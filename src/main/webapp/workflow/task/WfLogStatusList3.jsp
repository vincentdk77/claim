<%--
****************************************************************************
* DESC       : �������ڵ�״̬��ѯ���ҳ��
* AUTHOR     : liubvo
* CREATEDATE ��2004-08-16
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="com.sinosoft.claim.dto.custom.UserDto" %>
<%@ page import = "com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.UICodeAction"%>
<%   
String comLevel =(String)request.getAttribute("comLevel");
UICodeAction uiCodeAction=new UICodeAction();
%> 
<html:html locale="true">
<head>
    <app:css />
  <title>
    <!-- ���ݽڵ��������ʾ���� -->
    �������ڵ�״̬
  </title>
    <script src="/claim/workflow/task/js/WfLogStatusList.js"> </script>
    <script src="/claim/common/js/showpage.js"> </script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script language="javascript">
  <!--
  function submitForm()
  {
  //if(fm.Fname != null && trim(fm.Fname.value).length != 0)
  //{
  //  if(fm.EarLabel != null && trim(fm.EarLabel.value).length == 0)
  //  {
  //   alert("ũ��������Ϊ��ʱ�������������ţ�");
  //   return false;
  //  }
  //}
  if(fm.EarLabel !=null && trim(fm.EarLabel.value).length<4 && trim(fm.EarLabel.value).length>0)
       {
           alert("����ų��Ȳ���С��4λ");
           return false;
       }
      if(fm.FamilyNo !=null && trim(fm.FamilyNo.value).length<4 && trim(fm.FamilyNo.value).length>0)
       {
            alert("����ų��Ȳ���С��4λ");
            return false;
        }
       if(fm.FCardID!=null && trim(fm.FCardID.value).length<6 && trim(fm.FCardID.value).length>0)
       {
           alert("ũ�����֤�ų��Ȳ���С��6λ");
           return false;
       }
        if(fm.FamilyFIDCard !=null && trim(fm.FamilyFIDCard.value).length<6 && trim(fm.FamilyFIDCard.value).length>0)
        {
            alert("�������֤�ų��Ȳ���С��6λ");
            return false;
        }
    progressStart();
    fm.searchFlag.value="true";
    fm.submit();//�ύ
  }
  //�м����黹û����ͨ���Ͳ����ڳ�������
  function compeCount(count) {
      if (count > 0) {
      alert ("�˰�������δ����ͨ����δ�ύ�ļ����飬�����ٳ������顣")
      return false;
      }
      return true;
  }
  //�Ѿ�ע���ı�����������
  function otherFlag(otherFlag) {
      if (otherFlag == "1") {
          alert("�˱����ѱ�ע��������������");
          return false;
      }
      return true;
  }
  function showCheckTurn(field){
     var strCheck = field;
   var returnValues = window.showModalDialog(strCheck,window,"dialogWidth=600px;dialogHeight=300px");
    window.location.reload();
  }
  //-->
  </script>
 <html:base target="_self"/>
</head>

<body  onload="ShowAlertMessage();progressStop();">
<%
  int index=0;
  String strindex="";
  String searchField=request.getParameter("searchField");
  String searchLabel=request.getParameter("searchLabel");
  System.err.println("-------------------------------------------------------------------------------");
  if (searchField==null) searchField="businessNo";
  if (searchLabel==null) searchLabel="businessNo";

  String nodeStatus=request.getParameter("status");
  String nodeType=request.getParameter("nodeType");
  String editType=request.getParameter("editType");
  String isFirst = request.getParameter("isFirst");
  if(editType == null)  editType = "";
    if(nodeType==null){
    nodeType="commo";
  }
  String funcName = request.getParameter("FuncName"); //��ʾ��ע������/�����ⰸ�����.
  String funcDesc="";
  int      intriskcode=5;

  if (funcName!=null&& funcName.equals("")){
  if (funcName.equals("cancelApply")) funcDesc="(ע��/��������)";
  if (funcName.equals("specialApply")) funcDesc="(Ԥ�ⰸ����)";
  }

  SwfLogDto swfLogDto = null;
  SwfLogDto swfLogDto1 = (SwfLogDto)request.getAttribute("swfLogDto");
  String msg = "\n"+swfLogDto1.getAlertMessage();

  //modify by luqin 2005-04-08 start
  //reason: ������Ϊ�����ж�ҳ����ת
  String riskCode="";
  //modify by luqin 2005-04-08 end
  String strTitle="";
  String subTitleTime="";
  String subTitleColName="";
  String nowNodeStatus=""; //��ÿ��״̬�ж��õ�
  int colNumber=5;         //���������� ������ʾ��5��
  String carFlag1="" ;     //��ʾ�Ƿ��Ǳ�������
  String carFlag="" ;      //��ʾ�Ƿ��Ǳ�������
  String typeFlag="";      //��ʾÿ�е�typeflag������
  String dealHref="";      //�����ܣ���ť�ϵ�����
  String backHref="";      //������˵Ĺ��ܣ���ť�ϵ�����
  String dispHref="";      //��ʾ����������
  String flowStr="";       //��������flowid��logNo�ĺ���ִ������ּ���riskCode��editType,��Ϊÿ�������ݵ�
  String EditLastType="";  //������ʱ����editType�ķ�ʽ��
  int afterDay=0;          //����������������ȥ������
  int afterHour=0;       //����������������ȥ��Сʱ
  int claimLimit=Integer.parseInt(AppConfig.get("sysconst.ClaimLimitHour")); //�������ʱ����
  String toDoTitle="ҵ���"; //��������ʾ��ҵ��ŵ�����
  if (nodeStatus.equals("2")){
    strTitle="���ڴ���";
    subTitleTime="����ʱ��";    
    if(editType.equals("DELETE")){
      editType="DELETE";
    }else{
      editType="EDIT";
    }
  }
  if (nodeStatus.equals("3")){
    strTitle="���˻�";
    subTitleTime="�˻�ʱ��";
    editType="EDIT";
  }
  if (nodeStatus.equals("4")){
    strTitle="�Ѵ���";
    subTitleTime="����ʱ��";
    editType="SHOW";
  }
  if (nodeStatus.equals("0")){
    strTitle="δ����";
    subTitleTime="����ʱ��";
    editType="ADD";
  }
  if (nodeStatus.equals("-1")){
    strTitle="";
    subTitleTime="����ʱ��";
    editType="CANCEL";
  }
  if (nodeStatus.equals("99")){
    strTitle="";
    subTitleTime="����ʱ��";
    editType="SHOW";
    colNumber=6;
  }
%>

