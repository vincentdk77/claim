    
      <tr>         
      <logic:notEqual name="prpLregistDto" property="riskCode" value="ZH03">
        <td class="title" >��ע��</td>
        <td class="input"  colspan="3">
          <input name='prpLcheckRemark' class='input' maxlength="80" onblur="checkLength1(this);" description="��ע" value="<bean:write name='prpLcheckDto' property='remark'/>">
        </td>
         </logic:notEqual>
          <logic:equal name="prpLregistDto" property="riskCode" value="ZH03">
            <td class="title" >����ţ�</td>
        <td class="input"  colspan="3">
          <input name='prpLcheckRemark' class="readonly" readonly="true" maxlength="80" onblur="checkLength1(this);" description="�����" value="<bean:write name='prpLcheckDto' property='remark'/>">
        </td>
           </logic:equal>
      </tr>        
    </table>