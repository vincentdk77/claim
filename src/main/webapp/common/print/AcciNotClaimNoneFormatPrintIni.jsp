<%--

****************************************************************************

* DESC       ���⽡�ղ�������֪ͨ���ӡ��ʼ��

* AUTHOR     ��dongchengliang

* CREATEDATE ��2005-8-17

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

   String strContext = "";

   RegistDto registDto = (RegistDto) request.getAttribute("registDto");

   java.util.ArrayList prpLltextDtoList = (java.util.ArrayList) registDto.getPrpLregistTextDtoList();

   

   PrpLregistTextDto prpLltextDto = null;

   if (prpLltextDtoList != null) {

       for (int i = 0; i < prpLltextDtoList.size(); i++) {

           prpLltextDto = (PrpLregistTextDto) prpLltextDtoList.get(i);

           if (prpLltextDto.getTextType().equals("2")) {  //����Ϊ2�Ĳ��ǲ���������Ϣ

               strContext = strContext + prpLltextDto.getContext();

           }

       }   

   }

%>



<script language="javascript">

    function loadForm() {

        tdRregistNo.innerHTML          = '������:' + '<%= registDto.getPrpLregistDto().getRegistNo() %>';

    }

</script>