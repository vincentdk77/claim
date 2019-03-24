<%--
****************************************************************************
* DESC       ：显示承保险别的页面
* AUTHOR     ： lixiang
* CREATEDATE ： 2005-02-18
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 
      <table class="common" align="center" width="100%"> 
    <tr>
      <td class="subformtitle" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"   
             name="RegistPolicyRiskImg" onclick="showPage(this,RegistPolicyRisk)">
             险种保益信息
        <br>
       
         <%//modify by lixiang remark 20050308 start
        //reason:保单承保险别位置上移动，保单号后，只显示承保险别%>
       
        <table class="common" align="center" id="RegistPolicyRisk" >
        <%       //modify by lixiang remark 20050308 end%>
        
         </tbody>
    <%//modify by lixiang remark 20050315 start
     //reason:去掉节点名称的转换
     //报案对象
     
     int indexCitemKind=0;%>
     <tr>
        <td class="prompttitle" >序号</td>
        <td class="prompttitle" >险别代码</td>
        <td class="prompttitle" >险别名称</td>
        <td class="prompttitle" >标的明细名称</td>
        <td class="prompttitle" >币别</td>
        <td class="prompttitle" >每人保额</td>
        <td class="prompttitle" >人数</td>
        <td class="prompttitle" >保费</td>
        <td class="prompttitle" >保险金额</td>
        
     </tr>
     <logic:notEmpty  name="prpCitemKindDto"  property="prpCitemKindDtoList"> 
     <logic:iterate id="prpCitemKindList"  name="prpCitemKindDto"  property="prpCitemKindDtoList">  
     
          <%if(indexCitemKind %2== 0)
               out.print("<tr class=listodd>");
          else 
               out.print("<tr class=listeven>");
       %> 
       <td ><%=indexCitemKind+1%></td>
       <td ><bean:write name="prpCitemKindList" property="kindCode"/></td>
       <td ><bean:write name="prpCitemKindList" property="kindName"/></td>
       <td ><bean:write name="prpCitemKindList" property="itemDetailName"/></td>
       <td ><bean:write name="prpCitemKindList" property="currency"/></td>
       <td ><bean:write name="prpCitemKindList" property="unitAmount"/></td>
       <td ><bean:write name="prpCitemKindList" property="quantity"/></td>
       <td ><bean:write name="prpCitemKindList" property="premium"/></td>
       <td ><bean:write name="prpCitemKindList" property="amount"/></td>
    
      <%
          //modify by wangwei add end 2005-06-08
      %>
       </tr>   
    <% indexCitemKind++;%>
      </logic:iterate>
      </logic:notEmpty>
  
       <%//modify by lixiang remark 20050315 end  %>   
          </tbody>
        </table>
      </td>
    </tr>
  </table>
 