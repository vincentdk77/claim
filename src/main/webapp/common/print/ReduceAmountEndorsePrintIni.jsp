<%--
****************************************************************************
* DESC       ������������Ĵ�ӡҳ���ʼ��
* AUTHOR     ��
* CREATEDATE ��2005-12-12
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
<%@page import="com.sinosoft.claim.dto.domain.PrpPheadDto" %>
<%@page import="com.sinosoft.utility.string.Str"%>

<%
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  EndorseDto endorseDto = (EndorseDto)request.getAttribute("endorseDto");
  UICodeAction uiCodeAction = new UICodeAction();
  
  String  RiskCode  = "" ;  //�������ִ���
  String  strRiskName = "" ;  //������������
  String  strPolicyNo = "";
  String  strInsuredName = "";
  String  strEndorseNo = "";
  String  strHandlerCode = "";
  String  strHandlerName = "";
  String strInputDate = "";    //����ʱ��
  
  StringBuffer strBuffer = new StringBuffer();
  RiskCode = policyDto.getPrpCmainDto().getRiskCode();
  strRiskName = uiCodeAction.translateRiskCode(RiskCode,true);
  strPolicyNo = policyDto.getPrpCmainDto().getPolicyNo();
  strInsuredName = policyDto.getPrpCmainDto().getInsuredName();
  strEndorseNo = endorseDto.getPrpPmainDto().getEndorseNo();
  strHandlerCode = endorseDto.getPrpPheadDto().getOperatorCode();
  strHandlerName = uiCodeAction.translateUserCode(strHandlerCode,true);  
  
  strInputDate  = endorseDto.getPrpPheadDto().getInputDate().getYear()
                  + "��" + endorseDto.getPrpPheadDto().getInputDate().getMonth()
                  + "��" + endorseDto.getPrpPheadDto().getInputDate().getDate()
                  + "��";
  
  String  StrPtext = "";
  int     i = 0;
  for(i=0;i<endorseDto.getPrpPtextDtoList().size();i++)
  {
    PrpPtextDto prpPtextDto = (PrpPtextDto)endorseDto.getPrpPtextDtoList().get(i);
    if(i==0)
    {
      StrPtext = "&nbsp;&nbsp;&nbsp;&nbsp;"+prpPtextDto.getEndorseText();
    }
    else
    {
      StrPtext = prpPtextDto.getEndorseText();
    }
    StrPtext = Str.replace(StrPtext,"\r\n","<br>&nbsp;&nbsp;&nbsp;&nbsp;");
    StrPtext = Str.replace(StrPtext," ","&nbsp;");
    strBuffer.append(StrPtext);
    
  }
  
%>

<script language="javascript">
	function loadForm()
	{
		tdRiskName.innerHTML = '<%="�������"+strRiskName%>' ;
		tdPolicyNo.innerHTML = '<%="���յ��ţ�"+strPolicyNo%>' ;
		tdInsuredName.innerHTML = '<%="�������ˣ�"+strInsuredName%>' ;
		tdEndorseNo.innerHTML = '<%="�����ţ�"+strEndorseNo%>' ;
		tdHandlerName.innerHTML = '<%="���ƣ�"+strHandlerName%>'
		tdInputDate.innerHTML = '<%="ǩ�����ڣ�"+strInputDate%>'
	}
</script>