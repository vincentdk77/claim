package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.EndcaseDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcaseNo;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaim;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcompensate;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLltext;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisitswflog;
import com.sinosoft.common_claim.bl.action.custom.BLCIClaimPropPlatFormInterfaceFacade;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utiall.blsvr.BLPrpDcompany;

/**
 * 结案数据库管理对象
 * <p>
 * Title: 车险理赔结案数据管理
 * </p>
 * <p>
 * Description: 车险理赔结案数据管理
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author liubvo
 * @version 1.0
 */
public class DBEndcase {
    private DBManager dbManager = null; //资源管理类

    /**
     * 构造函数
     * 
     * @param dbManager 资源管理类
     */
    public DBEndcase() {

    }

    /**
     * 结案保存方法
     * 
     * @param endcaseDto 结案对象
     * @throws SQLException
     * @throws Exception
     * @return 无
     */
    public void insert(DBManager dbManager, EndcaseDto endcaseDto) throws SQLException, Exception {

        String caseNo = ""; //赔案号
        String claimNo = ""; //赔案号
        String textType = "";
        
        caseNo = endcaseDto.getPrpLclaimDto().getCaseNo();
        claimNo = endcaseDto.getPrpLclaimDto().getClaimNo();

        //首先删除原来的相关数据
        if(!(endcaseDto.getPrpLclaimDto().getCancelDate().toString().equals(""))){
        	textType = "10";
        }
        //Modify by zhaolu 20060909 start
        else{
        	textType = "08";
        }
        //Modify by zhaolu 20060909 end  		
        deleteSubInfo(dbManager, caseNo, claimNo,textType);
        
        if(endcaseDto.getPrpLclaimDto().getFlag().equals("1")){
        	endcaseDto.getPrpLclaimDto().setFlag("");
            new DBPrpLclaim(dbManager).insert(endcaseDto.getPrpLclaimDto());
        }

        //插入陪案号表
        if (endcaseDto.getPrpLcaseNoDtoList() != null) {
            new DBPrpLcaseNo(dbManager).insertAll(endcaseDto.getPrpLcaseNoDtoList());
        }
        //插入文本信息表
        if (endcaseDto.getPrpLltextDtoList() != null) {
            new DBPrpLltext(dbManager).insertAll(endcaseDto.getPrpLltextDtoList());
        }
        //插入详细出险原因信息
        if(endcaseDto.getPrpLltextDtoList3() != null){
        	new DBPrpLltext(dbManager).insertAll(endcaseDto.getPrpLltextDtoList3());
        }
      //生成回访信息
        if(endcaseDto.getPrplreturnvisitswflogDto() != null){
        	new DBPrplreturnvisitswflog(dbManager).insert(endcaseDto.getPrplreturnvisitswflogDto());
             // new DBPrplreturnvisitswflog(dbManager).insert(endcaseDto.getPrplreturnvisitswflogDto());
        }
        //更新立案，赔款计算数，节点状态
        updateStatus(dbManager, endcaseDto);
        //
        //上海意健险平台结案接口交互begin
		boolean isYJXFlag = false;
		String groupFlag = "";
		String strPolicyNo = endcaseDto.getPrpLclaimDto().getPolicyNo();//获取保单号
		boolean isSuccess = false;
		if("26,27,28".indexOf(endcaseDto.getPrpLclaimDto().getRiskCode().substring(0,2)) > -1){
			isYJXFlag = true;
		}
		String upComCode = new BLPrpDcompany().getDaaPlatformComCode(endcaseDto.getPrpLclaimDto().getComCode());
		if(isYJXFlag && "310000".equals(upComCode)){
			System.out.println("------------------上海平台意健险结案接口调用,claimNo= " + endcaseDto.getPrpLclaimDto().getClaimNo() +" --------------------------");
			//根据保单号来查询保单信息,判断该保单是否为团单
			BLPrpCmain blPrpCmain = new BLPrpCmain();
			blPrpCmain.getData(strPolicyNo);	  			 
			//dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			//根据prpcmain.groupNo是否为空判断是否为团单
			if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
				groupFlag = "0";//个险
				isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C01", "03", endcaseDto.getPrpLclaimDto().getClaimNo(),strPolicyNo,groupFlag,upComCode);
			}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
				groupFlag = "1";//团险
				isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C04", "03", endcaseDto.getPrpLclaimDto().getClaimNo(),strPolicyNo,groupFlag,upComCode);
			} 			
		}
    }

    /**
     * 结案删除子表信息
     * 
     * @param fcoClaimNoticeNo
     * @throws SQLException
     * @throws Exception
     */
    private void deleteSubInfo(DBManager dbManager, String caseNo, String claimNo,String textType) throws SQLException, Exception {
        String condition1 = " claimno = " + "'" + claimNo.trim() + "'";
        String condition2 = " caseno = " + "'" + caseNo.trim() + "'";
        //示例未完成
        String statement = "";

        statement = " DELETE FROM prplltext Where " + condition1 + " and TextType = '" + textType + "'";
        System.out.println("test========SQL=" + statement);
        dbManager.executeUpdate(statement);
        statement = " DELETE FROM prplltext Where " + condition1 + " and TextType = '07'";
        System.out.println("test========SQL=" + statement);
        dbManager.executeUpdate(statement);
        statement = " DELETE FROM prplcaseno Where " + condition2;
        dbManager.executeUpdate(statement);
    }

    /**
     * 结案删除
     * 
     * @param caseNo
     * @throws SQLException
     * @throws Exception
     */
    public void delete(DBManager dbManager, String caseNo) throws SQLException, Exception {
        String condition = " caseNo = '" + StringUtils.rightTrim(caseNo) + "'";
        String condition3 = " BusinessNo='" + caseNo.trim() + "' " + " AND NodeType ='endca' ";
        //示例未完成
        String statement = " DELETE FROM prpLlText Where " + condition + " and TextType = '08'";
        dbManager.executeUpdate(statement);

        statement = " DELETE FROM prpLclaimStatus Where " + condition3;
        dbManager.executeUpdate(statement);

        statement = " DELETE FROM prpLcaseno Where " + condition;
        dbManager.executeUpdate(statement);
    }

    /*
     * 结案查询方法 @param endcaseDto 结案对象 @throws SQLException @throws Exception @return 无
     */
    public EndcaseDto findByPrimaryKey(DBManager dbManager, String caseNo, String claimNo, String certiNo,
            String certiType) throws SQLException, Exception {

        String conditions = " caseNo = '" + caseNo.trim() + "'";
        String condition2 = " claimNo = '" + claimNo.trim() + "'";
        String conditions1 = " claimNo = '" + claimNo.trim() + "' and TextType = '08' ";

        EndcaseDto endcaseDto = new EndcaseDto();
        endcaseDto.setPrpLcaseNoDtoList((ArrayList) new DBPrpLcaseNo(dbManager).findByConditions(conditions, 0, 0));
        endcaseDto.setPrpLltextDtoList((ArrayList) new DBPrpLltext(dbManager).findByConditions(conditions1, 0, 0));
        endcaseDto.setPrpLclaimStatusDto(new DBPrpLclaimStatus(dbManager).findByPrimaryKey(caseNo, "endca", 0));

        endcaseDto.setPrpLclaimDto(new DBPrpLclaim(dbManager).findByPrimaryKey(claimNo));
        endcaseDto.setPrpLcompensateDtoList((ArrayList) new DBPrpLcompensate(dbManager).findByConditions(condition2, 0,
                0));

        return endcaseDto;
    }

    /*
     * 结案查询方法 @param endcaseDto 结案对象 @throws SQLException @throws Exception @return 无
     */
    public EndcaseDto findByPrimaryKey(DBManager dbManager, String claimNo) throws SQLException, Exception {

        String conditions1 = " claimno = '" + claimNo.trim() + "'";
        String conditions2 = " claimNo = '" + claimNo.trim() + "'";
        String conditions3 = " claimNo = '" + claimNo.trim() + "' and TextType = '08' ";
        String conditions4 = " claimNo = '" + claimNo.trim() + "' and TextType = '06' ";
        
        EndcaseDto endcaseDto = new EndcaseDto();
        endcaseDto.setPrpLcaseNoDtoList((ArrayList) new DBPrpLcaseNo(dbManager).findByConditions(conditions1, 0, 0));
        endcaseDto.setPrpLltextDtoList((ArrayList) new DBPrpLltext(dbManager).findByConditions(conditions3, 0, 0));
        //endcaseDto.setPrpLclaimStatusDto(new DBPrpLclaimStatus(dbManager).findByPrimaryKey(caseNo,"endca",0));
        endcaseDto.setPrpLltextDtoList3((ArrayList)new DBPrpLltext(dbManager).findByConditions(conditions4, 0, 0));
        endcaseDto.setPrpLclaimDto(new DBPrpLclaim(dbManager).findByPrimaryKey(claimNo));
        endcaseDto.setPrpLcompensateDtoList((ArrayList) new DBPrpLcompensate(dbManager).findByConditions(conditions2,
                0, 0));
        return endcaseDto;
    }
    /**
     * 变更结案的操作状态的方法
     * 
     * @param endcaseDto 结案对象
     * @throws SQLException
     * @throws Exception
     * @return 无
     */
    public void updateStatus(DBManager dbManager, EndcaseDto endcaseDto) throws SQLException, Exception {

        //示例未完成
        String statement = "";
        //更新节点状态
        if (endcaseDto.getPrpLclaimStatusDto() != null) {
            String condition3 = " BusinessNo='" + endcaseDto.getPrpLclaimStatusDto().getBusinessNo().trim() + "' "
                    + " AND NodeType ='" + endcaseDto.getPrpLclaimStatusDto().getNodeType() + "'";
            statement = " DELETE FROM prpLclaimStatus Where " + condition3;
            dbManager.executeUpdate(statement);
            new DBPrpLclaimStatus(dbManager).insert(endcaseDto.getPrpLclaimStatusDto());
        }
        //更新立案表信息
        if (endcaseDto.getPrpLclaimDto() != null) {
            new DBPrpLclaim(dbManager).update(endcaseDto.getPrpLclaimDto());
        }
        //更新赔款计算书
        if (endcaseDto.getPrpLcompensateDtoList() != null) {
            for (int i = 0; i < endcaseDto.getPrpLcompensateDtoList().size(); i++) {
                PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto) (endcaseDto.getPrpLcompensateDtoList().get(i));
                new DBPrpLcompensate(dbManager).update(prpLcompensateDto);
            }
        }
       /* // 是重开赔案需更新prplrecase表
        if (endcaseDto.getPrpLrecaseDto()!= null) {
        	 new DBPrpLrecase(dbManager).update(endcaseDto.getPrpLrecaseDto());
            
         }
        System.out.println("更新重开赔案表---------OK");*/ 
        
    }

}