<%--
****************************************************************************
* DESC       �����ڻ������䱣������������ӡ��ʼ��
* AUTHOR     ��zhulianyu
* CREATEDATE ��2005-11-15
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
  String strTextType          = "";   //�����������
  String strContext           = "";   //������������
  String strDamageStartDate   = "";   //����ʱ��
  String strInsuredDate       = "";   //�����ڼ�
  double dblSumPrePaid        = 0;    //
  double dblSumRest           = 0;    //
  double dblCheckFee1         = 0; 	  //�����
  double dblAgentFee          = 0;    //�����
  double dblLawFee            = 0;    //���Ϸ�
  double dblSumLoss           = 0;    //�����ʧ���

  double dblRescueFee         = 0;    //ʩ�ȷ�
  double dblCheckFee          = 0;    //�鿱��
  double dblJudgeFee          = 0;    //���������
  double dblGsjzFee			  = 0;	  //���������
  double dblAssessFee         = 0; 	  //������
  double dblFlFee			  = 0;	  //���ɷ�  
  double dblElseFee           = 0;    //����
  
  double dblPropSumLossPay	  = 0;	  //�Ʋ���ʧ
  double dblPersonSumLossPay  = 0;	  //������ʧ
  double dblSumLossPay		  = 0;	  //������
  
  
  
  String strSumThisPaid       = "";   //
  String strCSumThisPaid      = "";   //
  String strSumLossPay		 = "";	 //������
  String strCSumLossPay	     = "";	 //����������
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
  String strHandlerName       = "";   //������
  String strInputDate         = "";   //��������
  String strUnderWriteEndDate = "";   //����ͨ������
  String strUnderWriteName    = "";
  String strApproverCode      = "";
  String strOperatorCode      = "";
  String strApproverName      = "";
  String strOperatorName      = "";
  String strLossRate          = "";
  //add begin by zhuly 20051103 
  String[] subKindName        = new String[6]; //�������ձ�����
  String[] subKindAmount      = new String[6]; //�����ձ���
  String strKindName          = "";  //�����ձ�
  String strFlag              = "";  //���ո����ձ�־
  String strKindAmount        = "";  //�������޶�
  String strCarInsuredRelation = "" ; //�������ʴ���
  String strCarInsuredRelationName = "";//��������
  String strUseNatureCode     = "";  //ʹ������
  String strBLNo              = "";  //���������乤���ƺ�
  String strCarryBillNo       = "";  //�������˵�����
  String strStartSiteName     = "";  //������ʼ��
  String strViaSiteName       = "";  //������ת��
  String strEndSiteName       = "";  //������ֹ��
  String strCaseNo            = "";  //�ⰸ���
  String strSumAmount         = "";  //���ս��
  String strLossName          = "";  //������(��������)
  int    intLossQuantity      = 0;   //����������
 
  //�����岿��
                                              

  PrpCitemKindDto    prpItemKindDto     = null;   //������ItemKindDto����
  PrpCmainDto        prpCmainDto        = null;   //�����������
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto����
  PrpLchargeDto      prpLchargeDto      = null;   //ChargeDto����
  PrpLctextDto       prpLctextDto       = null; 
  PrpLregistDto      prpLregistDto      = null;
  PrpLextDto         prpLextDto         = null;
  PrpCmainCargoDto   prpCmainCargoDto   = null;   //�����ձ�����Ϣ
  
  int                intCompensateCount = 0;      //CompensateDto����ļ�¼��
  int                intItemCarCount    = 0;      //ItemcarDto����ļ�¼��
  int                intItemKindCount   = 0;      //ItemKindDto����ļ�¼��
  int                intThirdPartyCount = 0;      //ThirdPartyDto����ļ�¼��
  int                intChargeCount     = 0;      //ChargeDto����ļ�¼��
  int                intCtextCount      = 0;      //CtextDto����ļ�¼��
  int                intCtextCountTmp   = 0;      //textarea����
  int                intDriverCount     = 0;      //DriverDto����ļ�¼��
  int                intPropCount       = 0;
  String             lossDesc           = "";     //��ʧ�̶�
    
  int index = 0;
  
  //�õ�ClaimDto,RegistDto,PolicyDto,CompensateDto,CheckDto����
  ClaimDto           claimDto           = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto          policyDto          = (PolicyDto)request.getAttribute("policyDto");
  RegistDto          registDto          = (RegistDto)request.getAttribute("registDto");
  CheckDto           checkDto           = (CheckDto)request.getAttribute("checkDto"); 
  CompensateDto      compensateDto      = (CompensateDto)request.getAttribute("compensateDto"); 
  
  UICodeAction       uiCodeAction       = new UICodeAction();
  prpLcompensateDto                     = compensateDto.getPrpLcompensateDto(); //�õ�prpLcompensateDto ����
  prpLclaimDto                          = claimDto.getPrpLclaimDto();           //�õ�prpLclaimDto����   
  prpCmainDto                           = policyDto.getPrpCmainDto();           //�õ������������
  prpLregistDto                         = registDto.getPrpLregistDto();         //�õ�prpLregistDto����
  prpCmainCargoDto                      = policyDto.getPrpCmainCargoDto();      //�õ�prpCmainCargoDto����
  strClaimNo                            = prpLclaimDto.getClaimNo();   
  DateTime           dateTime           = new DateTime();
  //�õ�������
  strPolicyNo = prpLclaimDto.getPolicyNo();
  //�õ��ⰸ���
  strCaseNo   = prpLcompensateDto.getCaseNo();
  //�õ����ս��
  strSumAmount = ""+new DecimalFormat("#,##0.00").format(prpCmainDto.getSumAmount());
  String  RiskCode = "" ;  //�������ִ���
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
    
      strPayRefName = uiCodeAction.translateUserCode(strPayRefCode,true);
    }
  }
  
  
  //�õ������ʧ
  dblSumLoss   = prpLcompensateDto.getSumLoss();
  
  	dblPropSumLossPay = compensateDto.getPrpLcompensateDto().getLossSumRealPay();	  //�Ʋ���ʧ
	dblPersonSumLossPay = compensateDto.getPrpLcompensateDto().getPersonLossSumRealPay();	  //������ʧ
	dblSumLossPay = dblPropSumLossPay + dblPersonSumLossPay;	  //������
	strSumLossPay = new DecimalFormat("#,##0.00").format(dblSumLossPay);
	strCSumLossPay = MoneyUtils.toChinese(dblSumLossPay,prpLcompensateDto.getCurrency());   
	
	//�õ������˺ͺ�����
	strHandlerName = uiCodeAction.translateUserCode(prpLcompensateDto.getHandlerCode(),true);
	strUnderWriteName = prpLcompensateDto.getUnderWriteName();
  strInputDate = prpLcompensateDto.getInputDate().getYear()+"��"+prpLcompensateDto.getInputDate().getMonth()+"��"+prpLcompensateDto.getInputDate().getDate()+"��";
  strUnderWriteEndDate = prpLcompensateDto.getUnderWriteEndDate().getYear()+"��"+prpLcompensateDto.getUnderWriteEndDate().getMonth()+"��"+prpLcompensateDto.getUnderWriteEndDate().getDate()+"��";
  
  //������Ϣ
  if(registDto.getPrpLregistDto()!=null)
  {
     strLossName         = prpLregistDto.getLossName();
     intLossQuantity     = (int)prpLregistDto.getLossQuantity();
  } 
  if(policyDto.getPrpCmainCargoDto()!=null)
  {
    strBLNo              = prpCmainCargoDto.getBLNo();            //���������乤���ƺ�
    strCarryBillNo       = prpCmainCargoDto.getCarryBillNo();     //�������˵�����
    strStartSiteName     = prpCmainCargoDto.getStartSiteName();   //������ʼ��
    strViaSiteName       = prpCmainCargoDto.getViaSiteName();     //������ת��
    strEndSiteName       = prpCmainCargoDto.getEndSiteName();     //������ֹ��        
  }
    if(strStartSiteName.equals(""))
    {
        strStartSiteName = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    }   
    if(strViaSiteName.equals(""))
    {
        strViaSiteName = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    } 
    if(strEndSiteName.equals(""))
    {
        strEndSiteName = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
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
%>

<script language="javascript">
  function loadForm()
  {
        
    //*****���������PrpLcompensate*****
    //tdCompensateNo.innerHTML  = '<%=strCompensateNo%>';
    
<%
    dblSumPaid      = dblSumLossPay;             
    strSumPaid      = new DecimalFormat("#,##0.00").format(dblSumLossPay);    
    strCSumPaid     = MoneyUtils.toChinese(dblSumLossPay,prpLcompensateDto.getCurrency());   
%>
    //tdCSumPaid.innerHTML  = '&nbsp;����ܼƣ���д����'      + '<%=strCSumPaid%>'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Сд)��:'+ '<%=strSumPaid%>Ԫ';
    tdCSumLossPay.innerHTML = '&nbsp;����ܼƣ���д����'      + '<%=strCSumLossPay%>'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Сд)��:'+ '<%=strSumLossPay%>Ԫ';
    
    tdSSumPaid.innerHTML      = '&nbsp;'+'<%=strSumPaid%>'+'Ԫ';
    tdSSumLossPay.innerHTML   = '&nbsp;'+'<%=strSumLossPay%>';
    tdBLNo.innerHTML          = '<%=strBLNo%>';         
    tdCarryBillNo.innerHTML   = '<%=strCarryBillNo%>';
    tdSiteName.innerHTML      = '��'+'<%=strStartSiteName%>'+'��'+'<%=strViaSiteName%>'+'��'+'<%=strEndSiteName%>';
    tdCaseNo.innerHTML        = '<%=strClaimNo%>';
    tdSumAmount.innerHTML     = '<%=strSumAmount%>';
    //tdSumLoss.innerHTML       = '&nbsp;'+'<%=new DecimalFormat("#,##0.00").format(dblSumLoss)%>';
    tdSumLossPay.innerHTML       = '&nbsp;'+'<%=new DecimalFormat("#,##0.00").format(dblSumLossPay)%>';
    //tdLossName.innerHTML      = '<%=StringConvert.encode(strLossName)%>';
    //tdLossQuantity.innerHTML  = '<%=intLossQuantity%>';
    tdPolicyNo.innerHTML      = '<%=strPolicyNo%>';
    tdRiskName.innerHTML      = '<%=strRiskName%>';
    tdInsuredName.innerHTML   = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
<%    
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                        + " �� " +prpLclaimDto.getDamageStartDate().getMonth()
                        + " �� " + prpLclaimDto.getDamageStartDate().getDate()
                        + " ��";
    String damangeAddressType = uiCodeAction.translateCodeCode("DamageAddress",prpLregistDto.getDamageAddressType(),true);
%>                    
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>';
    tdDamageName.innerHTML      = '<%=StringConvert.encode(prpLclaimDto.getDamageName())%>';  
    tdDamageAddress.innerHTML   = '<%=StringConvert.encode(prpLclaimDto.getDamageAddress())%>';
<%    
    strInsuredDate =  prpLclaimDto.getStartDate().getYear()
                     + "��" +prpLclaimDto.getStartDate().getMonth()
                     + "��" + prpLclaimDto.getStartDate().getDate()
                     + "��" ;
%>                    
    tdInsuredDate.innerHTML = '<%=strInsuredDate%>';    
<%
    //*****���������ϢPrpTitemKind*****
    dblSumAmount1 = 0;
    dblSumAmount2 = 0;
    
  if(policyDto.getPrpCitemKindDtoList()!=null){
     int tempindex = 0 ;  //������ʱ����
    for(index=0;index<intItemKindCount;index++)
    {      
      prpItemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
      strRiskCode = prpItemKindDto.getRiskCode();
      strKindCode = prpItemKindDto.getKindCode();
      strKindName = prpItemKindDto.getKindName();  
      strKindAmount = ""+prpItemKindDto.getAmount();
      strFlag     = prpItemKindDto.getFlag();
      strCalculateFlag = prpItemKindDto.getCalculateFlag();         
    }    
  }     
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    //*****���������ֱ�PrpLctext*****
    for(index=0;index<intCtextCount;index++)
    {
      prpLctextDto = (PrpLctextDto)compensateDto.getPrpLctextDtoDtoList().get(index);
      strTextType = StringConvert.encode(prpLctextDto.getTextType());
      if ( strTextType.charAt(0)=='7' )
      {      
        strContext = strContext + StringConvert.encode(prpLctextDto.getContext()) ;
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
    
    if( intCtextCountTmp>20 )
    {
      strContext = strContext.substring(0,600)+"<br>��������Ϣ���࣬������嵥��";  
    }
    while(strContext.indexOf("\\r\\n")!=-1)
       strContext=strContext.substring(0,strContext.indexOf("\\r\\n"))+"<br>"+strContext.substring(strContext.indexOf("\\r\\n")+"\\r\\n".length());

%>  
   tdContext.innerHTML = '<%="&nbsp;������㣺<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+strContext%>';
<%    
    //*****��������Ϣ��PrpLcharge*****    
    dblJudgeFee = 0;  
    dblCheckFee = 0;  
    dblLawFee   = 0;  
    dblElseFee  = 0;
    dblCheckFee1 = 0; 
    dblAssessFee = 0; 
    dblRescueFee = 0;
  if(compensateDto.getPrpLchargeDtoList()!=null){
    for(index=0;index<intChargeCount;index++)
    {
      prpLchargeDto = (PrpLchargeDto)compensateDto.getPrpLchargeDtoList().get(index);
      strChargeCode = StringConvert.encode(prpLchargeDto.getChargeCode()); 
           
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
      else if( strChargeCode.equals("03"))   //ʩ�ȷ�
      {
        dblRescueFee += prpLchargeDto.getChargeAmount();        
      }
      else if( strChargeCode.equals("09"))   //�����
      { 
        dblAgentFee  += prpLchargeDto.getChargeAmount();
      }
      else if( strChargeCode.equals("11"))   //���������
      { 
        dblGsjzFee  += prpLchargeDto.getChargeAmount();
      }
      else if( strChargeCode.equals("15"))   //���ɷ�
      { 
        dblFlFee  += prpLchargeDto.getChargeAmount();
      }
      else if( strChargeCode.equals("99"))   //����
      { 
        dblElseFee  += prpLchargeDto.getChargeAmount();
      }
    }    
  }    
%>    
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
    
    
    
}
</script>
  