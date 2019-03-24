<%@ page contentType="text/html; charset=GBK" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@page import="java.util.Map" %>
<%@page import="com.gyic.claim.dto.domain.SettlemainlistDto" %>
<%@page import="com.gyic.claim.dto.domain.InsuremainlistDto" %>
<%@page import="com.gyic.claim.dto.domain.NyxsettlelistDto" %>
<%@page import="com.gyic.claim.dto.domain.NyxsettlelisttempDto" %>
<%@page import="com.gyic.claim.dto.domain.NyxpolicylistDto" %>
<%@page import="com.sinosoft.sysframework.common.datatype.PageRecord" %>
<%@page import="java.util.Collection" %>
<%@page import="com.sinosoft.nyx.blsvr.BLNyxPolicyList" %>
<%@page import="com.sinosoft.nyx.schema.NyxPolicyListSchema" %>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDrisk" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Iterator" %>
<%@page import="com.gyic.claim.ui.control.facade.UIClaimGetSettleListFacade" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">

  <head>
    <html:base />
    
    <title>理赔清单页面</title>

  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	
  </head>
<script language="javascript">
  function gotoPage(strMethod){
    if(parseInt(fm.PageNum.value)==1){
      document.getElementsByName("NextPage")[0].disabled = true;
      document.getElementsByName("FinalPage")[0].disabled = true;
    }
    else if(parseInt(fm.PageNum.value)==parseInt(fm.PageCount.value)){
      document.getElementsByName("FirstPage")[0].disabled = true;
      document.getElementsByName("PreviousPage")[0].disabled = true;
    }else{
      document.getElementsByName("FirstPage")[0].disabled = true;
      document.getElementsByName("PreviousPage")[0].disabled = true;
      document.getElementsByName("NextPage")[0].disabled = true;
      document.getElementsByName("FinalPage")[0].disabled = true;
    }
    if(parseInt(fm.PageCount.value)>1)
      document.getElementsByName("PersonalPage")[0].disabled = true;
    if(strMethod=="First")
      fm.PageNum.value = 1;
    else if(strMethod=="Previous")
      fm.PageNum.value = parseInt(fm.PageNum.value)-1;
    else if(strMethod=="Next")
      fm.PageNum.value = parseInt(fm.PageNum.value)+1;
    else if(strMethod=="Final")
      fm.PageNum.value = fm.PageCount.value;
    else if(strMethod=="Personal"){
      if(parseInt(fm.PersonalPage.value)<1||parseInt(fm.PersonalPage.value)>parseInt(fm.PageCount.value)){
        alert("没有这一页，请重试！");
        //document.fm.PersonalPage.focus();

        if(parseInt(fm.PageNum.value)==1){
	      document.getElementsByName("NextPage")[0].disabled = false;
	      document.getElementsByName("FinalPage")[0].disabled = false;
        }
        else if(parseInt(fm.PageNum.value)==parseInt(fm.PageCount.value)){
	      document.getElementsByName("FirstPage")[0].disabled = false;
	      document.getElementsByName("PreviousPage")[0].disabled = false;
        }else{
	      document.getElementsByName("FirstPage")[0].disabled = false;
	      document.getElementsByName("PreviousPage")[0].disabled = false;
	      document.getElementsByName("NextPage")[0].disabled = false;
	      document.getElementsByName("FinalPage")[0].disabled = false;
        }
        if(parseInt(fm.PageCount.value)>1)
	      document.getElementsByName("PersonalPage")[0].disabled = false;

        return false;
      }else{
        fm.PageNum.value = fm.PersonalPage.value;
      }
    }
    fm.submit();
  }
  function searchSettleInfo(){
  	fm.PageNum.value=1;
  	fm.submit();
  }
  function deleteItems(){
  	var dataSource = fm.dataSource.value;
  	if("PolicyList"==dataSource){
  		alert("保单清单数据不可删除！！");
  		return false;
  	}else if("SettleList"==dataSource){
  		var nodeType = fm.nodeType.value;
  		var realNodeType = fm.realNodeType.value;
  		if(nodeType==realNodeType){
	  		var checkboxs=document.getElementsByName("settleIndexes");
	  		var checked = false;
			for(var i=0;i<checkboxs.length;i++){
				if(checkboxs[i].checked){
					checked = true;
					break;
				}
			}
			if(checked){
		  		fm.action = "/claim/deletePlantingSettleList3224.do"
		  		fm.submit();
	  		}else{
	  			alert("请至少选择一个农户理赔信息！");
	  			return false;
	  		}
  		}else alert("当前节点下无清单，不可删除！");
  	}
  }
  function checkAll(obj){
	if (obj.name=="checkall"){
		var checkboxs=document.getElementsByName("settleIndexes");
		for(var i=0;i<checkboxs.length;i++){
			checkboxs[i].checked=obj.checked;
		}
	}else{
		//var checkboxs=document.getElementsByName("d");	
		//for(var i=0;i<checkboxs.length;i++){
		//alert(checkboxs[i].name);
		//	checkboxs[i].checked=obj.checked;
		//}	
	}
  }
  function cbOnclick(obj){
	 var cbAll=document.getElementsByName("checkall")[0];
	 if(cbAll.indeterminate==false){
	  cbAll.indeterminate=true;
	 }
	 var cb=checkCB(obj,"settleIndexes");
	 if(cb==1){
	  cbAll.indeterminate=false;
	  cbAll.checked=true;
	 }else if(cb==2){
	  cbAll.indeterminate=false;
	  cbAll.checked=false;
	 }else if(cb==0){
	  cbAll.indeterminate=true;
	  cbAll.checked=false;
	 }  
  }
  function checkCB(obj,checkboxName){
	 var flag=0;
	 var oo=document.getElementsByName(checkboxName);
	 var k=0;
	 if(oo!=null&&oo.length>0){
	    for(var i=0;i<oo.length;i++){
	       if(oo[i].checked==true){
	         k++;
	    	}
	    }
	 }
	 if(k==oo.length){
	    flag=1;
	 }else if(k==0){
	    flag=2;
	 }else{
	    flag=0;
	 }
 	return flag;
  }
  function deleteAllSettle(){
  	var dataSource = fm.dataSource.value;
  	if("PolicyList"==dataSource){
  		alert("保单清单数据不可删除！！");
  		return false;
  	}else if("SettleList"==dataSource){
  		var nodeType = fm.nodeType.value;
  		var realNodeType = fm.realNodeType.value;
  		if(nodeType==realNodeType){
	  		if(confirm("当前清单下所有数据将被删除！")){
		  		fm.deleteAll.value = "deleteAll";
		  		fm.action = "/claim/deletePlantingSettleList3224.do"
		  		fm.submit();
	  		}else return false;
  		}else alert("当前节点下无清单，不可删除！");
  	}
  }
  function importSettle(){
	var res=checkFileName();
	if (!res)
		return false;
	else{
		document.fm.action="/claim/plantingSettleImport3224.do?";
		initScroll('scrlContainer', 'scrlContent');
		document.fm.submit();
	}
 }
 function checkFileName(){
	var s=document.getElementById("formFile").value;
	var allowSubmit=true;
	
	if ((s=="")){
		alert("请先选择一个文件！");
		allowSubmit=false;
	}
	else if((s.substr(s.length-4,4).toLowerCase().match("^.xls|cvs$")==null)){
		alert("请选择Excel文件！");
		allowSubmit=false;
		document.getElementById("formFile").focus();
	}
	return allowSubmit;
 }
 function save(){
 	var loadXLS = fm.loadXLS.value;
 	if("loadXLS"!=loadXLS){
 		alert("请先导入理赔清单！！");
 		return false;
 	}
 	else{
 		var saveButton = document.getElementsByName("saveSettle");
 		saveButton[0].style.display="none"; 		
		initScroll('scrlContainer', 'scrlContent');
 		document.fm.action="/claim/plantingSettleSave3224.do?";
 		document.fm.submit();
 	}
 }
