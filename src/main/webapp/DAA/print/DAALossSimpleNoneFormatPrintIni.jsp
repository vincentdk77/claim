<%--
****************************************************************************
* DESC       ����������������ʧ�������ȷ�����ӡ��ʼ��
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
  String strRegistNo        = "";   //������
  String strPolicyNo        = "";   //������
  String strLicenseNo       = "";   //���ƺ���
  String strLicenseNo1      = "";   //���ƺ���
  String strFrameNo         = "";   //��������
  String strDamageStartDate = "";   //����ʱ��
  String strInsureCarFlag   = "";   //�Ƿ�Ϊ����������
  double dblRepSumDefLoss   = 0;    //������Ŀ�ܽ��  
  double dblComSumDefLoss   = 0;    //������Ŀ�ܽ��  
  double dblProSumReject    = 0;    //��ֵ���۽��
  String strRepSumDefLoss1  = "";   // 
  String strComSumDefLoss1  = "";   // 
  String strProSumReject1   = "";   // 
  String strRepSumDefLoss2  = "";   // 
  String strComSumDefLoss2  = "";   // 
  String strProSumReject2   = "";   // 
  String strRepContext      = "";   //������Ŀ�ܽ�����������
  String strComContext      = "";   //������Ŀ�ܽ�����������
  String strProContext      = "";   //��ֵ���۽�����������
  String strGearboxType     = "";   //
  String strGearboxName     = "";   //
  String strQuoteCompanyGrade = ""; //
  String strQuoteCompanyName  = ""; //
  double dblQuantity        = 0;
  double dblManHourFee1     = 0;
  double dblQueryPrice      = 0;
  double dblQuotedPrice     = 0;  
  double dblManHour         = 0;    //��ʱ
  double dblManHourFee2     = 0;    //��ʱ��
  double dblMaterialFee     = 0;    //���Ϸ�
  double dbSum1             = 0;
  double dbSum2             = 0;
  String strMessage         = "";
  //add by caopeng start at 2005-12-20
        double dbSumSum2    =0.0;        
  //add by caopeng end at 2005-12-20
    
  //���뷭�����

  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
  
  //�����岿��
                                             
  PrpCitemCarDto    prpItemcarDto     = null;   //������ItemcarDto����
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto����
  PrpLcheckDto       prpLcheckDto       = null;   //checkDto����
  PrpLpropDto        prpLpropDto        = null;   //propDto����
  PrpLcomponentDto   prpLcomponentDto   = null;   //ComponentDto����
  PrpLrepairFeeDto   prpLrepairFeeDto   = null;   //RepairFeeDto����
  
  int intClaimCount      = 0;   //ClaimDto����ļ�¼��
  int intItemCarCount    = 0;   //Item_carDto����ļ�¼��
  int intThirdPartyCount = 0;   //ThirdPartyDto����ļ�¼��
  int intCheckCount      = 0;   //CheckDto����ļ�¼��
  int intPropCount       = 0;   //PropDto����ļ�¼��
  int intComponentCount  = 0;   //ComponentDto����ļ�¼��
  int intRepairFeeCount  = 0;   //RepairFeeDto����ļ�¼��
    
  int index = 0;
    
  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto����
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  CheckDto checkDto = (CheckDto)request.getAttribute("checkDto"); 
  CertainLossDto certainLossDto = (CertainLossDto)request.getAttribute("certainLossDto");
   
  UICodeAction uiCodeAction = new UICodeAction();
  //�õ�������
  strPolicyNo = claimDto.getPrpLclaimDto().getPolicyNo();
  
  strRegistNo = claimDto.getPrpLclaimDto().getRegistNo();
  
  //�õ�blPrpCitemCar����
  if(policyDto.getPrpCitemCarDtoList()!=null){
    intItemCarCount     = policyDto.getPrpCitemCarDtoList().size();
  }  
  
  //�õ�prpLclaimDto����
  prpLclaimDto   = claimDto.getPrpLclaimDto();
  
  //�õ�blPrpLthirdParty����ļ�¼�� 
  if(claimDto.getPrpLthirdPartyDtoList()!=null){
    intThirdPartyCount     = claimDto.getPrpLthirdPartyDtoList().size();
  }

  //�õ�check����
  prpLcheckDto = checkDto.getPrpLcheckDto();
  
  //�õ�blPrpLprop����ļ�¼��  
  if(certainLossDto.getPrpLpropDtoList()!=null){
    intPropCount     = certainLossDto.getPrpLpropDtoList().size();
  }
  
  //�õ�blPrpLcomponent����ļ�¼��
  if(certainLossDto.getPrpLcomponentDtoList()!=null){
    intComponentCount     = certainLossDto.getPrpLcomponentDtoList().size();
  }

  //�õ�blPrpLrepairFee����ļ�¼��
  if(certainLossDto.getPrpLrepairFeeDtoList()!=null){
    intRepairFeeCount     = certainLossDto.getPrpLrepairFeeDtoList().size();
  }
