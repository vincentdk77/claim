<%--
****************************************************************************
* DESC       �������˻ض���¼��/�޸�ҳ��
* AUTHOR     ��lixiang
* CREATEDATE ��2006-04-17
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
    <!--��title����-->
    <title>
    	������˴���
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script language="javascript">
  <!--
  function saveForm()
  {
    var haveCompensate=fm.haveCompensate.value;
    var permitBack=fm.permitBack.value
    var rowcount=fm.txtcertaadd.length;
    var nowrow=1;
    
    if (permitBack=="0"){
       alert("�˰����Ѿ����ύ�ļ����飬���ܽ���������˲�������ϸ���Բ鿴����������!");
       return false;
    }
    
    if ((haveCompensate=="1")&&(!window.confirm("�����˻أ�ԭ�м�������Ϣ���ٱ�������ȷ���Ƿ������"))){
		    return false;
		   }
		var haveselect=-1;   
		for(nowrow=1;nowrow<rowcount;nowrow++){
		  if (fm.txtcertaadd[nowrow].checked==true){
         haveselect=1;
         fm.selectCerta[nowrow].value="1";
      }
		}
		
		if (haveselect==-1){
		   alert("������ѡ��һ���ɹ����˵Ķ�������!");
       return false;
		}   
    fm.submit();//�ύ
  }
-->
  </script>
</head>

<body class="interface" onload="initPage();">
<form name=fm action="/claim/compensateBackSave.do" method="post" onsubmit="return validateForm(this);">
        <table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
    <tr>
      <td width="30%">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr> 
            <td width ="12"><img src=" images/bgBarLeft.gif" width="12" height="19"></td>
            <td class="formtitle">������˴���</td>
            <td width ="11"><img src=" images/bgBarRight.gif" width="11" height="19"></td>
          </tr>
        </table> 
      </td>
            <input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
          <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
     
      <td width="70%" align="right"><font color="#666666">��ע����<font color="#FF0000">*</font>��Ϊ��ѡ���<img src=" images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">��
      Ϊ˫��ѡ���</font>
      </td>
    </tr>
  </table> 
  
  <table border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" style="width:100%">
    <tr>
      <td class="title" colspan="4" style="width:100%">������˴���
    </tr> 
    <tr>
      <td class="title" style="width:15%">������:</td>   
      <td class="input" style="width:35%">    
        <input type=text name="prpLverifyLossPolicyNoShow" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='policyNo'/>">     
      </td>  
      <td class="title" style="width:15%" style="valign:bottom" >������:</td>
      <td class="input" style="width:35%">   
        <input type=text name="prpLverifyLossClaimNoShow" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='claimNo'/>">             
        <input type="image" name="btRelate" src=" images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLverifyLossPolicyNoShow.value);return false;">
      </td> 
    </tr>          
    <tr>
      <td class="title" style="width:15%">������:</td>  
      <td class="input" style="width:35%" >  
        <input type=text name="prpLverifyLossRegistNoShow" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='registNo'/>">     
      </td> 
        <td class="title" style="width:15%">�˻�ԭ��:</td>
          <td class="input" style='width:35%' >
                  <html:select name="prpLverifyLossDto" property="compensateOpinion"  style="width:85%" >
                      <html:options collection="compensateBackOptionsList" property="value" labelProperty="label"/>
                  </html:select>     
          </td>
     </tr>
     
     <tr>
      <td class="title" style="width:15%">�������ʱ��:</td>   
      <td class="common" style="width:35%">    
       <input name="prpLverifyLossCompensateBackDate"  class="readonly" readOnly description="�������ʱ��" onkeypress="return pressFullDate(event);" value="<bean:write name='prpLverifyLossDto' property='compensateBackDate'/>" >        
      </td>   
          
      <td class="title" style="width:15%" style="valign:bottom" >���������Ա:</td>
      <td class="common" style="width:35%">   
        <input name="prpLverifyLossCompensateApproverCode"  class="readonly" readonly maxlength=10 style="width:40%"  value="<bean:write name='prpLverifyLossDto' property='compensateApproverCode'/>">         
        <input name="prpLverifyLossCompensateApproverName"  class="readonly" readonly maxlength=30 style="width:45%" value="<bean:write name='prpLverifyLossDto' property='compensateApproverName'/>"> 
      </td>
     </tr> 
     
     
 </table> 
 <input name="permitBack"  type=hidden value="<bean:write name='prpLverifyLossDto' property='flag'/>">     
   
  <logic:empty  name="prpLcompensateDto" property="compensateList">
    <input name="haveCompensate"  type=hidden value="0">         
  </logic:empty>
  <logic:notEmpty  name="prpLcompensateDto" property="compensateList">
   <input name="haveCompensate"  type=hidden value="1">         
     <table  align="center" border="0" cellpadding="0" cellspacing="1" bgcolor="#2D8EE1" class="title" width="100%">
     <tr>
      <td style="width:100%">
        <%@include file="/common/compensate/CompensateMainBeforeEdit.jsp" %>
      </td>
     </tr>
  </table>
