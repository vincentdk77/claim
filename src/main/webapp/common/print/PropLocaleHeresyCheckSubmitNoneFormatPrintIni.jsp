<%--
****************************************************************************
* DESC       ���Ʋ��մ��鿱ί�����ӡ��ʼ��
* AUTHOR     ��zhulianyu
* CREATEDATE ��2005-11-15
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%-- ����bean�ಿ�� --%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 

<%
  //������������
  String strClaimNo           = "";   //������
  String strRegistNo          = "";   //������
  String strPolicyNo          = "";   //������
  String strTextType          = "";
  String strContext           = "";   //������������
  String strDamageStartDate   = "";   //����ʱ��  
  String ReportDate           = "";   //�������� 
  String strDamageAddress     = "";     //���յص�  
  String strInsuredDate       = "";   //�����ڼ�
  
  String strDate              = "";   //��������
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
  String[] subKindName        = new String[6]; //�������ձ�����
  String[] subKindAmount      = new String[6]; //�����ձ���
  String strKindName          = "";  //�����ձ�
  String strFlag              = "";  //���ո����ձ�־
  String strKindAmount        = "";  //�������޶�
  String strUseNatureCode     = "";  //ʹ������
  String strStartSiteName     = "";  //������ʼ��
  String strViaSiteName       = "";  //������ת��
  String strEndSiteName       = "";  //������ֹ��
  String strCaseNo            = "";  //�ⰸ���
  String strSumAmount         = "";  //���ս��
  String strBLName            = "";  //���乤��
  String strBLNo              = "";  //�˾��ƺ�
  String strCarryBillNo       = "";  //�˵�����
  String strSailStartDate     = "";  //��������
  String strLossName          = "";  //������(��������)
  String strReportorName      = "";  //������
  String strMakeCom           = "";  // �б���˾������������ 
  int    intLossQuantity      = 0;   //���������� 
  String strLinkerName      = "";  //��ϵ��
  String strPhoneNumber      = "";  //��ϵ�绰

  String comCName      = "";  //���鿱��˾��������
  String addressCName  = "";  //���鿱��˾��ַ
  String postCode      = "";  //���鿱��˾�ʱ�
  String phoneNumber   = "";  //���鿱��˾�绰
  String manager       = "";  //���鿱��˾����
  String faxNumber     = "";  //���鿱��˾����
 //���뷭�����
  String strCode    = ""   ;
  String strName    = ""   ;
  boolean isChinese = true ; //���ı�־
  //HttpServletRequest httpServletRequest ;
  //�����岿��
  if(request.getSession().getAttribute("user")==null)
  {
   out.println("��½��ʱ���������µ�½��");
   return;
  }
  String strUserCode        = ((UserDto)request.getSession().getAttribute("user")).getUserCode(); //��õ�ǰuser��ID
 System.out.println("<br>strUserCode=======================:"+strUserCode);
 
  PrpDcompanyDto     prpDcompanyDto     = null;   //���鿱��˾��Ϣ(��ӡ��֪ͨ��user���ڵĹ�˾)                                          
  PrpCitemKindDto    prpItemKindDto     = null;   //������ItemKindDto����
  PrpCmainDto        prpCmainDto        = null;   //�����������
  PrpLchargeDto      prpLchargeDto      = null;   //ChargeDto����
  PrpLctextDto       prpLctextDto       = null; 
  PrpLregistDto      prpLregistDto      = null;
  PrpLextDto         prpLextDto         = null;   //������չ��Ϣ��
  PrpCmainCargoDto   prpCmainCargoDto   = null;   //�����ձ�����Ϣ
  
  

  int                intItemCarCount    = 0;      //ItemcarDto����ļ�¼��
  int                intItemKindCount   = 0;      //ItemKindDto����ļ�¼��
  int                intChargeCount     = 0;      //ChargeDto����ļ�¼��
  int                intCtextCount      = 0;      //CtextDto����ļ�¼��
  int                intCtextCountTmp   = 0;      //textarea����
    
  int index = 0;  
  //�õ�RegistDto,PolicyDto����
  PolicyDto          policyDto          = (PolicyDto)request.getAttribute("policyDto");
  RegistDto          registDto          = (RegistDto)request.getAttribute("registDto");  
  UIPolicyAction     uiPolicyAction     = new UIPolicyAction();
  UICodeAction       uiCodeAction       = new UICodeAction();
  UICompanyAction    uiCompanyAction    = new UICompanyAction();
  prpLregistDto                         = registDto.getPrpLregistDto();         //�õ�prpLregistDto����
  strRegistNo                           = prpLregistDto.getRegistNo();     //�õ�������

  strPolicyNo                           = prpLregistDto.getPolicyNo();     //�õ�������
  policyDto                             = uiPolicyAction.findByPrimaryKey(strPolicyNo); //���ݱ����Ż�ñ�������
  prpCmainDto                           = policyDto.getPrpCmainDto();           //�õ������������
  
  prpCmainCargoDto                      = policyDto.getPrpCmainCargoDto();      //�õ�prpCmainCargoDto����
  prpLextDto                            = registDto.getPrpLextDto();            //�õ�prpLextDto����
  DateTime           dateTime           = new DateTime();
  prpDcompanyDto = uiCompanyAction.findByPrimaryKey(strUserCode);
 if(prpDcompanyDto!=null) 
 {
  comCName        = prpDcompanyDto.getComCName();      //���鿱��˾��������
  addressCName    = prpDcompanyDto.getAddressCName();  //���鿱��˾��ַ
  postCode        = prpDcompanyDto.getPostCode();      //���鿱��˾�ʱ�
  phoneNumber     = prpDcompanyDto.getPhoneNumber();   //���鿱��˾�绰
  manager         = prpDcompanyDto.getManager();       //���鿱��˾������ϵ�ˣ�
  faxNumber       = prpDcompanyDto.getFaxNumber();     //���鿱��˾����
 }
  //String strDateTime = new DateTime(dateTime.current(),dateTime.YEAR_TO_HOUR);
  String MakeCom = prpCmainDto.getMakeCom();
  //�õ��б���λ
   //��������
  strDate = prpCmainDto.getStartDate().getYear()
                         + "��"+prpCmainDto.getStartDate().getMonth()
                         + "��"+prpCmainDto.getStartDate().getDate()
                         + "��"+(prpCmainDto.getStartHour()+"").substring(0,2)+"ʱ-"+ prpCmainDto.getEndDate().getYear()
                         + "��"+prpCmainDto.getEndDate().getMonth()
                         + "��"+prpCmainDto.getEndDate().getDate()
                         + "��"+(prpCmainDto.getEndHour()+"").substring(0,2)+"ʱ";

 strMakeCom = uiCodeAction.translateComCode(MakeCom,true);
  //�õ�������
  strPolicyNo = prpCmainDto.getPolicyNo();
  //�õ����ս�� 
  strSumAmount = ""+new DecimalFormat("#,##0.00").format(prpCmainDto.getSumAmount());
 
  //������Ϣ
  if(registDto.getPrpLregistDto()!=null)
  {
      strLossName                      = prpLregistDto.getLossName();//������
      intLossQuantity                  = (int)prpLregistDto.getLossQuantity();//����������      
      strReportorName                  = prpLregistDto.getReportorName();//������
	  strDamageAddress                 = prpLregistDto.getDamageAddress();//���յص�
	  strLinkerName                 = prpLregistDto.getLinkerName();//��ϵ��
	  strPhoneNumber                 = prpLregistDto.getPhoneNumber();//��ϵ�绰
  }
  //�����ձ����Ϣ
  if(policyDto.getPrpCmainCargoDto()!=null)
  {
    strStartSiteName     = prpCmainCargoDto.getStartSiteName();   //������ʼ��
    strViaSiteName       = prpCmainCargoDto.getViaSiteName();     //������ת��
    strEndSiteName       = prpCmainCargoDto.getEndSiteName();     //������ֹ��    
    strBLName            = prpCmainCargoDto.getBLName();          //���乤�� 
    strBLNo              = prpCmainCargoDto.getBLNo();            //�˾��ƺ�  
    strCarryBillNo       = prpCmainCargoDto.getCarryBillNo();     //�˵���
 
  
  }
  //������չ��Ϣ
  if(registDto.getPrpLextDto()!=null)
  {
    strSailStartDate     = prpLextDto.getSailStartDate().getYear()
                         + " �� "+prpLextDto.getSailStartDate().getMonth()
                         + " �� "+prpLextDto.getSailStartDate().getDate()
                         + " �� "; 
  }
  System.out.println("zhulianyu");  
