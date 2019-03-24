package com.sinosoft.claim.query.ui.control.actioin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.claim.dto.domain.PrpDriskDto;
import com.sinosoft.claim.dto.domain.UtiCodeTransferDto;
import com.sinosoft.claim.ui.model.AgentNameTranslateAgentCodeCommand;
import com.sinosoft.claim.ui.model.CodeFindByCodeTypeCommand;
import com.sinosoft.claim.ui.model.CodeFindByCondCommand;
import com.sinosoft.claim.ui.model.CodeFindByConditionsCommand;
import com.sinosoft.claim.ui.model.CodeFindByLicenseNoCommand;
import com.sinosoft.claim.ui.model.CodeGetComLevelCommand;
import com.sinosoft.claim.ui.model.CodeGetCustomerTypeCommand;
import com.sinosoft.claim.ui.model.CodeTranslateBusinessCodeCommand;
import com.sinosoft.claim.ui.model.CodeTranslateCalculateFlagCommand;
import com.sinosoft.claim.ui.model.CodeTranslateCodeCodeCommand;
import com.sinosoft.claim.ui.model.CodeTranslateComCodeCommand;
import com.sinosoft.claim.ui.model.CodeTranslateCurrencyCodeCommand;
import com.sinosoft.claim.ui.model.CodeTranslateItemCodeCommand;
import com.sinosoft.claim.ui.model.CodeTranslateKindCodeCommand;
import com.sinosoft.claim.ui.model.CodeTranslateLimitCommand;
import com.sinosoft.claim.ui.model.CodeTranslateRiskCodeCommand;
import com.sinosoft.claim.ui.model.CodeTranslateUserCodeCommand;
import com.sinosoft.claim.ui.model.ComCodeRecursionCommand;
import com.sinosoft.claim.ui.model.PrpDcurrencyFindByConditionsCommand;
import com.sinosoft.claim.ui.model.PrpDriskFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.UtiCodeTransferFindByConditionsCommand;
import com.sinosoft.claim.ui.model.UtiCodeTransferFindByPrimaryKeyCommand;

/**
 * �����ѯ�߼�
 * <p>Title: ��������</p>
 * <p>Description: ����������������</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author ��Ŀ��
 * @version 1.0
 */
public class UICodeAction{
	private static UICodeAction uiCodeAction= new UICodeAction();
	public static UICodeAction getInstance(){
		return uiCodeAction;
	}
	public static String COMCODE="ComCode";                //���Ż���
	public static String CURRENCYCODE = "CurrencyCode";    //�ұ�
	public static String KINDCODE = "KindCode";            //�ձ�
	public static String CLAUSECODE = "ClauseCode";        //����
	public static String REINSCODE = "ReinsCode";          //����
	public static String DAMAGECODE="DamageCode";          //����ԭ��
	public static String DAMAGEAREACODE="DamageAreaCode";  //��������
	public static String DAMAGETYPECODE = "DamageTypeCode";//�¹�����
	public static String HANDLERCODE="HandlerCode";        //������
	public static String DOCCODE="DocCode";                //��֤����
	public static String HANDERCODE="HanderCode";          //�Ӱ��� ������
	public static String HANDLEUNIT="HandleUnit";          //�¹ʴ�����
	public static String INSURECOMCODE="InsureComCode" ;   //�б���˾
	public static String POLICYKINDCODE="PolicyKindCode";  //����Ͷ���ձ�����prpcitemkind
	public static String POLICYITEMCODE="PolicyItemCode";  //������������prpcitemkind
	public static String CHARGECODE="ChargeCode" ;         //���ô���
	public static String CHARGECODE1="ChargeCode" ;         //���ô���
	public static String DAMAGEADDRESS="DamageAddress";    //���յص�
	public static String SCHEDULEOBJECT="ScheduleObject";    //���յص�
	public static String COMPCODE="CompCode";                //��ʧ����
	public static String BUSINESSSOURCE="BusinessSource";    //������ҵ
	public static String DAMAGEDISTRICT="DamageDistrict";    //���ڵ���
	public static String POLICYKINDCODEFORPERSON="PolicyKindCodeForPerson";    //����Ͷ���ձ�
	public static String POLICYKINDCODEFORPROP="PolicyKindCodeForProp";    //����Ͷ���ձ�
	public static String CustomerUnit="CustomerUnit";    //��Ա�������
	public static String INJURYGRADE="InjueryGrade";     //ҽ�Ƶȼ�
	public static String HandleUnitCar = "HandleUnitCar";  //���յ��¹ʴ�����
	public static String CASECODE = "CaseCode"; //��������
	public static String CATASTROPHECODE = "CatastropheCode";   //���ִ�����Ϣ
	public static String LIABCODE = "PrpDliab";   //����������
	public static String PAYOBJECT = "PayObject";   //֧������
	
