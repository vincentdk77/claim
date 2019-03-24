<%--
****************************************************************************
* DESC       ：财产损失部位信息页面
* AUTHOR     ：理赔项目组
* CREATEDATE ：2005-4-12
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
   <!--建立显示的录入条，可以收缩显示的-->

    <script language='javascript'>
		   <!--
      //在下面加入本页自定义的JavaScript方法

      /*
        插入一条新的之后的处理（可选方法）
      */
      function afterInsertThirdProp()
      {
        setPrpLThirdPropSerialNo();
      }

      /*
        删除本条WarnRegion之后的处理（可选方法）
      */
      function afterDeleteThirdProp(field)
      {
        setPrpLThirdPropSerialNo();
      }

      /**
       * 设置setPrpLThirdPropSerialNo
       */
      function setPrpLThirdPropSerialNo(){
        var count=getElementCount("prpLthirdPropItemNo");
        for(var i=0;i<count;i++)
        {
          if(count!=1){
              fm.prpLthirdPropItemNo[i].value=i;
              fm.prpLthirdPropNewAddFlag[i].value="new" ; //add by liyanjie 2005-12-18
                    //是否新增标志=new,因为已经控制了不能删除原来的.
          }
        }
      }

      //以下打开代码页面
      function openLossItemCodeWin(PageCode,Field)
      {
        var index = parseInt(getElementOrder(Field))-1;
        var partCode = fm.txtCodeType.value;
        var pageUrl="/claim/DAA/regist/DAARegistGetCompCode.jsp?strIndex="+index+"&partCode="+partCode;
        window.open(pageUrl,"openLossItemCodeWin","resizable=0,scrollbars,dependent,alwaysRaised,width=230,height=450");
      }



      //-->
    </script>

   <table class="common" cellspacing="1" cellpadding="5" id="tabThridProp">
    <!--表示显示多行的-->
    <tr>
      <td class="common" colspan="4" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="ThirdPropImg" onclick="showPage(this,spanThirdProp)">
             财产损失信息<br>
        <span style="display:none">
          <table class="common" style="display:none" id="ThirdProp_Data" cellspacing="1" cellpadding="5">
            <tbody>
              <tr>
                <td class="input"  style="width:12%">
                  <input type="hidden"  name="prpLthirdPropFlag">
                  <input name="prpLthirdPropItemNo" class="readonly" readonly style="width:75%" maxlength=3 value="1">
                  <input type="hidden" class="readonlyno"  name="prpLthirdPropNewAddFlag" > <!--add by liyanjie 2005-12-18是否新增标志 -->
           
                </td>
                <%--<td class="input">
                  <input name="prpLthirdPropLicenseNo" class="common"  maxlength=20 style="width:90%" >
                </td>--%>
                 <input type="hidden" name="prpLthirdPropLicenseNo" class="common"  maxlength=20 style="width:90%" >
                <td class="input"  style="width:10%">
                  <input name="prpLthirdLossItemName" maxLength="100" onblur="checkLength1(this);" description="损失名称" class="input" style="width:90%"
                     <%--ondblclick="return openLossItemCodeWin(ThirdProp,this);"--%>>
                  <input type="hidden" name="prpLthirdLossItemCode">
                </td>
                <td class="input"  style="width:22%">
                  <input name="prpLthirdPropLossDesc" maxLength="255" onblur="checkLength1(this);" description="损失程度描述" class="input" style="width:90%">
                </td>
                <!--Modify by chenrenda add begin 20050417-->
                <!--Reason:赔款费用模块合到财产损失信息中-->
                 <%
                 String strThirdPropNodeType = (String)request.getAttribute("prpLnodeType");
                 if(strThirdPropNodeType.equals("check"))
                 {
                 %>
                 <td class="input"  style="width:10%">
                    <html:select name="prpLthirdPropDto" property="prpLthirdPropKindCode"  style="width:100px">
                      <html:options collection="prpLcheckPropItemKindList" property="kindCode" labelProperty="kindName" />
                    </html:select>
                </td>
                <td class="input"  style="width:10%">
                  <input name="prpLthirdPropLossFee" class="input" style="width:100%;align:right">
                </td>
                 <%
                 }
                 %>

                <!--Modify by chenrenda add end 20050417-->

                <td class="input" style='width:4%'  align="center">
                  <div>
                    <input type=button name="buttonThirdPropDelete" class=smallbutton onclick="deleteRow(this,'ThirdProp')" value="-" style="cursor: hand">
                  </div>
                </td>
              </tr>
            </tbody>
          </table>
        </span>


        <span  id="spanThirdProp" style="display:none" cellspacing="1" cellpadding="0">
        <%-- 多行输入展现域 --%>
        <table class="common" id="ThirdProp" cellspacing="1" cellpadding="5">
          <thead>
            <tr>
                <td class="centertitle" style="width:12%">损失项目序号</td>
               <%-- <td class="centertitle" >车牌号</td>--%>
                <td class="centertitle" style="width:10%">损失名称</td>
                <td class="centertitle" style="width:22%">损失程度描述</td>

                <!--Modify by chenrenda add begin 20050417-->
                <!--Reason:赔款费用模块合到财产损失信息中-->
                <%
                String strThirdPropRows = "4";
                if(strThirdPropNodeType.equals("check"))
                {
                %>
                <td class="centertitle" style="width:10%">险别代码</td>
                <td class="centertitle" style="width:20%">损失金额</td>
                <%
                  strThirdPropRows = "6";
                }
                %>
                <!--Modify by chenrenda add end 20050417-->
                <td class="centertitle" style="width:4%" >&nbsp;</td>
                <td class="centertitle" style="width:4%" >&nbsp;</td>
            </tr>
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan=<%=strThirdPropRows%> >(按"+"号键增加损失部位信息，按"-"号键删除信息)
                <%--
                <logic:equal name="prpLthirdPartyDto" property="nodeType" value="regis">

                              <select name="thirdPropCheck" style="width:80px">

                                   <logic:equal name='prpLthirdPropDto' property='selectSend' value="1">
                                      <option value="1" selected>调度</option>
                                      <option value="0" >暂不调度</option>
                                   </logic:equal>

                                   <logic:notEqual name='prpLthirdPropDto' property='selectSend' value="1">
                                       <option value="1" >调度</option>
                                       <option value="0" selected>暂不调度</option>
                                   </logic:notEqual>
                              </select> 
                              
                              <select name="prpLthirdPropScheduleType" style="width:100px;" value="schel" >
                                <option value="schel" >定损调度</option>
                              <select>
                            </logic:equal>
                    --%>        
                    
                              <input type="hidden" name="thirdPropCheck" value="0" >   
                               <input type="hidden" name="selectSend" value="0" >                        
                              <input type="hidden" name="prpLthirdPropSelectSend" value="<bean:write name='prpLthirdPropDto' property='selectSend'/>" >                        
                 
                </td>
                <td class="title" align="right" style="width:2%">
                 <div align="center">
                 <input type="button" class=smallbutton value="+" class=smallbutton onclick="insertRowOfThirdProp('ThirdProp','ThirdProp_Data',this)" name="buttonThirdPropInsert" style="cursor: hand">
                 </div>
                </td>
              </tr>
           </tfoot>
          </tfoot>
          <tbody>

      <%
      //得到承保险别集合
      Collection prpLThirdPropItemKindColl = (Collection)request.getAttribute("prpLcheckPropItemKindList");
      int checkLossNow=0;
      %>
      <logic:notEmpty  name="prpLthirdPropDto"  property="thirdPropList">
        <logic:iterate id="ThirdPropdtox" name="prpLthirdPropDto" property="thirdPropList">

              <%
                //Modify by chenrenda update begin 20050418