%>

<script language="javascript">
  function loadForm()
  {
    tdClaimNo.innerHTML = '������ţ�' + '<%=strRegistNo%>';
    
    //*****������Ϣ��PrpLregist*****
    tdPolicyNo.innerHTML    = '���յ��ţ�' + '<%=strPolicyNo%>';
    tdInsuredName.innerHTML = '�������ˣ�' + '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
<%    
    //�б���˾
    strCode = "";
    strName = "";
    strCode = StringConvert.encode(prpLclaimDto.getComCode());
    strName = uiCodeAction.translateComCode(strCode,isChinese); 
%>
    tdComName.innerHTML  = '�б���˾��' + '<%=strName%>';
    tdSumAmount.innerHTML = '���ս�' + '<%=new DecimalFormat("#,##0.00").format(prpLclaimDto.getSumAmount())%>';
<%    
    strDamageStartDate = prpLclaimDto.getDamageStartDate().toString();
//    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
//                        + " �� " + prpLclaimDto.getDamageStartDate().getMonth()
//                        + " �� " + prpLclaimDto.getDamageStartDate().getDate()
//                        + " ��";
%>                    
    tdDamageStartDate.innerHTML = '����ʱ�䣺' + '<%=strDamageStartDate%>';
    tdDamageAddress.innerHTML   = '���յص㣺' + '<%=StringConvert.encode(prpLclaimDto.getDamageAddress())%>';
<%    
    //�¹�����
    strCode = "";
    strName = "";
    strCode = StringConvert.encode(prpLclaimDto.getIndemnityDuty());
    strName = uiCodeAction.translateCodeCode("IndemnityDuty",strCode,isChinese);
%>
    tdIndemnityDuty.innerHTML  = '�¹����Σ�' + '<%=strName%>';
    
    //*****���⳵����ϢPrpLthirdParty*****
<%  
  if(claimDto.getPrpLthirdPartyDtoList()!=null){
    for(index=0;index<intThirdPartyCount;index++)
    {
      prpLthirdPartyDto = (PrpLthirdPartyDto)claimDto.getPrpLthirdPartyDtoList().get(index);
      strInsureCarFlag     = prpLthirdPartyDto.getInsureCarFlag();
      
      if( strInsureCarFlag.equals("1") ) 
      {
        strLicenseNo = prpLthirdPartyDto.getLicenseNo();
%>        
        tdLicenseNo.innerHTML = '���ƺ��룺' + '<%=strLicenseNo%>';
        tdBrandName.innerHTML = '�����ͺţ�' + '<%=prpLthirdPartyDto.getBrandName()%>';
        tdEngineNo.innerHTML  = '�������ţ�' + '<%=prpLthirdPartyDto.getEngineNo()%>';
<%
        strFrameNo = prpLthirdPartyDto.getFrameNo();
            
        //�������
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(prpLthirdPartyDto.getClauseType());
        strName = uiCodeAction.translateCodeCode("ClauseType",strCode,isChinese);
%>        
        //tdClauseType.innerHTML= '�������' + '=strName';
<%  
      }
    }    
  }

  if(policyDto.getPrpCitemCarDtoList()!=null){
    intItemCarCount     = policyDto.getPrpCitemCarDtoList().size();    
    //*****�������ձ����Ϣ��PrpCitemCar*****    
    for(index=0;index<intItemCarCount;index++)
    {
      prpItemcarDto = (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(index);
      strLicenseNo1 = StringConvert.encode(prpItemcarDto.getLicenseNo()); 
            
      if( strLicenseNo1.equals(strLicenseNo) )
      {  if(prpItemcarDto.getVINNo() == ""){  
%>
        tdFrameNo.innerHTML   = '���ܺ��루VIN�룩��' + '<%=strFrameNo%>';
<%   
        }else{
%>
        tdFrameNo.innerHTML   = '���ܺ��루VIN�룩��' + '<%=strFrameNo%>'
                                + '��' + '<%=prpItemcarDto.getVINNo()%>' + '��';
<%        
        }
      }                             
    }    
  }      

                              
    //*****�鿱/���鿱��Ϣ��PrpLcheck*****    
    //for(index=0;index<intCheckCount;index++)
    //{
      //prpLcheckDto = blClaim.getBLPrpLcheck().getArr(index); 
%>
      tdCheckDate.innerHTML = '����ʱ�䣺' + '<%=prpLcheckDto.getCheckDate()%>';
      tdCheckSite.innerHTML = '����ص㣺' + '<%=prpLcheckDto.getCheckSite()%>';
<%
    //}
    
    //*****��������嵥��PrpLrepairFee*****
    dblRepSumDefLoss = 0;
  if(certainLossDto.getPrpLrepairFeeDtoList()!=null){
    intRepairFeeCount     = certainLossDto.getPrpLrepairFeeDtoList().size();
    for(index=0;index<intRepairFeeCount;index++)
    { 
      prpLrepairFeeDto = (PrpLrepairFeeDto)certainLossDto.getPrpLrepairFeeDtoList().get(index);
      dblRepSumDefLoss += prpLrepairFeeDto.getSumDefLoss();
      
%>
      tdRepairStartDate.innerHTML = '����ʱ�䣺'     + '<%=prpLrepairFeeDto.getRepairStartDate()%>';
      tdRepairEndDate.innerHTML   = '�޸�����ʱ�䣺' + '<%=prpLrepairFeeDto.getRepairEndDate()%>';
<%
    }    
  }
      

    
    //*****������Ŀ�嵥��PrpLcomponent*****    
    dblComSumDefLoss = 0;
  if(certainLossDto.getPrpLcomponentDtoList()!=null){
    for(index=0;index<intComponentCount;index++)
    {
      prpLcomponentDto = (PrpLcomponentDto)certainLossDto.getPrpLcomponentDtoList().get(index);
      
      dblComSumDefLoss += prpLcomponentDto.getSumDefLoss();
      
      //��������ʽ
      strGearboxType = prpLcomponentDto.getGearboxType();
      if( strGearboxType.equals("1") )
      {
        strGearboxName = "�ֶ���";  
      }
      else if( strGearboxType.equals("2") )
      {
        strGearboxName = "�Զ���"; 
      }
      else
      {
        strGearboxName = "δ֪"; 
      }
      
      //���۹�˾
      strQuoteCompanyGrade = prpLcomponentDto.getRepairStartDate().toString();
      if( strQuoteCompanyGrade.equals("1") )
      {
        strQuoteCompanyName = "�ܹ�˾";
      }
      else if( strQuoteCompanyGrade.equals("2") )
      {
        strQuoteCompanyName = "ʡ��˾";
      }
      else if( strQuoteCompanyGrade.equals("3") )
      {
        strQuoteCompanyName = "���й�˾";
      }
      else
      {
        strQuoteCompanyName = "����"; 
      }
%>
      tdGearboxType.innerHTML       = '��������ʽ��' + '<%=strGearboxName%>';
      tdQuoteCompanyGrade.innerHTML = '���۹�˾��'   + '<%=strQuoteCompanyName%>';
<%
    }    
  }    

  if(certainLossDto.getPrpLpropDtoList()!=null){
    intPropCount     = certainLossDto.getPrpLpropDtoList().size();
    //*****�Ʋ��˶�����ϸ�嵥��PrpLprop*****    
    for(index=0;index<intPropCount;index++)
    {
      prpLpropDto = (PrpLpropDto)certainLossDto.getPrpLpropDtoList().get(index);      
      dblProSumReject += prpLpropDto.getSumReject();
    }    
  }    

    
    if( dblComSumDefLoss != 0 )
    {
      strComSumDefLoss1 = MoneyUtils.toChinese(dblComSumDefLoss,prpLcomponentDto.getCurrency());
    }
    if( dblRepSumDefLoss != 0 )
    {
      strRepSumDefLoss1 = MoneyUtils.toChinese(dblRepSumDefLoss,prpLrepairFeeDto.getCurrency());
    }
    if( dblProSumReject != 0 )
    {
      strProSumReject1  = MoneyUtils.toChinese(dblProSumReject,prpLpropDto.getCurrency()); 
    }
    
    strRepSumDefLoss2 = "������" + DataUtils.zeroToEmpty(dblRepSumDefLoss);
    strComSumDefLoss2 = "������" + DataUtils.zeroToEmpty(dblComSumDefLoss);
    strProSumReject2  = "������" + DataUtils.zeroToEmpty(dblProSumReject);
    
    strRepContext = "������ܼƽ�������Ҵ�д�� " + strRepSumDefLoss1;
    strComContext = "������Ŀ���� " + DataUtils.zeroToEmpty(intComponentCount) + " ��ܼƽ�������Ҵ�д�� " + strComSumDefLoss1;
    strProContext = "��ֵ���۽�������Ҵ�д�� " + strProSumReject1;
%>
    tdRepSumDefLoss.innerHTML = '<%=strRepSumDefLoss2%>';
    tdComSumDefLoss.innerHTML = '<%=strComSumDefLoss2%>';
    tdProSumReject.innerHTML  = '<%=strProSumReject2%>';  
    tdRepContext.innerHTML    = '<%=strRepContext%>'; 
    tdComContext.innerHTML    = '<%=strComContext%>'; 
    tdProContext.innerHTML    = '<%=strProContext%>'; 
  }
</script>
 