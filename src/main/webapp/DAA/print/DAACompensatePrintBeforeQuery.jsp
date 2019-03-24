<%--
****************************************************************************
* DESC       ：保单单车连续打印查询列表框架页面
* AUTHOR     ：lirui
* CREATEDATE ：2003-12-25
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="com.sinosoft.sysframework.reference.DBManager"%>
<%@page import="com.sinosoft.sysframework.reference.AppConfig"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.bl.action.domain.*"%>
<%@page import="com.sinosoft.utility.string.*"%>
<%@page import="com.sinosoft.claim.util.StringConvert"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.sinosoft.claim.ui.control.viewHelper.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>

<%
//变量定义：
  String strClass         = "";   //列表行的css样式
  String strClaimNo = request.getParameter("ClaimNo");
  String strClaimNoSign = request.getParameter("ClaimNoSign");
  String strCompendateNo =request.getParameter("CompensateNo");
  String strCompendateNoSign =request.getParameter("CompensateNoSign");
  String strClaimStatus = request.getParameter("ClaimStatus");
  String strUnderwriteendDate =request.getParameter("UndwriteendDate");
  String strUnderwritebeginDate =request.getParameter("UndwritebeginDate");
  String strUnderwriteendDateSign =request.getParameter("UndwriteendDateSign");
  String strSQL = "";
  String strSQL1 = "";
  String strSqlTmp = "";
  int intPageSize = 20;//每页显示几条
  int intRowCount=0;
  int intPageCount=0;
  int intPage;//当前是第几页
  String strPage;
  strPage = request.getParameter("page");
  if(strPage == null){
  intPage = 0;
 }else{
  intPage = Integer.parseInt(strPage);

 }
    int i = 0;

   Collection collection = null;
   Collection collection1 = null;
  if(strClaimStatus.equals("1"))
  {
    strSQL1 = "Select l.Compensateno,l.Claimno,l.Underwritecode,l.Underwritename,l.Underwriteenddate From Prplcompensate l Where l.Underwriteflag <> '1' ";
    if(!strCompendateNo.equals(""))
    {
      if(strCompendateNoSign.equals("*"))
      {
        strSQL1 += " And l.COMPENSATENO like '" + strCompendateNo + "%'";
      }
      else if(strCompendateNoSign.equals("="))
      {
        strSQL1 += " And l.COMPENSATENO" + strCompendateNoSign + "'" + strCompendateNo + "1";
      }
    }
    if(!strClaimNo.equals(""))
    {
      if(strClaimNoSign.equals("*"))
      {
        strSQL1 += " And l.ClaimNo like '%" + strClaimNo + "%'";
      }
      else if(strClaimNoSign.equals("="))
      {
        strSQL1 += " And l.ClaimNo" + strClaimNoSign + "'" + strClaimNo + "'";
      }
    }
    if(!strUnderwriteendDate.equals(""))
    {
      //strSqlTmp = strSqlTmp + StringConvert.convertDate("Underwriteenddate",strUnderwriteendDate,strUnderwriteendDateSign);
      //strSqlTmp = strSqlTmp.substring(4);
     // strSQL += " And l." + strSqlTmp;
    }
    strSQL1 += "union select l.Compensateno,l.Claimno,l.Underwritecode,l.Underwritename,l.Underwriteenddate from Prplcompensate l,Prpjplanfee f where f.Certitype = 'C' and l.Compensateno = f.Certino and f.Planfee > f.Realpayreffee ";
    strSqlTmp = "";
    if(!strCompendateNo.equals(""))
    {
      if(strCompendateNoSign.equals("*"))
      {
        strSQL1 += " And l.COMPENSATENO like '%" + strCompendateNo + "%'";
      }
      else if(strCompendateNoSign.equals("="))
      {
        strSQL1 += " And l.COMPENSATENO" + strCompendateNoSign + "'" + strCompendateNo + "1";
      }
    }
    if(!strClaimNo.equals(""))
    {
      if(strClaimNoSign.equals("*"))
      {
        strSQL1 += " And l.ClaimNo like '%" + strClaimNo + "%'";
      }
      else if(strClaimNoSign.equals("="))
      {
        strSQL1 += " And l.ClaimNo" + strClaimNoSign + "'" + strClaimNo + "'";
      }
    }
    if(!strUnderwriteendDate.equals(""))
    {
      //strSqlTmp = strSqlTmp + StringConvert.convertDate("Underwriteenddate",strUnderwriteendDate,strUnderwriteendDateSign);
      //strSqlTmp = strSqlTmp.substring(4);
      //strSQL += " And l." + strSqlTmp;
    }
     strSQL=" SELECT CompensateNo,ClaimNo,UnderWriteCode,UnderWriteName,UnderWriteEndDate FROM ( " 
  +"Select rownumber() over(Order By compensateno DESC) As LineNum,U.* From ("+ strSQL1 +")U )T " +
   " Where T.LineNum<=" + (intPage+1)*intPageSize + " And T.LineNum>" +  intPage*intPageSize ;
  }
  else
  {
    strSQL1 = "select c.Compensateno,c.Claimno,c.Underwritecode,c.Underwritename,c.Underwriteenddate,r.payrefdate,r.PAYREFNAME from Prplcompensate c,Prpjplanfee f,Prpjpayrefrec r where f.Certitype = 'C' and c.Compensateno = f.Certino and f.Planfee = f.Realpayreffee and f.Certitype = r.Certitype and f.Certino = r.Certino";
    if(!strCompendateNo.equals(""))
    {
      if(strCompendateNoSign.equals("*"))
      {
        strSQL1 += " And c.COMPENSATENO like '%" + strCompendateNo + "%'";
      }
      else if(strCompendateNoSign.equals("="))
      {
        strSQL1 += " And c.COMPENSATENO" + strCompendateNoSign + "'" + strCompendateNo + "1";
      }
    }
    if(!strClaimNo.equals(""))
    {
      if(strClaimNoSign.equals("*"))
      {
        strSQL1 += " And c.ClaimNo like '%" + strClaimNo + "%'";
      }
      else if(strClaimNoSign.equals("="))
      {
        strSQL1 += " And c.ClaimNo" + strClaimNoSign + "'" + strClaimNo + "'";
      }
    }
    if(!strUnderwritebeginDate.equals("")&&!strUnderwriteendDate.equals(""))
    {
       strSQL1 +=" and r.payrefdate between Sinosoft_To_Date('"+strUnderwritebeginDate+"', 'YYYY-MM-DD') and Sinosoft_To_Date('"+strUnderwriteendDate+"','YYYY-MM-DD')";
    }
    
     strSQL=" SELECT CompensateNo,ClaimNo,UnderWriteCode,UnderWriteName,UnderWriteEndDate,payrefdate,PAYREFNAME FROM ( " 
  +"Select rownumber() over(Order By compensateno DESC) As LineNum,U.* From ("+ strSQL1 +")U )T " +
   " Where T.LineNum<=" + (intPage+1)*intPageSize + " And T.LineNum>" +  intPage*intPageSize ;
  }
    
  BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
  DBManager dbManager = new DBManager();
  try{
    dbManager.open(AppConfig.get("sysconst.DBJNDI"));
    dbManager.beginTransaction();
    collection = blPrpLcompensateAction.findBySQLConditions(dbManager,strSQL,strClaimStatus);
    collection1 = blPrpLcompensateAction.findBySQLConditions(dbManager,strSQL1,strClaimStatus);
    intRowCount = collection1.size();//总记录数
    intPageCount = intRowCount%intPageSize == 0 ? intRowCount/intPageSize : intRowCount/intPageSize+1;
    dbManager.commitTransaction();
  }catch(Exception ex)
  {
    dbManager.rollbackTransaction();
    throw ex;
  }finally{
    dbManager.close();
  }
