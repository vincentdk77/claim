<%--
****************************************************************************
* DESC       ���Ʋ������������ӡҳ���ʼ��
* AUTHOR     ��wangwei
* CREATEDATE ��2005-5-21
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
  String strCompensateNo      = ""; //���������
  System.out.println("strCompensateNo = "+strCompensateNo);
  String strClaimNo           = "";   //������
  String strPolicyNo          = "";   //������
  double dblSumAmount1       = 0;    //���ս��      
  String strKindCode          = "";   //�ձ����
  String strCause             = "";   //����ԭ��
  String strAddress           = "";   //���յص�
  
  String strCountExp          = "";   //�����㹫ʽ
  String strDamageStartDate   = "";
  String strInsuredDate       = "";  
  
  //���˶�
  double dblClaim            = 0;    //���˶�
  double dblAgen             = 0;    //�����
  double dblCheck            = 0;    //�����
  double dblExamine          = 0;    //�鿱��
  double dblRest             = 0;    //��������
  double dblSum              = 0;    //���ϼ�
  double dblEndMoney         = 0;    //�����Ѹ������
  double dblTrueMoney        = 0;    //�᰸ʱʵ�������

  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
  
  //�����岿��
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto����
  PrpLctextDto       prpLctextDto       = null; 
  
  int intCompensateCount = 0;   //CompensateDto����ļ�¼��
  int intItemCarCount    = 0;   //ItemcarDto����ļ�¼��
  int intItemKindCount   = 0;   //ItemKindDto����ļ�¼��
  int intThirdPartyCount = 0;   //ThirdPartyDto����ļ�¼��
  int intChargeCount     = 0;   //ChargeDto����ļ�¼��
  int intCtextCount      = 0;   //CtextDto����ļ�¼��
  int intCtextCountTmp   = 0;   //textarea����
    
  int index = 0;
  
  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto����
  CompensateDto compensateDto = (CompensateDto)request.getAttribute("compensateDto"); 
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  CheckDto checkDto = (CheckDto)request.getAttribute("checkDto"); 
  
  CertainLossDto certainLossDto = (CertainLossDto)request.getAttribute("certainLossDto");
   
  UICodeAction uiCodeAction = new UICodeAction();
  //�õ�prpLcompensateDto ����
  prpLcompensateDto   = compensateDto.getPrpLcompensateDto();
  strCompensateNo = prpLcompensateDto.getCompensateNo();
  //�õ�prpLclaimDto����
  prpLclaimDto   = claimDto.getPrpLclaimDto();
  
  strClaimNo = prpLclaimDto.getClaimNo(); 
  String strApproverCode   = prpLcompensateDto.getApproverCode();   //����Ա����
  String strOperatorCode   = prpLcompensateDto.getOperatorCode();   //����Ա����
  String strApproverName   = uiCodeAction.translateUserCode(strApproverCode,isChinese);  
  String strOperatorName   = uiCodeAction.translateUserCode(strOperatorCode,isChinese);  
  
  //�õ�������
  strPolicyNo = prpLclaimDto.getPolicyNo();
  
  //�õ�blPrpCitemCar���� 
  if(policyDto.getPrpCitem_carDtoList()!=null){
    intItemCarCount     = policyDto.getPrpCitem_carDtoList().size();
  }  
  
  //�õ�blPrpCitemKind����ļ�¼��
  if(policyDto.getPrpCitemKindDtoList()!=null){
    intItemKindCount     = policyDto.getPrpCitemKindDtoList().size();
  }  
    
  //�õ�blPrpLcharge����ļ�¼��
  if(compensateDto.getPrpLchargeDtoList()!=null){
    intChargeCount     = compensateDto.getPrpLchargeDtoList().size();
  }  
  //�õ�dbPrpLctext����ļ�¼��  
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    intCtextCount     = compensateDto.getPrpLctextDtoDtoList().size();
  }
 String strEndMoney =  new DecimalFormat("#,##0.00").format(prpLcompensateDto.getSumPrePaid());
 String strCEndMoney = null;
 if(prpLcompensateDto.getSumPrePaid() >= 0){
	 strCEndMoney = MoneyUtils.toChinese(prpLcompensateDto.getSumPrePaid()*-1,prpLcompensateDto.getCurrency()); 
 }
 else{
	 strCEndMoney = "��" + MoneyUtils.toChinese(prpLcompensateDto.getSumPrePaid(),prpLcompensateDto.getCurrency()); 
 }
%>

<script language="javascript">
  function loadForm()
  {
    
    //*****���������PrpLcompensate*****
    tdCompensateNo.innerHTML = '<%=strCompensateNo%>';

    //*****������Ϣ��PrpLclaim*****
    tdPolicyNo.innerHTML     = '<%=strPolicyNo%>';
    tdInsuredName.innerHTML  = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
    tdLossName.innerHTML    = '<%prpLclaimDto.getLossName();%>';
    tdSumAmount.innerHTML = '<%= new DecimalFormat("#,##0.00").format(prpLclaimDto.getSumAmount())%>';
<%    
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                        + " �� " +prpLclaimDto.getDamageStartDate().getMonth()
                        + " �� " + prpLclaimDto.getDamageStartDate().getDate()
                        + " ��";
%>                    
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>';
<%    
    strInsuredDate = "�� " + prpLclaimDto.getStartDate().getYear()
                     + "��" + prpLclaimDto.getStartDate().getMonth()
                     + "��" + prpLclaimDto.getStartDate().getDate()
                     + "�� ��ʱ��"
                     + "<br>" + "<br>" 
                     + "�� " + prpLclaimDto.getEndDate().getYear()
                     + "��" + prpLclaimDto.getEndDate().getMonth()
                     + "��" +prpLclaimDto.getEndDate().getDate()
                     + "�� ��ʮ��ʱֹ";
%>                    
    tdInsuredDate.innerHTML = '<%=strInsuredDate%>';
    tdDamageAddress.innerHTML = '<%= prpLclaimDto.getDamageAddress()%>';
    
 } 
</script>
  