</logic:notEmpty>
 </br>
 <table id="CertainLoss" align="center" border="0" cellpadding="0" cellspacing="0" bgcolor="#2D8EE1" class="title" width="100%">
  <tr>
    <td style="width:100%">
    <input type="hidden" name="carLossSize" value="1">
    
    <table  border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#2D8EE1" class="title" width="100%" >
      <tr>
        <td class="common" style="text-align:left;" colspan="3">�����˻�ѡ��</td>
      </tr>
      <tr class="common" style="display:none">
      <td colspan="3"> <input type="checkbox"  name="txtcertaadd"  style="width:15px"> 
      <input type="hidden"  name="lossitemCode"  value="">
      <input type="hidden"  name="nodeType"  value="">
      <input type="hidden"  name="selectCerta"  value="">
      
      
      </td><%//�������õ�%>
      
      </tr>
      <tr>   
        <td class="centertitle" style="width:1%">���</td>
        <td class="centertitle" style="width:15%">���</td>
        <td class="centertitle" style="width:55%">��������</td>
        
      </tr>
      
<% int index1=0;
   String lossItemTitle=""; //�������
   String lossItemStr="";   //�����ʾ
   String nodeType="";//
%>
<logic:notEmpty  name="prpLverifyLossDto"  property="verifyLossList">
         <logic:iterate id="verifyLoss" name="prpLverifyLossDto" property="verifyLossList">
<%
    if(index1 %2== 0){
        out.print("<tr class=oddrow>");
    }
    else{
        out.print("<tr class=oddrow>");
    }
%>
        <logic:equal name="verifyLoss" property="lossItemCode" value="-1">
        <% lossItemTitle="�Ʋ�";
           nodeType="propc";%>
        </logic:equal>
        
        <logic:equal name="verifyLoss" property="lossItemCode" value="0">
        <% lossItemTitle="����";
           nodeType="wound";%>
        </logic:equal>
        
        <logic:equal name="verifyLoss" property="lossItemCode" value="1">
        <% lossItemTitle="��ĳ���";
           nodeType="certa";%>
        </logic:equal>
        
        <logic:greaterThan name="verifyLoss" property="lossItemCode" value="1">
        <% lossItemTitle="���߳���";
          nodeType="certa";%>
        </logic:greaterThan>
    
         <td class="title" style="text-align:center"><input type="checkbox"  name="txtcertaadd"  checked style="width:15px"  >&nbsp;<%=index1+1%></td>
         <td class="title" ><%=lossItemTitle%>��<bean:write name='verifyLoss' property='lossItemName'/></td>
        <td class="title"><%=lossItemTitle%>����
        <input type="hidden"  name="lossitemCode"  value="<bean:write name='verifyLoss' property='lossItemCode'/>">
        <input type="hidden"  name="nodeType"  value="<%=nodeType%>">
        <input type="hidden"  name="selectCerta"  value="">
  
        </td>
       </tr>
  <%    index1++;%>
</logic:iterate>
</logic:notEmpty>     
  </table>
  </td>
  </tr>
  </table>
  
  
 <table class="common" align="center" >
  <tr>
    <td>
      <input  type="hidden" name=buttonSaveType value="2">
    </td>
   </tr> 
   <tr>
     <td class=button style="width:20%" align="center">
       <!--���水ť-->
        <input type="button" name=buttonSave class='button' value="ȷ��" onclick="return saveForm();">
     </td>
     
     <td class=button style="width:33%" align="center">
           <!--ȡ����ť-->
          <input type=button name=buttonCancel class='button' value="����" onclick="history.back();">         
      </td>
   </tr>
   </table>   
   
       
 </form>
</body>

</html:html>
