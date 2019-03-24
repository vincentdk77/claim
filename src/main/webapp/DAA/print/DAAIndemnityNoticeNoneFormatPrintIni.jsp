<%--
****************************************************************************
* DESC       �����������������֪ͨ���ӡҳ���ʼ��
* AUTHOR     ��caopeng
* CREATEDATE ��2005-12-09
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
  String strCompensateNo         = request.getParameter("CompensateNo"); //���������
  String strClaimNo              = "";   //������
  String strRegistNo             = "";   //������
  String strPolicyNo             = "";   //������
  String strSumPaid              = "";   //
  String strCSumPaid             = "";   //
  double dblSumPaid              = 0;    //
  String strChargeCode           = "";
  String strInsuredName          = "";    //��������
  String strYear                 = "";    
  String strMonth                = "";
  String strDate                 = "";
  String strComCode              = "";   //ҵ������������� 
  String strComCName             = "";   //ҵ�����������������
  String strBank                 = "";   //������������
  String strAccount              = "";   //���������ʺ�
  String strReceiverName         = "";   //���������ʺ�����
  String riskName                = "";   //��������
  String handlerName             = "";   //������
  String underWriteName          = "";   //������
  String currency                = "";   //�ұ�
  String currencyTag             = "";   //�ұ����
  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
  
  //�����岿��
                                              

  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto����
  PrpCmainDto    prpMainDto             = null;   //CMainDto����

  
  int index = 0;
  
  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto����
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  CompensateDto compensateDto = (CompensateDto)request.getAttribute("compensateDto"); 
  strBank = compensateDto.getPrpLcompensateDto().getBank();
  strAccount = compensateDto.getPrpLcompensateDto().getAccount();
  strReceiverName = compensateDto.getPrpLcompensateDto().getReceiverName();
  
  UICodeAction uiCodeAction = new UICodeAction();
  riskName = uiCodeAction.translateRiskCode(compensateDto.getPrpLcompensateDto().getRiskCode(),true);
  //�õ�prpLcompensateDto ����
  prpLcompensateDto   = compensateDto.getPrpLcompensateDto();
  handlerName = uiCodeAction.translateUserCode(prpLcompensateDto.getHandlerCode(),true);
  underWriteName = prpLcompensateDto.getUnderWriteName();
  currency = uiCodeAction.translateCurrencyCode(prpLcompensateDto.getCurrency(),true);
  if("�����".equals(currency)){
	  currencyTag = "��";
  }else if("��Ԫ".equals(currency)){
	  currencyTag = "��";
  }
  //�õ�prpLclaimDto����
  prpLclaimDto   = claimDto.getPrpLclaimDto();
  if(policyDto!=null){
	  prpMainDto =  policyDto.getPrpCmainDto();
	  if(prpMainDto!=null){
		  strComCode       = StringConvert.encode(prpMainDto.getComCode());
		  UICompanyAction uiCompanyAction = new UICompanyAction();
		  PrpDcompanyDto prpDcompanyDto = uiCompanyAction.findByPrimaryKey(strComCode); 
		  if(prpDcompanyDto!=null)
		  strComCName      = prpDcompanyDto.getComCName();
	  }
  }
 
  java.util.Date date = new java.util.Date();
  strYear = String.valueOf(date.getYear()+1900);
  strMonth = String.valueOf(date.getMonth()+1);
  strDate = String.valueOf(date.getDate());
  //�õ�������
  strPolicyNo = prpLclaimDto.getPolicyNo();

    strInsuredName  = StringConvert.encode(prpLclaimDto.getInsuredName());
    if(prpLcompensateDto != null){
       dblSumPaid      = prpLcompensateDto.getSumDutyPaid();
       strClaimNo      = prpLcompensateDto.getClaimNo();
    }             
    strSumPaid      = new DecimalFormat("#,##0.00").format(dblSumPaid);    
    if(dblSumPaid < 0){
    	strCSumPaid     = "��" + MoneyUtils.toChinese(dblSumPaid * -1,prpLcompensateDto.getCurrency());   
    }
    else{
    	strCSumPaid     = MoneyUtils.toChinese(dblSumPaid,prpLcompensateDto.getCurrency()); 
    }
