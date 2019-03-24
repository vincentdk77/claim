<%--
****************************************************************************
* DESC       ��������������(����)֤����ӡ��ʼ��
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
<%@page import="java.util.ArrayList"%>

<%
  //������������
  String strClaimNo           = request.getParameter("ClaimNo"); //������
  String strRegistNo          = "";   //������
  String strPolicyNo          = "";   //������
  String strLicenseNo         = "";   //�����еĺ��ƺ���
  String strLicenseColorCode  = "";   //�����еĺ��Ƶ�ɫ
  String strLicenseNo1        = "";   //���⳵����Ϣ�еĺ��ƺ���
  String strLicenseColorCode1 = "";   //���⳵����Ϣ�еĺ��Ƶ�ɫ
  String strLicenseNo2        = "";   //���ƺ���
  String strFrameNo           = "";   //��������
  String strInsuredFlag       = "";   //�ж���Ͷ���˻��Ǳ�������
  String strEnrollDate        = "";   //���εǼ�����
  String strReceiveLicenseDate= "";   //������֤����
  String strInsureCarFlag     = "";   //�Ƿ�Ϊ����������
  String strTextType          = "";   //��������
  String strRegistText        = "";   //������Ϣ
  String strDamageStartDate   = "";   //����ʱ��
  String strMessage           = "";

  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
  
  //�����岿��
                                          
  PrpCmainDto        prpMainDto         = null;   //������MainDto����
  PrpCinsuredDto     prpInsuredDto      = null;   //������InsuredDto����
  PrpCitemCarDto    prpItemcarDto     = null;   //������ItemcarDto����
  PrpLregistDto      prpLregistDto      = null;   //RegistDto����
  PrpLregistTextDto  prpLregistTextDto  = null;   //RegistTextDto����
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLdriverDto      prpLdriverDto      = null;   //DriverDto����
  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto����

  int intClaimCount      = 0;   //ClaimDto����ļ�¼��
  int intInsuredCount    = 0;   //InsuredDto����ļ�¼��
  int intItemCarCount    = 0;   //ItemCarDto����ļ�¼��
  int intDriverCount     = 0;   //DriverDto����ļ�¼��
  int intThirdPartyCount = 0;   //ThirdPartyDto����ļ�¼��
  int intRegistTextCount = 0;   //RegistTextDto����ļ�¼��
    
  int index = 0;
  //�õ�PolicyDto,ClaimDto,RegistDto����
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto"); 
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  
  UICodeAction uiCodeAction = new UICodeAction();
    
  //�õ�������
  strPolicyNo = claimDto.getPrpLclaimDto().getPolicyNo();

  //�õ�prpMainDto����
  prpMainDto       = policyDto.getPrpCmainDto();
   
  //�õ�PrpCinsured����ļ�¼��  
  if(policyDto.getPrpCinsuredDtoList()!=null){
    intInsuredCount     = policyDto.getPrpCinsuredDtoList().size();
  }
  //�õ�prpItemcarDto����
  if(policyDto.getPrpCitemCarDtoList()!=null){
    intItemCarCount     = policyDto.getPrpCitemCarDtoList().size();
  }  
  //�õ�PrpLthirdParty����ļ�¼��
  if(claimDto.getPrpLthirdPartyDtoList()!=null){
    intThirdPartyCount     = claimDto.getPrpLthirdPartyDtoList().size();
  }
  
  //�õ�PrpLdriver����ļ�¼��
  if(claimDto.getPrpLdriverDtoList()!=null){
    intDriverCount     = claimDto.getPrpLdriverDtoList().size();
  }

  //�õ�prpLclaimDto����
  prpLclaimDto     = claimDto.getPrpLclaimDto();
  
  //�õ�prpLregistDto����
  prpLregistDto    = registDto.getPrpLregistDto();
  
  //�õ�blPrpLregistText����ļ�¼��
  if(registDto.getPrpLregistTextDtoList()!=null){
    intRegistTextCount  = registDto.getPrpLregistTextDtoList().size();
  }
%>
 
