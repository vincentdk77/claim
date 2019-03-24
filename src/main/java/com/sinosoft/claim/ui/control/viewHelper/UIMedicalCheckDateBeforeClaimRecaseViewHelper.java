package com.sinosoft.claim.ui.control.viewHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import com.sinosoft.claim.bl.facade.BLPrpLinterRecaseRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterAutoClaimDetailFacade;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.webservice.AccidentPersonInfoDto;
import com.sinosoft.claim.webservice.CertifyInfoDto;
import com.sinosoft.claim.webservice.ClaimAppDto;
import com.sinosoft.claim.webservice.ClaimRequestInfo;
import com.sinosoft.claim.webservice.CompeFeeInfoDto;
import com.sinosoft.claim.webservice.CompeInvDetailInfo;
import com.sinosoft.claim.webservice.CompeInvMainInfo;
import com.sinosoft.claim.webservice.CompePayFeeInfoDto;
import com.sinosoft.claim.webservice.InjuryPersonInfoDto;
import com.sinosoft.claim.webservice.ReCaseRequestInfo;
import com.sinosoft.claim.webservice.SchedExtInfoDto;
import com.sinosoft.prpall.pubfun.PubTools;
import com.sinosoft.sysframework.common.datatype.DateTime;
/**
 * 大病接口重开赔案传入参数的合法性校验类
 * 
 */
