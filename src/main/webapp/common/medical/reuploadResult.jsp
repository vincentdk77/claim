<%--
****************************************************************************
* DESC       ����������������
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
  <title><bean:message key="title.claimBeforeEdit.titleName" /></title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script language="javascript">
  <!--
  <%--����״̬��־����--%>
  function submitForm()
  {
	//��Ҫ����У���߼���
	/**
	������
	�м������
	�����������
	����ͬʱΪ��
	**/
	/**
	�����ڵ㲻��Ϊ��
	**/
  	if(fm.nodeType.value=="payDelete"&&(fm.outId.value==null || fm.outId.value=="")){
		alert("��������Ϊ����֧��ɾ��ʱ�����������������Ϊ�գ�");
		return false;
	}
    fm.submit();//�ύ
  }
  //-->
</script>
<script language="javascript">
  	var nodeCount = 17;
  	var array = new Array();
  	array[0] = new Array("claim","regis","����");
	array[1] = new Array("claim","sched","����");
	array[2] = new Array("claim","check","�鿱");
	array[3] = new Array("claim","claim","����");
	array[4] = new Array("claim","certi","��֤");
	array[5] = new Array("claim","compp","����");
	array[6] = new Array("claim","veric","����");
	array[7] = new Array("claim","endca","�᰸");
	array[8] = new Array("cancel","cancelApply","����");
	array[9] = new Array("cancel","cancelAudit","ע��");
	array[10] = new Array("recase","recaseApply","�ؿ��ⰸ����");
	array[11] = new Array("recase","recaseAudit","�ؿ��ⰸ����");
	array[12] = new Array("recase","recaseCompp","�ؿ��ⰸ����");
	array[13] = new Array("recase","recaseVeric","�ؿ��ⰸ����");
	array[14] = new Array("recase","recaseEndca","�ؿ��ⰸ�᰸");
	array[15] = new Array("pay","payApply","����֧������");
	array[16] = new Array("pay","payAudit","����֧������");
	array[17] = new Array("payDelete","payDelete","����֧��ɾ��");
	
  	function buildNodeSelect(nodeType, reuploadNode){
    	var nodeTypeValue = nodeType.value;
    	reuploadNode.length = 0;
    	reuploadNode.options[0] = new Option("", "");
    	for(var i=0; i<nodeCount; i++){
        	if(array[i][0] == nodeTypeValue){
            	reuploadNode.options[reuploadNode.length] = new Option(array[i][2], array[i][1]);
        	}
    	}
    	reuploadNode.remove(0);
 	}
  </script>
</head>

<body onload="buildNodeSelect(fm.nodeType, fm.reuploadNode);">
<form name="fm" action="/claim/medicalReupload.do"  method="post">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    
      <tr>
    	<td colspan=4 class="formtitle">������ӿڲ���</td>
      </tr>
    
      <tr>
        <td class='title' >�����ţ�</td>
        <td class='input' >
        	<input type=text name="registNo" class="query" value="<bean:write name="registNo"/>">
        </td>
        <td class='title' >�м��������</td>
        <td class='input' >
        	<input type=text name="interId" class="query" value="<bean:write name="interId"/>">
        </td>
      </tr>
      
       <tr>
        <td class="title" rowspan="2">�������������</td>
        <td class="input" rowspan="2">
        	<input type=text name="outId" class="query" value="<bean:write name="outId"/>">
        </td>
        <td class="title" >�����ڵ����ͣ�</td>
        <td colspan="3" class="input" >
        <select name="nodeType" style="width:60%" value="<bean:write name="nodeType"/>" onchange="buildNodeSelect(fm.nodeType, fm.reuploadNode);">
        	
        	<option value ="claim" <%if(request.getAttribute("nodeType").equals("claim")){ %>selected<%} %>>�Զ�����</option>
        	<option value ="cancel" <%if(request.getAttribute("nodeType").equals("cancel")){ %>selected<%} %>>����ע��</option>
        	<option value ="recase" <%if(request.getAttribute("nodeType").equals("recase")){ %>selected<%} %>>�ؿ��ⰸ</option>
        	<option value ="pay" <%if(request.getAttribute("nodeType").equals("pay")){ %>selected<%} %>>����֧��</option>
        	<option value ="payDelete" <%if(request.getAttribute("nodeType").equals("payDelete")){ %>selected<%} %>>����֧��ɾ��</option>
        </select>
        </td>
      </tr>
      
       <tr>
        <td class="title" >�����ڵ㣺</td>
        <td colspan="3" class="input" >
        <select name="reuploadNode" style="width:60%">
        </select>
        </td>
      </tr>
      
      <tr>
       <td class='button'  colspan="4">
          <input type=button class='button' value="<bean:message key='button.submit.value' />" onClick="submitForm();">
        </td>
        </tr>
    </table>
    
    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
      <tr>
      	<td class="common" colspan=4 align="center" >
           	<bean:write name="returnMessage"/>
      	</td>
      </tr>
    </table>
  
  </form>
</body>
</html:html>