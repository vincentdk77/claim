<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.sinosoft.claim.dto.domain.PrplpayDto"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>

	<title>��ѯ���ҳ</title>
	 <jsp:include page="/common/pub/StaticJavascript.jsp" />
	 <link rel="stylesheet" type="text/css" href="/claim/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/claim/js/easyui/themes/icon.css">
	<script type="text/javascript" src="/claim/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/claim/js/easyui/jquery.datagrid.js"></script>
	<script src="/claim/common/js/showpage.js"></script>
	<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
	<script src="/claim/common/js/UILoad.js"></script>
	<script type="text/javascript">
	/**
	* ��������
	*/
	function revoke(paymentNo){
		if(confirm("ȷ�ϳ�������")){
 			//var registNo= document.getElementById("registNo").value;
			//var paymentNo = $(obj).parent().parent().find("input[name='paymentNo']").val();
			$.ajax({
				url:'/claim/paymainRevoke.do'
				,type:'POST'
				,dataType:"text"
				,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
				,data:{'paymentNo':paymentNo}
				,success:function(data){
					if(data=="true"){
						alert('���سɹ���');
						//$(obj).parent().parent().remove();
						//getIndex();
						window.location.reload(); 
					}else{
						alert('����ʧ�ܣ�');
					}
				}
				,error:function(){alert('��������');}
			});	
		}
		
	}
	
	function openFlagDesc(){
    	var vURL = "/claim/DAA/payment/UIThirdPayFlagDetail.jsp";
    	window.open(vURL,"showPayMessage","width=840,height=500,status=yes,menubar=no,location=no,resizable=yes,scrollbars=yes");
    }
	
	function hrevPaymentShow(paymentNo,editType,billFlag){
		var prevPageUrl = $("input[name='prevPageUrl']").val();
		fm.target="_parent";
		x_load.show("����ִ����...");
		if(billFlag=="1"){
			fm.action="/claim/prplpaybill.do?paymentNo="+paymentNo+"&nodeType=apay&editType="+editType+"&prevPageUrl="+prevPageUrl;
			fm.submit();
		}else{
			fm.action="/claim/paymainEdit.do?paymentNo="+paymentNo+"&nodeType=apay&editType="+editType+"&prevPageUrl="+prevPageUrl;
			fm.submit();
		}
	}
	function hrevPaymentBillEdit(billNo,editType,billFlag){
		var prevPageUrl = $("input[name='prevPageUrl']").val();
		fm.target="_parent";
		x_load.show("����ִ����...");
		if(billFlag=="1"){
			fm.action="/claim/compensateList.do?billNo="+billNo+"&nodeType=apay&editType="+editType+"&prevPageUrl="+prevPageUrl;
			fm.submit();
		}
	}
	</script>
