<%@ page language="java" import="java.util.*" %>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime;"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
    String type=request.getParameter("type");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <title>支付信息查询</title>
      <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
      <script src="/claim/common/js/SimpleCalendar.js"></script>
      <jsp:include page="/common/pub/StaticJavascript.jsp" />
      <script src="/claim/js/WdatePicker.js"></script>
      <script  type="text/javascript">
    	function addNew(){
    		var registno=$("#registno").val();
    		var compensateno=$("#compensateno").val();
    		var node=$("#node").val();
    		if(registno==''){
    			alert('请填写正确的报案号码');
    			return false;
    		}
    		if(node=='prepay'||node=='comp'){
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
    		  fm.action ="/claim/prplpaysearch.do";
    		  fm.submit();//提交
    		  return true ;
    		
    	}
    	function disabledStates(obj){
    		if(obj.value=='certify')
    		{
    			$("input[name='state'][type=checkbox]").attr('disabled','disabled');
    			$("input[name='state'][type=checkbox]").attr('checked',false);
    		}else{
    			$("input[name='state'][type=checkbox]").removeAttr("disabled");
    		}
    	}
   	 </script>
  </head>
 <body class="interface">
  <form name="fm" action=""  method="post">
   		<table  width="100%" border="0" align="center"  cellpadding="0"  cellspacing="0" class="common">
   			<tr>
   				<td colspan="10" class="formtitle">请输入查询条件</td>
   			</tr>
   			<tr>	
   				<td class="title" style="width:15%">报案号</td>
   				<td class="input" style="width:35%">
   					<input type="text" name="prplpay.registno" id="registno" class="input" style="width: 90%">
   				</td>
   				<td class="title" style="width:15%">预赔（或理算书）号</td>
   				<td class="input" style="width:35%">
   					<input type="text" name="prplpay.compensateno" id="compensateno" style="width: 90%" class="input" >
   				</td>
   			</tr>
   			<tr>	
   				<td class="title" style="width:15%">是否已支付</td>
   				<td class="input" style="width:35%">
   					<select name="prplpay.payflag">
   						<option>请选择</option>
   						<option value="1">是</option>
   						<option value="0">否</option>
   					</select>
   				</td>
   				<td class="title" style="width:15%">支付类型</td>
   				<td class="input" style="width:35%">
   					<select name="prplpay.paytype">
   						<option>请选择</option>
   						<option value="P1">预赔</option>
   						<option value="P2">支付</option>
   						<option value="P3">实付</option>
   						<option value="P4">垫付</option>
   						<option value="P5">结案支付</option>
   					</select>
   				</td>
   			</tr>
   			<tr>	
   				<td class="title" style="width:15%">支付日期</td>
   				<td class="input" style="width: 35%">
   					<input type="text" name="prplpay.starttime" id="prplpay.starttime" class="Wdate" style="width:29%"  value="<%= new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY).addYear(-1) %> "  onfocus="WdatePicker()"> <!-- <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.getElementById(\'prplpay.starttime\')', '2007', '2017')"> -->
   					至
   					<input type="text" name="prplpay.startend" id = "prplpay.startend" class="Wdate" style="width:29%"  value="<%= new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY) %> "  onfocus="WdatePicker()"> <!-- <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.getElementById(\'prplpay.startend\')', '2007', '2017')"> -->
   				</td>
   				<td class="title" style="width:15%">领款人类型</td>
   				<td class="input" style="width:35%">
   					<select name="prplpay.receivertype">
   						<option>请选择</option>
   						<option value="t1">被保险人</option>
   						<option value="t2">委托个人代理索赔</option>
   						<option value="t3">委托单位代理索赔</option>
   					</select>
   				</td>
   			</tr>
   			<tr>
   				<td class="title">流程</td>
   				<td>
   					<select name="prplpay.node" id="node" onchange="disabledStates(this)">
   						<option>请选择</option>
   						<option value="certify">单证</option>
   						<option value="prepay">预赔</option>
   						<option value="comp">理算</option>
   					</select>
   				</td>
   				<td></td>
   				<td></td>
   			</tr>
   			<!--  
   			<%if("1".equals(type)){ //新增%>
   			 <tr>
   				<td class="title">支付信息状态</td>
   				<td colspan="3">
   				  <input type="checkbox" name="state" value="0" id="state1"><label for="state1">核赔通过未提交审核</label>
   				  <input type="checkbox" name="state" value="-1" id="state3"><label for="state3">核赔未通过</label>
   				</td>
   			</tr>
   			<%}else if("2".equals(type)){//暂存 %>
   			<tr >
   				<td class="title">支付信息状态</td>
   				<td colspan="3">
   				  <input type="checkbox" name="state" value="0" id="state1"><label for="state1">核赔通过未提交审核</label>
   				  <input type="checkbox" name="state" value="-1" id="state3"><label for="state3">核赔未通过</label>
   				</td>
   			</tr>
   			<%}else if("3".equals(type)){//退回 %>
   			<tr style="display:none">
   				<td class="title">支付信息状态</td>
   				<td colspan="3">
   				  <input type="hidden" name="state" value="3" id="state2"><label for="state2">退回</label>
   				</td>
   			</tr>
   			<%}else if("4".equals(type)){ //查询%>
   			<tr>
   				<td class="title">支付信息状态</td>
   				<td colspan="3">
   				  <input type="checkbox" name="state" value="0" id="state1"><label for="state1">核赔通过未提交审核</label>
   				  <input type="checkbox" name="state" value="3" id="state2"><label for="state2">退回</label>
   				  <input type="checkbox" name="state" value="-1" id="state3"><label for="state3">核赔未通过</label>
   				  <input type="checkbox" name="state" value="4" id="state4"><label for="state4">已提交审核</label>
   				</td>
   			</tr>
   			<%} %>
   			-->
   			<tr>
   				<td colspan="5" align="center">
   				    <input type="hidden" value="<%=type %>" name="type">
   					<input type="button" value="查询" class="button" onclick="submitForm();" >
   					<%if(!"4".equals(type)){ //查询%>
   					<input type="button" value="添加" class="button" onclick="addNew();">
   					<%} %>
   				</td>
   			</tr>
   		</table>
   	</form>
  </body>
</html>
