<%@ page contentType="text/html; charset=GBK" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@page import="java.util.Map" %>
<%@page import="com.gyic.claim.dto.domain.SettlemainlistDto" %>
<%@page import="com.gyic.claim.dto.domain.InsuremainlistDto" %>
<%@page import="com.gyic.claim.dto.domain.PlantingsettlelistDto" %>
<%@page import="com.gyic.claim.dto.domain.PlantingsettlelisttempDto" %>
<%@page import="com.gyic.claim.dto.domain.PlantingpolicylistDto" %>
<%@page import="com.gyic.claim.dto.domain.*" %>
<%@page import="com.sinosoft.sysframework.common.datatype.PageRecord" %>
<%@page import="java.util.Collection" %>
<%@page import="com.sinosoft.nyx.blsvr.BLPlantingPolicyList" %>
<%@page import="com.sinosoft.nyx.schema.PlantingPolicyListSchema" %>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDrisk" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.gyic.claim.utils.PlantingSettleExport"  %>
<%@page import="com.gyic.claim.utils.*"  %>
<%@page import="java.util.Iterator" %>
<%@page import="com.gyic.claim.ui.control.facade.UIClaimGetSettleListFacade" %>
<%@page import="com.gyic.claim.ui.control.facade.UIClaimGetMedicalSettleListFacade" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">

  <head>
    <html:base />
    
    <title>�����嵥ҳ��</title>

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
        alert("û����һҳ�������ԣ�");
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
  		alert("�����嵥���ݲ���ɾ������");
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
		  		fm.action = "/claim/deleteMedicalSettleList.do"
		  		fm.submit();
	  		}else{
	  			alert("������ѡ��һ��������Ϣ��");
	  			return false;
	  		}
  		}else alert("��ǰ�ڵ������嵥������ɾ����");
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
  		alert("�����嵥���ݲ���ɾ������");
  		return false;
  	}else if("SettleList"==dataSource){
  		var nodeType = fm.nodeType.value;
  		var realNodeType = fm.realNodeType.value;
  		if(nodeType==realNodeType){
	  		if(confirm("��ǰ�嵥���������ݽ���ɾ����")){
		  		fm.deleteAll.value = "deleteAll";
		  		fm.action = "/claim/deleteMedicalSettleList.do"
		  		fm.submit();
	  		}else return false;
  		}else alert("��ǰ�ڵ������嵥������ɾ����");
  	}
  }
  function importSettle(){
	var res=checkFileName();
	if (!res)
		return false;
	else{
		document.fm.action="/claim/medicalSettleImport.do?";
		initScroll('scrlContainer', 'scrlContent');
		document.fm.submit();
	}
 }
 function checkFileName(){
	var s=document.getElementById("formFile").value;
	var allowSubmit=true;
	
	if ((s=="")){
		alert("����ѡ��һ���ļ���");
		allowSubmit=false;
	}
	else if((s.substr(s.length-4,4).toLowerCase().match("^.xls|cvs$")==null)){
		alert("��ѡ��Excel�ļ���");
		allowSubmit=false;
		document.getElementById("formFile").focus();
	}
	return allowSubmit;
 }
 function save(){
 	var loadXLS = fm.loadXLS.value;
 	if("loadXLS"!=loadXLS){
 		alert("���ȵ��������嵥����");
 		return false;
 	}
 	else{
 		var saveButton = document.getElementsByName("saveSettle");
 		saveButton[0].style.display="none"; 		
		initScroll('scrlContainer', 'scrlContent');
 		document.fm.action="/claim/medicalSettleSave.do?";
 		document.fm.submit();
 	}
 }
