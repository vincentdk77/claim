package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcompensatehouse;
import com.gyic.claim.resource.dtofactory.domain.DBPrplcompensateear;
import com.sinosoft.claim.bl.facade.BLPrpLclaimStatusFacade;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.InderectFeeDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLcomRepairBillDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLdeductCondDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCengage;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpClimit;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDlimit;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciPerson;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcfee;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcfeecoins;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcharge;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaim;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcomRepairBill;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcompensate;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLctext;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLdeductCond;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLdeductible;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLhospitalizationPayFee;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinjuryPerson;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLloss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLltext;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLnodutyLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLqualityCheck;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistExt;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdParty;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcompensatehouse;
import com.sinosoft.reins.out.dto.domain.PrpLdangerItemDto;
import com.sinosoft.reins.out.resource.dtofactory.domain.DBPrpLdangerItem;
import com.sinosoft.reins.out.resource.dtofactory.domain.DBPrpLdangerTot;
import com.sinosoft.reins.out.resource.dtofactory.domain.DBPrpLdangerUnit;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * ʵ�����ݿ�������
 * <p>
 * Title: ��������ʵ�����ݹ���
 * </p>
 * <p>
 * Description: ��������ʵ�����ݹ���
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
public class DBCompensate {

    /**
     * ���캯��
     * 
     * @param dbManager ��Դ������
     */
    public DBCompensate() {

    }
    private static Log logger = LogFactory.getLog(DBCompensate.class);


