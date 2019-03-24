package com.sinosoft.claim.ui.control.viewHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.LabelValueBean;

import com.sinosoft.claim.bl.facade.BLDangerUnitFacade;
import com.sinosoft.claim.bl.facade.BLPersonLossFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrpLthirdPartyFacade;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.CertifyDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCengageDto;
import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpClimitDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpDcurrencyDto;
import com.sinosoft.claim.dto.domain.PrpDlimitDto;
import com.sinosoft.claim.dto.domain.PrpLcarLossDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.claim.dto.domain.PrpLcfeeDto;
import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.claim.dto.domain.PrpLcomRepairBillDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLcomponentDto;
import com.sinosoft.claim.dto.domain.PrpLctextDto;
import com.sinosoft.claim.dto.domain.PrpLdeductCondDto;
import com.sinosoft.claim.dto.domain.PrpLdeductibleDto;
import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLnodutyLossDto;
import com.sinosoft.claim.dto.domain.PrpLpersonDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.claim.dto.domain.PrpLqualityCheckDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLrepairFeeDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.claim.ui.control.action.UICertainLossAction;
import com.sinosoft.claim.ui.control.action.UICertifyAction;
import com.sinosoft.claim.ui.control.action.UICheckAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIConfigAction;
import com.sinosoft.claim.ui.control.action.UIDeductCondAction;
import com.sinosoft.claim.ui.control.action.UILdeductCondAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPrepayAction;
import com.sinosoft.claim.ui.control.action.UIPrpClimitAction;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIRiskUnitAction;
import com.sinosoft.claim.ui.control.action.UISwfNotionAction;
import com.sinosoft.claim.ui.control.action.UIVerifyLossAction;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.prpall.pubfun.PubTools;
import com.sinosoft.reins.out.bl.facade.BLFcoRepolicyFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpCdangerUnitFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpLdangerUnitFacade;
import com.sinosoft.reins.out.dto.domain.PrpLdangerItemDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerTotDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerUnitDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.utiall.dbsvr.BLPrpDcarModelNew;
import com.sinosoft.utility.string.Str;

/**
 * <p>
 * Title: CompensateViewHelper
 * </p>
 * <p>
 * Description:实赔ViewHelper类，在该类中完成页面数据的整理
 * </p>
 * <p>
 * Copyright: Copyright 中科软科技股份有限公司(c) 2004
 * </p>
 * 
 * @author 车险理赔项目组 liubvo
 * @version 1.0 <br>
 */

public class SunnyCompensateViewHelper extends DAACompensateViewHelper {
	private static Log logger = LogFactory.getLog(SunnyCompensateViewHelper.class);
	public static SunnyCompensateViewHelper getInstance(){
		return new SunnyCompensateViewHelper();
	}


	/**
	 * 保存实赔时实赔页面数据整理. 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
	 * 
	 * @param httpServletRequest
	 * @return compensateDto 实赔数据传输数据结构
	 * @throws Exception
	 */
	public CompensateDto viewToDto(HttpServletRequest httpServletRequest) throws Exception {
		 UICodeAction uiCodeAction = UICodeAction.getInstance();
		 
		
		
		// 继承对compensate,compensateText表的赋值
		CompensateDto compensateDto = super.viewToDto(httpServletRequest);
		/*---------------------特别约定信息prpCengageDto------------------------------------*/
		/*
		 * ArrayList prpCengageDtoList = new ArrayList(); PrpCengageDto
		 * prpCengageDto = null;
		 * 
		 * //从界面得到输入数组 String prpLcengagePolicyNo =
		 * httpServletRequest.getParameter("prpLcompensatePolicyNo"); String
		 * prpLcengageRiskCode =
		 * httpServletRequest.getParameter("prpLcompensateRiskCode"); String[]
		 * prpLcengageSerialNo =
		 * httpServletRequest.getParameterValues("prpLcengageSerialNo");
		 * String[] prpLcengageLineNo =
		 * httpServletRequest.getParameterValues("prpLcengageLineNo"); String[]
		 * prpLcengageClauseCode =
		 * httpServletRequest.getParameterValues("prpLcengageClauseCode");
		 * String[] prpLcengageClauses =
		 * httpServletRequest.getParameterValues("prpLcengageClauses"); String[]
		 * prpLcengageFlag =
		 * httpServletRequest.getParameterValues("prpLcengageFlag"); //对象赋值
		 * //特别约定信息 for(int index = 1;index < prpLcengageSerialNo.length;
		 * index++) { prpCengageDto = new PrpCengageDto();
		 * prpCengageDto.setPolicyNo(prpLcengagePolicyNo);
		 * prpCengageDto.setRiskCode(prpLcengageRiskCode);
		 * prpCengageDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLcengageSerialNo[index])));
		 * prpCengageDto.setLineNo(Integer.parseInt(DataUtils.nullToZero(prpLcengageLineNo[index])));
		 * prpCengageDto.setClauseCode(prpLcengageClauseCode[index]);
		 * prpCengageDto.setClauses(prpLcengageClauses[index]);
		 * prpCengageDto.setFlag(prpLcengageFlag[index]); //加入集合
		 * prpCengageDtoList.add(prpCengageDto); } //特别约定信息
		 * compensateDto.setPrpCengageDtoList(prpCengageDtoList);
		 */
		/*---------------------赔付标的信息prpLlossDto------------------------------------*/
		String prpLlossDtoCompensateNo = (String) httpServletRequest.getAttribute("compensateNo");
		//免赔条件信息 add by miaowenjun 20060607
		ArrayList deductCondList = UIDeductCondAction.getInstance().getDeductCondList(httpServletRequest,true);
		compensateDto.getPrpLcompensateDto().setPrpLdeductCondDtoList(deductCondList);
		
		ArrayList prpLlossDtoList = new ArrayList();
		PrpLlossDto prpLlossDto = null;
	  
	    String   DangerUnitCheckSaveFlag = httpServletRequest.getParameter("DangerUnitCheckSaveFlag");
   
         // 加入危险单位处理 add by qinyongli 2005-9-10
		// reason: 目前只有一个危险单位，所以和标的信息放在一起处理，如果，有多个危险单位必须放入危险单位信息里面处理！
		ArrayList prpLprpLdangerTotList = new ArrayList(); // 理赔危险单位金额合计信息
		ArrayList prpLprpLdangerItemList = new ArrayList(); // 理赔的危险单位信息表
		PrpLdangerTotDto prpLdangerTotDto = new PrpLdangerTotDto(); // 金额合计Dto
		PrpLdangerItemDto prpLdangerItemDto = new PrpLdangerItemDto(); // 标的DTO
       
	 
		
		int dangerItemSerialNo = 1; // 用于存储标的的序号
		// 从界面得到输入数组
		// String prpLlossDtoCompensateNo =
		// httpServletRequest.getParameter("prpLcompensateCompensateNo");

		// 文件的处理方式改变，所以这里可以从1开始，而不用从文件中的数据。 2005-07-18
		// int prpCitemKindCount =
		// Integer.parseInt(DataUtils.nullToZero(httpServletRequest.getParameter("prpCitemKindCount")));
		int prpCitemKindCount = 1;
		String lastRealPay = httpServletRequest.getParameter("lastRealPay");//总赔款
		String prpLDeductible = httpServletRequest.getParameter("prpLDeductible");//免赔额
		double alreadySplit = 0.0;

		String prpLlossDtoRiskCode = httpServletRequest.getParameter("prpLcompensateRiskCode");
		String prpLlossDtoPolicyNo = httpServletRequest.getParameter("prpLcompensatePolicyNo");
		String[] prpLlossDtoSerialNo = httpServletRequest.getParameterValues("lossDtoSerialNo");
		String[] prpLlossDtoItemKindNo = httpServletRequest.getParameterValues("prpLlossDtoItemKindNo");
		String[] prpLlossDtoFamilyNo = httpServletRequest.getParameterValues("prpLlossDtoFamilyNo");
		String[] prpLlossDtoFamilyName = httpServletRequest.getParameterValues("prpLlossDtoFamilyName");
		String[] prpLlossDtoKindCode = httpServletRequest.getParameterValues("prpLlossDtoKindCode");
		String[] prpLlossDtoLicenseNo = httpServletRequest.getParameterValues("prpLicenseNo");
		String[] prpLlossDtoItemCode = httpServletRequest.getParameterValues("prpLlossDtoItemCode");
		String[] prpLlossDtoLossName = httpServletRequest.getParameterValues("prpLlossDtoLossName");
		String[] prpLlossDtoItemAddress = httpServletRequest.getParameterValues("prpLlossDtoItemAddress");
		String[] prpLlossDtoFeeTypeCode = httpServletRequest.getParameterValues("prpLlossDtoFeeTypeCode");
		String[] prpLlossDtoFeeTypeName = httpServletRequest.getParameterValues("prpLlossDtoFeeTypeName");
		String[] prpLlossDtoLossQuantity = httpServletRequest.getParameterValues("prpLlossDtoLossQuantity");
		String[] prpLlossDtoUnit = httpServletRequest.getParameterValues("prpLlossDtoUnit");
		String[] prpLlossDtoUnitPrice = httpServletRequest.getParameterValues("prpLlossDtoUnitPrice");
		String[] prpLlossDtoBuyDate = httpServletRequest.getParameterValues("prpLlossDtoBuyDate");
		String[] prpLlossDtoDepreRate = httpServletRequest.getParameterValues("prpLlossDtoDepreRate");
		String[] prpLlossDtoCurrency = httpServletRequest.getParameterValues("prpLlossDtoCurrency");
		String[] prpLlossDtoAmount = httpServletRequest.getParameterValues("prpLlossDtoAmount");
		String[] prpLlossDtoCurrency1 = httpServletRequest.getParameterValues("prpLlossDtoCurrency1");
		String[] prpLlossDtoItemValue = httpServletRequest.getParameterValues("prpLlossDtoItemValue");
		String[] prpLlossDtoCurrency2 = httpServletRequest.getParameterValues("prpLlossDtoCurrency2");
		String[] prpLlossDtoSumLoss = httpServletRequest.getParameterValues("prpLlossDtoSumLoss");
		String[] prpLlossDtoSumDefPay = httpServletRequest.getParameterValues("prpLlossDtoSumDefPay");
		String[] prpLlossDtoSumRest = httpServletRequest.getParameterValues("prpLlossDtoSumRest");
		String[] prpLlossDtoIndemnityDutyRate = httpServletRequest.getParameterValues("prpLlossDtoIndemnityDutyRate");
		String[] prpLlossDtoArrangeRate = httpServletRequest.getParameterValues("prpLlossDtoArrangeRate");
		String[] prpLlossDtoClaimRate = httpServletRequest.getParameterValues("prpLlossDtoClaimRate");
		String[] prpLlossDtoCurrency3 = httpServletRequest.getParameterValues("prpLlossDtoCurrency3");
		String[] prpLlossDtoDeductibleRate = httpServletRequest.getParameterValues("prpLlossDtoDeductibleRate");
		String[] prpLlossDtoDutyDeductibleRate = httpServletRequest.getParameterValues("prpLlossDtoDutyDeductibleRate");
		String[] prpLlossDtoMainKindDeductibleRate = httpServletRequest.getParameterValues("PrpLlossDtoMainKindDuctibleRate");
			
		String[] prpLlossDtoDriverDeductibleRate = httpServletRequest.getParameterValues("prpLlossDtoDriverDeductibleRate");
		//交强险赔款金额
		String[] prpLlossDtoCISumRealPay = httpServletRequest.getParameterValues("prpLlossDtoCISumRealPay");
		String[] prpLlossDtoDeductible = httpServletRequest.getParameterValues("prpLlossDtoDeductible");
		String[] prpLlossDtoCurrency4 = httpServletRequest.getParameterValues("prpLlossDtoCurrency4");
		String[] prpLlossDtoSumRealPay = httpServletRequest.getParameterValues("prpLlossDtoSumRealPay");
		String[] prpLlossDtoFlag = httpServletRequest.getParameterValues("prpLlossDtoFlag");

		// 对象赋值
		if (prpLlossDtoSerialNo == null) {
			
		} else {
			//计算车损险的记录数
			int kindCodeA_Acount  = 0;
			int kindCodeA_Index = 0;
			//记录所有险别的记录数（不包含不计免赔）
			int kindCodeAll_Acount = 0;
			int sumLoss = 0;
			int kindCodeAll_Index = 0;
			for(int i = 0; i < prpLlossDtoKindCode.length; i++){
				if("A".equals(prpLlossDtoKindCode[i])){
					kindCodeA_Acount ++;
				}
				if(!"M".equals(prpLlossDtoKindCode[i])){
					kindCodeAll_Acount ++;
					sumLoss += Str.round(Double.parseDouble(prpLlossDtoSumRealPay[i]),2);
				}
			}
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(httpServletRequest.getParameter("prpLregistExtRegistNo"));
			
			for (int index = prpCitemKindCount; index < prpLlossDtoSerialNo.length; index++) {
				
				prpLlossDto = new PrpLlossDto();
				prpLlossDto.setPolicyNo(prpLlossDtoPolicyNo);
				prpLlossDto.setRiskCode(prpLlossDtoRiskCode);
				prpLlossDto.setCompensateNo(prpLlossDtoCompensateNo);
				prpLlossDto.setSerialNo(index);
				prpLlossDto.setItemKindNo(Integer.parseInt(DataUtils.nullToZero(prpLlossDtoItemKindNo[index])));
				prpLlossDto.setFamilyNo(Integer.parseInt(DataUtils.nullToZero(prpLlossDtoFamilyNo[index])));
				prpLlossDto.setFamilyName(prpLlossDtoFamilyName[index]);
				prpLlossDto.setKindCode(prpLlossDtoKindCode[index]);
				prpLlossDto.setLicenseNo(prpLlossDtoLicenseNo[index]);
				prpLlossDto.setItemCode(prpLlossDtoItemCode[index]);
				prpLlossDto.setLossName(prpLlossDtoLossName[index]);
				prpLlossDto.setItemAddress(prpLlossDtoItemAddress[index]);
				prpLlossDto.setFeeTypeCode("".equals(prpLlossDtoFeeTypeCode[index])?"99":prpLlossDtoFeeTypeCode[index]);
				prpLlossDto.setFeeTypeName(prpLlossDtoFeeTypeName[index]);
				prpLlossDto.setLossQuantity(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoLossQuantity[index])));
				prpLlossDto.setUnit(prpLlossDtoUnit[index]);
				prpLlossDto.setUnitPrice(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoUnitPrice[index])));
				prpLlossDto.setBuyDate(new DateTime(prpLlossDtoBuyDate[index]));
				prpLlossDto.setDepreRate(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoDepreRate[index])));
				prpLlossDto.setCurrency(prpLlossDtoCurrency[index]);
				prpLlossDto.setAmount(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoAmount[index])));
				prpLlossDto.setCurrency1(prpLlossDtoCurrency1[index]);
				prpLlossDto.setItemValue(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoItemValue[index])));
				prpLlossDto.setCurrency2(prpLlossDtoCurrency2[index]);
				prpLlossDto.setSumLoss(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoSumLoss[index])));
				prpLlossDto.setSumRest(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoSumRest[index])));
				prpLlossDto.setSumDefPay(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoSumDefPay[index])));
				prpLlossDto.setIndemnityDutyRate(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoIndemnityDutyRate[index])));
				prpLlossDto.setArrangeRate(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoArrangeRate[index])));				
				prpLlossDto.setClaimRate(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoClaimRate[index])));
				prpLlossDto.setCurrency3(prpLlossDtoCurrency3[index]);
				prpLlossDto.setDutyDeductibleRate(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoDutyDeductibleRate[index])));
				prpLlossDto.setDeductibleRate(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoDeductibleRate[index])));
				prpLlossDto.setDriverDeductibleRate(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoDriverDeductibleRate[index])));
				prpLlossDto.setDeductible(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoDeductible[index])));
				prpLlossDto.setCurrency4(prpLlossDtoCurrency4[index]);
				prpLlossDto.setSumRealPay(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoSumRealPay[index])));
				prpLlossDto.setFlag(prpLlossDtoFlag[index]);
				//交强险赔款金额
				prpLlossDto.setCISumRealPay(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoCISumRealPay[index])));
				//对免赔额进行分摊 add by qinyongli 20060113 start
				//只有输入了免赔额，才进行分摊
				if (prpLDeductible.equals("")||prpLDeductible==null) {
					prpLDeductible = "0.00";
				} 
				double prpLDeductibleTemp= Double.parseDouble(prpLDeductible);
				//摩托车、拖拉机免赔额的分摊处理:将免赔额分摊到除不计免赔险外的所有险种
				if(prpLregistDto.getCarKindCode().indexOf("M") == 0 ||
				   prpLregistDto.getCarKindCode().indexOf("J") == 0 ){
					if (prpLDeductible != null && prpLDeductibleTemp!=0 && !prpLlossDto.getKindCode().equals("M")) {
						kindCodeAll_Index ++;
						if (kindCodeAll_Acount != kindCodeAll_Index + 1) {
							double realDeductible = Str.round(Double.parseDouble(prpLDeductible),2)
									* (prpLlossDto.getSumRealPay() / sumLoss);
							realDeductible = Str.round(realDeductible, 2);
							alreadySplit = Str.round(alreadySplit + realDeductible,2);
							prpLlossDto.setDeductible(Str.round(realDeductible, 2));
						} else {
							prpLlossDto.setDeductible(Str.round(Double.parseDouble(prpLDeductible) - alreadySplit, 2));
						}
					}
					if (!prpLlossDto.getKindCode().equals("M")) {
						prpLlossDto.setSumRealPay(Str.round(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoSumRealPay[index]))
								- prpLlossDto.getDeductible(),2));
					}
					
				//机动车车损险免赔的分摊处理:将免赔额分摊到车损险
				}else{
					if (prpLDeductible != null && prpLDeductibleTemp!=0 && prpLlossDto.getKindCode().equals("A")) {
						kindCodeA_Index ++;
						if (kindCodeA_Acount != kindCodeA_Index + 1) {
							double realDeductible = Str.round(Double.parseDouble(prpLDeductible),2)
									* (prpLlossDto.getSumRealPay() / (Str.round(Double.parseDouble(lastRealPay),2) + Str.round(Double
											.parseDouble(prpLDeductible),2)));
							realDeductible = Str.round(realDeductible, 2);
							alreadySplit = Str.round(alreadySplit + realDeductible,2);
							prpLlossDto.setDeductible(Str.round(realDeductible, 2));
						} else {
							prpLlossDto.setDeductible(Str.round(Double.parseDouble(prpLDeductible) - alreadySplit, 2));
						}
					}
					if (prpLlossDto.getKindCode().equals("A")) {
						prpLlossDto.setSumRealPay(Str.round(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoSumRealPay[index]))
								- prpLlossDto.getDeductible(),2));
					}
				}
				
				//add by qinyongli 20060113 end

				prpLlossDto.setMainKindDeductibleRate(Double.parseDouble(DataUtils
						.nullToZero(prpLlossDtoMainKindDeductibleRate[index])));
		  
       //用旧的危险单位方法保存
       if(DangerUnitCheckSaveFlag.equals("1")){
          	// 加入危险单位收集 add by qinyongli 2005-9-10
				prpLdangerItemDto = new PrpLdangerItemDto();
				prpLdangerItemDto.setCertiNo(prpLlossDtoCompensateNo); // 实赔号
				prpLdangerItemDto.setDangerNo(1); // 目前只有一个危险单位
				prpLdangerItemDto.setCurrency(prpLlossDtoCurrency2[index]); // 损失币别
				prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
				prpLdangerItemDto.setKindName("正常"); // 险别归类名称
				prpLdangerItemDto.setRiskCode(prpLlossDtoRiskCode); // 险别
				prpLdangerItemDto.setSerialNo(dangerItemSerialNo); // 标的序号
				dangerItemSerialNo++;
				prpLdangerItemDto.setSumPaid(Double.parseDouble(DataUtils.nullToZero(prpLlossDtoSumRealPay[index]))); // 已决赔款
				prpLprpLdangerItemList.add(prpLdangerItemDto);
				// add by qinyongli end 2005-9-10
       }				
						
			
				// 加入集合
				prpLlossDtoList.add(prpLlossDto);
			}
		}
	//-----------------------------------------------------------------
		String strConfigCode = uiCodeAction.translateRiskCodetoConfigCode(prpLlossDtoRiskCode);
		
	    if ("RISKCODE_DAZ".equals(strConfigCode)||"RISKCODE_DAY".equals(strConfigCode)||"RISKCODE_DAU".equals(strConfigCode)){
	    	
	    	
	    	dangerItemSerialNo =   this.lossCompelInit(httpServletRequest,prpLlossDtoList,prpLprpLdangerItemList,dangerItemSerialNo);	
	       
	    }
   //-----------------------------------------------------------------		
		compensateDto.setPrpLlossDtoList(prpLlossDtoList);
		
		ArrayList prpLnodutyLossDtoList = new ArrayList();
		if("RISKCODE_DAZ".equals(strConfigCode)||"RISKCODE_DAY".equals(strConfigCode)||"RISKCODE_DAU".equals(strConfigCode)) {
			this.nodutyLossCompelInit(httpServletRequest, prpLnodutyLossDtoList);
		}
		compensateDto.setPrpLnodutyLossDtoList(prpLnodutyLossDtoList);
		/*------------------------互碰自赔时录入三者车信息  -------------------------------START*/
		ArrayList prpLthirdPartyDtoList = new ArrayList();
		if(compensateDto.getPrpLcompensateDto().getClaimType().equals("K")){
			String prpLthirdPartyClaimNo = (String)httpServletRequest.getParameter("prpLcompensateClaimNo");
			String prpLthirdPartyRiskCode =  (String)httpServletRequest.getParameter("prpLcompensateRiskCode");
			String[] prpLthirdPartySerialNo = httpServletRequest.getParameterValues("prpLthirdPartySerialNo");
			String[] prpLthirdPartyLicenseNo = httpServletRequest.getParameterValues("prpLthirdPartyLicenseNo");
			String[] prpLthirdPartyFrameNo = httpServletRequest.getParameterValues("prpLthirdPartyFrameNo");
			String[] carKindCodes  = httpServletRequest.getParameterValues("carKindCode");
			String[] prpLthirdPartyEngineNo = httpServletRequest.getParameterValues("prpLthirdPartyEngineNo");
			String[] licenseColorCodes = httpServletRequest.getParameterValues("licenseColorCode");
			String[] prpLthirdPartyModelCode = httpServletRequest.getParameterValues("prpLthirdPartyModelCode");
			String[] prpLthirdPartyBrandName = httpServletRequest.getParameterValues("prpLthirdPartyBrandName");
			String[] prpLthirdPartyInsureComCode = httpServletRequest.getParameterValues("prpLthirdPartyInsureComCode");
			String[] prpLthirdPartyInsureComName = httpServletRequest.getParameterValues("prpLthirdPartyInsureComName");
			String[] prpLthirePartyInsureCarFlag = httpServletRequest.getParameterValues("insureCarFlag");
			String[] prpLthirdPartyCarPolicyNo = httpServletRequest.getParameterValues("prpLthirdPartyCarPolicyNo");
			String[] prpLthirdPartyFlag = httpServletRequest.getParameterValues("flag");
			BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
			PrpLclaimDto prpLclaimDto = blPrpLclaimFacade.findByPrimaryKey(prpLthirdPartyClaimNo);
			for(int i=1;i < prpLthirdPartySerialNo.length;i++){
				 if(prpLthirdPartyFlag[i].equals("1")){
						String prpLthirdPartyRegistNo = prpLclaimDto.getRegistNo();
						PrpLthirdPartyDto prpLthirdPartyDto = new PrpLthirdPartyDto();
						prpLthirdPartyDto.setRegistNo(prpLthirdPartyRegistNo);
						prpLthirdPartyDto.setClaimNo(prpLthirdPartyClaimNo);
						prpLthirdPartyDto.setRiskCode(prpLthirdPartyRiskCode);
						prpLthirdPartyDto.setSerialNo(Integer.parseInt(prpLthirdPartySerialNo[i]));
						prpLthirdPartyDto.setLicenseNo(prpLthirdPartyLicenseNo[i]);
						prpLthirdPartyDto.setFrameNo(prpLthirdPartyFrameNo[i]);
						prpLthirdPartyDto.setCarKindCode(carKindCodes[i]);
						prpLthirdPartyDto.setEngineNo(prpLthirdPartyEngineNo[i]);
						prpLthirdPartyDto.setLicenseColorCode(licenseColorCodes[i]);
						prpLthirdPartyDto.setModelCode(prpLthirdPartyModelCode[i]);
						prpLthirdPartyDto.setBrandName(prpLthirdPartyBrandName[i]);
						prpLthirdPartyDto.setInsureCarFlag(prpLthirePartyInsureCarFlag[i]);
						prpLthirdPartyDto.setInsureComCode(prpLthirdPartyInsureComCode[i]);
						prpLthirdPartyDto.setInsureComName(prpLthirdPartyInsureComName[i]);
						prpLthirdPartyDto.setCarPolicyNo(prpLthirdPartyCarPolicyNo[i]);
						prpLthirdPartyDto.setFlag(prpLthirdPartyFlag[i]);
						prpLthirdPartyDtoList.add(prpLthirdPartyDto);
					}
				}
			
			compensateDto.setPrpLthirdPartyDtoList(prpLthirdPartyDtoList);
		}
		/*------------------- 互碰自赔---------------------------------END*/
		/*-------------------------维修发票信息-----------------------------*/
		ArrayList prpLcomRepairBillDtoList = new ArrayList();
		String prpLBillCompensateNo = (String) httpServletRequest.getAttribute("compensateNo");
		String[] itemNo = httpServletRequest.getParameterValues("prpLbillSerialNo");
		String[] carKind = httpServletRequest.getParameterValues("carKind");
		String[] licenseno = httpServletRequest.getParameterValues("licenseNo");
		String[] frameNo = httpServletRequest.getParameterValues("frameNo");
		String[] billType = httpServletRequest.getParameterValues("billType");
		String[] billNo = httpServletRequest.getParameterValues("billNo");
		PrpLcomRepairBillDto prpLcomRepairBillDto = null;
		if (itemNo == null) {

		}else{
			for (int index = 1; index < itemNo.length; index++) {
				prpLcomRepairBillDto = new PrpLcomRepairBillDto();
				prpLcomRepairBillDto.setItemno(Integer.parseInt(DataUtils.nullToZero(itemNo[index])));
				prpLcomRepairBillDto.setCompenSateNo(prpLBillCompensateNo);
				prpLcomRepairBillDto.setCarkind(carKind[index]);
				prpLcomRepairBillDto.setLicenseno(licenseno[index]);
				prpLcomRepairBillDto.setFrameno(frameNo[index]);
				prpLcomRepairBillDto.setBillType(billType[index]);
				prpLcomRepairBillDto.setBillNo(billNo[index]);
				prpLcomRepairBillDtoList.add(prpLcomRepairBillDto);
				compensateDto.setPrpLcomRepairBillDtoList(prpLcomRepairBillDtoList);
			}
			
		}
		
		/*-------------------------维修发票信息-----------------------------*/
		
		/*---------------------赔付人员信息prpLpersonLossDto------------------------------------*/
		ArrayList prpLpersonLossDtoList = new ArrayList();
		PrpLpersonLossDto prpLpersonLossDto = null;

		// 从界面得到输入数组
		// String prpLpersonLossCompensateNo =
		// httpServletRequest.getParameter("prpLcompensateCompensateNo");
		String prpLpersonLossCompensateNo = (String) httpServletRequest.getAttribute("compensateNo");
		String prpLpersonLossRiskCode = httpServletRequest.getParameter("prpLcompensateRiskCode");
		String prpLpersonLossPolicyNo = httpServletRequest.getParameter("prpLcompensatePolicyNo");

		String[] personLossSerialNo = httpServletRequest.getParameterValues("personLossSerialNo");
		String[] prpLpersonLossSerialNo = httpServletRequest.getParameterValues("prpLpersonLossSerialNo");
		String[] prpLpersonLossPersonNo = httpServletRequest.getParameterValues("prpLpersonLossPersonNo");
		String[] prpLpersonLossPersonName = httpServletRequest.getParameterValues("prpLpersonLossPersonName");
		String[] prpLpersonLossIdentifyNumber = httpServletRequest.getParameterValues("prpLpersonLossIdentifyNumber");
		String[] prpLpersonLossSex = httpServletRequest.getParameterValues("prpLpersonLossSex");
		String[] prpLpersonLossAge = httpServletRequest.getParameterValues("prpLpersonLossAge");
		String[] prpLpersonLossItemKindNo = httpServletRequest.getParameterValues("prpLpersonLossItemKindNo");
		String[] prpLpersonLossFamilyNo = httpServletRequest.getParameterValues("prpLpersonLossFamilyNo");
		String[] prpLpersonLossFamilyName = httpServletRequest.getParameterValues("prpLpersonLossFamilyName");
		String[] prpLpersonLossKindCode = httpServletRequest.getParameterValues("prpLpersonLossKindCode");
		String[] prpLpersonLossLiabCode = httpServletRequest.getParameterValues("prpLpersonLossLiabCode");
		String[] prpLpersonLossLiabName = httpServletRequest.getParameterValues("prpLpersonLossLiabName");
		String[] prpLpersonLossJobCode = httpServletRequest.getParameterValues("prpLpersonLossJobCode");
		String[] prpLpersonLossJobName = httpServletRequest.getParameterValues("prpLpersonLossJobName");
		String[] prpLpersonLossLiabDetailCode = httpServletRequest.getParameterValues("prpLpersonLossLiabDetailCode");
		String[] prpLpersonLossLiabDetailName = httpServletRequest.getParameterValues("prpLpersonLossLiabDetailName");
		String[] prpLpersonLossItemAddress = httpServletRequest.getParameterValues("prpLpersonLossItemAddress");
		String[] prpLpersonLossLossQuantity = httpServletRequest.getParameterValues("prpLpersonLossLossQuantity");
		String[] prpLpersonLossUnit = httpServletRequest.getParameterValues("prpLpersonLossUnit");
		String[] prpLpersonLossUnitAmount = httpServletRequest.getParameterValues("prpLpersonLossUnitAmount");
		String[] prpLpersonLossHospitalDays = httpServletRequest.getParameterValues("prpLpersonLossHospitalDays");
		String[] prpLpersonLossCurrency = httpServletRequest.getParameterValues("prpLpersonLossCurrency");
		String[] prpLpersonLossAmount = httpServletRequest.getParameterValues("prpLpersonLossAmount");
		String[] prpLpersonLossCurrency1 = httpServletRequest.getParameterValues("prpLpersonLossCurrency1");
		String[] prpLpersonLossItemValue = httpServletRequest.getParameterValues("prpLpersonLossItemValue");
		String[] prpLpersonLossCurrency2 = httpServletRequest.getParameterValues("prpLpersonLossCurrency2");
		String[] prpLpersonLossSumLoss = httpServletRequest.getParameterValues("prpLpersonLossSumLoss");
		String[] prpLpersonLossSumRest = httpServletRequest.getParameterValues("prpLpersonLossSumRest");
		String[] prpLpersonLossSumDefPay = httpServletRequest.getParameterValues("prpLpersonLossSumDefPay");
		String[] prpLpersonLossIndemnityDutyRate = httpServletRequest.getParameterValues("prpLpersonLossIndemnityDutyRate");
		String[] prpLpersonLossArrangeRate = httpServletRequest.getParameterValues("prpLpersonLossArrangeRate");
		String[] prpLpersonLossClaimRate = httpServletRequest.getParameterValues("prpLpersonLossClaimRate");
		String[] prpLpersonLossCurrency3 = httpServletRequest.getParameterValues("prpLpersonLossCurrency3");
		String[] prpLpersonLossDeductibleRate = httpServletRequest.getParameterValues("prpLpersonLossDeductibleRate");
		String[] prpLpersonLossDutyDeductibleRate = httpServletRequest.getParameterValues("prpLpersonLossDutyDeductibleRate");

		String[] prpLpersonLossDriverDeductibleRate = httpServletRequest.getParameterValues("prpLpersonLossDriverDeductibleRate");

		String[] prpLpersonLossMainKindDeductibleRate = httpServletRequest.getParameterValues("prpLpersonLossMainKindDeductibleRate");
		String[] prpLpersonLossDeductible = httpServletRequest.getParameterValues("prpLpersonLossDeductible");
		String[] prpLpersonLossCurrency4 = httpServletRequest.getParameterValues("prpLpersonLossCurrency4");
		String[] prpLpersonLossSumRealPay = httpServletRequest.getParameterValues("prpLpersonLossSumRealPay");
		String[] prpLpersonLossFlag = httpServletRequest.getParameterValues("prpLpersonLossFlag");
		//交强险人伤赔款金额
		String[] prpLpersonLossCISumRealPay = httpServletRequest.getParameterValues("prpLpersonLossCISumRealPay");
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLpersonLossRiskCode);
		if (personLossSerialNo == null) {

		} else {
			if (prpLpersonLossRiskCode != null
					&& "D".equals(strRiskType)) {
				// 对象赋值
				for (int index = 1; index < personLossSerialNo.length; index++) {
					prpLpersonLossDto = new PrpLpersonLossDto();
					prpLpersonLossDto.setPolicyNo(prpLpersonLossPolicyNo);
					prpLpersonLossDto.setRiskCode(prpLpersonLossRiskCode);
					prpLpersonLossDto.setCompensateNo(prpLpersonLossCompensateNo);
					prpLpersonLossDto.setSerialNo(index);
					// prpLpersonLossDto.setPersonNo (
					// Integer.parseInt(DataUtils.nullToZero(
					// prpLpersonLossPersonNo [index])));
					prpLpersonLossDto.setIdentifyNumber(prpLpersonLossIdentifyNumber[index]);
				  //  prpLpersonLossDto.setItemKindNo (Integer.parseInt(DataUtils.nullToZero(prpLpersonLossItemKindNo [index])));
					prpLpersonLossDto.setFamilyNo(Integer.parseInt(DataUtils.nullToZero(prpLpersonLossFamilyNo[index])));
					prpLpersonLossDto.setLiabCode(prpLpersonLossLiabCode[index]);
					prpLpersonLossDto.setLiabName(prpLpersonLossLiabName[index]);
					prpLpersonLossDto.setJobCode(prpLpersonLossJobCode[index]);
					prpLpersonLossDto.setJobName(prpLpersonLossJobName[index]);
					prpLpersonLossDto.setItemAddress(prpLpersonLossItemAddress[index]);
					prpLpersonLossDto.setUnit(prpLpersonLossUnit[index]);
					prpLpersonLossDto.setCurrency(prpLpersonLossCurrency[index]);
					prpLpersonLossDto.setAmount(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossAmount[index])));

					prpLpersonLossDto.setCurrency1(prpLpersonLossCurrency1[index]);
					prpLpersonLossDto.setItemValue(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossItemValue[index])));
					prpLpersonLossDto.setCurrency2(prpLpersonLossCurrency2[index]);
					prpLpersonLossDto.setSumRest(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossSumRest[index])));
					prpLpersonLossDto.setClaimRate(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossClaimRate[index])));
					prpLpersonLossDto.setDeductible(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDeductible[index])));
					prpLpersonLossDto.setCurrency4(prpLpersonLossCurrency4[index]);
					prpLpersonLossDto.setSumRealPay(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossSumRealPay[index])));
					prpLpersonLossDto.setFlag(prpLpersonLossFlag[index]);
					prpLpersonLossDto.setLiabDetailCode(prpLpersonLossLiabDetailCode[index]);
					prpLpersonLossDto.setLiabDetailName(prpLpersonLossLiabDetailName[index]);
					prpLpersonLossDto.setUnitAmount(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossUnitAmount[index])));

					prpLpersonLossDto.setHospitalDays(Integer.parseInt(DataUtils.nullToZero(prpLpersonLossHospitalDays[index])));
					prpLpersonLossDto.setLossQuantity(Integer.parseInt(DataUtils.nullToZero(prpLpersonLossLossQuantity[index])));
					prpLpersonLossDto.setSumLoss(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossSumLoss[index])));
					prpLpersonLossDto.setSumDefPay(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossSumDefPay[index])));
					prpLpersonLossDto.setCISumRealPay(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossCISumRealPay[index])));
					//prpLpersonLossDto.setKindCode(damageKind[index]);
					
					//prpLpersonLossDto.setIndemnityDutyRate (Double.parseDouble(DataUtils.nullToZero(prpLpersonLossIndemnityDutyRate				  [index]))); 
					//prpLpersonLossDto.setKindCode (prpLpersonLossKindCode [index]);
					//prpLpersonLossDto.setDeductibleRate (Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDeductibleRate[index])));
					
					for (int index2 = 1; index2 < prpLpersonLossSerialNo.length; index2++) {
						if (prpLpersonLossSerialNo[index2].equals(personLossSerialNo[index])) {
							// 少数派
							prpLpersonLossDto.setSex(prpLpersonLossSex[index2]);
							prpLpersonLossDto.setPersonName(prpLpersonLossPersonName[index2]);
							prpLpersonLossDto.setAge(Integer.parseInt(DataUtils.nullToZero(prpLpersonLossAge[index2])));
							prpLpersonLossDto.setCurrency3(prpLpersonLossCurrency3[index2]);
							prpLpersonLossDto.setKindCode(prpLpersonLossKindCode[index2]);
							prpLpersonLossDto.setFamilyName(prpLpersonLossFamilyName[index2]);// 车牌号码

							prpLpersonLossDto.setIndemnityDutyRate(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossIndemnityDutyRate[index2])));
							prpLpersonLossDto.setArrangeRate(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossArrangeRate[index2])));
							
							prpLpersonLossDto.setKindCode(prpLpersonLossKindCode[index2]);
							prpLpersonLossDto.setDutyDeductibleRate(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDutyDeductibleRate[index2])));
							prpLpersonLossDto.setMainKindDeductibleRate(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossMainKindDeductibleRate[index2])));

							prpLpersonLossDto.setDeductibleRate(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDeductibleRate[index2])));
							prpLpersonLossDto.setDriverDeductibleRate(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDriverDeductibleRate[index2])));
							prpLpersonLossDto.setPersonNo(index2);
							prpLpersonLossDto.setItemKindNo(Integer.parseInt(DataUtils.nullToZero(prpLpersonLossItemKindNo[index2])));
						}
					}
					
		      //用旧的危险单位方法保存
               if(DangerUnitCheckSaveFlag.equals("1")){			
					// 加入危险单位收集 add by qinyongli 2005-9-10
					prpLdangerItemDto = new PrpLdangerItemDto();
					prpLdangerItemDto.setCertiNo(prpLlossDtoCompensateNo); // 实赔号
					prpLdangerItemDto.setDangerNo(1); // 目前只有一个危险单位
					prpLdangerItemDto.setCurrency(prpLpersonLossCurrency[index]); // 损失币别
					prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
					prpLdangerItemDto.setKindName("正常"); // 险别归类名称
					prpLdangerItemDto.setRiskCode(prpLpersonLossRiskCode); // 险别
					prpLdangerItemDto.setSerialNo(dangerItemSerialNo); // 标的序号
					dangerItemSerialNo++;
					prpLdangerItemDto.setSumPaid(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossSumRealPay[index])));
					// 已决赔款
					prpLprpLdangerItemList.add(prpLdangerItemDto);
					// add by qinyongli end 2005-9-10
			   }		
					// 加入集合
					prpLpersonLossDtoList.add(prpLpersonLossDto);
				}
			} else {
				// 对象赋值
				for (int index = 1; index < personLossSerialNo.length; index++) {
					prpLpersonLossDto = new PrpLpersonLossDto();
					prpLpersonLossDto.setPolicyNo(prpLpersonLossPolicyNo);
					prpLpersonLossDto.setRiskCode(prpLpersonLossRiskCode);
					prpLpersonLossDto.setCompensateNo(prpLpersonLossCompensateNo);
					prpLpersonLossDto.setSerialNo(index);
					// prpLpersonLossDto.setPersonNo (
					// Integer.parseInt(DataUtils.nullToZero(
					// prpLpersonLossPersonNo [index])));
					prpLpersonLossDto.setIdentifyNumber(prpLpersonLossIdentifyNumber[index]);
					prpLpersonLossDto.setItemKindNo(Integer.parseInt(DataUtils.nullToZero(prpLpersonLossItemKindNo[index])));
					prpLpersonLossDto.setFamilyNo(Integer.parseInt(DataUtils.nullToZero(prpLpersonLossFamilyNo[index])));
					prpLpersonLossDto.setLiabCode(prpLpersonLossLiabCode[index]);
					prpLpersonLossDto.setLiabName(prpLpersonLossLiabName[index]);
					prpLpersonLossDto.setJobCode(prpLpersonLossJobCode[index]);
					prpLpersonLossDto.setJobName(prpLpersonLossJobName[index]);
					prpLpersonLossDto.setItemAddress(prpLpersonLossItemAddress[index]);
					prpLpersonLossDto.setUnit(prpLpersonLossUnit[index]);
					prpLpersonLossDto.setCurrency(prpLpersonLossCurrency[index]);
					prpLpersonLossDto.setAmount(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossAmount[index])));
					prpLpersonLossDto.setCurrency1(prpLpersonLossCurrency1[index]);
					prpLpersonLossDto.setItemValue(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossItemValue[index])));
					prpLpersonLossDto.setCurrency2(prpLpersonLossCurrency2[index]);
					prpLpersonLossDto.setSumRest(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossSumRest[index])));
					prpLpersonLossDto.setClaimRate(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossClaimRate[index])));
					prpLpersonLossDto.setDeductible(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDeductible[index])));
					prpLpersonLossDto.setCurrency4(prpLpersonLossCurrency4[index]);
					prpLpersonLossDto.setSumRealPay(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossSumRealPay[index])));
					prpLpersonLossDto.setFlag(prpLpersonLossFlag[index]);
					prpLpersonLossDto.setLiabDetailCode(prpLpersonLossLiabDetailCode[index]);
					prpLpersonLossDto.setLiabDetailName(prpLpersonLossLiabDetailName[index]);
					prpLpersonLossDto.setUnitAmount(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossUnitAmount[index])));
					prpLpersonLossDto.setHospitalDays(Integer.parseInt(DataUtils.nullToZero(prpLpersonLossHospitalDays[index])));
					prpLpersonLossDto.setLossQuantity(Integer.parseInt(DataUtils.nullToZero(prpLpersonLossLossQuantity[index])));
					prpLpersonLossDto.setSumLoss(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossSumLoss[index])));

					// prpLpersonLossDto.setSex ( prpLpersonLossSex [index]);
					// prpLpersonLossDto.setPersonName (
					// prpLpersonLossPersonName [index]);
					// prpLpersonLossDto.setAge (
					// Integer.parseInt(DataUtils.nullToZero( prpLpersonLossAge
					// [index])));
					prpLpersonLossDto.setCurrency3(prpLpersonLossCurrency3[index]);
					prpLpersonLossDto.setFamilyName(prpLpersonLossFamilyName[index]);
					prpLpersonLossDto.setIndemnityDutyRate(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossIndemnityDutyRate[index])));
					prpLpersonLossDto.setArrangeRate(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossArrangeRate[index])));

					prpLpersonLossDto.setKindCode(prpLpersonLossKindCode[index]);
					prpLpersonLossDto.setDutyDeductibleRate(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDutyDeductibleRate[index])));
					prpLpersonLossDto.setDriverDeductibleRate(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDriverDeductibleRate[index])));
					prpLpersonLossDto.setDeductibleRate(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDeductibleRate[index])));
					prpLpersonLossDto.setPersonNo(index);
					//prpLpersonLossDto.setKindCode("");

					for (int index2 = 0; index2 < prpLpersonLossSerialNo.length; index2++) {
						if (prpLpersonLossSerialNo[index2].equals(personLossSerialNo[index])) {
							// 少数派
							/*
							 * prpLpersonLossDto.setCurrency3 (
							 * prpLpersonLossCurrency3 [index2]);
							 * prpLpersonLossDto.setFamilyName (
							 * prpLpersonLossFamilyName [index2]);
							 * prpLpersonLossDto.setIndemnityDutyRate (
							 * Double.parseDouble(DataUtils.nullToZero(prpLpersonLossIndemnityDutyRate
							 * [index2]))); prpLpersonLossDto.setKindCode (
							 * prpLpersonLossKindCode [index2]);
							 * prpLpersonLossDto.setDeductibleRate (
							 * Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDeductibleRate
							 * [index2]))); prpLpersonLossDto.setPersonNo
							 * (index2);
							 */
							prpLpersonLossDto.setAge(Integer.parseInt(DataUtils.nullToZero(prpLpersonLossAge[index2])));
							prpLpersonLossDto.setPersonNo(index2);
							prpLpersonLossDto.setPersonName(prpLpersonLossPersonName[index2]);
							prpLpersonLossDto.setSex(prpLpersonLossSex[index2]);
						}
					}
					// 加入集合
					prpLpersonLossDtoList.add(prpLpersonLossDto);
				}
			}
		}
