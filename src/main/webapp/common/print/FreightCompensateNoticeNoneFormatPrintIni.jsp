<%--

****************************************************************************

* DESC       ：货运险赔案终结报告书清单打印初始化

* AUTHOR     ：wangwei

* CREATEDATE ：2005-5-21

* MODIFYLIST ：   Name       Date            Reason/Contents

****************************************************************************

--%>



<%-- 引入bean类部分 --%>

<%@page import="java.text.*"%>

<%@page import="com.sinosoft.claim.ui.control.action.*"%>

<%@page import="com.sinosoft.claim.dto.custom.*"%>

<%@page import="com.sinosoft.claim.dto.domain.*"%> 

<%@page import="com.sinosoft.claim.util.*"%> 

<%@page import="com.sinosoft.sysframework.common.util.*"%> 

<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 

<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 



<%

    String strStartDate    = ""; //出险日期

    String strEndCaseDate  = ""; //结案日期

    

    ClaimDto claimDto = (ClaimDto) request.getAttribute("claimDto");

    PrpLclaimDto prpLclaimDto = claimDto.getPrpLclaimDto(); 

    

    if (prpLclaimDto.getStartDate().toString() == null || prpLclaimDto.getStartDate().toString().trim().equals("")) {

        strStartDate = "";

    } else {

            strStartDate = prpLclaimDto.getStartDate().getYear() + "年" + prpLclaimDto.getStartDate().getMonth()

                         + "月" + prpLclaimDto.getStartDate().getDay() + "日";

    }

    

    if (prpLclaimDto.getEndCaseDate() == null || prpLclaimDto.getEndCaseDate().toString().trim().equals("")) {

        strEndCaseDate = "";

   } else {

        strEndCaseDate = prpLclaimDto.getEndCaseDate().getYear() + "年" + prpLclaimDto.getEndCaseDate().getMonth()

                        + "月" + prpLclaimDto.getEndCaseDate().getDay() + "日";

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