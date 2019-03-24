<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade"%>
<%@page import="com.sinosoft.claim.ui.control.action.UICodeAction"%>
<%@page import="com.sinosoft.platform.ui.control.action.UIPowerAction"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDcompany"%>
<%@page import="java.util.ArrayList"%>	
<%@page import="com.sinosoft.claim.util.DataCovert"%>
<%@page import="com.sinosoft.claim.dto.custom.DTreeDto"%>
<%@page import="com.sinosoft.claim.dto.custom.UserDto" %>
<%
  	response.setHeader("Pragma","No-cache");   	
	response.setHeader("Cache-Control","no-cache");   
	response.setDateHeader("Expires", -10);  
	String provinceCode = StringUtils.rightTrim(request.getParameter("provinceCode"));
	String treeTitle	= StringUtils.rightTrim(request.getParameter("treeTitle"));
	String codeType		= StringUtils.rightTrim(request.getParameter("codeType"));
	String nodeType		= StringUtils.rightTrim(request.getParameter("nodeType"));
	String HandlComCode		= request.getParameter("HandlComCode");	//转交受理机构
	UserDto user = (UserDto)session.getAttribute("user");
	
	String comCode = "";
	StringBuffer buffer         = new StringBuffer(); // 装载代码查询结果
	Collection colls = new ArrayList();
	Collection collsTemp1 = new ArrayList();
	Collection collsTemp2 = new ArrayList();
	Collection collsTemp3 = new ArrayList();
	Collection collsTemp4= new ArrayList();
	
	Collection collection = new ArrayList();
	int    recordSize           = -1;   // 记录条数信息 -1--null, 0--等于0, 1--大于0

	if(treeTitle == null || treeTitle.equals("")){
		treeTitle = "代码选择";
	}
	try{
		if("ComCode".equals(codeType)){
			String strCondition = " comCode not like '0000%' or comCode like '00000013%' order by comcode";
			BLPrpDcompanyFacade blPrpDcompayFacade = new BLPrpDcompanyFacade();
			colls = blPrpDcompayFacade.findByConditions(strCondition);
		}
		else{

	         String  checkCode    = "" ;//校验代码
		     String  taskCode     = "" ;//得到任务代码
		     boolean checkPower = false ; //是否通过校验
		     checkCode     = AppConfig.get("sysconst.CHECKCODE_EXE");
		     taskCode      = AppConfig.get("sysconst.TASKCODE_LP");
	         String conditions = "";
	         conditions = "  ValidStatus='1' "
	                       + " AND comCode in ( select ComCode from prpdCompany Start With ComCode = '" + HandlComCode
	                       + "' Connect By Prior comCode =  uppercomCode"
	                       + " and prior comcode != comcode and validstatus='1')";
	    

	         collection = new UICodeAction().findByConditions(UICodeAction.HANDERCODE,conditions,0,0);
	         recordSize=collection.size();
	         for(Iterator iterator = collection.iterator();iterator.hasNext();)
	         {
		       //对查询出的人员进行权限校验
		       PrpDuserDto prpDuserDto = (PrpDuserDto)iterator.next();
		       com.sinosoft.platform.dto.domain.PrpDuserDto platformPrpDuserDto = new com.sinosoft.platform.dto.domain.PrpDuserDto();
		       BLPrpDcompany prpDcompany = new BLPrpDcompany();   
	           String upperComCode = prpDcompany.getCenterCode(prpDuserDto.getComCode());
		       platformPrpDuserDto.setLoginComCode(upperComCode);
		       platformPrpDuserDto.setUserCode(prpDuserDto.getUserCode());
		       checkPower=UIPowerAction.checkPowerReturn(platformPrpDuserDto,Constants.TASK_CLAIM_CHECK);
		       if (checkPower) {
	               buffer.append("<option value='");
	               buffer.append(prpDuserDto.getUserCode());
	               buffer.append("_FIELD_SEPARATOR_");
	               buffer.append(prpDuserDto.getUserName());
	               buffer.append("'>");
	               buffer.append(prpDuserDto.getUserCode());
	               buffer.append("-");
	               buffer.append(prpDuserDto.getUserName());
	           }
	         }
		}
	}catch(Exception e){
		e.printStackTrace();
		if(nodeType == null || "".equals(nodeType)){
			out.println("系统错误：\n\n没有传节点类型");
		}else{	
			out.println("系统错误");
		}
	}
	Collection trees = DataCovert.collectionToTree(colls,codeType);
	StringBuffer sbBuf=new StringBuffer();
	sbBuf.append("[");
	Iterator iter=trees.iterator();
	DTreeDto city = null;
	while(iter.hasNext()){
		city = (DTreeDto)iter.next();
		sbBuf.append("{id:'"+city.getId()+"',");
		sbBuf.append("pId:'"+city.getParentId()+"',");
		sbBuf.append("name:'"+city.getName()+"',");
		sbBuf.append("url:'"+city.getUrl()+"',");
		sbBuf.append("target:'"+request.getParameter("target")+"'");
		if("".equals(city.getParentId())){
			sbBuf.append(",open:true}");
		}else{
			sbBuf.append("}");
		}
		sbBuf.append(",");
	}
	String strTreeData=sbBuf.substring(0,sbBuf.length()-1);
	strTreeData=strTreeData+"]";
	if(trees == null || trees.isEmpty()){
		strTreeData = "[]";
	}
