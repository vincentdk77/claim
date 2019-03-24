<%--
****************************************************************************
* DESC       ：查询输入页面
* AUTHOR     ： 
* CREATEDATE ： 2007-06-25
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
		<script src="/claim/commonAcci/regist/js/AcciRegistEdit.js"></script>
		<jsp:include page="/common/pub/StaticJavascript.jsp" />
		<script language="javascript">
			function submitForm()
			{
				if(fm.insuredName.value==""&&fm.identifyNumber.value==""&&fm.hospitalNumber.value=="")
				{
					alert("请至少填写一个查询条件！");
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
          <td class="formtitle" colspan="2" align="center">被保险人查询</td>
        </tr>
        <tr>
        	<td class="title" align="center" style="width:350px">姓名：</td>
        	<td>
        		<input type=text name="insuredName" style="width:150px">
        	</td>
        </tr>
        <tr>
        	<td class="title" align="center" style="width:350px">身份证号：</td>
        	<td>
        		<input type=text name="identifyNumber" style="width:150px">
        	</td>
        </tr>
        <tr>
        	<td class="title" align="center" style="width:350px">医疗证号：</td>
        	<td>
        		<input type=text name="hospitalNumber" style="width:150px">
        	</td>
        </tr>
        <tr>
        	<td colspan="2" align="center">
        		<input type=button value="查询" class='button' onclick="submitForm();">
        	</td>
        </tr>
        <input type="hidden" name="editType" value="Query">
			</table>
		</form>
	</body>
</html>