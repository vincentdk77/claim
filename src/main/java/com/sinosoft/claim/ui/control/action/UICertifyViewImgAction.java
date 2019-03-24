package com.sinosoft.claim.ui.control.action;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.net.TelnetInputStream;
import sun.net.ftp.FtpClient;

import com.sinosoft.claim.bl.facade.BLCertifyImgFacade;
import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.sysframework.reference.AppConfig;

public class UICertifyViewImgAction extends HttpServlet {
	public UICertifyViewImgAction() {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strBusinessNo = request.getParameter("BusinessNo"); // 报案号
		String strSerialNo = request.getParameter("SerialNo"); // 序列号
		String writedir = (String) AppConfig.get("sysconst.WRITEDIR");
		String ftpUrl = (String) AppConfig.get("sysconst.FTP_URL");
		String ftpUser = (String) AppConfig.get("sysconst.FTP_USER");
		String ftpPass = (String) AppConfig.get("sysconst.FTP_PASS");
		OutputStream outputStream = null;
		String strContentType = "";
		FtpClient ftpClient = new FtpClient();
		TelnetInputStream inputStream = null;
		ByteArrayOutputStream byteOut = null;
		try {
			BLCertifyImgFacade blCertifyImgFacade = new BLCertifyImgFacade();
			ArrayList collection = (ArrayList) blCertifyImgFacade
					.findByConditions("businessno='" + strBusinessNo
							+ "' and SerialNo='" + strSerialNo + "'");

			// 如果没有数据(正常情况肯定是有数据的)就返回，而不应该在向下执行程序
			if (collection == null || collection.size() < 1) {
				return;
			}

			PrpLcertifyImgDto prpLcertifyImgDto = (PrpLcertifyImgDto) collection
					.get(0);
			String address = prpLcertifyImgDto.getPicPath() + "/"
					+ prpLcertifyImgDto.getImgFileName();
			String fileaddress = writedir + address;
			String ext = (prpLcertifyImgDto.getImgFileName()).trim().substring(
					(prpLcertifyImgDto.getImgFileName()).trim()
							.lastIndexOf('.')).substring(0, 2);
	
			// 用ftp方式从服务器上取得文件
			ftpClient.openServer(ftpUrl);
			ftpClient.login(ftpUser, ftpPass);
			ftpClient.binary();
			inputStream = ftpClient.get(fileaddress);
			
			byte[] buff = new byte[1024];
			byteOut = new ByteArrayOutputStream();
			int read = 0;
			while ((read = inputStream.read(buff)) > 0) {
				byteOut.write(buff, 0, read);
			}
			byte[] data = byteOut.toByteArray();
			
			
			if (ext.equals(".j")) {
				strContentType = "image/jpeg";
			}
			if (ext.equals(".g")) {
				strContentType = "image/gif";
			}
			if (ext.equals(".d")) {
				strContentType = "application/msword";
			}
			response.setContentType(strContentType);
			outputStream = response.getOutputStream();
			outputStream.write(data);
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			inputStream.close();
			byteOut.close();
			ftpClient.closeServer();
			outputStream.close();
		}
	}
}
