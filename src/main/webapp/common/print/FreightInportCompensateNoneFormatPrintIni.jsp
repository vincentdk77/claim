<%--
****************************************************************************
* DESC       �����ڻ������䱣������������ӡ��ʼ��
* AUTHOR     ��zhuly
* CREATEDATE ��2005-11-15
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%-- ����bean�ಿ�� --%>
<%@page import="java.text.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDrisk" %>

<%
  //������������
  String strCompensateNo      = request.getParameter("CompensateNo"); //���������
  String strClaimNo           = "";   //������
  String strRegistNo          = "";   //������
  String strPolicyNo          = "";   //������
  String strTextType          = "";
  String strContext           = "";   //������������
  String strDamageStartDate   = "";   //��������
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
  double dblAgentFee          = 0;    //�����
  double dblGsjzFee			  = 0;	  //���������
  double dblFlFee			  = 0;	  //���ɷ�
  
  double dblSumLoss           = 0;    //�����ʧ���
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
  String[] subKindName        = new String[6]; //�������ձ�����
  String[] subKindAmount      = new String[6]; //�����ձ���
  String strKindName          = "";  //�����ձ�
  String strFlag              = "";  //���ո����ձ�־
  String strKindAmount        = "";  //�������޶�
  String strUseNatureCode     = "";  //ʹ������
  String strBLNo              = "";  //���������乤���ƺ�
  String strCarryBillNo       = "";  //�������˵�����
  String strStartSiteName     = "";  //������ʼ��
  String strViaSiteName       = "";  //������ת��
  String strEndSiteName       = "";  //������ֹ��
  String strCaseNo            = "";  //�ⰸ���
  String strSumAmount         = "";  //���ս��
  String strLadingNo          = "";  //�ᵥ��
  String strInvoiceNo         = "";  //��˾��ͬ��Ʊ��
  String strBLName            = "";  //���乤��
  String strSailStartDate     = "";  //��������
  String strCheckAgentCode    = "";  //��������˴���
   
  //add end   by zhuly 20051103

  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
  
  //�����岿��
  PrpCitemKindDto    prpItemKindDto     = null;   //������ItemKindDto����
  PrpCmainDto        prpCmainDto        = null;   //�����������
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto����
  PrpLchargeDto      prpLchargeDto      = null;   //ChargeDto����
  PrpLctextDto       prpLctextDto       = null; 
  PrpLdriverDto      prpLdriverDto      = null;
  PrpLregistDto      prpLregistDto      = null;
  PrpLpropDto        prpLpropDto        = null;
  PrpLextDto         prpLextDto         = null;   //������չ��Ϣ��
  PrpCmainCargoDto   prpCmainCargoDto   = null;   //�����ձ�����Ϣ  
  int                intCompensateCount = 0;      //CompensateDto����ļ�¼��
  int                intItemKindCount   = 0;      //ItemKindDto����ļ�¼��
  int                intThirdPartyCount = 0;      //ThirdPartyDto����ļ�¼��
  int                intChargeCount     = 0;      //ChargeDto����ļ�¼��
  int                intCtextCount      = 0;      //CtextDto����ļ�¼��
  int                intCtextCountTmp   = 0;      //textarea����
  int                intPropCount       = 0;
    
  int index = 0;
  
  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto,CompensateDto,CheckDto,EndorseDto����
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
  strOperatorCode                       = prpLcompensateDto.getOperatorCode();    
  strOperatorName                       = uiCodeAction.translateUserCode(strOperatorCode,isChinese); 
  DateTime           dateTime           = new DateTime();
  //String strDateTime = new DateTime(dateTime.current(),dateTime.YEAR_TO_HOUR);
  //�õ�������
  strPolicyNo = prpLclaimDto.getPolicyNo();
  System.out.println("zhulianyu");  
  //�õ��ⰸ���
  strCaseNo   = prpLcompensateDto.getCaseNo();
  //�õ����ս��
  strSumAmount = ""+new DecimalFormat("#,##0.00").format(prpCmainDto.getSumAmount());
  String  RiskCode = "" ;  //�������ִ���
  String  strRiskName = "" ;  //������������
  RiskCode = prpCmainDto.getRiskCode();//
  strSailStartDate = prpCmainDto.getStartDate().toString();
  strRiskName = uiCodeAction.translateRiskCode(RiskCode,true);
  //�õ������ʧ
  dblSumLoss   = prpLcompensateDto.getSumLoss();
  //**********************�����ձ�����Ϣ*****************************//
  if(policyDto.getPrpCmainCargoDto()!=null)
  {
    strBLNo              = prpCmainCargoDto.getBLNo();            //���������乤���ƺ�
    strCarryBillNo       = prpCmainCargoDto.getCarryBillNo();     //�������˵�����
    strStartSiteName     = prpCmainCargoDto.getStartSiteName();   //������ʼ��
    strViaSiteName       = prpCmainCargoDto.getViaSiteName();     //������ת��
    strEndSiteName       = prpCmainCargoDto.getEndSiteName();     //������ֹ��  
    strLadingNo          = prpCmainCargoDto.getLadingNo();        //�õ��ᵥ�� 
    strInvoiceNo         = prpCmainCargoDto.getInvoiceNo();       //��Ʊ��
    strBLName            = prpCmainCargoDto.getBLName();          //���乤��
    strCheckAgentCode    = prpCmainCargoDto.getCheckAgentCode();  //�������
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
  
  List prplLossList = new ArrayList();
  if(compensateDto.getPrpLlossDtoList()!=null){
  	prplLossList = compensateDto.getPrpLlossDtoList();
  }

  //������4���ձ�,��չ�4����������4�������ӡ��������
  int printLossCount = 4;
  int prplLossListSize = prplLossList.size();
  
  if(prplLossListSize<printLossCount){
  	for(int i=prplLossListSize;i<printLossCount;i++){
	  	prplLossList.add(new PrpLlossDto());
	}  	
  }else if(prplLossList.size()>printLossCount){
  	prplLossList.subList(0,printLossCount-1);
  }
  
%>

<script language="javascript">
  function loadForm()
  {
        
    //*****���������PrpLcompensate*****
    //tdCompensateNo.innerHTML  = '<%=strCompensateNo%>';
    
<%
    dblSumPrePaid   = prpLcompensateDto.getSumPrePaid();  
    dblSumRest      = prpLcompensateDto.getSumRest();     
    dblSumThisPaid  = prpLcompensateDto.getSumThisPaid(); 
    strSumThisPaid  = new DecimalFormat("#,##0.00").format(dblSumThisPaid);
    dblSumThisPaid  = Math.abs(dblSumThisPaid);
    strCSumThisPaid = MoneyUtils.toChinese(dblSumThisPaid,prpLcompensateDto.getCurrency());
    dblSumPaid      = prpLcompensateDto.getSumPaid();             
    strSumPaid      = new DecimalFormat("#,##0.00").format(dblSumPaid);    
    dblSumPaid      = Math.abs(dblSumPaid);
    strCSumPaid     = MoneyUtils.toChinese(dblSumPaid,prpLcompensateDto.getCurrency());  
    System.out.println("zhulianyu");  
%>
    tdSumAmount.innerHTML       = '<%=StringConvert.encode(strSumAmount)%>';
    //tdSumLoss.innerHTML         = '&nbsp;'+'<%=new DecimalFormat("#,##0.00").format(dblSumLoss)%>';
    tdSSumPaid.innerHTML      = '&nbsp;'+'<%=strSumPaid%>'+'Ԫ';
    tdLadingNo.innerHTML        = '<%=StringConvert.encode(strLadingNo)%>';
    tdInvoiceNo.innerHTML       = '<%=StringConvert.encode(strInvoiceNo)%>';
    tdCheckAgentCode.innerHTML  = '<%=StringConvert.encode(strCheckAgentCode)%>';
    //tdBLName.innerHTML        = '<%=StringConvert.encode(strBLName)%>';
    tdBLNo.innerHTML            = '<%=StringConvert.encode(strBLNo)%>';
    tdSiteName.innerHTML        = '��'+'<%=strStartSiteName%>'+'����'+'<%=strEndSiteName%>'+'ֹ';    
    tdPolicyNo.innerHTML        = '<%=StringConvert.encode(strPolicyNo)%>';
    tdClaimNo.innerHTML         = '<%=StringConvert.encode(strClaimNo)%>';
    tdSailStartDate.innerHTML   = '<%=StringConvert.encode(strSailStartDate)%>';
    //tdCaseNo.innerHTML          = '<%=StringConvert.encode(strCaseNo)%>';
    tdInsuredName.innerHTML     = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
<%    
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                        + " �� " +prpLclaimDto.getDamageStartDate().getMonth()
                        + " �� " + prpLclaimDto.getDamageStartDate().getDate()
                        + " ��";
    String damangeAddressType = uiCodeAction.translateCodeCode("DamageAddress",prpLregistDto.getDamageAddressType(),true);

%>                    
    tdDamageStartDate.innerHTML = '<%=StringConvert.encode(strDamageStartDate)%>';
    //tdDamageName.innerHTML      = '<%=StringConvert.encode(prpLclaimDto.getDamageName())%>';  
    //tdDamageAddress.innerHTML   = '<%=StringConvert.encode(prpLclaimDto.getDamageAddress())%>';
    //tdDamageAddressType.innerHTML   = '<%=damangeAddressType%>';
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
    strInsuredDate =  prpLclaimDto.getStartDate().getYear()
                     + "��" +prpLclaimDto.getStartDate().getMonth()
                     + "��" + prpLclaimDto.getStartDate().getDate()
                     + "��" ;  
    
    //*****���������ϢPrpTitemKind*****
    dblSumAmount1 = 0;
    dblSumAmount2 = 0;
    
  if(policyDto.getPrpCitemKindDtoList()!=null){
     int tempindex = 0 ;  //������ʱ����
    for(index=0;index<intItemKindCount;index++)
    {
      prpItemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
      //add begin by zhuly 20051103 reason:�������U��Ϣ
      strRiskCode = prpItemKindDto.getRiskCode();
      strKindCode = prpItemKindDto.getKindCode();
      strKindName = prpItemKindDto.getKindName();  
      strKindAmount = ""+prpItemKindDto.getAmount();
      strFlag     = prpItemKindDto.getFlag();
      strCalculateFlag = prpItemKindDto.getCalculateFlag();    
    }    
  }  
  
  BLPrpDrisk blPrpDrisk = new BLPrpDrisk();
  String riskCName = blPrpDrisk.translateCode(strRiskCode,true);
%>
    //tdSumAmount1.innerHTML = '<%=new DecimalFormat("#,##0.00").format(policyDto.getPrpCmainDto().getSumAmount())%>';
    //tdSumAmount2.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount2)%>'; 
    //tdDeductibleRate.innerHTML = '<%=prpItemKindDto.getDeductibleRate()%>'+'��';   
<%    
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
   tdContext.innerHTML = '<%="�����㣺<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+strContext%>';
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
    tdRiskName.innerHTML      = '<%=strRiskName%>';
   
}  
</script>
  