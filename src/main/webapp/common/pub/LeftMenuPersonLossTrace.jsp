                <tr>                                                                                                                                                                                                                    
                    <%// �����ļ��еڶ����ǰ����Ǹ��Ӻ�/����ͼ��%>                                                                                                                                                                                                                    
                    <td nowrap>                                                                                                                                                                                                         
                      <img name="notopimg" ID="24" style="cursor:'hand';" onmouseup="clickEvent(document.all('24'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" src="/claim/images/treeAdd.gif" width="9" height="9" >
                    </td>
                    
                    <%// �����ļ��еڶ�����ʾͼ�������%>   
                    <td align=left nowrap onClick="clickEvent(document.all('24'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" style="cursor:'default'" >                                                               
                      <img name="notopimgII" ID="24II" src="/claim/images/treeFoderclass2.gif" align="absmiddle" width="16" height="16">                                                                                                                                      
                      <font ID="24font" color="#000000" >���˸���������</font>                                                                                                                                                                  
                    </td>                                                                                                                                                                                                                
                  </tr>       
                  
                  <tr name="notop" ID="24p" STYLE="Display:'none'">                                                                                                                                                                       
                     <td nowrap></td>             
                     <td nowrap>                                                                                                                                                                                                         
                        <%// �����ļ��е�����%>
                        <table border=0 cellspacing=0 cellpadding=0 class="menu">                                                                                                                                                                  
                          <tr name="notop" ID="240p" STYLE="Display:'none'" >                                                                                                                                                                      
                             <td nowrap></td>                                                                                                                                                                                                    
                                                                                                                                                                                                                               
                              <%// �Ƶ�nowrap�ļ��е�����%>
                              <%// 1��12��1���������˸��ٵǼ���%>
                          <%
                            //�Ƿ������˸��ٹ���ִ��Ȩ��
                            checkCode     = AppConfig.get("sysconst.CHECKCODE_WRITE");
                            taskCode      = AppConfig.get("sysconst.TASKCODE_LPLA");
                            checkPower    = false;
                            checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
                            if(checkPower) {             
                          %>  
                          
                          <%/*         
                             <tr>                                                                                                                                                                                                                      
                                   <td nowrap height="22px"></td>                                                                                                                                           
                                   <td align=left nowrap>                                                                                                                                                                                               
                                      
                                      <font ID="2400font" color="#000000" onClick="maingo('2400','sysMenu','�������˸��ٵǼ�','/claim/common/certainLoss/certainLossBeforeEdit.jsp','2400')"  style="cursor:'hand'" >                                                                                                                                                                                                     
                                           <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke> 
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   �������˸��ٵǼ�
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                      </font>
                                   </td>                                                                                                                                                                                                                
                              </tr>  
                              */%> 
                              <%// 1��12��9�����������˸�������%>
                                   <tr>
                                       <td nowrap></td>
                                       <td align=left nowrap>
                        
                                           <font ID="2408font" color="#000000" onClick="maingo('2408','sysMenu','���������˸�������','/claim/wfLogQuery.do?nodeType=wound&status=0','2408')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ���������˸�������
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                           </font>
                        
                                        </td>
                                     </tr>                                                                                                                                                                                                                  
                                                                                                                                                                                                                                  
                              <%// 1��12��2�����ڴ������˸���������%>                                                                                                                                                                                                                            
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap> 
                                    <font ID="2401font" color="#000000" onClick="maingo('2401','sysMenu','���ڴ������˸�������','/claim/wfLogQuery.do?nodeType=wound&status=2','2401')"  style="cursor:'hand'" >
                                      <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                        <v:stroke dashstyle ="ShortDot"></v:stroke>
                                      </v:line>
                                      <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
                                        <v:stroke dashstyle ="ShortDot"></v:stroke>  
                                      </v:line>
                                      <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
                                        <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
                                          ���ڴ������˸�������
                                        </v:TextBox>
                                        <v:Extrusion backdepth='5pt' on='true'/>
                                      </v:rect>  
                                    </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                 
                              </tr>                                                                                                                                                                                                   
                           </tr>             
                                                                                                                                                                                                                                
                             <%// 1��12��3�����ύ���˸���������%>                                                                                                                                                                                                                            
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="2402font" color="#000000" onClick="maingo('2402','sysMenu','���ύ���˸�������','/claim/wfLogQuery.do?nodeType=wound&status=4','2402')"  style="cursor:'hand'" > 
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ���ύ���˸�������
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr>       
          <!-- 
                                      
                             <%// 1��12��4�������˻�������%>                                                                                                                                                                                                                            
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                      
                                     <font ID="2403font" color="#000000" onClick="maingo('2403','sysMenu','�������������','/claim/claimStatusQuery.do?status=5&nodeType=certa','2403')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   �������������
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                              
    -->                           
                              <%// 1��12��5���������˸�������%>                                                                                                                                                                                                                            
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                
                                     <font ID="2404font" color="#000000" onClick="maingo('2404','sysMenu','ɾ�����˸�������','workAffair/document/unprocessed_docs.jsp','2404')"  style="cursor:'hand'" > 
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ɾ�����˸�������
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                              <%// 1��12��10��ע��/����%>
                              <tr>
                                 <td nowrap></td>
                                 <td align=left nowrap>
                                     <font ID="2410font" color="#000000" onClick="maingo('2410','sysMenu',' ����ע��/����','/claim/wfLogQuery.do?status=-1&nodeType=wound','2410')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ����ע��/����
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>
                                 </td>
                              </tr>
          
                 <%}%>
            <%
			   //�Ƿ������˸��ٲ�ѯȨ��
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_READ");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPLA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
			 %>  
                              <%// 1��12��6�����˸�������״̬ͳ��%>
                              <tr>
                                 <td nowrap></td>
                                 <td align=left nowrap>
                                     <font ID="2405font" color="#000000" onClick="maingo('2405','sysMenu',' ���˸�������״̬ͳ��','/claim/common/claimstatus/ClaimStatusStatEdit.jsp?nodeType=certa','2405')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ���˸�������״̬ͳ��
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>
                                 </td>
                              </tr>                                                     
                              <%// 1��12��8����ѯ���˸���������%>                                                                                                                                                                                                                            
                              <tr>
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="2407font" color="#000000" onClick="maingo('2407','sysMenu',' ���˸��ٲ�ѯ','/claim/common/certainLoss/CertainLossQueryEdit.jsp','2407')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,10">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ���˸��ٲ�ѯ
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                   <%}%>   
             <%
			   //�Ƿ������˸���ִ��Ȩ��
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_WRITE");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPLA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
			 %>                                                     
                              <%// 1��12��9�����˸���ͼƬ�ϴ�����%>                                                                                                                                                                                                                            
                              <tr>
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="2408font" color="#000000" onClick="maingo('2408','sysMenu',' ���˸���ͼƬ�ϴ�����','/claim/common/certainLoss/CertainLossCertifyQueryEdit.jsp','2408')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,10">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ���˸���ͼƬ�ϴ�����
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
               
               
               
               
               
               
               
               
               
               
               
               
               <tr>                                                                                                                                                                                                                    
                    <%// �����ļ��еڶ����ǰ����Ǹ��Ӻ�/����ͼ��%>                                                                                                                                                                                                                    
                    <td nowrap>                                                                                                                                                                                                         
                      <img name="notopimg" ID="25" style="cursor:'hand';" onmouseup="clickEvent(document.all('25'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" src="/claim/images/treeAdd.gif" width="9" height="9" >
                    </td>
                    
                    <%// �����ļ��еڶ�����ʾͼ�������%>   
                    <td align=left nowrap onClick="clickEvent(document.all('25'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" style="cursor:'default'" >                                                               
                      <img name="notopimgII" ID="25II" src="/claim/images/treeFoderclass2.gif" align="absmiddle" width="16" height="16">                                                                                                                                      
                      <font ID="25font" color="#000000" >���˺���������</font>                                                                                                                                                                  
                    </td>                                                                                                                                                                                                                
                  </tr>    
                  
                  <tr name="notop" ID="25p" STYLE="Display:'none'">                                                                                                                                                                       
                     <td nowrap></td>             
                     <td nowrap>                                                                                                                                                                                                         
                        <%// �����ļ��е�����%>
                        <table border=0 cellspacing=0 cellpadding=0 class="menu">                                                                                                                                                                  
                          <tr name="notop" ID="250p" STYLE="Display:'none'" >                                                                                                                                                                      
                             <td nowrap></td>                                                                                                                                                                                                    
                                                                                                                                                                                                                               
                              <%// �Ƶ�nowrap�ļ��е�����%>
                              <%// 1��12��1���������˺���Ǽ���%>
             <%
			   //�Ƿ������˺������ִ��Ȩ��
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_WRITE");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPLA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
			 %>           

                             <tr >                                                                                                                                                                                                                    
                                   <td nowrap height="22px"></td>                                                                                                                                           
                                   <td align=left nowrap>                                                                                                                                                                                              
                                      
                                      <font ID="2500font" color="#000000" onClick="maingo('2500','sysMenu','�������˺���Ǽ�','/claim/common/certainLoss/certainLossBeforeEdit.jsp','2500')"  style="cursor:'hand'" >                                                                                                                                                                                                     
                                           <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke> 
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   �������˺���Ǽ�
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                      </font>
                                   </td>                                                                                                                                                                                                                
                              </tr>  
                               
                              <%// 1��12��9�����������˺�������%>
                                   <tr>
                                       <td nowrap></td>
                                       <td align=left nowrap>
                        
                                           <font ID="2508font" color="#000000" onClick="maingo('2508','sysMenu','���������˺�������','/claim/wfLogQuery.do?nodeType=veriw&status=0','2508')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ���������˺�������
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                           </font>
                        
                                        </td>
                                     </tr>                                                                                                                                                                                                                  
                                                                                                                                                                                                                                  
                              <%// 1��12��2�����ڴ������˺���������%>                                                                                                                                                                                                                            
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap> 
                                    <font ID="2501font" color="#000000" onClick="maingo('2501','sysMenu','���ڴ������˺�������','/claim/wfLogQuery.do?nodeType=veriw&status=2','2501')"  style="cursor:'hand'" >
                                      <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                        <v:stroke dashstyle ="ShortDot"></v:stroke> 
                                      </v:line>
                                      <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
                                        <v:stroke dashstyle ="ShortDot"></v:stroke>  
                                      </v:line>
                                      <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
                                        <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
                                          ���ڴ������˺�������
                                        </v:TextBox>
                                        <v:Extrusion backdepth='5pt' on='true'/>
                                      </v:rect>  
                                    </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                 
                              </tr>                                                                                                                                                                                                   
                           </tr>             
                                                                                                                                                                                                                                
                             <%// 1��12��3�����ύ���˺���������%>                                                                                                                                                                                                                            
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="2502font" color="#000000" onClick="maingo('2502','sysMenu','���ύ���˺�������','/claim/wfLogQuery.do?nodeType=veriw&status=4','2502')"  style="cursor:'hand'" > 
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ���ύ���˺�������
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr>       
          <!-- 
                                      
                             <%// 1��12��4�������˻�������%>                                                                                                                                                                                                                            
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                      
                                     <font ID="2503font" color="#000000" onClick="maingo('2503','sysMenu','�������������','/claim/claimStatusQuery.do?status=5&nodeType=certa','2503')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   �������������
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                              
    -->                           
                              <%// 1��12��5���������˺�������%>                                                                                                                                                                                                                            
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                
                                     <font ID="2504font" color="#000000" onClick="maingo('2504','sysMenu','ɾ�����˺�������','workAffair/document/unprocessed_docs.jsp','2504')"  style="cursor:'hand'" > 
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ɾ�����˺�������
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                              
                               <%// 1��12��11��ע��/����%>
                              <tr>
                                 <td nowrap></td>
                                 <td align=left nowrap>
                                     <font ID="2510font" color="#000000" onClick="maingo('2510','sysMenu',' ����ע��/����','/claim/wfLogQuery.do?status=-1&nodeType=certa','2510')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ����ע��/����
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>
                                 </td>
                              </tr>
          
                 <%}%>
            <%
			   //�Ƿ������˺����ѯȨ��
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_READ");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPLA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
			 %>  
                              <%// 1��12��6�����˺�������״̬ͳ��%>
                              
                              <tr>
                                 <td nowrap></td>
                                 <td align=left nowrap>
                                     <font ID="2505font" color="#000000" onClick="maingo('2505','sysMenu',' ���˺�������״̬ͳ��','/claim/common/claimstatus/ClaimStatusStatEdit.jsp?nodeType=certa','2505')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ���˺�������״̬ͳ��
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>
                                 </td>
                              </tr>                                                     
                              <%// 1��12��8����ѯ���˺���������%>                                                                                                                                                                                                                            
                              <tr>
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="2507font" color="#000000" onClick="maingo('2507','sysMenu',' ���˺����ѯ','/claim/common/certainLoss/CertainLossQueryEdit.jsp','2507')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,10">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										   
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ���˺����ѯ
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect> 
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                   <%}%>   
             <%
			   //�Ƿ������˺���ִ��Ȩ��
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_WRITE");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPLA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {          
			 %>                                                     
                              <%// 1��12��9�����˺���ͼƬ�ϴ�����%>                                                                                                                                                                                                                            
                              <tr>
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="2509font" color="#000000" onClick="maingo('2509','sysMenu',' ���˺���ͼƬ�ϴ�����','/claim/common/certainLoss/CertainLossCertifyQueryEdit.jsp','2509')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,10">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   ���˺���ͼƬ�ϴ�����
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