    /**
     * ʵ�Ᵽ�淽��
     * 
     * @param compensateDto ʵ�����
     * @throws SQLException
     * @throws Exception
     * @return ��
     */
    public void insert(DBManager dbManager, CompensateDto compensateDto) throws SQLException, Exception {
        if (compensateDto.getPrpLcompensateDto() == null) {
            throw new Exception();
        }
        //����ɾ��ԭ�����������
        deleteSubInfo(dbManager, compensateDto);
        new DBPrpLcompensate(dbManager).insert(compensateDto.getPrpLcompensateDto());

        if (compensateDto.getPrpLchargeDtoList() != null && compensateDto.getPrpLchargeDtoList().size()>0) {
            new DBPrpLcharge(dbManager).insertAll(compensateDto.getPrpLchargeDtoList());
        }
        
        //add by miaowenjun 20060607
        if(compensateDto.getPrpLcompensateDto().getPrpLdeductCondDtoList() != null){
        	for (int i = 0; i < compensateDto.getPrpLcompensateDto().getPrpLdeductCondDtoList().size(); i++) {
        		((PrpLdeductCondDto) compensateDto.getPrpLcompensateDto()
						.getPrpLdeductCondDtoList().get(i))
						.setCompensateNo(compensateDto.getPrpLcompensateDto()
								.getCompensateNo());
			}
        	new DBPrpLdeductCond(dbManager).insertAll(compensateDto.getPrpLcompensateDto().getPrpLdeductCondDtoList());
        }
  
        //add by qinyongli start 2005-8-19
        //���Ӷ�����Ϣ
        if(compensateDto.getPrpLcompensateeartDtoList()!=null){
        	new DBPrplcompensateear(dbManager).insertAll(compensateDto.getPrpLcompensateeartDtoList());
        }
        
        if(compensateDto.getPrplCompensateHouseDtoList()!=null && compensateDto.getPrplCompensateHouseDtoList().size() > 0){
        	PrplcompensatehouseDto PrplcompensatehouseDto = (PrplcompensatehouseDto)compensateDto.getPrplCompensateHouseDtoList().get(0);
			String registno = PrplcompensatehouseDto.getRegistno();
			String nodetype = PrplcompensatehouseDto.getNodetype();
			String businessno = PrplcompensatehouseDto.getBusinessno();
			String compensateno = PrplcompensatehouseDto.getCompensateno();
			String condition = " registno='" + registno + "' and nodetype='" + nodetype + "' and businessno='" + businessno + "' and COMPENSATENO='" + compensateno + "' ";
			new DBPrplcompensatehouse(dbManager).deleteByConditions(condition);
        	new DBPrplcompensatehouse(dbManager).insertAll(compensateDto.getPrplCompensateHouseDtoList());
        }
        
        
        //reason:����Σ�յ�λ
        if(compensateDto.getPrplRiskUnitDtoList()!=null){
        	new DBPrpLdangerUnit(dbManager).insertAll(compensateDto.getPrplRiskUnitDtoList());
        }
        if(compensateDto.getPrpLprpLdangerTotList()!=null){
        	new DBPrpLdangerTot(dbManager).insertAll(compensateDto.getPrpLprpLdangerTotList());
        }
        if(compensateDto.getPrpLprpLdangerItemList()!=null){
        	 Iterator i = compensateDto.getPrpLprpLdangerItemList().iterator();
             while(i.hasNext()){
             	PrpLdangerItemDto dangerItemAll1 =(PrpLdangerItemDto) i.next();
             }
        	new DBPrpLdangerItem(dbManager).insertAll(compensateDto.getPrpLprpLdangerItemList());
        }
        //add by qinyongli end 2005-8-19
        if (compensateDto.getPrpLlossDtoList() != null) {
            new DBPrpLloss(dbManager).insertAll(compensateDto.getPrpLlossDtoList());
        }
        
        if(compensateDto.getPrpLhospitalizationPayFeeDtoList() != null){
        	new DBPrpLhospitalizationPayFee(dbManager).insertAll(compensateDto.getPrpLhospitalizationPayFeeDtoList());
        }

        if (compensateDto.getPrpLpersonLossDtoList() != null) {
            new DBPrpLpersonLoss(dbManager).insertAll(compensateDto.getPrpLpersonLossDtoList());
        }
       
        if (compensateDto.getPrpLctextDtoDtoList() != null) {
            new DBPrpLctext(dbManager).insertAll(compensateDto.getPrpLctextDtoDtoList());
        }
        
        if (compensateDto.getPrpLqualityCheckList() != null) {
            new DBPrpLqualityCheck(dbManager).insertAll(compensateDto.getPrpLqualityCheckList());
        }
        //��չ��Ϣ
        if (compensateDto.getPrpLregistExtDtoList() != null) {
            new DBPrpLregistExt(dbManager).insertAll(compensateDto.getPrpLregistExtDtoList());
        }
        if (compensateDto.getPrpLcfeeDtoList() != null) {
            new DBPrpLcfee(dbManager).insertAll(compensateDto.getPrpLcfeeDtoList());
        }
        
        if (compensateDto.getPrpLltextDtoList() != null) {
            new DBPrpLltext(dbManager).insertAll(compensateDto.getPrpLltextDtoList());
        }
        if (compensateDto.getPrpLacciPersonDtoList() != null) {
        	for (int i =0; i < compensateDto.getPrpLacciPersonDtoList().size(); i++) {
        	 new DBPrpLacciPerson(dbManager).updateFlag((PrpLacciPersonDto)compensateDto.getPrpLacciPersonDtoList().get(i));	
        	}
            
        }

        if(compensateDto.getPrpLinjuryPersonList()!=null&&compensateDto.getPrpLinjuryPersonList().size()>0){
        	new DBPrpLinjuryPerson(dbManager).insertAll(compensateDto.getPrpLinjuryPersonList());
        }

        //add by chenrd begin 20070719
        //reason:ũ���ŵ�����
        if(compensateDto.getPrpLagriPersonDtoList()!=null){
        	new DBPrpLacciPerson(dbManager).insertAll(compensateDto.getPrpLagriPersonDtoList());
        }
        //add by chenrd end 20070719
        
        if(compensateDto.getPrpLnodutyLossDtoList() != null){
        	new DBPrpLnodutyLoss(dbManager).insertAll(compensateDto.getPrpLnodutyLossDtoList());
        }
        
        //add ������Ϣ
        
        if(compensateDto.getPrpLdeductibleList() != null){
        	
        	new DBPrpLdeductible(dbManager).insertAll(compensateDto.getPrpLdeductibleList());
        	
        }
        
        //add �¹�����Ϣ
        
        if(compensateDto.getPrpLacciBenPersonList()!=null){
      	  
         new DBPrpLacciPerson(dbManager).deleteAll(compensateDto.getPrpLacciBenPersonList()) ;
	
       	 new DBPrpLacciPerson(dbManager).insertAll(compensateDto.getPrpLacciBenPersonList()) ;
         }
        //ά�޷�Ʊ��Ϣ
        if(compensateDto.getPrpLcomRepairBillDtoList() != null){
        	
        	new DBPrpLcomRepairBill(dbManager).insertAll(compensateDto.getPrpLcomRepairBillDtoList());
        	
        }
        //������Ϣ
        if(compensateDto.getPrpLthirdPartyDtoList() != null){
        	new DBPrpLthirdParty(dbManager).insertAll(compensateDto.getPrpLthirdPartyDtoList());
        }
        
        //����״̬�ĸı�
        updateClaimStatus(dbManager, compensateDto);
        //������Ϣ
        if(compensateDto.getPrpLcfeecoinsList() != null){
        	new DBPrpLcfeecoins(dbManager).insertAll(compensateDto.getPrpLcfeecoinsList());
        }
        

    }
    /**
     * ʵ�Ᵽ�淽��
     * 
     * @param compensateDto ʵ�����
     * @throws SQLException
     * @throws Exception
     * @return ��
     */
    public void insert(DBManager dbManager, PrpLcompensateDto compensateDto) throws SQLException, Exception {
        
        //����״̬�ĸı�
        updateClaimStatus(dbManager, compensateDto);

    }
    
   

