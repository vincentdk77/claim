 <%//��ʼ�ڶ����ļ��� %>

 <%//1��2���������� %>
<tr>
     <td nowrap>
       <img name="notopimg" ID="11" style="cursor:'hand';" onmouseup="clickEvent(document.all('11'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" src="/claim/images/treeAdd.gif" width="9" height="9" >
    </td>
    <td align=left nowrap onClick="clickEvent(document.all('11'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" style="cursor:'default'" >
       <img name="notopimgII" ID="11II" src="/claim/images/treeFoderclass2.gif"  align="absmiddle" width="16" height="16">
       <font ID="11font" color="#000000" >����������</font>
    </td>
</tr>
<tr name="notop" ID="11p" STYLE="Display:'none'">
    <td nowrap></td>
    <td nowrap>
    <%//�����������ļ��� %>
       <table border=0 cellspacing=0 cellpadding=0 class="menu">
      <%// 1��2��1�����������Ǽ�%>
           <!--
           <tr>
               <td nowrap></td> 
               <td align=left nowrap>

                  <font ID="110font" color="#000000" onClick="maingo('110','sysMenu',' ���������Ǽ�','/claim/common/claim/claimBeforeEdit.jsp','110')"  style="cursor:'hand'" >
			       <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
			          <v:stroke dashstyle ="ShortDot"></v:stroke>
			       </v:line>
			       <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
			          <v:stroke dashstyle ="ShortDot"></v:stroke>
			       </v:line>
			       
			       <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
				       <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>���������Ǽ�</v:TextBox>
					   <v:Extrusion backdepth='5pt' on='true'/>
			       </v:rect>
                  </font>
               </td>
          </tr>
          -->
    <%// 1��2��9����������������%>
          <%
			   //�Ƿ�������ִ��Ȩ��
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_WRITE");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPLA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
			 %>     
           <tr>
               <td nowrap></td>
               <td align=left nowrap>

                   <font ID="110font" color="#000000" onClick="maingo('110','sysMenu','��������������','/claim/wfLogQuery.do?nodeType=claim&status=0','110')"  style="cursor:'hand'" >
                   <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
			          <v:stroke dashstyle ="ShortDot"></v:stroke>
			       </v:line>
			       <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
			          <v:stroke dashstyle ="ShortDot"></v:stroke>
			       </v:line>
			       
			       <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
				       <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>��������������</v:TextBox>
					   <v:Extrusion backdepth='5pt' on='true'/>
			       </v:rect>
                   </font>

                </td>
             </tr> 
   <%// 1��2��2�����ڴ�����������%>
           <tr>
              <td nowrap></td>
              <td align=left nowrap>
                  <font ID="111font" color="#000000" onClick="maingo('111','sysMenu','���ڴ�����������','/claim/wfLogQuery.do?nodeType=claim&status=2','111')"  style="cursor:'hand'" >
                   <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
			          <v:stroke dashstyle ="ShortDot"></v:stroke>
			       </v:line>
			       <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
			          <v:stroke dashstyle ="ShortDot"></v:stroke>
			       </v:line>
			       
			       <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
				       <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>���ڴ�����������</v:TextBox>
					   <v:Extrusion backdepth='5pt' on='true'/>
			       </v:rect>
                  </font>
              </td>
           </tr>
     <%// 1��2��4�����ύ��������%>
           <tr>
               <td nowrap></td>
               <td align=left nowrap>

                   <font ID="113font" color="#000000" onClick="maingo('113','sysMenu','���ύ��������','/claim/wfLogQuery.do?nodeType=claim&status=4','113')"  style="cursor:'hand'" >
                    <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
			          <v:stroke dashstyle ="ShortDot"></v:stroke>
			       </v:line>
			       <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
			          <v:stroke dashstyle ="ShortDot"></v:stroke>
			       </v:line>
			       
			       <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
				       <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>���ύ��������</v:TextBox>
					   <v:Extrusion backdepth='5pt' on='true'/>
			       </v:rect>
                   </font>
               </td>
           </tr>
           
           
             <%// 1��2��8��ע��/����%>
                              <tr>
                                 <td nowrap></td>
                                 <td align=left nowrap>
                                     <font ID="119font" color="#000000" onClick="maingo('119','sysMenu',' ����ע��/����','/claim/wfLogQuery.do?status=-1&nodeType=claim','119')"  style="cursor:'hand'" >
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
          

  <%// 1��2��5��ע��/������������%>
           <tr>
               <td nowrap></td>
               <td align=left nowrap>

                   <font ID="114font" color="#000000" onClick="maingo('114','sysMenu','ע��/������������','/claim/common/claim/ClaimBeforeCancel.jsp','114')"  style="cursor:'hand'" >
                   <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
			          <v:stroke dashstyle ="ShortDot"></v:stroke>
			       </v:line>
			       <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
			          <v:stroke dashstyle ="ShortDot"></v:stroke>
			       </v:line>
			       
			       <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
				       <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>ע��/������������</v:TextBox>
					   <v:Extrusion backdepth='5pt' on='true'/>
			       </v:rect>
                   </font>
               </td>
           </tr>

<%// 1��2��9��������������%>
           <tr>
               <td nowrap></td>
               <td align=left nowrap>

                   <font ID="118font" color="#000000" onClick="maingo('118','sysMenu','ɾ����������','/claim/common/claim/ClaimDeleteQueryEdit.jsp','118')"  style="cursor:'hand'" >
                   <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
			          <v:stroke dashstyle ="ShortDot"></v:stroke>
			       </v:line>
			       <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
			          <v:stroke dashstyle ="ShortDot"></v:stroke>
			       </v:line>
			       
			       <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
				       <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>ɾ����������</v:TextBox>
					   <v:Extrusion backdepth='5pt' on='true'/>
			       </v:rect>
                   </font>
               </td>
           </tr>
         <%}%> 
   <%// 1��2��6����������״̬ͳ��%>
            <%
			   //�Ƿ���������Ȩ��
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_READ");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPLA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
			 %>     
           <tr>
               <td nowrap></td>
               <td align=left nowrap>

                   <font ID="115font" color="#000000" onClick="maingo('115','sysMenu','��������״̬ͳ��','/claim/common/claimstatus/ClaimStatusStatEdit.jsp?nodeType=claim','115')"  style="cursor:'hand'" >
                   <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
			          <v:stroke dashstyle ="ShortDot"></v:stroke>
			       </v:line>
			       <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
			          <v:stroke dashstyle ="ShortDot"></v:stroke>
			       </v:line>
			       
			       <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
				       <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>��������״̬ͳ��</v:TextBox>
					   <v:Extrusion backdepth='5pt' on='true'/>
			       </v:rect>
                   </font>
               </td>
           </tr>
    <%// 1��2��7����ѯ��������%>
           <tr>
               <td nowrap></td> 
               <td align=left nowrap>

                   <font ID="116font" color="#000000" onClick="maingo('116','sysMenu','��ѯ��������','/claim/common/claim/ClaimQueryEdit.jsp','116')"  style="cursor:'hand'" >
                   <v:line style="POSITION: absolute" from = "0,0" to = "0,10">
			          <v:stroke dashstyle ="ShortDot"></v:stroke>
			       </v:line>
			       <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
			          <v:stroke dashstyle ="ShortDot"></v:stroke>
			       </v:line>
			       
			       <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
				       <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>��ѯ��������</v:TextBox>
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