<%--
****************************************************************************
* DESC       ���ѳ�����Ϣ��ʾ����
* AUTHOR     �� Sinosoft
* CREATEDATE �� 2005-07-04
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<%@ page import="java.util.*" %>
<%@ page import="com.sinosoft.claim.dto.custom.*"%>
<%@ page import="com.sinosoft.claim.dto.domain.*"%>

<html>
<head>
  <title>���ѳ�����Ϣ��ʾ</title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
<SCRIPT LANGUAGE="JavaScript">
//��ť�����¼���������ͬ��������౨������ʾ

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
    //var linkURL = "/claim/DAA/certify/DAACertifyViewFile.jsp?businessNo="+registNo+"&display=all";	 
    var linkURL = "/claim/common/certify/CertifyViewAllFile.jsp?businessNo=" + registNo; 
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");    
} 

//modify by liujianbo modify 20050321 end

//--> 
</SCRIPT>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginhigh="0">
<form name="fm">
  <table class="common" cellpadding="5" cellspacing="1">
      <tr >
        <td class="prompttitle">���</td>
        <td class="prompttitle">������</td>
        
        <!--modify by wangwei add start 2005-06-04-->
        <!--ԭ���ڽ���������һЩ��Ϣ-->
        <td class="prompttitle">������</td>
        <!--modify by wangwei add end 2005-06-04-->
        
        <td class="prompttitle">����ʱ��</td>
        <%--
        <td class="prompttitle">��ϵ��</td> 
        <td class="prompttitle">��������</td>
        <td class="prompttitle">����������</td> 
        --%>
        <td class="prompttitle">���յص�</td> 
        <td class="prompttitle">״̬</td>  
      </tr> 
    
    
        <!-- ������մ�����ϸ��Ϣ-->  
        <%
            /*
            Collection prpLregregistDtoList = new ArrayList();
            PrpLregistDto prpLregistDto = null;
            PrpLregistDto prpLregistDto2 = null;
            
            prpLregistDto2 = (PrpLregistDto)request.getAttribute("prpLregistDto1");
            prpLregregistDtoList = prpLregistDto2.getRegistList();
            Iterator it = prpLregregistDtoList.iterator();
            while(it.hasNext())
            {
              prpLregistDto = (PrpLregistDto)it.next();
              
            }
            */
            
            String curRegistNo = (String)request.getAttribute("curRegistNo");
            
            //modify by wangwei add start 2005-06-04
            //ԭ�򣺴�������Ϣ���д���������Ϣ
            ArrayList registClaimDtoList = (ArrayList) request.getAttribute("registClaimDtoList");
            
            if (registClaimDtoList != null) {
            for (int count = 0; count < registClaimDtoList.size(); count++ ) {
                RegistClaimInfoDto registClaimDto = (RegistClaimInfoDto) registClaimDtoList.get(count);
                //���˱�����
                if(registClaimDto.getRegistNo().equals(curRegistNo))
                  continue;

                int sequenceNo = count + 1;  
                
        %>
        <tr>        
          <td class="prompt"><%= sequenceNo %></td> 
          <%--modify by liujianbo modify 20050321 start--%>
          <%--resson:�ڱ����Ǽǻ����У��ѳ��մ��������γ����¹ʵ��嵥��,���Ե�������Ź�������ذ�����Ϣ--%>           
          <td class="prompt"><a href="javascript:showRegist('<%= registClaimDto.getRegistNo() %>')"><%= registClaimDto.getRegistNo() %></a> </td> 
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
      <tr>  
        <td colspan=14 class="common" align="center">
          <input type=button name = 'button_Peril_Close_Context' class=button value='(O)�ر�'  ACCESSKEY="O" onclick="window.close()">  
        </td> 
      </tr>
  </table>        
</form>  
</body>
</html>