    /**
     * ���ʵ��Ĳ���״̬�ķ���
     * 
     * @param compensateDto ��������
     * @throws SQLException
     * @throws Exception
     * @return ��
     */
    public void updateClaimStatus(DBManager dbManager, CompensateDto compensateDto) throws SQLException, Exception {
        //ʾ��δ���
        String statement = "";

        if (compensateDto.getPrpLclaimStatusDto() != null) {
            String condition3 = " BusinessNo='"
                    + StringUtils.rightTrim(compensateDto.getPrpLclaimStatusDto().getBusinessNo()) + "' "
                    + " AND NodeType ='" + compensateDto.getPrpLclaimStatusDto().getNodeType() + "' and TypeFlag='"
                    + compensateDto.getPrpLclaimStatusDto().getTypeFlag().trim() + "'";
            //ΪʲôҪ��typeflag?
            // String condition3 = " BusinessNo='" +
            // StringUtils.rightTrim(compensateDto.getPrpLclaimStatusDto().getBusinessNo()) + "' "
            //                  + " AND NodeType ='"+compensateDto.getPrpLclaimStatusDto().getNodeType()+"'";

            statement = " DELETE FROM prpLclaimStatus Where " + condition3;
            dbManager.executeUpdate(statement);
            new DBPrpLclaimStatus(dbManager).insert(compensateDto.getPrpLclaimStatusDto());
            
        }
    }
    /**
     * ���ʵ��Ĳ���״̬�ķ���
     * 
     * @param compensateDto ��������
     * @throws SQLException
     * @throws Exception
     * @return ��
     */
    public void updateClaimStatus(DBManager dbManager, PrpLcompensateDto compensateDto) throws SQLException, Exception {
        //ʾ��δ���
        String statement = "";

        BLPrpLclaimStatusFacade claimStatusFacade=new BLPrpLclaimStatusFacade();
        PrpLclaimStatusDto  claimStatusDto=new PrpLclaimStatusDto();
        claimStatusDto=claimStatusFacade.findByPrimaryKey(compensateDto.getCompensateNo(), "compe", 0);
        if (claimStatusDto!= null) {
            String condition3 = " BusinessNo='"
                    + compensateDto.getCompensateNo() + "' "
                    + " AND NodeType ='compe' and TypeFlag='2'";
            //ΪʲôҪ��typeflag?
            // String condition3 = " BusinessNo='" +
            // StringUtils.rightTrim(compensateDto.getPrpLclaimStatusDto().getBusinessNo()) + "' "
            //                  + " AND NodeType ='"+compensateDto.getPrpLclaimStatusDto().getNodeType()+"'";

            statement = "  update prpLclaimStatus set status ='4' Where " + condition3;
            dbManager.executeUpdate(statement);
            
        }
    }
    /**
     * ɾ��������
     * @param dbManager 
     * @param compensateNo    �������  
     * @throws SQLException
     * @throws Exception
     */
    public void delete(DBManager dbManager, String compensateNo) throws SQLException, Exception {
        String condition = " compensateNo = '" + StringUtils.rightTrim(compensateNo) + "'";
        try{
        	dbManager.beginTransaction();
        	String  statement = " DELETE FROM prpLcfee Where " + condition;
            dbManager.executeUpdate(statement);
            statement = " DELETE FROM prpLctext Where " + condition;
            dbManager.executeUpdate(statement);
            statement = " DELETE FROM prpLcharge Where " + condition;
            dbManager.executeUpdate(statement);
            statement = " DELETE FROM prpLloss Where " + condition;
            dbManager.executeUpdate(statement);
            statement = " DELETE FROM prpLpersonLoss Where " + condition;
            dbManager.executeUpdate(statement);
            statement = " Delete from PrpLnodutyloss  where " +condition;
            dbManager.executeUpdate(statement);
            statement = " Delete from prplcomrepairbill  where " +condition;
            dbManager.executeUpdate(statement);
            statement = " DELETE FROM prpLcompensate Where " + condition;
            dbManager.executeUpdate(statement);
            
            condition = " businessno = '" + StringUtils.rightTrim(compensateNo) + "'";
            statement = " delete  from swfpathlog where flowid in (select flowid from swflog where  "+condition+" and swfpathlog.endnodeno =swflog.logno)";
            dbManager.executeUpdate(statement); 
            statement = "update swflog set NodeStatus = '0' where businessno in (select distinct keyin FROM swflog Where "+condition+") and nodeType = 'compe' and logno in (select max(logno) from swflog where businessno in (select distinct keyin FROM swflog Where "+condition+") and nodeType = 'compe')";
            dbManager.executeUpdate(statement);
            statement = " DELETE FROM swflog Where " + condition ;
            dbManager.executeUpdate(statement); 
            statement = " DELETE FROM prplclaimstatus Where " + condition ;
            dbManager.executeUpdate(statement);
            dbManager.commitTransaction();
        }catch(SQLException sql){
        	throw sql;	
        }catch(Exception e){
        	throw e;
        }finally{
        	
        }

    }


    
    /**
     * ʵ��ɾ��,ɾ��һ�����������м�����
     * 
     * @param fcoCompensateNoticeNo
     * @throws SQLException
     * @throws Exception
     */
    public void deleteByClaimNo(DBManager dbManager, String claimNo) throws SQLException, Exception {
    	  String condition  = " compensateNo in (select compensateNo from prpLcompensate Where claimNo='"+claimNo+ "')";
    	  String condition1 = " businessno in (select compensateNo from prpLcompensate Where claimNo='"+claimNo+ "')";
      	  String condition2 = " registno in (select compensateNo from prpLcompensate Where claimNo='"+claimNo+ "')";
          
    	  //ʾ��δ���
        //1.8	ɾ�����㱨��������Ϣ
        String statement = "delete prplctext where "+condition +" and  textType = '1'";
        dbManager.executeUpdate(statement);
        //1.9	ɾ����Ա�⸶��Ϣ��
        statement = "delete prplpersonloss where "+condition;
        dbManager.executeUpdate(statement);
		//1.10	ɾ���⸶�����Ϣ��
        statement = "delete prplloss where "+condition;
        dbManager.executeUpdate(statement);
		//1.11	������Ϣ��
        statement = "delete prplcharge where "+condition;
        dbManager.executeUpdate(statement);
		//1.12	���������
        statement = "delete prplcfee where "+condition;
        dbManager.executeUpdate(statement);
		//1.13	�����������Ϣ
        //statement = "delete prplcfeecoins where "+condition1;
        //System.out.println( statement);
        //dbManager.executeUpdate(statement);
		//.14	ɾ�������������ݱ�����Ŀǰû�õ������ǣ������ݣ�
        statement = "delete PrpLqualityCheck where "+condition2;
        dbManager.executeUpdate(statement);
        //1.16 ɾ���������������
        statement = " DELETE FROM prplclaimstatus Where " + condition1 ;
        dbManager.executeUpdate(statement);
		//1.15	ɾ������������
        statement = "delete prplcompensate where claimNo='"+claimNo+ "'";
        dbManager.executeUpdate(statement);
		
    }
/*
     * ʵ���ѯ���� @param compensateDto ʵ����� @throws SQLException @throws Exception @return ��
     */
    public CompensateDto findByPrimaryKey(DBManager dbManager, String compensateNo) throws SQLException, Exception {
        String conditions = " CompensateNo = '" + compensateNo + "'";
        CompensateDto compensateDto = new CompensateDto();
        compensateDto.setPrpLcompensateDto(new DBPrpLcompensate(dbManager).findByPrimaryKey(compensateNo));
        compensateDto
                .setPrpLclaimStatusDto(new DBPrpLclaimStatus(dbManager).findByPrimaryKey(compensateNo, "compe", 0));
        compensateDto.setPrpLchargeDtoList((ArrayList) new DBPrpLcharge(dbManager).findByConditions(conditions, 0, 0));
        compensateDto.setPrpLctextDtoDtoList((ArrayList) new DBPrpLctext(dbManager).findByConditions(conditions, 0, 0));
        compensateDto.setPrpLlossDtoList((ArrayList) new DBPrpLloss(dbManager).findByConditions(conditions, 0, 0));
        compensateDto.setPrpLpersonLossDtoList((ArrayList) new DBPrpLpersonLoss(dbManager).findByConditions(conditions,
                0, 0));
        compensateDto.setPrpLcfeeDtoList((ArrayList) new DBPrpLcfee(dbManager).findByConditions(conditions, 0, 0));
        compensateDto.setPrpLhospitalizationPayFeeDtoList((ArrayList) new DBPrpLhospitalizationPayFee(dbManager).findByConditions(conditions, 0, 0));
        
        if (compensateDto.getPrpLcompensateDto() != null) {
            conditions = " policyNo = '" + compensateDto.getPrpLcompensateDto().getPolicyNo() + "'";
            compensateDto.setPrpCengageDtoList((ArrayList) new DBPrpCengage(dbManager).findByConditions(conditions, 0,
                    0));
            conditions = " riskCode = '" + compensateDto.getPrpLcompensateDto().getRiskCode() + "'";
            compensateDto
                    .setPrpDlimitDtoList((ArrayList) new DBPrpDlimit(dbManager).findByConditions(conditions, 0, 0));
            conditions = " policyNo = '" + compensateDto.getPrpLcompensateDto().getPolicyNo() + "'";
            compensateDto
                    .setPrpClimitDtoList((ArrayList) new DBPrpClimit(dbManager).findByConditions(conditions, 0, 0));
        }
        PrpLclaimDto prpLclaimDto = new DBPrpLclaim(dbManager).findByPrimaryKey(compensateDto.getPrpLcompensateDto()
                .getClaimNo());
        
        compensateDto.setPrpLclaimDto(prpLclaimDto);

        conditions = " registNo = '" + prpLclaimDto.getRegistNo() + "'";
        compensateDto.setPrpLregistExtDtoList((ArrayList) new DBPrpLregistExt(dbManager).findByConditions(conditions,
                0, 0));
        
        conditions = " certino = '" + compensateNo + "' and CertiType = '04' ";
        compensateDto.setPrpLagriPersonDtoList((ArrayList) new DBPrpLacciPerson(dbManager).findByConditions(conditions));
        
        conditions = " CompensateNo = '" + compensateNo + "'";
        compensateDto.setPrpLnodutyLossDtoList((ArrayList) new DBPrpLnodutyLoss(dbManager).findByConditions(conditions));
        
        return compensateDto;
    }
    
