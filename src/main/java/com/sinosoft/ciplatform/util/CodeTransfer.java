package com.sinosoft.ciplatform.util;

import java.util.HashMap;
import java.util.Map;



public class CodeTransfer {
	private Map platFormMap = new HashMap();
	private Map systemMap = new HashMap();
	//ע��ԭ��
	public static CodeTransfer CancelCause=new CodeTransfer("CodeTransfer");

	/**
	 * �¹����δ���
	 */ 
	public static CodeTransfer IndemnityDuty = new CodeTransfer("IndemnityDuty");
	/**
	 * �����������
	 */
	public static CodeTransfer SelfPayFlag	= new CodeTransfer("SelfPayFlag");
	/**
	 * �¹ʴ���ʽ����
	 */
	public static CodeTransfer ManageType = new CodeTransfer("ManageType");
	/**
	 * �ֳ�������
	 */ 
	public static CodeTransfer FieldType = new CodeTransfer("FieldType");
	/**
	 * ��Ա��ͨ״̬����
	 */ 
	public static CodeTransfer TrafficType = new CodeTransfer("TrafficType");
	/**
	 * ������Աҽ�����ʹ���
	 */ 
	public static CodeTransfer MedicalType = new CodeTransfer("MedicalType");
	/**
	 * �¹����δ���
	 */
	public static CodeTransfer IndemnityDuty1 = new CodeTransfer("IndemnityDuty1");
	/**
	 * ��������
	 */
	public static CodeTransfer LicenseKindCode = new CodeTransfer("LicenseKindCode");
	/**
	 * ��˾����
	 */
	public static CodeTransfer ClaimCompany = new CodeTransfer("ClaimCompany");
	/**
	 * �¹ʴ�����
	 */
	public static CodeTransfer AccidentDep = new CodeTransfer("AccidentDep");
	/**
	 * ֤������
	 */
	public static CodeTransfer CertiType = new CodeTransfer("CertiType");
	/**
	 * ��֤����
	 */
	public static CodeTransfer DocType = new CodeTransfer("DocType");
	
	/**
	 * �渶ԭ��
	 */
	public static CodeTransfer PrePayCause = new CodeTransfer("PrePayCause");
	
	/**
	 * ��ʧ��ϸ����
	 */
	public static CodeTransfer LossTypeDetail = new CodeTransfer("LossTypeDetail");
	
