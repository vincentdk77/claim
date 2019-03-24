<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.sinosoft.claim.dto.domain.*" %>
<%@page import="java.util.*" %>
<script type="text/javascript">

	/**
	*  ֧���ϲ�����
	*/
	function mergeFee(obj){
		
		var paymentType = $("select[name='paymentType'] option[selected]").val();
		var paymentNo = $("input[name='paymentNo']").val();
		if(paymentType=="undifined"||paymentType==""){
			alert("����ѡ���������");
		}
		var payTotalAmount=0;
		var hasPay=0;
		var payAmount=0;
		var k=0;
		$("input[name='flag']").each(function(){
			if($(this).is(":checked")){
				var mergeFlag = true;
				//��size>1ʱ�����������+�������Ajax���ݵ���̨������У��
				if(k>0){
					mergeFlag = true;
					var certiNo = $(this).parent().parent().find("input[name='certiNoPay']").val();
					//mergeFlag = payMergeCheck(paymentType,certiNo,paymentNo);
				}
				//alert(mergeFlag);
				if(mergeFlag){
					var sumPaidStr = $(this).parent().parent().find("input[name='sumPaidPay']").val();
					var sumPaid=parseFloat(sumPaidStr);
					payTotalAmount+=sumPaid;
					var havPaidStr = $(this).parent().parent().find("input[name='havPaidPay']").val();
					var havPaid=parseFloat(havPaidStr);
					hasPay+=havPaid;
					var paidStr = $(this).parent().parent().find("input[name='fiscalpayAmount']").val();
					var paid=parseFloat(paidStr);
					payAmount+=paid;
				}else{
					$(obj).removeAttr("checked");
				}
				k++;
			}
		});
		$("input[name='payTotalAmount']").val(payTotalAmount.toFixed(2));
		$("input[name='hasPay']").val(hasPay.toFixed(2));
		$("input[name='sumPayAmount']").val(payAmount.toFixed(2));
		
	}
	/**
	*  ���������+�������Ajax���ݵ���̨������У���Ƿ����֧����Ϣ
	*/
	function payMergeCheck(paymentType,certiNo,paymentNo){
		var mergeFlag=false;
		$.ajax({
			url:'/claim/payMergeCheck.do'
			,type:'POST'
			,dataType:"text"
			,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
			,async:false
			,data:{'paymentNo':paymentNo,'paymentType':paymentType,'certiNo':certiNo}
			,success:function(data){
				if(data=="true"){
					//alert('��֤ͨ����');
					mergeFlag=true;
				}else{
					alert('�Ѵ���֧����Ϣ���޷��ϲ�');
					mergeFlag=false;
				}
			}
			,error:function(){alert('��������');}
		});
		return mergeFlag;
	}
	
	//�ϲ�֧��������д����֧��������֧�����
	function getPayTotalAmount(){
		var payTotalAmount=0;
		var hasPay=0;
		var payAmount=0;
		var k=0;
		$("input[name='flag']").each(function(){
			if($(this).is(":checked")){
				var paidStr = $(this).parent().parent().find("input[name='fiscalpayAmount']").val();
				var paid=parseFloat(paidStr);
				payAmount+=paid;
			}
			k++;
		});
		$("input[name='sumPayAmount']").val(payAmount.toFixed(2));
	}
	//ֻ���������ֺ�С������ı���(��������)
	function clearNoNumF(obj)
	{
	 //�Ȱѷ����ֵĶ��滻�����������ֺ�.-
	 obj.value = obj.value.replace(/[^\d.-]/g,"");
	 //���뱣֤��һ��Ϊ���ֻ���-������.
	 obj.value = obj.value.replace(/^\./g,"");
	 //��ֻ֤�г���һ��.��û�ж��.
	 obj.value = obj.value.replace(/\.{2,}/g,".");
	//��ֻ֤�г���һ��-��û�ж��.
	 obj.value = obj.value.replace(/\-{2,}/g,"-");
	 //��֤.ֻ����һ�Σ������ܳ�����������
	 obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
	//��֤-ֻ����һ�Σ������ܳ�����������
	 obj.value = obj.value.replace("-","$#$").replace(/\-/g,"").replace("$#$","-");
	 fireChangeComm(obj);
	}
	/**
	*��֤�����ֵ���ɸ����趨�����ֵ
	*/
	function checkMaxVal(obj){
		//var thisVal = $(obj).val();
		var thisVal = obj.value;
		var maxVal = $(obj).parent().find("input[name='paidMaxValue']").val();
		if(null!=maxVal&&""!=maxVal){
			if(parseFloat(thisVal)>parseFloat(maxVal)){
				alert("���ֵ���ɸ��ڱ�׼ֵ��"+maxVal);
				obj.value=maxVal;
			}
		}
		
	}
	//�ϲ��·���־����
	function mergeFlagClinck(obj){
		if($(obj).is(":checked")){
			//alert("ѡ��");
			$("input[name='mergerFlag']").val("1");
		}else{
			//alert("ȡ��");
			$("input[name='mergerFlag']").val("0");
		}
	}
	function getPayrefReasonName(reasonCode){
		var jsArr = [];
		<% Map<String,String> paymentTypeMap = (HashMap<String,String> )request.getAttribute("paymentTypeMap");
			Set<String> set = paymentTypeMap.keySet();
			for(String paymentTypeCode : set){
		%>
			var code="<%=paymentTypeCode%>";
			var name="<%=paymentTypeMap.get(paymentTypeCode)%>";
			if(reasonCode.trim()==code.trim()){
				return name;
			}
		<%		
			}
		%>
		
	}
	function showPayAndPolicy(registNo){
		var url = "/claim/paymainAndRigistEdit.do?registNo="+registNo+"&dataType=linkOne&editType=SHOW&nodeType=apay&isBtn=true";
		window.open(url);
	}
