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
<%@ page import="com.sinosoft.claim.dto.domain.PrpPheadDto" %> 
<%@page import="com.sinosoft.sff.schema.PrpJpayRefRecSchema"%>
<%@page import="com.sinosoft.sff.blsvr.BLPrpJpayRefRec"%>
<%@page import="com.sinosoft.payment.bl.facade.BLPrpJpayRefMainFacade"%>
<%@page import="com.sinosoft.payment.dto.domain.PrpJpayRefMainDto"%>
<%
  //������������
  String strCompensateNo      = ""; //���������
  System.out.println("strCompensateNo = "+strCompensateNo);
  String strClaimNo           = "";   //������
  String strPolicyNo          = "";   //������
  double dblSumAmount1        = 0;    //���ս��      
  String strKindCode          = "";   //�ձ����
  String strCause             = "";   //����ԭ��
  String strAddress           = "";   //���յص�
  String strDamageAddress     = "";   //���յص�
  String strDamageStartDate   = "";   //����ʱ��
  String strReportHour        = "";   //����Сʱ
  String strTextType          = "";
  String strContext           = "";   //������������
  String strContext1 = "";
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
  double dblGsjzFee			      = 0;	  //���������
  double dblFlFee			        = 0;	  //���ɷ�  
  double dblPropSumLossPay	  = 0;	  //�Ʋ���ʧ
  double dblPersonSumLossPay  = 0;	  //������ʧ
  double dblSumLossPay		    = 0;	  //������
  
  //�������ĸ������
  double dblJudgeFeeRealPay          = 0;    //������
  double dblCheckFeeRealPay          = 0;    //�鿱��
  double dblLawFeeRealPay            = 0;    //���Ϸ�
  double dblElseFeeRealPay           = 0;    //��������
  double dblSumPrePaidRealPay        = 0;    //
  double dblSumRestRealPay           = 0;    //
  double dblCheckFee1RealPay         = 0;    //���鿱��
  double dblAssessFeeRealPay         = 0;    //������
  double dblRescueFeeRealPay         = 0;    //ʩ�ȷ�
  double dblAgentFeeRealPay          = 0;    //�����
  double dblGsjzFeeRealPay           = 0;    //���������
  double dblFlFeeRealPay             = 0;    //���ɷ�  
  double dblSumLossPay1              = 0; //������+�������ķ��÷���
  
  
  double dblSumLoss          = 0;    //�˶���ʧ�����ձ����ʧ
  String strCurrency2        = "";   //�˶���ʧ�����ձ����ʧ�ұ�
  String strSumPaid          = "";   //���ϼƸ�ʽ��
  String strCSumPaid         = "";   //���ϼƴ�д
  String strSumLossPay		   = "";	 //������
  String strCSumLossPay	     = "";	 //����������
  double dblSumPaid          = 0;    //���ϼ�
	String stritemKind         = "";
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
  
  UIEndorseAction uiEndorseAction = new UIEndorseAction();
  UICodeAction uiCodeAction = new UICodeAction();
  //�õ�prpLcompensateDto ����
  prpLcompensateDto   = compensateDto.getPrpLcompensateDto();
  strCompensateNo = prpLcompensateDto.getCompensateNo();
  //�õ�prpLclaimDto����
  prpLclaimDto   = claimDto.getPrpLclaimDto();
	
	List itemKindList = new ArrayList();
	itemKindList = (ArrayList)policyDto.getPrpCitemKindDtoList();
	
	stritemKind = ((PrpCitemKindDto)itemKindList.get(0)).getItemDetailName();

  strClaimNo = prpLclaimDto.getClaimNo(); 
  String strApproverCode   = prpLcompensateDto.getApproverCode();   //����Ա����
  String strOperatorCode   = prpLcompensateDto.getOperatorCode();   //����Ա����
  String strApproverName   = uiCodeAction.translateUserCode(strApproverCode,isChinese);  
  String strOperatorName   = uiCodeAction.translateUserCode(strOperatorCode,isChinese);  
  String strHandlerCode    = prpLcompensateDto.getHandlerCode();    //�����˴���
  String strHandlerName    = uiCodeAction.translateUserCode(strHandlerCode,isChinese);  
  String strUnderWriteName = prpLcompensateDto.getUnderWriteName();
  String strInputDate      = "";  //����ʱ��
  String strUnderWriteEndDate = ""; //����ͨ������
         strInputDate      = prpLcompensateDto.getInputDate().getYear()
                             + "��" + prpLcompensateDto.getInputDate().getMonth()
                             + "��" + prpLcompensateDto.getInputDate().getDate()
                             + "��";
     strUnderWriteEndDate  = prpLcompensateDto.getUnderWriteEndDate().getYear()
                             + "��" + prpLcompensateDto.getUnderWriteEndDate().getMonth()
                             + "��" + prpLcompensateDto.getUnderWriteEndDate().getDate()
                             + "��"; 
  
  //�õ�������
  strPolicyNo = prpLclaimDto.getPolicyNo();
  PrpCmainDto prpCmainDto    = policyDto.getPrpCmainDto();           //�õ������������ 
  strInsuredName    = prpCmainDto.getInsuredName();     //��������
  strInsuredAddress = prpCmainDto.getInsuredAddress();  //���ղƲ���ַ
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
      strPayRefCode = prpJpayRefMainDto.getPayRefCode();
      strPayRefDate = "�������ڣ�"
                   +prpJpayRefMainDto.getPayRefDate().getYear()+" �� "
                   +prpJpayRefMainDto.getPayRefDate().getMonth()+" �� "
                   +prpJpayRefMainDto.getPayRefDate().getDay()+" �� ";
    
      strPayRefName =  "�����ˣ�"+uiCodeAction.translateUserCode(strPayRefCode,isChinese);
    }
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
  strReportHour       =  prpLregistDto.getReportHour().toString();

  //�õ�blPrpCitemCar���� 
