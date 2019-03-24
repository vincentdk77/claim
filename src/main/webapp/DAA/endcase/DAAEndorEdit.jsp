<%--
****************************************************************************
* DESC       ：冲减保额主画面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-11-26
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<%
   String claimNo = (String)request.getAttribute("claimNo");
%>


<html:html locale="true">
<head>
  <title>冲减保额</title>
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/endcase/js/DAAEndcaseEdit.js"></script>
  <script language='javascript'>
    /**
     @author      liubvo
     @description 校验窗体方法
     @param       无
     @return      boolean,合法返回true,不合法返回false
    */
    function checkForm()
		{
			if(isEmpty(fm.ClaimNo))
			{
				fm.ClaimNo.focus();
				errorMessage("立案号不能为空!");
				return false;
			}
			else if(trim(fm.ClaimNo.value).length!=22)
			{
				fm.ClaimNo.focus();
				errorMessage("立案号应为22位长!");
				return false;
			}

			if(!isEmpty(fm.CompensateNo))
			{
			  if(trim(fm.CompensateNo.value).length!=22)
			  {
  				fm.CompensateNo.focus();
  				errorMessage("赔款计算书号应为22位长!");
  				return false;
			  }
			}

			return true;
		}

    /**
     @author      liubvo
     @description 提交窗体方法
     @param       无
     @return      无
     @see         checkForm
    */
    function submitForm()
    {
    /*
      if(checkForm()==true)
	  	{
        fm.submit();
      }
      */
       fm.buttonSave.disabled = true;
        fm.submit();
    }

    function resetForm()
    {
      fm.reset();
    }
  </script>
</head>

<body  class="interface" onload="initPage();">

<%-- 调用loadForm 初始化页面 --%>
<body class="interface" onload="initPage();">
  <form name=fm action="/claim/endor.do" method="post" onsubmit="return validateForm(this);">
  <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">

    <table class="common" cellpadding="5" cellspacing="1">
  	  <tr>
  	  	<td class=formtitle colspan="4">冲减保额登记
  	  	</td>
  	  </tr>
      <tr>
        <td class="title">立案号：</td>
        <td class="input">
          <input type='hidden' name='RiskCode' value="<bean:write name='prpLlossDto' property='riskCode' />">
          <input name="ClaimNo" class="readonly" readonly value="<%= claimNo%>">
        </td>
        <td class="title">保单号：</td>
        <td class="input">
          <input name="PolicyNo" class="readonly" readonly value="<bean:write name='prpLlossDto' property='policyNo' />">
        </td>
      </tr>
    </table>

    <table class="common" align=center>
      <%--冲减保额登记清单--%>
      <tr class=mline>
        <td class="common" colspan="4" style="text-align:left">
          <table class="common" cellpadding="5" cellspacing="1">
            <tr>
              <td class="subformtitle">冲减保额信息
              </td>
            </tr>
          </table>

          <span id="spanEndorAll" >
            <table class=common cellpadding="5" cellspacing="1" id="Endor">
              <thead>
                <tr>
                  <td class="centertitle" style="width:20%">赔款计算书号</td>
                  <td class="centertitle" style="width:10%">标的项目类别</td>
                  <td class="centertitle" style="width:20%">标的项目名称</td>
                  <td class="centertitle" style="width:20%">险别名称</td>
                  <td class="centertitle" style="width:15%">币别</td>
                  <td class="centertitle" style="width:15%">冲减保额</td>
                </tr>
              </thead>
              <tfoot>
              </tfoot>
              <tbody>
		<logic:notEmpty  name="prpLlossDto"  property="prpLlossList">
        <logic:iterate id="lossList" name="prpLlossDto" property="prpLlossList">
              <logic:equal name="lossList" property="kindCode" value="T">
                <tr class=common>
                  <td>
                    <input name=CompensateNo class="readonly" readonly style='width:170px' value="<bean:write name='lossList' property='compensateNo' />">
                  </td>
                  <td>
                    <input name="ItemCode" class="readonly" readonly style="width:40px" value="<bean:write name='lossList' property='itemCode' />">
                  </td>
                  <td>
                    <input name="ItemName" class="readonly" readonly style="width:110px" value="<bean:write name='lossList' property='lossName' />">
                  </td>
                  <td>
                    <input type='hidden' name="ItemKindNo" value="<bean:write name='lossList' property='itemKindNo' />">
                    <input type='hidden' name="KindCode" value="<bean:write name='lossList' property='kindCode' />">
                    <input type="input" name=KindName class="readonly" readonly style='width:105px' value="<bean:write name='lossList' property='kindName' />">
                  </td>
                  <td>
                    <input type='hidden' name="Currency" value="<bean:write name='lossList' property='currency' />">
                    <input name="CurrencyName" class="readonly" readonly style="width:65px" value="<bean:write name='lossList' property='currencyName' />">
                  </td>
                  <td>
                    <input name="EndorAmount" class="readonly" readonly style="width:90px" value="-<bean:write name='lossList' property='sumRealPay' />">
                  </td>
                </tr>
              </logic:equal>
              <logic:equal name="lossList" property="kindCode" value="C">
                <tr class=common>
                  <td>
                    <input name=CompensateNo class="readonly" readonly style='width:170px' value="<bean:write name='lossList' property='compensateNo' />">
                  </td>
                  <td>
                    <input name="ItemCode" class="readonly" readonly style="width:40px" value="<bean:write name='lossList' property='itemCode' />">
                  </td>
                  <td>
                    <input name="ItemName" class="readonly" readonly style="width:110px" value="<bean:write name='lossList' property='lossName' />">
                  </td>
                  <td>
                    <input type='hidden' name="ItemKindNo" value="<bean:write name='lossList' property='itemKindNo' />">
                    <input type='hidden' name="KindCode" value="<bean:write name='lossList' property='kindCode' />">
                    <input type="input" name=KindName class="readonly" readonly style='width:105px' value="<bean:write name='lossList' property='kindName' />">
                  </td>
                  <td>
                    <input type='hidden' name="Currency" value="<bean:write name='lossList' property='currency' />">
                    <input name="CurrencyName" class="readonly" readonly style="width:65px" value="<bean:write name='lossList' property='currencyName' />">
                  </td>
                  <td>
                    <input name="EndorAmount" class="readonly" readonly style="width:90px" value="-<bean:write name='lossList' property='sumRealPay' />">
                  </td>
                </tr>
              </logic:equal>
           </logic:iterate>
      </logic:notEmpty>
              </tbody>
            </table>
          </span>
        </td>
      </tr>
    </table>

  <input type="hidden" name="editType" value="SAVE">
  <table class="common" align="center">
    <tr>
      <td class="button" >
        <input type="button" name="buttonSave" value=" 下一步 " class="button" onclick="submitForm();">
      </td>
      <td class="button" >
        <input type="button" name="buttonCancel" value=" 取 消 " class="button" onclick="resetForm();">
      </td>
    </tr>
  </table>
</form>
</body>
<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>
