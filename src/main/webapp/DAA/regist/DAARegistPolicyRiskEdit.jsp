<%--
****************************************************************************
* DESC       ����ʾ�б��ձ��ҳ��
* AUTHOR     �� lixiang
* CREATEDATE �� 2005-02-18
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 
      <table class="common"  cellspacing="1" cellpadding="5" > 
    <tr>
      <td class="common" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="RegistPolicyRiskImg" onclick="showPage(this,RegistPolicyRisk)">
             �����б��ձ�
        <br>
       
         <%//modify by lixiang remark 20050308 start
        //reason:�����б��ձ�λ�����ƶ��������ź�ֻ��ʾ�б��ձ�%>
       
        <table class="common" cellpadding="5" cellspacing="1" id="RegistPolicyRisk" style="display: none">
        <%       //modify by lixiang remark 20050308 end%>
        
         </tbody>
    <%//modify by lixiang remark 20050315 start
     //reason:ȥ���ڵ����Ƶ�ת��
     //��������
     
     int indexCitemKind=0;%>
     <tr>
        <td class="prompttitle" >���</td>
        <td class="prompttitle" >�ձ����</td>
        <td class="prompttitle" >�ձ�����</td>
	
		<%--�ǳ����������Ҫ�ӱ������--%>
		<logic:notEqual name="prpLregistDto" property="classCode" value="04">        
		<logic:notEqual name="prpLregistDto" property="classCode" value="05">        
		<logic:notEqual name="prpLregistDto" property="classCode" value="06">        
		<logic:notEqual name="prpLregistDto" property="classCode" value="07">        
        	<td class="prompttitle" >�������</td>        	
        </logic:notEqual>
        </logic:notEqual>
        </logic:notEqual>
        </logic:notEqual>                     
        
        <%-- ���������IMEI���� add by wangxinyang 20180614 --%>
		<logic:equal name="prpLregistDto" property="riskCode" value="0313">
			<td class="prompttitle" >IMEI��</td>
		</logic:equal>
        <%--��ӱ���/�޶���Ϣ--%>
        <td class="prompttitle" >����/�޶�</td>
        <td class="prompttitle" >�ұ�</td>
       <%
           //modify by wangwei add start 2005-06-08
           //ԭ���������Ҫ���������Ϣ
       %>
      <logic:equal name="com.sinosoft.forward" value="ADDEAA">
        <td class="prompttitle" >�����ϸ����</td>
        <td class="prompttitle" >�ұ�</td>
        <td class="prompttitle" >ÿ�˱���</td>
        <td class="prompttitle" >����</td>
        <td class="prompttitle" >����</td>
        <td class="prompttitle" >���ս��</td>
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
       
	   <%--�ǳ����������Ҫ�ӱ������--%>
		<logic:notEqual name="prpLregistDto" property="classCode" value="04">        
		<logic:notEqual name="prpLregistDto" property="classCode" value="05">        
		<logic:notEqual name="prpLregistDto" property="classCode" value="06">        
		<logic:notEqual name="prpLregistDto" property="classCode" value="07">        
       <td ><bean:write name="prpCitemKindList" property="itemDetailName"/></td>
        </logic:notEqual>
        </logic:notEqual>
        </logic:notEqual>
        </logic:notEqual>  
       
        <%-- ���������IMEI���� add by wangxinyang 20180614 --%>
		<logic:equal name="prpLregistDto" property="riskCode" value="0313">
			<td><bean:write name="prpCitemKindList" property="remark"/></td>
		</logic:equal>
       <%--��ӱ���/�޶���Ϣ--%>
       <td ><bean:write name="prpCitemKindList" property="amount" format="0.00"/></td>
       <td ><bean:write name="prpCitemKindList" property="currency"/></td>
  		</logic:notEqual>
  		<logic:equal name="prpLregistDto" property="riskCode" value="1003">
  			<logic:equal name="prpCitemKindList" property="flag" value="1">
  				<td ><%=indexCitemKind+1%></td>
		       <td ><bean:write name="prpCitemKindList" property="kindCode"/></td>
		       <td ><bean:write name="prpCitemKindList" property="kindName"/></td>
		       
			   <%--�ǳ����������Ҫ�ӱ������--%>
				<logic:notEqual name="prpLregistDto" property="classCode" value="04">        
				<logic:notEqual name="prpLregistDto" property="classCode" value="05">        
				<logic:notEqual name="prpLregistDto" property="classCode" value="06">        
				<logic:notEqual name="prpLregistDto" property="classCode" value="07">        
		       <td ><bean:write name="prpCitemKindList" property="itemDetailName"/></td>
		        </logic:notEqual>
		        </logic:notEqual>
		        </logic:notEqual>
		        </logic:notEqual>  
		       
		       <%--��ӱ���/�޶���Ϣ--%>
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
 