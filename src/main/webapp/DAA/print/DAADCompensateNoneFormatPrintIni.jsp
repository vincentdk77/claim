<%--
****************************************************************************
* DESC       �����������������������ӡ��ʼ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16
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
<%@page import="com.sinosoft.sff.schema.PrpJpayRefRecSchema"%>
<%@page import="com.sinosoft.sff.blsvr.BLPrpJpayRefRec"%>
<%@page import="com.sinosoft.payment.bl.facade.BLPrpJpayRefMainFacade"%>
<%@page import="com.sinosoft.payment.dto.domain.PrpJpayRefMainDto"%>

<%
  //������������
  String strCompensateNo      = request.getParameter("CompensateNo"); //���������
  String strClaimNo           = "";   //������
  String strCaseNo            = "";   //������
  String strRegistNo          = "";   //������
  String strPolicyNo          = "";   //������
  String strRPolicyNo         = "";
  String strLicenseNo         = "";   //�����еĺ��ƺ���
  String strLicenseColorCode  = "";   //�����еĺ��Ƶ�ɫ
  String strLicenseNo1        = "";   //���⳵����Ϣ�еĺ��ƺ���
  String strLicenseColorCode1 = "";   //���⳵����Ϣ�еĺ��Ƶ�ɫ
  String strInsureCarFlag     = "";   //�Ƿ�Ϊ����������
  String strTextType           = "";
  String strContext           = "";   //������������
  String strContextLaw				= "";   //��ǿ����
  String strDamageStartDate   = "";   //����ʱ��
  String strInsuredDate       = "";   //�����ڼ�
  double dblJudgeFee          = 0;    //
  double dblCheckFee          = 0;    //
  double dblLawFee            = 0;    //
  double dblElseFee           = 0;    //
  double dblSumPrePaid        = 0;    //
  double dblSumRest           = 0;    //
  double dblCheckFee1         = 0; 
  double dblJianYan						= 0;
  double dblAssessFee         = 0; 
  String strSumThisPaid       = "";   //
  String strCSumThisPaid      = "";   //
  double dblSumThisPaid       = 0;    //
  
  String strSumPaid           = "";   //
  String strCSumPaid          = "";   //
  double dblSumPaid           = 0;    //
  String strChargeCode        = "";
  double dblSumAmount1        = 0;    //���ս��    
  double dblSumAmount2        = 0;    //�����޶�    
  String strRiskCode          = "";   //���ִ���     
  String strKindCode          = "";   //�ձ����     
  String strCalculateFlag     = "";   //�Ƿ���뱣��
  String strMessage           = "";
  String strUnderWriteName    = "";
  String strApproverCode      = "";
  String strOperatorCode      = "";
  String strApproverName      = "";
  String strOperatorName      = "";
  String strLossRate          = "";
  String strTitleName         = "��������������������";
  String strIndemnityType				= "";
  String strKindCodeThird			= ""; //�ж����������޶��־λ
  double strAmount						= 0; //���������޶�
  String strAllSumPaid       ="";
  String strCAllSumPaid			 ="";

  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
  int countNumber   = 0;
  int countNumber1  =0;

  //�����岿��
                                              
  PrpCitemCarDto    prpItemCarDto     = null;   //ItemCarDto���� 
  PrpCitemKindDto    prpItemKindDto     = null;   //������ItemKindDto����
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto����
  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto����
  PrpLchargeDto      prpLchargeDto      = null;   //ChargeDto����

  PrpLctextDto       prpLctextDto       = null; 
  PrpLdriverDto      prpLdriverDto      = null;
  PrpCcarDriverDto   prpCcarDriverDto   = null;
  PrpLregistDto      prpLregistDto      = null;
  PrpLpropDto        prpLpropDto        = null;
  PrpLextDto         prpLextDto         = null;
  
  int intCompensateCount = 0;   //CompensateDto����ļ�¼��
  int intItemCarCount    = 0;   //ItemcarDto����ļ�¼��
  int intItemKindCount   = 0;   //ItemKindDto����ļ�¼��
  int intThirdPartyCount = 0;   //ThirdPartyDto����ļ�¼��
  int intChargeCount     = 0;   //ChargeDto����ļ�¼��
  int intCtextCount      = 0;   //CtextDto����ļ�¼��
  int intCtextCountTmp   = 0;   //textarea����
  int intDriverCount     = 0;   //DriverDto����ļ�¼��
  int intCriverCount     = 0;   //prpCcarDriverDto����ļ�¼��
  int intPropCount       = 0;
  String lossDesc        = "";  //��ʧ�̶�
  
  int intLossCount = 0;
  int intPersonLossCount = 0;
  
  double lawSumPaid      =0;
  String strLawSumPaid   ="";
  String strLawCSumPaid  = "";
  
  String strContexTtemp = "";
  String strDisplay = "";
    
  int index = 0;
  
  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto����
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  CheckDto checkDto = (CheckDto)request.getAttribute("checkDto"); 
  CompensateDto compensateDto = (CompensateDto)request.getAttribute("compensateDto"); 
  CertainLossDto certainLossDto = (CertainLossDto)request.getAttribute("certainLossDto");
  
  EndorseDto endorseDto = (EndorseDto)request.getAttribute("endorseDto");
   
  UICodeAction uiCodeAction = new UICodeAction();
  //�õ�prpLcompensateDto ����
  prpLcompensateDto   = compensateDto.getPrpLcompensateDto();
  //�õ��Ƿ��Ƿ����������־
  if(prpLcompensateDto.getFlag()!=null&&!prpLcompensateDto.getFlag().equals("")){
     if(prpLcompensateDto.getFlag().substring(3,5)!=null&&prpLcompensateDto.getFlag().substring(3,5).equals("B1")){
        strTitleName = "��������������������(��������)";
     }
  }
  
  //�õ�prpLclaimDto����
  prpLclaimDto   = claimDto.getPrpLclaimDto();
  
  //�õ�prpLregistDto����
  prpLregistDto  = registDto.getPrpLregistDto();
  
  strClaimNo = prpLclaimDto.getClaimNo(); 
  strRegistNo = prpLclaimDto.getRegistNo();
  strRiskCode = prpLclaimDto.getRiskCode();
  strCaseNo   = prpLclaimDto.getCaseNo();
  strIndemnityType = prpLclaimDto.getDamageTypeName();
  if(strCaseNo == null){
    strCaseNo = "";
  }
  strOperatorCode   = prpLcompensateDto.getHandlerCode();    
  strOperatorName   = uiCodeAction.translateUserCode(strOperatorCode,isChinese); 
  DateTime dateTime = new DateTime();
  //String strDateTime = new DateTime(dateTime.current(),dateTime.YEAR_TO_HOUR);
  
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
    strPayRefDate = "�������ڣ�"
                   +prpJpayRefMainDto.getPayRefDate().getYear()+" �� "
                   +prpJpayRefMainDto.getPayRefDate().getMonth()+" �� "
                   +prpJpayRefMainDto.getPayRefDate().getDay()+" �� ";
    
    strPayRefName = "�����ˣ�"+uiCodeAction.translateUserCode(strPayRefCode,true);
  }
  
  
  //�õ�������
  strPolicyNo = prpLclaimDto.getPolicyNo();
  
  
   UIPrpLregistRPolicyAction uiPrpLregistRPolicyAction  = new UIPrpLregistRPolicyAction(); 
  Collection collection =	uiPrpLregistRPolicyAction.findByConditions("registNo = '" + strRegistNo + "'"); 
  if(collection != null){
  for(Iterator iterator = collection.iterator();iterator.hasNext();){
  	PrpLRegistRPolicyDto prpLRegistRPolicyDto = (PrpLRegistRPolicyDto)iterator.next();
  	if(strPolicyNo.equals(prpLRegistRPolicyDto.getPolicyNo()) || strPolicyNo == prpLRegistRPolicyDto.getPolicyNo()){
  	  
  	}
  	else{
  		  strRPolicyNo = prpLRegistRPolicyDto.getPolicyNo();
  		 }
  }
  }
  
  //�õ�blPrpCitemCar���� 
  if(policyDto.getPrpCitemCarDtoList()!=null){
    intItemCarCount     = policyDto.getPrpCitemCarDtoList().size();
  }  
  
  //�õ�blPrpCitemKind����ļ�¼��
  if(policyDto.getPrpCitemKindDtoList()!=null){
    intItemKindCount     = policyDto.getPrpCitemKindDtoList().size();
  }  
    
  //�õ�blPrpLthirdParty����ļ�¼��  
  if(claimDto.getPrpLthirdPartyDtoList()!=null){
    intThirdPartyCount     = claimDto.getPrpLthirdPartyDtoList().size();
  }
    
  //�õ�blPrpLcharge����ļ�¼��
  if(compensateDto.getPrpLchargeDtoList()!=null){
    intChargeCount     = compensateDto.getPrpLchargeDtoList().size();
  }  
  
   //�õ�blPrpLloss����ļ�¼��
  if(compensateDto.getPrpLlossDtoList()!=null){
    intLossCount     = compensateDto.getPrpLlossDtoList().size();
  }  
  
  
  //�õ�blPrpLPersonloss����ļ�¼��
  if(compensateDto.getPrpLpersonLossDtoList()!=null){
    intPersonLossCount     = compensateDto.getPrpLpersonLossDtoList().size();
  }     
 
  
  //�õ�dbPrpLctext����ļ�¼��  
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    intCtextCount     = compensateDto.getPrpLctextDtoDtoList().size();
  }
  
  //�õ���ʧ�̶�����
  if (claimDto.getPrpLthirdCarLossDtoList() != null) {
     for(index=0;index<claimDto.getPrpLthirdCarLossDtoList().size();index++){
      PrpLthirdCarLossDto prpLthirdCarLossDto = (PrpLthirdCarLossDto) claimDto.getPrpLthirdCarLossDtoList().get(0);
      lossDesc = prpLthirdCarLossDto.getLossDesc();
      }
  }
  //Ԥ��������Ԥ��������Ϊ�м��⸶��׼�� begin 20060208 huangyunzhong
  ArrayList compensateList = new ArrayList();
  int intCompensatePreCount = 0;
  //DateTime inputDate = prpLcompensateDto.getInputDate();
  String strClaimNoConditions  = "";
  strClaimNoConditions  = " claimno = '" + strClaimNo + "'";
  UICompensateAction uiCompensateAction = new UICompensateAction();
  compensateList = (ArrayList)uiCompensateAction.findByClaimNo(strClaimNoConditions);
  if (compensateList != null){
     for(index=0;index<compensateList.size();index++){
      PrpLcompensateDto prpLcompensateDtoForPre = (PrpLcompensateDto) compensateList.get(index);
      if(!prpLcompensateDtoForPre.getCompensateNo().equals(strCompensateNo)&&!prpLcompensateDtoForPre.getFinallyFlag().equals("1")&&prpLcompensateDtoForPre.getUnderWriteFlag().equals("1"))
        {
         //DateTime inputDatePre = prpLcompensateDtoForPre.getInputDate();
          intCompensatePreCount ++;
          dblSumPrePaid = dblSumPrePaid + prpLcompensateDtoForPre.getSumThisPaid();
        }
      }
  }
  //Ԥ��������Ԥ��������Ϊ�м��⸶��׼�� end 20060208 huangyunzhong
     String strInputDate = "";
      strInputDate      = prpLcompensateDto.getInputDate().getYear()
                             + "��" + prpLcompensateDto.getInputDate().getMonth()
                             + "��" + prpLcompensateDto.getInputDate().getDate()
                             + "��";
      String strUnderWriteEndDate = "";
      strUnderWriteEndDate  = prpLcompensateDto.getUnderWriteEndDate().getYear()
                             + "��" + prpLcompensateDto.getUnderWriteEndDate().getMonth()
                             + "��" + prpLcompensateDto.getUnderWriteEndDate().getDate()
                             + "��"; 
