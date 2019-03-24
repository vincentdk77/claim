<%--
****************************************************************************
* DESC       ���Ʋ������������ӡҳ���ʼ��
* AUTHOR     ��wangwei
* CREATEDATE ��2005-5-21
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@page errorPage="UIErrorPage"%>

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
  //������������
  String strCompensateNo      = request.getParameter("CompensateNo"); //���������
  if(strCompensateNo==null) strCompensateNo = "";
  String strClaimNo           = "";   //������
  String strPolicyNo          = "";   //������
  double dblSumAmount1       = 0;    //���ս��      
  String strKindCode          = "";   //�ձ����
  String strCause             = "";   //����ԭ��
  String strAddress           = "";   //���յص�
  String strDamageStartDate   = "";   //����ʱ��
  String strCountExp          = "";   //�����㹫ʽ
  String strDealerCode        = "";
  String strContext1          = "";
  String strClaimText         = "";
  
  //���˶�
  double dblClaim            = 0;    //���˶�
  double dblAgen             = 0;    //�����
  double dblCheck            = 0;    //�����
  double dblExamine          = 0;    //�鿱��
  double dblRest             = 0;    //��������
  double dblSum              = 0;    //���ϼ�
  double dblEndMoney         = 0;    //�����Ѹ������
  double dblTrueMoney        = 0;    //�᰸ʱʵ�������

  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
  
  //�����岿��
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto����
  PrpLregistTextDto  prpLregistTextDto  = null; 
  PrpLregistDto      prpLregistDto      = null;
  
  int intCompensateCount = 0;   //CompensateDto����ļ�¼��
  int intItemCarCount    = 0;   //ItemcarDto����ļ�¼��
  int intItemKindCount   = 0;   //ItemKindDto����ļ�¼��
  int intThirdPartyCount = 0;   //ThirdPartyDto����ļ�¼��
  int intChargeCount     = 0;   //ChargeDto����ļ�¼��
  int intCtextCount      = 0;   //CtextDto����ļ�¼��
  int intCtextCountTmp   = 0;   //textarea����
    
  int index = 0;
  
  //�õ�ClaimDto����
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  UICodeAction uiCodeAction = new UICodeAction();
  //�õ�prpLclaimDto����
  prpLclaimDto     = claimDto.getPrpLclaimDto();

%>


<script language="javascript">
  function loadForm()
  {
    
    //*****���������PrpLcompensate*****
    tdCompensateNo.innerHTML  = '<%=strCompensateNo%>';

    //*****������Ϣ��PrpLclaim*****
    tdPolicyNo.innerHTML     = '<%=strPolicyNo%>';
    tdInsuredName.innerHTML  = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
    tdRiskCode.innerHTML  ='<%=prpLclaimDto.getRiskCode()%>';
    tdLossName.innerHTML    = '<%=prpLclaimDto.getLossName()%>';
    tdSumAmount.innerHTML = '<%= new DecimalFormat("#,##0.00").format(prpLclaimDto.getSumAmount())%>';
<%    
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                         + " �� " +prpLclaimDto.getDamageStartDate().getMonth()
                         + " �� " + prpLclaimDto.getDamageStartDate().getDate()
                         + " ��";
%>                    
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>';
    tdDamageAddress.innerHTML = '<%= prpLclaimDto.getDamageAddress()%>';
    tdCancelReason.innerHTML = '<%=prpLclaimDto.getCancelReason()%>';
<%
    if(registDto.getPrpLregistTextDtoList()!=null){
         int intSizeTemp = registDto.getPrpLregistTextDtoList().size();
         if (intSizeTemp>0)
         {  
           for(int i=0;i<intSizeTemp;i++)
           {    
               prpLregistTextDto = (PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(i); 
                
               if(!prpLregistTextDto.getContext().trim().equals(""))  
               {          
               strContext1 += StringConvert.encode(prpLregistTextDto.getContext())+"\\r\\n";      
               }   
            }  
            if(!strContext1.trim().equals(""))  
            {
            strClaimText += strContext1;
            
            }
         }
       }  System.out.println("strClaimText= "+strClaimText);
%>
    tdRegistText.innerHTML = '<%=strClaimText%>';
} 
</script>
  