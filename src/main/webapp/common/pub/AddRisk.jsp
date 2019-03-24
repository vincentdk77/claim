<%--
****************************************************************************
* DESC       ：查询新增保单页面
* AUTHOR     ：luyang
* CREATEDATE ：2003-12-25 
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<html:html>
<head>
    <app:css />
    <title>
        AddRisk
    </title>
    <script language="javascript">
  function submitForm()
  {
    opener.AddPolicy(fm.type.value,fm.classcode.value,fm.riskcode.value);
    window.close();
  }

    </script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginhigh="0">
<form name="fm">
<table width="100%" height="100%" width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
  <table width="510" border="0" cellpadding="0" cellspacing="0" align="center"> 
    <tr> 
       <td width="172" height="24" align="center" background="/claim/images/bgBarBig.gif" class="button"><font color="#FFFFFF" style='font-family宋体;font-size:12px'><b>新 增 保 单</b></font></td>
       <td width="328" background="/claim/images/bgBarHorizontalLine.gif">&nbsp;</td>
       <td align="right"><img src="/claim/images/bgClaimBlueRightNode.gif" width="10" height="24"></td>
    </tr>
  </table>
  <table width="510" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
      <td width="6" height="130" background="/claim/images/bgBarVerticalLine1.gif"></td>
      <td>
        <table width="494" height="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#1D4356">
          <tr>
             <td bgcolor="EFFAFF">
                 <table align="center" border="0" cellpadding="5" cellspacing="0">
                       <tr>
                          <td class="title2">
                              险类：
                             <select name="classcode">
                                <option >---请选择险类代码---</option>
                                <option value="Q">Q</option>
                                <option value="A">A</option>
                             </select>
                          </td>
                          <td class="title2">
                             险种：
                            <select name="riskcode">
                              <option>---请选择险种代码---</option>
                              <option value="QAA">QAA</option>
                            </select>
                         </td>
                      </tr>
                      <tr align="center">
                         <td class="title2" width="50%" align="center"><input type="hidden" name="type" value="<%=request.getParameter("type")%>"><input type="submit" class="button1" onclick="submitForm();" value="提 交"></td>
                         <td class="title2" width="50%" align="center"><input type="reset" class="button1" value="重 置"></td>
                       </tr>
                   </table>
                </td>
             </tr>
          </table>
        </td>
        <td width="10" background="/claim/images/bgBarVerticalLine2.gif"></td>
      </tr>
  </table>
  <table width="510" border="0" cellpadding="0" cellspacing="0" align="center">
      <tr>
         <td><img src="/claim/images/bgBlueLeftNode.gif" width="6" height="13"></td>
         <td width="494" align="center" valign="middle" background="/claim/images/bgBlueLine.gif"></td>
         <td align="right"><img src="/claim/images/bgBlueRightNode.gif" width="10" height="13"></td>
      </tr>
  </table>
</td>
</tr>
</table></form>
</body>
</html:html>
