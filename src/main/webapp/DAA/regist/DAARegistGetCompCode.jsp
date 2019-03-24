<%--
****************************************************************************
* DESC       ：零件代码页面
* AUTHOR     ：理赔项目组
* CREATEDATE ：2005-04-06
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
  
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%
  //得到输入域所在位置
  String strIndex=request.getParameter("strIndex");
  //得到部位代码
  String strPartCode = request.getParameter("partCode").trim();
  //得到请求来自哪个模块
  String previousFlag = request.getParameter("previousFlag");
  if(previousFlag==null)
  {
    previousFlag = "";
  }
  previousFlag = previousFlag.trim();
  System.out.println("previousFlag:"+previousFlag);
  
%>

<html:html locale="true">  
<head>
  <title>
   代码名称页面
  </title>
  <app:css />
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/regist/js/DAARegistEdit.js"></script>
  <script src="/claim/DAA/regist/js/DAAThirdCarLossEdit.js"></script>
  <script language="javascript">
    //根据损失部位的不同，显示不同的零件
    function loadInfo()
    {
	  if(<%=strPartCode%>==1)
	  {
	    spanQianBu.style.display="";
	  }
	  else if(<%=strPartCode%>==4)
	  {
	    spanHouBu.style.display=""; 
	  }else if(<%=strPartCode%>==2||<%=strPartCode%>==3)
	  {
	    spanZhongBu.style.display=""; 
	  }else if(<%=strPartCode%>==5)
	  {
	     spanLossItem.style.display=""; 
	  }
	  
	  return true;
	}
  </script>  
</head>  

