package com.sinosoft.claim.util;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrplPayeeInfoFacade;
import com.sinosoft.claim.log.SaveOrDeletePrplpayeeinfoLogger;
import com.sinosoft.utility.SysConfig;
import com.sinosoft.utility.database.DbPool;

public class UIDeleteSavePayeeInfo extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		String conditions = "";
		String receiverFullName = request.getParameter("receiverFullName");
		String receiverTypeOther = request.getParameter("receiverTypeOther");
		String certifNo = request.getParameter("certifNo");
		String certifType = request.getParameter("certifType");
		String bank = request.getParameter("bank");
		String bankAccount = request.getParameter("bankAccount");
		String bankType = request.getParameter("bankType");
		String accountFlag = request.getParameter("accountFlag");
		String accountType = request.getParameter("accountType");
		String routeNum = request.getParameter("routeNum");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String mobilePhone = request.getParameter("mobilePhone");
		String inputDate = request.getParameter("inputDate");
		
		BLPrplPayeeInfoFacade bLPrplPayeeInfoFacade = new BLPrplPayeeInfoFacade();
		SaveOrDeletePrplpayeeinfoLogger saveOrDeletePrplpayeeinfoLogger = new SaveOrDeletePrplpayeeinfoLogger();
		try {
			if(!"".equals(receiverFullName)){
				conditions += " and receiverFullName = '"+receiverFullName+"'";
			}else{
				conditions += " and receiverFullName is null ";
			}
			if(!"".equals(receiverTypeOther)){
				conditions += " and receiverTypeOther = '"+receiverTypeOther+"'";
			}else{
				conditions += " and receiverTypeOther is null ";
			}
			if(!"".equals(certifNo)){
				conditions += " and certifNo = '"+certifNo+"'";
			}else{
				conditions += " and certifNo is null ";
			}
			if(!"".equals(certifType)){
				conditions += " and certifType = '"+certifType+"'";
			}else{
				conditions += " and certifType is null ";
			}
			if(!"".equals(bank)){
				conditions += " and bank = '"+bank+"'";
			}else{
				conditions += " and bank is null ";
			}
			if(!"".equals(bankAccount)){
				conditions += " and bankAccount = '"+bankAccount+"'";
			}else{
				conditions += " and bankAccount is null ";
			}
			if(!"".equals(bankType)){
				conditions += " and bankType = '"+bankType+"'";
			}else{
				conditions += " and bankType is null ";
			}
			if(!"".equals(accountFlag)){
				conditions += " and accountFlag = '"+accountFlag+"'";
			}else{
				conditions += " and accountFlag is null ";
			}
			if(!"".equals(accountType)){
				conditions += " and accountType = '"+accountType+"'";
			}else{
				conditions += " and accountType is null ";
			}
			if(!"".equals(routeNum)){
				conditions += " and routeNum = '"+routeNum+"'";
			}else{
				conditions += " and routeNum is null ";
			}
			if(!"".equals(city)){
				conditions += " and city = '"+city+"'";
			}else{
				conditions += " and city is null ";
			}
			if(!"".equals(province)){
				conditions += " and province = '"+province+"'";
			}else{
				conditions += " and province is null ";
			}
			if(!"".equals(mobilePhone)){
				conditions += " and mobilePhone = '"+mobilePhone+"'";
			}else{
				conditions += " and mobilePhone is null ";
			}
			if(!"".equals(inputDate)){
				conditions += " and inputDate = '"+inputDate+"'";
			}else{
				conditions += " and inputDate is null ";
			}
			if(!"".equals(conditions)){
				conditions = conditions.replaceFirst("and", "");
				System.out.println("删除：DELETE FROM PrplPayeeInfo WHERE"+conditions);
				bLPrplPayeeInfoFacade.deleteByConditions(conditions);
				String data = "删除领款人信息成功："+
							 receiverFullName +" "+
							 receiverTypeOther +" "+
							 certifNo +" "+
							 certifType +" "+
							 bank +" "+
							 bankAccount +" "+
							 bankType +" "+
							 accountFlag +" "+
							 accountType +" "+
							 routeNum +" "+
							 province +" "+
							 city +" "+
							 mobilePhone +" "+
							 inputDate ;
				saveOrDeletePrplpayeeinfoLogger.printData(data);
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write("true");
			}else{
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write("false");
			}
		} catch (Exception e) {
			saveOrDeletePrplpayeeinfoLogger.error(e);
			response.getWriter().write("false");
			e.printStackTrace();
		}
		return null;
	}
}
