<%--
****************************************************************************
* DESC       ���⸶�����Ϣҳ��
* AUTHOR     ��liubvo
* CREATEDATE �� 2004-10-18
* MODIFYLIST ��   Name       Date            Reason/Contents
*               qinyongli    2005-9-1        ���������ձ��ĵ��ж�
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.function.insutil.dto.domain.PrpDexchDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpCitemKindDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLlossDto"%>
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.claim.dto.custom.ClaimDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLclaimDto"%>

<script language="javascript">    
var damageKind = new Array();
var damageItemKind = new Array();
var damageItemAmount = new Array();
var damageItemAmountDisplay = new Array();
<%
   String kindCode = "";
   String itemKind = "";
   double itemAmount= 0.00;
   String itemAmountDisplay= "";
   PrpCitemKindDto prpCitemKindDto; 
   String strEditType=request.getParameter("editType");
   String strRiskCode = (String)request.getAttribute("riskCode");
   String familyNo = "";
   ArrayList damageKindList = (ArrayList)request.getAttribute("prpCitemKindList");
   PrpLlossDto prpLlossDto = (PrpLlossDto)request.getAttribute("prpLlossDto");
   PrpLclaimDto prpLclaimDtoTemp = (PrpLclaimDto)request.getAttribute("prpLclaimDto");
   if(null != prpLclaimDtoTemp){
   		request.setAttribute("prpLclaimDtoTemp", prpLclaimDtoTemp);
   		familyNo = ""+prpLclaimDtoTemp.getRemark();
   }
   //if(null!=prpLlossDto && prpLlossDto.getPrpLlossList().size()>0){
   //		Collection prpLlossList = prpLlossDto.getPrpLlossList();
   //		PrpLlossDto prpLlossDtoTemp = (PrpLlossDto)prpLlossList.toArray()[0];
   //		request.setAttribute("prpLlossDtoTemp", prpLlossDtoTemp);
   //		familyNo = ""+prpLlossDtoTemp.getFamilyNo();
   //}
   for(int k=0;k<damageKindList.size();k++)
   {
       prpCitemKindDto = (PrpCitemKindDto)damageKindList.get(k);
       kindCode = prpCitemKindDto.getKindCode();
       itemKind = prpCitemKindDto.getItemCode();
       itemAmount = prpCitemKindDto.getAmount();
       itemAmountDisplay = NumberFormat.getInstance().format(prpCitemKindDto.getAmount());
%>  
       damageKind[<%=k%>]  ='<%=kindCode%>';
       damageItemKind[<%=k%>] ='<%=itemKind%>';
       damageItemAmount[<%=k%>] ='<%=itemAmount%>';
       damageItemAmountDisplay[<%=k%>] ='<%=itemAmountDisplay%>';
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
     var strValue = fm.prpLlossDtoKindCode[findex].value;
     var strValueitem = fm.prpLlossDtoItemCode[findex].value;
     //�ж�ѡ����ձ��Ƿ�Ϊ�������ڵ�ʱ��Ч���ձ���߱��
    /*
     for (var j=0;j<damageKind.length;j++)
     { 
        if(strValueitem==""||damageKind[j]==strValue&&damageItemKind[j]==strValueitem)
        { 
            fm.prpLlossDtoAmount[findex].value = damageItemAmount[j];     //���ɱ������ʱ�ı���
            fm.prpLlossDtoAmountDisplay[findex].value = damageItemAmountDisplay[j];     //��ʾ��
            findFlag = 1;
            break;
        }
     }
     if(findFlag==0)
     {
         alert("��ѡ����ձ���߱�Ĳ��ǳ�������ʱ���ձ���߱��,�����½���ѡ��");
         fm.prpLlossDtoKindCode[findex].value = "";
         fm.prpLlossDtoItemCode[findex].value = "";
         return false;
     } 
     */
}
</script>  
    <%--���������Զ���JavaScript������--%>
        <%--���������Զ���JavaScript������--%>
 
    <script language="javascript">
      //��������뱾ҳ�Զ����JavaScript����
 
        /*
        ����һ���µ�lLoss֮��Ĵ�������ѡ������
      */
      function afterInsertlLoss()
      {
        setPrpLlossDtoSerialNo();
      }
    
      /*
        ɾ������WarnRegion֮��Ĵ�������ѡ������
      */
      function afterDeletelLoss(field)
      {
        
        setPrpLlossDtoSerialNo();
      }
    
        /**
         * ����setPrpLlossDtoSerialNo
         */
        function setPrpLlossDtoSerialNo(){
            var count=getElementCount("prpLlossDtoSerialNo");
            for(var i=0;i<count;i++)
            {
                //alert("����ʲôʱ������?count="+count+"  i="+i); 
                if(count!=1){
                    fm.prpLlossDtoSerialNo[i].value=i;
                }
            }
        }
        
        
       function isRightDutyPercent(field){
        var lPercent=0;
        var strmsg="";
        var i=0;

         lPercent=parseFloat(field.value);
         if ((lPercent>100)||(lPercent<0))
         {
            strmsg="�⸶�������ܴ���100����С��0!";
            alert(strmsg);
            field.select();
            field.focus();
            return false;
         }
            return true;
      }
      function getInsuredAmount(Field){
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
      	var itemCode = fm.prpLlossDtoItemCode[findex].value;
      	var kindCode = fm.prpLlossDtoKindCode[findex].value;
      	var familyNo = fm.prpLlossDtoFamilyNo[1].value;
      	var familyName = fm.prpLlossFamilyName[findex].value;
      	var damageTime = fm.prpLcompensateDamageStartDate[1].value;
      	if(null!=itemCode || ""!=itemCode || null!=kindCode || ""!=kindCode || ""!=familyNo || null!=familyNo){
      		var policyNo = fm.prpLcompensatePolicyNo.value;
      		var strPage = "/claim/ZH03/compensate/PropZH03GetInsuredAmount.jsp?policyNo="
				+ policyNo + "&itemCode=" + itemCode+"&kindCode="
				+ kindCode + "&familyNo=" + familyNo+ "&familyName=" + familyName+"&damageTime="+damageTime;
  			var strText = getResponseXmlText(strPage);
  			if(null!=strText && ""!=strText){
  				strText = strText.replace(/^\s+|\s+$/g,"");
  				var itemAmount = strText;
  				fm.prpLlossDtoAmountDisplay[findex].value = itemAmount;
  				fm.prpLlossDtoAmount[findex].value = itemAmount;
  			}
      	}
      }
      function displayOrNot(Field){
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
      	var itemCode = fm.prpLlossDtoItemCode[findex].value;
      	var kindCode = fm.prpLlossDtoKindCode[findex].value;
      	if(kindCode.indexOf("2742")>-1){//�������������˺�����
      		//fm.tdPrpLlossFamilyName[findex].style = "display:display";
      		fm.prpLlossFamilyName[findex].value = "";
      	}else{
      		//fm.tdPrpLlossFamilyName[findex].style = "display:none";
      		fm.prpLlossFamilyName[findex].value = "";
      	}
      }
	function getResponseXmlText(strURL){
	  var objXmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	  objXmlHttp.Open("POST",strURL,false);
	  objXmlHttp.setRequestHeader("Content-type","text/xml");
	  objXmlHttp.Send("");
	  if(objXmlHttp.status==200)
	  {
	    return objXmlHttp.responseText;
	  }
	  else if(objXmlHttp.status==404)
	  {
	    alert("�Ҳ���ҳ�棺"+ strURL);
	    return "";
	  }
	  else
	  {
	    alert("����"+ strURL +"����������ţ�"+objXmlHttp.status);
	    return "";
	  }
	}
    </script>   
    
   <!--������ʾ��¼����������������ʾ��-->
   
 
   
   
   
   <table class="common" align="center">
    <!--��ʾ��ʾ���е�-->
    
    <%
     //�һ�������д��������
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
    <tr>
      <td class="subformtitle" colspan="4" style="text-align:left">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="lLossImg" onclick="showPage(this,spanlLoss)">�⸶�����Ϣ<br>
        <span style="display:none"> 
          <table class="common" style="display:none" id="lLoss_Data" cellspacing="1" cellpadding="0">
            <tbody>
              <tr>
              <td class="input" style="width:4%">
                 <div align="center">
                   <input class="readonlyNo" readonly name="prpLlossDtoSerialNo" description="���">
                 </div>
             </td>
             <td class="subformtitle"  style="width:92%">   
                 <table  cellpadding="0" cellspacing="1" class="common" style="width:100%">
                    <!--�Ƿ񳬹������е��޶��־��-->
                    <!-- input type="hidden" name="prpLlossDtoOverAmount" -->  
                    <input type='hidden' name="prpLlossDtoLicenseNo">
                    <input type='hidden' name='prpLlossDtoFamilyNo' > 
                    <input type='hidden' name="prpLlossDtoFeeTypeCode">
                    <input type='hidden' name="prpLlossDtoFeeTypeName"> 
                    <input type='hidden' name='prpLlossDtoFamilyName'> 
                    <input type='hidden' name='prpLlossDtoItemAddress'> 
                    <input type='hidden' name='prpLlossDtoBuyDate' value="2004/12/12"> 
                    <input type='hidden' name='prpLlossDtoDepreRate'> 
                    <input type='hidden' name='prpLlossDtoCurrency1' value="<bean:write name='prpLcompensateDto' property='currency' />"> 
                    <input type='hidden' name='prpLlossDtoCurrency4' value="<bean:write name='prpLcompensateDto' property='currency' />"> 
                    <input type='hidden' name='prpLlossDtoFlag'> 
                    <input type='hidden' name='prpLlossDtoUnit'> 
                    <input type="hidden" name="prpLlossDtoLossQuantity">                  
                    <input type="hidden" name="prpLlossDtoUnitPrice">               
                    <input type="hidden" name="prpLlossDtoIndemnityDutyRate">  
                    <tr>                             
                        <td class="title" style="width:15%">����ţ�</td> 
                        <td class="input" style="width:35%" colspan="3">
                          <input type="input" readonly="readonly" class="readonly" name="prpLlossFamilyNo" style="width:80" value="<bean:write name='prpLclaimDtoTemp' property='remark' />"/>                  
                        </td>                
                    </tr> 
                   <tr>                             
                        <td class="title" style="width:15%">�����ţ�</td> 
                        <td class="input" style="width:35%" colspan="3">
                          <input type="input" name=prpLlossDtoItemKindNo class="readonly" readonly="readonly" style="width:40"                            
                            onchange="setFlagDanger();"/>                 
                        </td> 
                    </tr>
                    <tr>
                        <td class="title" style="width:15%">�ձ�</td> 
                        <td class="input" style="width:35%" colspan="3">
                          <input type="input" name=prpLlossDtoKindCode class="codecode" style="width:40" 
                            ondblclick="code_CodeSelect(this, 'PolicyKindCode','1,-1,3,4','code','none','post');"
                            onblur=""
                            onkeyup= "code_CodeSelect(this, 'PolicyKindCode','1,-1,3,4','code','none','post');"
                            onchange="setFlagDanger();">                 
                          <input type="input" name=prpLlossDtoKindName class="codename" style="width:110" 
        		    ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2,2,3','always','none','post');"
        		    onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2,2,3','always','none','post');"
        		    onchange="setFlagDanger();" > 
                          <input type='hidden' name='prpLlossItemKindNo'> 
                          <img src="/claim/images/bgMarkMustInput.jpg">                                                    
                        </td> 
 					</tr>
 					<%if ("EDIT".equals(editType) || "ADD".equals(editType)){%>
          				<tr>                 
	                        <td class="title" style="width:15%">��ʧ��ģ�</td>                                                                   
	                        <td class="input" style="width:85%" colspan="3">
	                          <input type='text' name='prpLlossDtoItemCode' class='readonly' style="width:40" 
	                            onpropertychange="getInsuredAmount(this);"> 
	                          <input name="prpLlossDtoLossName" class='readonly' style="width:330px"  
	                            onchange="">
	                        </td>                                  
                      </tr>
 					 <tr>
 					 	<td class="title" style="width:15%, display:display" name="tdPrpLlossFamilyName">�¹������ƣ�</td> 
                 		<td class="input" style="width:35%" colspan="3">
			               <input type=text name="prpLlossFamilyName" class="codecode" title="�¹�������" style="width:40%"
			               ondblclick="code_CodeSelect(this, 'ZH03prpLlossFamilyName','','code','none','post');"
                           onkeyup= "code_CodeSelect(this, 'ZH03prpLlossFamilyName','','code','none','post');"
                           onchange="getInsuredAmount(this);"
                           value=""/>
          				 </td>
          				</tr>
                     <%}else{ %>
                     <tr>                 
	                        <td class="title" style="width:15%">��ʧ��ģ�</td>                                                                   
	                        <td class="input" style="width:85%" colspan="3">
	                          <input type='text' name='prpLlossDtoItemCode' class='readonly' style="width:40"> 
	                          <input name="prpLlossDtoLossName" class='readonly' style="width:330px">
	                        </td>                                  
                      </tr>
 					 <tr>
 					 	<td class="title" style="width:15%, display:display" name="tdPrpLlossFamilyName">�¹������ƣ�</td> 
                 		<td class="input" style="width:35%" colspan="3">
			               <input type=text name="prpLlossFamilyName" class="codecode" title="�¹�������" style="width:40%" 
			               ondblclick="code_CodeSelect(this, 'ZH03prpLlossFamilyName','','code','none','post');"
                           onkeyup= "code_CodeSelect(this, 'ZH03prpLlossFamilyName','','code','none','post');"/>
          				 </td>
          				</tr>
          				<%} %>
                      <tr>                             
                        <td class="title" style="width:15%">���ս�</td>
                        <td class="input" style="width:35%">
                           <input type="text" name="prpLlossDtoAmountDisplay"  value="" class='readonly' readonly>
                           <input type="hidden" name="prpLlossDtoAmount" value="" class='readonly' readonly >
                        </td>                   
                        <td class="title" style="width:15%">���ռ�ֵ��</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoItemValue" class="common"  style="width:180px">
                        </td>                
                      </tr>   
                      <tr style="display:none">                             
                        <td class="title" style="width:15%">�ұ�</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency" class="codecode" style="width:30px"  value="<bean:write name='prpLcompensateDto' property='currency' />"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrencyName" class="codecode" style="width:90px"  value="<bean:write name='prpLcompensateDto' property='currencyName' />"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">             
                        </td>            
                      </tr>                        
                      <tr>                             
                        <td class="title" style="width:15%">�˶��ұ�</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency2" class="codecode" style="width:30px"  value="<bean:write name='prpLcompensateDto' property='currency' />"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrency2Name" class="codecode" style="width:90px"  value="<bean:write name='prpLcompensateDto' property='currencyName' />"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">                                                                         
                        </td>            
                      </tr>                                     
                      <tr>
                        <td class="title">�˶���ʧ��</td>
                        <td class="input">
                          <input name="prpLlossDtoSumLoss" class="common"  style="width:180px" onblur="calRealpay(this);calLoss();" onchange="setFlagDanger();">
                        </td>
                        <td class="title">��ֵ��</td>
                        <td class="input">
                          <input name="prpLlossDtoSumRest" class="common"  style="width:180px" onblur="calRealpay(this);calLoss();" onchange="setFlagDanger();">
                        </td>                  
                      </tr>                              
                      <tr>
                        <td class="title">�⸶������</td> 
                        <td class="input">                          
                          <input name="prpLlossDtoClaimRate"  class="common"  style="width:180px"  value="100" onblur="calRealpay(this);calLoss();return isRightDutyPercent(this)" onchange="setFlagDanger();">%
                        </td>
                        <td class="title">�����ʣ�</td>
                        <td class="input">
                          <input name="prpLlossDtoDeductibleRate"  class="common"  style="width:180px" value="0" onblur="calRealpay(this);calLoss();" onchange="setFlagDanger();">%
                        </td>                  
                      </tr>
                      <tr>                             
                        <td class="title" style="width:15%">�⸶�ұ�</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency3" class="codecode" style="width:30px"  value="<bean:write name='prpLcompensateDto' property='currency' />"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrency3Name" class="codecode" style="width:90px"  value="<bean:write name='prpLcompensateDto' property='currencyName' />"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">  
                        </td>            
                      </tr>      
                          
                      <tr>                             
                        <td class="title" style="width:15%">����</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoDeductible" type='text' class="input" style="width:180px" onblur="calRealpay(this);calLoss();" onchange="setFlagDanger();">                                                                            
                        </td>                   
                        <td class="title" style="width:15%">�⳥��</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoSumRealPay" style="width:180px" class="input" onchange="calFund();calRealpay(this);setFlagDanger();">
                        </td>                 
                      </tr>  
			      <logic:notEmpty name="coinsFlag"  >
					<logic:equal name='coinsFlag' value="2">
                      <tr>                             
                        <td class="title" style="width:15%">�������⳥���</br>�����ҷ�����������������</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoCoinsSumRealPay" type='text' class="input" style="width:180px" onblur="calCoinsSumPaid(this);" onchange="setFlagDanger();">                                                                     
                        </td>                   
                      </tr>  
					</logic:equal>
					<logic:equal name='coinsFlag' value="1">
                      <tr>                             
                        <td class="title" style="width:15%">�������⳥���</br>�����ҷ�����������������</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoCoinsSumRealPay" type='text' class="input" style="width:180px" onblur="calCoinsSumPaid(this);" onchange="setFlagDanger();">                                                                     
                        </td>                   
                      </tr>  
					</logic:equal>
				</logic:notEmpty>
                       <!--add by zhulei 20050905 ����ļ��һ���ָ���-->
           <tr>
             <td height="1" bgcolor="#6C90DA" colspan='4'></td>
           </tr>
                   </table>     
               </td>
               
              <td class="input" style="width:4%">
              <div align="center">
                <input type=button name="buttonlLossDelete"  class="smallbutton" onclick="deleteRow(this,'lLoss');calFund();setFlagDanger();" value="-" style="cursor: hand">
              </div>
              </td> 
           </tr>
            </tbody>
          </table>
        </span>
        
        <span  id="spanlLoss" style="display:none">
        <%-- ��������չ���� --%>
        <table id="lLoss" class="common" align="center" cellspacing="1" cellpadding="0">
          <thead>
             <tr>
                <td class="title" style="width:4%">���</td>
                <td class="title" style="width:96%" colspan=2 >����</td>
             </tr> 
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan=2 style="width:96%">(��"+"�ż������ձ���Ϣ����"-"�ż�ɾ����Ϣ)</td>
                 <td class="title" align="right" style="width:4%">
                 <div align="center">
                 <input type="button" value="+" onclick="insertRow('lLoss');setFlagDanger();" class="smallbutton" name="buttonlLossInsert" style="cursor: hand">
                 </div>
                 </td>
              </tr> 
           </tfoot> 
            
         <tbody>
 <% int index24=0;%>
