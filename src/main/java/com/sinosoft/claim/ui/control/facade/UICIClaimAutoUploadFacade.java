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
 * ����ƽ̨ ��ʱ�����Զ��ϴ�
 * <p>Title: ����ƽ̨ ��ʱ�����Զ��ϴ�</p>
 * <p>Description: ����ƽ̨ ��ʱ�����Զ��ϴ�</p>
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
			//��ǿ��ʧ�����ݲ���
			BLCIAutoUploadAction.getInstance().autoUpload();
			//2011��ҵ��ʧ�����ݲ���
			BLCISYXAutoUploadAction.getInstance().autoUpload();
			
		}catch(Exception e ){
			e.printStackTrace();
		}
		
		return null;
	}
}
