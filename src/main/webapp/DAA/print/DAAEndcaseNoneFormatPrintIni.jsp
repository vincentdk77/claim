<%@page pageEncoding="GBK"%>
<%--
****************************************************************************
* DESC       �������������ս᰸�������ӡ��ʼ��
* AUTHOR     ��zhaozhuo
* CREATEDATE ��2005-04-13
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%-- ����bean�ಿ�� --%>
<%@page import="java.util.*"%>
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
  
  
  String strInsuredName       ="";
  String strDamageStartDate   = "";   //����ʱ��
  String strLicenseNo         = "";   //�����еĺ��ƺ���
  String strClaimNo           = "";   //������
   String strContext           = "";  //������������
  String strTextType           = "";
  String strComName     = "";  //�б���˾����
  String strPolicyNo    = "";  //������
  String strRiskCode    = "";
 
  int intInsuredCount     = 0;   //InsuredDto����ļ�¼��
  int intThirdPartyCount  = 0;   //ThirdPartyDto����ļ�¼��
  int intDriverCount      = 0;   //DriverDto����ļ�¼��
  int intCtextCount       = 0;   //CtextDto����ļ�¼��
  int intCtextCountTmp    = 0;   //textarea����
  int intCplanCount       = 0;   
  int index=0;
  int intLossCount        = 0;
  int intCmainCount       = 0;
  
  double douPlanFee     = 0d;
  double douDelinquentFee = 0d;

  //�����岿��
    PrpCinsuredDto     prpInsuredDto      = null;   //������InsuredDto����                                           
    PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
    PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto����
    PrpLdriverDto      prpLdriverDto      = null;   //DriverDto����
    PrpLctextDto       prpLctextDto       = null; 
    PrpLregistDto      prpLregistDto      = null;
    PrpLcheckDto       prpLcheckDto       = null;
    PrpCplanDto        prpCplanDto        = null;
    PrpLlossDto        prpLlossDto        = null; 
    PrpLpersonLossDto  prpLpersonLossDto  = null;
    PrpLchargeDto      prpLchargeDto      = null;
    PrpCmainDto        prpCmainDto        = null;
    

 //�õ�ClaimDto,RegistDto,PolicyDto,CompensateDto����
    PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
    ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
    CompensateDto compensateDto = (CompensateDto)request.getAttribute("compensateDto"); 
    RegistDto registDto = (RegistDto)request.getAttribute("registDto"); 
    CheckDto  checkDto  = (CheckDto)request.getAttribute("checkDto");  
    PrpLCMainDto prpLCMainDto = (PrpLCMainDto)request.getAttribute("prpLCMainDto");
    
    UICodeAction uiCodeAction = new UICodeAction();

 //�õ�prpLclaimDto����
  prpLclaimDto   = claimDto.getPrpLclaimDto();  
  prpLregistDto =  registDto.getPrpLregistDto();
  prpLcheckDto =   checkDto.getPrpLcheckDto();
  strClaimNo = prpLclaimDto.getClaimNo(); 
  strComName = prpLclaimDto.getComName();
  strPolicyNo = prpLregistDto.getPolicyNo();
 //�õ�dbPrpLctext����ļ�¼��  
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    intCtextCount     = compensateDto.getPrpLlossDtoList().size();
  }  
 
%>

