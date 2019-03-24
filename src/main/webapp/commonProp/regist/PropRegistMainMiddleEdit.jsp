<%--
****************************************************************************
* DESC       ：农险报案登记报案报案主信息中
* AUTHOR     ：lixiang
* CREATEDATE ：2004-10-12
* MODIFYLIST ：   Name       Date            Reason/Contents
			     wuzheng    20071207        国元打印赔款收据的时候需要出险标的信息。所以出险标的改为必须项，且控制长度
                 
****************************************************************************
--%>
 <tr>
      <td class="title">受损标的:</td>
      <td class="input" colspan=3>
        <input type=text name="prpLregistLossName" title="受损标的" Class="input" style="width:30%" maxLength="120" onblur="checkLength1(this);" description="受损标的" value="<bean:write name='prpLregistDto' property='lossName' filter='true' />">   
        <img src="/claim/images/bgMarkMustInput.jpg">
      </td>
 </tr>
      