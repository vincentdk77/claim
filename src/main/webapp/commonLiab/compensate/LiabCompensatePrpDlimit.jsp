<%--
****************************************************************************
* DESC       ���⳥�޶�/�������ʾ���� 
* AUTHOR     ��liubvo
* CREATEDATE �� 2004-10-18 
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<!--������ʾ��¼����������������ʾ��-->  
   <table class="common" align="center" width="100%">
    <tr class=mline>
      <td class="subformtitle" colspan="4" style="text-align:left">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
          name="LimitImg" onclick="showPage(this,spanLimit)">�⳥�޶�/�����<br>
        <span style="display:none">
          <table id="Limit_Data">
            <tbody>
              <tr>
                <td>
                  <input class=readonly readonly style='display:none;width:12px' 
                    name=Limit_Flag><input class=readonly readonly style="width:60px" 
                    name=LimitGrade>
                </td>
                <td><input class=readonly readonly style="width:60px" name=LimitNo ></td>
                <td><input class=readonly readonly style="width:150px" name=LimitType></td>
                <td><input class=readonly readonly style="width:100px" name=PrpLimitCurrency ></td>
                <td><input class=readonly readonly style="width:150px" name=LimitFee ></td>
              </tr>
            </tbody>
          </table>
        </span>

        <span id="spanLimit" style="display:none">
          <table class="sub" style='width:100%' id="Limit">
            <thead>
              <tr>
                <td class="centertitle" style="width:15%">ȫ��/����</td>
               <!-- <td class="centertitle" style="width:15%">����ձ����</td>-->
                <td class="centertitle" style="width:40%">�޶�/���������</td>
                <td class="centertitle" style="width:15%">�ұ�</td>
                <td class="centertitle" style="width:15%">�⳥�޶�/����</td> 
              </tr> 
            </thead> 
            <tbody>
          <logic:notEmpty  name="prpClimitDto"  property="prpClimitList"> 
         <logic:iterate id="limitList" name="prpClimitDto" property="prpClimitList">
              <tr class=oddrow> 
                <td class="centertitle"><bean:write name='limitList' property='limitGrade'/>
                  <input type="hidden" name="limitList" value="<bean:write name='limitList' property='limitNo'/>" >
                </td>
                <!--<td class="centertitle"><bean:write name='limitList' property='limitNo'/></td>-->
                <td class="centertitle"><bean:write name='limitList' property='limitTypeName'/></td>
                <td class="centertitle"><bean:write name='limitList' property='currencyName'/></td>
                <td class="centertitle"><bean:write name='limitList' property='limitFee' format='##0.00'/></td>
              </tr>
        </logic:iterate>
      </logic:notEmpty>
            </tbody>
          </table>
        </span>
      </td>
    </tr>
  </table> 
