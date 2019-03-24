package com.sinosoft.claim.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.sinosoft.sysframework.reference.AppConfig;


public class SaveOrDeletePrplpayeeinfoLogger {
	public static String logPath = AppConfig.get("sysconst.PAYMENTPLATFORMLOGPATH");
	
	public static synchronized void log(Object obj){
		if(obj instanceof Exception){
			Exception ex = (Exception)obj;
			error(ex);
		}
		else{
			String xml = (String)obj;
			printData(xml);
		}
	}
	public static synchronized void error(Exception e){
		
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
			in = new RandomAccessFile(filePath + File.separator + "PrplpayeeinfoError.log", "rw");
		    in.seek(in.length());
		    String message = sf.format(cal.getTime()) + e.getMessage() + "\r\n" + sw.toString();
		    in.write(message.getBytes("GBK"));
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e1) {
			}
		}
	}
	public static synchronized void printData(String xml){
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
			String time = sf.format(cal.getTime());
			String message = time + "\r\n" + xml + "\r\n";
			in = new RandomAccessFile(filePath + File.separator + "PrplpayeeinfoPrintDate.log", "rw");
			in.seek(in.length());
			in.write(message.getBytes("GBK"));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}