</script>
<div id="content_basic" style="width: 98%" name="mainInfoDiv">
	<span style="text-align: left; width: 99%;font-size:12px">
		<img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
			name="RegistExtImg" onclick="showPage(this,mainInfo)">&nbsp;�⸶��Ϣ
	</span>
	<table class="common" id="mainInfo" cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8">
		<tr>
			<!-- <td class="title"  style="width:8%" align="center">��������</td> -->
			<td class="title"  style="width:11%" align="center">��������</td>
			<td class="title"  style="width:23%" align="center">��������</td>
			<td class="title"  style="width:11%" align="center">�������</td>
			<td class="title"  style="width:14%" align="center">�������</td>
			<td class="title"  style="width:10%" align="center">�᰸���</td>
			<td class="title"  style="width:10%" align="center">��֧�����</td>
			<td class="title"  style="width:12%" align="center">ʣ��֧�����</td>
			<!-- <td class="title"  style="width:9%" align="center">����</td> -->
		</tr>
		<c:if test="${not empty prpLpayShowDtoList }">
		<c:forEach items="${prpLpayShowDtoList }" var="prpLpayShowDto" varStatus="status">
		<tr>
			<td class="input"  align="center">
				<input type="hidden" style="width: 99%;text-align: center;" readOnly class="readOnly" name="policyTypePay" value="${prpLpayShowDto.policyType }" />
				<input type="hidden" style="width: 99%" readOnly class="readOnly" name="policyNoPay" value="${prpLpayShowDto.policyNo }" />
				<input type="hidden" style="width: 99%" readOnly class="readOnly" name="claimNoPay" value="${prpLpayShowDto.claimNo }" />
				<input type="hidden" style="width: 99%" readOnly class="readOnly" name="payrefreason" value="${prpLpayShowDto.payrefreason }" />
				<input type="hidden" style="width: 99%" readOnly class="readOnly" name="serilNoPay" value="${status.count }" />
				<input type="hidden" style="width: 99%" readOnly class="readOnly" name="payrefreasonChinesName" value="${paymentTypeMap[prpLpayShowDto.payrefreason] }" />
			<!-- </td>
			<td  class="input"  align="center"> -->
				<a href="#" onclick="logstore('${prpLpayShowDto.registNo }','apay')">${prpLpayShowDto.registNo }</a>
				<input type="hidden" style="width: 99%;text-align: center;" readOnly class="readOnly" name="registNoPay" value="${prpLpayShowDto.registNo }" />
				<input type="hidden" style="width: 99%;text-align: center;" readOnly class="readOnly" name="classCode" value="${prpLpayShowDto.classCode }" />
			</td>
			<td  class="input"  align="center">
				<input type="hidden" style="width: 99%;text-align: center;" readOnly class="readOnly" name="insuredNamePay" value="${prpLpayShowDto.insuredName }" />
				${prpLpayShowDto.insuredName }
			</td>
			<td  class="input"  align="center">
				<input type="text" style="width: 99%;text-align: center;" readOnly class="readOnly" name="certiNoPay" value="${prpLpayShowDto.certiNo }" />
			</td>
			<td  class="input"  align="center">
				<input type="hidden" style="width: 99%" readOnly class="readOnly" name="comCodePay" value="${prpLpayShowDto.comCode}" />
				<input type="hidden" style="width: 99%;text-align: center;" readOnly class="readOnly" name="comCodeNamePay" value="${prpLpayShowDto.comCodeName }" />
				${paymentTypeMap[prpLpayShowDto.payrefreason] }
			</td>
			<td  class="input"  align="center">
				<input type="text" style="width: 99%;text-align:right;" readOnly class="readOnly" name="sumPaidPay" value="${prpLpayShowDto.sumPaid }" />
			</td>
			<td  class="input"  align="center">
				<input type="text" style="width: 99%;text-align:right;" readOnly class="readOnly" name="havPaidPay" value="${prpLpayShowDto.havPaid }" />
			</td>
			<td  class="input"  align="center">
				<input type="hidden" name="paidMaxValue"  value="<fmt:formatNumber type='number' value='${prpLpayShowDto.sumPaid-prpLpayShowDto.havPaid }' pattern='##########.##' maxFractionDigits='2'/>" />
				<c:if test="${prpLpayShowDto.exist eq '1' }">
				<input type="hidden" style="width: 99%;text-align:right;"  class="input" name="paidPayHis"  value="${prpLpayShowDto.nowPaid }" onblur="clearNoNumF(this);checkMaxVal(this);mergeFee(this);"/>
				<input type="text" style="width: 99%;text-align:right;" readOnly class="readOnly"  class="input" name="paidPay"  value="${prpLpayShowDto.nowPaid }" onblur="clearNoNumF(this);checkMaxVal(this);mergeFee(this);"/>
				</c:if>
				<c:if test="${prpLpayShowDto.exist ne '1' }">
					<input type="text" style="width: 99%;text-align:right;" readOnly class="readOnly"  class="input" name="paidPay"  value="<fmt:formatNumber type='number' value='${prpLpayShowDto.sumPaid-prpLpayShowDto.havPaid }' pattern='##########.##' maxFractionDigits='2'/>" onblur="clearNoNumF(this);checkMaxVal(this);mergeFee(this);"/>
				</c:if>
			</td>
			<!-- <td  class="input"  align="center">
				<input type="checkbox" style="border: none;" name="certiNoflag" value="${status.index }" onclick="mergeFeeByCertiNo(this);" <c:if test="${prpLpayShowDto.exist eq '1' }">checked</c:if> />
			</td> -->
		</tr>
		</c:forEach>
		</c:if>

	</table>
	
</div>


		