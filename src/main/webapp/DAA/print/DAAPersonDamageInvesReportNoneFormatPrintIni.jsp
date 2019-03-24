<%--
****************************************************************************
* DESC       �������������������������鱨���ӡ��ʼ��
* AUTHOR     ��caopeng
* CREATEDATE ��2005-12-07
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
<%@page import="java.util.Iterator"%>

<%
  //������������
  String strClaimNo         = "";   //������
  String strRegistNo        = "";   //������
  String strPolicyNo        = "";   //������

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
  double strRunDistancethird      = 0.0d;   //��������ʻ������
  int    strUseYearsthird         = 0;   //����ʵ��ʹ������
  String strLicenseNothird        = "";   //���ƺ�
  String strFrameNothird          = "";   //���ܺ�
  //��Ա����
  String strReferKind             = "";//�ձ����
  String strReferKindName         = "";//�ձ�����
  String strD1                    = "";//��Ա����
  String strD2                    = "";//��Աְҵ
  String strD3                    = "";//��Ա����
  String strSexCode               = "" ;//��Ա�Ա����
  String strSexName               = "" ;//��Ա�Ա�����
  String strWoundRemark           = "" ;//��Ա��������
  String strHospital              = "" ;//ʩ��ҽԺ 
  
  String strCheckSite             = "" ;//�鿱�ص�
  String strDamageCode            = "" ;//����ԭ�����
  String strDamageClause          = "" ;//����ԭ��
  String strDamageTypeCode        = "" ;//�¹����ʹ���
  String strDamageTypeName        = "" ;//�¹�����˵��



  //���뷭�����

  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־

  //�����岿��


  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto����
  PrpLregistDto prpLregistDto = new PrpLregistDto();
  PrpLpersonTraceDto prpLpersonTraceDto = new PrpLpersonTraceDto();

  int intThirdPartyCount = 0;   //ThirdPartyDto����ļ�¼��



  int index = 0;
  int intTemp = 0;
  
  RegistDto registDto = new RegistDto();
  registDto=(RegistDto)request.getAttribute("registDto");
  strPolicyNo = prpLregistDto.getPolicyNo();

  strRegistNo = request.getParameter("RegistNo");



  //����ת��
  UICodeAction uiCodeAction = new UICodeAction();
  
  
  //�鿱��Ϣ
  UICheckAction uiCheckAction = new UICheckAction();
  CheckDto checkDto = uiCheckAction.findByPrimaryKey(strRegistNo);
  PrpLcheckDto prpLcheckDto = checkDto.getPrpLcheckDto();
  if(checkDto.getPrpLcheckDto()!=null)
  {
    strCheckSite    = prpLcheckDto.getCheckSite();
    System.out.println("checkpoint"+strCheckSite);

    strDamageAddress = strCheckSite;
    strPolicyNo = prpLcheckDto.getPolicyNo();

    strDamageCode   = prpLcheckDto.getDamageCode();
    strDamageClause = uiCodeAction.translateCodeCode("DamageCode",strDamageCode,true);
    strDamageTypeCode = prpLcheckDto.getDamageTypeCode();
    strDamageTypeName = uiCodeAction.translateCodeCode("DamageTypeCode",strDamageTypeCode,true);
  }
  //��ñ�����Ϣ
  UIPolicyAction uiPolicyAction = new UIPolicyAction();
  PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(strPolicyNo);
  PrpCitemCarDto prpCitemCarDto = new PrpCitemCarDto();

  

  //*****��Ա��Ϣ
 
  int intPersonTrace = 0;
  if(registDto.getPrpLpersonTraceDtoList() != null){
  	intPersonTrace = registDto.getPrpLpersonTraceDtoList().size();
  	for(index=0;index<intPersonTrace;index++){
  		prpLpersonTraceDto = (PrpLpersonTraceDto)registDto.getPrpLpersonTraceDtoList().get(index);
  		strReferKind       = prpLpersonTraceDto.getReferKind();
  		strReferKindName   = uiCodeAction.translateKindCode("0501",strReferKind,true);
  		strD1              = prpLpersonTraceDto.getPersonName();
  		strD2              = prpLpersonTraceDto.getJobName();
  		strD3              = String.valueOf(prpLpersonTraceDto.getPersonAge());
  		strSexCode         = prpLpersonTraceDto.getPersonSex();
  		strSexName         = uiCodeAction.translateCodeCode("SexCode",strSexCode,true);
  		strWoundRemark     = prpLpersonTraceDto.getWoundRemark();
  		strHospital        = prpLpersonTraceDto.getHospital();
  	}
  }

  
  prpLregistDto = registDto.getPrpLregistDto();
  strInsuredName =  prpLregistDto.getInsuredName();
  strDamageAddress = prpLregistDto.getDamageAddress();

  strdamageStartDate	=String.valueOf(prpLregistDto.getDamageStartDate());
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

 %>