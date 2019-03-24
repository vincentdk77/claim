<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>查询结果页</title>
 <jsp:include page="/common/pub/StaticJavascript.jsp" />
 <link rel="stylesheet" type="text/css" href="/claim/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/claim/js/easyui/themes/icon.css">
<script type="text/javascript" src="/claim/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/claim/js/easyui/jquery.datagrid.js"></script>
<script src="/claim/common/js/showpage.js"></script>
<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
<script  type="text/javascript">
function checkAll()
{
  if(fm.total.checked==false)
  {
    if(fm.certiNo.length==null)
    {
      fm.certiNo.checked = "";
    }
    else
    {
      for(var i=0;i<fm.certiNo.length;i++)
      {
        fm.certiNo[i].checked = "";
      }
    }
  }
  else
  {
    if(fm.certiNo.length==null)
    {
      fm.certiNo.checked = "yes";
    }
    else
    {
      for(var i=0;i<fm.certiNo.length;i++)
      {
        fm.certiNo[i].checked = "yes";
      }
    }
  }
}


	var ret = new Array();
	//流程图链接 dataFrom :数据来源此处为支付环节
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
					alert('该计算书已经存在未支付完成的支付信息！');
					flag = false;
					//window.close();
				}
			}
			,error:function(){alert('发生错误');}
		});
		return flag;
	}
	function chooseAll(obj){
		var checkNum = $("input[type=checkbox][name='certiNo'][checked]").length;
		if(checkNum>0){
			var i=0;
			ret[0] = "true";
			$("input[name='certiNo']:checkbox").each(function(){
				if($(this).attr("checked")){
					ret[i*15+1]=$(this).val();
					var registNo = $(this).parent().find("input[name='registNo']").val();
					ret[i*15+2] =registNo;
					var policyNo = $(this).parent().find("input[name='policyNo']").val();
					ret[i*15+3] =policyNo;
					var claimNo = $(this).parent().find("input[name='claimNo']").val();
					ret[i*15+4] =claimNo;
					var insuredName = $(this).parent().find("input[name='insuredName']").val();
					ret[i*15+5] =insuredName;
					var licenseNo = $(this).parent().find("input[name='licenseNo']").val();
					ret[i*15+6] =licenseNo;
					var sumPaid = $(this).parent().find("input[name='sumPaid']").val();
					ret[i*15+7] =sumPaid;
					var havPaid = $(this).parent().find("input[name='havPaid']").val();
					ret[i*15+8] =havPaid;
					var comCode = $(this).parent().find("input[name='comCode']").val();
					ret[i*15+9] =comCode;
					var comCodeName = $(this).parent().find("input[name='comCodeName']").val();
					ret[i*15+10] =comCodeName;
					var payType = $(this).parent().find("input[name='payType']").val();
					ret[i*15+11] =payType;
					var policyType = $(this).parent().find("input[name='policyType']").val();
					ret[i*15+12] =policyType;
					var payrefreason = $(this).parent().find("input[name='payrefreason']").val();
					ret[i*15+13] =payrefreason;
					var classCode = $(this).parent().find("input[name='classCode']").val();
					ret[i*15+14] =classCode;
					var coinsCode = $(this).parent().find("input[name='coinsCode']").val();
					ret[i*15+15] =coinsCode;
					i++
				}
			});
			window.close();
		}else{
			window.close();
		}
		/**
		ret[0] = "true";
		ret[1] =certiNo;
		var registNo = $(obj).parent().find("input[name='registNo']").val();
		ret[2] =registNo;
		var policyNo = $(obj).parent().find("input[name='policyNo']").val();
		ret[3] =policyNo;
		var claimNo = $(obj).parent().find("input[name='claimNo']").val();
		ret[4] =claimNo;
		var insuredName = $(obj).parent().find("input[name='insuredName']").val();
		ret[5] =insuredName;
		var licenseNo = $(obj).parent().find("input[name='licenseNo']").val();
		ret[6] =licenseNo;
		var sumPaid = $(obj).parent().find("input[name='sumPaid']").val();
		ret[7] =sumPaid;
		var havPaid = $(obj).parent().find("input[name='havPaid']").val();
		ret[8] =havPaid;
		var comCode = $(obj).parent().find("input[name='comCode']").val();
		ret[9] =comCode;
		var comCodeName = $(obj).parent().find("input[name='comCodeName']").val();
		ret[10] =comCodeName;
		var payType = $(obj).parent().find("input[name='payType']").val();
		ret[11] =payType;
		var policyType = $(obj).parent().find("input[name='policyType']").val();
		ret[12] =policyType;
		var payrefreason = $(obj).parent().find("input[name='payrefreason']").val();
		ret[13] =payrefreason;
		*/
		
		//window.close();
	}
	window.returnValue = ret;