	/**
	 * ��ѯ����
	 * @param Collection����ѯ����
	 * @throws Exception
	 */
	public Collection findByConditions(String codetype,String conditions,int pageNo,int rowsPerPage)
	throws Exception
	{
		
		CodeFindByCondCommand codeFindByCondCommand = new CodeFindByCondCommand(codetype,conditions,pageNo,rowsPerPage);
		return (Collection)codeFindByCondCommand.execute();
	}
	
	/**
	 * ��ѯ����
	 * @param Collection����ѯ����
	 * @throws Exception
	 */
	public Collection findByConditions(String conditions)
	throws Exception
	{
		
		CodeFindByConditionsCommand CodeFindByConditionsCommand = new CodeFindByConditionsCommand(conditions);
		return (Collection)CodeFindByConditionsCommand.execute();
	}
	
	/**
	 * ��ѯ��������
	 * @param Collection����ѯ����
	 * @throws Exception
	 */
	public Collection getDeductCondition(String riskCode) throws Exception{
		BLCodeFacade bLCodeFacade = new BLCodeFacade();
		return bLCodeFacade.getDeductCondition(riskCode);
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
		CodeGetCustomerTypeCommand codeGetCustomerTypeCommand = new CodeGetCustomerTypeCommand(customerCode);
		return (String)codeGetCustomerTypeCommand.execute();
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
		CodeGetComLevelCommand codeGetComLevelCommand = new CodeGetComLevelCommand(comCode);
		return (String)codeGetComLevelCommand.execute();
	}
	
	/**
	 * ����ҵ�����ͼ����ֲ�ѯҵ�����
	 * @param  codetype��ҵ������
	 * @param  riskcode�����ִ���
	 * @return PrpDcodeDto �����ѯ
	 * @throws SQLException
	 * @throws Exception
	 */
	public Collection getCodeType(String codetype,String riskcode)
	throws Exception
	{
		CodeFindByCodeTypeCommand codeFindByCodeTypeCommand = new CodeFindByCodeTypeCommand(codetype,riskcode);
		return (Collection)codeFindByCodeTypeCommand.execute();
	}
	
	/**
	 * ���ػ������ƣ������б�
	 * @return Collection �����ѯ
	 * @throws SQLException
	 * @throws Exception
	 */
	public Collection getCurrencyList()
	throws Exception
	{
		PrpDcurrencyFindByConditionsCommand prpDcurrencyFindByConditionsCommand = new PrpDcurrencyFindByConditionsCommand();
		return (Collection)prpDcurrencyFindByConditionsCommand.execute();
	}
	
