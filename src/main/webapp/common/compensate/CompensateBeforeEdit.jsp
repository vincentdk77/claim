<%--
****************************************************************************
* DESC       ��¼��ʵ��ǰ����������ҳ��
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-05-19
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
  //�����ձ���ʾ��������
  String strRiskCode = request.getParameter("riskCode");
  String strDisplay  = "";
  if (strRiskCode!=null&&strRiskCode.equals("DAS"))
    strDisplay = "none";
%>
<script language='javascript'>
	function loadForm()
	{
		fm.ATimes.style.display = "none";//Modify By sunhao 2004-09-15
		fm.BTimes.style.display = "none";//Modify By sunhao 2004-09-15
		fm.VisaNum.style.display = "none";
	}
</script>
<html:html locale="true">
<head>
  <title>��ѯʵ����Ϣ</title>
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
    <script language='javascript'>
      /**
       @author      ����Ⱥ
       @description У��
       @param       ��
       @return      boolean,�Ϸ�����true,���Ϸ�����false
      */
      function checkForm()
      {
      	if(isEmptyField(fm.ClaimNo))
      	{
      		fm.ClaimNo.focus();
      		errorMessage("�����Ų���Ϊ��!");
      		return false;
      	}
      	/*
      	else if(trim(fm.ClaimNo.value).length!=22)
      	{
      		fm.ClaimNo.focus();
      		errorMessage("������ӦΪ22λ��!");
      		return false;
      	}
      	*/
      	if(fm.APaidTimes.checked == true)
      	{
      		if(isEmptyField(fm.ATimes))
      		{
      			fm.ATimes.focus();
      			errorMessage("����������Ϊ��!");
      			return false;
      		}
      		if(fm.ATimes.value=='0')
      		{
      			fm.ATimes.focus();
      			errorMessage("����������Ϊ0!");
      			return false;
      		}
      	}

      	if(fm.BPaidTimes.checked == true)
      	{
      		if(isEmptyField(fm.BTimes))
      		{
      			fm.BTimes.focus();
      			errorMessage("����������Ϊ��!");
      			return false;
      		}
      		if(fm.BTimes.value=='0')
      		{
      			fm.BTimes.focus();
      			errorMessage("����������Ϊ0!");
      			return false;
      		}
      	}

      	if(fm.NoVisaNum.checked == true)
      	{
      		if(isEmptyField(fm.VisaNum))
      		{
      			fm.VisaNum.focus();
      			errorMessage("��֤��������Ϊ��!");
      			return false;
      		}
      		if(fm.VisaNum.value=='0')
      		{
      			fm.VisaNum.focus();
      			errorMessage("��֤��������Ϊ0!");
      			return false;
      		}
      	}
      	return true;
      }

      /**
       @author      ����Ⱥ
       @description ���������������
       @param       ��
       @return      ��
      */
      function getDeductibleTerm()
      {
        var strIsSingle    = "0";
        var strIsFindThirt = "0";
        var strIsSafeLoad  = "0";
        var strIsLoadAccid = "0";
        var strIsNoDriver  = "0";
        var strAPaidTimes  = "0";
        var strBPaidTimes  = "0";
        var strNoVisaNum   = "0";
        var strIsNoKey     = "0";
        var strIsGlassCrash= "0";

        if( fm.IsSingle.checked == true )
        {strIsSingle = "1";}
        if( fm.IsFindThirt.checked == true )
        {strIsFindThirt = "1";}
        if( fm.IsSafeLoad.checked == true )
        {strIsSafeLoad = "1";}
        if( fm.IsLoadAccid.checked == true )
        {strIsLoadAccid = "1";}
        if( fm.IsNoDriver.checked == true )
        {strIsNoDriver = "1";}
        if( fm.APaidTimes.checked == true )//Modify By sunhao 2004-09-15
        {strAPaidTimes = fm.ATimes.value;}
        if( fm.BPaidTimes.checked == true )//Modify By sunhao 2004-09-15
        {strBPaidTimes = fm.BTimes.value;}
        if( fm.NoVisaNum.checked == true )
        {strNoVisaNum = fm.VisaNum.value;}
        if( fm.IsNoKey.checked == true )
        {strIsNoKey = "1";}
        if( fm.IsGlassCrash.checked == true )
        {strIsGlassCrash = "1";}

        fm.DeductibleTerm.value = strIsSingle + strIsFindThirt + strIsSafeLoad + strIsLoadAccid
                                + strIsNoDriver + strAPaidTimes + strBPaidTimes + strNoVisaNum + strIsNoKey + strIsGlassCrash;

      }


      /**
       @author      ����Ⱥ
       @description �ύ����
       @param       ��
       @return      ��
      */
      function submitForm()
      {

        if(!checkForm())
        {
          return false;
        }
        getDeductibleTerm();
        fm.submit();
      }

      //Modify By sunhao begin 2004-09-15
			function displayAPaidTimes()
			{
				if( fm.ATimes.style.display == "")
				{
					fm.ATimes.style.display = "none";
				}
			  else
				{
					fm.ATimes.style.display = "";
				}

			}

			function displayBPaidTimes()
			{
				if( fm.BTimes.style.display == "")
				{
					fm.BTimes.style.display = "none";
				}
			  else
				{
					fm.BTimes.style.display = "";
				}

			}
			//Modify By sunhao end 2004-09-15

			function displayNoVisaNum()
			{
				if( fm.VisaNum.style.display == "" )
				{
					fm.VisaNum.style.display = "none";
				}
				else
				{
					fm.VisaNum.style.display = "";
				}
			}
    </script>
