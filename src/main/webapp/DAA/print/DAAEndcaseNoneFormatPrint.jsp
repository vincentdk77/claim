<%--
****************************************************************************
* DESC       ：机动车辆保险结案报告书打印页面
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
<%-- 初始化 --%>
<%@include file="DAAEndcaseNoneFormatPrintIni.jsp"%>
<html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns="http://www.w3.org/TR/REC-html40">

<link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">
<body bgcolor="#FFFFFF" onload="loadForm();">
    <form name="fm">
          </form>
          <p height="40" align=center style="font-family:宋体; font-size:14pt;">
          <B> 机动车辆保险结案报告书 </b></p>
      <br>
      <div align="left">
      <table border="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="92%" id="AutoNumber1">
        <tr>
          <td  width="33%" id="tdComName" ></td>
          <td  width="33%" ></td>
          <td  width="33%" id="tdClaimNo" ></td>
        </tr>
        <tr>
          <td  width="33%" id="tdInsuredName" ></td>
          <td  width="33%" id="tdPolicyNo" ></td>
          <td  width="33%" id="tdCaseNo" ></td>
        </tr>
      </table>
      </div>

         <hr>
         <br>
         <br>
         &nbsp;&nbsp;&nbsp;
         <ins>&nbsp;<font id="tdDamageStartDate" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">，驾驶人员（姓名）：</font>
         <ins>&nbsp;<font valign="middle"  width="30%" height="23" id="tdDriverName">&nbsp;</font></ins>
         <font text-align:center">（驾驶证号码：</font>
         <ins>&nbsp;<font valign="middle"  width="30%" height="23" id="tdDrivingLicenseNo">&nbsp;</font></ins>
         <font text-align:center">；驾龄：</font>
         <ins>&nbsp;</ins>
         <font text-align:center">；准驾车型：</font>
         <ins>&nbsp;<font valign="middle"  width="30%" height="23" id="tdDrivingCarType">&nbsp;</font></ins>
         <font text-align:center">）驾驶(号牌号码：</font>
         <ins>&nbsp;<font valign="middle"  width="30%" height="23" id="tdLicenseNo">&nbsp;</font></ins>
         <font text-align:center">；厂牌型号：</font>
         <ins>&nbsp;<font valign="middle"  width="30%" height="23" id="tdBrandName">&nbsp;</font></ins>
         <font text-align:center">)车辆，因</font>
         <ins>&nbsp;<font id="tdDamageTypeName" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">原因发生</font>
         <ins>&nbsp;<font id="tdDamageName" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">（出险原因）事故，造成保险损失。</font>
         <br><br>

         &nbsp;&nbsp;&nbsp;
         <font text-align:center">接到报案后，由</font>
         <ins>&nbsp;<font id="tdChecker1" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">和</font>
         <ins>&nbsp;<font id="tdChecker2" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">同志于</font>
         <ins>&nbsp;<font id="tdCheckDate" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">到</font>
         <ins>&nbsp;<font id="tdDamageAddress" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">（地点）进行了查勘。根据查勘情况以及有关证明材料，认定该事故属</font>
         <ins>&nbsp;<font id="tdRiskCode" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">（险种）保险责任。此次事故经</font>
         <ins>&nbsp;<font id="tdCheckUnitName" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">认定保险人负</font>
         <ins>&nbsp;<font id="tdIndemnityDuty" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">责任，保险人应承担</font>
         <ins>&nbsp;<font id="tdIndemnityDutyRate" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">％的责任。</font>
         <br><br>

         &nbsp;&nbsp;&nbsp;
         <font text-align:center">本车承保情况如下：</font>
         <br>
         <table border="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="92%">
           <tr>
             <td width="20%">投保人：</td>
             <td width="30%" id="tdAppliName"></td>
             <td width="20%">被保险人：</td>
             <td width="30%" id="tdInsuredName1"></td>
           </tr>
           <tr>
             <td>签单日期：</td>
             <td id="tdOperateDate"></td>
             <td>保险期限：</td>
             <td id="tdStartTime"></td>
           </tr>
           <tr>
             <td>总保险金额：</td>
             <td id="tdSumAmount1"></td>
             <td>总责任限额：</td>
             <td id="tdSumAmount2"></td>
           </tr>
           <tr>
             <td>约定分期交费次数：</td>
             <td id="tdPayTimes"></td>
             <td>交费情况：</td>
             <td id="tdSumPremium"></td>
           </tr>
           <tr>
             <td>承保险种</td>
             <td colspan=3></td>
           </tr>
           <tr>
             <td colspan=4 id="tdItemKindInfo"></td>
           </tr>
         </table>
         
         <br>
         &nbsp;&nbsp;&nbsp;
         <font text-align:center">被保险人应交保费：</font>
         <ins>&nbsp;<font id="tdPlanFee" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">元，已缴付：</font>
         <ins>&nbsp;<font id="tdFinishFee" height="25" width="23%"  >&nbsp;</font></ins>
         <font text-align:center">元。</font>
         <br><br>

         &nbsp;&nbsp;&nbsp;
         <font text-align:center">经过（第一现场  第二现场）定损，本次事故核定损失如下：（按险种列明）</font><br>
         <table border="0" cellspacing="0" style="border-collapse: collapse" width="92%">
           <tr height="210" valign=top>
             <td id="tdContext1"></td>
           </tr>
         </table>
         <br>

         &nbsp;&nbsp;&nbsp;
         <font text-align:center">经计算，赔款建议如下：（按险种列明）</font>
         <table border="0" cellspacing="0" style="border-collapse: collapse" width="92%">
           <tr height="80" valign=top>
             <td id="tdContext2"></td>
           </tr>
         </table>

         &nbsp;&nbsp;&nbsp;
         <font text-align:center">&nbsp;&nbsp;&nbsp;&nbsp;赔款总计：</font>
         <ins><font id=tdSumPaid>&nbsp;</font></ins>
         <font text-align:center">元。</font>
         <br>
         <hr>
 
         &nbsp;&nbsp;&nbsp;
         <p style="text-align: right">
           <font text-align:center">报告人：<%=operatorName%></font>
         </p>

        <p style="text-align: right">
          <font  align=left ><%=operateTime%></font>
        </p>
      <%-- include打印按钮 --%>
      <jsp:include page="/common/print/PrintButton.jsp" />
  </form>
  </body>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
    </b>
</html>
