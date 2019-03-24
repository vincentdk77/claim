<%--
****************************************************************************
* DESC       : 工作流节点状态查询结果页面
* AUTHOR     : liubvo
* CREATEDATE ：2004-08-16
* MODIFYLIST ：   id       Date            Reason/Contents
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
    <!-- 根据节点的类型显示标题 -->
    工作流节点状态
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
  //   alert("农户姓名不为空时，必须输入耳标号！");
  //   return false;
  //  }
  //}
  if(fm.EarLabel !=null && trim(fm.EarLabel.value).length<4 && trim(fm.EarLabel.value).length>0)
       {
           alert("耳标号长度不能小于4位");
           return false;
       }
      if(fm.FamilyNo !=null && trim(fm.FamilyNo.value).length<4 && trim(fm.FamilyNo.value).length>0)
       {
            alert("户编号长度不能小于4位");
            return false;
        }
       if(fm.FCardID!=null && trim(fm.FCardID.value).length<6 && trim(fm.FCardID.value).length>0)
       {
           alert("农户身份证号长度不能小于6位");
           return false;
       }
        if(fm.FamilyFIDCard !=null && trim(fm.FamilyFIDCard.value).length<6 && trim(fm.FamilyFIDCard.value).length>0)
        {
            alert("户主身份证号长度不能小于6位");
            return false;
        }
    progressStart();
    fm.searchFlag.value="true";
    fm.submit();//提交
  }
  //有计算书还没核赔通过就不能在出计算书
  function compeCount(count) {
      if (count > 0) {
      alert ("此案件还有未核赔通过或未提交的计算书，不得再出计算书。")
      return false;
      }
      return true;
  }
  //已经注销的保单不得立案
  function otherFlag(otherFlag) {
      if (otherFlag == "1") {
          alert("此保单已被注销，不能立案。");
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
  String funcName = request.getParameter("FuncName"); //表示是注销申请/特殊赔案申请的.
  String funcDesc="";
  int      intriskcode=5;

  if (funcName!=null&& funcName.equals("")){
  if (funcName.equals("cancelApply")) funcDesc="(注销/拒赔申请)";
  if (funcName.equals("specialApply")) funcDesc="(预赔案申请)";
  }

  SwfLogDto swfLogDto = null;
  SwfLogDto swfLogDto1 = (SwfLogDto)request.getAttribute("swfLogDto");
  String msg = "\n"+swfLogDto1.getAlertMessage();

  //modify by luqin 2005-04-08 start
  //reason: 以险种为依据判断页面跳转
  String riskCode="";
  //modify by luqin 2005-04-08 end
  String strTitle="";
  String subTitleTime="";
  String subTitleColName="";
  String nowNodeStatus=""; //做每行状态判断用的
  int colNumber=5;         //基本的列数 基本显示是5列
  String carFlag1="" ;     //表示是否是保单车辆
  String carFlag="" ;      //表示是否是保单车辆
  String typeFlag="";      //表示每行的typeflag的内容
  String dealHref="";      //处理功能，按钮上的联接
  String backHref="";      //处理回退的功能，按钮上的联接
  String dispHref="";      //显示的联接内容
  String flowStr="";       //用来传递flowid和logNo的后半字串后来又加入riskCode和editType,因为每条都传递的
  String EditLastType="";  //用来临时保存editType的方式。
  int afterDay=0;          //如果是立案，计算过去的天数
  int afterHour=0;       //如果是立案，计算过去的小时
  int claimLimit=Integer.parseInt(AppConfig.get("sysconst.ClaimLimitHour")); //获得立案时限制
  String toDoTitle="业务号"; //待处理显示的业务号的名称
  if (nodeStatus.equals("2")){
    strTitle="正在处理";
    subTitleTime="处理时间";    
    if(editType.equals("DELETE")){
      editType="DELETE";
    }else{
      editType="EDIT";
    }
  }
  if (nodeStatus.equals("3")){
    strTitle="已退回";
    subTitleTime="退回时间";
    editType="EDIT";
  }
  if (nodeStatus.equals("4")){
    strTitle="已处理";
    subTitleTime="流出时间";
    editType="SHOW";
  }
  if (nodeStatus.equals("0")){
    strTitle="未处理";
    subTitleTime="流入时间";
    editType="ADD";
  }
  if (nodeStatus.equals("-1")){
    strTitle="";
    subTitleTime="流入时间";
    editType="CANCEL";
  }
  if (nodeStatus.equals("99")){
    strTitle="";
    subTitleTime="处理时间";
    editType="SHOW";
    colNumber=6;
  }
%>

<input type="hidden" name="testMessage" class="common" value=<%=msg%>>
<form name="fm" action="/claim/wfLogQuery.do"  method="post" onsubmit="return validateForm(this);">
    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr>  <td colspan=4 class="formtitle">查询条件</td></tr>
      <tr>
        <td class='title'>
           <% if (searchLabel.equals("businessNo")) subTitleColName="业务号:"; %>
           <% if (searchLabel.equals("businessNo") && nodeType.equals("claim") && !nodeStatus.equals("-1")) subTitleColName="报案号:"; %>
           <% if (searchLabel.equals("businessNo") && (nodeType.equals("claim") || nodeType.equals("compe")) && nodeStatus.equals("-1"))  subTitleColName="立案号:";%>
           <% if (searchLabel.equals("registNo")) subTitleColName="报案号:"; %>
           <% if (searchLabel.equals("claimNo")) subTitleColName="立案号:"; %>
           <% if (searchLabel.equals("compensateNo")) subTitleColName="赔款计算书号:"; %>
           <% if (searchLabel.equals("endCaseNo")) subTitleColName="结案号:"; %>
           <% if (searchLabel.equals("specialNo")) subTitleColName="特殊归档号:"; %>
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
              //modify by qinyongli  2005/7/15 加入险种查询
              String searchContent1=request.getParameter("BusinessNo");
              String searchContent2=request.getParameter("PolicyNo");
              String searchContent3=request.getParameter("RiskCode");
              String searchContentSign1=request.getParameter("BusinessNoSign");
              String searchContentSign2=request.getParameter("PolicyNoSign");
              String searchContentSign3=request.getParameter("RiskCodeNoSign");
              String signselect="";
              //险种大类
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

        <td class='title'>保单号：</td>
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
        <td class='title'>险种大类：</td>
        <td class='input' >
          <select class=tag name="RiskCodeNoSign"  value="<%=searchContentSign3%>">
            <option value="=" <%=signselect%>>=</option>
          </select>
          <select name="RiskClaimType" class="query" style="width: 70%">
                            <option value="">全险种</option>
                            <option value="D">车险</option>
                            <option value="Y">水险</option>
                            <option value="Q">非水</option>
                            <option value="E">意健</option>
                            <option value="H">种植</option>
                            <option value="I">养殖</option>
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
          到：
          <input type=text style="width:85"  value='<bean:write name="todayDate"/>' name="statEndDate" class="Wdate"  onfocus="WdatePicker()"> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.statEndDate', '2007', '2017')"> -->
       </td> 
       <%}else{%>
        </td>
         <td class='title' colspan=2><%=subTitleTime%>:
          <input type=text style="width:85" width="30%"  name="statStartDate" class="Wdate"  onfocus="WdatePicker()"> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif"  align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.statStartDate', '2007', '2017')"> -->
          到：
          <input type=text style="width:85"  name="statEndDate" class="Wdate"  onfocus="WdatePicker()"> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.statEndDate', '2007', '2017')"> -->
       </td> 
        <%}%>
      </tr>
      <!--------------------增加被保险人，报案号查询-start---------------------------------------------->
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
        <td class='title'>被保险人：</td>
        <td class='input' >
          <select class=tag name="insuredNameSign"  value="<%=insuredNameSign1%>">
            <option value="*">*</option>
            <option value="=" <%=signselect%>>=</option>
          </select> <input type=text name="insuredName" class="query" style="width:70%"  value="<%=insuredName1%>">
        </td>
        <%  if (nodeType.equals("regis") ) {  
%>  
<tr>      
<td class='title'>耳标号：(中央政策性养殖险专用)</td>
<td class='input' >
  <select class=tag name="EarLabelSign" >
    <option value="*">*</option>
    <option value="=">=</option>
  </select> <input type=text name="EarLabel" class="query" >
</td>
<td class='title'>农户姓名：(中央政策性养殖险专用)</td>
<td class='input' >
<select class=tag name="FnameSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="Fname" class="query" >
</td>
</tr>
<tr>
        <td class='title' >身份证号：(种植险专用)</td>
        <td class='input' >
          <select class=tag name="FCardIDSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="FCardID" class="query" >
        </td>
        <td class='title'>农户姓名：(种植险专用)</td>
    <td class='input' >
    <select class=tag name="Fname1Sign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="Fname1" class="query" >
    </td>
      </tr>
<%}%>
<%  if (nodeType.equals("verip") ) {  
      if (comLevel.equals("1")){  //总公司不需要本机构
%>        
         <td class='title'>委托类型：</td>
         <td class='input'>
          <select class=tag name="conSignTypeSign">            
            <option value="=">=</option>
          </select>          
          <select class=query name="conSignType" style="width:160" value="<%=conSignType%>">
             <option value="verpo">异地委托</option>
          </select>        
         </td>
    <%} else { %>
  <td class='title'>委托类型：</td>
         <td class='input'>
          <select class=tag name="conSignTypeSign">            
            <option value="=">=</option>
          </select>          
          <select class=query name="conSignType" style="width:160" value="<%=conSignType%>">
            <option value="verip">本机构</option>
            <option value="verpo">异地委托</option>
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
         <td class='title'>报案号：</td>
         <td class='input'>
          <select class=tag name="ComppRegistNoSign"  value="<%=searchContentSign6%>">
            <option value="*">*</option>
            <option value="=" <%=signselect%>>=</option>
          </select> <input type=text name="ComppRegistNo" class="query"  style="width:160"   value="<%=searchContent6%>">
        </td>
         
       <% }else if (searchLabel.equals("claimNo") && nodeType.equals("claim") ) { %>
         <td class='title'>报案号：</td>
         <td class='input'>
          <select class=tag name="ClaimRegistNoSign"  value="<%=searchContentSign4%>">
            <option value="*">*</option>
            <option value="=" <%=signselect%>>=</option>
          </select> <input type=text name="ClaimRegistNo" class="query"  style="width:160"   value="<%=searchContent4%>">
        </td>
         
       <% } else if (searchLabel.equals("claimNo") && nodeType.equals("compe") ) {   %>
        
         <td class='title'>报案号：</td>
         <td class='input'>
          <select class=tag name="CompeRegistNoSign"  value="<%=searchContentSign5%>">
            <option value="=" <%=signselect%>>=</option>
          </select> <input type=text name="CompeRegistNo" class="query"  style="width:160"   value="<%=searchContent5%>">
        </td>
                
       <% } else if (searchLabel.equals("claimNo") && nodeType.equals("endca") ) {  %>
         
         <td class='title'>报案号：</td>
         <td class='input'>
          <select class=tag name="EndcaRegistNoSign"  value="<%=searchContentSign7%>">
            <option value="=" <%=signselect%>>=</option>
          </select> <input type=text name="EndcaRegistNo" class="query"  style="width:160"   value="<%=searchContent7%>">
        </td>
            
       <%}
          signselect="";
          if (insuredNameSign1.equals("=")) signselect="selected";
         %>  
        <td class='title'>被保险人：</td>
        <td class='input' >
          <select class=tag name="insuredNameSign"  value="<%=insuredNameSign1%>">
            <option value="*">*</option>
            <option value="=" <%=signselect%>>=</option>
          </select> <input type=text name="insuredName" class="query"   value="<%=insuredName1%>">
        </td>
      <%}%>  
       </tr>
      <!--------------------增加被保险人查询----end------------------------------------------->
      <tr>
       <td class='button' colspan="4">
          <input type=button name="queryButton" class='button' disabled value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td>
        </tr>   
    </table>
 <app:processBar/>
<%
  //是否第一次进来，第一次进来不查询结果    End
  if("N".equals(isFirst)){
%>
  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr><td colspan=12 class="formtitle">
              <!-- 根据节点的类型显示内容 -->
              <%if (swfLogDto1.getNodeType().equals("commo")){
                   strTitle=strTitle+"信息";
                   subTitleColName="业务号码"; 
                }
              if (swfLogDto1.getNodeType().equals("regis")){
                   strTitle=strTitle+"报案信息";
                   subTitleColName="报案号"; 
              }
              if (swfLogDto1.getNodeType().equals("check")){
                   strTitle=strTitle+"查勘信息";
                   subTitleColName="报案号"; 
              }
              if (swfLogDto1.getNodeType().equals("certa")){
                   strTitle=strTitle+"定损信息";
                   subTitleColName="报案号"; 
              }
               if (swfLogDto1.getNodeType().equals("verip")){
                   strTitle=strTitle+"核价信息";
                   subTitleColName="报案号";
              }
               if (swfLogDto1.getNodeType().equals("verif")){
                   strTitle=strTitle+"核损信息";
                   subTitleColName="报案号";
              }

               if (swfLogDto1.getNodeType().equals("propc")){
                   strTitle=strTitle+"财产定损信息";
                   subTitleColName="报案号"; 
              }
               if (swfLogDto1.getNodeType().equals("backc")){
                   strTitle=strTitle+"复勘信息";
                   subTitleColName="报案号";
              }
               if (swfLogDto1.getNodeType().equals("propv")){
                   strTitle=strTitle+"财产核损信息";
                   subTitleColName="报案号"; 
              }
               if (swfLogDto1.getNodeType().equals("claim")){
                   strTitle=strTitle+"立案信息";
                   subTitleColName="立案号";
                   if (nodeStatus.equals("0"))toDoTitle="报案号";
              }
               if (swfLogDto1.getNodeType().equals("prepa")){
                   strTitle=strTitle+"预赔信息";
                   subTitleColName="报案号";
              }
               if (swfLogDto1.getNodeType().equals("endca")){
                   strTitle=strTitle+"结案信息";
                   subTitleColName="归档号";
             }
               if (swfLogDto1.getNodeType().equals("certi")){
                   strTitle=strTitle+"单证信息";
                   subTitleColName="报案号";
                   if (nodeStatus.equals("0"))toDoTitle="报案号";
              }
               if (swfLogDto1.getNodeType().equals("compe")){
                   strTitle=strTitle+"理算信息";
                   subTitleColName="立案号";
                   if (nodeStatus.equals("0")) toDoTitle="立案号";
              }
               if (swfLogDto1.getNodeType().equals("sched")){
                   strTitle=strTitle+"调度信息";
                   subTitleColName="报案号";
                  //if (subTitleTime.equals("流入时间")) subTitleTime="停留时间"; 
              }

               if (swfLogDto1.getNodeType().equals("wound")){
                   strTitle=strTitle+"人伤跟踪信息";
                   subTitleColName="报案号";
              }
               if (swfLogDto1.getNodeType().equals("cance")){
                   strTitle=strTitle+"注销/拒赔信息";
                   subTitleColName="报案号";
              }
               if (swfLogDto1.getNodeType().equals("veriw")){
                   strTitle=strTitle+"人伤核损信息";
                   subTitleColName="报案号";
              }
               if (swfLogDto1.getNodeType().equals("compp")){
                   strTitle=strTitle+"计算书信息";
                   subTitleColName="赔款计算书号";
              }
               if (swfLogDto1.getNodeType().equals("speci")){
                   strTitle=strTitle+"预赔案信息";
                   subTitleColName="预赔案号";
              }
               if (swfLogDto1.getNodeType().equals("commo")){
                   strTitle=strTitle+"信息";
                   subTitleColName="业务号码";
              }
               if (swfLogDto1.getNodeType().equals("backv")){
                   strTitle=strTitle+"回访信息";
                   subTitleColName="报案号";
              }
               if (swfLogDto1.getNodeType().equals("veric")){
                   strTitle=strTitle+"核赔信息";
                   subTitleColName="业务号";
              } %>
<%=strTitle%>
            </td></tr>
     <tr>
         <td class="centertitle" style="width:4%">序号</td>
<%
        if (nodeStatus.equals("0")||nodeStatus.equals("-1")||nodeStatus.equals("99")){
%>
         <td class="centertitle" style="width:10%">状态</td>
        <td class="centertitle" style="width:16%"><%=toDoTitle%></td>
<%        } else {%>
         <td class="centertitle" style="width:16%"><%=subTitleColName%></td>
<%        }%>
         <td class="centertitle" style="width:16%">保单号码</td>
         <td class="centertitle" style="width:14%">险种</td>
         <td class="centertitle" >被保险人</td>
<%
        //如果等于立案节点
        if(nodeType.equals("claim")&& nodeStatus.equals("0")){
%>
             <td class="centertitle" >剩余(天)</td>
<%
          colNumber=colNumber+1; //列增加1行,如果是定损的话，加入定损类型
        }
        //如果等于定损节点
        if(nodeType.equals("certa")){
%>
             <td class="centertitle" >紧急程度</td>

             <td class="centertitle" >车牌号码</td>
             <td class="centertitle" style="width:10%">保单车辆</td>
<%
          colNumber=colNumber+3; //列增加1行,如果是定损的话，加入定损类型
        }
 
        //如果等于核价节点
        if(nodeType.equals("verip")){
%>
             <td class="centertitle" >车牌号码</td>
             <td class="centertitle" style="width:10%">保单车辆</td>
<%
          colNumber=colNumber+2; //列增加1行,如果是核价的话，加入核价类型
        }
        //如果等于核损节点
        if(nodeType.equals("verif")){
%>
             <td class="centertitle" >车牌号码</td>
             <td class="centertitle" style="width:10%">保单车辆</td>
<%
          colNumber=colNumber+2; //列增加1行,如果是核损的话，加入核损类型
        }
//如果等于回访节点
        if(nodeType.equals("backv")){  %>
             <td class="centertitle" >回访类型</td>
<%          colNumber=colNumber+1; //列增加1行,回访类型
        }
        //如果等于查勘节点
        if(nodeType.equals("check")){

        //modify by wangwei modify start 2005-06-12
        //原因：意健险没有车牌号码这一列
            if (request.getAttribute("com.sinosoft.type") != null && request.getAttribute("com.sinosoft.type").equals("acci")) {
            } else {
%>
             <td class="centertitle" >车牌号码</td>
<%
          colNumber=colNumber+1; //列增加4行,加入车牌号码等
             }
          //modify by wangwei modify end 2005-06-12

        }
        //如果等于计算书或者特殊赔案节点
        if(nodeType.equals("compp")||nodeType.equals("veric")){
%>
             <td class="centertitle" >立案号码</td>
<%
          colNumber=colNumber+1; //列增加4行,加入车牌号码等
        }

        if (nodeType.equals("speci")){

          if (nodeStatus.equals("0")){
        %>
          <td class="centertitle" >赔案类型</td>
        <%
        }else{
        %>
        <td class="centertitle" >立案号码</td>
        <%
        }
        colNumber=colNumber+1; //列增加1行,加入车牌号码等
        }

               //如果等于定损调度或者查勘调度节点
        if(nodeType.equals("sched")||nodeType.equals("schel")){
%>
             
             <td class="centertitle">出险标的</td>
<%
           if (nodeStatus.equals("0")){
%>

             <td class="centertitle" style="width:12%">等候</td>
             <td class="centertitle">是否查勘调度</td>
<%
             colNumber=colNumber+1;
             }
          colNumber=colNumber+2; //列增加1行,加入车牌号码等
        } %>
     
     <!-------------------被保险人--------------------------------------->   
     <!--td class="centertitle" >被保险人</td>       -->
     
     
<%
      //如果不等于理算节点，全都显示处理人员这一列
        if(!nodeType.equals("compe")){
%>
             <td class="centertitle" >处理人员</td>
<%
         }
       //定损退回节点，标志由哪退回   
        if(nodeType.equals("certa")&& nodeStatus.equals("3")){
%>
             <td class="centertitle" >退回节点</td>

<%}   
         //如果等于理算节点
         if(nodeType.equals("compe")){
%>
             <td class="centertitle" >计算书号码</td>
             <td class="centertitle" >操作人员</td>
<%
          colNumber=colNumber+2;
         }

       if(!nodeType.equals("sched")){
%>
        <td class="centertitle" style="width:16%"><%=subTitleTime%></td>
<%     }
         //如果等于通用节点
         if(nodeType.equals("commo")){
%>
        <td class="centertitle" style="width:16%">节点名称</td>
<%
          colNumber=colNumber+1;
         }
        if ((nodeStatus.equals("0")||nodeStatus.equals("-1")||nodeStatus.equals("4")) && !nodeType.equals("compp")){
%>
              <td class="centertitle" style="width:5%">操作</td>
<%
          colNumber=colNumber+2;
        }
      //如果等于养殖险查勘节点,转交操作
        if("check".equals(nodeType)&&!"4".equals(nodeStatus)&&!"5".equals(nodeStatus)){
          if (request.getAttribute("com.sinosoft.type") != null && request.getAttribute("com.sinosoft.type").equals("acci")) {
            } else {
%>
              <td class="centertitle" style="width:5%">转交</td>
<%
           colNumber=colNumber+1;
          }
        }
%>
     </tr>
<%
     //modify by wangwei modify start 2005-06-
     //原因：需要区别意健险和其他险种，点不同险种的菜单时显示不同的页面信息。以下代码用于显示意健险的界面.
     SwfLogDto swfLogDtoTmp = (SwfLogDto)request.getAttribute("swfLogDto");
     int countLogDto = swfLogDtoTmp.getSwfLogList().size();
%>
    <logic:notEmpty name="com.sinosoft.type">
    <logic:equal name="com.sinosoft.type" value="acci">
<%
    //modify by lixiang modify start 2006-08-09
    //原因：意健险的连接界面，减少此页面的修改量。
%>
   <%@include file="/workflow/task/AcciWfLogStatusList.jsp" %>
<% //modify by lixiang modify start 2006-08-09 %>
      </logic:equal>
     </logic:notEmpty>
<%
    //modify by wangwei modify start 2005-06-12
    //原因：以下代码用于显示非意键险时的界面。
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
      //取得该行的DTO的数据 判断节点类型和状态，根据不同的状态，实现不同的按扭内容
      swfLogDto = (SwfLogDto) ((ArrayList)swfLogDto1.getSwfLogList()).get(index);
      typeFlag = swfLogDto.getTypeFlag();
      dealHref="";      //清空联接内容
      backHref="";      //清空处理回退的联接
      dispHref="";      //清空显示的联接
      carFlag="三者车";     //判断insureCarFlag的属性

      EditLastType=editType; //复制
      String strRiskTypeNow = uiCodeAction.translateRiskCodetoRiskType(swfLogDto.getRiskCode());
      if (swfLogDto.getInsureCarFlag().equals("1")) carFlag="标的车";
      if (!"D".equals(strRiskTypeNow)) carFlag="";
      
      nowNodeStatus=swfLogDto.getNodeStatus();

      if (nodeStatus.equals("0")||nodeStatus.equals("-1")||nodeStatus.equals("99")){ //判断当前的任务是哪种类型的，根据任务的节点的状态
%>

          <td align="center">
<%

      if (nowNodeStatus.equals("3")){

         if (!nodeStatus.equals("-1")){EditLastType="EDIT" ;}
        // EditLastType="EDIT";
%>
      回退处理
<%
      }

      if (nowNodeStatus.equals("4")){ %>
      已提交
      <%}

      if (nowNodeStatus.equals("5")){ %>
      不通过退回
      <%}
      if (nowNodeStatus.equals("0")){
%>
      新处理
<%
        if (swfLogDto.getNodeType().equals("cance"))  EditLastType="CANCELEDIT";
      }
             if (nowNodeStatus.equals("2")){ %> 正在处理
<%
             }
%>
          </td>
<%
       }
      // 把工作流号码等等也需要 加载到link中
      //modify by lixiang add 20050304 start
      //reason:加入传进保单号码的过程

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
       //以下是根据节点名称的不同，在显示第一列的超链的内容不同。（一般是业务号码）
       // (nodeStatus.equals("0")&&nowNodeStatus.equals("0")是表示待处理任务中的新任务
       // nodeStatus.equals("-1") 表示的是按下注销拒赔申请菜单后的任务显示。 %>
          <td align="center">
                  <logic:equal name="swfLogList1" property="nodeType" value="prepa">

<%                if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                        dealHref="/claim/claimFinishQueryList.do?prpLclaimClaimNo="+swfLogDto.getKeyIn()
                                +flowStr;
                        }else if (nodeStatus.equals("-1")){ //注销拒赔申请

          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
    }else{

                        dealHref="/claim/claimBeforeCancel.do?ClaimNo="+swfLogDto.getKeyIn()
                                +flowStr;
      }
                        }
                        else if (nowNodeStatus.equals("3")) //区分是退回的方式
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
                  <%//暂时用来做核赔通过的功能
                  if (nodeStatus.equals("99")){
                      if (nowNodeStatus.equals("0")||nowNodeStatus.equals("5")){
                      //businessNo为归档号码
                         dealHref="/claim/compensateFinishQueryList.do?prpLcompensateCompensateNo="+swfLogDto.getBusinessNo()+flowStr;
                         dispHref=swfLogDto.getBusinessNo();
                       }else
                       {
                       //keyOut为归档号码
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
                  <%--resson:UNIX大小写一致--%>
                  <% riskCode=swfLogDto.getRiskCode();
                     //add by lixiang start at 2006-04-17
                  
                     //reason:如果是车险的，可以增加一个回退定损的功能
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
                     if (nodeStatus.equals("-1")){ //注销拒赔申请     
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
                    
                        //特殊赔案中的通融和预付车险和非车险不同 2005-9-30
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
                           }else if (nodeStatus.equals("-1")){ //注销拒赔申请
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
                           }else if (nodeStatus.equals("-1")){ //注销拒赔申请
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
                          }else if (nodeStatus.equals("-1")){ //注销拒赔申请

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
                             }else if (nodeStatus.equals("-1")){ //注销拒赔申请
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
    }else{
                             dealHref="/claim/claimBeforeCancel.do?RegistNo="+swfLogDto.getKeyIn()
                                + "&type=" + request.getAttribute("com.sinosoft.type")
                                +flowStr;}

                            }else if (nowNodeStatus.equals("3")) //区分是退回的方式
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
                            }else if (nodeStatus.equals("-1")){ //注销拒赔申请
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
                            }else if (nodeStatus.equals("-1")){ //注销拒赔申请
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
                            }else if (nodeStatus.equals("-1")){ //注销拒赔申请
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
                   <% //人伤核损的链接%>
                  <logic:equal name="swfLogList1" property="nodeType" value="veriw">
                            <% if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                              dealHref="/claim/verifyLossFinishQueryList.do?RegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag="+swfLogDto.getTypeFlag()
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode="+swfLogDto.getLossItemCode()
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +flowStr;
                            }else if (nodeStatus.equals("-1")){ //注销拒赔申请
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
                  }else if (nodeStatus.equals("-1")){ //注销拒赔申请
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

                            }else if (nodeStatus.equals("-1")){ //注销拒赔申请
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
    }else{
                             dealHref="/claim/claimBeforeCancel.do?RegistNo="+swfLogDto.getKeyIn()
                                + "&type=" + request.getAttribute("com.sinosoft.type")
                                +flowStr;}

                            }else if (nowNodeStatus.equals("3")) //区分是退回的方式
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
            <%--resson:增加物损--%>
                  <logic:equal name="swfLogList1" property="nodeType" value="propc">
