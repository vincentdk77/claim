                <tr>                                                                                                                                                                                                                    
                    <%// 设置文件夹第二层的前面的那个加号/减号图标%>                                                                                                                                                                                                                       
                    <td nowrap>                                                                                                                                                                                                         
                      <img name="notopimg" ID="27" style="cursor:'hand';" onmouseup="clickEvent(document.all('27'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" src="/claim/images/treeAdd.gif" width="9" height="9" >
                    </td>
                    
                    <%// 设置文件夹第二层显示图标和名称%>    
                    <td align=left nowrap onClick="clickEvent(document.all('27'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" style="cursor:'default'" >                                                               
                      <img name="notopimgII" ID="27II" src="/claim/images/treeFoderclass2.gif" align="absmiddle" width="16" height="16">                                                                                                                                      
                      <font ID="27font" color="#000000" >预赔案任务处理</font>                                                                                                                                                                  
                    </td>                                                                                                                                                                                                                 
                  </tr>   
                  <tr name="notop" ID="27p" STYLE="Display:'none'">                                                                                                                                                                       
                     <td nowrap></td>             
                     <td nowrap>                                                                                                                                                                                                         
                        <%// 建立文件夹第三层%>
                        <table border=0 cellspacing=0 cellpadding=0 class="menu">   
            <%
			   //是否有特殊赔案写权限 
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_WRITE");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPPA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower) 
			   {         
			 %>                                                                                                                                                                                                 
                          <tr name="notop" ID="270p" STYLE="Display:'none'" >                                                                                                                                                                      
                             <td nowrap></td>                                                                                                                                                                                                     
                                                                                                                                                                                                                               
                              <%// 移到nowrap文件夹第三层%>
                              <%// 1。6。1。处理特殊赔案登记项%> 
                             <tr >                                                                                                                                                                                                                    
                                   <td nowrap height="22px"></td>                                                                                                                                           
                                   <td align=left nowrap>                                                                                                                                                                                              
                                      
                                      <font ID="2700font" color="#000000" onClick="maingo('2700','sysMenu','处理预赔案登记','/claim/common/specialCase/SpecialCaseBeforeQueryEdit.jsp','2700')"  style="cursor:'hand'" >                                                                                                                                                                                                     
                                        <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                          <v:stroke dashstyle ="ShortDot"></v:stroke>
                                          </v:line>     
                                          <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
                                            <v:stroke dashstyle ="ShortDot"></v:stroke>
                                          </v:line>
                                             
                                          <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
                                            <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
                                              处理预赔案登记  
                                            </v:TextBox>
                                          <v:Extrusion backdepth='5pt' on='true'/>
                                        </v:rect>
    				                          </font>
                                   </td>                                                                                                                                                                                                                
                              </tr>                                                                                                                                                                                                 
                              <%// 1。6。9。待处理特殊赔案任务%>        
                              <!--                                                                                                                                                                                                                     
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                    
                                    <font ID="2708font" color="#000000" onClick="maingo('2708','sysMenu','待处理特殊赔案任务','/claim/wfLogQuery.do?nodeType=prepa&status=0','2708')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   待处理特殊赔案任务
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                    </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                                                                                                                                                                                                                                    
                           </tr>                                                                                                                                                                                                                     
                                     -->                                                                                                                                                                                             
                              <%// 1。6。2。正在处理特殊赔案任务项%>                                                                                                                                                                                                                             
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                    
                                    <font ID="2701font" color="#000000" onClick="maingo('2701','sysMenu','正在处理预赔案任务','/claim/wfLogQuery.do?nodeType=speci&status=2','2701')"  style="cursor:'hand'" >
                                           <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   正在处理预赔案任务
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                    </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                                                                                                                                                                                                                                    
                           </tr>  
                           
                        <!--              
                                                                                                                                                                                                                                
                             <%// 1。6。3。已完成特殊赔案任务项%>                                                                                                                                                                                                                             
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="2702font" color="#000000" onClick="maingo('2702','sysMenu','已完成特殊赔案任务','/claim/claimStatusQuery.do?status=3&nodeType=prepa','2702')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   已完成特殊赔案任务
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr>       
                            -->  
                             <%// 1。6。4。已提交特殊赔案任务项%>                                                                                                                                                                                                                             
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="2703font" color="#000000" onClick="maingo('2703','sysMenu','已提交预赔案任务','/claim/wfLogQuery.do?nodeType=speci&status=4','2703')"  style="cursor:'hand'" > 
                                       <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   已提交预赔案任务
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                                                                
                              <%// 1。6。5。撤销特殊赔案任务%>  
                              <!--                                                                                                                                                                                                                           
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                
                                     <font ID="2704font" color="#000000" onClick="maingo('2704','sysMenu','撤销特殊赔案任务','workAffair/document/unprocessed_docs.jsp','2704')"  style="cursor:'hand'" > 
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   撤销特殊赔案任务
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
             <%}%>     
                     -->
             <%
			   //是否有特殊赔案读权限
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_CHECK");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPPA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
			 %>    
                                                           
                              <%// 1。6。6。特殊赔案任务复核%>     
                              <!--                                                                                                                                                                                                                        
                              <tr>
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                    
                                     <font ID="2705font" color="#000000" onClick="maingo('2705','sysMenu','特殊赔案任务复核','/claim/common/specialCase/specialCaseApproveQueryEdit.jsp','2705')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   特殊赔案任务复核
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr>                                                                                                                                                                                                                
                                      -->
                            <%// 1。6。7。手工提交核赔项%>  
                            <!--                                                                                                                                                                                                                          
                              <tr>
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="2706font" color="#000000" onClick="maingo('2706','sysMenu',' 手工提交核赔','workAffair/document/unprocessed_docs.jsp','2706')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   手工提交核赔
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                              --> 
            <%}%>                  
            <%
			   //是否有特殊赔案读权限
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_READ");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPPA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
			 %>   
                              <%// 1。7。9。 特殊赔案任务状态统计项%>
                              <tr>
                                 <td nowrap></td>
                                 <td align=left nowrap>
                      
                                     <font ID="2708font" color="#000000" onClick="maingo('2708','sysMenu',' 预赔案任务状态统计','/claim/common/claimstatus/ClaimStatusStatEdit.jsp?nodeType=speci','2708')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   预赔案任务状态统计
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>
                                 </td>
                              </tr>   			                                    
                              <%// 1。6。8。查询特殊赔案任务项%>                                                                                                                                                                                                                             
                              <tr>
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="2707font" color="#000000" onClick="maingo('2707','sysMenu',' 预赔案查询','/claim/common/specialCase/SpecialCaseQueryEdit.jsp','2707')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   预赔案查询
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr>         
                              <%// 1。6。8。增加特殊赔案核赔通过功能（只用于测试）%>                                                                                                                                                                                                                             
                              <tr>
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="2708font" color="#000000" onClick="maingo('2708','sysMenu',' 预赔案核赔通过功能（只用于测试）','/claim/common/specialCase/SpecialCaseApproveTest.jsp','2708')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											     预赔案核赔通过功能（只用于测试）
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect> 
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr>  
                              
                                      <%// 1。6。8。增加预赔核赔通过功能（只用于测试）%>                                                                                                                                                                                                                             
                              <tr>
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="1608font" color="#000000" onClick="maingo('1608','sysMenu',' 预赔核赔通过功能（只用于测试）','/claim/common/prepay/PrepayApproveTest.jsp','1608')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   预赔核赔通过功能（只用于测试）
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr>  
                                    
                  <%}%>                                                                                                                                                                                                         
                       </table>  
                  <%//完成第三级文件夹 %>                                                                                                                                                                                                                  
                 </td>                                                                                                                                                                                                           
               </tr>       
               
                  