<%--
****************************************************************************
* DESC       ������������������վݴ�ӡҳ���ʼ��
* AUTHOR     ��caopeng
* CREATEDATE ��2005-12-02
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%-- ����bean�ಿ�� --%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 

<%
  //������������
  String strCompensateNo      = request.getParameter("CompensateNo"); //���������
  String strClaimNo           = "";   //������
  String strRegistNo          = "";   //������
  String strPolicyNo          = "";   //������
  String strSumPaid           = "";   //
  String strCSumPaid          = "";   //
  double dblSumPaid           = 0;    //
  String strChargeCode        = "";
  String strInsuredName       = "";    //��������
  String strYear              = "";    
  String strMonth             = "";
  String strDate              = "";
  String strComCode       = "";   //ҵ������������� 
  String strComCName      = "";   //ҵ�����������������
  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
  String riskCodeName="";
  
  //�����岿��
                                              

  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto����
  PrpCmainDto    prpMainDto             = null;   //CMainDto����

  
  int index = 0;
  
  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto����
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  CompensateDto compensateDto = (CompensateDto)request.getAttribute("compensateDto"); 
  UserDto   user     = (UserDto)session.getAttribute("user");
  String userName = "";
  if (user!=null){
   userName=user.getUserName();
  } 
   
   
  UICodeAction uiCodeAction = new UICodeAction();
  //�õ�prpLcompensateDto ����
  prpLcompensateDto   = compensateDto.getPrpLcompensateDto();
  
  //�õ�prpLclaimDto����
  prpLclaimDto   = claimDto.getPrpLclaimDto();
  if(policyDto!=null){
	  prpMainDto =  policyDto.getPrpCmainDto();
	  if(prpMainDto!=null){
		  strComCode       = StringConvert.encode(prpMainDto.getComCode());
		  UICompanyAction uiCompanyAction = new UICompanyAction();
		  PrpDcompanyDto prpDcompanyDto = uiCompanyAction.findByPrimaryKey(strComCode); 
		  if(prpDcompanyDto!=null)
		  strComCName      = prpDcompanyDto.getComCName();
	  }
  }
 
  java.util.Date date = new java.util.Date();
  strYear = String.valueOf(date.getYear()+1900);
  strMonth = String.valueOf(date.getMonth()+1);
  strDate = String.valueOf(date.getDate());
  //�õ�������
  strPolicyNo = prpLclaimDto.getPolicyNo();
  riskCodeName = uiCodeAction.translateRiskCode(prpLclaimDto.getRiskCode() ,true);
    strInsuredName  = StringConvert.encode(prpLclaimDto.getInsuredName());
    if(prpLcompensateDto != null){
       dblSumPaid      = prpLcompensateDto.getSumPaid();
       strClaimNo      = prpLcompensateDto.getClaimNo();
    }             
    strSumPaid      = new DecimalFormat("#,##0.00").format(dblSumPaid);    
    strCSumPaid     = MoneyUtils.toChinese(dblSumPaid,prpLcompensateDto.getCurrency());   

%> 



  