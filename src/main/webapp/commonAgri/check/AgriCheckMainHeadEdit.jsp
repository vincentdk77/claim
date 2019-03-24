<%--
****************************************************************************
* DESC       :添加主信息子块界面页面
* AUTHOR     : liubvo
* CREATEDATE : 2004-06-03 
* MODIFYLIST :   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<!--add by liuyanmei 20051206 start -->
<%

 String comCode ="";
 String comName ="";
try{
  UserDto  user   = (UserDto)session.getAttribute("user");
  
   if (user!=null){
   comCode = user.getComCode();
    comName = user.getComName();
    }
 }catch (Exception e){
 }
String strViewUrl = AppConfig.get("sysconst.GIS_RFFeildView_URL");
  %>
<!--add by liuyanmei 20051206 end reason:自动带出操作员所属部门机构（需求）-->
 
<%--//add by wangli 20050601 reason:系统内从prpdcompany带出，系统外则从客户资料表prpdcustomer_unit中取值--%>
<script language="javascript">
 function selectHandleCodeByUnitType(fieldObject){
   
   var unitType = fm.unitType.value;
  // alert(fieldObject);
  // alert(unitType);  
  // fm.prpLcheckHandleUnitCode.value = ""; 
    if(unitType==1){
    code_CodeSelect(fieldObject, 'ComCode');
       }else{
    code_CodeSelect(fieldObject, 'CustomerUnit');
    }      
 }
     
      function clearHandleUnitCode(){
       fm.prpLcheckHandleUnitCode.value = ""; 
       fm.prpLcheckHandleUnitName.value = "";
      }
