<%--
****************************************************************************
* DESC       ����ҳ����ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2005-01-25
* MODIFYLIST ��Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:html>
<head>
<title>��ҳ����ҳ��</title>
<app:css />
    <script src="/claim/common/pub/TurnOverPage.js"></script>
    <jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>
<%

%>
<body >
<table class=common>
    <tr>

        <input type="hidden" name="totalPage" value="<bean:write property='totalPage' name='pageview'/>">

        <logic:greaterEqual name="pageview" property="totalPage" value="0" >
            <td width="60%" align="center" >
                <div align="right">
                    ���������ļ�¼Ϊ<bean:write property="totalCount" name="pageview"/>����

                    ��<bean:write  property="pageNo" name="pageview"/>ҳ/��<bean:write property="totalPage" name="pageview"/>ҳ��
                    <logic:notEqual name="pageview" property="pageNo" value="1" >
                     <a href="javascript:FirstPage()"><u>��ҳ</u></a>
                    </logic:notEqual>

                    <logic:equal name="pageview" property="pageNo" value="1" >
                     <font color="#808080">��ҳ</font>
                    </logic:equal>

                     <logic:greaterThan name="pageview" property="pageNo" value="1" >
                          <a href="javascript:PrePage(<bean:write name="pageview" property="pageNo"/>)"><u>ǰҳ</u></a>
                     </logic:greaterThan>

                     <logic:lessEqual name="pageview" property="pageNo" value="1" >
                           <font color="#808080">ǰҳ</font>
                     </logic:lessEqual>
                    
                     <%--bean:define id="curPage" name="pageview" property="pageNo" /--%>
 
                     <logic:lessThan name="pageview" property="pageNo" value='${pageview.totalPage }'>
                          <a href="javascript:NextPage(<bean:write name="pageview" property="pageNo"/>)"><u>��ҳ</u></a>
                     </logic:lessThan>

                     <logic:greaterEqual name="pageview" property="pageNo" value='${pageview.totalPage}'>
                          <font color="#808080">��ҳ</font>
                     </logic:greaterEqual>

                     <logic:lessThan name="pageview" property="pageNo" value='${pageview.totalPage}' >
                     <a href="javascript:LastPage()"><u>βҳ</u></a>
                     </logic:lessThan>

                     <logic:greaterEqual name="pageview" property="pageNo" value='${pageview.totalPage}' >
                     <font color="#808080">βҳ</font>��
                     </logic:greaterEqual>

                     ����<input type="text" name="changepage" size="2" class="common" style="width:3%"
                             value='<bean:write  property="pageNo" name="pageview"/>'  maxlength="10" >ҳ<a href="javascript:ChangePage();"><html:img page="/images/bgGo.gif" width="20" height="15" border="0" align="absmiddle"/></a>
                     <input type="hidden" name="pageNo"  value='<bean:write  property="pageNo" name="pageview"/>'>
		                 <input type="hidden" name="condition" value="<bean:write  property="condition" name="pageview"/>">
		                  <input type="hidden" name="condition2" value="<bean:write  property="condition2" name="pageview"/>">
		                   <input type="hidden" name="condition3" value="<bean:write  property="condition3" name="pageview"/>">
		                 <input type="hidden" name="flag" id="flag" value="${flag}">
		                 <input type="hidden" name="type"  value="${type}">
                </div>
            </td>
        </logic:greaterEqual>
    </tr>
</table>
</body>
</html:html>