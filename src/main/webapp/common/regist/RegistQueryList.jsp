<%--
****************************************************************************
* DESC       ��������ѯ�������ҳ��
* AUTHOR     ��lijiyuan
* CREATEDATE ��2004-03-01
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%> 

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<!---add by zhaolu 20060802 start--->
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<!---add by zhaolu 20060802 end--->
<%
    //ԭ����ҳ��������һ����ӡ��ť
    
%> 
<script src="/claim/common/js/showpage.js"> </script>
    <script language="VBScript">
    // ���ⵯ����ȫ������˵����Internetѡ��=����ȫ=�������ε�վ��
    // 1.����վ����������վ�㣬
    // 2.�Զ��弶���� ���� ��û�б��Ϊ��ȫ��ActiveX�ؼ����г�ʼ���ͽű�����

    dim hkey_root,hkey_path,hkey_key
    hkey_root="HKEY_CURRENT_USER"
    hkey_path="\Software\Microsoft\Internet Explorer\PageSetup"

    dim oldheader,oldfooter

    '//������ҳ��ӡ��ҳüҳ�ţ���������
    function pagesetup_set(header,footer)
        on error resume next
        Set RegWsh = CreateObject("WScript.Shell")
        hkey_key="\header"
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,header
        hkey_key="\footer"
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,footer


        hkey_key="\margin_left" '��
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"0.73"
        hkey_key="\margin_right" '��
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"0.70"
        hkey_key="\margin_top" '��
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"1.1"
        hkey_key="\margin_bottom" '��
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"1"

    end function
    '//������ҳ��ӡ��ҳüҳ��,��������ΪĬ��ֵ
    function pagesetup_default()
        on error resume next
        Set RegWsh = CreateObject("WScript.Shell")
        hkey_key="\header"
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"&w&bҳ�룬&p/&P"
        hkey_key="\footer"
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"&u&b&d"

        hkey_key="\margin_left" '��
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"0.75"     '(��Ӧ 19.05����)
        hkey_key="\margin_right" '��
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"0.75"
        hkey_key="\margin_top" '��
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"0.75"
        hkey_key="\margin_bottom" '��
        RegWsh.RegWrite hkey_root+hkey_path+hkey_key,"0.75"
    end function

    '//��ʾҳ������
    function pagesetup_get()
        on error resume next
        Set RegWsh = CreateObject("WScript.Shell")
        hkey_key="\header"
        oldheader=RegWsh.RegRead(hkey_root+hkey_path+hkey_key)
        hkey_key="\footer"
        oldfooter=RegWsh.RegRead(hkey_root+hkey_path+hkey_key)

        'hkey_key="\margin_left" '��
        'message = message & "��:" & RegWsh.RegRead( hkey_root+hkey_path+hkey_key) & vbCrLf
        'hkey_key="\margin_right" '��
        'message = message & "��:" & RegWsh.RegRead( hkey_root+hkey_path+hkey_key) & vbCrLf
        'hkey_key="\margin_top" '��
        'message = message & "��:" & RegWsh.RegRead( hkey_root+hkey_path+hkey_key) & vbCrLf
        'hkey_key="\margin_bottom" '��
        'message = message & "��:" & RegWsh.RegRead( hkey_root+hkey_path+hkey_key) & vbCrLf
        '
        'msgbox (message)
    end function

    function printPage()
		pagesetup_get()         '��ȡ��ֵ
		header=""
		footer=""
		pagesetup_get()
		pagesetup_set header, footer
		divButton.style.display = "none"
    	        window.print()
		pagesetup_set oldheader, oldfooter            '�ָ�����
    end function
</script>

<html:html locale="true">
<head>
    <app:css />

  <title><bean:message key="title.registBeforeEdit.queryRegist"/></title>
  
  <html:base/>
</head>

<body >
<input type="hidden" name="pageFlag">
<!---add by zhaolu 20060802 start--->
<form name="fm" action="/claim/RegistQuery.do"  method="post">
<!---add by zhaolu 20060802 start---> 
  <table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
    <tr>
      <td>
        <div align="center" id="divButton" style="display:none">
        <input class="button" type="button"  name="buttonPrint" value=" �� ӡ "  onclick="printPage()">
        </div>
      </td>
    </tr>
  </table>

  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr>

            <td colspan="6" class="formtitle">������ѯ�����Ϣ</td>

          </tr>
     <tr>
        <td class="centertitle" >����״̬</td>
        <td class="centertitle" ><bean:message key="db.prpLregist.registNo"/></td>
        <td class="centertitle" ><bean:message key="db.prpLregist.policyNo"/></td>
        <td class="centertitle" >������������</td>
        <td class="centertitle" ><bean:message key="db.prpLregist.operatorCode"/></td>
        <td class="centertitle" >����ʱ��</td>
     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="prpLregistDto"  property="registList">
     <logic:iterate id="prpLregist1"  name="prpLregistDto"  property="registList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
        <td align="center">
        
         <logic:equal name="prpLregist1" property="cancelDate" value="" >
      
              <logic:equal name="prpLregist1" property="status" value='1' >
               δ����
              </logic:equal>
              <logic:equal name="prpLregist1" property="status" value='2' >
               ������
              </logic:equal>
              <logic:equal name="prpLregist1" property="status" value='3' >
               �Ѵ���
              </logic:equal>
              <logic:equal name="prpLregist1" property="status" value='4' >
               ���ύ
              </logic:equal>
              <logic:equal name="prpLregist1" property="status" value='5' >
               �ѳ���
              </logic:equal>
         </logic:equal>
        
         <logic:notEqual name="prpLregist1" property="cancelDate" value="" >
            ��ע��
         </logic:notEqual>
        </td>
        </td>
        <td align="center"><a href="/claim/registFinishQueryList.do?prpLregistRegistNo=<bean:write name='prpLregist1' property='registNo'/>&editType=<bean:write name='prpLregistDto' property='editType'/>&riskCode=<bean:write name="prpLregist1" property="riskCode"/>"> <bean:write name="prpLregist1" property="registNo"/></a></td>
        <!--add by zhouliu start at 2006-6-9
            reason:ǿ����ѯ
        -->
        <td align="center">
        	<logic:iterate id="currelatepolicyNo"  name="prpLregist1"  property="relatepolicyNo">
        		<bean:write name="currelatepolicyNo"/><br>
        	</logic:iterate>
        	
        </td>
        <!--add by zhouliu end at 2006-6-9-->
        
        <td align="center"><bean:write name="prpLregist1" property="insuredName"/></td>
        <td align="center"><bean:write name="prpLregist1" property="receiverName"/></td>
        <td align="center"><bean:write name="prpLregist1" property="operateDate"/></td>
      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
      <tr class="listtail">
        <td colspan="5">
        <!---add by zhaolu 20060802 start--->
         <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>   
                  <bean:define id="pageview" name="prpLregistDto" property="turnPageDto"/>  
<% 
  PrpLregistDto prpLregistDto = (PrpLregistDto)request.getAttribute("prpLregistDto"); 
  int curPage = prpLregistDto.getTurnPageDto().getPageNo(); 
%>                   
                  <%@include file="/common/pub/TurnOverPage.jsp" %>   
              </tr> 
          </table>
        </td>
      </tr>
  </table>
    </table>
    </tr>
  </table>
<input type="hidden" name="editType" value="<%=request.getParameter("editType")%>">
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</form>
<!---add by zhaolu 20060802 start--->
</body>
</html:html>