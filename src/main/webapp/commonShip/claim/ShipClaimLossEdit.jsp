<%--
****************************************************************************
* DESC       ����ʾ�����Ǽǵ��ձ������ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-06-24
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.claim.dto.domain.PrpCitemKindDto"%>
<%@page import="com.sinosoft.function.insutil.dto.domain.PrpDexchDto"%>
<%@page import="java.util.*"%>


<script language="javascript">
//add by zhaolu 20060908 start
   	/**
     *�����������ӹ���������ڱ������
     */
     function checkBeyondSumAmount(field)
     {
        var sumAmount = 0;
        var feeSumClaim = 0;
        var errorMessage = "";
        var findex = getElementOrder(field)-1;
        sumAmount = parseFloat(fm.prpLclaimLossItemAmount[findex].value);
        feeSumClaim = parseFloat(field.value);
         if(parseFloat(fm.prpLclaimSumClaim.value)>parseFloat(fm.prpLclaimSumAmount.value)){
            alert("������֮�Ͳ��ܴ����ܱ��");
            fm.prpLclaimSumClaim.value = 0;
            field.select();
            return false;
       }
        if( feeSumClaim > sumAmount )
        {
          errorMessage = "�ձ������ܴ��ڱ��� ";
          alert(errorMessage);
          field.select();
          return false;
        }
        return true;
        
     }
      //add by zhaolu 20060908 end   	 
    
    //add by kangzhen  ��fm.prpLclaimLossKindCode��ֵ
    function setPrpLclaimLossKindCode()
    {
    	for( var j=1;j<fm.prpLclaimLossCurrency.length;j++)
 	    {
 	    	fm.prpLclaimLossKindCode[j].value = fm.prpLclaimLossItemCode[j].value;
 	    }
    }
   </script>	 

<%
     //�һ�����Ϣд�������� 2005-09-05
      PrpDexchDto prpDexchDto;
      Collection prpdexchDtoList = (Collection)request.getAttribute("prpdexchDtoList");
      if(prpdexchDtoList!=null)
      {
          Iterator itprpdexch = prpdexchDtoList.iterator();
          while(itprpdexch.hasNext())
          {
              prpDexchDto =  (PrpDexchDto)itprpdexch.next();
              out.println("  <input type=\"hidden\" name=\"baseCurrency\""+
                " value=\""+prpDexchDto.getBaseCurrency()+"\""+"\">");
              out.println("  <input type=\"hidden\" name=\"exchCurrency\""+
                " value=\""+prpDexchDto.getExchCurrency()+"\""+"\">");
              out.println("  <input type=\"hidden\" name=\"exchRate\""+
                " value=\""+prpDexchDto.getExchRate()+"\""+"\">");                
          }
      }   
%>

<script language="javascript">    
var damageKind = new Array();
<%
   String kindCode = "";
   PrpCitemKindDto prpCitemKindDto;
   ArrayList damageKindList = (ArrayList)request.getAttribute("damageKindList");  
   for(int k=0;k<damageKindList.size();k++)
   {
       prpCitemKindDto = (PrpCitemKindDto)damageKindList.get(k);
       kindCode = prpCitemKindDto.getKindCode();
%>  
       damageKind[<%=k%>]   ='<%=kindCode%>';
<%
    }
%>      

  function judgeKindCode(Field)
{
     var findFlag = 0;
     var fieldname=Field.name;
     var i = 0;
     var findex=0;
     for(i=1;i<fm.all(fieldname).length;i++)
     {
        if( fm.all(fieldname)[i] == Field )
        {
           findex=i;
           break;
        }
     } 
     var strValue = fm.prpLclaimLossKindCode[findex].value;
     //�ж�ѡ����ձ��Ƿ�Ϊ�������ڵ�ʱ��Ч���ձ�
     for (var j=0;j<damageKind.length;j++)
     {
        if(damageKind[j]==strValue)
        { 
            findFlag = 1;
            break;
        }
     }
     if(findFlag==0)
     {
         alert("��ѡ����ձ��ǳ�������ʱ���ձ�,�����½���ѡ��");
         fm.prpLclaimLossKindCode[findex].value = "";
         return false;
     } 
}
</script>  