<%                 if ((nodeStatus.equals("0")&&nowNodeStatus.equals("0"))){
                             dealHref="/claim/certainLossBeforeEdit.do?RegistNo="+swfLogDto.getKeyIn()
                                      +"&lossTypeFlag=0"
                                      +"&insureCarFlag="+swfLogDto.getInsureCarFlag()
                                      +"&lossItemCode=-1"
                                      +"&lossItemName="+swfLogDto.getLossItemName()
                                      +flowStr;

                            }else if (nodeStatus.equals("-1")){ //注销拒赔申请
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
    }else{
                             dealHref="/claim/claimBeforeCancel.do?RegistNo="+swfLogDto.getKeyIn()
                             + "&type=" + request.getAttribute("com.sinosoft.type")
                                +flowStr;}

                            }else if (nowNodeStatus.equals("3")) //区分是退回的方式
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
                            }else if (nodeStatus.equals("-1")){ //注销拒赔申请
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
                            }else if (nodeStatus.equals("-1")){ //注销拒赔申请
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
             <%--Reason:增加回访节点  --%>
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

         <%--value=1 表示这个保单已经注销，不得立案--%>
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
        <%//保单号码的内容%>
        <td align="center">
        <% //modify by lixiang start at 2006-6-5
           //reason :支持多个关联保单%>
        <logic:iterate id="relatePolicyList1"  name="swfLogList1"  property="relatePolicyList">  
        <bean:write name="relatePolicyList1" property="policyNo"/>
        </logic:iterate>
         <% //modify by lixiang end at 2006-6-5%>
        </td>
        <td align="center"><bean:write name="swfLogList1" property="riskCodeName"/></td>
        <td align="center" width="10%"><bean:write name="swfLogList1" property="insuredName"/></td> 
        <%//如果是定损核损，列出类型中的内容%>
        <logic:equal name="swfLogDto" property="nodeType" value="certa">
           <td align="center">
             <logic:equal name="swfLogList1" property="exigenceGree" value="0">
              紧急
              </logic:equal>
             <logic:equal name="swfLogList1" property="exigenceGree" value="1">
              一般
              </logic:equal>
           </td>
          <logic:notEqual name="swfLogList1" property="insureCarFlag" value="1">
       <%//modify by kangzhen%>
<%
           if("D".equals(strRiskTypeNow))  
           {
%>           
           <td align="center"><bean:write name='swfLogList1' property='lossItemName'/>(三者车)</td>
           
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

         <%//如果是理算类型的，写具体理算记录数据%>
        <logic:equal name="swfLogDto" property="nodeType" value="compe">
           <td align="center"> <a href="/claim/compensateFinishQueryList.do?prpLcompensateCompensateNo=<bean:write name='swfLogList1' property='keyOut'/>&editType=<%=EditLastType%>&riskCode=<bean:write name='swfLogList1' property='riskCode'/><%=flowStr%>"><bean:write name='swfLogList1' property='keyOut'/></a></td>
        </logic:equal>

        <%//如果是计算书类型的，写立案号码%>
        <logic:equal name="swfLogDto" property="nodeType" value="compp">
          <td align="center"><a href="/claim/claimFinishQueryList.do?prpLclaimClaimNo=<bean:write name='swfLogList1' property='keyIn'/>&editType=SHOW&riskCode=<bean:write name='swfLogList1' property='riskCode'/><%=flowStr%>" title="<bean:write name="swfLogList1" property="titleStr"/>">
                  <bean:write name='swfLogList1' property='keyIn'/></a>
        </logic:equal> </td>

<%//如果是特殊案件类型的，写立案号码%>
        <logic:equal name="swfLogDto" property="nodeType" value="speci">
         <td align="center">
           <logic:equal name="swfLogList1" property="nodeStatus" value="0">
                 <logic:equal name="swfLogList1" property="typeFlag" value="3">通融</logic:equal>
                <logic:equal name="swfLogList1" property="typeFlag" value="4">预付</logic:equal>
                <logic:equal name="swfLogList1" property="typeFlag" value="5">预赔</logic:equal>
                <logic:equal name="swfLogList1" property="typeFlag" value="6">其它</logic:equal>
           </logic:equal>

           <% if ((!swfLogDto.getNodeStatus().equals("0"))&&(!swfLogDto.getNodeStatus().equals("3"))){%>
             <a href="/claim/claimFinishQueryList.do?prpLclaimClaimNo=<bean:write name='swfLogList1' property='keyIn'/>&editType=SHOW&riskCode=<bean:write name='swfLogList1' property='riskCode'/><%=flowStr%>" title="<bean:write name="swfLogList1" property="titleStr"/>">
                   <bean:write name='swfLogList1' property='keyIn'/></a>
           <%}%>
            </td>
        </logic:equal>
 <%//如果是核赔类型的，写立案号码%>
        <logic:equal name="swfLogDto" property="nodeType" value="veric">
          <td align="center">      <a href="/claim/claimFinishQueryList.do?prpLclaimClaimNo=<bean:write name='swfLogList1' property='keyIn'/>&editType=SHOW&riskCode=<bean:write name='swfLogList1' property='riskCode'/><%=flowStr%>" title="<bean:write name="swfLogList1" property="titleStr"/>">
                  <bean:write name='swfLogList1' property='keyIn'/></a>
        </logic:equal> </td>
<%//如果是回访
if(nodeType.equals("backv")){
String backvType="查勘回访";
  if (swfLogDto.getTypeFlag().equals("2")) backvType="定损回访";
%>
        <td align="center"><%=backvType%></td>
<%
}
%>
         <%//如果是查勘类型的，写具体车牌号码，%>
          <logic:equal name="swfLogDto" property="nodeType" value="check">
          <logic:notEqual name="com.sinosoft.type" value="acci">
             <td align="center"><bean:write name='swfLogList1' property='lossItemName'/></td>
           </logic:notEqual>
          </logic:equal>

          <%//如果是查勘类型的，写具体车牌号码，保单车辆，调度号，调度人 %>
          <logic:equal name="swfLogDto" property="nodeType" value="claim">
          <%
               afterDay=0;   //计算时间的
               afterHour=0;
               if (nodeStatus.equals("0"))
               {
               afterDay=DateTime.intervalDay(new DateTime(swfLogDto.getFlowInTime(),DateTime.YEAR_TO_DAY),swfLogDto.getTimeLimit(),new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY) ,DateTime.current().getHour() ) ;
               //-1是因为如果不到一天，是按照一天计算的，因为我要计算小时，所以就应该记为0天的
               afterHour=(afterDay-1) - (swfLogDto.getTimeLimit()+DateTime.current().getHour())/24;
               //剩余时间计算               
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

        <% //如果等于定损调度或者查勘调度节点
        if(nodeType.equals("sched")||nodeType.equals("schel")){
        %>
        <td align="center"><bean:write name='swfLogList1' property='lossItemName'/></td>
          <% if (nodeStatus.equals("0")){ %>
        <td align="center"><bean:write name='swfLogList1' property='stopTimeDesc'/></td>
          <% 
            if("10".equals(swfLogDto.getTypeFlag())){
          %>
            <td align="center">是</td>
          <%
            }
            else{
           %>
           <td align="center">否</td>
           <%
             }
          }
        }
        %>
        <!--td align="center"><bean:write name="swfLogList1" property="insuredName"/></td> <!-----被保险人-------------->
        <%//写操作人数据%>
        <td align="center"><bean:write name="swfLogList1" property="handlerName"/></td>
        <%//写操作时间的信息%>
        
  <%     //定损退回节点，标志由哪退回   
        if(nodeType.equals("certa")&& nodeStatus.equals("3")){
%>
       <logic:equal name="swfLogList1" property="businessType" value="verip">
        <td align="center" width="5%">核价</td>
       </logic:equal>
       <logic:equal name="swfLogList1" property="businessType" value="verif">
        <td align="center" width="5%">核损</td>
       </logic:equal>
       <logic:equal name="swfLogList1" property="businessType" value="compe">
        <td align="center" width="5%">理算</td>
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
          <%//以下为每行隐含中的内容的具体信息%>
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
<%           // 已立案，结案不能回退,目前只限制在已经处理的回退任务
             //这些都不能回退的
             if (swfLogDto.getNodeStatus().equals("3")||swfLogDto.getNodeType().equals("claim")
                ||swfLogDto.getNodeType().equals("sched")||swfLogDto.getNodeType().equals("schel")
                ||swfLogDto.getNodeType().equals("backv")||swfLogDto.getNodeType().equals("check")
                ||swfLogDto.getNodeType().equals("certa")||swfLogDto.getNodeType().equals("wound")
                ||swfLogDto.getNodeType().equals("backc")||swfLogDto.getNodeType().equals("speci")){  %>
            <a href="<%=dealHref%>" onclick="return otherFlag('<%=swfLogDto.getOtherFlag()%>')">
                <img name=buttonDistribute  src="/claim/images/butDeal.gif" border="0"  hspace="5"  alt="选择处理">
            </a>&nbsp;
<%}          else {        %>

         <%if (!backHref.equals("")){%>
            <a href="<%=dealHref%>" onclick="return compeCount('<%=swfLogDto.getCompeCount()%>')">
                <img name=buttonDistribute  src="/claim/images/butDeal.gif" border="0"  hspace="5"  alt="选择处理"></a>
                <a href="<%=backHref%>" onclick="return otherFlag('<%=swfLogDto.getOtherFlag()%>')">
                <img name=buttonDistribute src="/claim/images/butBack.GIF" border="0" hspace="0"  alt="回退处理" ></a>
                
           <%    }else{%>
             <a href="<%=dealHref%>" onclick="return compeCount('<%=swfLogDto.getCompeCount()%>')">
                <img name=buttonDistribute  src="/claim/images/butDeal.gif" border="0"  hspace="5"  alt="选择处理"></a>
           <%}
            }
           %>
        </td>
        <%}
        //显示注销申请的处理按钮

          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("cancelApply")){
          %>
           <td align="center"><a href="<%=dealHref%>"><img name=buttonDistribute  src="/claim/images/butCancel.gif" border="0"  hspace="5"   alt="注销/拒赔 "></a>&nbsp;</td>
<%
          }
        //显示特殊赔案申请的处理按钮
          if (nodeStatus.equals("-1")&&funcName!=null&&funcName.equals("specialApply")){
            dealHref="/claim/specailCaseQuery.do?"+flowStr;
%>
           <td align="center"><a href="<%=dealHref%>" border="0"  hspace="5"   alt="预赔案申请 ">申请</a>&nbsp;</td>
<%
          }
          if (nodeStatus.equals("4") && !nodeType.equals("sched") && !nodeType.equals("certa") && !nodeType.equals("verip") && !nodeType.equals("verpo") && !nodeType.equals("compp")&& !nodeType.equals("claim")){
%>
<%//modify by liujianbo modify 20051107 start
  //reason:立案应该封掉“收回”功能。
%>
           <td align="center"><a href="/claim/processWorkflow.do?editType=recycle&flowID=<bean:write name="swfLogList1" property="flowID"/>&logNo=<bean:write name="swfLogList1" property="logNo"/>">收回</a>&nbsp;</td>
<%
          }
    //如果等于养殖险查勘节点,转交操作
    if("check".equals(nodeType)&&!"4".equals(nodeStatus)&&!"5".equals(nodeStatus)){
      if("I".equals(strRiskTypeNow)||"H".equals(strRiskTypeNow)||"E".equals(strRiskTypeNow)||"Q".equals(strRiskTypeNow)||"Y".equals(strRiskTypeNow) ){
      String strCheck = "/claim/common/workrove/TurnTask.jsp?&swfLogFlowID="+swfLogDto.getFlowID()
        +"&swfLogLogNo="+swfLogDto.getLogNo()+"&RegistNo="+swfLogDto.getKeyIn()
        +"&policyNo="+swfLogDto.getPolicyNo()+"&riskCode="+swfLogDto.getRiskCode()
        +"&lossitemCode="+swfLogDto.getLossItemCode()
        +"&roveType="+swfLogDto.getNodeType();

%>

     <td align="center"><a href="#" border="0"  hspace="5" onclick="showCheckTurn('<%=strCheck%>');"   alt="查勘转交 ">转交</a>&nbsp;</td>
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
  }//是否第一次进来，第一次进来不查询结果    End
%>
   </tr>
  </table>
 <table>
 <tr>
  <%//1。为了查勘登记所使用的输入域，此处输入的name名称必须与查勘登记录入的名称相同，否则UIfacade会有问题%>

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
        //原因：向下一个文件增加一个意健险信息
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
