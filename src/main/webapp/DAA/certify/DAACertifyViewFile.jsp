<%--
****************************************************************************
* DESC       ： 单证查看单证图片页面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-07-13
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
**************************************************************************** 
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.ui.control.action.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="com.sinosoft.sysframework.reference.*"%>

<%@ page import="com.sinosoft.sysframework.common.util.StringUtils"%>
<%@ page import="com.sinosoft.claim.bl.facade.BLCertifyImgFacade"%>
<%@ page import="com.sinosoft.claim.bl.facade.BLPrpLclaimFacade" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.PageRecord" %>
<%@ page import="com.sinosoft.claim.ui.control.action.UIRegistAction" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@page import="com.sinosoft.utiall.blsvr.BLPrpDuser"%>
<html:html locale="true">
<head>
  <title>查看单证信息</title>
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <style type="text/css">
  	.desc{
  		position: absolute;
  		width: 300px;
  		heigh: 200px;
  		border-width: 1px;
  		border-style:solid;
  		border-color:#2D8EE1;
  		width: 220px;
  		height: 80px;
  		padding 5 5 5 5;
  		
  	}
  	.area{
  		width: 250px;
  		height: 100px;
  		scroll:auto;
  	}
  	.desctab{
  		background-color:#6C90DA;
  	}
  	#divBar{
  		position: absolute;
  		left:10px;
  		z-index: 300;
  		top:expression(offsetParent.scrollTop+5);
  	}
  </style>
  <SCRIPT LANGUAGE="JavaScript">
  //add by liyanjie 提交单证删除保存
   function submitFormli(){
   		var isCaseFlag = fm.isCaseFlag.value;
   		if(isCaseFlag == "Y"){
   			alert("案件已经结案不能删除图片！");
   			return false;
   		}
   		var count = getElementCount('checkboxSelect');
   		
   		if(count==0){
   			alert("没有符合条件的单证可删除!");
        return false;
      }else if(count==1){
      	if(!fm.checkboxSelect.checked==true){
   			alert("请先选择要删除的单证!");
            return false;
        }
      }else{
				var n = 0;
        for(var i=0;i< fm.checkboxSelect.length;i++){
            if(fm.checkboxSelect[i].checked==true){
                n = n + 1;
            }
        }
        if(n==0){
   			alert("请先选择要删除的单证!");
            return false;
        }
			}
      if(!confirm('确认要删除选择的单证吗？')){ 
         return false;
      } 
                
			fm.action="/claim/processCertifyImg.do?actionType=delete";
            fm.submit();
			return true;
		}
    
    function hand(obj){
      obj.style.cursor="hand";
    }
    
    function big(image) {
		 var old =image.width;
		 var b = 100;
		 old = old + b;
		 if(old>2000) 
		 	old=2000;
		 image.width = old;
	}
	function small(image) {
	  	var old =image.width;
	  	var b = 100;
		old = old - b;
		if(old<50) 
			old=50;
		image.width = old;
	}
	function becomebig(){
	  var images = document.getElementsByName("cerImage");
	  for(var i=0; i<images.length; i++){
	    images[i].style.width = "";
	    big(images[i]);
	  }
	}
	function becomesmall(){
	  var images = document.getElementsByName("cerImage");
	  for(var i=0;i<images.length;i++){
	  	images[i].style.width = "";
	    small(images[i]);
	  }
	}
	function becomeOrigin(){
		var images = document.getElementsByName("cerImage");
	  	for(var i=0;i<images.length;i++){
	    	images[i].style.width = "auto";
	  	}
	  	fm.imageStatus.value="auto";
	}
	function becomeBack(){
	  var images = document.getElementsByName("cerImage");
	  	for(var i=0;i<images.length;i++){
	    	images[i].style.width = 130;
	  	}
	  fm.imageStatus.value="130";
	}
	var tdDesc;
	function modifyDesc(filed,serialNo){
		fm.nowSerialNo.value = serialNo;
		divDesc.style.display = "";
		tdDesc = filed.parentElement.previousSibling.previousSibling;
		var x = filed.offsetLeft - divDesc.offsetWidth;
		var y = filed.offsetTop;
		var parent = filed;
		while(parent.offsetParent){
			parent = parent.offsetParent;
			x += parent.offsetLeft;
			y += parent.offsetTop;
		}
		if(y + divDesc.offsetHeight > document.body.clientHeight){
			y = y - divDesc.offsetHeight;
		}
		divDesc.style.left = x+"px";
		divDesc.style.top  = y+"px";
		fm.newDesc.value = tdDesc.innerText;
		fm.newDesc.focus();
		

	}
	var xmlRequest;
	function submitModify(){
		
		var businessNo  = fm.businessNo.value;
		var nowSerialNo = fm.nowSerialNo.value;
		var newDesc     = fm.newDesc.value;
		var url = "/claim/DAA/certify/DAACertifyUpdateDesc.jsp";
		var param ="?businessNo=" + businessNo + "&nowSerialNo=" + nowSerialNo + "&newDesc=" + newDesc;
		xmlRequest = new ActiveXObject("Msxml2.XMLHTTP");
		xmlRequest.onreadystatechange = processUpdateChange;
	    try {
	        xmlRequest.open("POST", url+param, true);
	        xmlRequest.send(param);
	    }catch (e) {
	        alert(e);
	    }
	    
	}
	function cancelModify(){
		fm.nowSerialNo.value = "";
		fm.newDesc.value = "";
		divDesc.style.display = "none";
	}
	function cancelHerf(){
		return false;
	}
    function processUpdateChange(){
		if(xmlRequest.readyState == 4) { 
			if (xmlRequest.status == 200) {
				var retValue = xmlRequest.responseText;
            	if(retValue == '1'){
            		tdDesc.innerHTML = fm.newDesc.value;
            		divDesc.style.display = "none";
             		alert("修改成功!");
             		
             	}
           	 	else{
            		divDesc.style.display = "none";
             		alert("修改失败!");
            	}
             	
        } 
        else {
            alert("Problem: " + xmlRequest.statusText);
        }
     }
   }

   </SCRIPT>
