<%--
****************************************************************************
* DESC       ����ҳ�������ӡ�����һ�����롱�����ֶ������롱¼����
* AUTHOR     ��wangwei
* CREATEDATE ��2005-06-04
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

   <table class="common" align="center" width="100%" cellpadding="5" cellspacing="1">
      <tr>
          <td class="subformtitle" style="text-align:left" colspan=4>
              <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
                name="LtextImg" onclick="showPage(this,Lloss)"> ���ֵȼ�
             <br>
         
              <table class="common" align="center" id="Lloss" style="display:none">
                <tbody>
                    <tr>         
                        <td class="title" >����һ�����룺</td>
                        <td class="input"  >
                              <input name="prpCatastropheCode1" class="codecode"   maxlength=5 description="����һ������" 
                                   value="<bean:write name='prpLclaimDto' property='catastropheCode1'filter='true' />"
                                           ondblclick="code_CodeSelect(this, 'CatastropheCode');"
                                           onkeyup= "code_CodeSelect(this, 'CatastropheCode');">
                        </td>
                        <td class="title">��������</td>
                        <td class="input"  >
                               <input name="prpCatastropheName1" class="codename"    maxlength=30 description="��������" 
                                   value="<bean:write name='prpLclaimDto' property='catastropheName1' filter='true' />"
                                      ondblclick="code_CodeSelect(this, 'CatastropheCode','-1','always','none','post');"
                                     onkeyup= "code_CodeSelect(this, 'CatastropheCode','-1','always','none','post');">
                        </td>         
                   </tr>
                   <tr>
                       <td class="title">���ֶ�������</td>
                       <td class="input"><input type="text" name="prpCatastropheCode2" maxlength=5  class="input"  
                             value="<bean:write name='prpLclaimDto' property='catastropheCode2' filter='true' />"></input></td>
                       <td class="title">��������</td>
                       <td class="input"><input type="text" name="prpCatastropheName2"  maxlength=30  class="input"  
                            value="<bean:write name='prpLclaimDto' property='catastropheName2' filter='true' />"></input></td>
                  </tr>
             </tbody>
           </table>  
           
        </td> 
    </tr>
  </table>