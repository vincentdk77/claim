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

<script language="Javascript" src="/claim/common/js/DangerUnit.js" ></script>  

  <%
    String disabledFlag="";
  	String display="none";
    if(editType.equals("SHOW")){
    	disabledFlag="disabled";
  %>
        <jsp:include page="/common/claim/DangerUnitIni.jsp"/>
    <%	
   }else if(editType.equals("EDIT")){
	   %>
	    <jsp:include page="/common/claim/DangerUnitIni.jsp"/>
	   <%
   }else if(editType.equals("modifyDetail")&&null!=isShow){
	   disabledFlag="disabled";
	   %>
	     <jsp:include page="/common/claim/DangerUnitIni.jsp"/>

	   <%
   }else if(editType.equals("modifyDetail")&&null==isShow){
	     display="";
   }
	//ũ����������ʾΣ�յ�λ��Ϣ,3155����Σ�յ�λ
	PrpLclaimDto  prpLclaimDto2 = (PrpLclaimDto)request.getAttribute("prpLclaimDto"); 
	String strDisplay="";
	if(prpLclaimDto2 != null && (prpLclaimDto2.getClassCode().equals("31") || prpLclaimDto2.getClassCode().equals("32"))){
		strDisplay = "none";
	}
	if(editType.equals("modifyDetail")){
		strDisplay="";
	}
	
%>
 <table class="common" width="100%">
    <tr class=mline  style="display:<%=strDisplay %>">
      <td class="subformtitle"  style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="RegistTextImg" onclick="showPage(this,NewDangerUnitTable)"> Σ�յ�λ��Ϣ
                <font color="#FF0000">*</font>
  <table class="common" id="NewDangerUnitTable" style="display: none">
      <tr>
        <td class="subformtitle" style="text-align:left;" colspan="11" >
           <input type=button class="bigbutton"  style="cursor: hand" name="creatDangerUnit" value="����Σ�յ�λ" onclick="changFlagDanger();" <%=disabledFlag %>>
           <input type="hidden" name="flagDangerUnit" value="0"> 
           <input type="hidden" name="DangerUnitCheckSaveFlag" value="2"> 
           <input type="hidden"  name="prpLdangerRiskSumClaim" />
           <input type="hidden"  name="prpLdangerRiskSumPaid" />
           <input type="hidden"  name="prpLdangerRiskClaim" value="claim" />
           <input type="hidden"  name="prpLdangerRiskeditType"  value="<%=editType %>" />
        </td>
     </tr>
    <tr>
      <td style="text-align:left" colspan="11"> 
       
        <table id="NewDangerUnit_Data" style="display:none">
          <tbody>
            <tr>
              <td > 
                 <input type="hidden"  name="prpLdangerPolicyNo" />
                 <input type="hidden"  name="prpLdangerRiskCode" /> 
              </td>
                  <td><input class="readonly" readonly="readonly" type=text name="prpLdangerUnitItemKindNo"  /></td>
                  <td><input class="readonly" readonly="readonly" type=text name="prpLdangerDangerNo"  /></td>
			      <td><input class="readonly" readonly="readonly" type=text name="prpLdangerUnitDangerDesc"  /></td>
			      <td><input class="readonly" readonly="readonly" type=text name="prpLdangerUnitAddressName" /></td>
			      <td align="center"><input  class="readonly" type="text" name="prpLdangerCurrency" title="�ұ�"  readonly="readonly" style="text-align: left;width: 30%" >
			          <input class="readonly" type=text name="prpLdangerCurrencyName"   title="�ұ�" readonly="readonly" style="text-align: right;width: 60%" >
			      </td>
			      <%if(editType.equals("modifyDetail")){ %>
			      <td><input class="readonly" readonly="readonly"  type="text" name="prpLdangerUnitSumLoss"  format="0.00"/></td>
	     		  <%}else { %>
			      <td><input class="common"  type="text" name="prpLdangerUnitSumLoss" format="0.00" onblur="collectDangerShare(this);"/></td>
			      <%} %>
			      <td><input class="readonly" readonly="readonly" type="text" name="prpLdangerShare"  style="text-align: right;"/>%</td>    
			      <td><input class="readonly" readonly="readonly" type="text" name="prpLdangerKindcode" /></td>    
			      <td><input class="readonly" readonly="readonly" type="text" name="prpLdangerKindname" /></td>    
			      <td><input class="readonly" readonly="readonly" type="text" name="prpLdangerItemCode" /></td>    
			      <td><input class="readonly" readonly="readonly" type="text" name="prpLdangerItemName" /></td>  
			      <td><input type="hidden" name="prpLdangerBusinessNature" /></td>
			      <td><input type="hidden" name="prpLdangerPolicyBizType" /></td>
			      <td><input type="hidden" name="prpLdangerPolicyType" /></td>
			      <td><input type="hidden" name="prpLdangerBusinessType1" /></td>
			      <td><input type="hidden" name="prpLdangerBusinessType" /></td>
			      <td><input type="hidden" name="prpLdangerOthFlag" /></td>
			      <td><input type="hidden" name="prpLdangerBusinessProvince" /></td>
			      <td><input type="hidden" name="prpLdangerBusinessTown" /></td>
			      <td><input type="hidden" name="prpLdangerBusinessCounty" /></td>
			      <td><input type="hidden" name="prpLdangerBusinessAreaName" /></td> 
			      <td align=center><input type="checkbox"  name="isRiskUnit" checked="checked" disabled="disabled"/></td>
			    <%-- <td align=center><input type="checkbox"  name="isRiskUnit" checked="checked"  onclick="RiskUnitIni(this);" <%=disabledFlag %>/></td> --%>
            </tr>
          </tbody>
        </table>
        <table id="NewDangerUnit" class="common" >
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
