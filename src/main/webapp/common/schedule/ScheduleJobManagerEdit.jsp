<%@ page import="com.sinosoft.claim.ui.control.action.UICodeAction" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.DateTime" %>
<%@page import="com.sinosoft.claim.dto.custom.UserDto"%><%--
****************************************************************************
* DESC       �����Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��fengchuang
* CREATEDATE ��2012-10-24
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<head>
	<!--��title����-->
	<title>����ѯ</title>
	<%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
	
	<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
	<jsp:include page="/common/pub/StaticJavascript.jsp" />
	<%
	UserDto user = (UserDto) request.getSession().getAttribute("user");
	String comCode = user.getComCode();
	String comName = user.getComName();
	String handledept = request.getParameter("handledept");//��������
	String deptname = request.getParameter("deptname");//��������
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
			  <tr>  <td colspan=4 class="formtitle">��ѯ����</td></tr>
			  <tr>
					<td class='title' style="width: 15%">
						���ࣺ
					</td>
					<td class='input' style="width: 25%">
					<select class=tag name="RiskCodeNoSign"  value="">
           				 <option value="=" >=</option>
         			 </select>
          			<select name="classCode"  id="classCode" class="query" style="width: 70%">
                            <option value="" <% if (classCode.equals("")){%>selected<%} %>>��ѡ��</option>
                            <option value="31" <% if (classCode.equals("31")){%>selected<%} %>>��ֲ������</option>
                            <option value="32" <% if (classCode.equals("32")){%>selected<%} %>>��ֳ������</option>
							<option value="99" <% if (classCode.equals("99")){%>selected<%} %>>��ũ������</option>
          			 </select>
			        </td> 
					<td class='title' style="width: 15%">
						��������
					</td>
					<td class='input' style="width: 25%">
						<input type=hidden class="codecode" name="handledept"
							style="width: 20%" title="���嵥λ" value="<%=comCode%>">
						<input type=text class="codecode" name="deptname" id="deptname" title="���嵥λ"
							style="width: 100%" maxLength="50" description="���λ" value="<%=comName %>"
							ondblclick="open_CodeSelect(this,'jobComCode','0000000000','���λ');"
							onkeyup="open_CodeSelect(this,'jobComCode','0000000000','���λ');"
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
						���ڣ�
					</td>
			         <td class='title' colspan="3">
			          <input type=text style="width:120" width="30%" name="jobdateBegin" class="Wdate"  onfocus="WdatePicker()" value=<%=startDate %>	> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif"  align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.jobdateBegin', '2007', '2017')"> -->
			    		      ����
			          <input type=text style="width:120" name="jobdateEnd" class="Wdate"  onfocus="WdatePicker()" value=<%=endDate %>> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.jobdateEnd', '2007', '2017')"> -->
			       </td> 
			  </tr>
			  <tr>
					<td colspan="4" align="center" class='title'>
						<input type="button" id="backButton" class='button' name="queryButton"  value="��ѯ" onclick="saveForm2();">
					<% if(editType.equals("SchedSHOW")){ %>
						<input type=button name=buttonCancel class='button'  value="����" onclick="window.close();" >
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
				alert("����������Ϊ�ա�");
				deptname.focus();
				return false;
			}
			if(classCode.value == ""){
				alert("���಻��Ϊ�ա�");
				classCode.focus();
				return false;
			}
			//if(month.value == "00"){
			//	alert("��ѡ�����·ݡ�");
			//	month.focus();
			//	return false;
			//}
			fm.queryButton.disabled=true;
	        fm.submit();//�ύ
	        setTimeout('fm.queryButton.disabled=false',5000);
			return true;
	}
</script>