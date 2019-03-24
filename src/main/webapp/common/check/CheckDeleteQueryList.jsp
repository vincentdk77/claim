<%--
****************************************************************************
* DESC       ��ɾ���鿱��ѯ���ҳ��
* AUTHOR     ��lixiang
* CREATEDATE ��2004-06-15
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

  <title><bean:message key="title.checkBeforeEdit.queryCheck"/></title>
          <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>

  <script language=javascript>
    function submitForm(fieldObject)
    {
      var registNo="";
      var status ="";
      var  intIndex = parseInt(fieldObject.num);
   	  if(isNaN(fm.buttonDelete.length))
      {
    	  registNo= fm.registNoRow.value;
    	  status =fm.checkStatusNoRow.value;
      }
      else
      {
        registNo= fm.registNoRow[intIndex].value;
        status = fm.checkStatusNoRow[intIndex].value;
      }


      if (status=="4" || status=="")
      {
       alert("ѡ�еĲ鿱'"+registNo+"' �Ѿ����ύ�ˣ������Խ���ɾ������!")
       return false;

      }

	   //����ȷ����ʾ
        if(confirm("ȷ��Ҫɾ��ѡ�еĲ鿱'"+ registNo+"'��"))
        {
          fm.buttonDelete.disabled = true;
          fm.registNo.value = registNo;
          fm.status.value = status;
          fm.submit();
          return true;
        }

        return false;

    }
  </script>
</head>

<body  >
<form name=fm action="/claim/checkDelete.do" method="post" onsubmit="return validateForm(this);">


  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr> <td colspan=6 class="formtitle">�鿱��ѯ�����Ϣ</td></tr>
     <tr>
        <td class="centertitle" ><bean:message key="db.prpLcheck.registNo"/></td>
        <td class="centertitle" ><bean:message key="db.prpLcheck.policyNo"/></td>
        <td class="centertitle" >�鿱��1</td>
        <td class="centertitle" >�鿱��2</td>
        <td class="centertitle" >����ʱ��</td>
        <td class="centertitle">����</td>

     </tr>
     <%int index=0;
       String strindex="";
     %>
     <logic:notEmpty  name="prpLcheckDto"  property="checkList">
     <logic:iterate id="prpLcheck1"  name="prpLcheckDto"  property="checkList">
<%
         strindex = "'"+String.valueOf(index)+"'";

          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
       <tr class=common> <td align="center"> <a href="/claim/checkFinishQueryList.do?prpLcheckCheckNo=<bean:write name='prpLcheck1' property='registNo'/>&editType=<bean:write name='prpLcheckDto' property='editType'/>&riskCode='DAA'"> <bean:write name="prpLcheck1" property="registNo"/></a></td>
        <td align="center"><bean:write name="prpLcheck1" property="policyNo"/></td>
        <td align="center"><bean:write name="prpLcheck1" property="checker1"/></td>
        <td align="center"><bean:write name="prpLcheck1" property="checker2"/></td>
        <td align="center"><bean:write name="prpLcheck1" property="checkDate"/>
        <input type="hidden" name="registNoRow" class="common" value="<bean:write name='prpLcheck1' property='registNo'/>">
        <input type="hidden" name="checkStatusNoRow" class="common" value="<bean:write name='prpLcheck1' property='status'/>">

        </td>
        <td align="center"> <input type="button" name="buttonDelete" class='button' num=<%=strindex%>  value="ɾ��" onclick="return submitForm(this);"></td>



      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
      <tr class=listtail>
      <td colspan=6 >
       ����ѯ��<%=index%>�����������ļ�¼
       <input type="hidden" name="registNo" class="common" value="">
       <input type="hidden" name="status" class="common" value="">

      </td>
      </tr>
    </table>
    </tr>
    </table>
</form>

</body>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>