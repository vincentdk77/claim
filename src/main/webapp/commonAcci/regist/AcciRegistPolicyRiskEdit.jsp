<%--
****************************************************************************
* DESC       ����ʾ�б��ձ��ҳ��
* AUTHOR     �� lixiang
* CREATEDATE �� 2005-02-18
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 
      <table class="common" align="center" width="100%"> 
    <tr>
      <td class="subformtitle" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"   
             name="RegistPolicyRiskImg" onclick="showPage(this,RegistPolicyRisk)">
             ���ֱ�����Ϣ
        <br>
       
         <%//modify by lixiang remark 20050308 start
        //reason:�����б��ձ�λ�����ƶ��������ź�ֻ��ʾ�б��ձ�%>
       
        <table class="common" align="center" id="RegistPolicyRisk" >
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
        <td class="prompttitle" >�����ϸ����</td>
        <td class="prompttitle" >�ұ�</td>
        <td class="prompttitle" >ÿ�˱���</td>
        <td class="prompttitle" >����</td>
        <td class="prompttitle" >����</td>
        <td class="prompttitle" >���ս��</td>
        
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
 