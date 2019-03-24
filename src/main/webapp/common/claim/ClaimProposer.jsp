<%--
****************************************************************************
* DESC       ：添加驾驶员信息页面
* AUTHOR     ：weishixin
* CREATEDATE ： 2004-03-03
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<script language='javascript'>
//modify by liuyanmei delete 20051107 start 

  function afterInsertProposer()
    {
        setPrpLdriverSerialNo();
       
        var count=getElementCount("proposerIdentifyNo");
        for(var i=0;i<count;i++)
        {             
            if(count!=1){
             fm.proposerIdentifyNo[i].maxLength=22;
            }
        }
       
        setButtonProposerInsertStatus();
    }


  /*
    删除本条Proposer之后的处理（可选方法）
  */

    function afterDeleteProposer(field)
    {
        setPrpLdriverSerialNo();
        setButtonProposerInsertStatus();
    }

    /**
     * 设置setPrpLdriverSerialNo
     */
  function setPrpLdriverSerialNo(){
        var count=getElementCount("prpLacciPersonSerialNo");
        for(var i=0;i<count;i++)
        {
            //alert("看看什么时候运行?count="+count+"  i="+i);
            if(count!=1){
            	fm.prpLacciPersonSerialNo[i].value=i;
            }
        }
    }

//modify by liuyanmei modify 20051119 reason:itest bug 976要求可以输入多条记录
    /**
     * 只允许有一个驾驶员
     */
   function setButtonProposerInsertStatus(){
	    var count=getElementCount("proposerName");
        if(count<=1){
           fm.buttonProposerInsert.disabled=false;
         }else{
            fm.buttonProposerInsert.disabled=true;
        }
    }  
  //modify by liuyanmei modify 20051107 end  
</script>


<!--建立显示的录入条，可以收缩显示的-->
    <table class="common" cellpadding="5" cellspacing="1">
   <!--表示显示多行的-->
      <tr>
        <td class="common" colspan="3" style="text-align:left;"><img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif" name="prpLacciPersonImg" onclick="showPage(this,spanClaimProposer)">
        索赔申请人信息<br>
<!--==========================================================-->
     <table cellpadding="5" cellspacing="1" class="common"  id="Proposer_Data" style="display:none">
       <tbody>
        <tr>
          <td style="width:5%" class=common>
             <div align="left">
               <input class="readonlyNo" readonly name="prpLacciPersonSerialNo" description="序号">
             </div>
          </td>
          <td  class=common colspan=5 style="width:91%">
            <table  cellpadding="2" cellspacing="1" class="common">
              <tr>
                 <!-----索赔人信息start----------------->
                 <td class="input" style='width:11%'>
                   <input name="proposerName" class="input" style="width:70%" maxlength=20 description="索赔申请人姓名"><img src="/claim/images/bgMarkMustInput.jpg">  
                 </td>
                 <td class="input" style='width:25%' align="center">
                   <input name="proposerIdentifyNumber" class="input" style="width:70%" maxlength=20 description="索赔申请人身份证号码"> <img src="/claim/images/bgMarkMustInput.jpg">
                 </td>
                 <td class="input" style="width:20%" align="center">
                   <select name="relationCode" >
                              <option value="1" >被保险人本人</option>
		                      <option value="2" >指定受益人</option>
		                      <option value="3" >被保险人之继承人</option>
		                      <option value="4" >被保险人之监护人</option>
		            </select> <img src="/claim/images/bgMarkMustInput.jpg">
		        </td>
                <td class="input" style='width:15%' align="center">
                  <input name="proposerPhone" class="common" style="width:95%" maxlength=20 description="联系电话">
                </td>
                <td class="input" style='width:20%' align="center">
                  <input name="proposerAddress" class="common" style="width:95%" maxlength=20 description="通信地址">
                  <input type=hidden name="personFamilyNo" value="<bean:write name='prpLclaimDto' property='familyNo' filter='true' />" class="input" />
                  <input type=hidden name="claimNo" value="<bean:write name='prpLclaimDto' property='claimNo' filter='true' />" class="input" />
                  <input type=hidden name="proposerPolicyNo" value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />" class="input" />
                  
                </td>
              </tr>
            </table>
          </td>
          <!-----索赔人信息end------------------->
          <td class="input" style='width:4%'>
          <div align="right">
            <input type=button name="buttonProposerDelete"  class=smallbutton onclick="deleteRow(this,'Proposer')" value="-" style="cursor: hand">
          </div>
          </td>
       </tr>
     </tbody>
  </table>
