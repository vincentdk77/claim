<%@ page language="java" pageEncoding="GBK"%>
<%@ page import="com.sinosoft.claim.dto.custom.UserDto" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>My JSF 'ClaimInterFace.jsp' starting page</title>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
  
<body>
	<%
	UserDto userDto = new UserDto();
	userDto.setUserCode("0000000000");
	userDto.setUserName("系统管理员");
	request.getSession().setAttribute("user" ,userDto);

	System.out.println("进入理赔系统，开始传递参数");
	String sysName = request.getParameter("sysName");
	String interFaceUrl = request.getParameter("interFaceUrl");
	String otherParameter = request.getParameter("otherParameter");
	String interFaceType = request.getParameter("interFaceType");
	
	String myComCode = request.getParameter("myComCode");
	String myUserCode = request.getParameter("myUserCode");
	String myUserName = request.getParameter("myUserName");
	
	String redirectString = "";
	
	if("10".equals(interFaceType)){//请求理算路径
		String businessNo =  request.getParameter("businessNo");
		String riskCode =  request.getParameter("riskCode");
		redirectString ="/claimBeforeCancel.do?"+
						"businessNo="+businessNo+"&editType=UNCANCEL&riskCode="+riskCode+"";
	}else if("11".equals(interFaceType)){//请求重开赔案路径
		String claimNo =  request.getParameter("claimNo");
		redirectString ="/reCaseBefore.do?reCaseClaimNo="+claimNo+"&editType=UWTSHOW";
					
	}else if("8".equals(interFaceType)){//请求支付信息路径
		String busino =  request.getParameter("businessNo");
		String undwrtEditType=request.getParameter("undwrtEditType");
		//redirectString ="/prplpayadd.do?editType=SHOW&busino="+busino+"&node=comp&from=undwrt&payflag=0";
		if(null!=busino && !"".equals(busino) && busino.startsWith("F")){
			redirectString="/fiscalpaymainEditFromUndwrt.do?editType=SHOW&paymentNo="+busino+"&nodeType=vpay&from=undwrt&payflag=0&undwrtEditType="+undwrtEditType;
		}else if(null!=busino && !"".equals(busino) && busino.startsWith("H")){
			redirectString="/compensateList.do?editType=SHOW&billNo="+busino;
		}else{
			redirectString="/paymainEditFromUndwrt.do?editType=SHOW&paymentNo="+busino+"&nodeType=vpay&from=undwrt&payflag=0&undwrtEditType="+undwrtEditType;			
		}
	}
	
	System.out.println("redirectString = "+redirectString);
	response.setHeader("P3P","CP=CAO PSA OUR IDC DSP COR ADM DEVi TAIi PSD IVAi IVDi CONi HIS IND CNT"); 
	request.getRequestDispatcher(redirectString).forward(request,response);
	%>
</body>
</html>