public class UIMedicalCheckDateBeforeClaimRecaseViewHelper {
	/**
	 * 接口传入参数的合法性校验
	 * @param reCaseRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkBeforeClaim(ReCaseRequestInfo reCaseRequestInfo) throws Exception{
		String returnStr = "";
		/**
		 * 第一步：校验非空
		 * 第二部：校验合法性
		 * 第三部：outID校验
		 * 第三部：金额校验
		 */
		returnStr=checkNotNullFiels(reCaseRequestInfo);//非空校验
		if("".equals(returnStr)||returnStr.length()<1){
			returnStr = checkFlagFieldsRange(reCaseRequestInfo);//合法校验
		}
		if("".equals(returnStr)||returnStr.length()<1){
			returnStr = checkExistenceOfOutId(reCaseRequestInfo);//outID校验
		}
		if("".equals(returnStr)||returnStr.length()<1){
			returnStr = checkLegalityOfFees(reCaseRequestInfo);//金额校验
		}
		if("".equals(returnStr)||returnStr.length()<1){
			returnStr = checkClaimInputdate(reCaseRequestInfo);//核赔时间校验
		}
		return returnStr;
	}
	
	/**
	 * 非空字段的非空性校验，若有不满足条件的字段属性，返回提示：0^某属性不能为空
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkNotNullFiels(ReCaseRequestInfo reCaseRequestInfo) throws Exception{
		String returnStr = "";
		if(null == reCaseRequestInfo){
			returnStr = "0^入参对象不能为空";
			return returnStr;
		}
		if(reCaseRequestInfo.getOutId()==null||"".equals(reCaseRequestInfo.getOutId())){
			returnStr = "0^客户端数据主键不能为空";
			return returnStr;
		}
		if(reCaseRequestInfo.getRelationOutId()==null||"".equals(reCaseRequestInfo.getRelationOutId())){
			returnStr = "0^客户端数据关联主键不能为空";
			return returnStr;
		}
		if(reCaseRequestInfo.getReClaimNotion()==null||"".equals(reCaseRequestInfo.getReClaimNotion())){
			returnStr = "0^重开审批片语不能为空";
			return returnStr;
		}
		if(reCaseRequestInfo.getReClaimHandleText()==null||"".equals(reCaseRequestInfo.getReClaimHandleText())){
			returnStr = "0^重开赔案审核审批意见不能为空";
			return returnStr;
		}
		if(reCaseRequestInfo.getOperatorCode() == null || "".equals(reCaseRequestInfo.getOperatorCode())){
			returnStr = "0^操作人代码不能为空";
			return returnStr;
		}
		if(reCaseRequestInfo.getOperatorName() == null || "".equals(reCaseRequestInfo.getOperatorName())){
			returnStr = "0^操作人名称不能为空";
			return returnStr;
		}
		if(reCaseRequestInfo.getMakeCom() == null || "".equals(reCaseRequestInfo.getMakeCom())){
			returnStr = "0^理赔处理机构不能为空";
			return returnStr;
		}
		if(reCaseRequestInfo.getMakeComName() == null || "".equals(reCaseRequestInfo.getMakeComName())){
			returnStr = "0^理赔处理机构名称不能为空";
			return returnStr;
		}
		if(reCaseRequestInfo.getApplyRecaseTime() == null || "".equals(reCaseRequestInfo.getApplyRecaseTime())){
			returnStr = "0^重开赔案申请时间不能为空";
			return returnStr;
		}
		if(reCaseRequestInfo.getApplyRecaseUser() == null || "".equals(reCaseRequestInfo.getApplyRecaseUser())){
			returnStr = "0^重开赔案申请人员代码不能为空";
			return returnStr;
		}
		if(reCaseRequestInfo.getAuditRecaseTime() == null || "".equals(reCaseRequestInfo.getAuditRecaseTime())){
			returnStr = "0^审核重开赔案时间不能为空";
			return returnStr;
		}
		if(reCaseRequestInfo.getAuditUser() == null || "".equals(reCaseRequestInfo.getAuditUser())){
			returnStr = "0^审核人员代码不能为空";
			return returnStr;
		}
		if(reCaseRequestInfo.getVericTime() == null || "".equals(reCaseRequestInfo.getVericTime())){
			returnStr = "0^核赔通过时间不能为空";
			return returnStr;
		}
		if(reCaseRequestInfo.getVericUser() == null || "".equals(reCaseRequestInfo.getVericUser())){
			returnStr = "0^核赔人员代码不能为空";
			return returnStr;
		}
		if(reCaseRequestInfo.getClaimAppDto() == null || reCaseRequestInfo.getClaimAppDto().length == 0){
			returnStr = "0^索赔申请人信息不能为空";
			return returnStr;
		}else{
			ClaimAppDto[] claimAppDtos = reCaseRequestInfo.getClaimAppDto();
			ClaimAppDto claimApp = null;
			for(int i=0;i<claimAppDtos.length;i++){
				if(claimAppDtos[i] != null){
					claimApp = claimAppDtos[i];
					if(claimApp.getAcciName()==null || "".equals(claimApp.getAcciName())){
						returnStr = "0^索赔申请人信息中的姓名不能为空";
						return returnStr;
					}
					if(claimApp.getIdentifyNumber()==null || "".equals(claimApp.getIdentifyNumber())){
						returnStr = "0^索赔申请人信息中的身份证号码不能为空";
						return returnStr;
					}
					if(claimApp.getRelationCode()==null || "".equals(claimApp.getRelationCode())){
						returnStr = "0^索赔申请人信息中的与事故者关系不能为空";
						return returnStr;
					}else{
						String relationCode = "1,2,3";
						if(!relationCode.contains(claimApp.getRelationCode())){
							returnStr = "0^索赔申请人信息中的与事故者关系不合法";
							return returnStr;
						}
					}
				}else{
					returnStr = "0^索赔申请人信息不能为空";
					return returnStr;
				}
			}
		}
		
		if(reCaseRequestInfo.getCompeFeeInfoDto() == null || reCaseRequestInfo.getCompeFeeInfoDto().length == 0){
			returnStr = "0^计算书费用信息不能为空";
			return returnStr;
		}else{
			CompeFeeInfoDto[] compeFeeDtos = reCaseRequestInfo.getCompeFeeInfoDto();
			CompeFeeInfoDto compeFee = null;
			for(int i=0;i<compeFeeDtos.length;i++){
				if(compeFeeDtos[i] != null){
					compeFee = compeFeeDtos[i];
					if(compeFee.getKindCode()==null || "".equals(compeFee.getKindCode())){
						returnStr = "0^计算书费用信息中的险别代码不能为空";
						return returnStr;
					}
					if(compeFee.getKindName()==null || "".equals(compeFee.getKindName())){
						returnStr = "0^计算书费用信息中的险别名称不能为空";
						return returnStr;
					}
					if(compeFee.getCurrency()==null || "".equals(compeFee.getCurrency())){
						returnStr = "0^计算书费用信息中的币别代码不能为空";
						return returnStr;
					}
				}else{
					returnStr = "0^计算书费用信息不能为空";
					return returnStr;
				}
			}
		}
		if(reCaseRequestInfo.getNotion() == null || "".equals(reCaseRequestInfo.getNotion())){
			returnStr = "0^核赔审批片语不能为空";
			return returnStr;
		}
		if(reCaseRequestInfo.getHandleText() == null || "".equals(reCaseRequestInfo.getHandleText())){
			returnStr = "0^核赔签署审批意见不能为空";
			return returnStr;
		}
		
		SchedExtInfoDto[] schedExtDtos = reCaseRequestInfo.getSchedExtInfoDto();
		if(schedExtDtos != null && schedExtDtos.length>0){
			SchedExtInfoDto schedExt = null;
			for(int i=0;i<schedExtDtos.length;i++){
				if(schedExtDtos[i] != null){
					schedExt = schedExtDtos[i];
					if(schedExt.getOperatorCode()==null || "".equals(schedExt.getOperatorCode())){
						returnStr = "0^补充说明信息中的操作人不能为空";
						return returnStr;
					}
				}else{
					returnStr = "0^补充说明信息不能为空";
					return returnStr;
				}
			}
		}
		
		CertifyInfoDto[] certifyDtos = reCaseRequestInfo.getCertifyInfoDto();
		if(certifyDtos != null && certifyDtos.length >0){
			CertifyInfoDto certify = null;
			for(int i=0;i<certifyDtos.length;i++){
				if(certifyDtos[i] != null){
					certify = certifyDtos[i];
					if(certify.getTypeCode()==null || "".equals(certify.getTypeCode())){
						returnStr = "0^单证信息中的单证类型不能为空";
						return returnStr;
					}else{
						String typeCode = "0102,0105,A001,A002,A004,A006,B003,B004,B005,B038," +
								"B039,B095,B40,C006,C008,C024,C027,C028,C052,C075,C076,Z001";
						if(!typeCode.contains(certify.getTypeCode())){
							returnStr = "0^单证信息中的单证类型不合法";
							return returnStr;
						}
					}
					if(certify.getTypeName()==null || "".equals(certify.getTypeName())){
						returnStr = "0^单证信息中的单证清单名称不能为空";
						return returnStr;
					}
				}else{
					returnStr = "0^单证信息不能为空";
					return returnStr;
				}
			}
		}
		
		
		
		CompePayFeeInfoDto[] compePayFeeDtos = reCaseRequestInfo.getCompePayFeeInfoDto();
		if(compePayFeeDtos != null && compePayFeeDtos.length>0){
			CompePayFeeInfoDto compePayFee = null;
			for(int i=0;i<compePayFeeDtos.length;i++){
				if(compePayFeeDtos[i] != null){
					compePayFee = compePayFeeDtos[i];
					if(compePayFee.getKindCode()==null || "".equals(compePayFee.getKindCode())){
						returnStr = "0^计算书赔款费用信息中的险别代码不能为空";
						return returnStr;
					}
					if(compePayFee.getKindName()==null || "".equals(compePayFee.getKindName())){
						returnStr = "0^计算书赔款费用信息中的险别名称不能为空";
						return returnStr;
					}
					if(compePayFee.getCodeCName()==null || "".equals(compePayFee.getCodeCName())){
						returnStr = "0^计算书赔款费用信息中的费用名称不能为空";
						return returnStr;
					}
					if(compePayFee.getCodeCode()==null || "".equals(compePayFee.getCodeCode())){
						returnStr = "0^计算书赔款费用信息中的费用代码不能为空";
						return returnStr;
					}else{
						String codeCode = "03,04,05,07,13,14,15,99";
						if(!codeCode.contains(compePayFee.getCodeCode())){
							returnStr = "0^计算书赔款费用信息中的费用代码不合法";
							return returnStr;
						}
					}
					/*if(compePayFee.getCheckDeptName()==null || "".equals(compePayFee.getCheckDeptName())){
						returnStr = "0^计算书赔款费用信息中的代查勘机构不能为空";
						return returnStr;
					}*/
					if(compePayFee.getCurrency()==null || "".equals(compePayFee.getCurrency())){
						returnStr = "0^计算书赔款费用信息中的币别代码不能为空";
						return returnStr;
					}
					if(compePayFee.getCurrencyName()==null || "".equals(compePayFee.getCurrencyName())){
						returnStr = "0^计算书赔款费用信息中的币别名称不能为空";
						return returnStr;
					}
				}else{
					returnStr = "0^计算书赔款费用信息不能为空";
					return returnStr;
				}
			}
		}
		
		CompeInvMainInfo[] compeInvMainDtos = reCaseRequestInfo.getCompeInvMainInfo();
		if(compeInvMainDtos != null && compeInvMainDtos.length>0){
			CompeInvMainInfo compeInvMain = null;
			for(int i=0;i<compeInvMainDtos.length;i++){
				if(compeInvMainDtos[i] != null){
					compeInvMain = compeInvMainDtos[i];
					if(compeInvMain.getRegistNo()==null || "".equals(compeInvMain.getRegistNo())){
						returnStr = "0^计算书理算清单信息中的报案号不能为空";
						return returnStr;
					}
					if(compeInvMain.getClaimNo()==null || "".equals(compeInvMain.getClaimNo())){
						returnStr = "0^计算书理算清单信息中的立案号不能为空";
						return returnStr;
					}
					
					CompeInvDetailInfo[] compeInvDetailInfos = compeInvMain.getCompeInvDetailInfo();
					if(compeInvDetailInfos!=null && compeInvDetailInfos.length>0){
						CompeInvDetailInfo compeInvDetail = null;
						for(int j=0;j<compeInvDetailInfos.length;j++){
							if(compeInvDetailInfos[j] != null){
								compeInvDetail = compeInvDetailInfos[j];
								if(compeInvDetail.getName()==null || "".equals(compeInvDetail.getName())){
									returnStr = "0^计算书理算清单明细信息中的被保险人不能为空";
									return returnStr;
								}
								if(compeInvDetail.getMedicalCard()==null || "".equals(compeInvDetail.getMedicalCard())){
									returnStr = "0^计算书理算清单明细信息中的医保编号不能为空";
									return returnStr;
								}
								if(compeInvDetail.getIdCard()==null || "".equals(compeInvDetail.getIdCard())){
									returnStr = "0^计算书理算清单明细信息中的身份证号码不能为空";
									return returnStr;
								}if(compeInvDetail.getMedicalFamily()==null || "".equals(compeInvDetail.getMedicalFamily())){
									returnStr = "0^计算书理算清单明细信息中的户名不能为空";
									return returnStr;
								}
								if(compeInvDetail.getBank()==null || "".equals(compeInvDetail.getBank())){
									returnStr = "0^计算书理算清单明细信息中的开户行不能为空";
									return returnStr;
								}
								if(compeInvDetail.getCreditCard()==null || "".equals(compeInvDetail.getCreditCard())){
									returnStr = "0^计算书理算清单明细信息中的银行账户不能为空";
									return returnStr;
								}
							}
						}
					}
				}
			}
		}
		// 判断出险人信息是否为空
		InjuryPersonInfoDto injuryPersonInfoDto = reCaseRequestInfo
				.getInjuryPersonInfoDto();
		if (injuryPersonInfoDto != null) {
			if (injuryPersonInfoDto.getAcciName() == null
					|| "".equals(injuryPersonInfoDto.getAcciName())) {
				returnStr = "0^具体出险人姓名不能为空";
				return returnStr;
			}
			if (injuryPersonInfoDto.getIdentifyNumber() == null
					|| "".equals(injuryPersonInfoDto.getIdentifyNumber())) {
				returnStr = "0^具体出险人身份证号码不能为空";
				return returnStr;
			}
			if (injuryPersonInfoDto.getSex() == null
					|| "".equals(injuryPersonInfoDto.getSex())) {
				returnStr = "0^具体出险人性别不能为空";
				return returnStr;
			}
		} else {
			returnStr = "0^具体出险人明细信息不能为空";
			return returnStr;
		}
		
		return returnStr;
	}
	/**
	 * 标志位字段的范围校验，若有不满足条件的字段属性，返回提示：0^某属性数据不合法
	 * @param reCaseRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkFlagFieldsRange(ReCaseRequestInfo reCaseRequestInfo) throws Exception{
		String returnStr = "";
		
		String notion = "01,02,03,04,05";
		if(!notion.contains(reCaseRequestInfo.getNotion())){
			returnStr = "0^审批片语不合法";
			return returnStr;
		}
		String zeroLossTypesString = "1,2,3";
		if(reCaseRequestInfo.getZeroLossType()!=null&&!"".equals(reCaseRequestInfo.getZeroLossType())&&!zeroLossTypesString.contains(reCaseRequestInfo.getZeroLossType())){
			returnStr = "0^零赔付原因不合法";
			return returnStr;
		}
		return returnStr;
	}
	
	/**
	 * 校验外部outId是否在中间表中存在，不存在提示错误信息
	 * @param reCaseRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkExistenceOfOutId(ReCaseRequestInfo reCaseRequestInfo) throws Exception{
		String returnStr = "";
		BLPrpLinterRequestFacade blPrpLinterRequestFacade = new BLPrpLinterRequestFacade();
		BLPrplinterAutoClaimDetailFacade blPrplinterAutoClaimDetailFacade = new BLPrplinterAutoClaimDetailFacade();
		Collection collection = 
			blPrpLinterRequestFacade.findByConditions(" OutId='"+reCaseRequestInfo.getRelationOutId()+"' ");
		if(collection == null||collection.isEmpty()){
			returnStr = "0^该数据未交互过理赔系统";
			return returnStr;
		}else{
			PrpLinterRequestDto prpLinterRequestDto = (PrpLinterRequestDto)collection.iterator().next();
			String id = prpLinterRequestDto.getId();
			Collection claimDetailList = blPrplinterAutoClaimDetailFacade.findByConditions(" id='"+id+"' ");
			if(claimDetailList==null || claimDetailList.size()<1){
				returnStr = "0^相关案件没有结案，不能重开";
				return returnStr;
			}
			PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = (PrplinterAutoClaimDetailDto)claimDetailList.iterator().next();
			if(!prplinterAutoClaimDetailDto.getEndcaSuccFlag().equals("1")){
				returnStr = "0^相关案件没有结案，不能重开";
				return returnStr;
			}
		}
		BLPrpLinterRecaseRequestFacade blPrpLinterRecaseRequestFacade = new BLPrpLinterRecaseRequestFacade();
		Collection collection2 = 
				blPrpLinterRecaseRequestFacade.findByConditions(" OutId='"+reCaseRequestInfo.getOutId()+"' ");
			if(collection2 != null){
				Iterator it = collection2.iterator();
				if(it.hasNext()){
					PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto)it.next();
					PrpLinterRecaseDetailDto prpLinterRecaseDetailDto= prpLinterRecaseRequestDto.getPrpLinterRecaseDetailDto();
					if(prpLinterRecaseDetailDto != null && prpLinterRecaseDetailDto.getEndcaSuccFlag() == "1"){
						returnStr = "2^该数据已经交互过理赔系统，理赔重开赔案成功";
						return returnStr;
					}else{
						returnStr = "2^该数据已经交互过理赔系统，理赔重开赔案失败";
						return returnStr;
					}
				}
			}
		return returnStr;
	}
	
	
	
	/**
	 * 金额合法性校验，返回提示：0^***不合法
	 * @param reCaseRequestInfo
	 * @return String
	 * @throws Exception  
	 */
	public String checkLegalityOfFees(ReCaseRequestInfo reCaseRequestInfo) throws Exception{
		String returnStr = "";
		
		/** --理赔   sumNoDutyFee = Σ(compepayfeeinfodto.chargeAmount)
	             	sumThisPaid = Σ(compeFeeinfodto.sumrealpay)
	             	prplcompensatesumpaid = sumNoDutyFee + sumThisPaid  */
		//判断费用合计是否等于子对象的费用金额之和
		double sumNoDutyFee = 0.0;
		CompePayFeeInfoDto[] compePayFeeDtos = reCaseRequestInfo.getCompePayFeeInfoDto();
		if(compePayFeeDtos!=null && compePayFeeDtos.length>0){
			CompePayFeeInfoDto compePayFee = null;
			for(int i=0;i<compePayFeeDtos.length;i++){
				if(compePayFeeDtos[i] != null){
					compePayFee = compePayFeeDtos[i];
					sumNoDutyFee += compePayFee.getChargeAmount();
				}
			}
			if(reCaseRequestInfo.getSumNoDutyFee() != sumNoDutyFee){
				returnStr = "0^费用合计不等于子对象的费用金额之和";
				return returnStr;
			}
		}
		//判断本次给付金额是否等于子对象的给付金额之和
		double sumThisPaid = 0.0;
		CompeFeeInfoDto[] compeFeeDtos = reCaseRequestInfo.getCompeFeeInfoDto();
		if(compeFeeDtos!=null && compeFeeDtos.length>0){
			CompeFeeInfoDto compeFee = null;
			for(int i=0;i<compeFeeDtos.length;i++){
				if(compeFeeDtos[i] != null){
					compeFee = compeFeeDtos[i];
					sumThisPaid += compeFee.getSumRealPay();
				}
			}
			if(reCaseRequestInfo.getSumThisPaid() != sumThisPaid){
				returnStr = "0^本次给付金额不等于子对象的给付金额之和";
				return returnStr;
			}
		}
		//判断赔款合计是否等于费用合计与本次给付金额之和
		if(reCaseRequestInfo.getPrplCompensateSumPaid() != reCaseRequestInfo.getSumNoDutyFee() + reCaseRequestInfo.getSumThisPaid()){
			returnStr = "0^赔款合计不等于费用合计与本次给付金额之和";
			return returnStr;
		}
		
		return returnStr;
	}
	
	
	/**
	 * 判断核赔日期是否合法，若不合法，返回提示：0^***不合法
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkClaimInputdate(ReCaseRequestInfo reCaseRequestInfo) throws Exception{
		String returnStr = "";
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		DateTime VericTime = new DateTime(reCaseRequestInfo.getVericTime(),DateTime.YEAR_TO_DAY);
		String outId = reCaseRequestInfo.getOutId();
		int flag = 0;
		try{
            Calendar cal = Calendar.getInstance();
            String year = String.valueOf(cal.get(Calendar.YEAR));
            String month = String.valueOf(cal.get(Calendar.MONTH));
            
            int iYear = 0;
            String iEndDate = "";
            PubTools  pubTools  = new PubTools();
            Date date = new Date();
            iEndDate  = sf.format(date);
            iEndDate =  pubTools.getMonthEnd(iEndDate, "1", 1);
            System.err.println("OutId="+reCaseRequestInfo.getOutId()+" ==VericTime==="+ VericTime.toString()+"iEndDate==="+iEndDate);  
           
            flag =  PubTools.compareDate(VericTime.toString(), iEndDate);
            if(flag>0){
        	   
            }else{
        	   returnStr = "0^核赔结案操作时间小于当前月第一天不能同步";
     		   return returnStr;
            }
          
        }catch(Exception exception){
            throw exception;
        }finally{
           
        }
        return returnStr;
	}
}
