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
              }
          }  
      }		    
    </script> 
      <!--������ʾ��¼����������������ʾ��-->   
        <table class="common" cellpadding="5" cellspacing="1"> 
          <!--��ʾ��ʾ���е�-->  
          <tr>  
            <td class="common" colspan="4" style="text-align:left;">
              <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif" name="PersonTraceImg" onclick="showPage(this,spanClaimpersonTrace)">
              ���˸�����Ϣ<br>        
                <table cellpadding="5" cellspacing="1" class=common  id="PersonTrace_Data" style="display:none">
                  <tbody>  
                    <tr>
                      <td class="input" style="width:3%">
                        <div align="center">
                          <input class="readonlyNo" readonly name="prpLpersonTracePersonNo" description="���">
                        </div>
                      </td>
                      <td class="common"  >
                        <table cellpadding="5" cellspacing="1" class="common">
                          <tr>
                            <td class="title" style="width:12%">��&nbsp;&nbsp;&nbsp;&nbsp;��</td>
                            <td class="input" style='width:16%'>
                              <input name="prpLpersonTracePersonName" class="input" style="width:70%" maxlength=20 description="���˸�������">
                              <!--<img src="/claim/images/bgMarkMustInput.jpg">  -->
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
                            <td class="title" style='width:10%' align=center>����</td>
                            <td class="input" style='width:10%'>
                              <input name="prpLpersonTracePersonAge" class="input" maxlength=5 description="����">
                            </td>   
                            <td class="title" style="width:10%">������ҵ</td>
                            <td class="input" style='width:22%'>
                              <input name="prpLpersonTraceJobName" class="input" description="������ҵ"  style="width:100%">
                            </td>
                          </tr>
                          <tr>
                            <td class="title"  style="width:12%">�漰����</td>
                            <td class="input" colspan="7" align=left>��
                              <html:select name="prpLpersonTraceDto" property="prpLpersonTraceReferKind" style="width:50%">
                                <html:options collection="referKindList" property="kindCode" labelProperty="kindName" />
                              </html:select>
                            </td>
                          </tr>
                          <tr>
                            <td class="title" style="width:12%">���˲�λ</td>
                            <td class="input" colspan="7">
                              <input name="prpLpersonTracePartDesc" class="input" maxLength="100" onblur="checkLength1(this);" description="���˲�λ">
                            </td>
                          </tr>
                          <tr>
                            <td class="title" style="width:12%">��������</td>
                            <td class="input" colspan="7">
                              <input name="prpLpersonTraceWoundRemark" class="input" maxLength="255" onblur="checkLength1(this);" description="��������">
                            </td>
                          </tr>
                          <tr>
                            <td class="title" style="width:12%">�Ƿ����о�ҽ</td>
                            <td class="input" colspan="3" >��
                              <html:select name="prpLpersonTraceDto" property="motionFlag" style="width:50%">
                              <html:option value="0" >��</html:option>
                              <html:option value="1" >��</html:option>
                              </html:select>
                            </td>
                            <td class="title" align=center>����ҽԺ</td>
                            <td class="input" colspan="3" >
                              <input name="prpLpersonTraceHospital" class="input" maxLength="100" onblur="checkLength1(this);" description="����ҽԺ">
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
                        <input type=button name="buttonPersonTraceDelete" class="smallbutton"  onclick="deleteRow(this,'PersonTrace')" value="-" style="cursor: hand">
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
                        <td class="centertitle" style="width:4%">���</td>
                        <td class="centertitle" style="width:92%">���� 
                        </td>
                        <td class="centertitle" style="width:4%"> </td>
                      </tr>                        
                    </thead>
                    <tfoot>
                      <tr>
                       	     <td class="title" colspan=2 >(��"+"�ż�������ʧ��λ��Ϣ����"-"�ż�ɾ����Ϣ)
                             <input type="hidden" name="personCheck" value="1" >       
                             <input type="hidden" name="selectSend" value="0" >           
                             <input type="hidden" name="prpLpersonTraceSelectSend" value="<bean:write name='prpLpersonTraceDto' property='selectSend'/>" >                        
                 			  </td>
        
                        <td class="title" colspan= align="right" style="width:4%">
                          <div align="center">
                          <input type="button" value="+" class=smallbutton onclick="insertRow('PersonTrace')" name="buttonPersonTraceInsert" style="cursor: hand">
                          </div>
                        </td>                                  
                      </tr>
                    </tfoot> 
                    <tbody>
                      <%index=0;%>
                      <logic:notEmpty  name="prpLpersonTraceDto"  property="personTraceList"> 
                        <logic:iterate id="personTrace" name="prpLpersonTraceDto" property="personTraceList">
                        <%
                        if(index %2== 0)
                          out.print("<tr class=oddrow>");
                        else 
                          out.print("<tr class=oddrow>");                       
                       %>
                        <td class="input" style="width:4%">
                          <div align="center">
                          <input  name="prpLpersonTracePersonNo"  class="readonlyno" readonly="true" value="<bean:write name='personTrace' property='personNo'/>">
                          </div>
                        </td>
                        <td class="subformtitle" >
                          <table  class="common" cellpadding="5" cellspacing="1">
                            <tr>
                              <td class="title" style="width:12%">����</td>
                              <td class="input" style='width:18%'>
                                <input name="prpLpersonTracePersonName" class="input" style="width:70%" maxlength=20 description="���˸�������"
                                value="<bean:write name='personTrace' property='personName'/>">
                                <!--<img src="/claim/images/bgMarkMustInput.jpg">  -->
                              </td>
                              <td class="title" style="width:6%" align=center>�Ա�</td>
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
                                <input name="prpLpersonTraceJobName" class="input" description="������ҵ" style="width:100%"
                                value="<bean:write name='personTrace' property='jobName'/>" >
                              </td>
                            </tr>
                            <!--Modify by chenrenda add begin 20050417-->
                            <tr>
                              <td class="title"  style="width:12%">�漰����</td>
                              <td class="input" colspan="7" align=left >�� 
                                <html:select name="personTrace" property="prpLpersonTraceReferKind"  style="width:50%">
                                  <html:options collection="referKindList" property="kindCode" labelProperty="kindName" />  
                                </html:select>                    
                              </td>
                            </tr> 
                            <!--Modify by chenrenda add end 20050417-->
                            
                            <tr>
                              <td class="title" style="width:12%">���˲�λ</td>
                              <td class="input" colspan="7">
                                <input name="prpLpersonTracePartDesc" class="input" description="���˲�λ"
                                value="<bean:write name='personTrace' property='partDesc'/>" >
                              </td>
                            </tr>
                            <tr>
                              <td class="title" style="width:12%">��������</td>
                              <td class="input" colspan="7">
                                <input name="prpLpersonTraceWoundRemark" class="input" description="��������"
                                value="<bean:write name='personTrace' property='woundRemark'/>" >
                              </td>
                            </tr>    
                            <tr>
                              <td class="title" style="width:12%">�Ƿ����о�ҽ</td>
                              <td class="input" colspan="3" >�� 
                                <html:select name="personTrace" property="motionFlag" style="width:50%">
                                  <html:option value="0" >��</html:option>
                                  <html:option value="1" >��</html:option>
                                </html:select>                    
                              </td>
                              <td class="title" align=center>����ҽԺ</td>
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
                              <input type=button name="buttonPersonTraceDelete" class=smallbutton onclick="deleteRow(this,'PersonTrace')" value="-" style="cursor: hand">
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
      




     
