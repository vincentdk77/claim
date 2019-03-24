<%--
****************************************************************************
* DESC       �����պ󳭵���ӡҳ��ʼ��
* AUTHOR     �� ��Ŀ��
* CREATEDATE ��2005-9-14
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
<%@page import="com.sinosoft.claim.bl.facade.*"%>
<%@page import="com.sinosoft.utiall.blsvr.*"%>
<%@page import="java.util.*"%>
<%
    int i = 0;
    int k = 0;
    String strClassCode = ""; //����
    String strPolicyNo = ""; //������
    String strRegistNo = ""; //������
    String strPolicyName = ""; //������������
    String strPolicyAddress = ""; //�������˵�ַ
    String strCoinsFlag     = ""; //��������־
    String strCurrency   ="";
    double dbSumAmount   = 0.0;
    DateTime OperateDate = new DateTime();
    DateTime InputDate = new DateTime();
    DateTime SignDate = new DateTime();
    DateTime UnderWriteEndDate = new DateTime();
    DateTime StartDate = new DateTime();
    DateTime EndDate = new DateTime();


    String strRiskCode     = ""; //���ִ���
    String strRiskName     = ""; //��������


    String[] strKindName = null;   //�ձ�����
    double[] dbAmount   = null;  //�ձ𱣶�

    String[] strEndorseNo = null;
    String[] strEndorType = null;
    DateTime[] strEndorDate = null;
    String[] strUnderWriteName = null;

    int[] iPlanNo = null;
    String[] strPlanEndorNo = null;
    double[] dbPlanFee = null;
    double[] dbRealFee = null;
    DateTime[] strPayDate = null;

    Collection collection = null;
    Collection collection1 = null;
    UICodeAction uiCodeAction = new UICodeAction();

    RegistDto registDto = (RegistDto) request.getAttribute("registDto");
    PolicyDto policyDto = (PolicyDto) request.getAttribute("policyDto");
    EndorseDto endorseDto = (EndorseDto) request.getAttribute("endorseDto");
    if(registDto!=null && registDto.getPrpLregistDto()!=null){
        strPolicyNo = registDto.getPrpLregistDto().getPolicyNo();
        strClassCode = registDto.getPrpLregistDto().getClassCode();
        strRegistNo = registDto.getPrpLregistDto().getRegistNo();
    }
    if(policyDto!=null && policyDto.getPrpCmainDto()!=null){
        strPolicyName = policyDto.getPrpCmainDto().getAppliName();
        strPolicyAddress = policyDto.getPrpCmainDto().getAppliAddress();
        strCoinsFlag= policyDto.getPrpCmainDto().getCoinsFlag().toString();
        dbSumAmount =policyDto.getPrpCmainDto().getSumAmount();
        strCurrency =policyDto.getPrpCmainDto().getCurrency();
        OperateDate = policyDto.getPrpCmainDto().getOperateDate();
        InputDate = policyDto.getPrpCmainDto().getInputDate();
        SignDate = policyDto.getPrpCmainDto().getSignDate();
        UnderWriteEndDate = policyDto.getPrpCmainDto().getUnderWriteEndDate();
        StartDate = policyDto.getPrpCmainDto().getStartDate();
        EndDate = policyDto.getPrpCmainDto().getEndDate();
        strRiskName = uiCodeAction.translateRiskCode(policyDto.getPrpCmainDto().getRiskCode(),true);
    }
    if (endorseDto.getPrpPheadDtoList() != null) {
        collection = endorseDto.getPrpPheadDtoList();
        strEndorseNo = new String[collection.size()];
        strEndorType = new String[collection.size()];
        strEndorDate = new DateTime[collection.size()];
        strUnderWriteName = new String[collection.size()];
        i = 0;
        Iterator iterator = endorseDto.getPrpPheadDtoList()
            .iterator();
        //System.out.println(iterator.getSize());
        while (iterator.hasNext()) {
          PrpPheadDto prpPheadDtoTemp = (PrpPheadDto) iterator
              .next();
          strEndorseNo[i] = prpPheadDtoTemp.getEndorseNo();
          strEndorType[i] = uiCodeAction.translateCodeCode("EndorType",prpPheadDtoTemp.getEndorType(),true);
          strEndorDate[i] = prpPheadDtoTemp.getEndorDate();
          strUnderWriteName[i] = prpPheadDtoTemp.getUnderWriteName();
          i++;
        }
      }
    if (policyDto.getPrpCplanDtoList() != null) {
        Iterator iterator = policyDto.getPrpCplanDtoList()
            .iterator();
        collection = policyDto.getPrpCplanDtoList();
        iPlanNo = new int[collection.size()];
        strPlanEndorNo = new String[collection.size()];
        dbPlanFee = new double[collection.size()];
        dbRealFee = new double[collection.size()];
        strPayDate = new DateTime[collection.size()];
        i = 0;
        while (iterator.hasNext()) {
          PrpCplanDto prpCplanDtoTemp = (PrpCplanDto) iterator
              .next();

          iPlanNo[i] = prpCplanDtoTemp.getPayNo();
          if(prpCplanDtoTemp.getPayNo()==0)
            iPlanNo[i] = 1;
          strPlanEndorNo[i] = prpCplanDtoTemp.getEndorseNo();
          dbPlanFee[i] = prpCplanDtoTemp.getPlanFee();
          dbRealFee[i] = prpCplanDtoTemp.getPlanFee() - prpCplanDtoTemp.getDelinquentFee();
          strPayDate[i] = prpCplanDtoTemp.getPlanDate();
          i++;
        }
      }
    if (policyDto.getPrpCitemKindDtoList() != null) {

        collection = policyDto.getPrpCitemKindDtoList();
        strKindName = new String[collection.size()];
        dbAmount    = new double[collection.size()];
        i = 0;
        Iterator iterator = policyDto.getPrpCitemKindDtoList()
            .iterator();
        while (iterator.hasNext()) {
          PrpCitemKindDto prpCitemKindDtoTemp = (PrpCitemKindDto) iterator
              .next();
          strKindName[i] = prpCitemKindDtoTemp.getKindName();
          dbAmount[i] = prpCitemKindDtoTemp .getAmount();
          i++;
        }
      }

    //modify by zhulei 20050926
    if (strCoinsFlag.equals("0")) {         
        strCoinsFlag = "��";
    } else if (strCoinsFlag.equals("1")) {
        strCoinsFlag = "��";
    }
    //if (strCoinsFlag.equals("0")) {         //�ǹ���
    //    strCoinsFlag = "�ǹ���";
    //} else if (strCoinsFlag.equals("1")) {  //������
    //    strCoinsFlag = "������";
    //} else if (strCoinsFlag.equals("2")) {  //����
    //    strCoinsFlag = "����";
    //}
    
    //add by zhulei 20050914 ��ʷ�⸶��¼ PrpLclaim--����ʱ���д�����Կ���ȡ���������
    String[]   strClaimNo      = null;    //������
    DateTime[] strDamangeDate  = null;    //��������
    String[]   strDamageName   = null;    //����ԭ��
    double[]   dbSumPaid       = null;    //�⸶���
    DateTime[] arrEndCaseDate  = null;    //�᰸����(claim��)
    DateTime[] arrEndCaseDate1 = null;    //�᰸����(compensate��)
    double[]   dbSumClaim      = null;    //δ�����(������)
    double[]   result          = null;    //δ���������Ѿ���
    String[]   arrCaseNo       = null;    //�鵵��
    String[]   arrOperatorCode = null;    //�����ˣ������˴��룩
    String[]   arrUnderWriteName = null;  //����������
    String[]   arrHandlerCode  = null;    //�����˴���
    String[]   arrHandlerName  = null;    //����������
    BLPrpDuser blPrpDuser = new BLPrpDuser();

    String conditions = "";
    conditions = "PolicyNo='" + strPolicyNo + "'";
    BLClaimFacade blClaimFacade = new BLClaimFacade();
    collection = blClaimFacade.findByConditions(conditions);
    if(collection!=null){
      Iterator iterator = collection .iterator();
      strClaimNo       = new String[collection.size()];
      strDamangeDate   = new DateTime[collection.size()];
      strDamageName    = new String[collection.size()];
      dbSumPaid        = new double[collection.size()];
      arrEndCaseDate   = new DateTime[collection.size()];
      arrEndCaseDate1  = new DateTime[collection.size()];
      dbSumClaim       = new double[collection.size()];
      arrCaseNo        = new String[collection.size()];
      arrOperatorCode  = new String[collection.size()];
      arrUnderWriteName = new String[collection.size()];
      arrHandlerCode   = new String[collection.size()];
      arrHandlerName   = new String[collection.size()];
      result           = new double[collection.size()];
      i = 0;
      while (iterator.hasNext()) {
        PrpLclaimDtoBase prpLclaimDtoBase = (PrpLclaimDtoBase) iterator .next();
        strClaimNo[i]      = prpLclaimDtoBase.getClaimNo();
        strDamangeDate[i]  = prpLclaimDtoBase.getDamageStartDate();
        strDamageName[i]   = prpLclaimDtoBase.getDamageName();
        dbSumPaid[i]       = prpLclaimDtoBase.getSumPaid();
        arrEndCaseDate[i]  = prpLclaimDtoBase.getEndCaseDate();
        dbSumClaim[i]      = prpLclaimDtoBase.getSumClaim();
        arrCaseNo[i]       = prpLclaimDtoBase.getCaseNo();
        result[i]          = dbSumClaim[i]-dbSumPaid[i];
        if(!prpLclaimDtoBase.getEndCaseDate().isEmpty()){//�᰸��δ�����Ϊ0
        	result[i] = 0.0;
        }
//zhulei leave:ȡ ��������� ����......
        conditions = "ClaimNo='" + strClaimNo[i] + "'";
        BLCompensateFacade blCompensateFacade = new BLCompensateFacade();        
        collection1 = blCompensateFacade.findByConditions(conditions);
        k = 0;
        if(collection1!=null){
          Iterator iterator1 = collection1 .iterator();
          while (iterator1.hasNext()) {          	
            PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto) iterator1.next();
            arrUnderWriteName[i] = prpLcompensateDto.getUnderWriteName();
            arrHandlerCode[i] = prpLcompensateDto.getHandlerCode();
            blPrpDuser = new BLPrpDuser();
            blPrpDuser.query("UserCode='"+arrHandlerCode[i]+"'");
            arrHandlerName[i] = blPrpDuser.getArr(0).getUserName();
            break;
          }
        }
        //add by zhulei arrUnderWriteName���ܴ��null
        if(arrUnderWriteName[i]==null){
          arrUnderWriteName[i] = "";	
        }
        if(arrHandlerName[i]==null){
          arrHandlerName[i] = "";	
        }
        i++;
      }
    }
    //add by zhulei 20050923
    String strUserName = "";   //������
    String mDateTime = "";     //��������
    String strSystem = request.getParameter("System");
    UserDto user = (UserDto) session.getAttribute("user");
    if("undwrt".equals(strSystem)){
    	strUserName = request.getParameter("UserName");
    }else{
    	strUserName = user.getUserName();
    }
    Calendar cal = Calendar.getInstance(); 
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    mDateTime = formatter.format(cal.getTime());
%>