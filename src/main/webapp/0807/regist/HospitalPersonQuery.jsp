<%--
****************************************************************************
* DESC       ��ҽ��֤������ҳ��
* AUTHOR     �� 
* CREATEDATE �� 2007-05-21
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

<%
String  policyNo = (String)request.getAttribute("policyNo"); 

%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
		<script src="/claim/commonAcci/regist/js/AcciRegistEdit.js"></script>
		<jsp:include page="/common/pub/StaticJavascript.jsp" />
		<script language="javascript">
			function submitForm()
			{
				if(fm.hospitalNumber.value=="")
				{
					alert("������ҽ��֤��!");
					return false; 
				}
				fm.submit();
			}
		</script>
	</head>
	<body>
		<form name=fm action="/claim/0807registBeforeEdit.do" method="post">
			<table border="0" align="center" cellpadding="4" cellspacing="1" class="common">
				<tr>
          <td class="formtitle" colspan="2" align="center">�������˲�ѯ</td>
        </tr>
        <tr>
          <td class="title" align="center">��������:</td>
          <td class="input">��סԺҽ�Ʒ��ò���</td>
        </tr>
        <tr>
        	<td class="title" align="center">�������룺</td>
        	<td class="input">
        		<input type=text name=prpCmainPolicyNo class="readonly" readonly="true" value="<%=policyNo%>">
        	</td>
        </tr>
        <tr>
        	<td class="title" align="center">ҽ��֤�ţ�</td>
        	<td>
        		<input type=text name="hospitalNumber" style="width:150px"   >
        	</td>
        </tr>
        <tr>
        	<td colspan="2" align="center">
        		<input type=button value="��һ��" onclick="submitForm();">
        	</td>
        </tr>
			</table>
			<input type="hidden" name="editType" value="ADD">
		</form>
	</body>
</html>