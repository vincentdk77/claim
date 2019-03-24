<%--
****************************************************************************
* DESC       :添加主信息子块界面页面[ 立案 ]
* AUTHOR     :liubvo
* CREATEDATE :2004-05-12
* MODIFYLIST :  Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
****************************************************************************
--%>
<!-- add by zhangyingrui start 20060809-->
<% 
   String  limitfeeHaveDuty=(String) request.getAttribute("limitfeeHaveDuty");
   System.out.println("-------------------------------");
   System.out.println(limitfeeHaveDuty);
   System.out.println("-------------------------------");
   String  limitfeeNoneDuty= (String) request.getAttribute("limitfeeNoneDuty");
   //add by zhangyingrui start at 20060821
   String  sumBeforePrepaidzf=(String) request.getAttribute("sumBeforePrepaidzf");
   String  sumBeforePrepaiddf= (String) request.getAttribute("sumBeforePrepaiddf");
  //add by zhangyingrui end at 20060821
%>
<!-- add by zhangyingrui start 20060809-->
  
    <table cellpadding="5" cellspacing="1" class="common">
    <tr>
      
       <%--modify by wangli update start 20050409--%>
       <td><input type="button" class=bigbutton name="message" value="讨论留言" onclick="openWinSave(fm.prpLprepayClaimNo.value,fm.prpLprepayPolicyNo.value,fm.prpLprepayRiskCode.value,'prepa',fm.prpLprepayClaimNo.value)"></td>
       <td><input type="button" class=bigbutton name="messageView" value="查看留言" onclick="openWinQuery('claimNo',fm.prpLprepayClaimNo.value)"></td>
       <!--add by zhangyingrui start at 20060808-->
       <td><input type="button" name="eCertify" class="bigbutton" value="电子单证" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo',fm.registNo.value,'speci',fm.swfLogLogNo.value);"></td> 
       <td><input type="button" name="buttonCertifyDirect" class="bigbutton" value="索赔清单" onClick="doCertifyDirect(fm.registNo.value,'speci')"></td> 
       <td align="right"><font color="#666666">　注：“<font color="#FF0000">*</font>”为必选项，“<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">” 
      为双击选择项。</font></td>
      <!--add by zhangyingrui start at 20060808-->
      <%--modify by wangli update end 20050409--%>
    </tr>
    </table>
    <%  String caseType=request.getParameter("caseType");%>
