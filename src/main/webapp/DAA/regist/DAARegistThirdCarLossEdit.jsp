<%--
****************************************************************************
* DESC       �������ʧ��λ��Ϣҳ��
* AUTHOR     ��liubvo
* CREATEDATE �� 2004-12-07
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
****************************************************************************
--%>
   <!--������ʾ��¼����������������ʾ��-->
   
    <script language='javascript'>
		   <!--    
      //��������뱾ҳ�Զ����JavaScript����

      /*
        ����һ���µ�֮��Ĵ�����ѡ������ 
      */
      function afterInsertThirdCarLoss()
      {
        setPrpLthirdCarLossSerialNo();
      }
    
      /*
        ɾ������WarnRegion֮��Ĵ�����ѡ������
      */
      function afterDeleteThirdCarLoss(field)
      {         
        setPrpLthirdCarLossSerialNo();
      }
     
      /** 
       * ����setPrpLthirdCarLossSerialNo
       */
      function setPrpLthirdCarLossSerialNo(){
        var count=getElementCount("prpLthirdCarLossSerialNo");
        for(var i=0;i<count;i++)
        {
          //alert("����ʲôʱ������?count="+count+"  i="+i); 
          if(count!=1){
              fm.prpLthirdCarLossSerialNo[i].value=i;
          } 
        } 
      }   
		   //-->      
    </script>   
    
   <table class="common" cellspacing="1" cellpadding="5">
    <!--��ʾ��ʾ���е�--> 
    <tr>
      <td class="common" colspan="4">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="ThirdCarLossImg" onclick="showPage(this,spanThirdCarLoss)">
             ��ʧ��λ<br>
        <span style="display:none"> 
          <table class="common" style="display:none" id="ThirdCarLoss_Data" cellspacing="1" cellpadding="5">
            <tbody>
              <tr>
                  <td class="input"> 
                  <input type="hidden"  name="prpLthirdCarLossFlag">
                  <input type="hidden"  name="prpLthirdCarLossSerialNo" description="���">
                  <input name="prpLthirdCarLossItemNo" class="readonly" readonly style="width:75%" maxlength=3 value="1">
                   <img src="/claim/images/bgMarkMustInput.jpg">    
                </td>
                <td class="input">
                  <input name="prpLthirdCarLossLicenseNo" class="readonly" readonly style="width:90%" value="<bean:write name='prpLregistDto' property='licenseNo' filter='true' />">
                </td>
                <!--Modify by chenrenda update begin 20050406-->
                <td class="input">
                  <html:select name="prpLthirdCarLossDto" property="partCode" styleClass="three" style="width:120px" >
                    <html:options  collection="partCodeList" property="value" labelProperty="label"/>
                  </html:select>
                  <input type="hidden" name="partName">
                </td>    
                <!--<td class="input"> 
                  <input name="prpLthirdCarLossCompCode" class="codecode" style="width:60%"                  
                      ondblclick= "code_CodeSelect(this,'CarPartCode');"
                      onkeyup= "code_CodeSelect(this,'CarPartCode');">
                       <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">
                       <img src="/claim/images/bgMarkMustInput.jpg">    
                </td>-->
                <td class="input">
                  <input name="compName" class="codename" style="width:90%"  			             
                     ondblclick="return openCompCodeWin(ThirdCarLoss_Data,this);">  
                     <input type="hidden" name="compCode">
                </td>
                <!--Modify by chenrenda update end 20050406-->
                <td class="input"> 
                  <input name="prpLthirdCarLossLossGrade" class="input" style="width:90%">
                </td>
                <td class="input">
                  <input name="prpLthirdCarLossLossDesc" class="input" style="width:90%">
                </td> 
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type=button name="buttonThirdCarLossDelete"  class="smallbutton" onclick="deleteRow(this,'ThirdCarLoss')" value="-" style="cursor: hand">
                </div>
                </td>
              </tr>
              
            </tbody>
          </table>
        </span>
        
        
        <span  id="spanThirdCarLoss" style="display:none" cellspacing="1" cellpadding="0">
        <%-- ��������չ���� --%>
        <table class="common" style="width:100%" id="ThirdCarLoss" cellspacing="1" cellpadding="5">
          <thead>
            <tr>
                <td class="centertitle" >��ʧ��Ŀ���</td>
                <td class="centertitle" >���ƺ�</td>
                <td class="centertitle" >��ʧ��λ</td>
                <td class="centertitle" >���(��Ŀ)����</td>
                <td class="centertitle" >��ʧ�̶ȼ���</td>
                <td class="centertitle" style="width:21%">��ʧ�̶�����</td>
              <td class="centertitle" style="width:4%" >&nbsp;</td> 
            </tr>
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan=6 >(��"+"�ż�������ʧ��λ��Ϣ����"-"�ż�ɾ����Ϣ)</td>
                 <td class="title" align="right" style="width:4%">
                 <div align="center">
                 <input type="button" value="+" class=smallbutton onclick="insertRow('ThirdCarLoss')" name="buttonDriverInsert" style="cursor: hand">
                 </div>
                 </td>
              </tr>
           </tfoot> 
          </tfoot>
          <tbody>
 <% int indexThirdCarLoss=0;%>
