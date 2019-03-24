package com.gyic.claim.ui.control.viewHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.util.LabelValueBean;

import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcheckFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimStatusFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrpLthirdPartyFacade;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.ClaimStatusDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.VerifyLossDto;
import com.sinosoft.claim.dto.custom.WorkFlowQueryDto;
import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpDcodeDto;
import com.sinosoft.claim.dto.domain.PrpLcarLossDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLcomponentDto;
import com.sinosoft.claim.dto.domain.PrpLpersonDto;
import com.sinosoft.claim.dto.domain.PrpLpersonTraceDto;
import com.sinosoft.claim.dto.domain.PrpLpersonWoundDto;
import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLrepairFeeDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossExtDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossItemDto;
import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.claim.ui.control.action.ICollections;
import com.sinosoft.claim.ui.control.action.UICertainLossAction;
import com.sinosoft.claim.ui.control.action.UIClaimStatusAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.action.UIPrpLcheckAction;
import com.sinosoft.claim.ui.control.action.UIPrpLpersonTraceAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.viewHelper.CertainLossViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAAClaimViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAARegistViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.prpall.pubfun.TransCodeCI;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * <p>Title: CertainLossViewHelper</p>
 * <p>Description:定损ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 liubvo
 * @version 1.0
 * <br>
 */

public class DAACombineCertainLossViewHelper extends CertainLossViewHelper{
	
