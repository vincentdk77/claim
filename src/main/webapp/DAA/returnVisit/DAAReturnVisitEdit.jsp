<%--
****************************************************************************
* DESC       ：回访管理
* AUTHOR     ：chengyupeng
* CREATEDATE ：2011-12-28
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@	page contentType="text/html; charset=GBK"	language="java"	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>回访管理</title>
	<%-- 页面样式  --%>
	<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
	<link href="/claim/css/Toolbar.css" rel="stylesheet" type="text/css" />
	<link href="/claim/css/tabstyle.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="/claim/css/tableType.css">
	<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
	<script type="text/javascript" src="/claim/js/Toolbar.js"></script>
	<jsp:include page="/common/pub/StaticJavascript.jsp" />
<script type="text/javascript">	
		  var formutil=new FormUtil();
		/////////////////////////////////////////////////////////////////
		var toolbar;
		$(document).ready(function(){
		var nodeType = '<%=request.getAttribute("nodeType")%>';
        if(nodeType=='sched'){
            toolbar = new Toolbar({
      		  renderTo : 'toolbar',
     	      border: 'none',
     	      items : [{
         	     type : 'button',
        	     text : '流程查询',
        	     bodyStyle : 'file',
        	     useable : 'T',
        	     handler : function(){
       	         var swfLogFlowID = fm.swfLogFlowID.value;
                          var url = "/claim/swfFlowBeforeQuery.do?swfLogFlowID="+swfLogFlowID+"";
	                  		if(hasSVG()){
	                  			url += "&svgFlag=1";
	                  		}else{ 
	                  			url += "&svgFlag=0";
	                  		}
	                  		window.open(url);
          }
        }]
      });  toolbar.render();	
            }else if(nodeType == 'endca'){
            		toolbar = new Toolbar({
      		  renderTo : 'toolbar',
     	      border: 'none',
     	      items : [{
         	     type : 'button',
        	     text : '流程查询',
        	     bodyStyle : 'file',
        	     useable : 'T',
        	     handler : function(){
       	         var swfLogFlowID = fm.swfLogFlowID.value;
                          var url = "/claim/swfFlowBeforeQuery.do?swfLogFlowID="+swfLogFlowID+"";
	                 		if(hasSVG()){
	                 			url += "&svgFlag=1";
	                 		}else{ 
	                 			url += "&svgFlag=0";
	                 		}
	                 		window.open(url);
          }
        },'-',{
          type : 'hidden',
         // style: 'display:none'
          text : '支付信息',
          bodyStyle : 'file',
          useable : 'T',
          handler : function(){
            var registNo = fm.registNo.value;
          var nodetype = fm.nodeType.value;
			window.open('/claim/returnDetailEdit.do?registNo='+registNo+'&flag=TOOL&nodeType='+nodeType);
          }
        }
        ]
      }); 
       toolbar.render();
            }

		});
</script>
</head>
  