<script language="javascript">
  function loadForm()
  {
    tdRegistNo.innerHTML = '������ţ�' + '<%=StringConvert.encode(prpLclaimDto.getRegistNo())%>';
    tdClaimNo.innerHTML  = '������ţ�' + '<%=strClaimNo%>';
    
    //*****������Ϣ��PrpLregist*****
    tdLinkerPostCode.innerHTML = '�������룺' + '<%=StringConvert.encode(prpLregistDto.getLinkerPostCode())%>';
    
    //*****Ͷ����������Ϣ��PrpCmain*****
<%
    //����Ա
    strCode = "";
    strCode = StringConvert.encode(prpMainDto.getHandlerCode());
    strName = uiCodeAction.translateUserCode(strCode,isChinese);
%>    
    tdLinkerName1.innerHTML        = '��ϵ�ˣ�'   + '<%=strName%>';
     
    //*****������Ϣ��PrpLclaim*****
    tdInsuredName.innerHTML     = '�������ˣ�' + '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
<%  
    String strDateTemp = "";  
    if(prpLclaimDto.getDamageStartHour()!=null){
      if(prpLclaimDto.getDamageStartHour().length()<2){ 
        strDateTemp = prpLclaimDto.getDamageStartHour(); 
      }else{
        strDateTemp = prpLclaimDto.getDamageStartHour().substring(0,2);
      }
    }
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                        + " �� " + prpLclaimDto.getDamageStartDate().getMonth()
                        + " �� " + prpLclaimDto.getDamageStartDate().getDate()
                        + " �� " + strDateTemp
                        + " ʱ";
%>                    
    tdDamageStartDate.innerHTML = '����ʱ�䣺' + '<%=strDamageStartDate%>';
    tdDamageAddress.innerHTML   = '���յص㣺' + '<%=StringConvert.encode(prpLclaimDto.getDamageAddress())%>';
     
    //*****���չ�ϵ�˱�PrpCinsured*****
<%
  if(policyDto.getPrpCinsuredDtoList()!=null){
    ArrayList listTemp = policyDto.getPrpCinsuredDtoList();
    for(index=0;index<intInsuredCount;index++)
    {
      prpInsuredDto = (PrpCinsuredDto)listTemp.get(index);    
      strInsuredFlag   = prpInsuredDto.getInsuredFlag();
      
      if( strInsuredFlag.equals("1") ) //��������
      {
%>
        tdLinkerName.innerHTML  = '��ϵ�ˣ�'  + '<%=StringConvert.encode(prpInsuredDto.getLinkerName())%>';
        tdPhoneNumber.innerHTML = '��ϵ�绰��'+ '<%=StringConvert.encode(prpInsuredDto.getPhoneNumber())%>';
<%        
      }
    }    
  }
 
  if(claimDto.getPrpLthirdPartyDtoList()!=null){
    //*****���⳵����ϢPrpLthirdParty*****  
    for(index=0;index<intThirdPartyCount;index++)
    {
      prpLthirdPartyDto = (PrpLthirdPartyDto)claimDto.getPrpLthirdPartyDtoList().get(index);
      strInsureCarFlag     = prpLthirdPartyDto.getInsureCarFlag();
      
      if( strInsureCarFlag.equals("1") ) 
      {
        //�б���˾
        strCode = ""; 
        strName = ""; 
        UICompanyAction uiCompanyAction = new UICompanyAction();
         
        strCode = StringConvert.encode(prpLthirdPartyDto.getInsureComCode());
        //dbPrpDcompany.getInfo(strCode); 
        strName = uiCodeAction.translateComCode(strCode,isChinese);
        PrpDcompanyDto prpDcompanyDto = uiCompanyAction.findByPrimaryKey(strCode);   
        if(prpDcompanyDto==null)    
        prpDcompanyDto = new PrpDcompanyDto();
%>        
        tdComName.innerHTML      = '�б���˾��' + '<%=strName%>';
        tdPhoneNumber1.innerHTML = '��ϵ�绰��' + '<%=prpDcompanyDto.getPhoneNumber()%>';
<%        
          
        
        strLicenseNo        = StringConvert.encode(prpLthirdPartyDto.getLicenseNo());
        strLicenseColorCode = StringConvert.encode(prpLthirdPartyDto.getLicenseColorCode());
%>        
        tdLicenseNo.innerHTML    = '���ƺ��룺' + '<%=StringConvert.encode(prpLthirdPartyDto.getLicenseNo())%>';
        tdBrandName.innerHTML    = '�����ͺţ�' + '<%=StringConvert.encode(prpLthirdPartyDto.getBrandName())%>';
        tdEngineNo.innerHTML     = '�������ţ�' + '<%=StringConvert.encode(prpLthirdPartyDto.getEngineNo())%>';
<%
        strFrameNo = StringConvert.encode(prpLthirdPartyDto.getFrameNo());
      }
    }
  }

  if(policyDto.getPrpCitemCarDtoList()!=null){     
    //*****�������ձ����Ϣ��PrpCitemCar*****    
    for(index=0;index<intItemCarCount;index++)
    {
      prpItemcarDto = (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(index);
      strLicenseNo2 = StringConvert.encode(prpItemcarDto.getLicenseNo()); 
            
      if( strLicenseNo2.equals(strLicenseNo) )
      {    
        //������ɫ
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(prpItemcarDto.getColorCode());
        strName = uiCodeAction.translateCodeCode("ColorCode",strCode,true);
%>        
        tdColorCode.innerHTML = '������ɫ��'       + '<%=strName%>';
        tdSeatCount.innerHTML = '��λ/��λ��'     + '<%=prpItemcarDto.getSeatCount()%>' + '/'
                                                  + '<%=new DecimalFormat("0.00").format(prpItemcarDto.getTonCount()/1000)%>';
<%      
      if(StringConvert.encode(prpItemcarDto.getVINNo()) == ""){
%>
        tdFrameNo.innerHTML   = '���ܺţ�VIN����' + '<%=strFrameNo%>';
<%
      }else{
%>
        tdFrameNo.innerHTML   = '���ܺţ�VIN����' + '<%=strFrameNo%>'
                                + '��'            + '<%=StringConvert.encode(prpItemcarDto.getVINNo())%>' + '��';
<%
      }
        //���εǼ�����
        strEnrollDate = prpItemcarDto.getEnrollDate().toString();
        if ( (strEnrollDate == null) || (strEnrollDate.trim().equals("")) ) 
        {
          strEnrollDate = "";
        }
        else
        {
          strEnrollDate = prpItemcarDto.getEnrollDate().getYear() + " �� "
                       + prpItemcarDto.getEnrollDate().getMonth() + " �� ";      
        }
%>      
        tdEnrollDate.innerHTML        = '�������εǼ����ڣ�' + '<%=strEnrollDate%>';
        tdPurchasePrice.innerHTML     = '�³����üۣ�'       + '<%=new DecimalFormat("#,##0.00").format(prpItemcarDto.getPurchasePrice())%>' + 'Ԫ';
<%
      }
    }
  }  

%>
    //*****���ռ�ʻԱ��Ϣ��PrpLdriver*****
    tdDriverName.innerHTML         = '��ʻԱ������';
    tdDrivingLicenseNo.innerHTML   = '��ʻ֤���룺';
    tdReceiveLicenseDate.innerHTML = '������֤���ڣ�';
    tdDrivingCarType.innerHTML     = '׼�ݳ��ͣ�';
<%  
  if(claimDto.getPrpLdriverDtoList()!=null){    
    for(index=0;index<intDriverCount;index++)
    {
      prpLdriverDto     = (PrpLdriverDto)claimDto.getPrpLdriverDtoList().get(index);
      strLicenseNo1        = prpLdriverDto.getLicenseNo();
      strLicenseColorCode1 = prpLdriverDto.getLicenseColorCode();
      
      if( strLicenseNo1.equals(strLicenseNo) && strLicenseColorCode1.equals(strLicenseColorCode) ) 
      {
%>        
        tdDriverName.innerHTML         = '��ʻԱ������'   + '<%=StringConvert.encode(prpLdriverDto.getDriverName())%>';
        tdDrivingLicenseNo.innerHTML   = '��ʻ֤���룺'   + '<%=StringConvert.encode(prpLdriverDto.getDrivingLicenseNo())%>';
<%      
        //���εǼ�����
        strReceiveLicenseDate = prpLdriverDto.getReceiveLicenseDate().toString();
        if ( (strReceiveLicenseDate == null) || (strReceiveLicenseDate.trim().equals("")) ) 
        {
          strReceiveLicenseDate = "";
        }
        else
        {
          strReceiveLicenseDate = prpLdriverDto.getReceiveLicenseDate().getYear() + " �� "
                                + prpLdriverDto.getReceiveLicenseDate().getMonth() + " �� ";      
        }
%>        
        tdReceiveLicenseDate.innerHTML = '������֤���ڣ�' + '<%=strReceiveLicenseDate%>';
        tdDrivingCarType.innerHTML     = '׼�ݳ��ͣ�'     + '<%=StringConvert.encode(prpLdriverDto.getDrivingCarType())%>';
<%  
      }
    }
  }

  strRegistText = "";
  if(registDto.getPrpLregistTextDtoList()!=null){
  //*****�������ֱ�PrpLregistText*****
    for(index=0;index<intRegistTextCount;index++)
    {
      prpLregistTextDto = (PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(index);
      strTextType = prpLregistTextDto.getTextType();
      
      if( strTextType.equals("1")) 
      {
        strRegistText += StringConvert.encode(prpLregistTextDto.getContext())+ "\\r\\n";
      }
    }
      
    //��鱨�����ִ�����Ǽ���
    int intRegistTextCountTmp1 = 0;    //textarea������
    int intRegistTextCountTmp2 = 0;    //textarea������
    String strRegistTextTmp = "";      //��"�������ݣ�������嵥..."������
    
    for(index=0;index<strRegistText.length();index++)
    {
      if(strRegistText.substring(index,index+1).equals("\\"))
      {
        if(!(strRegistText.substring(index).length()<4))
        {
          if(strRegistText.substring(index,index+4).equals("\\r\\n"))
          {
             intRegistTextCountTmp1 += 1;    //ֻҪ�лس����У�intRegistTextCountTmp1+1
             intRegistTextCountTmp2 += 1;    //ֻҪ�лس����У�intRegistTextCountTmp2+1
            if(intRegistTextCountTmp2==9)
            {
              strRegistTextTmp = strRegistText.substring(0,index+4)  //9�е�strRegistText + "�������ݣ�������嵥..."
                               + "�������ݣ�������嵥...";
            }
          }
        }
      }
    }
    
    int x = 0;
    int y = 0;
    if(!(strRegistText.length()<4))    //���strRegistText.length()>=4���ж�strRegistText��β�����֣����ǻس�����
    {
      x = strRegistText.length()-4;
      y = strRegistText.length();
      if(!strRegistText.substring(x,y).equals("\\r\\n"))
      {
         intRegistTextCountTmp1 += 1;   
      }
    }
    else    //���strRegistText����1�У�intRegistTextCountTmp1 = 1; 
      intRegistTextCountTmp1 = 1; 
    
    //���intRegistTextCountTmp1>10����strRegistText = 9�е�strRegistText + "�������ݣ�������嵥..."
    if(intRegistTextCountTmp1>10)
    {
      strRegistText = strRegistTextTmp;
    }
  }
  String strReportor = prpLregistDto.getReportorName();
  String strReportType = uiCodeAction.translateCodeCode("ReportType",prpLregistDto.getReportType(),true);
  
  strRegistText = strRegistText + "<br>"+"&nbsp;&nbsp;�����ˣ�"+strReportor+"<br>&nbsp;&nbsp;����ʱ�䣺"+strDamageStartDate+"<br>&nbsp;&nbsp;������ʽ��"+strReportType;
   
%>   
    tdRegistText.innerHTML = '<%=strRegistText%>'; 
  }
</script>
