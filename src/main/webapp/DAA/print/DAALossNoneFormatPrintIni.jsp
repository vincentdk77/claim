<%--
****************************************************************************
* DESC       �������������ն��𱨸�/��ϸ���ӡ��ʼ��
* AUTHOR     ��zhulianyu
* CREATEDATE ��2005-11-15
* MODIFYLIST ��   Name       Date            Reason/Contents
--------------------------------------------------------------------------
****************************************************************************
--%>

<%-- ����bean�ಿ�� --%> 
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.util.*"%>
<%@page import="com.sinosoft.sysframework.common.util.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%>
<%@page import="com.sinosoft.claim.dto.custom.RepairContentDto;"%>

<%

  //������������
  String printType         = request.getParameter("printType"); 
  String licenseNo         = request.getParameter("strLicenseNo");
  System.out.println("oooooooo00000000000000���ƺ�ooooooo==="+licenseNo);
  String  engineNo="" ;
  String  frameNo="" ;
  String  brandName="" ;
  Date printDate = new Date();
  
  //String strClaimNo         = request.getParameter("ClaimNo"); //������
  String strPolicyNo        = ""  ;   //������
  String strLicenseNo       = ""  ;   //���ƺ���
  String strLicenseNo1      = ""  ;   //���ƺ���
  String strFrameNo         = ""  ;   //���ܺ�
  String strDamageStartDate = ""  ;   //����ʱ��
  String strDamageStartHour = ""  ;   //����Сʱ
  String strInsuredName     = ""  ;   //��������
  String strBrandName       = ""  ;   //�����ͺ�
  String strEngineNo        = ""  ;   //��������
  String strKindCode        = ""  ;   //�ձ�����
  String strIndemnityDuty   = ""  ;   //�¹�����
  String strEnrollDate      = ""  ;   //��������
  double douExhaustScale    = 0   ;   //������
  String strSafeDevice      = ""  ;   //��ȫװ��
  String strRepairStartDate = ""  ;   //����ʱ��
  String strRepairEndDate   = ""  ;   //�޸�����ʱ��
  String strInsureCarFlag   = ""  ;   //�Ƿ�Ϊ����������
  double [] dblRepSumDefLoss      ;   //������Ŀ�ܽ��
  double [] dblComSumDefLoss      ;   //������Ŀ�ܽ��
  double [] dblProSumReject       ;   //��ֵ���۽��
  String [] strRepSumDefLoss1     ;   //
  String [] strComSumDefLoss1     ;   //
  String [] strProSumReject1      ;   //
  String [] strRepSumDefLoss2     ;   //
  String [] strComSumDefLoss2     ;   //
  String [] strProSumReject2      ;   //
  String [] strRepContext         ;   //������Ŀ�ܽ�����������
  String [] strComContext         ;   //������Ŀ�ܽ�����������
  String [] strProContext         ;   //��ֵ���۽�����������
  int    [] intCount              ;
  String strGearboxType       = "";   //
  String strGearboxName       = "";   //
  String strQuoteCompanyGrade = "";   //
  String strQuoteCompanyName  = "";   //
  String strMessage           = "";
  String strCurrency          = "";   //�ұ�
