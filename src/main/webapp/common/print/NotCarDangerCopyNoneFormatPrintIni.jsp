<%--

****************************************************************************

* DESC       �����պ󳭵���ӡҳ��ʼ��

* AUTHOR     ��wangwei

* CREATEDATE ��2005-5-28

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

<%@page import="com.sinosoft.claim.bl.facade.BLPrpJpayRefRecFacade"%>


<%
//�����չ�������
 String[] itemDetailName = null; 
 String[] currency = null;
 double[] everyTimeLimit = null; 
 double[] everyTimePropLimit = null; 
 double[] everyTimePersonLimit = null; 
 double[] everyPersonLimit = null; 
 String[] kindCode = null; 
 String[] kindNamef = null; 
 String[] currencyf = null;
 double[] dbAmountf = null; 
 double[] limitAmount = null;
 double[] everyTimeLimitf = null; 
 int[] itemKindNo =null; 
 String[] flag =null;
  String[] limitType =null;
  String strflag =null;
  double[] limitNo=null;
  int j=0;
  Collection collectionLimit = null;




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

    

    String[] strEndorseNo = null; 

    String[] strEndorType = null;

    DateTime[] strEndorDate = null;

    String[] strUnderWriteName = null;

    

    int[] iPlanNo = null;

    String[] strPlanEndorNo = null;

    double[] dbPlanFee = null;

    double[] dbRealFee = null;

    DateTime[] strPayDate = null;

    String conditon = "";//��ѯ����ʱ�������
    BLPrpJpayRefRecFacade blPrpJpayRefRecFacade = new BLPrpJpayRefRecFacade();
    

    

    

    

    

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

        strPolicyName = policyDto.getPrpCmainDto().getInsuredName();
System.out.println("=================[ strPolicyName ]" +strPolicyName);
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
			    //����������ƴ��
			    conditon = "rec.certino='" + strPolicyNo + "' and rec.serialno ='"+prpCplanDtoTemp.getSerialNo()+"' and rec.payrefreason='"+prpCplanDtoTemp.getPayReason()+"'";
			    //strPayDate[i] = prpCplanDtoTemp.getPlanDate();
			    if(strPlanEndorNo[i]!=null && !"".equals(strPlanEndorNo[i])){
			       conditon = "rec.certino='" + strPlanEndorNo[i] + "' and rec.payrefreason='"+prpCplanDtoTemp.getPayReason()+"'";
			    }
			    strPayDate[i] = blPrpJpayRefRecFacade.getRefDate(conditon);

			    i++;

				}

			}

			
//��������ʾ���ո������޶�
		if (policyDto.getPrpCitemKindDtoList() != null) {
 if (strClassCode.equals("04")){
 collection = policyDto.getPrpCitemKindDtoList();
     
   flag = new String[collection.size()];  
   kindCode = new String[collection.size()];
   strKindName = new String[collection.size()];
   itemKindNo    = new int[collection.size()];  //01 ÿ�� 
   itemDetailName = new String[collection.size()];  //Ӫҵ����
    currency = new String[collection.size()];
    dbAmount    = new double[collection.size()];  //04 �ۻ�
    limitAmount = new double[collection.size()];  //�⳥�޶�
   // everyTimeLimit    = new double[collection.size()];  //01 ÿ�� 
   // everyTimePropLimit    = new double[collection.size()]; //03 ÿ�βƲ�
    //everyTimePersonLimit    = new double[collection.size()]; //07 ÿ����
    //everyPersonLimit    = new double[collection.size()];  //02 ÿ��
    
     i = 0;
     Iterator iterator = policyDto.getPrpCitemKindDtoList().iterator();
    System.out.println("ר������-----1-------------"); 
     while (iterator.hasNext()) {
     System.out.println("ר������-----111------------"); 
		PrpCitemKindDto prpCitemKindDtoTemp = (PrpCitemKindDto) iterator.next();
		   flag[i]=prpCitemKindDtoTemp.getFlag(); System.out.println("ר������-flag-------"+flag[i]); 
		   itemKindNo[i]=prpCitemKindDtoTemp.getItemKindNo(); System.out.println("ר������-itemKindNo-------"+itemKindNo[i]);
		   limitAmount[i]=prpCitemKindDtoTemp.getAmount();
		   currency[i]=prpCitemKindDtoTemp.getCurrency(); System.out.println("ר������-currency-------"+currency[i]);
		   itemDetailName[i] =  prpCitemKindDtoTemp.getItemDetailName(); System.out.println("ר������-itemDetailName-------"+itemDetailName[i]);
		   strKindName[i] = prpCitemKindDtoTemp.getKindName(); System.out.println("ר������-strKindName-------"+strKindName[i]);
		   kindCode[i]= prpCitemKindDtoTemp.getKindCode(); System.out.println("ר������-flag-------"+flag[i]);
		  System.out.println("ר������-----2------------"); 
		  
		   collectionLimit = policyDto.getPrpClimitDtoList();
		   
		    //limitType = new String[collectionLimit.size()]; 
		     limitNo = new double[collectionLimit.size()];  
		   
		   Iterator it = policyDto.getPrpClimitDtoList().iterator();
		   j=0;
		  while (it.hasNext()) {
		  System.out.println("ר������-----3-------------");
		    PrpClimitDto prpClimitDtoTemp = (PrpClimitDto) it.next();
		    limitNo[j]= prpClimitDtoTemp.getLimitNo();
		   // limitType[j]= prpClimitDtoTemp.getLimitType();
		    if(limitNo[j]==itemKindNo[i]){ 
		    System.out.println("ר������-----33---j---"+j);
		      /*if(limitType[j].equals("04")){dbAmount[i] = prpClimitDtoTemp.getLimitFee(); }
		      else if(limitType[j].equals("01")){everyTimeLimit[i] = prpClimitDtoTemp.getLimitFee(); }
		      else if(limitType[j].equals("03")){everyTimePropLimit[i] = prpClimitDtoTemp.getLimitFee(); }
		      else if(limitType[j].equals("07")){everyTimePersonLimit[i] = prpClimitDtoTemp.getLimitFee(); }
		      else if(limitType[j].equals("02")){everyPersonLimit[i] = prpClimitDtoTemp.getLimitFee(); }*/
		    }else{  System.out.println("ר������-----3333---j---"+j);}
		   j++;
		    System.out.println("ר������-----4-------------");
		  }
	 i++;
     }
 
}//����
else {
    	  collection = policyDto.getPrpCitemKindDtoList();

		  strKindName = new String[collection.size()];

		  dbAmount    = new double[collection.size()];

		  i = 0;

			Iterator iterator = policyDto.getPrpCitemKindDtoList().iterator();

			while (iterator.hasNext()) {

				PrpCitemKindDto prpCitemKindDtoTemp = (PrpCitemKindDto) iterator.next();

				strKindName[i] = prpCitemKindDtoTemp.getKindName();

				dbAmount[i] = prpCitemKindDtoTemp .getAmount();

				i++;

				}
  }
}



    if (strCoinsFlag.equals("0")) {         //�ǹ���

        strCoinsFlag = "�ǹ���";

    } else if (strCoinsFlag.equals("1")) {  //������

        strCoinsFlag = "������";

    } else if (strCoinsFlag.equals("2")) {  //����

        strCoinsFlag = "����";

    }

%>