<%--
****************************************************************************
* DESC       ������ע������ҳ��
* AUTHOR     ��sinosoft
* CREATEDATE ��2005-07-14
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %><head>
   

<%@ page import="com.sinosoft.claim.dto.domain.*" %>
 
 <%
  //�õ�����ע����־
  String strCancelFlag = (String)request.getAttribute("strCancel");
  
 %>
<html:html locale="true"> 
 <!--����ע��/���⴦�����-->
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  
   <script language=javascript>
     
      
      function submitForm()
      {
        var context =fm.contextInnerHTML.value;
         if(context.length<1){
           alert("ע��ԭ����Ϊ��!");
           fm.contextInnerHTML.focus();
           return false;
         }     
         fm.submit();
         fm.buttonSave.disabled = true;
      }
     
    </script>
  </head>

<body class=interface onload="initPage()">
<form name=fm action="/claim/flowNodeCancel.do" method="post" onsubmit="return validateForm(this);">

     
       <%String flowID=request.getParameter("swfLogFlowID");
         String logNo=request.getParameter("swfLogLogNo");
         String policyNo=request.getParameter("policyNo");
         String registNo=request.getParameter("registNo");
         String nodeType=request.getParameter("nodeType");
         
         String lossItemName=request.getParameter("lossItemName");
         String nodeName="��������";
         
         if ("wound".equals(nodeType)){
         nodeName="����";
         }
         if ("propc".equals(nodeType)){
         nodeName="�Ʋ���ʧ";
         }
         
       %>
       
        <input type="hidden" name="swfLogFlowID" value="<%=flowID%>">
        <input type="hidden" name="swfLogLogNo" value="<%=logNo%>">
        <input type="hidden" name="editType" value="ScheduleCancel">
        
              
           
       <table width="100%" border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
          <tr> 
           
            <td class="formtitle" colspan="4">��������ע������</td></tr>
         <tr>
            <td class="title" style="width:15%;valign:bottom"><bean:message key="db.prpLclaim.registNo" />:</td>
            <td class="input" style="width:35%;valign:bottom" >
               <input type="text" name="RegistNo" class="readonly"  title="������" maxlength="22"  readonly="true"  value="<%=registNo%>">
            </td>
            <td class="title" style="width:15%;valign:bottom">��������:</td>
            <td class="input" style="width:35%;valign:bottom" >
             <input class="readonly" readonly value="<%=policyNo%>">
            </td>
            
         </tr>
         
         <tr>
            <td class="title" style="width:15%;valign:bottom">��������:</td>
            <td class="input" style="width:35%;valign:bottom" > 
            <input class="readonly" readonly value="<%=nodeName%>">
            </td>
            <td class="title" style="width:15%;valign:bottom">������:</td>
            <td class="input" style="width:35%;valign:bottom" >
            <input class="readonly" readonly value="<%=lossItemName%>">
            </td>
            
         </tr>
         
         <tr>
             <td class="title" colspan="6">
              ע��ԭ��
             </td>
         </tr>
         <tr>
           <td class="input" colspan="6" align="center">
             <textarea wrap="hard" rows=15 cols=80 style="width:505px" maxlen=80 name="contextInnerHTML"></textarea>              
           </td>
         </tr>
     </table>     
     <table class="common" align="center">
        <tr>
      	   <td class=button style="width:25%" align="center">
              <!--ȷ ����ť-->
              <input type=button name=buttonSave class='button' value="<bean:message key='button.submit.value' />" onClick="submitForm();">
           </td>
	       <!--ȡ����ť-->
	       <td class=button style="width:25%" align="center">
	         <input type=button name=buttonCancel class='button' value="����" onclick="history.back();" >
           </td>
	    </tr>
	    
     </table>
  </form>   
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
