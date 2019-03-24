<%--
****************************************************************************
* DESC       ：selectCode 选择切换
* AUTHOR     ：weishixin
* CREATEDATE ：2004-08-04
* MODIFYLIST ：   Name       Date            Reason/Contents
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

   String conditions = "";   //查询条件
   PrpDuserDto prpDuserDto = new PrpDuserDto();  //UserDto
   String selectContent  = "" ;                  //select中的内容
   UIPowerAction uiPowerAction = new UIPowerAction();
   String powerConditions = uiPowerAction.addPower(powerUserCode,powerRiskCode,taskCode,powerTableName);

   System.out.println("powerConditions="+ powerConditions);
   conditions =  "SELECT prpduser.usercode,prpduser.username FROM prpduser ,prpusergrade " +
                 "WHERE prpduser.usercode=prpusergrade.usercode AND prpusergrade.checkcode='r' AND prpusergrade.taskcode='" + taskCode + "'" + powerConditions;


   powerList = (ArrayList)uiPowerAction.findByTask(conditions);

   selectContent = selectContent + "0" + "_FIELD_SEPARATOR_" + "...请选择人员" + "_GROUP_SEPARATOR_";
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
    <!--对title处理-->
    <title>
      选择切换
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/test/SelectCode.js"> </script>
 </head>
<body class="interface" >
    <form name=fm action="" method="post" >

    </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
<script language="javascript">
  //将生成的人员代码与名称写到select中
  setFrameOption("personList","<%=selectContent%>");
</script>
</html:html>