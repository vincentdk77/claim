<%--
****************************************************************************
* DESC       ��������Ϣ����
* AUTHOR     �� Sinosoft 
* CREATEDATE �� 2004-12-09
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

//--> 
</SCRIPT>
<input type=text name="PerilCount" class="readonly" readonly="true" style="width:50%;text-align='center';color:'#9B009B'" value="<bean:write name='prpLregistDto1' property='perilCount' filter='true' />">

<input title="����˴��ɻ���ѳ��������Ϣ"  type=button ACCESSKEY="." value='...' class="smallbutton" name='button_Peril_Open_Context' onclick="buttonOnClick('span_Peril_Context');">
<span id="span_Peril_Context" style='width:800;display:none;position:absolute;background-color:FFFFFF;'> 
  <table class="prompt" style="width:400">
      <tr class="prompt">
        <td class="prompttitle">���</td>
        <td class="prompttitle">������</td>
        
        <!--modify by wangwei add start 2005-06-04-->
        <!--ԭ���ڽ���������һЩ��Ϣ-->
        <td class="prompttitle">������</td>
        <td class="prompttitle">������CNY</td>
        <td class="prompttitle">�⸶���CNY</td>
        <!--modify by wangwei add end 2005-06-04-->
        
        <td class="prompttitle">����ʱ��</td>
        <%--
        <td class="prompttitle">��ϵ��</td> 
        <td class="prompttitle">��������</td>
        <td class="prompttitle">����������</td> 
        --%>
        
        <td class="prompttitle">���յص�</td> 
        <td class="prompttitle">����ԭ��</td>
        <td class="prompttitle">��ʧ��λ</td> 
        <td class="prompttitle">������Ƭ</td> 
        <td class="prompttitle">��ϵ�绰</td>   
        <td class="prompttitle">״̬</td>  
      </tr> 
    
    
     <%-- <logic:notEmpty  name="prpLregistDto1"  property="registList"> 
        <logic:iterate id="registItem" name="prpLregistDto1" property="registList">--%>
        <!-- ������մ�����ϸ��Ϣ-->  
        <%
            //modify by wangwei add start 2005-06-04
            //ԭ�򣺴�������Ϣ���д���������Ϣ
            java.util.ArrayList registClaimDtoList = (java.util.ArrayList) request.getAttribute("registClaimDtoList");
            
            if (registClaimDtoList != null) {
            for (int count = 0; count < registClaimDtoList.size(); count++ ) {
                com.sinosoft.claim.dto.custom.RegistClaimInfoDto registClaimDto = (com.sinosoft.claim.dto.custom.RegistClaimInfoDto) registClaimDtoList.get(count);
                int sequenceNo = count + 1;
        %>
        <tr>        
          <td class="prompt"><%= sequenceNo %></td> 
          <%--modify by liujianbo modify 20050321 start--%>
          <%--resson:�ڱ����Ǽǻ����У��ѳ��մ��������γ����¹ʵ��嵥��,���Ե�������Ź�������ذ�����Ϣ--%>           
          <td class="prompt"><a href="javascript:showRegist('<%= registClaimDto.getRegistNo() %>"><%= registClaimDto.getRegistNo() %></a> </td> 
          <%--modify by liujianbo modify 20050321 end--%>

           <!--modify by wangwei add start 2005-06-04-->
           <!--ԭ���ڽ���������һЩ��Ϣ-->
           <td class="prompt"><%= registClaimDto.getClaimNo() %></td>
           <td class="prompt"><%= registClaimDto.getSumClaim() %></td>
           <td class="prompt"><%= registClaimDto.getSumPaidShow() %></td>
           <!--modify by wangwei add end 2005-06-04-->
           
          <td class="prompt"><%= registClaimDto.getDamageStartDate() %></td>
          <%--
          <td class="prompt"><%= registClaimDto.getLinkerName() %></td>
          <td class="prompt"><%= registClaimDto.getOperatorCode() %></td>
          <td class="prompt"><%= registClaimDto.getOperatorName() %></td>
           --%>
          <td class="prompt"><%= registClaimDto.getDamageAreaName() %></td>
          <td class="prompt"><%= registClaimDto.getDamageName() %></td>
          <td class="prompt"><%= registClaimDto.getCompName() %></td>
          <td class="prompt"><a href="javascript:showPicture('<%= registClaimDto.getRegistNo() %>')"><%= registClaimDto.getRegistNo() %></a> </td>
          <td class="prompt"><%= registClaimDto.getPhoneNumber() %></td>
          
          <td class="prompt"><%= registClaimDto.getStatus() %></td>
        </tr>       
        <%
              }
            }
            //modify by wangwei add end 2005-06-04
        %> 
       <%-- </logic:iterate> 
      </logic:notEmpty>           --%>
      <tr>  
        <td colspan=14 class="prompttitle" >
          <input type=button name = 'button_Peril_Close_Context' value='(O)�ر�'  class="button" ACCESSKEY="O" onclick="hideSubPage(this,'span_Peril_Context')">  
        </td> 
      </tr>
  </table>        
</span>
    