%>

<script language="javascript">
  function loadForm()
  {
        
    //---------���������PrpLcompensate*****
    tdCompensateNo.innerHTML  = '��������ţ�' + '<%=strCompensateNo%>';
    
<%  
	double dbClaimFee = 0;       //����������
	double dblPrplChargeFee=0;   //������
	if(compensateDto.getPrpLchargeDtoList()!=null){
    for(index=0;index<intChargeCount;index++)
    {
      prpLchargeDto = (PrpLchargeDto)compensateDto.getPrpLchargeDtoList().get(index);
      strChargeCode = StringConvert.encode(prpLchargeDto.getChargeCode()); 
      if(prpLchargeDto.getChargeAmount()==prpLchargeDto.getSumRealPay()&&!strChargeCode.equals("28")){
        dblPrplChargeFee += prpLchargeDto.getSumRealPay();
      }
      if( strChargeCode.equals("28") )       //����������
      {    
        dbClaimFee += prpLchargeDto.getChargeAmount();
      }
      
    }
    }
   
   
   //�õ�blPrpLloss����ļ�¼��
   double dblPrplLoss = 0;
   double dblPrplPersonLoss=0;
  
   if(compensateDto.getPrpLlossDtoList()!=null){
    for(index=0;index<intLossCount;index++)
    {
      PrpLlossDto prpLlossDto = (PrpLlossDto)compensateDto.getPrpLlossDtoList().get(index);
      dblPrplLoss +=prpLlossDto.getSumRealPay();
      
    }
   }
   
   //�õ�blPrpLPersonloss����ļ�¼��
   if(compensateDto.getPrpLpersonLossDtoList()!=null){
    for(index=0;index<intPersonLossCount;index++)
    {
      PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto)compensateDto.getPrpLpersonLossDtoList().get(index);
      dblPrplPersonLoss +=prpLpersonLossDto.getSumRealPay();
      
    }
   }
   
   

  
  
   if(strRiskCode.equals("0507")||strRiskCode.equals("0577")||strRiskCode.equals("0587"))
   {
     
     double lawSumPaidTmp=0;
     

    
    lawSumPaid      = prpLcompensateDto.getSumDutyPaid();   
    lawSumPaidTmp = Math.abs(lawSumPaid);      
    strLawSumPaid      = new DecimalFormat("#,##0.00").format(lawSumPaid);    
    strLawCSumPaid     = MoneyUtils.toChinese(lawSumPaidTmp,prpLcompensateDto.getCurrency()); 
    if(lawSumPaid<0){
       strLawCSumPaid = "��"+strLawCSumPaid;
    }

  }
  
   else
   {

   double dblSumThisPaidTmp=0;
   double dblSumPaidTmp=0;
  
    //��Ԥ��������Ϊ�м��⸶
    
    dblSumRest      = prpLcompensateDto.getSumRest();     
    dblSumThisPaid  = prpLcompensateDto.getSumThisPaid(); 
    strSumThisPaid  = new DecimalFormat("#,##0.00").format(dblSumThisPaid);

    dblSumThisPaidTmp = Math.abs(dblSumThisPaid);
    strCSumThisPaid = MoneyUtils.toChinese(dblSumThisPaidTmp,prpLcompensateDto.getCurrency());
    if(dblSumThisPaid<0){
       strCSumThisPaid = "��"+strCSumThisPaid;
    }
    //dblSumPaid      = prpLcompensateDto.getSumDutyPaid() - dbClaimFee;   
    dblSumPaid = dblPrplChargeFee+dblPrplLoss+dblPrplPersonLoss;
    
    dblSumPaidTmp = Math.abs(dblSumPaid);      
    strSumPaid      = new DecimalFormat("#,##0.00").format(dblSumPaid);    
    strCSumPaid     = MoneyUtils.toChinese(dblSumPaidTmp,prpLcompensateDto.getCurrency()); 
    if(dblSumPaid<0){
       strCSumPaid = "��"+strCSumPaid;
    }
    
    }
    
    
    //���������ҵ���뽻ǿ�պϼ���Ϣ--��ʱ
    double dblCAllSumPaidTmp=0;
    double dblCAllSumPaid=0;
    

  
    dblCAllSumPaid=lawSumPaid+dblSumPaid;
    dblCAllSumPaidTmp=Math.abs(dblCAllSumPaid);
    strAllSumPaid       = new DecimalFormat("#,##0.00").format(dblCAllSumPaid);
    strCAllSumPaid     = MoneyUtils.toChinese(dblCAllSumPaidTmp,prpLcompensateDto.getCurrency()); 
    if(dblSumPaid<0){
       strCAllSumPaid = "��"+strCAllSumPaid;
    }
    String dbSumPrePaid = new DecimalFormat("#,##0.00").format(prpLcompensateDto.getSumPrePaid());
      