<script language="javascript">
  function loadForm()
  {
<%    
    //�б���˾
    String strCode = "";
    String strName = "";
    strCode = StringConvert.encode(prpLclaimDto.getComCode());
    strName = uiCodeAction.translateComCode(strCode,true); 
    String operatorName = uiCodeAction.translateUserCode(prpLclaimDto.getOperatorCode(),true);
    DateTime dateTime = new DateTime();
    String operateTime = "<ins>&nbsp;"+new DateTime(dateTime.current(),dateTime.YEAR_TO_DAY).getYear()+"&nbsp;</ins>��<ins>&nbsp;"
                         +new DateTime(dateTime.current(),dateTime.YEAR_TO_HOUR).getMonth()+"&nbsp;</ins>��<ins>&nbsp;"
                         +new DateTime(dateTime.current(),dateTime.YEAR_TO_HOUR).getDate()+"&nbsp;</ins>��";
%>
    tdComName.innerHTML  = '�б���˾��' + '<%=strName%>';    
<%  
        ArrayList prpCinsuredDtoList = policyDto.getPrpCinsuredDtoList();
        intInsuredCount = prpCinsuredDtoList.size();
        for(index=0;index<intInsuredCount;index++)
    {
      prpInsuredDto = (PrpCinsuredDto)((ArrayList)prpCinsuredDtoList).get(index);        
      %>  
    tdPolicyNo.innerHTML = '������:'+'<%=strPolicyNo%>';
    tdInsuredName.innerHTML = '�������ˣ�'+'<%=StringConvert.encode(prpLclaimDto.getInsuredName())%>';
<%       
  }
%>   
<%  
    intThirdPartyCount = registDto.getPrpLthirdPartyDtoList().size();
    for(index=0;index<intThirdPartyCount;index++)
    {
      prpLthirdPartyDto = (PrpLthirdPartyDto)registDto.getPrpLthirdPartyDtoList().get(index);
%>        
      tdLicenseNo.innerHTML = '<%=((PrpLthirdPartyDto)registDto.getPrpLthirdPartyDtoList().get(0)).getLicenseNo()%>';  
      tdBrandName.innerHTML = '<%=prpLthirdPartyDto.getBrandName()%>' ;
<%
    }
%>
  
<%    
    strDamageStartDate = prpLclaimDto.getDamageStartDate().getYear()
                        + " �� " +prpLclaimDto.getDamageStartDate().getMonth()
                        + " �� " + prpLclaimDto.getDamageStartDate().getDate()
                        + " ��";
%>                    
    tdDamageStartDate.innerHTML = '<%=strDamageStartDate%>';
<%  
    intDriverCount = registDto.getPrpLdriverDtoList().size();
    for(index=0;index<intDriverCount;index++)
    {
      prpLdriverDto     = (PrpLdriverDto)registDto.getPrpLdriverDtoList().get(index);
%>        
      tdDriverName.innerHTML = '<%=StringConvert.encode(prpLdriverDto.getDriverName())%>'; 
      tdDrivingLicenseNo.innerHTML = '<%=StringConvert.encode(prpLdriverDto.getDrivingLicenseNo())%>'; 
      tdDrivingCarType.innerHTML = '<%=StringConvert.encode(prpLdriverDto.getDrivingCarType())%>';
      
<%
    }
%>  

      tdDamageAddress.innerHTML = '<%=StringConvert.encode(prpLregistDto.getDamageAddress())%>';
      tdDamageName.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getDamageName())%>';
      tdDamageTypeName.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getDamageTypeName())%>';
      tdClaimNo.innerHTML = '�ⰸ���:<%=strClaimNo%>';
      tdCaseNo.innerHTML = '�鵵���:<%=StringConvert.encode(prpLclaimDto.getCaseNo())%>';
      tdRiskCode.innerHTML = '<%=StringConvert.encode(prpLclaimDto.getRiskCode())%>'; 
      tdIndemnityDuty.innerHTML = '<%=uiCodeAction.translateCodeCode("IndemnityDuty",prpLclaimDto.getIndemnityDuty(),true)%>';
      tdIndemnityDutyRate.innerHTML = '<%=prpLclaimDto.getIndemnityDutyRate()%>';
  
      tdChecker1.innerHTML = '<%=StringConvert.encode(prpLcheckDto.getChecker1())%>';
      tdChecker2.innerHTML = '<%=StringConvert.encode(prpLcheckDto.getChecker2())%>';
      tdCheckDate.innerHTML = '<%=prpLcheckDto.getCheckDate()%>';
      tdCheckUnitName.innerHTML = '<%=StringConvert.encode(prpLcheckDto.getCheckUnitName())%>';  
