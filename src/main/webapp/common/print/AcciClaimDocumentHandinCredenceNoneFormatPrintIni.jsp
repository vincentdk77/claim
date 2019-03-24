<%--
****************************************************************************
* DESC       �������������ļ�����ƾ֤��ʼ��
* AUTHOR     ��caopeng
* CREATEDATE ��2005-12-13
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
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
  String strClaimNo         = request.getParameter("ClaimNo");   //������
  String strRegistNo        = "";   //������
  String strPolicyNo        = "";   //������
  String strInsuredName		= "";   //������������
  String strAcciName        = "";   //����������
  
  int index                 = 0;    //ѭ������
  int intSize               = 0;    //ArrayList�Ĵ�С
  int inttemp               = 0;    //������
  String [] strTypeCode        ;    //��������
  String [] strTypeName        ;    //��������
  
  //�����岿��                                             
  PrpLregistDto      prpLregistDto      = null;   //RegistDto����
  CertifyDto         certifyDto         = null;   //CertifyDto����
  ClaimDto           claimDto           = null;   //ClaimDto����
  
  UICertifyAction uiCertifyAction = new UICertifyAction();
  ArrayList arrPrpLcertifyDirectDto = null;
  ArrayList arrPrpLacciPersonDto    = null;
  
  //�õ�RegistDto����
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  
  //�õ�CertifyDto����
  UICodeAction uiCodeAction = new UICodeAction();
  strRegistNo = uiCodeAction.translateBusinessCode(strClaimNo, false);
  certifyDto = uiCertifyAction.findByPrimaryKey(strRegistNo);
  
  //�õ�prpLregistDto����
  if(registDto != null){
    prpLregistDto       = registDto.getPrpLregistDto();
  }
  
  //�õ�claimDto����
  claimDto =(ClaimDto)request.getAttribute("claimDto");
  
  if(prpLregistDto != null){
    strPolicyNo         = prpLregistDto.getPolicyNo();
    strInsuredName      = prpLregistDto.getInsuredName();
  }
  
  if(claimDto != null){
    arrPrpLacciPersonDto = claimDto.getPrpLacciPersonDtoList();
    if(arrPrpLacciPersonDto != null){
      intSize = arrPrpLacciPersonDto.size();
      for(index=0;index<intSize;index++){
        PrpLacciPersonDto prpLacciPersonDto = (PrpLacciPersonDto)arrPrpLacciPersonDto.get(index);
        if(prpLacciPersonDto.getFlag()!=null && prpLacciPersonDto.getFlag().equals("1")){
          strAcciName = prpLacciPersonDto.getAcciName();
          
        }
      }
      intSize = 0;
    }
    
  }

  if(certifyDto != null){
  	arrPrpLcertifyDirectDto = certifyDto.getPrpLcertifyDirectDtoList();
  	if(arrPrpLcertifyDirectDto != null){
  		intSize = arrPrpLcertifyDirectDto.size();
  		System.out.println("checkpoint"+intSize);
  	}
  }
  
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
 %>



<script language="javascript">

function loadForm(){

  spPolicyNo.innerHTML = '<%=strPolicyNo%>';

  spAcciName.innerHTML = '<%=strAcciName%>';
  <%for(index = 0;index < 30;index++){
      if(index<intSize && strTypeCode[index].substring(0,1).equals("Y") && !strTypeCode[index].equals("Y24")){%>
  tdTypeName<%=index+1%>.innerHTML = '&nbsp;'+'<%=index+1%>'+'&nbsp;'+'<%=strTypeName[index]%>';
  <%  }else{%>
  tdTypeName<%=index+1%>.innerHTML = '';
      <%}}%>
  spIntSize.innerHTML = '<%=intSize%>';

}

</script>