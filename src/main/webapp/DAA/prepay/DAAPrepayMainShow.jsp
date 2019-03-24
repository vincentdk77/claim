<%--
****************************************************************************
* DESC       ：添加主信息子块界面页面[ 立案 ]
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-05-12
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
  
    <table cellpadding="5" cellspacing="1" class="common">
    <tr>
       
       <%--modify by wangli update start 20050409--%>
       <td><input type="button" class=bigbutton name="message" value="讨论留言" onclick="openWinSave(fm.prpLprepayClaimNo.value,fm.prpLprepayPolicyNo.value,fm.prpLprepayRiskCode.value,'prepa',fm.prpLprepayClaimNo.value)"></td>
       <td><input type="button" class=bigbutton name="messageView" value="查看留言" onclick="openWinQuery('claimNo',fm.prpLprepayClaimNo.value)"></td>
      
      <%--modify by wangli update end 20050409--%>
    </tr>
    </table>
<table  class=common cellpadding="5" cellspacing="1">
  <tr class=listtitle> 
    <td colspan="4" >预付赔款登记 
      <input type="hidden" name="prpLprepayUnderWriteFlag"  value="0"> 
    </td>
  </tr>
  <tr> 
    <td class="title"  style="width:15%"> 预付赔款号：</td>
    <td class="input"  style="width:35%"> <input type=text name="prpLprepayPreCompensateNo" title="预付赔款号" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLprepayDto' property='preCompensateNo' filter='true' />"> 
    </td>
    <td class="title"  style="width:15%"> 立案号： </td>
    <td class="input"  style="width:35%"> <input type=text name="prpLprepayClaimNo" title="立案号" maxlength="22" class="readonly" readonly="true"  value="<bean:write name='prpLprepayDto' property='claimNo' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 保单号： </td>
    <td class="input"> <input type=text name="prpLprepayPolicyNo" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLprepayDto' property='policyNo' filter='true' />"><input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.PolicyNo.value);"> 
    </td>
    <td class="title"> 条款类别： </td>
    <td class="input"> <input class="readonly" type=text name="prpLprepayClauseName" readonly="true"  style="width:150px" value="<bean:write name='prpLprepayDto' property='clauseName' filter='true' />">	
    </td>
  </tr>
  
  <tr> 
    <td class="title"> 保险期间：</td>
    <td colspan="3" class="input"> 
    	<input type=text name="prpLprepayStartDate" class="readonly" style="width:340px" readonly="true"  value="<bean:write name='prpLprepayDto' property='startDate' filter='true' /> 日 0 时 至 <bean:write name='prpLprepayDto' property='endDate' filter='true' /> 日 24 时止">     
    </td>
  </tr>
  <tr> 
    <td class="title"> 号牌号码:</td>
    <td class="input"> <input class="readonly" name="prpLprepayLicenseNo" readonly="true" value="<bean:write name='prpLprepayDto' property='licenseNo' filter='true' />"> 
    </td>
    <td class="title"> 号牌底色： </td>
    <td class="input"> 
    	<input class="readonly"  name="prpLprepayLicenseColor" readonly="true" value="<bean:write name='prpLprepayDto' property='licenseColor' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 车辆种类：</td>
    <td class="input"> 
    	<input name="prpLprepayCarKind"  class="readonly" readonly="true" value="<bean:write name='prpLprepayDto' property='carKind' filter='true' />">  
    </td>
    <td class="title"> 厂牌型号：</td>
    <td class="input"> <input class="readonly" name="prpLprepayBrandName" readonly="true" value="<bean:write name='prpLprepayDto' property='brandName' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 发动机号： </td>
    <td class="input"> <input type="text" name="prpLprepayEngineNo" class="readonly" readonly="true" maxlength=20 description="发动机号" value="<bean:write name='prpLprepayDto' property='engineNo'/>"> 
    </td>
    <td class="title"> 车架号： </td>
    <td class="input"> <input type="text" name="prpLprepayFrameNo" class="readonly" readonly="true" maxlength=20 description="车架号" value="<bean:write name='prpLprepayDto' property='frameNo'/>"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 出险时间：</td>
    <td colspan="3" class="input"> 
    	<input type=text name="prpLprepayDamageStartDate" class="readonly" readonly="true" maxlength="10" style="width:250px" value="<bean:write name='prpLprepayDto' property='damageStartDate' filter='true' /> 日 <bean:write name='prpLprepayDto' property='damageStartHour' filter='true' /> 时">
    </td>
  </tr>
  <tr> 
    <td class="title"> 出险地点：</td>
    <td colspan="3" class="input"> <input type=text name="prpLprepayDamageAddress" title="出险地" style="width:400px" class="readonly" readonly="true" value="<bean:write name='prpLprepayDto' property='damageAddress' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 估损金额(CNY)：</td>
    <td class="input"> <input class="readonly" readonly name="prpLprepaySumClaim" description="保险损失金额" value="<bean:write name='prpLprepayDto' property='sumClaim' filter='true' />"> 
    </td>
    <td class="title"> 保险金额(CNY)：</td>
    <td class="input"> 
    	<input name="prpLprepaySumAmount" type="text" class="readonly" readonly="true" value="<bean:write name='prpLprepayDto' property='sumAmount' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title">币别： </td>
    <td class="input"> 
    	<input class="readonly" style="width:100" name="prpLprepayCurrencyName" value="人民币"><img src="/claim/images/bgMarkMustInput.jpg">
    </td>
    <td class="title"> 预赔金额：</td>
    <td class="input"> 
    	<input name="prpLprepaySumPrePaid" type="text" class="readonly" readonly="true" style="width:130" value="<bean:write name='prpLprepayDto' property='sumPrePaid' filter='true' />"><img src="/claim/images/bgMarkMustInput.jpg"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 业务归属机构： </td>
    <td class="input"> 
      <input type=text   name="prpLprepayComName" title="业务归属机构" class="readonly" readonly="true" value = "<bean:write name='prpLprepayDto' property='comName' filter='true' />"> 
    </td>
    <td class="title">归属业务员：</td>
    <td class="input"> 
      <input type=text   name="prpLprepayHandler1Name" title="归属业务员" class="readonly" readonly="true" value="<bean:write name='prpLprepayDto' property='handler1Name' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 经办人： </td>
    <td class="input"> 
      <input name="prpLprepayHandlerCode" class="readonly" readonly="true" style="width:80" value="<bean:write name='prpLprepayDto' property='handlerCode' filter='true' />"> 
      <input name="prpLprepayHandlerName" class="readonly" readonly="true"  style="width:80"  title="经办人" value="<bean:write name='prpLprepayDto' property='handlerName' filter='true' />"><img src="/claim/images/bgMarkMustInput.jpg">
    </td>
    <td class="title"> 统计年月：</td>
    <td class="input"> <input type="text" class="readonly" readonly="true" style="width:130" name="prpLprepayStatisticsYM" value="<bean:write name='prpLprepayDto' property='statisticsYM' filter='true' />">
			<img src="/claim/images/bgMarkMustInput.jpg">
    </td>
  </tr>
</table>
