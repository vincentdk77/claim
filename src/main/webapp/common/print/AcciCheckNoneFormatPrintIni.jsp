<%--

****************************************************************************

* DESC       �������ղ鿱�����嵥��ӡ��ʼ��

* AUTHOR     ��dongchengliang

* CREATEDATE ��2005-6-16

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

    String policyNo = ""; //������

    String registNo = ""; //������

    String insuredName = ""; //������

    String claimType = ""; //

    String checker1 = ""; //

    String damageTypeName = "";

    String checkType = "";

    String remark = ""; //

    DateTime checkEndDate = new DateTime();

    DateTime checkDate = new DateTime();

    DateTime damageStartDate =new DateTime();

    String damageStartYear = "";

    String damageStartMonth = "";

    String damageStartDay = "";

    String damageStartHour = "";

    String damageStartMinute = "";

    String operateStartYear = "";

    String operateStartMonth = "";

    String operateStartDay = "";

    String operateStartHour = "";

    String operateStartMinutue = "";

    String strContext = "";   //��������

    

    PrpLacciCheckDto prpLacciCheckDto = (PrpLacciCheckDto) request.getAttribute("prpLacciCheckDto");

    PrpCmainDto prpCmainDto = (PrpCmainDto) request.getAttribute("prpCmainDto");

    PrpLregistDto prpLregistDto = (PrpLregistDto) request.getAttribute("prpLregistDto");

    java.util.ArrayList prpLacciCheckTextDtoList = (java.util.ArrayList) request.getAttribute("prpLacciCheckTextDtoList");

    

    if(prpCmainDto!= null){

      policyNo = prpCmainDto.getPolicyNo();

      insuredName = prpCmainDto.getInsuredName();

    }



   if(prpLregistDto!= null){

      checkEndDate = prpLacciCheckDto.getCheckEndDate();//�����������

      checkDate    = prpLacciCheckDto.getCheckDate();   //���鿪ʼ����

      damageStartDate = prpLregistDto.getDamageStartDate();  //����ʱ��

      

      if(damageStartDate != null){

        damageStartYear = String.valueOf(damageStartDate.getYear());

        damageStartMonth = String.valueOf(damageStartDate.getMonth());

        damageStartDay = String.valueOf(damageStartDate.getDay());

      }

      

      if(checkDate != null){

        operateStartYear = String.valueOf(checkDate.getYear());

        operateStartMonth = String.valueOf(checkDate.getMonth());

        operateStartDay = String.valueOf(checkDate.getDay());

      }

    }

   

   //��õ������� 2005-08-16

   for (int i = 0; i < prpLacciCheckTextDtoList.size(); i++) {

       PrpLacciCheckTextDto prpLacciCheckTextDto = (PrpLacciCheckTextDto) prpLacciCheckTextDtoList.get(i);

       strContext = strContext + prpLacciCheckTextDto.getContext();

   }

   String checkHour = prpLacciCheckDto.getCheckHour().substring(0,prpLacciCheckDto.getCheckHour().indexOf(":"));
   String checkMin = prpLacciCheckDto.getCheckHour().substring(prpLacciCheckDto.getCheckHour().indexOf(":")+1,prpLacciCheckDto.getCheckHour().length());
   
   String checkEndHour = prpLacciCheckDto.getCheckEndHour().substring(0,prpLacciCheckDto.getCheckEndHour().indexOf(":"));
   String checkEndMin = prpLacciCheckDto.getCheckEndHour().substring(prpLacciCheckDto.getCheckEndHour().indexOf(":")+1,prpLacciCheckDto.getCheckEndHour().length());

   String strDate = "����ʱ�䣺" + checkDate.getYear() + "��" + checkDate.getMonth() + "��" +  checkDate.getDay() + "��" 

                                        + checkHour + "ʱ" + checkMin + "��"

                                        + "��" + operateStartYear + "��" +  operateStartMonth + "��" +  operateStartDay + "��"

                                        +  checkEndHour + "ʱ" + checkEndMin + "��";

%>



<script language="javascript">

    function loadForm() {

        tdPolicyNo.innerHTML          = '��������:' + '<%= policyNo%>';

        tdRegistNo.innerHTML          = '������:' + '<%= prpLacciCheckDto.getRegistNo() %>';

        tdInsuredName.innerHTML       = '��������������' + '<%= insuredName %>';

        tdDamageTypeName.innerHTML    = '�¹����ͣ�' + '<%= prpLacciCheckDto.getDamageTypeName() %>';

        tdCheckNature.innerHTML       = '���鷽ʽ:' + '<%= prpLacciCheckDto.getCheckNature().equals("0") ? "ֱ�ӵ���" : "��ӵ���"%>';

        tdCheckerCode.innerHTML       = '����Ա:' + '<%= prpLacciCheckDto.getCheckerCode() %>';

        tdDamageStartDate.innerHTML   = '�¹����ڣ�&nbsp;<%= damageStartYear %>��&nbsp;<%= damageStartMonth %>��&nbsp;<%= damageStartDay %>��';

    }

</script>