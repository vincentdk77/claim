<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page language="java" isELIgnored="false" %>
<%@page import="com.sinosoft.claim.dto.domain.PrplpayDto" %>
<%@page import="com.sinosoft.platform.dto.domain.PrpDcodeDto" %>
<%
	String businame=request.getParameter("businame");
	String businame1=request.getParameter("businame1");
	String registNo = (String)request.getAttribute("RegistNo");
	String policyNo = (String)request.getAttribute("PolicyNo");
	String riskCode = (String)request.getAttribute("RiskCode");
	String claimNo =  (String)request.getAttribute("ClaimNo");
	String busiNo  =  (String)request.getAttribute("BusiNo");
	String flag    =  (String)request.getParameter("flag");
	ArrayList<PrpDcodeDto> paymentTypeList = (ArrayList<PrpDcodeDto>)request.getAttribute("PaymentType");
	ArrayList<PrplpayDto> payInfoList = (ArrayList<PrplpayDto>)request.getAttribute("PayInfoList");
	ArrayList<PrplpayDto> uppayList =  (ArrayList<PrplpayDto>)request.getAttribute("UppayList");
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>֧����Ϣ</title>
	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<script type="text/javascript">
	/**
		У��֧����Ϣ�ı�����
	*/
	function checkPayment(){
	  var bankaccount=document.getElementsByName("bankaccount");
	  var rebankaccount=document.getElementsByName("rebankaccount");
	  var receiverfullname=document.getElementsByName("receiverfullname");
	  var bank=document.getElementsByName("bank");
	  if(bankaccount.length!=0){
		  for(i=1;i<bankaccount.length;i++){
		  	if(bank[i].value==''){
		  		alert('����д֧����Ϣ�еĿ������У�����������');
		  		return false;
		  	}else if(bankaccount[i].value==''){
		  		alert("����д�����˺�");
		  		return false;
		  	}else if(receiverfullname[i].value==''){
		  		alert("����д�����ȫ��");
		  		return false;
		  	}else if(bankaccount[i].value!=rebankaccount[i].value){
		  		alert('�����˺ź�ȷ���˺ű���һ��');
		  		return false;
		  	}
		  }
	  }
	  	return true;
	}
	function yuPayMent(){
   		var yupei=document.getElementById("sumPrePaid");
   		var tempYupei=yupei==null?0:yupei.value;
   		var zhifu=document.getElementsByName("payamount");
   		var shizhifu=0;
   		for(i=1;i<zhifu.length;i++){
	   		shizhifu+=Number(zhifu[i].value);
   		}
   		//alert(tempYupei+":"+shizhifu);
   		//if(tempYupei!=0){
   		 if(Number(shizhifu)!=Number(tempYupei)){
   			alert("֧����Ϣ�е��ܵ�֧�����������Ԥ����:"+tempYupei);
   			return false;
   		 }
   		//}
   		
   		return true;
   	}

	var htmlvalue="";
	function addRow_(){
		
		//getAddHtml();
		
		if(htmlvalue==""){
			htmlvalue=$("#hiddentab").html();
			
			$("#hiddentab").html();
		}
		$("#mytab").append(htmlvalue);
		setIndex("mytab");
	}
	function delRow_(flag){
		if(htmlvalue==""){
			htmlvalue=$("#hiddentab").html();
		}
		if(confirm('ȷ��ɾ����')){
			$(flag).parent().parent().parent().remove();
			setIndex("mytab");
		}
	}
	/**
	*��ʼ�����ݣ���ҳ����õ�ʱ������һ��
	*/
	function initData(){
			//��������
        	var options=new Array();
        	options.push("");
        	//���к���
        	bankaccountoptions=new Array();
        	bankaccountoptions.push("");
        	//ȷ�Ϻ���
        	rebankaccountoptions=new Array();
        	rebankaccountoptions.push("");
        	//�����ȫ��
        	nameoptions=new Array();
        	nameoptions.push("");
        	<%for(int i=0;i<uppayList.size();i++){
        		PrplpayDto dto = (PrplpayDto)uppayList.get(i);
        		if(!dto.getBank().equals("")){
        			%>options.push("<%=dto.getBank()%>");<%//��������
        		}
        		if(!dto.getBankaccount().equals("")){
        			%>bankaccountoptions.push("<%=dto.getBankaccount()%>");<%//���к���
        			%>rebankaccountoptions.push("<%=dto.getBankaccount()%>");<%//ȷ�Ϻ���
        		}
        		if(!dto.getReceiverfullname().equals("")){
        			%>nameoptions.push("<%=dto.getReceiverfullname()%>");<%//�տ�������
        		}
        	} %>
        	var param={divclass:'div_1',option:options};
        	fu.style.editSelect(param);
        	var param={divclass:'div_2',option:bankaccountoptions};
        	fu.style.editSelect(param);
        	var param={divclass:'div_3',option:rebankaccountoptions};
        	fu.style.editSelect(param);
        	var param={divclass:'div_4',option:nameoptions};
        	fu.style.editSelect(param);
	}
	//�����Ÿı�����䶯�����
	function changeComp(obj){
	   var tr=$(obj).parent().parent();
	   var selectRiskCode=obj.value.split(",")[2];
	   var compSelectOptions=tr.find("select[name=compensateno]").find("option");
	   for(var i=0;i<compSelectOptions.length;i++){
	   	var partVar=compSelectOptions[i].value.substring(1,5);
	   	if(partVar==selectRiskCode){
	   	   $(compSelectOptions[i]).attr("selected",true);
	   	}else{
	   	   $(compSelectOptions[i]).attr("selected",false);
	   	}
	   }
	   
	}
	
	//�����Ÿı�����䶯�����
	function changeClaim(obj){
	   var tr=$(obj).parent().parent();
	   var selectRiskCode=obj.value.substring(1,5);
	   
	   var claimSelectOptions=tr.find("select[name=claimno]").find("option");
	   for(var i=0;i<claimSelectOptions.length;i++){
	   	var partVar=claimSelectOptions[i].value.split(",")[2];
	   	if(partVar==selectRiskCode){
	   	   $(claimSelectOptions[i]).attr("selected",true);
	   	}else{
	   	   $(claimSelectOptions[i]).attr("selected",false);
	   	}
	   }
	   
	}
	//��ʼ��ʹ�����źͼ������һ��
   $(document).ready(function(){
      var compSelects=$("select[name=compensateno]");
      if(compSelects.length>0){
      	 changeClaim(compSelects[0]);
      }
   })
        
	</script>
  </head>
  <body>
  	<input type="hidden" name="flag" value="<%=flag%>">
    <table class="common" width="100%" style="border-collapse:collapse;background-color: #F7F7F7;"  cellpadding="0"  cellspacing="0" border="1" bordercolor="#3A81C8">
    	<tr>
    		<td class="formlefttitle" colspan="8">֧��¼��</td>
    	</tr>
    	<tr>
    		<td colspan="9">
    			<table style="margin-top:4px;border-collapse:collapse;display: none;" class="common"  width="99%" id="hiddentab"  cellpadding="0"  cellspacing="0" border="1" bordercolor="#3A81C8">
    				<tbody >
				    	<tr>
				    		<td class=""  style="background-color:#D8E3F3;width:5%">
				    			���<input type="hidden" name="payflag" value="0">
				    		</td>
				    		<td  class="title" style="width:6%;padding-left: 0px;">
				    			<span>������</span>
				    		</td>
				    		<td colspan="2" >
				    			<input type="text" id="registNo_payment" name="registNo_payment" value="<%=registNo %>" class="readonly">
				    		</td>
				    		<td class="title"  style="width: 10%">
				    			<%=businame1 %>
				    			<input type="hidden" name="riskcode_payment" value="<%=riskCode %>">
				    		</td>
				    		<td width="20%" colspan="2" >
				    		<%if(busiNo != null && !busiNo.equals("")){%>
				    			<select name="compensateno" onchange="changeClaim(this)">
				    				<option value='<%=busiNo %>'><%=busiNo %></option>
				    			</select>
				    		<%} %>
				    		</td>
				    		<td class="title"><%=businame %></td>
				    		<td >
								<select name="claimno" onchange="changeComp(this)">
									<option	value="<%=claimNo %>,<%=policyNo %>,<%=riskCode %>"><%=claimNo %></option>
								</select>
				    		</td>
				    		<td rowspan="7" style="width:4%" >
				    			<input type="button" class="smallbutton" onclick="delRow_(this)" value="-">
				    		</td>
				    	</tr>
				    	<tr>
				    		<td rowspan="6" style="width:10px" id="tdindex" class="input indextd">
				    			<input type="hidden" value="0" name="serialno">0
				    		</td>
				    		<td class="title" style="width:8%">֧������</td>
				    		<td width="15%"  colspan="2">
				    			<select name="paytype">
				    				<option value="" >��ѡ��</option>
				    				<option value="P1" >Ԥ��</option>
				    				<option value="P2">֧��</option>
				    				<option value="P3" selected>ʵ��</option>
				    				<option value="P4">�渶</option>
				    				<option value="P5">�᰸֧��</option>
				    			</select>
				    		</td>
				    		<td class="title" style="width:10%">���������</td>
				    		<td width="15%"  colspan="2">
				    			<select style="width: 98" name="receivertype">
				    				<option value="t1">��������</option>
				    				<option value="t2">ί�и��˴�������</option>
				    				<option value="t3">ί�е�λ��������</option>
				    			</select>
				    		</td>
				    		<td class="title" style="width:8%">֧�����</td>
				    		<td >
				    			<input type="text"  name="payamount"  style="width:90%">
				    		</td>
				    	</tr>
				    	<tr>
				    		<td class="title">��������</td>
				    		<td colspan="5" >
				    			<div class="div_1" name="bank"></div>
				    			<font class="font_">*</font>
				    		</td>
				    		<td class="title">�������</td>
				    		<td >
				    			<select name="paymenttype" >
				    			<%for(int i=0;i<paymentTypeList.size();i++){
				    				PrpDcodeDto paymenttype = (PrpDcodeDto)paymentTypeList.get(i);
				    				System.err.println(paymenttype.getCodeCode()+"   "+paymenttype.getCodeCName());
				    			%>
				    				<option value="<%=paymenttype.getCodeCode() %>"><%=paymenttype.getCodeCName() %></option>
				    			<%} %>
				    			</select>
							</td>
				    	</tr>
				    	<tr>
				    		<td class="title" style="width: 5%">�����˺�</td>
				    		<td colspan="5">
				    			<div class="div_2" name="bankaccount"></div>
				    			<font class="font_">*</font>
				    		</td>
				    		<td class="title" style="width: 5%">�˺�ȷ��</td>
				    		<td >
				    			<div class="div_3" name="rebankaccount"></div>
				    			<font class="font_">*</font>
				    		</td>
				    	</tr>
				    	<tr>
				    		<td class="title" style="width: 5%">�����ȫ��</td>
				    		<td colspan="5" >
				    			<div class="div_4" name="receiverfullname"></div>
				    			<font class="font_">*</font>
				    		</td>
				    		<td class="title" style="width:8%">��ϵ�绰</td>
				    		<td>
				    			<input type="text"  name="familyphone" >
				    		</td>
				    	</tr>
			    	</tbody>
    			</table>
    			
    			<table style="margin-top:4px;border-collapse:collapse;" class="common"  width="99%" id="mytab"  cellpadding="0"  cellspacing="0" border="1" bordercolor="#3A81C8">
   					<%for(int i=0;i<payInfoList.size();i++){
   						PrplpayDto pif = (PrplpayDto)payInfoList.get(i);
   						System.err.println("payamount"+pif.getPayamount());
   					%>
    				<tbody class="divpayflag<%=pif.getPayflag() %>">
				    	<tr>
				    		<td style="background-color:#D8E3F3;width:5%">
				    			���<input type="hidden" name="payflag" value="<%=pif.getPayflag() %>">
				    		</td>
				    		<td  class="title" style="width:6%;padding-left: 0px;">
				    			������
				    		</td>
				    		<td colspan="2">
				    			<input type="text" name="registNo_payment" value="<%=pif.getRegistno() %>" class="readonly">
				    		</td>
				    		<td class="title"  style="width: 10%">
				    			<%=businame1%><input type="hidden" name="riskcode_payment" value="<%=pif.getRiskcode() %>">
				    		</td>
				    		<td width="20%" colspan="2" >
				    			<input type="text" value="<%=pif.getCompensateno() %>" id="compensateno" name="compensateno" class="readonly" readonly="readonly">
				    		</td>
				    		<td class="title"><%=businame %></td>
				    		<td style="">
				    			<select name="claimno">
				    				<option value="<%=pif.getClaimno() %>,<%=pif.getPolicyno() %>,<%=pif.getRiskcode() %>" selected><%=pif.getClaimno() %></option>
				    			</select>
				    		</td>
				    		<td rowspan="7" style="width:4%"  >
				    			<input type="button" class="smallbutton" onclick="delRow_(this)" value="-">
				    		</td>
				    	</tr>
				    	<tr>
				    		<td rowspan="6" style="width:10px;"  id="tdindex" class="indextd" align="center">
				    			<input type="hidden" value="0" style="width:10px" name="serialno"><%=i+1 %>
				    		</td>
				    		
				    		<td class="title" style="width:8%">֧������</td>
				    		<td width="15%"  colspan="2">
				    			<select name="paytype">
				    			
				    				<option value="" >��ѡ��</option>
				    				<option value="P1" <%=(pif.getPaytype().equals("P1")?"selected":"") %>>Ԥ��</option>
				    				<option value="P2" <%=(pif.getPaytype().equals("P2")?"selected":"") %>>֧��</option>
				    				<option value="P3" <%=(pif.getPaytype().equals("P3")?"selected":"") %>>ʵ��</option>
				    				<option value="P4" <%=(pif.getPaytype().equals("P4")?"selected":"") %>>�渶</option>
				    				<option value="P5" <%=(pif.getPaytype().equals("P5")?"selected":"") %>>�᰸֧��</option>
				    			</select>
				    		</td>
				    		<td class="title" style="width:10%">���������</td>
				    		<td width="15%"  colspan="2">
				    			<select style="width: 98%" name="receivertype">
				    				<option value="t1" <%=(pif.getReceivertype().equals("t1")?"selected":"") %>>��������</option>
				    				<option value="t2" <%=(pif.getReceivertype().equals("t2")?"selected":"") %>>ί�и��˴�������</option>
				    				<option value="t3" <%=(pif.getReceivertype().equals("t3")?"selected":"") %>>ί�е�λ��������</option>
				    			</select>
				    		</td>
				    		<td class="title" style="width:8%">֧�����</td>
				    		<td >
				    			<input type="text" value="<%=pif.getPayamount() %>"  name="payamount"  style="width:90%">
				    		</td>
				    		
				    	</tr>
				    	<tr>
				    		<td class="title">��������</td>
				    		<td colspan="5">
				    			<div class="div_1" name="bank"><%=pif.getBank() %></div>
				    			<font class="font_">*</font>
				    		</td>
				    		<td class="title">�������</td>
				    		<td  style="">
				    			<select name="paymenttype">
				    			<%for(int j=0;j<paymentTypeList.size();j++){
				    				PrpDcodeDto paymenttype = (PrpDcodeDto)paymentTypeList.get(j);
				    			%>
				    				<option value="<%=paymenttype.getCodeCode() %>" <%=(pif.getPaymenttype().equals(paymenttype.getCodeCode())?"selected":"") %>><%=paymenttype.getCodeCName() %></option>
				    			<%} %>
				    			</select>
							</td>
				    	</tr>
				    	<tr>
				    		<td class="title" style="width: 5%">�����˺�</td>
				    		<td  colspan="5">
				    			<div class="div_2" name="bankno"><%=pif.getBankaccount() %></div>
				    			<font class="font_">*</font>
				    		</td>
				    		<td class="title" style="width: 5%">�˺�ȷ��</td>
				    		<td  colspan="">
				    			<div class="div_3" name="rebankaccount"><%=pif.getBankaccount() %></div>
				    			<font class="font_">*</font>
				    		</td>
				    	</tr>
				    	<tr>
				    		<td class="title" style="width: 5%">�����ȫ��</td>
				    		<td colspan="5" >
				    			<div class="div_4" name="receiverfullname"><%=pif.getReceiverfullname() %></div>
				    			<font class="font_">*</font>
				    		</td>
				    		<td class="title" style="width:8%">��ϵ�绰</td>
				    		<td  >
				    			<input type="text" name="familyphone" value="<%=pif.getFamilyphone() %>" >
				    		</td>
				    	</tr>
			    	</tbody>
			    	<%} %>
    			</table>
    		</td>
    	</tr>
    	<tr style="padding-top: 0px;margin-top: 0px">
    		<td colspan="1" style="width:13%;margin-top: 0px;padding-top: 0px;background-color: #D8E3F3">֧��˵��</td>
    		<td colspan="6" >
    			<textarea rows="2" name="payremark" cols="4" maxlen="150" cnname="֧��˵��" style="width:99%">${PayRemark}</textarea>
    		</td>
    		<td   align="right"  style="padding-right:8px;width: 10%;">
    			<input type="button" class="smallbutton" value="+" onclick="addRow_()">
    		</td>
    	</tr>
    </table>
  </body>
</html>
