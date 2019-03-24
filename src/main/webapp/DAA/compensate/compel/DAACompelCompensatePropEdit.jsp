<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>

<%
%>

<!--//==财产如下-->


<table  class="common" align="center"  id="tabProp">
<tr>
<td>
<img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
     name="PropPersonImg" onclick="showPage(this,spanPropPerson);">强制保险财产信息<br>
<span  id="spanPropPerson" style="display">   
<table  cellpadding="0" cellspacing="1" class="common" style="width:100%">                    
         <tr>
             <td rowspan="3" class='title' style="width:8%;display:none" align="center" >财产损失</td>
              <td colspan="4" class="common" style="width:100%" >
		        <span style="display:none">
		          <table class="common" style="display:none" id="PropCompelFee_Data" cellspacing="1" cellpadding="0">
		            <tbody>
		              <tr>
		                <td class="input"  style="width:18%">
				          <input type="hidden" name="propSerialNo"  class="input" >                
		                  <input type="text" name="propLicenseNo"  class="input" >
		                </td>
		                <td class="input"  style="width:18%">
		                  <input type="text" name="propName"  class="input" value="车辆">
		                </td>
		                <td class="input"  style="width:18%">
		                <input type="hidden" name="propFeeTypeCode" class='codecode' style="width:30%"
		                  ondblclick= "code_CodeSelect(this,'PropertyFeeType');"
		                  onchange="code_CodeChange(this, 'PropertyFeeType');"
		                  onkeyup= "code_CodeSelect(this,'PropertyFeeType');"
		                  onblur= "code_CodeChange(this,'PropertyFeeType',1);">
		                <input name="propFeeTypeName" class='codename' style="width:98%" value=""
		                  ondblclick= "code_CodeSelect(this, 'PropertyFeeType','-1','name','none','post');"
		                  onchange="code_CodeChange(this, 'PropertyFeeType','-1','name','none','post');"
		                  onkeyup= "code_CodeSelect(this, 'PropertyFeeType','-1','name','none','post');"
		                  					>
		
		
		                  
		                </td>
		                <td class="input"  style="width:12%">
		                  <input type="text" name="propSumLoss"  class="input" onblur="checkBeyondQuotaForGuoYuan(this);calPropSumDefPay(this,'0');calCompelSumPropAndPerson(); calSumDutyPaid();">
		                </td>
		                <td class="input"  style="width:10%">
		                  <input type="text" name="propEliminate"  class="input" onblur="calPropSumDefPay(this,'1');calCompelSumPropAndPerson();calSumDutyPaid();">
		                </td> 
		                 <td class="input"  style="width:10%">
		                  <input type="text" name="propSumDefPay"  class="readonly" readonly="true" onchange="makeDisabledFalse(this);" onblur="calCompelSumPropAndPerson();calSumDutyPaid();">
		                </td>                
		                <td class="input" style='width:4%'  align="center">
		                <div>
		                  <input type=button name="buttonCertainLossExtDelete" class=smallbutton onclick="deleteRow(this,'PropCompelFee');calCompelSumPropAndPerson();calSumDutyPaid();" value="-" style="cursor: hand">
		                </div>
		                </td>
		              </tr>
		            </tbody>
		          </table>
		        </span>

                 <table  class="common" id="PropCompelFee" cellspacing="1" cellpadding="0">
                     <thead>
                      <tr>
                          <td class="centertitle" style="width:20%">车牌号码</td>
                          <td class="centertitle" style="width:20%">财物名称</td>
                          <td class="centertitle" style="width:20%">损失明细</td>
                          <td class="centertitle" style="width:15%">核定损失</td>
                          <td class="centertitle" style="width:10%">剔出金额</td>  
                          <td class="centertitle" style="width:10%">核定赔偿</td>                                
                          <td class="centertitle" style="width:5%">操作</td>                                
                          
                      </tr>
                    </thead>
                    <tfoot>
                        <tr>
                           <td  colspan=6 class="title">
						(按"+"号键增加损失部位信息，按"-"号键删除信息)</td>
                           <td class="title" align="right" style="width:4%">
                           <div align="center">
                           <input type="button" value="+" class=smallbutton onclick="insertRowTable('PropCompelFee','PropCompelFee_Data',this);" name="buttonPropCompelInsert" style="cursor: hand">
                           </div>
                           </td>
                        </tr>
                         </tfoot>                      
          <tbody>

<%          


%>    
          
		<logic:notEmpty  name="prpLlossDto"  property="prpLlossList">
		<logic:iterate id="prpLlossList1" name="prpLlossDto" property="prpLlossList">
		              <logic:equal name="prpLlossList1" property="kindCode" value="BZ">          
		              <tr>
		                <td class="input"  style="width:18%">
				    <input type="hidden" name="propSerialNo"  class="input" >
		                  <input type="text" name="propLicenseNo"  class="input"  value="<bean:write name='prpLlossList1' property='licenseNo'/>">
		                </td>
		                <td class="input"  style="width:18%">
		                  <input type="text" name="propName"  class="input"  value="<bean:write name='prpLlossList1' property='lossName'/>">
		                </td>
		                <td class="input"  style="width:18%">
		                  <input name="propFeeTypeCode"  class="input" type=hidden value="<bean:write name='prpLlossList1' property='feeTypeCode'/>">
		                  <input type="text" name="propFeeTypeName"  class="input"  value="<bean:write name='prpLlossList1' property='feeTypeName'/>">		                  
		                </td>
		                <td class="input"  style="width:12%">
		                  <input type="text" name="propSumLoss"  class="input"  value="<bean:write name='prpLlossList1' property='sumLoss'/>" onblur="checkBeyondQuotaForGuoYuan(this);calPropSumDefPay(this,'0');calCompelSumPropAndPerson();calSumDutyPaid();">
		                </td>
		                <td class="input"  style="width:10%">
		                  <input type="text" name="propEliminate"  class="input" value="<bean:write name='prpLlossList1' property='sumRest'/>" onblur="calPropSumDefPay(this,'1');calCompelSumPropAndPerson();calSumDutyPaid();">
		                </td> 
		                 <td class="input"  style="width:10%">
                                       <input type="text" name="propSumDefPay" readonly="true" class="readonly"  value="<bean:write name='prpLlossList1' property='sumDefPay'/>"   onchange="makeDisabledFalse(this);"  onblur="calCompelSumPropAndPerson();calSumDutyPaid();">
                                 </td>                 
		                <td class="input" style='width:4%'  align="center">                <div>
		                <input  type=button  name="buttonCertainLossExtDelete"  onclick="deleteRow(this,'PropCompelFee');calCompelSumPropAndPerson();calSumDutyPaid();"  class="smallbutton"   value="-" >
				 </div>
		                </td>
		              </tr>
		   </logic:equal>              
		      </logic:iterate>
		      </logic:notEmpty>          
 		 </tbody>
		</table>
  </td>
  </tr>
</table>
</span>
</td>
</tr>
</table>
