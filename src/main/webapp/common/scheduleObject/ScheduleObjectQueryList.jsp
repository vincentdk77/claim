<%--
****************************************************************************
* DESC       ：查询结果显示页面
* AUTHOR     ：lixiang
* CREATEDATE ：2005-09-02
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
    <app:css />
    <STYLE>BODY {
                 SCROLLBAR-FACE-COLOR:#EFFAFF;
                 SCROLLBAR-HIGHLIGHT-COLOR:#4D9AC4;
                 SCROLLBAR-SHADOW-COLOR:#4D9AC4;
                 SCROLLBAR-3DLIGHT-COLOR:#EFFAFF;
                 SCROLLBAR-ARROW-COLOR:#EFFAFF;
                 SCROLLBAR-TRACK-COLOR:#EFFAFF;
                 SCROLLBAR-DARKSHADOW-COLOR:#EFFAFF;
                }
                </STYLE>  
  <title><bean:message key="title.claimBeforeEdit.queryClaim"/></title>
  <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>

<body class="interface" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
  <table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
    <tr> 
      <td width="184" height="26" valign="bottom"> 
        <table width="184" height="19" border="0" cellpadding="0" cellspacing="0">
          <tr> 
            <td><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
            <td width="161" class="formtitle">调度机构信息列表</td>
            <td><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
          </tr>
        </table>
      </td>
      <td valign="bottom"><font color="#666666">&nbsp;</td>
    </tr>
  </table>
  <table bgcolor="#2D8EE1" class="common" cellpadding="4" cellspacing="1" >
     <tr>
        <td class="centertitle" >序号</td>
        <td class="centertitle" >调度机构代码</td>
        <td class="centertitle" >调度机构名称</td>
        <td class="centertitle" >调度机构类型</td>
        <td class="centertitle" >有效</td>
        <td class="centertitle" >归属调度机构</td>
        <td class="centertitle" >操作功能</td>
        <td class="centertitle" >操作功能</td>
     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="prpDcompanyDto"  property="companyList"> 
     <logic:iterate id="companyList1"  name="prpDcompanyDto"  property="companyList">  
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
        <td align="center">
        <%=index+1%>
        </td>
        <td align="center"><bean:write name="companyList1" property="comCode"/></td>    
        <td align="left"><bean:write name="companyList1" property="comCName"/></td>        
        <td align="center"><bean:write name="companyList1" property="comType"/></td>
        <td align="center"><bean:write name="companyList1" property="validStatus"/></td>
        <td align="center"><bean:write name="companyList1" property="upperComCode"/></td>
        
        <td align="center"><a href="/claim/scheduleObjectQuery.do?comCode=<bean:write name='companyList1' property='comCode'/>&editType=EDIT">修改</a></td>
        <td align="center"><a href="/claim/scheduleObjectQuery.do?comCode=<bean:write name='companyList1' property='comCode'/>&editType=SHOW">查看</a></td>
        
      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
      <tr class="listtail">
	      <td colspan="8">
	       共查询出<%= index %>条满足条件的记录
	      </td>
      </tr>
    </table>
    </tr>
  </table>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>