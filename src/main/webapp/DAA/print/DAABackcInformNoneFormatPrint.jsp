<%--
****************************************************************************
* DESC       �����������ؿ�֪ͨ���ӡ��ӡҳ��
* AUTHOR     ��zhaozhuo
* CREATEDATE ��2005-04-13
* MODIFYLIST ��   id       Date            Reason/Contents
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
    <title>�ؿ�֪ͨ���ӡ</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  </head>


<body bgcolor="#FFFFFF" onload="">
    <form name="fm">
          </form>

          <p height="40" align=top align=center style="text-align:center; font-family:����; font-size:14pt;">
          <B> �ؿ�֪ͨ�� </b></p>

         <br>
         <br>

      <p style="text-align: left">
        <font  width="40%" style="font-family:����; font-size:14pt" size="20" >���޳�<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>�� </font>
        <br>
      </p>

      <p style="text-align: left">
        <font  width="40%" style="font-family:����; " size="2" >&nbsp;&nbsp;&nbsp;</font>
        <font  width="40%" style="font-family:����; font-size:14pt" size="20" >�ɹ󳧳��޵�</font>
        <font  width="40%" style="font-family:����; font-size:14pt" size="20" >&nbsp</font>
        <font  width="40%" style="font-family:����; font-size:14pt" size="20" >�ų������Ѿ�����˾������ϡ����ڸó��ĳ��������Ϊ��֤�������޸�������ͬʱά���������˵ĺϷ�Ȩ�棬
        <font  width="40%" style="font-family:����; font-size:14pt" size="20" > <b>����ڳ����޸�����ǰһ��֪ͨ��˾�ؿ��鳵�����鳵�ϸ��ά�޳���������ʽ������</b> </font>
      </p>
      <br>
      <p style="text-align: left">&nbsp;&nbsp;&nbsp;
        <font  width="40%" style="font-family:����; font-size:14pt" size="20" >
      δ����˾�ؿ����������Ŀ������Ϊ�����������ݣ���˾��Ȩ���ݰ��飬�Զ��������Ŀ����������
      </p>
      <p style="text-align: left">&nbsp;&nbsp;&nbsp;
        <font  width="40%" style="font-family:����; font-size:14pt" size="20" >
        �ش�֪ͨ</p>
      <p style="text-align:right">
        <font style="font-size: 14.0pt; line-height: 150%;font-family: ����">�й���زƲ����չɷ����޹�˾���޹�˾</font>
      </p>
      <p style="text-align:right">
        <font style="font-size: 14.0pt; line-height: 150%;font-family: ����">���ڷֹ�˾</font>
      </p>
      <p style="font-size: 14.0pt; line-height: 150%; font-family: ����">�鿱�ˣ�<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></p>
      <p style="font-size: 14.0pt; line-height: 150%; font-family: ����">����ǩ�գ�<u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u></p>

      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />

  </body>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html>