</head>
  
  <body>
  <form action="/claim/prplpaysearch.do" name="fm" method="post">
  <input type="hidden" name="prevPageUrl" id="prevPageUrl"  value="${prevPageUrl}">
   		<table class="easyui-datagrid" height="35%" width="95%" cellpadding="5" cellspacing="1">
   			<thead>
	   			<tr>
	   				<th field="code" align="center" class="centertitle" width="30" >���</th>
	   				<th field="code1" align="center" class="centertitle" width="150" >��������</th>
	   				<th field="code2" align="center" class="centertitle" width="130" >��������</th>
	   				<th field="code3" align="center" class="centertitle" width="120" >��������</th>
	   				<th field="code5" align="center" class="centertitle" width="60" >����ʱ��</th>
	   				<th field="code6" align="center" class="centertitle" width="60" >������</th>
	   				<th field="code7" align="center" class="centertitle" width="60" >����״̬</th>
	   				<th field="code10" align="center" class="centertitle" width="80" >֧������</th>
	   				<th field="code8" align="center" class="centertitle" width="120" >�б�����</th>
	   				<th field="code9" align="center" class="centertitle" width="60" >״̬˵��</th>
	   			</tr>
   			</thead>
   			<tbody>
	   			<c:if test="${not empty paymainList }">
	   			<c:forEach items="${paymainList}" var="prplpaymain" varStatus="count">
	    		<tr class="listodd">
	    			<td align="left">
	    				${count.index+1}
						<input type="hidden" id="num" name="num" value="${count.index+1}"/>
					</td>
					
	    			<td align="left">
	    				<c:if test="${prplpaymain.billNoFlag ne '1'}">
		    				<a href="javascript:;" onclick="hrevPaymentShow('${prplpaymain.paymentNo }','SHOW','${ prplpaymain.billFlag}');" >${prplpaymain.registNo }</a>
	    				</c:if>
	    				<c:if test="${prplpaymain.billNoFlag eq '1'}">
		    				<a href="javascript:;" onclick="hrevPaymentBillEdit('${prplpaymain.billNo }','SHOW','${ prplpaymain.billFlag}');" >${prplpaymain.billNo }</a>
	    				</c:if>
	    				<input type="hidden" name="paymentNo" value="${prplpaymain.paymentNo }"/>
	    				<input type="hidden" name="billFlag" value="${prplpaymain.billFlag }">
						<input type="hidden" name="noBillFlag" value="${prplpaymain.noBillFlag }">
			    	</td>
			    	
			    	<td align="left">
			    		${prplpaymain.policyNo}
			    		<input type="hidden" name="policyNo" value="${prplpaymain.policyNo }"/>
			    	</td>
			    	<td align="left">
			    		${prplpaymain.insuredName}
			    		<input type="hidden" name="insuredName" value="${prplpaymain.insuredName }"/>
			    	</td>
			    	
			    	<td align="left">
			   			${prplpaymain.totalInputDate }
			   			<input type="hidden" name="totalInputDate" value="${prplpaymain.totalInputDate }"/>
			   		</td>
			   		<td align="left">
			   		<c:if test="${type eq '4' }">
			   			<fmt:formatNumber pattern='#0.00' value="${prplpaymain.payAmountSub }"/>
			   			<input type="hidden" name="payAmount" value="${prplpaymain.payAmount }"/>
			   		</c:if>
			   		<c:if test="${type ne '4' }">
			   			<fmt:formatNumber pattern='#0.00' value="${prplpaymain.payAmount }"/>
			   			<input type="hidden" name="payAmount" value="${prplpaymain.payAmount }"/>
			   		</c:if>
			   		</td>
			    	<td align="left">
			    		<c:forEach items="${thirdPayFlagMap }" var="thirdPayFlagM">
			    			<c:if test="${thirdPayFlagM.key eq  prplpaymain.thirdPayFlag}">${thirdPayFlagM.value }</c:if>
			    		</c:forEach>
			    		<input type="hidden" name="thirdPayFlag" value="${prplpaymain.thirdPayFlag }"/>
			    	</td>
			   		<td align="left">
			   			<c:forEach items="${realPayWayMap }" var="realPayWayM">
			    			<c:if test="${realPayWayM.key eq  prplpaymain.realPayWay}">${realPayWayM.value }</c:if>
			    		</c:forEach>
			   			<input type="hidden" name="realPayWay" value="${prplpaymain.realPayWay }"/>
			   		</td>
			   		<td align="left">
			   			${prplpaymain.comName }
			   			<input type="hidden" name="comName" value="${prplpaymain.comName }"/>
			   			<input type="hidden" name="comCode" value="${prplpaymain.comCode }"/>
			   		</td>
			   		<td>
			   			<input type="button" value="˵��" class="bobu" onclick="openFlagDesc();"/>
			   		</td>
			   		<c:if test="${type eq '4' }">
			   		<td align="center">
			   			<c:if test="${(prplpaymain.payFlag ne '1' )and(( prplpaymain.vflag eq '4')or( prplpaymain.vflag eq '6') )  }">
						<input type="button" class="bobu"  name="backBtn" value="����" onclick="revoke('${prplpaymain.paymentNo }');"  /> 
						</c:if>

					</td>
			   		</c:if>
			   	</tr>
	   		    </c:forEach>
	   		    </c:if>
	   		</tbody>
	   		<tr><td colspan="9"><br></td></tr>
   		</table>
   		<%
   		PrplpayDto payDto=(PrplpayDto)request.getAttribute("payDto");
   		int curPage =payDto.getTurnPageDto().getPageNo(); 
   		%>
   		 <%@include file="/common/pub/TurnOverPage.jsp" %>
   		</form>
</body>
</html>