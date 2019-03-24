<%--
****************************************************************************
* DESC       ：财产险险代查勘委托书打印页面
* AUTHOR     ：zhuly
* CREATEDATE ：2005-11-15
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%-- 初始化 --%>
<%@include file="PropLocaleHeresyCheckSubmitNoneFormatPrintIni.jsp"%>

<html>
  <head>
    <title>财产险代查勘委托书打印</title>
    <link rel="stylesheet" type="text/css" href="Standard.css">
  </head>

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <!-- 标题部分 -->
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height="40">
        <td colspan="2" height="40" align="center" style="font-family:宋体; font-size:14pt;">            
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>
      <tr>
        <td colspan="2" height="40" align=top align=center style="text-align:center; font-family:宋体; font-size:14pt;">
          <p align="center"><b>财&nbsp;产&nbsp;险&nbsp;代&nbsp;查&nbsp;勘&nbsp;委&nbsp;托&nbsp;书</b></p>
        </td>
      </tr>
      <tr>
        <td align="right" colspan="2" style="font-family:宋体; font-size:10pt;">NO：<ins>&nbsp;<%=strRegistNo%>&nbsp;</ins></td>
      </tr>
    </table>  
   <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse"  bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
   
  <tr>
    <td colspan="7" height="35"> <ins>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</ins>分公司/支公司： </td>
  </tr>
  <tr>
    <td width="38"  height="25">&nbsp;</td>
    <td colspan="6"><p>我司承保的标的已出险，现委托贵公司代为处理有关理赔事宜。 </p></td>
  </tr>
  <tr>
    <td   height="25">&nbsp;</td>
    <td colspan="6"><p>A. 承保及出险等情况： </p></td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td width="9">&nbsp;</td>
    <td colspan="2"> 被保险人名称： </td>
    <td colspan="2" id="tdInsuredName">&nbsp;</td>
    <td width="218">&nbsp;</td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2"> 标的名称： </td>
    <td width="190" id="tdLossName">&nbsp;</td>
    <td width="87" > 出险地址： </td>
    <td id="tdDamageAddress">&nbsp;</td>
  </tr>
  <tr  height="25">
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2"> 保单号码： </td>
    <td id="tdPolicyNo">&nbsp;</td>
    <td> 出险时间： </td>
    <td id="tdDamageStartDate">&nbsp;</td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2"> 保险金额： </td>
    <td id="tdSumAmount">&nbsp;</td>
    <td> 联 系 人： </td>
    <td id="tdLinkerName">&nbsp;</td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2"> 保险期限： </td>
    <td id="tdDate">&nbsp;</td>
    <td> 电话、地址： </td>
    <td id="tdPhoneNumber">&nbsp;</td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td colspan="6"><p>B. 委托事项（需要委托的，请打 √ ）： </p></td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td width="25">&nbsp;□</td>
    <td colspan="4"><p>现场查勘、调查出险主要原因并出具现场查勘报告。 </p></td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;□</td>
    <td colspan="4"><p>安排对保险标的损失检验和确定损失金额。 </p></td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;□</td>
    <td colspan="4"><p>提供标的损失照片及事故现场照片。 </p></td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;□</td>
    <td colspan="4"> 安排保险标的在当地进行修复、定价并收集承修协议书及发票。 </td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;□</td>
    <td colspan="4"> 协助被保险人对受损物资进行清点、施救，并及时、合理的处理。 </td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;□</td>
    <td colspan="4"><p>要求被保险人提供与定损理赔有关 的 保单正本或复印件、 财务报表、库存记录、设备清册、修复发票等资料。 </p></td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;□</td>
    <td colspan="4"><p> 提供并要求被保险人填写我司相关内部印制单证（如查账笔录、损失清单等）并进行收集。 </p></td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;□</td>
    <td colspan="4"> 请将上述材料和照片邮寄或由被保险人转交给我公司。 </td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td colspan="6"><p>C ． 如果估损金额超过<ins>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</ins>万元，请书面通知我司，得到答复后再作处理。 </p></td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td colspan="6"><p><br>对贵司的大力协助，深表谢意！ </p></td>
  </tr>
  <tr>
    <td colspan="7" height="25">&nbsp;</td>
  </tr>
  <tr  >
    <td height="35">&nbsp;</td>
    <td colspan="3">我司电话：</td>
    <td><%=phoneNumber%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font align="right">传真：<%=faxNumber%></font></td>
    <td align="right">联系人：<%=manager%></td>
    <td></td>
  </tr>
  <tr>
    <td height="35">&nbsp;</td>
    <td colspan="3">地&nbsp;&nbsp;址：</td>
    <td><%=addressCName%></td>
    <td align="right">邮&nbsp;&nbsp;编：<%=postCode%></td>
    <td></td>
  </tr>
  <tr>
    <td colspan="7" height="30">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="7" height="25" align="right"><%=comCName%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>
  <tr>
    <td colspan="7" height="25" align="right">年&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
   </table>
  	<!-- 按钮部分 -->
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
