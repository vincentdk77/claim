<%--
****************************************************************************
* DESC       ��ָ��Σ�յ�λ����
* AUTHOR     ����Ԫ��Ŀ��
* CREATEDATE ��2010-12-26
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*" %>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDcode"%>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>


  <%
    String disabledFlag="";
    if(editType.equals("SHOW")){
    	disabledFlag="disabled";
  %>
        <jsp:include page="/common/claim/DangerUnitIni.jsp"/>
    <%	
   }else if(editType.equals("EDIT")){
	   %>
	    <jsp:include page="/common/claim/DangerUnitIni.jsp"/>
	   <%
   }
	//ũ����������ʾΣ�յ�λ��Ϣ
	PrpLclaimDto  prpLclaimDto2 = (PrpLclaimDto)request.getAttribute("prpLclaimDto_"+indexRiskUnit); 
	String strDisplay="";
	if(prpLclaimDto2 != null && (prpLclaimDto2.getClassCode().equals("31") || prpLclaimDto2.getClassCode().equals("32"))
			&& !"3155".equals(prpLclaimDto2.getRiskCode()) && !"3196".equals(prpLclaimDto2.getRiskCode())){
		strDisplay = "none";
	}
	
%>
 <table class="common" width="100%">
    <tr class=mline  style="display:<%=strDisplay %>">
      <td class="subformtitle"  style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="RegistTextImg_<%=indexRiskUnit%>" onclick="showPage(this,NewDangerUnitTable)"> Σ�յ�λ��Ϣ
                <font color="#FF0000">*</font>
  <table class="common" id="NewDangerUnitTable_<%=indexRiskUnit%>" style="display: none">
      <tr>
        <td class="subformtitle" style="text-align:left;" colspan="11" >
           <input type=button class="bigbutton"  style="cursor: hand" name="creatDangerUnit_<%=indexRiskUnit%>" value="����Σ�յ�λ" onclick="changFlagDanger();" <%=disabledFlag %>>
           <input type="hidden" name="flagDangerUnit_<%=indexRiskUnit%>" value="0"> 
           <input type="hidden" name="DangerUnitCheckSaveFlag_<%=indexRiskUnit%>" value="2"> 
           <input type="hidden"  name="prpLdangerRiskSumClaim_<%=indexRiskUnit%>" />
           <input type="hidden"  name="prpLdangerRiskSumPaid_<%=indexRiskUnit%>" />
        </td>
     </tr>
    <tr>
      <td style="text-align:left" colspan="11"> 
       
        <table id="NewDangerUnit_Data_<%=indexRiskUnit%>" style="display:none">
          <tbody>
            <tr>
              <td > 
                 <input type="hidden"  name="prpLdangerPolicyNo_<%=indexRiskUnit%>" />
                 <input type="hidden"  name="prpLdangerRiskCode_<%=indexRiskUnit%>" /> 
              </td>
                  <td><input class="readonly" readonly="readonly" type=text name="prpLdangerUnitItemKindNo_<%=indexRiskUnit%>"  /></td>
                  <td><input class="readonly" readonly="readonly" type=text name="prpLdangerDangerNo_<%=indexRiskUnit%>"  /></td>
			      <td><input class="readonly" readonly="readonly" type=text name="prpLdangerUnitDangerDesc_<%=indexRiskUnit%>"  /></td>
			      <td><input class="readonly" readonly="readonly" type=text name="prpLdangerUnitAddressName_<%=indexRiskUnit%>" /></td>
			      <td align="center"><input  class="readonly" type="text" name="prpLdangerCurrency_<%=indexRiskUnit%>" title="�ұ�"  readonly="readonly" style="text-align: left;width: 30%" >
			          <input class="readonly" type=text name="prpLdangerCurrencyName_<%=indexRiskUnit%>"   title="�ұ�" readonly="readonly" style="text-align: right;width: 60%" >
			      </td>
			      <td><input class="common"  type="text" name="prpLdangerUnitSumLoss_<%=indexRiskUnit%>"  onblur="collectDangerShare(this);"/></td>
			      <td><input class="readonly" readonly="readonly" type="text" name="prpLdangerShare_<%=indexRiskUnit%>"  style="text-align: right;"/>%</td>    
			      <td><input class="readonly" readonly="readonly" type="text" name="prpLdangerKindcode_<%=indexRiskUnit%>" /></td>    
			      <td><input class="readonly" readonly="readonly" type="text" name="prpLdangerKindname_<%=indexRiskUnit%>" /></td>    
			      <td><input class="readonly" readonly="readonly" type="text" name="prpLdangerItemCode_<%=indexRiskUnit%>" /></td>    
			      <td><input class="readonly" readonly="readonly" type="text" name="prpLdangerItemName_<%=indexRiskUnit%>" /></td>    
			      <td align=center><input type="checkbox"  name="isRiskUnit_<%=indexRiskUnit%>" checked="checked"  onclick="RiskUnitIni(this);" <%=disabledFlag %>/></td>
            </tr>
          </tbody>
        </table>
        <table id="NewDangerUnit_<%=indexRiskUnit%>" class="common" >
          <thead>
             <tr>
              <td> 
              </td>
              <td class="centertitle" style="width: 4%">������</td>
              <td class="centertitle" style="width: 5%">Σ�յ�λ��</td>
              <td class="centertitle" style="width: 10%">Σ�յ�λ����</td>
              <td class="centertitle" style="width: 10%">��ַ����</td>
              <td class="centertitle" style="width: 10%">�ұ�</td>
	          <td class="centertitle" style="width: 10%">������</td>
              <td class="centertitle" style="width: 6%">ռ��</td>   
              <td class="centertitle" style="width: 8%">�ձ����</td>  
              <td class="centertitle" style="width: 12%">�ձ�����</td> 
              <td class="centertitle" style="width: 8%">��Ĵ���</td>  
              <td class="centertitle" style="width: 12%">�������</td>   
              <td class="centertitle" style="width: 5%">�Ƿ�Σ�յ�λ</td>
            </tr>
          </thead>
          <tfoot>
          </tfoot>
          <tbody>
          </tbody>
         </table>
        </td>
       </tr>
     </table>
   </td>
  </tr>
 </table>
 <%indexRiskUnit++; %>
