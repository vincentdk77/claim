<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>
<html>
<head>
<title>�⽡�յ�������</title>
</head>
<link href="/claim/css/Standard.css" rel="stylesheet" type="text/css">
<table width="100%" height="100%" border="0" cellpadding="5" cellspacing="0">

  <tr>
    <td align="center" valign="top">
       <table border="0" cellpadding="5" cellspacing="1" class="common">
        <tr class=listtitle>
          <td colspan="4" align="center">�⽡�յ�������</td>
        </tr>
        <tr class=common>
          <td width="20%" >�������룺</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="registNo" /></td>
          <td width="20%" >���������</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="times" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >����ţ�</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkNo" /></td>
          <td width="20%" >����ڵ㣺</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="certiType" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >����ڵ��ҵ����룺</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="certiNo" /></td>
          <td width="20%" >���ִ��룺</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="riskCode" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >�������룺</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="policyNo" /></td>
          <td width="20%" >�������ͣ�</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkType" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >�������ݼ�Ҫ������</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkContext" /></td>
          <td width="20%" >�������</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkObject" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >�������������</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkObjectDesc" /></td>
          <td width="20%" >���鷽ʽ��</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkNature" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >������ʼ���ڣ�</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkDate" /></td>
          <td width="20%" >������ʼʱ�䣺</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkHour" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >����������ڣ�</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkEndDate" /></td>
          <td width="20%" >�������ʱ�䣺</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkEndHour" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >����ص㣺</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkSite" /></td>
          <td width="20%" >�¹�ԭ����룺</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="damageCode" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >�¹�ԭ��˵����</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="damageName" /></td>
          <td width="20%" >�¹����ʹ��룺</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="damageTypeCode" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >�¹�����˵����</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="damageTypeName" /></td>
          <td width="20%" >�����˴��룺</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkerCode" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >����˴��룺</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="approverCode" /></td>
          <td width="20%" >������ڣ�</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="approverDate" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >���״̬��</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="approverStatus" /></td>
          <td width="20%" >��ע��</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="remark" /></td>
        </tr>
      </table>
       &nbsp; <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr align="center">
          <td><a href="#" onclick="javascript:history.back();"><img src="/claim/images/btnBack.gif" width="75" height="20" border="0"></a></td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html>
