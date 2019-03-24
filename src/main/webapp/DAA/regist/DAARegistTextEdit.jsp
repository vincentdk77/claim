<%--
****************************************************************************
* DESC       ：显示报案文字页面(1: 出险摘要；2: 拒赔/注销原因；3: 查勘报告)，要传参数TextType
* AUTHOR     ：魏士鑫
* CREATEDATE ：2004-03-03
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
   <table class="common"  cellspacing="1" cellpadding="5">
    <tr class=mline>
      <td class="common" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"   
             name="RegistTextImg" onclick="showPage(this,RegistText)">
         <logic:equal name="prpLregistTextDto" property="textType" value="1">
               <bean:message key="db.regist.registText.textType1" />
         </logic:equal> 
               <logic:equal name="prpLregistTextDto" property="textType" value="2">
               <bean:message key="db.regist.registText.textType2" />
         </logic:equal>    
         <logic:equal name="prpLregistTextDto" property="textType" value="3">
               <bean:message key="db.regist.registText.textType3" />
         </logic:equal>
        <br>
      <table class="common" align="center" id="RegistText"  cellspacing="1" cellpadding="5">
          <tbody>
            <tr>
              <td class="title" style="text-align:center;" >
              <textarea style="wrap:hard" rows="4" cols="80" name="prpLregistTextContextInnerHTML"><bean:write name="prpLregistTextDto" property="context"/></textarea>              
               
                <!--Modify by chenrenda add begin 20050410-->
                <!--Reason:根据大地需求，出险摘要根据用户定义规则自动生成
                 <logic:equal name="prpLregistTextDto" property="textType" value="1">
                   <input type="button" name="btnRegistText" class=bigbutton value="生成出险摘要" onclick="return generateRegistText();">
                 </logic:equal>--> 
                <!--Modify by chenrenda add end 20050410-->
              </td>
            </tr>
          </tbody>
        </table>
      </td>
    </tr>
  </table>


<!--- add by zhaolu 20060912 start --->
<%
	if( (String)request.getAttribute("context") == null ||"".equals((String)request.getAttribute("context")))
	{
%>
<%
  }
  else
  	{
%>

 <table class="common"  cellspacing="1" cellpadding="5">
    <tr class=mline>
      <td class="common" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="RegistTextImg" onclick="showPage(this,RegistText2)">
             <bean:message key="db.regist.registText.textType2" />
        <br>
      <table class="common" align="center" id="RegistText2" style="display:none" cellspacing="1" cellpadding="5">
          <tbody>
            <tr>
              <td class="title" style="text-align:center;" >
              <textarea style="wrap:hard" rows="15" cols="80" name="prpLregistTextContextInnerHTML2"><%=(String)request.getAttribute("context")%></textarea>              
              </td>
            </tr>
          </tbody>
        </table>
      </td>
    </tr>
  </table>

<%
  }
%>
