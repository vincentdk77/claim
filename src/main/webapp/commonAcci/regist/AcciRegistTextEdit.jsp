<%--
****************************************************************************
* DESC       ：录入/显示事故经过及其事故者现状 1事故经过及其事故者现状 2为调查描叙
* AUTHOR     ：wangwei
* CREATEDATE ：2005-06-08
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
  
   <table class="common" align="center" width="100%">
    <tr class=mline>
      <td class="subformtitle" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="RegistTextImg" onclick="showPage(this,RegistText)">
         <logic:equal name="prpLregistTextDto" property="textType" value="1">
               事故经过及其事故者现状
         </logic:equal> 
          <logic:equal name="prpLregistTextDto" property="textType" value="2">
               调查描述
         </logic:equal>    
         <logic:equal name="prpLregistTextDto" property="textType" value="3">
                调查描述
         </logic:equal>
        <br>
      <table class="common" align="center" id="RegistText" style="display:none">
          <tbody>
            <tr>
              <td class="title" style="text-align:center;" colspan="0">
              <%if(editType.equals("ADD")){ %>
              <logic:notEmpty name="prpLregistTextDto" property="context" >
	          	  <textarea style="wrap:hard" rows="15" cols="80" name="prpLregistTextContextInnerHTML"><bean:write name="prpLregistTextDto" property="context"/>
                  </textarea>
	          </logic:notEmpty>
	          <logic:empty name="prpLregistTextDto" property="context" >
                  <textarea style="wrap:hard" rows="15" cols="80" name="prpLregistTextContextInnerHTML">
事故经过：
事故结果：
事故者现状： 
			  </textarea>   
			  </logic:empty>
              <%}else{%>
                  <textarea style="wrap:hard" rows="15" cols="80" name="prpLregistTextContextInnerHTML"><bean:write name="prpLregistTextDto" property="context"/></textarea>              
              <%}%>  
              </td>
            </tr>
          </tbody>
        </table>
      </td>
    </tr>
  </table>