<input type="hidden" name="testMessage" class="common" value=<%=msg%>>
<form name="fm" action="/claim/wfLogQuery.do"  method="post" onsubmit="return validateForm(this);">
    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr>  <td colspan=4 class="formtitle">��ѯ����</td></tr>
      <tr>
        <td class='title'>
           <% if (searchLabel.equals("businessNo")) subTitleColName="ҵ���:"; %>
           <% if (searchLabel.equals("businessNo") && nodeType.equals("claim") && !nodeStatus.equals("-1")) subTitleColName="������:"; %>
           <% if (searchLabel.equals("businessNo") && (nodeType.equals("claim") || nodeType.equals("compe")) && nodeStatus.equals("-1"))  subTitleColName="������:";%>
           <% if (searchLabel.equals("registNo")) subTitleColName="������:"; %>
           <% if (searchLabel.equals("claimNo")) subTitleColName="������:"; %>
           <% if (searchLabel.equals("compensateNo")) subTitleColName="���������:"; %>
           <% if (searchLabel.equals("endCaseNo")) subTitleColName="�᰸��:"; %>
           <% if (searchLabel.equals("specialNo")) subTitleColName="����鵵��:"; %>
           <%=subTitleColName%>
           <% 
             //--------------------------------------
                 String insuredName1=request.getParameter("insuredName");  
                 if (insuredName1==null) insuredName1="";
                 String insuredNameSign1=request.getParameter("insuredNameSign");
                 if (insuredNameSign1==null) insuredNameSign1="";
                 
                 String conSignType = request.getParameter("conSignType");
                 if (conSignType==null) conSignType="";
           //-------------------------------------------------
              //modify by qinyongli  2005/7/15 �������ֲ�ѯ
              String searchContent1=request.getParameter("BusinessNo");
              String searchContent2=request.getParameter("PolicyNo");
              String searchContent3=request.getParameter("RiskCode");
              String searchContentSign1=request.getParameter("BusinessNoSign");
              String searchContentSign2=request.getParameter("PolicyNoSign");
              String searchContentSign3=request.getParameter("RiskCodeNoSign");
              String signselect="";
              //���ִ���
              String strClaimRiskType = request.getParameter("RiskClaimType");
              
              String searchContent4=request.getParameter("ClaimRegistNo");          //add by liuyanmei
              String searchContentSign4=request.getParameter("ClaimRegistNo");      //add by liuyanmei
              if (searchContent4==null) searchContent4="";                          //add by liuyanmei
              if (searchContentSign4==null) searchContentSign4="";                  //add by liuyanmei
             
              String searchContent5=request.getParameter("CompeRegistNo");          //add by liuyanmei
              String searchContentSign5=request.getParameter("CompeRegistNoSign");  //add by liuyanmei
              if (searchContent5==null) searchContent5="";                          //add by liuyanmei
              if (searchContentSign5==null) searchContentSign5="";                  //add by liuyanmei
              
              String searchContent6=request.getParameter("ComppRegistNo");          //add by liuyanmei
              String searchContentSign6=request.getParameter("ComppRegistNoSign");  //add by liuyanmei
              if (searchContent6==null) searchContent6="";                          //add by liuyanmei
              if (searchContentSign6==null) searchContentSign6="";                  //add by liuyanmei
              
              String searchContent7=request.getParameter("EndcaRegistNo");          //add by liuyanmei
              String searchContentSign7=request.getParameter("EndcaRegistNoSign");  //add by liuyanmei
              if (searchContent7==null) searchContent7="";                          //add by liuyanmei
              if (searchContentSign7==null) searchContentSign7="";                  //add by liuyanmei
                  
              if (searchContent1==null) searchContent1="";
              if (searchContent2==null) searchContent2="";
              if (searchContent3==null) searchContent3="";

              if (searchContentSign1==null) searchContentSign1="";
              if (searchContentSign2==null) searchContentSign2="";
              if (searchContentSign3==null) searchContentSign3="";

              if (searchContentSign1.equals("=")) signselect="selected";
           %>
        </td>
        <td class='input'>
          <select class=tag name="BusinessNoSign"  >
            <option value="*">*</option>
            <option value="=" <%=signselect%>>=</option>

          </select> <input type=text name="BusinessNo" class="query"  style="width:70%" value="<%=searchContent1%>">
        </td>
         <%
          signselect="";
          if (searchContentSign2.equals("=")) signselect="selected";
         %>

        <td class='title'>�����ţ�</td>
        <td class='input' >
          <select class=tag name="PolicyNoSign"  value="<%=searchContentSign2%>">
            <option value="*">*</option>
            <option value="=" <%=signselect%>>=</option>
          </select> <input type=text name="PolicyNo" class="query"  style="width:160"   value="<%=searchContent2%>">
        </td>
         <%
          signselect="";
          if (searchContentSign3.equals("=")) signselect="selected";
         %>
      </tr>
      <tr>
        <td class='title'>���ִ��ࣺ</td>
        <td class='input' >
          <select class=tag name="RiskCodeNoSign"  value="<%=searchContentSign3%>">
            <option value="=" <%=signselect%>>=</option>
          </select>
          <select name="RiskClaimType" class="query" style="width: 70%">
                            <option value="">ȫ����</option>
                            <option value="D">����</option>
                            <option value="Y">ˮ��</option>
                            <option value="Q">��ˮ</option>
                            <option value="E">�⽡</option>
                            <option value="H">��ֲ</option>
                            <option value="I">��ֳ</option>
           </select>
          <script type="text/javascript">
          var value= '<%=strClaimRiskType%>';
      var  count = fm.RiskClaimType.length;
          var i; 
          for( i = 0; i < count; i ++){
            if(fm.RiskClaimType[i].value == value){
               fm.RiskClaimType.selectedIndex = i;
               break;
             }
          } 
          </script> 
         <!-- <input type=text name="RiskCode" class="query" style="width:70%"  value="<%=searchContent3%>">  -->
         <%if(nodeType.equals("claim") || nodeType.equals("compe")||nodeType.equals("endca")|| nodeType.equals("compp")){%>
        </td>
         <td class='title' colspan=2><%=subTitleTime%>:
          <input type=text style="width:85" width="30%" value='<bean:write name="startDate"/>' name="statStartDate" class="Wdate"  onfocus="WdatePicker()"> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif"  align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.statStartDate', '2007', '2017')"> -->
          ����
          <input type=text style="width:85"  value='<bean:write name="todayDate"/>' name="statEndDate" class="Wdate"  onfocus="WdatePicker()"> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.statEndDate', '2007', '2017')"> -->
       </td> 
       <%}else{%>
        </td>
         <td class='title' colspan=2><%=subTitleTime%>:
          <input type=text style="width:85" width="30%"  name="statStartDate" class="Wdate"  onfocus="WdatePicker()"> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif"  align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.statStartDate', '2007', '2017')"> -->
          ����
          <input type=text style="width:85"  name="statEndDate" class="Wdate"  onfocus="WdatePicker()"> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.statEndDate', '2007', '2017')"> -->
       </td> 
        <%}%>
      </tr>
      <!--------------------���ӱ������ˣ������Ų�ѯ-start---------------------------------------------->
      <tr>
      <%  System.out.println("---------------------1----------");
       if ( !(searchLabel.equals("compensateNo") && nodeType.equals("compp")) && 
              !(searchLabel.equals("claimNo") && nodeType.equals("claim") )  &&
              !(searchLabel.equals("claimNo") && nodeType.equals("compe") ) &&
              !(searchLabel.equals("claimNo") && nodeType.equals("endca") ) 
            ) { %> 
        <% System.out.println("---------------------2---------");
          signselect="";
          if (insuredNameSign1.equals("=")) signselect="selected";
         %>  
        <td class='title'>�������ˣ�</td>
        <td class='input' >
          <select class=tag name="insuredNameSign"  value="<%=insuredNameSign1%>">
            <option value="*">*</option>
            <option value="=" <%=signselect%>>=</option>
          </select> <input type=text name="insuredName" class="query" style="width:70%"  value="<%=insuredName1%>">
        </td>
        <%  if (nodeType.equals("regis") ) {  
%>  
<tr>      
<td class='title'>����ţ�(������������ֳ��ר��)</td>
<td class='input' >
  <select class=tag name="EarLabelSign" >
    <option value="*">*</option>
    <option value="=">=</option>
  </select> <input type=text name="EarLabel" class="query" >
</td>
<td class='title'>ũ��������(������������ֳ��ר��)</td>
<td class='input' >
<select class=tag name="FnameSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="Fname" class="query" >
</td>
</tr>
<tr>
        <td class='title' >���֤�ţ�(��ֲ��ר��)</td>
        <td class='input' >
          <select class=tag name="FCardIDSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="FCardID" class="query" >
        </td>
        <td class='title'>ũ��������(��ֲ��ר��)</td>
    <td class='input' >
    <select class=tag name="Fname1Sign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="Fname1" class="query" >
    </td>
      </tr>
<%}%>
<%  if (nodeType.equals("verip") ) {  
      if (comLevel.equals("1")){  //�ܹ�˾����Ҫ������
%>        
         <td class='title'>ί�����ͣ�</td>
         <td class='input'>
          <select class=tag name="conSignTypeSign">            
            <option value="=">=</option>
          </select>          
          <select class=query name="conSignType" style="width:160" value="<%=conSignType%>">
             <option value="verpo">���ί��</option>
          </select>        
         </td>
    <%} else { %>
  <td class='title'>ί�����ͣ�</td>
         <td class='input'>
          <select class=tag name="conSignTypeSign">            
            <option value="=">=</option>
          </select>          
          <select class=query name="conSignType" style="width:160" value="<%=conSignType%>">
            <option value="verip">������</option>
            <option value="verpo">���ί��</option>
          </select>        
         </td>
<%}
}else{   
%>        
         <td class='title'></td>
         <td class='input'></td>
      <%  
           }          
         } else  {%>
      <% if (searchLabel.equals("compensateNo") && nodeType.equals("compp") ) { %>
         <td class='title'>�����ţ�</td>
         <td class='input'>
          <select class=tag name="ComppRegistNoSign"  value="<%=searchContentSign6%>">
            <option value="*">*</option>
            <option value="=" <%=signselect%>>=</option>
          </select> <input type=text name="ComppRegistNo" class="query"  style="width:160"   value="<%=searchContent6%>">
        </td>
         
       <% }else if (searchLabel.equals("claimNo") && nodeType.equals("claim") ) { %>
         <td class='title'>�����ţ�</td>
         <td class='input'>
          <select class=tag name="ClaimRegistNoSign"  value="<%=searchContentSign4%>">
            <option value="*">*</option>
            <option value="=" <%=signselect%>>=</option>
          </select> <input type=text name="ClaimRegistNo" class="query"  style="width:160"   value="<%=searchContent4%>">
        </td>
         
       <% } else if (searchLabel.equals("claimNo") && nodeType.equals("compe") ) {   %>
        
         <td class='title'>�����ţ�</td>
         <td class='input'>
          <select class=tag name="CompeRegistNoSign"  value="<%=searchContentSign5%>">
            <option value="=" <%=signselect%>>=</option>
          </select> <input type=text name="CompeRegistNo" class="query"  style="width:160"   value="<%=searchContent5%>">
        </td>
                
       <% } else if (searchLabel.equals("claimNo") && nodeType.equals("endca") ) {  %>
         
         <td class='title'>�����ţ�</td>
         <td class='input'>
          <select class=tag name="EndcaRegistNoSign"  value="<%=searchContentSign7%>">
            <option value="=" <%=signselect%>>=</option>
          </select> <input type=text name="EndcaRegistNo" class="query"  style="width:160"   value="<%=searchContent7%>">
        </td>
            
       <%}
          signselect="";
          if (insuredNameSign1.equals("=")) signselect="selected";
         %>  
        <td class='title'>�������ˣ�</td>
        <td class='input' >
          <select class=tag name="insuredNameSign"  value="<%=insuredNameSign1%>">
            <option value="*">*</option>
            <option value="=" <%=signselect%>>=</option>
          </select> <input type=text name="insuredName" class="query"   value="<%=insuredName1%>">
        </td>
      <%}%>  
       </tr>
      <!--------------------���ӱ������˲�ѯ----end------------------------------------------->
      <tr>
       <td class='button' colspan="4">
          <input type=button name="queryButton" class='button' disabled value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td>
        </tr>   
    </table>
 <app:processBar/>
