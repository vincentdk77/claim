<%--
****************************************************************************
* DESC       ��������鱨���ʼ��
* AUTHOR     ��caopeng
* CREATEDATE ��2005-12-13
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
<%@page import="java.util.ArrayList"%>

<% 
  System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
    String policyNo           = ""; //������
    String strRegistNo        = ""; //������
    String strClaimNo         = "";  //������
    String insuredName        = ""; //
    String claimType          = ""; //
    String checker1           = "";
    String damageTypeName     = "";
    String checkType          = "";
    String strAcciName        = "";   //�¹�������
    
    
    int    intSize            = 0;    //ArrayList�Ĵ�С
    int    index              = 0; 

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
    
    //�����岿��
    ClaimDto           claimDto           = null;   //ClaimDto����
    ArrayList arrPrpLacciPersonDto        = null;

    PrpLacciCheckDto prpLacciCheckDto = (PrpLacciCheckDto) request.getAttribute("prpLacciCheckDto");

    PrpCmainDto prpCmainDto = (PrpCmainDto) request.getAttribute("prpCmainDto");

    PrpLregistDto prpLregistDto = (PrpLregistDto) request.getAttribute("prpLregistDto");

    ArrayList prpLacciCheckTextDtoList = (ArrayList) request.getAttribute("prpLacciCheckTextDtoList");
    UIClaimAction uiClaimAction = new UIClaimAction();
    
    
    strRegistNo = prpLacciCheckDto.getRegistNo();
    UICodeAction uiCodeAction = new UICodeAction();
    strClaimNo = uiCodeAction.translateBusinessCode(strRegistNo,true);
    
    System.out.println("@@@@@@@@@@@@@@@wrerwer@@@@@@@@@");
    //�õ�claimDto����
    if(strClaimNo!=null && !strClaimNo.trim().equals("")){
      claimDto =(ClaimDto)uiClaimAction.findByPrimaryKey(strClaimNo);
      if(claimDto != null){
        PrpLacciPersonDto prpLacciPersonDto = (PrpLacciPersonDto)claimDto.getPrpLacciPersonDto();
        if(prpLacciPersonDto != null){
          strAcciName = prpLacciPersonDto.getAcciName();
        }
      }
    }
     
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

   System.out.println("@@@@@@sdsdsdsa222@@@@@@@@@@@@@@@@@@");

   //��õ�������

   for (int i = 0; i < prpLacciCheckTextDtoList.size(); i++) {

       PrpLacciCheckTextDto prpLacciCheckTextDto = (PrpLacciCheckTextDto) prpLacciCheckTextDtoList.get(i);

       strContext = strContext + prpLacciCheckTextDto.getContext();

   }

     System.out.println("@@@@@@33333@@@@@@@@@@@@");


   String strDate = "����ʱ�䣺" + checkDate.getYear() + "��" + checkDate.getMonth() + "��" +  checkDate.getDay() + "��" ;

                                      //  + prpLacciCheckDto.getCheckHour().substring(0,2) + "ʱ" + prpLacciCheckDto.getCheckHour().substring(3,5) + "��" ;

                                      //  + "��" + operateStartYear + "��" +  operateStartMonth + "��" +  operateStartDay + "��"

                                       // +  prpLacciCheckDto.getCheckEndHour().substring(0, 2) + "ʱ" + prpLacciCheckDto.getCheckEndHour().substring(3,5) + "��";

   System.out.println("@@@@@@8888@555@@@@@@@@@@@");
  
%>



<script language="javascript">

    function loadForm() {
    
        spRegistNo.innerHTML          = '<%=strRegistNo%>';
        spClaimNo.innerHTML           = '<%=strClaimNo%>';
        spCheckYear.innerHTML           = '<%=checkEndDate.getYear()%>';
        spCheckMonth.innerHTML           = '<%=checkEndDate.getMonth()%>';
        spCheckDate.innerHTML           = '<%=checkEndDate.getDay()%>';
        spAcciName.innerHTML           = '<%=strAcciName%>';
        
    }

</script>