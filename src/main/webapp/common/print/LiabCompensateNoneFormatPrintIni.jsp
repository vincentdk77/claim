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
  String strRegistNo          = "";   //������
  String strPolicyNo          = "";   //������
  String strLicenseNo         = "";   //�����еĺ��ƺ���
  String strLicenseColorCode  = "";   //�����еĺ��Ƶ�ɫ
  String strLicenseNo1        = "";   //���⳵����Ϣ�еĺ��ƺ���
  String strLicenseColorCode1 = "";   //���⳵����Ϣ�еĺ��Ƶ�ɫ
  String strInsureCarFlag     = "";   //�Ƿ�Ϊ����������
  String strTextType          = "";
  String strContext           = "&nbsp;���㹫ʽ�������<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";   //������������
  String strContexTtemp       = "&nbsp;���㹫ʽ�������<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";   //�����㷽ʽ�嵥�е� ������������
  String strContext1          = "";
  String strDamageStartDate   = "";   //����ʱ��
  String strDamageName        = "";   //����ԭ��
  String strReportHour        = "";   //����ʱ��Сʱ
  String strInsuredDate       = "";   //�����ڼ�
  double dblJudgeFee          = 0;    //
  double dblCheckFee          = 0;    //
  double dblLawFee            = 0;    //
  double dblElseFee           = 0;    //
  double dblSumPrePaid        = 0;    //
  double dblSumRest           = 0;    //
  double dblCheckFee1         = 0; 
  double dblAssessFee         = 0; 
  double dblRescueFee         = 0;    //ʩ�ȷ�
  double dblGsjzFee			  = 0;	  //����������
  double dblFlFee			  = 0;	  //���ɷ�
  double dblAgentFee          = 0;    //�����
  double dblPropSumLossPay	  = 0;	  //�Ʋ���ʧ
  double dblPersonSumLossPay  = 0;	  //������ʧ
  double dblSumLossPay	 	  = 0;	  //������
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
  String strApproverCode      = "";
  String strOperatorCode      = "";
  String strApproverName      = "";
  String strOperatorName      = "";
  String strLossRate          = "";
  //add begin by zhuly 20051103 
  String strSeatCount         = "";   //��λ
  String strTonCount          = "";   //��λ��
  String strFrameNo           = "";   //���ܺ�
  String strEngineNo          = "";   //��������
  String[] subKindName        = new String[6]; //�������ձ�����
  String[] subKindAmount      = new String[6]; //�����ձ���
  String strKindName          = "";  //�����ձ�
  String strFlag              = "";  //���ո����ձ�־
  String strKindAmount        = "";  //�������޶�
  String strCarInsuredRelation = "" ; //�������ʴ���
  String strCarInsuredRelationName = "";//��������
  String strUseNatureCode     = "";  //ʹ������
  String strDisplay           = "none";  //�����㷽ʽ�嵥�Ĵ�ӡ��ʶ
  //add end   by zhuly 20051103
 double SumChargeAmount=0;           //���з��õĺϼ�
 //add end by fenglei 20080530
  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
  
  double dblRescueFeeRealPay  = 0;         //�������� ʩ�ȷ�
  double dblCheckFeeRealPay  = 0;          //�������� �鿱��
  double dblJudgeFeeRealPay  = 0;          //�������� ������
  double dblGsjzFeeRealPay  = 0;           //�������� ���������
  double dblAssessFeeRealPay  = 0;         //�������� ������
  double dblFlFeeRealPay  = 0;             //�������� ���ɷ�
  double dblElseFeeRealPay  = 0;           //�������� ����

  
  //�����岿��
                                              
  PrpCitemCarDto     prpItemCarDto      = null;   //ItemCarDto���� 
  PrpCitemKindDto    prpItemKindDto     = null;   //������ItemKindDto����
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto����
  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto����
  PrpLchargeDto      prpLchargeDto      = null;   //ChargeDto����
  PrpLctextDto       prpLctextDto       = null; 
  PrpLdriverDto      prpLdriverDto      = null;
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
  int intPropCount       = 0;
  String lossDesc        = "";  //��ʧ�̶�
    
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
  
  //�õ�prpLclaimDto����
  prpLclaimDto   = claimDto.getPrpLclaimDto();
  
  //�õ�prpLregistDto����
  prpLregistDto  = registDto.getPrpLregistDto();
  
  strClaimNo = prpLclaimDto.getClaimNo();   
  strOperatorCode   = prpLcompensateDto.getOperatorCode();    
  strOperatorName   = uiCodeAction.translateUserCode(strOperatorCode,isChinese); 
  DateTime dateTime = new DateTime();
  String strHandlerCode    = prpLcompensateDto.getHandlerCode();    //�����˴���
  String strHandlerName    = uiCodeAction.translateUserCode(strHandlerCode,isChinese);  
  String strUnderWriteName = prpLcompensateDto.getUnderWriteName();
  String strInputDate      = "";                                    //����ʱ��
         strInputDate      = prpLcompensateDto.getInputDate().getYear()
                             + "��" + prpLcompensateDto.getInputDate().getMonth()
                             + "��" + prpLcompensateDto.getInputDate().getDate()
                             + "��";
  String strUnderWriteEndDate  = "";    //�����������
  strUnderWriteEndDate     = prpLcompensateDto.getUnderWriteEndDate().getYear()
                             + "��" + prpLcompensateDto.getUnderWriteEndDate().getMonth()
                             + "��" + prpLcompensateDto.getUnderWriteEndDate().getDate()
                             + "��";   
 
  
  //String strDatteTime = new DateTime(dateTime.current(),dateTime.YEAR_TO_HOUR);
  
  //�õ�������
  strPolicyNo = prpLclaimDto.getPolicyNo();
  
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
  //�õ�dbPrpLctext����ļ�¼��  
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    intCtextCount     = compensateDto.getPrpLctextDtoDtoList().size();
  }
   PrpCmainDto prpCmainDto    = policyDto.getPrpCmainDto();           //�õ������������ 

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
      strPayRefCode = prpJpayRefMainDto.getPayRefCode();
      strPayRefDate = prpJpayRefMainDto.getPayRefDate().getYear()+" �� "
                   +prpJpayRefMainDto.getPayRefDate().getMonth()+" �� "
                   +prpJpayRefMainDto.getPayRefDate().getDay()+" �� ";
    
      strPayRefName = uiCodeAction.translateUserCode(strPayRefCode,isChinese);
    }  
  }

  //�õ���ʧ�̶�����
  if (claimDto.getPrpLthirdCarLossDtoList() != null) {
     for(index=0;index<claimDto.getPrpLthirdCarLossDtoList().size();index++){
      PrpLthirdCarLossDto prpLthirdCarLossDto = (PrpLthirdCarLossDto) claimDto.getPrpLthirdCarLossDtoList().get(0);
      lossDesc = prpLthirdCarLossDto.getLossDesc();
      }
  }
