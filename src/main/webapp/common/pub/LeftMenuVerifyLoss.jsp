                <tr>                                                                                                                                                                                                                    
                    <%// 设置文件夹第二层的前面的那个加号/减号图标%>                                                                                                                                                                                                                     
                    <td nowrap>                                                                                                                                                                                                         
                      <img name="notopimg" ID="23" style="cursor:'hand';" onmouseup="clickEvent(document.all('23'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" src="/claim/images/treeAdd.gif" width="9" height="9" >
                    </td>
                    
                    <%// 设置文件夹第二层显示图标和名称%>    
                    <td align=left nowrap onClick="clickEvent(document.all('23'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" style="cursor:'default'" >                                                               
                      <img name="notopimgII" ID="23II" src="/claim/images/treeFoderclass2.gif" align="absmiddle" width="16" height="16">                                                                                                                                      
                      <font ID="23font" color="#000000" >核损任务处理</font>                                                                                                                                                                  
                    </td>                                                                                                                                                                                                                
                  </tr>    
                  <tr name="notop" ID="23p" STYLE="Display:'none'">                                                                                                                                                                       
                     <td nowrap></td>             
                     <td nowrap>                                                                                                                                                                                                         
                        <%// 建立文件夹第三层%>
                        <table border=0 cellspacing=0 cellpadding=0 class="menu">                                                                                                                                                                  
                          <tr name="notop" ID="230p" STYLE="Display:'none'" >                                                                                                                                                                      
                             <td nowrap></td>                                                                                                                                                                                                    
                                                                                                                                                                                                                               
                              <%// 移到nowrap文件夹第三层%>
                              <%// 1。13。1。处理核损登记项%> 
          <%
			   //是否有核损执行权限
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_WRITE");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPLA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
			 %>                              
              <!-- 
                             <tr >                                                                                                                                                                                                                    
                                   <td nowrap height="22px"></td>                                                                                                                                           
                                   <td align=left nowrap> 
                                      <font ID="2300font" color="#000000" onClick="maingo('2300','sysMenu','处理核损登记','/claim/common/verifyLoss/verifyLossBeforeEdit.jsp','2300')"  style="cursor:'hand'" >                                                                                                                                                                                                     
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   处理核损登记
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                      </font>
                                   </td>                                                                                                                                                                                                                
                              </tr>  
                       --> 
                                                                                                                                                                                                                                      
                            <%// 1。13。9。待处理核损任务%>
                                   <tr>
                                       <td nowrap></td>
                                       <td align=left nowrap>
                        
                                           <font ID="2308font" color="#000000" onClick="maingo('2308','sysMenu','待处理核损任务','/claim/wfLogQuery.do?nodeType=verif&status=0','2308')"  style="cursor:'hand'" >
                                           <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   待处理核损任务
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                           </font>
                        
                                        </td>
                                     </tr> 
                                                                                                                                                                                                                                               
                              <%// 1。13。2。正在处理核损任务项%>                                                                                                                                                                                                                             
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                    
                                    <font ID="2301font" color="#000000" onClick="maingo('2301','sysMenu','正在处理核损任务','/claim/wfLogQuery.do?nodeType=verif&status=2','2301')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   正在处理核损任务
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                    </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                                                                                                                                                                                                                                    
                           </tr>             
                                                                                                                                                                                                                                
                             <%// 1。13。3。已完成核损任务项%>                                                                                                                                                                                                                             
 <!--
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="2302font" color="#000000" onClick="maingo('2302','sysMenu','已完成核损任务','/claim/claimStatusQuery.do?status=3&nodeType=verif','2302')"  style="cursor:'hand'" > 
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   已完成核损任务
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr>       
  -->                            
                             <%// 1。13。4。已提交核损任务项%>                                                                                                                                                                                                                             
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="2303font" color="#000000" onClick="maingo('2303','sysMenu','已提交核损任务','/claim/wfLogQuery.do?nodeType=verif&status=4','2303')"  style="cursor:'hand'" > 
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   已提交核损任务
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                              
                              
                              <%// 1。13。5。撤销核损任务%>                                                                                                                                                                                                                             
                              <tr>                                                                                                                                                                                                                    
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                
                                     <font ID="2304font" color="#000000" onClick="maingo('2304','sysMenu','删除核损任务','workAffair/document/unprocessed_docs.jsp','2304')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   删除核损任务
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>                                                                                                                                                                                                     
                                 </td>                                                                                                                                                                                                                
                              </tr> 
                              
                              <%// 1。13。10。注销/拒赔%>
                              <tr>
                                 <td nowrap></td>
                                 <td align=left nowrap>
                                     <font ID="2310font" color="#000000" onClick="maingo('2310','sysMenu',' 申请注销/拒赔','/claim/wfLogQuery.do?status=-1&nodeType=verif','2310')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   申请注销/拒赔
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>
                                 </td>
                              </tr>
               <%}%>   
          <%
			   //是否有立案读权限
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_READ");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPLA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
			 %>                                           
                              <%// 1。13。6。 核损任务状态统计项%>
                              <tr>
                                 <td nowrap></td>
                                 <td align=left nowrap>

                                     <font ID="2305font" color="#000000" onClick="maingo('2305','sysMenu',' 核损任务状态统计','/claim/common/claimstatus/ClaimStatusStatEdit.jsp?nodeType=verif','2305')"  style="cursor:'hand'" >
                                          <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   核损任务状态统计
											   </v:TextBox>
											   <v:Extrusion backdepth='5pt' on='true'/>
										  </v:rect>
                                     </font>
                                 </td>
                              </tr>                                                                                                                                                                                                  
                    
                              <%// 1。13。8。查询核损任务项%>                                                                                                                                                                                                                             
                              <tr>
                                 <td nowrap></td>                                                                                                                                           
                                 <td align=left nowrap>                                                                                                                                                                                              
                                     
                                     <font ID="2307font" color="#000000" onClick="maingo('2307','sysMenu',' 核损查询','/claim/common/verifyLoss/VerifyLossQueryEdit.jsp','2307')"  style="cursor:'hand'" > 
                                         <v:line style="POSITION: absolute" from = "0,0" to = "0,10">
                                             <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
										     <v:stroke dashstyle ="ShortDot"></v:stroke>
										  </v:line>
										  
										  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
											   <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>
											   核损查询
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