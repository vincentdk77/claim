<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" isELIgnored="false" %>
<%@page import="com.sinosoft.sysframework.reference.AppConfig"%> 
<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
  <script src="/claim/js/WdatePicker.js"></script>
  <%@page language="java" isELIgnored="false" %>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script src="/claim/DAA/compensate/js/z_util.js"></script>
  <script src="/claim/js/DAAReviewEdit.js"></script>
  <script type="text/javascript">
	$(document).ready(function(){
		 <c:if test="${editType eq 'SHOW'}">
			 $("form[name=form2] :input ").attr("disabled","true");
   		 </c:if>
    })
		$(function(){
			initData();
		})
	</script>
    <title>֧����ϸҳ</title>
    <%
    	String node=request.getAttribute("node")+"";
    	String businame1="";
    	String businame="";
    	//��֤
    	if(node.equals("certify")){
    	    businame1="";
    	    businame="";
    	//Ԥ��
    	}else if(node.equals("prepay")){
    	    businame1="Ԥ���";
    	    businame="��������";
    	//����
    	}else if(node.equals("comp")){
    	    businame1="�������";
    	    businame="��������";
    	}
    
    %>

  </head>
  
  <body>
   <form action="" name="form2" method="post">
	<table style="width: 99%" cellpadding="0" cellspacing="0" border="1"
				bordercolor="#3A81C8" class="common">
    	<tr ondblclick="showPage(RegistExtImg9,top9)">
				<td colspan="18" class="tabletitle">
					<div style="padding-left: 3px">
						<img style="cursor: hand;" src="/claim/images/butExpandBlue.gif"
							name="RegistExtImg" id="RegistExtImg9"
							onclick="showPage(this,top9)">
						<span>֧��¼��</span>
					</div>
				</td>
			</tr>
    	<tr>
		<tbody id="top9" style="">
    		<td colspan="9"  align="center"  width="100%" height="100%">
    			<table style="margin-top:4px;border-collapse:collapse;" class="common mycommon"  width="99%" id="mytab"  cellpadding="0"  cellspacing="0" border="1" bordercolor="#3A81C8">
    					<c:forEach items="${payinfoList}" var="pif" varStatus="status">
    				<tbody class="divpayflag${pif.payflag}">
				    	<tr>
				    		<td class=""  style="background-color:#D8E3F3;width:5%">
				    			���
				    			<input type="hidden" name="payflag" value="${pif.payflag}">
				    		</td>
				    		<td  class="title" style="width:6%;padding-left: 0px;">
				    			������
				    		</td>
				    		<td   colspan="2">
				    		<input type="text" name="registNo_payment" value="${pif.registno}" class="readonly">
				    			<input type="hidden" name="kindcode_payment" value="bz">
				    		</td>
				    		<td class="title"  style="width: 10%">
				    			<%=businame1%>
				    		<input type="hidden" name="riskcode_payment" value="${codeMap.riskCode.busiRiskCode}">
				    		</td>
				    		<td width="20%" colspan="2" >
				    		<input type="text" value="${pif.compensateno }" id="compensateno" name="compensateno" class="readonly" readonly="readonly">
				    		</td>
				    		<td class="title"><%=businame %></td>
				    		<td style="">
				    			<%
				    			if(businame!=null&&!businame.equals("")){
				    			    %>
					    			<select name="claimno">
										<c:if test="${claimNoMap.busiClaimNo!=''&&claimNoMap.busiClaimNo!=null and pif.claimno eq claimNoMap.busiClaimNo}">
											<option value="${claimNoMap.busiClaimNo},${policyNoMap.business},${codeMap.riskCode.busiRiskCode}" <c:if test="${pif.claimno eq claimNoMap.busiClaimNo }" > selected </c:if> >${claimNoMap.busiClaimNo}</option>				    				
										</c:if>			    				
										<c:if test="${claimNoMap.bzClaimNo!=''&&claimNoMap.bzClaimNo!=null and pif.claimno eq claimNoMap.bzClaimNo}">
											<option value="${claimNoMap.bzClaimNo},${policyNoMap.bz},${codeMap.riskCode.bzRiskCode}" <c:if test="${pif.claimno eq claimNoMap.bzClaimNo }" > selected </c:if>  >${claimNoMap.bzClaimNo}</option>
										</c:if>	
					    			</select>
				    			    <%
				    			}
				    		%>
				    		</td>
				    		<td rowspan="7" style="width:4%"  >
				    			<input type="button" class="smallbutton" onclick="" value="-">
				    		</td>
				    	</tr>
				    	<tr>
				    		<td rowspan="6" style="width:10px;"  id="tdindex" class="indextd" align="center">
				    			<input type="hidden" value="0" style="width:10px" name="serialno">${status.index+1}
				    		</td>
				    		
				    		<td class="title" style="width:8%">֧������</td>
				    		<td width="15%"  colspan="2">
				    			<select name="paytype" >
				    			
				    				<option value="" >��ѡ��</option>
				    				<option value="P1" ${pif.paytype=='P1'?'selected':''}>Ԥ��</option>
				    				<option value="P2" ${pif.paytype=='P2'?'selected':''}>֧��</option>
				    				<option value="P3" ${pif.paytype=='P3'?'selected':''}
				    				<% 
				    					if(node.equals("comp")){//���㻷��
				    					    out.print("selected");
				    					}
				    				%> 
				    				>ʵ��</option>
				    				<option value="P4" ${pif.paytype=='P4'?'selected':''}>�渶</option>
				    				<option value="P5" ${pif.paytype=='P5'?'selected':''}>�᰸֧��</option>
				    			</select>
				    		</td>
				    		<td class="title" style="width:10%">���������</td>
				    		<td width="15%"  colspan="2">
				    			<select style="width: 98" name="receivertype">
				    				<option value="t1" ${pif.receivertype=='t1'?'selected':'' }>��������</option>
				    				<option value="t2" ${pif.receivertype=='t2'?'selected':'' }>ί�и��˴�������</option>
				    				<option value="t3" ${pif.receivertype=='t3'?'selected':'' }>ί�е�λ��������</option>
				    			</select>
				    		</td>
				    		<td class="title" style="width:8%">֧�����</td>
				    		<td >
				    			<input type="text" value="${pif.payamount}"  name="payamount"  style="width:90%">
				    		</td>
				    		
				    	</tr>
				    	<tr>
				    		<td class="title">��������</td>
				    		<td colspan="5" >
				    			<div class="div_1" name="bank">
				    				${pif.bank}
				    			</div><font color="red" style="height: 100%">*</font>
				    		</td>
				    		<td class="title">�������</td>
				    		<td  style="">
				    			<select name="paymenttype" >
				    				<c:forEach items="${paymenttype1}" var="type">
					    				<option value="${type.codeCode}" ${type.codeCode==pif.paymenttype?'selected':''}>${type.codeCName}</option>
				    				</c:forEach>
				    			</select>
							</td>
				    	</tr>
				    	<tr>
				    		<td class="title" style="width: 5%">�����˺�</td>
				    		<td  colspan="5">
				    			<div id="div_2" class="div_2"  style="" name="bankno">${pif.bankaccount}</div><font  style="color: red;;height: 100%;">*</font>
				    			
				    		</td>
				    		<td class="title" style="width: 5%">�˺�ȷ��</td>
				    		<td  colspan="">
				    			<div id="div_3" class="div_3" style="width: 91%" name="rebankno">${pif.bankaccount}</div>
				    		</td>
				    	</tr>
				    	<tr>
				    		
				    		<td class="title" style="width: 5%">�����ȫ��</td>
				    		<td colspan="5" >
				    			<div id="div_4" class="div_4" name="receiverfullname">${pif.receiverfullname}</div><font  style="color: red;;height: 100%;">*</font>
				    		</td>
				    		<td class="title" style="width:8%">��ϵ�绰</td>
				    		<td  >
				    			<input type="text" name="familyphone" value="${pif.familyphone}" >
				    		</td>
				    	</tr>
				    	
			    	</div>
			    	</tbody>
			    	</c:forEach>
    			</table>

    		</td>
    	</tr>
    	<tr style="padding-top: 0px;margin-top: 0px">
    		<td colspan="1" style="width:13%;margin-top: 0px;padding-top: 0px;background-color: #D8E3F3">֧��˵��</td>
    		<td colspan="6" style="disabled:true">
    			<textarea rows="2" name="payremark" cols="4" maxlen="150" cnname="֧��˵��" style="width:99% ">${payremark}</textarea>
    		</td>
    		<td   align="right"  style="padding-right:8px;width: 10%;">
    			<input type="button" class="smallbutton" value="+" onclick="" disabled="disabled">
    		</td>
    	</tr>
	</tbody>
    </table>
			<div id="outcontainer" style="width:100%;padding-bottom: 8px;padding-top: 0px;">
   <div id="content_basic" style="width:99%;">
	   <span style="width:99%;text-align:left;font-size:12px">
	    <img  style="cursor:hand;" src="/claim/images/butExpandBlue.gif" name="RegistExtImg" onclick="showPage(this,RegistExt)">
	    ����˵��<font color="red"></font></span>
       
	     
			<table id="RegistExt" class="common" cellpadding="0"  cellspacing="0" border="1" bordercolor="#3A81C8">
			      <tr>
			      <td class="title" style="width:10%;text-align: center;">������</td>
			      <td class="title" style="width:14%;text-align: center;">����ʱ��</td>
			      <td class="title" style="width:15%;text-align: center;">����Ա</td>
			      <td class="title" style="width:16%;text-align: center;">����</td>
			      <td class="title" style="width:15%;text-align: center;">��ϵ�绰</td>
			      <td class="title" style="width:30%;text-align: center;" >����˵��</td>
			      </tr>
			      <c:forEach items="${prpLregistExtDtoList}" var="prpLregistExtDto" varStatus="count">
			      <c:if test="${prpLregistExtDto.checkStatus eq 0}">
			      		<input type="hidden" name="serialNoExt" id="serialNoExt" value="${prpLregistExtDto.serialNo}">
				      	<input type="hidden" name="riskCodeExt" id="riskCodeExt" value="${prpLregistExtDto.riskCode}">
				      	<input type="hidden" name="nodeTypeExt" id="nodeTypeExt" value="${prpLregistExtDto.nodetype}">
				      	<input type="hidden" name="checkStatusExt" id="checkStatusExt" value="${prpLregistExtDto.checkStatus}">
			      		<tr>
				      		<td class="input" align="center" style="width:10%;">
				      			${prpLregistExtDto.nodetypeName}
				      			<input type="hidden" id="nodeTypeExt" class="input" name='nodetypeExt' value="${prpLregistExtDto.nodetype}"/>
				      		</td>
				      		<td class="input" align="center" style="width:14%;">
				      			${prpLregistExtDto.inputDate} ${prpLregistExtDto.inputHour} 
				      			<input type="hidden" id="prpLregistInputDateExt" class="input" name='prpLregistInputDateExt' value="${prpLregistExtDto.inputDate}" />
				      			<input type="hidden" id="prpLregistInputHourExt" class="input" name='prpLregistInputHourExt' value="${prpLregistExtDto.inputHour} " />
				      		</td>
				      		<td class="input" align="center" style="width:15%;">
				      			${prpLregistExtDto.operatorCodeName}
				      			<input type="hidden" id="operatorCodeExt" class="input" name='operatorCodeExt' value="${prpLregistExtDto.operatorCode}" />
				      		</td>
				      		<td class="input" align="center" style="width:26%;">
				      			${prpLregistExtDto.comCName}
				      			<input type="hidden" id="comCodeExt" class="input" name='comCodeExt' value="${prpLregistExtDto.comCode}" />
				      		</td>
				      		<td class="input"  align="center" style="width:15%;">
				      			${prpLregistExtDto.linkphone}
				      			<input type="hidden" id="linkphoneExt" class="input" name='linkphoneExt' value="${prpLregistExtDto.linkphone}" />
				      		</td>
				      		<td class="input" align="left" width="30%" style="word-break: break-all">
				      				${prpLregistExtDto.context}
				      			<input type="hidden" id="contextExt" class="input" name='contextExt' value="${prpLregistExtDto.context}" />
				      		</td>
				      	</tr>
			      </c:if>
			      </c:forEach>
	          </table>
	</div>
  </div>
	</form>		
  </body>
