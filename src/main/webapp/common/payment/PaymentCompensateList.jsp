<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>
<style type="text/css">
/*--查询/编辑/显示页面中输入域/显示域对应标题的样式--*/
TD.title
{
	FONT-SIZE: 9pt;
	COLOR: #000000;
	height:20px;
	background-color:#D8E3F3;
	TEXT-ALIGN: center;
} 
#content_basic {
    border-width: 1px;
    border-style: solid;
    border-color: #3A81C8;
    background-color: #DFEBF7;
    padding: 8px;
    margin-top: 5px;
}
</style>
<html>
<head>
<title>清单列表</title>
<link href="/claim/css/tabstyle.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
   	 <jsp:include page="/common/pub/StaticJavascript.jsp" />
	 <link rel="stylesheet" type="text/css" href="/claim/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/claim/js/easyui/themes/icon.css">
	<script type="text/javascript" src="/claim/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/claim/js/easyui/jquery.datagrid.js"></script>
	<script src="/claim/common/js/UILoad.js"></script>
	<script type="text/javascript">
		function requestprevUrl(){
     		var prevPageUrl = document.getElementById('prevPageUrl').value;
     		if(prevPageUrl.length == 0){
 	    		var prevUrl = document.URL;
 	    		document.getElementById('prevPageUrl').value=prevUrl;
     		}
     	}
     	function submitData(){
     		var count = getElementCount("CheckTask");
     		var checkSelect = false;
     		if(count==1){
     			if(fm.CheckTask.checked == true){
     				checkSelect = true;
     			}
     		}else if(count>1){
     			for(var i=0;i<count;i++){
     				if(fm.CheckTask[i].checked == true){
     					checkSelect = true;
     				}
     			}
     		}
     		if(!checkSelect){
     			alert("请选择一条数据！");
     			fm.btn.disabled = false;
     			return false;
     		}else{
     			fm.action="/claim/prplpaybill.do";
     			fm.submit();
     		}
     	}
     	function submitBillData(){
     		var count = getElementCount("CheckTask");
     		var selectCount = getElementCount("payKey");
     		var checkSelect = false;
     		if(count==1){
     			if(fm.CheckTask.checked == true){
     				checkSelect = true;
     			}
     		}else if(count>1){
     			for(var i=0;i<count;i++){
     				if(fm.CheckTask[i].checked == true){
     					checkSelect = true;
     				}
     			}
     		}
     		if(selectCount>999){
     			alert("最多只能勾选999条数据！");
     			fm.btn.disabled = false;
     			return false;
     		}
     		if(!checkSelect){
     			alert("请选择一条数据！");
     			fm.btn.disabled = false;
     			return false;
     		}else{
     			fm.action="/claim/compensateList.do?selectBillFlag=1";
     			fm.submit();
     		}
     	}
     	function selectElementKey(field){
     		var index = getElementOrder(field)-1;
     		var count = getElementCount("payName");
     		var payKey = "";
     		if(count==1){
     			payKey = fm.payName.value+"_"+fm.identifyNumber.value;
     			if(fm.CheckTask.checked == true){
     				$(fm.CheckTask).parent().append("<input type='hidden' name='payKey' value='"+payKey+"'>");
     			}else{
     				$(fm.CheckTask).siblings("input[name='payKey']").remove();
     			}
     		}else if(count>1){
     			payKey = fm.payName[index].value+"_"+fm.identifyNumber[index].value;
     			if(fm.CheckTask[index].checked == true){
     				$(fm.CheckTask[index]).parent().append("<input type='hidden' name='payKey' value='"+payKey+"'>");
     			}else{
     				$(fm.CheckTask[index]).siblings("input[name='payKey']").remove();
     			}
     		}
     	}
     	function selectAllElement(obj){
     		var CheckTask = document.getElementsByName('CheckTask');
     		var payName = document.getElementsByName('payName');
     		var identifyNumber = document.getElementsByName('identifyNumber');
     		var payKey = "";
	        for(var i = 0; i < CheckTask.length; i ++){
	            if(obj.checked){
	                CheckTask[i].checked = true;
	                payKey = payName[i].value+"_"+identifyNumber[i].value;
	                $(CheckTask[i]).parent().append("<input type='hidden' name='payKey' value='"+payKey+"'>");
	            }else{
	                CheckTask[i].checked = false;
	                $(CheckTask[i]).siblings("input[name='payKey']").remove();
	            }
	        }
     	}
	</script>
