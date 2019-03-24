<%--
****************************************************************************
* DESC       ����ʾ�������ձ������ҳ��
* AUTHOR     ��qinyongli
* CREATEDATE ��2005-09-20
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.util.*"%>
<%@page import="com.sinosoft.prpall.pubfun.PubTools"%>
<html>
<head>
  <title>������ϸ��Ϣ</title>
  <%-- ���ú��� --%>
 
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/common/modifySumClaim/js/PropClaimEdit.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
</head>
<%
  String  editType=(String)request.getAttribute("editType");
  String policyInputDate =(String)request.getAttribute("policyInputDate");
  String  isShow=(String)request.getAttribute("isShow");
%>
<body class="interface" onload="initPage();">
<form name="fm" action="/claim/modifySumClaim.do"  method="post"  onsubmit="return validateForm(this);">
   <input type="hidden" name="editType" value="modifySave">
   <table  border="0" align="center" cellpadding="4" cellspacing="1"  class="title" style="width:100%">
       <tr>
	  <td colspan="4" class="formtitle">����������ϸ��Ϣ</td>
      </tr> 
      <tr>
        <td class="title" style="width:15%">������:</td>
        <td class="input" style="width:36%" >
           <input type=text name="prpLclaimClaimNo" title="������" maxlength="22" class="readonly" readonly="true"  value="<bean:write name='prpLclaimDto' property='claimNo' filter='true' />">
        </td>
        <td class="title">������:</td>
        <td class="input" colspan=3>
          <input type=text name="prpLclaimRegistNo" title="������" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLclaimDto' property='registNo' filter='true' />">
        </td>
      </tr>
      <tr>
        <td class="title" >������:</td>
        <td class="input" >
          <input type=text name="policyno" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />">
        </td>
        <td class="title">��������:</td>
        <td class="input" colspan='3' > 
            <bean:write name='prpLclaimDto' property='insuredName' filter='true' />
          </a>
        </td>
      </tr>
      <tr>
        <td class="title">�����ڼ�</td>
        <td class="input" colspan='3'>
          <input type=text name="prpLclaimStartDate" title="������" class="readonly" style="width:80px" readonly="true"  value="<bean:write name='prpLclaimDto' property='startDate' filter='true' />">��ʱ����
          <input type=text name="prpLclaimEndDate"   title="�ձ�����" class="readonly" style="width:80px" readonly="true"   value="<bean:write name='prpLclaimDto' property='endDate' filter='true' />">��ʮ��ʱֹ
        </td>
      </tr>
      <tr>
        <td class="title">�ұ�:</td>
        <td class="input">
          <input class="readonly" readonly name="prpLclaimCurrencyName" value="�����">
          <input class="readonly" type=hidden name="prpLclaimCurrency" value="<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' />">
          <input class="readonly" type=hidden name="prpLclaimPolicyCurrency">
        </td>
        <td class="title">���ս��:</td>
        <td class="input">
          <input class="readonly" name="prpLclaimSumAmount" readonly="true" value="<bean:write name='prpLclaimDto' property='sumAmount' filter='true' format="##.00"/>">
          <input type="hidden" name="prpLclaimSumPremium" readonly="true" value="<bean:write name='prpLclaimDto' property='sumPremium' filter='true'  />">
        </td>
      </tr>
      <tr>
        <td class="title">�¹�ʱ��:</td>
        <td class="input">
          <input type=text name="prpLclaimDamageStartDate" title="�¹�ʱ��" class="readonly" readonly maxlength="10" style="width:80px" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' />">��
        </td>
        <td class="title">�ձ������ϼ�:</td>
        <td class="input">
          <input type=text name="prpLclaimSumClaim" title="������" Class="readonly" readonly  value="<bean:write name='prpLclaimDto' property='sumClaim' filter='true' />">
        </td>
      </tr>
   </table>
      <%-- �ձ��������Ϣ --%>
      <input  type="hidden" name="prpLclaimRiskCode" value="<bean:write name='prpLclaimDto' property='riskCode' filter='true' />"/>
      <%-- �ٱ�Σ�յ�λ���õ��������������ע���� --%>
      <%--<input  type="hidden" name="prpLdangerRiskSumClaim" value="<bean:write name='prpLclaimDto' property='sumClaim' filter='true' />"/>--%>
      <input type="hidden" name="damageStartDate" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' />">
       <script src="/claim/common/modifySumClaim/js/PropClaimEdit.js"></script>
       <%@include file="/common/modifySumClaim/ClaimLossEdit.jsp"%>
       
		<%-- 7.ָ��Σ�յ�λ��Ϣ --%>
		<%
	    PubTools pubTools=new PubTools();
	    int time= pubTools.compareDate(policyInputDate,"2011-02-27");
	    if(time<0){
	    //�þɵ�Σ�յ�λ��Ϣҳ��
		%>
			<%@include file="/common/claim/ClaimRiskUnit.jsp"%>
		<%
	    }else{
	    //���µ�Σ�յ�λ��Ϣҳ��
		%>
			<%@include file="/common/claim/ClaimNewRiskUnit.jsp"%>
		<%}%>
     <table  id="buttonArea" cellpadding="0" cellspacing="0" width="80%" style="display:">
       <tr>
        <td align="center">
           <br><br>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="button" name=buttonSaveFinishSubmit class='button' value='����' onclick="submitform();">
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="button" name=buttonBack class='button' value='����' onclick="back();">
          <script language="javascript">
                function back(){
                    fm.action = "/claim/modifySumClaim.do?editType=modifyBeforeQuery";
                    fm.submit();
                }
                
				function submitform(){
					//reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
					if(!validateForm(fm,'ClaimLoss_Data')){
						return false;
					}
					//alert("ok1");
					if(!checkLoss()){
						return false;
					}
					if(fm.DangerUnitCheckSaveFlag.value=='2'){ 
						if ( DangerUnitCheck()==false){
							return false;
						}
					}else if(fm.DangerUnitCheckSaveFlag.value=='1'){
						var reinsMoney=0;
						var reinsClaimMoney=0;
						var prpLdangerRiskSumClaim=round(parseFloat(fm.prpLdangerRiskSumClaim.value),2);
						for( var n=1;n<fm.prpLclaimLossSumClaim.length;n++){
							if(fm.ClaimLossFlag[n].value=="I"){
								reinsClaimMoney =parseFloat(fm.prpLclaimLossSumClaim[n].value);
								reinsMoney = reinsMoney + reinsClaimMoney;
							}
						}
						if(prpLdangerRiskSumClaim!=round(reinsMoney,2)){
							alert("������Ԥ��������Σ�յ�λҳ���¹�����ϼƣ�");
					        return false;
						}
					}
                    for( var j=1;j<fm.prpLclaimLossCurrency.length;j++)
                   	{
                   	  fm.prpLclaimLossFlag[j].disabled = false;
                   	}
                   	// ����ʱ����50����ʾ��,���ȷ�Ϻ󷽿ɱ���,����ͣ����ҳ��
                   	if(confirm(sumLossAmountInform() + "\nȷ�ϼ���������")) {
                   	     fm.submit();
                   	} 
                }
                
                function checkLoss()
             {
             	
               for( var j=1;j<fm.prpLclaimLossCurrency.length;j++)
              	{
             		if (isEmptyField(fm.prpLclaimLossCurrency[j]))
             		{
             			errorMessage("��"+ j+"���������бұ���Ϊ��!");
             			fm.prpLclaimLossCurrency[j].focus();
             			return false;
             		}
             
             		if(isEmptyField(fm.prpLclaimLossKindCode[j]))
             		{
             			errorMessage("��"+j+"�����������ձ���벻��Ϊ��!");
             			//fm.prpLclaimLossKindCode[j].focus();
             			return false;
             		}
             
             		if(isEmptyField(fm.prpLclaimLossSumClaim[j]))
		           {
		           	errorMessage("��"+j+"���������н���Ϊ��!");
		           	fm.prpLclaimLossSumClaim[j].focus();
		           	return false;
		           }
 	          }
 	
 
	             return true;
          }
                
          </script>
        </td>      
       </tr>
     </table>
</form>
</body>
</html>