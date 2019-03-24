<%--
****************************************************************************
* DESC       ������ʱ������ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-18
* MODIFYLIST ��Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>

<%@page errorPage="/UIErrorPage"%>

<%-- ����bean�ಿ�� --%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.ui.control.viewHelper.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%>
<%@page import="com.sinosoft.claim.util.*"%>

<%
  //������������
  String strPolicyNo        = "";   //������  
  String strDamageDate      = request.getParameter("EndDate"); //��������  
  String strDamageHour      = request.getParameter("EndHour"); //��ֹʱ��
  String strStartDate       = "";   //������
  String strStartHour       = "";   //��Сʱ
  String strEndDate         = "";   //�ձ�����
  String strEndHour         = "";   //�ձ�Сʱ
  String strRiskCode        = "";   //����
  String strMessage         = "";   //��Ϣ
  String strWhere           = "";   //sql���
  String strEndorseNo       = "";   //������
  String strRiskPage        = "";   //��ӡҳ��
  
  int index = 0;
  
  //�õ������������Ϣ
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");   
  
  PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
  
  strPolicyNo = prpCmainDto.getPolicyNo();

  //��ת¼��ҳ��
  strRiskCode   = prpCmainDto.getRiskCode(); //���ִ���

  //���������Ƿ��ڱ�������
  //dbPrpDrisk.getInfo(strRiskCode);
  strStartDate  = prpCmainDto.getStartDate().toString();
  strStartHour  = prpCmainDto.getStartHour() + "";
  strEndDate    = prpCmainDto.getEndDate().toString();
  strEndHour    = prpCmainDto.getEndHour() + "";
  
  EndorseViewHelper endorseViewHelper = new EndorseViewHelper();   
  PolicyDto policyDtoOld = endorseViewHelper.findForEndorBefore(prpCmainDto.getPolicyNo(),strDamageDate);        
 
  request.setAttribute("policyDto",policyDtoOld);
  
  //���ݱ������ݷַ�����ӡҳ��
  UICodeAction uiCodeAction = new UICodeAction();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(strRiskCode);
     if(("D").equals(strRiskType)){
       strRiskPage = "PolicyDAASingleCarNoneFormatPrint.jsp"  ; 
     } else {
        strRiskPage = "/" + strRiskCode + "/cb/UIPolicy" + strRiskCode + "NoneFormatPrint.jsp"  ; 
     }  
      
 System.out.println("=============="+strRiskPage); 

%>
  <jsp:forward page='<%=strRiskPage%>'>
    <jsp:param name='EDITTYPE' value='COPY'/>
    <jsp:param name='PolciyNo' value='<%=strPolicyNo%>' />
    <jsp:param name='PrintType' value='L' />
  </jsp:forward>

