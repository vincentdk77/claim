<%@page contentType="text/xml;charset=GBK"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpLpreChargeDto" %>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpLpreChargeFacade" %>

<%
	String kindCode = request.getParameter("kindCode");
	String chargeCode = request.getParameter("chargeCode");
	String preClaimNo = request.getParameter("preClaimNo");
	int count = Integer.parseInt(request.getParameter("strRecaseFlag"));
	double sumPreChargeAmount = 0.0;
	if(count < 1){
		String strReturn = "";
		String conditions = " claimNo ='"+preClaimNo+"' and kindcode ='"+kindCode+"' "+" and chargeCode ='"+chargeCode+"' ";
		BLPrpLpreChargeFacade blPrpLpreChargeFacade = new BLPrpLpreChargeFacade();
		ArrayList prpLpreChargeDtoList = (ArrayList)blPrpLpreChargeFacade.findByConditions(conditions);
		for(int i=0;i<prpLpreChargeDtoList.size();i++){
			PrpLpreChargeDto prpLpreChargeDto = (PrpLpreChargeDto)prpLpreChargeDtoList.get(i);
			sumPreChargeAmount += prpLpreChargeDto.getSumPrepaid();
		}
	}
	out.print("<?xml version=\"1.0\" encoding=\"GBK\"?>"); //×Ö·û±àÂëGBK
	out.print("<root>");
	out.print("<sumPreChargeAmount>"+sumPreChargeAmount+"</sumPreChargeAmount>");
	out.print("</root>");
%>