<%
  //�Ƿ��һ�ν�������һ�ν�������ѯ���    End
  if("N".equals(isFirst)){
%>
  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr><td colspan=12 class="formtitle">
              <!-- ���ݽڵ��������ʾ���� -->
              <%if (swfLogDto1.getNodeType().equals("commo")){
                   strTitle=strTitle+"��Ϣ";
                   subTitleColName="ҵ�����"; 
                }
              if (swfLogDto1.getNodeType().equals("regis")){
                   strTitle=strTitle+"������Ϣ";
                   subTitleColName="������"; 
              }
              if (swfLogDto1.getNodeType().equals("check")){
                   strTitle=strTitle+"�鿱��Ϣ";
                   subTitleColName="������"; 
              }
              if (swfLogDto1.getNodeType().equals("certa")){
                   strTitle=strTitle+"������Ϣ";
                   subTitleColName="������"; 
              }
               if (swfLogDto1.getNodeType().equals("verip")){
                   strTitle=strTitle+"�˼���Ϣ";
                   subTitleColName="������";
              }
               if (swfLogDto1.getNodeType().equals("verif")){
                   strTitle=strTitle+"������Ϣ";
                   subTitleColName="������";
              }

               if (swfLogDto1.getNodeType().equals("propc")){
                   strTitle=strTitle+"�Ʋ�������Ϣ";
                   subTitleColName="������"; 
              }
               if (swfLogDto1.getNodeType().equals("backc")){
                   strTitle=strTitle+"������Ϣ";
                   subTitleColName="������";
              }
               if (swfLogDto1.getNodeType().equals("propv")){
                   strTitle=strTitle+"�Ʋ�������Ϣ";
                   subTitleColName="������"; 
              }
               if (swfLogDto1.getNodeType().equals("claim")){
                   strTitle=strTitle+"������Ϣ";
                   subTitleColName="������";
                   if (nodeStatus.equals("0"))toDoTitle="������";
              }
               if (swfLogDto1.getNodeType().equals("prepa")){
                   strTitle=strTitle+"Ԥ����Ϣ";
                   subTitleColName="������";
              }
               if (swfLogDto1.getNodeType().equals("endca")){
                   strTitle=strTitle+"�᰸��Ϣ";
                   subTitleColName="�鵵��";
             }
               if (swfLogDto1.getNodeType().equals("certi")){
                   strTitle=strTitle+"��֤��Ϣ";
                   subTitleColName="������";
                   if (nodeStatus.equals("0"))toDoTitle="������";
              }
               if (swfLogDto1.getNodeType().equals("compe")){
                   strTitle=strTitle+"������Ϣ";
                   subTitleColName="������";
                   if (nodeStatus.equals("0")) toDoTitle="������";
              }
               if (swfLogDto1.getNodeType().equals("sched")){
                   strTitle=strTitle+"������Ϣ";
                   subTitleColName="������";
                  //if (subTitleTime.equals("����ʱ��")) subTitleTime="ͣ��ʱ��"; 
              }

               if (swfLogDto1.getNodeType().equals("wound")){
                   strTitle=strTitle+"���˸�����Ϣ";
                   subTitleColName="������";
              }
               if (swfLogDto1.getNodeType().equals("cance")){
                   strTitle=strTitle+"ע��/������Ϣ";
                   subTitleColName="������";
              }
               if (swfLogDto1.getNodeType().equals("veriw")){
                   strTitle=strTitle+"���˺�����Ϣ";
                   subTitleColName="������";
              }
               if (swfLogDto1.getNodeType().equals("compp")){
                   strTitle=strTitle+"��������Ϣ";
                   subTitleColName="���������";
              }
               if (swfLogDto1.getNodeType().equals("speci")){
                   strTitle=strTitle+"Ԥ�ⰸ��Ϣ";
                   subTitleColName="Ԥ�ⰸ��";
              }
               if (swfLogDto1.getNodeType().equals("commo")){
                   strTitle=strTitle+"��Ϣ";
                   subTitleColName="ҵ�����";
              }
               if (swfLogDto1.getNodeType().equals("backv")){
                   strTitle=strTitle+"�ط���Ϣ";
                   subTitleColName="������";
              }
               if (swfLogDto1.getNodeType().equals("veric")){
                   strTitle=strTitle+"������Ϣ";
                   subTitleColName="ҵ���";
              } %>
<%=strTitle%>
            </td></tr>
     <tr>
         <td class="centertitle" style="width:4%">���</td>
<%
        if (nodeStatus.equals("0")||nodeStatus.equals("-1")||nodeStatus.equals("99")){
%>
         <td class="centertitle" style="width:10%">״̬</td>
        <td class="centertitle" style="width:16%"><%=toDoTitle%></td>
<%        } else {%>
         <td class="centertitle" style="width:16%"><%=subTitleColName%></td>
<%        }%>
         <td class="centertitle" style="width:16%">��������</td>
         <td class="centertitle" style="width:14%">����</td>
         <td class="centertitle" >��������</td>
<%
        //������������ڵ�
        if(nodeType.equals("claim")&& nodeStatus.equals("0")){
%>
             <td class="centertitle" >ʣ��(��)</td>
<%
          colNumber=colNumber+1; //������1��,����Ƕ���Ļ������붨������
        }
        //������ڶ���ڵ�
        if(nodeType.equals("certa")){
%>
             <td class="centertitle" >�����̶�</td>

             <td class="centertitle" >���ƺ���</td>
             <td class="centertitle" style="width:10%">��������</td>
<%
          colNumber=colNumber+3; //������1��,����Ƕ���Ļ������붨������
        }
 
        //������ں˼۽ڵ�
        if(nodeType.equals("verip")){
%>
             <td class="centertitle" >���ƺ���</td>
             <td class="centertitle" style="width:10%">��������</td>
<%
          colNumber=colNumber+2; //������1��,����Ǻ˼۵Ļ�������˼�����
        }
        //������ں���ڵ�
        if(nodeType.equals("verif")){
%>
             <td class="centertitle" >���ƺ���</td>
             <td class="centertitle" style="width:10%">��������</td>
<%
          colNumber=colNumber+2; //������1��,����Ǻ���Ļ��������������
        }
//������ڻطýڵ�
        if(nodeType.equals("backv")){  %>
             <td class="centertitle" >�ط�����</td>
<%          colNumber=colNumber+1; //������1��,�ط�����
        }
        //������ڲ鿱�ڵ�
        if(nodeType.equals("check")){

        //modify by wangwei modify start 2005-06-12
        //ԭ���⽡��û�г��ƺ�����һ��
            if (request.getAttribute("com.sinosoft.type") != null && request.getAttribute("com.sinosoft.type").equals("acci")) {
            } else {
%>
             <td class="centertitle" >���ƺ���</td>
<%
          colNumber=colNumber+1; //������4��,���복�ƺ����
             }
          //modify by wangwei modify end 2005-06-12

        }
        //������ڼ�������������ⰸ�ڵ�
        if(nodeType.equals("compp")||nodeType.equals("veric")){
%>
             <td class="centertitle" >��������</td>
<%
          colNumber=colNumber+1; //������4��,���복�ƺ����
        }

        if (nodeType.equals("speci")){

          if (nodeStatus.equals("0")){
        %>
          <td class="centertitle" >�ⰸ����</td>
        <%
        }else{
        %>
        <td class="centertitle" >��������</td>
        <%
        }
        colNumber=colNumber+1; //������1��,���복�ƺ����
        }

               //������ڶ�����Ȼ��߲鿱���Ƚڵ�
        if(nodeType.equals("sched")||nodeType.equals("schel")){
%>
             
             <td class="centertitle">���ձ��</td>
<%
           if (nodeStatus.equals("0")){
%>

             <td class="centertitle" style="width:12%">�Ⱥ�</td>
             <td class="centertitle">�Ƿ�鿱����</td>
<%
             colNumber=colNumber+1;
             }
          colNumber=colNumber+2; //������1��,���복�ƺ����
        } %>
     
     <!-------------------��������--------------------------------------->   
     <!--td class="centertitle" >��������</td>       -->
     
     
<%
      //�������������ڵ㣬ȫ����ʾ������Ա��һ��
        if(!nodeType.equals("compe")){
%>
             <td class="centertitle" >������Ա</td>
<%
         }
       //�����˻ؽڵ㣬��־�����˻�   
        if(nodeType.equals("certa")&& nodeStatus.equals("3")){
%>
             <td class="centertitle" >�˻ؽڵ�</td>

<%}   
         //�����������ڵ�
         if(nodeType.equals("compe")){
%>
             <td class="centertitle" >���������</td>
             <td class="centertitle" >������Ա</td>
<%
          colNumber=colNumber+2;
         }

       if(!nodeType.equals("sched")){
%>
        <td class="centertitle" style="width:16%"><%=subTitleTime%></td>
<%     }
         //�������ͨ�ýڵ�
         if(nodeType.equals("commo")){
%>
        <td class="centertitle" style="width:16%">�ڵ�����</td>
<%
          colNumber=colNumber+1;
         }
        if ((nodeStatus.equals("0")||nodeStatus.equals("-1")||nodeStatus.equals("4")) && !nodeType.equals("compp")){
%>
              <td class="centertitle" style="width:5%">����</td>
<%
          colNumber=colNumber+2;
        }
      //���������ֳ�ղ鿱�ڵ�,ת������
        if("check".equals(nodeType)&&!"4".equals(nodeStatus)&&!"5".equals(nodeStatus)){
          if (request.getAttribute("com.sinosoft.type") != null && request.getAttribute("com.sinosoft.type").equals("acci")) {
            } else {
%>
              <td class="centertitle" style="width:5%">ת��</td>
<%
           colNumber=colNumber+1;
          }
        }
%>
     </tr>
<%
     //modify by wangwei modify start 2005-06-
     //ԭ����Ҫ�����⽡�պ��������֣��㲻ͬ���ֵĲ˵�ʱ��ʾ��ͬ��ҳ����Ϣ�����´���������ʾ�⽡�յĽ���.
     SwfLogDto swfLogDtoTmp = (SwfLogDto)request.getAttribute("swfLogDto");
     int countLogDto = swfLogDtoTmp.getSwfLogList().size();
%>
    <logic:notEmpty name="com.sinosoft.type">
    <logic:equal name="com.sinosoft.type" value="acci">
<%
    //modify by lixiang modify start 2006-08-09
    //ԭ���⽡�յ����ӽ��棬���ٴ�ҳ����޸�����
%>
   <%@include file="/workflow/task/AcciWfLogStatusList.jsp" %>
<% //modify by lixiang modify start 2006-08-09 %>
      </logic:equal>
     </logic:notEmpty>
<%
    //modify by wangwei modify start 2005-06-12
    //ԭ�����´���������ʾ�������ʱ�Ľ��档
%>
    <logic:notEqual name="com.sinosoft.type" value="acci">
     <logic:notEmpty  name="swfLogDto"  property="swfLogList">
     <logic:iterate id="swfLogList1"  name="swfLogDto"  property="swfLogList">
<%
     if(index %2== 0)
          out.print("<tr class=listodd>");
     else
          out.print("<tr class=listeven>");

%>
         <td align="center">
             <%=index+1%>
         </td>
<%
      strindex = "'"+String.valueOf(index)+"'";
      //ȡ�ø��е�DTO������ �жϽڵ����ͺ�״̬�����ݲ�ͬ��״̬��ʵ�ֲ�ͬ�İ�Ť����
      swfLogDto = (SwfLogDto) ((ArrayList)swfLogDto1.getSwfLogList()).get(index);
      typeFlag = swfLogDto.getTypeFlag();
      dealHref="";      //�����������
      backHref="";      //��մ�����˵�����
      dispHref="";      //�����ʾ������
      carFlag="���߳�";     //�ж�insureCarFlag������

      EditLastType=editType; //����
      String strRiskTypeNow = uiCodeAction.translateRiskCodetoRiskType(swfLogDto.getRiskCode());
      if (swfLogDto.getInsureCarFlag().equals("1")) carFlag="��ĳ�";
      if (!"D".equals(strRiskTypeNow)) carFlag="";
      
      nowNodeStatus=swfLogDto.getNodeStatus();

      if (nodeStatus.equals("0")||nodeStatus.equals("-1")||nodeStatus.equals("99")){ //�жϵ�ǰ���������������͵ģ���������Ľڵ��״̬
%>

          <td align="center">
<%

      if (nowNodeStatus.equals("3")){

         if (!nodeStatus.equals("-1")){EditLastType="EDIT" ;}
        // EditLastType="EDIT";
%>
      ���˴���
<%
      }

      if (nowNodeStatus.equals("4")){ %>
      ���ύ
      <%}

      if (nowNodeStatus.equals("5")){ %>
      ��ͨ���˻�
      <%}
      if (nowNodeStatus.equals("0")){
%>
      �´���
<%
        if (swfLogDto.getNodeType().equals("cance"))  EditLastType="CANCELEDIT";
      }
             if (nowNodeStatus.equals("2")){ %> ���ڴ���
<%
             }
%>
          </td>
<%
       }
      // �ѹ���������ȵ�Ҳ��Ҫ ���ص�link��
      //modify by lixiang add 20050304 start
      //reason:���봫����������Ĺ���

      flowStr="&swfLogFlowID="+swfLogDto.getFlowID()+"&swfLogLogNo="+swfLogDto.getLogNo()+"&status="+swfLogDto.getNodeStatus()
              +"&riskCode="+swfLogDto.getRiskCode()+"&editType="+EditLastType
              +"&nodeType="+swfLogDto.getNodeType()
              +"&businessNo="+swfLogDto.getBusinessNo()
              +"&keyIn="+swfLogDto.getKeyIn()
              +"&policyNo="+swfLogDto.getPolicyNo()
              +"&modelNo="+swfLogDto.getModelNo()
              +"&nodeNo="+swfLogDto.getNodeNo()
              +"&dfFlag="+swfLogDto.getDfFlag();

       //modify by lixiang add 20050304 end
       //�����Ǹ��ݽڵ����ƵĲ�ͬ������ʾ��һ�еĳ��������ݲ�ͬ����һ����ҵ����룩
       // (nodeStatus.equals("0")&&nowNodeStatus.equals("0")�Ǳ�ʾ�����������е�������
       // nodeStatus.equals("-1") ��ʾ���ǰ���ע����������˵����������ʾ�� %>
          <td align="center">
                  <logic:equal name="swfLogList1" property="nodeType" value="prepa">

<%                if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                        dealHref="/claim/claimFinishQueryList.do?prpLclaimClaimNo="+swfLogDto.getKeyIn()
                                +flowStr;
                        }else if (nodeStatus.equals("-1")){ //ע����������

          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
    }else{

                        dealHref="/claim/claimBeforeCancel.do?ClaimNo="+swfLogDto.getKeyIn()
                                +flowStr;
      }
                        }
                        else if (nowNodeStatus.equals("3")) //�������˻صķ�ʽ
                        {  dealHref="/claim/prepayFinishQueryList.do?prpLprepayPrepayNo="+swfLogDto.getKeyIn()+flowStr;
                        }else
                        {
                          dealHref="/claim/prepayFinishQueryList.do?prpLprepayPrepayNo="+swfLogDto.getKeyIn()+flowStr;
                         }
                         dispHref=swfLogDto.getKeyIn();
                         %>
                      <input name=keyIN  type="hidden"  value=<bean:write name="swfLogList1" property="businessNo"/>>
                  </logic:equal>

                  <logic:equal name="swfLogList1" property="nodeType" value="regis">
                          <% if (nodeStatus.equals("0")){
                          dealHref="/claim/registBeforeEdit.do?prpCmainPolicyNo="+swfLogDto.getBusinessNo()+flowStr;

                          }else{
                          dealHref="/claim/registFinishQueryList.do?prpLregistRegistNo="+swfLogDto.getBusinessNo()+flowStr+"&updateExt=true";
                           }
                          dispHref=swfLogDto.getBusinessNo();
                          %>
                  </logic:equal>


                  <logic:equal name="swfLogList1" property="nodeType" value="veric">
                  <%//��ʱ����������ͨ���Ĺ���
                  if (nodeStatus.equals("99")){
                      if (nowNodeStatus.equals("0")||nowNodeStatus.equals("5")){
                      //businessNoΪ�鵵����
                         dealHref="/claim/compensateFinishQueryList.do?prpLcompensateCompensateNo="+swfLogDto.getBusinessNo()+flowStr;
                         dispHref=swfLogDto.getBusinessNo();
                       }else
                       {
                       //keyOutΪ�鵵����
                         dealHref="/claim/compensateFinishQueryList.do?prpLcompensateCompensateNo="+swfLogDto.getKeyOut()+flowStr;
                         dispHref=swfLogDto.getKeyOut();
                      }

                  }else{
                   dealHref="/claim/compensateApprove.do?prpLcompensateCompensateNo="+swfLogDto.getBusinessNo()
                                +"&keyString="+swfLogDto.getKeyIn()
                                +flowStr;
                   dispHref=swfLogDto.getBusinessNo();
                   }
                  %>
                  </logic:equal>

                  <logic:equal name="swfLogList1" property="nodeType" value="compe">

                  <%--modify by weishixin modify 20050227 start--%>
                  <%--resson:UNIX��Сдһ��--%>
                  <% riskCode=swfLogDto.getRiskCode();
                     //add by lixiang start at 2006-04-17
                  
                     //reason:����ǳ��յģ���������һ�����˶���Ĺ���
                     if ("05".equals(uiCodeAction.translateClassCodeByRiskCode(swfLogDto.getRiskCode()))){
                       backHref="/claim/compensateBackBeforeQuery.do?claimNo="+swfLogDto.getBusinessNo()+"&registNo="+swfLogDto.getRegistNo()+flowStr;
                      }
                     //add by lixiang end at 2006-04-17
                     if("D".equals(strRiskTypeNow)) //add liuyanmei
                     {
                        String   flowStr1="&swfLogFlowID="+swfLogDto.getFlowID()+"&swfLogLogNo="+swfLogDto.getLogNo()+"&status="+swfLogDto.getNodeStatus()
                                 +"&riskCode="+swfLogDto.getRiskCode()+"&editType="+EditLastType
                                  +"&nodeType="+swfLogDto.getNodeType()
                                  +"&businessNo="+swfLogDto.getBusinessNo()
                                  +"&policyNo="+swfLogDto.getPolicyNo()
                                  +"&modelNo="+swfLogDto.getModelNo()
                                  +"&nodeNo="+swfLogDto.getNodeNo();
                         dealHref="/claim/compensateBeforeEditList.do?ClaimNo="+swfLogDto.getKeyIn()+flowStr1 + "&compeCount=" + swfLogDto.getCompeCount();
                     }
                     else{
                     dealHref="/claim/compensateBeforeEdit.do?ClaimNo="+swfLogDto.getKeyIn()+"&caseType="+swfLogDto.getTypeFlag()+flowStr + "&compeCount=" + swfLogDto.getCompeCount();
                     }
                     if (nodeStatus.equals("-1")){ //ע����������     
                             dealHref="/claim/claimBeforeCancel.do?prpLclaimCancelClaimNo="+swfLogDto.getKeyIn()
                                              + "&nodeType=" + request.getParameter("nodeType")
                                              +flowStr;
                                     

                                           }

                    dispHref=swfLogDto.getKeyIn();

                  %>
                  <%--modify by weishixin modify 20050227 end--%>
                  </logic:equal>

                  <logic:equal name="swfLogList1" property="nodeType" value="compp">
                  <% 
                       dealHref="/claim/compensateFinishQueryList.do?prpLcompensateCompensateNo="+swfLogDto.getBusinessNo()+flowStr;
                       dispHref=swfLogDto.getBusinessNo();
                         %>
                  </logic:equal>

                   <logic:equal name="swfLogList1" property="nodeType" value="speci">
                   <%
                   if (nowNodeStatus.equals("0")){
                    if (typeFlag.equals("3")||typeFlag.equals("4") || typeFlag.equals("6")){
                    
                        //�����ⰸ�е�ͨ�ں�Ԥ�����պͷǳ��ղ�ͬ 2005-9-30
                        //modify by lixiang start at 2005-12-20
                        // if ("0501".equals(swfLogDto1.getRiskCode())) { 
                        //modify by lixiang end at 2005-12-20
                        if ("D".equals(strRiskTypeNow)) {  //add liuyanmei
                             dealHref="/claim/compensateBeforeEditList.do?ClaimNo="+swfLogDto.getKeyIn()
                                       +"&caseType="+swfLogDto.getTypeFlag()
                                       +"&ClaimNoSign= ="
                                       +flowStr;
                        } else {
                              dealHref="/claim/compensateBeforeEdit.do?ClaimNo="+swfLogDto.getKeyIn()
                                       +"&caseType="+swfLogDto.getTypeFlag()
                                       +"&ClaimNoSign= ="
                                       +flowStr;
                        }
                        
                    }
                       if (typeFlag.equals("7")||typeFlag.equals("8") || typeFlag.equals("5")){
                       dealHref="/claim/prepayBeforeEdit.do?ClaimNo="+swfLogDto.getKeyIn()
                         +"&caseType="+swfLogDto.getTypeFlag()
                         +flowStr;
                       }
                         dispHref=swfLogDto.getKeyIn();


                   }else{
                         if (typeFlag.equals("3")||typeFlag.equals("4")||typeFlag.equals("6")){
                           dealHref="/claim/compensateFinishQueryList.do?ClaimNo="+swfLogDto.getKeyIn()+"&prpLcompensateCompensateNo="+swfLogDto.getKeyOut()
                                       +"&caseType="+typeFlag+flowStr;
                         }
                         if (typeFlag.equals("7")||typeFlag.equals("8") || typeFlag.equals("5"))
                         {
                           dealHref="/claim/prepayFinishQueryList.do?ClaimNo="+swfLogDto.getKeyIn()+"&prpLprepayPrepayNo="+swfLogDto.getKeyOut()
                                   +"&caseType="+typeFlag+flowStr;
                         }

                         dispHref=swfLogDto.getKeyOut();
                   }
                      %>
                  </logic:equal>

                  <logic:equal name="swfLogList1" property="nodeType" value="claim">
                          <% if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                            dealHref="/claim/claimBeforeEdit.do?RegistNo="+swfLogDto.getKeyIn()+flowStr;
                            dispHref=swfLogDto.getKeyIn();
                           }else if (nodeStatus.equals("-1")){ //ע����������
                             if (!nowNodeStatus.equals("0"))
                             {
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
    }else{
                             dealHref="/claim/claimBeforeCancel.do?ClaimNo="+swfLogDto.getKeyOut()
                                + "&RegistNo="+swfLogDto.getKeyIn()
                                +flowStr;
      }
                             dispHref=swfLogDto.getBusinessNo();
                             }else
                             {
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
    }else{
                              dealHref="/claim/claimBeforeCancel.do?RegistNo="+swfLogDto.getBusinessNo()
                                + "&type=" + request.getAttribute("com.sinosoft.type")
                                +flowStr;}
                             dispHref=swfLogDto.getBusinessNo();
                             }
                            }else{
          if (funcName!=null&&funcName.equals("addLoss")){
        String Lossstr="";
              Lossstr="&swfLogFlowID="+swfLogDto.getFlowID()+"&swfLogLogNo="+swfLogDto.getLogNo()+"&status="+swfLogDto.getNodeStatus()
                      +"&riskCode="+swfLogDto.getRiskCode()+"&editType="+"LOSS"
                      +"&nodeType="+swfLogDto.getNodeType()
                      +"&businessNo="+swfLogDto.getBusinessNo()
                      +"&keyIn="+swfLogDto.getKeyIn()
                      +"&policyNo="+swfLogDto.getPolicyNo()
                      +"&modelNo="+swfLogDto.getModelNo()
                      +"&nodeNo="+swfLogDto.getNodeNo();
                            dealHref="/claim/claimFinishQueryList.do?prpLclaimClaimNo="+swfLogDto.getKeyOut()+Lossstr;
            }else{
                            dealHref="/claim/claimFinishQueryList.do?prpLclaimClaimNo="+swfLogDto.getKeyOut()+flowStr;
              }
                           dispHref=swfLogDto.getKeyOut();
                           }
                         %>
                  </logic:equal>
                  <logic:equal name="swfLogList1" property="nodeType" value="check">
                      <% if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                              dealHref="/claim/checkBeforeEdit.do?RegistNo="+swfLogDto.getKeyIn()
                                  +"&lossItemName="+swfLogDto.getLossItemName()
                                  +"&lossItemCode="+swfLogDto.getLossItemCode()
                                  +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                  +flowStr;
                            dispHref=swfLogDto.getKeyIn();
                           }else if (nodeStatus.equals("-1")){ //ע����������
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
    }else{
                             dealHref="/claim/claimBeforeCancel.do?RegistNo="+swfLogDto.getKeyIn()
                                + "&type=" + request.getAttribute("com.sinosoft.type")
                                +flowStr;}
                             dispHref=swfLogDto.getKeyIn();
                            }else{
                            dealHref="/claim/checkFinishQueryList.do?prpLcheckCheckNo="+swfLogDto.getKeyIn()
                    + "&type=" + request.getAttribute("com.sinosoft.type")
                                    +"&lossItemCode="+swfLogDto.getLossItemCode()
                                    +"&lossItemName="+swfLogDto.getLossItemName()
                                    +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                    +flowStr;
                            dispHref=swfLogDto.getKeyIn();
                           }
                          %>
                  </logic:equal>
                  <logic:equal name="swfLogList1" property="nodeType" value="endca">
                  <%
                     // modify by wangli update start 20050417
                     //dealHref="/claim/endcaseBeforeEdit.do?ClaimNo="+swfLogDto.getKeyIn()+flowStr;
                     dealHref="/claim/endcaseBeforeEdit.do?ClaimNo="+swfLogDto.getKeyIn()+"&ClaimNoSign= ="+"&caseType="+swfLogDto.getTypeFlag()+flowStr;
                     //modify by wangli update end 20050417
                     dispHref=swfLogDto.getKeyIn();
                  %>
                  </logic:equal>

                  <logic:equal name="swfLogList1" property="nodeType" value="certi">
                          <% if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){

                             dealHref="/claim/certifyBeforeEdit.do?RegistNo="+swfLogDto.getKeyIn()+flowStr;
                          }else if (nodeStatus.equals("-1")){ //ע����������

          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
    }else{
                             dealHref="/claim/claimBeforeCancel.do?RegistNo="+swfLogDto.getKeyIn()
                                + "&type=" + request.getAttribute("com.sinosoft.type")
                                +flowStr;}

                            }else{
                             dealHref="/claim/certifyFinishQueryList.do?prpLcertifyCertifyNo="+swfLogDto.getKeyIn()+flowStr;
                          }
                          dispHref=swfLogDto.getKeyIn();
                           %>
                  </logic:equal>
                  <logic:equal name="swfLogList1" property="nodeType" value="certa">
                            <% 
                            if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                                 dealHref="/claim/certainLossBeforeEdit.do?RegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                     +flowStr;
                             }else if (nodeStatus.equals("-1")){ //ע����������
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
    }else{
                             dealHref="/claim/claimBeforeCancel.do?RegistNo="+swfLogDto.getKeyIn()
                                + "&type=" + request.getAttribute("com.sinosoft.type")
                                +flowStr;}

                            }else if (nowNodeStatus.equals("3")) //�������˻صķ�ʽ
                              { dealHref="/claim/certainLossFinishQueryList.do?prpLverifyLossRegistNo="
                                        +swfLogDto.getKeyIn()
                                        +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                        +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                        +"&flag=1"+flowStr;
                              } else
                              {
                              dealHref="/claim/certainLossFinishQueryList.do?prpLverifyLossRegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +flowStr;
                               }

                            dispHref=swfLogDto.getKeyIn();
                            %>
                  </logic:equal>
                  <logic:equal name="swfLogList1" property="nodeType" value="verip">
                           <% if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                              dealHref="/claim/verifyPriceFinishQueryList.do?RegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +flowStr;
                            }else if (nodeStatus.equals("-1")){ //ע����������
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
    }else{
                             dealHref="/claim/claimBeforeCancel.do?RegistNo="+swfLogDto.getKeyIn()
                                + "&type=" + request.getAttribute("com.sinosoft.type")
                                +flowStr;}

                            }else{
                            dealHref="/claim/verifyPriceFinishQueryList.do?prpLverifyLossRegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +"&handleDept="+swfLogDto.getHandleDept()
                                      +"&deptName="+swfLogDto.getDeptName()
                                      +flowStr;
                            }
                            dispHref=swfLogDto.getKeyIn();
                            %>
                  </logic:equal>                  
                  <logic:equal name="swfLogList1" property="nodeType" value="verpo">
                           <% if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                              dealHref="/claim/verifyPriceFinishQueryList.do?RegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +flowStr;
                            }else if (nodeStatus.equals("-1")){ //ע����������
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
    }else{
                             dealHref="/claim/claimBeforeCancel.do?RegistNo="+swfLogDto.getKeyIn()
                                + "&type=" + request.getAttribute("com.sinosoft.type")
                                +flowStr;}

                            }else{
                            dealHref="/claim/verifyPriceFinishQueryList.do?prpLverifyLossRegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +flowStr;
                            }
                            dispHref=swfLogDto.getKeyIn();
                            %>
                  </logic:equal>                  
                  <logic:equal name="swfLogList1" property="nodeType" value="verif">
                           <% if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                              dealHref="/claim/verifyLossFinishQueryList.do?RegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +flowStr;
                            }else if (nodeStatus.equals("-1")){ //ע����������
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
    }else{
                             dealHref="/claim/claimBeforeCancel.do?RegistNo="+swfLogDto.getKeyIn()
                                + "&type=" + request.getAttribute("com.sinosoft.type")
                                +flowStr;}

                            }else{
                            dealHref="/claim/verifyLossFinishQueryList.do?prpLverifyLossRegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +flowStr;
                            }
                            dispHref=swfLogDto.getKeyIn();
                            %>
                  </logic:equal>
                   <% //���˺��������%>
                  <logic:equal name="swfLogList1" property="nodeType" value="veriw">
                            <% if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                              dealHref="/claim/verifyLossFinishQueryList.do?RegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +flowStr;
                            }else if (nodeStatus.equals("-1")){ //ע����������
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
    }else{
                             dealHref="/claim/claimBeforeCancel.do?RegistNo="+swfLogDto.getKeyIn()
                                + "&type=" + request.getAttribute("com.sinosoft.type")
                                +flowStr; }

                            }else{
                            dealHref="/claim/verifyLossFinishQueryList.do?prpLverifyLossRegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +"&flag=1"+flowStr;
                            }
                            dispHref=swfLogDto.getKeyIn();
                            %>
                  </logic:equal>

                  <logic:equal name="swfLogList1" property="nodeType" value="sched">
                          <% 
                  if( nodeStatus.equals("0")&& (nowNodeStatus.equals("0") || nowNodeStatus.equals("3")) ){  
                             dealHref="/claim/registFinishQueryList.do?prpLregistRegistNo="+swfLogDto.getKeyIn()+flowStr;
                             dealHref="/claim/scheduleDealRegist.do?prpLscheduleMainWFRegistNo="+swfLogDto.getKeyIn()
                                     +"&prpLscheduleMainWFSurveyNo=0"
                                     +"&scheduleType=sched"
                                     +"&handleDept="+swfLogDto.getHandleDept()
                                     +"&endflag="+swfLogDto.getEndFlag()
                                     +"&commiFlag=0"
                                     +flowStr;
                             dispHref=swfLogDto.getKeyIn();
                             //if (autoRefresh) SoundFlag =true;
                  }else if (nodeStatus.equals("-1")){ //ע����������
                    if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){ 
                        dealHref="/claim/specailCaseQuery.do?"+flowStr;
                    }else{                                                    
                        dealHref="/claim/claimBeforeCancel.do?RegistNo="+swfLogDto.getBusinessNo()
                                +flowStr;
                    }
                    dispHref=swfLogDto.getBusinessNo();     
                  }else{
                           dealHref="/claim/scheduleFinishQueryList.do?prpLscheduleMainWFRegistNo="+swfLogDto.getBusinessNo()
                                   +"&prpLscheduleMainWFScheduleID=1"
                                   +"&scheduleType=sched"
                                   +"&handleDept="+swfLogDto.getHandleDept()
                                   +"&endflag="+swfLogDto.getEndFlag()
                                   +"&commiFlag=0"
                                   + "&handlerCode=" + swfLogDto.getHandlerCode()
                                   +flowStr;
                           dispHref=swfLogDto.getBusinessNo();
                  }
                  %>  
                  </logic:equal>
                  <logic:equal name="swfLogList1" property="nodeType" value="wound">
