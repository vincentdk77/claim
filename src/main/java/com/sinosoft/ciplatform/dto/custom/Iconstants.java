package com.sinosoft.ciplatform.dto.custom;

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
		 * ��ҵ�ձ������ݽ���
		 */
		public static String REGIST_SYX = "80";	
		/**
		 * �������ݽ���
		 */
		public static String CLAIM = "51";	
		/**
		 * ��ҵ���������ݽ���
		 */
		public static String CLAIM_SYX = "81";
		/**
		 * �������ݽ���
		 */
		public static String COMPENSATE = "55";	
		/**
		 * ��ҵ���������ݽ���
		 */
		public static String COMPENSATE_SYX = "84";
		/**
		 * �᰸���ݽ���
		 */
		public static String ENDCASE = "52";
		/**
		 * ��ҵ�ս᰸���ݽ���
		 */
		public static String ENDCASE_SYX = "82";
		/**
		 * �鿱����������ݽ���
		 */
		public static String CHECKVERIFY = "56";
		/**
		 * ��ҵ�ղ鿱����������ݽ���
		 */
		public static String CHECKVERIFY_SYX = "86";
		/**
		 * ��֤���ݽ���
		 */
		public static String CERTIFY = "57";
		/**
		 * ��֤���ݽ���
		 */
		public static String CERTIFY_SYX = "57SYX";
		/**
		 * �Ϻ�֧����Ϣ���ݽ���
		 */
		public static String PAYINFORSH = "58";
		/**
		 * �Ϻ�֧����Ϣ���ݽ���
		 */
		public static String PAYINFORSH_SYX = "58SYX";
//		/**
//		 * ֧����Ϣ���ݽ���
//		 */
//		public static String PAYINFOR = "55";
//		/**
//		 * ֧����Ϣ���ݽ���
//		 */
//		public static String PAYINFOR_SYX = "84";
		/**
		 * �᰸׷�����ݽ���
		 */
		public static String ENDCASE_APPEND = "53";	
		/**
		 * ��ҵ�ս᰸׷�����ݽ���
		 */
		public static String ENDCASE_APPEND_SYX  = "85";	
		/**
		 * ����ע��	
		 */
		public static String CANCELCASE = "54";	
		/**
		 * ��ҵ�հ���ע��	
		 */
		public static String CANCELCASE_SYX = "83";
		
		/**
		 * ����ע����ͨ��������ע����������������ϵͳ���øýӿڿ��ʱʹ�ã���Jar������ʱʹ��CANCELCASE
		 */
		public static String CANCEL_REGIST_CASE = "54-1";
		public static String CANCEL_REGISTSYX_CASE = "83-1";
		
		/**
		 * ����ע����ͨ��������ע����������������ϵͳ���øýӿڿ��ʱʹ�ã���Jar������ʱʹ��CANCELCASE
		 */
		public static String CANCEL_CLAIM_CASE = "54-2";
		public static String CANCEL_CLAIMSYX_CASE = "83-2";
        /**
         * �¹���Ϣ�ϴ�������������ϵͳ���øýӿڿ��ʱʹ�ã���Jar������ʱʹ��CANCELCASE
         */
        public static String COMPELCRASH_UPLOAD = "K1";
        /**
         * �¹���Ϣ��д������������ϵͳ���øýӿڿ��ʱʹ�ã���Jar������ʱʹ��CANCELCASE
         */
        public static String COMPELCRASH_DOWNLOAD = "K2";
        /**
		 * ��ǿ�հ����ظ�ע��	
		 */
		public static String REPCANCEL_REGIST_CASE = "54-3";
        
        
        
        /**
         * ���������⸶��Ϣ��д��������
         */
        public static String NODUTYPAY_DOWNLOAD="D1";
        public static String NODUTYPAY_ENDCASE_DOWNLOAD="D7";
        
        
	}
	/**
	 * �㽭��ҵ����������
	 * @author mdd
	 *
	 */
	public static class ZJRequstType{
		/**
		 * ��ҵ�ձ������ݽ���
		 */
		public static String REGIST_SYX = "V3101";	
		/**
		 * ��ҵ���������ݽ���
		 */
		public static String CLAIM_SYX = "V3102";
		/**
		 * ��ҵ���⸶�Ǽ����ݽ���
		 */
		public static String COMPENSATE_SYX = "V3106";
		/**
		 * ��ҵ�ս᰸���ݽ���
		 */
		public static String ENDCASE_SYX = "V3104";
		/**
		 * ��ҵ�ս᰸׷�����ݽ���
		 */
		public static String ENDCASE_APPEND_SYX = "V3105";
		/**
		 * ��ҵ��ע�����ݽ���
		 */
		public static String CANCEL_CASE = "V34";
		/**
		 * ��ҵ���ո����ݽ���
		 */
		public static String PAYINFOR_SYX = "V3106";
		public static String RECASE_SYX = "V3111";
				/**
		 * ��ҵ������������ݽ���
		 */
		public static String COMPENSATEVERIC_SYX = "V3110";
		/**
		 * ��ҵ���ո����ݽ���
		 */
		public static String ACCOUNTS_NO_SYX = "V3205";
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
		 * ���������⳥
		 */
		public static String OTHER = "4";
		
		/**
		 * ����ҽ�Ʒ����⳥
		 */
		public static String NODUTY_MEDICAL = "5";	
		/**
		 * ���������˲��⳥ 
		 */
		public static String NODUTY_DEATH_CRIPPLE = "6";
		/**
		 * ����Ʋ���ʧ�⳥
		 */
		public static String NODUTY_PROPERTY = "7";
		
		/**
		 * ���������⳥
		 */
		public static String NODUTY_OTHER = "8";
	}
	public static class SHLossType{
		/**
		 * ������ʧ
		 */
		public static String carLoss = "1";	
		/**
		 * ����
		 */
		public static String lostLoss = "2";
		/**
		 * ������ʧ
		 */
		public static String personLoss = "3";
		/**
		 * ����
		 */
		public static String propLoss = "4";
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
		public static String OTHER= "4";
	}
	/**
	 * ��������
	 * @author mdd
	 *
	 */
	public static class CaseType{
		/**
		 * �����漰�������ⰸ
		 */
		public static String NORMAL_DEATH = "0";
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
		 * �ѱ���
		 */
		public static String REGIST = "1";
		/**
		 * ����ע��
		 */
		public static String REGIST_CANCEL = "2";
		/**
		 * ������
		 */
		public static String CLAIM = "3";
		/**
		 * ����ע��
		 */
		public static String CLAIM_CANCEL = "4";
		/**
		 * �ѽ᰸
		 */
		public static String ENDCASE = "5";
		/**
		 * ����
		 */
		public static String OTHER = "9";
		
	}
	/**
	 * �Ϻ���������
	 * @author mdd
	 *
	 */
	public static class ReasonType{
		/**
		 * ����
		 */
		public static String SS = "1";	
	}

}
