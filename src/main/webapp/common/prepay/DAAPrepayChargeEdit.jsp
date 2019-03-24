<%--
****************************************************************************
* DESC       ：添加费用赔款信息页面
* AUTHOR     ：liubvo
* CREATEDATE ： 2004-05-19
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
****************************************************************************
--%>
   <!--建立显示的录入条，可以收缩显示的-->

    <script language='javascript'>
   
      //在下面加入本页自定义的JavaScript方法
      function afterInsertCharge()
    {
        setPrpLpreChargeSerialNo();
    }
    
    /**
     * 删除本条AcciPerson之后的处理（可选方法）
     */
    function afterDeleteCharge(field)
    {
        setPrpLpreChargeSerialNo();
    }

    /**
     * 设置setPrpLpreChargeSerialNo
     */
    function setPrpLpreChargeSerialNo(){
        var count=getElementCount("prpLpreChargeSerialNo");
        for(var i=0;i<count;i++)
        {
            if(i!=0){
            	fm.prpLpreChargeSerialNo[i].value=i;
            }
        }
    }
      
     
    </script>
   <table class="common" align="center">
   <input type="hidden" name="policyno" value="<bean:write name='prpLprepayDto' property='policyNo' filter='true' />">
   <input type="hidden" name="damageStartDate" value="<bean:write name='prpLprepayDto' property='damageStartDate' filter='true' />"> 
    <!--表示显示多行的-->
    <tr>
      <td class="common" colspan="4" style="text-align:left">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="ChargeImg" onclick="showPage(this,spanCharge);">费用赔款信息<br>
        <span style="display:none">
          <table class="common" style="display:none" id="Charge_Data" cellspacing="1" cellpadding="0">
            <tbody>
              <tr>
                <td style="width:3%" class=common>
	               <div align="center">
	                 <input class="readonlyNo" readonly name="prpLpreChargeSerialNo" description="序号">
	               </div>
	            </td>
                <td class="input" style="width:6%">
                  <input name="prpLprechargeKindCode" class="codecode" style="width:100%" maxlength="3"
                    ondblclick="code_CodeSelect(this, 'PolicyKindCode','1','code','none','post');"
                    onchange="code_CodeChange(this, 'PolicyKindCode','1','code','none','post');"
                    onkeyup= "code_CodeSelect(this, 'PolicyKindCode','1','code','none','post');">
                    
                </td>
                <td class="input" style="width:20%">
                  <input name="prpLprechargeKindName" class="codename"
			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','none','post');"
			             onchange="code_CodeChange(this, 'PolicyKindCode','-1','name','none','post');"
			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','none','post');" >
			            
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLprechargeChargeCode" class="readonly" style="width:100%"
                    ondblclick="code_CodeSelect(this, 'ChargeCode2');"
                    onchange="code_CodeChange(this, 'ChargeCode2'); "
                    onkeyup= "code_CodeSelect(this, 'ChargeCode2'); "
                    >
                </td>
                <td class="input" style="width:20%">
                  <input name="prpLprechargeChargeName" class="codename" style="width:100%"
			             ondblclick="code_CodeSelect(this, 'ChargeCode2','-1','name','none','post');"
			             onchange="code_CodeChange(this, 'ChargeCode2','-1','name','none','post');"
			             onkeyup= "code_CodeSelect(this, 'ChargeCode2','-1','name','none','post');"
			             >
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLprechargeCurrency" class="readonly" style="width:100%" value="CNY">
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLprechargeChargeReport" class="input" style="width:100%" >
                </td>
                <!-- 
                <td class="input" style="width:16%">
                </td>
                -->
                <td class="input" style='width:4%'  align="left">
                <div>
                  <input type=button name="buttonChargeDelete"  class="smallbutton" onclick="deleteRow(this,'Charge');" value="-" style="cursor: hand;">
                </div>
                </td>
              </tr>

            </tbody>
          </table>
        </span>


        <span  id="spanCharge" style="display:none" cellspacing="1" cellpadding="0">
        <%-- 多行输入展现域 --%>
        <table class="common" cellpadding="5" cellspacing="1" id="Charge" >
          <thead>
            <tr>
            	<td class="centertitle" style="width:6%">序号</td>
                <td class="centertitle" style="width:6%">险别代码</td>
                <td class="centertitle" style="width:20%">险别名称</td>
                <td class="centertitle"  style="width:10%">费用代码</td>
                <td class="centertitle"  style="width:20%">费用名称</td>
                <td class="centertitle"  style="width:10%">币别</td>
                <td class="centertitle"  style="width:10%">费用金额</td>
                <td class="centertitle" style="width:4%" >&nbsp;</td>
            </tr>
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan=7 >(按"+"号键增加费用赔款信息，按"-"号键删除信息)</td>
                 <td class="title" align="right" style="width:4%">
                 <div align="center">
                 <input type="button" value="+" class=smallbutton onclick="insertRow('Charge');" name="buttonDriverInsert" style="cursor: hand"  >
                 </div>
                 </td>
              </tr>
           </tfoot>
          </tfoot>
          <tbody>
 <logic:notEmpty  name="prpLpreChargeDto"  property="prpLpreChargeList">