%>
    tdSumPrePaid.innerHTML    = '&nbsp;��Ԥ����'    + '<%=dbSumPrePaid%>'                ;
    tdSumRest.innerHTML       = '&nbsp;��������/��ֵ��'           + '<%=DataUtils.zeroToEmpty(dblSumRest)%>';
 <!--   tdCSumThisPaid.innerHTML  = '&nbsp;����ʵ��������Ҵ�д����'  + '<%=strCSumThisPaid%>'; -->
 <!--   tdSumThisPaid.innerHTML   = '������'                        + '<%=strSumThisPaid%>'; -->
    tdCSumPaid.innerHTML      = '&nbsp;��ҵ�������ϼƣ�����Ҵ�д����'      + '<%=strCSumPaid%>';
    tdSumPaid.innerHTML       = 'Ԫ������'                        + '<%=strSumPaid%>';
    
    tdCAllSumPaid.innerHTML      = '&nbsp;���ϼƣ�����Ҵ�д����'      + '<%=strCAllSumPaid%>';
    tdAllSumPaid.innerHTML       = 'Ԫ������'                        + '<%=strAllSumPaid%>';
    
    
    tdHandlerName.innerHTML   =  '<%="�����ˣ�<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+strOperatorName%>';      
   <% String compensateFlag="0";
      compensateFlag =request.getParameter("compensateFlag");
      if(compensateFlag != null || !"1".equals(prpLcompensateDto.getUnderWriteFlag()))
    { %>
   tdUnderWriteName.innerHTML = '<%="�����ˣ�"%>';
 <%  }else{%>
  tdUnderWriteName.innerHTML = '<%="�����ˣ�<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+prpLcompensateDto.getUnderWriteName()%>' ; 
 <% }%>
   
    tdInputDate.innerHTML     = '<%=strInputDate%>';
    <%
    if("1".equals(prpLcompensateDto.getUnderWriteFlag())){
    %>
    tdUnderWriteEndDate.innerHTML =  '<%=strUnderWriteEndDate%>';
    <%
    }
    %>
    
   
    
    
    
    //������Ϣ��PrpLclaim*****
    tdPolicyNo.innerHTML     = '���յ��ţ�'+'<%=strPolicyNo%>' + '  <%=strRPolicyNo%>';
    tdInsuredName.innerHTML  = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
    tdIndemnityType.innerHTML = '<%=strIndemnityType%>';
    tdRegistNo.innerHTML     = '������ţ�'+'<%=strRegistNo%>';
   
  <!--  tdCaseNo.innerHTML     = '<%=strCaseNo%>'; -->
