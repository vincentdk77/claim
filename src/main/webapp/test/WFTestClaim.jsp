<%--
****************************************************************************
* DESC       ���������Թ������ͻ���
* AUTHOR     ��
* CREATEDATE ��2004-06-29
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>  
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.function.workflow.ejb.client.SharkFactory"%>
<%@page import="com.sinosoft.function.workflow.ejb.shark.SharkClientInterface"%>
<%@ page import="java.util.*"%>
<%
     /*
      SharkClient relaxBTFClient ;
      relaxBTFClient = new SharkClient("admin","enhydra");
      //���ӹ�����
      relaxBTFClient.connect() ;
      //���빤��������
      relaxBTFClient.defaultConfig();
      */

     SharkClientInterface shark = SharkFactory.getShark();
     Map formalPars = new LinkedHashMap();
     String claimno = "A11111111111111111";

     formalPars.put("claimno",claimno);

     shark.acceptActivity("101_1_claim_claim_Wor1");
     shark.updateActivity("101_1_claim_claim_Wor1",formalPars);
     shark.completeActivity("101_1_claim_claim_Wor1");
     
      Collection worklist = shark.getWorklist();
     System.out.println("There is " + worklist.size() + " work items to be done!");
     Iterator it = worklist.iterator();
     Map result;
     while(it.hasNext())
     {
         result = (Map)it.next();
         System.out.println("----------" + result.get("activityname") + "---details:begin-----------");
         System.out.println("riskcode:" + result.get("riskcode"));
         System.out.println("premium:" + result.get("premium"));
         System.out.println("claimno:" + result.get("claimno"));
         System.out.println("-------------details:end-----------");
        }
        
     
 /*

     //1.����һ������
     SharkClientInterface shark = SharkFactory.getShark();
     System.out.println("��ʼ���ɹ�");
     Map formalPars = new LinkedHashMap();
     String riskcode = "DAB";
     Double premium = new Double(7000);
     //String policyNo="PDAA200431010006000017";
     //String claimNo ="ADAA200451010005000013";
     formalPars.put("riskcode",riskcode);
     formalPars.put("premium",premium);
     //formalPars.put("policyNo",policyNo);
     //formalPars.put("claimNo",claimNo);

     shark.createProcess("claim","claim_Wor1",formalPars);

     //2.�ڵ㴦��
     SharkClientInterface shark = SharkFactory.getShark();
     Map formalPars = new LinkedHashMap();
     String riskcode = "DAA";
     Double premium = new Double(7000);
     formalPars.put("riskcode",riskcode);
     formalPars.put("premium",premium);

     shark.acceptActivity("1_1_claim_claim_Wor1");

      //3.�ڵ��޸�
     SharkClientInterface shark = SharkFactory.getShark();
     Map formalPars = new LinkedHashMap();
     String riskcode = "DAB";

     formalPars.put("proposal_status",riskcode);

     shark.acceptActivity("1_1_claim_claim_Wor1");
     shark.updateActivity("1_1_claim_claim_Wor1",formalPars);
     shark.completeActivity("1_1_claim_claim_Wor1");
 //}//��ʾ��ǰ���������
     Collection worklist = shark.getWorklist();
     System.out.println("There is " + worklist.size() + " work items to be done!");
     Iterator it = worklist.iterator();
     Map result;
     while(it.hasNext())
     {
         result = (Map)it.next();
         System.out.println("----------" + result.get("activityname") + "---details:begin-----------");
         System.out.println("riskcode:" + result.get("riskcode"));
         System.out.println("premium:" + result.get("premium"));
         System.out.println("proposal_status:" + result.get("proposal_status"));
         System.out.println("-------------details:end-----------");
        }

 */
  

%>
<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      �������Թ������ͻ���
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/regist/js/DAARegistEdit.js"></script>
</head> 
        
<body class="interface" onload="initPage();initSet();">  
    <form name=fm action="" method="post" onsubmit="">
         �������Թ������ͻ��� 
    </form>
</body>

</html:html>
  