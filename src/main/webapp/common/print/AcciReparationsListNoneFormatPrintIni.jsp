<%--

***********************************************************

*DESC       : �⽡������������ӡ��ʼ��ҳ��

*AUTHOR     : wangwei

*CREATEDATE : 2005-08-18

*MODIFYLIST :    ID          DATE            Reason/contents

*            -----------------------------------------------

************************************************************

--%>



<%@page import="java.util.*,com.sinosoft.claim.dto.custom.CompensateDto" %>

<%@page import="com.sinosoft.claim.dto.domain.PrpLctextDto" %>

<%@page import=" com.sinosoft.claim.ui.control.action.UICodeAction" %>
<%@page import="java.util.*" %>


<%

    String strContext     = ""; //����������Ϣ

    String strHandlerCode = ""; //�����˴���

    String strHandlerName = ""; //������

    

    CompensateDto compensateDto = (CompensateDto) request.getAttribute("compensateDto"); 

    ArrayList prpLctextDtoList = (ArrayList) compensateDto.getPrpLctextDtoDtoList();

    PrpLctextDto prpLctextDto = null;

    for (int i = 0; i < prpLctextDtoList.size(); i++) {

        prpLctextDto = (PrpLctextDto) prpLctextDtoList.get(i);

        strContext = strContext + prpLctextDto.getContext();

    }

    

    strHandlerCode = compensateDto.getPrpLcompensateDto().getHandlerCode();

    UICodeAction uiCodeAction = new UICodeAction();

    strHandlerName = uiCodeAction.translateUserCode(strHandlerCode, true);

    

%>



<script language="javascript">

    function loadForm() {

        tdCompensateNo.innerHTML = '�������:' + '<%= compensateDto.getPrpLcompensateDto().getCompensateNo() %>';

        tdClaimNo.innerHTML      = '������:' + '<%= compensateDto.getPrpLcompensateDto().getClaimNo() %>';

    }

</script>