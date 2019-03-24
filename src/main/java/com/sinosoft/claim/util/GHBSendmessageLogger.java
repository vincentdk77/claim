package com.sinosoft.claim.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.sinosoft.sysframework.reference.AppConfig;

/**
 * ���ӱ��ӿڴ�����־��
 * @author chu 20140515
 *
 */
public class GHBSendmessageLogger {
	public static String logPath = AppConfig.get("sysconst.GHBSENDLOGPATH");
	
	public static synchronized void log(long serial,Object obj){
		if(obj instanceof Exception){
			Exception ex = (Exception)obj;
			GHBSendMessageError(serial,ex);
		}
		else{
			String xml = (String)obj;
			GHBSendMessageData(serial,xml);
		}
	}
	public static synchronized void GHBSendMessageError(long serial,Exception e){
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
			in = new RandomAccessFile(filePath + File.separator + "GHBSendMessageError.log", "rw");
			
			
		    in.seek(in.length());
		    String message ="\r\n��ţ�"+serial+ "\r\n"+ sf.format(cal.getTime()) + e.getMessage() + "\r\n" + sw.toString();
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
	public static synchronized void GHBSendMessageData(long serial,String xml){
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
			String message = "\r\n��ţ�"+serial+ "\r\n"+time + "\r\n" + xml + "\r\n";
			in = new RandomAccessFile(filePath + File.separator + "GHBMessageData.log", "rw");
			in.seek(in.length());
			in.write(message.getBytes("UTF-8"));
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
