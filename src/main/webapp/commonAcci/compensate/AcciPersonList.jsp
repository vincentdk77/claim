<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
  <head>
    <title>�ͻ���Ϣ��ѯ</title>
	<app:css />
	<%-- ҳ����ʽ  --%>
	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<script type="text/javascript">
  	function selectAll(){
  		if(fm.checkAll.checked){
  			for(var i=1;i<fm.checkBox.length;i++){
  				fm.checkBox[i].checked = true;
  				fm.checkFlag[i].value = "Y";
  			}
  		}else{
  			for(var i=1;i<fm.checkBox.length;i++){
  				fm.checkBox[i].checked = false;
  				fm.checkFlag[i].value = "Y";
  			}
  		}
  	}
  	function queryDanger(){
  		var flag = false;
  		for(var i=0;i<fm.checkBox.length;i++){
  			if(fm.checkBox[i].checked){
  				fm.checkFlag[i].value = "Y";
  				flag = true;
  			}
  		}
  		if(flag){
			fm.submit();
  		}else{
  			alert("������ѡ��һ����������Ϣ��");
  		}
  	}
	</script>
  </head>
  
  <body>
  <form name="fm" action="/claim/queryAcciPerson.do">
  	<table class=common id="AcciPerson" cellpadding="5" cellspacing="1">
  	  <thead>
    	<tr class=listtitle>
    	  <td colspan="5">�ͻ���Ϣ</td>
    	</tr>
    	<tr class=listtitle>
    	  <td align="center" style="width:10%">ѡ��</td>
    	  <td align="center" style="width:10%">���</td>
    	  <td align="center" style="width:30%">����������</td>
    	  <td align="center" style="width:20%">֤������</td>
    	  <td align="center" style="width:30%">֤������</td>
    	</tr>
      </thead>
      <tfoot>
      	<tr>
      	  <td>
	        <input type="hidden" name="checkBox">
	        <input type="hidden" name="checkFlag">
			<input type="hidden" name="sex">
			<input type="hidden" name="Birthday">
			<input type="hidden" name="serialNo">
			<input type="hidden" name="acciName">
	        <input type="hidden" name="identifyType">
	        <input type="hidden" name="identifyNumber">
	        <input type="hidden" name="LossDate" value="${LossDate }">
	        <input type="hidden" name="registNo" value="${registNo }">
	        <input type="hidden" name="editType" value="queryDangerInfo">
	        <input type="hidden" name="AreaFlag" value="${AreaFlag }">
		  </td>
		</tr>
        <logic:notEmpty name="prpLacciPersonDtoList" >
          <logic:iterate id="prpLacciPersonDto" name="prpLacciPersonDtoList">
	        <tr>
	          <td align="center">
	          	<input type="checkbox" name="checkBox">
	          	<input type="hidden" name="checkFlag">
				<input type="hidden" name="Birthday" 
				        value="<bean:write name='prpLacciPersonDto' property='birthday'/>">
				<input type="hidden" name="sex"
						value="<bean:write name='prpLacciPersonDto' property='sex'/>">
	          </td>
	          <td align="center">
				<input name="serialNo" class="readonly" readonly 
						value="<bean:write name='prpLacciPersonDto' property='serialNo'/>">
	          </td>
	          <td align="center">
				<input name="acciName" class="readonly" readonly 
						value="<bean:write name='prpLacciPersonDto' property='acciName'/>">
	          </td>
	          <td align="center">
	          	<input name="identifyType" class="readonly" readonly 
						value="<bean:write name='prpLacciPersonDto' property='identifyType'/>">
			  </td>
	          <td align="center">
	          	<input name="identifyNumber" class="readonly" readonly 
						value="<bean:write name='prpLacciPersonDto' property='identifyNumber'/>">
			  </td>
	        </tr>
	      </logic:iterate>
	    </logic:notEmpty>
	    <tr>
	    <!-- 
	      <td align="center">
	      	<input type="checkbox" name="checkAll" onclick="selectAll();">
	      </td>
	       -->
	      <td>
	      <font color="#ED1B24">ÿ��ֻ��ѡ��һ����������Ϣ���в�ѯ</font>
	      </td>
	      <td colspan="2"></td>
	      <td align="right">
	      	<input type="button" class="button" value="���ղ�ѯ" onclick="queryDanger();">
	      </td>
	    </tr>
      </tfoot>
    </table>
  </form>
  </body>
</html>