	/**
	 * 保存定损时定损页面数据整理.
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
	 * @param httpServletRequest
	 * @return certainLossDto 定损数据传输数据结构
	 * @throws Exception
	 */
	public CertainLossDto viewToDto(HttpServletRequest httpServletRequest) throws Exception
	{
		//继承对certainLoss,certainLossText表的赋值
		CertainLossDto certainLossDto = super.viewToDto(httpServletRequest);
		
		//add by lixiang start 20051228
		//reason: 因为考虑到录入的时候，可能没有立案，但是在提交的时候，做了立案，导致立案号没写入。
		//先取立案号码，很重要，不要从页面上取得。。。
		String claimNo=httpServletRequest.getParameter("prpLverifyLossClaimNo");
		String registNo  = httpServletRequest.getParameter("prpLverifyLossRegistNo");
		if (claimNo==null||claimNo.length()<2){
			UICodeAction uiCodeAction = new UICodeAction();
			claimNo=uiCodeAction.translateBusinessCode(registNo,true);
		}
		//add by lixiang end 20051228
		
		
		//modify by liuyanmei add strat reason: 定损处涉案车辆信息可修改，此处却没有存三者车的信息
		String  lossItemCode = httpServletRequest.getParameter("prpLcarLossLossItemCode");
		/*---------------------三者车辆prpLthirdParty-----------------------------------*/
		System.out.println("-----lossItemCode===="+lossItemCode);
		if(lossItemCode==null || lossItemCode.equals("")){
		}
		else {
			String prpLthirdPartyRegistNo = httpServletRequest.getParameter("prplCheckRegistNoShow");
			System.out.println("-----[prpLthirdPartyRegistNo]:"+prpLthirdPartyRegistNo);
			int i=0;
			int serialNo  = 0;
			int useYears = 0;
			double  runDistance =0.00;
			String	carOwner = "";
			String	insuredFlag = "";
			String	flag ="";
			String clauseType ="";
			String lossFlag ="";
			double dutyPercent=0.00;
			UIRegistAction  uiRegistAction =new UIRegistAction();
			RegistDto registDto = uiRegistAction.findByPrimaryKey(prpLthirdPartyRegistNo);
			ArrayList registThirdPartyDtoList = registDto.getPrpLthirdPartyDtoList();
			if ( registThirdPartyDtoList!=null && registThirdPartyDtoList.size()> 0 ){
				for (i=0;i< registThirdPartyDtoList.size();i++){
					PrpLthirdPartyDto 	registPrpLthirdPartyDto =(PrpLthirdPartyDto)registThirdPartyDtoList.get(i);
					serialNo = registPrpLthirdPartyDto.getSerialNo();
					if (serialNo==Integer.parseInt(lossItemCode)){
						useYears = registPrpLthirdPartyDto.getUseYears();
						runDistance =registPrpLthirdPartyDto.getRunDistance();
						carOwner = registPrpLthirdPartyDto.getCarOwner();
						insuredFlag = registPrpLthirdPartyDto.getInsuredFlag();
						flag =registPrpLthirdPartyDto.getFlag();
						clauseType = registPrpLthirdPartyDto.getClauseType();
						dutyPercent= registPrpLthirdPartyDto.getDutyPercent();
						lossFlag =  registPrpLthirdPartyDto.getLossFlag();
					}
					else {
						continue;
					}
					
				}
				
			}
			
			PrpLthirdPartyDto prpLthirdPartyDto = null;
			
			//从界面得到输入数组
			
			String prpLthirdPartyRiskCode = httpServletRequest.getParameter("prpLverifyLossRiskCode");
			String prpLthirdPartyClaimNo = httpServletRequest.getParameter("prplCheckClaimNoShow");
			String prpLthirdPartySerialNo = httpServletRequest.getParameter("prpLcarLossLossItemCode");
			String prpLthirdPartyLicenseNo = httpServletRequest.getParameter("prpLcarLossLossItemName");
			String prpLthirdPartyLicenseColorCode = httpServletRequest.getParameter("prpLcarLossLicenseColorCode");
			String prpLthirdPartyCarKindCode = httpServletRequest.getParameter("prpLcarLossCarKindCode"); 
			String prpLthirdPartyInsureCarFlag = httpServletRequest.getParameter("prpLcarLossInsureCarFlag");
			//String[] prpLthirdPartyCarOwner = httpServletRequest.getParameterValues("prpLthirdPartyCarOwner");
			String prpLthirdPartyEngineNo = httpServletRequest.getParameter("prpLcarLossEngineNo");
			String prpLthirdPartyFrameNo = httpServletRequest.getParameter("prpLcarLossFrameNo");
			//String[] prpLthirdPartyModelCode = httpServletRequest.getParameterValues("prpLthirdPartyModelCode");
			String prpLthirdPartyBrandName = httpServletRequest.getParameter("prpLcarLossBrandName");
			String prpLthirdPartyModelCode = httpServletRequest.getParameter("prpLcarLossModelCode");	  
			
			//String[] prpLthirdPartyRunDistance = httpServletRequest.getParameterValues("prpLthirdPartyRunDistance");
			//String[] prpLthirdPartyUseYears = httpServletRequest.getParameterValues("prpLthirdPartyUseYears");
			//String prpLthirdPartyDutyPercent = httpServletRequest.getParameter("prpLcarLossIndemnityDutyRate");
			//String[] prpLthirdPartyInsuredFlag = httpServletRequest.getParameterValues("insuredFlag");
			String prpLthirdPartyInsureComCode = httpServletRequest.getParameter("prpLcarLossInsureComCode");
			String prpLthirdPartyInsureComName = httpServletRequest.getParameter("prpLcarLossInsureComName");
			//String[] prpLthirdPartyFlag = httpServletRequest.getParameterValues("prpLthirdPartyFlag");
			String prpLthirdPartyVINNo = httpServletRequest.getParameter("prpLcarLossVINNo");
			
			prpLthirdPartyDto = new PrpLthirdPartyDto();
			prpLthirdPartyDto.setRegistNo(prpLthirdPartyRegistNo);
			prpLthirdPartyDto.setRiskCode(prpLthirdPartyRiskCode);
			prpLthirdPartyDto.setSerialNo(Integer.parseInt(lossItemCode));
			prpLthirdPartyDto.setClaimNo(claimNo);
			prpLthirdPartyDto.setClauseType(clauseType);
			prpLthirdPartyDto.setLicenseNo(prpLthirdPartyLicenseNo);
			prpLthirdPartyDto.setLicenseColorCode(prpLthirdPartyLicenseColorCode);
			prpLthirdPartyDto.setCarKindCode(prpLthirdPartyCarKindCode);
			prpLthirdPartyDto.setInsureCarFlag(prpLthirdPartyInsureCarFlag);
			prpLthirdPartyDto.setEngineNo(prpLthirdPartyEngineNo);
			prpLthirdPartyDto.setFrameNo(prpLthirdPartyFrameNo);
			prpLthirdPartyDto.setBrandName(prpLthirdPartyBrandName);
			prpLthirdPartyDto.setModelCode(prpLthirdPartyModelCode);
			
			prpLthirdPartyDto.setRunDistance(runDistance);
			prpLthirdPartyDto.setUseYears(useYears);
			prpLthirdPartyDto.setDutyPercent(dutyPercent);
			prpLthirdPartyDto.setInsuredFlag(insuredFlag);
			prpLthirdPartyDto.setInsureComCode(prpLthirdPartyInsureComCode);
			prpLthirdPartyDto.setInsureComName(prpLthirdPartyInsureComName);
			prpLthirdPartyDto.setVINNo(prpLthirdPartyVINNo);
			prpLthirdPartyDto.setCarOwner(carOwner);
			prpLthirdPartyDto.setFlag(flag);
			prpLthirdPartyDto.setLossFlag(lossFlag);
			BLPrpLthirdPartyFacade blPrpLthirdParty = new BLPrpLthirdPartyFacade();
			Collection collectiion = blPrpLthirdParty.findByConditions(" registno= '"+prpLthirdPartyRegistNo+"' and serialno = '"+lossItemCode+"'");
			if(collectiion.size() > 0){
				prpLthirdPartyDto.setPrpLthirdPartyDriveName(((PrpLthirdPartyDto)collectiion.iterator().next()).getPrpLthirdPartyDriveName());
				prpLthirdPartyDto.setPrpLthirdPartyDriveLicensNo(((PrpLthirdPartyDto)collectiion.iterator().next()).getPrpLthirdPartyDriveLicensNo());
			}
			
			//加入三者车辆
			certainLossDto.setPrpLthirdPartyDto(prpLthirdPartyDto);
			
		} 
		// modify by liuyanmei add end reason: 定损处涉案车辆信息可修改，此处却没有存三者车的信息 
		
		
		/*---------------------财产核定损明细清单表 prpLprop ------------------------------------*/
		ArrayList prpLpropDtoList = new ArrayList();
		PrpLpropDto prpLpropDto = null;
		
		//定核损处理标的表
		PrpLverifyLossItemDto LossItemRepairComponentDto = new PrpLverifyLossItemDto();
		PrpLverifyLossItemDto LossItemPersonDto = new PrpLverifyLossItemDto();
		PrpLverifyLossItemDto LossItemPropDto = new PrpLverifyLossItemDto();
		PrpLverifyLossItemDto LossItemAllLossDto = new PrpLverifyLossItemDto();
		ArrayList lossItemListTemp = new ArrayList();
		//从界面得到输入数组
		String   prpLpropPolicyNo  = httpServletRequest.getParameter("prpLverifyLossPolicyNo");
		String   prpLpropRiskCode  = httpServletRequest.getParameter("prpLverifyLossRiskCode");
		String   prpLpropClaimNo  = httpServletRequest.getParameter("prpLverifyLossClaimNo");
		String   prpLpropRegistNo  = httpServletRequest.getParameter("prpLverifyLossRegistNo");
		
		String[]   prpLpropSerialNo                  =httpServletRequest.getParameterValues("prpLpropSerialNo");
		String[]   prpLpropItemKindNo                =httpServletRequest.getParameterValues("prpLpropItemKindNo");
		String[]   prpLpropFamilyNo                  =httpServletRequest.getParameterValues("prpLpropFamilyNo");
		String[]   prpLpropFamilyName                =httpServletRequest.getParameterValues("prpLpropFamilyName");
		String[]   prpLpropKindCode                  =httpServletRequest.getParameterValues("prpLpropKindCode");
		String[]   prpLpropItemCode                  =httpServletRequest.getParameterValues("prpLpropItemCode");
		String[]   prpLpropLossItemCode              =httpServletRequest.getParameterValues("prpLpropLossItemCode");
		String[]   prpLpropLossItemName              =httpServletRequest.getParameterValues("prpLpropLossItemName");
		String[]   prpLpropFeeTypeCode               =httpServletRequest.getParameterValues("prpLpropFeeTypeCode");
		String[]   feeTypeCode                       =httpServletRequest.getParameterValues("feeTypeCode");
		String[]   prpLpropFeeTypeName               =httpServletRequest.getParameterValues("prpLpropFeeTypeName");
		String[]   prpLpropCurrency                  =httpServletRequest.getParameterValues("prpLpropCurrency");
		String[]   prpLpropUnitPrice                 =httpServletRequest.getParameterValues("prpLpropUnitPrice");
		String[]   prpLpropLossQuantity              =httpServletRequest.getParameterValues("prpLpropLossQuantity");
		String[]   prpLpropUnit                      =httpServletRequest.getParameterValues("prpLpropUnit");
		String[]   prpLpropBuyDate                   =httpServletRequest.getParameterValues("prpLpropBuyDate");
		String[]   prpLpropDepreRate                 =httpServletRequest.getParameterValues("prpLpropDepreRate");
		String[]   prpLpropSumLoss                   =httpServletRequest.getParameterValues("prpLpropSumLoss");
		String[]   prpLpropSumReject                 =httpServletRequest.getParameterValues("prpLpropSumReject");
		String[]   prpLpropRejectReason              =httpServletRequest.getParameterValues("prpLpropRejectReason");
		String[]   prpLpropLossRate                  =httpServletRequest.getParameterValues("prpLpropLossRate");
		String[]   prpLpropSumDefLoss                =httpServletRequest.getParameterValues("prpLpropSumDefLoss");
		String[]   prpLpropRemark                    =httpServletRequest.getParameterValues("prpLpropRemark");
		String[]   prpLpropVeriUnitPrice             =httpServletRequest.getParameterValues("prpLpropVeriUnitPrice");
		String[]   prpLpropVeriLossQuantity          =httpServletRequest.getParameterValues("prpLpropVeriLossQuantity");
		String[]   prpLpropVeriUnit                  =httpServletRequest.getParameterValues("prpLpropVeriUnit");
		String[]   prpLpropVeriDepreRate             =httpServletRequest.getParameterValues("prpLpropVeriDepreRate");
		String[]   prpLpropVeriSumLoss               =httpServletRequest.getParameterValues("prpLpropVeriSumLoss");
		String[]   prpLpropVeriSumReject             =httpServletRequest.getParameterValues("prpLpropVeriSumReject");
		String[]   prpLpropVeriRejectReason          =httpServletRequest.getParameterValues("prpLpropVeriRejectReason");
		String[]   prpLpropVeriLossRate              =httpServletRequest.getParameterValues("prpLpropVeriLossRate");
		String[]   prpLpropVeriSumDefLoss            =httpServletRequest.getParameterValues("prpLpropVeriSumDefLoss");
		String[]   prpLpropVeriRemark                =httpServletRequest.getParameterValues("prpLpropVeriRemark");
		String[]   prpLpropFlag                      =httpServletRequest.getParameterValues("prpLpropFlag");
		
		
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = null;
		PolicyDto policyDto = null;
		if(registNo != null && !registNo.equals("")){
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper(); 
			registDto = uiRegistAction.findByPrimaryKey(registNo); 
			policyDto = endorseViewHelper.findForEndorBefore(registDto.getPrpLregistDto()
				.getPolicyNo(),registDto.getPrpLregistDto().getDamageStartDate().toString()
				,registDto.getPrpLregistDto().getDamageStartHour()); 
		}
//		add by lixiang start at 2006-04-21
	    //reason: 增加保存理算退回的定损的标志的保存,若有数据不会被保存冲掉
	  String[]   prpLpropCompensateBackFlag  = httpServletRequest.getParameterValues("prpLpropCompensateBackFlag");
		//add by lixiang end at 2006-04-21
//对象赋值
		if (prpLpropSerialNo==null){
		}else{
			
			for(int index=1;index<prpLpropSerialNo.length;index++)
			{
				prpLpropDto = new PrpLpropDto();
				prpLpropDto.setPolicyNo(prpLpropPolicyNo);
				prpLpropDto.setRiskCode(prpLpropRiskCode);
				prpLpropDto.setClaimNo(claimNo);
				prpLpropDto.setRegistNo(prpLpropRegistNo);
				
				prpLpropDto.setSerialNo                 ( index);
				//prpLpropDto.setSerialNo                 ( Integer.parseInt(DataUtils.nullToZero(prpLpropSerialNo     [index])));
				prpLpropDto.setFamilyNo                 ( Integer.parseInt(DataUtils.nullToZero(prpLpropFamilyNo     [index])));
				prpLpropDto.setFamilyName               ( prpLpropFamilyName   [index]);
				prpLpropDto.setKindCode                 ( prpLpropKindCode     [index]);
				prpLpropDto.setItemKindNo               ( Integer.parseInt(DataUtils.nullToZero(prpLpropItemKindNo   [index])));
				
				
				
				
				if (!registDto.getPrpLregistDto().getPolicyNo().equals("")){
					for (int k=0; k<policyDto.getPrpCitemKindDtoList().size(); k++)       {
						PrpCitemKindDto    prpCitemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(k);
						
						if (prpCitemKindDto.getKindCode() == prpLpropDto.getKindCode())
							prpLpropDto.setItemKindNo(prpCitemKindDto.getItemKindNo());
						break;
					}}
				
				prpLpropDto.setItemCode                 ( prpLpropItemCode     [index]);
				prpLpropDto.setLossItemCode             ( prpLpropLossItemCode [index]);
				prpLpropDto.setLossItemName             ( prpLpropLossItemName [index]);
				prpLpropDto.setFeeTypeCode              ( feeTypeCode  [index]);
				
				if("01".equals(feeTypeCode  [index])){
					prpLpropDto.setFeeTypeName              ("修理费");
				}else{ 
					prpLpropDto.setFeeTypeName              ("材料费");
				} 
				prpLpropDto.setCurrency                 ( prpLpropCurrency     [index]);
				prpLpropDto.setUnitPrice                ( Double.parseDouble(DataUtils.nullToZero(prpLpropUnitPrice    [index])));
				prpLpropDto.setLossQuantity             ( Double.parseDouble(DataUtils.nullToZero(prpLpropLossQuantity [index])));
				prpLpropDto.setUnit                     ( prpLpropUnit         [index]);
				prpLpropDto.setBuyDate                  ( new DateTime(new Date(),DateTime.YEAR_TO_DAY));
				//prpLpropDto.setBuyDate                  ( new DateTime(prpLpropBuyDate      [index]));
				prpLpropDto.setDepreRate                ( Double.parseDouble(DataUtils.nullToZero(prpLpropDepreRate    [index])));
				prpLpropDto.setSumLoss                  ( Double.parseDouble(DataUtils.nullToZero(prpLpropSumLoss      [index])));
				prpLpropDto.setSumReject                ( Double.parseDouble(DataUtils.nullToZero(prpLpropSumReject    [index])));
				prpLpropDto.setRejectReason             ( prpLpropRejectReason [index]);
				prpLpropDto.setLossRate                 ( Double.parseDouble(DataUtils.nullToZero(prpLpropLossRate     [index])));
				prpLpropDto.setSumDefLoss               ( Double.parseDouble(DataUtils.nullToZero(prpLpropSumDefLoss   [index])));
				prpLpropDto.setRemark                   ( prpLpropRemark       [index]);
				prpLpropDto.setVeriUnitPrice            ( Double.parseDouble(DataUtils.nullToZero(prpLpropVeriUnitPrice[index])));
				prpLpropDto.setVeriLossQuantity         ( Double.parseDouble(DataUtils.nullToZero(prpLpropVeriLossQuantity[index])));
				prpLpropDto.setVeriUnit                 ( prpLpropVeriUnit        [index]);
				prpLpropDto.setVeriDepreRate            ( Double.parseDouble(DataUtils.nullToZero(prpLpropVeriDepreRate   [index])));
				prpLpropDto.setVeriSumLoss              ( Double.parseDouble(DataUtils.nullToZero(prpLpropVeriSumLoss     [index])));
				prpLpropDto.setVeriSumReject            ( Double.parseDouble(DataUtils.nullToZero(prpLpropVeriSumReject   [index])));
				prpLpropDto.setVeriRejectReason         ( prpLpropVeriRejectReason[index]);
				prpLpropDto.setVeriLossRate             ( Double.parseDouble(DataUtils.nullToZero(prpLpropVeriLossRate    [index])));
				prpLpropDto.setVeriSumDefLoss           ( Double.parseDouble(DataUtils.nullToZero(prpLpropVeriSumDefLoss  [index])));
				prpLpropDto.setVeriRemark               ( prpLpropVeriRemark      [index]);
				prpLpropDto.setFlag                     ( prpLpropFlag            [index]);
		        prpLpropDto.setCompensateBackFlag                     ( prpLpropCompensateBackFlag           [index]);

				//加入集合
				prpLpropDtoList.add(prpLpropDto);
			}
			PropertyUtils.copyProperties(LossItemPropDto,certainLossDto.getPrpLverifyLossDto());
			LossItemPropDto.setSerialNo(3);
			LossItemPropDto.setLossType("3");
			LossItemPropDto.setNodeType("certa");
			lossItemListTemp.add(LossItemPropDto);
		}
		//财产核定损明细清单表
		certainLossDto.setPrpLpropDtoList(prpLpropDtoList);
		
		
		/*---------------------定损车辆表&修理费用清单&换件项目清单 prpLcarLoss&prpLrepairFee&prpLcomponent ------------------------------------*/
		ArrayList prpLcarLossDtoList = new ArrayList();
		PrpLcarLossDto prpLcarLossDto = null;
		//修理费用清单
		ArrayList prpLrepairFeeDtoList = new ArrayList();
		PrpLrepairFeeDto prpLrepairFeeDto = null;
		//换件项目清单
		ArrayList prpLcomponentDtoList = new ArrayList();
		PrpLcomponentDto prpLcomponentDto = null;
		
		//取得取得车辆标的的数量
		//int carLossSize = Integer.parseInt(httpServletRequest.getParameter("carLossSize"));
		
		//从界面得到输入数组
		String   prpLcarLossPolicyNo  = httpServletRequest.getParameter("prpLverifyLossPolicyNo");
		String   prpLcarLossRiskCode  = httpServletRequest.getParameter("prpLverifyLossRiskCode");
		String   prpLcarLossClaimNo  = httpServletRequest.getParameter("prpLverifyLossClaimNo");
		String   prpLcarLossRegistNo  = httpServletRequest.getParameter("prpLverifyLossRegistNo");
		
		//修理换件的数量
		int repairFeeNo = 0;
		int componentNo = 0;
		
		//String prpLcarLossLossItemCode = String.valueOf(i+1); //车辆标的
		String[]   prpLcarLossLossItemCode        = httpServletRequest.getParameterValues("prpLcarLossLossItemCode");
		String[]   prpLcarLossLossItemName        = httpServletRequest.getParameterValues("prpLcarLossLossItemName");
		String[]   prpLcarLossCurrency            = httpServletRequest.getParameterValues("prpLcarLossCurrency");
		String[]   prpLcarLossSumRest             = httpServletRequest.getParameterValues("prpLcarLossSumRest");
		String[]   prpLcarLossSumManager          = httpServletRequest.getParameterValues("prpLcarLossSumManager");
		String[]   prpLcarLossSumCertainLoss      = httpServletRequest.getParameterValues("prpLcarLossSumCertainLoss");
		String[]   prpLcarLossSumVeriRest         = httpServletRequest.getParameterValues("prpLcarLossSumVeriRest");
		String[]   prpLcarLossSumVeriManager      = httpServletRequest.getParameterValues("prpLcarLossSumVeriManager");
		String[]   prpLcarLossSumVerifyLoss       = httpServletRequest.getParameterValues("prpLcarLossSumVerifyLoss");
		String[]   prpLcarLossLossDesc            = httpServletRequest.getParameterValues("prpLcarLossLossDesc");
		String[]   prpLcarLossIndemnityDuty       = httpServletRequest.getParameterValues("prpLcarLossIndemnityDuty");
		String[]   prpLcarLossIndemnityDutyRate   = httpServletRequest.getParameterValues("prpLcarLossIndemnityDutyRate");
		String[]   prpLcarLossVeriIndeDutyRate    = httpServletRequest.getParameterValues("prpLcarLossVeriIndeDutyRate");
		String[]   prpLcarLossRemark              = httpServletRequest.getParameterValues("prpLcarLossRemark");
		String[]   prpLcarLossOperatorCode        = httpServletRequest.getParameterValues("prpLcarLossOperatorCode");
		String[]   prpLcarLossApproverCode        = httpServletRequest.getParameterValues("prpLcarLossApproverCode");
		String[]   prpLcarLossFlag                = httpServletRequest.getParameterValues("prpLcarLossFlag");
		String[]   prpLcarLossBackCheckFlag       = httpServletRequest.getParameterValues("prpLcarLossBackCheckFlag");
		String[]   prpLcarLossCarKindCode         = httpServletRequest.getParameterValues("prpLcarLossCarKindCode");
		String[]   prpLcarLossLicenseColorCode    = httpServletRequest.getParameterValues("prpLcarLossLicenseColorCode");
		String[]   prpLcarLossVINNo    = httpServletRequest.getParameterValues("prpLcarLossVINNo");
		String[]   prpLcarLossSumManageFeeRate    = httpServletRequest.getParameterValues("prpLcarLossSumManageFeeRate");
		
		String[]   prpLcarLossSumTransFee    = httpServletRequest.getParameterValues("prpLcarLossSumTransFee");
		String[]   prpLcarLossSumTax    = httpServletRequest.getParameterValues("prpLcarLossSumTax");
		
		
		
		
		
		
		
		String   prpLrepairFeeRepairFactoryCode = httpServletRequest.getParameter("prpLrepairFeeRepairFactoryCode");
		String   prpLrepairFeeRepairFactoryName = httpServletRequest.getParameter("prpLrepairFeeRepairFactoryName");
		String   prpLrepairFeeRepairStartDate   = httpServletRequest.getParameter("prpLrepairFeeRepairStartDate");
		String   prpLrepairFeeRepairEndDate     = httpServletRequest.getParameter("prpLrepairFeeRepairEndDate");
		String   prpLrepairFeeHandlerCode       = httpServletRequest.getParameter("prpLrepairFeeHandlerCode");
		String   prpLrepairFeeHandlerName       = httpServletRequest.getParameter("prpLrepairFeeHandlerName");
		
		//prpLrepairFee
		String[]   carLossRepairFeeLossItemCode   = httpServletRequest.getParameterValues("carLossRepairFeeLossItemCode");
		String[]   prpLrepairFeeSerialNo          = httpServletRequest.getParameterValues("prpLrepairFeeSerialNo");
		String[]   prpLrepairFeeItemKindNo        = httpServletRequest.getParameterValues("prpLrepairFeeItemKindNo");
		String[]   prpLrepairFeeLossItemCode      = httpServletRequest.getParameterValues("prpLrepairFeeLossItemCode");
		String[]   prpLrepairFeeKindCode          = httpServletRequest.getParameterValues("prpLrepairFeeKindCode");
		String[]   prpLrepairFeeLicenseNo         = httpServletRequest.getParameterValues("prpLrepairFeeLicenseNo");
		String[]   prpLrepairFeeLicenseColorCode  = httpServletRequest.getParameterValues("prpLrepairFeeLicenseColorCode");
		String[]   prpLrepairFeeCarKindCode       = httpServletRequest.getParameterValues("prpLrepairFeeCarKindCode");
		//String[]   prpLrepairFeeRepairFactoryCode = httpServletRequest.getParameterValues("prpLrepairFeeRepairFactoryCode");
		//String[]   prpLrepairFeeRepairFactoryName = httpServletRequest.getParameterValues("prpLrepairFeeRepairFactoryName");
		//String[]   prpLrepairFeeHandlerCode       = httpServletRequest.getParameterValues("prpLrepairFeeHandlerCode");
		//String[]   prpLrepairFeeRepairStartDate   = httpServletRequest.getParameterValues("prpLrepairFeeRepairStartDate");
		//String[]   prpLrepairFeeRepairEndDate     = httpServletRequest.getParameterValues("prpLrepairFeeRepairEndDate");
		String[]   prpLrepairFeeSanctioner          = httpServletRequest.getParameterValues("prpLrepairFeeSanctioner");
		String[]   prpLrepairFeeApproverCode        = httpServletRequest.getParameterValues("prpLrepairFeeApproverCode");
		String[]   prpLrepairFeeOperatorCode        = httpServletRequest.getParameterValues("prpLrepairFeeOperatorCode");
		//Modify by chenrenda add begin 20050413
		//Reason:在修理清单中加上损失部位、修理方式
		String[]   prpLrepairFeePartCode            = httpServletRequest.getParameterValues("prpLrepairFeePartCode");
		String[]   prpLrepairFeePartName            = httpServletRequest.getParameterValues("prpLrepairFeePartName");
		String[]   prpLrepairFeeRepairType            = httpServletRequest.getParameterValues("prpLrepairFeeRepairType");
		//Modify by chenrenda add end 20050413
		String[]   prpLrepairFeeCompCode            = httpServletRequest.getParameterValues("prpLrepairFeeCompCode");
		String[]   prpLrepairFeeCompName            = httpServletRequest.getParameterValues("prpLrepairFeeCompName");
		String[]   prpLrepairFeeManHour             = httpServletRequest.getParameterValues("prpLrepairFeeManHour");
		String[]   prpLrepairFeeManHourUnitPrice    = httpServletRequest.getParameterValues("prpLrepairFeeManHourUnitPrice");
		String[]   prpLrepairFeeManHourFee          = httpServletRequest.getParameterValues("prpLrepairFeeManHourFee");
		String[]   prpLrepairFeeMaterialFee         = httpServletRequest.getParameterValues("prpLrepairFeeMaterialFee");
		String[]   prpLrepairFeeLossRate            = httpServletRequest.getParameterValues("prpLrepairFeeLossRate");
		String[]   prpLrepairFeeCurrency            = httpServletRequest.getParameterValues("prpLrepairFeeCurrency");
		
		String[]   prpLrepairFeeSumDefLoss          = httpServletRequest.getParameterValues("prpLrepairFeeSumDefLoss");
		String[]   prpLrepairFeeFirstSumDefLoss   = httpServletRequest.getParameterValues("prpLrepairFeeFirstSumDefLoss");
		
		
		String[]   prpLrepairFeeRemark              = httpServletRequest.getParameterValues("prpLrepairFeeRemark");
		String[]   prpLrepairFeeVeriManHour         = httpServletRequest.getParameterValues("prpLrepairFeeVeriManHour");
		String[]   prpLrepairFeeVeriManUnitPrice    = httpServletRequest.getParameterValues("prpLrepairFeeVeriManUnitPrice");
		String[]   prpLrepairFeeVeriManHourFee      = httpServletRequest.getParameterValues("prpLrepairFeeVeriManHourFee");
		String[]   prpLrepairFeeVeriMaterQuantity   = httpServletRequest.getParameterValues("prpLrepairFeeVeriMaterQuantity");
		String[]   prpLrepairFeeVeriMaterUnitPrice  = httpServletRequest.getParameterValues("prpLrepairFeeVeriMaterUnitPrice");
		String[]   prpLrepairFeeVeriMaterialFee     = httpServletRequest.getParameterValues("prpLrepairFeeVeriMaterialFee");
		String[]   prpLrepairFeeVeriLossRate        = httpServletRequest.getParameterValues("prpLrepairFeeVeriLossRate");
		String[]   prpLrepairFeeVeriSumLoss         = httpServletRequest.getParameterValues("prpLrepairFeeVeriSumLoss");
		String[]   prpLrepairFeeVeriRemark          = httpServletRequest.getParameterValues("prpLrepairFeeVeriRemark");
		String[]   prpLrepairFeeFlag                = httpServletRequest.getParameterValues("prpLrepairFeeFlag");
//      add by lixiang start at 2006-04-21
	    //reason: 增加保存理算退回的定损的标志的保存,若有数据不会被保存冲掉
		String[]   prpLrepairFeeCompensateBackFlag  = httpServletRequest.getParameterValues("prpLrepairFeeCompensateBackFlag");
//		add by lixiang start at 2006-04-21
	    //reason: 增加保存理算退回的定损的标志的保存,若有数据不会被保存冲掉
		
		
		String[]   prpLcomponentCompensateBackFlag  = httpServletRequest.getParameterValues("prpLcomponentCompensateBackFlag");
		//add by lixiang end at 2006-04-21

		//prpLcomponent
		String[]   carLossComponentLossItemCode     = httpServletRequest.getParameterValues("carLossComponentLossItemCode");
		String[]   prpLcomponentSerialNo            = httpServletRequest.getParameterValues("prpLcomponentSerialNo");
		String[]   prpLcomponentItemKindNo          = httpServletRequest.getParameterValues("prpLcomponentItemKindNo");
		String[]   prpLcomponentKindCode            = httpServletRequest.getParameterValues("prpLcomponentKindCode");
		String[]   prpLcomponentIndId				  = httpServletRequest.getParameterValues("prpLcomponentIndId");
		String[]   prpLcomponentLossItemCode        = httpServletRequest.getParameterValues("prpLcomponentLossItemCode");
		String[]   prpLcomponentLicenseNo           = httpServletRequest.getParameterValues("prpLcomponentLicenseNo");
		String[]   prpLcomponentLicenseColorCode    = httpServletRequest.getParameterValues("prpLcomponentLicenseColorCode");
		String[]   prpLcomponentCarKindCode         = httpServletRequest.getParameterValues("prpLcomponentCarKindCode");
		String[]   prpLcomponentMakeYear            = httpServletRequest.getParameterValues("prpLcomponentMakeYear");
		String[]   prpLcomponentGearboxType         = httpServletRequest.getParameterValues("prpLcomponentGearboxType");
		String[]   prpLcomponentQuoteCompanyGrade   = httpServletRequest.getParameterValues("prpLcomponentQuoteCompanyGrade");
		String[]   prpLcomponentManageFeeRate       = httpServletRequest.getParameterValues("prpLcomponentManageFeeRate");
		String   prpLcomponentRepairFactoryCode   = httpServletRequest.getParameter("prpLrepairFeeRepairFactoryCode");
		String   prpLcomponentRepairFactoryName   = httpServletRequest.getParameter("prpLrepairFeeRepairFactoryName");
		String   prpLcomponentHandlerCode         = httpServletRequest.getParameter("prpLrepairFeeHandlerCode");
		String   prpLcomponentRepairStartDate     = httpServletRequest.getParameter("prpLrepairFeeRepairStartDate");
		String   prpLcomponentRepairEndDate       = httpServletRequest.getParameter("prpLrepairFeeRepairEndDate");
		String[]   prpLcomponentSanctioner          = httpServletRequest.getParameterValues("prpLcomponentSanctioner");
		String[]   prpLcomponentApproverCode        = httpServletRequest.getParameterValues("prpLcomponentApproverCode");
		String[]   prpLcomponentOperatorCode        = httpServletRequest.getParameterValues("prpLcomponentOperatorCode");
		
		//Modify by chenrenda add begin 20050413
		//Reason:在换件清单中加上损失部位
		String[]   prpLcomponentPartCode            = httpServletRequest.getParameterValues("prpLcomponentPartCode");
		String[]   prpLcomponentPartName            = httpServletRequest.getParameterValues("prpLcomponentPartName");
		//String[]   prpLcomponentPartDesc            = httpServletRequest.getParameterValues("prpLcomponentPartDesc");
		////Modify by chenrenda add end 20050413
		String[]   prpLcomponentCompCode            = httpServletRequest.getParameterValues("prpLcomponentCompCode");
		String[]   prpLcomponentCompName            = httpServletRequest.getParameterValues("prpLcomponentCompName");
		String[]   prpLcomponentQuantity            = httpServletRequest.getParameterValues("prpLcomponentQuantity");
		String[]   prpLcomponentManHourFee          = httpServletRequest.getParameterValues("prpLcomponentManHourFee");
		
		String[]   prpLcomponentMaterialFee         = httpServletRequest.getParameterValues("prpLcomponentMaterialFee");
		String[]   prpLcomponentFirstMaterialFee  = httpServletRequest.getParameterValues("prpLcomponentFirstMaterialFee");	  
		
		
		String[]   prpLcomponentRestFee             = httpServletRequest.getParameterValues("prpLcomponentRestFee");
		String[]   prpLcomponentVeriRestFee         = httpServletRequest.getParameterValues("prpLcomponentVeriRestFee");
		
		String[]   prpLcomponentQueryPrice          = httpServletRequest.getParameterValues("prpLcomponentQueryPrice");
		
		
		String[]   prpLcomponentQuotedPrice         = httpServletRequest.getParameterValues("prpLcomponentQuotedPrice");
		String[]   prpLcomponentLossRate            = httpServletRequest.getParameterValues("prpLcomponentLossRate");
		String[]   prpLcomponentCurrency            = httpServletRequest.getParameterValues("prpLcomponentCurrency");
		String[]   prpLcomponentSumDefLoss          = httpServletRequest.getParameterValues("prpLcomponentSumDefLoss");
		String[]   prpLcomponentRemark              = httpServletRequest.getParameterValues("prpLcomponentRemark");
		String[]   prpLcomponentVeriQuantity        = httpServletRequest.getParameterValues("prpLcomponentVeriQuantity");
		String[]   prpLcomponentVeriManHourFee      = httpServletRequest.getParameterValues("prpLcomponentVeriManHourFee");
		String[]   prpLcomponentVeriMaterFee        = httpServletRequest.getParameterValues("prpLcomponentVeriMaterFee");
		String[]   prpLcomponentVeriLossRate        = httpServletRequest.getParameterValues("prpLcomponentVeriLossRate");
		String[]   prpLcomponentSumVeriLoss         = httpServletRequest.getParameterValues("prpLcomponentSumVeriLoss");
		String[]   prpLcomponentVeriRemark          = httpServletRequest.getParameterValues("prpLcomponentVeriRemark");
		String[]   prpLcomponentFlag                = httpServletRequest.getParameterValues("prpLcomponentFlag");
		
		
		//System.out.println("========  [ prpLcomponentFlag ] == "+ prpLcomponentFlag[0]);
		String[]   prpLcomponentOriginalId                = httpServletRequest.getParameterValues("prpLcomponentOriginalId");	  
		
		
		String[]   prpLcomponentSys4SPrice                = httpServletRequest.getParameterValues("prpLcomponentSys4SPrice");	  
		String[]   prpLcomponentSysMarketPrice            = httpServletRequest.getParameterValues("prpLcomponentSysMarketPrice");	  
		String[]   prpLcomponentSysMatchPrice                = httpServletRequest.getParameterValues("prpLcomponentSysMatchPrice");	  
		String[]   prpLcomponentNative4SPrice                = httpServletRequest.getParameterValues("prpLcomponentNative4SPrice");	  
		String[]   prpLcomponentNativeMarketPrice                = httpServletRequest.getParameterValues("prpLcomponentNativeMarketPrice");	  
		String[]   prpLcomponentNativeMatchPrice                = httpServletRequest.getParameterValues("prpLcomponentNativeMatchPrice");	  
		String[]   prpLcomponentVerpCompPrice                = httpServletRequest.getParameterValues("prpLcomponentVerpCompPrice");	  
		
		
		
		
		//Modify by chenrenda update begin 20050420
		//Reason:定损提交核损时，去掉人员选择，增加核损级别
		String prplCarLossHandlerRange = "";
		int intPrpLcarLossLossItemCode = 0;
		//Modify by chenrenda update end 20050420
		
		if (prpLcarLossLossItemCode==null){
			
		}else{
			
			for(int i=0;i<prpLcarLossLossItemCode.length;i++){
				////System.out.println("--backflag---"+prpLcarLossBackCheckFlag[i]);
				prpLcarLossDto = new PrpLcarLossDto();
				prpLcarLossDto.setPolicyNo(prpLcarLossPolicyNo);
				prpLcarLossDto.setRiskCode(prpLcarLossRiskCode);
				prpLcarLossDto.setClaimNo(claimNo);
				prpLcarLossDto.setRegistNo(prpLcarLossRegistNo);
				prpLcarLossDto.setLossItemCode(prpLcarLossLossItemCode[i]);
				//prpLcarLossDto.setLossItemCode(prpLcarLossLossItemCode[i]);
				
				//Modify by chenrenda update begin 20050420
				//Reason:定损提交核损时，去掉人员选择，增加核损级别
				intPrpLcarLossLossItemCode = Integer.parseInt(DataUtils.nullToZero(prpLcarLossLossItemCode[i]));
				if(intPrpLcarLossLossItemCode>0)
				{
					prplCarLossHandlerRange = httpServletRequest.getParameter("prplCarLossHandlerRange");    	
				}
				prpLcarLossDto.setHandlerRange(prplCarLossHandlerRange);
				//Modify by chenrenda update end 20050420
				
				prpLcarLossDto.setLossItemName        ( prpLcarLossLossItemName      [i]);
				prpLcarLossDto.setCurrency            ( prpLcarLossCurrency          [i]);
				prpLcarLossDto.setSumRest             ( Double.parseDouble(DataUtils.nullToZero(prpLcarLossSumRest           [i])));
				prpLcarLossDto.setSumManager          ( Double.parseDouble(DataUtils.nullToZero(prpLcarLossSumManager        [i])));
				prpLcarLossDto.setSumCertainLoss      ( Double.parseDouble(DataUtils.nullToZero(prpLcarLossSumCertainLoss    [i])));
				prpLcarLossDto.setSumVeriRest         ( Double.parseDouble(DataUtils.nullToZero(prpLcarLossSumVeriRest       [i])));
				prpLcarLossDto.setSumVeriManager      ( Double.parseDouble(DataUtils.nullToZero(prpLcarLossSumVeriManager    [i])));
				prpLcarLossDto.setSumVerifyLoss       ( Double.parseDouble(DataUtils.nullToZero(prpLcarLossSumVerifyLoss     [i])));
				prpLcarLossDto.setLossDesc            ( prpLcarLossLossDesc          [i]);
				prpLcarLossDto.setIndemnityDuty       ( prpLcarLossIndemnityDuty     [i]);
				prpLcarLossDto.setIndemnityDutyRate   ( Double.parseDouble(DataUtils.nullToZero(prpLcarLossIndemnityDutyRate [i])));
				prpLcarLossDto.setVeriIndeDutyRate    ( Double.parseDouble(DataUtils.nullToZero(prpLcarLossVeriIndeDutyRate  [i])));
				prpLcarLossDto.setRemark              ( prpLcarLossRemark            [i]);
				prpLcarLossDto.setVINNo               ( prpLcarLossVINNo             [i]);
				prpLcarLossDto.setSumManageFeeRate    ( Double.parseDouble(DataUtils.nullToZero(prpLcarLossSumManageFeeRate             [i])));
				prpLcarLossDto.setOperatorCode        ( prpLcarLossOperatorCode      [i]);
				prpLcarLossDto.setApproverCode        ( prpLcarLossApproverCode      [i]);
				prpLcarLossDto.setFlag                ( prpLcarLossFlag              [i]);
				prpLcarLossDto.setBackCheckFlag                ( prpLcarLossBackCheckFlag              [i]);
				prpLcarLossDto.setSumTransFee    ( Double.parseDouble(DataUtils.nullToZero(prpLcarLossSumTransFee [i])));
				prpLcarLossDto.setSumTax  ( Double.parseDouble(DataUtils.nullToZero(prpLcarLossSumTax [i])));
				//增加修理厂类型和修理厂名称
				prpLcarLossDto.setRepairFactoryCode(prpLrepairFeeRepairFactoryCode);
				prpLcarLossDto.setRepairFactoryName(prpLrepairFeeRepairFactoryName);
				
								//加入集合
				prpLcarLossDtoList.add(prpLcarLossDto);
				
				//对象赋值
				for(int index1=1;index1<carLossRepairFeeLossItemCode.length;index1++)
				{
					//if(String.valueOf(Integer.parseInt(carLossRepairFeeLossItemCode[index1])+1).equals(prpLcarLossLossItemCode[i])){
					repairFeeNo = repairFeeNo + 1;
					prpLrepairFeeDto = new PrpLrepairFeeDto();
					prpLrepairFeeDto.setPolicyNo(prpLcarLossPolicyNo);
					prpLrepairFeeDto.setRiskCode(prpLcarLossRiskCode);
					prpLrepairFeeDto.setClaimNo(claimNo);
					prpLrepairFeeDto.setRegistNo(prpLcarLossRegistNo);
					
					prpLrepairFeeDto.setSerialNo                   (repairFeeNo);
					//prpLrepairFeeDto.setSerialNo                 (Integer.parseInt(DataUtils.nullToZero(prpLrepairFeeSerialNo[index])));
					prpLrepairFeeDto.setItemKindNo                 (Integer.parseInt(DataUtils.nullToZero(prpLrepairFeeItemKindNo[index1])));
					prpLrepairFeeDto.setLossItemCode               (prpLcarLossLossItemCode[i]);
					//prpLrepairFeeDto.setLossItemCode             (prpLrepairFeeLossItemCode[index]);
					prpLrepairFeeDto.setKindCode                   (prpLrepairFeeKindCode[index1]);
//					===========================================================
					
					if (!registDto.getPrpLregistDto().getPolicyNo().equals("")){
						for (int k=0; k<policyDto.getPrpCitemKindDtoList().size(); k++)       {
							PrpCitemKindDto    prpCitemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(k);
							if (prpCitemKindDto.getKindCode().equals(prpLrepairFeeDto.getKindCode())){
								prpLrepairFeeDto.setItemKindNo(prpCitemKindDto.getItemKindNo());
								break;}
						}
					}
//					===========================================================
					
					prpLrepairFeeDto.setLicenseNo                  (prpLcarLossLossItemName[i]);
					prpLrepairFeeDto.setLicenseColorCode           (prpLcarLossLicenseColorCode[i]);
					prpLrepairFeeDto.setCarKindCode                (prpLcarLossCarKindCode[i]);
					prpLrepairFeeDto.setRepairFactoryCode          (prpLrepairFeeRepairFactoryCode);
					prpLrepairFeeDto.setRepairFactoryName          (prpLrepairFeeRepairFactoryName);
					prpLrepairFeeDto.setHandlerCode                (prpLrepairFeeHandlerCode);
					
					//prpLrepairFeeDto.setRepairStartDate          (new DateTime(new Date(),DateTime.YEAR_TO_DAY));
					//prpLrepairFeeDto.setRepairEndDate            (new DateTime(new Date(),DateTime.YEAR_TO_DAY));
					
					prpLrepairFeeDto.setRepairStartDate            (new DateTime(prpLrepairFeeRepairStartDate));
					prpLrepairFeeDto.setRepairEndDate              (new DateTime(prpLrepairFeeRepairEndDate));
					prpLrepairFeeDto.setSanctioner                 (prpLrepairFeeSanctioner[index1]);
					prpLrepairFeeDto.setApproverCode               (prpLrepairFeeApproverCode[index1]);
					prpLrepairFeeDto.setOperatorCode               (prpLrepairFeeOperatorCode[index1]);
					
					//Modify by chenrenda add begin 20050413
					//Reason:在修理清单中加上损失部位、修理方式
					prpLrepairFeeDto.setPartCode(prpLrepairFeePartCode[index1]);
					prpLrepairFeeDto.setPartName(prpLrepairFeePartName[index1]);
					prpLrepairFeeDto.setRepairType(prpLrepairFeeRepairType[index1]);
					//Modify by chenrenda add end 20050413 
					
					
					prpLrepairFeeDto.setCompCode                   (prpLrepairFeeCompCode[index1]);
					prpLrepairFeeDto.setCompName                   (prpLrepairFeeCompName[index1]);
					prpLrepairFeeDto.setManHour                    (Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeManHour[index1])));
					prpLrepairFeeDto.setManHourUnitPrice           (Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeManHourUnitPrice[index1])));
					//prpLrepairFeeDto.setManHourUnitPrice           (Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeMaterialFee[index1])));
					
					
					prpLrepairFeeDto.setManHourFee                 (Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeManHourFee[index1])));
					prpLrepairFeeDto.setMaterialFee                (Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeMaterialFee[index1])));
					prpLrepairFeeDto.setLossRate                   (Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeLossRate[index1])));
					prpLrepairFeeDto.setCurrency                   (prpLrepairFeeCurrency[index1]);
					
					prpLrepairFeeDto.setSumDefLoss                 (Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeSumDefLoss[index1])));
					prpLrepairFeeDto.setFirstSumDefLoss           (Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeFirstSumDefLoss[index1])));			  
					
					prpLrepairFeeDto.setRemark                     (prpLrepairFeeRemark[index1]);
					prpLrepairFeeDto.setVeriManHour                (Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeVeriManHour[index1])));
					prpLrepairFeeDto.setVeriManUnitPrice           (Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeVeriManUnitPrice[index1])));
					prpLrepairFeeDto.setVeriManHourFee             (Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeVeriManHourFee[index1])));
					prpLrepairFeeDto.setVeriMaterQuantity          (Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeVeriMaterQuantity[index1])));
					prpLrepairFeeDto.setVeriMaterUnitPrice         (Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeVeriMaterUnitPrice[index1])));
					prpLrepairFeeDto.setVeriMaterialFee            (Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeVeriMaterialFee[index1])));
					prpLrepairFeeDto.setVeriLossRate               (Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeVeriLossRate[index1])));
					prpLrepairFeeDto.setVeriSumLoss                (Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeVeriSumLoss[index1])));
					prpLrepairFeeDto.setVeriRemark                 (prpLrepairFeeVeriRemark[index1]);
					prpLrepairFeeDto.setFlag                       (prpLrepairFeeFlag[index1]);
