                <tr>                                                                                                                                                                                                                    
                    <%// �����ļ��еڶ����ǰ����Ǹ��Ӻ�/����ͼ��%>                                                                                                                                                                                                                       
                    <td nowrap>                                                                                                                                                                                                         
                      <img name="notopimg" ID="27" style="cursor:'hand';" onmouseup="clickEvent(document.all('27'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" src="/claim/images/treeAdd.gif" width="9" height="9" >
                    </td>
                    
                    <%// �����ļ��еڶ�����ʾͼ�������%>    
                    <td align=left nowrap onClick="clickEvent(document.all('27'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" style="cursor:'default'" >                                                               
                      <img name="notopimgII" ID="27II" src="/claim/images/treeFoderclass2.gif" align="absmiddle" width="16" height="16">                                                                                                                                      
                      <font ID="27font" color="#000000" >Ԥ�ⰸ������</font>                                                                                                                                                                  
                    </td>                                                                                                                                                                                                                 
                  </tr>   
                  <tr name="notop" ID="27p" STYLE="Display:'none'">                                                                                                                                                                       
                     <td nowrap></td>             
                     <td nowrap>                                                                                                                                                                                                         
                        <%// �����ļ��е�����%>
                        <table border=0 cellspacing=0 cellpadding=0 class="menu">   
            <%
			   //�Ƿ��������ⰸдȨ�� 
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_WRITE");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPPA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower) 
			   {         
			 %>                                                                                                                                                                                                 
                          <tr name="notop" ID="270p" STYLE="Display:'none'" >                                                                                                                                                                      
                             <td nowrap></td>                                                                                                                                                                                                     
                                                                                                                                                                                                                               
                              <%// �Ƶ�nowrap�ļ��е�����%>
                              <%// 1��6��1�����������ⰸ�Ǽ���%> 
                             <tr >                                                                                                                                                                                                                    
                                   <td nowrap height="22px"></td>                                                                                                                                           
                                   <td align=left nowrap>                                                                                                                                                                                              
                                      
                                      <font ID="2700font" color="#000000" onClick="maingo('2700','sysMenu','����Ԥ�ⰸ�Ǽ�','/claim/common/specialCase/SpecialCaseBeforeQueryEdit.jsp','2700')"  style="cursor:'hand'" >                                                                                                                                                                                                     
                                        <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                          <v:stroke dashstyle ="ShortDot"></v:stroke>
                                          </v:line>     
                                          <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
                                            <v:stroke dashstyle ="ShortDot"></v:stroke>
                                          </v:line>
                                             
                                          <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
                                            <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
                                              ����Ԥ�ⰸ�Ǽ�  
                                            </v:TextBox>
                                          <v:Extrusion backdepth='5pt' on='true'/>
                                        </v:rect>
    				                          </font>
                                   </td>                                                                                                                                                                                                                
                              </tr>                                                                                                                                                                                                 
                              <%// 1��6��9�������������ⰸ����%>        
                              <!--                                                                                                                                                                                                                     
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                    
                                    <font ID="2708font" color="#000000" onClick="maingo('2708','sysMenu','�����������ⰸ����','/claim/wfLogQuery.do?nodeType=prepa&status=0','2708')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   �����������ⰸ����
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                    </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                                                                                                                                                                                                                                    
                           </tr>                                                                                                                                                                                                                     
                                     -->                                                                                                                                                                                             
                              <%// 1��6��2�����ڴ��������ⰸ������%>                                                                                                                                                                                                                             
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                    
                                    <font ID="2701font" color="#000000" onClick="maingo('2701','sysMenu','���ڴ���Ԥ�ⰸ����','/claim/wfLogQuery.do?nodeType=speci&status=2','2701')"  style="cursor:'hand'" >
                                           <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ���ڴ���Ԥ�ⰸ����
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                    </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                                                                                                                                                                                                                                    
                           </tr>  
                           
                        <!--              
                                                                                                                                                                                                                                
                             <%// 1��6��3������������ⰸ������%>                                                                                                                                                                                                                             
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="2702font" color="#000000" onClick="maingo('2702','sysMenu','����������ⰸ����','/claim/claimStatusQuery.do?status=3&nodeType=prepa','2702')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ����������ⰸ����
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr>       
                            -->  
                             <%// 1��6��4�����ύ�����ⰸ������%>                                                                                                                                                                                                                             
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="2703font" color="#000000" onClick="maingo('2703','sysMenu','���ύԤ�ⰸ����','/claim/wfLogQuery.do?nodeType=speci&status=4','2703')"  style="cursor:'hand'" > 
                                       <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ���ύԤ�ⰸ����
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                                                                
                              <%// 1��6��5�����������ⰸ����%>  
                              <!--                                                                                                                                                                                                                           
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                
                                     <font ID="2704font" color="#000000" onClick="maingo('2704','sysMenu','���������ⰸ����','workAffair/document/unprocessed_docs.jsp','2704')"  style="cursor:'hand'" > 
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ���������ⰸ����
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
             <%}%>     
                     -->
             <%
			   //�Ƿ��������ⰸ��Ȩ��
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_CHECK");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPPA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
			 %>    
                                                           
                              <%// 1��6��6�������ⰸ���񸴺�%>     
                              <!--                                                                                                                                                                                                                        
                              <tr>
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                    
                                     <font ID="2705font" color="#000000" onClick="maingo('2705','sysMenu','�����ⰸ���񸴺�','/claim/common/specialCase/specialCaseApproveQueryEdit.jsp','2705')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   �����ⰸ���񸴺�
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr>                                                                                                                                                                                                                
                                      -->
                            <%// 1��6��7���ֹ��ύ������%>  
                            <!--                                                                                                                                                                                                                          
                              <tr>
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="2706font" color="#000000" onClick="maingo('2706','sysMenu',' �ֹ��ύ����','workAffair/document/unprocessed_docs.jsp','2706')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   �ֹ��ύ����
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                              --> 
            <%}%>                  
            <%
			   //�Ƿ��������ⰸ��Ȩ��
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_READ");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPPA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
			 %>   
                              <%// 1��7��9�� �����ⰸ����״̬ͳ����%>
                              <tr>
                                 <td nowrap></td>
                                 <td align=left nowrap>
                      
                                     <font ID="2708font" color="#000000" onClick="maingo('2708','sysMenu',' Ԥ�ⰸ����״̬ͳ��','/claim/common/claimstatus/ClaimStatusStatEdit.jsp?nodeType=speci','2708')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   Ԥ�ⰸ����״̬ͳ��
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>
                                 </td>
                              </tr>   			                                    
                              <%// 1��6��8����ѯ�����ⰸ������%>                                                                                                                                                                                                                             
                              <tr>
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="2707font" color="#000000" onClick="maingo('2707','sysMenu',' Ԥ�ⰸ��ѯ','/claim/common/specialCase/SpecialCaseQueryEdit.jsp','2707')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   Ԥ�ⰸ��ѯ
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr>         
                              <%// 1��6��8�����������ⰸ����ͨ�����ܣ�ֻ���ڲ��ԣ�%>                                                                                                                                                                                                                             
                              <tr>
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="2708font" color="#000000" onClick="maingo('2708','sysMenu',' Ԥ�ⰸ����ͨ�����ܣ�ֻ���ڲ��ԣ�','/claim/common/specialCase/SpecialCaseApproveTest.jsp','2708')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											     Ԥ�ⰸ����ͨ�����ܣ�ֻ���ڲ��ԣ�
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect> 
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr>  
                              
                                      <%// 1��6��8������Ԥ�����ͨ�����ܣ�ֻ���ڲ��ԣ�%>                                                                                                                                                                                                                             
                              <tr>
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="1608font" color="#000000" onClick="maingo('1608','sysMenu',' Ԥ�����ͨ�����ܣ�ֻ���ڲ��ԣ�','/claim/common/prepay/PrepayApproveTest.jsp','1608')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   Ԥ�����ͨ�����ܣ�ֻ���ڲ��ԣ�
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr>  
                                    
                  <%}%>                                                                                                                                                                                                         
                       </table>  
                  <%//��ɵ������ļ��� %>                                                                                                                                                                                                                  
                 </td>                                                                                                                                                                                                           
               </tr>       
               
                  