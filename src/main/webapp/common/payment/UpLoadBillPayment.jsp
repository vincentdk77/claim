<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String[] registNo = request.getParameterValues("registNo");
	String[] compensateNo = request.getParameterValues("compensateNo");
	String[] claimNo = request.getParameterValues("claimNo");
	String[] policyNo = request.getParameterValues("policyNo");
	String[] serialNo = request.getParameterValues("serialNo");
	String[] payName = request.getParameterValues("payName");
	String[] identifyNumber = request.getParameterValues("identifyNumber");
	String[] payAmount = request.getParameterValues("payAmount");
	String[] fkSerialNo = request.getParameterValues("fkSerialNo");
	String[] payAmounts = request.getParameterValues("payAmounts");
	String[] paymentNo = request.getParameterValues("paymentNo");
	String[] vflag = request.getParameterValues("vflag");
	String editType = request.getParameter("editType");
	String billNo = request.getParameter("billNo");
%>
<html>
<head>
<title>支付清单导入</title>
<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
 <link rel="stylesheet" type="text/css" href="/claim/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/claim/js/easyui/themes/icon.css">
<script type="text/javascript">
function submitForm()
{
  	var fileName1 = fm.FILE1.value;
	if(fileName1=="")
	{
		errorMessage("请选择要上传的Excel文件!");
		return false;		
	}
	if((fileName1!=""&&fileName1.substring(fileName1.length-4,fileName1.length).toUpperCase()!=".XLS"))
	{
		errorMessage("请上传XLS文件!");
		return false;		
	}
	fm.submit();
}
</script>
</head>
 <form action="/claim/prplBIllExcel.do" name="fm" ENCTYPE="multipart/form-data" target="fraInterface" method="post">
	<body class="interface">
		<table  cellpadding="1" cellspacing="1" bordercolor="#3A81C8"  border="0" >
			 <td class="title"  >文件名:</td>
		    <td class=title ><input TYPE="file"  name="FILE1" OnKeyDown="return false" SIZE="58">
		    </td>
		    <%for(int i=0;i<registNo.length;i++){ %>
		    	<input type="hidden" name="registNo" value="<%=registNo[i] %>">
		    	<input type="hidden" name="compensateNo" value="<%=compensateNo[i] %>">
		    	<input type="hidden" name="claimNo" value="<%=claimNo[i] %>">
		    	<input type="hidden" name="policyNo" value="<%=policyNo[i] %>">
		    	<input type="hidden" name="serialNo" value="<%=serialNo[i] %>">
		    	<input type="hidden" name="payName" value="<%=payName[i] %>">
		    	<input type="hidden" name="identifyNumber" value="<%=identifyNumber[i] %>">
		    	<input type="hidden" name="payAmount" value="<%=payAmount[i] %>">
		    	<input type="hidden" name="fkSerialNo" value="<%=fkSerialNo[i] %>">
		    	<input type="hidden" name="payAmounts" value="<%=payAmounts[i] %>">
		    	<input type="hidden" name="paymentNo" value="<%=paymentNo[i] %>">
		    	<input type="hidden" name="vflag" value="<%=vflag[i] %>">
		    	<input type="hidden" name="editType" value="<%=editType %>">
		    	<input type="hidden" name="billNo" value="<%=billNo %>">
		    <%} %>
	    </table>
	    <div >
	        <table align="center" id="buttonTable">
	           <tr style="valign:middle">
	        	 <td id="originButton1">
	        	 	<input class="button"   type=button value=" 数据导入 " onclick="submitForm();window.close() "> 
	        	 </td>
	        	</tr>
	        </table>
        </div>
	</body>
</form>
</html>