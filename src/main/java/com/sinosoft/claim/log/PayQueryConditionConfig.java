package com.sinosoft.claim.log;

import java.io.InputStream;
import java.util.Properties;

/**
 * @reason 支付录人查询sql日志
 *
 */
public class PayQueryConditionConfig {

	private static PayQueryConditionConfig instance = null;
	
	private Properties properties = null;
	
	private PayQueryConditionConfig() {
		init();
	}
	
	public static PayQueryConditionConfig getInstance() {
		System.out.println("执行PayQueryConditionConfig中的getInstance方法!");
		
		if (instance == null) {
			instance = new PayQueryConditionConfig();
		}
		return instance;
	}
	
	/**
	 * 初始化配置文件
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
	 * 根据key值取得对应的value值
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
