<%@ page pageEncoding="GBK" %>
<%--
****************************************************************************
* DESC       �����պ󳭵���ӡҳ��ʼ��
* AUTHOR     �� ��Ŀ��
* CREATEDATE ��2005-9-15
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%-- ����bean�ಿ�� --%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.util.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.sysframework.common.util.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDkind"%>
<%@page import="com.sinosoft.prpall.blsvr.cb.*"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpCitemKindAgriFacade"%>

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
    String strSumAmount  = "";    //�ܱ����ʽ��ʾ
    double dbDeductible = 0;      //�����
    DateTime OperateDate = new DateTime();
    DateTime InputDate = new DateTime();
    DateTime SignDate = new DateTime();
    DateTime UnderWriteEndDate = new DateTime();
    DateTime StartDate = new DateTime();
    DateTime EndDate = new DateTime();
    DateTime loanStartDate = new DateTime();
    DateTime loanEndDate = new DateTime();
    
    //add by miaowenjun 20060428 �����ճ���������Ϣ
    String[] strAddressName = null;      //����ס����ϸ��ַ
    String[] strStructure = null;        //����ס���ṹ
    double[] dblBuildArear = null;		 //����ס���������
    String strLoanUsage = "";            //��������
    String strLoanBank = "";             //��������,������
    String strWarrantorCode = "";        //������������
    String strLoanNo2 = "";              //���ݹ��ü�
    double dblLoanAmount = 0.0d;         //������
    
    String strRiskCode     = ""; //���ִ���
    String strRiskName     = ""; //��������
    
    //add by zhulei 20050916 �������ա������ա������ա����𸽼���
    String[] strKindCode = null;   //�ձ����
    String[] strKindName = null;   //�ձ�����
    String[] strKindFlag = null;   //�ձ��־
    String[] strItemDetailName = null;   //�������
    String[] strIMEI = null;   //�������
    String[] strFamilyName = null;   //������������
    int[] strKindAddress = null; //�ձ��ַ
    String[] strCalculateFlag = null;   //�ձ��־���������ա������ա������ա����𸽼���
    double[] dbAmount   = null;  //�ձ𱣶�
    String[] strAmount  = null;  //�ձ𱣶��ʽ��ʾ
    double[] dbUnitAmount   = null;  //�ձ𱣶�
    String[] strUnitAmount  = null;  //�ձ𱣶��ʽ��ʾ
    String[] strQuantity  = null;  //�ձ𱣶��ʽ��ʾ
    double dbAmount100  = 0;     //�������ܱ���
    String strAmount100 = "0.00";     //�������ܱ�����ʾ��ʽ
    BLPrpDkind blPrpDkind = new BLPrpDkind();
    String strSQL = "";
    
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
    String[] arrClauseCode = null;    //��Լ�����Ӵ���
    String[] arrEngage = null;
    String strEngage = "";
    
    Collection collection = null;
    UICodeAction uiCodeAction = new UICodeAction();
    
		

    RegistDto registDto = (RegistDto) request.getAttribute("registDto");
    PolicyDto policyDto = (PolicyDto) request.getAttribute("policyDto");
    EndorseDto endorseDto = (EndorseDto) request.getAttribute("endorseDto");
    
    //add by miaowenjun 20060428
    if(policyDto != null && policyDto.getPrpCaddressDtoList() != null){
    	for(int index=0;index<policyDto.getPrpCaddressDtoList().size();index++){
    		strAddressName = new String[policyDto.getPrpCaddressDtoList().size()];
    		PrpCaddressDto prpCaddressDto = (PrpCaddressDto)((ArrayList)policyDto.getPrpCaddressDtoList()).get(index);
    		strAddressName[index] = prpCaddressDto.getAddressName();
    	}
    }
    
    if(policyDto != null && policyDto.getPrpCitemHouseDtoList() != null){
    	for(int index=0;index<policyDto.getPrpCitemHouseDtoList().size();index++){
    		strStructure = new String[policyDto.getPrpCitemHouseDtoList().size()];
    		dblBuildArear = new double[policyDto.getPrpCitemHouseDtoList().size()];
	    	PrpCitemHouseDto prpCitemHouseDto = (PrpCitemHouseDto)((ArrayList)policyDto.getPrpCitemHouseDtoList()).get(index);
    		if("0".equals(prpCitemHouseDto.getStructure())){
    			strStructure[index] = "�ֽ������";
    		}else if("1".equals(prpCitemHouseDto.getStructure())){
    			strStructure[index] = "�����";
    		}else if("9".equals(prpCitemHouseDto.getStructure())){
    			strStructure[index] = "שľ��";
    		}
    		dblBuildArear[index] = prpCitemHouseDto.getBuildArea();
    	}
    }
    
    if(policyDto != null && policyDto.getPrpCmainLoanDto() != null){
    	if("0".equals(policyDto.getPrpCmainLoanDto().getLoanUsage())){
	    	strLoanUsage = "�ַ�";
		}else{
			strLoanUsage = "�ڷ�";
		}
		strLoanBank = policyDto.getPrpCmainLoanDto().getLoanBankName();
		strWarrantorCode = policyDto.getPrpCmainLoanDto().getWarrantorCode();
		strLoanNo2 = policyDto.getPrpCmainLoanDto().getLoanNo2();
		dblLoanAmount = policyDto.getPrpCmainLoanDto().getLoanAmount();
		loanStartDate = policyDto.getPrpCmainLoanDto().getLoanStartDate();
    loanEndDate = policyDto.getPrpCmainLoanDto().getLoanEndDate();
    }
    //add by miaowenjun 20060428
    
    if(registDto!=null && registDto.getPrpLregistDto()!=null){
        strPolicyNo = registDto.getPrpLregistDto().getPolicyNo();
        strClassCode = registDto.getPrpLregistDto().getClassCode();
        strRegistNo = registDto.getPrpLregistDto().getRegistNo();
    }
    if(policyDto!=null && policyDto.getPrpCmainDto()!=null){
        strPolicyName = policyDto.getPrpCmainDto().getInsuredName(); //modify by kangzhen
        strPolicyAddress = policyDto.getPrpCmainDto().getAppliAddress();
        strCoinsFlag= policyDto.getPrpCmainDto().getCoinsFlag().toString();
        dbSumAmount = policyDto.getPrpCmainDto().getSumAmount();
        strSumAmount = new DecimalFormat("0.00").format(policyDto.getPrpCmainDto().getSumAmount());
        
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
    	  strKindCode = new String[collection.size()];
			  strKindName = new String[collection.size()];
			  strKindFlag = new String[collection.size()];
			  strItemDetailName = new String[collection.size()];
			  strIMEI = new String[collection.size()];
			  strFamilyName = new String[collection.size()];
			  strKindAddress = new int[collection.size()];
			  dbAmount    = new double[collection.size()];
			  dbUnitAmount    = new double[collection.size()];
			  strAmount   = new String[collection.size()];
			  strUnitAmount   = new String[collection.size()];
			  strQuantity   = new String[collection.size()];
			  
			  strCalculateFlag = new String[collection.size()];
			  i = 0;
				Iterator iterator = policyDto.getPrpCitemKindDtoList().iterator();
				while (iterator.hasNext()) {
					PrpCitemKindDto prpCitemKindDtoTemp = (PrpCitemKindDto) iterator.next();
					strKindCode[i] = prpCitemKindDtoTemp.getKindCode();
					strKindName[i] = prpCitemKindDtoTemp.getKindName();

					strKindFlag[i] = prpCitemKindDtoTemp.getFlag();

					strItemDetailName[i] = prpCitemKindDtoTemp.getItemDetailName();
					strIMEI[i] = prpCitemKindDtoTemp.getRemark();
					strFamilyName[i] = prpCitemKindDtoTemp.getFamilyName();
                    strKindAddress[i] = prpCitemKindDtoTemp.getAddressNo();

					dbAmount[i] = prpCitemKindDtoTemp .getAmount();
                    dbUnitAmount[i] = prpCitemKindDtoTemp .getUnitAmount();
					strAmount[i] = new DecimalFormat("0.00").format(prpCitemKindDtoTemp .getAmount());
                    strUnitAmount[i] = new DecimalFormat("0.00").format(prpCitemKindDtoTemp .getUnitAmount());
                    //yx
                    //if(strRiskCode.equals("3224"))
                    if("3101,3224,3201,3204,3238,3228,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3192,3196,3163,3168,3169,3182".indexOf(strRiskCode)>-1)
                    {

        					//PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) iter.next();
        					PrpCitemKindAgriDto prpCitemKindAgriDto = new PrpCitemKindAgriDto(); 
        					prpCitemKindAgriDto = new BLPrpCitemKindAgriFacade().findByPrimaryKey(prpCitemKindDtoTemp.getPolicyNo(), prpCitemKindDtoTemp.getItemKindNo(), prpCitemKindDtoTemp.getKindCode());
        					strQuantity[i]=new DecimalFormat("0.00").format(prpCitemKindAgriDto.getGrossQuantity());
        			
                    }else
                    {
                    	strQuantity[i] = new DecimalFormat("0.00").format(prpCitemKindDtoTemp .getQuantity());
                    }
                    dbDeductible = dbDeductible + prpCitemKindDtoTemp.getDeductible();

					//add by zhulei 20050916 ��KindCode��PrpDcode���CalculateFlag���Ա���ʾ��ʱ��ȷ�������ա������ա������ա����𸽼���
					strSQL = "RiskCode='" + strRiskCode + "' AND KindCode='" + strKindCode[i] +"'";

					blPrpDkind = new BLPrpDkind();

					blPrpDkind.query(strSQL);
					if(blPrpDkind!=null&&blPrpDkind.getSize()>0){						
						strCalculateFlag[i] = blPrpDkind.getArr(0).getCalculateFlag();
					}else{
						strCalculateFlag[i] = null;
					}
					//add by zhulei 20050926 �������ܱ���
					if("100".equals(strKindCode[i])){
					  dbAmount100 = dbAmount100 + dbAmount[i];
					}
					
					i++;
					  
				}
				
				strAmount100 = new DecimalFormat("0.00").format(dbAmount100);
			}

    //modify by zhulei 20050926
    if (strCoinsFlag.equals("0")) {         
        strCoinsFlag = "��";
    } else if (strCoinsFlag.equals("1")) {
        strCoinsFlag = "��";
    }
