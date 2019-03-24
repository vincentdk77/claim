package com.sinosoft.claim.log;

import java.io.InputStream;
import java.util.Properties;

/**
 * @reason ֧��¼�˲�ѯsql��־
 *
 */
public class PayQueryConditionConfig {

	private static PayQueryConditionConfig instance = null;
	
	private Properties properties = null;
	
	private PayQueryConditionConfig() {
		init();
	}
	
	public static PayQueryConditionConfig getInstance() {
		System.out.println("ִ��PayQueryConditionConfig�е�getInstance����!");
		
		if (instance == null) {
			instance = new PayQueryConditionConfig();
		}
		return instance;
	}
	
	/**
	 * ��ʼ�������ļ�
	 */
	public void init(){
		
		try{
			InputStream is = PayQueryConditionConfig.class.getResourceAsStream("/payQueryCondition_config.properties");
			properties = new Properties();
			properties.load(is);
			
		}catch (Exception e){
			throw new RuntimeException("Failed to get properties!");
		}
	}
	
	/**
	 * ����keyֵȡ�ö�Ӧ��valueֵ
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		return properties.getProperty(key);
	}

	/**
	 * @return the properties
	 */
	public Properties getProperties() {
		return properties;
	}
}
