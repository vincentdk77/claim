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
      RegistDto registDto = (RegistDto)request.getAttribute("registDto");
      String registNo = "";
      registNo = registDto.getPrpLregistDto().getRegistNo();
      String policyNo = registDto.getPrpLregistDto().getPolicyNo();
      
      UIPolicyAction uiPolicyAction = new UIPolicyAction();
      PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(policyNo);
      PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
      
      UICodeAction uiCodeAction = new UICodeAction();
      String strCode = "";
      String strName = "";
      strCode = StringConvert.encode(registDto.getPrpLregistDto().getComCode());
      strName = uiCodeAction.translateComCode(strCode,true); 
      
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
<table width="92%" align="center" cellspacing="0" cellpadding="0" border="0"> 
  <tr> 
    <td colspan=4 height="20">
        <p><ins><%=prpCmainDto.getInsuredName()%></ins>��</p>
      </td>
	   </tr>
  <tr> 
    <td colspan=4 height="20"><p> &nbsp;&nbsp;&nbsp;&nbsp;������Ͷ���Ļ��������������¹ʣ����������ҹ�˾�ύ�����������������������顷��ͬʱ�������ҹ�˾��Ҫ���ṩ���� 
        �йص�֤��������������ѣ�����ʱ����˾�ķ���ר�ߵ绰 ��__________�����ҹ�˾���߳�Ϊ���ṩ���ʡ���Ч�ı��շ��� лл���ĺ�����</p></td>
	   </tr>
	<tr> 
    <td colspan=4 height="20"><blockquote>
        <p>���������������������ϸ���£�</p>
      </blockquote></td>
	   </tr><br>
<%if(certifyDtoCount > 25){
    certifyDtoCount = 25;
  }  
  for(int i=0;i<certifyDtoCount;i++){
    prpLcertifyDirectDto = (PrpLcertifyDirectDto)certifyDto.getPrpLcertifyDirectDtoList().get(i); 
    String typeName = "";
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
    if(i > 0 && !strTypeCode[i-1].equals("03")){
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
    if(i > 0 && !strTypeCode[i-1].equals("04")){
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
    if((i > 0 && !strTypeCode[i-1].equals("05"))){
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
    if(i > 0 && !strTypeCode[i-1].equals("06")){
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
    if(i > 0 && !strTypeCode[i-1].equals("07")){
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
    if(i > 0 && !strTypeCode[i-1].equals("08")){
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
    if(i > 0 && !strTypeCode[i-1].equals("09")){
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
    if(i > 0 && !strTypeCode[i-1].equals("10")){
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
    if(i > 0 && !strTypeCode[i-1].equals("11")){
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
    if(i > 0 && !strTypeCode[i-1].equals("99")){
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
    else if(i==24){
%>
  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p>(���ݹ��࣬�������ݼ���һҳ)</p>
      </blockquote></blockquote></td>
	   </tr>
<%  }  
  }
}
    if(certifyDtoCount < 25 ){
      for(int j=0;j<30-certifyDtoCount;j++){
%>
	  <tr height="20"> 
    <td colspan=4><blockquote><blockquote>
        <p></p>
      </blockquote></blockquote></td>
	   </tr> 
<%
    }
  }
%>  	     
  <tr> 
    <td colspan=4 height="20"><p>&nbsp;&nbsp;&nbsp;&nbsp;����ע�⣺Ϊȷ�����ܹ���ø���ȫ�桢����ı����⳥���ҹ�˾����������У�������Ҫ����һ���ṩ�������е�֤ ���������֤�����ϡ���ʱ���ҹ�˾����ʱ֪ͨ������л�������ǹ����������֧�֣�</p></td>
	   </tr>
	   <tr>
	     <td  colspan=4><hr></td>
	   </tr>
  </table>
  <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0"> 	   
     <tr height="30">
	     <td width="30%">�������ˣ� </td>
		   <td width="20%"><%=prpCmainDto.getInsuredName()%></td>
		   <td width="30%">���չ�˾��</td>
		   <td width="20%"><%=strName%></td>
	   </tr> 
	   <tr height="30">
	     <td>�쵽��������֪�����ڣ�</td>
		   <td>____��____��____��</td>
		   <td>������������֪�����ڣ�</td>
		   <td>____��____��____��</td>
	   </tr> 
	   <tr height="30">
	     <td>ȷ��ǩ�֣�</td>
		   <td></td>
		   <td>������ǩ�֣�</td>
		   <td></td>
	   </tr> 
	   <tr height="30">
	     <td>�ύ����������ڣ�</td>
		   <td>____��____��____��</td>
		   <td>�յ�����������ڣ�</td>
		   <td>____��____��____��</td>
	   </tr> 
	   <tr height="30">
	     <td>ȷ��ǩ�֣�</td>
		   <td></td>
		   <td>������ǩ�֣�</td>
		   <td></td>
	   </tr> 
  </table>
  <br>


  <input type="hidden" name="nodeType" value="CertifDirect">
  <script language='javascript'>
      function printPage()
      {
        tbButton.style.display = "none";
        window.print();
      }
    </script>    
      <%-- include��ӡ��ť --%>
      <!--<jsp:include page="/common/print/PrintButton.jsp" />     -->
   <table id="tbButton" cellpadding="0" cellspacing="0" width="80%" style="display:">
      <tr>
        <td class=button style="width:33%" align="center">
          <input type=button name=buttonPrint value=" �� ӡ " class="button" onclick="return printPage()">
        </td>
<%
  if(certifyDto.getPrpLcertifyDirectDtoList().size()>24){
%> 
  <td class=button style="width:33%" align="center">
          <input type=button name=buttonPage value=" �� ҳ " class="button" onclick="return certifyDirectAdd('<%=registNo%>','certi','<%=index%>')">
        </td>
<%
  }
%>       
        <td class=button style="width:33%" align="center">
          <input type=button name=buttonClose value=" �� �� " class="button" onclick="javascript:window.close()">
        </td>
      </tr>
    </table>
  </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html>