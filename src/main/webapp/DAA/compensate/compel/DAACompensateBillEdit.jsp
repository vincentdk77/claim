<%--
****************************************************************************
* DESC       ���������Ʊ��Ϣҳ��
* AUTHOR     ��dingmingliang
* CREATEDATE �� 2010-05-13
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               dingmingliang  20100513
****************************************************************************
--%>
   <!--������ʾ��¼����������������ʾ��-->

    <%@page import="java.util.ArrayList"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLcomRepairBillDto"%>
<script language='javascript'>
      /*
        ����һ���µ�֮��Ĵ�����ѡ������
      */
      function afterInsertBill()
      {
        setPrpLbillSerialNo();
      }

      /*
        ɾ������WarnRegion֮��Ĵ�����ѡ������
      */
      function afterDeleteBill(field)
      {
        setPrpLbillSerialNo();
      }

      /**
       * ����setPrpLBillSerialNo
       */
      function setPrpLbillSerialNo(){
        var count=getElementCount("prpLbillSerialNo");
        for(var i=0;i<count;i++)
        {
          //alert("����ʲôʱ������?count="+count+"  i="+i);
          if(count!=1){
              fm.prpLbillSerialNo[i].value=i;
          }
        }
      }
   </script>

   <table class="common" cellpadding="5" cellspacing="1">
    <!--��ʾ��ʾ���е�-->
    <tr>
      <td class="common" colspan="4" style="text-align:left">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="BillImg" onclick="showPage(this,spanBill);changeCompensateFlag('1');">����Ʊ��Ϣ(<font color='red'>����д��������Ʊ��Ϣ</font> )<br>
        <span style="display:none">
          <table class="common" style="display:none" id="Bill_Data" cellspacing="1" cellpadding="0">
            <tbody>
              <tr>
                  <input type="hidden" name="prpLbillSerialNo"  style="width:100" maxlength="3">
                <td class="input" style='width:20%'>
                  <input name="frameNo" class="codecode" codetype="frameType" 
                  ondblclick="code_CodeSelect(this, 'frameType','1,2','code','none','post');"
                  onkeyup="code_CodeChange(this, 'frameType','1,2','code','none','post');"
                  onkeyup="code_CodeSelect(this, 'frameType','1,2','code','none','post');">
                </td>
                <td class="input" style='width:20%'>
                  <input name="licenseNo" class="readonly" readonly>
                </td>
                <td class="input" style='width:10%'>
                  <input name="carKind" class="readonly" readonly>
                </td>
                <td class="input" style='width:15%'>
                  <input name="billType" class="common" maxlength="22" onblur="checkLength1(this)" description="��Ʊ����">
                </td>
                
                <td class="input" style='width:20%'>
                  <input name="billNo" class="common">
                </td>
                <td class="input" style='width:11%'  align="center">
                    <div>
                         <input type=button name="buttonBillDelete"  class="smallbutton" 
                                onclick="deleteRow(this,'Bill')" value="-" style="cursor: hand">
                    </div>
                </td>
              </tr>
            </tbody>
          </table>
        </span>


        <span  id="spanBill" style="display:" cellspacing="1" cellpadding="0">
        <%-- ��������չ���� --%>
        <table class="common" cellpadding="5" cellspacing="1" id="Bill" >
          <thead>
            <tr>
                <td class="centertitle" style='width:20%'>���ܺ�</td>
                <td class="centertitle" style='width:20%'>���ƺ���</td>
                <td class="centertitle" style='width:10%'>��������</td>
                <td class="centertitle" style='width:15%'>��Ʊ����</td>
                <td class="centertitle" style='width:20%'>��Ʊ����</td>
                <td class="centertitle" style='width:11%'>&nbsp;</td>
            </tr>
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan=5 >(��"+"�ż���������Ʊ��Ϣ����"-"�ż�ɾ����Ϣ)</td>
                 <td class="title" align="right" style="width:4%">
                     <div align="center">
                          <input type="button" value="+" class=smallbutton name="buttonDriverInsert" style="cursor: hand"
                                 onclick="insertRow('Bill')">
                     </div>
                 </td>
              </tr>
           </tfoot>
          </tfoot>
          <tbody>
<% 
if(request.getAttribute("prpLcomRepairBillList")!=null)
{
    ArrayList prpLcomRepairBillList = (ArrayList)request.getAttribute("prpLcomRepairBillList");
    PrpLcomRepairBillDto prpLcomRepairBillDto = null;
    String carKind  = "";
    for(int indexBill=0;indexBill<prpLcomRepairBillList.size(); indexBill++)
    {
	   prpLcomRepairBillDto = (PrpLcomRepairBillDto)prpLcomRepairBillList.get(indexBill);
	   carKind = prpLcomRepairBillDto.getCarkind();
%>
              <tr>
                  <input type="hidden" name="prpLbillSerialNo"  style="width:100" maxlength="3" 
                  value="<%=prpLcomRepairBillDto.getItemno() %>" >
                <td class="input" style="width:20%">
                  <input name="frameNo" class="codecode"  value="<%=prpLcomRepairBillDto.getFrameno() %>"
                  ondblclick="code_CodeSelect(this, 'frameType','1,2','code','none','post');"
                  onkeyup="code_CodeChange(this, 'frameType','1,2','code','none','post');"
                  onkeyup="code_CodeSelect(this, 'frameType','1,2','code','none','post');">
                </td>
                <td class="input" style="width:20%">
                  <input name="licenseNo" class="readonly" readonly  value="<%=prpLcomRepairBillDto.getLicenseno() %>">
                </td>
                <td class="input" style="width:10%">
                  <input name="carKind" class="readonly" readonly  value="<%=prpLcomRepairBillDto.getCarkind() %>">
                </td>
                <td class="input" style="width:10%">
                  <input name="billType" class="common"  value="<%=prpLcomRepairBillDto.getBillType() %>" maxlength="22" onblur="checkLength1(this)" description="��Ʊ����">
                </td>
                
                <td class="input" style="width:20%">
                  <input name="billNo" class="common"   value="<%=prpLcomRepairBillDto.getBillNo() %>">
                </td>
                <td class="input" style='width:10%'  align="center">
                    <div>
                         <input type=button name="buttonBillDelete"  class="smallbutton" 
                                onclick="deleteRow(this,'Bill')" value="-" style="cursor: hand">
                    </div>
                </td>
              </tr>
<%   }
}%>
          </tbody>
        </table>
        </span>
      </td>
    </tr>
  </table>








