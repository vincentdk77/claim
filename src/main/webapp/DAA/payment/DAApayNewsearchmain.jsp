<%@ page language="java" import="java.util.*" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.DateTime" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String doQuery = request.getParameter("doQuery");

String pageConditions = request.getParameter("pageConditions");
String shuldQuery = request.getParameter("shuldQuery");
String prevPageUrl = (String)request.getAttribute("prevPageUrl");
if(prevPageUrl==null||"".equals(prevPageUrl)){
	prevPageUrl = request.getParameter("prevPageUrl");
}
if(prevPageUrl==null||"".equals(prevPageUrl)){
	prevPageUrl = "";
}
String type = request.getParameter("type");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
      <link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
    <title>֧����Ϣ��ѯ</title>
   <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script  src="/claim/js/WdatePicker.js" ></script>
  <script  type="text/javascript">
    	function submitForm(){
    		var registNo=$("#registNoT").val();
    		var policyNo=$("#policyNo").val();
    		var insuredName=$("#insuredName").val();
    		var shuldQuery = $("#shuldQuery").val();
    		var startStr = document.getElementsByName("inputDateStrat")[0].value;
    		var endStr = document.getElementsByName("inputDateEnd")[0].value;
    		
    		if((registNo==null||registNo.trim().length<1)&&(startStr==null||startStr=="")&&(endStr==null||endStr=="")){
    			alert("������������ʱ�䲻��ͬʱΪ�գ�");
    			return false;
    		}else if(registNo==null||registNo.trim().length<1){
    			if(startStr==null||startStr=="") {
        			alert("����ʱ������Ϊ�գ�");
        			return false;
        		}
    			if(endStr==null||endStr=="") {
        			alert("����ʱ��ֹ����Ϊ�գ�");
        			return false;
        		}
    		}
    		if(shuldQuery!='1'){
	    		//if((registNo==null||registNo.trim().length<1)&&(policyNo==null||policyNo.trim().length<1)
	    		//		&&(insuredName==null||insuredName.trim().length<1)){
	    		//	alert("�������롢�������롢�������˱�������¼��һ�ȷ��ѯ");
	    		//	return false;
	    		//}
    		}
    		fm.condition.value="";
    		fm.buttonSubmit.disabled = true;
    		  fm.action ="/claim/paymainRegist.do";
    		  fm.submit();//�ύ
    		  setTimeout('fm.buttonSubmit.disabled=false',1500);
    		  //return true ;
    	}
    	 function requestprevUrl(){
     		var prevPageUrl = document.getElementById('prevPageUrl').value;
     		if(prevPageUrl.length == 0){
 	    		var prevUrl = document.URL;
 	    		document.getElementById('prevPageUrl').value=prevUrl;
     		}
     	}
    	 
    	 function changeOtherMonth(fieldName){
     		if(fieldName=='inputDateStrat'){
     			var startStr = document.getElementsByName(fieldName)[0].value;
     			if(startStr==null||startStr=="") {
     				return ;
     			}
     			var tarr = startStr.split('-');
     			var year = tarr[0];                //��ȡ��ǰ���ڵ���
     			var month = tarr[1];            //��ȡ��ǰ���ڵ���
     			var day = tarr[2];                //��ȡ��ǰ���ڵ���
     			var days = new Date(year,month,0);    
     			days = days.getDate();//��ȡ��ǰ�����е��µ�����
     			var year2 = year;
     			var month2 = parseInt(month,10);
     			var day2 = parseInt(day,10)+7;
     			if(day2<0||day2==0){
     				month2 = parseInt(month2)-1;	
     				var days2 = new Date(year2,month2,0);
         			days2 = days2.getDate();
         			day2 = parseInt(days2)+parseInt(day2);
     			}
     			if(day2>days){
     				month2 = parseInt(month2)+1;
         			day2 = parseInt(day2)-parseInt(days);
     			}
     			if(0<parseInt(day2) && parseInt(day2)<10){
     				day2 = '0'+day2;
     			}
     			if(month2==13) {
     			    year2 = parseInt(year2,10)+1;
     			    month2 = 1;
     			}
     			if(month2<10) {
     			    month2 = '0'+month2;
     			}
     			var endDate = year2+'-'+month2+'-'+day2;
     		    var endStr = document.getElementsByName("inputDateEnd")[0].value;
     			if(endStr==null||endStr==""){
     				return;
     			} 
     			var tarr1 = endStr.split('-');
     			var year1 = tarr1[0];                //��ȡ��ǰ���ڵ���
     			var month1 = tarr1[1];            //��ȡ��ǰ���ڵ���
     			var day1 = tarr1[2];                //��ȡ��ǰ���ڵ���
     			var days1 = new Date(year1,month1,0);    
     			days1 = days1.getDate();//��ȡ��ǰ�����е��µ�����
                        var startDaterel = new Date(year2,month2,day2);
                        var endDateOld = new Date(year1,month1,day1);
                        var startDateNew = new Date(year,month,day);
     		    if(endDateOld>=startDaterel || startDateNew>=endDateOld){
     		    	 document.getElementsByName("inputDateEnd")[0].value=endDate;
     		    }else{
     		    }
     		}else if (fieldName=='inputDateEnd'){
     			var endStr = document.getElementsByName(fieldName)[0].value;
     			if(endStr==null||endStr==""){
     				return ;
     			} 
     			var tarr = endStr.split('-');
     			var year = tarr[0];                //��ȡ��ǰ���ڵ���
     			var month = tarr[1];            //��ȡ��ǰ���ڵ���
     			var day = tarr[2];                //��ȡ��ǰ���ڵ���
     			var days = new Date(year,month,0);    
     			days = days.getDate();//��ȡ��ǰ�����е��µ�����
     			var year2 = year;
     			var month2 = parseInt(month,10);
     			var day2 = parseInt(day,10)-7;
     			if(day2<0||day2==0){
     				month2 = parseInt(month2)-1;
     				if(month2==0){
     					year2 = parseInt(year2,10)-1;
     					month2 = 12;
     					var days21 = new Date(year2,month2,0);
 	        			var days21Count = days21.getDate();
 	        			day2 = parseInt(days21Count)+parseInt(day2);
     				}else{
 	    				var days21 = new Date(year2,month2);
 	        			var days21Count = days21.getDate();
 	        			day2 = parseInt(days21Count)+parseInt(day2);
     				}
     			}
     			if(0<day2 && day2<10){
     				day2 = '0'+day2;
     			}
     			
     			if(month2<10) {
     			    month2 = '0'+month2;
     			}
     			var startDate = year2+'-'+month2+'-'+day2;
     		    var startStr = document.getElementsByName("inputDateStrat")[0].value;
     			if(startStr==null||startStr=="") {
     			   return;
     			}
     		    var tarr2 = startStr.split('-');
     		    var year1 = tarr2[0];                //��ȡ��ǰ���ڵ���
     		    var month1 = tarr2[1];            //��ȡ��ǰ���ڵ���
     		    var day1 = tarr2[2];                //��ȡ��ǰ���ڵ���
     		    
     		    
     		    var endDaterel = new Date(year2,month2,day2);
     		    var startDateOld = new Date(year1,month1,day1);
     		    var endDateNew = new Date(year,month,day);
     		    
     		    if(endDaterel>=startDateOld || endDateNew<=startDateOld){
     		       document.getElementsByName("inputDateStrat")[0].value=startDate;
     		    }else{
     		    }
     		}
     	  
     	  
     	}
    </script>
  </head>
 <body class="interface" onload="requestprevUrl();">
  <form name="fm" action=""  method="post"  target ="showlist">
  		<input type="hidden" name="nodeType" value="apay"/>
  		<input type="hidden" name="condition" value=""/>
  		<input type="hidden" name="shuldQuery" value="<%=shuldQuery%>"/>
  		<input type="hidden" name="prevPageUrl" id="prevPageUrl"  value="<%=prevPageUrl%>">
  		<input type="hidden" name="type" value="<%=type %>">
   		<table  cellpadding="0"  cellspacing="0" border="1" bordercolor="#3A81C8" class="mycommon common">
   			<tr>
			<td colspan=4 class="tabletitle" ondblclick="showPage(RegistExtImg,paymain)">
				<IMG id="RegistExtImg" style="CURSOR: hand" onclick="showPage(this,paymain)"
					src="/claim/images/butExpandBlue.gif" name=RegistExtImg> ��ѯ����
			</td>
			</tr>
			<tbody id="paymain" >
	   			<tr>	
	   				<td class="title" style="width:15%;text-align:center">��������</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="registno" name="registNos">
	           				<option value="=">=</option>
