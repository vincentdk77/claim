package com.gyic.claim.ui.control.viewHelper;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;

import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.gyic.claim.utils.Utils;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindAgriFacade;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.dto.custom.CaseRelateNodeDto;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLpersonDto;
import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossExtDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossItemDto;
import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.claim.ui.control.action.ICollections;
import com.sinosoft.claim.ui.control.action.UICertainLossAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIConfigAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPrpLcheckAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.CertainLossViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAAClaimViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAARegistViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.prpall.pubfun.GroupProposalService;
import com.sinosoft.prpall.schema.PrpCvirturlItemSchema;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.utility.SysConfig;

/**
 * <p>Title: CertainLossViewHelper</p>
 * <p>Description:定损ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 liubvo
 * @version 1.0
 * <br>
 */

public class AgriCombineCertainLossViewHelper extends CertainLossViewHelper{
	
	/**
	 * 保存定损时定损页面数据整理.
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
	 * @param httpServletRequest
	 * @return certainLossDto 定损数据传输数据结构
	 * @throws Exception
	 */
	/**
     * 并案保存定损时定损页面数据整理.
     * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
     * @param httpServletRequest
     * @param combineIndex
     * @return certainLossDto
     * @throws Exception
     */
    public CertainLossDto combineViewToDto(HttpServletRequest httpServletRequest,int combineIndex) throws Exception
    {
      double underWritePreDef = Double.parseDouble(DataUtils.nullToZero(AppConfig.get("sysconst.UnderWritePreDef")));
      double sumPreDefLoss    = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossSumPreDefLoss_"+combineIndex)));
      UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
      String    userCode = user.getUserCode() ;
      String    userName = user.getUserName() ;

      CertainLossDto certainLossDto = new CertainLossDto();
      /*---------------------定损主表 PrpLverifyLoss------------------------------------*/
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

      prpLverifyLossDto.setLossItemCode         (httpServletRequest.getParameter("prpLverifyLossLossItemCode_"+combineIndex));
      prpLverifyLossDto.setLossItemName         (httpServletRequest.getParameter("prpLverifyLossLossItemName_"+combineIndex));
      prpLverifyLossDto.setInsureCarFlag        (httpServletRequest.getParameter("prpLverifyLossLossInsureCarFlag_"+combineIndex));

      prpLverifyLossDto.setDefLossDate         (new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      prpLverifyLossDto.setDefLossDate         (new DateTime(httpServletRequest.getParameter("prpLverifyLossDefLossDate_"+combineIndex),DateTime.YEAR_TO_DAY ));
      prpLverifyLossDto.setUnderWriteCode      (httpServletRequest.getParameter("prpLverifyLossUnderWriteCode_"+combineIndex));
      prpLverifyLossDto.setUnderWriteName      (httpServletRequest.getParameter("prpLverifyLossUnderWriteName_"+combineIndex));
      prpLverifyLossDto.setUnderWriteEndDate   (new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      //prpLverifyLossDto.setUnderWriteEndDate   (httpServletRequest.getParameter("prpLverifyLossUnderWriteEndDate_"+combineIndex));
      prpLverifyLossDto.setUnderWriteFlag      (httpServletRequest.getParameter("prpLverifyLossUnderWriteFlag_"+combineIndex));
      prpLverifyLossDto.setRemark              (httpServletRequest.getParameter("prpLverifyLossRemark_"+combineIndex));
      prpLverifyLossDto.setVerifyRemark        (httpServletRequest.getParameter("prpLverifyLossVerifyRemark_"+combineIndex));
      prpLverifyLossDto.setVeriwReturnReason   (httpServletRequest.getParameter("prpLverifyLossVeriwReturnReason_"+combineIndex));
      prpLverifyLossDto.setFlag                (httpServletRequest.getParameter("prpLverifyLossFlag_"+combineIndex));
      //add by lixiang start at 2006-04-21
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
 
      //定损偏差率
      double prpLverifyLossFirstDefLoss    = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossFirstDefLoss_"+combineIndex)));      
      double prpLverifyLossWarpDefLoss    = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLverifyLossWarpDefLoss_"+combineIndex)));
      if(prpLverifyLossFirstDefLoss<=0){
      	prpLverifyLossFirstDefLoss=prpLverifyLossWarpDefLoss;
      }   
      prpLverifyLossDto.setFirstDefLoss(prpLverifyLossFirstDefLoss);
      prpLverifyLossDto.setWarpDefLoss(prpLverifyLossFirstDefLoss);
      certainLossDto.setPrpLverifyLossDto(prpLverifyLossDto);
      //每次改动的时候，把改动人，改动时间，改动的金额，写到swfnotion表里
    	ArrayList notionList = new ArrayList();

        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction ();
      int maxLineNo=uiWorkFlowAction.getSwfNotionMaxLineNo(httpServletRequest.getParameter("swfLogFlowID_"+combineIndex),Integer.parseInt(DataUtils.nullToZero(httpServletRequest.getParameter("swfLogLogNo_"+combineIndex)) ));    	
      if(prpLverifyLossFirstDefLoss!=prpLverifyLossWarpDefLoss){
      	SwfNotionDto swfNotionDto = new SwfNotionDto();
      	swfNotionDto.setFlowID(httpServletRequest.getParameter("swfLogFlowID_"+combineIndex));
      	swfNotionDto.setLogNo(Integer.parseInt(DataUtils.nullToZero(httpServletRequest.getParameter("swfLogLogNo_"+combineIndex)) ));
      	swfNotionDto.setLineNo(maxLineNo); 
      	swfNotionDto.setHandleText(user.getUserName()+"在"+new DateTime(new Date(),DateTime.YEAR_TO_DAY)+"修改了定损金额:"+prpLverifyLossWarpDefLoss+"元_"+combineIndex);
      	notionList.add(swfNotionDto);
      } 
      certainLossDto.setSwfNotionList(notionList);
      //如果定损金额为某一值时，算核损通过 
        //System.out.println("++++++++++++++++++++underWritePreDef="+underWritePreDef + "|++++++++++++++sumPreDefLoss="+sumPreDefLoss);
        if(underWritePreDef>=sumPreDefLoss)
        {
          prpLverifyLossDto.setUnderWriteCode      (userCode);
          prpLverifyLossDto.setUnderWriteName(userName);
          prpLverifyLossDto.setUnderWriteEndDate(new DateTime(DateTime.current().
              toString(), DateTime.YEAR_TO_DAY));
          //prpLverifyLossDto.setUnderWriteEndDate   (httpServletRequest.getParameter("prpLverifyLossUnderWriteEndDate_"+index));
          prpLverifyLossDto.setUnderWriteFlag("1");
        }  

      /*---------------------状态内容prpLclaimStatus------------------------------------*/
      String statusTemp = httpServletRequest.getParameter("buttonSaveType");
      PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
      prpLclaimStatusDto.setBusinessNo(httpServletRequest.getParameter("prpLverifyLossRegistNo_"+combineIndex));
      prpLclaimStatusDto.setPolicyNo(httpServletRequest.getParameter("prpLverifyLossPolicyNo_"+combineIndex));
      prpLclaimStatusDto.setRiskCode(httpServletRequest.getParameter("prpLverifyLossRiskCode_"+combineIndex));
      prpLclaimStatusDto.setNodeType("certa");
      prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
      /*
      if(statusTemp.trim().equals("4")){
        prpLclaimStatusDto.setNodeType("verif");
        prpLclaimStatusDto.setStatus("1");
      }else{
        prpLclaimStatusDto.setNodeType("certa");
        prpLclaimStatusDto.setStatus(statusTemp);
      }
*/
      prpLclaimStatusDto.setTypeFlag(prpLverifyLossDto.getLossItemCode());
      prpLclaimStatusDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLverifyLossDto.getLossItemCode())));
      //取得当前用户信息，写操作员信息到定损中
      prpLclaimStatusDto.setHandlerCode(user.getUserCode());
      prpLclaimStatusDto.setInputDate(new DateTime(new Date(),DateTime.YEAR_TO_DAY));
      prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
      certainLossDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
      return certainLossDto;
    }
    
	public CertainLossDto viewToDto(HttpServletRequest httpServletRequest,int combineIndex) throws Exception
	{
		//继承对certainLoss,certainLossText表的赋值
		CertainLossDto certainLossDto = this.combineViewToDto(httpServletRequest, combineIndex);
		
		//add by lixiang start 20051228
		//reason: 因为考虑到录入的时候，可能没有立案，但是在提交的时候，做了立案，导致立案号没写入。
		//先取立案号码，很重要，不要从页面上取得。。。
		String claimNo=httpServletRequest.getParameter("prpLverifyLossClaimNo_"+combineIndex);
		String registNo  = httpServletRequest.getParameter("prpLverifyLossRegistNo_"+combineIndex);
		if (claimNo==null||claimNo.length()<2){
			UICodeAction uiCodeAction = new UICodeAction();
			claimNo=uiCodeAction.translateBusinessCode(registNo,true);
		}
		//add by lixiang end 20051228
		
		/*---------------------财产核定损明细清单表 prpLprop ------------------------------------*/
		ArrayList prpLpropDtoList = new ArrayList();
		PrpLpropDto prpLpropDto = null;
		
		//定核损处理标的表
		PrpLverifyLossItemDto LossItemPropDto = new PrpLverifyLossItemDto();
		ArrayList lossItemListTemp = new ArrayList();
		//从界面得到输入数组
		String   prpLpropPolicyNo  = httpServletRequest.getParameter("prpLverifyLossPolicyNo_"+combineIndex);
		String   prpLpropRiskCode  = httpServletRequest.getParameter("prpLverifyLossRiskCode_"+combineIndex);
		String   prpLpropClaimNo  = httpServletRequest.getParameter("prpLverifyLossClaimNo_"+combineIndex);
		String   prpLpropRegistNo  = httpServletRequest.getParameter("prpLverifyLossRegistNo_"+combineIndex);
		
		String[]   prpLpropSerialNo                  =httpServletRequest.getParameterValues("prpLpropSerialNo_"+combineIndex);
		String[]   prpLpropItemKindNo                =httpServletRequest.getParameterValues("prpLpropItemKindNo_"+combineIndex);
		String[]   prpLpropFamilyNo                  =httpServletRequest.getParameterValues("prpLpropFamilyNo_"+combineIndex);
		String[]   prpLpropFamilyName                =httpServletRequest.getParameterValues("prpLpropFamilyName_"+combineIndex);
		String[]   prpLpropKindCode                  =httpServletRequest.getParameterValues("prpLpropKindCode_"+combineIndex);
		String[]   prpLpropItemCode                  =httpServletRequest.getParameterValues("prpLpropItemCode_"+combineIndex);
		String[]   prpLpropLossItemCode              =httpServletRequest.getParameterValues("prpLpropLossItemCode_"+combineIndex);
		String[]   prpLpropLossItemName              =httpServletRequest.getParameterValues("prpLpropLossItemName_"+combineIndex);
		String[]   prpLpropFeeTypeCode               =httpServletRequest.getParameterValues("prpLpropFeeTypeCode_"+combineIndex);
		String[]   feeTypeCode                       =httpServletRequest.getParameterValues("feeTypeCode_"+combineIndex);
		String[]   prpLpropFeeTypeName               =httpServletRequest.getParameterValues("prpLpropFeeTypeName_"+combineIndex);
		String[]   prpLpropCurrency                  =httpServletRequest.getParameterValues("prpLpropCurrency_"+combineIndex);
		String[]   prpLpropUnitPrice                 =httpServletRequest.getParameterValues("prpLpropUnitPrice_"+combineIndex);
		String[]   prpLpropLossQuantity              =httpServletRequest.getParameterValues("prpLpropLossQuantity_"+combineIndex);
		String[]   prpLpropUnit                      =httpServletRequest.getParameterValues("prpLpropUnit_"+combineIndex);
		String[]   prpLpropBuyDate                   =httpServletRequest.getParameterValues("prpLpropBuyDate_"+combineIndex);
		String[]   prpLpropDepreRate                 =httpServletRequest.getParameterValues("prpLpropDepreRate_"+combineIndex);
		String[]   prpLpropSumLoss                   =httpServletRequest.getParameterValues("prpLpropSumLoss_"+combineIndex);
		String[]   prpLpropSumReject                 =httpServletRequest.getParameterValues("prpLpropSumReject_"+combineIndex);
		String[]   prpLpropRejectReason              =httpServletRequest.getParameterValues("prpLpropRejectReason_"+combineIndex);
		String[]   prpLpropLossRate                  =httpServletRequest.getParameterValues("prpLpropLossRate_"+combineIndex);
		String[]   prpLpropSumDefLoss                =httpServletRequest.getParameterValues("prpLpropSumDefLoss_"+combineIndex);
		String[]   prpLpropRemark                    =httpServletRequest.getParameterValues("prpLpropRemark_"+combineIndex);
		String[]   prpLpropVeriUnitPrice             =httpServletRequest.getParameterValues("prpLpropVeriUnitPrice_"+combineIndex);
		String[]   prpLpropVeriLossQuantity          =httpServletRequest.getParameterValues("prpLpropVeriLossQuantity_"+combineIndex);
		String[]   prpLpropVeriUnit                  =httpServletRequest.getParameterValues("prpLpropVeriUnit_"+combineIndex);
		String[]   prpLpropVeriDepreRate             =httpServletRequest.getParameterValues("prpLpropVeriDepreRate_"+combineIndex);
		String[]   prpLpropVeriSumLoss               =httpServletRequest.getParameterValues("prpLpropVeriSumLoss_"+combineIndex);
		String[]   prpLpropVeriSumReject             =httpServletRequest.getParameterValues("prpLpropVeriSumReject_"+combineIndex);
		String[]   prpLpropVeriRejectReason          =httpServletRequest.getParameterValues("prpLpropVeriRejectReason_"+combineIndex);
		String[]   prpLpropVeriLossRate              =httpServletRequest.getParameterValues("prpLpropVeriLossRate_"+combineIndex);
		String[]   prpLpropVeriSumDefLoss            =httpServletRequest.getParameterValues("prpLpropVeriSumDefLoss_"+combineIndex);
		String[]   prpLpropVeriRemark                =httpServletRequest.getParameterValues("prpLpropVeriRemark_"+combineIndex);
		String[]   prpLpropFlag                      =httpServletRequest.getParameterValues("prpLpropFlag_"+combineIndex);
		String[]   prpLpropKindName                  =httpServletRequest.getParameterValues("prpLpropKindName_"+combineIndex);
		
//		add by lixiang start at 2006-04-21
	    //reason: 增加保存理算退回的定损的标志的保存,若有数据不会被保存冲掉
	  String[]   prpLpropCompensateBackFlag  = httpServletRequest.getParameterValues("prpLpropCompensateBackFlag_"+combineIndex);
	  UICodeAction uiCodeAction = new UICodeAction();
	  String strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLpropRiskCode);
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
				
				if(prpLpropFamilyName == null || "".equals(prpLpropFamilyName[index]))
				{
					PrpCvirturlItemSchema prpCvirturlItemSchema = Utils.findPrpCvirturlItemSchema(prpLpropPolicyNo,prpLpropRiskCode);
					prpLpropDto.setFamilyNo(Integer.parseInt(DataUtils
							.nullToZero(prpCvirturlItemSchema.getFamilyNo())));
					prpLpropDto.setFamilyName(prpCvirturlItemSchema.getFamilyName());
				}
				else
				{
					prpLpropDto.setFamilyNo(Integer.parseInt(DataUtils
							.nullToZero(prpLpropFamilyNo[index])));
					prpLpropDto.setFamilyName(prpLpropFamilyName[index]);
				}
				
				if("".equals(prpLpropKindName[index]))
				{
					PrpCvirturlItemSchema prpCvirturlItemSchema1 = Utils.findPrpCvirturlItemSchema(prpLpropPolicyNo,prpLpropRiskCode,String.valueOf(prpLpropDto.getFamilyNo()),
							httpServletRequest.getParameter("prpLregistDamageStartDate1_"+combineIndex));
					prpLpropDto.setKindName(prpCvirturlItemSchema1.getKindName());
					prpLpropDto.setKindCode(prpCvirturlItemSchema1.getKindCode());
					prpLpropDto.setLossItemName             ( prpCvirturlItemSchema1.getItemDetailName());
					prpLpropDto.setItemKindNo(Integer.parseInt(DataUtils
							.nullToZero(prpCvirturlItemSchema1.getItemKindNo())));
					prpLpropDto.setItemCode(prpCvirturlItemSchema1.getItemCode());
				}
				else
				{
					prpLpropDto.setKindName(prpLpropKindName[index]);
					prpLpropDto.setKindCode                 ( prpLpropKindCode     [index]);
					prpLpropDto.setLossItemName             ( prpLpropLossItemName [index]);
					prpLpropDto.setItemKindNo               ( Integer.parseInt(DataUtils.nullToZero(prpLpropItemKindNo   [index])));
					prpLpropDto.setItemCode                 ( prpLpropItemCode     [index]);
				}

				prpLpropDto.setSerialNo                 ( index);
				//prpLpropDto.setSerialNo                 ( Integer.parseInt(DataUtils.nullToZero(prpLpropSerialNo     [index])));

				
				if("I".equals(strRiskType)||"H".equals(strRiskType)){
  				    prpLpropDto.setLossItemCode             ("-2");
				}else{
			        prpLpropDto.setLossItemCode             ( prpLpropLossItemCode [index]);
				}
				
				if("I".equals(strRiskType)||"H".equals(strRiskType)){
					prpLpropDto.setFeeTypeCode              ("");
					prpLpropDto.setFeeTypeName              ("");
				}else{
				    prpLpropDto.setFeeTypeCode              ( feeTypeCode [index]);
				    prpLpropDto.setFeeTypeName              (prpLpropFeeTypeName [index]);
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
		        if(prpLpropCompensateBackFlag!=null){
		        	prpLpropDto.setCompensateBackFlag       ( prpLpropCompensateBackFlag [index]);
		        }
		        httpServletRequest.setAttribute("prpLpropDto_"+combineIndex,prpLpropDto);
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
		/*---------------------报案信息补充说明 PrpLregistExt ------------------------------------*/
		ArrayList prpLregistExtDtoList = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = null ;
		//从界面得到输入数组
		
		String prpLregistExtRegistNo = (String)httpServletRequest.getParameter("prpLregistExtRegistNo_"+combineIndex); 
		String prpLregistExtRiskCode = httpServletRequest.getParameter      ("prpLregistExtRiskCode_"+combineIndex);
		String[] prpLregistExtSerialNo = httpServletRequest.getParameterValues("prpLregistExtSerialNo_"+combineIndex);
		String[] prpLregistExtInputDate = httpServletRequest.getParameterValues("prpLregistExtInputDate_"+combineIndex);
		String[] prpLregistExtInputHour = httpServletRequest.getParameterValues("prpLregistExtInputHour_"+combineIndex);
		String[] prpLregistExtOperatorCode = httpServletRequest.getParameterValues("prpLregistExtOperatorCode_"+combineIndex);
		String[] prpLregistExtContext = httpServletRequest.getParameterValues("prpLregistExtContext_"+combineIndex);
		
		//对象赋值
		//人员伤亡跟踪 部分开始
		if (prpLregistExtSerialNo==null)
		{}
		else
		{
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
		/*---------------------耳标号清单表 prplCompensateEar ------------------------------------*/
		
			ArrayList prplCompensateEarDtoList = new ArrayList();
			PrplcompensateearDto prplCompensateEarDto = null;
			
	  
			//从界面得到输入数组
			String   prplCheckPolicyNoShow  = httpServletRequest.getParameter("prplCheckPolicyNoShow_"+combineIndex);
			String   prplCheckRegistNoShow  = httpServletRequest.getParameter("prplCheckRegistNoShow_"+combineIndex);

			//start养殖险清单列表字段定义add by 张菊卿
			String[] prplCompensateEarAccount=httpServletRequest.getParameterValues("prplCompensateEarAccount_"+combineIndex);
			String[] prplCompensateEarBank=httpServletRequest.getParameterValues("prplCompensateEarBank_"+combineIndex);
			String[] prplCompensateEarBreedingAreaCode=httpServletRequest.getParameterValues("prplCompensateEarBreedingAreaCode_"+combineIndex);
			String[] prplCompensateEarBreedingAreaName=httpServletRequest.getParameterValues("prplCompensateEarBreedingAreaName_"+combineIndex);
			String[] prplCompensateEarCaseNo=httpServletRequest.getParameterValues("prplCompensateEarCaseNo_"+combineIndex);
			String[] prplCompensateEarClaimNo=httpServletRequest.getParameterValues("prplCompensateEarClaimNo_"+combineIndex);
			String[] prplCompensateEarClaimRate=httpServletRequest.getParameterValues("prplCompensateEarClaimRate_"+combineIndex);
			String[] prplCompensateEarCombineNo=httpServletRequest.getParameterValues("prplCompensateEarCombineNo_"+combineIndex);
			String[] prplCompensateEarCompensateNo=httpServletRequest.getParameterValues("prplCompensateEarCompensateNo_"+combineIndex);
			String[] prplCompensateEarCullNumber=httpServletRequest.getParameterValues("prplCompensateEarCullNumber_"+combineIndex);
			String[] prplCompensateEarDamageCode=httpServletRequest.getParameterValues("prplCompensateEarDamageCode_"+combineIndex);
			String[] prplCompensateEarDamageEndDate=httpServletRequest.getParameterValues("prplCompensateEarDamageEndDate_"+combineIndex);
			String[] prplCompensateEarDamageName=httpServletRequest.getParameterValues("prplCompensateEarDamageName_"+combineIndex);
			String[] prplCompensateEarDamageStartDate=httpServletRequest.getParameterValues("prplCompensateEarDamageStartDate_"+combineIndex);
			String[] prplCompensateEarDamageStartHour=httpServletRequest.getParameterValues("prplCompensateEarDamageStartHour_"+combineIndex);
			String[] prplCompensateEarDeadNumber=httpServletRequest.getParameterValues("prplCompensateEarDeadNumber_"+combineIndex);
			String[] prplCompensateEarDeadReason=httpServletRequest.getParameterValues("prplCompensateEarDeadReason_"+combineIndex);
			String[] prplCompensateEarDeductible=httpServletRequest.getParameterValues("prplCompensateEarDeductible_"+combineIndex);
			String[] prplCompensateEarDeductibleRate=httpServletRequest.getParameterValues("prplCompensateEarDeductibleRate_"+combineIndex);
			String[] prplCompensateEarEarNo=httpServletRequest.getParameterValues("prplCompensateEarEarNo_"+combineIndex);
			String[] prplCompensateEarEstimateLoss=httpServletRequest.getParameterValues("prplCompensateEarEstimateLoss_"+combineIndex);
			String[] prplCompensateEarFCode=httpServletRequest.getParameterValues("prplCompensateEarFCode_"+combineIndex);
			String[] prplCompensateEarId_Card=httpServletRequest.getParameterValues("prplCompensateEarId_Card_"+combineIndex);
			String[] prplCompensateEarInusreListCode=httpServletRequest.getParameterValues("prplCompensateEarInusreListCode_"+combineIndex);
			String[] prplCompensateEarKindCode=httpServletRequest.getParameterValues("prplCompensateEarKindCode_"+combineIndex);
			String[] prplCompensateEarName=httpServletRequest.getParameterValues("prplCompensateEarName_"+combineIndex);
			String[] prplCompensateEarNodeNo=httpServletRequest.getParameterValues("prplCompensateEarNodeNo_"+combineIndex);
			String[] prplCompensateEarNodeType=httpServletRequest.getParameterValues("prplCompensateEarNodeType_"+combineIndex);
			String[] prplCompensateEarPolicyNo=httpServletRequest.getParameterValues("prplCompensateEarPolicyNo_"+combineIndex);
			String[] prplCompensateEarRegistNo=httpServletRequest.getParameterValues("prplCompensateEarRegistNo_"+combineIndex);
			String[] prplCompensateEarReportTime=httpServletRequest.getParameterValues("prplCompensateEarReportTime_"+combineIndex);
			String[] prplCompensateEarRestFee=httpServletRequest.getParameterValues("prplCompensateEarRestFee_"+combineIndex);
			String[] prplCompensateEarSumRealpay=httpServletRequest.getParameterValues("prplCompensateEarSumRealpay_"+combineIndex);
			String[] prplCompensateEarUnitAmount=httpServletRequest.getParameterValues("prplCompensateEarUnitAmount_"+combineIndex);
			
			//end养殖险耳标清单列表字段定义
			if(prplCheckRegistNoShow==null){
				
			}else{
			   if (prplCompensateEarEarNo == null){
			     }else{
				for(int index = 1;index < prplCompensateEarEarNo.length;index++)
				{
					prplCompensateEarDto = new PrplcompensateearDto();
							
					prplCompensateEarDto.setAccount(prplCompensateEarAccount[index]);
					prplCompensateEarDto.setBank(prplCompensateEarBank[index]);
					prplCompensateEarDto.setBreedingareacode(prplCompensateEarBreedingAreaCode[index]);
					prplCompensateEarDto.setBreedingareaname(prplCompensateEarBreedingAreaName[index]);
					prplCompensateEarDto.setCaseno(prplCompensateEarCaseNo[index]);
					prplCompensateEarDto.setClaimno(prplCompensateEarClaimNo[index]);
					prplCompensateEarDto.setClaimrate(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarClaimRate[index])));
					prplCompensateEarDto.setCombineno(httpServletRequest.getParameter("CombineNo"));
					prplCompensateEarDto.setCompensateno(prplCompensateEarCompensateNo[index]);
					prplCompensateEarDto.setCullnumber(Integer.valueOf(DataUtils.nullToZero(prplCompensateEarCullNumber[index])));
					prplCompensateEarDto.setDamagecode(prplCompensateEarDamageCode[index]);
					prplCompensateEarDto.setDamageenddate(new DateTime(prplCompensateEarDamageEndDate[index],DateTime.YEAR_TO_DAY));
					prplCompensateEarDto.setDamagename(prplCompensateEarDamageName[index]);
					prplCompensateEarDto.setDamagestartdate(new DateTime(httpServletRequest.getParameter("prpLregistDamageStartDate1_"+combineIndex),DateTime.YEAR_TO_DAY));
					prplCompensateEarDto.setDamagestarthour(prplCompensateEarDamageStartHour[index]);
					prplCompensateEarDto.setDeadnumber(Integer.valueOf(DataUtils.nullToZero(prplCompensateEarDeadNumber[index])));
					prplCompensateEarDto.setDeadreason(prplCompensateEarDeadReason[index]);
					prplCompensateEarDto.setDeductible(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarDeductible[index])));
					prplCompensateEarDto.setDeductiblerate(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarDeductibleRate[index])));
					prplCompensateEarDto.setEarno(prplCompensateEarEarNo[index]);
					prplCompensateEarDto.setEstimateloss(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarEstimateLoss[index])));
					prplCompensateEarDto.setFcode(prplCompensateEarFCode[index]);
					prplCompensateEarDto.setId_card(prplCompensateEarId_Card[index]);
					prplCompensateEarDto.setInusrelistcode(prplCompensateEarInusreListCode[index]);
					prplCompensateEarDto.setKindcode(prplCompensateEarKindCode[index]);
					prplCompensateEarDto.setName(prplCompensateEarName[index]);
					if("check".equals(prplCompensateEarNodeType[index]))
					{
						prplCompensateEarDto.setNodeno(2);
						prplCompensateEarDto.setNodetype("check");
					}
					if("certa".equals(prplCompensateEarNodeType[index]))
					{
						prplCompensateEarDto.setNodeno(3);
						prplCompensateEarDto.setNodetype("certa");
					}
					
					prplCompensateEarDto.setPolicyno(prplCheckPolicyNoShow);
					prplCompensateEarDto.setRegistno(prplCheckRegistNoShow);
					//add by xiatian,添加业务号
					prplCompensateEarDto.setBusinessno(prplCheckRegistNoShow);
					prplCompensateEarDto.setReporttime(prplCompensateEarReportTime[index]);
					prplCompensateEarDto.setRestfee(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarRestFee[index])));
					prplCompensateEarDto.setSumrealpay(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarSumRealpay[index])));
					prplCompensateEarDto.setUnitamount(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarUnitAmount[index])));
		
	    			prplCompensateEarDtoList.add(prplCompensateEarDto);
				}
			}
			}
			certainLossDto.setPrplCompensateEarDtoList(prplCompensateEarDtoList);
		
		return certainLossDto;
	}
	
	/**
	 * 生成定损信息详细画面
	 * @param httpServletRequest 返回给页面的request
	 * @param businessNo     业务号码
	 * @param editType   编辑类型
	 * @throws Exception
	 */
	public void certainLossDtoView(HttpServletRequest httpServletRequest,String registNo,String editType,int index) throws Exception
	{
		String riskCode= String.valueOf(httpServletRequest.getAttribute("riskCode_"+index));
		String lossItemCode = String.valueOf(httpServletRequest.getAttribute("lossItemCode_"+index));
		//非车险，lossItemCode默认为1,这样就可以正常进行财产险详细的删除操作了
		UICodeAction uiCodeAction1 = new UICodeAction();
		String strRiskType = uiCodeAction1.translateRiskCodetoRiskType(riskCode);
		if (("H").equals(strRiskType)&&("I").equals(strRiskType)){
		//标的序号，如果是人伤为0，否则为1，2，3，4，5等车辆序号
		     lossItemCode = "-2";
		}
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		CertainLossDto certainLossDto = uiCertainLossAction.findByPrimaryKey(registNo.trim(),lossItemCode);
		PrpLverifyLossDto prpLverifyLossDto =  certainLossDto.getPrpLverifyLossDto();
		//设置定损操作的状态为 案件修改 (正处理任务)
		if(prpLverifyLossDto==null){
			String msg="";
			msg ="未发现报案号为："+registNo.trim()+",序号"+lossItemCode+"的定损数据,可能是进行了注销拒赔申请！";
			throw new UserException(1,3,"定损查询",msg);
		}
		if (certainLossDto.getPrpLclaimStatusDto()!=null)
		{
			if (certainLossDto.getPrpLclaimStatusDto().getStatus().equals("7")) certainLossDto.getPrpLclaimStatusDto().setStatus("3");
			prpLverifyLossDto.setStatus(certainLossDto.getPrpLclaimStatusDto().getStatus());
		}
		else
		{
			//已提交，已经处理完毕的状态
			prpLverifyLossDto.setStatus("4");
		}
		String nodeStatus = String.valueOf(httpServletRequest.getAttribute("status_"+index));
		if(nodeStatus!=null){
			prpLverifyLossDto.setStatus(nodeStatus);
		}
		
		//查询相同保单号的出险次数
		DAACombineRegistViewHelper dAACombineRegistViewHelper = new DAACombineRegistViewHelper();
		dAACombineRegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLverifyLossDto.getPolicyNo(),prpLverifyLossDto.getRegistNo(),index);
		//设置相关代码的中文转换
		changeCodeToName(httpServletRequest,certainLossDto);
		
		if (prpLverifyLossDto.getClaimNo()==null||prpLverifyLossDto.getClaimNo().equals("")){
			DAAClaimViewHelper daaClaimViewHelper =new DAAClaimViewHelper ();
			prpLverifyLossDto.setClaimNo(daaClaimViewHelper.getLossClaimNo(registNo));
		}

		httpServletRequest.setAttribute("prpLverifyLossDto_"+index, prpLverifyLossDto);
		httpServletRequest.setAttribute("certainLossDto_"+index, certainLossDto);
		httpServletRequest.setAttribute("verifyPriceOpinionList_"+index, ICollections.getVerifyPriceOpinionList());
		httpServletRequest.setAttribute("verifyOpinionList_"+index, ICollections.getVerifyOpinionList()); // 增加核损意见
		//start设置耳标号清单列表 add by 张菊卿
		String taskCode = SysConfig.getProperty("FamilySplittingFlag","claim");
		if (prpLverifyLossDto.getRiskCode() != null && taskCode.indexOf(prpLverifyLossDto.getRiskCode()) > -1) {
			ArrayList prplCompensateEarDtoList = new ArrayList();//耳标清单列表
			if (registNo != null)
			{		
				BLPrplcompensateearFacade bLPrplcompensateearFacade = new BLPrplcompensateearFacade();

				prplCompensateEarDtoList = (ArrayList)bLPrplcompensateearFacade.getPrpLCompensateEarDtos(registNo, "certa",registNo);
			}

			httpServletRequest.setAttribute("prplCompensateEarDtoList_"+index, prplCompensateEarDtoList);
			httpServletRequest.setAttribute("familySplittingFlag_"+index, "true");//设置耳标号清单列表
		}
		
		//end设置耳标号清单列表 add by 张菊卿
		//取得相关主表的信息
		getRegistCheckInfo(httpServletRequest, registNo,index);
		
		//设置各个子表信息项到窗体表单
		setSubInfo(httpServletRequest,certainLossDto,index);
		
		//设置工作流下一个节点提交的配置信息
		getSubmitNodes(httpServletRequest,index);
	}
	
	/**
	 * 获取报案号相应的报案及查勘信息
	 * @param httpServletRequest
	 * @param registNo 报案号
	 * @throws Exception
	 */
	private void getRegistCheckInfo(HttpServletRequest httpServletRequest, String registNo,int index)
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
		httpServletRequest.setAttribute("prpLregistDto_"+index, prpLregistDtoTemp);
		
		// 查勘信息
		UIPrpLcheckAction uiPrpLcheckAction = new UIPrpLcheckAction();
		PrpLcheckDto prpLcheckDtoTemp = uiPrpLcheckAction.findByPrimaryKey(registNo);
		if (prpLcheckDtoTemp == null) {
			prpLcheckDtoTemp = new PrpLcheckDto();
		}
		httpServletRequest.setAttribute("prpLcheckDtoTemp_"+index, prpLcheckDtoTemp);
	}
	
	/**
	 * 填写定损页面及查询定损request的生成.
	 * @param httpServletRequest 返回给页面的request
	 * @param businessNo 业务号码
	 * @param editType 编辑类型
	 * @throws Exception
	 */
	public void registDtoToView(HttpServletRequest httpServletRequest, String businessNo,
			String editType,int index) throws Exception {
		PrpLregistDto prplregistDto = new PrpLregistDto();
		//标的序号，如果是人伤为0，否则为1，2，3，4，5等车辆序号 
		String lossItemCode = DataUtils.nullToZero(String.valueOf(httpServletRequest.getAttribute("lossItemCode_"+index)));
		UICodeAction uiCodeAction = new UICodeAction();
		//转换,无论有没有，都取一次
		String claimNo = uiCodeAction.translateBusinessCode(businessNo, true);
		
		//判断原来的定损是否存在
		UICertainLossAction uiCertainLossAction = new UICertainLossAction();
		CertainLossDto certainLossDto = uiCertainLossAction.findByPrimaryKey(businessNo,lossItemCode);
				
		PrpLverifyLossDto prpLverifyLossDto = new PrpLverifyLossDto();
	
		//如果是已经存在的定损
		if(certainLossDto.getPrpLverifyLossDto()!=null){
			prpLverifyLossDto = certainLossDto.getPrpLverifyLossDto();
			//设置定损操作的状态为 案件修改 (正处理任务)
			prpLverifyLossDto.setClaimNo(claimNo);
			if (certainLossDto.getPrpLclaimStatusDto() != null) {
				if (certainLossDto.getPrpLclaimStatusDto().getStatus().equals("7"))
					certainLossDto.getPrpLclaimStatusDto().setStatus("3");
				prpLverifyLossDto.setStatus(certainLossDto.getPrpLclaimStatusDto().getStatus());
			} else {
				// 已提交，已经处理完毕的状态
				prpLverifyLossDto.setStatus("1");
			}
			String nodeStatus = String.valueOf(httpServletRequest.getAttribute("status_"+index));
			if(nodeStatus!=null){
				prpLverifyLossDto.setStatus(nodeStatus);
			}
			if(certainLossDto.getPrpLcarLossDtoList()==null||certainLossDto.getPrpLcarLossDtoList().size()<1){} else {}
		}else{
			UIRegistAction uiRegistAction = new UIRegistAction();
			RegistDto registDto = uiRegistAction.findByPrimaryKey(businessNo.trim());
			prplregistDto = registDto.getPrpLregistDto();
			// 定损表
			certainLossDto = new CertainLossDto();
			prpLverifyLossDto.setRegistNo(registDto.getPrpLregistDto().getRegistNo());
			prpLverifyLossDto.setClaimNo(claimNo);
			prpLverifyLossDto.setRiskCode(prplregistDto.getRiskCode());
			prpLverifyLossDto.setPolicyNo(prplregistDto.getPolicyNo());
			prpLverifyLossDto.setInsuredName(prplregistDto.getInsuredName());
			prpLverifyLossDto.setLicenseNo(prplregistDto.getLicenseNo());
			prpLverifyLossDto.setClauseType(prplregistDto.getClauseType());
			prpLverifyLossDto.setLossItemCode(String.valueOf(httpServletRequest.getAttribute("lossItemCode_"+index)));
			prpLverifyLossDto.setLossItemName(String.valueOf(httpServletRequest.getAttribute("lossItemName_"+index)));
			prpLverifyLossDto.setInsureCarFlag(String.valueOf(httpServletRequest.getAttribute("insureCarFlag_"+index)));
			prpLverifyLossDto.setCurrency("CNY");
			prpLverifyLossDto.setMakeCom(prplregistDto.getMakeCom());
			prpLverifyLossDto.setComCode(prplregistDto.getComCode());
			
			// 设置农险统计参数
			prpLverifyLossDto.setLossesNumber(prplregistDto.getLossesNumber());
			prpLverifyLossDto.setLossesUnitCode(prplregistDto.getLossesUnitCode());
			
			
			HttpSession session = httpServletRequest.getSession();
			UserDto user = (UserDto) session.getAttribute("user");
			prpLverifyLossDto.setHandlerCode            (user.getUserCode());
			prpLverifyLossDto.setHandlerName            (user.getUserName());
			prpLverifyLossDto.setDefLossDate (new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));

			prpLverifyLossDto.setFlag(prplregistDto.getFlag());
			certainLossDto.setPrpLregistExtDtoList(registDto.getPrpLregistExtDtoList());
			//设置实赔操作的状态为 新案件登记 (未处理任务)
			prpLverifyLossDto.setStatus("1");
			
			//从prplacciperson表中得到出险者的信息
			if(registDto.getPrplacciBenPersonDtoList()!=null){
            	ArrayList prpLpropDtoList = new ArrayList();
            	PrpLpropDto prpLpropDto  = null;
            	Iterator iterator = registDto.getPrplacciBenPersonDtoList().iterator();
            	while(iterator.hasNext()){
            		PrpLacciPersonDto prplacciBenPersonDto = (PrpLacciPersonDto)iterator.next();
            		prpLpropDto = new PrpLpropDto();
            		prpLpropDto.setFamilyName(prplacciBenPersonDto.getAcciName());
            		prpLpropDto.setFamilyNo(prplacciBenPersonDto.getFamilyNo());
            		prplacciBenPersonDto.setSerialNo(prplacciBenPersonDto.getSerialNo());
            		prpLpropDto.setCurrency("CNY");
            		prpLpropDtoList.add(prpLpropDto);
            	}
            	certainLossDto.setPrpLpropDtoList(prpLpropDtoList);
            }
		}
		//查询相同保单号的出险次数
		DAACombineRegistViewHelper dAACombineRegistViewHelper = new DAACombineRegistViewHelper();
		dAACombineRegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLverifyLossDto.getPolicyNo(),prpLverifyLossDto.getRegistNo(),index);
		
		//设置相关代码的中文转换
		changeCodeToName(httpServletRequest,certainLossDto);
		
		//设置窗体表单中各个多选框中列表信息的内容
		//setSelectionList(httpServletRequest,businessNo);
		
		if (claimNo==null||claimNo.equals("")){
			DAAClaimViewHelper daaClaimViewHelper =new DAAClaimViewHelper ();
			prpLverifyLossDto.setClaimNo(daaClaimViewHelper.getLossClaimNo(businessNo));
		}
		//start设置耳标号清单列表 add by 张菊卿
		String taskCode = SysConfig.getProperty("FamilySplittingFlag","claim");
		if (prpLverifyLossDto.getRiskCode() != null && taskCode.indexOf(prpLverifyLossDto.getRiskCode()) > -1) {
			ArrayList prplCompensateEarDtoList = new ArrayList();//耳标清单列表
			if (businessNo != null)
			{
				BLPrplcompensateearFacade bLPrplcompensateearFacade = new BLPrplcompensateearFacade();

				if (editType.equals("ADD")) {
					if ("check".equals(String.valueOf(httpServletRequest
							.getParameter("nodeType")))) {
						prplCompensateEarDtoList = (ArrayList) bLPrplcompensateearFacade
								.getPrpLCompensateEarDtos(businessNo, "regis",businessNo);
					}
					if ("certa".equals(String.valueOf(httpServletRequest
							.getParameter("nodeType"))) ){

						prplCompensateEarDtoList = (ArrayList) bLPrplcompensateearFacade
								.getPrpLCompensateEarDtos(businessNo, "check",businessNo);

					}
				}
				if (editType.equals("EDIT") || editType.equals("SHOW")
						|| editType.equals("DELETE")) {
					prplCompensateEarDtoList = (ArrayList) bLPrplcompensateearFacade
							.getPrpLCompensateEarDtos(businessNo, "check",businessNo);
				}

			}

			httpServletRequest.setAttribute("prplCompensateEarDtoList_"+index, prplCompensateEarDtoList);

			httpServletRequest.setAttribute("familySplittingFlag_"+index, "true" );//设置耳标号清单列表
		}
		
		//end设置耳标号清单列表 add by 张菊卿
		//设置定损信息内容到窗体表单
		//start并案处理

		httpServletRequest.setAttribute("prpLverifyLossDto_"+index, prpLverifyLossDto);
		//end并案处理
		httpServletRequest.setAttribute("prpLregistDto_"+index, prplregistDto); //可能是中科软的疏忽，该属性会在后面getRegistCheckInfo中被覆盖
		httpServletRequest.setAttribute("certainLossDto_"+index, certainLossDto);//该属性在定损页面中没有使用
		
		// 获取报案及查勘信息
		this.getRegistCheckInfo(httpServletRequest, businessNo,index);
                                   
		//设置各个子表信息项到窗体表单  
		certainLossDto.setPrpLverifyLossDto(prpLverifyLossDto);
		setSubInfo(httpServletRequest,certainLossDto,index);
		
		//增加核损意见       
		httpServletRequest.setAttribute("verifyOpinionList_"+index, ICollections.getVerifyOpinionList());
		
		//设置工作流下一个节点提交的配置信息
		getSubmitNodes(httpServletRequest,index);
	}
	
	/**
	 * 设置出险时保单的承保数量，农险使用（种植险没有定损），用来控制赔付数量不能超过保单的总数量
	 * @param httpServletRequest
	 * @param riskType 险种大类
	 * @param prpLregistDto 报案信息
	 * @throws Exception
	 */
	public void setStatQuantity(HttpServletRequest httpServletRequest, String riskType,
			String registNo,int index) throws Exception {
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo); 
		if (riskType.equals("I")) {
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(prpLregistDto.getPolicyNo(),
					prpLregistDto.getDamageStartDate().toString(), prpLregistDto
							.getDamageStartHour());
			httpServletRequest.setAttribute("statQuantity_"+index, policyDto.getPrpCmainDto()
					.getStatQuantity());
		}
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
		if (certainLossDto.getPrpLpropDtoList() != null) {
			for (int i = 0; i < certainLossDto.getPrpLpropDtoList().size(); i++) {
				PrpLpropDto prpLpropDto = (PrpLpropDto) certainLossDto.getPrpLpropDtoList().get(i);
				String riskCode = prpLpropDto.getRiskCode();
				prpLpropDto.setFeeTypeName(uiCodeAction.translateCodeCode("PropertyFeeType",
						prpLpropDto.getFeeTypeCode(), true));
				prpLpropDto.setKindName(uiCodeAction.translateKindCode(riskCode, prpLpropDto
						.getKindCode(), true));
				prpLpropDto.setCurrencyName(uiCodeAction.translateCurrencyCode(prpLpropDto
						.getCurrency(), true));
			}
		}

		if (certainLossDto.getPrpLpersonDtoList() != null) {
			PrpLpersonDto prpLpersonDto = null;
			// 险别名称转换
			Iterator iterator2 = certainLossDto.getPrpLpersonDtoList().iterator();
			while (iterator2.hasNext()) {
				prpLpersonDto = (PrpLpersonDto) iterator2.next();
				String riskCode = prpLpersonDto.getRiskCode();
				prpLpersonDto.setKindName(uiCodeAction.translateKindCode(riskCode, prpLpersonDto
						.getKindCode(), true));
				prpLpersonDto.setItemName("test");
				prpLpersonDto.setCurrencyName(uiCodeAction.translateCurrencyCode(prpLpersonDto
						.getCurrency(), true));
				prpLpersonDto.setAreaName(uiCodeAction.translateCodeCode("DamageDistrict",
						prpLpersonDto.getAreaCode(), true));
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
			CertainLossDto certainLossDto,int index) throws Exception
			{
		//Modify by chenrenda add begin 20050413
		httpServletRequest.setAttribute("partCodeList_"+index, ICollections.getPartCodeList());
		
		//Modify by chenrenda add end 20050413
		
		//给定核损信息补充说明多行列表准备数据
		Collection arrayListVerifyLossExt = new ArrayList();
		PrpLverifyLossExtDto prpLverifyLossExtDto  = new PrpLverifyLossExtDto();
		PrpLverifyLossExtDto prpLverifyLossExtDtoAdd  = new PrpLverifyLossExtDto();
		prpLverifyLossExtDtoAdd.setTitle("定损完成");
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
		String status = String.valueOf(httpServletRequest.getAttribute("status_"+index));
		if("0".equals(status)||"3".equals(status)){
			arrayListVerifyLossExt.add(prpLverifyLossExtDtoAdd);
		}
		prpLverifyLossExtDto.setVerifyLossExtList(arrayListVerifyLossExt) ;
		httpServletRequest.setAttribute("prpLverifyLossExtDto_"+index, prpLverifyLossExtDto);
		       
				
		//财产核定损明细清单多行列表准备数据
		ArrayList arrayList4 = new ArrayList();
		PrpLpropDto prpLpropDto  = new PrpLpropDto();
		arrayList4 = certainLossDto.getPrpLpropDtoList();
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
		httpServletRequest.setAttribute("prpLpropDto_"+index, prpLpropDto);
//		理算退回意见
		Collection compensateBackOptionsList =ICollections.getCompensateBackList();
		httpServletRequest.setAttribute("compensateBackOptionsList_"+index,compensateBackOptionsList);
	
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
	 * 查询工作流可以用来选择的节点内容
	 * @param modelNo String
	 * @param nodeNo String
	 * @throws Exception
	 */
	private void getSubmitNodes(HttpServletRequest httpServletRequest,int index) throws Exception
	{
		String modelNo= String.valueOf(httpServletRequest.getAttribute("modelNo_"+index)); //模板号
		String nodeNo= String.valueOf(httpServletRequest.getAttribute("nodeNo_"+index));   //节点号
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
		httpServletRequest.setAttribute("pathList_"+index,pathList);
		httpServletRequest.setAttribute("swfPathDto_"+index,swfPathDto);
	}
	
}