<%    
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                        + "��" +prpLclaimDto.getDamageStartDate().getMonth()
                        + "��" + prpLclaimDto.getDamageStartDate().getDate()
                        + "��";
    String damangeAddressType = uiCodeAction.translateCodeCode("DamageAddress",prpLregistDto.getDamageAddressType(),true);
%>                    
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>';
<!--tdDamageName.innerHTML      = '<%=StringConvert.encode(prpLclaimDto.getDamageName())%>'; -->
<!--    tdSumClaim.innerHTML        = '<%= lossDesc %>';     -->
    tdDamageAddress.innerHTML   = '<%=StringConvert.encode(prpLclaimDto.getDamageAddress())%>';
 <!--   tdDamageAddressType.innerHTML   = '<%=damangeAddressType%>';  -->
<%    
    //�¹�����
    strCode = ""; 
    strName = "";
    strCode = StringConvert.encode(prpLclaimDto.getIndemnityDuty());
    strName = uiCodeAction.translateCodeCode("IndemnityDuty",strCode,isChinese);
%>
<!--    tdIndemnityDuty.innerHTML     = '<%=strName%>';  -->
    tdIndemnityDutyRate.innerHTML = '<%=new DecimalFormat("#,##0.00").format(prpLcompensateDto.getIndemnityDutyRate())%>'+'��';