/*
  if(policyDto.getPrpCitem_carDtoList()!=null){
    intItemCarCount     = policyDto.getPrpCitem_carDtoList().size();
  }  
*/  
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
	 String strCEndMoney = "";
	 if(prpLcompensateDto.getSumPrePaid() >= 0){
		 strCEndMoney = MoneyUtils.toChinese(prpLcompensateDto.getSumPrePaid(),prpLcompensateDto.getCurrency()); 
	 }
	 else{
		 strCEndMoney = "��" + MoneyUtils.toChinese(prpLcompensateDto.getSumPrePaid()*-1,prpLcompensateDto.getCurrency()); 
	 }
	 
	 dblSumPaid = prpLcompensateDto.getSumDutyPaid();
	 if(dblSumPaid >= 0){
		 strCSumPaid     = MoneyUtils.toChinese(dblSumPaid,prpLcompensateDto.getCurrency());  
	 }
	 else{
		 strCSumPaid     = "��" + MoneyUtils.toChinese(dblSumPaid*-1,prpLcompensateDto.getCurrency());  
	 }
	  

	dblPropSumLossPay = compensateDto.getPrpLcompensateDto().getLossSumRealPay();	  //�Ʋ���ʧ
	dblPersonSumLossPay = compensateDto.getPrpLcompensateDto().getPersonLossSumRealPay();	  //������ʧ
	
	
	   
	    

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
        dblJudgeFeeRealPay += prpLchargeDto.getSumRealPay();
        MJudgeFee =  prpLchargeDto.getCurrency();
      }   
      else if( strChargeCode.equals("06") )  //���鿱��
      {    
        dblCheckFee1 += prpLchargeDto.getChargeAmount();
        dblCheckFee1RealPay += prpLchargeDto.getSumRealPay();
        
      }   
      else if( strChargeCode.equals("05") )  //���Ϸ�
      {    
        dblLawFee   += prpLchargeDto.getChargeAmount();
        dblLawFeeRealPay += prpLchargeDto.getSumRealPay();
        
      }
      else if( strChargeCode.equals("04") )  //�鿱��
      {    
        dblCheckFee += prpLchargeDto.getChargeAmount();
        dblCheckFeeRealPay += prpLchargeDto.getSumRealPay();
        
        MCheckFee =  prpLchargeDto.getCurrency();
      }
      else if( strChargeCode.equals("13") )  //������
      {    
        dblAssessFee += prpLchargeDto.getChargeAmount();
        dblAssessFeeRealPay += prpLchargeDto.getSumRealPay();
        MAssessFee  =  prpLchargeDto.getCurrency();
      }   
      else if( strChargeCode.equals("03"))   //ʩ�ȷ�
      {
        dblRescueFee += prpLchargeDto.getChargeAmount();
        dblRescueFeeRealPay += prpLchargeDto.getSumRealPay();        
        MRescueFee =  prpLchargeDto.getCurrency();
      }
      else if( strChargeCode.equals("09"))   //�����
      { 
        dblAgentFee  += prpLchargeDto.getChargeAmount();
        dblAgentFeeRealPay += prpLchargeDto.getSumRealPay(); 
        MAgentFee =  prpLchargeDto.getCurrency();
      }
      else if( strChargeCode.equals("11"))   //���������
      { 
        dblGsjzFee  += prpLchargeDto.getChargeAmount();
        dblGsjzFeeRealPay += prpLchargeDto.getSumRealPay();
        MGsjzFee = prpLchargeDto.getCurrency();
      }
      else if( strChargeCode.equals("15"))   //���ɷ�
      { 
        dblFlFee  += prpLchargeDto.getChargeAmount();
        dblFlFeeRealPay += prpLchargeDto.getSumRealPay();
        MFlFee = prpLchargeDto.getCurrency();
      }
      else if( strChargeCode.equals("99"))   //����
      { 
        dblElseFee  += prpLchargeDto.getChargeAmount();
        dblElseFeeRealPay += prpLchargeDto.getSumRealPay();
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
 
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    // *****���������ֱ�PrpLctext*****
    for(index=0;index<intCtextCount;index++)
    {
      prpLctextDto = (PrpLctextDto)compensateDto.getPrpLctextDtoDtoList().get(index);
      strTextType = StringConvert.encode(prpLctextDto.getTextType());
      if(RiskCode.substring(0,2).equals("11") ||RiskCode.substring(0,2).equals("15") 
      		|| RiskCode.substring(0,2).equals("01") || RiskCode.substring(0,2).equals("03")){
      	if ( strTextType.charAt(0)=='7' )
      	{      
        	strContext = strContext + StringConvert.encode(prpLctextDto.getContext()) ;
      	}
      }else{
      		if ( strTextType.charAt(0)=='1' || strTextType.charAt(0)=='7')
		      {
		        strContext = strContext + StringConvert.encode(prpLctextDto.getContext()) ;
		      }
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
    }
    while(strContext.indexOf("\\r\\n")!=-1){
       strContext=strContext.substring(0,strContext.indexOf("\\r\\n"))+"<br>"+strContext.substring(strContext.indexOf("\\r\\n")+"\\r\\n".length());
      
    }
    while(strContext1.indexOf("\\r\\n")!=-1){
       strContext1=strContext1.substring(0,strContext1.indexOf("\\r\\n"))+"<br>"+strContext1.substring(strContext1.indexOf("\\r\\n")+"\\r\\n".length());
    }
       dblSumLossPay =  dblPropSumLossPay + dblPersonSumLossPay; //������
       strSumPaid  = new DecimalFormat("#,##0.00").format(dblSumLossPay+dblRescueFee+dblCheckFee+dblJudgeFee+dblGsjzFee+dblAssessFee+dblFlFee+dblElseFee);
       dblSumLossPay1 = dblSumLossPay+dblRescueFeeRealPay+dblCheckFeeRealPay+dblJudgeFeeRealPay+dblGsjzFeeRealPay+dblAssessFeeRealPay+dblFlFeeRealPay+dblElseFeeRealPay;   //������
       strSumLossPay = new DecimalFormat("#,##0.00").format(dblSumLossPay1);
	   if(dblSumLossPay1 >= 0){
		   strCSumLossPay = MoneyUtils.toChinese(dblSumLossPay1,prpLcompensateDto.getCurrency());
	   }
	   else{
		   strCSumLossPay = "��" + MoneyUtils.toChinese(dblSumLossPay1*-1,prpLcompensateDto.getCurrency());
	   }
%>

<script language="javascript">
  function loadForm()
  {
    
    // *****���������PrpLcompensate*****
    //tdCompensateNo.innerHTML = '<%=strCompensateNo%>';

    // *****������Ϣ��PrpLclaim*****
    tdPolicyNo.innerHTML     = '<%=strPolicyNo%>';
    //tdInsuredName.innerHTML  = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
    //tdSumAmount.innerHTML = '<%= new DecimalFormat("#,##0.00").format(prpLclaimDto.getSumAmount())%>';
<%    
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                        + " �� " +prpLclaimDto.getDamageStartDate().getMonth()
                        + " �� " + prpLclaimDto.getDamageStartDate().getDate()
                        + " ��";
%>                    
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>';
<%    
		String a = "prpLclaimDto.getStartDate()==="+prpLclaimDto.getStartDate().getYear();
		System.out.println(a);
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
    tdDamageAddress.innerHTML = '<%= prpLclaimDto.getDamageAddress()%>';
    tdInsuredName.innerHTML = '<%=strInsuredName%>';
    tdSumAmount1.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount1)%>';
    tdEndorseNo.innerHTML = '<%=strEndorseNo%>';
    tdDamageAddress.innerHTML = '<%=strDamageAddress%>';
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>'+'&nbsp;'+'<%=strReportHour.substring(0,2)%>'+'ʱ';
   tdContext.innerHTML = '<%="�����㣺<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+strContext%>';
    tdHandlerName.innerHTML = '<%="&nbsp;���ƣ�<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+strHandlerName
                                 +"<br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+strInputDate%>';
    <%if("1".equals(prpLcompensateDto.getUnderWriteFlag())){%>
    tdUnderWriteName.innerHTML = '<%="&nbsp;������:<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+strUnderWriteName
                                 +"<br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+strUnderWriteEndDate%>';
   <%}%>
    //tdSumLoss.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumLoss)%>';
    tdSumLoss.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumLossPay)%>';
    
    tdCurrency2.innerHTML ='&nbsp;'+ '<%=strCurrency2%>';
    tdCurrency22.innerHTML = '<%=strCurrency2%>';
    tdClaimNo.innerHTML = '<%=strClaimNo%>';
    //ʩ�ȷ�
    //dblRescueFee>0?(new DecimalFormat("#,##0.00").format(dblRescueFee)):(DataUtils.zeroToEmpty(dblRescueFee))
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
    
    tdMRescueFee.innerHTML = '&nbsp;'+ '<%=uiCodeAction.translateCurrencyCode(MRescueFee,true)%>';
    tdMCheckFee.innerHTML = '&nbsp;'+ '<%=uiCodeAction.translateCurrencyCode(MCheckFee,true)%>';
    tdMJudgeFee.innerHTML = '&nbsp;'+ '<%=uiCodeAction.translateCurrencyCode(MJudgeFee,true)%>';
    tdMGsjzFee.innerHTML = '&nbsp;'+ '<%=uiCodeAction.translateCurrencyCode(MGsjzFee,true)%>';
    tdMAssessFee.innerHTML = '&nbsp;'+ '<%=uiCodeAction.translateCurrencyCode(MAssessFee,true)%>';
    tdMFlFee.innerHTML = '&nbsp;'+ '<%=uiCodeAction.translateCurrencyCode(MFlFee,true)%>';
    tdMElseFee.innerHTML = '&nbsp;'+ '<%=uiCodeAction.translateCurrencyCode(MElseFee,true)%>';

    //tdAgentFee.innerHTML = '&nbsp;'+'<%=new DecimalFormat("#,##0.00").format(dblAgentFee)%>';
    //tdMAgentFee.innerHTML = '&nbsp;'+ '<%=uiCodeAction.translateCurrencyCode(MAgentFee,true)%>';
   
    tdSumPaid.innerHTML = '&nbsp;'+ '<%=strSumPaid%>';
   
 } 
</script>
  