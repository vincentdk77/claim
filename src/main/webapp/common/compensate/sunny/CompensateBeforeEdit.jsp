<%--
****************************************************************************
* DESC       ：录入实赔前输入立案号页面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-05-19
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sinosoft.claim.dto.domain.PrpDcodeDto"%>
<%@ page import="com.sinosoft.claim.dto.domain.PrpLdeductCondDto"%>
<%@ page import="com.sinosoft.claim.ui.control.action.UIDeductCondAction" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>



<%
   String rechoseFlag =(String) request.getAttribute("rechoseFlag");
   String compensateNo =(String) request.getAttribute("compensateNo");
   ArrayList  prpLdeductCondDtolist = (ArrayList)request.getAttribute("prpLdeductCondDtolist");

  //根据险别显示免赔条件
	List prpDCodeList = (ArrayList)request.getAttribute("prpDCodeList");	
	String driverFlag = (String) request.getAttribute("driverFlag");
%>
<html>
<head>
	<title>查询实赔信息</title>
	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<jsp:include page="/common/pub/StaticJavascript.jsp" />

	<script language='javascript'>
	    
	    /**
    	初始化脚本
    	*/
    	function loadForm(){
    	var deduct = document.getElementsByName("deductCondition");
    	var flag = document.getElementsByName("timesFlag");
    	for(var i=0;i<deduct.length;i++){
	    	if( deduct[i].checked == true && flag[i].value == "'1'"){
				fm.ATimes.style.display = "";
			}
		}
	  	
    	
    	}
      	  
	  
	  
      /**
       @author      任轶群
       @description 校验
       @param       无
       @return      boolean,合法返回true,不合法返回false
      */
      function checkForm()
      {
      	if(isEmptyField(fm.ClaimNo))
      	{
      		fm.ClaimNo.focus();
      		errorMessage("立案号不能为空!");
      		return false;
      	}
      	
      	var deduct = document.getElementsByName("deductCondition");
      	var timesArray = document.getElementsByName("Times");
      	var flag = document.getElementsByName("timesFlag");
      	var deductName = document.getElementsByName("deductName");
      	for(var i=0;i<deduct.length;i++){
      	  if(deduct[i].checked == true && flag[i].value == "'1'"){
      	    if(isEmptyField(timesArray[i])){
      	      timesArray[i].focus();
      	      errorMessage(deductName[i].value+"不能为空!");
      			  return false;
      	    }
      	    if(timesArray[i].value == '0'){
      	      timesArray[i].focus();
      	      errorMessage(deductName[i].value+"不能为零!");
      			  return false;
      	    }
      	  }
      	}
      	return true;
      }
      
     function displayTimes(obj){
      var timesArray = document.getElementsByName("Times");
      var findex;
      
      for(var i=2;i<fm.all(obj.name).length;i++){
        if( fm.all(obj.name)[i] == obj ){
          findex=i; 
          break;
        }
      }
      if(obj.checked == true){
        timesArray[findex].value = "1";
      }else{
        timesArray[findex].value = "0";
      }
      var timeflag = document.getElementsByName("timesFlag");
      if(obj.checked == true && timeflag[findex].value == "'1'"){
  				timesArray[findex].style.display = "";
      }else{
  				timesArray[findex].style.display = "none";
      }
		}	




      /**
       @author      miaowenjun
       @description 提交方法
       @param       无
       @return      无
      */
	function submitForm(){
      if(!checkForm()){
         return false;
      }
      fm.submit();
    }
    
 
	

	
    </script>
</head>

<body onload="initPage()">
		
