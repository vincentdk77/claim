<%--
****************************************************************************
* DESC       ：补传输入结果界面
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
  <%--案件状态标志处理--%>
  function submitForm()
  {
	//需要增加校验逻辑：
	/**
	报案号
	中间表主键
	三方机构外键
	不能同时为空
	**/
	/**
	补传节点不能为空
	**/
  	if(fm.nodeType.value=="payDelete"&&(fm.outId.value==null || fm.outId.value=="")){
		alert("补传类型为三方支付删除时，三方机构外键不能为空！");
		return false;
	}
    fm.submit();//提交
  }
  //-->
</script>
<script language="javascript">
  	var nodeCount = 17;
  	var array = new Array();
  	array[0] = new Array("claim","regis","报案");
	array[1] = new Array("claim","sched","调度");
	array[2] = new Array("claim","check","查勘");
	array[3] = new Array("claim","claim","立案");
	array[4] = new Array("claim","certi","单证");
	array[5] = new Array("claim","compp","理算");
	array[6] = new Array("claim","veric","核赔");
	array[7] = new Array("claim","endca","结案");
	array[8] = new Array("cancel","cancelApply","报案");
	array[9] = new Array("cancel","cancelAudit","注销");
	array[10] = new Array("recase","recaseApply","重开赔案申请");
	array[11] = new Array("recase","recaseAudit","重开赔案审批");
	array[12] = new Array("recase","recaseCompp","重开赔案理算");
	array[13] = new Array("recase","recaseVeric","重开赔案核赔");
	array[14] = new Array("recase","recaseEndca","重开赔案结案");
	array[15] = new Array("pay","payApply","三方支付申请");
	array[16] = new Array("pay","payAudit","三方支付审批");
	array[17] = new Array("payDelete","payDelete","三方支付删除");
	
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
    	<td colspan=4 class="formtitle">大病理赔接口补传</td>
      </tr>
    
      <tr>
        <td class='title' >报案号：</td>
        <td class='input' >
        	<input type=text name="registNo" class="query" value="<bean:write name="registNo"/>">
        </td>
        <td class='title' >中间表主键：</td>
        <td class='input' >
        	<input type=text name="interId" class="query" value="<bean:write name="interId"/>">
        </td>
      </tr>
      
       <tr>
        <td class="title" rowspan="2">三方机构外键：</td>
        <td class="input" rowspan="2">
        	<input type=text name="outId" class="query" value="<bean:write name="outId"/>">
        </td>
        <td class="title" >补传节点类型：</td>
        <td colspan="3" class="input" >
        <select name="nodeType" style="width:60%" value="<bean:write name="nodeType"/>" onchange="buildNodeSelect(fm.nodeType, fm.reuploadNode);">
        	
        	<option value ="claim" <%if(request.getAttribute("nodeType").equals("claim")){ %>selected<%} %>>自动理赔</option>
        	<option value ="cancel" <%if(request.getAttribute("nodeType").equals("cancel")){ %>selected<%} %>>报案注销</option>
        	<option value ="recase" <%if(request.getAttribute("nodeType").equals("recase")){ %>selected<%} %>>重开赔案</option>
        	<option value ="pay" <%if(request.getAttribute("nodeType").equals("pay")){ %>selected<%} %>>三方支付</option>
        	<option value ="payDelete" <%if(request.getAttribute("nodeType").equals("payDelete")){ %>selected<%} %>>三方支付删除</option>
        </select>
        </td>
      </tr>
      
       <tr>
        <td class="title" >补传节点：</td>
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