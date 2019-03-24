<%--
****************************************************************************
* DESC       : 未处理并案信息查询结果页面
* AUTHOR     : qianxiantao
* CREATEDATE ：2011-08-01
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.gyic.claim.dto.domain.*" %>
<%@ page import = "com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="java.util.*"%>
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
  function submitForm()
  {
    progressStart();
    fm.action="/claim/wfLogUniteQueryEdite.do?Flag=N";
    fm.searchFlag.value="true";
    fm.submit();//提交
  }
  function claimComBineCheck()
 {
   var i = 0;
   var choosecount = 0;
   var str = "";  
   //检查选中
   var ilength = fm.claimComBineBox.length;
   for(i=0;i<ilength;i++)

   {
      if(fm.claimComBineBox[i].checked)
      {
          choosecount = choosecount+1;
      }
   }
   if(choosecount==0) //没有选中
   {
      alert("请选择要合并的报案号！当前系统可合并案件数量限制为"+fm.CombineLimit.value+"！");
      return false;
   }
    if(choosecount > fm.CombineLimit.value) //没有选中
   {
      alert("当前系统可合并案件数量限制为"+fm.CombineLimit.value+"！");
      return false;
   }
      fm.action="/claim/claimComBine.do";
      fm.submit();
 }  
   function claimComBineCheckCancle()
 {
   var i = 0;
   var choosecount = 0;
   var str = "";  
   //检查选中
   var ilength = fm.claimComBineBox.length;
   if(null!=ilength){
	   for(i=0;i<ilength;i++)
	   {
	      if(fm.claimComBineBox[i].checked)
	      {
	          choosecount = choosecount+1;
	      }
	   }
 	}else if(null!=fm.claimComBineBox){
	 if(fm.claimComBineBox.checked)
      {
          choosecount = choosecount+1;
      }
   }
if(choosecount==0) //没有选中
   {
      alert("请选择要合并的报案号！当前系统可合并案件数量限制为"+fm.CombineLimit.value+"！");
      return false;
   }
    if(choosecount > fm.CombineLimit.value) //没有选中
   {
      alert("当前系统可合并案件数量限制为"+fm.CombineLimit.value+"！");
      return false;
   }
      fm.action="/claim/claimComBineEditeDelete.do";
      fm.submit();
 }  
 function claimComBineCheckAdd()
 {
   var i = 0;
   var choosecount = 0;
   var str = "";  
   //检查选中
   var ilength = document.getElementsByName("claimComBineBox").length;
   
   //var ilength = fm.claimComBineBox.length;
   if(null!=ilength && ilength >1){
	   for(i=0;i<ilength;i++)
	
	   {
	      if(fm.claimComBineBox[i].checked)
	      {
	          choosecount = choosecount+1;
	      }
	   }
   }else if(null!=ilength && ilength ==1){
	 if(fm.claimComBineBox.checked)
      {
          choosecount = choosecount+1;
      }
   }
if(choosecount==0) //没有选中
   {
      alert("请选择要合并的报案号！当前系统可合并案件数量限制为"+fm.CombineLimit.value+"！");
      return false;
   }
    if(choosecount > fm.CombineLimit.value) //没有选中
   {
      alert("当前系统可合并案件数量限制为"+fm.CombineLimit.value+"！");
      return false;
   }
      fm.action="/claim/claimComBineEditeAdd.do";
      fm.submit();
 }  
  function doChecked(obj){
       var check=fm.checkBox.value;
       if(obj.checked){
          if(check.split("&").toString().indexOf(obj.value)!=-1){
          }else{
          check=check+("&"+obj.value);
          }
       }else{
          if(check.split("&").toString().indexOf(obj.value)!=-1){
           check=check.replace("&"+obj.value,"");    
          }
       }
       fm.checkBox.value=check;
 }
  </script>
   <html:base/>
