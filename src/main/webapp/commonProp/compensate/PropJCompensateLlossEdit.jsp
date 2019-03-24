<%--
****************************************************************************
* DESC       ：赔付标的信息页面
* AUTHOR     ：liubvo
* CREATEDATE ： 2004-10-18
* MODIFYLIST ：   Name       Date            Reason/Contents
*               qinyongli    2005-9-1        增加新增险别标的的判断
*               chenrd       20070718        家财团单改造
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.function.insutil.dto.domain.PrpDexchDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpCitemKindDto"%>
<%@page import="java.text.*"%>
<%@ page import="java.util.*"%>

    <%--多行输入自定义JavaScript方法域--%>
    <script language="javascript">
      //在下面加入本页自定义的JavaScript方法
 
        /*
        插入一条新的lLoss之后的处理（可选方法）
      */
      function afterInsertlLoss()
      {
        setPrpLlossDtoSerialNo();
        setPrpLlossDetailSerialNo();
      }
    
      /*
        删除本条WarnRegion之后的处理（可选方法）
      */
      function afterDeletelLoss(field)
      {
        
        setPrpLlossDtoSerialNo();
        setPrpLlossDetailSerialNo();
      }
  
          </script>   
   
   <table class="common" align="center">
    <!--表示显示多行的-->
    
    <%
      PrpDexchDto prpDexchDto;
      Collection prpdexchDtoList = (Collection)request.getAttribute("prpdexchDtoList");
      if(prpdexchDtoList!=null)
      {
          Iterator itprpdexch = prpdexchDtoList.iterator();
          while(itprpdexch.hasNext())
          {
              prpDexchDto =  (PrpDexchDto)itprpdexch.next();
              out.println("  <input type=\"hidden\" name=\"baseCurrency\""+
                " value=\""+prpDexchDto.getBaseCurrency()+"\""+"\">");
              out.println("  <input type=\"hidden\" name=\"exchCurrency\""+
                " value=\""+prpDexchDto.getExchCurrency()+"\""+"\">");
              out.println("  <input type=\"hidden\" name=\"exchRate\""+
                " value=\""+prpDexchDto.getExchRate()+"\""+"\">");                
          }
       }   
    %>
    
      <span style="display:none">
        <table class="common" style="display:none" id="LossDetail_Data" cellspacing="1" cellpadding="0">
         
          <tbody>  
            <tr>                  
              <td class="inputsubsub">
                 <input type='hidden' name="prpLlossDtoFeeTypeCode">
                 <input type='hidden' name="prpLlossDtoFeeTypeName">
                 <input type='hidden' name="prpLlossDtoLicenseNo">
                 <input type='hidden' name='prpLlossDtoItemAddress'> 
                 <input type='hidden' name='prpLlossDtoBuyDate' value="2004/12/12"> 
                 <input type='hidden' name='prpLlossDtoDepreRate'> 
                 <input type='hidden' name='prpLlossDtoCurrency1' value="<bean:write name='prpLcompensateDto' property='currency' />"> 
                 <input type='hidden' name='prpLlossDtoCurrency4' value="<bean:write name='prpLcompensateDto' property='currency' />"> 
                 
                 <input type='hidden' name='prpLlossDtoUnit'> 
                 <input type="hidden" name="prpLlossDtoLossQuantity">                  
                 <input type="hidden" name="prpLlossDtoUnitPrice">               
                 <input type="hidden" name="prpLlossDtoIndemnityDutyRate">  
                 <input type="hidden" name="prpLlossDtoCurrency2" value="<bean:write name='prpLcompensateDto' property='currency' />">  
                 <input type="hidden" name="prpLlossDtoCurrency2Name" value="<bean:write name='prpLcompensateDto' property='currencyName' />">
                 <input type="hidden" name="prpLlossDtoCurrency3" value="<bean:write name='prpLcompensateDto' property='currency' />">  
                 <input type="hidden" name="prpLlossDtoCurrency3Name" value="<bean:write name='prpLcompensateDto' property='currencyName' />">
                 <input type="hidden" name="prpLlossDtoCurrency" value="<bean:write name='prpLcompensateDto' property='currency' />">  
                 <input type="hidden" name="prpLlossDtoCurrencyName" value="<bean:write name='prpLcompensateDto' property='currencyName' />">        
                 <input type='hidden' name='LossItemCode'>                                                                   
                 <input type='hidden' name="LossItemName" class='readonly' readonly>
                 <input type="hidden" name="prpLlossDtoKindCode"  description="承保险别"   >                      
                 <input type="input" name="prpLlossDtoKindName" class="codename" style="width:80px"
  			             ondblclick="code_CodeSelect(this, 'PolicyKindCodeOfAgri','-1,1,6,7,8','always','none','post');"
  			           onkeyup= "code_CodeSelect(this, 'PolicyKindCodeOfAgri','-1,1,6,7,8','always','none','post');"> 
  			     <input type="hidden" name="prpLlossDtoItemKindNo">  
  			     <input type="hidden" name="prpLlossMaxPaid" > 
                 <input type="hidden" name="prpLlossHisPaid" >
              </td>
              <td class="inputsubsub"> 
                <input type="hidden" name="prpLlossDetailSerialNo" >    
                <input type="hidden" name="prpLlossSerialNo">                       
                <input type="hidden" name="prpLlossDtoItemCode">                                                   
                <input name="prpLlossDtoLossName" class="codename" style="width:80px"> 
              </td>
              <td class="inputsubsub">                        
                 <input name="prpLlossDtoAmount" class="common" style="width:60px" >
                 <input type="hidden"" name="prpLlossDtoAmountDisplay"> 
              </td>
              <td class="inputsubsub">
                 <input name="prpLlossDtoItemValue" class="common"  style="width:60px">
              </td>  
              <td class="inputsubsub">
                 <input name="prpLlossDtoSumLoss" class="common"  style="width:60px" onblur="calRealpay(this);calLoss();">
              </td> 
              <td class="inputsubsub">
                 <input name="prpLlossDtoSumRest" class="common"  style="width:60px" onblur="calRealpay(this);calLoss();">
              </td>                 
              <td class="inputsubsub">
                <input name="prpLlossDtoClaimRate"  class="common"  style="width:40px" onblur="calRealpay(this);calLoss();return isRightDutyPercent(this)">%
              </td>
              <td class="inputsubsub">
                <input name="prpLlossDtoDeductibleRate"  class="common"  style="width:40px" onblur="calRealpay(this);calLoss();">%
              </td>
              <td class="inputsubsub">
                <input name="prpLlossDtoDeductible" type='text' class="input" style="width:50px" onblur="calRealpay(this);calLoss();"> 
              </td>
              <td class="inputsubsub">
                <input name="prpLlossDtoSumRealPay" style="width:80px" class="input" onchange="calFund();calRealpay(this)">
              </td>
              <td class="inputsubsub">
                <div align="center">
                  <input type=button name="buttonLossDetailDelete"  onclick="deleteRowTable(this,'LossDetail',1,1),calFund();" value="-" readonly style="cursor: hand">
                </div>              
              </td>             
            </tr>
          </tbody>
        </table>
      </span>
      
        <span style="display:none"> 
          <table class="common" style="display:none" id="lLoss_Data" cellspacing="1" cellpadding="0">
            <tbody>
              <tr>
                <td class="input" style="width:4%">
                 <div align="center">
                   <input class="readonlyNo" readonly name="prpLlossDtoSerialNo" description="序号">
                 </div>
                </td>
                <td class="subformtitle"  style="width:92%">   
                    <table  cellpadding="0" cellspacing="1" class="common" style="width:100%">
                      <tr>
                        <td class="title" style="width:15%">被保险人：</td> 
                        <td class="input" style="width:35%" >
                        <input type = "hidden" name = "prpLclaimLossAcciCode">
                        <input type=text name="prpLlossDtoFamilyName" title="被保险人姓名"  style="width:180px"
                         class="codecode"  title="被保险人姓名"
                         ondblclick="code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');"
                         onkeyup= "code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');">
                         <input type= "hidden" name= "prpLclaimAcciPersonSex">
                         <input type= "hidden" name= "prpLclaimAcciPersonAge">
                         <input type= "hidden" name= "prpLclaimAcciPersonIdentifyNumber">
                         <input type= "hidden" name= "prpLlossDtoFamilyNo">
                        </td>
                        
                      </tr>
                      <tr>
                        <td height="1" bgcolor="#6C90DA" colspan='4'>
                          <span  id="spanLossDetail" >
                            <table id="LossDetail" name="LossDetail" class="common" align="center" cellspacing="1" cellpadding="0">
                              <thead>
                                <tr>
                                  <td class="subformtitle" colspan="11">赔付信息</td>
                                </tr>
                                <tr>
                      	  		  <td class="centertitle">承保险别</td>
                      	  		  <td class="centertitle">损失标的</td>
                      	  		  <td class="centertitle">保险金额</td>
                      	  		  <td class="centertitle">保险价值</td>
                      	  		  <td class="centertitle">核定损失</td>
                      	  		  <td class="centertitle">残值</td>
                      	  		  <td class="centertitle">赔付比例%</td>
                      	  		  <td class="centertitle">免赔率%</td> 
                      	  		  <td class="centertitle">免赔额</td>
                      	  		  <td class="centertitle">赔偿金额</td>  
                      	  		  <td class="centertitle" style="width:3%">  </td>                                           
                                </tr>  
                              </thead>
                              <tfoot>
                                <tr>
                                  <td class="titlesubsub" colspan="10" style="width:97%"></td>
                                  <td class="title" align="right" style="width:4%">
                                    <div align="center">
                                      <input type="button" value="+" onclick="insertRowTable('LossDetail','LossDetail_Data',this);setFlagDanger();" name="buttonLossDetailInsert" readonly style="cursor: hand">
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
                    </table>     
                </td>
                <td class="input" style="width:4%">
                  <div align="center">
                    <input type=button name="buttonlLossDelete"  class="smallbutton" onclick="deleteRow(this,'lLoss'),calFund();setFlagDanger();" value="-" style="cursor: hand">
                  </div>
                </td> 
              </tr>
            </tbody>
          </table>
        </span>   
    
   <tr>
      <td class="subformtitle" colspan="4" style="text-align:left">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="lLossImg" onclick="showPage(this,spanlLoss)">赔付标的信息<br>
        <span  id="spanlLoss" style="display:none">
        <%-- 多行输入展现域 --%>
        <table id="lLoss" class="common" align="center" cellspacing="1" cellpadding="0">
           <thead>
             <tr>
                <td class="title" style="width:4%">序号</td>
                <td class="title" style="width:96%" colspan=2 >内容</td>
             </tr> 
           </thead>
           <tfoot>
              <tr>
                 <td class="title" colspan=2 style="width:96%">(按"+"号键增加险别信息，按"-"号键删除信息)</td>
                 <td class="title" align="right" style="width:4%">
                 <div align="center">
                 <input type="button" value="+" onclick="insertRow('lLoss');setFlagDanger();" class="smallbutton" name="buttonlLossInsert" style="cursor: hand">
                 </div>
                 </td>
              </tr> 
           </tfoot> 
           <tbody>
  <%
     int index=1;
     int intLossCount =0;
  %>

