package com.gyic.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.LabelValueBean;

import com.sinosoft.claim.dto.custom.CaseRelateNodeDto;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.VerifyLossDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpLcarLossDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimGradeDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLcomponentDto;
import com.sinosoft.claim.dto.domain.PrpLpersonDto;
import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLrepairFeeDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossExtDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossItemDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.claim.ui.control.action.ICollections;
import com.sinosoft.claim.ui.control.action.UICertainLossAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPrpLclaimGradeAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIVerifyLossAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.prpall.pubfun.GroupProposalService;
import com.sinosoft.prpall.pubfun.TransCodeCI;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * <p>Title: VerifyLossViewHelper</p>
 * <p>Description:定损ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 liubvo
 * @version 1.0
 * <br>
 */

public class AgriCombineVerifyLossViewHelper {
	private static Log logger = LogFactory.getLog(AgriCombineVerifyLossViewHelper.class);
	/**
	    * 保存核损时核损页面数据整理.
	    * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
	    * @param httpServletRequest
	    * @return stepFlag 标志
	    * @throws Exception
	    */
	    public VerifyLossDto viewToDto(int combineIndex,HttpServletRequest httpServletRequest) throws Exception
	    {
	      String lossType = httpServletRequest.getParameter("lossTypeFlag_"+combineIndex);
	      String nodeType = httpServletRequest.getParameter("nodeType");
	      
	      VerifyLossDto verifyLossDto = new VerifyLossDto();
	      
	      /*---------------------核损主表 PrpLverifyLoss------------------------------------*/
	      PrpLverifyLossDto prpLverifyLossDto = new PrpLverifyLossDto();
	      prpLverifyLossDto.setRegistNo            (httpServletRequest.getParameter("prpLverifyLossRegistNo_"+combineIndex));
	      prpLverifyLossDto.setClaimNo             (httpServletRequest.getParameter("prpLverifyLossClaimNo_"+combineIndex));
	      prpLverifyLossDto.setRiskCode            (httpServletRequest.getParameter("prpLverifyLossRiskCode_"+combineIndex));
	      prpLverifyLossDto.setPolicyNo            (httpServletRequest.getParameter("prpLverifyLossPolicyNo_"+combineIndex));
	      prpLverifyLossDto.setInsuredName         (httpServletRequest.getParameter("prpLverifyLossInsuredName_"+combineIndex));
	      prpLverifyLossDto.setLicenseNo           (httpServletRequest.getParameter("prpLverifyLossLicenseNo_"+combineIndex));
	      prpLverifyLossDto.setLicenseColorcode    (httpServletRequest.getParameter("prpLverifyLossLicenseColorcode_"+combineIndex));
	      prpLverifyLossDto.setCarKindCode         (httpServletRequest.getParameter("prpLverifyLossCarKindCode_"+combineIndex));
	      prpLverifyLossDto.setCurrency            (httpServletRequest.getParameter("prpLverifyLossCurrency_"+combineIndex));
	      prpLverifyLossDto.setSumPreDefLoss       (Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossSumPreDefLoss_"+combineIndex))));
	      prpLverifyLossDto.setSumDefLoss          (Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossSumDefLoss_"+combineIndex))));
	      prpLverifyLossDto.setMakeCom             (httpServletRequest.getParameter("prpLverifyLossMakeCom_"+combineIndex));
	      prpLverifyLossDto.setComCode             (httpServletRequest.getParameter("prpLverifyLossComCode_"+combineIndex));
	      prpLverifyLossDto.setHandlerCode         (httpServletRequest.getParameter("prpLverifyLossHandlerCode_"+combineIndex));
	      prpLverifyLossDto.setHandlerName         (httpServletRequest.getParameter("prpLverifyLossHandlerName_"+combineIndex));
	      
	      //Modify by chenrenda update begin 20050421
	      //Reason:在核损页面增加核损意见选项
	      int intPrpLverifyLossLossItemCode = Integer.parseInt(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossLossItemCode_"+combineIndex)));
	      String strVerifyPriceOpinion = "";
	      String strVerifyOpinion = "";
	      if(intPrpLverifyLossLossItemCode>0) {
	      	strVerifyPriceOpinion =   httpServletRequest.getParameter("verpOpinion_"+combineIndex);	
	      	strVerifyOpinion =   httpServletRequest.getParameter("verifyOpinion_"+combineIndex);
	      }
	      
	      prpLverifyLossDto.setVerifyOpinion(strVerifyOpinion);
	      //Modify by chenrenda update end 20050421
	      
	      prpLverifyLossDto.setVerpOpinion(strVerifyPriceOpinion);
	      prpLverifyLossDto.setVerpDate(new DateTime(httpServletRequest.getParameter("prpLverifyLossVerpDate_"+combineIndex),DateTime.YEAR_TO_DAY ));
	      prpLverifyLossDto.setVerpApproverCode         (httpServletRequest.getParameter("prpLverifyLossVerpApproverCode_"+combineIndex));
	      prpLverifyLossDto.setVerpRemark         (httpServletRequest.getParameter("prpLverifyLossVerpRemark"));
	      
	      prpLverifyLossDto.setLossItemCode         (httpServletRequest.getParameter("prpLverifyLossLossItemCode_"+combineIndex));
	      prpLverifyLossDto.setLossItemName         (httpServletRequest.getParameter("prpLverifyLossLossItemName_"+combineIndex));
	      prpLverifyLossDto.setInsureCarFlag        (httpServletRequest.getParameter("prpLverifyLossInsureCarFlag_"+combineIndex));
	      prpLverifyLossDto.setDefLossDate         (new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
	      prpLverifyLossDto.setDefLossDate         (new DateTime(httpServletRequest.getParameter("prpLverifyLossDefLossDate_"+combineIndex),DateTime.YEAR_TO_DAY ));
	      prpLverifyLossDto.setUnderWriteCode      (httpServletRequest.getParameter("prpLverifyLossUnderWriteCode_"+combineIndex));
	      prpLverifyLossDto.setUnderWriteName      (httpServletRequest.getParameter("prpLverifyLossUnderWriteName_"+combineIndex));
	      prpLverifyLossDto.setUnderWriteEndDate   (new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
	      prpLverifyLossDto.setBackCheckRemark   (httpServletRequest.getParameter("prpLverifyLossBackCheckRemark_"+combineIndex));  
	      prpLverifyLossDto.setVeriwReturnReason   (httpServletRequest.getParameter("prpLverifyLossVeriwReturnReason_"+combineIndex));  
	      //prpLverifyLossDto.setUnderWriteEndDate   (httpServletRequest.getParameter("prpLverifyLossUnderWriteEndDate"));
	      
	      //定损偏差率  
	      double prpLverifyLossFirstDefLoss    = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossFirstDefLoss_"+combineIndex)));      
	      double prpLverifyLossWarpDefLoss    = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossWarpDefLoss_"+combineIndex)));
	      prpLverifyLossDto.setFirstDefLoss(prpLverifyLossFirstDefLoss);
	      prpLverifyLossDto.setWarpDefLoss(prpLverifyLossWarpDefLoss);
	      //当提交时表示核损通过underWriteFlag的状态位为1,表示通过
	      String buttonSaveType = httpServletRequest.getParameter("buttonSaveType");
	      if(buttonSaveType.equals("3")||buttonSaveType.endsWith("4")) {
	        prpLverifyLossDto.setUnderWriteFlag      ("1");
	      } else {
	        prpLverifyLossDto.setUnderWriteFlag      ("0");
	      }
	      prpLverifyLossDto.setRemark              (httpServletRequest.getParameter("prpLverifyLossRemark_"+combineIndex));
	      prpLverifyLossDto.setVerifyRemark        (httpServletRequest.getParameter("prpLverifyLossVerifyRemark_"+combineIndex));
	      prpLverifyLossDto.setFlag                (httpServletRequest.getParameter("prpLverifyLossFlag_"+combineIndex));
	      //prpLverifyLossDto.setBackCheckRemark     (httpServletRequest.getParameter("prpLverifyLossBackCheckRemark"));
	     
//	    add by lixiang start at 2006-04-21
	      //reason: 增加保存理算退回的定损的原有数据的保存,若有数据不会被保存冲掉
	      prpLverifyLossDto.setCompensateApproverCode( httpServletRequest.getParameter("prpLverifyLossCompensateApproverCode_"+combineIndex));
	      prpLverifyLossDto.setCompensateBackDate( new DateTime((String)httpServletRequest.getParameter("prpLverifyLossCompensateBackDate_"+combineIndex),DateTime.YEAR_TO_DAY ));
	      prpLverifyLossDto.setCompensateFlag( httpServletRequest.getParameter("prpLverifyLossCompensateFlag_"+combineIndex));
	      prpLverifyLossDto.setCompensateOpinion( httpServletRequest.getParameter("prpLverifyLossCompensateOpinion_"+combineIndex));
	      //add by lixiang end at 2006-04-21
	      //add by wunier 20080103
	      //reason:农险改造添加新字段
	      String prpLverifyLossLossesNumber = httpServletRequest.getParameter("prpLverifyLossLossesNumber_"+combineIndex);
	      if(prpLverifyLossLossesNumber!=null&&!"".equals(prpLverifyLossLossesNumber)){
	      prpLverifyLossDto.setLossesNumber(Double.parseDouble(prpLverifyLossLossesNumber));
	      }
	      prpLverifyLossDto.setLossesUnitCode(httpServletRequest.getParameterValues("lossesUnitCode")[combineIndex]);
	      String prpLverifyLossDamageInsured = httpServletRequest.getParameter("prpLverifyLossDamageInsured_"+combineIndex);
	      if(prpLverifyLossDamageInsured!=null&&!"".equals(prpLverifyLossDamageInsured)){
	      prpLverifyLossDto.setDamageInsured(Double.parseDouble(prpLverifyLossDamageInsured));
	      }
	      String prpLverifyLossDisasterArea = httpServletRequest.getParameter("prpLverifyLossDisasterArea_"+combineIndex);
	      if(prpLverifyLossDisasterArea!=null&&!"".equals(prpLverifyLossDisasterArea)){
	      prpLverifyLossDto.setDisasterArea(Double.parseDouble(prpLverifyLossDisasterArea));
	      }
	      prpLverifyLossDto.setDisasterUnit(httpServletRequest.getParameter("disasterUnit_"+combineIndex));
	      String prpLverifyLossAffectedArea = httpServletRequest.getParameter("prpLverifyLossAffectedArea_"+combineIndex);
	      if(prpLverifyLossAffectedArea!=null&&!"".equals(prpLverifyLossAffectedArea)){
	      prpLverifyLossDto.setAffectedArea(Double.parseDouble(prpLverifyLossAffectedArea));
	      }
	      prpLverifyLossDto.setAffectedUnit(httpServletRequest.getParameter("affectedUnit_"+combineIndex));
	      String prpLverifyLossNoProductionArea = httpServletRequest.getParameter("prpLverifyLossNoProductionArea_"+combineIndex);
	      if(prpLverifyLossNoProductionArea!=null&&!"".equals(prpLverifyLossNoProductionArea)){
	      prpLverifyLossDto.setNoProductionArea(Double.parseDouble(prpLverifyLossNoProductionArea));
	      }
	      prpLverifyLossDto.setNoProductionUnit(httpServletRequest.getParameter("noProductionUnit_"+combineIndex));
	      String prpLverifyLossDeathQuantity = httpServletRequest.getParameter("prpLverifyLossDeathQuantity_"+combineIndex);
	      if(prpLverifyLossDeathQuantity!=null&&!"".equals(prpLverifyLossDeathQuantity)){
	      prpLverifyLossDto.setDeathQuantity(Double.parseDouble(prpLverifyLossDeathQuantity));
	      prpLverifyLossDto.setDeathUnit(httpServletRequest.getParameterValues("deathUnit")[combineIndex]);
	      }
	      String prpLverifyLossKillQuantity = httpServletRequest.getParameter("prpLverifyLossKillQuantity_"+combineIndex);
	      if(prpLverifyLossKillQuantity!=null&&!"".equals(prpLverifyLossKillQuantity)){
	      prpLverifyLossDto.setKillQuantity(Double.parseDouble(prpLverifyLossKillQuantity));
	      prpLverifyLossDto.setKillUnit(httpServletRequest.getParameterValues("killUnit")[combineIndex]);
	      }
	      //end by wunier 20080103

	      verifyLossDto.setPrpLverifyLossDto(prpLverifyLossDto);

	      /*---------------------状态内容prpLclaimStatus------------------------------------*/
	      String statusTemp = httpServletRequest.getParameter("buttonSaveType_"+combineIndex);
	      PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
	      prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType_"+combineIndex));
	      prpLclaimStatusDto.setBusinessNo(httpServletRequest.getParameter("prpLverifyLossRegistNo_"+combineIndex));
	      prpLclaimStatusDto.setPolicyNo(httpServletRequest.getParameter("prpLverifyLossPolicyNo_"+combineIndex));
	      prpLclaimStatusDto.setRiskCode(prpLverifyLossDto.getRiskCode());
	      prpLclaimStatusDto.setNodeType(nodeType);
	      prpLclaimStatusDto.setSerialNo(0);
	      prpLclaimStatusDto.setTypeFlag(prpLverifyLossDto.getLossItemCode());
	      prpLclaimStatusDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLverifyLossDto.getLossItemCode())));
	      //取得当前用户信息，写操作员信息到核损中
	      HttpSession session = httpServletRequest.getSession();
	      UserDto user = (UserDto) session.getAttribute("user");
	      System.out.println("user="+user);
	      prpLclaimStatusDto.setHandlerCode(user.getUserCode());
	      prpLclaimStatusDto.setInputDate(new DateTime(new Date(),DateTime.YEAR_TO_DAY));
	      prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
	      verifyLossDto.setPrpLclaimStatusDto(prpLclaimStatusDto);

	      return verifyLossDto;
	    }
	/**
	 * 保存定损时定损页面数据整理.
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
	 * @param httpServletRequest
	 * @return verifyLossDto 定损数据传输数据结构
	 * @throws Exception
	 */
	public VerifyLossDto viewToDto(HttpServletRequest httpServletRequest,int combineIndex)
			throws Exception {
		String lossType = httpServletRequest.getParameter("lossTypeFlag_"+combineIndex);
		String nodeType = httpServletRequest.getParameter("nodeType_"+combineIndex);

		//继承对verifyLoss,verifyLossText表的赋值
		VerifyLossDto verifyLossDto = this.viewToDto(combineIndex,httpServletRequest);
		/*---------------------财产核定损明细清单表 prpLprop ------------------------------------*/
		ArrayList prpLpropDtoList = new ArrayList();
		PrpLpropDto prpLpropDto = null;
		//add by lixiang start 20051228
		//reason: 因为考虑到录入的时候，可能没有立案，但是在提交的时候，做了立案，导致立案号没写入。
		String claimNo = httpServletRequest
				.getParameter("prpLverifyLossClaimNo_"+combineIndex);
		String registNo = httpServletRequest
				.getParameter("prpLverifyLossRegistNo_"+combineIndex);
		//先取立案号码，很重要，不要从页面上取得。。。
		if (claimNo == null || claimNo.length() < 2) {
			UICodeAction uiCodeAction = new UICodeAction();
			claimNo = uiCodeAction.translateBusinessCode(registNo, true);
		}
		//add by lixiang end 20051228

		//定核损处理标的表
		PrpLverifyLossItemDto LossItemRepairComponentDto = new PrpLverifyLossItemDto();
		PrpLverifyLossItemDto LossItemPersonDto = new PrpLverifyLossItemDto();
		PrpLverifyLossItemDto LossItemPropDto = new PrpLverifyLossItemDto();
		PrpLverifyLossItemDto LossItemAllLossDto = new PrpLverifyLossItemDto();
		UICodeAction uiCodeAction = new UICodeAction();
		ArrayList lossItemListTemp = new ArrayList();

		//从界面得到输入数组
		String prpLpropPolicyNo = httpServletRequest
				.getParameter("prpLverifyLossPolicyNo_"+combineIndex);
		String prpLpropRiskCode = httpServletRequest
				.getParameter("prpLverifyLossRiskCode_"+combineIndex);
		String prpLpropClaimNo = httpServletRequest
				.getParameter("prpLverifyLossClaimNo_"+combineIndex);
		String prpLpropRegistNo = httpServletRequest
				.getParameter("prpLverifyLossRegistNo_"+combineIndex);
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLpropRiskCode);

		String[] prpLpropSerialNo = httpServletRequest
				.getParameterValues("prpLpropSerialNo_"+combineIndex);
		String[] prpLpropItemKindNo = httpServletRequest
				.getParameterValues("prpLpropItemKindNo_"+combineIndex);
		String[] prpLpropFamilyNo = httpServletRequest
				.getParameterValues("prpLpropFamilyNo_"+combineIndex);
		String[] prpLpropFamilyName = httpServletRequest
				.getParameterValues("prpLpropFamilyName_"+combineIndex);
		String[] prpLpropKindCode = httpServletRequest
				.getParameterValues("prpLpropKindCode_"+combineIndex);
		String[] prpLpropItemCode = httpServletRequest
				.getParameterValues("prpLpropItemCode_"+combineIndex);
		String[] prpLpropLossItemCode = httpServletRequest
				.getParameterValues("prpLpropLossItemCode_"+combineIndex);
		String[] prpLpropLossItemName = httpServletRequest
				.getParameterValues("prpLpropLossItemName_"+combineIndex);
		String[] prpLpropFeeTypeCode = httpServletRequest
				.getParameterValues("prpLpropFeeTypeCode_"+combineIndex);
		String[] prpLpropCurrency = httpServletRequest
				.getParameterValues("prpLpropCurrency_"+combineIndex);
		String[] prpLpropUnitPrice = httpServletRequest
				.getParameterValues("prpLpropUnitPrice_"+combineIndex);
		String[] prpLpropLossQuantity = httpServletRequest
				.getParameterValues("prpLpropLossQuantity_"+combineIndex);
		String[] prpLpropUnit = httpServletRequest
				.getParameterValues("prpLpropUnit_"+combineIndex);
		String[] prpLpropBuyDate = httpServletRequest
				.getParameterValues("prpLpropBuyDate_"+combineIndex);
		String[] prpLpropDepreRate = httpServletRequest
				.getParameterValues("prpLpropDepreRate_"+combineIndex);
		String[] prpLpropSumLoss = httpServletRequest
				.getParameterValues("prpLpropSumLoss_"+combineIndex);
		String[] prpLpropSumReject = httpServletRequest
				.getParameterValues("prpLpropSumReject_"+combineIndex);
		String[] prpLpropRejectReason = httpServletRequest
				.getParameterValues("prpLpropRejectReason_"+combineIndex);
		String[] prpLpropLossRate = httpServletRequest
				.getParameterValues("prpLpropLossRate_"+combineIndex);
		String[] prpLpropSumDefLoss = httpServletRequest
				.getParameterValues("prpLpropSumDefLoss_"+combineIndex);
		String[] prpLpropRemark = httpServletRequest
				.getParameterValues("prpLpropRemark_"+combineIndex);
		String[] prpLpropVeriUnitPrice = httpServletRequest
				.getParameterValues("prpLpropVeriUnitPrice_"+combineIndex);
		String[] prpLpropVeriLossQuantity = httpServletRequest
				.getParameterValues("prpLpropVeriLossQuantity_"+combineIndex);
		String[] prpLpropVeriUnit = httpServletRequest
				.getParameterValues("prpLpropVeriUnit_"+combineIndex);
		String[] prpLpropVeriDepreRate = httpServletRequest
				.getParameterValues("prpLpropVeriDepreRate_"+combineIndex);
		String[] prpLpropVeriSumLoss = httpServletRequest
				.getParameterValues("prpLpropVeriSumLoss_"+combineIndex);
		String[] prpLpropVeriSumReject = httpServletRequest
				.getParameterValues("prpLpropVeriSumReject_"+combineIndex);
		String[] prpLpropVeriRejectReason = httpServletRequest
				.getParameterValues("prpLpropVeriRejectReason_"+combineIndex);
		String[] prpLpropVeriLossRate = httpServletRequest
				.getParameterValues("prpLpropVeriLossRate_"+combineIndex);
		String[] prpLpropVeriSumDefLoss = httpServletRequest
				.getParameterValues("prpLpropVeriSumDefLoss_"+combineIndex);
		String[] prpLpropVeriRemark = httpServletRequest
				.getParameterValues("prpLpropVeriRemark_"+combineIndex);
		String[] prpLpropFlag = httpServletRequest
				.getParameterValues("prpLpropFlag_"+combineIndex);
		//		add by lixiang start at 2006-04-21
		//reason: 增加保存理算退回的定损的标志的保存,若有数据不会被保存冲掉
		String[] prpLpropCompensateBackFlag = httpServletRequest
				.getParameterValues("prpLpropCompensateBackFlag_"+combineIndex);
		//add by lixiang end at 2006-04-21

		//对象赋值
		if (prpLpropSerialNo == null) {

		} else {
			for (int index = 1; index < prpLpropSerialNo.length; index++) {
				prpLpropDto = new PrpLpropDto();
				prpLpropDto.setPolicyNo(prpLpropPolicyNo);
				prpLpropDto.setRiskCode(prpLpropRiskCode);
				prpLpropDto.setClaimNo(claimNo);
				prpLpropDto.setRegistNo(prpLpropRegistNo);
				prpLpropDto.setSerialNo(index);
				//prpLpropDto.setSerialNo( Integer.parseInt(DataUtils.nullToZero(prpLpropSerialNo[index])));
				prpLpropDto.setItemKindNo(Integer.parseInt(DataUtils
						.nullToZero(prpLpropItemKindNo[index])));
				prpLpropDto.setFamilyNo(Integer.parseInt(DataUtils
						.nullToZero(prpLpropFamilyNo[index])));
				prpLpropDto.setFamilyName(prpLpropFamilyName[index]);
				prpLpropDto.setKindCode(prpLpropKindCode[index]);
				prpLpropDto.setItemCode(prpLpropItemCode[index]);
				if("I".equals(strRiskType)||"H".equals(strRiskType)){
				prpLpropDto.setLossItemCode("-2");
				}else{
				prpLpropDto.setLossItemCode(prpLpropLossItemCode[index]);
				}
				prpLpropDto.setLossItemName(prpLpropLossItemName[index]);
				prpLpropDto.setFeeTypeCode("");
				prpLpropDto.setFeeTypeName("");
				prpLpropDto.setCurrency(prpLpropCurrency[index]);
				prpLpropDto.setUnitPrice(Double.parseDouble(DataUtils
						.nullToZero(prpLpropUnitPrice[index])));
				prpLpropDto.setLossQuantity(Double.parseDouble(DataUtils
						.nullToZero(prpLpropLossQuantity[index])));
				prpLpropDto.setUnit(prpLpropUnit[index]);
				prpLpropDto.setBuyDate(new DateTime(new Date(),
						DateTime.YEAR_TO_DAY));
				//prpLpropDto.setBuyDate                  ( new DateTime(prpLpropBuyDate      [index]));
				prpLpropDto.setDepreRate(Double.parseDouble(DataUtils
						.nullToZero(prpLpropDepreRate[index])));
				prpLpropDto.setSumLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLpropSumLoss[index])));
				prpLpropDto.setSumReject(Double.parseDouble(DataUtils
						.nullToZero(prpLpropSumReject[index])));
				prpLpropDto.setRejectReason(prpLpropRejectReason[index]);
				prpLpropDto.setLossRate(Double.parseDouble(DataUtils
						.nullToZero(prpLpropLossRate[index])));
				prpLpropDto.setSumDefLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLpropSumDefLoss[index])));
				prpLpropDto.setRemark(prpLpropRemark[index]);
				prpLpropDto.setVeriUnitPrice(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriUnitPrice[index])));
				prpLpropDto.setVeriLossQuantity(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriLossQuantity[index])));
				prpLpropDto.setVeriUnit(prpLpropVeriUnit[index]);
				prpLpropDto.setVeriDepreRate(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriDepreRate[index])));
				prpLpropDto.setVeriSumLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriSumLoss[index])));
				prpLpropDto.setVeriSumReject(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriSumReject[index])));
				prpLpropDto
						.setVeriRejectReason(prpLpropVeriRejectReason[index]);
				prpLpropDto.setVeriLossRate(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriLossRate[index])));
				prpLpropDto.setVeriSumDefLoss(Double.parseDouble(DataUtils
						.nullToZero(prpLpropVeriSumDefLoss[index])));
				prpLpropDto.setVeriRemark(prpLpropVeriRemark[index]);
				prpLpropDto.setFlag(prpLpropFlag[index]);
				prpLpropDto
						.setCompensateBackFlag(prpLpropCompensateBackFlag[index]);
				//===========================================================
				UIRegistAction uiRegistAction = new UIRegistAction();
				RegistDto registDto = uiRegistAction
						.findByPrimaryKey(prpLpropRegistNo);

				if (!registDto.getPrpLregistDto().getPolicyNo().equals("")) {
					EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
					PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
							registDto.getPrpLregistDto().getPolicyNo(),
							registDto.getPrpLregistDto().getDamageStartDate()
									.toString(), registDto.getPrpLregistDto()
									.getDamageStartHour());
					//增加是否是团单的判断，如果是团单则从页面收取itemkindno
					String strRiskCode = registDto.getPrpLregistDto().getRiskCode();
					GroupProposalService groupProposalService = new GroupProposalService();
					 //是否是团单的标志
			        boolean isVirturlItemRisk = groupProposalService.isGroupProposal(strRiskCode);
			        if(!isVirturlItemRisk) {
						for (int k = 0; k < policyDto.getPrpCitemKindDtoList().size(); k++) {
					           PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) policyDto
							          .getPrpCitemKindDtoList().get(k);
					           if (prpCitemKindDto.getKindCode().equals(
							          prpLpropDto.getKindCode())) {
						               prpLpropDto.setItemKindNo(prpCitemKindDto
								              .getItemKindNo());
						                 break;
					           }
						}
			        }
				}
				//===========================================================
				//加入集合
				prpLpropDtoList.add(prpLpropDto);
			}
			PropertyUtils.copyProperties(LossItemPropDto, verifyLossDto
					.getPrpLverifyLossDto());
			LossItemPropDto.setSerialNo(3);
			LossItemPropDto.setLossType("3");
			LossItemPropDto.setNodeType("veri");
			lossItemListTemp.add(LossItemPropDto);
		}
		//财产核定损明细清单表
		verifyLossDto.setPrpLpropDtoList(prpLpropDtoList);
		/*---------------------定损车辆表&修理费用清单&换件项目清单 prpLcarLoss&prpLrepairFee&prpLcomponent ------------------------------------*/
		
		verifyLossDto.setPrpLverifyLossItemDtoList(lossItemListTemp);
		
		/*---------------------报案信息补充说明 PrpLregistExt ------------------------------------*/
		ArrayList prpLregistExtDtoList = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = null;
		//从界面得到输入数组
		String prpLregistExtRegistNo = (String) httpServletRequest
				.getParameter("prpLregistExtRegistNo_"+combineIndex);
		String prpLregistExtRiskCode = httpServletRequest
				.getParameter("prpLregistExtRiskCode_"+combineIndex);
		String[] prpLregistExtSerialNo = httpServletRequest
				.getParameterValues("prpLregistExtSerialNo_"+combineIndex);
		String[] prpLregistExtInputDate = httpServletRequest
				.getParameterValues("prpLregistExtInputDate_"+combineIndex);
		String[] prpLregistExtInputHour = httpServletRequest
				.getParameterValues("prpLregistExtInputHour_"+combineIndex);
		String[] prpLregistExtOperatorCode = httpServletRequest
				.getParameterValues("prpLregistExtOperatorCode_"+combineIndex);
		String[] prpLregistExtContext = httpServletRequest
				.getParameterValues("prpLregistExtContext_"+combineIndex);

		//对象赋值
		//人员伤亡跟踪 部分开始
		if (prpLregistExtSerialNo == null) {
		} else {
			//System.out.println("人员伤亡跟踪部分开始 ");
			for (int index = 1; index < prpLregistExtSerialNo.length; index++) {
				prpLregistExtDto = new PrpLregistExtDto();
				prpLregistExtDto.setRegistNo(prpLregistExtRegistNo);
				prpLregistExtDto.setRiskCode(prpLregistExtRiskCode);
				prpLregistExtDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLregistExtSerialNo[index])));
				prpLregistExtDto.setInputDate(new DateTime(
						prpLregistExtInputDate[index], DateTime.YEAR_TO_DAY));
				prpLregistExtDto.setInputHour(prpLregistExtInputHour[index]);
				prpLregistExtDto
						.setOperatorCode(prpLregistExtOperatorCode[index]);
				prpLregistExtDto.setContext(prpLregistExtContext[index]);
				//加入集合
				prpLregistExtDtoList.add(prpLregistExtDto);
			}
			//报案集合中加入损失部位
			verifyLossDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
		}

		return verifyLossDto;
	}

	/**
	 * 生成定损信息详细画面
	 * @param httpServletRequest 返回给页面的request
	 * @param businessNo     业务号码
	 * @param editType   编辑类型
	 * @throws Exception
	 */
	public void verifyLossDtoView(HttpServletRequest httpServletRequest,
			String registNo, String editType, String tempStatus,int index)
			throws Exception {
		//标的序号，如果是人伤为0，否则为1，2，3，4，5等车辆序号
		String lossItemCode = httpServletRequest.getParameter("lossItemCode");
		//工作流的信息
		String swfLogFlowID = (String) httpServletRequest
				.getParameter("swfLogFlowID");
		String swfLogLogNo = (String) httpServletRequest
				.getParameter("swfLogLogNo");
		String nodeType = (String) httpServletRequest.getParameter("nodeType");

		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user"); //用户信息

		String riskCode = httpServletRequest.getParameter("riskCode");
		//非车险，lossItemCode默认为1,这样就可以正常进行财产险详细的删除操作了
		logger.debug("RiskCode:" + riskCode);
		UICodeAction uiCodeAction = new UICodeAction();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		//modify by miaowenjun 20060925 start 农险的lossitemcode暂定为-2
		if (riskCode != null && !strRiskType.equals(("D")) && !strRiskType.equals(("I"))&& !strRiskType.equals(("H"))) {
			lossItemCode = "1";
		}
		if (strRiskType.equals(("I"))|| strRiskType.equals(("H"))) {
			lossItemCode = "-2";
		}
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		CertainLossDto certainLossDto = uiCertainLossAction.findByPrimaryKey(
				registNo.trim(), lossItemCode);

		UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
		VerifyLossDto verifyLossDto = uiVerifyLossAction.findByPrimaryKey(
				registNo.trim(), lossItemCode, nodeType);

		//根据查询出来的数据内容，给PrpLverifyLossDto赋值
		PrpLverifyLossDto prpLverifyLossDto = verifyLossDto
				.getPrpLverifyLossDto();

		//设置定损操作的状态为 案件修改 (正处理任务)      
		if (verifyLossDto.getPrpLclaimStatusDto() != null) {
			if (tempStatus == null) {
				prpLverifyLossDto.setStatus(verifyLossDto
						.getPrpLclaimStatusDto().getStatus());
			} else {
				prpLverifyLossDto.setStatus(tempStatus);
			}
		} else {
			//已提交，已经处理完毕的状态
			prpLverifyLossDto.setStatus("1");
		}

		//校验是否已经向外询价，如果已经向外询价，则允许核价员超权限提交
		if (!prpLverifyLossDto.getStatus().equals("4")) {
			String msg = "";
			msg = this.checkVerpo(swfLogFlowID, swfLogLogNo, lossItemCode);
			prpLverifyLossDto.setVerifPriceOuterMsg(msg);
		}

		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo.trim());
		String relatePolicyFlag = "0";
		if (registDto.getPrpLRegistRPolicyList().size() > 1) {
			relatePolicyFlag = "1";
		}
		if ("1".equals(relatePolicyFlag)) {
			httpServletRequest.setAttribute("prpLregistRPolicyNo", registDto
					.getPrpLRegistRPolicyDtoOfCompel());
		}
		//add by zhaolu end at 2006-06-09
		//属性条款类别
		prpLverifyLossDto.setClauseType(registDto.getPrpLregistDto()
				.getClauseType());

		//查询相同保单号的出险次数
		DAACombineRegistViewHelper dAACombineRegistViewHelper = new DAACombineRegistViewHelper();
		dAACombineRegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLverifyLossDto.getPolicyNo(), prpLverifyLossDto
						.getRegistNo(),index);
		//设置相关代码的中文转换
		changeCodeToName(httpServletRequest, prpLverifyLossDto);
		changeCodeToName(httpServletRequest, verifyLossDto);
		//设置窗体表单中各个多选框中列表信息的内容
		setSelectionList(httpServletRequest);

		//查询核价权限       
		String taskCode = AppConfig.get("sysconst.TASKCODE_LPHJ"); //任务代码为核价
		UIPrpLclaimGradeAction uiPrpLclaimGradeAction = new UIPrpLclaimGradeAction();

		//单个自定义配件价格
		PrpLclaimGradeDto prpLclaimGradeDto1 = uiPrpLclaimGradeAction
				.findByPrimaryKey(user.getUserCode(), taskCode,
						"SINGLE_CUSTOM_COMP_PRICE");
		//单车自定义配件价格
		PrpLclaimGradeDto prpLclaimGradeDto2 = uiPrpLclaimGradeAction
				.findByPrimaryKey(user.getUserCode(), taskCode,
						"SINGLECAR_CUSTOM_COMP_PRICE");
		//单车全部配件价格
		PrpLclaimGradeDto prpLclaimGradeDto3 = uiPrpLclaimGradeAction
				.findByPrimaryKey(user.getUserCode(), taskCode,
						"SINGLECAR_ALL_COMP_PRICE");

		if (prpLclaimGradeDto1 == null)
			prpLclaimGradeDto1 = new PrpLclaimGradeDto();
		if (prpLclaimGradeDto2 == null)
			prpLclaimGradeDto2 = new PrpLclaimGradeDto();
		if (prpLclaimGradeDto3 == null)
			prpLclaimGradeDto3 = new PrpLclaimGradeDto();

		httpServletRequest.setAttribute("prpLclaimGradeDto1",
				prpLclaimGradeDto1);
		httpServletRequest.setAttribute("prpLclaimGradeDto2",
				prpLclaimGradeDto2);
		httpServletRequest.setAttribute("prpLclaimGradeDto3",
				prpLclaimGradeDto3);

		//设置定损信息内容到窗体表单
		httpServletRequest.setAttribute("prpLverifyLossDto", prpLverifyLossDto);
		httpServletRequest.setAttribute("verifyLossDto", verifyLossDto);

		httpServletRequest.setAttribute("verifyPriceOpinionList", ICollections
				.getVerifyPriceOpinionList());
		//Reason:增加核损意见       
		httpServletRequest.setAttribute("verifyOpinionList", ICollections
				.getVerifyOpinionList());

		//设置各个子表信息项到窗体表单
		setSubInfo(httpServletRequest, verifyLossDto);

		PrpLthirdPartyDto prpLthirdParty1Dto = new PrpLthirdPartyDto();
		prpLthirdParty1Dto = certainLossDto.getPrpLthirdPartyDto();
		httpServletRequest.setAttribute("prpLthirdParty1Dto",
				prpLthirdParty1Dto);

		//取得相关主表的信息 
		//UIRegistAction uiRegistAction = new UIRegistAction();
		CaseRelateNodeDto caseRelateNodeDto = uiRegistAction
				.relateNode(registNo);
		PrpLcheckDto prpLcheckDtoTemp1 = caseRelateNodeDto.getPrpLcheckDto();
		if (prpLcheckDtoTemp1 == null)
			prpLcheckDtoTemp1 = new PrpLcheckDto();
		httpServletRequest.setAttribute("prpLcheckDtoTemp", prpLcheckDtoTemp1);
		PrpLregistDto prpLregistDtoTemp1 = caseRelateNodeDto.getPrpLregistDto();
		String timeTemp = StringConvert.toStandardTime(prpLregistDtoTemp1
				.getDamageStartHour());
		prpLregistDtoTemp1.setDamageStartMinute(timeTemp.substring(3, 5));
		prpLregistDtoTemp1.setDamageStartHour(timeTemp.substring(0, 2));
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDtoTemp1);

		//设置工作流下一个节点提交的配置信息
		getSubmitNodes(httpServletRequest);
	}

	/**
	 * 填写定损页面及查询定损request的生成.
	 * @param httpServletRequest 返回给页面的request
	 * @param businessNo 业务号码
	 * @param editType 编辑类型
	 * @throws Exception
	 */
	public void certainLossDtoToView(HttpServletRequest httpServletRequest,
			String registNo, String editType,int index) throws Exception {
		//标的序号，如果是人伤为0，否则为1，2，3，4，5等车辆序号
		String lossItemCode = httpServletRequest.getParameter("lossItemCode");
		//工作流的信息
		String swfLogFlowID = (String) httpServletRequest
				.getParameter("swfLogFlowID");
		String swfLogLogNo = (String) httpServletRequest
				.getParameter("swfLogLogNo");
		String nodeType = (String) httpServletRequest.getParameter("nodeType");
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user"); //用户信息

		String riskCode = httpServletRequest.getParameter("riskCode");

		//非车险，lossItemCode默认为1,这样就可以正常进行财产险详细的删除操作了
		//System.out.println("riskCode=============="+riskCode);
		UICodeAction uiCodeAction = new UICodeAction();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		CertainLossDto certainLossDto = uiCertainLossAction.findByPrimaryKey(
				registNo.trim(), lossItemCode);

		UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
		//System.out.println("registNo-------"+registNo);
		VerifyLossDto verifyLossDto = uiVerifyLossAction.findByPrimaryKey(
				registNo.trim(), lossItemCode, nodeType);
		
		//根据查询出来的数据内容，给PrpLverifyLossDto赋值
		PrpLverifyLossDto prpLverifyLossDto = null;
		prpLverifyLossDto = verifyLossDto.getPrpLverifyLossDto();
		
		if (prpLverifyLossDto == null) {
			prpLverifyLossDto = new PrpLverifyLossDto();
		}
		//准备数据

		if (verifyLossDto.getPrpLpropDtoList() != null) {
			for (int i = 0; i < verifyLossDto.getPrpLpropDtoList().size(); i++) {
				PrpLpropDto prpLpropDto = (PrpLpropDto) verifyLossDto
						.getPrpLpropDtoList().get(i);
				prpLpropDto.setVeriSumLoss(prpLpropDto.getSumLoss());
				prpLpropDto.setVeriSumReject(prpLpropDto.getSumReject());
				prpLpropDto.setVeriSumDefLoss(prpLpropDto.getSumDefLoss());
				prpLpropDto.setVeriRemark(prpLpropDto.getRemark());

			}
		}
		prpLverifyLossDto.setStatus("1");

		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo.trim());
		//属性条款类别
		prpLverifyLossDto.setClauseType(registDto.getPrpLregistDto()
				.getClauseType());

		//查询相同保单号的出险次数
		DAACombineRegistViewHelper dAACombineRegistViewHelper = new DAACombineRegistViewHelper();
		dAACombineRegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLverifyLossDto.getPolicyNo(), prpLverifyLossDto
						.getRegistNo(),index);
		//设置相关代码的中文转换
		changeCodeToName(httpServletRequest, prpLverifyLossDto);
		changeCodeToName(httpServletRequest, verifyLossDto);
		//设置窗体表单中各个多选框中列表信息的内容
		setSelectionList(httpServletRequest);

		//设置定损信息内容到窗体表单
		httpServletRequest.setAttribute("prpLverifyLossDto", prpLverifyLossDto);
		httpServletRequest.setAttribute("verifyLossDto", verifyLossDto);
		if (nodeType.equals("verip")) {
			httpServletRequest.setAttribute("verifyPriceOpinionList",
					ICollections.getVerifyPriceOpinionList());
		} else if (nodeType.equals("verpo")) {
			httpServletRequest.setAttribute("verifyPriceOpinionList",
					ICollections.getVerifyPriceVerpoOpinionList());
		}

		//Modify by chenrenda add begin 20050421
		//Reason:增加核损意见
		httpServletRequest.setAttribute("verifyOpinionList", ICollections
				.getVerifyOpinionList());
		//Modify by chenrenda add  end 20050421

		//设置各个子表信息项到窗体表单
		verifyLossDto.setPrpLverifyLossDto(prpLverifyLossDto);
		setSubInfo(httpServletRequest, verifyLossDto);

		//取得相关主表的信息
		//UIRegistAction uiRegistAction = new UIRegistAction();
		CaseRelateNodeDto caseRelateNodeDto = uiRegistAction
				.relateNode(registNo);
		PrpLcheckDto prpLcheckDtoTemp1 = caseRelateNodeDto.getPrpLcheckDto();
		if (prpLcheckDtoTemp1 == null)
			prpLcheckDtoTemp1 = new PrpLcheckDto();
		httpServletRequest.setAttribute("prpLcheckDtoTemp", prpLcheckDtoTemp1);
		PrpLregistDto prpLregistDtoTemp1 = caseRelateNodeDto.getPrpLregistDto();
		String timeTemp = StringConvert.toStandardTime(prpLregistDtoTemp1
				.getDamageStartHour());
		prpLregistDtoTemp1.setDamageStartMinute(timeTemp.substring(3, 5));
		prpLregistDtoTemp1.setDamageStartHour(timeTemp.substring(0, 2));
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDtoTemp1);

		//设置工作流下一个节点提交的配置信息
		getSubmitNodes(httpServletRequest);
	}

	/**
	 * 检查本车核价是否已向外询价
	 * @param swfLogDtoCurrent SwfLogDto 需要被检查的节点对象
	 * @throws Exception
	 */
	public String checkVerpo(String swfLogFlowID, String swfLogLogNo,
			String lossItemCode) throws Exception {
		//目前只检查该车核价是否已经询价过（只针对单辆车）

		String nodeType = "";
		String conditions = "";
		String msg = "";

		SwfLogDto swfLogDtoCurrent = null;

		int logNo = Integer.parseInt(DataUtils.nullToZero(swfLogLogNo));

		if (swfLogFlowID == null || logNo < 1)
			return msg;

		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		swfLogDtoCurrent = uiWorkFlowAction.findNodeByPrimaryKey(swfLogFlowID,
				logNo);
		if (swfLogDtoCurrent == null)
			return msg;

		nodeType = swfLogDtoCurrent.getNodeType();

		if (nodeType.equals("verip")) //核价检查是否已经向外询价
		{
			conditions = " flowid='" + swfLogDtoCurrent.getFlowID()
					+ "' and nodeType='verpo'  and  lossItemCode = '"
					+ lossItemCode + "' ";
		}

		if (uiWorkFlowAction.getCount(conditions) > 0) {
			msg = "本车已经向外询价";
		}
		return msg;
	}

	/**
	 * 已核损案件查询
	 * @param httpServletRequest 返回给页面的request
	 * @param businessNo      赔案号
	 * @throws Exception
	 */
	public void getUnderWriteVerifyLossList(
			HttpServletRequest httpServletRequest) throws Exception {
		logger.info("查询已核算案件 对 like 进行了优化");
		//caseNO,policyNo,claimNo
		//根据输入的保单号，定损号生成SQL where 子句
		String conditions = "";
		conditions = " underWriteFlag = '1' ";
		//查询立案信息
		UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
		//得到多行定损主表信息
		Collection verifyLossList = new ArrayList();
		verifyLossList = (Collection) uiVerifyLossAction
				.findByConditions(conditions);
		PrpLverifyLossDto prpLverifyLossDto = new PrpLverifyLossDto();
		prpLverifyLossDto.setVerifyLossList(verifyLossList);
		prpLverifyLossDto.setEditType(httpServletRequest
				.getParameter("editType"));
		httpServletRequest.setAttribute("prpLverifyLossDto", prpLverifyLossDto);
	}

	/**
	 * 获取选择框和列表框中的所有内容
	 * @param httpServletRequest 返回给页面的request
	 * @param prpLcaseNoDto    定损的数据类
	 * @throws Exception
	 */
	private void setSelectionList(HttpServletRequest httpServletRequest)
			throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		//(11)得到费用名称的列表 ---
		Collection FeeTypeCodeList = new ArrayList();
		FeeTypeCodeList.add(new LabelValueBean("修理费", "01"));
		FeeTypeCodeList.add(new LabelValueBean("材料费", "02"));
		httpServletRequest.setAttribute("FeeTypeCodeList", FeeTypeCodeList);

		//(2)得到车辆种类列表
		Collection carKindCodes = uiCodeAction.getCodeType("CarKind",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
						"RISKCODE_DAA"));
		httpServletRequest.setAttribute("carKindCodes", carKindCodes);

	}

	/**
	 * 根据PrpPrepayDto中的已经设置的代码内容，对代码进行名称转换
	 * @param httpServletRequest 返回给页面的request
	 * @param prpLcaseNoDto    定损的数据类
	 * @throws Exception
	 */
	private void changeCodeToName(HttpServletRequest httpServletRequest,
			PrpLverifyLossDto prpLverifyLossDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		//号牌颜色转换
		String licenseColorCodeCode = prpLverifyLossDto.getLicenseColorcode();
		String licenseColor = uiCodeAction.translateCodeCode("LicenseColor",
				licenseColorCodeCode, true);
		prpLverifyLossDto.setLicenseColor(licenseColor);
		//车辆类型转换
		String carKindCode = prpLverifyLossDto.getCarKindCode();
		String carKind = uiCodeAction.translateCodeCode("CarKind", carKindCode,
				true);
		prpLverifyLossDto.setCarKind(carKind);
		//条款名称的转换
		String clauseType = prpLverifyLossDto.getClauseType();
		String clauseName = uiCodeAction.translateCodeCode("ClauseType",
				clauseType, true);
		prpLverifyLossDto.setClauseName(clauseName);

	}

	/**
	 * 根据PrpPrepayDto中的已经设置的代码内容，对代码进行名称转换
	 * @param httpServletRequest 返回给页面的request
	 * @param prpLcaseNoDto    定损的数据类
	 * @throws Exception
	 */
	private void changeCodeToName(HttpServletRequest httpServletRequest,
			VerifyLossDto verifyLossDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		String compelRiskCode = "";//交强险险种号
		String businessRiskCode = "";//商业险险种号
		String riskCode = "";
        String riskCodeType = "";//险种类型
        TransCodeCI transCodeCI = new TransCodeCI();

		PrpLpropDto prpLpropDto = null;
		if (verifyLossDto.getPrpLpropDtoList() != null) {
			for (int i = 0; i < verifyLossDto.getPrpLpropDtoList().size(); i++) {
				prpLpropDto = (PrpLpropDto) verifyLossDto.getPrpLpropDtoList()
						.get(i);
				if (prpLpropDto.getFeeTypeCode().trim().equals("01")) {
					prpLpropDto.setFeeTypeName("修理费");
				} else if (prpLpropDto.getFeeTypeCode().trim().equals("02")) {
					prpLpropDto.setFeeTypeName("材料费");
				}
		        riskCode  = prpLpropDto.getRiskCode();
				if ("BZ".equals(prpLpropDto.getKindCode())) {

			        riskCodeType = "";
			        //取交强险uticodetransfer表类型
			        riskCodeType = transCodeCI.getRiskCodeCIType(riskCode);
					prpLpropDto.setKindName(uiCodeAction.translateKindCode(
							BusinessRuleUtil.getOuterCode(httpServletRequest,
									riskCodeType), prpLpropDto.getKindCode(),
							true));
				} else {
			        riskCodeType = "";
			        //取商业险uticodetransfer表类型
			        riskCodeType = transCodeCI.getRiskCodeBusiType(riskCode);
					prpLpropDto.setKindName(uiCodeAction.translateKindCode(
							BusinessRuleUtil.getOuterCode(httpServletRequest,
									riskCodeType), prpLpropDto.getKindCode(),
							true));
				}
			}
		}

		PrpLcarLossDto prpLcarLossDto = null;
		if (verifyLossDto.getPrpLcarLossDtoList() != null) {
			for (int i = 0; i < verifyLossDto.getPrpLcarLossDtoList().size(); i++) {
				prpLcarLossDto = (PrpLcarLossDto) verifyLossDto
						.getPrpLcarLossDtoList().get(i);
				//是否为本保单车辆转换
				if (prpLcarLossDto.getInsureCarFlag().trim().equals("1")) {
					prpLcarLossDto.setInsureCarFlagName("是");
				} else {
					prpLcarLossDto.setInsureCarFlagName("否");
				}
				//车辆种类
				prpLcarLossDto.setCarKindName(uiCodeAction.translateCodeCode(
						"CarKind", prpLcarLossDto.getCarKindCode(), true));
			}
		}

		if (verifyLossDto.getPrpLrepairFeeDtoList() != null) {
			PrpLrepairFeeDto prpLrepairFeeDto = null;
			//险别名称转换
			Iterator iterator = verifyLossDto.getPrpLrepairFeeDtoList()
					.iterator();
			while (iterator.hasNext()) {
				prpLrepairFeeDto = (PrpLrepairFeeDto) iterator.next();
				prpLrepairFeeDto.setHandlerName(uiCodeAction.translateUserCode(
						prpLrepairFeeDto.getHandlerCode(), true));
		        riskCode  = prpLrepairFeeDto.getRiskCode();
				if ("BZ".equals(prpLrepairFeeDto.getKindCode())) {
			        riskCodeType = "";
			        //取交强险uticodetransfer表类型
			        riskCodeType = transCodeCI.getRiskCodeCIType(riskCode);
					prpLrepairFeeDto.setKindName(uiCodeAction
							.translateKindCode(BusinessRuleUtil.getOuterCode(
									httpServletRequest, riskCodeType),
									prpLrepairFeeDto.getKindCode(), true));
				} else {
			        riskCodeType = "";
			        //取商业险uticodetransfer表类型
			        riskCodeType = transCodeCI.getRiskCodeBusiType(riskCode);
					prpLrepairFeeDto.setKindName(uiCodeAction
							.translateKindCode(BusinessRuleUtil.getOuterCode(
									httpServletRequest, riskCodeType),
									prpLrepairFeeDto.getKindCode(), true));
				}
				prpLrepairFeeDto.setRepairTypeName(uiCodeAction
						.translateCodeCode("RepairType", prpLrepairFeeDto
								.getRepairType(), true));

			}
		}

		if (verifyLossDto.getPrpLcomponentDtoList() != null) {
			PrpLcomponentDto prpLcomponentDto = null;
			//险别名称转换
			Iterator iterator1 = verifyLossDto.getPrpLcomponentDtoList()
					.iterator();
			while (iterator1.hasNext()) {
				prpLcomponentDto = (PrpLcomponentDto) iterator1.next();
				prpLcomponentDto.setHandlerName(uiCodeAction.translateUserCode(
						prpLcomponentDto.getHandlerCode(), true));
		        riskCode  = prpLcomponentDto.getRiskCode();
				if ("BZ".equals(prpLcomponentDto.getKindCode())) {
			        riskCodeType = "";
			        //取交强险uticodetransfer表类型
			        riskCodeType = transCodeCI.getRiskCodeCIType(riskCode);
					prpLcomponentDto.setKindName(uiCodeAction
							.translateKindCode(BusinessRuleUtil.getOuterCode(
									httpServletRequest, riskCodeType),
									prpLcomponentDto.getKindCode(), true));
				} else {
			        riskCodeType = "";
			        //取商业险uticodetransfer表类型
			        riskCodeType = transCodeCI.getRiskCodeBusiType(riskCode);
					prpLcomponentDto.setKindName(uiCodeAction
							.translateKindCode(BusinessRuleUtil.getOuterCode(
									httpServletRequest, riskCodeType),
									prpLcomponentDto.getKindCode(), true));
				}
			}
		}
		if (verifyLossDto.getPrpLpersonDtoList() != null) {
			PrpLpersonDto prpLpersonDto = null;
			//险别名称转换
			Iterator iterator2 = verifyLossDto.getPrpLpersonDtoList()
					.iterator();
			while (iterator2.hasNext()) {
				prpLpersonDto = (PrpLpersonDto) iterator2.next();
		        riskCode  = prpLpersonDto.getRiskCode();
				if ("BZ".equals(prpLpersonDto.getKindCode())) {
			        riskCodeType = "";
			        //取交强险uticodetransfer表类型
			        riskCodeType = transCodeCI.getRiskCodeCIType(riskCode);
					prpLpersonDto.setKindName(uiCodeAction.translateKindCode(
							BusinessRuleUtil.getOuterCode(httpServletRequest,
									riskCodeType), prpLpersonDto
									.getKindCode(), true));
				} else {
			        riskCodeType = "";
			        //取商业险uticodetransfer表类型
			        riskCodeType = transCodeCI.getRiskCodeBusiType(riskCode);
					prpLpersonDto.setKindName(uiCodeAction.translateKindCode(
							BusinessRuleUtil.getOuterCode(httpServletRequest,
									riskCodeType), prpLpersonDto
									.getKindCode(), true));
				}
				prpLpersonDto.setAreaName(uiCodeAction.translateCodeCode(
						"DamageDistrict", prpLpersonDto.getAreaCode(), true));
				if (prpLpersonDto.getFixedIncomeFlagName().trim().equals("1")) {
					prpLpersonDto.setFixedIncomeFlagName("有固定收入");
				} else if (prpLpersonDto.getFixedIncomeFlagName().trim()
						.equals("2")) {
					prpLpersonDto.setFixedIncomeFlagName("无固定收入");
				} else if (prpLpersonDto.getFixedIncomeFlagName().trim()
						.equals("3")) {
					prpLpersonDto.setFixedIncomeFlagName("无收入");
				} else if (prpLpersonDto.getFixedIncomeFlagName().trim()
						.equals("4")) {
					prpLpersonDto.setFixedIncomeFlagName("无劳动能力");
				} else {
					prpLpersonDto.setFixedIncomeFlagName("其它");
				}
				if (prpLpersonDto.getPayPersonType().trim().equals("1")) {
					prpLpersonDto.setPayPersonTypeName("伤");
				} else if (prpLpersonDto.getPayPersonType().trim().equals("2")) {
					prpLpersonDto.setPayPersonTypeName("被扶养人");
				} else if (prpLpersonDto.getPayPersonType().trim().equals("3")) {
					prpLpersonDto.setPayPersonTypeName("护理人");
				} else if (prpLpersonDto.getPayPersonType().trim().equals("4")) {
					prpLpersonDto.setPayPersonTypeName("残");
				} else if (prpLpersonDto.getPayPersonType().trim().equals("5")) {
					prpLpersonDto.setPayPersonTypeName("亡");
				} else if (prpLpersonDto.getPayPersonType().trim().equals("6")) {
					prpLpersonDto.setPayPersonTypeName("参加事故处理人员");
				} else {
					prpLpersonDto.setPayPersonTypeName("其它");
				}
			}
		}
	}

	/**
	 * 取初始化信息需要的数据的整理.
	 * 填写定损单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参，
	 * 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。
	 * 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public VerifyLossDto iniViewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		VerifyLossDto verifyLossDto = new VerifyLossDto();
		return verifyLossDto;
	}

	/**
	 * 填写定损页面及查询定损request的生成.
	 * @param httpServletRequest 返回给页面的request
	 * @param verifyLossDto 取出的初始化信息Dto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest,
			VerifyLossDto verifyLossDto) throws Exception {
	}

	/**
	 * 根据verifyLossDto中的各子表内的信息填充界面
	 * @param httpServletRequest 返回给页面的request
	 * @param verifyLossDto    定损的数据类
	 * @throws Exception
	 */
	private void setSubInfo(HttpServletRequest httpServletRequest,
			VerifyLossDto verifyLossDto) throws Exception {
		//Reason:得到修理类型列表
		String strRiskCode = BusinessRuleUtil.getRiskCode(verifyLossDto
				.getPrpLverifyLossDto().getRegistNo(), "RegistNo");
		UICodeAction uiCodeAction = new UICodeAction();
		Collection repairTypes = uiCodeAction.getCodeType("RepairType",
				strRiskCode);
		httpServletRequest.setAttribute("repairTypes", repairTypes);
		String nodeType = (String) httpServletRequest.getParameter("nodeType");
		httpServletRequest.setAttribute("partCodeList", ICollections
				.getPartCodeList());

		//给定核损信息补充说明多行列表准备数据
		Collection arrayListVerifyLossExt = new ArrayList();
		PrpLverifyLossExtDto prpLverifyLossExtDto = new PrpLverifyLossExtDto();
		PrpLverifyLossExtDto prpLverifyLossExtDtoAdd = new PrpLverifyLossExtDto();
		if (nodeType.equals("verip")) {
			prpLverifyLossExtDtoAdd.setTitle("同意报价");
		}
		if (nodeType.equals("verif")) {
			prpLverifyLossExtDtoAdd.setTitle("同意定损");
		}

		if (nodeType.equals("backc")) {
			prpLverifyLossExtDtoAdd.setTitle("通过复勘");
		}
		prpLverifyLossExtDtoAdd.setRegistNo(verifyLossDto
				.getPrpLverifyLossDto().getRegistNo());
		prpLverifyLossExtDtoAdd.setRiskCode(verifyLossDto
				.getPrpLverifyLossDto().getRiskCode());
		prpLverifyLossExtDtoAdd.setInputDate(new DateTime(DateTime.current()
				.toString(), DateTime.YEAR_TO_DAY));
		prpLverifyLossExtDtoAdd.setInputHour(new DateTime(DateTime.current()
				.toString(), DateTime.YEAR_TO_SECOND).getHour()
				+ "时"
				+ new DateTime(DateTime.current().toString(),
						DateTime.YEAR_TO_SECOND).getMinute() + "分");
		prpLverifyLossExtDto.setRegistNo(verifyLossDto.getPrpLverifyLossDto()
				.getRegistNo());
		prpLverifyLossExtDto.setRiskCode(verifyLossDto.getPrpLverifyLossDto()
				.getRiskCode());
		arrayListVerifyLossExt = verifyLossDto.getPrpLverifyLossExtDtoList();
		if (arrayListVerifyLossExt == null) {
			arrayListVerifyLossExt = new ArrayList();
		}
		prpLverifyLossExtDtoAdd.setSerialNo(arrayListVerifyLossExt.size() + 1);
		String status = httpServletRequest.getParameter("status");
		if ("0".equals(status)) {
			arrayListVerifyLossExt.add(prpLverifyLossExtDtoAdd);
		}
		prpLverifyLossExtDto.setVerifyLossExtList(arrayListVerifyLossExt);
		httpServletRequest.setAttribute("prpLverifyLossExtDto",
				prpLverifyLossExtDto);

		//给报案信息补充说明多行列表准备数据
		Collection arrayListRegistExt = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = new PrpLregistExtDto();
		prpLregistExtDto.setRegistNo(verifyLossDto.getPrpLverifyLossDto()
				.getRegistNo());
		prpLregistExtDto.setRiskCode(verifyLossDto.getPrpLverifyLossDto()
				.getRiskCode());
		arrayListRegistExt = verifyLossDto.getPrpLregistExtDtoList();
		prpLregistExtDto.setRegistExtList(arrayListRegistExt);
		httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);

		//财产核定损明细清单多行列表准备数据
		ArrayList arrayList4 = new ArrayList();
		PrpLpropDto prpLpropDto = new PrpLpropDto();
		arrayList4 = verifyLossDto.getPrpLpropDtoList();
		//add by kangzhen
		//modify by miaowenjun 20070202
		UIPolicyAction uiPolicyAction = new UIPolicyAction();
		PolicyDto policyDto = new PolicyDto();
		PrpCitemKindDto prpCitemKindDto =new PrpCitemKindDto(); 
		if (arrayList4 != null) {
	        for (int i = 0; i < arrayList4.size(); i++) {
	          PrpLpropDto prpLpropDto1 = (PrpLpropDto) arrayList4.get(i);
	          prpCitemKindDto = uiPolicyAction.findPrpCitemKindDtoByConditions(prpLpropDto1.getPolicyNo(), prpLpropDto1.getKindCode());
	          
	          prpLpropDto1.setKindName(prpCitemKindDto.getKindName());
	        }
	    }
		prpLpropDto.setPropList(arrayList4);
		httpServletRequest.setAttribute("prpLpropDto", prpLpropDto);
		}

	/**
	 * 检查是否已出赔案计算书
	 * 返回值   true 已出        false 未出
	 * @param httpServletRequest 返回给页面的request
	 * @param claimNo 赔案号
	 * @throws Exception
	 */
	public boolean checkCompensate(HttpServletRequest httpServletRequest,
			String registNo) throws Exception {
		//根据报案号码取得对应的赔案号码
		UICodeAction uiCodeAction = new UICodeAction();
		String claimNo = uiCodeAction.translateBusinessCode(registNo, true);
		//取得赔款计算书信息
		UICompensateAction uICompensateAction = new UICompensateAction();
		String conditions = "claimNo ='" + claimNo.trim() + "'";
		ArrayList arraylist = (ArrayList) uICompensateAction
				.findByConditions(conditions);
		if (arraylist == null || arraylist.size() < 1) {
			return false;
		} else {
			return true;
		}
	}


	/**
	 * 查询工作流可以用来选择的节点内容
	 * @param modelNo String
	 * @param nodeNo String
	 * @throws Exception
	 */
	private void getSubmitNodes(HttpServletRequest httpServletRequest)
			throws Exception {
		String modelNo = httpServletRequest.getParameter("modelNo"); //模板号
		String nodeNo = httpServletRequest.getParameter("nodeNo"); //节点号
		int nextNodeNo = 0;
		Collection pathList = new ArrayList();
		SwfPathDto swfPathDto = new SwfPathDto();
		WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
		if (modelNo != null && nodeNo != null) {
			pathList = workFlowViewHelper.getNextSumbitNodes(modelNo, nodeNo);
			if (pathList.iterator().hasNext()) {
				SwfPathDto swfPathDtoTemp = new SwfPathDto();
				swfPathDtoTemp = (SwfPathDto) pathList.iterator().next();
				nextNodeNo = swfPathDtoTemp.getEndNodeNo();
				swfPathDto.setNextNodeNo(nextNodeNo);
			}
		}
		swfPathDto.setPathList(pathList);
		httpServletRequest.setAttribute("pathList", pathList);
		httpServletRequest.setAttribute("swfPathDto", swfPathDto);
	}
}
