<%--
****************************************************************************
* DESC       ：添加主信息子块界面页面[ 结案 ]
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-06-28
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<% String dfFlag =(String) request.getAttribute("dfFlag");
if (dfFlag!=null && !dfFlag.equals("")&& dfFlag.equals("Y")){  %>
<input type="hidden" name="dfFlag" value="<%=dfFlag%>"> 

<%}else {%>
<input type="hidden" name="dfFlag" value="N"> 
<%}%>  

<table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
  <tr>
    
      <%--modify by wangli update start 20050409 --%>
          <td><input type="button" name="prpLmessageSave" class=bigbutton value="撰写留言" onclick="openWinSave(fm.prpLclaimRegistNo.value,fm.prpLclaimPolicyNo.value,fm.prpLclaimRegistNo.value,'endca',fm.prpLendcaseClaimNo1.value);"></td>
          <td><input type="button" name="prpLmessageView" class=bigbutton value="查看留言" onClick="openWinQuery('registNo',fm.prpLclaimRegistNo.value);"></td>
    
     <%--modify by wangli update end 20050409 --%>
  </tr>
</table>
<table  class=common cellpadding="5" cellspacing="1">
  <tr class=listtitle> 
     <%if (dfFlag!=null && !dfFlag.equals("")&& dfFlag.equals("Y")){  %>
    
     <td  colspan="4" style="width:100%">结案登记 (垫付抢救费) 
    <%}else {%>
    <td  colspan="4" style="width:100%">结案登记 
    <%}%>
      <input type="hidden" name="prpLendcaseClaimNo1" value="<bean:write name='prpLclaimDto' property='claimNo'/>"> 
      <input type="hidden" name="prpLendcaseCertiNo" value=" "> 
      <input type="hidden" name="prpLendcaseCertiType" value="C"> 
      <input type="hidden" name="prpLendcaseFlag" value="1"> 
      <input type="hidden" name="prpLendcaseCaseNo" value="<bean:write name='prpLcaseNoDto' property='caseNo'/>"> 
     
     
      <%--resson: 增加预赔号和赔款计算书号--%> 
      <input type="hidden" name="prpLendcasepreCompensateNo" value="<bean:write name='prpLcaseNoDto' property='preCompensateNo'/>">
      <input type="hidden" name="prpLendcasecompensateNo" value="<bean:write name='prpLcaseNoDto' property='compensateNo'/>">
      <%--modify by zhaozhuo add 20050331 end--%>
      <!--modify by qinyongli 2005-07-21 start 增加保费是否已经实收信息-->
      <logic:notEmpty name="premiumFee"  >
      <input type="hidden" name="premiumFee" value="<bean:write name='premiumFee'/>">
      </logic:notEmpty>
      <logic:empty name="premiumFee"  >
      <input type="hidden" name="premiumFee" value="1">
      </logic:empty>
      <!--modify by qinyongli 2005-07-21 end-->
    </td>
  </tr>
  <tr> 
    <td class="title"  >立案号:</td>
    <td class="input"  ><input type="text" name="prpLclaimClaimNo" title="立案号" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='claimNo' filter='true'/>"> 
    </td>
    <td class="title" >理赔类型:</td>
    <td class="input"  >       
      <logic:equal name="prpLclaimDto" property="LFlag" value="D">
        <input type="text" name="prpLendcaseLFlag" title="理赔类型" maxlength="22" class="readonly" readonly="true"  value="代理赔"> 
      </logic:equal>
      <logic:equal name="prpLclaimDto" property="LFlag" value="L">
        <input type="text" name="prpLendcaseLFlag" title="理赔类型" maxlength="22" class="readonly" readonly="true"  value="理赔"> 
      </logic:equal>
    </td>
  </tr>
  <tr> 
    <td class="title"> 报案号:</td>
    <td class="input"> <input type="text" name="prpLclaimRegistNo" title="报案号" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='registNo' filter='true' />"> 
    </td>
    <td class="title"> 保单号:</td>
    <td class="input"> 
      <input type="text" name="prpLclaimPolicyNo" style="width:150px" class="readonly" readonly="true"  value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />"> 
      <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate2();return false;">
    </td> 
  </tr>  
 <%--此处仅能显示被保险人代码,且点击链接无法显示被保险人名称,故此处将此屏弊
  <tr> 
    <td class="title">被保险人代码:</td>
    <td class="input" colspan="3">  
    <logic:match name='prpLclaimDto' property="insuredCode" value="1" location="start">
    
      <a href='/claim/processPrpDcustomerIdv.do?actionType=prepareUpdate&prpDcustomerIdvCustomerCode=<bean:write name='prpLclaimDto' property='insuredCode' filter='true' />' target='_blank'>
    </logic:match>  
    <logic:notMatch name='prpLclaimDto' property="insuredCode" value="1" location="start">
      <a href='/claim/processPrpDcustomerUnit.do?actionType=prepareUpdate&prpDcustomerUnitCustomerCode=<bean:write name='prpLclaimDto' property='insuredCode' filter='true' />' target='_blank'>
    </logic:notMatch>
    <input type=hidden name="prpLregistInsuredCode" title="被保险人代码" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='insuredCode' filter='true' />">  
    <bean:write name='prpLclaimDto' property='insuredCode' filter='true' />
      </a>
    </td>
    <!--
    <td class="title"> 被保险人代码:</td>
    <td class="input" colspan="3"> 
      <input type="text" name="prpLclaimInsuredCode" title="被保险人" style="width:120px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='insuredCode' filter='true' />">
      
    </td>
    -->
  </tr>
 --%>
  <tr> 
    <td class="title"> 保险期间：</td>
    <td class="input" colspan="3"> <input type="text" name="prpLendcaseStartDate" class="readonly" style="width:340px" readonly="true"  value="<bean:write name='prpLclaimDto' property='startDate' filter='true' /> 日 0 时 至 <bean:write name='prpLclaimDto' property='endDate' filter='true' /> 日 24 时止">
    </td>
  </tr>
 
  <tr> 
    <td class="title"> 条款类别：</td>
    <td class="input" colspan="3">     
      <input class="readonly" type=text name="prpLclaimClauseType" readonly="true"  style="width:30px" value="<bean:write name='prpLclaimDto' property='clauseType' filter='true' />">
  
      <input class="readonly" type=text name="prpLclaimClauseName" readonly="true"  style="width:300px"value="<bean:write name='prpLclaimDto' property='clauseName' filter='true' />">      
    </td>
  </tr>
 
  <tr> 
    <td class="title"> 号牌号码:</td>
    <td class="input"> <input class="readonly" name="prpLclaimLicenseNo" style="width:90px" readonly="true" value="<bean:write name='prpLclaimDto' property='licenseNo' filter='true' />">
    </td>
    <td class="title"> 号牌底色: </td>
    <td class="input"> <input class="readonly"  name="prpLclaimLicenseColor" readonly="true" value="<bean:write name='prpLclaimDto' property='licenseColor' filter='true' />">
    </td>
  </tr>
 
  <tr> 
    <td class="title"> 厂牌型号:</td>
    <td class="input"> <input class="readonly" name="prpLclaimBrandName" readonly="true" value="<bean:write name='prpLclaimDto' property='brandName' filter='true' />">
    </td>
    <td class="title"> 车辆种类: </td>
    <td class="input"> <input name="prpLclaimCarKind"  class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='carKind' filter='true' />">
    </td>
  </tr>
 
  <tr> 
    <td class="title"> 币别:</td>
    <td class="input"> <input class="readonly" readonly name="prpLclaimCurrencyName" value="人民币">
    </td>
    <td class="title"> 保险金额: </td>
    <td class="input"> <input class="readonly" name="prpLclaimSumAmount" readonly="true" value="<bean:write name='prpLclaimDto' property='sumAmount' filter='true' format='##0.00'/>">
    </td>
  </tr>
 
  <tr> 
    <td class="title"> 出险时间:</td>
    <td class="input"> 
      <input type=text name="prpLendcaseDamageStartDate" readonly="true" class="readonly"  style="width:180px" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' /> 日 <bean:write name='prpLclaimDto' property='damageStartHour' filter='true' /> 时">
    </td>
    <td class="title"> 事故原因：</td>
    <td class="input"> 
      <input type=text class="readonly" readonly="true" name="prpLclaimDamageTypeName"  title="事故原因" value="<bean:write name='prpLclaimDto' property='damageTypeName' filter='true'/>">
    </td>
  </tr>
 
  <tr> 
    <td class="title"> 出险原因:</td>
    <td class="input"> <input type="text" name="prpLclaimDamageName"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='damageName' filter='true' />"> 
    </td>
    <td class="title"> 出险区域： </td>
    <td class="input"> <input type="text" name="prpLclaimDamageAreaName"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='damageAreaName' filter='true' />"> 
    </td>
  </tr>
 
  <tr> 
    <td class="title"> 出险地点：</td>
    <td class="input"> <input type="text" name="prpLclaimDamageAddress"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='damageAddress' filter='true' />"> 
    </td>
    <td class="title"> 立案日期: </td>
    <td class="input"> <input type="text" name="prpLclaimClaimDate"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='claimDate' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 事故责任：</td>
    <td class="input"> <input type="text" name="prpLclaimIndemnityDutyName"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='indemnityDutyName' filter='true' />"> 
    </td>
    <td class="title"> 责任比例： </td>
    <td class="input"> <input type="text" name="prpLclaimIndemnityDutyRate"  style="width:80px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='indemnityDutyRate' filter='true' format='##0.0000'/>">% 
    </td>
  </tr>
  <tr> 
    <td class="title"> 保险损失金额：</td>
    <td class="input"> <input type="text" name="prpLclaimSumClaim"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='sumClaim' filter='true' format='##0.00'/>"> 
    </td>
    <td class="title"> 赔案类别： </td>
    <td class="input"> <input type="text" name="prpLclaimClaimTypeName"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='claimTypeName' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 保单业务归属部门：</td>
    <td class="input"> <input type="text" name="prpLclaimComName"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='comName' filter='true' />"> 
    </td>
    <td class="title"> 归属业务员： </td>
    <td class="input"> <input type="text" name="prpLclaimHandler1Name"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='handler1Name' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 经办人：</td>
    <td class="input"> <input type="text" name="prpLclaimHandlerName"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='handlerName' filter='true' />"> 
    </td>
    <td class="title"> 赔付金额： </td>
    <td class="input"> <input type="text" name="prpLclaimSumPaid"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='sumPaid' filter='true' format='##0.00'/>"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 理赔部门：</td>
    <td class="input"> <input type="text" name="prpLendcaseMakeCom"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='makeComName' filter='true' />"> 
    </td>
    <td class="title"> 操作员： </td>
    <td class="input"> <input type="text" name="prpLregistOperatorName"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='operatorName' filter='true' />">
    </td>
  </tr>
  <tr> 
    <td class="title"> 输单日期：</td>
    <td class="input"> <input type="text" name="prpLclaimInputDate"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='inputDate' filter='true' />"> 
    </td>
    <td class="title"> 案件性质: </td>
    <td class="input"> <input type="text" name="prpLclaimCaseType"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='caseType' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 结案日期：</td>
    <td class="input"> <input type="text" name="prpLclaimEndCaseDate"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='endCaseDate' filter='true' />"> 
    </td>
    <td class="title"> 结案员： </td>
    <td class="input"> <input type="text" name="prpLclaimEndCaserCode"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='endCaserCode' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 注销日期：</td>
    <td class="input"> <input type="text" name="prpLclaimCancelDate"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='cancelDate' filter='true' />"> 
    </td>
    <td class="title"> 注销人:</td>
    <td class="input"> <input type="text" name="prpLclaimDealerCode"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='dealerCode' filter='true' />"> 
    </td>
  </tr> 
</table>
