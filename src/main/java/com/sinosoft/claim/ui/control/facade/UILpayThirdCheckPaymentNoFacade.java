package com.sinosoft.claim.ui.control.facade;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.action.domain.BLPrpLregistAction;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class UILpayThirdCheckPaymentNoFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = "";
		String[] paymentNo = httpServletRequest.getParameterValues("paymentNo");
		String ifThirdPay = "";
		for(int i=0;i<paymentNo.length;i++){
			DBManager dbManager = new DBManager();
			try{
				String checkQuery = "select count(1) from thirdpay_platform.prpqpaymain where " +
									" visaserialno = '"+paymentNo[i]+"' and flag not in ('4','14','15')";
				dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            //查询数据,赋值给DTO
	            ResultSet rs = dbManager.executeQuery(checkQuery);
	            if(rs.next()){
	            	if(dbManager.getInt(rs,1)!=0){
	            		ifThirdPay = "YES";
	            	}else{
	                	ifThirdPay = "NO";
	                }
	            }
	            rs.close();
	            String checkQueryhis = "select count(1) from thirdpay_platform.prpqpaymainhis where " +
						" visaserialno = '"+paymentNo[i]+"' and flag not in ('4','14','15')";
	            ResultSet rss = dbManager.executeQuery(checkQueryhis);
	            if(rss.next()&&!"YES".equals(ifThirdPay)){
	            	if(dbManager.getInt(rss,1)!=0){
	            		ifThirdPay = "YES";
	            	}else{
	                	ifThirdPay = "NO";
	                }
	            }
	            rss.close();
			}catch(Exception e){
				e.printStackTrace();
				httpServletResponse.getWriter().write(e.getMessage());
				ActionErrors errors = new ActionErrors();
				ActionError error = new ActionError("title.payInfoSave");
				errors.add(ActionErrors.GLOBAL_ERROR, error);
				httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
				saveErrors(httpServletRequest, errors);
				forward = "error";
			}finally{
				dbManager.close();
			}
			if(ifThirdPay == "YES"){
            	break;
            }
		}
		httpServletResponse.getWriter().write("true##"+ifThirdPay);
		forward="success";
		return null;
	}
	
	

}
