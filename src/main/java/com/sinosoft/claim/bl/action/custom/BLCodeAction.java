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
 * �����ѯ�߼�
 * <p>
 * Title: ��������
 * </p>
 * <p>
 * Description: ��������
 * </p>
 * <p>
 * Copyright: Copyright (c) 2003
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 *
 * @author ��Ŀ��
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
        try { //���Ŵ���
            if (codetype.equals("ComCode")) {
                DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
                collection = dbPrpDcompany.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }
            
            //�ұ�
            if (codetype.equals("CurrencyCode")) {
                DBPrpDcurrency dbPrpDcurrency = new DBPrpDcurrency(dbManager);
                collection = dbPrpDcurrency.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }
            //����
            if (codetype.equals("KindCode")) {
                DBPrpDkind dbPrpDkind = new DBPrpDkind(dbManager);
                collection = dbPrpDkind.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }
            //����
            if (codetype.equals("ClauseCode")) {
                DBPrpDclause dbPrpDclause = new DBPrpDclause(dbManager);
                collection = dbPrpDclause.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }
            //����ԭ�򣬳������򣬳������ͣ���֤,��������,���ִ���
            if (codetype.equals("DamageCode") || codetype.equals("DamageAreaCode") || codetype.equals("DamageTypeCode")
                    || codetype.equals("DocCode") || codetype.equals("BackVisitCode") || codetype.equals("CaseCode")
                    || codetype.equals("InjueryGrade") || codetype.equals("CatastropheCode") ||codetype.equals("AcciCheckChargeType"))
            {

                DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);
                //���ڳ���ԭ����Ҫ����������⴦��
                if(codetype.equals("DamageCode")){
                	collection=dbPrpDcode.findByConditionsReason(conditions, pageNo, rowsPerPage);
                	return collection;
                }
                collection = dbPrpDcode.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }
            //�Ӱ��� ������
            if (codetype.equals("HanderCode")) {
                DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
                collection = dbPrpDuser.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }
            //�¹ʴ�����
            if (codetype.equals("HandleUnit")) {
                DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
                collection = dbPrpDcompany.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }
            //�б���˾
            if (codetype.equals("InsureComCode")) {
                DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
                collection = dbPrpDcompany.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }

            //����Ͷ���ձ�,���ݴ�������������Էֳ�DAA���������ֵ����
            //modify by chenrenda begin 20070706
            //reason:������ŵ������޸�
            if (codetype.equals("PolicyKindCode")) {
                DBPrpCitemKind dbPrpCitemKind = new DBPrpCitemKind(dbManager);
                collection = dbPrpCitemKind.findByConditions(conditions, pageNo, rowsPerPage);
               
                //reason:���ڳб��ձ𣬴��ڳб�ͬһ�ձ����β�ͬ����£�Ӧ���ÿͻ�����ѡ����Ӧ�б�����
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
            //��������,���ݴ�������������Էֳ�DAA���������ֵ����
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
            //���ô���,���յص�
            if (codetype.equals("ChargeCode") || codetype.equals("DamageAddress") || codetype.equals("CompCode")
                    || codetype.equals("HandleUnitCar")) {
                DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);
                collection = dbPrpDcode.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }

            //�鿱����

            if (codetype.equals("ScheduleObject")) {
                DBPrpLscheduleObject dbPrpLscheduleObject = new DBPrpLscheduleObject(dbManager);
                collection = dbPrpLscheduleObject.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }

            //�ͻ�����
            if (codetype.equals("CustomerUnit")) {
                DBPrpDcustomerUnit dBPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);
                collection = dBPrpDcustomerUnit.findByConditions(conditions, pageNo, rowsPerPage);
                return collection;
            }
            //������������ϸ
            if(codetype.equals("PrpDliab"))
            {
            	//modify by chenrenda begin 20070705
            	//reason:������ϸ�������ֺͳб��ձ��ȡ
            	DBPrpLkindItem dbPrpLkindItem = new DBPrpLkindItem(dbManager);
            	collection = dbPrpLkindItem.findByConditions(conditions,pageNo,rowsPerPage);
                //modify by chenrenda end 20070705
            	return collection;
            }
            
            //֧������ѡ��
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
            //add by qinyongli start 2005-9-4 ���û��ָ�����ͣ�Ĭ�ϴ�prpdcode���в�������
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
     * ����ҵ�����ͼ����ֲ�ѯҵ�����
     *
     * @param codetype��ҵ������
     * @param riskcode�����ִ���
     * @return PrpDcodeDto �����ѯ
     * @throws SQLException
     * @throws Exception
     */

    public Collection getCodeType(String codetype, String riskcode) throws Exception {
        Collection collection = null;
        if (codetype == null)
            throw new Exception();
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        String conditions = ""; //��ѯ����
        try {
            conditions = " codetype = '" + codetype
                    + "' AND validstatus = '1' AND codecode in (SELECT codecode FROM prpdcoderisk WHERE codetype = '"
                    + codetype + "' AND (riskcode = '" + riskcode + "' OR riskcode = '0000'))";
            DBPrpDcode dbPrpDcode = new DBPrpDcode(dbManager);    
            //add by lixiang start at 2006-01-25
            //���ӵ�֤���Ͱ���codecode��������Ĺ���
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
     * �������������б�
     * @return Collection �����ѯ
     * @throws SQLException
     * @throws Exception
     */
    public Collection getDeductCondition(String riskCode) throws Exception{
    	String conditions = " codecode in (select codecode from prpdcoderisk where riskcode = '"+riskCode+"' and codetype = 'DeductCond') and ValidStatus='1' and codetype = 'DeductCond'"; 
    	return this.findByConditions("DeductCond",conditions,0,0);
    }

    
    /**
     * ���ݿͻ������ѯ�ͻ����
     * @param  customerCode���ͻ�����
     * @return  �ͻ����
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
    * ���ݻ��������ѯ��������
    * @param  comCode����������
    * @return  ��������
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
     * ����User����
     *
     * @param dbManager ���ݿ����
     * @param userCode �û�����
     * @param isChinese �����ı�ʶ
     * @throw Exception
     * @return �������ַ������Ļ�Ӣ������
     */

    public String translateUserCode(DBManager dbManager, String userCode, boolean isChinese) throws SQLException,
            Exception {
        String codeName = ""; //��ѯ��������
        codeName = new DBPrpDuser(dbManager).translateCode(userCode, isChinese);
        return codeName;
    }

    /**
     * ����Code����
     *
     * @param dbManager ���ݿ����
     * @param codeType �û�����
     * @param codeCode �û�����
     * @param isChinese �����ı�ʶ
     * @throw SQLException,Exception
     * @return �������ַ������Ļ�Ӣ������
     */

    public String translateCodeCode(DBManager dbManager, String codeType, String codeCode, boolean isChinese)
            throws SQLException, Exception {
        String codeName = ""; //��ѯ��������
        codeName = new DBPrpDcode(dbManager).translateCode(codeType, codeCode, isChinese);
        return codeName;
    }
    
    public String translateLimit(DBManager dbManager, String riskCode, String limitCode, boolean isChinese)
    throws SQLException, Exception {
      String limitName = ""; //��ѯ��������
      limitName = new DBPrpDlimit(dbManager).translateLimit(riskCode, limitCode, isChinese);
      return limitName;
     }
    /**
     * �������֣���Ĵ����ѯ�������
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
        String codeName = ""; //��ѯ��������
        codeName = new DBPrpDitem(dbManager).translateCode(riskCode, itemCode, isChinese);
        return codeName;

    }
    
    /**
     * �������֣����մ����ѯ����
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
        String codeName = ""; //��ѯ��������
        codeName = new DBPrpDkind(dbManager).translateCode(riskCode, kindCode, isChinese);
        return codeName;

    }

    /**
     * �������ֲ�ѯ����
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
        String codeName = ""; //��ѯ��������
        codeName = new DBPrpDrisk(dbManager).translateCode(riskCode, isChinese);
        return codeName;

    }

    /**
     * ���ݱұ����õ��ұ�����
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
        String codeName = ""; //��ѯ��������
        codeName = new DBPrpDcurrency(dbManager).translateCode(currencyCode, isChinese);
        return codeName;

    }
    /**
     * ���ݹ�˾����õ���˾����
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
        String codeName = ""; //��ѯ��������
        codeName = new DBPrpDcompany(dbManager).translateCode(comCode, isChinese);
        return codeName;

    }

    /**
     * ���ݹ���������ѯ�Ḷ��˾��Ϣ
     *
     * @param comcode��������������
     * @return PrpDcompanyDto ��������
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
     * ���ݱ��������ѯ��Ӧ���ⰸ����
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
        String codeName = ""; //��ѯ��������
        codeName = new DBPrpLclaim(dbManager).translateCode(currencyCode, isChinese);
        return codeName;

    }

    /**
     * ����ҵ�����ͼ����ֲ�ѯҵ�����
     *
     * @param registNo ������
     * @return Collection �����ѯ
     * @throws SQLException
     * @throws Exception
     */

    public Collection getLicenseNoList(String registNo) throws Exception {
        Collection collection = null;
        if (registNo == null)
            throw new Exception();
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        String conditions = ""; //��ѯ����
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
     * ���ػ������ƣ������б�
     *
     * @return Collection �����ѯ
     * @throws SQLException
     * @throws Exception
     */

    public Collection getCurrencyList() throws Exception {
        Collection collection = null;
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        String conditions = " 1=1 "; //��ѯ����
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
     * �������֣����մ����ѯ�����ܱ����־
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
        String codeName = ""; //��ѯ��������
        codeName = new DBPrpDkind(dbManager).translateCalculateFlag(riskCode, kindCode);
        return codeName;

    }

    //modify by wangli add start 20050416
    /**
     * ���ݴ����˴���õ�����������
     *
     * @param dbManager DBManager
     * @param agentCode �����˴���
     * @throws SQLException
     * @throws Exception
     * @return String
     */
    public String translateAgentName(DBManager dbManager, String agentCode) throws SQLException, Exception {
        String agentName = ""; //��ѯ��������
        agentName = new DBPrpDagent(dbManager).translateAgentName(agentCode);
        return agentName;

    }
    // modify by wangli add end 20050416

    /**
     * ���ݿͻ�����õ��ͻ�����
     *
     * @param agentCode �ͻ�����
     */
    public String translateCustomerCName(DBManager dbManager, String customerCode) throws SQLException, Exception {
        String customerCName = ""; //��ѯ��������
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