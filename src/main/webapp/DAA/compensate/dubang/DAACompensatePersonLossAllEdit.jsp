<%--
****************************************************************************
* DESC       ：添加人员赔款费用信息页面
* AUTHOR     ：lixiang
* CREATEDATE ： 2004-06-01
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
****************************************************************************
--%>
<%@page import="java.util.*"%>
<script language='javascript'>
    /*
      删除本条Person之后的处理（可选方法）
    */
    function afterDeletePerson(field)
    {
      if(getElementCount("calRealpay1ForDuBang")>1){
        calRealpay1ForDuBang(fm.prpLpersonMedicalSumLoss[0]);
        calRealpay1ForDuBang(fm.prpLpersonMedicalSumLoss);
      }
      calFund();
      calLoss();
    }
    
</script>
   <!--建立显示的录入条，可以收缩显示的-->


      <span style="display:none">
        <table class="common" style="display:none" id="PersonFeeMedical_Data" cellspacing="1" cellpadding="0">
          <tbody>
            <tr>
              <td class="inputsubsub">
                <input type="hidden" name="personMedicalSerialNo" style="width:20px">
                <input name="prpLpersonMedicalDetailCode" class="codecode" style="width:30px" title="费用代码"
                   ondblclick= " code_CodeSelect(this,'PersonFeeType');"
                   onchange="code_CodeChange(this, 'PersonFeeType');"
                   onkeyup= " code_CodeSelect(this,'PersonFeeType');"
                   onblur="calculateFee(this);">
                <input name="prpLpersonMedicalDetailName" class="codename" style="width:100px" title="费用名称"
                  ondblclick= "code_CodeSelect(this, 'PersonFeeType','-1','name','none','post');"
                  onchange="code_CodeChange(this, 'PersonFeeType','-1','name','none','post');"
                  onkeyup= " code_CodeSelect(this, 'PersonFeeType','-1','name','none','post');"
                   onblur="calculateFee(this);">
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonMedicalSumLoss" class="common" style="width:100px" onblur="calSumPropAndPerson();">
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonMedicalRejectSum" class="common" style="width:100px" onblur="calSumPropAndPerson();">
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonMedicalSumDefPay" class="common" style="width:100px" onblur="calSumPropAndPerson();">
              </td>
              <td class="inputsubsub">
                <div align="center">
                  <input type=button name="buttonPersonFeeMedicalDelete"  class="smallbutton" onclick="deleteRowMDTable(this,'PersonFeeMedical',1,1);calFundCommerce();" value="-" readonly style="cursor: hand">
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </span>

      <span style="display:none">
        <table class="common" style="display:none" id="PersonFeeDeformity_Data" cellspacing="1" cellpadding="0">
          <tbody>
            <tr>
              <td class="inputsubsub">
                <input type="hidden" name="personDeformitySerialNo" style="width:20px">
                <input name="prpLpersonDeformityDetailCode" class="codecode" style="width:30px" title="费用代码"
                   ondblclick= " code_CodeSelect(this,'PersonFeeType');"
                   onchange="code_CodeChange(this, 'PersonFeeType');"
                   onkeyup= " code_CodeSelect(this,'PersonFeeType');"
                   onblur="calculateFee(this);">
                <input name="prpLpersonDeformityDetailName" class="codename" style="width:100px" title="费用名称"
                  ondblclick= "code_CodeSelect(this, 'PersonFeeType','-1','name','none','post');"
                  onchange="code_CodeChange(this, 'PersonFeeType','-1','name','none','post');"
                  onkeyup= " code_CodeSelect(this, 'PersonFeeType','-1','name','none','post');"
                   onblur="calculateFee(this);">
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonDeformitySumLoss" class="common" style="width:100px" onblur="calSumPropAndPerson();">
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonDeformityRejectSum" class="common" style="width:100px" onblur="calSumPropAndPerson();">
              </td>
                <td class="inputsubsub">
                <input name="prpLpersonDeformitySumDefPay" class="common" style="width:100px" onblur="calSumPropAndPerson();">
              </td>
              <td class="inputsubsub">
                <div align="center">
                  <input type=button name="buttonPersonFeeDeformityDelete"  class="smallbutton" onclick="deleteRowMDTable(this,'PersonFeeDeformity',1,1);calFundCommerce();" value="-" readonly style="cursor: hand">
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </span>


      <table class="common" align="center">
      <!--表示显示多行的-->
        <tr >
          <td class="common" colspan="4">
            <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
                 name="PersonImg" onclick="showPage(this,spanPersonCommerce);changeCompensateFlag('1');">商业三者赔付人员信息<br>
            <span style="display:none">
              <table class="common" style="display:none" id="PersonCommerce_Data" cellspacing="1" cellpadding="0">
                <tbody>
                  <tr>
                    <td class="input" style="width:8%">
                       <div align="center">人伤损失
                    <input type="hidden" name="prpLpersonLossItemKindNo">
                        <input type="hidden" name="prpLpersonCommerceSerialNo">
                       </div>
                   </td>
                   <td class="subformtitle" style="width:88%">
                   <table  cellpadding="0" cellspacing="1" class="common" style="width:100%">
                      <tbody>
                          <tr>
                            <input type="hidden" name="prpLpersonCommercePersonNo">
                            <td class="title"  style="width:15%">人员姓名：</td>
                            <td class="input" style="width:35%">
                              <input class='common' style="width:110" name="prpLpersonCommercePersonName"
                              maxlength=20 description="人员姓名">
                            </td>
                            <td class="title" style="width:15%">性别：</td>
                            <td class="input" style="width:35%">
                              <select name="prpLpersonCommerceSex" class='common' style="width:110">
                                 <option value="1">男</option>
                                 <option value="2">女</option>
                              </select>
                            </td>

                          </tr>
                          <tr>
                            <td class="title">年龄：</td>
                            <td class="input">
                              <input class='common' name="prpLpersonCommerceAge"  style="width:110"
                                maxlength="3" description="年龄" onchange="checkInteger(this,1,120)">
                            </td>
                            <td class="title">币别：</td>
                            <td class="input">
                              <input type="hidden" name="prpLpersonCommerceCurrency3"  value="CNY">
                              <input class='readonly' readonly name="prpLpersonCommerceCurrencyName3" value="人民币">
                            </td>
                          </tr>

                          <tr>
                            <td colspan="4">
                              <span  id="spanPersonFeeMedical" >
                              <%-- 多行输入展现域 --%>
                              <table id="PersonFeeMedical" name="PersonFeeMedical" class="common" align="center" cellspacing="1" cellpadding="0">
                                <thead>
                                  <tr>
                                    <td class="subformtitle" colspan="9">
                                      医疗费用信息 
                                    </td>
                                  </tr>
                                  <tr>
                          	  		  <td class="centertitle" style="width:37%">费用</td>
                          	  		  <td class="centertitle" style="width:20%">核定损失</td>
                          	  		  <td class="centertitle" style="width:20%">残值</td>
                          	  		   <td class="centertitle" style="width:20%">核定赔偿</td>
                          	  		  <td class="centertitle" style="width:3%">操作</td>
                                <td class="centertitle" style="width:3%">  </td>                          	  		  
                                  </tr>
                                </thead>
                                <tfoot>
                                  <tr>
                                    <td class="titlesubsub" colspan="6" style="width:97%"></td>
                                    <td class="title" align="right" style="width:4%">
                                      <div align="center">
                                        <input type="button" value="+"	 class="smallbutton"   onclick="insertRowMDTable('PersonFeeMedical','PersonFeeMedical_Data',this);" name="buttonPersonFeeMedicalInsert" readonly style="cursor: hand">
                                      </div>
                                    </td>
                                  </tr>
                                </tfoot>

                                <tbody>

                                </tbody>
                              </table>
                            </span>
                          </td>
                        </tr>
