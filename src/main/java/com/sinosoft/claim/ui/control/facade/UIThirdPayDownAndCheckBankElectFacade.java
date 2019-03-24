package com.sinosoft.claim.ui.control.facade;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.utility.error.UserException;



public class UIThirdPayDownAndCheckBankElectFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws UserException,Exception {
			java.io.BufferedInputStream bis=null;
		    java.io.BufferedOutputStream  bos=null;
		  try{
			  String queryType = request.getParameter("queryType");
		      String batchNo = request.getParameter("batchNo");
		      String resNo = request.getParameter("resNo");
		      Date nowDate = new Date();
		      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		      String date = sdf.format(nowDate);
		      String filePath = "/";
		      if(batchNo.length()==36){
		    	  filePath = date.substring(0,2)+batchNo.substring(30,32)+"/"+batchNo.substring(32,34)+"/"+batchNo.substring(34,36)+"/"+batchNo+"_"+resNo+".pdf";
		      }
		      if(batchNo.length()==29){
		    	  filePath =  batchNo.substring(15,19)+"/"+batchNo.substring(19,21)+"/"+batchNo.substring(21,23)+"/"+batchNo+"_"+resNo+".pdf";
		      }
			  String fileName = batchNo+"_"+resNo+".pdf";
		      FTPClient ftp = new FTPClient();
		      String ftpUser = AppConfig.get("sysconst.FTP_USER");
			  String ftpPass = AppConfig.get("sysconst.FTP_PASS");
			  String ftpUrl  = AppConfig.get("sysconst.FTP_URL");
			  String ftpDir  = AppConfig.get("sysconst.BACKELECT_WRITEDIR");
			  int ftpPort  = Integer.parseInt(AppConfig.get("sysconst.FTP_PORT"));
			  int reply;
				ftp.connect(ftpUrl, ftpPort);
				ftp.login(ftpUser, ftpPass);
				reply = ftp.getReplyCode();
				if(!FTPReply.isPositiveCompletion(reply)){
					ftp.disconnect();
					throw new Exception ("");
				}
				ftp.setFileType(FTP.BINARY_FILE_TYPE);
				String ftpPath = ftpDir;
				if(ftpPath!=null && !"".equals(ftpPath)){
					ftp.changeWorkingDirectory("/");
					String[] rootPaths = ftpPath.split("/");
					for(int i=0; i<rootPaths.length; i++){
						if(!"".equals(rootPaths[i])){
							ftp.changeWorkingDirectory(rootPaths[i]);
						}
					}
				}
				String path = filePath;
				String separator = "/";
				int lastIndex = filePath.lastIndexOf("/");
				if(lastIndex==-1){
					lastIndex = filePath.lastIndexOf("\\");
					separator = "\\\\";
				}
				String dir = path.substring(0, lastIndex);
				String[] dirs = dir.split(separator);
				for(String direct : dirs){
					ftp.changeWorkingDirectory(direct);
				}
				String[] listName = ftp.listNames();
				boolean ifUse = false;
				if(null!=listName && listName.length>0){
					for(int i=0;i<listName.length;i++){
						System.err.println("****"+listName[i]);
						if(fileName.equals(listName[i])){
							ifUse = true;
						}
					}
				}
				if(null!=queryType && "down".equals(queryType)){
					if(!ifUse){
						String strMessage = "该笔电子回执单尚未生成";
						response.getWriter().print("<script charset='gb2312' language='javascript' type='text/javascript' src='ntkoock.js'>alert('1235sdfd该笔电子回执单尚未生成')</script>");
					}else{
						response.setContentType("application/pdf");
						response.setHeader("Content-Disposition", "attachment;fileName="+fileName);
						OutputStream os = response.getOutputStream();
						ftp.retrieveFile(new String(fileName.getBytes("GBK"),"ISO-8859-1"), os);
						os.flush();
						os.close();
						ftp.logout();
					}
				}else{
					boolean ifSame = false;
					String sameMess2 = "";
					if(!ifUse){
						ifSame = true;
						sameMess2 = "该笔支付信息电子回执单不存在！";
					}
					response.setContentType("text/html;charset=GBK");
					response.getWriter().write(ifSame+"#"+sameMess2);
				}
				
				
				
		     }
		     catch(Exception e){
		         e.printStackTrace();
		         throw e;
		     }
		     finally {
		       if (bis != null)bis.close();
		       if (bos != null)bos.close();
		      }

		return null;
	}
	
}

