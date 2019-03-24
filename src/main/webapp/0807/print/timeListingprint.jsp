<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime;"%>

<html>
	<head>
		<title>大病住院医疗补助费用清单打印前输入日期</title>
		<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
		<script src="/claim/DAA/print/js/DAAPrintBeforeEdit.js"></script>
		<jsp:include page="/common/pub/StaticJavascript.jsp" />
		<script language="javascript">
			function submitForm()
			{
				if(fm.startDate.value=="")
				{
					alert("请输入开始日期!");
					return false;
				}
				if(fm.endDate.value=="")
				{
					alert("请输入截止日期!");
					return false;
				}
				var strUrl = "";
				strUrl = "/claim/ClaimPrint.do?printType=timeListing&startDate=" + fm.startDate.value+"&endDate=" + fm.endDate.value;
				printWindow(strUrl,"打印1");
			}
			function printWindow(strURL,strWindowName)
      {
        var pageWidth=screen.availWidth-10;
        var pageHeight=screen.availHeight-30;

        if (pageWidth<100 )
          pageWidth = 100;

        if (pageHeight<100 )
          pageHeight = 100;

        var newWindow = window.open(strURL,strWindowName,'width='+pageWidth+',height='+pageHeight+',top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1.resizable=1,status=0');
        newWindow.focus();
        return newWindow;
      }
		</script>
	</head>
	<body>
		<form name="fm">
			<table border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
				<tr>
					<td colspan=2 class="formtitle">请输入起止日期</td>
				</tr>
				<tr>
					<td align="center">起
						<input class="common" type='text' name='startDate'style="width:100" onblur="checkFullDate(this);">日
						<img src="/claim/images/bgMarkMustInput.jpg">YYYY-MM-DD或YYYYMMDD
					</td>
					<td align="center">止
						<input class="common" type='text' name='endDate'style="width:100" onblur="checkFullDate(this);">日
						<img src="/claim/images/bgMarkMustInput.jpg">YYYY-MM-DD或YYYYMMDD
					</td>
				</tr>
				<tr>
					<td class="button" align="center" colspan="2">
						<input type=button value="下一步" class='button' onclick="submitForm();">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>