<%--
****************************************************************************
* DESC       ：回访查询
* AUTHOR     ：chengyupeng
* CREATEDATE ：2011-12-28
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page language="java" pageEncoding="GBK"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime" %>
<%@ page import="com.sinosoft.claim.bl.facade.BLPrpDriskFacade" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.DateTime" %>
<%@ page import="com.sinosoft.claim.dto.domain.PrpDriskDto" %>
<%
   DateTime strFlowinTime = new DateTime().current();
   strFlowinTime.setTime(System.currentTimeMillis() - Long.parseLong("7776000000"));
   
   List riskCodeCollection = (List)new BLPrpDriskFacade().findRiskCodeByConditions(" k.validstatus = '1'");
   String[] riskCategory = new String[riskCodeCollection.size()];
   String[] riskCode = new String[riskCodeCollection.size()];
   String[] riskName = new String[riskCodeCollection.size()];
   PrpDriskDto prpdRiskDto = null;
   for(int i=0; i<riskCodeCollection.size(); i++)
   {
	   prpdRiskDto = (PrpDriskDto)riskCodeCollection.get(i);
       riskCategory[i] = prpdRiskDto.getRiskType();
       riskCode[i] = prpdRiskDto.getRiskCode();
       riskName[i] = prpdRiskDto.getRiskCName();
   }
   
