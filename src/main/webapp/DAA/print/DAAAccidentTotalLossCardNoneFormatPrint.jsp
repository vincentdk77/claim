<%--
****************************************************************************
* DESC       ：事故车辆全损单页面
* AUTHOR     ：caopeng
* CREATEDATE ：2005-12-09
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
  <%-- 初始化 --%>
<%@include file="DAAAccidentTotalLossCardNoneFormatPrintIni.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>事故车辆全损单</title>
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
</head>

<body>
<table width="669" align="center" cellspacing="0" cellpadding="0" border="0">
  <tr height=30>
    <td colspan="2" align="center" style="font-family:宋体; font-size:14pt;"> <img src="/claim/images/LOGO.jpg"/> </td>
  </tr>
  <tr height=30>
    <td height="35" colspan="2" align=center valign="middle" style="font-family:宋体; font-size:14pt;">
      <center>
        <p><strong>事故车辆全损单</strong></p>
      </center></td>
  </tr>
  <tr height=30>
    <td width="95%" align=center valign="middle" style="font-family:宋体; font-size:10pt;"><p align="right">&nbsp;&nbsp;共&nbsp;&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;第&nbsp;&nbsp;&nbsp;&nbsp;页</p>    </td>
    <td width="5%" align=center valign="middle" style="font-family:宋体; font-size:10pt;">&nbsp;</td>
  </tr>
  <tr height=30>
    <td colspan="2" align=center valign="middle" style="font-family:宋体; font-size:10pt;"><table width="92%" border="1" cellpadding="0" cellspacing="0" bordercolor="111111" style="font-family:宋体; font-size:10pt;">
      <tr>
        <td width="10%" height="25"><div align="center">被保险人</div></td>
        <td colspan="3">&nbsp;</td>
        <td width="12%" height="25"><div align="center">号牌号码</div></td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td height="25"><div align="center">厂牌型号</div></td>
        <td colspan="3">&nbsp;</td>
        <td height="25"><div align="center">车架号码</div></td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td height="25"><div align="center">发动机号</div></td>
        <td colspan="3">&nbsp;</td>
        <td height="25"><div align="center">新车重置价</div></td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td height="25"><div align="center">保险金额</div></td>
        <td colspan="3">&nbsp;</td>
        <td height="25"><div align="center">实际价值</div></td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td height="25"><div align="center">使用年限</div></td>
        <td colspan="3">&nbsp;</td>
        <td height="25"><div align="center">查勘日期</div></td>
        <td colspan="3">&nbsp;</td>
      </tr>
      <tr>
        <td height="25" colspan="2"><div align="center">报&nbsp;&nbsp;废&nbsp;&nbsp;项&nbsp;&nbsp;目</div></td>
        <td width="13%"><div align="center">照片编号</div></td>
        <td width="13%"><div align="center">损失金额</div></td>
        <td height="25" colspan="2"><div align="center">残&nbsp;&nbsp;值&nbsp;&nbsp;项&nbsp;&nbsp;目</div></td>
        <td width="13%"><div align="center">照片编号</div></td>
        <td width="11%"><div align="center">残值金额</div></td>
      </tr>
      <tr>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
      </tr>
      <tr>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
      </tr>
      <tr>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
      </tr>
      <tr>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
      </tr>
      <tr>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
      </tr>
      <tr>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
      </tr>
      <tr>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
      </tr>
      <tr>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
      </tr>
      <tr>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
      </tr>
      <tr>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25" colspan="2">&nbsp;</td>
        <td height="25">&nbsp;</td>
        <td height="25">&nbsp;</td>
      </tr>
      <tr>
        <td height="25" colspan="3"><div align="center">合&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计</div></td>
        <td height="25">&nbsp;</td>
        <td height="25" colspan="3"><div align="center">合&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计</div></td>
        <td height="25">&nbsp;</td>
      </tr>
      <tr>
        <td height="25" colspan="8">经核定损失费合计人民币：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元，达到该车实际价值的&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;%，失去修复价值。</td>
        </tr>
      <tr>
        <td height="25" colspan="8">建议扣除残值人民币：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;，推定全损。</td>
        </tr>
      <tr>
        <td colspan="4"><p>&nbsp;</p>
          <p>&nbsp;</p>
          <p>&nbsp;&nbsp;被保险人：</p>
          <p>&nbsp;</p>
          <p>&nbsp;&nbsp;经办人：</p>
          <p>&nbsp;</p>
          <p>&nbsp;</p>
          <p align="right">年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</p></td>
        <td colspan="4"><p>&nbsp;</p>
          <p>&nbsp;</p>
          <p>&nbsp;&nbsp;保险公司（章）</p>
          <p>&nbsp;</p>
          <p>&nbsp;&nbsp;经办人：</p>
          <p>&nbsp;</p>
          <p>&nbsp;</p>
          <p align="right">年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</p></td>
      </tr>
    </table></td>
  </tr>
</table>
<%-- include打印按钮 --%>
      <jsp:include page="/common/print/PrintButton.jsp" />
  <script language='javascript'>
    function printPage()
    {
      divButton.style.display = "none";
      window.print();
    }
  </script>
</body>
</html>
