<%--
****************************************************************************
* DESC       ：显示回访问询信息
* AUTHOR     ：理赔项目组
* CREATEDATE ：2005-03-24
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
   <table class="common" align="center" cellpadding="5" cellspacing="1"> 
    <tr>
      <td class="common" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"   
             name="BackVisitQueImg" onclick="showPage(this,BackVisitQue)">
             回访问询信息
        <br>
        <table class="common" align="center" cellpadding="5" cellspacing="1" id="BackVisitQue" style="display:">
          <tbody>
       
          <%
            int intTemp = 0;
            String trClass = "";
          %>
<logic:iterate id="prpDCodeDto" name="prpdCodeList">
         <%
           intTemp++;
           if(intTemp%2==0)
           {
             trClass = "listodd";
           }
           else
           {
             trClass = "listeven";
           }
         %>
          <tr class=<%=trClass%>>
            <td align="left" style="width:50%" colspan=3><%=intTemp%>、<bean:write name="prpDCodeDto" property="codeCName" filter="true"/>
              <input type="radio" name="VisitBackQue<%=intTemp%>" value="1">是
              <input type="radio" name="VisitBackQue<%=intTemp%>" value="0">否
              <input type="radio" name="VisitBackQue<%=intTemp%>" value="2">不确定
              
              <input type="hidden" name="txtQuestionCode<%=intTemp%>" value="<bean:write name="prpDCodeDto" property="codeCode" filter="true"/>">
              <input type="hidden" name="txtQuestionName<%=intTemp%>" value="<bean:write name="prpDCodeDto" property="codeCName" filter="true"/>">
            </td>
            <td>
              <input type="text"  name="txtQuestionRemark<%=intTemp%>" class="common"  maxlength="255">
            </td>
          </tr>
      
</logic:iterate>
          <input type="hidden" name="txtRecordNum" value="<%=intTemp%>">
          </tbody>
        </table>
      </td>
    </tr>
  </table>
