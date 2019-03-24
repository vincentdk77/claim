<%--
****************************************************************************
* DESC       ��Ԥ��ͨ�������������ӡ��ʼ��
* AUTHOR     ��caopeng
* CREATEDATE ��2005-12-09
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
<%@page import="java.util.Iterator"%>

<%
  //������������
  String strCompensateNo      = request.getParameter("CompensateNo"); //���������
  String strClaimNo           = (String)request.getAttribute("ClaimNo"); //������
  String strRegistNo          = "";   //������
  String strPolicyNo          = "";   //������
  String strInsuredName       = "";   //������������
  String strDamageStartDate   = "";   //����ʱ��
  String strInsuredDate       = "";   //�����ڼ�
  String strDamageName        = "";   //����ԭ��
  String strSumAmount         = "";   //���ս��
  String strSumClaim          = "";   //������
  String strRiskCode          = "";   //�б��ձ����
  String strRiskName          = "";   //�б��ձ�����
  String strCaseType          = "";   //��������
  String strSumThisPaid       = "";   //Ԥ�����
  double dblSumThisPaid       = 0.0;  //Ԥ����� 
  double dblSumAmount         = 0.0;  //���ս��

  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
  
  //�����岿��
                                          
  PrpCmainDto        prpCmainDto        = null;   //������CmainDto����
  PrpCinsuredDto     prpInsuredDto      = null;   //������InsuredDto����
  PrpCitemCarDto    prpItemcarDto     = null;   //������ItemcarDto����
  PrpLregistDto      prpLregistDto      = null;   //RegistDto����
  PrpLregistTextDto  prpLregistTextDto  = null;   //RegistTextDto����
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLdriverDto      prpLdriverDto      = null;   //DriverDto����
  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto����
  PrpLclaimLossDto   prpLclaimLossDto   = null;   //ClaimLossDto����
  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto����
  
  int intClaimCount      = 0;   //ClaimDto����ļ�¼��
  int intInsuredCount    = 0;   //InsuredDto����ļ�¼��
  int intItemCarCount    = 0;   //ItemCarDto����ļ�¼��
  int intDriverCount     = 0;   //DriverDto����ļ�¼��
  int intThirdPartyCount = 0;   //ThirdPartyDto����ļ�¼��
  int intRegistTextCount = 0;   //RegistTextDto����ļ�¼��
  int intClaimLoss       = 0;   //PrpLclaimLossDto����ļ�¼��

    
  int index = 0;
  //�õ�PolicyDto,ClaimDto,RegistDto,CompensateDto����
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto"); 
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  CompensateDto compensateDto = (CompensateDto)request.getAttribute("compensateDto");
  
  UICodeAction uiCodeAction = new UICodeAction();
    
  //�õ�������
  strPolicyNo = claimDto.getPrpLclaimDto().getPolicyNo();

  //�õ�prpMainDto����
  prpCmainDto      = policyDto.getPrpCmainDto();
   
  //�õ�PrpCinsured����ļ�¼��  
  if(policyDto.getPrpCinsuredDtoList()!=null){
    intInsuredCount     = policyDto.getPrpCinsuredDtoList().size();
  }
  //�õ�prpItemcarDto����
  if(policyDto.getPrpCitemCarDtoList()!=null){
    intItemCarCount     = policyDto.getPrpCitemCarDtoList().size();
  }  
  //�õ�PrpLthirdParty����ļ�¼��
  if(claimDto.getPrpLthirdPartyDtoList()!=null){
    intThirdPartyCount     = claimDto.getPrpLthirdPartyDtoList().size();
  }
  
  //�õ�PrpLdriver����ļ�¼��
  if(claimDto.getPrpLdriverDtoList()!=null){
    intDriverCount     = claimDto.getPrpLdriverDtoList().size();
  }
  //�õ�PrpLclaimLoss����ļ�¼��
  if(claimDto.getPrpLclaimLossDtoList()!=null){
    intClaimLoss     = claimDto.getPrpLclaimLossDtoList().size();
  }

  //�õ�prpLclaimDto����
  prpLclaimDto     = claimDto.getPrpLclaimDto();
  
  
  
  //�õ�prpLregistDto����
  prpLregistDto    = registDto.getPrpLregistDto();
  
  //�õ�prpLcompensateDto����
  prpLcompensateDto   = compensateDto.getPrpLcompensateDto();
  
  //�õ�blPrpLregistText����ļ�¼��
  if(registDto.getPrpLregistTextDtoList()!=null){
    intRegistTextCount  = registDto.getPrpLregistTextDtoList().size();
  }
  
  strRiskCode = prpLclaimDto.getRiskCode();
  strRiskName = uiCodeAction.translateRiskCode(strRiskCode,isChinese);
  
  double dblSumClaim = 0.0;  //������
  if(intClaimLoss>0){
    for(index=0;index<intClaimLoss;index++){
      prpLclaimLossDto = (PrpLclaimLossDto)claimDto.getPrpLclaimLossDtoList().get(index);
      dblSumClaim += prpLclaimLossDto.getSumClaim();
    }
  }
  strSumClaim = new DecimalFormat("#,##0.00").format(dblSumClaim) + "Ԫ"; 
  strInsuredName = StringConvert.encode(prpLclaimDto.getInsuredName());
  String strDateTemp = "";  
    if(prpLclaimDto.getDamageStartHour()!=null){
      if(prpLclaimDto.getDamageStartHour().length()<2){ 
        strDateTemp = prpLclaimDto.getDamageStartHour(); 
      }else{
        strDateTemp = prpLclaimDto.getDamageStartHour().substring(0,2);
      }
    }
  strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                       + " �� " + prpLclaimDto.getDamageStartDate().getMonth()
                       + " �� " + prpLclaimDto.getDamageStartDate().getDate()
                       + " �� " + strDateTemp
                       + " ʱ";
  if(prpCmainDto != null){
    strInsuredDate = "�� " + prpCmainDto.getStartDate().getYear()
                       + "��" +prpCmainDto.getStartDate().getMonth()
                       + "��" + prpCmainDto.getStartDate().getDate()
                       + "��" + prpCmainDto.getStartHour()
                       + "ʱ��"
                       + "�� " + prpCmainDto.getEndDate().getYear()
                       + "��" + prpCmainDto.getEndDate().getMonth()
                       + "��" + prpCmainDto.getEndDate().getDate()
                       + "��" + prpCmainDto.getEndHour()
                       + "ʱֹ";
  }
  if(prpLregistDto != null){
     strDamageName    =  StringConvert.encode(prpLregistDto.getDamageName());
  }
  
  if(prpLcompensateDto!=null){
    strCaseType = prpLcompensateDto.getCaseType();
    if("3".equals(strCaseType) || "4".equals(strCaseType) || "6".equals(strCaseType) ){
      dblSumThisPaid  = prpLcompensateDto.getSumThisPaid(); 
      if(dblSumThisPaid>0){
        strSumThisPaid = new DecimalFormat("#,##0.00").format(dblSumThisPaid) + "Ԫ"; 
      }
    }
  }
  
  dblSumAmount = prpLclaimDto.getSumAmount();
  strSumAmount = new DecimalFormat("#,##0.00").format(dblSumAmount) + "Ԫ"; 
%>