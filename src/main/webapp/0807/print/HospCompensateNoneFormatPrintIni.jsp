<%--
****************************************************************************
* DESC       ���Ʋ������������ӡҳ���ʼ��
* AUTHOR     ��hanliang
* CREATEDATE ��2005-12-12
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%-- ����bean�ಿ�� --%>
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 
<%@page import="com.sinosoft.claim.dto.domain.PrpPheadDto" %> 
<%@page import="com.sinosoft.sff.schema.PrpJpayRefRecSchema"%>
<%@page import="com.sinosoft.sff.blsvr.BLPrpJpayRefRec"%>
<%@page import="com.sinosoft.payment.bl.facade.BLPrpJpayRefMainFacade"%>
<%@page import="com.sinosoft.payment.dto.domain.PrpJpayRefMainDto"%>
<%
  //������������
  String strCompensateNo      = ""; //���������
  String strClaimNo           = "";   //������
  String strPolicyNo          = "";   //������
  double dblSumAmount1       = 0;    //���ս��      
  String strKindCode          = "";   //�ձ����
  String strCause             = "";   //����ԭ��
  String strAddress           = "";   //���յص�
  String strDamageAddress      = "";   //���յص�
  String strDamageStartDate    = "";   //����ʱ��
  String strReportHour         = "";   //����Сʱ
  String strInputDate         = "";    //����ʱ��
  String strUnderWriteEndDate = "";    //�����������
  String strTextType          = "";
  String strContext           = "";   //������������
  String strCountExp          = "";   //�����㹫ʽ
  String strInsuredDate       = "";  
  String strInsuredName       = "";   //��������
  String strInsuredAddress    = "";   //���ղƲ���ַ
  String strEndorseNo         = "";   //��������

  String strChargeCode        = "";   //
  
  //���˶�
  double dblJudgeFee          = 0;    //������
  double dblCheckFee          = 0;    //�鿱��
  double dblLawFee            = 0;    //���Ϸ�
  double dblElseFee           = 0;    //��������
  double dblSumPrePaid        = 0;    //
  double dblSumRest           = 0;    //
  double dblCheckFee1         = 0;    //���鿱��
  double dblAssessFee         = 0;    //������
  double dblRescueFee         = 0;    //ʩ�ȷ�
  double dblAgentFee          = 0;    //�����
  double dblGsjzFee			  = 0;	  //���������
  double dblFlFee			  = 0;	  //���ɷ�  
  double dblPropSumLossPay	  = 0;	  //�Ʋ���ʧ
  double dblPersonSumLossPay  = 0;	  //������ʧ
  double dblSumLossPay		  = 0;	  //������
  
  double dblSumLoss          = 0;    //�˶���ʧ�����ձ����ʧ
  String strCurrency2        = "";   //�˶���ʧ�����ձ����ʧ�ұ�
  String strSumPaid          = "";   //���ϼƸ�ʽ��
  String strCSumPaid         = "";   //���ϼƴ�д
  String strSumLossPay		 = "";	 //������
  String strCSumLossPay	     = "";	 //����������
  double dblSumPaid          = 0;    //���ϼ�

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
  PrpLchargeDto prpLchargeDto = null;
  CertainLossDto certainLossDto = (CertainLossDto)request.getAttribute("certainLossDto");
  
  
  ArrayList prpLpersonlossList = new ArrayList();
  prpLpersonlossList = compensateDto.getPrpLpersonLossDtoList();
  PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto)prpLpersonlossList.get(0);
  String strPersonName = prpLpersonLossDto.getPersonName();
  
  ArrayList prpLhospitalizationPayFeeDtoList = new ArrayList();
  prpLhospitalizationPayFeeDtoList = compensateDto.getPrpLhospitalizationPayFeeDtoList();
  double fee = 0;
  if(prpLhospitalizationPayFeeDtoList!=null&&prpLhospitalizationPayFeeDtoList.size()>0)
  {
    int m = prpLhospitalizationPayFeeDtoList.size();
    for(int x=0;x<m;x++)
    {
      PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto = new PrpLhospitalizationPayFeeDto();
      prpLhospitalizationPayFeeDto = (PrpLhospitalizationPayFeeDto)prpLhospitalizationPayFeeDtoList.get(x);
      if("02".equals(prpLhospitalizationPayFeeDto.getUnitType()))
      {
        fee = fee + prpLhospitalizationPayFeeDto.getFee();
      }
    }
  }
  String strHezuoFee = "";
  strHezuoFee = new DecimalFormat("#,##0.00").format(fee);
  
  
  UIEndorseAction uiEndorseAction = new UIEndorseAction();
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
  String strHandlerCode    = prpLcompensateDto.getHandlerCode();    //�����˴���
  String strHandlerName    = uiCodeAction.translateUserCode(strHandlerCode,isChinese);  
  String strUnderWriteName = prpLcompensateDto.getUnderWriteName();
  
         strInputDate      = prpLcompensateDto.getInputDate().getYear()
                             + "��" + prpLcompensateDto.getInputDate().getMonth()
                             + "��" + prpLcompensateDto.getInputDate().getDate()
                             + "��";
     if(!prpLcompensateDto.getUnderWriteEndDate().isEmpty())
     {
     strUnderWriteEndDate  = prpLcompensateDto.getUnderWriteEndDate().getYear()
                             + "��" + prpLcompensateDto.getUnderWriteEndDate().getMonth()
                             + "��" + prpLcompensateDto.getUnderWriteEndDate().getDate()
                             + "��";                 
     }
  
  //�õ�������
  strPolicyNo = prpLclaimDto.getPolicyNo();
  PrpCmainDto prpCmainDto    = policyDto.getPrpCmainDto();           //�õ������������ 
  strInsuredName    = prpCmainDto.getInsuredName();     //��������
  dblSumAmount1     = prpCmainDto.getSumAmount();      //���ս��
  
  String  RiskCode  = "" ;  //�������ִ���
  String  strRiskName = "" ;  //������������
  RiskCode = prpCmainDto.getRiskCode();//
  strRiskName = uiCodeAction.translateRiskCode(RiskCode,true);
  
    
  String strPayRefCode = "";
  String strPayRefName = "";
  String strPayRefDate = "";
  String strPayRefNo = "";
  
  BLPrpJpayRefRec blPrpJpayRefRec = new BLPrpJpayRefRec();
  PrpJpayRefRecSchema prpJpayRefRecSchema = new PrpJpayRefRecSchema();
  String strSQL = "certitype = 'C' and certiNo = '" + strCompensateNo + "'";
  blPrpJpayRefRec.query(strSQL);
  if(blPrpJpayRefRec.getSize()>0)
  {
    prpJpayRefRecSchema = blPrpJpayRefRec.getArr(0);
  }
  if(prpJpayRefRecSchema!=null)
  {
    strPayRefNo = prpJpayRefRecSchema.getPayRefNo();
  }
  if(!strPayRefNo.equals("")&&strPayRefNo.length()==21)
  {
    BLPrpJpayRefMainFacade blPrpJpayRefMainFacade = new BLPrpJpayRefMainFacade();
    PrpJpayRefMainDto prpJpayRefMainDto = new PrpJpayRefMainDto();
    String conditions = "PayRefNo = '" + strPayRefNo + "'";
    ArrayList prpJpayRefMainDtoList = new ArrayList();
    prpJpayRefMainDtoList = (ArrayList)blPrpJpayRefMainFacade.findByConditions(conditions);
    if(prpJpayRefMainDtoList!=null)
    {
      prpJpayRefMainDto = (PrpJpayRefMainDto)prpJpayRefMainDtoList.get(0);
    }
    strPayRefCode = prpJpayRefMainDto.getPayRefCode();
    strPayRefDate = "�������ڣ�"+prpJpayRefMainDto.getPayRefDate().getYear()+" �� "
                   +prpJpayRefMainDto.getPayRefDate().getMonth()+" �� "
                   +prpJpayRefMainDto.getPayRefDate().getDay()+" �� ";
    
    strPayRefName = "�����ˣ�"+uiCodeAction.translateUserCode(strPayRefCode,isChinese);
  }

  EndorseDto endorseDto = uiEndorseAction.findByConditions(strPolicyNo);//���ݱ����ŵõ���������
  ArrayList prpPheadDtoList = endorseDto.getPrpPheadDtoList();
  if(prpPheadDtoList!=null && prpPheadDtoList.size()>0){
     PrpPheadDto prpPheadDto = (PrpPheadDto)endorseDto.getPrpPheadDtoList().get(0); 
     strEndorseNo = prpPheadDto.getEndorseNo();
     
  }
  else {
    strEndorseNo="";
  } 
    
  PrpLregistDto  prpLregistDto = registDto.getPrpLregistDto(); //�õ�������Ϣ����
  strDamageAddress    = prpLregistDto.getDamageAddress();
  strDamageStartDate  = prpLregistDto.getDamageStartDate().getYear()
                       + "��" + prpLregistDto.getDamageStartDate().getMonth()
                       + "��" + prpLregistDto.getDamageStartDate().getDate()
                       + "��";
  String strDamageEndDate = "";
  strDamageEndDate  = prpLregistDto.getDamageEndDate().getYear()
                       + "��" + prpLregistDto.getDamageEndDate().getMonth()
                       + "��" + prpLregistDto.getDamageEndDate().getDate()
                       + "��";
  strReportHour       =  prpLregistDto.getReportHour().toString();
  String strTownName = prpLregistDto.getLicenseNo();
  String strAddressName = prpLregistDto.getInsuredAddress();
  strInsuredAddress = strTownName + strAddressName;
 
  //�õ�blPrpCitemKind����ļ�¼��
  if(policyDto.getPrpCitemKindDtoList()!=null){
    intItemKindCount     = policyDto.getPrpCitemKindDtoList().size();
  }  
  int indexl = 0;  
  //�õ�blPrpLcharge����ļ�¼��
  if(compensateDto.getPrpLchargeDtoList()!=null){
    indexl     = compensateDto.getPrpLchargeDtoList().size();
  }  
  //�õ�dbPrpLctext����ļ�¼��  
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    intCtextCount     = compensateDto.getPrpLctextDtoDtoList().size();
  }
 String strEndMoney =  new DecimalFormat("#,##0.00").format(prpLcompensateDto.getSumPrePaid());
 String strCEndMoney = MoneyUtils.toChinese(prpLcompensateDto.getSumPrePaid(),prpLcompensateDto.getCurrency()); 
 dblSumPaid = prpLcompensateDto.getSumDutyPaid();

 strCSumPaid     = MoneyUtils.toChinese(dblSumPaid,prpLcompensateDto.getCurrency());   

	dblPropSumLossPay = compensateDto.getPrpLcompensateDto().getLossSumRealPay();	  //�Ʋ���ʧ
	dblPersonSumLossPay = compensateDto.getPrpLcompensateDto().getPersonLossSumRealPay();	  //������ʧ
	dblSumLossPay = dblPropSumLossPay + dblPersonSumLossPay;	  //������
	
	double dbZongPayFee = fee + dblSumLossPay;
	String strZongPayFee = "";
    strZongPayFee = new DecimalFormat("#,##0.00").format(dbZongPayFee);
	
	strSumLossPay = new DecimalFormat("#,##0.00").format(dblSumLossPay);
	strCSumLossPay = MoneyUtils.toChinese(dblSumLossPay,prpLcompensateDto.getCurrency());   
	strSumPaid      = new DecimalFormat("#,##0.00").format(dblSumLossPay);    

    dblJudgeFee = 0;  
    dblCheckFee = 0;  
    dblLawFee   = 0;  
    dblElseFee  = 0;
    dblCheckFee1 = 0; 
    dblAssessFee = 0; 
    dblRescueFee = 0;

	String MJudgeFee = "CNY";
	String MCheckFee = "CNY";
	String MAssessFee = "CNY";
	String MRescueFee = "CNY";
	String MAgentFee = "CNY";
	String MElseFee = "CNY";
	String MGsjzFee = "CNY";
	String MFlFee = "CNY";
	
	intChargeCount = compensateDto.getPrpLchargeDtoList().size();
  if(compensateDto.getPrpLchargeDtoList()!=null){
    for(indexl=0;indexl<intChargeCount;indexl++)
    {
      prpLchargeDto = (PrpLchargeDto)compensateDto.getPrpLchargeDtoList().get(indexl);
      strChargeCode = StringConvert.encode(prpLchargeDto.getChargeCode()); 

      if( strChargeCode.equals("07") )       //������
      {    
        dblJudgeFee += prpLchargeDto.getChargeAmount();
        MJudgeFee =  prpLchargeDto.getCurrency();
      }   
      else if( strChargeCode.equals("06") )  //���鿱��
      {    
        dblCheckFee1 += prpLchargeDto.getChargeAmount();
      }   
      else if( strChargeCode.equals("05") )  //���Ϸ�
      {    
        dblLawFee   += prpLchargeDto.getChargeAmount();
      }
      else if( strChargeCode.equals("04") )  //�鿱��
      {    
        dblCheckFee += prpLchargeDto.getChargeAmount();
        MCheckFee =  prpLchargeDto.getCurrency();
      }
      else if( strChargeCode.equals("13") )  //������
      {    
        dblAssessFee += prpLchargeDto.getChargeAmount();
        MAssessFee  =  prpLchargeDto.getCurrency();
      }   
      else if( strChargeCode.equals("03"))   //ʩ�ȷ�
      {
        dblRescueFee += prpLchargeDto.getChargeAmount();        
        MRescueFee =  prpLchargeDto.getCurrency();
      }
      else if( strChargeCode.equals("09"))   //�����
      { 
        dblAgentFee  += prpLchargeDto.getChargeAmount();
        MAgentFee =  prpLchargeDto.getCurrency();
      }
      else if( strChargeCode.equals("11"))   //���������
      { 
        dblGsjzFee  += prpLchargeDto.getChargeAmount();
        MGsjzFee = prpLchargeDto.getCurrency();
      }
      else if( strChargeCode.equals("15"))   //���ɷ�
      { 
        dblFlFee  += prpLchargeDto.getChargeAmount();
        MFlFee = prpLchargeDto.getCurrency();
      }
      else if( strChargeCode.equals("99"))   //����
      { 
        dblElseFee  += prpLchargeDto.getChargeAmount();
        MElseFee =  prpLchargeDto.getCurrency();
      }
    }    
  }    
 