<%
//=====================插入点==============
%>
                          <tr>
                            <td colspan="4">
                              <span  id="spanPersonFeeDeformity" >
                              <%-- 多行输入展现域 --%>
                              <table id="PersonFeeDeformity" name="PersonFeeDeformity" class="common" align="center" cellspacing="1" cellpadding="0">
                                <thead>
                                  <tr>
                                    <td class="subformtitle" colspan="9">
                                      死亡残疾费用信息
                                    </td>
                                  </tr>
                                  <tr>
                          	  		  <td class="centertitle" style="width:37%">费用</td>
                          	  		  <td class="centertitle" style="width:20%">核定损失</td>
                          	  		  <td class="centertitle" style="width:20%">残值</td>
                          	  		   <td class="centertitle" style="width:20%">核定赔偿</td>
                          	  		  <td class="centertitle" style="width:3%">操作</td>
                                <td class="centertitle" style="width:3%">  </td>                          	  		  
                                  </tr>
                                </thead>
                                <tfoot>
                                  <tr>
                                    <td class="titlesubsub" colspan="6" style="width:97%"></td>
                                    <td class="title" align="right" style="width:4%">
                                      <div align="center">
                                        <input type="button" value="+"	 class="smallbutton"   onclick="insertRowDTable('PersonFeeDeformity','PersonFeeDeformity_Data',this);" name="buttonPersonFeeDeformityInsert" readonly style="cursor: hand">
                                      </div>
                                    </td>
                                  </tr>
                                </tfoot>

                                <tbody>

                                </tbody>
                              </table>
                            </span>
                          </td>
                        </tr>

