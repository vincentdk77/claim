<%--
****************************************************************************
* DESC       :�������ȱ����Ϣҳ��
* AUTHOR     :lixiang
* CREATEDATE : 2004-07-22
* MODIFYLIST :   Name       Date            Reason/Contents
*          ------------------------------------------------------
************************ ****************************************************
--%>
    <%-- ��������չ�����ģ�� --%>
    <%--���������Զ���JavaScript������--%>
   <!--������ʾ��¼������������������ʾ��-->   
 <%@page import="java.util.*"%>
  
<input  type=text readonly class="readonly"  name="prpLscheduleItemFinishSchedule" value="<%=request.getAttribute("finishSubmit")%>">
 
            <%-- ��������չ���� --%>
            <table class=common cellpadding="5" cellspacing="1">
                <tr>
	               <td colspan=7 class="formtitle">�����������<%=strtitleTemp%>����</td>
	              </tr>
    
                
                <tbody>
            <%
                int index=0;
                int rowspan=7; //��Ϊ��źϲ�ʹ�õ�
                int personrowspan=7 ;
                String checkValue=""; 
                String saveType="getBackers"; 
                String haveCheck=""; //�ж��Ƿ��Ѿ�ѡ�����
                String haveCheckdisable=""; //�ж��Ƿ��Ѿ����ȹ��ˡ�
                String itemDis="";   //��ʾ�����
                String  ifreadonly=""; //Ĭ�ϲ���ֻ����
                String  checkTypeDisplay="style='dipslay:none'"; //Ĭ��û�в鿱�ֳ��ȵ���ʾ
                String lossItemCode=request.getParameter("lossItemCode");// ֻ����editType=GETBACK��ʱ�򣬾�����һ���ſ����޸ĵ�
                //�ж���Աѡ���
                String selectPersonFunction ="CertaHanderCode";           
                String getBackDisp=""; //���ø�����ʾ��
                String strLossItemCode = "";   //����������
                String riskCode = request.getParameter("riskCode"); 
                String carDisplay0507 = "";
            %>
                 <%// ˼·������Ǹ��ɣ�ֻ��ʾѡ�����һ�У�����ʾ�����ĵ�����Ϣ%>
                 <logic:notEmpty  name="prpLscheduleItemDto"  property="scheduleItemList"> 
                 
             <%  //System.out.println("������Ȳ�Ϊ��");       
                 PrpLscheduleItemDto  prpLscheduleItemDto1=(PrpLscheduleItemDto)request.getAttribute("prpLscheduleItemDto");
             %>
   
                <logic:iterate id="scheduleItem" name="prpLscheduleItemDto" property="scheduleItemList">
             <!-- �����永��������-->        
             <% 
                 carDisplay0507 = "";
                 haveCheckdisable=""; //Ĭ��û�б����ȹ�
                 haveCheck=""; //Ĭ��û��ѡ�����
                 itemDis="";//Ĭ��ʲô������ʾ
                 ifreadonly=""; //Ĭ�ϲ���ֻ����
                 getBackDisp=""; //���ɵ���ʾ
                 strLossItemCode = "";
             %>
				<logic:equal name='scheduleItem' property='itemNo' value="1">
					<%
				    if("0507".equals(riskCode.trim())||"0577".equals(riskCode.trim())||"0587".equals(riskCode.trim())){
				    	carDisplay0507 = "";
				      }       
                %>
				</logic:equal>

				<tr <%=carDisplay0507 %>>   
 <%   
     PrpLscheduleItemDto  prpLscheduleItemDto = (PrpLscheduleItemDto) ((ArrayList)prpLscheduleItemDto1.getScheduleItemList()).get(index);                
    if (!"GETBACKEDIT".equals(saveType1)|| ("GETBACKEDIT".equals(saveType1)
           &&  (prpLscheduleItemDto.getItemNo()+"").equals(lossItemCode))) {   
     
      //�ж���Աѡ������һ��
      selectPersonFunction ="CertaHanderCode";
      if (prpLscheduleItemDto.getItemNo()==0)  selectPersonFunction ="WoundHanderCode";
      if (prpLscheduleItemDto.getItemNo()==-1) selectPersonFunction ="PropHanderCode";                      
 %>       
 
  <input name="prpLscheduleItemOperatorCode" type="hidden" description="����Ա"  value="<bean:write name='scheduleItem' property='operatorCode'/>">
  <input name="prpLscheduleItemInputDate" type="hidden" description="����ʱ��"  value="<bean:write name='scheduleItem' property='inputDate'/>">
  
        
          <logic:equal name='scheduleItem' property='itemNo' value="-1">
                  <td class="title" style="width:20%" rowspan=8>       
          </logic:equal>
            
          <logic:notEqual name='scheduleItem' property='itemNo' value="-1">
                  <td class="title" style="width:20%" rowspan="<%=rowspan%>">       
          </logic:notEqual>                

                    <div align="center">
                       
                     <logic:equal name='scheduleItem' property='selectSend' value="1">
<% 
    haveCheck="checked";
	hasSchedFlag = true;    //add by liyanjie 2005-12-14
%>
                     </logic:equal> 
                     <logic:equal name='scheduleItem' property='surveyTimes' value="1">
<% 
   haveCheckdisable="disabled"; 
   ifreadonly="readonly";
%>
                     </logic:equal>  
                     <logic:equal name='scheduleItem' property='scheduleType' value="sched">
<% 
   //�������û���ύ���򲻿��Խ��е���
   //haveCheckdisable="disabled"; 
   //ifreadonly="readonly"; 
%>
                     </logic:equal>  
<%
	/*
    if("0507".equals(riskCode.trim())){
       haveCheckdisable=" "; 
       ifreadonly=" ";
       haveCheck=" ";       
    }
	*/
%>
 <% //����Ǹ��ɣ�����Խ����޸Ĳ���������ֻ��ָ�����������޸ĵ� %>
 
 <logic:equal name="prpLscheduleMainWFDto"  property="saveType" value="GETBACKEDIT">
     <logic:equal name='scheduleItem' property='itemNo' value="<%=lossItemCode%>">
     <%
       ifreadonly="";
       getBackDisp="(�ɸ���)";
    %>
     </logic:equal>
 </logic:equal>                   
                     <logic:equal name='scheduleItem' property='itemNo' value="1">
<%
    /*
	if("0507".equals(riskCode.trim())){
    	 haveCheckdisable="disabled"; 
         ifreadonly="readonly";
         haveCheck=" ";       
    }       
	*/
    itemDis="��ĳ�(";
    strLossItemCode = prpLscheduleItemDto.getItemNo() + "):";
%>   
                     </logic:equal>              
                  
                     <input type="checkbox" class="readonly"  name="checkYesNo" style="width:20px" value="ON" <%=haveCheck%> <%=haveCheckdisable%>>&nbsp;
                     
                     

                     
                    
                     
                     <logic:greaterThan name='scheduleItem' property='itemNo' value="1">
<%
    itemDis="���߳�(";
    strLossItemCode = prpLscheduleItemDto.getItemNo() + "):";
%>    
                     </logic:greaterThan>
                   
                     <%=itemDis + strLossItemCode %>
                     <bean:write name='scheduleItem' property='licenseNo'/><%=getBackDisp%>
                     <br>    
                     <!--<input type="checkbox"  name="txtScheduleSmcSend" onclick="setSmcSend();" class="readonly" style="width:20px"  >&nbsp;���Ͷ���-->
                </td>
   <input type="hidden" class="readonlyno" readonly name="prpLscheduleItemItemNo" value="<bean:write name='scheduleItem' property='itemNo'/>">
   <input name="prpLscheduleItemLicenseNo" type="hidden" description="���ƺ���"  value="<bean:write name='scheduleItem' property='licenseNo'/>">
               
                 
                 
                    </div>
                  
                   </td>          
                 <td class="title" style="width:11%">������λ: </td>
                 <td class="input" colspan=6>
                 <input type=hidden class="codecode" name="prpLscheduleItemScheduleObjectID"  num=<%=index%>
                    style="width:20%" title="���嵥λ" value="<bean:write name='scheduleItem' property='scheduleObjectID' filter='true' />"
                    <% if (!ifreadonly.equals("readonly")){%>
                    ondblclick="code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onkeyup= "code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onblur="code_CodeChange(this, 'ComCodeByProvinceCode','1','code','post','clear');"
                    onchange="setNewComCode(this);"
                    <%}%>
                   <%=ifreadonly%>
                 >
                 
                 <input type=text class="codecode" name="prpLscheduleItemScheduleObjectName"  title="���嵥λ" style="width:50%" maxLength="50" description="�鿱����λ" value="<bean:write name='scheduleItem' property='scheduleObjectName' filter='true' />"
                   <% if (!ifreadonly.equals("readonly")){%>
                     ondblclick = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'�鿱����λ');"
                    onkeypress = "window.event.keyCode = 0;"
                    onkeyup    = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'�鿱����λ');"
                   <%}%>
                   <%=ifreadonly%>
                 >
                 
                 <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle"> 
                 <img src="/claim/images/bgMarkMustInput.jpg">
                </tr>
            <%checkTypeDisplay="";%> 
           <logic:greaterThan name='scheduleItem' property='itemNo' value="0">
            <%checkTypeDisplay="style='display:none'"; //Ĭ��û�в鿱�ֳ��ȵ���ʾ %>
           </logic:greaterThan>  
             <logic:equal name='scheduleItem' property='itemNo' value="1">
                    <%
                    if("0507".equals(riskCode.trim())||"0577".equals(riskCode.trim())||"0587".equals(riskCode.trim())){
                    	carDisplay0507 = "";
                      }       
                %>
                </logic:equal>
              <tr <%=checkTypeDisplay%> >
          <input type=hidden class="readonlyno" readonly name="prpLscheduleItemInsureCarFlag" value="<bean:write name='scheduleItem' property='insureCarFlag'/>">
            <logic:greaterThan name='scheduleItem' property='itemNo' value="0">
                <input  type=hidden name="prpLscheduleItemCommendRepairFactoryName"  value="<bean:write name='scheduleItem' property='commendRepairFactoryName'/>">
   
                    <td class="title" style="width:11%" >�鿱��:</td>
                    <td class="input" style="width:15%">
                  
                 <logic:equal name='scheduleItem' property='surveyTimes' value="0">
                                      <html:select name="scheduleItem" property="surveyType" style="display:none" >
                              <html:option value="1" >��һ�ֳ�</html:option>
		                          <html:option value="0">�ǵ�һ�ֳ�</html:option>
		                 </html:select>
                 </logic:equal> 
                 
                 <logic:notEqual name='scheduleItem' property='surveyTimes' value="0" >
                     <html:select name="scheduleItem" property="surveyType" style="display:none">
                            <logic:equal name='scheduleItem' property='surveyType' value="1">
                              <html:option value="1" >��һ�ֳ�</html:option>
                            </logic:equal>  
                            <logic:equal name='scheduleItem' property='surveyType' value="0" >
		                          <html:option value="0" >�ǵ�һ�ֳ�</html:option>
		                          </logic:equal>
		                 </html:select>

                 </logic:notEqual>
                                
                </td>
                
                  <td class="title" style="width:19%">�Ƿ�Ϊ��ĳ���:</td>
                 <td class="input" style="width:10%">
                     
                    <logic:equal name='scheduleItem' property='insureCarFlag' value="1">
                         ��
                     </logic:equal>  
                     
                     <logic:notEqual name='scheduleItem' property='insureCarFlag' value="1">
                         ��
                     </logic:notEqual>  
                     
                  </td>
                 
	
          </logic:greaterThan>
           
           <logic:equal name='scheduleItem' property='itemNo' value="0">
                 <td class="title" >���յص�:</td>
                 <td class="input" colspan=5>
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemCheckSite" style="width:90%" value="<bean:write name='scheduleItem' property='checkSite'/>"><img src="/claim/images/bgMarkMustInput.jpg">  
                 </td>

            </logic:equal>
            
           <logic:lessThan name='scheduleItem' property='itemNo' value="1">
            <input type="hidden" name="surveyType" value="<bean:write name='scheduleItem' property='surveyType'/>">
           </logic:lessThan>
            
            </tr>

             <!--Modify by chenrenda  add begin 20050415 -->
             <!--Reason:�ڶ������ҳ�����������������������ϵ�绰���Ƿ������־λ -->
           <logic:equal name='scheduleItem' property='itemNo' value="0">
             <tr >   
                <td class="title" style="width:11%" >��ϵ������:</td>
                <td class="input" style="width:15%">
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemCommendRepairFactoryName" maxLength="80" onblur="checkLength1(this);" description="��ϵ������" value="<bean:write name='scheduleItem' property='commendRepairFactoryName'/>">
                </td>    
               
               <td class="input" style="width:11%">��ϵ�˵绰:</td>
               <td class="input" style="width:15%">
                 <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemFactoryPhone" maxLength="30" onblur="checkLength1(this);" description="��ϵ�˵绰" value="<bean:write name='scheduleItem' property='factoryPhone'/>">
               </td>                
             </tr>
             <tr>   
                <td class="title" style="width:11%" >������:</td>
                <td class="input" colspan=4>
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemFactoryEstimateLoss"  value="<bean:write name='scheduleItem' property='factoryEstimateLoss'/>">
                </td>    
             </tr>
            </logic:equal>

            <logic:equal name='scheduleItem' property='itemNo' value="-1">
             <tr>   
                 <td class="title" >�����ַ:</td>
                 <td class="input" colspan=5>
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemCheckSite" style="width:90%" maxLength="100" onblur="checkLength1(this);" description="�����ַ" value="<bean:write name='scheduleItem' property='checkSite'/>"><img src="/claim/images/bgMarkMustInput.jpg">  
                 </td>
                                
             </tr>           
             <tr>   
                <td class="title" style="width:11%" >��ϵ������:</td>
                <td class="input" style="width:15%">
                   <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemCommendRepairFactoryName" maxLength="80" onblur="checkLength1(this);" description="��ϵ������"  value="<bean:write name='scheduleItem' property='commendRepairFactoryName'/>">
               </td>    
               
               <td class="input" style="width:11%">��ϵ�˵绰:</td>
               <td class="input" style="width:15%">
                 <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemFactoryPhone" maxLength="30" onblur="checkLength1(this);" description="��ϵ�˵绰" value="<bean:write name='scheduleItem' property='factoryPhone'/>">
               </td>                
             </tr>
             <tr>   
                <td class="title" style="width:11%" >������:</td>
                <td class="input" colspan=4>
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemFactoryEstimateLoss"  value="<bean:write name='scheduleItem' property='factoryEstimateLoss'/>">
                </td>    
             </tr>
            </logic:equal>

            <logic:equal name='scheduleItem' property='itemNo' value="-2">
             <tr>   
                 <td class="title" >�����ַ:</td>
                 <td class="input" colspan=5>
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemCheckSite" style="width:90%" maxLength="100" onblur="checkLength1(this);" description="�����ַ" value="<bean:write name='scheduleItem' property='checkSite'/>"><img src="/claim/images/bgMarkMustInput.jpg">  
                 </td>
                                
             </tr>           
             <tr>   
                <td class="title" style="width:11%" >��ϵ������:</td>
                <td class="input" style="width:15%">
                   <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemCommendRepairFactoryName" maxLength="80" onblur="checkLength1(this);" description="��ϵ������"  value="<bean:write name='scheduleItem' property='commendRepairFactoryName'/>">
               </td>    
               
               <td class="input" style="width:11%">��ϵ�˵绰:</td>
               <td class="input" style="width:15%">
                 <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemFactoryPhone" maxLength="30" onblur="checkLength1(this);" description="��ϵ�˵绰" value="<bean:write name='scheduleItem' property='factoryPhone'/>">
               </td>                
             </tr>
             <tr>   
                <td class="title" style="width:11%" >������:</td>
                <td class="input" colspan=4>
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemFactoryEstimateLoss"  value="<bean:write name='scheduleItem' property='factoryEstimateLoss'/>">
                </td>    
             </tr>
            </logic:equal>
            
           <logic:greaterThan name='scheduleItem' property='itemNo' value="0">
             <tr <%=carDisplay0507%>>   
                 <td class="title" >�����ַ:</td>
                 <td class="input" colspan=5>
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemCheckSite" style="width:90%" maxLength="100" onblur="checkLength1(this);" description="�����ַ" value="<bean:write name='scheduleItem' property='checkSite'/>"><img src="/claim/images/bgMarkMustInput.jpg">  
                 </td>
                                
             </tr>           
             <tr <%=carDisplay0507%>>   
                <td class="title" style="width:11%" >������:</td>
                <td class="input" style="width:15%">
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemFactoryEstimateLoss"  value="<bean:write name='scheduleItem' property='factoryEstimateLoss'/>">
                </td>    
               
               <td class="input" style="width:11%">������ϵ�绰:</td>
               <td class="input" style="width:15%">
                 <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemFactoryPhone" maxLength="30" onblur="checkLength1(this);" description="������ϵ�绰" value="<bean:write name='scheduleItem' property='factoryPhone'/>">
               </td>                
             </tr>
           </logic:greaterThan>
            
             <tr <%=carDisplay0507%>>   
                <td class="title" >����״̬:</td>
                <td class="input" colspan="5">
                   <html:select name="scheduleItem" style="width:30%" property="exigenceGree" >
                     <logic:notEqual name='scheduleItem' property='surveyTimes' value="0">
                       <logic:equal name='scheduleItem' property='exigenceGree' value="1">
                           <html:option value="1"   >һ��</html:option>
                        </logic:equal>  
                          <logic:equal name='scheduleItem' property='exigenceGree' value="0">
                          <html:option value="0" >����</html:option>
                        </logic:equal>  
                     </logic:notEqual>
                     <logic:equal name='scheduleItem' property='surveyTimes' value="0">
                     
                     <html:option value="1"   >һ��</html:option>
                     <html:option value="0" >����</html:option>
                     
                     </logic:equal>
		          </html:select>  
                </td>    
                           
             </tr>
             
             <!--Modify by chenrenda  add end 20050415 -->
           
              <tr <%=carDisplay0507%>>
                <td class="title" >����Ҫ����ʾ:</td>
          <td class="input" colspan=6>
              <input  class="input" <%=ifreadonly%> name="prpLscheduleItemResultInfo" style="width:90%" maxLength="255" onblur="checkLength1(this);" description="����Ҫ����ʾ" value="<bean:write name='scheduleItem' property='resultInfo'/>">
              <input  type=hidden name="prpLCheckSelectSend" value="0">
              <input  type=hidden name="prpLscheduleItemSelectSend" value="<bean:write name='scheduleItem' property='selectSend'/>">
              <!-- add by liyanjie 2005-12-12 start ÿ��������Ŀ�е�����˫����־,�����ĵ������Ĵ���-->
              <input  type=hidden name="prpLscheduleItemCommiItemFlag" value="<bean:write name='scheduleItem' property='commiItemFlag'/>">   
              <input  type=hidden name="prpLscheduleItemClaimComCode" value="<bean:write name='scheduleItem' property='claimComCode'/>">   
              <!-- add by liyanjie 2005-12-12 end-->
              <input  type=hidden name="prpLscheduleItemSurveyTimes" value="<bean:write name='scheduleItem' property='surveyTimes'/>">
              <input  type=hidden name="prpLscheduleItemBookFlag" value="<bean:write name='scheduleItem' property='bookFlag'/>">
              <input  type=hidden name="prpLscheduleItemScheduleType" value="<bean:write name='scheduleItem' property='scheduleType'/>">
              <input  type=hidden name="prpLscheduleItemFlag" value="<bean:write name='scheduleItem' property='flag'/>">
          </td>
       </tr>
                 
                 <tr <%=carDisplay0507%>>
                 <td class="title" style="width:11%">������Ա:</td>
                 <td class="input" colspan=6 Style=""><%//�߿������%>
                   
                   <input type="hidden" name="nextNodeNo" value="<bean:write name='scheduleItem' property='nextNodeNo'/>">
                   <input type=text name="nextHandlerCode" num=<%=index%> class="codecode"   style="width:100px" maxlength="10" title="����Ա" value="<bean:write name='scheduleItem' property='nextHandlerCode'/>"
             <% if (!ifreadonly.equals("readonly")){%>
             ondblclick="setNewHandlerComCode(this);code_CodeSelect(this, '<%=selectPersonFunction%>');"
             onkeyup= "code_CodeSelect(this, '<%=selectPersonFunction%>');" 
             onblur="code_CodeChange(this, '<%=selectPersonFunction%>','1','code','post','clear');"
             onchange="setNewHandlerCode(this);"
             <%}%>
             <%=ifreadonly%>
             >
        <input type=text name="nextHandlerName" num=<%=index%> class="codecode" style="width:80px" title="����Ա" maxlength="30"   value="<bean:write name='scheduleItem' property='nextHandlerName'/>"
             <% if (!ifreadonly.equals("readonly")){%>
              ondblclick="setNewHandlerComCode(this);code_CodeSelect(this, '<%=selectPersonFunction%>','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, '<%=selectPersonFunction%>','-1','name','none','post');" 
             onblur="code_CodeChange(this, '<%=selectPersonFunction%>','-1','name','post','clear');"
             <%}%>
             <%=ifreadonly%>

                  </td>
                  
               </tr>
               
               <tr <%=carDisplay0507%>><td colspan="7"><hr size="2"  color="#065498" ></td>
               </tr>
               
               
               
<input type="hidden" name="scheduleLossItemCode" value=<%=lossItemCode%>>
<%}%>       
         <%    index++;%>
        </logic:iterate>
      </logic:notEmpty>  
                </tbody>
                <% if ("GETBACKEDIT".equals(saveType1)) index=1; %>
             <input type=hidden name=maxrow value=<%=index%>>
             <input  type=hidden name="scheduleType" value="">
             <input type=hidden name="selectLossItemCodeMain" value="0">
             <input  type=hidden name="prpLscheduleItemScheduleID" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleID'/>">
             </table>
            
            

     