 //add by lym  for InderectFee group by kindCode-------------Start
    /*
     * ���ձ��ѯ���������� @param compensateNo 
     */
    public Collection findByCompensateNo(DBManager dbManager,
			String compensateNo) throws Exception {
		StringBuffer buffer = new StringBuffer(500);
		// ƴSQL���
		buffer.append("select compensateno,kindcode,round(sum(sumrealpay)*0.025,2) from ");
		buffer.append("( select compensateno,kindcode,sumrealpay from prplloss where compensateno='");
		buffer.append(compensateNo);
		buffer.append("' union all select compensateno,kindcode,sumrealpay from prplpersonloss where compensateno='");
		buffer.append(compensateNo);
		buffer.append("' union all select compensateno,kindcode,chargeamount as sumrealpay from prplcharge where chargecode!='28' and compensateno='");
		buffer.append(compensateNo);
		buffer.append("') group by compensateno,kindcode ");
		if (logger.isDebugEnabled()) {
			logger.debug(buffer.toString());
		}
		ResultSet resultSet = dbManager.executeQuery(buffer.toString());
		
		// ���巵�ؽ������
		Collection collection = new ArrayList();
		InderectFeeDto inderectFeeDto = null;
		while (resultSet.next()) {
			inderectFeeDto = new InderectFeeDto();
			inderectFeeDto.setCompensateNo(dbManager.getString(resultSet, 1));
			inderectFeeDto.setKindCode(dbManager.getString(resultSet, 2));
			inderectFeeDto.setChargeAmount(dbManager.getDouble(resultSet, 3));
			collection.add(inderectFeeDto);
		}
		resultSet.close();
		return collection;
   }
 
//add by lym  for InderectFee group by kindCode-------------end  
    