<!--������ʾ��¼����������������ʾ��-->
<table class="common" align="center" width="100%" >
 <!--��ʾ��ʾ���е�-->
 <tr >
   <td class="subformtitle" colspan="4" style="text-align:left">
     <img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
          name="ClaimLossImg" onclick="showPage(this,spanClaimLoss)">
          �ձ��������Ϣ<font color="#FF0000">*</font><br>
     <span style="display:none">
       <table class="common" style="display:none" id="ClaimLoss_Data" cellspacing="1" cellpadding="0">
         <tbody>
         <tr>
<%
      //modify by lixiang add 20050316 start
      //reason:���������
%>
      		<td class="input" style="width:4%" style="align:center">
                  <input name="prpLclaimLossItemKindNo" type="text" class="readonly" readonly="readonly" title="������">
              </td>
             <td class="input" style="width:26%" style="align:center">
                 <input type="hidden" name="prpLclaimLossKindCode" class="codecode" style="width:20%" title="�ձ����" value=<bean:write name='defaultKindCode'/>
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode','1,2');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode','1,2');"
                      onchange="judgeKindCode(this);setFlagDanger();">
                 <input type="hidden" name="prpLclaimLossKindName" class="codecode" style="width:70%" title="�ձ�����"
                      ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,1','always','none','post');"
                      onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,1','always','none','post');"
                      onchange="judgeKindCode(this);setFlagDanger();">
                 <input type='input' name='prpLclaimLossItemCode' class="codecode" style="width:20%" title="��Ĵ���"
                            ondblclick="code_CodeSelect(this, 'PolicyKindCode','1,-3,2,3,4','code','none','post');" 
                            onkeyup= "code_CodeSelect(this, 'PolicyKindCode','1,-3,2,3,4','code','none','post');" 
                            onchange="judgeKindCode(this);setFlagDanger();"> 
                 <input type='input' name="prpLclaimLossItemDetailName" class="codename"  style="width:70%" title="�������"
                            ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-4,1,2,3','always','none','post');"
        		    		onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-4,1,2,3','always','none','post');" >                                                                        
                 
                 <input type='hidden' name='prpLclaimLossItemCode' class="codecode">
                 <input type='hidden' name="prpLclaimLossItemDetailName" class="codename">
                 <input name="prpLclaimLossItemAmount" type="hidden" value="">

              </td>

             <td class="input" style="width:20%" align="center">
             	<!-- 
                 <input name="prpLclaimLossItemCode" type="hidden">
                -->
                 <input type="text" name="prpLclaimLossCurrency" value="<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' />" class="codecode" style="width:30%" title="�ұ�"
                                    ondblclick="code_CodeSelect(this, 'Currency');"
                                    onkeyup= "code_CodeSelect(this, 'Currency');">
                  <input type=text name="prpLclaimLossCurrencyName" class="codecode" style="width:60%" title="�ұ�"  value="<bean:write name='strCurrencyName'  filter='true' />"
                                     ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                                     onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">
             </td>

             <td class="input" style="width:10%" >
            <%/*
             <html:select name='claimLoss'  property='flag' style="width:60px" >
                  <html:option value="0" selected >����</html:option>
                  <html:option value="1">����</html:option>
             </html:select>
            */%>
             <select name="prpLclaimLossLossFeeType">
                       <option value="P">���</option>
                       <option value="Z">����</option>
             </select>  
            <input type="hidden" name="prpLclaimLossFlag" class="input" readonly="true" style="width:60%" value="1">
            <input name="prpLclaimLossFeeCategory" type="hidden" value="">
             </td>
             <td class="input" style="width:16%">
                 <input name="prpLclaimLossSumClaim" class=common style="text-align:right" onblur=" collectClaimLoss();setPrpLclaimLossKindCode();return checkBeyondSumAmount(this);"
                 onchange="setFlagDanger();">
             </td>
             
             
             
             <td class="input" style="width:8%">                
                  <input name="prpLclaimLossKindRest" class=common style="width:50px">
           </td> 
             
             <td class="input" style="width:10%">
                 <input name="prpLclaimLossInputDate" onblur="checkFullDate(this)"  style="width:85px" maxlength="10" class=readonly readonly="readonly"
                   value="<%= new com.sinosoft.sysframework.common.datatype.DateTime(com.sinosoft.sysframework.common.datatype.DateTime.current().toString(), com.sinosoft.sysframework.common.datatype.DateTime.YEAR_TO_DAY) %>">
                   <!--
                 <input name="prpLclaimLossInputDate" class="readonly" readonly style="width:85px" maxlength="10" >
                   -->
             </td>
             <td class="input" style="width:10%">
                 <input name="prpLclaimLossRemarkFlag" class="input" maxlength="100">
             </td>

             <td class="input" style='width:4%' colspan="2" align="center">
                 <div>
                   <input  name="buttonClaimLossDelete"  type="button" class="smallbutton" onclick="deleteRow(this,'ClaimLoss');collectClaimLoss();setFlagDanger();" value="-" style="cursor: hand"  >
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
         	  <td class="centertitle" style="width:4%">������</td>
              <td class="centertitle" style="width:26%">��Ŀ</td>
              <td class="centertitle" style="width:20%">�ұ�</td>
              <td class="centertitle" style="width:10%">�������</td>
              <td class="centertitle" style="width:16%">�ձ������</td>
              <td class="centertitle" style="width:8%">��ֵ</td>
              <td class="centertitle" style="width:10%">��������</td>
              <td class="centertitle" style="width:10%">����ԭ��</td>
              <td  class="centertitle"  style="width:4%">
                 <input onclick="collectCurrency();"  type="button" class="button" value="����">
              </td>
         </tr>
       </thead>
       <tfoot>
         <!--modify by zhulei 20050903 �鿴ҳ�棬��ťҪ�ҵ����������Ҫ�޸ģ���ע���Ӧ��ClaimEdit��Ҫȥ��disabledAllButton(ClaimLoss_button)������-->
         <tr><td colspan="7"><table id="ClaimLoss_button" style="width:100%">
           <tr>
             <td class="title" colspan=6 style="width:91%">(��"+"�ż����ӵ�֤��Ϣ����"-"�ż�ɾ����Ϣ)</td>
             <td class="title" align="middle" style="width:9%">
                <div align="center">
                   <input type="button" value="+" class="smallbutton" onclick="insertRow('ClaimLoss');setFlagDanger();" name="buttonDriverInsert" style="cursor: hand"  >
                </div>
             </td>
           </tr>
         </table></td></tr>
      </tfoot>

    <tbody>
 <% int indexClaimLoss=0;%>
 <% String displayType="readonly"; %>
 <% String buttonType="disabled"; %>

 <%
  if (editType.equals("ADD")){
  displayType="";
  buttonType="";}
  if (editType.equals("EDIT")){
  displayType="";
  buttonType="disabled";}
