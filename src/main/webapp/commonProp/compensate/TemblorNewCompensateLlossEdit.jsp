<%--
****************************************************************************
* DESC       ：赔付标的信息页面
* AUTHOR     ：qianxiantao
* CREATEDATE ： 2011-10-31
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.function.insutil.dto.domain.PrpDexchDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpCitemKindDto"%>
<%@page import="java.text.*"%>
<%@ page import="java.util.*"%>

<%--多行输入自定义JavaScript方法域--%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpCitemKindAgriFacade"%>
<%@page import="com.sinosoft.prpall.schema.PrpCvirturlItemSchema"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpCitemKindAgriDto"%>
<%@page import="com.sinosoft.sysframework.common.util.StringUtils"%>
<%@page import="com.sinosoft.prpall.pubfun.GroupProposalService"%>
<%@page import="com.gyic.claim.ui.control.facade.UIClaimPlantingSettleLoadFacade"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
  <%
  UIClaimPlantingSettleLoadFacade uIClaimPlantingSettleLoadFacade = new UIClaimPlantingSettleLoadFacade();
  String policyNoForHn= request.getParameter("policyNo");
     String settleListCode=(String)request.getAttribute("settleListCode");
     String disabledFlag="";
     String disableEditSettleList = "disabled";
     String disableViewSettleList = "disabled";
  if(editType.equals("SHOW")){
     disabledFlag="disabled";
     disableViewSettleList = "";
  %>
     <jsp:include page="/commonProp/compensate/TemblorNewCompensateLlossEditIni.jsp"/>
  <%  
  }else if(editType.equals("EDIT")){
  	disableEditSettleList = "";
  %>
     <jsp:include page="/commonProp/compensate/TemblorNewCompensateLlossEditIni.jsp"/>
  <%
  }else if("ADD".equalsIgnoreCase(editType))  	
  	disableEditSettleList = "";
  %>
