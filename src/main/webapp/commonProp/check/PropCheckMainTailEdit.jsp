    
      <tr>         
      <logic:notEqual name="prpLregistDto" property="riskCode" value="ZH03">
        <td class="title" >备注：</td>
        <td class="input"  colspan="3">
          <input name='prpLcheckRemark' class='input' maxlength="80" onblur="checkLength1(this);" description="备注" value="<bean:write name='prpLcheckDto' property='remark'/>">
        </td>
         </logic:notEqual>
          <logic:equal name="prpLregistDto" property="riskCode" value="ZH03">
            <td class="title" >户编号：</td>
        <td class="input"  colspan="3">
          <input name='prpLcheckRemark' class="readonly" readonly="true" maxlength="80" onblur="checkLength1(this);" description="户编号" value="<bean:write name='prpLcheckDto' property='remark'/>">
        </td>
           </logic:equal>
      </tr>        
    </table>