%>

<script language="javascript">
  function loadForm()
  {
        
    //���������PrpLcompensate
    tdCompensateNo.innerHTML  = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��������ţ�&nbsp;'+'<%=strCompensateNo%>';
    
<%
    dblSumPrePaid   = prpLcompensateDto.getSumPrePaid();  
    dblSumRest      = prpLcompensateDto.getSumRest();     
    dblSumThisPaid  = prpLcompensateDto.getSumThisPaid(); 
    strSumThisPaid  = new DecimalFormat("#,##0.00").format(dblSumThisPaid);
    if(dblSumThisPaid < 0){
    	 strCSumThisPaid = "��"+MoneyUtils.toChinese(dblSumThisPaid*-1,prpLcompensateDto.getCurrency());
    }
    else{
    	strCSumThisPaid = MoneyUtils.toChinese(dblSumThisPaid,prpLcompensateDto.getCurrency());
    }
    
    dblSumPaid      = prpLcompensateDto.getSumPaid();             
    strSumPaid      = new DecimalFormat("#,##0.00").format(dblSumPaid);    
    if(dblSumPaid < 0){
    	strCSumPaid = "��"+  MoneyUtils.toChinese(dblSumPaid*-1,prpLcompensateDto.getCurrency()); 
    }
    else{
    	strCSumPaid = MoneyUtils.toChinese(dblSumPaid,prpLcompensateDto.getCurrency());   
    }
    
    
    dblPropSumLossPay  = prpLcompensateDto.getLossSumRealPay();	  //�Ʋ���ʧ
    dblPersonSumLossPay = prpLcompensateDto.getPersonLossSumRealPay();	  //������ʧ
    dblSumLossPay		= dblPropSumLossPay + dblPersonSumLossPay;	  //������
    String strSumLossPay      = new DecimalFormat("#,##0.00").format(dblSumLossPay);        
    String strCSumLossPay = "";
    if(dblSumLossPay < 0){
    	strCSumLossPay = "��" + MoneyUtils.toChinese(dblSumLossPay*-1,prpLcompensateDto.getCurrency());  
    }
    else{
    	strCSumLossPay     = MoneyUtils.toChinese(dblSumLossPay,prpLcompensateDto.getCurrency());   
    }
    
    
%>
    //tdSumPrePaid.innerHTML    = '&nbsp;��Ԥ����'                    + '<%=DataUtils.zeroToEmpty(dblSumPrePaid)%>';
    //tdSumRest.innerHTML       = '&nbsp;��������/��ֵ��'           + '<%=DataUtils.zeroToEmpty(dblSumRest)%>';
    //tdCSumThisPaid.innerHTML  = '&nbsp;����ʵ��������Ҵ�д����'  + '<%=strCSumThisPaid%>';
    //tdSumThisPaid.innerHTML   = '������'                        + '<%=strSumThisPaid%>';
    
    //tdCSumPaid.innerHTML      = '&nbsp;��������д����'      + '<%=strCSumPaid%>'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Сд)��:'+ '<%=strSumPaid%>Ԫ';
    
   

    //������Ϣ��PrpLclaim
    tdPolicyNo.innerHTML     = "<%=strPolicyNo%>";
    tdRiskName.innerHTML     = '<%=strRiskName%>';
    //tdEndorseNo.innerHTML = '<%//=strEndorseNo%>';

    tdPropSumLossPay.innerHTML = '<%=dblPropSumLossPay%>';
    tdPersonSumLossPay.innerHTML = '<%=dblPersonSumLossPay%>';

    
    tdCSumLossPay.innerHTML      = '&nbsp;��������д����'      + '<%=strCSumLossPay%>'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Сд)��:'+ '<%=strSumLossPay%>Ԫ';
    tdSSumLossPay.innerHTML      = '&nbsp;'+'<%=strSumLossPay%>';
    

    tdHandlerName.innerHTML      = '<%="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + strHandlerName%>'
    <%if("1".equals(prpLcompensateDto.getUnderWriteFlag())){%>
    tdUnderWriteName.innerHTML = '<%="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + strUnderWriteName%>';                             
	<%}%>