//--------------------------------------------------------------------------------
	  strConfigCode = uiCodeAction.translateRiskCodetoConfigCode(prpLpersonLossRiskCode);
		
		if ("RISKCODE_DAZ".equals(strConfigCode)||"RISKCODE_DAY".equals(strConfigCode)||"RISKCODE_DAU".equals(strConfigCode)){
			
			dangerItemSerialNo =this.personLossCompelInit(httpServletRequest,prpLpersonLossDtoList, prpLprpLdangerItemList, dangerItemSerialNo);	
		   
		}	
		//----------------------------------------------------LYM
		compensateDto.setPrpLpersonLossDtoList(prpLpersonLossDtoList);

		/*---------------------赔款费用信息prpLchargeDto------------------------------------*/
		ArrayList prpLchargeDtoList = new ArrayList();
		PrpLchargeDto prpLchargeDto = null;

		// 从界面得到输入数组
		String prpLchargePolicyNo = httpServletRequest.getParameter("prpLcompensatePolicyNo");
		String prpLchargeRiskCode = httpServletRequest.getParameter("prpLcompensateRiskCode");
		// String prpLchargeCompensateNo =
		// httpServletRequest.getParameter("prpLcompensateCompensateNo");
		String prpLchargeCompensateNo = (String) httpServletRequest.getAttribute("compensateNo");
		String[] prpLchargeSerialNo = httpServletRequest.getParameterValues("prpLchargeSerialNo");
		String[] prpLchargeKindCode = httpServletRequest.getParameterValues("prpLchargeKindCode");
		String[] prpLchargeChargeCode = httpServletRequest.getParameterValues("prpLchargeChargeCode");
		String[] prpLchargeChargeName = httpServletRequest.getParameterValues("prpLchargeChargeName");
		String[] prpLchargeCurrency = httpServletRequest.getParameterValues("prpLchargeCurrency");
		String[] prpLchargeChargeAmount = httpServletRequest.getParameterValues("prpLchargeChargeAmount");
		String[] prpLpreChargeAmount = httpServletRequest.getParameterValues("prpLpreChargeAmount");
		String[] prpLchargeSumRealPay = httpServletRequest.getParameterValues("prpLchargeSumRealPay");
		String[] prpLchargeFlag = httpServletRequest.getParameterValues("prpLchargeFlag");
		String[] prpLchargeChargeReport = httpServletRequest.getParameterValues("prpLchargeChargeReport");   //add 20060512
		String[] prpLchargePayObjectType = httpServletRequest.getParameterValues("prpLchargePayObjectType");    //add 20060803
		String[] prpLchargePayObjectCode = httpServletRequest.getParameterValues("prpLchargePayObjectCode");    //add 20060803
		String[] prpLchargePayObjectName= httpServletRequest.getParameterValues("prpLchargePayObjectName");     //add 20060803
		String[] prpLlossDtoItemKindNoForCharge= httpServletRequest.getParameterValues("prpLlossDtoItemKindNoForCharge");     //add 20110519 
		String[] prpLchargeCheckDeptCode= httpServletRequest.getParameterValues("prpLchargeCheckDeptCode");
		String[] prpLchargeCheckDeptName= httpServletRequest.getParameterValues("prpLchargeCheckDeptName");
		
		// 对象赋值
		if (prpLchargeSerialNo == null) {

		} else {
			
			for (int index = 1; index < prpLchargeSerialNo.length; index++) {
				
				prpLchargeDto = new PrpLchargeDto();
				prpLchargeDto.setPolicyNo(prpLchargePolicyNo);
				prpLchargeDto.setRiskCode(prpLchargeRiskCode);
				prpLchargeDto.setCompensateNo(prpLchargeCompensateNo);

				prpLchargeDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLchargeSerialNo[index])));
				prpLchargeDto.setKindCode(prpLchargeKindCode[index]);
				prpLchargeDto.setChargeCode(prpLchargeChargeCode[index]);
				prpLchargeDto.setChargeName(prpLchargeChargeName[index]);
				if(prpLchargeChargeCode[index]!=null&&"14".equals(prpLchargeChargeCode[index])){
					prpLchargeDto.setCheckDeptCode(prpLchargeCheckDeptCode[index]);
					prpLchargeDto.setCheckDeptName(prpLchargeCheckDeptName[index]);
	            }
				prpLchargeDto.setCurrency(prpLchargeCurrency[index]);
				prpLchargeDto.setChargeAmount(Double.parseDouble(DataUtils.nullToZero(prpLchargeChargeAmount[index])));
				prpLchargeDto.setPreChargeAmount(Double.parseDouble(DataUtils.nullToZero(prpLpreChargeAmount[index])));
				prpLchargeDto.setSumRealPay(Double.parseDouble(DataUtils.nullToZero(prpLchargeSumRealPay[index])));
				prpLchargeDto.setFlag(prpLchargeFlag[index]);
				if(prpLchargePayObjectCode != null){
					prpLchargeDto.setPayObjectCode(prpLchargePayObjectCode[index]);
				}
				if(prpLchargePayObjectType != null){
					prpLchargeDto.setPayObjectType(prpLchargePayObjectType[index]);
				}
				if(prpLchargePayObjectName != null){
					prpLchargeDto.setPayObjectName(prpLchargePayObjectName[index]);
				}
				prpLchargeDto.setChargeReport(Double.parseDouble( DataUtils.nullToZero(prpLchargeChargeReport[index] ))); //add 20060512
				prpLchargeDto.setItemkindno(Integer.parseInt(DataUtils.nullToZero(prpLlossDtoItemKindNoForCharge[index])));
				
				String configCode = uiCodeAction.translateRiskCodetoConfigCode(prpLlossDtoRiskCode);
				
				 //用旧的危险单位方法保存
          if(DangerUnitCheckSaveFlag.equals("1")){
				// 加入危险单位收集 add by qinyongli 2005-9-10
				prpLdangerItemDto = new PrpLdangerItemDto();
				prpLdangerItemDto.setCertiNo(prpLchargeCompensateNo); // 实赔号
				prpLdangerItemDto.setDangerNo(1); // 目前只有一个危险单位
				prpLdangerItemDto.setCurrency(prpLchargeCurrency[index]); // 损失币别
				prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
				prpLdangerItemDto.setKindName("正常"); // 险别归类名称
				prpLdangerItemDto.setRiskCode(prpLchargeRiskCode); // 险别
				prpLdangerItemDto.setSerialNo(dangerItemSerialNo); // 标的序号
				dangerItemSerialNo++;
				prpLdangerItemDto.setSumFee(Double.parseDouble(DataUtils.nullToZero(prpLchargeSumRealPay[index])));
				
				// 已决赔款
				prpLprpLdangerItemList.add(prpLdangerItemDto);
				// add by qinyongli end 2005-9-10
		    }
				// 加入集合
				prpLchargeDtoList.add(prpLchargeDto);
					}
				
			}
		
		// 赔款费用信息
		compensateDto.setPrpLchargeDtoList(prpLchargeDtoList);

		ArrayList prpLqualityCheckDtoList = new ArrayList();
		PrpLqualityCheckDto prpLqualityCheckDto = null;
		String strCount = httpServletRequest.getParameter("txtRecordNum");
		int intCount = Integer.parseInt(strCount);
		int j = 0;
		String strQuestionCode = "";
		String strQuestionName = "";
		String strQuestionRemark = "";
		String strVisitBackQueRes = "";
		for (int i = 0; i < intCount; i++) {
			j = i + 1;

			strQuestionCode = "txtQuestionCode" + j;
			strQuestionName = "txtQuestionName" + j;
			strQuestionRemark = "txtQuestionRemark" + j;
			strVisitBackQueRes = "VisitBackQue" + j;
			prpLqualityCheckDto = new PrpLqualityCheckDto();
			prpLqualityCheckDto.setRegistNo(compensateDto.getPrpLcompensateDto().getCompensateNo());
			prpLqualityCheckDto.setQualityCheckType(httpServletRequest.getParameter("qualityCheckType"));
			prpLqualityCheckDto.setSerialNo(i + 1);
			prpLqualityCheckDto.setTypeName(httpServletRequest.getParameter(strQuestionName));
			prpLqualityCheckDto.setTypeCode(httpServletRequest.getParameter(strQuestionCode));
			prpLqualityCheckDto.setCheckResult(httpServletRequest.getParameter(strVisitBackQueRes));
			prpLqualityCheckDto.setCheckRemark(httpServletRequest.getParameter(strQuestionRemark));
			prpLqualityCheckDto.setFlag("");
			prpLqualityCheckDtoList.add(prpLqualityCheckDto);
		}
		// 加到ArrayList中
		compensateDto.setPrpLqualityCheckList(prpLqualityCheckDtoList);
		// 整理回访问询信息结束

		/*---------------------报案信息补充说明 PrpLregistExt ------------------------------------*/
		ArrayList prpLregistExtDtoList = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = null;
		// 从界面得到输入数组
		String prpLregistExtRegistNo = (String) httpServletRequest.getParameter("prpLregistExtRegistNo");
		String prpLregistExtRiskCode = httpServletRequest.getParameter("prpLregistExtRiskCode");
		String[] prpLregistExtSerialNo = httpServletRequest.getParameterValues("prpLregistExtSerialNo");
		String[] prpLregistExtInputDate = httpServletRequest.getParameterValues("prpLregistExtInputDate");
		String[] prpLregistExtInputHour = httpServletRequest.getParameterValues("prpLregistExtInputHour");
		String[] prpLregistExtOperatorCode = httpServletRequest.getParameterValues("prpLregistExtOperatorCode");
		String[] prpLregistExtContext = httpServletRequest.getParameterValues("prpLregistExtContext");

		// 对象赋值
		// 人员伤亡跟踪 部分开始
		if (prpLregistExtSerialNo == null) {
		} else {
			for (int index = 1; index < prpLregistExtSerialNo.length; index++) {
				prpLregistExtDto = new PrpLregistExtDto();
				prpLregistExtDto.setRegistNo(prpLregistExtRegistNo);
				prpLregistExtDto.setRiskCode(prpLregistExtRiskCode);
				prpLregistExtDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLregistExtSerialNo[index])));
				prpLregistExtDto.setInputDate(new DateTime(prpLregistExtInputDate[index], DateTime.YEAR_TO_DAY));
				prpLregistExtDto.setInputHour(prpLregistExtInputHour[index]);
				prpLregistExtDto.setOperatorCode(prpLregistExtOperatorCode[index]);
				prpLregistExtDto.setContext(prpLregistExtContext[index]);
				// 加入集合
				prpLregistExtDtoList.add(prpLregistExtDto);
			}
			// 报案集合中加入损失部位
			compensateDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
		}

		ArrayList prpLcfeeDtoList = new ArrayList();
		PrpLcfeeDto prpLcfeeDto = null;
		// 从界面得到输入数组
		String prpLcfeeCompensateNo = (String) httpServletRequest.getAttribute("compensateNo");
		String prpLcfeePolicyNo = httpServletRequest.getParameter("prpLcompensatePolicyNo");
		String prpLcfeeRiskCode = httpServletRequest.getParameter("prpLcompensateRiskCode");
		String prpLcfeeCurrency1 = httpServletRequest.getParameter("prpLcompensateCurrency");
		String prpLcfeeSumThisPaid = httpServletRequest.getParameter("prpLcompensateSumThisPaid");
		String prpLcfeeFlag = httpServletRequest.getParameter("prpLcfeeFlag");
		// 对象赋值
		// 赔款计算金额信息
		prpLcfeeDto = new PrpLcfeeDto();
		prpLcfeeDto.setCompensateNo(prpLcfeeCompensateNo);
		prpLcfeeDto.setPolicyNo(prpLcfeePolicyNo);
		prpLcfeeDto.setRiskCode(prpLcfeeRiskCode);
		prpLcfeeDto.setCurrency(prpLcfeeCurrency1);
		prpLcfeeDto.setSumPaid(Double.parseDouble(DataUtils.nullToZero(prpLcfeeSumThisPaid)));
		prpLcfeeDto.setFlag("");
		prpLcfeeDtoList.add(prpLcfeeDto);
		compensateDto.setPrpLcfeeDtoList(prpLcfeeDtoList);

		// 如果案件属于案终赔付，则需要结案报告文本 2005-07-20
		String prpLcompensateFinallyFlag = httpServletRequest.getParameter("prpLcompensateFinallyFlag");
		//modify by lixiang start 2006-8-1
		//reason:由于不是第一张计算书的情况下，要说明后续情况，所以就要保存数据了
		//if (prpLcompensateFinallyFlag.equals("1")) {
			ArrayList prpLltextDtoList = new ArrayList();
			String TextTemp = httpServletRequest.getParameter("prpLltextContextInnerHTML");
			//System.out.println("后续说明的内容："+TextTemp);
			String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);
			// 得到连接串,下面将其切分到数组
			for (int k = 0; k < rules.length; k++) {
				PrpLltextDto prpLltextDto = new PrpLltextDto();
				prpLltextDto.setClaimNo((String) httpServletRequest.getParameter("prpLcompensateClaimNo"));
				prpLltextDto.setContext(rules[k]);
				prpLltextDto.setLineNo(k + 1);
				prpLltextDto.setTextType("08");
				prpLltextDtoList.add(prpLltextDto);
			}
			compensateDto.setPrpLltextDtoList(prpLltextDtoList);
		//}
        //modify by lixiang end 2006-8-1
		// ----------------------------危险单位信息处理,目前只有一个危险单位
		// String TCurrency = httpServletRequest.getParameter("MergeCurrency");
      //用旧的危险单位方法保存
       if(DangerUnitCheckSaveFlag.equals("1")){		
		// 将危险单位标的信息保存在集合中：add by qinyongli 2005-9-10
		compensateDto.setPrpLprpLdangerItemList(prpLprpLdangerItemList);
		// 对标的信息进行处理，得到，合计信息
		ArrayList itemList = prpLprpLdangerItemList;
		PrpLdangerItemDto dangerItemAll = new PrpLdangerItemDto(); // 获取每个标的对象
		PrpLdangerItemDto dangerItem = new PrpLdangerItemDto(); // 循环判断时使用
		ArrayList tempCurrency = new ArrayList();
		Iterator itemListIteratorAll = itemList.iterator();
		Iterator itemListIterator = itemList.iterator();
		PrpLdangerItemDto dangerItemAll1 = new PrpLdangerItemDto();
		while (itemListIteratorAll.hasNext()) {
			dangerItemAll = (PrpLdangerItemDto) itemListIteratorAll.next();
			dangerItemAll1 = new PrpLdangerItemDto();
			dangerItemAll1.setSumFee(dangerItemAll.getSumFee());
			dangerItemAll1.setSumPaid(dangerItemAll.getSumPaid());
			// 用当前币别遍历集合进行统计
			String currentCur = dangerItemAll.getCurrency();
			int currentSerial = dangerItemAll.getSerialNo();
			while (itemListIterator.hasNext()) {
				dangerItem = (PrpLdangerItemDto) itemListIterator.next();
				// 如果币别相等，则对赔偿金额和费用进行累加
				if (currentSerial != dangerItem.getSerialNo() && currentCur.equals(dangerItem.getCurrency())) {
					dangerItemAll1.setSumFee(dangerItemAll.getSumFee() + dangerItem.getSumFee()); // 合计费用
					dangerItemAll1.setSumPaid(dangerItemAll.getSumPaid() + dangerItem.getSumPaid()); // 合计金额
				}
			}
			if (tempCurrency.contains(currentCur)) {
				continue; // 如果已经合计过的币种，不再进行合计;
			}
			tempCurrency.add(currentCur); // 将当前合计的币种暂存 ;
			// 将标的信息加入合计Dto
			if (dangerItemAll != null) {
				
				prpLdangerTotDto.setCertiNo(dangerItemAll.getCertiNo());
				prpLdangerTotDto.setDangerNo(1); // 目前，就一个危险单位
				prpLdangerTotDto.setSCurrency(dangerItemAll.getCurrency()); // 标的原币别
				prpLdangerTotDto.setSumFee(dangerItemAll1.getSumFee());
				prpLdangerTotDto.setSumPaid(dangerItemAll1.getSumPaid());
				prpLdangerTotDto.setTCurrency("CNY");
				// 进行币别转化 转化后的币别为TCurrency
				String SCurrency = dangerItemAll.getCurrency(); // 原币别
				double exchangeRate = PubTools.getExchangeRate("CNY", "CNY", String.valueOf(new Date()));
				prpLdangerTotDto.setExchRate(exchangeRate);
				prpLdangerTotDto.setSumFeeEx(dangerItemAll.getSumFee() * exchangeRate);
				prpLdangerTotDto.setSumPaidEx(dangerItemAll.getSumPaid() * exchangeRate);
			}
			if (prpLdangerTotDto != null) {
				prpLprpLdangerTotList.add(prpLdangerTotDto);
			}
		}
		compensateDto.setPrpLprpLdangerTotList(prpLprpLdangerTotList);
		// 将危险单位标的信息保存在集合中：add by qinyongli 2005-9-10 end
		// ******---------------------危险单位信息 add by qinyongli 2005-8-19
		// start------------------------------------*/
		
        //add by kangzhen 061130 start reason 给再保送数据
		UIPolicyAction uiPolicyAction =new UIPolicyAction();
        PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(compensateDto.getPrpLcompensateDto().getPolicyNo());
        PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
        String strCoinsFlag = prpCmainDto.getCoinsFlag();
        //add by kangzhen 061130 end 
		ArrayList dangerUnitList = new ArrayList();
		PrpLdangerUnitDto prpLdangerUnitDto = null;
		// 从界面得到输入数组
		String compensateNo = (String) httpServletRequest.getAttribute("compensateNo");
		String[] prpLdangerClaimNo = httpServletRequest.getParameterValues("prpLdangerClaimNo");
		String[] prpLdangerPolicyNo = httpServletRequest.getParameterValues("prpLdangerPolicyNo");
		String[] prpLdangerRiskCode = httpServletRequest.getParameterValues("prpLdangerRiskCode");
		String[] prpLdangerUnitDesc = httpServletRequest.getParameterValues("prpLdangerUnitDesc");
		String[] prpLdangerAddressName = httpServletRequest.getParameterValues("prpLdangerAddressName");
		String[] prpLdangerCurrency = httpServletRequest.getParameterValues("prpLdangerCurrency");
		String[] prpLcompensateSumThisPaid = httpServletRequest.getParameterValues("prpLcompensateSumThisPaid");
		String[] prpLdangerRiskSumClaim = httpServletRequest.getParameterValues("prpLdangerRiskSumClaim");
		String[] prpLdangerRiskSumPaid = httpServletRequest.getParameterValues("prpLdangerRiskSumPaid");
		String[] prpLdangerProportion = httpServletRequest.getParameterValues("prpLdangerProportion");
		String prpLcompensateSumNoDutyFee = httpServletRequest.getParameter("prpLcompensateSumNoDutyFee");
		// 对象赋值
		if (prpLdangerCurrency == null) {
		} else {
			for (int index = 0; index < prpLdangerCurrency.length; index++) {
				prpLdangerUnitDto = new PrpLdangerUnitDto();
				prpLdangerUnitDto.setCertiNo(compensateNo);
				prpLdangerUnitDto.setClaimNo(prpLdangerClaimNo[index]);
				
				prpLdangerUnitDto.setRiskCode(prpLdangerRiskCode[index]);
				
				prpLdangerUnitDto.setPolicyNo(prpLdangerPolicyNo[index]);
				prpLdangerUnitDto.setDangerNo(index + 1);
				prpLdangerUnitDto.setDangerDesc(prpLdangerUnitDesc[index]);
				prpLdangerUnitDto.setAddressName(prpLdangerAddressName[index]);
				prpLdangerUnitDto.setCurrency(prpLdangerCurrency[index]);
				prpLdangerUnitDto.setSumLoss(Double.parseDouble(prpLdangerRiskSumClaim[index]));
				prpLdangerUnitDto.setSumPaid(Double.parseDouble(prpLdangerRiskSumPaid[index]));
				prpLdangerUnitDto.setDamageDate(compensateDto.getPrpLcompensateDto().getDamageStartDate());
				prpLdangerUnitDto.setBusinessNature(prpCmainDto.getBusinessNature());
				prpLdangerUnitDto.setPolicyBizType(prpCmainDto.getPolicyBizType());
				prpLdangerUnitDto.setPolicyType(prpCmainDto.getPolicyType());
				prpLdangerUnitDto.setBusinessType(prpCmainDto.getBusinessType());
				prpLdangerUnitDto.setBusinessType1(prpCmainDto.getBusinessType1());
				prpLdangerUnitDto.setOthFlag(prpCmainDto.getOthFlag());
				prpLdangerUnitDto.setBusinessProvince(prpCmainDto.getBusinessProvince());
				prpLdangerUnitDto.setBusinessTown(prpCmainDto.getBusinessTown());
				prpLdangerUnitDto.setBusinessCounty(prpCmainDto.getBusinessCounty());
				prpLdangerUnitDto.setBusinessAreaName(prpCmainDto.getBusinessAreaName());
				//prpLdangerUnitDto.setSumFee(Double.parseDouble(prpLcompensateSumNoDutyFee));
				// 从立案获取实赔
				if (!prpLdangerClaimNo[index].equals("")) {
					ClaimDto claimDto = new ClaimDto();
					UIClaimAction uiclaimAction = new UIClaimAction();
					claimDto = uiclaimAction.findByPrimaryKey(prpLdangerClaimNo[index]);
					double sumPaid = claimDto.getPrpLclaimDto().getSumPaid();
					prpLdangerUnitDto.setSumNoPaid(Double.parseDouble(prpLdangerRiskSumClaim[index]) - sumPaid);
				}
           	    if("1".equals(prpLcompensateFinallyFlag)){
        	      prpLdangerUnitDto.setCertiType("3");//案终为实赔
        	      prpLdangerUnitDto.setSumNoPaid(0);  //结案  未决赔款置零
        	    }else{
        	 	  prpLdangerUnitDto.setCertiType("3");
        	 	  prpLdangerUnitDto.setSumNoPaid(prpLdangerUnitDto.getSumNoPaid()-Double.parseDouble(prpLcompensateSumThisPaid[index]));
        	    }
				prpLdangerUnitDto.setDangerShare(Double.parseDouble(prpLdangerProportion[index]));
				prpLdangerUnitDto.setCoinsFlag(strCoinsFlag);//add by kangzhen 061129

				// 加入集合
				if (prpLdangerPolicyNo[index] != null && !(prpLdangerPolicyNo[index].equals(""))) {
					dangerUnitList.add(prpLdangerUnitDto);
				}
			}
			if (dangerUnitList.size() > 0) {
				compensateDto.setPrplRiskUnitDtoList(dangerUnitList);
			}
		}
	// ******---------------------危险单位信息 add by qinyongli 2005-8-19
	}else if(DangerUnitCheckSaveFlag.equals("2")){
		//新的危险单位保存方法
		 //******---------------------危险单位信息 国元项目组  start------------------------------------*/

        UIPolicyAction uiPolicyAction =new UIPolicyAction();
        PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(compensateDto.getPrpLcompensateDto().getPolicyNo());
        PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
        String strCoinsFlag = prpCmainDto.getCoinsFlag();
		BLPrpLdangerUnitFacade blPrpLdangerUnitFacade = new BLPrpLdangerUnitFacade();
		PrpLdangerUnitDto prpLdangerUnitClaimDto = new PrpLdangerUnitDto();
		
        ArrayList  dangerUnitList = new ArrayList();
        ArrayList  dangerItemList = new ArrayList();
        ArrayList  dangerTotList = new ArrayList();
        ArrayList  prpLchargeList = compensateDto.getPrpLchargeDtoList();
        PrpLchargeDto lchargeDto = null;
        boolean isfee;
    
        double temp=0;
        double sumDangerUnit=0d;
        boolean flag=true; 
       
        //从界面得到输入数组
        String prpLdangerCompensateNo = (String) httpServletRequest.getAttribute("compensateNo");//理算书号
        
        String[] prpLdangerPolicyNo = httpServletRequest.getParameterValues("prpLdangerPolicyNo");//保单号
        String[] prpLdangerRiskCode = httpServletRequest.getParameterValues("prpLdangerRiskCode");//险种代码
        String[] prpLdangerUnitDesc = httpServletRequest.getParameterValues("prpLdangerUnitDangerDesc");//危险单位描述
        String[] prpLdangerAddressName = httpServletRequest.getParameterValues("prpLdangerUnitAddressName");//危险单位地址
        String[] prpLdangerCurrency = httpServletRequest.getParameterValues("prpLdangerCurrency");//币别
        String[] prpLdangerUnitSumLoss = httpServletRequest.getParameterValues("prpLdangerUnitSumLoss");//赔付金额
        String[] prpLdangerDangerNo = httpServletRequest.getParameterValues("prpLdangerDangerNo");//危险单位号
        String[] prpLdangerShare = httpServletRequest.getParameterValues("prpLdangerShare");//占比
        String[] prpLdangerKindcode = httpServletRequest.getParameterValues("prpLdangerKindcode");//险别代码
        String[] prpLdangerKindname = httpServletRequest.getParameterValues("prpLdangerKindname");//险别名称
        String[] prpLdangerItemCode = httpServletRequest.getParameterValues("prpLdangerItemCode");//标的代码
        String[] prpLdangerItemName = httpServletRequest.getParameterValues("prpLdangerItemName");//标的名称
        String[] prpLdangerUnitItemKindNo = httpServletRequest.getParameterValues("prpLdangerUnitItemKindNo");//标的序号
        
        String[] prpLdangerBusinessNature = httpServletRequest.getParameterValues("prpLdangerBusinessNature");//业务来源
        String[] prpLdangerPolicyBizType = httpServletRequest.getParameterValues("prpLdangerPolicyBizType");//保单业务类型
        String[] prpLdangerPolicyType = httpServletRequest.getParameterValues("prpLdangerPolicyType");//投保方式
        String[] prpLdangerBusinessType1 = httpServletRequest.getParameterValues("prpLdangerBusinessType1");//政策性标志
        String[] prpLdangerBusinessType = httpServletRequest.getParameterValues("prpLdangerBusinessType");//涉农标识
        String[] prpLdangerOthFlag = httpServletRequest.getParameterValues("prpLdangerOthFlag");//其他标识字段
        String[] prpLdangerBusinessProvince = httpServletRequest.getParameterValues("prpLdangerBusinessProvince");//归属区域省
        String[] prpLdangerBusinessTown = httpServletRequest.getParameterValues("prpLdangerBusinessTown");//归属区域市
        String[] prpLdangerBusinessCounty = httpServletRequest.getParameterValues("prpLdangerBusinessCounty");//归属区域县
        String[] prpLdangerBusinessAreaName = httpServletRequest.getParameterValues("prpLdangerBusinessAreaName");//归属区域乡镇
        //1、生成此赔款危险单位标的prpLdangerItem
        if (prpLdangerCurrency == null) {
 			
 		} else {
 			PrpLdangerItemDto prpLdangerItemNewDto=null;
 		    for (int index = 1; index < prpLdangerCurrency.length; index++) {
 		    	
 		    	prpLdangerItemNewDto = new PrpLdangerItemDto();      
 				prpLdangerItemNewDto.setCertiNo(prpLdangerCompensateNo); 
 				prpLdangerItemNewDto.setDangerNo(Integer.parseInt(prpLdangerDangerNo[index])); 
 				prpLdangerItemNewDto.setCurrency(prpLdangerCurrency[index]); 
 				prpLdangerItemNewDto.setKindFlag("0"); // 险别归类标志,0表示正常
 				prpLdangerItemNewDto.setKindCode(prpLdangerKindcode[index]); 
 				prpLdangerItemNewDto.setKindName(prpLdangerKindname[index]);  
 				prpLdangerItemNewDto.setRiskCode(prpLdangerRiskCode[index]); 
 				prpLdangerItemNewDto.setAddressName(prpLdangerAddressName[index]);
 				prpLdangerItemNewDto.setPolicyno(prpLdangerPolicyNo[index]);
 				prpLdangerItemNewDto.setDangerdesc(prpLdangerUnitDesc[index]);
 				prpLdangerItemNewDto.setItemcode(prpLdangerItemCode[index]);
 				prpLdangerItemNewDto.setItemname(prpLdangerItemName[index]);
 			
 				
 				//占比最后一个减法原则
 				flag=true;
 	                for(int i=index+1;i<prpLdangerCurrency.length;i++){
 	             
    	               	 if(prpLdangerUnitItemKindNo[index].equals(prpLdangerUnitItemKindNo[i])){
   	     	              		 flag=false;
   	     	               }
    	                   
 	                }
 	                   if(flag){
 	                	  temp=0;
 	               		for(int k=1;k<index;k++){
	 	              
	    	               		 if(prpLdangerUnitItemKindNo[k].equals(prpLdangerUnitItemKindNo[index])){
	   	                    	  temp+=Str.round(Double.parseDouble(prpLdangerShare[k]),2);
	   	               		     }
		               		 
 	               		}
 	                    	prpLdangerItemNewDto.setDangerKindShare(Str.round(100-temp,2));
 	                   }else{
 	                	    prpLdangerItemNewDto.setDangerKindShare(Double.parseDouble(prpLdangerShare[index]));
 	                   }
 	                  isfee = false; //是否有费用，如果有则拆分到对应的险别代码和标的代码
 	                  if(prpLchargeList != null && prpLchargeList.size()>0){
 	                	 lchargeDto = new PrpLchargeDto();
 	                	 for(int c=0;c<prpLchargeList.size();c++){
 	                		lchargeDto = (PrpLchargeDto) prpLchargeList.get(c);
 	                		if(lchargeDto.getKindCode().equals(prpLdangerKindcode[index])){
 	                			isfee = true;
 	     	           			break;
 	                		}
    	                  }
 	                  }
 	                  if(isfee){
 	                	 prpLdangerItemNewDto.setSumFee(Str.round((lchargeDto.getChargeAmount()-lchargeDto.getSumRealPay()),2));
 	                	 prpLdangerItemNewDto.setSumPaid(Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2)); 
 	                  }else{
 	                	 prpLdangerItemNewDto.setSumPaid(Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2)); 
 	                  }
 	                 prpLdangerItemNewDto.setSerialNo(Integer.parseInt(prpLdangerUnitItemKindNo[index])); // 标的序号
 				
 				sumDangerUnit+=Str.round(Double.parseDouble(prpLdangerUnitSumLoss[index]),2);
 				 //加入集合
               	 if(prpLdangerItemNewDto!=null){
               		 dangerItemList.add(prpLdangerItemNewDto);
               	 }
 			}
 		    
 		    if(dangerItemList.size()>0){
              	compensateDto.setPrpLprpLdangerItemList(dangerItemList);
            }
 		}
        
        //2、生成此危险单位标金额合计PrpLdangerTot（汇总prpLdangerItem）
        
        Iterator     iterator   = null;
        PrpLdangerTotDto prpLdangerTotNewDto   = null; 
        Iterator      itTot  = null;
 		PrpLdangerItemDto prpLdangerItemNewDto = null;       //标的DTO
        boolean find = true;
        if (dangerItemList  != null){
        	iterator = dangerItemList.iterator();
        	while(iterator.hasNext()){
        		prpLdangerItemNewDto = (PrpLdangerItemDto)iterator.next();
        		find = false;
        		itTot = dangerTotList.iterator();
        		while(itTot.hasNext())
        		{
        			prpLdangerTotNewDto = (PrpLdangerTotDto)itTot.next();
        			if (prpLdangerTotNewDto.getDangerNo() == prpLdangerItemNewDto.getDangerNo())
        			{
        				find = true;
        				prpLdangerTotNewDto.setSumPaid(Str.round(prpLdangerTotNewDto.getSumPaid()+prpLdangerItemNewDto.getSumPaid(),2));
        				prpLdangerTotNewDto.setSumPaidEx(Str.round(prpLdangerTotNewDto.getSumPaidEx()+prpLdangerItemNewDto.getSumPaid(),2));
        				prpLdangerTotNewDto.setSumFee(Str.round(prpLdangerTotNewDto.getSumFee()+prpLdangerItemNewDto.getSumFee(),2));
        				prpLdangerTotNewDto.setSumFeeEx(Str.round(prpLdangerTotNewDto.getSumFeeEx()+prpLdangerItemNewDto.getSumFee(),2));
        				break;
        			}
        		}
        		//每个危险单位标的的第一次数据的生成
        		if (find == false)
        		{
        			prpLdangerTotNewDto = new PrpLdangerTotDto();
                    
        			prpLdangerTotNewDto.setCertiNo(prpLdangerCompensateNo);
        			prpLdangerTotNewDto.setDangerNo(prpLdangerItemNewDto.getDangerNo());                        
        			prpLdangerTotNewDto.setSCurrency(prpLdangerItemNewDto.getCurrency());   //标的原币别
        			prpLdangerTotNewDto.setSumFee(prpLdangerItemNewDto.getSumFee());
        			prpLdangerTotNewDto.setSumPaid(prpLdangerItemNewDto.getSumPaid());
        			prpLdangerTotNewDto.setTCurrency(prpLdangerItemNewDto.getCurrency());
        			prpLdangerTotNewDto.setExchRate(1);
        			prpLdangerTotNewDto.setSumFeeEx(prpLdangerItemNewDto.getSumFee());
        			prpLdangerTotNewDto.setSumPaidEx(prpLdangerItemNewDto.getSumPaid());
    		  	 	 //加入集合
                	 if(prpLdangerTotNewDto!=null){
                		dangerTotList.add(prpLdangerTotNewDto);
                	 }
            		
        		}
          
        	}

        	  if(dangerTotList.size()>0){
        		  compensateDto.setPrpLprpLdangerTotList(dangerTotList);
              }
        }
        
        //3、生成危险单位prpLdangerUnit
        com.sinosoft.prpall.dbsvr.lp.DBPrpLdangerUnit dbPrpLdangerUnit = null ;
        Iterator      itUnit  = null;
        PrpLdangerUnitDto prpLdangerUnitNewDto=null;
        if (dangerItemList != null){
        	iterator = dangerItemList.iterator();
        	while(iterator.hasNext()){
        		prpLdangerItemNewDto = (PrpLdangerItemDto)iterator.next();
        		find = false;
        		itUnit = dangerUnitList.iterator();
        		while(itUnit.hasNext())
        		{
        			prpLdangerUnitNewDto = (PrpLdangerUnitDto)itUnit.next();
        			if (prpLdangerUnitNewDto.getDangerNo() == prpLdangerItemNewDto.getDangerNo())
        			{
        				find = true;
        				prpLdangerUnitNewDto.setSumPaid(Str.round(prpLdangerUnitNewDto.getSumPaid()+prpLdangerItemNewDto.getSumPaid(),2));
        				prpLdangerUnitNewDto.setSumFee(Str.round(prpLdangerUnitNewDto.getSumFee()+prpLdangerItemNewDto.getSumFee(),2));
        				prpLdangerUnitNewDto.setSumNoPaid(prpLdangerUnitNewDto.getSumPaid()-prpLdangerUnitNewDto.getSumFee());
        				break;
        			}
        		}
        		
        		//每个危险单位标的的第一次数据的生成
        		if (find == false)
        		{
                	
        			 prpLdangerUnitNewDto = new PrpLdangerUnitDto();
        			 prpLdangerUnitNewDto.setCertiNo(prpLdangerCompensateNo);
        			 prpLdangerUnitNewDto.setClaimNo(compensateDto.getPrpLcompensateDto().getClaimNo());
                	 prpLdangerUnitNewDto.setCertiType("3");
                	 prpLdangerUnitNewDto.setRiskCode(prpLdangerItemNewDto.getRiskCode());
                	 prpLdangerUnitNewDto.setPolicyNo(prpLdangerItemNewDto.getPolicyno());
                	 prpLdangerUnitNewDto.setDangerNo(prpLdangerItemNewDto.getDangerNo());
                	 prpLdangerUnitNewDto.setDangerDesc(prpLdangerItemNewDto.getDangerdesc());
                	 prpLdangerUnitNewDto.setAddressName(prpLdangerItemNewDto.getAddressName());
                	 prpLdangerUnitNewDto.setCurrency(prpLdangerItemNewDto.getCurrency());
                	 prpLdangerUnitNewDto.setSumPaid(prpLdangerItemNewDto.getSumPaid());
                	 prpLdangerUnitNewDto.setSumFee(prpLdangerItemNewDto.getSumFee());
                	 dbPrpLdangerUnit = new com.sinosoft.prpall.dbsvr.lp.DBPrpLdangerUnit();
 					 dbPrpLdangerUnit.getInfo(compensateDto.getPrpLcompensateDto().getCaseNo(), ""+prpLdangerUnitNewDto.getDangerNo());
 					if(!"".equals(dbPrpLdangerUnit.getSumLoss()) && !"".equals(prpLdangerItemNewDto.getSumPaid())){
						prpLdangerUnitNewDto.setSumNoPaid(Double.parseDouble(dbPrpLdangerUnit.getSumLoss()) - prpLdangerItemNewDto.getSumPaid());
					}
                	 prpLdangerUnitNewDto.setCoinsFlag(strCoinsFlag);
                	 prpLdangerUnitNewDto.setDamageDate(compensateDto.getPrpLcompensateDto().getDamageStartDate());
              	    // prpLdangerUnitNewDto.setAgricultureflag(prpCmainDto.getBusinessType1());
                	 prpLdangerUnitNewDto.setBusinessNature(prpLdangerBusinessNature[1]);
                	 prpLdangerUnitNewDto.setPolicyBizType(prpLdangerPolicyBizType[1]);
                	 prpLdangerUnitNewDto.setPolicyType(prpLdangerPolicyType[1]);
                	 prpLdangerUnitNewDto.setBusinessType(prpLdangerBusinessType[1]);
                	 prpLdangerUnitNewDto.setBusinessType1(prpLdangerBusinessType1[1]);
                	 prpLdangerUnitNewDto.setOthFlag(prpLdangerOthFlag[1]);
                	 prpLdangerUnitNewDto.setBusinessProvince(prpLdangerBusinessProvince[1]);
                	 prpLdangerUnitNewDto.setBusinessTown(prpLdangerBusinessTown[1]);
                	 prpLdangerUnitNewDto.setBusinessCounty(prpLdangerBusinessCounty[1]);
                	 prpLdangerUnitNewDto.setBusinessAreaName(prpLdangerBusinessAreaName[1]);
              	    //加入集合
                	 if(prpLdangerUnitNewDto!=null){
                		dangerUnitList.add(prpLdangerUnitNewDto);
                	 }
                  }
        		
        	}
        	//最后一个占比减法原则
        	double dangerShare = 0;
        	double tempSumDangerShare = 0;
        	  ClaimDto claimDto = new ClaimDto();
      	     UIClaimAction uiclaimAction= new UIClaimAction();
      	     claimDto = uiclaimAction.findByPrimaryKey(compensateDto.getPrpLcompensateDto().getClaimNo());
      	     double tempSumLoss=0;
      	     double temSumFee=0;
      	     double sumTempSumLoss=0;
      	     double tempSumNoPaid=0;
      	     double sumTempNoPaid=0;
      	     PrpLdangerUnitDto prpLdangerUnitDtotemp=null;
        	for (int i=0;i<dangerUnitList.size();i++){
        		 prpLdangerUnitDtotemp=(PrpLdangerUnitDto)dangerUnitList.get(i);
	        		if(i==(dangerUnitList.size()-1))
	        		{
	        			dangerShare = Str.round(100-tempSumDangerShare,2);
	        			tempSumNoPaid = Str.round(claimDto.getPrpLclaimDto().getSumClaim()-claimDto.getPrpLclaimDto().getSumPaid()-sumTempNoPaid,2);
	        		    tempSumLoss = Str.round(claimDto.getPrpLclaimDto().getSumClaim()-sumTempSumLoss,2);
	        		    temSumFee = Str.round(prpLdangerUnitDtotemp.getSumFee()*dangerShare/100,2);
	        		}else
	        		{
	        			dangerShare = Str.round(prpLdangerUnitDtotemp.getSumPaid()/sumDangerUnit*100,2);
	        			tempSumDangerShare = Str.round(tempSumDangerShare+dangerShare, 2);
	        			tempSumNoPaid = Str.round((claimDto.getPrpLclaimDto().getSumClaim()-claimDto.getPrpLclaimDto().getSumPaid())*dangerShare/100,2);
	        			sumTempNoPaid = Str.round(sumTempSumLoss+tempSumLoss, 2);
	        			tempSumLoss = Str.round(claimDto.getPrpLclaimDto().getSumClaim()*dangerShare/100,2);
	        			sumTempSumLoss = Str.round(sumTempSumLoss+tempSumLoss, 2);
	        			temSumFee = Str.round(prpLdangerUnitDtotemp.getSumFee()*dangerShare/100,2);
	        		}
	        		prpLdangerUnitDtotemp.setDangerShare(dangerShare);
	       			prpLdangerUnitDtotemp.setClaimDate(claimDto.getPrpLclaimDto().getClaimDate());
	       			prpLdangerUnitDtotemp.setSumLoss(tempSumLoss);
	       			prpLdangerUnitDtotemp.setSumFee(temSumFee);
	       			 if("1".equals(prpLcompensateFinallyFlag)){
		            	 prpLdangerUnitDtotemp.setSumNoPaid(0);  //结案  未决赔款置零
		          	 }else{
		          	   prpLdangerUnitDtotemp.setSumNoPaid(tempSumNoPaid);
		        	   prpLdangerUnitDtotemp.setSumNoPaid(Str.round(prpLdangerUnitDtotemp.getSumNoPaid()-compensateDto.getPrpLcompensateDto().getSumThisPaid(),2));
		          	 }
	       			
 	       	 }
           	 
 	        	 if(dangerUnitList.size()>0){
 	        		compensateDto.setPrplRiskUnitDtoList(dangerUnitList);
 	             }
 	        }
        
       //******---------------------危险单位信息 国元项目组   end------------------------------------*/
     }
		
        
		//add by qinyongli 2006-01-12 begin 加入对车险免赔额的收集
		ArrayList dedutibleList = new ArrayList();
		PrpLdeductibleDto prpLdeductibleDto = new PrpLdeductibleDto();
		//String PrpLDeductible = httpServletRequest.getParameter("prpLDeductible");
		prpLdeductibleDto.setClaimNo(compensateDto.getPrpLcompensateDto().getClaimNo());
		prpLdeductibleDto.setCompensateNo(compensateDto.getPrpLcompensateDto().getCompensateNo());
		prpLdeductibleDto.setCurrency(compensateDto.getPrpLcompensateDto().getCurrency());
		prpLdeductibleDto.setDeductible(Str.chgStrZero(prpLDeductible));
		prpLdeductibleDto.setSerialNo("1");
		prpLdeductibleDto.setDeductibleLevel("21");
		dedutibleList.add(prpLdeductibleDto);
		compensateDto.setPrpLdeductibleList(dedutibleList);
		//第一位：0-保单 1-赔付类型  2-险别  3-赔付项目；第二位0-默认不区分 1-物损 2-人损）

		// end------------------------------------*/
		return compensateDto;

	}

	/**
	 * 取初始化信息需要的数据的整理. 填写实赔单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参，
	 * 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。
	 * 
	 * @param httpServletRequest
	 * @return compensateDto 取初始化信息需要的数据
	 * @throws Exception
	 */
	public CompensateDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception {
		CompensateDto compensateDto = new CompensateDto();
		return compensateDto;
	}

	/**
	 * 填写实赔页面及查询实赔request的生成.
	 * 填写实赔时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param proposalIniDto
	 *            取出的初始化信息Dto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest, CompensateDto compensateDto) throws Exception {
		// 得到request的PrpLcompensateForm用于显示
		PrpLcompensateDto prpLcompensateDto = compensateDto.getPrpLcompensateDto();
		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);
	}

	/**
	 * 根据赔款计算书号查询预赔信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param compensateNo
	 *            赔款计算书号
	 * @throws Exception
	 */

	public void compensateDtoView(HttpServletRequest httpServletRequest, String compensateNo, String editType)
			throws Exception {
		// 特殊赔案标志,从工作流上获得。
		String caseType = httpServletRequest.getParameter("caseType");
		UICompensateAction uiCompensateAction = new UICompensateAction();
		CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(compensateNo, caseType);
		PolicyDto policyDto=null;
		// 赔款计算书主信息
		PrpLcompensateDto prpLcompensateDto = compensateDto.getPrpLcompensateDto();
		prpLcompensateDto.setEditType(editType.trim());

		//add by miaowenjun 20070130 显示的时候去掉间接理赔费用 start
	        double sumPaid = 0d;
	        double sumDutyPaid = 0d;
	        double sumThisPaid = 0d;
	        sumPaid  = prpLcompensateDto.getSumPaid();
	        sumDutyPaid = prpLcompensateDto.getSumDutyPaid();
	        sumThisPaid = prpLcompensateDto.getSumThisPaid();
	        for (Iterator iter = compensateDto.getPrpLchargeDtoList().iterator(); iter.hasNext();) {
				PrpLchargeDto prpLchargeDto = (PrpLchargeDto) iter.next();
				if("28".equals(prpLchargeDto.getChargeCode())){
					sumPaid -= prpLchargeDto.getChargeAmount();
					sumDutyPaid -= prpLchargeDto.getChargeAmount();
					sumThisPaid -= prpLchargeDto.getChargeAmount();
				}
			}
	        prpLcompensateDto.setSumPaid(sumPaid);
	        prpLcompensateDto.setSumDutyPaid(sumDutyPaid);
	        prpLcompensateDto.setSumThisPaid(sumThisPaid);
	        compensateDto.setPrpLcompensateDto(prpLcompensateDto);
        //add by miaowenjun 20070130 显示的时候去掉间接理赔费用 end
		
		// add by huangyunzhong 20051128 得到是否重开赔案
		String claimNo = prpLcompensateDto.getClaimNo().trim();
		int recount = 0;
		ReCaseDto reCaseDto = new ReCaseDto();
		PrpLrecaseDto prpLrecaseDto = new PrpLrecaseDto();
		// 查询重开赔案信息
		UIRecaseAction uiRecaseAction = new UIRecaseAction();
		reCaseDto = uiRecaseAction.findByPrimaryKey(claimNo, 1);
		prpLrecaseDto = reCaseDto.getPrpLrecaseDto();
		if (prpLrecaseDto != null && prpLrecaseDto.getClaimNo() != null
				&& prpLrecaseDto.getClaimNo().trim().length() > 0) {
			recount = 1;
			httpServletRequest.setAttribute("recaseFlag", String.valueOf(recount));
		}
		httpServletRequest.setAttribute("recaseFlag", String.valueOf(recount));
		// add end huangyunzhong 20051128

		// 设置实赔操作的状态为 案件修改 (正处理任务)
		if (compensateDto.getPrpLclaimStatusDto() != null) {
			// 设置初始化的内容
			prpLcompensateDto = compensateDto.getPrpLcompensateDto();

			if (compensateDto.getPrpLclaimStatusDto().getStatus().equals("7"))
				compensateDto.getPrpLclaimStatusDto().setStatus("3");
			prpLcompensateDto.setStatus(compensateDto.getPrpLclaimStatusDto().getStatus());
		} else {
			// 已提交，已经处理完毕的状态
			prpLcompensateDto.setStatus("4");
		}
		String status = httpServletRequest.getParameter("status");// 从工作流上去状态

		// add bu liuyanmei start 20051219 reason:在理算环节如果是核赔退回的单子，必须显示退回原因
		if (status != null && !status.equals("")) {
			if (status.equals("3")) {
				String flowId = httpServletRequest.getParameter("swfLogFlowID");
				int logNo = Integer.parseInt(httpServletRequest.getParameter("swfLogLogNo")) - 1; // 传过来的logNo是最大加了1，所以减掉
				SwfNotionDto swfNotionDto = new SwfNotionDto();

				UISwfNotionAction uiUwNotionAction = new UISwfNotionAction();
				swfNotionDto = uiUwNotionAction.findByPrimaryKey(flowId, logNo, 1);
				httpServletRequest.setAttribute("swfNotionDto", swfNotionDto);
			}
		}
		// add bu liuyanmei end 20051219 reason:在理算环节如果是核赔退回的单子，必须显示退回原因

		if (status != null && !status.equals(""))
			prpLcompensateDto.setStatus(status);
		if (!compensateDto.getPrpLcompensateDto().getPolicyNo().equals("")) {
			// 查询保单信息
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			// 根据出险日期还原保单信息
			// PolicyDto policyDto =
			// endorseViewHelper.findForEndorBefore(compensateDto.getPrpLcompensateDto().getPolicyNo());
			   policyDto= endorseViewHelper.findForEndorBefore(compensateDto.getPrpLcompensateDto()
					.getPolicyNo(), compensateDto.getPrpLcompensateDto().getDamageStartDate().toString(), compensateDto
					.getPrpLcompensateDto().getDamageStartHour());
			// 将险别信息压到页面上
			ArrayList damageKindList = policyDto.getPrpCitemKindDtoList();
			httpServletRequest.setAttribute("damageKindList", damageKindList);

			PrpCitemCarDto PrpCitemCarDto = new PrpCitemCarDto();
			httpServletRequest.setAttribute("prpCitemKindList", policyDto.getPrpCitemKindDtoList());
			/**
			 * 获得保单默认的险别
			 */
			String defaultKindCode = new DAAClaimViewHelper().getDefaultKindCodeByPolicyDto(policyDto);
			httpServletRequest.setAttribute("defaultKindCode", defaultKindCode);

			if (policyDto.getPrpCitemCarDtoList().size() > 0) {
				// 对车型等信息的支持
				PrpCitemCarDto = (PrpCitemCarDto) policyDto.getPrpCitemCarDtoList().get(0);
				prpLcompensateDto.setClauseType(PrpCitemCarDto.getClauseType());
				prpLcompensateDto.setLicenseNo(PrpCitemCarDto.getLicenseNo());
				prpLcompensateDto.setLicenseColorCode(PrpCitemCarDto.getLicenseColorCode());
				prpLcompensateDto.setLicenseColorCode(PrpCitemCarDto.getLicenseColorCode());
				prpLcompensateDto.setBrandName(PrpCitemCarDto.getBrandName());
				prpLcompensateDto.setCarKindCode(PrpCitemCarDto.getCarKindCode());
				prpLcompensateDto.setEngineNo(PrpCitemCarDto.getEngineNo());
				prpLcompensateDto.setFrameNo(PrpCitemCarDto.getFrameNo());
				prpLcompensateDto.setClauseTypeCode(PrpCitemCarDto.getClauseType());// dododo
				prpLcompensateDto.setPurchasePrice(String.valueOf(PrpCitemCarDto.getPurchasePrice()));				
 				BLPrpDcarModelNew blprpDcarModelNew = new BLPrpDcarModelNew();
				blprpDcarModelNew.getData(PrpCitemCarDto.getModelCode());
				//取得新车购置价
				if(blprpDcarModelNew.getSize() > 0){
					httpServletRequest.setAttribute("currentPurchasePrice", blprpDcarModelNew.getArr(0).getPurchasePrice());
				}else{
					httpServletRequest.setAttribute("currentPurchasePrice", "未查询到相关信息");
				}

			}
		}

		ClaimDto claimDto = null;
		// add by liubvo 20040601
		if (!compensateDto.getPrpLcompensateDto().getClaimNo().equals("")) {
			// 查询保单信息
			UIClaimAction uiClaimAction = new UIClaimAction();
			claimDto = uiClaimAction.findByPrimaryKey(compensateDto.getPrpLcompensateDto().getClaimNo());
			// 得到人伤个数
			Collection prplpersonTraceList = claimDto.getPrpLpersonTraceDtoList();
			int personCount = prplpersonTraceList.size();
			httpServletRequest.setAttribute("personCount", String.valueOf(personCount));
			PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
			prpLclaimDto = claimDto.getPrpLclaimDto();
			prpLcompensateDto.setDamageStartDate(prpLclaimDto.getDamageStartDate());
			if(prpLcompensateDto.getIndemnityDuty() == null || "".equals(prpLcompensateDto.getIndemnityDuty())){
				prpLcompensateDto.setIndemnityDuty(prpLclaimDto.getIndemnityDuty());// dododo
			}			
			prpLcompensateDto.setEscapeFlag(prpLclaimDto.getEscapeFlag());// dododo
			// prpLcompensateDto.setDamageStartHour(prpLclaimDto.getDamageStartHour());
			String timeTemp = StringConvert.toStandardTime(claimDto.getPrpLclaimDto().getDamageStartHour());
			prpLcompensateDto.setClaimType(compensateDto.getPrpLcompensateDto().getClaimType());
			prpLcompensateDto.setDamageStartHour(timeTemp.substring(0, 2));
			prpLcompensateDto.setDamageStartMinute(timeTemp.substring(3, 5));
			prpLcompensateDto.setStartDate(prpLclaimDto.getStartDate());
			prpLcompensateDto.setEndDate(prpLclaimDto.getEndDate());
			prpLcompensateDto.setDamageAddress(prpLclaimDto.getDamageAddress());
			prpLcompensateDto.setSumClaim(prpLclaimDto.getSumClaim());
			prpLcompensateDto.setSumAmount(prpLclaimDto.getSumAmount());
			prpLcompensateDto.setInsuredName(prpLclaimDto.getInsuredName());
			prpLcompensateDto.setInsuredCode(prpLclaimDto.getInsuredCode());
			prpLcompensateDto.setSumPaidAll(prpLclaimDto.getSumPaid());
			// 添加是否有赔偿信息
			if (claimDto.getPrpLclaimDto().getReplevyFlag().equals("1")) {
				prpLcompensateDto.setReplevyFlag("是");
			} else {
				prpLcompensateDto.setReplevyFlag("否");
			}
		}
		// 摘要的信息
		PrpLctextDto prpLctextDto = new PrpLctextDto();
		String tempContext = "";
		if (compensateDto.getPrpLctextDtoDtoList() != null) {
			Iterator iterator = compensateDto.getPrpLctextDtoDtoList().iterator();
			while (iterator.hasNext()) {
				PrpLctextDto prpLctextDtoTemp = (PrpLctextDto) iterator.next();
				tempContext = tempContext + prpLctextDtoTemp.getContext();
			}
		}
		prpLctextDto.setContext(tempContext);
		prpLctextDto.setTextType("1");
		httpServletRequest.setAttribute("prpLctextDto", prpLctextDto);

		// 设置相关代码的中文转换
		changeCodeToName(httpServletRequest, prpLcompensateDto);

		UICodeAction uiCodeAction = new UICodeAction();
		if (compensateDto.getPrpLlossDtoList() != null) {
			for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
				PrpLlossDto prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
				prpLlossDto.setKindName(uiCodeAction.translateKindCode("KindCode", prpLlossDto.getKindCode(), true));
				prpLlossDto.setCurrency2Name(uiCodeAction.translateCurrencyCode(prpLlossDto.getCurrency2(), true));
			}
		}
		
		
		// //BLPrpCitemKind 承保保单中的内容以及免赔率等东西 modify by miaowenjun 20060607
		
		//add by miaowenjun 免赔条件
		List prpDCodeList = (ArrayList)uiCodeAction.getDeductCondition(prpLcompensateDto.getRiskCode());
		ArrayList prpLdeductCondDtoList = new ArrayList(); 
		prpLdeductCondDtoList = (ArrayList)UILdeductCondAction.getInstance().findByConditions(prpLcompensateDto.getCompensateNo());
		PrpLdeductCondDto prpLdeductCondDto = new PrpLdeductCondDto();
		prpLdeductCondDto.setCompensateNo("");
		prpLdeductCondDto.setDeductCondCode("");
		prpLdeductCondDto.setDeductCondName("");
		prpLdeductCondDto.setTimes(0);
		int count = prpDCodeList.size()-prpLdeductCondDtoList.size();
		for(int i=0;i<count;i++){
			prpLdeductCondDtoList.add(prpLdeductCondDto);
		}
		prpLcompensateDto.setPrpLdeductCondDtoList(prpLdeductCondDtoList);
		getLossInfo(httpServletRequest, prpLcompensateDto);
		
		
		// 设置窗体表单中各个多选框中列表信息的内容
		setSelectionList(httpServletRequest, prpLcompensateDto);
		// 查询相同保单号的出险次数
		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
		dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest, prpLcompensateDto.getPolicyNo(), claimDto
				.getPrpLclaimDto().getRegistNo());

		httpServletRequest.setAttribute("prpLqualityCheckList", compensateDto.getPrpLqualityCheckList());
		// 设置主实赔信息内容到窗体表单
		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);
		httpServletRequest.setAttribute("prpLclaimDto", claimDto.getPrpLclaimDto());  
		httpServletRequest.setAttribute("prpLcomRepairBillList", compensateDto.getPrpLcomRepairBillDtoList());
		// 设置各个子表信息项到窗体表单
		setSubInfo(httpServletRequest, compensateDto);
		
		    PubTools pubTools=new PubTools();
		    int time= pubTools.compareDate(policyDto.getPrpCmainDto().getInputDate().toString(),"2011-02-27");
		    if(time<0){
		    	// add by qinyongli start 2005-8-16
				// reason:获取危险单位信息
				UIRiskUnitAction uiRiskUnitAction = new UIRiskUnitAction();
				PrpLdangerUnitDto prpLdangerUnitDto = uiRiskUnitAction.findByPrimaryKeyFromPrpLdangerUnit(compensateNo, 1,
						httpServletRequest, prpLcompensateDto.getRiskCode(),0);
				if (prpLdangerUnitDto == null) {
					// add by caopeng start 2006-1-9
					prpLdangerUnitDto = uiRiskUnitAction.findByPrimaryKeyFromPrpLdangerUnit(claimNo, 1, httpServletRequest,
							prpLcompensateDto.getRiskCode(),0);
					if (prpLdangerUnitDto == null) {
						// add by caopeng end 2006-1-9
						prpLdangerUnitDto = new PrpLdangerUnitDto();
						prpLdangerUnitDto.setCurrency(compensateDto.getPrpLclaimDto().getCurrency()); // 解决危险单位中的币别不显示问题
					}
				}
				prpLdangerUnitDto.setRiskLevelDesc(uiCodeAction.translateCurrencyCode(prpLdangerUnitDto.getCurrency(), true)); // 用此字段表示币别中文信息
				httpServletRequest.setAttribute("prpLdangerUnitDto", prpLdangerUnitDto);
				// add by qinyongli end 2005-8-16
		    }else{
		    	 //******---------------------获取危险单位信息 国元项目组  start-----------------------------------*/
		        BLDangerUnitFacade blDangerFacade=new BLDangerUnitFacade();
		        List prpLdangerUnitList = new ArrayList();
		        prpLdangerUnitList=blDangerFacade.getPrpLdangerUnit(compensateNo);
		        httpServletRequest.setAttribute("prpLdangerUnitList", prpLdangerUnitList);
		        //******---------------------获取危险单位信息 国元项目组  end-----------------------------------*/
				
		    }
		
		// 结案报告 2005-07-20
		tempContext = "";
		if (compensateDto.getPrpLltextDtoList() != null) {
			Iterator iterator = compensateDto.getPrpLltextDtoList().iterator();
			while (iterator.hasNext()) {
				PrpLltextDto prpLltextDtoTemp = (PrpLltextDto) iterator.next();
				if (prpLltextDtoTemp.getTextType().equals("08")) {
					tempContext = tempContext + prpLltextDtoTemp.getContext();
				}
			}
		}
		PrpLltextDto prpLltextDto = new PrpLltextDto();
		prpLltextDto.setContext(tempContext);
		prpLltextDto.setTextType("08");
		httpServletRequest.setAttribute("prpLltextDto", prpLltextDto);
		
		ArrayList prpLnodutyLossList = new ArrayList();
		ArrayList prpLnodutyList = new ArrayList();
		ArrayList prpLnoInsList = new ArrayList();
		if(compensateDto.getPrpLnodutyLossDtoList() != null)
		{
			prpLnodutyLossList = (ArrayList)compensateDto.getPrpLnodutyLossDtoList();
			for(int i=0;i<prpLnodutyLossList.size();i++){
				PrpLnodutyLossDto prpLnodutyLossDto =(PrpLnodutyLossDto)prpLnodutyLossList.get(i);
				if(prpLnodutyLossDto.getPaidType().equals("noDuty")){
					prpLnodutyList.add(prpLnodutyLossDto);
				}else{
					prpLnoInsList.add(prpLnodutyLossDto);
				}	
			}			
		}
		httpServletRequest.setAttribute("prpLnodutyLossList", prpLnodutyList);
		httpServletRequest.setAttribute("prpLnoinsList", prpLnoInsList);
		httpServletRequest.setAttribute("prpLthirdPartyDtoList", (ArrayList)compensateDto.getPrpLthirdPartyDtoList());
	}

	
	
	/**
	 * 填写实赔页面及查询实赔request的生成.
	 * 填写实赔时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param PrpLcompensateDto
	 *            取出的初始化信息Dto
	 * @throws Exception
	 */
	// 重新设计
	public void claimDtoToView(HttpServletRequest httpServletRequest, String claimNo, String editType) throws Exception {
		UICodeAction uiCodeAction = UICodeAction.getInstance();
		
		
		// 特殊赔案标志
		String caseType = httpServletRequest.getParameter("caseType");// 特殊赔案标志
		UIClaimAction uiClaimAction = new UIClaimAction();
		ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
		// 得到人伤个数
		httpServletRequest.setAttribute("personCount", String.valueOf(claimDto.getPrpLpersonTraceDtoList().size()));

		// modify by wangwei add start 2005-06-10
		// 原因：要在界面上显示该保单的所有立案信息
		httpServletRequest.setAttribute("registClaimDtoList", uiClaimAction.findByPolicyNo(claimDto.getPrpLclaimDto()
				.getPolicyNo()));
		// modify by wangwei add end 2005-06-10

		// add by huangyunzhong 20051128 得到是否重开赔案
		int recount = 0;
		// 查询重开赔案信息
		ReCaseDto reCaseDto = new UIRecaseAction().findByPrimaryKey(claimNo, 1);
		PrpLrecaseDto prpLrecaseDto = reCaseDto.getPrpLrecaseDto();
		if (prpLrecaseDto != null && prpLrecaseDto.getClaimNo() != null
				&& prpLrecaseDto.getClaimNo().trim().length() > 0) {
			recount = 1;
		}
		httpServletRequest.setAttribute("recaseFlag", String.valueOf(recount));
		// add end huangyunzhong 20051128

		// 赔款计算书主信息
		PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();

		/*
		 * 设置赔案类型开始-----------------------------
		 */
		prpLcompensateDto.setCaseType(claimDto.getPrpLclaimDto().getCaseType());

		// 特殊赔案标志
		// 因为传过来的caseType="null"
		if (caseType != null && !caseType.equals("null")) {
			if (caseType.trim().equals("3") || caseType.trim().equals("4") || caseType.trim().equals("6")) {
				prpLcompensateDto.setCaseType(caseType);
			}
		} else {
			// 正常的流程，进行赔付
			prpLcompensateDto.setCaseType("2");
		}
		/*
		 * 设置赔案类型结束-------------------------------
		 */

		prpLcompensateDto.setCompensateNo(""); //计算书号
		prpLcompensateDto.setEditType(editType.trim());
		prpLcompensateDto.setLFlag(claimDto.getPrpLclaimDto().getLFlag());
		prpLcompensateDto.setCaseNo(claimDto.getPrpLclaimDto().getCaseNo());
		prpLcompensateDto.setTimes(1);
		prpLcompensateDto.setClaimType(claimDto.getPrpLclaimDto().getClaimType());
		prpLcompensateDto.setEscapeFlag(claimDto.getPrpLclaimDto().getEscapeFlag());
		prpLcompensateDto.setIndemnityDuty(claimDto.getPrpLclaimDto().getIndemnityDuty());
		prpLcompensateDto.setClassCode(claimDto.getPrpLclaimDto().getClassCode());
		prpLcompensateDto.setRiskCode(claimDto.getPrpLclaimDto().getRiskCode());
		prpLcompensateDto.setClaimNo(claimDto.getPrpLclaimDto().getClaimNo());
		prpLcompensateDto.setPolicyNo(claimDto.getPrpLclaimDto().getPolicyNo());
		prpLcompensateDto.setDeductCond(httpServletRequest.getParameter("DeductibleTerm")); //免赔条件
		prpLcompensateDto.setPreserveDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		prpLcompensateDto.setIndemnityDutyRate(claimDto.getPrpLclaimDto().getIndemnityDutyRate());
		prpLcompensateDto.setIndemnityDuty(claimDto.getPrpLclaimDto().getIndemnityDuty());
		prpLcompensateDto.setUnderWriteFlag("0");
		prpLcompensateDto.setSumPaidAll(claimDto.getPrpLclaimDto().getSumPaid());
		// add by qinyongli start 2005-7-25
		prpLcompensateDto.setBusinessNature(claimDto.getPrpLclaimDto().getBusinessNature());
		prpLcompensateDto.setDamageCode(claimDto.getPrpLclaimDto().getDamageCode());
		prpLcompensateDto.setDamageName(claimDto.getPrpLclaimDto().getDamageName());
		prpLcompensateDto.setUnderWriteFlag("0");
		// **************判断保费是否已经实收add by qinyongli 2005-7-21
		String conditions1 = " policyno = '" + prpLcompensateDto.getPolicyNo() + "'";
		int intReturn = 0;
		intReturn = UIPolicyAction.getInstance().checkPay(conditions1);// -1为未缴费，0为未缴全，1为缴全
		prpLcompensateDto.setPalyFlag(intReturn);

		// 获取系统设置信息
		// 获取保费未实收是否允许理算信息
		String configValue = UIConfigAction.getInstance().getConfigValue("ALLOW_UNPAYED_COMPENSATE",
				prpLcompensateDto.getRiskCode());
		if (configValue == null || configValue.equals("")) {
			throw new UserException(1, 3, "platform", "该险种未进行基础数据初始化，请在基础平台系统，险种配置中进行初始化！");
		}

		// 如果configValue =2 intReturn！=1则表示未交费不能立案
		if (configValue.equals("2") && intReturn != 1) {
			httpServletRequest.setAttribute("premiumFee", "0");// 0表示不允许理算提交
		} else {
			httpServletRequest.setAttribute("premiumFee", "1");// 0表示允许理算提交
		}
		// *******************************************add end

  		// 车险默认不自动结案,其他险种默认自动结案（国元需求）
		if(prpLcompensateDto.getClassCode().equals("05")) {
			prpLcompensateDto.setFinallyFlag("0");
		}else{
			prpLcompensateDto.setFinallyFlag("1");
		}

		if (claimDto.getPrpLclaimDto().getReplevyFlag().equals("1")) {
			prpLcompensateDto.setReplevyFlag("是");
		} else {
			prpLcompensateDto.setReplevyFlag("否");
		}
		prpLcompensateDto.setCurrency(claimDto.getPrpLclaimDto().getCurrency());
		prpLcompensateDto.setSumPaid(claimDto.getPrpLclaimDto().getSumPaid());
		prpLcompensateDto.setMakeCom(claimDto.getPrpLclaimDto().getMakeCom());
		prpLcompensateDto.setComCode(claimDto.getPrpLclaimDto().getComCode());
		UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
		prpLcompensateDto.setHandlerCode(user.getUserCode());
		prpLcompensateDto.setHandler1Code(claimDto.getPrpLclaimDto().getHandler1Code());
		prpLcompensateDto.setStatisticsYM(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		prpLcompensateDto.setOperatorCode(claimDto.getPrpLclaimDto().getOperatorCode());
		prpLcompensateDto.setInputDate(claimDto.getPrpLclaimDto().getInputDate());
		prpLcompensateDto.setUnderWriteEndDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		prpLcompensateDto.setRemark(claimDto.getPrpLclaimDto().getRemark());
		prpLcompensateDto.setFlag(claimDto.getPrpLclaimDto().getFlag());

		// 设置实赔操作的状态为 新案件登记 (未处理任务)
		prpLcompensateDto.setStatus("1");
		prpLcompensateDto.setInsuredCode(claimDto.getPrpLclaimDto().getInsuredCode());
		prpLcompensateDto.setInsuredName(claimDto.getPrpLclaimDto().getInsuredName());
		prpLcompensateDto.setStartDate(claimDto.getPrpLclaimDto().getStartDate());
		prpLcompensateDto.setStartHour(claimDto.getPrpLclaimDto().getStartHour());
		prpLcompensateDto.setEndDate(claimDto.getPrpLclaimDto().getEndDate());
		prpLcompensateDto.setEndHour(claimDto.getPrpLclaimDto().getEndHour());
		prpLcompensateDto.setClauseType(claimDto.getPrpLclaimDto().getClauseType());

		prpLcompensateDto.setDamageStartDate(claimDto.getPrpLclaimDto().getDamageStartDate());
		String timeTemp = StringConvert.toStandardTime(claimDto.getPrpLclaimDto().getDamageStartHour());
		prpLcompensateDto.setDamageStartHour(timeTemp.substring(0, 2));
		prpLcompensateDto.setDamageStartMinute(timeTemp.substring(3, 5));
		prpLcompensateDto.setDamageAddressType(claimDto.getPrpLclaimDto().getDamageAddressType());
		prpLcompensateDto.setDamageAddress(claimDto.getPrpLclaimDto().getDamageAddress());
		prpLcompensateDto.setSumAmount(claimDto.getPrpLclaimDto().getSumAmount());
		prpLcompensateDto.setSumPremium(claimDto.getPrpLclaimDto().getSumPremium());
		prpLcompensateDto.setSumClaim(claimDto.getPrpLclaimDto().getSumClaim());
		prpLcompensateDto.setHandlerName(claimDto.getPrpLclaimDto().getHandlerName());
		PolicyDto policyDto = new PolicyDto();
		if (!claimDto.getPrpLclaimDto().getPolicyNo().equals("")) {
			// 查询保单信息
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			// 根据出险日期还原保单信息
			policyDto = endorseViewHelper.findForEndorBefore(
					claimDto.getPrpLclaimDto().getPolicyNo(), 
					claimDto.getPrpLclaimDto().getDamageStartDate().toString(), 
					claimDto.getPrpLclaimDto().getDamageStartHour());

			// 将险别信息压到页面上
			ArrayList damageKindList = policyDto.getPrpCitemKindDtoList();
			httpServletRequest.setAttribute("damageKindList", damageKindList);

			PrpCitemCarDto PrpCitemCarDto = new PrpCitemCarDto();
			httpServletRequest.setAttribute("prpCitemKindList", policyDto.getPrpCitemKindDtoList());

			/**
			 * 获得保单默认的险别
			 */
			String defaultKindCode = new DAAClaimViewHelper().getDefaultKindCodeByPolicyDto(policyDto);
			httpServletRequest.setAttribute("defaultKindCode", defaultKindCode);

			if (policyDto.getPrpCitemCarDtoList().size() > 0) {

				// 对车型等信息的支持
				PrpCitemCarDto = (PrpCitemCarDto) policyDto.getPrpCitemCarDtoList().get(0);
				prpLcompensateDto.setClauseType(PrpCitemCarDto.getClauseType());
				prpLcompensateDto.setLicenseNo(PrpCitemCarDto.getLicenseNo());
				prpLcompensateDto.setClauseTypeCode(PrpCitemCarDto.getClauseType());
				prpLcompensateDto.setPurchasePrice(String.valueOf(PrpCitemCarDto.getPurchasePrice()));
				prpLcompensateDto.setLicenseColorCode(PrpCitemCarDto.getLicenseColorCode());
				prpLcompensateDto.setLicenseColorCode(PrpCitemCarDto.getLicenseColorCode());
				prpLcompensateDto.setBrandName(PrpCitemCarDto.getBrandName());
				prpLcompensateDto.setCarKindCode(PrpCitemCarDto.getCarKindCode());
				prpLcompensateDto.setEngineNo(PrpCitemCarDto.getEngineNo());
				prpLcompensateDto.setFrameNo(PrpCitemCarDto.getFrameNo());
				prpLcompensateDto.setSeatCount(String.valueOf(PrpCitemCarDto.getSeatCount()));				
 				BLPrpDcarModelNew blprpDcarModelNew = new BLPrpDcarModelNew();
				blprpDcarModelNew.getData(PrpCitemCarDto.getModelCode());
				//取得新车购置价
				if(blprpDcarModelNew.getSize() > 0){
					httpServletRequest.setAttribute("currentPurchasePrice", blprpDcarModelNew.getArr(0).getPurchasePrice());
				}else{
					httpServletRequest.setAttribute("currentPurchasePrice", "未查询到相关信息");
				}

			}
		}

		// add by qinyongli begin 2005-7-19
		// 得到共保和股东业务信息临分信息
		if (policyDto != null) {
			httpServletRequest.setAttribute("coinsFlag", policyDto.getPrpCmainDto().getCoinsFlag());
			httpServletRequest.setAttribute("shareHolderFlag", policyDto.getPrpCmainDto().getShareHolderFlag());
			String conditions = "reinsType in ('1','2')  and policyno = '" + claimDto.getPrpLclaimDto().getPolicyNo()
					+ "'";
			BLFcoRepolicyFacade blFcoRepolicyFacade = new BLFcoRepolicyFacade();
			ArrayList reins = (ArrayList) blFcoRepolicyFacade.findByConditions(conditions);
			if (reins != null && reins.size() > 0) {
				httpServletRequest.setAttribute("tempReinsFlag", "1");
			} else {
				httpServletRequest.setAttribute("tempReinsFlag", "0");
			}
		}
		// add by qinyongli end 2005-7-19

		// modify by luqin add 2005-06-30 start
		// reason: 默认带出查勘人
		if (!claimDto.getPrpLclaimDto().getRegistNo().equals("")) {
			UICheckAction uiCheckAction = new UICheckAction();
			CheckDto checkDto = uiCheckAction.findByPrimaryKey(claimDto.getPrpLclaimDto().getRegistNo());
			if (checkDto.getPrpLcheckDto() != null) {
				prpLcompensateDto.setChecker1(checkDto.getPrpLcheckDto().getChecker1());
			}
		}
		// modify by luqin add 20005-06-30 end
		// add by qinyongli start 2005-8-19
		// reason:获取危险单位信息
		PrpLdangerUnitDto prpLdangerUnitDto = new UIRiskUnitAction().findByPrimaryKeyFromPrpLdangerUnit(
				prpLcompensateDto.getClaimNo(), 
				1, 
				httpServletRequest, 
				prpLcompensateDto.getRiskCode(),0);
		if (prpLdangerUnitDto == null) {
			prpLdangerUnitDto = new PrpLdangerUnitDto();
		}
		prpLdangerUnitDto.setRiskLevelDesc(uiCodeAction.translateCurrencyCode(prpLdangerUnitDto.getCurrency(), true)); // 用此字段表示币别中文信息
		httpServletRequest.setAttribute("prpLdangerUnitDto", prpLdangerUnitDto);
		// add by qinyongli end 2005-8-19
		// 赋值初始的计算书Times信息
		String conditions = " ClaimNo= '" + claimNo + "'";
		UICompensateAction uiCompensateAction = new UICompensateAction();
		Collection prplCompensateListTemp = uiCompensateAction.findByConditions(conditions);
		if (prplCompensateListTemp != null) {
			prpLcompensateDto.setTimes(prplCompensateListTemp.size() + 1);
		} else {
			prpLcompensateDto.setTimes(1);
		}
		// 初始化人员信息（从定核损带过来）
		ArrayList personLossListTemp =this.initPersonLoss(httpServletRequest, claimNo, claimDto);
		double medicLimit=0;
		double deathLimit=0;
		double propLimit=0;
		String duty =prpLcompensateDto.getIndemnityDuty();
		String configCode =uiCodeAction.translateRiskCodetoConfigCode(claimDto.getPrpLclaimDto().getRiskCode());
		 //取强制保单限额----------------------------------------------
		
		if ("RISKCODE_DAZ".equals(configCode)||"RISKCODE_DAY".equals(configCode)||"RISKCODE_DAU".equals(configCode)){
			UIPrpClimitAction  uiPrpClimitAction =new UIPrpClimitAction(); 
			Collection limitList= uiPrpClimitAction.findByConditions(" policyNo='" +claimDto.getPrpLclaimDto().getPolicyNo() +"'");
			String limitType="";
			if ( limitList != null && limitList.size()>0){
				Iterator it =limitList.iterator();
				while (it.hasNext()){
					PrpClimitDto  prpClimitDto =(PrpClimitDto)it.next();
					if(!"4".equals(duty)){
						if("92".equals(prpClimitDto.getLimitType()) ){
						    propLimit =  prpClimitDto.getLimitFee()  ;	
						}
						if("91".equals(prpClimitDto.getLimitType()) ){
							medicLimit =  prpClimitDto.getLimitFee()  ;	
						}
						if("90".equals(prpClimitDto.getLimitType()) ){
							deathLimit =  prpClimitDto.getLimitFee()  ;	
						}
						
					}else {
						if("95".equals(prpClimitDto.getLimitType()) ){
						    propLimit =  prpClimitDto.getLimitFee()  ;	
						}
						if("94".equals(prpClimitDto.getLimitType()) ){
							medicLimit =  prpClimitDto.getLimitFee()  ;	
						}
						if("93".equals(prpClimitDto.getLimitType()) ){
							deathLimit =  prpClimitDto.getLimitFee()  ;	
						}
					}
				}
			}
		}
		
		BLPersonLossFacade blPersonLossFacade=	new  BLPersonLossFacade();
	    blPersonLossFacade.initPersonLoss(configCode,claimDto.getPrpLclaimDto().getRiskCode(),personLossListTemp,medicLimit,deathLimit);
		
		 
		
		// 初始化标的（从定核损带过来）
		ArrayList prpLlossListTemp = this.initLossItem(httpServletRequest, claimNo, claimDto);
		
		//对prpLlossListTemp进行 进一步初始化 ---------------------------
		double realPay = 0.00;
		if( "RISKCODE_DAZ".equals(configCode)||"RISKCODE_DAY".equals(configCode)||"RISKCODE_DAU".equals(configCode)){ //强制得核定赔偿 按费用优先级别赋值
			for (Iterator iterator = prpLlossListTemp.iterator(); iterator.hasNext();) {
				PrpLlossDto prpLlossDto = (PrpLlossDto) iterator.next();
				if ("BZ".equals( prpLlossDto.getKindCode())){	
					if(propLimit >=(prpLlossDto.getSumLoss()-prpLlossDto.getSumRest())){
						prpLlossDto.setSumDefPay(prpLlossDto.getSumLoss()-prpLlossDto.getSumRest());
						propLimit-= (prpLlossDto.getSumLoss()-prpLlossDto.getSumRest());
					}else if(propLimit>0){
						prpLlossDto.setSumDefPay(propLimit);
						propLimit = 0;						
					} else{
						prpLlossDto.setSumDefPay(0);
					}
					prpLlossDto.setSumRealPay(prpLlossDto.getSumDefPay());
				}	
			}
			
		}else if( "RISKCODE_DAY".equals(configCode)){  //0505核定赔偿设为零
			for (Iterator iterator = prpLlossListTemp.iterator(); iterator.hasNext();) {
				PrpLlossDto prpLlossDto = (PrpLlossDto) iterator.next();
				if ( "B".equals(prpLlossDto.getKindCode())){
					prpLlossDto.setSumDefPay(0);
				}else{
					prpLlossDto.setSumDefPay(prpLlossDto.getSumLoss()-prpLlossDto.getSumRest());
				}
				realPay = (prpLlossDto.getSumDefPay())
				* (prpLlossDto.getClaimRate() * 0.01) * (prpLlossDto.getIndemnityDutyRate() * 0.01)
				* (1 - (prpLlossDto.getDutyDeductibleRate() * 0.01))
				* (1 - (prpLlossDto.getDeductibleRate() * 0.01));
				prpLlossDto.setSumRealPay(realPay);
				
			}
		}else { //其他的车险 核定赔偿设为 核定损失-残值
			for (Iterator iterator = prpLlossListTemp.iterator(); iterator.hasNext();) {
				PrpLlossDto prpLlossDto = (PrpLlossDto) iterator.next();
				prpLlossDto.setSumDefPay(prpLlossDto.getSumLoss()-prpLlossDto.getSumRest());
				realPay = (prpLlossDto.getSumDefPay())
				* (prpLlossDto.getClaimRate() * 0.01) * (prpLlossDto.getIndemnityDutyRate() * 0.01)
				* (1 - (prpLlossDto.getDutyDeductibleRate() * 0.01))
				* (1 - (prpLlossDto.getDeductibleRate() * 0.01));
				prpLlossDto.setSumRealPay(realPay);
			}
		}
		//-------------------------------------
		
		
		// //BLPrpCitemKind 承保保单中的内容以及免赔率等东西
		// 重新设计
		//add by miaowenjun 免赔条件
		ArrayList deductConditionList = new ArrayList();
		//deductConditionList = (ArrayList)UIDeductCondAction.getInstance().getDeductCondList(httpServletRequest);

		prpLcompensateDto.setPrpLdeductCondDtoList(UIDeductCondAction.getInstance().getDeductCondList(httpServletRequest,false));
		
		getLossInfo(httpServletRequest, prpLcompensateDto);
		PrpLctextDto prpLctextDto = new PrpLctextDto();
		// 设值文本的内容
		httpServletRequest.setAttribute("prpLctextDto", prpLctextDto);

		// 设置结案信息 2005-07-20
		PrpLltextDto prpLltextDto = new PrpLltextDto();
		// add by lixiang start at 2006-1-25
		// reason:增加 结案报告的内容
		String strTemp = "";
		strTemp = "一、被保险人概况" + "\r\n";
		strTemp = strTemp + "二、事故经过及原因调查" + "\r\n";
		strTemp = strTemp + "三、认定责任" + "\r\n";
		strTemp = strTemp + "四、足额投保" + "\r";
		strTemp = strTemp + "五、是否存在重复投保及向第三者追偿前景" + "\r\n";
		strTemp = strTemp + "六、索赔及定损" + "\r\n";
		strTemp = strTemp + "七、总结和赔付";
		prpLltextDto.setContext(strTemp);
		prpLltextDto.setTextType("08");
		// add by lixiang end at 2006-1-25
		httpServletRequest.setAttribute("prpLltextDto", prpLltextDto);

		// 设置相关代码的中文转换
		changeCodeToName(httpServletRequest, prpLcompensateDto);
		// 设置窗体表单中各个多选框中列表信息的内容
		setSelectionList(httpServletRequest, prpLcompensateDto);
		// 查询相同保单号的出险次数
		// getSamePolicyRegistInfo(prpLcompensateDto);
		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
		dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest, prpLcompensateDto.getPolicyNo(), claimDto
				.getPrpLclaimDto().getRegistNo());

		// 设置主实赔信息内容到窗体表单
		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);
		// 设置各个子表信息项到窗体表单
		CompensateDto compensateDto = new CompensateDto();
		compensateDto.setPrpLcompensateDto(prpLcompensateDto);
		compensateDto = uiCompensateAction.findByAppendInformation(compensateDto);
		compensateDto.setPrpLpersonLossDtoList(personLossListTemp);
		compensateDto.setPrpLlossDtoList(prpLlossListTemp);

		// modify by luqin 2005-04-08 start
		// 缴费标志，判断保费是否交付
		String policyNo = prpLcompensateDto.getPolicyNo();
		int intPayFee = checkPay(httpServletRequest, policyNo);
		prpLcompensateDto.setPayFee(intPayFee);
		// modify by luqin 2005-04-08 end

		compensateDto.setPrpLcompensateDto(prpLcompensateDto);		
		String registNo = uiCodeAction.translateBusinessCode(prpLcompensateDto.getClaimNo(), false);
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		compensateDto.setPrpLregistExtDtoList(registDto.getPrpLregistExtDtoList());
		
		setSubInfo(httpServletRequest, compensateDto);
	}


	/**
	 * 根据compensateDto中的各子表内的信息填充界面
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param compensateDto
	 *            实赔的数据类
	 * @throws Exception
	 */
	private void setSubInfo(HttpServletRequest httpServletRequest, CompensateDto compensateDto) throws Exception {

		// 给报案信息补充说明多行列表准备数据
		Collection arrayListRegistExt = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = new PrpLregistExtDto();
		UICodeAction uiCodeAction = new UICodeAction();
		String registNo = uiCodeAction.translateBusinessCode(compensateDto.getPrpLcompensateDto().getClaimNo(), false);
		prpLregistExtDto.setRegistNo(registNo);
		prpLregistExtDto.setRiskCode(compensateDto.getPrpLcompensateDto().getRiskCode());
		arrayListRegistExt = compensateDto.getPrpLregistExtDtoList();
		prpLregistExtDto.setRegistExtList(arrayListRegistExt);
		httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);

		// 特别约定信息多行列表准备数据
		Collection arrayList = new ArrayList();
		PrpCengageDto prpCengageDto = new PrpCengageDto();
		arrayList = compensateDto.getPrpCengageDtoList();
		ArrayList cengageListTemp = new ArrayList();
		if (arrayList != null) {
			Iterator iteratorCengage = arrayList.iterator();
			while (iteratorCengage.hasNext()) {
				PrpCengageDto prpCengageDtoTemp = (PrpCengageDto) iteratorCengage.next();
				if (prpCengageDtoTemp.getClauseCode() != null && prpCengageDtoTemp.getClauseCode().length() > 0
						&& prpCengageDtoTemp.getClauseCode().charAt(0) == 'T') {
					cengageListTemp.add(prpCengageDtoTemp);
				}
			}
			boolean cFlag = false;
			arrayList = new ArrayList();
			arrayList.addAll(cengageListTemp);
			cengageListTemp = new ArrayList();
			iteratorCengage = arrayList.iterator();
			PrpCengageDto prpCengageDtoTemp1 = new PrpCengageDto();
			while (iteratorCengage.hasNext()) {
				PrpCengageDto prpCengageDtoTemp = (PrpCengageDto) iteratorCengage.next();
				if (prpCengageDtoTemp.getTitleFlag().equals("0")) {
					cFlag = true;
					cengageListTemp.add(prpCengageDtoTemp1);
					prpCengageDtoTemp1 = new PrpCengageDto();
					PropertyUtils.copyProperties(prpCengageDtoTemp1, prpCengageDtoTemp);
				} else {
					prpCengageDtoTemp1.setContext(prpCengageDtoTemp1.getContext() + prpCengageDtoTemp.getClauses()
							+ "<br>");
				}
			}
			cengageListTemp.add(prpCengageDtoTemp1);
			if (cengageListTemp.size() > 0) {
				cengageListTemp.remove(0);
			}
		}
		prpCengageDto.setPrpCengageList(cengageListTemp);

		httpServletRequest.setAttribute("prpCengageDto", prpCengageDto);

		// 赔偿限额/免赔额信息多行列表准备数据
		Collection arraylist4 = new ArrayList();
		PrpDlimitDto prpDlimitDto = new PrpDlimitDto();
		arraylist4 = compensateDto.getPrpDlimitDtoList();
		prpDlimitDto.setPrpDlimitList(arraylist4);
		httpServletRequest.setAttribute("prpDlimitDto", prpDlimitDto);

		// 货币代码的列表
		Collection collection = uiCodeAction.getCurrencyList();
		Iterator iterator = collection.iterator();
		HashMap currencyTemp = new HashMap();
		while (iterator.hasNext()) {
			PrpDcurrencyDto prpDcurrencyDto = (PrpDcurrencyDto) iterator.next();
			currencyTemp.put(prpDcurrencyDto.getCurrencyCode(), prpDcurrencyDto.getCurrencyCName());
		}

		// 赔偿限额/免赔额信息多行列表准备数据
		Collection arraylist5 = new ArrayList();
		PrpClimitDto prpClimitDto = new PrpClimitDto();
		arraylist5 = compensateDto.getPrpClimitDtoList();
		Iterator iPrpClimitTemp = arraylist5.iterator();
		while (iPrpClimitTemp.hasNext()) {
			PrpClimitDto prpClimitDtoTemp = (PrpClimitDto) iPrpClimitTemp.next();
			if (currencyTemp.containsKey(prpClimitDtoTemp.getCurrency())) {
				prpClimitDtoTemp.setCurrencyName(currencyTemp.get(prpClimitDtoTemp.getCurrency()).toString());
			}
			if (prpClimitDtoTemp.getLimitGrade().trim().equals("1"))
				prpClimitDtoTemp.setLimitGrade("保单");
			else
				prpClimitDtoTemp.setLimitGrade("标的险别");
			prpClimitDtoTemp.setLimitTypeName(uiCodeAction.translateLimit(prpClimitDtoTemp.getRiskCode(),
					prpClimitDtoTemp.getLimitType(), true));
		}
		prpClimitDto.setPrpClimitList(arraylist5);
		httpServletRequest.setAttribute("prpClimitDto", prpClimitDto);

		String edtiType = httpServletRequest.getParameter("editType");
		Collection arrayList1 = new ArrayList();
		PrpLlossDto prpLlossDto = new PrpLlossDto();
		arrayList1 = compensateDto.getPrpLlossDtoList();
		if (arrayList1 != null) {
			Iterator iteratorPrpLloss = arrayList1.iterator();
			PrpLlossDto prpLlossDtoTemp = null;
			while (iteratorPrpLloss.hasNext()) {
				prpLlossDtoTemp = (PrpLlossDto) iteratorPrpLloss.next();
				if (currencyTemp.containsKey(prpLlossDtoTemp.getCurrency())) {
					prpLlossDtoTemp.setCurrencyName(currencyTemp.get(prpLlossDtoTemp.getCurrency()).toString());
				}
				if (currencyTemp.containsKey(prpLlossDtoTemp.getCurrency())) {
					prpLlossDtoTemp.setCurrency1Name(currencyTemp.get(prpLlossDtoTemp.getCurrency1()).toString());
				}

				if (currencyTemp.containsKey(prpLlossDtoTemp.getCurrency())) {
					prpLlossDtoTemp.setCurrency2Name(currencyTemp.get(prpLlossDtoTemp.getCurrency2()).toString());
				}
				if (currencyTemp.containsKey(prpLlossDtoTemp.getCurrency())) {
					prpLlossDtoTemp.setCurrency3Name(currencyTemp.get(prpLlossDtoTemp.getCurrency3()).toString());
				}
				if (currencyTemp.containsKey(prpLlossDtoTemp.getCurrency())) {
					prpLlossDtoTemp.setCurrency4Name(currencyTemp.get(prpLlossDtoTemp.getCurrency4()).toString());
				}
				prpLlossDtoTemp.setKindName(uiCodeAction.translateKindCode(prpLlossDtoTemp.getRiskCode(),
						prpLlossDtoTemp.getKindCode(), true));
				//lijiyuan 2006-03-07
				if (edtiType.equals("ADD")) {
					prpLlossDtoTemp.setSumRealPay(prpLlossDtoTemp.getSumRealPay());
				} else {
					prpLlossDtoTemp.setSumRealPay(prpLlossDtoTemp.getDeductible() + prpLlossDtoTemp.getSumRealPay());
				}

				//lijiyuan 2006-03-07
			}
		}
		prpLlossDto.setPrpLlossList(arrayList1);
		httpServletRequest.setAttribute("prpLlossDto", prpLlossDto);

		// 赔付人员信息多行列表准备数据
		Collection arrayList2 = new ArrayList();
		PrpLpersonLossDto prpLpersonLossDto = new PrpLpersonLossDto();
		arrayList2 = compensateDto.getPrpLpersonLossDtoList();
		if (arrayList2 != null) {
			Iterator iteraotrPersonLossTemp = arrayList2.iterator();
			PrpLpersonLossDto pLpersonLossDtoTemp = null;
			while (iteraotrPersonLossTemp.hasNext()) {
				pLpersonLossDtoTemp = (PrpLpersonLossDto) iteraotrPersonLossTemp.next();
				if (currencyTemp.containsKey(pLpersonLossDtoTemp.getCurrency2())) {
					pLpersonLossDtoTemp.setCurrency2Name(currencyTemp.get(pLpersonLossDtoTemp.getCurrency2())
							.toString());
				}
				if (currencyTemp.containsKey(pLpersonLossDtoTemp.getCurrency())) {
					pLpersonLossDtoTemp.setCurrencyName(currencyTemp.get(pLpersonLossDtoTemp.getCurrency()).toString());
				}
				pLpersonLossDtoTemp.setKindName(uiCodeAction.translateKindCode(pLpersonLossDtoTemp.getRiskCode(),
						pLpersonLossDtoTemp.getKindCode(), true));

			}
		}
		prpLpersonLossDto.setPrpLpersonLossList(arrayList2);
		//prpLpersonLossDto.setPersonLossList(arrayList2);
		httpServletRequest.setAttribute("prpLpersonLossDto", prpLpersonLossDto);

		// 赔款费用信息多行列表准备数据
		Collection arrayList3 = new ArrayList();
		PrpLchargeDto prpLchargeDto = new PrpLchargeDto();
		arrayList3 = compensateDto.getPrpLchargeDtoList();
		if (arrayList3 != null) {
			Iterator iteraotrChargeDto = arrayList3.iterator();
			PrpLchargeDto prpLchargeDtoTemp = null;
			while (iteraotrChargeDto.hasNext()) {
				prpLchargeDtoTemp = (PrpLchargeDto) iteraotrChargeDto.next();
				prpLchargeDtoTemp.setKindName(uiCodeAction.translateKindCode(prpLchargeDtoTemp.getRiskCode(),
						prpLchargeDtoTemp.getKindCode(), true));
				if (currencyTemp.containsKey(prpLchargeDtoTemp.getCurrency())) {
					prpLchargeDtoTemp.setCurrencyName(currencyTemp.get(prpLchargeDtoTemp.getCurrency()).toString());
				}
			}
		}
		//add by miaowenjun 20070130 去掉间接理赔费用 start
        Collection newArrayList3 = new ArrayList();
        if("SHOW".equals(compensateDto.getPrpLcompensateDto().getEditType()) || "EDIT".equals(compensateDto.getPrpLcompensateDto().getEditType())){
	        for (Iterator iter = arrayList3.iterator(); iter.hasNext();) {
				PrpLchargeDto prpLchargeDtoTemp = (PrpLchargeDto) iter.next();
				if(!"28".equals(prpLchargeDtoTemp.getChargeCode())){
					newArrayList3.add(prpLchargeDtoTemp);
				}
			}
        }else{
        	newArrayList3 = arrayList3;
        }
        //add by miaowenjun 20070130 去掉间接理赔费用 end
        prpLchargeDto.setPrpLchargeList(newArrayList3);
		httpServletRequest.setAttribute("prpLchargeDto", prpLchargeDto);
		//add by qinyongli 2006-1-12 begin 加入对车险损失险免赔额的处理
		ArrayList deductibleList = compensateDto.getPrpLdeductibleList();
		//首先，在理算免赔额表中查找数据，如果，找不到再从险别表中取免赔额
		PrpLdeductibleDto prpLdeductibleDto = null;
		if (deductibleList != null) {
			Iterator iteratorA = deductibleList.iterator();
			while (iteratorA.hasNext()) {
				prpLdeductibleDto = (PrpLdeductibleDto) iteratorA.next();
				break;//目前，车险只有一个到险别的免赔额
			}
		}
		//如果，找不到免赔额再从险别表中取免赔额
		if (prpLdeductibleDto == null) {
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(compensateDto.getPrpLcompensateDto()
					.getPolicyNo(), compensateDto.getPrpLcompensateDto().getDamageStartDate().toString(), compensateDto
					.getPrpLcompensateDto().getDamageStartHour());

			ArrayList prpCitemKindList = policyDto.getPrpCitemKindDtoList();
			PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();
			Iterator citemKind = prpCitemKindList.iterator();
			while (citemKind.hasNext()) {
				prpCitemKindDto = (PrpCitemKindDto) citemKind.next();
				if (prpCitemKindDto.getKindCode().equals("A")) {
					if (prpCitemKindDto.getValue() != 0) {
						prpLdeductibleDto = new PrpLdeductibleDto();
						//prpLdeductibleDto.setDeductible(String.valueOf(prpCitemKindDto.getValue())); 
						prpLdeductibleDto.setDeductible(String.valueOf(prpCitemKindDto.getValue()));
					} else {
						prpLdeductibleDto = null;
					}
				}
			}
		}
		httpServletRequest.setAttribute("prpLdeductibleDto", prpLdeductibleDto);
		//add by qinyongli 2006-1-12 end

	}

	/**
	 * 获取选择框和列表框中的所有内容
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param prpPrepayDto
	 *            实赔的数据类
	 * @throws Exception
	 */
	private void setSelectionList(HttpServletRequest httpServletRequest, PrpLcompensateDto prpLcompensateDto)
			throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();

		// (1)得到实赔类型列表
		Collection compeQuality = uiCodeAction.getCodeType("CompeQuality", prpLcompensateDto.getRiskCode());
		httpServletRequest.setAttribute("qualityCheckList", compeQuality);
		// (1)得到实赔类型列表
		Collection reportTypes = uiCodeAction.getCodeType("ReportType", prpLcompensateDto.getRiskCode());
		httpServletRequest.setAttribute("reportTypes", reportTypes);
		// (2)得到案件种类列表列表
		Collection claimTypes = uiCodeAction.getCodeType("CaseCode", prpLcompensateDto.getRiskCode());
		httpServletRequest.setAttribute("claimTypes", claimTypes);
		// (3)得到出险地址类型列表
		Collection damageAddressTypes = uiCodeAction.getCodeType("DamageAddress", prpLcompensateDto.getRiskCode());
		httpServletRequest.setAttribute("damageAddressTypes", damageAddressTypes);
		// (4)得到车辆种类列表
		Collection carKindCodes = uiCodeAction.getCodeType("CarKind", prpLcompensateDto.getRiskCode());
		httpServletRequest.setAttribute("carKindCodes", carKindCodes);
		// (5)得到车牌底色列表
		Collection licenseColorCode = uiCodeAction.getCodeType("LicenseColor", prpLcompensateDto.getRiskCode());
		httpServletRequest.setAttribute("licenseColorCodes", licenseColorCode);
		// (6)得到赔偿责任列表
		Collection indemnityDuty = uiCodeAction.getCodeType("IndemnityDuty", prpLcompensateDto.getRiskCode());
		httpServletRequest.setAttribute("indemnityDutys", indemnityDuty);
		// (7)得到赔案类别列表
		Collection escapeFlags = uiCodeAction.getCodeType("CaseCode", prpLcompensateDto.getRiskCode());
		httpServletRequest.setAttribute("escapeFlags", escapeFlags);
		// (8)得到得到性别
		Collection driverSex = uiCodeAction.getCodeType("SexCode", prpLcompensateDto.getRiskCode());
		httpServletRequest.setAttribute("driverSexs", driverSex);
		// (9)得到职业分类
		Collection driverOccupation = uiCodeAction.getCodeType("Occupation", prpLcompensateDto.getRiskCode());
		httpServletRequest.setAttribute("driverOccupations", driverOccupation);
		// (10)得到文化程度
		Collection education = uiCodeAction.getCodeType("Education", prpLcompensateDto.getRiskCode());
		httpServletRequest.setAttribute("educations", education);
		// 车牌号码
		Collection LicenseNoList = (Collection) uiCodeAction.getLicenseNoList(uiCodeAction.translateBusinessCode(
				prpLcompensateDto.getClaimNo(), false));
		ArrayList claimFlagList = new ArrayList();
		Iterator iteratorTemp = LicenseNoList.iterator();
		while (iteratorTemp.hasNext()) {
			PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto) iteratorTemp.next();
			claimFlagList.add(new LabelValueBean(prpLthirdPartyDto.getLicenseNo(), prpLthirdPartyDto.getLicenseNo()));
		}
		httpServletRequest.setAttribute("LicenseNoList", claimFlagList);
		// 车牌号码
		Collection licenseNoList = (Collection) uiCodeAction.getLicenseNoList(uiCodeAction.translateBusinessCode(
				prpLcompensateDto.getClaimNo(), false));
		httpServletRequest.setAttribute("licenseNoList", licenseNoList);
	}

	/**
	 * 根据PrpPrepayDto中的已经设置的代码内容，对代码进行名称转换
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param prpPrepayDto
	 *            实赔的数据类
	 * @param PrepayDto
	 *            查询出的数据类
	 * @throws Exception
	 */
	private void changeCodeToName(HttpServletRequest httpServletRequest, PrpLcompensateDto prpLcompensateDto)
			throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		// (1)条款名称的转换
		String clauseType = prpLcompensateDto.getClauseType();
		String clauseName = uiCodeAction.translateCodeCode("ClauseType", clauseType, true);
		prpLcompensateDto.setClauseName(clauseName);
		// (2)号牌颜色转换
		String licenseColorCodeCode = prpLcompensateDto.getLicenseColorCode();
		String licenseColor = uiCodeAction.translateCodeCode("LicenseColor", licenseColorCodeCode, true);
		prpLcompensateDto.setLicenseColor(licenseColor);
		// (3)车辆类型转换
		String carKindCode = prpLcompensateDto.getCarKindCode();
		String carKind = uiCodeAction.translateCodeCode("CarKind", carKindCode, true);
		prpLcompensateDto.setCarKind(carKind);
		// (4)对业务归属结构进行转换
		String comCode = prpLcompensateDto.getComCode();
		String comName = uiCodeAction.translateComCode(comCode, true);
		prpLcompensateDto.setComName(comName);
		// (5)对归属业务员进行转换
		String handler1Code = prpLcompensateDto.getHandler1Code();
		String handler1Name = uiCodeAction.translateUserCode(handler1Code, true);
		// prpLcompensateDto.setHandler1Name(handler1Name) ;
		// (6)对代理人进行转换
		// String agentCode = prpLcompensateDto.getAgentCode();
		// String agentName = uiCodeAction.translateUserCode(agentCode,true) ;
		// prpLcompensateDto.setAgentName(agentName) ;
		// (7)对经办人进行转换
		String handlerCode = prpLcompensateDto.getHandlerCode();
		String handlerName = uiCodeAction.translateUserCode(handlerCode, true);
		prpLcompensateDto.setHandlerName(handlerName);
		// (8)对案件类型进行转换
		String caseType = prpLcompensateDto.getCaseType();
		String caseTypeName = uiCodeAction.translateCodeCode("CaseType", caseType, true);
		prpLcompensateDto.setCaseTypeName(caseTypeName);
		// (8)对案件类型进行转换
		String indemnityDutyRate = String.valueOf(prpLcompensateDto.getIndemnityDuty());
		String indemnityDutyRateName = uiCodeAction.translateCodeCode("IndemnityDuty", indemnityDutyRate, true);
		prpLcompensateDto.setIndemnityDutyName(indemnityDutyRateName);

	}

	/**
	 * 根据赔款计算书号和保单号,赔案号,案件状态，车牌号码，操作时间查询实赔信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param compensateNo
	 *            赔款计算书号
	 * @param policyNo
	 *            保单号
	 * @param claimNo
	 *            赔案号
	 * @throws Exception
	 *             Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件
	 */

	public void setPrpLcompensateDtoToView(HttpServletRequest httpServletRequest, String compensateNo, String policyNo,
			String claimNo, String licenseNo, String status, String operateDate, String underWriteFlag)
			throws Exception {
		UICodeAction uiCodeAction = UICodeAction.getInstance();
		// compensateNo,policyNo,claimNo
		// 根据输入的保单号，实赔号生成SQL where 子句
		claimNo = StringUtils.rightTrim(claimNo);
		policyNo = StringUtils.rightTrim(policyNo);
		compensateNo = StringUtils.rightTrim(compensateNo);
		licenseNo = StringUtils.rightTrim(licenseNo);
		operateDate = StringUtils.rightTrim(operateDate);
		String strSign = httpServletRequest.getParameter("OperateDateSign");

		String conditions = " 1=1 ";
		conditions = conditions
				+ StringConvert.convertString("a.compensateNo", compensateNo, httpServletRequest
						.getParameter("CompensateNoSign"));
		conditions = conditions
				+ StringConvert.convertString("a.claimNo", claimNo, httpServletRequest.getParameter("ClaimNoSign"));
		conditions = conditions
				+ StringConvert.convertString("a.policyNo", policyNo, httpServletRequest.getParameter("PolicyNoSign"));
		conditions = conditions
				+ StringConvert.convertString("c.licenseNo", licenseNo, httpServletRequest
						.getParameter("LicenseNoSign"));
		if (status.trim().length() > 0) {
			conditions = conditions + " AND b.status in ('" + status + "')";
		}
		if (underWriteFlag.trim().length() > 0) {
			conditions = conditions + " AND a.underWriteFlag in (" + underWriteFlag + ") ";
		}
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions + StringConvert.convertDate("b.operateDate", operateDate, strSign);
		}

		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession().getAttribute("user");
		
