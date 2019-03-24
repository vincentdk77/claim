<%--
****************************************************************************
* DESC       ：添加修理发票信息页面
* AUTHOR     ：dingmingliang
* CREATEDATE ： 2010-05-13
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               dingmingliang  20100513
****************************************************************************
--%>
   <!--建立显示的录入条，可以收缩显示的-->

    <%@page import="java.util.ArrayList"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLcomRepairBillDto"%>
<script language='javascript'>
      /*
        插入一条新的之后的处理（可选方法）
      */
      function afterInsertBill()
      {
        setPrpLbillSerialNo();
      }

      /*
        删除本条WarnRegion之后的处理（可选方法）
      */
      function afterDeleteBill(field)
      {
        setPrpLbillSerialNo();
      }

      /**
       * 设置setPrpLBillSerialNo
       */
      function setPrpLbillSerialNo(){
        var count=getElementCount("prpLbillSerialNo");
        for(var i=0;i<count;i++)
        {
          //alert("看看什么时候运行?count="+count+"  i="+i);
          if(count!=1){
              fm.prpLbillSerialNo[i].value=i;
          }
        }
      }
   </script>

   <table class="common" cellpadding="5" cellspacing="1">
    <!--表示显示多行的-->
    <tr>
      <td class="common" colspan="4" style="text-align:left">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="BillImg" onclick="showPage(this,spanBill);changeCompensateFlag('1');">修理发票信息(<font color='red'>请填写修理车辆发票信息</font> )<br>
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
                  <input name="billType" class="common" maxlength="22" onblur="checkLength1(this)" description="发票类型">
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
        <%-- 多行输入展现域 --%>
        <table class="common" cellpadding="5" cellspacing="1" id="Bill" >
          <thead>
            <tr>
                <td class="centertitle" style='width:20%'>车架号</td>
                <td class="centertitle" style='width:20%'>车牌号码</td>
                <td class="centertitle" style='width:10%'>车辆种类</td>
                <td class="centertitle" style='width:15%'>发票类型</td>
                <td class="centertitle" style='width:20%'>发票号码</td>
                <td class="centertitle" style='width:11%'>&nbsp;</td>
            </tr>
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan=5 >(按"+"号键增加修理发票信息，按"-"号键删除信息)</td>
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
                  <input name="billType" class="common"  value="<%=prpLcomRepairBillDto.getBillType() %>" maxlength="22" onblur="checkLength1(this)" description="发票类型">
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








