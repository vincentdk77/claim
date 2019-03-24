<%--
****************************************************************************
* DESC       ：货运险查勘报告清单打印
* AUTHOR     ：wangwei
* CREATEDATE ：2005-5-22
* MODIFYLIST ：   id       Date            Reason/Contents
    建议打印设置：上
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page import="java.util.*"%>

<%-- 初始化 --%>
<%@include file="FreightCheckReportNoneFormatPrintIni.jsp"%>

<html>
  <head>
    <title>货运险查勘报告清单打印</title>
    <link rel="stylesheet" type="text/css" href="Standard.css">
  </head>

  <body bgcolor="#FFFFFF">
    <!-- 标题部分 -->

    <table width="80%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr>
        <td colspan="2" height="40" align="center">
          <Img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>
      <tr>
        <td colspan="2" height="40" align=top align=center style="text-align:center; font-family:宋体; font-size:14pt;">
          <B>货 运 险 查 勘 报 告<B>
        </td>
      </tr>
      <tr>
        <td colspan="2" height="15" align=right>
          <font style=" font-family:宋体; font-size:10pt;"> &nbsp;&nbsp;报案号:<%=strRegistNo%></font>
        </td>
      </tr>
    </table>
    <table border="1" width="88%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse;font-family:宋体; font-size:10pt;" bordercolor="#111111" >
<tr>
    <td width="87" height="25"> &nbsp;&nbsp;被保险人 </td>
    <td width="199">&nbsp;<%=strInsuredName%></td>
    <td width="80"> &nbsp;&nbsp;货主名称 </td>
    <td width="206">&nbsp;<%=strAppliName%></td>
  </tr>
  <tr>
    <td  height="25"> &nbsp;&nbsp;保险单号 </td>
    <td>&nbsp;<%=strPolicyNo%></td>
    <td> &nbsp;&nbsp;批单号 </td>
    <td>&nbsp;<%=strEndorseNo%></td>
  </tr>
  <tr>
    <td height="25">&nbsp;&nbsp; 出险地点 </td>
    <td>&nbsp;<%=strCheckSite%></td>
    <td>&nbsp;&nbsp; 出险原因 </td>
    <td>&nbsp;<%=strDamageName%></td>
  </tr>
  <tr>
    <td height="25"> &nbsp;&nbsp;货物名称 </td>
    <td>&nbsp;<%=strValue1%></td>
    <td> &nbsp;&nbsp;报损金额 </td>
    <td>&nbsp;<%=strEstimateLoss%></td>
  </tr>
  <tr>
    <td height="25"> &nbsp;&nbsp;报案时间 </td>
    <td>&nbsp;<%=strReportDate%></td>
    <td> &nbsp;&nbsp;出险时间 </td>
    <td>&nbsp;<%=strDamageStartDate%></td>
  </tr>
  <tr>
    <td height="25">&nbsp;&nbsp; 运输方式 </td>
    <td>&nbsp;<%=strConveyance%></td>
    <td>&nbsp;&nbsp; 运输工具 </td>
    <td>&nbsp;<%=strBLName%></td>
  </tr>
  <tr>
    <td height="25">&nbsp;&nbsp; 运输路线 </td>
    <td>&nbsp;<%=strTPath%></td>
    <td>&nbsp;&nbsp; 起运日期 </td>
    <td>&nbsp;<%=strCheckDate%></td>
  </tr>
  <tr>
    <td height="25">&nbsp;&nbsp; 提单/运单 </td>
    <td>&nbsp;<%=strLadingNo%></td>
    <td>&nbsp;&nbsp; 承保公司 </td>
    <td>&nbsp;<%=strComCName%></td>
  </tr>
  <tr>
    <td height="25">&nbsp;&nbsp; 联系人 </td>
    <td>&nbsp;<%=strLinkerName%></td>
    <td>&nbsp;&nbsp; 联系方式 </td>
    <td>&nbsp;<%=strPhoneNumber%></td>
  </tr>
  <tr>
    <td colspan="4" height="400" valign="top"><p>请填写本案出险原因、经过以及损失处理情况；估计全案损失并填写查勘人意见。 </p>
	<%=strContext%>
	</td>
  </tr>
  <tr>
    <td colspan="4" height="60"><p>&nbsp;查勘时间：<%=CheckDate%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;查勘地点：<%=CheckSite%> </p>
      <p>&nbsp; </p>
    &nbsp;查勘人：<%=strChecker1%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 当事人签名： &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp; 月&nbsp;&nbsp; 日<br> <br></td>
  </tr>
    </table>
   <!--include打印按钮-->
  <jsp:include page="/common/print/PrintButton.jsp" />
  </body>
</html>
