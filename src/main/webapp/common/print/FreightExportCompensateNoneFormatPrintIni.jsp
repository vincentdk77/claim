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
<%@page import="com.sinosoft.claim.dto.domain.PrpCplanDto"%> 

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
  String strLicenseNo         = "";   //�����еĺ��ƺ���
  String strLicenseColorCode  = "";   //�����еĺ��Ƶ�ɫ
  String strLicenseNo1        = "";   //���⳵����Ϣ�еĺ��ƺ���
  String strLicenseColorCode1 = "";   //���⳵����Ϣ�еĺ��Ƶ�ɫ
  String strInsureCarFlag     = "";   //�Ƿ�Ϊ����������
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
  double dblSumLoss           = 0;    //�����ʧ���
  double dblGsjzFee			  = 0;	  //���������
  double dblFlFee			  = 0;	  //���ɷ�
  
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
  //add begin by zhuly 20051103 
  String strSeatCount         = "";  //��λ��
  String strTonCount          = "";  //��λ��
  String strFrameNo           = "";  //܇��̖
  String strEngineNo          = "";  //�l�әC̖
  String[] subKindName        = new String[6]; //�������ձ�����
  String[] subKindAmount      = new String[6]; //�����ձ���
  String strKindName          = "";  //�����ձ�
  String strFlag              = "";  //���ո����ձ�־
  String strKindAmount        = "";  //�������޶�
  String strCarInsuredRelation = "" ;//�������ʴ���
  String strCarInsuredRelationName = "";//��������
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
  String strValue1            = "";  //��ļ�����
   
  //add end   by zhuly 20051103

  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
  
  //�����岿��
  PrpCitemCarDto     prpItemCarDto      = null;   //ItemCarDto���� 
  PrpCitemKindDto    prpItemKindDto     = null;   //������ItemKindDto����
  PrpCmainDto        prpCmainDto        = null;   //�����������
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto����
  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto����
  PrpLchargeDto      prpLchargeDto      = null;   //ChargeDto����
  PrpLctextDto       prpLctextDto       = null; 
  PrpLdriverDto      prpLdriverDto      = null;
  PrpLregistDto      prpLregistDto      = null;
  PrpLpropDto        prpLpropDto        = null;
  PrpLextDto         prpLextDto         = null;   //������չ��Ϣ��
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
  
  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto,CompensateDto,CheckDto,EndorseDto����
  ClaimDto           claimDto           = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto          policyDto          = (PolicyDto)request.getAttribute("policyDto");
  RegistDto          registDto          = (RegistDto)request.getAttribute("registDto");
  CheckDto           checkDto           = (CheckDto)request.getAttribute("checkDto"); 
  CompensateDto      compensateDto      = (CompensateDto)request.getAttribute("compensateDto"); 
  CertainLossDto     certainLossDto     = (CertainLossDto)request.getAttribute("certainLossDto"); 
  EndorseDto         endorseDto         = (EndorseDto)request.getAttribute("endorseDto");   
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
  strRiskName = uiCodeAction.translateRiskCode(RiskCode,true);
 //�õ������ʧ
  dblSumLoss   = prpLcompensateDto.getSumLoss();
  //�õ�blPrpCitemCar����  
  if(policyDto.getPrpCitemCarDtoList()!=null){
    intItemCarCount     = policyDto.getPrpCitemCarDtoList().size();
  } 
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
  //�õ���ʧ�̶�����
  if (claimDto.getPrpLthirdCarLossDtoList() != null) {
     for(index=0;index<claimDto.getPrpLthirdCarLossDtoList().size();index++){
      PrpLthirdCarLossDto prpLthirdCarLossDto = (PrpLthirdCarLossDto) claimDto.getPrpLthirdCarLossDtoList().get(0);
      lossDesc = prpLthirdCarLossDto.getLossDesc();
      }
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
    strCSumThisPaid = MoneyUtils.toChinese(dblSumThisPaid,prpLcompensateDto.getCurrency());
    dblSumPaid      = prpLcompensateDto.getSumPaid();             
    strSumPaid      = new DecimalFormat("#,##0.00").format(dblSumPaid);    
    strCSumPaid     = MoneyUtils.toChinese(dblSumPaid,prpLcompensateDto.getCurrency());  
%>
    //tdSumPrePaid.innerHTML    = '&nbsp;��Ԥ����'                    + '<%=DataUtils.zeroToEmpty(dblSumPrePaid)%>';
    //tdSumRest.innerHTML       = '&nbsp;��������/��ֵ��'           + '<%=DataUtils.zeroToEmpty(dblSumRest)%>';
    //tdCSumThisPaid.innerHTML  = '&nbsp;����ʵ��������Ҵ�д����'  + '<%=strCSumThisPaid%>';
    //tdSumThisPaid.innerHTML   = '������'                        + '<%=strSumThisPaid%>';
    //tdCSumPaid.innerHTML      = '&nbsp;����ܼƣ���д����'      + '<%=strCSumPaid%>'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Сд)��:'+ '<%=strSumPaid%>Ԫ';
    tdSSumPaid.innerHTML      = '&nbsp;'+'<%=strSumPaid%>'+'Ԫ';
    //tdBLNo.innerHTML            = '<%=strBLNo%>';         
    //tdCarryBillNo.innerHTML     = '<%=strCarryBillNo%>';
    tdSumAmount.innerHTML       = '<%=StringConvert.encode(strSumAmount)%>';
    tdRiskName.innerHTML      = '<%=strRiskName%>';
    //tdSumLoss.innerHTML         = '&nbsp;'+'<%=new DecimalFormat("#,##0.00").format(dblSumLoss)%>';
    tdLadingNo.innerHTML        = '<%=StringConvert.encode(strLadingNo)%>';
    tdInvoiceNo.innerHTML       = '<%=StringConvert.encode(strInvoiceNo)%>';
    tdCheckAgentCode.innerHTML  = '<%=StringConvert.encode(strCheckAgentCode)%>';
    tdBLName.innerHTML          = '<%=StringConvert.encode(strBLName)%>';
    tdSiteName.innerHTML        = '��'+'<%=strStartSiteName%>'+'����'+'<%=strEndSiteName%>'+'ֹ';    
    tdPolicyNo.innerHTML        = '<%=StringConvert.encode(strPolicyNo)%>';
    tdCaseNo.innerHTML          = '<%=StringConvert.encode(strCaseNo)%>';
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
    //tdSumClaim.innerHTML        = '<%= lossDesc %>';    
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
%>                    
    //tdInsuredDate.innerHTML = '<%=strInsuredDate%>';
    
    //*****���⳵����ϢPrpLthirdParty*****  
<%
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
        //tdUseNatureCode.innerHTML = '<%=strUseNatureCode%>';
        //tdLicenseNo.innerHTML    = '<%=StringConvert.encode(prpItemCarDto.getLicenseNo())%>';       
        //tdBrandName.innerHTML    = '<%=StringConvert.encode(prpItemCarDto.getBrandName())%>';
        //tdCarInsuredRelationName.innerHTML = '<%=strCarInsuredRelationName%>';
        //tdSeatTonCount.innerHTML = '<%=strSeatCount+"��/"+strTonCount+"��"%>';  
        //tdEngineNo.innerHTML     = '<%=StringConvert.encode(prpItemCarDto.getEngineNo())%>';
        //tdFrameNo.innerHTML      = '<%=StringConvert.encode(prpItemCarDto.getFrameNo())%>'; 
     
<%
        System.out.println(prpItemCarDto.getLicenseNo()+" "+prpItemCarDto.getBrandName()+" ppppppppppppppppppppppppp");
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
    //*****�������ձ����Ϣ��PrpCitemCar*****    
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
      //add end by zhuly 20051103
      //strRiskCode = prpItemKindDto.getRiskCode();
      //strKindCode = prpItemKindDto.getKindCode();
      //dbPrpDkind.getInfo(strRiskCode,strKindCode);
      //strCalculateFlag = dbPrpDkind.getCalculateFlag().substring(0,2);
      strCalculateFlag = prpItemKindDto.getCalculateFlag();    
      //strCalculateFlag="Y1";
      if( strFlag.substring(1,2).equals("1") && strKindCode.equals("A"))//����܇�p�U���~ 
      {
        dblSumAmount1 += prpItemKindDto.getAmount();
      }
      if( strFlag.substring(1,2).equals("1") && strKindCode.equals("B"))//���������U���~
      {
        dblSumAmount2 += prpItemKindDto.getAmount();
      }
      if( strFlag.substring(1,2).equals("2")&&tempindex<6)//������
      {
        subKindName[tempindex] = strKindName;
        subKindAmount[tempindex] = strKindAmount;  
   %>
     // <%="tdKindName"+tempindex%>.innerHTML = '<%=subKindName[tempindex]%>'; 
     // <%="tdKindAmount"+tempindex%>.innerHTML = '<%=subKindAmount[tempindex]%>';              
   <%
        tempindex ++;
      }      
    }    
  }  

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
      if ( strTextType.charAt(0)=='1' )
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
      strContext = strContext.substring(0,1200)+"<br>��������Ϣ���࣬������嵥��";  
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
<%  
    strSumThisPaid  = new DecimalFormat("#,##0.00").format(dblSumThisPaid-dblJudgeFee-dblCheckFee-dblLawFee-dblElseFee-dblSumPrePaid-dblSumRest);
    strCSumThisPaid = MoneyUtils.toChinese(dblSumThisPaid-dblJudgeFee-dblCheckFee-dblLawFee-dblElseFee-dblSumPrePaid-dblSumRest,prpLcompensateDto.getCurrency());
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
     strValue1           =  prpLextDto.getValue1();
     strSailStartDate    = prpLextDto.getSailStartDate().getYear()
                         + "��"+prpLextDto.getSailStartDate().getMonth()
                         + "��"+prpLextDto.getSailStartDate().getDay()
                         + "��";   
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
   tdValue1.innerHTML = '<%=strValue1%>';
   tdSailStartDate.innerHTML = '<%=strSailStartDate%>';
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
   //tdEndorseNo.innerHTML = '<%=strEndorseNo%>';
<%
    }
  }
%>
   
}  
</script>
  