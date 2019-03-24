<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html>
<head>
<title>山东意外险风险预警平台补传</title>
<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
<jsp:include page="/common/pub/StaticJavascript.jsp" />
<script type="text/javascript">
	function saveForm(){
		var serviceType = fm.serviceType;
		if(isEmptyField(serviceType)){
			alert("平台交互接口不能为空。");
			return false;
		}
		var claimNo = fm.claimNo;
		if(isEmptyField(claimNo)){
		    alert("立案号不能为空");
		    return false;
		}
		fm.submit();
		return true;
	}
</script>
</head>
<body>
    <form name="fm" action="/claim/claimSDAcciPlat.do" method="post" target="showlist">
        <table width="90%" border="1" cellpadding="0" bordercolor="#3A81C8" cellspacing="0"  class="common">
            <tr>
				<td colspan="4" class="tabletitle" ondblclick="showPage(img1,top1)">
					<img id="img1"  onclick="showPage(this,top1)" src="/claim/images/butExpandBlue.gif">
					山东意外险风险预警平台补传（<font color="red">“*”为必录项</font>）
				</td>
			</tr>
			<tbody id="top1">
			    <tr>
			        <td class='title' width="15%">平台交互接口：</td>
					<td class='input' width="25%">
						<select name="serviceType" style="width:91%">
							<option value="">--请选择--</option>
							<option value="L01">立案</option>
							<option value="L02">结案</option>
						</select>
						<font color="red">*</font>
					</td>
					<td class='title' width="15%">立案号：</td>
					<td class='input' width="25%">
						<input type="text" name="claimNo" length="21" style="width:90%">
						<font color="red">*</font>
					</td>
			    </tr>
			    <tr>
					<td colspan="4" align="center" class='title'>
						<input type="button" id="backButton" class="bobu" value="提交" onclick="saveForm();">
					</td>
				</tr>
			</tbody>
        </table>
    </form>
    <iframe id="showlist" name="showlist" src="" frameborder="0"  marginheight="0" marginwidth="0" scrolling="no" width="100%"></iframe>
</body>
</html>