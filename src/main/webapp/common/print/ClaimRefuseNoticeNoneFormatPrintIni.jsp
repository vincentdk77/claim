<%--
****************************************************************************
* DESC       �������������ս᰸�߸桢ע��֪ͨ���ӡ��ʼ��
* AUTHOR     ��zhulianyu
* CREATEDATE ��2005-11-14
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%-- ����bean�ಿ�� --%>
<%@page import="java.text.*"%> 
<%@ page import="java.util.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 
<%@page import="com.sinosoft.prpall.blsvr.lp.BLPrpLclaimLoss"%>
<%@page import="com.sinosoft.prpall.schema.PrpLclaimLossSchema"%>
<%@page import="com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade"%>

<%
  //������������
  String strClaimNo         = request.getParameter("ClaimNo"); //������
  String strRegistNo        = "";   //������
  String strInsuredDate     = "";   //�����ڼ�
  String strDamageStartDate = "";   //����ʱ��
  Double sumAmount          = 0.0;  // ������ 
  String strCancelReason    = "";
  String strTextType        = "";
  String strDamageProcess   = "";  // ���վ���
  String strComCode    = "";
  String comCName      = "";  //���չ�˾��������
  String addressCName  = "";  //���չ�˾��ַ
  String postCode      = "";  //���չ�˾�ʱ�
  String phoneNumber   = "";  //���չ�˾�绰
  String comCName2      = "";  //���չ�˾��������
  String addressCName2  = "";  //���չ�˾��ַ
  String postCode2      = "";  //���չ�˾�ʱ�
  String phoneNumber2   = "";  //���չ�˾�绰

  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־ 
    
  //�����岿��                                             
  PrpDcompanyDto     prpDcompanyDto     = null;   //��ӡ��֪ͨ��user���ڵĹ�˾                                          
  PrpLregistDto      prpLregistDto      = null;   //RegistDto����
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
 
  int index = 0;
  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto����
  ClaimDto claimDto   = (ClaimDto)request.getAttribute("claimDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  UICodeAction uiCodeAction = new UICodeAction();
  
  //�õ�prpLclaimDto����
  prpLclaimDto   = claimDto.getPrpLclaimDto();
  
  // �õ���˾��Ϣ
  strComCode = prpLclaimDto.getComCode();  // ҵ���������
  UICompanyAction    uiCompanyAction    = new UICompanyAction();   
  prpDcompanyDto = uiCompanyAction.findByPrimaryKey(strComCode);  
  if(prpDcompanyDto!=null) 
  {
  	comCName        = prpDcompanyDto.getComCName();      //���չ�˾��������
  	addressCName    = prpDcompanyDto.getAddressCName();  //���չ�˾��ַ
  	postCode        = prpDcompanyDto.getPostCode();      //���չ�˾�ʱ�
  	phoneNumber     = prpDcompanyDto.getPhoneNumber();   //���չ�˾�绰
  	comCName2        = prpDcompanyDto.getComCName();      //���չ�˾��������
  	addressCName2    = prpDcompanyDto.getAddressCName();  //���չ�˾��ַ
  	postCode2        = prpDcompanyDto.getPostCode();      //���չ�˾�ʱ�
  	phoneNumber2     = prpDcompanyDto.getPhoneNumber();   //���չ�˾�绰
  }
  
  //�õ�prpLregistDto����
  prpLregistDto    = registDto.getPrpLregistDto();
  strRegistNo      = prpLregistDto.getRegistNo();
  
  //��ó��վ���,�ӱ�����Ϣ����ȡ,������ҳ���ϵĳ���ժҪ
  PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
  if(registDto.getPrpLregistTextDtoList()!=null){
    for(index=0;index<registDto.getPrpLregistTextDtoList().size();index++)
    {
    	prpLregistTextDto = (PrpLregistTextDto)registDto.getPrpLregistTextDtoList().get(index);
        strTextType = prpLregistTextDto.getTextType(); 
        if ( strTextType.equals("1"))  // ����ժҪ
        {      
        	strDamageProcess = strDamageProcess + StringConvert.encode(prpLregistTextDto.getContext()) ;
        }
    }    
  }
  
  // ��þ�������,��������Ϣ��ȡ
  PrpLltextDto prpLltextDto = new PrpLltextDto();
  if(claimDto.getPrpLltextDtoList()!=null){
    for(index=0;index<claimDto.getPrpLltextDtoList().size();index++)
    {
      prpLltextDto = (PrpLltextDto)claimDto.getPrpLltextDtoList().get(index);
      strTextType = prpLltextDto.getTextType();
      // ��������
      if ( strTextType.equals("10"))
      {      
        strCancelReason = strCancelReason + StringConvert.encode(prpLltextDto.getContext()) ;
      }
    }    
  }
  
  //ȡ������
  sumAmount = prpLregistDto.getEstimateLoss();
%>

<script language="javascript">
  function loadForm()
  { 
    tdPolicyNo.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getPolicyNo())%>';
    tdPolicyNo2.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getPolicyNo())%>';
    tdRegistNo.innerHTML = '<%=strRegistNo%>';
    tdRegistNo2.innerHTML = '<%=strRegistNo%>';
    tdInsuredName.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
    tdInsuredName2.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
    tdDamageCause.innerHTML ='<%=StringConvert.encode(prpLregistDto.getDamageName())%>';
    tdDamageCause2.innerHTML ='<%=StringConvert.encode(prpLregistDto.getDamageName())%>';
    tdCancelReason.innerHTML = '���⣨ע��������: </br>&nbsp;&nbsp;&nbsp;&nbsp;' + '<%=strCancelReason%>';
    tdCancelReason2.innerHTML = '���⣨ע��������: </br>&nbsp;&nbsp;&nbsp;&nbsp;' + '<%=strCancelReason%>';
    tdDamageProcess.innerHTML = '���վ���: </br>&nbsp;&nbsp;&nbsp;&nbsp;' + '<%=strDamageProcess%>';
    tdDamageProcess2.innerHTML = '���վ���: </br>&nbsp;&nbsp;&nbsp;&nbsp;' + '<%=strDamageProcess%>';