function checkPersonal(){
  if(""==fm.PersonalPage.value||null==fm.PersonalPage.value){
     alert("ҳ������Ϊ�գ���");
  }
}
//decreasing speed for mozilla
//scrlSpeed = (document.all) ? scrlSpeed : Math.max(1, scrlSpeed - 1)
function initScroll(container, object) {
//���������а�ť��
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
	//String areaCode = "";
	String classCode = "";
	String loadXLS = "";
	String editType = "";
	String nodeTypeName = "";
	String realNodeType = "";
	String realNodeTypeName = null;
	String compensateNo = "";
	Map settleListMap = (Map)request.getAttribute("settleListMap");
	String listType = (String)settleListMap.get("listType");
	System.err.println(listType);
	
	registNo = (String)request.getAttribute("registNo");
	claimNo = (String)request.getAttribute("claimNo");
	policyNo = (String)request.getAttribute("policyNo");
	nodeType = (String)request.getAttribute("nodeType");
	realNodeType = (String)request.getAttribute("realNodeType");
	compensateNo = (String)request.getAttribute("compensateNo");
	
	if(null!=nodeType && !"".equals(nodeType)){
		String[] nodeList = com.gyic.claim.ui.control.facade.UIClaimGetMedicalSettleListFacade.nodeList;
		String[] nodeListName = com.gyic.claim.ui.control.facade.UIClaimGetMedicalSettleListFacade.nodeNameList;
		for(int i=0;i<nodeList.length;i++){
			if(nodeList[i].equals(nodeType)){
				nodeTypeName = nodeListName[i];
				break;
			}
		}
	}
	if(null!=realNodeType && !"".equals(realNodeType)){
		String[] nodeList = com.gyic.claim.ui.control.facade.UIClaimGetMedicalSettleListFacade.nodeList;
		String[] nodeListName = com.gyic.claim.ui.control.facade.UIClaimGetMedicalSettleListFacade.nodeNameList;
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
		if(insureListCode == null)
		{
			insureListCode = "";
		}
		settleListCode = settleMainListDto.getSettlelistcode();
		riskCode = settleMainListDto.getRiskcode();
		//areaCode = settleMainListDto.getFareacode();
		classCode = settleMainListDto.getClasscode();
	}
	else if("PolicyList".equals(listType)){
		MedicalInsuremainlistDto insureMainListDto = (MedicalInsuremainlistDto)settleListMap.get("mainTable");
		insureListCode = insureMainListDto.getInusreListCode();
		if(insureListCode == null)
		{
			insureListCode = "";
		}
		riskCode = insureMainListDto.getRiskCode();
		//areaCode = insureMainListDto.getFareacode();
		classCode = insureMainListDto.getClassCode();
	}
	if("NoList".equals(listType))
	{
		riskCode = (String)request.getAttribute("riskCode1");
		//System.err.println(riskCode);
	}
	BLPrpDrisk blPrpDrisk = new BLPrpDrisk();
	String strRiskcode1 = blPrpDrisk.translateCode(riskCode,true);

	//Ϊ�˶Բ�ͬ�����ֶ��ƻ���ͬ���嵥��ʾ������һ�����������ÿһҳ����ʾ��Ϣ��
	//List<String> strTitle = UIClaimGetMedicalSettleListFacade.getTitleListByRisk(riskCode); //�����ʾҳ���嵥��ͷ��Ϣ
	//List<String> strTitleFieldName = UIClaimGetMedicalSettleListFacade.getTitleFieldNameListByRiskPolicyNo(riskCode,policyNo);//����б����ֶζ�Ӧ�����ݿ��ֶ�����û�е��ֶ��ַ���ʹ��STRING����������INT��
	
	//UIClaimGetMedicalSettleListFacade uiClaimGetMedicalSettleListFacade = new UIClaimGetMedicalSettleListFacade();
	//List settleInfoList = uiClaimGetMedicalSettleListFacade.getSettleInfoList(request, loadXLS,  editType, strTitleFieldName);
%>
  <body onLoad="initPage()" >
     <form name="fm" action="/claim/medicalsettleList.do" method="post" enctype="multipart/form-data">
<table class="common">
		<input type="hidden" name="listType" value="<%=listType %>"/>
		<input type="hidden" name="policyNo" value="<%=policyNo%>"/>
		<input type="hidden" name="dataSource" value="<%=listType%>"/>
		<input type="hidden" name="formInfo" value="settleForm" />
		<input type="hidden" name="PageNum" value="<%=settleListMap.get("currentPageNum")%>"/>
	    <input type="hidden" name="PageCount" value="<%=settleListMap.get("totalPageNum")%>"/>
    	<input type="hidden" name="deleteAll" value=""/>
    	<input type="hidden" name="areaCode" value=""/>
    	<input type="hidden" name="riskCode" value="<%=riskCode%>"/>
    	<input type="hidden" name="classCode" value="<%=classCode%>"/>
    	<input type="hidden" name="kindCode" value="<%=request.getAttribute("kindCode")==null?"":request.getAttribute("kindCode")%>"/>
    	<input type="hidden" name="loadXLS" value="<%=loadXLS%>"/>
    	<input type="hidden" name="editType" value="<%=editType%>"/>
    	<input type="hidden" name="nodeType" value="<%=nodeType==null?"":nodeType%>"/>
    	<input type="hidden" name="realNodeType" value="<%=request.getAttribute("realNodeType")==null?"":request.getAttribute("realNodeType")%>"/>
    	<input type="hidden" name="timeStamp" value="<%=timeStamp==null?"":timeStamp%>"/>
<tr>
 	<td colspan="9" align="center" class="formtitle">�����嵥</td>
</tr>
<tr>
    <% if(!"2605".equals(riskCode) && !"2606".equals(riskCode)&& !"2609".equals(riskCode) && !"2801".equals(riskCode)){ %>
    <td class="title" >�����嵥���:</td>
	<td class="input" > <input type="text" name="insureListCode"   size=36 value="<%=insureListCode%>"  readonly/></td>
	<%} %>
	<td class="title" >�⸶�嵥���:</td>
	<td class="input" ><input type="text" name="settleListCode"   size=36 value="<%=settleListCode%>" readonly/></td>
</tr>
<tr>
	<td class="title" >������:</td>
	<td class="input" ><input type="text" name="registNo"   size=36 value="<%=registNo==null?"":registNo%>" readonly/></td>
	<td class="title" >������:</td>
	<td class="input"  ><input type="text" name="claimNo"   size=36 value="<%=claimNo==null?"":claimNo%>" readonly/></td>
</tr>
<tr>
	<td class="title" >�������:</td>
	<td class="input" ><input type="text" name="compensateNo"   size=36 value="<%=compensateNo==null?"":compensateNo%>" readonly/></td>
	<td class="title" >������Դ:</td>
	<td class="input"  >
	
	<% if(null==settleListCode ||"".equals(settleListCode)){ %>
		<input type="text" name="dataSourceName"   size=36 value="" readonly/>
	<% }else{ %>
		<input type="text" name="dataSourceName"   size=36 value="�����嵥<%=null==realNodeTypeName?"":"--"+realNodeTypeName+"����"%>" readonly/>
	<%} %>
	</td>
</tr>
<tr>
	<td class="title" >Ͷ�����֣�</td>
	<td class="input" ><input type="text" name="riskCodeName"   size=36 value="<%=strRiskcode1==null?"":strRiskcode1%>"  readonly/></td>
	<td class="title" >��ǰ�ڵ㣺</td>
	<td class="input" ><input type="text" name="nodeTypeName"   size=36 value="<%=nodeTypeName==null?"":nodeTypeName%>"  readonly/></td>
</tr>  
<tr  align="center">
  <td align="center">
<select name="searchType" size="1">
		<option value="0" selected>--��ѡ��--</option>
		<% if("2607".equals(riskCode)){ %>
		
		<option value="idcard">���֤��</option>
		<%} else if("2801".equals(riskCode) || "2605".equals(riskCode) || "2606".equals(riskCode)|| "2609".equals(riskCode)){%>
		<option value="medicalcard">ҽ�����</option>
		<%} %>
		
		<option value="creditcard">���п���</option>
		<option value="Name">������������</option>
	</select>
  </td>
  <td class="page" align="center">
     <input type="text" class="common" name="searchInfo" id="searchInfo" value="">
  </td> 
  <td class="page" align="center">
	 <input type="Button" class="button" name="button4" value="�� ѯ" onclick="searchSettleInfo();"/>   
  </td>
</tr>  
</table>
<!-- ��3149��ʼ���嵥ҳ����ʾ�ֶδ�strTitle��strTitleFieldName�л�ȡ��ʵ����ʾЧ���Ķ��ƻ��� -->

<table id="table1" width="100%" class="common">
 	<tr align=middle>
	  	<td width=2% class="centertitle">
	   		<input type="checkbox" name="checkall" id="checkall" onclick="checkAll(this)"/>ȫѡ
	    </td>
	    <td class="centertitle">���</td>
	    <td class="centertitle">��������</td>
	    <td class="centertitle">ҽ�����</td>   
	    <td class="centertitle">���֤</td>
	    <td class="centertitle">��Ʊ���</td>
	    <td class="centertitle">�⸶���</td>
	    <td class="centertitle">����</td>	    
	    <td class="centertitle">������</td>
	    <td class="centertitle">�����ʺ�</td>

     </tr>
     
     <% 
     if("SettleList".equals(listType) && !"loadXLS".equals(loadXLS)){//listTable
     	Collection collectionMedicalSettleList = (Collection)settleListMap.get("listTable");
     	if(null!=collectionMedicalSettleList && collectionMedicalSettleList.size()>0){
     		Iterator it = collectionMedicalSettleList.iterator();
     		int i=1;
     		while(it.hasNext()){
     			MedicalsettlelistDto medicalsettlelistDto = (MedicalsettlelistDto)it.next();

     					
     				
   					
     %>
     <tr class="listeven">
		<td>
		<input type="checkbox" name="settleIndexes" id="settleIndexes" value="<%=medicalsettlelistDto.getIndexofsettle()%>" onclick="cbOnclick(this)"/>
		<input type="hidden" name="settleIndex<%=i%>" value="<%=medicalsettlelistDto.getIndexofsettle()%>"/>
		</td>
		<td>
		<%=i %>
		</td>
		<td>
		<%=medicalsettlelistDto.getName()==null?"&nbsp;":medicalsettlelistDto.getName() %>
		</td>
		<td>
		<%=((medicalsettlelistDto.getMedicalcard()==null)||("�ձ��".equals(medicalsettlelistDto.getMedicalcard())))?"&nbsp;":medicalsettlelistDto.getMedicalcard()%>
		</td>
		<td>
		<%=medicalsettlelistDto.getIdcard()==null?"&nbsp;":medicalsettlelistDto.getIdcard()%>
		</td>
		<td>
		<%=medicalsettlelistDto.getSuminsured()==0?0:medicalsettlelistDto.getSuminsured()%>
		</td>
		<td>
		<%=medicalsettlelistDto.getSettlesum()==0?0:medicalsettlelistDto.getSettlesum()%>
		</td>
		<td>
		<%=medicalsettlelistDto.getMedicalfamily()==null?"&nbsp;":medicalsettlelistDto.getMedicalfamily()%>
		</td>
		<td>
		<%=medicalsettlelistDto.getBank()==null?"&nbsp;":medicalsettlelistDto.getBank()%>
		</td>
		<td>
		<%=medicalsettlelistDto.getCreditcard()==null?"&nbsp;":medicalsettlelistDto.getCreditcard()%>
		</td>

	</tr>
	<%		i++;
			}
		}
     	
	}	else if("PolicyList".equals(listType)){
		Collection collectionMedicalPolicyList = (Collection)settleListMap.get("listTable");
		if(null != collectionMedicalPolicyList && collectionMedicalPolicyList.size()>0){
			Iterator it = collectionMedicalPolicyList.iterator();
			int i = 1;
			while(it.hasNext()){
				MedicalPolicyListDto medicalPolicyListDto = (MedicalPolicyListDto)it.next();
				//String strRiskcode1 = blPrpDrisk.translateCode(strRiskcode,true);
	 %>
     <tr class="listeven">
		<td>
		<input type="checkbox" name="settleIndexes" id="<%=i%>" value="<%=medicalPolicyListDto.getIndexCode()%>" onclick="cbOnclick(this)"/>
		<input type="hidden" name="settleIndex<%=i%>" value="<%=medicalPolicyListDto.getIndexCode()%>"/>
		</td>
		<td>
		<%=i %><input type="hidden" name="hiddenInfo" id="hiddenInfo" value />
		</td>

		<td>
		<%=medicalPolicyListDto.getName()==null?"&nbsp;":medicalPolicyListDto.getName()%>
		</td>
		<td>
		<%=""%>
		<td>
		<%=medicalPolicyListDto.getIdCard()==null?"&nbsp;":medicalPolicyListDto.getIdCard()%>
		</td>
		<td>
		<%=""%>
		</td>
		<td>
		<%=""%>
		</td>
		<td>
		<%=""%>
		</td>
		<td>
		<%=""%>
		</td>
		<td>
		<%=""%>
		</td>
	</tr>
	<%		i++;
			}
		}
		}else if("loadXLS".equals(loadXLS)){
		//listTable
     	Collection collectionMedicalSettleListTemp = (Collection)settleListMap.get("listTable");
     	if(null!=collectionMedicalSettleListTemp && collectionMedicalSettleListTemp.size()>0){
     		Iterator it = collectionMedicalSettleListTemp.iterator();
     		int i=1;
     		while(it.hasNext()){
     			MedicalsettlelisttempDto medicalsettlelistTempDto = (MedicalsettlelisttempDto)it.next();
     %>
     <tr class="listeven">
		<td>
		<input type="checkbox" name="settleIndexes" id="settleIndexes" value="<%=medicalsettlelistTempDto.getIndexofsettle()%>" onclick="cbOnclick(this)"/>
		<input type="hidden" name="settleIndex<%=i%>" value="<%=medicalsettlelistTempDto.getIndexofsettle()%>"/>
		</td>
		<td>
		<%=i %>
		</td>
		<td>
		<%=medicalsettlelistTempDto.getName()==null?"&nbsp;":medicalsettlelistTempDto.getName() %>
		</td>
		<td>
		<%=((medicalsettlelistTempDto.getMedicalcard()==null)||("�ձ��".equals(medicalsettlelistTempDto.getMedicalcard())))?"&nbsp;":medicalsettlelistTempDto.getMedicalcard()%>
		</td>
		<td>
		<%=medicalsettlelistTempDto.getIdcard()==null?"&nbsp;":medicalsettlelistTempDto.getIdcard()%>
		</td>
		<td>
		<%=medicalsettlelistTempDto.getSuminsured()==0?0:medicalsettlelistTempDto.getSuminsured()%>
		</td>
		<td>
		<%=medicalsettlelistTempDto.getSettlesum()==0?0:medicalsettlelistTempDto.getSettlesum()%>
		</td>
		<td>
		<%=medicalsettlelistTempDto.getMedicalfamily()==null?"&nbsp;":medicalsettlelistTempDto.getMedicalfamily()%>
		</td>
		<td>
		<%=medicalsettlelistTempDto.getBank()==null?"&nbsp;":medicalsettlelistTempDto.getBank()%>
		</td>
		<td>
		<%=medicalsettlelistTempDto.getCreditcard()==null?"&nbsp;":medicalsettlelistTempDto.getCreditcard()%>
		</td>

		
	
	

	</tr>
	<%		i++;
			}
		}
	}
	//else throw new Exception("��ȡ�����������ı����嵥���������嵥�������󣡣�");
     %>
     <tr>
        <td class=input colspan=16 align="right">�� <%=currentPageNum%> ҳ / �� <%=totalPageNum%> ҳ</td>
      </tr>
</table>
    <table class="common" align="top" id=ResultTable>
    <tr><td >&nbsp</td></tr>
        <tr class="common">
		<td align="center" colspan="1" >���⸶��</td>
		<td align="center" id="totelSettleSum" ><%=settleListMap.get("settleSum")==null?"0":settleListMap.get("settleSum")%></td>
	</tr>
    <tr>
        <td align="left" colspan="1">
	    	&nbsp;��<%=settleListMap.get("countRecord")==null?"0":settleListMap.get("countRecord") %>��
	    </td>
<%
  if(currentPageNum>1)
  {
%>
        <td align="center" colspan="1">
          	<a href="#" onclick="gotoPage('First');return false;" name="FirstPage">��ҳ</a>
        </td>
	    <td colspan="1">
	    	<a href="#" onclick="gotoPage('Previous');return false;"  name="PreviousPage">��ҳ</a>
	    </td>
<%
  }
  if(currentPageNum<totalPageNum)
  {
%>
        <td colspan="1">
	    	<a href="#" onclick="gotoPage('Next');return false;"  name="NextPage">��ҳ</a>
	    </td>
        <td align="center" colspan="1">
       		<a href="#" onclick="gotoPage('Final');return false;"  name="FinalPage">ĩҳ</a>
        </td>
<%
  }
  if(totalPageNum>1)
  {
%>
        <td align="right" colspan="1">
          	ת��<input type='text' name="PersonalPage" value='<%=currentPageNum%>' class='small' onblur="checkPersonal()" >ҳ<a href="javascript:gotoPage('Personal')"><html:img page="/images/bgGo.gif" width="20" height="15" border="0" align="absmiddle"/></a>
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
  		<input type="Button" class="button" name="deleteSelected" value="ɾ��ѡ��" onclick="deleteItems()" style="display:none"/> 
    </td>
    <td >
   		<input type="Button" class="button" name="deleteAllButton" value="ɾ��ȫ��" onclick="deleteAllSettle()" style="display:none"/> 
    </td>
    <td>
		<input type="button" value="���������嵥ģ��" name="exportTemplate" class="bigbutton" onclick="window.target='_blank';window.location='medicalSettleExport.do?settleListCode=<%=settleListCode%>&&listType=<%=listType%>&&nodeType=<%=nodeType%>&&riskCode=<%=riskCode%>&&template=template&&policyNo=<%=policyNo%>&&claimNo=<%=claimNo%>'; " style="display:none">
	</td>
	<td>
		<input type="button" value="���������嵥" name="exportSettleList" class="bigbutton" onclick="window.target='_blank';window.location='medicalSettleExport.do?settleListCode=<%=settleListCode%>&&listType=<%=listType%>&&nodeType=<%=nodeType%>&&riskCode=<%=riskCode%>&&policyNo=<%=policyNo%>&&claimNo=<%=claimNo%>';"  style="display:none">
    </td>
   	<td ></td>
   </tr>
</table>
   <table >
   	<!-- tr>
	  	<td><span>�����嵥�ձ�</span></td>
	  	<td>
	  		<select name="kindCodeType" size="1">
		    <% 
		    	//List kindCodesList = (List)settleListMap.get("kindCodesList");
		    	//if(null!=kindCodesList && kindCodesList.size()>0){
		    %>
				<option value="0" selected>--��ѡ��--</option>
		    <%		//for(int i=0;i<kindCodesList.size();i++){
		     %>
				<option value="<%//=kindCodesList.get(i) %>"><%//i++;%><%//=kindCodesList.get(i) %></option>
			<%		//}
				//} %>
			</select>
		</td>
   	</tr> -->
    <tr id="fileTr" style="display:none">
    	<td>�����嵥���룺</td>
    	<td><input type="file" name="formFile" id="formFile"/></td>
	    <td>
	  		<input type="button" name="submitFile" value="���������嵥" onclick="importSettle()" class="bigbutton">  
	  	</td>
	  	<td >
	   		<input type="Button" class="bigbutton" name="saveSettle" value="���������嵥" onclick="save()" style="display:none"/> 
	    </td>
    </tr>
	</table> 
   <br>
   </form>
   
<table  class="common">
<div id="scrlContainer">
    <div id="scrlContent">�������ڴ����У����Ժ�������ڴ����У����Ժ�������ڴ����У����Ժ�������ڴ����У����Ժ�������ڴ����У����Ժ </div>
</div>
</table>
  </body>
</html:html>
