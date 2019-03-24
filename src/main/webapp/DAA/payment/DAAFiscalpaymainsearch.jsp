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
 <body class="interface" onload="requestprevUrl();<%if("query".equals(doQuery)){%>submitForm();<%}%>" >
   <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script  src="/claim/js/WdatePicker.js" ></script>
  <script  type="text/javascript">
    	function addNew(){
    		var registno=$("#registno").val();
    		var compensateno=$("#compensateno").val();
    		var node=$("#node").val();
    		if(registno==''){
    			alert('请填写正确的报案号码');
    			return false;
    		}if(node=='prepay'||node=='comp'){
    			if(compensateno==''){
	    			alert('请填写正确的业务号');
	    			return false;
    			}
    		}if(node==''||node=='请选择'){
    			alert('请选择流程');
    			return false;
    		}
    		fm.action="/claim/prplpayadd.do?registno="+registno+"&busino="+compensateno+"&node="+node+"";
    		fm.submit();
    	}
    	function submitForm(){
    		  fm.buttonSubmit.disabled = true;
    		  fm.action ="/claim/prplfiscalpaysearch.do";
    		  fm.submit();//提交
    		  return true ;
    		
    	}
    	function disabledStates(obj){
    	    //alert(obj.value);
    		if(obj.value=='certify')
    		{
    			$("input[name='state'][type=checkbox]").attr('disabled','disabled');
    			$("input[name='state'][type=checkbox]").attr('checked',false);
    		}else{
    			$("input[name='state'][type=checkbox]").removeAttr("disabled");
    		}
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
  <form name="fm" action=""  method="post"  target ="showlist">
  		<input type="hidden" name="prevPageUrl" id="prevPageUrl"  value="${prevPageUrl }">
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
	   					<select class=tag style="width: 30%" id="registno" name="registnoSign">
	            			<option value="*">*</option>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" name="prplfiscalpaymainDto.registno" id="registno" class="input" style="width: 60%">
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">支付清单号</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="fiscalnoSign" name="fiscalnoSign">
	            			<option value="*">*</option>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" name="prplfiscalpaymainDto.fiscalno" id="fiscalno" style="width: 60%" class="input" >
	   				</td>
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
   	<iframe name="showlist" src="/claim/DAA/payment/empty.jsp" height="100%" frameborder="0" marginheight="0" marginwidth="0" scrolling="no" width="100%"></iframe>
  </body>
</html>