//    if (strCoinsFlag.equals("0")) {         //�ǹ���
//        strCoinsFlag = "�ǹ���";
//    } else if (strCoinsFlag.equals("1")) {  //������
//        strCoinsFlag = "������";
//    } else if (strCoinsFlag.equals("2")) {  //����
//        strCoinsFlag = "����";
//    }
    
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
      	//��Լ���ظ���ʾ��ע��Ҫ���ָ�����,arrClauseCode[i]�ĵ�һλ��T��
      	if(arrClauseCode[i].substring(0,1).equals("T")){
          if(strEngage.indexOf(arrEngage[i])<0){
      	    strEngage = strEngage + arrEngage[i] + "<br>";
          }
        }
      	i++;
      }
    }
    
  //add by zhulei 20051006 ������ʧ���֣�ë���󡢹�������
  int strGrossProfitMonths = 0;   //ë������
  int strWageMonths = 0;          //ë������
  BLPrpCitemProp blPrpCitemProp = new BLPrpCitemProp();
  blPrpCitemProp.query("PolicyNo='"+ strPolicyNo +"'");
  if(blPrpCitemProp.getSize()>0){
  	strGrossProfitMonths = blPrpCitemProp.getArr(0).getGrossProfitMonths();
  	strWageMonths = blPrpCitemProp.getArr(0).getWageMonths();
  }
%>