<%--
****************************************************************************
* DESC       ����ʾ������ҳ��(�ǳ���ʹ��)
* AUTHOR     ��lixiang
* CREATEDATE ��2004-10-15
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>


   <table class="common" align="center" style="width:100%">
    <tr class=mline>
      <td class="subformtitle" style>
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="ClaimFeeImg" onclick="showPage(this,spanClaimFee)">
             ��������Ϣ 
             <font color="#FF0000">*</font>
	 	
        <span style="display:none"> 
          <table id="ClaimFee_Data" class="common" cellspacing="1" cellpadding="0" >
            <tbody>
      		<tr>
      		
      		   <td class="input" style="width:48%" style="align:center">
      		       		    
      		    <input type=text name="prpLclaimFeeCurrency" class="codecode" style="width:30%" title="�ұ����" 
                        ondblclick="code_CodeSelect(this, 'Currency');"
                        onkeyup= "code_CodeSelect(this, 'Currency');">
                    <input type=text name="prpLclaimFeeCurrencyName" class="codecode" style="width:60%" title="�ұ�����"  
                        ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                        onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">
                  </td>
                  
      		   <td class="input" style="width:48%">
      		     <input name="prpLclaimFeeSumClaim" class=common  style="text-align:right" >
      		   </td>
                   <td class="input" style="width:4%">
                       <div align="center" >            
                        <input type=button ACCESSKEY="-" name='button_ClaimFee_Delete' class="smallbutton" value='-' onclick="deleteRow(this,'ClaimFee')">
                        <input type="hidden" name="prpLclaimFeeFlag">
                       </div>
                    
                    </td>
      	        </tr>
            </tbody>
          </table>
        </span>
         
        <span  id="spanClaimFee" style="display:none">
        <table id="ClaimFee" class="common" style="width:100%">
          <thead>
            <tr>
              <td class="centertitle" style="width:48%">
                �ұ� 
              </td>
              <td class="centertitle" style="width:48%" >
                ������
              </td> 
              <td  class="centertitle"  style="width:4%">
                 <input onclick="collectClaimFee();" type="button" class="button" value="����">
              </td>
            </tr> 
          </thead>
          <tfoot>
            <tr>
            <td class="title" colspan=2 style="width:96%" >(��"+"�ż����ӹ������"-"�ż�ɾ����Ϣ)
              <td class="title" style="width:4%">
                <p align="center">
                <input onclick="insertRow('ClaimFee'); " type="smallbutton" class="button" value="+">
                
                </p>
              </td>
             </tr>
          </tfoot>
          <tbody>
          <%int indexfee=0;%>
        
           <logic:iterate id="claimFee" name="prpLclaimFeeDto" property="claimFeeList">
             <!-- �����������Ϣ-->
             <tr>
      		
      		   <td class="input" style="width:48%" style="align:center">
      		       		    
      		    <input type=text name="prpLclaimFeeCurrency" class="codecode" style="width:30%" title="�ұ�" value="<bean:write name='claimFee' property='currency'/>"
                        ondblclick="code_CodeSelect(this, 'Currency');"
                        onkeyup= "code_CodeSelect(this, 'Currency');">
                    <input type=text name="prpLclaimFeeCurrencyName" class="codecode" style="width:60%" title="�ұ�"  value="<bean:write name='claimFee' property='currencyName'/>"
                        ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                        onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">
                  </td>
                  
      		   <td class="input" style="width:48%">
      		     <input name="prpLclaimFeeSumClaim" class=common style="text-align:right" value="<bean:write name='claimFee' property='sumClaim' format="0.00" />">
      		   </td>
                   <td class="input" style="width:4%">
                       <div align="center" >            
                        <input type=button ACCESSKEY="-" name='button_ClaimFee_Delete' class="smallbutton" value='-' onclick="deleteRow(this,'ClaimFee')">
                        <input type="hidden" name="prpLclaimFeeFlag">
                       </div>
                    
                    </td>
      	        </tr>
             
             <%    indexfee++;%>
           </logic:iterate>
          </tbody>
        </table>
        <span>
      </td>
    </tr>
  </table>



