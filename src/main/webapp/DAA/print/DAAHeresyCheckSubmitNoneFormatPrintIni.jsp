<%--
****************************************************************************
* DESC       �������������մ��鿱ί�����ӡ��ʼ��
* AUTHOR     ��zhulianyu
* CREATEDATE ��2005-11-15
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
  String strLicenseNo         = "";   //�����еĺ��ƺ���
  String strLicenseColorCode  = "";   //�����еĺ��Ƶ�ɫ
  String strLicenseNo1        = "";   //���⳵����Ϣ�еĺ��ƺ���
  String strLicenseColorCode1 = "";   //���⳵����Ϣ�еĺ��Ƶ�ɫ
  String strInsureCarFlag     = "";   //�Ƿ�Ϊ����������
  String strTextType           = "";
  String strContext           = "";   //������������
  String strDamageStartDate   = "";   //����ʱ��
  String strReportDate        = "";   //����ʱ��
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
  String strSeatCount         = "";   //��λ��
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
  String strInsuredName       = "";  //��������
  String strBrandName         = "";  //�����ͺ�
  String strDamageAddress     = "";  //���յص�
  String strDamageName        = "";  //����ԭ��

  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
  
  //�����岿��
                                              
  PrpCitemCarDto     prpItemCarDto      = null;   //ItemCarDto���� 
  PrpCitemKindDto    prpItemKindDto     = null;   //������ItemKindDto����
  PrpLchargeDto      prpLchargeDto      = null;   //ChargeDto����
  PrpLctextDto       prpLctextDto       = null; 
  PrpLdriverDto      prpLdriverDto      = null;
  PrpLregistDto      prpLregistDto      = null;
  PrpLpropDto        prpLpropDto        = null;
  PrpLextDto         prpLextDto         = null;
  PrpCmainDto        prpCmainDto        = null;   //�����������
  
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
   System.out.println("zhulianyu"); 
  //�õ�RegistDto,PolicyDto����
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  UICodeAction uiCodeAction = new UICodeAction();
  //�õ�prpCmainDto����
  if(policyDto.getPrpCmainDto()!=null)
  {
    prpCmainDto = policyDto.getPrpCmainDto();
  }     
  //�õ�prpLregistDto����
  prpLregistDto  = registDto.getPrpLregistDto();
    System.out.println("zhulianyu");
  //�õ�������
  strPolicyNo = prpCmainDto.getPolicyNo();
  
  //�õ�blPrpCitemCar���� 
  if(policyDto.getPrpCitemCarDtoList()!=null){
    intItemCarCount     = policyDto.getPrpCitemCarDtoList().size();
  }  
  System.out.println("zhulianyu");
  //�õ�blPrpCitemKind����ļ�¼��
  if(policyDto.getPrpCitemKindDtoList()!=null){
    intItemKindCount     = policyDto.getPrpCitemKindDtoList().size();
  }  
   
  //������Ϣ
  if(registDto.getPrpLregistDto()!=null)
  {
     strLicenseNo     =  prpLregistDto.getLicenseNo();
     strEngineNo      =  prpLregistDto.getEngineNo();
     strBrandName     =  prpLregistDto.getBrandName();
     strEngineNo      =  prpLregistDto.getEngineNo();
     strRegistNo      =  prpLregistDto.getRegistNo();
     strDamageAddress =  prpLregistDto.getDamageAddress();
     System.out.println("zhuilanyu"+strDamageAddress);
     strDamageName    =  prpLregistDto.getDamageName();
  }
  //������Ϣ
  if(policyDto.getPrpCmainDto()!=null)
  {
     strInsuredName = prpCmainDto.getInsuredName();
  }
  System.out.println(strLicenseNo);
%>