//		modify by zhaolu 20060816 start
		//conditions = conditions
		//		+ uiPowerInterface.addPower(userDto.getUserCode(), com.sinosoft.claim.util.BusinessRuleUtil
		//				.transTaskCode(httpServletRequest.getParameter("nodeType")), "a", uiCodeAction
		//				.translateProductCode("RISKCODE_DAA"));
		conditions = conditions + uiPowerInterface.addPower(userDto,"a","","ComCode");
		//modify by zhaolu 20060816 end
		// 查询预赔信息
		UICompensateAction uiCompensateAction = new UICompensateAction();

		// 得到多行实赔主表信息
		Collection compensateList = new ArrayList();
		compensateList = (Collection) uiCompensateAction.findByQueryConditions(conditions);
		PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
		prpLcompensateDto.setCompensateList(compensateList);
		prpLcompensateDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);

	}

	/**
	 * 有预赔的案件复核不通过的案件不能进入实赔理算 返回值 true 已出 false 未出
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param claimNo
	 *            赔案号
	 * @throws Exception
	 */
	public boolean checkPrepay(HttpServletRequest httpServletRequest, String claimNo) throws Exception {
		boolean blnRetrun = true;
		// 取得赔款计算书信息
		UIPrepayAction uiPrepayAction = new UIPrepayAction();
		String conditions = "claimNo ='" + claimNo.trim() + "'";
		Collection collection = (Collection) uiPrepayAction.findByConditions(conditions);
		Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			PrpLprepayDto prpLprepayDto = (PrpLprepayDto) iterator.next();
			if (prpLprepayDto.getUnderWriteFlag() == null || !prpLprepayDto.getUnderWriteFlag().trim().equals("1")) {
				blnRetrun = false;
			}
		}
		return blnRetrun;
	}

	/**
	 * 核损不通过的案件不能进入实赔理算 返回值 true 已出 false 未出
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param claimNo
	 *            赔案号
	 * @throws Exception
	 */
	public boolean checkVerifyLoss(HttpServletRequest httpServletRequest, String claimNo) throws Exception {
		boolean blnRetrun = true;
		// 根据赔案号码取得对应的报案号码
		UICodeAction uiCodeAction = new UICodeAction();
		String registNo = uiCodeAction.translateBusinessCode(claimNo, false);

		// 取得赔款计算书信息
		UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
		String conditions = "registNo ='" + registNo.trim() + "'";
		Collection collection = (Collection) uiVerifyLossAction.findByConditions(conditions);
		Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			PrpLverifyLossDto prpLverifyLossDto = (PrpLverifyLossDto) iterator.next();
			if (prpLverifyLossDto.getUnderWriteFlag() == null
					|| !prpLverifyLossDto.getUnderWriteFlag().trim().equals("1")) {
				blnRetrun = false;
			}
		}
		return blnRetrun;
	}

	/**
	 * 核损不通过的案件不能进入实赔理算 返回值 true 已出 false 未出
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param claimNo
	 *            赔案号
	 * @throws Exception
	 */
	public int checkCondition(HttpServletRequest httpServletRequest, String claimNo) throws Exception {
		int intReturn = 0;
		UIClaimAction uiClaimAction = new UIClaimAction();
		ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
		if (claimDto.getPrpLclaimDto() == null) {
			return 1;
		}

		// 根据赔案号码取得对应的报案号码
		UICodeAction uiCodeAction = new UICodeAction();
		String registNo = uiCodeAction.translateBusinessCode(claimNo, false);

		// 取得赔款计算书信息
		UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
		String conditions = "registNo ='" + registNo.trim() + "'";
		Collection collection = (Collection) uiVerifyLossAction.findByConditions(conditions);
		if (collection.size() < 1) {
			return 2;
		}
		return intReturn;
	}

	/**
	 * 核损不通过的案件不能进入实赔理算 返回值 true 已出 false 未出
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param claimNo
	 *            赔案号
	 * @throws Exception
	 */
	public boolean checkCertify(HttpServletRequest httpServletRequest, String claimNo) throws Exception {
		boolean blnReturn1 = false;
		boolean blnReturn2 = false;

		// 根据赔案号码取得对应的报案号码
		UICodeAction uiCodeAction = new UICodeAction();
		String registNo = uiCodeAction.translateBusinessCode(claimNo, false);

		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		String licenseNo = registDto.getPrpLregistDto().getLicenseNo();

		UICertifyAction uiCertifyAction = new UICertifyAction();
		CertifyDto certifyDto = uiCertifyAction.findByPrimaryKey(registNo);
		Iterator iterator = certifyDto.getPrpLcertifyCollectDtoList().iterator();
		ArrayList arrayList = (ArrayList) certifyDto.getPrpLcertifyCollectDtoList();
		while (iterator.hasNext()) {
			PrpLcertifyCollectDto prpLcertifyCollectDto = (PrpLcertifyCollectDto) iterator.next();
			if (prpLcertifyCollectDto.getLossItemCode() != null
					&& prpLcertifyCollectDto.getLossItemCode().trim().equals("0")) {
				if (prpLcertifyCollectDto.getCollectFlag() != null
						&& prpLcertifyCollectDto.getCollectFlag().trim().equals("1")) {
					blnReturn1 = true;
				}
			}
		}
		iterator = certifyDto.getPrpLcertifyCollectDtoList().iterator();
		while (iterator.hasNext()) {
			PrpLcertifyCollectDto prpLcertifyCollectDto = (PrpLcertifyCollectDto) iterator.next();
			if (prpLcertifyCollectDto.getLossItemName() != null
					&& prpLcertifyCollectDto.getLossItemName().trim().equals(licenseNo)) {
				if (prpLcertifyCollectDto.getCollectFlag() != null
						&& prpLcertifyCollectDto.getCollectFlag().trim().equals("1")) {
					blnReturn2 = true;
				}
			}
		}

		return (blnReturn1 && blnReturn2);
	}

	/**
	 * 根据赔款计算书号和保单号和赔案号查询待复核的实赔信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param compensateNo
	 *            赔款计算书号
	 * @param policyNo
	 *            保单号
	 * @param claimNo
	 *            赔案号
	 * @throws Exception
	 */

	public void getApproveCompensateList(HttpServletRequest httpServletRequest, String compensateNo, String policyNo,
			String claimNo) throws Exception {
		// compensateNo,policyNo,claimNo
		// 根据输入的保单号，实赔号生成SQL where 子句
		claimNo = StringUtils.rightTrim(claimNo);
		policyNo = StringUtils.rightTrim(policyNo);
		compensateNo = StringUtils.rightTrim(compensateNo);

		String conditions = "1=1  ";
		conditions = conditions
				+ StringConvert.convertString("prplcompensate.compensateNo", compensateNo, httpServletRequest
						.getParameter("CompensateNoSign"));
		conditions = conditions
				+ StringConvert.convertString("prplcompensate.policyNo", policyNo, httpServletRequest
						.getParameter("PolicyNoSign"));
		conditions = conditions
				+ StringConvert.convertString("prplcompensate.claimNo", claimNo, httpServletRequest
						.getParameter("ClaimNoSign"));
		// conditions = conditions +" AND ( prplcompensate.ApproverCode IS NULL
		// OR prplcompensate.ApproverCode='' OR
		// prplcompensate.UnderWriteFlag='2') and prplclaimstatus.status='3'" ;
		conditions = conditions
				+ " AND ( prplcompensate.ApproverCode IS NULL OR  prplcompensate.ApproverCode='' OR prplcompensate.UnderWriteFlag='2')";
		// 查询预赔信息
		UICompensateAction uiCompensateAction = new UICompensateAction();

		// 得到多行实赔主表信息
		Collection compensateList = new ArrayList();

		compensateList = (Collection) uiCompensateAction.findByApproveConditions(conditions);


		PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
		prpLcompensateDto.setCompensateList(compensateList);

		prpLcompensateDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);
	}

	/**
	 * 承保保单中的内容以及免赔率等内容
	 * 
	 * @throws Exception
	 */
	public void getLossInfo(HttpServletRequest httpServletRequest, PrpLcompensateDto prpLcompensateDto)
			throws Exception {
		
		UIDeductCondAction uiDeductCondAction = UIDeductCondAction.getInstance();
		// 批单
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		// 保单对象
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(prpLcompensateDto.getPolicyNo(), prpLcompensateDto
				.getDamageStartDate().toString(), prpLcompensateDto.getDamageStartHour());
		// 免赔率
		double dblDeductibleRate = 0;
		double dblDutyDeductibleRate = 0;
		double dblDriverDeductibleRate = 0;

		ClaimDto claimDto = UIClaimAction.getInstance().findByPrimaryKey(prpLcompensateDto.getClaimNo());

		List prpcItemKindDtoLossList = getPrpcItemKindDtoLossList(policyDto.getPrpCitemKindDtoList(), claimDto
				.getPrpLclaimLossDtoList());

		for (int i = 0; i < prpcItemKindDtoLossList.size(); i++) {
			PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) prpcItemKindDtoLossList.get(i);
			if(policyDto.getPrpCmainDto().getOperateDate() == null){
            	throw new UserException(0, 0, "保单签单日期为空");
            }
			// 事故责任免赔率  modify by miaowenjun 20060605
			if(prpCitemKindDto.getModel()!=null&&!"".equals(prpCitemKindDto.getModel())){
			dblDutyDeductibleRate = uiDeductCondAction.getDeductibleRateOfAccident(
					prpLcompensateDto.getRiskCode(), 
					prpCitemKindDto.getKindCode(), 
					prpLcompensateDto.getIndemnityDuty(), 
				    	prpCitemKindDto.getModel(),
				    	policyDto.getPrpCmainDto().getOperateDate().toString()
					    );
		
			   //System.out.println("zwwwww viewhelper getlossinfo model"+dblDutyDeductibleRate);
			}else{
				dblDutyDeductibleRate = uiDeductCondAction.getDeductibleRateOfAccident(
						prpLcompensateDto.getRiskCode(), 
						prpCitemKindDto.getKindCode(), 
						prpLcompensateDto.getIndemnityDuty(), 
						prpCitemKindDto.getModeCode(),
						policyDto.getPrpCmainDto().getOperateDate().toString()
						);
			}
			// 获得绝对免赔率 modify by miaowenjun 20060605
			dblDeductibleRate = uiDeductCondAction.getDeductibleRateOfAbsolute(
					prpLcompensateDto.getClauseType(), 
					prpCitemKindDto.getKindCode(), 
					prpLcompensateDto.getPrpLdeductCondDtoList(), 
					prpLcompensateDto.getRiskCode(),
					policyDto.getPrpCmainDto().getOperateDate().toString()
					);

			//驾驶员免赔率
			dblDriverDeductibleRate = 0;
			
			prpCitemKindDto.setDeductibleRate(dblDeductibleRate);
			prpCitemKindDto.setDutyDeductibleRate(dblDutyDeductibleRate);
			prpCitemKindDto.setDriverDeductibleRate(dblDriverDeductibleRate);
			// 赔偿比例
			if (prpCitemKindDto.getKindCode().equals("A")) {
				String escapeFlag = prpLcompensateDto.getEscapeFlag();
				if (escapeFlag != null && escapeFlag.length() > 1 && escapeFlag.substring(1, 2).equals("Y")) {
					double purchasePrice = Double.parseDouble(DataUtils
							.nullToZero(prpLcompensateDto.getPurchasePrice()));
					double amount = prpCitemKindDto.getAmount();
					if (purchasePrice != amount) {
						double lossClaimRate = amount * 100.00 / purchasePrice;
						prpCitemKindDto.setClaimRate(lossClaimRate);
					}
				}
			} else {
				prpCitemKindDto.setClaimRate(100);
			}
			// 责任比例
			prpCitemKindDto.setIndemnityDutyRate(100);
		}
		httpServletRequest.setAttribute("prpCitemKindDtoListInit", prpcItemKindDtoLossList);
	}

	/**
	 * 出新的赔款计算数的时候初始化人员的信息
	 * 
	 * @throws Exception
	 */
	public ArrayList initPersonLoss(HttpServletRequest httpServletRequest, String claimNo, ClaimDto claimDto) throws Exception {

		UICodeAction uiCodeAction = new UICodeAction();
		String riskCode = claimDto.getPrpLclaimDto().getRiskCode();
		String configCode=uiCodeAction.translateRiskCodetoConfigCode(riskCode);
		ArrayList prpLdeductCondList = UIDeductCondAction.getInstance().getDeductCondList(httpServletRequest,false);
		// 得到赔付人员信息
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		PrpCitemKindDto prpCitemKindDtoTemp = new PrpCitemKindDto();
		ArrayList personLossListTemp = new ArrayList();
		// 报案号码
		String registNo = uiCodeAction.translateBusinessCode(claimNo, false);
		// 序列号
		int serialNo = 0;
		// 免赔率
		double dblDeductibleRate = 0;
		double dblDutyDeductibleRate = 0;
		String strDeductibleTerm = httpServletRequest.getParameter("DeductibleTerm");

		//判断是否已出过计算书且核赔通过，如果是这样，再出计算书，不需要带出人伤定损信息-----------------|
		String compensateFlag = "";
		String conditions = "  claimNo = '" + claimNo + "'";
		UICompensateAction uiCompensateAction = new UICompensateAction();
		Collection compensateDtoList = new ArrayList();
		compensateDtoList = uiCompensateAction.findByClaimNo(conditions);

		if ((!compensateDtoList.isEmpty()) && compensateDtoList.size() > 0) {
			logger.debug("[人伤]出过计算书");
			Iterator list = compensateDtoList.iterator();
			while (list.hasNext()) {
				PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto) list.next();
				if (prpLcompensateDto.getUnderWriteFlag().equals("1")
						|| prpLcompensateDto.getUnderWriteFlag().equals("3")) {
					compensateFlag = "1";
					break;
				} else {
					compensateFlag = "0";
					continue;
				}
			}
		} else { //没出过计算书
			logger.debug("[人伤]没出过计算书");
			compensateFlag = "0";
		}

		logger.debug("======是否有已核赔通过的计算书  标志 1 有 0 没有=====" + compensateFlag);

		if (compensateFlag.equals("1")) {
		} else {
			PrpLlossDto prpLlossDto = new PrpLlossDto();
			CertainLossDto certainLossDto = uiCertainLossAction.findByPrimaryKey(registNo);
			if (certainLossDto.getPrpLpersonDtoList() != null) {
				Iterator iteratorTemp = certainLossDto.getPrpLpersonDtoList().iterator();
				while (iteratorTemp.hasNext()) {
					// 取得保单的信息
					serialNo++;
					PrpLpersonDto prpLpersonDtoTemp = (PrpLpersonDto) iteratorTemp.next();
					PrpLpersonLossDto prpLpersonLossDto = new PrpLpersonLossDto();

					EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
					PolicyDto policyDto = endorseViewHelper.findForEndorBefore(prpLpersonDtoTemp.getPolicyNo(),
							claimDto.getPrpLclaimDto().getDamageStartDate().toString(), claimDto.getPrpLclaimDto()
									.getDamageStartHour());
					ArrayList cTemp = policyDto.getPrpCitemKindDtoList();
					for (int i = 0; i < cTemp.size(); i++) {
						prpCitemKindDtoTemp = (PrpCitemKindDto) cTemp.get(i);
						if (prpCitemKindDtoTemp.getItemKindNo() == prpLpersonDtoTemp.getItemKindNo()) {
							break;
						}
					}
					
					
					String strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLpersonDtoTemp.getRiskCode());
				
					
					PrpCitemCarDto PrpCitemCarDto = (PrpCitemCarDto) policyDto.getPrpCitemCarDtoList().get(0);
					UIDeductCondAction uiDeductCondAction = UIDeductCondAction.getInstance();
					
					if(policyDto.getPrpCmainDto().getOperateDate() == null){
                    	throw new UserException(0, 0, "保单生效期为空");
                    }
					// 获得事故责任免赔率
					if("D".equals(strRiskType)){
						if (("RISKCODE_DAZ".equals(configCode)||"RISKCODE_DAY".equals(configCode)
								||"RISKCODE_DAU".equals(configCode)) && ("B".equals(prpLpersonDtoTemp.getKindCode())|| "BZ".equals(prpLpersonDtoTemp.getKindCode()))){
							
							prpLpersonLossDto.setKindCode("BZ");
						}else if ("BZ".equals(prpLpersonDtoTemp.getKindCode())){
							//modify by kangzhen 061127 start  
							//如果没有投保B险就不在商业保险的计算书中显示人伤信息
							if(checkItemKindB(claimNo)==true){
								prpLpersonLossDto.setKindCode("B");
							}
							else {
								continue;
							}
							//modify by kangzhen 061127 end
						}else{
							prpLpersonLossDto.setKindCode(prpLpersonDtoTemp.getKindCode());
						}
						//理算人员标的序号从核心系统表取
						for (int i = 0; i < cTemp.size(); i++) {
							prpCitemKindDtoTemp = (PrpCitemKindDto) cTemp.get(i);
							if (prpCitemKindDtoTemp.getKindCode().equals(prpLpersonLossDto.getKindCode())) {
								break;
							}
						}
					}
					if(prpCitemKindDtoTemp.getModel()!=null&&!"".equals(prpCitemKindDtoTemp.getModel())){
					    dblDutyDeductibleRate = uiDeductCondAction.getDeductibleRateOfAccident(
					    		prpLpersonDtoTemp.getRiskCode(),
					    		prpLpersonLossDto.getKindCode(), 
						    	claimDto.getPrpLclaimDto().getIndemnityDuty(),
							    prpCitemKindDtoTemp.getModel(),
						    	policyDto.getPrpCmainDto().getOperateDate().toString()
						    	);
					    //System.out.println("zwwwww viewhelper personloss model"+dblDutyDeductibleRate);
					}else{
						dblDutyDeductibleRate = uiDeductCondAction.getDeductibleRateOfAccident(
								prpLpersonDtoTemp.getRiskCode(),
								prpLpersonLossDto.getKindCode(), 
								claimDto.getPrpLclaimDto().getIndemnityDuty(),
								prpCitemKindDtoTemp.getModeCode(),
								policyDto.getPrpCmainDto().getOperateDate().toString()
								);
						//System.out.println("zwwwww viewhelper personloss modeCode"+dblDutyDeductibleRate);
					}
					// 获得绝对免赔率
					dblDeductibleRate = uiDeductCondAction.getDeductibleRateOfAbsolute(
							PrpCitemCarDto.getClauseType(), 
							prpLpersonLossDto.getKindCode(), 
							prpLdeductCondList, 
							prpLpersonDtoTemp.getRiskCode(),
							policyDto.getPrpCmainDto().getOperateDate().toString());
					
					
					if ("D".equals(strRiskType)) {
						prpLlossDto.setRiskCode(prpLpersonDtoTemp.getRiskCode());
						prpLlossDto.setPolicyNo(prpLpersonDtoTemp.getPolicyNo());
						prpLlossDto.setAmount(prpCitemKindDtoTemp.getAmount());
						prpLlossDto.setCompensateNo(claimNo);
						prpLlossDto.setKindCode(prpLpersonDtoTemp.getKindCode());
						prpLlossDto.setKindName(
								uiCodeAction.translateKindCode(prpLpersonDtoTemp.getRiskCode(),prpLpersonDtoTemp.getKindCode(), true));
						prpLlossDto.setCurrency(prpLpersonDtoTemp.getCurrency());
						prpLlossDto.setSumLoss(prpLpersonDtoTemp.getVeriSumDefLoss());
						prpLlossDto.setSumDefPay(prpLpersonDtoTemp.getVeriSumDefLoss());
						prpLlossDto.setSumRest(prpLpersonDtoTemp.getVeriSumReject());
						prpLlossDto.setIndemnityDutyRate(claimDto.getPrpLclaimDto().getIndemnityDutyRate());
						prpLlossDto.setDeductibleRate(dblDeductibleRate);
						prpLlossDto.setDutyDeductibleRate(dblDutyDeductibleRate);
						// 没有传递claimNo的值
						prpLlossDto = calculateSumLoss(prpLlossDto);
						prpLpersonLossDto.setPersonNo(prpLpersonDtoTemp.getPersonNo());
						prpLpersonLossDto.setOverAmount("");
						prpLpersonLossDto.setSerialNo(serialNo);
						prpLpersonLossDto.setRiskCode(prpLpersonDtoTemp.getRiskCode());
						prpLpersonLossDto.setPersonName(prpLpersonDtoTemp.getPersonName());
						prpLpersonLossDto.setSex(prpLpersonDtoTemp.getPersonSex());
						prpLpersonLossDto.setAge(prpLpersonDtoTemp.getPersonAge());
						prpLpersonLossDto.setIdentifyNumber(prpLpersonDtoTemp.getIdentifyNumber());
						prpLpersonLossDto.setFamilyName(prpLpersonDtoTemp.getFamilyName());
						prpLpersonLossDto.setItemKindNo(prpCitemKindDtoTemp.getItemKindNo());
						prpLpersonLossDto.setAmount(prpCitemKindDtoTemp.getAmount());
						prpLpersonLossDto.setDeductible(prpCitemKindDtoTemp.getDeductible());
					
						
						prpLpersonLossDto.setKindName(
								uiCodeAction.translateKindCode(prpLpersonDtoTemp.getRiskCode(),prpLpersonLossDto.getKindCode(), true));

						prpLpersonLossDto.setJobCode(prpLpersonDtoTemp.getJobCode());
						prpLpersonLossDto.setJobName(prpLpersonDtoTemp.getJobName());
						prpLpersonLossDto.setCurrency3(prpLpersonDtoTemp.getCurrency());
						prpLpersonLossDto.setCurrency3Name(uiCodeAction.translateCurrencyCode(prpLpersonDtoTemp.getCurrency(), true));
						prpLpersonLossDto.setIndemnityDutyRate(claimDto.getPrpLclaimDto().getIndemnityDutyRate());
						//协商赔偿比例默认为100%
						prpLpersonLossDto.setArrangeRate(100);
						prpLpersonLossDto.setDeductibleRate(prpLlossDto.getDeductibleRate());
						prpLpersonLossDto.setDutyDeductibleRate(prpLlossDto.getDutyDeductibleRate());
						// 赔付合计
						prpLpersonLossDto.setSumRealPay1(0);
						prpLpersonLossDto.setSumRealPay(prpLpersonDtoTemp.getVeriSumDefLoss());
						prpLpersonLossDto.setLiabDetailCode(prpLpersonDtoTemp.getFeeTypeCode());
						prpLpersonLossDto.setLiabDetailName(prpLpersonDtoTemp.getFeeTypeName());
						prpLpersonLossDto.setUnitAmount(prpLpersonDtoTemp.getVeriUnitLoss());
						prpLpersonLossDto.setLossQuantity((int) prpLpersonDtoTemp.getVeriQuantity());
						prpLpersonLossDto.setSumLoss(Number2(prpLpersonDtoTemp.getVeriSumDefLoss()));
						prpLpersonLossDto.setSumDefPay(Number2(prpLpersonDtoTemp.getVeriSumDefLoss() ));
						prpLpersonLossDto.setClaimRate(prpLlossDto.getClaimRate());

						// modify 20051215 start \reason : 赔付标的信息中赔付金额值不对 ；
						double realPay = 0.00;
						realPay = (prpLpersonLossDto.getSumLoss() - prpLpersonLossDto.getSumRest())
								* (prpLpersonLossDto.getClaimRate() * 0.01)
								* (prpLpersonLossDto.getIndemnityDutyRate() * 0.01)
								* (1 - (prpLpersonLossDto.getDutyDeductibleRate() * 0.01))
								* (1 - (prpLpersonLossDto.getDeductibleRate() * 0.01));
						prpLpersonLossDto.setSumRealPay(Number2(realPay));
						// prpLpersonLossDto.setSumRealPay(prpLlossDto.getSumRealPay());
						// modify 20051215 start \reason : 赔付标的信息中赔付金额值不对 ；

						
						personLossListTemp.add(prpLpersonLossDto);
					} else {
						prpLpersonLossDto.setPersonNo(prpLpersonDtoTemp.getPersonNo());
						prpLpersonLossDto.setOverAmount("");
						prpLpersonLossDto.setSerialNo(serialNo);
						prpLpersonLossDto.setRiskCode(prpLpersonDtoTemp.getRiskCode());
						prpLpersonLossDto.setPersonName(prpLpersonDtoTemp.getPersonName());
						prpLpersonLossDto.setSex(prpLpersonDtoTemp.getPersonSex());
						prpLpersonLossDto.setAge(prpLpersonDtoTemp.getPersonAge());
						prpLpersonLossDto.setSumRealPay(0);
						prpLpersonLossDto.setItemKindNo(prpLpersonDtoTemp.getItemKindNo());
						prpLpersonLossDto.setLiabCode(prpCitemKindDtoTemp.getItemCode());
						prpLpersonLossDto.setLiabName(prpCitemKindDtoTemp.getItemDetailName());

						
						
						if (("RISKCODE_DAZ".equals(configCode)||"RISKCODE_DAY".equals(configCode)
								||"RISKCODE_DAU".equals(configCode)) && ("B".equals(prpLpersonDtoTemp.getKindCode())|| "BZ".equals(prpLpersonDtoTemp.getKindCode()))){
						
							prpLpersonLossDto.setKindCode("BZ");
						}else if ("BZ".equals(prpLpersonDtoTemp.getKindCode())){
							prpLpersonLossDto.setKindCode("B");
						}else{
							prpLpersonLossDto.setKindCode(prpLpersonDtoTemp.getKindCode());
						}
						prpLpersonLossDto.setKindName(
								uiCodeAction.translateKindCode(prpLpersonDtoTemp.getRiskCode(),prpLpersonLossDto.getKindCode(), true));

						
						prpLpersonLossDto.setKindCode(prpLpersonDtoTemp.getKindCode());
						prpLpersonLossDto.setKindName(uiCodeAction.translateKindCode(prpLpersonDtoTemp.getRiskCode(),
								prpLpersonDtoTemp.getKindCode(), true));
						prpLpersonLossDto.setLiabDetailCode(prpLpersonDtoTemp.getFeeTypeCode());
						prpLpersonLossDto.setLiabDetailName(prpLpersonDtoTemp.getFeeTypeName());
						prpLpersonLossDto.setCurrency2(prpLpersonDtoTemp.getCurrency());
						prpLpersonLossDto.setCurrency2Name(uiCodeAction.translateCurrencyCode(prpLpersonDtoTemp
								.getCurrency(), true));
						prpLpersonLossDto.setSumLoss(Number2(prpLpersonDtoTemp.getVeriSumLoss()));
						prpLpersonLossDto.setAmount(prpCitemKindDtoTemp.getAmount());
						prpLpersonLossDto.setClaimRate(prpLpersonDtoTemp.getLossRate());
						prpLpersonLossDto.setDeductible(0);
						prpLpersonLossDto.setCurrency(prpLpersonDtoTemp.getCurrency());
						prpLpersonLossDto.setCurrency1(prpLpersonDtoTemp.getCurrency());
						prpLpersonLossDto.setCurrency3(prpLpersonDtoTemp.getCurrency());
						prpLpersonLossDto.setCurrency4(prpLpersonDtoTemp.getCurrency());

						// modify 20051215 start \reason : 赔付标的信息中赔付金额值不对 ；
						double realPay = 0.00;
						realPay = (prpLpersonLossDto.getSumLoss() - prpLpersonLossDto.getSumRest())
								* (prpLpersonLossDto.getClaimRate() * 0.01)
								* (prpLpersonLossDto.getIndemnityDutyRate() * 0.01)
								* (1 - (prpLpersonLossDto.getDutyDeductibleRate() * 0.01))
								* (1 - (prpLpersonLossDto.getDeductibleRate() * 0.01));
						prpLpersonLossDto.setSumRealPay(Number2(realPay));
						// prpLpersonLossDto.setSumRealPay(prpLpersonDtoTemp.getSumDefLoss());
						// modify 20051215 start \reason : 赔付标的信息中赔付金额值不对 ；				
						personLossListTemp.add(prpLpersonLossDto);
					}
				}
			}
		}//end if (compensateFlag.equals("0"))
		return personLossListTemp;
	}

	/**
	 * STUB-ONLY 计算实赔金额
	 * 
	 * @param PrpLlossDto
	 *            prpLlossDto
	 * @throws UserException
	 * @throws Exception
	 * @throws prpLlossSchema
	 */
	public PrpLlossDto calculateSumLoss(PrpLlossDto prpLlossDto) throws Exception {
		UICodeAction uiCodeAction = UICodeAction.getInstance();
		double dblSumLoss = 0;
		double dblSumRest = 0;
		double dblDeductible = 0;
		double dblDeductRate = 0;
		double dblDeductible1 = 0;
		double dblSumRealPay = 0;
		double lv_claimrate = 0;
		double dblRate = 0;
		double dblIndemnityDutyRate = 0;
		String strRiskCode = "";
		String strCond = "";

		// BLPrpCitemCar blPrpCitemCar = new BLPrpCitemCar() ;
		// BLPrpLcompensate blPrpLcompensate = new BLPrpLcompensate() ;
		// BLPrpLclaim blPrpLclaim = new BLPrpLclaim() ;
		// BLPrpCitemKind blPrpCitemKind = new BLPrpCitemKind() ;

		// PrpCitemCarDto prpCitemCarDto = new PrpCitemCarDto() ;
		PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
		PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();
		PrpCitemCarDto PrpCitemCarDto = new PrpCitemCarDto();
		// blPrpLclaim = new BLPrpLclaim();
		// 如果prpLlossDto.getCompensateNo()为空怎么办？？
		strCond = "ClaimNo = '" + prpLlossDto.getCompensateNo() + "'";
		UIClaimAction uiClaimAction = new UIClaimAction();
		ClaimDto claimDto = uiClaimAction.findByPrimaryKey(prpLlossDto.getCompensateNo());

		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(prpLlossDto.getPolicyNo(), claimDto
				.getPrpLclaimDto().getDamageStartDate().toString(), claimDto.getPrpLclaimDto().getDamageStartHour());

		for (int i = 0; i < policyDto.getPrpCitemKindDtoList().size(); i++) {
			prpCitemKindDto = (PrpCitemKindDto) policyDto.getPrpCitemKindDtoList().get(i);
			if (prpCitemKindDto.getKindCode().equals(prpLlossDto.getKindCode())) {
				break;
			}
		}

		PrpCitemCarDto = (PrpCitemCarDto) policyDto.getPrpCitemCarDtoList().get(0);
		prpLclaimDto = claimDto.getPrpLclaimDto();

		dblSumLoss = prpLlossDto.getSumLoss();
		dblSumRest = prpLlossDto.getSumRest();
		dblDeductible = prpLlossDto.getDeductible();
		dblDeductRate = prpLlossDto.getDeductibleRate() / 100;
		dblIndemnityDutyRate = prpLlossDto.getIndemnityDutyRate();
		strRiskCode = prpLlossDto.getRiskCode();

		// 根据所注释程序逻辑可推出如下公式
		if (!strRiskCode.equals(uiCodeAction.translateProductCode("RISKCODE_DAA"))
				&&!strRiskCode.equals(uiCodeAction.translateProductCode("RISKCODE_DAX"))
				&&!strRiskCode.equals(uiCodeAction.translateProductCode("RISKCODE_DAT"))) {
			dblSumRealPay = (dblSumLoss - dblSumRest) * (prpLlossDto.getClaimRate()) / 100;
		}

		if (!prpLlossDto.getCurrency2().equals(prpLlossDto.getCurrency4())) {
			// dblRate =
			// fnu(fget_exch_rate(prpLlossDto.getCurrency2,prpLlossDto.getCurrency4,TODAY));
		} else {
			dblRate = 1;
		}

		if (dblSumLoss > prpLlossDto.getAmount() && !prpLclaimDto.getEscapeFlag().equals("5N")) // 非逃逸案
		{
			dblSumLoss = prpLlossDto.getAmount();
		}

		double dblSumLossRest = prpLlossDto.getSumLoss() - prpLlossDto.getSumRest();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(strRiskCode);
		if ("D".equals(strRiskType)) {
			// 机动车辆损失险
			if (prpLlossDto.getKindCode().equals("A")) {
				if (prpLlossDto.getAmount() == PrpCitemCarDto.getPurchasePrice()) {
					prpLlossDto.setClaimRate(100);
					if (PrpCitemCarDto.getClauseType().equals("F11")) {
						// 2000版条款
						prpLlossDto.setSumRealPay(dblSumLossRest * dblIndemnityDutyRate / 100 * (1 - dblDeductRate));
					} else {
						// 2003版条款
						prpLlossDto.setSumRealPay(dblSumLossRest * dblIndemnityDutyRate / 100 * (1 - dblDeductRate));
//						prpLlossDto.setDeductible(dblSumLossRest * dblIndemnityDutyRate / 100 * dblDeductRate);
						if (prpLlossDto.getSumRealPay() > prpLlossDto.getItemValue()) {
							prpLlossDto.setSumRealPay(prpLlossDto.getItemValue());
						}
					}
				} else // 按投保时保险车辆的实际价值确定保险金额或协商确定保额
				{
					if (prpLlossDto.getAmount() < PrpCitemCarDto.getPurchasePrice()) {
						if (prpLclaimDto.getEscapeFlag().length() > 1
								&& prpLclaimDto.getEscapeFlag().substring(1, 2).equals("Y")
								&& (strRiskCode.equals(uiCodeAction.translateProductCode("RISKCODE_DAA"))
										||strRiskCode.equals(uiCodeAction.translateProductCode("RISKCODE_DAX"))
										||strRiskCode.equals(uiCodeAction.translateProductCode("RISKCODE_DAT")))) {
							prpLlossDto.setClaimRate(100);
						} else {
							prpLlossDto.setClaimRate(prpLlossDto.getAmount() * 100 / PrpCitemCarDto.getPurchasePrice());
						}
					}
					// 摩托车、拖拉机赔偿比例为100%   //add by liuyanmei
					if ("D".equals(strRiskType)
							|| PrpCitemCarDto.getClauseType().equals("F34")
							|| PrpCitemCarDto.getClauseType().equals("F35")) {
						prpLlossDto.setClaimRate(100);
					}
					if (PrpCitemCarDto.getClauseType().equals("F11")) {
						// 2000版条款
						prpLlossDto.setSumRealPay(dblSumLossRest * dblIndemnityDutyRate / 100
								* prpLlossDto.getClaimRate() / 100 * (1 - dblDeductRate));
					} else {
						// 2003版条款
						// 免赔率不同
						prpLlossDto.setSumRealPay(dblSumLossRest * dblIndemnityDutyRate / 100 * prpLlossDto.getClaimRate() / 100 * (1 - dblDeductRate));
//						prpLlossDto.setDeductible(dblSumLossRest * dblIndemnityDutyRate / 100 * prpLlossDto.getClaimRate() / 100 * dblDeductRate);
						if (prpLlossDto.getSumRealPay() > prpLlossDto.getItemValue()) {
							prpLlossDto.setSumRealPay(prpLlossDto.getItemValue());
						}
					}
				}
			}

			// 机动车辆第三者责任险
			if (prpLlossDto.getKindCode().equals("B")) {
				// dblDeductRate绝对免赔率
				// DutyDeductibleRate责任免赔率
				prpLlossDto.setClaimRate(100);
				if (prpLlossDto.getSumLoss() * dblIndemnityDutyRate / 100 > prpLlossDto.getAmount()) // 赔款=赔偿限额×（1-事故责任免赔率）×（1-绝对免赔率）
				{
					prpLlossDto.setSumRealPay(prpLlossDto.getAmount() * (1 - dblDeductRate)
							* (1 - prpLlossDto.getDutyDeductibleRate() / 100)); // modify
					// 20060106
//					prpLlossDto.setDeductible(prpLlossDto.getAmount() * dblDeductRate);

				} else // 赔款=应付赔偿金额(乘责任比例之后的)×（1-事故责任免赔率）×（1-绝对免赔率）
				{

					prpLlossDto.setSumRealPay(prpLlossDto.getSumLoss() * dblIndemnityDutyRate / 100
							* (1 - dblDeductRate) * (1 - prpLlossDto.getDutyDeductibleRate() / 100));// modify
					// 20060106
//					prpLlossDto.setDeductible(prpLlossDto.getSumLoss() * dblIndemnityDutyRate / 100 * dblDeductRate);

				}

			}

			// 全车盗抢险，计算方式按附加盗抢方式计算
			if (prpLlossDto.getKindCode().equals("C")) {
				// prpLlossDto.setSumRealPay(dblSumLossRest *
				// dblIndemnityDutyRate/100 * (1-dblDeductRate));
				// prpLlossDto.setDeductible(dblSumLossRest *
				// dblIndemnityDutyRate/100 * dblDeductRate);

				if (prpLclaimDto.getEscapeFlag().length() > 1
						&& prpLclaimDto.getEscapeFlag().substring(1, 2).equals("Y")
						&& (strRiskCode.equals(uiCodeAction.translateProductCode("RISKCODE_DAA"))
								||strRiskCode.equals(uiCodeAction.translateProductCode("RISKCODE_DAX"))
								||strRiskCode.equals(uiCodeAction.translateProductCode("RISKCODE_DAT")))) {
					prpLlossDto.setSumRealPay(prpLlossDto.getAmount() * (1 - dblDeductRate));
				} else {
					prpLlossDto.setSumRealPay(prpLlossDto.getSumLoss() - prpLlossDto.getSumRest());
//					prpLlossDto.setDeductible(0);
				}

				if (prpLlossDto.getSumRealPay() > prpLlossDto.getAmount()) {
					prpLlossDto.setSumRealPay(prpLlossDto.getAmount());
				}
				prpLlossDto.setClaimRate(100);
				prpLlossDto.setIndemnityDutyRate(100);
				prpLlossDto.setArrangeRate(100);
			}

			// 盗抢险
			if (prpLlossDto.getKindCode().equals("G")) {
				if (prpLclaimDto.getEscapeFlag().length() > 1
						&& prpLclaimDto.getEscapeFlag().substring(1, 2).equals("Y")
						&& (strRiskCode.equals(uiCodeAction.translateProductCode("RISKCODE_DAA"))
								||strRiskCode.equals(uiCodeAction.translateProductCode("RISKCODE_DAX"))
								||strRiskCode.equals(uiCodeAction.translateProductCode("RISKCODE_DAT")))) {
					prpLlossDto.setSumRealPay(prpLlossDto.getAmount() * (1 - dblDeductRate));
				} else {
					prpLlossDto.setSumRealPay(prpLlossDto.getSumLoss() - prpLlossDto.getSumRest());
					prpLlossDto.setDeductible(0);
				}
				if (prpLlossDto.getSumRealPay() > prpLlossDto.getAmount()) {
					prpLlossDto.setSumRealPay(prpLlossDto.getAmount());
				}
				prpLlossDto.setClaimRate(100);
				prpLlossDto.setIndemnityDutyRate(100);
				prpLlossDto.setArrangeRate(100);
				// prpLlossDto.setDeductible(0);
			}

			// 玻璃单独破碎险
			if (prpLlossDto.getKindCode().equals("F")) {
				prpLlossDto.setSumRealPay(prpLlossDto.getSumLoss());
//				prpLlossDto.setDeductible(0);
				prpLlossDto.setClaimRate(100);
				prpLlossDto.setIndemnityDutyRate(100);
				prpLlossDto.setArrangeRate(100);
			}

			// 火灾、爆炸、自燃损失险
			if (prpLlossDto.getKindCode().equals("E")) {
				prpLlossDto.setSumRealPay(dblSumLossRest * (1 - dblDeductRate));
//				prpLlossDto.setDeductible(dblSumLossRest * dblDeductRate);
				if (prpLlossDto.getSumRealPay() > prpLlossDto.getAmount()) {
					prpLlossDto.setSumRealPay(prpLlossDto.getAmount());
				}
				prpLlossDto.setClaimRate(100);
				prpLlossDto.setIndemnityDutyRate(100);
				prpLlossDto.setArrangeRate(100);
			}

			// 自燃损失险
			if (prpLlossDto.getKindCode().equals("Z")) {
				prpLlossDto.setSumRealPay(dblSumLossRest * (1 - dblDeductRate));
//				prpLlossDto.setDeductible(dblSumLossRest * dblDeductRate);
				if (prpLlossDto.getSumRealPay() > prpLlossDto.getAmount()) {
					prpLlossDto.setSumRealPay(prpLlossDto.getAmount());
				}
				prpLlossDto.setClaimRate(100);
				prpLlossDto.setIndemnityDutyRate(100);
				prpLlossDto.setArrangeRate(100);
			}

			// 车身划痕损失险 //////冲减保额
			if (prpLlossDto.getKindCode().equals("L")) {
				prpLlossDto.setSumRealPay(prpLlossDto.getSumLoss());
				if (prpLlossDto.getSumRealPay() > prpLlossDto.getAmount()) {
					prpLlossDto.setSumRealPay(prpLlossDto.getAmount());
				}
				prpLlossDto.setClaimRate(100);
				prpLlossDto.setIndemnityDutyRate(100);
				prpLlossDto.setArrangeRate(100);
//				prpLlossDto.setDeductibleRate(0);
			}

			// 车辆停驶损失险 //////冲减最高赔偿天数
			if (prpLlossDto.getKindCode().equals("T")) {
				if (prpLlossDto.getLossQuantity() > prpCitemKindDto.getQuantity()) {
					prpLlossDto.setSumRealPay(prpCitemKindDto.getUnitAmount() * prpCitemKindDto.getQuantity());
				} else {
					prpLlossDto.setSumRealPay(prpCitemKindDto.getUnitAmount() * prpLlossDto.getLossQuantity());
				}
				prpLlossDto.setClaimRate(100);
				prpLlossDto.setIndemnityDutyRate(100);
				prpLlossDto.setArrangeRate(100);
//				prpLlossDto.setDeductibleRate(0);
			}

			// 车载货物掉落责任险
			if (prpLlossDto.getKindCode().equals("H")) {
				if (prpLlossDto.getSumLoss() <= prpLlossDto.getAmount()) {
					prpLlossDto.setSumRealPay(prpLlossDto.getSumLoss() * (1 - dblDeductRate));
//					prpLlossDto.setDeductible(prpLlossDto.getSumLoss() * dblDeductRate);
				} else {
					prpLlossDto.setSumRealPay(prpLlossDto.getAmount() * (1 - dblDeductRate));
//					prpLlossDto.setDeductible(prpLlossDto.getAmount() * dblDeductRate);
				}
				prpLlossDto.setClaimRate(100);
			}

			// 新增加设备损失险
			if (prpLlossDto.getKindCode().equals("X")) {
				if (PrpCitemCarDto.getClauseType().equals("F11")) {
					// 2000版条款
					if (prpLlossDto.getSumLoss() <= prpLlossDto.getAmount()) {
						prpLlossDto.setSumRealPay(dblSumLossRest * dblIndemnityDutyRate / 100 * (1 - dblDeductRate));
					} else {
						prpLlossDto.setSumRealPay(prpLlossDto.getAmount() - prpLlossDto.getSumRest()
								* dblIndemnityDutyRate / 100 * (1 - dblDeductRate));
					}
				} else {
					prpLlossDto.setSumRealPay(0.00);
				}
			}

			// 车上人员责任险
			if (prpLlossDto.getKindCode().equals("D1")) {
				if (!PrpCitemCarDto.getClauseType().equals("F11")) {
					// 2003版条款
					prpLlossDto.setSumRealPay(prpLlossDto.getSumLoss() * dblIndemnityDutyRate / 100);
					if (prpLlossDto.getSumRealPay() > prpLlossDto.getAmount()) {
						prpLlossDto.setSumRealPay(prpLlossDto.getAmount());
					}
					prpLlossDto.setClaimRate(100);
//					prpLlossDto.setDeductibleRate(0);
					prpLlossDto.setDeductible(0);
				} else {
					// 2000版条款
					prpLlossDto.setSumRealPay(prpLlossDto.getSumLoss() * dblIndemnityDutyRate / 100
							* (1 - dblDeductRate));
					if (prpLlossDto.getSumRealPay() > prpLlossDto.getAmount()) {
						prpLlossDto.setSumRealPay(prpLlossDto.getAmount() * (1 - dblDeductRate));
					}
				}
			}

			// 车上货物责任险 //2000版和2003版的免赔率不同
			if (prpLlossDto.getKindCode().equals("D2")) {
				prpLlossDto.setSumRealPay(prpLlossDto.getSumLoss() * dblIndemnityDutyRate / 100 * (1 - dblDeductRate));
//				prpLlossDto.setDeductible(prpLlossDto.getSumLoss() * dblIndemnityDutyRate / 100 * dblDeductRate);
				if (prpLlossDto.getSumRealPay() > prpLlossDto.getAmount()) {
					prpLlossDto.setSumRealPay(prpLlossDto.getAmount() * (1 - dblDeductRate));
				}
			}
			prpLlossDto.setClaimRate(100);

			// 无过失责任险
			if (prpLlossDto.getKindCode().equals("W")) {
				if (prpLlossDto.getSumLoss() <= prpLlossDto.getAmount()) {
					prpLlossDto.setSumRealPay(prpLlossDto.getSumLoss() * (1 - dblDeductRate));
//					prpLlossDto.setDeductible(prpLlossDto.getSumLoss() * dblDeductRate);
				} else {
					prpLlossDto.setSumRealPay(prpLlossDto.getAmount() * (1 - dblDeductRate));
//					prpLlossDto.setDeductible(prpLlossDto.getSumLoss() * dblDeductRate);
				}
				prpLlossDto.setClaimRate(100);
			}

			// 救助险计算赔付金额
			if (prpLlossDto.getKindCode().equals("J")) {
				prpLlossDto.setSumRealPay(prpLlossDto.getSumLoss());
				prpLlossDto.setDeductible(0);
			}
			// 车险全损
			if (prpLclaimDto.getEscapeFlag() != null && prpLclaimDto.getEscapeFlag().length() > 1) {
				if (prpLclaimDto.getEscapeFlag().substring(1, 2).equals("Y")) {
					// this.calculateCarLoss(prpLlossDto.get*) RETURNING
					// prpLlossDto.get*;
				}
			}

			// 不计免赔特约条款
			if (prpLlossDto.getKindCode().equals("M")) {
				// this.CalculateNoFranchise(prpLlossDto.get*) RETURNING
				// prpLlossDto.getSumRealPay
			}
		} else {
			if (strRiskCode.substring(0, 2).equals("YD")) {
				dblDeductible1 = prpLlossDto.getAmount() * prpLlossDto.getDeductibleRate() / 100;
			} else {
				dblDeductible1 = prpLlossDto.getSumLoss() * prpLlossDto.getDeductibleRate() / 100;
			}
			if (dblDeductible > dblDeductible1) {
				prpLlossDto.setSumRealPay((dblSumRealPay * dblRate - dblDeductible));
			} else {
				prpLlossDto.setSumRealPay((dblSumRealPay * dblRate - dblDeductible1));
			}
		}

		if (prpLlossDto.getSumRealPay() < 0) {
			prpLlossDto.setSumRealPay(0);
		}
		return prpLlossDto;
	}

	/**
	 * 出新的赔款计算数的时候初始化赔付标的的信息
	 * 
	 * @throws Exception
	 */
	public ArrayList initLossItem(HttpServletRequest httpServletRequest, String claimNo, ClaimDto claimDto)
			throws Exception {
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		ArrayList prpLdeductCondList = UIDeductCondAction.getInstance().getDeductCondList(httpServletRequest,true);
		
		// PrpLlossDto prpLlossDto = new PrpLlossDto();
		// PrpCitemKindDto prpCitemKindDtoTemp = new PrpCitemKindDto();

		UICodeAction uiCodeAction = new UICodeAction();
		// 报案号码
		String registNo = uiCodeAction.translateBusinessCode(claimNo, false);
		CertainLossDto certainLossDto = uiCertainLossAction.findByPrimaryKey(registNo);
		// 定义变量部分
		String strRiskCode = claimDto.getPrpLclaimDto().getRiskCode();
		String  configCode =uiCodeAction.translateRiskCodetoConfigCode(strRiskCode);
		
		
		boolean isChinese = true; // 中英文保单标志
		String strCode = "";
		String strName = "";
		String strClaimNo = claimNo;
		String strCond = "";

		// 定义对象
		PrpLclaimDto prpLclaimDto = claimDto.getPrpLclaimDto();
		PrpLthirdPartyDto prpLthirdPartyDto = null;
		PrpCitemCarDto PrpCitemCarDto = null;

		PrpLlossDto prpLlossDto = null;
		PrpLpropDto prpLpropDto = null;
		PrpLrepairFeeDto prpLrepairFeeDto = null;
		PrpLcomponentDto prpLcomponentDto = null;
		PrpCitemKindDto prpCitemKindDto = null;

		Hashtable hashRepComFee = new Hashtable(); // 按币别汇总的修理费和换件费
		Hashtable hashRepSumRest = new Hashtable();
		String strFlag = "";
		double strItemValue = 0;
		int serialNo = 0;
		double strIndemnityDutyRate = 0;
		String strLicenseNo = "";
		String strRepComKindCode = "";
		String strRepComLicenseNo = "";
		int strRepComItemKindNo = 0;
		String[] arrKindCode = null; // 汇总险别
		String[] arrLossFeeType = null; // 01：修理费 02：材料费
		String[] arrLossFeeTypeName = null; // 01：修理费 02：材料费
		String[] arrItemKindNo = null; // 汇总标的序号
		String[] arrLicenseNo = null; // 汇总车牌号
		double[] arrSumDefFee = null; // 汇总金额
		double[] arrSumRest = null; // 汇总残值
		double dbRepComSumDefFee = 0d;
		double dbRepComSumRest = 0d;
		int intRepFeeCount = 0; // 按险别,车牌号汇总后的修理费
		int intComFeeCount = 0; // 按险别,车牌号汇总后的材料费
		int intLossCount = 0; // 赔付标的记录数
		int intPropCount = 0;
		int intRepairFeeCount = 0;
		int intComponentCount = 0;
		int intItemKindCount = 0;
		int intThirdPartyCount = 0;
		int index = 0;
		int index1 = 0;
		int index2 = 0;
		int j = 0;
		ArrayList prpLlossListTemp = new ArrayList();

		//		判断是否已出过计算书且核赔通过，如果是这样，再出计算书，不需要带出人伤定损信息-----------------|
		String compensateFlag = "";
		String conditions = "  claimNo = '" + claimNo + "'";
		UICompensateAction uiCompensateAction = new UICompensateAction();
		Collection compensateDtoList = new ArrayList();
		compensateDtoList = uiCompensateAction.findByClaimNo(conditions);

		if ((!compensateDtoList.isEmpty()) && compensateDtoList.size() > 0) { //出过计算书
			Iterator list = compensateDtoList.iterator();
			while (list.hasNext()) {
				PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto) list.next();
				if (prpLcompensateDto.getUnderWriteFlag().equals("1")
						|| prpLcompensateDto.getUnderWriteFlag().equals("3")) {
					compensateFlag = "1";
					break;
				} else {
					compensateFlag = "0";
					continue;
				}
			}
		} else { //没出过计算书
			compensateFlag = "0";
		}

		

		if (compensateFlag.equals("1")) {
		} else {
			// reason:增加自负额
			boolean bFlag = false;
			strCond = " ClaimNo ='" + strClaimNo + "' ";
			if (certainLossDto.getPrpLpropDtoList() != null) {
				intPropCount = certainLossDto.getPrpLpropDtoList().size();
			}
			if (certainLossDto.getPrpLrepairFeeDtoList() != null) {
				intRepairFeeCount = certainLossDto.getPrpLrepairFeeDtoList().size();
			}
			if (certainLossDto.getPrpLcomponentDtoList() != null) {
				intComponentCount = certainLossDto.getPrpLcomponentDtoList().size();
			}

			// 按险种,车牌,标的序号汇总修理费和材料费用
			if (intRepairFeeCount > 0) {
				for (j = 0; j < intRepairFeeCount; j++) {
					PrpLrepairFeeDto prpLrepairFeeDtoTemp = (PrpLrepairFeeDto) certainLossDto.getPrpLrepairFeeDtoList()
							.get(j);
					if("RISKCODE_DAZ".equals(configCode)||"RISKCODE_DAY".equals(configCode)||"RISKCODE_DAU".equals(configCode)){ //如果是交强险
						if("K".equals(claimDto.getPrpLclaimDto().getClaimType())){      // 如果是互碰自赔
							if("2".equals(prpLrepairFeeDtoTemp.getLossItemCode())){		// 如果是三者车的修理费不带过去
								continue;
							}
							strRepComKindCode ="BZ";
						}
						else{															// 不是互碰自赔
							if(("1").equals(prpLrepairFeeDtoTemp.getLossItemCode())){	// 如果是标的车的修理费不带过去
								continue;
							}
							if ("B".equals(prpLrepairFeeDtoTemp.getKindCode())){
								strRepComKindCode ="BZ";
							}
							else{
								strRepComKindCode = prpLrepairFeeDtoTemp.getKindCode();
							}
						}
					}
					else{ //如果是商业险 走原来流程
						if ("BZ".equals(prpLrepairFeeDtoTemp.getKindCode())){
							strRepComKindCode ="B" ;
						}else{
							strRepComKindCode = prpLrepairFeeDtoTemp.getKindCode();
						}
					}
					
					
					strRepComLicenseNo = prpLrepairFeeDtoTemp.getLicenseNo();
					strRepComItemKindNo = (int) prpLrepairFeeDtoTemp.getItemKindNo();

					if ((Double) hashRepComFee.get("01," + strRepComKindCode + "," + strRepComLicenseNo + ","
							+ strRepComItemKindNo) != null) {
						dbRepComSumDefFee = ((Double) hashRepComFee.get("01," + strRepComKindCode + ","
								+ strRepComLicenseNo + "," + strRepComItemKindNo)).doubleValue();
						dbRepComSumDefFee += prpLrepairFeeDtoTemp.getVeriSumLoss();
						hashRepComFee.put("01," + strRepComKindCode + "," + strRepComLicenseNo + ","
								+ strRepComItemKindNo, new Double(dbRepComSumDefFee));
					} else {
						hashRepComFee.put("01," + strRepComKindCode + "," + strRepComLicenseNo + ","
								+ strRepComItemKindNo, new Double(prpLrepairFeeDtoTemp.getVeriSumLoss()));
					}
				}
			}
			intRepFeeCount = hashRepComFee.size(); // 按币别，险别汇总后的修理费

			

			if (intComponentCount > 0) {
				for (j = 0; j < intComponentCount; j++) {
					PrpLcomponentDto prpLcomponentDtoTemp = (PrpLcomponentDto) certainLossDto.getPrpLcomponentDtoList()
							.get(j);
					
					if("RISKCODE_DAZ".equals(configCode)||"RISKCODE_DAY".equals(configCode)
							||"RISKCODE_DAU".equals(configCode)){ //如果是交强险
						if("K".equals(claimDto.getPrpLclaimDto().getClaimType())){      // 如果是互碰自赔
							if("2".equals(prpLcomponentDtoTemp.getLossItemCode())){		// 如果是三者车的修理费不带过去
								continue;
							}
							strRepComKindCode ="BZ";
						}
						else{															// 不是互碰自赔
							if(("1").equals(prpLcomponentDtoTemp.getLossItemCode())){	// 如果是标的车的修理费不带过去
								continue;
							}
							if ("B".equals(prpLcomponentDtoTemp.getKindCode())){
								strRepComKindCode ="BZ";
							}
							else{
								strRepComKindCode = prpLcomponentDtoTemp.getKindCode();
							}
						}
					}
					else{ //如果是商业险 走原来流程
						if ("BZ".equals(prpLcomponentDtoTemp.getKindCode())){
							strRepComKindCode ="B" ;
						}else{
							strRepComKindCode = prpLcomponentDtoTemp.getKindCode();
						}
					}
					/*
					  if ("RISKCODE_DAZ".equals(configCode) && ("B".equals(prpLcomponentDtoTemp.getKindCode())|| "BZ".equals(prpLcomponentDtoTemp.getKindCode()))){
							strRepComKindCode ="BZ";
						}else if ("BZ".equals(prpLcomponentDtoTemp.getKindCode())){
							strRepComKindCode ="B" ;
						}else{
							strRepComKindCode = prpLcomponentDtoTemp.getKindCode();
					  }
					 */
					
					strRepComLicenseNo = prpLcomponentDtoTemp.getLicenseNo();
					strRepComItemKindNo = (int) prpLcomponentDtoTemp.getItemKindNo();

					if ((Double) hashRepComFee.get("02," + strRepComKindCode + "," + strRepComLicenseNo + ","
							+ strRepComItemKindNo) != null) {

						dbRepComSumDefFee = ((Double) hashRepComFee.get("02," + strRepComKindCode + ","
								+ strRepComLicenseNo + "," + strRepComItemKindNo)).doubleValue();

						dbRepComSumDefFee += prpLcomponentDtoTemp.getSumVeriLoss();
						//dbRepComSumDefFee += prpLcomponentDtoTemp.getVerpCompPrice(); //各零配件的核价累加 +还得加上prplcarloss中的三金和残值

						hashRepComFee.put("02," + strRepComKindCode + "," + strRepComLicenseNo + ","
								+ strRepComItemKindNo, new Double(dbRepComSumDefFee));
					} else {

						hashRepComFee.put("02," + strRepComKindCode + "," + strRepComLicenseNo + ","
								+ strRepComItemKindNo,
						new Double(prpLcomponentDtoTemp.getSumVeriLoss()));
							//new Double(prpLcomponentDtoTemp.getVerpCompPrice())); //modify 20060316
					}
					if ((Double) hashRepSumRest.get("rest_02," + strRepComKindCode + "," + strRepComLicenseNo + ","+ strRepComItemKindNo) != null) {
						dbRepComSumRest = ((Double) hashRepSumRest.get("rest_02," + strRepComKindCode + ","+ strRepComLicenseNo + "," + strRepComItemKindNo)).doubleValue();
						dbRepComSumRest += prpLcomponentDtoTemp.getSumReject();
						hashRepSumRest.put("rest_02," + strRepComKindCode + "," + strRepComLicenseNo + ","+ strRepComItemKindNo, new Double(dbRepComSumRest));
					} else {
						hashRepSumRest.put("rest_02," + strRepComKindCode + "," + strRepComLicenseNo + ","+ strRepComItemKindNo,new Double(prpLcomponentDtoTemp.getSumReject()));
					}
				}

			}

			int m = 0;
			double dbComFee = 0d;
			double dbSumReset = 0d;

			ArrayList prpLcarLossDtoList = new ArrayList();
			prpLcarLossDtoList = certainLossDto.getPrpLcarLossDtoList();

			if (prpLcarLossDtoList != null && prpLcarLossDtoList.size() > 0) {
				for (m = 0; m < prpLcarLossDtoList.size(); m++) {
					PrpLcarLossDto prpLcarLossDto = (PrpLcarLossDto) prpLcarLossDtoList.get(m);
					String strKindCode = "";
					int strItemKindNo = -1;
					String strLicenseNo1 = "";
					for (j = 0; j < intComponentCount; j++) {
						PrpLcomponentDto prpLcomponentDtoTemp = (PrpLcomponentDto) certainLossDto
								.getPrpLcomponentDtoList().get(j);
					
						if (prpLcomponentDtoTemp.getLossItemCode().equals(prpLcarLossDto.getLossItemCode())) {
							if (("RISKCODE_DAZ".equals(configCode)||"RISKCODE_DAY".equals(configCode)||"RISKCODE_DAU".equals(configCode)) && ("B".equals(prpLcomponentDtoTemp.getKindCode())|| "BZ".equals(prpLcomponentDtoTemp.getKindCode()))){
								strKindCode ="BZ";
							}else if ("BZ".equals(prpLcomponentDtoTemp.getKindCode())){
								strKindCode ="B" ;
							}else{
								strKindCode=prpLcomponentDtoTemp.getKindCode();
							}
							
							
							//strKindCode = prpLcomponentDtoTemp.getKindCode();
							strItemKindNo = (int) prpLcomponentDtoTemp.getItemKindNo();
							strLicenseNo1 = prpLcomponentDtoTemp.getLicenseNo();
						}

					}
					if ((Double) hashRepComFee.get("02," + strKindCode + "," + strLicenseNo1 + "," + strItemKindNo) != null) {
						dbComFee = ((Double) hashRepComFee.get("02," + strKindCode + "," + strLicenseNo1 + ","+ strItemKindNo)).doubleValue();
						dbComFee += prpLcarLossDto.getSumManager() + prpLcarLossDto.getSumTax()+ prpLcarLossDto.getSumTransFee() ;//- prpLcarLossDto.getSumRest(); //各零配件的核价累加 +还得加上prplcarloss中的三金和残值
						hashRepComFee.put("02," + strKindCode + "," + strLicenseNo1 + "," + strItemKindNo, new Double(dbComFee));
					}
					if ((Double) hashRepSumRest.get("rest_02," + strKindCode + "," + strLicenseNo1 + "," + strItemKindNo) != null) {
						dbSumReset = ((Double) hashRepSumRest.get("rest_02," + strKindCode + "," + strLicenseNo1 + ","+ strItemKindNo)).doubleValue();
						dbSumReset += prpLcarLossDto.getSumVeriRest();
						hashRepSumRest.put("rest_02," + strKindCode + "," + strLicenseNo1 + "," + strItemKindNo, new Double(dbSumReset));
					}
				}
			}

			//------------------------------------------------------

			intComFeeCount = hashRepComFee.size() - intRepFeeCount; // 按险别,车牌号，标的序号汇总后的材料费

			arrKindCode = new String[intRepFeeCount + intComFeeCount];
			arrLossFeeType = new String[intRepFeeCount + intComFeeCount];
			arrLossFeeTypeName = new String[intRepFeeCount + intComFeeCount];
			arrLicenseNo = new String[intRepFeeCount + intComFeeCount];
			arrItemKindNo = new String[intRepFeeCount + intComFeeCount];
			arrSumDefFee = new double[intRepFeeCount + intComFeeCount];
			arrSumRest = new double[intRepFeeCount + intComFeeCount];
			int k = 0;
			Enumeration eSumEle = hashRepComFee.keys();
			while (eSumEle.hasMoreElements()) {
				String strElement = (String) eSumEle.nextElement();
				int intIndex1 = strElement.indexOf(",", 3);
				int intIndex2 = strElement.indexOf(",", intIndex1 + 1);
				arrLossFeeType[k] = strElement.substring(0, 2);
				arrKindCode[k] = strElement.substring(3, intIndex1);
				arrLicenseNo[k] = strElement.substring(intIndex1 + 1, intIndex2);
				arrItemKindNo[k] = strElement.substring(intIndex2 + 1);

				arrSumDefFee[k] = ((Double) hashRepComFee.get(strElement)).doubleValue();
				if(hashRepSumRest.containsKey("rest_" + strElement)){
					arrSumRest[k] = ((Double) hashRepSumRest.get("rest_" + strElement)).doubleValue();
				}else{
					arrSumRest[k] = 0;
				}
				
				k++;
			}

			for (k = 0; k < arrLossFeeType.length; k++) {
				if (arrLossFeeType[k].equals("01"))
					arrLossFeeTypeName[k] = "修理费";
				else
					// "02"
					arrLossFeeTypeName[k] = "材料费";
			}

			// 得到机动车险险别信息
			// blPrpCitemKind =
			// ((BLPolicy)httpServletRequest.getAttribute("Policy")).getBLPrpCitemKind();
			// 保单号码
			String policyNo = claimDto.getPrpLclaimDto().getPolicyNo();
			// 得到险别估损信息
			ArrayList prplClaimLossDtoList = new ArrayList();
			prplClaimLossDtoList = claimDto.getPrpLclaimLossDtoList();
			// 取得保单的信息
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo, claimDto.getPrpLclaimDto()
					.getDamageStartDate().toString(), claimDto.getPrpLclaimDto().getDamageStartHour());

			if (policyDto.getPrpCitemKindDtoList() != null) {
				intItemKindCount = policyDto.getPrpCitemKindDtoList().size();
			}

			// 得到理赔车辆信息
			// BLPrpLthirdParty bLPrpLthirdParty = new BLPrpLthirdParty();
			// bLPrpLthirdParty.query(" ClaimNo='"+strClaimNo+"'");
			if (claimDto.getPrpLthirdPartyDtoList() != null) {
				intThirdPartyCount = claimDto.getPrpLthirdPartyDtoList().size();
			}
			String strPersonLicenseNo = "";
			for (index = 0; index < intThirdPartyCount; index++) {
				prpLthirdPartyDto = (PrpLthirdPartyDto) claimDto.getPrpLthirdPartyDtoList().get(index);
				if (index == 0) {
					strPersonLicenseNo += prpLthirdPartyDto.getLicenseNo() + "_FIELD_SEPARATOR_"
							+ prpLthirdPartyDto.getLicenseNo();
				} else {
					strPersonLicenseNo += "_GROUP_SEPARATOR_" + prpLthirdPartyDto.getLicenseNo() + "_FIELD_SEPARATOR_"
							+ prpLthirdPartyDto.getLicenseNo();
				}
			}
			if (!((intPropCount + intRepFeeCount + intComFeeCount) == 0)) {
				/*
				 * var lossData1 = getPageData("Loss");
				 */

				// 得到赔付标的信息
				// modify begin zhanqiang
				double dblDeductibleRate = 0;
				double dblDutyDeductibleRate = 0;
				int kindFlag = 0;
				// BLPrpDdeductCond blPrpDdeductCond = new BLPrpDdeductCond();
				PrpLlossDto prpLlossDtoTmp = new PrpLlossDto();
				// BLCompensate blCompensate = new BLCompensate();

				String strDeductibleTerm = httpServletRequest.getParameter("DeductibleTerm");
                String citemKindCode ="";
				for (index = 0; index < intPropCount; index++) {
					
					strItemValue = 0;
					strIndemnityDutyRate = 0;
					serialNo++;
					prpLlossDto = new PrpLlossDto();
					prpLlossDtoTmp = new PrpLlossDto();
					prpLpropDto = (PrpLpropDto) certainLossDto.getPrpLpropDtoList().get(index);
					

					for (int i = 0; i < intItemKindCount; i++) {
						prpCitemKindDto = (PrpCitemKindDto) policyDto.getPrpCitemKindDtoList().get(i);
						if(!prpCitemKindDto.getKindCode().equals(prpLpropDto.getKindCode())){
							continue;
						}
						// 判断该险别是否为估损险别
						if (("RISKCODE_DAZ".equals(configCode)||"RISKCODE_DAY".equals(configCode)
								||"RISKCODE_DAU".equals(configCode)) && ("B".equals(prpCitemKindDto.getKindCode())|| "BZ".equals(prpCitemKindDto.getKindCode()))){
							citemKindCode ="BZ";
						}else if ("BZ".equals(prpCitemKindDto.getKindCode())){
							citemKindCode ="B" ;
						}else{
							citemKindCode=prpCitemKindDto.getKindCode();
						}
						kindFlag = this.getLossKind(citemKindCode, prplClaimLossDtoList);
						//if (kindFlag == 0)
						//	continue;
						if (citemKindCode.equals("A") || citemKindCode.equals("B")) {
							strItemValue = prpCitemKindDto.getAmount();
						}
						// reason:增加自负额
						if (prpCitemKindDto.getKindCode().equals("A") && prpCitemKindDto.getValue() > 0
								&& (prpLpropDto.getRiskCode().equals(uiCodeAction.translateProductCode("RISKCODE_DAA"))
										||prpLpropDto.getRiskCode().equals(uiCodeAction.translateProductCode("RISKCODE_DAX"))
										||prpLpropDto.getRiskCode().equals(uiCodeAction.translateProductCode("RISKCODE_DAT")))
								&& prpLpropDto.getKindCode().equals("A")) {
							bFlag = true;
						}

						//if (prpCitemKindDto.getItemKindNo() == prpLpropDto.getItemKindNo()) {
							break;
						//}
					}
					if (policyDto.getPrpCitemCarDtoList() != null && policyDto.getPrpCitemCarDtoList().size() > 0) {
						PrpCitemCarDto = (PrpCitemCarDto) (policyDto.getPrpCitemCarDtoList().get(0));
						strLicenseNo = PrpCitemCarDto.getLicenseNo();
					}
					//strCode = prpLpropDto.getKindCode();
					if (("RISKCODE_DAZ".equals(configCode)||"RISKCODE_DAY".equals(configCode)
							||"RISKCODE_DAU".equals(configCode)) && ("B".equals(prpLpropDto.getKindCode())|| "BZ".equals(prpLpropDto.getKindCode()))){
						strCode ="BZ";
					}else if ("BZ".equals(prpLpropDto.getKindCode())){
						strCode ="B" ;
					}else{
						strCode=prpLpropDto.getKindCode();
					}
					
					if (strCode.equals("A") || strCode.equals("B") || strCode.equals("X") || strCode.equals("D1")
							|| strCode.equals("D2") || strCode.equals("BZ")) {
						// if (blPrpLclaim.getSize()>0)
						// {
						strIndemnityDutyRate = prpLclaimDto.getIndemnityDutyRate();
						// }
					} else {
						strIndemnityDutyRate = 100;
					}
					UIDeductCondAction uiDeductCondAction = UIDeductCondAction.getInstance();
					if(policyDto.getPrpCmainDto().getOperateDate() == null){
                    	throw new UserException(0, 0, "保单生效期为空");
                    }
					
					/*
					for (int i = 0; i < intItemKindCount; i++) {
						System.out.println();
						System.out.println();
						System.out.println("00000====yyy======");
						System.out.println();
						System.out.println();
						PrpCitemKindDto	prpCitemKindDto1 = (PrpCitemKindDto) policyDto.getPrpCitemKindDtoList().get(i);
						if (strCode.equals(prpCitemKindDto1.getKindCode())){
							// 事故责任免赔率
							//prpCitemKind取新风险水平model modify by zhangwei start 2006-12-07
							if(prpCitemKindDto1.getModel()!=null&&!"".equals(prpCitemKindDto1.getModel())){
							    dblDutyDeductibleRate = uiDeductCondAction.getDeductibleRateOfAccident(
								    	prpLpropDto.getRiskCode(), 
								    	strCode, 
								    	claimDto.getPrpLclaimDto().getIndemnityDuty(), 
								    	prpCitemKindDto1.getModel(),
								    	policyDto.getPrpCmainDto().getOperateDate().toString());
							    //System.out.println("zwwwww viewhelper lossitem model"+dblDutyDeductibleRate);
							}else{
								dblDutyDeductibleRate = uiDeductCondAction.getDeductibleRateOfAccident(
										prpLpropDto.getRiskCode(), 
										strCode, 
										claimDto.getPrpLclaimDto().getIndemnityDuty(), 
										prpCitemKindDto1.getModeCode(),
										policyDto.getPrpCmainDto().getOperateDate().toString());
								//System.out.println("zwwwww viewhelper lossitem modeCode"+dblDutyDeductibleRate);
							}
						}
					}
					*/
					
					if(prpCitemKindDto.getModel()!=null&&!"".equals(prpCitemKindDto.getModel())){
					    dblDutyDeductibleRate = uiDeductCondAction.getDeductibleRateOfAccident(
						    	prpLpropDto.getRiskCode(), 
						    	strCode, 
						    	claimDto.getPrpLclaimDto().getIndemnityDuty(), 
						    	prpCitemKindDto.getModel(),
						    	policyDto.getPrpCmainDto().getOperateDate().toString());
					}else{
						dblDutyDeductibleRate = uiDeductCondAction.getDeductibleRateOfAccident(
								prpLpropDto.getRiskCode(), 
								strCode, 
								claimDto.getPrpLclaimDto().getIndemnityDuty(), 
								prpCitemKindDto.getModeCode(),
								policyDto.getPrpCmainDto().getOperateDate().toString());
					}
					// 绝对免赔率
					dblDeductibleRate = uiDeductCondAction.getDeductibleRateOfAbsolute(
							PrpCitemCarDto.getClauseType(), 
							strCode, 
							prpLdeductCondList, 
							prpLpropDto.getRiskCode(),
							policyDto.getPrpCmainDto().getOperateDate().toString());
					
								
					prpLlossDtoTmp.setRiskCode(prpLpropDto.getRiskCode());
					prpLlossDtoTmp.setPolicyNo(prpLpropDto.getPolicyNo());
					prpLlossDtoTmp.setCompensateNo(claimNo);
								
					prpLlossDtoTmp.setKindCode(strCode);
					prpLlossDtoTmp.setCurrency(prpLpropDto.getCurrency());
					prpLlossDtoTmp.setAmount(prpCitemKindDto.getAmount());
					prpLlossDtoTmp.setLossQuantity(prpLpropDto.getLossQuantity());
					prpLlossDtoTmp.setItemValue(strItemValue);
					prpLlossDtoTmp.setSumLoss(Number2(prpLpropDto.getVeriSumLoss()));
					prpLlossDtoTmp.setSumRest(Number2(prpLpropDto.getVeriSumReject()));
					prpLlossDtoTmp.setIndemnityDutyRate(strIndemnityDutyRate);
					prpLlossDtoTmp.setArrangeRate(100);
					prpLlossDtoTmp.setDeductibleRate(dblDeductibleRate);
					prpLlossDtoTmp.setDutyDeductibleRate(dblDutyDeductibleRate);

					prpLlossDtoTmp = calculateSumLoss(prpLlossDtoTmp);

					prpLlossDto.setSerialNo(serialNo);
					prpLlossDto.setAmount(prpCitemKindDto.getAmount());

					prpLlossDto.setLicenseNo("");
					prpLlossDto.setItemKindNo(prpLpropDto.getItemKindNo());
					prpLlossDto.setKindCode(strCode);
					
					
					
					
					prpLlossDto.setRiskCode(prpLpropDto.getRiskCode());
					prpLlossDto.setKindName(uiCodeAction.translateKindCode(prpLpropDto.getRiskCode(), strCode, true));
					prpLlossDto.setFeeTypeCode(prpLpropDto.getFeeTypeCode());
					prpLlossDto.setFeeTypeName(prpLpropDto.getFeeTypeName());
					prpLlossDto.setCurrency1(prpLpropDto.getCurrency());
					prpLlossDto.setCurrency1Name(uiCodeAction.translateCurrencyCode(prpLpropDto.getCurrency(), true));
					prpLlossDto.setCurrency(prpLpropDto.getCurrency());
					prpLlossDto.setCurrencyName(uiCodeAction.translateCurrencyCode(prpLpropDto.getCurrency(), true));
					prpLlossDto.setCurrency2(prpLpropDto.getCurrency());
					prpLlossDto.setCurrency2Name(uiCodeAction.translateCurrencyCode(prpLpropDto.getCurrency(), true));
					prpLlossDto.setCurrency3(prpLpropDto.getCurrency());
					prpLlossDto.setCurrency3Name(uiCodeAction.translateCurrencyCode(prpLpropDto.getCurrency(), true));
					prpLlossDto.setCurrency4(prpLpropDto.getCurrency());
					prpLlossDto.setCurrency4Name(uiCodeAction.translateCurrencyCode(prpLpropDto.getCurrency(), true));
					prpLlossDto.setLossName(prpLpropDto.getLossItemName());
					prpLlossDto.setUnitPrice(prpLpropDto.getUnitPrice());
					prpLlossDto.setLossQuantity(prpLpropDto.getLossQuantity());
					prpLlossDto.setItemValue(strItemValue);
					prpLlossDto.setSumLoss(prpLpropDto.getVeriSumLoss());
					prpLlossDto.setSumRest(prpLpropDto.getVeriSumReject());
					prpLlossDto.setIndemnityDutyRate(strIndemnityDutyRate);
					prpLlossDto.setArrangeRate(100);
					prpLlossDto.setClaimRate(prpLlossDtoTmp.getClaimRate());
					prpLlossDto.setDeductibleRate(prpLlossDtoTmp.getDeductibleRate());
					prpLlossDto.setDutyDeductibleRate(prpLlossDtoTmp.getDutyDeductibleRate());

					prpLlossDto.setDeductible(prpLlossDtoTmp.getDeductible());
					prpLlossDto.setSumRealPay(Number2(prpLlossDtoTmp.getSumRealPay()));
					// modify by zhanqiang
					prpLlossListTemp.add(prpLlossDto);
				}
				for (index1 = index; index1 < (intPropCount + intRepFeeCount + intComFeeCount); index1++) {
					strItemValue = 0;
					strIndemnityDutyRate = 0;
					k = 0;
					serialNo++;
					prpLlossDto = new PrpLlossDto();
					PrpLlossDto prpLlossDtoTemp = new PrpLlossDto();

					for (int i = 0; i < intItemKindCount; i++) {
						prpCitemKindDto = (PrpCitemKindDto) policyDto.getPrpCitemKindDtoList().get(i);
						// 显示的险别必须是立案中估损的险别

						if (prpCitemKindDto.getKindCode().equals("A") || prpCitemKindDto.getKindCode().equals("B")) {
							strItemValue = prpCitemKindDto.getAmount();
						}
						// reason:增加自负额
						if (prpCitemKindDto.getKindCode().equals("A") && prpCitemKindDto.getValue() > 0
								&& (strRiskCode.equals(uiCodeAction.translateProductCode("RISKCODE_DAA"))
										||strRiskCode.equals(uiCodeAction.translateProductCode("RISKCODE_DAX"))
										||strRiskCode.equals(uiCodeAction.translateProductCode("RISKCODE_DAT")))
								&& arrKindCode[index1 - index].equals("A")) {
							bFlag = true;
						}
						if (String.valueOf(prpCitemKindDto.getItemKindNo()).equals(arrItemKindNo[index1 - index])) {
							break;
						}
					}

					if (policyDto.getPrpCitemCarDtoList() != null && policyDto.getPrpCitemCarDtoList().size() > 0) {
						PrpCitemCarDto = (PrpCitemCarDto) (policyDto.getPrpCitemCarDtoList().get(0));
					}
					//strCode = arrKindCode[index1 - index];
					
					if (("RISKCODE_DAZ".equals(configCode)||"RISKCODE_DAY".equals(configCode)
							||"RISKCODE_DAU".equals(configCode)) && ("B".equals(arrKindCode[index1 - index])|| "BZ".equals(arrKindCode[index1 - index]))){
						strCode ="BZ";
					}else if ("BZ".equals(arrKindCode[index1 - index])){
						strCode ="B" ;
					}else{
						strCode = arrKindCode[index1 - index];
					}
						
					
					
					if (strCode.equals("A") || strCode.equals("B") || strCode.equals("X") || strCode.equals("D1")
							|| strCode.equals("D2")) {
						strIndemnityDutyRate = prpLclaimDto.getIndemnityDutyRate();
					} else {
						strIndemnityDutyRate = 100;
					}

					// 事故责任免赔率
					UIDeductCondAction uiDeductCondAction = UIDeductCondAction.getInstance();
					if(policyDto.getPrpCmainDto().getOperateDate() == null){
                    	throw new UserException(0, 0, "保单生效期为空");
                    }
					
					/*
					for (int i = 0; i < intItemKindCount; i++) {
						System.out.println();
						System.out.println();
						System.out.println("00000==========");
						System.out.println();
						System.out.println();
						PrpCitemKindDto	prpCitemKindDto1 = (PrpCitemKindDto) policyDto.getPrpCitemKindDtoList().get(i);
						if (strCode.equals(prpCitemKindDto1.getKindCode())){
							if(prpCitemKindDto1.getModel()!=null&&!"".equals(prpCitemKindDto1.getModel())){
							dblDutyDeductibleRate = uiDeductCondAction.getDeductibleRateOfAccident(
									strRiskCode, 
									strCode,
									prpLclaimDto.getIndemnityDuty(), 
						    			prpCitemKindDto1.getModel(), 
						    			policyDto.getPrpCmainDto().getOperateDate().toString());
							    //System.out.println("zwwwww viewhelper lossitem 2 model"+dblDutyDeductibleRate);
							}else{
								dblDutyDeductibleRate = uiDeductCondAction.getDeductibleRateOfAccident(
										strRiskCode, 
										strCode,
										prpLclaimDto.getIndemnityDuty(), 
										prpCitemKindDto1.getModeCode(), 
										policyDto.getPrpCmainDto().getOperateDate().toString());
								//System.out.println("zwwwww viewhelper lossitem 2 modeCode"+dblDutyDeductibleRate);
							}
						}
					}
					*/
					if(prpCitemKindDto.getModel()!=null&&!"".equals(prpCitemKindDto.getModel())){
						dblDutyDeductibleRate = uiDeductCondAction.getDeductibleRateOfAccident(
								strRiskCode, 
								strCode,
								prpLclaimDto.getIndemnityDuty(), 
					    			prpCitemKindDto.getModel(), 
					    			policyDto.getPrpCmainDto().getOperateDate().toString());
						}else{
							dblDutyDeductibleRate = uiDeductCondAction.getDeductibleRateOfAccident(
									strRiskCode, 
									strCode,
									prpLclaimDto.getIndemnityDuty(), 
									prpCitemKindDto.getModeCode(), 
									policyDto.getPrpCmainDto().getOperateDate().toString());
					}
					
					dblDeductibleRate = 0;
					dblDeductibleRate = uiDeductCondAction.getDeductibleRateOfAbsolute(
							PrpCitemCarDto.getClauseType(), 
							strCode,
							prpLdeductCondList, 
							strRiskCode,
							policyDto.getPrpCmainDto().getOperateDate().toString());
 
 
					prpLlossDto.setRiskCode(strRiskCode);
					prpLlossDto.setPolicyNo(prpCitemKindDto.getPolicyNo());
					prpLlossDto.setCompensateNo(prpLclaimDto.getClaimNo());
					prpLlossDto.setKindCode(strCode);
					prpLlossDto.setCurrency(prpLclaimDto.getCurrency());
					prpLlossDto.setAmount(prpCitemKindDto.getAmount());
					prpLlossDto.setLossQuantity(prpCitemKindDto.getQuantity());
					prpLlossDto.setItemValue(strItemValue);
					prpLlossDto.setSumLoss(Number2(arrSumDefFee[index1 - index]));
					prpLlossDto.setSumRest(Number2(arrSumRest[index1 - index]));
					prpLlossDto.setIndemnityDutyRate(strIndemnityDutyRate);
					prpLlossDto.setArrangeRate(100);
					
					prpLlossDto.setDeductibleRate(dblDeductibleRate);
					prpLlossDto.setDutyDeductibleRate(dblDutyDeductibleRate);
				
					
					prpLlossDto = calculateSumLoss(prpLlossDto);
					
					prpLlossDtoTemp.setSerialNo(serialNo);
					prpLlossDtoTemp.setRiskCode(prpLlossDto.getRiskCode());
					prpLlossDtoTemp.setAmount(prpCitemKindDto.getAmount());

					prpLlossDtoTemp.setLicenseNo(arrLicenseNo[index1 - index]);
					prpLlossDtoTemp.setItemKindNo((int) Double.parseDouble(arrItemKindNo[index1 - index]));
					
					
					prpLlossDtoTemp.setKindCode(strCode);
					prpLlossDtoTemp.setKindName(uiCodeAction.translateKindCode(prpLlossDto.getRiskCode(), prpLlossDtoTemp.getKindCode(), true));
					prpLlossDtoTemp.setFeeTypeCode(arrLossFeeType[index1 - index]);
					prpLlossDtoTemp.setFeeTypeName(arrLossFeeTypeName[index1 - index]);
					String currency = claimDto.getPrpLclaimDto().getCurrency();
					prpLlossDtoTemp.setCurrency1(currency);
					prpLlossDtoTemp.setCurrency1Name(uiCodeAction.translateCurrencyCode(currency, true));
					prpLlossDtoTemp.setCurrency(currency);
					prpLlossDtoTemp.setCurrencyName(uiCodeAction.translateCurrencyCode(currency, true));
					prpLlossDtoTemp.setCurrency2(currency);
					prpLlossDtoTemp.setCurrency2Name(uiCodeAction.translateCurrencyCode(currency, true));
					prpLlossDtoTemp.setCurrency3(currency);
					prpLlossDtoTemp.setCurrency3Name(uiCodeAction.translateCurrencyCode(currency, true));
					prpLlossDtoTemp.setCurrency4(currency);
					prpLlossDtoTemp.setCurrency4Name(uiCodeAction.translateCurrencyCode(currency, true));
					prpLlossDtoTemp.setLossName(prpCitemKindDto.getItemDetailName());
					prpLlossDtoTemp.setUnitPrice(prpCitemKindDto.getUnitAmount());
					prpLlossDtoTemp.setLossQuantity(prpCitemKindDto.getQuantity());
					prpLlossDtoTemp.setItemValue(strItemValue);
					prpLlossDtoTemp.setSumLoss(Number2(arrSumDefFee[index1 - index]));
					prpLlossDtoTemp.setSumRest(Number2(arrSumRest[index1 - index]));
					prpLlossDtoTemp.setIndemnityDutyRate(strIndemnityDutyRate);
					prpLlossDtoTemp.setArrangeRate(100);
					prpLlossDtoTemp.setClaimRate(prpLlossDto.getClaimRate());
					prpLlossDtoTemp.setDeductibleRate(prpLlossDto.getDeductibleRate());
					prpLlossDtoTemp.setDutyDeductibleRate(prpLlossDto.getDutyDeductibleRate());

					prpLlossDtoTemp.setDeductible(prpLlossDto.getDeductible());
					// modify 20051215 start \reason : 赔付标的信息中赔付金额值不对 ；
						
					double realPay = 0.00;
					realPay = (prpLlossDto.getSumLoss() - prpLlossDto.getSumRest())
							* (prpLlossDto.getClaimRate() * 0.01) * (prpLlossDto.getIndemnityDutyRate() * 0.01)
							* (1 - (prpLlossDto.getDutyDeductibleRate() * 0.01))
							* (1 - (prpLlossDto.getDeductibleRate() * 0.01));
					prpLlossDtoTemp.setSumRealPay(0);
					// prpLlossDtoTemp.setSumRealPay(prpLlossDto.getSumRealPay());
					// modify 20051215 end \reason : 赔付标的信息中赔付金额值不对 ；
					prpLlossListTemp.add(prpLlossDtoTemp);
				}

			}
		} //end if else		

		return prpLlossListTemp;
	}
	
	/**
	 * 对根据立案估损获得所有出险的险别信息的List进行排序
	 * @author dubang
	 *
	 */
	private static class getPrpcItemKindDtoLossListSort implements Comparator{
		public int compare(Object arg0, Object arg1) {
			int i=0;
			if(((PrpCitemKindDto)arg0).getKindCode().compareTo(((PrpCitemKindDto)arg1).getKindCode()) == 0){
				i=0;
			}else if(((PrpCitemKindDto)arg0).getKindCode().compareTo(((PrpCitemKindDto)arg1).getKindCode())< 0){
				i = -1;
			}else{
				i = 1;
			}
			return i;
		}
	}
	/**
	 * 根据立案估损获得所有出险的险别信息
	 * @param prpcItemKindDtoList
	 * @param prplClaimLossDtoList
	 * @return
	 * @throws Exception
	 */
	private List getPrpcItemKindDtoLossList(List prpcItemKindDtoList, List prplClaimLossDtoList) throws Exception {
		List getPrpcItemKindDtoLossList = new ArrayList();
		for (Iterator iter = prpcItemKindDtoList.iterator(); iter.hasNext();) {
			PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) iter.next();
//			if (getLossKind(prpCitemKindDto.getKindCode(), prplClaimLossDtoList) == 1) {
			//	if (!prpCitemKindDto.getKindCode().equals("D3") && !prpCitemKindDto.getKindCode().equals("D4")) {
					getPrpcItemKindDtoLossList.add(prpCitemKindDto);
			//	}
//			}
		}
		Collections.sort(getPrpcItemKindDtoLossList, new getPrpcItemKindDtoLossListSort());
		return getPrpcItemKindDtoLossList;
	}
	
	/**
	 * 获取险别是否为出险险别
	 * @param kindCode
	 * @param prplClaimLossDtoList
	 * @return
	 * @throws Exception
	 */
	private int getLossKind(String kindCode, List prplClaimLossDtoList) throws Exception {
		int kindFlag = 0;
		PrpLclaimLossDto prpLclaimLossDto;
		for (int i = 0; i < prplClaimLossDtoList.size(); i++) {
			prpLclaimLossDto = (PrpLclaimLossDto) prplClaimLossDtoList.get(i);
			if (prpLclaimLossDto.getKindCode().equals(kindCode)) {
				kindFlag = 1;
				break;
			}
		}
		return kindFlag;
	}
	
	
	private double Number2(double pDouble) {
		BigDecimal bd = new BigDecimal(pDouble);
		BigDecimal bd1 = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		pDouble = bd1.doubleValue();
		return pDouble;
	}









