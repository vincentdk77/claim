<%--
****************************************************************************
* DESC       ����������������ӡ��ѯ�б���ҳ��
* AUTHOR     ��lirui
* CREATEDATE ��2003-12-25
* MODIFYLIST ��   Name       Date            Reason/Contents
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
//�������壺
  String strClass         = "";   //�б��е�css��ʽ
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
  int intPageSize = 20;//ÿҳ��ʾ����
  int intRowCount=0;
  int intPageCount=0;
  int intPage;//��ǰ�ǵڼ�ҳ
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
    intRowCount = collection1.size();//�ܼ�¼��
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
  <title>�ⰸ������������ӡѡ��ҳ��</title>
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <%-- ���ú��� --%>
  <script src="/claim/common/js/Common.js"></script>
  <%-- ��ҳ���� --%>
  <script src="/claim/DAA/print/js/DAACompensatePrintBeforeQuery.js"></script>
</head>
<body class="interface" background="/claim/images/bgCommon.gif">
  <form name=fm action="/claim/DAA/print/DAACompensatePrintQueryList.jsp" target="_blank">
    <input type="checkbox" name="CheckedCompensateNo"  style="display:none">
    <input type="checkbox" name="PrintNo"  style="display:none">
    <table class="common" align=center>
      <tr class="listtitle">
        <td style="width:5%">ѡ��</td>
        <td style="width:25%">���������</td>
        <td style="width:25%">������</td>
        <td style="width:5%">����ʶ</td>
        <td style="width:10%">������</td>
        <td style="width:15%">����ͨ������</td>  
       <td style="width:15%">��������</td>
      </tr>
<%
  //��ӡ�б�
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
          <td>δ��</td>  
          <td><%=prplcompensate.getUnderWriteName()%></td>  
          <td><%=prplcompensate.getUnderWriteEndDate()%></td>       
        <%  }else{%>
         <td>����</td>
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
      	    ����ѯ�� <%=intRowCount%> �����������ļ�¼,ÿҳ20��    ��ǰ��<%=(intPage+1)%>ҳ  ��<%=intPageCount%>ҳ
<%if(intPage != 1){%><a href="DAACompensatePrintBeforeQuery.jsp?page=0&ClaimNo=<%=strClaimNo%>
&ClaimNoSign=<%=strClaimNoSign%>&CompensateNo=<%=strCompendateNo%>&CompensateNoSign=<%=strCompendateNoSign%>
&ClaimStatus=<%=strClaimStatus%>&UndwriteendDate=<%=strUnderwriteendDate%>&UndwritebeginDate=<%=strUnderwritebeginDate%>
&UndwriteendDateSign=<%=strUnderwriteendDateSign%>">��ҳ</a><%}%> 
<%if(intPage>=1){%><a href="DAACompensatePrintBeforeQuery.jsp?page=<%=intPage-1%>&ClaimNo=<%=strClaimNo%>
&ClaimNoSign=<%=strClaimNoSign%>&CompensateNo=<%=strCompendateNo%>&CompensateNoSign=<%=strCompendateNoSign%>
&ClaimStatus=<%=strClaimStatus%>&UndwriteendDate=<%=strUnderwriteendDate%>&UndwritebeginDate=<%=strUnderwritebeginDate%>
&UndwriteendDateSign=<%=strUnderwriteendDateSign%>">��һҳ</a><%}%>  
<%if(intPageCount!=1&&intPage<intPageCount){%><a href="DAACompensatePrintBeforeQuery.jsp?page=<%=intPage+1%>&ClaimNo=<%=strClaimNo%>
&ClaimNoSign=<%=strClaimNoSign%>&CompensateNo=<%=strCompendateNo%>&CompensateNoSign=<%=strCompendateNoSign%>
&ClaimStatus=<%=strClaimStatus%>&UndwriteendDate=<%=strUnderwriteendDate%>&UndwritebeginDate=<%=strUnderwritebeginDate%>
&UndwriteendDateSign=<%=strUnderwriteendDateSign%>">��һҳ</a><%}%>  
<%if(intPage != intPageCount){%><a href="DAACompensatePrintBeforeQuery.jsp?page=<%=intPageCount-1%>&ClaimNo=<%=strClaimNo%>
&ClaimNoSign=<%=strClaimNoSign%>&CompensateNo=<%=strCompendateNo%>&CompensateNoSign=<%=strCompendateNoSign%>
&ClaimStatus=<%=strClaimStatus%>&UndwriteendDate=<%=strUnderwriteendDate%>&UndwritebeginDate=<%=strUnderwritebeginDate%>
&UndwriteendDateSign=<%=strUnderwriteendDateSign%>">βҳ</a><%}%> 
      	    	  </td>
      	</tr>
        <tr id="trCheckboxAll">
          <td colspan="8" class="title">
            <input type="checkbox" name="CheckboxAll" onClick="CheckboxAll_onclick()">ȫѡ          
            
            </td>
           
        </tr>
    </table>    
    <table class="common" align=center>
      <tr>
        <td class="button">
          <input  class="button" type="button" name="buttonSave" value=" �� ӡ " onClick="submit();">
        </td>
        <td class="button">
          <input  class="button" type="button" name="buttonCancel" value=" ȡ �� " onClick="cancelForm();">
        </td>
      </tr>
    </table>

  </form>
</body>
</html>
