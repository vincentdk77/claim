package com.sinosoft.claimciplatform.bl.action.custom;

import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacadeBase;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claimciplatform.bl.facade.BLCIClaimDemandFacade;
import com.sinosoft.claimciplatform.dto.custom.PlatFormParam;
import com.sinosoft.claimciplatform.dto.domain.CIClaimDemandDto;
import com.sinosoft.prpall.blsvr.cb.BLPrpCitemCar;
import com.sinosoft.prpall.schema.PrpCitemCarSchema;

/**
 * 上传平台时相关校验的方法类
 * @author sinosoft
 * 
 */
public class BLCIClaimPlatFormCheckAction {
	
	/**
	 * 报案上传平台时校验
	 * @param policyNo 报案号
	 * @param registNo 保单号
	 * @return true－满足上传条件，false－不满足
	 * @throws Exception
	 */
	public static boolean checkUploadForRegist(String policyNo,String registNo)throws Exception{
		if(policyNo == null || "".equals(policyNo)){
			return false;
		}
		BLCIClaimPlatFormInterfaceAction blCIClaimPlatFormInterfaceAction = BLCIClaimPlatFormInterfaceAction.getInstance();
		PlatFormParam platFormParam = blCIClaimPlatFormInterfaceAction.getPlatFormParam(policyNo);
		String strConfigRiskCode = platFormParam.getRiskcode();
		
		boolean isUpload = false;
		if("Y".equals(platFormParam.getUseFlag())){
			BLPrpLRegistRPolicyFacadeBase blPrpLRegistRPolicyFacadeBase = new BLPrpLRegistRPolicyFacadeBase();
			String strWhere = " registNo ='" + registNo + "'";
			Collection collection = blPrpLRegistRPolicyFacadeBase.findByConditions(strWhere);
			for(Iterator iter = collection.iterator();iter.hasNext();){
				PrpLRegistRPolicyDto prpLregistRPolicyDto = (PrpLRegistRPolicyDto)iter.next();
				if(strConfigRiskCode.indexOf(prpLregistRPolicyDto.getRiskCode()) >= 0){
					isUpload = true;
				}
			}
		}
		if(isUpload){
			isUpload = checkCarKind(policyNo);
		}
		return isUpload;
	}
	/**
	 * 立案上传平台时校验
	 * @param policyNo 报案号
	 * @param registNo 保单号
	 * @return true－满足上传条件，false－不满足
	 * @throws Exception
	 */
	public static boolean checkUploadForClaim(String claimNo)throws Exception{
		BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
		PrpLclaimDto claimDto = blPrpLclaimFacade.findByPrimaryKey(claimNo);
		BLCIClaimPlatFormInterfaceAction blCIClaimPlatFormInterfaceAction = BLCIClaimPlatFormInterfaceAction.getInstance();
		PlatFormParam platFormParam = blCIClaimPlatFormInterfaceAction.getPlatFormParam(claimDto.getPolicyNo());
		String strConfigRiskCode = platFormParam.getRiskcode();
		
		boolean isUpload = false;
		if("Y".equals(platFormParam.getUseFlag())){
			if(strConfigRiskCode.indexOf(claimDto.getRiskCode()) >= 0){
				isUpload = true;
			}
			//立案案上传控制：报案信息必须已经上传平台
			if(isUpload){
				isUpload = false;
				BLCIClaimDemandFacade blCIClaimDemandFacade = new BLCIClaimDemandFacade();
				String strWhere = " registno='" + claimDto.getRegistNo() + "'";
				Collection collection = blCIClaimDemandFacade.findByConditions(strWhere);
				if(collection.size() > 0){
					CIClaimDemandDto ciClaimDemandDto = (CIClaimDemandDto)collection.iterator().next();
					if("1".equals(ciClaimDemandDto.getRegistUploadFlag())){
						isUpload = true;
					} 
				}
			}
		}
		if(isUpload){
			isUpload = checkCarKind(claimDto.getPolicyNo());
		}
		return isUpload;
	}
	/**
	 * 实付登记上传平台时校验
	 * @param claim 立案号
	 * @return true－满足上传条件，false－不满足
	 * @throws Exception
	 */
	public static boolean checkUploadForPayref(String claimNo)throws Exception{
		BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
		PrpLclaimDto claimDto = blPrpLclaimFacade.findByPrimaryKey(claimNo);
		BLCIClaimPlatFormInterfaceAction blCIClaimPlatFormInterfaceAction = BLCIClaimPlatFormInterfaceAction.getInstance();
		PlatFormParam platFormParam = blCIClaimPlatFormInterfaceAction.getPlatFormParam(claimDto.getPolicyNo());
		String strConfigRiskCode = platFormParam.getRiskcode();
		
		boolean isUpload = false;
		if("Y".equals(platFormParam.getUseFlag())){
			if(strConfigRiskCode.indexOf(claimDto.getRiskCode()) >= 0){
				isUpload = true;
			}
			//实付登记上传控制：立案信息必须已经上传平台
			if(isUpload){
				isUpload = false;
				BLCIClaimDemandFacade blCIClaimDemandFacade = new BLCIClaimDemandFacade();
				String strWhere = " claimno='" + claimDto.getClaimNo() + "'";
				Collection collection = blCIClaimDemandFacade.findByConditions(strWhere);
				if(collection.size() > 0){
					CIClaimDemandDto ciClaimDemandDto = (CIClaimDemandDto)collection.iterator().next();
					if("1".equals(ciClaimDemandDto.getClaimUploadFlag())){
						isUpload = true;
					} 
				}
			}
		}
		if(isUpload){
			isUpload = checkCarKind(claimDto.getPolicyNo());
		}
		return isUpload;
	}
	/**
	 * 结案案上传平台时校验
	 * @param policyNo 报案号
	 * @param registNo 保单号
	 * @return true－满足上传条件，false－不满足
	 * @throws Exception
	 */
	public static boolean checkUploadForEndCase(String claimNo)throws Exception{
		boolean isUpload = false;
		
		BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
		PrpLclaimDto claimDto = blPrpLclaimFacade.findByPrimaryKey(claimNo);
		
		BLCIClaimPlatFormInterfaceAction blCIClaimPlatFormInterfaceAction = BLCIClaimPlatFormInterfaceAction
				.getInstance();
		PlatFormParam platFormParam = blCIClaimPlatFormInterfaceAction
				.getPlatFormParam(claimDto.getPolicyNo());
		String strConfigRiskCode = platFormParam.getRiskcode();

		
		if ("Y".equals(platFormParam.getUseFlag())) {
			if (strConfigRiskCode.indexOf(claimDto.getRiskCode()) >= 0) {
				isUpload = true;
			}
			//结案上传控制：立案案信息必须已经上传平台
			if(isUpload){
				isUpload = false;
				BLCIClaimDemandFacade blCIClaimDemandFacade = new BLCIClaimDemandFacade();
				//商业险现在也要上传平台,交强险立案是否上传平台的查询条件需加险种
				String strWhere = " registno='" + claimDto.getRegistNo() + "' and riskcode = '0507' ";
				Collection collection = blCIClaimDemandFacade.findByConditions(strWhere);
				if(collection.size() > 0){
					CIClaimDemandDto ciClaimDemandDto = (CIClaimDemandDto)collection.iterator().next();
					if("1".equals(ciClaimDemandDto.getClaimUploadFlag())){
						isUpload = true;
					} 
				}
			}
		}
		if(isUpload){
			isUpload = checkCarKind(claimDto.getPolicyNo());
		}
		return isUpload;
	}
	/**
	 * 结案案上传平台时校验
	 * @param policyNo 报案号
	 * @param registNo 保单号
	 * @return true－满足上传条件，false－不满足
	 * @throws Exception
	 */
	public static boolean checkUploadForReCase(String claimNo)throws Exception{
		boolean isUpload = false;
		
		BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
		PrpLclaimDto claimDto = blPrpLclaimFacade.findByPrimaryKey(claimNo);
		
		BLCIClaimPlatFormInterfaceAction blCIClaimPlatFormInterfaceAction = BLCIClaimPlatFormInterfaceAction
				.getInstance();
		PlatFormParam platFormParam = blCIClaimPlatFormInterfaceAction
				.getPlatFormParam(claimDto.getPolicyNo());
		String strConfigRiskCode = platFormParam.getRiskcode();

		
		if ("Y".equals(platFormParam.getUseFlag())) {
			if (strConfigRiskCode.indexOf(claimDto.getRiskCode()) >= 0) {
				isUpload = true;
			}
			//结案上传控制：立案案信息必须已经上传平台
			if(isUpload){
				isUpload = false;
				BLCIClaimDemandFacade blCIClaimDemandFacade = new BLCIClaimDemandFacade();
				//商业险现在也要上传平台,交强险立案是否上传平台的查询条件需加险种
				String strWhere = " claimno='" + claimDto.getClaimNo() + "'";
				Collection collection = blCIClaimDemandFacade.findByConditions(strWhere);
				if(collection.size() > 0){
					CIClaimDemandDto ciClaimDemandDto = (CIClaimDemandDto)collection.iterator().next();
					if("1".equals(ciClaimDemandDto.getClaimUploadFlag())){
						isUpload = true;
					} 
				}
			}
		}
		if(isUpload){
			isUpload = checkCarKind(claimDto.getPolicyNo());
		}
		return isUpload;
	}
	/**
	 * 报案注销上传平台时校验
	 * @param policyNo 报案号
	 * @param registNo 保单号
	 * @return true－满足上传条件，false－不满足
	 * @throws Exception
	 */
	public static boolean checkUploadForRegistCancel(String policyNo,String registNo)throws Exception{
		
		if(policyNo.length() == 0){
			return false;
		}
		
		BLCIClaimPlatFormInterfaceAction blCIClaimPlatFormInterfaceAction = BLCIClaimPlatFormInterfaceAction.getInstance();
		PlatFormParam platFormParam = blCIClaimPlatFormInterfaceAction.getPlatFormParam(policyNo);
		String strConfigRiskCode = platFormParam.getRiskcode();
		
		boolean isUpload = false;
		if("Y".equals(platFormParam.getUseFlag())){
			BLPrpLRegistRPolicyFacadeBase blPrpLRegistRPolicyFacadeBase = new BLPrpLRegistRPolicyFacadeBase();
			String strWhere = " registNo ='" + registNo 
							+ "' and validstatus = '0' and claimNo is null"
							+ " and policyNo in (" + policyNo + ")";
			Collection collection = blPrpLRegistRPolicyFacadeBase.findByConditions(strWhere);
			for(Iterator iter = collection.iterator();iter.hasNext();){
				PrpLRegistRPolicyDto prpLregistRPolicyDto = (PrpLRegistRPolicyDto)iter.next();
				if(strConfigRiskCode.indexOf(prpLregistRPolicyDto.getRiskCode()) >= 0){
					isUpload = true;
				}
			}
			//报案撤消上传控制：报案信息必须已经上传平台
			if(isUpload){
				isUpload = false;
				BLCIClaimDemandFacade blCIClaimDemandFacade = new BLCIClaimDemandFacade();
				strWhere = " registno='" + registNo + "' and riskcode = '0507' ";
				collection = blCIClaimDemandFacade.findByConditions(strWhere);
				if(collection.size() > 0){
					CIClaimDemandDto ciClaimDemandDto = (CIClaimDemandDto)collection.iterator().next();
					if("1".equals(ciClaimDemandDto.getRegistUploadFlag()) && !"1".equals(ciClaimDemandDto.getCancelUploadFlag())){
						isUpload = true;
					} 
				}
			}
		}
		
		if(isUpload){
			isUpload = checkCarKind(policyNo);
		}
		return isUpload;
	}
	
