<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%--
****************************************************************************
* DESC       �������嵥��ʾ����ӡҳ��
* AUTHOR     �� zhaolu
* CREATEDATE �� 2005-08-07 
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.util.*"%>
<HTML>
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<link href="/claim/css/Standard.css" type=text/css rel=stylesheet>
<script src="/claim/DAA/certify/js/DAACertifyEdit.js">
</script>
<SCRIPT>

  	function exit()
  	{
      window.opener.location.reload();
  	}
  </script>
<%
  String nodeType=request.getParameter("nodeType");
  if(nodeType.equals("certi")){
%>
</HEAD>
<body onunload=exit();>
<%
  }else{
%>
<%
  }
%>
<form action=/claim/certifySave.do method=post name="fm">
<table cellSpacing=0 cellPadding=0 width="92%" align=center border=0>
  <TBODY>
  <tr height=40>
    <td style="FONT-SIZE: 14pt; FONT-FAMILY: ����" align=top>
<B>
<%=(String)request.getAttribute("riskName")%>
������֪<B>
     </B>
</B>
</td>
</tr>
</TBODY>
</table>
<%
      RegistDto registDto = (RegistDto)request.getAttribute("registDto");
      String registNo = "";
      registNo = registDto.getPrpLregistDto().getRegistNo();
      String policyNo = registDto.getPrpLregistDto().getPolicyNo();
      String strName = "";    
      UIPolicyAction uiPolicyAction = new UIPolicyAction();
      PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(policyNo);
      PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
      strName = (String)request.getAttribute("riskName");
      PrpLcertifyDirectDto prpLcertifyDirectDto = null;
      String strTypeCode[] = new String[100];
      String strTypeName[] = new String[100];
      int certifyDtoCount = 0;
      int index = 1;
      CertifyDto certifyDto = (CertifyDto)request.getAttribute("certifyDto");
      if(certifyDto.getPrpLcertifyDirectDtoList()!=null){
        certifyDtoCount = certifyDto.getPrpLcertifyDirectDtoList().size();
      }
%>
<br>
<table cellSpacing=0 cellPadding=0 width="92%" align=center border=0>
  <TBODY>
  <tr>
    <td colSpan=4 height=20>
      <p>
<ins>
<%=prpCmainDto.getInsuredName()%>
</ins>
��</p>
</td>
</tr>
  <tr>
    <td colSpan=4 height=20>
      <p>
&nbsp;&nbsp;&nbsp;&nbsp;������Ͷ���ı�ķ������¹ʣ����������ҹ�˾�ύ��<%=strName%>���������顷��ͬʱ�������ҹ�˾��Ҫ���ṩ����       �йص�֤��������������ѣ�����ʱ����˾�ķ���ר�ߵ绰 ��__________�����ҹ�˾���߳�Ϊ���ṩ���ʡ���Ч�ı��շ���     лл���ĺ�����</p>
</td>
</tr>
  <tr>
    <td colSpan=4 height=20>
      <blockquote>
        <p>
<%=strName%>
�������������ϸ���£�</p>
</blockquote>
</td>
</tr>
<br>
<%if(certifyDtoCount >
 25){
    certifyDtoCount = 25;
  }  
  for(int i=0;i<certifyDtoCount;i++){
    prpLcertifyDirectDto = (PrpLcertifyDirectDto)certifyDto.getPrpLcertifyDirectDtoList().get(i); 
    String typeName = "";
    strTypeCode[i] = prpLcertifyDirectDto.getTypeCode().substring(1,3);
    strTypeName[i] = prpLcertifyDirectDto.getTypeName();
    if(!strTypeName[i].equals("")){
       
%>
  <tr height=20>
    <td colSpan=4>
      <blockquote>
        <p>
<%=index++%>
.<%=strTypeName[i]%>
</p>
</blockquote>
</td>
</tr>
<%
    if ( i == 24 )
    {
 %>
  <tr height=20>
    <td colSpan=4>
      <blockquote>
        <blockquote>
          <p>
(���ݹ��࣬�������ݼ���һҳ)</p>
</blockquote>
</blockquote>
</td>
</tr>
<%
	}
%>
<%   
  }
}
    if(certifyDtoCount < 25 ){
      for(int j=0;j<30-certifyDtoCount;j++){
%>
  <tr height=20>
    <td colSpan=4>
      <blockquote>
        <blockquote>
          <p>
</p>
</blockquote>
</blockquote>
</td>
</tr>
<%
    }
  }
%>
  <tr>
    <td colSpan=4 height=20>
      <p>
&nbsp;&nbsp;&nbsp;&nbsp;����ע�⣺Ϊȷ�����ܹ���ø���ȫ�桢����ı����⳥���ҹ�˾����������У�������Ҫ����һ���ṩ�������е�֤       ���������֤�����ϡ���ʱ���ҹ�˾����ʱ֪ͨ������л�������ǹ����������֧�֣�</p>
</td>
</tr>
  <tr>
    <td colSpan=4>
      <hr>
    </td>
</tr>
</TBODY>
</table>
<table cellSpacing=0 cellPadding=0 width="92%" align=center border=0>
  <TBODY>
  <tr height=30>
    <td width="30%">
�������ˣ� </td>
    <td width="20%">
<%=prpCmainDto.getInsuredName()%>
</td>
    <td width="30%">
���չ�˾��</td>
    <td width="20%">
<%=strName%>
</td>
</tr>
  <tr height=30>
    <td>
�쵽��������֪�����ڣ�</td>
    <td>
____��____��____��</td>
    <td>
������������֪�����ڣ�</td>
    <td>
____��____��____��</td>
</tr>
  <tr height=30>
    <td>
ȷ��ǩ�֣�</td>
    <td>
</td>
    <td>
������ǩ�֣�</td>
    <td>
</td>
</tr>
  <tr height=30>
    <td>
�ύ����������ڣ�</td>
    <td>
____��____��____��</td>
    <td>
�յ�����������ڣ�</td>
    <td>
____��____��____��</td>
</tr>
  <tr height=30>
    <td>
ȷ��ǩ�֣�</td>
    <td>
</td>
    <td>
������ǩ�֣�</td>
    <td>
</td>
</tr>
</TBODY>
</table>
<br>
<input type="hidden" name="nodeType" value="CertifDirect">
<script language=javascript>

      function printPage()
      {
        tbButton.style.display = "none";
        window.print();
      }
    </script>
 <%-- include��ӡ��ť --%>
<!--<jsp:include page="/common/print/PrintButton.jsp"  />
     -->
<table cellSpacing=0 cellPadding=0 width="80%"  id="tbButton">
  <TBODY>
  <tr>
    <td style="WIDTH: 33%" align=middle  class="button">
<input type=button name=buttonPrint value=" �� ӡ " class="button" onclick="return printPage()">
     </td>
<%
  if(certifyDto.getPrpLcertifyDirectDtoList().size()>
24){
%>
    <td style="WIDTH: 33%" align=middle  class="button">
<input type=button name=buttonPage value=" �� ҳ " class="button" onclick="return certifyDirectAdd('<%=registNo%>','certi','<%=index%>')">
     </td>
<%
  }
%>
    <td style="WIDTH: 33%" align=middle  class="button">
 <input type=button name=buttonClose value=" �� �� " class="button" onclick="javascript:window.close()">
     </td>
</tr>
</TBODY>
</table>
</form>
<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp"  />
</body>
</HTML>
