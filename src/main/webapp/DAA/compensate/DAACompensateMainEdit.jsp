<%--
****************************************************************************
* DESC       ：添加主信息子块界面页面[ 实赔 ]
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-05-12
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
   
<table  class=common cellpadding="5" cellspacing="1">
  <tr class=listtitle> 
    <td  colspan="4" >赔款计算书 
      <input type="hidden" name="prpLcompensateCompensateNo" value="<bean:write name='prpLcompensateDto' property='compensateNo' />"> 
      <input type="hidden" name="prpLcompensateCaseNo" value="<bean:write name='prpLcompensateDto' property='caseNo' />"> 
      <input type="hidden" name="prpLcompensateTimes" value="<bean:write name='prpLcompensateDto' property='times' />"> 
      <input type="hidden" name="prpLcompensateClassCode" value="<bean:write name='prpLcompensateDto' property='classCode' />"> 
      <input type="hidden" name="prpLcompensateRiskCode" value="<bean:write name='prpLcompensateDto' property='riskCode' />"> 
      <input type="hidden" name="prpLcompensateClaimNo" value="<bean:write name='prpLcompensateDto' property='claimNo' />"> 
      <input type="hidden" name="prpLcompensatePolicyNo" value="<bean:write name='prpLcompensateDto' property='policyNo' />"> 
      <input type="hidden" name="prpLcompensateDeductCond" value="<bean:write name='prpLcompensateDto' property='deductCond' />"> 
      <input type="hidden" name="prpLcompensatePreserveDate" value="<bean:write name='prpLcompensateDto' property='preserveDate' />"> 
      <input type="hidden" name="prpLcompensateCheckAgentCode" value="<bean:write name='prpLcompensateDto' property='checkAgentCode' />"> 
      <input type="hidden" name="prpLcompensateCheckAgentName" value="<bean:write name='prpLcompensateDto' property='checkAgentName' />"> 
      <input type="hidden" name="prpLcompensateSurveyorName" value="<bean:write name='prpLcompensateDto' property='surveyorName' />"> 
      <input type="hidden" name="prpLcompensateCounterClaimerName" value="<bean:write name='prpLcompensateDto' property='counterClaimerName' />"> 
      <input type="hidden" name="prpLcompensateDutyDescription" value="<bean:write name='prpLcompensateDto' property='dutyDescription' />"> 
      <input type="hidden" name="prpLcompensateCurrency" value="<bean:write name='prpLcompensateDto' property='currency' />"> 
      <input type="hidden" name="prpLcompensateSumLoss" value="<bean:write name='prpLcompensateDto' property='sumLoss' />"> 
      <input type="hidden" name="prpLcompensateSumRest" value="<bean:write name='prpLcompensateDto' property='sumRest' />"> 
      <input type="hidden" name="prpLcompensateSumDutyPaid" value="<bean:write name='prpLcompensateDto' property='sumDutyPaid' />"> 
      <input type="hidden" name="prpLcompensateSumNoDutyFee" value="<bean:write name='prpLcompensateDto' property='sumNoDutyFee' />"> 
      <input type="hidden" name="prpLcompensateSumPaid" value="<bean:write name='prpLcompensateDto' property='sumPaid' />"> 
      <input type="hidden" name="prpLcompensateSumPrePaid" value="<bean:write name='prpLcompensateDto' property='sumPrePaid' />"> 
      <input type="hidden" name="prpLcompensateSumThisPaid" value="<bean:write name='prpLcompensateDto' property='sumThisPaid' />"> 
      <input type="hidden" name="prpLcompensateReceiverName" value="<bean:write name='prpLcompensateDto' property='receiverName' />"> 
      <input type="hidden" name="prpLcompensateBank" value="<bean:write name='prpLcompensateDto' property='bank' />"> 
      <input type="hidden" name="prpLcompensateAccount" value="<bean:write name='prpLcompensateDto' property='account' />"> 
      <input type="hidden" name="prpLcompensateMakeCom" value="<bean:write name='prpLcompensateDto' property='makeCom' />"> 
      <input type="hidden" name="prpLcompensateComCode" value="<bean:write name='prpLcompensateDto' property='comCode' />"> 
      <input type="hidden" name="prpLcompensateHandlerCode" value="<bean:write name='prpLcompensateDto' property='handlerCode' />"> 
      <input type="hidden" name="prpLcompensateHandler1Code" value="<bean:write name='prpLcompensateDto' property='handler1Code' />"> 
      <input type="hidden" name="prpLcompensateApproverCode" value="<bean:write name='prpLcompensateDto' property='approverCode' />"> 
      <input type="hidden" name="prpLcompensateUnderWriteCode" value="<bean:write name='prpLcompensateDto' property='underWriteCode' />"> 
      <input type="hidden" name="prpLcompensateUnderWriteName" value="<bean:write name='prpLcompensateDto' property='underWriteName' />"> 
      <input type="hidden" name="prpLcompensateOperatorCode" value="<bean:write name='prpLcompensateDto' property='operatorCode' />"> 
      <input type="hidden" name="prpLcompensateInputDate" value="<bean:write name='prpLcompensateDto' property='inputDate' />"> 
      
      <input type="hidden" name="prpLcompensateUnderWriteEndDate" value="2005/06/08"> 
      
      
    </td>
  </tr>
  <tr> 
    <td class="title"  style="width:15%"> 计算书号：</td>
    <td class="input"  style="width:35%"> <input type=text name="prpLcompensateCompensateNo" title="计算书号" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='compensateNo' />"> 
    </td>
    <td class="title"  style="width:15%"> 理赔类型： </td>
    <td class="input"  style="width:35%"> 
        <select name="prpLcompensateLFlag" onchange="return changeLFlag(this);">
          <option value="L">理赔</option>
          <option value="D">代理赔</option>
        </select>    
    </td>
  </tr>
  <tr> 
    <td class="title"> 立案号： </td>
    <td class="input"> <input class="readonly" type=text name="prpLcompensateClaimNo" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='claimNo' filter='true' />">  
    </td>
    <td class="title"> 保单号： </td>
    <td class="input"> <input type=text name="prpLcompensatePolicyNo" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLcompensateDto' property='policyNo' filter='true' />"><input type="image" name="btRelate" src="/claim/images/car_18-1.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLcompensatePolicyNo.value);"> 
    </td>
  </tr>
  
  <tr> 
    <td class="title" colspan="3"> 被保险人： </td>
    <td class="input"> <input class="readonly" type=text name="prpLcompensateInsuredName" readonly="true"  style="width:250px" value="<bean:write name='prpLcompensateDto' property='insuredName' filter='true' />">  
    </td>
  </tr>
  
  <tr> 
    <td class="title"> 保险期间：</td>
    <td colspan="3" class="input"> 
      <input type=text name="prpLcompensateStartDate" class="readonly" style="width:340px" readonly="true"  value="<bean:write name='prpLcompensateDto' property='startDate' filter='true' /> 日 0 时 至 <bean:write name='prpLcompensateDto' property='endDate' filter='true' /> 日 24 时止">
    </td>
  </tr>
  
  <tr> 
    <td class="title"> 条款类别：</td>
    <td class="input"> <input class="readonly" type=text name="prpLcompensateClauseName" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='clauseName' filter='true' />">  
    </td>
    <td class="title"> 号牌号码： </td>
    <td class="input"> <input class="readonly" name="prpLcompensateLicenseNo" readonly="true" value="<bean:write name='prpLcompensateDto' property='licenseNo' filter='true' />"> 
    </td>
  </tr>
  
  <tr> 
    <td class="title"> 车辆种类： </td>
    <td class="input"> <input name="prpLcompensateCarKind"  class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='carKind' filter='true' />">  
    </td>
    <td class="title"> 号牌底色： </td>
    <td class="input"> <input class="readonly"  name="prpLcompensateLicenseColor" readonly="true" value="<bean:write name='prpLcompensateDto' property='licenseColor' filter='true' />"> 
    </td>
  </tr>
  
  <tr> 
    <td class="title"> 厂牌型号： </td>
    <td class="input"> <input class="readonly" name="prpLcompensateBrandName" readonly="true" value="<bean:write name='prpLcompensateDto' property='brandName' filter='true' />"> 
    </td>
    <td class="title"> 发动机号： </td>
    <td class="input"> <input type="text" name="prpLcompensateEngineNo" class="readonly" readonly="true" maxlength=20 description="发动机号" value="<bean:write name='prpLcompensateDto' property='engineNo'/>"> 
    </td>
  </tr>
  
  <tr> 
    <td class="title"> 车架号： </td>
    <td class="input" colspan="3" > <input type="text" name="prpLcompensateFrameNo" class="readonly" readonly="true" maxlength=20 description="车架号" value="<bean:write name='prpLcompensateDto' property='frameNo'/>"> 
    </td>
  </tr>
  
  <tr> 
    <td class="title"> 出险时间： </td>
    <td class="input" colspan="3"> <input type=text name="prpLcompensateDamageStartDate" class="readonly" readonly="true" maxlength="10" style="width:250px" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' /> 日 <bean:write name='prpLcompensateDto' property='damageStartHour' filter='true' /> 时">
    </td>
  </tr>
  <tr> 
    <td class="title"> 出险地点： </td>
    <td colspan="3" class="input"> <input type=text name="prpLcompensateDamageAddress" title="出险地" style="width:400px" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='damageAddress' filter='true' />"> 
    </td>
  </tr>
  
  <tr> 
    <td class="title"> 币别： </td>
    <td colspan="3" class="input"> 
      <input class="readonly" readonly name="prpLcompensateCurrencyName" value="人民币">
    </td>
  </tr>
  
  <tr> 
    <td class="title"> 保险金额：</td>
    <td class="input"> <input name="prpLcompensateSumAmount" type="text" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='sumAmount' filter='true' />"> 
    </td>
    <td class="title"> 估损金额： </td>
    <td class="input"> <input class="readonly" readonly name="prpLcompensateSumClaim" description="保险损失金额" value="<bean:write name='prpLcompensateDto' property='sumClaim' filter='true' />"> 
    </td>
  </tr>  
  <tr> 
    <td class="title"> 责任赔款合计： </td>
    <td class="input"> <input class="readonly" type=text name="prpLcompensateSumDutyPaid" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='sumDutyPaid' filter='true' />">  
    </td>
    <td class="title"> 其它费用： </td>
    <td class="input"> <input type=text name="prpLcompensateSumNoDutyFee" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLcompensateDto' property='sumNoDutyFee' filter='true' />"> 
    </td>
  </tr>
  
  <tr> 
    <td class="title"> 赔款合计： </td>
    <td class="input"> <input class="readonly" type=text name="prpLcompensateSumPaid" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='sumPaid' filter='true' />">  
    </td>
    <td class="title"> 已预付赔款： </td>
    <td class="input"> <input type=text name="prpLcompensateSumPrePaid" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLcompensateDto' property='sumPrePaid' filter='true' />"> 
    </td>
  </tr>
  
  <tr> 
    <td class="title"> 本次赔付金额： </td>
    <td class="input" colspan="3"> <input class="readonly" type=text name="prpLcompensateSumThisPaid" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='sumThisPaid' filter='true' />">  
    </td>
  </tr>
  
  <tr> 
    <td class="title"> 业务经办人： </td>
    <td class="input" colspan="3">  <input name="prpLcompensateHandlerCode" class="codecode" style="width:60%" value="<bean:write name='prpLcompensateDto' property='handlerCode' filter='true' />"> 
      <input name="prpLcompensateHandlerName" class="codename" readonly="true" style="width:35%"  title="经办人" value="<bean:write name='prpLcompensateDto' property='handlerName' filter='true' />"> 
    </td>
  </tr>
  
  
  <tr> 
    <td class="title"> 统计年月： </td>
    <td class="input"> <input type="text" size="15" name="prpLcompensateStatisticsYM" value="<bean:write name='prpLcompensateDto' property='statisticsYM' filter='true' />">
    </td>
    <td class="title"> 查勘人： </td>
    <td class="input"> <input type=text name="prpLcompensateChecker1" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLcompensateDto' property='checker1' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 备注： </td>
    <td class="input" colspan="3"> <input class="readonly" type=text name="prpLcompensateRemark" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='remark' filter='true' />">  
    </td>
  </tr>

</table>
