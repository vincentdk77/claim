
<%--
****************************************************************************
* DESC       ��У���Ƿ��Ѿ�����
* AUTHOR     ����Ԫ��Ŀ��
* CREATEDATE ��
* MODIFYLIST ��  Name      Date      Reason/Contents
*          --------------------------------------------------

****************************************************************************
--%>

<%@page import="com.sinosoft.claim.bl.facade.BLSwfLogStoreFacadeBase"%>

<%
	String result = "false";
	try{
		String strBusinessNo = request.getParameter("BusinessNo");
		BLSwfLogStoreFacadeBase blSwfLogStoreFacadeBase = new BLSwfLogStoreFacadeBase();
		String condition = "businessno = '" + strBusinessNo + "' and nodetype = 'cance'";
		int answer = blSwfLogStoreFacadeBase.getCount(condition);
		if(answer > 0) {
			result = "true";
		}
	} catch(Exception e) {
	    throw e;
	}
	out.print(result);
%>

