<%--         
******************************************************************************
* DESC       :  ���� 
* AUTHOR     �� 
* CREATEDATE :  2004-07-12
* MODIFYLIST ��  Name       Date            Reason/Contents
*          --------------------------------------------------------------------
*               
******************************************************************************
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.util.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>

<%
/*
����˼·��
===========================
[1]���ݱ�������Ӹ����������в�ѯ�������ĺ��룬�ṩ���û�ѡ��
[2]�����û���ѡ��֤����Դ��������Ӧ���ݵĲ鿴��
*/

	//�������
	String 	PolicyNo= "";
	String 	RiskCode= "";
	//��ѯ������
	DBPrpCmain dbPrpCmain 				    = new DBPrpCmain();
	//��ѯͷ
	BLPrpPhead blPrpPhead 				    = new BLPrpPhead();
	//������
	BLPrpLclaim blPrpLclaim 		      = new BLPrpLclaim();
	//��Ԥ��
	BLPrpLprepay blPrpLprepay         = new BLPrpLprepay();
	//��ʵ��
	BLPrpLcompensate blPrpLcompensate = new BLPrpLcompensate();
	//���ٱ�
	BLFcoRepolicy blFcoRepolicy       = new BLFcoRepolicy();  //�ٱ��ֱ�����
	
	//��ʼ����ѯ����
	String strCondition               = "";
	int     i                         = 0;
	String strBizNo                   = "";
	//���ձ�����
	PolicyNo = request.getParameter("PolicyNo"); 
	strCondition = "PolicyNo='" + PolicyNo + "'";
	
	dbPrpCmain.getInfo(PolicyNo);
	RiskCode = dbPrpCmain.getRiskCode();
	blPrpPhead.query(strCondition);
	blPrpLclaim.query(strCondition);
	blPrpLprepay.query(strCondition);
	blPrpLcompensate.query(strCondition);
	blFcoRepolicy.query(strCondition);    //��ѯ�ٱ��ֱ�����
%>

<html>
	<head>
	  <title>��ʾ����ҳ��</title>
	  <script language="javascript">
	   
	  //��ʾͶ����
	  function showProposal(strProposalNo)
	  {
	     window.location = "/claim/<%=RiskCode%>/tbcbpg/UIPrPoEn<%=RiskCode%>Show.jsp?"
	                     + "<%=SysConst.getProperty("BIZTYPE")%>=<%=SysConst.getProperty("BIZTYPE_PROPOSAL")%>"
	                     + "&BizNo=" + strProposalNo
	                     + "&<%=SysConst.getProperty("SHOWTYPE")%>=<%=SysConst.getProperty("SHOWTYPE_SHOW")%>";  
	  }
	  //��ʾ����
	  function showPolicy(strPolicyNo)
	  {
	     window.location = "/claim/<%=RiskCode%>/tbcbpg/UIPrPoEn<%=RiskCode%>Show.jsp?"
	                     + "<%=SysConst.getProperty("BIZTYPE")%>=<%=SysConst.getProperty("BIZTYPE_POLICY")%>"
	                     + "&BizNo=" + strPolicyNo
	                     + "&<%=SysConst.getProperty("SHOWTYPE")%>=<%=SysConst.getProperty("SHOWTYPE_SHOW")%>";
	
	  }
	  //��ʾ����
	  function showEndorse(strEndorseNo)
	  {
	     window.location = "/claim/<%=RiskCode%>/tbcbpg/UIPrPoEn<%=RiskCode%>Show.jsp?"
	                     + "<%=SysConst.getProperty("BIZTYPE")%>=<%=SysConst.getProperty("BIZTYPE_ENDORSE")%>"
	                     + "&BizNo=" + strEndorseNo
	                     + "&<%=SysConst.getProperty("SHOWTYPE")%>=<%=SysConst.getProperty("SHOWTYPE_SHOW")%>";    
	  }
	  //��ʾ�շѵǼ�
	  function showJpayRec()
	  {
	  
	  }
	  //��ʾ����
	  function showJrefRec()
	  {
	  
	  }
	  //��ʾ����
	  function showClaim(strClaimNo)
	  {
	   <%
	   UICodeAction uiCodeAction = new UICodeAction();
		String riskInnerCode = uiCodeAction.translateRiskCodetoInnerCode(RiskCode);
	   if(("DAE").equals(riskInnerCode))
     	{
	       RiskCode =BusinessRuleUtil.getOuterCode(request,"RISKCODE_DAA");
	    }
	   %>
	    window.location = "/claim/<%=RiskCode%>/lp/claim/UIL<%=RiskCode%>ClaimShow.jsp?"
	    								+ "ClaimNo=" + strClaimNo;
	  }
	  //��ʾԤ�������
	  function showPrepay(strPreCompensateNo)
	  {
	    <%
	    String riskInnerCode1 = uiCodeAction.translateRiskCodetoInnerCode(RiskCode);
	   if(("DAE").equals(riskInnerCode1))
     	{
	       RiskCode =BusinessRuleUtil.getOuterCode(request,"RISKCODE_DAA");
	    }
	   %>
	    window.location = "/claim/<%=RiskCode%>/lp/prepay/UIL<%=RiskCode%>PrepayShow.jsp?"
		        					+ "PreCompensateNo=" + strPreCompensateNo;
	  }
	  //��ʾ������
	  function showCompensate(strCompensateNo)
	  {
	   <%
	   String riskInnerCode2 = uiCodeAction.translateRiskCodetoInnerCode(RiskCode);
	   if(("DAE").equals(riskInnerCode2))
     	{
	       RiskCode =BusinessRuleUtil.getOuterCode(request,"RISKCODE_DAA");
	    }
	   %>
	    window.location = "/claim/<%=RiskCode%>/lp/compensate/UIL<%=RiskCode%>CompensateShow.jsp?"
	    								+ "CompensateNo=" + strCompensateNo; 
	  }
	  //��ʾ�ٱ��ֱ�ժҪ
	  //modify by weishixin add start 20030904
	  //ԭ�򣺼����ٱ��ֱ���Ϣ��ʾ
	  function showFcoAbstract(strRePolicyNo)
	  {
	    window.location = "/claim/common/pub/UILFcoAbstractShow.jsp?"
	    								+ "RePolicyNo=" + strRePolicyNo; 
	  }
	  //modify by weishixin add end  20030904
	  </script>
	</head>
	
	<%-- ����loadForm ��ʼ��ҳ�� --%>
	<body class="interface" background="/claim/common/images/bgCommon.gif">
	  <table class="common" align="center" cellspacing="3" cellpadding="5">
	    <tr>
	      <td class="formtitle" colspan="2">������Ϣ</td>
	    </tr>
	    <tr class="listodd">
	      <td width="10%">Ͷ����</a></td>
	      <td width="90%" align="left"><a href="javascript:showProposal('<%=dbPrpCmain.getProposalNo()%>')"><%=dbPrpCmain.getProposalNo()%></a></td>
	    </tr>
	    <tr class="listodd">
	      <td width="10%">����</a></td>
	      <td width="90%" align="left"><a href="javascript:showPolicy('<%=PolicyNo%>')" ><%=PolicyNo%></a></td>
	    </tr>
	    <tr class="listodd">
	      <td width="10%">����</td>
	      <td width="90%" align="left">