<%    
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                        + " �� " +prpLclaimDto.getDamageStartDate().getMonth()
                        + " �� " + prpLclaimDto.getDamageStartDate().getDate()
                        + " ��";
    strReportHour      =  prpLregistDto.getReportHour().toString();
    strDamageName      =  prpLregistDto.getDamageName();
	String damangeAddressType = uiCodeAction.translateCodeCode("DamageAddress",prpLregistDto.getDamageAddressType(),true);
%>                    
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>'+'&nbsp;'+'<%=strReportHour.substring(0,2)%>'+'&nbsp;ʱ';
    tdDamageName.innerHTML      = '<%=StringConvert.encode(prpLclaimDto.getDamageName())%>';
    //tdSumClaim.innerHTML        = '<%= lossDesc %>';    
    //tdDamageAddress.innerHTML   = '<%=StringConvert.encode(prpLclaimDto.getDamageAddress())%>';
    //tdDamageAddressType.innerHTML   = '<%=damangeAddressType%>';
   // tdDamageName.innerHTML = '<%=strDamageName%>';
    tdInsuredName.innerHTML  = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
<%    
    //�¹�����
    strCode = ""; 
    strName = "";
    strCode = StringConvert.encode(prpLclaimDto.getIndemnityDuty());
    strName = uiCodeAction.translateCodeCode("IndemnityDuty",strCode,isChinese);
