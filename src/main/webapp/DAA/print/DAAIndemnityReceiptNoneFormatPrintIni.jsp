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
  double dblSumDutyPaid       = 0;    //�������(���������������ķ���)
  String strSumDutyPaid       = "";
  String strCSumDutyPaid      = "";
  String strChargeCode        = "";
  String strInsuredName       = "";    //��������
  String strInsuredCode		  = "";    //�������˴���
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
  
  String strUnitBank = "";	//�տλ����
  String strUnitAccount = "";  //�տλ�ʺ�
  String strAccount = ""; //�տ��������ʺ�
  String strIdentifyNumber = ""; //�տ������֤��
  
  //�����岿��
                                              

  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto����
  PrpCmainDto    prpMainDto             = null;   //CMainDto����

  
  int index = 0;
  
  //�Ƿ����д�ӡ��ˮ��
  Boolean isHavePrintNo = (Boolean)request.getAttribute("isHavePrintNo");
  //��ô�ӡ��ˮ��
  String printNo = (String)request.getAttribute("printNo");
  
  //��֤����
  String visaCode = (String)request.getAttribute("visaCode");
  
  String visaName = (String)request.getAttribute("visaName");
  
  
  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto����
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
  //�õ�prpLcompensateDto ����
  prpLcompensateDto   = compensateDto.getPrpLcompensateDto();
  
  //�õ�prpLclaimDto����
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
  //�õ�������
  strPolicyNo = prpLclaimDto.getPolicyNo();
  riskCodeName = uiCodeAction.translateRiskCode(prpLclaimDto.getRiskCode() ,true);
    strInsuredName  = StringConvert.encode(prpLclaimDto.getInsuredName());
    strInsuredCode  = StringConvert.encode(prpLclaimDto.getInsuredCode());    
    if(prpLcompensateDto != null){
       dblSumPaid      = prpLcompensateDto.getSumPaid();
       dblSumDutyPaid  = prpLcompensateDto.getSumDutyPaid();
       strClaimNo      = prpLcompensateDto.getClaimNo();
       strUnitBank =  prpLIndemnityReceiptDto.getUnitBank();	//�տλ����
	   strUnitAccount = prpLIndemnityReceiptDto.getUnitAccount();
	   strAccount = prpLIndemnityReceiptDto.getAccount(); //�տ��������ʺ�
       strIdentifyNumber = prpLIndemnityReceiptDto.getIdentifyNumber(); //�տ������֤��
    }             
    strSumPaid      = new DecimalFormat("#,##0.00").format(dblSumPaid);    
    strCSumPaid     = MoneyUtils.toChinese(dblSumPaid,prpLcompensateDto.getCurrency());   
    
    strSumDutyPaid  = new DecimalFormat("#,##0.00").format(dblSumDutyPaid);    
    strCSumDutyPaid = MoneyUtils.toChinese(dblSumDutyPaid,prpLcompensateDto.getCurrency());   

%> 



  