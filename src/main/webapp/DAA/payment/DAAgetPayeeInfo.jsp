<%@page import="com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper"%>
<%@page import="com.sinosoft.claim.dto.custom.TurnPageDto"%>
<%@page contentType="text/html; charset=GBK"	language="java"	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="java.util.ArrayList" %>
<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
<link rel="stylesheet" type="text/css" href="/newclaim/css/StandardCar.css">

<%  
    PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
	String newAgriFlag = (String)request.getAttribute("newAgriFlag");
%>
<script type="text/javascript">
	var ret = new Array();
	function chooseOne(obj){
	//debugger;
		ret[0] = "true";
		var receiverFullName = $(obj).parent().find("input[name='receiverFullName']").val();
		ret[1] =receiverFullName;
		var receiverTypeOther = $(obj).parent().find("input[name='receiverTypeOther']").val();
		ret[2] =receiverTypeOther;
		var receiverTypeOtherName = $(obj).parent().find("input[name='receiverTypeOtherName']").val();
		ret[3] =receiverTypeOtherName;
		var certifNo = $(obj).parent().find("input[name='certifNo']").val();
		ret[4] =certifNo;
		var certifType = $(obj).parent().find("input[name='certifType']").val();
		ret[5] =certifType;
		var bank = $(obj).parent().find("input[name='bank']").val();
		ret[6] =bank;
		var bankAccount = $(obj).parent().find("input[name='bankAccount']").val();
		ret[7] =bankAccount;
		var bankType = $(obj).parent().find("input[name='bankType']").val();
		ret[8] =bankType;
		var accountFlag = $(obj).parent().find("input[name='accountFlag']").val();
		ret[9] =accountFlag;
		var accountType = $(obj).parent().find("input[name='accountType']").val();
		ret[10] =accountType;
		var routeNum = $(obj).parent().find("input[name='routeNum']").val();
		ret[11] =routeNum;
		var city = $(obj).parent().find("input[name='city']").val();
		ret[12] =city;
		var province = $(obj).parent().find("input[name='province']").val();
		ret[13] =province;
		var mobilePhone = $(obj).parent().find("input[name='mobilePhone']").val();
		ret[14] =mobilePhone;
		var inputDate = $(obj).parent().find("input[name='inputDate']").val();
		ret[15] =inputDate;
		window.close();
	}
	window.returnValue = ret;
	
	function deleteElementRow(field,intPageDataKeyCount,intRowsCount)
		{
		//debugger;
		  var index = getElementOrder(field)-intPageDataKeyCount;
		  var count = getElementCount(field.name);
		  var obj_tr = field.parentNode.parentNode.childNodes;
		  for(var i=0;i<obj_tr.length;i++){
			  obj_tr[i].style.background = "#778899";       //ɾ��(��ɫ)
		  }
		  if(count==1){
		    fm.deleteFlag.value="1";
		    fm.button_add.style.display="";
		    fm.button_delete.style.display="none";
		  }else if(count>1){
		    fm.deleteFlag[index].value="1";
		    fm.button_add[index].style.display="";
		    fm.button_delete[index].style.display="none";
		  }
		}
		
   function addElementRow(field,intPageDataKeyCount,intRowsCount){
   //debugger;
	 var index = getElementOrder(field)-intPageDataKeyCount;
	 var count = getElementCount(field.name);
	 var obj_tr = field.parentNode.parentNode.childNodes;
		  for(var i=0;i<obj_tr.length;i++){
			  obj_tr[i].style.background = "";
		  }
	  if(count==1){
  		fm.deleteFlag.value="0";
		fm.button_add.style.display="none";
		fm.button_delete.style.display="";
	  }else if(count>1){
	    fm.deleteFlag[index].value="0";
		fm.button_add[index].style.display="none";
		fm.button_delete[index].style.display="";
	  }
   }
   
   function saveInfo(page){
   //debugger;
	   var curPage = page;
	   if(fm.receiverFullName.length==null){
		      if(fm.deleteFlag.value=="1"){
		          if(confirm("ȷ��ɾ����ѡ������")){
				       $.ajax({
						url:'/claim/deleteSavePayeeInfo.do'
						,type:'POST'
						,dataType:"text"
						,async:false
						,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
						,data:{
						"receiverFullName":fm.receiverFullName.value,
						"receiverTypeOther":fm.receiverTypeOther.value,
						"certifNo":fm.certifNo.value,
						"certifType":fm.certifType.value,
						"bank":fm.bank.value,
						"bankAccount":fm.bankAccount.value,
						"bankType":fm.bankType.value,
						"accountFlag":fm.accountFlag.value,
						"accountType":fm.accountType.value,
						"routeNum":fm.routeNum.value,
						"province":fm.province.value,
						"city":fm.city.value,
						"mobilePhone":fm.mobilePhone.value,
						"inputDate":fm.inputDate.value			
						}
						,success:function(data){
							if(data){
						      alert("ɾ����Ϣ�ɹ���");
							}else{
							  alert("ɾ����Ϣʧ�ܣ�");
							}
						}
						,error:function(){alert('��������');}
					   });    
		               fm.submit();
		          }
		      }else{
			      alert("δѡ����Ҫɾ�������ݣ����豣�棡");
			      return;
		      }
	   }else{
	      var retMsg ="";
	      var isDelete = false;
	       for(var i=0;i<fm.receiverFullName.length;i++){
		        if(fm.deleteFlag[i].value=="1"){
		             isDelete = true;
		             break;
		        }
		   }
		   if(isDelete){//�����Ҫɾ��������
		      if(confirm("ȷ��ɾ����ѡ������")){
			      for(var i=0;i<fm.receiverFullName.length;i++){
				        if(fm.deleteFlag[i].value=="1"){
					       $.ajax({
							url:'/claim/deleteSavePayeeInfo.do'
							,type:'POST'
							,dataType:"text"
							,async:false
							,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
							,data:{
							"receiverFullName":fm.receiverFullName[i].value,
							"receiverTypeOther":fm.receiverTypeOther[i].value,
							"certifNo":fm.certifNo[i].value,
							"certifType":fm.certifType[i].value,
							"bank":fm.bank[i].value,
							"bankAccount":fm.bankAccount[i].value,
							"bankType":fm.bankType[i].value,
							"accountFlag":fm.accountFlag[i].value,
							"accountType":fm.accountType[i].value,
							"routeNum":fm.routeNum[i].value,
							"province":fm.province[i].value,
							"city":fm.city[i].value,
							"mobilePhone":fm.mobilePhone[i].value,
							"inputDate":fm.inputDate[i].value	
							}
							,success:function(data){
								retMsg +=data;
							}
							,error:function(){
							   retMsg="flase";
							}
					       });
				        }
			      }
			      if(retMsg.indexOf("flase")>0){
			         alert("ɾ����Ϣʧ�ܣ�");
			      }else{
			         alert("ɾ����Ϣ�ɹ���");
			      }
			      fm.submit();
		      }
		   }else{
		      alert("δѡ����Ҫɾ�������ݣ����豣�棡");
		      return;
		   }
	   }
  }
 
