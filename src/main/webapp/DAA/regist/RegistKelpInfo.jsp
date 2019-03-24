<%--
****************************************************************************
* DESC       ：在页面中增加“巨灾一级代码”、巨灾二级代码”录入域
* AUTHOR     ：wangwei
* CREATEDATE ：2005-06-04
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
****************************************************************************
--%>

   <table class="common" align="center" cellpadding="5" cellspacing="1">
      <tr>
          <td class="common" style="text-align:left" colspan=4>
              <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
                name="LtextImg" onclick="showPage(this,Lloss)">巨灾信息
             <br>
         
              <table class="common" cellpadding="5" cellspacing="1" id="Lloss" style="display:none">
                <tbody>
                    <tr>         
                        <td class="title" >巨灾类型：</td>
                        <td class="input" >
                              <input name="prpCatastropheCode1" class="codecode" style="width:98%"  maxlength=5 description="巨灾类型" 
                                           value="<bean:write name='prpLregistDto' property='catastropheCode1' />"
                                           ondblclick="code_CodeSelect(this, 'CatastropheCode');"
                                           onchange="code_CodeChange(this, 'CatastropheCode');"
                                           onkeyup= "code_CodeSelect(this, 'CatastropheCode');">
                        </td>
                        <td class="title" >巨灾名称</td>
                        <td class="input"  >
                               <input name="prpCatastropheName1" class="common" style="width:98%"  maxlength=30 description="巨灾名称" 
                                value="<bean:write name='prpLregistDto' property='catastropheName1' />"
                               >
                        </td>         
                   </tr>
               </tbody>
           </table>  
           
        </td> 
    </tr>
  </table>