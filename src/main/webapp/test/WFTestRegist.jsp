<%--
****************************************************************************
* DESC       ：报案测试工作流客户端
* AUTHOR     ：
* CREATEDATE ：2004-06-29
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>  
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.function.workflow.ejb.client.SharkFactory"%>
<%@page import="com.sinosoft.function.workflow.ejb.shark.SharkClientInterface"%>
<%@ page import="java.util.*"%>

<html:html locale="true">
<head>
    <!--对title处理-->
    <title>
      报案测试工作流客户端
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/regist/js/DAARegistEdit.js"></script>
</head> 
 

<body class="interface" >
  <form name="fm">
    <table class="common" align=center>
      <tr class=listtitle>
        <td>内容</td>
        <td>结果</td>
    
      </tr>
<%

    
     String strDealType ="";
     String strResult ="";
     
     strDealType=request.getParameter("DealType").trim();
     SharkClientInterface shark = SharkFactory.getShark();
     Map formalPars = new HashMap();
     
     String riskcode = "DAB";
     String policyNo="PDAA200431010006000017";
     String registNo ="RDAA200451010005000013";
     
     System.out.println(strDealType);
     
     if (strDealType.equals("registWFMake"))
     {
     
     formalPars.put("RiskCode",riskcode);
     formalPars.put("PolicyNo",policyNo);
     formalPars.put("RegistNo",registNo);
     formalPars.put("RegistStatus","1");
     formalPars.put("RegistOperatorCode","0000000000");
     formalPars.put("RegistInDate","2004/07/05");
     
   
     
    
     strResult =shark.createProcess("claimWF","ClaimWF_Work",formalPars);
     
     %>
     <tr>
     <td>创建工作流程
     </td>
     <td> <%=strResult%>
     </td>
     </tr>
     <%
     }
     
     if (strDealType.equals("registWFDeal")||strDealType.equals("registWFQuery"))
     {
     if (strDealType.equals("registWFDeal"))
     {
     registNo ="RDAA1111111111111111";
     String registOutDate ="2004/07/06";
     //formalPars.put("RegistOutDate",registOutDate);
     formalPars.put("RegistNo",registNo);
     
     
     shark.acceptActivity("1_1_claimWF_ClaimWF_Work");
     
     System.out.println("已经接受");
     shark.updateActivity("1_1_claimWF_ClaimWF_Work",formalPars);
     System.out.println("已经变更");
    shark.completeActivity("1_1_claimWF_ClaimWF_Work");
     System.out.println("已经完成");
     }
     Collection worklist = shark.getWorklist();
     System.out.println("There is " + worklist.size() + " work items to be done!");
     Iterator it = worklist.iterator();
     Map result;
     while(it.hasNext())
     {
         result = (Map)it.next();
         System.out.println("----------" + result.get("activityname") + "---details:begin-----------");
         System.out.println("RiskCode:" + result.get("RiskCode"));
         System.out.println("PolicyNo:" + result.get("PolicyNo"));
         System.out.println("RegistNo:" + result.get("RegistNo"));
         System.out.println("-------------details:end-----------");
         %> 
         <tr>  
         <td>
         <%=result.get("activityname")%>
         </td>
         <td>
         RiskCode:<%=result.get("RiskCode")%>  PolicyNo:<%=result.get("PolicyNo")%> RegistNo:<%=result.get("RegistNo")%>
         </td>
         </tr>
	     	<%	
        }
    } 
    
    if (strDealType.equals("registWFQueryProccessKey"))
    {
            //Collection processes = shark.queryProcesses("claimWF","ClaimWF_Work","context_RiskCode.equals(\"DAB\")");
			
			Collection processes = shark.queryProcesses("claimWF","ClaimWF_Work","context_RegistNo.equals(\"RDAA200451010005000013\")");
			//Collection processes = shark.queryProcesses("claimWF","ClaimWF_Work","state.equals(\"open.running\")");
			
			Iterator it = processes.iterator();
			String processkey;
			int intRow=1;
			
			while(it.hasNext())
			{
				processkey = (String)it.next();
				System.out.println("processkey:" + processkey);
				
				%>
				<tr>  
         <td>
         <%=intRow%>
         </td>
         <td>
         <%=processkey%>
         </td>
         </tr>
         <%
				intRow++;
			}
           
    }
    
    if (strDealType.equals("registWFQueryActivitiesKey"))
     {
            //Shark shark = null;
    	try
    	{
			//shark = new Shark();
    		int intRowa=1;
    		Collection activities = shark.queryActivities("4_claimWF_ClaimWF_Work","open.not_running.not_started");
			System.out.println("There is " + activities.size() + " work items to be done!");
			Iterator it = activities.iterator();
			String activitykey;
			while(it.hasNext())
			{
				activitykey = (String)it.next();
				System.out.println("activitykey:" + activitykey);
				%>
				<tr>  
         <td>
         <%=intRowa%>
         </td>
         <td>
         <%=activitykey%>
         </td>
         </tr>
         <%
         intRowa++;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();	
		}
		
          
		
    }

%>

        
</table>

</form>
 
</body>

</html:html>
  