<%--
****************************************************************************
* DESC       ：调查申请信息处理页面
* AUTHOR     ：liubvo
* CREATEDATE ：2005-06-14
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************

--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.sysframework.common.datatype.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*"%>
<%@ page import="com.sinosoft.claim.dto.domain.*"%>
<%@ page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.util.*"%>
<%@ page import="com.sinosoft.sysframework.reference.*"%>
<%@ page import="java.util.*"%>

<head>
    <!--对title处理-->

<html:html locale="true">
 <!--调查申请信息处理入口-->
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

  <!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
  <jsp:include page="/common/pub/StaticJavascript.jsp" />

  <script language=javascript>

      function saveForm()
      {
        if (fm.checkNotOver.value == "1") {   //"1"上次调查还没有结束;"0"没有提起过调查，或上次调查结束；
           alert("上次申请调查还没有处理，不能再次申请调查");
           return false;
        }
       //var prplclaimClaimNo=fm.ClaimNo.value
       var context = fm.checkContext.value
      /*
        if(prplclaimClaimNo=="")
        {
        	 errorMessage("调查申请之前必须立案!");
          fm.Context.focus();
          return false;
        }
      */
        context=rightTrim(context);
        context=leftTrim(context);
        
        if(context.length<1)
        {
          errorMessage("调查内容不能为空!");
          fm.checkContext.focus();
          return false;
        }
        fm.buttonSave.disabled = true;
        //window.opener.fm.AcciClaimFlag.value = 'N';
        fm.submit();
      }
      
  
    
//modify by liuyanmei add end 20051028  
      
      
      
    </script>
  </head>

<%

 //--只允许上次提调结束后才能再次申请提调--------
  SwfLogDto  swfLogAcciDto =(SwfLogDto) request.getAttribute("swfLogAcciDto");
  int i=0;
   //String registNo = request.getParameter("RegistNo"); 
    String fowid    = swfLogAcciDto.getFlowID();
   //int logNo    = swfLogAcciDto.getLogNo();
   String checkNotOver="0";
  
   String  conditions2 = "flowid='"+fowid+"' and nodetype='check'";
   SwfLogDto  swfLogDto = null;
  
   UIWorkFlowAction  uiWorkFlowAction = new UIWorkFlowAction();
   System.out.println("--conditions2---1--"+conditions2);
    Collection  swfLogDtoList = uiWorkFlowAction.findNodesByConditions(conditions2);
   System.out.println("--conditions2---2--"+conditions2);
    if(swfLogDtoList.isEmpty()){
      checkNotOver="0";
       System.out.println("------没调查过-----");
     }
    else if(swfLogDtoList.size()!=0) { 
      System.out.println("------有过调查-----");
      //int i=0;
   // if(swfLogDtoList.iterator().hasNext()){
      Iterator it = swfLogDtoList.iterator();
     while (it.hasNext()){
      for (i=0;i<swfLogDtoList.size();i++ ){
        swfLogDto=(SwfLogDto)it.next();
       System.out.println("有过("+swfLogDtoList.size()+")调查");
        String nodeStatus=swfLogDto.getNodeStatus();
        
        if (!nodeStatus.equals("4")){
          checkNotOver="1";
          System.out.println("------上次调查没结束-----");
        }
      }  
     }
  } 
 


%>

