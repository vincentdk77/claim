<%--
****************************************************************************
* DESC       ： 人员伤亡清单页面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-07-13  
* MODIFYLIST ：   Name       Date            Reason/Contents
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
*          ------------------------------------------------------
****************************************************************************
--%>     
<%@ page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%DecimalFormat sf = new DecimalFormat ("####0.00"); %>
<script type="text/javascript">
/*
*出院日期是否早于入院日期
*/
function checkOutAndInHospDate(field){
    var fieldName = field.name;
    for(var i = 0;i < fm.all(fieldName).length;i++){
        if(field == fm.all(fieldName)[i]){        
        var inDate    = fm.all("prpLpersonInHospDate")[i].value;
        var outDate   = fm.all("prpLpersonOutHospDate")[i].value;
        if(inDate != "" && outDate != ""){
            var inYear    = inDate.substring(0,4);
            var inMonth   = inDate.substring(5,7);
            var inDay     = inDate.substring(8,10);
        
            var outYear    = outDate.substring(0,4);
            var outMonth   = outDate.substring(5,7);
            var outDay     = outDate.substring(8,10);
            if(outYear < inYear){
                alert("出院日期不能早于入院日期");
                field.focus();
                field.select();                
            }else if(outYear == inYear ){
                if(outMonth < inMonth){
                    alert("出院日期不能早于入院日期");
                    field.focus();
                    field.select();  
                }else if(outMonth == inMonth){
                    if(outDay < inDay){
                        alert("出院日期不能早于入院日期");
                        field.focus();
                        field.select();
                    }else if(outDay == inDay){
                    
                    }
                }
            }
        
        }
        
        }
    }
    
}
/*
*人员伤亡费用清单信息中，同一费用类型应只能录入一次
*/
function feeTypeIsExist(field){
    var fieldName = field.name;
    var currentFeeCode ="";
    var currentFeeName ="";    
    var personSerialNo;
    var index = 0;
    var CompensateBackFlag = "0";
    if(isNaN(fm.CompensateBackFlag[1])){
    	CompensateBackFlag = fm.CompensateBackFlag[1].value;
    }
    //理算退回人伤定损时，以前定损金额不准修改，如果对冲数据时将录入相同的险别，需放开控制
    if(CompensateBackFlag != "1"){
	    for(var i = 0; i< fm.all(fieldName).length;i++){
	        if(field == fm.all(fieldName)[i]){ 
	             currentFeeCode = fm.all("prpLpersonFeeTypeCode")[i].value;
	             currentFeeName = fm.all("prpLpersonFeeTypeName")[i].value; 
	             personSerialNo = fm.all("personSerialNo")[i].value;  
	             index = i;      
	        }
	    }
	    for(var i = 0;i < fm.all(fieldName).length;i++){
	        if(  personSerialNo  == fm.all("personSerialNo")[i].value 
	          && currentFeeCode == fm.all("prpLpersonFeeTypeCode")[i].value 
	          && currentFeeName == fm.all("prpLpersonFeeTypeName")[i].value
	          && currentFeeCode != ""
	          && currentFeeName != ""
	          && fm.all("prpLpersonFeeTypeCode")[i] != field
	          && fm.all("prpLpersonFeeTypeName")[i] != field){
	            alert(currentFeeName + " 在同一人员伤亡费用清单中只能录入一次");            
	            fm.all("prpLpersonFeeTypeCode")[index].value = "";
	            fm.all("prpLpersonFeeTypeName")[index].value = "";
	            return;
	        }
	    }
    }
}

