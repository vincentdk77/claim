<%--
****************************************************************************
* DESC       ：分页公共页面
* AUTHOR     ：liubvo
* CREATEDATE ：2005-01-25
* MODIFYLIST ：Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:html>
<head>
<title>分页公共页面</title>
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
                    满足条件的记录为<bean:write property="totalCount" name="pageview"/>条　

                  
                    <logic:notEqual name="pageview" property="pageNo" value="1" >
                     
                    </logic:notEqual>

                    <logic:equal name="pageview" property="pageNo" value="1" >
                     
                    </logic:equal>

                     <logic:greaterThan name="pageview" property="pageNo" value="1" >
                          
                     </logic:greaterThan>

                     <logic:lessEqual name="pageview" property="pageNo" value="1" >
                           
                     </logic:lessEqual>
                    
                     <%--bean:define id="curPage" name="pageview" property="pageNo" /--%>
 
                     <logic:lessThan name="pageview" property="pageNo" value='${pageview.totalPage }'>
                       
                     </logic:lessThan>

                     <logic:greaterEqual name="pageview" property="pageNo" value='${pageview.totalPage}'>
                      
                     </logic:greaterEqual>

                     <logic:lessThan name="pageview" property="pageNo" value='${pageview.totalPage}' >
                   
                     </logic:lessThan>

                     <logic:greaterEqual name="pageview" property="pageNo" value='${pageview.totalPage}' >
                  
                     </logic:greaterEqual>

                    
                     <input type="hidden" name="pageNo"  value='<bean:write  property="pageNo" name="pageview"/>'>
		                 <input type="hidden" name="condition" value="<bean:write  property="condition" name="pageview"/>">
		                 <input type="hidden" name="flag" id="flag" value="${flag}">
		                 <input type="hidden" name="type"  value="${type}">
                </div>
            </td>
        </logic:greaterEqual>
    </tr>
</table>
</body>
</html:html>