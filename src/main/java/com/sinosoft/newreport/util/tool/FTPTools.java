package com.sinosoft.newreport.util.tool;

import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTPTools {
	/**
	 * Description: 向FTP服务器上传文件
	 * @param url FTP服务器hostName
	 * @param port FTP服务器端口
	 * @param userName FTP登录账号
	 * @param password FTP登录密码
	 * @param path FTP服务器保存目录
	 * @param fileName 上传到FTP服务器上的文件名
	 * @param input 输入流
	 * @return 成功返回true 失败返回false
	 */
	public static boolean uploadFile(String url, int port, String userName, String password, String path,
			String fileName, InputStream input){
		boolean result = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(url, port);
			ftp.login(userName, password);
			reply = ftp.getReplyCode();
			if(!FTPReply.isPositiveCompletion(reply)){
				ftp.disconnect();
				return result;
			}
			ftp.mkd(path);
			ftp.changeWorkingDirectory(path);
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			ftp.storeFile(fileName, input);
			input.close();
			ftp.logout();
			result = true;
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if(ftp.isConnected()){
				try{
					ftp.disconnect();
				} catch (Exception e){
					
				}
			}
		}
		return result;
	}
}