function checkPersonal(){
  if(""==fm.PersonalPage.value||null==fm.PersonalPage.value){
     alert("页数不能为空！！");
  }
}
//decreasing speed for mozilla
//scrlSpeed = (document.all) ? scrlSpeed : Math.max(1, scrlSpeed - 1)
function initScroll(container, object) {
//先隐藏所有按钮！
var fileTr= document.getElementById("fileTr");
fileTr.style.display="none";
var fileTr= document.getElementById("buttonTr");
fileTr.style.display="none";
 var scrlSpeed = 1
 if (document.getElementById(container) != null) {
  var contObj = document.getElementById(container);
  var obj = document.getElementById(object);
  contObj.style.visibility = "visible";
  contObj.scrlSpeed = scrlSpeed;
  widthContainer = contObj.offsetWidth;
  obj.style.left = parseInt(widthContainer) + "px";
  widthObject = obj.offsetWidth;
  interval = setInterval("objScroll('" + container + "','" + object
    + "'," + widthContainer + ")", 20);
  contObj.onmouseover = function() {
   contObj.scrlSpeed = 0;
  }
  contObj.onmouseout = function() {
   contObj.scrlSpeed = scrlSpeed;
  }
 }
}

function objScroll(container, object, widthContainer) {
 var contObj = document.getElementById(container);
 var obj = document.getElementById(object);
 widthObject = obj.offsetWidth;
 if (parseInt(obj.style.left) > (widthObject * (-1))) {
  obj.style.left = parseInt(obj.style.left) - contObj.scrlSpeed + "px";
 } else {
  obj.style.left = parseInt(widthContainer) + "px";
 }
}
 function initPage(){
 	var editType = document.getElementsByName("editType")[0].value;
 	var loadXLS = document.getElementsByName("loadXLS")[0].value;
 	if("view"==editType){
 		var exportSettleList = document.getElementsByName("exportSettleList");
 		exportSettleList[0].style.display="";
 	}else if("edit"==editType && "loadXLS"!=loadXLS){
 		var fileTr= document.getElementById("fileTr");
 		fileTr.style.display="";
 		var nodeType = fm.nodeType.value;
  		var realNodeType = fm.realNodeType.value;
  		if(nodeType==realNodeType){
	 		var deleteSelected = document.getElementsByName("deleteSelected");
	 		deleteSelected[0].style.display="";
	 		var deleteAllButton = document.getElementsByName("deleteAllButton");
	 		deleteAllButton[0].style.display="";
	 		var exportSettleList = document.getElementsByName("exportSettleList");
	 		exportSettleList[0].style.display="";
 		}
 		var exportTemplate = document.getElementsByName("exportTemplate");
 		exportTemplate[0].style.display="";
 	}else if("loadXLS"==loadXLS){
 		var fileTr= document.getElementById("fileTr");
 		fileTr.style.display="";
 		var saveButton = document.getElementsByName("saveSettle");
 		saveButton[0].style.display="";
 		var exportTemplate = document.getElementsByName("exportTemplate");
 		exportTemplate[0].style.display="";
 		//var exportSettleList = document.getElementsByName("exportSettleList");
 		//exportSettleList[0].style.display="";
 	}
}  
</script>
<style type="text/css">
#scrlContainer{
    visibility:hidden;
    background:#f1f1f1;
    position:relative;
    overflow:hidden;
    width: 100%;
    height:40px;
    line-height:40px;
    margin:1em;
}

