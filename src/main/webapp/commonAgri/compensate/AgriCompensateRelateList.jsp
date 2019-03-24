<%--
****************************************************************************
* DESC       ：理赔清单关联页面
* AUTHOR     ：国元项目组
* CREATEDATE ：2011-06-06
* MODIFYLIST ：  Name      Date      Reason/Contents
*          --------------------------------------------------
****************************************************************************
--%>

<%@page errorPage="/UIErrorPage"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade"%>

<%
  String RelationListNo = request.getParameter("RelationListNo");
  String strRiskCode= request.getParameter("vStrRiskCode");
  int i = 0;
  int intRecodeNum = 20; //每页显示的记录数
  int intPageNum = 0;
  int intPageCount = 0;

  
  
  String strPageNum = request.getParameter("PageNum");
  String strPageCount ="";
  String strTrClass ="";
  String strLink ="";
  String strWhere ="";
  if(strPageNum==null||strPageNum.trim().equals(""))
    intPageNum = 1;
  else
    intPageNum = Integer.parseInt(strPageNum.trim());

  	strWhere=" settlelistcode ='" + RelationListNo + "' and validity='1' and ABS(settlearea)>0";
  	if(null==strRiskCode||"".equals(strRiskCode)){
  	}else{
  		strWhere += " and INSURECATEGORY='"+strRiskCode+"' ";
  	}
  	
  	Collection arrayListForRelateList = new BLPrpLcompensateFacade().findByConditionsForNXDA(strWhere,intPageNum,intRecodeNum);
  	

  	intPageCount = new BLPrpLcompensateFacade().getCountForNXDA(strWhere);
	  if(intPageCount>0)
	  {
	    intPageCount = (intPageCount-1)/intRecodeNum+1;
	  }
	  else
	  {
	    intPageCount = 0;
	    intPageNum = 0;
	  }
%>


<html>
<head>
  <title>显示关联页面</title>
  <!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script language="javascript">
		//页面跳转
  function gotoPage(strMethod)
  {
    if(parseInt(fm.PageNum.value)==1)
    {
      fm.NextPage.disabled = true;
      fm.FinalPage.disabled = true;
    }
    else if(parseInt(fm.PageNum.value)==parseInt(fm.PageCount.value))
    {
      fm.FirstPage.disabled = true;
      fm.PreviousPage.disabled = true;
    }
    else
    {
      fm.FirstPage.disabled = true;
      fm.PreviousPage.disabled = true;
      fm.NextPage.disabled = true;
      fm.FinalPage.disabled = true;
    }

    if(parseInt(fm.PageCount.value)>1)
      fm.PersonalPage.disabled = true;
    if(strMethod=="First")
      fm.PageNum.value = 1;
    else if(strMethod=="Previous")
      fm.PageNum.value = parseInt(fm.PageNum.value)-1;
    else if(strMethod=="Next")
     
      fm.PageNum.value = parseInt(fm.PageNum.value)+1;
    else if(strMethod=="Final")
      fm.PageNum.value = fm.PageCount.value;
    else if(strMethod=="Personal")
    {
      if(parseInt(fm.Personal.value)<1||parseInt(fm.Personal.value)>parseInt(fm.PageCount.value))
      {
        alert("没有这一页，请重试！");
        fm.Personal.focus();

        if(parseInt(fm.PageNum.value)==1)
        {
          fm.NextPage.disabled = false;
          fm.FinalPage.disabled = false;
        }
        else if(parseInt(fm.PageNum.value)==parseInt(fm.PageCount.value))
        {
          fm.FirstPage.disabled = false;
          fm.PreviousPage.disabled = false;
        }
        else
        {
          fm.FirstPage.disabled = false;
          fm.PreviousPage.disabled = false;
          fm.NextPage.disabled = false;
          fm.FinalPage.disabled = false;
        }

        if(parseInt(fm.PageCount.value)>1)
          fm.PersonalPage.disabled = false;

        return false;
      }
      else
      {
        fm.PageNum.value = fm.Personal.value;
      }
    }

    fm.submit();
  }
  </script>
