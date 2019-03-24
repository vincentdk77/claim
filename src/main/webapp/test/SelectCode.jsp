<%--
****************************************************************************
* DESC       ��selectCode ѡ���л�
* AUTHOR     ��weishixin
* CREATEDATE ��2004-08-04
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.sysframework.reference.*" %>
<%@page import="java.util.*" %>
<%@page import="com.sinosoft.function.power.ui.action.UIPowerAction" %>
<%@page import="com.sinosoft.function.power.dto.domain.PrpDuserDto" %>
<%
   String nodeType = request.getParameter("nodeType");
   ArrayList powerList = new ArrayList();
   String nodeTaskCode  = "sysconst." + nodeType;
   String taskCode      = AppConfig.get(nodeTaskCode);

   String powerUserCode      = "4201010201" ;
   String powerRiskCode      = "DAA" ;
   String powerTableName     = "prpduser";

   String conditions = "";   //��ѯ����
   PrpDuserDto prpDuserDto = new PrpDuserDto();  //UserDto
   String selectContent  = "" ;                  //select�е�����
   UIPowerAction uiPowerAction = new UIPowerAction();
   String powerConditions = uiPowerAction.addPower(powerUserCode,powerRiskCode,taskCode,powerTableName);

   System.out.println("powerConditions="+ powerConditions);
   conditions =  "SELECT prpduser.usercode,prpduser.username FROM prpduser ,prpusergrade " +
                 "WHERE prpduser.usercode=prpusergrade.usercode AND prpusergrade.checkcode='r' AND prpusergrade.taskcode='" + taskCode + "'" + powerConditions;


   powerList = (ArrayList)uiPowerAction.findByTask(conditions);

   selectContent = selectContent + "0" + "_FIELD_SEPARATOR_" + "...��ѡ����Ա" + "_GROUP_SEPARATOR_";
   for(int i=0;i<powerList.size();i++)
   {

     prpDuserDto = (PrpDuserDto)powerList.get(i);
     if(i==powerList.size()-1)
     {
	     selectContent = selectContent + prpDuserDto.getUserCode() ;
	     selectContent = selectContent + "_FIELD_SEPARATOR_";
	     selectContent = selectContent + prpDuserDto.getUserCode();
	     selectContent = selectContent + "-";
	     selectContent = selectContent + prpDuserDto.getUserName();
     }
     else
     {
	     selectContent = selectContent + prpDuserDto.getUserCode() ;
	     selectContent = selectContent + "_FIELD_SEPARATOR_";
	     selectContent = selectContent + prpDuserDto.getUserCode();
	     selectContent = selectContent + "-";
	     selectContent = selectContent + prpDuserDto.getUserName();
	     selectContent = selectContent + "_GROUP_SEPARATOR_";
     }
   }


%>
<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      ѡ���л�
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/test/SelectCode.js"> </script>
 </head>
<body class="interface" >
    <form name=fm action="" method="post" >

    </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
<script language="javascript">
  //�����ɵ���Ա����������д��select��
  setFrameOption("personList","<%=selectContent%>");
</script>
</html:html>