#scrlContent{
    position:absolute;
    left:0;
    top:0;
    white-space:nowrap;
}
</style>
<%	
	String insureListCode = "";
	String settleListCode = "";
	String riskCode = "";
	String registNo = "";
	String claimNo = "";
	String policyNo = "";
	String nodeType = "";
	String areaCode = "";
	String classCode = "";
	String loadXLS = "";
	String editType = "";
	String nodeTypeName = "";
	String realNodeType = "";
	String realNodeTypeName = null;
	String compensateNo = "";
	Map settleListMap = (Map)request.getAttribute("settleListMap");
	String listType = (String)settleListMap.get("listType");
	registNo = (String)request.getAttribute("registNo");
	claimNo = (String)request.getAttribute("claimNo");
	policyNo = (String)request.getAttribute("policyNo");
	nodeType = (String)request.getAttribute("nodeType");
	realNodeType = (String)request.getAttribute("realNodeType");
	compensateNo = (String)request.getAttribute("compensateNo");
	if(null!=nodeType && !"".equals(nodeType)){
		String[] nodeList = com.gyic.claim.ui.control.facade.UIClaimGetSettleListFacade3224.nodeList;
		String[] nodeListName = com.gyic.claim.ui.control.facade.UIClaimGetSettleListFacade3224.nodeNameList;
		for(int i=0;i<nodeList.length;i++){
			if(nodeList[i].equals(nodeType)){
				nodeTypeName = nodeListName[i];
				break;
			}
		}
	}
	if(null!=realNodeType && !"".equals(realNodeType)){
		String[] nodeList = com.gyic.claim.ui.control.facade.UIClaimGetSettleListFacade3224.nodeList;
		String[] nodeListName = com.gyic.claim.ui.control.facade.UIClaimGetSettleListFacade3224.nodeNameList;
		for(int i=0;i<nodeList.length;i++){
			if(nodeList[i].equals(realNodeType)){
				realNodeTypeName = nodeListName[i];
				break;
			}
		}
	}
	loadXLS = (String)request.getAttribute("loadXLS");
	editType = (String)request.getAttribute("editType");
	int totalPageNum = 0;
	int currentPageNum = 0;
	String timeStamp = (String)request.getAttribute("timeStamp");
	if(null!=settleListMap.get("totalPageNum"))
		totalPageNum = Integer.parseInt(String.valueOf(settleListMap.get("totalPageNum")));
	if(null!=settleListMap.get("currentPageNum"))
		currentPageNum = Integer.parseInt(String.valueOf(settleListMap.get("currentPageNum")));
	if("SettleList".equals(listType)){
		SettlemainlistDto settleMainListDto = (SettlemainlistDto)settleListMap.get("mainTable");
		insureListCode = settleMainListDto.getInusrelistcode();
		settleListCode = settleMainListDto.getSettlelistcode();
		riskCode = settleMainListDto.getRiskcode();
		areaCode = settleMainListDto.getFareacode();
		classCode = settleMainListDto.getClasscode();
	}else if("PolicyList".equals(listType)){
		InsuremainlistDto insureMainListDto = (InsuremainlistDto)settleListMap.get("mainTable");
		insureListCode = insureMainListDto.getInusrelistcode();
		riskCode = insureMainListDto.getRiskcode();
		areaCode = insureMainListDto.getFareacode();
		classCode = insureMainListDto.getClasscode();
	}//else throw new Exception("获取保单所关联的保单清单或者理赔清单关联错误！！");
	BLPrpDrisk blPrpDrisk = new BLPrpDrisk();
	String strRiskcode1 = blPrpDrisk.translateCode(riskCode,true);

