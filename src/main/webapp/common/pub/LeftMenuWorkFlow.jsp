         <%//1��9���̹��� %>

             <tr>
                  <td nowrap>
                    <img name="notopimg" ID="30" style="cursor:'hand';" onmouseup="clickEvent(document.all('30'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" src="/claim/images/treeAdd.gif" width="9" height="9" >
                 </td>
                 <td align=left nowrap onClick="clickEvent(document.all('30'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" style="cursor:'default'" >
                    <img name="notopimgII" ID="30II" src="/claim/images/treeFoderclass2.gif"  align="absmiddle" width="16" height="16">
                    <font ID="30font" color="#000000" >����������</font>
                 </td>
             </tr>
             
             <tr name="notop" ID="30p" STYLE="Display:'none'">
                 <td nowrap></td>
                 <td nowrap>
               <%//��ʼ�ڶ����ļ��� %>
               <%// �����ļ��еڶ���%>
                   <table border=0 cellspacing=0 cellpadding=2 class="menu">
             <%
			   //�Ƿ��й���������ִ��Ȩ��
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_WRITE");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_SYS");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
			 %>                     
                      <tr>
                         <%// �����ļ��еڶ����ǰ����Ǹ��Ӻ�/����ͼ��%>
                         <td nowrap>
                          <img name="notopimg" ID="31" style="cursor:'hand';" onmouseup="clickEvent(document.all('31'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" src="/claim/images/treeAdd.gif" width="9" height="9" >
                         </td>

                         <%// �����ļ��еڶ�����ʾͼ�������%>
                         <td align=left nowrap onClick="clickEvent(document.all('31'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" style="cursor:'default'" >
                           <img name="notopimgII" ID="31II" src="/claim/images/treeFoderclass2.gif" align="absmiddle" width="16" height="16">
                          <font ID="31font" color="#000000">ģ�����</font>
                        </td>
                      </tr>
              <%}%>
                      <tr name="notop" ID="31p" STYLE="Display:'none'">
                         <td nowrap></td>
                         <td nowrap>
                            <%// �����ļ��е�����%>
                            <table border=0 cellspacing=0 cellpadding=0 class="menu">
                              <tr name="notop" ID="310p" STYLE="Display:'none'" >
                                 <td nowrap></td>

                                  <%// �Ƶ�nowrap�ļ��е�����%>
                                  <%// 1��1��1��ģ��ά��%>
                                 <tr >
                                       <td nowrap height="22px"></td>
                                       <td align=left nowrap>
                                          <font ID="3101font" color="#000000" onClick="maingo('3101','sysMenu','ģ��ά��','/claim/swfModelQuery.do','3101')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ģ��ά��
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                          </font>
                                       </td>
                                  </tr>

                                  <%// ����ģ��%>
                                  <tr>
                                     <td nowrap></td>
                                     <td align=left nowrap>
                                        <font ID="3102font" color="#000000" onClick="maingo('3102','sysMenu','����ģ��','/claim/swfModelBeforeEdit.do?editType=ADD','3102')"  style="cursor:'hand'" >
                                           <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ����ģ��
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>  
                                        </font>
                                     </td>
                                  </tr>

                                  <%// 1��1��2������ģ�����%>
                                  <tr>
                                     <td nowrap></td>
                                     <td align=left nowrap>
                                        <font ID="3103font" color="#000000" onClick="maingo('3103','sysMenu','ģ����������','/claim/swfModelUseBeforeEdit.do?editType=ADD','3103')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ģ����������
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                        </font>
                                     </td>
                                  </tr>
                                  <%// 1��1��2��ģ�����ά��%>
                                  <tr>
                                     <td nowrap></td>
                                     <td align=left nowrap>
                                        <font ID="3104font" color="#000000" onClick="maingo('3104','sysMenu','ģ�����ά��','/claim/swfModelUseBeforeEdit.do?editType=EDIT','3104')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ģ�����ά��
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                        </font>
                                     </td>
                                  </tr>
                                  <%// 1��1��3��·������ά��%>
                                  <tr>
                                     <td nowrap></td>
                                     <td align=left nowrap>

                                         <font ID="3105font" color="#000000" onClick="maingo('3105','sysMenu','·������ά��','/claim/swfModelCondStep1Query.do','3105')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,10">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ·������ά��
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                         </font>
                                     </td>
                                  </tr>
                                
                           </table>
                        <%//��ɵ������ļ��� %>
                     </td>
                   </tr>
             <%
			   //�Ƿ��й���������ִ��Ȩ��
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_READ");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_SYS");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
			 %>                      
                      <tr>
                         <%// �����ļ��еڶ����ǰ����Ǹ��Ӻ�/����ͼ��%>
                         <td nowrap>
                          <img name="notopimg" ID="32" style="cursor:'hand';" onmouseup="clickEvent(document.all('32'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" src="/claim/images/treeAdd.gif" width="9" height="9" >
                         </td>

                         <%// �����ļ��еڶ�����ʾͼ�������%>
                         <td align=left nowrap onClick="clickEvent(document.all('32'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" style="cursor:'default'" >
                           <img name="notopimgII" ID="32II" src="/claim/images/treeFoderclass2.gif" align="absmiddle" width="16" height="16">
                          <font ID="32font" color="#000000" >���̹���</font>
                        </td>
                      </tr>
              <%}%>
                      <tr name="notop" ID="32p" STYLE="Display:'none'">
                         <td nowrap></td>
                         <td nowrap>
                            <%// �����ļ��е�����%>
                            <table border=0 cellspacing=0 cellpadding=0 class="menu">
                              <tr name="notop" ID="320p" STYLE="Display:'none'" >
                                 <%// 1��1��1�����̲�ѯ%>
                                 <tr >
                                       <td nowrap height="22px"></td>
                                       <td align=left nowrap>
                                          <font ID="3201font" color="#000000" onClick="maingo('3201','sysMenu','���̲�ѯ','/claim/workflow/flow/WorkFlowFlowBeforeQuery.jsp','3201')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,10">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ���̲�ѯ
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                          </font>
                                       </td>
                                  </tr>

                               </tr>
                           </table>
                        <%//��ɵ������ļ��� %>
                     </td>
                   </tr>
                   
                  </table>
                  
                  </td>
               </tr>
                            