<%--
****************************************************************************
* DESC       ��������ʾҳ��
* Author     : ������Ŀ��
* CREATEDATE ��2003-05-22
* MODIFYLIST ��   Name       Date            Reason/Contents
*
****************************************************************************
--%>

<%-- ������ҳ�� --%>
<%@page errorPage="/UIErrorPage"%>

<%-- ����bean�ಿ�� --%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.utility.string.Date"%>
<%@page import="com.sinosoft.utility.string.Str"%>
<%@page import="com.sinosoft.utility.error.*"%>
<%@page import="com.sinosoft.utiall.blsvr.*"%>
<%@page import="com.sinosoft.prpall.dbsvr.pg.*"%>
<%@page import="com.sinosoft.prpall.blsvr.pg.*"%>
<%@page import="com.sinosoft.prpall.schema.*"%>

<%
  //������������
  String strEndorseNo  = request.getParameter("EndorseNo");   //ȡ������

  //�����岿��
  BLPrpPtext     blPrpPtext     = null;   //���Ķ���
  PrpPtextSchema prpPtextSchema = null;   //������PrpPtextSchema����

  if((strEndorseNo == null )||(strEndorseNo.trim().length() == 0))
  {
    throw new UserException(-98,-1014,"UIPtextShow.jsp");
  }

  blPrpPtext = new BLPrpPtext();
  blPrpPtext.query(" EndorseNo = '" + strEndorseNo +"' ORDER BY LineNo",0);
%>

 <html>
  <head>
    <title>����</title>
    <%-- ҳ����ʽ  --%>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  </head>
<body class=interface>
<br><br><br><br><br><br>
  <table class=common cellpadding="5" cellspacing="1">
    <tr>
      <td class=formtitle>
        �鿴����
      </td>
    </tr>
    <tr>
      <td class=input>
        <pre>
          <%=(blPrpPtext.getEndorseText())%>
        </pre>
      </td>
    </tr>
  </table>
</body>
</html>
