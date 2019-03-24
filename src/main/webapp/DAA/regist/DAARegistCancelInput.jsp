<%--
****************************************************************************
* DESC       ：报案注销处理页面
* AUTHOR     ：sinosoft
* CREATEDATE ：2005-07-14
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
 <%
  //得到案件注销标志
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
 <!--立案注销/拒赔处理入口-->
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" /> 
   <script language=javascript>
       function submitForm()
      {
        
         var context = fm.prpLregistTextContextInnerHTML.value;
         if(fm.prpLclaimRegistNo.value==null||(fm.prpLclaimRegistNo.value).length<1)
         {
           alert("报案号不能为空!");
           return false;
         }
         if(context.length<1){
           alert("撤销原因描述不能为空!");
           fm.prpLregistTextContextInnerHTML.focus();
           return false;
         }
         if(fm.classCode.value == "05" && (isEmptyField(fm.CancelReason) || isEmptyField(fm.CancelReasonName))){
            alert("撤销原因不能为空!");
           return false;
         }
         //判断选择的保单号码
         
         var policyCount =parseInt(fm.txtPolicyCount.value);
         var haveselect=0; //默认不选中一个保单
         var allpolicySelect=1;
         
         //alert(policyCount)
          if (policyCount==1){ //只有一个保单号的情况下
           if (fm.txtcheckadd.checked==false){
               alert("请至少选择一项需要注销的保单！")
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
               alert("请至少选择一项需要注销的保单,或者选择报案全部注销 ！")
               return;
              }
         
         }
         
         //假设设置全部进行注销的情况，即使选的是一个保单，也可以进行操作的。
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
  	        errorMessage = "此报案已注销";
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
                    <td class="formtitle">报案撤销处理</td>
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
               <input type="text" name="prpLclaimRegistNo" class="readonly"  title="报案号" maxlength="22"  readonly="true"  value="<bean:write name='prpLregistDto' property='registNo' filter='true' />">
               <input type="hidden" name="classCode" value="<bean:write name='prpLregistDto' property='classCode' filter='true' />">
            </td>
         </tr>
         
         
          <%  
          String selectToCancle="0";          //是否可以选择用来进行注销的保单
          String haveCheck="";                //默认是否选中
          String haveCheckdisable="";         //是否允许进行选择
          String haveCancled="";              //已经注销过了。
          int rowcount=0;
          %>
        
          <logic:iterate id="relatePolicyList1"  name="registDto"  property="prpLRegistRPolicyList">  
          
            <%  haveCheckdisable=""; //默认不能选择check
                haveCheck="checked";           //默认选择check
                rowcount= rowcount+1;        //记录保单的条数
                haveCancled="";              //没有注销过
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
              <input type="text" name="prpLclaimPolicyNo" class="readonly"  title="保单号" maxlength="22"  readonly="true"  value="<bean:write name='relatePolicyList1' property='policyNo' filter='true' />">
            </td>
            <td class="title" style="width:15%">保单类型:</td>
            <td class="input" style="width:35%">
                <logic:equal name="relatePolicyList1"  property="policyType" value="1">
                   商业保单
                </logic:equal>

               <logic:equal name="relatePolicyList1"  property="policyType" value="3">
                   强制保单
                </logic:equal>
               </td>
            
         </tr>
         </logic:iterate>
         
         <% 
         String allCancel="Style='display:none'";
         if  (rowcount>1) {
          allCancel="";
          //考虑了一下，如果一个案件已经立案了，如果没有注销的情况下，也是不能进行全部报案注销的。
         
         }%>
         
          <tr <%=allCancel%> >
            <td class="title" style="width:15%;valign:bottom">撤销选项:</td>
            <td class="input" style="width:35%;valign:bottom" colspan="3">
              <input type="checkbox"  class="" name="txtCheckallCancel" style="width:20px" value="ON" >  报案全部撤销
            </td>
         </tr>
         
         
         <tr>
         <input type="hidden" name="txtPolicyCount" value="<%=rowcount%>"> 
         <input type="hidden" name="txtAllCancle" value=""> 
             <td class="title" colspan="<%=colspan %>">
              撤销原因：
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
              <!--确 定按钮-->
              <input type=button name=buttonSave class='button' value="<bean:message key='button.submit.value' />" onClick="submitForm();">
           </td>
	       <!--取消按钮-->
	       <td class=button style="width:25%" align="center">
	         <input type=button name=buttonCancel class='button' value="返回" onclick="history.back();" >
           </td>
	    </tr>
     </table>
  </form>   
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->


</html:html>
