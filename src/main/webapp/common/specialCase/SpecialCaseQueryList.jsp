<%--
****************************************************************************
* DESC       ：报案查询条件结果页面
* AUTHOR     ：lijiyuan
* CREATEDATE ：2004-03-01
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<html:html locale="true">
<head>
    <app:css />

  <title><bean:message key="title.registBeforeEdit.queryRegist"/></title>
          <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>


</head>

<body >
<input type="hidden" name="pageFlag">
  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr><td colspan=6 class="formtitle">预赔案查询结果信息</td></tr>
     <tr>
        <td class="centertitle" >案件状态</td>
        <td class="centertitle" >业务号</td>
        <td class="centertitle" ><bean:message key="db.prpLregist.policyNo"/></td>
        <td class="centertitle" ><bean:message key="db.prpLregist.operatorCode"/></td>
        <td class="centertitle" >操作时间</td>
        <td class="centertitle" >赔案类型</td>
     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="swfLogDto"  property="swfLogList">
     <logic:iterate id="swfLogList1"  name="swfLogDto"  property="swfLogList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
      <tr class=common>  <td align="center">
        <logic:equal name="swfLogList1" property="nodeStatus" value='1' >
         未处理
        </logic:equal>
        <logic:equal name="swfLogList1" property="nodeStatus" value='2' >
         正处理
        </logic:equal>
        <logic:equal name="swfLogList1" property="nodeStatus" value='3' >
         已处理
        </logic:equal>
        <logic:equal name="swfLogList1" property="nodeStatus" value='4' >
         已提交
        </logic:equal>
        <logic:equal name="swfLogList1" property="nodeStatus" value='5' >
         已撤消
        </logic:equal>
        </td>
        <logic:equal name="swfLogList1" property="typeFlag" value='3' >
          <td align="center"><a href="/claim/compensateFinishQueryList.do?prpLcompensateCompensateNo=<bean:write name='swfLogList1' property='keyOut'/>&editType=SHOW&riskCode=<bean:write name="swfLogList1" property="riskCode"/>"> <bean:write name="swfLogList1" property="keyOut"/></a></td>
        </logic:equal>
        <logic:equal name="swfLogList1" property="typeFlag" value='4' >
          <td align="center"><a href="/claim/compensateFinishQueryList.do?prpLcompensateCompensateNo=<bean:write name='swfLogList1' property='keyOut'/>&editType=SHOW&riskCode=<bean:write name="swfLogList1" property="riskCode"/>"> <bean:write name="swfLogList1" property="keyOut"/></a></td>
        </logic:equal>
        <logic:equal name="swfLogList1" property="typeFlag" value='5' >
          <td align="center"><a href="/claim/prepayFinishQueryList.do?prpLprepayPrepayNo=<bean:write name='swfLogList1' property='keyOut'/>&editType=SHOW&riskCode=<bean:write name="swfLogList1" property="riskCode"/>"> <bean:write name="swfLogList1" property="keyOut"/></a></td>
        </logic:equal>
         <logic:equal name="swfLogList1" property="typeFlag" value='7' >
          <td align="center"><a href="/claim/prepayFinishQueryList.do?prpLprepayPrepayNo=<bean:write name='swfLogList1' property='keyOut'/>&editType=SHOW&caseType=7&riskCode=<bean:write name="swfLogList1" property="riskCode"/>"> <bean:write name="swfLogList1" property="keyOut"/></a></td>
        </logic:equal>
        
         <logic:equal name="swfLogList1" property="typeFlag" value='8' >
          <td align="center"><a href="/claim/prepayFinishQueryList.do?prpLprepayPrepayNo=<bean:write name='swfLogList1' property='keyOut'/>&editType=SHOW&caseType=8&riskCode=<bean:write name="swfLogList1" property="riskCode"/>"> <bean:write name="swfLogList1" property="keyOut"/></a></td>
        </logic:equal>
        <td align="center"><bean:write name="swfLogList1" property="policyNo"/></td>
        <td align="center"><bean:write name="swfLogList1" property="handleTime"/></td>
        <td align="center"><bean:write name="swfLogList1" property="handlerName"/></td>
        <td align="center"><bean:write name="swfLogList1" property="typeFlagName"/></td>
      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
      <tr class="listtail">
        共查询出<%= index %>条满足条件的记录
      </tr>
  </table>
    </table>
    </tr>
  </table>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</form>
</body>
</html:html>