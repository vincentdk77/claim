<%--
****************************************************************************
* DESC       ����ʾ�����ǼǵĹ�����ҳ��
* AUTHOR     ��lixiang
* CREATEDATE ��2004-04-14
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
****************************************************************************
--%>


   <table class="common" cellpadding="5" cellspacing="1">
    <tr class=mline>
      <td class="common" style>
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="ClaimFeeImg" onclick="showPage(this,spanClaimFee)">
             ��������Ϣ 
             <font color="#FF0000">*</font>
	 	
        <span style="display:none"> 
          <table id="ClaimFee_Data" class="common" cellspacing="1" cellpadding="5" >
            <tbody>
      		<tr>
      		
      		   <td class="input" style="width:48%" style="align:center">
      		       		    
      		    <input type=text name="prpLclaimFeeCurrency" class="codecode" style="width:30%" title="�ұ�" 
                        ondblclick="code_CodeSelect(this, 'Currency');"
                        onchange="code_CodeChange(this, 'Currency');"
                        onkeyup= "code_CodeSelect(this, 'Currency');">
                    <input type=text name="prpLclaimFeeCurrencyName" class="codecode" style="width:60%" title="�ұ�"  
                        ondblclick="code_CodeSelect(this, 'Currency','-1','name','none','post');"
                        onchange="code_CodeChange(this, 'Currency','-1','name','none','post');"
                        onkeyup= "code_CodeSelect(this, 'Currency','-1','name','none','post');">
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
        <table id="ClaimFee" class="common" cellpadding="5" cellspacing="1">
          <thead>
            <tr>
              <td class="centertitle" style="width:48%">
                �ұ� 
              </td>
              <td class="centertitle" style="width:48%" >
                ������
              </td> 
            </tr> 
          </thead>
          <tfoot>
            <tr>
            
              <td class="title" colspan=2>
                <p align="center">
                <input onclick="insertRow('ClaimFee'); " class=smallbutton type="button" value="+">
                
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
                        onchange="code_CodeChange(this, 'Currency');"
                        onkeyup= "code_CodeSelect(this, 'Currency');">
                    <input type=text name="prpLclaimFeeCurrencyName" class="codecode" style="width:60%" title="�ұ�"  value="<bean:write name='claimFee' property='currencyName'/>"
                        ondblclick="code_CodeSelect(this, 'Currency','-1','name','none','post');"
                        onchange="code_CodeChange(this, 'Currency','-1','name','none','post');"
                        onkeyup= "code_CodeSelect(this, 'Currency','-1','name','none','post');">
                  </td>
                  
      		   <td class="input" style="width:48%">
      		     <input name="prpLclaimFeeSumClaim" class=common style="text-align:right" value="<bean:write name='claimFee' property='sumClaim' format="0.00" />">
      		   </td>
                   <td class="input" style="width:4%">
                       <div align="center" >            
                        <input type=button ACCESSKEY="-" name='button_ClaimFee_Delete' value='-' class="smallbutton" onclick="deleteRow('claimFee')">
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