//  String strMainKindName      = "";   //�����ձ�
  String strHandlerName       = "";   //�鿱������

  //caopeng11.22
  String [] strCompName			  ;   //���������
  String [] strCompName1		  ;   //���������
  String [] strRepairType		  ;   //������Ŀ
  double [] dblMaterialQuantity  ;   //����
  double [] dblMaterialUnitPrice ;   //����۸�
  double [] dblManHourFee		  ;   //��ʱ��
  double [] dblSumManHourFee	  ;   //��ʱ��С��
  double [] dblSumMaterialFee    ;   //���Ϸ�С��
  double [] dblSumMQuantity      ;   //����С��
  double    dblSumMaterialFeeTemp  = 0.0;
  int       inttemp           = 0;
  //caopeng11.22
  
  //liuyanmei  start
   double[] dblManHour ;
   double[]  dblMaterialFee ;
   // strSanctioner  strApproverName
   String[] dblRemark ;
  
  //liuyanmei end 
	
	
  //���뷭�����
  

  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־

  //�����岿��

  PrpCitemCarDto    prpItemcarDto       = null;   //������ItemcarDto����
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto����
  PrpLcheckDto       prpLcheckDto       = null;   //checkDto����
  PrpLpropDto        prpLpropDto        = null;   //propDto����
  PrpLcomponentDto   prpLcomponentDto   = null;   //ComponentDto����
  PrpLrepairFeeDto   prpLrepairFeeDto   = null;   //RepairFeeDto����
  //add by miaowenjun 20060403
  PrpLverifyLossDto prpLverifyLossDto = null;
  //add end by miaowenjun 20060403


  int intClaimCount      = 0;   //ClaimDto����ļ�¼��
  int intItemCarCount    = 0;   //itemCarDto����ļ�¼��
  int intThirdPartyCount = 0;   //ThirdPartyDto����ļ�¼��
  int intCheckCount      = 0;   //CheckDto����ļ�¼��
  int intPropCount       = 0;   //PropDto����ļ�¼��
  int intComponentCount  = 0;   //ComponentDto����ļ�¼��
  int intRepairFeeCount  = 0;   //RepairFeeDto����ļ�¼��
  int intCarLossCount    = 0;   //add by miaowenjun 20060406
  
  //add by miaowenjun 20060406
  double sumhour1 = 0;
  double sumhour2 = 0;
  double sumhour3 = 0;
  double sumhour4 = 0;
  double sumhour5 = 0;
  double sumhourfee1 = 0;
  double sumhourfee2 = 0;
  double sumhourfee3 = 0;
  double sumhourfee4 = 0;
  double sumhourfee5 = 0;
  int count1 = 0;
  int count2 = 0;
  int count3 = 0;
  int count4 = 0;
  int count5 = 0;
  PrpLcarLossDto prpLcarLossDto = null;
  double[] sumTransFee;
  double[] sumTax;
  double[] sumManager;
  String strSumAllFee = "";
  //add end by miaowenjun 20060406
  
  //add by miaowenjun 20060328
  double firstsumhour = 0;
  double firstsumhourfee = 0;
  double secondsumhour = 0;
  double secondsumhourfee = 0;
  double sumhour = 0;
  double sumhourfee = 0;
  List repairListInfo = new ArrayList();
  int repaircount = 0;
  int pageNo = 0;;
  int pageTotal = 0;;
  String strApproverName = "";
  Date verpDate = new Date();
  //add end by miaowenjun 20060328
  
  //add by miaowenjun 20060405
  int changecount = 0;
  int changePageNo = 0;
  int changePageTotal = 0;
  List changeListInfo = new ArrayList();
  double firstchangefee = 0;
  double secondchangefee = 0;
  double sumchangefee = 0;
  //add end by miaowenjun 20060405

  int index = 0;

  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto����
 
  if( ! printType.equals("ComponentList")  ) {
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  }
  
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  CheckDto checkDto = (CheckDto)request.getAttribute("checkDto");
  CertainLossDto certainLossDto = (CertainLossDto)request.getAttribute("certainLossDto");
  

  UICodeAction uiCodeAction = new UICodeAction();

  //�õ�������
  //strPolicyNo = claimDto.getPrpLclaimDto().getPolicyNo();  
  strPolicyNo = registDto.getPrpLregistDto().getPolicyNo(); 
  //System.out.println("����������:"+strPolicyNo);
  PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();
  int intPrpCitemKind = 0;
  String[] strKindName = new String[3];
  strKindName[0] = "";
  strKindName[1] = "";
  strKindName[2] = "";
  String[] strMainKindName = new String[4];
  strMainKindName[0] = "";
  strMainKindName[1] = "";
  strMainKindName[2] = "";
  strMainKindName[3] = "";
  
    int k = 0 ; 
  intPrpCitemKind = policyDto.getPrpCitemKindDtoList().size();
  String riskCode = policyDto.getPrpCmainDto().getRiskCode();
  //�õ�������Ϣ
  if(policyDto.getPrpCitemKindDtoList()!=null){
    int temp = 0;
     
  for(index=0;index<intPrpCitemKind;index++)
  {
    prpCitemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
    if(prpCitemKindDto.getFlag().substring(1,2).equals("1")||(("0507".equals(riskCode)||"0577".equals(riskCode)||"0587".equals(riskCode)) && prpCitemKindDto.getFlag().substring(1,2).equals("2")))
    {
       //strMainKindName += "  "+prpCitemKindDto.getKindName();
        strMainKindName[k]= prpCitemKindDto.getKindName();
        //System.out.println("strMainKindName[k]=="+ k +strMainKindName[k]);
        k++;
    }
    if(prpCitemKindDto.getFlag().substring(1,2).equals("2")&&temp<3&&!"0507".equals(riskCode)&&!"0577".equals(riskCode)&&!"0587".equals(riskCode))
    {
    strKindName[temp] = prpCitemKindDto.getKindName();
    temp++;
    }
  }
}
  //�õ�blPrpCitemCar����
  if(policyDto.getPrpCitemCarDtoList()!=null){
    intItemCarCount     = policyDto.getPrpCitemCarDtoList().size();
  }

  //�õ�prpLclaimDto����
  // prpLclaimDto   = claimDto.getPrpLclaimDto();
  //String strRegistNo = prpLclaimDto.getRegistNo();
   PrpLregistDto prpLregistDto =registDto.getPrpLregistDto();
   
  String strRegistNo = prpLregistDto.getRegistNo(); 
   
  //�õ����ұ�
  //strCurrency = prpLregistDto.getCarKindCode();

  //�õ�blPrpLthirdParty����ļ�¼��
  if(registDto.getPrpLthirdPartyDtoList()!=null){
    intThirdPartyCount     = registDto.getPrpLthirdPartyDtoList().size();
  }

  //�õ�blPrpLcheck����ļ�¼��
  prpLcheckDto = checkDto.getPrpLcheckDto();

  //�õ�blPrpLprop����ļ�¼��
  if(certainLossDto.getPrpLpropDtoList()!=null){
    intPropCount     = certainLossDto.getPrpLpropDtoList().size();
  }

  //�õ�blPrpLcomponent����ļ�¼��
  if(certainLossDto.getPrpLcomponentDtoList()!=null){
    intComponentCount     = certainLossDto.getPrpLcomponentDtoList().size();
  }
  
  //add by miaowenjun 20060406
  if(certainLossDto.getPrpLcarLossDtoList() != null){
  	intCarLossCount = certainLossDto.getPrpLcarLossDtoList().size();
  }
  //add end by miaowenjun 20060406

  //�õ�blPrpLrepairFee����ļ�¼��
  if(certainLossDto.getPrpLrepairFeeDtoList()!=null){
    intRepairFeeCount     = certainLossDto.getPrpLrepairFeeDtoList().size();
    System.out.println("-----------------���� =="+intRepairFeeCount);
  }

