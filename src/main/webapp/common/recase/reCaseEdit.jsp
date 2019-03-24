<%--
****************************************************************************
* DESC       ：申请重开赔案主画面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-11-26
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="com.sinosoft.claim.ui.control.action.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*"%>
<%@ page import="com.sinosoft.claim.dto.domain.*"%>
<%@ page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.sinosoft.claim.util.*"%>
<%@page import="com.sinosoft.function.power.ui.action.UIPowerAction"%>
<%@page  import="com.sinosoft.sysframework.common.datatype.DateTime"%>

<%
 
    
   PrpLclaimDto prpLclaimDto = (PrpLclaimDto)request.getAttribute("prpLclaimDto");
   UIClaimAction   uiClaimAction  =new  UIClaimAction ();   
   ClaimDto claimDto= uiClaimAction.findByPrimaryKey(prpLclaimDto.getClaimNo());
   UserDto   user      = (UserDto)session.getAttribute("user");
   String editType = (String)request.getAttribute("editType");
   PrpLrecaseDto prpLrecaseDto = (PrpLrecaseDto)request.getAttribute("prpLrecaseDto");
   
   String ended="";
    String recaseend="";
   if (!prpLclaimDto.getEndCaseDate().toString().equals("")){
        ended ="y";  //已结案
      }
      else{
        ended ="n";
      }
   if(prpLrecaseDto!=null){
   if (!prpLrecaseDto.getCloseCaseDate().toString().equals("")){
        recaseend ="y";//重开赔案已结束
      }else{
        recaseend ="n";
      }
   }else{recaseend ="y";}  
%>


<html:html locale="true">
<head>
   <title>重开赔案</title>
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
   <script language='javascript'>
  
   function checkendCase()
   {
   
     var ended="<%=ended%>";
     var recaseend="<%=recaseend%>";
     if (recaseend=="n"){
    	alert("此案件上次重开赔案尚未结案,不能再次重开赔案");
     	fm.buttonSave.disabled = true;
        return false;
     }
   	 if (ended=="n"){
     	alert("此案件未结案不能重开赔案");
     	fm.buttonSave.disabled = true;
        return false;
     }
     return true;
   }
  
   function submitForm()
    {
        //ajax判断照片是否上传
        //var checkMsg = true;
        //$.ajax({
				   //type: "POST",
				   //url: "/claim/claimCancelCheckCertify.do",
				   //data: "&type=2&ClaimNo="+fm.ClaimNo.value,
				  // async: false,
				   //success: function(msg){
				     //if(msg.trim()=="1"){
   					 	//alert("至少上传一张重开赔案照片！");
   					 	//checkMsg = false;
   					 //}
				   //}
			 //}); 
       // if(!checkMsg){
            //return false;
        //}
    
    if(checkendCase()==true)
	  	{
        fm.submit();
      }
   
    }

    function resetForm()
    {
      fm.reset();
    }
  </script>
</head>

<body  class="interface" onload="initPage();">

<%-- 调用loadForm 初始化页面 --%>
<body class="interface" onload="initPage();">
  <form name=fm action="/claim/appRecase.do" method="post" onsubmit="return validateForm(this);">
  <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">

    <table class="common" cellpadding="5" cellspacing="1">
  	  <tr>
  	  		  	<td class=formtitle colspan="4">重开赔案</td>
  	  </tr>
  	    <%if("UWTSHOW".equals(editType)){ %>
	    <tr>
	      <td>
	        <td><input type="button" name="eCertify" class="bigbutton" value="电子单证" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLclaimDto' property='registNo' filter='true' />','check');"></td> 
	      </td>
	    </tr>
	  <%} %>
      <tr>
        <td class="title">立案号：</td>
        <td class="input">
          <input type='hidden' name='RiskCode' value="<bean:write name='prpLclaimDto' property='riskCode' />">
          <input name="ClaimNo" class="readonly" readonly value="<bean:write name='prpLclaimDto' property='claimNo' />">
        </td>
        <td class="title">保单号：</td>
        <td class="input">
          <input name="PolicyNo" class="readonly" readonly value="<bean:write name='prpLclaimDto' property='policyNo' />">
        </td>
      </tr>
      <tr>
        <td class="title">上次结案时间：</td>
        <td class="input">
           <input name=endCaseDate class="readonly" readonly value="<bean:write name='prpLclaimDto' property='endCaseDate' />">
        </td>
        <td class="title">上次结案操作员：</td>
        <td class="input">
           <input name="ItemCode" class="readonly" readonly value="<bean:write name='prpLclaimDto' property='endCaserCode' />">
        </td>
      </tr>
      <tr>
        <td class="title">重开赔案时间：</td>
        <td class="input"> 
    <input name=reCaseDate type="input" class="readonly" value="<%=new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString()%>">
        </td>
        <td class="title">操作员：</td>
        <td class="input">
             <input name="reCasehandleCode" type="input" class="readonly" value="<%= user.getUserCode() %>">
        </td>
      </tr>
      <tr>
          <td class="title" colspan=4>重开赔案原因：</td>
      </tr>
      <tr>
           <td class="input" colspan="4" align="center">
            <input type='hidden' name="riskCode"  value="<bean:write name='prpLclaimDto' property='riskCode' />">
             <textarea name='appRecaseReason' wrap="hard" rows=15 cols=80 class=common ><logic:notEmpty name="prpLrecaseDto"><bean:write name='prpLrecaseDto' property='reCaseReason' /></logic:notEmpty></textarea>
            </td>
     </tr>
    </table>
  <%if(!"SHOW".equals(editType) && !"UWTSHOW".equals(editType)){ %>
  <input type="hidden" name="editType" value="SAVE">
  <table class="common" align="center">
    <tr>
      <td class="button" >
        <input type="button" name="buttonSave" value=" 确 定 " class="button" onclick="submitForm();">
      </td>
      <td class="button" >
        <input type="button" name="buttonCancel" value=" 取 消 " class="button" onclick="resetForm();">
      </td>
      <td>
        <td><input type="button" name="eCertify" class="bigbutton" value="电子单证" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLclaimDto' property='registNo' filter='true' />','check');"></td> 
      </td>
    </tr>
  </table>
  <%} %>
</form>
</body>
<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>