%>
    //tdIndemnityDuty.innerHTML     = '<%=strName%>';
    //tdIndemnityDutyRate.innerHTML = '<%=new DecimalFormat("#,##0.00").format(prpLclaimDto.getIndemnityDutyRate())%>'+'��';
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
    
    //���⳵����ϢPrpLthirdParty 
<%
//����⳥�޶�
  double dblSumAmount3 = 0;
  PrpCitemKindDto prpCitemKindDto = null;
  if(policyDto.getPrpCitemKindDtoList()!=null){
    for(index=0;index<policyDto.getPrpCitemKindDtoList().size();index++)
    {
      prpCitemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
      strCalculateFlag = prpCitemKindDto.getCalculateFlag();    
      if( strCalculateFlag.equals("N") ) 
      {
        dblSumAmount3 += prpCitemKindDto.getAmount();
      }
    }    
  }  

	//modify by lixiaohua 20040326 begin reason �������鳧���ͺŴ�ӡ����
  if(policyDto.getPrpCitemCarDtoList()!=null){
    for(index=0;index<intItemCarCount;index++)
    { 
        prpItemCarDto       = (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(index);
        strLicenseNo        = StringConvert.encode(prpItemCarDto.getLicenseNo());
        strLicenseColorCode = StringConvert.encode(prpItemCarDto.getLicenseColorCode());
        strSeatCount        = ""+prpItemCarDto.getSeatCount();
        strTonCount         = ""+prpItemCarDto.getTonCount();
        strEngineNo         = StringConvert.encode(prpItemCarDto.getEngineNo());
        strFrameNo          = StringConvert.encode(prpItemCarDto.getFrameNo());
        strCarInsuredRelation = StringConvert.encode(prpItemCarDto.getCarInsuredRelation());
        strCarInsuredRelationName = uiCodeAction.translateCodeCode("CarInsuredRelation",strCarInsuredRelation,true);
        strUseNatureCode    = StringConvert.encode(prpItemCarDto.getUseNatureCode());
        if(strUseNatureCode.equals("1")||strUseNatureCode.equals("2")||strUseNatureCode.equals("3"))
        {
            strUseNatureCode = "��Ӫҵ";//��Ӫҵ
        }
        else
        {
            strUseNatureCode = "Ӫҵ";//Ӫҵ
        }
%>
        tdUseNatureCode.innerHTML = '<%=strUseNatureCode%>';
        tdLicenseNo.innerHTML    = '<%=StringConvert.encode(prpItemCarDto.getLicenseNo())%>';       
        tdBrandName.innerHTML    = '<%=StringConvert.encode(prpItemCarDto.getBrandName())%>';
        tdCarInsuredRelationName.innerHTML = '<%=strCarInsuredRelationName%>';
        tdSeatTonCount.innerHTML = '<%=strSeatCount+"��/"+strTonCount+"��"%>';  
        tdEngineNo.innerHTML     = '<%=StringConvert.encode(prpItemCarDto.getEngineNo())%>';
        tdFrameNo.innerHTML      = '<%=StringConvert.encode(prpItemCarDto.getFrameNo())%>'; 
     
<%
        //�������
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(prpItemCarDto.getClauseType());
        strName = uiCodeAction.translateCodeCode("ClauseType",strCode,isChinese);
%>        
<%
    }    
  }      

  if(policyDto.getPrpCitemCarDtoList()!=null){
    //�������ձ����Ϣ��PrpCitemCar   
    for(index=0;index<intItemCarCount;index++)
    {
      prpItemCarDto = (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(index);
      strLicenseNo1 = StringConvert.encode(prpItemCarDto.getLicenseNo()); 
           
      if( strLicenseNo1.equals(strLicenseNo) )
      {    
%>        
        //tdPurchasePrice.innerHTML = '<%=new DecimalFormat("#,##0.00").format(prpItemCarDto.getPurchasePrice())%>';
<%
      }
    }
  }  
    
    //���������ϢPrpTitemKind
    dblSumAmount1 = 0;
    dblSumAmount2 = 0;
    
  if(policyDto.getPrpCitemKindDtoList()!=null){
     int tempindex = 0 ;  //������ʱ����
    for(index=0;index<intItemKindCount;index++)
    {
      
      prpItemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
      //add begin by zhuly 20051103 reason:��������Ϣ
      strRiskCode = prpItemKindDto.getRiskCode();
      strKindCode = prpItemKindDto.getKindCode();
      strKindName = prpItemKindDto.getKindName();  
      strKindAmount = ""+prpItemKindDto.getAmount();
      strFlag     = prpItemKindDto.getFlag();
      //add end by zhuly 20051103
      //strRiskCode = prpItemKindDto.getRiskCode();
      //strKindCode = prpItemKindDto.getKindCode();
      //dbPrpDkind.getInfo(strRiskCode,strKindCode);
      //strCalculateFlag = dbPrpDkind.getCalculateFlag().substring(0,2);
      strCalculateFlag = prpItemKindDto.getCalculateFlag();    
      //strCalculateFlag="Y1";
      if( strFlag.substring(1,2).equals("1") && strKindCode.equals("A"))//���ճ����� 
      {
        dblSumAmount1 += prpItemKindDto.getAmount();
      }
      if( strFlag.substring(1,2).equals("1") && strKindCode.equals("B"))//�������߱���
      {
        dblSumAmount2 += prpItemKindDto.getAmount();
      }
      if( strFlag.substring(1,2).equals("2")&&tempindex<6)//������
      {
        subKindName[tempindex] = strKindName;
        subKindAmount[tempindex] = ""+new DecimalFormat("#,##0.00").format(prpItemKindDto.getAmount());  
   %>
      //<%="tdKindName"+tempindex%>.innerHTML = '<%=subKindName[tempindex]%>'; 
      //<%="tdKindAmount"+tempindex%>.innerHTML = '<%=subKindAmount[tempindex]%>';              
   <%
        tempindex ++;
      }      
    }    
  }  

%>
    //tdSumAmount1.innerHTML = '<%=new DecimalFormat("#,##0.00").format(policyDto.getPrpCmainDto().getSumAmount())%>';
    tdSumAmount2.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount3)%>'; 
    //tdDeductibleRate.innerHTML = '<%=prpItemKindDto.getDeductibleRate()%>'+'��';   
<%    
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    //���������ֱ�PrpLctext
    for(index=0;index<intCtextCount;index++)
    {
      prpLctextDto = (PrpLctextDto)compensateDto.getPrpLctextDtoDtoList().get(index);
      strTextType = StringConvert.encode(prpLctextDto.getTextType());
      if ( strTextType.charAt(0)=='1' || strTextType.charAt(0)=='7')
      {      
        strContext = strContext + StringConvert.encode(prpLctextDto.getContext()) ;
        strContexTtemp = strContexTtemp + StringConvert.toHTMLFormat(prpLctextDto.getContext()) ;
      }
    }    
  }

    
    //�����������ִ�����Ǽ���
    intCtextCountTmp = 0;    //textarea������
