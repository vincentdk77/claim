<%-- 引入bean类部分 --%>
<%@page import="com.sinosoft.claim.resource.dtofactory.domain.*"%>
<%@page import="com.sinosoft.sysframework.reference.AppConfig"%>
<%@page import="com.sinosoft.sysframework.reference.DBManager"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/xml;charset=GBK"%>

<%
	String policyno = request.getParameter("policyno");
	String kindcode = request.getParameter("kindcode");
	String strWhere = "policyno = '" + policyno +"' and kindcode ='" + kindcode+"'";
	
	DBManager dbManager = new DBManager();
	String strReturn = "true";
	try{
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        DBPrpCitemKindBase dbPrpCitemKindBase = new DBPrpCitemKindBase(dbManager);
        ArrayList<PrpCitemKindDto> temp = (ArrayList<PrpCitemKindDto>)dbPrpCitemKindBase.findByConditions(strWhere);
        if(temp.size()>0) {
        	double returnAmount = 0.0;
        	for(int i=0; i<temp.size(); i++) {
        		double amount = temp.get(i).getAmount();
        		returnAmount = returnAmount + amount;
        	}
            java.text.DecimalFormat df = new java.text.DecimalFormat("########.00");
    	    //if(returnAmount!=0) {
    		    strReturn = df.format(returnAmount);
    	    //}
        }
    }catch(Exception exception){
        throw exception;
    }finally{
        dbManager.close();
    }
	out.print(strReturn);
%>