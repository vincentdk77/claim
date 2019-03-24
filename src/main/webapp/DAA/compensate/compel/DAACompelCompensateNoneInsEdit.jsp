<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<table class="common" align="center" >
<tr>
<td>

<input type="hidden" name="noDInsReplaceFlag" value="02">
<input type="hidden" name="noDInsKindCode" value="BZ">
<input type="hidden" name="noDInsCurrency" value="CNY">
  
<img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
     name="noneInsImg" onclick="showPage(this,spanNoneIns);">强制保险无保险代赔信息<br>

     <span  id="spanNoneIns" style="display">   
			<table  cellpadding="0" cellspacing="1" class="common" style="width:100%">                      
				<tr>
					<td colspan="5" class="common" style="width:100%" >
						<span style="display:none">
						  <table class="common" style="display:none" id="NoneInsCompelFee_Data" cellspacing="1" cellpadding="1">
							<tbody>
							  <tr>
								<td class="input"  style="width:16%">
								  <input type="hidden" name="NoneInsItemCode" class='codecode' 
									  ondblclick= "code_CodeSelect(this,'paidType');"
									  onchange=""
									  onkeyup= ""
									  onblur= "">
								  <input name="NoneInsItemName" class='codename'  value=""
									  ondblclick= "code_CodeSelect(this, 'paidType','-1','name','none','post');"
									  onchange=""
									  onkeyup= ""
									  onblur= "getQuota(this);">
								  <img src="/claim/images/bgMarkMustInput.jpg">
								</td>
								<td class="input"  style="width:12%">
								  <input type="text" name="NoInsVerifyPaid"  class="input" value="0" onblur= "setRealPaid(this);">
								  <img src="/claim/images/bgMarkMustInput.jpg">
								</td>
								<td class="input"  style="width:12%">
								  <input type="text" name="NoInsLimitPaid"  style="width:70%" value="0" class="readonly" readonly>								  
								</td>
								<td class="input"  style="width:20%">
								  <input type="text" name="NoInsRealPaid" style="width:70%"  class="readonly" readonly>
								  <img src="/claim/images/bgMarkMustInput.jpg">
								</td> 
									  
								<td class="input" style='width:4%'  align="center">
								  <input type=button name="buttonNoneInsDelete" class=smallbutton onclick="deleteRow(this,'NoneInsCompelFee');calCompelSumPropAndPerson();calSumDutyPaid();" value="-" style="cursor: hand">
								</td>
							  </tr>
							 </tbody>
						    </table>
						  </span>

						 <table  class="common" id="NoneInsCompelFee" cellspacing="1" cellpadding="1">
							<thead>
										<tr>
											<td class="centertitle" style="width:25%">损失项目</td>
											<td class="centertitle" style="width:25%">核定赔偿金</td>
											<td class="centertitle" style="width:20%">强制保险限额</td>
											<td class="centertitle" style="width:25%">赔款金额</td> 
										  
											<td class="centertitle" style="width:5%">操作</td>                                
											
										</tr>
									  </thead>
									  <tfoot>
										  <tr>
											 <td  colspan=4 >
									(按"+"号键增加损失部位信息，按"-"号键删除信息)</td>
											 <td class="title" align="right" style="width:4%">
											 <div align="center">
											 <input type="button" value="+" class=smallbutton onclick="insertRowTable('NoneInsCompelFee','NoneInsCompelFee_Data',this);" name="buttonNoneInsCompelInsert" style="cursor: hand">
											 </div>
											 </td>
										  </tr>
									   </tfoot>
							</tfoot>                           
					  <tbody>	
					
						<logic:notEmpty  name="prpLnoinsList" >
							<logic:iterate id="noinsList"  name="prpLnoinsList">
							<tr>
								<td class="input"  style="width:16%">
									<input type="hidden" name="NoneInsItemCode"  class="codecode"  value="<bean:write name='noinsList' property='paidType'/>"
									ondblclick= "code_CodeSelect(this,'paidType');">
									<input  name="NoneInsItemName"  class="codename"  value="<bean:write name='noinsList' property='paidName'/>"
									ondblclick= "code_CodeSelect(this, 'paidType','-1','name','none','post');"
									onblur= "getQuota(this);">
									<img src="/claim/images/bgMarkMustInput.jpg">
								</td>
								<td class="input"  style="width:12%">
									<input type="text" name="NoInsVerifyPaid"  class="input"  value="<bean:write name='noinsList' property='verifyPaid'/>">              
									<img src="/claim/images/bgMarkMustInput.jpg">
								</td>
								<td class="input"  style="width:12%">
									<input type="text" name="NoInsLimitPaid"  style="width:70%" class="readonly" readonly value="<bean:write name='noinsList' property='limitPaid'/>" >									
								</td> 
								<td class="input"  style="width:20%">
									<input type="text" name="NoInsRealPaid" style="width:70%" class="readonly" readonly value="<bean:write name='noinsList' property='realPaid'/>"   >
									<img src="/claim/images/bgMarkMustInput.jpg">
								</td>                 
								<td class="input" style='width:4%'  align="center">                <div>
									<input  type=button  name="buttonNoneInsDelete"  onclick="deleteRow(this,'NoneInsCompelFee');calCompelSumPropAndPerson();calSumDutyPaid();" class=smallbutton   value="-" >
									 </div>
								</td>
							</tr>             
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
