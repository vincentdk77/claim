<%--
****************************************************************************
* DESC       �� ������Ϣ����
* AUTHOR     �� wangli 
* CREATEDATE �� 2005-05-28
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 

<SCRIPT LANGUAGE="JavaScript">
<!--
//modify by liujianbo modify 20050321 start
//reason:�ڱ����Ǽǻ����У��ѳ��մ��������γ����¹ʵ��嵥��,���Ե�������Ź�������ذ�����Ϣ  
/**
 *@description ��������������Ϣҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function showRegist(registNo){	       
	     
    var linkURL = "/claim/registFinishQueryList.do?prpLregistRegistNo="+registNo+"&editType=SHOW";	  
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");    
}   
function showPicture(registNo){	    
    var linkURL = "/claim/DAA/certify/DAACertifyViewFile.jsp?businessNo="+registNo+"&display=all";	  
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");    
}   
//modify by liujianbo modify 20050321 end

function showCompensateFee(registNo){	       
	     
    var linkURL = "/claim/uiCompensateFee.do?prpLregistRegistNo="+registNo;	  
    var newWindow = window.open(linkURL,"NewWindow","width=300,height=100,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");    
}  

//�ѳ��մ���ҳ��"..."��ť�����¼���������ͬ��������౨������ʾ add by xuecheng
function buttonOnClickAgriCheck(actionName,policyNo,curRegistNo)
{
  var allPerilCount = document.getElementsByName("PerilCount");
  var sameCount = parseInt(allPerilCount[0].value);
  if (sameCount <1)
  {
  	var buttonPerilOpenContext = document.getElementsByName("button_Peril_Open_Context");
  	buttonPerilOpenContext[0].disabled = true;
  	return;
  }

  var messagedo="/claim/"+actionName+".do?policyNo="+policyNo+"&curRegistNo="+curRegistNo;

  win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,top=100,left=100,width=700,Height=500");
}
//--> 
</SCRIPT>
<input type=text name="PerilCount" class="readonly" readonly="true" style="width:50%;text-align='center';color:'#9B009B'" value="<bean:write name='prpLregistDto1' property='perilCount' filter='true' />">

<input type=button ACCESSKEY="." value='...' name='button_Peril_Open_Context' class="smallbutton" onclick="buttonOnClickAgriCheck('perilInfoShow',fm.policyno.value,fm.registno.value);">
<!--
<logic:present name="prpLclaimDto" property="registNo">
<input type=hidden name="curRegistNo" value="<bean:write name='prpLclaimDto' property='registNo' filter='true' />">
</logic:present>
-->
<span id="span_Peril_Context" style='width:700;display:none;position:absolute;background-color:FFFFFF;'> 
  <table class="prompt" style="width:600">
      <tr class="prompt">
        <td class="prompttitle">���</td>
        <td class="prompttitle">������</td>
        <td class="prompttitle">����ʱ��</td>
        <!--
        <td class="prompttitle">�Ѿ����</td> 
        <td class="prompttitle">δ�����</td>
        -->
        <td class="prompttitle">�Ѿ�δ�������ʾ</td> 
        <td class="prompttitle">����״̬</td>  
        <td class="prompttitle">����Ա</td>      
        <!--
        <td class="prompttitle">��ϵ��</td> 
        <td class="prompttitle">��������</td>
        <td class="prompttitle">����������</td> 
        <td class="prompttitle">���յص�</td> 
        <td class="prompttitle">��ʧ��λ</td> 
        <td class="prompttitle">������Ƭ</td> 
        <td class="prompttitle">��ϵ�绰</td>   
        <td class="prompttitle">״̬</td>  
        -->
      </tr> 
      
      <logic:notEmpty  name="prpLregistDto1"  property="registList"> 
        <logic:iterate id="registItem" name="prpLregistDto1" property="registList">
        <!-- ������մ�����ϸ��Ϣ-->  
        <tr>        
          <td class="prompt"><bean:write name="registItem" property="serialNo"/></td> 
          <%--modify by liujianbo modify 20050321 start--%>
          <%--resson:�ڱ����Ǽǻ����У��ѳ��մ��������γ����¹ʵ��嵥��,���Ե�������Ź�������ذ�����Ϣ--%>           
          <td class="prompt"><a href="javascript:showRegist('<bean:write name='registItem' property='registNo'/>')"><bean:write name='registItem' property='registNo'/></a> </td> 
          <%--modify by liujianbo modify 20050321 end--%>
          <td class="prompt"><bean:write name="registItem" property="damageStartDate"/></td>         
          <td class="prompt"><a href="javascript:showCompensateFee('<bean:write name='registItem' property='registNo'/>')">�Ѿ�δ�������ʾ</a></td>                             
          <td class="prompt"><bean:write name="registItem" property="status"/></td>   
          <td class="prompt"><bean:write name="registItem" property="operatorName"/></td>
          <!--
          <td class="prompt"><bean:write name="registItem" property="linkerName"/></td>
          <td class="prompt"><bean:write name="registItem" property="operatorCode"/></td>
          <td class="prompt"><bean:write name="registItem" property="operatorName"/></td>
          <td class="prompt"><bean:write name="registItem" property="damageAddress"/></td>
          <td class="prompt"><bean:write name="registItem" property="brandName"/></td>
          <td class="prompt"><a href="javascript:showPicture('<bean:write name='registItem' property='registNo'/>')"><bean:write name='registItem' property='registNo'/></a> </td>
          <td class="prompt"><bean:write name="registItem" property="phoneNumber"/></td>
          <td class="prompt"><bean:write name="registItem" property="status"/></td>
          -->
        </tr>        
        </logic:iterate> 
      </logic:notEmpty>           
      <tr>  
        <td colspan=10 class="prompttitle" >
          <input type=button name = 'button_Peril_Close_Context' value='(O)�ر�'  class="button" ACCESSKEY="O" onclick="hideSubPage(this,'span_Peril_Context')">  
        </td> 
      </tr>
  </table>        
</span>
    