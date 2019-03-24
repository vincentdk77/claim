<%--
****************************************************************************
* DESC       ：批文显示页面
* Author     : 东安项目组
* CREATEDATE ：2003-05-22
* MODIFYLIST ：   Name       Date            Reason/Contents
*
****************************************************************************
--%>

<%-- 错误处理页面 --%>
<%@page errorPage="/UIErrorPage"%>

<%-- 引入bean类部分 --%>
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
  //变量声明部分
  String strEndorseNo  = request.getParameter("EndorseNo");   //取批单号

  //对象定义部分
  BLPrpPtext     blPrpPtext     = null;   //批文对象
  PrpPtextSchema prpPtextSchema = null;   //批单的PrpPtextSchema对象

  if((strEndorseNo == null )||(strEndorseNo.trim().length() == 0))
  {
    throw new UserException(-98,-1014,"UIPtextShow.jsp");
  }

  blPrpPtext = new BLPrpPtext();
  blPrpPtext.query(" EndorseNo = '" + strEndorseNo +"' ORDER BY LineNo",0);
%>

 <html>
  <head>
    <title>批文</title>
    <%-- 页面样式  --%>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  </head>
<body class=interface>
<br><br><br><br><br><br>
  <table class=common cellpadding="5" cellspacing="1">
    <tr>
      <td class=formtitle>
        查看批文
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