    /*
     * ʵ���ѯ���� @param compensateDto ʵ����� @throws SQLException @throws Exception @return ��
     */
    public CompensateDto findByPrimaryKey(DBManager dbManager, String compensateNo, String caseType)
            throws SQLException, Exception {
        
        String conditions = " CompensateNo = '" + compensateNo + "'";
        CompensateDto compensateDto = new CompensateDto();
        compensateDto.setPrpLcompensateDto(new DBPrpLcompensate(dbManager).findByPrimaryKey(compensateNo));
        //�����ⰸ��־
        if (caseType != null) {
            if (caseType.trim().equals("3") || caseType.trim().equals("4")) {
                compensateDto.setPrpLclaimStatusDto(new DBPrpLclaimStatus(dbManager).findByPrimaryKey(compensateNo,
                        "speci", Integer.parseInt(DataUtils.nullToZero(caseType))));
            } else {
                compensateDto.setPrpLclaimStatusDto(new DBPrpLclaimStatus(dbManager).findByPrimaryKey(compensateNo,
                        "compe", 0));
            }
        } else {
            compensateDto.setPrpLclaimStatusDto(new DBPrpLclaimStatus(dbManager).findByPrimaryKey(compensateNo,
                    "compe", 0));
        }
        
        compensateDto.setPrpLchargeDtoList((ArrayList) new DBPrpLcharge(dbManager).findByConditions(conditions, 0, 0));
        compensateDto.setPrpLctextDtoDtoList((ArrayList) new DBPrpLctext(dbManager).findByConditions(conditions, 0, 0));
        compensateDto.setPrpLlossDtoList((ArrayList) new DBPrpLloss(dbManager).findByConditions(conditions, 0, 0));
        compensateDto.setPrpLpersonLossDtoList((ArrayList) new DBPrpLpersonLoss(dbManager).findByConditions(conditions,
                0, 0));
        compensateDto.setPrpLcfeeDtoList((ArrayList) new DBPrpLcfee(dbManager).findByConditions(conditions, 0, 0));
        if (compensateDto.getPrpLcompensateDto() != null) {
            conditions = " policyNo = '" + compensateDto.getPrpLcompensateDto().getPolicyNo() + "'";
            compensateDto.setPrpCengageDtoList((ArrayList) new DBPrpCengage(dbManager).findByConditions(conditions, 0,
                    0));
            conditions = " riskCode = '" + compensateDto.getPrpLcompensateDto().getRiskCode() + "'";
            compensateDto
                    .setPrpDlimitDtoList((ArrayList) new DBPrpDlimit(dbManager).findByConditions(conditions, 0, 0));
            conditions = " policyNo = '" + compensateDto.getPrpLcompensateDto().getPolicyNo() + "'";
            compensateDto
                    .setPrpClimitDtoList((ArrayList) new DBPrpClimit(dbManager).findByConditions(conditions, 0, 0));
        }
        conditions = " registNo = '" + compensateNo + "' and QualityCheckType='compe'";
        compensateDto.setPrpLqualityCheckList((ArrayList) new DBPrpLqualityCheck(dbManager).findByConditions(
                conditions, 0, 0));
        
        PrpLclaimDto prpLclaimDto = new DBPrpLclaim(dbManager).findByPrimaryKey(compensateDto.getPrpLcompensateDto()
                .getClaimNo());
        
        conditions = " registNo = '" + prpLclaimDto.getRegistNo() + "'";
        compensateDto.setPrpLregistExtDtoList((ArrayList) new DBPrpLregistExt(dbManager).findByConditions(conditions,
                0, 0));
        compensateDto.setPrpLthirdPartyDtoList((ArrayList) new DBPrpLthirdParty(dbManager).findByConditions(conditions,0,0));
        
        conditions = " claimNo = '" + prpLclaimDto.getClaimNo() + "'";
        compensateDto.setPrpLltextDtoList((ArrayList) new DBPrpLltext(dbManager).findByConditions(conditions, 0, 0));
        
        //���ܴ�����ʷ����
        conditions = " certiNo = '" + prpLclaimDto.getClaimNo()+ "' and Flag='1' ";
        compensateDto.setPrpLacciPersonDtoList((ArrayList) new DBPrpLacciPerson(dbManager).findByConditions(conditions));
        if("27".equals(prpLclaimDto.getClassCode()) || "26".equals(prpLclaimDto.getClassCode()) || "28".equals(prpLclaimDto.getClassCode())){
            conditions = "certino='"+prpLclaimDto.getRegistNo()+"'";

        }else{
        	conditions = "certino='"+compensateNo+"' and CertiType = '04'";
        }
        compensateDto.setPrpLagriPersonDtoList((ArrayList) new DBPrpLacciPerson(dbManager).findByConditions(conditions));
        compensateDto.setPrpLclaimDto(prpLclaimDto);
        
        //add by qinyongli 2006-01-12 ��������������Ϣ
        conditions = " CompensateNo = '" + compensateNo + "'";
        compensateDto.setPrpLdeductibleList((ArrayList) new DBPrpLdeductible(dbManager).findByConditions(conditions, 0, 0));
        compensateDto.setPrpLnodutyLossDtoList((ArrayList) new DBPrpLnodutyLoss(dbManager).findByConditions(conditions));
        compensateDto.setPrpLcomRepairBillDtoList((ArrayList) new DBPrpLcomRepairBill(dbManager).findByConditions(conditions));
        compensateDto.setPrpLcompensateeartDtoList((ArrayList)new DBPrplcompensateear(dbManager).findByConditions(conditions));
        //������Ϣ���ܴ����������
        conditions = " businessno = '" + compensateNo + "' and lossfeetype <> 'L' ";
        compensateDto.setPrpLcfeecoinsList((ArrayList)new DBPrpLcfeecoins(dbManager).findByConditions(conditions));
        return compensateDto;
    }

