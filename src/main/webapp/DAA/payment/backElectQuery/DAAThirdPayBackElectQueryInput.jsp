<%@ page language="java" import="java.util.*" %>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.utility.string.ChgDate"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String doQuery = request.getParameter("doQuery");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   

    <title>���ӻ�ִ�����ز�ѯ</title>
  </head>
      <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
      <link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
      <script  src="/claim/js/WdatePicker.js" ></script>
      <jsp:include page="/common/pub/StaticJavascript.jsp"/>
    
      <script  type="text/javascript">
      
    	function submitForm(){
			var receiverFullName=fm.receiverFullName.value;
	    	var bankAccount=fm.bankAccount.value;
	    	var paymentNo = fm.paymentNo.value;
	    	var registNo = fm.registNo.value;
    		var payDate1 = fm.payDate1.value;
    		var payDate2 = fm.payDate2.value;
    		if((receiverFullName=="")&&(bankAccount=="")&&(paymentNo=="")&&(registNo=="")
	    				&&(payDate1=="")&&(payDate2=="")){
	    			alert("��������¼��һ���ѯ");
	    			return false;
	    		}
    	   if ((payDate1=="")&&(payDate2=="")){
    	   }else if ((payDate1!="")&&(payDate2!="")){
    	   }else{
    			alert("��ͬʱ����֧��ʱ����ֹʱ��");
    			return false;
    	   }
    	  fm.submitButton.disabled=true;
   		  //fm.action ="UIThirdPayBackElectQueryList.jsp?forward=query";
   		  fm.action ="/claim/bankelect.do";
   		  fm.submit();//�ύ    		
   		  setTimeout('fm.submitButton.disabled=false',1000);
    	}
    </script>
    <%
    	String type=request.getParameter("type");
      	ChgDate idate = new ChgDate();
	  	String strDate  = idate.getCurrentTime("yyyy-MM-dd");
	  	//ȡ��ǰ���ڵ�ͷһ��
	  	com.sinosoft.utility.string.Date sinosoftDate = new com.sinosoft.utility.string.Date();
	  	sinosoftDate.set(sinosoftDate.DATE,sinosoftDate.get(sinosoftDate.DATE)-1);
	  	String strPrePayDate2 = idate.toFormat(sinosoftDate.getString(sinosoftDate.YEAR+sinosoftDate.MONTH+sinosoftDate.DATE));
	  	sinosoftDate.set(sinosoftDate.MONTH,sinosoftDate.get(sinosoftDate.MONTH)-3);
	  	String strPrePayDate1 = idate.toFormat(sinosoftDate.getString(sinosoftDate.YEAR+sinosoftDate.MONTH+sinosoftDate.DATE));
     %>
     
 <body>
  <form name="fm" method="post"  action="/claim/bankelect.do" target ="showlist">
   		<table  cellpadding="0"  cellspacing="0" border="1" bordercolor="#3A81C8" class="common">
   			<tr>
				<td colspan=4 class="tabletitle" ondblclick="showPage(RegistExtImg,paymain)">
				<IMG id="RegistExtImg" style="CURSOR: hand" onclick="showPage(this,paymain)"
					src="/claim/images/butExpandBlue.gif" name=RegistExtImg> ��ѯ����
				</td>
			</tr>
			<tbody id="paymain" >
			<tr>	   				
   				<td class=title style="width:15%;text-align:center">������</td>
   				<td class=input style="width:35%">
   					<select class=tag  style="width: 30%" id="registNoSign" name="registNoSign">
   						<option value="=">=</option>
            			<option value="*">*</option>
          			</select>
   					<input type="text" id="registNo" name="registNo" class="input" style="width: 50%"/>
   				</td>
   				<td class=title style="width:15%;text-align:center">�ո����</td>
   				<td class="input" style="width:35%">
   					<select class=tag style="width: 30%" id="paymentNoSign" name="paymentNoSign">
   						<option value="=">=</option>
            			<option value="*">*</option>
          			</select>
   					<input type="text" id="paymentNo" name="paymentNo" style="width: 50%" class="input"/>
   				</td>
	   		</tr>
			<tr>	   				
   				<td class=title style="width:15%;text-align:center">���������</td>
   				<td class=input style="width:35%">
   					<select class=tag style="width: 30%" id="receiverFullNameSign" name="receiverFullNameSign">
   						<option value="=">=</option>
            			<option value="*">*</option>
          			</select>
   					<input type="text" id="receiverFullName" name="receiverFullName" class="input" style="width:50%"/>
   				</td>
   				<td class=title style="width:15%;text-align:center">�����˺�</td>
   				<td class=input style="width:35%">
   					<select class=tag style="width: 30%" id="bankAccountSign" name="bankAccountSign">
   						<option value="=">=</option>
            			<option value="*">*</option>
          			</select>
   					<input type=text id="bankAccount" name="bankAccount" class="input" style="width:50%"/>
   				</td>
	   		</tr>
	   		<tr>
				<td class="title" style="width:15%;text-align:center">¼��ʱ��</td>
   				<td class="input" style="width:35%">
   					<input type="text" style="width:40%" value="<%=strPrePayDate1%>" id="payDate1" name="payDate1" class='input Wdate' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',autoPickDate:true,maxDate:'#F{$dp.$D(\'payDate2\')}'})"/>
   					����
					<input type='text' style="width:40%" value="<%=strPrePayDate2%>" id="payDate2" name="payDate2" class='input Wdate' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',autoPickDate:true,minDate:'#F{$dp.$D(\'payDate1\')}'})"/>
   				</td>
   				<td class="title" style="width:15%;text-align:center"></td>
   				<td class="input" style="width:35%">
   				</td>
	   		<tr>
	   		<tr>
   				<td class="input" colspan="4" style="height: 25px;border-top:0px">
   				&nbsp;
   				<span style="color: red;">ϵͳ��ʾ�����ӻ�ִ�������ڼ�������û��֧���ɹ����ҵ��ӻ�ִ��ֻ����ϵͳ���3���£�3���º��Զ����</span></td>
   				</td>
	   		<tr>
	   		
	   	</tbody>
   			<tr>
   				<td colspan="4" class=title style="text-align:center;border-top:0px">
   					<input type="hidden" value="<%=type %>" name="type"  >
   					<input type="button" name="submitButton" value="��ѯ" class="bobu" onclick="submitForm()" >
   				</td>
   			</tr>
   		</table>
   	</form>
   	<iframe name="showlist" src="/claim/DAA/payment/empty.jsp" height="100%" frameborder="0" marginheight="0" marginwidth="0" scrolling="no" width="100%"></iframe>
  </body>
</html>