<%     
   if((prpLclaimDto.getStartDate()+"").length()>0)
   strInsuredDate = "�� " + prpLclaimDto.getStartDate().getYear()
                     + " �� " + prpLclaimDto.getStartDate().getMonth()
                     + " �� " + prpLclaimDto.getStartDate().getDate()
                     + " �� " + prpLclaimDto.getEndHour()
                     + " ʱ��";
   if((prpLclaimDto.getEndDate()+"").length()>0)

      strInsuredDate =  strInsuredDate  + "</br>�� " + prpLclaimDto.getEndDate().getYear()
                     + " �� " + prpLclaimDto.getEndDate().getMonth()
                     + " �� " + prpLclaimDto.getEndDate().getDate()
                     + " �� " + prpLclaimDto.getEndHour()
                     + " ʱֹ";
%>                    
    tdInsuredDate.innerHTML = '<%=strInsuredDate%>';
    tdInsuredDate2.innerHTML = '<%=strInsuredDate%>';
<%
    //��������
    strCode = "";
    strName = "";
    strCode = StringConvert.encode(prpLclaimDto.getRiskCode());
    strName = uiCodeAction.translateRiskCode(strCode,isChinese);
%>  
    tdTitleName.innerHTML='<%=strName%>'+'���⣨ע��������֪ͨ��';
    tdTitleName2.innerHTML='<%=strName%>'+'���⣨ע��������֪ͨ��';
    
<%  // ����ʱ��  
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                        + " �� " + prpLclaimDto.getDamageStartDate().getMonth()
                        + " �� " + prpLclaimDto.getDamageStartDate().getDate()
                        + " �� " + prpLclaimDto.getDamageStartHour().substring(0,2)+" ʱ";
%>                    
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>';
    tdDamageStartDate2.innerHTML = '<%=strDamageStartDate%>';
    tdDamageAddress.innerHTML   = '<%=StringConvert.encode(prpLclaimDto.getDamageAddress())%>';
    tdDamageAddress2.innerHTML   = '<%=StringConvert.encode(prpLclaimDto.getDamageAddress())%>';
    
    // ������
    tdSumAmount.innerHTML = '<%=new DecimalFormat("#,##0.00").format(sumAmount)%>' + ' Ԫ';
    tdSumAmount2.innerHTML = '<%=new DecimalFormat("#,##0.00").format(sumAmount)%>' + ' Ԫ';
   
  }
</script>
 