<%--

****************************************************************************

* DESC       ���������ⰸ�սᱨ�����嵥��ӡ��ʼ��

* AUTHOR     ��wangwei

* CREATEDATE ��2005-5-21

* MODIFYLIST ��   Name       Date            Reason/Contents

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

    String strStartDate    = ""; //��������

    String strEndCaseDate  = ""; //�᰸����

    

    ClaimDto claimDto = (ClaimDto) request.getAttribute("claimDto");

    PrpLclaimDto prpLclaimDto = claimDto.getPrpLclaimDto(); 

    

    if (prpLclaimDto.getStartDate().toString() == null || prpLclaimDto.getStartDate().toString().trim().equals("")) {

        strStartDate = "";

    } else {

            strStartDate = prpLclaimDto.getStartDate().getYear() + "��" + prpLclaimDto.getStartDate().getMonth()

                         + "��" + prpLclaimDto.getStartDate().getDay() + "��";

    }

    

    if (prpLclaimDto.getEndCaseDate() == null || prpLclaimDto.getEndCaseDate().toString().trim().equals("")) {

        strEndCaseDate = "";

   } else {

        strEndCaseDate = prpLclaimDto.getEndCaseDate().getYear() + "��" + prpLclaimDto.getEndCaseDate().getMonth()

                        + "��" + prpLclaimDto.getEndCaseDate().getDay() + "��";

   }

%>



<script language="javascript">

  function loadForm()

  {


      tdPolicyNo.innerHTML      = '<%= prpLclaimDto.getPolicyNo() %>';

      tdSumAmount.innerHTML     = '<%= prpLclaimDto.getSumAmount() %>';

      tdDamageAddress.innerHTML = '<%= prpLclaimDto.getDamageAddress() %>';

      tdDamageName.innerHTML    = '<%= prpLclaimDto.getDamageName() %>';

      tdInsuredName.innerHTML   = '<%= prpLclaimDto.getInsuredName() %>';

  } 

</script>