%> 
<script type="text/javascript">
    function loadForm(){
        //��������
        
        var InsuredNameLength = parseInt('<%=strInsuredName.length()%>');
        if(InsuredNameLength < 26){
            document.getElementById("spInsuredName").innerHTML = "&nbsp;" + "<%=strInsuredName %>" + getStringSpace((26 - InsuredNameLength)*1.5);  
        }else{
            document.getElementById("spInsuredName").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "<%=strInsuredName %>" + getStringSpace((52 - InsuredNameLength)*1.2);             
        }
        //��������
        var  riskNameLength = parseInt('<%=riskName.length()%>');
        if(riskNameLength < 9 || riskNameLength == 9){
            document.getElementById("spRiskName").innerHTML ="&nbsp;&nbsp;" + "<%=riskName%>" + getStringSpace(10 - riskNameLength);
            //document.getElementById("spBr").innerHTML = '<br>';
        }else{
           // document.getElementById("spBr").innerHTML = '<br>';
           document.getElementById("spRiskName").innerHTML ="&nbsp;&nbsp;" + "<%=riskName%>" + getStringSpace((21-riskNameLength)*1.5);
        }        
        //�ⰸ���
        var CSumPaidLength = parseInt('<%=strCSumPaid.length()%>');
        if(CSumPaidLength < 22 || CSumPaidLength == 22){
            document.getElementById("spCSumPaid").innerHTML = "<%=currency%>" + "<%=strCSumPaid%>" + getStringSpace(23 - CSumPaidLength);
        }else {
            document.getElementById("spCSumPaid").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;" +"<%=currency%>" + "<%=strCSumPaid%>" + getStringSpace(50 - CSumPaidLength);
        }
        var SumPaidLength = parseInt('<%=strSumPaid.length()%>');
        if(SumPaidLength < 22 || SumPaidLength == 22){
            document.getElementById("spSumPaid").innerHTML = "<%=currencyTag%>" + "<%=strSumPaid%>" + getStringSpace(28 - SumPaidLength);
        }else {
            document.getElementById("spSumPaid").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;" + "<%=currencyTag%>" +"<%=strSumPaid%>" + getStringSpace(50 - SumPaidLength);
        }
        //������Ϣ
        var BankLength = parseInt('<%=strBank.length()%>');
        if(BankLength < 24 || BankLength == 24){
            document.getElementById("spBank").innerHTML = "&nbsp;&nbsp;" + "<%=strBank%>" ;
        }else {
            document.getElementById("spBank").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;" + "<%=strBank%>" ;
        }
        var ReceiverNameLength = parseInt('<%=strReceiverName.length()%>');
        if(ReceiverNameLength < 24 || ReceiverNameLength == 24){
            document.getElementById("spReceiverName").innerHTML = "&nbsp;&nbsp;" + "<%=strReceiverName%>" ;
        }else {
            document.getElementById("spReceiverName").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;" + "<%=strReceiverName%>" ;
        }
        var AccountLength = parseInt('<%=strAccount.length()%>');
        if(AccountLength < 24 || AccountLength == 24){
            document.getElementById("spAccount").innerHTML = "&nbsp;&nbsp;" + "<%=strAccount%>" ;
        }else {
            document.getElementById("spAccount").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;" + "<%=strAccount%>" + getStringSpace(50 - AccountLength);
        }
        
    }
    function getStringSpace(count){
        var str = "";
        if(isNaN(count))
            count = 0 ;
        else count = parseInt(count);
        for(var i = 0;i < count;i++){
            str = str + "&nbsp;"
        }
        return str;
    }
</script>


  