<%@ page language="java" import="java.util.*" %>
<%@page import="com.sinosoft.utility.string.ChgDate"%>
<%@ page import = "com.sinosoft.sysframework.common.datatype.DateTime"%>
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
 
   

    <title>������֧����Ϣ��ѯ</title>
  </head>
 <body class="interface" >
   <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script  src="/claim/js/WdatePicker.js" ></script>

  <script  type="text/javascript">
    	function submitForm(){
            var receiverFullName=$("#receiverFullName").val();
    		var bankAccount=$("#bankAccount").val();
    		var payAmount=$("#payAmount").val();
    		var payDate1 = $("#payDate1").val();
			var payDate2 = $("#payDate2").val();
	    		if((receiverFullName==null||receiverFullName.trim().length<1)&&(bankAccount==null||bankAccount.trim().length<1)
	    				&&(payAmount==null||payAmount.trim().length<1)
	    				&&(payDate1==null||payDate1.trim().length<1)&&(payDate2==null||payDate2.trim().length<1)){
	    			alert("��������¼��һ���ѯ");
	    			return false;
	    		}
	    		
	    		if ((payDate1==null||payDate1.trim().length<1)&&(payDate2==null||payDate2.trim().length<1)){
	    		}else if ((payDate1!=null&&payDate1.trim().length>0)&&(payDate2!=null&&payDate2.trim().length>0)){
	    		}else{
	    			alert("��ͬʱ����֧��ʱ����ֹʱ��");
	    			return false;
	    		}
    		
    		  fm.action ="/claim/prplthirdpayquery.do?forward=query";
    		  //x_load.show("ϵͳ���ڲ�ѯ,������ҳ��...");
              fm.queryButton.disabled=true;
	          fm.submit();//�ύ
	          setTimeout('fm.queryButton.disabled=false',5000);
    		  //return true ;
    		
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
  <form name="fm" action="/claim/prplthirdpayquery.do?forward=query"  method="post"  target ="showlist">
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
	   				<td class="title" style="width:15%;text-align:center">�տ���</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="receiverFullNameSign" name="receiverFullNameSign">
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" id="receiverFullName" name="prplpaymain.receiverFullName" class="input" style="width:60%"/>
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">�տ��˺�</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="bankAccountSign" name="bankAccountSign">
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" id="bankAccount" name="prplpaymain.bankAccount" class="input" style="width:60%"/>
	   				</td>
	   			</tr>
	   		    <tr>	   				
	   				<td class="title" style="width:15%;text-align:center">���</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="payAmountSign" name="payAmountSign">
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" id="payAmount" name="prplpaymain.payAmount" class="input" style="width:60%"/>
	   				</td>
	   				<td class="title" style="width:15%;text-align:center"></td>
		   			<td class="input" style="width:35%"></td>
	   			</tr>
	   			<tr>
                      <%
		            String payDate1 = "";
		       		String payDate2 ="";
		       		
		       		DateTime dateTime = new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY);
		       		payDate1 = dateTime.addDay(-7).toString();
		       		payDate2 = dateTime.toString();
		   
		       
		           %>
		   			<td class="title" style="width:15%;text-align:center">֧��ʱ��</td>
	   				<td class="input" style="width:35%">
	   					<input type="text" style="width:40%" id="payDate1" value="<%=payDate1 %>" name="payDate1" class='input Wdate' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',autoPickDate:true,maxDate:'#F{$dp.$D(\'payDate2\')}'})"/>
	   					����
						<input type='text' style="width:40%" id="payDate2"  value="<%=payDate2 %>" name="payDate2" class='input Wdate' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',autoPickDate:true,minDate:'#F{$dp.$D(\'payDate1\')}'})"/>
	   				</td>
	   				<td class="title" style="width:15%;text-align:center"></td>
		   			<td class="input" style="width:35%"></td>
	   			<tr>
	   			<tr style = "display:none" >	
	   				<td class="title" style="width:15%;text-align:center">��������</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="registno" name="registnoSign">
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" name="prplpay.registno" id="registno" class="input" style="width: 60%">
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">��������</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="policynoSign" name="policynoSign">
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" name="prplpay.policyno" id="policyno" style="width: 60%" class="input" >
	   				</td>
	   			</tr>

	   			<tr style = "display:none" >	
	   				
	   				<td class="title" style="width:15%;text-align:center">��������</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="insuredNameSign" name="insuredNameSign">
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" id="insuredName" name="prplregist.insuredName" class="input" style="width:60%"/>
	   				</td>
	   				<td class="title" style="width:15%;text-align:center"></td>
		   			<td class="input" style="width:35%"></td>
	   			</tr>

<%--	   				<td class="title" style="width:15%;text-align:center">��������</td>--%>
<%--	   				<td class="input" style="width:35%">--%>
<%--	   					<input type="checkbox" id="" name="mechanism" value="mechanism"/>������--%>
<%--	   					<input type="checkbox" id="" name="agnet" value="agnet"/>���鿱--%>
<%--	   				</td>--%>

	   			<tr style = "display:none" >
		   			<td class="title" style="width:15%;text-align:center">����״̬</td>
		   			<td class="input" style="width:35%">
		   				<input type="checkbox" id="" name="vflag" value="7"/>����
	   					<input type="checkbox" id="" name="vflag" value="3"/>����˻�
	   					<input type="checkbox" id="" name="vflag" value="9"/>�����˻�
		   			</td>
		   			<td class="title" style="width:15%;text-align:center">��������</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="insuredNameSign" name="insuredNameSign">
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" id="insuredName" name="prplregist.insuredName" class="input" style="width:60%"/>
	   				</td>
	   			</tr>

	   			<tr style = "display:none" >
		   			<td class="title" style="width:15%;text-align:center">����״̬</td>
	   				<td class="input" style="width:35%">
		   				<input type="checkbox" id="" name="vflag" value="6"/>�����
	   					<input type="checkbox" id="" name="vflag" value="2"/>�����
	   					<input type="checkbox" id="" name="vflag" value="8"/>��֧��
	   					<input type="checkbox" id="" name="prplpaymain.payFlag" value="1"/>��֧��
		   			</td>
		   			<%
		            String inputDate1 = "";
		       		String inputDate2 ="";
		       		
		       		DateTime dateTime1 = new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY);
		       		inputDate1 = dateTime1.addDay(-7).toString();
		       		inputDate2 = dateTime1.toString();
		   
		       
		           %>
		   			<td class="title" style="width:15%;text-align:center">����ʱ��</td>
	   				<td class="input" style="width:35%">
	   					<input type="text" style="width:40%" id="inputDate1" name="inputDate1" class='input Wdate' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',autoPickDate:true,maxDate:'#F{$dp.$D(\'inputDate2\')}'})"/>
	   					����
						<input type='text' style="width:40%" id="inputDate2" name="inputDate2" class='input Wdate' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',autoPickDate:true,minDate:'#F{$dp.$D(\'inputDate1\')}'})"/>
	   				</td>
	   			<tr>

		   		</tr>

	   			
   			</tbody>
   			<tr>
   				<td colspan="4" class="title" style="text-align:center">
   					<input type="hidden" value="<%=type %>" name="type"  >
   					<input type="button" value="��ѯ" class="bobu" name="queryButton" onclick="submitForm()" >
   				</td>
   			</tr>
   		</table>
   	</form>
   	<iframe name="showlist" src="/claim/DAA/payment/empty.jsp" height="100%" frameborder="0" marginheight="0" marginwidth="0" scrolling="no" width="100%"></iframe>
  </body>
</html>