<script language="javascript">
      //在下面加入本页自定义的JavaScript方法
       /*
       *检查险别的多条保险金额之和是否超过了该险别的保额
       */
       function checkKindAmount(field,times){  
 
            //如果是由险别名称双击域事件而导致触发了这个函数，则times＝‘first’，如不加这个判断，则在双击险别是可能会弹出两次相同的提示          
            if(times == "first"){
                field.select();
                field.focus();
                return false;           
            }
            var kindCode ;          //险别
            var kindName ;          //险别名称
            var amount = 0;     
            var allAmount = 0;      //保险金额
            var allAmountTemp = 0;
            var lossSerialNo = 0;   //序号
            var lossItemCode ;      //损失标的代码
            var lossItemName ;      //损失标的名称
            var strClassCode = fm.classcodeM.value; 
            for(var i = 0;i < fm.all(field.name).length;i++){                
                if(field == fm.all("prpLlossDtoAmount")[i]){ 
                    if(strClassCode == '31' || fm.prpLcompensateRiskCode.value == "3219" || fm.prpLcompensateRiskCode.value == "3221"){
                     var test = fm.all("prpLlossDtoAmountDisplay")[i].value;
                     var n = test.split("-");
                     allAmount  = parseFloat(n[1]);
                    }else{                                       
                    allAmount  = parseFloat(fm.all("prpLlossDtoAmountDisplay")[i].value);
                    }
                    if(isNaN(allAmount))
                        allAmount = 0;
                    kindCode = fm.all("prpLlossDtoKindCode")[i].value;
                    kindName = fm.all("prpLlossDtoKindName")[i].value;
                    lossSerialNo = fm.all("prpLlossSerialNo")[i].value;
                    lossItemCode = fm.all("prpLlossDtoItemCode")[i].value;
                    lossItemName = fm.all("prpLlossDtoLossName")[i].value;
                }
            }
            //计算页面上输入的各条损失信息的保险金额的和
            for(var i = 0 ;i < fm.all(field.name).length;i++){                
                if(  fm.all("prpLlossSerialNo")[i].value    == lossSerialNo 
                  && fm.all("prpLlossDtoKindCode")[i].value == kindCode
                  && fm.all("prpLlossDtoItemCode")[i].value == lossItemCode){
                    amount = parseFloat(fm.all("prpLlossDtoAmount")[i].value);
                    if(isNaN(amount))
                        amount = 0;
                    allAmountTemp = allAmountTemp + amount;                    
                }
            }            
            if(allAmountTemp > allAmount){
              field.select();
                field.focus();
                alert("被保险人 （" + fm.all("prpLlossDtoFamilyName")[lossSerialNo].value + "） " + kindName + "（" + lossItemName +"）" + "各条损失信息的保险金额之和，\n"
                        + "超过了该险别的保险金额（"+ allAmount + "）");
                
                return false;
            }
            
       }
       function calBackMainAgri(){
         var SettleArea=0;
         var SettleAreaTemp=0;
         var ProductionArea=0;
         var SettleAreaAll=fm.SettleAreaAll.value;
         var NoProductionArea=fm.NoProductionArea.value;
         fm.calBackMainAgriFlag.value="1";
         if(fm.creatCompensateLlossFlag.value=="0"){
            alert("请先生成标的信息！");
            fm.calBackMainAgriFlag.value="0";
            return false;
          }
         if(SettleAreaAll==""||SettleAreaAll==null){
         for(var i=0;i<fm.all("prpLlossDtoSettleArea").length;i++){       
             SettleArea=parseFloat(fm.all("prpLlossDtoSettleArea")[i].value);  
             if(isNaN(SettleArea)){
             SettleArea=0;
             }
             SettleAreaTemp=SettleAreaTemp+SettleArea
         }
         fm.prpLcompensateLossesNumber.value=round(SettleAreaTemp,3);
         fm.prpLcompensateAffectedArea.value=round(SettleAreaTemp,3);
         fm.prpLcompensateDisasterArea.value=round(SettleAreaTemp,3);
         }else{
         fm.prpLcompensateLossesNumber.value=round(parseFloat(SettleAreaAll),3);
         fm.prpLcompensateAffectedArea.value=round(parseFloat(SettleAreaAll),3);
         fm.prpLcompensateDisasterArea.value=round(parseFloat(SettleAreaAll),3);
         }
         if(NoProductionArea==""||NoProductionArea==null){
         for(var i=0;i<fm.all("prpLlossDtoSettleArea").length;i++){
             if(fm.all("indemnityDutyRate")[i].value>=80){
             ProductionArea=ProductionArea+parseFloat(fm.all("prpLlossDtoSettleArea")[i].value);  
             }
         }
         fm.prpLcompensateNoProductionArea.value=round(ProductionArea,3);
         }else{
          fm.prpLcompensateNoProductionArea.value=round(parseFloat(NoProductionArea),3);
         }
         fm.prpLcompensateDamageInsured.value=fm.DamageInsured.value; 
       }
       function flashCompensateLoss(policyNo,claimNo,settleListCode){
          fm.creatCompensateLlossFlag.value="1";
          if(checkFamilyName()==false){
            return false;
          }
          var policyno=policyNo.value;
          var claimno=claimNo.value;
          var settlelistCode=settleListCode.value;
          if(settlelistCode==null || trim(settlelistCode)==""){
            alert("请先缮制清单！");
            return false;
          }
          if(checkCoinsPaidLossType() == false ){
			  return false ; 
		  }
          var oldAction = fm.action;
          var oldTarget = fm.target;
          fm.action='/claim//CompensateNewLoss.do?claimNo='+claimno+'&policyNo='+policyno+'&SettleListCode='+settlelistCode;
          fm.target="fraSubmit";
          fm.submit();
          fm.action=oldAction;
          fm.target=oldTarget;  
       }
       
       function checkFamilyName(){
        var FamilyName =fm.prpLlossDtoFamilyName.value;
        if(FamilyName==null || trim(FamilyName)==""){
             alert("被保险人不能为空！");
             fm.creatCompensateLlossFlag.value="0";
             fm.prpLlossDtoFamilyName.focus();
             return false;
        }else{
             return true;
        }
       }
       /**
      * 预缮制清单页面弹出
      */
      function openCompensateSettleListPage(editType,nodeType){
        var policyNo = fm.policyno.value;
    	var registNo = fm.registno.value;
    	var claimNo = fm.prpLcompensateClaimNo.value;
    	var compensateNo = fm.prpLcompensateCompensateNo.value;
      	var newWindow = window.open("/claim/settleList.do?policyNo=" +policyNo+ "&registNo=" +registNo+"&nodeType="+nodeType+"&editType="+editType+"&isFirst='isFirst'&compensateNo="+compensateNo+"&claimNo="+claimNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
      }
      /**
      * 非中央政策性农险预缮制清单页面弹出
      */
      function openCompensate31SettleListPage(editType,nodeType){
        var policyNo = fm.policyno.value;
    	var registNo = fm.registno.value;
    	var claimNo = fm.prpLcompensateClaimNo.value;
    	var compensateNo = fm.prpLcompensateCompensateNo.value;
      	var newWindow = window.open("/claim/planting31SettleList.do?policyNo=" +policyNo+ "&registNo=" +registNo+"&nodeType="+nodeType+"&editType="+editType+"&isFirst='isFirst'&compensateNo="+compensateNo+"&claimNo="+claimNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
      }
      
       /**
      * 非中央政策性农险预缮制清单页面弹出
      */
      function openCompensate3224SettleListPage(editType,nodeType){
        var policyNo = fm.policyno.value;
    	var registNo = fm.registno.value;
    	var claimNo = fm.prpLcompensateClaimNo.value;
    	var compensateNo = fm.prpLcompensateCompensateNo.value;
      	var newWindow = window.open("/claim/planting3224SettleList.do?policyNo=" +policyNo+ "&registNo=" +registNo+"&nodeType="+nodeType+"&editType="+editType+"&isFirst='isFirst'&compensateNo="+compensateNo+"&claimNo="+claimNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
      }
      
       function openCompensate0311SettleListPage(editType,nodeType){
        var policyNo = fm.policyno.value;
    	var registNo = fm.registno.value;
    	var claimNo = fm.prpLcompensateClaimNo.value;
    	var compensateNo = fm.prpLcompensateCompensateNo.value;
      	var newWindow = window.open("/claim/temblor0311SettleList.do?policyNo=" +policyNo+ "&registNo=" +registNo+"&nodeType="+nodeType+"&editType="+editType+"&isFirst='isFirst'&compensateNo="+compensateNo+"&claimNo="+claimNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
      }
      /**
      * 非中央政策性农险生成赔付标的信息
      */
         function flash31CompensateLoss(policyNo,claimNo,settleListCode){
          fm.creatCompensateLlossFlag.value="1";
          if(checkFamilyName()==false){
            return false;
          }
          var policyno=policyNo.value;
          var claimno=claimNo.value;
          var settlelistCode=settleListCode.value;
          if(settlelistCode==null || trim(settlelistCode)==""){
            alert("请先缮制清单！");
            return false;
          }
          var oldAction = fm.action;
          var oldTarget = fm.target;
          fm.action='/claim/CompensatePlanting31Loss.do?claimNo='+claimno+'&policyNo='+policyno+'&SettleListCode='+settlelistCode;
          fm.target="fraSubmit";
          fm.submit();
          fm.action=oldAction;
          fm.target=oldTarget;  
       }
       
          function flash0311CompensateLoss(policyNo,claimNo,settleListCode){
          fm.creatCompensateLlossFlag.value="1";
          if(checkFamilyName()==false){
            return false;
          }
          var policyno=policyNo.value;
          var claimno=claimNo.value;
          var settlelistCode=settleListCode.value;
          if(settlelistCode==null || trim(settlelistCode)==""){
            alert("请先缮制清单！");
            return false;
          }
          var oldAction = fm.action;
          var oldTarget = fm.target;
          fm.action='/claim/CompensateTemblor0311Loss.do?claimNo='+claimno+'&policyNo='+policyno+'&SettleListCode='+settlelistCode;
          fm.target="fraSubmit";
          fm.submit();
          fm.action=oldAction;
          fm.target=oldTarget;  
       }
       /**
       * 非中央政策性农险汇总赔付标的信息
       */
       function calBackMainTemblor0311(){
         var SettleArea=0;
         var SettleAreaTemp=0;
         var ProductionArea=0;
         var SettleAreaAll=fm.SettleAreaAll.value;
         var NoProductionArea=fm.NoProductionArea.value;
         fm.calBackMainAgriFlag.value="1";
         if(fm.creatCompensateLlossFlag.value=="0"){
            alert("请先生成标的信息！");
            fm.calBackMainAgriFlag.value="0";
            return false;
          }
          changeCoinsSumPaid();
         //alert(fm.prpLlossDtoSerialNo.length);
         //fm.prpLcompensateLossesNumber.value=fm.SettleAreaAll.value;
         ///fm.prpLcompensateAffectedArea.value=fm.SettleAreaAll.value;
         //fm.prpLcompensateDisasterArea.value=fm.SettleAreaAll.value;
         
         
         //fm.prpLcompensateNoProductionArea.value=fm.NoProductionArea.value;
         //fm.prpLcompensateDamageInsured.value=fm.DamageInsured.value; 
       }
       
        function calBackMainAgriPlanting3224(){
         var SettleArea=0;
         var SettleAreaTemp=0;
         var ProductionArea=0;
         var SettleAreaAll=fm.SettleAreaAll.value;
         var NoProductionArea=fm.NoProductionArea.value;
         fm.calBackMainAgriFlag.value="1";
         if(fm.creatCompensateLlossFlag.value=="0"){
            alert("请先生成标的信息！");
            fm.calBackMainAgriFlag.value="0";
            return false;
          }
         
         fm.prpLcompensateLossesNumber.value=fm.SettleAreaAll.value;
         fm.prpLcompensateAffectedArea.value=fm.SettleAreaAll.value;
         fm.prpLcompensateDisasterArea.value=fm.SettleAreaAll.value;
         
         
         fm.prpLcompensateNoProductionArea.value=fm.NoProductionArea.value;
         fm.prpLcompensateDamageInsured.value=fm.DamageInsured.value; 
       }
       
       
          </script>

<table class="common" align="center">
  <!--表示显示多行的-->

  <%
    PrpDexchDto prpDexchDto;
    Collection prpdexchDtoList = (Collection) request
        .getAttribute("prpdexchDtoList");
    if (prpdexchDtoList != null) {
      Iterator itprpdexch = prpdexchDtoList.iterator();
      while (itprpdexch.hasNext()) {
        prpDexchDto = (PrpDexchDto) itprpdexch.next();
        out
        .println("  <input type=\"hidden\" name=\"baseCurrency\""
        + " value=\""
        + prpDexchDto.getBaseCurrency()
        + "\""
        + "\">");
        out
        .println("  <input type=\"hidden\" name=\"exchCurrency\""
        + " value=\""
        + prpDexchDto.getExchCurrency()
        + "\""
        + "\">");
        out.println("  <input type=\"hidden\" name=\"exchRate\""
        + " value=\"" + prpDexchDto.getExchRate() + "\""
        + "\">");
      }
    }
  %>
 
  <tr>
    <td class="subformtitle" colspan="4" style="text-align: left"><img
      style="cursor: hand;" src="/claim/images/butCollapseBlue.gif"
      name="lLossImg" onclick="showPage(this,spanlLoss)">赔付标的信息<br>
    <span id="spanlLoss" style="display: none"> <%-- 多行输入展现域 --%>
    <table id="lLoss" class="common" align="center" cellspacing="1"
      cellpadding="0">
      <thead>       

      
         <tr>
        <td class="title" colspan=2 style="width: 100%">
          <logic:notEmpty name="prpLacciPersonDto"
          property="prpLagriPersonList">
          <logic:iterate id="prpLagriPerson" name="prpLacciPersonDto"
            property="prpLagriPersonList" length="1" offset="0">
            <tr>
              <div align="center"><input class="readonlyNo" type="hidden"
                name="prpLlossDtoSerialNo" description="序号"
                value="<bean:write name='prpLagriPerson' property='serialNo' filter='true' />">
              </div>
              <td class="subformtitle" style="width: 100%">
              <table cellpadding="0" cellspacing="1" class="common"
                style="width: 100%">
                <tr>
                  <td class="title" style="width: 15%">被保险人：</td>
                  <td class="input" style="width: 35%">
                    <input type="hidden" name="prpLclaimLossAcciCode" value="<bean:write name='prpLagriPerson' property='acciCode' filter='true' />">
                    <input type="hidden" name="prpLlossDtoFamilyNo"
                      value="<bean:write name='prpLagriPerson' property='familyNo' filter='true' />">
                  <input type=text name="prpLlossDtoFamilyName" title="被保险人姓名"
                    style="width: 180px" class="codecode" title="被保险人姓名"
                    value="<bean:write name='prpLagriPerson' property='acciName' filter='true' />"
                    ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
                    onkeyup="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
                  <input type="hidden" name="prpLclaimAcciPersonSex"
                    value="<bean:write name='prpLagriPerson' property='sex' filter='true' />">
                  <input type="hidden" name="prpLclaimAcciPersonAge"
                    value="<bean:write name='prpLagriPerson' property='age' filter='true' />">
                  <input type="hidden" name="prpLclaimAcciPersonIdentifyNumber"
                    value="<bean:write name='prpLagriPerson' property='identifyNumber' filter='true' />">

                  </td>                  
                  <td> 
                  <input type=button class="bigbutton" style="cursor: hand" name="creatCompensateLloss" value="生成赔付标的信息" <%=disabledFlag%> onclick="flash0311CompensateLoss(fm.prpLcompensatePolicyNo,fm.prpLcompensateClaimNo,fm.settleListCode);calFund();" >
                  <input type="hidden" name="creatCompensateLlossFlag" value="0"/>
                  </td>
                  <td> 
                  <input type=button class="bigbutton" style="cursor: hand" name="creatCompensateLloss" value="汇总赔付标的信息" <%=disabledFlag%> onclick="calBackMainTemblor0311();calFund();" >
                  <input type="hidden" name="calBackMainAgriFlag" value="0"/>
                  </td>
                  <td class="title" style="width:15%;display:none">牛号：</td>
                  <td class="input" style="width: 35%"><%--在农险用车牌号字段暂存牛号--%>
                  <input type="hidden" name="prpLlossDtoLicenseNo" description="牛号"
                    class="common" onblur="checkInteger(this)"
                    style="width: 180px"
                    value="<bean:write name='prpLagriPerson' property='address' filter='true' />">
                  </td>
                </tr>
		       <tr>
		        	<td class="title" style="width: 15%">
		        		理赔清单：
		        	</td>
		        	<td class="input" style="width: 35%">
		        		<input class="input" type="text" name="settleListCode" id="settleListCode" value="<%=settleListCode==null?"":settleListCode%>" readonly/>
		              <input type="hidden" name="editSettleListFlag" value="1"/>
		        	</td>
		        	<td>        		
		              <input type="button" name="editSettleListButton" class='bigbutton' value="缮制理赔清单" <%=disableEditSettleList%> onclick="openCompensate3224SettleListPage('edit','compe'); return false;"/>
		            </td>
		        	<td>
		        		<input type="button" name="viewSettleListButton" class='bigbutton' value="查看理赔清单" <%=disableViewSettleList%> onclick="openCompensate3224SettleListPage('view','compe'); return false;"/>
		        	</td>
		        </tr>
                </table>
                </tr>
          </logic:iterate>
          </logic:notEmpty>
          <logic:empty name="prpLacciPersonDto" property="prpLagriPersonList">
            <tr>            
              <td class="subformtitle" style="width: 100%" colspan="2">
              <input class="readonlyNo" type="hidden"
                name="prpLlossDtoSerialNo" description="序号"
                value="1"/>
              <table cellpadding="0" cellspacing="1" class="common"
                style="width: 100%">
                <tr>
                  <td class="title" style="width: 15%">被保险人：</td>
                  <td class="input" style="width: 35%">
                    <input type="hidden" name="prpLclaimLossAcciCode">
                    <input type="hidden" name="prpLlossDtoFamilyNo">
                  <input type=text name="prpLlossDtoFamilyName" title="被保险人姓名"
                    style="width: 180px" class="codecode" title="被保险人姓名"
                    ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
                    onkeyup="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
                  <input type="hidden" name="prpLclaimAcciPersonSex">
                  <input type="hidden" name="prpLclaimAcciPersonAge">
                  <input type="hidden" name="prpLclaimAcciPersonIdentifyNumber">

                  </td>                  
                  <td> 
                  <input type=button class="bigbutton" style="cursor: hand" name="creatCompensateLloss" value="生成赔付标的信息" <%=disabledFlag%> onclick="flash0311CompensateLoss(fm.prpLcompensatePolicyNo,fm.prpLcompensateClaimNo,fm.settleListCode);calFund();" >
                  <input type="hidden" name="creatCompensateLlossFlag" value="0"/>
                  </td>
                  <td> 
                  <input type=button class="bigbutton" style="cursor: hand" name="creatCompensateLloss" value="汇总赔付标的信息" <%=disabledFlag%> onclick="calBackMainTemblor0311();calFund();" >
                  <input type="hidden" name="calBackMainAgriFlag" value="0"/>
                  </td>
                  <td class="title" style="width:15%;display:none">牛号：</td>
                  <td class="input" style="width: 35%"><%--在农险用车牌号字段暂存牛号--%>
                  <input type="hidden" name="prpLlossDtoLicenseNo" description="牛号"
                    class="common" onblur="checkInteger(this)"
                    style="width: 180px">
                  </td>
                </tr>
		       <tr>
		        	<td class="title" style="width: 15%">
		        		理赔清单：
		        	</td>
		        	<td class="input" style="width: 35%">
		        		<input class="input" type="text" name="settleListCode" id="settleListCode" value="<%=settleListCode==null?"":settleListCode%>" readonly/>
		              <input type="hidden" name="editSettleListFlag" value="1"/>
		        	</td>
		        	<td align="center">        		
		              <input type="button" name="editSettleListButton" class='bigbutton' value="缮制理赔清单" <%=disableEditSettleList%> onclick="openCompensate0311SettleListPage('edit','compe'); return false;"/>
		            </td>
		        	<td align="center">
		        		<input type="button" name="viewSettleListButton" class='bigbutton' value="查看理赔清单" <%=disableViewSettleList%> onclick="openCompensate0311SettleListPage('view','compe'); return false;"/>
		        	</td>
		        </tr>
                </table>
                </td>
                </tr>
          </logic:empty>
                </thead>
          <tfoot>
          <tr>
          <td class="title" colspan=2 style="width: 100%">
          <font color="#ED1B24">
           全损赔付：<br>
          &emsp;&emsp;保险金额<br>
           部分损失赔付：<br>
           &emsp;&emsp;保险金额× 赔付比例<br>
           </font>
           </td>
           </tr>
           </tfoot>
           </td>
        </tr>

  <tr>
  <td style="width: 100%" colspan="2">
  <input type="hidden" name="classcodeM"  value="<bean:write name='prpLcompensateDto' property='classCode' />">
  <input type="hidden" name="DamageInsured"  >
  <input type="hidden" name="NoProductionArea"  >
  <input type="hidden" name="SettleAreaAll"  >
  <table class="common" style="display: none" id="LossDetail_Data"
    cellspacing="1" cellpadding="0">
    <tbody>
      <tr>
          <td class="inputsubsub">
            <input type="text" name="prpLlossDtoItemKindNo" class="readonly" readonly="readonly" style="width: 30px"> 
          </td>
        <td class="inputsubsub">
          <input type='hidden'name="prpLlossDtoFeeTypeCode"> 
        <input type='hidden'name="prpLlossDtoFeeTypeName">
        <input type='hidden'name='prpLlossDtoItemAddress'> 
        <input type='hidden'name='prpLlossDtoBuyDate' value="2004/12/12"> 
        <input type='hidden' name='prpLlossDtoDepreRate'> 
        <input type='hidden' name='prpLlossDtoCurrency1' value="<bean:write name='prpLcompensateDto' property='currency' />">
          <input type='hidden' name='prpLlossDtoCurrency4' value="<bean:write name='prpLcompensateDto' property='currency' />">
        <input type='hidden' name='prpLlossDtoUnit'> 
        <input type="hidden" name="prpLlossDtoLossQuantity"> 
        <input type="hidden" name="prpLlossDtoUnitPrice">
          <input type="hidden" name="prpLlossDtoIndemnityDutyRate"> 
          <input type="hidden" name="prpLlossDtoCurrency2"
          value="<bean:write name='prpLcompensateDto' property='currency' />">
        <input type="hidden" name="prpLlossDtoCurrency2Name"
          value="<bean:write name='prpLcompensateDto' property='currencyName' />">
        <input type="hidden" name="prpLlossDtoCurrency3"
          value="<bean:write name='prpLcompensateDto' property='currency' />">
        <input type="hidden" name="prpLlossDtoCurrency3Name"
          value="<bean:write name='prpLcompensateDto' property='currencyName' />">
        <input type="hidden" name="prpLlossDtoCurrency"
          value="<bean:write name='prpLcompensateDto' property='currency' />">
        <input type="hidden" name="prpLlossDtoCurrencyName"
          value="<bean:write name='prpLcompensateDto' property='currencyName' />">
        <input type='hidden' name='LossItemCode'>
        <input type='hidden' name="LossItemName" class='readonly' readonly>
        <input type="hidden" name="prpLlossDtoKindCode" description="承保险别">
        <input type="input" name="prpLlossDtoKindName" class="codename"
          style="width: 150px"
          ondblclick="code_CodeSelect(this, 'KindCodeVirturlItem1','-1,-21,5,6','always','none','post');"
          onkeyup="code_CodeSelect(this, 'KindCodeVirturlItem1','-1,-21,5,6','always','none','post');">
        <input type="hidden" name="prpLlossMaxPaid"> 
        <input type="hidden" name="prpLlossHisPaid"></td>
        <td class="inputsubsub">
        <input type="hidden" name="prpLlossDetailSerialNo"> 
        <input type="hidden" name="prpLlossSerialNo">
        <input type="hidden" name="prpLlossDtoItemCode" > 
        <input name="prpLlossDtoLossName" class="readonly" readonly
          style="width: 110px"></td>
        <select name="calaType" style="display:none"
          class="common" style="width: 110px" onchange="calRealpay(this);calLoss();">
          <option value='1'>全损赔付</option>
          <option value='2'>部分损失赔付</option>
          </select>   
        <select name="cala" style="display:none"
          class="common" style="width: 110px" onchange="calRealpay(this);calLoss();">
          <option value='1'>保险金额计算</option>
          <option value='2'>核定损失计算</option>
          </select> 
        <td style="display:none" class="inputsubsub">
            <input name="prpLlossDtoSettleArea" class="common" readonly style="width: 60px">
        </td>  
        <td style="display:none" class="inputsubsub">
            <input  name="prpLlossDtoAmount" class="common"  readonly style="width: 60px"  >
           <input type="hidden" name="prpLlossDtoAmountDisplay" >
        </td>
          <input name="prpLlossDtoSumLoss" type="hidden"
          class="common" style="width: 60px"> 
        <td class="inputsubsub"><input name="prpLlossDtoClaimRate" readonly
          class="common" style="width: 40px" value="100">%
        </td>
        <!-- 损失率 -->
        <td class="inputsubsub"><input name="indemnityDutyRate" readonly
                    class="common" style="width: 60px" >%</td>
        <td class="inputsubsub"><input name="prpLlossDtoDeductibleRate" readonly
          class="common" style="width: 40px" value="0.0">%</td>
          <input name="prpLlossDtoDeductible" type="hidden"
          type='text' class="input" style="width: 50px" value="0.0">
        <input name="prpLlossDtoSumRest" type="hidden"
          class="common" style="width: 60px">
        <td class="inputsubsub"><input name="prpLlossDtoSumRealPay"
          style="width: 80px" class='input' readonly onchange="calFund();calClaimRate(this);"></td>
        <logic:notEmpty name="coinsFlag"  >
			<logic:equal name='coinsFlag' value="2">
                <td class="inputsubsub">
                <input name="prpLlossDtoCoinsSumRealPay" type='text' class="input" style="width:180px" onblur="calCoinsSumPaid(this);" onchange="">                                                                     
                </td>                   
			</logic:equal>
			<logic:equal name='coinsFlag' value="1">
                <td class="inputsubsub">
                <input name="prpLlossDtoCoinsSumRealPay" type='text' class="input" style="width:180px" onblur="calCoinsSumPaid(this);" onchange="">                                                                     
                </td>                   
			</logic:equal>
		</logic:notEmpty>
      </tr>
    </tbody>
  </table>

  <table id="LossDetail" name="LossDetail" class="common" align="center" cellspacing="1" cellpadding="0" style="width: 100%">
             <thead>

                <tr>
                  <td class="centertitle">标的序号</td>
                  <td class="centertitle">承保险别</td>
                  <td class="centertitle">损失标的</td>
                  <!--<td class="centertitle">赔付面积</td>
                  <td class="centertitle">出险面积保险金额</td>-->
                  <td class="centertitle">赔付比例%</td>
                  <td class="centertitle">损失率%</td>
                  <td class="centertitle">免赔率%</td>
                  <td class="centertitle">赔偿金额</td>
        
				<logic:notEmpty name="coinsFlag"  >
					<logic:equal name='coinsFlag' value="2">
                       <td class="centertitle">共保总赔偿金额</br>（含我方及其它共保方）：</td>
					</logic:equal>
					<logic:equal name='coinsFlag' value="1">
                       <td class="centertitle">共保总赔偿金额</br>（含我方及其它共保方）：</td>
					</logic:equal>
				</logic:notEmpty>
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
  </span>
  </td>
  </tr>
</table>  