/**
 @description 计算人员伤亡费用清单核损金额
 @param       Field: 触发域 
 @return      无      
*/   
function calSumPersonVeriDefLoss(Field)
{                     
  var fieldname=Field.name;
  var i = 0; 
  var findex=0;  
  var sumLoss;      
  var sumReject;
  var sumDefLoss;

  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == Field )
    {
      findex=i;
      break;
    }
  }    
  
  sumLoss    = parseFloat(fm.all("prpLpersonVeriSumLoss")[findex].value);      
  sumReject  = parseFloat(fm.all("prpLpersonVeriSumReject")[findex].value); 
  
  if(isNaN(sumLoss))
    sumLoss = 0;
  if(isNaN(sumReject))
    sumReject = 0;
  
  sumDefLoss = sumLoss - sumReject; 
  
  fm.all("prpLpersonVeriSumDefLoss")[findex].value = point(round(sumDefLoss,2),2);       
            
} 
</script>
    <span style="display:" id="SpanPerson" cellspacing="1" cellpadding="0"> 
      <span style="display:none"> 
        <table class="common" style="display:none" id="PersonFeeLoss_Data" cellpadding="5" cellspacing="1">
          <tbody>   
            <tr>   
             <%--//modify by wangli remark start 20050401 --%>
             <%--
              <td class="input">  
                <input type="hidden" name="personSerialNo" style="width:20px"> 
                <input type="input" name="prpLpersonKindCode" class="codecode" style="width:60px"
                      ondblclick= "code_CodeSelect(this,'PolicyKindCodeForPerson');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCodeForPerson');">         
              </td>
              <td class="input">   
                  <input type="input" name="prpLpersonKindName" class="codename" style="width:80px"
			             ondblclick="code_CodeSelect(this, 'PolicyKindCodeForPerson','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'PolicyKindCodeForPerson','-1','always','none','post');">         
              </td>
              --%>
              <%--//modify by wangli remark end 20050401 --%>
              

              <td class="input">  
               <%--//modify by wangli add start 20050401 --%>
               <input type="hidden" name="personSerialNo" style="width:20px"> 
                <%--//modify by wangli add end 20050401 --%>
                <input type="input" name="prpLpersonFeeTypeCode" class="codecode" style="width:60px"
                      ondblclick= "code_CodeSelect(this,'PersonFeeType');"
                      onchange="code_CodeChange(this,'PersonFeeType');"
                      onkeyup= "code_CodeSelect(this,'PersonFeeType');"
                      onblur="feeTypeIsExist(this);">         
              </td>
              <td class="input">   
                  <input type="input" name="prpLpersonFeeTypeName" class="codename" style="width:130px"
			             ondblclick="code_CodeSelect(this, 'PersonFeeType','-1','name','none','post');"
			             onchange="code_CodeChange(this, 'PersonFeeType','-1','name','none','post');"
			             onkeyup= "code_CodeSelect(this, 'PersonFeeType','-1','name','none','post');"
			             onblur="feeTypeIsExist(this);">         
              </td>
        <!--
              <td class="input">
                <input name="prpLpersonUnitLoss" title="单价" class="common" style="width:60px">
              </td>
              <td class="input">
                <input name="prpLpersonQuantity" class="common" style="width:60px">
              </td>                     -->
              <td class="input">
                <input name="prpLpersonSumLoss" class="common" style="width:60px" onBlur="return calSumPersonDefLoss(this)">
              </td> 
              <td class="input">
                <input name="prpLpersonSumReject" class="common" style="width:60px" onBlur="return calSumPersonDefLoss(this)">
              </td>                                           
              <!--//modify by wangli add start 20050401 -->
              <td class="input">
                <input name="prpLpersonSumDefLoss" class="common" style="width:60px" onBlur="return calSumPersonDefLoss(this)">
              </td>
          
              <td class="input">
               <input name="prpLpersonRejectReason" class="common" style="width:60px" >
                <!-- <input name="prpLpersonSumDefLoss" class="common" style="width:60px"> -->
                <!--//modify by wangli add end 20050401 -->
                <input type="hidden" name="prpLpersonItemKindNo"> 
                <input type="hidden" name="prpLpersonFamilyNo"> 
                <input type="hidden" name="prpLpersonItemCode"> 
                <input type="hidden" name="prpLpersonUnit">  
                <input type="hidden" name="prpLpersonTimes">   
            <%--//    <input type="hidden" name="prpLpersonRejectReason"> --%>
                <input type="hidden" name="prpLpersonVeriQuantity"> 
                <input type="hidden" name="prpLpersonVeriUnitLoss"> 
                <input type="hidden" name="prpLpersonVeriUnit"> 
                <input type="hidden" name="prpLpersonVeriTimes">    
                <input type="hidden" name="prpLpersonVeriSumLoss"> 
                <input type="hidden" name="prpLpersonVeriSumReject"> 
                <input type="hidden" name="prpLpersonVeriRejectReason"> 
                <input type="hidden" name="prpLpersonVeriLossRate"> 
                <input type="hidden" name="prpLpersonVeriSumDefLoss"> 
                <input type="hidden" name="prpLpersonVeriRemark"> 
                <input type="hidden" name="prpLpersonFlag"> 
                <input type="hidden" name="prpLpersonCompensateBackFlag" >
                <input type="hidden" name="CompensateBackFlag"> 
              </td>                                                                            
              <td class="input"> 
                <div align="center">
                  <input type=button name="buttonPersonFeeLossDelete"  class="smallbutton" onclick="deleteRowTable(this,'PersonFeeLoss',1,1)" value="-" readonly style="cursor: hand">
                </div>              
              </td>             
            </tr>
          </tbody>
        </table>
      </span>
       
      <table cellpadding="5" cellspacing="1" class="common" >
      <!--表示显示多行的-->    
        <tr>
          <td class="subformtitle" colspan="4" align="center">
            赔付人员信息             
          </td>
        </tr>
        <tr class=common>
          <td  colspan="4">
            <span style="display:none"> 
              <table class="common" style="display:none" id="Person_Data" cellpadding="5" cellspacing="1">
                <tbody>                      
                   <tr>
                     <td class="input" style="width:3%">
                       <div align="center">
                         <input class="readonlyNo" readonly name="prpLpersonSerialNo" description="序号">
                       </div>
                     </td>
                     <td class="common">
                       <table  cellpadding="5" cellspacing="1" class="common">
                         <tr>
                           <td class="title" style="width:15%">伤者姓名:</td>
                           <td class="input" style="width:85%" colspan="3">
                             <input name="prpLpersonPersonName" class="input" style="width:150px"><img src="/claim/images/bgMarkMustInput.jpg">
                           </td>
                         </tr>      
                         
                          <!-- modify by wangli add start 20050401 -->
                          <tr>    
                           <td  class="title" style="width:15%">险别代码:</td>
                           <td  class="input" style="width:35%" > 
                           <input type="input" name="prpLpersonKindCode" class="codecode" style="width:150px"
                           ondblclick= "code_CodeSelect(this,'PolicyKindCodeForPerson');"
                           onchange="code_CodeChange(this, 'PolicyKindCodeForPerson');"
                           onkeyup= "code_CodeSelect(this,'PolicyKindCodeForPerson');">
                           </td>
                           <td class="title" style="width:15%">险别名称:</td>
                           <td  type="input" style="width:35%" >
                            <input type="input" name="prpLpersonKindName" class="codename"" style="width:150px"  
                             ondblclick="code_CodeSelect(this, 'PolicyKindCodeForPerson','-1','name','none','post');"
                             onchange="code_CodeChange(this, 'PolicyKindCodeForPerson','-1','name','none','post');"
			     onkeyup= "code_CodeSelect(this, 'PolicyKindCodeForPerson','-1','name','none','post');">
			   </td>
                           </tr> 
                        <!-- modify by wangli add end 2050401 -->   
                         
                         
                         
                         <tr>
                           <td class="title" style="width:15%">性别:</td>
                           <td class="input" style="width:35%">                                    
                            <select name="prpLpersonPersonSex" class='input' style="width:150px">   
                               <option value="1">男</option>
                               <option value="2">女</option>                   
                            </select>   
                           </td>
                           <td class="title" style="width:15%">号牌号码:</td>
                           <td class="input" style="width:35%">
  		                     <%
          		                Collection collection = (Collection)request.getAttribute("LicenseNoList"); 
          		                Iterator iteratorLicenseNo1 = collection.iterator();
          		              %>
                            <select name="familyName" style="width:150px">
                            <%
                              while (iteratorLicenseNo1.hasNext()){
                              PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)iteratorLicenseNo1.next();
                            %>
                              <option value="<%= prpLthirdPartyDto.getLicenseNo() %>"><%= prpLthirdPartyDto.getLicenseNo() %></option>
                             <%
                               }
                             %> 
                            </select><img src="/claim/images/bgMarkMustInput.jpg">  
                           </td> 
                         </tr>  
                         <tr>
                           <td class="title" style="width:15%">年龄:</td>
                           <td class="input" style="width:85%" colspan="3">
                             <input name="prpLpersonPersonAge" class="input" style="width:150px">
                           </td>
                         </tr>   
                         <tr>
                           <td class="title" style="width:15%">身份证号码:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonIdentifyNumber" class="input" style="width:150px">
                           </td>
                           <td class="title" style="width:15%">所在地区:</td>
                           <td class="input" style="width:35%">
                            <input type="input" name="prpLpersonAreaCode" class="codecode" style="width:50px"
                                  ondblclick= "code_CodeSelect(this,'DamageDistrict');"
                                  onchange="code_CodeChange(this, 'DamageDistrict');"
                                  onkeyup= "code_CodeSelect(this,'DamageDistrict');"> 
                            <input type="input" name="prpLpersonAreaName" class="codename" style="width:150px"
            			 ondblclick="code_CodeSelect(this, 'DamageDistrict','-1','name','none','post');"
            			 onchange="code_CodeChange(this, 'DamageDistrict','-1','name','none','post');"
            			 onkeyup= "code_CodeSelect(this, 'DamageDistrict','-1','name','none','post');">
            			 <img src="/claim/images/bgMarkMustInput.jpg">
                           </td>
                         </tr> 
                         
                         <tr>
                           <td class="title" style="width:15%">工作单位:</td>
                           <td class="input" style="width:85%" colspan="3">
                             <input name="prpLpersonJobUnit" class="input"  maxlength="15" style="width:450px">
                           </td>
                         </tr> 
                         <tr>
                           <td class="title" style="width:15%">标准工资:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonMonthStdWage" class="input" style="width:150px">
                           </td>
                           <td class="title" style="width:15%">月奖金:</td>
                           <td class="input" style="width:35%">
                            <input type="input" name="prpLpersonMonthBonus" class="input" style="width:150px"> 
                           </td>
                         </tr> 
                         <tr>
                           <td class="title" style="width:15%">津（补）贴:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonAllowance" class="input" style="width:150px">
                           </td>
                           <td class="title" style="width:15%">月收入小计:</td>
                           <td class="input" style="width:35%">
                            <input type="input" name="prpLpersonMonthWage" class="input" style="width:150px"> 
                           </td>
                         </tr> 
                         <tr>
                           <td class="title" style="width:15%">就诊医院:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonHospital" class="input" style="width:150px">
                           </td>
                           <td class="title" style="width:15%">需要护理人数:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonNursePersons" class="input" style="width:150px">
                           </td>
                         </tr> 
                         <tr>
                           <td class="title" style="width:15%">需要护理天数:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonNurseDays" class="input" style="width:150px">
                           </td>
                           <td class="title" style="width:15%">诊断结果:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonDiagnose" class="input" style="width:150px">
                           </td>
                         </tr>                          
                         <tr>
                           <td class="title" style="width:15%">伤势程度:</td>
                           <td class="input" style="width:35%">
                            <select name="prpLpersonWoundGrade" style="width:150px">
                              <option value="1">伤</option>
                              <option value="2">残</option>
                              <option value="3">死亡</option>
                            </select> 
                           </td>
                           <td class="title" style="width:15%">拟住院天数:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonHospitalDays" class="input" style="width:150px">
                           </td>
                         </tr> 
                         <tr>
                           <td class="title" style="width:15%">拟治疗天数:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonCureDays" class="input" style="width:150px">
                           </td>
                           <td class="title" style="width:15%">是否需要转院治疗:</td>
                           <td class="input" style="width:35%">
                            <select name="prpLpersonChangeHospital" style="width:150px">
                              <option value="1">是</option>
                              <option value="0">否</option>
                            </select> 
                           </td>
                         </tr> 
                         
                         
                         <tr>
                           <td class="title" style="width:15%">收入情况:</td>
                           <td class="input" style="width:35%">
  		                     <%
          		                Collection collectionFixedIncomeFlagList = (Collection)request.getAttribute("FixedIncomeFlagList"); 
          		                Iterator iteratorFixedIncomeFlagList = collectionFixedIncomeFlagList.iterator();
          		              %>
                            <select name="prpLpersonFixedIncomeFlag" style="width:150px">
                            <%
                              while (iteratorFixedIncomeFlagList.hasNext()){
                              LabelValueBean labelValueBean = (LabelValueBean)iteratorFixedIncomeFlagList.next();
                            %>
                              <option value="<%= labelValueBean.getValue() %>"><%= labelValueBean.getLabel() %></option>
                             <%
                               }
                             %> 
                            </select> 
                           </td>
                           <td class="title" style="width:15%">行业:</td>
                           <td class="input" style="width:35%">
                            <input type="input" name="prpLpersonJobCode" class="codecode" style="width:50px"
                                  ondblclick= "code_CodeSelect(this,'BusinessSource');"
                                  onchange="code_CodeChange(this, 'BusinessSource');"
                                  onkeyup= "code_CodeSelect(this,'BusinessSource');"> 
                            <input type="input" name="prpLpersonJobName" class="codename" style="width:150px"
            			  ondblclick="code_CodeSelect(this, 'BusinessSource','-1','name','none','post');"
            			  onchange="code_CodeChange(this, 'BusinessSource','-1','name','none','post');"
            			  onkeyup= "code_CodeSelect(this, 'BusinessSource','-1','name','none','post');">
            			  <img src="/claim/images/bgMarkMustInput.jpg">
                           </td>
                         </tr> 
                         
                         <tr>
                           <td class="title" style="width:15%">人员类型:</td>
                           <td class="input" style="width:35%">
  		                     <%
          		                Collection collectionPayPersonTypeList = (Collection)request.getAttribute("PayPersonTypeList"); 
          		                Iterator iteratorPayPersonTypeList = collectionPayPersonTypeList.iterator();
          		              %> 
                            <select name="prpLpersonPayPersonType" style="width:150px"  onchange="setPropertyOfPage(this);">
                            <%
                              while (iteratorPayPersonTypeList.hasNext()){
                              LabelValueBean labelValueBean = (LabelValueBean)iteratorPayPersonTypeList.next();
                            %>
                              <option value="<%= labelValueBean.getValue() %>"><%= labelValueBean.getLabel() %></option>
                             <% 
                               }
                             %> 
                            </select>
                           </td>
                           <td class="title" style="width:15%">关联人员:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonRelatePersonNo" class="input" style="width:150px" onchange="return checkRelatePersonNo(this);">
                           </td>
                         </tr> 
                          
                         <tr>
                           <td class="title" style="width:15%">伤残比例:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonLossRate" class="input" style="width:150px">%
                           </td>
                           <td class="title" style="width:15%">币别:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonCurrencyName" class="readonly" readonly style="width:150px" value="人民币">
                             <input name="prpLpersonCurrency" type="hidden" value="CNY">
                           </td>
                         </tr> 
                         
                        <%-- //modify by wangli add start 20050401 --%>
                             <tr>
                           <td class="title" style="width:15%">入院日期:</td>  
                           <td class="input" style="width:35%">
                             <input type="input" name="prpLpersonInHospDate" class="codename" style="width:150px"   ondblclick="return getDateTime(this);" onchange="checkOutAndInHospDate(this);" > 
                           </td>
                           <td class="title" style="width:15%">出院日期:</td>
                           <td class="input" style="width:35%">
                             <input type="input" name="prpLpersonOutHospDate" class="codename" style="width:150px" ondblclick="return getDateTime(this);" onchange="checkOutAndInHospDate(this);">
                           </td>
                         </tr>
                            <tr>
                           <td class="title" style="width:15%">定残日期:</td>
                           <td class="input" style="width:85%" colspan="3">
                             <input type="input" name="prpLpersonRestDate" class="codename" style="width:150px" ondblclick="return getDateTime(this);">
                           </td>
                         </tr>
                           <tr>
                           <td class="title" style="width:15%">续医情况说明:</td>
                           <td class="input" style="width:85%" colspan="3">
                             <input name="prpLpersonFllowHospRemark" class="input" style="width:350px" maxLength="255" onblur="checkLength1(this);" description="续医情况说明">
                           </td>
                         </tr>  
                          <%-- //modify by wangli add end  20050401 --%>
                               
                         
                         <tr>
                           <td class="title" style="width:15%">备注:</td>
                           <td class="input" style="width:85%" colspan="3">
                             <input name="prpLpersonRemark" class="input" style="width:350px" maxLength="60" onblur="checkLength1(this);" description="备注">
                             <input type="hidden" name="prpLpersonPersonNo"> 
                           </td>
                         </tr>                           
                         
                         <tr> 
                           <td class="common" style="width:100%" colspan="4">
                            <table name="PersonFeeLoss" class="common" cellpadding="5" cellspacing="1">
                              <tr> 
                                <td class="title" style="width:4%" rowspan="6">伤情类别</td>
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck001" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck001Txt" value="0"></td> 
                                <td class="title" style="width:14%">颅脑损伤</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck002" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck002Txt" value="0"></td> 
                                <td class="title" style="width:14%">肋骨骨折</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck003" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck003Txt" value="0"></td> 
                                <td class="title" style="width:14%">下肢骨折</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck004" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck004Txt" value="0"></td> 
                                <td class="title" style="width:14%">脾脏损伤</td>                                                                                      
                              </tr>                                                                                                                                    
                              <tr>                                                                                                                                     
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck005" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck005Txt" value="0"></td> 
                                <td class="title" style="width:14%">容貌损伤</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck006" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck006Txt" value="0"></td> 
                                <td class="title" style="width:14%">脊柱骨折</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck007" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck007Txt" value="0"></td> 
                                <td class="title" style="width:14%">手部骨折</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck008" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck008Txt" value="0"></td> 
                                <td class="title" style="width:14%">胰脏损伤</td>                                                                                      
                              </tr>                                                                                                                                    
                              <tr>                                                                                                                                     
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck009" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck009Txt" value="0"></td> 
                                <td class="title" style="width:14%">颈部损伤</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck010" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck010Txt" value="0"></td> 
                                <td class="title" style="width:14%">脊髓骨折</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck011" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck011Txt" value="0"></td> 
                                <td class="title" style="width:14%">足部骨折</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck012" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck012Txt" value="0"></td> 
                                <td class="title" style="width:14%">肾脏损伤</td>                                                                                       
                              </tr>                                                                                                                                    
                              <tr>                                                                                                                                     
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck013" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck013Txt" value="0"></td> 
                                <td class="title" style="width:14%">颈椎损伤</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck014" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck014Txt" value="0"></td> 
                                <td class="title" style="width:14%">盆骨骨折</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck015" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck015Txt" value="0"></td> 
                                <td class="title" style="width:14%">心脏损伤</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck016" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck016Txt" value="0"></td> 
                                <td class="title" style="width:14%">其他内脏损伤</td>                                                                                  
                              </tr>                                                                                                                                    
                              <tr>                                                                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck017" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck017Txt" value="0"></td> 
                                <td class="title" style="width:14%">锁骨骨折</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck018" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck018Txt" value="0"></td> 
                                <td class="title" style="width:14%">股骨头骨折</td>                                                                                    
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck019" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck019Txt" value="0"></td> 
                                <td class="title" style="width:14%">肺部损伤</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck020" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck020Txt" value="0"></td> 
                                <td class="title" style="width:14%">软组织挫伤</td>                                                                                    
                              </tr>                                                                                                                                    
                              <tr>                                                                                                                                     
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck021" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck021Txt" value="0"></td> 
                                <td class="title" style="width:14%">胸骨骨折</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck022" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck022Txt" value="0"></td> 
                                <td class="title" style="width:14%">上臂骨折</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck023" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck023Txt" value="0"></td> 
                                <td class="title" style="width:14%">肝脏损伤</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck024" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck024Txt" value="0"></td> 
                                <td class="title" style="width:14%">其他损伤</td> 
                              </tr> 
                            </table> 
                           </td> 
                         </tr>  
                         
                        <tr>
                        <td colspan="4">
                          <span  id="spanPersonFeeLoss" >
                          <%-- 多行输入展现域 --%>
                          <table id="PersonFeeLoss" name="PersonFeeLoss" class="common" cellpadding="5" cellspacing="1">
                            <thead>
                              <tr>
                                <td class="centertitle" colspan=10>
                                  人员伤亡费用清单信息 
                                </td>
                              </tr>
                              <tr> 
                              <%-- // modify by wangli remark start 20050331
                                <td class="centertitle" style="width:10%">险别代码</td>                              
                                <td class="centertitle" style="width:15%">险别名称</td>
                                 //--modify by wangli remark end  20050331 --%>
                                <td class="centertitle" style="width:12%">费用代码</td>
                                <td class="centertitle" style="width:13%">费用名称<img src="/claim/images/bgMarkMustInput.jpg"></td>
                               <!-- <td class="centertitle" style="width:12%">单价</td>
                                <td class="centertitle" style="width:11%">数量</td>    -->                                    
                                <td class="centertitle" style="width:11%">报损金额</td>
                                <td class="centertitle" style="width:11%">剔除金额</td> 
                                <%--modify by wangli update start 20050401--%>
                               <td  class="centertitle" style="width:11%">定损金额</td>
                               <td  class="centertitle" style="width:15%">剔除情况说明</td>
                               <%--modify by wangli update start 20050401--%>
                                <td class="centertitle" style="width:3%" colspan=2>  </td>                                            
                              </tr>  
                            </thead>                            
                            <tfoot>
                              <tr>
                                <td class="title" colspan="8" style="width:97%">(按"+"号键增加人员伤亡费用信息，按"-"号键删除信息)</td>
                                <td class="title" align="right" style="width:4%">
                                  <div align="center">
                                    <input type="button" class=smallbutton value="+" onclick="insertRowTable('PersonFeeLoss','PersonFeeLoss_Data',this);" name="buttonPersonFeeLossInsert" readonly style="cursor: hand">
                                  </div>
                                </td>
                              </tr>
                            </tfoot> 
                             
                            <tbody>
                   
                            </tbody>
                          </table>  
                        </span>  
                      </td>
                    </tr>            
                    <tr>
                      <td colspan="4">
                        <table class="common" style="width:100%"> 
                          <td class='title' colspan="1" width="30%">报损金额:<input class='readonly' readonly="true" style='width:80px' name='prpLpersonSumLossSum'>
                          </td>    
                          <td class='title' colspan="1" width="30%">剔除金额:<input class='readonly'  readonly="true" style='width:80px' name='prpLpersonSumRejectSum'>
                          </td>   
                          <td class='title' colspan="2" width="40%">定损金额:<input class='readonly'  readonly="true" style='width:80px' name='prpLpersonSumDefLossSum'>
                          </td>
                        </table>   
                      </td>   
                    </tr>
                  </tbody> 
                </table>
              </td>
              <td class="input" style="width:4%">
                <div align="center">
                  <input type=button name="buttonPersonDelete"  class=smallbutton onclick="deleteRow(this,'Person')" value="-" style="cursor: hand">
                </div>
              </td>                       
           </tr> 
         </tbody>
       </table>
     </span>
          
     <span  id="spanPerson">
       <%-- 多行输入展现域 --%>
       <table id="person" class="common" align="center" cellspacing="1" cellpadding="5">
         <thead>
           <tr>
             <td class="title" style="width:4%">序号</td>
             <td class="title" style="width:96%" colspan=2 >内容</td>
           </tr> 
         </thead>
         <tfoot>
           <tr>
             
             <td class="title"  colspan=2 align="right" >
               <div align="center">
                 <input type="button" value="+"  class=smallbutton onclick="insertRow('person')" name="buttonPersonInsert" style="cursor: hand">
               </div>
             </td>
           </tr>
         </tfoot> 
         <tbody>

