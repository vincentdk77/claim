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
 * 代码查询逻辑
 * <p>Title: 车险理赔</p>
 * <p>Description: 车险理赔样本程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author 项目组
 * @version 1.0
 */
public class UICodeAction{
	private static UICodeAction uiCodeAction= new UICodeAction();
	public static UICodeAction getInstance(){
		return uiCodeAction;
	}
	public static String COMCODE="ComCode";                //部门机构
	public static String CURRENCYCODE = "CurrencyCode";    //币别
	public static String KINDCODE = "KindCode";            //险别
	public static String CLAUSECODE = "ClauseCode";        //条款
	public static String REINSCODE = "ReinsCode";          //？？
	public static String DAMAGECODE="DamageCode";          //出险原因
	public static String DAMAGEAREACODE="DamageAreaCode";  //出险区域
	public static String DAMAGETYPECODE = "DamageTypeCode";//事故类型
	public static String HANDLERCODE="HandlerCode";        //经办人
	public static String DOCCODE="DocCode";                //单证代码
	public static String HANDERCODE="HanderCode";          //接案人 经办人
	public static String HANDLEUNIT="HandleUnit";          //事故处理部门
	public static String INSURECOMCODE="InsureComCode" ;   //承保公司
	public static String POLICYKINDCODE="PolicyKindCode";  //保单投保险别来自prpcitemkind
	public static String POLICYITEMCODE="PolicyItemCode";  //保单责任来自prpcitemkind
	public static String CHARGECODE="ChargeCode" ;         //费用代码
	public static String CHARGECODE1="ChargeCode" ;         //费用代码
	public static String DAMAGEADDRESS="DamageAddress";    //出险地点
	public static String SCHEDULEOBJECT="ScheduleObject";    //出险地点
	public static String COMPCODE="CompCode";                //损失部件
	public static String BUSINESSSOURCE="BusinessSource";    //所在行业
	public static String DAMAGEDISTRICT="DamageDistrict";    //所在地区
	public static String POLICYKINDCODEFORPERSON="PolicyKindCodeForPerson";    //保单投保险别
	public static String POLICYKINDCODEFORPROP="PolicyKindCodeForProp";    //保单投保险别
	public static String CustomerUnit="CustomerUnit";    //人员定损费用
	public static String INJURYGRADE="InjueryGrade";     //医疗等级
	public static String HandleUnitCar = "HandleUnitCar";  //车险的事故处理部门
	public static String CASECODE = "CaseCode"; //案件性质
	public static String CATASTROPHECODE = "CatastropheCode";   //巨灾代码信息
	public static String LIABCODE = "PrpDliab";   //责任类别代码
	public static String PAYOBJECT = "PayObject";   //支付对象
	
	/**
	 * 查询代码
	 * @param Collection：查询代码
	 * @throws Exception
	 */
	public Collection findByConditions(String codetype,String conditions,int pageNo,int rowsPerPage)
	throws Exception
	{
		
		CodeFindByCondCommand codeFindByCondCommand = new CodeFindByCondCommand(codetype,conditions,pageNo,rowsPerPage);
		return (Collection)codeFindByCondCommand.execute();
	}
	
	/**
	 * 查询代码
	 * @param Collection：查询代码
	 * @throws Exception
	 */
	public Collection findByConditions(String conditions)
	throws Exception
	{
		
		CodeFindByConditionsCommand CodeFindByConditionsCommand = new CodeFindByConditionsCommand(conditions);
		return (Collection)CodeFindByConditionsCommand.execute();
	}
	
	/**
	 * 查询免赔条件
	 * @param Collection：查询代码
	 * @throws Exception
	 */
	public Collection getDeductCondition(String riskCode) throws Exception{
		BLCodeFacade bLCodeFacade = new BLCodeFacade();
		return bLCodeFacade.getDeductCondition(riskCode);
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
		CodeGetCustomerTypeCommand codeGetCustomerTypeCommand = new CodeGetCustomerTypeCommand(customerCode);
		return (String)codeGetCustomerTypeCommand.execute();
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
		CodeGetComLevelCommand codeGetComLevelCommand = new CodeGetComLevelCommand(comCode);
		return (String)codeGetComLevelCommand.execute();
	}
	
	/**
	 * 根据业务类型及险种查询业务代码
	 * @param  codetype：业务类型
	 * @param  riskcode：险种代码
	 * @return PrpDcodeDto 代码查询
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
	 * 返回货币名称，代码列表
	 * @return Collection 代码查询
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
	 * 根据部门代码得到部门名称
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
	 * 根据币别得到币别名称
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
	 * 根据险种，险别代码得到险别名称
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
	 * 根据险种，标的代码得到标的名称
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
	 * 根据代码类型，代码查询代码名称
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
	//查询PrpdLimit表，赔偿限额专用转换
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
	 * 根据用户代码查询代码名称
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
	 * 根据报案号码查询对应的赔案号码
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
	 * 查询本报案的相关车牌号码的列表
	 * @param  registNo    报案号码
	 * @return Collection 代码查询
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
	 * 根据险种代码得到险种名称
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
	 * 根据险种代码得到险类的代码
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
	 * 根据险种，险别代码得到计入总保额标志
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
	 * 根据代理人代码得到代理人姓名
	 * @param dbManager DBManager
	 * @param agentCode 代理人代码
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
	
	/** 根据客户代码得到客户姓名
	 * @param agentCode 客户代码
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
	 * 根据代码对照表转换代码
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
	 * 根据代码对照表转换代码
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
	 * 根据代码对照表转换代码
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
	 * 根据代码对照表转换代码
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
	 * 根据代码对照表转换代码
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
	 * 根据国外检验代理人代码转换成国外检验代理人姓名
	 * @param checkAgentCodeSQL 查询语句
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
