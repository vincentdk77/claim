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

   <table class="common" align="center" cellpadding="5" cellspacing="1">
      <tr>
          <td class="common" style="text-align:left" colspan=4>
              <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
                name="LtextImg" onclick="showPage(this,Lloss)">������Ϣ
             <br>
         
              <table class="common" cellpadding="5" cellspacing="1" id="Lloss" style="display:none">
                <tbody>
                    <tr>         
                        <td class="title" >�������ͣ�</td>
                        <td class="input" >
                              <input name="prpCatastropheCode1" class="codecode" style="width:98%"  maxlength=5 description="��������" 
                                           value="<bean:write name='prpLregistDto' property='catastropheCode1' />"
                                           ondblclick="code_CodeSelect(this, 'CatastropheCode');"
                                           onchange="code_CodeChange(this, 'CatastropheCode');"
                                           onkeyup= "code_CodeSelect(this, 'CatastropheCode');">
                        </td>
                        <td class="title" >��������</td>
                        <td class="input"  >
                               <input name="prpCatastropheName1" class="common" style="width:98%"  maxlength=30 description="��������" 
                                value="<bean:write name='prpLregistDto' property='catastropheName1' />"
                               >
                        </td>         
                   </tr>
               </tbody>
           </table>  
           
        </td> 
    </tr>
  </table>