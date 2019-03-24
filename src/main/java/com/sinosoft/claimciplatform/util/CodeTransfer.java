package com.sinosoft.claimciplatform.util;

import java.util.HashMap;
import java.util.Map;

public class CodeTransfer {
	private Map platFormMap = new HashMap();
	private Map systemMap = new HashMap();

	/**
	 * 事故责任代码
	 */
	public static CodeTransfer IndemnityDuty = new CodeTransfer("IndemnityDuty");
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
	 * 垫付原因
	 */
	public static CodeTransfer PrePayCause = new CodeTransfer("PrePayCause");
	
	/**
	 * 损失明细代码
	 */
	public static CodeTransfer PersonFeeTypeDetail = new CodeTransfer("PersonFeeTypeDetail");
	
	/**
	 * 互碰自赔代码
	 */
	public static CodeTransfer SelfPayFlag	= new CodeTransfer("SelfPayFlag");
	
	/**
	 * 险种代码
	 */
	public static CodeTransfer RiskCodeType = new CodeTransfer("RiskCodeType");
	
	/**
	 * 损失类型
	 */
	public static CodeTransfer PersonFeeType = new CodeTransfer("PersonFeeType");	
	
	/**
	 * 通用方法，系统代码转换成平台代码
	 */
	public String covrentPlatFormCode(String code) {
		String platFormCode = "";
		if (code!=null&&code.trim().length()>0){
			if (platFormMap == null) {
				platFormCode = code;
			} else {
				try{
					platFormCode = (String) platFormMap.get(code);
				}finally{
					//在Map中找不到，则返回空字符串即可，由平台进行处理
				}
			}
		}
		//是空则返回空字符串
		return platFormCode==null?"":platFormCode;
	}
	/**
	 * 通用方法，平台代码转换成系统代码
	 */
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
	
