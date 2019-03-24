<%--
****************************************************************************
* DESC       ：机动车辆保险索赔申请书页面
* AUTHOR     ：caopeng
* CREATEDATE ：2005-12-06
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
<%@include file="DAAClaimApplyNoneFormatPrintIni.jsp"%>
<html>
  <head>
    <title>机动车辆保险索赔申请书打印</title>
    <link rel="stylesheet" type="text/css" href="Standard.css">
   <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  </head>

  <body bgcolor="#FFFFFF">
  <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td colspan="2" height="40" align="center" style="text-align:center; font-family:宋体; font-size:14pt;"> <span><img src="/claim/images/LOGO.jpg"/></span> </td>
    </tr>
    <tr>
      <td colspan="2" height="40" align=center style="text-align:center; font-family:宋体; font-size:14pt;"> <strong><B>机动车辆保险索赔申请书<B> </b></b></strong></td>
    </tr>
  </table>
  <table width="92%"  border="1" align="center" cellspacing="0" cellpadding="2" bordercolor="#111111" style="border-collapse:collapse; font-family:宋体; font-size:10pt">
    <tr>
      <td width="14%" height="25" align="center">被保险人</td>
      <td height="25" colspan="5"><div align="center"><%=strInsuredName%></div></td>
      <td width="14%" height="25" align="center">保单号码</td>
      <td width="34%" height="25"><div align="center"><%=strPolicyNo%></div></td>
    </tr>
    <tr>
      <td height="25" align="center">厂牌型号</td>
      <td height="25" colspan="5"><div align="center"><%=strBrandName%></div></td>
      <td height="25" align="center">号牌号码</td>
      <td height="25"><div align="center"><%=strLicenseNo%></div></td>
    </tr>
    <tr>
      <td height="25" align="center">出险时间</td>
      <td height="25" colspan="5"><div align="center"><%=strdamageStartDate%>&nbsp;&nbsp;<%=strdamageStartHour%></div></td>
      <td height="25" align="center">出险地点</td>
      <td height="25"><div align="center"><%=strDamageAddress%></div></td>
    </tr>
    <tr>
      <td height="25" align="center">驾驶员姓名</td>
      <td width="15%" height="25"><div align="center"><%=strD1%></div></td>
      <td width="6%">性别</td>
      <td width="6%"><div align="center"><%=strSexName%></div></td>
      <td width="6%">年龄</td>
      <td width="5%"><div align="center"><%=strD3%></div></td>
      <td height="25" align="center">驾驶员号码</td>
      <td height="25"><div align="center"><%=strD2%></div></td>
    </tr>
    <tr>
      <td height="25" align="center">出险类型</td>
      <td height="25" colspan="7"><!--□单方事故&nbsp;&nbsp;&nbsp;&nbsp;□多方事故&nbsp;&nbsp;&nbsp;&nbsp;□多方事故&nbsp;&nbsp;&nbsp;□其他-->
        <div align="left">&nbsp;&nbsp;<%=strDamageTypeName%></div></td>
    </tr>
    <tr>
      <td height="25" align="center">出险原因</td>
      <td height="25" colspan="7"><!--<table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td>□碰撞</td>
            <td>□倾覆</td>
            <td>□盗抢</td>
            <td>□火灾</td>
            <td>□爆炸</td>
            <td>□台风</td>
            <td>□自燃</td>
            <td>□暴雨</td>
            <td>□其他</td>
          </tr>
      </table>-->
        <div align="left">&nbsp;&nbsp;<%=strDamageClause%></div></td>
    </tr>
    <tr>
      <td height="349" colspan="8">
        <table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0" style="font-family:宋体; font-size:10pt">
          <tr>
            <td height="13">&nbsp;出险经过</td>
          </tr>
          <tr>
            <td height="396" valign="top"><br>&nbsp;&nbsp;&nbsp;&nbsp;<%=tempContext%>
         <br><br><br></td>
          </tr>
      </table></td>
    </tr>
    <tr>
      <td height="132" colspan="8"><table width="100%" height="100%"  border="0" cellspacing="0" style="font-family:宋体; font-size:10pt ">
          <tr>
            <td height="43" colspan="5">&nbsp;&nbsp;&nbsp;&nbsp; 兹声明本人所填上述资料均为真实情况，否则，愿放弃保险单之一切权利并承担相应的法律责任。</td>
          </tr>
          <tr>
            <td height="61" colspan="5">&nbsp;</td>
          </tr>
          <tr>
            <td width="28%" height="22">&nbsp;被保险人（报案人）签章：</td>
            <td width="12%">&nbsp;</td>
            <td width="16%">联系电话：</td>
            <td width="18%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td width="26%"><div align="right">&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;月&nbsp;&nbsp;日</div></td>
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