</head>

<body  onload="initPage();loadForm();">
<form name="fm" action="/claim/compensateBeforeEdit.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr><td colspan=2 class="formtitle">���������ţ��������飩</td></tr>
      <tr>
        <td class='title2' >������:</td>
        <td class='input2' >
          <input type=text name="ClaimNo" class="readonly" readonly value="<%= request.getParameter("ClaimNo") %>">
          <input type="hidden" name="swfLogFlowID" value="<%= request.getParameter("swfLogFlowID") %>">
          <input type="hidden" name="swfLogLogNo" value="<%= request.getParameter("swfLogLogNo") %>">
          <input type="hidden" name="status" value="<%= request.getParameter("status") %>">
          <input type="hidden" name="riskCode" value="<%= request.getParameter("riskCode") %>">
          <input type="hidden" name="editType" value="<%= request.getParameter("editType") %>">
          <input type="hidden" name="nodeType" value="<%= request.getParameter("nodeType") %>">
          <input type="hidden" name="nodeType" value="<%= request.getParameter("nodeType") %>">
          <input type="hidden" name="businessNo" value="<%= request.getParameter("businessNo") %>">
          <input type="hidden" name="caseType" value="<%= request.getParameter("caseType") %>">

        </td>
      </tr>
         <tr style="display:'<%=strDisplay%>'">
          <td class='title2'>����������</td>
          <td class='input2'>
            <input type="checkbox" name="IsSingle"    value="IsSingle">���������¹�<br>
            <input type="checkbox" name="IsFindThirt" value="IsFindThirt">�޷��ҵ�������<br>
            <input type="checkbox" name="IsSafeLoad"  value="IsSafeLoad">Υ����ȫװ�ع涨<br>
            <input type="checkbox" name="IsLoadAccid" value="IsLoadAccid">��Υ����ȫװ�ع涨���±����¹ʷ���<br>
            <input type="checkbox" name="IsNoDriver"  value="IsNoDriver">��Լ����ʻ��Աʹ�ñ��ճ������������¹ʵ�<br>
            <input type="checkbox" name="APaidTimes"   value="APaidTimes" onclick="displayAPaidTimes()">ͬһ��������ڳ�����(A)���մ���<input class="common" type='text' name='ATimes' maxlength='1' style="width:30"><br>
            <input type="checkbox" name="BPaidTimes"   value="BPaidTimes" onclick="displayBPaidTimes()">ͬһ��������ڵ�����������(B)���մ���<input class="common" type='text' name='BTimes' maxlength='1' style="width:30"><br>
            <input type="checkbox" name="NoVisaNum"   value="NoVisaNum" onclick="displayNoVisaNum()">ȱ����ص�֤����(������)<input class="common" type='text' name='VisaNum' maxlength='1' style="width:30"><br>
            <input type="checkbox" name="IsNoKey"     value="IsNoKey">ȱ�ٳ�Կ��(������)<br>
            <input type="checkbox" name="IsGlassCrash" value="IsGlassCrash">������������<br>
            <input class="common" type='hidden' name='DeductibleTerm'>
          </td>
        </tr>

      <tr>
        <td class='button' colspan="2"  style="align:center">
          <input type="button" class='button' value="��һ��" onclick="submitForm();">
        </td>
      </tr>
    </table>


  </form>

      <%--modify by wangli add start 20050417 --%>
            <%-- �����Ŷ�Ӧ���������б� --%>
      <%@include file="/common/compensate/CompensateMainBeforeEdit.jsp" %>
      <%--modify by wangli add end 20050417 --%>

</body>
</html:html>



