      <tr>         
        <td class="title" >��������:</td>
        <td class="input"  colspan="3">
          <input type="text" name="prpLextSalvor" class="input" style="width:100px" value="<bean:write name='prpLextDto' property='salvor'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
          
        </td>
      </tr>
     <tr>         
        <td class="title" >ж������:</td>
        <td class="input" >
        <input type="text" name="prpLextUnloadDate" class="input" style="width:140px"  value="<bean:write name='prpLextDto' property='unloadDate'/>" >
        </td>

        <td class="title" >�ᵥ/�˵�:</td>
        <td class="input" >
          <input type="text" name="prpLextLoadingNo" class="input" style="width:100%"  value="<bean:write name='prpLextDto' property='remark'/>" >
        </td>      
      </tr>
      

	

      <tr>         
        <td class="title" >��ע��</td>
        <td class="input"  colspan="3">
          <input name='prpLcheckRemark' class='input' maxlength=80 style="width:440px" value="<bean:write name='prpLcheckDto' property='remark'/>">
        </td>
      </tr>        
    </table>