package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;

import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCitemKind;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDagent;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcarModel;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDclause;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcode;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcompany;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcurrency;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcustomerUnit;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDkind;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDlimit;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDrisk;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDuser;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaim;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLkindItem;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayObject;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleObject;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdParty;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDitem;
import com.sinosoft.platform.dto.domain.PrpDcustomerDto;
import com.sinosoft.platform.resource.dtofactory.domain.DBPrpDcustomer;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 代码查询逻辑
 * <p>
 * Title: 车险理赔
 * </p>
 * <p>
 * Description: 车险理赔
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 *
 * @author 项目组
 * @version 1.0
 */
public class BLCodeAction {
    public BLCodeAction() {
    }

    public Collection findByConditions(String codetype, String conditions, int pageNo, int rowsPerPage)
            throws Exception {
        Collection collection = null;
        if (codetype == null)
            throw new Exception();
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        try { //部门代码
            if (codetype.equals("ComCode")) {
                DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
                collection = dbPrpDcompany.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }
            
            //币别
            if (codetype.equals("CurrencyCode")) {
                DBPrpDcurrency dbPrpDcurrency = new DBPrpDcurrency(dbManager);
                collection = dbPrpDcurrency.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }
            //险种
            if (codetype.equals("KindCode")) {
                DBPrpDkind dbPrpDkind = new DBPrpDkind(dbManager);
                collection = dbPrpDkind.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }
            //条款
            if (codetype.equals("ClauseCode")) {
                DBPrpDclause dbPrpDclause = new DBPrpDclause(dbManager);
                collection = dbPrpDclause.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }
            //出险原因，出险区域，出险类型，单证,案件性质,巨灾代码
            if (codetype.equals("DamageCode") || codetype.equals("DamageAreaCode") || codetype.equals("DamageTypeCode")
                    || codetype.equals("DocCode") || codetype.equals("BackVisitCode") || codetype.equals("CaseCode")
                    || codetype.equals("InjueryGrade") || codetype.equals("CatastropheCode") ||codetype.equals("AcciCheckChargeType"))
            {

                DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);
                //由于出险原因需要排序，因此特殊处理
                if(codetype.equals("DamageCode")){
                	collection=dbPrpDcode.findByConditionsReason(conditions, pageNo, rowsPerPage);
                	return collection;
                }
                collection = dbPrpDcode.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }
            //接案人 经办人
            if (codetype.equals("HanderCode")) {
                DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
                collection = dbPrpDuser.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }
            //事故处理部门
            if (codetype.equals("HandleUnit")) {
                DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
                collection = dbPrpDcompany.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }
            //承保公司
            if (codetype.equals("InsureComCode")) {
                DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
                collection = dbPrpDcompany.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }

            //保单投保险别,根据传入的条件，可以分成DAA或其他险种的类别
            //modify by chenrenda begin 20070706
            //reason:意键险团单理赔修改
            if (codetype.equals("PolicyKindCode")) {
                DBPrpCitemKind dbPrpCitemKind = new DBPrpCitemKind(dbManager);
                collection = dbPrpCitemKind.findByConditions(conditions, pageNo, rowsPerPage);
               
                //reason:对于承保险别，存在承保同一险别但责任不同情况下，应该让客户自已选择相应承保责任
                /*
                HashMap itemKindHash = new LinkedHashMap();
                for (Iterator iter = tempCollection.iterator(); iter.hasNext();) {
                    PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) iter.next();
                    if (!itemKindHash.containsKey(prpCitemKindDto.getKindCode())) {
                        itemKindHash.put(prpCitemKindDto.getKindCode(), prpCitemKindDto);
                    }
                }
                */
                return collection;
            }
            if (codetype.equals("AcciPolicyKindCode")) {
            	DBPrpCitemKind dbPrpCitemKind = new DBPrpCitemKind(dbManager);
                Collection tempCollection = dbPrpCitemKind.findByConditions(conditions, pageNo, rowsPerPage);
                HashMap itemKindHash = new LinkedHashMap();
                for (Iterator iter = tempCollection.iterator(); iter.hasNext();) {
                    PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) iter.next();
                    if (!itemKindHash.containsKey(prpCitemKindDto.getKindCode())) {
                        itemKindHash.put(prpCitemKindDto.getKindCode(), prpCitemKindDto);
                    }
                }
                collection = itemKindHash.values();
                return collection;
            }
            //modify by chenrenda end 20070706 
            //保单责任,根据传入的条件，可以分成DAA或其他险种的类别
            if (codetype.equals("PolicyItemCode")) {
                DBPrpCitemKind dbPrpCitemKind = new DBPrpCitemKind(dbManager);
                Collection tempCollection = dbPrpCitemKind.findByConditions(conditions, pageNo, rowsPerPage);
                Hashtable itemKindHash = new Hashtable();
                for (Iterator iter = tempCollection.iterator(); iter.hasNext();) {
                    PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) iter.next();
                    if (!itemKindHash.containsKey(prpCitemKindDto.getItemCode()+prpCitemKindDto.getItemDetailName())) {
                        itemKindHash.put(prpCitemKindDto.getItemCode()+prpCitemKindDto.getItemDetailName(), prpCitemKindDto);
                    }
                }
                collection = itemKindHash.values();
                return collection;
            }
            //费用代码,出险地点
            if (codetype.equals("ChargeCode") || codetype.equals("DamageAddress") || codetype.equals("CompCode")
                    || codetype.equals("HandleUnitCar")) {
                DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);
                collection = dbPrpDcode.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }

            //查勘对象

            if (codetype.equals("ScheduleObject")) {
                DBPrpLscheduleObject dbPrpLscheduleObject = new DBPrpLscheduleObject(dbManager);
                collection = dbPrpLscheduleObject.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }

            //客户资料
            if (codetype.equals("CustomerUnit")) {
                DBPrpDcustomerUnit dBPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);
                collection = dBPrpDcustomerUnit.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }
            //意外险责任明细
            if(codetype.equals("PrpDliab"))
            {
            	//modify by chenrenda begin 20070705
            	//reason:责任明细根据险种和承保险别获取
            	DBPrpLkindItem dbPrpLkindItem = new DBPrpLkindItem(dbManager);
            	collection = dbPrpLkindItem.findByConditions(conditions,pageNo,rowsPerPage);
                //modify by chenrenda end 20070705
            	return collection;
            }
            
            //支付对象选择
            if(codetype.equals("PayObject"))
            {
            	
            	DBPrpLpayObject  dbPrpLpayObject = new DBPrpLpayObject(dbManager);
            	collection = dbPrpLpayObject.findByConditions(conditions,pageNo,rowsPerPage);
            	return collection;
            }
            
            //--------------------------------
            
            if(codetype.equals("ModelCode"))
            {
            	DBPrpDcarModel  dbPrpDcarModel = new DBPrpDcarModel(dbManager);
            	collection = dbPrpDcarModel.findByConditions(conditions,pageNo,rowsPerPage);
            	return collection;
            }
            
            //-------------------------------------
            //add by qinyongli start 2005-9-4 如果没有指明类型，默认从prpdcode表中查找数据
