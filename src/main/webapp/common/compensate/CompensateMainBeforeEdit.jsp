<%--
****************************************************************************
* DESC       ���������Ϣ�ӿ����ҳ��[ �᰸ ]
* AUTHOR     �� wangli
* CREATEDATE �� 2005-04-18
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="java.util.*"%>
     <%
       PrpLcompensateDto prpLcompensateDto=(PrpLcompensateDto)request.getAttribute("prpLcompensateDto");
       List list=(ArrayList)prpLcompensateDto.getCompensateList();
       double sumPaid=0; 
       if(list.size()>0){
         for(int i=0;i<list.size();i++){
         prpLcompensateDto=(PrpLcompensateDto)list.get(i);
         sumPaid+=prpLcompensateDto.getSumPaid();
         
         }
       }
     
     
     
     %>
   <logic:notEmpty  name="prpLcompensateDto"  property="compensateList"> 
 
  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr>  <td colspan=5 class="formtitle">������Ϣ</td></tr>
     <tr>        
        <td class="centertitle" >����״̬</td>
        <td class="centertitle" >���������</td>
        <td class="centertitle" >������</td>
        <td class="centertitle" >������</td>
        <td class="centertitle" >���⸶���(CNY)</td>
     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="prpLcompensateDto"  property="compensateList"> 
     <logic:iterate id="prpLcompensate1"  name="prpLcompensateDto"  property="compensateList">  
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
      <tr class=common><td align="center">
           <logic:equal name="prpLcompensate1" property="underWriteFlag" value='0' >
         �ݴ�
        </logic:equal>
        <logic:equal name="prpLcompensate1" property="underWriteFlag" value='1' >
         ����ͨ��
        </logic:equal>
        <logic:equal name="prpLcompensate1" property="underWriteFlag" value='2' >
         ���ⲻͨ��
        </logic:equal>
        <logic:equal name="prpLcompensate1" property="underWriteFlag" value='3' >
         �������
        </logic:equal>
        <logic:equal name="prpLcompensate1" property="underWriteFlag" value='9' >
         ������
        </logic:equal> 
      </td>
        <td align="center"> <a href="/claim/compensateFinishQueryList.do?prpLcompensateCompensateNo=<bean:write name='prpLcompensate1' property='compensateNo'/>&nodeType=compp&editType=SHOW&riskCode=<bean:write name="prpLcompensate1" property="riskCode"/>"> <bean:write name="prpLcompensate1" property="compensateNo"/></a></td>    
        <td align="center"><bean:write name="prpLcompensate1" property="claimNo"/></td>
        <td align="center"><bean:write name="prpLcompensate1" property="policyNo"/></td>
        <td align="center"><bean:write name="prpLcompensate1" property="sumPaid"/>
        <input type="hidden" name="SumPaid" value="<%=sumPaid%>">
        <input type="hidden" name="RiskCode" value="<bean:write name="prpLcompensate1" property="riskCode"/>">
        </td>
        <input type="hidden" name="prpLcompensateCompensateNo" value="<bean:write name='prpLcompensate1' property='compensateNo'/>">
      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
   <tr class="listtail">
     <td colspan="5">
       ����<%= index %>�����������ļ�¼
     </td>
   </tr>
    </table>
    </tr>
  </table>
 </logic:notEmpty>
