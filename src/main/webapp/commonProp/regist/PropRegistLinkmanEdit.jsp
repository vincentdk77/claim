<%--
****************************************************************************
* DESC       ���Ʋ���������ϵ��
* AUTHOR     ��wangwei
* CREATEDATE ��2005-5-31
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

   <!--������ʾ��¼����������������ʾ��-->
   
    <script language='javascript'>
		   <!--    
      //��������뱾ҳ�Զ����JavaScript����

      /*
        ����һ���µ�֮��Ĵ�����ѡ������ 
      */
      function afterInsertThirdProp()
      {
        setPrpLThirdPropSerialNo();
      }
    
      /*
        ɾ������WarnRegion֮��Ĵ�����ѡ������
      */
      function afterDeleteThirdProp(field)
      {         
        setPrpLThirdPropSerialNo();
      }
     
      /** 
       * ����prpLSeriaNo
       */
      function setPrpLThirdPropSerialNo(){
        var count=getElementCount("prpLrelatePersonSeriaNo");
        for(var i=0;i<count;i++)
        {
          if(count!=1){
              fm.prpLrelatePersonSeriaNo[i].value=i;
          } 
        } 
      }   
      //-->      
    </script>   


    <!--��ʾ��ʾ���е�--> 
    <tr >
      <td class="subformtitle" colspan="6" cellspacing="1" cellpadding="0" style="text-align:left">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="ThirdPropImg" onclick="showPage(this,spanThirdProp)">
            ������ϵ��            
        <span style="display:none"> 
          <table class="common" style="display:none" id="ThirdProp_Data" cellspacing="1" cellpadding="0">
            <tbody>
              <tr>
                <td class="input" style="width:10%"> 
                  <input name="prpLrelatePersonSeriaNo" class="readonly" readonly style="width:75%" maxlength=3 value="1">
                 
                </td>
                <td class="input" style="width:15%">
                  <input name="prpLrelatePersonPersonName" class="common" maxLength="30" onblur="checkLength1(this);" description="����"  style="width:90%" >
                </td>
                <td class="input" style="width:15%">
                    <input name="prpLrelatePersonPhoneNumber" class="common" maxLength="30" onblur="checkLength1(this);" description="�̶��绰"  style="width:90%" >
                </td> 
                <td class="input" style="width:15%">
                  <input name="prpLrelatePersonMobile" class="input" maxLength="30" onblur="checkLength1(this);" description="�ƶ��绰" style="width:90%">
                </td>  
                <td class="input" style="width:45%">
                  <input name="prpLrelatePersonRemark" class="input" maxLength="60" onblur="checkLength1(this);" description="��ע" style="width:90%">
                </td>                 
                <td class="input" style='width:4%'  align="center">
                  <div>
                    <input type=button name="buttonThirdPropDelete"  class="smallbutton" onclick="deleteRow(this,'ThirdProp')" value="-" style="cursor: hand">
                  </div>
                </td>
              </tr>
            </tbody>
          </table>
        </span>
        
        
        <span  id="spanThirdProp" style="display:none" cellspacing="1" cellpadding="0">
        <%-- ��������չ���� --%>
        <table class="common" style="width:100%" id="ThirdProp" >
          <thead>
            <tr>
                <td class="centertitle" style="width:10%">���</td>
                <td class="centertitle" style="width:15%">����</td>
                <td class="centertitle" style="width:15%">�̶��绰</td>
                <td class="centertitle" style="width:15%">�ƶ��绰</td>
                <td class="centertitle" style="width:45%">��ע</td>
                <td class="centertitle" style="width:4%" >&nbsp;</td> 
            </tr>
          </thead>
          
          <tfoot>
              <tr>
                <td class="title" colspan=5 style="width:96%">
                    (��"+"�ż�������ϵ����Ϣ����"-"�ż�ɾ����Ϣ)
                </td>
                <td class="title" align="right" style="width:4%">
                 <div align="center">
                    <input type="button" value="+"  class="smallbutton" onclick="insertRow('ThirdProp')" name="buttonDriverInsert" style="cursor: hand">
                 </div>
                </td>
              </tr>
           </tfoot> 
           
           <tbody>
           <logic:notEmpty  name="prpLrelatePersonDtoList">
           <logic:iterate id="prpLrelatePersonDto" name="prpLrelatePersonDtoList">
              <tr>
                <td class="input" style="width:10%">
                  <input name="prpLrelatePersonSeriaNo" class="readonly" readonly style="width:75%" maxlength=3 value="<bean:write name='prpLrelatePersonDto' property='serialNo' />">
                </td>
                <td class="input" style="width:15%">
                  <input name="prpLrelatePersonPersonName" class="common"  style="width:90%" maxLength="30" onblur="checkLength1(this);" description="����" value="<bean:write name='prpLrelatePersonDto' property='personName' />">
                </td>
                <td class="input" style="width:15%">
                    <input name="prpLrelatePersonPhoneNumber" class="common"  style="width:90%" maxLength="30" onblur="checkLength1(this);" description="�̶��绰" value="<bean:write name='prpLrelatePersonDto' property='phoneNumber' />">
                </td>
                <td class="input" style="width:15%">
                  <input name="prpLrelatePersonMobile" class="input" style="width:90%" maxLength="30" onblur="checkLength1(this);" description="�ƶ��绰" value="<bean:write name='prpLrelatePersonDto' property='mobile' />">
                </td>
                <td class="input" style="width:45%">
                  <input name="prpLrelatePersonRemark" class="input" style="width:90%" maxLength="60" onblur="checkLength1(this);" description="��ע" value="<bean:write name='prpLrelatePersonDto' property='remark' />">
                </td>
                <td class="input" style='width:4%'  align="center">
                  <div>
                    <input type=button name="buttonThirdPropDelete" class="smallbutton"  onclick="deleteRow(this,'ThirdProp')" value="-" style="cursor: hand">
                  </div>
                </td>
              </tr>
          </logic:iterate>
          </logic:notEmpty>
       </tbody>
        </table>  
        </span>    
      </td>
    </tr>




  
  