//System.out.println("读取财产险的序号："+intCheckLossIndex);
                PrpLcheckLossDto prpLcheckLossDto2 = null;
                if(strThirdPropNodeType.equals("check"))
                {
                  //Reason:取出估计损失信息
                  PrpLcheckLossDto prpLcheckLossDto = (PrpLcheckLossDto)request.getAttribute("prpLcheckLossDto");
                  ArrayList prpLcheckLossList = new ArrayList();
                  prpLcheckLossList = (ArrayList)prpLcheckLossDto.getPrpLcheckLossList();

                  if(prpLcheckLossList==null||prpLcheckLossList.size()==0)
                  {
                    prpLcheckLossDto2 = new PrpLcheckLossDto();
                  }
                  else
                  {
                     if (intCheckLossIndex<prpLcheckLossList.size()){
                       prpLcheckLossDto2  = (PrpLcheckLossDto)prpLcheckLossList.get(intCheckLossIndex);
                   
                        intCheckLossIndex++;
                       }else{
                       prpLcheckLossDto2 = new PrpLcheckLossDto();
                       }
                  }
                }
                  
                //Modify by chenrenda update end 20050418
              %>
              <tr>
                <input type="hidden"  name="prpLthirdPropFlag" value="<bean:write name='ThirdPropdtox' property='flag'/>">
                <td class="input"  style="width:12%">
                  <input name="prpLthirdPropItemNo" class="readonly" readonly style="width:75%" maxlength=3 value="<bean:write name='ThirdPropdtox' property='serialNo'/>">
                  <input type="hidden" class="readonlyno"  name="prpLthirdPropNewAddFlag" value="old" > <!--add by liyanjie 2005-12-18是否新增标志 -->
          
                </td>
               <%-- <td class="input">
                  <input name="prpLthirdPropLicenseNo" class="common"   style="width:90%"  maxlength="1" value="<bean:write name='ThirdPropdtox' property='licenseNo'/>">
                </td>--%>
                <input type="hidden" name="prpLthirdPropLicenseNo" class="common"   style="width:90%"  maxlength="1" value="<bean:write name='ThirdPropdtox' property='licenseNo'/>">
                <td class="input"  style="width:10%">
                  <input name="prpLthirdLossItemName" class="input" style="width:90%" maxLength="100" onblur="checkLength1(this);" description="损失名称" value="<bean:write name='ThirdPropdtox' property='lossItemName'/>"
                     <%--ondblclick="return openLossItemCodeWin(ThirdProp,this);"--%>>
                  <input type="hidden"  name="prpLthirdLossItemCode"  value="<bean:write name='ThirdPropdtox' property='lossItemCode'/>">
                </td>
                <td class="input"  style="width:22%">
                  <input name="prpLthirdPropLossDesc" class="input" style="width:90%" maxLength="255" onblur="checkLength1(this);" description="损失程度描述" value="<bean:write name='ThirdPropdtox' property='lossItemDesc'/>">
                </td>

                <!--Modify by chenrenda add begin 20050417-->
                <!--Reason:赔款费用模块合到财产损失信息中-->
                <%
                if(strThirdPropNodeType.equals("check")){
                %>
                <td class="input"  style="width:10%">

                 <select name="prpLthirdPropKindCode" styleClass="three" style='width:100px' >
                   <%
                      Iterator prpLcheckItemKind = prpLThirdPropItemKindColl.iterator();
                      while (prpLcheckItemKind.hasNext()){
                        PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)prpLcheckItemKind.next();
                   %>
                      <option value="<%= prpCitemKindDto.getKindCode() %>" <%= ((prpCitemKindDto.getKindCode().trim().equals(prpLcheckLossDto2.getKindCode())) ? "selected" : "") %>><%= prpCitemKindDto.getKindName() %></option>
                    <%
                       }
                   %>
                   </select>
                </td>
                <td class="input"  style="width:20%">
                  <input  name="prpLthirdPropLossFee" class="input" style="width:100%;align:right"  value="<%=prpLcheckLossDto2.getLossFee()%>" >
                </td>
                <%
                }
                %>
                <!--Modify by chenrenda add end 20050417-->

                <td class="input" colspan=2 style='width:2%'  align="center">
                <div>
                  <input type=button name="buttonThirdPropDelete"  class=smallbutton onclick="deleteRow(this,'ThirdProp')" value="-" style="cursor: hand">
                </div>
                </td>
              </tr>

        </logic:iterate>
      </logic:notEmpty>
          </tbody>
          <!--其它损失代码定为5-->
          <input type="hidden" name="txtCodeType" value="5">
        </table>
        </span>
      </td>
    </tr>
  </table>








