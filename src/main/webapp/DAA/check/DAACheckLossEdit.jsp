<%--
****************************************************************************
* DESC       ���鿱�¹ʹ������
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-06-03
* MODIFYLIST ��   Name       Date            Reason/Contents
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
*          ------------------------------------------------------
****************************************************************************
--%> 
 
   <!--������ʾ��¼����������������ʾ��-->   
    <script language='javascript'>
      //��������뱾ҳ�Զ����JavaScript����
      /*
        ����һ���µ�֮��Ĵ�����ѡ������ע��afterInsert���������span�����֣��������ִ�Сд
      */
      function afterInsertCheckLoss()
      {
        setPrpLcheckLossSerialNo();
      }
    
      /*
        ɾ������WarnRegion֮��Ĵ�����ѡ������
      */
      function afterDeleteCheckLoss(field)
      {        
        setPrpLcheckLossSerialNo();
      }
    
      /**
       * ����setPrpLcheckLossSerialNo
       */
      function setPrpLcheckLossSerialNo(){
          var count=getElementCount("prpLcheckLossSerialNo");
          for(var i=0;i<count;i++)
          {
              //alert("����ʲôʱ������?count="+count+"  i="+i); 
              if(count!=1){
                  fm.prpLcheckLossSerialNo[i].value=i;
              }
          }
      }
    </script>   
    
   <table class="common" align="center" width="100%" >
    <!--��ʾ��ʾ���е�-->
    <tr>
      <td class="subformtitle" colspan="4">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="CheckLossImg" onclick="showPage(this,spanCheckLoss)">
             ������<br>
        <span style="display:none"> 
          <table class="common" style="display:none" id="CheckLoss_Data" cellspacing="1" cellpadding="0">
            <tbody>
              <tr>
                <td class="title" style="width:20%">
                  <input type="hidden"  name="prpLcheckLossFlag">
                  <input type="hidden"  name="prpLcheckLossLossFeeType">
                  <input type="text" class="input" style="width:80px" name="prpLcheckLossReferSerialNo">
                  <input type="hidden" name="prpLcheckLossSerialNo" description="���">
                </td>
                <td class="title" style="width:16%">
                  <input type="text" name="prpLcheckLossKindCode" class="codecode" style="width:50px" maxlength=3
                        ondblclick="code_CodeSelect(this, 'PolicyKindCode');"
                        onchange="code_CodeChange(this, 'PolicyKindCode');"
                        onkeyup= "code_CodeSelect(this, 'PolicyKindCode');">
                </td>
                <td class="title" style="width:20%">
                  <input type="text" name="prpLcheckLossKindName" class="codename" style="width:90%"
                        ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','none','post');"
                        onchange="code_CodeChange(this, 'PolicyKindCode','-1','name','none','post');"
                        onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','none','post');">
                </td>
                <td class="title" style="width:20%">
                  
                  <html:select name="prpLcheckLossDto" property="lossFeeType">
                     <html:option value="1">����</html:option>
                     <html:option value="2">��Ա</html:option>
                     <html:option value="3">�Ʋ�</html:option>
                  </html:select>
                
                </td>
                <td class="title" style="width:20%">
                  <input type="text" name="prpLcheckLossLossFee" class="input" style="width:100%;align:right">
                </td>
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type=button name="buttonCheckLossDelete"  class="smallbutton" onclick="deleteRow(this,'CheckLoss')" value="-" style="cursor: hand">
                </div>
                </td>
              </tr>         
            </tbody>
          </table>
        </span>        
        
        <span  id="spanCheckLoss" style="display:none" cellspacing="1" cellpadding="0">
        <%-- ��������չ���� --%>
        <table class="common" style="width:100%" id="CheckLoss" >
          <thead>
            <tr>
              <td class="centertitle"  style="width:20%">�������⳵�����</td>
              <td class="centertitle" style="width:16%">�ձ����</td>
              <td class="centertitle" style="width:20%">�ձ�����</td>
              <td class="centertitle" style="width:20%">�������</td>
              <td class="centertitle" style="width:20%">��ʧ���</td>
              <td class="title" style="width:4%" >&nbsp;</td>
            </tr>
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan=5 style="width:96%">(��"+"�ż�������������Ϣ����"-"�ż�ɾ����Ϣ)</td>
                 <td class="title" align="right" style="width:4%">
                   <div align="center">
                     <input type="button" value="+" class="smallbutton" onclick="insertRow('CheckLoss')" name="buttonDriverInsert" style="cursor: hand">
                   </div>
                 </td>
              </tr>
           </tfoot> 
          </tfoot>
          <tbody>
<% int indexCharge=0;%>
<logic:notEmpty  name="prpLcheckLossDto"  property="prpLcheckLossList"> 
<logic:iterate id="checkLossdtox" name="prpLcheckLossDto" property="prpLcheckLossList">

              <tr>
                <td class="input">
                  <input type="hidden"  name="prpLcheckLossLossFeeType" value="<bean:write name='checkLossdtox' property='lossFeeType'/>">
                  <input type="text" class="input" style="width:80px" name="prpLcheckLossReferSerialNo" value="<bean:write name='checkLossdtox' property='referSerialNo'/>">
                  <input type="hidden"  name="prpLcheckLossFlag" value="<bean:write name='checkLossdtox' property='flag'/>">
                  <input type="hidden"  name="prpLcheckLossSerialNo" description="���" value="<bean:write name='checkLossdtox' property='serialNo'/>">
                </td>
                <td class="input">
                  <input type="text" name="prpLcheckLossKindCode" class="codecode" style="width:50px" maxlength=3 value="<bean:write name='checkLossdtox' property='kindCode'/>"
                        ondblclick="code_CodeSelect(this, 'PolicyKindCode');"
                        onchange="code_CodeChange(this, 'PolicyKindCode');"
                        onkeyup= "code_CodeSelect(this, 'PolicyKindCode');">
                 
                </td>
                <td class="input">
                  <input type="text" name="prpLcheckLossKindName" class="codename" style="width:90%" value="<bean:write name='checkLossdtox' property='kindName'/>"
                        ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','none','post');"
                        onchange="code_CodeChange(this, 'PolicyKindCode','-1','name','none','post');"
                        onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','none','post');">
                        
                </td>
                <td class="input">
                   <html:select name="checkLossdtox" property="lossFeeType">
                     <html:option value="1">����</html:option>
                     <html:option value="2">��Ա</html:option>
                     <html:option value="3">�Ʋ�</html:option>
                  </html:select>
                  
                
                </td>
                <td class="input">
                  <input type="text" name="prpLcheckLossLossFee" class="input" style="width:100%;text-align:right" value="<bean:write name='checkLossdtox' property='lossFee' format='##.00' />">
                </td>
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type=button name="buttonCheckLossDelete" class="smallbutton"  onclick="deleteRow(this,'CheckLoss')" value="-" style="cursor: hand">
                </div>
                </td>
              </tr>
<%    indexCharge++;%>
      </logic:iterate>
      </logic:notEmpty>         
          </tbody>
        </table>  
        </span>    
      </td>
    </tr>
  </table>

