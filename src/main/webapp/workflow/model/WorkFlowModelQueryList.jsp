<%--
****************************************************************************
* DESC       : ������ģ���б�
* AUTHOR     ��weishixin
* CREATEDATE ��2004-08-10
* MODIFYLIST ��   id       Date            Reason/Contents
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

  <title>������ģ���б�</title>
  <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>

<body  >

  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr> <td colspan=6 class="formtitle">�������б�</td></tr>
     <tr>
        <td class="centertitle" >ģ���</td>
        <td class="centertitle" >ģ������</td>
        <td class="centertitle" >ģ������</td>
        <td class="centertitle" >������</td>
        <td class="centertitle" >����ʱ��</td>
        <td class="centertitle" >ģ��״̬</td>

     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="swfModelMainDto"  property="modelMainList">
     <logic:iterate id="modelMainList1"  name="swfModelMainDto"  property="modelMainList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
      <tr class=common>  <td align="center"> <a href="/claim/swfModelBeforeEdit.do?editType=EDIT&modelNo=<bean:write name='modelMainList1' property='modelNo'/>"><bean:write name='modelMainList1' property='modelNo'/></a></td>
        <td align="center"><bean:write name="modelMainList1" property="modelName"/></td>
        <td align="center"><bean:write name="modelMainList1" property="modelType"/></td>
        <td align="center"><bean:write name="modelMainList1" property="authorCode"/></td>
        <td align="center"><bean:write name="modelMainList1" property="modifyDate"/></td>
        <td align="center">

        <logic:equal name="modelMainList1" property="modelStatus" value="0">
             δʹ��
        </logic:equal>
        <logic:equal name="modelMainList1" property="modelStatus" value="1">
             ����ʹ��
        </logic:equal>
        <logic:equal name="modelMainList1" property="modelStatus" value="2">
             ��ͣ��
        </logic:equal>
        <logic:equal name="modelMainList1" property="modelStatus" value="3">
             δʹ������
        </logic:equal>
        <logic:equal name="modelMainList1" property="modelStatus" value="4">
             ��ע��
        </logic:equal>
        </td>
      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
      <tr class="listtail">
        <td colspan="6">
         ����ѯ��<%= index %>�����������ļ�¼
        </td>
      </tr>
  </table>
    </table>
    </tr>
  </table>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>