%>
  <body onLoad="initPage()" >
     <form name="fm" action="/claim/planting3224SettleList.do" method="post" enctype="multipart/form-data">
<table class="common">
		<input type="hidden" name="listType" value="<%=listType %>"/>
		<input type="hidden" name="policyNo" value="<%=policyNo%>"/>
		<input type="hidden" name="dataSource" value="<%=listType%>"/>
		<input type="hidden" name="formInfo" value="settleForm" />
		<input type="hidden" name="PageNum" value="<%=settleListMap.get("currentPageNum")%>"/>
	    <input type="hidden" name="PageCount" value="<%=settleListMap.get("totalPageNum")%>"/>
    	<input type="hidden" name="deleteAll" value=""/>
    	<input type="hidden" name="areaCode" value="<%=areaCode%>"/>
    	<input type="hidden" name="riskCode" value="<%=riskCode%>"/>
    	<input type="hidden" name="classCode" value="<%=classCode%>"/>
    	<input type="hidden" name="kindCode" value="<%=request.getAttribute("kindCode")==null?"":request.getAttribute("kindCode")%>"/>
    	<input type="hidden" name="loadXLS" value="<%=loadXLS%>"/>
    	<input type="hidden" name="editType" value="<%=editType%>"/>
    	<input type="hidden" name="nodeType" value="<%=nodeType==null?"":nodeType%>"/>
    	<input type="hidden" name="realNodeType" value="<%=request.getAttribute("realNodeType")==null?"":request.getAttribute("realNodeType")%>"/>
    	<input type="hidden" name="timeStamp" value="<%=timeStamp==null?"":timeStamp%>"/>
<tr>
 	<td colspan="9" align="center" class="formtitle">理赔清单</td>
</tr>
<tr>
	<td class="title" >保单清单编号:</td>
	<td class="input" > <input type="text" name="insureListCode"   size=36 value="<%=insureListCode%>"  readonly/></td>
	<td class="title" >赔付清单编号:</td>
	<td class="input" ><input type="text" name="settleListCode"   size=36 value="<%=settleListCode%>" readonly/></td>
</tr>
<tr>
	<td class="title" >报案号:</td>
	<td class="input" ><input type="text" name="registNo"   size=36 value="<%=registNo==null?"":registNo%>" readonly/></td>
	<td class="title" >立案号:</td>
	<td class="input"  ><input type="text" name="claimNo"   size=36 value="<%=claimNo==null?"":claimNo%>" readonly/></td>
