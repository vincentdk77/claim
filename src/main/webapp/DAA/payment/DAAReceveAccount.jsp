<%@page contentType="text/html; charset=GBK"	language="java"	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="java.util.ArrayList" %>
<%@page import="com.sinosoft.claim.ui.control.action.UICodeAction" %>
<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
<link rel="stylesheet" type="text/css" href="/newclaim/css/StandardCar.css">
<script type="text/javascript">
	var ret = new Array();
	function chooseOne(obj){
		ret[0] = "true";
		var accountName = $(obj).parent().find("input[name='accountName']").val();
		ret[1] =accountName;
		var buslicenseCode = $(obj).parent().find("input[name='buslicenseCode']").val();
		ret[2] =buslicenseCode;
		var openProvinceCode = $(obj).parent().find("input[name='openProvinceCode']").val();
		ret[3] =openProvinceCode;
		var openCityCode = $(obj).parent().find("input[name='openCityCode']").val();
		ret[4] =openCityCode;
		var accountType = $(obj).parent().find("input[name='accountType']").val();
		ret[5] =accountType;
		var bankType = $(obj).parent().find("input[name='bankType']").val();
		ret[6] =bankType;
		var bankDetail = $(obj).parent().find("input[name='bankDetail']").val();
		ret[7] =bankDetail;
		var bankAccount = $(obj).parent().find("input[name='bankAccount']").val();
		ret[8] =bankAccount;
		var legalPersonMobileNo = $(obj).parent().find("input[name='legalPersonMobileNo']").val();
		ret[9] =legalPersonMobileNo;
		var addressDetail = $(obj).parent().find("input[name='addressDetail']").val();
		ret[10] =addressDetail;
		var enterpriseCode = $(obj).parent().find("input[name='enterpriseCode']").val();
		ret[11] =enterpriseCode;
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
			    <td class="title"  style="width:14%" align="center">企业名称</td>
			    <td class="title"  style="width:20%" align="center">归属机构</td>
			</tr>
		</thead>
		<tbody>
			<% ArrayList prpLTripartiteComList = (ArrayList)request.getAttribute("prpLTripartiteComList");
				UICodeAction uiCodeAction = new UICodeAction();
				for(int i=0;i<prpLTripartiteComList.size();i++) {
					PrpLTripartiteComDto prpLTripartiteComDto = (PrpLTripartiteComDto)prpLTripartiteComList.get(i);
			%>
				<tr>
					<td class="input">
						<input type="radio" name="enterpriseCode" value="<%=prpLTripartiteComDto.getEnterpriseCode() %>" onclick="chooseOne(this);"/>
						<input type="hidden" name="accountName" value="<%=prpLTripartiteComDto.getAccountName() %>" />
						<input type="hidden" name="buslicenseCode" value="<%=prpLTripartiteComDto.getBuslicenseCode() %>" />
						<input type="hidden" name="openProvinceCode" value="<%=prpLTripartiteComDto.getOpenProvinceCode() %>" />
						<input type="hidden" name="openCityCode" value="<%=prpLTripartiteComDto.getOpenCityCode() %>" />
						<input type="hidden" name="accountType" value="<%=prpLTripartiteComDto.getAccountType() %>" />
						<input type="hidden" name="bankType" value="<%=prpLTripartiteComDto.getBankType() %>" />
						<input type="hidden" name="bankDetail" value="<%=prpLTripartiteComDto.getBankDetail() %>" />
						<input type="hidden" name="bankAccount" value="<%=prpLTripartiteComDto.getBankAccount() %>" />
						<input type="hidden" name="legalPersonMobileNo" value="<%=prpLTripartiteComDto.getLegalPersonMobileNo() %>" />
						<input type="hidden" name="addressDetail" value="<%=prpLTripartiteComDto.getAddressDetail() %>" />
						
					</td>
					<td class="input">
						<%=prpLTripartiteComDto.getEnterpriseCname() %>
					</td>
					<td class="input">
						<%=prpLTripartiteComDto.getComCname() %>
					</td>
				</tr>
			<%} %>
		</tbody>
	</table>
</div>
<input type="button" id="closeButton" name="closeButton" class="bobu"  value="关闭" onclick="javascript:window.close();">