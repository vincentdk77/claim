package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLIndemnityReceiptFacade;
import com.sinosoft.claim.dto.custom.UserDto;

import com.sinosoft.sysframework.exceptionlog.UserException;

public class UIVisaFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)  throws Exception{
		String forward="success";
		
		String type=httpServletRequest.getParameter("type");
		String businessNo=httpServletRequest.getParameter("businessNo");
		String printNo=httpServletRequest.getParameter("printNo");
		String visaCode = httpServletRequest.getParameter("visaCode");
		String visaName = httpServletRequest.getParameter("visaName");
		String msg = "��ʾ��Ϣ";
		UserDto userDto = (UserDto)httpServletRequest.getSession().getAttribute("user");
		if("IndemnityReceiptUsed".equals(type)){
			
			msg = "��֤���ųɹ�";
			try {
				BLIndemnityReceiptFacade blIndemnityReceiptFacade = new BLIndemnityReceiptFacade();
				blIndemnityReceiptFacade.doUseVisa(visaCode,visaName,printNo,businessNo,userDto.getUserCode(),userDto.getUserName());
			} catch (UserException ue) {
				msg = "��֤����ʧ��,ԭ��:"+ue.getErrorMessage();
			} catch (Exception e) {
				msg = "��֤����ʧ��,ԭ��:"+e.getMessage();
				e.printStackTrace();
			}
		} else if("IndemnityReceiptAnnul".equals(type)){
			
			msg = "��֤�����ϳɹ�";
			try {
				BLIndemnityReceiptFacade blIndemnityReceiptFacade = new BLIndemnityReceiptFacade();
				blIndemnityReceiptFacade.doAnnerVisa(businessNo,userDto.getUserCode(),userDto.getUserName());
			} catch (UserException ue) {
				msg = "��֤�����ϳɹ�,ԭ��:"+ue.getErrorMessage();
			} catch (Exception e) {
				msg = "��֤�����ϳɹ�,ԭ��:"+e.getMessage();
				e.printStackTrace();
			}
		} else{
			throw new Exception("�޴����͵�����");
		}

		httpServletRequest.setAttribute("info",msg);
		return actionMapping.findForward(forward);

	}	

}
