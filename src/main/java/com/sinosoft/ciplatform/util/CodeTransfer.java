package com.sinosoft.ciplatform.util;

import java.util.HashMap;
import java.util.Map;



public class CodeTransfer {
	private Map platFormMap = new HashMap();
	private Map systemMap = new HashMap();
	//注销原因
	public static CodeTransfer CancelCause=new CodeTransfer("CodeTransfer");

	/**
	 * 事故责任代码
	 */ 
	public static CodeTransfer IndemnityDuty = new CodeTransfer("IndemnityDuty");
	/**
	 * 互碰自赔代码
	 */
	public static CodeTransfer SelfPayFlag	= new CodeTransfer("SelfPayFlag");
	/**
	 * 事故处理方式代码
	 */
	public static CodeTransfer ManageType = new CodeTransfer("ManageType");
	/**
	 * 现场类别代码
	 */ 
	public static CodeTransfer FieldType = new CodeTransfer("FieldType");
	/**
	 * 人员交通状态代码
	 */ 
	public static CodeTransfer TrafficType = new CodeTransfer("TrafficType");
	/**
	 * 伤亡人员医疗类型代码
	 */ 
	public static CodeTransfer MedicalType = new CodeTransfer("MedicalType");
	/**
	 * 事故责任代码
	 */
	public static CodeTransfer IndemnityDuty1 = new CodeTransfer("IndemnityDuty1");
	/**
	 * 号牌种类
	 */
	public static CodeTransfer LicenseKindCode = new CodeTransfer("LicenseKindCode");
	/**
	 * 公司代码
	 */
	public static CodeTransfer ClaimCompany = new CodeTransfer("ClaimCompany");
	/**
	 * 事故处理部门
	 */
	public static CodeTransfer AccidentDep = new CodeTransfer("AccidentDep");
	/**
	 * 证件类型
	 */
	public static CodeTransfer CertiType = new CodeTransfer("CertiType");
	/**
	 * 单证类型
	 */
	public static CodeTransfer DocType = new CodeTransfer("DocType");
	
	/**
	 * 垫付原因
	 */
	public static CodeTransfer PrePayCause = new CodeTransfer("PrePayCause");
	
	/**
	 * 损失明细代码
	 */
	public static CodeTransfer LossTypeDetail = new CodeTransfer("LossTypeDetail");
	
