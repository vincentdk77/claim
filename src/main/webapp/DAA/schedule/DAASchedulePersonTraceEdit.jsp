<%--
****************************************************************************
* DESC       ��������˸�����Ϣҳ��
* AUTHOR     ��lixiang
* CREATEDATE �� 2005-02-20
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 
<%-- ��������չ�����ģ�� --%>
<%--���������Զ���JavaScript������--%>
    <script language='javascript'>
      //��������뱾ҳ�Զ����JavaScript����                        
    	/*
        ����һ���µ�personTrace֮��Ĵ�����ѡ������
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
        ɾ������PersonTrace֮��Ĵ�����ѡ������
      */
      function afterDeletePersonTrace(field)
      {
        setPrpLpersonTracePersonNo();
      }
    
      /**
       * ����setPrpLpersonTracePersonNo
       */
      function setPrpLpersonTracePersonNo(){
          var count=getElementCount("prpLpersonTracePersonNo");
          for(var i=0;i<count;i++)
          {
              //alert("����ʲôʱ������?count="+count+"  i="+i); 
              if(count!=1){
              	fm.prpLpersonTracePersonNo[i].value=i;
              	fm.prpLpersonTraceNewAddFlag[i].value="new" ; //add by liyanjie 2005-12-17
                    //�Ƿ��������������־=new,��Ϊ�Ѿ������˲���ɾ��ԭ����.
              }
          }  
      }		    
    </script> 
      <!--������ʾ��¼����������������ʾ��-->   
        <table class="common" align="center" style="width:100%"> 
          <!--��ʾ��ʾ���е�-->  
          <tr>  
            <td class="subformtitle" style="text-align:left" colspan="4">
              <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif" name="PersonTraceImg" onclick="showPage(this,spanClaimpersonTrace)">
              ���˸�����Ϣ<br>        
                <table width="100%" cellpadding="0" cellspacing="1" class="common"  id="PersonTrace_Data" style="display:none">
                  <tbody>  
                    <tr>
                      <td class="input" style="width:3%">
                        <div align="center">
                          <input class="readonlyNo" readonly name="prpLpersonTracePersonNo" description="���">
                          <input type="hidden" class="readonlyno"  name="prpLpersonTraceNewAddFlag" > <!--add by liyanjie 2005-12-17�Ƿ���������������ʧ -->
                          
                        </div>
                      </td>
                      <td class="subformtitle"  >
                        <table  cellpadding="0" cellspacing="1" class="common">
                          <tr>
                            <td class="title" style="width:10%">����</td>
                            <td class="input" style='width:18%'>
                              <input name="prpLpersonTracePersonName" class="input" style="width:70%" maxlength=20 description="���˸�������">
                              <img src="/claim/images/bgMarkMustInput.jpg">  
                            </td>
                            <td class="title" style="width:6%">�Ա�</td>
                            <td class="input" style="width:12%">           		                         
                            <%        
                              //modify by lixiang remark 20050308 start
                              //reason:�����Ա�Ĭ��Ϊδ˵��
                            %>                   		                          
                              <html:select name="prpLpersonTraceDto" property="personSex" style="width:70%" >
                              <html:option value="9" >δ˵��</html:option>
                              <html:option value="1">��</html:option>
                              <html:option value="2">Ů</html:option>
                              </html:select>
                              <img src="/claim/images/bgMarkMustInput.jpg">  
                              <%//modify by lixiang remark 20050308 end%>
                            </td>
                            <td class="title" style='width:10%'>����</td>
                            <td class="input" style='width:10%'>
                              <input name="prpLpersonTracePersonAge" class="input" maxlength=5 description="����">
                            </td>   
                            <td class="title" style="width:10%">������ҵ</td>
                            <td class="input" style='width:22%'>
                              <input name="prpLpersonTraceJobName" class="input" description="������ҵ">
                            </td>
                          </tr>


                          <tr>
                            <td class="title" >�漰����</td>
                            <td class="input" colspan="3" >��
                              <html:select name="prpLpersonTraceDto" property="prpLpersonTraceReferKind" style="width:50%">
                                <html:options collection="referKindList" property="kindCode" labelProperty="kindName" />
                              </html:select>
                            </td>
                            <td></td>
                          </tr>


                          <tr>
                            <td class="title" >���˲�λ</td>
                            <td class="input" colspan="7">
                              <input name="prpLpersonTracePartDesc" class="input" description="���˲�λ">
                            </td>
                          </tr>
                          <tr>
                            <td class="title" >��������</td>
                            <td class="input" colspan="7">
                              <input name="prpLpersonTraceWoundRemark" class="input" description="��������">
                            </td>
                          </tr>
                          <tr>
                            <td class="title" >�Ƿ����о�ҽ</td>
                            <td class="input" colspan="3" >��
                              <html:select name="prpLpersonTraceDto" property="motionFlag" style="width:50%">
                              <html:option value="0" >��</html:option>
                              <html:option value="1" >��</html:option>
                              </html:select>
                            </td>
                            <td class="title" >����ҽԺ</td>
                            <td class="input" colspan="3" >
                              <input name="prpLpersonTraceHospital" class="input" description="����ҽԺ">
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
                <%-- ��������չ���� --%>
                  <table  class="sub" id="PersonTrace" align="center" cellspacing="1" cellpadding="0">
                    <thead>
                      <tr>
                        <td class="title" style="width:4%">���</td>
                        <td class="title" style="width:96%" colspan=2> 
                          <p align="right">
                          </p>     
                        </td>
                        <input type="hidden" name="prpLpersonTraceSelectSend" value="<bean:write name='prpLpersonTraceDto' property='selectSend'/>" >                        
                      </tr>                        
                    </thead>
                    <tfoot>
                      <tr>
                        <td class="title" colspan=2 style="width:96%">(��"+"�ż��������˸�����Ϣ����"-"�ż�ɾ����Ϣ)</td>
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
                       //Reason:ȡ��������ʧ��Ϣ
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
                          	<input type="hidden" class="readonlyno"  name="prpLpersonTraceNewAddFlag" value="old" > <!--add by liyanjie 2005-12-17�Ƿ������������˱�־ -->
                          </div>
                        </td>
                        <td class="subformtitle" >
                          <table  cellpadding="0" cellspacing="1" class="common">
                            <tr>
                              <td class="title" style="width:10%">����</td>
                              <td class="input" style='width:18%'>
                                <input name="prpLpersonTracePersonName" class="input" style="width:70%" maxlength=20 description="���˸�������"
                                value="<bean:write name='personTrace' property='personName'/>">
                                <img src="/claim/images/bgMarkMustInput.jpg">  
                              </td>
                              <td class="title" style="width:6%">�Ա�</td>
                              <td class="input" style="width:12%">           		                         
                                <html:select name="personTrace" property="personSex" style="width:70%">
                                  <html:options collection="driverSexs" property="codeCode" labelProperty="codeCName" />
                                </html:select> 
                                <img src="/claim/images/bgMarkMustInput.jpg">  
                              </td>
                              <td class="title" style='width:10%'>����</td>
                              <td class="input" style='width:10%'>
                                <input name="prpLpersonTracePersonAge" class="input" maxlength=5 description="����"
                                value="<bean:write name='personTrace' property='personAge'/>">
                              </td>   
                              <td class="title" style="width:10%">������ҵ</td>
                              <td class="input" style='width:22%'>
                                <input name="prpLpersonTraceJobName" class="input" description="������ҵ"
                                value="<bean:write name='personTrace' property='jobName'/>" >
                              </td>
                            </tr>
                            <!--Modify by chenrenda add begin 20050417-->
                            <!--Reason:������ģ��ϵ�������ʧ��Ϣ��-->

                            <tr>
                              <td class="title" >�漰����</td>
                              <td class="input" colspan="3" >�� 
                                <html:select name="personTrace" property="prpLpersonTraceReferKind"  style="width:50%">
                                  <html:options collection="referKindList" property="kindCode" labelProperty="kindName" />  
                                </html:select>                    
                              </td>
                              <td></td>
                             </tr> 

                            <!--Modify by chenrenda add end 20050417-->
                            
                            <tr>
                              <td class="title" >���˲�λ</td>
                              <td class="input" colspan="7">
                                <input name="prpLpersonTracePartDesc" class="input" description="���˲�λ"
                                value="<bean:write name='personTrace' property='partDesc'/>" >
                              </td>
                            </tr>
                            <tr>
                              <td class="title" >��������</td>
                              <td class="input" colspan="7">
                                <input name="prpLpersonTraceWoundRemark" class="input" description="��������"
                                value="<bean:write name='personTrace' property='woundRemark'/>" >
                              </td>
                            </tr>    
                            <tr>
                              <td class="title" >�Ƿ����о�ҽ</td>
                              <td class="input" colspan="3" >�� 
                                <html:select name="personTrace" property="motionFlag" style="width:50%">
                                  <html:option value="0" >��</html:option>
                                  <html:option value="1" >��</html:option>
                                </html:select>                    
                              </td>
                              <td class="title" >����ҽԺ</td>
                              <td class="input" colspan="3" >
                                <input name="prpLpersonTraceHospital" class="input" description="����ҽԺ"  value="<bean:write name='personTrace' property='hospital'/>">
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
      




     
