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
<%@ page import="java.util.*"%>

<%-- ����bean�ಿ�� --%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.util.*"%>
<%@page import="com.sinosoft.sysframework.common.util.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%>
<%@page import="com.sinosoft.claim.bl.facade.*"%>
<%@page import="com.sinosoft.utiall.dbsvr.DBPrpDcode"%>

<%
  //������������
  String strClaimNo         = "";   //������
  String strRegistNo        = "";   //������
  String strPolicyNo        = "";   //������
  String strEndorseNo = "";           //������
  UIEndorseAction uiEndorseAction = new UIEndorseAction();

  //������Ϣ
  DateTime dateStartDate         = null;   //��������
  String strStartDate            = "" ;//��������
  DateTime dateEndDate         = null;   //��������
  String strEndDate            = "" ;//��������
  
  //������Ϣ
  String strInsuredName        = "";   //��������
  String strDamageAddress      = "";   //���յص�
  String strDamageStartDate    = "";   //����ʱ��
  String strReportHour         = "";   //����Сʱ
  String strReceiverName       = "";   //�� �� ��
  String strOperatorCode       = "";   //����Ա����
  String strHandleUnit         = "";   //�Ӵ�����
 // String strInsuredName      = "";   //�Ӵ����ŵ绰
  //����������Ϣ
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
  System.out.println("-------------0---------------");
  String strD1="";                     //��ʻԱ����
  String strD2="";                     //��ʻ֤����
  String strD3="";                     //��ʻ֤��Ч��
  //add begin by zhuly 20051107
  String strUseNatureCode         = "" ;//ʹ�����ʴ���
  String strUseNatureName         = "" ;//ʹ������
  String strCheckSite             = "" ;//�鿱�ص�
  String strCheckDate             = "" ;//�鿱ʱ��
  String strChecker1              = "" ;//�鿱��
  String strDamageCode            = "" ;//����ԭ�����
  String strDamageClause          = "" ;//����ԭ��
  String strRunAreaCode           = "" ;//��ʻ�������
  String strRunAreaName           = "" ;//��ʻ����
  String strSexCode               = "" ;//��ʻԱ�Ա����
  String strSexName               = "" ;//��ʻԱ�Ա�����
  double strEstimateLoss          = 0.0 ;//������
  DateTime dateReportDate         = null;   //��������
  String strReportDate            = "" ;//��������
  String strLinkerName = "";       //��ϵ��
  String strPhoneNumber = "";       //��ϵ��ʽ
  String strLossName = "";       //���ձ��
  
  //add end by zhuly 20051107

  //���뷭�����

  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־

  //�����岿��


  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto����
  PrpLregistDto prpLregistDto = new PrpLregistDto();

  int intThirdPartyCount = 0;   //ThirdPartyDto����ļ�¼��


 System.out.println("<br>registDto=======================:");

  int index = 0;

  RegistDto registDto = new RegistDto();
  registDto=(RegistDto)request.getAttribute("registDto");
 System.out.println("<br>registDto=======================:"+registDto);
  prpLregistDto    = registDto.getPrpLregistDto();
  strPolicyNo = prpLregistDto.getPolicyNo();
  strRegistNo = prpLregistDto.getRegistNo();

//�õ�������
 PrpPheadDto prpPheadDto = new PrpPheadDto();
	Collection prpPheadDtoList = uiEndorseAction.findByPrpPheadConditions(" policyNo='" + strPolicyNo + "'");
	  if (prpPheadDtoList != null) {
           Iterator iterator = prpPheadDtoList.iterator();
            while (iterator.hasNext()) {
             prpPheadDto = (PrpPheadDto) iterator.next();
			 strEndorseNo = prpPheadDto.getEndorseNo();
			}
	    }

  //add begin by zhuly 20051107 ���ձ����Ϣ
  //����ת��
  UICodeAction uiCodeAction = new UICodeAction();
  //��ñ�����Ϣ
  UIPolicyAction uiPolicyAction = new UIPolicyAction();
  PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(strPolicyNo);
  PrpCmainDto prpCmainDto  = policyDto.getPrpCmainDto(); //�õ������������
  PrpCitemCarDto prpCitemCarDto = new PrpCitemCarDto();
  //*****�������ձ����Ϣ��PrpCitemCar*****
  int intItemCarCount = 0 ;//���������Ϣ��¼��
  intItemCarCount     = policyDto.getPrpCitemCarDtoList().size();
 /*
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
*/
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
  if(prpLregistDto!=null){
  strInsuredName      = prpLregistDto.getInsuredName();
  strLossName      =  prpLregistDto.getLossName();
  strDamageAddress    = prpLregistDto.getDamageAddress();
  strEstimateLoss = prpLregistDto.getEstimateLoss();

  strDamageStartDate  = prpLregistDto.getDamageStartDate().getYear()
                       + "��" + prpLregistDto.getDamageStartDate().getMonth()
                       + "��" + prpLregistDto.getDamageStartDate().getDate()
                       + "��";
  strReportHour       =  prpLregistDto.getReportHour().toString();
  strReceiverName     = prpLregistDto.getReceiverName();
  strHandleUnit       = prpLregistDto.getHandleUnit();
  strOperatorCode     = prpLregistDto.getOperatorCode();
  strLinkerName = prpLregistDto.getLinkerName();
  strPhoneNumber = prpLregistDto.getPhoneNumber();
  dateReportDate    = prpLregistDto.getReportDate();
  strReportDate     = dateReportDate.getYear()
                       + "��" + dateReportDate.getMonth()
                       + "��" + dateReportDate.getDate()
                       + "��";
  }