	/**
	 * 立案注销上传平台时校验
	 * @param policyNo 报案号
	 * @param registNo 保单号
	 * @return true－满足上传条件，false－不满足
	 * @throws Exception
	 */
	public static boolean checkUploadForClaimCancel(String policyNo,String registNo)throws Exception{
		BLCIClaimPlatFormInterfaceAction blCIClaimPlatFormInterfaceAction = BLCIClaimPlatFormInterfaceAction.getInstance();
		PlatFormParam platFormParam = blCIClaimPlatFormInterfaceAction.getPlatFormParam(policyNo);
		String strConfigRiskCode = platFormParam.getRiskcode();
		
		boolean isUpload = false;
		if("Y".equals(platFormParam.getUseFlag())){
			BLPrpLRegistRPolicyFacadeBase blPrpLRegistRPolicyFacadeBase = new BLPrpLRegistRPolicyFacadeBase();
			String strWhere = " registNo ='" + registNo 
							+ "' and validstatus = '0' and claimNo is not null"
							+ " and policyNo in ('" + policyNo + "')";
			Collection collection = blPrpLRegistRPolicyFacadeBase.findByConditions(strWhere);
			for(Iterator iter = collection.iterator();iter.hasNext();){
				PrpLRegistRPolicyDto prpLregistRPolicyDto = (PrpLRegistRPolicyDto)iter.next();
				if(strConfigRiskCode.indexOf(prpLregistRPolicyDto.getRiskCode()) >= 0){
					isUpload = true;
				}
			}
			//立案注销上传控制：立案信息必须已经上传平台
			if(isUpload){
				isUpload = false;
				BLCIClaimDemandFacade blCIClaimDemandFacade = new BLCIClaimDemandFacade();
				strWhere = " registno='" + registNo + "'";
				collection = blCIClaimDemandFacade.findByConditions(strWhere);
				if(collection.size() > 0){
					CIClaimDemandDto ciClaimDemandDto = (CIClaimDemandDto)collection.iterator().next();
					if("1".equals(ciClaimDemandDto.getClaimUploadFlag())){
						isUpload = true;
					} 
				}
			}
		}
		
		if(isUpload){
			isUpload = checkCarKind(policyNo);
		}
		return isUpload;
	}
	/**
	 * 校验车辆种类是否需要上传(排除摩托车、拖拉机)
	 * @param policyNo
	 * @return
	 * @throws Exception
	 */
	private static boolean checkCarKind(String policyNo) throws Exception{
		boolean isUpload = false;
		BLPrpCitemCar blprpcitemcar = new BLPrpCitemCar();
		blprpcitemcar.getData(policyNo);
		if(blprpcitemcar.getSize() > 0){
			PrpCitemCarSchema prpCitemCarSchema = blprpcitemcar.getArr(0);
			if(prpCitemCarSchema.getCarKindCode().indexOf("M") != 0 &&
			   prpCitemCarSchema.getCarKindCode().indexOf("J") != 0){
				isUpload = true;
			}
		}
		return isUpload;
	}
	
	public static void main(String[] ags){
		
	}
}
