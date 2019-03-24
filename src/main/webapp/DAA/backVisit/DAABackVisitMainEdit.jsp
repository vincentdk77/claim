<%--
****************************************************************************
* DESC       ：显示回访主信息
* AUTHOR     ：理赔项目组
* CREATEDATE ：2005-03-24
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
  <input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
  <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
  <input type="hidden" name="newNode" class="common" value="<%=request.getParameter("newNode")%>">        
  <input type="hidden" name="fromNodeType" class="common" value="<%=request.getParameter("nodeType")%>">        
  
    
      <table  border="0" align="center" cellpadding="5" cellspacing="1" class=common>
      <tr> <td colspan=4 class="formtitle">回访信息</td></tr>
        <tr>
          <td class="title" style="width:15%"><bean:message key="db.prpLregist.registNo" />:</td>
          <td class="input" style="width:35%" >
            <input type=text name="prpLbackVisitRegistNo" class="readonly" readonly="true" value="<bean:write name='prpLbackVisitDto' property='registNo' filter='true' />">
          </td>
          <td class="title" style="width:15%" style="valign:bottom" ><bean:message key="db.prpLregist.policyNo" />:</td>
          <td class="input" style="width:35%" style="valign:middle">
            <input type=text name="prpLbackVisitPolicyNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLbackVisitDto' property='policyNo' filter='true' />">
            <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLbackVisitPolicyNo.value);return false;">
          </td>
        </tr>
        <tr>
          <td class="title">车牌号码：</td>
          <td class="input">
            <input type="text" class="readonly"  readonly="true" name="prpLbackVisitLicenseNo" value="<bean:write name="prpLbackVisitDto" property="licenseNo" />">
          </td>
          <td class="title">被保险人名称：</td>
          <td class="input">
            <input type="text" class="readonly" readonly="true"  name="prpLbackVisitInsuredName" value="<bean:write name="prpLbackVisitDto" property="insuredName" />">
            <input type="hidden" name="prpLbackVisitInsuredCode" value="<bean:write name="prpLbackVisitDto" property="insuredCode" />">
          </td>
        </tr>
        <tr>
          <td class="title">联系电话：</td>
          <td class="input">
            <input type="text" class="common" name="prpLbackVisitPhone" value="<bean:write name="prpLbackVisitDto" property="phone" />">
          </td>
          <td class="title">联系人：</td>
          <td class="input">
            <input type="text" class="common" name="prpLbackLinkerName" value="<bean:write name="prpLbackVisitDto" property="linkerName" />">
          </td>
        </tr>
        <tr>
          <td class="title">电子邮件：</td>
          <td class="input">
             <input type="text" class="common" name="prpLbackVisitEmail" value="<bean:write name="prpLbackVisitDto" property="email" />">
          </td>
          <td class="title">传真：</td>
          <td class="input">
             <input type="text" class="common" name="prpLbackVisitFax" value="<bean:write name="prpLbackVisitDto" property="fax" />">
          </td>
        </tr>
        <tr>
          <td class="title">业务类型：</td>
          <td class="input">
              <input type="hidden" name="backVisitType" class="common" value="<bean:write name="prpLbackVisitDto" property="backVisitType" />">        
             <logic:equal name="prpLbackVisitDto" property="backVisitType" value="1" >
             查勘回访
             </logic:equal>
             
             <logic:equal name="prpLbackVisitDto" property="backVisitType" value="2" >
             定损回访
             </logic:equal>
             
             
          </td>
          
          <td class="title">回访时间：</td>
          <td class="input">
             <input type="text" class="common" name="prpLbackVisitBackVisitTime" value="<bean:write name="prpLbackVisitDto" property="backVisitTime" />">
          </td>
        </tr>
        <tr>
          <td class="title">客户满意度：</td>
          <td class="input">
            <html:select name="prpLbackVisitDto" property="customOpinion" styleClass="common">
         	  <html:options  collection="customOpinionList" property="value" labelProperty="label"/>
            </html:select>
          </td>
          <td class="title">邮政编码：</td>
          <td class="input">
            <input type="text" class="common" name="prpLbackVisitPostCode" value="<bean:write name="prpLbackVisitDto" property="postCode" />">
          </td>
          
        </tr>
        <tr>
          <td class="title">联系地址：</td>
          <td class="input" colspan="3">
            <input type="text" class="common" style="width:96%"name="prpLbackVisitAddress" value="<bean:write name="prpLbackVisitDto" property="address" />">
          </td>
        </tr>
    </table>
            