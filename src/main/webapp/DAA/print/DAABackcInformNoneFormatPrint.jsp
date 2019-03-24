<%--
****************************************************************************
* DESC       ：机动车辆回勘通知书打印打印页面
* AUTHOR     ：zhaozhuo
* CREATEDATE ：2005-04-13
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>


<html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns="http://www.w3.org/TR/REC-html40">
  <head>
    <title>回勘通知书打印</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  </head>


<body bgcolor="#FFFFFF" onload="">
    <form name="fm">
          </form>

          <p height="40" align=top align=center style="text-align:center; font-family:宋体; font-size:14pt;">
          <B> 回勘通知书 </b></p>

         <br>
         <br>

      <p style="text-align: left">
        <font  width="40%" style="font-family:宋体; font-size:14pt" size="20" >承修厂<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>： </font>
        <br>
      </p>

      <p style="text-align: left">
        <font  width="40%" style="font-family:宋体; " size="2" >&nbsp;&nbsp;&nbsp;</font>
        <font  width="40%" style="font-family:宋体; font-size:14pt" size="20" >由贵厂承修的</font>
        <font  width="40%" style="font-family:宋体; font-size:14pt" size="20" >&nbsp</font>
        <font  width="40%" style="font-family:宋体; font-size:14pt" size="20" >号车辆，已经由我司定损完毕。鉴于该车的车损情况，为保证车辆的修复质量，同时维护被保险人的合法权益，
        <font  width="40%" style="font-family:宋体; font-size:14pt" size="20" > <b>请贵厂于车辆修复出厂前一天通知我司回勘验车，待验车合格后维修车辆方可正式出厂。</b> </font>
      </p>
      <br>
      <p style="text-align: left">&nbsp;&nbsp;&nbsp;
        <font  width="40%" style="font-family:宋体; font-size:14pt" size="20" >
      未经我司回勘，定损金额及项目不能作为索赔最终依据，我司有权根据案情，对定损金额和项目作出调整。
      </p>
      <p style="text-align: left">&nbsp;&nbsp;&nbsp;
        <font  width="40%" style="font-family:宋体; font-size:14pt" size="20" >
        特此通知</p>
      <p style="text-align:right">
        <font style="font-size: 14.0pt; line-height: 150%;font-family: 宋体">中国大地财产保险股份有限公司有限公司</font>
      </p>
      <p style="text-align:right">
        <font style="font-size: 14.0pt; line-height: 150%;font-family: 宋体">深圳分公司</font>
      </p>
      <p style="font-size: 14.0pt; line-height: 150%; font-family: 宋体">查勘人：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></p>
      <p style="font-size: 14.0pt; line-height: 150%; font-family: 宋体">厂方签收：<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></p>

      <%-- include打印按钮 --%>
      <jsp:include page="/common/print/PrintButton.jsp" />

  </body>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html>
