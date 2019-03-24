<%@ page contentType="text/html; charset=GBK" %>
<%@page import="com.sinosoft.claim.bl.facade.BLCertifyImgFacade"%>
<html>
<head>
<style type="text/css">
	#tabFile tr td{
		padding:0 2 0 2;
		font-size: 12px;
	}
	#tabFile tr th{
		font-size: 12px;
	}
	TR.content{
		background:#F7F7F7;
	}
	TR.title{
		background:#6C90DA;
   		color:#ffffff;
	}
	.image{
		width: 25px;
		height:25px;
		vertical-align: bottom;
		cursor: hand;
		border: 1px;
	}
	.outoWidth{
		width: 100%;
	}
	INPUT.button
	{
	   color: #000000;
		 background-image: url(/claim/images/BgButton.gif);
		 text-align: center;
		 height: 22px;
		 width: 72px;
		 border: none;
	}
	body{
		margin :0 0 0 0;
		padding:0 0 0 0;
		scroll:auto;
		font-size: 12px;
		
	}
</style>
<title>��֤�ϴ�</title>
</head>

<script type="text/javascript">
	function createInputFile(node){
		var input = document.createElement("INPUT");
		input.type = "file";
		node.appendChild(input);
		return input;
	}
	function addFileBatch(){
		for(var i = 0;i < 3;i++){
			addFile();
		}
	}
	function addFile(){
		var index = tabFile.rows.length;
		var row   = tabFile.insertRow();
		var tdNo       = row.insertCell();
		var tdImageType = row.insertCell();
		var tdFileName = row.insertCell();
		var tdFileDesc     = row.insertCell();
		var tdOperator = row.insertCell();
		
		tdNo.innerHTML = index;
		tdNo.setAttribute("align","center");
		tdFileName.innerHTML = '<input type="file" name="uploadFile" class="outoWidth"/>';
		tdFileDesc.innerHTML = '<input type="text" name="fileDesc" style="width:100%"/>';
		tdOperator.innerHTML = '<a href="javascript:deleteFile('+index+');">ɾ��</a>';
		tdOperator.setAttribute("align","center");
		
		var imageTypeList = fm.imageTypeList.value;
		var sel = document.createElement("SELECT");
		sel.name = "imageType";
		sel.className = "outoWidth";
		tdImageType.appendChild(sel);
		var images = imageTypeList.split("|");
		for(var i = 0;i < images.length;i++){
			var tmp = images[i].split("@@");
			if(tmp.length != 2)
				continue;
			var imageCode =  tmp[0];
			var imageName =  tmp[1];
			var opt = new Option(imageName,images[i]);
			opt.title = imageName;
			sel.add(opt);
		}
		row.style.display = "";
		row.className = "content";
	}
	function deleteFile(index){
		tabFile.deleteRow(index);
		var ind = tabFile.rows.length;
		for(var i=index;i<ind;i++){
			tabFile.rows[i].firstChild.innerHTML = i;
			tabFile.rows[i].lastChild.lastChild.href="javascript:deleteFile("+i+")";
		}
	}
	function showFile(obj){

	}
	function initBody(){
		window.moveTo(300,300);
	}
	function checkFile(){
		var files = document.getElementsByName("uploadFile");
		var fileDesc = document.getElementsByName("fileDesc");
		if(files.length < 1){
			return false;
		}
		var classCode = fm.riskCode.value;
		classCode = classCode.substr(0,2);
		if(classCode == "05"){
			if(files.length > 20){
				alert("��Ƭһ���ϴ����ܳ�����ʮ�ţ�");
				return false;
			}
		}
		for(var i = 0;i < files.length;i++){
			if(files[i].value ==""){
				alert("�ϴ��Ĳ���Ϊ��,������ѡ���ļ�!");
				files[i].focus();
				return false;
			}
			var fileName = files[i].value;
			var index = fileName.lastIndexOf(".");
			if(index < 0){
				alert("ֻ���ϴ���չ��Ϊ:jpg,gif,bmp,png ���ļ�!");
				files[i].focus();
				return false;
			}
			var ext = fileName.substring(index+1);
			ext = ext.toUpperCase();
			if(ext != "JPG" && ext != "GIF" && ext != "BMP" && ext != "PNG"){
				alert("ֻ���ϴ���չ��Ϊ:jpg,gif,bmp,png ���ļ�!");
				files[i].focus();
				return false;
			}
			if(classCode == "05"){
				if(fileDesc[i].value == null || fileDesc[i].value == ""){
					alert("�ϴ�˵������Ϊ��!");
					fileDesc[i].focus();
					return false;
				}
			}
		}
		fm.btnAdd.disabled= true;
		fm.btnUpload.disabled= true;
		return true;
	}
	function closeWindow(){
		
	}
</script>
<body onload="initBody()" onunload="closeWindow()">
<%
	String businessNo = request.getParameter("businessNo");
	String lossItemCode = request.getParameter("lossItemCode");
	String certiType = request.getParameter("directType");
	BLCertifyImgFacade blCertifyImgFacade = new BLCertifyImgFacade();
%>
<form action="/claim/certifyUpload.do" method="post" enctype="multipart/form-data" name="fm" onsubmit="return checkFile();">
	<input type="hidden" name="count">
	<input type="hidden" name="policyNo" value ="<%=request.getParameter("policyNo")%>">
	<input type="hidden" name="businessNo" value ="<%=request.getParameter("businessNo")%>">
	<input type="hidden" name="riskCode" value ="<%=request.getParameter("riskCode")%>">
	<input type="hidden" name="nodeType" value ="<%=request.getParameter("nodeType")%>">
	<input type="hidden" name="certiType" value ="<%=request.getParameter("directType")%>">
	<input type="hidden" name="lossItemCode" value ="<%=request.getParameter("lossItemCode")%>">
	<input type="hidden" name="lossItemName" value ="<%=request.getParameter("lossItemName")%>">
	<input type="hidden" name="uploadYear" value ="<%=request.getParameter("uploadYear")%>">
	<input type="hidden" name="titleName" value ="<%=request.getParameter("titleName")%>">
	<input type="hidden" name="imageTypeList" value ="<%=request.getParameter("imageTypeList")%>">
	<input type="hidden" name="collectorName" value ="<%=request.getParameter("operatorCode")%>">
	
	
	
	
	<table align="center" width="100%" border="0" id="tabFile" cellspacing="1" cellpadding="1">
		<tr class="title" height="25"><th width="6%">���</th><th width="32%">�嵥����</th><th width="30%">�ļ���</th><th width="25%">˵��</th><th width="7%">����</th></tr>
	</table>
	<table align="center" width="100%" border="0" id="tabHead">
		<tr>
		<td>
			<input type="button" name ="btnAdd" class = "button" value="����ļ�" onclick="addFileBatch()">
			<input type="submit" name ="btnUpload" class="button" value=" �� �� ">
		</td>
		</tr>
	</table>
	<div id="divFile">
	
	</div>
</form>
</body>
</html>