<%    
    strInsuredDate = "�� " + prpLclaimDto.getStartDate().getYear()
                     + "��" +prpLclaimDto.getStartDate().getMonth()
                     + "��" + prpLclaimDto.getStartDate().getDate()
                     + "�� ��ʱ��"
                     + "�� " + prpLclaimDto.getEndDate().getYear()
                     + "��" + prpLclaimDto.getEndDate().getMonth()
                     + "��" + prpLclaimDto.getEndDate().getDate()
                     + "�� ��ʮ��ʱֹ";
%>                    
    tdInsuredDate.innerHTML = '<%=strInsuredDate%>';
    
    //---------���⳵����ϢPrpLthirdParty*****  
<%
    //modify by lixiaohua 20040326 begin reason �������鳧���ͺŴ�ӡ����
  if(policyDto.getPrpCitemCarDtoList()!=null){
    for(index=0;index<intItemCarCount;index++)
    { 
       prpItemCarDto = (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(index);
        strLicenseNo        = StringConvert.encode(prpItemCarDto.getLicenseNo());
        strLicenseColorCode = StringConvert.encode(prpItemCarDto.getLicenseColorCode());
%>
        tdLicenseNo.innerHTML    = '<%=StringConvert.encode(prpItemCarDto.getLicenseNo())%>';
        tdBrandName.innerHTML    = '<%=StringConvert.encode(prpItemCarDto.getBrandName())%>';
<%
        //�������
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(prpItemCarDto.getClauseType());
        strName = uiCodeAction.translateCodeCode("ClauseType",strCode,isChinese);
%>  
        tdCarClause.innerHTML		= '<%=strName%>';      
<%
    }    
  }      

  if(policyDto.getPrpCitemCarDtoList()!=null){
    //---------�������ձ����Ϣ��PrpCitemCar*****    
    for(index=0;index<intItemCarCount;index++)
    {
      prpItemCarDto = (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(index);
      strLicenseNo1 = StringConvert.encode(prpItemCarDto.getLicenseNo()); 
           
      if( strLicenseNo1.equals(strLicenseNo)&& prpItemCarDto.getPurchasePrice()!=0 )
      {    
%>        
        tdPurchasePrice.innerHTML = '<%=new DecimalFormat("#,##0.00").format(prpItemCarDto.getPurchasePrice())%>';
<%
      }
    }
  }  
    
    //---------���������ϢPrpCitemKind*****
    dblSumAmount1 = 0;
    dblSumAmount2 = 0;
    
  if(policyDto.getPrpCitemKindDtoList()!=null){
    for(index=0;index<intItemKindCount;index++)
    {
      prpItemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
      //strRiskCode = prpItemKindDto.getRiskCode();
      //strKindCode = prpItemKindDto.getKindCode();
      //dbPrpDkind.getInfo(strRiskCode,strKindCode);
      //strCalculateFlag = dbPrpDkind.getCalculateFlag().substring(0,2);
      strCalculateFlag = prpItemKindDto.getCalculateFlag();   
      strKindCodeThird	= prpItemKindDto.getKindCode(); 
      //strCalculateFlag="Y1";
      if( strCalculateFlag.equals("Y") ) 
      {
        dblSumAmount1 += prpItemKindDto.getAmount();
      }
      if( strCalculateFlag.equals("A") ) 
      {
      //  dblSumAmount2 += prpItemKindDto.getAmount();
      } 
      if(strKindCodeThird.equals("B"))
      {
        strAmount=prpItemKindDto.getAmount();	
      }  
       if(strKindCodeThird.equals("A"))
      {
        dblSumAmount2=prpItemKindDto.getAmount();	
      }     
    }    
  }  

%>
    tdSumAmount1.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount2)%>';
 <!--   tdSumAmount2.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount2)%>';  -->
  
     
    
    tdAmount.innerHTML = '<%=new DecimalFormat("#,##0.00").format(strAmount)%>';
