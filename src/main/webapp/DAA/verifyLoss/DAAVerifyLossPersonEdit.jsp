<%--
****************************************************************************
* DESC       �� ��Ա�����嵥ҳ��
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-07-13 
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
**************************************************************************** 
--%>     
<%@ page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>

    <span style="display:" id="SpanPerson" cellspacing="1" cellpadding="0"> 
      <span style="display:none"> 
        <table class="common" style="display:none" id="PersonFeeLoss_Data" cellspacing="1" cellpadding="5">
          <tbody>  
            <tr>    
              <td class="input">  
                <input type="hidden" name="personSerialNo" style="width:20px"> 
                <input type="input" name="prpLpersonKindCode" class="codecode" style="width:60px"
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode');"
                      onchange="code_CodeChange(this, 'PolicyKindCode');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode');">         
              </td>
              <td class="input">   
                  <input type="input" name="prpLpersonKindName" class="codename" style="width:80px"
			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
			             onchange="code_CodeChange(this, 'PolicyKindCode','-1','name','none','post');"
			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');">         
              </td>

              <td class="input">  
                <input type="input" name="prpLpersonFeeTypeCode" class="codecode" style="width:60px">         
              </td>
              <td class="input">   
                  <input type="input" name="prpLpersonFeeTypeName" class="codename" style="width:80px">         
              </td>
            <!--
              <td class="input">
                <input name="prpLpersonUnitLoss" title="����" class="readonly" readonly style="width:60px">
              </td>
              <td class="input">
                <input name="prpLpersonQuantity" class="readonly" readonly style="width:60px">
              </td>                     -->
              <td class="input">
                <input name="prpLpersonSumLoss" class="readonly" readonly style="width:60px">
              </td>
              <td class="input">
                <input name="prpLpersonSumReject" class="readonly" readonly style="width:60px">
              </td>
              <td class="input">
                <input name="prpLpersonSumDefLoss" class="readonly" readonly style="width:60px">
                <input type="hidden" name="prpLpersonItemKindNo"> 
                <input type="hidden" name="prpLpersonFamilyNo"> 
                <input type="hidden" name="prpLpersonItemCode"> 
                <input type="hidden" name="prpLpersonUnit"> 
                <input type="hidden" name="prpLpersonTimes"> 
                <input type="hidden" name="prpLpersonRejectReason"> 
                <input type="hidden" name="prpLpersonVeriQuantity"> 
                <input type="hidden" name="prpLpersonVeriUnitLoss"> 
                <input type="hidden" name="prpLpersonVeriUnit"> 
                <input type="hidden" name="prpLpersonVeriTimes"> 
                <input type="hidden" name="prpLpersonVeriSumLoss"> 
                <input type="hidden" name="prpLpersonVeriSumReject"> 
                <input type="hidden" name="prpLpersonVeriRejectReason">  
                <input type="hidden" name="prpLpersonVeriLossRate">  
                <input type="hidden" name="prpLpersonVeriSumDefLoss"> 
                <input type="hidden" name="prpLpersonVeriRemark"> 
                <input type="hidden" name="prpLpersonFlag"> 
                <input type="hidden" name="prpLpersonCompensateBackFlag" >
      
              </td>    
            </tr>
          </tbody>
        </table>
      </span>
       
      <table class=common cellpadding="5" cellspacing="1">
      <!--��ʾ��ʾ���е�-->
        <tr>
          <td class="centertitle" colspan="4" align="center">
            �⸶��Ա��Ϣ             
          </td>
        </tr>
        <tr>
          <td class="common" colspan="4">
            <span style="display:none"> 
              <table class="common" style="display:none" id="Person_Data" cellspacing="1" cellpadding="5">
                <tbody>                      
                   <tr>
                     <td class="input" style="width:3%">
                       <div align="center">
                         <input class="readonlyNo" readonly name="prpLpersonSerialNo" description="���">
                       </div>
                     </td>
                     <td class="common">
                       <table  cellpadding="0" cellspacing="1" class="common">
                         <tr>
                           <td class="title" style="width:15%">��Ա���:</td>
                           <td class="input" style="width:35%">&nbsp;</td>
                           <td class="title" style="width:15%">��Ա����:</td>
                           <td class="readonly" readonly style="width:35%">
                             <input name="prpLpersonPersonName" class="readonly" readonly style="width:150px">
                           </td>
                         </tr>      
                         <tr>
                           <td class="title" style="width:15%">�Ա�:</td>
                           <td class="title" style="width:35%">                               
                            <select name="prpLpersonPersonSex" class='input' style="width:150px">   
                               <option value="1">��</option>
                               <option value="2">Ů</option>                   
                            </select>   
                           </td>
                           <td class="title" style="width:15%">���ƺ���:</td>
                           <td class="readonly" readonly style="width:35%">
                             <input name="prpLpersonFamilyName" class="readonly" readonly style="width:150px">
                           </td>
                         </tr> 
                         <tr>
                           <td class="title" style="width:15%">����:</td>
                           <td class="readonly" readonly style="width:85%" colspan="3">
                             <input name="prpLpersonPersonAge" class="readonly" readonly style="width:150px">
                           </td>
                         </tr> 
                         <tr>
                           <td class="title" style="width:15%">���֤����:</td>
                           <td class="readonly" readonly style="width:35%">
                             <input name="prpLpersonIdentifyNumber" class="readonly" readonly style="width:150px">
                           </td>
                           <td class="title" style="width:15%">���ڵ���:</td>
                           <td class="readonly" readonly style="width:35%">
                             <input name="prpLpersonAreaCode" class="readonly" readonly style="width:90px">
                             <input name="prpLpersonAreaName" class="readonly" readonly style="width:90px">
                           </td>
                         </tr> 
                         
                         <tr>
                           <td class="title" style="width:15%">������λ:</td>
                           <td class="input" style="width:85%" colspan="3">
                             <input name="prpLpersonJobUnit" class="input" style="width:450px">
                           </td>
                         </tr> 
                         <tr>
                           <td class="title" style="width:15%">��׼����:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonMonthStdWage" class="input" style="width:150px">
                           </td>
                           <td class="title" style="width:15%">�½���:</td>
                           <td class="input" style="width:35%">
                            <input type="input" name="prpLpersonMonthBonus" class="input" style="width:150px"> 
                           </td>
                         </tr> 
                         <tr>
                           <td class="title" style="width:15%">�򣨲�����:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonAllowance" class="input" style="width:150px">
                           </td>
                           <td class="title" style="width:15%">������С��:</td>
                           <td class="input" style="width:35%">
                            <input type="input" name="prpLpersonMonthWage" class="input" style="width:150px"> 
                           </td>
                         </tr> 
                         <tr>
                           <td class="title" style="width:15%">����ҽԺ:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonHospital" class="input" style="width:150px">
                           </td>
                           <td class="title" style="width:15%">��Ҫ��������:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonNursePersons" class="input" style="width:150px">
                           </td>
                         </tr> 
                         <tr>
                           <td class="title" style="width:15%">��Ҫ��������:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonNurseDays" class="input" style="width:150px">
                           </td>
                           <td class="title" style="width:15%">��Ͻ��:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonDiagnose" class="input" style="width:150px">
                           </td>
                         </tr>                          
                         <tr>
                           <td class="title" style="width:15%">���Ƴ̶�:</td>
                           <td class="input" style="width:35%">
                            <select name="prpLpersonWoundGrade" style="width:150px">
                              <option value="1">��</option>
                              <option value="2">��</option>
                              <option value="3">����</option>
                            </select> 
                           </td>
                           <td class="title" style="width:15%">��סԺ����:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonHospitalDays" class="input" style="width:150px">
                           </td>
                         </tr> 
                         <tr>
                           <td class="title" style="width:15%">����������:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonCureDays" class="input" style="width:150px">
                           </td>
                           <td class="title" style="width:15%">�Ƿ���ҪתԺ����:</td>
                           <td class="input" style="width:35%">
                            <select name="prpLpersonChangeHospital" style="width:150px">
                              <option value="1">��</option>
                              <option value="0">��</option>
                            </select> 
                           </td>
                         </tr> 
                                                  
                         <tr>
                           <td class="title" style="width:15%">�������:</td>
                           <td class="readonly" readonly style="width:35%">
                             <input name="prpLpersonFixedIncomeFlag" class="readonly" readonly style="width:150px">
                           </td>
                           <td class="title" style="width:15%">��ҵ:</td>
                           <td class="readonly" readonly style="width:35%">
                             <input name="prpLpersonJobCode" class="readonly" readonly style="width:90px">
                             <input name="prpLpersonJobName" class="readonly" readonly style="width:90px">
                           </td>
                         </tr> 
                         
                         <tr>
                           <td class="title" style="width:15%">��Ա����:</td>
                           <td class="readonly" readonly style="width:35%">
                             <input name="prpLpersonPayPersonType" class="readonly" readonly style="width:150px">
                           </td>
                           <td class="title" style="width:15%">������Ա:</td>
                           <td class="readonly" readonly style="width:35%">
                             <input name="prpLpersonRelatePersonNo" class="readonly" readonly style="width:150px">
                           </td>
                         </tr> 
                         
                         <tr>
                           <td class="title" style="width:15%">�˲б���:</td>
                           <td class="readonly" readonly style="width:35%">
                             <input name="prpLpersonLossRate" class="readonly" readonly style="width:150px">%
                           </td>
                           <td class="title" style="width:15%">�ұ�:</td>
                           <td class="readonly" readonly style="width:35%">
                             <input name="prpLpersonCurrencyName" class="readonly" readonly style="width:150px" value="�����">
                             <input name="prpLpersonCurrency" type="hidden" value="CNY">
                           </td>
                         </tr> 
                        <%-- //modify by hanliang add start 20051222 --%>
                             <tr>
                           <td class="title" style="width:15%">��Ժ����:</td>  
                           <td class="input" style="width:35%">
                             <input type="input" name="prpLpersonInHospDate" class="readonly" style="width:150px"   ondblclick="return getDateTime(this);" value=""> 
                           </td>
                           <td class="title" style="width:15%">��Ժ����:</td>
                           <td class="input" style="width:35%">
                             <input type="input" name="prpLpersonOutHospDate" class="readonly" style="width:150px" ondblclick="return getDateTime(this);" value="">
                           </td>
                         </tr>
                            <tr>
                           <td class="title" style="width:15%">��������:</td>
                           <td class="input" style="width:85%" colspan="3">
                             <input type="input" name="prpLpersonRestDate" class="readonly" style="width:150px" ondblclick="return getDateTime(this);" value="">
                           </td>
                         </tr>
                           <tr>
                           <td class="title" style="width:15%">��ҽ���˵��:</td>
                           <td class="input" style="width:85%" colspan="3">
                             <input name="prpLpersonFllowHospRemark" class="readonly" style="width:350px" maxLength="255" onblur="checkLength1(this);" description="��ҽ���˵��" value="">
                           </td>
                         </tr>  
                          <%-- //modify by hanliang add end  20051222 --%>
                         <tr>
                           <td class="title" style="width:15%">��ע:</td>
                           <td class="readonly" readonly style="width:85%" colspan="3">
                             <input name="prpLpersonRemark" class="readonly" readonly style="width:150px">
                             <input type="hidden" name="prpLpersonPersonNo"> 
                           </td>
                         </tr>  
                         <tr> 
                           <td class="common" style="width:100%" colspan="4">
                            <table name="PersonFeeLoss" class="common" style="width:100%" cellpadding="1" cellspacing="1" border="0" bgcolor="#2D8EE1">
                              <tr> 
                                <td class="title" style="width:4%" rowspan="6">�������</td>
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck001" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck001Txt" value="0"></td> 
                                <td class="title" style="width:14%">­������</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck002" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck002Txt" value="0"></td> 
                                <td class="title" style="width:14%">�߹ǹ���</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck003" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck003Txt" value="0"></td> 
                                <td class="title" style="width:14%">��֫����</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck004" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck004Txt" value="0"></td> 
                                <td class="title" style="width:14%">Ƣ������</td>                                                                                      
                              </tr>                                                                                                                                    
                              <tr>                                                                                                                                     
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck005" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck005Txt" value="0"></td> 
                                <td class="title" style="width:14%">��ò����</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck006" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck006Txt" value="0"></td> 
                                <td class="title" style="width:14%">��������</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck007" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck007Txt" value="0"></td> 
                                <td class="title" style="width:14%">�ֲ�����</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck008" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck008Txt" value="0"></td> 
                                <td class="title" style="width:14%">��������</td>                                                                                      
                              </tr>                                                                                                                                    
                              <tr>                                                                                                                                     
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck009" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck009Txt" value="0"></td> 
                                <td class="title" style="width:14%">��������</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck010" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck010Txt" value="0"></td> 
                                <td class="title" style="width:14%">�������</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck011" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck011Txt" value="0"></td> 
                                <td class="title" style="width:14%">�㲿����</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck012" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck012Txt" value="0"></td> 
                                <td class="title" style="width:14%">��������</td>                                                                                       
                              </tr>                                                                                                                                    
                              <tr>                                                                                                                                     
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck013" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck013Txt" value="0"></td> 
                                <td class="title" style="width:14%">��׵����</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck014" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck014Txt" value="0"></td> 
                                <td class="title" style="width:14%">��ǹ���</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck015" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck015Txt" value="0"></td> 
                                <td class="title" style="width:14%">��������</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck016" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck016Txt" value="0"></td> 
                                <td class="title" style="width:14%">������������</td>                                                                                  
                              </tr>                                                                                                                                    
                              <tr>                                                                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck017" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck017Txt" value="0"></td> 
                                <td class="title" style="width:14%">���ǹ���</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck018" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck018Txt" value="0"></td> 
                                <td class="title" style="width:14%">�ɹ�ͷ����</td>                                                                                    
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck019" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck019Txt" value="0"></td> 
                                <td class="title" style="width:14%">�β�����</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck020" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck020Txt" value="0"></td> 
                                <td class="title" style="width:14%">����֯����</td>                                                                                    
                              </tr>                                                                                                                                    
                              <tr>                                                                                                                                     
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck021" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck021Txt" value="0"></td> 
                                <td class="title" style="width:14%">�عǹ���</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck022" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck022Txt" value="0"></td> 
                                <td class="title" style="width:14%">�ϱ۹���</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck023" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck023Txt" value="0"></td> 
                                <td class="title" style="width:14%">��������</td>                                                                                      
                                <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck024" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck024Txt" value="0"></td> 
                                <td class="title" style="width:14%">��������</td> 
                              </tr> 
                            </table> 
                           </td> 
                         </tr>  
                                                  
                        <tr>
                        <td colspan="4">
                          <span  id="spanPersonFeeLoss" >
                          <%-- ��������չ���� --%>
                          <table id="PersonFeeLoss" name="PersonFeeLoss" class="common" align="center" cellspacing="1" cellpadding="5">
                            <thead>
                              
                            </thead>
                            <tfoot>
                            
                            </tfoot> 
                             
                            <tbody>    
                   
                            </tbody>
                          </table>    
                        </span>  
                      </td>
                    </tr>    
                    <tr>
                      <td colspan="4">
                        <table class="common"  cellpadding="5" cellspacing="1"> 
                          <td class='title' colspan="1" width="30%">������:<input class='readonly' readonly="true" style='width:80px' name='prpLpersonSumLossSum'>
                          </td>    
                          <td class='title' colspan="1" width="30%">�޳����:<input class='readonly'  readonly="true" style='width:80px' name='prpLpersonSumRejectSum'>
                          </td>   
                          <td class='title' colspan="2" width="40%">������:<input class='readonly'  readonly="true" style='width:80px' name='prpLpersonSumDefLossSum'>
                          </td>
                        </table>   
                      </td>   
                    </tr>
                  </tbody> 
                </table>
              </td>                 
           </tr> 
         </tbody>
       </table>
     </span>
          
     <span  id="spanPerson">
       <%-- ��������չ���� --%>
       <table id="person" class="common" align="center" cellspacing="1" cellpadding="5">
         <thead>
           <tr>
             <td class="title" style="width:4%">���</td>
             <td class="title" style="width:96%" >����</td>
           </tr> 
         </thead>
         <tfoot>

         </tfoot> 
         <tbody>