<%  
    intCplanCount = policyDto.getPrpCplanDtoList().size();
    for(index=0;index<intCplanCount;index++)
    {
      prpCplanDto = (PrpCplanDto)policyDto.getPrpCplanDtoList().get(index);
      douPlanFee = prpCplanDto.getPlanFee();
      douDelinquentFee = prpCplanDto.getDelinquentFee();
%>        
      tdPlanFee.innerHTML = '<%=douPlanFee%>';  
      tdFinishFee.innerHTML = '<%=(douPlanFee-douDelinquentFee)%>';
<%
    }
%>
<%
  String itemLossInfo = "";
  String strKindCode = "";
  String strKindName = "";
  if(compensateDto.getPrpLlossDtoList()!=null){
    intLossCount = compensateDto.getPrpLlossDtoList().size();
    for(index=0;index<intLossCount;index++){
      prpLlossDto = (PrpLlossDto)compensateDto.getPrpLlossDtoList().get(index); 
      strKindCode = prpLlossDto.getKindCode();
      strKindName = uiCodeAction.translateKindCode("0501",strKindCode,true);  
      itemLossInfo += "&nbsp;"+strKindName+"&nbsp;"
                      +prpLlossDto.getFeeTypeName()+"&nbsp;"
                      +prpLlossDto.getSumRealPay()+"<br>";
%>    
<%
    }
  }
  String personLossInfo = "";
  if(compensateDto.getPrpLpersonLossDtoList()!=null){
    for(index=0;index<compensateDto.getPrpLpersonLossDtoList().size();index++){
      prpLpersonLossDto = (PrpLpersonLossDto)compensateDto.getPrpLpersonLossDtoList().get(index);
      personLossInfo += "&nbsp;"+prpLpersonLossDto.getPersonName()+"&nbsp;"
                        +uiCodeAction.translateKindCode("0501",prpLpersonLossDto.getKindCode(),true)+"&nbsp;"
                        +prpLpersonLossDto.getLiabDetailName()+"&nbsp;"
                        +prpLpersonLossDto.getSumRealPay()+"<br>";
%>
<%
    }
  }
%>
      tdSumPaid.innerHTML = '<%=compensateDto.getPrpLcompensateDto().getSumPaid()%>';
<%
  prpCmainDto = policyDto.getPrpCmainDto();
%>
      tdAppliName.innerHTML = '<%=prpCmainDto.getAppliName()%>';
      tdInsuredName1.innerHTML = '<%=prpCmainDto.getInsuredName()%>';
      tdOperateDate.innerHTML = '<%=prpCmainDto.getOperateDate()%>';
      tdStartTime.innerHTML = '<%=prpCmainDto.getStartDate()%>'+'��'+'<%=prpCmainDto.getEndDate()%>';
      tdSumPremium.innerHTML = '<%=prpCmainDto.getSumPremium()%>';
      tdPayTimes.innerHTML = '<%=prpCmainDto.getPayTimes()%>';
<%
   
  double dblSumAmount1 = 0;
  double dblSumAmount2 = 0;
  String strCalculateFlag = "";
  String strItemKindInfo = "";
  PrpCitemKindDto prpCitemKindDto = null;
  if(policyDto.getPrpCitemKindDtoList()!=null){
    for(index=0;index<policyDto.getPrpCitemKindDtoList().size();index++)
    {
      prpCitemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
      strCalculateFlag = prpCitemKindDto.getCalculateFlag();    
      if( strCalculateFlag.equals("Y") ) 
      {
        dblSumAmount1 += prpCitemKindDto.getAmount();
      }
      if( strCalculateFlag.equals("N") ) 
      {
        dblSumAmount2 += prpCitemKindDto.getAmount();
      }
      strItemKindInfo += "&nbsp;" + prpCitemKindDto.getItemKindNo() + "&nbsp;"
                        +prpCitemKindDto.getKindCode() + "&nbsp;"
                        +uiCodeAction.translateKindCode(prpCitemKindDto.getRiskCode(),prpCitemKindDto.getKindCode(),true) + "&nbsp;"     
                        +prpCitemKindDto.getAmount() + "<br>";
    }    
  }  
