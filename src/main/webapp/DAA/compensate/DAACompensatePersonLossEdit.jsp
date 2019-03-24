<%--
****************************************************************************
* DESC       ：添加人员赔款费用信息页面
* AUTHOR     ：lixiang
* CREATEDATE ： 2004-06-01
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
****************************************************************************
--%>
<%@ page import="java.util.*"%>
  
   <!--建立显示的录入条，可以收缩显示的-->      
      <span style="display:none"> 
        <table class="common" style="display:none" id="PersonFeeLoss_Data" cellspacing="1" cellpadding="5">
          <tbody>   
            <tr>      
              <td class="inputsubsub">
                <input type="hidden" name="personLossSerialNo" style="width:20px">                         
                <input name="prpLpersonLossLiabDetailCode" class="codecode" style="width:25px" title="费用代码" 
                   ondblclick= " code_CodeSelect(this,'PropertyFeeType');"
                   onchange="code_CodeChange(this, 'PropertyFeeType');"
                   onkeyup= " code_CodeSelect(this,'PropertyFeeType');"
                   onblur="calculateFee(this);">                                             
                <input name="prpLpersonLossLiabDetailName" class="codename" style="width:65px" title="费用名称" 
                  ondblclick= "code_CodeSelect(this, 'PropertyFeeType','-1','name','none','post');"
                  onchange="code_CodeChange(this, 'PropertyFeeType','-1','name','none','post');"
                  onkeyup= " code_CodeSelect(this, 'PropertyFeeType','-1','name','none','post');"
                   onblur="calculateFee(this);">  
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonLossUnitAmount" class="common" style="width:65px" onchange="calSumLoss(this);">
              </td>  
              <td class="inputsubsub">
                <input type= "hidden" name="prpLpersonLossLossQuantity" class="common" style="width:65px" onchange="calSumLoss(this);">
              </td>         
                <input type="hidden" name="prpLpersonLossHospitalDays" onchange="calSumLoss(this);">
               
              <td class="inputsubsub">
                <input name="prpLpersonLossSumLoss" class="common" style="width:65px" onchange="calRealpay1(this);calLoss();">
              </td> 							     
              <td class="inputsubsub">
                <input name="prpLpersonLossClaimRate" class="common" style="width:65px" onchange="calRealpay1(this);">
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonLossSumRealPay" class="readonly" readonly style="width:65px"  onchange="return changePersonLossRealpay(this);">
                <input type="hidden" name="prpLpersonLossItemKindNo">       
                <input type="hidden" name="prpLpersonLossFamilyNo">          
                <input type="hidden" name="prpLpersonLossIdentifyNumber">   
                <input type="hidden" name="prpLpersonLossLiabCode">         
                <input type="hidden" name="prpLpersonLossLiabName">         
                <input type="hidden" name="prpLpersonLossJobCode">            
                <input type="hidden" name="prpLpersonLossJobName">          
                <input type="hidden" name="prpLpersonLossItemAddress">      
                <input type="hidden" name="prpLpersonLossUnit">             
                <input type="hidden" name="prpLpersonLossCurrency" value="CNY">         
                <input type="hidden" name="prpLpersonLossAmount">           
                <input type="hidden" name="prpLpersonLossCurrency1" value="CNY">        
                <input type="hidden" name="prpLpersonLossItemValue">        
                <input type="hidden" name="prpLpersonLossCurrency2" value="CNY">        
                <input type="hidden" name="prpLpersonLossSumRest">          
                <input type="hidden" name="prpLpersonLossDeductible">       
                <input type="hidden" name="prpLpersonLossCurrency4" value="CNY">        
                <input type="hidden" name="prpLpersonLossFlag"> 
              </td>                                                       
              <td class="inputsubsub">
                <div align="center">
                  <input type=button name="buttonPersonFeeLossDelete"  class="smallbutton" onclick="deleteRowTable(this,'PersonFeeLoss',1,1)" value="-" readonly style="cursor: hand">
                </div>              
              </td>             
            </tr>
          </tbody> 
        </table>
      </span>
       
      <table class="common" cellpadding="5" cellspacing="1" align="center">
      <!--表示显示多行的-->
        <tr >
          <td class="common" colspan="4">
            <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
                 name="PersonImg" onclick="showPage(this,spanPerson);changeCompensateFlag('1');">赔付人员信息<br>
            <span style="display:none"> 
              <table class="common" style="display:none" id="Person_Data" cellspacing="1" cellpadding="5">
                <tbody>  
                  <tr>
                    <td class="input" style="width:8%">
                       <div align="center">  
                    <input type="input" name="prpLpersonLossKindCode" class="codecode" style="width:60px" 
                          ondblclick= "code_CodeSelect(this,'PolicyKindCode');" 
                          onchange="code_CodeChange(this, 'PolicyKindCode');"
                          onkeyup= "code_CodeSelect(this,'PolicyKindCode');" 
                          onblur="getDeductibleRate(this,'PersonLoss');checkKindCode(this);"
                       >         
                    <input type="input" name="prpLpersonLossKindName" class="codename" style="width:60px" 
    			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','none','post');"
    			             onchange="code_CodeChange(this, 'PolicyKindCode','-1','name','none','post');"
    			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','none','post');"
                      onblur="getDeductibleRate(this,'PersonLoss');checkKindCode(this);" 
                      >                                    
                    <img src="/claim/images/bgMarkMustInput.jpg">     
                        <input type="hidden" name="prpLpersonLossSerialNo">
                       </div>
                   </td>
                   <td class="common" style="width:88%">
                   <table  cellpadding="0" cellspacing="1" class="common" style="width:100%">
                      <tbody> 
                          <tr>
                            <input type="hidden" name="prpLpersonLossPersonNo"> 
                            <td class="title"  style="width:15%">人员姓名：</td>
                            <td class="input" style="width:35%">
                              <input class='common' style="width:110" name="prpLpersonLossPersonName"
                              maxlength=20 description="人员姓名">                  
                              <img src="/claim/images/bgMarkMustInput.jpg">
                            </td>
                            <td class="title" style="width:15%">性别：</td>
                            <td class="input" style="width:35%">                                              
                              <select name="prpLpersonLossSex" class='common' style="width:110">   
                                 <option value="1">男</option>
                                 <option value="2">女</option>                        
                              </select>
                              <img src="/claim/images/bgMarkMustInput.jpg">
                            </td>
                          </tr>
                          <tr>
                            <td class="title">年龄：</td>
                            <td class="input">
                              <input class='common' name="prpLpersonLossAge"  style="width:110"
                                maxlength="3" description="年龄" onchange="checkInteger(this,1,120)">                      
                              <img src="/claim/images/bgMarkMustInput.jpg">
                            </td>
                            <td class="title">币别：</td>
                            <td class="input">
                              <input type="hidden" name="prpLpersonLossCurrency3"  value="CNY">
                              <input class='readonly' readonly name="prpLpersonLossCurrencyName3" value="人民币">
                            </td>
                          </tr> 
                                 
                          <tr>       
                            <td class='title'>责任比例：</td>   
                            <td class='input'>                                    
                              <input class='common' name="prpLpersonLossIndemnityDutyRate" style="width:120px"  onChange="checkKindCode(this);calRealpay2(this);">%
                            </td>
                            <td class='title'>免赔率：</td> 
                            <td class='input'>
                              <input class='common' style='width:110px' name="prpLpersonLossDeductibleRate"  onChange="checkKindCode(this);calRealpay2(this);">%
                            </td>  
                          </tr>    
                                                  
                          <tr>                               
                            <td class='title'>号牌号码：</td>
                            <td class="input">       
                               <%
              		                Collection collection = (Collection)request.getAttribute("licenseNoList"); 
              		                Iterator iteratorLicenseNo1 = collection.iterator(); 
              		              %>
                                <select name="prpLpersonLossFamilyName" style="width:100px" onchange="calRealpay2(this);">
                                <%
                                  while (iteratorLicenseNo1.hasNext()){
                                  PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)iteratorLicenseNo1.next();
                                %>
                                  <option value="<%= prpLthirdPartyDto.getLicenseNo() %>"><%= prpLthirdPartyDto.getLicenseNo() %></option>
                                 <%
                                   }
                                 %> 
                                </select>               
                              <img src="/claim/images/bgMarkMustInput.jpg">  
                            </td> 
                            <td class='title'>赔付合计：</td>
                            <td class='input'>                                   
                              <input class='readonly' style='width:110' readonly name="prpLpersonLossSumRealPay1">
                            </td> 
                          </tr>
                          
                          <tr>
                            <td colspan="4">
                              <span  id="spanPersonFeeLoss" >
                              <%-- 多行输入展现域 --%>
                              <table id="PersonFeeLoss" name="PersonFeeLoss" class="common" cellpadding="5" cellspacing="1">
                                <thead>
                                  <tr>
                                    <td class="centertitle" colspan="9">
                                      费用信息
                                    </td>
                                  </tr>
                                  <tr>
                          	  		  <td class="centertitle">费用</td>
                          	  		  <td style="display:none"   class="centertitle">单价</td>  
                    	  		         <td style="display:none"   class="centertitle">数量</td>    			        			  
                          	  		  <td class="centertitle">核损金额</td>
                          	  		  <td class="centertitle">赔偿比例%</td>
                          	  		  <td class="centertitle">赔付金额</td>    
                                    <td class="centertitle" style="width:3%">  </td>                                           
                                  </tr>   
                                </thead>
                                <tfoot> 
                                  <tr>
                                    <td class="titlesubsub" colspan="6" ></td>
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
                      </tbody> 
                    </table> 
                    
                 </td>
              <td class="input" style="width:4%">
                <div align="center">
                  <input type=button name="buttonPersonDelete" class=smallbutton onclick="deleteRow(this,'Person')" value="-" style="cursor: hand">
                </div>
              </td>                       
           </tr> 
         </tbody>
       </table>
     </span>
          
     <span  id="spanPerson" style="display:none">
       <%-- 多行输入展现域 --%>
       <table id="person" class="common" align="center" cellspacing="1" cellpadding="5">
         <thead>
           <tr>
             <td class="title" style="width:4%">险别</td>
             <td class="title" style="width:96%" >内容</td>
           </tr> 
         </thead>
         <tfoot>
           <tr>
             
             <td class="title" align="right" colspan=2>
               <div align="center">
                 <input type="button" value="+" class=smallbutton onclick="insertRow('person')" name="buttonPersonInsert" style="cursor: hand">
               </div>
             </td>
           </tr>
         </tfoot> 
         <tbody>
         
         