</script>
<head>
  <base target="_self">
</head>
<body>
  <form action="/claim/getPayeeInfo.do" name="fm" method="post">
<div id="content_basic1" style="overflow-x:scroll; width: 100%" name="payeeInfoListDiv">
	<span style="text-align: left; width: 99%;font-size:12px ">
		<img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
			name="RegistExtImg" onclick="showPage(this,payInfoList)">&nbsp;�������Ϣ
	</span>
	<table class="common" id="payInfoList" cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8">
		<thead>
			<tr>
				<td nowrap class="centertitle"  align="center">ѡ��</td>
				<td nowrap class="centertitle"  align="center">���������</td>
				<!-- <td nowrap   align="center">���������</td> -->
				<td nowrap class="centertitle"  align="center">֤������</td>
				<td nowrap class="centertitle"  align="center">֤������</td>
				<td nowrap class="centertitle"  align="center">��������</td>
				<td nowrap class="centertitle"  align="center">�����˺�</td>
				<td nowrap class="centertitle"  align="center">���д���</td>
				<td nowrap class="centertitle"  align="center">�˺�����</td>
				<td nowrap class="centertitle"  align="center">�˺�����</td>
				<td nowrap class="centertitle"  align="center">���к�</td>
				<td nowrap class="centertitle"  align="center">ʡ������</td>
				<td nowrap class="centertitle"  align="center">��������</td>
				<td nowrap class="centertitle"  align="center">�ֻ�����</td>
				<td nowrap class="centertitle"  align="center">�� ��</td>
			</tr>
		</thead>
		<tbody>
			<%  TurnPageDto turnPageDto = (TurnPageDto)request.getAttribute("turnPageDto"); 
				ArrayList prplPayeeInfoDtoList = (ArrayList)turnPageDto.getResultList();
				String accountFlagName = "";
				for(int i=0;i<prplPayeeInfoDtoList.size();i++) {
					PrplPayeeInfoDto prplPayeeInfoDto = (PrplPayeeInfoDto)prplPayeeInfoDtoList.get(i);
					if("00".equals(prplPayeeInfoDto.getAccountFlag())){accountFlagName = "���п�";}
					if("01".equals(prplPayeeInfoDto.getAccountFlag())){accountFlagName = "����";}
					if("02".equals(prplPayeeInfoDto.getAccountFlag())){accountFlagName = "���ÿ�";}
					if("03".equals(prplPayeeInfoDto.getAccountFlag())){accountFlagName = "�Թ��˻�";}
			%>
				<tr>
					<td nowrap class="input" align="center">
						<input type="radio" onclick="chooseOne(this)"/>
						<input type="hidden" name="receiverFullName" value="<%=prplPayeeInfoDto.getReceiverFullName() %>" />
						<input type="hidden" name="receiverTypeOther" value="<%=prplPayeeInfoDto.getReceiverTypeOther() %>" />
						<input type="hidden" name="receiverTypeOtherName" value="<%=paymentViewHelper.getReceiverTypeOtherName(newAgriFlag, prplPayeeInfoDto.getReceiverTypeOther())%>" />
						<input type="hidden" name="certifNo" value="<%=prplPayeeInfoDto.getCertifNo() %>" />
						<input type="hidden" name="certifType" value="<%=prplPayeeInfoDto.getCertifType() %>" />
						<input type="hidden" name="certifTypeName" value="<%=paymentViewHelper.getCertifTypeName(prplPayeeInfoDto.getCertifType()) %>" />
						<input type="hidden" name="bank" value="<%=prplPayeeInfoDto.getBank() %>" />
						<input type="hidden" name="bankAccount" value="<%=prplPayeeInfoDto.getBankAccount() %>" />
						<input type="hidden" name="bankType" value="<%=prplPayeeInfoDto.getBankType() %>" />
						<input type="hidden" name="accountFlag" value="<%=prplPayeeInfoDto.getAccountFlag()%>" />
						<input type="hidden" name="accountFlagName" value="<%=accountFlagName%>" />
						<input type="hidden" name="accountType" value="<%=prplPayeeInfoDto.getAccountType()%>" />
						<input type="hidden" name="routeNum" value="<%=prplPayeeInfoDto.getRouteNum() %>" />
						<input type="hidden" name="province" value="<%=prplPayeeInfoDto.getProvince() %>" />
						<input type="hidden" name="city" value="<%=prplPayeeInfoDto.getCity() %>" />
						<input type="hidden" name="mobilePhone" value="<%=prplPayeeInfoDto.getMobilePhone() %>" />
						<input type="hidden" name="inputDate" value="<%=prplPayeeInfoDto.getInputDate()%>" />
					</td>
					<td nowrap class="input"><%=prplPayeeInfoDto.getReceiverFullName() %></td>
					<%-- <td nowrap class="input"><%=paymentViewHelper.getReceiverTypeOtherName(newAgriFlag, prplPayeeInfoDto.getReceiverTypeOther())%></td> --%>
					<td nowrap class="input"><%=paymentViewHelper.getCertifTypeName(prplPayeeInfoDto.getCertifType()) %></td>
					<td nowrap class="input"><%=prplPayeeInfoDto.getCertifNo() %></td>
					<td nowrap class="input"><%=prplPayeeInfoDto.getBank() %></td>
					<td nowrap class="input"><%=prplPayeeInfoDto.getBankAccount()%></td>
					<td nowrap class="input"><%=prplPayeeInfoDto.getBankType() %></td>
					<td nowrap class="input"><%=accountFlagName%></td>
					<td nowrap class="input"><%="1".equals(prplPayeeInfoDto.getAccountType())?"����":"��λ" %></td>
					<td nowrap class="input"><%=prplPayeeInfoDto.getRouteNum() %></td>
					<td nowrap class="input"><%=prplPayeeInfoDto.getProvince() %></td>
					<td nowrap class="input"><%=prplPayeeInfoDto.getCity() %></td>
					<td nowrap class="input"><%=prplPayeeInfoDto.getMobilePhone() %></td>
					<td class="input" style="width: 5%" align="center">
			    		<input type="hidden" name="deleteFlag" value="0">
			    		<input type="button" class="button" name="button_delete" value="ɾ��" onclick="deleteElementRow(this,1,1);">
			    		<input type="button" class="button" name="button_add" value="�ָ�" style="display: none" onclick="addElementRow(this,1,1);">
			    	</td>
				</tr>
			<%} %>
		</tbody>
	</table>
	<% 
		  String iWhere = turnPageDto.getCondition();
		%>
		<c:set var="pageview" value="${turnPageDto}"></c:set>
   		 <%@include file="/common/pub/TurnOverPage.jsp" %>
</div>
<input type="hidden" name="iWhere"  value="<%=iWhere %>">
<input type="button" id="closeButton" name="closeButton" class="bobu"  value="�ر�" onclick="javascript:window.close();">
<%if(prplPayeeInfoDtoList.size()>0){%>
    <input type="button" id="submitButton" name="submitButton" class="bobu"  value="����" onclick="saveInfo();">
<%}%>
</form>
</body>