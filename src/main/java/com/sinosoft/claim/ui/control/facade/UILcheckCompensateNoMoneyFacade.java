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
import com.sinosoft.platform.bl.facade.BLUtiPlatConfigRuleFacade;
import com.sinosoft.platform.dto.domain.UtiPlatConfigRuleDto;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.string.Str;

public class UILcheckCompensateNoMoneyFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = "";
		String registNo = httpServletRequest.getParameter("registNo");
		try{
			String [] certiNos = httpServletRequest.getParameterValues("certiNoPay");//业务单号
			String [] paidPay = httpServletRequest.getParameterValues("paidPay");//本次支付金额
			String [] payrefreason = httpServletRequest.getParameterValues("payrefreason");//赔款类型 收付原因
			String [] coinsCode = httpServletRequest.getParameterValues("coinsCode");//联共保人
			String paymentNo = httpServletRequest.getParameter("paymentNo");//收付编号
			String flagStr = "";
			String [] flags = httpServletRequest.getParameterValues("flag");//合并勾选框
			for(int k =0;k<flags.length;k++){
				flagStr += "["+flags[k]+"]";
			}
			//boolean ifOverPlanfee = false;
			String ifOver = "";
			for(int i=0;i<certiNos.length;i++){
				if((flagStr).indexOf("["+String.valueOf(i)+"]")<0) continue;
				ifOver = this.findPlanfeeByCompensateNo(certiNos[i],payrefreason[i],paidPay[i],paymentNo,coinsCode[i]);
				if("YES".equals(ifOver)){
					ifOver += "&&"+certiNos[i];
					break;
				}
				
			}
			
			httpServletResponse.getWriter().write("true##"+ifOver);
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
     * 判断计算书录入的支付信息汇总金额是否超出计算书本身的赔款金额
     * @param compensateNo 计算书号 payrefReason 收付原因
     * @return ifOverPlanfee
     * @throws Exception
     */
    public String findPlanfeeByCompensateNo(String  compensateNo,String payrefReason,String paidpay,String paymentNo,String coinsCode) throws Exception{
        DBManager dbManager = new DBManager();
        double planfee = 0.00;
        double payamount = 0.00;
        //boolean ifOverPlanfee = false;
        String ifOver = "NO";
        //声明DTO
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
    		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacadeReason = new BLUtiPlatConfigRuleFacade();
    		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacadeReason.findByPrimaryKey("payment", "PAYREFREASON_GBPKANDFY", 1);
            if(null!=payrefReason && utiPlatConfigRuleDto.getRule().indexOf(payrefReason) > -1){
            	String queryCondtion = "select planfee from prpjplanfeecoins where certitype in ('C','Y') and certiNo = '"+compensateNo+"' and payrefreason = '"+payrefReason+"'";
                if(null!=coinsCode && !"".equals(coinsCode)){
                	queryCondtion += " and coinscode ='"+coinsCode+"' ";
                }
            	ResultSet rs = dbManager.executeQuery(queryCondtion);
                if(rs.next()){
                	planfee = Str.round(Double.parseDouble(rs.getString("planfee")),2);
                }
                rs.close();
            }else{
            	String queryCondtion = "select planfee from prpjplanfee where certitype in ('C','Y') and certiNo = '"+compensateNo+"' and payrefreason = '"+payrefReason+"'";
                ResultSet rs = dbManager.executeQuery(queryCondtion);
                if(rs.next()){
                	planfee = Str.round(Double.parseDouble(rs.getString("planfee")),2);
                }
                rs.close();
            }
            
            String querySumPay = " select sum(payamount) as payamount from prplpay where compensateno = '"+compensateNo+"' and paymenttype = '"+payrefReason+"'";
            if(null!=coinsCode && !"".equals(coinsCode)){
            	querySumPay += " and coinscode ='"+coinsCode+"' ";
            }
            if(null!=paymentNo && !"".equals(paymentNo)){
            	querySumPay += " and serialno <> '"+paymentNo+"'";
            }
            ResultSet rso = dbManager.executeQuery(querySumPay);
            String queryPayamount = "";
            if(rso.next()){
            	queryPayamount = rso.getString("payamount");
            	
            }
            if(null == queryPayamount || "".equals(queryPayamount)){
            	queryPayamount = "0";
        	}
        	payamount = Double.parseDouble(queryPayamount);
            double nowfee = Str.round(payamount, 2) + Str.round(Double.parseDouble(paidpay),2);
            nowfee = Str.round(nowfee,2);
            if(nowfee>planfee){
            	ifOver = "YES";//ifOverPlanfee = true;
            }
            rso.close();
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return ifOver;
    }

}
