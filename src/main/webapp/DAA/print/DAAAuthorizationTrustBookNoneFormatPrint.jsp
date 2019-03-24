<%--
****************************************************************************
* DESC       ：授权委托书打印页面
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
  <%@include file="DAAAuthorizationTrustBookNoneFormatPrintIni.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>机动车辆保险授权委托书</title>
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
</head>

<body>
<table width="680" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:'宋体'; font-size:10pt ">
  <tr height=30>
    <td width="100%" align="center" style="font-family:'宋体'; font-size:14pt "> <img src="/claim/images/LOGO.jpg"/> </td>
  </tr>
  <tr height=30>
    <td height="35" align=center valign="middle" style="font-family:宋体; font-size:14pt;">
      <center>
        <p><span>机动车辆保险授权委托书 </span></p>
    </center></td>
  </tr>
  <tr height=30>
    <td height="22" align=left valign="bottom" style="font-family:宋体; font-size:12px;">&nbsp;</td>
  </tr>
  <tr height=30>
    <td align=center valign="top" style="font-family:宋体; font-size:10pt;">      <table width="89%" border="0" cellpadding="0" cellspacing="0" style="font-family:宋体; font-size:10pt;">
        <tr>
          <td colspan="4"><p> 财产保险股份有限公司：</p>
          <p align="center">&nbsp;&nbsp;&nbsp;&nbsp;本人（本公司）在你司投保机动车辆保险（保单号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;），</p>
          <p align="center">现授权并委托&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;代理本人（本公司）向你司办理如下本人（本公司）</p>
          <p align="left">&nbsp;同意之委托事项：</p>
          <table width="620" border="0" cellspacing="0" cellpadding="0" style="font-family:宋体; font-size:10pt;">
            <tr>
              <td width="78" height="30">&nbsp;</td>
              <td width="193" height="30"><div align="left"><span>委托事项</span></div></td>
              <td width="349" height="30"><div align="left"><span>委托意见（请填写“同意”或“不同意”）</span></div></td>
            </tr>
            <tr>
              <td height="30">&nbsp;</td>
              <td height="30"><div align="left"><span>1、提交索赔资料</span></div></td>
              <td height="30"><div align="left"><span><ins>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</ins></span></div></td>
            </tr>
            <tr>
              <td height="30">&nbsp;</td>
              <td height="30"><div align="left"><span>2、签署有关理赔材料</span></div></td>
              <td height="30"><div align="left"><span><ins>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</ins></span></div></td>
            </tr>
            <tr>
              <td height="30">&nbsp;</td>
              <td height="30"><div align="left"><span>3、领取赔款</span></div></td>
              <td height="30"><div align="left"><span><ins>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</ins></span></div></td>
            </tr>
            <tr>
              <td height="30">&nbsp;</td>
              <td height="30"><div align="left"><span>4、签订理赔协议&nbsp;</span></div></td>
              <td height="30"><div align="left"><span><ins>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</ins></span></div></td>
            </tr>
            <tr>
              <td height="30">&nbsp;</td>
              <td height="30"><div align="left"><span>5、其他事宜&nbsp;</span></div></td>
              <td height="30"><div align="left"><span><ins>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</ins></span></div></td>
            </tr>
          </table>          <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;就本委托事宜引起的法律纠纷由本人（本公司）负责，特此声明。</p>
          <p>&nbsp;</p>
          <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
          <table width="620" border="0" cellspacing="0" cellpadding="0" style="font-family:宋体; font-size:10pt;">
            <tr align="center" valign="middle">
              <td width="190" height="50"><span>委托人签章：</span></td>
              <td width="430" height="50">                <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="30%" height="25"><div align="right"><span >身份证号&nbsp;</span> </div></td>
                    <td width="70%" height="25">                      <div align="left">
                      <table width="180" border="1" align="left" cellpadding="0" cellspacing="0" bordercolor="#111111" style="border-collapse:collapse ">
                        <tr>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                        </tr>
                      </table>
                    </div></td>
                  </tr>
                </table>                </td>
            </tr>
            <tr align="center" valign="middle">
              <td height="50">&nbsp;</td>
              <td height="50"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话：</span></td>
            </tr>
            <tr align="center" valign="middle">
              <td height="50"><span>受托人签章：</span></td>
              <td height="50"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="30%" height="25"><div align="right"><span>身份证号&nbsp;</span> </div></td>
                  <td width="70%" height="25"><table width="180" border="1" align="left" cellpadding="0" cellspacing="0" bordercolor="#111111" style="border-collapse:collapse ">
                    <tr>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                      <td>&nbsp;</td>
                    </tr>
                  </table>
                    <div align="left"></div></td>
                </tr>
              </table>    </td>
            </tr>
            <tr align="center" valign="middle">
              <td height="50">&nbsp;</td>
              <td height="50"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话：</span></td>
            </tr>
          </table>          <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
          <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
          <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
          <p>&nbsp;</p>
          <p align="right">年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
          </td>
        </tr>
    </table></td>
  </tr>
</table>
<jsp:include page="/common/print/PrintButton.jsp" />      
      <%--<jsp:include page="/DAA/compensate/DAASpecialPrintButton.jsp" />--%>
</body>
</html>