//engineNo =new String[intThirdPartyCount];
//frameNo =new String[intThirdPartyCount];
//brandName =new String[intThirdPartyCount];


   dblRepSumDefLoss   = new double[intThirdPartyCount];
   dblComSumDefLoss   = new double[intThirdPartyCount];
   dblProSumReject    = new double[intThirdPartyCount];
   strRepSumDefLoss1  = new String[intThirdPartyCount];
   strComSumDefLoss1  = new String[intThirdPartyCount];
   strProSumReject1   = new String[intThirdPartyCount];
   strRepSumDefLoss2  = new String[intThirdPartyCount];
   strComSumDefLoss2  = new String[intThirdPartyCount];
   strProSumReject2   = new String[intThirdPartyCount];
   strRepContext      = new String[intThirdPartyCount];
   strComContext      = new String[intThirdPartyCount];
   strProContext      = new String[intThirdPartyCount];
   intCount           = new int[intThirdPartyCount];
   
   //caopeng11.22
   strCompName        = new String[intComponentCount];
   dblMaterialQuantity  = new double[intComponentCount];
   dblMaterialUnitPrice = new double[intComponentCount];
   strRepairType      = new String[intRepairFeeCount];
   strCompName1       = new String[intRepairFeeCount];
   dblManHourFee      = new double[intRepairFeeCount];
   dblManHour      = new double[intRepairFeeCount];
   dblMaterialFee = new double[intRepairFeeCount];
   dblRemark = new String[intRepairFeeCount];
   dblSumManHourFee   = new double[intThirdPartyCount];
   dblSumMaterialFee  = new double[intThirdPartyCount];
   dblSumMQuantity    = new double[intThirdPartyCount];
   sumTransFee        = new double[intCarLossCount];
   sumTax             = new double[intCarLossCount];
   sumManager         = new double[intCarLossCount];
   
   //caopeng11.22
  
   for(index=0;index<intThirdPartyCount;index++)
   {
      dblRepSumDefLoss [index] = 0.0;
      dblComSumDefLoss [index] = 0.0;
      dblProSumReject  [index] = 0.0;
      strRepSumDefLoss1[index] = "";
      strComSumDefLoss1[index] = "";
      strProSumReject1 [index] = "";
      strRepSumDefLoss2[index] = "";
      strComSumDefLoss2[index] = "";
      strProSumReject2 [index] = "";
      strRepContext    [index] = "";
      strComContext    [index] = "";
      strProContext    [index] = "";
      intCount         [index] = 0;
      //caopeng11.22
      dblSumManHourFee [index] = 0.0;
      dblSumMaterialFee[index] = 0.0;
      dblSumMQuantity  [index] = 0.0;
      //caopeng11.22
   }
      //caopeng11.22
   for(index=0;index<intComponentCount;index++){
      strCompName      [index] = "";
      dblMaterialQuantity [index] = 0.0;
      dblMaterialUnitPrice[index] = 0.0;
   }
   for(index=0;index<intRepairFeeCount;index++){
      strRepairType       [index] = "";
      strCompName1        [index] = "";
      dblManHourFee    [index] = 0.0;
      dblManHour  [index] =0.0; 
     
   }
      //caopeng11.22
   