%>
<%@page import="com.sinosoft.utility.SysConfig"%>
<%@page import="com.sinosoft.sysframework.common.util.StringUtils"%>
<%@page import="com.sinosoft.sysframework.common.Constants"%>
<html>
<head>
	<title><%=treeTitle %></title>
	<META   HTTP-EQUIV="pragma"   CONTENT="no-cache"> 
  	<META   HTTP-EQUIV="Cache-Control"   CONTENT="no-cache,   must-revalidate"> 
 	<script type="text/javascript" src="/claim/common/js/jquery-1.4.2.min.js"></script>
 	<link rel="stylesheet" type="text/css" href="/claim/css/StandardCarRisk.css">
	<link rel="stylesheet" type="text/css" href="/claim/common/dtree/dtree.css"></link>
	<!-- <script type="text/javascript" src="/claim/common/dtree/dtree.js"></script> -->
	<script language="Javascript" src="/claim/common/js/Common.js"></script>
	<script language="Javascript" src="/claim/common/js/InputCode.js"></script>
	<script language="Javascript" src="/claim/common/js/PrivateInputCode.js"></script>
	<link rel="stylesheet" type="text/css" href="/claim/common/ztree/css/zTreeStyle/zTreeStyle.css"></link>
	<script type="text/javascript" src="/claim/common/js/ztree/jquery.ztree.core-3.1.js"></script>
	<style type="text/css">
		body{
			border-width: 0px;
			margin: 0;
			padding: 0;
		}
		.treeDiv{
			overflow: auto;
			width: 100%;
			height:90%;
		}
		.treeDivButtom{
			background-color: threedlightshadow;
			height:10%;
			padding-top:5px;
			border-top: 2px outset ;
		}
	</style>
	<script type="text/javascript">
		//$(document).ready(function(){
		window.onload = function(){
	  		var t = $("#treeDemo");
	  		var zNodes = <%=strTreeData%>;
	  		t = $.fn.zTree.init(t, setting, zNodes);
		}
	  	//});*/
	  	
		var setting = {
			callback: {
				onClick: zTreeOnClick
			},
	  		view: {
	  			dblClickExpand: false,
	  			showLine: true,
	  			selectedMulti: false,
	  			expandSpeed: ""
	  		},
	  		data: {
	  			simpleData: {
	  				enable:true
	  			}
	  		}
		};
		
		function zTreeOnClick(event, treeId, treeNode) {
		    submitForm(treeNode.id,treeNode.name);
		}
		
		function submitForm(comCode,comName){
			window.returnValue = comCode + "#" + comName;
			window.close();
		}
		function windowclose(){
		    window.close();
		}
		
		function submitForm1(){
			var checks = fm.codeselect;
			var comCode = "";
			var comName = "";
			for(var i = 0;i < checks.length;i++){
				if(checks[i].selected){
				var charStr = checks[i].value.split("_FIELD_SEPARATOR_");
					comCode += charStr[0];
					comName += charStr[1];
					break;
				}	
			}
			window.returnValue = comCode + "#" + comName;
			window.close();
		}
		
	</script>
</head>
<body scroll="no">
	
	<div class="treeDiv">
	<form name="fm">
	 <%
	 if("ComCode".equals(codeType)){
	 %>
		<%
	    if(trees == null || trees.isEmpty()){
		%>
		<span class="norecord">查询结果无记录！</span>
		<%		
		}
	    %>
	    <div class="treeDiv">
	    	<ul id="treeDemo" class="ztree"/>
	    </div>
<% }else{ %>
	<table class="common" style="width:100%" align="center">
		<tr>
			<td style="width:30%"></td>
			<td style="width:20%" align="center">
						<%// 确定按钮%>
				<input type=button name=SelectIt class="button" value="<%--<bean:message key='button.save.value' />--%>确定" onclick='submitForm1()'></input>
			</td>
			<td style="width:20%" align="center">
				<input type=button name=CancelIt class="button" value="<bean:message key='button.cancel.value' />" onclick='window.close()'></input><!-- onclick='cancelFieldValue()' -->
			</td>
			<td style="width:30%"></td>
		</tr>
		<tr>
			<td colspan=4 align="center" style="width:100%">
				<select name=codeselect class="code" style='width:200px' size=20 onkeypress=fieldOnKeyPress() ondblclick="submitForm1()">
				<%=buffer.toString()%>
				</select>
	</td>
				</tr>
			</table>
<%} %>
	</form>
	</div>
	<!--  
	<div class="treeDivButtom">
	<center><input type="button" value=" 确定 " onclick="submitForm()"/> <input type="button" value=" 取消 " onclick="window.close();"/></center>
	</div>
	-->
</body>
</html>