<%
				for (i = 0 ; i < blPrpPhead.getSize(); i++)
				{
					strBizNo = blPrpPhead.getArr(i).getEndorseNo();
%>
      		<a href="javascript:showEndorse('<%=strBizNo%>')" ><%=strBizNo%></a>
<%
				}
%>
	      </td>
	    </tr>    
	    <!--<tr class="listodd">
	      <td><a href="javascript:showJpayRec()" >�� ��</a></td>
	      <td><a href="javascript:showJrefRec()" >�� ��</a></td>
	    </tr>-->    
	    <tr class="listodd">
	    	<td width="10%">����</td>
	    	<td width="90%" align="left">
<%
				for (i = 0 ; i < blPrpLclaim.getSize(); i++)
				{
					strBizNo = blPrpLclaim.getArr(i).getClaimNo();
%>
      		<a href="javascript:showClaim('<%=strBizNo%>')" ><%=strBizNo%></a>
<%
				}
%>  		
				</td>
	    </tr>
	    <tr class="listodd">
	    	<td width="10%">Ԥ��</td>
	      <td width="90%" align="left">
<%
				for (i = 0 ; i < blPrpLprepay.getSize(); i++)
				{
					strBizNo = blPrpLprepay.getArr(i).getPreCompensateNo();
%>
      		<a href="javascript:showPrepay('<%=strBizNo%>')" ><%=strBizNo%></a>
<%
				}
%>  	      
	      </td>
	    </tr>    
	    <tr class="listodd">
	    	<td width="10%">ʵ��</td>
	      <td width="90%" align="left">
<%
				for (i = 0 ; i < blPrpLcompensate.getSize(); i++)
				{
					strBizNo = blPrpLcompensate.getArr(i).getCompensateNo();
%>
      		<a href="javascript:showCompensate('<%=strBizNo%>')" ><%=strBizNo%></a>
<%
				}
%>  	      
	      </td>
	    </tr>
	    <tr class="listodd">
	    	<td width="10%">�ٱ�</td>
	      <td width="90%" align="left">
<%
      //modify by weishixin add start 20030904
	  //ԭ�򣺼����ٱ��ֱ���Ϣ��ʾ
				for (i = 0 ; i < blFcoRepolicy.getSize(); i++)
				{
					strBizNo = blFcoRepolicy.getArr(i).getRepolicyNo();
%>
      		<a href="javascript:showFcoAbstract('<%=strBizNo%>')" ><%=strBizNo%></a>
<%
		//modify by weishixin add end 20030904
				}
%>  	      
	      </td>
	    </tr>
	  </table>
	</body>
</html>  