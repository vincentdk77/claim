<%--

************************************************************

*DESC          : �⽡������������ӡ

*AUTHOR        : wangwei

*CREATEDATE    : 2005-08-18

*MODIFYLIST    :   id       Date            Reason/Contents

*              ---------------------------------------------

************************************************************

--%>



<%@page contentType="text/html; charset=GBK" %>

<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@page import="java.util.*"%>



<!--��ʼ��ҳ��-->

<%@include file="AcciReparationsListNoneFormatPrintIni.jsp" %>



<html>

    <head>

        <title>�⽡������������ӡ</title>

         <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

         <meta http-equiv="Content-Type" content="text/html; charset=gb2312">

    </head>

    <body onload="loadForm();">

        <table width="90%" align="center" cellspacing="0" cellpadding="0" border="0">

            <tr>

                <td colspan="2" height="40" align=top align=center style="text-align:center; font-family:����; font-size:16pt;">

                    <B>�� �� �� �� �� �� ��</B>

                </td>

            </tr>

            <tr>

                <td id="tdCompensateNo" align="center">�������:</td>

                <td id="tdClaimNo" align="center">������:</td>

            </tr>

            <tr>

                <td colspan=2 align="center">

 <textarea style="wrap:hard" rows="15" cols="80" class=readonlyWhite readonly style="overflow:hidden;FONT-SIZE: 10pt"><%= strContext %></textarea>

                </td>

            </tr>

            <tr>

                <td>&nbsp;</td>

            </tr>

            <tr>

                <td colspan=2 align="center" ><B>�����ˣ� <%= strHandlerName %>&nbsp;&nbsp;         

                                             ǩ���ˣ�<%= compensateDto.getPrpLcompensateDto().getUnderWriteName() %>&nbsp;&nbsp;

                                             ǩ�����ڣ�<%= compensateDto.getPrpLcompensateDto().getUnderWriteEndDate() %>  </B></td>

            </tr>

        </table>

        

        <!--include��ӡ��ť-->

        <jsp:include page="/common/print/PrintButton.jsp" />   

    </body>

</html>