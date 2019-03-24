package com.sinosoft.claim.ui.control.facade;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.fxq.bl.facade.BLTerroristFacade;

public class UILpaymentBillCheckEditPostFacade_new extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			String[] payName = request.getParameterValues("payName");
			String[] provinceName = request.getParameterValues("provinceName");
			String[] cityName = request.getParameterValues("cityName");
			String[] accountType = request.getParameterValues("accountType");
			String[] bankName = request.getParameterValues("bankName");
			String[] openBank = request.getParameterValues("openBank");
			String[] bankAccount = request.getParameterValues("bankAccount");
			String[] accountFlag = request.getParameterValues("accountFlag");
			String[] mobilePhone = request.getParameterValues("mobilePhone");
			String[] address = request.getParameterValues("address");
			String[] payWay = request.getParameterValues("payWay");
			String[] ipayAmount = request.getParameterValues("payAmount");
			String[] payReason = request.getParameterValues("payReason");
			String[] identifyNumber = request.getParameterValues("identifyNumber");
			
			//zf0000000000
			BLTerroristFacade blTerroristFacade= new BLTerroristFacade();
			Collection collection=null;
			String conditions="";
			response.setCharacterEncoding("GBK");
			String message = "";
			try {
				for(int i=0;i<payName.length;i++){
					if(provinceName[i]==null||"".equals(provinceName[i])||"".equals(provinceName[i].trim())){
				   		message += "人员"+payName[i]+"账户信息中省份名称不能为空！\n";
				    }
				   
				   if(cityName[i]==null||"".equals(cityName[i])||"".equals(cityName[i].trim())){
				   		message += "人员"+payName[i]+"账户信息中城市名称不能为空！\n";
				   }
				   
				   if(accountType[i]==null||"".equals(accountType[i])||"".equals(accountType[i].trim())){
				   		message += "人员"+payName[i]+"账户信息中账户属性不能为空！\n";
				   }
				   
					if(bankName[i] == null||"".equals(bankName[i])||"".equals(bankName[i].trim())){
						message += "人员"+payName[i]+"账户信息中银行大类不能为空！\n";
					}
					
					if(openBank[i] == null||"".equals(openBank[i])||"".equals(openBank[i].trim())){
						message += "人员"+payName[i]+"账户信息中开户银行不能为空！\n";
					}
					
					if(bankAccount[i] == null||"".equals(bankAccount[i])||"".equals(bankAccount[i].trim())){
						message += "人员"+payName[i]+"账户信息中银行账号不能为空！\n";
					}
					//校验银行账号不能小于五位
					else if( bankAccount[i].trim().length()<5){
						message += "人员"+payName[i]+"账户信息中银行账号不能小于五位！\n";
					}
					
				   if(accountFlag[i] ==null||"".equals(accountFlag[i])||"".equals(accountFlag[i].trim())){
				   		message += "人员"+payName[i]+"账户信息中账号类型不能为空！\n";
				   }
					
					if(payWay[i] == null||"".equals(payWay[i])||"".equals(payWay[i].trim())){
						message += "人员"+payName[i]+"账户信息中支付方式不能为空！\n" ;
					}
					if("2".equals(payWay[i])){
					    message += "人员"+payName[i]+"在批量支付时,账户信息中的支付方式只能选择第三方支付！\n";
					}
					if("2".equals(payWay[i])&&"".equals(payReason[i])){
						message += "人员"+payName[i]+"账户信息中支付方式为“传统方式支付”时，支付原因不能为空！\n";
					}
					 
					 if(Double.parseDouble(ipayAmount[i])<=0&&"1".equals(payWay[i])){
					 	message += "人员"+payName[i]+"账户信息中本次支付金额为0或负数时，支付方式请选择“传统方式支付”！\n";
					 }
					 
					 if(identifyNumber[i]==null || "".equals(identifyNumber[i])){
						 message += "人员"+payName[i]+"身份证号不能为空！\n";
					 }else if(identifyNumber[i].length() > 20){
						 message += "人员"+payName[i]+"身份证号长度不能超过20！\n";
					 }
					 if(identifyNumber[i]!=null &&!"".equals(identifyNumber[i])
							 && payName[i]!=null && !"".equals(payName[i]) && !"".equals(payName[i].trim())){
						 conditions=" terroristCName='"+payName[i]+"' and  identifyNumber='"+identifyNumber[i]+"' ";
						collection= blTerroristFacade.findByConditions(conditions);
						if(collection!=null &&collection.size()>0){
							 message += "人员"+payName[i]+"证件号"+identifyNumber[i]+"可能为恐怖分子！\n";
						}
					 }
					 
				}
				response.getWriter().write("true##"+message);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
    	   
		return null;
	}

}
