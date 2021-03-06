<%--
****************************************************************************
* DESC       ：添加驾驶员信息页面
* AUTHOR     ：weishixin
* CREATEDATE ： 2004-03-03
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 

   <!--建立显示的录入条，可以收缩显示的-->   
    <script language='javascript'>
      //在下面加入本页自定义的JavaScript方法
      /*
        插入一条新的之后的处理（可选方法）
      */
      function afterInsertProp()
      {
        setPrpLpropSerialNo();
      } 
     
      /* 
        删除本条WarnRegion之后的处理（可选方法）
      */
      function afterDeleteProp(field)
      {        
        setPrpLpropSerialNo();
      }
     
      /**
       * 设置setPrpLpropSerialNo
       */
      function setPrpLpropSerialNo(){
          var count=getElementCount("prpLpropSerialNo");
          for(var i=0;i<count;i++)
          {
              //alert("看看什么时候运行?count="+count+"  i="+i); 
              if(count!=1){
                fm.prpLpropSerialNo[i].value=i;
                //alert(i);
              }
          }
      }
    </script>    
		 
  <span  id="SpanProp" style="display:" >   
    <!--建立显示的录入条，可以收缩显示的-->   
    <table class="common" align="center" cellspacing="1" cellpadding="5"> 
    <!--表示显示多行的-->  
      <tr> 
        <td class="subformtitle" colspan="4">财产损失清单信息<br>
          <span  style="display:none">
            <table width="100%" cellpadding="0" cellspacing="1" class="common"  id="Prop_Data" style="display:none">
              <tbody> 
                <tr >
                  <td class="input" style="width:3%">
                   <div align="center">
                     <input class="readonlyNo" readonly name="prpLpropSerialNo" description="序号"> 
                   </div>
                  </td>
                  <td class="subformtitle"  >
                    <table  cellpadding="0" cellspacing="1" class="common">
                      <tr>
                        <td class="title" >险别：</td>
                        <td class="input" style='width:35%'>                          
                          <input type="input" name="prpLpropKindCode" class="codecode" style='width:60px'
                              ondblclick= "code_CodeSelect(this,'PolicyKindCodeForProp');"
                              onkeyup= "code_CodeSelect(this,'PolicyKindCodeForProp');">   
                          <input type="input" name="prpLpropKindName" class="codename" style='width:120px'
          			             ondblclick="code_CodeSelect(this, 'PolicyKindCodeForProp','-1','always','none','post');"
          			             onkeyup= "code_CodeSelect(this, 'PolicyKindCodeForProp','-1','always','none','post');">  
                              
                        </td>
                        <td class="title" >项目名称：</td>
                        <td class="input" >
                          <input type="input" name="prpLpropItemDetailName" class="readonly" readonly>
                        </td>
                      </tr>
                      <tr>
                        <td class="title">损失项目：</td>
                        <td class="input" colspan="3">
                          <input name="prpLpropLossItemName" class=common style='width:300px'>
                        </td>
                      </tr>  
                      
                      
                      <tr>
                        <td class="title">损失明细：</td> 
                        <td class="input">                       
                          <input type="input" name="prpLpropFeeTypeCode" class="codecode" style='width:60px'
                              ondblclick= "code_CodeSelect(this,'CompCode');"
                              onkeyup= "code_CodeSelect(this,'CompCode');">   
                          <input type="input" name="prpLpropFeeTypeName" class="codename" style='width:120px'
          			             ondblclick="code_CodeSelect(this, 'CompCode','-1','always','none','post');"
          			             onkeyup= "code_CodeSelect(this, 'CompCode','-1','always','none','post');">  
                                
                        </td>
                        <td class="title">币别：</td>   
                        <td class="input">
                          <input class="input" style='width:30px' name="prpLpropCurrency" value="CNY">
                          <input class="input"  name="prpLpropCurrencyName" value="人民币">
                          </td>
                      </tr> 
                      
                      <tr>
                        <td class="title">单价：</td>
                        <td class="input">
                          <input class="input"  name="prpLpropUnitPrice">
                        </td>
                        <td class="title">受损数量：</td>   
                        <td class="input">
                          <input class="input"  name="prpLpropLossQuantity">
                        </td>
                      </tr>   
                      
                      <tr>
                        <td class="title">折旧率：</td>
                        <td class="input" colspan="3">
                          <input class="input"  name="prpLpropDepreRate">%
                        </td>
                      </tr>  
                      
                      <tr>
                        <td class="title">核定损失：</td>
                        <td class="input">
                          <input class="input"  name="prpLpropSumLoss">
                        </td>
                        <td class="title">剔除金额：</td>   
                        <td class="input"><input class="input"  name="prpLpropSumReject"></td>
                      </tr>  
                      
                      <tr>
                        <td class="title">损失率：</td>
                        <td class="input">
                          <input class="input"  name="prpLpropLossRate">%
                        </td>
                        <td class="title">核定标的损失：</td>   
                        <td class="input"><input class="input"  name="prpLpropSumDefLoss"></td>
                      </tr>  
                      
                      <tr>
                        <td class="title">剔除原因：</td>
                        <td class="input" colspan="3">
                          <input class="input"  name="prpLpropRejectReason">
                        </td>
                      </tr>  
                      
                      <tr>
                        <td class="title">备注：</td>
                        <td class="input" colspan="3">
                          <input class="input"  name="prpLpropRemark">
                          <input type="hidden" name="prpLpropItemKindNo">
                          <input type="hidden" name="prpLpropFamilyNo">
                          <input type="hidden" name="prpLpropFamilyName">
                          <input type="hidden" name="prpLpropItemCode">
                          <input type="hidden" name="prpLpropLossItemCode">
                          <input type="hidden" name="prpLpropFeeTypeCode">
                          <input type="hidden" name="prpLpropFeeTypeName">
                          <input type="hidden" name="prpLpropUnit">
                          <input type="hidden" name="prpLpropBuyDate">
                          <input type="hidden" name="prpLpropVeriRemark">        
                          <input type="hidden" name="prpLpropVeriUnitPrice"> 
                          <input type="hidden" name="prpLpropVeriLossQuantity">
                          <input type="hidden" name="prpLpropVeriUnit">        
                          <input type="hidden" name="prpLpropVeriDepreRate">   
                          <input type="hidden" name="prpLpropVeriSumLoss">     
                          <input type="hidden" name="prpLpropVeriSumReject">   
                          <input type="hidden" name="prpLpropVeriRejectReason">
                          <input type="hidden" name="prpLpropVeriLossRate">    
                          <input type="hidden" name="prpLpropVeriSumDefLoss">  
                          <input type="hidden" name="prpLpropFlag">   
                        </td>
                      </tr>                    
                    </table>
                  </td>
                  <td class="input" style='width:4%'>
                    <div align="center">
                      <input type=button name="buttonPropDelete"  class=smallbutton onclick="deleteRow(this,'Prop')" value="-" style="cursor: hand">
                    </div>
                  </td>   
                </tr>
              </tbody> 
            </table>
            </span> 
  
  
          <span  id="spanProp" style="display:">
          <%-- 多行输入展现域 --%>
          <table  class="common" id="Prop" align="center" cellspacing="1" cellpadding="0">
            <thead>
              <tr>
                <td class="title" style="width:4%">序号</td>
                <td class="title" style="width:96%" colspan=2 >内容</td>
              </tr>                        
            </thead>
            <tfoot> 
              <tr>
                <td class="title" colspan=2 style="width:96%">(按"+"号键增加驾驶员信息，按"-"号键删除信息)</td>
                <td class="title" align="right" style="width:4%">
                  <div align="center">
                    <input type="button" value="+" class=smallbutton onclick="insertRow('Prop')" name="buttonDriverInsert" style="cursor: hand">
                  </div>
                </td>                                  
              </tr>
            </tfoot>  
            <tbody>
              <tr>
                <td colspan="3">
                    <table  cellpadding="0" cellspacing="1" class="common">
                      <tr>
                        <td class="title" style="width:5%">姓名</td>
                        <td class="input" style='width:10%'>
                          <input name="prpLdriverDriverName" class="input" style="width:95%" maxlength=20 description="驾驶员姓名">
                        </td>
                        <td class="title" style="width:10%">准驾车型</td>
                        <td class="input" style="width:17%">
                          <select name="prpLdriverDrivingCarType"  style="width:100%">
                            <option value="" selected >未指明
                            <option value="A">A</option>
                            <option value="B">B</option>
                            <option value="C">C</option>
                            <option value="D">其他</option>
                          </select>  
                        </td>
                        <td class="title" style="width:14%">颁证机关</td>
                        <td class="input" style='width:9%'>
                          <input name="prpLdriverAwardLicenseOrgan" class="common" style="width:95%" maxlength=20 description="颁证机关"> 
                        </td>        
                        <td class="title" style="width:12%">驾驶证号码</td>
                        <td class="input" style='width:23%'>
                          <input name="prpLdriverDrivingLicenseNo" class="common"  style="width:95%" maxlength=10 description="驾驶证号码">
                        </td>          
                      </tr> 
                    </table>
		              </td> 
                </tr>
            </tbody>
          </table>
       </span>
      </td>
   </tr>
</table>

  <table border="0" align="center" cellpadding="5" cellspacing="1"  class="title" width="100%">
    <tr>
      <td class='title' width="33%">受损金额合计:<input class='readonly' readonly="true" style='width:80px' name='prpLpropSumSumLoss'>
      </td>    
      <td class='title' width="33%">剔除金额合计:<input class='readonly'  readonly="true" style='width:80px' name='prpLpropSumSumReject'>
      </td>  
      <td class='title' width="33%">定损金额合计:<input class='readonly'  readonly="true" style='width:80px' name='prpLpropSumSumDefLoss'>
      </td>        
    </tr>
  </table>  
</span>