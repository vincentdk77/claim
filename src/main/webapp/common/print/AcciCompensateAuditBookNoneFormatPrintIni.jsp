<%--
****************************************************************************
* DESC       ������������ʼ��
* AUTHOR     ��caopeng
* CREATEDATE ��2005-12-14
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>



<%-- ����bean�ಿ�� --%>
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 
<%@page import="java.util.ArrayList"%>
<%@page import="com.sinosoft.sff.schema.PrpJpayRefRecSchema"%>
<%@page import="com.sinosoft.sff.blsvr.BLPrpJpayRefRec"%>
<%@page import="com.sinosoft.payment.bl.facade.BLPrpJpayRefMainFacade"%>
<%@page import="com.sinosoft.payment.dto.domain.PrpJpayRefMainDto"%>

<%
  //������������
  String strCompensateNo      = request.getParameter("CompensateNo"); //����������
  String strClaimNo           = "";   //������
  String strRegistNo          = "";   //������
  String strPolicyNo          = "";   //������
  String strTextType          = "";
  String strContext           = "";   //������������
  String[] strAcciName        ;   //�¹�������
  String strSexCode           = "";   //�Ա����
  String[] strAcciSex         ;     //�¹����Ա�
  String[] strAcciAge         ;     //�¹�������
  String[] strAcciIDCardNo    ;     //�¹������֤��
  String strAcciDate          = "";   //�¹�ʱ��
  String strDamageTypeName    = "";   //�¹�����
  String strClaimTypeName     = "";   //�¹�����
  String strDamageName        = "";   //�¹�ԭ��
  String strInsuredDate       = "";   //��������
  String strSumRealPay        = "";   //�⸶�ܽ��
  String strDamageType        = "";   //�⸶����
  String strHandlerName       = "";   //������
  String strUnderWriteName    = "";   //�����
  String strInputDate         = "";   
  double sumRealpay           = 0.0;  //�⸶�ϼ�
  String strUnderWriteEndDate         = "";   
  
  double dblSumAmount        = 0;    //���ս�� 
  
  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
  
  //�����岿��
                                              
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLcompensateDto  prpLcompensateDto  = null;   //CompensateDto����
  PrpLchargeDto      prpLchargeDto      = null;   //ChargeDto����
  PrpLctextDto       prpLctextDto       = null; 
  PrpLregistDto      prpLregistDto      = null;
  PrpLpropDto        prpLpropDto        = null;
  PrpLextDto         prpLextDto         = null;
  PrpLlossDto        prpLlossDto		= null;
  PrpLpersonLossDto  prpLpersonLossDto  = null;
  List               prplPersonList = new ArrayList(); 
	List    					 prpLctextList = new ArrayList();
  
  
  int index = 0;
  
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  CheckDto checkDto = (CheckDto)request.getAttribute("checkDto"); 
  CompensateDto compensateDto = (CompensateDto)request.getAttribute("compensateDto"); 
  CertainLossDto certainLossDto = (CertainLossDto)request.getAttribute("certainLossDto");
  
  prpLctextList = (ArrayList)request.getAttribute("prpLctextList");
  prplPersonList = (ArrayList)request.getAttribute("prplPersonList");
  
  EndorseDto endorseDto = (EndorseDto)request.getAttribute("endorseDto");
   
  UICodeAction uiCodeAction = new UICodeAction();
  //�õ�prpLcompensateDto ����
  prpLcompensateDto   = compensateDto.getPrpLcompensateDto();
  
  //�õ�prpLclaimDto����
  prpLclaimDto   = claimDto.getPrpLclaimDto();
  //�õ�prpLregistDto����
  prpLregistDto  = registDto.getPrpLregistDto();
  
  strClaimNo = prpLclaimDto.getClaimNo();
  //�õ�������
  strPolicyNo = prpLclaimDto.getPolicyNo();
  
  //�õ��¹�����Ϣ
  int personCount = claimDto.getPrplacciBenPersonDtoList().size();
  strAcciName = new String[personCount];
  strAcciSex  = new String[personCount];
  strAcciAge  = new String[personCount];
  strAcciIDCardNo = new String[personCount];
  if(claimDto != null){    
    for(int i = 0;i < personCount; i++){
      PrpLacciPersonDto prpLacciPersonDto = (PrpLacciPersonDto)claimDto.getPrplacciBenPersonDtoList().get(i);
      strAcciName[i]          = StringConvert.encode(prpLacciPersonDto.getAcciName());
      strSexCode              = prpLacciPersonDto.getSex(); 
      strAcciSex[i]           = uiCodeAction.translateCodeCode("SexCode",strSexCode,true);  
      strAcciAge[i]           = String.valueOf(prpLacciPersonDto.getAge()); 
      strAcciIDCardNo[i]      = prpLacciPersonDto.getIdentifyNumber();
    }
  }
  
  //�õ�������Ϣ
  if(prpLclaimDto != null){
    strCode = prpLclaimDto.getDamageTypeCode();
    strDamageTypeName = uiCodeAction.translateCodeCode("DamageTypeCode",strCode,true);
    DateTime dtAcciDate = new DateTime();
    String strDamageStartHour = prpLclaimDto.getDamageStartHour();
    dtAcciDate = prpLclaimDto.getDamageStartDate();
    strAcciDate = dtAcciDate.getYear()+"��"+
                  dtAcciDate.getMonth()+"��"+
                  dtAcciDate.getDay()+"��"+
                  strDamageStartHour;
    strCode = prpLclaimDto.getClaimType();
    strClaimTypeName = uiCodeAction.translateCodeCode("CaseCode",strCode,true);
    strClaimTypeName = "���ʣ�" + strClaimTypeName;
    strCode = prpLclaimDto.getDamageCode();
    strDamageName = uiCodeAction.translateCodeCode("DamageCode",strCode,true);
    //System.out.println("====="+strClaimTypeName);
  }
  
  //�õ�������Ϣ
  if(policyDto != null){
    PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
    if(prpCmainDto!=null){
      strInsuredDate = "�� " + prpCmainDto.getStartDate().getYear()
                       + "��" +prpCmainDto.getStartDate().getMonth()
                       + "��" + prpCmainDto.getStartDate().getDate()
                       + "��" + prpCmainDto.getStartHour()
                       + "ʱ��"
                       + "�� " + prpCmainDto.getEndDate().getYear()
                       + "��" + prpCmainDto.getEndDate().getMonth()
                       + "��" + prpCmainDto.getEndDate().getDate()
                       + "��" + prpCmainDto.getEndHour()
                       + "ʱֹ";
      dblSumAmount = prpCmainDto.getSumAmount();
    }
  }
  
  
  String strPayRefCode = "";
  String strPayRefName = "";
  String strPayRefDate = "";
  String strPayRefNo = "";
  
  BLPrpJpayRefRec blPrpJpayRefRec = new BLPrpJpayRefRec();
  PrpJpayRefRecSchema prpJpayRefRecSchema = new PrpJpayRefRecSchema();
  String strSQL = "certitype = 'C' and certiNo = '" + strCompensateNo + "'";
  blPrpJpayRefRec.query(strSQL);
  if(blPrpJpayRefRec.getSize()>0)
  {
    prpJpayRefRecSchema = blPrpJpayRefRec.getArr(0);
  }
  if(prpJpayRefRecSchema!=null)
  {
    strPayRefNo = prpJpayRefRecSchema.getPayRefNo();
  }
  if(!strPayRefNo.equals("")&&strPayRefNo.length()==21)
  {
    BLPrpJpayRefMainFacade blPrpJpayRefMainFacade = new BLPrpJpayRefMainFacade();
    PrpJpayRefMainDto prpJpayRefMainDto = new PrpJpayRefMainDto();
    String conditions = "PayRefNo = '" + strPayRefNo + "'";
    ArrayList prpJpayRefMainDtoList = new ArrayList();
    prpJpayRefMainDtoList = (ArrayList)blPrpJpayRefMainFacade.findByConditions(conditions);
    if(prpJpayRefMainDtoList!=null)
    {
      prpJpayRefMainDto = (PrpJpayRefMainDto)prpJpayRefMainDtoList.get(0);
    
      strPayRefCode = prpJpayRefMainDto.getPayRefCode();
      strPayRefDate = prpJpayRefMainDto.getPayRefDate().getYear()+" �� "
                   +prpJpayRefMainDto.getPayRefDate().getMonth()+" �� "
                   +prpJpayRefMainDto.getPayRefDate().getDay()+" �� ";
    
      strPayRefName = uiCodeAction.translateUserCode(strPayRefCode,isChinese);
    }
  }
  
  
  
  //add by miaowenjun 2007-1-29 10:53 start
	sumRealpay = prpLcompensateDto.getPersonLossSumRealPay();
    //���������еļ��������ӽ����ϼ���    
    int count = compensateDto.getPrpLchargeDtoList().size();
    for(int i = 0 ; i < count; i ++){
    	prpLchargeDto = (PrpLchargeDto)compensateDto.getPrpLchargeDtoList().get(i);
    	sumRealpay += prpLchargeDto.getSumRealPay();
    }
    strSumRealPay = String.valueOf(new DecimalFormat("#,##0.00").format(sumRealpay));
	strHandlerName = uiCodeAction.translateUserCode(prpLcompensateDto.getHandlerCode(),true);
	strUnderWriteName = prpLcompensateDto.getUnderWriteName();
	strInputDate = prpLcompensateDto.getInputDate().getYear()+"��"+prpLcompensateDto.getInputDate().getMonth()+"��"+prpLcompensateDto.getInputDate().getDate()+"��";
	strUnderWriteEndDate = prpLcompensateDto.getUnderWriteEndDate().getYear()+"��"+prpLcompensateDto.getUnderWriteEndDate().getMonth()+"��"+prpLcompensateDto.getUnderWriteEndDate().getDate()+"��";
	//add by miaowenjun 2007-1-29 10:53 end
%>
<script language="javascript">

function loadForm(){
  
  spClaimNo.innerHTML = '<%=strClaimNo%>';
  spClaimNo1.innerHTML = '<%=strClaimNo%>';
  spPolicyNo.innerHTML = '<%=strPolicyNo%>';
  spDamageTypeName.innerHTML  = '<%=strDamageTypeName%>';
  spAcciDate.innerHTML  = '<%=strAcciDate%>';
  spAcciDate1.innerHTML  = '<%=strAcciDate%>';
  spAcciDamageDesc.innerHTML  = '<%="&nbsp;&nbsp;�¹�ԭ��"+strDamageName+"&nbsp;&nbsp;"+strClaimTypeName%>';
  spAcciDamageName.innerHTML  = '<%=strDamageName%>';
  spPolicyNo1.innerHTML  = '<%=strPolicyNo%>'; 
  spInsuredDate.innerHTML  = '<%=strInsuredDate%>';
  spSumAmount.innerHTML = '<%=new DecimalFormat("#,##0.00").format(dblSumAmount)%>';
}

</script>
