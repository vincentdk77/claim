<%--
****************************************************************************
* DESC       �������Ա��������Ϣҳ��
* AUTHOR     ��weishixin
* CREATEDATE �� 2004-06-01
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
  
   <!--������ʾ��¼����������������ʾ��-->
      <span style="display:none"> 
          <table class="common" style="display:none" id="PersonFeeLoss_Data" cellspacing="1" cellpadding="0">
           <tbody>
           <tr>                                             
          <td class='inputsubsub'>
             <input type="text" name="personSerialNo" style="width:20px">                   
             <input name=prpLpersonLossFeeTypeCode class="codecode" style='width:95%' title="���ô���" 
                 coderelation="1" codelimit="must"
              ondblclick= " code_CodeSelect(this,'KindCode');"
              onkeyup= " code_CodeSelect(this,'KindCode');"> 
          </td>
          <td class='inputsubsub'>                                                    
             <input name=prpLpersonLossFeeTypeName class="codename" style="width:95%" title="��������" 
             
              ondblclick= "code_CodeSelect(this, 'KindCode','-1','always','none','post');"
              onkeyup= " code_CodeSelect(this, 'KindCode','-1','always','none','post');"> 
          </td>
          <td class='inputsubsub'>
              <input name=prpLpersonLossUnitPrice class="common" style="width:95%">
          </td>
          <td class='inputsubsub'>
              <input name=prpLpersonLossQuantity class="common" style="width:95%">
          </td>                     
          <td class='inputsubsub'>
              <input name=prpLpersonLossSumLoss class="common" style="width:95%">
          </td>
          <td class='inputsubsub'>
              <input name=prpLpersonLossClaimRate class="common" style="width:95%">
           </td>
           <td class='inputsubsub'>
              <input name=prpLpersonLossRealpay class="readonly" readonly=true style="width:90%">
           </td>                                                                              
           <td class='inputsubsub'>
              <div align="center">
                <input type=button name="buttonPersonFeeLossDelete"  onclick="deleteRow(this,'PersonFeeLoss')" value="-" style="cursor: hand">
              </div>
              
           </td>
             
         </tr>
       </tbody>

    </table>
    </span>
        
        <span  id="spanPersonFeeLoss" >
        <%-- ��������չ���� --%>
        <table id="PersonFeeLoss" class="common" align="center" cellspacing="1" cellpadding="0">
          <thead>
             <tr>
                <td class="subsubformtitle" colspan=11>
                 ������Ϣ <font color="#FF0000">*</font>
                </td>
             </tr>
             <tr>
         <td class="titlesubsub" style="width:11%">���ô���</td>
         <td class="titlesubsub" style="width:15%">��������</td>
         <td class="titlesubsub" style="width:15%">����</td>
         <td class="titlesubsub" style="width:15%">��Ŀ</td>                                        
         <td class="titlesubsub" style="width:15%">������</td>
         <td class="titlesubsub" style="width:11%">�⳥����%</td>
         <td class="titlesubsub" style="width:15%">�⸶���</td>  
         <td class="titlesubsub" style="width:3%">  </td>                                           
       </tr> 
          </thead>
          <tfoot>
              <tr>
                <td class="titlesubsub" colspan="7" style="width:97%"></td>
                 <td class="title" align="right" style="width:4%">
                 <div align="center">
                 <input type="button" value="+" onclick="insertRow('PersonFeeLoss');" name="buttonPersonFeeLossInsert" style="cursor: hand">
                 </div>
                 </td>
              </tr>
           </tfoot> 
           
          <tbody>
 <% int indexperloss=0;%>   
          </tbody>
        </table>  
        </span>    
  