%>

<script language="javascript"> 
  function loadForm()
  {      
    tdPolicyNo.innerHTML      = '<%=strPolicyNo%>';
    tdInsuredName.innerHTML   = '<%=StringConvert.encode(prpCmainDto.getInsuredName())%>';    
    //tdCarryBillNo.innerHTML   = '<%=strCarryBillNo%>';
    tdSumAmount.innerHTML     = '<%=strSumAmount%>';
    tdLinkerName.innerHTML     = '<%=strLinkerName%>';
    //tdBLName.innerHTML        = '<%=StringConvert.encode(strBLName)%>';
    //tdBLNo.innerHTML          = '<%=StringConvert.encode(strBLNo)%>';
    //tdEndSiteName.innerHTML   = '<%=StringConvert.encode(strEndSiteName)%>';
    //tdSailStartDate.innerHTML = '<%=strSailStartDate%>';
    tdLossName.innerHTML      = '<%=StringConvert.encode(strLossName)%>';
    //tdLossQuantity.innerHTML  = '<%=intLossQuantity%>';
    tdDate.innerHTML  = '<%=strDate%>';
    tdPhoneNumber.innerHTML  = '<%=strPhoneNumber%>'+' <%=prpCmainDto.getInsuredAddress()%>';

<%    
    strDamageStartDate = prpLregistDto.getDamageStartDate().getYear()
                        + " �� " +prpLregistDto.getDamageStartDate().getMonth()
                        + " �� " + prpLregistDto.getDamageStartDate().getDate()
                        + " ��";
    ReportDate = prpLregistDto.getReportDate().getYear()
                        + " �� " +prpLregistDto.getReportDate().getMonth()
                        + " �� " + prpLregistDto.getReportDate().getDate()
                        + " �� "+ (prpLregistDto.getReportHour()+"").substring(0,2)
                        + " ʱ ";
    String damangeAddressType = uiCodeAction.translateCodeCode("DamageAddress",prpLregistDto.getDamageAddressType(),true);
%>                    
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>';
    //tdDamageName.innerHTML      = '<%=StringConvert.encode(prpLregistDto.getDamageName())%>';    
    tdDamageAddress.innerHTML   = '<%=StringConvert.encode(prpLregistDto.getDamageAddress())%>';
    //tdDamageAddressType.innerHTML   = '<%=damangeAddressType%>';
    //tdIndemnityDuty.innerHTML     = '<%=strName%>';
    //tdInsuredDate.innerHTML = '<%=strInsuredDate%>';           
<%       
    //*****���������ϢPrpTitemKind*****
    dblSumAmount1 = 0;
    dblSumAmount2 = 0;

  if(policyDto.getPrpCitemKindDtoList()!=null){
    int tempindex = 0 ;  //������ʱ����
    //�õ�blPrpCitemKind����ļ�¼��
    intItemKindCount     = policyDto.getPrpCitemKindDtoList().size();     
    for(index=0;index<intItemKindCount;index++)
    {      
      prpItemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
      //add begin by zhuly 20051103 reason:����������Ϣ
      strRiskCode = prpItemKindDto.getRiskCode();
      strKindCode = prpItemKindDto.getKindCode();
      strKindName = prpItemKindDto.getKindName();  
      strKindAmount = ""+prpItemKindDto.getAmount();
      strFlag     = prpItemKindDto.getFlag();  
    }    
  }  

%>
    //tdSumAmount1.innerHTML = '<%=new DecimalFormat("#,##0.00").format(policyDto.getPrpCmainDto().getSumAmount())%>';
    //tdSumAmount2.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount2)%>';       
}  
</script>
  