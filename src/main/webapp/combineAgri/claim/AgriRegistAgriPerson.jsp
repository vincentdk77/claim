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
 
</script>
<%@page import="com.sinosoft.claim.dto.domain.PrpLacciPersonDto";%>
<%
	PrpLacciPersonDto prpLacciPersonDto = (PrpLacciPersonDto)request.getAttribute("prpLacciPersonDto_"+intdexRegistAgriPerson);
	request.setAttribute("prpLacciPersonDto",prpLacciPersonDto);

 %>
   <!--��ʾ��ʾ���е�-->
<tr>
  <td class="subformtitle" colspan="4" style="text-align:left;"><img style="cursor:hand;" src="/claim/images/butExpandBlue.gif" name="prpLacciPersonImg_<%=intdexRegistAgriPerson %>" onclick="showPage(this,document.getElementById('spanAcciPerson_<%=intdexRegistAgriPerson %>'))">
        �¹�����Ϣ<br>
     <table cellpadding="5" cellspacing="1" class="common"  id="AcciPerson_<%=intdexRegistAgriPerson %>_Data" style="display:none">
       <tbody>
        <tr>
          <td style="width:3%" class=common>
             <div align="center">
               <input class="readonlyNo" readonly name="prpLacciBenPersonSerialNo_<%=intdexRegistAgriPerson %>" description="���">
             </div>
          </td>
                <td class="input" align=left  style="display:none">
                  <input type="hidden" name="prpLacciPersonAddress_<%=intdexRegistAgriPerson %>"  title="ţ��" class="input">
                  <input type="text" name="prpLacciPersonAcciCode_<%=intdexRegistAgriPerson %>" 
                    title="�¹��ߴ���"  class="codecode" maxLength="16" onblur="checkLength1(this);"
                    ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','1,2,3,4');"
                    onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem','1,2,3,4');">
                </td>
                <td class="input" align=left style="width:30%">
                  <%-- ���ر���������� --%>
                  <input type=hidden name="prpLacciPersonFamilyNo_<%=intdexRegistAgriPerson %>"  class="input" />
                  <input type=text name="prpLacciPersonAcciName_<%=intdexRegistAgriPerson %>" title="�¹�������" 
                   class="codecode"  title="�¹�������"  maxLength="120" onblur="checkLength1(this);"
                   ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
                   onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
                <input type=hidden name="prpLacciPersonSex_<%=intdexRegistAgriPerson %>"  class="input" />
                <input type=hidden name="prpLacciPersonAge_<%=intdexRegistAgriPerson %>"  class="input" / value="0"> 
                </td>
                
                <td class="input" align=left style="width:30%">
                  <input type=text name="prpLacciPersonIdentifyNumber_<%=intdexRegistAgriPerson %>"  readonly="true"  title="���֤��" class="input">
               </td>
               <td class="input" align=center style="width:20%">
                   <%@include file="/combineAgri/claim/Benerisk.jsp"%>
               </td>  
          <td class="input" style='width:4%'>
          <div align="center">
            <input type=button name="buttonAcciPersonDelete_<%=intdexRegistAgriPerson %>"  class=smallbutton onclick="deleteRow(this,'AcciPerson_<%=intdexRegistAgriPerson %>')" value="-" style="cursor: hand">
          </div>
          </td>
       </tr>
     </tbody>
  </table>

  <span  id="spanAcciPerson_<%=intdexRegistAgriPerson %>" style="display:">
     <%-- ��������չ���� --%>
    <table class=common id="AcciPerson_<%=intdexRegistAgriPerson %>" cellpadding="5" cellspacing="1">
            <thead>
              <tr class=listtitle>
                <td  style="width:8%">���</td>
                <td  style="display:none">�¹��ߴ���</td>
                <td  style="width:30%">�¹�������</td>
                <td  style="width:30%">���֤����</td>
                <td  style="width:20%">������Ϣ</td>
                <td  style="width:12%">&nbsp;</td>
              </tr>
            </thead>
           <tfoot>
              <tr>
                <td colspan=4  align="center" class="title" >(��"+"�ż������¹�����Ϣ����"-"�ż�ɾ����Ϣ)</td>
                <td class="title"  colspan=1 align="center" >
                   <input type="button" value="+" class=smallbutton onclick="insertRow('AcciPerson_<%=intdexRegistAgriPerson %>')" name="buttonAcciPersonInsert_<%=intdexRegistAgriPerson %>" style="cursor: hand">
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
                  <input  name="prpLacciBenPersonSerialNo_<%=intdexRegistAgriPerson %>"  class="readonlyno" readonly="true"  value="<bean:write name='prpLacciBenPerson' property='serialNo'/>">
                </div>
              </td>
                     <td class="input" align=left  style="display:none">
                       <input type="hidden" name="prpLacciPersonAddress_<%=intdexRegistAgriPerson %>"  title="ţ��" class="input" value="<bean:write name='prpLacciBenPerson' property='address' filter='true' />">
                       <input type="text" name="prpLacciPersonAcciCode_<%=intdexRegistAgriPerson %>" value="<bean:write name='prpLacciBenPerson' property='acciCode' filter='true' />"
                       title="�¹��ߴ���"  class="codecode"    maxLength="16" onblur="checkLength1(this);"
                       ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','1,2,3,4');"
                       onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem','1,2,3,4');">
                     </td>
                     <td class="input" align=left style="width:30%">
                        <%-- ���ر���������� --%>
                        <input type=hidden name="prpLacciPersonFamilyNo_<%=intdexRegistAgriPerson %>"  value="<bean:write name='prpLacciBenPerson' property='familyNo' filter='true' />" class="input" />
                        <input type=text name="prpLacciPersonAcciName_<%=intdexRegistAgriPerson %>" title="�¹�������" value="<bean:write name='prpLacciBenPerson' property='acciName' filter='true' />"
                           class="codecode"  title="�¹�������" maxLength="120" onblur="checkLength1(this);"
                           ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
                           onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
                     <input type=hidden name="prpLacciPersonSex_<%=intdexRegistAgriPerson %>"  class="input" />
                     <input type=hidden name="prpLacciPersonAge_<%=intdexRegistAgriPerson %>"  class="input" / value="0"> 
                     </td>
                     <td class="input" align=left style="width:30%">
                          <input type=text name="prpLacciPersonIdentifyNumber_<%=intdexRegistAgriPerson %>"  readonly="true"  title="���֤��" class="input"  value="<bean:write name='prpLacciBenPerson' property='identifyNumber' filter='true' />">
                       
                      </td>
                      <td class="input" align=center style="width:20%">
                          <%@include file="/combineAgri/claim/Benerisk.jsp"%>
                      </td>
              <td class="title" style="width:4%">
                  <div align="center">
                    <input type=button name="buttonAcciPersonDelete_<%=intdexRegistAgriPerson %>" class=smallbutton  onclick="deleteRow(this,'AcciPerson_<%=intdexRegistAgriPerson %>')" value="-" style="cursor: hand">
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
<%intdexRegistAgriPerson++; %>
 