<%    
  
  
  if(strRiskCode.equals("0507")||strRiskCode.equals("0577")||strRiskCode.equals("0587"))
  {
  	//��ǿ�յĲ�������
  }
  else
  {
  
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    //------------���������ֱ�PrpLctext*****
    for(index=0;index<intCtextCount;index++)
    {
      prpLctextDto = (PrpLctextDto)compensateDto.getPrpLctextDtoDtoList().get(index);
      strTextType = StringConvert.encode(prpLctextDto.getTextType());
      if ( strTextType.charAt(0)=='1' || strTextType.charAt(0)=='7' )
      {      
        strContext = strContext + StringConvert.encode(prpLctextDto.getContext()) ;
      }
    }    
  }

    
    //�����������ִ�����Ǽ���
    intCtextCountTmp = 0;    //textarea������


    
    for(index=0;index<strContext.length();index++)
    {
      if(strContext.substring(index,index+1).equals("\\"))
      {
        if(!(strContext.substring(index).length()<4))
        {
          if(strContext.substring(index,index+4).equals("\\r\\n"))
          {
             intCtextCountTmp += 1;    //ֻҪ�лس����У�intCtextCountTmp+1
          }
        }
      }
    }
    
    int x1 = 0;
    int y1 = 0;
    if(!(strContext.length()<4))    //���strContext.length()>=4���ж�strContext��β�����֣����ǻس�����
    {
      x1 = strContext.length()-4;
      y1 = strContext.length();
      if(!strContext.substring(x1,y1).equals("\\r\\n"))
      {
         intCtextCountTmp += 1;   
      }
    }
    else    //���strContext����1�У�intCtextCountTmp = 1; 
      intCtextCountTmp = 1; 
    
   while(strContext.indexOf("\\r\\n")!=-1)
   		strContext=strContext.substring(0,strContext.indexOf("\\r\\n"))+"<br>"+strContext.substring(strContext.indexOf("\\r\\n")+"\\r\\n".length());   
   if( intCtextCountTmp>20 )
   {
	  strContexTtemp = strContext;
	  strDisplay = "";
      strContext = "<br/>��������Ϣ���࣬������嵥��";
      for(int k = 0;k < 18;k++){
    	  strContext += "</br>";
      }
   }
    
 }
%>  
   tdContext.innerHTML = ''+'<br>'+'<%=strContext%>';
  
<%    

    //--------��������Ϣ��PrpLcharge*****    
    dblJudgeFee = 0;  
    dblCheckFee = 0;  
    dblLawFee   = 0;  
    dblElseFee  = 0;
    dblCheckFee1 = 0; 
    dblAssessFee = 0; 
    dblJianYan   =0;
  if(strRiskCode.equals("0507")||strRiskCode.equals("0577")||strRiskCode.equals("0587"))
   {
   }
  else
   {
  if(compensateDto.getPrpLchargeDtoList()!=null){
    for(index=0;index<intChargeCount;index++)
    {
      prpLchargeDto = (PrpLchargeDto)compensateDto.getPrpLchargeDtoList().get(index);
      strChargeCode = StringConvert.encode(prpLchargeDto.getChargeCode()); 
      if(!prpLchargeDto.getChangeFlag().equals("0")){
          //continue;//add by qinyongli ����ֻ��ӡԭʼ����
      }      
      if( strChargeCode.equals("07") )       //������
      {    
        dblJudgeFee += prpLchargeDto.getChargeAmount();
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
      }
      else if( strChargeCode.equals("13") )  //������
      {    
        dblAssessFee += prpLchargeDto.getChargeAmount();
      }   
      else if( strChargeCode.equals("01") )  //�����
      {    
        dblJianYan += prpLchargeDto.getChargeAmount();
      }   
      else if( strChargeCode.equals("28") )  //���������ò���ʾ
      {
      }
      else                                   //��������
      {    
        dblElseFee  += prpLchargeDto.getChargeAmount();
      }   
    }    
  }    
  //��ȡ�⳥����
  double ThelossRate = 0;
  if(compensateDto.getPrpLlossDtoList()!=null){
    for(index=0;index<compensateDto.getPrpLlossDtoList().size();index++)
    {
      PrpLlossDto prpLlossDto = (PrpLlossDto)compensateDto.getPrpLlossDtoList().get(0);
      ThelossRate = prpLlossDto.getIndemnityDutyRate();
       break;
    }    
  }    
 }
  
  
