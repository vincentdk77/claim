<%--
****************************************************************************
* DESC       �������������ս᰸�߸桢ע��֪ͨ���ӡ��ʼ��
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

<%
  //������������
  String strClaimNo         = request.getParameter("ClaimNo"); //������
  String strPolicyNo        = "";   //������
  String strInsuredDate     = "";   //�����ڼ�
  String strDamageStartDate = "";   //����ʱ��
  String strInsureCarFlag   = "";   //�Ƿ�Ϊ����������
  double dblSumAmount1      = 0;    //���ս��    
  double dblSumAmount2      = 0;    //�����޶�    
  String strRiskCode        = "";   //���ִ���     
  String strKindCode        = "";   //�ձ����     
  String strCalculateFlag   = "";   //�Ƿ���뱣��
  String strUserCode        = ((UserDto)request.getSession().getAttribute("user")).getUserCode(); 
  String strMessage         = "";  
  String strCancelReason    = "";   //����ע��String strCancelReason    = "";   //����ע��ԭ��
  String strTextType        = "";

  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
  //add by miaowenjun 20060405
  String strComCode = "";
  String strCompanyAdd = "";
  String strPostCode = "";
  PrpDcompanyDto prpDcompanyDto = null;
  UICompanyAction uiCompanyAction = new UICompanyAction();
  //add end by miaowenjun 20060405  
    
  //�����岿��                                             
  PrpCitemKindDto    prpItemKindDto     = null;   //������ItemKindDto����
  PrpLregistDto      prpLregistDto      = null;   //RegistDto����
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto����
  PrpLltextDto       prpLltextDto       = null;   //PrpLltextDto����
  
  int intClaimCount      = 0;   //ClaimDto����ļ�¼��
  int intItemKindCount   = 0;   //ItemKindDto����ļ�¼��
  int intThirdPartyCount = 0;   //ThirdPartyDto����ļ�¼��
  int intLtextCount      = 0;   //PrpLltextDto����ļ�¼��
  int intLtextCountTmp   = 0;
  int index = 0;
  
  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto����
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  
  UICodeAction uiCodeAction = new UICodeAction();
  //�õ�prpLclaimDto����
  prpLclaimDto   = claimDto.getPrpLclaimDto();
  
  //�õ�������  
  strPolicyNo =prpLclaimDto.getPolicyNo(); 
  
  //?????? ??????? add by miaowenjun 20060405
  strComCode = prpLclaimDto.getComCode();
  prpDcompanyDto = uiCompanyAction.findByPrimaryKey(strComCode);
  if(prpDcompanyDto != null){
  	strCompanyAdd = prpDcompanyDto.getAddressCName();
  	strPostCode = prpDcompanyDto.getPostCode();
  }
  //add end by miaowenjun 20060405
  
  //�õ�blPrpCitemKind����ļ�¼��
  if(policyDto.getPrpCitemKindDtoList()!=null){
    intItemKindCount     = policyDto.getPrpCitemKindDtoList().size();
  }
    
  //�õ�blPrpLthirdParty����ļ�¼��
  if(claimDto.getPrpLthirdPartyDtoList()!=null){
    intThirdPartyCount     = claimDto.getPrpLthirdPartyDtoList().size();
  }
  
  //�õ�PrpLltext����ļ�¼��
  if(claimDto.getPrpLltextDtoList()!=null){
    intLtextCount          = claimDto.getPrpLltextDtoList().size();
  }
  
  //�õ�prpLregistDto����
  prpLregistDto    = registDto.getPrpLregistDto();
%>

<script language="javascript">
  function loadForm()
  {
    tdClaimNo.innerHTML = '�����ţ�' + '<%=strClaimNo%>';
    
    //*****������Ϣ��PrpLregist*****
<%
  double douEstimateLoss = prpLregistDto.getEstimateLoss();
  if(douEstimateLoss == 0){
%>    
    //tdEstimateLoss.innerHTML = '��';
<%
  }else{
%>    
    //tdEstimateLoss.innerHTML = '<%=new DecimalFormat("#,##0.00").format(prpLregistDto.getEstimateLoss())%>' + ' Ԫ';
<%
  }
  System.out.println("--------------"+prpLclaimDto.getPolicyNo());
%>    
    //*****������Ϣ��PrpLregist*****
    tdPolicyNo.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getPolicyNo())%>';
    tdInsuredName.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
    //tdInsuredName1.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>' + '�������������ƣ���';