	/**
	 * 损失类型代码转换（系统代码转换成平台代码）
	 */
	public String covrentPFCodeForPersonFeeType(String indemnityDuty,String codeType){
		String platFormCode = "";
		codeType = "N_" + codeType;//默认未无责
		if(!"4".equals(indemnityDuty)){
			codeType = "Y_" + codeType;
		}		
		return covrentPlatFormCode(codeType);
	}	
	
	
	private CodeTransfer(String codeType) {
		if (codeType.equals("IndemnityDuty")) {
			platFormMap.put("0", "1"); // 全责
			platFormMap.put("1", "2"); // 主责
			platFormMap.put("2", "3"); // 同责
			platFormMap.put("3", "4"); // 次责
			platFormMap.put("4", "5"); // 无责
			platFormMap.put("5", "9"); // 单方肇事
			platFormMap.put("6", "9"); // 无法找到第三方
			platFormMap.put("9", "9"); // 其它

			systemMap.put("1", "0"); // 全责
			systemMap.put("2", "1"); // 主责
			systemMap.put("3", "2"); // 同责
			systemMap.put("4", "3"); // 次责
			systemMap.put("5", "4"); // 无责
			systemMap.put("9", "9"); // 其它
		} else if (codeType.equals("CertiType")) {
			platFormMap.put("01", "01");// 身份证
			platFormMap.put("02", "99");// 户口薄
			platFormMap.put("03", "02");// 护照
			platFormMap.put("04", "03");// 军官证
			platFormMap.put("05", "99");// 驾驶执照
			platFormMap.put("06", "99");// 返乡证
			platFormMap.put("59", "99");// 其他
			platFormMap.put("61", "10");// 组织机构代码证
			platFormMap.put("62", "99");// 税务登记证
			platFormMap.put("63", "11");// 工商登记证
			platFormMap.put("99", "99");// 其他
			
			systemMap.put("01", "01"); // 居民身份证
			systemMap.put("02", "03");// 护照
			systemMap.put("03", "03");// 军人证
			systemMap.put("10", "99");// 组织机构代码
			systemMap.put("11", "63");// 工商登记证
			systemMap.put("99", "99");// 其他
		}  else if(codeType.equals("SelfPayFlag")){
			platFormMap.put("0","0");//一般赔案
			platFormMap.put("1","0");//速决赔案
			platFormMap.put("2","0");//重大案件
			platFormMap.put("4","0");//双代赔案
			platFormMap.put("5","0");//通融赔案
			platFormMap.put("J","0");//互碰案件
			platFormMap.put("K","1");//互碰自赔			
			
		} else if(codeType.equals("RiskCodeType")){
			platFormMap.put("0507", "1");// 交强险
			//暂时这样转换，目前还没有商业险平台
			platFormMap.put("B", "2");// 商业车损
			platFormMap.put("A", "3");// 商业车损
			platFormMap.put("99", "9");// 商业车损
		} else if(codeType.equals("PersonFeeType")){
			platFormMap.put("Y_101","2");//医药费            
			platFormMap.put("Y_102","2");//诊疗费            
			platFormMap.put("Y_103","2");//住院费            
			platFormMap.put("Y_104","2");//住院伙食补助费    
			platFormMap.put("Y_105","2");//后续治疗费        
			platFormMap.put("Y_106","2");//整容费            
			platFormMap.put("Y_107","2");//营养费            
			platFormMap.put("Y_108","2");//医疗其它费        
			platFormMap.put("Y_201","1");//丧葬费            
			platFormMap.put("Y_202","1");//死亡补偿费        
			platFormMap.put("Y_203","1");//残疾赔偿金        
			platFormMap.put("Y_204","1");//残疾辅助器具费    
			platFormMap.put("Y_205","1");//被抚养人生活费    
			platFormMap.put("Y_206","1");//误工费            
			platFormMap.put("Y_207","1");//交通费            
			platFormMap.put("Y_208","1");//家属办理丧葬交通费
			platFormMap.put("Y_209","1");//住宿费            
			platFormMap.put("Y_210","1");//护理费            
			platFormMap.put("Y_211","1");//康复费            
			platFormMap.put("Y_212","1");//死亡伤残其它费    
			platFormMap.put("Y_213","4");//其他              
			                 
			platFormMap.put("N_101","6");//医药费            
			platFormMap.put("N_102","6");//诊疗费            
			platFormMap.put("N_103","6");//住院费            
			platFormMap.put("N_104","6");//住院伙食补助费    
			platFormMap.put("N_105","6");//后续治疗费        
			platFormMap.put("N_106","6");//整容费            
			platFormMap.put("N_107","6");//营养费            
			platFormMap.put("N_108","6");//医疗其它费        
			platFormMap.put("N_201","5");//丧葬费            
			platFormMap.put("N_202","5");//死亡补偿费        
			platFormMap.put("N_203","5");//残疾赔偿金        
			platFormMap.put("N_204","5");//残疾辅助器具费    
			platFormMap.put("N_205","5");//被抚养人生活费    
			platFormMap.put("N_206","5");//误工费            
			platFormMap.put("N_207","5");//交通费            
			platFormMap.put("N_208","5");//家属办理丧葬交通费
			platFormMap.put("N_209","5");//住宿费            
			platFormMap.put("N_210","5");//护理费            
			platFormMap.put("N_211","5");//康复费            
			platFormMap.put("N_212","5");//死亡伤残其它费    
			platFormMap.put("N_213","7");//其他           
			                 
		}else if(codeType.equals("PersonFeeTypeDetail")){
			//医疗费用
			platFormMap.put("101","01");//医药费            
			platFormMap.put("102","02");//诊疗费            
			platFormMap.put("103","03");//住院费            
			platFormMap.put("104","04");//住院伙食补助费    
			platFormMap.put("105","05");//后续治疗费        
			platFormMap.put("106","06");//整容费            
			platFormMap.put("107","07");//营养费            
			platFormMap.put("108","99");//医疗其它费    
			//死亡伤残
			platFormMap.put("201","01");//丧葬费            
			platFormMap.put("202","02");//死亡补偿费        
			platFormMap.put("203","06");//残疾赔偿金        
			platFormMap.put("204","07");//残疾辅助器具费    
			platFormMap.put("205","11");//被抚养人生活费    
			platFormMap.put("206","13");//误工费            
			platFormMap.put("207","10");//交通费            
			platFormMap.put("208","03");//家属办理丧葬交通费
			platFormMap.put("209","12");//住宿费            
			platFormMap.put("210","08");//护理费            
			platFormMap.put("211","09");//康复费            
			platFormMap.put("212","99");//死亡伤残其它费    
			//其他
			platFormMap.put("213","9");//其他 
		} else {
			platFormMap = null;
			systemMap = null;
		}
	}
}
