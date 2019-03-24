<%--
****************************************************************************
* DESC       ：添加人员赔款费用信息页面
* AUTHOR     ：lixiang
* CREATEDATE ： 2004-06-01
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
*                chenrenda  20070706         意键险团单理赔改造
****************************************************************************
--%>
<%@ page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%
      //将险别和历史赔付额写到画面上
      Collection prpCitemKindList = (Collection)request.getAttribute("prpCitemKindList");
      PrpLacciPersonDto prpLacciPersonDto = (PrpLacciPersonDto)request.getAttribute("PrpLAcciPersonDto");
      DecimalFormat idecimalFormat = new DecimalFormat("0.00");
      
      
      String settleListCode=(String)request.getAttribute("settleListCode");//
      String disableEditSettleList = "disabled";//
      String disableViewSettleList = "disabled";//
      if(editType.equals("SHOW")){
    	  disableViewSettleList = "";
      }
      else if(editType.equals("EDIT"))
      {
    	  disableEditSettleList = "";
      }
      else if("ADD".equalsIgnoreCase(editType))
      {
    	  disableEditSettleList = "";
      }
      
      //PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto) request.getAttribute("prpLcompensateDto");
      
      Iterator ititemkind = prpCitemKindList.iterator();
      
      while(ititemkind.hasNext())
      {
          PrpCitemKindDto prpCitemKindDto =  (PrpCitemKindDto)ititemkind.next();
            out.println("  <input type=\"hidden\" name=\"hisKind\""+
                " value=\""+prpCitemKindDto.getKindCode()+"\"" + ">");
            out.println("  <input type=\"hidden\" name=\"hisPaid\""+
                " value=\""+prpCitemKindDto.getHisPaid()+"\""+">");
            out.println("  <input type=\"hidden\" name=\"currAmount\""+
                " value=\""+prpCitemKindDto.getAmount()+"\""+">"); 
                prpCitemKindDto.setUnitAmount(prpCitemKindDto.getAmount());
      }
