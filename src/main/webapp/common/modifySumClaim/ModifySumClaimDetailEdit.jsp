<%--
****************************************************************************
* DESC       ：显示立案的险别估损金额页面
* AUTHOR     ：qinyongli
* CREATEDATE ：2005-09-20
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.util.*"%>
<%@page import="com.sinosoft.prpall.pubfun.PubTools"%>
<html>
<head>
  <title>立案详细信息</title>
  <%-- 公用函数 --%>
 
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/common/modifySumClaim/js/PropClaimEdit.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
</head>
<%
  String  editType=(String)request.getAttribute("editType");
  String policyInputDate =(String)request.getAttribute("policyInputDate");
  String  isShow=(String)request.getAttribute("isShow");
%>
<body class="interface" onload="initPage();">
<form name="fm" action="/claim/modifySumClaim.do"  method="post"  onsubmit="return validateForm(this);">
   <input type="hidden" name="editType" value="modifySave">
   <table  border="0" align="center" cellpadding="4" cellspacing="1"  class="title" style="width:100%">
       <tr>
	  <td colspan="4" class="formtitle">立案估损详细信息</td>
      </tr> 
      <tr>
        <td class="title" style="width:15%">立案号:</td>
        <td class="input" style="width:36%" >
           <input type=text name="prpLclaimClaimNo" title="立案号" maxlength="22" class="readonly" readonly="true"  value="<bean:write name='prpLclaimDto' property='claimNo' filter='true' />">
        </td>
        <td class="title">报案号:</td>
        <td class="input" colspan=3>
          <input type=text name="prpLclaimRegistNo" title="报案号" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLclaimDto' property='registNo' filter='true' />">
        </td>
      </tr>
      <tr>
        <td class="title" >保单号:</td>
        <td class="input" >
          <input type=text name="policyno" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />">
        </td>
        <td class="title">被保险人:</td>
        <td class="input" colspan='3' > 
            <bean:write name='prpLclaimDto' property='insuredName' filter='true' />
          </a>
        </td>
      </tr>
      <tr>
        <td class="title">保险期间</td>
        <td class="input" colspan='3'>
          <input type=text name="prpLclaimStartDate" title="起保日期" class="readonly" style="width:80px" readonly="true"  value="<bean:write name='prpLclaimDto' property='startDate' filter='true' />">零时起至
          <input type=text name="prpLclaimEndDate"   title="终保日期" class="readonly" style="width:80px" readonly="true"   value="<bean:write name='prpLclaimDto' property='endDate' filter='true' />">二十四时止
        </td>
      </tr>
      <tr>
        <td class="title">币别:</td>
        <td class="input">
          <input class="readonly" readonly name="prpLclaimCurrencyName" value="人民币">
          <input class="readonly" type=hidden name="prpLclaimCurrency" value="<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' />">
          <input class="readonly" type=hidden name="prpLclaimPolicyCurrency">
        </td>
        <td class="title">保险金额:</td>
        <td class="input">
          <input class="readonly" name="prpLclaimSumAmount" readonly="true" value="<bean:write name='prpLclaimDto' property='sumAmount' filter='true' format="##.00"/>">
          <input type="hidden" name="prpLclaimSumPremium" readonly="true" value="<bean:write name='prpLclaimDto' property='sumPremium' filter='true'  />">
        </td>
      </tr>
      <tr>
        <td class="title">事故时间:</td>
        <td class="input">
          <input type=text name="prpLclaimDamageStartDate" title="事故时间" class="readonly" readonly maxlength="10" style="width:80px" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' />">日
        </td>
        <td class="title">险别估损金额合计:</td>
        <td class="input">
          <input type=text name="prpLclaimSumClaim" title="估损金额" Class="readonly" readonly  value="<bean:write name='prpLclaimDto' property='sumClaim' filter='true' />">
        </td>
      </tr>
   </table>
      <%-- 险别估损金额信息 --%>
      <input  type="hidden" name="prpLclaimRiskCode" value="<bean:write name='prpLclaimDto' property='riskCode' filter='true' />"/>
      <%-- 再保危险单位里用到这个变量，所以注销掉 --%>
      <%--<input  type="hidden" name="prpLdangerRiskSumClaim" value="<bean:write name='prpLclaimDto' property='sumClaim' filter='true' />"/>--%>
      <input type="hidden" name="damageStartDate" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' />">
       <script src="/claim/common/modifySumClaim/js/PropClaimEdit.js"></script>
       <%@include file="/common/modifySumClaim/ClaimLossEdit.jsp"%>
       
		<%-- 7.指定危险单位信息 --%>
		<%
	    PubTools pubTools=new PubTools();
	    int time= pubTools.compareDate(policyInputDate,"2011-02-27");
	    if(time<0){
	    //用旧的危险单位信息页面
		%>
			<%@include file="/common/claim/ClaimRiskUnit.jsp"%>
		<%
	    }else{
	    //用新的危险单位信息页面
		%>
			<%@include file="/common/claim/ClaimNewRiskUnit.jsp"%>
		<%}%>
     <table  id="buttonArea" cellpadding="0" cellspacing="0" width="80%" style="display:">
       <tr>
        <td align="center">
           <br><br>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="button" name=buttonSaveFinishSubmit class='button' value='保存' onclick="submitform();">
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="button" name=buttonBack class='button' value='返回' onclick="back();">
          <script language="javascript">
                function back(){
                    fm.action = "/claim/modifySumClaim.do?editType=modifyBeforeQuery";
                    fm.submit();
                }
                
				function submitform(){
					//reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
					if(!validateForm(fm,'ClaimLoss_Data')){
						return false;
					}
					//alert("ok1");
					if(!checkLoss()){
						return false;
					}
					if(fm.DangerUnitCheckSaveFlag.value=='2'){ 
						if ( DangerUnitCheck()==false){
							return false;
						}
					}else if(fm.DangerUnitCheckSaveFlag.value=='1'){
						var reinsMoney=0;
						var reinsClaimMoney=0;
						var prpLdangerRiskSumClaim=round(parseFloat(fm.prpLdangerRiskSumClaim.value),2);
						for( var n=1;n<fm.prpLclaimLossSumClaim.length;n++){
							if(fm.ClaimLossFlag[n].value=="I"){
								reinsClaimMoney =parseFloat(fm.prpLclaimLossSumClaim[n].value);
								reinsMoney = reinsMoney + reinsClaimMoney;
							}
						}
						if(prpLdangerRiskSumClaim!=round(reinsMoney,2)){
							alert("新增的预估金额不等于危险单位页面下估损金额合计！");
					        return false;
						}
					}
                    for( var j=1;j<fm.prpLclaimLossCurrency.length;j++)
                   	{
                   	  fm.prpLclaimLossFlag[j].disabled = false;
                   	}
                   	// 保存时增加50万提示框,点击确认后方可保存,否则停留在页面
                   	if(confirm(sumLossAmountInform() + "\n确认继续保存吗？")) {
                   	     fm.submit();
                   	} 
                }
                
                function checkLoss()
             {
             	
               for( var j=1;j<fm.prpLclaimLossCurrency.length;j++)
              	{
             		if (isEmptyField(fm.prpLclaimLossCurrency[j]))
             		{
             			errorMessage("第"+ j+"条估损金额中币别不能为空!");
             			fm.prpLclaimLossCurrency[j].focus();
             			return false;
             		}
             
             		if(isEmptyField(fm.prpLclaimLossKindCode[j]))
             		{
             			errorMessage("第"+j+"条估损金额中险别代码不能为空!");
             			//fm.prpLclaimLossKindCode[j].focus();
             			return false;
             		}
             
             		if(isEmptyField(fm.prpLclaimLossSumClaim[j]))
		           {
		           	errorMessage("第"+j+"条估损金额中金额不能为空!");
		           	fm.prpLclaimLossSumClaim[j].focus();
		           	return false;
		           }
 	          }
 	
 
	             return true;
          }
                
          </script>
        </td>      
       </tr>
     </table>
</form>
</body>
</html>