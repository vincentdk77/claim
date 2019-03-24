<%@ page import="com.sinosoft.sysframework.reference.AppConfig" %>
<%@ page import="com.sinosoft.claim.dto.custom.UserDto" %>
<%      
       UserDto   userDto = (UserDto)session.getAttribute("user");
       boolean isShowButton = true;
       //用户没用登录理赔系统时，不显示相关按钮(主要是双核系统访问理赔流程图的情况)
       if(userDto == null){
    	   isShowButton = false;
       }
       String policyNo = (String)request.getAttribute("policyNo");
       String curRegistNo = (String)request.getAttribute("curRegistNo");
       String bizNO = policyNo;
       String bizType = "P";
       String classCode = prpLregistDto.getClassCode();
       String strSpanClass = "";
       String strDisplay   = "none";
       if("05".equals(classCode)){
    	   strSpanClass = "spanBar";
    	   strDisplay   = "";
       }
       if(!"".equals(prpLregistDto.getRegistNo())){
    	   bizNO = prpLregistDto.getRegistNo();
    	   bizType = "R";
       }
%>
<style>
    DIV.spanBar{
        position: absolute;
        left:10px;
        z-index: 300;
        top:expression(offsetParent.scrollTop+5);
    }
</style>
<div id="spanMessage" class="<%=strSpanClass %>">
<%
  String url = AppConfig.get("sysconst.Core_URL");
  url += "/common/cb/UIPoliCIRelate.jsp?typeClaim=claim";
  String UNDWRT_URL = AppConfig.get("sysconst.GY_UNDWRT_URL");
  String UNDWRT_HOST = AppConfig.get("sysconst.GY_UNDWRT_HOST");
 %>  
<%if(isShowButton){ %>
    <logic:notEqual name="prpLregistDto" property="status" value="1">
        <input type="button" class="button"  height="21" name="messageSave"  value="理赔沟通"  onclick="return openWinSaveQuery(fm.prpLregistRegistNo.value,fm.prpLregistPolicyNo.value,fm.prpLregistRiskCode.value,'regis','','registNo',fm.prpLregistRegistNo.value);">&nbsp;
    </logic:notEqual>
<%} %>
<!-- 
<input type="button" class="bigbutton" style="width:100px" name="policyBackWard" value="出险时保单信息" onclick="backWardPolicy();">&nbsp;&nbsp;

<%
  if(request.getAttribute("prpLregistRPolicyNo")!= null)
   {
%>
       <input type=button class="bigbutton" style="width:100px" name="policyBackWard" value="强制保单信息" onclick="relateBeforePolicyNo('<bean:write name='prpLregistRPolicyNo' property='policyNo'/>','<bean:write name='prpLregistRPolicyNo' property='riskCode'/>',fm.prpLregistDamageStartDate.value);">
<%
    }
%>
 -->
 <input type="button" class="button"  value="承保影像" style="display:<%=strDisplay %>" onclick="showMaterialInfo('<%=request.getAttribute("proposalNo")%>')">

<input type="button" class="button"  value="保单抄件" style="display:<%=strDisplay %>" onclick="printWindow('<%=bizNO%>','打印1','<%=bizType %>')">

<input title="点击此处可获得已出险相关信息"  type=button value='历次赔案' class="button"  name='button_Peril_Open_Context' onclick="buttonOnClick('perilInfoShow','<%=policyNo%>','<%=curRegistNo%>');">

<input alt="点击此按钮可获得保单相关信息" type="button" class="button" style="display:<%=strDisplay %>" value="关联保单" onclick="doCertifyDirect()">
    <input type="hidden" name="UNDWRT_URL" value="<%= UNDWRT_URL%>">
    <input type="hidden" name="UNDWRT_HOST" value="<%= UNDWRT_HOST %>">
</div>
<script type="text/javascript">
    function doCertifyDirect(){
       window.open( '<%=url%>',"Print","resizable=0,scrollbars=1,width=800,height=600");
    } 
</script>
