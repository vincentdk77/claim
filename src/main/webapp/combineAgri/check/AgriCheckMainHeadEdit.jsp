<%--
****************************************************************************
* DESC       :�������Ϣ�ӿ����ҳ��
* AUTHOR     : liubvo
* CREATEDATE : 2004-06-03 
* MODIFYLIST :   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<!--add by liuyanmei 20051206 start -->
<%

 String comCode ="";
 String comName ="";
try{
  UserDto  user   = (UserDto)session.getAttribute("user");
  
   if (user!=null){
   comCode = user.getComCode();
    comName = user.getComName();
    }
 }catch (Exception e){
 }
 

  %>
<!--add by liuyanmei 20051206 end reason:�Զ���������Ա�������Ż���������-->
 
<%--//add by wangli 20050601 reason:ϵͳ�ڴ�prpdcompany������ϵͳ����ӿͻ����ϱ�prpdcustomer_unit��ȡֵ--%>
<script language="javascript">
 function selectHandleCodeByUnitType(fieldObject,combineIndex){

   var unitType = fm.all("unitType")[combineIndex].value;
  // alert(fieldObject);
  // alert(unitType);  
  // fm.prpLcheckHandleUnitCode.value = ""; 
    if(unitType==1){
    code_CodeSelect(fieldObject, 'ComCode');
       }else{
    code_CodeSelect(fieldObject, 'CustomerUnit');
    }      
 }
     
      function clearHandleUnitCode(field){
       fm.all("prpLcheckHandleUnitCode_"+(getElementOrder(field)-1)).value = ""; 
       fm.all("prpLcheckHandleUnitName_"+(getElementOrder(field)-1)).value = ""; 
      }
      function showDamageMessageSpan(spanID,leftMove,topMove,combineIndex){
		  document.getElementById("span_damageMessage_"+combineIndex).style.display = "";
		  var intLeftMove = (leftMove==null?0:leftMove);
		  var intTopMove = (topMove==null?0:topMove);
		  var span = eval(spanID);
		  var spanTop = document.body.offsetHeight;
		  spanTop = spanTop-topMove;
		  span.style.top=document.body.scrollTop+spanTop;
		  span.style.display ='';
		  tdLossesNumber.style.display="none";
		  tdKillQuantity.style.display="none";
	}
	function hideDamageMessageSpan(combineIndex){
		document.getElementById("span_damageMessage_"+combineIndex).style.display = "none";
		tdLossesNumber.style.display="";
		tdKillQuantity.style.display="";
	}
