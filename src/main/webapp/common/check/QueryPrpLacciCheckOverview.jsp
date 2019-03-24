<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>
<html>
<head>
<link href="/claim/css/Standard.css" rel="stylesheet" type="text/css">
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
<html:form action="/processPrpLacciCheck.do?actionType=query">
<html:hidden property="rowsPerPage"/>
<html:hidden property="taskCode"/>
<html:hidden property="groupCode"/>

      <table border="0" cellpadding="5" cellspacing="1" class="common">
        <tr class=listtitle>
          <td colspan="4" >�����⽡�յ�������</td>
        </tr>
        <tr class=common>
          <td width="20%" >�������룺</td>
          <td width="30%" > <input name="prpLacciCheckRegistNo" type="text" class="common"></td>
          <td width="20%" >���������</td>
          <td width="30%" > <input name="prpLacciCheckTimes" type="text" class="common"></td>
        </tr>
        <tr class=common>
          <td width="20%" >����ţ�</td>
          <td width="30%" > <input name="prpLacciCheckCheckNo" type="text" class="common"></td>
          <td width="20%" >����ڵ㣺</td>
          <td width="30%" > <input name="prpLacciCheckCertiType" type="text" class="common"></td>
        </tr>
        <tr class=common>
          <td width="20%" >����ڵ��ҵ����룺</td>
          <td width="30%" > <input name="prpLacciCheckCertiNo" type="text" class="common"></td>
          <td width="20%" >���ִ��룺</td>
          <td width="30%" > <input name="prpLacciCheckRiskCode" type="text" class="common"></td>
        </tr>
        <tr class=common>
          <td width="20%" >�������룺</td>
          <td width="30%" > <input name="prpLacciCheckPolicyNo" type="text" class="common"></td>
          <td width="20%" >�������ͣ�</td>
          <td width="30%" > <input name="prpLacciCheckCheckType" type="text" class="common"></td>
        </tr>
        <tr class=common>
          <td width="20%" >�������ݼ�Ҫ������</td>
          <td width="30%" > <input name="prpLacciCheckCheckContext" type="text" class="common"></td>
          <td width="20%" >�������</td>
          <td width="30%" > <input name="prpLacciCheckCheckObject" type="text" class="common"></td>
        </tr>
        <tr class=common>
          <td width="20%" >�������������</td>
          <td width="30%" > <input name="prpLacciCheckCheckObjectDesc" type="text" class="common"></td>
          <td width="20%" >���鷽ʽ��</td>
          <td width="30%" > <input name="prpLacciCheckCheckNature" type="text" class="common"></td>
        </tr>
        <tr class=common>
          <td width="20%" >������ʼ���ڣ�</td>
          <td width="30%" > <input name="prpLacciCheckCheckDate" type="text" class="common"></td>
          <td width="20%" >������ʼʱ�䣺</td>
          <td width="30%" > <input name="prpLacciCheckCheckHour" type="text" class="common"></td>
        </tr>
        <tr class=common>
          <td width="20%" >����������ڣ�</td>
          <td width="30%" > <input name="prpLacciCheckCheckEndDate" type="text" class="common"></td>
          <td width="20%" >�������ʱ�䣺</td>
          <td width="30%" > <input name="prpLacciCheckCheckEndHour" type="text" class="common"></td>
        </tr>
        <tr class=common>
          <td width="20%" >����ص㣺</td>
          <td width="30%" > <input name="prpLacciCheckCheckSite" type="text" class="common"></td>
          <td width="20%" >�¹�ԭ����룺</td>
          <td width="30%" > <input name="prpLacciCheckDamageCode" type="text" class="common"></td>
        </tr>
        <tr class=common>
          <td width="20%" >�¹�ԭ��˵����</td>
          <td width="30%" > <input name="prpLacciCheckDamageName" type="text" class="common"></td>
          <td width="20%" >�¹����ʹ��룺</td>
          <td width="30%" > <input name="prpLacciCheckDamageTypeCode" type="text" class="common"></td>
        </tr>
        <tr class=common>
          <td width="20%" >�¹�����˵����</td>
          <td width="30%" > <input name="prpLacciCheckDamageTypeName" type="text" class="common"></td>
          <td width="20%" >�����˴��룺</td>
          <td width="30%" > <input name="prpLacciCheckCheckerCode" type="text" class="common"></td>
        </tr>
        <tr class=common>
          <td width="20%" >����˴��룺</td>
          <td width="30%" > <input name="prpLacciCheckApproverCode" type="text" class="common"></td>
          <td width="20%" >������ڣ�</td>
          <td width="30%" > <input name="prpLacciCheckApproverDate" type="text" class="common"></td>
        </tr>
        <tr class=common>
          <td width="20%" >���״̬��</td>
          <td width="30%" > <input name="prpLacciCheckApproverStatus" type="text" class="common"></td>
          <td width="20%" >��ע��</td>
          <td width="30%" > <input name="prpLacciCheckRemark" type="text" class="common"></td>
        </tr>
      </table>
      &nbsp; <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr align="center">
          <td><a href="#" onclick="submitForm()"><img src="/claim/images/btnEnter.gif" width="75" height="20" border="0"></a></td>
        </tr>
      </table>

<app:codeInput/>
</html:form>
 <jsp:include page="/common/pub/StaticJavascript.jsp" />
<script language="javascript">
   function submitForm(){
      fm.submit();
   }
 </script>
</body>
</html>