%>  

  <script language="javascript">
        function openCompensateSettleListPage(editType,nodeType){
        var policyNo = fm.policyno.value;
    	var registNo = fm.registno.value;
    	var claimNo = fm.prpLcompensateClaimNo.value;
    	var compensateNo = fm.prpLcompensateCompensateNo.value;
      	var newWindow = window.open("/claim/medicalsettleList.do?policyNo=" +policyNo+ "&registNo=" +registNo+"&nodeType="+nodeType+"&editType="+editType+"&isFirst='isFirst'&compensateNo="+compensateNo+"&claimNo="+claimNo+"&riskCode=2801","NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
      }
  </script>
  
    <script language="javascript">
        function openCompensateSettleListPageFor2607(editType,nodeType){
        var policyNo = fm.policyno.value;
    	var registNo = fm.registno.value;
    	var claimNo = fm.prpLcompensateClaimNo.value;
    	var compensateNo = fm.prpLcompensateCompensateNo.value;
      	var newWindow = window.open("/claim/medicalsettleList.do?policyNo=" +policyNo+ "&registNo=" +registNo+"&nodeType="+nodeType+"&editType="+editType+"&isFirst='isFirst'&compensateNo="+compensateNo+"&claimNo="+claimNo+"&riskCode=2607","NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
      }
  </script>
  
   <script language="javascript">
        function openCompensateSettleListPageFor2605(editType,nodeType){
        var policyNo = fm.policyno.value;
    	var registNo = fm.registno.value;
    	var claimNo = fm.prpLcompensateClaimNo.value;
    	var compensateNo = fm.prpLcompensateCompensateNo.value;
      	var newWindow = window.open("/claim/medicalsettleList.do?policyNo=" +policyNo+ "&registNo=" +registNo+"&nodeType="+nodeType+"&editType="+editType+"&isFirst='isFirst'&compensateNo="+compensateNo+"&claimNo="+claimNo+"&riskCode=2605","NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
      }
  </script>
  
     <script language="javascript">
        function openCompensateSettleListPageFor2606(editType,nodeType){
        var policyNo = fm.policyno.value;
    	var registNo = fm.registno.value;
    	var claimNo = fm.prpLcompensateClaimNo.value;
    	var compensateNo = fm.prpLcompensateCompensateNo.value;
      	var newWindow = window.open("/claim/medicalsettleList.do?policyNo=" +policyNo+ "&registNo=" +registNo+"&nodeType="+nodeType+"&editType="+editType+"&isFirst='isFirst'&compensateNo="+compensateNo+"&claimNo="+claimNo+"&riskCode=2606","NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
      }
      function openCompensateSettleListPageFor2609(editType,nodeType){
        var policyNo = fm.policyno.value;
    	var registNo = fm.registno.value;
    	var claimNo = fm.prpLcompensateClaimNo.value;
    	var compensateNo = fm.prpLcompensateCompensateNo.value;
      	var newWindow = window.open("/claim/medicalsettleList.do?policyNo=" +policyNo+ "&registNo=" +registNo+"&nodeType="+nodeType+"&editType="+editType+"&isFirst='isFirst'&compensateNo="+compensateNo+"&claimNo="+claimNo+"&riskCode=2609","NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
      }
      	function assessAcciInjuryGrade(obj){
      		var url = "/claim/commonAcci/compensate/AcciInjuryGradeTree.jsp";
      		var returnValue = window.showModalDialog(url,"","dialogWidth:300px;dialogHeight:400px;resizable:1");
      		if(returnValue!=null){
      			var ary = returnValue.split("#");
      			$(obj).prev().val(ary[1]);
      			$(obj).prev().attr("title",ary[1]);
      			$(obj).prev().prev().val(ary[0]);
      		}
      	}
  </script>
   <!--建立显示的录入条，可以收缩显示的-->
   <input type="hidden" name="hisKind" value="T">
   <input type="hidden" name="hisPaid" value="T">
   <input type="hidden" name="currAmount" value="T">
      <span style="display:none"> 
        <table class="common" style="display:none" id="PersonFeeLoss_Data" cellspacing="1" cellpadding="0">
          <tbody>  
            <tr>                  
              <td class="inputsubsub">
                 <input type="text" name="prpLpersonLossItemKindNo" readonly="readonly" class="readonly" description="标的序号" >  
              </td>
              <td class="inputsubsub">
                 <input  type="input" class="common" readonly name="prpLpersonLossKindCode" style="width:50px"
                    maxlength=20 description="险别" >                      
                 <input type="input" name="prpLpersonLossKindName" class="codename" style="width:150px"
  			             ondblclick="code_CodeSelect(this, 'KindCodeVirturlItem','-1,-2,7,5,6','always','none','post');"
  			             onkeyup= "code_CodeSelect(this, 'KindCodeVirturlItem','-1,-2,7,5,6','always','none','post');"
  			             onblur="dispHisInfo(this);"> 
  			    
  			     <input type="hidden" name="prpLpersonLossMaxPaid" > 
                 <input type="hidden" name="prpLpersonLossHisPaid" >
              </td>
                <input type="hidden" name="prpLpersonLossLiabSerialNo" style="width:20px">    
                <input type="hidden" name="personLossSerialNo" style="width:20px">                       
                <input name="prpLpersonLossLiabDetailCode" type="hidden">                                                   
                <input  type="hidden" name="prpLpersonLossLiabDetailName" class="codename" style="width:50px"> 
                <input type="hidden" name="prpLpersonLossAmount">
              <%if(!("2801".indexOf(restrRiskCode) > -1)){%>
              <td class="inputsubsub">                        
                <input name="prpLpersonLossInjuryGrade" type="hidden">                                                   
                <input name="prpLpersonLossInjuryGradeName" style="width:50px" readonly class="readonly"> 
                <a href="javascript:void(0);" onclick="assessAcciInjuryGrade(this);">评定</a>
              </td>
              <td class="inputsubsub">
                 <input name="prpLpersonLossInHospDate" class="common" style="width:60px"  onblur="checkFullDate(this);calHospDays(this);">
              </td>  
              <td class="inputsubsub">
                 <input name="prpLpersonLossOutHospDate" class="common" style="width:60px" onblur="checkFullDate(this);calHospDays(this);">
              </td> 
              <td class="inputsubsub">
                 <input name="prpLpersonLossHospitalDays" class="common" style="width:30px">
              </td>    
<%} %>
                  
              <td class="inputsubsub"> 
                <input type="hidden" name="prpLpersonLossCurrency" class="codecode" value="<bean:write name='prpLcompensateDto' property='currency' />"
                  ondblclick= "code_CodeSelect(this,'Currency');"
                  onkeyup= "code_CodeSelect(this,'Currency');">  
                <input style='width:50px' name="prpLpersonLossCurrencyName" class="codename" value="<bean:write name='prpLcompensateDto' property='currencyName' />"
		             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
		             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');"> 
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonLossSumLoss" class="common" style="width:60px" onblur="calRealPay(this);calFund();checkAmount(this);" 
                 onchange="setFlagDanger();">
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonLossSumRest" class="common" style="width:60px" onblur="calRealPay(this);calFund();checkAmount(this);"
                onchange="setFlagDanger();">
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonLossDeductible" class="common" style="width:50px" value="0" onblur="calRealPay(this);calFund();checkAmount(this);"
                onchange="setFlagDanger();">
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonLossClaimRate" class="common" style="width:40px" value="100" onblur="calRealPay(this);calFund();checkAmount(this);"
                onchange="setFlagDanger();">
              </td>
            
              <td class="inputsubsub">
                <input name="prpLpersonLossSumRealPay" class="common" style="width:60px" onblur="calFund2();checkAmount(this);" onchange="setFlagDanger();"> 
                <input type="hidden" name="prpLpersonLossUnitAmount">
                <input type="hidden" name="prpLpersonLossLossQuantity">
                <input type="hidden" name="prpLpersonLossFamilyName">
                <input type="hidden" name="prpLpersonLossIndemnityDutyRate">                  
                <input type="hidden" name="prpLpersonLossDeductibleRate">
                      
                
                <input type="hidden" name="prpLpersonLossLiabCode">         
                <input type="hidden" name="prpLpersonLossLiabName">         
                <input type="hidden" name="prpLpersonLossJobCode">          
                <input type="hidden" name="prpLpersonLossJobName">          
                <input type="hidden" name="prpLpersonLossItemAddress">      
                <input type="hidden" name="prpLpersonLossUnit">             
                <input type="hidden" name="prpLpersonLossCurrency2" value="CNY">           
                <input type="hidden" name="prpLpersonLossCurrency1" value="CNY">        
                <input type="hidden" name="prpLpersonLossItemValue">         
                <input type="hidden" name="prpLpersonLossCurrency4" value="CNY">        
                <input type="hidden" name="prpLpersonLossFlag">    
                <input type="hidden" name="prpLpersonLossCurrency3"  value="CNY">     
                      
              </td>  
              <td class="inputsubsub">
                <input name="prpLpersonLossRemark" class="common" style="width:50px"  maxLength="255" onblur="checkLength1(this);" description="备注">
              </td>                                                    
              <td class="inputsubsub">
                <div align="center">
                  <input type=button name="buttonPersonFeeLossDelete"  onclick="deleteRowTable(this,'PersonFeeLoss',1,1);setFlagDanger();" value="-" readonly style="cursor: hand">
                </div>              
              </td>             
            </tr>
          </tbody>
        </table>
      </span>
       
      <span  id="spanPersonFeeLoss" style="display:none">
        <%-- 多行输入展现域 --%>
        <table id="PersonFeeLoss" name="PersonFeeLoss" class="common" align="center" cellspacing="1" cellpadding="0">
          <thead>
            <tr>
              <td class="subformtitle" colspan="10">费用信息</td>
            </tr>
            <tr>
         	      <td class="centertitle">标的序号</td>
        		  <td class="centertitle">承保险别</td>
        		  <td class="centertitle">责任明细</td>
        		  <td class="centertitle">伤残等级</td>
        		  <td class="centertitle">入院日期</td>
        		  <td class="centertitle">出院日期</td>
        		  <td class="centertitle">天数</td>
        		  <td class="centertitle">币别</td>
        		  <td class="centertitle">申请金额</td>
        		  <td class="centertitle">自费金额</td>
        		  <td class="centertitle">免赔额</td>  
        		  <td class="centertitle">赔偿比例%</td>
        		  <td class="centertitle">给付金额</td> 
        		  <td class="centertitle">备注</td> 
        		  <td class="centertitle" style="width:3%"></td>                                           
            </tr>  
          </thead>
          <tfoot>
            <tr>
              <td class="titlesubsub" colspan="9" style="width:97%"></td>
              <td class="title" align="right" style="width:4%">
                <div align="center">
                  <input type="button" value="+" onclick="insertRowTable('PersonFeeLoss','PersonFeeLoss_Data',this);setFlagDanger();" name="buttonPersonFeeLossInsert" readonly style="cursor: hand">
                </div>
              </td>
            </tr>
          </tfoot> 
          <tbody>
          </tbody>
        </table>  
      </span>  
      
<table class="common" align="center" width="100%" >
      <!--表示显示多行的-->
  <tr>
    <td  colspan="4" align="left">
      <img style="cursor:hand;" src="/claim/images/butExpandBlue.gif" 
                 name="PersonImg" onclick="showPage(this,spanPerson)"><%if(!("2801".indexOf(restrRiskCode) > -1)){%>                 
                 被保险人赔付信息<br>
                 <%} %>
  
     <span  id="spanPerson" style="display:">
   <% 
     int intIndex = 1;
     int intFeeCount =0;
   %>
   
<logic:notEmpty  name="prpLacciPersonDto"  property="prpLacciBenPersonList">
  <logic:iterate id="prpLacciBenPerson" name="prpLacciPersonDto" property="prpLacciBenPersonList">     
      <table  class="common" align="center" cellspacing="1" cellpadding="0">
         <tr>
            <td id = "tbprpLacciPersonName" class="title" style="width:15%">姓名</td>
            <td id = "tbprpLacciPersonName1" class="input" style="width:35%">
              <input class='readonly' readonly style="width:80px" name="prpLpersonLossPersonName" value="<bean:write name='prpLacciBenPerson' property='acciName' filter='true' />"
                    maxlength=120 description="人员姓名">                  
            </td>       
            <td id = "tbprpLacciPersonAge" class="title" style="width:15%" >年龄</td>
            <td id = "tbprpLacciPersonAge1" class="input" style="width:35%">
              <input class='readonly' readonly name="prpLpersonLossAge"  style="width:80px" value="<bean:write name='prpLacciBenPerson' property='age' filter='true' />" 
                      maxlength="3" description="年龄">           
             </td>
          </tr>
          <tr>
            <td id = "tbprpLacciPersonSex" class="title" style="width:15%">性别</td>
            <td id = "tbprpLacciPersonSex1" class="input" style="width:35%">
               <select name ="prpLpersonLossSex" title="性别"  class="readonly" readonly>
                 <option value="9" selected>未知</option>
                 <option value="1" <logic:equal name="prpLacciBenPerson" property="sex" value='1'>selected</logic:equal>>男</option>
                 <option value="2" <logic:equal name="prpLacciBenPerson" property="sex" value='2'>selected</logic:equal>>女</option>
               </select>
            </td>
            <td id = "tbprpLacciPersonID" class="title" style="width:15%">身份证号</td>
            <td id = "tbprpLacciPersonID1" class="input" style="width:35%">
              <input class='readonly' readonly style="width:160px" name="prpLpersonLossIdentifyNumber"  value="<bean:write name='prpLacciBenPerson' property='identifyNumber' filter='true' />"
                    maxlength=20 description="身份证号">                  
            </td>
            <input type="hidden" name="familyNo"  value="<bean:write name='prpLacciBenPerson' property='familyNo' filter='true' />"  />
            <input type="hidden" name="prpLpersonLossFamilyNo"  value="<bean:write name='prpLacciBenPerson' property='familyNo' filter='true' />"  />
            <input type="hidden" name="prplAcciPersonNo"  value="<%=intIndex%>"  />
          </tr> 
            <td colspan="4">
              <span  id="spanPersonFeeLoss" >
                <table id="PersonFeeLoss" name="PersonFeeLoss" class="common" align="center" cellspacing="1" cellpadding="0">
                            <thead>
                              <tr>
                                <td class="subformtitle" colspan="14">费用信息</td>
                              </tr>
                              <tr>
                                  <td class="centertitle">标的序号</td>
                      	  		  <td class="centertitle">承保险别</td>
                      	  		 <!--  <td class="centertitle">责任明细</td> -->
                                   <%if(!("2801".indexOf(restrRiskCode) > -1)){%>
                      	  		  <td class="centertitle">伤残等级</td>
                      	  		  <td class="centertitle">入院日期</td>
                      	  		  <td class="centertitle">出院日期</td>
                      	  		  <td class="centertitle">天数</td>
<%} %>
                      	  		  <td class="centertitle">币别</td>
                      	  		  <td class="centertitle">申请金额</td>
                      	  		  <td class="centertitle">自费金额</td>
                      	  		  <td class="centertitle">免赔额</td> 
                      	  		  <td class="centertitle">赔偿比例%</td>
                      	  		  <td class="centertitle">给付金额</td>  
                      	  		  <td class="centertitle">备注</td>  
                                <td class="centertitle" style="width:3%">  </td>                                           
                              </tr>  
                            </thead>
                            <tfoot>
                              <tr>
                                <td class="titlesubsub" colspan="9" style="width:97%"></td>
                                <td class="title" align="right" style="width:4%">
                                  <div align="center">
                                    <input type="button" value="+" onclick="insertRowTable('PersonFeeLoss','PersonFeeLoss_Data',this);setFlagDanger();" name="buttonPersonFeeLossInsert" readonly style="cursor: hand">
                                  </div>
                                </td>
                              </tr>
                            </tfoot> 
                            <tbody>
 <%
   PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto)request.getAttribute("prpLpersonLossDto");
 	java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
   if(prpLpersonLossDto.getPrpLpersonLossList()!=null){
     Iterator iterator1 = prpLpersonLossDto.getPrpLpersonLossList().iterator();
     while(iterator1.hasNext())
     { 
       PrpLpersonLossDto PrpLpersonLossDto1 =  (PrpLpersonLossDto)iterator1.next();
       if(PrpLpersonLossDto1.getPersonNo()==intIndex)
       {
           intFeeCount++;
%>                    
          <tr>   
            <td class="inputsubsub" >
               <input type="text" name="prpLpersonLossItemKindNo" class="readonly" readonly="readonly" value="<%= PrpLpersonLossDto1.getItemKindNo() %>">    
            </td>
              <td class="inputsubsub" >
                 <input  type="hidden" name="prpLpersonLossKindCode"  value = "<%= PrpLpersonLossDto1.getKindCode() %>"
                    maxlength=20 description="险别"  ondblclick= "code_CodeSelect(this,'KindCodeVirturlItem','1,2');">                      
                 <input type="input" name="prpLpersonLossKindName" class="codename" style="width:150px" value = "<%= PrpLpersonLossDto1.getKindName() %>"
  			             ondblclick="code_CodeSelect(this, 'KindCodeVirturlItem','-1,-2,7,5,6','always','none','post');"
  			             onkeyup= "code_CodeSelect(this, 'KindCodeVirturlItem','-1,-2,7,5,6','always','none','post');"
  			             onblur="dispHisInfo(this);"> 
  			    
  			     <input type="hidden" name="prpLpersonLossMaxPaid"  value="<%= PrpLpersonLossDto1.getMaxpaid() %>"
                         description="最大赔付额"> 
                 <input type="hidden" name="prpLpersonLossHisPaid"  value="<%= PrpLpersonLossDto1.getHispaid() %>"
                       description="历史赔付额">      
              </td>
              <td class="inputsubsub" style="display:none">    
                 <input type="hidden" name="prpLpersonLossLiabSerialNo" style="width:20px" value="<%= intFeeCount %>">                                     
                 <input type="hidden" name="personLossSerialNo" style="width:20px" value="<%= intIndex %>">                                     
                 <input name="prpLpersonLossLiabDetailCode" type="hidden"  value="<%= PrpLpersonLossDto1.getLiabDetailCode() %>">                                                   
                 <input name="prpLpersonLossLiabDetailName" class="codename" style="width:70px"  value="<%= PrpLpersonLossDto1.getLiabDetailName() %>"> 
                 <input type="hidden" name="prpLpersonLossAmount"  value="<%= PrpLpersonLossDto1.getAmount() %>">
              </td> 
              <%if(!("2801".indexOf(restrRiskCode) > -1)){%>
              <td class="inputsubsub">                        
                <input name="prpLpersonLossInjuryGrade" type="hidden"  value="<%= PrpLpersonLossDto1.getInjuryGrade() %>" >     
                <%if (!"SHOW".equals(editType)){  %>                                       
                <input name="prpLpersonLossInjuryGradeName" style="width:70px" readonly class="readonly"  value="<%= PrpLpersonLossDto1.getInjuryGradeName() %>" title="<%= PrpLpersonLossDto1.getInjuryGradeName() %>"> 
                <a href="javascript:void(0);" onclick="assessAcciInjuryGrade(this);">评定</a>
                <%} else { %>
                <input name="prpLpersonLossInjuryGradeName" style="width:98px" readonly class="readonly"  value="<%= PrpLpersonLossDto1.getInjuryGradeName() %>" title="<%= PrpLpersonLossDto1.getInjuryGradeName() %>">
                <%}  %>
              </td>
               <td class="inputsubsub">
                 <input name="prpLpersonLossInHospDate" class="common" style="width:70px" value="<%= PrpLpersonLossDto1.getInHospDate() %>" onblur="calHospDays(this);" >
              </td>  
              <td class="inputsubsub">
                 <input name="prpLpersonLossOutHospDate" class="common" style="width:70px" value="<%= PrpLpersonLossDto1.getOutHospDate() %>" onblur="calHospDays(this);">
              </td> 
              <td class="inputsubsub">
                 <input name="prpLpersonLossHospitalDays" class="common" style="width:70px"   value="<%= PrpLpersonLossDto1.getHospitalDays() %>">
              </td>     
              <%} %>
                              
              <td class="inputsubsub">
                <input type="hidden" name="prpLpersonLossCurrency" value="<%= PrpLpersonLossDto1.getCurrency() %>" class="codecode"
                  ondblclick= "code_CodeSelect(this,'Currency');"
                  onkeyup= "code_CodeSelect(this,'Currency');">  
                <input class="input" style='width:60px' name="prpLpersonLossCurrencyName" value="<%= PrpLpersonLossDto1.getCurrencyName() %>" class="codename"
		             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
		             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');"> 
              </td>
              
              <td class="inputsubsub">
                <input name="prpLpersonLossSumLoss" class="common" style="width:70px" value="<%=idecimalFormat.format(PrpLpersonLossDto1.getSumLoss()) %>" onblur="calRealPay(this);calFund();checkAmount(this)"
                onchange="setFlagDanger();">
              </td>
              
              <td class="inputsubsub">
                <input name="prpLpersonLossSumRest" class="common" style="width:70px" value="<%= idecimalFormat.format(PrpLpersonLossDto1.getSumRest()) %>" onblur="calRealPay(this);calFund();checkAmount(this);"
                onchange="setFlagDanger();">
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonLossDeductible" class="common" style="width:70px" value="<%= PrpLpersonLossDto1.getDeductible() %>" onblur="calRealPay(this);calFund();checkAmount(this);"
                onchange="setFlagDanger();">
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonLossClaimRate" class="common" style="width:70px" value="<%= PrpLpersonLossDto1.getClaimRate() %>" onblur="calRealPay(this);calFund();checkAmount(this);"
                onchange="setFlagDanger();">
              </td>
             
              <td class="inputsubsub">
                <input name="prpLpersonLossSumRealPay" class="common" style="width:70px" value="<%= idecimalFormat.format(PrpLpersonLossDto1.getSumRealPay()) %>"  onblur="calFund2();checkAmount(this)" onchange="setFlagDanger();">
 
                <input type="hidden" name="prpLpersonLossUnitAmount"  value="<%= PrpLpersonLossDto1.getUnitAmount() %>">
                <input type="hidden" name="prpLpersonLossLossQuantity"  value="<%= PrpLpersonLossDto1.getLossQuantity() %>">
                
                <input type="hidden" name="prpLpersonLossIndemnityDutyRate"  value="<%= PrpLpersonLossDto1.getIndemnityDutyRate() %>">                  
                <input type="hidden" name="prpLpersonLossDeductibleRate" value="<%= PrpLpersonLossDto1.getDeductibleRate() %>">
                
                
                <input type="hidden" name="prpLpersonLossLiabCode" value="<%= PrpLpersonLossDto1.getLiabCode() %>">         
                <input type="hidden" name="prpLpersonLossLiabName" value="<%= PrpLpersonLossDto1.getLiabName() %>">         
                <input type="hidden" name="prpLpersonLossJobCode" value="<%= PrpLpersonLossDto1.getJobCode() %>">          
                <input type="hidden" name="prpLpersonLossJobName" value="<%= PrpLpersonLossDto1.getJobName() %>">          
                <input type="hidden" name="prpLpersonLossItemAddress" value="<%= PrpLpersonLossDto1.getItemAddress() %>">      
                <input type="hidden" name="prpLpersonLossUnit" value="<%= PrpLpersonLossDto1.getUnit() %>">             
                <input type="hidden" name="prpLpersonLossCurrency2" value="<%= PrpLpersonLossDto1.getCurrency2() %>">           
                <input type="hidden" name="prpLpersonLossCurrency1" value="<%= PrpLpersonLossDto1.getCurrency1() %>">        
                <input type="hidden" name="prpLpersonLossItemValue" value="<%= PrpLpersonLossDto1.getItemValue() %>">         
                <input type="hidden" name="prpLpersonLossCurrency4" value="<%= PrpLpersonLossDto1.getCurrency4() %>">        
                <input type="hidden" name="prpLpersonLossFlag" value="<%= PrpLpersonLossDto1.getFlag() %>">    
                <input type="hidden" name="prpLpersonLossCurrency3"  value="<%= PrpLpersonLossDto1.getCurrency3() %>">
                
              </td>  
              <td class="inputsubsub">
                <input name="prpLpersonLossRemark" class="common" style="width:50px" maxLength="255" onblur="checkLength1(this);" description="备注" value="<%= PrpLpersonLossDto1.getRemark() %>">
              </td>
                                                                   
              <td class="inputsubsub">
                <div align="center">
                  <input type=button name="buttonPersonFeeLossDelete"  onclick="deleteRowTable(this,'PersonFeeLoss',1,1);setFlagDanger();" value="-" readonly style="cursor: hand">
                  
                </div>              
              </td>             
            </tr>
          
<%
       }
     }
   }
%>   

                            </tbody>
                </table>  
              </span>  
            </td>
          <tr>
          </tr>   
       </table>
     
   <% 
     intIndex++;
   %>
  </logic:iterate>
</logic:notEmpty>

     </span>    
   </td>
   
 </tr> 
 <%if("2801".indexOf(restrRiskCode) > -1){%>
		       <tr>
		        	<td class="title" style="width: 15%">
		        		理赔清单：
		        	</td>
		        	<td class="input" style="width: 35%">
		        		<input class="input" type="text" name="settleListCode" id="settleListCode" value="<%=settleListCode==null?"":settleListCode%>" readonly/>
		              <input type="hidden" name="editSettleListFlag" value="1"/>
		        	</td>
		        	<td>        		
		              <input type="button" name="editSettleListButton" class='bigbutton' value="缮制理赔清单" <%=disableEditSettleList%> onclick="openCompensateSettleListPage('edit','compe','2801'); return false;"/>
		            </td>
		        	<td>
		        		<input type="button" name="viewSettleListButton" class='bigbutton' value="查看理赔清单" <%=disableViewSettleList%> onclick="openCompensateSettleListPage('view','compe','2801'); return false;"/>
		        	</td>
		        </tr>
		        <%}else %>
		         <%if("2607".indexOf(restrRiskCode) > -1){%>
		       <tr>
		        	<td class="title" style="width: 15%">
		        		理赔清单：
		        	</td>
		        	<td class="input" style="width: 35%">
		        		<input class="input" type="text" name="settleListCode" id="settleListCode" value="<%=settleListCode==null?"":settleListCode%>" readonly/>
		              <input type="hidden" name="editSettleListFlag" value="1"/>
		        	</td>
		        	<td>        		
		              <input type="button" name="editSettleListButton" class='bigbutton' value="缮制理赔清单" <%=disableEditSettleList%> onclick="openCompensateSettleListPageFor2607('edit','compe','2607'); return false;"/>
		            </td>
		        	<td>
		        		<input type="button" name="viewSettleListButton" class='bigbutton' value="查看理赔清单" <%=disableViewSettleList%> onclick="openCompensateSettleListPageFor2607('view','compe','2607'); return false;"/>
		        	</td>
		        </tr>
		        <%} else%>
		        <%if("2605".indexOf(restrRiskCode) > -1){%>
		       <tr>
		        	<td class="title" style="width: 15%">
		        		理赔清单：
		        	</td>
		        	<td class="input" style="width: 35%">
		        		<input class="input" type="text" name="settleListCode" id="settleListCode" value="<%=settleListCode==null?"":settleListCode%>" readonly/>
		              <input type="hidden" name="editSettleListFlag" value="1"/>
		        	</td>
		        	<td>        		
		              <input type="button" name="editSettleListButton" class='bigbutton' value="缮制理赔清单" <%=disableEditSettleList%> onclick="openCompensateSettleListPageFor2605('edit','compe','2605'); return false;"/>
		            </td>
		        	<td>
		        		<input type="button" name="viewSettleListButton" class='bigbutton' value="查看理赔清单" <%=disableViewSettleList%> onclick="openCompensateSettleListPageFor2605('view','compe','2605'); return false;"/>
		        	</td>
		        </tr>
		        <%} else%>
		        <%if("2606".indexOf(restrRiskCode) > -1){%>
		       <tr>
		        	<td class="title" style="width: 15%">
		        		理赔清单：
		        	</td>
		        	<td class="input" style="width: 35%">
		        		<input class="input" type="text" name="settleListCode" id="settleListCode" value="<%=settleListCode==null?"":settleListCode%>" readonly/>
		              <input type="hidden" name="editSettleListFlag" value="1"/>
		        	</td>
		        	<td>        		
		              <input type="button" name="editSettleListButton" class='bigbutton' value="缮制理赔清单" <%=disableEditSettleList%> onclick="openCompensateSettleListPageFor2606('edit','compe','2606'); return false;"/>
		            </td>
		        	<td>
		        		<input type="button" name="viewSettleListButton" class='bigbutton' value="查看理赔清单" <%=disableViewSettleList%> onclick="openCompensateSettleListPageFor2606('view','compe','2606'); return false;"/>
		        	</td>
		        </tr>
		       <%}%>
		                        
</table>





