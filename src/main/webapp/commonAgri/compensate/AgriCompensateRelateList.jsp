<%--
****************************************************************************
* DESC       �������嵥����ҳ��
* AUTHOR     ����Ԫ��Ŀ��
* CREATEDATE ��2011-06-06
* MODIFYLIST ��  Name      Date      Reason/Contents
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
  int intRecodeNum = 20; //ÿҳ��ʾ�ļ�¼��
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
  <title>��ʾ����ҳ��</title>
  <!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script language="javascript">
		//ҳ����ת
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
        alert("û����һҳ�������ԣ�");
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

<%-- ����loadForm ��ʼ��ҳ�� --%>
<body class="interface" background="/claim/images/bgCommon.gif">
<form name="fm" action="/claim/commonAgri/compensate/AgriCompensateRelateList.jsp" method="POST">
  <table class="common" align="center" cellspacing="3" cellpadding="5">
    <tr>
      <td class="formtitle" colspan="12">�����嵥��Ϣ</td>
    </tr>
      <tr class=listtitle>
        <td width='10%'>�����嵥��</td>
        <td width='8%'>ũ������</td>
        <td width='12%'>ũ������</td>
        <td width='10%'>ũ�����֤</td>
        <td width='10%'>ֱ������</td>
        <td width='8%'>�б����</td>
        <td width='6%'>�ɳ��ڱ���</td>
        <td width='6%'>��ʧ��</td>
        <td width='8%'>��ʧ���</td>
        <td width='8%'>�����</td>
        <td width='6%'>����</td>
        <td width='8%'>��Ч��־λ</td>
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
        <td class=page>��Ч</td>
        <% }else if("2".equals((String)arrayListForResult.get(11))){%>
        <td class=page>�ݴ�</td>
        <%}else if("1".equals((String)arrayListForResult.get(11))){%>
        <td class=page>���ύ</td>
        <%}%>
        
      </tr>
     <% }
 	  } %>
      <tr>
        <td class=input colspan=12 align=center>��ҳ�� <%=i%> ����¼���������� <%=intPageNum%> ҳ / �� <%=intPageCount%> ҳ</td>
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
          <input name="FirstPage" class="button" type="button" alt="��ҳ" value="��ҳ" onclick="gotoPage('First');">����
          <input name="PreviousPage" class="button" type="button" alt="��һҳ" value="��һҳ" onclick="gotoPage('Previous');">����
<%
  }
  if(intPageNum<intPageCount)
  {
%>
          <input name="NextPage" class="button" type="button" alt="��һҳ" value="��һҳ" onclick="gotoPage('Next');">����
          <input name="FinalPage" class="button" type="button" alt="���һҳ" value="���һҳ" onclick="gotoPage('Final');">����
<%
  }
  if(intPageCount>1)
  {
%>
          ת���� <input class=small type="text" name="Personal" size="2" value="<%=intPageNum%>"> ҳ��<input name="PersonalPage" class="smallbutton" type="button" alt="GO" value="GO" onclick="gotoPage('Personal');">
<%
  }
%>
        </td>
      </tr>
  </table>
</body>
</html>
