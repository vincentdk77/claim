package com.sinosoft.claimciplatform.util;

import java.util.HashMap;
import java.util.Map;

public class CodeTransfer {
	private Map platFormMap = new HashMap();
	private Map systemMap = new HashMap();

	/**
	 * �¹����δ���
	 */
	public static CodeTransfer IndemnityDuty = new CodeTransfer("IndemnityDuty");
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
	 * �渶ԭ��
	 */
	public static CodeTransfer PrePayCause = new CodeTransfer("PrePayCause");
	
	/**
	 * ��ʧ��ϸ����
	 */
	public static CodeTransfer PersonFeeTypeDetail = new CodeTransfer("PersonFeeTypeDetail");
	
	/**
	 * �����������
	 */
	public static CodeTransfer SelfPayFlag	= new CodeTransfer("SelfPayFlag");
	
	/**
	 * ���ִ���
	 */
	public static CodeTransfer RiskCodeType = new CodeTransfer("RiskCodeType");
	
	/**
	 * ��ʧ����
	 */
	public static CodeTransfer PersonFeeType = new CodeTransfer("PersonFeeType");	
	
	/**
	 * ͨ�÷�����ϵͳ����ת����ƽ̨����
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
					//��Map���Ҳ������򷵻ؿ��ַ������ɣ���ƽ̨���д���
				}
			}
		}
		//�ǿ��򷵻ؿ��ַ���
		return platFormCode==null?"":platFormCode;
	}
	/**
	 * ͨ�÷�����ƽ̨����ת����ϵͳ����
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
					//��Map���Ҳ������򷵻ؿ��ַ������ɣ���ƽ̨���д���
				}
			}
		}
		return systemCode;
	}
	
	/**
	 * ��ʧ���ʹ���ת����ϵͳ����ת����ƽ̨���룩
	 */
	public String covrentPFCodeForPersonFeeType(String indemnityDuty,String codeType){
		String platFormCode = "";
		codeType = "N_" + codeType;//Ĭ��δ����
		if(!"4".equals(indemnityDuty)){
			codeType = "Y_" + codeType;
		}		
		return covrentPlatFormCode(codeType);
	}	
	
	
	private CodeTransfer(String codeType) {
		if (codeType.equals("IndemnityDuty")) {
			platFormMap.put("0", "1"); // ȫ��
			platFormMap.put("1", "2"); // ����
			platFormMap.put("2", "3"); // ͬ��
			platFormMap.put("3", "4"); // ����
			platFormMap.put("4", "5"); // ����
			platFormMap.put("5", "9"); // ��������
			platFormMap.put("6", "9"); // �޷��ҵ�������
			platFormMap.put("9", "9"); // ����

			systemMap.put("1", "0"); // ȫ��
			systemMap.put("2", "1"); // ����
			systemMap.put("3", "2"); // ͬ��
			systemMap.put("4", "3"); // ����
			systemMap.put("5", "4"); // ����
			systemMap.put("9", "9"); // ����
		} else if (codeType.equals("CertiType")) {
			platFormMap.put("01", "01");// ���֤
			platFormMap.put("02", "99");// ���ڱ�
			platFormMap.put("03", "02");// ����
			platFormMap.put("04", "03");// ����֤
			platFormMap.put("05", "99");// ��ʻִ��
			platFormMap.put("06", "99");// ����֤
			platFormMap.put("59", "99");// ����
			platFormMap.put("61", "10");// ��֯��������֤
			platFormMap.put("62", "99");// ˰��Ǽ�֤
			platFormMap.put("63", "11");// ���̵Ǽ�֤
			platFormMap.put("99", "99");// ����
			
			systemMap.put("01", "01"); // �������֤
			systemMap.put("02", "03");// ����
			systemMap.put("03", "03");// ����֤
			systemMap.put("10", "99");// ��֯��������
			systemMap.put("11", "63");// ���̵Ǽ�֤
			systemMap.put("99", "99");// ����
		}  else if(codeType.equals("SelfPayFlag")){
			platFormMap.put("0","0");//һ���ⰸ
			platFormMap.put("1","0");//�پ��ⰸ
			platFormMap.put("2","0");//�ش󰸼�
			platFormMap.put("4","0");//˫���ⰸ
			platFormMap.put("5","0");//ͨ���ⰸ
			platFormMap.put("J","0");//��������
			platFormMap.put("K","1");//��������			
			
		} else if(codeType.equals("RiskCodeType")){
			platFormMap.put("0507", "1");// ��ǿ��
			//��ʱ����ת����Ŀǰ��û����ҵ��ƽ̨
			platFormMap.put("B", "2");// ��ҵ����
			platFormMap.put("A", "3");// ��ҵ����
			platFormMap.put("99", "9");// ��ҵ����
		} else if(codeType.equals("PersonFeeType")){
			platFormMap.put("Y_101","2");//ҽҩ��            
			platFormMap.put("Y_102","2");//���Ʒ�            
			platFormMap.put("Y_103","2");//סԺ��            
			platFormMap.put("Y_104","2");//סԺ��ʳ������    
			platFormMap.put("Y_105","2");//�������Ʒ�        
			platFormMap.put("Y_106","2");//���ݷ�            
			platFormMap.put("Y_107","2");//Ӫ����            
			platFormMap.put("Y_108","2");//ҽ��������        
			platFormMap.put("Y_201","1");//ɥ���            
			platFormMap.put("Y_202","1");//����������        
			platFormMap.put("Y_203","1");//�м��⳥��        
			platFormMap.put("Y_204","1");//�м��������߷�    
			platFormMap.put("Y_205","1");//�������������    
			platFormMap.put("Y_206","1");//�󹤷�            
			platFormMap.put("Y_207","1");//��ͨ��            
			platFormMap.put("Y_208","1");//��������ɥ�ύͨ��
			platFormMap.put("Y_209","1");//ס�޷�            
			platFormMap.put("Y_210","1");//�����            
			platFormMap.put("Y_211","1");//������            
			platFormMap.put("Y_212","1");//�����˲�������    
			platFormMap.put("Y_213","4");//����              
			                 
			platFormMap.put("N_101","6");//ҽҩ��            
			platFormMap.put("N_102","6");//���Ʒ�            
			platFormMap.put("N_103","6");//סԺ��            
			platFormMap.put("N_104","6");//סԺ��ʳ������    
			platFormMap.put("N_105","6");//�������Ʒ�        
			platFormMap.put("N_106","6");//���ݷ�            
			platFormMap.put("N_107","6");//Ӫ����            
			platFormMap.put("N_108","6");//ҽ��������        
			platFormMap.put("N_201","5");//ɥ���            
			platFormMap.put("N_202","5");//����������        
			platFormMap.put("N_203","5");//�м��⳥��        
			platFormMap.put("N_204","5");//�м��������߷�    
			platFormMap.put("N_205","5");//�������������    
			platFormMap.put("N_206","5");//�󹤷�            
			platFormMap.put("N_207","5");//��ͨ��            
			platFormMap.put("N_208","5");//��������ɥ�ύͨ��
			platFormMap.put("N_209","5");//ס�޷�            
			platFormMap.put("N_210","5");//�����            
			platFormMap.put("N_211","5");//������            
			platFormMap.put("N_212","5");//�����˲�������    
			platFormMap.put("N_213","7");//����           
			                 
		}else if(codeType.equals("PersonFeeTypeDetail")){
			//ҽ�Ʒ���
			platFormMap.put("101","01");//ҽҩ��            
			platFormMap.put("102","02");//���Ʒ�            
			platFormMap.put("103","03");//סԺ��            
			platFormMap.put("104","04");//סԺ��ʳ������    
			platFormMap.put("105","05");//�������Ʒ�        
			platFormMap.put("106","06");//���ݷ�            
			platFormMap.put("107","07");//Ӫ����            
			platFormMap.put("108","99");//ҽ��������    
			//�����˲�
			platFormMap.put("201","01");//ɥ���            
			platFormMap.put("202","02");//����������        
			platFormMap.put("203","06");//�м��⳥��        
			platFormMap.put("204","07");//�м��������߷�    
			platFormMap.put("205","11");//�������������    
			platFormMap.put("206","13");//�󹤷�            
			platFormMap.put("207","10");//��ͨ��            
			platFormMap.put("208","03");//��������ɥ�ύͨ��
			platFormMap.put("209","12");//ס�޷�            
			platFormMap.put("210","08");//�����            
			platFormMap.put("211","09");//������            
			platFormMap.put("212","99");//�����˲�������    
			//����
			platFormMap.put("213","9");//���� 
		} else {
			platFormMap = null;
			systemMap = null;
		}
	}
}