//------------------------------------
public int lossCompelInit(HttpServletRequest httpServletRequest,ArrayList prpLlossDtoList,ArrayList prpLprpLdangerItemList,int dangerItemSerialNo) throws Exception {
	
	PrpLdangerItemDto prpLdangerItemDto = null; // 标的DTO
        
	    // 赔付标的信息
	    PrpLlossDto prpLlossDto = new PrpLlossDto();
	    String[] propSerialNo      =  httpServletRequest.getParameterValues("propSerialNo");
		String[] propLicenseNo	   =  httpServletRequest.getParameterValues("propLicenseNo");
		String[] propName          =  httpServletRequest.getParameterValues("propName");
		String[] propFeeTypeCode   =  httpServletRequest.getParameterValues("propFeeTypeCode");
		String[] propFeeTypeName   =  httpServletRequest.getParameterValues("propFeeTypeName");
		String[] propSumLoss       =  httpServletRequest.getParameterValues("propSumLoss");
		String[] propEliminate     =  httpServletRequest.getParameterValues("propEliminate");
		String[] propSumDefPay     =  httpServletRequest.getParameterValues("propSumDefPay");
		String propIndemnityDutyRate = httpServletRequest.getParameter("prpLcompensateIndemnityDutyRate");	
		
		String[] prpLlossDtoSerialNo = httpServletRequest.getParameterValues("lossDtoSerialNo");
		String prpLlossDtoPolicyNo = httpServletRequest.getParameter("prpLcompensatePolicyNo");
		String prpLlossDtoRiskCode = httpServletRequest.getParameter("prpLcompensateRiskCode");
		String prpLlossDtoCompensateNo = (String) httpServletRequest.getAttribute("compensateNo");
		int    propindex=0;
		if (prpLlossDtoSerialNo==null)propindex=0;
		else propindex=prpLlossDtoSerialNo.length;

		if (propSerialNo  == null) {

		} else {
			for (int index = 1; index < propSerialNo.length; index++) {
				prpLlossDto = new PrpLlossDto();
				
				prpLlossDto.setPolicyNo(prpLlossDtoPolicyNo);
				
				prpLlossDto.setRiskCode(prpLlossDtoRiskCode);
				prpLlossDto.setCompensateNo(prpLlossDtoCompensateNo);
				prpLlossDto.setSerialNo(index+propindex-1);
				prpLlossDto.setKindCode("BZ");				
				prpLlossDto.setLicenseNo(propLicenseNo[index]);
				prpLlossDto.setFeeTypeCode(propFeeTypeCode[index]);
				prpLlossDto.setFeeTypeName(propFeeTypeName[index]);
				prpLlossDto.setSumLoss(Double.parseDouble(DataUtils.nullToZero(propSumLoss[index])));
				prpLlossDto.setSumRest(Double.parseDouble(DataUtils.nullToZero(propEliminate[index])));
				prpLlossDto.setCurrency("CNY");
				prpLlossDto.setCurrency1("CNY");
				prpLlossDto.setCurrency2("CNY");
				prpLlossDto.setCurrency3("CNY");
				prpLlossDto.setCurrency4("CNY");
				prpLlossDto.setLossName(propName[index]);
				prpLlossDto.setSumDefPay(Double.parseDouble(DataUtils.nullToZero(propSumDefPay[index]))) ;
				prpLlossDto.setSumRealPay(Double.parseDouble(DataUtils.nullToZero(propSumDefPay[index]))) ;
			
				prpLdangerItemDto = new PrpLdangerItemDto();
				prpLdangerItemDto.setCertiNo(prpLlossDtoCompensateNo); // 实赔号
				prpLdangerItemDto.setDangerNo(1); // 目前只有一个危险单位
				prpLdangerItemDto.setCurrency("CNY"); // 损失币别
				prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
				prpLdangerItemDto.setKindName("正常"); // 险别归类名称
				prpLdangerItemDto.setRiskCode(prpLlossDtoRiskCode); // 险别
				prpLdangerItemDto.setSerialNo(dangerItemSerialNo); // 标的序号
				dangerItemSerialNo++;
				prpLdangerItemDto.setSumPaid(Double.parseDouble(DataUtils.nullToZero(propSumDefPay[index]))); // 已决赔款
				prpLprpLdangerItemList.add(prpLdangerItemDto);
				prpLlossDtoList.add(prpLlossDto);				

				
			}
		}
		return  dangerItemSerialNo;
  }	
