<%--
****************************************************************************
* DESC       ����ʾ(�ǳ���)�����Ǽǵ��ձ������ҳ��
* AUTHOR     ��wangwei
* CREATEDATE ��2005-06-07
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

<!--������ʾ��¼����������������ʾ��-->

<table class="common" align="center" width="100%" >
 <!--��ʾ��ʾ���е�-->
 <tr >
   <td class="subformtitle" colspan="4">
     <img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
          name="ClaimLossImg" onclick="showPage(this,spanClaimLoss)">
          �ձ��������Ϣ<font color="#FF0000">*</font><br>
     <span style="display:none">
       <table class="common" style="display:none" id="ClaimLoss_Data" cellspacing="1" cellpadding="0">
         <tbody>
         <tr>

             <td class="input" style="width:30%" style="align:center">
                 <input type=text name="prpLclaimLossKindCode" class="codecode" style="width:30%" title="�ձ�"
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode');">
                 <input type=text name="prpLclaimLossKindName" class="codecode" style="width:60%" title="�ձ�"
                      ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
                      onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');">
             </td>
              
             <td class="input" style="width:20%" align="center">
                 <input type="text" name="prpLregistEstiCurrency" value="" class="codecode" style="width:30%" title="�ұ�" 
                                    ondblclick="code_CodeSelect(this, 'Currency');"
                                    onkeyup= "code_CodeSelect(this, 'Currency');">
                  <input type=text name="prpLregistEstiCurrencyName" class="codecode" style="width:60%" title="�ұ�"  value=""
                                     ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                                     onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">
             </td>
             <td class="input" style="width:16%">
                 <input name="prpLclaimLossSumClaim" class=common style="text-align:right" onblur=" collectClaimLoss();dutySum();">
                
             </td>
             
             <td class="input" name="prpLregsitLossFeeType" style="width:10%">
                   <select name="prpLregistLossFeeType">
                       <option value="P">���</option>
                       <option value="Z">����</option>
                    </select>        	
            </td>
            <td class="input" style="width:8%">                
                  <input name="prpLclaimLossKindRest" class=common style="width:50px">
          </td>
            <%
                //��õ�ǰʱ��
            %>
             <td class="input" style="width:10%">
                 <input name="prpLclaimLossInputDate" class="readonly" readonly style="width:85px" maxlength="10"  
                   value="<%= new com.sinosoft.sysframework.common.datatype.DateTime(com.sinosoft.sysframework.common.datatype.DateTime.current().toString(), com.sinosoft.sysframework.common.datatype.DateTime.YEAR_TO_DAY) %>">
             </td>
             <td class="input" style="width:10%">
                 <input name="prpLclaimLossRemarkFlag" class="input" maxlength="100">
             </td>
             
             <td class="input" style='width:4%' colspan="2" align="center">
                 <div>
                   <input type=button name="buttonClaimLossDelete"  class="smallbutton" onclick="deleteRow(this,'ClaimLoss')" value="-" style="cursor: hand">
                 </div>
             </td>
         </tr>
         </tbody>
      </table>
    </span>
    
    <span  id="spanClaimLoss" style="display:" cellspacing="1" cellpadding="0">
     <%-- ��������չ���� --%>
     <table class="common" style="width:100%" id="ClaimLoss" >
       <thead>
         <tr>
              <td class="centertitle" style="width:30%">�ձ�</td>
              <td class="centertitle" style="width:20%">�ұ�</td>
              <td class="centertitle" style="width:16%">�ձ������</td>
              <td class="centertitle" style="width:10%">��������</td>
               <td class="centertitle" style="width:8%">��ֵ</td>
              <td class="centertitle" style="width:10%">��������</td>
              <td class="centertitle" style="width:10%">����ԭ��</td>
              <td  class="centertitle"  style="width:4%">
                 <input onclick="collectClaimLoss();dutySum();" type="button" class="button" value="����">
              </td>
         </tr>
       </thead>
       <tfoot>
         <tr>
            <td class="title" colspan=6 style="width:96%">(��"+"�ż����ӵ�֤��Ϣ����"-"�ż�ɾ����Ϣ)</td>
            <td class="title" align="right" style="width:4%">
               <div align="center">
                  <input type="button" value="+" class="smallbutton" onclick="insertRow('ClaimLoss')" name="buttonDriverInsert" style="cursor: hand">
               </div>
            </td>
        </tr>
      </tfoot>
   
      <tbody>
 
       </tbody>
     </table>
    </span>
   </td>
  </tr>
</table>