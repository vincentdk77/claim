<%--
****************************************************************************
* DESC       ����ѯ����ҳ��
* AUTHOR     �� 
* CREATEDATE �� 2007-06-25
* MODIFYLIST ��   Name       Date            Reason/Contents
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
					alert("��������дһ����ѯ������");
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
        	<td class="title" align="center" style="width:350px">������</td>
        	<td>
        		<input type=text name="insuredName" style="width:150px">
        	</td>
        </tr>
        <tr>
        	<td class="title" align="center" style="width:350px">���֤�ţ�</td>
        	<td>
        		<input type=text name="identifyNumber" style="width:150px">
        	</td>
        </tr>
        <tr>
        	<td class="title" align="center" style="width:350px">ҽ��֤�ţ�</td>
        	<td>
        		<input type=text name="hospitalNumber" style="width:150px">
        	</td>
        </tr>
        <tr>
        	<td colspan="2" align="center">
        		<input type=button value="��ѯ" class='button' onclick="submitForm();">
        	</td>
        </tr>
        <input type="hidden" name="editType" value="Query">
			</table>
		</form>
	</body>
</html>