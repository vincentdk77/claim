<%--
****************************************************************************
* DESC       ��������������������Ͻ��ӵ�
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
<%@page import="java.util.ArrayList"%>

<%
  //������������
  String strRegistNo        = request.getParameter("RegistNo"); //������
  String strPolicyNo        = "";   //������
  String strInsuredName		= "";   //������������
  
  //add by coapeng start at 2005.12.2
  int index                 = 0;    //ѭ������
  int intSize               = 0;    //ArrayList�Ĵ�С
  int inttemp               = 0;    //ÿ��Ĳ�����
  String [] strTypeCode        ;    //��������
  String [] strTypeName        ;    //��������
  String strCollectFlag     = "";
  //add by caopeng end at 2005.12.2 
  
  //�����岿��                                             
  PrpLregistDto      prpLregistDto      = null;   //RegistDto����
  //add by coapeng start at 2005.12.2
  CertifyDto certifyDto =null;//CertifyDto����
  UICertifyAction uiCertifyAction = new UICertifyAction();
  ArrayList arrPrpLcertifyDirectDto = null;
  PrpLcertifyCollectDto   prpLcertifyCollectDto = null;
  //add by caopeng end at 2005.12.2
  
  //�õ�RegistDto����
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  
  //add by coapeng start at 2005.12.2
  //�õ�CertifyDto����
  certifyDto = uiCertifyAction.findByPrimaryKey(strRegistNo);
  //add by caopeng end at 2005.12.2
  
  //�õ�prpLregistDto����
  prpLregistDto       = registDto.getPrpLregistDto();
  strPolicyNo         = prpLregistDto.getPolicyNo();
  strInsuredName      = prpLregistDto.getInsuredName();
  
  //add by coapeng start at 2005.12.2
  if(certifyDto != null){
  	arrPrpLcertifyDirectDto = certifyDto.getPrpLcertifyDirectDtoList();
  	prpLcertifyCollectDto   = certifyDto.getPrpLcertifyCollectDto();
  	if(prpLcertifyCollectDto != null){
  	  strCollectFlag = prpLcertifyCollectDto.getCollectFlag();
  	}
  	if(arrPrpLcertifyDirectDto != null){
  		intSize = arrPrpLcertifyDirectDto.size();
  	}
  }
  UICodeAction uiCodeAction = new UICodeAction();
  if(intSize>0){
  	strTypeCode  = new String[intSize];
  	strTypeName  = new String[intSize];
  	for(index=0;index<intSize;index++){
  		PrpLcertifyDirectDto prpLcertifyDirectDto = (PrpLcertifyDirectDto)arrPrpLcertifyDirectDto.get(index);
  		strTypeCode[index] = prpLcertifyDirectDto.getTypeCode();
  		//strTypeName[index] = StringConvert.encode(prpLcertifyDirectDto.getTypeName());
  		strTypeName[index] = uiCodeAction.translateCodeCode("ImageType",strTypeCode[index],true);
  	}
  }else{
  	strTypeCode  = null;
  	strTypeName  = null;
  }
  //add by caopeng end at 2005.12.2
 %>