<% indexCertainLoss=0;%>
<% String compensatebackReadOnlyP=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String compensatebackDiasableP=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String compensatebackStyleP=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>

<%
    int personNo = 0;
    PrpLpersonDto prpLpersonDto = (PrpLpersonDto)request.getAttribute("prpLpersonDto"); 
    if(prpLpersonDto.getPersonList()!=null){
      Iterator iterator = prpLpersonDto.getPersonList().iterator();
      while(iterator.hasNext()){ 
        PrpLpersonDto PrpLpersonDto1 =  (PrpLpersonDto)iterator.next();
        if(!(PrpLpersonDto1.getPersonNo() == personNo)){
        
         
        
%>               
                   <tr>
                     <td class="input" style="width:3%">
                       <div align="center">
                         <input class="readonlyNo" readonly name="prpLpersonSerialNo" description="序号" value="<%= personNo+1 %>">
                       </div>     
                     </td>
                     <td class="common">
                       <table  cellpadding="5" cellspacing="1" class="common">
                         <tr>
                           <td class="title" >伤者姓名:</td>
                           <td class="input"  colspan="2">
                             <input name="prpLpersonPersonName" class="input" style="width:150px"  value="<%= PrpLpersonDto1.getPersonName() %>"><img src="/claim/images/bgMarkMustInput.jpg">
                           </td>
<%if (PrpLpersonDto1.getKindCode().equals("B")||PrpLpersonDto1.getKindCode().equals("003")) {%>                           
                       <td class="title" style="width:15%">三者人伤</td>
                       <%}%>                       
<%if  (PrpLpersonDto1.getKindCode().equals("D3")||PrpLpersonDto1.getKindCode().equals("D4") || PrpLpersonDto1.getKindCode().equals("004")) {%>                           
                       <td class="title" style="width:15%">车上人伤</td>
                       <%}%>
<%if  (!PrpLpersonDto1.getKindCode().equals("D3") ||
	   !PrpLpersonDto1.getKindCode().equals("D4") ||
		!PrpLpersonDto1.getKindCode().equals("B")) {%>                           
                       <td class="title" style="width:15%"></td>
                       <%}%>
                       
                         </tr>      
                         
                      <%--modify by  wangli   add start 20050331--%>  
                         <tr>
                       <td class="title" style="width:15%">险别代码:</td>
                       <td class="input" style="width:35%">                             
                       <input type="input" name="prpLpersonKindCode" class="codecode" style="width:150px" value="<%= PrpLpersonDto1.getKindCode() %>"
                           ondblclick= "code_CodeSelect(this,'PolicyKindCodeForPerson');"
                           onchange="code_CodeChange(this, 'PolicyKindCodeForPerson');"
                           onkeyup= "code_CodeSelect(this,'PolicyKindCodeForPerson');"
                       >
                       </td>
                      <td  class="title" style="width:15%">险别名称:</td>
                      <td  class="input" style="width:35%" > 
                      <input type="input" name="prpLpersonKindName" class="codename" style="width:150px" value="<%= PrpLpersonDto1.getKindName() %>"
                       ondblclick="code_CodeSelect(this, 'PolicyKindCodeForPerson','-1','name','none','post');"
                       onchange="code_CodeChange(this, 'PolicyKindCodeForPerson','-1','name','none','post');"
			                 onkeyup= "code_CodeSelect(this, 'PolicyKindCodeForPerson','-1','name','none','post');">
			      
                       </td>                          
                        </tr> 
                       <%--modify by  wangli   add end 20050331--%>
                         
                         <tr>
                           <td class="title" style="width:15%">性别:</td>
                           <td class="input" style="width:35%">                
                           <select name="prpLpersonPersonSex" class="three" style="width:150px"  value="<%= PrpLpersonDto1.getPersonSex() %>">   
                               <option value="1" <%= PrpLpersonDto1.getPersonSex().trim().equals("1")? "selected":"" %>>男</option>
                               <option value="2" <%= PrpLpersonDto1.getPersonSex().trim().equals("2")? "selected":"" %>>女</option>                   
                            </select>   
                           </td>
                           <td class="title" style="width:15%">号牌号码:</td>
                           <td class="input" style="width:35%"> 
                           <%
          		                Iterator iteratorLicenseNo2 = collection.iterator();
          		              %>
                            <select name="familyName" style="width:150px"> 
                            <%
                              while (iteratorLicenseNo2.hasNext()){ 
                              PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)iteratorLicenseNo2.next();
                            %>
                              <option value="<%= prpLthirdPartyDto.getLicenseNo() %>" <%= ((PrpLpersonDto1.getFamilyName().trim().equals(prpLthirdPartyDto.getLicenseNo().trim())) ? "selected" : "") %>><%= prpLthirdPartyDto.getLicenseNo() %></option>
                             <%
                               }
                             %>  
                            </select><img src="/claim/images/bgMarkMustInput.jpg">                                
                           </td>
                         </tr> 
                         
                         <tr>
                           <td class="title" style="width:15%">年龄:</td>
                           <td class="input" style="width:85%" colspan="3">
                             <input name="prpLpersonPersonAge" class="input" style="width:150px" value="<%= PrpLpersonDto1.getPersonAge() %>">
                           </td>
                         </tr> 
                         <tr>
                           <td class="title" style="width:15%">身份证号码:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonIdentifyNumber" class="input" style="width:150px" value="<%= PrpLpersonDto1.getIdentifyNumber() %>">
                           </td>
                           <td class="title" style="width:15%">所在地区:</td>
                           <td class="input" style="width:35%">
                            <input type="input" name="prpLpersonAreaCode" class="codecode" style="width:50px" value="<%= PrpLpersonDto1.getAreaCode() %>"
                                  ondblclick= "code_CodeSelect(this,'DamageDistrict');"
                                  onchange="code_CodeChange(this, 'DamageDistrict');"
                                  onkeyup= "code_CodeSelect(this,'DamageDistrict');"> 
                            <input type="input" name="prpLpersonAreaName" class="codename" style="width:150px" value="<%= PrpLpersonDto1.getAreaName() %>"
            			  ondblclick="code_CodeSelect(this, 'DamageDistrict','-1','name','none','post');"
            			  onchange="code_CodeChange(this, 'DamageDistrict','-1','name','none','post');"
            			  onkeyup= "code_CodeSelect(this, 'DamageDistrict','-1','name','none','post');"><img src="/claim/images/bgMarkMustInput.jpg">
                           </td>
                         </tr> 
                         
                         
                         <tr>
                           <td class="title" style="width:15%">工作单位:</td>
                           <td class="input" style="width:85%" colspan="3">
                             <input name="prpLpersonJobUnit" class="input" maxlength="15" style="width:450px" value="<%= PrpLpersonDto1.getJobUnit() %>">
                           </td>
                         </tr> 
                         <tr>
                           <td class="title" style="width:15%">标准工资:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonMonthStdWage" class="input" style="width:150px" value="<%= sf.format(PrpLpersonDto1.getMonthStdWage()) %>">
                           </td>
                           <td class="title" style="width:15%">月奖金:</td>
                           <td class="input" style="width:35%">
                            <input type="input" name="prpLpersonMonthBonus" class="input" style="width:150px" value="<%= sf.format(PrpLpersonDto1.getMonthBonus()) %>"> 
                           </td>
                         </tr> 
                         <tr>
                           <td class="title" style="width:15%">津（补）贴:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonAllowance" class="input" style="width:150px" value="<%= sf.format(PrpLpersonDto1.getAllowance()) %>">
                           </td>
                           <td class="title" style="width:15%">月收入小计:</td>
                           <td class="input" style="width:35%">
                            <input type="input" name="prpLpersonMonthWage" class="input" style="width:150px" value="<%= sf.format(PrpLpersonDto1.getMonthWage()) %>"> 
                           </td>
                         </tr> 
                         <tr>
                           <td class="title" style="width:15%">就诊医院:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonHospital" class="input" style="width:150px" value="<%= PrpLpersonDto1.getHospital() %>">
                           </td>
                           <td class="title" style="width:15%">需要护理人数:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonNursePersons" class="input" style="width:150px" value="<%= PrpLpersonDto1.getNursePersons() %>">
                           </td>
                         </tr> 
                         <tr>
                           <td class="title" style="width:15%">需要护理天数:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonNurseDays" class="input" style="width:150px" value="<%= PrpLpersonDto1.getNurseDays() %>">
                           </td>
                           <td class="title" style="width:15%">诊断结果:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonDiagnose" class="input" style="width:150px" value="<%= PrpLpersonDto1.getDiagnose() %>">
                           </td>
                         </tr>                          
                         <tr>
                           <td class="title" style="width:15%">伤势程度:</td> 
                           <td class="input" style="width:35%"> 
                           
                            <select name="prpLpersonWoundGrade" style="width:150px">
                              <option value="1" <%= PrpLpersonDto1.getWoundGrade().equals("1")?"selected":"" %>>伤</option>
                              <option value="2" <%= PrpLpersonDto1.getWoundGrade().equals("2")?"selected":"" %>>残</option>
                              <option value="3" <%= PrpLpersonDto1.getWoundGrade().equals("3")?"selected":"" %>>死亡</option>
                            </select> 
                            
                           </td>
                           <td class="title" style="width:15%">拟住院天数:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonHospitalDays" class="input" style="width:150px" value="<%= PrpLpersonDto1.getHospitalDays() %>">
                           </td>
                         </tr> 
                         <tr>
                           <td class="title" style="width:15%">拟治疗天数:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonCureDays" class="input" style="width:150px" value="<%= PrpLpersonDto1.getCureDays() %>">
                           </td>
                           <td class="title" style="width:15%">是否需要转院治疗:</td>
                           <td class="input" style="width:35%">                            
                            <select name="prpLpersonChangeHospital" style="width:150px">
                              <option value="1" <%= PrpLpersonDto1.getChangeHospital().equals("1")?"selected":"" %>>是</option>
                              <option value="0" <%= PrpLpersonDto1.getChangeHospital().equals("0")?"selected":"" %>>否</option>
                            </select>  
                           </td>
                         </tr>   
                         
                         <tr>
                           <td class="title" style="width:15%">收入情况:</td>
                           <td class="input" style="width:35%">
  		                     <% 
          		                iteratorFixedIncomeFlagList = collectionFixedIncomeFlagList.iterator();
          		              %>
                            <select name="prpLpersonFixedIncomeFlag" style="width:150px">
                            <%
                              while (iteratorFixedIncomeFlagList.hasNext()){
                              LabelValueBean labelValueBean = (LabelValueBean)iteratorFixedIncomeFlagList.next();
                            %>
                              <option value="<%= labelValueBean.getValue() %>" <%= ((labelValueBean.getValue().trim().equals(PrpLpersonDto1.getFixedIncomeFlag().trim())) ? "selected" : "") %>><%= labelValueBean.getLabel() %></option>
                             <%
                               }
                             %> 
                            </select>
                           </td>
                           <td class="title" style="width:15%">行业:</td>
                           <td class="input" style="width:35%">
                            <input type="input" name="prpLpersonJobCode" class="codecode" style="width:50px" value="<%= PrpLpersonDto1.getJobCode() %>"
                                  ondblclick= "code_CodeSelect(this,'BusinessSource');"
                                  onchange="code_CodeChange(this, 'BusinessSource');"
                                  onkeyup= "code_CodeSelect(this,'BusinessSource');"> 
                            <input type="input" name="prpLpersonJobName" class="codename" style="width:150px" value="<%= PrpLpersonDto1.getJobName() %>"
            			             ondblclick="code_CodeSelect(this, 'BusinessSource','-1','name','none','post');"
            			             onchange="code_CodeChange(this, 'BusinessSource','-1','name','none','post');"
            			             onkeyup= "code_CodeSelect(this, 'BusinessSource','-1','name','none','post');"><img src="/claim/images/bgMarkMustInput.jpg">
                           </td>
                         </tr> 
                             
                         <tr>
                           <td class="title" style="width:15%">人员类型:</td>
                           <td class="input" style="width:35%">
  		                     <%
          		                iteratorPayPersonTypeList = collectionPayPersonTypeList.iterator();
          		              %>
                            <select name="prpLpersonPayPersonType" style="width:150px"  onchange="setPropertyOfPage(this);">
                            <%
                              while (iteratorPayPersonTypeList.hasNext()){
                              LabelValueBean labelValueBean = (LabelValueBean)iteratorPayPersonTypeList.next();
                            %>
                              <option value="<%= labelValueBean.getValue() %>" <%= ((labelValueBean.getValue().trim().equals(PrpLpersonDto1.getPayPersonType().trim())) ? "selected" : "") %>><%= labelValueBean.getLabel() %></option>
                             <%
                               }
                             %> 
                            </select> 
                           </td>
                           <td class="title" style="width:15%">关联人员:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonRelatePersonNo" class="input" style="width:150px" value="<%= PrpLpersonDto1.getRelatePersonNo() %>" onchange="return checkRelatePersonNo(this);">
                           </td>
                         </tr>   
                                                  
                         <tr>
                           <td class="title" style="width:15%">伤残比例:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonLossRate" class="input" style="width:150px" value="<%= PrpLpersonDto1.getLossRate() %>">%
                           </td>
                           <td class="title" style="width:15%">币别:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonCurrencyName" class="readonly" readonly style="width:150px" value="人民币">
                             <input name="prpLpersonCurrency" type="hidden" value="CNY">
                           </td>
                         </tr> 
                         
                               
                       <%-- //modify by wangli add start 20050401 --%> 
                             <tr>
                           <td class="title" style="width:15%">入院日期:</td>
                           <td class="input" style="width:35%">
                             <input type="input" name="prpLpersonInHospDate" class="codename" style="width:150px" value="<%=PrpLpersonDto1.getInHospDate().toString()%>"  ondblclick="return getDateTime(this);" onchange="checkOutAndInHospDate(this);">
                           </td>
                           <td class="title" style="width:15%">出院日期:</td>
                           <td class="input" style="width:35%">
                             <input type="input" name="prpLpersonOutHospDate" class="codename" style="width:150px" value="<%=PrpLpersonDto1.getOutHospDate().toString()%>"  ondblclick="return getDateTime(this);" onchange="checkOutAndInHospDate(this);">
                           </td>
                         </tr>
                            <tr>
                           <td class="title" style="width:15%">定残日期:</td>
                           <td class="input" style="width:85%" colspan="3">
                             <input type="input" name="prpLpersonRestDate" class="codename" style="width:150px" value="<%=PrpLpersonDto1.getRestDate().toString()%>"  ondblclick="return getDateTime(this);" >
                           </td>
                         </tr>
                           <tr>
                           <td class="title" style="width:15%">续医情况说明:</td>
                           <td class="input" style="width:85%" colspan="3">
                             <input name="prpLpersonFllowHospRemark" class="input" style="width:350px" maxLength="255" onblur="checkLength1(this);" description="续医情况说明" value="<%=PrpLpersonDto1.getFllowHospRemark()%>">        
                           </td>
                         </tr>  
                         
                       <%-- //modify by wangli add end  20050401 --%>
                         
                         
                         <tr> 
                           <td class="title" style="width:15%">备注:</td>
                           <td class="input" style="width:85%" colspan="3">
                            <input name="prpLpersonRemark" class="input" style="width:350px" maxLength="60" onblur="checkLength1(this);" description="备注" value="<%= PrpLpersonDto1.getRemark() %>">
                            <input type="hidden" name="prpLpersonPersonNo" value="<%= PrpLpersonDto1.getPersonNo() %>"> 
                           </td>
                         </tr>  
                         

                         <tr> 
                           <td class="common" style="width:100%" colspan="4">
                            <table name="PersonFeeLoss" class="common" style="width:100%" cellpadding="1" cellspacing="1" border="0" >
                              <tr> 
                                <td class="title" style="width:4%" rowspan="6">伤情类别</td>
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck001" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck001Txt" value="0"></td> 
                                <td class="title" style="width:14%">颅脑损伤</td>                                                                                                       
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck002" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck002Txt" value="0"></td> 
                                <td class="title" style="width:14%">肋骨骨折</td>                                                                                                       
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck003" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck003Txt" value="0"></td> 
                                <td class="title" style="width:14%">下肢骨折</td>                                                                                                       
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck004" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck004Txt" value="0"></td> 
                                <td class="title" style="width:14%">脾脏损伤</td>                                                                                                       
                              </tr>                                                                                                                                                     
                              <tr>                                                                                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck005" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck005Txt" value="0"></td> 
                                <td class="title" style="width:14%">容貌损伤</td>                                                                                                       
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck006" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck006Txt" value="0"></td> 
                                <td class="title" style="width:14%">脊柱骨折</td>                                                                                                       
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck007" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck007Txt" value="0"></td> 
                                <td class="title" style="width:14%">手部骨折</td>                                                                                                       
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck008" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck008Txt" value="0"></td> 
                                <td class="title" style="width:14%">胰脏损伤</td>                                                                                                       
                              </tr>                                                                                                                                                      
                              <tr>                                                                                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck009" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck009Txt" value="0"></td> 
                                <td class="title" style="width:14%">颈部损伤</td>                                                                                                       
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck010" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck010Txt" value="0"></td> 
                                <td class="title" style="width:14%">脊髓骨折</td>                                                                                                       
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck011" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck011Txt" value="0"></td> 
                                <td class="title" style="width:14%">足部骨折</td>                                                                                                       
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck012" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck012Txt" value="0"></td> 
                                <td class="title" style="width:14%">肾脏损伤</td>                                                                                                       
                              </tr>                                                                                                                                                     
                              <tr>                                                                                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck013" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck013Txt" value="0"></td> 
                                <td class="title" style="width:14%">颈椎损伤</td>                                                                                                       
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck014" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck014Txt" value="0"></td> 
                                <td class="title" style="width:14%">盆骨骨折</td>                                                                                                       
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck015" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck015Txt" value="0"></td> 
                                <td class="title" style="width:14%">心脏损伤</td>                                                                                                       
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck016" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck016Txt" value="0"></td> 
                                <td class="title" style="width:14%">其他内脏损伤</td>                                                                                                   
                              </tr>                                                                                                                                                     
                              <tr>                                                                                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck017" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck017Txt" value="0"></td> 
                                <td class="title" style="width:14%">锁骨骨折</td>                                                                                                       
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck018" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck018Txt" value="0"></td> 
                                <td class="title" style="width:14%">股骨头骨折</td>                                                                                                     
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck019" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck019Txt" value="0"></td> 
                                <td class="title" style="width:14%">肺部损伤</td>                                                                                                       
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck020" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck020Txt" value="0"></td> 
                                <td class="title" style="width:14%">软组织挫伤</td>                                                                                                     
                              </tr>                                                                                                                                                     
                              <tr>                                                                                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck021" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck021Txt" value="0"></td> 
                                <td class="title" style="width:14%">胸骨骨折</td>                                                                                                       
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck022" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck022Txt" value="0"></td> 
                                <td class="title" style="width:14%">上臂骨折</td>                                                                                                       
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck023" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck023Txt" value="0"></td> 
                                <td class="title" style="width:14%">肝脏损伤</td>                                                                                                       
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck024" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck024Txt" value="0"></td> 
                                <td class="title" style="width:14%">其他损伤</td> 
                              </tr> 
                            </table>
                           </td>
                         </tr>                                                   
                         
                         
                        <tr> 
                        <td colspan="4" style="width:100%"> 
                          <span  id="spanPersonFeeLoss" >
                          <%-- 多行输入展现域 --%>
                          <table id="PersonFeeLoss" name="PersonFeeLoss"  class="common" style="width:100%">
                            <thead>
                              <tr>
                                <td class="subformtitle" colspan=10>
                                  人员伤亡费用清单信息 <font color="#FF0000">*</font> 
                                </td> 
                              </tr> 
                              <tr>
                               <%--//modify by wangli remark start 20050401 
                                <td class="centertitle" style="width:10%">险别代码</td> 
                                <td class="centertitle" style="width:14%">险别名称</td>
                                  //modify by wangli remark start 20050401 --%>
                                <td class="centertitle" style="width:12%">费用代码</td>
                                <td class="centertitle" style="width:13%">费用名称<img src="/claim/images/bgMarkMustInput.jpg"></td>
                               <!-- <td class="centertitle" style="width:12%">单价</td>
                                <td class="centertitle" style="width:11%">数量</td>    -->                                    
                                <td class="centertitle" style="width:11%">报损金额</td>
                                <td class="centertitle" style="width:11%">剔除金额</td> 
                                <%--modify by wangli update start 20050401--%>
                               <td  class="centertitle" style="width:11%">定损金额</td>
                               <td  class="centertitle" style="width:15%">剔除情况说明</td>
                               <%--modify by wangli update start 20050401--%>
                                <td class="centertitle" style="width:3%" colspan=2>  </td>                                           
                              </tr>  
                            </thead>
                            <tfoot>
                              <tr>
                                <td class="title" colspan="8" style="width:97%">(按"+"号键增加人员伤亡费用信息，按"-"号键删除信息)</td>
                                <td class="title" align="right" style="width:4%">
                                  <div align="center">
                                    <input type="button" value="+"   class="smallbutton" onclick="insertRowTable('PersonFeeLoss','PersonFeeLoss_Data',this);" name="buttonPersonFeeLossInsert" readonly style="cursor: hand">
                                  </div>
                                </td>
                              </tr>
                            </tfoot> 
                               
                            <tbody>
<%
   Iterator iterator1 = prpLpersonDto.getPersonList().iterator();
      while(iterator1.hasNext()){ 
        PrpLpersonDto PrpLpersonDto2 =  (PrpLpersonDto)iterator1.next();
        if(PrpLpersonDto2.getPersonNo() == (personNo+1)){
        
         //增加理算退回的判断
          compensatebackReadOnlyP="";
          compensatebackDiasableP="";
          compensatebackStyleP="";
          if ("1".equals(PrpLpersonDto2.getCompensateBackFlag())) {
              compensatebackStyleP=";background:#CECECE";
              compensatebackReadOnlyP="readOnly";
              compensatebackDiasableP="disabled";
          }
%> 
<%
          if(flag==null||flag.length()<1){ 
%>                    
            <tr>   
               <!-- //mdify by wangli remark start 20050401
              <td class="input">  
                <input type="hidden" name="personSerialNo" style="width:20px" value="<%= personNo+1 %>"> 
                <input type="input" name="prpLpersonKindCode" class="codecode" style="width:60px" value="<%= PrpLpersonDto2.getKindCode() %>"
                      ondblclick= "code_CodeSelect(this,'PolicyKindCodeForPerson');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCodeForPerson');">         
              </td>
              <td class="input">    
                  <input type="input" name="prpLpersonKindName" class="codename" style="width:80px" value="<%= PrpLpersonDto2.getKindName() %>"
			             ondblclick="code_CodeSelect(this, 'PolicyKindCodeForPerson','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'PolicyKindCodeForPerson','-1','always','none','post');">         
              </td>
              //mdify by wangli remark end 20050401      -->
              
              <td class="input">  
               <input type="hidden" name="personSerialNo" style="width:20px<%=compensatebackStyleP%>" <%=compensatebackReadOnlyP%> value="<%= personNo+1 %>"> 
                <input type="input" name="prpLpersonFeeTypeCode" class="codecode" style="width:60px<%=compensatebackStyleP%>" <%=compensatebackReadOnlyP%> value="<%= PrpLpersonDto2.getFeeTypeCode() %>"
            <%            if (compensatebackReadOnlyP.equals("")){%>
           
                      ondblclick= "code_CodeSelect(this,'PersonFeeType');"
                      onchange="code_CodeChange(this, 'PersonFeeType');"
                      onkeyup= "code_CodeSelect(this,'PersonFeeType');"  
                      onblur="feeTypeIsExist(this);"    
              <%}%>  
              >         
              </td>
              <td class="input">   
                  <input type="input" name="prpLpersonFeeTypeName" class="codename" style="width:130px<%=compensatebackStyleP%>" <%=compensatebackReadOnlyP%> value="<%= PrpLpersonDto2.getFeeTypeName() %>"
			         <%            if (compensatebackReadOnlyP.equals("")){%>
          
			             ondblclick="code_CodeSelect(this, 'PersonFeeType','-1','name','none','post');"
			             onchange="code_CodeChange(this, 'PersonFeeType','-1','name','none','post');"
			             onkeyup= "code_CodeSelect(this, 'PersonFeeType','-1','name','none','post');"
			             onblur="feeTypeIsExist(this);"    
			         <%}%>      
			             >         
              </td>
         <!--
              <td class="input">
                <input name="prpLpersonUnitLoss" title="单价" class="common" style="width:60px" value="<%= PrpLpersonDto2.getUnitLoss() %>">
              </td>
              <td class="input">
                <input name="prpLpersonQuantity" class="common" style="width:60px" value="<%= PrpLpersonDto2.getQuantity() %>">
              </td> 
           -->                     
              <td class="input">
                <input name="prpLpersonSumLoss" class="common" style="width:80px<%=compensatebackStyleP%>" <%=compensatebackReadOnlyP%> value="<%= sf.format(PrpLpersonDto2.getSumLoss()) %>" onBlur="return calSumPersonDefLoss(this)">
              </td> 
              <td class="input">
                <input name="prpLpersonSumReject" class="common" style="width:80px<%=compensatebackStyleP%>" <%=compensatebackReadOnlyP%>  value="<%= sf.format(PrpLpersonDto2.getSumReject()) %>" onBlur="return calSumPersonDefLoss(this);">
              </td>
              
                <%--//modify by wangli add start 20050401 --%>
                <td class="input"> 
                <input name="prpLpersonSumDefLoss"  class="common" style="width:80px<%=compensatebackStyleP%>" <%=compensatebackReadOnlyP%> value="<%= sf.format(PrpLpersonDto2.getSumDefLoss()) %>" onBlur="return calSumPersonDefLoss(this);">
                </td>
                <td class="input"> 
                <!--   <input type="hidden" name="prpLpersonSumDefLoss" class="common" style="width:60px" value="<%= PrpLpersonDto2.getSumDefLoss() %>"> -->
                <input name="prpLpersonRejectReason" class="common" style="width:60px<%=compensatebackStyleP%>" <%=compensatebackReadOnlyP%> value="<%= PrpLpersonDto2.getRejectReason() %>" >
               <%--//modify by wangli add end 20050401 --%>
                <input type="hidden" name="prpLpersonItemKindNo" value="<%= PrpLpersonDto2.getItemKindNo() %>"> 
                <input type="hidden" name="prpLpersonFamilyNo" value="<%= PrpLpersonDto2.getFamilyNo() %>"> 
                <input type="hidden" name="prpLpersonItemCode" value="<%= PrpLpersonDto2.getItemCode() %>"> 
                <input type="hidden" name="prpLpersonUnit" value="<%= PrpLpersonDto2.getUnit() %>"> 
                <input type="hidden" name="prpLpersonTimes" value="<%= PrpLpersonDto2.getTimes() %>"> 
            
                <input type="hidden" name="prpLpersonVeriQuantity" value="<%= PrpLpersonDto2.getVeriQuantity() %>"> 
                <input type="hidden" name="prpLpersonVeriUnitLoss" value="<%= PrpLpersonDto2.getVeriUnitLoss() %>"> 
                <input type="hidden" name="prpLpersonVeriUnit" value="<%= PrpLpersonDto2.getVeriUnit() %>"> 
                <input type="hidden" name="prpLpersonVeriTimes" value="<%= PrpLpersonDto2.getVeriTimes() %>"> 
                <input type="hidden" name="prpLpersonVeriSumLoss" value="<%= PrpLpersonDto2.getVeriSumLoss() %>"> 
                <input type="hidden" name="prpLpersonVeriSumReject" value="<%= PrpLpersonDto2.getVeriSumReject() %>"> 
                <input type="hidden" name="prpLpersonVeriRejectReason" value="<%= PrpLpersonDto2.getVeriRejectReason() %>"> 
                <input type="hidden" name="prpLpersonVeriLossRate" value="<%= PrpLpersonDto2.getVeriLossRate() %>"> 
                <input type="hidden" name="prpLpersonVeriSumDefLoss" value="<%= PrpLpersonDto2.getVeriSumDefLoss() %>"> 
                <input type="hidden" name="prpLpersonVeriRemark" value="<%= PrpLpersonDto2.getVeriRemark() %>"> 
                <input type="hidden" name="prpLpersonCompensateBackFlag" value="<%= PrpLpersonDto2.getCompensateBackFlag() %>"> 
				<input type="hidden" name="CompensateBackFlag" value="<%= PrpLpersonDto2.getCompensateBackFlag() %>"> 
                <input type="hidden" name="prpLpersonFlag" value="<%= PrpLpersonDto2.getFlag() %>"> 
              </td>                                                                            
              <td class="input">
                <div align="center">
                  <input type=button name="buttonPersonFeeLossDelete"  class="smallbutton"  <%=compensatebackDiasableP%> onclick="deleteRowTable(this,'PersonFeeLoss',1,1)" value="-" readonly style="cursor: hand">
                </div>              
              </td>             
            </tr>
<%
              } else {
%>                    
            <tr>    
              <!-- //modify by wangli remark start 20050401 
              <td class="input">  
                <input type="hidden" name="personSerialNo" style="width:20px" value="<%= personNo+1 %>"> 
                <input type="input" name="prpLpersonKindCode" class="codecode" style="width:60px" value="<%= PrpLpersonDto2.getKindCode() %>"
                      ondblclick= "code_CodeSelect(this,'PolicyKindCodeForPerson');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCodeForPerson');">         
              </td>
              <td class="input">   
                  <input type="input" name="prpLpersonKindName" class="codename" style="width:80px" value="<%= PrpLpersonDto2.getKindName() %>"
			             ondblclick="code_CodeSelect(this, 'PolicyKindCodeForPerson','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'PolicyKindCodeForPerson','-1','always','none','post');">         
              </td>
               //modify by wangli add end 20050401 -->
              <td class="input">  
              <%-- //modify by wangli add start 20050401 --%>
              <input type="hidden" name="personSerialNo" style="width:20px" value="<%= personNo+1 %>"> 
               <%-- //modify by wangli add end 20050401 --%>
                <input type="input" name="prpLpersonFeeTypeCode" class="codecode" style="width:60px<%=compensatebackStyleP%>" <%=compensatebackReadOnlyP%> value="<%= PrpLpersonDto2.getFeeTypeCode() %>"
                    <%            if (compensatebackReadOnlyP.equals("")){%>
 
                      ondblclick= "code_CodeSelect(this,'PersonFeeType');"
                      onchange="code_CodeChange(this, 'PersonFeeType');"
                      onkeyup= "code_CodeSelect(this,'PersonFeeType');"
                      
                      <%}%>>         
              </td>
              <td class="input">   
                  <input type="input" name="prpLpersonFeeTypeName" class="codename" style="width:130px<%=compensatebackStyleP%>"  <%=compensatebackReadOnlyP%> value="<%= PrpLpersonDto2.getFeeTypeName() %>"
			                 <%            if (compensatebackReadOnlyP.equals("")){%>
 
			             ondblclick="code_CodeSelect(this, 'PersonFeeType','-1','always','none','post');"
			             onchange="code_CodeChange(this, 'PersonFeeType','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'PersonFeeType','-1','always','none','post');"
			             <%}%>
			             
			             >        
              </td>
            <!--
              <td class="input">
                <input name="prpLpersonUnitLoss" title="单价" class="common" style="width:60px" value="<%= PrpLpersonDto2.getUnitLoss() %>">
              </td>
              <td class="input">
                <input name="prpLpersonQuantity" class="common" style="width:60px" value="<%= PrpLpersonDto2.getQuantity() %>">
              </td>                     -->
              <td class="input">
                <input name="prpLpersonSumLoss" class="common" style="width:60px<%=compensatebackStyleP%>" <%=compensatebackReadOnlyP%> value="<%= PrpLpersonDto2.getSumLoss() %>" onBlur="return calSumPersonDefLoss(this);">
              </td>
              <td class="input">
                <input name="prpLpersonSumReject" class="common" style="width:60px<%=compensatebackStyleP%>" <%=compensatebackReadOnlyP%> value="<%= PrpLpersonDto2.getSumReject() %>" onBlur="return calSumPersonDefLoss(this);">
              </td>
             <%--//modify by wangli add start 20050401 --%>
             <td class="input"> 
              <input name="prpLpersonSumDefLoss" class="common" readonly="true" style="width:60px<%=compensatebackStyleP%>" <%=compensatebackReadOnlyP%> value="<%= PrpLpersonDto2.getSumDefLoss() %>" >
             </td>
               <td class="input"> 
               <input name="prpLpersonRejectReason" class="common" style="width:60px<%=compensatebackStyleP%>" <%=compensatebackReadOnlyP%> value="<%= PrpLpersonDto2.getRejectReason() %>" >
              <!-- <input name="prpLpersonSumDefLoss" class="common" style="width:60px" value="<%= PrpLpersonDto2.getSumDefLoss() %>"> -->
              <%--//modify by wangli add end 20050401 --%>
                <input type="hidden" name="prpLpersonItemKindNo" value="<%= PrpLpersonDto2.getItemKindNo() %>"> 
                <input type="hidden" name="prpLpersonFamilyNo" value="<%= PrpLpersonDto2.getFamilyNo() %>"> 
                <input type="hidden" name="prpLpersonItemCode" value="<%= PrpLpersonDto2.getItemCode() %>"> 
                <input type="hidden" name="prpLpersonUnit" value="<%= PrpLpersonDto2.getUnit() %>"> 
                <input type="hidden" name="prpLpersonTimes" value="<%= PrpLpersonDto2.getTimes() %>"> 
          
                <input type="hidden" name="prpLpersonVeriQuantity" value="<%= PrpLpersonDto2.getVeriQuantity() %>"> 
                <input type="hidden" name="prpLpersonVeriUnitLoss" value="<%= PrpLpersonDto2.getVeriUnitLoss() %>"> 
                <input type="hidden" name="prpLpersonVeriUnit" value="<%= PrpLpersonDto2.getVeriUnit() %>"> 
                <input type="hidden" name="prpLpersonVeriTimes" value="<%= PrpLpersonDto2.getVeriTimes() %>"> 
                <input type="hidden" name="prpLpersonVeriRejectReason" value="<%= PrpLpersonDto2.getVeriRejectReason() %>"> 
                <input type="hidden" name="prpLpersonVeriLossRate" value="<%= PrpLpersonDto2.getVeriLossRate() %>"> 
                <input type="hidden" name="prpLpersonVeriRemark" value="<%= PrpLpersonDto2.getVeriRemark() %>"> 
                <input type="hidden" name="prpLpersonFlag" value="<%= PrpLpersonDto2.getFlag() %>">
                <input type="hidden" name="prpLpersonCompensateBackFlag" value="<%= PrpLpersonDto2.getCompensateBackFlag() %>"> 
                <input type="hidden" name="CompensateBackFlag" value="<%= PrpLpersonDto2.getCompensateBackFlag() %>"> 
           
              </td>                                                                            
              <td class="input"> 
                <div align="center">
                  <input type=button name="buttonPersonFeeLossDelete" class="smallbutton"  <%=compensatebackDiasableP%>  onclick="deleteRowTable(this,'PersonFeeLoss',1,2)" value="-" readonly style="cursor: hand">
                </div>              
              </td>             
            </tr>
            
               <%-- //modify by hanliang add end 20051223 --%>
            <tr>   
              <td class="input" colspan="2">&nbsp;</td>
              <td class="input">
                <input name="prpLpersonVeriSumLoss" class="readonly" style="width:60px" value="<%= sf.format(PrpLpersonDto2.getVeriSumLoss()) %>" onBlur="return calSumPersonVeriDefLoss(this)">
              </td>
              <td class="input">
                <input name="prpLpersonVeriSumReject" class="readonly" style="width:60px" value="<%= sf.format(PrpLpersonDto2.getVeriSumReject()) %>" onBlur="return calSumPersonVeriDefLoss(this)">
              </td>
              <td class="input">
                <input name="prpLpersonVeriSumDefLoss" class="readonly" readonly="true" style="width:60px" value="<%= sf.format(PrpLpersonDto2.getVeriSumDefLoss()) %>">
              </td>                                                                            
              <td class="input">&nbsp;</td>             
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
                    </tr>  
         
                    <tr>
                      <td colspan="4">
                        <table class="common" style="width:100%"> 
                          <td class='title' colspan="1" width="30%">报损金额:<input class='readonly' readonly="true" style='width:80px' name='prpLpersonSumLossSum'>
                          </td>    
                          <td class='title' colspan="1" width="30%">剔除金额:<input class='readonly'  readonly="true" style='width:80px' name='prpLpersonSumRejectSum'>
                          </td>   
                          <td class='title' colspan="2" width="40%">定损金额:<input class='readonly'  readonly="true" style='width:80px' name='prpLpersonSumDefLossSum'>
                          </td>
                        </table>    
                      </td>  
                    </tr>  
                  </tbody> 
                </table>
              </td>
              <td class="input" style="width:4%">
                <div align="center">
                  <input type=button name="buttonPersonDelete"  class="smallbutton" onclick="deleteRow(this,'Person')" value="-" style="cursor: hand">
                </div>
              </td>                       
           </tr> 


<%
        personNo =   PrpLpersonDto1.getPersonNo();
        }
      }
    }
%>


         </tbody>
       </table>  
       
     </span>    
   </td>
 </tr> 
</table>
</span>  























