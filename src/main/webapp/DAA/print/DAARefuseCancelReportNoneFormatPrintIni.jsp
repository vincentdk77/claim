<%--
****************************************************************************
* DESC       �������������վ��� /ע�������ӡ��ʼ��
* AUTHOR     ��caopeng
* CREATEDATE ��2005-12-08
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
  String strClaimNo         = request.getParameter("ClaimNo"); //������
  String strPolicyNo        = "";   //������
  String strRegistNo        = "";   //������
  String strInsuredDate     = "";   //��������
  String strInsuredName     = "";   //��������
  String strDamageStartDate = "";   //����ʱ��
  String strDamageAddress   = "";   //���յص�
  String strIndemnityDuty   = "";   //��������
  String strInsureCarFlag   = "";   //�Ƿ�Ϊ����������
  String strLicenseNo       = "";   //���ƺ���
  String strBrandName       = "";   //���Ƴ���
  String strContext        = "";   //�������
  String strCancelReason    = "";   //����ע������

  String strRiskCode        = "";   //���ִ���     
  String strKindCode        = "";   //�ձ����     
  String strCalculateFlag   = "";   //�Ƿ���뱣��
  String strUserCode        = ((UserDto)request.getSession().getAttribute("user")).getUserCode(); 
  String strMessage         = "";  
  String strTextType        = "";  

  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
    
  //�����岿��                                             
  PrpCitemKindDto    prpItemKindDto     = null;   //������ItemKindDto����
  PrpLregistDto      prpLregistDto      = null;   //RegistDto����
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto����
  PrpLltextDto       prpLltextDto       = null;   //PrpLltextDto����
  
  int intClaimCount      = 0;   //ClaimDto����ļ�¼��
  int intItemKindCount   = 0;   //ItemKindDto����ļ�¼��
  int intThirdPartyCount = 0;   //ThirdPartyDto����ļ�¼��
  int index = 0;
  int intLtextCount      = 0;   //PrpLltextDto����ļ�¼��
  int intLtextCountTmp   = 0;
  
  
  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto����
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  
  UICodeAction uiCodeAction = new UICodeAction();
  //�õ�prpLclaimDto����
  prpLclaimDto   = claimDto.getPrpLclaimDto();
  
  //�õ�������  
  strPolicyNo =prpLclaimDto.getPolicyNo(); 
  strCode = prpLclaimDto.getIndemnityDuty();
  strIndemnityDuty = uiCodeAction.translateCodeCode("IndemnityDuty",strCode,isChinese);
  
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
  strRegistNo      = prpLregistDto.getRegistNo();
  
  //�õ��������
  UICheckAction uiCheckAction = new UICheckAction();
  CheckDto checkDto = uiCheckAction.findByPrimaryKey(strRegistNo);
  PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
	
  if (checkDto.getPrpLregistTextDtoList() != null) {
    Iterator iterator = checkDto.getPrpLregistTextDtoList().iterator();
    while (iterator.hasNext()) {
      PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto) iterator.next();
      strContext = strContext + prpLregistTextDtoTemp.getContext();
    }
  }
  strInsuredName = StringConvert.encode(prpLclaimDto.getInsuredName());
   
    //*****������Ϣ��PrpLregist*****
      
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

    //��������
    strCode = "";
    strName = "";
    strCode = StringConvert.encode(prpLclaimDto.getRiskCode());
    strName = uiCodeAction.translateRiskCode(strCode,isChinese);
   
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                        + "��" + prpLclaimDto.getDamageStartDate().getMonth()
                        + "��" + prpLclaimDto.getDamageStartDate().getDate()
                        + "��"+prpLclaimDto.getDamageStartHour().substring(0,2)+"ʱ";
    strDamageAddress   = StringConvert.encode(prpLclaimDto.getDamageAddress());
    //*****���⳵����ϢPrpLthirdParty*****
 

  if(claimDto.getPrpLthirdPartyDtoList()!=null){
    for(index=0;index<intThirdPartyCount;index++)
    {
      prpLthirdPartyDto = (PrpLthirdPartyDto)claimDto.getPrpLthirdPartyDtoList().get(index);
      strInsureCarFlag     = prpLthirdPartyDto.getInsureCarFlag();
      
      if( strInsureCarFlag.equals("1") )  
      {
        strLicenseNo = prpLthirdPartyDto.getLicenseNo();
        strBrandName = StringConvert.encode(prpLthirdPartyDto.getBrandName());
      }
    }
  }  
  //add by caopeng start at 2005-12-29
  //����ע������
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
    //add by caopeng end at 2005-12-29
%>