<logic:notEmpty  name="prpLthirdCarLossDto"  property="thirdCarLossList"> 
<logic:iterate id="thirdCarLossdtox" name="prpLthirdCarLossDto" property="thirdCarLossList">
              <tr>
                <td class="input"> 
                  <input type="hidden"  name="prpLthirdCarLossFlag" value="<bean:write name='thirdCarLossdtox' property='flag'/>">
                  <input type="hidden"  name="prpLthirdCarLossSerialNo" description="���" value="<bean:write name='thirdCarLossdtox' property='serialNo'/>">
                  <input name="prpLthirdCarLossItemNo" class="readonly" readonly style="width:75%" maxlength=3 value="<bean:write name='thirdCarLossdtox' property='itemNo'/>">
                   <img src="/claim/images/bgMarkMustInput.jpg">    
                </td> 
                <td class="input">
                  <input name="prpLthirdCarLossLicenseNo" class="readonly" readonly  style="width:90%" value="<bean:write name='thirdCarLossdtox' property='licenseNo'/>">
                </td>
                <!--Modify by chenrenda update begin 20050406-->
                <!--Reason:���ݴ��������ʧ��λ��ʾΪ�б�ʽ,��ʾ�������-->
                <td class="input">
                  <html:select name="thirdCarLossdtox" property="partCode" styleClass="three" style="width:120px" >
                    <html:options  collection="partCodeList" property="value" labelProperty="label"/>
                  </html:select>
                  <input type="hidden"  name="partName"  value="<bean:write name='thirdCarLossdtox' property='partName'/>">
                </td>    
                <!--
                <td class="input">
                  <input name="prpLthirdCarLossCompCode" class="codecode" style="width:60%" value="<bean:write name='thirdCarLossdtox' property='compCode'/>"          
                      ondblclick= "code_CodeSelect(this,'CarPartCode');"
                      onkeyup= "code_CodeSelect(this,'CarPartCode');"> 
                      <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle"> 
                       <img src="/claim/images/bgMarkMustInput.jpg">   
                </td>
                -->
                <td class="input">
                  <input name="compName" class="codename" style="width:90%" value="<bean:write name='thirdCarLossdtox' property='compName'/>" 			             
                     ondblclick="return openCompCodeWin(ThirdCarLoss,this);">  
                  <input type="hidden"  name="compCode"  value="<bean:write name='thirdCarLossdtox' property='compCode'/>">
                </td>
                 <!--Modify by chenrenda update end 20050406-->
                <td class="input"> 
                  <input name="prpLthirdCarLossLossGrade" class="input" style="width:90%" value="<bean:write name='thirdCarLossdtox' property='lossGrade'/>">
                </td>
                <td class="input">
                  <input name="prpLthirdCarLossLossDesc" class="input" style="width:90%" value="<bean:write name='thirdCarLossdtox' property='lossDesc'/>">
                </td>
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type=button name="buttonThirdCarLossDelete"  class=smallbutton onclick="deleteRow(this,'ThirdCarLoss')" value="-" style="cursor: hand">
                </div>
                </td>
              </tr>
 <%    indexThirdCarLoss++;%>
      </logic:iterate>
      </logic:notEmpty>         
          </tbody>
        </table>  
        </span>    
      </td>
    </tr>
  </table>



  
  