</head>
<body onload="progressStop();">
<%
     int index=0;
     String policyNo=request.getParameter("PolicyNo");
     String comBineNo=request.getParameter("ComBineNo");
     String registNo=request.getParameter("RegistNo");
     String editType=request.getParameter("editType");
     String isFirst = request.getParameter("isFirst");
     PrplcombineSwfLogDto swfLogDto = null;
     PrplcombineSwfLogDto swfLogDto1 = (PrplcombineSwfLogDto)request.getAttribute("swfLogDto");
     String riskCode="";
     String nowNodeStatus=""; //做每行状态判断用的
     int colNumber=9;         //基本的列数 基本显示是7列
     String strClaimRiskType = request.getParameter("RiskClaimType");
    // String strClaimRiskType = "H";
     String checkStr="";
%>
<form name="fm" action="/claim/wfLogUniteQueryEdite.do?Flag=Y"  method="post">
<input type="hidden" name="CombineLimit" value="<%= AppConfig.get("sysconst.COMBINE_LIMIT") %>">
    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr>  <td colspan=4 class="formtitle">查询条件</td></tr>
      <tr>
      <td class='title'>保单号：</td>
        <td class='input' >
          <select class=tag name="PolicyNoSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="PolicyNo" class="query"  style="width:60%">
        </td>
        <td class='title'>险种：</td>
        <td class='input' >
          <select class='input' name="riskCode" style="width:160">
            <option value="3220">能繁母猪养殖保险</option>
            <option value="3202">奶牛养殖保险</option>
            <option value="3223">能繁母羊养殖保险</option>
            <option value="3227">肉羊养殖保险</option>
            <option value="3233">基础母牛保险</option>
            <option value="3234">牛养殖保险</option>
            <option value="3240">科技养鸡保险</option>
          </select>
        </td> 
      </tr>
      <tr> 
      <td class='title'>
             事故号
        </td>
        <td class='input'>
          <select class=tag name="ComBineNoSign"  >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="ComBineNo" class="query"  style="width:60%">
        </td>       

         <td class='title' colspan=2>报案时间:
          <input type=text style="width:85" width="30%" name="statStartDate" class="Wdate" value=""  onfocus="WdatePicker()"> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif"  align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.statStartDate', '2007', '2017')"> -->
          到：
          <input type=text style="width:85" name="statEndDate" class="Wdate" value="" onfocus="WdatePicker()"> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.statEndDate', '2007', '2017')"> -->
       </td> 
      </tr>
      <!--------------------增加被保险人，报案号查询-start---------------------------------------------->
      <tr>
        <td class='title'>报案号</td>
        <td class='input'>
          <select class=tag name="RegistNoSign"  >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="RegistNo" class="query"  style="width:60%">
        <td class='title'>被保险人：</td>
        <td class='input' >
          <select class=tag name="InsuredNameSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="InsuredName" class="query" style="width: 60%">
        </td> 

       </tr>
      <!--------------------增加被保险人查询----end------------------------------------------->
      <tr>
       <td class='button' colspan="4">
          <input type=button name="queryButton" class='button' value="查询" onClick="submitForm();">
        </td>
        </tr>   
 </table>
 <app:processBar/>
      <%
          if("N".equals(isFirst)){
     %>
     <table  class="common" cellpadding="5" cellspacing="1" >
     <tr><td colspan=12 class="formtitle">未处理已合并案件信息</td>
     </tr>
     <tr>
         <td class="centertitle" >需要标志</td>
         <td class="centertitle" >序号</td>
         <td class="centertitle" >状态</td>
         <td class="centertitle" >报案号</td>
         <td class="centertitle" >事故号</td>
         <td class="centertitle" >保单号码</td>
         <td class="centertitle" >险种</td>
         <td class="centertitle" >被保险人</td>
         <td class="centertitle" >节点类型</td>
     </tr>
     <logic:notEmpty  name="swfLogDto"  property="swfLogList">
     <logic:iterate id="swfLogList1"  name="swfLogDto"  property="swfLogList">
     <%
     if(index %2== 0)
          out.print("<tr class=listodd>");
     else
          out.print("<tr class=listeven>");
      %>
      <%
           Object check= request.getParameter("checkBox");
           checkStr=(String )check;
           swfLogDto = (PrplcombineSwfLogDto) ((ArrayList)swfLogDto1.getSwfLogList()).get(index);
           String checked="";
           if(checkStr.contains(swfLogDto.getRegistNo())){
              checked="checked";
           }
         %>
         <td align="center" width="5%">
         <input type="checkbox" name="claimComBineBox" <%=checked%> value="<bean:write name='swfLogList1' property='registNo'/>" onclick="doChecked(this)">
         </td>
         <td align="center">
             <%=index+1%>
         </td>
         <%
      swfLogDto = (PrplcombineSwfLogDto) ((ArrayList)swfLogDto1.getSwfLogList()).get(index);
      nowNodeStatus=swfLogDto.getNodeStatus();
      %>
       <td align="center">
      <%
             if (nowNodeStatus.equals("2")){ %> 正在处理
      <%
             }
      %>
      <%
             if (nowNodeStatus.equals("4")){ %> 已提交
      <%
             }
      %>
      <%
             if (nowNodeStatus.equals("0")){ %> 新处理
      <%
             }
      %>
      <%
             if (nowNodeStatus.equals("5")){ %> 不通过退回
      <%
             }
      %>
      <%
             if (nowNodeStatus.equals("3")){ %> 回退处理
      <%
             }
      %>
        </td>
         <td align="center">
            <a href="/claim/registFinishQueryList.do?prpLregistRegistNo=<bean:write name='swfLogList1' property='registNo'/>&editType=SHOW&riskcode="> <bean:write name="swfLogList1" property="registNo"/></a></td>
        </td>
        <td align="center" width="12%">
        <bean:write name="swfLogList1" property="combineno"/>
        </td>
        <td align="center">
        <bean:write name="swfLogList1" property="policyNo"/>
        </td>
        <td align="center"><bean:write name="swfLogList1" property="riskCodeName"/></td>
        <td align="center" width="12%"><bean:write name="swfLogList1" property="insuredName"/></td>
        <td align="center"><bean:write name="swfLogList1" property="nodeName"/></td>
         </tr>
        <%index++;%>
     </logic:iterate>
     </logic:notEmpty>
     <tr>
       <td class='button' colspan="6">
          <input type=button name="comBineButton" class='button' value="新增合并" onclick="claimComBineCheckAdd()">
        </td>
         <td class='button' colspan="0">
          <input type=button name="buttonCancel" class='button' value="删除合并" onclick="claimComBineCheckCancle()">
        </td>
        </tr>   
        <tr class="listtail" align="center">
         <td colspan='16' align="center">
           <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr align="center">
             <bean:define id="pageview" name="swfLogDto" property="turnPageDto"/>
      <%int curPage = swfLogDto1.getTurnPageDto().getPageNo(); %>
      <%@include file="/common/pub/TurnOverPage.jsp"  %>
              </tr>
          </table>
         </td>
     </tr>
    </table>
<%
  }//是否第一次进来，第一次进来不查询结果End
%>
   </tr>
</table>
 <table>
 <tr>
  <input type="hidden" name="checkBox" value="<%=request.getAttribute("checkBox")==null?"":request.getAttribute("checkBox")%>">
  <input type="hidden" name="comBineNo" value="<%=request.getAttribute("ComBineNo")%>">
  <input type="hidden" name="policyNo" value="<%=request.getAttribute("PolicyNo")%>">
  <input type="hidden" name="StartDate" value="<%=request.getAttribute("StartDate")%>">
  <input type="hidden" name="EndDate" value="<%=request.getAttribute("EndDate")%>">
  <input type="hidden" name="RiskCode"  value=""/>
  <input type="hidden" name="searchFlag"  value=""/>
  <input type="hidden" name="alertMessage" class="common" value=""/>
  <input type="hidden" name="editType"  value="SHOW"/>
  <input type="hidden" name="isFirst" value="N"/>
  </tr>
  </table>
</form> 
</body>
</html:html>
  <script language="javascript">
     fm.queryButton.disabled = false;
  </script>