<script language="javascript">
  function loadForm()
  { 
    tdLicenseNo.innerHTML       = '<%=StringConvert.encode(strLicenseNo)%>';
    tdEngineNo.innerHTML        = '<%=StringConvert.encode(strEngineNo)%>';   
    tdPolicyNo.innerHTML        = '<%=StringConvert.encode(strPolicyNo)%>';
    tdInsuredName.innerHTML     = '<%=StringConvert.encode(prpCmainDto.getInsuredName())%>';
    tdRegistNo.innerHTML        = '<%=StringConvert.encode(prpLregistDto.getRegistNo())%>';
    tdDamageAddress.innerHTML   = '<%=StringConvert.encode(prpLregistDto.getDamageAddress())%>';
    tdDamageName.innerHTML      = '<%=StringConvert.encode(strDamageName)%>';
<%    
    strDamageStartDate = prpLregistDto.getDamageStartDate().getYear()
                        + " �� " + prpLregistDto.getDamageStartDate().getMonth()
                        + " �� " + prpLregistDto.getDamageStartDate().getDate()
                        + " �� " + prpLregistDto.getDamageStartHour().substring(0,2)
                        + " ʱ ";
    strReportDate      = prpLregistDto.getReportDate().getYear()
                        + " �� " + prpLregistDto.getReportDate().getMonth()
                        + " �� " + prpLregistDto.getReportDate().getDate()
                        + " �� " + prpLregistDto.getReportHour().substring(0,2)
                        + " ʱ ";
    String damangeAddressType = uiCodeAction.translateCodeCode("DamageAddress",prpLregistDto.getDamageAddressType(),true);
%>                    
    tdDamageStartDate.innerHTML       = '<%=strDamageStartDate%>'; 
    tdDamageAddress.innerHTML         = '<%=StringConvert.encode(prpLregistDto.getDamageAddress())%>';
    tdReportDate.innerHTML            = '<%=strReportDate%>';
<%    
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
%>                    
    tdInsuredDate.innerHTML = '<%=strInsuredDate%>';
    
    //*****���⳵����ϢPrpLthirdParty*****  
<%
    //modify by lixiaohua 20040326 begin reason �������鳧���ͺŴ�ӡ����
  if(policyDto.getPrpCitemCarDtoList()!=null){
    for(index=0;index<intItemCarCount;index++)
    { 
        prpItemCarDto       = (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(index);
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
        tdBrandName.innerHTML    = '<%=StringConvert.encode(prpItemCarDto.getBrandName())%>';
        tdSeatTonCount.innerHTML = '<%=strSeatCount+"��/"+strTonCount+"��"%>';  
        tdEngineNo.innerHTML     = '<%=StringConvert.encode(prpItemCarDto.getEngineNo())%>';
     
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
    //*****���������ϢPrpCitemKind*****
    dblSumAmount1 = 0;
    dblSumAmount2 = 0;
    
  if(policyDto.getPrpCitemKindDtoList()!=null){
  System.out.println("�м����ձ�");
     int tempindex = 0 ;  //������ʱ����
    for(index=0;index<intItemKindCount;index++)
    {
      prpItemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
      strRiskCode = prpItemKindDto.getRiskCode();
      strKindCode = prpItemKindDto.getKindCode();
      strKindName = prpItemKindDto.getKindName();  
      strKindAmount = ""+prpItemKindDto.getAmount();
      strFlag     = prpItemKindDto.getFlag();
      //strCalculateFlag = dbPrpDkind.getCalculateFlag().substring(0,2);
      strCalculateFlag = prpItemKindDto.getCalculateFlag();    
      //strCalculateFlag="Y1";
      if( strFlag.substring(1,2).equals("1") && strKindCode.equals("A"))//���ճ����ձ��� 
      {
        dblSumAmount1 += prpItemKindDto.getAmount();
        System.out.println("�����ձ���"+dblSumAmount1);
      }
      if( strFlag.substring(1,2).equals("1") && strKindCode.equals("B"))//���������U���~
      {
        dblSumAmount2 += prpItemKindDto.getAmount();
      }
      if( strFlag.substring(1,2).equals("2")&&tempindex<6)//������
      {
        subKindName[tempindex] = strKindName;
   %>
      <%="tdKindName"+tempindex%>.innerHTML = '<%=subKindName[tempindex]%>';          
   <%
        tempindex ++;
      }      
    }    
  }  
System.out.println(dblSumAmount1+"  "+dblSumAmount2);
%>
    tdSumAmount1.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount1)+"Ԫ"%>';
    tdSumAmount2.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount2)+"Ԫ"%>';  
    <%System.out.println(dblSumAmount1+"  "+dblSumAmount2);%>  
}  
</script>
  