<logic:iterate id="chargedtox" name="prpLpreChargeDto" property="prpLpreChargeList">
              <tr>
              	<td style="width:3%" class=common>
	                 <input class="readonlyNo" readonly name="prpLpreChargeSerialNo" description="序号" value="<bean:write name='chargedtox' property='serialNo'/>"
	            </td>
                <td class="input" style="width:6%">
                  <input name="prpLprechargeKindCode" class="codecode" style="width:100%" maxlength="3"  value="<bean:write name='chargedtox' property='kindCode'/>"
                    ondblclick="code_CodeSelect(this, 'PolicyKindCode','1','code','none','post');"
                    onchange="code_CodeChange(this, 'PolicyKindCode','1','code','none','post');"
                    onkeyup= "code_CodeSelect(this, 'PolicyKindCode','1','code','none','post');">
                   
                </td>
                <td class="input" style="width:20%">
                  <input name="prpLprechargeKindName" class="codename"  value="<bean:write name='chargedtox' property='kindName'/>"
			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','none','post');"
			             onchange="code_CodeChange(this, 'PolicyKindCode','-1','name','none','post');"
			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','none','post');">
			             
                </td>
                <td class="input" style="width:10%">
                  <input  name="prpLprechargeChargeCode" class="readonly" style="width:100%" value="<bean:write name='chargedtox' property='chargeCode'/>"
                    ondblclick="code_CodeSelect(this, 'ChargeCode2');"
                    onchange="code_CodeChange(this, 'ChargeCode2');"
                    onkeyup= "code_CodeSelect(this, 'ChargeCode2');">
                </td>
                <td class="input" style="width:20%">
                  <input name="prpLprechargeChargeName" class="codename" style="width:100%" value="<bean:write name='chargedtox' property='chargeEName'/>"
			             ondblclick="code_CodeSelect(this, 'ChargeCode2','-1','name','none','post');"
			             onchange="code_CodeChange(this, 'ChargeCode2','-1','name','none','post');"
			             onkeyup= "code_CodeSelect(this, 'ChargeCode2','-1','name','none','post');">
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLprechargeCurrency" class="readonly" style="width:100%" value="<bean:write name='chargedtox' property='currenCY'/>">
                </td>
                 <td class="input" style="width:10%">
                  <input name="prpLprechargeChargeReport" class="input" style="width:100%" value="<bean:write name='chargedtox' property='sumPrepaid'/>"  >
                </td>
                
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type=button name="buttonChargeDelete"  class=smallbutton onclick="deleteRow(this,'Charge');" value="-" style="cursor: hand"  >
                </div>
                </td>
              </tr>
      </logic:iterate>
      </logic:notEmpty>
          </tbody>
        </table>
        </span>
      </td>
    </tr>
  </table>