<%                 if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                             dealHref="/claim/certainLossBeforeEdit.do?RegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag=0"
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +flowStr;

                            }else if (nodeStatus.equals("-1")){ //ע����������
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
    }else{
                             dealHref="/claim/claimBeforeCancel.do?RegistNo="+swfLogDto.getKeyIn()
                                + "&type=" + request.getAttribute("com.sinosoft.type")
                                +flowStr;}

                            }else if (nowNodeStatus.equals("3")) //�������˻صķ�ʽ
                              {                              dealHref="/claim/certainLossBeforeEdit.do?RegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag=0"
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +"&flag=1"
                                      +flowStr;
                              } else
                              {
                              dealHref="/claim/certainLossFinishQueryList.do?prpLverifyLossRegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag=0"
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +flowStr;
                              }

                             dispHref=swfLogDto.getKeyIn();
 %>
                  </logic:equal>

                  <logic:equal name="swfLogList1" property="nodeType" value="cance">
                  <%
                     if (nodeStatus.equals("0"))
                     {
                     //add by lixiang start at 2006-02-14
                     dealHref="/claim/claimBeforeCancel.do?ClaimNo="+swfLogDto.getKeyIn()+flowStr
                      +"&typeFlag="+swfLogDto.getTypeFlag()+"&flowInTime="+swfLogDto.getFlowInTime();
                     //add by lixiang end at 2006-02-14

                     }else
                     {
                      
                     dealHref="/claim/claimFinishQueryList.do?prpLclaimClaimNo="+swfLogDto.getKeyIn()+flowStr;
                     
                     }

                     dispHref=swfLogDto.getKeyIn();

                  %>
                  </logic:equal>

            <%--modify by liujianbo modify 20050315 start--%>
            <%--resson:��������--%>
                  <logic:equal name="swfLogList1" property="nodeType" value="propc">
