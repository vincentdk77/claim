<%--
****************************************************************************
* DESC       ���᰸�Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-06-28
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
    <!--��title����-->
    <title>�᰸�Ǽ�</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
<script language="javascript">
  function submitForm()
  {
    fm.submit();
  }
</script>
</head>

<body class=interface onload="initPage();" class="interface">
  <form name="fm" method="post" action="/claim/endcaseSave.do?step=step2">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <h3>�᰸�ǼǱ���ɹ���</h3><br>
    <h3>Ҫ���ɹ鵵��,������һ����ť��</h3>
    <hr>
    <input type=hidden name="prpLendcaseClaimNo1" value="<%= request.getAttribute("claimNo") %>">
    <input type="button" name="buttonNext" value="������һ��" class="bigbutton" onclick="submitForm()">
    <input  type="hidden" name=buttonSaveType value="1">
  </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
