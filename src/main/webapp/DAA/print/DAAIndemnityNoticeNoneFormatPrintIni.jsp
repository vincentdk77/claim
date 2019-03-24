<%--
****************************************************************************
* DESC       ：机动车辆保险赔款通知书打印页面初始化
* AUTHOR     ：caopeng
* CREATEDATE ：2005-12-09
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>

<%-- 引入bean类部分 --%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 

<%
  //变量声明部分
  String strCompensateNo         = request.getParameter("CompensateNo"); //赔款计算书号
  String strClaimNo              = "";   //立案号
  String strRegistNo             = "";   //报案号
  String strPolicyNo             = "";   //保单号
  String strSumPaid              = "";   //
  String strCSumPaid             = "";   //
  double dblSumPaid              = 0;    //
  String strChargeCode           = "";
  String strInsuredName          = "";    //被保险人
  String strYear                 = "";    
  String strMonth                = "";
  String strDate                 = "";
  String strComCode              = "";   //业务归属机构代码 
  String strComCName             = "";   //业务归属机构中文名称
  String strBank                 = "";   //开户银行名称
  String strAccount              = "";   //开户银行帐号
  String strReceiverName         = "";   //开会银行帐号名称
  String riskName                = "";   //险种名称
  String handlerName             = "";   //经办人
  String underWriteName          = "";   //核配人
  String currency                = "";   //币别
  String currencyTag             = "";   //币别符号
  //代码翻译变量
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //中文标志
  
  //对象定义部分
                                              

  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto对象
  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto对象
  PrpCmainDto    prpMainDto             = null;   //CMainDto对象

  
  int index = 0;
  
  //得到ClaimDto,RegistDto,CertainLossDto,PolicyDto对象
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  CompensateDto compensateDto = (CompensateDto)request.getAttribute("compensateDto"); 
  strBank = compensateDto.getPrpLcompensateDto().getBank();
  strAccount = compensateDto.getPrpLcompensateDto().getAccount();
  strReceiverName = compensateDto.getPrpLcompensateDto().getReceiverName();
  
  UICodeAction uiCodeAction = new UICodeAction();
  riskName = uiCodeAction.translateRiskCode(compensateDto.getPrpLcompensateDto().getRiskCode(),true);
  //得到prpLcompensateDto 对象
  prpLcompensateDto   = compensateDto.getPrpLcompensateDto();
  handlerName = uiCodeAction.translateUserCode(prpLcompensateDto.getHandlerCode(),true);
  underWriteName = prpLcompensateDto.getUnderWriteName();
  currency = uiCodeAction.translateCurrencyCode(prpLcompensateDto.getCurrency(),true);
  if("人民币".equals(currency)){
	  currencyTag = "￥";
  }else if("美元".equals(currency)){
	  currencyTag = "＄";
  }
  //得到prpLclaimDto对象
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
  //得到保单号
  strPolicyNo = prpLclaimDto.getPolicyNo();

    strInsuredName  = StringConvert.encode(prpLclaimDto.getInsuredName());
    if(prpLcompensateDto != null){
       dblSumPaid      = prpLcompensateDto.getSumDutyPaid();
       strClaimNo      = prpLcompensateDto.getClaimNo();
    }             
    strSumPaid      = new DecimalFormat("#,##0.00").format(dblSumPaid);    
    if(dblSumPaid < 0){
    	strCSumPaid     = "负" + MoneyUtils.toChinese(dblSumPaid * -1,prpLcompensateDto.getCurrency());   
    }
    else{
    	strCSumPaid     = MoneyUtils.toChinese(dblSumPaid,prpLcompensateDto.getCurrency()); 
    }
%> 
<script type="text/javascript">
    function loadForm(){
        //被保险人
        
        var InsuredNameLength = parseInt('<%=strInsuredName.length()%>');
        if(InsuredNameLength < 26){
            document.getElementById("spInsuredName").innerHTML = "&nbsp;" + "<%=strInsuredName %>" + getStringSpace((26 - InsuredNameLength)*1.5);  
        }else{
            document.getElementById("spInsuredName").innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "<%=strInsuredName %>" + getStringSpace((52 - InsuredNameLength)*1.2);             
        }
        //险种名称
        var  riskNameLength = parseInt('<%=riskName.length()%>');
        if(riskNameLength < 9 || riskNameLength == 9){
            document.getElementById("spRiskName").innerHTML ="&nbsp;&nbsp;" + "<%=riskName%>" + getStringSpace(10 - riskNameLength);
            //document.getElementById("spBr").innerHTML = '<br>';
        }else{
           // document.getElementById("spBr").innerHTML = '<br>';
           document.getElementById("spRiskName").innerHTML ="&nbsp;&nbsp;" + "<%=riskName%>" + getStringSpace((21-riskNameLength)*1.5);
        }        
        //赔案金额
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
        //银行信息
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


  