<form name="fm" action="/claim/compensateBeforeEdit.do" method="post" onsubmit="return validateForm(this);">
	<table border="0" align="center" cellpadding="5" cellspacing="1" class="common">
		<!-- modify by wuxiaodong 050905 begain reasin 将输入立案号（赔款计算书）改为选择免赔条件-->
		<!--
		    <tr><td colspan=2 class="formtitle">输入立案号（赔款计算书）</td></tr>
	    -->
		<tr>
			<td colspan=2 class="formtitle">
				选择免赔条件
			</td>
		</tr>
		<!-- modify by wuxiaodong 050905 end -->
		<tr>
			<td class='title2'>
				立案号：
			</td>
			<td class='input2'>	
				<input type=text name="ClaimNo" class="readonly" readonly value="<%= request.getParameter("ClaimNo") %>">
				<input type="hidden" name="swfLogFlowID" value="<%= request.getParameter("swfLogFlowID") %>">
				<input type="hidden" name="swfLogLogNo" value="<%= request.getParameter("swfLogLogNo") %>">
				<input type="hidden" name="status" value="<%= request.getParameter("status") %>">
				<input type="hidden" name="riskCode" value="<%= request.getParameter("riskCode") %>">
				<input type="hidden" name="editType" value="<%= request.getParameter("editType") %>">
				<input type="hidden" name="nodeType" value="<%= request.getParameter("nodeType") %>">
				<input type="hidden" name="businessNo" value="<%= request.getParameter("businessNo") %>">
				<input type="hidden" name="caseType" value="<%= request.getParameter("caseType") %>">
			</td>
		</tr>
		<tr>
			<td class='title2'>免赔条件：</td>
			<td class='input2'>
					<input type="hidden" name="deductCondition" value="">
					<input type="hidden" name="deductCondition" value="">
					<input type="hidden" name="deductConditionTemp" value="">
					<input type="hidden" name="deductConditionTemp" value="">
					<input type="hidden" name="Times" value="0">
					<input type="hidden" name="Times" value="0">
					<input type="hidden" name="timesFlag" value="">
					<input type="hidden" name="timesFlag" value="">
					<input type="hidden" name="deductName" value="">
					<input type="hidden" name="deductName" value="">
			<%
			String disabled = "";
			String checked = "";
			String timeValue = "0";
			String timeStyle = "width:30;display:none";
			if(prpDCodeList != null && prpDCodeList.size() != 0){
				for(int i=0;i<prpDCodeList.size();i++){
				timeValue = "0";
				timeStyle = "width:30;display:none";
				disabled = "";
				checked = "";
				PrpDcodeDto prpDcodeDto = (PrpDcodeDto)prpDCodeList.get(i);
				if (prpLdeductCondDtolist!=null && prpLdeductCondDtolist.size()>0 ){
				  for (int k=0;k<prpLdeductCondDtolist.size();k++){
				    PrpLdeductCondDto prpLdeductCondDto =( PrpLdeductCondDto) prpLdeductCondDtolist.get(k);
				    if (prpLdeductCondDto.getDeductCondCode().equals( prpDcodeDto.getCodeCode())){
				        checked ="checked";
				        timeValue = Integer.toString(prpLdeductCondDto.getTimes());
				        if(prpLdeductCondDto.getTimes()>0 && ("130".equals(prpLdeductCondDto.getDeductCondCode()) || "190".equals(prpLdeductCondDto.getDeductCondCode())))  timeStyle = "width:30;display:";
				      }
				
				  }
				}
				if(UIDeductCondAction.DeductCondCode.NO_APPOINT_DRIVER.equals(prpDcodeDto.getCodeCode())){
					disabled = " ";
					if(driverFlag.equals("false")){
						checked = "checked";%>
						<input type="hidden" name="driverDeductCondition" value="<%=prpDcodeDto.getCodeCode()%>" >
					<input type="hidden" name="driverTimes" value="1">
				
					<input type="hidden" name="driverDeductName" value="<%=prpDcodeDto.getCodeCName()%>">
					<%}
				}
				%>
				  
					<input type="checkbox" name="deductCondition" <%=disabled%> <%=checked%> value="<%=prpDcodeDto.getCodeCode()%>" onclick="displayTimes(this)">
					<%=prpDcodeDto.getCodeCName()%>
					<input class="common" type="text" name="Times" maxlength='1' width="5" style="<%=timeStyle%>" value="<%=timeValue%>"><br>
					<input type="hidden" name="deductConditionTemp" value="<%=prpDcodeDto.getCodeCode()%>">
					<input type="hidden" name="timesFlag" value="'<%=prpDcodeDto.getFlag()%>'">
					<input type="hidden" name="deductName" value="<%=prpDcodeDto.getCodeCName()%>">
				<%
				 
				}%>
			<%}%>
			</td>
		</tr>
		<tr>
			<td class='button' colspan="2" style="align:center">
		  <!-- 免赔率选择-20060418--start--------------------->
				<%if( rechoseFlag!=null && !rechoseFlag.equals("")&& rechoseFlag.equals("1")) {%>
			   <input  type="hidden"   name="editType"  value="RECHOSE" >
			   <input  type="hidden"   name="prpLcompensateCompensateNo"  value="<%=compensateNo%>" >
				<input type="button" class='button' value="确定" onclick="submitForm();">
			
				<% }else {%>
				<input type="button" class='button' value="下一步" onclick="submitForm();">
				<% }%>
			<!-- 免赔率选择-20060418--start--------------------->	
			</td>
		</tr>
	</table>
</form>
 <!-- 免赔率选择-20060418--start--------------------->
<% if( rechoseFlag!=null && !rechoseFlag.equals("")&& rechoseFlag.equals("1"))
	 {
	 }
   else{%>
     <%-- 立案号对应赔款计算书列表 --%>
     <%@include file="/common/compensate/CompensateMainBeforeEdit.jsp"%>
<% }  %>
 <!-- 免赔率选择-20060418--start--------------------->
</body>
</html>