<%--
****************************************************************************
* DESC       :�������Ϣ�ӿ����ҳ��Tail[ ʵ�� ]
* AUTHOR     :liubvo
* CREATEDATE :2004-05-12
* MODIFYLIST :  Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
****************************************************************************
--%>

<table  class=common cellpadding="5" cellspacing="1">
<%  

 String sosMedicFee =(String) request.getAttribute("sosMedicFee");
 String preSosMedicFee = (String) request.getAttribute("preSosMedicFee");
 %>  
  <tr> 
    <td class="title"  > ���ϼ�:</td>
    <td class="input"  > <input class="readonly" type=text name="prpLcompensateSumDutyPaid" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='sumDutyPaid' filter='true' format='##0.00'/>">  
    </td>
    <td class="title"  > ����:</td>
    <td class="input" > <input type=text name="prpLcompensateSumNoDutyFee" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLcompensateDto' property='sumNoDutyFee' filter='true' format='##0.00'/>"> 
    </td>
  </tr>
   
  <tr> 
    <td class="title"> ����ܼ�:</td>
    <td class="input"> <input class="readonly" type=text name="prpLcompensateSumPaid" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='sumPaid' filter='true' format='##0.00'/>">  
    </td>
    <td class="title"> ��Ԥ�����:</td>
    <td class="input"> <!--input type=text name="prpLcompensateSumPrePaid" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLcompensateDto' property='sumPrePaid' filter='true' format='##0.00'/>"--> 
    	<input type=text name="prpLcompensateSumPrePaid" class="readonly" readonly="true"   style="width:140px" value="<%=sosMedicFee%>"> 
    </td>
  </tr> 
  <tr>
  	 <td class="title"> ��Ԥ������:</td>
    <td class="input" colspan="3"> 
    	<input class="readonly" type=text name="prpLcompensatePreSumChargePaid" readonly="true"  style="width:150px" value="<%=preSosMedicFee %>">  
    </td>
  </tr>
  <tr> 
    <td class="title"> �����⸶���:</td>
    <td class="input"> <input class="readonly" type=text name="prpLcompensateSumThisPaid" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='sumThisPaid' filter='true' format='##0.00'/>">  
    </td>  
    <td class="title"> �������Ը���:</td>
    <td class="input"> <input class="readonly" type=text name="prpLcompensateSumSelfValue" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='bank' format='##0.00'/>">  
    </td>
  </tr> 
  
  <tr> 
    <td class="title"> ҵ�񾭰���:</td>
    <td class="input" colspan="3"> 
      <input name="prpLcompensateHandlerCode" class="codecode" style="width:100px" value="<bean:write name='prpLcompensateDto' property='handlerCode' filter='true' />"
          ondblclick="code_CodeSelect(this, 'HanderCode');"
          onchange="code_CodeChange(this, 'HanderCode');"
          onkeyup= "code_CodeSelect(this, 'HanderCode');">
      <input name="prpLcompensateHandlerName" class="codename" style="width:120px"  title="������" value="<bean:write name='prpLcompensateDto' property='handlerName' filter='true' />"
         ondblclick="code_CodeSelect(this, 'HanderCode','-1','name','none','post');"
         onchange="code_CodeChange(this, 'HanderCode','-1','name','none','post');"
         onkeyup= "code_CodeSelect(this, 'HanderCode','-1','name','none','post');"> 
    </td>
  </tr> 
  
  <tr> 
    <td class="title"> ͳ������:</td>
    <td class="input"> <input type="text" class="common"  style="width:110" name="prpLcompensateStatisticsYM" value="<bean:write name='prpLcompensateDto' property='statisticsYM' filter='true' />">
    </td>
    <td class="title"> �鿱��:</td>
    <td class="input"> <input type=text name="prpLcompensateChecker1" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLcompensateDto' property='checker1' filter='true' />"> 
    </td>
  </tr>
  <logic:equal value="1" name="prpLcompensateDto" property="underWriteFlag">
	   <tr>
	    <td class="title"> ���պ�����:</td>
	    <td class="input"  >
	      <input name="prpLcompensateUnderWriteName" class="codename" style="width:50%"  title="���պ�����" readonly="true"
	         value="<bean:write name='prpLcompensateDto' property='underWriteName' filter='true' />">
	    </td>
	
	    <td class="title"> ����ͨ������:</td>
	    <td class="input"> <input type="text" class="common"  readonly="true" style="width:110" name="prpLcompensateUnderWriteEndDate" 
	    	value="<bean:write name='prpLcompensateDto' property='underWriteEndDate' filter='true' />">
	   </tr>
	</logic:equal>
  <tr> 
    <td class="title"> ��ע:</td>
    <td class="input" colspan="3"> <input class="input" type=text name="prpLcompensateRemark"  maxLength="255" onblur="checkLength1(this);" description="��ע" value="<bean:write name='prpLcompensateDto' property='remark' filter='true' />">  
    </td>
  </tr>
  <%
  // delete by yehuiquan 2007-07-16 Reason:ҳ��500����ɾ������ԭ��Ҫ��
  /*
   <logic:equal name="prpLcompensateDto" property="status" value="3">       
  <tr> 
    <td class="title"> ����ԭ��:</td>
    <td class="input" colspan="3"> <input class="readonly"  readonly=true  type=text name="backReason" value="<bean:write name='swfNotionDto' property='handleText' filter='true' />">  
    </td>
  </tr>
</logic:equal>
  */
  %>
</table>