%>    
    tdJudgeFee.innerHTML = '&nbsp;�����ѣ�'   + '<%=DataUtils.zeroToEmpty(dblJudgeFee)%>';
    tdCheckFee1.innerHTML = '&nbsp;���鿱�ѣ�' + '<%=DataUtils.zeroToEmpty(dblCheckFee1)%>';
    tdLawFee.innerHTML   = '&nbsp;���ϡ��ٲ÷ѣ�'   + '<%=DataUtils.zeroToEmpty(dblLawFee)%>';
    tdElseFee.innerHTML  = '&nbsp;�������ã�' + '<%=DataUtils.zeroToEmpty(dblElseFee)%>';
    tdCheckFee.innerHTML = '&nbsp;�鿱�ѣ�' + '<%=DataUtils.zeroToEmpty(dblCheckFee)%>';
    tdAssessFee.innerHTML = '&nbsp;�����ѣ�' + '<%=DataUtils.zeroToEmpty(dblAssessFee)%>';
    tdJianYan.innerHTML = '&nbsp;����ѣ�' + '<%=DataUtils.zeroToEmpty(dblJianYan)%>';
<%  
    //strSumThisPaid  = new DecimalFormat("#,##0.00").format(dblSumThisPaid-dblJudgeFee-dblCheckFee-dblLawFee-dblElseFee-dblSumPrePaid-dblSumRest);
    //strCSumThisPaid = MoneyUtils.toChinese(dblSumThisPaid-dblJudgeFee-dblCheckFee-dblLawFee-dblElseFee-dblSumPrePaid-dblSumRest,prpLcompensateDto.getCurrency());
      double finalyPaidTmp = 0;
      if((dblSumThisPaid-dblJudgeFee-dblCheckFee-dblLawFee-dblElseFee-dblSumRest)<0){
         finalyPaidTmp = Math.abs(dblSumThisPaid-dblJudgeFee-dblCheckFee-dblLawFee-dblElseFee-dblSumRest);
      }else{
         finalyPaidTmp = dblSumThisPaid-dblJudgeFee-dblCheckFee-dblLawFee-dblElseFee-dblSumRest;
      }
      strSumThisPaid  = new DecimalFormat("#,##0.00").format(dblSumThisPaid-dblJudgeFee-dblCheckFee-dblLawFee-dblElseFee-dblSumRest);
      strCSumThisPaid = MoneyUtils.toChinese(finalyPaidTmp,prpLcompensateDto.getCurrency());
      if((dblSumThisPaid-dblJudgeFee-dblCheckFee-dblLawFee-dblElseFee-dblSumRest)<0){
         strCSumThisPaid = "��"+ strCSumThisPaid;
      }
%>    
 <!--   tdCSumThisPaid.innerHTML  = '&nbsp;����ʵ��������Ҵ�д����'  + '<%=strCSumThisPaid%>';     -->
  <!--   tdSumThisPaid.innerHTML   = '������'                        + '<%=strSumThisPaid%>';           -->
<%    
    //---------������Ϣ��PrpLdriver*****  
    if(registDto.getPrpLdriverDtoList() != null){    
    intDriverCount = registDto.getPrpLdriverDtoList().size();
    for(index=0;index<intDriverCount;index++)
    {
      prpLdriverDto     = (PrpLdriverDto)registDto.getPrpLdriverDtoList().get(index) ;

%>        
   <!--     tdDriverName.innerHTML         = '<%=StringConvert.encode(prpLdriverDto.getDriverName())%>';  -->
        //tdDriverName1.innerHTML         = '<%=StringConvert.encode(prpLdriverDto.getDriverName())%>';
        
<%  
   }  
   }
   if(policyDto.getPrpCcarDriverDtoList() != null){
   intCriverCount = policyDto.getPrpCcarDriverDtoList().size();
   for(index=0;index<intCriverCount;index++)
   {
     prpCcarDriverDto = (PrpCcarDriverDto) policyDto.getPrpCcarDriverDtoList().get(index);
     if (prpCcarDriverDto.getChangelessFlag().equals("1")) {
     %>
  <!--       tdDriverName1.innerHTML         = '<%=StringConvert.encode(prpCcarDriverDto.getDriverName())%>'; -->
     <%
     }
   }
   }
