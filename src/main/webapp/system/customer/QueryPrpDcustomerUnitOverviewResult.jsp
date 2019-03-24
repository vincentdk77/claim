<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
 <link href="/claim/css/Standard.css" rel="stylesheet" type="text/css">
 </head>
<body class="interface" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<html:form action="/processPrpDcustomerUnit.do?actionType=queryContinue">
<html:hidden property="pageNo"/>
<html:hidden property="rowsCount"/>
<html:hidden property="rowsPerPage"/>
<html:hidden property="taskCode"/>
<html:hidden property="groupCode"/>

<table width="100%" height="100%" border="0" cellpadding="5" cellspacing="0">
  <tr>
    <td height="35"><img src="/claim/images/imgPrpDcustomerUnit.gif">
    </td>
  </tr>
  <tr>
    <td align="center" valign="top">
      <table border="0" cellpadding="5" cellspacing="1" class="common">
        <tr>
          <td colspan="50" align="center" class="top"><strong>企业客户资料</strong></td>
        </tr>
        <tr>
          <td width="16%" class="top" style="text-align:left"><input type="checkbox" name=selectButton onpropertychange="boundCheckBox(this,fm.checkboxSelect)">顺序号</td>
          <td class="top">客户代码</td>
          <td class="top">速查索引码</td>
          <td class="top">客户中文名称</td>
          <td class="top">地址中文名称</td>

          <td class="top">归属机构代码</td>
          <td class="top">下级允许查看</td>
        </tr>
<%int index=0;%>
<logic:iterate id="prpDcustomerUnitDto" name="prpDcustomerUnitOverview">
        <tr>
          <td align="left" class="page">
            <input type=checkbox name=checkboxSelect value="<%=index++%>">
            <a href="processPrpDcustomerUnit.do?actionType=view&prpDcustomerUnitCustomerCode=<bean:write name="prpDcustomerUnitDto" property="customerCode" filter="true" />"><app:navigateNo name="fm" objectName="fm" index="<%=index%>"/></a>
            <input type="hidden" name="prpDcustomerUnitCustomerCode" value="<bean:write name="prpDcustomerUnitDto" property="customerCode" filter="true"/>">
          </td>
          <td align="center" class="page"><bean:write name="prpDcustomerUnitDto" property="customerCode" filter="true" /></td>
          <td align="center" class="page"><bean:write name="prpDcustomerUnitDto" property="shortHandCode" filter="true" /></td>
          <td align="center" class="page"><bean:write name="prpDcustomerUnitDto" property="customerCName" filter="true" /></td>
          <td align="center" class="page"><bean:write name="prpDcustomerUnitDto" property="addressCName" filter="true" /></td>
          <td align="center" class="page"><bean:write name="prpDcustomerUnitDto" property="comcode" filter="true" /></td>
          <td align="center" class="page"><bean:write name="prpDcustomerUnitDto" property="lowerViewFlag" filter="true" /></td>
        </tr>
</logic:iterate>
        <tr>
          <td colspan="50" align="center" class="page">
            <app:navigate name="fm" objectName="fm"/>
          </td>
        </tr>
        <tr>
          <td colspan="50" align="center" class="page">
            <app:command name="fm" objectName="PrpDcustomerUnit" action="insert,delete,update,query" path="system"/>
          </td>
        </tr>
      </table>
      </td>
  </tr>
</table>
</html:form>
 <jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html>
