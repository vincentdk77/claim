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
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
 <%
  //�õ�����ע����־
  String strCancelFlag = (String)request.getAttribute("strCancel");
  PrpLregistDto prpLregistDto = (PrpLregistDto)request.getAttribute("prpLregistDto");
  String colspan = "4";
  String display = "none";
  if("05".equals(prpLregistDto.getClassCode())){
	  colspan = "1";
	  display = "";
  }
 %>
<head> 	
 <html:html locale="true"> 
 <!--����ע��/���⴦�����-->
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" /> 
   <script language=javascript>
       function submitForm()
      {
        
         var context = fm.prpLregistTextContextInnerHTML.value;
         if(fm.prpLclaimRegistNo.value==null||(fm.prpLclaimRegistNo.value).length<1)
         {
           alert("�����Ų���Ϊ��!");
           return false;
         }
         if(context.length<1){
           alert("����ԭ����������Ϊ��!");
           fm.prpLregistTextContextInnerHTML.focus();
           return false;
         }
         if(fm.classCode.value == "05" && (isEmptyField(fm.CancelReason) || isEmptyField(fm.CancelReasonName))){
            alert("����ԭ����Ϊ��!");
           return false;
         }
         //�ж�ѡ��ı�������
         
         var policyCount =parseInt(fm.txtPolicyCount.value);
         var haveselect=0; //Ĭ�ϲ�ѡ��һ������
         var allpolicySelect=1;
         
         //alert(policyCount)
          if (policyCount==1){ //ֻ��һ�������ŵ������
           if (fm.txtcheckadd.checked==false){
               alert("������ѡ��һ����Ҫע���ı�����")
             return;
           }
         }else{
            for (i=0;i<policyCount;i++){
               if (fm.txtcheckadd[i].checked==false) {
                  allpolicySelect=0;
                  }
               if (fm.haveCancled[i].value==""&&fm.txtcheckadd[i].checked==true){
               //alert("ok")
                  haveselect=1;
                  fm.selectToCancle[i].value="1";
               }
             }  
               
             if (fm.txtCheckallCancel.checked==false&&haveselect==0){
               alert("������ѡ��һ����Ҫע���ı���,����ѡ�񱨰�ȫ��ע�� ��")
               return;
              }
         
         }
         
         //��������ȫ������ע�����������ʹѡ����һ��������Ҳ���Խ��в����ġ�
         if (fm.txtCheckallCancel.checked==true) allpolicySelect=1;
         
         fm.txtAllCancle.value=allpolicySelect;
         
        
              
         fm.submit();
         fm.buttonSave.disabled = true;
      }
      
      function initInfo()
      { 
         var errorMessage = "";
         var prpLregistCancel = (fm.prpLregistCancel.value);
         
  	     if (prpLregistCancel=="1") 
      	 {
  	        errorMessage = "�˱�����ע��";
//  	        readonlyAllInput();
  	        fm.buttonSave.disabled=true;
         }
         if (errorMessage.length>0) {
           alert(errorMessage);  
           return false;
         }     
         return true;
      } 
      
      function initRegistText(){
<%
  	    PrpLregistTextDto prpLregistTextDtoText = (PrpLregistTextDto)request.getAttribute("prpLregistTextDto");
        //System.out.println("----pagecontext------"+prpLregistTextDtoText.getContext());  	  
%>  	
  	    fm.prpLregistTextContextInnerHTML.value='<%= prpLregistTextDtoText.getContext() %>';
  	  }
  	

    </script>
  </head>
