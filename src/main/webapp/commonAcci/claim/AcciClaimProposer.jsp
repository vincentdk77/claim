<%--
****************************************************************************
* DESC       ����Ӽ�ʻԱ��Ϣҳ��
* AUTHOR     ��weishixin
* CREATEDATE �� 2004-03-03
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<script language='javascript'>

  function afterInsertProposer()
    {
        setPrpLdriverSerialNo();
       
        var count=getElementCount("proposerIdentifyNo");
        for(var i=0;i<count;i++)
        {             
            if(count!=1){
             fm.proposerIdentifyNo[i].maxLength=22;
            }
        }
    }


  /*
    ɾ������Proposer֮��Ĵ�����ѡ������
  */

    function afterDeleteProposer(field)
    {
        setPrpLdriverSerialNo();
    }

    /**
     * ����setPrpLdriverSerialNo
     */
  function setPrpLdriverSerialNo(){
        var count=getElementCount("prpLacciPersonSerialNo");
        for(var i=0;i<count;i++)
        {
            if(count!=1){
            	fm.prpLacciPersonSerialNo[i].value=i;
            }
        }
    }
 
</script>


<!--������ʾ��¼����������������ʾ��-->
    <table class="common" cellpadding="5" cellspacing="1">
   <!--��ʾ��ʾ���е�-->
      <tr>
        <td class="subformtitle" colspan="3" style="text-align:left;"><img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif" name="prpLacciPersonImg" onclick="showPage(this,spanClaimProposer)">
        ������������Ϣ<br>

     <table cellpadding="5" cellspacing="1" class="common"  id="Proposer_Data" style="display:none">
       <tbody>
        <tr>
          <td style="width:5%" class=common>
             <div align="center">
               <input class="readonlyNo" readonly name="prpLacciPersonSerialNo" description="���">
             </div>
          </td>
                 <!-----��������Ϣstart----------------->
                 <td class="input" style='width:20%' align="center">
                   <input name="proposerName" class="input" style="width:90%" maxlength=20 description="��������������"><img src="/claim/images/bgMarkMustInput.jpg">  
                 </td>
                 <td class="input" style='width:20%' align="center">
                   <input name="proposerIdentifyNumber" class="input" style="width:95%" maxlength=20 description="�������������֤����"><img src="/claim/images/bgMarkMustInput.jpg">
                 </td>
                 <td class="input" style="width:15%" align="center">
                   <select name="relationCode" >
                              <option value="1" >�������˱���</option>
		                      <option value="2" >ָ��������</option>
		                      <option value="3" >��������֮�̳���</option>
		                      <option value="4" >��������֮�໤��</option>
		            </select>
		        </td>
                <td class="input" style='width:15%' align="center">
                  <input name="proposerPhone" class="common" style="width:95%" maxlength=20 description="��ϵ�绰">
                </td>
                <td class="input" style='width:21%' align="center">
                  <input name="proposerAddress" class="common" style="width:95%" maxlength=20 description="ͨ�ŵ�ַ">
                  <input type=hidden name="personFamilyNo" value="<bean:write name='prpLclaimDto' property='familyNo' filter='true' />" class="input" />
                  <input type=hidden name="claimNo" value="<bean:write name='prpLclaimDto' property='claimNo' filter='true' />" class="input" />
                  <input type=hidden name="proposerPolicyNo" value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />" class="input" />
                  
                </td>
          </td>
          <!-----��������Ϣend------------------->
          <td class="input" style='width:4%'>
          <div align="center">
            <input type=button name="buttonProposerDelete"  class=smallbutton onclick="deleteRow(this,'Proposer')" value="-" style="cursor: hand">
          </div>
          </td>
       </tr>
     </tbody>
  </table>

  <span  id="spanClaimProposer" style="display:none">
  <%-- ��������չ���� --%>
    <table class=common id="Proposer" cellpadding="5" cellspacing="1">
            <thead>
              <tr class=listtitle>
                <td  style="width:5%">���</td>
                <td  style="width:20%">����</td>
                <td  style="width:20%">���֤����</td>
                <td  style="width:15%">���¹��߹�ϵ</td>
                <td  style="width:15%">��ϵ�绰</td>
                <td  style="width:21%">ͨ�ŵ�ַ</td>
                <td  style='width:4%'>&nbsp;</td>
              </tr>
            </thead>
           <tfoot>
              <tr>
                <td colspan=6  align="center" class="title" >(��"+"�ż�����������������Ϣ����"-"�ż�ɾ����Ϣ)</td>
                <td class="title"  colspan=1 align="center" >
                   <input type="button" value="+" class=smallbutton onclick="insertRow('Proposer')" name="buttonProposerInsert" style="cursor: hand">
                </td>
              </tr>
           </tfoot>
         <tbody>
      <% int  index=0;   %>
                                                    
<logic:notEmpty  name="prpLacciPersonDto"  property="prpLacciPersonList">
         <logic:iterate id="prpLacciPerson" name="prpLacciPersonDto" property="prpLacciPersonList">

<%
   if(index %2== 0){
        out.print("<tr class=oddrow>");
    }
    else{
        out.print("<tr class=oddrow>");
    }
%>

              <td class="input" style="width:5%">
                <div align="center">
                  <input  name="prpLacciPersonSerialNo"  class="readonlyno" readonly="true" value="<bean:write name='prpLacciPerson' property='serialNo'/>">
                </div>
              </td>
                     <td class="input" style='width:20%'align="center">
                        <input name="proposerName"  class="input" style="width:90%" maxlength=20 value="<bean:write name='prpLacciPerson' property='acciName'/>" title="����������"><img src="/claim/images/bgMarkMustInput.jpg">
                     </td>
                     <td class="input" style='width:20%' align="center">
                        <input name="proposerIdentifyNumber"  class="input" style="width:95%" maxlength=20 value="<bean:write name='prpLacciPerson' property='identifyNumber'/>" title="���֤����"><img src="/claim/images/bgMarkMustInput.jpg">
                     </td>
                     <td class="input" style="width:15%"  align="center">
                      <html:select name="prpLacciPerson"  property='relationCode'>
                              <html:option value="1" >�������˱���</html:option>
		                      <html:option value="2" >ָ��������</html:option>
		                      <html:option value="3" >��������֮�̳���</html:option>
		                      <html:option value="4" >��������֮�໤��</html:option>
                     </html:select>
               
                  <input type=hidden name="claimNo" value="<bean:write name='prpLacciPerson' property='certiNo'/>" class="input" />  
                    </td>
                    <td class="input" style='width:15%' align="center">
                        <input name="proposerPhone"  class="input" style="width:95%" maxlength=20 value="<bean:write name='prpLacciPerson' property='phone'/>" title="�����˵绰">
                    </td>
                    <td class="input" style="width:21%" align="center">
                        <input name="proposerAddress" class="input"  style="width:95%" maxlength=10 value="<bean:write name='prpLacciPerson' property='address'/>" title="�����˵�ַ">
                    </td>
              <td class="title" style="width:4%">
                  <div align="center">
                    <input type=button name="buttonProposerDelete" class=smallbutton  onclick="deleteRow(this,'Proposer')" value="-" style="cursor: hand">
                  </div>
              </td>  
             </tr>   
<%    index++;%>
  </logic:iterate>
      </logic:notEmpty>
 
          </tbody>
        </table>
      </td>
    </tr>
  </table>
</span>
</table>

