<%--
****************************************************************************
* DESC       ���������ֳ��鿱��¼��ӡ��ʼ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16
* MODIFYLIST ��   Name       Date            Reason/Contents
--------------------------------------------------------------------------
*                 lirj     20040317        ���÷ֿ��������ƺ����ӡ
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
<%@page import="java.util.*"%>

<%
  //������������
  String strClaimNo         = "";   //������
  String strRegistNo        = "";   //������
  String strPolicyNo        = "";   //������
  String prpLRegistRPolicyNo = "";  //ǿ�Ʊ�����
  
  /**DateTime currentDateTime = new DateTime();
  int intYear = currentDateTime.getYear();
  int intMonth = currentDateTime.getMonth();
  int intDay = currentDateTime.getDay();
  int intHour = currentDateTime.getHour();
  int intMinute     = currentDateTime.getMinute();
  int intSecond  = currentDateTime.getSecond();
  String strPrintTime = new Integer(intYear).toString() + "��" +
  new Integer(intMonth).toString() + "��" +
  new Integer(intDay).toString() + "��" +
  new Integer(intHour).toString() + "ʱ" +
  new Integer(intMinute).toString() + "��" +
  new Integer(intSecond).toString() + "��";*/
  
  //����������Ϣ
  String strInsuredName	    ="";
  String strDamageAddress   ="";
  String strdamageStartDate	="";
  String strdamageStartHour     ="";
  String strdamageStartMinute   ="";
  String indemnityDutyCode      = "";//���δ���
  String indemnityDuty = "";//�¹�����
  String handleUnitCode = "";//�¹ʴ�����
  String handleUnit = "";//�¹ʴ���ʽ   
  int intItemKindCount = 0;
  String strBrandName       = "";   //�����ͺ�
  String strEngineNo        = "";   //��������
  double strRunDistance     = 0.0d;   //��������ʻ������
  int    strUseYears        = 0;   //����ʵ��ʹ������
  String strLicenseNo       = "";   //���ƺ�
  String strFrameNo         = "";   //���ܺ�
  //add by zhaolu 20060904 start
  String strLicenseColorCode = "";  //���Ƶ�ɫ��־
  String strLicenseColor = "";//���Ƶ�ɫ
  int intCarSerialNo[] = null;//������SerialNo
 //add by zhaolu 20060904 end

  //������������Ϣ
  //Modify by zhaolu 20060905 start
  String strBrandNamethird[]        = null;   //�����ͺ�
  String strEngineNothird[]         = null;   //��������
  double strRunDistancethird[]      = null;   //��������ʻ������
  int    strUseYearsthird[]         = null;   //����ʵ��ʹ������
  String strLicenseNothird[]       = null;   //���ƺ�
  String strFrameNothird[]          = null;   //���ܺ�
  System.out.println("-------------0---------------");
  String strD1="";                     //��ʻԱ����
  String strD2="";                     //��ʻ֤����
  String strD3="";                     //��ʻ֤��Ч��
