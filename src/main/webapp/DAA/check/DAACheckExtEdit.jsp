<%--
****************************************************************************
* DESC       ：4.3.10  查勘/代查勘扩展页面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-06-03
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>  
 
   <table class="common" align="center" width="100%"> 
    <tr>
      <td class="subformtitle" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="CheckLossTextImg" onclick="showPage(this,CheckLossText)">
             查勘扩展信息
        <br>
        <table class="common" align="center" id="CheckLossText" style="display:none">
          <tbody>
          
          <%//
          //modify by lixiang add 20050311 start
//reason:查勘扩展信息用颜色间隔区分，增加一个不确定选项,不能用-1,因为判断如果为-1，js不写值
          %>
              <tr class=listeven>
                <td align="left" colspan=4>1、保险车辆的车牌号码、发动机号、车架号码与保险单上所列是否相符
                  <input type="radio" name="CheckExt01" value="1">是
                  <input type="radio" name="CheckExt01" value="0">否
                  <input type="radio" name="CheckExt01" value="2">不确定
                  
                </td>
              </tr>
              <tr class="listodd">
                <td align="left" colspan=4>2、出险时间是否在保险有效期限内
                  <input type="radio" name="CheckExt02" value="1">是
                  <input type="radio" name="CheckExt02" value="0">否
                  <input type="radio" name="CheckExt02" value="2">不确定
                </td>
              </tr>
              <tr class=listeven>
                <td align="left" colspan=4>3、出险时间接近保险起讫期的，有无相应时间证明
                  <input type="radio" name="CheckExt03" value="1">     是
                  <input type="radio" name="CheckExt03" value="0">     否
                  <input type="radio" name="CheckExt03" value="2">不确定
                </td>
              </tr>
              <tr class="listodd">
                <td align="left" colspan=4>4、实际使用性质与保单上所注明的是否一致：
                  <input type="radio" name="CheckExt04" value="1">是
                  <input type="radio" name="CheckExt04" value="0">否
                  <input type="radio" name="CheckExt04" value="2">不确定
                </td>
              </tr>
              <tr class=listeven>
                <td align="left" colspan=4>5、保险车辆驾驶员情况与报案人所述是否一致:
                  <input type="radio" name="CheckExt05" value="1">是
                  <input type="radio" name="CheckExt05" value="0">否
                  <input type="radio" name="CheckExt05" value="2">不确定
                </td>
              </tr>
             <tr class="listodd">
               <td align="left" colspan=4>6、保险车辆驾驶员的驾驶证是否有效：
                 <input type="radio" name="CheckExt06" value="1">是
                 <input type="radio" name="CheckExt06" value="0">否
                 <input type="radio" name="CheckExt06" value="2">不确定
               </td>
             </tr>
             <tr class=listeven>
               <td align="left" colspan=4>7、保险车辆驾驶员准驾车型与实际驾驶车辆是否相符：
                 <input type="radio" name="CheckExt07" value="1">是
                 <input type="radio" name="CheckExt07" value="0">否
                 <input type="radio" name="CheckExt07" value="2">不确定
               </td>
             </tr>
             <tr class="listodd">
               <td align="left" colspan=4>8、使用各种专用机械车、特种车的人员是否有国家有关部门核发的有效操作证：
                 <input type="radio" name="CheckExt08" value="1">是
                 <input type="radio" name="CheckExt08" value="0">否
                 <input type="radio" name="CheckExt08" value="2">不确定
               </td>
             </tr>
             <tr class=listeven>
               <td align="left" colspan=4>9、驾驶营业性客车的驾驶员无国家有关行政管理部门核发的有效资格证书：
                 <input type="radio" name="CheckExt09" value="1">是
                 <input type="radio" name="CheckExt09" value="0">否
                 <input type="radio" name="CheckExt09" value="2">不确定
               </td>
             </tr>
             <tr class="listodd">
               <td align="left" colspan=4>10、保险车辆驾驶员是否为被保险人允许的驾驶员：
                 <input type="radio" name="CheckExt10" value="1">是
                 <input type="radio" name="CheckExt10" value="0">否
                 <input type="radio" name="CheckExt10" value="2">不确定
             </tr>
             <tr class=listeven>
               <td align="left" colspan=4>11、保险车辆驾驶员是否为保险合同约定的驾驶员：
                 <input type="radio" name="CheckExt11" value="1">是
                 <input type="radio" name="CheckExt11" value="0">否
                 <input type="radio" name="CheckExt11" value="2">不确定
               </td>
             </tr>
             <tr class="listodd">
               <td align="left" colspan=4>12、保险车辆驾驶员是否为酒后驾车：
                 <input type="radio" name="CheckExt12" value="1">是
                 <input type="radio" name="CheckExt12" value="0">否
                 <input type="radio" name="CheckExt12" value="2">不确定
               </td>
             </tr>
              <tr class=listeven>
                <td align="left" colspan=4>13、事故车辆损失痕迹与事故现场痕迹是否吻合：
                  <input type="radio" name="CheckExt13" value="1">是
                  <input type="radio" name="CheckExt13" value="0">否
                  <input type="radio" name="CheckExt13" value="2">不确定
                </td>
              </tr>
              <tr class="listodd">
                <td align="left" colspan=4>14、第三者车辆是否已向其承保公司报案、索赔：
                  <input type="radio" name="CheckExt14" value="1">是
                  <input type="radio" name="CheckExt14" value="0">否
                  <input type="radio" name="CheckExt14" value="2">不确定
                </td>
              </tr>
              <tr class=listeven>
                <td align="left" colspan=4>15、事故是否涉及第三方人身伤亡：
                  <input type="radio" name="CheckExt15" value="1">是
                  <input type="radio" name="CheckExt15" value="0">否
                  <input type="radio" name="CheckExt15" value="2">不确定
                </td>
              </tr>
              <tr class="listodd">
                <td align="left" colspan=4>16、事故是否涉及第三方财产损失：
                  <input type="radio" name="CheckExt16" value="1">是
                  <input type="radio" name="CheckExt16" value="0">否
                  <input type="radio" name="CheckExt16" value="2">不确定
                </td>
              </tr>
              <tr class=listeven>
                <td align="left" colspan=4>17、事故是否涉及本车上人员伤亡：
                  <input type="radio" name="CheckExt17" value="1">是
                  <input type="radio" name="CheckExt17" value="0">否
                  <input type="radio" name="CheckExt17" value="2">不确定
                </td>
              </tr>
              <tr class="listodd">
                <td align="left" colspan=4>18、是否向其它保险公司投保：
                  <input type="radio" name="CheckExt18" value="1">是
                  <input type="radio" name="CheckExt18" value="0">否
                  <input type="radio" name="CheckExt18" value="2">不确定
                </td>
              </tr>
              <tr class=listeven>
                <td align="left" colspan=4>19、事故车辆是否配置防盗装置：
                  <input type="radio" name="CheckExt19" value="1">是
                  <input type="radio" name="CheckExt19" value="0">否
                  <input type="radio" name="CheckExt19" value="2">不确定
                </td>
              </tr>
              
              <%//modify by lixiang add 20050311 end%>
							<%--扩展说明部分--%>
							<input  name="CheckExt01Dis" type="hidden" value="保险车辆的车牌号码、发动记号、车架号码与保险单上是否相符:">
							<input  name="CheckExt02Dis" type="hidden" value="出险时间是否在有效期内:">
							<input  name="CheckExt03Dis" type="hidden" value="出险时间接近保险起讫期的，有无相应时间证明:">
							<input  name="CheckExt04Dis" type="hidden" value="实际使用性质与保单上所注明的是否一致:">
							<input  name="CheckExt05Dis" type="hidden" value="保险车辆驾驶员情况与报案人所述是否一致:">
							<input  name="CheckExt06Dis" type="hidden" value="保险车辆驾驶员的驾驶证是否有效:">
							<input  name="CheckExt07Dis" type="hidden" value="保险车辆驾驶员准驾车型于实际驾驶车辆是否相符:">
							<input  name="CheckExt08Dis" type="hidden" value="使用专用机械车、特种车的人员是否有国家核发的有效操作证:">
							<input  name="CheckExt09Dis" type="hidden" value="驾驶营业性客车的驾驶员无国家行政管理部门核发的有效资格证书:">
							<input  name="CheckExt10Dis" type="hidden" value="保险车辆驾驶员是否为保险人允许的驾驶员:">
							<input  name="CheckExt11Dis" type="hidden" value="保险车辆驾驶员是否为保险合同约定的驾驶员:">
							<input  name="CheckExt12Dis" type="hidden" value="保险车辆驾驶员是否为酒后驾车:">
							<input  name="CheckExt13Dis" type="hidden" value="事故车辆损失痕迹与事故现场痕迹是否吻合:">
							<input  name="CheckExt14Dis" type="hidden" value="第三者车辆是否已向其承保公司报案:">
							<input  name="CheckExt15Dis" type="hidden" value="事故是否涉及第三方人身伤亡:">
							<input  name="CheckExt16Dis" type="hidden" value="事故是否涉及第三方财产损失:">
							<input  name="CheckExt17Dis" type="hidden" value="事故是否涉及本车上人员伤亡:">
							<input  name="CheckExt18Dis" type="hidden" value="是否向其它保险公司投保:">							
							<input  name="CheckExt19Dis" type="hidden" value="事故车辆是否配置防盗装置:">							
							<input  name="CheckExt01Serial" type="hidden" value="1">
							<input  name="CheckExt02Serial" type="hidden" value="2">
							<input  name="CheckExt03Serial" type="hidden" value="3">
							<input  name="CheckExt04Serial" type="hidden" value="4">
							<input  name="CheckExt05Serial" type="hidden" value="5">
							<input  name="CheckExt06Serial" type="hidden" value="6">
							<input  name="CheckExt07Serial" type="hidden" value="7">
							<input  name="CheckExt08Serial" type="hidden" value="8">
							<input  name="CheckExt09Serial" type="hidden" value="9">
							<input  name="CheckExt10Serial" type="hidden" value="10">
							<input  name="CheckExt11Serial" type="hidden" value="11">
							<input  name="CheckExt12Serial" type="hidden" value="12">
							<input  name="CheckExt13Serial" type="hidden" value="13">
							<input  name="CheckExt14Serial" type="hidden" value="14">
							<input  name="CheckExt15Serial" type="hidden" value="15">
							<input  name="CheckExt16Serial" type="hidden" value="16">
							<input  name="CheckExt17Serial" type="hidden" value="17">
							<input  name="CheckExt18Serial" type="hidden" value="18">							
							<input  name="CheckExt19Serial" type="hidden" value="19">
          </tbody>
        </table>
      </td>
    </tr>
  </table>
