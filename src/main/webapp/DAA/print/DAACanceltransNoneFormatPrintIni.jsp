<%--
****************************************************************************
* DESC       �������������վ��ⰸ���������ӡ��ʼ��
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
  String strClaimNo         = request.getParameter("ClaimNo"); //������
  String strPolicyNo        = "";   //������
  String strInsuredDate     = "";   //�����ڼ�
  String strDamageStartDate = "";   //����ʱ��
  String strInsureCarFlag   = "";   //�Ƿ�Ϊ����������
  double dblSumAmount1      = 0;    //���ս��    
  double dblSumAmount2      = 0;    //�����޶�    
  String strRiskCode        = "";   //���ִ���     
  String strKindCode        = "";   //�ձ����     
  String strCalculateFlag   = "";   //�Ƿ���뱣��
  String strUserCode        = ((UserDto)request.getSession().getAttribute("user")).getUserCode();
  String strUserName        = "";
  String strInputDate       = "";  
  String strMessage         = "";
  String strDealerCode      = "";
  String strContext         = "";
 
  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
  
  //�����岿��
                                              
  PrpCitemKindDto    prpItemKindDto     = null;   //������ItemKindDto����
  PrpLregistDto      prpLregistDto      = null;   //RegistDto����
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto����
  PrpLregistTextDto  prpLregistTextDto  = null;
  
  int intClaimCount      = 0;   //ClaimDto����ļ�¼��
  int intItemKindCount   = 0;   //ItemKindDto����ļ�¼��
  int intThirdPartyCount = 0;   //ThirdPartyDto����ļ�¼��
  int intTextCount       = 0;
    
  int index = 0;

  //�õ�ClaimDto,RegistDto,PolicyDto����
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  
  UICodeAction uiCodeAction = new UICodeAction();
  //�õ�blClaim����ͱ�����
;
  strPolicyNo = claimDto.getPrpLclaimDto().getPolicyNo();
  
  //�õ�blPrpCitemKind����ļ�¼��
  if(policyDto.getPrpCitemKindDtoList()!=null){
    intItemKindCount = policyDto.getPrpCitemKindDtoList().size();
  }

  //�õ�blPrpLthirdParty����ļ�¼��
  if(registDto.getPrpLthirdPartyDtoList()!=null){
    intThirdPartyCount  = registDto.getPrpLthirdPartyDtoList().size();
  }  
  
  //�õ�prpLclaimDto����
  prpLclaimDto     = claimDto.getPrpLclaimDto();
  

  //�õ�prpLregistDto����
  prpLregistDto    = registDto.getPrpLregistDto(); 
/*
  strDealerCode = prpLregistDto.getDealerCode();
  if(strDealerCode==null || strDealerCode.trim().equals(""))
  {
    throw new UserException(-98,-2013,"UILDAACanceltransNoneFormatPrintIni.jsp");
  }
*/  

%>

<script language="javascript">
  function loadForm()
  {
    tdClaimNo.innerHTML = '������ţ�' + '<%=strClaimNo%>';
    
    //*****������Ϣ��PrpLregist*****
    tdEstimateLoss.innerHTML = '<%=new DecimalFormat("#,##0.00").format(prpLregistDto.getEstimateLoss())%>' + ' Ԫ';
     
    //*****������Ϣ��PrpLregist*****
    tdPolicyNo.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getPolicyNo())%>';
    tdInsuredName.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
<%    
    strInsuredDate = "�� " + prpLclaimDto.getStartDate().getYear()
                     + "��" + prpLclaimDto.getStartDate().getMonth()
                     + "��" + prpLclaimDto.getStartDate().getDate()
                     + "�� ��ʱ��"
                     + "<br>" + "<br>" 
                     + "�� " + prpLclaimDto.getEndDate().getYear()
                     + "��" + prpLclaimDto.getEndDate().getMonth()
                     + "��" +prpLclaimDto.getEndDate().getDate()
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
    strDamageStartDate =prpLclaimDto.getDamageStartDate().getYear()
                        + " �� " + prpLclaimDto.getDamageStartDate().getMonth()
                        + " �� " + prpLclaimDto.getDamageStartDate().getDate()
                        + " ��";
%>                    
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>';
    tdDamageAddress.innerHTML   = '<%=StringConvert.encode(prpLclaimDto.getDamageAddress())%>';
    
    //*****���⳵����ϢPrpLthirdParty*****
<%
  if(registDto.getPrpLthirdPartyDtoList()!=null){ 
    for(index=0;index<intThirdPartyCount;index++)
    {
      prpLthirdPartyDto = (PrpLthirdPartyDto)registDto.getPrpLthirdPartyDtoList().get(index);
      strInsureCarFlag     = prpLthirdPartyDto.getInsureCarFlag();
      if( strInsureCarFlag.equals("1") ) 
      {
%>        
        tdLicenseNo.innerHTML = '<%=prpLthirdPartyDto.getLicenseNo()%>';
        tdBrandName.innerHTML = '<%=prpLthirdPartyDto.getBrandName()%>';
<%  
      }
    }
  }  

    
    //*****���������ϢPrpTitemKind*****
    dblSumAmount1 = 0;
    dblSumAmount2 = 0;
  if(policyDto.getPrpCitemKindDtoList()!=null){
    for(index=0;index<intItemKindCount;index++)
    {
      prpItemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
      //strRiskCode = prpItemKindDto.getRiskCode();
      //strKindCode = prpItemKindDto.getKindCode();
      //dbPrpDkind.getInfo(strRiskCode,strKindCode);
      //strCalculateFlag = dbPrpDkind.getCalculateFlag().substring(0,2);
      //strCalculateFlag = uiCodeAction.translateCalculateFlag(strRiskCode,strKindCode);  
      strCalculateFlag = prpItemKindDto.getCalculateFlag();
      if( strCalculateFlag.equals("Y") ) 
      {
        dblSumAmount1 += prpItemKindDto.getAmount();
      }
      if( strCalculateFlag.equals("N") ) 
      {
        dblSumAmount2 += prpItemKindDto.getAmount();
      }      
    }    
  }    

%>
    tdSumAmount1.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount1)%>';
    tdSumAmount2.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount2)%>';    
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
<%
    if(registDto.getPrpLregistTextDtoList()!=null){
      intTextCount = registDto.getPrpLregistTextDtoList().size();
      for(index=0;index<intTextCount;index++){
        prpLregistTextDto = (PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(index);
          strContext += prpLregistTextDto.getContext();
      }
    }
    String strIndemnityDuty = prpLclaimDto.getIndemnityDuty();
%>
    tdContext.innerHTML = '�¹ʸſ���'+'<%=strContext%>'+'<br><br>�¹����Σ�'+'<%=uiCodeAction.translateCodeCode("IndemnityDuty",strIndemnityDuty,true)%>';
  }
</script>
