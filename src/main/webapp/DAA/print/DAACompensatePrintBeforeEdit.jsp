<%--
****************************************************************************
* DESC       ：打印前输入业务号页面
* AUTHOR     ： lixiang
* CREATEDATE ： 2004-11-12 
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=gb2312"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>


<html:html locale="true">
<head>
	<title>理赔打印前输入单证号</title>
	<%-- 页面样式  --%>
	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<script src="/claim/DAA/print/js/DAAPrintBeforeEdit.js"></script>
	<script src="/claim/common/js/SimpleCalendar.js"></script>
	<script language='javascript'>

      function loadForm()
      {
        
      }


      function checkForm()
      {

        return true;
      }


      function submitForm()
      {
        
       // if(checkForm()==true)
       // {
       //   }
       fm.submit();
      }
      
      function changeBizNoTitle()
{
  if(fm.ClaimStatus.value=="1")
  {
   tdBizNoTitle.innerHTML = "";
   tdBizNoTitle.style.display = "none";
   tdBizNoInput.style.display = "none";
  }
  else 
  {
   tdBizNoTitle.innerHTML = "赔款日期:";
   tdBizNoTitle.style.display = "";
   tdBizNoInput.style.display = "";
  }
  
}

    </script>

	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<html>
	<body class="interface" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="loadForm();"">
		<form name="fm" method="post" action="/claim/DAA/print/DAACompensatePrintBeforeQuery.jsp" onsubmit=" return submitForm()">

			<table border="0" align="center" cellpadding="5" cellspacing="1" class="common">
				<tr>
					<td colspan=4 class="formtitle">
						<div align="center">
							赔款理算书打印
						</div>
					</td>
				</tr>
				<tr>
					<td class='title' style="width:15%">
						赔款计算书号：
					</td>
					<td class='input' style="width:35%">
						<select class=tag name="CompensateNoSign">
							<option value="*">
								*
							</option>
							<option value="=">
								=
							</option>
						</select>
						<input type=text name="CompensateNo" class="query">
					</td>
					<td class='title' style="width:15%">
						立案号：
					</td>
					<td class='input' style="width:35%">
						<select class=tag name="ClaimNoSign">
							<option value="*">
								*
							</option>
							<option value="=">
								=
							</option>
						</select>
						<input type=text name="ClaimNo" class="query">
					</td>

				</tr>
				<tr>
					<td class='title' style="width:15%">
						赔款标识:
					</td>
					<td class='input'>
						<select class=tag name="ClaimStatus" onchange="changeBizNoTitle()" style="width:35%">
							<option value="1" checked>
								未赔
							</option>
							<option value="2">
								已赔
							</option>
						</select>
					</td>
					<td class='title' id="tdBizNoTitle" style="display:none" style="width:15%">
						赔款日期:
					</td>
					<td class='input' id="tdBizNoInput" style="display:none" style="width:35%">
						<input type=text name="UndwritebeginDate" class="Wdate" style="width:25%" onfocus="WdatePicker()">
						<!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" onClick="TogglePopupCalendarWindow('document.fm.UndwritebeginDate', '2007', '2017')"> -->
						至
						<input type=text name="UndwriteendDate" class="Wdate" style="width:25%" onfocus="WdatePicker()">
						<!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" onClick="TogglePopupCalendarWindow('document.fm.UndwriteendDate', '2007', '2017')"> -->
					</td>
				<tr>
					<td class='button' colspan="4">
						<div align="center">
							<input type=button class='button' value="查询" onClick="submitForm();">
						</div>
					</td>
				</tr>
			</table>

		</form>
	</body>

	<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>


