<%--
****************************************************************************
* DESC       �������������õǼ�¼��/�޸�ҳ�� 
* AUTHOR     ��lixiang
* CREATEDATE ��2005-08-30
* MODIFYLIST ��   Name       Date            Reason/Contents

****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>


<html:html locale="true">
<head>
  <!--��title����-->  
  <title>���Ȼ�����Ϣ����</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
</head> 

  <script language="javascript">
  
  function saveForm(){
  if(!validateForm(fm))
  {
    return false;
  }
  
  //�жϻ����������Ϊ8λ
  
  var comcode=fm.prpDcompanyComCode.value;
  
  if (trim(comcode).toString().length!=8){
     alert("����ĵ��Ȼ����Ĵ������Ϊ8λ")
     return false;
  }
  
  fm.submit();
  
  }
  
  </script>
<%  
  //modify by lixiang start 2005-7-23
  //reason:������ʱ���showģʽ
  String editType=request.getParameter("editType");
  String displayModeReadOnly=""; //չ��ģʽ
 
 if (editType.equals("SHOW")){
    displayModeReadOnly="readonlyAllInput();";
  }
%>

<body class="interface" onload="initPage();<%=displayModeReadOnly%>"> 


    <form name=fm action="/claim/scheduleObjectEdit.do" method="post" onsubmit="return validateForm(this);">
      <%-- 1.��������Ϣ --%>
      <%@include file="/common/scheduleObject/ScheduleObjectMainEdit.jsp" %>
       <%-- ����ͨ�ð�ť --%>
      <%@include file="/common/scheduleObject/ScheduleObjectSave.jsp"%>
      <logic:notEqual name='scheduleObjectDto' property='alertMessage' value="">
      <input type='text' class=readonly readonly style="color:red" value="<bean:write name='scheduleObjectDto' property='alertMessage' />">
      </logic:notEqual>
      </form>   

</body>
<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>
