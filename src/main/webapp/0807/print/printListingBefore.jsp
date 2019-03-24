<html>
	<head>
		<title>农村合作医疗大病住院补偿费用清单打印</title>
		<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script src="/claim/DAA/print/js/DAAPrintBeforeEdit.js"></script>
    <jsp:include page="/common/pub/StaticJavascript.jsp" />
    <script language='javascript'>
    	function submitForm1()
    	{
    		window.location.href("timeListingprint.jsp");
    	}
    </script>
	</head>
	<body>
		<form name="fm">
			<table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
				<tr>
					<td colspan=2 class="formtitle">农村合作医疗大病住院补偿费用清单打印</td>
				</tr>
				<tr>
					<td class='common' align="center" colspan=2>请选择打印类型</td>
				</tr>
				<tr>
					<td align="right">
						<input type=button value="按时间" class='button' onclick="submitForm1();">
					</td>
					<td align="left">
						<input type=button value="按镇名" class='button' onclick="">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>