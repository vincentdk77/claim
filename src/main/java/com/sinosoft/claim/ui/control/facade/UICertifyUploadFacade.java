package com.sinosoft.claim.ui.control.facade;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.ui.control.viewHelper.DAACertifyUploadVieHelper;
import com.sinosoft.claim.util.FtpClient;
import com.sinosoft.sysframework.reference.AppConfig;

public class UICertifyUploadFacade  extends Action{


	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int rtnValue = 0;
		try{
			UserDto user = (UserDto)request.getSession().getAttribute("user");
			if(user == null){
				rtnValue = -1;
				throw new Exception("µÇÂ¼³¬Ê±");
			}
			FtpClient ftp = initFtpClient();
			DAACertifyUploadVieHelper uploadViewHelper = new DAACertifyUploadVieHelper();
			rtnValue = uploadViewHelper.uploadFile(request, ftp);
			request.setAttribute("result", String.valueOf(rtnValue));
		}catch(Exception e){
			request.setAttribute("result", String.valueOf(rtnValue));
			e.printStackTrace();
		}

		return mapping.findForward("message");
	}

	public FtpClient initFtpClient() throws Exception{
		String ftpUser = AppConfig.get("sysconst.FTP_USER");
		String ftpPass = AppConfig.get("sysconst.FTP_PASS");
		String ftpUrl  = AppConfig.get("sysconst.FTP_URL");
		String ftpDir  = AppConfig.get("sysconst.WRITEDIR");
		FtpClient ftp = new FtpClient();
		ftp.open(ftpUrl);
		ftp.login(ftpUser, ftpPass);
		ftp.cd(ftpDir);
		ftp.setMode(FtpClient.BIN_MODE);
		return ftp;
	}
	
}