    /**
     * ʵ��ɾ���ӱ���Ϣ
     * 
     * @param compensateNo
     * @throws SQLException
     * @throws Exception
     */
    private void deleteSubInfo(DBManager dbManager, CompensateDto compensateDto) throws SQLException, Exception {
        String compensateNo = compensateDto.getPrpLcompensateDto().getCompensateNo();
        String condition = " compensateNo = '" + StringUtils.rightTrim(compensateNo) + "'";
        
        String statement = ""; //ʾ��δ���
        statement = " DELETE FROM prplcompensateear Where " + condition;
        dbManager.executeUpdate(statement);
        
        statement = " DELETE FROM prpLctext Where " + condition;
        dbManager.executeUpdate(statement);
        
        statement = " DELETE FROM prpLcharge Where " + condition;
        dbManager.executeUpdate(statement);
        
        statement = "DELETE FROM prpLnodutyLoss where " + condition;
        dbManager.executeUpdate(statement);
        
        //add by miaowenjun 20060607 �������������Ϣ
        statement = " DELETE FROM prpldeductcond Where " + condition;
        dbManager.executeUpdate(statement);
        //add by qinyongli start 2005-8-19 
        //reason:����Σ�յ�λ
        String  conditions =" certino = '" + StringUtils.rightTrim(compensateNo) + "'";
        statement = " DELETE FROM prpldangertot Where " + conditions;
        dbManager.executeUpdate(statement);
        
        //add by qinyongli start 2006-1-11 
        //reason:�������������
        statement = " DELETE FROM PrpLdeductible Where " + condition;
        dbManager.executeUpdate(statement);
        //add by qinyongli end 2006-1-11
		
        statement = " DELETE FROM prpldangeritem Where " + conditions;
        dbManager.executeUpdate(statement);
        
        statement = " DELETE FROM prpldangerunit Where " + conditions;
        dbManager.executeUpdate(statement);
        //add by qinyongli end 2005-8-19 
        
        statement = " DELETE FROM prpLpersonLoss Where " + condition;
        dbManager.executeUpdate(statement);

        statement = " DELETE FROM prpLloss Where " + condition;
        dbManager.executeUpdate(statement);

        statement = " DELETE FROM prpLcfee Where " + condition;
        dbManager.executeUpdate(statement);

        statement = " DELETE FROM prpLcfeecoins Where businessno = '"+compensateNo+"' "  ; 
        dbManager.executeUpdate(statement);
        statement = " DELETE FROM PrpLhospitalizationPayFee Where " + condition;
        dbManager.executeUpdate(statement);
        
        statement = " DELETE FROM prplcomrepairbill Where " + condition;
        dbManager.executeUpdate(statement);
        
        statement = " DELETE FROM prpLcompensate Where " + condition;
        dbManager.executeUpdate(statement);

        statement = " DELETE FROM prplcfee Where " + condition;
        dbManager.executeUpdate(statement);
        
        statement = " DELETE FROM prplinjuryperson Where " + condition;
        dbManager.executeUpdate(statement);

        condition = " registNo = '" + compensateNo + "' and QualityCheckType='compe'";
        statement = " DELETE FROM PrpLqualityCheck Where " + condition;
        dbManager.executeUpdate(statement);

        PrpLclaimDto prpLclaimDto = new DBPrpLclaim(dbManager).findByPrimaryKey(compensateDto.getPrpLcompensateDto()
                .getClaimNo());

        condition = " registNo = " + "'" + prpLclaimDto.getRegistNo() + "'";
        //ɾ����չ��Ϣ
        statement = " DELETE FROM PrpLregistExt Where " + condition;
        dbManager.executeUpdate(statement);

        condition = " ClaimNo = '" + prpLclaimDto.getClaimNo() + "' AND TextType = '08'";
        statement = " DELETE FROM PrpLlText Where " + condition;
        dbManager.executeUpdate(statement);
        
        
        
        //ɾ���⸶����������Ϣ
        String strCondition = " certino = '" + StringUtils.rightTrim(compensateNo) + "' and CertiType = '04'";
        statement = " DELETE FROM  PrpLacciPerson Where " + strCondition;
        dbManager.executeUpdate(statement);
        
        //ɾ�����߳�����Ϣ
        strCondition = "registNo = '"+prpLclaimDto.getRegistNo() + "' and Flag='1' ";
        statement = "DELETE FROM PrpLthirdParty Where " + strCondition;
        dbManager.executeUpdate(statement);

    }