//    String la="\\";
//    String lala="\\r\\n";

    
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
    
    int x = 0;
    int y = 0;
    if(!(strContext.length()<4))    //���strContext.length()>=4���ж�strContext��β�����֣����ǻس�����
    {
      x = strContext.length()-4;
      y = strContext.length();
      if(!strContext.substring(x,y).equals("\\r\\n"))
      {
         intCtextCountTmp += 1;   
      }
    }
    else    //���strContext����1�У�intCtextCountTmp = 1; 
      intCtextCountTmp = 1; 
    strContext1 = strContext;
    if( intCtextCountTmp>6 )
    {
    	strContext = "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���������Ϣ���࣬������嵥��";
    	strDisplay = "";
    }
    while(strContext.indexOf("\\r\\n")!=-1){
       strContext=strContext.substring(0,strContext.indexOf("\\r\\n"))+"<br>&nbsp;"+strContext.substring(strContext.indexOf("\\r\\n")+"\\r\\n".length());
    }
    while(strContext1.indexOf("\\r\\n")!=-1){
        strContext1=strContext1.substring(0,strContext1.indexOf("\\r\\n"))+"<br>&nbsp;"+strContext1.substring(strContext1.indexOf("\\r\\n")+"\\r\\n".length());
     }
%>  
   tdContext.innerHTML = '<%=strContext%>';
