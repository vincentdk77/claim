<%--
****************************************************************************
* DESC       ����ʾ��������ҳ��(1: ����ժҪ��2: ����/ע��ԭ��3: �鿱����)��Ҫ������TextType
* AUTHOR     ��κʿ��
* CREATEDATE ��2004-03-03
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%iterator = PrplcombineDtos.iterator();
while(iterator.hasNext()){iterator.next();%>
<%
String prpLregistTextDto = "";
String RegistText = "";
prpLregistTextDto = "prpLregistTextDto_"+String.valueOf(idxTextEdit);
RegistText = "RegistText_"+String.valueOf(idxTextEdit);
%>
    <span  id="spanTextEdit_<%=idxTextEdit%>" style = "display:none" cellspacing="1" cellspacing="0"  width="100%">
   <table class="common" align="center" width="100%">
    <tr class=mline>
      <td class="subformtitle" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="RegistTextImg" onclick="showPage(this,<%= RegistText%>)">
         <logic:equal name="<%= prpLregistTextDto%>" property="textType" value="1">
               <bean:message key="db.regist.registText.textType1" />
         </logic:equal> 
               <logic:equal name="<%= prpLregistTextDto%>" property="textType" value="2">
               <bean:message key="db.regist.registText.textType2" />
         </logic:equal>    
         <logic:equal name="<%= prpLregistTextDto%>" property="textType" value="3">
               <bean:message key="db.regist.registText.textType3" />
         </logic:equal>
        <br>
      <table class="common" align="center" id="<%= RegistText%>" style="display:none">
          <tbody>
            <tr>
              <td class="title" style="text-align:center;" colspan="0">
              <textarea style="wrap:hard" rows="15" cols="80" name="prpLregistTextContextInnerHTML_<%=idxTextEdit%>"><bean:write name="<%= prpLregistTextDto%>" property="context"/></textarea>              
               
                <!--Modify by chenrenda add begin 20050410-->
                <!--Reason:���ݴ�����󣬳���ժҪ�����û���������Զ�����-->
                 <logic:equal name="<%= prpLregistTextDto%>" property="textType" value="1">
                   <input type="button" name="btnRegistText_<%=idxTextEdit%>" value="���ɳ���ժҪ" class="bigbutton" onclick="return generateRegistText();">
                 </logic:equal> 
                <!--Modify by chenrenda add end 20050410-->
              </td>
            </tr>
          </tbody>
        </table>
      </td>
    </tr>
  </table>
</span>

<%idxTextEdit++;
}%>