package com.sinosoft.claimciplatform.dto.custom;

public class Iconstants {
	private Iconstants(){
		//��ֹ����
	}
	/**
	 * ��������
	 * @author mdd
	 *
	 */
	public static class RequstType{
		/**
		 * �������ݽ���
		 */
		public static String REGIST = "50";	
		/**
		 * �������ݽ���
		 */
		public static String CLAIM = "51";	
		/**
		 * �᰸���ݽ���
		 */
		public static String ENDCASE = "52";
		/**
		 * �᰸׷�����ݽ���
		 */
		public static String ENDCASE_APPEND = "53";	
		/**
		 * ����ע��	
		 */
		public static String CANCELCASE = "54";	
		
		/**
		 * ����ע����ͨ��������ע����������������ϵͳ���øýӿڿ��ʱʹ�ã���Jar������ʱʹ��CANCELCASE
		 */
		public static String CANCEL_REGIST_CASE = "54-1";
		
		/**
		 * ����ע����ͨ��������ע����������������ϵͳ���øýӿڿ��ʱʹ�ã���Jar������ʱʹ��CANCELCASE
		 */
		public static String CANCEL_CLAIM_CASE = "54-2";
        /**
         * �¹���Ϣ�ϴ�������������ϵͳ���øýӿڿ��ʱʹ�ã���Jar������ʱʹ��CANCELCASE
         */
        public static String COMPELCRASH_UPLOAD = "K1";
        /**
         * �¹���Ϣ��д������������ϵͳ���øýӿڿ��ʱʹ�ã���Jar������ʱʹ��CANCELCASE
         */
        public static String COMPELCRASH_DOWNLOAD = "K2";
        
        
	}
	/**
	 * ���������־
	 * 
	 * @author ��Ԫ��Ŀ��
	 */
	public static class SelfPayFlag{
		/**
		 * �ǻ�������
		 */
		public static String NOTSELFPAYFLAG = "0";	
		/**
		 * ��������
		 */
		public static String ISSELFPAYFLAG = "1";	
	}
	/**
	 * ƽ̨���ش�����
	 * @author mdd
	 *
	 */
	public static class ReturnType{
		/**
		 * ����������ȷ����������ֵ
		 */
		public static String SUCCESS = "1";	
		/**
		 * �������������޷���������ֵ
		 */
		public static String INVALID_INPUTDATA = "0";	
		/**
		 * ϵͳδ֪����
		 */
		public static String UNKNOW_ERROR = "E";
	}
	/**
	 * �⳥����
	 * @author mdd
	 *
	 */
	public static class LossType{
		/**
		 * ҽ�Ʒ����⳥
		 */
		public static String MEDICAL = "2";	
		/**
		 * �����˲��⳥ 
		 */
		public static String DEATH_CRIPPLE = "1";
		/**
		 * �Ʋ���ʧ�⳥
		 */
		public static String PROPERTY = "3";
		/**
		 * �����⳥
		 */
		public static String OTHER = "4";
		/**
		 * ����ҽ�Ʒ���
		 */
		public static String NODUTYMEDICAL = "6";
		/**
		 * �������������˲�
		 */
		public static String NODUTY_DEATH_CRIPPLE = "5";
		/**
		 * ����Ʋ���ʧ
		 */
		public static String NODUTY_PROPERTY = "7";
		/**
		 * ��������
		 */
		public static String NODUTY_OTHER = "8";
		
	}
	/**
	 * �������ʹ���
	 * @author mdd
	 *
	 */
	public static class RiskCodeType{
		/**
		 * ǿ��������
		 */
		public static String COMPEL_THIRD= "1";
		/**
		 * ��ҵ������
		 */
		public static String BUSINESS_THIRD= "2";
		/**
		 * ��ҵ������
		 */
		public static String BUSINESS_MAIN= "3";
		/**
		 * ����
		 */
		public static String OTHER= "9";
	}
	/**
	 * ��������
	 * @author mdd
	 *
	 */
	public static class CaseType{
		/**
		 * ��������
		 */
		public static String NORMAL = "1";
		/**
		 * �����ⰸ
		 */
		public static String IRRESPONSIBILITY = "2";
		/**
		 * �渶�ⰸ
		 */
		public static String PRE_PAY = "3";
		/**
		 * �渶��������
		 */
		public static String PRE_FUND = "4";
		/**
		 * ����
		 */
		public static String OTHER = "9";
		
	}
	/**
	 * ����״̬
	 * @author mdd
	 *
	 */
	public static class CaseStatus{
		/**
		 *@decription �ѱ���
		 */
		public static String REGIST = "1";
		
		/**
		 *@decription ����ע��
		 */
		public static String REGIST_CANCEL = "2";
		
		/**
		 *@decription ������
		 */
		public static String CLAIM = "3";
		
		/**
		 *@decription ����ע��
		 */
		public static String CLAIM_CANCEL = "4";
		
		/**
		 *@decription �ѽ᰸
		 */
		public static String ENDCASE = "5";
		
		/**
		 *@decription ����
		 */
		public static String OTHER = "9";
		
	}

	/**
	 * �渶ԭ�����
	 * @author sinosoft
	 */
	public static class PrePayCause{
		
		/**
		 *@decription ��ʻԱ��֤��ʻ���ʻԱ��Ƽ�ʻ
		 */
		public static String DRIVING_WITHOUT_LICENSE = "1";
		
		/**
		 *@decription �����������ڼ�����
		 */
		public static String ACCIDENT_IN_STEAL = "2";
		
		/**
		 *@decription �������˹�����Ϊ
		 */
		public static String INTENTIONAL_ACTION = "3";
		
		/**
		 *@decription ����
		 */
		public static String OTHER = "4";
	}
	
	/**
	 * ��ʧ�⳥������ϸ�����Ʋ��⳥����
	 * @author sinosoft
	 */
	public static class LossTypeProp{
		/**
		 * @decription ����
		 */
		public static String LOSSTYPEPROP_CAR = "1";
		
		/**
		 * @decription ����
		 */
		public static String LOSSTYPEPROP_OTHER = "9";
	}
}