<%    
    //��������Ϣ��PrpLcharge  
    dblJudgeFee = 0;  //������
    dblCheckFee = 0;  //�鿱��
    dblLawFee   = 0;  //���Ϸ�
    dblElseFee  = 0;  //����
    dblCheckFee1 = 0; //�����
    dblAssessFee = 0; //������
    dblRescueFee = 0; //ʩ�ȷ�
    dblGsjzFee = 0 ;  //���������
    dblFlFee = 0 ;	  //���ɷ�
    double dblfee28 = 0;//����������
  if(compensateDto.getPrpLchargeDtoList()!=null){
    for(index=0;index<intChargeCount;index++)
    {
      prpLchargeDto = (PrpLchargeDto)compensateDto.getPrpLchargeDtoList().get(index);
      strChargeCode = StringConvert.encode(prpLchargeDto.getChargeCode()); 
       SumChargeAmount += prpLchargeDto.getChargeAmount();
      if( strChargeCode.equals("07") )       //������dblJudgeFee
      {    
        dblJudgeFee += prpLchargeDto.getChargeAmount();
        dblJudgeFeeRealPay += prpLchargeDto.getSumRealPay();
      }   
      else if( strChargeCode.equals("06") )  //���鿱��
      {    
        dblCheckFee1 += prpLchargeDto.getChargeAmount();
      }   
      else if( strChargeCode.equals("05") )  //���Ϸ�
      {    
        dblLawFee   += prpLchargeDto.getChargeAmount();
      }
      else if( strChargeCode.equals("04") )  //�鿱��dblCheckFee
      {    
        dblCheckFee += prpLchargeDto.getChargeAmount();
        dblCheckFeeRealPay += prpLchargeDto.getSumRealPay();
      }
      else if( strChargeCode.equals("13") )  //������dblAssessFee
      {    
        dblAssessFee += prpLchargeDto.getChargeAmount();
        dblAssessFeeRealPay += prpLchargeDto.getSumRealPay();
      }   
      else if( strChargeCode.equals("03"))   //ʩ�ȷ�dblRescueFee
      {
        dblRescueFee += prpLchargeDto.getChargeAmount();    
        dblRescueFeeRealPay += prpLchargeDto.getSumRealPay();
      }
      else if( strChargeCode.equals("09"))   //�����
      { 
        dblAgentFee  += prpLchargeDto.getChargeAmount();
      }
      else if( strChargeCode.equals("11"))   //���������dblGsjzFee
      { 
        dblGsjzFee  += prpLchargeDto.getChargeAmount();
        dblGsjzFeeRealPay += prpLchargeDto.getSumRealPay();
      }
      else if( strChargeCode.equals("15"))   //���ɷ�dblFlFee
      { 
        dblFlFee  += prpLchargeDto.getChargeAmount();
        dblFlFeeRealPay += prpLchargeDto.getSumRealPay();
      }
      else if(strChargeCode.equals("28"))
      {
        dblfee28  += prpLchargeDto.getChargeAmount();
      }
//      else if( strChargeCode.equals("99"))   //����dblElseFee
//      { 
//        dblElseFee  += prpLchargeDto.getChargeAmount();
//      }
//      else                                   //��������
//     {    
//        dblElseFee  += prpLchargeDto.getChargeAmount();
//      }   
    } 
    dblElseFee = SumChargeAmount - (dblRescueFee+dblCheckFee+dblJudgeFee+dblAssessFee+dblFlFee);
  }
  strSumPaid      = new DecimalFormat("#,##0.00").format(dblSumPaid-dblfee28);        
