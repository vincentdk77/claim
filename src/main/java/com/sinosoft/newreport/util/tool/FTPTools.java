package com.sinosoft.newreport.util.tool;

import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTPTools {
	/**
	 * Description: ��FTP�������ϴ��ļ�
	 * @param url FTP������hostName
	 * @param port FTP�������˿�
	 * @param userName FTP��¼�˺�
	 * @param password FTP��¼����
	 * @param path FTP����������Ŀ¼
	 * @param fileName �ϴ���FTP�������ϵ��ļ���
	 * @param input ������
	 * @return �ɹ�����true ʧ�ܷ���false
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
