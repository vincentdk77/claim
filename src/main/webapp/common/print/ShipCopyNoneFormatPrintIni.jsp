<%--

****************************************************************************

* DESC       �����պ󳭵���ӡҳ��ʼ��

* AUTHOR     ��wangwei

* CREATEDATE ��2005-5-28

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

    String strPolicyNo = ""; //������

    String strRegistNo = ""; //������

    String strPolicyName = ""; //������������

    String strPolicyAddress = ""; //�������˵�ַ

    String strCoinsFlag     = ""; //��������־

    String strLossName   = "";

    String strSumAmount  = "";

    String strClaimSite  = "";

    String strDeductibleRate = "";

    String strStartDate = "";

    String strInputDate = "";

    String strOperateDate = "";

    String strEndDate   = "";



    RegistDto registDto = (RegistDto) request.getAttribute("registDto");

    PolicyDto policyDto = (PolicyDto) request.getAttribute("policyDto");

    EndorseDto endorseDto = (EndorseDto) request.getAttribute("endorseDto");

    if(registDto!=null && registDto.getPrpLregistDto()!=null){

        strPolicyNo = registDto.getPrpLregistDto().getPolicyNo();

        strRegistNo = registDto.getPrpLregistDto().getRegistNo();

        strLossName = registDto.getPrpLregistDto().getLossName();

    }

    if(policyDto!=null && policyDto.getPrpCmainDto()!=null){

        strPolicyName = policyDto.getPrpCmainDto().getArbitBoardName();

        strPolicyAddress = policyDto.getPrpCmainDto().getAppliAddress();

        strCoinsFlag = policyDto.getPrpCmainDto().getCoinsFlag().toString();

        strSumAmount =""+ policyDto.getPrpCmainDto().getSumAmount();

        

        strStartDate = policyDto.getPrpCmainDto().getStartDate().toString();

        strInputDate = policyDto.getPrpCmainDto().getInputDate().toString();

        strOperateDate = policyDto.getPrpCmainDto().getOperateDate().toString();

        strEndDate = "��"+policyDto.getPrpCmainDto().getStartDate()+"��"+policyDto.getPrpCmainDto().getEndDate();

    }

    



    if (strCoinsFlag.equals("0")) {         //�ǹ���

        strCoinsFlag = "�ǹ���";

    } else if (strCoinsFlag.equals("1")) {  //������

        strCoinsFlag = "������";

    } else if (strCoinsFlag.equals("2")) {  //����

        strCoinsFlag = "����";

    }

    

%>