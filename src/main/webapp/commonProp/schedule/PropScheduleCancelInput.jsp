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
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %><head>
   

<%@ page import="com.sinosoft.claim.dto.domain.*" %>
 
 <%
  //得到案件注销标志
  String strCancelFlag = (String)request.getAttribute("strCancel");
  
 %>
<html:html locale="true"> 
 <!--立案注销/拒赔处理入口-->
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  
   <script language=javascript>
     
      
      function submitForm()
      {
        var context =fm.contextInnerHTML.value;
         if(context.length<1){
           alert("注销原因不能为空!");
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
         String nodeName="车辆定损";
         
         if ("wound".equals(nodeType)){
         nodeName="人伤";
         }
         if ("propc".equals(nodeType)){
         nodeName="财产损失";
         }
         
       %>
       
        <input type="hidden" name="swfLogFlowID" value="<%=flowID%>">
        <input type="hidden" name="swfLogLogNo" value="<%=logNo%>">
        <input type="hidden" name="editType" value="ScheduleCancel">
        
              
           
       <table width="100%" border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
          <tr> 
           
            <td class="formtitle" colspan="4">定损任务注销处理</td></tr>
         <tr>
            <td class="title" style="width:15%;valign:bottom"><bean:message key="db.prpLclaim.registNo" />:</td>
            <td class="input" style="width:35%;valign:bottom" >
               <input type="text" name="RegistNo" class="readonly"  title="报案号" maxlength="22"  readonly="true"  value="<%=registNo%>">
            </td>
            <td class="title" style="width:15%;valign:bottom">保单号码:</td>
            <td class="input" style="width:35%;valign:bottom" >
             <input class="readonly" readonly value="<%=policyNo%>">
            </td>
            
         </tr>
         
         <tr>
            <td class="title" style="width:15%;valign:bottom">定损类型:</td>
            <td class="input" style="width:35%;valign:bottom" > 
            <input class="readonly" readonly value="<%=nodeName%>">
            </td>
            <td class="title" style="width:15%;valign:bottom">定损标的:</td>
            <td class="input" style="width:35%;valign:bottom" >
            <input class="readonly" readonly value="<%=lossItemName%>">
            </td>
            
         </tr>
         
         <tr>
             <td class="title" colspan="6">
              注销原因：
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
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
