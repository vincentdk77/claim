<%@page pageEncoding="GBK"%>
<%--
****************************************************************************
* DESC       ���������������ղ鿱�����ӡ��ʼ��
* AUTHOR     ��liubvo
* CREATEDATE ��2005-11-15
* MODIFYLIST ��   Name       Date            Reason/Contents
--------------------------------------------------------------------------
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
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%
  //������������
  String strClaimNo         = "";   //������
  String strRegistNo        = "";   //������
  String strPolicyNo        = "";   //������
  String strChecker         = "";   //�鿱Ա
  DateTime checkDate        = null; //�鿱ʱ��    add by miaowenjun 20060404  

  //����������Ϣ
  String strInsuredName	    ="";
  String strDamageAddress   ="";
  String strdamageStartDate	="";
  String strdamageStartHour     ="";
  String strdamageStartMinute   ="";

  String strBrandName       = "";   //�����ͺ�
  String strEngineNo        = "";   //��������
  double strRunDistance     = 0.0d;   //��������ʻ������
  int    strUseYears        = 0;   //����ʵ��ʹ������
  String strLicenseNo       = "";   //���ƺ�
  String strFrameNo         = "";   //���ܺ�

  //������������Ϣ
  String strBrandNamethird        = "";   //�����ͺ�
  String strEngineNothird         = "";   //��������
  double strRunDistancethird      = 0.0d; //��������ʻ������
  int    strUseYearsthird         = 0;    //����ʵ��ʹ������
  String strLicenseNothird        = "";   //���ƺ�
  String strFrameNothird          = "";   //���ܺ�
  String strD1                    = "";   //��ʻԱ����
  String strD2                    = "";   //��ʻ֤����
  String strD3                    = "";   //��ʻ֤��Ч��
  String strUseNatureCode         = "" ;  //ʹ�����ʴ���
  String strUseNatureName         = "" ;  //ʹ������
  String strCheckSite             = "" ;  //�鿱�ص�
  String strSexCode               = "" ;  //��ʻԱ�Ա����
  String strSexName               = "" ;  //��ʻԱ�Ա�����
  String strMarriageCode          = "" ;  //������
  String strMarriageName          = "" ;  //�������
  String strBusinessSource        = "" ;  //��ҵ���ʴ���
  String strBusinessName          = "" ;  //��ҵ��������
  String strSafeDevice            = "" ;  //��ȫ�豸
  String strParkSite              = "" ;  //�̶�ͣ�ŵص�
  //���뷭�����

  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־

  //�����岿��

  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto����
  PrpLregistDto prpLregistDto = new PrpLregistDto();
  int intThirdPartyCount = 0;   //ThirdPartyDto����ļ�¼��
  

  int index = 0;

  RegistDto registDto = new RegistDto();
  registDto=(RegistDto)request.getAttribute("registDto");
  

  
  prpLregistDto = registDto.getPrpLregistDto();
  strInsuredName  =  prpLregistDto.getInsuredName();
  strPolicyNo = prpLregistDto.getPolicyNo();
  strRegistNo = prpLregistDto.getRegistNo();

  //����ת��
  UICodeAction uiCodeAction = new UICodeAction();
  //��ñ�����Ϣ
  UIPolicyAction uiPolicyAction = new UIPolicyAction();
  PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(strPolicyNo);
  PrpCitemCarDto prpCitemCarDto = new PrpCitemCarDto();

  int intItemCarCount = 0 ;//���������Ϣ��¼��
  intItemCarCount     = policyDto.getPrpCitemCarDtoList().size();
  if(policyDto.getPrpCitemCarDtoList()!=null){
  //*****�������ձ����Ϣ��PrpCitemCar*****
  for(index=0;index<intItemCarCount;index++)
  {
    prpCitemCarDto = (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(index);
    strUseNatureCode = prpCitemCarDto.getUseNatureCode();
    strUseNatureName = uiCodeAction.translateCodeCode("UseNature",strUseNatureCode,true);
    strSafeDevice    += uiCodeAction.translateCodeCode("SafeDevice",prpCitemCarDto.getSafeDevice(),true);
    if(prpCitemCarDto.getParkSite().equals("1")||"".equals(prpCitemCarDto.getParkSite()))
    {
        strParkSite =  " �� ";
    }
    if(prpCitemCarDto.getParkSite().equals("2")||prpCitemCarDto.getParkSite().equals("3")||prpCitemCarDto.getParkSite().equals("4"))
    {
        strParkSite =  " �� ";
    }
  }
}

  //��ò鿱��Ϣ
  UICheckAction uiCheckAction  = new UICheckAction();
  CheckDto checkDto = uiCheckAction.findByPrimaryKey(strRegistNo);
  PrpLcheckDto prpLcheckDto = checkDto.getPrpLcheckDto();
  if(checkDto.getPrpLcheckDto()!=null)
  {
    strCheckSite = prpLcheckDto.getCheckSite();
    strChecker   = prpLcheckDto.getChecker1();
    checkDate    = prpLcheckDto.getCheckDate();
  }
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

  for(index=0;index<registDto.getPrpLthirdPartyDtoList().size();index++)
  {
     prpLthirdPartyDto = (PrpLthirdPartyDto)registDto.getPrpLthirdPartyDtoList().get(index);
     if(index==0)
        strClaimNo =  prpLthirdPartyDto.getClaimNo();
     //ȡ�ñ��ճ�����Ϣ
     if(prpLthirdPartyDto.getInsureCarFlag().equals("1"))
     {
         strBrandName    = prpLthirdPartyDto.getBrandName();
         strEngineNo     = prpLthirdPartyDto.getEngineNo();
         strRunDistance  = prpLthirdPartyDto.getRunDistance();
         strUseYears     = prpLthirdPartyDto.getUseYears();
         strLicenseNo    = prpLthirdPartyDto.getLicenseNo();
         strFrameNo      = prpLthirdPartyDto.getFrameNo();
     }
     else
     {
         strBrandNamethird     = prpLthirdPartyDto.getBrandName();
         strEngineNothird      = prpLthirdPartyDto.getEngineNo();
         strRunDistancethird   = prpLthirdPartyDto.getRunDistance();
         strUseYearsthird      = prpLthirdPartyDto.getUseYears();
         strLicenseNothird     = prpLthirdPartyDto.getLicenseNo();
         strFrameNothird       = prpLthirdPartyDto.getFrameNo();
     }

  }
    //*****��������ʻԱ��ϵ��
  int intCarDriver  = 0 ;
  intCarDriver     = policyDto.getPrpCcarDriverDtoList().size();

  PrpCcarDriverDto prpCcarDriverDto = new PrpCcarDriverDto();
  //caopeng 11.30
  UIClaimAction uiClaimAction = new UIClaimAction();
  ClaimDto claimDto = uiClaimAction.findByPrimaryKey(strClaimNo);
  ArrayList arrPrpLdriverDto = null;
  PrpLdriverDto prpLdriverDto = null;
  if(claimDto != null){
  	arrPrpLdriverDto =claimDto.getPrpLdriverDtoList();
  	if(arrPrpLdriverDto != null){
  		for(index=0;index<arrPrpLdriverDto.size();index++){
  			prpLdriverDto     = (PrpLdriverDto)claimDto.getPrpLdriverDtoList().get(index);
  			strD1             = prpLdriverDto.getDriverName();
    		strD2             = prpLdriverDto.getDrivingLicenseNo();
    		strSexCode        = prpLdriverDto.getDriverSex();
    		strSexName        = uiCodeAction.translateCodeCode("SexCode",strSexCode,true);
  		}
  	}
  }
  
/*  if(policyDto.getPrpCcarDriverDtoList()!=null){
  for(index=0;index<intCarDriver;index++)
  {
    prpCcarDriverDto  = (PrpCcarDriverDto)policyDto.getPrpCcarDriverDtoList().get(index);
    strD1             = prpCcarDriverDto.getDriverName();
    strD2             = prpCcarDriverDto.getDrivingLicenseNo();
    strSexCode        = prpCcarDriverDto.getSex();
    strSexName        = uiCodeAction.translateCodeCode("SexCode",strSexCode,true);
    strMarriageCode   = prpCcarDriverDto.getMarriage();
    strMarriageName   = uiCodeAction.translateCodeCode("Marriage",strMarriageCode,true);
    strBusinessSource = prpCcarDriverDto.getBusinessSource();//��ҵ������
    strBusinessName   = uiCodeAction.translateCodeCode("BusinessSource",strBusinessSource,true);
  }
}*/
  //caopeng 11.30
  strDamageAddress       = prpLregistDto.getDamageAddress();
  strdamageStartDate	   = prpLregistDto.getDamageStartDate().getYear()+" �� "
                         + prpLregistDto.getDamageStartDate().getMonth()+" �� "
                         + prpLregistDto.getDamageStartDate().getDate()+" �� "
                         + prpLregistDto.getDamageStartHour().substring(0,2)+" ʱ ";
 %>







