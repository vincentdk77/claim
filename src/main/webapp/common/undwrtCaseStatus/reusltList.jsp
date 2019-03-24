<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.custom.CaseNoQueryDto"%>
<%@page import="com.sinosoft.claim.dto.custom.TurnPageDto"%>
<%@page import="java.util.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.claim.dto.custom.UndwrtCaseStatusDto"%>
<%
  ArrayList<UndwrtCaseStatusDto> undwrtCaseStatusDtoList = (ArrayList<UndwrtCaseStatusDto>)request.getAttribute("undwrtCaseStatusDtoList");
%>
<html xmlns:v="urn:schemas-microsoft-com:vml">

<head>
    <app:css />

  <title>核赔工作流信息补传</title>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script type="text/javascript">
  	function submitform(button1){
        var flag = false;
        if(fm1.selectSerial.length != null){
	        for (var i = 0;i < fm1.selectSerial.length;i++)
	        {
	          if(fm1.selectSerial[i].checked)
	          {
	          	flag= true;
	          }
	        }
	      }else{
	      	if(fm1.selectSerial.checked){
        		 flag= true;
        	 }
	      }
        if(!flag){
        	alert("请选择要补传的数据！");
          	return;
        }
  		if(confirm("确认补传？")){
  			fm1.action = "/claim/undwrtCaseStatus.do?editType=passVeric";
  			button1.disabled = true;
  			fm1.submit();
  		}
  	}
  	function submitform1(button1){
        var flag = false;
        if(fm1.selectSerial.length != null){
	        for (var i = 0;i < fm1.selectSerial.length;i++)
	        {
	          if(fm1.selectSerial[i].checked)
	          {
	          	flag= true;
	          }
	        }
	     }else{
	     	 if(fm1.selectSerial.checked){
        		 flag= true;
        	 }
	     }
        if(!flag){
        	alert("请选择要补传并结案的数据！");
          	return;
        }
  		if(confirm("确认补传并结案？")){
  			fm1.action = "/claim/undwrtCaseStatus.do?editType=passVericAndCloseFlow";
  			button1.disabled = true;
  			fm1.submit();
  		}
  	}
  </script>
  <html:base/>
</head>

<body  >
<form name="fm1" action=""  method="post">
      

  <table class=common style="width=100%" >
  	<tr><td class="formtitle" colspan="9">核赔工作流信息补传数据信息</td></tr>
  	<tr>
  		<td class="formtitle" style="width=3%">选择</td>
  		<td class="formtitle" style="width=5%">序号</td>
	  	<td class="formtitle" style="width=17%">理算书号</td>
		<td class="formtitle" style="width=14%">立案号</td>
		<td class="formtitle" style="width=14%">报案号</td>
		<td class="formtitle" style="width=13%">审核提交时间</td>
		<td class="formtitle" style="width=25%">处理意见</td>
		<td class="formtitle" style="width=9%">处理人员代码</td>
  	</tr>
  	<%
  	 for(int i = 0;i<undwrtCaseStatusDtoList.size();i++){
  		UndwrtCaseStatusDto dto = (UndwrtCaseStatusDto)undwrtCaseStatusDtoList.get(i);
  	%>
  	<tr>
  			<td align="center" style="width=5%">
				<input  type = "checkbox"  name= "selectSerial" value= "<%= i %>"/>
			</td>
  			<td align="center" style="width=5%"><%=i+1 %></td>
	  		<td align="center" style="width=17%">
	  			<input class = "readonly" type = "text" readonly name= "compensateno" value= "<%=dto.getCompensateno() %>"/>
	  		</td>
			<td align="center" style="width=14%">
				<input class = "readonly" type = "text" readonly name= "claimno" value= "<%=dto.getClaimno() %>"/>
			</td>
			<td align="center" style="width=14%">
				<input class = "readonly" type = "text" readonly name= "registno" value= "<%=dto.getRegistno() %>"/>
			</td>
			<td align="center" style="width=13%">
				<input class = "readonly" type = "text" readonly name= "submittime" value= "<%=dto.getSubmittime() %>"/>
			</td>
			<td align="center" style="width=25%">
				<input class = "readonly" type = "text" readonly name= "notionInfo" value= "<%=dto.getNotionInfo() %>"/>
			</td>
			<td align="center" style="width=9%">
				<input class = "readonly" type = "text" readonly name= "handlerCode" value= "<%=dto.getHandlerCode() %>"/>
				<input  type = "hidden" readonly name= "Lflowid" value= "<%=dto.getLflowid() %>"/>
				<input  type = "hidden" readonly name= "Llogno" value= "<%=dto.getLlogno() %>"/>
			</td>
	  	</tr>	
  	<% 
  	 }
  	%>
  	<tr align="center" >
  		<td align="center"  colspan="9">
  			<center>
  			<input type = "button" class="button" value="补传"  onclick = "submitform(this);"/>
  		    <input type = "button" class="button" value="补传并结案"  onclick = "submitform1(this);"/>
  			</center>
  		</td>
  	<tr>
  </table>
</form>  

<script language="javascript">

</script>
</body>
</html>