<%@page import="java.util.*"%>

<%--
****************************************************************************
* DESC       ：添加第三者车辆信息页面
* AUTHOR     ：weishixin
* CREATEDATE ： 2004-03-02
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
************************ ****************************************************
--%>
    <%-- 多行输入展现域的模板 --%>
    <%--多行输入自定义JavaScript方法域--%>

    <script language='javascript'>
      //在下面加入本页自定义的JavaScript方法

        /*
        插入一条新的ThirdParty之后的处理（可选方法）
      */
      function afterInsertThirdParty()
      {
        setPrpLthirdPartySerialNo();
      }

      /* 
        删除本条WarnRegion之后的处理（可选方法）
      */
      function afterDeleteThirdParty(field)
      {

        setPrpLthirdPartySerialNo();
      }

        /**
         * 设置setPrpLthirdPartySerialNo
         */
        function setPrpLthirdPartySerialNo(){
            var count=getElementCount("prpLthirdPartySerialNo");
            for(var i=0;i<count;i++)
            {
               // alert("看看什么时候运行?count="+count+"  i="+i);
                if(count!=1){
                    fm.prpLthirdPartySerialNo[i].value=i;
                    fm.prpLthirdPartyNewAddFlag[i].value="new" ; //add by liyanjie 2005-12-17
                    //是否新增的车辆标志=new,因为已经控制了不能删除原来的.
                }
            }
        }

        /**
         * 判断对本涉案车责任比例不能是大于100，小于0的数
         */
      function isRightDutyPercent(){
        var lPercent=0;
        var strmsg="";
        var i=0;
        if(isNaN(fm.prpLthirdPartySerialNo.length))
        {
           return true;
        }
        //只有一条不校验

        //alert(fm.prpLthirdPartySerialNo.length)
        for (i=1;i<fm.prpLthirdPartySerialNo.length;i++)
        {
         lPercent=parseInt(fm.prpLthirdPartyDutyPercent[i].value);
         if ((lPercent>100)||(lPercent<0))
         {
            strmsg="序号为"+fm.prpLthirdPartySerialNo[i].value+"的涉案车辆的责任比例不能是大于100或者小于0!";
            alert(strmsg);
            //fm.prpLthirdPartySerialNo[i].onfocus();
            return false;
         }

        }

        return true;
      }
      /**
      * 并且只应该/必须有一辆为保单车辆
      */
      function checkInsureCarFlag(){
        var insureCarFlag=""; //是否本保单车辆
        var i=0;              //计数
        var flagCount =0;     //
        var strmsg="";        //提示消息

        for (i=1;i<fm.prpLthirdPartySerialNo.length;i++)
        {
           insureCarFlag=fm.insureCarFlag[i].value;
           if (insureCarFlag="1")
           {
            flagCount++;
           }
        }
        if ( flagCount<1)
        {
            strmsg="涉案车辆中，必须有1辆车辆为本保单车辆！";
            alert(strmsg);
            return false;
        }

         if ( flagCount>1)
        {
            strmsg="涉案车辆中，只能有1辆车辆为本保单车辆！";
            alert(strmsg);
            return false;
        }

        return true;
      }

 
    </script>
        
      <span style="display:none"> 
        <table class="common" style="display:none" id="ThirdCarLoss_Data" cellspacing="1" cellpadding="0">
          <tbody>   
            <tr>
                  <td class="input" style="width:10%"> 
                  <input type="hidden"  name="prpLthirdCarLossFlag">
                  <input type="hidden"  name="prpLthirdCarLossSerialNo" description="序号">
                  <input type="hidden"  name="RelateSerialNo" description="序号">
                  <input type="hidden"  name="prpLthirdCarLossLossGrade" description="损失程度级别">
                  <input name="prpLthirdCarLossItemNo" class="readonly" readonly style="width:75%" maxlength=3 value="1">
                  
                </td>
                <td class="input" style="width:15%">
                  <input name="prpLthirdCarLossLicenseNo" class="common"  style="width:90%" >
                </td>
                <!--Modify by chenrenda update begin 20050406-->
                <td class="input" style="width:15%">
                  <html:select name="prpLthirdCarLossDto" property="partCode" styleClass="three" style="width:120px" onchange="getPartName(this);">
                    <html:options  collection="partCodeList" property="value" labelProperty="label"/>
                  </html:select>
                  <input type="hidden" name="partName" value="<bean:write name='prpLthirdCarLossDto' property='partName'/>">
                </td>    
                <td class="input" style="width:15%">
                  <input name="compName" class="codename" style="width:90%"  			             
                     ondblclick="return openCompCodeWin(ThirdCarLoss_Data,this);">  
                     <input type="hidden" name="compCode">
                </td>
                <!--Modify by chenrenda update end 20050406-->
              
                <td class="input" style="width:26%">
                  <input name="prpLthirdCarLossLossDesc" class="input" style="width:90%">
                </td> 
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type=button name="buttonThirdCarLossDelete"  onclick="deleteRowTable(this,'ThirdCarLoss',1,1)" value="-" style="cursor: hand">
                </div>
                </td>
              </tr>
          </tbody>
        </table>
      </span>
      
      
    
   <!--建立显示的录入条，可以收缩显示的-->
    <table class="common" align="center">
   <!--表示显示多行的-->    
      <tr class="mline">
        <td class="subformtitle" colspan="4" style="text-align:left"><img style="cursor:hand;" src="/claim/images/butExpandBlue.gif" name="ThirdPartyImg" onclick="showPage(this,spanThirdPartyAll)">
        涉案车辆<br>
          <span  style="display:none">
             <!--点击后显示内容-->
             <table class="common" style="display:none" id="ThirdParty_Data" cellspacing="1" cellpadding="0" >
               <tbody>
                 <tr>
                    <td class="title" style="width:4%">
                      <div align="center">
                          <input class="readonlyno" readonly name="prpLthirdPartySerialNo" >
                          <input type="hidden" class="readonlyno"  name="prpLthirdPartyNewAddFlag" > <!--add by liyanjie 2005-12-17是否是新增的车辆标志 -->
                      </div>
                    </td>
                    <td class="subformtitle" style="width:92%" >
                        <table class="common" cellspacing="1" cellpadding="0">
                           <tr>
                    <td class="common" style="TEXT-ALIGN: center" colspan=2 style="width:30%">
											<font color=red>三者车</font>
										</td>
                   <td class="title" style="width:10%">号牌号码</td>
                   <td class="input" style="width:20%" style="valign:bottom" >
                     <input name="prpLthirdPartyLicenseNo" class="input" style="width:75%" maxlength=30 onblur="checkLength1(this)" description="号牌号码" >
                     <img src="/claim/images/bgMarkMustInput.jpg"> 
                   </td>

                   <td class="title" style="width:10%;valign:bottom" >车架号</td>
                   <td class="input" style="width:20%;valign:bottom" >
                    <input type="text" name="prpLthirdPartyFrameNo" class="input" maxlength=20 description="车架号" >

                   </td>

                   
                    <input type="hidden" name="prpLthirdPartySelectSend" value="0">          
                    <input type="hidden" name="insuredFlag" value="1">
                </tr>
                <tr>
                  <td class="title" style="width:10%">车辆种类</td>
                  <td class="input" style="width:20%">
                       <html:select name="prpLthirdPartyDto" property="carKindCode" >
                          <html:options collection="carKindCodes" property="codeCode" labelProperty="codeCName" />
                       </html:select>
                  </td>
                  <td class="title" style="width:10%">发动机号</td>
                  <td class="input" style="width:20%">
                  <input type="text" name="prpLthirdPartyEngineNo" class="input" maxlength=20 description="发动机号">
                  </td>
                  <td class="title"  style="width:10%">号牌底色</td>
                  <td class="input" style="width:20%">
                   <html:select name="prpLthirdPartyDto" property="licenseColorCode" >
                     <html:options collection="licenseColorCodes" property="codeCode" labelProperty="codeCName" />
                   </html:select>
                  </td>

                </tr>
                <tr>
                  <td class="title" style="width:10%">厂牌型号</td>
                  <td class="input" style="width:20%">
                   <input type="text" name="prpLthirdPartyBrandName" class="input"  maxlength=30 description="厂牌型号" >
                  </td>
                  <td class="title" style="width:10%">承保公司</td>
                  <td id="ThirdPartyInsureComCodeInput" class="input"  style="width:20%">
                       <input name="prpLthirdPartyInsureComCode" class="codecode" description="承保公司代码" style="width:30%"
                          ondblclick="code_CodeSelect(this, 'InsureComCode');"
                          onkeyup= "code_CodeSelect(this, 'InsureComCode');">

                       <input type="text" name="prpLthirdPartyInsureComName" class="codename" maxlength=50 description="承保公司名称" style="width:60%"
                          ondblclick="code_CodeSelect(this, 'InsureComCode','-1','always','none','post');"
                          onkeyup= "code_CodeSelect(this, 'InsureComCode','-1','always','none','post');">
                  </td>
                  <td class="title" style="width:10%">车辆使用年限</td>
                  <td class="input" style="width:20%">
                   <input type="input" name="prpLthirdPartyUseYears" class="input" maxlength=5 description="车辆使用年限">
                  </td>
                </tr>

               <tr>
               <td class="title" style="width:10%">VIN</td>
                  <td class="input" style="width:20%">
                    <input type="text" name="prpLthirdPartyVINNo" class="common" style="width:90%">
                  </td>
                   <td class="title"  style="width:10%">行驶公里数</td>
                   <td class="input" style="width:20%">
                    <input type="text" name="prpLthirdPartyRunDistance" class="input"  description="车辆已行驶公里数" maxlength=15 >
                   </td>
                  <td class="title" style="width:16%;display:none" >是否为本保单车辆</td>
                  <td class="input"  style="width:6%;TEXT-ALIGN: center;display:none">
                    <input type="hidden" name="insureCarFlag" value="0">三者车
                  </td>
                  <%--modify by wangli update start 20050407--%>
                   <!--Modify by chenrenda update begin 20050405 在报案时不显示责任比例-->
                  <td class="title"  id="tdDutyPercentTitle" style="width:10%;">对本涉案车责任比例</td>
                  <td class="input" id="tdDutyPercentInput" style="width:20%;">
                  <input type="text" name="prpLthirdPartyDutyPercent" class="input" maxlength=6 description="保险车辆对本车责任" style="width:90%"">%
                   <img src="/claim/images/bgMarkMustInput.jpg"> 

                  </td>
                  <!--Modify by chenrenda update begin 20050405-->                                    
                  <%--modify by wangli update end 20050407--%>
                </tr>
                <tr>
                    <td colspan="8" class="subformtitle" style="width:92%" >
                       <table  class="common" id="ThirdCarLoss" cellspacing="1" cellpadding="0">
                           <thead> 
                            <tr>
                                <td class="centertitle" style="width:10%">损失项目序号</td>
                                <td class="centertitle" style="width:15%">车牌号</td>
                                <td class="centertitle" style="width:15%">损失部位</td>
                                <td class="centertitle" style="width:15%">零件(项目)名称</td>
                                <td class="centertitle" style="width:26%">损失程度描述</td>
                              <td class="title" style="width:4%" >&nbsp;</td> 
                            </tr> 
                          </thead>
                          <tfoot>
                              <tr>
                                <td class="title" colspan=5 style="width:96%">(按"+"号键增加损失部位信息，按"-"号键删除信息)</td>
                                 <td class="title" align="right" style="width:4%">
                                 <div align="center">
                                 <input type="button" value="+" onclick="insertRowTable('ThirdCarLoss','ThirdCarLoss_Data',this)" name="buttonDriverInsert" style="cursor: hand">
                                 </div>
                                 </td>
                              </tr>
                           </tfoot> 
                            <tbody>
                              
                            </tbody>
                        </table>
                    </td>
                </tr>               
                
             </table>
          </td>
         
          <td class="title" style="width:4%">
             <div align="center">
                <input type=button name="buttonThirdPartyDelete"  onclick="deleteRow(this,'ThirdParty')" value="-" >
             </div>
          </td>
                  </tr>

                 </tbody>
             </table>
          </span>
          
          
          <span id="spanThirdPartyAll" style="display:">
          <%-- 多行输入展现域 --%>
             <table id="ThirdParty" class="common" align="center" cellspacing="1" cellpadding="0">
                <thead>
                  <tr>
                     <td class="title" style="width:4%">序号</td>
                     <td class="title" style="width:96%" colspan="2">内容
                   </td>
                  </tr>
                </thead>
                <tfoot>
                  <tr>
                     <td class="title" colspan=2 style="width:96%">(按"+"号键增加涉案车辆，按"-"号键删除信息)</td>
                     <td class="title" align="right" style="width:4%">
                        <div align="center">
                            <input type="button" value="+" onclick="insertRow('ThirdParty')" align="right" name="buttonThirdPartyInsert" >
                        </div>
                     </td>
                  </tr>
                  </tfoot>
                <tbody id="readonlyThirdPartyTable"> 
       <%
       int index=0;
       int intCheckLossIndex = 0;
       %>
       <% String butdisabled=""; //让-按钮不可以用%>

      <logic:notEmpty  name="prpLthirdPartyDto"  property="thirdPartyList">
        <logic:iterate id="thirdParty" name="prpLthirdPartyDto" property="thirdPartyList">
            
      <%
         //得到涉案车辆序号
         PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)request.getAttribute("prpLthirdPartyDto"); 
         ArrayList prpLthirdPartyList = new ArrayList();
         prpLthirdPartyList = (ArrayList)prpLthirdPartyDto.getThirdPartyList();
         PrpLthirdPartyDto prpLthirdPartyDto2  = (PrpLthirdPartyDto )prpLthirdPartyList.get(index);
         int intSerialNo = prpLthirdPartyDto2.getSerialNo();
      %> 
             
           
        
             <!-- 插入涉案车辆内容-->
             <%butdisabled="";%>
             <logic:equal name="prpLthirdPartyDto" property="nodeType" value="check">
             <%butdisabled="disabled";%>
             </logic:equal>
                <tr>
                   <td class="title" style="width:4%">
                     <div align="center">
                         <input class="readonlyno" readonly name="prpLthirdPartySerialNo" value="<bean:write name='thirdParty' property='serialNo'/>">
                         <input type="hidden" class="readonlyno"  name="prpLthirdPartyNewAddFlag" value="old" > <!--add by liyanjie 2005-12-17是否是新增的车辆标志 -->
                     </div>
                   </td>
                   <td class="subformtitle" style="width:92%" >
                       <table class="common" cellspacing="1" cellpadding="0">
                          <tr>
                          
                          <td class="common" style="TEXT-ALIGN: center" colspan=2 style="width:30%">
												   <logic:equal name="thirdParty" property="insureCarFlag" value="1"><font color=red>标的车</font></logic:equal>
												  	<logic:notEqual name="thirdParty" property="insureCarFlag" value="1"><font color=red>三者车</font></logic:notEqual>
												  </td>
												
                     <td class="title" style="width:10%">号牌号码</td>
                     <td class="input" style="width:20%;valign:bottom" >
                       <input name="prpLthirdPartyLicenseNo" class="input"  style="width:75%" maxlength=30 onblur="checkLength1(this)" description="号牌号码"  value="<bean:write name='thirdParty' property='licenseNo'/>">
                       <img src="/claim/images/bgMarkMustInput.jpg">
                     </td>

                   <td class="title" style="width:10%">车架号</td>

                   <td class="input" style="width:20%" >

                    <input type="text" name="prpLthirdPartyFrameNo" class="input" maxlength=20 description="车架号"  value="<bean:write name='thirdParty' property='frameNo'/>">
                   </td>

                 
                   <input type="hidden" name="prpLthirdPartySelectSend" value="<bean:write name='thirdParty' property='selectSend'/>" >
                   <input type="hidden" name="insuredFlag" value="1">
               </tr>
               <tr>
                 <td class="title"  style="width:10%">车辆种类</td>
                 <td class="input" style="width:20%">
                      <html:select name="thirdParty" property="carKindCode" styleClass="one" style="width:100%" >
                         <html:options collection="carKindCodes" property="codeCode" labelProperty="codeCName" />
                      </html:select>
                 </td>
                 <td class="title" style="width:10%">发动机号</td>
                 <td class="input" style="width:20%">
                 <input type="text" name="prpLthirdPartyEngineNo" value="<bean:write name='thirdParty' property='engineNo'/>"  class="input" maxlength=20 description="发动机号" >
                 </td>
                 <td class="title" style="width:10%">号牌底色</td>
                 <td class="input" style="width:20%">
                  <html:select name="thirdParty" property="licenseColorCode" >
                    <html:options collection="licenseColorCodes" property="codeCode" labelProperty="codeCName" />
                  </html:select>
                 </td>
                 </tr>
                 
               <tr>
                  <td class="title" style="width:10%">厂牌型号</td>
                  <td class="input" style="width:20%">
                   <input type="text" name="prpLthirdPartyBrandName" class="input" value="<bean:write name='thirdParty' property='brandName'/>" style="width:100%" maxlength=30 description="厂牌型号" >
                  </td>
                   <td class="title" style="width:10%">承保公司</td>
                   <td id="ThirdPartyInsureComCodeInput" class="input" style="width:20%" >
                       <input name="prpLthirdPartyInsureComCode" class="codecode" description="承保公司代码" style="width:30%" value="<bean:write name='thirdParty' property='insureComCode'/>">

                       <input type="text" name="prpLthirdPartyInsureComName" class="codename" maxlength=50 description="承保公司名称" style="width:60%" value="<bean:write name='thirdParty' property='insureComName'/>">
                   </td>
                   <td class="title" style="width:10%">车辆使用年限</td>
                   <td class="input" style="width:20%">
                    <input type="input" name="prpLthirdPartyUseYears" class="common" maxlength=5 description="车辆使用年限"
                                      value="<bean:write name='thirdParty' property='useYears'/>">
                   </td>


                 </tr>
                 <tr>
                   <td class="title" style="width:10%">VIN</td>
                   <td class="input" style="width:20%">
                     <input type="text" name="prpLthirdPartyVINNo" class="common" style="width:90%" value="<bean:write name='thirdParty' property='VINNo'/>" >
                   </td>
                   <td class="title" style="width:10%">行驶公里数</td>
                   <td class="input" style="width:20%">
                     <input type="text" name="prpLthirdPartyRunDistance" value="<bean:write name='thirdParty' property='runDistance'/>" class="common"  description="车辆已行驶公里数" maxlength=15 >
                   </td>
                   <td class="title" style="width:16%;display:none">是否为本保单车辆</td>
                   <td class="input"  style="width:6%;display:none;TEXT-ALIGN: center">
                   <input type="hidden" name="insureCarFlag" value="<bean:write name='thirdParty' property='insureCarFlag'/>">
                     <logic:equal name="thirdParty" property="insureCarFlag" value="1">标的车</logic:equal>
                     <logic:notEqual name="thirdParty" property="insureCarFlag" value="1">三者车</logic:notEqual>
                   </td>
                   <!-- modify by wangli update start 20050407 -->
                   <td class="title" id="tdDutyPercentTitle"  style="width:10%;">对本涉案车责任比例</td>
                   <td class="input" id="tdDutyPercentInput" style="width:20%;">
                     <input type="text" name="prpLthirdPartyDutyPercent" class="common" maxlength=6 description="保险车辆对本车责任"
                       style="width:90%"  value="<bean:write name='thirdParty' property='dutyPercent'/>">%
                       <img src="/claim/images/bgMarkMustInput.jpg"> 
                   </td>
                   <!-- modify by wangli update end 20050407 -->
                 </tr>
                 <tr>
                   <td colspan="8" class="subformtitle" style="width:92%" >
                     <table  class="common" id="ThirdCarLoss" cellspacing="1" cellpadding="0">
                       <thead>  
                        <tr>
                            <td class="centertitle" style="width:10%">损失项目序号</td>
                            <td class="centertitle" style="width:15%">车牌号</td>
                            <td class="centertitle" style="width:15%">损失部位</td>
                            <td class="centertitle" style="width:15%">零件(项目)名称</td>
                            <td class="centertitle" style="width:26%">损失程度描述</td>
                            <td class="title" style="width:4%" >&nbsp;</td> 
                        </tr>
                       </thead>
                       <tfoot>
                          <tr>
                            <td class="title" colspan=5 style="width:96%">(按"+"号键增加损失部位信息，按"-"号键删除信息)</td>
                             <td class="title" align="right" style="width:4%">
                             <div align="center">
                             <input type="button" value="+" onclick="insertRowTable('ThirdCarLoss','ThirdCarLoss_Data',this)" name="buttonDriverInsert" <%=butdisabled%> style="cursor: hand">
                             </div>
                             </td>
                          </tr>
                       </tfoot> 
                       <tbody>
                         <logic:notEmpty  name="prpLthirdCarLossDto"  property="thirdCarLossList"> 
                           <logic:iterate id="thirdCarLossdtox" name="prpLthirdCarLossDto" property="thirdCarLossList">
                             <input type="hidden" name="test" value="<bean:write name='thirdParty' property='serialNo'/>"> 
                             <input type="hidden" name="test2" value="<bean:write name='thirdCarLossdtox' property='serialNo'/>"> 
                     
                             <logic:equal name="thirdCarLossdtox" property="serialNo" value="<%=String.valueOf(intSerialNo)%>">
                                  <tr>
                                    <td class="input" style="width:10%"> 
                                      <input type="hidden"  name="prpLthirdCarLossFlag" value="<bean:write name='thirdCarLossdtox' property='flag'/>">
                                      <input type="hidden"  name="prpLthirdCarLossSerialNo" description="序号" value="<bean:write name='thirdCarLossdtox' property='serialNo'/>">
                                      <input type="hidden"  name="RelateSerialNo" description="序号" value="<bean:write name='thirdCarLossdtox' property='serialNo'/>">
                                      <input type="hidden"  name="prpLthirdCarLossLossGrade" value="<bean:write name='thirdCarLossdtox' property='lossGrade'/>">
                                      <input name="prpLthirdCarLossItemNo" class="readonly" readonly style="width:75%" maxlength=3 value="<bean:write name='thirdCarLossdtox' property='itemNo'/>">
                                    </td> 
                                    <td class="input" style="width:15%">
                                      <input name="prpLthirdCarLossLicenseNo" class="readonly" readonly  style="width:90%" value="<bean:write name='thirdCarLossdtox' property='licenseNo'/>">
                                    </td>
                                 
                                    <td class="input" style="width:15%">
                                      <html:select name="thirdCarLossdtox" property="partCode" styleClass="three" style="width:120px" onchange="getPartName(this);">
                                        <html:options  collection="partCodeList" property="value" labelProperty="label"/>
                                      </html:select>
                                      <input type="hidden"  name="partName"  value="<bean:write name='thirdCarLossdtox' property='partName'/>">
                                    </td>    
                                 
                                    <td class="input" style="width:15%">
                                      <input name="compName" class="codename" style="width:90%" value="<bean:write name='thirdCarLossdtox' property='compName'/>">  
                                      <input type="hidden"  name="compCode"  value="<bean:write name='thirdCarLossdtox' property='compCode'/>">
                                    </td>
                                  
                                    
                                    <td class="input" style="width:26%">
                                      <input name="prpLthirdCarLossLossDesc" class="input" style="width:90%" value="<bean:write name='thirdCarLossdtox' property='lossDesc'/>">
                                    </td>
                                    <td class="input" style='width:4%'  align="center">
                                    <div>
                                      <input type=button name="buttonThirdCarLossDelete"  onclick="deleteRowTable(this,'ThirdCarLoss',1,1)" value="-" <%=butdisabled%> style="cursor: hand">
                                    </div>
                                    </td>
                                  </tr>
                             </logic:equal>       
                           </logic:iterate>
                         </logic:notEmpty>          
                      </tbody> 
                    </table>  
                  </td>
                </tr>
               </table>
             </td>
             <td class="title" style="width:4%">
                <div align="center">
                   <input type=button name="buttonThirdPartyDelete"  onclick="deleteRow(this,'ThirdParty')" value="-" <%=butdisabled%> >
                </div>
             </td>
            </tr>
          <% index++;%>
        </logic:iterate> 
      </logic:notEmpty>
                </tbody>
             </table>
        </span>
      </td>
   </tr>
  
</table>