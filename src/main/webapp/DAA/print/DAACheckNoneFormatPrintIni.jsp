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

<%
  //������������
  String strClaimNo         = "";   //������
  String strRegistNo        = "";   //������
  String strPolicyNo        = "";   //������
  
  //����������Ϣ
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
  strPolicyNo = prpLregistDto.getPolicyNo();
  strRegistNo = prpLregistDto.getRegistNo();
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
  
  
  
  
  

   
  