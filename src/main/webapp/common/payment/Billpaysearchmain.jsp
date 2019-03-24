<%@ page language="java" import="java.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String doQuery = request.getParameter("doQuery");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
      <link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
 
   

    <title>支付信息查询</title>
  </head>
 <body class="interface"  >
   <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script  src="/claim/js/WdatePicker.js" ></script>
  <script  type="text/javascript">
    	function submitForm(){
    		  var registNo = fm.registno.value;
    		  var policyno = fm.policyno.value;
    		  var insuredName = fm.insuredName.value;
    		  if(registNo=="" && policyno == ""&&insuredName==""){
    		  	 alert("报案号、保单号、被保险人三项至少录入一项！");
    		  	 return false;
    		  }
    		  fm.buttonSubmit.disabled = true;
    		  fm.action ="/claim/compensateList.do";
    		  fm.submit();//提交
    		  return true ;
    		
    	}
    	function requestprevUrl(){
     		var prevPageUrl = document.getElementById('prevPageUrl').value;
     		if(prevPageUrl.length == 0){
 	    		var prevUrl = document.URL;
 	    		document.getElementById('prevPageUrl').value=prevUrl;
     		}
     	}
    </script>
    <%
    String type=request.getParameter("type");
     %>
  <form name="fm" action=""  method="post" >
  		<input type="hidden" name="prevPageUrl" id="prevPageUrl"  value="${prevPageUrl }">
  		<input type="hidden" name="editType" value="ADD">
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
	   					<select class=tag style="width: 30%"  name="registnoSign">
	            			<option value="*">*</option>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" name="registno"  class="input" style="width: 60%">
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">保单号码</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%"  name="policynoSign">
	            			<option value="*">*</option>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" name="policyno"  style="width: 60%" class="input" >
	   				</td>
	   			</tr>
	   			<tr>	
	   				
	   				<td class="title" style="width:15%;text-align:center">被保险人</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%"  name="insuredNameSign">
	            			<option value="*">*</option>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text"  name="insuredName" class="input" style="width:60%"/>
	   				</td>
	   				<td class="title" style="width:15%;text-align:center"></td>
		   			<td class="input" style="width:35%"></td>
	   			</tr>
	   			
   			</tbody>
   			<tr>
   				<td colspan="4" class="title" style="text-align:center">
   					<input type="hidden" value="<%=type %>" name="type"  >
   					<input type="button" name="buttonSubmit" value="查询" class="bobu" onclick="submitForm()" >
   				</td>
   			</tr>
   		</table>
   	</form>
  </body>
</html>