%>

<html>
<head>
  <title>赔案理算书连续打印选择页面</title>
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <%-- 公用函数 --%>
  <script src="/claim/common/js/Common.js"></script>
  <%-- 本页函数 --%>
  <script src="/claim/DAA/print/js/DAACompensatePrintBeforeQuery.js"></script>
</head>
<body class="interface" background="/claim/images/bgCommon.gif">
  <form name=fm action="/claim/DAA/print/DAACompensatePrintQueryList.jsp" target="_blank">
    <input type="checkbox" name="CheckedCompensateNo"  style="display:none">
    <input type="checkbox" name="PrintNo"  style="display:none">
    <table class="common" align=center>
      <tr class="listtitle">
        <td style="width:5%">选择</td>
        <td style="width:25%">赔款计算书号</td>
        <td style="width:25%">立案号</td>
        <td style="width:5%">赔款标识</td>
        <td style="width:10%">核赔人</td>
        <td style="width:15%">核赔通过日期</td>  
       <td style="width:15%">付款日期</td>
      </tr>
<%
  //打印列表
  Iterator it =collection.iterator();
 while (it.hasNext())
  {
    
    if(i%2==0)
    {
      strClass = "listodd";
    }
    else
    {
      strClass = "listeven";
    }

    PrpLcompensateDto prplcompensate = (PrpLcompensateDto)it.next();
%>

        <tr class="<%=strClass%>">
          <td><input type="checkbox" name="CheckedCompensateNo" value='<%=prplcompensate.getCompensateNo()%>' onClick="CheckedCompensateNo_onclick(this)">
              <input type="checkbox" name="PrintNo" value='<%=prplcompensate.getCompensateNo()%>' style="display:none">          </td>
          <td><a href="/claim/ClaimPrint.do?printType=Compensate&CompensateNo=<%=prplcompensate.getCompensateNo()%>&compensateFlag=1" target="_blank"><%=prplcompensate.getCompensateNo()%></a></td>
          <td><%=prplcompensate.getClaimNo()%></td>     
       <%   if(strClaimStatus.equals("1"))
          { %>
          <td>未赔</td>  
          <td><%=prplcompensate.getUnderWriteName()%></td>  
          <td><%=prplcompensate.getUnderWriteEndDate()%></td>       
        <%  }else{%>
         <td>已赔</td>
         <td><%=prplcompensate.getUnderWriteName()%></td> 
         <td><%=prplcompensate.getUnderWriteEndDate()%></td>
         <td ><%=prplcompensate.getPayrefDate()%></td>
         <%}%>
        </tr>
<%
  }
