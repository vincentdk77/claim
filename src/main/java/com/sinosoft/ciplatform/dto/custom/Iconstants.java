package com.sinosoft.ciplatform.dto.custom;

public class Iconstants {
	private Iconstants(){
		//禁止构造
	}
	/**
	 * 请求类型
	 * @author mdd
	 *
	 */
	public static class RequstType{
		/**
		 * 报案数据交互
		 */
		public static String REGIST = "50";	
		/**
		 * 商业险报案数据交互
		 */
		public static String REGIST_SYX = "80";	
		/**
		 * 立案数据交互
		 */
		public static String CLAIM = "51";	
		/**
		 * 商业险立案数据交互
		 */
		public static String CLAIM_SYX = "81";
		/**
		 * 理算数据交互
		 */
		public static String COMPENSATE = "55";	
		/**
		 * 商业险理算数据交互
		 */
		public static String COMPENSATE_SYX = "84";
		/**
		 * 结案数据交互
		 */
		public static String ENDCASE = "52";
		/**
		 * 商业险结案数据交互
		 */
		public static String ENDCASE_SYX = "82";
		/**
		 * 查勘定损核损数据交互
		 */
		public static String CHECKVERIFY = "56";
		/**
		 * 商业险查勘定损核损数据交互
		 */
		public static String CHECKVERIFY_SYX = "86";
		/**
		 * 单证数据交互
		 */
		public static String CERTIFY = "57";
		/**
		 * 单证数据交互
		 */
		public static String CERTIFY_SYX = "57SYX";
		/**
		 * 上海支付信息数据交互
		 */
		public static String PAYINFORSH = "58";
		/**
		 * 上海支付信息数据交互
		 */
		public static String PAYINFORSH_SYX = "58SYX";
//		/**
//		 * 支付信息数据交互
//		 */
//		public static String PAYINFOR = "55";
//		/**
//		 * 支付信息数据交互
//		 */
//		public static String PAYINFOR_SYX = "84";
		/**
		 * 结案追加数据交互
		 */
		public static String ENDCASE_APPEND = "53";	
		/**
		 * 商业险结案追加数据交互
		 */
		public static String ENDCASE_APPEND_SYX  = "85";	
		/**
		 * 案件注销	
		 */
		public static String CANCELCASE = "54";	
		/**
		 * 商业险案件注销	
		 */
		public static String CANCELCASE_SYX = "83";
		
		/**
		 * 报案注销（通过报案号注销），仅用于理赔系统调用该接口框架时使用，本Jar包测试时使用CANCELCASE
		 */
		public static String CANCEL_REGIST_CASE = "54-1";
		public static String CANCEL_REGISTSYX_CASE = "83-1";
		
		/**
		 * 立案注销（通过立案号注销），仅用于理赔系统调用该接口框架时使用，本Jar包测试时使用CANCELCASE
		 */
		public static String CANCEL_CLAIM_CASE = "54-2";
		public static String CANCEL_CLAIMSYX_CASE = "83-2";
        /**
         * 事故信息上传，仅用于理赔系统调用该接口框架时使用，本Jar包测试时使用CANCELCASE
         */
        public static String COMPELCRASH_UPLOAD = "K1";
        /**
         * 事故信息回写，仅用于理赔系统调用该接口框架时使用，本Jar包测试时使用CANCELCASE
         */
        public static String COMPELCRASH_DOWNLOAD = "K2";
        /**
		 * 交强险案件重复注销	
		 */
		public static String REPCANCEL_REGIST_CASE = "54-3";
        
        
        
