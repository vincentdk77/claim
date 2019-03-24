<%@page import="com.sinosoft.claim.dto.custom.TurnPageDto"%>
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<% 
response.setContentType("application/x-msdownload");
String WherePart = (String)request.getAttribute("WherePart");
%>
<html>
  <head>
    <title>显示列表</title>
    <meta http-equiv=Content-Type content="text/html; charset=GBK">
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script src="/claim/common/js/showpage.js"></script>
    <jsp:include page="/common/pub/StaticJavascript.jsp" />
    <link rel="stylesheet" type="text/css" href="/claim/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/claim/js/easyui/themes/icon.css">
	<script type="text/javascript" src="/claim/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/claim/js/easyui/jquery.datagrid.js"></script>
  </head>
  <script type="text/javascript" src="/claim/DAA/js/jquery.min.js"></script>
  <script language=javascript>
      function checkIfhaveElect(batchNo,resNo){
    	  $.ajax({
				url:'/claim/checkIfhaveElect.do'
				,data:{'batchNo':batchNo,'resNo':resNo,'queryType':'check'}
				,type:'POST'
				,dataType:"text"
				,contentType: "application/x-www-form-urlencoded; charset=UTF-8"
				,async:false
				,success:function(data){
					var arr  = data.split("#");
					var flag = arr[0];
					if(flag=="false"){		
						ifOK = true;
					}else{
						alert(arr[1]);
						ifOK = false;
					}
				}
				,error:function(){alert('发生错误');}
			});
    	  
    	 if(ifOK){
    		 fmm.action = "/claim/downBankElect.do?queryType=down&batchNo="+batchNo+"&resNo="+resNo;
    		 fmm.submit();
    	 } 
      }
      
  </script>
  
  <body>
    <form name="fm" method="post" action="/claim/bankelect.do">
  	  <input type="hidden" name="pageConditions" id="pageConditions"  value="${turnPageDto.condition}">
  	  <input type="hidden" name="WherePart2" id="WherePart2"  value="${turnPageDto.condition2}">
        <table class="easyui-datagrid" cellpadding="5" cellspacing="1" >
          <thead>
          <tr class="listtitle">
             <th field="code" align="center" class="centertitle" width="30" >序号</th>
             <th field="code1" align="center" class="centertitle" width="180" >交易批次号</th>
             <th field="code2" align="center" class="centertitle" width="80" >记录序号</th>
             <th field="code3" align="center" class="centertitle" width="150" >支付单号</th>
             <th field="code4" align="center" class="centertitle" width="180" >领款人名称</th>
             <th field="code5" align="center" class="centertitle" width="80" >支付金额</th>
             <th field="code6" align="center" class="centertitle" width="100" >银行大类</th>
             <th field="code7" align="center" class="centertitle" width="80" >电子回执单</th>
           </tr>
           </thead>
        <tbody id="paymain" >
		<c:if test="${not empty turnPageDto.resultList }">
	   			<c:forEach items="${turnPageDto.resultList}" var="prplpayDto" varStatus="count">
	    		<tr class="listodd">
	    			<td align="left">
						${count.index+1}
					</td>
					<td align="left">
						${prplpayDto.claimno }
					</td>
					<td>
						${prplpayDto.serialNo2 }
					</td>
			   		<td>
						${prplpayDto.serialno }
					</td>
					<td>
						${prplpayDto.receiverfullname }
					</td>
					<td>
						${prplpayDto.payamount }
					</td>
					<td>
						${prplpayDto.banktype }
					</td>
					<td>
						<input type='button' class="button" value="下载"onclick="checkIfhaveElect('${prplpayDto.claimno }','${prplpayDto.serialNo2 }');">
					</td>
			   	</tr>
	   		    </c:forEach>
	   		    </c:if>
					
		</tbody>
		<tr><td colspan="8"><br></td></tr>

     </table>
     	<% 
		TurnPageDto turnPageDto = (TurnPageDto)request.getAttribute("turnPageDto"); 
		  int curPage = turnPageDto.getPageNo(); 
		%>
		<c:set var="pageview" value="${turnPageDto}"></c:set>
   		 <%@include file="/common/pub/TurnOverPage.jsp" %>
    </form>
    <form name="fmm" method="post" ></form>
  </body>
</html>
