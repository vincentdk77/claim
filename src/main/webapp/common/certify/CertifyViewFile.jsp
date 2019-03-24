
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
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="com.sinosoft.claim.ui.control.action.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@ page import="java.io.*" %>
<%!
private boolean isImageFile(String fileName){
    fileName = fileName.toLowerCase().trim();
    if(fileName.endsWith("jpg") || fileName.endsWith("jpeg") ||
        fileName.endsWith("gif") || fileName.endsWith("bmp")){
        return true;
    }else{
        return false;
    }
}
%>

<html>
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
  </style>
  <script language="javascript">
    function downloadFile(fileURL){
      window.open(fileURL,"downloaFile",'width=10,height=10,top=500,left=380,toolbar=0,location=0,directories=0,menubar=0,scrollbars=0,resizable=0,status=0');
    }
    
  //add by liyanjie 提交单证删除保存
   function submitFormli(){
     if (submitdetePicture()){
      //删除之后，如何再显示呢？？ thinking....先等个2秒再说
     // var secs =2;
     // var wait = secs * 1000;
     // window.setTimeout("Timer()", wait);
     // window.location.reload();
     }
   }
   
   //modify by zhangwei start 2006-10-12
    function submite(a){
      //alert(a);
      fm.action="/claim/DAA/certify/DAAShowFile.jsp#"+a;
      fm.FileName.value = a;
      fm.submit();
    }
    //modify by zhangwei end 2006-10-12
   
   function submitdetePicture(){
      var count = getElementCount('checkboxSelect');
      
      if(count==0){
        alert("无单证数据!");
        return false;
      }else if(count==1){
        if(!fm.checkboxSelect.checked==true){
        alert("请选择要删除的单证!");
            return false;
        }
      }else{
        var n = 0;
        for(var i=0;i<fm.checkboxSelect.length;i++){
            if(fm.checkboxSelect[i].checked==true){
                n = n + 1;
            }
        }
        if(n==0){
        alert("请选择要删除的单证!");
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
     
  
  function big(imageName) {
   var old =document.all(imageName).width;
    var b = 100;
    //alert(document.all.imgBtn.style.width);
     old = old + b;
     if (old>2000) old=2000;
     
    // var obj=document.getElementsByName(imageName)
     document.all(imageName).width = old;
  }
  function small(imageName) {
   var old =document.all(imageName).width;
  
    var b = 100;
    //alert(document.all.imgBtn.style.width);
     old = old - b;
      if (old<50) old=50;
     document.all(imageName).width = old;
  }
  //add by zhangwei 2006-11-15
  function hand(obj){
      obj.style.cursor="hand";
    }
    var tdDesc;
   	function modifyDesc(filed,serialNo){
		fm.nowSerialNo.value = serialNo;
		divDesc.style.display = "";
		tdDesc = filed.parentElement.previousSibling;
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
    
  </script>
</head>

<body  onload="initPage();">
<form name=fm method="post" > 
<%
  String directType = request.getParameter("directType");
  String display = request.getParameter("display");
  String businessNo = request.getParameter("businessNo");
  UICertifyAction uiCertifyAction = new UICertifyAction();
  CertifyDto certifyDto = uiCertifyAction.findByPrimaryKey(businessNo.trim());
  String editType = request.getParameter("editType");  //add by liyanjie 20051103 
  String strFileName = "";   
  UserDto userDto = (UserDto)session.getAttribute("user");      // add by liyanjie 20051103
  String userCode="";
  if (userDto!=null){
  userCode=userDto.getUserCode();
  }
  String[] imgFileName = null;
  String s = "";  //显示标题要用的比较字符串，add by zhangwei 2006-10-13
%>
  <table  border="0" cellpadding="5" cellspacing="1"  class="common" >
    <tr>
      <input type="hidden" name="businessNo" value="<%=businessNo %>">
 
      <td class="subformtitle" style="width:70%" align="center">图片</td>
      <td class="subformtitle" style="width:20%" align="center">说明</td>
      <td class="subformtitle" style="width:10%" align="center">删除</td>     <!-- add by liyanjie 20051103 -->
    </tr>
  <%
    String imageName="";
    int cnti = 0;
    if(certifyDto.getPrpLcertifyImgDtoList()!=null){
      imgFileName = new String[certifyDto.getPrpLcertifyImgDtoList().size()];
      for(int i=0;i<certifyDto.getPrpLcertifyImgDtoList().size();i++){
        PrpLcertifyImgDto prpLcertifyImgDto =(PrpLcertifyImgDto)certifyDto.getPrpLcertifyImgDtoList().get(i);
        imageName = "imgPic"+i;
        
        imgFileName[i] = "/claim/uiviewimg?BusinessNo=" + 
                     prpLcertifyImgDto.getBusinessNo() + 
                     "&SerialNo=" + prpLcertifyImgDto.getSerialNo();
        
        if(display!=null&&display.trim().equals("all")){
          strFileName = "/claim/uiviewimg?BusinessNo=" + 
                     prpLcertifyImgDto.getBusinessNo() + 
                     "&SerialNo=" + prpLcertifyImgDto.getSerialNo();


//分类显示类标题 add by zhangwei start 2006-10-13
            if(!s.equals(prpLcertifyImgDto.getPicName())){ 
  %>
            <tr>
              <td class="prompt" style="width:100%" align="center" colspan=3><%= prpLcertifyImgDto.getPicName() %></td> 
            </tr>
  <%
            s=prpLcertifyImgDto.getPicName();
            }
//分类显示类标题 add by zhangwei end 2006-10-13  
  %>
    <tr>
       <!--submite()增加锚点名称参数 add by zhangwei  start 2006-10-12 -->
       <td><a onclick="submite('<%= imgFileName[i] %>')" onmouseover="hand(this)" target="_blank"><img src="<%=strFileName%>" width="130" height="110"></a></td>
       <!--submite()增加锚点名称参数 add by zhangwei  end 2006-10-12 -->
       <!-- modify by liyanjie add 20051103 begin -->
       <td class="prompt"><%= prpLcertifyImgDto.getDisplayName() %></td> 
      <td class="prompt">
<%        if((prpLcertifyImgDto.getCollectorName().trim().equals(userCode))){
%>
        <input type=checkbox name=checkboxSelect value="<%=cnti%>">删除
        <input type="hidden" name="certifyImgLossItemCode" value="<%= prpLcertifyImgDto.getLossItemCode() %>">
        <input type="hidden" name="certifyImgSerialNo" value="<%= prpLcertifyImgDto.getSerialNo() %>">
        <a href="#" onclick= "return modifyDesc(this,'<%=prpLcertifyImgDto.getSerialNo()%>');">修改</a>
<%          
            cnti++;
          }
          
%>        
      </td> 
      <!-- modify by liyanjie add 20051103 end -->  
    
    </tr>
<%
        }else{
          if(prpLcertifyImgDto.getTypeCode()!=null&&prpLcertifyImgDto.getTypeCode().trim().length()>0
          ){
          strFileName = "/claim/uiviewimg?BusinessNo=" + 
                     prpLcertifyImgDto.getBusinessNo() + 
                     "&SerialNo=" + prpLcertifyImgDto.getSerialNo();

//分类显示类标题 add by zhangwei start 2006-10-13
            if(!s.equals(prpLcertifyImgDto.getPicName())){ 
  %>
            <tr>
              <td class="prompt" style="width:100%" align="center" colspan=3><%= prpLcertifyImgDto.getPicName() %></td> 
            </tr>
  <%
            s=prpLcertifyImgDto.getPicName();
            }
//分类显示类标题 add by zhangwei end 2006-10-13
  %>    
    <tr>
    <td class="prompt">
<%
          String fileExt = "";
          String fileName=prpLcertifyImgDto.getImgFileName();
          if (fileName.indexOf('.') > -1) {
                fileExt = fileName.substring(fileName.lastIndexOf('.'));
          }
          if (fileExt.equals(".doc")){
        %>
        <img src="/claim/images/word.gif" > <a href="<%=strFileName%>" target="_blank"><%=prpLcertifyImgDto.getUploadFileName() %></a>        
        
<%                
          }else{
%>
       <!--submite()增加锚点名称参数 add by zhangwei  start 2006-10-12 -->
       <a onclick="submite('<%= imgFileName[i] %>')" onmouseover="hand(this)" target="_blank"><img src="<%=strFileName%>" width="130" height="110"></a>
       <!--submite()增加锚点名称参数 add by zhangwei  end 2006-10-12 -->
        
  <%        }
%> 
  </td>       
  	  <!-- modify by liyanjie add 20051103 begin -->
         <!--add by lishengjun start 20061013-->
      	 <!--add by lishengjun end 20061013-->
      <td class="prompt"><%= prpLcertifyImgDto.getDisplayName() %></td> 
      <td class="prompt">
		<input type='hidden' name="prpLcertifyImgDisplayName" value="<%= prpLcertifyImgDto.getDisplayName() %>">
        <input type=checkbox name=checkboxSelect value="<%=cnti%>">删除
        <input type="hidden" name="certifyImgLossItemCode" value="<%= prpLcertifyImgDto.getLossItemCode() %>">
        <input type="hidden" name="certifyImgSerialNo" value="<%= prpLcertifyImgDto.getSerialNo() %>">
        <a href="#" onclick= "return modifyDesc(this,'<%=prpLcertifyImgDto.getSerialNo()%>');">修改</a>
<%          
            cnti++;
          
%>        
      </td> 
      <!-- modify by liyanjie add 20051103 end -->  
    </tr>
   <%
          }
        }
      }
    }
   %>
    <input type="hidden" name="FileName" value="">
      <tr>
        <td colspan=3 class="button">
            <!-- add by liyanjie 20051103 start -->
          <input type="button" name="buttonSave" class="button" value="确认删除" onclick="return submitFormli()"> 
          &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
          <!-- add by liyanjie 20051103 end -->
     
          <input type="button" class=button name="buttonClose" value="关 闭" onclick="javascript:window.close()">
        </td>
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

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html>