</head>

 <!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
 <jsp:include page="/common/pub/StaticJavascript.jsp" />

<body class="interface" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="initPage();">
<form name=fm method="post" action="/claim/DAA/certify/DAACertifyViewFile.jsp"> 
<%
  String editType = request.getParameter("editType");  //add by liyanjie 20051103 
  String directType = request.getParameter("directType");
  String display = request.getParameter("display");
  String businessNo = request.getParameter("businessNo");
  String strLossItemName = request.getParameter("itemcode");
  String pageNo = request.getParameter("pageNo");
  String viewFile = request.getParameter("viewFile");
  String rowsPerPage = "15";
  int curPage=0;
  UserDto userDto = (UserDto)session.getAttribute("user");      // add by liyanjie 20051103
  System.err.println(directType.length());
  //照片状态，0为缩略图，1为原始大小
  String imageStatus = request.getParameter("imageStatus");
  if(imageStatus == null || "".equals(imageStatus)){
	  imageStatus = "130";
  }
  
  //控制已结案案件不能删除图片，但可以上传
  String isFirst = request.getParameter("isFirst"); //是否第一次进入查看页面
  if(isFirst == null || "".equals(isFirst)){
	  isFirst = "Y";
  }
  
  String isCaseFlag = request.getParameter("isCaseFlag");
  if(isCaseFlag == null || "".equals(isCaseFlag)){
	  isCaseFlag = "Y";
  }
  if("Y".equals(isFirst)){
	  String strSql = "";
	  BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
	  strSql += "claimNo = '" + businessNo.trim() + "' or registNo ='" + businessNo.trim() + "'";
	  ArrayList prplclaimDtoList = (ArrayList)blPrpLclaimFacade.findByConditions(strSql);
	  PrpLclaimDto prpLclaimDto = null;
	  if(prplclaimDtoList.size() < 1){
		  isCaseFlag = "N";
	  }else{
		  for(int index = 0;index < prplclaimDtoList.size();index++){
			  prpLclaimDto = (PrpLclaimDto)prplclaimDtoList.get(index);
			  String endCaseDate = prpLclaimDto.getEndCaseDate().toString();
			  if("".equals(endCaseDate) || endCaseDate == null){
				  isCaseFlag = "N";
				  break;
			  }
		  }
	  }
	  isFirst = "N";
  }
  
  BLCertifyImgFacade blCertifyImgFacade= new BLCertifyImgFacade();
  java.util.ArrayList prpLCertifyImgList =new  java.util.ArrayList();

//Modify by zhaolu 20060912 start
  String conditions = "";
