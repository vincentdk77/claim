<%--
****************************************************************************
* DESC       �������嵥��ʾ����ӡҳ��
* AUTHOR     �� luqin
* CREATEDATE �� 2005-07-21 
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

    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script src="/claim/DAA/certify/js/DAACertifyEdit.js"></script>
  <SCRIPT>
  	function exit()
  	{
      window.opener.location.reload();
  	}
  </SCRIPT>

<%
  String nodeType=request.getParameter("nodeType");
  if(nodeType.equals("certi")){
%>
<body  onunload="exit();">
<%
  }else{
%>
<body >
<%
  }
%>
  <form name=fm action="/claim/certifySave.do" method="post">
  <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
    <tr height="40">
      <td align=top align=center style="font-family:����; font-size:14pt;">            
          <B>������������������֪<B>
      </td>
    </tr>
  </table>
<%
      PrpLcertifyDirectDto prpLcertifyDirectDto = null;
      String strTypeCode[] = new String[100];
      String strTypeName[] = new String[100];
      int certifyDtoCount = 0;
      int index = 0;
      index = Integer.parseInt(request.getParameter("index"));
      CertifyDto certifyDto = (CertifyDto)request.getAttribute("certifyDto");
      if(certifyDto.getPrpLcertifyDirectDtoList()!=null){
        certifyDtoCount = certifyDto.getPrpLcertifyDirectDtoList().size();
      }
%>
<br>
<table width="92%" align="center" cellspacing="0" cellpadding="0" border="0"> 
	<tr> 
    <td colspan=4 height="20"><blockquote>
        <p>���������������������ϸ���£�������ҳ��</p>
      </blockquote></td>
	   </tr><br>
<% 
  for(int i=25;i<certifyDtoCount;i++){
    prpLcertifyDirectDto = (PrpLcertifyDirectDto)certifyDto.getPrpLcertifyDirectDtoList().get(i); 
    strTypeCode[i] = prpLcertifyDirectDto.getTypeCode().substring(0,2);
    strTypeName[i] = prpLcertifyDirectDto.getTypeName();
    if(!strTypeName[i].equals("")){
      if(strTypeCode[i].equals("01")){  
%>	   
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. �����������������������顷</p>
      </blockquote></td>
	   </tr>
<%
  }if(strTypeCode[i].equals("02")){
%> 
  <tr height="20">  
    <td colspan=4><blockquote>
        <p><%=index++%>. �����������յ�����</p>
      </blockquote></td>
	   </tr>
<%
  }if(strTypeCode[i].equals("03")){
    if(!strTypeCode[i-1].equals("03")){
%>	   
  <tr height="20">  
    <td colspan=4><blockquote>
        <p><%=index++%>. �¹ʴ����ų��ߵģ� </p>
      </blockquote></td>
	   </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
  }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
    }
  }if(strTypeCode[i].equals("04")){
    if(!strTypeCode[i-1].equals("04")){
%>	   
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. ��Ժ���ٲû������ߵģ�</p>
      </blockquote></td>
	   </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>	   
<%
  }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
    }
  }if(strTypeCode[i].equals("05")){
    if((i==0)||(!strTypeCode[i-1].equals("05"))){
%>	   
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. �漰������ʧ�����ṩ�� </p>
      </blockquote></td>
	   </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>	   
<%
  }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
    }
  }if(strTypeCode[i].equals("06")){
    if(!strTypeCode[i-1].equals("06")){
%>	   
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. �漰�Ʋ���ʧ�����ṩ��</p>
      </blockquote></td>
	   </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>	   
<%
  }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
    }
  }if(strTypeCode[i].equals("07")){
    if((i==25)||(!strTypeCode[i-1].equals("07"))){
%>	    
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. �漰�����ˡ��С�����ʧ�����ṩ��</p>
      </blockquote></td>
	   </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>	   
<%
  }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
    }
  }if(strTypeCode[i].equals("08")){
    if((i==25)||(!strTypeCode[i-1].equals("08"))){
%>	   
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. �漰�����������������ṩ�� </p>
      </blockquote></td>
     </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>     
<%
  }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
    }
  }if(strTypeCode[i].equals("09")){
    if((i==25)||(!strTypeCode[i-1].equals("09"))){
%>     
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. �漰������ȼ�İ��������ṩ��</p>
      </blockquote></td>
    </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>    
<%
  }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
    }
  }if(strTypeCode[i].equals("10")){
    if((i==25)||(!strTypeCode[i-1].equals("10"))){
%>    
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. ������������ʱ�������ṩ����֤��ԭ���������չ�˾��֤�����渴ӡ����</p>
      </blockquote></td>
    </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>    
<%
  }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
    }
  }if(strTypeCode[i].equals("11")){
    if((i==25)||(!strTypeCode[i-1].equals("11"))){
%>
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. ����������ȡ���ʱ�����ṩ���²��Ϻ�֤���������չ�˾��֤�����渴ӡ����</p>
      </blockquote></td>
	   </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>	   
<%
  }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
    }
  }if(strTypeCode[i].equals("99")){
    if((i==25)||(!strTypeCode[i-1].equals("99"))){
%>
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>. ��Ҫ�ṩ����������֤���͵��ݣ�</p>
      </blockquote></td>
	   </tr>
	<tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>	   
<%
    }else{
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p><%=strTypeName[i]%> </p>
      </blockquote></blockquote></td>
	   </tr>
<%
      }
    }
  }
} 
%>	     
  <input type="hidden" name="nodeType" value="CertifDirect">
  </form>
     <jsp:include page="/common/print/PrintButton.jsp" />
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html>