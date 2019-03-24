package com.sinosoft.claim.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sinosoft.sysframework.reference.AppConfig;

/**
 * 呼叫中心接口传输日志。
 * @author chu 20140515
 *
 */
public class CallCenterInterfaceLogger {
	public static String logPath = AppConfig.get("sysconst.CALLCENTERINTERFACELOGPATH");
	
	public static synchronized void log(String interfaceName,long serial,Exception ex){
			messageError(interfaceName,serial,ex);
		
	}
	/**
	 * 
	 * @param interfaceName（接口名称）
	 * @param dataType数据类型（1入参参数，0返回数据）
	 * @param data（数据）
	 */
	public static synchronized void log(String interfaceName,int dataType,long serial,String data){
		RandomAccessFile in = null;
		try{
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			
			String filePath = logPath + File.separator + year;
			filePath += File.separator + month;
			filePath += File.separator + day;
			
			File dir = new File(filePath);
			if(!dir.exists()){
				dir.mkdirs();
			}
			String strDataType ="";
			if(dataType==1){
				strDataType = "入参参数";
			}else if(dataType==0){
				strDataType = "返回数据";
			}else{
				strDataType = "数据";
			}
			String time = sf.format(cal.getTime());
			String message = "\r\n序号："+serial+"\r\n" +time +":"+strDataType+ "\r\n" + data + "\r\n";
			in = new RandomAccessFile(filePath + File.separator + interfaceName+".log", "rw");
			in.seek(in.length());
			in.write(message.getBytes("UTF-8"));
		}catch(Exception e){
			e.printStackTrace();
			CallCenterInterfaceLogger.objectToXmlErrMessage(e);
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				CallCenterInterfaceLogger.objectToXmlErrMessage(e);
			}
		}
	}
	/**
	 * 
	 * @param interfaceName（接口名称）
	 * @param dataType数据类型（1入参参数，0返回数据）
	 * @param obj（数据对象）
	 */
	public static synchronized void log(String interfaceName,int dataType,long serial,Object obj){
		RandomAccessFile in = null;
		try{
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			
			String filePath = logPath + File.separator + year;
			filePath += File.separator + month;
			filePath += File.separator + day;
			
			File dir = new File(filePath);
			if(!dir.exists()){
				dir.mkdirs();
			}
			String strDataType ="";
			if(dataType==1){
				strDataType = "入参参数";
			}else if(dataType==0){
				strDataType = "返回数据";
			}else{
				strDataType = "数据";
			}
			String time = sf.format(cal.getTime());
			String strData = CallCenterInterfaceLogger.getData(obj);
			String message = "\r\n序号："+serial+"\r\n" +time +":"+strDataType+ "\r\n" + strData + "\r\n";
			in = new RandomAccessFile(filePath + File.separator + interfaceName+".log", "rw");
			in.seek(in.length());
			in.write(message.getBytes("UTF-8"));
		}catch(Exception e){
			e.printStackTrace();
			CallCenterInterfaceLogger.objectToXmlErrMessage(e);
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				CallCenterInterfaceLogger.objectToXmlErrMessage(e);
			}
		}
	}
	/**
	 * 
	 * @param interfaceName（接口名称）
	 * @param dataType数据类型（1入参参数，0返回数据）
	 * @param obj（数据对象数组）
	 */
	public static synchronized void log(String interfaceName,int dataType,long serial,Object[] objs){
		RandomAccessFile in = null;
		try{
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			
			String filePath = logPath + File.separator + year;
			filePath += File.separator + month;
			filePath += File.separator + day;
			
			File dir = new File(filePath);
			if(!dir.exists()){
				dir.mkdirs();
			}
			String strDataType ="";
			if(dataType==1){
				strDataType = "入参参数";
			}else if(dataType==0){
				strDataType = "返回数据";
			}else{
				strDataType = "数据";
			}
			String time = sf.format(cal.getTime());
			String strData = "";
			if(objs == null){
				strData = "null";
			}else if(objs.length==0){
				strData = "length==0";
			}else{
				for(Object obj:objs){
					strData += CallCenterInterfaceLogger.getData(obj);
				}
			}
			String message = "\r\n序号："+serial+"\r\n"  +time +":"+strDataType+ "\r\n" + strData + "\r\n";
			in = new RandomAccessFile(filePath + File.separator + interfaceName+".log", "rw");
			in.seek(in.length());
			in.write(message.getBytes("UTF-8"));
		}catch(Exception e){
			e.printStackTrace();
			CallCenterInterfaceLogger.objectToXmlErrMessage(e);
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				CallCenterInterfaceLogger.objectToXmlErrMessage(e);
			}
		}
	}
	public static synchronized void messageError(String interfaceName,long serial,Exception e){
		PrintWriter pw = null;
		RandomAccessFile in = null;
		try{
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			
			String filePath = logPath + File.separator + year;
			filePath += File.separator + month;
			filePath += File.separator + day;
			
			File dir = new File(filePath);
			if(!dir.exists()){
				dir.mkdirs();
			}
			StringWriter sw = new StringWriter();
			pw = new PrintWriter(sw,true);
			e.printStackTrace(pw);
			pw.flush();
			in = new RandomAccessFile(filePath + File.separator + interfaceName+"ErrMessage.log", "rw");
			
			
		    in.seek(in.length());
		    String message = sf.format(cal.getTime()) +"\r\n序号："+serial+"\r\n"+ e.getMessage() + "\r\n" + sw.toString();
		    in.write(message.getBytes("UTF-8"));
			
		}catch(Exception ex){
			ex.printStackTrace();
			CallCenterInterfaceLogger.objectToXmlErrMessage(ex);
		}finally{
			try {
				in.close();
			} catch (IOException e1) {
				e1.printStackTrace();
				CallCenterInterfaceLogger.objectToXmlErrMessage(e1);
			}
		}
	}
	
	
	//------- 以下是处理对象为xml方法------------------------------------------------
	 
	private static String  getData(Object o){
		String strData = "";
		try {
			if(o==null){
				strData +="null"; 
				return strData;
			}
			List list = getFiledsInfo(o);
			for(int i = 0;i<list.size();i++){
				HashMap hashMap = (HashMap) list.get(i);
				//数组
				if("array".equals(hashMap.get("type"))){
					Object[] objs = (Object[]) hashMap.get("value");
					String arrayName = (String) hashMap.get("name");
					if(objs == null){
						strData += toStartXml(arrayName)+"null"+toEndXml(arrayName);
					}else if(objs.length==0){
						strData += toStartXml(arrayName)+"length==0"+toEndXml(arrayName);
					}else{
						for(int j = 0;j<objs.length;j++){
							Object obj = objs[j];
							if(obj == o){
								continue;
							}
							if(obj instanceof String ){
								strData += toStartXml(arrayName)+(String)obj+toEndXml(arrayName);
								
							}else{
								strData += toStartXml(arrayName)+getData(obj)+toEndXml(arrayName);
							}
						}
					}
						//基本类型加String
				}else if("putong".equals(hashMap.get("type"))){
					strData += toStartXml((String)hashMap.get("name"))+hashMap.get("value")+toEndXml((String)hashMap.get("name"));
					//日期类型
				}else if("Date".equals(hashMap.get("type"))){
					Object obj = hashMap.get("value");
					String date = "";
					if(obj!=null){
						date = obj.toString();
					}
					strData += toStartXml((String)hashMap.get("name"))+date+toEndXml((String)hashMap.get("name"));
					//集合类型
				}else{
					Object obj =  hashMap.get("value");
					String collectionName = (String) hashMap.get("name");
					if(obj!=null){
						strData += toStartXml(collectionName)+getData(obj)+toEndXml(collectionName);
					}else if(obj == o){
						
					}else{
						strData += toStartXml(collectionName)+"null"+toEndXml(collectionName);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			CallCenterInterfaceLogger.objectToXmlErrMessage(e);
		}
		return strData;
	}
	
	private static String toStartXml(String name){
		String startXml ="";
		startXml = "<"+name+">";
		return startXml;
	}
	private static String toEndXml(String name){
		String endXml ="";
		endXml = "<\\"+name+">\r\n";
		return endXml;
	}
	
	 /** 
	    * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list 
	    * */  
	   private static List getFiledsInfo(Object o){  
	    Field[] fields=o.getClass().getDeclaredFields();  
	        String[] fieldNames=new String[fields.length];  
	        List list = new ArrayList();  
	        Map infoMap=null;  
	    for(int i=0;i<fields.length;i++){  
	        infoMap = new HashMap(); 
	        String type = "";
	        if(fields[i].getType().isArray()){
	        	type = "array";
	        }else if(fields[i].getType() == String.class||fields[i].getType().isPrimitive()){
	        	type = "putong";
	        }else if(fields[i].getType() == java.util.Date.class
	        		||fields[i].getType() == com.sinosoft.sysframework.common.datatype.DateTime.class){
	        	type = "Date";
	        }else{
	        	type = "other";
	        }
	        String name = fields[i].getName();
	        
	        	 if(!"serialVersionUID".equals(name)){
	        		 try {
		 	        	infoMap.put("type", type);  
		 	        	infoMap.put("name", fields[i].getName());  
		 	        	infoMap.put("value", getFieldValueByName(fields[i].getName(), o));  
		 	        	list.add(infoMap);  
	        	 	} catch (Exception e) {
	        	 	}
	 	         }
	       
	    }  
	    return list;  
	   }  
	/** 
	 * 根据属性名获取属性值 
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * */  
	private static Object getFieldValueByName(String fieldName, Object o) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {  
	         String firstLetter = fieldName.substring(0, 1).toUpperCase();    
	         String getter = "get" + firstLetter + fieldName.substring(1);    
	         Method method = o.getClass().getMethod(getter, new Class[] {});    
	         Object value = method.invoke(o, new Object[] {});    
	         return value;    
	 }
	
	public static synchronized void objectToXmlErrMessage(Exception e){
		PrintWriter pw = null;
		RandomAccessFile in = null;
		try{
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			
			String filePath = logPath + File.separator + year;
			filePath += File.separator + month;
			filePath += File.separator + day;
			
			File dir = new File(filePath);
			if(!dir.exists()){
				dir.mkdirs();
			}
			StringWriter sw = new StringWriter();
			pw = new PrintWriter(sw,true);
			e.printStackTrace(pw);
			pw.flush();
			in = new RandomAccessFile(filePath + File.separator + "objectToXmlErrMessage.log", "rw");
			
			
		    in.seek(in.length());
		    String message = sf.format(cal.getTime()) + e.getMessage() + "\r\n" + sw.toString();
		    in.write(message.getBytes("UTF-8"));
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e1) {
			}
		}
	}
}
