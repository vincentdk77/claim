package com.sinosoft.claimciplatform.dto.custom;

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
		 * 立案数据交互
		 */
		public static String CLAIM = "51";	
		/**
		 * 结案数据交互
		 */
		public static String ENDCASE = "52";
		/**
		 * 结案追加数据交互
		 */
		public static String ENDCASE_APPEND = "53";	
		/**
		 * 案件注销	
		 */
		public static String CANCELCASE = "54";	
		
		/**
		 * 报案注销（通过报案号注销），仅用于理赔系统调用该接口框架时使用，本Jar包测试时使用CANCELCASE
		 */
		public static String CANCEL_REGIST_CASE = "54-1";
		
		/**
		 * 立案注销（通过立案号注销），仅用于理赔系统调用该接口框架时使用，本Jar包测试时使用CANCELCASE
		 */
		public static String CANCEL_CLAIM_CASE = "54-2";
        /**
         * 事故信息上传，仅用于理赔系统调用该接口框架时使用，本Jar包测试时使用CANCELCASE
         */
        public static String COMPELCRASH_UPLOAD = "K1";
        /**
         * 事故信息回写，仅用于理赔系统调用该接口框架时使用，本Jar包测试时使用CANCELCASE
         */
        public static String COMPELCRASH_DOWNLOAD = "K2";
        
        
	}
	/**
	 * 互碰自赔标志
	 * 
	 * @author 国元项目组
	 */
	public static class SelfPayFlag{
		/**
		 * 非互碰自赔
		 */
		public static String NOTSELFPAYFLAG = "0";	
		/**
		 * 互碰自赔
		 */
		public static String ISSELFPAYFLAG = "1";	
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
		 * 其它赔偿
		 */
		public static String OTHER = "4";
		/**
		 * 无责医疗费用
		 */
		public static String NODUTYMEDICAL = "6";
		/**
		 * 无责无责死亡伤残
		 */
		public static String NODUTY_DEATH_CRIPPLE = "5";
		/**
		 * 无责财产损失
		 */
		public static String NODUTY_PROPERTY = "7";
		/**
		 * 无责其它
		 */
		public static String NODUTY_OTHER = "8";
		
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
		public static String OTHER= "9";
	}
	/**
	 * 理赔类型
	 * @author mdd
	 *
	 */
	public static class CaseType{
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
		 *@decription 已报案
		 */
		public static String REGIST = "1";
		
		/**
		 *@decription 报案注销
		 */
		public static String REGIST_CANCEL = "2";
		
		/**
		 *@decription 已立案
		 */
		public static String CLAIM = "3";
		
		/**
		 *@decription 立案注销
		 */
		public static String CLAIM_CANCEL = "4";
		
		/**
		 *@decription 已结案
		 */
		public static String ENDCASE = "5";
		
		/**
		 *@decription 其它
		 */
		public static String OTHER = "9";
		
	}

	/**
	 * 垫付原因代码
	 * @author sinosoft
	 */
	public static class PrePayCause{
		
		/**
		 *@decription 驾驶员无证驾驶或驾驶员醉酒驾驶
		 */
		public static String DRIVING_WITHOUT_LICENSE = "1";
		
		/**
		 *@decription 机动车盗抢期间肇事
		 */
		public static String ACCIDENT_IN_STEAL = "2";
		
		/**
		 *@decription 被保险人故意行为
		 */
		public static String INTENTIONAL_ACTION = "3";
		
		/**
		 *@decription 其它
		 */
		public static String OTHER = "4";
	}
	
	/**
	 * 损失赔偿类型明细－－财产赔偿代码
	 * @author sinosoft
	 */
	public static class LossTypeProp{
		/**
		 * @decription 车辆
		 */
		public static String LOSSTYPEPROP_CAR = "1";
		
		/**
		 * @decription 其他
		 */
		public static String LOSSTYPEPROP_OTHER = "9";
	}
}
