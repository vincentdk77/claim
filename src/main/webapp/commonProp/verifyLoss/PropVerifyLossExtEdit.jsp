<%--
****************************************************************************
* DESC       ����Ӷ����𲹳�˵��ҳ��
* AUTHOR     ��sunchenggang
* CREATEDATE �� 2006-03-20
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.claim.query.ui.control.actioin.UICodeAction"%>
<%@ page contentType="text/html; charset=GBK" %>
   <!--������ʾ��¼����������������ʾ��-->
<%@ page import="java.util.*"%>
    <script language='javascript'>
		   <!--
      //��������뱾ҳ�Զ����JavaScript����

      /*
        ����һ���µ�֮��Ĵ�����ѡ������
      */
      function afterInsertCertainLossExt()
      {
        setPrpLverifyLossExtSerialNo();
      }

      /*
        ɾ������WarnRegion֮��Ĵ�����ѡ������
      */
      function afterDeleteCertainLossExt(field)
      {
        setPrpLverifyLossExtSerialNo();
      }

      /**
       * ����setPrpLverifyLossExtSerialNo
       */
      function setPrpLverifyLossExtSerialNo(){
        var count=getElementCount("prpLverifyLossExtSerialNo");
        for(var i=0;i<count;i++)
        {
          //alert("����ʲôʱ������?count="+count+"  i="+i);
          if(count!=1){
              fm.prpLverifyLossExtSerialNo[i].value=i;
          }
        }
      }
		   //-->
    </script>
	<%String status = request.getParameter("status");%>
	<input type="hidden" name="status" value="<%=status%>"/>
    <input type="hidden"  name="prpLverifyLossExtRegistNo" value="<bean:write name='prpLverifyLossExtDto' property='registNo' />">
    <input type="hidden"  name="prpLverifyLossExtRiskCode" value="<bean:write name='prpLverifyLossExtDto' property='riskCode' />">
   <table class="common"  cellspacing="1" cellpadding="5">
    <!--��ʾ��ʾ���е�-->
    <tr>
      <td class="common" colspan="4" style="text-align:left;">
      <!--��modify by wuxiaodong 050905 begain reasion ��������ϵ��¼��Ϊ��ע-->
      <!--
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="CertainLossExtImg" onclick="showPage(this,spanCertainLossExt)">
             ������ϵ��¼<br>-->
             <img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
             name="CertainLossExtImg" onclick="showPage(this,spanCertainLossExt)">
             �����������ϸ��Ϣ<br>
        <!-- modify by wuxiaodong 050905 end -->
        <span style="display:none">
          <table class="common" style="display:none" id="CertainLossExt_Data" cellspacing="1" cellpadding="5">
            <tbody>
              <tr>
                <td class="input"  style="width:6%">
                  <input type="hidden"  name="prpLverifyLossExtFlag">
                  <input type="text" class="readonly" readonly  name="prpLverifyLossExtSerialNo" description="���">
                </td>
                <%
                  String time3 = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY).toString();
                  String time4 = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND).getHour()+"ʱ"+new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND).getSecond()+"��";
                %>
                <td class="input"  style="width:18%">
                  <input type="text" name="prpLverifyLossExtInputDate" class="readonly" readonly style="width:45%" value="<%= time3 %>"><input  type="text" name="prpLverifyLossExtInputHour" class="readonly" readonly style="width:47%" value="<%= time4 %>">
                </td>
                <td class="input"  style="width:12%">
<%                
   if(editType.equals("SHOW")){
   	}else{
   	%>        <input type="hidden"  name="prpLverifyLossExtOperatorCode"  value="<bean:write name='user' property='userCode'/>">
                  <input type="text"  name="prpLverifyLossExtOperatorName" class="readonly" readonly style="width:100%" value="<bean:write name='user' property='userName'/>">
		<%}%>                  
                </td>
                <td class="input"  style="width:15%">
                  <input  type="text" name="prpLverifyLossExtTitle" class="input" style="width:100%" maxlength='20'>
                </td>
                <td class="input"  style="width:45%">
                  <input  type="text" name="prpLverifyLossExtContext" class="input" style="width:100%" maxlength='125' onblur="checkLength1(this);" description="����">
                </td>
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type=button name="buttonCertainLossExtDelete" class=smallbutton onclick="deleteRow(this,'CertainLossExt')" value="-" style="cursor: hand">
                </div>
                </td>
              </tr>
            </tbody>
          </table>
        </span>

        <span  id="spanCertainLossExt" style="" cellspacing="1" cellpadding="0">
        <%-- ��������չ���� --%>
        <table class="common"  id="CertainLossExt" cellspacing="1" cellpadding="5">
          <thead>
            <tr>
                <td class="centertitle" style="width:6%">���</td>
                <td class="centertitle" style="width:18%">ʱ��</td>
                <td class="centertitle" style="width:12%">����Ա</td>
                <td class="centertitle" style="width:15%">���</td>
                <td class="centertitle" style="width:45%">����</td>
              <td class="centertitle" style="width:4%" >&nbsp;</td>
            </tr>
          </thead>
          <!-- tfoot>
              <tr>
                <td class="title" colspan=5 >(��"+"�ż����ӱ�ע��Ϣ����"-"�ż�ɾ����Ϣ)</td>
                 <td class="title" align="right" style="width:4%">
                 <div align="center">
