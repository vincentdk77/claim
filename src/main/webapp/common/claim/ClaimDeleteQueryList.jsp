<%--
****************************************************************************
* DESC       ��������ѯ�����ʾҳ�棨������������ʹ�ã�
* AUTHOR     ��lixiang
* CREATEDATE ��2004-09-15
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
    <app:css />

  <title><bean:message key="title.claimBeforeEdit.queryClaim"/></title>
  <script src="/claim/common/js/showpage.js"> </script>
  <script language="javascript">
        /**
         *@description ��������
         *@param       ��ť����
         *@return      ͨ������true,���򷵻�false
        */

        function deleteClaim(fieldObject)
        {
        	var bussinessNo="";
        	var status="";
        	var registNo="";

        	var  intIndex = parseInt(fieldObject.num);
        	   if(isNaN(fm.buttonDelete.length))
            {
            		bussinessNo= fm.prplclaimClaimNo.value;
            		status=fm.prplclaimStatus.value;
            		registNo=fm.RegistNo.value;
            }
            else
            {
            	  bussinessNo = fm.prplclaimClaimNo[intIndex].value;
            	  status=fm.prplclaimStatus[intIndex].value;
            	  registNo=fm.RegistNo[intIndex].value;
        	 }

        	 //�����ַ����Ϊ��
        	if(bussinessNo==""){
        		alert("û�еõ�bussinessNo�������²�����");
        		return false;
        	}



        	if (status=="4")
        	{
        	   alert("�Ѿ��ύ�İ��������ܹ������г����Ĳ�����");
        		 return false;
        	}

        	 //��ʾ�Ƿ�����
        	 strMsg ="ȷ��Ҫ����ҵ�����Ϊ'"+bussinessNo+"'�İ�����?";
        	 //ִ��delete�Ĳ���
        	 if(confirm(strMsg))
          {
             fm.bussinessNo.value= bussinessNo;
             fm.claimRegistNo.value=registNo;
             //��ֹ�ظ��ύ
             fm.userLastAction.value="deleteclaim?"+bussinessNo;
             fieldObject.disabled = true;
             fm.submit();
            return true;
          }

  return false;
}

function ShowAlertMessage()
{
	var msg= fm.alertMessage.value;
	if (msg!="")
	{
		alert(msg)
		fm.alertMessage.value="";
	}
}

  </script>
  <html:base/>
</head>

<body  >
<form name=fm action="/claim/claimDeleteSave.do" method="post" >

  <table class="common" cellpadding="5" cellspacing="1" >
   <tr><td colspan=6 class="formtitle"><bean:message key="title.claimBeforeEdit.titleName" /></td></tr>
     <tr>
        <td class="centertitle" >����״̬</td>
        <td class="centertitle" ><bean:message key="db.prpLclaim.claimNo"/></td>
        <td class="centertitle" >������</td>
        <td class="centertitle" >����Ա</td>
        <td class="centertitle" >����ʱ��</td>
        <td class="centertitle" >����</td>

     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="prpLclaimDto"  property="claimList">
     <logic:iterate id="prpLclaim1"  name="prpLclaimDto"  property="claimList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
<tr class=common>
        <td align="center">
        <logic:equal name="prpLclaim1" property="status" value='1' >
         δ����
        </logic:equal>
        <logic:equal name="prpLclaim1" property="status" value='2' >
         ������
        </logic:equal>
        <logic:equal name="prpLclaim1" property="status" value='3' >
         �Ѵ���
        </logic:equal>
        <logic:equal name="prpLclaim1" property="status" value='4' >
         ���ύ
        </logic:equal>
        <logic:equal name="prpLclaim1" property="status" value='5' >
         �ѳ���
        </logic:equal>
        </td>
        <td align="center"><a href="/claim/claimFinishQueryList.do?prpLclaimClaimNo=<bean:write name='prpLclaim1' property='claimNo'/>&editType=SHOW"><bean:write name="prpLclaim1" property="claimNo"/></a></td>
        <td align="center"><bean:write name="prpLclaim1" property="registNo"/></td>
        <td align="center"><bean:write name="prpLclaim1" property="operatorCode"/></td>
        <td align="center"><bean:write name="prpLclaim1" property="operateDate"/></td>
        <td>
         <input type="button" name="buttonDelete" class='button' num=<%=index%>  value="����" onclick="return deleteClaim(this);">
         <input type="hidden" name="prplclaimClaimNo"  value="<bean:write name='prpLclaim1' property='claimNo'/>">
         <input type="hidden" name="prplclaimStatus"  value="<bean:write name='prpLclaim1' property='status'/>">
         <input type="hidden" name="RegistNo"  value="<bean:write name='prpLclaim1' property='registNo'/>">

        </td>
      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
      <tr class="listtail">
	      <td colspan="6">
	       ����ѯ��<%= index %>�����������ļ�¼
	      </td>
	      <input type="hidden" name="bussinessNo"  value="">
	      <input type="hidden" name="status" value="">
	      <input type="hidden" name="userLastAction"  value="">
	      <input type="hidden" name="queryCondtions" value="">
        <input type="hidden" name="editType" value="SHOW">
        <input type="hidden" name="claimRegistNo"  value="">

	    </tr>
    </table>
    </tr>
  </table>
</form>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>