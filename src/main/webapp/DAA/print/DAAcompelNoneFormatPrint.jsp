<%--
****************************************************************************
* DESC       �������������վ��� /ע������ҳ��
* AUTHOR     ��zhouliu
* CREATEDATE ��2006-6-12
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
  <%-- ��ʼ�� --%>
<%@include file="DAAcompelNoneFormatPrintIni.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>��������ͨ�¹�����ǿ�Ʊ��վ����ӡ</title>
   <style type="text/css">
   INPUT.printline
{
    FONT-SIZE: 10pt;
    BORDER-TOP: #ececec 0px solid;
    WIDTH: 10px;
    COLOR: #000000;
    BORDER-BOTTOM: #400000 1px solid;
    BORDER-RIGHT-STYLE: none;
    BORDER-LEFT-STYLE: none;
    BACKGROUND-COLOR: #ffffff
    text-align:center
}
   </style> 
  </head>

  <body bgcolor="#FFFFFF">
  <div align="center">

    <table width="100%" border="0" align="center" style="font-family:����; font-size:10pt;">
      <tr width="100%">
        <td align=center style=" font-family:����; font-size:14pt;"> <B>
          <center>
        ��������ͨ�¹�����ǿ�Ʊ��վ���֪ͨ��
          <center>
		</td>
      </tr>
   </table>
	<br>
	<br>
	<br>
   <table width="55%" border="0" align="center" style="font-family:����;" align="center">
	 <tr align="left">
		�������ˣ� <input type=text name="insuredName"   readonly="true" class="printline" style=
		"width:200px;text-align:center" value="<%=strInsuredName%>">
	 </tr>
	 
	 <tr>
	   <td width="100%" align="left" colspan="2">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div>&nbsp;&nbsp;&nbsp;�ǳ��ź���֪ͨ��,�����йط��ɺͱ��պ�ͬ�Ĺ涨,
		</td>
	 </tr>
	 <tr>
		 <td width="100%" align="left" colspan="2">
		 �ҹ�˾���յ�<input type=text name="policyNo"   readonly="true" class="printline" style=
		"width:180px;text-align:center" value="<%=strPolicyNo%>">(����)���³б�
		</td>
	</tr>
	<tr>
		  <td width="100%" align="left"  colspan="2">
		  ��<input type=text name="licenseNo" readonly="true" class="printline" style=
		"width:60px;text-align:center" value="<%=strLicenseNo%>">(���պ���)����������<input type=text name="year" readonly="true" class="printline" style=
		"width:40px;text-align:center" value="<%=damageDate.getYear()%>">��<input type=text name="month" readonly="true" class="printline" style=
		"width:30px;text-align:center" value="<%=damageDate.getMonth()%>">��<input type=text name="day" readonly="true" class="printline" style=
		"width:35px;text-align:center" value="<%=damageDate.getDay()%>">��
		  </td>
	</tr>
	<tr>
		   <td width="100%" align="left"  colspan="2">
		   ��<input type=text name="damageAddress" readonly="true" class="printline" style=
		"width:115px;text-align:center" value="<%=strDamageAddress%>">(���յص�)�������¹���ʧ�����ڱ�
		   </td>
	 </tr>
	 <tr>
			<td width="100%" align="left"  colspan="2">
				�������⳥��Χ,�Դ��ҹ�˾���ܸ����⸶,�������.
			</td>
	 </tr>
	 <tr>
	   <td>
			<br>
			<br>
			&nbsp;&nbsp;&nbsp;&nbsp;��ӭ�����ҹ�˾�Ĺ���������.
			<br>
			<br>
			<br>
			&nbsp;&nbsp;&nbsp;&nbsp;����
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
       </td>
	 </tr>
	 <tr>
              <td align="left">��������ǩ�գ�</td>
              <td align="center">������(ǩ��)��</td>
    </tr>
	<tr>
		<td>
			&nbsp;
		</td>
		<td>
			&nbsp;
		</td>
	</tr>
	<tr>
			<td>
			&nbsp;
		</td>
		<td>
			&nbsp;
		</td>
	</tr>
		<tr>
              <td width="200" align="left">���ڣ�<%=(curdate.getYear()+1900)%>��<%=(curdate.getMonth()+1)%>��<%=(curdate.getDay()+11)%>��</td>
              <td width="200" align="center">���ڣ�<%=(curdate.getYear()+1900)%>��<%=(curdate.getMonth()+1)%>��<%=(curdate.getDay()+11)%>��</td>
       </tr>
</table>
</div>
<%-- include��ӡ��ť --%>
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
