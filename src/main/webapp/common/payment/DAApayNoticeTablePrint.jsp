<%--
****************************************************************************
* DESC       ������֪ͨ���ӡҳ��
* AUTHOR     ��zhongfen
* CREATEDATE ��2013-07-19
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/DAA/payment/lib/smsx.cab";
%>
<%-- ��ʼ�� --%>
<html>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

<div align="center" id="divButton" style="display:">
<!--<object id="factory" viewastext style="display:none" classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814"  -->
<!--	codebase="<%=basePath %>">  -->
</object>
</div>
<style type="text/css">
	tr{
		height: 27px;
	}
     .borderbottom{
       border-bottom-color:transparent;
     }
   input.payfor{
	width:450;
	border: none;
	border-bottom: 1px solid #000000;
    }
    .divcss5{ width:620px;}
</style>
<script type="text/javascript">
function printPage(){
  	document.getElementById("buttonClose").style.display="none";
  	document.getElementById("buttonPrint").style.display="none";
    //factory.printing.header = "";//ҳü
    //factory.printing.footer = "";//ҳ��
    //factory.printing.leftMargin = 0.75;//��߾�
    //factory.printing.topMargin = 0.75;//�ϱ߾�
    //factory.printing.rightMargin = 0.75;//�ұ߾�
    //factory.printing.bottomMargin = 0.75;//�±߾�
    //factory.printing.portrait = false;//��ӡ����true:����.false:����
    //factory.DoPrint(false);//����Ϊfalse��ֱ�Ӵ�ӡ
    window.print()

}

</script>
<%
	int i = 1;
 %>
<body onload="" style="text-align:center;">
<!-- ���ⲿ�� -->
<br>
<table cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse;font-size: 9.5pt" bordercolor="black">
<tr height="40">
  <td colspan="2" height="40" align="center" style="font-family:����; font-size:14pt;">            
    <img src="/claim/images/logoPrint.jpg"/>
  </td>
</tr>      
  <tr>
    <td colspan="3" height="40"  align=center style="font-family:����; font-size:14pt;">
      <B>����֪ͨ��<B>
    </td>
  </tr>
</table>
<table class="common" border="1" cellpadding="0" cellspacing="0" style="width:620px;border-collapse: collapse;border-bottom-style: none;" bordercolor="black">
   <tr>
       <td style="text-align:center;width:10%" >
      	�ո����
       </td>
       <td style="text-align:center;width:30%" colspan="3">
      	${paymentNo }
       </td>
       <td style="text-align:center;width:20%" >
      	���������
       </td>
       <td style="text-align:center;width:40%" colspan="2">
      	${receiverfullname }
       </td>
  </tr>
   <tr>
       <td style="text-align:center;width:10%">
      	��������
       </td>
       <td style="width:90%" colspan="6">
      	&nbsp;${yearTemp }��${monthTemp }��${dayTemp }�ձ���˾������ˣ�${receiverfullname }��֧���������������������ϸ�嵥��
       </td>
  </tr>
  <tr>
       <td class=" borderbottom" style="text-align:center;width:10%;">
      	�����ܶ�
       </td>
       <td class=" borderbottom" style="width:70%;" colspan="4">
       	����д����${chineseMoney }
       </td>
       <td class=" borderbottom" style="width:20%;" colspan="2">
       	��Сд����${sumpay }
       </td>
  </tr>
</table>
<table class="common" border="1" cellpadding="0" cellspacing="0" style="width:620px;border-collapse: collapse;" bordercolor="black" >
  <tr>
  	<td style="text-align:center;" colspan="7">��ϸ�嵥</td>
  </tr>
  <tr>
		<td style="text-align:center;" width="6%">��� </td>
		<td style="text-align:center;" width="19%">������ </td>
		<td style="text-align:center;" width="28%">�������</td>
		<td style="text-align:center;" width="22%">�������� </td>
		<!-- <td style="text-align:center;" width="12%">���ƺ��� </td> -->
		<td style="text-align:center;" width="13%">�������</td>
		<td style="text-align:center;" width="14%">֧����� </td>
  </tr>
	
	<c:forEach items="${prplpayList }" var="prplpayDto" varStatus="number" >
		<tr>
			<td style="text-align:center;">${number.index+1 }</td>
			<td style="text-align:center;">${prplpayDto.registno }</td>
			<td style="text-align:center;">${prplpayDto.compensateno }</td>
			<td style="text-align:center;">${prplpayDto.insuredName }</td>
			<!-- <td style="text-align:center;">${prplpayDto.licenseNo }</td> -->
			<td style="text-align:center;">
			<c:forEach items="${paymentTypeMap }" var="paymentType">
				<c:if test="${paymentType.key eq  prplpayDto.paymenttype}">${paymentType.value }</c:if>
			</c:forEach>
			</td>
			<td style="text-align:right;">${prplpayDto.payamount }</td>
		</tr>
		<c:if test="${fn:length(prplpayList)==number.count }">
			<c:if test="${number.count<pagePrintSize }">
				<c:forEach begin="${fn:length(prplpayList)+1 }" end="${pagePrintSize}" var="i">
				<tr>
					<td style="text-align:center;">${i} </td>
					<td style="text-align:center;"> </td>
					<td style="text-align:center;"> </td>
					<td style="text-align:center;"> </td>
					<!-- <td style="text-align:center;"> </td> -->
					<td style="text-align:center;"> </td>
					<td style="text-align:right;"> </td>
				</tr>
				</c:forEach>
			</c:if>
		</c:if>
	</c:forEach>
	<tr>
		<td class=" borderbottom" colspan="4">�б���������Ԫũҵ���չɷ����޹�˾${comCname }</td>
		<td class=" borderbottom" colspan="3">֧�����ڣ�${yearTemp }��${monthTemp }��${dayTemp }��</td>
	</tr>