<%     
    strInsuredDate = "��" + prpLclaimDto.getStartDate().getYear()
                     + "��" + prpLclaimDto.getStartDate().getMonth()
                     + "��" + prpLclaimDto.getStartDate().getDate()
                     + "��" + prpLclaimDto.getStartHour()
                     + "ʱ��"

                     + "��" + prpLclaimDto.getEndDate().getYear()
                     + "��" + prpLclaimDto.getEndDate().getMonth()
                     + "��" + prpLclaimDto.getEndDate().getDate()
                     + "��" + prpLclaimDto.getEndHour()
                     + "ʱֹ";
  //add by caopeng start at 2005-12-30
  //����ע��ԭ��
   if(claimDto.getPrpLltextDtoList()!=null){
    for(index=0;index<intLtextCount;index++)
    {
      prpLltextDto = (PrpLltextDto)claimDto.getPrpLltextDtoList().get(index);
      strTextType = StringConvert.encode(prpLltextDto.getTextType());
      if ( strTextType != null && strTextType.equals("10"))
      {      
        strCancelReason = strCancelReason + StringConvert.encode(prpLltextDto.getContext()) ;
      }
    }    
  }
     
    intLtextCountTmp = 0;    //text������

    for(index=0;index<strCancelReason.length();index++)
    {
      if(strCancelReason.substring(index,index+1).equals("\\"))
      {
        if(!(strCancelReason.substring(index).length()<4))
        {
          if(strCancelReason.substring(index,index+4).equals("\\r\\n"))
          {
             intLtextCountTmp++;    //ֻҪ�лس����У�intLtextCountTmp+1
          }
        }
      }
    }
    
    int x = 0;
    int y = 0;
    if(!(strCancelReason.length()<4))    //���strCancelReason.length()>=4���ж�strCancelReason��β�����֣����ǻس�����
    {
      x = strCancelReason.length()-4;
      y = strCancelReason.length();
      if(!strCancelReason.substring(x,y).equals("\\r\\n"))
      {
         intLtextCountTmp += 1;   
      }
    }
    else    //���strCancelReason����1�У�intLtextCountTmp = 1; 
      intLtextCountTmp = 1; 
    
    /*if( intLtextCountTmp>20 )
    {      
       strCancelReason = "<br>";        
    }*/
    while(strCancelReason.indexOf("\\r\\n")!=-1){
       strCancelReason=strCancelReason.substring(0,strCancelReason.indexOf("\\r\\n"))+"<br>"+strCancelReason.substring(strCancelReason.indexOf("\\r\\n")+"\\r\\n".length());
    }
    //add by caopeng end at 2005-12-30
%>                    
    tdInsuredDate.innerHTML = '<%=strInsuredDate%>';
    tdRegistNo.innerHTML = '�����ţ�'+'<%=StringConvert.encode(prpLclaimDto.getRegistNo())%>';
    //tdCaseNo.innerHTML = '�鵵��'+'<%=StringConvert.encode(prpLclaimDto.getCaseNo())%>';
    tdCancelReason.innerHTML = 'ע������ԭ��<br>&nbsp;&nbsp;&nbsp;&nbsp;'+'<%=StringConvert.encode(strCancelReason)%>';
    tdDamageCause.innerHTML = '����ԭ��<br>&nbsp;&nbsp;&nbsp;&nbsp;'+'<%=StringConvert.encode(prpLclaimDto.getDamageName())%>';
<%
    //��������
    strCode = "";
    strName = "";
    strCode = StringConvert.encode(prpLclaimDto.getRiskCode());
    strName = uiCodeAction.translateRiskCode(strCode,isChinese);
%>  
    //tdRiskName.innerHTML = '<%=strName%>';
    tdRiskNameAndEstimateLoss.innerHTML = '<%=strName+"/"+new DecimalFormat("#,##0.00").format(prpLregistDto.getEstimateLoss())+"Ԫ"%>';
<%    
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                        + "��" + prpLclaimDto.getDamageStartDate().getMonth()
                        + "��" + prpLclaimDto.getDamageStartDate().getDate()
                        + "��"+prpLclaimDto.getDamageStartHour().substring(0,2)+"ʱ";
%>                    
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>';
    //tdDamageAddress.innerHTML   = '<%=StringConvert.encode(prpLclaimDto.getDamageAddress())%>';
    
    //*****���⳵����ϢPrpLthirdParty*****
<%  

  if(claimDto.getPrpLthirdPartyDtoList()!=null){
    for(index=0;index<intThirdPartyCount;index++)
    {
      prpLthirdPartyDto = (PrpLthirdPartyDto)claimDto.getPrpLthirdPartyDtoList().get(index);
      strInsureCarFlag     = prpLthirdPartyDto.getInsureCarFlag();
      
      if( strInsureCarFlag.equals("1") )  
      {
%>        
        tdLicenseNo.innerHTML = '<%=prpLthirdPartyDto.getLicenseNo()%>';
        //tdBrandName.innerHTML = '<%=prpLthirdPartyDto.getBrandName()%>';
<%  
      }
    }
  }  
    
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
    //tdSumAmount1.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount1)%>';
    //tdSumAmount2.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount2)%>';    
  }
</script>
 