
  <script src="/claim/DAA/certainLoss/js/DAACertainLossRepairComponentEdit.js"></script>
   <table class="common" cellpadding="5" cellspacing="1"> 
    <tr>
      <td class="common" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="CheckInsertImg" onclick="showPage(this,CheckInsert)">
             ¼��鿱��Ϣ
        <br>    
        <table class="common" cellpadding="5" cellspacing="1" id="CheckInsert" style="display:none">
          <tr class=common>  
            <td> 
                <%-- 1.�鿱/���鿱����Ϣ --%> 
                  <%@include file="/DAA/certainLoss/DAACheckMainEdit.jsp" %>
                <%-- 2.�鿱/���鿱��չ --%>
                  <%@include file="/DAA/check/DAACheckExtEdit.jsp"%>
                <%-- 3.�永���� --%>                                       
                  <%@include file="/DAA/claim/DAAClaimThirdPartyEdit.jsp"%>
                <%--  �Ʋ���ʧ��λ��Ϣ --%>
                 <%@include file="/DAA/regist/DAARegistThirdPropEdit.jsp"%>  
                 
                <%-- 4.��ʧ�����Ϣ --%>                                   
                  <%@include file="/DAA/check/DAACheckLossEdit.jsp"%>  
                <%-- 4.1 ���˸�����Ϣ --%>
                    <%@include file="/DAA/claim/DAAClaimPersonTraceEdit.jsp"%>    
                          
                <%-- 5.��ʻԱ��Ϣ --%>                                     
                  <%@include file="/DAA/claim/DAAClaimDriverEdit.jsp"%>      
     
                <%-- 6.�鿱��ע��Ϣ --%>                              
                 <%@include file="/DAA/regist/DAARegistTextEdit.jsp"%> 
            </td>
          </tr>
       </table> 
      </td>
    </tr>
  </table>  