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
<%@ page import="java.util.Date"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 

<%
  //������������
  String strClaimNo         = request.getParameter("ClaimNo"); //������
  String strRegistNo        = "";   //������
  String strPolicyNo        = "";   //������
  String strInsuredDate     = "";   //�����ڼ�
  String strDamageStartDate = "";   //����ʱ��
  String strDamageStartHour = "";   //����Сʱ
  String strInsureCarFlag   = "";   //�Ƿ�Ϊ����������
  double dblSumAmount1      = 0;    //���ս��    
  double dblSumAmount2      = 0;    //�����޶�    
  String strRiskCode        = "";   //���ִ���     
  String strKindCode        = "";   //�ձ����     
  String strBLName          = "";   //���乤������
  String strCalculateFlag   = "";   //�Ƿ���뱣��
  String strStartSiteName   = "";   //����������ʼ��ַ
  String strEndSiteName     = "";   //����������ֹ��ַ
  String strCaseNo          = "";   //�鵵��
  String strLossName   = "";  //���ձ��
  String strUserCode        = ((UserDto)request.getSession().getAttribute("user")).getUserCode(); 
  String strMessage         = "";  
  String strDamageName      = "";  //����ԭ��
  String strCancelReason    = "";
  String strTextType        = "";


  String comCName      = "";  //���չ�˾��������
  String addressCName  = "";  //���չ�˾��ַ
  String postCode      = "";  //���չ�˾�ʱ�
  String phoneNumber   = "";  //���չ�˾�绰
  String manager       = "";  //���չ�˾����
  String faxNumber     = "";  //���չ�˾����

  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־ 
    
  //�����岿��                                             
  PrpDcompanyDto     prpDcompanyDto     = null;   //��ӡ��֪ͨ��user���ڵĹ�˾                                          
  PrpCitemKindDto    prpItemKindDto     = null;   //������ItemKindDto����
  PrpLregistDto      prpLregistDto      = null;   //RegistDto����
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpCmainCargoDto   prpCmainCargoDto   = null;   //�����ձ�����Ϣ����
  
  int intClaimCount      = 0;   //ClaimDto����ļ�¼��
  int intItemKindCount   = 0;   //ItemKindDto����ļ�¼��
  int intThirdPartyCount = 0;   //ThirdPartyDto����ļ�¼��
  
  
  UICompanyAction    uiCompanyAction    = new UICompanyAction();   
  prpDcompanyDto = uiCompanyAction.findByPrimaryKey(strUserCode);      //�õ����չ�˾�Ķ���
 if(prpDcompanyDto!=null) 
 {
  comCName        = prpDcompanyDto.getComCName();      //���չ�˾��������
  addressCName    = prpDcompanyDto.getAddressCName();  //���չ�˾��ַ
  postCode        = prpDcompanyDto.getPostCode();      //���չ�˾�ʱ�
  phoneNumber     = prpDcompanyDto.getPhoneNumber();   //���չ�˾�绰
  manager         = prpDcompanyDto.getManager();       //���չ�˾������ϵ�ˣ�
  faxNumber       = prpDcompanyDto.getFaxNumber();     //���չ�˾����
 }

  
  int index = 0;
  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto����
  ClaimDto claimDto   = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  //�õ���Dto����
  prpCmainCargoDto    = policyDto.getPrpCmainCargoDto();
  
  UICodeAction uiCodeAction = new UICodeAction();
  //�õ�prpLclaimDto����
  prpLclaimDto   = claimDto.getPrpLclaimDto();
  strCaseNo      = prpLclaimDto.getCaseNo();
    System.out.println("prpLregistDto����");
  //�õ�������  
  strPolicyNo = prpLclaimDto.getPolicyNo(); 
  if(policyDto.getPrpCmainCargoDto()!=null)
  {
     strStartSiteName = prpCmainCargoDto.getStartSiteName();
     strEndSiteName   = prpCmainCargoDto.getEndSiteName();
     strBLName        = prpCmainCargoDto.getBLName();
  } 
  if(strStartSiteName.equals(""))
    strStartSiteName="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
  if(strEndSiteName.equals(""))
    strEndSiteName="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";         
  strDamageStartHour = prpLclaimDto.getDamageStartHour();
  if(strDamageStartHour.equals(""))
  {
     strDamageStartHour = "0" ;
  }
  else
  {
     strDamageStartHour = prpLclaimDto.getDamageStartHour().substring(0,2);
  }
  
  //�õ�prpLregistDto����
  prpLregistDto    = registDto.getPrpLregistDto();
  strRegistNo      = prpLregistDto.getRegistNo();
  strDamageName    = prpLregistDto.getDamageName();
  strLossName =     prpLregistDto.getLossName();//������
  System.out.println("prpLregistDto����");
  
  PrpLltextDto prpLltextDto = new PrpLltextDto();
  if(claimDto.getPrpLltextDtoList()!=null){
    for(index=0;index<claimDto.getPrpLltextDtoList().size();index++)
    {
      prpLltextDto = (PrpLltextDto)claimDto.getPrpLltextDtoList().get(index);
      strTextType = prpLltextDto.getTextType();
      if ( strTextType.equals("10"))
      {      
        strCancelReason = strCancelReason + StringConvert.encode(prpLltextDto.getContext()) ;
      }
    }    
  }