if (compensateDto.getPrpLlossDtoList()!=null && compensateDto.getPrpLlossDtoList().size()>0){
 
     PrpLlossDto   prpLlossDto = (PrpLlossDto)compensateDto.getPrpLlossDtoList().get(0);  // �õ��⸶�����Ϣ����
     dblSumLoss         = prpLlossDto.getSumLoss();
     strCurrency2       = prpLlossDto.getCurrency2();
     strCurrency2       = uiCodeAction.translateCurrencyCode(strCurrency2,true);
 }
 
  
  double sumloss = 0;
  sumloss = prpLpersonLossDto.getSumLoss();
  if(sumloss<=45000)
  {
    strContext = "����� = (�˶�ҽҩ�ѽ�� - 5000) * 35%<br>"
               +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; = ("+sumloss+" - 5000) * 35%<br>"
               +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; = "+strSumLossPay+"(Ԫ)";
  }
  if(sumloss>45000)
  {
    strContext = "����� = (�˶�ҽҩ�ѽ�� - 5000) * 35%<br>"
               +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; = ("+sumloss+" - 5000) * 35%<br>"
               +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; = (45000 - 5000) * 35% (<=45000)"
               +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; = 14000(Ԫ)";
  }
%>

<script language="javascript">
  function loadForm()
  {
    
    //���������PrpLcompensate
    //tdCompensateNo.innerHTML = '<%=strCompensateNo%>';

    //������Ϣ��PrpLclaim
    tdPolicyNo.innerHTML     = '<%=strPolicyNo%>';
  
<%    
    strInsuredDate = "�� " + prpLclaimDto.getStartDate().getYear()
                     + "��" + prpLclaimDto.getStartDate().getMonth()
                     + "��" + prpLclaimDto.getStartDate().getDate()
                     + "��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;ʱ��"
                     + "�� " + prpLclaimDto.getEndDate().getYear()
                     + "��" + prpLclaimDto.getEndDate().getMonth()
                     + "��" +prpLclaimDto.getEndDate().getDate()
                     + "�� ��ʮ�� ʱֹ";
%>   
    tdInsuredDate.innerHTML = '<%=strInsuredDate%>';
    tdInsuredName.innerHTML = '<%=strInsuredName%>';
    tdHandlerName.innerHTML = '<%="&nbsp;���ƣ�<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+strHandlerName
                                 +"<br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+strInputDate%>';
    tdUnderWriteName.innerHTML = '<%="&nbsp;������:<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+strUnderWriteName
                                 +"<br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+strUnderWriteEndDate%>';

    tdRescueFee.innerHTML = '&nbsp;'+ '<%=new DecimalFormat("#,##0.00").format(dblRescueFee)%>';  
	//�鿱��
    tdCheckFee.innerHTML = '&nbsp;' + '<%=new DecimalFormat("#,##0.00").format(dblCheckFee)%>';
    //���������
    tdJudgeFee.innerHTML = '&nbsp;'+ '<%=new DecimalFormat("#,##0.00").format(dblJudgeFee)%>';
	//���������
    tdGsjzFee.innerHTML = '&nbsp;'+ '<%=new DecimalFormat("#,##0.00").format(dblGsjzFee)%>';
	//������
    tdAssessFee.innerHTML = '&nbsp;'+ '<%=new DecimalFormat("#,##0.00").format(dblAssessFee)%>';
	//���ɷ�
    tdFlFee.innerHTML = '&nbsp;'+ '<%=new DecimalFormat("#,##0.00").format(dblFlFee)%>';
    //����
    tdElseFee.innerHTML  = '&nbsp;' + '<%=new DecimalFormat("#,##0.00").format(dblElseFee)%>';
 } 
</script>
  