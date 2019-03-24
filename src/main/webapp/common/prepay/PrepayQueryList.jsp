<%--
****************************************************************************
* DESC       ：预赔条件输入页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-06-07
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

  <title>预赔搜索</title>
          <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>

<body >


  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr>     <td colspan=6 class="formtitle">预赔查询结果信息</td></tr>
     <tr>
        <td class="centertitle" >案件状态</td>
        <td class="centertitle" >预赔登记号</td>
        <td class="centertitle" >立案号</td>
        <td class="centertitle" >保单号</td>
        <td class="centertitle" >操作员</td>
        <td class="centertitle" >操作时间</td>
     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="prpLprepayDto"  property="claimList">
     <logic:iterate id="prpLprepay1"  name="prpLprepayDto"  property="claimList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
      <tr class=common><td align="center">
        <logic:equal name="prpLprepay1" property="status" value='1' >
         未处理
        </logic:equal>
        <logic:equal name="prpLprepay1" property="status" value='2' >
         正处理
        </logic:equal>
        <logic:equal name="prpLprepay1" property="status" value='3' >
         已处理
        </logic:equal>
        <logic:equal name="prpLprepay1" property="status" value='4' >
         已提交
        </logic:equal>
        <logic:equal name="prpLprepay1" property="status" value='5' >
         已撤消
        </logic:equal>
      </td>
        <td align="center"> <a href="/claim/prepayFinishQueryList.do?prpLprepayPrepayNo=<bean:write name='prpLprepay1' property='preCompensateNo'/>&editType=<bean:write name='prpLprepayDto' property='editType'/>&riskCode=<bean:write name='prpLprepay1' property='riskCode'/>"><bean:write name="prpLprepay1" property="preCompensateNo"/></a></td>
        <td align="center"><bean:write name="prpLprepay1" property="claimNo"/></td>
        <td align="center"><bean:write name="prpLprepay1" property="policyNo"/></td>
        <td align="center"><bean:write name="prpLprepay1" property="handlerCode"/></td>
        <td align="center"><bean:write name="prpLprepay1" property="operateDate"/></td>
      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
   <tr class="listtail">
     <td colspan="6">
       共查询出<%= index %>条满足条件的记录
     </td>
   </tr>
    </table>
    </tr>
  </table>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>