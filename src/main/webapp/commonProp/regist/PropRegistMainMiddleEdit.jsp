<%--
****************************************************************************
* DESC       ��ũ�ձ����ǼǱ�����������Ϣ��
* AUTHOR     ��lixiang
* CREATEDATE ��2004-10-12
* MODIFYLIST ��   Name       Date            Reason/Contents
			     wuzheng    20071207        ��Ԫ��ӡ����վݵ�ʱ����Ҫ���ձ����Ϣ�����Գ��ձ�ĸ�Ϊ������ҿ��Ƴ���
                 
****************************************************************************
--%>
 <tr>
      <td class="title">������:</td>
      <td class="input" colspan=3>
        <input type=text name="prpLregistLossName" title="������" Class="input" style="width:30%" maxLength="120" onblur="checkLength1(this);" description="������" value="<bean:write name='prpLregistDto' property='lossName' filter='true' />">   
        <img src="/claim/images/bgMarkMustInput.jpg">
      </td>
 </tr>
      