%> 
<%
  String claimType = prpLregistDto.getClaimType();
  String strClaimType = uiCodeAction.translateCodeCode("CaseCode",claimType,true);
  String handleUnit = prpLregistDto.getHandleUnit();
  String strHandleUnit = uiCodeAction.translateCodeCode("HandleUnit",handleUnit,true);
%>
 <!--   tdClaimType.innerHTML = '<%=strClaimType%>';  -->
  <!--  tdHandleUnit.innerHTML = '<%=strHandleUnit%>'; -->
<!--    tdRunAreaName.innerHTML = '<%=prpLregistDto.getDamageAreaName()%>'; -->

  
  <!--  tdRemark.innerHTML = '��ע��'; -->
<%
  double douDelinquentFee = 0;
  String strDelinquentFee = "";
  String strPlanFee = "";
  if(policyDto.getPrpCplanDtoList()!=null){
    int intPlanCount = policyDto.getPrpCplanDtoList().size();
    for(index=0;index<intPlanCount;index++){
      PrpCplanDto prpCplanDto = (PrpCplanDto)policyDto.getPrpCplanDtoList().get(index);      
      douDelinquentFee = prpCplanDto.getDelinquentFee();
      if(douDelinquentFee==0){
        strDelinquentFee = "��";
        strPlanFee = "������";
      }else{
        strDelinquentFee = "��";
        strPlanFee = "��Ƿ���ѣ�"+douDelinquentFee;
      }
%>
  <!-- tdEndorseNo.innerHTML  = '<%=prpCplanDto.getEndorseNo()%>'; -->	
  <!-- tdRemark.innerHTML = '��ע��'+'<br>'+'���ѽɷ������'+'<%=strPlanFee%>' + '<br>'+'�����������ڣ�'+'<%=prpCplanDto.getPlanDate()%>'+'<br>'+'�տ��ˣ�'+''; -->
   //tdSerialNo.innerHTML  = '��Ԥ��������'+'<%=DataUtils.zeroToEmpty(prpCplanDto.getSerialNo()-1)%>';
  <!-- tdSerialNo.innerHTML  = '��Ԥ��������'+'<%=DataUtils.zeroToEmpty(intCompensatePreCount)%>'; -->
<%
    }
  }
%>
<%
   prpLextDto = registDto.getPrpLextDto();
   if(prpLextDto != null){
     long personInjureB  = prpLextDto.getPersonInjureB();
     long personDeathB   = prpLextDto.getPersonDeathB();
     long personInjureD1 = prpLextDto.getPersonInjureD1();
     long personDeathD1  = prpLextDto.getPersonDeathD1();
     String personInjure1 = "";
     String personInjure2 = "";
     String personInjure = "�����ߣ��� "+personInjureB+" �ˣ��� "+personDeathB+" �ˣ���������Ա���� "
                            +personInjureD1+" �ˣ� �� "+personDeathD1+" �ˣ�";
     
     if(personInjureB==0){
       if(personDeathB==0){
         personInjure1 = "";
       }else{
         personInjure1 = "�����ߣ��� "+personDeathB+" �ˣ���";
       }  
     }else{
       if(personDeathB==0){
         personInjure1 = "�����ߣ��� "+personInjureB+" �ˣ���";
       }else{
         personInjure1 = "�����ߣ��� "+personInjureB+" �ˣ��� "+personDeathB+" �ˣ���";
       }
     }
     if(personInjureD1==0){
       if(personDeathD1==0){
         personInjure2 = "";
       }else{
         personInjure2 = "������Ա���� "+personDeathD1+" �ˣ�";
       }  
     }else{
       if(personDeathD1==0){
         personInjure2 = "������Ա���� "+personInjureD1+" �ˣ�";
       }else{
         personInjure2 = "������Ա���� "+personInjureD1+" �ˣ� �� "+personDeathD1+" �ˣ�";
       }
     }
     personInjure = personInjure1 + personInjure2; 
     if((prpLextDto.getPersonInjureB()==0)&&(prpLextDto.getPersonDeathB()==0)&&(prpLextDto.getPersonInjureD1()==0)&&(prpLextDto.getPersonDeathD1()==0)){
       personInjure = "����Ա����";
     }
%>
<!--   tdPersonInjure.innerHTML = '<%=personInjure%>';  -->
<%
  }
%>
<%
  String strEndorseNo = "";
  if(endorseDto.getPrpPheadDtoList()!=null){
    for(index=0;index<endorseDto.getPrpPheadDtoList().size();index++){
      PrpPheadDto prpPheadDto = (PrpPheadDto)endorseDto.getPrpPheadDtoList().get(index);
      strEndorseNo = prpPheadDto.getEndorseNo();
%>
 <!--  tdEndorseNo.innerHTML = '<%=strEndorseNo%>';  -->
<%
    }
  }
%>
   
}  
</script>
  