<body  onload=" initInfo();initRegistText();">
<form name=fm action="/claim/registCancel.do" method="post" onsubmit="return validateForm(this);">

      <table border="0" align="center" cellpadding="0" cellspacing="0" class="common" style="width:90%">
          <tr>
             <td width="30%"> 
               <table width="100%" border="0" cellpadding="0" cellspacing="0">
                 <tr> 
                    <td width ="12"><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
                    <td class="formtitle">������������</td>
                    <td width ="11"><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
                  </tr>
                </table>
             </td>
            <td width="70%" align="right"></td>
          </tr>
      </table>
          
      <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" style="width:90%">
         <tr>
            <td class="title" style="width:15%;valign:bottom"><bean:message key="db.prpLclaim.registNo" />:</td>
            <td class="input" style="width:35%;valign:bottom" colspan="3">
               <input type="text" name="prpLclaimRegistNo" class="readonly"  title="������" maxlength="22"  readonly="true"  value="<bean:write name='prpLregistDto' property='registNo' filter='true' />">
               <input type="hidden" name="classCode" value="<bean:write name='prpLregistDto' property='classCode' filter='true' />">
            </td>
         </tr>
         
         
          <%  
          String selectToCancle="0";          //�Ƿ����ѡ����������ע���ı���
          String haveCheck="";                //Ĭ���Ƿ�ѡ��
          String haveCheckdisable="";         //�Ƿ��������ѡ��
          String haveCancled="";              //�Ѿ�ע�����ˡ�
          int rowcount=0;
          %>
        
          <logic:iterate id="relatePolicyList1"  name="registDto"  property="prpLRegistRPolicyList">  
          
            <%  haveCheckdisable=""; //Ĭ�ϲ���ѡ��check
                haveCheck="checked";           //Ĭ��ѡ��check
                rowcount= rowcount+1;        //��¼����������
                haveCancled="";              //û��ע����
             %>
            <logic:notEqual name="relatePolicyList1"  property="claimNo" value="">
            <% haveCheckdisable="disabled";
               haveCheck=""; 
               %>
            </logic:notEqual>
            
            <logic:equal name="relatePolicyList1"  property="validStatus" value="0">
            <% haveCheckdisable="disabled"; 
               haveCancled="1";
            %>
            </logic:equal>
          
          <tr>
            <td class="title" style="width:15%;valign:bottom"><bean:message key="db.prpLclaim.policyNo" />:</td>
            <td class="input" style="width:35%;valign:bottom" >
              <input type="hidden" name="selectToCancle" value="">
              <input type="hidden" name="haveCancled" value="<%=haveCancled%>">
              <input type="checkbox"  class="" name="txtcheckadd" style="width:20px" value="ON"  <%=haveCheck%> <%=haveCheckdisable%>>&nbsp;
              <input type="text" name="prpLclaimPolicyNo" class="readonly"  title="������" maxlength="22"  readonly="true"  value="<bean:write name='relatePolicyList1' property='policyNo' filter='true' />">
            </td>
            <td class="title" style="width:15%">��������:</td>
            <td class="input" style="width:35%">
                <logic:equal name="relatePolicyList1"  property="policyType" value="1">
                   ��ҵ����
                </logic:equal>

               <logic:equal name="relatePolicyList1"  property="policyType" value="3">
                   ǿ�Ʊ���
                </logic:equal>
               </td>
            
         </tr>
         </logic:iterate>
         
         <% 
         String allCancel="Style='display:none'";
         if  (rowcount>1) {
          allCancel="";
          //������һ�£����һ�������Ѿ������ˣ����û��ע��������£�Ҳ�ǲ��ܽ���ȫ������ע���ġ�
         
         }%>
         
          <tr <%=allCancel%> >
            <td class="title" style="width:15%;valign:bottom">����ѡ��:</td>
            <td class="input" style="width:35%;valign:bottom" colspan="3">
              <input type="checkbox"  class="" name="txtCheckallCancel" style="width:20px" value="ON" >  ����ȫ������
            </td>
         </tr>
         
         
         <tr>
         <input type="hidden" name="txtPolicyCount" value="<%=rowcount%>"> 
         <input type="hidden" name="txtAllCancle" value=""> 
             <td class="title" colspan="<%=colspan %>">
              ����ԭ��
             </td>
             <td class="title" colspan="3" style="display: <%=display %>">
                 <input type="text" class="codecode" name="CancelReason"  style="width:40px" 
                    ondblclick="code_CodeSelect(this, 'CancelReason');"
                    onchange="code_CodeChange(this, 'CancelReason');"
                    onkeyup= "code_CodeSelect(this, 'CancelReason');"
                 >
                 <input type="text"  class="codecode" name="CancelReasonName"  style="width:185px" 
                    ondblclick="code_CodeSelect(this, 'CancelReason','-1','name','post','clear');"
                    onchange="code_CodeChange(this, 'CancelReason','-1','name','post','clear');"
                    onkeyup= "code_CodeSelect(this, 'CancelReason','-1','name','post','clear');"
                 >
             </td>
         </tr>
         <tr>
           <td class="input" colspan="4" align="center">
             <textarea wrap="hard" rows=15 cols=80 style="width:505px" name="prpLregistTextContextInnerHTML"></textarea>              
           </td>
         </tr>
     </table>     
     <input type="hidden" name="prpLregistCancel" value="<%=strCancelFlag%>">
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


</html:html>
