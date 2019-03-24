<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>
<html>
<head>
<title>意健险调查主表</title>
</head>
<link href="/claim/css/Standard.css" rel="stylesheet" type="text/css">
<table width="100%" height="100%" border="0" cellpadding="5" cellspacing="0">

  <tr>
    <td align="center" valign="top">
       <table border="0" cellpadding="5" cellspacing="1" class="common">
        <tr class=listtitle>
          <td colspan="4" align="center">意健险调查主表</td>
        </tr>
        <tr class=common>
          <td width="20%" >报案号码：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="registNo" /></td>
          <td width="20%" >调查次数：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="times" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >调查号：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkNo" /></td>
          <td width="20%" >发起节点：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="certiType" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >发起节点的业务号码：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="certiNo" /></td>
          <td width="20%" >险种代码：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="riskCode" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >保单号码：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="policyNo" /></td>
          <td width="20%" >调查类型：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkType" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >调查内容简要描述：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkContext" /></td>
          <td width="20%" >调查对象：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkObject" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >调查对象描述：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkObjectDesc" /></td>
          <td width="20%" >调查方式：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkNature" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >调查起始日期：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkDate" /></td>
          <td width="20%" >调查起始时间：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkHour" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >调查结束日期：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkEndDate" /></td>
          <td width="20%" >调查结束时间：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkEndHour" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >调查地点：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkSite" /></td>
          <td width="20%" >事故原因代码：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="damageCode" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >事故原因说明：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="damageName" /></td>
          <td width="20%" >事故类型代码：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="damageTypeCode" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >事故类型说明：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="damageTypeName" /></td>
          <td width="20%" >调查人代码：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="checkerCode" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >审核人代码：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="approverCode" /></td>
          <td width="20%" >审核日期：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="approverDate" /></td>
        </tr>
        <tr class=common>
          <td width="20%" >审核状态：</td>
          <td width="30%" ><bean:write name="prpLacciCheckDto" property="approverStatus" /></td>
          <td width="20%" >备注：</td>
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