<body>
	<form name=fm action="/claim/returnVisitSaveEdit.do" method="post" onsubmit="return validateForm(this,'Driver','');">
		<div id="toolbar" style="width: 99%; border: 1px solid #3A81C8; border-bottom: none;"></div>
		<input type="hidden" id="swfLogFlowID" name="swfLogFlowID" value="${swfLogFlowID}">
		<input type="hidden" id="registNo" name="registNo" value="${registNo}">
		<input type="hidden" id="nodeType" name="nodeType" value="${nodeType}">
		<!--  加页签-->
		<div class="tab">
			<!--页签头-->
			<div class="tab_menu">
				<ul>
					<li class="selected">
						回访
					</li>
				</ul>
			</div>

			<div class="tab_box">
				<div id="schedulMain">
						<%@include file="/DAA/returnVisit/DAAReturnVisitMessage.jsp"%>
				</div>
			</div>
		</div>
		<!-- 按钮 -->
		<div " id="outcontainer" name="submitDiv">
			<div id=content_basic>
				<table align="center" id="buttonTable">
					<tr>
						<td>
							<c:if test="${editType ne 'SHOW'}">
							<input type="button" id="backButton" class="bobu" value="保存" onclick="saveForm('4')">
							<input type="button" id="backButton" class="bobu" value="放弃" onclick="saveForm('3')">
							</c:if>
							<c:if test="${editType eq 'SHOW'}">
								<input type="button" id="backButton" class="bobu" value="返回" onclick="saveForm('2')">
							</c:if>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	//存在问题 JS
	function checkboxBut(obj){
		var inputObj = $(obj).parent().find("input");
		var inputvalue = "";
		inputObj.each(function(i){
			if(inputObj[i].name == 'existissueBox' && inputObj[i].checked == true){
				if(inputvalue == ""){
					inputvalue = inputObj[i].value;
				}else{
					inputvalue = inputvalue+";"+inputObj[i].value;
				}
			}
		});
		inputObj.each(function(i){
			if(inputObj[i].name == 'existissue'){
				inputObj[i].value = inputvalue;
			}
		});
	}
	function hasSVG(){
		SVG_NS = 'http://www.w3.org/2000/svg';
	return !!document.createElementNS && !!document.createElementNS(SVG_NS,'svg').createSVGRect;
	} 
	//单选按钮、下拉框点击后隐藏域赋值
	function selectBut(obj,inputName){
		var inputObj = $(obj).parent().find("input");
		inputObj.each(function(i){
			if(inputObj[i].name == inputName){
				inputObj[i].value = obj.value;
			}
		});
	}
	
	
  //单选按钮、下拉框点击后隐藏域赋值
	function turnIssue(){
	  //alert("dfdfdf");
      var serviceSelectNode=document.getElementsByName("serviceSelect");
      var serviceSelect=serviceSelectNode[0];
      var index=serviceSelect.selectedIndex;
      var existissueBoxNode=document.getElementsByName("existissueBox");
      var mustWriteSign=document.getElementById("document.getElementsByName");
      //alert(serviceSelect[index].value);
      if(serviceSelect[index].value=='1'){
        for(var i=0;i<7;i++){
          existissueBoxNode[i].disabled=true;
        }
      }else {
        for(var i=0;i<7;i++){
          existissueBoxNode[i].disabled=false;
        }          
        }
	}
	
	//不成功时显示是否跟进选项
	function toggleRadio(obj){
		$("#divfailradio").toggle(obj.value == '0');
	}
	
	
	//是否回访成功 不成功原因不可操作
	function defeatedBut(obj){
		var inputObj = $(obj).parent().parent().find("input");
		var selectObj = $(obj).parent().parent().find("select");
		inputObj.each(function(i){
			if(obj.value == 1 && inputObj[i].name == 'visitnocause'){
				inputObj[i].value = "";
			}
		});
		selectObj.each(function(i){
			if(selectObj[i].name == 'visitnocauseSelect'){
				if(obj.value == '1'){
					selectObj[i].disabled="disabled";
					selectObj[i].value = '0';
					document.getElementById('visitsuccessState').value='1';
				}else{
					selectObj[i].disabled="";
					document.getElementById('visitsuccessState').value='0';
				}
			}
		});
		
	}
	//保存方法
	function saveForm(id){
		var status = true;
		if(id == '4'){
			//判断input是否为空
//			var inpurCname = $("input[cname]");
//				inpurCname.each(function(i){
//				var name = inpurCname[i].name;
//				var valuename = $("input[name="+name+"]:last");
//				if(valuename.val() == ""){
//					valuename.focus();
//					alert(inpurCname[i].cname+"不能为空！");
//					status = false;
//					return false;
//				}
//			});
//			//判断Select是否为空
//			if(status){
//				var selectCname = $("select[cname]");
//				selectCname.each(function(i){
//					var name = selectCname[i].name;
//					var valuename = $("select[name="+name+"]:last");
//					if(valuename.val() == "0"){
//						valuename.focus();
//						alert(selectCname[i].cname+"不能为空！");
//						status = false;
//						return false;
//					}
//				});
//			}
            	if(status == true){
					var visitname = $("input[name=visitname]:first").val();
					if(visitname == ""){
						alert("被回访人不能为空！");
						status = false;
						return false;
					}
				}
				if(status == true){
					var contact = $("input[name=contact]:first").val();
					if(contact == ""){
						alert("联系号码不能为空！");
						status = false;
						return false;
					}
				}
			
			if(status == true){
				var visitsuccess = $("input[name=visitsuccess]:first").val();
				if(visitsuccess == ""){
					alert("是否回访成功不能为空！");
					status = false;
					return false;
				}
				var visitfail = $("input[name=visitfail]:first").val();
				if(visitsuccess == "0" && visitfail == ""){
					alert("是否需要跟进不能为空！");
					status = false;
					return false;
				}
			}
			if(status == true){
				var selectCname = $("select[cname]");
				selectCname.each(function(i){
					var name = selectCname[i].name;
					var valuename = $("select[name="+name+"]:first");
					
					if(name == 'serviceSelect'){
						var visitsuccess = $("input[name=visitsuccess]:first").val();
						if(visitsuccess == '1'){
							if(valuename.val() == "0"){
								valuename.focus();
								alert(selectCname[i].cname+"不能为空！");
								status = false;
								return false;
							}
						}
					}
					if(name == 'visitnocauseSelect'){
						var visitsuccess = $("input[name=visitsuccess]:first").val();
						if(visitsuccess == '0'){
							if(valuename.val() == "0"){
								valuename.focus();
								alert(selectCname[i].cname+"不能为空！");
								status = false;
								return false;
							}
						}
					}
				});
			}
			
			if(status == true){			
				var visitsuccess = $("input[name=visitsuccess]:first").val();
				if(visitsuccess == '1'){				
					var recorderno = $("input[name=recorderno]:first").val();
					if(recorderno == ""){
						alert("录音流水号不能为空。");
						status = false;
						return false;
					}
				}
			}
			
			if(status == true){		
			    var service = $("input[name=service]:first").val();
				var visitsuccess = $("input[name=visitsuccess]:first").val();
				if(visitsuccess == '1'){
					var existissue = $("input[name=existissue]:first").val();
					if(existissue == ""){
					   if(service != "1"){
						alert("存在问题不能为空。");
						status = false;
						return false;
					   }
					}
				}
			}
			
			var cmaxObj = $("input[cmax]");
			for(var i=0;i<cmaxObj.length;i++){
				var naxName = cmaxObj[i].name;
				var objValue = $("input[name="+naxName+"]");
				for(var x=0;x<objValue.length;x++){
					if(cmaxObj[i] == objValue[x]){
						var valno = objValue[x].value;
						if(valno.length > parseInt(objValue[x].cmax)){
							alert(objValue[x].cname+"长度不能大于"+objValue[x].cmax+"!");
							return false;
						}
					}
				}
			}
			
		}
		if(id == '3'){
			document.getElementById('nodeType').value = "";
			fm.action='/claim/returnVisitEdit.do?editType=SHOW';
		}
		if(id == '2'){
			fm.action='/claim/returnVisitQueryEdit.do?editType=ADD';
		}
		if(status == true){
			fm.submit();
			return status;
		}
	}
	
	function textareaValue(obj){
		var inputObj = $(obj).parent().find("input");
		inputObj[0].value = obj.innerHTML;
	}
</script>
</html>