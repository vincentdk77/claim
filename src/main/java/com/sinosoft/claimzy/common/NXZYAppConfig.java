package com.sinosoft.claimzy.common;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import com.sinosoft.sysframework.common.util.FileUtils;
import com.sinosoft.utility.InitComponent;

public class NXZYAppConfig implements InitComponent{
	private static boolean isInit = false;
	private static Map urlMap = new HashMap();
	private static Map treeMap = new HashMap();
    private static final File CONFIG_FILE = FileUtils.getUniqueFile(NXZYAppConfig.class, ".config");
    private static long lastModified = 0L;
    private static int configFileCount = 0;
    private static File localConfigFile;
	public static String getProperty(String comCode,String nodeName){
		if(!isInit){
			reconfigure();
		}
		if(comCode == null || comCode.length() < 2){
			return "";
		}
		String tempCode = comCode;
		Object obj = urlMap.get(tempCode);
		if(obj != null){
			Map subMap = (Map)obj;
			Object nodeValue = subMap.get(nodeName);
			if(nodeValue != null){
				return (String)nodeValue;
			}
			else{
				return "";
			}
		}else{
			return "";
		}
	}
	public static Map getUrlMap(){
		if(!isInit){
			reconfigure();
		}
		return urlMap;
	}

	public static String getProperty(String name){
		if(!isInit){
			reconfigure();
		}
		Object obj = treeMap.get(name);
		if(obj != null){
			return (String)obj;
		}else{
			return "";
		}
	}
	public void init(String configFile){
		
		try{
			treeMap.clear();
			urlMap.clear();
			FileUtils.write(configFile, CONFIG_FILE);
			configure(configFile);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public static void configure(String configFile){
		try{
			
			SAXReader sax = new SAXReader();
			Document doc = sax.read(new File(configFile));
			Element root = doc.getRootElement();
			List elements = root.selectNodes("NXZY_COM_LIST/NXZY_COM");
			for(int i = 0;i < elements.size();i++){
				Map subMap = new HashMap();
				Element element = (Element)elements.get(i);
				String comCode = element.elementText("COMCODE");
				List sub = element.elements();
				for(int j = 0;j < sub.size();j++){
					Element subElement = (Element)sub.get(j);
					subMap.put(subElement.getName(), subElement.getTextTrim());
				}
				urlMap.put(comCode,subMap);
			}
			Element params = root.element("NXZY_COMMON");
			elements = params.elements();
			
		
			for(int i = 0;i < elements.size();i++){
				Element element = (Element)elements.get(i);
				String nodeName = element.getName();
				String nodeValue = element.getTextTrim();
				treeMap.put(nodeName, nodeValue);
			}
			isInit = true;
			System.err.println("NXZY农险平台参数ClientInfo初始化成功.");
		}catch(Exception e){
			System.err.println("NXZY农险平台参数ClientInfo初始化失败.");
			e.printStackTrace();
		}
	}
	public static void reconfigure()
	{
	    try
	    {
	        if (CONFIG_FILE.exists()) {
	          String confPath = FileUtils.read(CONFIG_FILE);
	          if (new File(confPath).exists())
	            configure(confPath);
	        }
	        else{
	        	System.out.println("Init file " + CONFIG_FILE.getAbsolutePath() + " fail.");
	        }
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	}
}