        /**
         * 北京无责赔付信息回写请求类型
         */
        public static String NODUTYPAY_DOWNLOAD="D1";
        public static String NODUTYPAY_ENDCASE_DOWNLOAD="D7";
        
        
	}
	/**
	 * 浙江商业险请求类型
	 * @author mdd
	 *
	 */
	public static class ZJRequstType{
		/**
		 * 商业险报案数据交互
		 */
		public static String REGIST_SYX = "V3101";	
		/**
		 * 商业险立案数据交互
		 */
		public static String CLAIM_SYX = "V3102";
		/**
		 * 商业险赔付登记数据交互
		 */
		public static String COMPENSATE_SYX = "V3106";
		/**
		 * 商业险结案数据交互
		 */
		public static String ENDCASE_SYX = "V3104";
		/**
		 * 商业险结案追加数据交互
		 */
		public static String ENDCASE_APPEND_SYX = "V3105";
		/**
		 * 商业险注销数据交互
		 */
		public static String CANCEL_CASE = "V34";
		/**
		 * 商业险收付数据交互
		 */
		public static String PAYINFOR_SYX = "V3106";
		public static String RECASE_SYX = "V3111";
				/**
		 * 商业险理算核赔数据交互
		 */
		public static String COMPENSATEVERIC_SYX = "V3110";
		/**
		 * 商业险收付数据交互
		 */
		public static String ACCOUNTS_NO_SYX = "V3205";
	}
	/**
	 * 平台返回处理结果
	 * @author mdd
	 *
	 */
	public static class ReturnType{
		/**
		 * 输入数据正确，返回正常值
		 */
		public static String SUCCESS = "1";	
		/**
		 * 输入数据有误，无法返回正常值
		 */
		public static String INVALID_INPUTDATA = "0";	
		/**
		 * 系统未知错误
		 */
		public static String UNKNOW_ERROR = "E";
	}
	/**
	 * 赔偿类型
	 * @author mdd
	 *
	 */
	public static class LossType{
		/**
		 * 医疗费用赔偿
		 */
		public static String MEDICAL = "2";	
		/**
		 * 死亡伤残赔偿 
		 */
		public static String DEATH_CRIPPLE = "1";
		/**
		 * 财产损失赔偿
		 */
		public static String PROPERTY = "3";
		/**
		 * 无责其它赔偿
		 */
		public static String OTHER = "4";
		
		/**
		 * 无责医疗费用赔偿
		 */
		public static String NODUTY_MEDICAL = "5";	
		/**
		 * 无责死亡伤残赔偿 
		 */
		public static String NODUTY_DEATH_CRIPPLE = "6";
		/**
		 * 无责财产损失赔偿
		 */
		public static String NODUTY_PROPERTY = "7";
		
		/**
		 * 无责其它赔偿
		 */
		public static String NODUTY_OTHER = "8";
	}
	public static class SHLossType{
		/**
		 * 车辆损失
		 */
		public static String carLoss = "1";	
		/**
		 * 盗抢
		 */
		public static String lostLoss = "2";
		/**
		 * 人伤损失
		 */
		public static String personLoss = "3";
		/**
		 * 物损
		 */
		public static String propLoss = "4";
	}
	/**
	 * 险种类型代码
	 * @author mdd
	 *
	 */
	public static class RiskCodeType{
		/**
		 * 强制三者险
		 */
		public static String COMPEL_THIRD= "1";
		/**
		 * 商业三者险
		 */
		public static String BUSINESS_THIRD= "2";
		/**
		 * 商业车损险
		 */
		public static String BUSINESS_MAIN= "3";
		/**
		 * 其它
		 */
		public static String OTHER= "4";
	}
	/**
	 * 理赔类型
	 * @author mdd
	 *
	 */
	public static class CaseType{
		/**
		 * 有责涉及死亡的赔案
		 */
		public static String NORMAL_DEATH = "0";
		/**
		 * 正常理赔
		 */
		public static String NORMAL = "1";
		/**
		 * 无责赔案
		 */
		public static String IRRESPONSIBILITY = "2";
		/**
		 * 垫付赔案
		 */
		public static String PRE_PAY = "3";
		/**
		 * 垫付救助基金
		 */
		public static String PRE_FUND = "4";
		/**
		 * 其它
		 */
		public static String OTHER = "9";
		
	}
	/**
	 * 案件状态
	 * @author mdd
	 *
	 */
	public static class CaseStatus{
		/**
		 * 已报案
		 */
		public static String REGIST = "1";
		/**
		 * 报案注销
		 */
		public static String REGIST_CANCEL = "2";
		/**
		 * 已立案
		 */
		public static String CLAIM = "3";
		/**
		 * 立案注销
		 */
		public static String CLAIM_CANCEL = "4";
		/**
		 * 已结案
		 */
		public static String ENDCASE = "5";
		/**
		 * 其它
		 */
		public static String OTHER = "9";
		
	}
	/**
	 * 上海请求类型
	 * @author mdd
	 *
	 */
	public static class ReasonType{
		/**
		 * 诉讼
		 */
		public static String SS = "1";	
	}

}
