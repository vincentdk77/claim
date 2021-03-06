<%--
****************************************************************************
* DESC       ：撤消报案查询结果页面
* AUTHOR     ：lixiang
* CREATEDATE ：2004-06-15
* MODIFYLIST ：   id       Date            Reason/Contents
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

  <title><bean:message key="title.registBeforeEdit.queryRegist"/></title>
          <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>

  <script language=javascript>
    function submitForm(fieldObject)
    {
      var registNo="";
      var  intIndex = parseInt(fieldObject.num);
   	  if(isNaN(fm.buttonDelete.length))
      {
    	  registNo= fm.registNoRow.value;
      }
      else
      {
        registNo= fm.registNoRow[intIndex].value;
      }
	   //撤消确认提示
        if(confirm("确定要删除选中的报案'"+ registNo+"'吗？"))
        {
          fm.buttonDelete.disabled = true;
          fm.registNo.value = registNo;
          fm.submit();
          return true;
        }

        return false;

    }
  </script>
</head>

<body  >
<form name=fm action="/claim/registDelete.do" method="post" onsubmit="return validateForm(this);">


  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr><td colspan=5 class="formtitle">报案查询结果信息</td></tr>
     <tr>
        <td class="centertitle" ><bean:message key="db.prpLregist.registNo"/></td>
        <td class="centertitle" ><bean:message key="db.prpLregist.policyNo"/></td>
        <td class="centertitle" ><bean:message key="db.prpLregist.operatorCode"/></td>
        <td class="centertitle" >输入时间</td>
        <td class="centertitle">操作</td>

     </tr>
     <%int index=0;
       String strindex="";
     %>
     <logic:notEmpty  name="prpLregistDto"  property="registList">
     <logic:iterate id="prpLregist1"  name="prpLregistDto"  property="registList">
<%
         strindex = "'"+String.valueOf(index)+"'";

          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
<tr class=common>
        <td align="center"> <a href="/claim/registFinishQueryList.do?prpLregistRegistNo=<bean:write name='prpLregist1' property='registNo'/>&editType=<bean:write name='prpLregistDto' property='editType'/>"> <bean:write name="prpLregist1" property="registNo"/></a></td>
        <td align="center"><bean:write name="prpLregist1" property="policyNo"/></td>
        <td align="center"><bean:write name="prpLregist1" property="operatorName"/></td>
        <td align="center"><bean:write name="prpLregist1" property="inputDate"/>
        <input type="hidden" name="registNoRow" class="common" value="<bean:write name='prpLregist1' property='registNo'/>">
        </td>
        <td align="center"> <input type="button" name="buttonDelete" class='button' num=<%=strindex%>  value="删除" onclick="return submitForm(this);"></td>



      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
      <tr class=listtail>
      <td colspan=5 >
       共查询出<%=index%>条满足条件的记录
       <input type="hidden" name="registNo" class="common" value="">
      </td>
      </tr>
    </table>
    </tr>
    </table>
</form>

</body>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>