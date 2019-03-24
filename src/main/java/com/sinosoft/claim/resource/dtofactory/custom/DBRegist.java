package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;

import com.gyic.claim.bl.facade.BLSettlemainlistFacade;
import com.gyic.claim.bl.facade.BLSettlemainlistFacadeForMedical;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.gyic.claim.resource.dtofactory.domain.DBPrplcompensateear;
import com.sinosoft.claim.dto.custom.AcciCheckDto;
import com.sinosoft.claim.dto.custom.CaseRelateNodeDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCmain;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLRegistRPolicy;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciCheck;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciCheckText;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciPerson;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcheck;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaim;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLdriver;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLear;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLext;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonTrace;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregist;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistExt;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistText;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLrelatePerson;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleItem;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleMainWF;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdCarLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdParty;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdProp;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcompensatehouse;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplregisthis;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 报案数据库管理对象
 * <p>Title: 车险理赔报案数据管理</p>
 * <p>Description: 车险理赔报案数据管理</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class DBRegist
{
  private DBManager dbManager = null; //资源管理类

  /**
   * 构造函数
   * @param dbManager 资源管理类
   */
  public DBRegist()
  {

  }

  /**
   * 报案保存方法
   *@param registDto 报案对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void insert(DBManager dbManager,RegistDto registDto)
    throws SQLException,Exception
  {
    if (registDto.getPrpLregistDto() ==null)
    {
    	 throw new Exception();
    }

    String registNo="";
    registNo = registDto.getPrpLregistDto().getRegistNo();

    //首先删除原来的相关数据
    deleteSubInfo(dbManager,registNo);

    new DBPrpLregist(dbManager).insert(registDto.getPrpLregistDto());
   
    //add by lym 20060605 for 强三 -----start
    if(registDto.getPrpLRegistRPolicyList()!=null)
    { 
       new DBPrpLRegistRPolicy(dbManager).insertAll(registDto.getPrpLRegistRPolicyList());
    }
    //add by lym 20060605 for 强三 -----end
    
    if(registDto.getPrpLthirdPartyDtoList()!=null)
    {
       new DBPrpLthirdParty(dbManager).insertAll(registDto.getPrpLthirdPartyDtoList());
    }
    if(registDto.getPrpLdriverDtoList()!=null)
    {
       new DBPrpLdriver(dbManager).insertAll(registDto.getPrpLdriverDtoList());
    }
    if(registDto.getPrpLregistTextDtoList()!=null)
    {
       new DBPrpLregistText(dbManager).insertAll(registDto.getPrpLregistTextDtoList());
    }
    
    //modify by wangwei add start 2005-06-16
    //原因：添加呈报信息
    if(registDto.getPrpLregistTextDtoList2()!=null)
    {
       new DBPrpLregistText(dbManager).insertAll(registDto.getPrpLregistTextDtoList2());
    }
    //modify by wangwei add end 2005-06-16
    
    //modify by luqin
    if(registDto.getPrpLextDto() != null)
    {
    	new DBPrpLext(dbManager).insert(registDto.getPrpLextDto());
    }
    
     if(registDto.getPrpLthirdCarLossDtoList()!=null)
     {
        new DBPrpLthirdCarLoss(dbManager).insertAll(registDto.getPrpLthirdCarLossDtoList());
     }
     if(registDto.getPrpLthirdPropDtoList()!=null)
     {
        new DBPrpLthirdProp(dbManager).insertAll(registDto.getPrpLthirdPropDtoList());
     }

     if(registDto.getPrpLpersonTraceDtoList()!=null)
     {
        new DBPrpLpersonTrace(dbManager).insertAll(registDto.getPrpLpersonTraceDtoList());
     }

     if(registDto.getPrpLregistExtDtoList()!=null)
     {
        new DBPrpLregistExt(dbManager).insertAll(registDto.getPrpLregistExtDtoList());
     }

/*     if(registDto.getPrpLscheduleNewDto()!=null)
   {
      new DBPrpLscheduleNew(dbManager).insert(registDto.getPrpLscheduleNewDto());
    }
*/
	if(registDto.getPrpLscheduleMainWFDto() !=null) {
	    new DBPrpLscheduleMainWF(dbManager).insert(registDto.getPrpLscheduleMainWFDto() );
	  }

  if(registDto.getPrpLscheduleItemDtoList() !=null)   {
     new DBPrpLscheduleItem(dbManager).insertAll(registDto.getPrpLscheduleItemDtoList()  );
  }
  
  //modify by wangwei add start 20050601
  if (registDto.getPrpLrelatePersonDtoList() != null) {
     new DBPrpLrelatePerson(dbManager).insertAll(registDto.getPrpLrelatePersonDtoList());
  }
  //modify by wangwei add end 20050601

  if(registDto.getPrplacciBenPersonDtoList()!=null){
	  
	 new DBPrpLacciPerson(dbManager).insertAll(registDto.getPrplacciBenPersonDtoList()) ;
  }
     //进行状态的改变
  //modified by GYIC 李杨 更换耳标号清单表为prplcompensateear   Start!
  if(registDto.getPrpLcompensateEarDtoList() != null){
	  new DBPrplcompensateear(dbManager).insertAll(registDto.getPrpLcompensateEarDtoList());
  }
  
  if (registDto.getPrplCompensateHouseDtoList()!= null && registDto.getPrplCompensateHouseDtoList().size() > 0) {
		PrplcompensatehouseDto PrplcompensatehouseDto = (PrplcompensatehouseDto)registDto.getPrplCompensateHouseDtoList().get(0);
		String registno = PrplcompensatehouseDto.getRegistno();
		String nodetype = PrplcompensatehouseDto.getNodetype();
		String condition = " registno='" + registno + "' and nodetype='" + nodetype + "'";
		new DBPrplcompensatehouse(dbManager).deleteByConditions(condition);
		new DBPrplcompensatehouse(dbManager).insertAll(registDto.getPrplCompensateHouseDtoList());
	}
  //modified by GYIC 李杨 更换耳标号清单表为prplcompensateear   End!
 
  if(registDto.getPrpLregistTextDtoList3() != null){
	  new DBPrpLregistText(dbManager).insertAll(registDto.getPrpLregistTextDtoList3());
  }
     updateClaimStatus(dbManager,registDto);

  }


  /**
   * 变更立案的操作状态的方法
   *@param claimDto 立案对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void updateClaimStatus(DBManager dbManager,RegistDto registDto)
    throws SQLException,Exception
{

 //示例未完成
   String statement = "";


  if(registDto.getPrpLclaimStatusDto() !=null)
   {
     String condition3 = " BusinessNo='" + StringUtils.rightTrim(registDto.getPrpLclaimStatusDto().getBusinessNo()) + "' "
                       + " AND NodeType ='regis' ";
    statement = " DELETE FROM prpLclaimStatus Where " + condition3;

    dbManager.executeUpdate(statement);

      new DBPrpLclaimStatus(dbManager).insert(registDto.getPrpLclaimStatusDto() );
   }


}


  /**
   * 报案删除
   * @param fcoRegistNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
    String condition = " registNo = '" + StringUtils.rightTrim(registNo) + "'";
    //示例未完成
    String statement = " DELETE FROM prpLregistText Where " + condition ;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLdriver Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLthirdParty Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM PrpLthirdCarLoss Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM PrpLthirdProp Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLregist Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLrelatePerson Where " + condition;
    dbManager.executeUpdate(statement);
    String condition3 = " businessno = '" + StringUtils.rightTrim(registNo) + "'";
    statement = " DELETE FROM prpLclaimStatus Where " + condition3;
    dbManager.executeUpdate(statement);

    statement= " DELETE FROM prplscheduleNew Where " + condition;
    dbManager.executeUpdate(statement);
    //add by lym 20060605 for 强三---start 
    statement= " DELETE FROM prpLRegistRPolicy Where " + condition;
    dbManager.executeUpdate(statement);
    //add by lym 20060605 for 强三---end
    String condition4 = " CertiNo = '" + StringUtils.rightTrim(registNo) + "'";
    statement = " DELETE FROM prpLacciPerson Where " + condition4;
    dbManager.executeUpdate(statement);
    //
    //modified by GYIC 李杨 更换耳标号清单表为prplcompensateear   Start!
    statement = " DELETE FROM prplcompensateear Where " + condition+ " and NodeType = 'regis'";
    dbManager.executeUpdate(statement);
    //modified by GYIC 李杨 更换耳标号清单表为prplcompensateear   End!
  }

  /**
     * 报案撤消
     * @param fcoRegistNoticeNo
     * @throws SQLException
     * @throws Exception
     */
    public void cancel(DBManager dbManager,String registNo)
      throws SQLException,Exception
    {
      //表示案件被撤消


    }
  /*
   * 报案查询方法
   *@param registDto 报案对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public RegistDto findByPrimaryKey(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
     String conditions = " RegistNo = '"+registNo+"'";
     String conditions2 =  " RegistNo = '"+registNo+"' and nodetype='regis'";
     String conditionsorder = " RegistNo = '"+registNo+"' order by serialNo";
     RegistDto registDto = new RegistDto();
     registDto.setPrpLregistDto(new DBPrpLregist(dbManager).findByPrimaryKey(registNo));
     
     registDto.setPrpLextDto(new DBPrpLext(dbManager).findByPrimaryKey(registNo,"01"));
     
     registDto.setPrpLthirdPartyDtoList((ArrayList)new DBPrpLthirdParty(dbManager).findByConditions(conditionsorder,0,0));
     registDto.setPrpLdriverDtoList((ArrayList)new DBPrpLdriver(dbManager).findByConditions(conditions,0,0));
     registDto.setPrpLthirdCarLossDtoList((ArrayList)new DBPrpLthirdCarLoss(dbManager).findByConditions(conditions,0,0));
     registDto.setPrpLthirdPropDtoList((ArrayList)new DBPrpLthirdProp(dbManager).findByConditions(conditions,0,0));
     registDto.setPrpLpersonTraceDtoList((ArrayList)new DBPrpLpersonTrace(dbManager).findByConditions(conditions,0,0));
     registDto.setPrpLregistExtDtoList((ArrayList)new DBPrpLregistExt(dbManager).findByConditions(conditions,0,0));
     registDto.setPrpLregistTextDtoList((ArrayList)new DBPrpLregistText(dbManager).findByConditions(conditions,0,0));
     registDto.setPrpLregistTextDtoList3((ArrayList)new DBPrpLregistText(dbManager).findByConditions(conditions,0,0));
     registDto.setPrpLrelatePersonDtoList((ArrayList)new DBPrpLrelatePerson(dbManager).findByConditions(conditions,0,0));
     String conditions1 = " registNo= '"+registNo+"' AND scheduleID=1";
     registDto.setPrplCompensateHouseDtoList((ArrayList)new DBPrplcompensatehouse(dbManager).findByConditions(conditions2));
     registDto.setPrpLscheduleMainWFDto(new DBPrpLscheduleMainWF(dbManager).findByPrimaryKey(1,registNo));
     registDto.setPrpLscheduleItemDtoList((ArrayList)new DBPrpLscheduleItem(dbManager).findByConditions(conditions1));
     //耳标号从表prplcompensateear中获取。by GYIC 李杨 20110811 Start!
//     registDto.setPrpLearDtoList((ArrayList)new DBPrpLear(dbManager).findByConditions(conditions));
     registDto.setPrpLcompensateEarDtoList((ArrayList)new DBPrplcompensateear(dbManager).findByConditions(conditions2));
     //耳标号从表prplcompensateear中获取。by GYIC 李杨 20110811 End!
     registDto.setPrpLclaimStatusDto(new DBPrpLclaimStatus(dbManager).findByPrimaryKey(registNo,"regis",0));
     String strConditions = "certino = '"+registNo +"'";
     ArrayList acciBenPersonList = (ArrayList) new DBPrpLacciPerson(dbManager).findByConditions(strConditions);
     //如果性别没有的险种，给赋值为9（与核心分户录入时统一），其表示未知
     for (int i = 0; i < acciBenPersonList.size(); i++) {
			PrpLacciPersonDto prpLacciPersonDto = (PrpLacciPersonDto) acciBenPersonList
					.get(i);

			if (prpLacciPersonDto.getSex() == null
					|| prpLacciPersonDto.getSex() == "") {
				prpLacciPersonDto.setSex("9");
			}
		}
     
     registDto.setPrplacciBenPersonDtoList(acciBenPersonList);
     //add by lixiang start at 2006-6-9
     //强三关联查询 
     String relateConditions=conditions+" and validstatus='1'";
     ArrayList relatePolicyList = (ArrayList) new DBPrpLRegistRPolicy(dbManager).findByConditions(relateConditions);
     registDto.setPrpLRegistRPolicyList(relatePolicyList);
     //add by lixiang end at 2006-6-9
     //modify by wangwei add start 2005-06-18
     //原因：添加调查信息
     AcciCheckDto acciCheckDto = new AcciCheckDto();
     int time = new DBPrpLacciCheck(dbManager).findByRegistNoMaxTimes(registNo);
     conditions = " RegistNo = '"+registNo + "' and Times = " + time; 
     ArrayList acciCheckDtoList = (ArrayList) new DBPrpLacciCheck(dbManager).findByConditions(conditions);
     if (acciCheckDtoList != null && acciCheckDtoList.size() > 0) {
         acciCheckDto.setPrpLacciCheckDto((PrpLacciCheckDto) acciCheckDtoList.get(0));
         acciCheckDto.setPrpLacciCheckTextDtoList((ArrayList) new DBPrpLacciCheckText(dbManager).findByConditions("CheckNo = '" + acciCheckDto.getPrpLacciCheckDto().getCheckNo() +"'"));
         acciCheckDto.setPrpLregistDto(new DBPrpLregist(dbManager).findByPrimaryKey(registNo));
     } 
     registDto.setAcciCheckDto(acciCheckDto);
     //modify by wangwei add end 2005-06-18
     
    
     
     return registDto;
  }

  /**
   * 立案删除子表信息
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
    String condition = " registNo = '" + StringUtils.rightTrim(registNo) + "'";
    //示例未完成

    String statement = " DELETE FROM prpLregistText Where " + condition ;
    dbManager.executeUpdate(statement);
    statement = " DELETE FROM prpLscheduleMainWF Where " + condition ;
    dbManager.executeUpdate(statement);
    statement = " DELETE FROM prpLscheduleItem Where " + condition ;
    dbManager.executeUpdate(statement);
    statement = " DELETE FROM prpLrelatePerson Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLpersonTrace Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM PrpLregistExt Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLdriver Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM PrpLthirdCarLoss Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM PrpLthirdProp Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLthirdParty Where " + condition;
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prpLregist Where " + condition;
    dbManager.executeUpdate(statement);
    //add by lym 20060605 for 强三 ---start
    statement =  " DELETE FROM prpLRegistRPolicy Where " + condition;
    dbManager.executeUpdate(statement);
    //add by lym 20060605 for 强三 ---end    
    statement =  " DELETE FROM prpLext Where certiNo = '" + StringUtils.rightTrim(registNo) + "'";
    dbManager.executeUpdate(statement);
    statement =  " DELETE FROM prplCompensateEar Where " + condition+" And nodeType ='regis'";
    dbManager.executeUpdate(statement);
  }

  /*
   * 报案查询方法
   *@param registDto 报案对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public CaseRelateNodeDto relateNode(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
     UICodeAction uiCodeAction = new UICodeAction();
     String claimNo = uiCodeAction.translateBusinessCode(registNo,true);
     CaseRelateNodeDto caseRelateNodeDto = new CaseRelateNodeDto();
     caseRelateNodeDto.setPrpLregistDto(new DBPrpLregist(dbManager).findByPrimaryKey(registNo));
     caseRelateNodeDto.setPrpCmainDto(new DBPrpCmain(dbManager).findByPrimaryKey(caseRelateNodeDto.getPrpLregistDto().getPolicyNo()));
     //caseRelateNodeDto.setPrpLscheduleMainWFDto(new DBPrpCmain(dbManager).findByPrimaryKey());
     caseRelateNodeDto.setPrpLcheckDto(new DBPrpLcheck(dbManager).findByPrimaryKey(registNo,1));
     caseRelateNodeDto.setPrpLverifyLossDto(new DBPrpLverifyLoss(dbManager).findByPrimaryKey(registNo,"1"));
     caseRelateNodeDto.setPrpLclaimDto(new DBPrpLclaim(dbManager).findByPrimaryKey(claimNo));

     return caseRelateNodeDto;
  }

  
  
 /**
   * 报案保存注销信息
   * @param registDto 报案对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void insertRegistCancel(DBManager dbManager,RegistDto registDto)
    throws SQLException,Exception
  {
    if (registDto.getPrpLregistDto() ==null)
    {
    	 throw new Exception("没有报案信息");
    }
    String statement ="";
    //更新报案表信息
    String registNo="";
    registNo = registDto.getPrpLregistDto().getRegistNo();
  
    if(registDto.getPrpLRegistRPolicyDto()==null){ //不单独更新关联表的时候，才更新报案的
    new DBPrpLregist(dbManager).update(registDto.getPrpLregistDto());
     statement =  " update prplregistrpolicy set validstatus='0'," +
     		"  CancelReason='" + registDto.getPrpLregistDto().getCancelReason() + "'," +
     		"  CancelReasonName='" + registDto.getPrpLregistDto().getCancelReasonName() + "' Where  registNo = '" + StringUtils.rightTrim(registNo) + "'";
     dbManager.executeUpdate(statement);
     
    //增加需要将关联表中的信息全部注销掉的过程
    }
    if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3148,3174,3150,3151,3197,3152,3153,3154,3155,3156,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3179,3187,3178,3158,3176,3177".indexOf(registDto.getPrpLregistDto().getRiskCode()) > -1)){
   	 String settlelistcode="";
		 BLSettlemainlistFacade blSettlemainlistFacade=new BLSettlemainlistFacade();
		 String str=" reportcode='"+registDto.getPrpLregistDto().getRegistNo()+"'";
		 ArrayList arr=(ArrayList)blSettlemainlistFacade.findByConditions(str);
		 SettlemainlistDto settlemainlistDto=new SettlemainlistDto();
		 if(arr.size()>0){
		   settlemainlistDto=(SettlemainlistDto)arr.get(0);
		   settlelistcode=settlemainlistDto.getSettlelistcode();
   	     String condition="update plantingSettlelist set validity='4' where settlelistcode='"+settlelistcode+"' and validity='1'";
		 String condition1="update settlemainlist set validity='4' where reportcode='"+registDto.getPrpLregistDto().getRegistNo()+"' and validity='2'";
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
    if("3224,3201,3204,3238,3228,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(registDto.getPrpLregistDto().getRiskCode()) > -1)
    {
    	 String settlelistcode="";
		 BLSettlemainlistFacade blSettlemainlistFacade=new BLSettlemainlistFacade();
		 String str=" reportcode='"+registDto.getPrpLregistDto().getRegistNo()+"'";
		 ArrayList arr=(ArrayList)blSettlemainlistFacade.findByConditions(str);
		 SettlemainlistDto settlemainlistDto=new SettlemainlistDto();
		 if(arr.size()>0){
		   settlemainlistDto=(SettlemainlistDto)arr.get(0);
		   settlelistcode=settlemainlistDto.getSettlelistcode();
   	     String condition="update nyxSettlelist set validity='4' where settlelistcode='"+settlelistcode+"' and validity='1'";
		 String condition1="update settlemainlist set validity='4' where reportcode='"+registDto.getPrpLregistDto().getRegistNo()+"' and validity='2'";
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
    if("2801".indexOf(registDto.getPrpLregistDto().getRiskCode()) > -1 || "2607".indexOf(registDto.getPrpLregistDto().getRiskCode()) > -1 || "2605".indexOf(registDto.getPrpLregistDto().getRiskCode()) > -1 || "2606".indexOf(registDto.getPrpLregistDto().getRiskCode()) > -1|| "2609".indexOf(registDto.getPrpLregistDto().getRiskCode()) > -1)
    {
    	 String settlelistcodemedical="";
    	 BLSettlemainlistFacadeForMedical blSettlemainlistFacadeForMedical=new BLSettlemainlistFacadeForMedical();
		 String str=" reportcode='"+registDto.getPrpLregistDto().getRegistNo()+"'";
		 ArrayList arr=(ArrayList)blSettlemainlistFacadeForMedical.findByConditions(str);
		 SettlemainlistDto settlemainlistDto=new SettlemainlistDto();
		 if(arr.size()>0){
		   settlemainlistDto=(SettlemainlistDto)arr.get(0);
		   settlelistcodemedical=settlemainlistDto.getSettlelistcode();
  	     String condition="update medicalSettlelist set validity='4' where settlelistcode='"+settlelistcodemedical+"' and validity='1'";
		 String condition1="update settlemainlist set validity='4' where reportcode='"+registDto.getPrpLregistDto().getRegistNo()+"' and validity='2'";
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
    //报案注销时，不对耳标号进行操作 BY GYIC 冯雷 20110811 Start！
    //耳标号报案注销
//    if(registDto.getPrpLearDtoList().size()>0){
//	        statement =  " update prplear set validstatus='0' Where  registNo = '" + StringUtils.rightTrim(registNo) + "'";
//	        dbManager.executeUpdate(statement);
//    } 

    //报案注销时，不对耳标号进行操作 BY GYIC 冯雷 20110811 End！
    
    //保存报案注销原因
    String condition = " registNo = '" + StringUtils.rightTrim(registNo) + "' and texttype='2'";
    statement =  " DELETE FROM PrpLregistText Where " + condition;
    dbManager.executeUpdate(statement);
    
    if(registDto.getPrpLregistTextDtoList()!=null)
    {    
        for (int i =0;i<registDto.getPrpLregistTextDtoList().size() ;i++){
        	
        	 //System.out.println("RegistNo"+((PrpLregistTextDto)((ArrayList)registDto.getPrpLregistTextDtoList()).get( i)).getRegistNo());
           	 //System.out.println("LineNo"+((PrpLregistTextDto)((ArrayList)registDto.getPrpLregistTextDtoList()).get( i)).getLineNo());
           	 //System.out.println("TextType"+((PrpLregistTextDto)((ArrayList)registDto.getPrpLregistTextDtoList()).get( i)).getTextType());
         	 //System.out.println("Context"+((PrpLregistTextDto)((ArrayList)registDto.getPrpLregistTextDtoList()).get( i)).getContext ());
             
        }
    
        new DBPrpLregistText(dbManager).insertAll(registDto.getPrpLregistTextDtoList());
    }
    //加入报案关联表的关联
    if(registDto.getPrpLRegistRPolicyList()!=null)
    {
    	for(int i=0;i<registDto.getPrpLRegistRPolicyList().size();i++){
        new DBPrpLRegistRPolicy(dbManager).update ((PrpLRegistRPolicyDto)registDto.getPrpLRegistRPolicyList().get(i));
    	}
    }
    //加入报案关联表的关联
    if(registDto.getPrpLRegistRPolicyDto()!=null)
    {
        new DBPrpLRegistRPolicy(dbManager).update (registDto.getPrpLRegistRPolicyDto());
        //处理如果注销掉的是主报案上的保单号这种情况，需要批量进行保单号码的代换，比较麻烦的。
        
        if (registDto.getPrpLRegistRPolicyDto().getPolicyNo().equals(registDto.getPrpLregistDto().getPolicyNo()) ){
        	//1。取出PrpLRegistRPolicy还算有效的PolicyNo进行替换.
        	
        	//替换的表很多。从报案开始。。(报案，调度，查勘，定损，工作流。。等等。。6月22日完成这部分的代码)
        	
        }
    }
    //修改记录
    if(registDto.getPrplregisthisDto() != null){
    	new DBPrplregisthis(dbManager).insert(registDto.getPrplregisthisDto());
    }
  }
  
}