</table>
	<c:forEach items="${list2 }" var="prplpayDto1" varStatus="number" >
		<c:if test="${number.index%pagePrintSize == 0 }">
			<div align="right" class="divcss5">
				<table border="0"  cellpadding="0" cellspacing="0"  style="width:620px;border-collapse: collapse;font-size: 9.5pt" >
				   <tr>
				     <td class=" borderbottom" style="text-align:right;">�� ${strpage } ҳ  ��  <%=i++ %> ҳ</td>
				   </tr>
				</table>
			</div>
			<div STYLE="page-break-after: always;">&nbsp;</div>
			
			<br>
			<br>
			<table class="common" border="1" cellpadding="0" cellspacing="0" style="width:620px;border-collapse: collapse;font-size: 9.5pt;border-bottom-style: none;" bordercolor="black">
			</table>
		</c:if>
		
			<table class="common" border="1" cellpadding="0" cellspacing="0" 
					style="width:620px;border-collapse: collapse;font-size: 9.5pt;border-top-style: none;<c:if test='${(number.index%pagePrintSize!=2) and (fn:length(list2)!=number.count) }'>border-bottom-style: none;</c:if>" 
					bordercolor="black">
				<tr <c:if test="${number.index%pagePrintSize != 0 }">style="display:none"</c:if>>
		  			<td style="text-align:center;" colspan="7">��ϸ�嵥</td>
		  		</tr>
			  	<tr <c:if test="${number.index%pagePrintSize != 0 }">style="display:none"</c:if>>
					<td style="text-align:center;" width="6%">��� </td>
		<td style="text-align:center;" width="19%">������ </td>
		<td style="text-align:center;" width="28%">�������</td>
		<td style="text-align:center;" width="22%">�������� </td>
		<!-- <td style="text-align:center;" width="12%">���ƺ��� </td> -->
		<td style="text-align:center;" width="13%">�������</td>
		<td style="text-align:center;" width="14%">֧����� </td>
			  	</tr>
			<tr>
				<td <c:if test="${number.count%pagePrintSize!=0 }">class=" borderbottom"</c:if> style="text-align:center;" width="4%">${number.index+pagePrintSize+1 }</td>
				<td <c:if test="${number.count%pagePrintSize!=0 }">class=" borderbottom"</c:if> style="text-align:center;" width="17%">${prplpayDto1.registno }</td>
				<td <c:if test="${number.count%pagePrintSize!=0 }">class=" borderbottom"</c:if> style="text-align:center;" width="25%">${prplpayDto1.compensateno }</td>
				<td <c:if test="${number.count%pagePrintSize!=0 }">class=" borderbottom"</c:if> style="text-align:center;" width="21%">${prplpayDto1.insuredName }</td>
				<!-- <td <c:if test="${number.count%pagePrintSize!=0 }">class=" borderbottom"</c:if> style="text-align:center;" width="12%">${prplpayDto1.licenseNo }</td> -->
				<td <c:if test="${number.count%pagePrintSize!=0 }">class=" borderbottom"</c:if> style="text-align:center;" width="11%">
				<c:forEach items="${paymentTypeMap }" var="paymentType">
					<c:if test="${paymentType.key eq  prplpayDto1.paymenttype}">${paymentType.value }</c:if>
				</c:forEach>
				</td>
				<td <c:if test="${number.count%pagePrintSize!=0 }">class=" borderbottom"</c:if> style="text-align:right;" width="11%">${prplpayDto1.payamount }</td>
			</tr>
			<c:if test="${fn:length(list2)==number.count && number.count%pagePrintSize!=0 }">
				<c:forEach begin="${1 }" end="${pagePrintSize-fn:length(list2)%pagePrintSize}" var="i">
				<tr>
					<td style="text-align:center;">${i+number.count+pagePrintSize} </td>
					<td style="text-align:center;"> </td>
					<td style="text-align:center;"> </td>
					<td style="text-align:center;"> </td>
					<!-- <td style="text-align:center;"> </td> -->
					<td style="text-align:center;"> </td>
					<td style="text-align:right;"> </td>
				</tr>
				</c:forEach>
			</c:if>
			</table>
	</c:forEach>
<div align="right" class="divcss5">
<table border="0"  cellpadding="0" cellspacing="0"  style="border-collapse: collapse;font-size: 9.5pt" >
   <tr>
     <td style="text-align:right;">�� ${strpage } ҳ  ��  <%=i++ %> ҳ</td>
   </tr>
</table>
</div>
<br>
<table border="0" cellpadding="0" cellspacing="0" bordercolor="#dAe1e8" style="width:99%;">
<tr id="BTN">
       <td style="text-align:left; font-family:����; font-size:12pt;">
       <input  type="button" id="buttonPrint" style="" class="button" value="��ӡ" onclick="printPage()"/>
       <input  type="button" id="buttonClose" style="" class="button" value="����" onclick="window.close();"/>
       </td>
  </tr>
</table>
</body>
</html>