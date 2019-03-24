package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.gyic.claim.bl.facade.BLSettlemainlistFacade;
import com.gyic.claim.bl.facade.BLSettlemainlistFacadeForMedical;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.gyic.claim.resource.dtofactory.domain.DBPrplcompensateear;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.RegistClaimInfoDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLthirdCarLossDto;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCengage;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCmain;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLRegistRPolicy;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciPerson;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaim;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimFee;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcompensate;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLdoc;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLdriver;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLext;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLltext;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLperson;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonTrace;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpreCharge;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLprepay;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregist;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistExt;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdCarLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdParty;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdProp;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcompensatehouse;
import com.sinosoft.reins.out.resource.dtofactory.domain.DBPrpLdangerItem;
import com.sinosoft.reins.out.resource.dtofactory.domain.DBPrpLdangerTot;
import com.sinosoft.reins.out.resource.dtofactory.domain.DBPrpLdangerUnit;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.SysConfig;

/**
 * 立案数据库管理对象
 * <p>Title: 车险理赔立案数据管理</p>
 * <p>Description: 车险理赔立案数据管理</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lijiyuan
 * @version 1.0
 */
public class DBClaim
{
  private DBManager dbManager = null; //资源管理类

  /**
   * 构造函数
   * @param dbManager 资源管理类
   */
  public DBClaim()
  {

  }