<%                 if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                             dealHref="/claim/certainLossBeforeEdit.do?RegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag=0"
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode=-1"
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +flowStr;

                            }else if (nodeStatus.equals("-1")){ //ע����������
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
    }else{
                             dealHref="/claim/claimBeforeCancel.do?RegistNo="+swfLogDto.getKeyIn()
                             + "&type=" + request.getAttribute("com.sinosoft.type")
                                +flowStr;}

                            }else if (nowNodeStatus.equals("3")) //�������˻صķ�ʽ
                              {                              dealHref="/claim/certainLossBeforeEdit.do?RegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag=0"
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode=-1"
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +"&flag=1"
                                      +flowStr;
                              } else
                              {
                              dealHref="/claim/certainLossFinishQueryList.do?prpLverifyLossRegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag=0"
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode=-1"
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +flowStr;
                              }

                             dispHref=swfLogDto.getKeyIn();
 %>
                  </logic:equal>


                  <logic:equal name="swfLogList1" property="nodeType" value="propv">
                            <% if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                              dealHref="/claim/verifyLossFinishQueryList.do?RegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +flowStr;
                            }else if (nodeStatus.equals("-1")){ //ע����������
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
    }else{
                             dealHref="/claim/claimBeforeCancel.do?RegistNo="+swfLogDto.getKeyIn()
                             + "&type=" + request.getAttribute("com.sinosoft.type")
                                +flowStr; }

                            }else{
                            dealHref="/claim/verifyLossFinishQueryList.do?prpLverifyLossRegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +"&flag=1"+flowStr;
                            }
                            dispHref=swfLogDto.getKeyIn();
                            %>
                  </logic:equal>
                  <logic:equal name="swfLogList1" property="nodeType" value="backc">
                            <% if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                              dealHref="/claim/verifyLossFinishQueryList.do?RegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +flowStr;
                            }else if (nodeStatus.equals("-1")){ //ע����������
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
    }else{
                             dealHref="/claim/claimBeforeCancel.do?RegistNo="+swfLogDto.getKeyIn()
                             + "&type=" + request.getAttribute("com.sinosoft.type")
                                +flowStr; }

                            }else{
                            dealHref="/claim/verifyLossFinishQueryList.do?prpLverifyLossRegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +"&flag=1"+flowStr;
                            }
                            dispHref=swfLogDto.getKeyIn();
                            %>
                  </logic:equal>
             <%--modify by liujianbo modify 20050315 end--%>

             <%--Modify by chenrenda add 20050315 begin--%>
             <%--Reason:���ӻطýڵ�  --%>
             <logic:equal name="swfLogList1" property="nodeType" value="backv">
                            <%
                            if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                              dealHref="/claim/backVisitBeforeEdit.do?RegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +flowStr;
                            }else{
                            dealHref="/claim/backVisitBeforeEdit.do?RegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +"&flag=1"+flowStr;
                            }
                            dispHref=swfLogDto.getKeyIn();
                            %>
                  </logic:equal>
             <%--modify by chenrenda add 20050315 end--%>

         <%--value=1 ��ʾ��������Ѿ�ע������������--%>
        <logic:equal name="swfLogList1" property="otherFlag" value="1">
          <logic:equal name="swfLogList1" property="dfFlag" value="Y">
             <a  href="<%=dealHref%>" title="<bean:write name="swfLogList1" property="titleStr"/>"
                onclick="checkDfFlag();return otherFlag('<bean:write name="swfLogList1" property="otherFlag"/>');"><%=dispHref%> </a>
           </logic:equal>
           <logic:notEqual name="swfLogList1" property="dfFlag" value="Y">
             <logic:equal name="swfLogList1" property="dfFlag" value="Y">
             <a  href="<%=dealHref%>" title="<bean:write name="swfLogList1" property="titleStr"/>"
                onclick="checkDfFlag();return otherFlag('<bean:write name="swfLogList1" property="otherFlag"/>');"><%=dispHref%> </a>
           </logic:equal>
           <logic:notEqual name="swfLogList1" property="dfFlag" value="Y">
             <a  href="<%=dealHref%>" title="<bean:write name="swfLogList1" property="titleStr"/>"
                onclick="return otherFlag('<bean:write name="swfLogList1" property="otherFlag"/>');"><%=dispHref%> </a>
           </logic:notEqual>
           </logic:notEqual>
        </logic:equal>
        <logic:notEqual name="swfLogList1" property="otherFlag" value="1">
            <a  href="<%=dealHref%>" title="<bean:write name="swfLogList1" property="titleStr"/>"
                onclick="return compeCount('<bean:write name="swfLogList1" property="compeCount"/>');"><%=dispHref%> </a>
        </logic:notEqual>
        </td>
        <%//�������������%>
        <td align="center">
        <% //modify by lixiang start at 2006-6-5
           //reason :֧�ֶ����������%>
        <logic:iterate id="relatePolicyList1"  name="swfLogList1"  property="relatePolicyList">  
        <bean:write name="relatePolicyList1" property="policyNo"/>
        </logic:iterate>
         <% //modify by lixiang end at 2006-6-5%>
        </td>
        <td align="center"><bean:write name="swfLogList1" property="riskCodeName"/></td>
        <td align="center" width="10%"><bean:write name="swfLogList1" property="insuredName"/></td> 
        <%//����Ƕ�������г������е�����%>
        <logic:equal name="swfLogDto" property="nodeType" value="certa">
           <td align="center">
             <logic:equal name="swfLogList1" property="exigenceGree" value="0">
              ����
              </logic:equal>
             <logic:equal name="swfLogList1" property="exigenceGree" value="1">
              һ��
              </logic:equal>
           </td>
          <logic:notEqual name="swfLogList1" property="insureCarFlag" value="1">
       <%//modify by kangzhen%>
