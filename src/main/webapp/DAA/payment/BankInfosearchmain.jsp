<%@ page language="java" import="java.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
      <link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
 
   

    <title>������Ϣ��ѯ</title>
  </head>
 <body class="interface" >
   <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script  src="/claim/js/WdatePicker.js" ></script>
  <script  type="text/javascript">
    	function submitForm(){
    		  //fm.buttonSubmit.disabled = true;
    		  var provname = fm.provname.value;
    		  var cityname = fm.cityname.value;
    		  var bankclass = fm.bankclass.value;
    		  var bankbranchname = fm.bankbranchname.value;
    		  if((provname==""||provname==null)
    		  &&(cityname==""||cityname==null)
    		  &&(bankclass==""||bankclass==null)
    		  &&(bankbranchname==""||bankbranchname==null)){
    		  	  alert("������¼��һ����ѯ������");
    		  	  return;
    		  }
    		  //fm.target="fraInterface";
    		  fm.target="_self";
    		  fm.action ="BankQueryList.jsp";
    		  fm.submit();//�ύ
    		  return true ;
    		
    	}
    </script>
    <%
    String type=request.getParameter("type");
    String isSF = request.getParameter("isSF");
     %>
  <form name="fm" action=""  method="post"  target ="showlist">
  		<input type="hidden" name="prevPageUrl" id="prevPageUrl"  value="${prevPageUrl }">
  		<input type="hidden" name="ExcelFlag" value=0 description="������־��1��ʾ����">
  		<input type="hidden" name="isAllFlag" value=0 description="�Ƿ�ȫ������">
  		<input type="hidden" name="isSF" value=<%=isSF %> description="�Ƿ�Ϊ����ϵͳ����">
   		<table  cellpadding="0"  cellspacing="0" border="1" bordercolor="#3A81C8" class="mycommon common">
   			<tr>
			<td colspan=4 class="tabletitle" ondblclick="showPage(RegistExtImg,paymain)">
				<IMG id="RegistExtImg" style="CURSOR: hand" onclick="showPage(this,paymain)"
					src="/claim/images/butExpandBlue.gif" name=RegistExtImg> ��ѯ����
			</td>
			</tr>
			<tbody id="paymain" >
	   			<tr>	
	   				<td class="title" style="width:15%;text-align:center">ʡ��</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="provSignID" name="provSign">
	            			<option value="*">*</option>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" name="provname" id="prov" class="input" style="width: 60%">
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">����</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="citySignID" name="citySign">
	            			<option value="*">*</option>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" name="cityname" id="city" style="width: 60%" class="input" >
	   				</td>
	   			</tr>
	   			<tr>	
	   				
	   				<td class="title" style="width:15%;text-align:center">���д���</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="bankclassSignID" name="bankclassSign">
	            			<option value="*">*</option>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" id="bank" name="bankclass" class="input" style="width:60%"/>
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">������</td>
		   			<td class="input" style="width:35%">
		   				<select class=tag style="width: 30%" id="bankbranchSignID" name="bankbranchSign">
	            			<option value="*">*</option>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" id="bankbranch" name="bankbranchname" class="input" style="width:60%"/>
		   			</td>
	   			</tr>
   			</tbody>
   			<tr>
   				<td colspan="4" class="title" style="text-align:center">
   					<input type="hidden" value="<%=type %>" name="type"  >
   					<input type="button" name="buttonSubmit" value="��ѯ" class="bobu" onclick="submitForm()" >
   				</td>
   			</tr>
   		</table>
   	</form>
   	<!-- <iframe name="showlist" src="/claim/DAA/payment/empty.jsp" height="100%" frameborder="0" marginheight="0" marginwidth="0" scrolling="no" width="100%"></iframe> -->
  </body>
</html>