  /**
   * 立案保存方法
   *@param claimDto 立案对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void insert(DBManager dbManager,ClaimDto claimDto)
    throws SQLException,Exception
  {
    if (claimDto.getPrpLclaimDto() ==null)
    {
             throw new Exception();
    }
    String claimNo="";
    String registNo="";
    String policyNo="";
    
    claimNo= claimDto.getPrpLclaimDto().getClaimNo();
    registNo = claimDto.getPrpLclaimDto().getRegistNo();
    policyNo = claimDto.getPrpLclaimDto().getPolicyNo();
    String textType="";
    
    if(claimDto.getPrpLltextDtoList()!=null&&((PrpLltextDto)claimDto.getPrpLltextDtoList().get(0)).getTextType().equals("10" ))
    {
    	//是注销拒赔保存，应该做cancelsave()
    	//(PrpLltextDto)claimDto.getPrpLltextDtoList().get( 0)).get
    	saveCancel(dbManager, claimDto);
    	return;
    }
    //首先删除原来的相关数据
    deleteSubInfo(dbManager,claimNo,registNo);
    
    
   
    new DBPrpLclaim(dbManager).insert(claimDto.getPrpLclaimDto());
    
    
    if(claimDto.getPrpLcompensateeartDtoList()!=null){
    	new DBPrplcompensateear(dbManager).insertAll(claimDto.getPrpLcompensateeartDtoList());
    }
   
    
	if (claimDto.getPrplCompensateHouseDtoList()!= null && claimDto.getPrplCompensateHouseDtoList().size() > 0) {
		PrplcompensatehouseDto PrplcompensatehouseDto = (PrplcompensatehouseDto)claimDto.getPrplCompensateHouseDtoList().get(0);
		String registno = PrplcompensatehouseDto.getRegistno();
		String nodetype = PrplcompensatehouseDto.getNodetype();
		String condition = " registno='" + registno + "' and nodetype='" + nodetype + "'";
		new DBPrplcompensatehouse(dbManager).deleteByConditions(condition);
		new DBPrplcompensatehouse(dbManager).insertAll(claimDto.getPrplCompensateHouseDtoList());
	}
    //add by lym  20060609  for 强三----start 
    if(claimDto.getPrpLRegistRPolicyDto()!=null)
    {
    	new DBPrpLRegistRPolicy(dbManager).update(claimDto.getPrpLRegistRPolicyDto());
    }
    //add by lym  20060609  for 强三----end 
    
    if(claimDto.getPrpLpersonDtoList()!=null)
    {
    	new DBPrpLperson(dbManager).insertAll(claimDto.getPrpLpersonDtoList());
    }
    
    if(claimDto.getPrpLthirdPartyDtoList()!=null)
    {
       new DBPrpLthirdParty(dbManager).insertAll(claimDto.getPrpLthirdPartyDtoList());
    }
    if(claimDto.getPrpLthirdCarLossDtoList()!=null)
    {
      new DBPrpLthirdCarLoss(dbManager).insertAll(claimDto.getPrpLthirdCarLossDtoList());
    }

    if(claimDto.getPrpLthirdPropDtoList()!=null)
    {
      new DBPrpLthirdProp(dbManager).insertAll(claimDto.getPrpLthirdPropDtoList());
    }

    if(claimDto.getPrpLdriverDtoList()!=null)
    {
       new DBPrpLdriver(dbManager).insertAll(claimDto.getPrpLdriverDtoList());
    }
    if(claimDto.getPrpLltextDtoList()!=null)
    {
       new DBPrpLltext(dbManager).insertAll(claimDto.getPrpLltextDtoList());
    }
    if(claimDto.getPrpLltextDtoList3() != null){
    	new DBPrpLltext(dbManager).insertAll(claimDto.getPrpLltextDtoList3());
    }
    if(claimDto.getPrpLclaimLossDtoList()!=null)
    {
       new DBPrpLclaimLoss(dbManager).insertAll(claimDto.getPrpLclaimLossDtoList());
    }
    if(claimDto.getPrpLclaimFeeDtoList()!=null)
    {
       new DBPrpLclaimFee(dbManager).insertAll(claimDto.getPrpLclaimFeeDtoList());
    }
    if(claimDto.getPrpLdocDtoList()!=null)
    {
       new DBPrpLdoc(dbManager).insertAll(claimDto.getPrpLdocDtoList());
    } 
    //立案环节增加危险单位划分表处理 2011-01-14
    if(claimDto.getPrpLRiskUnitDtoList()!=null){
       new DBPrpLdangerUnit(dbManager).insertAll(claimDto.getPrpLRiskUnitDtoList());
    }
    //立案环节增加危险单位信息表处理 2011-01-14
    if(claimDto.getPrpLdangerItemDtoList()!=null){
       new DBPrpLdangerItem(dbManager).insertAll(claimDto.getPrpLdangerItemDtoList());
    }
    //立案环节增加危险单位金额合计信息表处理 2011-01-14
    if(claimDto.getPrpLdangerTotDtoList()!=null){
       new DBPrpLdangerTot(dbManager).insertAll(claimDto.getPrpLdangerTotDtoList());
    }
    
    if(claimDto.getPrpLextDto()!=null){
        new DBPrpLext(dbManager).insert(claimDto.getPrpLextDto());
     }
    //立案环节增加理赔联系记录，先删后插。 2005-07-18
    if(claimDto.getPrpLregistExtDtoList()!=null)
    { 
       new DBPrpLregistExt(dbManager).insertAll(claimDto.getPrpLregistExtDtoList());
    }
    
     //索赔申请人模块
    if(claimDto.getPrpLacciPersonDtoList()!=null)
    {  String conditions = "certiNo= '"+ claimNo + "' and flag = '1' ";
       new DBPrpLacciPerson(dbManager).deleteByConditions(conditions);
       new DBPrpLacciPerson(dbManager).insertAll(claimDto.getPrpLacciPersonDtoList());
    }
    //add by chenrenda begin 20060628
    //事故者模块
    if(claimDto.getPrplacciBenPersonDtoList()!= null)
    { 
       String conditions = "certiNo= '"+ registNo+"'";
       new DBPrpLacciPerson(dbManager).deleteByConditions(conditions);
       new DBPrpLacciPerson(dbManager).insertAll(claimDto.getPrplacciBenPersonDtoList());
    }
     //add by chenrenda end 20060628
    //如果为保存立案信息，则修改prpCmain表的claimtimes（理赔次数）字段的值。让它加1。
    if (claimDto.getPrpLclaimStatusDto().getStatus().equals("4")) {
    	new DBPrpCmain(dbManager).updateClaimTimesAdd1(claimDto.getPrpLclaimDto().getPolicyNo());
    }
    if(claimDto.getPrpLpersonTraceDtoList()!=null)
    {
       new DBPrpLpersonTrace(dbManager).insertAll(claimDto.getPrpLpersonTraceDtoList());
    }
    //进行状态的改变
    updateClaimStatus(dbManager,claimDto);


  }

  /**
    * 立案注销拒赔保存方法
    *@param claimDto 立案对象
    * @throws SQLException
    * @throws Exception
    *@return 无
    */
   public void saveCancel(DBManager dbManager,ClaimDto claimDto)
     throws SQLException,Exception
   {
     if (claimDto.getPrpLclaimDto() ==null)
     {
              throw new Exception();
     }

     String claimNo="";
     //1，更改prplclaim表的caseType的位置的值,进行状态的改变
     new DBPrpLclaim(dbManager).update(claimDto.getPrpLclaimDto());
     if("3220".equals(claimDto.getPrpLclaimDto().getRiskCode())
    		 ||"3202".equals(claimDto.getPrpLclaimDto().getRiskCode())||"3223".equals(claimDto.getPrpLclaimDto().getRiskCode()) 
    		 ||"3225".equals(claimDto.getPrpLclaimDto().getRiskCode())||"3233".equals(claimDto.getPrpLclaimDto().getRiskCode())
    		 ||"3234".equals(claimDto.getPrpLclaimDto().getRiskCode())||"3239".equals(claimDto.getPrpLclaimDto().getRiskCode())
    		 ||"3236".equals(claimDto.getPrpLclaimDto().getRiskCode())||"3240".equals(claimDto.getPrpLclaimDto().getRiskCode())){
    	 if(claimDto.getPrpLclaimDto().getCancelDate() != null &&
    			 !claimDto.getPrpLclaimDto().getCancelDate().isEmpty() ){
	    	 String statement =  " update prplear set validstatus='0' Where  registNo = '" + claimDto.getPrpLclaimDto().getRegistNo() + "'";
		     dbManager.executeUpdate(statement);
    	 }
     }
     if("2801".indexOf(claimDto.getPrpLclaimDto().getRiskCode()) > -1 || "2607".indexOf(claimDto.getPrpLclaimDto().getRiskCode()) > -1 || "2605".indexOf(claimDto.getPrpLclaimDto().getRiskCode()) > -1 || "2606".indexOf(claimDto.getPrpLclaimDto().getRiskCode()) > -1 || "2609".indexOf(claimDto.getPrpLclaimDto().getRiskCode()) > -1)
     {
    	 String settlelistcode="";
    	 BLSettlemainlistFacadeForMedical blSettlemainlistFacadeForMedical=new BLSettlemainlistFacadeForMedical();
		 String str=" Registercode='"+claimDto.getPrpLclaimDto().getClaimNo()+"'";
		 ArrayList arr=(ArrayList)blSettlemainlistFacadeForMedical.findByConditions(str);
		 SettlemainlistDto settlemainlistDto=new SettlemainlistDto();
		 if(arr.size()>0){
		   settlemainlistDto=(SettlemainlistDto)arr.get(0);
		   settlelistcode=settlemainlistDto.getSettlelistcode();
		 String condition="update medicalSettlelist set validity='4' where Settlelistcode='"+settlelistcode+"' and validity='1'";
		 String condition1="update settlemainlist set validity='4' where Registercode='"+claimDto.getPrpLclaimDto().getClaimNo()+"' and validity='2'";
		 DBManager dbManager1 = new DBManager();
	        try{
	            dbManager1.open("JKXDataSource");
	            dbManager1.executeUpdate(condition);
	            dbManager1.executeUpdate(condition1);
	        }catch(Exception exception){
	            throw exception;
	        }finally{
	            dbManager1.close();
	        }
		 }
     }
     if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3179,3158,3176,3177".indexOf(claimDto.getPrpLclaimDto().getRiskCode()) > -1)){
	     String settlelistcode="";
		 BLSettlemainlistFacade blSettlemainlistFacade=new BLSettlemainlistFacade();
		 String str=" Registercode='"+claimDto.getPrpLclaimDto().getClaimNo()+"'";
		 ArrayList arr=(ArrayList)blSettlemainlistFacade.findByConditions(str);
		 SettlemainlistDto settlemainlistDto=new SettlemainlistDto();
		 if(arr.size()>0){
		   settlemainlistDto=(SettlemainlistDto)arr.get(0);
		   settlelistcode=settlemainlistDto.getSettlelistcode();
		 String condition="update plantingSettlelist set validity='4' where Settlelistcode='"+settlelistcode+"' and validity='1'";
		 String condition1="update settlemainlist set validity='4' where Registercode='"+claimDto.getPrpLclaimDto().getClaimNo()+"' and validity='2'";
		 DBManager dbManager1 = new DBManager();
	        try{
	            dbManager1.open("NXDADataSource");
	            dbManager1.executeUpdate(condition);
	            dbManager1.executeUpdate(condition1);
	        }catch(Exception exception){
	            throw exception;
	        }finally{
	            dbManager1.close();
	        }
		 }
     }
     //yx
     //if("3224".equals(claimDto.getPrpLclaimDto().getRiskCode()))
     if("3224,3201,3204,3238,3228,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(claimDto.getPrpLclaimDto().getRiskCode()) > -1)
     {
	     String settlelistcode="";
		 BLSettlemainlistFacade blSettlemainlistFacade=new BLSettlemainlistFacade();
		 String str=" Registercode='"+claimDto.getPrpLclaimDto().getClaimNo()+"'";
		 ArrayList arr=(ArrayList)blSettlemainlistFacade.findByConditions(str);
		 SettlemainlistDto settlemainlistDto=new SettlemainlistDto();
		 if(arr.size()>0){
		   settlemainlistDto=(SettlemainlistDto)arr.get(0);
		   settlelistcode=settlemainlistDto.getSettlelistcode();
		 String condition="update nyxSettlelist set validity='4' where Settlelistcode='"+settlelistcode+"' and validity='1'";
		 String condition1="update settlemainlist set validity='4' where Registercode='"+claimDto.getPrpLclaimDto().getClaimNo()+"' and validity='2'";
		 DBManager dbManager1 = new DBManager();
	        try{
	            dbManager1.open("NXDADataSource");
	            dbManager1.executeUpdate(condition);
	            dbManager1.executeUpdate(condition1);
	        }catch(Exception exception){
	            throw exception;
	        }finally{
	            dbManager1.close();
	        }
		 }
     }
     String planting31FarmerListFlag = SysConfig.getProperty("PLNATING_31_FARMER_LIST_FLAG","claim");
     if(null != planting31FarmerListFlag && (planting31FarmerListFlag.indexOf(claimDto.getPrpLclaimDto().getRiskCode()) > -1)){
	     String settlelistcode="";
		 BLSettlemainlistFacade blSettlemainlistFacade=new BLSettlemainlistFacade();
		 String str=" Registercode='"+claimDto.getPrpLclaimDto().getClaimNo()+"'";
		 ArrayList arr=(ArrayList)blSettlemainlistFacade.findByConditions(str);
		 SettlemainlistDto settlemainlistDto=new SettlemainlistDto();
		 if(arr.size()>0){
		   settlemainlistDto=(SettlemainlistDto)arr.get(0);
		   settlelistcode=settlemainlistDto.getSettlelistcode();
		 String condition="update planting31Settlelist set validity='4' where Settlelistcode='"+settlelistcode+"' and validity='1'";
		 String condition1="update settlemainlist set validity='4' where Registercode='"+claimDto.getPrpLclaimDto().getClaimNo()+"' and validity='2'";
		 DBManager dbManager1 = new DBManager();
	        try{
	            dbManager1.open("NXDADataSource");
	            dbManager1.executeUpdate(condition);
	            dbManager1.executeUpdate(condition1);
	        }catch(Exception exception){
	            throw exception;
	        }finally{
	            dbManager1.close();
	        }
		 }
     }
     //2,增加拒赔和注销赔案的原因
     if(claimDto.getPrpLltextDtoList()!=null)
     {

       String statement = " DELETE FROM prpLltext Where claimNo='" +claimDto.getPrpLclaimDto().getClaimNo()+"' and texttype='10'";
       dbManager.executeUpdate(statement);
       new DBPrpLltext(dbManager).insertAll(claimDto.getPrpLltextDtoList());
     }

     //3,更新立案操作状态为已提交
     updateClaimStatus(dbManager,claimDto);
     
     //add by lixiang at  20060623  start for 强三----start 
     if(claimDto.getPrpLRegistRPolicyDto()!=null)
     {
     	new DBPrpLRegistRPolicy(dbManager).update(claimDto.getPrpLRegistRPolicyDto());
     }
     //new DBEar(dbManager).cancle(claimDto.getPrpLRegistRPolicyDto().getRegistNo());
     //add by lixiang at  20060623 end for 强三----end 
  }

