<%--
****************************************************************************
* DESC       ��ũ���¹�����Ϣҳ��
* AUTHOR     ��chenrenda
* CREATEDATE ��2006-06-27
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>


<script language='javascript'>

    function afterInsertAcciPerson()
    {
        setPrpLAcciPersonSerialNo();
    }
    
    /**
     * ɾ������AcciPerson֮��Ĵ�����ѡ������
     */
    function afterDeleteAcciPerson(field)
    {
        setPrpLAcciPersonSerialNo();
    }

    /**
     * ����setPrpLAcciPersonSerialNo
     */
    function setPrpLAcciPersonSerialNo(){
        var count=getElementCount("prpLacciBenPersonSerialNo");
        for(var i=0;i<count;i++)
        {
            if(count!=1){
            	fm.prpLacciBenPersonSerialNo[i].value=i;
            }
        }
    }
    function checkInteger(field)
    {
      field.value = trim(field.value);
      var strValue=field.value;
      if(strValue=="")
        strValue = "0";
      var desc   = field.description;
      
      //���description���Բ����ڣ�����name����
      if(desc==null)
        desc = field.name;
      
      if(isNaN(strValue)||!isInteger(strValue))
      {
        errorMessage("������Ϸ���" + desc +"\n����Ϊ����");
        field.focus();
        field.select();
        return false;
      }
      return true;
    }    
</script>


 
   <!--��ʾ��ʾ���е�-->
<tr>
  <td class="common" colspan="4" style="text-align:left;"><img style="cursor:hand;" src="/claim/images/butExpandBlue.gif" name="prpLacciPersonImg" onclick="showPage(this,spanAcciPerson)">
        ���ձ��<br>
     <table cellpadding="5" cellspacing="1" class="common"  id="AcciPerson_Data" style="display:none">
       <tbody>
        <tr>
          <td style="width:3%" class=common>
             <div align="left">
               <input class="readonlyNo" readonly name="prpLacciBenPersonSerialNo" description="���">
             </div>
          </td>
          <td  class=common colspan=4 style="width:93%">
            <table  cellpadding="2" cellspacing="1" class="common">
              <tr>
                <td class="input" align=left style='width:24%'>
                   <input type=text name="prpLacciPersonAddress" description="ţ��" onblur="checkInteger(this)"  title="ţ��" class="input">
                </td>
                <td class="input" align=left style="width:24%">
                   <input type="hidden" name="prpLacciPersonAcciCode" 
                    title="�������˴���">
                  <input type=text name="prpLacciPersonAcciName" title="������������" 
                   class="codecode"  
                   ondblclick="code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');"
                   onkeyup= "code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');">
                <input type=hidden name="prpLacciPersonSex"  class="input" />
                <input type=hidden name="prpLacciPersonAge"  class="input" / value="0"> 
                </td>
                
                <td class="input" align=left style="width:28%">
                  <input type=text name="prpLacciPersonIdentifyNumber"  readonly="true"  title="���֤��" class="input">
                  <%-- ���ر���������� --%>
                  <input type=hidden name="prpLacciPersonFamilyNo"  class="input" />
                
                 
               </td>
               <td class="input" align=center style="width:16%">
                   <%@include file="/common/regist/3202Benerisk.jsp"%>
               </td>  
              </tr>
            </table>
          </td>
          <td class="input" style='width:4%'>
          <div align="right">
            <input type=button name="buttonAcciPersonDelete"  class=smallbutton onclick="deleteRow(this,'AcciPerson')" value="-" style="cursor: hand">
          </div>
          </td>
       </tr>
     </tbody>
  </table>

  <span  id="spanAcciPerson" style="display:">
     <%-- ��������չ���� --%>
    <table class=common id="AcciPerson" cellpadding="5" cellspacing="1">
            <thead>
              <tr class=listtitle>
                <td  style="width:8%">���</td>
                <td  style="width:24%">ţ��</td>
                <td  style="width:24%">������������</td>
                <td  style="width:28%">���֤����</td>
                <td  style="width:16%">������Ϣ</td>
              </tr>
            </thead>
           <tfoot>
              <tr>
                <td colspan=6  align="center" class="title" >(��"+"�ż������¹�����Ϣ����"-"�ż�ɾ����Ϣ)</td>
                <td class="title"  colspan=1 align="right" >
                   <input type="button" value="+" class=smallbutton onclick="insertRow('AcciPerson')" name="buttonAcciPersonInsert" style="cursor: hand">
                </td>
              </tr>
           </tfoot>
           <tbody>
            <% int  benIndex=0;   %>
       <logic:notEmpty  name="prpLacciPersonDto"  property="prpLacciBenPersonList">
          <logic:iterate id="prpLacciBenPerson" name="prpLacciPersonDto" property="prpLacciBenPersonList">

<%
   if(benIndex %2== 0){
        out.print("<tr class=oddrow>");
    }
    else{
        out.print("<tr class=oddrow>");
    }
%>

              <td class="input" style="width:3%">
                <div align="center">
                  <input  name="prpLacciBenPersonSerialNo"  class="readonlyno" readonly="true"  value="<bean:write name='prpLacciBenPerson' property='serialNo'/>">
                </div>
              </td>
              <td class="common"  colspan=4 style="width:93%">
                <table  cellpadding="5" cellspacing="1" class="common">
                  <tr>
                     <td class="input" align=left style="width:24%">
                       <input type=text name="prpLacciPersonAddress" description="ţ��"  value="<bean:write name='prpLacciBenPerson' property='address' filter='true' />"  title="ţ��" class="input">
                     </td>
                     <td class="input" align=left style="width:24%">
                       <input type="hidden" name="prpLacciPersonAcciCode" value="<bean:write name='prpLacciBenPerson' property='acciCode' filter='true' />"
                        title="�������˴���"  class="codecode"  >
                        <input type=text name="prpLacciPersonAcciName" title="������������" value="<bean:write name='prpLacciBenPerson' property='acciName' filter='true' />"
                           class="codecode" 
                           ondblclick="code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');"
                           onkeyup= "code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');">
                     <input type=hidden name="prpLacciPersonSex"  class="input" />
                     <input type=hidden name="prpLacciPersonAge"  class="input" / value="0"> 
                     </td>
                     <td class="input" align=left style="width:28%">
                          <input type=text name="prpLacciPersonIdentifyNumber"  readonly="true"  title="���֤��" class="input"  value="<bean:write name='prpLacciBenPerson' property='identifyNumber' filter='true' />">
                          <%-- ���ر���������� --%>
                          <input type=hidden name="prpLacciPersonFamilyNo"  value="<bean:write name='prpLacciBenPerson' property='familyNo' filter='true' />" class="input" />
                      </td>
                      <td class="input" align=center style="width:16%">
                          <%@include file="/common/regist/3202Benerisk.jsp"%>
                      </td>   
                  </tr>
                </table> 
              </td>
              <td class="title" style="width:4%">
                  <div align="center">
                    <input type=button name="buttonAcciPersonDelete" class=smallbutton  onclick="deleteRow(this,'AcciPerson')" value="-" style="cursor: hand">
                  </div>
              </td>  
             </tr>   
             <% benIndex++;%>
  </logic:iterate>
</logic:notEmpty>
          </tbody>
        </table>
       </span>
  </td>
</tr>
 
