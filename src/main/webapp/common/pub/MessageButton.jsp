<%@ page import="com.sinosoft.sysframework.reference.AppConfig" %>
<%@ page import="com.sinosoft.claim.dto.custom.UserDto" %>
<%      
       UserDto   userDto = (UserDto)session.getAttribute("user");
       boolean isShowButton = true;
       //�û�û�õ�¼����ϵͳʱ������ʾ��ذ�ť(��Ҫ��˫��ϵͳ������������ͼ�����)
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
        <input type="button" class="button"  height="21" name="messageSave"  value="���⹵ͨ"  onclick="return openWinSaveQuery(fm.prpLregistRegistNo.value,fm.prpLregistPolicyNo.value,fm.prpLregistRiskCode.value,'regis','','registNo',fm.prpLregistRegistNo.value);">&nbsp;
    </logic:notEqual>
<%} %>
<!-- 
<input type="button" class="bigbutton" style="width:100px" name="policyBackWard" value="����ʱ������Ϣ" onclick="backWardPolicy();">&nbsp;&nbsp;

<%
  if(request.getAttribute("prpLregistRPolicyNo")!= null)
   {
%>
       <input type=button class="bigbutton" style="width:100px" name="policyBackWard" value="ǿ�Ʊ�����Ϣ" onclick="relateBeforePolicyNo('<bean:write name='prpLregistRPolicyNo' property='policyNo'/>','<bean:write name='prpLregistRPolicyNo' property='riskCode'/>',fm.prpLregistDamageStartDate.value);">
<%
    }
%>
 -->
 <input type="button" class="button"  value="�б�Ӱ��" style="display:<%=strDisplay %>" onclick="showMaterialInfo('<%=request.getAttribute("proposalNo")%>')">

<input type="button" class="button"  value="��������" style="display:<%=strDisplay %>" onclick="printWindow('<%=bizNO%>','��ӡ1','<%=bizType %>')">

<input title="����˴��ɻ���ѳ��������Ϣ"  type=button value='�����ⰸ' class="button"  name='button_Peril_Open_Context' onclick="buttonOnClick('perilInfoShow','<%=policyNo%>','<%=curRegistNo%>');">

<input alt="����˰�ť�ɻ�ñ��������Ϣ" type="button" class="button" style="display:<%=strDisplay %>" value="��������" onclick="doCertifyDirect()">
    <input type="hidden" name="UNDWRT_URL" value="<%= UNDWRT_URL%>">
    <input type="hidden" name="UNDWRT_HOST" value="<%= UNDWRT_HOST %>">
</div>
<script type="text/javascript">
    function doCertifyDirect(){
       window.open( '<%=url%>',"Print","resizable=0,scrollbars=1,width=800,height=600");
    } 
</script>