//---------------------------------------
public int  personLossCompelInit(HttpServletRequest httpServletRequest,ArrayList prpLpersonLossDtoList,ArrayList prpLprpLdangerItemList,int dangerItemSerialNo)  throws Exception{
	PrpLpersonLossDto prpLpersonLossDto = new PrpLpersonLossDto();
	
	PrpLdangerItemDto prpLdangerItemDto = null; // 标的DTO	
    // 赔付人员信息
	String prpLpersonLossCompensateNo = (String) httpServletRequest.getAttribute("compensateNo");
	String prpLpersonLossRiskCode = httpServletRequest.getParameter("prpLcompensateRiskCode");
	String prpLpersonLossPolicyNo = httpServletRequest.getParameter("prpLcompensatePolicyNo");
    // String[] personDeformitySerialNo    = httpServletRequest.getParameterValues("personDeformitySerialNo");
	String[] medicDeathFlag      = httpServletRequest.getParameterValues("medicDeathFlag");
    String[] personMedicalSerialNo      = httpServletRequest.getParameterValues("personMedicalSerialNo");
    String[] prpLpersonCommerceSerialNo = httpServletRequest.getParameterValues("prpLpersonCommerceSerialNo");
    String[] prpLpersonCommercePersonName  = httpServletRequest.getParameterValues("prpLpersonCommercePersonName");
    String[] prpLpersonCommerceSex       = httpServletRequest.getParameterValues("prpLpersonCommerceSex");
    String[] prpLpersonCommerceAge       = httpServletRequest.getParameterValues("prpLpersonCommerceAge");

    String[] prpLpersonMedicalDetailCode = httpServletRequest.getParameterValues("prpLpersonMedicalDetailCode");
    String[] prpLpersonMedicalDetailName = httpServletRequest.getParameterValues("prpLpersonMedicalDetailName");
    String[] prpLpersonMedicalSumLoss    = httpServletRequest.getParameterValues("prpLpersonMedicalSumLoss");
    String[] prpLpersonMedicalRejectSum  = httpServletRequest.getParameterValues("prpLpersonMedicalRejectSum");
    String[] prpLpersonMedicalSumDefPay  = httpServletRequest.getParameterValues("prpLpersonMedicalSumDefPay");
    String   mdCurrency="CNY";
    int         indexneedadd=1;


if (personMedicalSerialNo==null) {
} else {
		// 对象赋值
		for (int index = 1; index < personMedicalSerialNo.length; index++) {
			prpLpersonLossDto = new PrpLpersonLossDto();
			prpLpersonLossDto.setPolicyNo(prpLpersonLossPolicyNo);
			prpLpersonLossDto.setRiskCode(prpLpersonLossRiskCode);
			prpLpersonLossDto.setCompensateNo(prpLpersonLossCompensateNo);
			prpLpersonLossDto.setSerialNo(index);
			prpLpersonLossDto.setLiabDetailCode(prpLpersonMedicalDetailCode[index]);
			prpLpersonLossDto.setLiabDetailName(prpLpersonMedicalDetailName[index]);
			prpLpersonLossDto.setSumLoss(Double.parseDouble(DataUtils.nullToZero(prpLpersonMedicalSumLoss[index])));
			prpLpersonLossDto.setSumRest(Double.parseDouble(DataUtils.nullToZero(prpLpersonMedicalRejectSum[index])));
			prpLpersonLossDto.setCurrency(mdCurrency);
			prpLpersonLossDto.setCurrency1(mdCurrency);
			prpLpersonLossDto.setCurrency2(mdCurrency);
			prpLpersonLossDto.setCurrency4(mdCurrency);
		    prpLpersonLossDto.setFeeCategory(medicDeathFlag[index]); //medicDeathFlag =M\D;
			prpLpersonLossDto.setSumDefPay(Double.parseDouble(DataUtils.nullToZero(prpLpersonMedicalSumDefPay[index])));
			prpLpersonLossDto.setSumRealPay(Double.parseDouble(DataUtils.nullToZero(prpLpersonMedicalSumDefPay[index])));


		    for (int index2 = 1; index2 < prpLpersonCommerceSerialNo.length; index2++) {
				if (personMedicalSerialNo[index].equals(prpLpersonCommerceSerialNo[index2])) {
					prpLpersonLossDto.setSex(prpLpersonCommerceSex[index2]);
					prpLpersonLossDto.setPersonName(prpLpersonCommercePersonName[index2]);
					prpLpersonLossDto.setAge(Integer.parseInt(DataUtils.nullToZero(prpLpersonCommerceAge[index2])));
					prpLpersonLossDto.setCurrency3("CNY");
					prpLpersonLossDto.setPersonNo(index2);
					prpLpersonLossDto.setKindCode("BZ");

				}
		    }
		    prpLdangerItemDto = new PrpLdangerItemDto();
			prpLdangerItemDto.setCertiNo(prpLpersonLossCompensateNo); // 实赔号
			prpLdangerItemDto.setDangerNo(1); // 目前只有一个危险单位
			prpLdangerItemDto.setCurrency("CNY"); // 损失币别
			prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
			prpLdangerItemDto.setKindName("正常"); // 险别归类名称
			prpLdangerItemDto.setRiskCode(prpLpersonLossRiskCode); // 险别
			prpLdangerItemDto.setSerialNo(dangerItemSerialNo); // 标的序号
			dangerItemSerialNo++;
			prpLdangerItemDto.setSumPaid(Double.parseDouble(DataUtils.nullToZero(prpLpersonMedicalSumDefPay[index])));
		
			// 已决赔款
			prpLprpLdangerItemList.add(prpLdangerItemDto);
			prpLpersonLossDtoList.add(prpLpersonLossDto);
	    }
   }
 return dangerItemSerialNo;
 }