//������Ϣ
if(prpCmainDto!=null)
{
  dateStartDate    = prpCmainDto.getStartDate();
  strStartDate     = dateStartDate.getYear()
                       + "��" + dateStartDate.getMonth()
                       + "��" + dateStartDate.getDate()
                       + "��";
  dateEndDate    = prpCmainDto.getEndDate();
  strEndDate     = dateEndDate.getYear()
                       + "��" + dateEndDate.getMonth()
                       + "��" + dateEndDate.getDate()
                       + "��";

}

  //���ݲ���Ա�����ѯ����Ա���ڲ��ŵ���ϵ�绰
  PrpDcompanyDto     prpDcompanyDto     = null;   // ���Ŷ���     
  String phone = "";
  if(strOperatorCode.length()>0)
  {
  UICompanyAction    uiCompanyAction    = new UICompanyAction();   
  prpDcompanyDto = uiCompanyAction.findByPrimaryKey(strOperatorCode);      //�õ�����Ա���ڲ��ŵĶ���
	 if(prpDcompanyDto!=null) 
	 {
	  phone     = prpDcompanyDto.getPhoneNumber();   //���չ�˾�绰
	 }
  }
  
  //�鿱��Ϣ
  UICheckAction uiCheckAction = new UICheckAction();
  CheckDto checkDto = uiCheckAction.findByPrimaryKey(strRegistNo);
  PrpLcheckDto prpLcheckDto = checkDto.getPrpLcheckDto();
  if(checkDto.getPrpLcheckDto()!=null)
  {
    strCheckSite    = prpLcheckDto.getCheckSite();
    strCheckDate    = prpLcheckDto.getCheckDate().getYear()
                       + "��" + prpLcheckDto.getCheckDate().getMonth()
                       + "��" + prpLcheckDto.getCheckDate().getDate()
                       + "��";
    strChecker1     = prpLcheckDto.getChecker1();
    strDamageCode   = prpLcheckDto.getDamageCode();
    //strEstimateLoss = prpLcheckDto.getEstimateLoss();
    strDamageClause = uiCodeAction.translateCodeCode("DamageCode",strDamageCode,true);
  }
	PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
	String tempContext = "";
	if (checkDto.getPrpLregistTextDtoList() != null) {
	        Iterator iterator = checkDto.getPrpLregistTextDtoList().iterator();
	        while (iterator.hasNext()) {
	                PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto) iterator
	                                .next();
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
//zhulei leave:ȡ ��������� ����......
    String conditions = "";
    Collection collection = null;
    conditions = "RegistNo='" + strRegistNo + "' AND TextType='3'";
    BLPrpLregistTextFacade blPrpLregistTextFacade = new BLPrpLregistTextFacade();
    collection = blPrpLregistTextFacade.findByConditions(conditions);
    int i = 0;
    String strContext = "";      //�鿱����
    //String[] arrContext = "";      //�鿱����
    if(collection!=null){
      Iterator iterator1 = collection .iterator();
      //arrContext = new String[collection.size()];
      while (iterator1.hasNext()) {
        prpLregistTextDto = (PrpLregistTextDto) iterator1.next();
        //arrContext[i] = prpLRegistTextDto.getContext();
        strContext = strContext + prpLregistTextDto.getContext();
        i++;
      }
    }
%>

<script language="javascript">
  function loadForm()
  { 
    tdPolicyNo.innerHTML = '<%=strPolicyNo%>';
    tdRegistNo.innerHTML = '������ţ�'+'<%=strRegistNo%>';
    tdLossName.innerHTML = '<%=strLossName%>';
    tdInsuredName.innerHTML = '<%=strInsuredName%>';
    tdDamageAddress.innerHTML = '<%=strDamageAddress%>';
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>'+'&nbsp;'+'<%=strReportHour.substring(0,2)%>'+'ʱ';
   // tdReceiverName.innerHTML = '<%=strReceiverName%>' +'&nbsp;&nbsp;'+'<%=phone%>';
  //  tdHandleUnit.innerHTML = '<%=strHandleUnit%>';
    tdEndorseNo.innerHTML = '<%=strEndorseNo%>';
    tdDamageClause.innerHTML = '<%=strDamageClause%>';
    tdEstimateLoss.innerHTML = '<%=strEstimateLoss%>';
    tdReportDate.innerHTML = '<%=strReportDate%>';
    tdLinkerName.innerHTML = '<%=strLinkerName%>';
    tdPhoneNumber.innerHTML = '<%=strPhoneNumber%>';
    tdDate.innerHTML = '<%=strStartDate%>'+' �� '+'<%=strEndDate%>';

  
  }
</script>






