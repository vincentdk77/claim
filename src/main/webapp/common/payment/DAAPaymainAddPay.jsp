<%@ page language="java" import="java.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
      <link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
    <title>֧����Ϣ��ѯ</title>
   <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script  src="/claim/js/WdatePicker.js" ></script>
  <script  type="text/javascript">
    	function submitForm(){
    		var registNo=$("#registNo").val();
    		var policyNo=$("#policyNo").val();
    		var insuredName=$("#insuredName").val();
    		var shuldQuery = $("#shuldQuery").val();
    		if(shuldQuery!='1'){
	    		if((registNo==null||registNo.trim().length<1)&&(policyNo==null||policyNo.trim().length<1)
	    				&&(insuredName==null||insuredName.trim().length<1)){
	    			alert("�������롢�������롢�������˱�������¼��һ�ȷ��ѯ");
	    			return false;
	    		}
    		}
    		  fm.action ="/claim/paymainMergeAddQuery.do";
    		  fm.submit();//�ύ
    		  //return true ;
    	}
    	
    </script>
  </head>
 <body class="interface" >
  <form name="fm" action=""  method="post"  target ="showlist">
  		<input type="hidden" name="nodeType" value="apay"/>
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
	   					<select class=tag style="width: 30%" id="registno" name="registNos">
	           				<option value="=">=</option>
<%--	            			<option value="*">*</option>--%>
	          			</select>
	   					<input type="text" name="registNoT" id="registNo" class="input" style="width: 60%" >
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">��������</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="policyNos" name="policyNos">
	           				<option value="=">=</option>
<%--	            			<option value="*">*</option>--%>
	          			</select>
	   					<input type="text" name="policyNo" id="policyNo" style="width: 60%" class="input" >
	   				</td>
	   			</tr>
	   			<tr>	
	   				<td class="title" style="width:15%;text-align:center">��������</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="insuredNames" name="insuredNames">
<%--	            			<option value="*">*</option>--%>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" id="insuredName" name="insuredName" class="input" style="width:60%"/>
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">����ʱ��</td>
	   				<td class="input" style="width:35%">
	   					<input type="text" style="width:40%" id="inputDateStrat" name="inputDateStrat" class='input Wdate' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',autoPickDate:true,maxDate:'#F{$dp.$D(\'inputDateStrat\')}'})"/>
	   					����
						<input type='text' style="width:40%" id="inputDateEnd" name="inputDateEnd" class='input Wdate' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',autoPickDate:true,minDate:'#F{$dp.$D(\'inputDateEnd\')}'})"/>
	   				</td>
	   			</tr>
	   			<tr style="display: none;">
	   				<td class="title" style="width:15%;text-align:center">�������</td>
	   				<td class="input" style="width:35%">
	   					<input type="hidden" name="paymentType" value="${paymentType }"/>
	   					<input type="input" name="paymentTypeName" value="${paymentTypeName }" class="input" readOnly/>
	   				</td>	
	   				
	   				<td class="title" style="width:15%;text-align:center">֧������</td>
	   				<td class="input" style="width:35%">
	   					<input type="hidden" name="payType" value="${payType }" />
	   					<input type="input" name="payTypeName" value="${payTypeName }" class="input" readOnly/>
	   				</td>
	   			</tr>
	   			<tr>
	   				<td class="title" style="width:15%;text-align:center">��������</td>
	   				<td class="input" style="width:35%">
	   					<input type="checkbox" id="" name="mechanism" value="mechanism" checked/>������
	   					<input type="checkbox" id="" name="agnet" value="agnet"/>���鿱
	   				</td>
	   				<td class="title" style="width:15%;text-align:center"></td>
	   				<td class="input" style="width:35%">
	   				</td>
	   			</tr>
	   			<tr>
	   				<td class="input" colspan="4" style="height: 32px;">
	   					&nbsp; �ϲ�¼�룺����ͬ���б���������������ơ������˺š�������͡�ͬ�İ������ɿ簸���ϲ�¼�롣<br>
	   					&nbsp; �������롢�������롢�������˱�������¼��һ�ȷ��ѯ��
	   				</td>
	   			</tr>
   			</tbody>
   			<tr>
   				<td colspan="4" class="title" style="text-align:center">
   					<input type="button" value="��ѯ" class="bobu" onclick="submitForm()" >
   				</td>
   			</tr>
   		</table>
   		<br>
   		<br>
   	</form>
   	<iframe name="showlist" src="/claim/DAA/payment/empty.jsp" height="100%" frameborder="0" marginheight="0" marginwidth="0" scrolling="yes" width="100%"></iframe>
  </body>
</html>