	/**
	 * ���ݲ��Ŵ���õ���������
	 * @param comCode String
	 * @param isChinese boolean
	 * @throws Exception
	 * @return String
	 */
	public String translateComCode(String comCode,boolean isChinese)
	throws Exception
	{
		String comName = "" ;
		if(comCode==null)
		{
			comName = "" ;
		}
		else
		{
			if(!comCode.equals(""))
			{
				CodeTranslateComCodeCommand codeTranslateComCodeCommand = new
				CodeTranslateComCodeCommand(comCode, isChinese);
				comName = (String) codeTranslateComCodeCommand.execute();
			}
		}
		return comName;
	}
	/**
	 * ���ݱұ�õ��ұ�����
	 * @param currencyCode String
	 * @param isChinese boolean
	 * @throws Exception
	 * @return String
	 */
	public String translateCurrencyCode(String currencyCode,boolean isChinese)
	throws Exception
	{
		String curryncyName = "" ;
		
		if(currencyCode==null)
		{
			curryncyName = "" ;
		}
		else
		{
			if(!currencyCode.equals(""))
			{
				CodeTranslateCurrencyCodeCommand codeTranslateCurryncyCodeCommand = new
				CodeTranslateCurrencyCodeCommand(currencyCode, isChinese);
				curryncyName = (String) codeTranslateCurryncyCodeCommand.execute();
			}
		}
		return curryncyName;
	}
	/**
	 * �������֣��ձ����õ��ձ�����
	 * @param riskCode String
	 * @param kindCode String
	 * @param isChinese boolean
	 * @throws Exception
	 * @return String
	 */
	public String translateKindCode(String riskCode,String kindCode,boolean isChinese)
	throws Exception
	{
		String codeName = "" ;
		
		if(riskCode==null||kindCode==null)
		{
			codeName = "" ;
		}
		else
		{
			if(!riskCode.equals("") && !kindCode.equals(""))
			{
				CodeTranslateKindCodeCommand codeTranslatKindCodeCommand = new
				CodeTranslateKindCodeCommand(riskCode,kindCode, isChinese);
				codeName = (String) codeTranslatKindCodeCommand.execute();
			}
		}
		return codeName;
	}
	
	/**
	 * �������֣���Ĵ���õ��������
	 * @param riskCode String
	 * @param kindCode String
	 * @param isChinese boolean
	 * @throws Exception
	 * @return String
	 */
	public String translateItemCode(String riskCode,String itemCode,boolean isChinese)
	throws Exception
	{
		String codeName = "" ;
		
		if(riskCode==null||itemCode==null)
		{
			codeName = "" ;
		}
		else
		{
			if(!riskCode.equals("") && !itemCode.equals(""))
			{
				CodeTranslateItemCodeCommand codeTranslateItemCodeCommand = new
				CodeTranslateItemCodeCommand(riskCode,itemCode, isChinese);
				codeName = (String) codeTranslateItemCodeCommand.execute();
			}
		}
		return codeName;
	}
	/**
	 * ���ݴ������ͣ������ѯ��������
	 * @param codeType String
	 * @param codeCode String
	 * @param isChinese boolean
	 * @throws Exception
	 * @return String
	 */
	public String translateCodeCode(String codeType,String codeCode,boolean isChinese)
	throws Exception
	{
		String codeName = "" ;
		
		if(codeType==null||codeCode==null)
		{
			codeName = "" ;
		}
		else
		{
			if(!codeType.equals("") && !codeCode.equals(""))
			{
				CodeTranslateCodeCodeCommand codeTranslatCodeCodeCommand = new
				CodeTranslateCodeCodeCommand(codeType,codeCode, isChinese);
				codeName = (String) codeTranslatCodeCodeCommand.execute();
			}
		}
		return codeName;
	}
	//��ѯPrpdLimit���⳥�޶�ר��ת��
	public String translateLimit(String riskCode,String limitCode,boolean isChinese)
	throws Exception
	{
		String limitName = "" ;
		
		if(riskCode==null||limitCode==null)
		{
			limitName = "" ;
		}
		else
		{
			if(!riskCode.equals("") && !limitCode.equals(""))
			{        	 
				CodeTranslateLimitCommand codeTranslateLimitCommand = new
				CodeTranslateLimitCommand(riskCode,limitCode, isChinese);
				limitName = (String) codeTranslateLimitCommand.execute();
			}
		}
		return limitName;
	}
	
	
	/**
	 * �����û������ѯ��������
	 * @param userCode String
	 * @param isChinese boolean
	 * @throws Exception
	 * @return String
	 */
	public String translateUserCode(String userCode,boolean isChinese)
	throws Exception
	{
		String codeName = "" ;
		
		if(userCode==null)
		{
			codeName = "" ;
		}
		else
		{
			if(!userCode.equals(""))
			{
				CodeTranslateUserCodeCommand codeTranslateUserCodeCommand = new
				CodeTranslateUserCodeCommand(userCode, isChinese);
				codeName = (String) codeTranslateUserCodeCommand.execute();
			}
		}
		return codeName;
	}
	