<logic:notEmpty  name="prpLlossDto"  property="prpLlossList"> 
<logic:iterate id="lloss" name="prpLlossDto" property="prpLlossList">
       
              <tr>
              <td class="input" style="width:4%">
                 <div align="center">
                   <input class="readonlyNo" readonly name="prpLlossDtoSerialNo" description="���" value="<bean:write name='lloss' property='serialNo'/>">
                 </div>
             </td>
             <td class="subformtitle"  style="width:92%">                        
                 <table  cellpadding="0" cellspacing="1" class="common" style="width:100%">
                  
                    <!--�Ƿ񳬹������е��޶��־��-->
                    <!-- input type="hidden" name="prpLlossDtoOverAmount" -->  
                    <input type='hidden' name="prpLlossDtoLicenseNo" value="<bean:write name='lloss' property='licenseNo'/>">
                    <input type='hidden' name='prpLlossDtoFamilyNo' value="<bean:write name='lloss' property='familyNoZH'/>"> 
                  
                    <input type='hidden' name="prpLlossDtoFeeTypeCode" value="<bean:write name='lloss' property='feeTypeCode'/>">
                    <input type='hidden' name="prpLlossDtoFeeTypeName" value="<bean:write name='lloss' property='feeTypeName'/>">
                                   
                    <input type='hidden' name='prpLlossDtoFamilyName' value="<bean:write name='lloss' property='familyName'/>"> 
                    <input type='hidden' name='prpLlossDtoItemAddress' value="<bean:write name='lloss' property='itemAddress'/>"> 
                    <input type='hidden' name='prpLlossDtoBuyDate' value="<bean:write name='lloss' property='buyDate'/>"> 
                    <input type='hidden' name='prpLlossDtoDepreRate' value="<bean:write name='lloss' property='depreRate'/>"> 
                    <input type='hidden' name='prpLlossDtoCurrency1' value="<bean:write name='lloss' property='currency1'/>"> 
                    <input type='hidden' name='prpLlossDtoCurrency4' value="<bean:write name='lloss' property='currency4'/>"> 
                    <input type='hidden' name='prpLlossDtoFlag' value="<bean:write name='lloss' property='flag'/>"> 
                    <input type='hidden' name='prpLlossDtoUnit' value="<bean:write name='lloss' property='unit'/>"> 
                    <input type="hidden" name="prpLlossDtoLossQuantity"   value="<bean:write name='lloss' property='lossQuantity'/>">                  
                    <input type="hidden" name="prpLlossDtoUnitPrice" value="<bean:write name='lloss' property='unitPrice'/>">               
                    <input type="hidden" name="prpLlossDtoIndemnityDutyRate" value="<bean:write name='lloss' property='indemnityDutyRate'/>">
                      <tr>                             
                        <td class="title" style="width:15%">����ţ�</td> 
                        <td class="input" style="width:35%" colspan="3">
                          <input type="input" readonly="readonly" class="readonly" name="prpLlossFamilyNo" style="width:80" value="<bean:write name='lloss' property='familyNoZH'/>">                  
                        </td>                
                      </tr>
                      <tr>                             
                        <td class="title" style="width:15%">�����ţ�</td> 
                        <td class="input" style="width:35%" colspan="3">
                           <input type='text' class="readonly" readonly="readonly" name='prpLlossDtoItemKindNo' value="<bean:write name='lloss' property='itemKindNo'/>"> 
                        </td>                
                      </tr>
                      <tr>                             
                        <td class="title" style="width:15%">�ձ�</td> 
                        <td class="input" style="width:35%" colspan="3">
                          <input type="input" name=prpLlossDtoKindCode class="codecode" style="width:40" value="<bean:write name='lloss' property='kindCode'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyKindCode','1,-1,4,5','code','none','post');"
                            onkeyup= "code_CodeSelect(this, 'PolicyKindCode','1,-1,4,5','code','none','post');"
                            onblur=""
                             onchange="setFlagDanger();">
                          <input type="input" name=prpLlossDtoKindName class="codename" style="width:110" value="<bean:write name='lloss' property='kindName'/>"
        			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2,3,4','always','none','post');"
        			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2,3,4','always','none','post');"
        			              onchange="setFlagDanger();"> 
                          <img src="/claim/images/bgMarkMustInput.jpg">                                                     
                          <input type='hidden' name='LossItemCode'>                                                                   
                          <input type='hidden' name="LossItemName" class='readonly' readonly>
                        </td>                
                      </tr>
                      <%if ("EDIT".equals(editType) || "ADD".equals(editType)){%>
			          <tr>                 
                        <td class="title" style="width:15%">��ʧ��ģ�</td>                                                                   
                        <td class="input" style="width:85%" colspan="3">
                          <input type='text' name='prpLlossDtoItemCode' class='readonly' style="width:40"   value="<bean:write name='lloss' property='itemCode'/>"
                            onpropertychange="getInsuredAmount(this);"
                            > 
                          <input name="prpLlossDtoLossName" class='readonly'  style="width:330px"  value="<bean:write name='lloss' property='lossName'/>"
                            onchange=""
        		 	        >  
	            		
                        </td>                                  
                      </tr>
                      <tr>
 					 	<td class="title" style="width:15%, display:display" name="tdPrpLlossFamilyName">�¹������ƣ�</td> 
                 		<td class="input" style="width:35%" colspan="3">
			               <input type=text name="prpLlossFamilyName" class="codecode" title="�¹�������" style="width:40%" value="<bean:write name='lloss' property='familyName' filter='true' />"
			               ondblclick="code_CodeSelect(this, 'ZH03prpLlossFamilyName','','code','none','post');"
                           onkeyup= "code_CodeSelect(this, 'ZH03prpLlossFamilyName','','code','none','post');"
                           onchange="getInsuredAmount(this);"/>
          				 </td>
          				</tr>
                      <% }else{%>
                      <tr>                 
                        <td class="title" style="width:15%">��ʧ��ģ�</td>                                                                   
                        <td class="input" style="width:85%" colspan="3">
                          <input type='text' name='prpLlossDtoItemCode' class='readonly' style="width:40"   value="<bean:write name='lloss' property='itemCode'/>"
                            > 
                          <input name="prpLlossDtoLossName" class='readonly'  style="width:330px"  value="<bean:write name='lloss' property='lossName'/>"
                            >  
	            		
                        </td>                                  
                      </tr>
                       <tr name="trPrpLlossFamilyName"  style="display:display">
 					 	 <td class="title" style="width:15%, display:display" name="tdPrpLlossFamilyName">�¹������ƣ�</td> 
                 		 <td class="input" style="width:35%" colspan="3">
			               <input type=text name="prpLlossFamilyName" title="�¹�������" style="width:40%" class="codecode" value="<bean:write name='lloss' property='familyName' filter='true' />"
			               ondblclick="code_CodeSelect(this, 'ZH03prpLlossFamilyName','','code','none','post');"
                           onkeyup= "code_CodeSelect(this, 'ZH03prpLlossFamilyName','','code','none','post');"/>
			           </td>
			          <tr>
                      <%} %>
 					 
                      <tr>                             
                        <td class="title" style="width:15%">���ս�</td>
                        <td class="input" style="width:35%">
                            <input type="hidden" name="prpLlossDtoAmount" class='readonly' readonly value="<bean:write name='lloss' property='amount'/>">
                            <input type="text" name="prpLlossDtoAmountDisplay" class='readonly' readonly value="<bean:write name='lloss' property='amount' format='#,##0.00'/>"> 
                        </td>                   
                        <td class="title" style="width:15%">���ռ�ֵ��</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoItemValue" class="common"  style="width:180px" value="<bean:write name='lloss' property='itemValue' format='##0.00'/>">
                        </td>                
                      </tr>   
                      <tr style="display:none">                             
                        <td class="title" style="width:15%">�ұ�</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency" class="codecode" style="width:30px" value="<bean:write name='lloss' property='currency'/>"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrencyName" class="codecode" style="width:90px" value="<bean:write name='lloss' property='currencyName'/>"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">             
                        </td>            
                      </tr>                        
                     
                        
                      <tr>                             
                        <td class="title" style="width:15%">�˶��ұ�</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency2" class="codecode" style="width:30px" value="<bean:write name='lloss' property='currency2'/>"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrency2Name" class="codecode" style="width:90px" value="<bean:write name='lloss' property='currency2Name'/>"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">                                                                         
                        </td>            
                      </tr>                                     
                      <tr>
                        <td class="title">�˶���ʧ��</td>
                        <td class="input">
                          <input name="prpLlossDtoSumLoss" class="common"  style="width:180px" value="<bean:write name='lloss' property='sumLoss' format='##0.00'/>"  onblur="calRealpay(this);calLoss();"
                          onchange="setFlagDanger();">
                        </td>
                        <td class="title">��ֵ��</td>
                        <td class="input">
                          <input name="prpLlossDtoSumRest" class="common"  style="width:180px" value="<bean:write name='lloss' property='sumRest' format='##0.00'/>"  onblur="calRealpay(this);calLoss();"
                          onchange="setFlagDanger();">
                        </td>                  
                      </tr>                              
                      <tr>
                        <td class="title">�⸶������</td> 
                        <td class="input">                          
                          <input name="prpLlossDtoClaimRate"  class="common"  style="width:180px" value="<bean:write name='lloss' property='claimRate' format='##0.0000'/>"  onblur="calRealpay(this);calLoss();"
                          onchange="setFlagDanger();">%
                        </td>
                        <td class="title">�����ʣ�</td>
                        <td class="input">
                          <input name="prpLlossDtoDeductibleRate"  class="common"  style="width:180px" value="<bean:write name='lloss' property='deductibleRate' format='##0.0000'/>"  onblur="calRealpay(this);calLoss();"
                          onchange="setFlagDanger();">%
                        </td>                  
                      </tr>
                      <tr>                             
                        <td class="title" style="width:15%">�⸶�ұ�</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency3" class="codecode" style="width:30px" value="<bean:write name='lloss' property='currency3'/>"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrency3Name" class="codecode" style="width:90px" value="<bean:write name='lloss' property='currency3Name'/>"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">  
                        </td>            
                      </tr>      
                          
                      <tr>                             
                        <td class="title" style="width:15%">����</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoDeductible" type='text' class="input" style="width:180px" value="<bean:write name='lloss' property='deductible' format='##0.00'/>"  onblur="calRealpay(this);calLoss();"
                          onchange="setFlagDanger();">                                                                            
                        </td>                   
                        <td class="title" style="width:15%">�⳥��</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoSumRealPay" style="width:180px" class="input" value="<bean:write name='lloss' property='sumRealPay' format='##0.00'/>" onchange="calFund();calRealpay(this);setFlagDanger();">
                        </td>                 
                      </tr>
			      <logic:notEmpty name="coinsFlag"  >
					<logic:equal name='coinsFlag' value="2">
                     <tr>                             
                        <td class="title" style="width:15%">�������⳥���</br>�����ҷ�����������������</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoCoinsSumRealPay" style="width:180px" class="input" value="<bean:write name='lloss' property='coinsSumRealPaid' format='##0.00'/>" onchange="" onblur="calCoinsSumPaid(this);">                                                                            
                        </td>                   
                      </tr>
					</logic:equal>
					<logic:equal name='coinsFlag' value="1">
                     <tr>                             
                        <td class="title" style="width:15%">�������⳥���</br>�����ҷ�����������������</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoCoinsSumRealPay" style="width:180px" class="input" value="<bean:write name='lloss' property='coinsSumRealPaid' format='##0.00'/>" onchange="" onblur="calCoinsSumPaid(this);">                                                                            
                        </td>                   
                      </tr>
					</logic:equal>
			      </logic:notEmpty>

                      <!--add by zhulei 20050905 ����ļ��һ���ָ���-->
           <tr>
             <td height="1" bgcolor="#6C90DA" colspan='4'></td>
           </tr>
                   </table>               
               </td>
              <td class="input" style='width:4%'>
              <div align="center">
                <input type=button name="buttonlLossDelete"  class="smallbutton" onclick="deleteRow(this,'lLoss');calFund();setFlagDanger();" value="-" style="cursor: hand">
              </div>
              </td> 
           </tr>
           
          
        <%    index24++;%>             
      </logic:iterate>
      </logic:notEmpty>   
       </tbody>      
         </table>  
        </span>    
      </td>
    </tr>
  </table>