//	        		add by lixiang start at 2006-04-21
	        	    //reason: 增加保存理算退回的定损的标志的保存,若有数据不会被保存冲掉
	                prpLrepairFeeDto.setCompensateBackFlag(prpLrepairFeeCompensateBackFlag[index1]);
	        		//add by lixiang end at 2006-04-21
					//加入集合
					prpLrepairFeeDtoList.add(prpLrepairFeeDto);
					//}
				}
				
				//对象赋值
				for(int index2=1;index2<carLossComponentLossItemCode.length;index2++)
				{
					//if(String.valueOf(Integer.parseInt(carLossComponentLossItemCode[index2])+1).equals(prpLcarLossLossItemCode[i])){
					componentNo = componentNo + 1;
					prpLcomponentDto = new PrpLcomponentDto();
					prpLcomponentDto.setPolicyNo(prpLcarLossPolicyNo);
					prpLcomponentDto.setRiskCode(prpLcarLossRiskCode);
					prpLcomponentDto.setClaimNo(claimNo);
					prpLcomponentDto.setRegistNo(prpLcarLossRegistNo);
					prpLcomponentDto.setSerialNo            (componentNo);
					//prpLcomponentDto.setSerialNo          (Integer.parseInt(DataUtils.nullToZero(prpLcomponentSerialNo[index2])));
					prpLcomponentDto.setItemKindNo         	(Integer.parseInt(DataUtils.nullToZero(prpLcomponentItemKindNo[index2])));
					prpLcomponentDto.setKindCode            (prpLcomponentKindCode[index2]);
					prpLcomponentDto.setIndId				(Integer.parseInt(DataUtils.nullToZero(prpLcomponentIndId[index2])));
//					===========================================================	
					if (!registDto.getPrpLregistDto().getPolicyNo().equals("")){
						
						for (int k=0; k<policyDto.getPrpCitemKindDtoList().size(); k++)       {
							PrpCitemKindDto    prpCitemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(k);
							if (prpCitemKindDto.getKindCode().equals(prpLcomponentDto.getKindCode())){
								prpLcomponentDto.setItemKindNo(prpCitemKindDto.getItemKindNo());
								break;}
						}}
//					===========================================================
					
					prpLcomponentDto.setLossItemCode           (prpLcarLossLossItemCode[i]);
					//prpLcomponentDto.setLossItemCode         (prpLcomponentLossItemCode[index2]);
					prpLcomponentDto.setLicenseNo              (prpLcarLossLossItemName[i]);
					prpLcomponentDto.setLicenseColorCode       (prpLcarLossLicenseColorCode[i]);
					prpLcomponentDto.setCarKindCode            (prpLcarLossCarKindCode[i]);
					prpLcomponentDto.setMakeYear               (prpLcomponentMakeYear[index2]);
					prpLcomponentDto.setGearboxType            (prpLcomponentGearboxType[index2]);
					prpLcomponentDto.setQuoteCompanyGrade      (prpLcomponentQuoteCompanyGrade[index2]);
					prpLcomponentDto.setManageFeeRate          (Double.parseDouble(DataUtils.nullToZero(prpLcomponentManageFeeRate[index2])));
					prpLcomponentDto.setRepairFactoryCode      (prpLcomponentRepairFactoryCode);
					prpLcomponentDto.setRepairFactoryName      (prpLcomponentRepairFactoryName);
					prpLcomponentDto.setHandlerCode            (prpLcomponentHandlerCode);
					//prpLcomponentDto.setRepairStartDate      (new DateTime(prpLcomponentRepairStartDate[index2]));
					//prpLcomponentDto.setRepairEndDate        (new DateTime(prpLcomponentRepairEndDate[index2]));
					prpLcomponentDto.setRepairStartDate        (new DateTime(new Date(),DateTime.YEAR_TO_DAY));
					prpLcomponentDto.setRepairEndDate          (new DateTime(new Date(),DateTime.YEAR_TO_DAY));
					
					
					prpLcomponentDto.setSanctioner             (prpLcomponentSanctioner[index2]);
					prpLcomponentDto.setApproverCode           (prpLcomponentApproverCode[index2]);
					prpLcomponentDto.setOperatorCode           (prpLcomponentOperatorCode[index2]);
					//Modify by chenrenda add begin 20050413
					//Reason:在换件清单中加上损失部位
					//////System.out.println("111:"+prpLcomponentPartCode[index2]);
					//////System.out.println("111:"+prpLcomponentPartName[index2]);
					
					prpLcomponentDto.setPartCode(prpLcomponentPartCode[index2]);
					prpLcomponentDto.setPartName(prpLcomponentPartName[index2]);
//					prpLcomponentDto.setPartDesc               ("");
					//Modify by chenrenda add end 20050413
					
				    prpLcomponentDto.setOriginalId               (prpLcomponentOriginalId[index2]);
					
					

					prpLcomponentDto.setSys4SPrice               (Double.parseDouble(DataUtils.nullToZero(prpLcomponentSys4SPrice[index2])));
					prpLcomponentDto.setSysMarketPrice               (Double.parseDouble(DataUtils.nullToZero(prpLcomponentSysMarketPrice[index2])));
					prpLcomponentDto.setSysMatchPrice               (Double.parseDouble(DataUtils.nullToZero(prpLcomponentSysMatchPrice[index2])));
					prpLcomponentDto.setNative4SPrice               (Double.parseDouble(DataUtils.nullToZero(prpLcomponentNative4SPrice[index2])));
					prpLcomponentDto.setNativeMarketPrice               (Double.parseDouble(DataUtils.nullToZero(prpLcomponentNativeMarketPrice[index2])));
					prpLcomponentDto.setNativeMatchPrice               (Double.parseDouble(DataUtils.nullToZero(prpLcomponentNativeMatchPrice[index2])));
					prpLcomponentDto.setVerpCompPrice               (Double.parseDouble(DataUtils.nullToZero(prpLcomponentVerpCompPrice[index2])));
					
					
					
					
					
					prpLcomponentDto.setCompName               (prpLcomponentCompName[index2]);
				//	if(prpLcomponentCompCode[index2]==null||prpLcomponentCompCode[index2].trim().length()==0){
				//		prpLcomponentDto.setCompCode               ("00");
				//	}else{
						prpLcomponentDto.setCompCode               (prpLcomponentCompCode[index2]);
				//	}
					prpLcomponentDto.setQuantity               (Integer.parseInt(DataUtils.nullToZero(prpLcomponentQuantity[index2])));
					prpLcomponentDto.setManHourFee             (Double.parseDouble(DataUtils.nullToZero(prpLcomponentManHourFee[index2])));
					prpLcomponentDto.setMaterialFee            (Double.parseDouble(DataUtils.nullToZero(prpLcomponentMaterialFee[index2])));
					
					
					prpLcomponentDto.setRestFee                (Double.parseDouble(DataUtils.nullToZero(prpLcomponentRestFee[index2])));
					prpLcomponentDto.setVeriRestFee            (Double.parseDouble(DataUtils.nullToZero(prpLcomponentVeriRestFee[index2])));
					prpLcomponentDto.setVeriRestFee            (Double.parseDouble(DataUtils.nullToZero(prpLcomponentRestFee[index2])));
					prpLcomponentDto.setQueryPrice             (Double.parseDouble(DataUtils.nullToZero(prpLcomponentQueryPrice[index2])));
					prpLcomponentDto.setQuotedPrice            (Double.parseDouble(DataUtils.nullToZero(prpLcomponentQuotedPrice[index2])));
					
//					prpLcomponentDto.setFirstMaterialFee           (Double.parseDouble(DataUtils.nullToZero(prpLcomponentFirstMaterialFee[index2])));
					
					prpLcomponentDto.setLossRate               (Double.parseDouble(DataUtils.nullToZero(prpLcomponentLossRate[index2])));
					prpLcomponentDto.setCurrency               (prpLcomponentCurrency[index2]);
					prpLcomponentDto.setSumDefLoss             (Double.parseDouble(DataUtils.nullToZero(prpLcomponentSumDefLoss[index2])));
					prpLcomponentDto.setRemark                 (prpLcomponentRemark[index2]);
					prpLcomponentDto.setVeriQuantity           (Integer.parseInt(DataUtils.nullToZero(prpLcomponentVeriQuantity[index2])));
					prpLcomponentDto.setVeriManHourFee         (Double.parseDouble(DataUtils.nullToZero(prpLcomponentVeriManHourFee[index2])));
					prpLcomponentDto.setVeriMaterFee           (Double.parseDouble(DataUtils.nullToZero(prpLcomponentVeriMaterFee[index2])));
					prpLcomponentDto.setVeriLossRate           (Double.parseDouble(DataUtils.nullToZero(prpLcomponentVeriLossRate[index2])));
					prpLcomponentDto.setSumVeriLoss            (Double.parseDouble(DataUtils.nullToZero(prpLcomponentSumVeriLoss[index2])));
					prpLcomponentDto.setVeriRemark             (prpLcomponentVeriRemark[index2]);
					prpLcomponentDto.setFlag                   (prpLcomponentFlag[index2]);
//	        		add by lixiang start at 2006-04-21
	        	    //reason: 增加保存理算退回的定损的标志的保存,若有数据不会被保存冲掉
	                prpLcomponentDto.setCompensateBackFlag(prpLcomponentCompensateBackFlag[index2]);
	        		//add by lixiang end at 2006-04-21
	                  //加入集合
	 
					//加入集合
					
					prpLcomponentDtoList.add(prpLcomponentDto);
					//}
				}
			}
			PropertyUtils.copyProperties(LossItemRepairComponentDto,certainLossDto.getPrpLverifyLossDto());
			LossItemRepairComponentDto.setSerialNo(1);
			LossItemRepairComponentDto.setLossType("1");
			LossItemRepairComponentDto.setNodeType("certa");
			lossItemListTemp.add(LossItemRepairComponentDto);
		}
		//定损车辆表
		certainLossDto.setPrpLcarLossDtoList(prpLcarLossDtoList);
		certainLossDto.setPrpLrepairFeeDtoList(prpLrepairFeeDtoList);
		certainLossDto.setPrpLcomponentDtoList(prpLcomponentDtoList);
		
		/*---------------------人员伤亡明细信息表 prpLperson ------------------------------------*/
		ArrayList prpLpersonDtoList = new ArrayList();
		PrpLpersonDto prpLpersonDto = null;
		
		//从界面得到输入数组
		String   prpLpersonPolicyNo              = httpServletRequest.getParameter("prpLverifyLossPolicyNo");
		String   prpLpersonRiskCode              = httpServletRequest.getParameter("prpLverifyLossRiskCode");
		String   prpLpersonClaimNo               = httpServletRequest.getParameter("prpLverifyLossClaimNo");
		String   prpLpersonRegistNo              = httpServletRequest.getParameter("prpLverifyLossRegistNo");
		String[]   personSerialNo                = httpServletRequest.getParameterValues("personSerialNo");
		String[]   prpLpersonSerialNo            = httpServletRequest.getParameterValues("prpLpersonSerialNo");
		String[]   prpLpersonItemKindNo          = httpServletRequest.getParameterValues("prpLpersonItemKindNo");
		String[]   prpLpersonFamilyNo            = httpServletRequest.getParameterValues("prpLpersonFamilyNo");
		String[]   prpLpersonFamilyName          = httpServletRequest.getParameterValues("prpLpersonFamilyName");
		String[]   familyName                    = httpServletRequest.getParameterValues("familyName");
		String[]   prpLpersonKindCode            = httpServletRequest.getParameterValues("prpLpersonKindCode");
		String[]   prpLpersonItemCode            = httpServletRequest.getParameterValues("prpLpersonItemCode");
		String[]   prpLpersonAreaCode            = httpServletRequest.getParameterValues("prpLpersonAreaCode");
		String[]   prpLpersonFixedIncomeFlag     = httpServletRequest.getParameterValues("prpLpersonFixedIncomeFlag");
		String[]   prpLpersonJobCode             = httpServletRequest.getParameterValues("prpLpersonJobCode");
		String[]   prpLpersonJobName             = httpServletRequest.getParameterValues("prpLpersonJobName");
		String[]   prpLpersonPayPersonType       = httpServletRequest.getParameterValues("prpLpersonPayPersonType");
		String[]   prpLpersonFeeTypeCode         = httpServletRequest.getParameterValues("prpLpersonFeeTypeCode");
		String[]   prpLpersonFeeTypeName         = httpServletRequest.getParameterValues("prpLpersonFeeTypeName");
		String[]   prpLpersonPersonNo            = httpServletRequest.getParameterValues("prpLpersonPersonNo");
		String[]   prpLpersonPersonName          = httpServletRequest.getParameterValues("prpLpersonPersonName");
		String[]   prpLpersonPersonSex           = httpServletRequest.getParameterValues("prpLpersonPersonSex");
		
		String[] prpLpersonJobUnit = httpServletRequest.getParameterValues("prpLpersonJobUnit");
		String[] prpLpersonMonthStdWage = httpServletRequest.getParameterValues("prpLpersonMonthStdWage");
		String[] prpLpersonMonthBonus = httpServletRequest.getParameterValues("prpLpersonMonthBonus");
		String[] prpLpersonAllowance = httpServletRequest.getParameterValues("prpLpersonAllowance");
		String[] prpLpersonMonthWage = httpServletRequest.getParameterValues("prpLpersonMonthWage");
		String[] prpLpersonHospital = httpServletRequest.getParameterValues("prpLpersonHospital");
		String[] prpLpersonNursePersons = httpServletRequest.getParameterValues("prpLpersonNursePersons");
		String[] prpLpersonNurseDays = httpServletRequest.getParameterValues("prpLpersonNurseDays");
		String[] prpLpersonDiagnose = httpServletRequest.getParameterValues("prpLpersonDiagnose");
		String[] prpLpersonWoundGrade = httpServletRequest.getParameterValues("prpLpersonWoundGrade");
		String[] prpLpersonHospitalDays = httpServletRequest.getParameterValues("prpLpersonHospitalDays");
		String[] prpLpersonCureDays = httpServletRequest.getParameterValues("prpLpersonCureDays");
		String[] prpLpersonChangeHospital = httpServletRequest.getParameterValues("prpLpersonChangeHospital");
		String[]   prpLpersonPersonAge           = httpServletRequest.getParameterValues("prpLpersonPersonAge");
		String[]   prpLpersonCurrency            = httpServletRequest.getParameterValues("prpLpersonCurrency");
		String[]   prpLpersonIdentifyNumber      = httpServletRequest.getParameterValues("prpLpersonIdentifyNumber");
		String[]   prpLpersonRelatePersonNo      = httpServletRequest.getParameterValues("prpLpersonRelatePersonNo");
		String[]   prpLpersonUnitLoss            = httpServletRequest.getParameterValues("prpLpersonUnitLoss");
		String[]   prpLpersonQuantity            = httpServletRequest.getParameterValues("prpLpersonQuantity");
		String[]   prpLpersonUnit                = httpServletRequest.getParameterValues("prpLpersonUnit");
		String[]   prpLpersonTimes               = httpServletRequest.getParameterValues("prpLpersonTimes");
		String[]   prpLpersonSumLoss             = httpServletRequest.getParameterValues("prpLpersonSumLoss");
		String[]   prpLpersonSumReject           = httpServletRequest.getParameterValues("prpLpersonSumReject");
		String[]   prpLpersonRejectReason        = httpServletRequest.getParameterValues("prpLpersonRejectReason");
		String[]   prpLpersonLossRate            = httpServletRequest.getParameterValues("prpLpersonLossRate");
		String[]   prpLpersonSumDefLoss          = httpServletRequest.getParameterValues("prpLpersonSumDefLoss");
		String[]   prpLpersonRemark              = httpServletRequest.getParameterValues("prpLpersonRemark");
		String[]   prpLpersonVeriQuantity         = httpServletRequest.getParameterValues("prpLpersonVeriQuantity");
		String[]   prpLpersonVeriUnitLoss         = httpServletRequest.getParameterValues("prpLpersonVeriUnitLoss");
		String[]   prpLpersonVeriUnit            = httpServletRequest.getParameterValues("prpLpersonVeriUnit");
		String[]   prpLpersonVeriTimes           = httpServletRequest.getParameterValues("prpLpersonVeriTimes");
		String[]   prpLpersonVeriSumLoss         = httpServletRequest.getParameterValues("prpLpersonVeriSumLoss");
		String[]   prpLpersonVeriSumReject       = httpServletRequest.getParameterValues("prpLpersonVeriSumReject");
		String[]   prpLpersonVeriRejectReason    = httpServletRequest.getParameterValues("prpLpersonVeriRejectReason");
		String[]   prpLpersonVeriLossRate        = httpServletRequest.getParameterValues("prpLpersonVeriLossRate");
		String[]   prpLpersonVeriSumDefLoss      = httpServletRequest.getParameterValues("prpLpersonVeriSumDefLoss");
		String[]   prpLpersonVeriRemark          = httpServletRequest.getParameterValues("prpLpersonVeriRemark");
		String[]   prpLpersonFlag                = httpServletRequest.getParameterValues("prpLpersonFlag");