//optimize(someday)-now only can see.
  if(viewFile == null || "".equals(viewFile)){
	  if (directType.equals("undefined")) {  
			conditions = conditions + "businessno='"+ businessNo.trim() +"' and ValidStatus ='1'" +"and substr(TYPECODE,1,2)='99' and lossitemcode ='99'";
	  	}		
	  else if (directType.length()<=1) {
			conditions = conditions + "businessno='"+ businessNo.trim() +"' and ValidStatus ='1'" +"and substr(TYPECODE,1,2)='0" + directType + "' and lossitemcode ='" +strLossItemName+"'";
	  	}
	  else {  	
	  	conditions = conditions + "businessno='"+ businessNo.trim() +"' and ValidStatus ='1'" +"and substr(TYPECODE,1,2)='" + directType + "' and lossitemcode ='" +strLossItemName+"'";
	  	}
  }else{
	  if (directType.equals("undefined")) {  
		  if("NoDeleteFile".equals(viewFile)){
			conditions = conditions + "businessno='"+ businessNo.trim() +"' and ValidStatus ='1'" +"and substr(TYPECODE,1,2)='99' and lossitemcode ='99'";
		  }else{
			  conditions = conditions + "businessno='"+ businessNo.trim() +"' and ValidStatus ='0'" +"and substr(TYPECODE,1,2)='99' and lossitemcode ='99'";  
		  }
	  	}		
	  else if (directType.length()<=1) {
		  if("NoDeleteFile".equals(viewFile)){
			conditions = conditions + "businessno='"+ businessNo.trim() +"' and ValidStatus ='1'" +"and substr(TYPECODE,1,2)='0" + directType + "' and lossitemcode ='" +strLossItemName+"'";
		  }else{
			  conditions = conditions + "businessno='"+ businessNo.trim() +"' and ValidStatus ='0'" +"and substr(TYPECODE,1,2)='0" + directType + "' and lossitemcode ='" +strLossItemName+"'";  
		  }
	  }
	  else {  	
		  if("NoDeleteFile".equals(viewFile)){
	  		conditions = conditions + "businessno='"+ businessNo.trim() +"' and ValidStatus ='1'" +"and substr(TYPECODE,1,2)='" + directType + "' and lossitemcode ='" +strLossItemName+"'";
		  }else{
			  conditions = conditions + "businessno='"+ businessNo.trim() +"' and ValidStatus ='0'" +"and substr(TYPECODE,1,2)='" + directType + "' and lossitemcode ='" +strLossItemName+"'";  
		  }
	  }
  }
 //Modify by zhaolu 20060912 end
  conditions += " order by SignInDate,serialNo";
  PageRecord  pageRecord =  blCertifyImgFacade.findByQueryConditions(conditions,pageNo,rowsPerPage);
  prpLCertifyImgList = (ArrayList)pageRecord.getResult();
  TurnPageDto turnPageDto= new TurnPageDto();
  turnPageDto.setResultList(prpLCertifyImgList);
  turnPageDto.setPageNo(pageRecord.getPageNo());
  turnPageDto.setRecordPerPage(20);
  turnPageDto.setTotalCount(pageRecord.getCount());
  turnPageDto.setCondition(conditions);
  turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
  request.setAttribute("turnPageDto", turnPageDto);
  curPage=turnPageDto.getPageNo();
  prpLCertifyImgList=(ArrayList)pageRecord.getResult();