%>
    tdSumAmount1.innerHTML = '<%=new DecimalFormat("#,##0.00").format(policyDto.getPrpCmainDto().getSumAmount())%>';
    tdSumAmount2.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount2)%>';    
    tdItemKindInfo.innerHTML = '<%=strItemKindInfo%>';
<%    
  String strContext1 = "";
  String strContext2 = "";
  if(compensateDto.getPrpLctextDtoDtoList()!=null){
    //���������ֱ�PrpLctext
    for(index=0;index<compensateDto.getPrpLctextDtoDtoList().size();index++)
    {
      prpLctextDto = (PrpLctextDto)compensateDto.getPrpLctextDtoDtoList().get(index);
      strTextType = StringConvert.encode(prpLctextDto.getTextType());
      if ( strTextType.charAt(0)=='1' )
      {      
        strContext = strContext + StringConvert.encode(prpLctextDto.getContext()) ;
      }
    }    
  }
	//Modify By �϶��� start at 20051227
	//reason �ڽ���������в�ѯ���ַ���������
    int intContext = strContext.indexOf("����ʵ����");
    if(intContext>=0){
	    strContext1 = strContext.substring(0,intContext);
  	  	strContext2 = strContext.substring(intContext,strContext.length());
  	}
    //Modify By �϶��� end at 20051227
    
    //�����������ִ�����Ǽ���
    int intCtextCountTmp1 = 0;    //textarea������
    int intCtextCountTmp2 = 0;    //textarea������

    for(index=0;index<strContext1.length();index++)
    {
      if(strContext1.substring(index,index+1).equals("\\"))
      {
        if(!(strContext1.substring(index).length()<4))
        {
          if(strContext1.substring(index,index+4).equals("\\r\\n"))
          {
             intCtextCountTmp1 += 1;    
          }
        }
      }
    } 
    int x = 0;
    int y = 0;
    if(!(strContext1.length()<4))    //���strContext.length()>=4���ж�strContext��β�����֣����ǻس�����
    {
      x = strContext1.length()-4;
      y = strContext1.length();
      if(!strContext1.substring(x,y).equals("\\r\\n"))
      {
         intCtextCountTmp1 += 1;   
      }
    }
    else    //���strContext����1�У�intCtextCountTmp = 1; 
      intCtextCountTmp1 = 1;    
    if( intCtextCountTmp1>15 )
    {
      //modify by kangzhen
      strContext1 = strContext1.substring(0,200)+"<br>(��Ϣ���࣬�������ҳ)";  
    }
/*    
    for(index=0;index<strContext2.length();index++)
    {
      if(strContext2.substring(index,index+1).equals("\\"))
      {
        if(!(strContext2.substring(index).length()<4))
        {
          if(strContext2.substring(index,index+4).equals("\\r\\n"))
          {
             intCtextCountTmp2 += 1;    
          }
        }
      }
    }
    int x2 = 0;
    int y2 = 0;
    if(!(strContext2.length()<4))    //���strContext.length()>=4���ж�strContext��β�����֣����ǻس�����
    {
      x = strContext2.length()-4;
      y = strContext2.length();
      if(!strContext2.substring(x,y).equals("\\r\\n"))
      {
         intCtextCountTmp2 += 1;   
      }
    }
    else    //���strContext����1�У�intCtextCountTmp = 1; 
      intCtextCountTmp2 = 1;    
    if( intCtextCountTmp2>8 )
    {
      strContext2 = strContext2.substring(0,300)+"<br>(��Ϣ���࣬�������ҳ)";  
    }
    */
    while(strContext1.indexOf("\\r\\n")!=-1)
       strContext1=strContext1.substring(0,strContext1.indexOf("\\r\\n"))+"<br>"+strContext1.substring(strContext1.indexOf("\\r\\n")+"\\r\\n".length());
    while(strContext2.indexOf("\\r\\n")!=-1)
       strContext2=strContext2.substring(0,strContext2.indexOf("\\r\\n"))+"<br>"+strContext2.substring(strContext2.indexOf("\\r\\n")+"\\r\\n".length());
%>  
   tdContext1.innerHTML = '<%=strContext1%>'; 
   tdContext2.innerHTML = '<%=strContext2%>';  
}
</script>
