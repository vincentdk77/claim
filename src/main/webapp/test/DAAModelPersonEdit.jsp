<%--
****************************************************************************
* DESC       ：报案登记录入/修改页面
* AUTHOR     ：weishixin
* CREATEDATE ：2004-02-29
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"  %>

<html>
<head>
    <!--对title处理-->
    <title>
      <bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script src="/claim/test/DAAModelPersonEdit.js"> </script>

 </head>
<body class="interface" onload="loadForm();">
  <form name=fm action="" method="post" >
   <!--建立显示的录入条，可以收缩显示的-->
   <table class="common" align="center">
    <!--表示显示多行的-->
    <tr >
      <td class="subformtitle" colspan="4">
          <table class="common"  id="PersonLoss_Data" cellspacing="1" cellpadding="0">
            <tbody>
           <tr>
          <td class="input" style="width:4%">
             <div align="center">
               <input class="readonlyNo" readonly name="prpLpersonLossSerialNo" description="序号">
             </div>
         </td>
         <td class="subformtitle" style="width:92%">
         <table  cellpadding="0" cellspacing="1" class="common" style="width:100%">
            <tbody>
                <tr>
                  <input type="hidden" name="prpLpersonLossPersonNo">
                  <input type="hidden" name="prpLpersonLossIdentifyNumber">
                  <!--是否超过保单中的限额标志域-->
                  <input type="hidden" name="prpLpersonLossPersonLossOverAmount">
                  <input type="hidden" name="prpLpersonLossJobCode">
                  <input type="hidden" name="prpLpersonLossJobName">
                  <td class="title"  style="width:15%">人员姓名：</td>
                  <td class="input" style="width:35%">
                    <input class='common' style="width:110" name="prpLpersonLossPersonName"
                    maxlength=20 description="人员姓名">
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                  <td class="title" style="width:15%">性别：</td>
                  <td class="input" style="width:35%">
                    <select name="prpLpersonLossSex" class='common' style="wdith:110">
                       <option value="1" checked >男</option>
                       <option value="2">女</option>
                    </select>
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                </tr>
                <tr>
                  <td class="title">年龄：</td>
                  <td class="input">
                    <input class='common' name="prpLpersonLossAge"  style="width:110"
                      maxlength="3" description="年龄">
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                  <td class="title">币别：</td>
                  <td class="input">
                    <input type="hidden" name="prpLpersonLossCurrency3"  value="CNY">
                    <input class='readonly' readonly name="prpLpersonLossCurrencyName3">
                  </td>
                </tr>
                <tr>
                  <td class="title">险别：</td>
                  <td class="input">
                    <input type='hidden' name="prpLpersonLossAmount">
                    <input type='hidden' name='prpLpersonLossDeductible'>
                    <!-- input type='hidden' name='TempName' -->
                    <input type='hidden' name='prpLpersonLossItemKindNo'>
                    <input type="input" name='prpLpersonLossKindCode' class="codecode"  style="width:40"
                      querytype="always" codetype="KindCode3" coderelation="1,-1,-2,-4,-2,-2,-3" codelimit="must"
                      ondblclick="code_CodeSelect(this);"
                      onkeyup="code_CodeSelect(this);"
                    >
                    <input type="input" name=prpLpersonLossKindName class="codename" style="width:110"
                      querytype="always" codetype="KindCode3" coderelation="-1,-2,-3,-5,-3,-3,-4" codelimit="must"
                      ondblclick="code_CodeSelect(this);"
                      onkeyup="code_CodeSelect(this);"
                    >
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                  <td  class="title">
                  </td>
                  <td class="input">
                  </td>


                </tr>
                <tr>
                  <td class='title'>号牌号码：</td>
                  <td class="input">
                    <select class='common' style="width:110" name="prpLpersonLossLicenseNo">
                       <option value="1">京A0001</option>
                       <option value="2">京A0002</option>
                       <option value="3">京A0003</option>
                       <option value="4">京A0004</option>
                    </select>
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                  <td class='title'>责任比例：</td>
                  <td class='input'>
                    <input class='common' name="prpLpersonLossIndemnityDutyRate" style="width:130">%
                  </td>
                </tr>
                <tr>
                  <td class='title'>免赔率：</td>
                  <td class='input'>
                    <input class='readonly' style='width:110' readonly name="prpLpersonLossDeductibleRate">%
                  </td>
                  <td class="title">赔付合计：</td>
                  <td class="input">
                    <input class='readonly' style='width:110' readonly name="prpLpersonLossSumRealpay">
                  </td>
                </tr>

              <input type='hidden' name='prpLpersonLossFamilyNo'>
              <input type='hidden' name='prpLpersonLossFamilyName'>
              <input type='hidden' name='prpLpersonLossLiabCode'>
              <input type='hidden' name='prpLpersonLossLiabName'>
              <input type='hidden' name='prpLpersonLossLiabDetailCode'>
              <input type='hidden' name='prpLpersonLossLiabDetailName'>
              <input type='hidden' name='prpLpersonLossItemAddress'>
              <input type='hidden' name='prpLpersonLossLossQuantity'>
              <input type='hidden' name='prpLpersonLossUnit'>
              <input type='hidden' name='prpLpersonLossUnitAmount'>
              <input type='hidden' name='prpLpersonLossCurrency'  value="CNY">
              <input type='hidden' name='prpLpersonLossCurrency1' value="CNY">
              <input type='hidden' name='prpLpersonLossItemValue'>
              <input type='hidden' name='prpLpersonLossCurrency2' value="CNY">
              <input type='hidden' name='prpLpersonLossSumLoss'>
              <input type='hidden' name='prpLpersonLossSumRest'>
              <input type='hidden' name='prpLpersonLossClaimRate'>
              <input type='hidden' name='prpLpersonLossCurrency4' value="CNY">
              <input type='hidden' name='prpLpersonLossSumRealPay'>
              <input type='hidden' name='prpLpersonLossFlag'>
              <input type='text' name='pageCode'>
              <input type='text' name='recordCount'>
              <input type='text' name='firstIndex'>
              <input type='text' name='countLoss'>
              <tr>
              <td colspan="4">
              <%//人员赔付信息%>
              <%@include file="/test/DAACompensatePersonLossEdit.jsp"%>
              </td>
              </tr>


            </tbody>
           </table>
           </td>
          <td class="input" style='width:4%'>
          <div align="center">
            <input type=button name=btnConfirm value="确定" onclick="return confirmInput(this,'PersonLoss');" style="cursor: hand"> <br>
          </div>
          </td>

       </tr>



            </tbody>
          </table>

      </td>
    </tr>
  </table>

  </form>
</body>
  <!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->


<html>