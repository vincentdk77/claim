<%--
****************************************************************************
* DESC       �����պ󳭵���ӡҳ��ʼ��������������
* AUTHOR     �� ��Ŀ��
* CREATEDATE ��2005-9-16
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%-- ����bean�ಿ�� --%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.util.*"%>
<%@page import="com.sinosoft.sysframework.common.util.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%>
<%@page import="com.sinosoft.prpall.blsvr.cb.*"%>
<%@page import="com.sinosoft.utiall.blsvr.*"%>

<%
    int i = 0;
    String strClassCode = ""; //����
    String strPolicyNo = ""; //������
    String strRegistNo = ""; //������
    String strPolicyName = ""; //������������
    String strPolicyAddress = ""; //�������˵�ַ
    String strCoinsFlag     = ""; //��������־
    String strCurrency   ="";
    double dbSumAmount   = 0.0;   //�ܱ���
    double dbDeductible = 0;      //�����
    DateTime OperateDate = new DateTime();
    DateTime InputDate = new DateTime();
    DateTime SignDate = new DateTime();
    DateTime UnderWriteEndDate = new DateTime();
    DateTime StartDate = new DateTime();
    DateTime EndDate = new DateTime();


    String strRiskCode     = ""; //���ִ���
    String strRiskName     = ""; //��������


    String[] strKindName = null;   //�ձ�����
    String[] strKindCode = null;   //�ձ����
    String[] strItemDetailName = null; //�������
    String[] strKindCurrency = null; //�ձ�ұ�
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

    //add by zhulei 20050915 �ر�Լ����Ϣ
    String[] arrEngage = null;     //��Լ��������Ϣ
    String[] arrClauseCode = null; //��Լ�����Ӵ���
    String strEngage = "";

    //add by zhulei 20050916
    String strConstructName = "";    //��������


    Collection collection = null;
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
        strRiskCode = policyDto.getPrpCmainDto().getRiskCode();
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
			  strKindCode = new String[collection.size()];
			  strKindCurrency = new String[collection.size()];
			  strItemDetailName = new String[collection.size()];
			  dbAmount    = new double[collection.size()];
			  i = 0;
				Iterator iterator = policyDto.getPrpCitemKindDtoList()
						.iterator();
				while (iterator.hasNext()) {
					PrpCitemKindDto prpCitemKindDtoTemp = (PrpCitemKindDto) iterator
							.next();
					strKindName[i] = prpCitemKindDtoTemp.getKindName();
					strKindCode[i] = prpCitemKindDtoTemp.getKindCode();
					strKindCurrency[i] = prpCitemKindDtoTemp.getCurrency();
					strItemDetailName[i] = prpCitemKindDtoTemp.getItemDetailName();
					dbAmount[i] = prpCitemKindDtoTemp .getAmount();
					dbDeductible = dbDeductible + prpCitemKindDtoTemp.getDeductible();
					i++;
				}
			}

