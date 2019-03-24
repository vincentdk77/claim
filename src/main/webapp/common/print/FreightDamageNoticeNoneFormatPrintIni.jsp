<%--
****************************************************************************
* DESC       �������ճ���֪ͨ���嵥��ӡ��ʼ��
* AUTHOR     ��wangwei
* CREATEDATE ��2005-5-21
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%-- ����bean�ಿ�� --%>
<%@page import="java.text.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 
<%@page import="com.sinosoft.prpall.blsvr.cb.*"%>
<%@page import="com.sinosoft.utiall.dbsvr.*"%>
<%@page import="com.sinosoft.claim.bl.facade.*"%>
<%@ page import="java.util.*"%>

<%
    String strPolicyNo    = ""; //������
    String strInsuredName = ""; //��������
    double dblSumAmount  = 0;  //���ս��
    String strRegistNo    = ""; //������
    String strStartDate   = ""; //��������
    String strDamageName  = ""; //����ԭ��
    String strDamageAddress = ""; //���յص�
    String strLindline      = ""; //����·��
    String strEstimateLoss = "";
    String strConveyance = "";    //���䷽ʽ
    String strVoyageNo = "";
    String strBargainNo = "";
    String strViaSiteName = "";
    String strCheckAgentCode = "";
    String strCheckAgentName = "";
    //add by zhulei 20050930
    String strReportorName = "";    //������
    String strPhoneNumber = "";     //��ϵ�绰
    String strReportDate = "";      //��������
    String strReceiverName = "";    //�Ǽ���
    String strInputDate = "";       //�Ǽ�����
    
    int intItemKind       = 0;
    int index             = 0;
    
    PrpCitemKindDto prpCitemKindDto = null;
    
    PrpLregistDto prpLregistDto = (PrpLregistDto) request.getAttribute("prpLregistDto");
    PolicyDto policyDto = (PolicyDto) request.getAttribute("policyDto");
    PrpCmainDto prpCmainDto = (PrpCmainDto) policyDto.getPrpCmainDto();
    UICodeAction uiCodeAction = new UICodeAction();
    
    PrpCmainCargoDto prpCmainCargoDto = policyDto.getPrpCmainCargoDto();
    
    strPolicyNo = prpLregistDto.getPolicyNo();
    strInsuredName = prpLregistDto.getInsuredName();
    strRegistNo = prpLregistDto.getRegistNo();
    strDamageName = prpLregistDto.getDamageName();
    strDamageAddress = prpLregistDto.getDamageAddress();
    strEstimateLoss = String.valueOf(prpLregistDto.getEstimateLoss());
    
    String strContent = "";
    BLPrpLregistTextFacade blPrpLregistTextFacade = new BLPrpLregistTextFacade();
    PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
    ArrayList textArrayList = null;
    textArrayList = (ArrayList)blPrpLregistTextFacade.findByConditions("RegistNo='"+strRegistNo+"'");
    Iterator textI = textArrayList.iterator();
    while(textI.hasNext()){
        prpLregistTextDto =(PrpLregistTextDto) textI.next();
        strContent = strContent + prpLregistTextDto.getContext();
    }   
    
    strReportorName = prpLregistDto.getReportorName();
    strPhoneNumber  = prpLregistDto.getPhoneNumber();
    strReportDate   = prpLregistDto.getReportDate().toString();
    strReceiverName = prpLregistDto.getReceiverName();
    strInputDate    = prpLregistDto.getInputDate().toString();
    
    
    //add by zhulei 20050927 
    String strLossName = "";      //��������
    String strLossQuantity = "";  //��������
    String strUnit = "";          //���ﵥλ
    String strBLNo = "";          //���Σ������
    
    strLossName = prpLregistDto.getLossName();
    strLossQuantity = new DecimalFormat("###0").format(prpLregistDto.getLossQuantity());
    strUnit = prpLregistDto.getUnit();
    
    if (prpLregistDto.getDamageStartDate() == null || prpLregistDto.getDamageStartDate().toString().trim().equals("")) {
        strStartDate = "";
    } else {
        strStartDate = prpLregistDto.getDamageStartDate().getYear() + "��" + prpLregistDto.getDamageStartDate().getMonth()
                        + "��" + prpLregistDto.getDamageStartDate().getDay() + "��";
    }
 
    if (prpCmainCargoDto != null) {
        strConveyance = prpCmainCargoDto.getConveyance();
        strVoyageNo = prpCmainCargoDto.getVoyageNo();
        strBargainNo = prpCmainCargoDto.getBargainNo();
        strViaSiteName = policyDto.getPrpCmainCargoDto().getViaSiteName();
        strCheckAgentCode = prpCmainCargoDto.getCheckAgentCode();
        strBLNo = prpCmainCargoDto.getBLNo();
    }
    
    //�����������˴���ת��
    if (strCheckAgentCode != null && !strCheckAgentCode.equals("")) {
         ArrayList prpDidentifierDtoList = uiCodeAction.translateCheckAgentCodeToName(" CheckAgentCode=" + strCheckAgentCode);
         if (prpDidentifierDtoList.size() > 1) {
             strCheckAgentName = ((PrpDidentifierDto) prpDidentifierDtoList.get(0)).getIdentifierName();
         }
    }
    String strStartDate1 = prpCmainDto.getStartDate().toString();  //��������������δ������������
    
    String strKindName = "";      //��������ձ�
    intItemKind = policyDto.getPrpCitemKindDtoList().size();
    for(index=0;index<intItemKind;index++){
      prpCitemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index);
      if(prpCitemKindDto.getFlag().substring(1,2).equals("1")){
        strKindName = strKindName + prpCitemKindDto.getKindName();
      }
      String strAmount = String.valueOf(prpCitemKindDto.getAmount());
    }
 
    if (policyDto.getPrpCmainCargoDto() != null) {
        if(strViaSiteName.equals("")) {
          strLindline = policyDto.getPrpCmainCargoDto().getStartSiteName()+" �� "+ policyDto.getPrpCmainCargoDto().getEndSiteName();
        }else{ 
          strLindline = " �� "+policyDto.getPrpCmainCargoDto().getStartSiteName()+" �� "+policyDto.getPrpCmainCargoDto().getViaSiteName()+" �� "+policyDto.getPrpCmainCargoDto().getEndSiteName();   
        }
    }
    
    //add by zhulei 20050927 
    String strMainPolicyNo = "";    //ԤԼ������
    BLPrpCmainSub blPrpCmainSub = new BLPrpCmainSub();
    blPrpCmainSub.query("PolicyNo='"+strPolicyNo+"'");
    if(blPrpCmainSub.getSize()>0){
      strMainPolicyNo = blPrpCmainSub.getArr(0).getMainPolicyNo();
    }
    
    String strRemark = "";        //������
    BLPrpCmainCargo blPrpCmainCargo = new BLPrpCmainCargo();
    blPrpCmainCargo.query("PolicyNo='"+strPolicyNo+"'");
    if(blPrpCmainCargo.getSize()>0){
      strRemark = blPrpCmainCargo.getArr(0).getRemark();
    }
    
    //add by zhulei begin 20050929 ���䷽ʽ����
    if(strConveyance!=null && !strConveyance.equals("")){
      DBPrpDcode dbPrpDcode = new DBPrpDcode();
      dbPrpDcode.getInfo("ConveyanceType",strConveyance);
      strConveyance = dbPrpDcode.getCodeCName();
    }
%>

<script language="javascript">
    function loadForm() {
        tdRegistNo.innerHTML    = '������:' + '<%= strRegistNo %>';
        tdInsuredName.innerHTML = '<%= strInsuredName %>';
        tdPolicyNo.innerHTML    = '<%= strPolicyNo %>';
        tdAmount.innerHTML      = '<%= dblSumAmount %>';
        tdConveyance.innerHTML  = '<%= strConveyance %>';
        tdLindline.innerHTML    = '<%= strLindline %>';
        //tdVoyageNo.innerHTML    = '<%= strVoyageNo %>';
        tdStartDate.innerHTML   = '<%= strStartDate1 %>';
        tdDamageStartDate.innerHTML = '<%= strStartDate %>';
        tdDamageName.innerHTML  = '<%= strDamageName %>';
        tdEstimateLoss.innerHTML= '<%= strEstimateLoss %>';
        tdDamageAddress.innerHTML = '<%= strDamageAddress %>';
        //tdCheckAgentName.innerHTML = '<%= strCheckAgentName %>';
        
    }
</script>