<table  class=common cellpadding="5" cellspacing="1">
  <tr class=listtitle>   
    <td  colspan="4" >
      <% if("7".equals(caseType)){ %>支付抢救费登记 
      <% }else if ("8".equals(caseType)){ %>垫付抢救费登记
      <% }else {%>
       预付赔款登记 
      <% }%>
      <input type="hidden" name="prpLprepayRiskCode" value="<bean:write name='prpLprepayDto' property='riskCode' />"> 
      <input type="hidden" name="prpLprepayOperatorCode" value="<bean:write name='prpLprepayDto' property='operatorCode' />"> 
      <input type="hidden" name="prpLprepayMakeCom" value="<bean:write name='prpLprepayDto' property='makeCom' />">	
      <input type="hidden" name="prpLprepayInputDate" value="<bean:write name='prpLprepayDto' property='inputDate' />"> 
      <input type="hidden" name="prpLprepayLicenseColorCode" value="<bean:write name='prpLprepayDto' property='licenseColorCode' filter='true' />"> 
      <input type="hidden" name="prpLprepayCarKindCode" value="<bean:write name='prpLprepayDto' property='carKindCode' filter='true' />">
      <input type="hidden" name="prpLprepaySumPremium" value="<bean:write name='prpLprepayDto' property='sumPremium' filter='true' />">  
      <input type="hidden" name="prpLprepayCurrency" value="<bean:write name='prpLprepayDto' property='currency' filter='true' />"> 
      <input type="hidden" name="prpLprepayArrearageTimes" value="<bean:write name='prpLprepayDto' property='arrearageTimes' filter='true' />"> 
      <input type="hidden" name="prpLprepaySumArrearage" value="<bean:write name='prpLprepayDto' property='sumArrearage' filter='true' />"> 
      <input type="hidden" name="prpLprepaySumBeforePrePaid" value="<bean:write name='prpLprepayDto' property='sumBeforePrePaid' filter='true' />"> 
      <input type="hidden" name="prpLprepayBlockUpTimes" value="<bean:write name='prpLprepayDto' property='blockUpTimes' filter='true' />">       
      <input type="hidden" name="prpLprepaySumTotalPrepaid" value="<bean:write name='prpLprepayDto' property='sumTotalPrepaid' filter='true' />">         
      <input type="hidden" name="prpLprepayApproverCode" value="<bean:write name='prpLprepayDto' property='approverCode' filter='true' />"> 
      <input type="hidden" name="prpLprepayUnderWriteCode" value="<bean:write name='prpLprepayDto' property='underWriteCode' filter='true' />">  
      <input type="hidden" name="prpLprepayUnderWriteName" value="<bean:write name='prpLprepayDto' property='underWriteName' filter='true' />"> 
      <input type="hidden" name="prpLprepayUnderWriteEndDate" value="<bean:write name='prpLprepayDto' property='underWriteEndDate' filter='true' />">    
      <input type="hidden" name="prpLprepayCaseType" class="common" value="<%=request.getParameter("caseType")%>">
      
      <!--Modify by chenrenda update begin 20050426 从险别估损金额表取估损金额有可能用户在立案时没有录入险别估损金额信息-->
      <!--<input type="hidden" name="sumClaim"  value="<%= request.getAttribute("sumClaim") %>"> -->
      <input type="hidden" name="sumClaim"  value="<bean:write name='prpLprepayDto' property='sumClaim' filter='true' />"> 
      <!--Modify by chenernda updae end 20050426-->
      
      <input type="hidden" name="percent"  value="<%= AppConfig.get("sysconst.PrepayPercent") %>"> 
      <input type="hidden" name="prpLprepayUnderWriteFlag"  value="<bean:write name='prpLprepayDto' property='underWriteFlag' filter='true' />"> 
      <input type="hidden" name="prpLprepayFlag" value="<bean:write name='prpLprepayDto' property='flag' filter='true' />"> 
     	<input type="hidden" name="prpLprepayComCode"  value = "<bean:write name='prpLprepayDto' property='comCode' filter='true' />"> 
    	<input type="hidden" name="prpLprepayHandler1Code" value="<bean:write name='prpLprepayDto' property='handler1Code' filter='true' />"> 
    	    	
    	<input type="hidden" name="ClaimNo" value="<bean:write name='prpLprepayDto' property='claimNo' filter='true' />">     	
    	<input type="hidden" name="riskCode" value="<bean:write name='prpLprepayDto' property='riskCode' filter='true' />">     	
    	<input type="hidden" name="editType" value="ADD"> 
    	<input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
      <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
    	 <input type="hidden" name="prpLprepayClassCode" class="common" value="<bean:write name='prpLprepayDto' property='classCode' filter='true' />">  
    	<!--add by zhangyingrui start at 20060808-->	
    	<input type="hidden" name="registNo" class="common" value="<%=(String)request.getAttribute("registNo")%>">
    	<input type="hidden" name="limitfeeHaveDuty" class="common" value="<%=limitfeeHaveDuty%>">
    	<input type="hidden" name="limitfeeNoneDuty" class="common" value="<%=limitfeeNoneDuty%>">
    	<!--add by zhangyingrui start at 20060821-->
    	<input type="hidden" name="sumBeforePrepaidzf" class="common" value="<%=sumBeforePrepaidzf%>">
    	<input type="hidden" name="sumBeforePrepaiddf" class="common" value="<%=sumBeforePrepaiddf%>">
    	<!--add by zhangyingrui end at 20060821-->
    	<!--add by zhangyingrui start at 20060808-->	
      <!--modify by qinyongli 2005-07-21 start 增加保费是否已经实收信息-->
      <logic:notEmpty name="prePayFlag"  >
      <input type="hidden" name="prePayFlag" value="<bean:write name='prePayFlag'/>">
      </logic:notEmpty>
      <logic:empty name="prePayFlag"  >
      <input type="hidden" name="prePayFlag" value="1">
      </logic:empty>
      <!--modify by qinyongli 2005-07-21 end-->	
    </td>    
  </tr>
  <tr> 
    <td class="title"  style="width:15%"> 赔款号:</td>
    <td class="input"  style="width:35%"> <input type=text name="prpLprepayPreCompensateNo" title="预付赔款号" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLprepayDto' property='preCompensateNo' filter='true' />"> 
    </td>
    <td class="title"  style="width:15%"> 立案号:</td>
    <td class="input"  style="width:35%"> <input type=text name="prpLprepayClaimNo" title="立案号" maxlength="22" class="readonly" readonly="true"  value="<bean:write name='prpLprepayDto' property='claimNo' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 保单号:</td>
    <td class="input"> <input type=text name="prpLprepayPolicyNo" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLprepayDto' property='policyNo' filter='true' />">
    <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLprepayPolicyNo.value);return false;"> 
    </td>
    <td class="title"> 已出险次数:</td>
    <td class="input" >
          <%-- 出险信息画面 --%>
           <%@include file="/DAA/regist/DAAExistRegist.jsp"%>           
        </td>
    
    
  </tr>
  
  <tr> 
    <td class="title"> 条款类别:</td>
    <td class="input" colspan=3> <input class="readonly" type=text name="prpLprepayClauseName" readonly="true"  style="width:150px" value="<bean:write name='prpLprepayDto' property='clauseName' filter='true' />">	
    </td>
  </tr>
  
  <tr> 
    <td class="title"> 保险期间:</td>
    <td colspan="3" class="input"> 
    	<input type=text name="prpLprepayStartDate" class="readonly" style="width:340px" readonly="true"  value="<bean:write name='prpLprepayDto' property='startDate' filter='true' /> 日 0 时 至 <bean:write name='prpLprepayDto' property='endDate' filter='true' /> 日 24 时止">
      <!--
    	<input type=text name="prpLprepayStartDate" title="起保日期" class="readonly" style="width:80px" readonly="true"  value="<bean:write name='prpLprepayDto' property='startDate' filter='true' />">
       
      <input type=text name="prpLprepayEndDate"   title="终保日期" class="readonly" style="width:80px" readonly="true"   value="<bean:write name='prpLprepayDto' property='endDate' filter='true' />">
      二十四时止 
    -->
    </td>
  </tr>
  <tr> 
    <td class="title"> 号牌号码:</td>
    <td class="input"> <input class="readonly" name="prpLprepayLicenseNo" readonly="true" value="<bean:write name='prpLprepayDto' property='licenseNo' filter='true' />"> 
    </td>
    <td class="title"> 号牌底色:</td>
    <td class="input"> 
    	<input class="readonly"  name="prpLprepayLicenseColor" readonly="true" value="<bean:write name='prpLprepayDto' property='licenseColor' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 车辆种类:</td>
    <td class="input"> 
    	<input name="prpLprepayCarKind"  class="readonly" readonly="true" value="<bean:write name='prpLprepayDto' property='carKind' filter='true' />">  
    </td>
    <td class="title"> 厂牌型号:</td>
    <td class="input"> <input class="readonly" name="prpLprepayBrandName" readonly="true" value="<bean:write name='prpLprepayDto' property='brandName' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 发动机号:</td>
    <td class="input"> <input type="text" name="prpLprepayEngineNo" class="readonly" readonly="true" maxlength=20 description="发动机号" value="<bean:write name='prpLprepayDto' property='engineNo'/>"> 
    </td>
    <td class="title"> 车架号:</td>
    <td class="input"> <input type="text" name="prpLprepayFrameNo" class="readonly" readonly="true" maxlength=20 description="车架号" value="<bean:write name='prpLprepayDto' property='frameNo'/>"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 出险时间:</td>
    <td colspan="3" class="input"> 
    	<input type=text name="prpLprepayDamageStartDate" class="readonly" readonly="true" maxlength="10" style="width:250px" value="<bean:write name='prpLprepayDto' property='damageStartDate' filter='true' /> 日 <bean:write name='prpLprepayDto' property='damageStartHour' filter='true' /> 时 <bean:write name='prpLprepayDto' property='damageStartMinute' filter='true' /> 分">
    	<!--
    	<input type=text name="prpLprepayDamageStartDate" title="出险时间" class="input" maxlength="10" style="width:80px" value="<bean:write name='prpLprepayDto' property='damageStartDate' filter='true' />">
      日 
      <input type=text name="prpLprepayDamageStartHour" title="出险小时" class="input" maxlength="2" style="width:20px" value="<bean:write name='prpLprepayDto' property='damageStartHour' filter='true' />">
      时
      --> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 出险地点:</td>
    <td colspan="3" class="input"> <input type=text name="prpLprepayDamageAddress" title="出险地" style="width:400px" class="readonly" readonly="true" value="<bean:write name='prpLprepayDto' property='damageAddress' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 估损金额(CNY):</td>
    <td class="input"> <input class="readonly" readonly name="prpLprepaySumClaim" description="保险损失金额" value="<bean:write name='prpLprepayDto' property='sumClaim' filter='true' />"> 
    </td>
    <td class="title"> 保险金额(CNY):</td>
    <td class="input"> 
    	<input name="prpLprepaySumAmount" type="text" class="readonly" readonly="true" value="<bean:write name='prpLprepayDto' property='sumAmount' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title">币别:</td>
    <td class="input"> 
    	<input class="readonly" style="width:100" name="prpLprepayCurrencyName" value="人民币"><img src="/claim/images/bgMarkMustInput.jpg">
    </td>
    <td class="title"> 
    <% if("7".equals(caseType)){ %>预支付抢救费金额： 
      <% }else if ("8".equals(caseType)){ %>垫付抢救费金额：
      <% }else {%>
       预赔金额: 
      <% }%>
    </td>
    <td class="input"> 
    	<!---<input name="prpLprepaySumPrePaid" type="text" class="input" style="width:130" value="<bean:write name='prpLprepayDto' property='sumPrePaid' filter='true' />"   onblur="checkBeyondLimitFee(this);"><img src="/claim/images/bgMarkMustInput.jpg">--->
		<input name="prpLprepaySumPrePaid" type="text" class="input" style="width:130" value="<bean:write name='prpLprepayDto' property='sumPrePaid' filter='true' />"><img src="/claim/images/bgMarkMustInput.jpg"> 
    </td>
  </tr>
  <tr>
   <td class="input" colspan="4">
	<%@include file="/common/prepay/DAAPrepayChargeEdit.jsp"%>
	</td>
  </tr>
  <tr> 
    <td class="title"> 业务归属机构:</td>
    <td class="input"> 
      <input type=text   name="prpLprepayComName" title="业务归属机构" class="readonly" readonly="true" value = "<bean:write name='prpLprepayDto' property='comName' filter='true' />"> 
    </td>
    <td class="title">归属业务员:</td>
    <td class="input"> 
      <input type=text   name="prpLprepayHandler1Name" title="归属业务员" class="readonly" readonly="true" value="<bean:write name='prpLprepayDto' property='handler1Name' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 经办人:</td>
    <td class="input"> 
      <input name="prpLprepayHandlerCode" class="codecode" style="width:40%" value="<bean:write name='prpLprepayDto' property='handlerCode' filter='true' />"
          ondblclick="code_CodeSelect(this, 'HanderCode');"
          onchange="code_CodeChange(this, 'HanderCode');"
          onkeyup= "code_CodeSelect(this, 'HanderCode');"> <input name="prpLprepayHandlerName" class="codename" style="width:50%"  title="经办人" value="<bean:write name='prpLprepayDto' property='handlerName' filter='true' />"
         ondblclick="code_CodeSelect(this, 'HanderCode','-1','always','none','post');"
         onkeyup= "code_CodeSelect(this, 'HanderCode','-1','always','none','post');"><img src="/claim/images/bgMarkMustInput.jpg">
    </td>
    <td class="title"> 统计年月:</td>
    <td class="input"> <input type="text" class="input" style="width:130" name="prpLprepayStatisticsYM" value="<bean:write name='prpLprepayDto' property='statisticsYM' filter='true' />">
			<img src="/claim/images/bgMarkMustInput.jpg">
    </td>
  </tr>
</table>
