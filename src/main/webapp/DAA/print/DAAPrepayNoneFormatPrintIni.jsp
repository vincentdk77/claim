<%--
****************************************************************************
* DESC       ��������������Ԥ������������ӡ��ʼ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16
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
  //������������
  String strPreCompensateNo   = request.getParameter("PreCompensateNo"); //Ԥ���
  String strClaimNo         = "";   //������
  String strInsuredDate     = "";   //�����ڼ�
  String strDamageStartDate = "";   //����ʱ��
  String strInsureCarFlag   = "";   //�Ƿ�Ϊ����������
  String strCSumPrePaid     = "";   //��дԤ����
  String strUserCode        = ((UserDto)request.getSession().getAttribute("user")).getUserCode(); 
  String strUserName        = "";
  String strInputDate       = "";
  String strMessage         = "";  

  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
  
  //�����岿��                                           
  PrpLregistDto      prpLregistDto      = null;   //RegistDto����
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto����
  
  int intPrepayCount      = 0;   //PrepayDto����ļ�¼��
  int intThirdPartyCount  = 0;   //ThirdPartyDto����ļ�¼��
    
  int index = 0;
  
  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto����
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  PrepayDto prepayDto = (PrepayDto)request.getAttribute("prepayDto"); 
    
  UICodeAction uiCodeAction = new UICodeAction();
  
  //�õ�prpLclaimDto����
  prpLclaimDto   = claimDto.getPrpLclaimDto();
  strClaimNo = prpLclaimDto.getClaimNo(); 
    
  //�õ�blPrpLthirdParty����ļ�¼��
  if(claimDto.getPrpLthirdPartyDtoList()!=null){
    intThirdPartyCount     = claimDto.getPrpLthirdPartyDtoList().size();
  }
  //�õ�prpLregistDto����
  prpLregistDto    = registDto.getPrpLregistDto();
  
  PrpLprepayDto prpLprepayDto = prepayDto.getPrpLprepayDto();
%>

<script language="javascript">
  function loadForm()
  {
    tdClaimNo.innerHTML = '������ţ�' + '<%=strClaimNo%>';
    
    //*****������Ϣ��PrpLregist*****
    tdEstimateLoss.innerHTML = '<%=new DecimalFormat("#,##0.00").format(prpLregistDto.getEstimateLoss())%>';    
    //*****������Ϣ��PrpLregist*****
    tdPolicyNo.innerHTML    = '<%=StringConvert.encode(prpLclaimDto.getPolicyNo())%>';
    tdInsuredName.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
    tdSumAmount.innerHTML   = '<%=new DecimalFormat("#,##0.00").format(prpLclaimDto.getSumAmount())%>';
<%    
    strInsuredDate = "�� " + prpLclaimDto.getStartDate().getYear()
                     + "��" + prpLclaimDto.getStartDate().getMonth()
                     + "��" + prpLclaimDto.getStartDate().getDate()
                     + "�� ��ʱ��"
                     + "<br>" + "<br>" 
                     + "�� " + prpLclaimDto.getEndDate().getYear()
                     + "��" + prpLclaimDto.getEndDate().getMonth()
                     + "��" + prpLclaimDto.getEndDate().getDate()
                     + "�� ��ʮ��ʱֹ";
%>                     
    tdInsuredDate.innerHTML = '<%=strInsuredDate%>';
<%
    //��������
    strCode = "";
    strName = "";
    strCode = StringConvert.encode(prpLclaimDto.getRiskCode());
    strName = uiCodeAction.translateRiskCode(strCode,isChinese);
%>
    tdRiskName.innerHTML = '<%=strName%>';
<%    
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                        + " �� " + prpLclaimDto.getDamageStartDate().getMonth()
                        + " �� " + prpLclaimDto.getDamageStartDate().getDate()
                        + " ��";
%>                    
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>';
    tdDamageAddress.innerHTML   = '<%=StringConvert.encode(prpLclaimDto.getDamageAddress())%>';
    
    //*****���⳵����ϢPrpLthirdParty*****
<%  
  if(claimDto.getPrpLthirdPartyDtoList()!=null){
    for(index=0;index<intThirdPartyCount;index++)
    {
      prpLthirdPartyDto = (PrpLthirdPartyDto)claimDto.getPrpLthirdPartyDtoList().get(index);
      strInsureCarFlag     = prpLthirdPartyDto.getInsureCarFlag();
      
      if( strInsureCarFlag.equals("1") ) 
      {
%>        
        tdLicenseNo.innerHTML = '<%=prpLthirdPartyDto.getLicenseNo()%>';
        tdBrandName.innerHTML = '<%=prpLthirdPartyDto.getBrandName()%>';
<%        
        //�������
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(prpLthirdPartyDto.getClauseType());
        strName = uiCodeAction.translateCodeCode("ClauseType",strCode,isChinese);
%>        
        tdClauseType.innerHTML= '<%=strName%>';
<%  
      }
    }
  }  
    
    //*****Ԥ��ǼǱ�PrpLprepay*****

      strCSumPrePaid = MoneyUtils.toChinese(prpLprepayDto.getSumPrePaid(),prpLprepayDto.getCurrency());

%>
    tdSumPrePaid.innerHTML = '&nbsp;Ԥ��������д����ң���' + '<%=strCSumPrePaid%>';
<%    
    //��� 
    strUserName = uiCodeAction.translateUserCode(strUserCode,isChinese);
    
    //�ʱ��
    strInputDate = DateTime.current().getYear() + "��"
                 + DateTime.current().getMonth() + "��" 
                 + DateTime.current().getDate() + "��";
%>
    tdUserName.innerHTML  ='��ˣ�'   + '<%=strUserName%>';
    tdInputDate.innerHTML ='�ʱ�䣺' + '<%=strInputDate%>';    
  }
</script>
