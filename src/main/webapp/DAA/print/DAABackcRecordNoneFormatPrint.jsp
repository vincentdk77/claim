<%--
****************************************************************************
* DESC       ：机动车辆回勘记录打印打印页面
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
    <title>机动车辆回勘记录打印</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
     <script LANGUAGE="JavaScript">
     <!--
      /**
       *@description 设值页面的一些初始化信息
       *@param       无
       *@return      通过返回true,否则返回false
       */
      function initSet()
      {
        return true;
      }
     //-->
     </script>
  </head>


<body bgcolor="#FFFFFF" onload="initSet();">
    <form name="fm">
          </form>


          <p height="40" align=top align=center style="text-align:center; font-family:宋体; font-size:14pt;">
          <B> 机动车辆回勘记录 </b></p>



    <table border="1" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" height="660" >
      <tr>
        <td width="50%" colspan="2" height="50">被保险人：
        <font width="50%" colspan="2" height="50" id="tdInsuredName">&nbsp;</font>
        </td>
               <td width="50%" height="50">回勘时间：&nbsp;&nbsp;&nbsp; 年&nbsp;&nbsp;&nbsp; 月&nbsp;&nbsp;&nbsp;
               日</td>
      </tr>
      <tr>
        <td width="25%" height="50">车牌号：
          <font width="25%" height="50" id="tdLicenseNo">&nbsp;</td>
        <td width="25%" height="50">车型
           <font width="25%" height="50" id="tdBrandName">&nbsp;</td>
        <td width="50%" height="50">标的车&nbsp;&nbsp;
        <input type="checkbox" name="C1" value="ON">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        第三者车&nbsp;&nbsp; <input type="checkbox" name="C1" value="ON"> </td>
      </tr>
      <tr>
        <td width="100%" colspan="3" height="261">　<p>回勘情况： </p>
          <p>A：有无按合同约定配件更换项目更换&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          全部&nbsp;&nbsp; <input type="checkbox" name="C1" value="ON">&nbsp;&nbsp;
          部分&nbsp;&nbsp; <input type="checkbox" name="C1" value="ON"></p>
          <p>B: 有无按合同约定更换损坏配件&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          正厂&nbsp;&nbsp; <input type="checkbox" name="C1" value="ON">&nbsp;&nbsp;
          合同规定&nbsp;&nbsp; <input type="checkbox" name="C1" value="ON">&nbsp;&nbsp;
          其他&nbsp;&nbsp; <input type="checkbox" name="C1" value="ON"></p>
          <p>C:&nbsp; 有无按合同约定维修项目维修&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          全部&nbsp;&nbsp; <input type="checkbox" name="C1" value="ON">&nbsp;&nbsp;
          部分&nbsp;&nbsp; <input type="checkbox" name="C1" value="ON"> </p>
          <p>D:&nbsp; 未按合同约定更换的配件名称及金额</p>
          <p>E:&nbsp; 未按合同约定维修的项目名称及金额</p>
          <p>　
         </td>
      </tr>
      <tr>
         <td width="100%" colspan="3" height="156">
           　<p>核损人员处理意见： </p>
           <p>　</p>
           <p>回勘人员签字：</p>
           <p style="text-align:right">年&nbsp;&nbsp;&nbsp; 月&nbsp;&nbsp;&nbsp; 日
         </td>
      </tr>
      <tr>
        <td width="100%" colspan="3" height="156">　<p>承修厂确认意见： </p>
          <p>　</p>
          <p>签章：</p>
          <p style="text-align:right">年&nbsp;&nbsp;&nbsp; 月&nbsp;&nbsp;&nbsp; 日
        </td>
      </tr>
    </table>

    <p>本记录表内部流转，作为理算依据归档。</p>



 <%-- include打印按钮 --%>
      <jsp:include page="/common/print/PrintButton.jsp" />
  </form>
  </body>

<jsp:include page="/common/pub/StaticJavascript.jsp" />

    </b>
</html>