    /*
     * ��ѯ�ر�Լ��,�⳥�޶�/�������Ϣ @param PrpLcompensateDto �������� @throws SQLException @throws Exception @return ��
     */
    public CompensateDto findByAppendInformation(DBManager dbManager, CompensateDto compensateDto) throws SQLException,
            Exception {
        //CompensateDto compensateDto = null;
        String conditions = "";
        if (compensateDto.getPrpLcompensateDto() != null) {
            conditions = " policyNo = '" + compensateDto.getPrpLcompensateDto().getPolicyNo() + "'";
            compensateDto.setPrpCengageDtoList((ArrayList) new DBPrpCengage(dbManager).findByConditions(conditions, 0,
                    0));
            conditions = " riskCode = '" + compensateDto.getPrpLcompensateDto().getRiskCode() + "'";
            compensateDto
                    .setPrpDlimitDtoList((ArrayList) new DBPrpDlimit(dbManager).findByConditions(conditions, 0, 0));
            conditions = " policyNo = '" + compensateDto.getPrpLcompensateDto().getPolicyNo() + "'";
            compensateDto
                    .setPrpClimitDtoList((ArrayList) new DBPrpClimit(dbManager).findByConditions(conditions, 0, 0));

        }
        return compensateDto;
    }

    
    /**
     * ʵ���˻صķ���
     * 
     * @param compensateDto ʵ�����
     * @throws SQLException
     * @throws Exception
     * @return ��
     */
    public void backToCerta(DBManager dbManager, String claimNo,PrpLverifyLossDto prpLverifyLossDto) throws SQLException, Exception {
        String conditions ="claimNo='"+claimNo+"'";
        String statement="";
        String registNo=new DBPrpLclaim(dbManager).translateCode(claimNo, false);//������
       
        //����м����飬ɾ����������Ϣ
   		DBPrpLcompensate dbPrpLcompensate= new DBPrpLcompensate(dbManager);
   			conditions = SqlUtils.getWherePartForGetCount(conditions);
    	int count = dbPrpLcompensate.getCount(conditions);
    	if (count>0){
    		//ɾ����������Ϣ
    		if (count>1){
    		      throw new UserException(1,3,"1000","���Ի��˵����㣬�����鲻�ܳ���1��"); 
    		}
    		deleteByClaimNo(dbManager,claimNo);
    	}
    	//���Ϊ�״��˻�����Ҫ���û��˱��
    	conditions ="registNo='"+registNo+"' and CompensateFlag='1'";
    	DBPrpLverifyLoss dbPrpLverifyLoss= new DBPrpLverifyLoss(dbManager);
    		conditions = SqlUtils.getWherePartForGetCount(conditions);
    	count= dbPrpLverifyLoss.getCount(conditions);
    	if (count==0){
//    		���ö�����ϢΪ�״��ύ�����޸�
    	   statement = " Update PrpLcomponent set CompensateBackFlag='1'"   //[1]����
    	   	         +" Where registNo='" + registNo+"'";
           dbManager.executeUpdate(statement);
           
           statement = " Update PrpLrepairFee set CompensateBackFlag='1'"   //[2]����
           	         +" Where registNo='" + registNo+"'";
           dbManager.executeUpdate(statement);
           
           statement = " Update PrpLperson set CompensateBackFlag='1'"      //[3]����
           	         +" Where registNo='" + registNo+"'";
           dbManager.executeUpdate(statement);    
           statement = " Update PrpLprop set CompensateBackFlag='1'"        //[4]�Ʋ�
           	         +" Where registNo='" + registNo+"'";
           dbManager.executeUpdate(statement);    
    	        
    	}
    	statement = " Update prplverifyLoss set CompensateFlag='1',"
			+" CompensateOpinion='"+prpLverifyLossDto.getCompensateOpinion()+"',"
			+" CompensateBackDate='"+prpLverifyLossDto.getCompensateBackDate()+"',"
			+" CompensateApproverCode='"+prpLverifyLossDto.getCompensateApproverCode()+"' "
			+" Where registNo='" + registNo+"'";
    	dbManager.executeUpdate(statement);
       
    	//���������Ĺ켣��Ϣ
    	statement = " Update swfLog set nodeStatus='5'"
			+" Where flowId='" + prpLverifyLossDto.getFlowID()+"' and nodeType='compp' and nodestatus<'4'";
    	dbManager.executeUpdate(statement);
    }
    
    
    public Map getKindSumRealPayMap(DBManager dbManager,String compensateNo) throws Exception{
    	Map kindSumRealPayMap = new HashMap();
    	StringBuffer sb = new StringBuffer();
    	sb.append("Select kindcode,Sum(sumrealpay) sumrealpay");
    	sb.append(" From(");
    	sb.append("Select kindcode,Sum(sumrealpay) sumrealpay From prplloss Where compensateno =? Group By kindcode");
    	sb.append(" Union ");
    	sb.append("Select kindcode,Sum(sumrealpay) sumrealpay From prplpersonloss Where compensateno = ? Group By kindcode");
    	sb.append(" Union ");
    	sb.append("Select kindcode,Sum(sumrealpay) sumrealpay From prplcharge Where compensateno = ? Group By kindcode");
    	sb.append(")");
    	sb.append(" Group By kindcode");
    	
    	dbManager.prepareStatement(sb.toString());
    	dbManager.setString(1,compensateNo);
    	dbManager.setString(2,compensateNo);
    	dbManager.setString(3, compensateNo);
    	ResultSet resultSet = dbManager.executePreparedQuery();
    	String kindCode;
    	double sumrealpay;
    	while(resultSet.next()){
    		kindCode = dbManager.getString(resultSet,"kindCode");
    		sumrealpay = dbManager.getDouble(resultSet,"sumrealpay");
    		kindSumRealPayMap.put(kindCode,new Double(sumrealpay));
    	}
    	resultSet.close();
    	return kindSumRealPayMap;
    }
}