</tr>
<tr>
	<td class="title" >计算书号:</td>
	<td class="input" ><input type="text" name="compensateNo"   size=36 value="<%=compensateNo==null?"":compensateNo%>" readonly/></td>
	<td class="title" >数据来源:</td>
	<td class="input"  >
	<% if(null==settleListCode ||"".equals(settleListCode)){ %>
		<input type="text" name="dataSourceName"   size=36 value="保单清单" readonly/>
	<% }else{ %>
		<input type="text" name="dataSourceName"   size=36 value="理赔清单<%=null==realNodeTypeName?"":"--"+realNodeTypeName+"环节"%>" readonly/>
	<%} %>
	</td>
</tr>
<tr>
	<td class="title" >投保险种：</td>
	<td class="input" ><input type="text" name="riskCodeName"   size=36 value="<%=strRiskcode1==null?"":strRiskcode1%>"  readonly/></td>
	<td class="title" >当前节点：</td>
	<td class="input" ><input type="text" name="nodeTypeName"   size=36 value="<%=nodeTypeName==null?"":nodeTypeName%>"  readonly/></td>
</tr>  
<tr  align="center">
  <td align="center">
  	<select name="searchType" size="1">
		<option value="0" selected>--请选择--</option>
		<option value="fCode">农户代码</option>
		<option value="ZhiBuKa">银行卡号</option>
		<option value="fName">农户姓名</option>
	</select>
  </td>
  <td class="page" align="center">
     <input type="text" class="common" name="searchInfo" id="searchInfo" value="">
  </td> 
  <td class="page" align="center">
	 <input type="Button" class="button" name="button4" value="查 询" onclick="searchSettleInfo();"/>   
  </td>
