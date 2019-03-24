<%--
****************************************************************************
* DESC       �����պ󳭵���ӡҳ��ʼ��
* AUTHOR     �� ��Ŀ��
* CREATEDATE ��2005-9-16
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
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpClimit"%>
<%@ page import="java.util.*"%>

<%
    int i = 0;
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

    //add by zhulei 20050917 ���յ�ַ
    String[] arrKindAddress = null;

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
    String[] arrEngage = null;      //������Լ��Ϣ
    String[] arrClauseCode = null;  //����/��Լ��Ϣ����
    String[] arrTitleFlag = null;   //����/���� ��־
    String strEngage = "";          //��Լ��Ϣ����

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

    //if (strCoinsFlag.equals("0")) {         //�ǹ���
    //    strCoinsFlag = "�ǹ���";
    //} else if (strCoinsFlag.equals("1")) {  //������
    //    strCoinsFlag = "������";
    //} else if (strCoinsFlag.equals("2")) {  //����
    //    strCoinsFlag = "����";
    //}
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
      arrTitleFlag = new String[collection.size()];
      i = 0;
      Iterator iterator = policyDto.getPrpCengageDtoList()
      		.iterator();
      while (iterator.hasNext()) {
      	PrpCengageDto prpCengageDto = (PrpCengageDto) iterator
      			.next();
      	arrEngage[i] = prpCengageDto.getClauses();
      	arrTitleFlag[i] =prpCengageDto.getTitleFlag();
      	arrClauseCode[i] = prpCengageDto.getClauseCode();
      	//if(arrTitleFlag[i].equals("0")){
      	if(arrClauseCode[i].substring(0,1).equals("T")){
      	  strEngage = strEngage + arrEngage[i] + "<br>";
      	}
      	i++;
      }
    }

    //add by zhulei 20050917 ���յ�ַ
    if(policyDto.getPrpCaddressDtoList() != null){
    	collection = policyDto.getPrpCaddressDtoList();
      arrKindAddress = new String[collection.size()];
      i = 0;
      Iterator iterator = policyDto.getPrpCaddressDtoList()
      		.iterator();
      while (iterator.hasNext()) {
      	PrpCaddressDto prpCaddressDto = (PrpCaddressDto) iterator
      			.next();
      	arrKindAddress[i] = prpCaddressDto.getAddressName();
      	System.out.println("================arrKindAddress=="+arrKindAddress[i]);
      	i++;
      }
    }

    //add by zhulei 20050916 �⳥�޶���Ϣ��������ҵ��jarȡ���ݣ�
    String strLimitType = "";  //�⳥�޶�/��������
    String strCurrency01 = "";  //ÿ���¹��⳥�޶�ұ�
    String strCurrency03 = "";  //�Ʋ���ʧ�⳥�޶�ұ�
    String strCurrency07 = "";  //���������⳥�޶�ұ�
    String strCurrency02 = "";  //ÿ���⳥�޶�ұ�
    String strCurrency05 = "";  //ÿ���¹ʾ�������ұ�
    
    double dbLimit01 = 0;      //ÿ���¹��⳥�޶�ۼƣ�
    double dbLimit03 = 0;      //�Ʋ���ʧ�⳥�޶�ۼƣ�
    double dbLimit07 = 0;      //���������⳥�޶�ۼƣ�
    double dbLimit02 = 0;      //ÿ���⳥�޶�ۼƣ� 
    double dbLimit05 = 0;      //ÿ���¹ʾ������⣨�ۼƣ� 
    String strLimit01 = "";   //ÿ���¹��⳥�޶��ʾ��ʽ0.00��
    String strLimit03 = "";   //�Ʋ���ʧ�⳥�޶��ʾ��ʽ0.00��
    String strLimit07 = "";   //���������⳥�޶��ʾ��ʽ0.00��
    String strLimit02 = "";   //ÿ���⳥�޶��ʾ��ʽ0.00��v
    String strLimit05 = "";   //ÿ���¹ʾ������⣨��ʾ��ʽ0.00��
    BLPrpClimit blPrpClimit = new BLPrpClimit();
    String strSQL = "PolicyNo='" + strPolicyNo + "'";
    blPrpClimit.query(strSQL);
    for(i=0;i<blPrpClimit.getSize();i++){
    	strLimitType = blPrpClimit.getArr(i).getLimitType();
    	if(strLimitType.equals("01")){  //ÿ���¹��⳥�޶�
    		//ȡ���һ����Ϣ��ע��������ȡ���ֵ�ĺͣ�
    		//dbLimit01 = dbLimit01 + Double.parseDouble(blPrpClimit.getArr(i).getLimitFee());
    		dbLimit01 = Double.parseDouble(blPrpClimit.getArr(i).getLimitFee());
    		strCurrency01 = blPrpClimit.getArr(i).getCurrency();
    	} else if(strLimitType.equals("03")){  //�Ʋ���ʧ�⳥�޶�
    		//ȡ���һ����Ϣ��ע��������ȡ���ֵ�ĺͣ�
    		//dbLimit03 = dbLimit03 + Double.parseDouble(blPrpClimit.getArr(i).getLimitFee());
    		dbLimit03 = Double.parseDouble(blPrpClimit.getArr(i).getLimitFee());
    		strCurrency03 = blPrpClimit.getArr(i).getCurrency();
    	} else if(strLimitType.equals("07")){  //���������⳥�޶�
    		//ȡ���һ����Ϣ��ע��������ȡ���ֵ�ĺͣ�
    		//dbLimit07 = dbLimit07 + Double.parseDouble(blPrpClimit.getArr(i).getLimitFee());
    		dbLimit07 = Double.parseDouble(blPrpClimit.getArr(i).getLimitFee());
    		strCurrency07 = blPrpClimit.getArr(i).getCurrency();
    	} else if(strLimitType.equals("02")){  //ÿ���⳥�޶�
    		//ȡ���һ����Ϣ��ע��������ȡ���ֵ�ĺͣ�
    		//dbLimit02 = dbLimit02 + Double.parseDouble(blPrpClimit.getArr(i).getLimitFee());
    		dbLimit02 = Double.parseDouble(blPrpClimit.getArr(i).getLimitFee());
    		strCurrency02 = blPrpClimit.getArr(i).getCurrency();
    	} else if(strLimitType.equals("05")){  //ÿ���¹ʾ�������
    		//ȡ���һ����Ϣ��ע��������ȡ���ֵ�ĺͣ�
    		//dbLimit05 = dbLimit05 + Double.parseDouble(blPrpClimit.getArr(i).getLimitFee());
    		dbLimit05 = Double.parseDouble(blPrpClimit.getArr(i).getLimitFee());
    		strCurrency05 = blPrpClimit.getArr(i).getCurrency();
    	}
    }
    strLimit01 = new DecimalFormat("0.00").format(dbLimit01);
    strLimit03 = new DecimalFormat("0.00").format(dbLimit03);
    strLimit07 = new DecimalFormat("0.00").format(dbLimit07);
    strLimit02 = new DecimalFormat("0.00").format(dbLimit02);
    strLimit05 = new DecimalFormat("0.00").format(dbLimit05);
%>