<html:html locale="true">
<head>
  <title>查看单证信息</title>
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
<%
  String strFileName = request.getParameter("FileName"); 
  String intSerialNo = request.getParameter("SerialNo");
  strFileName = strFileName;
  String imageName = "demo";
%>
  <SCRIPT LANGUAGE="JavaScript">
	 function big(imageName,i) {
			    var old =document.all(imageName)[i].width;
			  var b = 100;
				//alert(document.all.imgBtn.style.width);
				 old = old + b;
				 if (old>2000) old=2000;
				 
				// var obj=document.getElementsByName(imageName)
				 document.all(imageName)[i].width = old;
	}
	function small(imageName,i) {
	 var old =document.all(imageName)[i].width;
	
	  var b = 100;
		//alert(document.all.imgBtn.style.width);
		 old = old - b;
		  if (old<50) old=50;
		 document.all(imageName)[i].width = old;
	}
	function becomebig(imagename){
	  var obj = document.getElementsByName(imagename);
	  for(var i=0; i<obj.length; i++){
	    big(imagename,i);
	  }
	}
	function becomesmall(imagename){
	  var obj = document.getElementsByName(imagename);
	  for(var i=0;i<obj.length;i++){
	    small(imagename,i);
	  }
	}
   </SCRIPT>
</head>
<body style="margin-top: 0px;">
<form name=fm method="post" > 
<table  border="0" cellpadding="0" cellspacing="0"  class="common" style="margin-top: 0px;">
<tr><td>
<input  align="center" type="button" class=button name='addsize' value="放大" onclick="javascript:becomebig('<%=imageName%>');">
<input  align="center" type="button" class=button name='decsize' value="缩小" onclick="javascript:becomesmall('<%=imageName%>');">
<input  align="center" type="button" class=button name='addsize' value="返回" onclick="history.back();">
</td>
</tr>
<tr>
<td align="center">
<img name='<%=imageName%>' src="<%=strFileName + "&SerialNo=" + intSerialNo%>" width="1200">
</td>
</tr>

</table>
 </form>
  
</body>
</html:html>

