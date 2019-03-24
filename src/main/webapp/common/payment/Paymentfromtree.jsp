<%@page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLchargeDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLprepayDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLcompensateDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLregistExtDto" %>
<%@page language="java" isELIgnored="false" %>
<%

	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

	ArrayList<PrpLregistExtDto> prpLregistExtDtoList = (ArrayList<PrpLregistExtDto>)request.getAttribute("prpLregistExtDtoList");
	String editType = (String)request.getParameter("editType");
	String node=request.getAttribute("node")+"";
	String businame1="";
	String businame="";
	//��֤
	if(node.equals("certify")){
	    businame1="";
	    businame="";
	//Ԥ��
	}else if(node.equals("prepay")){
	    businame1="Ԥ���";
	    businame="��������";
	//����
	}else if(node.equals("comp")){
	    businame1="�������";
	    businame="��������";
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  	<jsp:include page="/common/pub/StaticJavascript.jsp" />
	<script type="text/javascript">
	function checkList(node,onlySave){
		if($("input[name=registNo_payment]").size()==1){
			alert('�����֧����Ϣ');
			return false;
		}
		var url="/claim/prplpaysave.do?";
		if(onlySave){
			url +="onlySave="+onlySave;//�ݴ�
		}else{
			if(!checkPayment()) 
				return false;
			if(node=='comp'){
				if(!checkpay()){
					return false
				}
			//��Ԥ����ж�
			}else if(node=='prepay'){
				if(!yuPayMent()){
					return false;
				}
			}
			url +="onlySave="+onlySave;//����
			$(".button").disabled = true;
		}
		form2.action= url;
		form2.submit();
	}
	function getNumber(str){
	   var temp=Number(str);
	   if(isNaN(temp)){
	     temp=Number(0);
	   }
	   return temp;
	}	
	function checkpay(){
		var payamounts=$('input[name=payamount]');
		var chargename=$('input[name=prpLchargeChargeName]');
		var bzCharge=$('input[name=prpLchargeChargeAmount]');
		var zfsumPayMap=new HashMap();
		var fysumPayMap=new HashMap();
		var tempMoney=0;
		 for(var i=1;i<payamounts.length;i++){
   	  		var paymenttype=document.all.paymenttype[i].options[document.all.paymenttype[i].selectedIndex].text;
   	  		if(paymenttype=='���'){	
   	  			tempMoney+=getNumber(payamounts[i].value);
   	  		}
   	  		if(zfsumPayMap.containsKey(paymenttype)){
   	  	 		var lastMoney=zfsumPayMap.get(paymenttype)+getNumber(payamounts[i].value);
   	  	 		zfsumPayMap.put(paymenttype,lastMoney);
   	  		}else{
   	  			zfsumPayMap.put(paymenttype,getNumber(payamounts[i].value));
   	  		}
   	     }
   	  	/*********��ҳ��ȡ����************/
   	  	for(var j=1;j<chargename.length;j++){
   	  		fysumPayMap.put(chargename[j].value,getNumber(bzCharge[j].value));
   	  	}
   	  	var fykeys=fysumPayMap.keys();
   	  	for(var j=0;j<fykeys.length;j++){
   	 	if(fysumPayMap.get(fykeys[j])!=zfsumPayMap.get(fykeys[j])){
   	 			alert(fykeys[j]+"��֧����Ϣ�е�"+fykeys[j]+"����ȣ�")
   	 			return false ;
   	 	}
   	  }
   	  	var sumThisPaid= $("input[name=sumThisPaid]").val();
   	  	if(getNumber(tempMoney).toFixed(2)!=getNumber(sumThisPaid).toFixed(2)){
   	  		alert("�������֧����Ϣ�е�������ȣ�");
   	  		return false;
   	  	}
   	  	return true ;
   	  }
	$(function(){initData();})
	$(document).ready(function(){
	<% if("SHOW".equals(editType)){%>
	$("form[name=form2] :input ").attr("disabled","true");
    <%}%>
    })
	</script>
    <title>�����˵�</title>
  </head>
  <body>
   	<form action="" name="form2" method="post">
       	<table width="100%" class="common" border="0">
       	<%
       	if(node!=null&&!node.equals("null")&&node.equals("comp")){
       	    PrpLcompensateDto compDto=(PrpLcompensateDto)request.getAttribute("CompDto");
       	    if(compDto!=null){
       	%>
			<tr>
		    	<td class="title" style="width: 10%">ʵ�������</td>
		    	<td style="width: 10%">
		    		<%=compDto.getSumDutyPaid()-compDto.getSumPrePaid()%>
		    		<input type="hidden" value="<%=compDto.getSumDutyPaid()-compDto.getSumPrePaid()%>" name="prpLcompensateCommeSumDutyPaid">
		    		<input type="hidden" value="<%=compDto.getSumThisPaid()%>" name="sumThisPaid">
		    		<input type="hidden"  id="compensatenotemp" value="<%=compDto.getCompensateNo()%>" name="compensatenotemp">
		    	</td>
		    	<td class="title" style="width:8% ">�����</td>
		    	<td style="width:15%"><%=compDto.getSumDutyPaid() %></td>
		    	<td class="title" style="width:8%">Ԥ����</td>
		    	<td style="width: 10%"><%=compDto.getSumPrePaid() %></td>
		    </tr>
		    <tr>
		    	<td class="title" style="width: 10%">����:</td>
		    	<td colspan="5">
		    		<!-- Ԥ��������û�õ�,������ -->
		    		<input type="hidden" value="0" name="prpLchargeChargeAmount">
		    		<input type="hidden" value="0" name="prpLchargeChargeName">
		    		<%
		    		List chargeList=(List)request.getAttribute("ChargeList");
		    		PrpLchargeDto chargeDto=null;
		    		if(chargeList!=null&&chargeList.size()!=0){
			    		for(int i=0;i<chargeList.size();i++){
			    			chargeDto=(PrpLchargeDto)chargeList.get(i);
			    			out.print(chargeDto.getChargeName()+":"+chargeDto.getChargeAmount()+"&nbsp;&nbsp;");
			    			out.println("<input type='hidden' name='prpLchargeChargeAmount' value='"+chargeDto.getChargeAmount()+"'>");
			    			out.println("<input type='hidden' name='prpLchargeChargeName' value='"+chargeDto.getChargeName()+"'>");
			    		}
		    		}else{
		    			out.print("����");
		    		}
		    		%>
		    	</td>
		    </tr>
       	    <%
       	    }
       	}else if(node!=null&&!node.equals("null")&&node.equals("prepay")){%>
       			<tr>
        	  		<td class="title">Ԥ����:</td>
        	  		<td>
        	  			<%
        	  				List reList=(List)request.getAttribute("prepay_pay_list");
        	  				PrpLprepayDto reDto=null;
        	  				if(reList!=null&&reList.size()!=0){
        	  				    for(int i=0;i<reList.size();i++){
        	  				      	reDto=(PrpLprepayDto)reList.get(i);
        	  				        out.print(""+reDto.getSumPrePaid());
        	  				        out.println("<input type='hidden' id='sumPrePaid' value='"+reDto.getSumPrePaid()+"' name='prpLprepaySumPrePaid'>");
        	  				    }
        	  				}
        	  			%>
        	  		</td>
        	  		
        	  	</tr>
       	<%
       	}
       	%>	
   		</table>
 		<jsp:include page="/common/payment/Paymentadd.jsp" >
			<jsp:param name="businame" value="<%=businame%>"></jsp:param> 
			<jsp:param name="businame1" value="<%=businame1 %>"></jsp:param>
			<jsp:param name="flag" value="<%=node%>"></jsp:param>
		</jsp:include>
		<table width="100%" class="common" border="0"><tr><td class="button">
			<%if(!"SHOW".equals(editType)){ %>
				<%if(request.getAttribute("paymenttypeflag")==null||request.getAttribute("paymenttypeflag").equals("null")){
				    %>
				        <%if(node.equals("certify")){//��֤ʱֻ��������� %>
    	 				 <input type="button" onclick="checkList('<%=node%>',false)" value="����" class="button" >
    	                 <%} else{%>
						 <input type="button" onclick="checkList('<%=node%>',true)" value="�ݴ�" class="button" >
						 <input type="button" onclick="checkList('<%=node%>',false)" value="�ύ" class="button" >
						 <%} %>
				    <%
				}
				%>
			<%} %>
		</td></tr></table>
	</form>
  </body>
</html>
