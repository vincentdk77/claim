<%--
****************************************************************************
* DESC       ：指定危险单位界面
* AUTHOR     ：国元项目组
* CREATEDATE ：2010-12-26
* MODIFYLIST ：   Name       Date            Reason/Contents
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
	//农险立案不显示危险单位信息,3155增加危险单位
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
             name="RegistTextImg" onclick="showPage(this,NewDangerUnitTable)"> 危险单位信息
                <font color="#FF0000">*</font>
  <table class="common" id="NewDangerUnitTable" style="display: none">
      <tr>
        <td class="subformtitle" style="text-align:left;" colspan="11" >
           <input type=button class="bigbutton"  style="cursor: hand" name="creatDangerUnit" value="生成危险单位" onclick="changFlagDanger();" <%=disabledFlag %>>
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
			      <td align="center"><input  class="readonly" type="text" name="prpLdangerCurrency" title="币别"  readonly="readonly" style="text-align: left;width: 30%" >
			          <input class="readonly" type=text name="prpLdangerCurrencyName"   title="币别" readonly="readonly" style="text-align: right;width: 60%" >
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
              <td class="centertitle" style="width: 4%">标的序号</td>
              <td class="centertitle" style="width: 5%">危险单位号</td>
              <td class="centertitle" style="width: 10%">危险单位描述</td>
              <td class="centertitle" style="width: 10%">地址描述</td>
              <td class="centertitle" style="width: 10%">币别</td>
	          <td class="centertitle" style="width: 10%">估损金额</td>
              <td class="centertitle" style="width: 6%">占比</td>   
              <td class="centertitle" style="width: 8%">险别代码</td>  
              <td class="centertitle" style="width: 12%">险别名称</td> 
              <td class="centertitle" style="width: 8%">标的代码</td>  
              <td class="centertitle" style="width: 12%">标的名称</td>   
              <td class="centertitle" style="width: 5%">是否危险单位</td>
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
