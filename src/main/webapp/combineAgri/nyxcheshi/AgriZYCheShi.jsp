<%@ page import="com.sinosoft.claimzy.bl.action.*;"%>
<%
  String serviceType = request.getParameter("serviceType");//�ӿ�����
  String startTime = request.getParameter("startTime");// + " 00:00:00"��ʼʱ�� 
  String endTime = request.getParameter("endTime");// + " 23:59:59"��ֹʱ��
  String returnMsg = ""; 
  String dataType = request.getParameter("dataType");//��������
  String requestType = request.getParameter("requestType");//��������
  int uSize = Integer.parseInt(request.getParameter("uSize"));//�ϴ�����
  try{
   if("claim".equals(serviceType)){//�����ӿ�startTime,endTime,dataType,count Integer.parseInt
	    
	   returnMsg = BLAGRIZYClaimUploadAction.getInstance().autoClaimUpload(startTime,endTime,dataType,uSize,requestType);
   }else if("case".equals(serviceType)){//�ⰸ�ӿ�
	   returnMsg = BLAGRIZYCaseUploadAction.getInstance().autoCaseUpload(startTime,endTime,dataType,uSize,requestType);
   }else if("cancel".equals(serviceType)){//ע��/���⣨�������ӿ�
	   returnMsg = BLAGRIZYCancelUploadAction.getInstance().autoCancelUpload(startTime,endTime,dataType,uSize,requestType);
   }else if("prepaid".equals(serviceType)){//Ԥ�ⰸ�ӿ�
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
	<title>ũ��ƽ̨�����ϴ�</title>
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
				<input type="button" class="button" name="backBn" value="�� ��" alt="�� ��" onclick="fm.submit();"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>
