<%--
****************************************************************************
* DESC       ：财产险立案登记主信息中
* AUTHOR     ：lixiang
* CREATEDATE ：2004-10-12
* MODIFYLIST ：   Name       Date            Reason/Contents
			     wuzheng    20071207        国元打印赔款收据的时候需要出险标的信息。所以出险标的改为必须项，且控制长度
                 
****************************************************************************
--%>
 <tr>
      <td class="title">受损标的:</td>
      <td class="input" >
        <input type=text name="prpLclaimLossName" title="受损标的" class="input"  value="<bean:write name='prpLclaimDto' property='lossName' filter='true' />">
        <img src="/claim/images/bgMarkMustInput.jpg">
      </td>
      <td class="title"></td>
      <td class="input"></td>
     
      </tr>
      