%>    
	//���������
    tdJudgeFee.innerHTML = '&nbsp;' + '<%=dblJudgeFee>0?(new DecimalFormat("#,##0.00").format(dblJudgeFee)):(DataUtils.zeroToEmpty(dblJudgeFee))%>';
    
    //�鿱��    
    tdCheckFee.innerHTML = '&nbsp;' + '<%=dblCheckFee>0?new DecimalFormat("#,##0.00").format(dblCheckFee):DataUtils.zeroToEmpty(dblCheckFee)%>';
    
    //�����
    //tdCheckFee1.innerHTML = '&nbsp;' + '<%=dblCheckFee1>0?(new DecimalFormat("#,##0.00").format(dblCheckFee1)):(DataUtils.zeroToEmpty(dblCheckFee1))%>';
    
    //���Ϸ�
    //tdLawFee.innerHTML = '&nbsp;' + '<%=dblLawFee>0?new DecimalFormat("#,##0.00").format(dblLawFee):DataUtils.zeroToEmpty(dblLawFee)%>';
    
    //���ɷ�
    tdFlFee.innerHTML = '&nbsp;' + '<%=dblFlFee>0?new DecimalFormat("#,##0.00").format(dblFlFee):DataUtils.zeroToEmpty(dblFlFee)%>';
    
    //���������
    tdGsjzFee.innerHTML = '&nbsp;' + '<%=dblGsjzFee>0?new DecimalFormat("#,##0.00").format(dblGsjzFee):DataUtils.zeroToEmpty(dblGsjzFee)%>';

    
	//����    
    tdElseFee.innerHTML = '&nbsp;' + '<%=dblElseFee>0?(new DecimalFormat("#,##0.00").format(dblElseFee)):(DataUtils.zeroToEmpty(dblElseFee))%>';

    //������
    tdAssessFee.innerHTML = '&nbsp;' + '<%=dblAssessFee>0?new DecimalFormat("#,##0.00").format(dblAssessFee):DataUtils.zeroToEmpty(dblAssessFee)%>';
    
	//ʩ�ȷ�
    tdRescueFee.innerHTML = '&nbsp;' + '<%=dblRescueFee>0?new DecimalFormat("#,##0.00").format(dblRescueFee):DataUtils.zeroToEmpty(dblRescueFee)%>';

	//�����
    //tdAgentFee.innerHTML = '&nbsp;'   + '<%=DataUtils.zeroToEmpty(dblAgentFee)%>';
    //��Ч���ս��
    tdSumAmount.innerHTML = '<%= new DecimalFormat("#,##0.00").format(policyDto.getPrpCmainDto().getSumAmount())%>';
    
    //���ս��
    tdOldSumAmount.innerHTML = '<%=new DecimalFormat("#,##0.00").format(policyDto.getPrpCmainOriginDto().getSumAmount())%>';
    
    
    //���յص�
    tdDamageAddress.innerHTML = '<%=prpLclaimDto.getDamageAddress() %>';
    
    //���ձ��
    <%
    String itemName = "";
    if( compensateDto.getPrpLlossDtoList() != null && compensateDto.getPrpLlossDtoList().size() > 0){
    	PrpLlossDto prpLlossDto = (PrpLlossDto)compensateDto.getPrpLlossDtoList().get(0);
    	itemName = prpLlossDto.getLossName();
    }
    %>
    tdLossName.innerHTML = '<%= itemName%>';
    
    //ʵ����
    tdtSumThisPaid.innerHTML = '<%= compensateDto.getPrpLcompensateDto().getSumThisPaid()%>';
    
    //
    tdPayDate.innerHTML = '<%=strUnderWriteEndDate%>';
    
    tdClaimNo.innerHTML = '&nbsp;'   + '<%=strClaimNo%>';
    tdSSumPaid.innerHTML      = '&nbsp;'+'<%=strSumPaid%>';

