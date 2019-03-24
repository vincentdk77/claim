<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
		<jsp:include page="/common/pub/StaticJavascript.jsp" />
		<script language="javascript">
			function submitForm()
			{
				if(fm.prpLclaimNo.value=="")
				{
					alert("请输入立案号!");
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
					<td align="center" colspan="2" class="formtitle">大病住院医疗费用补偿分段计算</td>
				</tr>
				<tr>
					<td align="right" class="title">请输入立案号：</td>
					<td class='input2'>
						<input align="center" class="common" type=text name="prpLclaimNo" >
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type=button value="下一步" class='button' name=saveButton onclick="submitForm();">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>