	/**
	 * ���ݱ��������ѯ��Ӧ���ⰸ����
	 * @param currencyCode String
	 * @param isSearchClaimNo boolean
	 * @throws Exception
	 * @return String
	 */
	public String translateBusinessCode(String businessCode,boolean isSearchClaimNo)
	throws Exception
	{
		String businessNo = "" ;
		
		if(businessCode==null)
		{
			businessNo = "" ;
		}
		else
		{
			if(!businessCode.equals(""))
			{
				CodeTranslateBusinessCodeCommand codeTranslateBusinessCodeCommand = new CodeTranslateBusinessCodeCommand(businessCode, isSearchClaimNo);
				businessNo = (String) codeTranslateBusinessCodeCommand.execute();
			}
		}
		return businessNo;
	}
	
	/**
	 * ��ѯ����������س��ƺ�����б�
	 * @param  registNo    ��������
	 * @return Collection �����ѯ
	 * @throws SQLException
	 * @throws Exception
	 */
	public Collection getLicenseNoList(String registNo)
	throws Exception
	{
		CodeFindByLicenseNoCommand codeFindByLicenseNoCommand = new CodeFindByLicenseNoCommand(registNo);
		return (Collection)codeFindByLicenseNoCommand.execute();
	}
	
	
	/**
	 * �������ִ���õ���������
	 * @param riskCode String
	 * @param isChinese boolean
	 * @throws Exception
	 * @return String
	 */
	public String translateRiskCode(String riskCode,boolean isChinese)
	throws Exception
	{
		String codeName = "" ;
		
		if(riskCode==null)
		{
			codeName = "" ;
		}
		else
		{
			if(!riskCode.equals("") )
			{
				CodeTranslateRiskCodeCommand codeTranslatRiskCodeCommand = new
				CodeTranslateRiskCodeCommand(riskCode,isChinese);
				codeName = (String) codeTranslatRiskCodeCommand.execute();
			}
		}
		return codeName;
	}
	
	/**
	 * �������ִ���õ�����Ĵ���
	 * @param riskCode String
	 * @throws Exception
	 * @return String classCode
	 */
	public String translateClassCodeByRiskCode(String riskCode)
	throws Exception
	{
		String classCode = "" ;
		
		if(riskCode!=null&&!riskCode.equals("") )
		{
				PrpDriskFindByPrimaryKeyCommand prpDriskFindByPrimaryKeyCommand = new
				PrpDriskFindByPrimaryKeyCommand(riskCode);
				PrpDriskDto prpDriskDto  = (PrpDriskDto) prpDriskFindByPrimaryKeyCommand.execute();
			    if (prpDriskDto!=null) classCode=prpDriskDto.getClassCode() ;
		}
		
		return classCode;
	}
	/**
	 * �������֣��ձ����õ������ܱ����־
	 * @param riskCode String
	 * @param kindCode String
	 * @throws Exception
	 * @return String
	 */
	public String translateCalculateFlag(String riskCode,String kindCode)
	throws Exception
	{
		String codeName = "" ;
		
		if(riskCode==null||kindCode==null)
		{
			codeName = "" ;
		}
		else
		{
			if(!riskCode.equals("") && !kindCode.equals(""))
			{
				CodeTranslateCalculateFlagCommand codeTranslateCalculateFlagCommand = new
				CodeTranslateCalculateFlagCommand(riskCode,kindCode);
				codeName = (String) codeTranslateCalculateFlagCommand.execute();
			}
		}
		return codeName;
	}
	
	
	//modify by wangli add start 20050416
	/**
	 * ���ݴ����˴���õ�����������
	 * @param dbManager DBManager
	 * @param agentCode �����˴���
	 * @throws SQLException
	 * @throws Exception
	 * @return String
	 */
	public String translateAgentName(String agentCode) throws Exception
	{
		String agentName = "" ;
		
		
		if(agentCode==null)
		{
			agentName = "" ;
		}
		else
		{
			if(!agentCode.equals(""))
			{
				AgentNameTranslateAgentCodeCommand agentNameTranslateAgentCodeCommand = new
				AgentNameTranslateAgentCodeCommand(agentCode);
				agentName = (String) agentNameTranslateAgentCodeCommand.execute();
			}
		}
		
		return agentName ;
	}
	
