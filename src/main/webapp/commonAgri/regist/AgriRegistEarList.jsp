<!--****************************************************************************************
 * DESC       �����ӿͻ�ҳ��
 * AUTHOR     ��������Ŀ��
 * CREATEDATE ��2005-8-29 10:25
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *
 *****************************************************************************************-->

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
  String serialNo = request.getParameter("serialNo");
  int equalLength = Integer.parseInt(serialNo);
%>
<html:html xhtml="true" locale="true">
  <head>
   <app:css />
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">   
  </head>
  
<body onunload="closeWindow()" scroll="auto">
 <form action="" name="fm" >
  <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title">
   <tr >
    <td align="" colspan="2" style="color:white">
    	���¶�����ѱ���,�Ƿ�����ύ���α�����Ϣ��
    </td>
   </tr>
  <tr>
    <td align="center" class="input">
    	������
    </td>
    <td align="center" class="input">
        �����
    </td>
     
   </tr>
		<%
		if(equalLength > 1){
			for(int i = 0;i < equalLength;i++){
			
		%>
  <tr>
    <td align="center" class="input">
    	<a  href="javascript:showEarInfo('<%=i %>')"><span id="spanRegistNo"></span> </a>
    	<input type="hidden" name="RegistNo" class="readonly" readonly >
    	<!-- -->
    	
    </td>
    <td align="center" class="input">
       <input name="earNo" class="readonly" readonly="true">
    </td>
   </tr>
<%} }else{ %>
    <tr>
    <td align="center" class="input">
    	<a name="registnoHref" href="javascript:showEarInfo(-1)"><span id="spanRegistNo"></span></div></a>
    	<input type="hidden" name="RegistNo" class="readonly" readonly >	
    </td>
    <td align="center" class="input">
       <input name="earNo" class="readonly" readonly="true" >
    </td>
   </tr>

<% }%>	


  <tr align=center >
      <td class="input" colspan="2">
        <input class="button" type="button"  name="buttonSubmit" alt="ȷ��"  value="ȷ��" onclick="FormSubmit();">
      &nbsp;&nbsp;&nbsp;&nbsp;
        <input name="buttonCancel" class="button"  type="button"  alt="ȡ��"  value="ȡ��" onclick="cancel();">
      </td>
    </tr>
    </table>
  </form>
</body>
<script>
      var earNo = window.opener.fm.earNo;
      var registNo = window.opener.fm.registno;
      if(earNo.length == undefined){
	      fm.earNo.value = earNo.value;
	      spanRegistNo.innerHTML = registNo.value;
	      fm.RegistNo.value = registNo.value;
     }else{
          for(var j = 0; j < earNo.length; j++){
	           fm.earNo[j].value = earNo[j].value;
	           spanRegistNo[j].innerHTML =  registNo[j].value;
	           fm.RegistNo[j].value = registNo[j].value;
	      }
     }
     var vRiskCode = window.opener.fm.riskcode.value;
      
   function showEarInfo(index){
   	   var registNo ;
      if(index == -1){
              registNo = fm.RegistNo.value;
       }else{
              registNo = fm.RegistNo[index].value;
       }
    	var url = "/claim/registFinishQueryList.do?prpLregistRegistNo="+registNo+"&editType=SHOW&riskCode=" + vRiskCode;
    	window.open(url,'EarInfo','width=1000,height=850,top=50,left=80,toolbar=0,location=0,directories=0,menubar=0,scrollbars=0,resizable=1,status=0');
    }
     
   function FormSubmit(){
      type = "SUBMIT";
      window.opener.fraInterfaceSubmit();
      window.close();
    }
    function cancel(){
        window.opener.fraInterfaceCancel();
    	window.close();
    }
     function closeWindow(){
    	window.opener.fraInterfaceCancel();
    }
    </script>
   
</html:html>