<%--
****************************************************************************
* DESC       ��ͨ�ð�ť����
* AUTHOR     : liubvo
* CREATEDATE ��2004-10-11
* MODIFYLIST ��   Name       Date            Reason/Contents
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
*          ------------------------------------------------------
****************************************************************************
--%>
<%-- ����ͨ�ð�ť --%>              
<table id="buttonArea" cellpadding="5" cellspacing="1" class=common style="display:" >
  <!--  modify by liyanjie 20051022 һ��table����id del: id="tablebutton"  -->
  <!--�ڲ�ͬ״̬�£���ť�������ǲ�ͬ�ģ�-->
  <%-- (1)�����Ǽ� " �ݴ�" " ȡ��" "�����","����ɲ��ύ"
  (2)������   "����" "ȡ��","�����","����ɲ��ύ","����"
  (3)�����   "����" "ȡ��" "�ύ"
  (4)���ύ   "����"
  (5)����     "����"                  
  --%> 
  <tr class=common>
  <%-- ���������ı��水ť���ĸ��ı�־--%>
    <td>
      <input  type="hidden" name=buttonSaveType value="2">
    </td>
  </tr> 
  
  <tr>  
      <% //����ǲ��ǴӲ鿱ֱ�ӽ���Ķ�������ǵĻ�����ôֻ���棬û�й����������顣
        String dfFlag=request.getParameter("dfFlag");
        if("Y".equals(dfFlag) ){
        %>
        <td class=button align="center">
           <!--���ذ�ť-->
             <input type=button name=buttonCancel class='button' value="����" onclick="javascript:history.go(-1);" >
        </td>
        
        
        <%
       } else {
         String checkInput=request.getParameter("checkInput");
         if (checkInput!=null&&checkInput.equals("true"))
         {
         %>
         
          <td class=button align="center">
                <!--���水ť-->
                <input  type="hidden" name=checkInput value="true">
                <input type="button" name=buttonSave class='button' value="�ݴ�" onclick="return saveForm(this,'CheckInput');">
                
          </td>
            <td class=button align="center">
           <!--���ذ�ť-->
             <input type=button name=buttonCancel class='button' value="����" onclick="javascript:history.go(-1);" >
            </td>   
         <%
         }else{
      %>
      
        <logic:notEqual name="prpLverifyLossDto" property="status" value="4">
              <td class=button  align="center">
                <!--���水ť-->
                 <input type="button" name=buttonSave class='button' value="�ݴ�" onclick="return saveForm(this,'2');">
              </td>
              
              <td class=button align="center">
              


                <!--<input type=text name="nextHandlerCode" class="codecode"  style="width:100px" title="����Ա" value=""
             ondblclick="code_CodeSelect(this, 'HanderCode');"
             onkeyup= "code_CodeSelect(this, 'HanderCode');">
            <input type=text name="nextHandlerName" class="codecode" style="width:80px" title="����Ա" value=""
             ondblclick="code_CodeSelect(this, 'HanderCode','-1','always','none','post');"
             onkeyup= "code_CodeSelect(this, 'HanderCode','-1','always','none','post');">-->
             
               <!--Modify by chenenda update end 20050420-->
                <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >
              </td>
              <td class=button  align="center">
                <!--ȡ����ť-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
              </td>
            </logic:notEqual>
     <%}%>           
    <logic:equal name="prpLverifyLossDto" property="status" value="4">
<%
  String ifclose = request.getParameter("ifclose");
  if("true".equals(ifclose)){
%>              
          <td class=button style="width:33%" align="center">
            <input type="button" name=buttonSave class='button' value="�� ��" onclick="window.close();">
            </td>
<%
  }else{
%>
      <td class=button  align="center">
        <!--ȡ����ť-->
         <input type="button" class="button" value="�� ��" src="/claim/images/bgClaimBackButtonSmall.gif" align="middle" width="68" height="21"  border-style="none"  LANGUAGE=JAVASCRIPT  onmousedown="history.back();return false;">         
      </td>
<%
  }
%>
    </logic:equal> 
     <logic:equal name="prpLverifyLossDto" property="status" value="2">
     	<td class=button  align="right">
        	 <input type="button" name=giveup class='button' value="��������"  onclick="giveupTemporarySave('certa');">
        </td>	 
     </logic:equal>
    
    <!--��������(ֻ�Դ�����״̬)-->
             <% String statusgiv= request.getParameter("status");
                 if(statusgiv!=null&&statusgiv.equals("0")){
             %>
             <td class=button  align="center">
              <!--������ťstyle="width:30%"-->
             <input type=button name=buttonGiveup class='button' value="��������" onclick="taskGiveup();" >
             </td>
             <%
             }
        }      %>              
           <!--��������-->
           
  </tr>
</table>  