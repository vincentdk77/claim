<%--
****************************************************************************
* DESC       ：添加人伤跟踪信息页面
* AUTHOR     ：lixiang
* CREATEDATE ： 2005-02-20
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 
<%-- 多行输入展现域的模板 --%>
<%--多行输入自定义JavaScript方法域--%>
    <script language='javascript'>
      //在下面加入本页自定义的JavaScript方法                        
    	/*
        插入一条新的personTrace之后的处理（可选方法）
      */
      function afterInsertPersonTrace()
      {
        setPrpLpersonTracePersonNo();      
      }
      function check_person(){
      
      if (fm.personcount.value=="0" && fm.prpLpersonTraceReferKind.value==""){
      fm.buttonPersonTraceInsert.disabled = true;
        }
      
      }
      /*
        删除本条PersonTrace之后的处理（可选方法）
      */
      function afterDeletePersonTrace(field)
      {
        setPrpLpersonTracePersonNo();
      }
    
      /**
       * 设置setPrpLpersonTracePersonNo
       */
      function setPrpLpersonTracePersonNo(){
          var count=getElementCount("prpLpersonTracePersonNo");
          for(var i=0;i<count;i++)
          {
              //alert("看看什么时候运行?count="+count+"  i="+i); 
              if(count!=1){
              	fm.prpLpersonTracePersonNo[i].value=i;
              	fm.prpLpersonTraceNewAddFlag[i].value="new" ; //add by liyanjie 2005-12-17
                    //是否是新增的人损标志=new,因为已经控制了不能删除原来的.
              }
          }  
      }		    
    </script> 
      <!--建立显示的录入条，可以收缩显示的-->   
        <table class="common" align="center" style="width:100%"> 
          <!--表示显示多行的-->  
          <tr>  
            <td class="subformtitle" style="text-align:left" colspan="4">
              <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif" name="PersonTraceImg" onclick="showPage(this,spanClaimpersonTrace)">
              人伤跟踪信息<br>        
                <table width="100%" cellpadding="0" cellspacing="1" class="common"  id="PersonTrace_Data" style="display:none">
                  <tbody>  
                    <tr>
                      <td class="input" style="width:3%">
                        <div align="center">
                          <input class="readonlyNo" readonly name="prpLpersonTracePersonNo" description="序号">
                          <input type="hidden" class="readonlyno"  name="prpLpersonTraceNewAddFlag" > <!--add by liyanjie 2005-12-17是否是新增的人伤损失 -->
                          
                        </div>
                      </td>
                      <td class="subformtitle"  >
                        <table  cellpadding="0" cellspacing="1" class="common">
                          <tr>
                            <td class="title" style="width:10%">姓名</td>
                            <td class="input" style='width:18%'>
                              <input name="prpLpersonTracePersonName" class="input" style="width:70%" maxlength=20 description="人伤跟踪姓名">
                              <img src="/claim/images/bgMarkMustInput.jpg">  
                            </td>
                            <td class="title" style="width:6%">性别</td>
                            <td class="input" style="width:12%">           		                         
                            <%        
                              //modify by lixiang remark 20050308 start
                              //reason:人伤性别默认为未说明
                            %>                   		                          
                              <html:select name="prpLpersonTraceDto" property="personSex" style="width:70%" >
                              <html:option value="9" >未说明</html:option>
                              <html:option value="1">男</html:option>
                              <html:option value="2">女</html:option>
                              </html:select>
                              <img src="/claim/images/bgMarkMustInput.jpg">  
                              <%//modify by lixiang remark 20050308 end%>
                            </td>
                            <td class="title" style='width:10%'>年龄</td>
                            <td class="input" style='width:10%'>
                              <input name="prpLpersonTracePersonAge" class="input" maxlength=5 description="年龄">
                            </td>   
                            <td class="title" style="width:10%">从事行业</td>
                            <td class="input" style='width:22%'>
                              <input name="prpLpersonTraceJobName" class="input" description="从事行业">
                            </td>
                          </tr>


                          <tr>
                            <td class="title" >涉及险种</td>
                            <td class="input" colspan="3" >　
                              <html:select name="prpLpersonTraceDto" property="prpLpersonTraceReferKind" style="width:50%">
                                <html:options collection="referKindList" property="kindCode" labelProperty="kindName" />
                              </html:select>
                            </td>
                            <td></td>
                          </tr>


                          <tr>
                            <td class="title" >受伤部位</td>
                            <td class="input" colspan="7">
                              <input name="prpLpersonTracePartDesc" class="input" description="受伤部位">
                            </td>
                          </tr>
                          <tr>
                            <td class="title" >伤情描述</td>
                            <td class="input" colspan="7">
                              <input name="prpLpersonTraceWoundRemark" class="input" description="伤情描述">
                            </td>
                          </tr>
                          <tr>
                            <td class="title" >是否自行就医</td>
                            <td class="input" colspan="3" >　
                              <html:select name="prpLpersonTraceDto" property="motionFlag" style="width:50%">
                              <html:option value="0" >否</html:option>
                              <html:option value="1" >是</html:option>
                              </html:select>
                            </td>
                            <td class="title" >就诊医院</td>
                            <td class="input" colspan="3" >
                              <input name="prpLpersonTraceHospital" class="input" description="就诊医院">
                              <input name="prpLpersonTraceIdentifyNumber"  type="hidden">
                              <input name="prpLpersonTraceRelatePersonNo"  type="hidden">
                              <input name="prpLpersonTraceJobCode"  type="hidden">
                              <input name="prpLpersonTraceRemark"  type="hidden">
                              <input name="prpLpersonTraceFlag"  type="hidden">
                            </td>
                          </tr>
                        </table>
                      </td>
                      <td class="input" style='width:4%'>
                        <div align="center">
                        <input type=button name="buttonPersonTraceDelete"  onclick="deleteRow(this,'PersonTrace')" value="-" style="cursor: hand">
                        </div>
                      </td>
                    </tr>
                  </tbody>
                </table>

                <span  id="spanClaimpersonTrace" style="display:none">
                <%-- 多行输入展现域 --%>
                  <table  class="sub" id="PersonTrace" align="center" cellspacing="1" cellpadding="0">
                    <thead>
                      <tr>
                        <td class="title" style="width:4%">序号</td>
                        <td class="title" style="width:96%" colspan=2> 
                          <p align="right">
                          </p>     
                        </td>
                        <input type="hidden" name="prpLpersonTraceSelectSend" value="<bean:write name='prpLpersonTraceDto' property='selectSend'/>" >                        
                      </tr>                        
                    </thead>
                    <tfoot>
                      <tr>
                        <td class="title" colspan=2 style="width:96%">(按"+"号键增加人伤跟踪信息，按"-"号键删除信息)</td>
                        <td class="title" align="right" style="width:4%">
                          <div align="center">
                          
                          
                          <input type="button" value="+" onclick="insertRow('PersonTrace')" name="buttonPersonTraceInsert" style="cursor: hand">
                          <!--test-->
                          </div>
                        </td>                                  
                      </tr>
                    </tfoot> 
                    <tbody id="readonlyPersonTraceTable">
                      <%index=0;%>
                      <logic:notEmpty  name="prpLpersonTraceDto"  property="personTraceList"> 
                        <logic:iterate id="personTrace" name="prpLpersonTraceDto" property="personTraceList">
                        <%
                        if(index %2== 0)
                          out.print("<tr class=oddrow>");
                        else 
                          out.print("<tr class=oddrow>");
              
                     
                       //Modify by chenrenda update begin 20050418
                       //Reason:取出估计损失信息
                       PrpLcheckLossDto prpLcheckLossDto2 = null;
                    /*   if(strPersonTraceNodeType.equals("check"))
                       {
                    
                         PrpLcheckLossDto prpLcheckLossDto = (PrpLcheckLossDto)request.getAttribute("prpLcheckLossDto"); 
                         ArrayList prpLcheckLossList = new ArrayList();
                         prpLcheckLossList = (ArrayList)prpLcheckLossDto.getPrpLcheckLossList();
                         
                         if(prpLcheckLossList==null||prpLcheckLossList.size()==0)
                         {
                           prpLcheckLossDto2 = new PrpLcheckLossDto();
                         }
                         else
                         {
                           prpLcheckLossDto2  = (PrpLcheckLossDto)prpLcheckLossList.get(intCheckLossIndex);
                           intCheckLossIndex++;  
                         }
                      */   
                    //   }
                       //Modify by chenrenda update end 20050418
                       
                       %>
                        <td class="input" style="width:4%">
                          <div align="center">
                          <input  name="prpLpersonTracePersonNo"  class="readonlyno" readonly="true" value="<bean:write name='personTrace' property='personNo'/>">
                          	<input type="hidden" class="readonlyno"  name="prpLpersonTraceNewAddFlag" value="old" > <!--add by liyanjie 2005-12-17是否是新增的人伤标志 -->
                          </div>
                        </td>
                        <td class="subformtitle" >
                          <table  cellpadding="0" cellspacing="1" class="common">
                            <tr>
                              <td class="title" style="width:10%">姓名</td>
                              <td class="input" style='width:18%'>
                                <input name="prpLpersonTracePersonName" class="input" style="width:70%" maxlength=20 description="人伤跟踪姓名"
                                value="<bean:write name='personTrace' property='personName'/>">
                                <img src="/claim/images/bgMarkMustInput.jpg">  
                              </td>
                              <td class="title" style="width:6%">性别</td>
                              <td class="input" style="width:12%">           		                         
                                <html:select name="personTrace" property="personSex" style="width:70%">
                                  <html:options collection="driverSexs" property="codeCode" labelProperty="codeCName" />
                                </html:select> 
                                <img src="/claim/images/bgMarkMustInput.jpg">  
                              </td>
                              <td class="title" style='width:10%'>年龄</td>
                              <td class="input" style='width:10%'>
                                <input name="prpLpersonTracePersonAge" class="input" maxlength=5 description="年龄"
                                value="<bean:write name='personTrace' property='personAge'/>">
                              </td>   
                              <td class="title" style="width:10%">从事行业</td>
                              <td class="input" style='width:22%'>
                                <input name="prpLpersonTraceJobName" class="input" description="从事行业"
                                value="<bean:write name='personTrace' property='jobName'/>" >
                              </td>
                            </tr>
                            <!--Modify by chenrenda add begin 20050417-->
                            <!--Reason:赔款费用模块合到人伤损失信息中-->

                            <tr>
                              <td class="title" >涉及险种</td>
                              <td class="input" colspan="3" >　 
                                <html:select name="personTrace" property="prpLpersonTraceReferKind"  style="width:50%">
                                  <html:options collection="referKindList" property="kindCode" labelProperty="kindName" />  
                                </html:select>                    
                              </td>
                              <td></td>
                             </tr> 

                            <!--Modify by chenrenda add end 20050417-->
                            
                            <tr>
                              <td class="title" >受伤部位</td>
                              <td class="input" colspan="7">
                                <input name="prpLpersonTracePartDesc" class="input" description="受伤部位"
                                value="<bean:write name='personTrace' property='partDesc'/>" >
                              </td>
                            </tr>
                            <tr>
                              <td class="title" >伤情描述</td>
                              <td class="input" colspan="7">
                                <input name="prpLpersonTraceWoundRemark" class="input" description="伤情描述"
                                value="<bean:write name='personTrace' property='woundRemark'/>" >
                              </td>
                            </tr>    
                            <tr>
                              <td class="title" >是否自行就医</td>
                              <td class="input" colspan="3" >　 
                                <html:select name="personTrace" property="motionFlag" style="width:50%">
                                  <html:option value="0" >否</html:option>
                                  <html:option value="1" >是</html:option>
                                </html:select>                    
                              </td>
                              <td class="title" >就诊医院</td>
                              <td class="input" colspan="3" >
                                <input name="prpLpersonTraceHospital" class="input" description="就诊医院"  value="<bean:write name='personTrace' property='hospital'/>">
                                <input name="prpLpersonTraceIdentifyNumber"  type="hidden" value="<bean:write name='personTrace' property='identifyNumber'/>">
                                <input name="prpLpersonTraceRelatePersonNo"  type="hidden" value="<bean:write name='personTrace' property='relatePersonNo'/>">
                                <input name="prpLpersonTraceJobCode"  type="hidden" value="<bean:write name='personTrace' property='jobCode'/>">
                                <input name="prpLpersonTraceRemark"  type="hidden" value="<bean:write name='personTrace' property='remark'/>">
                                <input name="prpLpersonTraceFlag"  type="hidden" value="<bean:write name='personTrace' property='flag'/>">
                              </td>
                            </tr> 
                          </table>
                        </td>  
                        <td class="title" style="width:4%">
                            <div align="center">
                              <input type=button name="buttonPersonTraceDelete"  onclick="deleteRow(this,'PersonTrace')" value="-"  disabled style="cursor: hand">
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
          
          <input type="hidden" name=personcount value="<%=index%>"> 
          <input type="hidden" name=referKindListCount value="<%=request.getAttribute("referKindListCount")%> 
        </table>
      




     
