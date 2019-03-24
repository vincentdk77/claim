<%--
****************************************************************************
* DESC       ：显示承保险别的页面
* AUTHOR     ： lixiang
* CREATEDATE ： 2005-02-18
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 
      <table class="common"  cellspacing="1" cellpadding="5" > 
    <tr>
      <td class="common" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="RegistPolicyRiskImg" onclick="showPage(this,RegistPolicyRisk)">
             保单承保险别
        <br>
       
         <%//modify by lixiang remark 20050308 start
        //reason:保单承保险别位置上移动，保单号后，只显示承保险别%>
       
        <table class="common" cellpadding="5" cellspacing="1" id="RegistPolicyRisk" style="display: none">
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
	
		<%--非车非意非责险要加标的名称--%>
		<logic:notEqual name="prpLregistDto" property="classCode" value="04">        
		<logic:notEqual name="prpLregistDto" property="classCode" value="05">        
		<logic:notEqual name="prpLregistDto" property="classCode" value="06">        
		<logic:notEqual name="prpLregistDto" property="classCode" value="07">        
        	<td class="prompttitle" >标的名称</td>        	
        </logic:notEqual>
        </logic:notEqual>
        </logic:notEqual>
        </logic:notEqual>                     
        
        <%-- 碎屏险添加IMEI串码 add by wangxinyang 20180614 --%>
		<logic:equal name="prpLregistDto" property="riskCode" value="0313">
			<td class="prompttitle" >IMEI码</td>
		</logic:equal>
        <%--添加保额/限额信息--%>
        <td class="prompttitle" >保额/限额</td>
        <td class="prompttitle" >币别</td>
       <%
           //modify by wangwei add start 2005-06-08
           //原因：意键险需要添加以下信息
       %>
      <logic:equal name="com.sinosoft.forward" value="ADDEAA">
        <td class="prompttitle" >标的明细名称</td>
        <td class="prompttitle" >币别</td>
        <td class="prompttitle" >每人保额</td>
        <td class="prompttitle" >人数</td>
        <td class="prompttitle" >保费</td>
        <td class="prompttitle" >保险金额</td>
      </logic:equal>
        
     </tr>
     <logic:notEmpty  name="prpCitemKindDto"  property="prpCitemKindDtoList"> 
     <logic:iterate id="prpCitemKindList"  name="prpCitemKindDto"  property="prpCitemKindDtoList">  
     
          <%if(indexCitemKind %2== 0)
               out.print("<tr class=listodd>");
          else 
               out.print("<tr class=listeven>");
       %> 
       
      <tr class=common> 
      <logic:notEqual name="prpLregistDto" property="riskCode" value="1003">
       <td ><%=indexCitemKind+1%></td>
       <td ><bean:write name="prpCitemKindList" property="kindCode"/></td>
       <td ><bean:write name="prpCitemKindList" property="kindName"/></td>
       
	   <%--非车非意非责险要加标的名称--%>
		<logic:notEqual name="prpLregistDto" property="classCode" value="04">        
		<logic:notEqual name="prpLregistDto" property="classCode" value="05">        
		<logic:notEqual name="prpLregistDto" property="classCode" value="06">        
		<logic:notEqual name="prpLregistDto" property="classCode" value="07">        
       <td ><bean:write name="prpCitemKindList" property="itemDetailName"/></td>
        </logic:notEqual>
        </logic:notEqual>
        </logic:notEqual>
        </logic:notEqual>  
       
        <%-- 碎屏险添加IMEI串码 add by wangxinyang 20180614 --%>
		<logic:equal name="prpLregistDto" property="riskCode" value="0313">
			<td><bean:write name="prpCitemKindList" property="remark"/></td>
		</logic:equal>
       <%--添加保额/限额信息--%>
       <td ><bean:write name="prpCitemKindList" property="amount" format="0.00"/></td>
       <td ><bean:write name="prpCitemKindList" property="currency"/></td>
  		</logic:notEqual>
  		<logic:equal name="prpLregistDto" property="riskCode" value="1003">
  			<logic:equal name="prpCitemKindList" property="flag" value="1">
  				<td ><%=indexCitemKind+1%></td>
		       <td ><bean:write name="prpCitemKindList" property="kindCode"/></td>
		       <td ><bean:write name="prpCitemKindList" property="kindName"/></td>
		       
			   <%--非车非意非责险要加标的名称--%>
				<logic:notEqual name="prpLregistDto" property="classCode" value="04">        
				<logic:notEqual name="prpLregistDto" property="classCode" value="05">        
				<logic:notEqual name="prpLregistDto" property="classCode" value="06">        
				<logic:notEqual name="prpLregistDto" property="classCode" value="07">        
		       <td ><bean:write name="prpCitemKindList" property="itemDetailName"/></td>
		        </logic:notEqual>
		        </logic:notEqual>
		        </logic:notEqual>
		        </logic:notEqual>  
		       
		       <%--添加保额/限额信息--%>
		       <td ><bean:write name="prpCitemKindList" property="amount" format="0.00"/></td>
		       <td ><bean:write name="prpCitemKindList" property="currency"/></td>
  			</logic:equal>
  		</logic:equal>
     <logic:equal name="com.sinosoft.forward" value="ADDEAA">
       <td ><bean:write name="prpCitemKindList" property="itemDetailName"/></td>
       <td ><bean:write name="prpCitemKindList" property="currency"/></td>
       <td ><bean:write name="prpCitemKindList" property="unitAmount" format="0.00"/></td>
       <td ><bean:write name="prpCitemKindList" property="quantity"/></td>
       <td ><bean:write name="prpCitemKindList" property="premium" format="0.00"/></td>
       <td ><bean:write name="prpCitemKindList" property="amount" format="0.00"/></td>
    </logic:equal>

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
 