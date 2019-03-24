<%--
****************************************************************************
* DESC       ：赔付标的信息页面
* AUTHOR     ：liubvo
* CREATEDATE ： 2004-10-18
* MODIFYLIST ：   Name       Date            Reason/Contents
*               qinyongli    2005-9-1        增加新增险别标的的判断
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCitemKind"%>
<%@page import="com.sinosoft.prpall.schema.PrpCitemKindSchema"%>
<%@page import="org.dom4j.Document"%>
<%@page import="org.dom4j.DocumentHelper"%>
<%@page import="org.dom4j.Element"%>


<%@page contentType="text/xml;charset=GBK"%>
<%
	String policyNo = request.getParameter("policyNo");
	String kindCode = request.getParameter("kindCode");
	BLPrpCitemKind blPrpCitemKind = new BLPrpCitemKind();
	String sqlCondition = " policyNo = '"+policyNo+"' and kindCode = '"+kindCode+"'";
	blPrpCitemKind.query(sqlCondition);
	//Document dom = DocumentHelper.createDocument();
	//dom.setXMLEncoding("GBK");
	String outString = "";
	//Element root = dom.addElement("prpCitemKind");
	if(null!= blPrpCitemKind && blPrpCitemKind.getSize()==1){
 	   PrpCitemKindSchema prpCitemKindSchema = blPrpCitemKind.getArr(0);
 	   String unitAmount = prpCitemKindSchema.getUnitAmount();
 	   String amount = prpCitemKindSchema.getAmount();
 	   unitAmount.trim();
 	   amount.trim();
 	   if(null == unitAmount || "".equals(unitAmount))
 	     unitAmount = "0";
 	   if(null == amount || "".equals(amount))
 	     amount = "0";
 	   //Element eleUnitAmount = root.addElement("UnitAmount");
 	   //eleUnitAmount.addText(unitAmount);
 	   //Element eleAmount = root.addElement("Amount");
 	   //eleAmount.addText(amount);
 	   outString = unitAmount+"/"+amount;
	 }
	 
	 //response.getWriter().write(dom.asXML());
	 out.clearBuffer();
	 out.print(outString);
	 //out.print(dom.asXML());
	 
	 
%>




