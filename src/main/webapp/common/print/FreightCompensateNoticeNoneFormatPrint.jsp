<%--

****************************************************************************

* DESC       ：货运险赔案终结报告书清单打印

* AUTHOR     ：wangwei

* CREATEDATE ：2005-5-22

* MODIFYLIST ：   id       Date            Reason/Contents

*          ------------------------------------------------------

****************************************************************************/

--%>

<%@ page contentType="text/html; charset=GBK" %>



<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>



<%-- 初始化 --%>

<%@include file="FreightCompensateNoticeNoneFormatPrintIni.jsp"%>



<html>

  <head>

    <title>货运险赔案终结报告书清单打印</title>

    <link rel="stylesheet" type="text/css" href="Standard.css">

    <jsp:include page="/common/pub/StaticJavascript.jsp" />

  </head>



  <body bgcolor="#FFFFFF" onload="loadForm();">

    <!-- 标题部分 -->

    <form name="fm">

    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">

      <tr>

        <td colspan="2" height="40" align=top align=center style="text-align:center; font-family:宋体; font-size:14pt;">

          <B>货运险赔案终结报告书<B>

        </td>

      </tr>

    </table>                                                                                             

  <strong><font size="2">立案号:<%= prpLclaimDto.getCaseNo() %></font></strong>

<table border=1 width="70%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">

  <tr>

    <td width="107">被保险人</td>

    <td width="152" id="tdInsuredName"><%= prpLclaimDto.getInsuredName() %></td>

    <td width="72" >总公司案号</td>

    <td width="182" >&nbsp;</td>

  </tr>

  <tr>

    <td>货物名称</td>

    <td>&nbsp;</td>

    <td >保单号码</td>

    <td id="tdPolicyNo"><%= prpLclaimDto.getPolicyNo() %></td>

  </tr>

  <tr>

    <td >保险金额</td>

    <td id="tdSumAmount"><%= prpLclaimDto.getSumAmount() %></td>

    <td>预约协议号</td>

    <td>&nbsp;</td>

  </tr>

  <tr>

    <td >承保险别</td>

    <td>&nbsp;</td>

    <td>估损金额</td>

    <td>&nbsp;</td>

  </tr>

  <tr>

    <td >出险日期</td>

    <td><%= strStartDate %></td>

    <td>出险地点</td>

    <td id="tdDamageAddress"><%= prpLclaimDto.getDamageAddress() %></td>

  </tr>

  <tr>

    <td>出险原因</td>

    <td id="tdDamageName"><%= prpLclaimDto.getDamageName() %></td>

    <td>承运工具</td>

    <td>&nbsp;</td>

  </tr>

  <tr>

    <td >承运人</td>

    <td>&nbsp;</td>

    <td>赔付金额</td>

    <td>&nbsp;</td>

  </tr>

  <tr>

    <td >追回金额</td>

    <td>&nbsp;</td>

    <td>结案日期</td>

    <td><%= strEndCaseDate %></td>

  </tr>

  <tr>

    <td >分保比例</td>

    <td colspan="3">&nbsp;</td>

  </tr>

  <tr>

    <td >共损理算人</td>

    <td colspan="3">&nbsp;</td>

  </tr>

  <tr>

    <td > <p>共损理算师</p></td>

    <td colspan="3"> <p>&nbsp;</p></td>

  </tr>

  <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

</table>

</form>

 <!--include打印按钮-->

    <jsp:include page="/common/print/PrintButton.jsp" />

  </body>

</html>

