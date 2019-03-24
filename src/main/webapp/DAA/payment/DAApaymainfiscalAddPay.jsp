<%@ page language="java" import="java.util.*" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.DateTime" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String doQuery = request.getParameter("doQuery");

String pageConditions = request.getParameter("pageConditions");
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
    		var registNo=$("#registNo").val();
    		var compensateNo=$("#compensateNo").val();
    		if((registNo==null||registNo.trim().length<1)&&(compensateNo==null||compensateNo.trim().length<1)){
    			alert("报案号码、计算书号必须至少录入一项精确查询");
    			return false;
    		}
    		fm.condition.value="";
    		fm.buttonSubmit.disabled = true;
    		  fm.action ="/claim/paymainFiscalAddQuery.do";
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
 <body class="interface" onload="">
  <form name="fm" action=""  method="post"  target ="showlist">
  		<input type="hidden" name="nodeType" value="apay"/>
  		<input type="hidden" name="condition" value=""/>
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
	   					<input type="text" name="registNo" id="registNo" class="input" style="width: 60%" >
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">计算书号</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="compensateNos" name="compensateNos">
	           				<option value="=">=</option>
<%--	            			<option value="*">*</option>--%>
	          			</select>
	   					<input type="text" name="compensateNo" id="compensateNo" style="width: 60%" class="input" >
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

</html>
