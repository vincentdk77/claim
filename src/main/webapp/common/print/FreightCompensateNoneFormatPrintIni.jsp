<%--
****************************************************************************
* DESC       �����������������ӡҳ���ʼ��
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
<%@page import="com.sinosoft.claim.bl.facade.*"%>
<%@page import="com.sinosoft.claim.util.*"%>
<%@page import="com.sinosoft.sysframework.common.util.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%>
<%@page import="com.sinosoft.function.insutil.bl.facade.BLPubRateFacade"%>
<%@page import="com.sinosoft.utiall.dbsvr.DBPrpDcode"%>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDuser"%>

<%
  //������������
  String strCompensateNo      = request.getParameter("CompensateNo"); //���������
  String strRiskName          = ""; //��������
  String strClaimNo           = "";   //������
  String strPolicyNo          = "";   //������
  String strClassCode         = "";   //����
  double dblSumAmount1       = 0;    //���ս��
  String strKindCode          = "";   //�ձ����
  String strKindName          = "";   //�ձ�����
  String strInvoiceNo         = "";   //��Ʊ��
  String strCount             = "";   //��Ʒ������
  String strItemDetial        = "";   //��Ʒ
  String strQuantity          = "";   //����
  String strConveyance        = "";   //���乤��
  String strAgenName          = "";   //���������
  String strTPath             = "";   //����·��
  DateTime dateDamageStartDate = null;   //��������
  String strDamageStartDate   = "";   //��������
  String strCause             = "";   //����ԭ��
  String strAddress           = "";   //���յص�
  String strCountExp          = "";   //�����㹫ʽ
  String strStartDate         = "";   ///�𱣣����ˣ�����-��ʽ��ʾ

  //���˶�
  double dblClaim            = 0;    //���˶�
  double dblHelp             = 0.0d; //ʩ�ȷ���
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
  PrpCitemCarDto    prpItemcarDto     = null;   //ItemcarDto����
  PrpCitemKindDto    prpItemKindDto     = null;   //������ItemKindDto����
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����

  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto����
  PrpLchargeDto      prpLchargeDto      = null;   //ChargeDto����
  PrpLctextDto       prpLctextDto       = null;
  PrpLlossDto        prpLlossDto        = null;

  int intCompensateCount = 0;   //CompensateDto����ļ�¼��
  int intItemCarCount    = 0;   //ItemcarDto����ļ�¼��
  int intItemKindCount   = 0;   //ItemKindDto����ļ�¼��
  int intThirdPartyCount = 0;   //ThirdPartyDto����ļ�¼��
  int intChargeCount     = 0;   //ChargeDto����ļ�¼��
  int intCtextCount      = 0;   //CtextDto����ļ�¼��
  int intCtextCountTmp   = 0;   //textarea����
  int intLossCount       = 0;   //LossDto����ļ�¼��
  int index = 0;
  DateTime dataTime = new DateTime();
  DateTime exchDate = new DateTime(dataTime.current(),DateTime.YEAR_TO_DAY);
  BLPubRateFacade blPubRateFacade = new BLPubRateFacade();
  double douExchangeRate = 0d;
  double douSumRealPay = 0.0;
  String strCurrency4 ="";
  String strCurrency4Show ="";
  double douSumRealPayShow =0.0;
  double douSumRealPayCNY = 0.0;
  double douSumPay = 0.0;

  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto����
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  CheckDto checkDto = (CheckDto)request.getAttribute("checkDto");
  CompensateDto compensateDto = (CompensateDto)request.getAttribute("compensateDto");
  CertainLossDto certainLossDto = (CertainLossDto)request.getAttribute("certainLossDto");

  UICodeAction uiCodeAction = new UICodeAction();
  //�õ�prpLcompensateDto ����
  prpLcompensateDto   = compensateDto.getPrpLcompensateDto();

  //�õ�prpLclaimDto����
  prpLclaimDto   = claimDto.getPrpLclaimDto();

  strClaimNo = prpLclaimDto.getClaimNo();
  String strApproverCode   = prpLcompensateDto.getApproverCode();   //����Ա����
  String strOperatorCode   = prpLcompensateDto.getOperatorCode();   //����Ա����
  String strApproverName   = uiCodeAction.translateUserCode(strApproverCode,isChinese);
  String strOperatorName   = uiCodeAction.translateUserCode(strOperatorCode,isChinese);

  //add by zhulei 20050930 ������Ա��Ϣ
  String strOperator          = "";     //������
  Date   strInputDate         = null;   //��������
  String strUnderWriteName    = "";     //������
  Date   strUnderWriteEndDate = null;   //��������
  String strChecker = "";               //�鿱��
  Date   dateCheckDate = null;          //�鿱����
  String strCheckDateYear  = "   ";
  String strCheckDateMonth = "   ";
  String strCheckDateDate  = "   ";
  if(prpLcompensateDto!=null){
    strOperator          = prpLcompensateDto.getOperatorCode();
    BLPrpDuser blPrpDuser = new BLPrpDuser();
    blPrpDuser.query("UserCode='"+strOperator+"'");
    strOperator = blPrpDuser.getArr(0).getUserName();
    strInputDate         = prpLcompensateDto.getInputDate();
    strUnderWriteName    = prpLcompensateDto.getUnderWriteName();
    strUnderWriteEndDate = prpLcompensateDto.getUnderWriteEndDate();
  }
  PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
  BLPrpLcheckFacade blPrpLcheckFacade = new BLPrpLcheckFacade();
  prpLcheckDto = blPrpLcheckFacade.findByPrimaryKey(prpLclaimDto.getRegistNo(),1);
  if(prpLcheckDto!=null){
    strChecker = prpLcheckDto.getChecker1();
    dateCheckDate = prpLcheckDto.getCheckDate();
    //strCheckDateYear  = dateCheckDate.getYear();
    //strCheckDateMonth = dateCheckDate.getMonth();
    //strCheckDateDate  = dateCheckDate.getDate();
  }

  //�õ�������
  strPolicyNo = prpLclaimDto.getPolicyNo();
  strClassCode = prpLclaimDto.getClassCode();
  strRiskName = uiCodeAction.translateRiskCode(prpLclaimDto.getRiskCode(),true);

  //�õ�blPrpCitemCar����
  if(policyDto.getPrpCitemCarDtoList()!=null){
    intItemCarCount     = policyDto.getPrpCitemCarDtoList().size();
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
  if(compensateDto.getPrpLlossDtoList()!=null){
    intLossCount     = compensateDto.getPrpLlossDtoList().size();
  }
  String strSumPaid =  new DecimalFormat("#,##0.00").format(prpLcompensateDto.getSumPaid());
  double dbSumPaid = prpLcompensateDto.getSumPaid();
  //add by zhulei 20050913 ���ϼ�����Ҽ���
  String strCurrency1 = prpLcompensateDto.getCurrency();
  String strSumPaidCNY = "";
  if(strCurrency1.equals("CNY")){
    strSumPaidCNY = strSumPaid;
  }else{
    douExchangeRate = blPubRateFacade.getExchangeRate(strCurrency1,"CNY",exchDate);
    strSumPaidCNY = new DecimalFormat("#,##0.00").format(douExchangeRate * dbSumPaid);
  }
  //modify by zhulei 20050921 ����ɴ�дʱ��0�Ĵ���
  String strCSumPaid = "��Բ";
  if(prpLcompensateDto.getSumPaid()!=0){
    strCSumPaid = MoneyUtils.toChinese(prpLcompensateDto.getSumPaid(),prpLcompensateDto.getCurrency());
  }
  String strSumPrePaid =  new DecimalFormat("#,##0.00").format(prpLcompensateDto.getSumPrePaid());
  String strCSumPrePaid = "��Բ";
  if(prpLcompensateDto.getSumPrePaid()!=0){
    strCSumPrePaid = MoneyUtils.toChinese(prpLcompensateDto.getSumPrePaid(),prpLcompensateDto.getCurrency());
  }
  String strSumThisPaid = new DecimalFormat("#,##0.00").format(prpLcompensateDto.getSumThisPaid());
  String strCSumThisPaid = "��Բ";
  if(prpLcompensateDto.getSumThisPaid()!=0){
    strCSumThisPaid = MoneyUtils.toChinese(prpLcompensateDto.getSumThisPaid(),prpLcompensateDto.getCurrency());
  }
  //�𱣣����ˣ�����
  DateTime StartDate    = policyDto.getPrpCmainDto().getStartDate();
  strStartDate = StartDate.getYear() + "��" + StartDate.getMonth() + "��" + StartDate.getDate() + "��";
  //add by zhulei 20050921 ��������
  dateDamageStartDate = prpLclaimDto.getDamageStartDate();
  strDamageStartDate = dateDamageStartDate.getYear()+"��"+dateDamageStartDate.getMonth()+"��"+dateDamageStartDate.getDate()+"��";
  //add by zhulei 20050920 ��������
 String strInsuredDateTime = ""; //������������
 DateTime dateInsuredStartDate = null;
 DateTime dateInsuredEndDate = null;
 dateInsuredStartDate = policyDto.getPrpCmainDto().getStartDate();
 dateInsuredEndDate = policyDto.getPrpCmainDto().getEndDate();
 strInsuredDateTime = dateInsuredStartDate.getYear()+"��"+dateInsuredStartDate.getMonth()+"��"+dateInsuredStartDate.getDate()+"��--"
                     +dateInsuredEndDate.getYear()+"��"+dateInsuredEndDate.getMonth()+"��"+dateInsuredEndDate.getDate()+"��" ;

%>

<script language="javascript">
  function loadForm()
  {
    tdClaimNo.innerHTML  =  '<%=strClaimNo%>';

    //*****���������PrpLcompensate*****
    tdCompensateNo.innerHTML  = '��������ţ�' + '<%=strCompensateNo%>';

    //*****������Ϣ��PrpLclaim*****
    tdPolicyNo.innerHTML     = '<%=strPolicyNo%>';
    tdInsuredName.innerHTML  = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
    tdSumAmount.innerHTML = '<%=prpLclaimDto.getCurrency()%><%= new DecimalFormat("#,##0.00").format(prpLclaimDto.getSumAmount())%>';
    tdDamageTypeName.innerHTML = '<%= prpLclaimDto.getDamageName()%>';
    tdDamageAddress.innerHTML = '<%= prpLclaimDto.getDamageAddress()%>';

    tdCheckAgentName.innerHTML = '<%= prpLcompensateDto.getCheckAgentName()%>';
    // modify by zhulei 20050913 ���ϼ�
<%
  if(strClassCode.equals("09") || strClassCode.equals("10")){
%>
    tdSumPaid.innerHTML = '<%=strCurrency1%><%=strSumPaid%>';
<%
  }else{
%>
    tdSumPaid.innerHTML = '<%=strSumPaid%>';
<%}%>
    tdSumPaidCNY.innerHTML = '<%=strSumPaidCNY%>';
<%
  if(strClassCode.equals("09") || strClassCode.equals("10")){
%>
    tdCSumPaid.innerHTML = '<%=strCSumPaid%>(<%=strSumPaid%>)';
<%
  }else{
%>
    tdCSumPaid.innerHTML = '<%=strCSumPaid%>';
<%}%>
    tdSumPrePaid.innerHTML = '<%=strCSumPrePaid%>(<%= strSumPrePaid%>)';
    tdSumThisPaid.innerHTML = '<%=strCSumThisPaid %>(<%= strSumThisPaid%>)';
  <%
    for(index=0;index<intLossCount;index++){
      prpLlossDto = (PrpLlossDto)compensateDto.getPrpLlossDtoList().get(index);
      double douDeductibleRate = prpLlossDto.getDeductibleRate();
      double douDeductible = prpLlossDto.getDeductible();

      douSumRealPay = prpLlossDto.getSumRealPay();
      strCurrency4 = prpLlossDto.getCurrency4();

      if(index==0)
      {
      	strCurrency4Show = strCurrency4;
      	douSumRealPayShow+=douSumRealPay;
      }
      else if(strCurrency4Show.equals(strCurrency4))
      {
      	douSumRealPayShow+=prpLlossDto.getSumRealPay();
      }
      else
      {
      	strCurrency4Show = "";
      }
      //add by zhulei 20050928

      if(strCurrency4.equals("CNY"))
      {
      	douSumRealPayCNY+=douSumRealPay;
      }
      else
      {
      	douExchangeRate = blPubRateFacade.getExchangeRate(strCurrency4,"CNY",exchDate);
        douSumRealPayCNY += douSumRealPay*douExchangeRate;
      }
    }

    String strSumRealPayShow = "";            //�ϼƽ���ʽ��ʾ
    strSumRealPayShow = new DecimalFormat("#,##0.00").format(douSumRealPayShow);

    if(!strCurrency4Show.equals("")){
      if(strClassCode.equals("09") || strClassCode.equals("10")){
  %>
    tdSumRealpay.innerHTML = '<%=strCurrency4Show%><%=strSumRealPayShow%>';
  <%
      }else{
%>
    tdSumRealpay.innerHTML = '<%=strSumRealPayShow%>';
<%
      }
    }
      if(strClassCode.equals("09") || strClassCode.equals("10")){
  %>
    tdCurrency4.innerHTML = '<%=douSumRealPayCNY%>';
  <%
      }else{
%>
    tdCurrency4.innerHTML = '<%=strCurrency4Show%>';
<%
      }

    blPubRateFacade = new BLPubRateFacade();
    douExchangeRate = 0d;
    double douChargeAmountCNY = 0d;
    for(index=0;index<intChargeCount;index++){
      prpLchargeDto = (PrpLchargeDto)compensateDto.getPrpLchargeDtoList().get(index);
      String strChargeName = prpLchargeDto.getChargeName();
      String strCurrency = prpLchargeDto.getCurrency();
      double douChargeAmount = prpLchargeDto.getSumRealPay();
      String strChargeAmount = new DecimalFormat("###0.00").format(douChargeAmount);
      if(strCurrency.equals("CNY")){
        douChargeAmountCNY = douChargeAmount;
      }else{
        douExchangeRate = blPubRateFacade.getExchangeRate(strCurrency,"CNY",exchDate);
        douChargeAmountCNY = douChargeAmount*douExchangeRate;
      }
      System.out.println("=====================strChargeName="+strChargeName+"-");
      System.out.println("=====================douChargeAmount="+douChargeAmount+"-");
      if(strChargeName.equals("��ͬ����")){
        if(strClassCode.equals("09") || strClassCode.equals("10")){
  %>
    tdChargeAmount1.innerHTML = '<%=strCurrency%><%=strChargeAmount%>';
    tdChargeAmountCNY1.innerHTML = '<%=douChargeAmountCNY%>';
  <%
        }else{
%>
    tdChargeAmount1.innerHTML = '<%=strChargeAmount%>';
    tdChargeAmountCNY1.innerHTML = '<%=strCurrency%>';
<%
         }
      }
      if(strChargeName.equals("ʩ�ȷ�")){
        if(strClassCode.equals("09") || strClassCode.equals("10")){
  %>
    tdChargeAmount2.innerHTML = '<%=strCurrency%><%=strChargeAmount%>';
    tdChargeAmountCNY2.innerHTML = '<%=douChargeAmountCNY%>';
  <%
        }//if(�����������ʾ��ͬ)
      }
      if(strChargeName.equals("�����")){
        if(strClassCode.equals("09") || strClassCode.equals("10")){
  %>
    tdChargeAmount3.innerHTML = '<%=strCurrency%><%=strChargeAmount%>';
    tdChargeAmountCNY3.innerHTML = '<%=douChargeAmountCNY%>';
  <%
        }else{
%>
    tdChargeAmount3.innerHTML = '<%=strChargeAmount%>';
    tdChargeAmountCNY3.innerHTML = '<%=strCurrency%>';
<%
        }
      }
      if(strChargeName.equals("�����")){
        if(strClassCode.equals("09") || strClassCode.equals("10")){
  %>
    tdChargeAmount4.innerHTML = '<%=strCurrency%><%=strChargeAmount%>';
    tdChargeAmountCNY4.innerHTML = '<%=douChargeAmountCNY%>';
  <%
        }else{
%>
    tdChargeAmount4.innerHTML = '<%=strChargeAmount%>';
    tdChargeAmountCNY4.innerHTML = '<%=strCurrency%>';
<%
        }
      }
      if(strChargeName.equals("�鿱��")){
        if(strClassCode.equals("09") || strClassCode.equals("10")){
  %>
    tdChargeAmount5.innerHTML = '<%=strCurrency%><%=strChargeAmount%>';
    tdChargeAmountCNY5.innerHTML = '<%=douChargeAmountCNY%>';
  <%
        }else{
%>
    tdChargeAmount5.innerHTML = '<%=strChargeAmount%>';
    tdChargeAmountCNY5.innerHTML = '<%=strCurrency%>';
<%
        }
      }
      if(strChargeName.equals("����")){
        if(strClassCode.equals("09") || strClassCode.equals("10")){
  %>
    tdChargeAmount6.innerHTML = '<%=strCurrency%><%=strChargeAmount%>';
    tdChargeAmountCNY6.innerHTML = '<%=douChargeAmountCNY%>';
  <%
        }else{
%>
    tdChargeAmount6.innerHTML = '<%=strChargeAmount%>';
    tdChargeAmountCNY6.innerHTML = '<%=strCurrency%>';
<%
        }
      }
    }
  %>
  <%
    for(index=0;index<intItemKindCount;index++){
      prpItemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
      if(prpItemKindDto.getFlag().substring(1,2).equals("1")){
        strKindName=strKindName+prpItemKindDto.getKindName()+"<br>";
      }
      //add by zhulei begin 20050913 ��Ʒ����ģ����������������ظ���ʾ
      //zhulei leave:���¹��˷���ֻ�ܹ��˵�������ͬ����ģ����ڲ������Ļ���Ҫѭ���жϣ����ﻹ��Ҫ�޸�
      if(!prpItemKindDto.getItemDetailName().equals(strItemDetial)){
        if(strClassCode.equals("09") || strClassCode.equals("10")){
          strCount += prpItemKindDto.getItemDetailName() + new DecimalFormat("###0").format(prpItemKindDto.getQuantity()) + prpItemKindDto.getModel() + "<br>";
        }else{
          strCount += prpItemKindDto.getItemDetailName() + "  ";
        }
        strItemDetial = prpItemKindDto.getItemDetailName();
      }
      //add by zhulei end 20050913 ��Ʒ����ģ�������
    }
    //add by zhulei begin 20050913 ���䷽ʽ����
    if(strClassCode.equals("09") || strClassCode.equals("10")){
      DBPrpDcode dbPrpDcode = new DBPrpDcode();
      dbPrpDcode.getInfo("ConveyanceType",policyDto.getPrpCmainCargoDto().getConveyance());
      strConveyance = dbPrpDcode.getCodeCName();
    }
    //add by zhulei end 20050913 ���䷽ʽ����
  %>
    tdCount.innerHTML = '<%=strCount%>';
    //fm.itemCount.value = <%=strCount%>
    tdKindName.innerHTML = '<%=strKindName%>';
    tdConveyance.innerHTML = '<%=strConveyance%>';
  <%
      System.out.println(".............test.....test......test22......");
    //System.out.println(policyDto.getPrpCmainCargoDto().getInvoiceNo());
    //add by zhulei 20050929 ���乤�ߣ����κ����
    String strBLNo = "";            //���š������
    if(strClassCode.equals("09") || strClassCode.equals("10")){
      strBLNo = policyDto.getPrpCmainCargoDto().getBLNo();
      String strViaSiteName = policyDto.getPrpCmainCargoDto().getViaSiteName();
      if(strViaSiteName.equals("")) {
  %>
    tdLindline.innerHTML = '�� <%=policyDto.getPrpCmainCargoDto().getStartSiteName()%> �� <%=policyDto.getPrpCmainCargoDto().getEndSiteName()%>';
  <%
      }else{
  %>
    tdLindline.innerHTML = '�� <%=policyDto.getPrpCmainCargoDto().getStartSiteName()%> �� <%=policyDto.getPrpCmainCargoDto().getViaSiteName()%> �� <%=policyDto.getPrpCmainCargoDto().getEndSiteName()%>';
  <%
      }
    }
    String strContext ="";
    String strContext2 ="";
    for(index=0;index<intCtextCount;index++){
      prpLctextDto = (PrpLctextDto)compensateDto.getPrpLctextDtoDtoList().get(index);
      if(prpLctextDto.getTextType().equals("1")){
        strContext += prpLctextDto.getContext();
      }else{
      	strContext2+= prpLctextDto.getContext();
      }
    }
    System.out.println(strContext);

    //add by zhulei 20050921 ж������
    String strUnloadDate = "";         //ж������
    if(strClassCode.equals("09") || strClassCode.equals("10")){
      PrpLextDto prpLextDto = new PrpLextDto();
      UICheckAction uiCheckAction = new UICheckAction();
      checkDto = uiCheckAction.findByPrimaryKey(claimDto.getPrpLclaimDto().getRegistNo());
      prpLextDto = checkDto.getPrpLextDto();
      if(prpLextDto!=null){
      System.out.println(".............prpLextDto.getUnloadDate()=========="+prpLextDto.getUnloadDate()+"--");
        if(prpLextDto.getUnloadDate()!=null && !prpLextDto.getUnloadDate().toString().equals("")){
          strUnloadDate = prpLextDto.getUnloadDate().getYear() + "��" + prpLextDto.getUnloadDate().getMonth() + "��" + prpLextDto.getUnloadDate().getDate() + "��";
        }
      }
    }
  %>
    //tdContext.innerHTML = '<>';
 }
</script>
  