//		add by lixiang start at 2006-04-21
	    //reason: 增加保存理算退回的定损的标志的保存,若有数据不会被保存冲掉
	  String[]   prpLpersonCompensateBackFlag  = httpServletRequest.getParameterValues("prpLpersonCompensateBackFlag");
		//add by lixiang end at 2006-04-21

		//modify by wangli add start 20050401
		//reason:保存继医情况说明 等
		String[]   prpLpersonFllowHospRemark              = httpServletRequest.getParameterValues("prpLpersonFllowHospRemark");//继医情况说明
		String[]   prpLpersonInHospDate                = httpServletRequest.getParameterValues("prpLpersonInHospDate");        //入院日期
		String[]   prpLpersonOutHospDate                = httpServletRequest.getParameterValues("prpLpersonOutHospDate");      //出院日期
		String[]   prpLpersonRestDate                = httpServletRequest.getParameterValues("prpLpersonRestDate");           //定残日期
		
		//modify by wangli add end 20050401
		//对象赋值
		if (personSerialNo==null){
			
		}else{
			for(int index=1;index<personSerialNo.length;index++)
			{
				prpLpersonDto = new PrpLpersonDto();
				prpLpersonDto.setPolicyNo(prpLpersonPolicyNo);
				prpLpersonDto.setRiskCode(prpLpersonRiskCode);
				prpLpersonDto.setClaimNo(claimNo);
				prpLpersonDto.setRegistNo(prpLpersonRegistNo);
				//
				prpLpersonDto.setSerialNo           ( index);
				//prpLpersonDto.setSerialNo         ( Integer.parseInt(DataUtils.nullToZero(personSerialNo [index])));
				
				prpLpersonDto.setFeeTypeCode        ( prpLpersonFeeTypeCode [index]);
				prpLpersonDto.setFeeTypeName        ( prpLpersonFeeTypeName [index]);
				//prpLpersonDto.setUnitLoss           ( Double.parseDouble(DataUtils.nullToZero( prpLpersonUnitLoss [index])));
				//prpLpersonDto.setQuantity           ( Double.parseDouble(DataUtils.nullToZero( prpLpersonQuantity [index])));
				prpLpersonDto.setSumLoss            ( Double.parseDouble(DataUtils.nullToZero(  prpLpersonSumLoss [index])));
				prpLpersonDto.setSumReject          ( Double.parseDouble(DataUtils.nullToZero(  prpLpersonSumReject [index])));
				prpLpersonDto.setSumDefLoss         ( Double.parseDouble(DataUtils.nullToZero(  prpLpersonSumDefLoss [index])));
				prpLpersonDto.setItemKindNo         ( Integer.parseInt(DataUtils.nullToZero( prpLpersonItemKindNo [index])));
				prpLpersonDto.setFamilyNo           ( Integer.parseInt(DataUtils.nullToZero( prpLpersonFamilyNo [index])));
				prpLpersonDto.setItemCode           ( prpLpersonItemCode [index]);
				//prpLpersonDto.setPersonNo         ( Integer.parseInt(DataUtils.nullToZero( prpLpersonPersonNo [index])));
				prpLpersonDto.setUnit               ( prpLpersonUnit [index]);
				prpLpersonDto.setTimes              ( Double.parseDouble(DataUtils.nullToZero(  prpLpersonTimes [index])));
				//modify by wangli remark 20050425
				prpLpersonDto.setRejectReason       ( prpLpersonRejectReason [index]);
				System.out.println("--------prpLpersonDto.getRejectReason: -------------"+prpLpersonDto.getRejectReason());
				//modify by wangli end 20050425
				prpLpersonDto.setVeriQuantity        ( Double.parseDouble(DataUtils.nullToZero(  prpLpersonVeriQuantity [index])));
				prpLpersonDto.setVeriUnitLoss       ( Double.parseDouble(DataUtils.nullToZero(  prpLpersonVeriUnitLoss [index])));
				prpLpersonDto.setVeriUnit           ( prpLpersonVeriUnit [index]);
				prpLpersonDto.setVeriTimes          ( Double.parseDouble(DataUtils.nullToZero( prpLpersonVeriTimes [index])));
				prpLpersonDto.setVeriSumLoss        ( Double.parseDouble(DataUtils.nullToZero( prpLpersonVeriSumLoss [index])));
				prpLpersonDto.setVeriSumReject      ( Double.parseDouble(DataUtils.nullToZero(  prpLpersonVeriSumReject [index])));
				prpLpersonDto.setVeriRejectReason   ( prpLpersonVeriRejectReason [index]);
				prpLpersonDto.setVeriLossRate       ( Double.parseDouble(DataUtils.nullToZero(  prpLpersonVeriLossRate [index])));
				prpLpersonDto.setVeriSumDefLoss     ( Double.parseDouble(DataUtils.nullToZero( prpLpersonVeriSumDefLoss [index])));
				prpLpersonDto.setVeriRemark         ( prpLpersonVeriRemark [index]);
				prpLpersonDto.setFlag               ( prpLpersonFlag [index]);
		        prpLpersonDto.setCompensateBackFlag (  prpLpersonCompensateBackFlag [index]); 

				for (int index2 = 0; index2 < prpLpersonSerialNo.length; index2++) {
					if(prpLpersonSerialNo[index2].equals(personSerialNo[index])){
						//
						prpLpersonDto.setFamilyName(familyName[index2]);
						prpLpersonDto.setAreaCode(prpLpersonAreaCode[index2]);
						prpLpersonDto.setFixedIncomeFlag(prpLpersonFixedIncomeFlag[index2]);
						prpLpersonDto.setJobCode(prpLpersonJobCode[index2]);
						prpLpersonDto.setJobName(prpLpersonJobName[index2]);
						prpLpersonDto.setPayPersonType(prpLpersonPayPersonType[index2]);
						prpLpersonDto.setPersonName(prpLpersonPersonName[index2]);
						prpLpersonDto.setPersonSex(prpLpersonPersonSex[index2]);
						prpLpersonDto.setKindCode           ( prpLpersonKindCode [index2]);
//						===========================================================
						
						if (!registDto.getPrpLregistDto().getPolicyNo().equals("")){					
							for (int k=0; k<policyDto.getPrpCitemKindDtoList().size(); k++)       {
								PrpCitemKindDto    prpCitemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(k);
								if (prpCitemKindDto.getKindCode().equals(prpLpersonDto.getKindCode())){
									prpLpersonDto.setItemKindNo(prpCitemKindDto.getItemKindNo());
									break;}
							}
						}
//						===========================================================			  
						prpLpersonDto.setJobUnit(prpLpersonJobUnit[index2]);
						prpLpersonDto.setMonthStdWage(Double.parseDouble(DataUtils.nullToZero(prpLpersonMonthStdWage[index2])));
						prpLpersonDto.setMonthBonus(Double.parseDouble(DataUtils.nullToZero(prpLpersonMonthBonus[index2])));
						prpLpersonDto.setAllowance(Double.parseDouble(DataUtils.nullToZero(prpLpersonAllowance[index2])));
						prpLpersonDto.setMonthWage(Double.parseDouble(DataUtils.nullToZero(prpLpersonMonthWage[index2])));
						prpLpersonDto.setHospital(prpLpersonHospital[index2]);
						prpLpersonDto.setNursePersons(Integer.parseInt(DataUtils.nullToZero(prpLpersonNursePersons[index2])));
						prpLpersonDto.setNurseDays(Integer.parseInt(DataUtils.nullToZero(prpLpersonNurseDays[index2])));
						prpLpersonDto.setDiagnose(prpLpersonDiagnose[index2]);
						prpLpersonDto.setWoundGrade(prpLpersonWoundGrade[index2]);
						prpLpersonDto.setHospitalDays(Integer.parseInt(DataUtils.nullToZero(prpLpersonHospitalDays[index2])));
						prpLpersonDto.setCureDays(Integer.parseInt(DataUtils.nullToZero(prpLpersonCureDays[index2])));
						prpLpersonDto.setChangeHospital(prpLpersonChangeHospital[index2]);
						
						prpLpersonDto.setPersonAge(Integer.parseInt(DataUtils.nullToZero(prpLpersonPersonAge[index2])));
						prpLpersonDto.setCurrency(prpLpersonCurrency[index2]);
						prpLpersonDto.setIdentifyNumber(prpLpersonIdentifyNumber[index2]);
						prpLpersonDto.setRelatePersonNo(Integer.parseInt(DataUtils.nullToZero(prpLpersonRelatePersonNo[index2])));
						prpLpersonDto.setLossRate(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossRate[index2])));
						prpLpersonDto.setRemark(prpLpersonRemark[index2]);
						prpLpersonDto.setPersonNo           (index2);
						
						//modify by wangli add start 20050401
						prpLpersonDto.setFllowHospRemark(prpLpersonFllowHospRemark[index2]);
						prpLpersonDto.setInHospDate(new DateTime(prpLpersonInHospDate[index2],DateTime.YEAR_TO_DAY));
						prpLpersonDto.setOutHospDate(new DateTime(prpLpersonOutHospDate[index2],DateTime.YEAR_TO_DAY));
						prpLpersonDto.setRestDate  (new DateTime(prpLpersonRestDate[index2],DateTime.YEAR_TO_DAY));			
						//modify by wangli add end 20050401
						
					}
				}
				//加入集合
				prpLpersonDtoList.add(prpLpersonDto);
			}
			PropertyUtils.copyProperties(LossItemPersonDto,certainLossDto.getPrpLverifyLossDto());
			LossItemPersonDto.setSerialNo(0);
			LossItemPersonDto.setLossType("0");
			LossItemPersonDto.setNodeType("certa");
