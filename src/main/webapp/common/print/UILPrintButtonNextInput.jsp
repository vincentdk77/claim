
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime;"%>
<script src="/claim/DAA/print/js/DAAPrintBeforeEdit.js"></script>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
<html:html locale="true">
	<head>
<% 	
		String strTitleName =request.getParameter("TitleName");
		String strBizName =request.getParameter("BizName"); 
		String strPrintType = request.getParameter("printType");
%>		
	<script language='javascript'>
		function loadForm()
		{
        	fm.printType.value="<%=strPrintType%>";
		}
		
		function checkForm()
		{
	        if (fm.BizNo.value=="")
	        {
	          fm.BizNo.focus();
	          errorMessage("号码不能为空");
	          return false;
	        }
	        // 打印拒赔通知单前检查此赔案是否可以进行拒赔打印
	        if (fm.printType.value=="ClaimRefuse") {
	            var no = fm.BizNo.value;
	  			var vURL = "/claim/common/check/CheckClaimRefuse.jsp?BusinessNo="+no;
      			var responseText = getResponseText(vURL);
	  			if(trim(responseText) == "false"){
	        		errorMessage("请检查立案号 ‘" + fm.BizNo.value + "’，\n此赔案未进行立案拒赔(注销)，或其未或审批，不允许打印。");
	            	return false;
	            }
	        }
	        return true;
		}
		
		function getResponseText(strURL)
		{
  			var objXmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  			objXmlHttp.Open("POST",strURL,false);
  			objXmlHttp.setRequestHeader("Content-type","text/xml");
  			objXmlHttp.Send("");
  			if(objXmlHttp.status==200)
  			{
    			return objXmlHttp.responseText;
  			}
  			else if(objXmlHttp.status==404)
  			{
    			alert("找不到页面："+ strURL);
    			return "";
  			}
  			else
  			{
    			alert("访问"+ strURL +"出错，错误号："+objXmlHttp.status);
    			return "";
  			}
		}
		
		function submitForm()
		{
			if(checkForm()==true)
			{
			
		    	var strUrl = "";
		    	if((fm.printType.value=="FreightRefuseCancel")||
		    		(fm.printType.value=="ClaimRefuse")||
			    	(fm.printType.value=="ClaimDispose")||
			    	(fm.printType.value=="ClaimDocumentHandinCredence")||
			    	(fm.printType.value=="Cancel")||
			    	(fm.printType.value=="ShipEndcase")){
		    		strUrl = "/claim/ClaimPrint.do?printType="+fm.printType.value+"&ClaimNo=" + fm.BizNo.value;
		    	}else if ((fm.printType.value=="AcciNotClaim")||
							    	(fm.printType.value=="FreightHeresyCheck")||
							    	(fm.printType.value=="PropLocalCheck")||
							    	(fm.printType.value=="FreightClaimApply")||
							    	(fm.printType.value=="CheckReport")||
							    	(fm.printType.value=="CetainLossList")){
			    	strUrl = "/claim/ClaimPrint.do?printType="+fm.printType.value+"&RegistNo=" + fm.BizNo.value;
			    }else if(fm.printType.value=="AcciCheck"){
			    	  strUrl = "/claim/checkQuery.do?editType=PRINT&RegistNo=" + fm.BizNo.value;
			    }else{
			    	strUrl = "/claim/ClaimPrint.do?printType="+fm.printType.value+"&CompensateNo=" + fm.BizNo.value;
			    }
			printWindow(strUrl,"打印");
			
			}
		}
		 //显示打印窗口
		function printWindow(strURL,strWindowName)
		{
			var pageWidth=screen.availWidth-10;
			var pageHeight=screen.availHeight-30;
			
			if (pageWidth<100 )
			  pageWidth = 100;
			
			if (pageHeight<100 )
			  pageHeight = 100;
			
			var newWindow = window.open(strURL,strWindowName,'width='+pageWidth+',height='+pageHeight+',top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1.resizable=1,status=0');
			newWindow.focus();
			return newWindow;
		}

	</script>
	<script src="/claim/DAA/print/js/DAAPrintBeforeEdit.js"></script>
	<jsp:include page="/common/pub/StaticJavascript.jsp" />
	</head>
	<body  onload="loadForm();">
	<form name="fm" method="post"  onsubmit="return validateForm(this);">
	    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
		    <tr>  
				<td colspan=2 class="formtitle" id="TitleName"><%=strTitleName%></td>
		    </tr>
			<tr>
				<td class='title2'  id="BizName"><%=strBizName%></td>
				<td class='input2'>
					<input type='hidden' name='BizName'>
					<input class="common" type='text' name='BizNo' maxlength='25' >
				</td>
			</tr>
		
			<tr>
				<td class="button" align="center"   colspan="2">
					<input type=button value="打印" class='button' onclick="submitForm();">
				</td>
			</tr>
			<input type='hidden' name="printType" value="<%=strPrintType %>">
	    </table>
	</form>
	</body>
</html:html>