function viewGis(){
	url = "<%=strViewUrl %>?RFNO=<%=request.getAttribute("GisRichFlyCode") %>&RegistNO=<%=request.getAttribute("GisRegistNo") %>";
	//alert(url);
   	window.open(url,"地图信息","width=600,height=400,status=yes,menubar=yes,location=yes,resizable=yes,scrollbars=yes");
}
</script>

    
         <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr align="left"> 
              
       <td><input type="button" class=bigbutton name="prpLmessageSave"   class="bigbutton"  value="理赔沟通" onclick="openWinSaveQuery(fm.prpLcheckRegistNo.value,fm.prpLcheckPolicyNo.value,fm.prpLcheckRiskCode.value,'check','','registNo',fm.prpLcheckRegistNo.value);"></td>
       <td><input type="button" name="eCertify" class="bigbutton" value="电子单证" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLcheckDto' property='registNo'/>','check');"></td> 
       <td><input type="button" name="buttonCertifyDirect" class="bigbutton" value="索赔清单" onClick="doCertifyDirect('<bean:write name='prpLcheckDto' property='registNo'/>','check')"></td>
    </tr>
    </table>

    <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" width="100%">
    <!--查勘处理 modified by xiatian -->
    <tr class=listtitle>
    <%
       // 从session里取扶贫/大户标志
		String strHPflag = (String)session.getAttribute("flag");
		if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
			if(strHPflag.equals("Large")) {
				%> <td colspan="4">规模经营主体系统查勘处理</td></td><% 
			} else if(strHPflag.equals("Retaol")) {
				%> <td colspan="4">扶贫系统查勘处理</td></td><% 
			} else {
				%> <td colspan="4">查勘处理</td></td><% 
			}
		} else {
			%> <td colspan="4">查勘处理</td></td><% 
		}
      %>
    
    
    </tr>
      <tr>
        <td class="title" >
          <input type="hidden" name="referKind">
          <input type="hidden" name="prpLcheckRiskCode"  value="<bean:write name='prpLcheckDto' property='riskCode'/>">
          <input type="hidden" name="prpLcheckFlag"  value="<bean:write name='prpLcheckDto' property='flag'/>">
          <input type="hidden" name="prpLcheckReferSerialNo" value="<bean:write name='prpLcheckDto' property='referSerialNo' filter='true' />">    
          <input type="hidden" name="prpLcheckInsureCarFlag" value="<bean:write name='prpLcheckDto' property='insureCarFlag' filter='true' />">    
          <input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
          <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
          <input type="hidden" name="riskCode"  value="<bean:write name='prpLcheckDto' property='riskCode'/>">
          <input type="hidden" name="prpLclaimRiskCode" value="<bean:write name='prpLcheckDto' property='riskCode'/>">  
          <input type="hidden" name="registno" value="<bean:write name='prpLcheckDto' property='registNo'/>">
          <input type="hidden" name="policyno" value="<bean:write name='prpLcheckDto' property='policyNo'/>">
          <input type="hidden" name="prpLverifyLossRegistNo" value="<bean:write name='prpLcheckDto' property='registNo'/>">
          <input type="hidden" name="prpLverifyLossPolicyNo" value="<bean:write name='prpLcheckDto' property='policyNo'/>">
          <input type="hidden" name="prpLverifyLossInsuredName" value="<bean:write name='prpLcheckDto' property='insuredName'/>">
          <input type="hidden" name="prpLverifyLossMakeCom" value="<bean:write name='prpLregistDto' property='makeCom'/>">
          <input type="hidden" name="prpLverifyLossComCode" value="<bean:write name='prpLregistDto' property='comCode'/>">            
        
        险种名称:</td>
        <td class="title"><%= request.getAttribute("riskCName") %></td>
        <td class="title"></td><td class="title"></td>
      </tr>
      
      <tr> 
        <td class="title"  style="valign:bottom" >报案号：</td>
        <td class="input">
          <input type=text name="prpLcheckRegistNo" style="width:50%" class="readonly" readonly="true"  value="<bean:write name='prpLcheckDto' property='registNo'/>">
          <logic:equal value="1" name="IsDisplayGisViewInfo">
          	<input type=button class="button" name="GisViewInfo" value="地图信息" onclick="viewGis();">
          </logic:equal>
        </td>
        <td class="title" >立案号：</td>
        <td class="input"  >
          <input type="text" name="prpLcheckClaimNo" class="readonly" readonly="true" value="<bean:write name='prpLcheckDto' property='claimNo'/>">
        </td>
      </tr>
        
      <tr>         
        <td class="title" >保单号：</td>
        <td class="input"  colspan="3">
          <input type="text" name="prpLcheckPolicyNo" style="width:20%" class="readonly" readonly="true"  value="<bean:write name='prpLcheckDto' property='policyNo'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
          <input type="image" name="btRelate" src="/claim/images/butRelate.gif"  border="0" onclick="relate(fm.prpLcheckPolicyNo.value);return false;">         
           <input type="hidden" name="damageDate" value="<bean:write name='prpLcheckDto' property='damageStartDate' filter='true' /> ">
          <input type=button class="bigbutton"  name="policyBackWard" value="出险时保单信息" onclick="backWardPolicy();">      
        </td>
      </tr>
      
      <%
       // 从session里取扶贫/大户标志
		strHPflag = (String)session.getAttribute("flag");
		if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
			if(strHPflag.equals("Large")) {
				%> <tr>
      <td class="title">保单投保方式:</td>
      <td class="input">个体投保-----规模经营主体</td>
      <td class="title"></td>
      <td class="input"></td>
      </tr><% 
			} else if(strHPflag.equals("Retaol")) {
				%> <tr>
      <td class="title">保单投保方式:</td>
      <td class="input">团体投保-----特困农户</td>
      <td class="title"></td>
      <td class="input"></td>
      </tr><% 
			} 
		} 
      %>
      
      
      <tr>         
        <td class="title" >被保险人：</td>
        <td class="input"  colspan="3">
          <input type="text" name="insuredName" style="width:40%" class="readonly" readonly="true"  value="<bean:write name='prpLcheckDto' property='insuredName'/>">
        </td>
      </tr>
      <!--modify by qinyongli 2005-07-22 start 联共保、临分和股东信息-->
      <logic:notEmpty name="coinsFlag"  >
      <input type="hidden" name="coinsFlag" value="<bean:write name='coinsFlag'/>">
      </logic:notEmpty>
      <logic:empty name="coinsFlag"  >
      <input type="hidden" name="coinsFlag" value="0">
      </logic:empty>
      <logic:notEmpty name="shareHolderFlag"  >
      <input type="hidden" name="shareHolderFlag" value="<bean:write name='shareHolderFlag'/>">
      </logic:notEmpty>
      <logic:empty name="shareHolderFlag"  >
      <input type="hidden" name="shareHolderFlag" value="0">
      </logic:empty>
      <logic:notEmpty name="tempReinsFlag"  >
      <input type="hidden" name="tempReinsFlag" value="<bean:write name='tempReinsFlag'/>">
      </logic:notEmpty>
      <logic:empty name="tempReinsFlag"  >
      <input type="hidden" name="tempReinsFlag" value="0">
      </logic:empty>
      <!--modify by qinyongli 2005-07-22 end 联共保和股东信息-->
      <tr>         
        <td class="title" >出险时间：</td>
        <td class="input" >
        <input type="text" name="prpLcheckDamageStartDate" class="readonly" readonly="true" maxlength="10"  value="<bean:write name='prpLcheckDto' property='damageStartDate' filter='true' /> <bean:write name='prpLcheckDto' property='damageStartHour' filter='true' /> 时 <bean:write name='prpLcheckDto' property='damageStartMinute' filter='true' /> 分">
         <input type="hidden" name="damageStartDate" class="readonly" readonly="true" maxlength="10"  value="<bean:write name='prpLcheckDto' property='damageStartDate' filter='true' /> ">
         <input type="hidden" name="damageStartHour" class="readonly" readonly="true" maxlength="10"  value="<bean:write name='prpLcheckDto' property='damageStartHour' filter='true' /> ">
        </td>

        <td class="title" >出险地点：</td>
        <td class="input" >
          <input type="text" name="prpLcheckDamageAddress" class="input"   value="<bean:write name='prpLcheckDto' property='damageAddress'/>">
        </td>      
      </tr>
      
      
      <tr>         
        <td class="title" >查勘类型：</td>
        <td class="input"  >
          <html:select name='prpLcheckDto' property='checkType' >
            <html:option value="L">查勘</html:option>
            <html:option value="D">代查勘</html:option>
           </html:select>
        </td>
        
         <td class="title" >查勘日期：</td>
        <td class="input"  >
          <input type="text" name="prpLcheckCheckDate" class="input" onblur="checkFullDate(this)" value="<bean:write name='prpLcheckDto' property='checkDate'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        
       
      </tr>
      
      <tr>         
        <td class="title"  style="valign:bottom" >查勘性质:</td>
        <td class="input"  style="valign:middle">
          <html:select name="prpLcheckDto" property="checkNature" styleClass="common">
              <html:options collection="checkNatures" property="codeCode" labelProperty="codeCName"/>          
          </html:select> 
        </td>
        
        <td class="title" >已出险次数:</td>
        <td class="input" >
        <%-- 出险信息画面 --%>
           <%@include file="/commonAgri/regist/AgriExistRegist.jsp"%>                
        </td>
      </tr>
      
      <tr>         
        <td class="title" >查勘地点:</td>
        <td class="input"  colspan="3">
          <input type="text" name="prpLcheckCheckSite" class="input" value="<bean:write name='prpLcheckDto' property='checkSite'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      
      <tr>         
        <td class="title" >查勘人 1:</td>
        <td class="input"  >
          <input name='prpLcheckChecker1' class='input' maxlength=20  description="查勘人1" value="<bean:write name='prpLcheckDto' property='checker1'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </select>
        </td>
        <td class="title"  style="valign:bottom" >查勘人 2:</td>
        <td class="input"  style="valign:middle">
          <input name='prpLcheckChecker2' class='input' maxlength=20 description="查勘人2" value="<bean:write name='prpLcheckDto' property='checker2'/>">
        </td>
      </tr>
      <%@include file="/commonAgri/check/AgriCheckDamageEdit.jsp"%>
      <!--modify by wangwei add start 20050602-->
      <!-- modify by wuxiaodong 050905 begain reasion 修改币别由报案记录代入，而不是写死-->
       <tr>         
        <td class="title" >报损金额:<bean:write name='prpLcheckDto' property='currency'/></td>
        <td class="input" colspan=3 >
          <input name='prpLcheckEstimateLoss2'  class="readonly" readonly="true"  maxlength=20 style="width:140px" description="查勘人1" value="<bean:write name='prpLcheckDto' property='registEstimateLoss' format = '#0.00'/>">
        </select>
        </td>
       <!-- <td class="title"  style="valign:bottom" >报损费用:<bean:write name='prpLcheckDto' property='currency'/></td>
        <td class="input"  style="valign:middle">
          <input name='prpLcheckEstimateFee2'  class="readonly" readonly="true"  maxlength=20 style="width:140px" description="查勘人2" value="<bean:write name='prpLcheckDto' property='registEstimateFee'/>">
        </td>  -->
      </tr>
      
       <tr>         
        <td class="title" >预估金额:<bean:write name='prpLcheckDto'  property='currency' /></td>
        <td class="input"  >
          <input name='prpLcheckEstimateLoss' class='input' maxlength=20 style="width:140px" description="查勘人1" value="<bean:write name='prpLcheckDto' format = "0.00" property='estimateLoss'/>">
        </select>
        </td>
        <td class="title"  style="valign:bottom" >预估费用:<bean:write name='prpLcheckDto' property='currency'/></td>
        <td class="input"  style="valign:middle">
          <input name='prpLcheckEstimateFee'  class='input' maxlength=20 style="width:140px" description="查勘人2" value="<bean:write name='prpLcheckDto' format = "0.00" property='estimateFee'/>">
        </td>
      </tr>
      <!-- modify by wuxiaodong 050905 end -->
      <!--//modify by wangwei add end 20050602-->
      
      <tr>
      <td class='title' id='tdTitleCheckUnitName'>查勘处理单位:</td>
        <td class="input" id="tdCheckName">
          <html:select name='prpLcheckDto' property='unitType' onchange="clearHandleUnitCode();">
            <html:option value="1">系统内</html:option>
            <html:option value="0">系统外</html:option>
           </html:select>     
           </td>
          <td class="input" colspan='2'>
    <!--add by liuyanmei 20051206 start  reason:自动带出操作员所属部门机构（需求）-->      
       <logic:notEmpty name='prpLcheckDto' property='handleUnitCode' >    
          <input name="prpLcheckHandleUnitCode" class="codecode" style="width:100px" maxlength=20 description="查勘处理单位代码" value="<bean:write name='prpLcheckDto' property='handleUnitCode'/>"
             ondblclick="selectHandleCodeByUnitType(fm.prpLcheckHandleUnitCode);"
             onkeyup= "selectHandleCodeByUnitType(fm.prpLcheckHandleUnitCode);">
          <input name="prpLcheckHandleUnitName" class="readonly"  style="width:200px" maxlength=60 description="查勘处理单位" value="<bean:write name='prpLcheckDto' property='handleUnit'/>">
      </logic:notEmpty>     
      <logic:empty name='prpLcheckDto' property='handleUnitCode' > 
            <input name="prpLcheckHandleUnitCode" class="codecode" style="width:100px" maxlength=20 description="查勘处理单位代码" value="<%=comCode%>" 
               ondblclick="selectHandleCodeByUnitType(fm.prpLcheckHandleUnitCode);"
               onkeyup= "selectHandleCodeByUnitType(fm.prpLcheckHandleUnitCode);">
            <input name="prpLcheckHandleUnitName" class="readonly"  style="width:200px" maxlength=60 description="查勘处理单位" value="<%= comName%>">  
      </logic:empty>
<!--add by liuyanmei 20051206 end -->
             <!--<img src="/claim/images/bgMarkMustInput.jpg">-->
          </td>          
      </tr>