<%@ page language="java" import="java.util.*" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.DateTime" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String doQuery = request.getParameter("doQuery");

String pageConditions = request.getParameter("pageConditions");
String shuldQuery = request.getParameter("shuldQuery");
String prevPageUrl = (String)request.getAttribute("prevPageUrl");
if(prevPageUrl==null||"".equals(prevPageUrl)){
	prevPageUrl = request.getParameter("prevPageUrl");
}
if(prevPageUrl==null||"".equals(prevPageUrl)){
	prevPageUrl = "";
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
      <link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
    <title>支付信息查询</title>
   <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script  src="/claim/js/WdatePicker.js" ></script>
  <script  type="text/javascript">
    	function submitForm(){
    		var registNo=$("#registNoT").val();
    		var policyNo=$("#policyNo").val();
    		var insuredName=$("#insuredName").val();
    		var shuldQuery = $("#shuldQuery").val();
    		if(shuldQuery!='1'){
	    		if((registNo==null||registNo.trim().length<1)&&(policyNo==null||policyNo.trim().length<1)
	    				&&(insuredName==null||insuredName.trim().length<1)){
	    			alert("报案号码、保单号码、被保险人必须至少录入一项精确查询");
	    			return false;
	    		}
    		}
    		fm.condition.value="";
    		fm.buttonSubmit.disabled = true;
    		  fm.action ="/claim/paymainFiscalRegist.do";
    		  fm.submit();//提交
    		  //return true ;
    	}
    	 function requestprevUrl(){
     		var prevPageUrl = document.getElementById('prevPageUrl').value;
     		if(prevPageUrl.length == 0){
 	    		var prevUrl = document.URL;
 	    		document.getElementById('prevPageUrl').value=prevUrl;
     		}
     	}
    </script>
  </head>
 <body class="interface" onload="requestprevUrl();">
  <form name="fm" action=""  method="post"  target ="showlist">
  		<input type="hidden" name="nodeType" value="apay"/>
  		<input type="hidden" name="condition" value=""/>
  		<input type="hidden" name="shuldQuery" value="<%=shuldQuery%>"/>
  		<input type="hidden" name="prevPageUrl" id="prevPageUrl"  value="<%=prevPageUrl%>">
   		<table  cellpadding="0"  cellspacing="0" border="1" bordercolor="#3A81C8" class="mycommon common">
   			<tr>
			<td colspan=4 class="tabletitle" ondblclick="showPage(RegistExtImg,paymain)">
				<IMG id="RegistExtImg" style="CURSOR: hand" onclick="showPage(this,paymain)"
					src="/claim/images/butExpandBlue.gif" name=RegistExtImg> 查询条件
			</td>
			</tr>
			<tbody id="paymain" >
	   			<tr>	
	   				<td class="title" style="width:15%;text-align:center">报案号码</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="registno" name="registNos">
	           				<option value="=">=</option>
<%--	            			<option value="*">*</option>--%>
	          			</select>
	   					<input type="text" name="registNoT" id="registNoT" class="input" style="width: 60%" >
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">保单号码</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="policyNos" name="policyNos">
	           				<option value="=">=</option>
<%--	            			<option value="*">*</option>--%>
	          			</select>
	   					<input type="text" name="policyNo" id="policyNo" style="width: 60%" class="input" >
	   				</td>
	   			</tr>
	   			<tr>	
	   				<td class="title" style="width:15%;text-align:center">被保险人</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="insuredNames" name="insuredNames">
<%--	            			<option value="*">*</option>--%>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" id="insuredName" name="insuredName" class="input" style="width:60%"/>
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">支付类型</td>
	   				<td class="input" style="width:35%">
	   					<input type="radio" id="payType" name="payType" value="P3" checked/>赔付
	   					<input type="radio" id="payType" name="payType" value="P1" />预付
	   					<input type="radio" id="payType" name="payType" value="P2"/>支付
	   					<input type="radio" id="payType" name="payType" value="P4"/>垫付
	   				</td>
	   			</tr>
	   			<tr>
	   				<td class="title" style="width:15%;text-align:center">案件类型</td>
	   				<td class="input" style="width:35%">
	   					<input type="checkbox" id="" name="mechanism" value="mechanism" checked/>本机构
	   					<input type="checkbox" id="" name="agnet" value="agnet"/>代查勘
	   				</td>
	   				<%
			            String statStartDate = "";
			       		String statEndDate ="";
			       		
			       		//DateTime dateTime = new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY);
			       		//statEndDate = dateTime.toString();
			       		//statStartDate = dateTime.addMonth(-1).toString();
			       
			         %>
	   				<td class="title" style="width:15%;text-align:center">流入时间</td>
	   				<td class="input" style="width:35%">
	   					<input type="text" style="width:40%" id="inputDateStrat" name="inputDateStrat" value="<%=statStartDate %>" class='input Wdate' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',autoPickDate:true,maxDate:'#F{$dp.$D(\'inputDateStrat\')}'})"/>
	   					至：
						<input type='text' style="width:40%" id="inputDateEnd" name="inputDateEnd" value="<%=statEndDate %>" class='input Wdate' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',autoPickDate:true,minDate:'#F{$dp.$D(\'inputDateEnd\')}'})"/>
	   				</td>
	   			</tr>
	   			<tr>
	   				<td class="title" style="width:15%;text-align:center">是否包括退回记录</td>
	   				<td class="input" style="width:35%">
	   					<input type="radio" name="back" value="1"/>是
	   					<input type="radio" name="back" value="0" checked/>否
	   				</td>
	   				<td colspan="2" class="input">
	   				</td>
	   				
	   			</tr>
	   			<tr>
	   				<td class="input" colspan="4" style="height: 32px;">
	   					
	   					&nbsp; 合并录入：对相同“承保机构、领款人名称、银行账号”的案件，可合并支付。<br>
	   					&nbsp; 报案号码、保单号码、被保险人必须至少录入一项精确查询。
	   				</td>
	   			</tr>
   			</tbody>
   			<tr>
   				<td colspan="4" class="title" style="text-align:center">
   					<input type="button" name="buttonSubmit" value="查询" class="bobu" onclick="submitForm()" >
   				</td>
   			</tr>
   		</table>
   	</form>
   	<iframe name="showlist" src="/claim/DAA/payment/empty.jsp" height="100%" frameborder="0" marginheight="0" marginwidth="0" scrolling="yes" width="100%"></iframe>
  </body>
  <script type="text/javascript">
  
  	<%  
  	//返回过来做一次查询
  	if((shuldQuery!=null&&"1".equals(shuldQuery))||("query".equals(doQuery))){
  	%>
  		fm.condition.value="<%=pageConditions%>";
  		fm.action ="/claim/paymainFiscalRegist.do";
	    fm.submit();//提交
  	<%	
  	} %>
  
  </script>
</html>
