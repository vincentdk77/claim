<%--
****************************************************************************
* DESC       ���طò�ѯ
* AUTHOR     ��chengyupeng
* CREATEDATE ��2011-12-28
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page language="java" pageEncoding="GBK"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime" %>
<%@ page import="com.sinosoft.claim.bl.facade.BLPrpDriskFacade" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.DateTime" %>
<%@ page import="com.sinosoft.claim.dto.domain.PrpDriskDto" %>
<%
   DateTime strFlowinTime = new DateTime().current();
   strFlowinTime.setTime(System.currentTimeMillis() - Long.parseLong("7776000000"));
   
   List riskCodeCollection = (List)new BLPrpDriskFacade().findRiskCodeByConditions(" k.validstatus = '1'");
   String[] riskCategory = new String[riskCodeCollection.size()];
   String[] riskCode = new String[riskCodeCollection.size()];
   String[] riskName = new String[riskCodeCollection.size()];
   PrpDriskDto prpdRiskDto = null;
   for(int i=0; i<riskCodeCollection.size(); i++)
   {
	   prpdRiskDto = (PrpDriskDto)riskCodeCollection.get(i);
       riskCategory[i] = prpdRiskDto.getRiskType();
       riskCode[i] = prpdRiskDto.getRiskCode();
       riskName[i] = prpdRiskDto.getRiskCName();
   }
   