<%
//=====================插入点==============
%>


                      </tbody>
                    </table>

                 </td>
              <td class="input" style="width:4%">
                <div align="center">
                  <input type=button name="buttonPersonCommerceDelete"  class="smallbutton" onclick="deleteRow(this,'PersonCommerce');testljy();" value="-" style="cursor: hand">
                </div>
              </td>
           </tr>
         </tbody>
       </table>
     </span>

     <span  id="spanPersonCommerce" style="display:none">
       <%-- 多行输入展现域 --%>
       <table id="PersonCommerce" class="common" align="center" cellspacing="1" cellpadding="0">
         <thead>
           <tr>
             <td class="centertitle" style="width:4%">名称</td>
             <td class="centertitle" style="width:96%" colspan=2 >内容</td>
           </tr>
         </thead>
         <tfoot>
           <tr>
             <td class="title" colspan=2 style="width:96%">(按"+"号键增加赔付人员信息，按"-"号键删除赔付人员信息)</td>
             <td class="title" align="right" style="width:4%">
               <div align="center">
                 <input type="button" value="+" class="smallbutton" onclick="insertRow('PersonCommerce');" name="buttonPersonInsert" style="cursor: hand">
               </div>
             </td>
           </tr>
         </tfoot>
         <tbody>

<script language="javascript">    
var damageKind = new Array();
<%
    damagekindCode = "";
   damageKindList = (ArrayList)request.getAttribute("damageKindList");  
   for(int m=0;m<damageKindList.size();m++)
   {
       prpCitemKindDto = (PrpCitemKindDto)damageKindList.get(m);
       damagekindCode = prpCitemKindDto.getKindCode();
%>  
       damageKind[<%=m%>]   ='<%=damagekindCode%>';
<%
   }
%>       

</script>      




