<%--
****************************************************************************
* DESC       ��������ѯ�����ʾҳ��
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
<!---add by zhaolu 20060802 start --->
<%@ page import="com.sinosoft.claim.dto.domain.PrpLclaimDto" %>
<%@ page import="com.sinosoft.claim.ui.control.action.UICodeAction" %>
<%@ page import="java.util.*" %>
<!---add by zhaolu 20060802 end--->
<%
    //ԭ����ҳ��������һ����ӡ��ť
%>
<!---modify by zhaolu 20060802 start --->
 <script src="/claim/common/js/showpage.js"> </script>
 <!---modify by zhaolu 20060802 end --->
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
		queryTable.style.display = "none"
		queryButton.style.display = "none"
    	        window.print()
		pagesetup_set oldheader, oldfooter            '�ָ�����
    end function

</script>

<script  type="text/javascript">
    	function submitForm(){
              fm.queryButton.disabled=true;
	          fm.submit();//�ύ
	          setTimeout('fm.queryButton.disabled=false',5000);
    		  //return true ;
    		
    	}
    </script>
<html:html locale="true">
<head>
    <app:css />
   
  <title><bean:message key="title.claimBeforeEdit.queryClaim"/></title>
  
  <html:base/>
</head>

<body  >
<!--modify by liuyanmei add 20051108 start----------------->
<!---<form name="fm" action="/claim/ClaimQuery.do?editType=claimTimeOut&nodeType=claim"  method="post"  validateForm(this);>--->
<form name="fm" action="/claim/ClaimQuery.do" method="post">
<input type="hidden" name="pageFlag">
<input type="hidden" name="isFirst" value="N" />
<!--add by zhouliu start at 2006-6-9-->
<logic:empty name="type">
<!--add by zhouliu end at 2006-6-9-->
    <table id="queryTable" width="100%" border="0" align="center" cellpadding="4" cellspacing="1"  class="common">
      <tr>

	          <td colspan="4" class="formtitle">��ѯ��ʱ������Ϣ</td>

	        </tr>
      <tr>
        <td class='title' ><bean:message key="db.prpLclaim.claimNo" />��</td>
        <td class='input' >
        <select class=tag name="ClaimNoSign" >
            <option value="=">=</option>
          </select> <input type=text name="ClaimNo" class="query" >
        </td>
        <td class='title' ><bean:message key="db.prpLclaim.policyNo" />��</td>
        <td class='input' >
        <select class=tag name="PolicyNoSign" >
            <option value="=">=</option>
          </select> <input type=text name="PolicyNo" class="query" >
        </td>
      </tr>
      <tr>  
        <td class='title' >�����������ƣ�</td>
        <td class='input' >
          <select class=tag name="InsuredNameSign" >
            <option value="=">=</option>
          </select> <input type=text name="InsuredName" class="query" >
        </td>
        <td class='title' >����:</td>
        <td class='input' >  
             <select class=tag name="RiskCodeSign" >
                <option value="=">=&nbsp;</option>
             </select> <input type=text name="RiskCode" class="query" > </td>
      </tr>
      </table>
      <table width=100%>
      <tr>
       <td class='button' colspan="4">
          <input type=submit class='button' name="queryButton" value="<bean:message key='button.query.value' />" onclick="submitForm();">
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input class="button" type="button"  name="divButton" value=" �� ӡ "  onclick="printPage()">
         </td>
      </tr>
    </table>
	<!--add by zhouliu start at 2006-6-9-->
  </logic:empty>
  <!--add by zhouliu end at 2006-6-9-->
  
<%
	String isFirst = request.getParameter("isFirst");
	//�Ƿ��һ�ν�������һ�ν�������ѯ���    End
	if("N".equals(isFirst)){
%>
  
  <table  class="common" cellpadding="5" cellspacing="1" >

<% 
  PrpLclaimDto prpLclaimDto = (PrpLclaimDto)request.getAttribute("prpLclaimDto"); 
  int curPage = prpLclaimDto.getTurnPageDto().getPageNo(); 
  UICodeAction uiCodeAction = new UICodeAction();
  Iterator iterator = prpLclaimDto.getClaimList().iterator();
%> 

<!--modify by liuyanmei add 20051108 end----------------->
 <!-- <table class="common" cellpadding="5" cellspacing="1" >-->
  <tr><td colspan=5 class="formtitle">������ѯ�����Ϣ</td></tr>
     <tr>
        <td class="centertitle" >����״̬</td>
        <td class="centertitle" ><bean:message key="db.prpLclaim.claimNo"/></td>
        <td class="centertitle" >������</td>
        <td class="centertitle" >����Ա</td>
        <td class="centertitle" >����ʱ��</td>
     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="prpLclaimDto"  property="claimList">
     <logic:iterate id="prpLclaim1"  name="prpLclaimDto"  property="claimList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
        <td align="center">
       
       <logic:equal name="prpLclaim1" property="caseType" value="" >
        <logic:equal name="prpLclaim1" property="status" value='1' >
         δ����
        </logic:equal>
        <logic:equal name="prpLclaim1" property="status" value='2' >
         ������
        </logic:equal>
        <logic:equal name="prpLclaim1" property="status" value='3' >
         �Ѵ���
        </logic:equal>
        <logic:equal name="prpLclaim1" property="status" value='4' >
         ���ύ
        </logic:equal>
        <logic:equal name="prpLclaim1" property="status" value='5' >
         �ѳ���
        </logic:equal>
        
        </logic:equal>
         
        
        <logic:equal name="prpLclaim1" property="caseType" value="0" >
         ��ע��
        </logic:equal>
        <logic:equal name="prpLclaim1" property="caseType" value="1" >
         �Ѿ���
        </logic:equal>
         <logic:equal name="prpLclaim1" property="caseType" value="2" >
         �ѽ᰸
        </logic:equal>
       
        
        </td>
        <td align="center"><a href="/claim/claimFinishQueryList.do?prpLclaimClaimNo=<bean:write name='prpLclaim1' property='claimNo'/>&editType=SHOW&riskCode=<bean:write name="prpLclaim1" property="riskCode"/>"><bean:write name="prpLclaim1" property="claimNo"/></a></td>
        <td align="center"><bean:write name="prpLclaim1" property="registNo"/></td>
        <td align="center"><%=uiCodeAction.translateUserCode(((PrpLclaimDto)iterator.next()).getOperatorCode(),true ) %></td>
        <td align="center"><bean:write name="prpLclaim1" property="operateDate"/></td>
      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
      <tr class="listtail">
	      <td colspan="5">
	      <!---add by zhaolu 20060802 start --->
	       <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>   
                  <bean:define id="pageview" name="prpLclaimDto" property="turnPageDto"/>  
                  
                  <%@include file="/common/pub/TurnOverPage.jsp" %>   
              </tr> 
          </table>
          <!--- add by zhaolu 20060802 end --->
	      </td>
      </tr>
  </table>
<%
	}
%>
 <!---add by zhaolu 20060802 start --->
<input type="hidden" name="editType" value="<%=request.getParameter("editType")%>">
</form>
<!---add by zhaolu 20060802 end --->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>