<!--%  //modify by qinyongli ��ѯʱ����ť��Ϊֻ�� 2005-8-31
   editType = request.getParameter("editType");
   if(editType.equals("SHOW")||editType.equals("DELETE")){
%>
                 <input type="button" disabled value="+" class=smallbutton  name="buttonCertainLossExtInsert">
<!--%}else{%>
 <input type="button" value="+" class=smallbutton onclick="insertRowCertainLossExt('CertainLossExt')" name="buttonCertainLossExtInsert" style="cursor: hand">
<!--%}%>
                 </div>
                 </td>
              </tr>
           </tfoot-->
          <tbody>
 <% int indexCertainLossExt=0;
 PrpLverifyLossExtDto prpLverifyLossExtDto = (PrpLverifyLossExtDto)request.getAttribute("prpLverifyLossExtDto");
 ArrayList verifyLossExtList = (ArrayList)prpLverifyLossExtDto.getVerifyLossExtList();
 if(verifyLossExtList != null){
 	for(indexCertainLossExt=0;indexCertainLossExt<verifyLossExtList.size();indexCertainLossExt++){
 	PrpLverifyLossExtDto verifyLossExt1 = (PrpLverifyLossExtDto)verifyLossExtList.get(indexCertainLossExt);
 %>
              <tr>
                <td class="input"  style="width:6%">
                  <input type="hidden"  name="prpLverifyLossExtFlag" value="">
                  <input  type="text"  name="prpLverifyLossExtSerialNo" class="readonly" readonly value="<%=verifyLossExt1.getSerialNo()%>">
                </td>
                <td class="input"  style="width:18%">
                  <input  type="text" name="prpLverifyLossExtInputDate" class="readonly" readonly style="width:45%" value="<%=verifyLossExt1.getInputDate()%>">&nbsp;<input  type="text" name="prpLverifyLossExtInputHour" class="readonly" readonly style="width:47%" value="<%=verifyLossExt1.getInputHour()%>">
                </td>
                <%if( ("0".equals(status) || "3".equals(status)) && indexCertainLossExt == verifyLossExtList.size()-1){%>
                <td class="input"  style="width:12%">
                  <input  type="text" name="prpLverifyLossExtOperatorName" class="readonly" readonly style="width:100%" value="<bean:write name='user' property='userName'/>">
                  <input  type="hidden" name="prpLverifyLossExtOperatorCode" class="readonly" readonly style="width:100%" value="<bean:write name='user' property='userCode'/>">
                </td>
                <%}else{%>
                <td class="input"  style="width:12%">
                  <input  type="text" name="prpLverifyLossExtOperatorName" class="readonly" readonly style="width:100%" value="<%=new UICodeAction().translateUserCode(verifyLossExt1.getOperatorCode(),true)%>">
                  <input  type="hidden" name="prpLverifyLossExtOperatorCode" class="readonly" readonly style="width:100%" value="<%=verifyLossExt1.getOperatorCode()%>">
                </td>
                <%}%>
                <%if(("0".equals(status)||"2".equals(status)||"3".equals(status)) && indexCertainLossExt == verifyLossExtList.size()-1){ %>
                <td class="input"  style="width:15%">
                  <input  type="text" name="prpLverifyLossExtTitle" class="readonly"  readonly style="width:100%" value="<%=verifyLossExt1.getTitle()%>">
                </td>
                <td class="input"  style="width:45%">
                  <input  type="text" name="prpLverifyLossExtContext" class="input"  style="width:100%" maxLength="125" onblur="checkLength1(this);" description="����" value="<%=verifyLossExt1.getContext()%>">
                </td>
                <%}else{%>
                <td class="input"  style="width:15%">
                  <input  type="text" name="prpLverifyLossExtTitle" class="readonly" readonly style="width:100%" value="<%=verifyLossExt1.getTitle()%>">
                </td>
                <td class="input"  style="width:45%">
                  <input  type="text" name="prpLverifyLossExtContext" class="readonly" readonly style="width:100%" maxLength="125" onblur="checkLength1(this);" description="����" value="<%=verifyLossExt1.getContext()%>">
                </td>
                <%}%>
                <td class="input" style='width:4%'  align="center">
                <!-- div>

                <input  type=button disabled name="buttonCertainLossExtDelete" class="smallbutton"   value="-" >

</div-->
                </td>
              </tr>
 <% }}%>
          </tbody>
        </table>
        </span>
      </td>
    </tr>
  </table>








