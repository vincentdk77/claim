<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="com.sinosoft.claim.dto.custom.*" %>
<script type="text/javascript">
	function setContext(obj){
		var context = $(obj).val();
		$("input[name='prpLpayExtContext']:last").val(context);
	}
	/**
	* 提交时更改处理意见
	*/
	function prplregistOption(){
		var submitType = fm.submitType.value;
		if(submitType!=null&&submitType!=""){
			if(submitType=="2"){
				$("input[name='prpLpayExtNotionCode']:last").val("1");
				$("input[name='prpLpayExtNotionName']:last").val("暂存任务");
			}else if(submitType=="4"){
				var vflag = fm.vflag.value;
				if(vflag!=null&&vflag!=""){
					if(vflag=="3"){
						$("input[name='prpLpayExtNotionCode']:last").val("3");
						$("input[name='prpLpayExtNotionName']:last").val("已补充信息");
					}else{
						$("input[name='prpLpayExtNotionCode']:last").val("2");
						$("input[name='prpLpayExtNotionName']:last").val("提交审核");
					}
				}else{
					$("input[name='prpLpayExtNotionCode']:last").val("2");
					$("input[name='prpLpayExtNotionName']:last").val("提交审核");
				}
			}
		}
	}
</script>
<div id="content_basic" style="width: 98%" name="registExtDiv">
	<span style="text-align: left; width: 99%;font-size:12px">
		<img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
			name="RegistExtImg" onclick="showPage(this,registExt)">&nbsp;处理意见
	</span>
	<table class="common" id="registExt" cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8">
		<c:if test="${(editType ne 'SHOW')}" >
		<tr>
	    	<td class="title" style="width:4%" align="center"  >录入说明</td>
    		<td colspan="7" style="width:96%">
       			<c:if test="${editType eq 'EDIT' }">
       			<textarea style="width:100%" name="prpLpayExtNewContext" id="prpLpayExtNewContext" maxlength="1000" onchange="setContext(this);" onkeyup="return checkMaxlength(this);setContext(this);">${prpLpayExtDtoNew.context }</textarea>
       			</c:if>
       			<c:if test="${editType ne 'EDIT' }">
       			<textarea style="width:100%" name="prpLpayExtNewContext"  id="prpLpayExtNewContext" maxlength="1000" onchange="setContext(this);" onkeyup="return checkMaxlength(this);setContext(this);"></textarea>
       			</c:if>
        	</td>
       	</tr>
       	</c:if>
       	<!-- 展示保存在数据库中处理意见信息 -->
	    <tr>
		 	<td class="title" style="width:4%;text-align: center;">序号</td>
		 	<td class="title" style="width:8%;text-align: center;">处理结点</td>
		    <td class="title" style="width:8%;text-align: center;">流出时间</td>
			<td class="title" style="width:8%;text-align: center;">占用时间</td>
		    <td class="title" style="width:8%;text-align: center;">操作人员</td>
		    <td class="title" style="width:10%;text-align: center;">处理机构</td>
		    <td class="title" style="width:10%;text-align: center;">处理意见</td>
		    <td class="title" style="width:44%;text-align: center;">补充说明</td>
		</tr>
		<c:if test="${not empty prpLpayExtDtoList }">
		<c:forEach items="${prpLpayExtDtoList }" var="prpLpayExtDto" varStatus="status">
			<c:if test="${(prpLpayExtDto.flag ne 'N') or (editType eq 'SHOW')}">
			<tr>
				<!-- 序号 -->
				<td class="input" align="center" style="width:4%;">
					<input type="hidden" name="prpLpayExtFlag" value="${prpLpayExtDto.flag }"  />
					<input type="hidden" name="prpLpayExtSerialNo" value="${prpLpayExtDto.serialNo }"  />
					<input type="text" class="readonly" style="text-align:center;width:100%" name="prpLpayExtRowNum" value="${status.count }" />
				</td>
				<!-- 处理结点 -->
				<td  class="input"  align="center" style="width:8%;">
					<input type="hidden"  style="text-align:center;width:99%" name="prpLpayExtNodeType" value="${prpLpayExtDto.nodeType }" class="readonly" readonly />
					<input type="text"  style="text-align:center;width:99%" name="prpLpayExtNodeName" value="${prpLpayExtDto.nodeName}" class="readonly" readonly />
		      	</td>
		      	<!-- 流出时间 -->
		      	<td class="input"  align="center" style="width:8%;">
		      		<input type="hidden"  style="text-align:center;width:99%" name="prpLpayExtInputDate" value="${prpLpayExtDto.inputDate }" class="readonly" readonly />
		      		${prpLpayExtDto.inputDate }
		     	</td>
	     		<!-- 占用时间 -->
	     		<td class="input"  align="center" style="width:8%;">
		     		<input type="text"  style="text-align:center;width:99%" name="prpLpayExtCostTime" value="${prpLpayExtDto.costTime}" class="readonly" readonly />
		     	</td>
	     		<!-- 操作人员 -->
	     		<td class="input"  align="center" style="width:8%;">
	     			<input type="hidden"  style="text-align:center;width:99%" name="prpLpayExtOperatorCode" value="${prpLpayExtDto.operatorCode }" class="readonly" readonly />
	     			<input type="text"  style="text-align:center;width:99%" name="prpLpayExtOperatorCodeName" value="${prpLpayExtDto.operatorCodeName }" class="readonly" readonly />
		     	</td>
	     		<!-- 处理机构 -->
	     		<td class="input" align="center" style="width:10%;">
	<!--	     			<%--=new UICodeAction().translateComCode("3400000000",true)--%>-->
					<input type="text" class="readonly" style="text-align:center;width:100%" name="prpLpayExtComCName" value="${prpLpayExtDto.comCName}" />
					<input type="hidden" style="text-align:center;width:100%" name="prpLpayExtComCode" value="${prpLpayExtDto.comCode }" />
	     		</td>
	     		<!-- 处理意见 -->
	     		<td class="input"  align="center" style="width:10%;">
	     			<input type="hidden" class="readonly" style="text-align:center;width:100%" name="prpLpayExtNotionCode" value="${prpLpayExtDto.notionCode }" />
	     			<input type="text" class="readonly" style="text-align:center;width:100%" name="prpLpayExtNotionName" value="${prpLpayExtDto.notionName }" />
	     		</td>
	     		<!-- 补充说明 -->
	     		<td class="input" style="width:44%;"  style="word-break: break-all">
		      		<input type="hidden" class="readonly" readonly style="text-align:center;width:100%" name="prpLpayExtContext" value="${prpLpayExtDto.context }" />
		      		${prpLpayExtDto.context }
	     		</td>
			</tr>
			</c:if>
		</c:forEach>
		</c:if>
		<c:if test="${(editType ne 'SHOW')}">
       	<tr>
			<!-- 序号 -->
			<td class="input" align="center" style="width:4%;">
				<input type="hidden" name="prpLpayExtFlag" value="${prpLpayExtDtoNew.flag }"  />
				<input type="hidden" name="prpLpayExtSerialNo" value="${prpLpayExtDtoNew.serialNo }"  />
				<c:if test="${not empty prpLpayExtDtoList }">
					<input type="text" class="readonly" style="text-align:center;width:100%" name="prpLpayExtRowNum" value="${fn:length(prpLpayExtDtoList)+1}" />
				</c:if>
				<c:if test="${empty prpLpayExtDtoList }">
					<input type="text" class="readonly" style="text-align:center;width:100%" name="prpLpayExtRowNum" value="1" />
				</c:if>
			</td>
			<!-- 处理结点 -->
			<td  class="input"  align="center" style="width:8%;">
				<input type="text"  style="text-align:center;width:99%" name="prpLpayExtNodeName" value="${prpLpayExtDtoNew.nodeName }" class="readonly" readonly />
				<input type="hidden"  style="text-align:center;width:99%" name="prpLpayExtNodeType" value="${prpLpayExtDtoNew.nodeType }" class="readonly" readonly />
	      	</td>
	      	<!-- 流出时间 -->
	      	<td class="input"  align="center" style="width:8%;">
	      		<input type="hidden"  style="text-align:center;width:99%" name="prpLpayExtInputDate" value="${prpLpayExtDtoNew.inputDate }" class="readonly" readonly />
	      		${prpLpayExtDtoNew.inputDate }
	     	</td>
     		<!-- 占用时间 -->
     		<td class="input"  align="center" style="width:8%;">
	     		<input type="text"  style="text-align:center;width:99%" name="prpLpayExtCostTime" value="${prpLpayExtDtoNew.costTime} " class="readonly" readonly />
	     	</td>
     		<!-- 操作人员 -->
     		<td class="input"  align="center" style="width:8%;">
     			<input type="hidden"  style="text-align:center;width:99%" name="prpLpayExtOperatorCode" value="${prpLpayExtDtoNew.operatorCode }" class="readonly" readonly />
     			<input type="text"  style="text-align:center;width:99%" name="prpLpayExtOperatorCodeName" value="${prpLpayExtDtoNew.operatorCodeName }" class="readonly" readonly />
	     	</td>
     		<!-- 处理机构 -->
     		<td class="input" align="center" style="width:10%;">
<!--	     			<%--=new UICodeAction().translateComCode("3400000000",true)--%>-->
				<input type="text" class="readonly" style="text-align:center;width:100%" name="prpLpayExtComCName" value="${prpLpayExtDtoNew.comCName}" />
				<input type="hidden" style="text-align:center;width:100%" name="prpLpayExtComCode" value="${prpLpayExtDtoNew.comCode }" />
     		</td>
     		<!-- 处理意见 -->
     		<td class="input"  align="center" style="width:10%;">
     			<input type="hidden" class="readonly" style="text-align:center;width:100%" name="prpLpayExtNotionCode" value="${prpLpayExtDtoNew.notionCode }" />
     			<input type="text" class="readonly" style="text-align:center;width:100%" name="prpLpayExtNotionName" value="${prpLpayExtDtoNew.notionName }" />
     		</td>
     		<!-- 补充说明 -->
     		<td class="input" style="width:44%;"  style="word-break: break-all">
	      		<input type="text" class="readonly" style="text-align:left;width:100%" name="prpLpayExtContext" value="${prpLpayExtDtoNew.context }" />
     		</td>
		</tr>
		</c:if>
	</table>
	
</div>
		