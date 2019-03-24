<%--
****************************************************************************
* DESC       �������������ս᰸�������ӡҳ��(��ҳ)
* AUTHOR     ��zhaozhuo
* CREATEDATE ��2005-04-13
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 

<%
  //������������
  
  
  String strInsuredName       ="";
  String strDamageStartDate   = "";   //����ʱ��
  String strLicenseNo         = "";   //�����еĺ��ƺ���
  String strClaimNo           = "";   //������
   String strContext           = "";  //������������
  String strTextType           = "";
  String strComName     = "";  //�б���˾����
  String strPolicyNo    = "";  //������
  String strRiskCode    = "";
 
  int intInsuredCount     = 0;   //InsuredDto����ļ�¼��
  int intThirdPartyCount  = 0;   //ThirdPartyDto����ļ�¼��
  int intDriverCount      = 0;   //DriverDto����ļ�¼��
  int intCtextCount       = 0;   //CtextDto����ļ�¼��
  int intCtextCountTmp    = 0;   //textarea����
  int intCplanCount       = 0;   
  int index=0;
  int intLossCount        = 0;
  int intCmainCount       = 0;
  
  double douPlanFee     = 0d;
  double douDelinquentFee = 0d;

  //�����岿��
    PrpCinsuredDto     prpInsuredDto      = null;   //������InsuredDto����                                           
    PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
    PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto����
    PrpLdriverDto      prpLdriverDto      = null;   //DriverDto����
    PrpLctextDto       prpLctextDto       = null; 
    PrpLregistDto      prpLregistDto      = null;
    PrpLcheckDto       prpLcheckDto       = null;
    PrpCplanDto        prpCplanDto        = null;
    PrpLlossDto        prpLlossDto        = null; 
    PrpLpersonLossDto  prpLpersonLossDto  = null;
    PrpLchargeDto      prpLchargeDto      = null;
    PrpCmainDto        prpCmainDto        = null;
    

 //�õ�ClaimDto,RegistDto,PolicyDto,CompensateDto����
    PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
    ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
    CompensateDto compensateDto = (CompensateDto)request.getAttribute("compensateDto"); 
    RegistDto registDto = (RegistDto)request.getAttribute("registDto"); 
    CheckDto  checkDto  = (CheckDto)request.getAttribute("checkDto");  
    PrpLCMainDto prpLCMainDto = (PrpLCMainDto)request.getAttribute("prpLCMainDto");
    
    UICodeAction uiCodeAction = new UICodeAction();

 //�õ�prpLclaimDto����
  prpLclaimDto   = claimDto.getPrpLclaimDto();  
  prpLregistDto =  registDto.getPrpLregistDto();
  prpLcheckDto =   checkDto.getPrpLcheckDto();
  strClaimNo = prpLclaimDto.getClaimNo(); 
  strComName = prpLclaimDto.getComName();
  strPolicyNo = prpLregistDto.getPolicyNo();
    
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    //*****���������ֱ�PrpLctext*****
    for(index=0;index<compensateDto.getPrpLctextDtoDtoList().size();index++)
    {
      prpLctextDto = (PrpLctextDto)compensateDto.getPrpLctextDtoDtoList().get(index);
      strTextType = StringConvert.encode(prpLctextDto.getTextType());
      if ( strTextType.charAt(0)=='1' )
      {      
        strContext = strContext + StringConvert.encode(prpLctextDto.getContext()) ;
      }
    }    
  }

    for(index=0;index<strContext.length();index++)
    {
      if(strContext.substring(index,index+1).equals("\\"))
      {
        if(!(strContext.substring(index).length()<4))
        {
          if(strContext.substring(index,index+4).equals("\\r\\n"))
          {
             intCtextCountTmp += 1;    
          }
        }
      }
    } 
    int x = 0;
    int y = 0;
    if(!(strContext.length()<4))    //���strContext.length()>=4���ж�strContext��β�����֣����ǻس�����
    {
      x = strContext.length()-4;
      y = strContext.length();
      if(!strContext.substring(x,y).equals("\\r\\n"))
      {
         intCtextCountTmp += 1;   
      }
    }
    else    //���strContext����1�У�intCtextCountTmp = 1; 
      intCtextCountTmp = 1;    
    
    while(strContext.indexOf("\\r\\n")!=-1)
       strContext=strContext.substring(0,strContext.indexOf("\\r\\n"))+"<br>"+strContext.substring(strContext.indexOf("\\r\\n")+"\\r\\n".length());
       
        //�б���˾
    String strCode = "";
    String strName = "";
    strCode = StringConvert.encode(prpLclaimDto.getComCode());
    strName = uiCodeAction.translateComCode(strCode,true); 
    String strCaseNo = StringConvert.encode(prpLclaimDto.getCaseNo());
    strInsuredName = StringConvert.encode(prpLclaimDto.getInsuredName());
    if(intCtextCountTmp < 16)
  {
%>

    <jsp:include page="/common/pub/UIErrorPage.jsp">
      <jsp:param name="Picture" value="F" />
      <jsp:param name="Content" value="�᰸�������Ѿ���ȫ�����������ӡ��ҳ!" />
    </jsp:include>


<%  
  return;
  }  
%>
<html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns="http://www.w3.org/TR/REC-html40">

<link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">
<body bgcolor="#FFFFFF">
    <form name="fm">
          <p height="40" align=top style="font-family:����; font-size:14pt;">
          <B> �����������ս᰸�����鸽ҳ </b></p>
      <br>
      <div align="left">
      <table border="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="92%" id="AutoNumber1">
        <tr>
          <td  width="33%">�б���˾��<%=strName%></td>
          <td  width="33%"></td>
          <td  width="33%">�ⰸ��ţ�<%=strClaimNo%></td>
        </tr>
        <tr>
          <td  width="33%">�������ˣ�<%=strInsuredName%></td>
          <td  width="33%">�����ţ�<%=strPolicyNo%></td>
          <td  width="33%">�鵵��ţ�<%=strCaseNo%></td>
        </tr>
      </table>
      </div>

         <hr>
         
      <font text-align:center">��������һ�ֳ�  �ڶ��ֳ������𣬱����¹ʺ˶���ʧ���£���������������</font><br>
         <table border="0" cellspacing="0" style="border-collapse: collapse" width="92%">
           <tr height="210" valign=top>
             <input type="hidden" name="CtextCountTmp" value="<%=intCtextCountTmp%>">
             <td><%=strContext%></td>
           </tr>
         </table>
         
      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />
  </form>
  </body>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
    </b>
</html>