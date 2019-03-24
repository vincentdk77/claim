package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.ciplatform.bl.action.custom.BLCISYXAutoUploadAction;
import com.sinosoft.claimciplatform.bl.action.custom.BLCIAutoUploadAction;

/**
 * 车险平台 定时任务自动上传
 * <p>Title: 车险平台 定时任务自动上传</p>
 * <p>Description: 车险平台 定时任务自动上传</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author sinosoft
 * @version 1.0
 */
public class UICIClaimAutoUploadFacade extends Action{
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
			
		try{
			//交强险失败数据补传
			BLCIAutoUploadAction.getInstance().autoUpload();
			//2011商业险失败数据补传
			BLCISYXAutoUploadAction.getInstance().autoUpload();
			
		}catch(Exception e ){
			e.printStackTrace();
		}
		
		return null;
	}
}