%>
      	<tr>
      	  <td colspan=8 class=input align=center>
      	    共查询出 <%=intRowCount%> 条满足条件的记录,每页20条    当前第<%=(intPage+1)%>页  共<%=intPageCount%>页
<%if(intPage != 1){%><a href="DAACompensatePrintBeforeQuery.jsp?page=0&ClaimNo=<%=strClaimNo%>
&ClaimNoSign=<%=strClaimNoSign%>&CompensateNo=<%=strCompendateNo%>&CompensateNoSign=<%=strCompendateNoSign%>
&ClaimStatus=<%=strClaimStatus%>&UndwriteendDate=<%=strUnderwriteendDate%>&UndwritebeginDate=<%=strUnderwritebeginDate%>
&UndwriteendDateSign=<%=strUnderwriteendDateSign%>">首页</a><%}%> 
<%if(intPage>=1){%><a href="DAACompensatePrintBeforeQuery.jsp?page=<%=intPage-1%>&ClaimNo=<%=strClaimNo%>
&ClaimNoSign=<%=strClaimNoSign%>&CompensateNo=<%=strCompendateNo%>&CompensateNoSign=<%=strCompendateNoSign%>
&ClaimStatus=<%=strClaimStatus%>&UndwriteendDate=<%=strUnderwriteendDate%>&UndwritebeginDate=<%=strUnderwritebeginDate%>
&UndwriteendDateSign=<%=strUnderwriteendDateSign%>">上一页</a><%}%>  
<%if(intPageCount!=1&&intPage<intPageCount){%><a href="DAACompensatePrintBeforeQuery.jsp?page=<%=intPage+1%>&ClaimNo=<%=strClaimNo%>
&ClaimNoSign=<%=strClaimNoSign%>&CompensateNo=<%=strCompendateNo%>&CompensateNoSign=<%=strCompendateNoSign%>
&ClaimStatus=<%=strClaimStatus%>&UndwriteendDate=<%=strUnderwriteendDate%>&UndwritebeginDate=<%=strUnderwritebeginDate%>
&UndwriteendDateSign=<%=strUnderwriteendDateSign%>">下一页</a><%}%>  
<%if(intPage != intPageCount){%><a href="DAACompensatePrintBeforeQuery.jsp?page=<%=intPageCount-1%>&ClaimNo=<%=strClaimNo%>
&ClaimNoSign=<%=strClaimNoSign%>&CompensateNo=<%=strCompendateNo%>&CompensateNoSign=<%=strCompendateNoSign%>
&ClaimStatus=<%=strClaimStatus%>&UndwriteendDate=<%=strUnderwriteendDate%>&UndwritebeginDate=<%=strUnderwritebeginDate%>
&UndwriteendDateSign=<%=strUnderwriteendDateSign%>">尾页</a><%}%> 
      	    	  </td>
      	</tr>
        <tr id="trCheckboxAll">
          <td colspan="8" class="title">
            <input type="checkbox" name="CheckboxAll" onClick="CheckboxAll_onclick()">全选          
            
            </td>
           
        </tr>
    </table>    
    <table class="common" align=center>
      <tr>
        <td class="button">
          <input  class="button" type="button" name="buttonSave" value=" 打 印 " onClick="submit();">
        </td>
        <td class="button">
          <input  class="button" type="button" name="buttonCancel" value=" 取 消 " onClick="cancelForm();">
        </td>
      </tr>
    </table>

  </form>
</body>
</html>
