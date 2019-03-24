<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%--
****************************************************************************
* DESC       ：索赔清单显示及打印页面
* AUTHOR     ： zhaolu
* CREATEDATE ： 2005-08-07 
* MODIFYLIST ：   Name       Date            Reason/Contents
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
    <td style="FONT-SIZE: 14pt; FONT-FAMILY: 宋体" align=top>
<B>
<%=(String)request.getAttribute("riskName")%>
索赔须知<B>
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
：</p>
</td>
</tr>
  <tr>
    <td colSpan=4 height=20>
      <p>
&nbsp;&nbsp;&nbsp;&nbsp;由于您投保的标的发生了事故，请您在向我公司提交《<%=strName%>索赔申请书》的同时，依照我公司的要求，提供以下       有关单证。如果您遇到困难，请随时拨打公司的服务专线电话 “__________”，我公司将竭诚为您提供优质、高效的保险服务。     谢谢您的合作！</p>
</td>
</tr>
  <tr>
    <td colSpan=4 height=20>
      <blockquote>
        <p>
<%=strName%>
索赔材料手续明细如下：</p>
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
(内容过多，其余内容见下一页)</p>
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
&nbsp;&nbsp;&nbsp;&nbsp;敬请注意：为确保您能够获得更加全面、合理的保险赔偿，我公司在理赔过程中，可能需要您进一步提供上述所列单证       以外的其他证明材料。届时，我公司将及时通知您。感谢您对我们工作的理解与支持！</p>
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
被保险人： </td>
    <td width="20%">
<%=prpCmainDto.getInsuredName()%>
</td>
    <td width="30%">
保险公司：</td>
    <td width="20%">
<%=strName%>
</td>
</tr>
  <tr height=30>
    <td>
领到《索赔须知》日期：</td>
    <td>
____年____月____日</td>
    <td>
交付《索赔须知》日期：</td>
    <td>
____年____月____日</td>
</tr>
  <tr height=30>
    <td>
确认签字：</td>
    <td>
</td>
    <td>
经办人签字：</td>
    <td>
</td>
</tr>
  <tr height=30>
    <td>
提交索赔材料日期：</td>
    <td>
____年____月____日</td>
    <td>
收到索赔材料日期：</td>
    <td>
____年____月____日</td>
</tr>
  <tr height=30>
    <td>
确认签字：</td>
    <td>
</td>
    <td>
经办人签字：</td>
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
 <%-- include打印按钮 --%>
<!--<jsp:include page="/common/print/PrintButton.jsp"  />
     -->
<table cellSpacing=0 cellPadding=0 width="80%"  id="tbButton">
  <TBODY>
  <tr>
    <td style="WIDTH: 33%" align=middle  class="button">
<input type=button name=buttonPrint value=" 打 印 " class="button" onclick="return printPage()">
     </td>
<%
  if(certifyDto.getPrpLcertifyDirectDtoList().size()>
24){
%>
    <td style="WIDTH: 33%" align=middle  class="button">
<input type=button name=buttonPage value=" 附 页 " class="button" onclick="return certifyDirectAdd('<%=registNo%>','certi','<%=index%>')">
     </td>
<%
  }
%>
    <td style="WIDTH: 33%" align=middle  class="button">
 <input type=button name=buttonClose value=" 关 闭 " class="button" onclick="javascript:window.close()">
     </td>
</tr>
</TBODY>
</table>
</form>
<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp"  />
</body>
</HTML>
