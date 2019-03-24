<%--
****************************************************************************
* DESC       ��¼�뵥֤ǰ���뱨����ҳ��
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-07-05
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
  <title>¼�뵥֤</title>
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
<script language="javascript">
  function submitForm()
  {
    fm.buttonNext.disabled = true;
    var ref="";
    for(i=0;i<fm.certifyFlag.length;i++){
      if(fm.certifyFlag[i].checked==true){
        ref = ref+"1";
      } else {
        ref = ref+"0";
      }
    }
    fm.caseFlag.value = ref;
    fm.submit(); //�ύ
  }
</script>
</head>

<body  onload="initPage();">
<form name="fm" action="/claim/certifyBeforeEdit.do"  method="post"  onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1" class="common">
    <tr>  <td colspan=2 class="formtitle">���뱨���ţ���֤�Ǽǣ�</td></tr>
      <tr>
        <td class='title2'  align="center">�����ţ�</td>
        <td class='input2' >
          <input type=text name="RegistNo" class="readonly" readonly value="<%= request.getParameter("RegistNo")%>">
        </td>

      </tr>

      <tr>
        <td class='title2'  align="center">��֤���ͣ�</td>
        <td class='input2' >
          <input type="hidden" name="caseFlag">
          <input type="checkbox" name="certifyFlag" value="0">�����¹�
          <input type="checkbox" name="certifyFlag" value="1">�����¹�
          <input type="checkbox" name="certifyFlag" value="2">�����¹�
          <input type="checkbox" name="certifyFlag" value="3">ȫ������
        </td>
      </tr>
      <tr>
        <td class='button'   align="center" colspan="2">
          <input type="button" class='button' value="��һ��" name="buttonNext" onclick="submitForm();">
        </td>
      </tr>
      <%--
      <tr>
        <td class='common'  align="center">�������:</td>
        <td class='input' >
          <input type="hidden" name="carLossFlag">
          <logic:notEmpty  name="prpLregistDto"  property="registList">
          <logic:iterate id="registList1"  name="prpLregistDto"  property="registList">
            <input type="checkbox" name="carFlag" value="<bean:write name='registList1' property='licenseNo'/>"><bean:write name="registList1" property="licenseNo"/>
          </logic:iterate>
          </logic:notEmpty>
        </td>
      </tr>
      --%>
    </table>
    <input type="hidden" name="editType" value="SELECTCAR">
  </form>
</body>

</html:html>