<%--	            			<option value="*">*</option>--%>
	          			</select>
	   					<input type="text" name="registNoT" id="registNoT" class="input" style="width: 60%" >
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">��������</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="policyNos" name="policyNos">
	           				<option value="=">=</option>
<%--	            			<option value="*">*</option>--%>
	          			</select>
	   					<input type="text" name="policyNo" id="policyNo" style="width: 60%" class="input" >
	   				</td>
	   			</tr>
	   			<tr>	
	   				<td class="title" style="width:15%;text-align:center">��������</td>
	   				<td class="input" style="width:35%">
	   					<select class=tag style="width: 30%" id="insuredNames" name="insuredNames">
<%--	            			<option value="*">*</option>--%>
	           				<option value="=">=</option>
	          			</select>
	   					<input type="text" id="insuredName" name="insuredName" class="input" style="width:60%"/>
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">֧������</td>
	   				<td class="input" style="width:35%">
	   					<input type="radio" id="payType" name="payType" value="P3" checked/>�⸶
	   					<input type="radio" id="payType" name="payType" value="P1" />Ԥ��
	   					<input type="radio" id="payType" name="payType" value="P2"/>֧��
	   					<input type="radio" id="payType" name="payType" value="P4"/>�渶
	   				</td>
	   			</tr>
	   			<tr>
	   				<td class="title" style="width:15%;text-align:center">��������</td>
	   				<td class="input" style="width:35%">
	   					<input type="checkbox" id="" name="mechanism" value="mechanism" checked/>������
	   					<input type="checkbox" id="" name="agnet" value="agnet"/>���鿱
	   				</td>
	   				<%
			            String statStartDate = "";
			       		String statEndDate ="";
			       		
			       		//DateTime dateTime = new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY);
			       		//statEndDate = dateTime.toString();
			       		//statStartDate = dateTime.addMonth(-1).toString();
			       
			         %>
	   				<td class="title" style="width:15%;text-align:center">����ʱ��</td>
	   				<td class="input" style="width:35%">
	   					<%
				            String endReportDate = "";
				       		String startReportDate ="";
				       		
				       		DateTime dateTime = new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY);
				       		endReportDate = dateTime.toString();
				       		startReportDate = dateTime.addDay(-7).toString();
				       
				       %>
				
				       <input type=text style="width:40%" id="inputDateStrat" name="inputDateStrat"  class="Wdate"  value="<%=startReportDate %>" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',autoPickDate:true})" onblur="changeOtherMonth('inputDateStrat');" />
				                       ����
				       <input type=text style="width:40%" id="inputDateEnd"  name="inputDateEnd" class="Wdate"  onfocus="WdatePicker()" value="<%=endReportDate %>" onblur="changeOtherMonth('inputDateEnd');" >       	
	   					
	   				</td>
	   			</tr>
	   			<tr>
	   				<td class="title" style="width:15%;text-align:center">�Ƿ�����˻ؼ�¼</td>
	   				<td class="input" style="width:35%">
	   					<input type="radio" name="back" value="1"/>��
	   					<input type="radio" name="back" value="0" checked/>��
	   				</td>
	   				<td colspan="2" class="input">
	   				</td>
	   			</tr>
	   			<!-- <tr>
	   				<td class="input" colspan="4" style="height: 32px;">
	   					
	   					&nbsp; �ϲ�¼�룺����ͬ���б���������������ơ������˺š��İ������ɺϲ�֧����<br>
	   					&nbsp; �������롢�������롢�������˱�������¼��һ�ȷ��ѯ��
	   				</td>
	   			</tr> -->
   			</tbody>
   			<tr>
   				<td colspan="4" class="title" style="text-align:center">
   					<input type="button" name="buttonSubmit" value="��ѯ" class="bobu" onclick="submitForm()" >
   				</td>
   			</tr>
   		</table>
   	</form>
   	<iframe name="showlist" src="/claim/DAA/payment/empty.jsp" height="100%" frameborder="0" marginheight="0" marginwidth="0" scrolling="yes" width="100%"></iframe>
  </body>
  <script type="text/javascript">
  
  	<%  
  	//���ع�����һ�β�ѯ
  	if((shuldQuery!=null&&"1".equals(shuldQuery))||("query".equals(doQuery))){
  	%>
  		fm.condition.value="<%=pageConditions%>";
  		fm.action ="/claim/prplpaynew.do";
	    fm.submit();//�ύ
  	<%	
  	} %>
  
  </script>
</html>