</head>

<%-- 调用loadForm 初始化页面 --%>
<body class="interface" background="/claim/images/bgCommon.gif">
<form name="fm" action="/claim/commonAgri/compensate/AgriCompensateRelateList.jsp" method="POST">
  <table class="common" align="center" cellspacing="3" cellpadding="5">
    <tr>
      <td class="formtitle" colspan="12">理赔清单信息</td>
    </tr>
      <tr class=listtitle>
        <td width='10%'>理赔清单号</td>
        <td width='8%'>农户代码</td>
        <td width='12%'>农户姓名</td>
        <td width='10%'>农户身份证</td>
        <td width='10%'>直补卡号</td>
        <td width='8%'>承保面积</td>
        <td width='6%'>成长期比例</td>
        <td width='6%'>损失率</td>
        <td width='8%'>损失面积</td>
        <td width='8%'>赔款金额</td>
        <td width='6%'>险种</td>
        <td width='8%'>有效标志位</td>
      </tr>
	<% Iterator iterator = arrayListForRelateList.iterator();
	    while(iterator.hasNext())
  		{ 
			ArrayList arrayListForResult = (ArrayList)iterator.next();
			if(null!=arrayListForResult&&arrayListForResult.size()>0){
				i++;
		%> 
  
	  <tr >
        <td class=page><%=arrayListForResult.get(0) %></td>
        <td class=page><%=arrayListForResult.get(1) %></td>
        <td class=page><%=arrayListForResult.get(2) %></td>
        <td class=page><%=arrayListForResult.get(3) %></td>
        <td class=page><%=arrayListForResult.get(4) %></td>
        <td class=page><%=arrayListForResult.get(5) %></td>
        <td class=page><%=arrayListForResult.get(6) %></td>
        <td class=page><%=arrayListForResult.get(7) %></td>
        <td class=page><%=arrayListForResult.get(8) %></td>
        <td class=page><%=arrayListForResult.get(9) %></td>
        <td class=page><%=arrayListForResult.get(10) %></td>
        <%if("0".equals((String)arrayListForResult.get(11))){%>
        <td class=page>无效</td>
        <% }else if("2".equals((String)arrayListForResult.get(11))){%>
        <td class=page>暂存</td>
        <%}else if("1".equals((String)arrayListForResult.get(11))){%>
        <td class=page>已提交</td>
        <%}%>
        
      </tr>
     <% }
 	  } %>
      <tr>
        <td class=input colspan=12 align=center>本页共 <%=i%> 条记录　　　　第 <%=intPageNum%> 页 / 共 <%=intPageCount%> 页</td>
      </tr>
    </table>
    <table class="common" align="center">
      <tr>
        <td align=center>
          <input type="hidden" name="PageNum" value="<%=intPageNum%>">
          <input type="hidden" name="PageCount" value="<%=intPageCount%>">
          <input type="hidden" name="WherePart" value="<%=strWhere%>">
          <input type="hidden" name="RelationListNo" value="<%=RelationListNo%>">
          <br>
<%
  if(intPageNum>1)
  {
%>
          <input name="FirstPage" class="button" type="button" alt="首页" value="首页" onclick="gotoPage('First');">　　
          <input name="PreviousPage" class="button" type="button" alt="上一页" value="上一页" onclick="gotoPage('Previous');">　　
<%
  }
  if(intPageNum<intPageCount)
  {
%>
          <input name="NextPage" class="button" type="button" alt="下一页" value="下一页" onclick="gotoPage('Next');">　　
          <input name="FinalPage" class="button" type="button" alt="最后一页" value="最后一页" onclick="gotoPage('Final');">　　
<%
  }
  if(intPageCount>1)
  {
%>
          转到第 <input class=small type="text" name="Personal" size="2" value="<%=intPageNum%>"> 页　<input name="PersonalPage" class="smallbutton" type="button" alt="GO" value="GO" onclick="gotoPage('Personal');">
<%
  }
%>
        </td>
      </tr>
  </table>
</body>
</html>
