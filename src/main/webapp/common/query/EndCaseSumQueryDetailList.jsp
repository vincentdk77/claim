<%--
****************************************************************************
* DESC       ���Ѿ������ܲ�ѯ�����ʾ
* AUTHOR     ��lixiang
* CREATEDATE ��2004-10-09
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

  <title>
  �Ѿ��������嵥
  </title>
  <script src="/claim/common/js/showpage.js"> </script>

  <script language=javascript>
  function reLoadList(){

    document.location.reload()
   }
  </script>

  <html:base/>
</head>

<body  onkeydown="if (event.keyCode==116){ reLoadList()}" >

<base target="_self">


<table  class="common" cellpadding="5" cellspacing="1"  >
<tr><td colspan=8 class="formtitle">�Ѿ������ʾ�б�</td></tr>
   <tr>
		  <td class="centertitle" style="width:8%">���ִ���</td>
      <td class="centertitle" style="width:16%">��������</td>
      <td class="centertitle" >�������</td>
		  <td class="centertitle" >������</td>
		  <td class="centertitle" >������</td>
	    <td class="centertitle" >������������</td>
		  <td class="centertitle" style="width:8%">�ұ�</td>
		  <td class="centertitle" >�⸶���</td>

   </tr>
   <%int index=0;%>
   <logic:notEmpty  name="prpLclaimDto"  property="claimList">
   <logic:iterate id="prpLclaim1"  name="prpLclaimDto"  property="claimList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
  <tr class=common>
      <td align="center"><bean:write name="prpLclaim1" property="riskCode"/></a></td>
      <td align="center"><bean:write name="prpLclaim1" property="riskCodeName"/></td>
      <td align="center"><bean:write name="prpLclaim1" property="compensateNo"/></td>
      <td align="center"><bean:write name="prpLclaim1" property="claimNo"/></td>
      <td align="center"><bean:write name="prpLclaim1" property="policyNo"/></td>
      <td align="center"><bean:write name="prpLclaim1" property="insuredName"/></a></td>

      <td align="center"><bean:write name="prpLclaim1" property="currency"/></td>
      <td align="right"><bean:write name="prpLclaim1" property="sumPaid" format="###,###.00"/></td>

    </tr>
<%        index++;%>
    </logic:iterate>
    </logic:notEmpty>
      <tr class="listtail">
        <td colspan="8">
         ����ѯ��<%= index %>�����������ļ�¼
         <input type="hidden" name="conditions" value=<bean:write name="prpLclaimDto" property="remark"/>>
        </td>
         <tr>
		<td  colspan=8 class=button align=center><input type=button value=" ��  �� " class="button" onclick="window.close()"></td>
	  </tr>
      </tr>
  </table>


  </tr>
</table>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>