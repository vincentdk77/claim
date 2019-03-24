<%--
****************************************************************************
* DESC       ：树形结构查询
* AUTHOR     ：国元
* CREATEDATE ：2014-12-24
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.claim.bl.facade.BLSelectTree"%>
<%@page import="com.sinosoft.claim.dto.domain.DTreeNewDto"%>
<%@page contentType="text/html;charset=GBK"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sinosoft.platform.dto.domain.PrpDuserDto"%>

<html>
<head>
	<title>代码选择</title>
	<link rel="stylesheet" type="text/css" href="/claim/common/ztree/css/zTreeStyle/zTreeStyle.css"></link>
	<script type="text/javascript" src="/claim/common/ztree/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="/claim/common/ztree/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="/claim/common/ztree/js/jquery.ztree.exedit-3.5.js"></script>
	<script type="text/javascript" src="/claim/common/ztree/js/jquery.ztree.excheck-3.5.js"></script>
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
	var temp ;
		function submitForm(){
				var checks = treeObj.getCheckedNodes(true);
				var flag = fm.flag.value;
				var codeType = fm.codeType.value;
				var value = "";
				var count = 0;
				var cname = "";
				var comcode=new Array();
				for(var i = 0;i < checks.length;i++){
					if(codeType == 'classCodeTemp'){
						if(checks[i].id.length != 2)
							continue;
					}
					else if(codeType == 'riskCode'){
						if(checks[i].id.length != 4)
							continue;
					}else if(codeType == 'zcflag'){
						if(checks[i].id == 99)
							continue;
					}
					
					if(count != 0){
						value += ",";
						cname += ",";
					}
					if(flag == "1"){
						value += "'" + checks[i].id + "'";
						cname += checks[i].name ;
						
					}
					else{
						value += checks[i].id;
						cname += checks[i].name;
						comcode[i] = checks[i].id ;
					}
					count++;
				}
				
				if(comcode[0]!=null)
				{
				//yx begin
				// window.opener.setCodeValue(comcode);
				 //window.dialogArguments.setCodeValue(comcode);
				}else
				{
				//window.dialogArguments.setCodeValue(value);
				}
				if(window.dialogArguments.setCodeName != null){
					
					//window.dialogArguments.setCodeName(cname);
					
				}
				temp=value+"#"+cname;
				//yx end
				window.returnValue=temp;
				window.close();
		}
		
		
	</script>
</head>
<%
	String codeType = request.getParameter("codeType");
	String codecode = request.getParameter("codecode");
	System.err.println(codecode);
	List<DTreeNewDto> trees = null;
	BLSelectTree  blSelectTree = new BLSelectTree();
	if(codeType.equals("classCodeTemp")){
		 trees = blSelectTree.queryClassCode(codecode);
	}else if("zcflag".equals(codeType)){
		trees = blSelectTree.queryGoveFlagCode(codecode);
	}else if(codeType.equals("riskCode")){
		trees = blSelectTree.queryRiskCode(codecode);
	}
	String flag		= request.getParameter("flag");
	String organCode = request.getParameter("organCode");
	StringBuffer sbBuf=new StringBuffer();
	sbBuf.append("[");
	for(DTreeNewDto dto : trees){
		sbBuf.append("{id:'"+dto.getId()+"',");
		sbBuf.append("pId:'"+dto.getParentId()+"',");
		sbBuf.append("name:'"+dto.getName()+"',");
		sbBuf.append("url:'"+dto.getUrl()+"',");
		sbBuf.append("target:'"+request.getParameter("target")+"'");
		if("false".equals(dto.getCheckBox())){
			sbBuf.append(",nocheck:true");
		}
		if(dto.isChecked()){
			sbBuf.append(",checked:true");
		}
		if(dto.isDisabled()){
			sbBuf.append(",chkDisabled:true");
		}
		if("".equals(dto.getParentId())){
			sbBuf.append(",open:true}");
		}else{
			sbBuf.append("}");
		}
		sbBuf.append(",");
	}
	String strTreeData=sbBuf.substring(0,sbBuf.length()-1);
	strTreeData=strTreeData+"]";
	//System.out.println("yx----------------"+strTreeData);
	 
	if(trees == null || trees.isEmpty()){
		strTreeData = "[]";
	}
%>
<body scroll="no">
	<script type="text/javascript">
		var treeObj;
		
		var setting = {
			check: {
				enable: true,
				chkStyle:"checkbox",
				chkboxType:{"Y":"s","N":"s"}
			},
	  		data: {
	  			simpleData: {
	  				enable:true
	  			}
	  		},
	  		view: {
	  			addHoverDom:setBackgroundColor1,
	  			removeHoverDom:setBackgroundColor2
	  		}
		};
		
		var zNodes = <%=strTreeData%>;
		
		$(document).ready(function(){
	  		treeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
	  	});
	  	
		function zTreeOnClick(event, treeId, treeNode) {
		    submitForm();
		}
		
		function submitForm1(comCode,comName){
			window.returnValue = comCode + "#" + comName;
			window.close();
		}
		function windowclose(){
		    window.close();
		}
		function setBackgroundColor1(treeId, treeNode){
			$("#"+treeNode.tId+"_a").css("background-color","#0066cc");
		}
		function setBackgroundColor2(treeId, treeNode){
			$("#"+treeNode.tId+"_a").css("background-color","");
		}
	</script>

	<form name="fm">
	<input type="hidden" name="codeType" value="<%=codeType %>"/>
	<input type="hidden" name="codecode" value="<%=codecode %>"/>
	<input type="hidden" name="flag" value="<%=flag %>"/>
	</form>
	<div class="treeDiv">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	<div class="treeDivButtom">
	<center><input type="button" value=" 确定 " onclick="submitForm()"/> <input type="button" value=" 取消 " onclick="window.close();"/></center>
	</div>

</body>
</html>