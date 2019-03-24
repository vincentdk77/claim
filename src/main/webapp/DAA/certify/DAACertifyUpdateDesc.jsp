<%@ page contentType="text/html; charset=GBK" %>
<%@page import="com.sinosoft.claim.bl.facade.BLCertifyImgFacade"%>

<%
	String businessNo  = request.getParameter("businessNo");
	String nowSerialNo = request.getParameter("nowSerialNo");
	String newDesc     = request.getParameter("newDesc");
	
	BLCertifyImgFacade facade = new BLCertifyImgFacade();
	String condition = "displayName = '"+ newDesc + 
					   "' where businessNo = '" +businessNo +
					   "' and serialNo =" + nowSerialNo +"";
	response.reset();
	try{
		facade.updateByCondition(condition);
		response.getWriter().write("1");
	}catch(Exception e){
		e.printStackTrace();
		response.getWriter().write("-1");
	}
	response.getWriter().flush();
	response.getWriter().close();
%>