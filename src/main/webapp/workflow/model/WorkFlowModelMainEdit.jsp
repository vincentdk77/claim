<%--
****************************************************************************
* DESC       ����ӹ�����ģ����Ϣ�ӿ����ҳ��
* AUTHOR     �� weishixin
* CREATEDATE �� 2004-8-10
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

    
    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
 
      <tr>
        <td class="title" colspan="4">������ģ������Ϣ </td>
      </tr>
      <tr>
         
        <td class="title">ģ���ţ�</td>
        <td class="input" >
          <input type=text name="swfModelMainModelNo" class="readonly" readonly="true" value="<bean:write name='swfModelMainDto' property='modelNo' filter='true' />"><font color="#FF0000">*</font>
        </td>
        <td class="title" style="valign:bottom" >ģ�����ƣ�</td>
        <td class="input" style="valign:middle">
          <input type=text name="swfModelMainModelName"  class="common" value="<bean:write name='swfModelMainDto' property='modelName' filter='true' />"><font color="#FF0000">*</font>
        </td>
      </tr>
      <tr>
        <td class="title">ģ�����ͣ�</td>
        <td class="input">
           <html:select name="swfModelMainDto" property="modelType" styleClass="three" >
              <html:option value="01" >����ģ��</html:option>
          </html:select>
        </td>
        <td class="title">ģ��״̬��</td>
        <td class="input">
          <html:select name="swfModelMainDto" property="modelStatus" styleClass="three" >
              <html:option value="0" >δʹ��</html:option>
		      <html:option value="1" >����ʹ��</html:option>        
		      <html:option value="2" >��ͣ��</html:option> 
		      <html:option value="3" >������</html:option> 
		      <html:option value="4" >��ע��</html:option> 
          </html:select>
        </td>
      </tr>
      <tr>
        <td class="title">�������ڣ�</td>
        <td class="input">
          <input type=text name="swfModelMainCreateDate" title="��������" class="readonly"  readonly="true"  value="<bean:write name='swfModelMainDto' property='createDate' filter='true' />">
        </td>
        <td class="title">�޸����ڣ�</td>
        <td class="input">
          <input type=text name="swfModelMainModifyDate" class="readonly"  readonly="true" value = "<bean:write name='swfModelMainDto' property='modifyDate' filter='true' />">
        </td>
      </tr>
       <input type=hidden name="swfModelMainRightID">
       <input type=hidden name="swfModelMainModelAttr">
       <input type=hidden name="swfModelMainCloseService">
       <input type=hidden name="swfModelMainActiveService">
       <input type=hidden name="swfModelMainFlag">
       <input type=hidden name="editType" value="<bean:write name='swfModelMainDto' property='editType' filter='true' />">

       
    </table>