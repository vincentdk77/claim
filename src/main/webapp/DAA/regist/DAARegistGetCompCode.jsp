<%--
****************************************************************************
* DESC       ���������ҳ��
* AUTHOR     ��������Ŀ��
* CREATEDATE ��2005-04-06
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
  
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%
  //�õ�����������λ��
  String strIndex=request.getParameter("strIndex");
  //�õ���λ����
  String strPartCode = request.getParameter("partCode").trim();
  //�õ����������ĸ�ģ��
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
   ��������ҳ��
  </title>
  <app:css />
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/regist/js/DAARegistEdit.js"></script>
  <script src="/claim/DAA/regist/js/DAAThirdCarLossEdit.js"></script>
  <script language="javascript">
    //������ʧ��λ�Ĳ�ͬ����ʾ��ͬ�����
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
  <tr class=listtitle><td class="formtitle">������Ŀ�б�</td></tr>
    <tr>
      <td  id = "spanQianBu" style="display:none">  
        <UL>
          <LI><IMG src="/claim/images/treeFoderclassOpen.gif"></IMG>ǰ��
          <UL>
             <LI ><A href="javascript:getCompCode('1001-ǰ���ո�');"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ǰ���ո� </A>
             <LI ><A href="javascript:getCompCode('1002-ǰ�ܹǼ�')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ǰ�ܹǼ� </A>
             <LI ><A href="javascript:getCompCode('1003-ǰ����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ǰ���� </A>
             <LI ><A href="javascript:getCompCode('1004-ǰ���')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ǰ��� </A>
             <LI ><A href="javascript:getCompCode('1005-ǰ�º���')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ǰ�º��� </A>
             <LI ><A href="javascript:getCompCode('1006-��ǰҶ�Ӱ�')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ��ǰҶ�Ӱ� </A>
             <LI ><A href="javascript:getCompCode('1007-��ǰҶ�Ӱ�')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ��ǰҶ�Ӱ� </A>
             <LI ><A href="javascript:getCompCode('1008-��ǰ����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ��ǰ���� </A>
             <LI ><A href="javascript:getCompCode('1009-��ǰ����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ��ǰ���� </A>
             <LI ><A href="javascript:getCompCode('1010-��ǰ����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ��ǰ���� </A>
             <LI ><A href="javascript:getCompCode('1011-��ǰ����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ��ǰ���� </A>
             <LI ><A href="javascript:getCompCode('1012-ǰ����ǽ')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ǰ����ǽ </A>
             <LI ><A href="javascript:getCompCode('1013-��ǰ������')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ��ǰ������ </A>
             <LI ><A href="javascript:getCompCode('1014-��ǰ������')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ��ǰ������ </A>
             <LI ><A href="javascript:getCompCode('1015-��ǰ������')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ��ǰ������ </A>
             <LI ><A href="javascript:getCompCode('1016-��ǰ������')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ��ǰ������ </A>
             <LI ><A href="javascript:getCompCode('1017-��ǰ��')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ��ǰ�� </A>
             <LI ><A href="javascript:getCompCode('1018-��ǰ��')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ��ǰ�� </A>
             <LI ><A href="javascript:getCompCode('1019-ǰ���ż�')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ǰ���ż� </A>
             <%--���Ӳ���ѡ��--%>
             <LI ><A href="javascript:getCompCode('1020-����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ���� </A>
           </UL>
         </UL>
      </td>
    </tr>
    <tr>
      <td  id = "spanZhongBu" style="display:none">
      <UL>
        <LI><IMG src="/claim/images/treeFoderclassOpen.gif"></IMG>�в�
          <UL>
            <LI ><A href="javascript:getCompCode('2001-����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ���� </A>
            <LI ><A href="javascript:getCompCode('2002-ˮ����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ˮ���� </A>
            <LI ><A href="javascript:getCompCode('2003-����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ���� </A>
            <LI ><A href="javascript:getCompCode('2004-����������')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ���������� </A>
            <LI ><A href="javascript:getCompCode('2005-����������')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ���������� </A>
            <LI ><A href="javascript:getCompCode('2006-����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ���� </A>
            
            <%--���Ӳ���ѡ��--%>
            <LI ><A href="javascript:getCompCode('2007-����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ���� </A>
          </UL>
        </UL>
      </td>  
    </tr>
    <tr>
      <td  id = "spanHouBu" style="display:none">
        <UL>
          <LI ><IMG src="/claim/images/treeFoderclassOpen.gif"></IMG>��
          <UL>
            <LI ><A href="javascript:getCompCode('4001-����´��')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ����´�� </A>
            <LI ><A href="javascript:getCompCode('4002-�Ҳ��´��')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> �Ҳ��´�� </A>
            <LI ><A href="javascript:getCompCode('4003-����װ�')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ����װ� </A>
            <LI ><A href="javascript:getCompCode('4004-�����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ����� </A>
            <LI ><A href="javascript:getCompCode('4005-�Һ���')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> �Һ��� </A>
            <LI ><A href="javascript:getCompCode('4006-��೵��')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ��೵�� </A>
            <LI ><A href="javascript:getCompCode('4007-�Ҳ೵��')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> �Ҳ೵�� </A>
            <LI ><A href="javascript:getCompCode('4008-���Ҷ�Ӱ�')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ���Ҷ�Ӱ� </A>
            <LI ><A href="javascript:getCompCode('4009-�Һ�Ҷ�Ӱ�')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> �Һ�Ҷ�Ӱ� </A>
            <LI ><A href="javascript:getCompCode('4010-�������')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ������� </A>
            <LI ><A href="javascript:getCompCode('4011-�Һ�����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> �Һ����� </A>
            <LI ><A href="javascript:getCompCode('4012-��Χ��')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ��Χ�� </A>
            <LI ><A href="javascript:getCompCode('4013-�󱸰�')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> �󱸰� </A>
            <LI ><A href="javascript:getCompCode('4014-�����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ����� </A>
            <LI ><A href="javascript:getCompCode('4015-��װ�')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ��װ� </A>
            <LI ><A href="javascript:getCompCode('4016-�������')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ������� </A>
            <LI ><A href="javascript:getCompCode('4017-�Һ�����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> �Һ����� </A>
            <LI ><A href="javascript:getCompCode('4018-�������')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ������� </A>
            <LI ><A href="javascript:getCompCode('4019-��β��')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ��β�� </A>
            <LI ><A href="javascript:getCompCode('4020-���ո�')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ���ո� </A>
            <LI ><A href="javascript:getCompCode('4021-��ܹǼ�')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ��ܹǼ� </A>
            <LI ><A href="javascript:getCompCode('4022-������')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ������ </A>
            <LI ><A href="javascript:getCompCode('4023-�Ҵ����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> �Ҵ���� </A>
            <LI ><A href="javascript:getCompCode('4024-�����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ����� </A>
            <%--���Ӳ���ѡ��--%>
             <LI ><A href="javascript:getCompCode('4025-����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ���� </A>
           </UL>
         </UL>
      </td>
     </tr>
     
     
     
      <tr>
      <td  id = "spanLossItem" style="display:none">
        <UL>
          <LI ><IMG src="/claim/images/treeFoderclassOpen.gif"></IMG>������ʧ��λ
          <UL>
            <LI ><A href="javascript:getLossItemCode('5001-����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ���� </A>
            <LI ><A href="javascript:getLossItemCode('5002-���߸�')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ���߸� </A>
            <LI ><A href="javascript:getLossItemCode('5003-�̻���')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> �̻��� </A>
            <LI ><A href="javascript:getLossItemCode('5004-���ϻ���')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ���ϻ��� </A>
            <LI ><A href="javascript:getLossItemCode('5005-����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ���� </A>
            <LI ><A href="javascript:getLossItemCode('5006-ǽ��')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ǽ�� </A>
            <LI ><A href="javascript:getLossItemCode('5007-����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ���� </A>
            <%--���Ӳ���ѡ��--%>
             <LI ><A href="javascript:getLossItemCode('5008-����')"><IMG border=0 src="/claim/images/treeNode.gif"></IMG> ���� </A>
           </UL>
         </UL>
      </td>
     </tr>
     
     
     <input type = "hidden" name = "txtIndex" value="<%=strIndex%>">
     <input type = "hidden" name = "txtPreviousFlag" value="<%=previousFlag%>">
     <tr>
      <td align="center">  
        <P><inut type="button" onclick=window.close(); class=button value="�� ��"></P>
      </td>
    </tr>
  </table>
  </form>
</BODY>
</html:html>
	