</head>
  <body class="interface" onload="requestprevUrl();x_load.hide();">
  <script type="text/javascript">x_load.show("页面加载中...");</script>
  <form action="/claim/compensateList.do" name="fm" method="post">
  		<input type="hidden" name="payType" value="P3"/>
  		<input type="hidden" name="paymentType" value=""/>
  		<input type="hidden" name="prevPageUrl" id="prevPageUrl"  value="${prevPageUrl}">
  		<input type="hidden" name="pageConditions" id="pageConditions"  value="${pageConditions}">
  		<input type="hidden" name="type" value="${type }">
  		<input type="hidden" name="back" value="${back }">
  		<input type="hidden" name="editType" value="${editType }">
		<input type="hidden" name="Datatype" value="${Datatype }">
		<input type="hidden" name="nodeType" value="${nodeType }">
		<input type="hidden" name="reQVflag" value="${reQVflag }">
		<input type="hidden" name="nodeType" value="${nodeType }">
  		<span style="text-align: left; width: 99%;font-size:12px">
			<img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
				name="RegistExtImg" onclick="showPage(this,baseInfo)">&nbsp;清单列表
		</span>
		 <%
	   		    ArrayList selectList = (ArrayList)request.getAttribute("selectList");
	   		    if(selectList!=null&&selectList.size()>0){
	   		    	for(int i=0;i<selectList.size();i++){
	   		    %>
	   		    <input type="hidden" name="payKey" value="<%=selectList.get(i) %>">
	   		    <%} 
	   		    }%>
   		<table  class="easyui-datagrid" cellpadding="0"  cellspacing="0" border="1"  id="baseInfo">
   			<thead>
	   			<tr>
	   				<c:if test="${type eq '1'}">
	   				<th field="code" align="center" class="centertitle" width="50" >选择</th>
	   				</c:if>
	   				<c:if test="${type eq '5'}">
	   				<th field="code" align="center" class="centertitle" width="50" >选择<input type="checkBox" name="selectAll" onclick="selectAllElement(this)"></th>
	   				</c:if>
	   				<th field="code1" align="center" class="centertitle" width="150" >报案号码</th>
	   				<th field="code2" align="center" class="centertitle" width="150" >保单号码</th>
	   				<th field="code3" align="center" class="centertitle" width="130" >姓名</th>
	   				<th field="code4" align="center" class="centertitle" width="120" >身份证号</th>
	   				<th field="code5" align="center" class="centertitle" width="100" >支付金额</th>
	   				<th field="code6" align="center" class="centertitle" width="100" >待支付剩余金额</th>
	   			</tr>
   			</thead>
   			<tbody id="tab">
	   			<c:if test="${not empty prpLclaimBillManagerList}">
	   			<c:forEach items="${prpLclaimBillManagerList}" var="billManager" varStatus="status">
	    		<tr class="listodd">
	    			<c:if test="${type eq '1'}">
		    			<td align="center">
							<input type="radio" id="registNo" name="CheckTask" value="${status.index }" />
						</td>
					</c:if>
					<c:if test="${type eq '5'}">
		    			<td align="center">
							<input type="checkbox" id="registNo" name="CheckTask" value="${status.index }" <c:if test="${billManager.selectFlag eq '1' }">checked</c:if> onclick="selectElementKey(this)"/>
							<c:if test="${billManager.selectFlag eq '1' }">
							<input type="hidden" name="payKey"  value="${billManager.payName}_${ billManager.identifyNumber}">
							</c:if>
						</td>
					</c:if>
					<td align="center">
	    				${billManager.registNo }
	    				<input type="hidden" name="registNo" value="${billManager.registNo }">
	    				<c:if test="${type eq '1'}">
	    				<input type="hidden" name="compensateNo" value="${billManager.compensateNo }">
	    				</c:if>
			    	</td>
			    	<td align="center">
	    				${billManager.policyNo }
	    				<input type="hidden" name="policyNo" value="${billManager.policyNo }">
			    	</td>
	    			<td align="center">
	    				${billManager.payName }
	    				<input type="hidden" name="payName" value="${billManager.payName }">
			    	</td>
			    	<td align="center">
			    		${billManager.identifyNumber }
			    		<input type="hidden" name="identifyNumber" value="${billManager.identifyNumber }">
			    	</td>
			    	<td align="center">
			    		${billManager.sumPaid }
			    		<input type="hidden" name="sumPaid" value="${billManager.sumPaid }">
			    	</td>
			    	<td align="center">
			    		${billManager.payAmount-billManager.havPaid }
			    		<input type="hidden" name="payAmount" value="${billManager.payAmount-billManager.havPaid }">
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
		           <c:if test="${type eq '1'}">
		        	 <td id="originButton1">
		        	 	<input type="button" name="btn" class="button" value="确定" onclick="buttonTableAddDisabled();submitData();"/> 
		        	 </td>
		           </c:if>
		           <c:if test="${type eq '5'}">
		        	 <td id="originButton1">
		        	 	<input type="button" name="btn" class="button" value="确定" onclick="buttonTableAddDisabled();submitBillData();"/> 
		        	 </td>
		           </c:if>
		        	</tr>
		        </table>
	        </div>
	     </div>
   		</form>
</body>
</html>
