<%--
****************************************************************************
* DESC       ��������������������֪
* AUTHOR     ��caopeng
* CREATEDATE ��2005-12-06
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
  
  int index                 = 0;    //ѭ������
  int intSize               = 0;    //ArrayList�Ĵ�С
  int inttemp               = 0;    //ÿ��Ĳ�����
  String [] strTypeCode        ;    //��������
  String [] strTypeName        ;    //��������

  
  //�����岿��                                             
  PrpLregistDto      prpLregistDto      = null;   //RegistDto����

  CertifyDto certifyDto =null;//CertifyDto����
  UICertifyAction uiCertifyAction = new UICertifyAction();
  ArrayList arrPrpLcertifyDirectDto = null;

  
  //�õ�RegistDto����
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  

  //�õ�CertifyDto����
  certifyDto = uiCertifyAction.findByPrimaryKey(strRegistNo);

  
  //�õ�prpLregistDto����
  prpLregistDto       = registDto.getPrpLregistDto();
  strPolicyNo         = prpLregistDto.getPolicyNo();
  strInsuredName      = prpLregistDto.getInsuredName();
  

  /*if(certifyDto != null){
  	arrPrpLcertifyDirectDto = certifyDto.getPrpLcertifyDirectDtoList();
  	if(arrPrpLcertifyDirectDto != null){
  		intSize = arrPrpLcertifyDirectDto.size();
  	}
  }
  if(intSize>0){
  	strTypeCode  = new String[intSize];
  	strTypeName  = new String[intSize];
  	for(index=0;index<intSize;index++){
  		PrpLcertifyDirectDto prpLcertifyDirectDto = (PrpLcertifyDirectDto)arrPrpLcertifyDirectDto.get(index);
  		strTypeCode[index] = prpLcertifyDirectDto.getTypeCode();
  		strTypeName[index] = StringConvert.encode(prpLcertifyDirectDto.getTypeName());
  	}
  }else{
  	strTypeCode  = null;
  	strTypeName  = null;
  }*/
  
 %>