	/**
	 *  �ձ���� 
	 */
	public static CodeTransfer KindCode = new CodeTransfer("KindCode");
	/**
	 *  ��������
	 */
	public static CodeTransfer SHKindType = new CodeTransfer("SHKindType");
	/**
	 *  ����ԭ�����
	 */
	public static CodeTransfer LossCauseCode = new CodeTransfer("LossCauseCode");
	/**
	 *  ���ִ��� 
	 */
	public static CodeTransfer SHKindCode = new CodeTransfer("SHKindCode");
	/**
	 *  �����¹ʷ��� 
	 */
	public static CodeTransfer AccidentType = new CodeTransfer("AccidentType");
	/**
	 *  ������ʧ��ϸ���� 
	 */
	public static CodeTransfer CarLossType = new CodeTransfer("CarLossType");
	/**
	 *  ������ʧ��ϸ���� 
	 */
	public static CodeTransfer PersonLossType = new CodeTransfer("PersonLossType");
	/**
	 *  �Ϻ�������ʧ��ϸ���� 
	 */
	public static CodeTransfer SHPersonLossType = new CodeTransfer("SHPersonLossType");
	/**
	 *  �Ϻ���ǿ�����˲���ʧ��ϸ���� 
	 */
	public static CodeTransfer SHBZDeadPersonLossType = new CodeTransfer("SHBZDeadPersonLossType");
	/**
	 *  �Ϻ���ǿҽ����ʧ��ϸ���� 
	 */
	public static CodeTransfer SHBZMedicalPersonLossType = new CodeTransfer("SHBZMedicalPersonLossType");
	/**
	 *  �Ϻ���ǿ�Ʋ���ʧ��ϸ���� 
	 */
	public static CodeTransfer SHBZPropPersonLossType = new CodeTransfer("SHBZPropPersonLossType");
	/**
	 *  �Ϻ���ǿ������ʧ��ϸ���� 
	 */
	public static CodeTransfer SHBZOtherPersonLossType = new CodeTransfer("SHBZOtherPersonLossType");
	/**
	 *  ������ϸ���� 
	 */
	public static CodeTransfer FeeLossType = new CodeTransfer("FeeLossType");
	/**
	 *  ȫ���¹ʴ���ʽ���� 
	 */
	public static CodeTransfer OptionType = new CodeTransfer("OptionType");
	/**
	 *  �㽭��ҵ�ռ�ʻԱ֤������ 
	 */
	public static CodeTransfer ZJCertiType = new CodeTransfer("ZJCertiType");
	/**
	 *  ������ҵ�����ִ��� 
	 */
	public static CodeTransfer CoverageCodeFG = new CodeTransfer("CoverageCodeFG");
	/**
	 *  ������ҵ�����ִ��� 
	 */
	public static CodeTransfer CoverageCodeFGT = new CodeTransfer("CoverageCodeFGT");
	/**
	 *  �Ѹ���ҵ�����ִ��� 
	 */
	public static CodeTransfer CoverageCode = new CodeTransfer("CoverageCode");
	/**
	 *  ������ҵ�����ִ��� 
	 */
	public static CodeTransfer FGKindKodeOut = new CodeTransfer("FGKindCodeOut");
	/**
	 *  �б������ձ����ת�� 
	 */
	public static CodeTransfer FGKindKodeIn = new CodeTransfer("FGKindCodeIn");
	/**
	 * add by  DBIC  sunzhaoyun  2007-06-06  ����ƽ̨����  begin
	 */
    public static  String  coventHandleUnitToManageType(String handleUnit)
    {
    	String ManageType = "1";
    	if(handleUnit==null)
    	{
    		return ManageType;
    	}
    	else
    	{
    		if(handleUnit.trim().equals("02")||handleUnit.trim().equals("03")||handleUnit.trim().equals("04")
    		   ||handleUnit.trim().equals("05")||handleUnit.trim().equals("99"))
    		{
    			ManageType = "1";
    		}
    		else if(handleUnit.trim().equals("02"))
    		{
    			ManageType = "3";
    		}
    		else
    		{
    			ManageType = "1";
    		}
    		return ManageType;
    	}
    }
    public static String coventDamageTypeCodeToAccidentCause(String DamageTypeCode)
    {
       String AccidentCause = "99";
       if(DamageTypeCode==null)
       {
    	   return  AccidentCause ;
       }
       else
       {
    	   if(DamageTypeCode.trim().equals("003"))
    	   {
    		   AccidentCause = "02";
    	   }
    	   else
    	   {
    		   AccidentCause = "99";
    	   }
           return  AccidentCause ;
       }
    }
	/**
	 * �������ִ��뷵���Ƿ��ǷѸ�����
	 */
	public static boolean isFG(String riskCode) {
		boolean isFG = false;
		if (riskCode == null||"".equals(riskCode)) {
			isFG = false;
		} else {
			if("0546,0556".indexOf(riskCode)>-1){
				isFG=true;
			}
		}
		return isFG;
	}
    public static String coventDamageAreaCodeTosection(String DamageAreaCode)
    {
    	return "05";//��������ʱĬ��Ϊ������
    }
    public static String coventIndemnityDutyToLiabilityAmount(String IndemnityDuty)
    {
    	return "9";//��������ʱĬ��Ϊ����
    }
    public static String coventDriverSex(String sex)
    {
    	String sexCode = "1";
    	if(sex==null)
    	{
    		return sexCode;
    	}
    	else
    	{
    		/***** ������ʱû�м�¼��ʻԱ���Ա���Ϣ�����������Ŀ���еĻ���������Լ���ʵ���������ת��  ****/
    		return sexCode;
    	}
    }
    public static String coventLicenseNo(String licenseNo)//������ҵ��ת�����ƺ���Ϣ�����ƺ���ʱ����
    {
    	if("��".equals(licenseNo))
    	{
    		return "";
    	}
    	else
    	{
    		return licenseNo;
    	}
    }
	/**
	 * add by  DBIC  sunzhaoyun  2007-06-06  ����ƽ̨����  end
	 */
	public String covrentPlatFormCode(String code) {
		String platFormCode = "";
			if (platFormMap == null) {
				platFormCode = code;
			} else {
				try{
					platFormCode = (String) platFormMap.get(code);
				}finally{
					//��Map���Ҳ������򷵻ؿ��ַ������ɣ���ƽ̨���д���
				}
			}
		/**
		 * �ǿ��򷵻ؿ��ַ���
		 */
		return platFormCode==null?"":platFormCode;
	}

