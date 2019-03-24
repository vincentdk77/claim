<%@page contentType="text/html; charset=GBK"	language="java"	%>
<%@ page import="com.sinosoft.sysframework.reference.AppConfig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLpayHisDto" %> 
<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
<%
	PrpLpayHisDto prpLpayHisDto1 = (PrpLpayHisDto)request.getAttribute("prpLpayHisDto");

%>
<style type="text/css">
/*--��ѯ/�༭/��ʾҳ����������/��ʾ���Ӧ�������ʽ--*/
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
<script type="text/javascript">
	//���ڽ�һ������ת����2���ֽڳ���
	String.prototype.realLength = function(){
		return this.replace(/[^\x00-\xff]/g,"**").length;
	}
	/**
	* У�������ֵ���ɴ�����󳤶�
	*/
	function checkMaxlength(oInObj){ 
		var iMaxLen = parseInt(oInObj.getAttribute('maxlength')); 
		var iCurLen = oInObj.value.realLength(); 
		if ( oInObj.getAttribute && iCurLen > iMaxLen ){ 
			alert("¼������ݳ������ֵ��������¼�룡");
			oInObj.focus();
			return false;
		} 
	}
	
	function queryThird(){
		//У���Ƿ�Ϊ������֧������֮ǰ���� begin
		var ifThird = false;
		$.ajax({
			url:'/claim/thirdPayQuery.do'
			,type:'POST'
			,dataType:"text"
			,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
			,data:$(document.fm).serialize()
			,async:false
			,success:function(data){
				var arr  = data.split("##");
				var flag = arr[0];
				var ifThirdPay = (arr[1]==null||arr[1]=="")?"":arr[1].split("&&");
				if(flag=="true"){
					if(ifThirdPay[0]=='YES'){
						ifThird = true;
					}else{
						alert('�ñ�֧�����������'+ifThirdPay[1]+'�����У��ڵ�����֧������ǰ�Ѻ���ͨ�������ڻ����ո�ϵͳ��������¼��֧����Ϣ��');
						ifThird = false;
					}
				}else{
					alert('У��ʧ�ܣ�');
				}
				//buttonTableRemoveDisabled();
			}
			,error:function(){alert('��������');}
		});
		return ifThird;
		//У���Ƿ�Ϊ������֧������֮ǰ���� end
	}
	function saveForm(submitType){
		//��֤�⸶��Ϣҳ���¼��
		buttonTableAddDisabled();
		if(!checkMainInfo()){
		 buttonTableRemoveDisabled();
		 return false;
		 }
		
		if(submitType=='4'){
			//��֤¼��˵����¼
			var direction = $("textarea[name='prpLpayExtNewContext']").val();
			if(direction==null||direction==""){
				alert("��¼��¼��˵��");
				buttonTableRemoveDisabled();
				return false;
			}
		}
		
		if(submitType!=null&&submitType=='2'){
			fm.submitType.value='2';
		}else if(submitType!=null&&submitType=='4'){
			fm.submitType.value='4';
		}else{
			fm.submitType.value='0';
		}
		prplregistOption();
		$.ajax({
			url:'/claim/paymainfiscalSave.do'
			,type:'POST'
			,dataType:"text"
			,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
			,data:$(document.fm).serialize()
			,success:function(data){
				var arr  = data.split("##");
				var flag = arr[0];
				var paymentNo = (arr[1]==null||arr[1]=="")?"":arr[1];
				if(flag=="true"){
					window.onbeforeunload=onClose;
					if(fm.submitType.value=='4'){
						alert('�ύ�ɹ���');
						$("input[type='button']").attr('disabled',"true");
						//window.close();
						goBack();
					}else{
						alert('����ɹ���');
						//window.location="paymainEdit.do?paymentNo="+paymentNo+"&nodeType=apay&editType=EDIT";
						var Datatype = fm.Datatype.value
						//fm.nodeType.value="apay";
						//fm.paymentNo.value=paymentNo;
						//fm.action='paymainEdit.do';
						goBack();
						//fm.action="paymainEdit.do?paymentNo="+paymentNo+"&nodeType=apay&editType=EDIT&Datatype="+Datatype;
						//fm.submit();
					}
				}else{
					alert('����ʧ�ܣ�');
				}
				//buttonTableRemoveDisabled();
				$("input[type=button][value='�ر�']").removeAttr("disabled","");//����ϵͳ����ʱ���������¼��
			}
			,error:function(){alert('��������');}
		});
	}
	function onClose(){
		if(window.opener!=null){
			window.opener.ReceiveValue();//����ͨ���ڵķ�ʽ��ͨ���˷������ø�ҳ��ˢ��ҳ�淽��
		}
	}
	/**
	*	����ĳЩֵ��ˢ��ҳ��
	*/
	function changeValueReload(){
		var url="";
		var registNo= document.getElementById("registNo").value;
		var nodeType= document.getElementById("nodeType").value;
		var editType= document.getElementById("editType").value;
		var paymentNo = document.getElementById("paymentNo").value;
		var isBtn= document.getElementById("isBtn").value;
		//var compensateNo= document.getElementById("compensateNo").value;
		url ="registNo="+registNo+"&nodeType="+nodeType+"&editType="+editType+"&isBtn="+isBtn;//&compensateNo="+compensateNo;
		var compensateNos = document.getElementsByName("compensateNo");
		for(var a=0;a<compensateNos.length;a++){
			url+="&compensateNo="+compensateNos[a].value;
		}
		var payType=$("input[name='payType']").val();
		var paymentType=$("input[name='paymentType']").val();
		url +="&payType="+payType+"&paymentType="+paymentType+"&paymentNo="+paymentNo;
		window.location="/claim/paymainEdit.do?"+url;
	}
		
	//����֪ͨ���ӡ
	function print(){
		//var noticeNo = fm.noticeNo.value;
		var paymentNo = $("input[name='paymentNo']").val();
		var url = "/claim/paymainPrint.do?paymentNo="+paymentNo;
		window.showModalDialog(url,"��ӡ","dialogWidth=756px;dialogHeight=1086px;dialogLeft=5px;center=yes;scroll=yes;");
		//window.open(url);
		//fm.action="/claim/paymainPrint.do";
		//fm.submit();
	}
	/**
	* checkbox��Ϊ������
	*/
	function readonlyAllCheckbox(){
		var elements = document.all;
		var len = elements.length;
		for(i=0; i < len; i++){
			if(elements[i].tagName=="INPUT"){
				tempElements = elements[i];
				if(tempElements.type=="checkbox"){
			    	tempElements.disabled=true;
			    }
				   
			  }
		}
		$("#prpLpayExtNewContext").removeAttr("readOnly");//����ϵͳ����ʱ���������¼��
	}
	/**
	* ɾ����¼
	*/
	function remove(){
		var fiscalno = $("input[name='fiscalno']").val();
		//var registNo= $("input[name='registNo']").val();
		if(typeof(fiscalno) == "undefined"||fiscalno==""){
			//window.close();
			goBack();
		}else{
			if(confirm("ȷ��ɾ����")){
				$.ajax({
					url:'/claim/fiscalpaymainRemove.do'
					,type:'POST'
					,dataType:"text"
					,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
					,data:{'fiscalno':fiscalno}
					,success:function(data){
						if(data=="true"){
							alert('ɾ���ɹ���');
							window.onbeforeunload=onClose;
							//window.close();
							goBack();
						}else{
							alert('ɾ��ʧ�ܣ�');
						}
					}
					,error:function(){alert('��������');}
				});	
			}
		}
	}
	//������ҳ�溯��
	function goBack(){
		var nowUrl = document.URL;
		var nowUrlStr = nowUrl.substring(0,nowUrl.indexOf("?"));
		var preUrl = document.referrer;
		var preu = fm.prevPageUrl.value;
		var Datatype = fm.Datatype.value;
		//alert("@nowUrl="+nowUrl+"   /n@preUrl="+preUrl+"   /n@preu="+preu +"  /n@Datatype="+Datatype);
		if(preUrl==null||preUrl==""){
			window.close();
		}else{
			var preUrlStr=preUrl.substring(0,preUrl.indexOf("?"));
			if(nowUrlStr==preUrlStr){
				//window.history.go(-2);
				if(Datatype!=null&&Datatype=="mergeMany"){
					//var preu = fm.prevPageUrl.value;
					//alert("@preu="+preu);
					window.location=preu;
				}
				window.close();
			}else{
				//Datatype!=null&&Datatype=="mergeMany"&&
				if(preu!=null){
					var toUrl = "";
					if(preu!=null&&preu.indexOf("?")>-1){
						toUrl = preu+"&doQuery=query";
					}else{
						toUrl = preu+"?doQuery=query";
					}
					//alert("###");
					fm.action=toUrl;
					fm.submit();
					//window.location=toUrl;
				}else{
					window.history.go(-1);
				}
				//preUrl = preUrl+"?doQuery=query";
				//window.location=preUrl;
			}
		}
	}
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
	var BGCOLORU="#FFFF00";        //�޸�(��ɫ)
	function setElementColor(DataPageCode)
{
  var i = 0;
  var name = "";
  var elements;
  var elementSelect;
  var color = "";

  //--������flag=="U"�����
  color = BGCOLORU;

  //�õ�Input�������
  
  var count = getElementCount('registNoPay');
  var registNo = '';
  if(count==1){
  	registNo = fm.registNoPay.value;
  }else if(count>1){
  	registNo = fm.registNoPay[0].value;
  }
  
  elements = document.all(DataPageCode).tBodies.item(0).getElementsByTagName("input");
  for(i=0;i<elements.length;i++)
  {
    if(elements[i].type=="button") continue;
    if(elements[i].type=="text"&&fm.all(elements[i].name).value!=fm.all(elements[i].name).title){
      var name = elements[i].name;
      var value = fm.all(elements[i].name).value;
       var parent= $(fm.all(elements[i].name)).parent();
       parent.children().remove();
       parent.html("<input type='hidden' name='"+name+"' value='"+value+"'><a style='color:red' href='###' onclick='queryHistory(\""+name+"\",\""+registNo+"\")'>"+value+"</a>");
    }else if(elements[i].type=="radio"){
    	if(fm.all(elements[i].name)[0].checked==true){
  			if(fm.all(elements[i].name)[0].value!=fm.all(elements[i].name)[0].title){
      			var name = elements[i].name;
      			var value = fm.all(elements[i].name)[0].value;
      			var textvalue = '�����˺�';
       			var parent= $(fm.all(elements[i].name)[0]).parent();
       			parent.children().remove();
       			parent.html("<input type='hidden' name='"+name+"' value='"+value+"'><a style='color:red' href='###' onclick='queryHistory(\""+name+"\",\""+registNo+"\")'>"+textvalue+"</a>");
      		}
	  	}else if(fm.all(elements[i].name)[1].checked==true){
	  		if(fm.all(elements[i].name)[1].value!=fm.all(elements[i].name)[1].title){
	      		var name = elements[i].name;
      			var value = fm.all(elements[i].name)[0].value;
      			var textvalue = '��λ�˺�';
       			var parent= $(fm.all(elements[i].name)[0]).parent();
       			parent.children().remove();
       			parent.html("<input type='hidden' name='"+name+"' value='"+value+"'><a style='color:red' href='###' onclick='queryHistory(\""+name+"\",\""+registNo+"\")'>"+textvalue+"</a>");
	      	}
	  	}
	}
  }
  
  //�õ�Select�������
  elementSelect = document.all(DataPageCode).tBodies.item(0).getElementsByTagName("select");
  for(j=0;j<elementSelect.length;j++)
  {  
  	if(elementSelect[j].type=="button");
	 if(elementSelect.length>0){
	 	if(fm.all(elementSelect.name).value != fm.all(elementSelect.name).title){
		 	 var nameSelect = elementSelect[0].name;
	         var valueSelect = fm.all(elementSelect[0].name).value;
	         var textSelect = elementSelect[0].options[elementSelect[0].selectedIndex].text;
		     var parent= $(fm.all(elementSelect[0].name)).parent();
	         parent.children().remove();
	         parent.html("<input type='hidden' name='"+nameSelect+"' value='"+valueSelect+"'><a style='color:red' href='###' onclick='queryHistory(\""+nameSelect+"\",\""+registNo+"\")'>"+textSelect+"</a>");
		 }
	 }
	 j--;
  }
  
}