<!--======================================================================================-->
  <span  id="spanClaimProposer" style="display:none">
  <%-- 多行输入展现域 --%>
    <table class=common id="Proposer" cellpadding="5" cellspacing="1">
            <thead>
              <tr class=listtitle>
                <td  style="width:5%">序号</td>
                <td  style="width:10%">姓名</td>
                <td  style="width:25%">身份证号码</td>
                <td  style="width:20%">与事故者关系</td>
                <td  style="width:15%">联系电话</td>
                <td  style="width:21%">通信地址</td>
              </tr>
            </thead>
           <tfoot>
              <tr>
                <td colspan=6  align="center" class="title" >(按"+"号键增加单证信息，按"-"号键删除信息)</td>
                <td class="title"  colspan=1 align="right" >
                   <input type="button" value="+" class=smallbutton onclick="insertRow('Proposer')" name="buttonProposerInsert" style="cursor: hand">
                </td>
              </tr>
           </tfoot>
         <tbody>
      <% int  index=0;   %>
                                                    
<logic:notEmpty  name="prpLacciPersonDto"  property="prpLacciPersonList">
         <logic:iterate id="prpLacciPerson" name="prpLacciPersonDto" property="prpLacciPersonList">

<%
  System.out.println("======有值===");
   if(index %2== 0){
        out.print("<tr class=oddrow>");
    }
    else{
        out.print("<tr class=oddrow>");
    }
%>

              <td class="input" style="width:4%">
                <div align="center">
                  <input  name="prpLacciPersonSerialNo"  class="readonlyno" readonly="true" value="<bean:write name='prpLacciPerson' property='serialNo'/>">
                </div>
              </td>
              <td class="common"  colspan=5>
                <table  cellpadding="5" cellspacing="1" class="common">
                  <tr>
                     <td class="input" style='width:10%'>
                        <input name="proposerName"  class="input" style="width:70%" maxlength=20 value="<bean:write name='prpLacciPerson' property='acciName'/>" title="索赔人姓名"><img src="/claim/images/bgMarkMustInput.jpg">
                     </td>
                     <td class="input" style='width:25%'>
                        <input name="proposerIdentifyNumber"  class="input" style="width:70%" maxlength=20 value="<bean:write name='prpLacciPerson' property='identifyNumber'/>" title="身份证号码"><img src="/claim/images/bgMarkMustInput.jpg">
                     </td>
                     <td class="input" style="width:20%" >
                    
                     <!--select name="prpLacciPerson" property="relationName" -->
                      <html:select name="prpLacciPerson"  property='relationCode'>
                              <html:option value="1" >被保险人本人</html:option>
		                      <html:option value="2" >指定受益人</html:option>
		                      <html:option value="3" >被保险人之继承人</html:option>
		                      <html:option value="4" >被保险人之监护人</html:option>
                     </html:select>
                <!--  <input type=hidden name="proposerRelation" value="<bean:write name='prpLacciPerson' property='relationCode'/>" class="input" /> -->
                  <input type=hidden name="claimNo" value="<bean:write name='prpLacciPerson' property='certiNo'/>" class="input" />  
                    </td>
                    <td class="input" style='width:15%'>
                        <input name="proposerPhone"  class="input" style="width:95%" maxlength=20 value="<bean:write name='prpLacciPerson' property='phone'/>" title="索赔人电话">
                    </td>
                    <td class="input" style="width:20%">
                        <input name="proposerAddress" class="input"  style="width:80%" maxlength=10 value="<bean:write name='prpLacciPerson' property='address'/>" title="索赔人地址">
                    </td>
                  </tr>
                </table> 
              </td>
              <td class="title" style="width:4%">
                  <div align="center">
                    <input type=button name="buttonProposerDelete" class=smallbutton  onclick="deleteRow(this,'Proposer')" value="-" style="cursor: hand">
                  </div>
              </td>  
             </tr>   
<%    index++;%>
  </logic:iterate>
      </logic:notEmpty>
 
          </tbody>
        </table>
      </td>
    </tr>
  </table>
</span>
</table>