<%
    
    int personNo = 0;
    String kindCode = "";
    int personSerialNo = 1;
    PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto)request.getAttribute("prpLpersonLossDto");
    if(prpLpersonLossDto.getPrpLpersonLossList()!=null){
      Iterator iterator = prpLpersonLossDto.getPrpLpersonLossList().iterator();
      while(iterator.hasNext()){ 
        PrpLpersonLossDto prpLpersonLossDto1 =  (PrpLpersonLossDto)iterator.next();
          if(!(prpLpersonLossDto1.getPersonNo() == personNo)||!prpLpersonLossDto1.getKindCode().equals(kindCode)){ 
          //if(!prpLpersonLossDto1.getKindCode().equals(kindCode)){  
%>                      
         
           <tr>
          <td class="input" style="width:8%"> 
             <div align="center">  
              <input type="input" name="prpLpersonLossKindCode" class="codecode" style="width:60px" value="<%= prpLpersonLossDto1.getKindCode() %>"
                    ondblclick= "code_CodeSelect(this,'PolicyKindCode');"
                    onchange="code_CodeChange(this, 'PolicyKindCode');"
                    onkeyup= "code_CodeSelect(this,'PolicyKindCode');" 
                    onblur="getDeductibleRate(this,'PersonLoss');checkKindCode(this);" 
                 >         
              <input type="input" name="prpLpersonLossKindName" class="codename" style="width:60px" value="<%= prpLpersonLossDto1.getKindName() %>"
		             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','none','post');"
		             onchange="code_CodeChange(this, 'PolicyKindCode','-1','name','none','post');"
		             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','none','post');"
                onblur="getDeductibleRate(this,'PersonLoss');checkKindCode(this);" 
                >                                    
              <img src="/claim/images/bgMarkMustInput.jpg">     
               <input type="hidden" name="prpLpersonLossSerialNo" value="<%= personSerialNo %>">
             </div>
         </td>
         <td class="common" style="width:88%">
         <table  cellpadding="5" cellspacing="1" class="common" style="width:100%">
            <tbody> 
                <tr>
                  <input type="hidden" name="prpLpersonLossPersonNo" value="<%= prpLpersonLossDto1.getPersonNo() %>"> 
                  <td class="title"  style="width:15%">人员姓名：</td>
                  <td class="input" style="width:35%">
                    <input class='common' style="width:110" name="prpLpersonLossPersonName" value="<%= prpLpersonLossDto1.getPersonName() %>">                  
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                  <td class="title" style="width:15%">性别：</td>
                  <td class="input" style="width:35%">                                              
                    <select name="prpLpersonLossSex" class='common' style="width:110">   
                       <option value="1" <%= prpLpersonLossDto1.getSex().trim().equals("1") ? "selected":"" %>>男</option>
                       <option value="2" <%= prpLpersonLossDto1.getSex().trim().equals("2") ? "selected":"" %>>女</option>                       
                    </select>  
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                </tr>
                <tr>
                  <td class="title">年龄：</td>
                  <td class="input">
                    <input class='common' name="prpLpersonLossAge"  style="width:110"  value="<%= prpLpersonLossDto1.getAge() %>"
                      maxlength="3" description="年龄" onchange="checkInteger(this,1,120)">                      
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                  <td class="title">币别：</td>
                  <td class="input">
                    <input type="hidden" name="prpLpersonLossCurrency3"  value="CNY">
                    <input class='readonly' readonly name="prpLpersonLossCurrencyName3" value="人民币">
                  </td>
                </tr>     
                         
                <tr>      
                  <td class='title'>责任比例：</td>
                  <td class='input'>                                    
                    <input class='common' name="prpLpersonLossIndemnityDutyRate" style="width:120px"  onChange="checkKindCode(this);calRealpay2(this);" value="<%= prpLpersonLossDto1.getIndemnityDutyRate() %>">%
                  </td>
                  <td class='title'>免赔率：</td> 
                  <td class='input'>
                    <input class='common' style='width:110px' name="prpLpersonLossDeductibleRate"  onChange="checkKindCode(this);calRealpay2(this);" value="<%= prpLpersonLossDto1.getDeductibleRate() %>">%
                  </td>  
                </tr>  
                            
                <tr>                               
                  <td class='title'>号牌号码：</td> 
                  <td class="input">       
                   <%
  		                Iterator iteratorLicenseNo2 = collection.iterator(); 
  		              %>
                    <select name="prpLpersonLossFamilyName" style="width:100px"  onchange="calRealpay2(this);"> 
                    <%
                      while (iteratorLicenseNo2.hasNext()){ 
                      PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)iteratorLicenseNo2.next();
                    %>
                      <option value="<%= prpLthirdPartyDto.getLicenseNo() %>" <%= ((prpLpersonLossDto1.getFamilyName().trim().equals(prpLthirdPartyDto.getLicenseNo().trim())) ? "selected" : "") %>><%= prpLthirdPartyDto.getLicenseNo() %></option>
                     <%
                       }
                     %>  
                    </select>                                  
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                  <td class='title'>赔付合计：</td>
                  <td class='input'>                                   
                    <input class='readonly' style='width:110' readonly name="prpLpersonLossSumRealPay1" value="<%= prpLpersonLossDto1.getSumRealPay1() %>">
                  </td> 
                </tr>
                 
                <tr>
                        <td colspan="4">
                          <span  id="spanPersonFeeLoss" >
                          <%-- 多行输入展现域 --%>
                          <table id="PersonFeeLoss" name="PersonFeeLoss" class="common"  cellspacing="1" cellpadding="5">
                            <thead>
                              <tr>
                                <td class="centertitle" colspan="9">
                                  费用信息
                                </td>
                              </tr> 
                              <tr>   
                      	  		  <td class="centertitle">费用</td>
                      	  		  <td class="centertitle">单价</td>
                      	  		  <td class="centertitle">数量</td>       			        			  
                      	  		  <td class="centertitle">核损金额</td>
                      	  		  <td class="centertitle">赔偿比例%</td>
                      	  		  <td class="centertitle">赔付金额</td>    
                                <td class="centertitle" style="width:3%">  </td>                                           
                              </tr>  
                            </thead> 
                            <tfoot> 
                              <tr>
                                <td class="titlesubsub" colspan="6" ></td>
                                <td class="title" align="right" >
                                  <div align="center">
                                    <input type="button" value="+" class=smallbutton onclick="insertRowTable('PersonFeeLoss','PersonFeeLoss_Data',this);" name="buttonPersonFeeLossInsert" readonly style="cursor: hand">
                                  </div>
                                </td>
                              </tr>
                            </tfoot> 
                             
                            <tbody>
 <%
System.out.println("------personNo-----"+personNo+"|"+kindCode);    
   Iterator iterator1 = prpLpersonLossDto.getPrpLpersonLossList().iterator();
      while(iterator1.hasNext()){ 
        PrpLpersonLossDto PrpLpersonLossDto2 =  (PrpLpersonLossDto)iterator1.next();
        if(PrpLpersonLossDto2.getPersonNo() == prpLpersonLossDto1.getPersonNo()&&PrpLpersonLossDto2.getKindCode().equals(prpLpersonLossDto1.getKindCode())){ 

%>                        
                              <tr>   
                                  <td class="inputsubsub"> 
                                    <input type="hidden" name="personLossSerialNo" style="width:20px" value="<%= personSerialNo %>">                         
                                    <input name="prpLpersonLossLiabDetailCode" class="codecode" style="width:25px" title="费用代码"  value="<%= PrpLpersonLossDto2.getLiabDetailCode() %>"
                                       ondblclick= " code_CodeSelect(this,'PropertyFeeType');"
                                       onchange="code_CodeChange(this, 'PropertyFeeType');"
                                       onkeyup= " code_CodeSelect(this,'PropertyFeeType');"
                                       onblur="calculateFee(this);">  
                                    <input name="prpLpersonLossLiabDetailName" class="codename" style="width:65px" title="费用名称"  value="<%= PrpLpersonLossDto2.getLiabDetailName() %>"
                                      ondblclick= "code_CodeSelect(this, 'PropertyFeeType','-1','name','none','post');"
                                      onchange="code_CodeChange(this, 'PropertyFeeType','-1','name','none','post');"
                                      onkeyup= " code_CodeSelect(this, 'PropertyFeeType','-1','name','none','post');"
                                      onblur="calculateFee(this);">   
                                  </td> 
                                  <td class="inputsubsub">   
                                    <input name="prpLpersonLossUnitAmount" class="common" style="width:65px" value="<%= PrpLpersonLossDto2.getUnitAmount() %>" onchange="calSumLoss(this);">
                                  </td> 
                                  <td class="inputsubsub">
                                    <input type="hidden" name="prpLpersonLossLossQuantity" class="common" style="width:65px" value="<%= PrpLpersonLossDto2.getLossQuantity() %>" onchange="calSumLoss(this);">
                                  </td>       
                                    <input type="hidden" name="prpLpersonLossHospitalDays" value="<%= PrpLpersonLossDto2.getHospitalDays() %>" onchange="calSumLoss(this);">
                                            
                                  <td class="inputsubsub"> 
                                    <input name="prpLpersonLossSumLoss" class="common" style="width:65px" value="<%= PrpLpersonLossDto2.getSumLoss() %>"  onchange="calRealpay1(this);calLoss();">
                                  </td>
                                  <td class="inputsubsub"> 
                                    <input name="prpLpersonLossClaimRate" class="common" style="width:65px" value="<%= PrpLpersonLossDto2.getClaimRate() %>"  onchange="calRealpay1(this);">
                                  </td>
                                  <td class="inputsubsub">
                                    <input name="prpLpersonLossSumRealPay" class="readonly" readonly style="width:65px" value="<%= PrpLpersonLossDto2.getSumRealPay() %>" onchange="return changePersonLossRealpay(this);">
                                    <input type="hidden" name="prpLpersonLossItemKindNo" value="<%= PrpLpersonLossDto2.getItemKindNo() %>">       
                                    <input type="hidden" name="prpLpersonLossFamilyNo" value="<%= PrpLpersonLossDto2.getFamilyNo() %>">         
                                    <input type="hidden" name="prpLpersonLossIdentifyNumber" value="<%= PrpLpersonLossDto2.getIdentifyNumber() %>">   
                                    <input type="hidden" name="prpLpersonLossLiabCode" value="<%= PrpLpersonLossDto2.getLiabCode() %>">         
                                    <input type="hidden" name="prpLpersonLossLiabName" value="<%= PrpLpersonLossDto2.getLiabName() %>">         
                                    <input type="hidden" name="prpLpersonLossJobCode" value="<%= PrpLpersonLossDto2.getJobCode() %>">          
                                    <input type="hidden" name="prpLpersonLossJobName" value="<%= PrpLpersonLossDto2.getJobName() %>">          
                                    <input type="hidden" name="prpLpersonLossItemAddress" value="<%= PrpLpersonLossDto2.getItemAddress() %>">      
                                    <input type="hidden" name="prpLpersonLossUnit" value="<%= PrpLpersonLossDto2.getUnit() %>">             
                                    <input type="hidden" name="prpLpersonLossCurrency" value="CNY">         
                                    <input type="hidden" name="prpLpersonLossAmount" value="<%= PrpLpersonLossDto2.getAmount() %>">           
                                    <input type="hidden" name="prpLpersonLossCurrency1" value="CNY">        
                                    <input type="hidden" name="prpLpersonLossItemValue" value="<%= PrpLpersonLossDto2.getItemValue() %>">        
                                    <input type="hidden" name="prpLpersonLossCurrency2" value="CNY">        
                                    <input type="hidden" name="prpLpersonLossSumRest" value="<%= PrpLpersonLossDto2.getSumRest() %>">          
                                    <input type="hidden" name="prpLpersonLossDeductible" value="<%= PrpLpersonLossDto2.getDeductible() %>">       
                                    <input type="hidden" name="prpLpersonLossCurrency4" value="CNY">        
                                    <input type="hidden" name="prpLpersonLossFlag" value="<%= PrpLpersonLossDto2.getFlag() %>">             
                                                        
                                  </td>                                                       
                                  <td class="inputsubsub">
                                    <div align="center">
                                      <input type=button name="buttonPersonFeeLossDelete"  class=smallbutton onclick="deleteRowTable(this,'PersonFeeLoss',1,1)" value="-" readonly style="cursor: hand">
                                    </div>              
                                  </td>             
                                </tr> 
<%
    }
  }
%>                     
                              </tbody>
                            </table>  
                          </span>  
                        </td>
                      </tr>  
          
                    </tbody> 
                  </table>
                </td>
                <td class="title" style="width:4%">
                  <div align="center">
                    <input type=button name="buttonPersonDelete"  class="smallbutton" onclick="deleteRow(this,'Person')" value="-" style="cursor: hand">
                  </div>
                </td>                       
             </tr> 
<%
        kindCode = prpLpersonLossDto1.getKindCode();      
        personNo =   prpLpersonLossDto1.getPersonNo();
        personSerialNo++;
        }
      }//while has next
    } 
%>         
           </tbody> 
         </table>   
       </span>    
     </td> 
   </tr> 
  </table>



