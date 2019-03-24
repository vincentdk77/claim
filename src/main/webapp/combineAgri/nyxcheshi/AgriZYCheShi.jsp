<%@ page import="com.sinosoft.claimzy.bl.action.*;"%>
<%
  String serviceType = request.getParameter("serviceType");//接口类型
  String startTime = request.getParameter("startTime");// + " 00:00:00"开始时间 
  String endTime = request.getParameter("endTime");// + " 23:59:59"截止时间
  String returnMsg = ""; 
  String dataType = request.getParameter("dataType");//数据类型
  String requestType = request.getParameter("requestType");//请求类型
  int uSize = Integer.parseInt(request.getParameter("uSize"));//上传条数
  try{
   if("claim".equals(serviceType)){//立案接口startTime,endTime,dataType,count Integer.parseInt
	    
	   returnMsg = BLAGRIZYClaimUploadAction.getInstance().autoClaimUpload(startTime,endTime,dataType,uSize,requestType);
   }else if("case".equals(serviceType)){//赔案接口
	   returnMsg = BLAGRIZYCaseUploadAction.getInstance().autoCaseUpload(startTime,endTime,dataType,uSize,requestType);
   }else if("cancel".equals(serviceType)){//注销/拒赔（立案）接口
	   returnMsg = BLAGRIZYCancelUploadAction.getInstance().autoCancelUpload(startTime,endTime,dataType,uSize,requestType);
   }else if("prepaid".equals(serviceType)){//预赔案接口
	   returnMsg = BLAGRIZYPrepaidUploadAction.getInstance().autoPrepaidUpload(startTime,endTime,dataType,uSize,requestType);
   }
  }catch(Exception e){
	  e.printStackTrace();
  }
  
  
%>

<html>
<head>
<style type="text/css">
</style>
	<title>农险平台数据上传</title>
	<link rel="stylesheet" type="text/css" href="/payment/css/Standard.css">
</head>
<body>
<form action="AgriZYCS.jsp" method="post"name="fm">
	<table class="common" align="center" width="100%" border="0" cellspacing="1" cellpadding="1">
		<tr class="common" height="100px">
		<td><%=returnMsg %></td>
		</tr>
		<tr class="common">
			<td>
				<input type="button" class="button" name="backBn" value="返 回" alt="返 回" onclick="fm.submit();"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>
