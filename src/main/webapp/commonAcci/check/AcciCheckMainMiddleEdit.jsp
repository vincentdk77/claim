      <tr>         
        <td class="title" style="width:15%">事故处理单位：</td>
        <td class="input" style="width:85%" colspan="3">
        <input type ="input" name="prpLcheckHandleUnit" class="codecode" style="width:40%" description="处理部门代码" value="<bean:write name='prpLcheckDto' property='handleUnit'/>">
        <input name='prpLcheckHandleUnitName' class='codename' maxlength=60  style="width:55%" description="处理部门"  value="<bean:write name='prpLcheckDto' property='handleUnitName'/>"
          querytype="always" codetype="ComCode" coderelation="-1" codelimit="none"  style="width:340px">
        </td>
      </tr>       
   