  /**
   * 变更立案的操作状态的方法
   *@param claimDto 立案对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void updateClaimStatus(DBManager dbManager,ClaimDto claimDto)
    throws SQLException,Exception
{

 //示例未完成
   String statement = "";


  if(claimDto.getPrpLclaimStatusDto() !=null)
   {
     String condition3 = " BusinessNo='" + StringUtils.rightTrim(claimDto.getPrpLclaimStatusDto().getBusinessNo()) + "' "
                       + " AND NodeType ='claim' ";
    statement = " DELETE FROM prpLclaimStatus Where " + condition3;

    dbManager.executeUpdate(statement);
      new DBPrpLclaimStatus(dbManager).insert(claimDto.getPrpLclaimStatusDto() );
   }


}

  /**
   * 立案删除
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String claimNo)
    throws SQLException,Exception
  {
    String statement = "";
    String condition = " claimNo='" + StringUtils.rightTrim(claimNo) + "'";
    statement = " DELETE FROM prpLlText Where " + condition;
    dbManager.executeUpdate(statement);

    statement = " DELETE FROM prpLdoc Where " + condition;
    dbManager.executeUpdate(statement);

    statement = " DELETE FROM prpLclaimFee Where " + condition;
    dbManager.executeUpdate(statement);

    statement = " DELETE FROM prpLclaimLoss Where " + condition;
    dbManager.executeUpdate(statement);

    statement = " DELETE FROM prpLclaim Where " + condition;
    dbManager.executeUpdate(statement);

  }

  /*
   * 立案查询方法
   *@param claimDto 立案对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public ClaimDto findByPrimaryKey(DBManager dbManager,String claimNo)
    throws SQLException,Exception
  {
     String conditions = " ClaimNo = '"+claimNo+"'";
     
     //Modify by lixiang add start 2006-02-14
     //Reason: 立案估损金额查询时要按SerialNo排序
     String strConditions = conditions + "  order by SerialNo";
     //Modify by lixiangw add start 2006-02-14

     ClaimDto claimDto = new ClaimDto();
     //得到报案号
     //Modify by chenrenda add begin 20050408
     //在立案对象加入损失部位模块信息
     PrpLclaimDto prplclaimDto = new DBPrpLclaim(dbManager).findByPrimaryKey(claimNo);
     //add by qinyongli start 2005-9-6 加入赔案号是否存在判断
     if(prplclaimDto==null){
     	 return null;
     }
     //add by qinyongli end
     String registNo = prplclaimDto.getRegistNo();
     String condition2 = " registNo = "+ "'" + StringUtils.rightTrim(registNo) + "' ";
     claimDto.setPrpLthirdCarLossDtoList((ArrayList)new DBPrpLthirdCarLoss(dbManager).findByConditions(condition2,0,0));
     claimDto.setPrpLthirdPropDtoList((ArrayList)new DBPrpLthirdProp(dbManager).findByConditions(condition2,0,0));
     //Modify by chenrenda add end 20050408
     claimDto.setPrpLclaimDto(new DBPrpLclaim(dbManager).findByPrimaryKey(claimNo));
     claimDto.setPrpLpersonDtoList((ArrayList)new DBPrpLperson(dbManager).findByConditions(conditions, 0, 0));
     claimDto.setPrpLthirdPartyDtoList((ArrayList)new DBPrpLthirdParty(dbManager).findByConditions(condition2,0,0));
     claimDto.setPrpLdriverDtoList((ArrayList)new DBPrpLdriver(dbManager).findByConditions(condition2,0,0));
     claimDto.setPrpLltextDtoList((ArrayList)new DBPrpLltext(dbManager).findByConditions(conditions,0,0));
     claimDto.setPrpLltextDtoList3((ArrayList)new DBPrpLltext(dbManager).findByConditions(conditions,0,0));
     claimDto.setPrpLdocDtoList((ArrayList)new DBPrpLdoc(dbManager).findByConditions(conditions,0,0));
     claimDto.setPrpLclaimFeeDtoList((ArrayList)new DBPrpLclaimFee(dbManager).findByConditions(conditions,0,0));
     claimDto.setPrpLclaimLossDtoList((ArrayList)new DBPrpLclaimLoss(dbManager).findByConditions(strConditions,0,0));

     claimDto.setPrpLclaimStatusDto(new DBPrpLclaimStatus(dbManager).findByPrimaryKey(claimNo,"claim",0));
     //事故者
     String strBenPersonCondition =  " certiNo = "+ "'" + StringUtils.rightTrim(registNo) + "'";
     claimDto.setPrplacciBenPersonDtoList((ArrayList)new DBPrpLacciPerson(dbManager).findByConditions(strBenPersonCondition,0,0));
     //索赔申请人
     String conditions3 ="certiNo = '"+claimNo+ "' and flag='1' " ;
     claimDto.setPrpLacciPersonDtoList((ArrayList)new DBPrpLacciPerson(dbManager).findByConditions(conditions3,0,0));
     
     conditions = " policyNo = '"+claimDto.getPrpLclaimDto().getPolicyNo()+"'";
     claimDto.setPrpCengageDtoList((ArrayList)new DBPrpCengage(dbManager).findByConditions(conditions,0,0));
     
     //向立案信息中增加理赔联系记录 2005-07-18
     claimDto.setPrpLregistExtDtoList((ArrayList)new DBPrpLregistExt(dbManager).findByConditions(condition2,0,0));
     
     //添加人伤跟踪信息 2005-07-26
     claimDto.setPrpLpersonTraceDtoList((ArrayList)new DBPrpLpersonTrace(dbManager).findByConditions(condition2,0,0));
     //add by qinyongli 增加立案扩展信息
     claimDto.setPrpLextDto(new DBPrpLext(dbManager).findByPrimaryKey(claimNo,"03"));
     //add by lym 20060809 start for （特殊赔案：垫支付）
     claimDto.setPrpLprepayDtoList((ArrayList)new DBPrpLprepay(dbManager).findByConditions(" claimno ='"+claimNo+"'" )); 
     //add by lym 20060809 end for （特殊赔案：垫支付）
     claimDto.setPrpLpreChargeDtoList((ArrayList)new DBPrpLpreCharge(dbManager).findByConditions(" claimno ='"+claimNo+"'" ));
     return claimDto;
  }

  /**
   * 立案删除子表信息
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,String claimNo,String registNo)
    throws SQLException,Exception
  {
    String condition1 = " claimNo = " + "'" + StringUtils.rightTrim(claimNo) + "'";
    String condition2 = " registNo = "+ "'" + StringUtils.rightTrim(registNo) + "'";
    String condition3 = " certino= "+"'" + StringUtils.rightTrim(claimNo) + "'";
    String condition4 = " claimNo = " + "'" + StringUtils.rightTrim(claimNo) + "' and nodetype ='claim'";
  //示例未完成
    String statement = "";
     
    statement = " DELETE FROM prpLcompensateEar Where " + condition1;
    dbManager.executeUpdate(statement);
    
    statement = " DELETE FROM prpLlText Where " + condition1;
    dbManager.executeUpdate(statement);

    statement = " DELETE FROM prpLdriver Where " + condition2;
    dbManager.executeUpdate(statement);

    statement =" DELETE FROM prpLthirdParty Where " + condition2;
    dbManager.executeUpdate(statement);
    
    statement =  " DELETE FROM PrpLthirdCarLoss Where " + condition2;
    dbManager.executeUpdate(statement);

    statement =  " DELETE FROM PrpLthirdProp Where " + condition2;
    dbManager.executeUpdate(statement);

    statement = " DELETE FROM prpLdoc Where " + condition1;
    dbManager.executeUpdate(statement);

    statement = " DELETE FROM prpLclaimFee Where " + condition1;
    dbManager.executeUpdate(statement);

    statement = " DELETE FROM prpLclaimLoss Where " + condition1;
    dbManager.executeUpdate(statement);
    
    //立案环节增加理赔联系记录，先删后插。 2005-07-18
    statement =  " DELETE FROM PrpLregistExt Where " + condition2;
    dbManager.executeUpdate(statement);

    statement = " DELETE FROM prpLclaim Where " + condition1;
    dbManager.executeUpdate(statement);
    
    //立案环节增加人伤跟踪信息，先删后插。 2005-07-18
    statement =  " DELETE FROM prpLpersonTrace Where " + condition2;
    dbManager.executeUpdate(statement);
    
    //立案环节保存危险单位信息表   2011-01-14 
    statement =  "DELETE FROM prpldangeritem where " + condition3;
    dbManager.executeUpdate(statement);
    
    //立案环节保存危险单位金额合计信息表 2011-01-14
    statement =  "DELETE FROM prpldangertot where " + condition3;
    dbManager.executeUpdate(statement);
    
    //立案环节保存危险单位划分表    2011-01-14 
    statement =  "DELETE FROM prpldangerunit where " + condition3;
    dbManager.executeUpdate(statement);
    
    //立案扩展表信息 add by qinyongli 
    String condition_claim = "delete from prplext where certino = " + "'" + StringUtils.rightTrim(claimNo) + "'";
    dbManager.executeUpdate(condition_claim);
    
  }

    public void UpdCaseType(DBManager dbManager,String claimNo) throws Exception{
        String statement = " update PrpLclaim set casetype=''  Where " +
                           " ClaimNo ='"+claimNo+"'";
        dbManager.prepareStatement(statement);
        dbManager.executePreparedUpdate();
    }

    public void UpdSumClaim(DBManager dbManager,ClaimDto claimDto,String claimNo,double sumClaim) throws Exception{

    	String condition1 = " claimNo = " + "'" + StringUtils.rightTrim(claimNo) + "'";
	    condition1 = " DELETE FROM prpLclaimLoss Where " + condition1;
	    dbManager.executeUpdate(condition1);
	    if(claimDto.getPrpLclaimLossDtoList()!=null)
	    {
	       new DBPrpLclaimLoss(dbManager).insertAll(claimDto.getPrpLclaimLossDtoList());
	    }
           String statement = " update PrpLclaim set sumclaim="+sumClaim+"Where " +
                           " ClaimNo ='"+claimNo+"'";
        dbManager.prepareStatement(statement);
        dbManager.executePreparedUpdate();
    }	
    
    //modify by wangwei add start 2005-06-05
    //原因：添加一个方法同时获得立案信息和报案信息
    public Object findByPolicyNo(DBManager dbManager, String policyNo) throws Exception {
    	ArrayList prpLregistDtoList = (ArrayList) new DBPrpLregist(dbManager).findByConditions(" policyno= '" + policyNo + "'");
    	Collection registClaimDtoList = new ArrayList();
    	
    	for (int i = 0; i < prpLregistDtoList.size(); i++) {
    		PrpLregistDto prpLregistDto = (PrpLregistDto) prpLregistDtoList.get(i);
    		RegistClaimInfoDto registClaimInfoDto = new RegistClaimInfoDto();
    		
    		registClaimInfoDto.setSerialNo(prpLregistDto.getSerialNo());
    		registClaimInfoDto.setRegistNo(prpLregistDto.getRegistNo());
    		registClaimInfoDto.setDamageStartDate(prpLregistDto.getDamageStartDate());
    		registClaimInfoDto.setLinkerName(prpLregistDto.getLinkerName());
    		registClaimInfoDto.setOperatorCode(prpLregistDto.getOperatorCode());
    		registClaimInfoDto.setOperatorName(prpLregistDto.getOperatorName());
    		registClaimInfoDto.setDamageAddress(prpLregistDto.getDamageAddress());
    		registClaimInfoDto.setBrandName(prpLregistDto.getBrandName());
    		registClaimInfoDto.setRegistNo(prpLregistDto.getRegistNo()); 
    		registClaimInfoDto.setPhoneNumber(prpLregistDto.getPhoneNumber());
    		registClaimInfoDto.setDamageName(prpLregistDto.getDamageName());
    		registClaimInfoDto.setDamageName(prpLregistDto.getDamageName());
    		registClaimInfoDto.setDamageAreaName(prpLregistDto.getDamageAddress());
    		ArrayList prpLclaimDtoList = new ArrayList();
    		ArrayList prpLcompensateDtoList = new ArrayList();
    		List prpLthirdCarLossList = new ArrayList();
    		double sumPaidShow = 0D;
    		
    		try {
    		    prpLclaimDtoList = (ArrayList) new DBPrpLclaim(dbManager).findByConditions(" registno= '"  + prpLregistDto.getRegistNo() + "'");
    		    prpLthirdCarLossList = (ArrayList) new DBPrpLthirdCarLoss(dbManager).findByConditions(" registno= '"  + prpLregistDto.getRegistNo() + "'");
      		} catch(Exception e) {
    			prpLclaimDtoList = null;
    		}
            
      		if (prpLthirdCarLossList.size() < 1) {
      			registClaimInfoDto.setCompName("");
      		} else {
      			PrpLthirdCarLossDto prpLthirdCarDto = (PrpLthirdCarLossDto) prpLthirdCarLossList.get(0);	
      			registClaimInfoDto.setCompName(prpLthirdCarDto.getCompName());
      		}
      		
      		if (prpLclaimDtoList == null) {
      			prpLclaimDtoList = new ArrayList();
      		}
      		
    		if (prpLclaimDtoList.size() < 1) {
    			registClaimInfoDto.setClaimNo("");
    			registClaimInfoDto.setSumClaim(0);
    			registClaimInfoDto.setSumPaidShow(0);
    			if(prpLregistDto.getCancelDate() == null || prpLregistDto.getCancelDate().toString().equals("")){
    				registClaimInfoDto.setStatus("正处理");
    			}
    			else{
    				registClaimInfoDto.setStatus("已注销");
    			}
    			
    		} else {
    			PrpLclaimDto  prpLclaimDto = (PrpLclaimDto)  prpLclaimDtoList.get(0);
    			prpLcompensateDtoList = (ArrayList) new DBPrpLcompensate(dbManager).findByConditions(" claimno='" + prpLclaimDto.getClaimNo() +"'");
    			
    			for (int j = 0; j < prpLcompensateDtoList.size(); j++) {
    				PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto) prpLcompensateDtoList.get(j);
    				sumPaidShow = sumPaidShow + prpLcompensateDto.getSumPaid();					
    			}
    			registClaimInfoDto.setClaimType(prpLclaimDto.getClaimType());
    			registClaimInfoDto.setClaimNo(prpLclaimDto.getClaimNo());
    			registClaimInfoDto.setSumClaim(prpLclaimDto.getSumClaim());
    			registClaimInfoDto.setSumPaidShow(sumPaidShow);
    			if(prpLclaimDto.getCaseType()== null || prpLclaimDto.getCaseType().equals("")){
    				registClaimInfoDto.setStatus("未结案");
    			}
    			else if(prpLclaimDto.getCaseType().equals("0")){
    				registClaimInfoDto.setStatus("已注销");
    			}
    			else if(prpLclaimDto.getCaseType().equals("1")){
    				registClaimInfoDto.setStatus("已拒陪");
    			}
    			else if(prpLclaimDto.getCaseType().equals("2")){
    				registClaimInfoDto.setStatus("已结案");
    			}
    			
    		}
    		
    		registClaimDtoList.add(registClaimInfoDto);
    	}  	
       
    	return registClaimDtoList;
    }
    
    public Object findByPolicyNo(DBManager dbManager, String policyNo,String idcard) throws Exception {
    	ArrayList prpLregistDtoList = (ArrayList) new DBPrpLregist(dbManager).findByConditions0310(" prplregist.policyno= '" + policyNo + "' and prplcompensatehouse.IDCARD='" + idcard + "'");
    	Collection registClaimDtoList = new ArrayList();
    	
    	for (int i = 0; i < prpLregistDtoList.size(); i++) {
    		PrpLregistDto prpLregistDto = (PrpLregistDto) prpLregistDtoList.get(i);
    		RegistClaimInfoDto registClaimInfoDto = new RegistClaimInfoDto();
    		
    		registClaimInfoDto.setSerialNo(prpLregistDto.getSerialNo());
    		registClaimInfoDto.setRegistNo(prpLregistDto.getRegistNo());
    		registClaimInfoDto.setDamageStartDate(prpLregistDto.getDamageStartDate());
    		registClaimInfoDto.setLinkerName(prpLregistDto.getLinkerName());
    		registClaimInfoDto.setOperatorCode(prpLregistDto.getOperatorCode());
    		registClaimInfoDto.setOperatorName(prpLregistDto.getOperatorName());
    		registClaimInfoDto.setDamageAddress(prpLregistDto.getDamageAddress());
    		registClaimInfoDto.setBrandName(prpLregistDto.getBrandName());
    		registClaimInfoDto.setRegistNo(prpLregistDto.getRegistNo()); 
    		registClaimInfoDto.setPhoneNumber(prpLregistDto.getPhoneNumber());
    		registClaimInfoDto.setDamageName(prpLregistDto.getDamageName());
    		registClaimInfoDto.setDamageName(prpLregistDto.getDamageName());
    		registClaimInfoDto.setDamageAreaName(prpLregistDto.getDamageAddress());
    		ArrayList prpLclaimDtoList = new ArrayList();
    		ArrayList prpLcompensateDtoList = new ArrayList();
    		//List prpLthirdCarLossList = new ArrayList();
    		double sumPaidShow = 0D;
    		
    		try {
    		    prpLclaimDtoList = (ArrayList) new DBPrpLclaim(dbManager).findByConditions(" registno= '"  + prpLregistDto.getRegistNo() + "'");
    		    //prpLthirdCarLossList = (ArrayList) new DBPrpLthirdCarLoss(dbManager).findByConditions(" registno= '"  + prpLregistDto.getRegistNo() + "'");
      		} catch(Exception e) {
    			prpLclaimDtoList = null;
    		}
      		
      		if (prpLclaimDtoList == null) {
      			prpLclaimDtoList = new ArrayList();
      		}
      		
    		if (prpLclaimDtoList.size() < 1) {
    			registClaimInfoDto.setClaimNo("");
    			registClaimInfoDto.setSumClaim(0);
    			registClaimInfoDto.setSumPaidShow(0);
    			if(prpLregistDto.getCancelDate() == null || prpLregistDto.getCancelDate().toString().equals("")){
    				registClaimInfoDto.setStatus("正处理");
    			}
    			else{
    				registClaimInfoDto.setStatus("已注销");
    			}
    			
    		} else {
    			PrpLclaimDto  prpLclaimDto = (PrpLclaimDto)  prpLclaimDtoList.get(0);
    			prpLcompensateDtoList = (ArrayList) new DBPrpLcompensate(dbManager).findByConditions(" claimno='" + prpLclaimDto.getClaimNo() +"'");
    			
    			for (int j = 0; j < prpLcompensateDtoList.size(); j++) {
    				PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto) prpLcompensateDtoList.get(j);
    				sumPaidShow = sumPaidShow + prpLcompensateDto.getSumPaid();					
    			}
    			registClaimInfoDto.setClaimType(prpLclaimDto.getClaimType());
    			registClaimInfoDto.setClaimNo(prpLclaimDto.getClaimNo());
    			registClaimInfoDto.setSumClaim(prpLclaimDto.getSumClaim());
    			registClaimInfoDto.setSumPaidShow(sumPaidShow);
    			if(prpLclaimDto.getCaseType()== null || prpLclaimDto.getCaseType().equals("")){
    				registClaimInfoDto.setStatus("未结案");
    			}
    			else if(prpLclaimDto.getCaseType().equals("0")){
    				registClaimInfoDto.setStatus("已注销");
    			}
    			else if(prpLclaimDto.getCaseType().equals("1")){
    				registClaimInfoDto.setStatus("已拒陪");
    			}
    			else if(prpLclaimDto.getCaseType().equals("2")){
    				registClaimInfoDto.setStatus("已结案");
    			}
    			
    		}
    		
    		registClaimDtoList.add(registClaimInfoDto);
    	}  	
       
    	return registClaimDtoList;
    }
    
    
    //modify by wangwei add end 2005-06-05
    
   //modify by liuyanmei add 20051102 start
    public void updateEndCaseDate(DBManager dbManager,String claimNo,Date endCaseDate)
    throws SQLException,Exception
    {	
    	String statement = "" ;
    	if(endCaseDate == null){
    		statement = "update prplclaim set endCaseDate = null Where claimNo= ?";
    		dbManager.prepareStatement(statement);
    		dbManager.setString(1, claimNo);
    	}
    	else{
    		statement = "update prplclaim set endCaseDate = ? Where claimNo= ?";
    		dbManager.prepareStatement(statement);
    		dbManager.setDateTime(1, (DateTime)endCaseDate);
    		dbManager.setString(2, StringUtils.rightTrim(claimNo));
    	}
    	dbManager.executePreparedUpdate();
    }
    //modify by liuyanmei add 20051102 end 
}
