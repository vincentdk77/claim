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
      <title>֧����Ϣ��ѯ</title>
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
    			alert('����д��ȷ�ı�������');
    			return false;
    		}
    		if(node=='prepay'||node=='comp'){
    			if(compensateno==''){
	    			alert('����д��ȷ��ҵ���');
	    			return false;
	    		}
    		}if(node==''||node=='��ѡ��'){
    			alert('��ѡ������');
    			return false;
    		}
    		fm.action="/claim/prplpayadd.do?registno="+registno+"&busino="+compensateno+"&node="+node+"";
    		fm.submit();
    	}
    	function submitForm(){
    		  fm.action ="/claim/prplpaysearch.do";
    		  fm.submit();//�ύ
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
   				<td colspan="10" class="formtitle">�������ѯ����</td>
   			</tr>
   			<tr>	
   				<td class="title" style="width:15%">������</td>
   				<td class="input" style="width:35%">
   					<input type="text" name="prplpay.registno" id="registno" class="input" style="width: 90%">
   				</td>
   				<td class="title" style="width:15%">Ԥ�⣨�������飩��</td>
   				<td class="input" style="width:35%">
   					<input type="text" name="prplpay.compensateno" id="compensateno" style="width: 90%" class="input" >
   				</td>
   			</tr>
   			<tr>	
   				<td class="title" style="width:15%">�Ƿ���֧��</td>
   				<td class="input" style="width:35%">
   					<select name="prplpay.payflag">
   						<option>��ѡ��</option>
   						<option value="1">��</option>
   						<option value="0">��</option>
   					</select>
   				</td>
   				<td class="title" style="width:15%">֧������</td>
   				<td class="input" style="width:35%">
   					<select name="prplpay.paytype">
   						<option>��ѡ��</option>
   						<option value="P1">Ԥ��</option>
   						<option value="P2">֧��</option>
   						<option value="P3">ʵ��</option>
   						<option value="P4">�渶</option>
   						<option value="P5">�᰸֧��</option>
   					</select>
   				</td>
   			</tr>
   			<tr>	
   				<td class="title" style="width:15%">֧������</td>
   				<td class="input" style="width: 35%">
   					<input type="text" name="prplpay.starttime" id="prplpay.starttime" class="Wdate" style="width:29%"  value="<%= new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY).addYear(-1) %> "  onfocus="WdatePicker()"> <!-- <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.getElementById(\'prplpay.starttime\')', '2007', '2017')"> -->
   					��
   					<input type="text" name="prplpay.startend" id = "prplpay.startend" class="Wdate" style="width:29%"  value="<%= new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY) %> "  onfocus="WdatePicker()"> <!-- <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.getElementById(\'prplpay.startend\')', '2007', '2017')"> -->
   				</td>
   				<td class="title" style="width:15%">���������</td>
   				<td class="input" style="width:35%">
   					<select name="prplpay.receivertype">
   						<option>��ѡ��</option>
   						<option value="t1">��������</option>
   						<option value="t2">ί�и��˴�������</option>
   						<option value="t3">ί�е�λ��������</option>
   					</select>
   				</td>
   			</tr>
   			<tr>
   				<td class="title">����</td>
   				<td>
   					<select name="prplpay.node" id="node" onchange="disabledStates(this)">
   						<option>��ѡ��</option>
   						<option value="certify">��֤</option>
   						<option value="prepay">Ԥ��</option>
   						<option value="comp">����</option>
   					</select>
   				</td>
   				<td></td>
   				<td></td>
   			</tr>
   			<!--  
   			<%if("1".equals(type)){ //����%>
   			 <tr>
   				<td class="title">֧����Ϣ״̬</td>
   				<td colspan="3">
   				  <input type="checkbox" name="state" value="0" id="state1"><label for="state1">����ͨ��δ�ύ���</label>
   				  <input type="checkbox" name="state" value="-1" id="state3"><label for="state3">����δͨ��</label>
   				</td>
   			</tr>
   			<%}else if("2".equals(type)){//�ݴ� %>
   			<tr >
   				<td class="title">֧����Ϣ״̬</td>
   				<td colspan="3">
   				  <input type="checkbox" name="state" value="0" id="state1"><label for="state1">����ͨ��δ�ύ���</label>
   				  <input type="checkbox" name="state" value="-1" id="state3"><label for="state3">����δͨ��</label>
   				</td>
   			</tr>
   			<%}else if("3".equals(type)){//�˻� %>
   			<tr style="display:none">
   				<td class="title">֧����Ϣ״̬</td>
   				<td colspan="3">
   				  <input type="hidden" name="state" value="3" id="state2"><label for="state2">�˻�</label>
   				</td>
   			</tr>
   			<%}else if("4".equals(type)){ //��ѯ%>
   			<tr>
   				<td class="title">֧����Ϣ״̬</td>
   				<td colspan="3">
   				  <input type="checkbox" name="state" value="0" id="state1"><label for="state1">����ͨ��δ�ύ���</label>
   				  <input type="checkbox" name="state" value="3" id="state2"><label for="state2">�˻�</label>
   				  <input type="checkbox" name="state" value="-1" id="state3"><label for="state3">����δͨ��</label>
   				  <input type="checkbox" name="state" value="4" id="state4"><label for="state4">���ύ���</label>
   				</td>
   			</tr>
   			<%} %>
   			-->
   			<tr>
   				<td colspan="5" align="center">
   				    <input type="hidden" value="<%=type %>" name="type">
   					<input type="button" value="��ѯ" class="button" onclick="submitForm();" >
   					<%if(!"4".equals(type)){ //��ѯ%>
   					<input type="button" value="���" class="button" onclick="addNew();">
   					<%} %>
   				</td>
   			</tr>
   		</table>
   	</form>
  </body>
</html>