</tr>  
</table>
<table id="table1" width="100%" class="common">
 	<tr align=middle>
	  	<td width=2% class="centertitle">
	   		<input type="checkbox" name="checkall" id="checkall" onclick="checkAll(this)"/>全选
	    </td>
	    <td class="centertitle">序号</td>
	    <td class="centertitle">农户代码</td>
	    <td class="centertitle">姓名</td>
	    <td class="centertitle">身份证</td>
	    <td class="centertitle">银行帐号</td>
	    <td class="centertitle">投保面积</td>
	    <td class="centertitle">保额</td>
	    <td class="centertitle">赔付险别代码</td>
	    <td class="centertitle">赔付标的</td>
	    <td class="centertitle">赔付比例%</td>
	    <td class="centertitle">受损面积</td>
	    <td class="centertitle">损失率%</td>
	    <td class="centertitle">赔偿金额</td>
	    <td class="centertitle">备注</td>
     </tr>
     
     <% 
     if("SettleList".equals(listType) && !"loadXLS".equals(loadXLS)){//listTable
     	Collection collectionPlanting31SettleList = (Collection)settleListMap.get("listTable");
     	if(null!=collectionPlanting31SettleList && collectionPlanting31SettleList.size()>0){
     		Iterator it = collectionPlanting31SettleList.iterator();
     		int i=1;
     		while(it.hasNext()){
     			NyxsettlelistDto planting31SettleListDto = (NyxsettlelistDto)it.next();
     %>
     <tr class="listeven">
		<td>
		<input type="checkbox" name="settleIndexes" id="settleIndexes" value="<%=planting31SettleListDto.getIndexofsettle()%>" onclick="cbOnclick(this)"/>
		<input type="hidden" name="settleIndex<%=i%>" value="<%=planting31SettleListDto.getIndexofsettle()%>"/>
		</td>
		<td>
		<%=i %>
		</td>
		<td>
		<%=planting31SettleListDto.getFcode()==null?"&nbsp;":planting31SettleListDto.getFcode() %>
		</td>
		<td>
		<%=planting31SettleListDto.getFname()==null?"&nbsp;":planting31SettleListDto.getFname()%>
		</td>
		<td>
		<%=planting31SettleListDto.getFidcard()==null?"&nbsp;":planting31SettleListDto.getFidcard()%>
		<td>
		<%=planting31SettleListDto.getZhibuka()==null?"&nbsp;":planting31SettleListDto.getZhibuka()%>
		</td>
		<td id="insuredArea<%=i %>">
		<%=planting31SettleListDto.getInsurearea()==0?0:planting31SettleListDto.getInsurearea()%>
		</td>
		<td id="sumInsured<%=i %>">
		<%=planting31SettleListDto.getSuminsured()==0?0:planting31SettleListDto.getSuminsured()%>
		</td>
		</td>
		<td id="kindCode<%=i %>">
		<%=planting31SettleListDto.getKindcode()==null?"&nbsp;":planting31SettleListDto.getKindcode()%>
		</td>
		<td id="itemCode<%=i %>">
			<%=planting31SettleListDto.getItemcode()==null?"&nbsp;":planting31SettleListDto.getItemcode()%>
		</td>
		<td id="claimRate<%=i %>">
		<%=planting31SettleListDto.getClaimrate()==0?0:planting31SettleListDto.getClaimrate()%>
		</td>
		<!-- td id="growingseason<%//=i %>">
		<%//=planting31SettleListDto.getGrowingseason()==0?0:planting31SettleListDto.getGrowingseason()%>
		</td> -->
		<td id="settlearea<%=i %>">
		<%=planting31SettleListDto.getSettlearea()==0?0:planting31SettleListDto.getSettlearea()%>
		</td>
		<td id="lossrate<%=i %>">
		<%=planting31SettleListDto.getLossrate()==0?0:planting31SettleListDto.getLossrate()%>
		</td>
		<td id="settlesum<%=i %>">
		<%=planting31SettleListDto.getSettlesum()==0?0:planting31SettleListDto.getSettlesum()%>
		</td>
		<td id="remark<%=i %>">
		<%=planting31SettleListDto.getRemark()==null?"&nbsp;":planting31SettleListDto.getRemark()%>
		</td>
	</tr>
	<%		i++;
			}
		}
	}else if("PolicyList".equals(listType)){
		Collection collectionPlanting31PolicyList = (Collection)settleListMap.get("listTable");
		if(null != collectionPlanting31PolicyList && collectionPlanting31PolicyList.size()>0){
			Iterator it = collectionPlanting31PolicyList.iterator();
			int i = 1;
			while(it.hasNext()){
				NyxpolicylistDto planting31PolicyListDto = (NyxpolicylistDto)it.next();
				//String strRiskcode1 = blPrpDrisk.translateCode(strRiskcode,true);
	 %>
     <tr class="listeven">
		<td>
		<input type="checkbox" name="settleIndexes" id="<%=i%>" value="<%=planting31PolicyListDto.getIndexcode()%>" onclick="cbOnclick(this)"/>
		<input type="hidden" name="settleIndex<%=i%>" value="<%=planting31PolicyListDto.getIndexcode()%>"/>
		</td>
		<td>
		<%=i %><input type="hidden" name="hiddenInfo" id="hiddenInfo" value />
		</td>
		<td>
		<%=planting31PolicyListDto.getFcode()==null?"&nbsp;":planting31PolicyListDto.getFcode() %>
		</td>
		<td>
		<%=planting31PolicyListDto.getFname()==null?"&nbsp;":planting31PolicyListDto.getFname()%>
		</td>
		<td>
		<%=planting31PolicyListDto.getFidcard()==null?"&nbsp;":planting31PolicyListDto.getFidcard()%>
		<td>
		<%=planting31PolicyListDto.getBankcard()==null?"&nbsp;":planting31PolicyListDto.getBankcard()%>
		</td>
		<td id="insuredArea<%=i %>">
		<%=planting31PolicyListDto.getAreanumber()==0?"0":planting31PolicyListDto.getAreanumber()%>
		</td>
		<td id="sumInsured<%=i %>">
		<%=planting31PolicyListDto.getSumamount()==0?"0":planting31PolicyListDto.getSumamount()%>
		</td>
		<td id="kindCode<%=i %>">
		<%=planting31PolicyListDto.getKindcode()==null?"&nbsp;":planting31PolicyListDto.getKindcode()%>
		</td>
		<td id="itemCode<%=i %>">
			<%=planting31PolicyListDto.getItemcode()==null?"&nbsp;":planting31PolicyListDto.getItemcode()%>
		</td>
		<td id="claimRate<%=i %>">
		<%="&nbsp;"%>
		</td>
		<!-- <td id="growingseason<%//=i %>">
		<%//="&nbsp;"%>
		</td> -->
		<td id="settlearea<%=i %>">
		<%="&nbsp;"%>
		</td>
		<td id="lossrate<%=i %>">
		<%="&nbsp;"%>
		</td>
		<td id="settlesum<%=i %>">
		<%="&nbsp;"%>
		</td>
		<td id="remark<%=i %>">
		<%=planting31PolicyListDto.getRemark()==null?"&nbsp;":planting31PolicyListDto.getRemark()%>
		</td>
	</tr>
	<%		i++;
			}
		}
	}else if("loadXLS".equals(loadXLS)){
		//listTable
     	Collection collectionPlanting31SettleListTemp = (Collection)settleListMap.get("listTable");
     	if(null!=collectionPlanting31SettleListTemp && collectionPlanting31SettleListTemp.size()>0){
     		Iterator it = collectionPlanting31SettleListTemp.iterator();
     		int i=1;
     		while(it.hasNext()){
     			NyxsettlelisttempDto planting31SettleListTempDto = (NyxsettlelisttempDto)it.next();
     %>
     <tr class="listeven">
		<td>
		<input type="checkbox" name="settleIndexes" id="settleIndexes" value="<%=planting31SettleListTempDto.getIndexofsettle()%>" onclick="cbOnclick(this)"/>
		<input type="hidden" name="settleIndex<%=i%>" value="<%=planting31SettleListTempDto.getIndexofsettle()%>"/>
		</td>
		<td>
		<%=i %>
		</td>
		<td>
		<%=planting31SettleListTempDto.getFcode()==null?"&nbsp;":planting31SettleListTempDto.getFcode() %>
		</td>
		<td>
		<%=planting31SettleListTempDto.getFname()==null?"&nbsp;":planting31SettleListTempDto.getFname()%>
		</td>
		<td>
		<%=planting31SettleListTempDto.getFidcard()==null?"&nbsp;":planting31SettleListTempDto.getFidcard()%>
		<td>
		<%=planting31SettleListTempDto.getZhibuka()==null?"&nbsp;":planting31SettleListTempDto.getZhibuka()%>
		</td>
		<td id="insuredArea<%=i %>">
		<%=planting31SettleListTempDto.getInsurearea()==0?0:planting31SettleListTempDto.getInsurearea()%>
		</td>
		<td id="sumInsured<%=i %>">
		<%=planting31SettleListTempDto.getSuminsured()==0?0:planting31SettleListTempDto.getSuminsured()%>
		</td>
		</td>
		<td id="kindCode<%=i %>">
		<%=planting31SettleListTempDto.getKindcode()==null?"&nbsp;":planting31SettleListTempDto.getKindcode()%>
		</td>
		<td id="itemCode<%=i %>">
			<%=planting31SettleListTempDto.getItemcode()==null?"&nbsp;":planting31SettleListTempDto.getItemcode()%>
		</td>
		<td id="claimRate<%=i %>">
		<%=planting31SettleListTempDto.getClaimrate()==0?0:planting31SettleListTempDto.getClaimrate()%>
		</td>
		<!-- td id="growingseason<%//=i %>">
		<%//=plantingsettlelistDto.getGrowingseason()==0?0:plantingsettlelistDto.getGrowingseason()%>
		</td> -->
		<td id="settlearea<%=i %>">
		<%=planting31SettleListTempDto.getSettlearea()==0?0:planting31SettleListTempDto.getSettlearea()%>
		</td>
		<td id="lossrate<%=i %>">
		<%=planting31SettleListTempDto.getLossrate()==0?0:planting31SettleListTempDto.getLossrate()%>
		</td>
		<td id="settlesum<%=i %>">
		<%=planting31SettleListTempDto.getSettlesum()==0?0:planting31SettleListTempDto.getSettlesum()%>
		</td>
		<td id="remark<%=i %>">
		<%=planting31SettleListTempDto.getRemark()==null?"&nbsp;":planting31SettleListTempDto.getRemark()%>
		</td>
	</tr>
	<%		i++;
			}
		}
	}
	//else throw new Exception("获取保单所关联的保单清单或者理赔清单关联错误！！");
     %>
     <tr>
        <td class=input colspan=16 align="right">第 <%=currentPageNum%> 页 / 共 <%=totalPageNum%> 页</td>
      </tr>