%>
  <input type="hidden" name="editType" value="<%=editType%>"/>
  <input type="hidden" name="directType" value="<%=directType%>"/>
  <input type="hidden" name="display" value="<%=display%>"/>
  <input type="hidden" name="businessNo" value="<%=businessNo%>"/>
  <input type="hidden" name="itemcode" value="<%=strLossItemName%>"/>
  <input type="hidden" name="pageNo1" value="<%=(curPage+1)%>"/>
  <input type="hidden" name="imageStatus" value="<%=imageStatus %>" />
  <input type="hidden" name="isFirst" value="<%=isFirst %>"/>
  <input type="hidden" name="isCaseFlag" value="<%=isCaseFlag %>"/>
  <input type="hidden" name="viewFile" value="<%=viewFile %>">
  <div id="divBar">
 	  <input  align="center" type="button" class=button name='originsize' value="原始大小" onclick="javascript:becomeOrigin();">
	  <input  align="center" type="button" class=button name='decsize' value="缩略图" onclick="javascript:becomeBack();">		
      <input type="button" name="buttonSave" class="button" value="确认删除" onclick="return submitFormli()"> 
      <input type="button" name="buttonClose" class="button" value="关 闭" onclick="javascript:window.close()">  
  </div>
  <table  border="0" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" width="100%"> 
    <tr>
    	<td class="subformtitle" style="width:60%" align="center">图片</td>
    	<td class="subformtitle" style="width:20%" align="center">说明</td>
    	<td class="subformtitle" style="width:10%" align="center">上传信息</td>
    	<td class="subformtitle" style="width:10%" align="center">删除</td>     <!-- add by liyanjie 20051103 -->
    </tr>
  <%    
    
    int cnti = 0;
    BLPrpDuser blPrpDuser = new BLPrpDuser();
    if(prpLCertifyImgList!=null){
        PrpLcertifyImgDto prpLcertifyImgDto = null;
     	for(int i=0;i<prpLCertifyImgList.size();i++){
        	prpLcertifyImgDto =(PrpLcertifyImgDto)prpLCertifyImgList.get(i);    
			String strFileName = "";
			String fileExt = "";
			String fileName=prpLcertifyImgDto.getImgFileName();
			String userCode = prpLcertifyImgDto.getCollectorName();
			String userName = blPrpDuser.translateCode(userCode,true);
			
			if (fileName.indexOf('.') > -1) {
    			fileExt = fileName.substring(fileName.lastIndexOf('.'));
			}

      		strFileName = "/claim/uiviewimg?BusinessNo=" + prpLcertifyImgDto.getBusinessNo() + "&SerialNo=" + prpLcertifyImgDto.getSerialNo();
%>
			<tr>  
			<td class="prompt">

<%
  			if (fileExt.equals(".doc")){
%>
  			<img src="/claim/images/word.gif" > <a href="<%=strFileName%>" target="_blank"><%=prpLcertifyImgDto.getUploadFileName() %></a>        
<%                
  			}
  			else{
%>
  				<a  href="/claim/DAA/certify/DAAShowFile.jsp?FileName=<%=strFileName%>">
  					<img name="cerImage" src="<%=strFileName%>" style="width: <%=imageStatus %>">
  				</a>
   
<%			}
%>        
			</td>
			
			<td class="prompt"  style="text-align:left;word-wrap:break-word;word-break:break-all;"><%= prpLcertifyImgDto.getDisplayName() %></td> 
			<td class="prompt" style="text-align:left;">上传人:<%= userName%><br/>上传时间:<%=prpLcertifyImgDto.getSignInDate()%></td> 
			<td class="prompt">
<%
			if(userDto!=null && prpLcertifyImgDto.getCollectorName().trim().equals(userDto.getUserCode()) && (!editType.equals("SHOW"))){
				if("NoDeleteFile".equals(viewFile)){
%>
				<input type=checkbox name=checkboxSelect value="<%=cnti%>">删除
				<input type="hidden" name="certifyImgLossItemCode" value="<%= prpLcertifyImgDto.getLossItemCode() %>">
				<input type="hidden" name="certifyImgSerialNo" value="<%= prpLcertifyImgDto.getSerialNo() %>">
				<a href="#AAA" onclick= "return modifyDesc(this,'<%=prpLcertifyImgDto.getSerialNo()%>');">修改</a>
<%					}else{

%>
						<input type=checkbox name=checkboxSelect value="<%=cnti%>" disabled="disabled">删除
				<input type="hidden" name="certifyImgLossItemCode" value="<%= prpLcertifyImgDto.getLossItemCode() %>">
				<input type="hidden" name="certifyImgSerialNo" value="<%= prpLcertifyImgDto.getSerialNo() %>">
				<a href="#AAA" onclick= "return false;return modifyDesc(this,'<%=prpLcertifyImgDto.getSerialNo()%>');" disabled="disabled">修改</a>
<%
					}
				cnti++;
			}			
%>      	
 			</td>	
 			</tr>
<%  
		}
    }     	
%> 

      <tr>  
        <td colspan=4 class="centertitle"> 
          
        </td> 
      </tr>
      <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
          <tr>
             <bean:define id="pageview" name="turnPageDto"/>
             <%@include file="/common/pub/TurnOverPage.jsp" %>
          </tr>
      </table>
      <div id="divDesc" class="desc" style="display: none">
      	<table cellpadding="0" cellspacing="0" class="desctab">
      		<tr>
      			<td align="center" class = "subformtitle">图片说明</td>
      		</tr>
      		<tr>
      			<td align="center"><textarea name="newDesc" class="area"></textarea></td>
      		</tr>
      		<tr>
      			<td align="center" style="padding-top: 3px;padding-bottom: 3px;">
      				<input type="hidden" name="nowSerialNo"/>
      				<input type="button" value="确定" class= "button" onclick="submitModify()"/>
      				<input type="button" value="取消" class= "button" onclick="cancelModify()"/>
      			</td>
      		</tr>
      	</table>
      </div>
      
 </form>
</body>
</html:html>

