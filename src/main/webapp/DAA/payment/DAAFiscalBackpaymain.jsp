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
 
   

    <title>֧����Ϣ��ѯ</title>
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
    			alert('����д��ȷ�ı�������');
    			return false;
    		}if(node=='prepay'||node=='comp'){
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
    		  fm.buttonSubmit.disabled = true;
    		  fm.action ="/claim/prplfiscalbacksearch.do";
    		  fm.submit();//�ύ
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
					src="/claim/images/butExpandBlue.gif" name=RegistExtImg> ��ѯ����
			</td>
			</tr>
			<tbody id="paymain" >
	   			<tr>	
	   				<td class="title" style="width:15%;text-align:center">��������</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="registno" name="registnoSign">
	            			<option value="*">*</option>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" name="prplpay.registno" id="registno" class="input" style="width: 60%">
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">��������</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="policynoSign" name="policynoSign">
	            			<option value="*">*</option>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" name="prplpay.policyno" id="policyno" style="width: 60%" class="input" >
	   				</td>
	   			</tr>
	   			<%
	   				if(!"3".equals(type)){
	   			%>
	   			<tr>	
	   				
	   				<td class="title" style="width:15%;text-align:center">��������</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="insuredNameSign" name="insuredNameSign">
	            			<option value="*">*</option>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" id="insuredName" name="prplregist.insuredName" class="input" style="width:60%"/>
	   				</td>
	   				<td class="title" style="width:15%;text-align:center"></td>
		   			<td class="input" style="width:35%"></td>
	   			</tr>
	   			<%
	   				}
	   			%>
<%--	   				<td class="title" style="width:15%;text-align:center">��������</td>--%>
<%--	   				<td class="input" style="width:35%">--%>
<%--	   					<input type="checkbox" id="" name="mechanism" value="mechanism"/>������--%>
<%--	   					<input type="checkbox" id="" name="agnet" value="agnet"/>���鿱--%>
<%--	   				</td>--%>
	   			<%
	   				if("3".equals(type)||"4".equals(type)){
	   			%>
	   			<tr>
		   			<td class="title" style="width:15%;text-align:center">����״̬</td>
		   			<%
	   					if("3".equals(type)){
	   				%>
		   			<td class="input" style="width:35%">
		   				<input type="checkbox" id="" name="vflag" value="7"/>����
	   					<input type="checkbox" id="" name="vflag" value="3"/>����˻�
	   					<input type="checkbox" id="" name="vflag" value="9"/>�����˻�
		   			</td>
		   			<td class="title" style="width:15%;text-align:center">��������</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="insuredNameSign" name="insuredNameSign">
	            			<option value="*">*</option>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" id="insuredName" name="prplregist.insuredName" class="input" style="width:60%"/>
	   				</td>
		   			<%
	   				}else if ("4".equals(type)){
	   				%>
	   				<td class="input" style="width:35%">
		   				<input type="checkbox" id="" name="vflag" value="6"/>�����
	   					<input type="checkbox" id="" name="vflag" value="2"/>�����
	   					<input type="checkbox" id="" name="vflag" value="8"/>��֧��
	   					<input type="checkbox" id="" name="prplpaymain.payFlag" value="1"/>��֧��
		   			</td>
		   			<td class="title" style="width:15%;text-align:center">����ʱ��</td>
	   				<td class="input" style="width:35%">
	   					<input type="text" style="width:40%" id="inputDate1" name="inputDate1" class='input Wdate' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',autoPickDate:true,maxDate:'#F{$dp.$D(\'inputDate2\')}'})"/>
	   					����
						<input type='text' style="width:40%" id="inputDate2" name="inputDate2" class='input Wdate' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',autoPickDate:true,minDate:'#F{$dp.$D(\'inputDate1\')}'})"/>
	   				</td>
	   				<%
	   					}
	   				%>
		   		</tr>
	   			<%
	   				}
	   			%>
	   			
   			</tbody>
   			<tr>
   				<td colspan="4" class="title" style="text-align:center">
   					<input type="hidden" value="<%=type %>" name="type"  >
   					<input type="button" name="buttonSubmit" value="��ѯ" class="bobu" onclick="submitForm()" >
   				</td>
   			</tr>
   		</table>
   	</form>
   	<iframe name="showlist" src="/claim/DAA/payment/empty.jsp" height="100%" frameborder="0" marginheight="0" marginwidth="0" scrolling="no" width="100%"></iframe>
  </body>
</html>
