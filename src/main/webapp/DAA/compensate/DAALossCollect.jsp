<%--
****************************************************************************
* DESC       ��ʵ��¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-05-19
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>

<%@page errorPage="/UIErrorPage"%>
<html:html locale="true">
<head>
    <!--��title����-->
    <title>
    	����ҳ��
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/compensate/js/DAACompensateEdit.js"></script>
    <script language=javascript>
    	function loadForm()
    	{
    		var arrayItem    = new Array();
    		arrayItem = window.opener.getLoss();

    	  var strContent = "";
    	  strContent = strContent + "<table class=common cellpadding='5' cellspacing='1'>";
    	  strContent = strContent + "  <tr class=listtitle>";
    	  strContent = strContent + "    <td >�ձ�����</td>";
    	  strContent = strContent + "    <td >��Ŀ����</td>";
    	  strContent = strContent + "    <td >������</td>";
    	  strContent = strContent + "    <td >�⳥���</td>";
    	  strContent = strContent + "  </tr>";

    	  for(var i=0;i<arrayItem.length;i++)
    	  {
    	    var trClass="";
    	    if( i % 2 == 0 )
    	      trClass = "listodd";
    	    else
    	      trClass = "listeven";

    	    strContent = strContent + "  <tr class="+ trClass +">";
    	    strContent = strContent + "    <td>"+ arrayItem[i].LossKindName +"</td>";
    	    strContent = strContent + "    <td>"+ arrayItem[i].LossName +"</td>";
    	    strContent = strContent + "    <td align=right>"+ point(round(arrayItem[i].LossSumLoss,2),2) +"</td>";
    	    strContent = strContent + "    <td align=right>"+ point(round(arrayItem[i].LossRealPay,2),2) +"</td>";
    	    strContent = strContent + "  </tr>";
    	  }
    	  strContent = strContent + "</table>";
    	  divContent.innerHTML = strContent;
    	}
    </script>
</head>

<%-- ����loadForm ��ʼ��ҳ�� --%>
<body class="interface" onload="loadForm();">
  <div id=divContent></div>
  <table class=common cellpadding="5" cellspacing="1">
    <tr>
      <td align=center>
       <input type="button" value="�ر�" name = 'button_Peril_Close_Context' class="button" alt="�ر�" onclick="window.close();">
      </td>
    </tr>
  </table>
</body>
<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>