//Modify by zhaolu 20060905 end
  //add begin by zhuly 20051107
  String strUseNatureCode         = "" ;//ʹ�����ʴ���
  String strUseNatureName         = "" ;//ʹ������
  String strCheckSite             = "" ;//�鿱�ص�
  String strDamageCode            = "" ;//����ԭ�����
  String strDamageClause           = "" ;//����ԭ��
  String strRunAreaCode           = "" ;//��ʻ�������
  String strRunAreaName           = "" ;//��ʻ����
  String strSexCode               = "" ;//��ʻԱ�Ա����
  String strSexName               = "" ;//��ʻԱ�Ա�����
  //add end by zhuly 20051107
  
  ArrayList prpLcheckExtDtoList = new ArrayList();
  
  //add by zhaolu 2006090404 start
  PrpLdriverDto prpLdriverDto = new PrpLdriverDto();
  ArrayList prpLdriverDtoList = new ArrayList();
  String strThirdPrpLregistPhoneNumber[] = null;//���߳���ʻԱ��ϵ�绰
  String strThirdPrpLdriverName[] = null;//���߳���ʻԱ����
  String strThirdPrpLdriverLicenseNo[] = null;//���߳���ʻԱ֤����
  DateTime thirdDateTime[] = null;//������֤ʱ��
  int intPrpLdriverSerialNo[] = null;//��ʻԱSerialNo
  String strPrpLregistPhoneNumber = "" ;//��ĳ���ʻԱ��ϵ�绰
  String strPrpLdriverName = "" ; //��ĳ���ʻԱ����
  String strPrpLdriverLicenseNo = "";//��ĳ���ʻԱ֤����
  DateTime dateTime = null;
  String strPrpLregistDamageAddress = "";//���յص�
  String strFirstSiteFlag = "";//�Ƿ��һ�ֳ�
  String strFirstSite = "";//�Ƿ��һ�ֳ�
  long personDeathB = 0;//������������
  long personInjureB = 0;//������������
  long personDeathD1 = 0;//������Ա������
  long personInjureD1 = 0;//������Ա������
  String[] strKindCode        = new String[20];//���ִ���
  String[] strKindName        = new String[20];//��������
  //add by zhaolu 20060904 end
  
  
  
  //add begin by miaowenjun 20060405
  PrpLcheckLossDto prpLcheckLossDto = null;
  ArrayList prpLcheckLossList = new ArrayList();
  double lossFee = 0d;
  double lossFeeThird = 0d;
  //add end by miaowenjun 20060405
  double lossFeeC = 0d;
  //add begin by miaowenjun 20060327
  String strgetCheckDate        = "";//�鿱����
  String strchecker1              = "";//�鿱��
  String strchecker2              = "";//�鿱��2
  //add end by miaowenjun 20060327

  //���뷭�����

  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־

  //�����岿��

  //prpLRegistRPolicyNo = (String)request.getAttribute("prpLRegistRPolicyNo");
  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto����
  PrpLregistDto prpLregistDto = new PrpLregistDto();

  int intThirdPartyCount = 0;   //ThirdPartyDto����ļ�¼��



  int index = 0;

  RegistDto registDto = new RegistDto();
  registDto=(RegistDto)request.getAttribute("registDto");
  strPolicyNo = prpLregistDto.getPolicyNo();
  
  
  //add by zhaolu 20060904 start
  handleUnitCode = registDto.getPrpLregistDto().getHandleUnit();
  personDeathB = registDto.getPrpLregistDto().getPersonDeathB();
  personInjureB = registDto.getPrpLregistDto().getPersonInjureB();
  personDeathD1 = registDto.getPrpLregistDto().getPersonDeathD1();
  personInjureD1 = registDto.getPrpLregistDto().getPersonInjureD1();
  prpLdriverDtoList = registDto.getPrpLdriverDtoList();
  strPrpLregistDamageAddress = registDto.getPrpLregistDto().getDamageAddress();
  strFirstSiteFlag = "";
  //add by zhaolu 20060904 end
  
  strRegistNo = request.getParameter("RegistNo");

  //caopeng 11.29
  //add begin by zhuly 20051107 ���ձ����Ϣ
  //����ת��
  UICodeAction uiCodeAction = new UICodeAction();
  
  
  //�鿱��Ϣ
  UICheckAction uiCheckAction = new UICheckAction();
  CheckDto checkDto = uiCheckAction.findByPrimaryKey(strRegistNo);
  indemnityDutyCode = checkDto.getPrpLcheckDto().getIndemnityDuty();
  indemnityDuty = uiCodeAction.translateCodeCode("IndemnityDuty",indemnityDutyCode,true);
  handleUnit = uiCodeAction.translateCodeCode("HandleUnit",handleUnitCode,true);
  //add by zhaolu 20060904 start
  strFirstSiteFlag = checkDto.getPrpLcheckDto().getFirstSiteFlag();
  if("0".equals(strFirstSiteFlag))
     strFirstSite = "��";
  if("1".equals(strFirstSiteFlag))
     strFirstSite = "��";
  //add by  zhaolu 20060904 end
  prpLcheckLossList = checkDto.getPrpLcheckLossDtoList();    //add by miaowenjun 20060405
  System.out.println("----------------------------");
  System.out.println(registDto.getPrpLthirdPartyDtoList().size());
  System.out.println(prpLcheckLossList.size());
  System.out.println("---------------------------");
  PrpLcheckDto prpLcheckDto = checkDto.getPrpLcheckDto();
  if(checkDto.getPrpLcheckDto()!=null)
  {
    strchecker1 = prpLcheckDto.getChecker1();
    strchecker2 = prpLcheckDto.getChecker2();
    strgetCheckDate = prpLcheckDto.getCheckDate().getYear() + "��" + prpLcheckDto.getCheckDate().getMonth() + "��" + prpLcheckDto.getCheckDate().getDay() + "��";
    strCheckSite    = prpLcheckDto.getCheckSite();
    System.out.println("checkpoint"+strCheckSite);
    //caopeng 11.29
    strDamageAddress = strCheckSite;
    strPolicyNo = prpLcheckDto.getPolicyNo();
    //11.29
    strDamageCode   = prpLcheckDto.getDamageCode();
    strDamageClause = uiCodeAction.translateCodeCode("DamageCode",strDamageCode,true);
  }
  //��ñ�����Ϣ
  UIPolicyAction uiPolicyAction = new UIPolicyAction();
  PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(strPolicyNo);
  PrpCitemCarDto prpCitemCarDto = new PrpCitemCarDto();


  //��ü�ʻԱ��Ϣ
  //add by zhaolu 20060905 start
  if(prpLdriverDtoList != null)
  {
    strThirdPrpLregistPhoneNumber = new String[prpLdriverDtoList.size()];
    strThirdPrpLdriverName = new String[prpLdriverDtoList.size()];
    strThirdPrpLdriverLicenseNo = new String[prpLdriverDtoList.size()];
    intPrpLdriverSerialNo = new int[prpLdriverDtoList.size()];
    thirdDateTime = new DateTime[prpLdriverDtoList.size()];
    for(int i = 0;i < prpLdriverDtoList.size();i++)
  	{
  		prpLdriverDto = (PrpLdriverDto)prpLdriverDtoList.get(i);
  		intPrpLdriverSerialNo[i] = prpLdriverDto.getSerialNo();
  		if(intPrpLdriverSerialNo[i] == 1)
  		 {
  		    strPrpLdriverName = prpLdriverDto.getDriverName();
  		    strPrpLregistPhoneNumber = prpLdriverDto.getDriverSeaRoute();
  		    strPrpLdriverLicenseNo = prpLdriverDto.getDrivingLicenseNo();
  		    dateTime = prpLdriverDto.getReceiveLicenseDate();
  		 }
  		else{
  	      strThirdPrpLregistPhoneNumber[i] = prpLdriverDto.getDriverSeaRoute();
  			 	strThirdPrpLdriverName[i] = prpLdriverDto.getDriverName();
  			 	strThirdPrpLdriverLicenseNo[i] = prpLdriverDto.getDrivingLicenseNo();
  			 	thirdDateTime[i] = prpLdriverDto.getReceiveLicenseDate();
  		    }
  			
  	}
  }
  //add by zhaolu 20060905 end

  //*****�������ձ����Ϣ��PrpCitemCar*****
  int intItemCarCount = 0 ;//���������Ϣ��¼��
  intItemCarCount     = policyDto.getPrpCitemCarDtoList().size();
  System.out.println("����"+intItemCarCount+"�����������Ϣ");
  if(policyDto.getPrpCitemCarDtoList()!=null){
  for(index=0;index<intItemCarCount;index++)
  {
    prpCitemCarDto = (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(index);
    strUseNatureCode = prpCitemCarDto.getUseNatureCode();
    strUseNatureName = uiCodeAction.translateCodeCode("UseNature",strUseNatureCode,true);
    strRunAreaCode   = prpCitemCarDto.getRunAreaCode();
    strRunAreaName   = uiCodeAction.translateCodeCode("RunArea",strRunAreaCode,true);
  }
}
  //*****��������ʻԱ��ϵ��
  int intCarDriver  = 0 ;
  intCarDriver     = policyDto.getPrpCcarDriverDtoList().size();

  System.out.println("����"+intCarDriver+"����ʻԱ��Ϣ");
  PrpCcarDriverDto prpCcarDriverDto = new PrpCcarDriverDto();
  if(policyDto.getPrpCcarDriverDtoList()!=null){
  for(index=0;index<intCarDriver;index++)
  {
    prpCcarDriverDto = (PrpCcarDriverDto)policyDto.getPrpCcarDriverDtoList().get(index);
    strD1            = prpCcarDriverDto.getDriverName();
    strD2            = prpCcarDriverDto.getDrivingLicenseNo();
    strSexCode       = prpCcarDriverDto.getSex();
    strSexName       = uiCodeAction.translateCodeCode("SexCode",strSexCode,true);
  }
}
  //add end by zhuly 20051107
  prpLregistDto = registDto.getPrpLregistDto();
  strInsuredName =  prpLregistDto.getInsuredName();
  strDamageAddress = prpLregistDto.getDamageAddress();

  //strdamageStartDate	=String.valueOf(prpLregistDto.getDamageStartDate());
  strdamageStartDate = prpLregistDto.getDamageStartDate().getYear()
                       + " �� " + prpLregistDto.getDamageStartDate().getMonth()
                       + " �� " + prpLregistDto.getDamageStartDate().getDate()
                       + " �� ";
  if(prpLregistDto.getDamageStartHour() != null){
    if(!"0".equals(prpLregistDto.getDamageStartHour().substring(0,1))){
      strdamageStartDate += prpLregistDto.getDamageStartHour().substring(0,2) + " ʱ";
    }else{
      strdamageStartDate += prpLregistDto.getDamageStartHour().substring(1,2) + " ʱ";
    }
  }
  strdamageStartHour     =String.valueOf(prpLregistDto.getDamageStartHour());
  strdamageStartMinute   =String.valueOf(prpLregistDto.getDamageStartMinute());
 
    
	PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
	String tempContext = "";
	if (checkDto.getPrpLregistTextDtoList() != null) {
	        Iterator iterator = checkDto.getPrpLregistTextDtoList().iterator();
	        while (iterator.hasNext()) {
	                PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto) iterator.next();
	                tempContext = tempContext + prpLregistTextDtoTemp.getContext();
	        }
	}


