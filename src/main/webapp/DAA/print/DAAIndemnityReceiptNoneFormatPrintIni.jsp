<%--
****************************************************************************
* DESC       ：机动车辆保险赔款收据打印页面初始化
* AUTHOR     ：caopeng
* CREATEDATE ：2005-12-02
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>

<%-- 引入bean类部分 --%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 

<%
  //变量声明部分
  String strCompensateNo      = request.getParameter("CompensateNo"); //赔款计算书号
  String strClaimNo           = "";   //立案号
  String strRegistNo          = "";   //报案号
  String strPolicyNo          = "";   //保单号
  String strSumPaid           = "";   //
  String strCSumPaid          = "";   //
  double dblSumPaid           = 0;    //
  double dblSumDutyPaid       = 0;    //责任赔款(不包括不计入赔款的费用)
  String strSumDutyPaid       = "";
  String strCSumDutyPaid      = "";
  String strChargeCode        = "";
  String strInsuredName       = "";    //被保险人
  String strInsuredCode		  = "";    //被保险人代码
  String strYear              = "";    
  String strMonth             = "";
  String strDate              = "";
  String strComCode       = "";   //业务归属机构代码 
  String strComCName      = "";   //业务归属机构中文名称
  //代码翻译变量
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //中文标志
  String riskCodeName="";
  
  String strUnitBank = "";	//收款单位银行
  String strUnitAccount = "";  //收款单位帐号
  String strAccount = ""; //收款人银行帐号
  String strIdentifyNumber = ""; //收款人身份证号
  
  //对象定义部分
                                              

  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto对象
  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto对象
  PrpCmainDto    prpMainDto             = null;   //CMainDto对象

  
  int index = 0;
  
  //是否已有打印流水号
  Boolean isHavePrintNo = (Boolean)request.getAttribute("isHavePrintNo");
  //获得打印流水号
  String printNo = (String)request.getAttribute("printNo");
  
  //单证代码
  String visaCode = (String)request.getAttribute("visaCode");
  
  String visaName = (String)request.getAttribute("visaName");
  
  
  //得到ClaimDto,RegistDto,CertainLossDto,PolicyDto对象
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  CompensateDto compensateDto = (CompensateDto)request.getAttribute("compensateDto"); 
  
  PrpLIndemnityReceiptDto prpLIndemnityReceiptDto = (PrpLIndemnityReceiptDto)request.getAttribute("prpLIndemnityReceiptDto");
  UserDto   user     = (UserDto)session.getAttribute("user");
  String userName = "";
  if (user!=null){
   userName=user.getUserName();
  } 
   
   
  UICodeAction uiCodeAction = new UICodeAction();
  //得到prpLcompensateDto 对象
  prpLcompensateDto   = compensateDto.getPrpLcompensateDto();
  
  //得到prpLclaimDto对象
  prpLclaimDto   = claimDto.getPrpLclaimDto();
  if(policyDto!=null){
	  prpMainDto =  policyDto.getPrpCmainDto();
	  if(prpMainDto!=null){
		  strComCode       = StringConvert.encode(prpMainDto.getComCode());
		  strComCode=strComCode.substring(0,7)+"000";
		  UICompanyAction uiCompanyAction = new UICompanyAction();
		  PrpDcompanyDto prpDcompanyDto = uiCompanyAction.findByPrimaryKey(strComCode); 
		  if(prpDcompanyDto!=null)
		  strComCName      = prpDcompanyDto.getComCName();
		  if (strComCName.length()>2) strComCName =strComCName.substring(0,strComCName.length()-2);
	  }
  }
 
  java.util.Date date = new java.util.Date();
  strYear = String.valueOf(date.getYear()+1900);
  strMonth = String.valueOf(date.getMonth()+1);
  strDate = String.valueOf(date.getDate());
  //得到保单号
  strPolicyNo = prpLclaimDto.getPolicyNo();
  riskCodeName = uiCodeAction.translateRiskCode(prpLclaimDto.getRiskCode() ,true);
    strInsuredName  = StringConvert.encode(prpLclaimDto.getInsuredName());
    strInsuredCode  = StringConvert.encode(prpLclaimDto.getInsuredCode());    
    if(prpLcompensateDto != null){
       dblSumPaid      = prpLcompensateDto.getSumPaid();
       dblSumDutyPaid  = prpLcompensateDto.getSumDutyPaid();
       strClaimNo      = prpLcompensateDto.getClaimNo();
       strUnitBank =  prpLIndemnityReceiptDto.getUnitBank();	//收款单位银行
	   strUnitAccount = prpLIndemnityReceiptDto.getUnitAccount();
	   strAccount = prpLIndemnityReceiptDto.getAccount(); //收款人银行帐号
       strIdentifyNumber = prpLIndemnityReceiptDto.getIdentifyNumber(); //收款人身份证号
    }             
    strSumPaid      = new DecimalFormat("#,##0.00").format(dblSumPaid);    
    strCSumPaid     = MoneyUtils.toChinese(dblSumPaid,prpLcompensateDto.getCurrency());   
    
    strSumDutyPaid  = new DecimalFormat("#,##0.00").format(dblSumDutyPaid);    
    strCSumDutyPaid = MoneyUtils.toChinese(dblSumDutyPaid,prpLcompensateDto.getCurrency());   

%> 



  