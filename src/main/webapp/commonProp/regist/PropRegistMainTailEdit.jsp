<%--
****************************************************************************
* DESC       ：报案登记报案主信息结尾
* AUTHOR     ：lixiang
* CREATEDATE ：2004-10-12
* MODIFYLIST ：   Name       Date            Reason/Contents
                 
****************************************************************************
--%>
   <tr>
      <td class="title"><bean:message key="db.prpLregist.receiverName" /></td>
      <td class="input" colspan=3>
        <input type=hidden name="prpLregistReceiverCode" class="codecode"  style="width:80px" title="接案人" value="<bean:write name='prpLregistDto' property='receiverCode' filter='true' />"
            ondblclick="code_CodeSelect(this, 'HanderCode');"
             onkeyup= "code_CodeSelect(this, 'HanderCode');">
        <input type=text readonly=true name="prpLregistReceiverName" class="readonly" style="width:125px" title="接案人" value="<bean:write name='prpLregistDto' property='receiverName' filter='true' />">
        <!--<img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">
        <img src="/claim/images/bgMarkMustInput.jpg">-->
      </td>
      
      
    </tr> 
    
    
    <tr>
        <td class="title"><bean:message key="db.prpLregist.handler1Code" />:</td>
        <td class="input">
          <input type=hidden name="prpLregistHandler1Code" value="<bean:write name='prpLregistDto' property='handler1Code' filter='true' />">
          <input type=text   name="prpLregistHandler1Name" title="归属业务员" class="readonly" readonly="true" value="<bean:write name='prpLregistDto' property='handler1Name' filter='true' />">
        </td>
        <td class="title"><bean:message key="db.prpLregist.comCode" />:</td>
        <td class="input">
          <input type=hidden name="prpLregistComCode" value = "<bean:write name='prpLregistDto' property='comCode' filter='true' />">
          <input type=text   name="prpLregistComName" title="业务归属机构" class="readonly" readonly="true" value = "<bean:write name='prpLregistDto' property='comName' filter='true' />">
        </td>
      </tr> 
    <tr>
        <td class="title"><bean:message key="db.prpLregist.operatorCode" />:</td>
        <td class="input">
          <input type=text name="prpLregistOperatorCode" title="操作员" class="readonly" style="width:80px" readonly="true" value="<bean:write name='prpLregistDto' property='operatorCode' filter='true' />">
          <input type=text name="prpLregistOperatorName" title="操作员名称" class="readonly" style="width:80px" readonly="true" value="<bean:write name='prpLregistDto' property='operatorName' filter='true' />">
        </td>
        <td class="title">理赔登记部门:</td> 
        <td class="input">
          <input type=text name="prpLregistMakeCom" title="理赔登记部门" class="readonly" style="width:60px" readonly="true" value="<bean:write name='prpLregistDto' property='makeCom' filter='true' />">
          <input type=text name="prpLregistMakeComName" title="理赔登记部门" class="readonly" style="width:120px" readonly="true" value="<bean:write name='prpLregistDto' property='makeComName' filter='true' />">
        </td>
    </tr>
    <tr style='display:none'>
      <td class="title"><bean:message key="db.prpLregist.acceptFlag" />:</td>
      <td class="input" >
        <html:radio  name="prpLregistDto" property="acceptFlag" value="Y"/>是
        <html:radio  name="prpLregistDto" property="acceptFlag" value="N"/>否
        <img src="/claim/images/bgMarkMustInput.jpg">
      </td>
      <td class="title"><bean:message key="db.prpLregist.repeatInsureFlag" />:</td>
      <td class="input">
        <html:radio  name="prpLregistDto" property="repeatInsureFlag" value="Y"/>是
        <html:radio  name="prpLregistDto" property="repeatInsureFlag" value="N"/>否   
        <img src="/claim/images/bgMarkMustInput.jpg">      
      </td>
    </tr>
   
    
      
<logic:notEqual name="prpLregistDto" property="riskCode" value="ZH03">
       <tr>
       <td class="title">备注:</td>
      <td class="input" colspan=3>
        <input type=text name="prpLregistRemark" title="备注" Class="input" style="width:92%" maxLength="255" onblur="checkLength1(this);" description="备注" value="<bean:write name='prpLregistDto' property='remark' filter='true' />">
      </td>
      </tr>
</logic:notEqual>
<input type=hidden name="familyNo" value = "<%= request.getParameter("faimlyNo") %>">
      <logic:equal name="prpLregistDto" property="riskCode" value="ZH03">
      <tr>
       <td class="title">户编码:</td>
      <td class="input" >
      <input type=text name="prpLregistRemark" title="户编号" class="readonly" style="width:60px" readonly="true" value="<bean:write name='prpLregistDto' property='remark' filter='true' />">
          <img src="/claim/images/bgMarkMustInput.jpg">
        <input type=text name="prpLregistRemark1" title="户编号" style="width:120px"  class="codecode" maxLength="20" onblur="checkLength1(this);" description="户编号" value="<bean:write name='prpLregistDto' property='remark' filter='true' />"
        ondblclick="code_CodeSelect(this, 'ZH03prpLlossFamilyNo','-1','code','query','post');"
        onkeyup= "code_CodeSelect(this, 'ZH03prpLlossFamilyNo','-1','code','query','post');">
      
      </td>
      <td class="title">主/连带被保险人:</td>
      <td class="input" >
        <input type=text name="prpLregistName" title="主/连带被保险人" style="width:120px" class="codecode" maxLength="20" description="主/连带被保险人"  
        ondblclick="code_CodeSelect(this, 'ZH03prpLlossFamilyNo1','-2,-1','always','query','post');"
        onkeyup= "code_CodeSelect(this, 'ZH03prpLlossFamilyNo1','-2,-1','always','query','post');"
        >
      </td>
      </tr>
      
</logic:equal>

     
    </table>