//          DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);
//          collection = dbPrpDcode.findByConditions(conditions, pageNo, rowsPerPage);
            //
            DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);
            String conditionAll = "1=1";
            if(codetype!=null&&codetype.length()>0){            	
            	conditionAll += " and codeType = '"+codetype+"'" ;
            }
            if(conditions!=null&&conditions.length()>0){
            	int orderIndex = conditions.toLowerCase().indexOf("order");
            	if(orderIndex==0){
            		conditionAll += conditions;
            	}else if (orderIndex>0){
            		conditionAll += " and ("+conditions.substring(0,orderIndex)+") "+conditions.substring(orderIndex);
            	}else{
            		conditionAll += " and ("+conditions+")";
            	}

            }
            
            collection = dbPrpDcode.findByConditions(conditionAll, pageNo, rowsPerPage);
            //add by qinyongli end 
        } catch (Exception ex) {
            throw ex;
        } finally {
            dbManager.close();
        }
        return collection;
    }

    /**
     * 根据业务类型及险种查询业务代码
     *
     * @param codetype：业务类型
     * @param riskcode：险种代码
     * @return PrpDcodeDto 代码查询
     * @throws SQLException
     * @throws Exception
     */

    public Collection getCodeType(String codetype, String riskcode) throws Exception {
        Collection collection = null;
        if (codetype == null)
            throw new Exception();
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        String conditions = ""; //查询条件
        try {
            conditions = " codetype = '" + codetype
                    + "' AND validstatus = '1' AND codecode in (SELECT codecode FROM prpdcoderisk WHERE codetype = '"
                    + codetype + "' AND (riskcode = '" + riskcode + "' OR riskcode = '0000'))";
            DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);    
            //add by lixiang start at 2006-01-25
            //增加单证类型按照codecode进行排序的功能
            if ("ImageType".equals(codetype)){
            	
             conditions =	conditions +" order by codecode";
            }
            //add by lixiang end at 2006-01-25
            
            collection = dbPrpDcode.findByConditions(conditions, 0, 0);
        } catch (Exception ex) {
            throw ex;
        } finally {
            dbManager.close();
        }
        return collection;
    }
    
    /**
     * 返回免赔条件列表
     * @return Collection 代码查询
     * @throws SQLException
     * @throws Exception
     */
    public Collection getDeductCondition(String riskCode) throws Exception{
    	String conditions = " codecode in (select codecode from prpdcoderisk where riskcode = '"+riskCode+"' and codetype = 'DeductCond') and ValidStatus='1' and codetype = 'DeductCond'"; 
    	return this.findByConditions("DeductCond",conditions,0,0);
    }

    
    /**
     * 根据客户代码查询客户类别
     * @param  customerCode：客户代码
     * @return  客户类别
     * @throws SQLException
     * @throws Exception
     */
   public String getCustomerType(String customerCode)
       throws Exception
   {
   	String customerType = "";
   	DBManager dbManager = new DBManager();
   	
   	try {    
	    dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	
	    PrpDcustomerDto prpDcustomerDto = null;
	   	DBPrpDcustomer dbPrpDcustomer = new DBPrpDcustomer(dbManager);
	   	
	   	prpDcustomerDto = dbPrpDcustomer.findByPrimaryKey(customerCode);
	   	
	   	if (prpDcustomerDto != null) {
	       	customerType = prpDcustomerDto.getCustomerType().trim();
	   	}
    } catch (Exception ex) {
        throw ex;
    } finally {
        dbManager.close();
    }
    
   	return customerType;
   }
   
   /**
    * 根据机构代码查询机构级别
    * @param  comCode：机构代码
    * @return  机构级别
    * @throws SQLException
    * @throws Exception
    */
  public String getComLevel(String comCode)
      throws Exception
  {
  	String comLevel = "";
  	DBManager dbManager = new DBManager();
  	
  	try {    
	    dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	
	    PrpDcompanyDto prpDcompanyDto = null;
	   	DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
	   	
	   	prpDcompanyDto = dbPrpDcompany.findByPrimaryKey(comCode);
	   	
	   	if (prpDcompanyDto != null) {
	       	comLevel = prpDcompanyDto.getComLevel().trim();
	   	}
   } catch (Exception ex) {
       throw ex;
   } finally {
       dbManager.close();
   }
   
  	return comLevel;
  }
  
   /**
     * 翻译User代码
     *
     * @param dbManager 数据库管理
     * @param userCode 用户代码
     * @param isChinese 中外文标识
     * @throw Exception
     * @return 根据语种返回中文或英文名称
     */

    public String translateUserCode(DBManager dbManager, String userCode, boolean isChinese) throws SQLException,
            Exception {
        String codeName = ""; //查询到的名称
        codeName = new DBPrpDuser(dbManager).translateCode(userCode, isChinese);
        return codeName;
    }

    /**
     * 翻译Code代码
     *
     * @param dbManager 数据库管理
     * @param codeType 用户代码
     * @param codeCode 用户代码
     * @param isChinese 中外文标识
     * @throw SQLException,Exception
     * @return 根据语种返回中文或英文名称
     */

    public String translateCodeCode(DBManager dbManager, String codeType, String codeCode, boolean isChinese)
            throws SQLException, Exception {
        String codeName = ""; //查询到的名称
        codeName = new DBPrpDcode(dbManager).translateCode(codeType, codeCode, isChinese);
        return codeName;
    }
    
    public String translateLimit(DBManager dbManager, String riskCode, String limitCode, boolean isChinese)
    throws SQLException, Exception {
      String limitName = ""; //查询到的名称
      limitName = new DBPrpDlimit(dbManager).translateLimit(riskCode, limitCode, isChinese);
      return limitName;
     }
    /**
     * 根据险种，标的代码查询标的名称
     *
     * @param dbManager DBManager
     * @param riskCode String
     * @param kindCode String
     * @param isChinese boolean
     * @throws SQLException
     * @throws Exception
     * @return String
     */
    public String translateItemCode(DBManager dbManager, String riskCode, String itemCode, boolean isChinese)
            throws SQLException, Exception {
        String codeName = ""; //查询到的名称
        codeName = new DBPrpDitem(dbManager).translateCode(riskCode, itemCode, isChinese);
        return codeName;

    }
    
    /**
     * 根据险种，子险代码查询名称
     *
     * @param dbManager DBManager
     * @param riskCode String
     * @param kindCode String
     * @param isChinese boolean
     * @throws SQLException
     * @throws Exception
     * @return String
     */
    public String translateKindCode(DBManager dbManager, String riskCode, String kindCode, boolean isChinese)
            throws SQLException, Exception {
        String codeName = ""; //查询到的名称
        codeName = new DBPrpDkind(dbManager).translateCode(riskCode, kindCode, isChinese);
        return codeName;

    }

    /**
     * 根据险种查询名称
     *
     * @param dbManager DBManager
     * @param riskCode String
     * @param isChinese boolean
     * @throws SQLException
     * @throws Exception
     * @return String
     */
    public String translateRiskCode(DBManager dbManager, String riskCode, boolean isChinese) throws SQLException,
            Exception {
        String codeName = ""; //查询到的名称
        codeName = new DBPrpDrisk(dbManager).translateCode(riskCode, isChinese);
        return codeName;

    }

    /**
     * 根据币别代码得到币别名称
     *
     * @param dbManager DBManager
     * @param currencyCode String
     * @param isChinese boolean
     * @throws SQLException
     * @throws Exception
     * @return String
     */
    public String translateCurrencyCode(DBManager dbManager, String currencyCode, boolean isChinese)
            throws SQLException, Exception {
        String codeName = ""; //查询到的名称
        codeName = new DBPrpDcurrency(dbManager).translateCode(currencyCode, isChinese);
        return codeName;

    }
    /**
     * 根据公司代码得到公司名称
     *
     * @param dbManager DBManager
     * @param comCode String
     * @param isChinese boolean
     * @throws SQLException
     * @throws Exception
     * @return String
     */
    public String translateComCode(DBManager dbManager, String comCode, boolean isChinese) throws SQLException,
            Exception {
        String codeName = ""; //查询到的名称
        codeName = new DBPrpDcompany(dbManager).translateCode(comCode, isChinese);
        return codeName;

    }

    /**
     * 根据归属机构查询结付公司信息
     *
     * @param comcode：归属机构代码
     * @return PrpDcompanyDto 归属机构
     * @throws SQLException
     * @throws Exception
     */

    public PrpDcompanyDto getPayInfo(String comcode) throws Exception {
        int ilevel = 8;
        StringBuffer sbCalComCode = null;
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        PrpDcompanyDto prpDcompanyDto = new PrpDcompanyDto();
        DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
        int iFlag = 0;
        try {
            for (int i = ilevel; i > 0; i--) {
                sbCalComCode = new StringBuffer("00000000");
                sbCalComCode.replace(0, ilevel, comcode.substring(0, ilevel));
                String strCalComCode = new String(sbCalComCode);
                prpDcompanyDto = dbPrpDcompany.findByPrimaryKey(strCalComCode);
                if (prpDcompanyDto != null) {
                    iFlag = 1;
                    break;
                } else {
                    ilevel = ilevel - 2;
                }
            }
            if (iFlag == 1) {
                return prpDcompanyDto;
            } else {
                return null;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            dbManager.close();
        }
    }

    /**
     * 根据报案号码查询对应的赔案号码
     *
     * @param dbManager DBManager
     * @param currencyCode String
     * @param isChinese boolean
     * @throws SQLException
     * @throws Exception
     * @return String
     */
    public String translateBusinessCode(DBManager dbManager, String currencyCode, boolean isChinese)
            throws SQLException, Exception {
        String codeName = ""; //查询到的名称
        codeName = new DBPrpLclaim(dbManager).translateCode(currencyCode, isChinese);
        return codeName;

    }

    /**
     * 根据业务类型及险种查询业务代码
     *
     * @param registNo 报案号
     * @return Collection 代码查询
     * @throws SQLException
     * @throws Exception
     */

    public Collection getLicenseNoList(String registNo) throws Exception {
        Collection collection = null;
        if (registNo == null)
            throw new Exception();
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        String conditions = ""; //查询条件
        try {
            conditions = " registNo = '" + registNo + "'";
            DBPrpLthirdParty dbPrpLthirdParty = new DBPrpLthirdParty(dbManager);
            collection = dbPrpLthirdParty.findByConditions(conditions, 0, 0);
        } catch (Exception ex) {
            throw ex;
        } finally {
            dbManager.close();
        }
        return collection;
    }

    /**
     * 返回货币名称，代码列表
     *
     * @return Collection 代码查询
     * @throws SQLException
     * @throws Exception
     */

    public Collection getCurrencyList() throws Exception {
        Collection collection = null;
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        String conditions = " 1=1 "; //查询条件
        try {
            DBPrpDcurrency dbPrpDcurrency = new DBPrpDcurrency(dbManager);
            collection = dbPrpDcurrency.findByConditions(conditions, 0, 0);
        } catch (Exception ex) {
            throw ex;
        } finally {
            dbManager.close();
        }
        return collection;
    }
    /**
     * 根据险种，子险代码查询计入总保额标志
     *
     * @param dbManager DBManager
     * @param riskCode String
     * @param kindCode String
     * @throws SQLException
     * @throws Exception
     * @return String
     */
    public String translateCalculateFlag(DBManager dbManager, String riskCode, String kindCode) throws SQLException,
            Exception {
        String codeName = ""; //查询到的名称
        codeName = new DBPrpDkind(dbManager).translateCalculateFlag(riskCode, kindCode);
        return codeName;

    }

    //modify by wangli add start 20050416
    /**
     * 根据代理人代码得到代理人姓名
     *
     * @param dbManager DBManager
     * @param agentCode 代理人代码
     * @throws SQLException
     * @throws Exception
     * @return String
     */
    public String translateAgentName(DBManager dbManager, String agentCode) throws SQLException, Exception {
        String agentName = ""; //查询到的名称
        agentName = new DBPrpDagent(dbManager).translateAgentName(agentCode);
        return agentName;

    }
    // modify by wangli add end 20050416

    /**
     * 根据客户代码得到客户姓名
     *
     * @param agentCode 客户代码
     */
    public String translateCustomerCName(DBManager dbManager, String customerCode) throws SQLException, Exception {
        String customerCName = ""; //查询到的名称
        customerCName = new DBPrpDcustomerUnit(dbManager).translateCustomerCName(customerCode);
        return customerCName;

    }

   

    public Collection findByConditions(String conditions) throws Exception {
        Collection collection = null;
        if (conditions == null)
            throw new Exception();
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
         try {
           DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);
            collection = dbPrpDcode.findByConditions(conditions, 0, 0);
        } catch (Exception ex) {
            throw ex;
        } finally {
            dbManager.close();
        }
        return collection;
    }

}