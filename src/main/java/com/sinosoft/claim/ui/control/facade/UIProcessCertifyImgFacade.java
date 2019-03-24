package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.bl.facade.BLCertifyImgFacade;
import com.sinosoft.sysframework.common.datatype.DateTime;
/**
 * 分发HTTP Post 车险理赔单证编辑界面
 * <p>Title: 车险理赔单证编辑界面信息</p>
 * <p>Description: 车险理赔单证编辑界面信息</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author liubvo
 * @version 1.0
 */
public class UIProcessCertifyImgFacade  extends Action {
	private Log log = LogFactory.getLog(UIProcessCertifyImgFacade.class);
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
	throws  Exception
	{
		
		String forward = ""; //向前流转
		try {
			String businessNo = httpServletRequest.getParameter("businessNo"); 
			String[] myselect = httpServletRequest.getParameterValues("checkboxSelect");
			String[] certifyImgLossItemCodes = httpServletRequest.getParameterValues("certifyImgLossItemCode");
			String[] certifyImgSerialNos = httpServletRequest.getParameterValues("certifyImgSerialNo");

			String certifyImgLossItemCode;
			String certifyImgSerialNo;
			DateTime curday =  new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY);
			
			String updateSql = " ValidStatus='0',CancelDate ='" + curday + "'";
			String condition = "";
			
			
			for (int i = 0; i < myselect.length; i++) {
				if(i==0){
					condition += " where ";
				}else{
					condition += " or ";
				}
				certifyImgLossItemCode = certifyImgLossItemCodes[Integer.parseInt(myselect[i])];
				certifyImgSerialNo = certifyImgSerialNos[Integer.parseInt(myselect[i])];
				condition += "BusinessNo='" + businessNo +"' and LossItemCode='"+certifyImgLossItemCode + "' and SerialNo="+certifyImgSerialNo;
			}
			if(condition.length()>0){
				updateSql += condition;
				BLCertifyImgFacade blCertifyImgFacade = new BLCertifyImgFacade();
				log.debug("要更新CertifyImg表的SQL语句是:"+updateSql);
				blCertifyImgFacade.updateByCondition(updateSql);
			}
			forward="success";
            ActionMessages messages = new ActionMessages();
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.certifyDelete.Success"));
            saveMessages(httpServletRequest, messages);
		}
		catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			forward = "error";
		}
		return actionMapping.findForward(forward);
	}
}
