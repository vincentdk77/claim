<%--
****************************************************************************
* DESC       ����ӵ�֤ҳ��
* AUTHOR     ��     zhangpeng
* CREATEDATE �� 2004-04-15
* MODIFYLIST ��   Name       Date            Reason/Contents
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
*          ------------------------------------------------------
*              lixiang       2004-06-17
****************************************************************************
--%>

<!--������ʾ��¼����������������ʾ��-->
<table class="common" cellpadding="5" cellspacing="1">
 <!--��ʾ��ʾ���е�-->
 <tr >
   <td class="common" colspan="4">
     <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
          name="DocImg" onclick="showPage(this,spanDoc)">
          ��ӵ�֤<br>
     <span style="display:none">
       <table class="common" style="display:none" id="Doc_Data" cellspacing="1" cellpadding="5">
         <tbody>
            <tr>
               <td class="input">
                   <input name="prpLdocDocCode" class="codecode" style="width:100%" maxlength=3
                    ondblclick="code_CodeSelect(this, 'DocCode');"
                    onchange="code_CodeChange(this, 'DocCode');"
                    onkeyup= "code_CodeSelect(this, 'DocCode');">
               </td>
               <td class="input">
                   <input name="prpLdocDocName" class="codename"
                   ondblclick="code_CodeSelect(this, 'DocCode','-1','name','none','post');"
                   onchange="code_CodeChange(this, 'DocCode','-1','name','none','post');"
                   onkeyup= "code_CodeSelect(this, 'DocCode','-1','name','none','post');">
               </td>
               <td class="input">
                   <input name="prpLdocDocCount" class="common" style="width:100%">
               </td>
               <td class="input" colspan="2">
                   <input name="prpLdocSignInDate" class="common" style="width:100%" description="ǩ������">
               </td>
               <td class="input" style='width:4%' colspan="2" align="center">
                   <div>
                     <input type=button name="buttonDocDelete"  class="smallbutton" onclick="deleteRow(this,'Doc')" value="-" style="cursor: hand">
                     <input type="hidden" name="prpLdocFlag">
                   </div>
               </td>
           </tr>
        </tbody>
     </table>
  </span>
  <span  id="spanDoc" style="display:none" >
     <%-- ��������չ���� --%>
     <table class="common" cellpadding="5" cellspacing="1" id="Doc" >
       <thead>
         <tr>
           <td class="centertitle" style="width:20%">
             ��֤����
           </td>
           <td class="centertitle" style="width:40%" >
             ��֤����
           </td>
           <td class="centertitle" style="width:10%">
             ��֤����
           </td>
           <td class="centertitle" style="width:20%" >
             ǩ������
           </td>
           <td class="centertitle" style="width:10%" >&nbsp;</td>
         </tr>
       </thead>
       <tfoot>
         <tr>
            
            <td class="title" align="right"  colspan=5 style="width:10%">
               <div align="center">
                  <input type="button" value="+" onclick="insertRow('Doc')" class=smallbutton name="buttonDriverInsert" style="cursor: hand">
               </div>
            </td>


        </tr>
      </tfoot>
    </tfoot>
    <tbody>
 <% int index1=0;%>
<logic:iterate id="Doc" name="prpLdocDto" property="docList">
<%
    if(index1 %2== 0)
        out.print("<tr class=oddrow>");
    else
        out.print("<tr class=oddrow>");
%>
               <td class="input">
                   <input name="prpLdocDocCode" class="codecode" style="width:100%" maxlength=3 value="<bean:write name='Doc' property='docCode'/>"
                    ondblclick="code_CodeSelect(this, 'DocCode');"
                    onchange="code_CodeChange(this, 'DocCode');"
                    onkeyup= "code_CodeSelect(this, 'DocCode');">
               </td>
               <td class="input">
                   <input name="prpLdocDocName" class="codename" value="<bean:write name='Doc' property='docName'/>"
                   ondblclick="code_CodeSelect(this, 'DocCode','-1','name','none','post');"
                   onchange="code_CodeChange(this, 'DocCode','-1','name','none','post');"
                   onkeyup= "code_CodeSelect(this, 'DocCode','-1','name','none','post');">
               </td>
               <td class="input">
                   <input name="prpLdocDocCount" class="common" style="width:100%" value="<bean:write name='Doc' property='docCount'/>">
               </td>
               <td class="input" colspan="2">
                   <input name="prpLdocSignInDate" class="common" style="width:100%" description="ǩ������" value="<bean:write name='Doc' property='signInDate'/>">
               </td>
               <td class="input" style='width:4%' colspan="2" align="center">
                   <div>
                     <input type=button name="buttonDocDelete" class=smallbutton onclick="deleteRow(this,'Doc')" value="-" style="cursor: hand">
                     <input type="hidden" name="prpLdocFlag">
                   </div>
               </td>
           </tr>
 <%    index1++;%>
</logic:iterate>
       </tbody>
     </table>
    </span>
   </td>
  </tr>
</table>