<script type="text/javascript">

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
        	<c:forEach items="${uppayList}" var="dto">
				<c:if test="${dto.bank!=''}">
					options.push('${dto.bank}');//��������
				</c:if>
				<c:if test="${dto.bankaccount!=''}">
					bankaccountoptions.push('${dto.bankaccount}');//���к���
					rebankaccountoptions.push('${dto.bankaccount}');//ȷ�Ϻ���
				</c:if>
				<c:if test="${dto.receiverfullname!=''}">
					nameoptions.push('${dto.receiverfullname}');//�տ�������
				</c:if>
			</c:forEach>
			//alert(11);
        	var param={divclass:'div_1',option:options};
        	fu.style.editSelect(param);
        	var param={divclass:'div_2',option:bankaccountoptions};
        	fu.style.editSelect(param);
        	//ȷ�Ϻ���
        	var param={divclass:'div_3',option:rebankaccountoptions};
        	fu.style.editSelect(param);
        	var param={divclass:'div_4',option:nameoptions};
        	fu.style.editSelect(param);
        	
        	//�Ѿ�֧�����Ĳ������޸�
			$(".divpayflag1 input").attr("disabled","true");
			$(".divpayflag1 select").attr("disabled","true");
			$("textarea[name=payremark]").attr("disabled","true");
		
	}

</script>
<script><%--
	//ifrom ����Ӧ�߶� showlist ifrom ���� begin
	parent.document.all("showlist").style.width=document.body.scrollWidth; 
	parent.document.all("showlist").style.height=document.body.scrollHeight; 

	
	
	var iframe = parent.document.getElementById("showlist");
	var bHeight = iframe.contentWindow.document.body.scrollHeight;
	var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
	//ifrom ����Ӧ�߶� showlist ifrom ���� end
--%></script>
</html>
