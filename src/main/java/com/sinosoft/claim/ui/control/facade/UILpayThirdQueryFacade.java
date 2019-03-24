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

public class UILpayThirdQueryFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = "";
		String registNo = httpServletRequest.getParameter("registNo");
		try{
			String [] certiNos = httpServletRequest.getParameterValues("certiNoPay");//业务单号
			String flagStr = "";
			String [] flags = httpServletRequest.getParameterValues("flag");//合并勾选框
			for(int k =0;k<flags.length;k++){
				flagStr += "["+flags[k]+"]";
			}
			String ifThirdPay = "";
			for(int i=0;i<certiNos.length;i++){
				if((flagStr).indexOf("["+String.valueOf(i)+"]")<0) continue;
				ifThirdPay = this.findIfThirdPay(certiNos[i]);
				if("NO".equals(ifThirdPay)){
					ifThirdPay += "&&"+certiNos[i];
					break;
				}
				
			}
			
			httpServletResponse.getWriter().write("true##"+ifThirdPay);
			forward="success";
		}catch(Exception e){
			e.printStackTrace();
			httpServletResponse.getWriter().write(e.getMessage());
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("title.payInfoSave");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
			saveErrors(httpServletRequest, errors);
			forward = "error";
		}
		return null;
	}
	
	
	/**
     * 按主键查找一条数据
     * @param registNo 报案号码
     * @return prpLregistDto prpLregistDto
     * @throws Exception
     */
    public String findIfThirdPay(String  compensateNo) throws Exception{
        DBManager dbManager = new DBManager();
        String ifThirdPay = "NO";
        //声明DTO
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            String queryCondtion = "select certiNo from prpjpayrefrec where certitype in ('C','Y') and certiNo = '"+compensateNo+"' and visaserialno is not null and visaserialno like '9%' and exists (select 1 from prpjcommissionflog where flowid = visaserialno)";
            ResultSet rs = dbManager.executeQuery(queryCondtion);
            if(rs.next()){
            	ifThirdPay = "YES";
            }else{
            	ifThirdPay = "NO";
            }
            rs.close();
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return ifThirdPay;
    }

}