<%
        int personNo = 0;
        PrpLpersonDto prpLpersonDto = (PrpLpersonDto)request.getAttribute("prpLpersonDto");
        if(prpLpersonDto.getPersonList()!=null){
          Iterator iterator = prpLpersonDto.getPersonList().iterator();
          while(iterator.hasNext()){
            PrpLpersonDto PrpLpersonDto1 =  (PrpLpersonDto)iterator.next();
            DecimalFormat sf = new DecimalFormat ("####0.00");
            if(!(PrpLpersonDto1.getPersonNo() == personNo)){
%>                      
           <tr>
             <td class="input" style="width:3%">
               <div align="center">
                 <input class="readonlyNo" readonly name="prpLpersonSerialNo" description="���" value="<%= personNo+1 %>">
               </div>
             </td>
             <td class="common">
               <table  cellpadding="0" cellspacing="1" class="common">
                 <tr>
                   <td class="title" style="width:15%">��Ա���:</td>
                   <td class="input" style="width:35%">&nbsp;</td>
                   <td class="title" style="width:15%">��Ա����:</td>
                   <td class="input" style="width:35%">
                     <input name="prpLpersonPersonName" class="readonly" readonly style="width:150px"  value="<%= PrpLpersonDto1.getPersonName() %>">
                   </td>
                 </tr>      
                 <tr>
                   <td class="title" style="width:15%">�Ա�:</td>
                   <td class="input" style="width:35%">
                     <input type="hidden" name="prpLpersonPersonSex" value="<%= PrpLpersonDto1.getPersonSex() %>">               
                     <select name="prpLpersonPersonSexShow" class="three" style="width:150px"  disabled value="<%= PrpLpersonDto1.getPersonSex() %>">   
                         <option value="1" <%= PrpLpersonDto1.getPersonSex().trim().equals("1")? "selected":"" %>>��</option>
                         <option value="2" <%= PrpLpersonDto1.getPersonSex().trim().equals("2")? "selected":"" %>>Ů</option>                   
                      </select>     
                   </td>
                   <td class="title" style="width:15%">���ƺ���:</td>
                   <td class="input" style="width:35%">
                     <input name="prpLpersonFamilyName" class="readonly" readonly style="width:150px" value="<%= PrpLpersonDto1.getFamilyName() %>">
                   </td>
                 </tr> 
                 <tr>
                   <td class="title" style="width:15%">����:</td>
                   <td class="input" style="width:85%" colspan="3">
                     <input name="prpLpersonPersonAge" class="readonly" readonly style="width:150px" value="<%= PrpLpersonDto1.getPersonAge() %>">
                   </td>
                 </tr> 
                 <tr>
                   <td class="title" style="width:15%">���֤����:</td>
                   <td class="input" style="width:35%">
                     <input name="prpLpersonIdentifyNumber" class="readonly" readonly style="width:150px" value="<%= PrpLpersonDto1.getIdentifyNumber() %>">
                   </td>
                   <td class="title" style="width:15%">���ڵ���:</td>
                   <td class="input" style="width:35%">
                     <input name="prpLpersonAreaCode" class="readonly" readonly style="width:90px" value="<%= PrpLpersonDto1.getAreaCode() %>">
                     <input name="prpLpersonAreaName" class="readonly" readonly style="width:90px" value="<%= PrpLpersonDto1.getAreaName() %>">
                   </td>
                 </tr> 
                 <tr>
                   <td class="title" style="width:15%">������λ:</td>
                   <td class="input" style="width:85%" colspan="3">
                     <input name="prpLpersonJobUnit" class="input" style="width:450px" value="<%= PrpLpersonDto1.getJobUnit() %>">
                   </td>
                 </tr> 
                 <tr>
                   <td class="title" style="width:15%">��׼����:</td>
                   <td class="input" style="width:35%">
                     <input name="prpLpersonMonthStdWage" class="input" style="width:150px" value="<%= sf.format(PrpLpersonDto1.getMonthStdWage()) %>">
                   </td>
                   <td class="title" style="width:15%">�½���:</td>
                   <td class="input" style="width:35%">
                    <input type="input" name="prpLpersonMonthBonus" class="input" style="width:150px" value="<%= sf.format(PrpLpersonDto1.getMonthBonus()) %>"> 
                   </td>
                 </tr> 
                 <tr>
                   <td class="title" style="width:15%">�򣨲�����:</td>
                   <td class="input" style="width:35%">
                     <input name="prpLpersonAllowance" class="input" style="width:150px" value="<%= sf.format(PrpLpersonDto1.getAllowance()) %>">
                   </td>
                   <td class="title" style="width:15%">������С��:</td>
                   <td class="input" style="width:35%">
                    <input type="input" name="prpLpersonMonthWage" class="input" style="width:150px" value="<%= sf.format(PrpLpersonDto1.getMonthWage()) %>"> 
                   </td>
                 </tr> 
                 <tr>
                   <td class="title" style="width:15%">����ҽԺ:</td>
                   <td class="input" style="width:35%">
                     <input name="prpLpersonHospital" class="input" style="width:150px" value="<%= PrpLpersonDto1.getHospital() %>">
                   </td>
                   <td class="title" style="width:15%">��Ҫ��������:</td>
                   <td class="input" style="width:35%">
                     <input name="prpLpersonNursePersons" class="input" style="width:150px" value="<%= PrpLpersonDto1.getNursePersons() %>">
                   </td>
                 </tr> 
                 <tr>
                   <td class="title" style="width:15%">��Ҫ��������:</td>
                   <td class="input" style="width:35%">
                     <input name="prpLpersonNurseDays" class="input" style="width:150px" value="<%= PrpLpersonDto1.getNurseDays() %>">
                   </td>
                   <td class="title" style="width:15%">��Ͻ��:</td>
                   <td class="input" style="width:35%">
                     <input name="prpLpersonDiagnose" class="input" style="width:150px" value="<%= PrpLpersonDto1.getDiagnose() %>">
                   </td>
                 </tr>                          
                 <tr>
                   <td class="title" style="width:15%">���Ƴ̶�:</td> 
                   <td class="input" style="width:35%"> 
                   
                    <select name="prpLpersonWoundGrade" style="width:150px">
                      <option value="1" <%= PrpLpersonDto1.getWoundGrade().equals("1")?"selected":"" %>>��</option>
                      <option value="2" <%= PrpLpersonDto1.getWoundGrade().equals("2")?"selected":"" %>>��</option>
                      <option value="3" <%= PrpLpersonDto1.getWoundGrade().equals("3")?"selected":"" %>>����</option>
                    </select> 
                     
                   </td>
                   <td class="title" style="width:15%">��סԺ����:</td>
                   <td class="input" style="width:35%">
                     <input name="prpLpersonHospitalDays" class="input" style="width:150px" value="<%= PrpLpersonDto1.getHospitalDays() %>">
                   </td>
                 </tr> 
                 <tr>
                   <td class="title" style="width:15%">����������:</td>
                   <td class="input" style="width:35%">
                     <input name="prpLpersonCureDays" class="input" style="width:150px" value="<%= PrpLpersonDto1.getCureDays() %>">
                   </td>
                   <td class="title" style="width:15%">�Ƿ���ҪתԺ����:</td>
                   <td class="input" style="width:35%">                            
                    <select name="prpLpersonChangeHospital" style="width:150px">
                      <option value="1" <%= PrpLpersonDto1.getChangeHospital().equals("1")?"selected":"" %>>��</option>
                      <option value="0" <%= PrpLpersonDto1.getChangeHospital().equals("0")?"selected":"" %>>��</option>
                    </select>  
                   </td>
                 </tr>                    
                 
                 <tr>
                   <td class="title" style="width:15%">�������:</td>
                   <td class="input" style="width:35%">                
                     <input name="prpLpersonFixedIncomeFlag" type="hidden" value="<%= PrpLpersonDto1.getFixedIncomeFlag() %>">
                     <input name="prpLpersonFixedIncomeFlagName" class="readonly" readonly style="width:150px" value="<%= PrpLpersonDto1.getFixedIncomeFlagName() %>">
                   
                   </td>
                   <td class="title" style="width:15%">��ҵ:</td>
                   <td class="input" style="width:35%">
                     <input name="prpLpersonJobCode" class="readonly" readonly style="width:90px" value="<%= PrpLpersonDto1.getJobCode() %>">
                     <input name="prpLpersonJobName" class="readonly" readonly style="width:90px" value="<%= PrpLpersonDto1.getJobName() %>">
                   </td>
                 </tr> 
                 
                 <tr>
                   <td class="title" style="width:15%">��Ա����:</td>
                   <td class="input" style="width:35%">             
                     <input type="hidden" name="prpLpersonPayPersonType" class="readonly" readonly style="width:150px" value="<%= PrpLpersonDto1.getPayPersonType() %>">
                     <input name="prpLpersonPayPersonTypeName" class="readonly" readonly style="width:150px" value="<%= PrpLpersonDto1.getPayPersonTypeName() %>">
                   </td>
                   <td class="title" style="width:15%">������Ա:</td> 
                   <td class="input" style="width:35%">
                     <input name="prpLpersonRelatePersonNo" class="readonly" readonly style="width:150px" value="<%= PrpLpersonDto1.getRelatePersonNo() %>">
                   </td>
                 </tr> 
                 
                 <tr>
                   <td class="title" style="width:15%">�˲б���:</td>
                   <td class="input" style="width:35%">
                     <input name="prpLpersonLossRate" class="readonly" readonly style="width:150px" value="<%= PrpLpersonDto1.getLossRate() %>">%
                   </td>
                   <td class="title" style="width:15%">�ұ�:</td>
                   <td class="input" style="width:35%">
                     <input name="prpLpersonCurrencyName" class="readonly" readonly style="width:150px" value="�����">
                     <input name="prpLpersonCurrency" type="hidden" value="CNY">
                   </td>
                 </tr> 
                        <%-- //modify by hanliang add start 20051222 --%>
                             <tr>
                           <td class="title" style="width:15%">��Ժ����:</td>  
                           <td class="input" style="width:35%">
                             <input type="input" name="prpLpersonInHospDate" class="codename" style="width:150px"   ondblclick="return getDateTime(this);" value="<%= PrpLpersonDto1.getInHospDate() %>"> 
                           </td>
                           <td class="title" style="width:15%">��Ժ����:</td>
                           <td class="input" style="width:35%">
                             <input type="input" name="prpLpersonOutHospDate" class="codename" style="width:150px" ondblclick="return getDateTime(this);" value="<%= PrpLpersonDto1.getOutHospDate() %>">
                           </td>
                         </tr>
                            <tr>
                           <td class="title" style="width:15%">��������:</td>
                           <td class="input" style="width:85%" colspan="3">
                             <input type="input" name="prpLpersonRestDate" class="codename" style="width:150px" ondblclick="return getDateTime(this);" value="<%= PrpLpersonDto1.getRestDate() %>">
                           </td>
                         </tr>
                           <tr>
                           <td class="title" style="width:15%">��ҽ���˵��:</td>
                           <td class="input" style="width:85%" colspan="3">
                             <input name="prpLpersonFllowHospRemark" class="input" style="width:350px" maxLength="255" onblur="checkLength1(this);" description="��ҽ���˵��" value="<%= PrpLpersonDto1.getFllowHospRemark() %>">
                           </td>
                         </tr>  
                          <%-- //modify by hanliang add end  20051222 --%>
                 <tr>
                   <td class="title" style="width:15%">��ע:</td>
                   <td class="input" style="width:85%" colspan="3">
                     <input name="prpLpersonRemark" class="readonly" readonly style="width:150px" value="<%= PrpLpersonDto1.getRemark() %>">
                     <input type="hidden" name="prpLpersonPersonNo" value="<%= PrpLpersonDto1.getPersonNo() %>"> 
                   </td>
                 </tr>                
                 <tr> 
                   <td class="common" style="width:100%" colspan="4">
                    <table name="PersonFeeLoss" class="common" style="width:100%" cellpadding="1" cellspacing="1" border="0" bgcolor="#2D8EE1">
                      <tr> 
                        <td class="title" style="width:4%" rowspan="6">�������</td>
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck001" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck001Txt" value="0"></td> 
                        <td class="title" style="width:14%">­������</td>                                                                                      
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck002" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck002Txt" value="0"></td> 
                        <td class="title" style="width:14%">�߹ǹ���</td>                                                                                      
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck003" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck003Txt" value="0"></td> 
                        <td class="title" style="width:14%">��֫����</td>                                                                                      
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck004" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck004Txt" value="0"></td> 
                        <td class="title" style="width:14%">Ƣ������</td>                                                                                      
                      </tr>                                                                                                                                    
                      <tr>                                                                                                                                     
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck005" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck005Txt" value="0"></td> 
                        <td class="title" style="width:14%">��ò����</td>                                                                                      
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck006" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck006Txt" value="0"></td> 
                        <td class="title" style="width:14%">��������</td>                                                                                      
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck007" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck007Txt" value="0"></td> 
                        <td class="title" style="width:14%">�ֲ�����</td>                                                                                      
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck008" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck008Txt" value="0"></td> 
                        <td class="title" style="width:14%">��������</td>                                                                                      
                      </tr>                                                                                                                                    
                      <tr>                                                                                                                                     
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck009" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck009Txt" value="0"></td> 
                        <td class="title" style="width:14%">��������</td>                                                                                      
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck010" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck010Txt" value="0"></td> 
                        <td class="title" style="width:14%">�������</td>                                                                                      
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck011" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck011Txt" value="0"></td> 
                        <td class="title" style="width:14%">�㲿����</td>                                                                                      
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck012" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck012Txt" value="0"></td> 
                        <td class="title" style="width:14%">��������</td>                                                                                       
                      </tr>                                                                                                                                    
                      <tr>                                                                                                                                     
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck013" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck013Txt" value="0"></td> 
                        <td class="title" style="width:14%">��׵����</td>                                                                                      
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck014" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck014Txt" value="0"></td> 
                        <td class="title" style="width:14%">��ǹ���</td>                                                                                      
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck015" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck015Txt" value="0"></td> 
                        <td class="title" style="width:14%">��������</td>                                                                                      
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck016" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck016Txt" value="0"></td> 
                        <td class="title" style="width:14%">������������</td>                                                                                  
                      </tr>                                                                                                                                    
                      <tr>                                                                                                                                      
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck017" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck017Txt" value="0"></td> 
                        <td class="title" style="width:14%">���ǹ���</td>                                                                                      
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck018" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck018Txt" value="0"></td> 
                        <td class="title" style="width:14%">�ɹ�ͷ����</td>                                                                                    
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck019" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck019Txt" value="0"></td> 
                        <td class="title" style="width:14%">�β�����</td>                                                                                      
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck020" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck020Txt" value="0"></td> 
                        <td class="title" style="width:14%">����֯����</td>                                                                                    
                      </tr>                                                                                                                                    
                      <tr>                                                                                                                                     
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck021" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck021Txt" value="0"></td> 
                        <td class="title" style="width:14%">�عǹ���</td>                                                                                      
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck022" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck022Txt" value="0"></td> 
                        <td class="title" style="width:14%">�ϱ۹���</td>                                                                                      
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck023" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck023Txt" value="0"></td> 
                        <td class="title" style="width:14%">��������</td>                                                                                      
                        <td class="title" style="width:10%" align="center"><input type="checkbox" name="woundCodeCheck024" onClick="return woundCodeChange(this);"><input type="hidden" name="woundCodeCheck024Txt" value="0"></td> 
                        <td class="title" style="width:14%">��������</td> 
                      </tr> 
                    </table> 
                   </td> 
                 </tr>  
                           
                <tr>
                <td colspan="4">
                  <span  id="spanPersonFeeLoss" >
                  <%-- ��������չ���� --%>
                  <table id="PersonFeeLoss" name="PersonFeeLoss" cellpadding="5" cellspacing="1">
                    <thead>
                      <tr>
                        <td class="centertitle" colspan=11>
                          ��Ա���������嵥��Ϣ
                        </td>
                      </tr>
                      <tr>
                        <td class="centertitle" style="width:10%">�ձ����</td>
                        <td class="centertitle" style="width:15%">�ձ�����</td>
                        <td class="centertitle" style="width:10%">���ô���</td>
                        <td class="centertitle" style="width:15%">��������</td>
                      <!--<td class="centertitle" style="width:10%">����</td>
                        <td class="centertitle" style="width:10%">����</td>          -->
                        <td class="centertitle" style="width:10%">������</td>
                        <td class="centertitle" style="width:10%">�޳����</td>
                        <td class="centertitle" style="width:10%">������</td>                                            
                      </tr>  
                    </thead>
                    <tfoot>
                    
                    </tfoot> 
                      
                    <tbody>
<%
                    Iterator iterator1 = prpLpersonDto.getPersonList().iterator();
                    while(iterator1.hasNext()){ 
                      PrpLpersonDto PrpLpersonDto2 =  (PrpLpersonDto)iterator1.next();
                      if(PrpLpersonDto2.getPersonNo() == (personNo+1)){

%>                    
                      <tr>   
                        <td class="input">  
                          <input type="hidden" name="personSerialNo" readonly style="width:20px" value="<%= personNo+1 %>"> 
                          <input type="input" name="prpLpersonKindCode" class="readonly" readonly style="width:60px" value="<%= PrpLpersonDto2.getKindCode() %>"
                                ondblclick= "code_CodeSelect(this,'PolicyKindCode');"
                                onchange="code_CodeChange(this, 'PolicyKindCode');"
                                onkeyup= "code_CodeSelect(this,'PolicyKindCode');">         
                        </td>
                        <td class="input">   
                            <input type="input" name="prpLpersonKindName" class="readonly" readonly style="width:80px" value="<%= PrpLpersonDto2.getKindName() %>"
          			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
          			             onchange="code_CodeChange(this, 'PolicyKindCode','-1','name','none','post');"
          			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');">         
                        </td>
          
                        <td class="input">  
                          <input type="input" name="prpLpersonFeeTypeCode" class="readonly" readonly style="width:60px" value="<%= PrpLpersonDto2.getFeeTypeCode() %>">         
                        </td>
                        <td class="input">   
                            <input type="input" name="prpLpersonFeeTypeName" class="readonly" readonly style="width:80px" value="<%= PrpLpersonDto2.getFeeTypeName() %>">         
                        </td>
                       <!--
                        <td class="input">
                          <input name="prpLpersonUnitLoss" title="����" class="readonly" readonly style="width:60px" value="<%= PrpLpersonDto2.getUnitLoss() %>">
                        </td>
                        <td class="input">
                          <input name="prpLpersonQuantity" class="readonly" readonly style="width:60px" value="<%= PrpLpersonDto2.getQuantity() %>">
                        </td>                     -->
                        <td class="input"> 
                          <input name="prpLpersonSumLoss" class="readonly" readonly style="width:60px" value="<%= sf.format(PrpLpersonDto2.getSumLoss()) %>">
                        </td>
                        <td class="input">
                          <input name="prpLpersonSumReject" class="readonly" readonly style="width:60px" value="<%= sf.format(PrpLpersonDto2.getSumReject()) %>">
                        </td>
                        <td class="input">
                          <input name="prpLpersonSumDefLoss" class="readonly" readonly style="width:60px" value="<%= sf.format(PrpLpersonDto2.getSumDefLoss()) %>">
                          <input type="hidden" name="prpLpersonItemKindNo" value="<%= PrpLpersonDto2.getItemKindNo() %>"> 
                          <input type="hidden" name="prpLpersonFamilyNo" value="<%= PrpLpersonDto2.getFamilyNo() %>"> 
                          <input type="hidden" name="prpLpersonItemCode" value="<%= PrpLpersonDto2.getItemCode() %>"> 
                          <input type="hidden" name="prpLpersonUnit" value="<%= PrpLpersonDto2.getUnit() %>"> 
                          <input type="hidden" name="prpLpersonTimes" value="<%= PrpLpersonDto2.getTimes() %>"> 
                          <input type="hidden" name="prpLpersonRejectReason" value="<%= PrpLpersonDto2.getRejectReason() %>">  
                          <input type="hidden" name="prpLpersonVeriUnit" value="<%= PrpLpersonDto2.getVeriUnit() %>"> 
                          <input type="hidden" name="prpLpersonVeriTimes" value="<%= PrpLpersonDto2.getVeriTimes() %>"> 
                          <input type="hidden" name="prpLpersonVeriRejectReason" value="<%= PrpLpersonDto2.getVeriRejectReason() %>"> 
                          <input type="hidden" name="prpLpersonVeriLossRate" value="<%= PrpLpersonDto2.getVeriLossRate() %>"> 
                          <input type="hidden" name="prpLpersonVeriRemark" value="<%= PrpLpersonDto2.getVeriRemark() %>"> 
                          <input type="hidden" name="prpLpersonFlag" value="<%= PrpLpersonDto2.getFlag() %>"> 
                          <input type="hidden" name="prpLpersonCompensateBackFlag" value="<%= PrpLpersonDto2.getCompensateBackFlag() %>"> 
      
                        </td>         
                      </tr>
                       
                      <tr>   
                        <td class="input" colspan="4"></td>
                       <!--
                        <td class="input">
                          <input name="prpLpersonVeriUnitLoss" class="input" style="width:60px" value="<%= PrpLpersonDto2.getVeriUnitLoss() %>">
                        </td>  
                        <td class="input"> 
                          <input name="prpLpersonVeriQuantity" class="input" style="width:60px" value="<%= PrpLpersonDto2.getVeriQuantity() %>">
                        </td>         -->  
                        <td class="input">
                          <input name="prpLpersonVeriSumLoss" class="input" style="width:60px" value="<%= sf.format(PrpLpersonDto2.getVeriSumLoss()) %>" onBlur="return calSumPersonVeriDefLoss(this)"> 
                        </td>
                        <td class="input">
                          <input name="prpLpersonVeriSumReject" class="input" style="width:60px" value="<%= sf.format(PrpLpersonDto2.getVeriSumReject()) %>" onBlur="return calSumPersonVeriDefLoss(this)">
                        </td>
                        <td class="input">
                          <input name="prpLpersonVeriSumDefLoss" class="input" readonly="true"  style="width:60px" value="<%= sf.format(PrpLpersonDto2.getVeriSumDefLoss()) %>">
                        </td>         
                      </tr>
<%
    }
  }
%>            
                    </tbody> 
                  </table>  
                </span>  
              </td>
            </tr>  
    <tr>
      <td class='title' width="30%">������:<input class='readonly' readonly="true" style='width:80px' name='prpLpersonSumLossSum'>
      </td>    
      <td class='title' width="30%">�޳����:<input class='readonly'  readonly="true" style='width:80px' name='prpLpersonSumRejectSum'>
      </td>   
      <td class='title' colspan="2" width="40%">������:<input class='readonly'  readonly="true" style='width:80px' name='prpLpersonSumDefLossSum'>
      </td>     
    </tr>
        </table>
      </td>                    
   </tr> 


<%
        personNo =   PrpLpersonDto1.getPersonNo();
        }
      }
    }
%>

         </tbody>
       </table>  
       
     </span>    
   </td>
 </tr> 
</table>
</span>  























