<%--
****************************************************************************
* DESC       ����ӡ��ť����
* AUTHOR     : zhaozhuo
* CREATEDATE ��2005-03-31
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<table class=common cellpadding="5" cellspacing="1" >
<tr> 
   <tr class=listtitle> 
    <td  colspan="4" >��ӡ�����ĵ�</td>
    </tr>
  <tr> 
  
    <td align="center" class="input">  <input type="button" name=buttonPrint1 class='bigbutton' value="���ձ�����¼" onclick="return printForm(this,'Regist');"> 
    </td>
    <td align="center" class="input">  <input type="button" name=buttonPrint2 class='bigbutton' value="ԭʼ����������" onclick="return printForm(this,'HistoryFile');"> 
    </td>
    <td align="center" class="input"><input type="button" name=buttonPrint3 class='bigbutton' value="����ʱ����" onclick="return printForm(this,'FileOnRisk');"> 
    </td>
    <td align="center"class="input"> <input type="button" name=buttonPrint4 class='bigbutton' value="Ԥ�����������" onclick="return printForm(this,'Prepay');"> 
    </td>
  </tr>
  <tr> 
  <%//modify by caopeng start at 2005-12-21%>
    <logic:equal name="prpLclaimDto" property="caseType" value="2">
    <td align="center" class="input">  <input type="button" name=buttonPrint5 class='bigbutton' value="����֪ͨ�� " onclick="return printForm(this,'Cancelnotice');">  
    </td>
    <td align="center" class="input"> <input type="button" name=buttonPrint6 class='bigbutton' value="���ⰸ��������" onclick="return printForm(this,'Canceltrans');"> 
    </td>
    </logic:equal>
    <logic:notEqual name="prpLclaimDto" property="caseType" value="2">
    <td align="center" class="input">  <input type="button" name=buttonPrint5 class='bigbutton' value="����֪ͨ�� " disabled onclick="return printForm(this,'Cancelnotice');">  
    </td>
    <td align="center" class="input"> <input type="button" name=buttonPrint6 class='bigbutton' value="���ⰸ��������" disabled onclick="return printForm(this,'Canceltrans');"> 
    </td>
    </logic:notEqual>
  <%//modify by caopeng end at 2005-12-21%>
    <td align="center" class="input"> <input type="button" name=buttonPrint7 class='bigbutton' value="�پ��ⰸ��ʧȷ���� " onclick="return printForm(this,'LossSimple');"> 
    </td>
    <td align="center" class="input"> <input type="button" name=buttonPrint8 class='bigbutton' value="��ʧ���ȷ����" onclick="return printForm(this,'Loss');"> 
    </td>
  </tr>
  <tr> 
    <td align="center" class="input"> <input type="button" name=buttonPrint9 class='bigbutton' value="�㲿��������Ŀ�嵥" onclick="return printForm(this,'ComponentList');">
    </td>
    <td align="center" class="input"> <input type="button" name=buttonPrint10 class='bigbutton' value="������Ŀ�嵥 " onclick="return printForm(this,'RepairList');"> 
    </td>
    <td align="center" class="input"> <input type="button" name=buttonPrint11 class='bigbutton' value="������Ŀ�嵥����" onclick="return printForm(this,'RepairAdd');">
    </td>
    <td align="center" class="input"> <input type="button" name=buttonPrint12 class='bigbutton' value="�Ʋ���ʧȷ����" onclick="return printForm(this,'PropList');"> 
    </td>
  </tr>
  <tr> 
    <td align="center"class="input"> <input type="button" name=buttonPrint13 class='bigbutton' value="�������� "onclick="return relate3('Compensate');">
    </td>
    <td align="center"class="input"> <input type="button" name=buttonPrint14 class='bigbutton' value="�������鸽ҳ " onclick="return relate3('CompensateAdd');"> 
    </td>
    <%//modify by caopeng start at 2005-12-21%>
    <logic:equal name="prpLclaimDto" property="caseType" value="0">
    <td align="center" class="input"> <input type="button" name=buttonPrint16 class='bigbutton' value="ע��֪ͨ��" onclick="return printForm(this,'Pressnotice');"> 
    </td>
    </logic:equal>
    <logic:notEqual name="prpLclaimDto" property="caseType" value="0">
    <td align="center" class="input"> <input type="button" name=buttonPrint16 class='bigbutton' value="ע��֪ͨ��" disabled onclick="return printForm(this,'Pressnotice');"> 
    </td>
    </logic:notEqual>
    <%//modify by caopeng end at 2005-12-21%>
    <td align="center" class="input"> <input type="button" name=buttonPrint16 class='bigbutton' value="�᰸�߸�֪ͨ��" onclick="return printForm(this,'PressnoticeEnd');"> 
    </td>
  </tr>
  <tr> 
    <td align="center" class="input"> <input type="button" name=buttonPrint17 class='bigbutton' value="�᰸������" onclick="return printForm(this,'Endcase');"> 
    </td>
    <td align="center" class="input"> <input type="button" name=buttonPrint18 class='bigbutton' value="�᰸�����鸽ҳ" onclick="return printForm(this,'EndcaseAdd');"> 
    </td>
    <td align="center"class="input"> <input type="button" name=buttonPrint19 class='bigbutton' value="��ȡ���֪ͨ�� " onclick="return printForm(this,'Drawnotice');">
    </td>
    <td align="center" class="input"></td>
  </tr> 
</table>