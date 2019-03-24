<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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
<script  type="text/javascript">
	var ret = new Array();
	//����ͼ���� dataFrom :������Դ�˴�Ϊ֧������
	function logstore(registNo,dataFrom){
		var url = "/claim/swfFlowBeforeQuery.do?registNo="+registNo+"&dataFrom="+dataFrom+"";
		if(hasSVG()){
			url += "&svgFlag=1";
		}else{
			url += "&svgFlag=0";
		}
		window.open(url);
	}
	function hasSVG(){
  		SVG_NS = 'http://www.w3.org/2000/svg';
		return !!document.createElementNS && !!document.createElementNS(SVG_NS,'svg').createSVGRect;
  	}
	function chooseOne(obj){
		var flag = false;
		var paymentType = $(obj).parent().find("input[name='payrefreason']").val();
		var certiNo = $(obj).val();
		$.ajax({
			url:'/claim/payMergeCheck.do'
			,type:'POST'
			,dataType:"text"
			,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
			,async:false
			,data:{'paymentType':paymentType,'certiNo':certiNo}
			,success:function(data){
				if(data=="true"){
					flag = true;
				}else{
					alert('�ü������Ѿ�����δ֧����ɵ�֧����Ϣ��');
					flag = false;
					//window.close();
				}
			}
			,error:function(){alert('��������');}
		});
		return flag;
	}
	function chooseAll(obj){
		var checkNum = $("input[type=checkbox][name='flag'][checked]").length;
		if(checkNum>0){
			var i=0;
			ret[0] = "true";
			$("input[name='flag']:checkbox").each(function(){
				if($(this).attr("checked")){
					ret[i*8+1]=$(this).val();
					var registNo = $(this).parent().find("input[name='fiscalRegistNo']").val();
					ret[i*8+2] =registNo;
					var compensateNo = $(this).parent().find("input[name='compensateNo']").val();
					ret[i*8+3] =compensateNo;
					var insuredCode = $(this).parent().find("input[name='insuredCode']").val();
					ret[i*8+4] =insuredCode;
					var payName = $(this).parent().find("input[name='payName']").val();
					ret[i*8+5] =payName;
					var identifyNumber = $(this).parent().find("input[name='identifyNumber']").val();
					ret[i*8+6] =identifyNumber;
					var bankAccount = $(this).parent().find("input[name='bankAccount']").val();
					ret[i*8+7] =bankAccount;
					var fiscalpayAmount = $(this).parent().find("input[name='fiscalpayAmount']").val();
					ret[i*8+8] =fiscalpayAmount;
					i++
				}
			});
			window.close();
		}else{
			window.close();
		}
	}
	window.returnValue = ret;
	
</script>
</head>
  
  <body>
  <form action="/claim/paymainFiscalAddQuery.do" name="fm" method="post">
  		<input type="hidden" name="payType" value="${payTypeMain }"/>
  		<input type="hidden" name="paymentType" value="${paymentType }"/>
   		<table class="easyui-datagrid" cellpadding="5" cellspacing="1">
   			<tr ondblclick="showPage(RegistExtImg9,top9)">
				<th field="ddd1" colspan="7" class="formtitle">
					��ѯ���
				</th>
			</tr>
   			<thead>
	   			<tr>
	   				<th field="code" align="center" class="centertitle" width="30" >ѡ��</th>
	   				<th field="code1" align="center" class="centertitle" width="140" >��������</th>
	   				<th field="code2" align="center" class="centertitle" width="160" >�������</th>
	   				<th field="code3" align="center" class="centertitle" width="60" >ũ������</th>
	   				<th field="code4" align="center" class="centertitle" width="60" >ũ������</th>
	   				<th field="code5" align="center" class="centertitle" width="60" >���֤��</th>
	   				<th field="code6" align="center" class="centertitle" width="120" >ũ���˺�</th>
	   				<th field="code7" align="center" class="centertitle" width="120" >�����</th>
	   			</tr>
   			</thead>
   			<tbody>
	   			<c:if test="${not empty claimBillList }">
	   			<c:forEach items="${claimBillList}" var="prpLclaimBillManagerDto" varStatus="status">
	    		<tr>
					<td class="input"  align="center">
						<input type="checkbox"class="readonly" style="text-align:center;width:100%" name="flag" value="${prpLclaimBillManagerDto.registNo }"/>
						<input type="hidden"  class="readonly" style="text-align:center;width:100%" name="fiscalRegistNo" value="${prpLclaimBillManagerDto.registNo }"/>
						<input type="hidden"  class="readonly" style="text-align:center;width:100%" name="compensateNo" value="${prpLclaimBillManagerDto.compensateNo }"/>
						<input type="hidden"  class="readOnly" style="text-align:center;width:100%" name="insuredCode" value="${prpLclaimBillManagerDto.insuredCode }" />
						<input type="hidden"  class="readOnly" style="text-align:center;width:100%" name="payName" value="${prpLclaimBillManagerDto.payName }" />
						<input type="hidden"  class="readOnly" style="text-align:center;width:100%" name="identifyNumber" value="${prpLclaimBillManagerDto.identifyNumber }" />
						<input type="hidden"  class="readOnly" style="text-align:center;width:100%" name="bankAccount" value="${prpLclaimBillManagerDto.bankAccount}" />
						<input type="hidden"  class="readOnly" style="text-align:center;width:100%" name="fiscalpayAmount" value="${prpLclaimBillManagerDto.payAmount }" />
					</td>
					<td align="left">
	    				${prpLclaimBillManagerDto.registNo }
			    	</td>
					<td class="input"  align="center">
						${prpLclaimBillManagerDto.compensateNo }
					</td>
					<td  class="input"  align="center">
						${prpLclaimBillManagerDto.insuredCode }
					</td>
					<td  class="input"  align="center">
						${prpLclaimBillManagerDto.payName }
					</td>
					<td  class="input"  align="center">
						${prpLclaimBillManagerDto.identifyNumber }
					</td>
					<td  class="input"  align="center">
						${prpLclaimBillManagerDto.bankAccount}
					</td>
					<td  class="input"  align="center">
						${prpLclaimBillManagerDto.payAmount }
					</td>
				</tr>
	   		    </c:forEach>
	   		    </c:if>
	   		</tbody>
   		</table>
   		<% 
		TurnPageDto turnPageDto = (TurnPageDto)request.getAttribute("turnPageDto"); 
		  int curPage = turnPageDto.getPageNo(); 
		%>
		<c:set var="pageview" value="${turnPageDto}"></c:set>
   		 <%@include file="/common/pub/TurnOverPage.jsp" %>
	   	<div id="outcontainer" name="submitDiv">
	    	<div >
		        <table align="center" id="buttonTable">
		           <tr style="valign:middle">
		        	 <td id="originButton1">
		        	 	<input type="button" name="btn" class="btn" value="�ر�" onclick="window.close();"/> 
		        	 </td>
		        	 <td id="originButton1">
		        	 	<input type="button" name="btn" class="btn" value="�ϲ�¼��" onclick="chooseAll();"/> 
		        	 </td>
		        	</tr>
		        </table>
	        </div>
	     </div>
   		</form>
</body>
</html>
