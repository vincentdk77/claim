<%--
****************************************************************************
* DESC       ����ҳ�������ӡ�����һ�����롱�����ֶ������롱¼����
* AUTHOR     ��wangwei
* CREATEDATE ��2005-06-04
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
****************************************************************************
--%>

   <table class="common" cellpadding="5" cellspacing="1">
      <tr>
          <td class="common" style="text-align:left" colspan=4>
              <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
                name="LtextImg" onclick="showPage(this,Lloss)">������Ϣ
             <br>
         
              <table class="common" cellpadding="5" cellspacing="1" id="Lloss" style="display:none">
                <tbody>
                    <tr>         
                        <td class="title" style="width:20%">�������ͣ�</td>
                        <td class="input" style="width:30%" >
                              <input name="prpCatastropheCode1" class="codecode" style="width:98%"  maxlength=5 description="����ԭ��" 
                              value="<bean:write name='prpLclaimDto' property='catastropheCode1' filter='true' />"
                                           ondblclick="code_CodeSelect(this, 'CatastropheCode');"
                                           onchange="code_CodeChange(this, 'CatastropheCode');"
                                           onkeyup= "code_CodeSelect(this, 'CatastropheCode');">
                        </td>
                        <td class="title" width="20%">��������</td>
                        <td class="input" style="width:30%" >
                               <input name="prpCatastropheName1" class="common" style="width:98%"  maxlength=30 description="����ԭ��" 
                               value="<bean:write name='prpLclaimDto' property='catastropheName1' filter='true' />"
                               >
                        </td>         
                   </tr>
               </tbody>
           </table>  
           
        </td> 
    </tr>
  </table>