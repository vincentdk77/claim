<%--
****************************************************************************
* DESC       ：冲减保额批文打印页面初始化
* AUTHOR     ：
* CREATEDATE ：2005-12-12
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
<%@page import="com.sinosoft.claim.dto.domain.PrpPheadDto" %>
<%@page import="com.sinosoft.utility.string.Str"%>

<%
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  EndorseDto endorseDto = (EndorseDto)request.getAttribute("endorseDto");
  UICodeAction uiCodeAction = new UICodeAction();
  
  String  RiskCode  = "" ;  //保单险种代码
  String  strRiskName = "" ;  //保单险种名称
  String  strPolicyNo = "";
  String  strInsuredName = "";
  String  strEndorseNo = "";
  String  strHandlerCode = "";
  String  strHandlerName = "";
  String strInputDate = "";    //缮制时间
  
  StringBuffer strBuffer = new StringBuffer();
  RiskCode = policyDto.getPrpCmainDto().getRiskCode();
  strRiskName = uiCodeAction.translateRiskCode(RiskCode,true);
  strPolicyNo = policyDto.getPrpCmainDto().getPolicyNo();
  strInsuredName = policyDto.getPrpCmainDto().getInsuredName();
  strEndorseNo = endorseDto.getPrpPmainDto().getEndorseNo();
  strHandlerCode = endorseDto.getPrpPheadDto().getOperatorCode();
  strHandlerName = uiCodeAction.translateUserCode(strHandlerCode,true);  
  
  strInputDate  = endorseDto.getPrpPheadDto().getInputDate().getYear()
                  + "年" + endorseDto.getPrpPheadDto().getInputDate().getMonth()
                  + "月" + endorseDto.getPrpPheadDto().getInputDate().getDate()
                  + "日";
  
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
		tdRiskName.innerHTML = '<%="保险类别："+strRiskName%>' ;
		tdPolicyNo.innerHTML = '<%="保险单号："+strPolicyNo%>' ;
		tdInsuredName.innerHTML = '<%="被保险人："+strInsuredName%>' ;
		tdEndorseNo.innerHTML = '<%="批单号："+strEndorseNo%>' ;
		tdHandlerName.innerHTML = '<%="缮制："+strHandlerName%>'
		tdInputDate.innerHTML = '<%="签发日期："+strInputDate%>'
	}
</script>