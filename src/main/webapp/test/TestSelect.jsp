<%--
****************************************************************************
* DESC       ������select
* AUTHOR     ��weishixin
* CREATEDATE ��2004-08-04
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
    <title>
      ����ѡ��
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/test/SelectCode.js"> </script>
 </head>
<body class="interface" >
    <form name=fm action="" method="post" >
        <select class='common' style="width:110" name="nodeType" onchange="return selectCode(this);">
            <option value="TASKCODE_LPBA">����</option>
            <option value="TASKCODE_LPLA">����</option>
            <option value="TASKCODE_LPCK">�鿱</option>
            <option value="TASKCODE_LPPA">����</option>
            <option value="TASKCODE_LPDD">����</option>
        </select>

        <select class='common' style="width:200" name="personList" >
            <option value="1">��A0001</option>
            <option value="2">��A0002</option>
            <option value="3">��A0003</option>
            <option value="4">��A0004</option>
        </select>
    </form>
</body>
  <!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>