<logic:notEmpty  name="prpLacciPersonDto"  property="prpLagriPersonList">
  <logic:iterate id="prpLagriPerson" name="prpLacciPersonDto" property="prpLagriPersonList">     
  <tr>
    <td class="input" style="width:4%">
     <div align="center">
       <input class="readonlyNo" readonly name="prpLlossDtoSerialNo" description="序号" value="<bean:write name='prpLagriPerson' property='serialNo' filter='true' />">
     </div>
    </td>
    <td class="subformtitle"  style="width:92%">
        <table  cellpadding="0" cellspacing="1" class="common" style="width:100%">
          <tr>
            <td class="title" style="width:15%">被保险人：</td> 
            <td class="input" style="width:35%" >
            <input type = "hidden" name = "prpLclaimLossAcciCode" value="<bean:write name='prpLagriPerson' property='acciCode' filter='true' />">
            <input type=text name="prpLlossDtoFamilyName" title="被保险人姓名"  style="width:180px"
             class="codecode"  title="被保险人姓名" value="<bean:write name='prpLagriPerson' property='acciName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');"
             onkeyup= "code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');">
             <input type= "hidden" name= "prpLclaimAcciPersonSex" value="<bean:write name='prpLagriPerson' property='sex' filter='true' />">
             <input type= "hidden" name= "prpLclaimAcciPersonAge" value="<bean:write name='prpLagriPerson' property='age' filter='true' />">
             <input type= "hidden" name= "prpLclaimAcciPersonIdentifyNumber" value="<bean:write name='prpLagriPerson' property='identifyNumber' filter='true' />">
             <input type= "hidden" name= "prpLlossDtoFamilyNo" value="<bean:write name='prpLagriPerson' property='familyNo' filter='true' />">
            </td>
           
          </tr>
          <tr>
            <td height="1" bgcolor="#6C90DA" colspan='4'>
              <span  id="spanLossDetail" >
                <table id="LossDetail" name="LossDetail" class="common" align="center" cellspacing="1" cellpadding="0">
                  <thead>
                    <tr>
                      <td class="subformtitle" colspan="11">赔付信息</td>
                    </tr>
                    <tr>
          	  		  <td class="centertitle">承保险别</td>
          	  		  <td class="centertitle">损失标的</td>
          	  		  <td class="centertitle">保险金额</td>
          	  		  <td class="centertitle">保险价值</td>
          	  		  <td class="centertitle">核定损失</td>
          	  		  <td class="centertitle">残值</td>
          	  		  <td class="centertitle">赔付比例%</td>
          	  		  <td class="centertitle">免赔率%</td> 
          	  		  <td class="centertitle">免赔额</td>
          	  		  <td class="centertitle">赔偿金额</td>  
          	  		  <td class="centertitle" style="width:3%">  </td>                                           
                    </tr>  
                  </thead>
                  <tfoot>
                    <tr>
                      <td class="titlesubsub" colspan="10" style="width:97%"></td>
                      <td class="title" align="right" style="width:4%">
                        <div align="center">
                          <input type="button" value="+" onclick="insertRowTable('LossDetail','LossDetail_Data',this);setFlagDanger();s" name="buttonLossDetailInsert" readonly style="cursor: hand">
                        </div>
                      </td>
                    </tr>
                  </tfoot>
                  <tbody>
   <%
   PrpLlossDto prpLlossDto = (PrpLlossDto)request.getAttribute("prpLlossDto");
   int intPersonNo =0;
   if(prpLlossDto.getPrpLlossList()!=null){
     Iterator iterator1 = prpLlossDto.getPrpLlossList().iterator();
     while(iterator1.hasNext())
     {
        PrpLlossDto prpLlossDto1 = (PrpLlossDto)iterator1.next();
        if(prpLlossDto1.getFlag()!=null&&!prpLlossDto1.getFlag().equals("")){
          intPersonNo=Integer.parseInt(prpLlossDto1.getFlag());
        }
        if(intPersonNo==index)
        {
          intLossCount++;
          %>
                  <tr>                  
                    <td class="inputsubsub">
                       <input type='hidden' name="prpLlossDtoLicenseNo" value = "<%= prpLlossDto1.getLicenseNo() %>">
                       <input type='hidden' name="prpLlossDtoFeeTypeCode" value = "<%= prpLlossDto1.getFeeTypeCode() %>">
                       <input type='hidden' name="prpLlossDtoFeeTypeName" value = "<%= prpLlossDto1.getFeeTypeName() %>">
                       <input type='hidden' name='prpLlossDtoItemAddress' value = "<%= prpLlossDto1.getItemAddress() %>"> 
                       <input type='hidden' name='prpLlossDtoBuyDate' value="2004/12/12"> 
                       <input type='hidden' name='prpLlossDtoDepreRate'value = "<%= prpLlossDto1.getDepreRate() %>"> 
                       <input type='hidden' name='prpLlossDtoCurrency1' value="<bean:write name='prpLcompensateDto' property='currency' />"> 
                       <input type='hidden' name='prpLlossDtoCurrency4' value="<bean:write name='prpLcompensateDto' property='currency' />"> 
                       
                       <input type='hidden' name='prpLlossDtoUnit' value = "<%= prpLlossDto1.getUnit()%>"> 
                       <input type="hidden" name="prpLlossDtoLossQuantity" value = "<%= prpLlossDto1.getLossQuantity() %>">                  
                       <input type="hidden" name="prpLlossDtoUnitPrice" value = "<%= prpLlossDto1.getUnitPrice() %>">               
                       <input type="hidden" name="prpLlossDtoIndemnityDutyRate" value = "<%= prpLlossDto1.getIndemnityDutyRate() %>">  
                       <input type="hidden" name="prpLlossDtoCurrency2" value="<bean:write name='prpLcompensateDto' property='currency' />">  
                       <input type="hidden" name="prpLlossDtoCurrency2Name" value="<bean:write name='prpLcompensateDto' property='currencyName' />">
                       <input type="hidden" name="prpLlossDtoCurrency3" value="<bean:write name='prpLcompensateDto' property='currency' />">  
                       <input type="hidden" name="prpLlossDtoCurrency3Name" value="<bean:write name='prpLcompensateDto' property='currencyName' />">
                       <input type="hidden" name="prpLlossDtoCurrency" value="<bean:write name='prpLcompensateDto' property='currency' />">  
                       <input type="hidden" name="prpLlossDtoCurrencyName" value="<bean:write name='prpLcompensateDto' property='currencyName' />">        
                       <input type='hidden' name='LossItemCode' >                                                                   
                       <input type='hidden' name="LossItemName" class='readonly' readonly >
                       <input  type="hidden" name="prpLlossDtoKindCode"  description="承保险别"  value = "<%= prpLlossDto1.getKindCode() %>" >                      
                       <input type="input" name="prpLlossDtoKindName" class="codename" style="width:80px"
  			                   ondblclick="code_CodeSelect(this, 'PolicyKindCodeOfAgri','-1,1,6,7,8','always','none','post');"
  			                   onkeyup= "code_CodeSelect(this, 'PolicyKindCodeOfAgri','-1,1,6,7,8','always','none','post');"
  			                   value = "<%= prpLlossDto1.getKindName() %>"> 
  			           <input type="hidden" name="prpLlossDtoItemKindNo" value = "<%= prpLlossDto1.getItemKindNo() %>">  
  			           <input type="hidden" name="prpLlossMaxPaid" > 
                       <input type="hidden" name="prpLlossHisPaid" >
                    </td>
                    <td class="inputsubsub"> 
                      <input type="hidden" name="prpLlossDetailSerialNo" value = "<%=intLossCount%>">  
                      <input type="hidden" name="prpLlossSerialNo" value = "<%= prpLlossDto1.getFlag() %>">                       
                      <input type="hidden" name="prpLlossDtoItemCode" value = "<%= prpLlossDto1.getItemCode() %>">                                                   
                      <input name="prpLlossDtoLossName" class="codename" style="width:80px" value = "<%= prpLlossDto1.getLossName() %>"> 
                    </td>
                    <td class="inputsubsub">                        
                       <input name="prpLlossDtoAmount" class="common" style="width:60px" value = "<%= prpLlossDto1.getAmount() %>">
                       <input type="hidden"" name="prpLlossDtoAmountDisplay"> 
                    </td>
                    <td class="inputsubsub">
                       <input name="prpLlossDtoItemValue" class="common"  style="width:60px" value = "<%= prpLlossDto1.getItemValue() %>">
                    </td>  
                    <td class="inputsubsub">
                       <input name="prpLlossDtoSumLoss" class="common"  style="width:60px" onblur="calRealpay(this);calLoss();" value = "<%= prpLlossDto1.getSumLoss() %>">
                    </td> 
                    <td class="inputsubsub">
                       <input name="prpLlossDtoSumRest" class="common"  style="width:60px" onblur="calRealpay(this);calLoss();" value = "<%= prpLlossDto1.getSumRest() %>">
                    </td>                 
                    <td class="inputsubsub">
                      <input name="prpLlossDtoClaimRate"  class="common"  style="width:40px" onblur="calRealpay(this);calLoss();return isRightDutyPercent(this)" value = "<%= prpLlossDto1.getClaimRate() %>">%
                    </td>
                    <td class="inputsubsub">
                      <input name="prpLlossDtoDeductibleRate"  class="common"  style="width:40px" onblur="calRealpay(this);calLoss();" value = "<%= prpLlossDto1.getDeductibleRate() %>">%
                    </td>
                    <td class="inputsubsub">
                      <input name="prpLlossDtoDeductible" type='text' class="input" style="width:50px" onblur="calRealpay(this);calLoss();" value = "<%= prpLlossDto1.getDeductible() %>"> 
                    </td>
                    <td class="inputsubsub">
                      <input name="prpLlossDtoSumRealPay" style="width:80px" class="input" onchange="calFund();calRealpay(this)" value = "<%= prpLlossDto1.getSumRealPay() %>">
                    </td>
                    <td class="inputsubsub">
                      <div align="center">
                        <input type=button name="buttonLossDetailDelete"  onclick="deleteRowTable(this,'LossDetail',1,1),calFund();" value="-" readonly style="cursor: hand" >
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
          </tr>
        </table>     
    </td>
    <td class="input" style="width:4%">
      <div align="center">
        <input type=button name="buttonlLossDelete"  class="smallbutton" onclick="deleteRow(this,'lLoss'),calFund();setFlagDanger();" value="-" style="cursor: hand">
      </div>
    </td> 
  </tr>
  <%    index++;%>             
  </logic:iterate>
</logic:notEmpty>
<%--农险团单理赔改造前旧数据展现处理--%>
<logic:empty name="prpLacciPersonDto"  property="prpLagriPersonList">
   <% int index24=0;%>
  <logic:notEmpty  name="prpLlossDto"  property="prpLlossList"> 
  <logic:iterate id="lloss" name="prpLlossDto" property="prpLlossList">
       
              <tr>
              <td class="input" style="width:4%">
                 <div align="center">
                   <input class="readonlyNo" readonly name="prpLlossDtoSerialNo" description="序号" value="<bean:write name='lloss' property='serialNo'/>">
                 </div>
             </td>
             <td class="subformtitle"  style="width:92%">                        
                 <table  cellpadding="0" cellspacing="1" class="common" style="width:100%">
                  
                    <!--是否超过保单中的限额标志域-->
                    <!-- input type="hidden" name="prpLlossDtoOverAmount" -->  
                    <input type='hidden' name="prpLlossDtoLicenseNo" value="<bean:write name='lloss' property='licenseNo'/>">
                    <input type='hidden' name='prpLlossDtoFamilyNo' value="<bean:write name='lloss' property='familyNo'/>"> 
                  
                    <input type='hidden' name="prpLlossDtoFeeTypeCode" value="<bean:write name='lloss' property='feeTypeCode'/>">
                    <input type='hidden' name="prpLlossDtoFeeTypeName" value="<bean:write name='lloss' property='feeTypeName'/>">
                                   
                    <input type='hidden' name='prpLlossDtoFamilyName' value="<bean:write name='lloss' property='familyName'/>"> 
                    <input type='hidden' name='prpLlossDtoItemAddress' value="<bean:write name='lloss' property='itemAddress'/>"> 
                    <input type='hidden' name='prpLlossDtoBuyDate' value="<bean:write name='lloss' property='buyDate'/>"> 
                    <input type='hidden' name='prpLlossDtoDepreRate' value="<bean:write name='lloss' property='depreRate'/>"> 
                    <input type='hidden' name='prpLlossDtoCurrency1' value="<bean:write name='lloss' property='currency1'/>"> 
                    <input type='hidden' name='prpLlossDtoCurrency4' value="<bean:write name='lloss' property='currency4'/>"> 
                    <input type='hidden' name='prpLlossDtoFlag' value="<bean:write name='lloss' property='flag'/>"> 
                    <input type='hidden' name='prpLlossDtoUnit' value="<bean:write name='lloss' property='unit'/>"> 
                    <input type="hidden" name="prpLlossDtoLossQuantity"   value="<bean:write name='lloss' property='lossQuantity'/>">                  
                    <input type="hidden" name="prpLlossDtoUnitPrice" value="<bean:write name='lloss' property='unitPrice'/>">               
                    <input type="hidden" name="prpLlossDtoIndemnityDutyRate" value="<bean:write name='lloss' property='indemnityDutyRate'/>">   
                      <tr>                             
                        <td class="title" style="width:15%">险别：</td> 
                        <td class="input" style="width:35%" colspan="3">
                          <input type="input" name=prpLlossDtoKindCode class="codecode" style="width:40" value="<bean:write name='lloss' property='kindCode'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyKindCode1');"
                            onkeyup= "code_CodeSelect(this, 'PolicyKindCode1');">                  
                          <input type="input" name=prpLlossDtoKindName class="codename" style="width:110" value="<bean:write name='lloss' property='kindName'/>"
        			             ondblclick="code_CodeSelect(this, 'PolicyKindCode1','-1','always','none','post');"
        			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode1','-1','always','none','post');"> 
                          <img src="/claim/images/bgMarkMustInput.jpg">                                                     
                          <input type='hidden' name='LossItemCode'>                                                                   
                          <input type='hidden' name="LossItemName" class='readonly' readonly>
                        </td>                
                      </tr>                         
                      <tr>                 
                        <td class="title" style="width:15%">损失标的：</td>                                                                   
                        <td class="input" style="width:85%" colspan="3">
                          <input type='input' name='prpLlossDtoItemCode' class="codecode" style="width:40"   value="<bean:write name='lloss' property='itemCode'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','1,2');"
                            onblur="checkRepeatItemCode(this);"
                            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','1,2');"> 
                          <input name="prpLlossDtoLossName" class="codename"  style="width:330px"  value="<bean:write name='lloss' property='lossName'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','-1,1','always','none','post');"
                            onblur="checkRepeatItemCode(this);"
        		    onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','-1,1','always','none','post');">  
	            		 <input type='hidden' name='prpLlossDtoItemKindNo' value="<bean:write name='lloss' property='itemKindNo'/>"> 
                        </td>                                  
                      </tr> 
                      <tr style="display:none">                             
                        <td class="title" style="width:15%">币别：</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency" class="codecode" style="width:30px" value="<bean:write name='lloss' property='currency'/>"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrencyName" class="codecode" style="width:90px" value="<bean:write name='lloss' property='currencyName'/>"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">             
                        </td>            
                      </tr>                        
                      <tr>                             
                        <td class="title" style="width:15%">保险金额：</td>
                        <td class="input" style="width:35%">
                            <input type="hidden" name="prpLlossDtoAmountDisplay" class='readonly' readonly value="<bean:write name='lloss' property='amount' format='##0.00'/>"> 
                             <input type="text" name="prpLlossDtoAmount" class='readonly' readonly value="<bean:write name='lloss' property='amount' format='##0.00'/>"> 
                        </td>                   
                        <td class="title" style="width:15%">保险价值：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoItemValue" class="common"  style="width:180px" value="<bean:write name='lloss' property='itemValue' format='##0.00'/>">
                        </td>                
                      </tr>   
                        
                      <tr>                             
                        <td class="title" style="width:15%">核定币别：</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency2" class="codecode" style="width:30px" value="<bean:write name='lloss' property='currency2'/>"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrency2Name" class="codecode" style="width:90px" value="<bean:write name='lloss' property='currency2Name'/>"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">                                                                         
                        </td>            
                      </tr>                                     
                      <tr>
                        <td class="title">核定损失：</td>
                        <td class="input">
                          <input name="prpLlossDtoSumLoss" class="common"  style="width:180px" value="<bean:write name='lloss' property='sumLoss' format='##0.00'/>"  onblur="calRealpay(this);calLoss();">
                        </td>
                        <td class="title">残值：</td>
                        <td class="input">
                          <input name="prpLlossDtoSumRest" class="common"  style="width:180px" value="<bean:write name='lloss' property='sumRest' format='##0.00'/>"  onblur="calRealpay(this);calLoss();">
                        </td>                  
                      </tr>                              
                      <tr>
                        <td class="title">赔付比例：</td> 
                        <td class="input">                          
                          <input name="prpLlossDtoClaimRate"  class="common"  style="width:180px" value="<bean:write name='lloss' property='claimRate' format='##0.0000'/>"  onblur="calRealpay(this);calLoss();">%
                        </td>
                        <td class="title">免赔率：</td>
                        <td class="input">
                          <input name="prpLlossDtoDeductibleRate"  class="common"  style="width:180px" value="<bean:write name='lloss' property='deductibleRate' format='##0.0000'/>"  onblur="calRealpay(this);calLoss();">%
                        </td>                  
                      </tr>
                      <tr>                             
                        <td class="title" style="width:15%">赔付币别：</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency3" class="codecode" style="width:30px" value="<bean:write name='lloss' property='currency3'/>"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrency3Name" class="codecode" style="width:90px" value="<bean:write name='lloss' property='currency3Name'/>"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">  
                        </td>            
                      </tr>      
                          
                      <tr>                             
                        <td class="title" style="width:15%">免赔额：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoDeductible" type='text' class="input" style="width:180px" value="<bean:write name='lloss' property='deductible' format='##0.00'/>"  onblur="calRealpay(this);calLoss();">                                                                            
                        </td>                   
                        <td class="title" style="width:15%">赔偿金额：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoSumRealPay" style="width:180px" class="input" value="<bean:write name='lloss' property='sumRealPay' format='##0.00'/>" onchange="calFund();calRealpay(this)">
                        </td>                 
                      </tr>
                      <!--add by zhulei 20050905 赔款标的间加一条分隔线-->
           <tr>
             <td height="1" bgcolor="#6C90DA" colspan='4'></td>
           </tr>
                   </table>               
               </td>
              <td class="input" style='width:4%'>
              <div align="center">
                <input type=button name="buttonlLossDelete"  class="smallbutton" onclick="deleteRow(this,'lLoss'),calFund();setFlagDanger();" value="-" style="cursor: hand">
              </div>
              </td> 
           </tr>
           
          
        <%    index24++;%>             
      </logic:iterate>
    </logic:notEmpty>   
</logic:empty>            
           </tbody>      
       </table>  
       </span>    
      </td>
    </tr>




