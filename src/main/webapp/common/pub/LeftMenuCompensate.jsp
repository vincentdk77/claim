
                    <%//1.7 实赔任务处理 %>
                   <tr>                                                                                                                                                                                                                    
                    <%// 设置文件夹第二层的前面的那个加号/减号图标%>                                                                                                                                                                                                                     
                    <td nowrap>                                                                                                                                                                                                         
                      <img name="notopimg" ID="17" style="cursor:'hand';" onmouseup="clickEvent(document.all('17'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" src="/claim/images/treeAdd.gif" width="9" height="9" >
                    </td>
                    
                    <%// 设置文件夹第二层显示图标和名称%>    
                    <td align=left nowrap onClick="clickEvent(document.all('17'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" style="cursor:'default'" >                                                               
                      <img name="notopimgII" ID="17II" src="/claim/images/treeFoderclass2.gif" align="absmiddle" width="16" height="16">                                                                                                                                      
                      <font ID="17font" color="#000000" >实赔任务处理</font>                                                                                                                                                                  
                    </td>                                                                                                                                                                                                                
                  </tr>   
                  <tr name="notop" ID="17p" STYLE="Display:'none'">                                                                                                                                                                       
                     <td nowrap></td>             
                     <td nowrap>                                                                                                                                                                                                         
                        <%// 建立文件夹第三层%>
                        <table border=0 cellspacing=0 cellpadding=0 class="menu">                                                                                                                                                                  
                          <tr name="notop" ID="170p" STYLE="Display:'none'" >                                                                                                                                                                      
                             <td nowrap></td>                                                                                                                                                                                                    
                                                                                                                                                                                                                               
                              <%// 移到nowrap文件夹第三层%>
                              <%// 1。7。1。处理实赔登记项%> 
                              <!--
                             <tr >                                                                                                                                                                                                                    
                                   <td nowrap height="22px"></td>                                                                                                                                           
                                   <td align=left nowrap>                                                                                                                                                                                              
                                      
                                      <font ID="1700font" color="#000000" onClick="maingo('1700','sysMenu','处理实赔登记','/claim/common/compensate/compensateBeforeEdit.jsp','1700')"  style="cursor:'hand'" >                                                                                                                                                                                                     
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											     <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>处理实赔登记</v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
    				                  </font>
                                   </td>                                                                                                                                                                                                                
                              </tr>                                                                                                                                                                                                                  
                               -->
            <%
			   //是否有实赔执行权限
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_WRITE");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPPA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
			 %>                                                                                                                                                                                       
                              <%// 1。7。9。待处理实赔任务%>                                                                                                                                                                                                                             
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                    <font ID="1701font" color="#000000" onClick="maingo('1701','sysMenu','待处理实赔任务','/claim/wfLogQuery.do?nodeType=compe&status=0','1701')"  style="cursor:'hand'" >
                                           <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											     <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>待处理实赔任务</v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                    </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                                                                                                                                                                                                        
                              <%// 1。7。2。正在处理实赔任务项%>                                                                                                                                                                                                                             
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                    <font ID="1702font" color="#000000" onClick="maingo('1702','sysMenu','正在处理实赔任务','/claim/wfLogQuery.do?nodeType=compp&status=2','1702')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>正在处理实赔任务</v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                    </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
            <!--                  
                              <%// 1。7。3。已完成实赔任务项%>                                                                                                                                                                                                                             
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     <font ID="1702font" color="#000000" onClick="maingo('1702','sysMenu','已完成实赔任务','/claim/claimStatusQuery.do?status=3&nodeType=compe','1702')"  style="cursor:'hand'" > 
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   已完成实赔任务
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr>       
                -->              
                             <%// 1。7。4。已提交实赔任务项%>                                                                                                                                                                                                                             
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                      <font ID="1703font" color="#000000" onClick="maingo('1703','sysMenu','已提交实赔任务','/claim/wfLogQuery.do?nodeType=compp&status=4','1703')"  style="cursor:'hand'" > 
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   已提交实赔任务
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                              
                              
                              <%// 1。7。5。删除实赔任务%>                                                                                                                                                                                                                             
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     <font ID="1704font" color="#000000" onClick="maingo('1704','sysMenu',' 删除实赔任务','workAffair/document/unprocessed_docs.jsp','1704')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   删除实赔任务
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                <%}%>    
            <%
			   //是否有实赔读权限
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_READ");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPPA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
			 %>                          
                              <%// 1。7。9。 实赔任务状态统计项%>
                              <tr>
                                 <td nowrap></td>
                                 <td align=left nowrap>
                      
                                     <font ID="1705font" color="#000000" onClick="maingo('1705','sysMenu',' 实赔任务状态统计','/claim/common/claimstatus/ClaimStatusStatEdit.jsp?nodeType=compe','1705')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   实赔任务状态统计
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>
                                 </td> 
                              </tr>                   
             <%}%>   
             <%
			   //是否有实赔读权限
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_CHECK");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPPA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
			 %>                  
                              <%// 1。7。6。实赔任务复核%>                                                                                                                                                                                                                             
                              <tr>
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     <font ID="1706font" color="#000000" onClick="maingo('1706','sysMenu','实赔任务复核','/claim/common/compensate/CompensateApproveQueryEdit.jsp','1706')"  style="cursor:'hand'" > 
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   实赔任务复核
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr>                                                                                                                                                                                                                
                                      
                            <%// 1。7。7。手工提交核赔任务项%>                                                                                                                                                                                                                             
                              <tr>
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     <font ID="1707font" color="#000000" onClick="maingo('1707','sysMenu',' 手工提交核赔','workAffair/document/unprocessed_docs.jsp','1707')"  style="cursor:'hand'" > 
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
            <%}%> 
            <%
			   //是否有实赔读权限
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_READ");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPPA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
			 %>                   
                              <%// 1。7。8。查询实赔任务项%>                                                                                                                                                                                                                             
                              <tr>
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     <font ID="1708font" color="#000000" onClick="maingo('1708','sysMenu',' 实赔查询','/claim/common/compensate/CompensateQueryEdit.jsp','1708')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   实赔查询
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr>      
                                                                                                                                                                                                                                   
                           </tr>   
                              <%// 1。7。9。实赔核赔通过功能（只用于测试）%>                                                                                                                                                                                                                             
                              <tr>
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     <font ID="1709font" color="#000000" onClick="maingo('1709','sysMenu',' 实赔核赔通过功能（只用于测试）','/claim/common/compensate/CompensateApproveTest.jsp','1709')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   实赔核赔通过功能（只用于测试）
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr>      
                                                                                                                                                                                                                                   
                           </tr>                 
                <%}%>                                                                                                                                                                                                                 
                       </table>  
                  <%//完成第三级文件夹 %>                                                                                                                                                                                                                  
                 </td>
                                                                                                                                                                                                                                
               </tr>   