%>  
    <logic:notEmpty  name="prpLclaimLossDto"  property="claimLossList">
    <logic:iterate id="claimLoss" name="prpLclaimLossDto" property="claimLossList">
<%
    if(indexClaimLoss %2== 0)
        out.print("<tr class=oddrow>");
    else
        out.print("<tr class=oddrow>");
%>
       <td class="input" style="width:4%" style="align:center">
                 <input type="text" class="readonly" readonly="readonly" title="������" name="prpLclaimLossItemKindNo"   value="<bean:write name='claimLoss' property='itemKindNo'/>">
         </td>
       <td class="input" style="width:26%" style="align:center">
                 <input type="hidden" name="prpLclaimLossKindCode" class="codecode" <%=displayType%> style="width:20%" title="�ձ����"
                      <%if (editType.equals("ADD")||editType.equals("EDIT")){%>
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode', '1,2');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode', '1,2');"
                      onchange="setFlagDanger();"
                      <%}%>
                      value="<bean:write name='claimLoss' property='kindCode'/>">
                 <input type="hidden" prpLclaimLossKindName" class="codecode" <%=displayType%> style="width:70%" title="�ձ�����"
                      <%if (editType.equals("ADD")||editType.equals("EDIT")){%>
                      ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,1','always','none','post');"
                      onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,1','always','none','post');"
                      onchange="setFlagDanger();"
                       <%}%>
                      value="<bean:write name='claimLoss' property='kindName'/>">
               
               <input type='input' name='prpLclaimLossItemCode' class="codecode" style="width:20%" title="��Ĵ���" value="<bean:write name='claimLoss' property='itemCode' filter='true'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyKindCode','1,-3,2,3,4','code','none','post');"
                            onkeyup= "code_CodeSelect(this, 'PolicyKindCode','1,-3,2,3,4','code','none','post');">
               <input type='input' name="prpLclaimLossItemDetailName" class="codename"  style="width:70%" title="�������" value="<bean:write name='claimLoss' property='itemDetailName' filter='true'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-4,1,2,3','always','none','post');"
        		    onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-4,1,2,3','always','none','post');">
                  
                 <input type="hidden" name="prpLclaimLossItemKindNo"   value="<bean:write name='claimLoss' property='itemKindNo'/>">
                 <input type='hidden' name='prpLclaimLossItemCode' class="codecode">
                 <input type='hidden' name="prpLclaimLossItemDetailName" class="codename">
                 <input name="prpLclaimLossItemAmount" type="hidden" value="<bean:write name='claimLoss' property='itemAmount'/>">
         </td>
         <td class="input" style="width:20%" align="center">
              <input type=text name="prpLclaimLossCurrency" class="codecode"  style="width:30%" title="�ұ�" value="<bean:write name='claimLoss' property='currency'/>"
               ondblclick= "code_CodeSelect(this,'Currency');"
               onkeyup= "code_CodeSelect(this,'Currency');">
              <input type=text name="prpLclaimLossCurrencyName" class="codecode"  style="width:60%" title="�ұ�"  value="<bean:write name='claimLoss' property='currencyName'/>"
               ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
               onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">
              <!-- 
             <input type="hidden" name="prpLclaimLossItemCode"   value="<bean:write name='claimLoss' property='itemCode'/>">
             -->
         </td>


         <td class="input" style="width:10%" >
          <%/*
         <html:select name='claimLoss' disabled property='flag' style="width:60px" >
             <html:option value="0" >����</html:option>
             <html:option value="1">����</html:option>
         </html:select>
         */%>
          <select name="prpLclaimLossLossFeeType">
                 <option value="P" <logic:equal name="claimLoss" property="lossFeeType" value='P'>selected</logic:equal>>���</option>
                 <option value="Z" <logic:equal name="claimLoss" property="lossFeeType" value='Z'>selected</logic:equal>>����</option>
          </select>
         <input type="hidden" name="prpLclaimLossFlag" class="input" readonly="true" style="width:60%" value="1">
         <input name="prpLclaimLossFeeCategory" type="hidden" value="<bean:write name='claimLoss' property='feeCategory' filter='true' />">
         </td>
         <td class="input" style="width:16%">
             <input name="prpLclaimLossSumClaim" class=common <%=displayType%> style="text-align:right" value="<bean:write name='claimLoss' property='sumClaim' format="0.00" />"  onblur=" collectClaimLoss();dutySum();setPrpLclaimLossKindCode();return checkBeyondSumAmount(this);"
             onchange="setFlagDanger();">
         </td>
         
         <td class="input" style="width:8%">                
                  <input name="prpLclaimLossKindRest" class=common style="width:50px">
         </td> 
         <td class="input" style="width:10%">
             <input name="prpLclaimLossInputDate" readonly onblur="checkFullDate(this)" style="width:85px" maxlength="10" value="<bean:write name='claimLoss' property='inputDate' />">
         </td>
         <td class="input" style="width:10%">
             <input name="prpLclaimLossRemarkFlag" class="input" maxlength="100" value="<bean:write name='claimLoss' property='remarkFlag' />">
         </td>
 <%//modify by lixiang add 20050316 end%>
          <td class="input" style='width:4%' align="center">
              <div>
                <input  name="buttonClaimLossDelete" <%=buttonType%> type="button" class="smallbutton" onclick="deleteRow(this,'ClaimLoss');collectClaimLoss();setFlagDanger();" <%=buttonType%> value="-" style="cursor: hand" >
              </div>
          </td>
       </tr>
 <%    indexClaimLoss++;%>
       </logic:iterate>
       </logic:notEmpty>
       </tbody>
     </table>
    </span>
   </td>
  </tr>
</table>