/**
 * 判断是否投保了机动车第三者综合保险（B）
 * 
 * @param claimNo
 *            立案号
 * @throws Exception
 * @author kangzhen
 */
public boolean checkItemKindB(String claimNo)throws Exception{
	boolean blnReturn = false;
	String kindCode="";
	
	ClaimDto claimDto = new UIClaimAction().findByPrimaryKey(claimNo);
	EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
	PolicyDto policyDto = endorseViewHelper.findForEndorBefore(claimDto.getPrpLclaimDto().getPolicyNo(),
    		                                         claimDto.getPrpLclaimDto().getDamageStartDate().toString(),
			                                         claimDto.getPrpLclaimDto().getDamageStartHour());
	ArrayList kindCodeList=policyDto.getPrpCitemKindDtoList();
	Iterator it =kindCodeList.iterator();
	if (kindCodeList!=null && kindCodeList.size()>0){
		while(it.hasNext()){
			PrpCitemKindDto  prpCitemKindDto =(PrpCitemKindDto)it.next();
		    kindCode = prpCitemKindDto.getKindCode();
		    if(kindCode.equals("B")){
		    	blnReturn = true;
		    	break;
		    }
		}
	}
	return blnReturn;
}

	public void nodutyLossCompelInit(HttpServletRequest httpServletRequest,
			ArrayList prpLnodutyLossDtoList) throws Exception {

		/*---------------------无责代赔信息prplnodutylossDto-----------------*/

		PrpLnodutyLossDto prpLnoDutyLossDto = null;

		String[] noneDutyLicenseNo = httpServletRequest
				.getParameterValues("noneDutyLicenseNo");
		String[] insuredName = httpServletRequest
				.getParameterValues("insuredName");
		String[] noneDutyCertiNo = httpServletRequest
				.getParameterValues("noneDutyCertiNo");
		String[] nodutyInsuredCompanyCode = httpServletRequest
				.getParameterValues("nodutyInsuredCompanyCode");
		String[] nodutyInsuredCompanyName = httpServletRequest
				.getParameterValues("nodutyInsuredCompanyName");
		String[] dutyPercent = httpServletRequest
				.getParameterValues("dutyPercent");
		String[] noneDutyLoss = httpServletRequest
				.getParameterValues("noneDutyLoss");

		String prpLnodutyLossCompensateNo = (String) httpServletRequest
				.getAttribute("compensateNo");
		String prpLnodutyLossRiskCode = httpServletRequest
				.getParameter("prpLcompensateRiskCode");
		String prpLnodutyLossPolicyNo = httpServletRequest
				.getParameter("prpLcompensatePolicyNo");
		String noDutyPaidType = httpServletRequest
				.getParameter("noDutyPaidType");
		String noDutyPaidName = httpServletRequest
				.getParameter("noDutyPaidName");
		String[] noDutyLimitPaid = httpServletRequest
				.getParameterValues("noDutyLimitPaid");
		String noDutyReplaceFlag = httpServletRequest
				.getParameter("noDutyReplaceFlag");
		String noDutyKindCode = httpServletRequest
				.getParameter("noDutyKindCode");
		String noDutyCurrency = httpServletRequest
				.getParameter("noDutyCurrency");
		String noDutyDutyType = "";
		int serialNo = 0;
		if (noneDutyLicenseNo != null) {
			for (int index = 1; index < noneDutyLicenseNo.length; index++) {
				serialNo++;
				prpLnoDutyLossDto = new PrpLnodutyLossDto();
				prpLnoDutyLossDto.setCompensateNo(prpLnodutyLossCompensateNo);
				prpLnoDutyLossDto.setRiskCode(prpLnodutyLossRiskCode);
				prpLnoDutyLossDto.setPolicyNo(prpLnodutyLossPolicyNo);
				prpLnoDutyLossDto.setSerialNo(serialNo);
				prpLnoDutyLossDto.setKindCode(noDutyKindCode);
				prpLnoDutyLossDto.setLicenseNo(noneDutyLicenseNo[index]);
				prpLnoDutyLossDto.setInsuredName(insuredName[index]);
				prpLnoDutyLossDto.setDriverLicenseNo(noneDutyCertiNo[index]);
				prpLnoDutyLossDto
						.setInsuredCompanyCode(nodutyInsuredCompanyCode[index]);
				prpLnoDutyLossDto
						.setInsuredCompanyName(nodutyInsuredCompanyName[index]);
				prpLnoDutyLossDto.setPaidType(noDutyPaidType);
				prpLnoDutyLossDto.setPaidName(noDutyPaidName);
				prpLnoDutyLossDto.setCurrency(noDutyCurrency);
				prpLnoDutyLossDto.setVerifyPaid(Double.parseDouble(DataUtils
						.nullToZero(noneDutyLoss[index])));
				prpLnoDutyLossDto.setLimitPaid(Double.parseDouble(DataUtils
						.nullToZero(noDutyLimitPaid[index])));
				prpLnoDutyLossDto.setRealPaid(Double.parseDouble(DataUtils
						.nullToZero(noneDutyLoss[index])));
				prpLnoDutyLossDto.setDutyPercent(Double.parseDouble(DataUtils
						.nullToZero(dutyPercent[index])));
				if (Double
						.parseDouble(DataUtils.nullToZero(dutyPercent[index])) > 0) {
					noDutyDutyType = "1";
				} else {
					noDutyDutyType = "0";
				}
				prpLnoDutyLossDto.setDutyType(noDutyDutyType);
				prpLnoDutyLossDto.setReplaceFlag(noDutyReplaceFlag);

				prpLnodutyLossDtoList.add(prpLnoDutyLossDto);

			}
		}
		// 无保险
		String[] noneInsItemCode = httpServletRequest
				.getParameterValues("NoneInsItemCode");
		String[] noneInsItemName = httpServletRequest
				.getParameterValues("NoneInsItemName");
		String[] noInsVerifyPaid = httpServletRequest
				.getParameterValues("NoInsVerifyPaid");
		String[] noInsLimitPaid = httpServletRequest
				.getParameterValues("NoInsLimitPaid");
		String[] noInsRealPaid = httpServletRequest
				.getParameterValues("NoInsRealPaid");
		String dutyPercentThird = httpServletRequest
				.getParameter("dutyPercentThird");
		String noDInsReplaceFlag = httpServletRequest
				.getParameter("noDInsReplaceFlag");
		String noDInsKindCode = httpServletRequest
				.getParameter("noDInsKindCode");
		String noDInsDutyType = httpServletRequest
				.getParameter("noDInsDutyType");
		String noDInsCurrency = httpServletRequest
				.getParameter("noDInsCurrency");

		if (noneInsItemCode != null) {
			for (int index = 1; index < noneInsItemCode.length; index++) {
				serialNo++;
				prpLnoDutyLossDto = new PrpLnodutyLossDto();
				prpLnoDutyLossDto.setCompensateNo(prpLnodutyLossCompensateNo);
				prpLnoDutyLossDto.setRiskCode(prpLnodutyLossRiskCode);
				prpLnoDutyLossDto.setPolicyNo(prpLnodutyLossPolicyNo);
				prpLnoDutyLossDto.setSerialNo(serialNo);
				prpLnoDutyLossDto.setKindCode(noDInsKindCode);
				prpLnoDutyLossDto.setLicenseNo("");
				prpLnoDutyLossDto.setInsuredName("");
				prpLnoDutyLossDto.setDriverLicenseNo("");
				prpLnoDutyLossDto.setInsuredCompanyCode("");
				prpLnoDutyLossDto.setInsuredCompanyName("");
				prpLnoDutyLossDto.setCurrency(noDInsCurrency);
				prpLnoDutyLossDto.setPaidType(noneInsItemCode[index]);
				prpLnoDutyLossDto.setPaidName(noneInsItemName[index]);
				prpLnoDutyLossDto.setVerifyPaid(Double.parseDouble(DataUtils
						.nullToZero(noInsVerifyPaid[index])));
				prpLnoDutyLossDto.setLimitPaid(Double.parseDouble(DataUtils
						.nullToZero(noInsLimitPaid[index])));
				prpLnoDutyLossDto.setRealPaid(Double.parseDouble(DataUtils
						.nullToZero(noInsRealPaid[index])));
				prpLnoDutyLossDto.setDutyPercent(Double.parseDouble(DataUtils
						.nullToZero(dutyPercentThird)));
				prpLnoDutyLossDto.setDutyType(noDInsDutyType);
				prpLnoDutyLossDto.setReplaceFlag(noDInsReplaceFlag);

				prpLnodutyLossDtoList.add(prpLnoDutyLossDto);
			}
		}
	
	
}















}