</script>
</head>
  
  <body>
  <form action="/claim/paymainMergeAddQuery.do" name="fm" method="post">
  		<input type="hidden" name="payType" value="${payTypeMain }"/>
  		<input type="hidden" name="paymentType" value="${paymentType }"/>
  		<input type="hidden" name="newPayType" value="${newPayType }"/>
  		<input type="hidden" name="registNoTNew" value="${registNoTNew }"/>
   		<table class="easyui-datagrid" cellpadding="5" cellspacing="1">
   			<tr ondblclick="showPage(RegistExtImg9,top9)">
				<th field="ddd1" colspan="7" class="formtitle">
					查询结果
				</th>
			</tr>
   			<thead>
	   			<tr>
	   				<th field="code" align="center" class="centertitle" width="50" >
	   				<input name="total" type="checkbox" value="" onClick="checkAll();">选择
	   				</th>
	   				<th field="code1" align="center" class="centertitle" width="140" >报案号码</th>
	   				<th field="code2" align="center" class="centertitle" width="160" >计算书号</th>
	   				<!-- <th field="code3" align="center" class="centertitle" width="60" >号牌号码</th> -->
	   				<th field="code4" align="center" class="centertitle" width="60" >结案金额</th>
	   				<th field="code7" align="center" class="centertitle" width="60" >赔款类型</th>
	   				<th field="code5" align="center" class="centertitle" width="120" >被保险人</th>
	   				<th field="code6" align="center" class="centertitle" width="120" >承保机构</th>
	   			</tr>
   			</thead>
   			<tbody>
	   			<c:if test="${not empty turnPageDto.resultList }">
	   			<c:forEach items="${turnPageDto.resultList}" var="prplpayShowDto" varStatus="status">
	    		<tr class="listodd">
	    			<td align="left">
						<input type="checkbox" id="certiNo" name="certiNo" value="${prplpayShowDto.certiNo }" />
			    		<input type="hidden" name="registNo" value="${prplpayShowDto.registNo }"/>
			    		<input type="hidden" name="policyNo" value="${prplpayShowDto.policyNo }" />
						<input type="hidden" name="claimNo" value="${prplpayShowDto.claimNo }" />
			    		<input type="hidden" name="insuredName" value="${prplpayShowDto.insuredName }"/>
			    		<input type="hidden" name="licenseNo" value="${prplpayShowDto.licenseNo }"/>
			    		<input type="hidden" name="sumPaid" value="${prplpayShowDto.sumPaid}"/>
			    		<input type="hidden" name="havPaid" value="${prplpayShowDto.havPaid }"/>
			   			<input type="hidden" name="comCode" value="${prplpayShowDto.comCode }"/>
			   			<input type="hidden" name="comCodeName" value="${prplpayShowDto.comCodeName }"/>
			    		<input type="hidden" name="payType" value="${prplpayShowDto.payType }"/>
			    		<input type="hidden" name="policyType" value="${prplpayShowDto.policyType }"/>
			    		<input type="hidden" name="payrefreason" value="${prplpayShowDto.payrefreason }"/>
			    		<input type="hidden" name="classCode" value="${prplpayShowDto.classCode }"/>
			    		<input type="hidden" name="coinsCode" value="${prplpayShowDto.coinsCode }"/>
					</td>
	    			<td align="left">
	    				<!--a href="/claim/paymainAndRigistEdit.do?registNo=${prplpayShowDto.registNo }&payType=${payTypeMain}&dataType=linkOne&editType=ADD&nodeType=apay" target="_parent"-->
	    				<!--/a-->
	    				<!--input type="hidden" name="registNo" value="${prplpayShowDto.registNo }"/-->
			    		<a href="#" onclick="logstore('${prplpayShowDto.registNo }','apay')">${prplpayShowDto.registNo }</a>
			    	</td>
			    	<td align="left">
	    				${prplpayShowDto.certiNo }
			    	</td>
			    	<!--<td align="left">
			    		${prplpayShowDto.licenseNo }
			    	</td>  -->
			    	<td align="left">
			   			<fmt:formatNumber pattern='#.00' value="${prplpayShowDto.sumPaid }"/>
			   		</td>
			   		<td align="left">
			   			${paymentTypeMap[prplpayShowDto.payrefreason ] }
			   		</td>
			    	<td align="left">
			    		${prplpayShowDto.insuredName }
			    	</td>
			   		<td align="left">
			   			${prplpayShowDto.comCodeName }
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
		        	 	<input type="button" name="btn" class="btn" value="关闭" onclick="window.close();"/> 
		        	 </td>
		        	 <td id="originButton1">
		        	 	<input type="button" name="btn" class="btn" value="合并录入" onclick="chooseAll();"/> 
		        	 </td>
		        	</tr>
		        </table>
	        </div>
	     </div>
   		</form>
</body>
</html>