</table>
    <table class="common" align="top" id=ResultTable>
    <tr><td >&nbsp</td></tr>
        <tr class="common">
		<td align="center"  colspan="1">总投保面积：</td>
		<td align="center" id="totelInsureArea"><%=settleListMap.get("sumInsuredArea")==null?"0":settleListMap.get("sumInsuredArea")%></td>
		<td align="center" colspan="1" >总受损面积：</td>
		<td align="center" id="totelSettleArea" ><%=settleListMap.get("sumSettleArea")==null?"0":settleListMap.get("sumSettleArea")%></td>		
		<td align="center" colspan="1" >总赔付金额：</td>
		<td align="center" id="totelSettleSum" ><%=settleListMap.get("settleSum")==null?"0":settleListMap.get("settleSum")%></td>
	</tr>
    <tr>
        <td align="left" colspan="1">
	    	&nbsp;共<%=settleListMap.get("countRecord")==null?"0":settleListMap.get("countRecord") %>条
	    </td>
<%
  if(currentPageNum>1)
  {
%>
        <td align="center" colspan="1">
          	<a href="#" onclick="gotoPage('First');return false;" name="FirstPage">首页</a>
        </td>
	    <td colspan="1">
	    	<a href="#" onclick="gotoPage('Previous');return false;"  name="PreviousPage">上页</a>
	    </td>
<%
  }
  if(currentPageNum<totalPageNum)
  {
%>
        <td colspan="1">
	    	<a href="#" onclick="gotoPage('Next');return false;"  name="NextPage">下页</a>
	    </td>
        <td align="center" colspan="1">
       		<a href="#" onclick="gotoPage('Final');return false;"  name="FinalPage">末页</a>
        </td>
<%
  }
  if(totalPageNum>1)
  {
%>
        <td align="right" colspan="1">
          	转到<input type='text' name="PersonalPage" value='<%=currentPageNum%>' class='small' onblur="checkPersonal()" >页<a href="javascript:gotoPage('Personal')"><html:img page="/images/bgGo.gif" width="20" height="15" border="0" align="absmiddle"/></a>
        </td>
<%
  }