<%
           if("D".equals(strRiskTypeNow))  
           {
%>           
           <td align="center"><bean:write name='swfLogList1' property='lossItemName'/>(���߳�)</td>
           
<%           
           }
           else
           {
%>                    
          <td align="center"></td>
<%           
           }
%>           
          </logic:notEqual>
          <logic:equal name="swfLogList1" property="insureCarFlag" value="1">
           <td align="center"><bean:write name='swfLogList1' property='lossItemName'/></td>
          </logic:equal>
           <td align="center"><%=carFlag%></td>
        </logic:equal>

        <logic:equal name="swfLogDto" property="nodeType" value="verip">
           <td align="center"><bean:write name='swfLogList1' property='lossItemName'/></td>
           <td align="center"><%=carFlag%></td>
        </logic:equal>

        <logic:equal name="swfLogDto" property="nodeType" value="verif">
           <td align="center"><bean:write name='swfLogList1' property='lossItemName'/></td>
           <td align="center"><%=carFlag%></td>
        </logic:equal>

         <%//������������͵ģ�д���������¼����%>
        <logic:equal name="swfLogDto" property="nodeType" value="compe">
           <td align="center"> <a href="/claim/compensateFinishQueryList.do?prpLcompensateCompensateNo=<bean:write name='swfLogList1' property='keyOut'/>&editType=<%=EditLastType%>&riskCode=<bean:write name='swfLogList1' property='riskCode'/><%=flowStr%>"><bean:write name='swfLogList1' property='keyOut'/></a></td>
        </logic:equal>

        <%//����Ǽ��������͵ģ�д��������%>
        <logic:equal name="swfLogDto" property="nodeType" value="compp">
          <td align="center"><a href="/claim/claimFinishQueryList.do?prpLclaimClaimNo=<bean:write name='swfLogList1' property='keyIn'/>&editType=SHOW&riskCode=<bean:write name='swfLogList1' property='riskCode'/><%=flowStr%>" title="<bean:write name="swfLogList1" property="titleStr"/>">
                  <bean:write name='swfLogList1' property='keyIn'/></a>
        </logic:equal> </td>