/*
    UIPolicyAction   uiPolicyAction = new UIPolicyAction();

    PolicyDto   policyDto = new PolicyDto();
    PrpCitemCarDto prpCitemCarDto= new PrpCitemCarDto();
    ArrayList prpCitemCarDtoList  = new ArrayList();
    policyDto = uiPolicyAction.findByPrimaryKey(strPolicyNo);
    prpCitemCarDtoList = policyDto.getprpCitemCarDtoList();
    Iterator ititemkind = prpCitemCarDtoList.iterator();
     while(ititemkind.hasNext())
     {
          PrpCitemCarDto prpCitemCarDto = (PrpCitemCarDto)ititemkind.next();
          if(prpCitemCarDto.getItemNo()==1)
          {
                break;
          }
     }
*/
 
  //Modify by zhaolu 20060905 start
     strBrandNamethird = new String[registDto.getPrpLthirdPartyDtoList().size()];  
     strEngineNothird = new String[registDto.getPrpLthirdPartyDtoList().size()];  
     strRunDistancethird = new double[registDto.getPrpLthirdPartyDtoList().size()];   
     strUseYearsthird = new int[registDto.getPrpLthirdPartyDtoList().size()];   
     strLicenseNothird = new String[registDto.getPrpLthirdPartyDtoList().size()];   
     strFrameNothird = new String[registDto.getPrpLthirdPartyDtoList().size()];   

  for(index=0;index<registDto.getPrpLthirdPartyDtoList().size();index++)
  {
     prpLthirdPartyDto = (PrpLthirdPartyDto)registDto.getPrpLthirdPartyDtoList().get(index);
     //intCarSerialNo[index] = prpLthirdPartyDto.getSerialNo();
     if(index==0) 
        strClaimNo =  prpLthirdPartyDto.getClaimNo();
     //ȡ�ñ��ճ�����Ϣ
     //if(prpLthirdPartyDto.getInsureCarFlag().equals("1") && prpLcheckLossDto.getReferSerialNo() == 1)
     if(prpLthirdPartyDto.getInsureCarFlag().equals("1"))
     {
         strBrandName    = prpLthirdPartyDto.getBrandName();
         strEngineNo     = prpLthirdPartyDto.getEngineNo();
         strRunDistance  = prpLthirdPartyDto.getRunDistance();
         strUseYears     = prpLthirdPartyDto.getUseYears();
         strLicenseNo    = prpLthirdPartyDto.getLicenseNo();
         strFrameNo      = prpLthirdPartyDto.getFrameNo();
         //add by zhaolu 20060905 start
         //�õ����Ƶ�ɫ
         strLicenseColorCode = prpLthirdPartyDto.getLicenseColorCode();
         strLicenseColor = uiCodeAction.translateCodeCode("LicenseColor",strLicenseColorCode,true);
        //add by zhaolu 20060905 end
        
     }
     else
     {
     		
     		 
         strBrandNamethird[index]     = prpLthirdPartyDto.getBrandName();
         strEngineNothird[index]      = prpLthirdPartyDto.getEngineNo();
         strRunDistancethird[index]   = prpLthirdPartyDto.getRunDistance();
         strUseYearsthird[index]      = prpLthirdPartyDto.getUseYears();
         strLicenseNothird[index]     = prpLthirdPartyDto.getLicenseNo();
         strFrameNothird[index]       = prpLthirdPartyDto.getFrameNo();
         
         
     }

  }
