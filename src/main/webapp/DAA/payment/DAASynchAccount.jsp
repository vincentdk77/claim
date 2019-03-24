<%@page contentType="text/html; charset=GBK"	language="java"	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="java.util.ArrayList" %>
<%@page import="com.sinosoft.claim.ui.control.action.UICodeAction" %>
<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
<script type="text/javascript">
	var ret = new Array();
	function chooseOne(obj){
		ret[0] = "true";
		var accountName = $(obj).parent().find("input[name='account']").val();
		ret[1] =accountName;
		var bank = $(obj).parent().find("input[name='bank']").val();
		ret[2] =bank;
		window.close();
	}
	window.returnValue = ret;
</script>

<div id="content_basic" style="width: 99%" name="payInfoListDiv">
	<span style="text-align: left; width: 99%;font-size:12px ">
		<img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
			name="RegistExtImg" onclick="showPage(this,payInfoList)">&nbsp;领款人信息
	</span>
	<table class="common" id="payInfoList" cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8">
		<thead>
			<tr>
				<td class="title"  style="width:5%" align="center">选择</td>
				<td class="title"  style="width:25%" align="center">计算书</td>
				<td class="title"  style="width:25%" align="center">户名</td>
			    <td class="title"  style="width:20%" align="center">账号</td>
			    <td class="title"  style="width:20%" align="center">开户银行</td>
			</tr>
		</thead>
		<tbody>
			<% ArrayList prpLcompensateList = (ArrayList)request.getAttribute("blPrpLcompensateList");
				UICodeAction uiCodeAction = new UICodeAction();
				for(int i=0;i<prpLcompensateList.size();i++) {
					PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)prpLcompensateList.get(i);
			%>
				<tr>
					<td class="input">
						<input type="radio" name="compensateNo" value="<%=prpLcompensateDto.getCompensateNo() %>" onclick="chooseOne(this);"/>
						<input type="hidden"  name="account" value="<%=prpLcompensateDto.getAccount() %>"/>
						<input type="hidden"  name="bank" value="<%=prpLcompensateDto.getBank() %>"/>	
						<input type="hidden"  name="receiverfullname" value="<%=prpLcompensateDto.getReceiverName() %>"/>
					</td>
					<td class="input">
						<%=prpLcompensateDto.getCompensateNo() %>
					</td>
					<td class="input">
						<%=prpLcompensateDto.getReceiverName() %>
					</td>
					<td class="input">
						<%=prpLcompensateDto.getAccount() %>
					</td>
					<td class="input">
						<%=prpLcompensateDto.getBank() %>
					</td>
				</tr>
			<%} %>
		</tbody>
	</table>
</div>
<input type="button" id="closeButton" name="closeButton" class="bobu"  value="关闭" onclick="javascript:window.close();">