<body  onload="initPage();">
<form name=fm action="/claim/applySchedule.do" method="post" onsubmit="return validateForm(this);">


      <table  border="0" align="center" cellpadding="5" cellspacing="1"  class=common>
      <tr><td class="formtitle" colspan="4">调查申请信息处理</td></tr>
         <tr>
            <td class="title" colspan="4">调查申请信息处理
                <input type="hidden" name="swfLogFlowID" class="common" value="<bean:write name='swfLogAcciDto' property='flowID' filter='true' />">
                <input type="hidden" name="swfLogLogNo" class="common" value="<bean:write name='swfLogAcciDto' property='logNo' filter='true' />">
                <input type="hidden" name="nodeStatus" class="common" value="<bean:write name='swfLogAcciDto' property='nodeStatus' filter='true' />">
                <input type="hidden" name="nodeName" class="common" value="<bean:write name='swfLogAcciDto' property='nodeName' filter='true' />">
                <input type="hidden" name="nodeType" class="common" value="<bean:write name='swfLogAcciDto' property='nodeType' filter='true' />">
                <input type="hidden" name="checkNotOver" class="common" value="<%=checkNotOver%>">
            </td>
         </tr>
         <tr>
            <td class="title" >案件性质:</td>
            <td class="input" colspan=3>
               <input type="text" name="claimStatusName" class="readonly"  title="案件性质"  readonly="true"  value="<bean:write name='swfLogAcciDto' property='nodeName' filter='true' /><bean:write name='swfLogAcciDto' property='nodeStatusName' filter='true' />">
            </td>
         </tr>
         <tr>
            <td class="title" ><bean:message key="db.prpLclaim.registNo" />:</td>
            <td class="input">
               <input type="text" name="registNo" class="readonly"  title="报案号" maxlength="22"  readonly="true"  value="<bean:write name='prpLacciCheckDto' property='registNo' filter='true' />">
            </td>
            <td class="title" >立案号:</td>
            <td class="input">
               <input type=text name="claimNo" title="" class="readonly"  readonly="true" value="<bean:write name='prpLacciCheckDto' property='claimNo' filter='true' />">
            </td>
         </tr>
         <tr>
            <td class="title" >计算书号:</td>
            <td class="input">
               <input type="text" name="compensateNo" class="readonly"  title="计算书号"  readonly="true"  value="<bean:write name='prpLacciCheckDto' property='compensateNo' filter='true' />">
            </td>
            <td class="title" >申请人:</td>
            <td class="input">
               <input type="hidden" name="specialCaseDealerCode" title="赔案申请人" class="readonly" value="<bean:write name='swfLogAcciDto' property='handlerCode' filter='true' />">
               <input type=text name="specialCaseDealerName" title="赔案申请人" class="readonly" value="<bean:write name='swfLogAcciDto' property='handlerName' filter='true' />">
            </td>
         </tr>

          <tr>
            <td class="title">申请时间：</td>
            <td class="input" colspan=2>
                <input type=text name="specialCaseflowInTime" title="申请时间" class="readonly"  value="<%= new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY) %>">
            </td>
            <td class="input" colspan=1>
                <input type=button name=buttonScheduleHistory class='bigbutton' value="历次调查" onclick="showScheduleHistory('<bean:write name='prpLacciCheckDto' property='registNo' filter='true' />');" >
            </td>
         </tr>
         <tr>
             <td class="title" colspan="1">调查人：</td>
            <td class="input" colspan=3>
                <input type=text name="checkerCode" title="调查人" class="common" maxLength=5>
            </td>
         </tr>
         <tr>
             <td class="title" colspan="1">调查内容：</td>
            <td class="input" colspan=3>
                <!--textarea name='checkContext' wrap="hard"  title="调查内容" rows=15 cols=80 class=common ></textarea-->
                <input type=text name="checkContext" title="调查内容" class="input"  maxLength=255>
            </td>
         </tr>
     </table>
    </tr>
  </table>

     <table class="common" align="center" >
        <tr >
      	   <td class=button align="center">
              <!--确定按钮-->
              <input type=submit name=buttonSave class='button' value="申请" onclick="return saveForm();">
           </td>
           <td class=button  align="center">
           <!--取消按钮-->
            <input type="button" name=buttonCancel class='button' value="返回" onclick="javascript:history.back();" >
           </td>

	         <!--取消按钮-->
	         <td class=button  align="center">
	          <logic:equal name='swfLogAcciDto' property='nodeType' value='regis' >
	            <input type=hidden name="certiType" title="发起节点" class="readonly" value="01">
	            <input type=hidden name="certiNo" title="发起节点的业务号码" class="readonly" value="<bean:write name='prpLacciCheckDto' property='registNo' filter='true' />">
	         </logic:equal>
	         <logic:equal name='swfLogAcciDto' property='nodeType' value='claim' >
	           <logic:notEqual name='swfLogAcciDto' property='nodeStatus' value='0' >
	              <input type=hidden name="certiType" title="发起节点" class="readonly" value="03">
	              <input type=hidden name="certiNo" title="发起节点的业务号码" class="readonly" value="<bean:write name='prpLacciCheckDto' property='claimNo' filter='true' />">
	           </logic:notEqual>
	           <logic:equal name='swfLogAcciDto' property='nodeStatus' value='0' >
	              <input type=hidden name="certiType" title="发起节点" class="readonly" value="03">
	              <input type=hidden name="certiNo" title="发起节点的业务号码" class="readonly" value="<bean:write name='prpLacciCheckDto' property='registNo' filter='true' />">
	           </logic:equal>
	         </logic:equal>
	          <logic:equal name='swfLogAcciDto' property='nodeType' value='certi' >
              <input type=hidden name="certiType" title="发起节点" class="readonly" value="04">
              <input type=hidden name="certiNo" title="发起节点的业务号码" class="readonly" value="<bean:write name='prpLacciCheckDto' property='claimNo' filter='true' />">
           </logic:equal>
	         <logic:equal name='swfLogAcciDto' property='nodeType' value='compe' >
	         <input type=hidden name="certiType" title="发起节点" class="readonly" value="05">
	         <input type=hidden name="certiNo" title="发起节点的业务号码" class="readonly" value="<bean:write name='prpLacciCheckDto' property='claimNo' filter='true' />">
	         </logic:equal>
	         <logic:equal name='swfLogAcciDto' property='nodeType' value='compp' >
	         <input type=hidden name="certiType" title="发起节点" class="readonly" value="07">
	         <input type=hidden name="certiNo" title="发起节点的业务号码" class="readonly" value="<bean:write name='prpLacciCheckDto' property='compensateNo' filter='true' />">
	         </logic:equal>
         </td>
	     </tr>
     </table>
  </form>
</body>

</html:html>
