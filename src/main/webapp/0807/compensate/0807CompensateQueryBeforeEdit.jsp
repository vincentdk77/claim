<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
		<jsp:include page="/common/pub/StaticJavascript.jsp" />
		<script language="javascript">
			function submitForm()
			{
				if(fm.prpLclaimNo.value=="")
				{
					alert("������������!");
					return false; 
				}
				fm.submit();
			}
		</script>
	</head>
	<body>
		<form name=fm action="/claim/0807compensateEdit.do" method="post">
			<table border="0" align="center" cellpadding="4" cellspacing="1" class="common">
				<tr>
					<td align="center" colspan="2" class="formtitle">��סԺҽ�Ʒ��ò����ֶμ���</td>
				</tr>
				<tr>
					<td align="right" class="title">�����������ţ�</td>
					<td class='input2'>
						<input align="center" class="common" type=text name="prpLclaimNo" >
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type=button value="��һ��" class='button' name=saveButton onclick="submitForm();">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>