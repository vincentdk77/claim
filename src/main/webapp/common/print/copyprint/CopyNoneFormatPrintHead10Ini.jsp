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
<%@page import="com.sinosoft.prpall.blsvr.cb.*"%>
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
    
    //modify by zhulei ���ӻ������ơ��ձ������
    String[] strKindName = null;   //�ձ�����
    String[] strItemDetailName = null;   //��������
    double dbDeductible = 0;    //�����
    
    double[] dbAmount   = null;  //�ձ𱣶�
    String strKindNameTemp = ""; //�ձ����ƣ����ܣ�
    String strItemDetailNameTemp = ""; //�ձ����ƣ����ܣ�
    
    String[] strEndorseNo = null; 
    String[] strEndorType = null;
    DateTime[] strEndorDate = null;
    String[] strUnderWriteName = null;
    
    int[] iPlanNo = null;
    String[] strPlanEndorNo = null;
    double[] dbPlanFee = null;
    double[] dbRealFee = null;
    DateTime[] strPayDate = null;
    
    //add by zhulei 20050915 ����·��
    String strSiteName      = "";    //����·��
    String strStartSiteName = "";    //���˵�
    String strViaSiteName   = "";    //��ת��
    String strEndSiteName   = "";    //Ŀ�ĵ�
    

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
			  strItemDetailName = new String[collection.size()];
			  dbAmount    = new double[collection.size()];
			  i = 0;
				Iterator iterator = policyDto.getPrpCitemKindDtoList()
						.iterator();
				while (iterator.hasNext()) {
					PrpCitemKindDto prpCitemKindDtoTemp = (PrpCitemKindDto) iterator
							.next();
					strKindName[i] = prpCitemKindDtoTemp.getKindName();
					strItemDetailName[i] = prpCitemKindDtoTemp.getItemDetailName();
					//add by zhulei 20050914 �ձ𡢻�������
					
					strKindNameTemp = strKindNameTemp + strKindName[i] + "&nbsp;&nbsp;&nbsp;&nbsp;";
					//�������Ʋ�Ҫ�ظ�
					if(strItemDetailNameTemp.indexOf(strItemDetailName[i])<0){
					  strItemDetailNameTemp = strItemDetailNameTemp + strItemDetailName[i] + "&nbsp;&nbsp;&nbsp;&nbsp;";
					}
					dbAmount[i] = prpCitemKindDtoTemp .getAmount();
					dbDeductible = dbDeductible + prpCitemKindDtoTemp.getDeductible();
					i++;
				}
			}
			
			//add by zhulei 20050915 ����·����Ϣ(mainCargo1������)
    if (policyDto.getPrpCmainCargoDto() != null) {
      strStartSiteName = policyDto.getPrpCmainCargoDto().getStartSiteName();    //���˵�
      strViaSiteName   = policyDto.getPrpCmainCargoDto().getViaSiteName();    //��ת��
      strEndSiteName   = policyDto.getPrpCmainCargoDto().getEndSiteName();    //Ŀ�ĵ�
      strSiteName = "���˵أ�" + strStartSiteName;
      if(strViaSiteName!=null && !strViaSiteName.equals("")){
      	strSiteName = strSiteName + "   ��ת�أ�" + strViaSiteName;
      }
      strSiteName = strSiteName + "   Ŀ�ĵأ�" + strEndSiteName;
		}
                        ///////////////////////////////////////////
    //modefy by zhulei 20050923
//    if (strCoinsFlag.equals("0")) {         //�ǹ���
//        strCoinsFlag = "�ǹ���";
//    } else if (strCoinsFlag.equals("1")) {  //������
//        strCoinsFlag = "������";
//    } else if (strCoinsFlag.equals("2")) {  //����
//        strCoinsFlag = "����";
//    }
    if (strCoinsFlag.equals("0")) {         //�ǹ���
        strCoinsFlag = "��";
    } else {                                  //������������
        strCoinsFlag = "��";
    }
    
    //add by zhulei 20050921 ԤԼЭ��
    String strMainPolicyNo = "";
    BLPrpCmainSub blPrpCmainSub = new BLPrpCmainSub();
    blPrpCmainSub.query("PolicyNo='"+strPolicyNo+"'");
    if(blPrpCmainSub.getSize()>0){
      strMainPolicyNo = blPrpCmainSub.getArr(0).getMainPolicyNo();
    }
    
%>