//    if (strCoinsFlag.equals("0")) {         //�ǹ���
//        strCoinsFlag = "�ǹ���";
//    } else if (strCoinsFlag.equals("1")) {  //������
//        strCoinsFlag = "������";
//    } else if (strCoinsFlag.equals("2")) {  //����
//        strCoinsFlag = "����";
//    }
    if (strCoinsFlag.equals("0")) {
        strCoinsFlag = "��";
    } else {
        strCoinsFlag = "��";
    }

    //add by zhulei 20050915 �ر�Լ��
    if (policyDto.getPrpCengageDtoList() != null) {
    	collection = policyDto.getPrpCengageDtoList();
      arrEngage = new String[collection.size()];
      arrClauseCode = new String[collection.size()];
      i = 0;
      Iterator iterator = policyDto.getPrpCengageDtoList()
      		.iterator();
      while (iterator.hasNext()) {
      	PrpCengageDto prpCengageDto = (PrpCengageDto) iterator
      			.next();
      	arrEngage[i] = prpCengageDto.getClauses();
      	arrClauseCode[i] = prpCengageDto.getClauseCode();
      	//System.out.println("===========arrEngage[i]="+arrEngage[i]);
      	//System.out.println("===========strEngage="+strEngage);
      	//System.out.println("======================arrEngage[i].indexOf(strEngage)="+arrEngage[i].indexOf(strEngage));
      	//��Լ���ظ���ʾ
      	if(arrClauseCode[i].substring(0,1).equals("T")){
      	  if(strEngage.indexOf(arrEngage[i])<0){
      	    strEngage = strEngage + arrEngage[i] + "<br>";
          }
        }
      	i++;
      }
    }

    //add by zhulei 20050917 ������������
    String[] arrInsuredName = null;    //������������
    String[] arrInsuredNature = null;  //������������
    String[] arrInsuredFlag = null;  //������������
    BLPrpCinsured blPrpCinsured = new BLPrpCinsured();
    blPrpCinsured.getData(strPolicyNo);
    arrInsuredName = new String[blPrpCinsured.getSize()];
    arrInsuredNature = new String[blPrpCinsured.getSize()];
    arrInsuredFlag = new String[blPrpCinsured.getSize()];
    for(i=0;i<blPrpCinsured.getSize();i++){
    System.out.println("|||-------------blPrpCinsured.getArr(i).getInsuredName()--"+blPrpCinsured.getArr(i).getInsuredName());
    System.out.println("|||---------blPrpCinsured.getArr(i).getInsuredNature()---"+blPrpCinsured.getArr(i).getInsuredNature());
    	arrInsuredName[i] = blPrpCinsured.getArr(i).getInsuredName();
    	arrInsuredNature[i] = blPrpCinsured.getArr(i).getInsuredNature();
    	arrInsuredFlag[i] = blPrpCinsured.getArr(i).getInsuredFlag();
    }

    //add by zhulei 20050917 ���չ��̵�ַ
    String[] arrItemAddress = null;
    BLPrpCaddress blPrpCaddress = new BLPrpCaddress();
    blPrpCaddress.getData(strPolicyNo);
    arrItemAddress = new String[blPrpCaddress.getSize()];
  	for(i=0;i<blPrpCaddress.getSize();i++){
    	arrItemAddress[i] = blPrpCaddress.getArr(i).getAddressName();
    	System.out.println("=================test==========arrItemAddress="+arrItemAddress[i]);
    }

    //add by zhulei 20050917 ������Ϣ
    String strConstructionName = ""; //��������
    String strStartFixDate = "";     //��װ���ڣ��������ڣ�
    String strEndFixDate = "";       //��װֹ�ڣ�����ֹ�ڣ�
    String strTestPeriod = "";       //�Գ�����
    String strTestStartDate = "";    //�Գ�����
    String strTestEndDate = "";      //�Գ�ֹ��
    String strStartAddDate = "";     //��֤����
    String strEndAddDate = "";       //��ֹ֤��
    BLPrpCmainConstruct blPrpCmainConstruct = new BLPrpCmainConstruct();
    blPrpCmainConstruct.getData(strPolicyNo);
    if(blPrpCmainConstruct.getSize()>0){
    	strConstructionName = blPrpCmainConstruct.getArr(0).getConstructName();

    	strStartFixDate     = blPrpCmainConstruct.getArr(0).getStartFixDate();
    	strEndFixDate       = blPrpCmainConstruct.getArr(0).getEndFixDate();
    	strTestPeriod       = blPrpCmainConstruct.getArr(0).getTestPeriod();
    	strTestStartDate    = blPrpCmainConstruct.getArr(0).getTestStartDate();
    	strTestEndDate      = blPrpCmainConstruct.getArr(0).getTestEndDate();
    	strStartAddDate     = blPrpCmainConstruct.getArr(0).getStartAddDate();
    	strEndAddDate       = blPrpCmainConstruct.getArr(0).getEndAddDate();
    }

    //add by zhulei 20050916 �⳥�޶���Ϣ��������ҵ��jarȡ���ݣ���01���಻ͬ��������Ҫ�����鴦��
    String[] strLimitType  = null;   //�⳥�޶�/��������
    String[] arrLimitTypeName = null; //�⳥�޶�/������������
    String[] strLimitCurrency = null;   //���޶�ұ�
    double[] dbLimitFee    = null;   //�⳥�޶�
    String[] arrLimitGrade = null;   //�޶�/���⼶��
    
    String strCurrency10 = "";  //ÿ���¹��⳥�޶�ұ�
    String strCurrency07 = "";  //�Ʋ���ʧ�⳥�޶�ұ�
    String strCurrency06 = "";  //���������⳥�޶�ұ�
    String strCurrency05 = "";  //ÿ���⳥�޶�ұ�
    String strCurrency09 = "";  //ÿ���¹ʾ�������ұ�
    String strCurrency11 = "";  //�ۼ��⳥�޶�ұ�
    
    double dbLimit10 = 0;      //ÿ���¹��⳥�޶�
    double dbLimit07 = 0;      //�Ʋ���ʧ�⳥�޶�
    double dbLimit06 = 0;      //���������⳥�޶�
    double dbLimit05 = 0;      //ÿ���⳥�޶�
    double dbLimit09 = 0;      //ÿ���¹ʾ�������
    double dbLimit11 = 0;      //�ۼ��⳥�޶�ұ�
    
    BLPrpDlimit blPrpDlimit = new BLPrpDlimit();
    BLPrpClimit blPrpClimit = new BLPrpClimit();
    String strSQL = "PolicyNo='" + strPolicyNo + "'";
    blPrpClimit.query(strSQL);
    strLimitType  = new String[blPrpClimit.getSize()];
    arrLimitTypeName  = new String[blPrpClimit.getSize()];
    strLimitCurrency   = new String[blPrpClimit.getSize()];
    dbLimitFee    = new double[blPrpClimit.getSize()];
    arrLimitGrade = new String[blPrpClimit.getSize()];
    for(i=0;i<blPrpClimit.getSize();i++){
    	strLimitType[i]  = blPrpClimit.getArr(i).getLimitType();
    	strLimitCurrency[i]   = blPrpClimit.getArr(i).getCurrency();
    	dbLimitFee[i]    = Double.parseDouble(blPrpClimit.getArr(i).getLimitFee());
    	arrLimitGrade[i] = blPrpClimit.getArr(i).getLimitGrade();
    	
    	if(strLimitType[i].equals("10")){  //ÿ���¹��⳥�޶�
    		dbLimit10 = Double.parseDouble(blPrpClimit.getArr(i).getLimitFee());
    		strCurrency10 = blPrpClimit.getArr(i).getCurrency();
    	} else if(strLimitType[i].equals("07")){  //�Ʋ���ʧ�⳥�޶�
    		dbLimit07 = Double.parseDouble(blPrpClimit.getArr(i).getLimitFee());
    		strCurrency07 = blPrpClimit.getArr(i).getCurrency();
    	} else if(strLimitType[i].equals("06")){  //���������⳥�޶�
    		dbLimit06 = Double.parseDouble(blPrpClimit.getArr(i).getLimitFee());
    		strCurrency06 = blPrpClimit.getArr(i).getCurrency();
    	} else if(strLimitType[i].equals("05")){  //ÿ���⳥�޶�
    		dbLimit05 = Double.parseDouble(blPrpClimit.getArr(i).getLimitFee());
    		strCurrency05 = blPrpClimit.getArr(i).getCurrency();
    	} else if(strLimitType[i].equals("09")){  //ÿ���¹ʾ�������
    		dbLimit09 = Double.parseDouble(blPrpClimit.getArr(i).getLimitFee());
    		strCurrency09 = blPrpClimit.getArr(i).getCurrency();
    	} else if(strLimitType[i].equals("11")){  //ÿ���¹ʾ�������
    		dbLimit11 = Double.parseDouble(blPrpClimit.getArr(i).getLimitFee());
    		strCurrency11 = blPrpClimit.getArr(i).getCurrency();
    	}
    	
    	blPrpDlimit = new BLPrpDlimit();
    	blPrpDlimit.query("RiskCode='"+strRiskCode+"' AND LimitCode='"+strLimitType[i]+"'");
    	if(blPrpDlimit.getSize()>0){
    	  arrLimitTypeName[i] = blPrpDlimit.getArr(0).getLimitCName();
    	}
    }
%>