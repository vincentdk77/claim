          
<%//1.10 �᰸������ %>  
<tr>                                                                                                                                                                                                                    
  <%// �����ļ��еڶ����ǰ����Ǹ��Ӻ�/����ͼ��%>                                                                                                                                                                                                                     
  <td nowrap>                                                                                                                                                                                                         
    <img name="notopimg" ID="20" style="cursor:'hand';" onmouseup="clickEvent(document.all('20'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" src="/claim/images/treeAdd.gif" width="9" height="9" >
  </td>   
  <%// �����ļ��еڶ�����ʾͼ�������%>    
  <td align=left nowrap onClick="clickEvent(document.all('20'), '/claim/images/treeFoderclassOpen.gif','/claim/images/treeFoderclass2.gif');" style="cursor:'default'" >                                                               
    <img name="notopimgII" ID="20II" src="/claim/images/treeFoderclass2.gif" align="absmiddle" width="16" height="16">                                                                                                                                      
    <font ID="20font" color="#000000" >�᰸������</font>                                                                                                                                                                  
  </td>                                                                                                                                                                                                                
</tr>   
<tr name="notop" ID="20p" STYLE="Display:'none'">                                                                                                                                                                       
   <td nowrap></td>             
   <td nowrap>                                                                                                                                                                                                         
      <%// �����ļ��е�����%>
      <table border=0 cellspacing=0 cellpadding=0 class="menu">  
                                                                                                                                                                      
        <tr name="notop" ID="200p" STYLE="Display:'none'" >                                                                                                                                                                      
          <td nowrap></td>                                                                                                                                                                                                    
            <%// �Ƶ�nowrap�ļ��е�����%>
            <%// 1��10��1������᰸�Ǽ���%>
            <%
			   //�Ƿ��н᰸��Ȩ��
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_WRITE");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPPA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
			 %>  
			 <!--                
        <tr>                                                                                                                                                                                                                    
          <td nowrap height="22px"></td>                                                                                                                                           
          <td align=left nowrap>  
            <font ID="2000font" color="#000000" onClick="maingo('2000','sysMenu','����᰸�Ǽ�','/claim/common/endcase/EndcaseBeforeEdit.jsp','2000')"  style="cursor:'hand'" >                                                                                                                                                                                                     
              <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
			     <v:stroke dashstyle ="ShortDot"></v:stroke>
			  </v:line>
			  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
			     <v:stroke dashstyle ="ShortDot"></v:stroke>
			  </v:line>
			  
			  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
				     <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>����᰸�Ǽ�</v:TextBox>
				   <v:Extrusion backdepth='5pt' on='true'/>
			  </v:rect>
            </font>
          </td>                                                                                                                                                                                                                
        </tr>                                                                                                                                                                                                                  
         -->                                                                                                                                                                                                  
        <%// 1��10��9��������᰸����%>                                                                                                                                                                                                                             
        <tr>                                                                                                                                                                                                                    
           <td nowrap></td>                                                                                                                                           
           <td align=left nowrap> 
             <font ID="2009font" color="#000000" onClick="maingo('2009','sysMenu','������᰸����','/claim/wfLogQuery.do?nodeType=endca&status=0','2009')"  style="cursor:'hand'" >
               <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
			     <v:stroke dashstyle ="ShortDot"></v:stroke>
			  </v:line>
			  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
			     <v:stroke dashstyle ="ShortDot"></v:stroke>
			  </v:line>
			  
			  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
				     <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>������᰸����</v:TextBox>
				   <v:Extrusion backdepth='5pt' on='true'/>
			  </v:rect>
             </font>                                                                                                                                                                                                     
           </td>                                                                                                                                                                                                                
        </tr> 
            
        <%// 1��10��5�������᰸����%>                                                                                                                                                                                                                             
        <tr>                                                                                                                                                                                                                    
          <td nowrap></td>                                                                                                                                           
          <td align=left nowrap>      
            <font ID="2004font" color="#000000" onClick="maingo('2004','sysMenu','ɾ���᰸����','workAffair/document/unprocessed_docs.jsp','2004')"  style="cursor:'hand'" > 
              <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
			     <v:stroke dashstyle ="ShortDot"></v:stroke>
			  </v:line>
			  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
			     <v:stroke dashstyle ="ShortDot"></v:stroke>
			  </v:line>
			  
			  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
				     <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>ɾ���᰸����</v:TextBox>
				   <v:Extrusion backdepth='5pt' on='true'/>
			  </v:rect>
            </font>                                                                                                                                                                                                     
          </td>                                                                                                                                                                                                                
        </tr>               
                                

        
        <%// 1��10��6�����ɹ鵵��%>                                                                                                                                                                                                                             
        <tr>
          <td nowrap></td>                                                                                                                                           
          <td align=left nowrap>   
            <font ID="2005font" color="#000000" onClick="maingo('2005','sysMenu','���ɹ鵵��','/claim/common/endcase/CaseNoBeforeEdit.jsp','2005')"  style="cursor:'hand'" > 
              <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
			     <v:stroke dashstyle ="ShortDot"></v:stroke>
			  </v:line>
			  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
			     <v:stroke dashstyle ="ShortDot"></v:stroke>
			  </v:line>
			  
			  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
				     <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>���ɹ鵵��</v:TextBox>
				   <v:Extrusion backdepth='5pt' on='true'/>
			  </v:rect>
            </font>                                                                                                                                                                                                     
          </td>                                                                                                                                                                                                                
        </tr>                                                                                                                                                                                                                
                    
        <%// 1��10��7���������%>                                                                                                                                                                                                                             
        <tr>
          <td nowrap></td>                                                                                                                                           
          <td align=left nowrap>   
            <font ID="2006font" color="#000000" onClick="maingo('2006','sysMenu',' �������','/claim/common/endcase/EndorBeforeInput.jsp','2006')"  style="cursor:'hand'" > 
              <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
			     <v:stroke dashstyle ="ShortDot"></v:stroke>
			  </v:line>
			  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
			     <v:stroke dashstyle ="ShortDot"></v:stroke>
			  </v:line>
			  
			  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
				     <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>�������</v:TextBox>
				   <v:Extrusion backdepth='5pt' on='true'/>
			  </v:rect>
            </font>                                                                                                                                                                                                     
          </td>                                                                                                                                                                                                                
        </tr>
        <%}%>
       <%
			   //�Ƿ��н᰸��Ȩ��
			   checkCode     = AppConfig.get("sysconst.CHECKCODE_READ");
			   taskCode      = AppConfig.get("sysconst.TASKCODE_LPPA");
			   checkPower    = false;
	           checkPower    = uiPowerAction.checkPower(userCode,riskCode,taskCode,checkCode);
			   if(checkPower)
			   {         
	   %>                     
        <%// 1��10��9�� �᰸����״̬ͳ����%>
        <tr>
           <td nowrap></td>
           <td align=left nowrap>

               <font ID="2008font" color="#000000" onClick="maingo('2008','sysMenu',' �᰸����״̬ͳ��','/claim/common/claimstatus/ClaimStatusStatEdit.jsp?nodeType=endca','2008')"  style="cursor:'hand'" >
              <v:line style="POSITION: absolute" from = "0,0" to = "0,16">
			     <v:stroke dashstyle ="ShortDot"></v:stroke>
			  </v:line>
			  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
			     <v:stroke dashstyle ="ShortDot"></v:stroke>
			  </v:line>
			  
			  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
				     <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>�᰸����״̬ͳ��</v:TextBox>
				   <v:Extrusion backdepth='5pt' on='true'/>
			  </v:rect>
               </font>
           </td>
        </tr>                  
        <%// 1��10��8����ѯ�᰸������%>                                                                                                                                                                                                                             
        <tr>
          <td nowrap></td>                                                                                                                                           
          <td align=left nowrap>  
            <font ID="2007font" color="#000000" onClick="maingo('2007','sysMenu',' �᰸��ѯ','/claim/common/endcase/EndcaseQueryEdit.jsp','2007')"  style="cursor:'hand'" > 
              <v:line style="POSITION: absolute" from = "0,0" to = "0,10">
			     <v:stroke dashstyle ="ShortDot"></v:stroke>
			  </v:line>
			  <v:line style="POSITION: absolute" from = "0,10" to = "10,10">
			     <v:stroke dashstyle ="ShortDot"></v:stroke>
			  </v:line>
			  
			  <v:rect style='position:relative;top:0;left:10;width:10;height:10;z-index:8;' fillcolor='#FFCCFF' strokeColor='blue'> 
				     <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '15pt,0pt,0pt,-10pt'>�᰸��ѯ</v:TextBox>
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