<%  
    strSumThisPaid  = new DecimalFormat("#,##0.00").format(dblSumThisPaid);
	if(dblSumThisPaid < 0){
		strCSumThisPaid = "��" + MoneyUtils.toChinese(dblSumThisPaid*-1,prpLcompensateDto.getCurrency());
	}
	else{
		 strCSumThisPaid = MoneyUtils.toChinese(dblSumThisPaid,prpLcompensateDto.getCurrency());
	}
   
%>    
    //tdCSumThisPaid.innerHTML  = '&nbsp;����ʵ��������Ҵ�д����'  + '<%=strCSumThisPaid%>';    
    //tdSumThisPaid.innerHTML   = '������'                        + '<%=strSumThisPaid%>';
<%    
    //*****������Ϣ��PrpLdriver*****  
    if(registDto.getPrpLdriverDtoList() != null){    
    intDriverCount = registDto.getPrpLdriverDtoList().size();
    for(index=0;index<intDriverCount;index++)
    {
      prpLdriverDto     = (PrpLdriverDto)registDto.getPrpLdriverDtoList().get(index) ;

%>        
        //tdDriverName.innerHTML         = '<%=StringConvert.encode(prpLdriverDto.getDriverName())%>';
        //tdDriverName1.innerHTML         = '<%=StringConvert.encode(prpLdriverDto.getDriverName())%>';
        
<%  
   }  
   }
%> 
<%
  String claimType = prpLregistDto.getClaimType();
  String strClaimType = uiCodeAction.translateCodeCode("CaseCode",claimType,true);
  String handleUnit = prpLregistDto.getHandleUnit();
  String strHandleUnit = uiCodeAction.translateCodeCode("HandleUnit",handleUnit,true);
%>
    //tdClaimType.innerHTML = '<%=strClaimType%>';
    //tdHandleUnit.innerHTML = '<%=strHandleUnit%>';
    //tdRunAreaName.innerHTML = '<%=prpLregistDto.getDamageAreaName()%>';

    //tdLossRate.innerHTML    = '<%=new DecimalFormat("#,##0.00").format(prpLclaimDto.getIndemnityDutyRate())%>'+'��';
    //tdRemark.innerHTML = '��ע��';
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
   //tdEndorseNo.innerHTML  = '<%=prpCplanDto.getEndorseNo()%>';
   //tdRemark.innerHTML = '��ע��'+'<br>'+'���ѽɷ������'+'<%=strPlanFee%>' + '<br>'+'�����������ڣ�'+'<%=prpCplanDto.getPlanDate()%>'+'<br>'+'�տ��ˣ�'+'';
   //tdSerialNo.innerHTML  = '��Ԥ��������'+'<%=DataUtils.zeroToEmpty(prpCplanDto.getSerialNo()-1)%>';
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
   //tdPersonInjure.innerHTML = '<%=personInjure%>';
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
   tdEndorseNo.innerHTML = '<%=strEndorseNo%>';
<%
    }
  }
%>
   
}  
</script>
  