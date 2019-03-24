<%@ page contentType="text/html; charset=GBK" %>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>

<%
	String provinceCode = request.getParameter("provinceCode");
	String treeTitle  = request.getParameter("treeTitle");
	String codeType   = request.getParameter("codeType");
	String comCode = "";
	Collection colls = new ArrayList();
	if(provinceCode != null && provinceCode.length() > 6){
		comCode = provinceCode.substring(0,6);
	}
	if(treeTitle == null || treeTitle.equals("")){
		treeTitle = "代码选择";
	}
	if("ComCode".equals(codeType)){
	    //增加Validstatus = '1'查询条件，屏蔽无效机构的展示
		String strCondition = " (comCode not like '0000%' or comCode like '00000013%' or comCode like '00000018%' or comCode like '000018%') And Validstatus = '1' order by comlevel,comcode";
		BLPrpDcompanyFacade blPrpDcompayFacade = new BLPrpDcompanyFacade();
		colls = blPrpDcompayFacade.findByConditions(strCondition);
	}
	else if("jobComCode".equals(codeType)){
	    //增加order by comlevel,comcode，使具有中心支公司登录权限的人员进行班表修改操作时，能够带出本级机构
		String strCondition = " companyflag = '1' And comCode In (Select Comcode From Prpdcompany Start With Comcode = '"+provinceCode+"' Connect By Prior Comcode = Uppercomcode And Prior Comcode != Comcode And Validstatus = '1') order by comlevel,comcode";
		BLPrpDcompanyFacade blPrpDcompayFacade = new BLPrpDcompanyFacade();
		colls = blPrpDcompayFacade.findByConditions(strCondition);
	}
	else{
		
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




<%@page import="com.sinosoft.claim.util.DataCovert"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sinosoft.claim.dto.custom.DTreeDto"%>
<html>
<head>
	<!-- <script type="text/javascript" src="/claim/common/dtree/dtree.js"></script> -->
	<title>代码选择</title>
	<script type="text/javascript" src="/claim/common/js/jquery-1.4.2.min.js" ></script> 
	<link rel="stylesheet" type="text/css" href="/claim/common/dtree/dtree.css"></link>
	<link rel="stylesheet" type="text/css" href="/claim/common/ztree/css/zTreeStyle/zTreeStyle.css"></link>
	<script type="text/javascript" src="/claim/common/js/ztree/jquery.ztree.core-3.1.js"></script>
	<script language="Javascript" src="/claim/common/js/Common.js"></script>
	<script language="Javascript" src="/claim/common/js/InputCode.js"></script>
	<script language="Javascript" src="/claim/common/js/PrivateInputCode.js"></script>
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
		  	//});
	  	
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
		
		/* function submitForm(){
				var checks = fm.treeCheckBox;
				var comCode = "";
				var comName = "";
				for(var i = 0;i < checks.length;i++){					
					if(checks[i].checked){
						comCode += checks[i].value;
						comName += checks[i].valueName;
						break;
					}	
				}
				window.returnValue = comCode + "#" + comName;
				window.close();
		} */
	</script>
</head>
<body scroll="no">
	
	<div class="treeDiv">
	<form name="fm">
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
	<%--<script type="text/javascript">
		 d = new dTree('d');	
<%
	Iterator it = trees.iterator();
	int index = 0;
	while(it.hasNext()){
		DTreeDto dTreeDto = (DTreeDto)it.next();
		if(index == 0){
%>	    	
	    	d.add('<%=dTreeDto.getParentId()%>','-1','<%=treeTitle%>','','','','','',false,false,false,false);
<%
	    }
%>
	    d.add('<%=dTreeDto.getId()%>',
	    	  '<%=dTreeDto.getParentId()%>',
	    	  '<%=dTreeDto.getName()%>',
	    	  '','','','','',
	    	  false,
	    	  false,
	    	  false,
	    	  false);
<%
		index++;
	}
	if(index == 0){
%>
	d.add('0','-1','<%=treeTitle%>','','','','','',false,false,false,false);
	document.write(d);	
	document.write('<span class="norecord">查询结果无记录！</span>');
<%		
	}
	else{
%>
	document.write(d);	
<%		
	}
%>  
	</script>
<%
	if(trees == null && trees.isEmpty()){
%>
		<center>无记录</center>
<%		
	}
%> --%>
	</form>
	</div>
</body>
</html>