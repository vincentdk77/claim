<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>单点请求失败</title>
<style type="text/css">
body{text-align:center;}
.div{margin: :0 auto;width:400px;height:100px;border:0px solid;  }
span{display:inline-block;width:100px;height:40px;line-height:40px;text-align:center; float:left;background-color:#00bbff; color: red;}
</style>
<script type="text/javascript">
	function error(){
		var error=doucument.getElementById("error").value;
		alert(error);
		if(window.confirm("确定要重置吗？"))
		  {
		    location.href = location.href;
		    return true;
		  }
		
	}

</script>

</head>
<body > 

<div class="div">
<span name="error" style="text-align: center;" >${datetime}</span>
</div>	
	
</body>
</html>