%>
<html>
	<head>
		<title>�طò�ѯ</title>
		<%-- ҳ����ʽ  --%>
		<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
		<link rel="stylesheet" type="text/css" href="/claim/css/tableType.css">
		<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
		<jsp:include page="/common/pub/StaticJavascript.jsp" />
		<!-- my97ʱ��ؼ� -->
		<script language="javascript" type="text/javascript" src="/claim/js/WdatePicker.js"></script>
		<script src="/claim/common/js/SimpleCalendar.js"></script>
		<script src="/claim/common/js/Common.js"></script>
		<script src="/claim/workflow/flow/js/WorkFlowFlowBeforeQuery.js"></script>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	</head>

	<body>
		<form name="fm" action="/claim/returnVisitQueryEdit.do" method="post" onsubmit="" target="showlist">
			<input type="hidden" id="editType" name="editType" value="${editType}"/>
			<table cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8" class="common">
				<tr ondblclick="showPage(RegistExtImg9,top9)">
					<td colspan="6" class="tabletitle">
						<div style="padding-left: 3px">
							<img style="cursor: hand;" src="/claim/images/butExpandBlue.gif" name="RegistExtImg" id="RegistExtImg9" onclick="showPage(this,top9)">
							<span>��ѯ����</span>
						</div>
					</td>
				</tr>
				<tbody id="top9">
					<tr>
						<td class='title w15 textr pright5'>��������(Ͷ�߱��)��</td>
						<td class='input w35 pleft5'>
							<select class=tag name="registNoSign">
								<option value="*">
									*
								</option>
								<option value="=">
									=
								</option>
							</select>
							<input type=text name="registNo" class="query">
						</td>
						<td class='title w15 textr pright5''>�������룺</td>
						<td class='input pleft5'>
							<select class=tag name="policyNoSign">
								<option value="*">
									*
								</option>
								<option value="=">
									=
								</option>
							</select>
							<input type=text name="policyNo" class="query">
						</td>
					</tr>
					<tr>
						<td class='title textr pright5'>�ѻط�ʱ��</td>
							<td class='input pleft5'>
								<input style="width: 35%" name="enteringtimeBegin" class="Wdate"
									onfocus="WdatePicker()">
								����
								<input style="width: 35%" name="enteringtimeEnd" class="Wdate"
									onfocus="WdatePicker()">
						</td>
						
						<td class='title textr pright5''>����ʱ�䣺</td>
						<td class='input pleft5'>
							<input style="width: 35%" name="reportdateBegin" class="Wdate"
								onfocus="WdatePicker()">
							����
							<input style="width: 35%" name="reportdateEnd" class="Wdate"
								onfocus="WdatePicker()">
						</td>
					</tr>
					<tr>
						<td class='title textr pright5''>�������ˣ�</td>
						<td class='input pleft5'>
							<select class=tag name="insurednameSign">
								<option value="*">
									*
								</option>
								<option value="=">
									=
								</option>
							</select>
							<input type=text name="insuredname" class="query">
						</td>
						<td class='title textr pright5''>�᰸ʱ�䣺</td>
						<td class='input pleft5'>
							<input style="width: 35%" name="endcasedateBegin" class="Wdate"
								onfocus="WdatePicker()">
							����
							<input style="width: 35%" name="endcasedateEnd" class="Wdate"
								onfocus="WdatePicker()">
						</td>
					</tr>
					<tr>
						<td class='title textr pright5''>�ط����ͣ�</td>
						<td class='input pleft5'>
							<select name="nodeType" onchange="nodeTypeObj(this);">
								<option value="0">��ѡ��</option>
								<option value="sched">�ɹ��ط�</option>
								<option value="endca">�᰸�ط�</option>
								<option value="compl">Ͷ�߻ط�</option>
							</select>
						</td>
						<td class='title textr pright5''>�طñ�־��</td>
						<td class='input pleft5'>
							<select name="nodeMark" >
								<option value="0" selected="selected">δ�ط�</option>
								<option value="20">�ѻط�δ�ɹ������������</option>
								<option value="21">�ѻط�δ�ɹ����������</option>
								<option value="4">�ѻط��ѳɹ�</option>
								<option value="024">ȫ��</option>
								
							</select>
						</td>
					</tr>
						<tr>
							<td class='title textr pright5'>�ͻ����ͣ�</td>
							<td class='input pleft5'>
								<select name="customerType" id="customerType">
									<option value="2" selected="selected">��λ</option>
									<option value="1">����</option>
									<option value="0">ȫ��</option>
								</select>
							</td>
							<td class='title textr pright5'>֧����־��</td>
							<td class='input pleft5'>
								<select name="payType" id="payType" disabled="disabled" onchange="setPayDate(this)">
									<option value="0" selected="selected">��֧��</option>
									<option value="1">δ֧��</option>
									<option value="2">ȫ��</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class='title textr pright5'>֧��ʱ�䣺</td>
							<td class='input pleft5'>
								<input style="width: 35%" name="paydateBegin" class="Wdate"
									onfocus="WdatePicker()">
								����
								<input style="width: 35%" name="paydateEnd" class="Wdate"
									onfocus="WdatePicker()">
							</td>
							<td class='title textr pright5'>���ִ��ࣺ</td>
       						 <td class='title'>
       					<select class="common" name="riskCategory"  id="riskCategory";
                               onchange="buildRiskCodeSelect(fm.riskCategory, fm.prpLregistRiskCode);">
                            <option value="">��ѡ��</option>
                            <option value="Y">ˮ��</option>
                            <option value="Q">��ˮ</option>
                            <option value="E">�⽡</option>
                            <option value="H">��ֲ</option>
                            <option value="I">��ֳ</option>
                        </select>
     					</td>
					    </tr>
						
						<tr>
						<td class='title textr pright5' >���֣�</td>
        				<td class="input">
           			   <select class=tag name="RiskCodeSign" style="display:none">
               				 <option value="=">=</option>
           			   </select> 
           				 <input type="hidden" name="riskCodeTag" value="=">
            			<select class="common" id ="prpLregistRiskCode" name="prpLregistRiskCode">
            			
            			</select>
       				 </td>
					   </tr>
					<tr>
						<td class='title textc' colspan="4">
							<input type=button class='bobu' value="��ѯ" onClick="submitForm('1');">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<iframe id="showlist" name="showlist" src="" height="100%" frameborder="0" marginheight="0" marginwidth="0" scrolling="no" width="100%"></iframe>
	</body>
	<script type="text/javascript">
		function submitForm(id){
			var nodeType = $("select[name=nodeType]").val();
			if(nodeType == '0'){
				alert("��ѡ��ط����ͣ�");
				return false;
			}
			if(id == '1'){
				document.getElementById('editType').value='SHOW';
				var nodeMark = $("select[name=nodeMark]").val();
				var enteringtimeBegin = $("input[name='enteringtimeBegin']").val();
				var enteringtimeEnd = $("input[name='enteringtimeEnd']").val();
				if(nodeMark == 0 && (enteringtimeBegin!="" || enteringtimeEnd!="")){
					if(!confirm("��ȷ��δ�ط�ʱ,�ѻط�ʱ���Ƿ���ڣ�\n����ִ�е����ȷ��������������ȡ������")){
						return false;
					}
				}
			}
			if(id == '2'){
				
			}
			fm.submit();
		}
		function nodeTypeObj(obj){
			var nodeType = obj.value;
			if(nodeType == "sched"){
				document.getElementById('endcasedateBegin').disabled="disabled";
				document.getElementById('endcasedateEnd').disabled="disabled";
				document.getElementById('endcasedateBegin').value="";
				document.getElementById('endcasedateEnd').value="";
				document.getElementById('payType').disabled="disabled";
				document.getElementById('payType').value="0";
				document.getElementById('customerType').value="2";
				document.getElementById('customerType').disabled="";
				document.getElementById('paydateBegin').disabled="disabled";
				document.getElementById('paydateEnd').disabled="disabled";
				document.getElementById('riskCategory').disabled="";
				document.getElementById('prpLregistRiskCode').disabled="";
			}else if(nodeType == "endca"){
				document.getElementById('payType').disabled="";
				document.getElementById('payType').value="0";
				document.getElementById('endcasedateBegin').disabled="";
				document.getElementById('endcasedateEnd').disabled="";
				document.getElementById('endcasedateBegin').value="<%=new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY).addDay(-10) %>";
				document.getElementById('endcasedateEnd').value="<%=new DateTime(DateTime.current().toString()) %>";
				document.getElementById('customerType').value="2";
				document.getElementById('customerType').disabled="";
				document.getElementById('paydateBegin').disabled="";
				document.getElementById('paydateEnd').disabled="";
				document.getElementById('riskCategory').disabled="";
				document.getElementById('prpLregistRiskCode').disabled="";
			}else{
				document.getElementById('endcasedateBegin').disabled="";
				document.getElementById('endcasedateEnd').disabled="";
				document.getElementById('endcasedateBegin').value="";
				document.getElementById('endcasedateEnd').value="";
				document.getElementById('payType').disabled="disabled";
				document.getElementById('payType').value="0";
				document.getElementById('customerType').value="0";
				document.getElementById('customerType').disabled="";
				document.getElementById('riskCategory').disabled="disabled";
				document.getElementById('riskCategory').value="";
				document.getElementById('prpLregistRiskCode').disabled="disabled";
				document.getElementById('prpLregistRiskCode').value="";
			}
		}
		function setPayDate(obj){
			var nodeType = obj.value;
			if(nodeType == "0"){
				document.getElementById('paydateBegin').disabled="";
				document.getElementById('paydateEnd').disabled="";
			}else{
				document.getElementById('paydateBegin').disabled="disabled";
				document.getElementById('paydateEnd').disabled="disabled";
			}
		}
		
	 var riskCodeCount = <%=riskCodeCollection.size()%>;
     var riskCodes = new Array();
    <%for(int i=0; i<riskCodeCollection.size(); i++){%>
        riskCodes[<%=i%>] = new Array("<%=riskCategory[i]%>", "<%=riskCode[i]%>", "<%=riskName[i]%>");
    <%}%>
	</script>
</html>