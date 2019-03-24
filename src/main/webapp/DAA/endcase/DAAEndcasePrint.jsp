<%--
****************************************************************************
* DESC       ：打印按钮画面
* AUTHOR     : zhaozhuo
* CREATEDATE ：2005-03-31
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<table class=common cellpadding="5" cellspacing="1" >
<tr> 
   <tr class=listtitle> 
    <td  colspan="4" >打印案件文档</td>
    </tr>
  <tr> 
  
    <td align="center" class="input">  <input type="button" name=buttonPrint1 class='bigbutton' value="保险报案记录" onclick="return printForm(this,'Regist');"> 
    </td>
    <td align="center" class="input">  <input type="button" name=buttonPrint2 class='bigbutton' value="原始保单及批单" onclick="return printForm(this,'HistoryFile');"> 
    </td>
    <td align="center" class="input"><input type="button" name=buttonPrint3 class='bigbutton' value="出险时保单" onclick="return printForm(this,'FileOnRisk');"> 
    </td>
    <td align="center"class="input"> <input type="button" name=buttonPrint4 class='bigbutton' value="预付赔款审批表" onclick="return printForm(this,'Prepay');"> 
    </td>
  </tr>
  <tr> 
  <%//modify by caopeng start at 2005-12-21%>
    <logic:equal name="prpLclaimDto" property="caseType" value="2">
    <td align="center" class="input">  <input type="button" name=buttonPrint5 class='bigbutton' value="拒赔通知书 " onclick="return printForm(this,'Cancelnotice');">  
    </td>
    <td align="center" class="input"> <input type="button" name=buttonPrint6 class='bigbutton' value="拒赔案件报告书" onclick="return printForm(this,'Canceltrans');"> 
    </td>
    </logic:equal>
    <logic:notEqual name="prpLclaimDto" property="caseType" value="2">
    <td align="center" class="input">  <input type="button" name=buttonPrint5 class='bigbutton' value="拒赔通知书 " disabled onclick="return printForm(this,'Cancelnotice');">  
    </td>
    <td align="center" class="input"> <input type="button" name=buttonPrint6 class='bigbutton' value="拒赔案件报告书" disabled onclick="return printForm(this,'Canceltrans');"> 
    </td>
    </logic:notEqual>
  <%//modify by caopeng end at 2005-12-21%>
    <td align="center" class="input"> <input type="button" name=buttonPrint7 class='bigbutton' value="速决赔案损失确认书 " onclick="return printForm(this,'LossSimple');"> 
    </td>
    <td align="center" class="input"> <input type="button" name=buttonPrint8 class='bigbutton' value="损失情况确认书" onclick="return printForm(this,'Loss');"> 
    </td>
  </tr>
  <tr> 
    <td align="center" class="input"> <input type="button" name=buttonPrint9 class='bigbutton' value="零部件更换项目清单" onclick="return printForm(this,'ComponentList');">
    </td>
    <td align="center" class="input"> <input type="button" name=buttonPrint10 class='bigbutton' value="修理项目清单 " onclick="return printForm(this,'RepairList');"> 
    </td>
    <td align="center" class="input"> <input type="button" name=buttonPrint11 class='bigbutton' value="修理项目清单附表" onclick="return printForm(this,'RepairAdd');">
    </td>
    <td align="center" class="input"> <input type="button" name=buttonPrint12 class='bigbutton' value="财产损失确认书" onclick="return printForm(this,'PropList');"> 
    </td>
  </tr>
  <tr> 
    <td align="center"class="input"> <input type="button" name=buttonPrint13 class='bigbutton' value="赔款计算书 "onclick="return relate3('Compensate');">
    </td>
    <td align="center"class="input"> <input type="button" name=buttonPrint14 class='bigbutton' value="赔款计算书附页 " onclick="return relate3('CompensateAdd');"> 
    </td>
    <%//modify by caopeng start at 2005-12-21%>
    <logic:equal name="prpLclaimDto" property="caseType" value="0">
    <td align="center" class="input"> <input type="button" name=buttonPrint16 class='bigbutton' value="注销通知书" onclick="return printForm(this,'Pressnotice');"> 
    </td>
    </logic:equal>
    <logic:notEqual name="prpLclaimDto" property="caseType" value="0">
    <td align="center" class="input"> <input type="button" name=buttonPrint16 class='bigbutton' value="注销通知书" disabled onclick="return printForm(this,'Pressnotice');"> 
    </td>
    </logic:notEqual>
    <%//modify by caopeng end at 2005-12-21%>
    <td align="center" class="input"> <input type="button" name=buttonPrint16 class='bigbutton' value="结案催告通知书" onclick="return printForm(this,'PressnoticeEnd');"> 
    </td>
  </tr>
  <tr> 
    <td align="center" class="input"> <input type="button" name=buttonPrint17 class='bigbutton' value="结案报告书" onclick="return printForm(this,'Endcase');"> 
    </td>
    <td align="center" class="input"> <input type="button" name=buttonPrint18 class='bigbutton' value="结案报告书附页" onclick="return printForm(this,'EndcaseAdd');"> 
    </td>
    <td align="center"class="input"> <input type="button" name=buttonPrint19 class='bigbutton' value="领取赔款通知书 " onclick="return printForm(this,'Drawnotice');">
    </td>
    <td align="center" class="input"></td>
  </tr> 
</table>