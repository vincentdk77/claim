<%--

****************************************************************************

* DESC       ���������ⰸ�սᱨ���顡

* AUTHOR     ��zhulei

* CREATEDATE ��2005-9-20

* MODIFYLIST ��   id       Date            Reason/Contents

*          ------------------------------------------------------

****************************************************************************/

--%>





<%-- ����bean�ಿ�� --%>

<%@page import="java.text.*"%>

<%@page import="com.sinosoft.claim.ui.control.action.*"%>

<%@page import="com.sinosoft.claim.dto.custom.*"%>

<%@page import="com.sinosoft.claim.dto.domain.*"%> 

<%@page import="com.sinosoft.claim.util.*"%> 

<%@page import="com.sinosoft.sysframework.common.util.*"%> 

<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 

<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 

<%@page import="com.sinosoft.function.insutil.bl.facade.BLPubRateFacade"%>

<%@page import="com.sinosoft.utiall.dbsvr.DBPrpDcode"%>

<%@page import="com.sinosoft.prpall.blsvr.cb.*"%>



<%

  //������������

  String strCompensateNo      = request.getParameter("CompensateNo"); //���������

  String strClaimNo           = "";   //������

  String strPolicyNo          = "";   //������

  

  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto���� zhulei leave����һ�����ã�������

  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");

  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");

  RegistDto registDto = (RegistDto)request.getAttribute("registDto");

  CheckDto checkDto = (CheckDto)request.getAttribute("checkDto"); 

  CompensateDto compensateDto = (CompensateDto)request.getAttribute("compensateDto"); 

  CertainLossDto certainLossDto = (CertainLossDto)request.getAttribute("certainLossDto");

  //�õ�������

  //strPolicyNo = policyDto.getPrpCmainDto().getPolicyNo();

  System.out.println(".............strPolicyNo="+strPolicyNo);

  

  BLPrpCmainCargo blPrpCmainCargo = new BLPrpCmainCargo();

  //blPrpCmainCargo.



%>