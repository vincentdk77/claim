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
  <title>�������</title>
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/endcase/js/DAAEndcaseEdit.js"></script>
  <script language='javascript'>
    /**
     @author      liubvo
     @description У�鴰�巽��
     @param       ��
     @return      boolean,�Ϸ�����true,���Ϸ�����false
    */
    function checkForm()
		{
			if(isEmpty(fm.ClaimNo))
			{
				fm.ClaimNo.focus();
				errorMessage("�����Ų���Ϊ��!");
				return false;
			}
			else if(trim(fm.ClaimNo.value).length!=22)
			{
				fm.ClaimNo.focus();
				errorMessage("������ӦΪ22λ��!");
				return false;
			}

			if(!isEmpty(fm.CompensateNo))
			{
			  if(trim(fm.CompensateNo.value).length!=22)
			  {
  				fm.CompensateNo.focus();
  				errorMessage("���������ӦΪ22λ��!");
  				return false;
			  }
			}

			return true;
		}

    /**
     @author      liubvo
     @description �ύ���巽��
     @param       ��
     @return      ��
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

<%-- ����loadForm ��ʼ��ҳ�� --%>
<body class="interface" onload="initPage();">
  <form name=fm action="/claim/endor.do" method="post" onsubmit="return validateForm(this);">
  <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">

    <table class="common" cellpadding="5" cellspacing="1">
  	  <tr>
  	  	<td class=formtitle colspan="4">�������Ǽ�
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
      <%--�������Ǽ��嵥--%>
      <tr class=mline>
        <td class="common" colspan="4" style="text-align:left">
          <table class="common" cellpadding="5" cellspacing="1">
            <tr>
              <td class="subformtitle">���������Ϣ
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
                  <td class="centertitle" style="width:15%">�������</td>
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