%>
<html>
	<head>
		<title>回访查询</title>
		<%-- 页面样式  --%>
		<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
		<link rel="stylesheet" type="text/css" href="/claim/css/tableType.css">
		<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
		<jsp:include page="/common/pub/StaticJavascript.jsp" />
		<!-- my97时间控件 -->
		<script language="javascript" type="text/javascript" src="/claim/js/WdatePicker.js"></script>
		<script src="/claim/common/js/SimpleCalendar.js"></script>
		<script src="/claim/common/js/Common.js"></script>
		<script src="/claim/workflow/flow/js/WorkFlowFlowBeforeQuery.js"></script>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	</head>

	<body>
		<form name="fm" action="/claim/returnVisitQueryEdit.do" method="post" onsubmit="" target="showlist">
			<input type="hidden" id="editType" name="editType" value="${editType}"/>
			<table cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8" class="common">
				<tr ondblclick="showPage(RegistExtImg9,top9)">
					<td colspan="6" class="tabletitle">
						<div style="padding-left: 3px">
							<img style="cursor: hand;" src="/claim/images/butExpandBlue.gif" name="RegistExtImg" id="RegistExtImg9" onclick="showPage(this,top9)">
							<span>查询条件</span>
						</div>
					</td>
				</tr>
				<tbody id="top9">
					<tr>
						<td class='title w15 textr pright5'>报案号码(投诉编号)：</td>
						<td class='input w35 pleft5'>
							<select class=tag name="registNoSign">
								<option value="*">
									*
								</option>
								<option value="=">
									=
								</option>
							</select>
							<input type=text name="registNo" class="query">
						</td>
						<td class='title w15 textr pright5''>保单号码：</td>
						<td class='input pleft5'>
							<select class=tag name="policyNoSign">
								<option value="*">
									*
								</option>
								<option value="=">
									=
								</option>
							</select>
							<input type=text name="policyNo" class="query">
						</td>
					</tr>
					<tr>
						<td class='title textr pright5'>已回访时间</td>
							<td class='input pleft5'>
								<input style="width: 35%" name="enteringtimeBegin" class="Wdate"
									onfocus="WdatePicker()">
								到：
								<input style="width: 35%" name="enteringtimeEnd" class="Wdate"
									onfocus="WdatePicker()">
						</td>
						
						<td class='title textr pright5''>报案时间：</td>
						<td class='input pleft5'>
							<input style="width: 35%" name="reportdateBegin" class="Wdate"
								onfocus="WdatePicker()">
							到：
							<input style="width: 35%" name="reportdateEnd" class="Wdate"
								onfocus="WdatePicker()">
						</td>
					</tr>
					<tr>
						<td class='title textr pright5''>被保险人：</td>
						<td class='input pleft5'>
							<select class=tag name="insurednameSign">
								<option value="*">
									*
								</option>
								<option value="=">
									=
								</option>
							</select>
							<input type=text name="insuredname" class="query">
						</td>
						<td class='title textr pright5''>结案时间：</td>
						<td class='input pleft5'>
							<input style="width: 35%" name="endcasedateBegin" class="Wdate"
								onfocus="WdatePicker()">
							到：
							<input style="width: 35%" name="endcasedateEnd" class="Wdate"
								onfocus="WdatePicker()">
						</td>
					</tr>
					<tr>
						<td class='title textr pright5''>回访类型：</td>
						<td class='input pleft5'>
							<select name="nodeType" onchange="nodeTypeObj(this);">
								<option value="0">请选择</option>
								<option value="sched">派工回访</option>
								<option value="endca">结案回访</option>
								<option value="compl">投诉回访</option>
							</select>
						</td>
						<td class='title textr pright5''>回访标志：</td>
						<td class='input pleft5'>
							<select name="nodeMark" >
								<option value="0" selected="selected">未回访</option>
								<option value="20">已回访未成功（无需跟进）</option>
								<option value="21">已回访未成功（需跟进）</option>
								<option value="4">已回访已成功</option>
								<option value="024">全部</option>
								
							</select>
						</td>
					</tr>
						<tr>
							<td class='title textr pright5'>客户类型：</td>
							<td class='input pleft5'>
								<select name="customerType" id="customerType">
									<option value="2" selected="selected">单位</option>
									<option value="1">个人</option>
									<option value="0">全部</option>
								</select>
							</td>
							<td class='title textr pright5'>支付标志：</td>
							<td class='input pleft5'>
								<select name="payType" id="payType" disabled="disabled" onchange="setPayDate(this)">
									<option value="0" selected="selected">已支付</option>
									<option value="1">未支付</option>
									<option value="2">全部</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class='title textr pright5'>支付时间：</td>
							<td class='input pleft5'>
								<input style="width: 35%" name="paydateBegin" class="Wdate"
									onfocus="WdatePicker()">
								到：
								<input style="width: 35%" name="paydateEnd" class="Wdate"
									onfocus="WdatePicker()">
							</td>
							<td class='title textr pright5'>险种大类：</td>
       						 <td class='title'>
       					<select class="common" name="riskCategory"  id="riskCategory";
                               onchange="buildRiskCodeSelect(fm.riskCategory, fm.prpLregistRiskCode);">
                            <option value="">请选择</option>
                            <option value="Y">水险</option>
                            <option value="Q">非水</option>
                            <option value="E">意健</option>
                            <option value="H">种植</option>
                            <option value="I">养殖</option>
                        </select>
     					</td>
					    </tr>
						
						<tr>
						<td class='title textr pright5' >险种：</td>
        				<td class="input">
           			   <select class=tag name="RiskCodeSign" style="display:none">
               				 <option value="=">=</option>
           			   </select> 
           				 <input type="hidden" name="riskCodeTag" value="=">
            			<select class="common" id ="prpLregistRiskCode" name="prpLregistRiskCode">
            			
            			</select>
       				 </td>
					   </tr>
					<tr>
						<td class='title textc' colspan="4">
							<input type=button class='bobu' value="查询" onClick="submitForm('1');">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<iframe id="showlist" name="showlist" src="" height="100%" frameborder="0" marginheight="0" marginwidth="0" scrolling="no" width="100%"></iframe>
	</body>
	<script type="text/javascript">
		function submitForm(id){
			var nodeType = $("select[name=nodeType]").val();
			if(nodeType == '0'){
				alert("请选择回访类型！");
				return false;
			}
			if(id == '1'){
				document.getElementById('editType').value='SHOW';
				var nodeMark = $("select[name=nodeMark]").val();
				var enteringtimeBegin = $("input[name='enteringtimeBegin']").val();
				var enteringtimeEnd = $("input[name='enteringtimeEnd']").val();
				if(nodeMark == 0 && (enteringtimeBegin!="" || enteringtimeEnd!="")){
					if(!confirm("请确认未回访时,已回访时间是否存在！\n继续执行点击“确定”，否则点击“取消”。")){
						return false;
					}
				}
			}
			if(id == '2'){
				
			}
			fm.submit();
		}
		function nodeTypeObj(obj){
			var nodeType = obj.value;
			if(nodeType == "sched"){
				document.getElementById('endcasedateBegin').disabled="disabled";
				document.getElementById('endcasedateEnd').disabled="disabled";
				document.getElementById('endcasedateBegin').value="";
				document.getElementById('endcasedateEnd').value="";
				document.getElementById('payType').disabled="disabled";
				document.getElementById('payType').value="0";
				document.getElementById('customerType').value="2";
				document.getElementById('customerType').disabled="";
				document.getElementById('paydateBegin').disabled="disabled";
				document.getElementById('paydateEnd').disabled="disabled";
				document.getElementById('riskCategory').disabled="";
				document.getElementById('prpLregistRiskCode').disabled="";
			}else if(nodeType == "endca"){
				document.getElementById('payType').disabled="";
				document.getElementById('payType').value="0";
				document.getElementById('endcasedateBegin').disabled="";
				document.getElementById('endcasedateEnd').disabled="";
				document.getElementById('endcasedateBegin').value="<%=new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY).addDay(-10) %>";
				document.getElementById('endcasedateEnd').value="<%=new DateTime(DateTime.current().toString()) %>";
				document.getElementById('customerType').value="2";
				document.getElementById('customerType').disabled="";
				document.getElementById('paydateBegin').disabled="";
				document.getElementById('paydateEnd').disabled="";
				document.getElementById('riskCategory').disabled="";
				document.getElementById('prpLregistRiskCode').disabled="";
			}else{
				document.getElementById('endcasedateBegin').disabled="";
				document.getElementById('endcasedateEnd').disabled="";
				document.getElementById('endcasedateBegin').value="";
				document.getElementById('endcasedateEnd').value="";
				document.getElementById('payType').disabled="disabled";
				document.getElementById('payType').value="0";
				document.getElementById('customerType').value="0";
				document.getElementById('customerType').disabled="";
				document.getElementById('riskCategory').disabled="disabled";
				document.getElementById('riskCategory').value="";
				document.getElementById('prpLregistRiskCode').disabled="disabled";
				document.getElementById('prpLregistRiskCode').value="";
			}
		}
		function setPayDate(obj){
			var nodeType = obj.value;
			if(nodeType == "0"){
				document.getElementById('paydateBegin').disabled="";
				document.getElementById('paydateEnd').disabled="";
			}else{
				document.getElementById('paydateBegin').disabled="disabled";
				document.getElementById('paydateEnd').disabled="disabled";
			}
		}
		
	 var riskCodeCount = <%=riskCodeCollection.size()%>;
     var riskCodes = new Array();
    <%for(int i=0; i<riskCodeCollection.size(); i++){%>
        riskCodes[<%=i%>] = new Array("<%=riskCategory[i]%>", "<%=riskCode[i]%>", "<%=riskName[i]%>");
    <%}%>
	</script>
</html>