	public String covrentSystemCode(String code) {
		String systemCode = "";
		if (code!=null&&code.trim().length()>0){
			if (platFormMap == null) {
				systemCode = code;
			} else {
				try{
					systemCode = (String) systemMap.get(code);
				}finally{
					//��Map���Ҳ������򷵻ؿ��ַ������ɣ���ƽ̨���д���
				}
			}
		}
		return systemCode;
	}

	private CodeTransfer(String codeType) {
		if (codeType.equals("IndemnityDuty")) {//2011�¹����λ���
			platFormMap.put("0", "1"); // ȫ��
			platFormMap.put("1", "2"); // ����
			platFormMap.put("2", "3"); // ͬ��
			platFormMap.put("3", "4"); // ����
			platFormMap.put("4", "5"); // ����
			platFormMap.put("5", "9"); // ��������
			platFormMap.put("6", "9"); // �޷��ҵ�������
			platFormMap.put("9", "9"); // ����
			platFormMap.put("", "9"); // ����

			systemMap.put("1", "0"); // ȫ��
			systemMap.put("2", "1"); // ����
			systemMap.put("3", "2"); // ͬ��
			systemMap.put("4", "3"); // ����
			systemMap.put("5", "4"); // ����
			systemMap.put("9", "9"); // ����
		}else if(codeType.equals("SelfPayFlag")){
			platFormMap.put("0","0");//һ���ⰸ
			platFormMap.put("1","0");//�پ��ⰸ
			platFormMap.put("2","0");//�ش󰸼�
			platFormMap.put("4","0");//˫���ⰸ
			platFormMap.put("5","0");//ͨ���ⰸ
			platFormMap.put("J","0");//��������
			platFormMap.put("K","1");//��������	
			platFormMap.put("", "0");
			platFormMap.put(null, "0");
			
		}else if(codeType.equals("FieldType")){
			platFormMap.put("03", "1");// ���ֳ�
			platFormMap.put("01", "2");// ��һ�ֳ�
			platFormMap.put("02", "3");// �ڶ��ֳ�
			platFormMap.put("04", "1");
		}else if(codeType.equals("TrafficType")){
			platFormMap.put("0", "1");// ����
			platFormMap.put("1", "2");//���г�
			platFormMap.put("2", "3");// �綯��
			platFormMap.put("3", "3");// Ħ�г�
			platFormMap.put("4", "4");// ����
			platFormMap.put("5", "9");// ����
		}else if(codeType.equals("MedicalType")){
			platFormMap.put("0", "1");// ����
			platFormMap.put("1", "2");// סԺ
			platFormMap.put("2", "3");// ����
		}else if(codeType.equals("CancelCause")){//2011����Ҫת����
			platFormMap.put("1","");
			platFormMap.put("2","");
			platFormMap.put("3","");
		}else if (codeType.equals("IndemnityDuty1")) {
			platFormMap.put("SH", "0"); // �����漰�������ⰸ
			platFormMap.put("0", "1"); // ȫ��
			platFormMap.put("1", "1"); // ����
			platFormMap.put("2", "1"); // ͬ��
			platFormMap.put("3", "1"); // ����
			platFormMap.put("4", "2"); // ����
			platFormMap.put("5", "9"); // ��������
			platFormMap.put("6", "9"); // �޷��ҵ�������
			platFormMap.put("9", "9"); // ����
			platFormMap.put("", "9"); // ����
			
			systemMap.put("1", "PUB"); 
			systemMap.put("2", "4");
			systemMap.put("9", "PUB");
		}else if (codeType.equals("CertiType")) {//2011
			platFormMap.put("01", "01");// ���֤
			platFormMap.put("02", "99");// ���ڱ�
			platFormMap.put("03", "02");// ����
			platFormMap.put("04", "03");// ����֤
			platFormMap.put("05", "99");// ��ʻִ��
			platFormMap.put("06", "99");// ����֤
			platFormMap.put("99", "99");// ����
			platFormMap.put("59", "99");// ����
			platFormMap.put("", "99");//����
			
			systemMap.put("01", "01"); // �������֤
			systemMap.put("02", "03");// ����
			systemMap.put("03", "03");// ����֤
			systemMap.put("10", "99");// ��֯��������
			systemMap.put("99", "99");// ����
		}  else if (codeType.equals("KindCode")){//��ά��
			platFormMap.put("B","2");
			platFormMap.put("A","3");   
			platFormMap.put("G","3");
			platFormMap.put("Z","9");
			platFormMap.put("D3","3");
			platFormMap.put("D4","3");
			platFormMap.put("C","9");
			platFormMap.put("C6","9");
			platFormMap.put("C7","9");
			platFormMap.put("D2","9");
			platFormMap.put("F","9");
			platFormMap.put("G0","9");
			platFormMap.put("H","9");
			platFormMap.put("K1","9");
			platFormMap.put("K12","9");
			platFormMap.put("K16","9");
			platFormMap.put("K17","9");
			platFormMap.put("K2","9");
			platFormMap.put("K6","9");
			platFormMap.put("K8","9");
			platFormMap.put("L","9");
			platFormMap.put("N","9");
			platFormMap.put("R","9");
			platFormMap.put("T","9");
			platFormMap.put("X","9");
			platFormMap.put("X1","9");
			
			
			systemMap.put("1", "A"); 
			systemMap.put("2", "B");
			systemMap.put("3", "PUB"); //��ά��
		}else if (codeType.equals("ClaimCompany")){
			platFormMap.put("A","DBIC02");   
			platFormMap.put("B","PICC02");
			platFormMap.put("C","PAIC02");
			platFormMap.put("D","CPIC02");
			platFormMap.put("E","CIC002");
			platFormMap.put("F","TAIC02");
			platFormMap.put("G","CCIC02");
			platFormMap.put("H","YAIC02");
			platFormMap.put("I","HAIC02");
			platFormMap.put("J","TPAIC2");
			platFormMap.put("K","HTIC02");
			platFormMap.put("L","DICC02");
			platFormMap.put("M","AICS02");
			platFormMap.put("N","ABIC02");
			platFormMap.put("P","CLPC02");
			platFormMap.put("Q","BPIC02");
			platFormMap.put("R","HNIC02");
			platFormMap.put("S","MACN02");
			platFormMap.put("T","TPAIC2");
			platFormMap.put("U","YGBX02");
			platFormMap.put("V","AHIC02");
			platFormMap.put("W","BOCI02");
			platFormMap.put("X","ACIC02");
		} else if(codeType.equals("AccidentType")){//2011�¹�����
			platFormMap.put("204", "111");
			platFormMap.put("252", "140");
			platFormMap.put("201", "201");
			platFormMap.put("202", "202");
			platFormMap.put("257", "222");
			platFormMap.put("256", "221");
			platFormMap.put("258", "232");
			platFormMap.put("259", "223");
			platFormMap.put("332", "204");
			platFormMap.put("260", "225");
			platFormMap.put("254", "241");
			platFormMap.put("255", "150");
			platFormMap.put("299", "199");
			platFormMap.put("152", "501");
			platFormMap.put("105", "502");
			platFormMap.put("104", "503");
			platFormMap.put("106", "504");
			platFormMap.put("107", "505");
			platFormMap.put("119", "506");
			platFormMap.put("155", "507");
			platFormMap.put("156", "508");
			platFormMap.put("157", "509");
			platFormMap.put("144", "510");
			platFormMap.put("109", "511");
			platFormMap.put("114", "512");
			platFormMap.put("253", "203");
			platFormMap.put("158", "513");
			platFormMap.put("", "900");
			
		}else if(codeType.equals("CarLossType"))//2011����
		{
			platFormMap.put("01", "301");
			platFormMap.put("02", "302");
			platFormMap.put("03", "300");
			platFormMap.put("04", "300");
			platFormMap.put("05", "900");
			platFormMap.put("50", "300");
			platFormMap.put("99", "300");
			platFormMap.put("", "300");
		}else if(codeType.equals("FeeLossType"))//2011����
		{
			platFormMap.put("05", "502");
			platFormMap.put("07", "506");
			platFormMap.put("15", "503");
			platFormMap.put("29", "501");
			platFormMap.put("30", "504");
			platFormMap.put("31", "507");
			platFormMap.put("32", "507");
			platFormMap.put("33", "507");
			
			platFormMap.put("04", "507");//�鿱��
			platFormMap.put("13", "900");//�ⲿ���鿱��
			platFormMap.put("14", "900");//�ڲ����鿱��
			platFormMap.put("", "900");
			
		}else if(codeType.equals("LossCauseCode"))//����ԭ�����
		{
			platFormMap.put("204", "A10029");
			platFormMap.put("252", "A10031");
			platFormMap.put("201","A10001"); 
			platFormMap.put("202","A10002");
			platFormMap.put("257","A10058");
			platFormMap.put("256","A10022");
			platFormMap.put("258","A19028");
			platFormMap.put("259","A10096");
			platFormMap.put("332","A10023");
			platFormMap.put("260","A10097");
			platFormMap.put("254","A10025");
			platFormMap.put("255","A10026");
			platFormMap.put("299","A10096");
			platFormMap.put("152","A10005");
			platFormMap.put("105","A10004");
			platFormMap.put("104","A10017");
			platFormMap.put("106","A10003");
			platFormMap.put("107","A10014");
			platFormMap.put("119","A10015");
			platFormMap.put("155","A10007");
			platFormMap.put("156","A10056");
			platFormMap.put("157","A10012");
			platFormMap.put("144","A10057");
			platFormMap.put("109","A10009");
			platFormMap.put("114","A10013");
			platFormMap.put("253","A10097");
			platFormMap.put("158","A10011");
			platFormMap.put("", "A10096");
			platFormMap.put("501", "A10030");
			platFormMap.put("502", "A10006");
			platFormMap.put("503", "A10004");
			platFormMap.put("504", "A10008");
			platFormMap.put("505", "A10010");
			platFormMap.put("506", "A10095");
			platFormMap.put("507", "A10060");
			platFormMap.put("508", "A10096");
			platFormMap.put("509", "A10096");
			platFormMap.put("510", "A10016");
			platFormMap.put("511", "A19013");
			platFormMap.put("512", "A19013");
			platFormMap.put("513", "A10095");
			platFormMap.put("514", "A10095");
			platFormMap.put("515", "A10096");
			platFormMap.put("516", "A10096");
			platFormMap.put("517", "A10096");
			platFormMap.put("518", "A10096");
			platFormMap.put("519", "A10096");
			platFormMap.put("520", "A19022");
			platFormMap.put("521", "A10023");
			platFormMap.put("522", "A10023");
			platFormMap.put("523", "A10096");
			platFormMap.put("524", "A10096");
			platFormMap.put("525", "A10095");
			platFormMap.put("526", "A10096");
			platFormMap.put("527", "A10096");
			
			systemMap.put("204", "A10029");
			systemMap.put("252", "A10031");
			systemMap.put("201","A10001"); 
			systemMap.put("202","A10002");
			systemMap.put("257","A10058");
			systemMap.put("256","A10022");
			systemMap.put("258","A19028");
			systemMap.put("259","A10096");
			systemMap.put("332","A10023");
			systemMap.put("260","A10097");
			systemMap.put("254","A10025");
			systemMap.put("255","A10026");
			systemMap.put("299","A10096");
			systemMap.put("152","A10005");
			systemMap.put("105","A10004");
			systemMap.put("104","A10017");
			systemMap.put("106","A10003");
			systemMap.put("107","A10014");
			systemMap.put("119","A10015");
			systemMap.put("155","A10007");
			systemMap.put("156","A10056");
			systemMap.put("157","A10012");
			systemMap.put("144","A10057");
			systemMap.put("109","A10009");
			systemMap.put("114","A10013");
			systemMap.put("253","A10097");
			systemMap.put("158","A10011");
			systemMap.put("", "A10096");
			systemMap.put("501", "A10030");
			systemMap.put("502", "A10006");
			systemMap.put("503", "A10004");
			systemMap.put("504", "A10008");
			systemMap.put("505", "A10010");
			systemMap.put("506", "A10095");
			systemMap.put("507", "A10060");
			systemMap.put("508", "A10096");
			systemMap.put("509", "A10096");
			systemMap.put("510", "A10016");
			systemMap.put("511", "A19013");
			systemMap.put("512", "A19013");
			systemMap.put("513", "A10095");
			systemMap.put("514", "A10095");
			systemMap.put("515", "A10096");
			systemMap.put("516", "A10096");
			systemMap.put("517", "A10096");
			systemMap.put("518", "A10096");
			systemMap.put("519", "A10096");
			systemMap.put("520", "A19022");
			systemMap.put("521", "A10023");
			systemMap.put("522", "A10023");
			systemMap.put("523", "A10096");
			systemMap.put("524", "A10096");
			systemMap.put("525", "A10095");
			systemMap.put("526", "A10096");
			systemMap.put("527", "A10096");
			
		}else if(codeType.equals("PersonLossType"))//2011����
		{
			platFormMap.put("101", "101");
			platFormMap.put("102", "102");
			platFormMap.put("103", "103");
			platFormMap.put("104", "104");
			platFormMap.put("105", "105");
			platFormMap.put("106", "106");
			platFormMap.put("107", "107");
			platFormMap.put("108", "100");
			platFormMap.put("201", "201");
			platFormMap.put("202", "202");
			platFormMap.put("203", "205");
			platFormMap.put("204", "206");
			platFormMap.put("205", "203");
			platFormMap.put("206", "211");
			platFormMap.put("207", "209");
			platFormMap.put("208", "204");
			platFormMap.put("209", "210");
			platFormMap.put("210", "207");
			platFormMap.put("211", "208");
			platFormMap.put("212", "200");
			platFormMap.put("213", "900");
			platFormMap.put("214", "212");
			platFormMap.put("215", "900");
			platFormMap.put("109", "200");
			platFormMap.put("213", "900");
			platFormMap.put("", "900");
		}else if(codeType.equals("OptionType"))//2011�¹ʴ���ʽ
		{
			platFormMap.put("01", "4");
			platFormMap.put("02", "9");
			platFormMap.put("03", "9");
			platFormMap.put("04", "1");
			platFormMap.put("05", "2");
			platFormMap.put("06", "9");
			platFormMap.put("07", "9");
			platFormMap.put("99", "9");
			platFormMap.put("", "9");
		}else if(codeType.equals("ZJCertiType"))//2011ƽ̨��Ҫ��
		{
			platFormMap.put("01", "01");
			platFormMap.put("02", "02");
			platFormMap.put("03", "07");
			platFormMap.put("04", "04");
			platFormMap.put("05", "03");
			platFormMap.put("06", "43");
			platFormMap.put("99", "99");
		}else if(codeType.equals("CoverageCode"))
		{
			platFormMap.put("BZ","100");//������ǿ�����α���
			platFormMap.put("S","360");//���ֳ���Լ��
			platFormMap.put("NX","421");//����������Լ��A
			platFormMap.put("NY","422");//����������Լ��B
			platFormMap.put("A","200");//������ʧ��
			platFormMap.put("B","600");//���������α���
			platFormMap.put("C","385");//������������
			platFormMap.put("D2","800");//���ϻ���������
			platFormMap.put("D3","701");//������Ա������-˾����λ
			platFormMap.put("D4","702");//������Ա������-�˿���λ
			platFormMap.put("F","231");//��������������
			platFormMap.put("G","500");//ȫ��������
			platFormMap.put("G0","412");//���Ӹ߶�����ߵ�����
			platFormMap.put("H","802");//���ػ������������
			platFormMap.put("K10","620");//�����¹ʸ��������ʧ��
			platFormMap.put("K6","410");//�泵������Ʒ��ʧ��
			platFormMap.put("L","210");//��������ʧ��
			platFormMap.put("M","900");//������������Լ��
			platFormMap.put("M2","240");//����¹�������Լ��
			platFormMap.put("P","252");//ָ��ר�޳���Լ��
			platFormMap.put("R","640");//��ͨ�¹ʾ������⳥��
			platFormMap.put("T","270");//����ͣʻ��ʧ��
			platFormMap.put("U","280");//������Լ��
			platFormMap.put("V1","630");//����������Ⱦ������
			platFormMap.put("X","260");//�������豸��ʧ��
			platFormMap.put("X3","290");//��ˮ��ʻ��ʧ��
			platFormMap.put("X4","710");//ϵ��ȫ��������Լ��
			platFormMap.put("Z","310");//��ȼ��ʧ��
		}else if(codeType.equals("CoverageCodeFG"))
		{
			platFormMap.put("BZ","100");//������ǿ�����α���
			platFormMap.put("A","0101200");//������ʧ��
			platFormMap.put("B","0101600");//���������α���
			platFormMap.put("FB","0101004");//���շ���
			platFormMap.put("D2","0101800");//���ϻ���������
			platFormMap.put("D3","0101701");//������Ա������-˾����λ
			platFormMap.put("D4","0101702");//������Ա������-�˿���λ
			platFormMap.put("F","0101231");//��������������
			platFormMap.put("G","0101500");//ȫ��������
			platFormMap.put("L","0101210");//��������ʧ��
			platFormMap.put("MA","0101911");//������������Լ��
			platFormMap.put("MB","0101912");//������������Լ��
			platFormMap.put("MD3","0101928");//������������Լ��
			platFormMap.put("MD4","0101929");//������������Լ��
			platFormMap.put("MG","0101921");//������������Լ��
			platFormMap.put("MD2","0101925");//������������Լ��
			platFormMap.put("MZ","0101970");//������������Լ��
			platFormMap.put("MX","0101923");//������������Լ��
			platFormMap.put("MR","0101973");//������������Լ�ս�ͨ�¹ʾ������⳥��
			platFormMap.put("ML","0101971");//��������ʧ�ճ�������ʧ��
			platFormMap.put("MX3","0101972");//��ˮ��ʻ��ʧ��
			platFormMap.put("P","0101252");//ָ��ר�޳���Լ��
			platFormMap.put("R","0101610");//��ͨ�¹ʾ������⳥��
			platFormMap.put("X","0101260");//�������豸��ʧ��
			platFormMap.put("X3","0101290");//��ˮ��ʻ��ʧ��
			platFormMap.put("Z","0101310");//��ȼ��ʧ��
			platFormMap.put("W","0101230");//�����ڼ���ò�����
			platFormMap.put("X5","0101230");//��������ʧ�����޷��ҵ���������Լ��
			platFormMap.put("004","0201200");//��������ʧ���գ�IACJQL0001��ȫ����
			platFormMap.put("009","0201001");//���Ӿ�����������Լ�գ�IACJQL0101��
			platFormMap.put("010","0201002");//���ӳ��ֵ����𻵳�����Լ�գ�IACJQL0201��
		}else if(codeType.equals("CoverageCodeFGT"))
		{
			platFormMap.put("BZ","100");//������ǿ�����α���
			platFormMap.put("A","0102200");//������ʧ��
			platFormMap.put("B","0102600");//���������α���
			platFormMap.put("FB","0101004");//���շ���
			platFormMap.put("D2","0102800");//���ϻ���������
			platFormMap.put("D3","0102701");//������Ա������-˾����λ
			platFormMap.put("D4","0102702");//������Ա������-�˿���λ
			platFormMap.put("F","0102231");//��������������
			platFormMap.put("G","0102500");//ȫ��������
			platFormMap.put("MA","0102911");//������������Լ��
			platFormMap.put("MB","0102912");//������������Լ��
			platFormMap.put("MD3","0102928");//������������Լ��
			platFormMap.put("MD4","0102929");//������������Լ��
			platFormMap.put("MG","0102921");//������������Լ��
			platFormMap.put("MD2","0102925");//������������Լ��
			platFormMap.put("MZ","0102971");//������������Լ��
			platFormMap.put("MX","0102923");//������������Լ��
			platFormMap.put("MR","0102972");//������������Լ��
			platFormMap.put("P","0102252");//ָ��ר�޳���Լ��
			platFormMap.put("R","0102610");//��ͨ�¹ʾ������⳥��
			platFormMap.put("X","0102260");//�������豸��ʧ��
			platFormMap.put("Z","0102310");//��ȼ��ʧ��
			platFormMap.put("X5","0102250");//��������ʧ�����޷��ҵ���������Լ��
			platFormMap.put("X6","0102253");//���ء�װж���ھ�����ʧ��չ����
			platFormMap.put("X7","0102254");//���ֳ����̶��豸����������չ����
			platFormMap.put("004","0201200");//��������ʧ���գ�IACJQL0001��ȫ����
			platFormMap.put("009","0201001");//���Ӿ�����������Լ�գ�IACJQL0101��
			platFormMap.put("010","0201002");//���ӳ��ֵ����𻵳�����Լ�գ�IACJQL0201��
		}else if (codeType.equals("ManageType")) {
			platFormMap.put("01", "4"); // �������׳�����
			platFormMap.put("02", "3"); // ������������
			platFormMap.put("03", "9"); // ��������
			platFormMap.put("04", "1"); // ���չ�˾
			platFormMap.put("05", "2"); // ���д���
			platFormMap.put("06", "9"); // ��ȷ��
			platFormMap.put("", "9"); // ��ȷ��

			systemMap.put("01", "4"); // �������׳�����
			systemMap.put("02", "3"); // ������������
			systemMap.put("03", "9"); // ��������
			systemMap.put("04", "1"); // ���չ�˾
			systemMap.put("05", "2"); // ���д���
			systemMap.put("06", "9"); // ��ȷ��
		}else if (codeType.equals("FGKindCodeOut")) {
			platFormMap.put("001",  "A"); // ������
			platFormMap.put("002",  "B"); // ����������
			platFormMap.put("003",  "D3"); // ˾����λ��
			platFormMap.put("006",  "D4"); // �˿���λ��
			platFormMap.put("007",  "G"); // ������
			platFormMap.put("201",  "F"); // ��������������
			platFormMap.put("202",  "Z"); // ��ȼ��ʧ��
			platFormMap.put("203",  "X"); // �������豸��ʧ��
			platFormMap.put("205",  "L"); // ��������ʧ��
			platFormMap.put("206",  "X3"); // ��������ˮ��ʧ��
			platFormMap.put("207",  "W"); // �����ڼ���ò�����
			platFormMap.put("208",  "D2"); // ���ϻ���������
			platFormMap.put("210",  "X5"); // ��������ʧ�����޷��ҵ���������Լ��
			platFormMap.put("211",  "P"); // ָ��������
			platFormMap.put("212",  "X6"); // ���ء�װж���ھ�����ʧ��չ����
			platFormMap.put("213",  "X7"); // ���ֳ����̶��豸����������չ����
			platFormMap.put("216",  "R"); // �����𺦸�ο��������
			platFormMap.put("BZ",   "BZ"); //
			platFormMap.put("008",  "FB"); // ���������߼��շ�����

			platFormMap.put("801",  "MA"); // �����������գ�������ʧ���գ�
			platFormMap.put("802",  "MB"); // �����������գ����������α��գ�
			platFormMap.put("803",  "MD3"); // �����������գ�������Ա���α��գ�˾������
			platFormMap.put("806",  "MD4"); // �����������գ�������Ա���α��գ�˾������
			platFormMap.put("807",  "MG"); // �����������գ�ȫ���������գ�
			platFormMap.put("902",  "MZ"); // �����������գ���ȼ��ʧ�գ�
			platFormMap.put("903",  "MX"); // �����������գ��������豸��ʧ�գ�
			platFormMap.put("905",  "ML"); // �����������գ���������ʧ��)
			platFormMap.put("906",  "MX3"); // �����������գ���������ˮ��ʧ��)
			platFormMap.put("908",  "MD2"); // �����������գ����ϻ���������)
			platFormMap.put("916",  "MR"); // �����������գ������𺦸�ο��������)
			platFormMap.put("004","004");//��������ʧ����(IACJQL0001)
			platFormMap.put("009","009");//���Ӿ���������Լ��ȫ����
			platFormMap.put("010","010");//���ӳ��ֵ����𻵳�����Լ��ȫ����
		}else if (codeType.equals("FGKindCodeIn")) {
			platFormMap.put("A",    "001"); // ������
			platFormMap.put("B",    "002"); // ����������
			platFormMap.put("D3",   "003"); // ˾����λ��
			platFormMap.put("D4",   "006"); // �˿���λ��
			platFormMap.put("G",    "007"); // ������
			platFormMap.put("F",    "201"); // ��������������
			platFormMap.put("Z",    "202"); // ��ȼ��ʧ��
			platFormMap.put("X",    "203"); // �������豸��ʧ��
			platFormMap.put("L",    "205"); // ��������ʧ��
			platFormMap.put("X3",   "206"); // ��������ˮ��ʧ��
			platFormMap.put("W",    "207"); // �����ڼ���ò�����
			platFormMap.put("D2",   "208"); // ���ϻ���������
			platFormMap.put("X5",   "210"); // ��������ʧ�����޷��ҵ���������Լ��
			platFormMap.put("P",    "211"); // ָ��������
			platFormMap.put("X6",   "212"); // ���ء�װж���ھ�����ʧ��չ����
			platFormMap.put("X7",   "213"); // ���ֳ����̶��豸����������չ����
			platFormMap.put("R",    "216"); // �����𺦸�ο��������
			platFormMap.put("BZ",   "BZ"); //
			platFormMap.put("FB",  "008"); // ���������߼��շ�����
			platFormMap.put("008",  "008"); // ���������߼��շ�����
			platFormMap.put("MA",   "801"); // �����������գ�������ʧ���գ�
			platFormMap.put("MB",   "802"); // �����������գ����������α��գ�
			platFormMap.put("MD3",  "803"); // �����������գ�������Ա���α��գ�˾������
			platFormMap.put("MD4",  "806"); // �����������գ�������Ա���α��գ�˾������
			platFormMap.put("MG",   "807"); // �����������գ�ȫ���������գ�
			platFormMap.put("MZ",   "902"); // �����������գ���ȼ��ʧ�գ�
			platFormMap.put("MX",   "903"); // �����������գ��������豸��ʧ�գ�
			platFormMap.put("ML",   "905"); // �����������գ���������ʧ��)
			platFormMap.put("MX3",  "906"); // �����������գ���������ˮ��ʧ��)
			platFormMap.put("MD2",  "908"); // �����������գ����ϻ���������)
			platFormMap.put("MR",   "916"); // �����������գ������𺦸�ο��������)
			platFormMap.put("004","004");//��������ʧ����(IACJQL0001)
			platFormMap.put("009","009");//���Ӿ���������Լ��ȫ����
			platFormMap.put("010","010");//���ӳ��ֵ����𻵳�����Լ��ȫ����
		}
		else {
			platFormMap = null;
			systemMap = null;
		}
	}
}