	/** ���ݿͻ�����õ��ͻ�����
	 * @param agentCode �ͻ�����
	 */
	
	public String translateCustomerCName(String customerCode) throws Exception
	{
		String customerCName = "" ;
		
		
		if(customerCode==null)
		{
			customerCName = "" ;
		}
		else
		{
			if(!customerCode.equals(""))
			{
				AgentNameTranslateAgentCodeCommand agentNameTranslateAgentCodeCommand = new
				AgentNameTranslateAgentCodeCommand(customerCode);
				customerCName = (String) agentNameTranslateAgentCodeCommand.execute();
			}
		}
		
		return customerCName ;
	}
	
	//modify by wangli add end 20050416
	
	/**
	 * ���ݴ�����ձ�ת������
	 * @param riskCode String
	 * @param kindCode String
	 * @param isChinese boolean
	 * @throws Exception
	 * @return String
	 */
	public String translateProductCode(String conFigCode)
	throws Exception
	{
		String codeName = "" ;
		
		try{
			if(conFigCode==null)
			{
				codeName = "" ;
			} else {
				UtiCodeTransferFindByPrimaryKeyCommand utiCodeTransferFindByPrimaryKeyCommand = new UtiCodeTransferFindByPrimaryKeyCommand(conFigCode);
				UtiCodeTransferDto UtiCodeTransferDto = (UtiCodeTransferDto)utiCodeTransferFindByPrimaryKeyCommand.execute();
				codeName = UtiCodeTransferDto.getOuterCode();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return codeName;
	}
	
	/**
	 * ���ݴ�����ձ�ת������
	 * @param riskCode String
	 * @param kindCode String
	 * @param isChinese boolean
	 * @throws Exception
	 * @return String
	 */
	public String translateRiskCodetoRiskType(String riskCode)
	throws Exception
	{
		String codeName = "" ;
		
		try{
			if(riskCode==null)
			{
				codeName = "" ;
			} else {
				UtiCodeTransferFindByConditionsCommand utiCodeTransferFindByConditionsCommand = new UtiCodeTransferFindByConditionsCommand(" outercode='"+riskCode+"'");
				ArrayList utiCodeTransferDtoList = new ArrayList();
				utiCodeTransferDtoList = (ArrayList)utiCodeTransferFindByConditionsCommand.execute();
				if(utiCodeTransferDtoList != null && utiCodeTransferDtoList.size() != 0){
					UtiCodeTransferDto UtiCodeTransferDto = (UtiCodeTransferDto)utiCodeTransferDtoList.get(0);
					codeName = UtiCodeTransferDto.getRiskType();
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return codeName;
	}
	
	/**
	 * ���ݴ�����ձ�ת������
	 * @param riskCode String
	 * @param kindCode String
	 * @param isChinese boolean
	 * @throws Exception
	 * @return String
	 */
	public String getRiskCodebyRiskType(String riskType)
	throws Exception
	{
		String condition = "";
		try{
			if(riskType!=null)
			{
				UtiCodeTransferFindByConditionsCommand utiCodeTransferFindByConditionsCommand = new UtiCodeTransferFindByConditionsCommand(" risktype='"+riskType+"'");
				ArrayList utiCodeTransferDtoList = new ArrayList();
				utiCodeTransferDtoList = (ArrayList)utiCodeTransferFindByConditionsCommand.execute();
				if(utiCodeTransferDtoList != null && utiCodeTransferDtoList.size() != 0){
					UtiCodeTransferDto UtiCodeTransferDto = (UtiCodeTransferDto)utiCodeTransferDtoList.get(0);
					condition = condition + "'" + UtiCodeTransferDto.getOuterCode() + "'";
					for(int i=1;i<utiCodeTransferDtoList.size();i++){
						condition = condition + ",'" + ((UtiCodeTransferDto)utiCodeTransferDtoList.get(i)).getOuterCode() + "'";
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return condition;
	}
	
	/**
	 * ���ݴ�����ձ�ת������
	 * @param riskCode String
	 * @param kindCode String
	 * @param isChinese boolean
	 * @throws Exception
	 * @return String
	 */
	public String translateRiskCodetoInnerCode(String riskCode)
	throws Exception
	{
		String codeName = "" ;
		
		try{
			if(riskCode==null)
			{
				codeName = "" ;
			} else {
				UtiCodeTransferFindByConditionsCommand utiCodeTransferFindByConditionsCommand = new UtiCodeTransferFindByConditionsCommand(" outercode='"+riskCode+"'");
				ArrayList utiCodeTransferDtoList = new ArrayList();
				utiCodeTransferDtoList = (ArrayList)utiCodeTransferFindByConditionsCommand.execute();
				if(utiCodeTransferDtoList != null && utiCodeTransferDtoList.size() != 0){
					UtiCodeTransferDto UtiCodeTransferDto = (UtiCodeTransferDto)utiCodeTransferDtoList.get(0);
					codeName = UtiCodeTransferDto.getInnerCode();
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return codeName;
	}
	
	/**
	 * ���ݴ�����ձ�ת������
	 * @param riskCode String
	 * @param kindCode String
	 * @param isChinese boolean
	 * @throws Exception
	 * @return String
	 */
	public String translateRiskCodetoConfigCode(String riskCode)
	throws Exception
	{
		String codeName = "" ;
		
		try{
			if(riskCode==null)
			{
				codeName = "" ;
			} else {
				UtiCodeTransferFindByConditionsCommand utiCodeTransferFindByConditionsCommand = new UtiCodeTransferFindByConditionsCommand(" outercode='"+riskCode+"'");
				ArrayList utiCodeTransferDtoList = new ArrayList();
				utiCodeTransferDtoList = (ArrayList)utiCodeTransferFindByConditionsCommand.execute();
				if(utiCodeTransferDtoList != null && utiCodeTransferDtoList.size() != 0){
					UtiCodeTransferDto UtiCodeTransferDto = (UtiCodeTransferDto)utiCodeTransferDtoList.get(0);
					codeName = UtiCodeTransferDto.getConfigCode();
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return codeName;
	}
	
	/**
	 * ���ݹ����������˴���ת���ɹ���������������
	 * @param checkAgentCodeSQL ��ѯ���
	 * @exception throws Exception 
	 * @return prpDidentifierDtoList
	 * */
	public ArrayList translateCheckAgentCodeToName(String checkAgentCodeSQL)  throws Exception {
		ArrayList prpDidentifierDtoList = new ArrayList();
		
		try {
			AgentNameTranslateAgentCodeCommand agentNameTranslateAgentCodeCommand = new AgentNameTranslateAgentCodeCommand();
			prpDidentifierDtoList = (ArrayList) agentNameTranslateAgentCodeCommand.translateCheckAgentCodeToName(checkAgentCodeSQL);
		} catch (Exception ex){
			ex.printStackTrace();
		} 
		return prpDidentifierDtoList;
	}
	public String getRecursionComCode(String condition)  throws Exception {
		String ComCode ="";
		ComCodeRecursionCommand comCodeRecursionCommand = new
		ComCodeRecursionCommand( condition);
		ComCode = (String) comCodeRecursionCommand.execute();
		return ComCode;
	}
}