</script>
<%iterator = PrplcombineDtos.iterator();
while(iterator.hasNext()){iterator.next();%>
<span  id="spanMain_<%=idxMain%>" style = "display:none" cellspacing="1" cellspacing="0"  width="100%">
<%
String prpLcheckDto = "";
String prpLregistDto = "";
String checkNatures = "";
String coinsFlag = "";
String shareHolderFlag = "";
String tempReinsFlag = "";
String prpLregistDto1 = "";
prpLcheckDto = "prpLcheckDto_"+String.valueOf(idxMain);
prpLregistDto = "prpLregistDto_"+String.valueOf(idxMain);
checkNatures = "checkNatures_"+String.valueOf(idxMain);
coinsFlag = "coinsFlag_"+String.valueOf(idxMain);
shareHolderFlag = "shareHolderFlag_"+String.valueOf(idxMain);
tempReinsFlag = "tempReinsFlag_"+String.valueOf(idxMain);
prpLregistDto1 = "prpLregistDto1_"+String.valueOf(idxMain);
%>   


    <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" width="100%">
    <tr class=listtitle><td colspan="4">���鴦��</td></tr>
      <tr>
        <td class="title" >
          <input type="hidden" name="referKind_<%=idxMain%>">
          <input type="hidden" name="prpLcheckRiskCode_<%=idxMain%>"  value="<bean:write name='<%=prpLcheckDto%>' property='riskCode'/>">
          <input type="hidden" name="prpLcheckFlag_<%=idxMain%>"  value="<bean:write name='<%=prpLcheckDto%>' property='flag'/>">
          <input type="hidden" name="prpLcheckReferSerialNo_<%=idxMain%>" value="<bean:write name='<%=prpLcheckDto%>' property='referSerialNo' filter='true' />">    
          <input type="hidden" name="prpLcheckInsureCarFlag_<%=idxMain%>" value="<bean:write name='<%=prpLcheckDto%>' property='insureCarFlag' filter='true' />">    
          <input type="hidden" name="swfLogFlowID_<%=idxMain%>" class="common" value="<%=request.getAttribute("swfLogFlowID_"+idxMain)%>">
          <input type="hidden" name="swfLogLogNo_<%=idxMain%>" class="common" value="<%=request.getAttribute("swfLogLogNo_"+idxMain)%>">
          <input type="hidden" name="riskCode_<%=idxMain%>"  value="<bean:write name='<%=prpLcheckDto%>' property='riskCode'/>">
          <input type="hidden" name="prpLclaimRiskCode_<%=idxMain%>" value="<bean:write name='<%=prpLcheckDto%>' property='riskCode'/>">  
          <input type="hidden" name="registno_<%=idxMain%>" value="<bean:write name='<%=prpLcheckDto%>' property='registNo'/>">
          <input type="hidden" name="policyno_<%=idxMain%>" value="<bean:write name='<%=prpLcheckDto%>' property='policyNo'/>">
          <input type="hidden" name="prpLverifyLossRegistNo_<%=idxMain%>" value="<bean:write name='<%=prpLcheckDto%>' property='registNo'/>">
          <input type="hidden" name="prpLverifyLossPolicyNo_<%=idxMain%>" value="<bean:write name='<%=prpLcheckDto%>' property='policyNo'/>">
          <input type="hidden" name="prpLverifyLossInsuredName_<%=idxMain%>" value="<bean:write name='<%=prpLcheckDto%>' property='insuredName'/>">
          <input type="hidden" name="prpLverifyLossMakeCom_<%=idxMain%>" value="<bean:write name='<%=prpLregistDto%>' property='makeCom'/>">
          <input type="hidden" name="prpLverifyLossComCode_<%=idxMain%>" value="<bean:write name='<%=prpLregistDto%>' property='comCode'/>">            
        
        ��������:</td>
        <td class="title"><%= request.getAttribute("riskCName_"+idxMain) %></td>
        <td class="title"></td><td class="title"></td>
      </tr>

      <tr> 
        <td class="title"  style="valign:bottom" >�����ţ�</td>
        <td class="input"  style="valign:middle">
          <input type=text name="prpLcheckRegistNo_<%=idxMain%>" class="readonly" readonly="true"  value="<bean:write name='<%=prpLcheckDto%>' property='registNo'/>">          
        </td>
        <td class="title" >�����ţ�</td>
        <td class="input"  >
          <input type="text" name="prpLcheckClaimNo_<%=idxMain%>" class="readonly" readonly="true" value="<bean:write name='<%=prpLcheckDto%>' property='claimNo'/>">
        </td>
      </tr>
       
      <tr>         
        <td class="title" >�����ţ�</td>
        <td class="input"  colspan="3">
          <input type="text" name="prpLcheckPolicyNo_<%=idxMain%>" style="width:20%" class="readonly" readonly="true"  value="<bean:write name='<%=prpLcheckDto%>' property='policyNo'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
          <input type="image" name="btRelate_<%=idxMain%>" src="/claim/images/butRelate.gif"  border="0" onclick="relate(fm.prpLcheckPolicyNo_<%=idxMain%>.value);return false;">         
           <input type="hidden" name="damageDate_<%=idxMain%>" value="<bean:write name='<%=prpLcheckDto%>' property='damageStartDate' filter='true' /> ">
          <input type=button class="bigbutton"  name="policyBackWard" value="����ʱ������Ϣ" onclick="backWardPolicy('<%=idxMain%>');">      
        </td>
      </tr>
      <tr>         
        <td class="title" >�������ˣ�</td>
        <td class="input"  colspan="3">
          <input type="text" name="insuredName_<%=idxMain%>" style="width:40%" class="readonly" readonly="true"  value="<bean:write name='<%=prpLcheckDto%>' property='insuredName'/>">
        </td>

      <!--modify by qinyongli 2005-07-22 start ���������ٷֺ͹ɶ���Ϣ-->
      <logic:notEmpty name="<%=coinsFlag%>"  >
      <input type="hidden" name="coinsFlag_<%=idxMain%>" value="<bean:write name='<%=coinsFlag%>'/>">
      </logic:notEmpty>
      <logic:empty name="<%=coinsFlag%>"  >
      <input type="hidden" name="coinsFlag_<%=idxMain%>" value="0">
      </logic:empty>
      <logic:notEmpty name="<%=shareHolderFlag%>"  >
      <input type="hidden" name="shareHolderFlag_<%=idxMain%>" value="<bean:write name='<%=shareHolderFlag%>'/>">
      </logic:notEmpty>
      <logic:empty name="<%=shareHolderFlag%>"  >
      <input type="hidden" name="shareHolderFlag_<%=idxMain%>" value="0">
      </logic:empty>
      <logic:notEmpty name="<%=tempReinsFlag%>"  >
      <input type="hidden" name="tempReinsFlag_<%=idxMain%>" value="<bean:write name='<%=tempReinsFlag%>'/>">
      </logic:notEmpty>
      <logic:empty name="<%=tempReinsFlag%>"  >
      <input type="hidden" name="tempReinsFlag_<%=idxMain%>" value="0">
      </logic:empty>
      <!--modify by qinyongli 2005-07-22 end �������͹ɶ���Ϣ-->
      <tr>         
        <td class="title" >����ʱ�䣺</td>
        <td class="input" >
        <input type="text" name="prpLcheckDamageStartDate_<%=idxMain%>" class="readonly" readonly="true" maxlength="10"  value="<bean:write name='<%=prpLcheckDto%>' property='damageStartDate' filter='true' /> <bean:write name='<%=prpLcheckDto%>' property='damageStartHour' filter='true' /> ʱ <bean:write name='<%=prpLcheckDto%>' property='damageStartMinute' filter='true' /> ��">
         <input type="hidden" name="damageStartDate_<%=idxMain%>" class="readonly" readonly="true" maxlength="10"  value="<bean:write name='<%=prpLcheckDto%>' property='damageStartDate' filter='true' /> ">
         <input type="hidden" name="damageStartHour_<%=idxMain%>" class="readonly" readonly="true" maxlength="10"  value="<bean:write name='<%=prpLcheckDto%>' property='damageStartHour' filter='true' /> ">
        </td>

        <td class="title" >���յص㣺</td>
        <td class="input" >
          <input type="text" name="prpLcheckDamageAddress_<%=idxMain%>" class="input"   value="<bean:write name='<%=prpLcheckDto%>' property='damageAddress'/>">
        </td>      
      </tr>
      
      <tr>         
        <td class="title" >�鿱���ͣ�</td>
        <td class="input"  >
          <html:select name='<%=prpLcheckDto%>' property='checkType' >
            <html:option value="L">�鿱</html:option>
            <html:option value="D">���鿱</html:option>
           </html:select>
        </td>
        
         <td class="title" >�鿱���ڣ�</td>
        <td class="input"  >
          <input type="text" name="prpLcheckCheckDate_<%=idxMain%>" class="input" onblur="checkFullDate(this)" value="<bean:write name='<%=prpLcheckDto%>' property='checkDate'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        
       
      </tr>
      
      <tr>         
        <td class="title"  style="valign:bottom" >�鿱����:</td>
        <td class="input"  style="valign:middle">
          <html:select name="<%=prpLcheckDto%>" property="checkNature" styleClass="common">
              <html:options collection="<%=checkNatures%>" property="codeCode" labelProperty="codeCName"/>          
          </html:select> 
        </td>
        
        <td class="title" >�ѳ��մ���:</td>
        <td class="input" >
        <%-- ������Ϣ���� --%>
         <%@include file="/combineAgri/regist/AgriExistRegist.jsp"%>                
        </td>
      </tr>

      <tr>         
        <td class="title" >�鿱�ص�:</td>
        <td class="input"  colspan="3">
          <input type="text" name="prpLcheckCheckSite_<%=idxMain%>" class="input" value="<bean:write name='<%=prpLcheckDto%>' property='checkSite'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>

      <tr>
        <td class="title" >�鿱�� 1:</td>
        <td class="input"  >
          <input name='prpLcheckChecker1_<%=idxMain%>' class='input' maxlength=20  description="�鿱��1" value="<bean:write name='<%=prpLcheckDto%>' property='checker1'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </select>
        </td>
        <td class="title"  style="valign:bottom" >�鿱�� 2:</td>
        <td class="input"  style="valign:middle">
          <input name='prpLcheckChecker2_<%=idxMain%>' class='input' maxlength=20 description="�鿱��2" value="<bean:write name='<%=prpLcheckDto%>' property='checker2'/>">
        </td>
      <%@include file="/combineAgri/check/AgriCheckDamageEdit.jsp"%>
      <!--modify by wangwei add start 20050602-->
      <!-- modify by wuxiaodong 050905 begain reasion �޸ıұ��ɱ�����¼���룬������д��-->
       <tr>         
        <td class="title" >������:<bean:write name='<%=prpLcheckDto%>' property='currency'/></td>
        <td class="input" colspan=3 >
          <input name='prpLcheckEstimateLoss2'  class="readonly" readonly="true"  maxlength=20 style="width:140px" description="�鿱��1" value="<bean:write name='<%=prpLcheckDto%>' property='registEstimateLoss' format = '#0.00'/>">
        </select>
        </td>
       <%-- <td class="title"  style="valign:bottom" >�������:<bean:write name='prpLcheckDto' property='currency'/></td>--%>
       <%-- <td class="input"  style="valign:middle">--%>
       <%--   <input name='prpLcheckEstimateFee2'  class="readonly" readonly="true"  maxlength=20 style="width:140px" description="�鿱��2" value="<bean:write name='prpLcheckDto' property='registEstimateFee'/>">--%>
       <%-- </td> --%>
      </tr>

       <tr>         
        <td class="title" >Ԥ�����:<bean:write name='<%=prpLcheckDto%>' format="0.00" property='currency'/></td>
        <td class="input"  >
          <input name='prpLcheckEstimateLoss_<%=idxMain%>' class='input' maxlength=20 style="width:140px" description="�鿱��1" value="<bean:write name='<%=prpLcheckDto%>' property='estimateLoss'/>">
        </select>
        </td>
        <td class="title"  style="valign:bottom" >Ԥ������:<bean:write name='<%=prpLcheckDto%>' property='currency'/></td>
        <td class="input"  style="valign:middle">
          <input name='prpLcheckEstimateFee_<%=idxMain%>'  class='input' maxlength=20 style="width:140px" description="�鿱��2" value="<bean:write name='<%=prpLcheckDto%>' property='estimateFee'/>">
        </td>
      </tr>
      <!-- modify by wuxiaodong 050905 end -->
      <!--//modify by wangwei add end 20050602-->
      
      <tr>
      <td class='title' id='tdTitleCheckUnitName_<%=idxMain%>'>�鿱����λ:</td>
        <td class="input" id="tdCheckName_<%=idxMain%>">
          <html:select name='<%=prpLcheckDto%>' property='unitType' onchange="clearHandleUnitCode(this);">
            <html:option value="1">ϵͳ��</html:option>
            <html:option value="0">ϵͳ��</html:option>
           </html:select>     
           </td>
          <td class="input" colspan='2'>
    <!--add by liuyanmei 20051206 start  reason:�Զ���������Ա�������Ż���������-->      
       <logic:notEmpty name='<%=prpLcheckDto%>' property='handleUnitCode' >    
          <input name="prpLcheckHandleUnitCode_<%=idxMain%>" class="codecode" style="width:100px" maxlength=20 description="�鿱����λ����" value="<bean:write name='<%=prpLcheckDto%>' property='handleUnitCode'/>"
             ondblclick="selectHandleCodeByUnitType(fm.prpLcheckHandleUnitCode_<%=idxMain%>,'<%=idxMain%>');"
             onkeyup= "selectHandleCodeByUnitType(fm.prpLcheckHandleUnitCode_<%=idxMain%>,'<%=idxMain%>');">
          <input name="prpLcheckHandleUnitName_<%=idxMain%>" class="readonly"  style="width:200px" maxlength=60 description="�鿱����λ" value="<bean:write name='<%=prpLcheckDto%>' property='handleUnit'/>">
      </logic:notEmpty>     
      <logic:empty name='<%=prpLcheckDto%>' property='handleUnitCode' > 
            <input name="prpLcheckHandleUnitCode_<%=idxMain%>" class="codecode" style="width:100px" maxlength=20 description="�鿱����λ����" value="<%=comCode%>" 
               ondblclick="selectHandleCodeByUnitType(fm.prpLcheckHandleUnitCode_<%=idxMain%>,'<%=idxMain%>');"
               onkeyup= "selectHandleCodeByUnitType(fm.prpLcheckHandleUnitCode_<%=idxMain%>,'<%=idxMain%>');">
            <input name="prpLcheckHandleUnitName_<%=idxMain%>" class="readonly"  style="width:200px" maxlength=60 description="�鿱����λ" value="<%= comName%>">  
      </logic:empty>
<!--add by liuyanmei 20051206 end -->
             <!--<img src="/claim/images/bgMarkMustInput.jpg">-->
          </td>          
      </tr>
            <tr>         
        <td class="title" >��ע��</td>
        <td class="input"  colspan="3">
          <input name='prpLcheckRemark_<%=idxMain%>' class='input' maxlength="80" onblur="checkLength1(this);" description="��ע"  value="<bean:write name='<%=prpLcheckDto%>' property='remark'/>">
        </td>
      </tr>        
    </table>
</span>
<%idxMain++;
}%>