<%--
****************************************************************************
* DESC       ����ҳ�������ӡ�����һ�����롱�����ֶ������롱¼����
* AUTHOR     ��wangwei
* CREATEDATE ��2005-06-04
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

   <table class="common" align="center" width="100%">
      <tr>
          <td class="subformtitle" style="text-align:left" colspan=4>
              <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
                name="LtextImg" onclick="showPage(this,Lloss)">���ֵȼ�
             <br>
         
              <table class="common" align="center" id="Lloss" style="display:none">
                <tbody>
                    <tr>         
                        <td class="title" style="width:25%">����һ�����룺</td>
                        <td class="input" style="width:25%" >
                              <input name="prpCatastropheCode1" class="codecode" style="width:98%"  maxlength=5 description="����һ������" 
                                           value="<bean:write name='prpLclaimDto' property='catastropheCode1' filter='true' />"
                                           ondblclick="code_CodeSelect(this, 'DamageCode');"
                                           onkeyup= "code_CodeSelect(this, 'DamageCode');">
                        </td>
                        <td class="title" width="25%">��������</td>
                        <td class="input" style="width:25%" >
                               <input name="prpCatastropheName1" class="codename"  style="width:98%"  maxlength=30 description="��������" 
                                          value="<bean:write name='prpLclaimDto' property='catastropheName1' filter='true' />"
                                          ondblclick="code_CodeSelect(this, 'DamageCode','-1','always','none','post');"
                                          onkeyup= "code_CodeSelect(this, 'DamageCode','-1','always','none','post');">
                        </td>         
                   </tr>
                   <tr>
                       <td class="title">���ֶ�������</td>
                       <td class="input"><input type="text" name="prpCatastropheCode2" maxlength=5  class="input"  style="width:98%"></input></td>
                       <td class="title">��������</td>
                       <td class="input"><input type="text" name="prpCatastropheName2"  maxlength=30  class="input"  style="width:98%"></input></td>
                  </tr>
             </tbody>
           </table>  
           
        </td> 
    </tr>
  </table>