<%@ page import="com.sinosoft.claim.ui.control.action.UICodeAction" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.DateTime" %>
<%@page import="com.sinosoft.claim.dto.custom.UserDto"%><%--
****************************************************************************
* DESC       ：班表登记录入/修改页面
* AUTHOR     ：fengchuang
* CREATEDATE ：2012-10-24
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<head>
	<!--对title处理-->
	<title>班表查询</title>
	<%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
	
	<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
	<jsp:include page="/common/pub/StaticJavascript.jsp" />
	<%
	UserDto user = (UserDto) request.getSession().getAttribute("user");
	String comCode = user.getComCode();
	String comName = user.getComName();
	String handledept = request.getParameter("handledept");//机构代码
	String deptname = request.getParameter("deptname");//机构名称
	if(handledept!=null&&handledept.length()>0){
		comCode = handledept;
	}
	if(deptname!=null&&deptname.length()>0){
		comName = deptname;
	}
	UICodeAction uiCodeAction = new UICodeAction();
	String editType = request.getParameter("editType");
	String classCode = "";
	if("SchedSHOW".equals(editType)){
		String riskCode =  request.getParameter("riskCode");
		String riskType = uiCodeAction
					.translateRiskCodetoRiskType(riskCode);
			//add by miaowenjun 20060922 end
			
			if ("D".equals(riskType)) {
				classCode = "05";
			} else if ("I".equals(riskType)){
				classCode = "32";
			}else if("H".equals(riskType)){
				classCode = "31";
			} else if ("Q".equals(riskType) || "Z".equals(riskType)
					|| "Y".equals(riskType)) {
				classCode = "99";
			}
	}
	%>

	<script type="text/javascript">
		function init(){
			var editType = $("#editType").val();
			if(editType=='SchedSHOW'){
				fm.submit();
			}
		}
	</script>
</head>

<body onload="init();">
	<form name="fm" action="/claim/scheduleJobManagerQuery.do" method="post" onsubmit="" target="showlist">
		<input type="hidden" id="editType" name="editType" value="<%=editType %>" />
		   <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
			  <tr>  <td colspan=4 class="formtitle">查询条件</td></tr>
			  <tr>
					<td class='title' style="width: 15%">
						险类：
					</td>
					<td class='input' style="width: 25%">
					<select class=tag name="RiskCodeNoSign"  value="">
           				 <option value="=" >=</option>
         			 </select>
          			<select name="classCode"  id="classCode" class="query" style="width: 70%">
                            <option value="" <% if (classCode.equals("")){%>selected<%} %>>请选择</option>
                            <option value="31" <% if (classCode.equals("31")){%>selected<%} %>>种植保险类</option>
                            <option value="32" <% if (classCode.equals("32")){%>selected<%} %>>养殖保险类</option>
							<option value="99" <% if (classCode.equals("99")){%>selected<%} %>>非农保险类</option>
          			 </select>
			        </td> 
					<td class='title' style="width: 15%">
						班表机构：
					</td>
					<td class='input' style="width: 25%">
						<input type=hidden class="codecode" name="handledept"
							style="width: 20%" title="具体单位" value="<%=comCode%>">
						<input type=text class="codecode" name="deptname" id="deptname" title="具体单位"
							style="width: 100%" maxLength="50" description="班表单位" value="<%=comName %>"
							ondblclick="open_CodeSelect(this,'jobComCode','0000000000','班表单位');"
							onkeyup="open_CodeSelect(this,'jobComCode','0000000000','班表单位');"
							onkeypress="window.event.keyCode = 0;">
					</td>
				</tr>
				<tr>
                <%
                  String startDate = "";
                  String endDate ="";       		
                  DateTime dateTime1 = new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY);
                  startDate = dateTime1.addDay(-7).toString();
                  endDate = dateTime1.toString();
                %>
					<td class='title' style="width: 15%">
						日期：
					</td>
			         <td class='title' colspan="3">
			          <input type=text style="width:120" width="30%" name="jobdateBegin" class="Wdate"  onfocus="WdatePicker()" value=<%=startDate %>	> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif"  align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.jobdateBegin', '2007', '2017')"> -->
			    		      到：
			          <input type=text style="width:120" name="jobdateEnd" class="Wdate"  onfocus="WdatePicker()" value=<%=endDate %>> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.jobdateEnd', '2007', '2017')"> -->
			       </td> 
			  </tr>
			  <tr>
					<td colspan="4" align="center" class='title'>
						<input type="button" id="backButton" class='button' name="queryButton"  value="查询" onclick="saveForm2();">
					<% if(editType.equals("SchedSHOW")){ %>
						<input type=button name=buttonCancel class='button'  value="返回" onclick="window.close();" >
					<%} %>							
					</td>
					

				</tr>
			</tbody>
		</table>
	</form>
	<br/>
	<iframe name="showlist" src="" height="100%" frameborder="0"  marginheight="0" marginwidth="0" scrolling="no" width="100%"></iframe>

</body>
<script>
	function saveForm2(){
			var deptname = document.getElementById('deptname');
			var classCode  = document.getElementById('classCode');
			if(deptname.value == ""){
				alert("班表机构不能为空。");
				deptname.focus();
				return false;
			}
			if(classCode.value == ""){
				alert("险类不能为空。");
				classCode.focus();
				return false;
			}
			//if(month.value == "00"){
			//	alert("请选择班表月份。");
			//	month.focus();
			//	return false;
			//}
			fm.queryButton.disabled=true;
	        fm.submit();//提交
	        setTimeout('fm.queryButton.disabled=false',5000);
			return true;
	}
</script>