<body  onload="loadInfo();">  
  <form name="fm">
  
  
  <table  border="0" align="center" cellpadding="5" cellspacing="1" >
  <tr class=listtitle><td class="formtitle">代码项目列表</td></tr>
    <tr>
      <td  id = "spanQianBu" style="display:none">  
        <UL>
          <LI><IMG src="/claim/images/treeFoderclassOpen.gif"></IMG>前部
          <UL>
             <LI ><A href="javascript:getCompCode('1001-前保险杠');"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 前保险杠 </A>
             <LI ><A href="javascript:getCompCode('1002-前杠骨架')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 前杠骨架 </A>
             <LI ><A href="javascript:getCompCode('1003-前机盖')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 前机盖 </A>
             <LI ><A href="javascript:getCompCode('1004-前面板')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 前面板 </A>
             <LI ><A href="javascript:getCompCode('1005-前下横梁')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 前下横梁 </A>
             <LI ><A href="javascript:getCompCode('1006-左前叶子板')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 左前叶子板 </A>
             <LI ><A href="javascript:getCompCode('1007-右前叶子板')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 右前叶子板 </A>
             <LI ><A href="javascript:getCompCode('1008-左前内旋')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 左前内旋 </A>
             <LI ><A href="javascript:getCompCode('1009-右前内旋')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 右前内旋 </A>
             <LI ><A href="javascript:getCompCode('1010-左前纵梁')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 左前纵梁 </A>
             <LI ><A href="javascript:getCompCode('1011-右前纵梁')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 右前纵梁 </A>
             <LI ><A href="javascript:getCompCode('1012-前防火墙')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 前防火墙 </A>
             <LI ><A href="javascript:getCompCode('1013-左前窗立柱')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 左前窗立柱 </A>
             <LI ><A href="javascript:getCompCode('1014-右前窗立柱')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 右前窗立柱 </A>
             <LI ><A href="javascript:getCompCode('1015-左前门立柱')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 左前门立柱 </A>
             <LI ><A href="javascript:getCompCode('1016-右前门立柱')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 右前门立柱 </A>
             <LI ><A href="javascript:getCompCode('1017-左前门')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 左前门 </A>
             <LI ><A href="javascript:getCompCode('1018-右前门')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 右前门 </A>
             <LI ><A href="javascript:getCompCode('1019-前龙门架')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 前龙门架 </A>
             <%--增加玻璃选项--%>
             <LI ><A href="javascript:getCompCode('1020-玻璃')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 玻璃 </A>
           </UL>
         </UL>
      </td>
    </tr>
    <tr>
      <td  id = "spanZhongBu" style="display:none">
      <UL>
        <LI><IMG src="/claim/images/treeFoderclassOpen.gif"></IMG>中部
          <UL>
            <LI ><A href="javascript:getCompCode('2001-中网')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 中网 </A>
            <LI ><A href="javascript:getCompCode('2002-水箱框架')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 水箱框架 </A>
            <LI ><A href="javascript:getCompCode('2003-车顶')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 车顶 </A>
            <LI ><A href="javascript:getCompCode('2004-左中门立柱')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 左中门立柱 </A>
            <LI ><A href="javascript:getCompCode('2005-右中门立柱')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 右中门立柱 </A>
            <LI ><A href="javascript:getCompCode('2006-中门')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 中门 </A>
            
            <%--增加玻璃选项--%>
            <LI ><A href="javascript:getCompCode('2007-玻璃')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 玻璃 </A>
          </UL>
        </UL>
      </td>  
    </tr>
    <tr>
      <td  id = "spanHouBu" style="display:none">
        <UL>
          <LI ><IMG src="/claim/images/treeFoderclassOpen.gif"></IMG>后部
          <UL>
            <LI ><A href="javascript:getCompCode('4001-左侧下大边')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 左侧下大边 </A>
            <LI ><A href="javascript:getCompCode('4002-右侧下大边')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 右侧下大边 </A>
            <LI ><A href="javascript:getCompCode('4003-车身底板')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 车身底板 </A>
            <LI ><A href="javascript:getCompCode('4004-左后门')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 左后门 </A>
            <LI ><A href="javascript:getCompCode('4005-右后门')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 右后门 </A>
            <LI ><A href="javascript:getCompCode('4006-左侧车身')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 左侧车身 </A>
            <LI ><A href="javascript:getCompCode('4007-右侧车身')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 右侧车身 </A>
            <LI ><A href="javascript:getCompCode('4008-左后叶子板')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 左后叶子板 </A>
            <LI ><A href="javascript:getCompCode('4009-右后叶子板')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 右后叶子板 </A>
            <LI ><A href="javascript:getCompCode('4010-左后立柱')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 左后立柱 </A>
            <LI ><A href="javascript:getCompCode('4011-右后立柱')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 右后立柱 </A>
            <LI ><A href="javascript:getCompCode('4012-后围板')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 后围板 </A>
            <LI ><A href="javascript:getCompCode('4013-后备板')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 后备板 </A>
            <LI ><A href="javascript:getCompCode('4014-后备箱盖')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 后备箱盖 </A>
            <LI ><A href="javascript:getCompCode('4015-后底板')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 后底板 </A>
            <LI ><A href="javascript:getCompCode('4016-左后纵梁')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 左后纵梁 </A>
            <LI ><A href="javascript:getCompCode('4017-右后纵梁')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 右后纵梁 </A>
            <LI ><A href="javascript:getCompCode('4018-车身大梁')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 车身大梁 </A>
            <LI ><A href="javascript:getCompCode('4019-后尾门')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 后尾门 </A>
            <LI ><A href="javascript:getCompCode('4020-后保险杠')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 后保险杠 </A>
            <LI ><A href="javascript:getCompCode('4021-后杠骨架')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 后杠骨架 </A>
            <LI ><A href="javascript:getCompCode('4022-左大厢板')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 左大厢板 </A>
            <LI ><A href="javascript:getCompCode('4023-右大厢板')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 右大厢板 </A>
            <LI ><A href="javascript:getCompCode('4024-大厢板')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 大厢板 </A>
            <%--增加玻璃选项--%>
             <LI ><A href="javascript:getCompCode('4025-玻璃')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 玻璃 </A>
           </UL>
         </UL>
      </td>
     </tr>
     
     
     
      <tr>
      <td  id = "spanLossItem" style="display:none">
        <UL>
          <LI ><IMG src="/claim/images/treeFoderclassOpen.gif"></IMG>其它损失部位
          <UL>
            <LI ><A href="javascript:getLossItemCode('5001-护栏')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 护栏 </A>
            <LI ><A href="javascript:getLossItemCode('5002-电线杆')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 电线杆 </A>
            <LI ><A href="javascript:getLossItemCode('5003-绿化带')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 绿化带 </A>
            <LI ><A href="javascript:getLossItemCode('5004-车上货物')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 车上货物 </A>
            <LI ><A href="javascript:getLossItemCode('5005-铁门')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 铁门 </A>
            <LI ><A href="javascript:getLossItemCode('5006-墙壁')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 墙壁 </A>
            <LI ><A href="javascript:getLossItemCode('5007-房屋')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 房屋 </A>
            <%--增加玻璃选项--%>
             <LI ><A href="javascript:getLossItemCode('5008-玻璃')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> 玻璃 </A>
           </UL>
         </UL>
      </td>
     </tr>
     
     
     <input type = "hidden" name = "txtIndex" value="<%=strIndex%>">
     <input type = "hidden" name = "txtPreviousFlag" value="<%=previousFlag%>">
     <tr>
      <td align="center">  
        <P><inut type="button" onclick=window.close(); class=button value="关 闭"></P>
      </td>
    </tr>
  </table>
  </form>
</BODY>
</html:html>
	