////			System.out.println("-------------对象-----1--------"+LossItemPersonDto);
////			System.out.println("-------------对象----2--------"+certainLossDto.getPrpLverifyLossDto());
			lossItemListTemp.add(LossItemPersonDto);
		}
		//财产核定损明细清单表
		certainLossDto.setPrpLpersonDtoList(prpLpersonDtoList);
		certainLossDto.setPrpLverifyLossItemDtoList(lossItemListTemp);
		
		/*---------------------伤情信息表 PrpLpersonWound ------------------------------------*/
		ArrayList prpLpersonWoundDtoList = new ArrayList();
		PrpLpersonWoundDto prpLpersonWoundDto = null;
		
		//从界面得到输入数组
		String[]   woundCodeCheck001Txt  = httpServletRequest.getParameterValues("woundCodeCheck001Txt");
		String[]   woundCodeCheck002Txt  = httpServletRequest.getParameterValues("woundCodeCheck002Txt");
		String[]   woundCodeCheck003Txt  = httpServletRequest.getParameterValues("woundCodeCheck003Txt");
		String[]   woundCodeCheck004Txt  = httpServletRequest.getParameterValues("woundCodeCheck004Txt");
		String[]   woundCodeCheck005Txt  = httpServletRequest.getParameterValues("woundCodeCheck005Txt");
		String[]   woundCodeCheck006Txt  = httpServletRequest.getParameterValues("woundCodeCheck006Txt");
		String[]   woundCodeCheck007Txt  = httpServletRequest.getParameterValues("woundCodeCheck007Txt");
		String[]   woundCodeCheck008Txt  = httpServletRequest.getParameterValues("woundCodeCheck008Txt");
		String[]   woundCodeCheck009Txt  = httpServletRequest.getParameterValues("woundCodeCheck009Txt");
		String[]   woundCodeCheck010Txt  = httpServletRequest.getParameterValues("woundCodeCheck010Txt");
		String[]   woundCodeCheck011Txt  = httpServletRequest.getParameterValues("woundCodeCheck011Txt");
		String[]   woundCodeCheck012Txt  = httpServletRequest.getParameterValues("woundCodeCheck012Txt");
		String[]   woundCodeCheck013Txt  = httpServletRequest.getParameterValues("woundCodeCheck013Txt");
		String[]   woundCodeCheck014Txt  = httpServletRequest.getParameterValues("woundCodeCheck014Txt");
		String[]   woundCodeCheck015Txt  = httpServletRequest.getParameterValues("woundCodeCheck015Txt");
		String[]   woundCodeCheck016Txt  = httpServletRequest.getParameterValues("woundCodeCheck016Txt");
		String[]   woundCodeCheck017Txt  = httpServletRequest.getParameterValues("woundCodeCheck017Txt");
		String[]   woundCodeCheck018Txt  = httpServletRequest.getParameterValues("woundCodeCheck018Txt");
		String[]   woundCodeCheck019Txt  = httpServletRequest.getParameterValues("woundCodeCheck019Txt");
		String[]   woundCodeCheck020Txt  = httpServletRequest.getParameterValues("woundCodeCheck020Txt");
		String[]   woundCodeCheck021Txt  = httpServletRequest.getParameterValues("woundCodeCheck021Txt");
		String[]   woundCodeCheck022Txt  = httpServletRequest.getParameterValues("woundCodeCheck022Txt");
		String[]   woundCodeCheck023Txt  = httpServletRequest.getParameterValues("woundCodeCheck023Txt");
		String[]   woundCodeCheck024Txt  = httpServletRequest.getParameterValues("woundCodeCheck024Txt");
		
		//取得伤情损伤的代码信息
		UICodeAction uiCodeAction = new UICodeAction();
		List woundCodeList = (ArrayList)uiCodeAction.getCodeType("WoundCode",null);
		Map woundCodeMap = new HashMap();
		for (int i = 0; i < woundCodeList.size(); i++) {
			PrpDcodeDto prpDcodeDto = (PrpDcodeDto)woundCodeList.get(i);
			woundCodeMap.put(prpDcodeDto.getCodeCode(),prpDcodeDto.getCodeCName());
		}
		int intSerialNo = 1;
		if (woundCodeCheck001Txt==null){
			
		}else{
			for(int index=1;index<woundCodeCheck001Txt.length;index++){
				intSerialNo = 1;
				if(woundCodeCheck001Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("001");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("001"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck002Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("002");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("002"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck003Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("003");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("003"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck004Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("004");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("004"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck005Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("005");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("005"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck006Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("006");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("006"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck007Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("007");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("007"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck008Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("008");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("008"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck009Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("009");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("009"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck010Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("010");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("010"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck011Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("011");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("011"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck012Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("012");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("012"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck013Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("013");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("013"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck014Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("014");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("014"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck015Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("015");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("015"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck016Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("016");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("016"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck017Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("017");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("017"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck018Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("018");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("018"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck019Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("019");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("019"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck020Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("020");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("020"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck021Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("021");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("021"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck022Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("022");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("022"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck023Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("023");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("023"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
				if(woundCodeCheck024Txt[index].trim().equals("1")){
					prpLpersonWoundDto = new PrpLpersonWoundDto();
					prpLpersonWoundDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
					prpLpersonWoundDto.setClaimNo(claimNo);
					prpLpersonWoundDto.setPolicyNo(certainLossDto.getPrpLverifyLossDto().getPolicyNo());
					prpLpersonWoundDto.setSerialNo(intSerialNo);
					prpLpersonWoundDto.setPersonNo(index);
					prpLpersonWoundDto.setPersonName(prpLpersonPersonName[index]);
					prpLpersonWoundDto.setWoundCode("024");
					prpLpersonWoundDto.setWoundDesc((String)woundCodeMap.get("024"));
					prpLpersonWoundDto.setFlag("");
					prpLpersonWoundDtoList.add(prpLpersonWoundDto);
				}
				intSerialNo++;
			}
		}
		certainLossDto.setPrpLpersonWoundDtoList(prpLpersonWoundDtoList);
		
		
		/*---------------------定核损信息补充说明 PrpLverifyLossExt ------------------------------------*/
		ArrayList prpLverifyLossExtDtoList = new ArrayList();
		PrpLverifyLossExtDto prpLverifyLossExtDto = null ;
		//从界面得到输入数组
		String prpLverifyLossExtRegistNo = (String)httpServletRequest.getParameter("prpLverifyLossExtRegistNo"); 
		String prpLverifyLossExtRiskCode = httpServletRequest.getParameter      ("prpLverifyLossExtRiskCode");
		String[] prpLverifyLossExtSerialNo = httpServletRequest.getParameterValues("prpLverifyLossExtSerialNo");
		String[] prpLverifyLossExtInputDate = httpServletRequest.getParameterValues("prpLverifyLossExtInputDate");
		String[] prpLverifyLossExtInputHour = httpServletRequest.getParameterValues("prpLverifyLossExtInputHour");
		String[] prpLverifyLossExtOperatorCode = httpServletRequest.getParameterValues("prpLverifyLossExtOperatorCode");
		String[] prpLverifyLossExtTitle = httpServletRequest.getParameterValues("prpLverifyLossExtTitle");
		String[] prpLverifyLossExtContext = httpServletRequest.getParameterValues("prpLverifyLossExtContext");
		String  prpLverifyLossExtLossItemCode = httpServletRequest.getParameter("prpLcarLossLossItemCode");
		System.out.println("===================[ 车号]================"+ prpLverifyLossExtLossItemCode);
		//财产定损时，保存定损信息，此时损失标的代码为-1
		if(prpLverifyLossExtLossItemCode == null){
			prpLverifyLossExtLossItemCode = httpServletRequest.getParameter("prpLpropLossLossItemCode");
		}
		
		//对象赋值
		//人员伤亡跟踪 部分开始
		if (prpLverifyLossExtSerialNo==null)
		{}
		else
		{
			//System.out.println("人员伤亡跟踪部分开始 ");
			for(int index=1;index<prpLverifyLossExtSerialNo.length;index++)
			{
				prpLverifyLossExtDto = new PrpLverifyLossExtDto();
				prpLverifyLossExtDto.setRegistNo(prpLverifyLossExtRegistNo);
				prpLverifyLossExtDto.setRiskCode(prpLverifyLossExtRiskCode);
				prpLverifyLossExtDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLverifyLossExtSerialNo[index])));
				prpLverifyLossExtDto.setInputDate(new DateTime(prpLverifyLossExtInputDate[index],DateTime.YEAR_TO_DAY ));
				prpLverifyLossExtDto.setInputHour(prpLverifyLossExtInputHour[index]);
				prpLverifyLossExtDto.setOperatorCode(prpLverifyLossExtOperatorCode[index]);
				prpLverifyLossExtDto.setTitle(prpLverifyLossExtTitle[index]);
				prpLverifyLossExtDto.setContext(prpLverifyLossExtContext[index]);
				prpLverifyLossExtDto.setLossItemCode(prpLverifyLossExtLossItemCode);
				//加入集合
				prpLverifyLossExtDtoList.add(prpLverifyLossExtDto);
			}
			//报案集合中加入损失部位
			certainLossDto.setPrpLverifyLossExtDtoList(prpLverifyLossExtDtoList);
		}        
		
		/*---------------------报案信息补充说明 PrpLregistExt ------------------------------------*/
		ArrayList prpLregistExtDtoList = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = null ;
		//从界面得到输入数组
		
		String prpLregistExtRegistNo = (String)httpServletRequest.getParameter("prpLregistExtRegistNo"); 
		String prpLregistExtRiskCode = httpServletRequest.getParameter      ("prpLregistExtRiskCode");
		String[] prpLregistExtSerialNo = httpServletRequest.getParameterValues("prpLregistExtSerialNo");
		String[] prpLregistExtInputDate = httpServletRequest.getParameterValues("prpLregistExtInputDate");
		String[] prpLregistExtInputHour = httpServletRequest.getParameterValues("prpLregistExtInputHour");
		String[] prpLregistExtOperatorCode = httpServletRequest.getParameterValues("prpLregistExtOperatorCode");
		String[] prpLregistExtContext = httpServletRequest.getParameterValues("prpLregistExtContext");
		
		//对象赋值
		//人员伤亡跟踪 部分开始
		if (prpLregistExtSerialNo==null)
		{}
		else
		{
			//////System.out.println("人员伤亡跟踪部分开始 ");
			for(int index=1;index<prpLregistExtSerialNo.length;index++)
			{
				prpLregistExtDto = new PrpLregistExtDto();
				prpLregistExtDto.setRegistNo(prpLregistExtRegistNo);
				prpLregistExtDto.setRiskCode(prpLregistExtRiskCode);
				prpLregistExtDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLregistExtSerialNo[index])));
				prpLregistExtDto.setInputDate(new DateTime(prpLregistExtInputDate[index],DateTime.YEAR_TO_DAY ));
				prpLregistExtDto.setInputHour(prpLregistExtInputHour[index]);
				prpLregistExtDto.setOperatorCode(prpLregistExtOperatorCode[index]);
				prpLregistExtDto.setContext(prpLregistExtContext[index]);
				//加入集合
				prpLregistExtDtoList.add(prpLregistExtDto);
			}
			//报案集合中加入损失部位
			certainLossDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
		}      
		
		return certainLossDto;
	}
	
	/**
	 * 生成定损信息详细画面
	 * @param httpServletRequest 返回给页面的request
	 * @param businessNo     业务号码
	 * @param editType   编辑类型
	 * @throws Exception
	 */
	public void certainLossDtoView(HttpServletRequest httpServletRequest, String registNo,
			String editType) throws Exception {
		String lossItemCode = httpServletRequest.getParameter("lossItemCode");
		String riskCode=httpServletRequest.getParameter("riskCode");
		String nodeStatus = httpServletRequest.getParameter("status");
		UICodeAction uiCodeAction1 = new UICodeAction();
		String claimNo = uiCodeAction1.translateBusinessCode(registNo.trim(), true);
		//非车险，lossItemCode默认为1,这样就可以正常进行财产险详细的删除操作了
		String strRiskType = uiCodeAction1.translateRiskCodetoRiskType(riskCode);
		if (riskCode != null && !"D".equals(strRiskType)) {
			lossItemCode = "1";
		}
		
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		CertainLossDto certainLossDto = uiCertainLossAction.findByPrimaryKey(registNo.trim(),lossItemCode);
		PrpLverifyLossDto prpLverifyLossDto = certainLossDto.getPrpLverifyLossDto();
		
		PrpLthirdPartyDto  prpLthirdParty1Dto =new PrpLthirdPartyDto();
		prpLthirdParty1Dto = certainLossDto.getPrpLthirdPartyDto();
		httpServletRequest.setAttribute("prpLthirdParty1Dto", prpLthirdParty1Dto);
		
		if(prpLverifyLossDto==null){
			String msg="";
			msg ="未发现报案号为："+registNo.trim()+",序号"+lossItemCode+"的定损数据,可能是进行了注销拒赔申请！";
			throw new UserException(1,3,"定损查询",msg);
		}
		
		//设置定损操作的状态为 案件修改 (正处理任务)
		if (certainLossDto.getPrpLclaimStatusDto() != null) {
			if (certainLossDto.getPrpLclaimStatusDto().getStatus().equals("7")){
				certainLossDto.getPrpLclaimStatusDto().setStatus("3");
			}
			prpLverifyLossDto.setStatus(certainLossDto.getPrpLclaimStatusDto().getStatus());
		} else {
			// 已提交，已经处理完毕的状态
			prpLverifyLossDto.setStatus("4");
		}
		if(nodeStatus!=null){
			prpLverifyLossDto.setStatus(nodeStatus);
		}
		
		this.setClaimType(httpServletRequest, registNo, claimNo);
		//属性条款类别
		prpLverifyLossDto.setClauseType("none");
		// 获取理赔车辆信息
		getCarLossInfo(httpServletRequest, registNo, lossItemCode, certainLossDto);
		// 获取报案、查勘信息
		this.getRegistCheckInfo(httpServletRequest, registNo);
		
		// 查询相同保单号的出险次数
		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
		dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLverifyLossDto.getPolicyNo(),prpLverifyLossDto.getRegistNo());
		//设置相关代码的中文转换
		changeCodeToName(httpServletRequest,prpLverifyLossDto);
		changeCodeToName(httpServletRequest,certainLossDto);
		//设置窗体表单中各个多选框中列表信息的内容
		setSelectionList(httpServletRequest,registNo);
		//设置定损信息内容到窗体表单
		
		if (prpLverifyLossDto.getClaimNo()==null||prpLverifyLossDto.getClaimNo().equals("")){
			DAAClaimViewHelper daaClaimViewHelper =new DAAClaimViewHelper ();
			prpLverifyLossDto.setClaimNo(daaClaimViewHelper.getLossClaimNo(registNo));
		}
		httpServletRequest.setAttribute("prpLverifyLossDto", prpLverifyLossDto);
		httpServletRequest.setAttribute("certainLossDto", certainLossDto);
		//Reason:得到修理类型列表
		UICodeAction uiCodeAction = new UICodeAction();
		Collection repairTypes = uiCodeAction.getCodeType("RepairType", riskCode);
		httpServletRequest.setAttribute("repairTypes", repairTypes);
		httpServletRequest.setAttribute("verifyPriceOpinionList", ICollections.getVerifyPriceOpinionList());
		//Reason:增加核损意见       
		httpServletRequest.setAttribute("verifyOpinionList", ICollections.getVerifyOpinionList());
		
		//设置各个子表信息项到窗体表单
		setSubInfo(httpServletRequest,certainLossDto);
		
		//设置工作流下一个节点提交的配置信息
		getSubmitNodes(httpServletRequest);
		
		/**添加强三关联保单信息 */
		RegistDto registDto = new RegistDto();
        BLPrpLRegistRPolicyFacade facade = new BLPrpLRegistRPolicyFacade();
        registDto.setPrpLRegistRPolicyList((List) facade.findByRegistNo(registNo));
        httpServletRequest.setAttribute("prpLregistRPolicyNo",registDto.getPrpLRegistRPolicyDtoOfCompel());
		
		//查询核价权限
		/*UIPrpLclaimGradeAction uiPrpLclaimGradeAction = new UIPrpLclaimGradeAction();
		String taskCode = AppConfig.get("sysconst.TASKCODE_LPDS");  //任务代码为定损
		//工时费合计
		PrpLclaimGradeDto prpLclaimGradeDto1 = uiPrpLclaimGradeAction.findByPrimaryKey(user.getUserCode(),taskCode,"SUM_WORK_HOUR_FEE");
		//换件费合计
		PrpLclaimGradeDto prpLclaimGradeDto2 = uiPrpLclaimGradeAction.findByPrimaryKey(user.getUserCode(),taskCode,"SUM_CHANGE_COMP_FEE");
		httpServletRequest.setAttribute("prpLclaimGradeDto1", prpLclaimGradeDto1);
		httpServletRequest.setAttribute("prpLclaimGradeDto2", prpLclaimGradeDto2);*/
	}
	
	/**
	 * 获取损失车辆信息：车辆定损、核损页面上的理赔车辆信息
	 * @param registNo 报案号
	 * @param lossItemCode 标的序号
	 * @param verifyLossDto 核损对象
	 * @throws Exception
	 */
	private void getLossCarInfo(String registNo, String lossItemCode, VerifyLossDto certainLossDto)
			throws Exception {
		// 获取理赔车辆信息：厂牌型号、车辆种类等
		BLPrpLthirdPartyFacade blPrpLthirdPartyFacade = new BLPrpLthirdPartyFacade();
		List thirdPartyDtoList = (List) blPrpLthirdPartyFacade.findByConditions("registNo = '"
				+ registNo + "' and serialno = '" + lossItemCode + "'");
		PrpLthirdPartyDto prpLthirdParty1Dto = null;
		if(thirdPartyDtoList.size() > 0) {
			prpLthirdParty1Dto = (PrpLthirdPartyDto)thirdPartyDtoList.get(0);
		}
		if (certainLossDto.getPrpLcarLossDtoList() != null) {
			for (int i = 0; i < certainLossDto.getPrpLcarLossDtoList().size(); i++) {
				PrpLcarLossDto prpLcarLossDto = (PrpLcarLossDto) certainLossDto
						.getPrpLcarLossDtoList().get(i);
				prpLcarLossDto.setLicenseColorCode(prpLthirdParty1Dto.getLicenseColorCode());
				prpLcarLossDto.setCarKindCode(prpLthirdParty1Dto.getCarKindCode());
				prpLcarLossDto.setModelCode(prpLthirdParty1Dto.getModelCode());
				prpLcarLossDto.setBrandName(prpLthirdParty1Dto.getBrandName());
				prpLcarLossDto.setEngineNo(prpLthirdParty1Dto.getEngineNo());
				prpLcarLossDto.setFrameNo(prpLthirdParty1Dto.getFrameNo());
				prpLcarLossDto.setVINNo(prpLthirdParty1Dto.getVINNo());
				prpLcarLossDto.setInsureCarFlag(prpLthirdParty1Dto.getInsureCarFlag());
				prpLcarLossDto.setInsureComCode(prpLthirdParty1Dto.getInsureComCode());
				prpLcarLossDto.setInsureComName(prpLthirdParty1Dto.getInsureComName());
			}
		}
	}
	
	/**
	 * 填写定损页面及查询定损request的生成.
	 * @param httpServletRequest 返回给页面的request
	 * @param businessNo 业务号码（报案号）
	 * @param editType 编辑类型
	 * @throws Exception
	 */
	public void registDtoToView(HttpServletRequest httpServletRequest, String businessNo,
			String editType) throws Exception {
		//标的序号，如果是人伤为0，否则为1，2，3，4，5等车辆序号 
		String lossItemCode = DataUtils.nullToZero(httpServletRequest.getParameter("lossItemCode"));
		UICodeAction uiCodeAction = new UICodeAction();
		String strRiskCode=BusinessRuleUtil.getRiskCode(businessNo,"RegistNo");
		String claimNo = uiCodeAction.translateBusinessCode(businessNo, true);
		
		//Reason:得到修理类型列表
		Collection repairTypes = uiCodeAction.getCodeType("RepairType", strRiskCode);
		httpServletRequest.setAttribute("repairTypes", repairTypes);
		
		//为了解决上海互碰案件问题，在定损中增加案件类型的判断（国元版本应该不需要，暂保留原有业务逻辑）
		setClaimType(httpServletRequest, businessNo, claimNo);
		
		//判断原来的定损是否存在
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		CertainLossDto certainLossDto = uiCertainLossAction.findByPrimaryKey(businessNo,lossItemCode);
		PrpLverifyLossDto prpLverifyLossDto = new PrpLverifyLossDto();
		httpServletRequest.setAttribute("prpLthirdParty1Dto", certainLossDto.getPrpLthirdPartyDto());
		// 当前案件存在定损信息（修改/查看定损信息时调用）
		if(certainLossDto.getPrpLverifyLossDto()!=null){
			prpLverifyLossDto = certainLossDto.getPrpLverifyLossDto();
			// 设置定损操作的状态为 案件修改 (正处理任务)
			prpLverifyLossDto.setClaimNo(claimNo);
			if (certainLossDto.getPrpLclaimStatusDto() != null) {
				if (certainLossDto.getPrpLclaimStatusDto().getStatus().equals("7")) {
					certainLossDto.getPrpLclaimStatusDto().setStatus("3");
				}
				prpLverifyLossDto.setStatus(certainLossDto.getPrpLclaimStatusDto().getStatus());
			} else {
				// 已提交，已经处理完毕的状态
				prpLverifyLossDto.setStatus("1");
			}
			String nodeStatus = httpServletRequest.getParameter("status");
			if (nodeStatus != null) {
				prpLverifyLossDto.setStatus(nodeStatus);
			}
			// 设置定损页面上的"理赔车辆"信息
			getCarLossInfo(httpServletRequest, businessNo, lossItemCode, certainLossDto);
		}
		// 新增定损信息：从报案环节带入信息（车辆信息）
		else{
			// 查询保单信息
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(businessNo);
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(prpLregistDto.getPolicyNo(),
					prpLregistDto.getDamageStartDate().toString(), prpLregistDto
							.getDamageStartHour()); 
			// 从报案等环节带入定损初始车辆信息
			certainLossDto = getCertainLossInfo(httpServletRequest,policyDto,businessNo, lossItemCode,
					claimNo, prpLverifyLossDto);
			// 从前面环节带入人伤跟踪信息
			certainLossDto = translateTraceToPerson(httpServletRequest,policyDto ,certainLossDto,businessNo);
		}
		//查询相同保单号的出险次数
		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
		dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLverifyLossDto.getPolicyNo(),prpLverifyLossDto.getRegistNo());
		
		//设置相关代码的中文转换
		changeCodeToName(httpServletRequest,prpLverifyLossDto);
		changeCodeToName(httpServletRequest,certainLossDto);
		
		if (claimNo==null||claimNo.equals("")){
			DAAClaimViewHelper daaClaimViewHelper =new DAAClaimViewHelper ();
			prpLverifyLossDto.setClaimNo(daaClaimViewHelper.getLossClaimNo(businessNo));
		}
		
		// 取得相关主表的信息
		getRegistCheckInfo(httpServletRequest, businessNo);
		
		//设置定损信息内容到窗体表单
		setSelectionList(httpServletRequest,businessNo);
		httpServletRequest.setAttribute("prpLverifyLossDto", prpLverifyLossDto);
		httpServletRequest.setAttribute("certainLossDto", certainLossDto);
		//httpServletRequest.setAttribute("prpLthirdParty1Dto", certainLossDto.getPrpLthirdPartyDto());
		//设置各个子表信息项到窗体表单  
		certainLossDto.setPrpLverifyLossDto(prpLverifyLossDto);
		setSubInfo(httpServletRequest,certainLossDto);
		httpServletRequest.setAttribute("verifyPriceOpinionList", ICollections.getVerifyPriceOpinionList());
		httpServletRequest.setAttribute("verifyOpinionList", ICollections.getVerifyOpinionList()); // 增加核损意见
		
		//设置工作流下一个节点提交的配置信息
		getSubmitNodes(httpServletRequest);
		
		/**添加强三关联保单信息 */
		RegistDto registDto = new RegistDto();
        BLPrpLRegistRPolicyFacade facade = new BLPrpLRegistRPolicyFacade();
        registDto.setPrpLRegistRPolicyList((List) facade.findByRegistNo(businessNo));
        httpServletRequest.setAttribute("prpLregistRPolicyNo",registDto.getPrpLRegistRPolicyDtoOfCompel());
		//Reason:根据员工代码取出相应理赔业务权限
		/*UserDto prpLclaimUser = (UserDto) httpServletRequest.getSession().getAttribute("user");
		String strPrpLclaimGradeUserCode = prpLclaimUser.getUserCode();
		String strPrpLclaimTaskCode = "certa";  //任务代码为定损
		UIPrpLclaimGradeAction uiPrpLclaimGradeAction = new UIPrpLclaimGradeAction();
		PrpLclaimGradeDto prpLclaimGradeDto = uiPrpLclaimGradeAction.findByPrimaryKey(strPrpLclaimGradeUserCode,strPrpLclaimTaskCode,"ALL");
		httpServletRequest.setAttribute("prpLclaimGradeDto", prpLclaimGradeDto);
		//查询核价权限       
		String taskCode = AppConfig.get("sysconst.TASKCODE_LPDS");  //任务代码为定损
		//工时费合计
		PrpLclaimGradeDto prpLclaimGradeDto1 = uiPrpLclaimGradeAction.findByPrimaryKey(strPrpLclaimGradeUserCode,taskCode,"SUM_WORK_HOUR_FEE");
		//换件费合计
		PrpLclaimGradeDto prpLclaimGradeDto2 = uiPrpLclaimGradeAction.findByPrimaryKey(strPrpLclaimGradeUserCode,taskCode,"SUM_CHANGE_COMP_FEE");
		httpServletRequest.setAttribute("prpLclaimGradeDto1", prpLclaimGradeDto1);
		httpServletRequest.setAttribute("prpLclaimGradeDto2", prpLclaimGradeDto2);
		*/
	}

	/**
	 * 从报案等环节带入定损初始车辆信息
	 * @param httpServletRequest
	 * @param registNo 报案号
	 * @param lossItemCode 损失标的序号
	 * @param claimNo 立案号
	 * @param prpLverifyLossDto
	 * @return 定损大对象
	 * @throws SQLException
	 * @throws UserException
	 * @throws Exception
	 */
	private CertainLossDto getCertainLossInfo(HttpServletRequest httpServletRequest, PolicyDto policyDto,
			String registNo, String lossItemCode, String claimNo,
			PrpLverifyLossDto prpLverifyLossDto) throws SQLException, UserException, Exception {
		CertainLossDto certainLossDto;
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo.trim());
		String policyNo = registDto.getPrpLregistDto().getPolicyNo();
		certainLossDto = new CertainLossDto();
		prpLverifyLossDto.setRegistNo(registDto.getPrpLregistDto().getRegistNo());
		prpLverifyLossDto.setClaimNo(claimNo);
		prpLverifyLossDto.setRiskCode(registDto.getPrpLregistDto().getRiskCode());
		prpLverifyLossDto.setPolicyNo(registDto.getPrpLregistDto().getPolicyNo());
		prpLverifyLossDto.setInsuredName(registDto.getPrpLregistDto().getInsuredName());
		prpLverifyLossDto.setLicenseNo(registDto.getPrpLregistDto().getLicenseNo());
		prpLverifyLossDto.setClauseType(registDto.getPrpLregistDto().getClauseType());
		prpLverifyLossDto.setLossItemCode(httpServletRequest.getParameter("lossItemCode"));
		prpLverifyLossDto.setLossItemName(httpServletRequest.getParameter("lossItemName"));
		prpLverifyLossDto.setInsureCarFlag(httpServletRequest.getParameter("insureCarFlag"));
		prpLverifyLossDto.setCurrency("CNY");
		prpLverifyLossDto.setMakeCom(registDto.getPrpLregistDto().getMakeCom());
		prpLverifyLossDto.setComCode(registDto.getPrpLregistDto().getComCode());
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		prpLverifyLossDto.setHandlerCode(user.getUserCode());
		prpLverifyLossDto.setHandlerName(user.getUserName());
		prpLverifyLossDto.setDefLossDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		prpLverifyLossDto.setFlag(registDto.getPrpLregistDto().getFlag());
		if (!registDto.getPrpLregistDto().getPolicyNo().equals("")) {
			PrpCitemCarDto PrpCitemCarDto = new PrpCitemCarDto();
			if(policyDto.getPrpCitemCarDtoList().size()>0){
				//对车型等信息的支持
				PrpCitemCarDto= (PrpCitemCarDto)policyDto.getPrpCitemCarDtoList().get(0);
				prpLverifyLossDto.setLicenseNo(PrpCitemCarDto.getLicenseNo()); 
				prpLverifyLossDto.setLossItemName(PrpCitemCarDto.getLicenseNo()); 
				prpLverifyLossDto.setLicenseColorcode(PrpCitemCarDto.getLicenseColorCode());
				prpLverifyLossDto.setCarKindCode(PrpCitemCarDto.getCarKindCode());
			}
			if(policyDto.getPrpCmainDto() != null){
				prpLverifyLossDto.setCurrency(policyDto.getPrpCmainDto().getCurrency());
			} 
		}
		ArrayList prpLcarLossDtoList1 = new ArrayList();
		
		if(registDto.getPrpLthirdPartyDtoList() != null){ 
			for (int i = 0; i < registDto.getPrpLthirdPartyDtoList().size(); i++) {
				PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)registDto.getPrpLthirdPartyDtoList().get(i);
				//取得定前车辆的信息
				if((String.valueOf(prpLthirdPartyDto.getSerialNo())).equals(lossItemCode.trim())){
					PrpLcarLossDto prpLcarLossDto = new PrpLcarLossDto();
					prpLcarLossDto.setRegistNo(prpLthirdPartyDto.getRegistNo());
					//此处需要一个根据报案号码查询关联的赔案号码的转换，管李香要
					prpLcarLossDto.setClaimNo(claimNo);
					prpLcarLossDto.setRiskCode(prpLthirdPartyDto.getRiskCode());
					prpLcarLossDto.setRegistNo(prpLthirdPartyDto.getRegistNo());
					prpLcarLossDto.setLossItemCode(String.valueOf(i + 1));
					prpLcarLossDto.setLossItemName(prpLthirdPartyDto.getLicenseNo());
					prpLcarLossDto.setPolicyNo(policyNo);
					prpLcarLossDto.setCurrency("CNY");
					prpLcarLossDto.setLossDesc("");
					prpLcarLossDto.setOperatorCode(user.getUserCode());
					prpLcarLossDto.setLicenseColorCode(prpLthirdPartyDto.getLicenseColorCode());
					prpLcarLossDto.setCarKindCode(prpLthirdPartyDto.getCarKindCode());
					prpLcarLossDto.setBrandName(prpLthirdPartyDto.getBrandName());
					prpLcarLossDto.setModelCode(prpLthirdPartyDto.getModelCode());
					prpLcarLossDto.setEngineNo(prpLthirdPartyDto.getEngineNo());
					prpLcarLossDto.setFrameNo(prpLthirdPartyDto.getFrameNo());
					prpLcarLossDto.setVINNo(prpLthirdPartyDto.getVINNo());
					prpLcarLossDto.setInsureCarFlag(prpLthirdPartyDto.getInsureCarFlag());
					prpLcarLossDto.setInsureComCode(prpLthirdPartyDto.getInsureComCode());
					prpLcarLossDto.setInsureComName(prpLthirdPartyDto.getInsureComName());
					prpLcarLossDto.setFlag(prpLthirdPartyDto.getFlag());
					prpLcarLossDtoList1.add(prpLcarLossDto);
				}
			}
		}
		certainLossDto.setPrpLcarLossDtoList(prpLcarLossDtoList1);
		certainLossDto.setPrpLregistExtDtoList(registDto.getPrpLregistExtDtoList());
		// 设置实赔操作的状态为 新案件登记 (未处理任务)
		prpLverifyLossDto.setStatus("1");
		return certainLossDto;
	}

	
	/**
	 * 获取报案号相应的报案及查勘信息
	 * @param httpServletRequest
	 * @param registNo 报案号
	 * @throws Exception
	 */
	private void getRegistCheckInfo(HttpServletRequest httpServletRequest, String registNo)
			throws Exception {
		// 报案信息
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		PrpLregistDto prpLregistDtoTemp = blPrpLregistFacade.findByPrimaryKey(registNo);
		if(prpLregistDtoTemp == null) {
			throw new Exception("没有查询到当前报案号相应的报案信息！");
		}
		String timeTemp = StringConvert.toStandardTime(prpLregistDtoTemp
				.getDamageStartHour());
		prpLregistDtoTemp.setDamageStartMinute(timeTemp.substring(3, 5));
		prpLregistDtoTemp.setDamageStartHour(timeTemp.substring(0, 2));
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDtoTemp);
		
		// 查勘信息
		UIPrpLcheckAction uiPrpLcheckAction = new UIPrpLcheckAction();
		PrpLcheckDto prpLcheckDtoTemp = uiPrpLcheckAction.findByPrimaryKey(registNo);
		if (prpLcheckDtoTemp == null) {
			prpLcheckDtoTemp = new PrpLcheckDto();
		}
		httpServletRequest.setAttribute("prpLcheckDtoTemp", prpLcheckDtoTemp);
	}
	/**
	 * 设置定损页面上的理赔车辆信息
	 * @param httpServletRequest
	 * @param businessNo 报案号
	 * @param lossItemCode 损失标的代码 
	 * @param certainLossDto 定损大对象
	 * @return 
	 * @throws Exception
	 */
	private void getCarLossInfo(HttpServletRequest httpServletRequest, String registNo,
			String lossItemCode, CertainLossDto certainLossDto)
			throws Exception {
		int intLossItemCode = Integer.parseInt(lossItemCode);
		BLPrpLthirdPartyFacade blPrpLthirdPartyFacade = new BLPrpLthirdPartyFacade();
		PrpLthirdPartyDto prpLthirdPartyDto = blPrpLthirdPartyFacade.findByPrimaryKey(registNo,intLossItemCode);
		if (certainLossDto.getPrpLcarLossDtoList() != null
				&& certainLossDto.getPrpLcarLossDtoList().size() > 0) {
			List prpLcarLossDtoList = certainLossDto.getPrpLcarLossDtoList(); // 只有一条记录
			for (int i = 0; i < prpLcarLossDtoList.size(); i++) {
				PrpLcarLossDto prpLcarLossDto = (PrpLcarLossDto) prpLcarLossDtoList.get(i);
				prpLcarLossDto.setLicenseColorCode(prpLthirdPartyDto.getLicenseColorCode());
				prpLcarLossDto.setCarKindCode(prpLthirdPartyDto.getCarKindCode());
				prpLcarLossDto.setBrandName(prpLthirdPartyDto.getBrandName());
				prpLcarLossDto.setModelCode(prpLthirdPartyDto.getModelCode());
				prpLcarLossDto.setEngineNo(prpLthirdPartyDto.getEngineNo());
				prpLcarLossDto.setFrameNo(prpLthirdPartyDto.getFrameNo());
				prpLcarLossDto.setVINNo(prpLthirdPartyDto.getVINNo());
				prpLcarLossDto.setInsureCarFlag(prpLthirdPartyDto.getInsureCarFlag());
				prpLcarLossDto.setInsureComCode(prpLthirdPartyDto.getInsureComCode());
				prpLcarLossDto.setInsureComName(prpLthirdPartyDto.getInsureComName());
			}
		}
	}

	/**
	 * 解决互碰案件问题，在定损中增加案件类型的判断
	 * 
	 * @param httpServletRequest
	 * @param registNo 报案号
	 * @param claimNo 立案号
	 * @throws Exception
	 */
	private void setClaimType(HttpServletRequest httpServletRequest, String registNo, String claimNo)
			throws Exception {
		String claimTypeCode = "";
		String claimTypeName = "";
		//取案件类型：已立案的从立案表取，未立案的若已查勘，从查勘取，未查勘从报案取
		BLPrpLcheckFacade blPrpLcheckFacade = new BLPrpLcheckFacade();
		
		PrpLcheckDto prpLcheckDto = blPrpLcheckFacade.findByPrimaryKey(registNo, 1);
		//1.先从查勘取赔案类别
		claimTypeCode = prpLcheckDto == null?"":prpLcheckDto.getClaimType();
		if(prpLcheckDto != null && "K".equals(prpLcheckDto.getClaimType())){
			claimTypeCode = "K";
		}else{
			//2.查勘不是互碰自赔，再查询立案是否是互碰自赔
			PrpLclaimDto prpLclaimDto = null;
			if(claimNo.length()>0){
				BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
				String conditions = "registno = '"+ registNo +"' and riskCode='0507'";
				ArrayList prpLclaimDtoList = (ArrayList)blPrpLclaimFacade.findByConditions(conditions);
				for(int i=0;i<prpLclaimDtoList.size();i++){
					prpLclaimDto = (PrpLclaimDto)prpLclaimDtoList.get(i);
				}
				if(prpLclaimDto != null){
					claimTypeCode = prpLclaimDto.getClaimType();
				}
			}
			//3.查勘、立案节点都没有做，从报案取赔案类别
			if(prpLcheckDto == null && prpLclaimDto == null){
				BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
				PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
				claimTypeCode = prpLregistDto.getClaimType();
			}
			
		}
		
		claimTypeName = new UICodeAction().translateCodeCode("CaseCode", claimTypeCode, true);
		httpServletRequest.setAttribute("claimTypeName", claimTypeName);
		httpServletRequest.setAttribute("claimTypeCode", claimTypeCode);

	}
	
	/**
	 * 根据赔案号和报案号查询定损信息
	 * @param httpServletRequest 返回给页面的request
	 * @param businessNo      赔案号
	 * @throws Exception
	 */
	public void setPrpLcertainLossDtoToView(HttpServletRequest httpServletRequest,String registNo,String policyNo) throws Exception
	{
		//caseNO,policyNo,claimNo
		//根据输入的保单号，定损号生成SQL where 子句
		registNo = StringUtils.rightTrim(registNo) ;
		policyNo = StringUtils.rightTrim(policyNo) ;
		String conditions = "";
		
		conditions = " registNo = '" + registNo.trim() + "' and policyNo = '" + policyNo.trim() + "'";
		//查询立案信息
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		
		//得到多行定损主表信息
		Collection verifyLossList = new ArrayList();
		verifyLossList  = (Collection)uiCertainLossAction.findByConditions(conditions) ;
		
		PrpLverifyLossDto prpLverifyLossDto = new PrpLverifyLossDto();
		prpLverifyLossDto.setVerifyLossList(verifyLossList);
		
		prpLverifyLossDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLverifyLossDto",prpLverifyLossDto) ;
	}
	
	
	//add by zhaolu 20060803 start
	public void setPrpLcertainLossDtoToView(HttpServletRequest httpServletRequest,WorkFlowQueryDto workFlowQueryDto,int pageNo,int recordPerPage) throws Exception
	{
		
		String claimNo  = StringUtils.rightTrim(workFlowQueryDto.getClaimNo()) ;
		String registNo = StringUtils.rightTrim(workFlowQueryDto.getRegistNo()) ;
		String policyNo = StringUtils.rightTrim(workFlowQueryDto.getPolicyNo()) ;
		String licenseNo = StringUtils.rightTrim(workFlowQueryDto.getLicenseNo());
		String status = StringUtils.rightTrim(workFlowQueryDto.getStatus());
		String operateDate = StringUtils.rightTrim(workFlowQueryDto.getOperateDate());
		String insuredName = StringUtils.rightTrim(workFlowQueryDto.getInsuredName());
		String conditions = " 1=1 ";
		conditions = conditions + StringConvert.convertString("a.registNo",registNo,workFlowQueryDto.getRegistNoSign());
//		conditions = conditions + StringConvert.convertString("a.policyNo",policyNo,workFlowQueryDto.getPolicyNoSign());
		//add by zhouliu start at 2006-6-9
		//reason:强三查询
		conditions = conditions + StringConvert.convertString("d.policyNo",policyNo,workFlowQueryDto.getPolicyNoSign());
		//add by zhouliu end at 2006-6-9		
		conditions = conditions + StringConvert.convertString("a.licenseNo",licenseNo,workFlowQueryDto.getLicenseNoSign());
		conditions = conditions + StringConvert.convertString("c.insuredName",insuredName,workFlowQueryDto.getInsuredNameSign());
		if(status.trim().length()>0){
			//拼案件状态条件
			int newIndex = 0;
			String statusTemp = "";
			while(true){
				if((newIndex = status.trim().indexOf(",")) != -1){
					statusTemp += status.trim().substring(0,newIndex) + "','";
					status =status.trim().substring(newIndex + 1,status.trim().length());					
				}else{
					break;
				}
			}
			status = statusTemp + status;	
			conditions = conditions + " AND b.status in ('" +status+ "')";
		}
		if(operateDate != null && !operateDate.trim().equals("")){
			conditions = conditions+ StringConvert.convertDate("b.operateDate",operateDate,workFlowQueryDto.getOperateDateSign());
		}
		
		//modify by zhaolu 20060816 start
		UIPowerInterface uiPowerInterface = new UIPowerInterface();
		UserDto userDto = (UserDto)httpServletRequest.getSession().getAttribute("user");
		conditions = conditions+uiPowerInterface.addPower(userDto,"a","","ComCode");
		//modify by zhaolu 20060816 end
		//Modify by caopeng add begin 20051215 Reason:使每种定损、核损查询只能查询本种类的数据
		String strNodeType = httpServletRequest.getParameter("nodeType");
		if(strNodeType != null){
			strNodeType = StringUtils.rightTrim(strNodeType);
		}
		String strLossItemCode = "";
		//add by zhaolu 20060809 start
		String strSerialNo = "";
		//add by zhaolu 20060809 start
		//modify by zhaolu 20060809 start
		if("verif".equals(strNodeType) || "certa".equals(strNodeType)){  //车损
			strLossItemCode = " AND (a.lossitemcode >'0' or a.lossitemcode = '-2')";
			strSerialNo = " AND (b.serialNo>0 or b.serialNo = -2)";
		}else if("veriw".equals(strNodeType) || "wound".equals(strNodeType)){  //人伤
			strLossItemCode = " AND a.lossitemcode ='0'";
			strSerialNo = " AND b.serialNo = 0";
		}else if("propv".equals(strNodeType) || "propc".equals(strNodeType)){  //财产
			strLossItemCode = " AND a.lossitemcode ='-1'";
			strSerialNo = " AND b.serialNo = -1";
		}
	  //modify by zhaolu 20060809 end
		
		String condition = httpServletRequest.getParameter("condition");
	       if(condition!=null && condition.trim().length()>0){ 
	          conditions = condition;
		
	       }
		
		conditions = conditions+strLossItemCode+strSerialNo;
	
		UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction();
		//Modify by caopeng add end 20051216 Reason:使每种定损、核损查询只能查询本种类的数据
		//查询立案信息
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		//得到多行定损主表信息
		ArrayList verifyLossList = new ArrayList();
		//System.out.println("start to search,please waiting ...");
		//verifyLossList  = (ArrayList)uiCertainLossAction.findByQueryConditions(conditions) ;
		 PageRecord pageRecord = (PageRecord)uiCertainLossAction.findByCondition(conditions,pageNo,recordPerPage);
		 verifyLossList = (ArrayList)pageRecord.getResult();
		 TurnPageDto turnPageDto = new TurnPageDto();
	       //查询出来的一页的结构集 
	       turnPageDto.setResultList(verifyLossList);
	       //当前页号
	       turnPageDto.setPageNo(pageRecord.getPageNo());
	       //一页的条数
	       turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
	       //查询出来的结果的总数
	       turnPageDto.setTotalCount(pageRecord.getCount());
	       //返回总的页数
	       turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
	       //搜索条件
	       turnPageDto.setCondition(conditions);
		//System.out.println("end search,please waiting for result...");
		//Modify by caopeng add begin 20051215 Reason:使每种核损查询只能查询本种类的数据
		if("propv".equals(strNodeType) || "veriw".equals(strNodeType) || "verif".equals(strNodeType)){
			for(int i = 0;i<verifyLossList.size();i++){  
				PrpLverifyLossDto prpLverifyLossDto = (PrpLverifyLossDto)verifyLossList.get(i);
				ClaimStatusDto claimStatusDto = uiClaimStatusAction.findByPrimaryKey(prpLverifyLossDto.getRegistNo(),strNodeType,Integer.parseInt(prpLverifyLossDto.getLossItemCode()));
				if(claimStatusDto != null){
					PrpLclaimStatusDto prpLclaimStatusDto = claimStatusDto.getPrpLclaimStatusDto();
					if(prpLclaimStatusDto != null){
						prpLverifyLossDto.setStatus(prpLclaimStatusDto.getStatus());
					}else{
						prpLverifyLossDto.setStatus("0");
					}
				}
			}
		}
		
		//Modify by caopeng add end 20051216 Reason:使每种核损查询只能查询本种类的数据
		PrpLverifyLossDto prpLverifyLossDto = new PrpLverifyLossDto();
		prpLverifyLossDto.setVerifyLossList(verifyLossList);
		prpLverifyLossDto.setTurnPageDto(turnPageDto);
		//System.out.println("finish add list");
	    //System.out.println("editType="+httpServletRequest.getParameter("editType"));
		prpLverifyLossDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLverifyLossDto",prpLverifyLossDto) ;
	}
	//add by zhaolu 20060803 end
	
	
	/**
	 * 获取选择框和列表框中的所有内容
	 * @param httpServletRequest 返回给页面的request
	 * @param prpLcaseNoDto    定损的数据类
	 * @throws Exception
	 */
	private void setSelectionList(HttpServletRequest httpServletRequest,String registNo) throws Exception
	{
		
		UICodeAction uiCodeAction = new UICodeAction();
		//得到费用名称的列表
		Collection FeeTypeCodeList = new ArrayList();
		FeeTypeCodeList.add(new LabelValueBean("修理费","01"));
		FeeTypeCodeList.add(new LabelValueBean("材料费","02"));
		httpServletRequest.setAttribute("FeeTypeCodeList",FeeTypeCodeList) ;
		
		
		//得到收入情况的列表
		Collection FixedIncomeFlagList = new ArrayList();
		FixedIncomeFlagList.add(new LabelValueBean("有固定收入","1"));
		FixedIncomeFlagList.add(new LabelValueBean("无固定收入","2"));
		FixedIncomeFlagList.add(new LabelValueBean("无收入","3"));
		FixedIncomeFlagList.add(new LabelValueBean("无劳动能力","4"));
		httpServletRequest.setAttribute("FixedIncomeFlagList",FixedIncomeFlagList) ;
		
		//得到人员类型的列表
		Collection PayPersonTypeList = new ArrayList();
		PayPersonTypeList.add(new LabelValueBean("伤","1"));
		PayPersonTypeList.add(new LabelValueBean("被扶养人","2"));
		PayPersonTypeList.add(new LabelValueBean("护理人","3"));
		PayPersonTypeList.add(new LabelValueBean("残","4"));
		PayPersonTypeList.add(new LabelValueBean("亡","5"));
		PayPersonTypeList.add(new LabelValueBean("参加事故处理人员","6"));
		httpServletRequest.setAttribute("PayPersonTypeList",PayPersonTypeList) ;
		
		//得到号牌号码的列表
		//LicenseNoList.add(new LabelValueBean("修理费","01"));
		//Collection education = uiCodeAction.getCodeType("Education",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
		//httpServletRequest.setAttribute("educations",education) ;
		Collection carKindCodes = uiCodeAction.getCodeType("CarKind",BusinessRuleUtil.getRiskCode(registNo,"RegistNo"));
		httpServletRequest.setAttribute("carKindCodes", carKindCodes);
		
		Collection LicenseNoList = (Collection)uiCodeAction.getLicenseNoList(registNo);
		httpServletRequest.setAttribute("LicenseNoList",LicenseNoList) ;
		
	}
	
	/**
	 * 根据PrpPrepayDto中的已经设置的代码内容，对代码进行名称转换
	 * @param httpServletRequest 返回给页面的request
	 * @param prpLcaseNoDto    定损的数据类
	 * @throws Exception
	 */
	private void changeCodeToName(HttpServletRequest httpServletRequest,
			PrpLverifyLossDto prpLverifyLossDto) throws Exception
			{
		UICodeAction uiCodeAction = new UICodeAction();
		//号牌颜色转换
		String  licenseColorCodeCode = prpLverifyLossDto.getLicenseColorcode();
		String  licenseColor = uiCodeAction.translateCodeCode("LicenseColor",licenseColorCodeCode,true) ;
		prpLverifyLossDto.setLicenseColor(licenseColor);
		//车辆类型转换
		String  carKindCode = prpLverifyLossDto.getCarKindCode();
		String  carKind = uiCodeAction.translateCodeCode("CarKind",carKindCode,true) ;
		prpLverifyLossDto.setCarKind(carKind);
		
		//条款名称的转换
		String  clauseType = prpLverifyLossDto.getClauseType();
		String  clauseName = uiCodeAction.translateCodeCode("ClauseType",clauseType,true) ;
		prpLverifyLossDto.setClauseName(clauseName);
		
			}
	/**
	 * 根据PrpPrepayDto中的已经设置的代码内容，对代码进行名称转换
	 * @param httpServletRequest 返回给页面的request
	 * @param prpLcaseNoDto    定损的数据类
	 * @throws Exception
	 */
	private void changeCodeToName(HttpServletRequest httpServletRequest,
			CertainLossDto certainLossDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		// 存储已经翻译过的险别名称，减少访问数据库的次数
		Map kindNameMap = new HashMap();
		if (certainLossDto.getPrpLpropDtoList() != null) {
			for (int i = 0; i < certainLossDto.getPrpLpropDtoList().size(); i++) {
				PrpLpropDto prpLpropDto = (PrpLpropDto) certainLossDto.getPrpLpropDtoList().get(i);
				prpLpropDto.setFeeTypeName(uiCodeAction.translateCodeCode("PropertyFeeType",
						prpLpropDto.getFeeTypeCode(), true));

				String riskCode = prpLpropDto.getRiskCode();
				String kindCode = prpLpropDto.getKindCode();
				// 取得险别名称
				String kindName = getKindName(kindNameMap, riskCode, kindCode); 
				prpLpropDto.setKindName(kindName);
			}
		}

		if (certainLossDto.getPrpLcarLossDtoList() != null) {
			String carKindName = "";
			for (int i = 0; i < certainLossDto.getPrpLcarLossDtoList().size(); i++) {
				PrpLcarLossDto prpLcarLossDto = (PrpLcarLossDto) certainLossDto
						.getPrpLcarLossDtoList().get(i);
				// 是否为本保单车辆转换
				if (prpLcarLossDto.getInsureCarFlag().trim().equals("1")) {
					prpLcarLossDto.setInsureCarFlagName("是");
				} else {
					prpLcarLossDto.setInsureCarFlagName("否");
				}
				//车辆种类(车辆种类信息不需要每次循环都翻译，一辆车只有一个种类)
				if("".equals(carKindName)) {
					carKindName = uiCodeAction.translateCodeCode("CarKind", prpLcarLossDto
							.getCarKindCode(), true);
				}
				prpLcarLossDto.setCarKindName(carKindName);
			}
		}

		if (certainLossDto.getPrpLrepairFeeDtoList() != null) {
			PrpLrepairFeeDto prpLrepairFeeDto = null;
			// 险别名称转换
			Iterator iterator = certainLossDto.getPrpLrepairFeeDtoList().iterator();
			while (iterator.hasNext()) {
				prpLrepairFeeDto = (PrpLrepairFeeDto) iterator.next();
				prpLrepairFeeDto.setHandlerName(uiCodeAction.translateUserCode(prpLrepairFeeDto
						.getHandlerCode(), true));
				String riskCode = prpLrepairFeeDto.getRiskCode();
				String kindCode = prpLrepairFeeDto.getKindCode();
				// 取得险别名称
				if(riskCode.equals("0507")  ){
					riskCode = "0506";
				}else if(riskCode.equals("0577")){
					riskCode = "0576";
				}else if(riskCode.equals("0587")){
					riskCode = "0586";
				}
				String kindName = getKindName(kindNameMap, riskCode, kindCode);
				prpLrepairFeeDto.setKindName(kindName);
			}
		}

		if (certainLossDto.getPrpLcomponentDtoList() != null) {
			PrpLcomponentDto prpLcomponentDto = null;
			// 险别名称转换
			Iterator iterator1 = certainLossDto.getPrpLcomponentDtoList().iterator();
			while (iterator1.hasNext()) {
				prpLcomponentDto = (PrpLcomponentDto) iterator1.next();
				prpLcomponentDto.setHandlerName(uiCodeAction.translateUserCode(prpLcomponentDto
						.getHandlerCode(), true));
				String riskCode = prpLcomponentDto.getRiskCode();
				String kindCode = prpLcomponentDto.getKindCode();
				// 取得险别名称
				String kindName = getKindName(kindNameMap, riskCode, kindCode);
				prpLcomponentDto.setKindName(kindName);
			}
		}
		if (certainLossDto.getPrpLpersonDtoList() != null) {
			PrpLpersonDto prpLpersonDto = null;
			// 险别名称转换
			Iterator iterator2 = certainLossDto.getPrpLpersonDtoList().iterator();
			while (iterator2.hasNext()) {
				prpLpersonDto = (PrpLpersonDto) iterator2.next();
				String riskCode = prpLpersonDto.getRiskCode();
				String kindCode = prpLpersonDto.getKindCode();
				// 取得险别名称
				String kindName = getKindName(kindNameMap, riskCode, kindCode);
				prpLpersonDto.setKindName(kindName);
				prpLpersonDto.setItemName("test");
				prpLpersonDto.setCurrencyName(uiCodeAction.translateCurrencyCode(prpLpersonDto
						.getCurrency(), true));
				prpLpersonDto.setAreaName(uiCodeAction.translateCodeCode("DamageDistrict",
						prpLpersonDto.getAreaCode(), true));
			}
		}
	}
	
	/**
	 * 获取险别名称
	 * @param kindNameMap 险别名称缓存
	 * @param riskCode 险种代码
	 * @param kindCode 险别代码
	 * @return 险别名称
	 * @throws Exception
	 */
	private String getKindName(Map kindNameMap, String riskCode, String kindCode) throws Exception {
		String kindName = "";
		if ("BZ".equals(kindCode)) {
			if("0506".equals(riskCode))
			{
				riskCode = "0507";
			}else if("0576".equals(riskCode))
			{
				riskCode = "0577";
			}else if("0586".equals(riskCode))
			{
				riskCode = "0587";
			}
		}
		if (kindNameMap.containsKey(kindCode)) {
			kindName = kindNameMap.get(kindCode).toString();
		} else {
			kindName = new UICodeAction().translateKindCode(riskCode, kindCode, true);
			kindNameMap.put(kindCode, kindName);
		}
		return kindName;
	}
	
	/**
	 * 取初始化信息需要的数据的整理.
	 * 填写定损单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参，
	 * 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。
	 * 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public CertainLossDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception
	{
		CertainLossDto certainLossDto = new CertainLossDto();
		return certainLossDto;
	}
	
	/**
	 * 填写定损页面及查询定损request的生成.
	 * @param httpServletRequest 返回给页面的request
	 * @param certainLossDto 取出的初始化信息Dto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest, CertainLossDto certainLossDto) throws Exception
	{
	}
	
	/**
	 * 根据certainLossDto中的各子表内的信息填充界面
	 * @param httpServletRequest 返回给页面的request
	 * @param certainLossDto    定损的数据类
	 * @throws Exception
	 */
	private void setSubInfo(HttpServletRequest httpServletRequest,
			CertainLossDto certainLossDto) throws Exception
			{
		//Modify by chenrenda add begin 20050413
		httpServletRequest.setAttribute("partCodeList", ICollections.getPartCodeList());
		
		//Modify by chenrenda add end 20050413
		
		//给定核损信息补充说明多行列表准备数据
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user"); // 用户信息
		if (user == null) {
			throw new  UserException(-98,-1010,"系统登录超时，请重新登录！");
		}
		Collection arrayListVerifyLossExt = new ArrayList();
		PrpLverifyLossExtDto prpLverifyLossExtDto  = new PrpLverifyLossExtDto();
		PrpLverifyLossExtDto prpLverifyLossExtDtoAdd  = new PrpLverifyLossExtDto();
		prpLverifyLossExtDtoAdd.setTitle("定损完成");
		prpLverifyLossExtDtoAdd.setOperatorCode(user.getUserCode());
		prpLverifyLossExtDtoAdd.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
		prpLverifyLossExtDtoAdd.setRiskCode(certainLossDto.getPrpLverifyLossDto().getRiskCode());
		prpLverifyLossExtDtoAdd.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
		prpLverifyLossExtDtoAdd.setInputHour(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND).getHour()+"时"+new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND).getMinute()+"分");
		prpLverifyLossExtDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
		prpLverifyLossExtDto.setRiskCode(certainLossDto.getPrpLverifyLossDto().getRiskCode());
		arrayListVerifyLossExt = certainLossDto.getPrpLverifyLossExtDtoList();
		if(arrayListVerifyLossExt==null){
			arrayListVerifyLossExt = new ArrayList();
		}
		prpLverifyLossExtDtoAdd.setSerialNo(arrayListVerifyLossExt.size()+1);		
		String status = httpServletRequest.getParameter("status");
		if("0".equals(status)||"3".equals(status)){
			arrayListVerifyLossExt.add(prpLverifyLossExtDtoAdd);
		}
		prpLverifyLossExtDto.setVerifyLossExtList(arrayListVerifyLossExt) ;
		httpServletRequest.setAttribute("prpLverifyLossExtDto", prpLverifyLossExtDto);
		
		//给报案信息补充说明多行列表准备数据
		Collection arrayListRegistExt = new ArrayList();
		PrpLregistExtDto prpLregistExtDto  = new PrpLregistExtDto();
		prpLregistExtDto.setRegistNo(certainLossDto.getPrpLverifyLossDto().getRegistNo());
		prpLregistExtDto.setRiskCode(certainLossDto.getPrpLverifyLossDto().getRiskCode());
		arrayListRegistExt = certainLossDto.getPrpLregistExtDtoList();
		prpLregistExtDto.setRegistExtList(arrayListRegistExt) ; 
		httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);        
		
		//修理费用清单多行列表准备数据
		ArrayList arrayList1 = new ArrayList();
		PrpLrepairFeeDto prpLrepairFeeDto  = new PrpLrepairFeeDto();
		arrayList1 = certainLossDto.getPrpLrepairFeeDtoList();
		//Modify by chenrenda 20050409 begin
		if(arrayList1!= null){
			Iterator prpLrepairFeeDtoList = arrayList1.iterator();
			while(prpLrepairFeeDtoList.hasNext()){
				PrpLrepairFeeDto prpLrepairFeeDto2 = (PrpLrepairFeeDto)prpLrepairFeeDtoList.next();
				prpLrepairFeeDto2.setPrpLrepairFeePartCode(prpLrepairFeeDto2.getPartCode());
			}
		}
		//Modify by chenrenda 20050409 end
		prpLrepairFeeDto.setRepairFeeList(arrayList1);
		httpServletRequest.setAttribute("prpLrepairFeeDto", prpLrepairFeeDto);
		
		//换件项目清单多行列表准备数据
		ArrayList arrayList2 = new ArrayList();
		PrpLcomponentDto prpLcomponentDto  = new PrpLcomponentDto();
		arrayList2 = certainLossDto.getPrpLcomponentDtoList();
		//Modify by chenrenda 20050409 begin
		if(arrayList2!= null){
			Iterator prpLcomponentDtoList = arrayList2.iterator();
			while(prpLcomponentDtoList.hasNext()){
				PrpLcomponentDto prpLcomponentDto2 = (PrpLcomponentDto)prpLcomponentDtoList.next();
				prpLcomponentDto2.setPrpLcomponentPartCode(prpLcomponentDto2.getPartCode());
			}
		}
		//Modify by chenrenda 20050409 end
		
		prpLcomponentDto.setComponentList(arrayList2);
		httpServletRequest.setAttribute("prpLcomponentDto", prpLcomponentDto);
		UICodeAction uiCodeAction = new UICodeAction();
		//人员伤亡明细信息清单多行列表准备数据
		ArrayList arrayList3 = new ArrayList();
		PrpLpersonDto prpLpersonDto  = new PrpLpersonDto();
		arrayList3 = (ArrayList)certainLossDto.getPrpLpersonDtoList();
		String riskCode  =  certainLossDto.getPrpLverifyLossDto().getRiskCode();
		String riskCodeUtiType = "";
        TransCodeCI transCodeCI = new TransCodeCI();
		if(arrayList3!=null&&arrayList3.size()>0){
			for(int i=0;i<arrayList3.size();i++){
				PrpLpersonDto prpLpersonDtoTemp = (PrpLpersonDto)arrayList3.get(i);
				if ( "BZ".equals(prpLpersonDtoTemp.getKindCode())){
					riskCodeUtiType = transCodeCI.getRiskCodeCIType(riskCode);
					prpLpersonDtoTemp.setKindName(uiCodeAction.translateKindCode(BusinessRuleUtil.getOuterCode(httpServletRequest,riskCodeUtiType),prpLpersonDtoTemp.getKindCode(),true));
				}else {
			   	    prpLpersonDtoTemp.setKindName(uiCodeAction.translateKindCode(certainLossDto.getPrpLverifyLossDto().getRiskCode(),prpLpersonDtoTemp.getKindCode(),true));
				}
			}
		}
		
		
		prpLpersonDto.setPersonList(arrayList3);
//		System.out.println("----personsize---setSubInfo方法人伤的数量----"+arrayList3.size());       
		httpServletRequest.setAttribute("prpLpersonDto", prpLpersonDto);
		
		//财产核定损明细清单多行列表准备数据
		Collection arrayList4 = new ArrayList();
		PrpLpropDto prpLpropDto  = new PrpLpropDto();
		arrayList4 = certainLossDto.getPrpLpropDtoList();
		prpLpropDto.setPropList(arrayList4);
		httpServletRequest.setAttribute("prpLpropDto", prpLpropDto);
		
		//伤情信息表 多行列表准备数据
		Collection list5 = new ArrayList();
		PrpLpersonWoundDto prpLpersonWoundDto  = new PrpLpersonWoundDto();
		list5 = certainLossDto.getPrpLpersonWoundDtoList();
		prpLpersonWoundDto.setWoundList(list5);
		httpServletRequest.setAttribute("prpLpersonWoundDto", prpLpersonWoundDto);
		
//		理算退回意见
		Collection compensateBackOptionsList =ICollections.getCompensateBackList();
		httpServletRequest.setAttribute("compensateBackOptionsList",compensateBackOptionsList);
	
			}
	/**
	 * 检查是否已出赔案计算书
	 * 返回值   true 已出        false 未出
	 * @param httpServletRequest 返回给页面的request
	 * @param claimNo 赔案号
	 * @throws Exception
	 */
	public boolean checkCompensate(HttpServletRequest httpServletRequest, String registNo) throws Exception
	{
		//根据报案号码取得对应的赔案号码
		UICodeAction uiCodeAction = new UICodeAction();
		String claimNo = uiCodeAction.translateBusinessCode(registNo,true);
		//取得赔款计算书信息
		UICompensateAction uICompensateAction = new UICompensateAction();
		String conditions =  "claimNo ='"+claimNo.trim()+"'" ;
		ArrayList arraylist = (ArrayList)uICompensateAction.findByConditions(conditions);
		if(arraylist==null || arraylist.size()<1){
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 判断当前业务的当前节点是否已经处理
	 * @param registNo 报案号
	 * @param lossItemCode 标的序号
	 * @param nodeType 节点类别
	 * @return 是否已经处理
	 * @throws Exception
	 */
	public boolean checkVerifyLoss(String registNo, String lossItemCode, String nodeType)
			throws Exception {
		BLPrpLclaimStatusFacade blPrpLclaimStatusFacade = new BLPrpLclaimStatusFacade();
		PrpLclaimStatusDto prpLclaimStatusDto = blPrpLclaimStatusFacade.findByPrimaryKey(registNo,
				nodeType, Integer.parseInt(lossItemCode));
		if (prpLclaimStatusDto != null) {
			return false;
		} else {
			return false;
		}
	}
	
	/**
	 * 根据赔案号,报案号,案件状态，车牌号码，操作时间查询定损信息
	 * @param httpServletRequest 返回给页面的request
	 * @param businessNo      赔案号
	 * @throws Exception
	 * Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件
	 */
	public void setPrpLcertainLossDtoToView(HttpServletRequest httpServletRequest,WorkFlowQueryDto workFlowQueryDto) throws Exception
	{
		
		String claimNo  = StringUtils.rightTrim(workFlowQueryDto.getClaimNo()) ;
		String registNo = StringUtils.rightTrim(workFlowQueryDto.getRegistNo()) ;
		String policyNo = StringUtils.rightTrim(workFlowQueryDto.getPolicyNo()) ;
		String licenseNo = StringUtils.rightTrim(workFlowQueryDto.getLicenseNo());
		String status = StringUtils.rightTrim(workFlowQueryDto.getStatus());
		String operateDate = StringUtils.rightTrim(workFlowQueryDto.getOperateDate());
		String insuredName = StringUtils.rightTrim(workFlowQueryDto.getInsuredName());
		String conditions = " 1=1 ";
		conditions = conditions + StringConvert.convertString("a.registNo",registNo,workFlowQueryDto.getRegistNoSign());
//		conditions = conditions + StringConvert.convertString("a.policyNo",policyNo,workFlowQueryDto.getPolicyNoSign());
		//add by zhouliu start at 2006-6-9
		//reason:强三查询
		conditions = conditions + StringConvert.convertString("d.policyNo",policyNo,workFlowQueryDto.getPolicyNoSign());
		//add by zhouliu end at 2006-6-9
		
		conditions = conditions + StringConvert.convertString("a.lossItemName",licenseNo,workFlowQueryDto.getLicenseNoSign());
		conditions = conditions + StringConvert.convertString("c.insuredName",insuredName,workFlowQueryDto.getInsuredNameSign());
		if(status.trim().length()>0){
			conditions = conditions + " AND b.status in ('" +status+ "')";
		}
		if(operateDate != null && !operateDate.trim().equals("")){
			conditions = conditions+ StringConvert.convertDate("b.operateDate",operateDate,workFlowQueryDto.getOperateDateSign());
		}
		
		//modify by zhaolu 20060816 start
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto)httpServletRequest.getSession().getAttribute("user");
		conditions = conditions+uiPowerInterface.addPower(userDto,"a","","ComCode");
		//modify by zhaolu 20060816 end
		//Modify by caopeng add begin 20051215 Reason:使每种定损、核损查询只能查询本种类的数据
		String strNodeType = httpServletRequest.getParameter("nodeType");
		if(strNodeType != null){
			strNodeType = StringUtils.rightTrim(strNodeType);
		}
		String strLossItemCode = "";
		if("verif".equals(strNodeType) || "certa".equals(strNodeType)){  //车损
			strLossItemCode = " AND a.lossitemcode >0";
		}else if("veriw".equals(strNodeType) || "wound".equals(strNodeType)){  //人伤
			strLossItemCode = " AND a.lossitemcode =0";
		}else if("propv".equals(strNodeType) || "propc".equals(strNodeType)){  //财产
			strLossItemCode = " AND a.lossitemcode =-1";
		}
		conditions = conditions+strLossItemCode;
		UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction();
		//Modify by caopeng add end 20051216 Reason:使每种定损、核损查询只能查询本种类的数据
		//查询立案信息
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		
		//得到多行定损主表信息
		ArrayList verifyLossList = new ArrayList();
		//System.out.println("start to search,please waiting ...");
		System.out.println(conditions);
		verifyLossList  = (ArrayList)uiCertainLossAction.findByQueryConditions(conditions) ;
		//System.out.println("end search,please waiting for result...");
		//Modify by caopeng add begin 20051215 Reason:使每种核损查询只能查询本种类的数据
		if("propv".equals(strNodeType) || "veriw".equals(strNodeType) || "verif".equals(strNodeType)){
			for(int i = 0;i<verifyLossList.size();i++){  
				PrpLverifyLossDto prpLverifyLossDto = (PrpLverifyLossDto)verifyLossList.get(i);
				ClaimStatusDto claimStatusDto = uiClaimStatusAction.findByPrimaryKey(prpLverifyLossDto.getRegistNo(),"verif",Integer.parseInt(prpLverifyLossDto.getLossItemCode()));
				if(claimStatusDto != null){
					PrpLclaimStatusDto prpLclaimStatusDto = claimStatusDto.getPrpLclaimStatusDto();
					if(prpLclaimStatusDto != null){
						prpLverifyLossDto.setStatus(prpLclaimStatusDto.getStatus());
					}else{
						prpLverifyLossDto.setStatus("0");
					}
				}
			}
		}
		//Modify by caopeng add end 20051216 Reason:使每种核损查询只能查询本种类的数据
		PrpLverifyLossDto prpLverifyLossDto = new PrpLverifyLossDto();
		prpLverifyLossDto.setVerifyLossList(verifyLossList);
		
		//System.out.println("finish add list");
		
		//System.out.println("editType="+httpServletRequest.getParameter("editType"));
		prpLverifyLossDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLverifyLossDto",prpLverifyLossDto) ;
	}
	
	/**
	 * 查询工作流可以用来选择的节点内容
	 * @param modelNo String
	 * @param nodeNo String
	 * @throws Exception
	 */
	private void getSubmitNodes(HttpServletRequest httpServletRequest) throws Exception
	{
		String modelNo= httpServletRequest.getParameter("modelNo"); //模板号
		String nodeNo= httpServletRequest.getParameter("nodeNo");   //节点号
		int nextNodeNo=0;
		Collection pathList = new ArrayList();
		SwfPathDto swfPathDto  = new SwfPathDto() ;
		WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
		//System.out.println("$$$$$$$$$$$$$$$$44"+modelNo+"++"+nodeNo);
		if (modelNo!=null&& nodeNo!=null)
		{
			pathList = workFlowViewHelper.getNextSumbitNodes(modelNo,nodeNo);
			if (pathList.iterator() .hasNext() )
			{
				SwfPathDto swfPathDtoTemp = new SwfPathDto();
				swfPathDtoTemp=(SwfPathDto)pathList.iterator().next();
				nextNodeNo = swfPathDtoTemp.getEndNodeNo();
				swfPathDto.setNextNodeNo(nextNodeNo);
			}
		}
		swfPathDto.setPathList(pathList);
		httpServletRequest.setAttribute("pathList",pathList);
		httpServletRequest.setAttribute("swfPathDto",swfPathDto);
	}
	
	/**
	 * 获取人伤跟踪信息
	 * @param policyDto 出险时保单信息
	 * @param certainLossDto 定损大对象
	 * @param registNo        报案号
	 * @throws Exception
	 */
	private CertainLossDto translateTraceToPerson(HttpServletRequest httpServletRequest,
			PolicyDto policyDto, CertainLossDto certainLossDto, String registNo) throws Exception {
		String status = httpServletRequest.getParameter("status");
		UIPrpLpersonTraceAction uiPrpLpersonTraceAction = new UIPrpLpersonTraceAction();
		String conditions = " registno = '" + registNo + "'";
		ArrayList prpLpersonDtolist = new ArrayList();
		ArrayList prpLpersonTraceDtolist = new ArrayList();

		if (certainLossDto.getPrpLpersonDtoList() != null) {
			prpLpersonDtolist = certainLossDto.getPrpLpersonDtoList();
		}
		if ("0".equals(status)) {
			prpLpersonTraceDtolist = (ArrayList) uiPrpLpersonTraceAction
					.findByConditions(conditions);
			Iterator ite = prpLpersonTraceDtolist.iterator();
			while (ite.hasNext()) {
				PrpLpersonTraceDto prpLpersonTraceDto = new PrpLpersonTraceDto();
				prpLpersonTraceDto = (PrpLpersonTraceDto) ite.next();
				PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
				prpLpersonDto.setRegistNo(prpLpersonTraceDto.getRegistNo());
				prpLpersonDto.setClaimNo(prpLpersonTraceDto.getClaimNo());
				prpLpersonDto.setPolicyNo(prpLpersonTraceDto.getPolicyNo());
				prpLpersonDto.setKindCode(prpLpersonTraceDto.getReferKind());
				prpLpersonDto.setPersonAge(prpLpersonTraceDto.getPersonAge());
				prpLpersonDto.setPersonName(prpLpersonTraceDto.getPersonName());
				prpLpersonDto.setPersonSex(prpLpersonTraceDto.getPersonSex());
				prpLpersonDto.setPersonNo(prpLpersonTraceDto.getPersonNo());
				prpLpersonDto.setSerialNo(prpLpersonTraceDto.getPersonNo());
				prpLpersonDto.setJobCode(prpLpersonTraceDto.getJobCode());
				prpLpersonDto.setJobName(prpLpersonTraceDto.getJobName());
				UIRegistAction uiRegistAction = new UIRegistAction();
				RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo.trim());
				if (!registDto.getPrpLregistDto().getPolicyNo().equals("")) {
					for (int k = 0; k < policyDto.getPrpCitemKindDtoList().size(); k++) {
						PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) policyDto
								.getPrpCitemKindDtoList().get(k);
						if (prpCitemKindDto.getKindCode() == prpLpersonTraceDto.getReferKind())
							prpLpersonDto.setItemKindNo(prpCitemKindDto.getItemKindNo());
						break;
					}
				}
				prpLpersonDtolist.add(prpLpersonDto);
			}
		}
		if (prpLpersonDtolist != null) {
			certainLossDto.setPrpLpersonDtoList(prpLpersonDtolist);
		}
		return certainLossDto;
	}
	
	/**
	 * 农险增加与赔付数量对应的单位信息
	 * @param httpServletRequest
	 * @param riskCode 险种代码
	 * @throws Exception
	 */
	public void setUnitCollection(HttpServletRequest httpServletRequest, String riskCode,int index)
			throws Exception {
		String conditions = " codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"
				+ riskCode + "' and codetype='Unit')";
		Collection collection = new UICodeAction().findByConditions(conditions);
		httpServletRequest.setAttribute("lossesUnitCodeCollection_"+index, collection);
	}
}
