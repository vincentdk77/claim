<%--

****************************************************************************

* DESC       ���⽡�վ���֪ͨ�飨��ʼ��ҳ�棩

* AUTHOR     ��luqin

* CREATEDATE ��2005-06-19

* MODIFYLIST ��   Name       Date            Reason/Contents

*          ------------------------------------------------------

****************************************************************************

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



<%

  String strIdentifyNumber  = "";

  String strDate = "";

  String strDamageName = "";

  

  DateTime dateTime  = new DateTime();



  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");

  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");

  PrpLclaimDto prpLclaimDto = claimDto.getPrpLclaimDto();

  

  PrpCinsuredDto prpCinsuredDto = null;

  

  String strInsuredName = prpLclaimDto.getInsuredName();

  if(policyDto.getPrpCinsuredDtoList()!=null){

    prpCinsuredDto = (PrpCinsuredDto)policyDto.getPrpCinsuredDtoList().get(0);

    strIdentifyNumber = prpCinsuredDto.getIdentifyNumber();

  }

  strDate = dateTime.current().getYear()+"��"+dateTime.current().getMonth()+"��"+dateTime.current().getDate()+"��";

  strDamageName = prpLclaimDto.getDamageName();

%>



<script language="javascript">

function loadForm(){

  tdClaimNo.innerHTML = '�����ţ�'+'<%=prpLclaimDto.getClaimNo()%>';

  tdHandlerName.innerHTML = '�����ˣ�'+'<%=prpLclaimDto.getHandlerName()%>';

}

</script>