<%

    int personMedicalDeformityNo = 0;
    int personMedicalDeformitySerialNo = 1;

    int personDeformityNo = 0;
    int personDeformitySerialNo = 1;


    kindCode = "";

	
    prpLpersonLossDto = (PrpLpersonLossDto)request.getAttribute("prpLpersonLossDto");
    if(prpLpersonLossDto.getPrpLpersonLossList()!=null){
      Iterator iterator = prpLpersonLossDto.getPrpLpersonLossList().iterator();
      while(iterator.hasNext()){
        PrpLpersonLossDto prpLpersonLossDto1 =  (PrpLpersonLossDto)iterator.next();
          if(!(prpLpersonLossDto1.getPersonNo() == personMedicalDeformityNo)
		  	||!prpLpersonLossDto1.getKindCode().equals(kindCode)){
          		if(!prpLpersonLossDto1.getKindCode().equals("B")) continue;
//end no time				
%>

           <tr>
          <td class="input" style="width:8%">
             <div align="center">人伤损失
               <input type="hidden" name="prpLpersonCommerceSerialNo" value="<%= personMedicalDeformitySerialNo %>">
             </div>
         </td>
         <td class="subformtitle" style="width:88%">
         <table  cellpadding="0" cellspacing="1" class="common" style="width:100%">
            <tbody>
                <tr>
                  <input type="hidden" name="prpLpersonCommercePersonNo" value="<%= prpLpersonLossDto1.getPersonNo() %>">
                  <td class="title"  style="width:15%">人员姓名：</td>
                  <td class="input" style="width:35%">
                    <input class='common' style="width:110" name="prpLpersonCommercePersonName" value="<%= prpLpersonLossDto1.getPersonName() %>">
                  </td>
                  <td class="title" style="width:15%">性别：</td>
                  <td class="input" style="width:35%">
                    <select name="prpLpersonCommerceSex" class='common' style="width:110">
                       <option value="1" <%= prpLpersonLossDto1.getSex().trim().equals("1") ? "selected":"" %>>男</option>
                       <option value="2" <%= prpLpersonLossDto1.getSex().trim().equals("2") ? "selected":"" %>>女</option>
                    </select>
                  </td>
                </tr>
                <tr>
                  <td class="title">年龄：</td>
                  <td class="input">
                    <input class='common' name="prpLpersonCommerceAge"  style="width:110"  value="<%= prpLpersonLossDto1.getAge() %>"
                      maxlength="3" description="年龄" onchange="checkInteger(this,1,120)">
                  </td>
                  <td class="title">币别：</td>
                  <td class="input">
                    <input type="hidden" name="prpLpersonCommerceCurrency3"  value="CNY">
                    <input class='readonly' readonly name="prpLpersonCommerceCurrencyName3" value="人民币">
                  </td>
                </tr>

                <tr>
                        <td colspan="4">
                          <span  id="spanPersonFeeMedical" >
                          <%-- 多行输入展现域 --%>
                          <table id="PersonFeeMedical" name="PersonFeeMedical" class="common" align="center" cellspacing="1" cellpadding="0">
                            <thead>
                              <tr>
                                <td class="subformtitle" colspan="9">
                                      医疗费用信息 
                                </td>
                              </tr>
                              <tr>
                          	  		  <td class="centertitle" style="width:37%">费用</td>
                          	  		  <td class="centertitle" style="width:20%">核定损失</td>
                          	  		  <td class="centertitle" style="width:20%">残值</td>
                          	  		   <td class="centertitle" style="width:20%">核定赔偿</td>
                          	  		  <td class="centertitle" style="width:3%">操作</td>
                                <td class="centertitle" style="width:3%">  </td>
                              </tr>
                            </thead>
                            <tfoot>
                              <tr>
                                <td class="titlesubsub" colspan="6" style="width:97%"></td>
                                <td class="title" align="right" style="width:4%">
                                  <div align="center">
                                    <input type="button" value="+" class="smallbutton" onclick="insertRowMDTable('PersonFeeMedical','PersonFeeMedical_Data',this);" name="buttonPersonFeeMedicalInsert" readonly style="cursor: hand">
                                  </div>
                                </td>
                              </tr>
                            </tfoot>

                            <tbody>
 <%
System.out.println("------personMedicalDeformityNo-----"+personMedicalDeformityNo+"|"+kindCode);
System.out.println("------prpLpersonLossDto1.getPersonNo()-----"+prpLpersonLossDto1.getPersonNo()+"|"+prpLpersonLossDto1.getKindCode());
   Iterator iterator1 = prpLpersonLossDto.getPrpLpersonLossList().iterator();
      while(iterator1.hasNext()){
        PrpLpersonLossDto PrpLpersonLossDto2 =  (PrpLpersonLossDto)iterator1.next();
        if(PrpLpersonLossDto2.getPersonNo() == prpLpersonLossDto1.getPersonNo()
			&&PrpLpersonLossDto2.getKindCode().equals(prpLpersonLossDto1.getKindCode())
			&&PrpLpersonLossDto2.getRemark().equals("M")
		){

%>
                              <tr>
                                  <td class="inputsubsub">
                                    <input type="hidden" name="personMedicalSerialNo" style="width:20px" value="<%= personMedicalDeformitySerialNo %>">
                                    <input name="prpLpersonMedicalDetailCode" class="codecode" style="width:30px" title="费用代码"  value="<%= PrpLpersonLossDto2.getLiabDetailCode() %>"
                                       ondblclick= " code_CodeSelect(this,'PersonFeeType');"
                                       onchange="code_CodeChange(this,'PersonFeeType');"
                                       onkeyup= " code_CodeSelect(this,'PersonFeeType');"
                                       onblur="calculateFee(this);">
                                    <input name="prpLpersonMedicalDetailName" class="codename" style="width:100px" title="费用名称"  value="<%= PrpLpersonLossDto2.getLiabDetailName() %>"
                                      ondblclick= "code_CodeSelect(this, 'PersonFeeType','-1','name','none','post');"
                                      onchange="code_CodeChange(this, 'PersonFeeType','-1','name','none','post');"
                                      onkeyup= " code_CodeSelect(this, 'PersonFeeType','-1','name','none','post');"
                                      onblur="calculateFee(this);">
                                  </td>


                                  <td class="inputsubsub">
                                    <input name="prpLpersonMedicalSumLoss" class="common" style="width:100px" value="<%= PrpLpersonLossDto2.getSumLoss() %>"  onblur="calSumPropAndPerson();">
                                  </td>
                                  <td class="inputsubsub">
                                    <input name="prpLpersonMedicalRejectSum" class="common" style="width:100px" value="<%= PrpLpersonLossDto2.getSumRest() %>" onblur="calSumPropAndPerson();">
                                  </td>
                                    <td class="inputsubsub">
                                    <input name="prpLpersonMedicalSumDefPay" class="common" style="width:100px" value="<%= PrpLpersonLossDto2.getSumRest() %>" onblur="calSumPropAndPerson();">
                                  </td>
                                  <td class="inputsubsub">
                                    <div align="center">
                                      <input type=button name="buttonPersonFeeMedicalDelete" 	 class="smallbutton" onclick="deleteRowMDTable(this,'PersonFeeMedical',1,1);calFundCommerce();" value="-" readonly style="cursor: hand">
                                    </div>
                                  </td>
                                </tr>
<%
    }
  }
%>
                              </tbody>
                            </table>
                          </span>
                        </td>
                      </tr>
<%
//=====================插入点==============
%>
                <tr>
                        <td colspan="4">
                          <span  id="spanPersonFeeDeformity" >
                          <%-- 多行输入展现域 --%>
                          <table id="PersonFeeDeformity" name="PersonFeeDeformity" class="common" align="center" cellspacing="1" cellpadding="0">
                            <thead>
                              <tr>
                                <td class="subformtitle" colspan="9">
                                      死亡残疾费用信息
                                </td>
                              </tr>
                              <tr>
                          	  		  <td class="centertitle" style="width:37%">费用</td>
                          	  		  <td class="centertitle" style="width:20%">核定损失</td>
                          	  		  <td class="centertitle" style="width:20%">残值</td>
                          	  		    <td class="centertitle" style="width:20%">核定赔偿</td>
                          	  		  <td class="centertitle" style="width:3%">操作</td>
                                <td class="centertitle" style="width:3%">  </td>
                              </tr>
                            </thead>
                            <tfoot>
                              <tr>
                                <td class="titlesubsub" colspan="6" style="width:97%"></td>
                                <td class="title" align="right" style="width:4%">
                                  <div align="center">
                                    <input type="button" value="+" class="smallbutton" onclick="insertRowDTable('PersonFeeDeformity','PersonFeeDeformity_Data',this);" name="buttonPersonFeeDeformityInsert" readonly style="cursor: hand">
                                  </div>
                                </td>
                              </tr>
                            </tfoot>

                            <tbody>
 <%
System.out.println("------personDeformityDeformityNo-----"+personDeformityNo+"|"+kindCode);
System.out.println("------prpLpersonLossDto1.getPersonNo()-----"+prpLpersonLossDto1.getPersonNo()+"|"+prpLpersonLossDto1.getKindCode());
   Iterator iterator2 = prpLpersonLossDto.getPrpLpersonLossList().iterator();
      while(iterator2.hasNext()){
        PrpLpersonLossDto PrpLpersonLossDto2 =  (PrpLpersonLossDto)iterator2.next();
        if(PrpLpersonLossDto2.getPersonNo() == prpLpersonLossDto1.getPersonNo()
			&&PrpLpersonLossDto2.getKindCode().equals(prpLpersonLossDto1.getKindCode())
			&&PrpLpersonLossDto2.getRemark().equals("D")
		){

%>
                              <tr>
                                  <td class="inputsubsub">
                                    <input type="hidden" name="personDeformitySerialNo" style="width:20px" value="<%= personDeformitySerialNo %>">
                                    <input name="prpLpersonDeformityDetailCode" class="codecode" style="width:30px" title="费用代码"  value="<%= PrpLpersonLossDto2.getLiabDetailCode() %>"
                                       ondblclick= " code_CodeSelect(this,'PersonFeeType');"
                                       onchange="code_CodeChange(this,'PersonFeeType');"
                                       onkeyup= " code_CodeSelect(this,'PersonFeeType');"
                                       onblur="calculateFee(this);">
                                    <input name="prpLpersonDeformityDetailName" class="codename" style="width:100px" title="费用名称"  value="<%= PrpLpersonLossDto2.getLiabDetailName() %>"
                                      ondblclick= "code_CodeSelect(this, 'PersonFeeType','-1','name','none','post');"
                                      onchange="code_CodeChange(this, 'PersonFeeType','-1','name','none','post');"
                                      onkeyup= " code_CodeSelect(this, 'PersonFeeType','-1','name','none','post');"
                                      onblur="calculateFee(this);">
                                  </td>


                                  <td class="inputsubsub">
                                    <input name="prpLpersonDeformitySumLoss" class="common" style="width:100px" value="<%= PrpLpersonLossDto2.getSumLoss() %>"  onblur="calSumPropAndPerson();">
                                  </td>
                                  <td class="inputsubsub">
                                    <input name="prpLpersonDeformityRejectSum" class="common" style="width:100px" value="<%= PrpLpersonLossDto2.getSumRest() %>" onblur="calSumPropAndPerson();">
                                  </td>
                                    <td class="inputsubsub">
                                    <input name="prpLpersonDeformitySumDefPay" class="common" style="width:100px" value="<%= PrpLpersonLossDto2.getSumRest() %>" onblur="calSumPropAndPerson();">
                                  </td>
                                  <td class="inputsubsub">
                                    <div align="center">
                                      <input type=button name="buttonPersonFeeDeformityDelete" 	 class="smallbutton" onclick="deleteRowDTable(this,'PersonFeeDeformity',1,1);calFundCommerce();" value="-" readonly style="cursor: hand">
                                    </div>
                                  </td>
                                </tr>
<%
    }
  }
%>
                              </tbody>
                            </table>
                          </span>
                        </td>
                      </tr>

<%
//=====================插入点==============
%>

                    </tbody>
                  </table>
                </td>
                <td class="title" style="width:4%">
                  <div align="center">
                    <input type=button name="buttonPersonCommerceDelete"  class="smallbutton" onclick="deleteRow(this,'PersonCommerce')" value="-" style="cursor: hand">
                  </div>
                </td>
             </tr>
<%
        kindCode = prpLpersonLossDto1.getKindCode();
        personMedicalDeformityNo =   prpLpersonLossDto1.getPersonNo();
        personMedicalDeformitySerialNo++;
        personDeformityNo =   prpLpersonLossDto1.getPersonNo();
        personDeformitySerialNo++;
		
        }
      }//while has next
    }
%>









           </tbody>
         </table>
       </span>
     </td>
   </tr>
  </table>



 
