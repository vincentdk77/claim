<%--
****************************************************************************
* DESC       �������Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��lixiang
* CREATEDATE ��2004-04-14
* MODIFYLIST ��   Name       Date            Reason/Contents
                  liubvo     2004/07/02      ȥ���˹�������Ϣ���棬�޸��˸�ʽ
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.prpall.pubfun.*"%>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@ page import="java.util.Map" %>

<%  
 Map mapList =(Map)request.getAttribute("mapList");
 RegistDto registDto =(RegistDto)request.getAttribute("registDto"); 
 ArrayList  lossKindCode = (ArrayList)request.getAttribute("lossKindCode"); 
 ArrayList  lossModeCode = (ArrayList)request.getAttribute("lossModeCode"); 
 String policyInputDate =(String)request.getAttribute("policyInputDate"); 
 String isShow = request.getParameter("isShow");//�ٱ�Σ�յ�λ�õ�

%>

<script language="JavaScript">
<!--
	javascript:window.history.forward(1);
//-->
</script>

<html:html locale="true">
<head>
  <!--��title����-->
  <title>��������</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/claim/js/DAAClaimEdit.js"></script>
  <script src="/claim/DAA/regist/js/DAAThirdCarLossEdit.js"></script>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>

  <script language="javascript">
  
  function oninitSum()
  {
    var sum = 0;
    var kindloss = 0;
    for(i=0;i<fm.all("prpLclaimLossSumClaim").length;i++){
     
      if(fm.all("prpLclaimLossSumClaim")[i].value>0){
        sum = sum+parseFloat(fm.all("prpLclaimLossSumClaim")[i].value);
      }
       if(fm.all("prpLclaimLossKindLoss")[i].value>0){
        kindloss = kindloss+parseFloat(fm.all("prpLclaimLossKindLoss")[i].value);
      }
    }

        fm.prpLclaimSumClaim.value=pointTwo(kindloss);
        fm.prpLdangerRiskSumClaim.value=pointTwo(sum);
     
  }
</script>

<%
  String editType=request.getParameter("editType");
  //�༭�Ͳ�ѯ״̬�µ�����Σ�յ�λ��ֵ
  if (editType.equals("SHOW")){
%>
<body class="interface" onload="initPage();initSet();dutySum();oninitSum();readonlyAllInput();disabledAllButton('buttonArea');showButton();loadDangerUnit();">
<%
}else if(editType.equals("EDIT")){
%>
<body class="interface" onload="loadDangerUnit();">
<%
}
else{
%>
<body class="interface" onload="initPage();initSet();oninitSum();dutySum();">
<%
}
%>
    <form name=fm action="/claim/claimSave.do" method="post" onsubmit="return validateForm(this);">
    <%session.setAttribute("oldClaimLastAccessedTime","");%>

      <%-- 1.��������Ϣ --%>
      <%@include file="/DAA/claim/DAAClaimMainEdit.jsp" %>

      <%-- 2.��������Ϣ --%>
      <%// @include file="/DAA/claim/DAAClaimFeeEdit.jsp" --%>


      <%-- 3.��ӵ�֤ --%>
      <%//@include file="/DAA/claim/DAAClaimDocEdit.jsp"%>

      

      <%-- 2.�ر�Լ�� --%>
      <%@include file="/DAA/compensate/DAACompensateCengage.jsp"%>

      <%-- 4.�永���� --%>
      <%@include file="/DAA/claim/DAAClaimThirdPartyEdit.jsp"%>

      <%-- �Ʋ���ʧ��λ��Ϣ --%>
      <%@include file="/DAA/regist/DAARegistThirdPropEdit.jsp"%>

     <%--������˸�����Ϣ 2005-07-26--%>      
      <%@include file="/DAA/claim/DAASelfClaimPersonTraceEdit.jsp"%>

      <%-- 5.��ʻԱ��Ϣ --%>
      <%@include file="/DAA/claim/DAAClaimDriverEdit.jsp"%>

      <%-- 6.�������� --%>
      <%@include file="/DAA/claim/DAAClaimTextEdit.jsp"%>

	  <!--modify by liyanjie ���ر�Լ��ǰ�����˴�
	  <!--modify by wangwei add start 2005-06-06-->
      <!--ԭ����Ӿ��ִ�����Ϣ-->
      <%@include file="/DAA/claim/PropClaimKelpInfo.jsp"%>
      <!--modify by wangwei add end 2005-06-06-->
      
      <%-- 2.�ձ��������Ϣ --%>
      <%@include file="/DAA/claim/DAAClaimLossEdit.jsp"%>

      <%-- 8.������ϵ��¼ 2005-07-18 --%>
      <%@include file="/DAA/regist/DAARegistExtEdit.jsp"%>
      <%-- 9.ָ��Σ�յ�λ��Ϣ --%>
      <%
	    PubTools pubTools=new PubTools();
	    int time= pubTools.compareDate(policyInputDate,"2011-02-27");
	    if(time<0){
	    //�þɵ�Σ�յ�λ��Ϣҳ��
    %>  
       <%@include file="/common/claim/ClaimRiskUnit.jsp"%>
     <%
	    }else{ 
	    //���µ�Σ�յ�λ��Ϣҳ��
	  %>
        <%@include file="/common/claim/ClaimNewRiskUnit.jsp"%>
     <%} %>
      <%-- ����ͨ�ð�ť --%>
       <%@include file="/DAA/claim/DAAClaimSave.jsp"%>
       <%-- �������鷵�ذ��o--%>
             <c:if test="${not empty param.caseNoQuery1 and param.caseNoQuery1 eq 'caseNoQuery1'}">
              <center> 
                <input type="button" class="button" onclick="window.close()" value="�ر�"/>
              </center>
        </c:if>

 </form>

</body>
</html:html>
<%--����Ҫ��
<script language="JavaScript">
    <!--
	var compAmout =0;
	var nowAmout =0;


	for( var n=1;n<fm.prpLclaimLossSumClaim.length;n++)
 		{
 			nowAmout =parseFloat(fm.prpLclaimLossSumClaim[n].value)
			compAmout = compAmout + nowAmout;
    }

	fm.prpLclaimSumClaim.value=pointTwo(compAmout);
    fm.prpLdangerRiskSumClaim.value=pointTwo(compAmout);
-->
</script>
--%>