%>
    </tr>
    
    <tr><td >&nbsp</td></tr>
    <tr><td >&nbsp</td></tr>
   <tr align="center" id="buttonTr">
   	<td ></td>
  	<td >
  		<input type="Button" class="button" name="deleteSelected" value="删除选中" onclick="deleteItems()" style="display:none"/> 
    </td>
    <td >
   		<input type="Button" class="button" name="deleteAllButton" value="删除全部" onclick="deleteAllSettle()" style="display:none"/> 
    </td>
    <td>
		<input type="button" value="导出理赔清单模板" name="exportTemplate" class="bigbutton" onclick="window.target='_blank';window.location='plantingSettleExport3224.do?settleListCode=<%=settleListCode%>&&listType=<%=listType%>&&nodeType=<%=nodeType%>&&insureListCode=<%=insureListCode%>&&riskCode=<%=riskCode%>&&areaCode=<%=areaCode%>&&template=template'; " style="display:none">
	</td>
	<td>
		<input type="button" value="导出理赔清单" name="exportSettleList" class="bigbutton" onclick="window.target='_blank';window.location='plantingSettleExport3224.do?settleListCode=<%=settleListCode%>&&listType=<%=listType%>&&nodeType=<%=nodeType%>&&insureListCode=<%=insureListCode%>&&riskCode=<%=riskCode%>&&areaCode=<%=areaCode%>';"  style="display:none">
    </td>
   	<td ></td>
   </tr>
</table>
   <table >
   	<!-- tr>
	  	<td><span>导入清单险别：</span></td>
	  	<td>
	  		<select name="kindCodeType" size="1">
		    <% 
		    	//List kindCodesList = (List)settleListMap.get("kindCodesList");
		    	//if(null!=kindCodesList && kindCodesList.size()>0){
		    %>
				<option value="0" selected>--请选择--</option>
		    <%		//for(int i=0;i<kindCodesList.size();i++){
		     %>
				<option value="<%//=kindCodesList.get(i) %>"><%//i++;%><%//=kindCodesList.get(i) %></option>
			<%		//}
				//} %>
			</select>
		</td>
   	</tr> -->
    <tr id="fileTr" style="display:none">
    	<td>理赔清单导入：</td>
    	<td><input type="file" name="formFile" id="formFile"/></td>
	    <td>
	  		<input type="button" name="submitFile" value="导入理赔清单" onclick="importSettle()" class="bigbutton">  
	  	</td>
	  	<td >
	   		<input type="Button" class="bigbutton" name="saveSettle" value="保存理赔清单" onclick="save()" style="display:none"/> 
	    </td>
    </tr>
	</table> 
   <br>
   </form>
   
<table  class="common">
<div id="scrlContainer">
    <div id="scrlContent">数据正在处理中，请稍侯！数据正在处理中，请稍侯！数据正在处理中，请稍侯！数据正在处理中，请稍侯！数据正在处理中，请稍侯！ </div>
</div>
</table>
  </body>
</html:html>
