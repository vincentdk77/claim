<%--
****************************************************************************
* DESC       �����õ������ĵ�����
* AUTHOR     �� lixiang
* CREATEDATE �� 2005-08-30
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
	<table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
	<tr>
	   <td width="30%"> 
	     <table width="100%" border="0" cellpadding="0" cellspacing="0">
	       <tr> 
	          <td width ="12"><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
	          <td class="formtitle">���Ȼ�������
	          </td>
	          <td width ="11"><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
	        </tr>
	      </table>
	   </td>
	   <td width="70%" align="right"><font color="#666666">��ע����<font color="#FF0000">*</font>��Ϊ��ѡ���<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">�� 
	  Ϊ˫��ѡ���</font></td>
	</tr>
</table>
    <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" style="width:100%">
      <tr>
        <td class="title" colspan="4">�����Ȼ�������
        
          <input type="hidden" name="prpDcompanyComEName" value="<bean:write name='prpDcompanyDto' property='comEName' />">
          <input type="hidden" name="prpDcompanyAddressEName" value="<bean:write name='prpDcompanyDto' property='addressEName' />">
          <input type="hidden" name="prpDcompanyTaxNumber" value="<bean:write name='prpDcompanyDto' property='taxNumber' />">
          <input type="hidden" name="prpDcompanyUpperComCode" value="<bean:write name='prpDcompanyDto' property='upperComCode' />">
          <input type="hidden" name="prpDcompanyInsurerName" value="<bean:write name='prpDcompanyDto' property='insurerName' />">
          <input type="hidden" name="prpDcompanyComAttribute" value="<bean:write name='prpDcompanyDto' property='comAttribute' />">
          <input type="hidden" name="prpDcompanyComType" value="<bean:write name='prpDcompanyDto' property='comType' />">
          <input type="hidden" name="prpDcompanyComLevel" value="<bean:write name='prpDcompanyDto' property='comLevel' />">
          <input type="hidden" name="prpDcompanyManager" value="<bean:write name='prpDcompanyDto' property='manager' />">
          <input type="hidden" name="prpDcompanyAccountLeader" value="<bean:write name='prpDcompanyDto' property='accountLeader' />">
          <input type="hidden" name="prpDcompanyCashier" value="<bean:write name='prpDcompanyDto' property='cashier' />">
          <input type="hidden" name="prpDcompanyAccountant" value="<bean:write name='prpDcompanyDto' property='accountant' />">
          <input type="hidden" name="prpDcompanyNewComCode" value="<bean:write name='prpDcompanyDto' property='newComCode' />">
          <input type="hidden" name="prpDcompanyValidStatus" value="<bean:write name='prpDcompanyDto' property='validStatus' />">
          <input type="hidden" name="prpDcompanyAcntUnit" value="<bean:write name='prpDcompanyDto' property='acntUnit' />">
          <input type="hidden" name="prpDcompanyArticleCode" value="<bean:write name='prpDcompanyDto' property='articleCode' />">
          <input type="hidden" name="prpDcompanyAccCode" value="<bean:write name='prpDcompanyDto' property='accCode' />">
          <input type="hidden" name="prpDcompanyCenterFlag" value="<bean:write name='prpDcompanyDto' property='centerFlag' />">
          <input type="hidden" name="prpDcompanyOuterPayCode" value="<bean:write name='prpDcompanyDto' property='outerPayCode' />">
          <input type="hidden" name="prpDcompanyInnerPayCode" value="<bean:write name='prpDcompanyDto' property='outerPayCode' />">
          <input type="hidden" name="prpDcompanyFlag" value="<bean:write name='prpDcompanyDto' property='flag' />">    
          <input type="hidden" name="editType" value="<bean:write name='scheduleObjectDto' property='editType' />">    
 </td>
      </tr> 
      
      <% 
      String addComReadOnly=" class='readonly' readOnly"; 
        if (editType.equals("ADD")){
        
         addComReadOnly=" class='input' ";
      }
      
      //������ܹ�˾�ģ������������еĵ��Ȼ���
      
       UserDto user = (UserDto) session.getAttribute("user");
       String comCodeTemp = user.getComCode();
       if (comCodeTemp.equals("31000000")){
      %>
      <tr>        
        <td class="title" style="width:15%">�������Ȼ���:</td>
        <td class="input" style="width:37%" colspan=3>
        
         <html:select name="prpDcompanyDto" property="upperComCode" styleClass="three" >
              <html:options collection="scheduleCenterList" property="comCode" labelProperty="comCName"/>          
          </html:select> 
          
        </td>
      </tr>
      <%}else{%>
         <input type="hidden" name="upperComCode" value="<bean:write name='prpDcompanyDto' property='upperComCode' />">
      
      <%}%>
      <tr>        
        <td class="title" style="width:15%">���Ȼ�������:</td>
        <td class="input" style="width:37%" >
           <input type=text name="prpDcompanyComCode" title="�����Ȼ�������" maxlength="8"  <%=addComReadOnly%>  style="width:90%" value="<bean:write name='prpDcompanyDto' property='comCode' filter='true' />">
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
       <td class="title" style="width:15%">���Ȼ�������:</td>
        <td class="input" style="width:37%" >
            <input type=text name="prpDcompanyComCName" title="�����Ȼ�������"  class="input"  style="width:90%" value="<bean:write name='prpDcompanyDto' property='comCName' filter='true' />">
            <img src="/claim/images/bgMarkMustInput.jpg">
         </td>
      </tr>
      <tr>
        <td class="title">��ַ:</td>
        <td class="input" colspan=3>
         <input type="text" class=input name="prpDcompanyAddressCName" value="<bean:write name='prpDcompanyDto' property='addressCName' />">
         
        	       
        </td>
       </tr>
       <tr>  
        <td class="title">�ʱ�:</td>
        <td class="input" >
      	  <input type="text" class=input name="prpDcompanyPostCode" value="<bean:write name='prpDcompanyDto' property='postCode' />">
        
        </td>  
          <td class="title">����:</td>
        <td class="input" >
             <input type="text" class=input name="prpDcompanyFaxNumber" value="<bean:write name='prpDcompanyDto' property='faxNumber' />">
         	
         </td>          
    <tr>
        <td class="title">Ч��״̬:</td>
        <td class="input" >
          <html:radio name="prpDcompanyDto" property="validStatus" value="1">��</html:radio>
          <html:radio name="prpDcompanyDto" property="validStatus" value="0">�� </html:radio>
       	
        </td>        
      
      <td class="title" style="width:15%" style="valign:bottom" >���Ȼ�������:</td> 
      <td class="input" style="width:20%">
        <html:radio name="prpDcompanyDto" property="comType" value="1000001">����</html:radio>
        <html:radio name="prpDcompanyDto" property="comType" value="1000002">������</html:radio>
   	</td>
      </tr>
        
       </tr>
       <tr>  
        <td class="title">�绰:</td>
        <td class="input" colspan=3>
      	 <input type="text" class=input name="prpDcompanyPhoneNumber" value="<bean:write name='prpDcompanyDto' property='phoneNumber' />">
        </td>  
      </tr>
       
      <tr>
       <td class="title" >��ע:</td>
       <td class="input" colspan="3" >
        <input type="text" class=input name="prpDcompanyRemark" value="<bean:write name='prpDcompanyDto' property='remark' />">
       </td>
      </tr>
    </table>