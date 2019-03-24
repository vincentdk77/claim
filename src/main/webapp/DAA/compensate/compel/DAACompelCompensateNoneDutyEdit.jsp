<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>

<table class="common" align="center" >
<tr>
<td>
<img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
     name="noneDutyImg" onclick="showPage(this,spanNoneDuty);">强制保险无责代赔信息<br>

     <span  id="spanNoneDuty" style="display">   
			<table  cellpadding="0" cellspacing="1" class="common" style="width:100%">                      
				<tr>
					<td colspan="7" class="common" style="width:100%" >
						<span style="display:none">
						  <table class="common" style="display:none" id="NoneDutyCompelFee_Data" cellspacing="1" cellpadding="1">
							<tbody>
							  <tr>
								<td class="input"  style="width:18%">           
								  <input type="text" name="noneDutyLicenseNo"  class="input" >
								  <img src="/claim/images/bgMarkMustInput.jpg">
								</td>
								<td class="input"  style="width:18%">
								  <input type="text" name="insuredName"  class="input" >
								</td>
								<td class="input"  style="width:12%">
								  <input type="text" name="noneDutyCertiNo"  class="input" >
								</td>
								<td class="input"  style="width:16%">
								  <input type="hidden" name="nodutyInsuredCompanyCode" class='codecode' 
									  ondblclick= "code_CodeSelect(this,'InsurerCompany');"
									  onchange=""
									  onkeyup= ""
									  onblur= "">
								  <input name="nodutyInsuredCompanyName" class='codename'  value=""
									  ondblclick= "code_CodeSelect(this, 'InsurerCompany','-1','name','none','post');"
									  onchange="code_CodeSelect(this, 'InsurerCompany','-1','name','none','post');"
									  onkeyup= "">
								  <img src="/claim/images/bgMarkMustInput.jpg">
								</td>
								
								<td class="input"  style="width:12%">
								  <input type="text" name="dutyPercent"  style="width:70%" class="input"
								  onblur="checkNodutyQuota(this);">%
								  <img src="/claim/images/bgMarkMustInput.jpg">
								</td>
								<td class="input"  style="width:20%">
								  <input type="text" name="noneDutyLoss" style="width:70%"  class="input" value="0"
								  onblur="checkNodutyQuota(this);">
								  <img src="/claim/images/bgMarkMustInput.jpg">
								</td> 
									  
								<td class="input" style='width:4%'  align="center">
								  <input type=button name="buttonNoneDutyDelete" class=smallbutton onclick="deleteRow(this,'NoneDutyCompelFee');calCompelSumPropAndPerson();calSumDutyPaid();" value="-" style="cursor: hand">
								</td>
								<input type="hidden" name="noDutyLimitPaid" value="">
							  </tr>
							 </tbody>
						    </table>
						  </span>

						 <table  class="common" id="NoneDutyCompelFee" cellspacing="1" cellpadding="1">
							<thead>
										<tr>
											<td class="centertitle" style="width:20%">车牌号码</td>
											<td class="centertitle" style="width:20%">被保险人名称</td>
											<td class="centertitle" style="width:15%">驾驶证号码</td>
											<td class="centertitle" style="width:20%">无责方交强险保险公司</td>
											<td class="centertitle" style="width:8%">责任比例</td>
											<td class="centertitle" style="width:12%">代赔金额</td>  
										  
											<td class="centertitle" style="width:5%">操作</td>                                
											
										</tr>
									  </thead>
									  <tfoot>
										  <tr>
											 <td  colspan=6 >
									(按"+"号键增加损失部位信息，按"-"号键删除信息)</td>
											 <td class="title" align="right" style="width:4%">
											 <div align="center">
											 <input type="button" value="+" class=smallbutton onclick="insertRowTable('NoneDutyCompelFee','NoneDutyCompelFee_Data',this);" name="buttonNoneDutyCompelInsert" style="cursor: hand">
											 </div>
											 </td>
										  </tr>
									   </tfoot>
							</tfoot>                           
					  <tbody>	
					
						<logic:notEmpty  name="prpLnodutyLossList" >
							<logic:iterate id="nodutyLossList"  name="prpLnodutyLossList">
							<tr>
								<td class="input"  style="width:18%">
									<input type="text" name="noneDutyLicenseNo"  class="input"  value="<bean:write name='nodutyLossList' property='licenseNo'/>">
									<img src="/claim/images/bgMarkMustInput.jpg">
								</td>
								<td class="input"  style="width:18%">
									<input type="text" name="insuredName"  class="input"  value="<bean:write name='nodutyLossList' property='insuredName'/>">
								</td>
								<td class="input"  style="width:12%">
									<input type="text" name="noneDutyCertiNo"  class="input"  value="<bean:write name='nodutyLossList' property='driverLicenseNo'/>">              
								</td>
								<td class="input"  style="width:16%">
									<input type="hidden" name="nodutyInsuredCompanyCode"  class="codecode"  value="<bean:write name='nodutyLossList' property='insuredCompanyCode'/>"
									ondblclick= "code_CodeSelect(this,'InsurerCompany');">
									<input  name="nodutyInsuredCompanyName"  class="codename"  value="<bean:write name='nodutyLossList' property='insuredCompanyName'/>"
									ondblclick= "code_CodeSelect(this, 'InsurerCompany','-1','name','none','post');">
									<img src="/claim/images/bgMarkMustInput.jpg">
								</td>
								<td class="input"  style="width:12%">
									<input type="text" name="dutyPercent"  style="width:70%" class="input" value="<bean:write name='nodutyLossList' property='dutyPercent'/>" 
									onblur="checkNodutyQuota(this);">%
									<img src="/claim/images/bgMarkMustInput.jpg">
								</td> 
								<td class="input"  style="width:20%">
									<input type="text" name="noneDutyLoss" style="width:70%" class="input"  value="<bean:write name='nodutyLossList' property='realPaid'/>"   
									onblur="checkNodutyQuota(this);">
									<img src="/claim/images/bgMarkMustInput.jpg">
								</td>                 
								<td class="input" style='width:4%'  align="center">                <div>
									<input  type=button  name="buttonNoneDutyDelete"  onclick="deleteRow(this,'NoneDutyCompelFee');calCompelSumPropAndPerson();calSumDutyPaid();" class=smallbutton   value="-" >
									 </div>
								</td>
								<input type="hidden" name="noDutyLimitPaid" value="">
							</tr>             
							</logic:iterate>
						</logic:notEmpty>   
					  
						</tbody>
					</table>
		</td>
	</tr>
	</table>
</span>

<input type="hidden" name="noDutyPaidType" value="noDuty">
<input type="hidden" name="noDutyPaidName" value="无责代赔">
<input type="hidden" name="noDutyReplaceFlag" value="01">
<input type="hidden" name="noDutyKindCode" value="BZ">
<input type="hidden" name="noDutyCurrency" value="CNY">
</td>
</tr>
</table>