	/**
	 *  险别代码 
	 */
	public static CodeTransfer KindCode = new CodeTransfer("KindCode");
	/**
	 *  险种类型
	 */
	public static CodeTransfer SHKindType = new CodeTransfer("SHKindType");
	/**
	 *  出险原因代码
	 */
	public static CodeTransfer LossCauseCode = new CodeTransfer("LossCauseCode");
	/**
	 *  险种代码 
	 */
	public static CodeTransfer SHKindCode = new CodeTransfer("SHKindCode");
	/**
	 *  保险事故分类 
	 */
	public static CodeTransfer AccidentType = new CodeTransfer("AccidentType");
	/**
	 *  车辆损失明细分类 
	 */
	public static CodeTransfer CarLossType = new CodeTransfer("CarLossType");
	/**
	 *  人伤损失明细分类 
	 */
	public static CodeTransfer PersonLossType = new CodeTransfer("PersonLossType");
	/**
	 *  上海人伤损失明细分类 
	 */
	public static CodeTransfer SHPersonLossType = new CodeTransfer("SHPersonLossType");
	/**
	 *  上海交强死亡伤残损失明细分类 
	 */
	public static CodeTransfer SHBZDeadPersonLossType = new CodeTransfer("SHBZDeadPersonLossType");
	/**
	 *  上海交强医疗损失明细分类 
	 */
	public static CodeTransfer SHBZMedicalPersonLossType = new CodeTransfer("SHBZMedicalPersonLossType");
	/**
	 *  上海交强财产损失明细分类 
	 */
	public static CodeTransfer SHBZPropPersonLossType = new CodeTransfer("SHBZPropPersonLossType");
	/**
	 *  上海交强其他损失明细分类 
	 */
	public static CodeTransfer SHBZOtherPersonLossType = new CodeTransfer("SHBZOtherPersonLossType");
	/**
	 *  费用明细分类 
	 */
	public static CodeTransfer FeeLossType = new CodeTransfer("FeeLossType");
	/**
	 *  全国事故处理方式分类 
	 */
	public static CodeTransfer OptionType = new CodeTransfer("OptionType");
	/**
	 *  浙江商业险驾驶员证件类型 
	 */
	public static CodeTransfer ZJCertiType = new CodeTransfer("ZJCertiType");
	/**
	 *  北京商业险险种代码 
	 */
	public static CodeTransfer CoverageCodeFG = new CodeTransfer("CoverageCodeFG");
	/**
	 *  北京商业险险种代码 
	 */
	public static CodeTransfer CoverageCodeFGT = new CodeTransfer("CoverageCodeFGT");
	/**
	 *  费改商业险险种代码 
	 */
	public static CodeTransfer CoverageCode = new CodeTransfer("CoverageCode");
	/**
	 *  北京商业险险种代码 
	 */
	public static CodeTransfer FGKindKodeOut = new CodeTransfer("FGKindCodeOut");
	/**
	 *  承保理赔险别代码转换 
	 */
	public static CodeTransfer FGKindKodeIn = new CodeTransfer("FGKindCodeIn");
	/**
	 * add by  DBIC  sunzhaoyun  2007-06-06  北京平台调整  begin
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
	 * 根据险种代码返回是否是费改险种
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
    	return "05";//北京的暂时默认为朝阳区
    }
    public static String coventIndemnityDutyToLiabilityAmount(String IndemnityDuty)
    {
    	return "9";//北京的暂时默认为其他
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
    		/***** 都邦暂时没有记录驾驶员的性别信息，如果其他项目组有的话，请根据自己的实际情况进行转码  ****/
    		return sexCode;
    	}
    }
    public static String coventLicenseNo(String licenseNo)//北京商业险转换车牌号信息，车牌号无时传空
    {
    	if("无".equals(licenseNo))
    	{
    		return "";
    	}
    	else
    	{
    		return licenseNo;
    	}
    }
	/**
	 * add by  DBIC  sunzhaoyun  2007-06-06  北京平台调整  end
	 */
	public String covrentPlatFormCode(String code) {
		String platFormCode = "";
			if (platFormMap == null) {
				platFormCode = code;
			} else {
				try{
					platFormCode = (String) platFormMap.get(code);
				}finally{
					//在Map中找不到，则返回空字符串即可，由平台进行处理
				}
			}
		/**
		 * 是空则返回空字符串
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
					//在Map中找不到，则返回空字符串即可，由平台进行处理
				}
			}
		}
		return systemCode;
	}

	private CodeTransfer(String codeType) {
		if (codeType.equals("IndemnityDuty")) {//2011事故责任划分
			platFormMap.put("0", "1"); // 全责
			platFormMap.put("1", "2"); // 主责
			platFormMap.put("2", "3"); // 同责
			platFormMap.put("3", "4"); // 次责
			platFormMap.put("4", "5"); // 无责
			platFormMap.put("5", "9"); // 单方肇事
			platFormMap.put("6", "9"); // 无法找到第三方
			platFormMap.put("9", "9"); // 其它
			platFormMap.put("", "9"); // 其它

			systemMap.put("1", "0"); // 全责
			systemMap.put("2", "1"); // 主责
			systemMap.put("3", "2"); // 同责
			systemMap.put("4", "3"); // 次责
			systemMap.put("5", "4"); // 无责
			systemMap.put("9", "9"); // 其它
		}else if(codeType.equals("SelfPayFlag")){
			platFormMap.put("0","0");//一般赔案
			platFormMap.put("1","0");//速决赔案
			platFormMap.put("2","0");//重大案件
			platFormMap.put("4","0");//双代赔案
			platFormMap.put("5","0");//通融赔案
			platFormMap.put("J","0");//互碰案件
			platFormMap.put("K","1");//互碰自赔	
			platFormMap.put("", "0");
			platFormMap.put(null, "0");
			
		}else if(codeType.equals("FieldType")){
			platFormMap.put("03", "1");// 无现场
			platFormMap.put("01", "2");// 第一现场
			platFormMap.put("02", "3");// 第二现场
			platFormMap.put("04", "1");
		}else if(codeType.equals("TrafficType")){
			platFormMap.put("0", "1");// 行人
			platFormMap.put("1", "2");//自行车
			platFormMap.put("2", "3");// 电动车
			platFormMap.put("3", "3");// 摩托车
			platFormMap.put("4", "4");// 汽车
			platFormMap.put("5", "9");// 其它
		}else if(codeType.equals("MedicalType")){
			platFormMap.put("0", "1");// 门诊
			platFormMap.put("1", "2");// 住院
			platFormMap.put("2", "3");// 死亡
		}else if(codeType.equals("CancelCause")){//2011不需要转换了
			platFormMap.put("1","");
			platFormMap.put("2","");
			platFormMap.put("3","");
		}else if (codeType.equals("IndemnityDuty1")) {
			platFormMap.put("SH", "0"); // 有责涉及死亡的赔案
			platFormMap.put("0", "1"); // 全责
			platFormMap.put("1", "1"); // 主责
			platFormMap.put("2", "1"); // 同责
			platFormMap.put("3", "1"); // 次责
			platFormMap.put("4", "2"); // 无责
			platFormMap.put("5", "9"); // 单方肇事
			platFormMap.put("6", "9"); // 无法找到第三方
			platFormMap.put("9", "9"); // 其它
			platFormMap.put("", "9"); // 其它
			
			systemMap.put("1", "PUB"); 
			systemMap.put("2", "4");
			systemMap.put("9", "PUB");
		}else if (codeType.equals("CertiType")) {//2011
			platFormMap.put("01", "01");// 身份证
			platFormMap.put("02", "99");// 户口薄
			platFormMap.put("03", "02");// 护照
			platFormMap.put("04", "03");// 军官证
			platFormMap.put("05", "99");// 驾驶执照
			platFormMap.put("06", "99");// 返乡证
			platFormMap.put("99", "99");// 其他
			platFormMap.put("59", "99");// 其他
			platFormMap.put("", "99");//其他
			
			systemMap.put("01", "01"); // 居民身份证
			systemMap.put("02", "03");// 护照
			systemMap.put("03", "03");// 军人证
			systemMap.put("10", "99");// 组织机构代码
			systemMap.put("99", "99");// 其他
		}  else if (codeType.equals("KindCode")){//待维护
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
			systemMap.put("3", "PUB"); //待维护
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
		} else if(codeType.equals("AccidentType")){//2011事故类型
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
			
		}else if(codeType.equals("CarLossType"))//2011车损
		{
			platFormMap.put("01", "301");
			platFormMap.put("02", "302");
			platFormMap.put("03", "300");
			platFormMap.put("04", "300");
			platFormMap.put("05", "900");
			platFormMap.put("50", "300");
			platFormMap.put("99", "300");
			platFormMap.put("", "300");
		}else if(codeType.equals("FeeLossType"))//2011费用
		{
			platFormMap.put("05", "502");
			platFormMap.put("07", "506");
			platFormMap.put("15", "503");
			platFormMap.put("29", "501");
			platFormMap.put("30", "504");
			platFormMap.put("31", "507");
			platFormMap.put("32", "507");
			platFormMap.put("33", "507");
			
			platFormMap.put("04", "507");//查勘费
			platFormMap.put("13", "900");//外部代查勘费
			platFormMap.put("14", "900");//内部代查勘费
			platFormMap.put("", "900");
			
		}else if(codeType.equals("LossCauseCode"))//出险原因代码
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
			
		}else if(codeType.equals("PersonLossType"))//2011人伤
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
		}else if(codeType.equals("OptionType"))//2011事故处理方式
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
		}else if(codeType.equals("ZJCertiType"))//2011平台不要求传
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
			platFormMap.put("BZ","100");//机动车强制责任保险
			platFormMap.put("S","360");//特种车特约险
			platFormMap.put("NX","421");//车辆重置特约险A
			platFormMap.put("NY","422");//车辆重置特约险B
			platFormMap.put("A","200");//车辆损失险
			platFormMap.put("B","600");//第三者责任保险
			platFormMap.put("C","385");//代步车费用险
			platFormMap.put("D2","800");//车上货物责任险
			platFormMap.put("D3","701");//车上人员责任险-司机座位
			platFormMap.put("D4","702");//车上人员责任险-乘客座位
			platFormMap.put("F","231");//玻璃单独破碎险
			platFormMap.put("G","500");//全车盗抢险
			platFormMap.put("G0","412");//附加高尔夫球具盗窃险
			platFormMap.put("H","802");//车载货物掉落责任险
			platFormMap.put("K10","620");//保险事故附随费用损失险
			platFormMap.put("K6","410");//随车行李物品损失险
			platFormMap.put("L","210");//车身划痕损失险
			platFormMap.put("M","900");//不计免赔率特约险
			platFormMap.put("M2","240");//多次事故免赔特约险
			platFormMap.put("P","252");//指定专修厂特约险
			platFormMap.put("R","640");//交通事故精神损害赔偿险
			platFormMap.put("T","270");//车辆停驶损失险
			platFormMap.put("U","280");//换件特约险
			platFormMap.put("V1","630");//附加油污污染责任险
			platFormMap.put("X","260");//新增加设备损失险
			platFormMap.put("X3","290");//涉水行驶损失险
			platFormMap.put("X4","710");//系安全带补偿特约险
			platFormMap.put("Z","310");//自燃损失险
		}else if(codeType.equals("CoverageCodeFG"))
		{
			platFormMap.put("BZ","100");//机动车强制责任保险
			platFormMap.put("A","0101200");//车辆损失险
			platFormMap.put("B","0101600");//第三者责任保险
			platFormMap.put("FB","0101004");//假日翻倍
			platFormMap.put("D2","0101800");//车上货物责任险
			platFormMap.put("D3","0101701");//车上人员责任险-司机座位
			platFormMap.put("D4","0101702");//车上人员责任险-乘客座位
			platFormMap.put("F","0101231");//玻璃单独破碎险
			platFormMap.put("G","0101500");//全车盗抢险
			platFormMap.put("L","0101210");//车身划痕损失险
			platFormMap.put("MA","0101911");//不计免赔率特约险
			platFormMap.put("MB","0101912");//不计免赔率特约险
			platFormMap.put("MD3","0101928");//不计免赔率特约险
			platFormMap.put("MD4","0101929");//不计免赔率特约险
			platFormMap.put("MG","0101921");//不计免赔率特约险
			platFormMap.put("MD2","0101925");//不计免赔率特约险
			platFormMap.put("MZ","0101970");//不计免赔率特约险
			platFormMap.put("MX","0101923");//不计免赔率特约险
			platFormMap.put("MR","0101973");//不计免赔率特约险交通事故精神损害赔偿险
			platFormMap.put("ML","0101971");//车身划痕损失险车身划痕损失险
			platFormMap.put("MX3","0101972");//涉水行驶损失险
			platFormMap.put("P","0101252");//指定专修厂特约险
			platFormMap.put("R","0101610");//交通事故精神损害赔偿险
			platFormMap.put("X","0101260");//新增加设备损失险
			platFormMap.put("X3","0101290");//涉水行驶损失险
			platFormMap.put("Z","0101310");//自燃损失险
			platFormMap.put("W","0101230");//修理期间费用补偿险
			platFormMap.put("X5","0101230");//机动车损失保险无法找到第三方特约险
			platFormMap.put("004","0201200");//机动车损失保险（IACJQL0001）全面型
			platFormMap.put("009","0201001");//附加绝对免赔率特约险（IACJQL0101）
			platFormMap.put("010","0201002");//附加车轮单独损坏除外特约险（IACJQL0201）
		}else if(codeType.equals("CoverageCodeFGT"))
		{
			platFormMap.put("BZ","100");//机动车强制责任保险
			platFormMap.put("A","0102200");//车辆损失险
			platFormMap.put("B","0102600");//第三者责任保险
			platFormMap.put("FB","0101004");//假日翻倍
			platFormMap.put("D2","0102800");//车上货物责任险
			platFormMap.put("D3","0102701");//车上人员责任险-司机座位
			platFormMap.put("D4","0102702");//车上人员责任险-乘客座位
			platFormMap.put("F","0102231");//玻璃单独破碎险
			platFormMap.put("G","0102500");//全车盗抢险
			platFormMap.put("MA","0102911");//不计免赔率特约险
			platFormMap.put("MB","0102912");//不计免赔率特约险
			platFormMap.put("MD3","0102928");//不计免赔率特约险
			platFormMap.put("MD4","0102929");//不计免赔率特约险
			platFormMap.put("MG","0102921");//不计免赔率特约险
			platFormMap.put("MD2","0102925");//不计免赔率特约险
			platFormMap.put("MZ","0102971");//不计免赔率特约险
			platFormMap.put("MX","0102923");//不计免赔率特约险
			platFormMap.put("MR","0102972");//不计免赔率特约险
			platFormMap.put("P","0102252");//指定专修厂特约险
			platFormMap.put("R","0102610");//交通事故精神损害赔偿险
			platFormMap.put("X","0102260");//新增加设备损失险
			platFormMap.put("Z","0102310");//自燃损失险
			platFormMap.put("X5","0102250");//机动车损失保险无法找到第三方特约险
			platFormMap.put("X6","0102253");//起重、装卸、挖掘车辆损失扩展条款
			platFormMap.put("X7","0102254");//特种车辆固定设备、仪器损坏扩展条款
			platFormMap.put("004","0201200");//机动车损失保险（IACJQL0001）全面型
			platFormMap.put("009","0201001");//附加绝对免赔率特约险（IACJQL0101）
			platFormMap.put("010","0201002");//附加车轮单独损坏除外特约险（IACJQL0201）
		}else if (codeType.equals("ManageType")) {
			platFormMap.put("01", "4"); // 交警简易程序处理
			platFormMap.put("02", "3"); // 交管正常处理
			platFormMap.put("03", "9"); // 消防部门
			platFormMap.put("04", "1"); // 保险公司
			platFormMap.put("05", "2"); // 自行处理
			platFormMap.put("06", "9"); // 不确定
			platFormMap.put("", "9"); // 不确定

			systemMap.put("01", "4"); // 交警简易程序处理
			systemMap.put("02", "3"); // 交管正常处理
			systemMap.put("03", "9"); // 消防部门
			systemMap.put("04", "1"); // 保险公司
			systemMap.put("05", "2"); // 自行处理
			systemMap.put("06", "9"); // 不确定
		}else if (codeType.equals("FGKindCodeOut")) {
			platFormMap.put("001",  "A"); // 车损险
			platFormMap.put("002",  "B"); // 三者责任险
			platFormMap.put("003",  "D3"); // 司机座位险
			platFormMap.put("006",  "D4"); // 乘客座位险
			platFormMap.put("007",  "G"); // 盗抢险
			platFormMap.put("201",  "F"); // 玻璃单独破碎险
			platFormMap.put("202",  "Z"); // 自燃损失险
			platFormMap.put("203",  "X"); // 新增加设备损失险
			platFormMap.put("205",  "L"); // 车身划痕损失险
			platFormMap.put("206",  "X3"); // 发动机涉水损失险
			platFormMap.put("207",  "W"); // 修理期间费用补偿险
			platFormMap.put("208",  "D2"); // 车上货物责任险
			platFormMap.put("210",  "X5"); // 机动车损失保险无法找到第三方特约险
			platFormMap.put("211",  "P"); // 指定修理厂险
			platFormMap.put("212",  "X6"); // 起重、装卸、挖掘车辆损失扩展条款
			platFormMap.put("213",  "X7"); // 特种车辆固定设备、仪器损坏扩展条款
			platFormMap.put("216",  "R"); // 精神损害抚慰金责任险
			platFormMap.put("BZ",   "BZ"); //
			platFormMap.put("008",  "FB"); // 机动车三者假日翻倍险

			platFormMap.put("801",  "MA"); // 不计免赔率险（车辆损失保险）
			platFormMap.put("802",  "MB"); // 不计免赔率险（第三者责任保险）
			platFormMap.put("803",  "MD3"); // 不计免赔率险（车上人员责任保险（司机））
			platFormMap.put("806",  "MD4"); // 不计免赔率险（车上人员责任保险（司机））
			platFormMap.put("807",  "MG"); // 不计免赔率险（全车盗抢保险）
			platFormMap.put("902",  "MZ"); // 不计免赔率险（自燃损失险）
			platFormMap.put("903",  "MX"); // 不计免赔率险（新增加设备损失险）
			platFormMap.put("905",  "ML"); // 不计免赔率险（车身划痕损失险)
			platFormMap.put("906",  "MX3"); // 不计免赔率险（发动机涉水损失险)
			platFormMap.put("908",  "MD2"); // 不计免赔率险（车上货物责任险)
			platFormMap.put("916",  "MR"); // 不计免赔率险（精神损害抚慰金责任险)
			platFormMap.put("004","004");//机动车损失保险(IACJQL0001)
			platFormMap.put("009","009");//附加绝对免赔特约险全面型
			platFormMap.put("010","010");//附加车轮单独损坏除外特约险全面型
		}else if (codeType.equals("FGKindCodeIn")) {
			platFormMap.put("A",    "001"); // 车损险
			platFormMap.put("B",    "002"); // 三者责任险
			platFormMap.put("D3",   "003"); // 司机座位险
			platFormMap.put("D4",   "006"); // 乘客座位险
			platFormMap.put("G",    "007"); // 盗抢险
			platFormMap.put("F",    "201"); // 玻璃单独破碎险
			platFormMap.put("Z",    "202"); // 自燃损失险
			platFormMap.put("X",    "203"); // 新增加设备损失险
			platFormMap.put("L",    "205"); // 车身划痕损失险
			platFormMap.put("X3",   "206"); // 发动机涉水损失险
			platFormMap.put("W",    "207"); // 修理期间费用补偿险
			platFormMap.put("D2",   "208"); // 车上货物责任险
			platFormMap.put("X5",   "210"); // 机动车损失保险无法找到第三方特约险
			platFormMap.put("P",    "211"); // 指定修理厂险
			platFormMap.put("X6",   "212"); // 起重、装卸、挖掘车辆损失扩展条款
			platFormMap.put("X7",   "213"); // 特种车辆固定设备、仪器损坏扩展条款
			platFormMap.put("R",    "216"); // 精神损害抚慰金责任险
			platFormMap.put("BZ",   "BZ"); //
			platFormMap.put("FB",  "008"); // 机动车三者假日翻倍险
			platFormMap.put("008",  "008"); // 机动车三者假日翻倍险
			platFormMap.put("MA",   "801"); // 不计免赔率险（车辆损失保险）
			platFormMap.put("MB",   "802"); // 不计免赔率险（第三者责任保险）
			platFormMap.put("MD3",  "803"); // 不计免赔率险（车上人员责任保险（司机））
			platFormMap.put("MD4",  "806"); // 不计免赔率险（车上人员责任保险（司机））
			platFormMap.put("MG",   "807"); // 不计免赔率险（全车盗抢保险）
			platFormMap.put("MZ",   "902"); // 不计免赔率险（自燃损失险）
			platFormMap.put("MX",   "903"); // 不计免赔率险（新增加设备损失险）
			platFormMap.put("ML",   "905"); // 不计免赔率险（车身划痕损失险)
			platFormMap.put("MX3",  "906"); // 不计免赔率险（发动机涉水损失险)
			platFormMap.put("MD2",  "908"); // 不计免赔率险（车上货物责任险)
			platFormMap.put("MR",   "916"); // 不计免赔率险（精神损害抚慰金责任险)
			platFormMap.put("004","004");//机动车损失保险(IACJQL0001)
			platFormMap.put("009","009");//附加绝对免赔特约险全面型
			platFormMap.put("010","010");//附加车轮单独损坏除外特约险全面型
		}
		else {
			platFormMap = null;
			systemMap = null;
		}
	}
}