%>

<script language="javascript">
  function loadForm()
  { 
    //*****������Ϣ��PrpLregist*****
    tdCaseNo.innerHTML = '�鵵��:'+'<%=strCaseNo%>';
    tdPolicyNo.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getPolicyNo())%>';
    tdRegistNo.innerHTML = '������:'+'<%=strRegistNo%>';
    tdInsuredName.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
    tdDamageCause.innerHTML ='����ԭ��:'+'<br>'+ '<%=StringConvert.encode(prpLregistDto.getDamageName())%>';
    tdLossName.innerHTML = '<%=strLossName%>';
    tdCancelReason.innerHTML = '����/ע�����ɣ�'+'<br>'+'<%=strCancelReason%>';
<%     
   if((prpLclaimDto.getStartDate()+"").length()>0)
   strInsuredDate = "�� " + prpLclaimDto.getStartDate().getYear()
                     + "��" + prpLclaimDto.getStartDate().getMonth()
                     + "��" + prpLclaimDto.getStartDate().getDate()
                     + "����";
   if((prpLclaimDto.getEndDate()+"").length()>0)

      strInsuredDate =  strInsuredDate  + "�� " + prpLclaimDto.getEndDate().getYear()
                     + "��" + prpLclaimDto.getEndDate().getMonth()
                     + "��" + prpLclaimDto.getEndDate().getDate()
                     + "��ֹ";
%>                    
    tdInsuredDate.innerHTML = '<%=strInsuredDate%>';
    tdBLName.innerHTML = '<%=strBLName%>';
    tdSiteName.innerHTML = '��'+'<%=strStartSiteName%>'+'����'+'<%=strEndSiteName%>'+'ֹ';
<%
    //��������
    strCode = "";
    strName = "";
    strCode = StringConvert.encode(prpLclaimDto.getRiskCode());
    strName = uiCodeAction.translateRiskCode(strCode,isChinese);
%>  
    tdRiskName.innerHTML = '<%=strName%>';
    tdTitleName.innerHTML='<%=strName%>'+'����/ע������֪ͨ��';
    
<%    
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                        + " �� " + prpLclaimDto.getDamageStartDate().getMonth()
                        + " �� " + prpLclaimDto.getDamageStartDate().getDate()
                        + " ��" +prpLclaimDto.getDamageStartHour().substring(0,2)+"&nbsp;ʱ";
%>                    
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>';
    tdDamageAddress.innerHTML   = '<%=StringConvert.encode(prpLclaimDto.getDamageAddress())%>';
    
<%      
    //*****���������ϢPrpTitemKind*****
    dblSumAmount1 = 0;
    dblSumAmount2 = 0;
    
  if(policyDto.getPrpCitemKindDtoList()!=null){
    for(index=0;index<intItemKindCount;index++)
    {
      prpItemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
      strCalculateFlag = prpItemKindDto.getCalculateFlag(); 
      if( strCalculateFlag.equals("Y") )  
      {
        dblSumAmount1 += prpItemKindDto.getAmount();
      }
      if( strCalculateFlag.equals("N") ) 
      {
        dblSumAmount2 += prpItemKindDto.getAmount();  
      }      
    }
  }   
%>
    tdSumAmount1.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount1)%>';
    //tdSumAmount2.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount2)%>';    
  }
</script>
 