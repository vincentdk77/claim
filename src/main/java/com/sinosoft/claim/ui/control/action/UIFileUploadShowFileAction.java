package com.sinosoft.claim.ui.control.action;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.net.TelnetInputStream;
import sun.net.ftp.FtpClient;

import com.sinosoft.claim.bl.facade.BLPrpLcertifyImgFacade;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 *
 */
public class UIFileUploadShowFileAction extends HttpServlet {

	public void init() throws ServletException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ObjectInputStream is = new ObjectInputStream(request.getInputStream());
			String itype = (String) is.readObject();
			String separator = "_";
			String writePath = (String) AppConfig.get("sysconst.WRITEDIR");
			String ftpUrl = (String) AppConfig.get("sysconst.FTP_URL");
			String ftpUser = (String) AppConfig.get("sysconst.FTP_USER");
			String ftpPass = (String) AppConfig.get("sysconst.FTP_PASS");
			FtpClient ftpClient = new FtpClient();
			if (itype.equals("show")) {
				ftpClient.openServer(ftpUrl);
				ftpClient.login(ftpUser, ftpPass);
				ftpClient.binary();
				String address = (String) is.readObject();
				address = writePath + address;
				is.close();
				TelnetInputStream inputStream = ftpClient.get(address);
				ftpClient.closeServer();
				
				
				byte[] buff = new byte[1024];
				ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
				int read = 0;
				while ((read = inputStream.read(buff)) > 0) {
					byteOut.write(buff, 0, read);
				}
				byte[] data = byteOut.toByteArray();
				byteOut.close();
				
				ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
				out.writeObject("success");
				out.writeObject(data);
				out.close();
			}

			if (itype.equals("upload")) {
				ftpClient.openServer(ftpUrl);
				ftpClient.login(ftpUser, ftpPass);
				ftpClient.binary();
                String remoteFile = (String) is.readObject();
                // 从目录中取得单证类型信息（由于jar包相应的源码丢失，只能从路径中截串取得）
                String imageType = remoteFile.substring(42,46);
                String businessNo = remoteFile.substring(20,41);
                
                // 取得上传文件名称
				int remoteFileCount = getMaxNo(businessNo, imageType) + 1;
				String filename = imageType + separator + remoteFileCount
						+ remoteFile.substring(remoteFile.lastIndexOf('#') + 1);
				
				// 创建文件目录
				remoteFile = remoteFile.substring(0,remoteFile.lastIndexOf("/"));
				String remoteFiledir = writePath + remoteFile;
				createFtpDir(ftpUrl,ftpUser,ftpPass,remoteFiledir);
				
				// ftp上传文件
				byte[] fileData = (byte[]) is.readObject();
				OutputStream ftpOut = ftpClient.put(remoteFiledir + "/" + filename);
				ftpOut.write(fileData);
	            ftpOut.close();
                ftpClient.closeServer();
                
                // 返回提示信息
				ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
				out.writeObject("success");
				out.writeObject(filename);
				out.close();
			}
		} catch (IOException e) {
			ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
			out.writeObject("error_a");
			out.close();
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}	

	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPut(request, response);
	}	
	
	/**
	 * 根据业务号和单证类型取得单证文件的最大编号
	 * @param businessNo 业务号
	 * @param imageType 单证类型
	 * @return 最大编号
	 * @throws Exception
	 */
	public int getMaxNo(String businessNo, String imageType) throws Exception {
        int maxNo = 0;
        String strCondition = " businessNo = '"
				+ businessNo + "' and typeCode = '" + imageType + "'";
        BLPrpLcertifyImgFacade blPrpLcertifyImgFacade = new BLPrpLcertifyImgFacade();
        ArrayList imgList = (ArrayList)blPrpLcertifyImgFacade.findByConditions(strCondition);
        maxNo = imgList.size();
        return maxNo;
    }
	
	/**
	 * 创建ftp目录
	 * @param ftpUrl ftp URL
	 * @param ftpUser 用户名
	 * @param ftpPass 密码
	 * @param strDir 目录名称
	 * @throws Exception
	 */
	private void createFtpDir(String ftpUrl, String ftpUser, String ftpPass,
			String strDir) throws Exception {
		com.sinosoft.sysframework.transfer.FtpClient ftpClient = new com.sinosoft.sysframework.transfer.FtpClient();
		ftpClient.open(ftpUrl);
		ftpClient.login(ftpUser, ftpPass);
		ftpClient.mkdirs(strDir);
		ftpClient.close();
	}
}