<%//��������ⰸ�����͵ģ�д��������%>
        <logic:equal name="swfLogDto" property="nodeType" value="speci">
         <td align="center">
           <logic:equal name="swfLogList1" property="nodeStatus" value="0">
                 <logic:equal name="swfLogList1" property="typeFlag" value="3">ͨ��</logic:equal>
                <logic:equal name="swfLogList1" property="typeFlag" value="4">Ԥ��</logic:equal>
                <logic:equal name="swfLogList1" property="typeFlag" value="5">Ԥ��</logic:equal>
                <logic:equal name="swfLogList1" property="typeFlag" value="6">����</logic:equal>
           </logic:equal>

           <% if ((!swfLogDto.getNodeStatus().equals("0"))&&(!swfLogDto.getNodeStatus().equals("3"))){%>
             <a href="/claim/claimFinishQueryList.do?prpLclaimClaimNo=<bean:write name='swfLogList1' property='keyIn'/>&editType=SHOW&riskCode=<bean:write name='swfLogList1' property='riskCode'/><%=flowStr%>" title="<bean:write name="swfLogList1" property="titleStr"/>">
                   <bean:write name='swfLogList1' property='keyIn'/></a>
           <%}%>
            </td>
        </logic:equal>
 <%//����Ǻ������͵ģ�д��������%>
        <logic:equal name="swfLogDto" property="nodeType" value="veric">
          <td align="center">      <a href="/claim/claimFinishQueryList.do?prpLclaimClaimNo=<bean:write name='swfLogList1' property='keyIn'/>&editType=SHOW&riskCode=<bean:write name='swfLogList1' property='riskCode'/><%=flowStr%>" title="<bean:write name="swfLogList1" property="titleStr"/>">
                  <bean:write name='swfLogList1' property='keyIn'/></a>
        </logic:equal> </td>