function queryHistory(name,registNo){
	var linkURL = "/claim/DAA/payment/queryHistoryShow.jsp?name="+name+"&registNo="+registNo;
	window.showModalDialog(linkURL,window,"dialogWidth=600px;dialogHeight=300px");
}
/**
* ��������
*/
function revoke(){
	if(confirm("ȷ�ϳ�������")){
		var registNo= document.getElementById("registNo").value;
		if(registNo==null||registNo==""){
			registNo= $("input[name='registNoPay']").val();
		}
		var paymentNo = $("input[name='paymentNo']").val();
		$.ajax({
			url:'/claim/paymainRevoke.do'
			,type:'POST'
			,dataType:"text"
			,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
			,data:{'paymentNo':paymentNo,'registNo':registNo}
			,success:function(data){
				if(data=="true"){
					alert('���سɹ���');
					//$(obj).parent().parent().remove();
					//getIndex();
					//window.location.reload(); 
					goBack();
				}else{
					alert('����ʧ�ܣ�');
				}
			}
			,error:function(){alert('��������');}
		});	
	}
	
}
/**
 * ����������͡��͡�������͡��Ĺ���У��
 * 
 */
function checkReceiverAndPaymentType(){
	var receiverType = $("select[name='receiverTypeOther'] option[selected]").val();//���������
	var receiverTypeName = $("select[name='receiverTypeOther'] option[selected]").text();//���������
	//alert("���������:"+receiverType+"   ���������:"+receiverTypeName);
	var checkFlag = false;
	var flags = document.getElementsByName("flag");
	//alert("����=="+flags.length);
	$("input[name='flag']").each(function(){
		//alert("�Ƿ�ѡ�У�"+this.checked);
		if(this.checked){
			var payrefreason = $(this).parent().parent().find("input[name='payrefreason']").val();//֧������
			var payrefreasonName = $(this).parent().parent().find("input[name='payrefreasonChinesName']").val();//֧����������
			if("P60"==payrefreason||"P50"==payrefreason){//���
				if(receiverType=="t04"||receiverType=="t11"||receiverType=="t06"||receiverType=="t08"||receiverType=="t10"
						||receiverType=="t09"||receiverType=="t18"){
					alert("�����Ϊ��"+receiverTypeName+"��ʱ,������֧����"+payrefreasonName+"��");
					checkFlag=true;
				}
			}else if ("P61"==payrefreason||"Y61"==payrefreason){//�����/Ԥ�������
				if(receiverType=="t02"||receiverType=="t03"||receiverType=="t07"||receiverType=="t04"||receiverType=="t18"
						||receiverType=="t11"||receiverType=="t15"||receiverType=="t16"||receiverType=="t17"||receiverType=="t09"){
					alert("�����Ϊ��"+receiverTypeName+"��ʱ,������֧����"+payrefreasonName+"��");
					checkFlag=true;
				}
			}else if ("P62"==payrefreason||"Y62"==payrefreason){//�����鿱��/Ԥ�������鿱��
				if(receiverType=="t01"||receiverType=="t02"||receiverType=="t03"||receiverType=="t05"||receiverType=="t06"
						||receiverType=="t07"||receiverType=="t08"||receiverType=="t09"||receiverType=="t10"||receiverType=="t11"
						||receiverType=="t12"||receiverType=="t13"||receiverType=="t14"||receiverType=="t15"||receiverType=="t16"
						||receiverType=="t17"||receiverType=="t18"){
					alert("�����Ϊ��"+receiverTypeName+"��ʱ,������֧����"+payrefreasonName+"��");
					checkFlag=true;
				}
			}else if ("P611"==payrefreason||"Y611"==payrefreason){//�ٲ÷�/Ԥ���ٲ÷�
				if(receiverType=="t02"||receiverType=="t03"||receiverType=="t04"||receiverType=="t05"||receiverType=="t06"
						||receiverType=="t07"||receiverType=="t08"||receiverType=="t09"||receiverType=="t10"||receiverType=="t11"
						||receiverType=="t15"||receiverType=="t16"||receiverType=="t17"){
					alert("�����Ϊ��"+receiverTypeName+"��ʱ,������֧����"+payrefreasonName+"��");
					checkFlag=true;
				}
			}else if ("P612"==payrefreason||"Y612"==payrefreason){//ִ�з�/Ԥ��ִ�з�
				if(receiverType=="t01"||receiverType=="t02"||receiverType=="t03"||receiverType=="t04"||receiverType=="t06"
						||receiverType=="t07"||receiverType=="t08"||receiverType=="t09"||receiverType=="t10"||receiverType=="t11"
						||receiverType=="t14"||receiverType=="t15"||receiverType=="t16"||receiverType=="t17"||receiverType=="t18"){
					alert("�����Ϊ��"+receiverTypeName+"��ʱ,������֧����"+payrefreasonName+"��");
					checkFlag=true;
				}
			}else if ("P64"==payrefreason||"Y64"==payrefreason){//���Ϸ�/Ԥ�����Ϸ�
				if(receiverType=="t02"||receiverType=="t03"||receiverType=="t04"||receiverType=="t06"||receiverType=="t07"
						||receiverType=="t08"||receiverType=="t09"||receiverType=="t10"||receiverType=="t11"||receiverType=="t15"
						||receiverType=="t16"||receiverType=="t17"||receiverType=="t18"){
					alert("�����Ϊ��"+receiverTypeName+"��ʱ,������֧����"+payrefreasonName+"��");
					checkFlag=true;
				}
			}
			/**
			else if ("P65"==payrefreason||"Y65"==payrefreason){//�ڲ����鿱��/Ԥ���ڲ����鿱��
				if(receiverType=="t04"||receiverType=="t11"||receiverType=="t06"||receiverType=="t08"||receiverType=="t10"||receiverType=="t09"){
					alert("�����Ϊ"+receiverTypeName+"ʱ,������ϲ�"+payrefreasonName);
					checkFlag=true;
				}
			}*/
			else if ("P67"==payrefreason||"Y67"==payrefreason){//�ⲿ���鿱��/Ԥ���ⲿ���鿱��
				if(receiverType=="t01"||receiverType=="t02"||receiverType=="t03"||receiverType=="t04"||receiverType=="t05"
						||receiverType=="t07"||receiverType=="t08"||receiverType=="t10"||receiverType=="t11"
						||receiverType=="t12"||receiverType=="t13"||receiverType=="t14"||receiverType=="t15"||receiverType=="t16"
						||receiverType=="t17"||receiverType=="t18"){
					alert("�����Ϊ��"+receiverTypeName+"��ʱ,������֧����"+payrefreasonName+"��");
					checkFlag=true;
				}
			}else if ("P68"==payrefreason||"Y68"==payrefreason){//��ʦ��/Ԥ����ʦ��
				if(receiverType=="t02"||receiverType=="t03"||receiverType=="t04"||receiverType=="t06"
						||receiverType=="t07"||receiverType=="t08"||receiverType=="t09"||receiverType=="t10"
						||receiverType=="t15"||receiverType=="t16"||receiverType=="t17"||receiverType=="t18"){
					alert("�����Ϊ��"+receiverTypeName+"��ʱ,������֧����"+payrefreasonName+"��");
					checkFlag=true;
				}
			}
			if(checkFlag){
				return false;
			}
		}
	});
	//alert(checkFlag);
	if(checkFlag){
		return false;
	}else{
		return true;
	}
}


