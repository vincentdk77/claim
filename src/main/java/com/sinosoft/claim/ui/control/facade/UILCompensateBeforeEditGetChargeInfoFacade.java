package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.domain.PrpLcfeecoinsDto;
import com.sinosoft.sysframework.common.util.DataUtils;

public class UILCompensateBeforeEditGetChargeInfoFacade extends Action{
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		
		String forward = "success"; //œÚ«∞
		ArrayList prpLcfeecoinsChargeDtoList = new ArrayList();
		PrpLcfeecoinsDto prpLcfeecoinsDto = null ;
		StringBuffer pageConetent = new StringBuffer();
		
		String[] prpLchargeChargeAmount = httpServletRequest.getParameterValues("prpLchargeChargeAmount");
		String[] prpLchargeChargeCode = httpServletRequest.getParameterValues("prpLchargeChargeCode");
		String[] prpLchargeChargeName = httpServletRequest.getParameterValues("prpLchargeChargeName");
		String[] prpLchargeCoinsCode = httpServletRequest.getParameterValues("CoinsCode");
		String[] prpLchargeCoinsName = httpServletRequest.getParameterValues("CoinsName");
		String[] prpLchargeSumRealPay = httpServletRequest.getParameterValues("prpLchargeSumRealPay");
		String[] CoinsRate = httpServletRequest.getParameterValues("CoinsRate");
		String[] arrCoinsSerialNo = httpServletRequest.getParameterValues("CoinsSerialNo");

		int j = 0;
		for (int z = 1; z < arrCoinsSerialNo.length; z++) {
			for (int i = 1; i < prpLchargeChargeCode.length; i++) {
				prpLcfeecoinsDto = new PrpLcfeecoinsDto();
				prpLcfeecoinsDto.setSerialNo(j++);
				prpLcfeecoinsDto.setCoinsCode(prpLchargeCoinsCode[z]);
				prpLcfeecoinsDto.setCoinsName(prpLchargeCoinsName[z]);
				prpLcfeecoinsDto.setChargeCode(prpLchargeChargeCode[i]);
				prpLcfeecoinsDto.setChargeName(prpLchargeChargeName[i]);
				double tempCoinsFee = Double.parseDouble(DataUtils.nullToZero(prpLchargeChargeAmount[i]))-Double.parseDouble(DataUtils.nullToZero(prpLchargeSumRealPay[i]));
				double coinsRate = Double.parseDouble(CoinsRate[z]);
				double coinsRates = 0;
				for (int k = 1; k < CoinsRate.length; k++) {
					coinsRates += Double.parseDouble(CoinsRate[k]);
				}
				double tempCoinsSumpaid = (double)Math.round((tempCoinsFee / (1-(coinsRates/100)) * (coinsRates/100))*100)/100;
				for (int k = 1; k < arrCoinsSerialNo.length; k++) {
					double tempCoinsSumpaid1 = (double)Math.round((tempCoinsSumpaid * (coinsRate/coinsRates))*100)/100;
					prpLcfeecoinsDto.setCoinsSumpaid(tempCoinsSumpaid1) ;
				}
				prpLcfeecoinsChargeDtoList.add(prpLcfeecoinsDto);
			}
		}
		for (int i = 0; i < prpLcfeecoinsChargeDtoList.size(); i++) {
			PrpLcfeecoinsDto dto = (PrpLcfeecoinsDto) prpLcfeecoinsChargeDtoList.get(i);
			
			pageConetent.append("<tr>"+
	         "<td class='title' style='width: 4%'>"+
	         "  	<input type='text' name='ChargeCoinsSerialNo' class='readonly' mstyle='width: 40%' readonly='true'"+
	         "    	value='"+dto.getSerialNo()+"'>"+
	         "</td>"+
	         "<td class='title' style='width: 16%'>"+
	         "  	<input type='text' name='ChargeCoinsCode' class='readonly' readonly style='width: 100%' readonly='true'"+
	         "    	value='"+dto.getCoinsCode()+"'>"+
	         "</td>"+
	         "<td class='title' style='width: 16%'>"+
	         "  	<input type='text' name='ChargeCoinsName' class='readonly' readonly style='width: 80%' readonly='true'"+
	         "    	value='"+dto.getCoinsName()+"'>"+
	         "</td>"+
	         "<td class='title' style='width: 10%'>"+
	         "  	<input type='hidden' name='CoinschargeCode' class='readonly' readonly style='width: 80%' readonly='true'"+
			 "		value='"+dto.getChargeCode()+"'>"+
	         "      <input type='text' name='CoinsChargeName' class='readonly' style='width: 100%' readonly='true'"+
			 "		value='"+dto.getChargeName()+"'>"+
	         "</td>"+
	         "<td class='title' style='width: 15%'>"+
	         "  	<input type='text' name='ChargeCoinsSumpaid' class='readonly' style='width: 100%' readonly='true'"+
			 "		value='"+dto.getCoinsSumpaid()+"'>"+
	         "</td>"+
		     "</tr>");
		}
		httpServletResponse.setCharacterEncoding("utf-8");
		httpServletResponse.getWriter().print(pageConetent.toString());
		return null;
		
	}
}