<%//����ǻط�
if(nodeType.equals("backv")){
String backvType="�鿱�ط�";
  if (swfLogDto.getTypeFlag().equals("2")) backvType="����ط�";
%>
        <td align="center"><%=backvType%></td>
<%
}
%>
         <%//����ǲ鿱���͵ģ�д���峵�ƺ��룬%>
          <logic:equal name="swfLogDto" property="nodeType" value="check">
          <logic:notEqual name="com.sinosoft.type" value="acci">
             <td align="center"><bean:write name='swfLogList1' property='lossItemName'/></td>
           </logic:notEqual>
          </logic:equal>

          <%//����ǲ鿱���͵ģ�д���峵�ƺ��룬�������������Ⱥţ������� %>
          <logic:equal name="swfLogDto" property="nodeType" value="claim">
          <%
               afterDay=0;   //����ʱ���
               afterHour=0;
               if (nodeStatus.equals("0"))
               {
               afterDay=DateTime.intervalDay(new DateTime(swfLogDto.getFlowInTime(),DateTime.YEAR_TO_DAY),swfLogDto.getTimeLimit(),new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY) ,DateTime.current().getHour() ) ;
               //-1����Ϊ�������һ�죬�ǰ���һ�����ģ���Ϊ��Ҫ����Сʱ�����Ծ�Ӧ�ü�Ϊ0���
               afterHour=(afterDay-1) - (swfLogDto.getTimeLimit()+DateTime.current().getHour())/24;
               //ʣ��ʱ�����               
               if(swfLogDto.getRiskCode().substring(0,2).equals("05")){
                 afterHour=5-afterHour;
               }else{
                 afterHour=claimLimit-afterHour;
               }
               %>
               <td align="center"><%=new DecimalFormat("##0.00").format(afterHour)%></td>
               <%
               }
           %>
           </logic:equal>

        <% //������ڶ�����Ȼ��߲鿱���Ƚڵ�
        if(nodeType.equals("sched")||nodeType.equals("schel")){
        %>
        <td align="center"><bean:write name='swfLogList1' property='lossItemName'/></td>
          <% if (nodeStatus.equals("0")){ %>
        <td align="center"><bean:write name='swfLogList1' property='stopTimeDesc'/></td>
          <% 
            if("10".equals(swfLogDto.getTypeFlag())){
          %>
            <td align="center">��</td>
          <%
            }
            else{
           %>
           <td align="center">��</td>
           <%
             }
          }
        }
        %>
        <!--td align="center"><bean:write name="swfLogList1" property="insuredName"/></td> <!-----��������-------------->
        <%//д����������%>
        <td align="center"><bean:write name="swfLogList1" property="handlerName"/></td>
        <%//д����ʱ�����Ϣ%>
        
  <%     //�����˻ؽڵ㣬��־�����˻�   
        if(nodeType.equals("certa")&& nodeStatus.equals("3")){
%>
       <logic:equal name="swfLogList1" property="businessType" value="verip">
        <td align="center" width="5%">�˼�</td>
       </logic:equal>
       <logic:equal name="swfLogList1" property="businessType" value="verif">
        <td align="center" width="5%">����</td>
       </logic:equal>
       <logic:equal name="swfLogList1" property="businessType" value="compe">
        <td align="center" width="5%">����</td>
       </logic:equal>
       
      <% if (swfLogDto.getBusinessType().equals("")){%> 
      <td align="center"></td>
      <%}%>
<%} %>   
 <%        if (!nodeType.equals("sched")){%>
         <td align="center">
         <%
          if (nodeStatus.equals("4")){%>
           <bean:write name='swfLogList1' property='submitTime'/>
          <% } else {
           %>
             <bean:write name='swfLogList1' property='handleTime'/>
          <% }
          //modify by lixiang remark 20050309 end  %>
          <%//����Ϊÿ�������е����ݵľ�����Ϣ%>
          <input name=flowID type="hidden"  value=<bean:write name="swfLogList1" property="flowID"/>>
          <input name=logNo  type="hidden"  value=<bean:write name="swfLogList1" property="logNo"/>>
          <input name=keyIN  type="hidden"  value=<bean:write name="swfLogList1" property="keyIn"/>>
       </td>

 <%}%>
          <logic:equal name="swfLogDto" property="nodeType" value="commo">
              <td align="center"><bean:write name="swfLogList1" property="nodeTypeName"/></td>
           </logic:equal>
<%
       if (nodeStatus.equals("0")){ %>
        <td align="center">
<%           // ���������᰸���ܻ���,Ŀǰֻ�������Ѿ�����Ļ�������
             //��Щ�����ܻ��˵�
             if (swfLogDto.getNodeStatus().equals("3")||swfLogDto.getNodeType().equals("claim")
                ||swfLogDto.getNodeType().equals("sched")||swfLogDto.getNodeType().equals("schel")
                ||swfLogDto.getNodeType().equals("backv")||swfLogDto.getNodeType().equals("check")
                ||swfLogDto.getNodeType().equals("certa")||swfLogDto.getNodeType().equals("wound")
                ||swfLogDto.getNodeType().equals("backc")||swfLogDto.getNodeType().equals("speci")){  %>
            <a href="<%=dealHref%>" onclick="return otherFlag('<%=swfLogDto.getOtherFlag()%>')">
                <img name=buttonDistribute  src="/claim/images/butDeal.gif" border="0"  hspace="5"  alt="ѡ����">
            </a>&nbsp;
<%}          else {        %>

         <%if (!backHref.equals("")){%>
            <a href="<%=dealHref%>" onclick="return compeCount('<%=swfLogDto.getCompeCount()%>')">
                <img name=buttonDistribute  src="/claim/images/butDeal.gif" border="0"  hspace="5"  alt="ѡ����"></a>
                <a href="<%=backHref%>" onclick="return otherFlag('<%=swfLogDto.getOtherFlag()%>')">
                <img name=buttonDistribute src="/claim/images/butBack.GIF" border="0" hspace="0"  alt="���˴���" ></a>
                
           <%    }else{%>
             <a href="<%=dealHref%>" onclick="return compeCount('<%=swfLogDto.getCompeCount()%>')">
                <img name=buttonDistribute  src="/claim/images/butDeal.gif" border="0"  hspace="5"  alt="ѡ����"></a>
           <%}
            }
           %>
        </td>
        <%}
        //��ʾע������Ĵ���ť

          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("cancelApply")){
          %>
           <td align="center"><a href="<%=dealHref%>"><img name=buttonDistribute  src="/claim/images/butCancel.gif" border="0"  hspace="5"   alt="ע��/���� "></a>&nbsp;</td>
<%
          }
        //��ʾ�����ⰸ����Ĵ���ť
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
%>
           <td align="center"><a href="<%=dealHref%>" border="0"  hspace="5"   alt="Ԥ�ⰸ���� ">����</a>&nbsp;</td>
<%
          }
          if (nodeStatus.equals("4") && !nodeType.equals("sched") && !nodeType.equals("certa") && !nodeType.equals("verip") && !nodeType.equals("verpo") && !nodeType.equals("compp")&& !nodeType.equals("claim")){
%>
<%//modify by liujianbo modify 20051107 start
  //reason:����Ӧ�÷�����ջء����ܡ�
%>
           <td align="center"><a href="/claim/processWorkflow.do?editType=recycle&flowID=<bean:write name="swfLogList1" property="flowID"/>&logNo=<bean:write name="swfLogList1" property="logNo"/>">�ջ�</a>&nbsp;</td>
<%
          }
    //���������ֳ�ղ鿱�ڵ�,ת������
    if("check".equals(nodeType)&&!"4".equals(nodeStatus)&&!"5".equals(nodeStatus)){
      if("I".equals(strRiskTypeNow)||"H".equals(strRiskTypeNow)||"E".equals(strRiskTypeNow)||"Q".equals(strRiskTypeNow)||"Y".equals(strRiskTypeNow) ){
      String strCheck = "/claim/common/workrove/TurnTask.jsp?&swfLogFlowID="+swfLogDto.getFlowID()
        +"&swfLogLogNo="+swfLogDto.getLogNo()+"&RegistNo="+swfLogDto.getKeyIn()
        +"&policyNo="+swfLogDto.getPolicyNo()+"&riskCode="+swfLogDto.getRiskCode()
        +"&lossitemCode="+swfLogDto.getLossItemCode()
        +"&roveType="+swfLogDto.getNodeType();

%>

     <td align="center"><a href="#" border="0"  hspace="5" onclick="showCheckTurn('<%=strCheck%>');"   alt="�鿱ת�� ">ת��</a>&nbsp;</td>
<%
      }  else{  
%>
      <td align="center"></td>
<%
      }
    }
%>
<%//modify by liujianbo modify 20051107 end
%>
    </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
      </logic:notEqual>
<%
    //modify by wangwei modify end 2005-06-12
    //}
%>
     <tr class="listtail">
         <td colspan='<%=colNumber%>'>


           <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>
             <bean:define id="pageview" name="swfLogDto" property="turnPageDto"/>

<%    int curPage = swfLogDto1.getTurnPageDto().getPageNo(); %>
      <%@include file="/common/pub/TurnOverPage.jsp"  %>
              </tr>
          </table>
         </td>
     </tr>
    </table>
<%
  }//�Ƿ��һ�ν�������һ�ν�������ѯ���    End
%>
   </tr>
  </table>
 <table>
 <tr>
  <%//1��Ϊ�˲鿱�Ǽ���ʹ�õ������򣬴˴������name���Ʊ�����鿱�Ǽ�¼���������ͬ������UIfacade��������%>

  <input type="hidden" name="recordCount" class="common" value="<%= index %>">
  <input type="hidden" name="swfLogFlowID" class="common" value="">
  <input type="hidden" name="swfLogLogNo" class="common" value="">
  <input type="hidden" name="bussinessNo" class="common" value="">
  <logic:notEqual name="swfLogDto" property="nodeType" value="commo">
         <input type="hidden" name="nodeType" class="common" value="<%=request.getParameter("nodeType")%>">
  </logic:notEqual>
  <input type="hidden" name="status" class="common" value="<%=request.getParameter("status")%>">
  <input type="hidden" name="alertMessage" class="common" value=<bean:write name="swfLogDto" property="alertMessage"/>>
  <input type="hidden" name="userLastAction" class="common" value="">
  <input type="hidden" name="flag"  value="">
  <input type="hidden" name="editType"  value="<%=editType%>">
  <input type="hidden" name="FuncName"  value="<%=request.getParameter("FuncName")%>">
  <input type="hidden" name="searchFlag"  value="">
  <input type="hidden" name="searchField"  value="<%=searchField%>">
  <input type="hidden" name="searchLabel"  value="<%=searchLabel%>">
  <input type="hidden" name="isFirst" value="N" />
 <%
        //modify by wangwei add start 2005-06-12
        //ԭ������һ���ļ�����һ���⽡����Ϣ
    %>
         <input type="hidden" name="type" value="<%= request.getAttribute("com.sinosoft.type")%>"/>
    <%
        //modify by wangwei add end 2005-06-12
    %>
  <%//======================= =================================================%>
  </tr>
  </table>
</form> 
</body>
</html:html>
  <script language="javascript">
     fm.queryButton.disabled = false;
  </script>