%>

<script language="javascript">
  function loadForm()
  {
 

<%
    strInsuredName=StringConvert.encode(prpLregistDto.getInsuredName());
    //�б���˾
    strCode = "";
    strName = "";
    strCode = StringConvert.encode(prpLregistDto.getComCode());
    strName = uiCodeAction.translateComCode(strCode,isChinese);

    strDamageStartDate = prpLregistDto.getDamageStartDate().toString();
    strDamageStartHour = prpLregistDto.getDamageStartHour().toString();
    strDamageStartDate = strDamageStartDate.substring(0,4)+"��"+strDamageStartDate.substring(5,7)+"��"+strDamageStartDate.substring(8,10)+"��"+strDamageStartHour.substring(0,2)+"ʱ";
    //�¹�����
    strCode = "";
    strName = "";
    strCode = StringConvert.encode(prpLregistDto.getIndemnityDuty());
    strName = uiCodeAction.translateCodeCode("IndemnityDuty",strCode,isChinese);
    strIndemnityDuty = strName;


	//add by miaowenjun 20060403	
	prpLverifyLossDto = certainLossDto.getPrpLverifyLossDto();
	
	if(prpLverifyLossDto != null){			
		strApproverName =  uiCodeAction.translateUserCode(prpLverifyLossDto.getVerpApproverCode(),true);
      	verpDate = prpLverifyLossDto.getVerpDate();
	}
 	 //add end by miaowenjun 20060403
	
    //*****���⳵����ϢPrpLthirdParty*****

  if(registDto.getPrpLthirdPartyDtoList()!=null){
    for(index=0;index<intThirdPartyCount;index++)
    {
      prpLthirdPartyDto = (PrpLthirdPartyDto)registDto.getPrpLthirdPartyDtoList().get(index);
      strInsureCarFlag     = prpLthirdPartyDto.getInsureCarFlag();

      if( strInsureCarFlag.equals("1") )
      {
        strLicenseNo = prpLthirdPartyDto.getLicenseNo();
        strBrandName = prpLthirdPartyDto.getBrandName();
        strEngineNo  = prpLthirdPartyDto.getEngineNo();
        strFrameNo   = prpLthirdPartyDto.getFrameNo();

        //�������
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(prpLthirdPartyDto.getClauseType());
        strName = uiCodeAction.translateCodeCode("ClauseType",strCode,isChinese);
        strKindCode =  strName;
      }
    }
  }

 
  
  if(policyDto.getPrpCitemCarDtoList()!=null){
    //*****�������ձ����Ϣ��PrpCitemCar*****
    for(index=0;index<intItemCarCount;index++)
    {
      prpItemcarDto = (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(index);
      strLicenseNo1 = StringConvert.encode(prpItemcarDto.getLicenseNo());

      if( strLicenseNo1.equals(strLicenseNo) )
      {
        if(prpItemcarDto.getVINNo() != ""){
            strFrameNo = strFrameNo+ prpItemcarDto.getVINNo();
         }
         //ȡ��������,��ʱȡ��������Ϊ����������
         strEnrollDate = prpItemcarDto.getEnrollDate().toString();
         strEnrollDate = strEnrollDate.substring(0,4)+"��"+strEnrollDate.substring(5,7)+"��"+strEnrollDate.substring(8,10)+"��";
         //������
         douExhaustScale = prpItemcarDto.getExhaustScale();
         //��ȫװ��(Ӧ�������뷭��)
         strSafeDevice   = prpItemcarDto.getSafeDevice();
         java.util.StringTokenizer tokenizer = new java.util.StringTokenizer(strSafeDevice);
         while(tokenizer.hasMoreTokens())
         {
            strSafeDevice = tokenizer.nextToken(",");
            strSafeDevice  += uiCodeAction.translateCodeCode("SafeDevice",strSafeDevice,true)+" ";
            System.out.println("��ȫװ��"+strSafeDevice);
         }
      }
    }
  }

  if(certainLossDto.getPrpLrepairFeeDtoList()!=null){
    for(index=0;index<intRepairFeeCount;index++)
    {
      prpLrepairFeeDto = (PrpLrepairFeeDto)certainLossDto.getPrpLrepairFeeDtoList().get(index);
      if(strLicenseNo.equals(prpLrepairFeeDto.getLicenseNo()))
      {
          strRepairStartDate = prpLrepairFeeDto.getRepairStartDate().toString();
          strRepairEndDate   = prpLrepairFeeDto.getRepairEndDate().toString();
      }
    }
  }
  if(certainLossDto.getPrpLcomponentDtoList()!=null){
    for(index=0;index<intComponentCount;index++)
    {
      prpLcomponentDto = (PrpLcomponentDto)certainLossDto.getPrpLcomponentDtoList().get(index);

      if(strLicenseNo.equals(prpLcomponentDto.getLicenseNo()))
       {
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
      System.out.println("��������ʽ"+strGearboxName);
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
      }
    }
  }

  if(registDto.getPrpLthirdPartyDtoList()!=null){
     for(int i=0;i<intThirdPartyCount;i++)
    {
      prpLthirdPartyDto = (PrpLthirdPartyDto)registDto.getPrpLthirdPartyDtoList().get(i);
      strInsureCarFlag     = prpLthirdPartyDto.getInsureCarFlag();
      

if (prpLthirdPartyDto.getLicenseNo().equals(licenseNo)){
      engineNo =prpLthirdPartyDto.getEngineNo();
      frameNo =prpLthirdPartyDto.getFrameNo();
      brandName =prpLthirdPartyDto.getBrandName();
}

      if( "1".equals(strInsureCarFlag))
      {
        strLicenseNo         = prpLthirdPartyDto.getLicenseNo();
      }

      //*****��������嵥��PrpLrepairFee*****
      //dblRepSumDefLoss = 0;

    if(certainLossDto.getPrpLrepairFeeDtoList()!=null){
      for(index=0;index<intRepairFeeCount;index++)
      {
        prpLrepairFeeDto = (PrpLrepairFeeDto)certainLossDto.getPrpLrepairFeeDtoList().get(index);

        if(strLicenseNo.equals(prpLrepairFeeDto.getLicenseNo()))
        {
          dblRepSumDefLoss[i] += prpLrepairFeeDto.getSumDefLoss();
          
        }
        //caopeng11.22
      	strRepairType        [index] = prpLrepairFeeDto.getRepairType();
        strCompName1         [index] = StringConvert.encode(prpLrepairFeeDto.getCompName());
        dblManHour           [index] = prpLrepairFeeDto.getManHour();
      	dblManHourFee        [index] = prpLrepairFeeDto.getManHour()*prpLrepairFeeDto.getManHourUnitPrice();
      	dblMaterialFee       [index] = prpLrepairFeeDto.getMaterialFee(); 
      	dblRemark            [index] = prpLrepairFeeDto.getRemark();
        dblSumManHourFee[i] += dblManHourFee[index];
        strCode = prpLrepairFeeDto.getHandlerCode();
        //caopeng11.22
        
      }
        
      
        
      strHandlerName = uiCodeAction.translateUserCode(strCode,isChinese);
    }

      //*****������Ŀ�嵥��PrpLcomponent**** 
      //dblComSumDefLoss = 0;
 System.out.println("===========printType= Loss====="+printType);  
    if(certainLossDto.getPrpLcomponentDtoList()!=null){  	
     if(printType.equals("ComponentListPrint") || printType.equals("LossPrint")) {
      System.out.println("===========printType======"+printType);

      for(index=0;index<intComponentCount;index++)
      {
        prpLcomponentDto = (PrpLcomponentDto)certainLossDto.getPrpLcomponentDtoList().get(index);
         if(strLicenseNo.equals(prpLcomponentDto.getLicenseNo()))
        {
          dblComSumDefLoss[i] += prpLcomponentDto.getSumDefLoss();
          
          intCount[i]++;
        }
        //modify by caopeng start 2005-12-19 
        strCompName       [index] = StringConvert.encode(prpLcomponentDto.getCompName());
      	dblMaterialQuantity  [index] = prpLcomponentDto.getQuantity();
      	dblMaterialUnitPrice [index] = prpLcomponentDto.getSumDefLoss();
      	dblSumMQuantity [i]  += dblMaterialQuantity  [index];
      	dblSumMaterialFee[i] += dblMaterialQuantity[index]*dblMaterialUnitPrice [index];
      	
      	strCode = prpLcomponentDto.getHandlerCode();
     
      	if(index<=23){
      	  dblSumMaterialFeeTemp = dblSumMaterialFee[i];
      
      
      	 %>
     <!-- 	tdSumMaterialFee1.innerHTML = '<div align="center">' + '<%=new DecimalFormat("#,##0.00").format(dblSumMaterialFeeTemp)%>' + '</div>';-->
      	<%
      	}
      	if(index<48){
      	%>
      	<%--
     	  tdIndex<%=index%>.innerHTML = '<div align="center">' + '<%=(index+1)%>' + '</div>'; 
      	tdComName<%=index%>.innerHTML = '<div align="center">' + '<%=strCompName[index]%>' + '</div>'; 
      	tdQuantity<%=index%>.innerHTML = '<div align="center">' + '<%=new DecimalFormat("#").format(dblMaterialQuantity[index])%>' + '</div>';
      	tdPrice<%=index%>.innerHTML = '<div align="center">' + '<%=new DecimalFormat("#,##0.00").format(dblMaterialUnitPrice[index])%>' + '</div>';
      	--%>
      	<%}
      	//modify by caopeng end 2005-12-19
      } //forddd
      	strHandlerName = uiCodeAction.translateUserCode(strCode,isChinese);
      %>
      <!--tdSumMaterialFee2.innerHTML = '<div align="center">' + '<%=new DecimalFormat("#,##0.00").format((dblSumMaterialFee[i]-dblSumMaterialFeeTemp))%>' + '</div>';-->
            <%   }  //fi print
      //-----------------------
         if( printType.equals("ComponentAddPrint") ) {
      System.out.println("===========printType======"+printType);
      for(index=48;index<intComponentCount;index++)
      {  System.out.println("6666666666=="+index);
        prpLcomponentDto = (PrpLcomponentDto)certainLossDto.getPrpLcomponentDtoList().get(index);
         if(strLicenseNo.equals(prpLcomponentDto.getLicenseNo()))
        {
          dblComSumDefLoss[i] += prpLcomponentDto.getSumDefLoss();
          
          intCount[i]++;
        }
        //modify by caopeng start 2005-12-19 
        strCompName       [index] = StringConvert.encode(prpLcomponentDto.getCompName());
      	dblMaterialQuantity  [index] = prpLcomponentDto.getQuantity();
      	dblMaterialUnitPrice [index] = prpLcomponentDto.getSumDefLoss();
      	dblSumMQuantity [i]  += dblMaterialQuantity  [index];
      	dblSumMaterialFee[i] += dblMaterialQuantity[index]*dblMaterialUnitPrice [index];
     
      	if(index<=71){
      	  dblSumMaterialFeeTemp = dblSumMaterialFee[i];
      
      
      	 %>
      <!--	tdSumMaterialFee1.innerHTML = '<div align="center">' + '<%=new DecimalFormat("#,##0.00").format(dblSumMaterialFeeTemp)%>' + '</div>';-->
      	<%
      	}
      	if(index<96){
      	%>
      	<%--
     	tdIndex<%=index%>.innerHTML = '<div align="center">' + '<%=(index+1)%>' + '</div>'; 
      	tdComName<%=index%>.innerHTML = '<div align="center">' + '<%=strCompName[index]%>' + '</div>'; 
      	tdQuantity<%=index%>.innerHTML = '<div align="center">' + '<%=new DecimalFormat("#").format(dblMaterialQuantity[index])%>' + '</div>';
      	tdPrice<%=index%>.innerHTML = '<div align="center">' + '<%=new DecimalFormat("#,##0.00").format(dblMaterialUnitPrice[index])%>' + '</div>';
      	--%>
      	<%}
      	//modify by caopeng end 2005-12-19
      } //forddd
      %>
   <!--   tdSumMaterialFee2.innerHTML = '<div align="center">' + '<%=new DecimalFormat("#,##0.00").format((dblSumMaterialFee[i]-dblSumMaterialFeeTemp))%>' + '</div>';-->
            <%   }  //fi print 
         
         
            
            
      //------------------------      
      }//finull
      
    //add by miaowenjun 20060406
    if(certainLossDto.getPrpLcarLossDtoList() != null){
    	for(index=0;index<intCarLossCount;index++){
    		prpLcarLossDto = (PrpLcarLossDto)certainLossDto.getPrpLcarLossDtoList().get(index);
    		sumManager[index] =  prpLcarLossDto.getSumManager();
    		sumTax[index] = prpLcarLossDto.getSumTax();
    		sumTransFee[index] = prpLcarLossDto.getSumTransFee();
    		strCurrency = prpLcarLossDto.getCurrency();
    	}
    }	
    //add end by miaowenjun 20060406      
   
    
    if(certainLossDto.getPrpLpropDtoList()!=null){
      //*****�Ʋ��˶�����ϸ�嵥��PrpLprop*****
      for(index=0;index<intPropCount;index++)
      {
        prpLpropDto = (PrpLpropDto)certainLossDto.getPrpLpropDtoList().get(index);

         if(strLicenseNo.equals(prpLpropDto.getFamilyName()))
        {
           dblProSumReject[i] += prpLpropDto.getSumReject();
        }
      }
    }

      if( dblComSumDefLoss[i] != 0 )
      {
        strComSumDefLoss1[i] = MoneyUtils.toChinese(dblComSumDefLoss[i],strCurrency);
      }
      if( dblRepSumDefLoss[i] != 0 )
      {
        strRepSumDefLoss1[i] = MoneyUtils.toChinese(dblRepSumDefLoss[i],strCurrency);
      }
      if( dblProSumReject[i] != 0 )
      {
        strProSumReject1[i]  = MoneyUtils.toChinese(dblProSumReject[i],strCurrency);
      }

      strRepSumDefLoss2[i] = "������" + DataUtils.zeroToEmpty(dblRepSumDefLoss[i]);
      strComSumDefLoss2[i] = "������" + DataUtils.zeroToEmpty(dblComSumDefLoss[i]);
      strProSumReject2 [i] = "������" + DataUtils.zeroToEmpty(dblProSumReject[i]);

      strRepContext[i] = "������ܼƽ�������Ҵ�д�� " + strRepSumDefLoss1[i];
      strComContext[i] = "���ƺ��룺" + strLicenseNo + "��������Ŀ���� " + DataUtils.zeroToEmpty(intCount[i]) + " ��ܼƽ�������Ҵ�д�� " + strComSumDefLoss1[i];
      strProContext[i] = "��ֵ���۽�������Ҵ�д�� " + strProSumReject1[i];

    }
    
    //add by miaowenjun 20060406
     for(index=0;index<intRepairFeeCount;index++){
        if(strRepairType[index].equals("01") || strRepairType[index] == ""){   	
        	sumhour1 = sumhour1 + dblManHour[index];
        	sumhourfee1 = sumhourfee1 + dblManHourFee[index];
        	count1++;
        }
        if(strRepairType[index].equals("02")){
        	sumhour2 = sumhour2 + dblManHour[index];
        	sumhourfee2 = sumhourfee2 + dblManHourFee[index];
        	count2++;
        }
        if(strRepairType[index].equals("03")){
        	sumhour3 = sumhour3 + dblManHour[index];
        	sumhourfee3 = sumhourfee3 + dblManHourFee[index];
        	count3++;
        }
        if(strRepairType[index].equals("04")){
        	sumhour4 = sumhour4 + dblManHour[index];
        	sumhourfee4 = sumhourfee4 + dblManHourFee[index];
        	count4++;
        }
        if(strRepairType[index].equals("05")){
        	sumhour5 = sumhour5 + dblManHour[index];
        	sumhourfee5 = sumhourfee5 + dblManHourFee[index];
        	count5++;
        }
    }
        //add end by miaowenjun 20060406 
    
    //add by miaowenjun 20060328 
      for(int z=0;z<strRepairType.length;z++){
        if(strRepairType[z].equals("01") || strRepairType[z] == ""){
          strRepairType[z] = "�¹��ӽ�";
        }else if(strRepairType[z].equals("02")){
          strRepairType[z] = "�¹�����";
        }else if(strRepairType[z].equals("03")){
          strRepairType[z] = "�¹ʻ���";
        }else if(strRepairType[z].equals("04")){
          strRepairType[z] = "�¹ʵ繤";
        }else if(strRepairType[z].equals("05")){
          strRepairType[z] = "�¹ʲ�װ";
        }else if(strRepairType[z].equals("99")){
          strRepairType[z] = "�¹�����";
        }
      }
      Vector vec = new Vector();
      for(int n=0;n<strRepairType.length;n++){
      	if((!vec.contains(strRepairType[n]))&&(strRepairType[n] != null)){
      		vec.add(strRepairType[n]);
      	}
      }   
      repaircount = vec.size() + strCompName1.length;
      RepairContentDto repairContentDto; 
	  for(int l=0;l<vec.size();l++){
	    int no = 1;
	    repairContentDto = new RepairContentDto();
	    repairContentDto.setRepairType(vec.get(l).toString());
			repairContentDto.setIsType(true);
		  repairListInfo.add(repairContentDto);
		  for(int j=0;j<strCompName1.length;j++){
		    if(strRepairType[j].equals(vec.get(l).toString())){
		      repairContentDto = new RepairContentDto();
		      repairContentDto.setNo(no);
	      	repairContentDto.setRepairName(strCompName1[j]);
	   			no++;
	 				repairContentDto.setRepairHour(dblManHour[j]);
	      	repairContentDto.setRepairHourFee(dblManHourFee[j]); 
	      	repairListInfo.add(repairContentDto);	
		    }
		  }
	  }
	  for(int i=0;i<repairListInfo.size();i++){
	  	sumhour += ((RepairContentDto)repairListInfo.get(i)).getRepairHour();
		sumhourfee += ((RepairContentDto)repairListInfo.get(i)).getRepairHourFee();
	  }
	  if(repaircount<=46){
	  	pageTotal = 1;
	  }else{
	  	if((repaircount-46)%54 == 0)
	  		pageTotal = (repaircount-46)/54 + 1;
	  	else
	  		pageTotal = (repaircount-46)/54 + 2;
	  }
    //add end by miaowenjun 20060328
    
    //add by miaowenjun 20060405
    changecount = strCompName.length;
    RepairContentDto changeRepairContentDto;
    for(int m=0;m<changecount;m++){
    	changeRepairContentDto = new RepairContentDto();
    	changeRepairContentDto.setNo(m+1);
    	changeRepairContentDto.setChangeName(strCompName[m]);
    	changeRepairContentDto.setChangeCount(dblMaterialQuantity[m]);
    	changeRepairContentDto.setChangeFee(dblMaterialUnitPrice[m]);
    	changeListInfo.add(changeRepairContentDto);
    }
    for(int i=0;i<changeListInfo.size();i++){
	  	sumchangefee += ((RepairContentDto)changeListInfo.get(i)).getChangeFee();
	  }
 	if(changecount<=46){
	  	changePageTotal = 1;
	  }else{
	  	if((changecount-46)%54 == 0)
	  		changePageTotal = (changecount-46)/54 + 1;
	  	else
	  		changePageTotal = (changecount-46)/54 + 2;
	  }
    //add end by miaowenjun 20060405
  }
  strSumAllFee = MoneyUtils.toChinese(dblSumManHourFee[0]+dblSumMaterialFee[0],strCurrency);
%>
  }
</script>