</script>
<head>
	<title>֧����Ϣ��ϸ</title>
</head>
<body class="interface"  onload="getPayTotalAmount();<c:if test="${editType eq 'SHOW'}">readonlyAllInput();readonlyAllCheckbox();</c:if>" >
	<form name="fm" action="/claim/payGetherSave.do" method="post" onsubmit="return validateForm(this);">
		<input type="hidden" name="editType" id="editType" value="${editType }" />
		<input type="hidden" name="registNo" id="registNo" value="${registNo }" />
		<input type="hidden" name="submitType" id="submitType" value="0" />
		<input type="hidden" name="Datatype" id="Datatype" value="${Datatype }" />
		<input type="hidden" name="vflag" id="vflag" value="${prplfiscalmainpayDto.vflag }" />
		<input type="hidden" name="prevPageUrl" id="prevPageUrl"  value="${prevPageUrl}">
		<input type="hidden" name="pageConditions" id="pageConditions"  value="${pageConditions}">
		<%--//�жϱ�־������Ԥ�����㻷�ڽ���֧����Ϣҳ�棬�����жϷ����Ƿ����ͨ�� --%>
		<input type="hidden" name="isBtn" id="isBtn" value="${isBtn }" />
		<c:if test="${not empty compensateNos }">
		<c:forEach items="${compensateNos }" var="compensateNo">
			<input type="hidden" name="compensateNo" id="compensateNo" value="${compensateNo }" />
		</c:forEach>
		</c:if>
		<!-- add by xia begin �����¼���Ӵ����� -->
		<input type="hidden" name="handleComCode"  value="${user.comCode }">
		<input type="hidden" name="handlerCode" value="${user.userCode}">
		<input type="hidden" name="handlerName" value="${user.userName}">
		<input type="hidden" name="fiscalno" value="${fiscalno }"/>
		<div class="outcontainer" id="payGetherMain">
			<%-- ũ��������Ϣ --%>
	       	<%@include file="/DAA/payment/DAAPaymainfiscalFarmers.jsp" %>
		    <%-- ũ����������Ϣ --%>
	       	<%@include file="/DAA/payment/DAAPaymainfiscalMainInfo.jsp" %>
		    <%-- ������� --%>
	       	<%@include file="/DAA/payment/DAAPayRegistExt.jsp" %>
		 </div>
		 <c:if test="${from ne 'undwrt' }">
		 <c:if test="${editType ne 'SHOW' }">
		 <c:if test="${isBtn eq 'true' }">
    	 <div id=content_basic style="width: 98%">
	        <table align="center" id="buttonTable">
	        	<tr>
	        		<td> 
						<input type="button" id="saveButton" name="saveButton" class="bobu"  value="����" onclick="saveForm();">
	        		</td>
	        		<td> 
						<input type="button" id="closeButton" name="closeButton" class="bobu"  value="�ر�" onclick="javascript:window.close();">
	        		</td>
	        	</tr>
	        </table>
         </div>
         </c:if>
         <c:if test="${isBtn ne 'true' }">
         <div id=content_basic style="width: 98%">
	         <table align="center" id="buttonTable">
		        	<tr>
		        		
		        		<td> 
							<input type="button" id="saveButton" name="saveButton" class="button"  value="����" onclick="saveForm('2');">
		        		</td>
		        		<td> 
							<input type="button" id="submitButton" name="submitButton" class="button"  value="�ύ" onclick="saveForm('4');">
		        		</td>
		        		<td> 
							<input type="button" id="closeButton" name="closeButton" class="button"  value="�ر�" onclick="goBack();">
		        		</td>
		        		<td> 
							<input type="button" id="removeButton" name="removeButton" class="button"  value="ɾ��" onclick="remove();">
		        		</td>
		        		<td> 
		        		</td>
		        	</tr>
		        </table>
	        </div>
         </c:if>
         </c:if>
         <c:if test="${editType eq 'SHOW' }">
         <div id=content_basic style="width: 98%">
	        <table align="center" id="buttonTable">
	        	<tr>
	        		<td> 
						<input type="button" id="closeButton" name="backButton" class="button"  value="����" onclick="goBack();">
	        		</td>
	        	</tr>
	        </table>
         </div>
         </c:if>
         </c:if>
	</form>
</body>
<c:if test="${from eq 'undwrt' }">

<script type="text/javascript">

</script>
</c:if>