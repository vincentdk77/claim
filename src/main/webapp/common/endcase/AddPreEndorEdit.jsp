<%--
****************************************************************************
* DESC       ���������������
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-26
* MODIFYLIST ��   Name       Date            Reason/Contents
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
  <title>���ձ���</title>
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/endcase/js/DAAEndcaseEdit.js"></script>
  <script language='javascript'>

    /**
     @author      liubvo
     @description �ύ���巽��
     @param       ��
     @return      ��
     @see         checkForm
    */
    function submitForm()
    {
        fm.submit();
    }

    function resetForm()
    {
      fm.reset();
    }
  </script>
</head>

<body  class="interface" onload="initPage();">

<%-- ����loadForm ��ʼ��ҳ�� --%>
<body class="interface" onload="initPage();">
  <form name=fm action="/claim/endor.do" method="post" onsubmit="return validateForm(this);">
  <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">

    <table class="common" cellpadding="5" cellspacing="1">
  	  <tr>
  	  	<td class=formtitle colspan="4">���ձ��ѵǼ�
  	  	</td>
  	  </tr>
      <tr>
        <td class="title">�����ţ�</td>
        <td class="input">
          <input type='hidden' name='RiskCode' value="<bean:write name='prpLlossDto' property='riskCode' />">
          <input name="ClaimNo" class="readonly" readonly value="<%= claimNo%>">
        </td>
        <td class="title">�����ţ�</td>
        <td class="input">
          <input name="PolicyNo" class="readonly" readonly value="<bean:write name='prpLlossDto' property='policyNo' />">
        </td>
      </tr>
    </table>

    <table class="common" align=center>
      <tr class=mline>
        <td class="common" colspan="4" style="text-align:left">
          <table class="common" cellpadding="5" cellspacing="1">
            <tr>
              <td class="subformtitle">���ձ�����Ϣ
              </td>
            </tr>
          </table>

          <span id="spanEndorAll" >
            <table class=common cellpadding="5" cellspacing="1" id="Endor">
              <thead>
                <tr>
                  <td class="centertitle" style="width:20%">���������</td>
                  <td class="centertitle" style="width:10%">�����Ŀ���</td>
                  <td class="centertitle" style="width:20%">�����Ŀ����</td>
                  <td class="centertitle" style="width:20%">�ձ�����</td>
                  <td class="centertitle" style="width:15%">�ұ�</td>
                  <td class="centertitle" style="width:15%">���ձ���</td>
                </tr>
              </thead>
              <tfoot>
              </tfoot>
              <tbody>
		<logic:notEmpty  name="prpLlossDto"  property="prpLlossList">
        <logic:iterate id="lossList" name="prpLlossDto" property="prpLlossList">
              
                <tr class=common>
                  <td align=center>
                    <input align=center name=CompensateNo class="readonly" readonly style='width:170px' value="<bean:write name='lossList' property='compensateNo' />">
                  </td>
                  <td align=center>
                    <input align=center name="ItemCode" class="readonly" readonly style="width:40px" value="<bean:write name='lossList' property='itemCode' />">
                  </td>
                  <td align=center>
                    <input align=center name="ItemName" class="readonly" readonly style="width:110px" value="<bean:write name='lossList' property='lossName' />">
                  </td>
                  <td align=center>
                    <input type='hidden' name="ItemKindNo" value="<bean:write name='lossList' property='itemKindNo' />">
                    <input type='hidden' name="KindCode" value="<bean:write name='lossList' property='kindCode' />">
                    <input align=center type="input" name=KindName class="readonly" readonly style='width:105px' value="<bean:write name='lossList' property='kindName' />">
                  </td>
                  <td align=center>
                    <input type='hidden' name="Currency" value="<bean:write name='lossList' property='currency' />">
                    <input align=center name="CurrencyName" class="readonly" readonly style="width:65px" value="<bean:write name='lossList' property='currencyName' />">
                  </td>
                  <td align=center>
                    <input align=center class="input" name="EndorAmount"   style="width:90px" >
                    <input type="hidden" name="EndorType" value="72">
                    <input type="hidden" name="EndorGrossQuantity">
                  </td>
                </tr>
        </logic:iterate>
      </logic:notEmpty>
              </tbody>
            </table>
          </span>
        </td>
      </tr>
    </table>

  <input type="hidden" name="editType" value="ADDPRESAVE">
  <table class="common" align="center">
    <tr>
      <td class="button" >
        <input type="button" name="buttonSave" value=" ��һ�� " class="button" onclick="submitForm();">
      </td>
      <td class="button" >
        <input type="button" name="buttonCancel" value=" ȡ �� " class="button" onclick="resetForm();">
      </td>
    </tr>
  </table>
</form>
</body>
<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>