//Modify by zhaolu 20060905 end
  //add by zhaolu 20060905 start
  //�Ʋ���ʧ
  if(prpLcheckLossList!=null)
  {
  for(int indexFee = 0; indexFee < prpLcheckLossList.size();indexFee++)
  {
  	 	 prpLcheckLossDto = (PrpLcheckLossDto)prpLcheckLossList.get(indexFee);
  	 	 if(prpLcheckLossDto.getReferSerialNo() == 1 && prpLcheckLossDto.getLossFeeType().equals("1"))
  	 	 {
  	 	 	 lossFee += prpLcheckLossDto.getLossFee();
  	 	 }
  	 	 
  	 	 if(prpLcheckLossDto.getLossFeeType().equals("1") && prpLcheckLossDto.getReferSerialNo() > 1)
  	 		{
  	 			lossFeeThird += prpLcheckLossDto.getLossFee();
  	 		}
  	 	
  	 	 
  }
  }
  //add by zhaolu 20060905 end

//add by zhaolu 20060905 start
//���������Ϣ
     PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();
     PrpCitemKindDto rPrpCitemKindDto = new PrpCitemKindDto();
     /**if(policyDto.getPrpCitemKindDtoList()!=null){
     intItemKindCount = policyDto.getPrpCitemKindDtoList().size();
     //add by zhaolu 20060902 start
      rPrpCitemKindDto = (PrpCitemKindDto)request.getAttribute("rPrpCitemKindDto");
     if( rPrpCitemKindDto != null )
      intItemKindCount = intItemKindCount + 1;
     //add by zhaolu 20060902 end
     for(index=0;index<intItemKindCount;index++){
      //add by zhaolu 20060902 start
      if( rPrpCitemKindDto != null ){
      if (index == intItemKindCount - 1 )
      {
           strKindCode[index] = rPrpCitemKindDto.getKindCode();
           strKindName[index] = rPrpCitemKindDto.getKindName();
           
      }
      }
      //add by zhaolu 20060902 end
      if(index != intItemKindCount - 1){
      		
       prpCitemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
       strKindCode[index] = prpCitemKindDto.getKindCode();
       strKindName[index] = prpCitemKindDto.getKindName();
       }
     
      }
     } */
     if(policyDto.getPrpCitemKindDtoList()!=null){
     		 intItemKindCount = policyDto.getPrpCitemKindDtoList().size();
     		 rPrpCitemKindDto = (PrpCitemKindDto)request.getAttribute("rPrpCitemKindDto");
     		 if(rPrpCitemKindDto != null)
     		 {
     		      prpLRegistRPolicyNo = (String)request.getAttribute("prpLRegistRPolicyNo");
     		 			intItemKindCount = intItemKindCount + 1;
     		 					for(index = 0;index < intItemKindCount;index++)
     		 					{
     		 						if (index == intItemKindCount - 1 )
     		 						{
     		 							strKindCode[index] = rPrpCitemKindDto.getKindCode();
                      strKindName[index] = rPrpCitemKindDto.getKindName();
     		 						}
     		 						if(index != intItemKindCount - 1){
     		 						prpCitemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
                    strKindCode[index] = prpCitemKindDto.getKindCode();
                    strKindName[index] = prpCitemKindDto.getKindName();
     		 						}
     		 					}
     		 }
     		else{
     				for(index = 0;index < intItemKindCount;index++)
     				{
     					      prpCitemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
                    strKindCode[index] = prpCitemKindDto.getKindCode();
                    strKindName[index] = prpCitemKindDto.getKindName();
     				}
     			}
     }
//add by zhaolu 20060905 end

//add by zhaolu 20060905 start
prpLcheckExtDtoList = checkDto.getPrpLcheckExtDtoList();
//add by zhaolu 20060905 end
 %>







