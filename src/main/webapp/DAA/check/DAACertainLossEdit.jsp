
  <script src="/claim/DAA/certainLoss/js/DAACertainLossRepairComponentEdit.js"></script>
   <table class="common" align="center" width="100%"> 
    <tr>
      <td class="subformtitle" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="CertainLossInsertImg" onclick="showPage(this,CertainLossInsert)">
             ¼�붨����Ϣ
        <br>    
        <table class="common" align="center" id="CertainLossInsert" style="display:none">
          <tr>
            <td> 
              <%! 
                int indexCertainLoss = 0;
                int repairFeeNo = 0; 
                int componentNo = 0; 
                String flag = null;
              %>
              <% 
                flag = request.getParameter("flag");
                System.out.println("----------�������ı�־---11111s----" + flag);
              %>
              <%-- ��������Ļ��� --%>
                <%@include file="/DAA/check/DAACertainLossMainEdit.jsp"%> 
              <%-- 1.���𻷽ڹ��̵�����/�����嵥ҳ�� --%> 
                <%@include file="/DAA/certainLoss/DAACertainLossRepairComponentEdit.jsp"%>
            </td>
          </tr>
       </table> 
      </td>
    </tr>
  </table>