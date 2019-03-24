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
import com.sinosoft.claim.bl.facade.BLPrpCitemKindAgriFacade;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.bl.facade.BLVerifyLossFacade;
import com.sinosoft.claim.dto.custom.AcciCheckDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.VerifyLossDto;
import com.sinosoft.claim.dto.custom.WorkFlowQueryDto;
import com.sinosoft.claim.dto.domain.PrpCengageDto;
import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.claim.dto.domain.PrpLacciCheckTextDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLcheckExtDto;
import com.sinosoft.claim.dto.domain.PrpLcheckItemDto;
import com.sinosoft.claim.dto.domain.PrpLcheckLossDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.claim.ui.control.action.ICollections;
import com.sinosoft.claim.ui.control.action.UICheckAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.claim.ui.control.action.UIVerifyLossAction;
import com.gyic.claim.ui.control.viewHelper.DAACombineRegistViewHelper;
import com.gyic.claim.utils.Utils;
import com.sinosoft.claim.ui.control.viewHelper.CheckViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.prpall.pubfun.GroupProposalService;
import com.sinosoft.prpall.schema.PrpCvirturlItemSchema;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.utility.SysConfig;
/**
 * <p>
 * Title: CheckViewHelper
 * </p>
 * <p>
 * Description:查勘ViewHelper类，在该类中完成页面数据的整理
 * </p>
 * <p>
 * Copyright: Copyright 中科软科技股份有限公司(c) 2004
 * </p>
 * 
 * @author 车险理赔项目组 liubvo
 * @version 1.0 <br>
 */

public class AgriCombineCheckViewHelper{
	
	 private int RULE_LENGTH = 70; //rule字段的长度  
	 /**
	 * 默认构造方法
	 */
	public AgriCombineCheckViewHelper() {
	}

	   /**
	    * 保存查勘时查勘页面数据整理.
	    * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
	    * @param httpServletRequest
	    * @return checkDto 查勘数据传输数据结构
	    * @throws Exception
	    */
	    public CheckDto viewToDto(int combineIndex,HttpServletRequest httpServletRequest) throws Exception
	    {
	      CheckDto checkDto = new CheckDto();
	      /*---------------------查勘主表prpLcheck------------------------------------*/

	        PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
	        prpLcheckDto.setRegistNo((String)httpServletRequest.getAttribute("registNo_"+combineIndex));
	        prpLcheckDto.setClaimNo(httpServletRequest.getParameter("prpLcheckClaimNo_"+combineIndex));
	        prpLcheckDto.setRiskCode(httpServletRequest.getParameter("prpLcheckRiskCode_"+combineIndex));
	        prpLcheckDto.setPolicyNo(httpServletRequest.getParameter("prpLcheckPolicyNo_"+combineIndex));
	        prpLcheckDto.setCheckType(httpServletRequest.getParameterValues("checkType")[combineIndex]);
	        prpLcheckDto.setCheckNature(httpServletRequest.getParameterValues("checkNature")[combineIndex]);
	        prpLcheckDto.setCheckDate(new DateTime(httpServletRequest.getParameter("prpLcheckCheckDate_"+combineIndex)));
	        prpLcheckDto.setCheckSite(httpServletRequest.getParameter("prpLcheckCheckSite_"+combineIndex));
	        prpLcheckDto.setFirstSiteFlag(httpServletRequest.getParameter("firstSiteFlag_"+combineIndex));
	        prpLcheckDto.setClaimType(httpServletRequest.getParameter("claimType_"+combineIndex));
	        prpLcheckDto.setDamageCode(httpServletRequest.getParameter("prpLcheckDamageCode_"+combineIndex));
	        prpLcheckDto.setDamageName(httpServletRequest.getParameter("prpLcheckDamageName_"+combineIndex));
	        prpLcheckDto.setDamageTypeCode(httpServletRequest.getParameter("prpLcheckDamageTypeCode_"+combineIndex));
	        prpLcheckDto.setDamageTypeName(httpServletRequest.getParameter("prpLcheckDamageTypeName_"+combineIndex));
	        prpLcheckDto.setReferKind(httpServletRequest.getParameter("referKind_"+combineIndex));
	        //prpLcheckDto.setReferKind(httpServletRequest.getParameter("prpLcheckReferKind_"+combineIndex));
	        prpLcheckDto.setDamageAreaCode(httpServletRequest.getParameter("prpLcheckDamageAreaCode_"+combineIndex));
	        prpLcheckDto.setDamageAddressType(httpServletRequest.getParameter("damageAddressType_"+combineIndex));
	        prpLcheckDto.setIndemnityDuty(httpServletRequest.getParameter("indemnityDuty_"+combineIndex));
	        //prpLcheckDto.setClaimFlag(httpServletRequest.getParameter("prpLcheckClaimFlag_"+combineIndex));
	        prpLcheckDto.setClaimFlag(httpServletRequest.getParameter("claimFlag_"+combineIndex));
	        prpLcheckDto.setChecker1(httpServletRequest.getParameter("prpLcheckChecker1_"+combineIndex));
	        prpLcheckDto.setChecker2(httpServletRequest.getParameter("prpLcheckChecker2_"+combineIndex));
	        prpLcheckDto.setCheckUnitName(httpServletRequest.getParameter("prpLcheckCheckUnitName_"+combineIndex));
	        prpLcheckDto.setHandleUnit(httpServletRequest.getParameter("prpLcheckHandleUnitName_"+combineIndex));
	        prpLcheckDto.setRemark(httpServletRequest.getParameter("prpLcheckRemark_"+combineIndex));
	        prpLcheckDto.setFlag(httpServletRequest.getParameter("prpLcheckFlag_"+combineIndex));
	        prpLcheckDto.setDamageAddress(httpServletRequest.getParameter("prpLcheckDamageAddress_"+combineIndex)   );   //add 20060320 
	        //modify by wangwei add start 20060603
	        //原因：从页面中或的预估金额和预估费用
	        prpLcheckDto.setEstimateLoss(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLcheckEstimateLoss_"+combineIndex))));
	        prpLcheckDto.setEstimateFee(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLcheckEstimateFee_"+combineIndex))));
	        //modify by wangwei add end 20050603
	 
	        //加入 系统表示 和 查勘处理单位代码字段
	        prpLcheckDto.setUnitType(httpServletRequest.getParameterValues("unitType")[combineIndex]);
	        prpLcheckDto.setHandleUnitCode(httpServletRequest.getParameter("prpLcheckHandleUnitCode_"+combineIndex));
	        
	        //加到ArrayList中
	        //String prpLcheckReferSerialNo=httpServletRequest.getParameter("prpLcheckReferSerialNo_"+combineIndex);
	        prpLcheckDto.setReferSerialNo(1);
	        checkDto.setPrpLcheckDto(prpLcheckDto);
	        String riskCode = prpLcheckDto.getRiskCode();
	        String strRiskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
	        if("D".equals(strRiskType)){
	            prpLcheckDto.setInsureCarFlag("1");
	        }else{
	        	prpLcheckDto.setInsureCarFlag("");	
	        }
		    if (httpServletRequest.getParameter("repeatInsureFlag_"+combineIndex)==null)
	        	prpLcheckDto.setRepeatInsureFlag("-");		
			else
	            prpLcheckDto.setRepeatInsureFlag(httpServletRequest.getParameter("repeatInsureFlag_"+combineIndex));

	        //modify by wangwei add start 2005-06-18
	        //原因：添加意健险的调查信息
	        if ("E".equals(strRiskType)) {
	        	PrpLacciCheckDto  prpLacciCheckDto = new PrpLacciCheckDto();
	        	//prpLacciCheckDto.setCheckType(httpServletRequest.getParameter("checkType_"+combineIndex)); //暂时用来显示是什么节点提交过来的调查,需调整
	        	prpLacciCheckDto.setRegistNo(httpServletRequest.getParameter("prpLacciCheckRegistNo_"+combineIndex));
	        	prpLacciCheckDto.setTimes(Integer.parseInt(httpServletRequest.getParameter("prpLacciCheckTimes_"+combineIndex)));
	        	prpLacciCheckDto.setCheckNo(httpServletRequest.getParameter("prpLacciCheckCheckNo_"+combineIndex));
	        	prpLacciCheckDto.setCertiType(httpServletRequest.getParameter("prpLacciCheckCertiType_"+combineIndex));
	        	prpLacciCheckDto.setCertiNo(httpServletRequest.getParameter("prpLacciCheckCertiNo_"+combineIndex));
	        	prpLacciCheckDto.setRiskCode(httpServletRequest.getParameter("prpLacciCheckRiskCode_"+combineIndex));
	        	prpLacciCheckDto.setPolicyNo(httpServletRequest.getParameter("prpLacciCheckPolicyNo_"+combineIndex));
	        	//prpLacciCheckDto.setCheckType(httpServletRequest.getParameter());
	        	prpLacciCheckDto.setCheckContext(httpServletRequest.getParameter("prpLacciCheckCheckContext_"+combineIndex));
	        	prpLacciCheckDto.setCheckObjectDesc(httpServletRequest.getParameter("prpLacciCheckCheckObject_"+combineIndex));
	        	prpLacciCheckDto.setCheckNature(httpServletRequest.getParameterValues("checkNature")[combineIndex]);
	        	prpLacciCheckDto.setCheckDate(new DateTime(httpServletRequest.getParameter("prpLacciCheckCheckDate_"+combineIndex)));
	        	prpLacciCheckDto.setCheckHour(httpServletRequest.getParameter("prpLacciCheckCheckHour_"+combineIndex) + ":" + httpServletRequest.getParameter("prpLaccecheckCheckMinute_"+combineIndex));
	        	prpLacciCheckDto.setCheckEndDate(new DateTime(httpServletRequest.getParameter("prpLacciCheckCheckEndDate_"+combineIndex)));
	        	prpLacciCheckDto.setCheckEndHour(httpServletRequest.getParameter("prpLacciCheckCheckEndHour_"+combineIndex) + ":" + httpServletRequest.getParameter("prpLacciCheckCheckEndMinute_"+combineIndex));
	        	prpLacciCheckDto.setCheckSite(httpServletRequest.getParameter("prpLacciCheckCheckSite_"+combineIndex));
	        	prpLacciCheckDto.setDamageCode(httpServletRequest.getParameter("prpLacciCheckDamageCode_"+combineIndex));
	        	prpLacciCheckDto.setDamageName(httpServletRequest.getParameter("prpLacciCheckDamageName_"+combineIndex));
	        	prpLacciCheckDto.setDamageTypeCode(httpServletRequest.getParameter("prpLacciCheckDamageTypeCode_"+combineIndex));
	        	prpLacciCheckDto.setDamageTypeName(httpServletRequest.getParameter("prpLacciCheckDamageTypeName_"+combineIndex));
	        	prpLacciCheckDto.setCheckerCode(httpServletRequest.getParameter("prpLacciCheckCode_"+combineIndex));
	        	prpLacciCheckDto.setRemark(httpServletRequest.getParameter("prpLacciCheckRemark_"+combineIndex));
	        	prpLacciCheckDto.setCheckFee(Float.parseFloat(httpServletRequest.getParameter("prpLacciCheckCheckFee_"+combineIndex)));
	        	prpLacciCheckDto.setCurrency(httpServletRequest.getParameter("prpLacciCheckCurrencyCode_"+combineIndex));
	        	
				
	        	ArrayList prpLacciCheckTextDtoList = new ArrayList();
	            //得到连接串,下面将其切分到数组
	          String TextTemp = httpServletRequest.getParameter("prpLregistTextContextInnerHTML_"+combineIndex);
	          String[] rulesAcci = StringUtils.split(TextTemp,RULE_LENGTH);
	            for(int k=0;k<rulesAcci.length;k++){
	              PrpLacciCheckTextDto prpLacciCheckTextDto = new PrpLacciCheckTextDto();
	              prpLacciCheckTextDto.setCheckNo( (String) httpServletRequest.getParameter("prpLacciCheckCheckNo_"+combineIndex));
	              prpLacciCheckTextDto.setContext(rulesAcci[k]);
	              prpLacciCheckTextDto.setLineNo(k+1);
	              prpLacciCheckTextDto.setTextType("3");
	              prpLacciCheckTextDtoList.add(prpLacciCheckTextDto);
	            }
	            AcciCheckDto acciCheckDto = new AcciCheckDto(); 
	            acciCheckDto.setPrpLacciCheckDto(prpLacciCheckDto);
	            acciCheckDto.setPrpLacciCheckTextDtoList(prpLacciCheckTextDtoList);
	            checkDto.setAcciCheckDto(acciCheckDto);
	          }
	        //modify by wangwei add end 2005-06-18
	        
	        /*---------------------文本表PrpLregistTextDto--------------------*/
	      	ArrayList prpLregistTextDtoList = new ArrayList();
	        //得到连接串,下面将其切分到数组
	      String TextTemp = httpServletRequest.getParameter("prpLregistTextContextInnerHTML_"+combineIndex);
	      String[] rules = StringUtils.split(TextTemp,RULE_LENGTH);
	        for(int k=0;k<rules.length;k++){
	          PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
	          prpLregistTextDto.setRegistNo( (String) httpServletRequest.getAttribute("registNo_"+combineIndex));
	          prpLregistTextDto.setContext(rules[k]);
	          prpLregistTextDto.setLineNo(k+1);
	          prpLregistTextDto.setTextType("3");
	          prpLregistTextDtoList.add(prpLregistTextDto);
	        }        

	        //装入checkDto
	        checkDto.setPrpLregistTextDtoList(prpLregistTextDtoList);
	        
	        /*------------------出险原因详细信息----------------------*/
	        String strDamageMessage = httpServletRequest.getParameter("damageMessageFlag_"+combineIndex);
	        if(strDamageMessage!=null && !strDamageMessage.equals("")){
	     	   ArrayList prpLregistTextDtoList3 = new ArrayList();
	     	   String[] damageMessage = httpServletRequest.getParameterValues("damageMessage_"+combineIndex);
	     	   if(damageMessage != null){
	 	    	   for(int index = 0;index<damageMessage.length;index++){
	 	    		   PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
	 	    		   prpLregistTextDto.setRegistNo((String) httpServletRequest.getAttribute("registNo_"+combineIndex));
	 	    		   prpLregistTextDto.setLineNo(index+1);
	 	    		   prpLregistTextDto.setContext(damageMessage[index]);
	 	    		   prpLregistTextDto.setTextType(strDamageMessage);
	 	    		   prpLregistTextDtoList3.add(prpLregistTextDto);
	 	    	   }
	     	   }
	     	   checkDto.setPrpLregistTextDtoList3(prpLregistTextDtoList3);
	        }
	        
	        
	        /*---------------------耳标号信息表prpLcompensateear------------------------------------*/
	        ArrayList prplCompensateEarDtoList = new ArrayList();
			PrplcompensateearDto prplCompensateEarDto = null;
			
	  
			//从界面得到输入数组
			String   prpLcheckPolicyNo  = httpServletRequest.getParameter("prpLcheckPolicyNo_"+combineIndex);
			String   prpLcheckRegistNo  = httpServletRequest.getParameter("prpLcheckRegistNo_"+combineIndex);
			String   prpLcheckDamageStartDate  = httpServletRequest.getParameter("prpLcheckDamageStartDate_"+combineIndex);
			String   prpLcheckDamageCode  = httpServletRequest.getParameter("prpLcheckDamageCode_"+combineIndex);
			String   prpLcheckDamageName  = httpServletRequest.getParameter("prpLcheckDamageName_"+combineIndex);
			String[]   prpLpropKindCode  = httpServletRequest.getParameterValues("prpLpropKindCode_"+combineIndex);
			
			
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
					prplCompensateEarDto.setCombineno(httpServletRequest.getParameter("Combine"));
					prplCompensateEarDto.setCompensateno(prplCompensateEarCompensateNo[index]);
					prplCompensateEarDto.setCullnumber(Integer.valueOf(DataUtils.nullToZero(prplCompensateEarCullNumber[index])));
					prplCompensateEarDto.setDamagecode(prpLcheckDamageCode);
					prplCompensateEarDto.setDamageenddate(new DateTime(prplCompensateEarDamageEndDate[index],DateTime.YEAR_TO_DAY));
					prplCompensateEarDto.setDamagename(prpLcheckDamageName);
					prplCompensateEarDto.setDamagestartdate(new DateTime(prpLcheckDamageStartDate,DateTime.YEAR_TO_DAY));
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
					prplCompensateEarDto.setNodeno(2);
					prplCompensateEarDto.setNodetype("check");
					prplCompensateEarDto.setPolicyno(prpLcheckPolicyNo);
					prplCompensateEarDto.setRegistno(prpLcheckRegistNo);
					prplCompensateEarDto.setBusinessno(prpLcheckRegistNo);
					prplCompensateEarDto.setReporttime(prplCompensateEarReportTime[index]);
					prplCompensateEarDto.setRestfee(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarRestFee[index])));
					prplCompensateEarDto.setSumrealpay(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarSumRealpay[index])));
					prplCompensateEarDto.setUnitamount(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarUnitAmount[index])));

					
	    			prplCompensateEarDtoList.add(prplCompensateEarDto);
				}
			}
			checkDto.setPrpLcompensateeartDtoList(prplCompensateEarDtoList);
	        
	        /*---------------------状态内容prpLclaimStatus------------------------------------*/
	        PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
	        prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
	        prpLclaimStatusDto.setBusinessNo(prpLcheckDto.getRegistNo() );
	        prpLclaimStatusDto.setPolicyNo(prpLcheckDto.getPolicyNo());
	        prpLclaimStatusDto.setNodeType("check");
	        prpLclaimStatusDto.setSerialNo(0);
	        prpLclaimStatusDto.setRiskCode(prpLcheckDto.getRiskCode());
	        System.out.println("prpLclaimStatusDto.setRiskCode(prpLcheckDto.getRiskCode()):==" + prpLcheckDto.getRiskCode());
	        //取得当前用户信息，写操作员信息到查勘中
	        HttpSession session = httpServletRequest.getSession();
	        UserDto user = (UserDto) session.getAttribute("user");
	        prpLclaimStatusDto.setHandlerCode(user.getUserCode());
	        //prpLclaimStatusDto.setHandlerCode(prpLcheckDto.getOperatorCode() );
	        prpLclaimStatusDto.setInputDate(prpLcheckDto.getCheckDate() );
	        prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));

	        checkDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
	      return checkDto;

	    }

	/**
	 * 保存查勘时查勘页面数据整理. 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
	 * 
	 * @param httpServletRequest
	 * @return checkDto 查勘数据传输数据结构
	 * @throws Exception
	 */
	public CheckDto viewToDto(HttpServletRequest httpServletRequest,int combineIndex)
	throws Exception {
		//继承对check,checkText表的赋值
		CheckDto checkDto = this.viewToDto(combineIndex,httpServletRequest);
		//Modify by chenrenda add begin 20050418
		//Reason:损失模块信息合到涉案车辆、人伤、财产损失信息中
		ArrayList prpLcheckLossDtoList = new ArrayList();
		PrpLcheckLossDto prpLcheckLossDto = null;
		int intCheckLossIndex = 1;//序号
		String prpLcheckLossRegistNo = (String) httpServletRequest
		.getAttribute("registNo_"+combineIndex);
		String prpLcheckLossPolicyNo = httpServletRequest
		.getParameter("prpLcheckPolicyNo_"+combineIndex);
		String prpLcheckLossClaimNo = httpServletRequest
		.getParameter("prpLcheckClaimNo_"+combineIndex);
		String prpLcheckLossRiskCode = httpServletRequest
		.getParameter("prpLcheckRiskCode_"+combineIndex);
		//Modify by chenrenda add end 20050418
		
		//add by lixiang start at 2005-12-28
		//reason: 因为考虑到录入的时候，可能没有立案，但是在提交的时候，做了立案，导致立案号没写入。
		//先取立案号码，很重要，不要从页面上取得。。。
		String claimNo=prpLcheckLossClaimNo;
		if (claimNo==null||claimNo.length()<2){
			UICodeAction uiCodeAction = new UICodeAction();
			claimNo=uiCodeAction.translateBusinessCode(prpLcheckLossRegistNo ,true);
		}
		
		//add by lixiang end at 2005-12-28
		
		
		ArrayList scheduleItemDtoList = new ArrayList();
		PrpLscheduleItemDto prpLscheduleItemDto = new PrpLscheduleItemDto();
		
		//Reason:页面中增加其它损失模块
		/*---------------------其它损失部位 PrpLthirdProp begin------------------------------------*/
		ArrayList thirdPropDtoList = new ArrayList();
		PrpLthirdPropDto prpLthirdPropDto = null;
		
		//从界面得到输入数组
		String prpLthirdPropRegistNo = (String) httpServletRequest
		.getAttribute("registNo_"+combineIndex);
		String prpLthirdPropRiskCode = httpServletRequest
		.getParameter("prpLcheckRiskCode_"+combineIndex);
		String[] prpLthirdPropItemNo = httpServletRequest
		.getParameterValues("prpLthirdPropItemNo_"+combineIndex);
		String[] prpLthirdPropLicenseNo = httpServletRequest
		.getParameterValues("prpLthirdPropLicenseNo_"+combineIndex);
		String[] lossItemCode = httpServletRequest
		.getParameterValues("prpLthirdLossItemCode_"+combineIndex);
		String[] LossItemName = httpServletRequest
		.getParameterValues("prpLthirdLossItemName_"+combineIndex);
		String[] prpLthirdPropLossDesc = httpServletRequest
		.getParameterValues("prpLthirdPropLossDesc_"+combineIndex);
		String[] prpLthirdPropFlag = httpServletRequest
		.getParameterValues("prpLthirdPropFlag_"+combineIndex);
		
		//Modify by chenrenda add begin 20050418
		//Reason:损失模块信息合到涉案车辆、人伤、财产损失信息中
		String[] prpLthirdPropKindCode = httpServletRequest
		.getParameterValues("prpLthirdPropKindCode_"+combineIndex);
		String[] prpLthirdPropLossFee = httpServletRequest
		.getParameterValues("prpLthirdPropLossFee_"+combineIndex);
		//Modify by chenrenda add end 20050418
		   String[] prpLthirdPropNewAddFlag      =httpServletRequest.getParameterValues("prpLthirdPropNewAddFlag_"+combineIndex );//是否新增项目的标志
		   
		//对象赋值
		//损失部位部分开始
		if (prpLthirdPropItemNo == null) {
		} else {
			for (int index = 1; index < prpLthirdPropItemNo.length; index++) {
				
				prpLthirdPropDto = new PrpLthirdPropDto();
				
				//Modify by chenrenda update begin 20050418
				//Reason:预估损失模块合到涉案车辆信息中
				prpLcheckLossDto = new PrpLcheckLossDto();
				prpLcheckLossDto.setRegistNo(prpLcheckLossRegistNo);
				prpLcheckLossDto.setClaimNo(claimNo);
				prpLcheckLossDto.setRiskCode(prpLcheckLossRiskCode);
				prpLcheckLossDto.setPolicyNo(prpLcheckLossPolicyNo);
				System.out.println("**********prpLthirdProp****:"
						+ intCheckLossIndex);
				prpLcheckLossDto.setSerialNo(intCheckLossIndex);
				prpLcheckLossDto.setReferSerialNo(intCheckLossIndex);
				prpLcheckLossDto.setKindCode(prpLthirdPropKindCode[index]);
				prpLcheckLossDto.setLossFeeType("3");
				prpLcheckLossDto.setLossFee(Double.parseDouble(DataUtils
						.nullToZero(prpLthirdPropLossFee[index])));
				prpLcheckLossDto.setFlag("");
				intCheckLossIndex++;
				prpLcheckLossDtoList.add(prpLcheckLossDto);
				//Modify by chenrenda update end 20050418
				
				prpLthirdPropDto.setRegistNo(prpLthirdPropRegistNo);
				prpLthirdPropDto.setRiskCode(prpLthirdPropRiskCode);
				prpLthirdPropDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLthirdPropItemNo[index])));
				prpLthirdPropDto.setLicenseNo(prpLthirdPropLicenseNo[index]);
				prpLthirdPropDto.setLossItemCode(lossItemCode[index]);
				prpLthirdPropDto.setLossItemName(LossItemName[index]);
				prpLthirdPropDto.setLossItemDesc(prpLthirdPropLossDesc[index]);
				prpLthirdPropDto.setFlag(prpLthirdPropFlag[index]);
				
				//加入集合
				thirdPropDtoList.add(prpLthirdPropDto);
				
			}
//			增加财产损失定损调度信息，如果有人，就进行调度
			System.out.println(" 财产损失判断开始。。。。。。。。");
			if (thirdPropDtoList != null && thirdPropDtoList.size() > 0) {
				System.out.println(" 财产损失有内容。。。。。。。。");	
		         prpLscheduleItemDto = new PrpLscheduleItemDto();
		         prpLscheduleItemDto.setScheduleID(1);
		         prpLscheduleItemDto.setRegistNo(checkDto.getPrpLcheckDto() .getRegistNo());
		         prpLscheduleItemDto.setItemNo(-1);
		         //表示是否选中
		         prpLscheduleItemDto.setSelectSend("1");
		         //表示没有调度成定损过
		         prpLscheduleItemDto.setSurveyTimes(0);
		         prpLscheduleItemDto.setSurveyType("1");
		         prpLscheduleItemDto.setCheckSite(checkDto.getPrpLcheckDto().getCheckSite() );
		         prpLscheduleItemDto.setInputDate(new DateTime(DateTime.current(),
		             DateTime.YEAR_TO_DAY));
		         prpLscheduleItemDto.setScheduleType("schel");
		         prpLscheduleItemDto.setLicenseNo("财产损失");
		         prpLscheduleItemDto.setScheduleObjectID("_");
		         prpLscheduleItemDto.setScheduleObjectName(" ");
		         prpLscheduleItemDto.setNextNodeNo("propc");
		        	scheduleItemDtoList.add(prpLscheduleItemDto);

			}

			//报案集合中加入损失部位
			checkDto.setPrpLthirdPropDtoList(thirdPropDtoList);
			}
		/*---------------------其它损失部位 PrpLthirdProp end------------------------------------*/
		//Modify by chenrenda add end 20050407
		
        //整理数据，整理定损调度的数据，如果当提交的时候。。将新的数据放入prplscheduleItem中，并保留已经调度过的数据
        if (checkDto.getPrpLclaimStatusDto() .getStatus().equals("4")
           &&scheduleItemDtoList.size() >0 ){ //本次查勘查找到有新的调度任务
           //检查定损调度的情况，如果存在定损调度，检查是否已经调度过，如果没有调度过，按照没有调度过处理
           Collection prpLscheduleItemList = new ArrayList();
           //查询调度过的
           String strSql =" registno ='"+checkDto.getPrpLcheckDto() .getRegistNo()
                         +"' and surveyTimes='1'";
           //查询数据
           UIScheduleAction uiScheduleAction=new UIScheduleAction();
           prpLscheduleItemList =uiScheduleAction.findItemByConditions(strSql) ;
           PrpLscheduleItemDto prpLscheduleItemoldDto=new PrpLscheduleItemDto();
           ArrayList scheduleItemLastList = new ArrayList();
           if (prpLscheduleItemList ==null || prpLscheduleItemList.size()<1){
              //不用检查scheduleITem的。。
              checkDto.setPrpLscheduleItemDtoList(scheduleItemDtoList) ;
           }else
           { //检查整理好的数据中，是否已经有已经调度过的数据

               ////System.out.println("prpLscheduleItemList.size()"+prpLscheduleItemList.size());
             //scheduleItemDtoList 是指原来从调度已经调度过的数据，无论怎么样，都是不能被删除的。
             //只要检查 scheduleItemDtoList中存在 prpLscheduleItemList中没有的，就增加prpLscheduleItemList好了。
             
            boolean blnotFind=true; 
            //scheduleItemDtoList，查勘这里收集的调度数据
             for (int i =0;i<scheduleItemDtoList.size() ;i++)
             {
               prpLscheduleItemDto = new PrpLscheduleItemDto();
               prpLscheduleItemDto = (PrpLscheduleItemDto)scheduleItemDtoList.get(i);
               //原则，相同的，以原来的数据为准，没有的已后来的为准
               blnotFind=true;
               for (int j =0;j<prpLscheduleItemList.size() ;j++)
               {
                 prpLscheduleItemoldDto= new PrpLscheduleItemDto();
                 prpLscheduleItemoldDto = (PrpLscheduleItemDto)((ArrayList)prpLscheduleItemList).get(j);
                 if (prpLscheduleItemDto.getItemNo()==prpLscheduleItemoldDto.getItemNo() )
                 { //如果存在旧的数据，就要用旧的数据，不要用新的数据
                   blnotFind=false;
                   break;
                 }
                 //原则，相同的，以原来的数据为准，没有的已后来的为准
               }
               
               if (blnotFind)  scheduleItemLastList.add(prpLscheduleItemDto) ;
             }
             
             //最后把原来已经调度过的数据再增加回去
            scheduleItemLastList.addAll(prpLscheduleItemList);
            checkDto.setPrpLscheduleItemDtoList(scheduleItemLastList) ;
           }
         }

		//Modify by chenrenda add begin 20050408
		//Reason:损失部位模块信息调整到涉案车辆信息中，相应模块做调整
		
		/*---------------------损失部位 PrpLthirdCarLoss end------------------------------------*/
		//Modify by chenrenda add end 20050408
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
		if (prpLregistExtSerialNo == null) {
		} else {
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
			checkDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
		}
		//Modify by chenrenda add begin 20051418
		//Reason:损失模块信息合到涉案车辆、人伤、财产损失信息中;最后损失信息放入checkDto对象中
		checkDto.setPrpLcheckLossDtoList(prpLcheckLossDtoList);
		//Modify by chenrenda add end 20051418
		return checkDto;
	}
	
	/**
	 * 取初始化信息需要的数据的整理. 填写查勘单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参，
	 * 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
	 * 
	 * @param httpServletRequest
	 * @return RequestDto 取初始化信息需要的数据
	 * @throws Exception
	 */
	public CheckDto iniViewToDto(HttpServletRequest httpServletRequest)
	throws Exception {
		CheckDto checkDto = new CheckDto();
		return checkDto;
	}
	
	/**
	 * 填写查勘页面及查询查勘request的生成.
	 * 填写查勘时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param proposalIniDto
	 *            取出的初始化信息Dto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest,
			CheckDto checkDto) throws Exception {
		//得到request的PrpLcheckForm用于显示
		PrpLcheckDto prpLcheckDto = checkDto.getPrpLcheckDto();
		httpServletRequest.setAttribute("prpLcheckDto", prpLcheckDto);
	}
	
	public void checkDtoView(HttpServletRequest httpServletRequest,
			String checkNo,int index) throws Exception {
		//取得当前用户信息，写操作员信息到查勘中
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		UICheckAction uiCheckAction = new UICheckAction();
		if (checkNo.length() > 21) {
		checkNo = checkNo.substring(0, 21);
	}
		CheckDto checkDto = uiCheckAction.findByPrimaryKey(checkNo);
		PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
		prpLcheckDto = checkDto.getPrpLcheckDto();
		UICodeAction uiCodeAction =new UICodeAction();
		//原因：区分意健和非意键险
		RegistDto registDto = new UIRegistAction().findByPrimaryKey(checkNo);
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(registDto.getPrpLregistDto().getRiskCode());
				//modify by wangwei add end 2005-06-18
		String riskCode = registDto.getPrpLregistDto().getRiskCode();
			
			//根据查询出来的数据内容，给PrpLcheckDto赋值
			
			//为了同步工作流
			//     prpLcheckDto.setLossItemName(lossItemName);
			prpLcheckDto.setLossItemCode(prpLcheckDto.getReferSerialNo() + "");
			//     prpLcheckDto.setInsureCarFlag(insureCarFlag);
			//    System.out.println("------liujianbo-----"+prpLcheckDto.getLossItemCode()+"|"+prpLcheckDto.getLossItemName()+"|"+prpLcheckDto.getInsureCarFlag());
			//设置查勘操作的状态为 案件修改 (正处理任务)
			if (checkDto.getPrpLclaimStatusDto() != null) {
				if (checkDto.getPrpLclaimStatusDto().getStatus().equals("7"))
					checkDto.getPrpLclaimStatusDto().setStatus("3");
				prpLcheckDto.setStatus(checkDto.getPrpLclaimStatusDto()
						.getStatus());
			} else {
				//已提交，已经处理完毕的状态
				prpLcheckDto.setStatus("4");
			}
			String nodeStatus = String.valueOf(httpServletRequest.getAttribute("status_"+index)) ;
			if (nodeStatus != null) {
				prpLcheckDto.setStatus(nodeStatus);
			}
			prpLcheckDto.setDamageStartDate(registDto.getPrpLregistDto()
					.getDamageStartDate());
			prpLcheckDto.setDamageEndDate(registDto.getPrpLregistDto()
					.getDamageEndDate());
			prpLcheckDto.setRegistEstimateFee(registDto.getPrpLregistDto()
					.getEstimateFee());
			prpLcheckDto.setRegistEstimateLoss(registDto.getPrpLregistDto()
					.getEstimateLoss());
			//registDto.getPrpLregistDto().setDamageStartHour(StringConvert.toStandardTime(registDto.getPrpLregistDto().getDamageStartHour()));
			String timeTemp = StringConvert.toStandardTime(registDto
					.getPrpLregistDto().getDamageStartHour());
			prpLcheckDto.setDamageStartMinute(timeTemp.substring(3, 5));
			prpLcheckDto.setDamageStartHour(timeTemp.substring(0, 2));
			timeTemp = StringConvert.toStandardTime(registDto
					.getPrpLregistDto().getDamageEndHour());
			prpLcheckDto.setDamageEndMinute(timeTemp.substring(3, 5));
			prpLcheckDto.setDamageEndHour(timeTemp.substring(0, 2));
			//prpLcheckDto.setDamageAddress(registDto.getPrpLregistDto()
			//		.getDamageAddress());
			//modify by lixiang add 20050308 start
			//reason:为了保证立案后三者车的顺利保存
			//如果立案取出赔案号，否则会出现问题
			//UICodeAction uiCodeAction = new UICodeAction();
			String claimNo = uiCodeAction.translateBusinessCode(checkNo, true);
			prpLcheckDto.setClaimNo(claimNo);
			//modify by lixiang add 20050308 end
			//modify by caopeng add 20051219 start
			if(registDto!=null && registDto.getPrpLregistDto()!=null){
				prpLcheckDto.setLossItemName(registDto.getPrpLregistDto().getLicenseNo());
				prpLcheckDto.setInsuredName(registDto.getPrpLregistDto().getInsuredName());
			}
			//modify by caopeng add 20051219 end
			//设置相关代码的中文转换
			changeCodeToName(httpServletRequest, prpLcheckDto);
			
			AgriCombineRegistViewHelper agriCombineRegistViewHelper = new AgriCombineRegistViewHelper();
			//查询相同保单号的出险次数
			agriCombineRegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
					prpLcheckDto.getPolicyNo(), prpLcheckDto.getRegistNo(),index);
			
			//Modify by chenrenda add begin 20050418
			//Reason:三个不同节点共用几个jsp文件时，客户端程序需要区分请求来自哪个节点
			String strPrpLnodeType = "check";
			httpServletRequest.setAttribute("prpLnodeType_"+index, strPrpLnodeType);
			//Modify by chenrenda add end 20050418
			
			//设置各个子表信息项到窗体表单
			setSubInfo(httpServletRequest, checkDto,index);
			
			//设置工作流下一个节点提交的配置信息
			getSubmitNodes(httpServletRequest,index);
			//设置主查勘信息内容到窗体表单
			httpServletRequest.setAttribute("prpLcheckDto_"+index, prpLcheckDto);
			
			//在界面上显示险种名称 2005-09-09
			httpServletRequest.setAttribute("riskCName_"+index, uiCodeAction
					.translateRiskCode(prpLcheckDto.getRiskCode(), true));
			
			httpServletRequest.setAttribute("prpLregistDto_"+index, registDto
					.getPrpLregistDto());
			//modify by wangwei add start 2005-06-15
			// 原因：转换代理人
			httpServletRequest.setAttribute("com.sinosoft.agentCode", registDto
					.getIdentifierName());
			//modify by wangwei add end 2005-06-15
			String policyNo = prpLcheckDto.getPolicyNo();
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
					policyNo, registDto.getPrpLregistDto().getDamageStartDate()
					.toString(), registDto.getPrpLregistDto()
					.getDamageStartHour());
			//add by qinyongli 2005-8-30 start
			//add by miaowenjun 20060925 查勘性质
			Collection checkNatures = uiCodeAction.getCodeType("CheckNature",
					BusinessRuleUtil.getOuterCode(httpServletRequest,
					"RISKCODE_DAA"));
			String editType     = String.valueOf(httpServletRequest.getAttribute("editType_"+index));
			AgriCombineCertainLossViewHelper agriCombineCertainLossViewHelper = new AgriCombineCertainLossViewHelper();
			agriCombineCertainLossViewHelper.registDtoToView(httpServletRequest, checkNo,
					editType,index);
					/*BusinessRuleUtil.getOuterCode(httpServletRequest,
					"RISKCODE_IBA"));GYIC张菊卿*/
			httpServletRequest.setAttribute("checkNatures_"+index, checkNatures);
			httpServletRequest.setAttribute("statQuantity_"+index, policyDto.getPrpCmainDto().getStatQuantity());

	}
	/**
	 * 填写查勘页面及查询查勘request的生成.
	 * 填写查勘时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param proposalIniDto
	 *            取出的初始化信息Dto
	 * @throws Exception
	 */
	public void registDtoToView(HttpServletRequest httpServletRequest,
			String registNo, String editType,int index) throws Exception {
		//取得当前用户信息，写操作员信息到查勘中
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
	    if (user==null){
			user = new UserDto();
		}
		if (registNo.length() > 21) {
			registNo = registNo.substring(0, 21);
		}
		
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		registDto.getPrpLdriverDtoList();
	    UICheckAction uiCheckAction = new UICheckAction();
		UICodeAction uiCodeAction = new UICodeAction();
		PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
		String claimNo = uiCodeAction.translateBusinessCode(registNo, true);
			
		//原因：区分意健和非意键险
		String riskCode = registDto.getPrpLregistDto().getRiskCode();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		
		//原因：要在界面上显示一些立案信息
		com.sinosoft.claim.ui.control.action.UIClaimAction uiClaimAction = new com.sinosoft.claim.ui.control.action.UIClaimAction();
		Collection registClaimDtoList = (Collection) uiClaimAction
		.findByPolicyNo(registDto.getPrpLregistDto().getPolicyNo());
		httpServletRequest.setAttribute("registClaimDtoList_"+index,
				registClaimDtoList);
		httpServletRequest.setAttribute("com.sinosoft.agentCode", registDto
				.getIdentifierName());
		//modify by wangwei add end 2005-06-07

		/*
		//原因：要在界面上显示一些定损的信息
		UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
		Collection registVerifyLossList = (Collection) uiVerifyLossAction.findByPrimaryKey(registNo);
		httpServletRequest.setAttribute("registVerifyLossList",registVerifyLossList);
		*/
		//查询是否已经录入过查勘信息。
		if (uiCheckAction.isExist(registNo)&&!strRiskType.equals("H")) {
			checkDtoView(httpServletRequest, registNo,index);
			//养殖险先查堪,后定损时带出承包数量
			if(strRiskType.equals("I")){
				EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
				PolicyDto policyDto = endorseViewHelper.findForEndorBefore(registDto.getPrpLregistDto().getPolicyNo(),
						registDto.getPrpLregistDto().getDamageStartDate().toString(),
						registDto.getPrpLregistDto().getDamageStartHour());
				httpServletRequest.setAttribute("statQuantity_"+index, policyDto.getPrpCmainDto().getStatQuantity());
			}
			return;
		}
		prpLcheckDto.setReferSerialNo(1);
		
		prpLcheckDto.setRegistNo(registDto.getPrpLregistDto().getRegistNo());
		//如果在查勘前已经立案了，那么如果不把赔案号放入的话会出问题
		
		prpLcheckDto.setClaimNo(claimNo);
		prpLcheckDto.setRiskCode(registDto.getPrpLregistDto().getRiskCode());
		prpLcheckDto.setPolicyNo(registDto.getPrpLregistDto().getPolicyNo());
		//prpLcheckDto.setCheckType("L");
		
		////查勘界面的查勘类型由调度表带出 2005-07-12
		if (registDto.getPrpLscheduleMainWFDto() != null) {
			prpLcheckDto.setCheckType(registDto.getPrpLscheduleMainWFDto()
					.getFlag());
		}
		
		//modify by wangwei add start 20050602
		//原因：增加报损金额和报损费用
		prpLcheckDto.setRegistEstimateLoss(registDto.getPrpLregistDto()
				.getEstimateLoss());
		prpLcheckDto.setRegistEstimateFee(registDto.getPrpLregistDto()
				.getEstimateFee());
		//modity by wangwei add end 20050602
		
		//add by miaowenjun 20060922 查勘性质列表 农险需求还没定，暂时使用Daa否则页面错误
		Collection checkNatures = uiCodeAction.getCodeType("CheckNature",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("checkNatures_"+index, checkNatures);
		//prpLcheckDto.setCheckNature(registDto.getPrpLregistDto().getCheckNature());
		//prpLcheckDto.setCheckDate(registDto.getPrpLregistDto().getCheckDate());
		//prpLcheckDto.setCheckSite(registDto.getPrpLregistDto().getCheckSite());
		//modify by lixiang remark 20050309 start
		// prpLcheckDto.setCheckSite(registDto.getPrpLregistDto().getDamageAddress());
		//reason:查勘界面出险地点由报案带出，查勘地址默认为出险地点
		//modify by lixiang remark 20050309 end
		
		//查勘界面的查勘地址由调度表带出 2005-07-12
		if (registDto.getPrpLscheduleMainWFDto() != null) {
			prpLcheckDto.setCheckSite(registDto.getPrpLscheduleMainWFDto()
					.getCheckSite());
		}
		
		prpLcheckDto.setFirstSiteFlag(registDto.getPrpLregistDto()
				.getFirstSiteFlag());
		prpLcheckDto.setClaimType(registDto.getPrpLregistDto().getClaimType());
		prpLcheckDto
		.setDamageCode(registDto.getPrpLregistDto().getDamageCode());
		prpLcheckDto
		.setDamageName(registDto.getPrpLregistDto().getDamageName());
		prpLcheckDto.setDamageTypeCode(registDto.getPrpLregistDto()
				.getDamageTypeCode());
		prpLcheckDto.setDamageTypeName(registDto.getPrpLregistDto()
				.getDamageTypeName());
		//prpLcheckDto.setReferKind(registDto.getPrpLregistDto().getReferKind());
		/////////////////////////bobobo//////////////////
		prpLcheckDto.setReferKind("A,M,L");
		prpLcheckDto.setDamageAreaCode(registDto.getPrpLregistDto()
				.getDamageAreaCode());
		prpLcheckDto.setDamageAddressType(registDto.getPrpLregistDto()
				.getDamageAddressType());
		//prpLcheckDto.setIndemnityDuty(registDto.getPrpLregistDto().getIndemnityDuty());
		//prpLcheckDto.setClaimFlag(registDto.getPrpLregistDto().getClaimFlag());
		
		//modify by lixiang add 20050304 start
		//reason:查勘人1默认为操作人远的名称
		
		prpLcheckDto.setChecker1(user.getUserName());
		//System.out.println("prpLcheckDto.setChecker1"+prpLcheckDto.getChecker1());
		//modify by lixiang add 20050304 end
		
		//prpLcheckDto.setChecker2(registDto.getPrpLregistDto().getChecker2());
		//prpLcheckDto.setCheckUnitName(registDto.getPrpLregistDto().getCheckUnitName());
		prpLcheckDto
		.setHandleUnit(registDto.getPrpLregistDto().getHandleUnit());
		prpLcheckDto.setRemark(registDto.getPrpLregistDto().getRemark());
		prpLcheckDto.setFlag(registDto.getPrpLregistDto().getFlag());
		
		//add by wuxiaodong 050905 beegain reasion 用户显示报案时的币别
		prpLcheckDto
		.setCurrency(registDto.getPrpLregistDto().getEstiCurrency());
		//add by wuxiaodong 050905 end
		
		prpLcheckDto.setDamageAddress(registDto.getPrpLregistDto()
				.getDamageAddress());
		prpLcheckDto.setStatus(registDto.getPrpLregistDto().getStatus());
		prpLcheckDto.setEditType(registDto.getPrpLregistDto().getEditType());
		prpLcheckDto
		.setClauseType(registDto.getPrpLregistDto().getClauseType());
		prpLcheckDto
		.setClauseName(registDto.getPrpLregistDto().getClauseName());//code
		prpLcheckDto.setDamageStartDate(registDto.getPrpLregistDto()
				.getDamageStartDate());
		//prpLcheckDto.setDamageStartHour(registDto.getPrpLregistDto().getDamageStartHour());
		
		prpLcheckDto.setDamageEndDate(registDto.getPrpLregistDto()
				.getDamageEndDate());
		
		//向查勘页面添加被保险人信息  2005-09-26
		prpLcheckDto.setInsuredName(registDto.getPrpLregistDto().getInsuredName());
		
		//prpLcheckDto.setDamageEndHour(registDto.getPrpLregistDto().getDamageEndHour());
		String timeTemp = StringConvert.toStandardTime(registDto
				.getPrpLregistDto().getDamageStartHour());
		prpLcheckDto.setDamageStartMinute(timeTemp.substring(3, 5));
		prpLcheckDto.setDamageStartHour(timeTemp.substring(0, 2));
		timeTemp = StringConvert.toStandardTime(registDto.getPrpLregistDto()
				.getDamageEndHour());
		prpLcheckDto.setDamageEndMinute(timeTemp.substring(3, 5));
		prpLcheckDto.setDamageEndHour(timeTemp.substring(0, 2));
		
		prpLcheckDto.setDamageAreaName(registDto.getPrpLregistDto()
				.getDamageAreaName());
		//prpLcheckDto.setHandleUnitName(registDto.getPrpLregistDto().getHandleUnitName());//未知
		
		//默认查勘日期
		prpLcheckDto.setCheckDate(new DateTime(DateTime.current(),
				DateTime.YEAR_TO_DAY));
		//设置查勘操作的状态为 新案件登记 (未处理任务)
		prpLcheckDto.setStatus("1");
		
		//设置相关代码的中文转换
		changeCodeToName(httpServletRequest, prpLcheckDto);
		//设置窗体表单中各个多选框中列表信息的内容
		//System.out.println("prpLcheckDto.getHandleUnitName()="+prpLcheckDto.getHandleUnitName()
		// );
		//查询相同保单号的出险次数
		DAACombineRegistViewHelper dAACombineRegistViewHelper = new DAACombineRegistViewHelper();
		dAACombineRegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLcheckDto.getPolicyNo(), prpLcheckDto.getRegistNo(),index);
		
		//设置主查勘信息内容到窗体表单
		//如果是三者车辆，那么因为不保存，又要通过校验，所以必须在特定域中放如初始化的数值
		/*
		 * if
		 * ((prpLcheckDto.getRiskCode().equals(BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA")))&&!insureCarFlag.equals("1")) {
		 * prpLcheckDto.setCheckSite("0 "); prpLcheckDto.setChecker1("0");
		 * prpLcheckDto.setChecker2("0 ");
		 * 
		 * }else {//默认值 prpLcheckDto.setInsureCarFlag("1");
		 * prpLcheckDto.setReferSerialNo(1); }
		 */
		//设置各个子表信息项到窗体表单
		CheckDto checkDto = new CheckDto();
		/*
		 * ArrayList arraylist1= new ArrayList();
		 * if(registDto.getPrpLthirdPartyDtoList() != null) {
		 * arraylist1.add(registDto.getPrpLthirdPartyDtoList().get(0)); }
		 */
		checkDto.setPrpLthirdPartyDtoList(registDto.getPrpLthirdPartyDtoList());
		checkDto.setPrpLdriverDtoList(registDto.getPrpLdriverDtoList());
		checkDto.setPrpLpersonTraceDtoList(registDto
				.getPrpLpersonTraceDtoList());
		checkDto.setPrpLthirdCarLossDtoList(registDto
				.getPrpLthirdCarLossDtoList());
		checkDto.setPrpLthirdPropDtoList(registDto.getPrpLthirdPropDtoList());
		checkDto.setPrpLregistExtDtoList(registDto.getPrpLregistExtDtoList());
		//modify by luqin add 2005-06-21 start
		checkDto.setPrpLregistTextDtoList(registDto.getPrpLregistTextDtoList());
		//modify by luqin add 2005-06-21 end
		checkDto.setPrpLregistTextDtoList3(registDto.getPrpLregistTextDtoList3());
		//modify by wangli add start 20050408
		//保存特别约定信息
		checkDto.setPrpLcheckDto(prpLcheckDto);

		//modify by wangli add end 20050408
		
		//Modify by chenrenda add begin 20050418
		//Reason:三个不同节点共用几个jsp文件时，客户端程序需要区分请求来自哪个节点
		String strPrpLnodeType = "check";
		httpServletRequest.setAttribute("prpLnodeType_"+index, strPrpLnodeType);
		//Modify by chenrenda add end 20050418
		
		 CheckDto checkDtoTemp = uiCheckAction.findByPrimaryKey(registNo);
		 checkDto.setPrpLcheckLossDtoList(checkDtoTemp.getPrpLcheckLossDtoList());

		//设置各个子表中的信息和显示
		setSubInfo(httpServletRequest, checkDto,index);
		
		//设置工作流下一个节点提交的配置信息
		getSubmitNodes(httpServletRequest,index);
		
		//获取定损信息
		AgriCombineCertainLossViewHelper agriCombineCertainLossViewHelper = new AgriCombineCertainLossViewHelper();
		agriCombineCertainLossViewHelper.registDtoToView(httpServletRequest, registNo,
				editType,index);
				/*BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_IBA"));原参数，注释掉*/
		httpServletRequest.setAttribute("prpLcheckDto_"+index, prpLcheckDto);
		//在界面上显示险种名称 2005-09-09
		httpServletRequest.setAttribute("riskCName_"+index, uiCodeAction
				.translateRiskCode(prpLcheckDto.getRiskCode(), true));
		
		String policyNo = prpLcheckDto.getPolicyNo();
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,
				registDto.getPrpLregistDto().getDamageStartDate().toString(),
				registDto.getPrpLregistDto().getDamageStartHour());
		if (policyDto != null) {
			httpServletRequest.setAttribute("coinsFlag_"+index, policyDto
					.getPrpCmainDto().getCoinsFlag());
			httpServletRequest.setAttribute("shareHolderFlag_"+index, policyDto
					.getPrpCmainDto().getShareHolderFlag());
		}
		httpServletRequest.setAttribute("statQuantity_"+index, policyDto.getPrpCmainDto().getStatQuantity());
		
	}
	
	/**
	 * 根据赔案号和报案号查询查勘信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param registNo
	 *            赔案号
	 * @param claimNo
	 *            报案号
	 * @throws Exception
	 */
	
	public void setPrpLcheckDtoToView(HttpServletRequest httpServletRequest,
			String registNo, String policyNo,int index) throws Exception {
		//checkNo,policyNo,claimNo
		//根据输入的保单号，查勘号生成SQL where 子句
		policyNo = StringUtils.rightTrim(policyNo);
		registNo = StringUtils.rightTrim(registNo);
		String conditions = "";
		conditions = " registNo like '" + registNo + "%' and policyNo like '" + policyNo + "%'";
		//查询预赔信息
		UICheckAction uiCheckAction = new UICheckAction();
		
		//得到多行查勘主表信息
		Collection checkList = new ArrayList();
		System.out.println("start to search,please waiting ...");
		
		checkList = (Collection) uiCheckAction.findByConditions(conditions);
		
		PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
		prpLcheckDto.setCheckList(checkList);
		
		prpLcheckDto.setEditType(String.valueOf(httpServletRequest.getAttribute("editType_"+index)));
		httpServletRequest.setAttribute("prpLcheckDto_"+index, prpLcheckDto);
		//设置工作流下一个节点提交的配置信息
		getSubmitNodes(httpServletRequest,index);
	}
	
	//add by zhaolu 20060802 start
	//reason:增加分页查询
	public void setPrpLcheckDtoToView(HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto,String pageNo,String recordPerPage) throws Exception {
		//根据输入的保单号，查勘号生成SQL where 子句
		String claimNo = StringUtils.rightTrim(workFlowQueryDto.getClaimNo());
		String registNo = StringUtils.rightTrim(workFlowQueryDto.getRegistNo());
		String licenseNo = StringUtils.rightTrim(workFlowQueryDto.getLicenseNo());
		String status = StringUtils.rightTrim(workFlowQueryDto.getStatus());
		String operateDate = StringUtils.rightTrim(workFlowQueryDto.getOperateDate());
		String policyNo = StringUtils.rightTrim(workFlowQueryDto.getPolicyNo());
		String insuredName = StringUtils.rightTrim(workFlowQueryDto.getInsuredName());
		int intPageNo = Integer.parseInt(pageNo);
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		String conditions = " 1=1 ";
		conditions = conditions
		+ StringConvert.convertString("a.registNo", registNo,
				workFlowQueryDto.getRegistNoSign());
		conditions = conditions
		+ StringConvert.convertString("a.claimNo", claimNo,
				workFlowQueryDto.getClaimNoSign());
		//add by zhouliu start at 2006-6-9
		//reason:强三查询
		conditions = conditions
		+ StringConvert.convertString("d.policyNo", policyNo, 
				workFlowQueryDto.getPolicyNoSign());
		//add by zhouliu end at 2006-6-9
		conditions = conditions
		+ StringConvert.convertString("c.LicenseNo", licenseNo,
				workFlowQueryDto.getLicenseNoSign());
		//添加被保险人查询条件 2006-04-12 miaowenjun
		conditions = conditions
				+ StringConvert.convertString("c.InsuredName", insuredName,
						workFlowQueryDto.getInsuredNameSign());
		if (status.trim().length() > 0) {
			conditions = conditions + " AND b.status in ('" + status + "')";
		}
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions
			+ StringConvert.convertDate("b.operateDate", operateDate,
					workFlowQueryDto.getOperateDateSign());
		}
		
		
	    // 拼权限
		//modify by zhaolu 20060816 start
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
		.getAttribute("user");
		
		//modify by zhaolu 20060816 end
		//modify by wangwei add start 2005-06-13
		//原因：需要根据不同的条件查询意键险和非意健险
		if (httpServletRequest.getParameter("type") != null
				&& httpServletRequest.getParameter("type").equals("acci")) {
			//modify by  都邦项目组  孙兆云  27险类修改为07
			conditions = conditions
			+ " and (b.riskcode like '07%' or b.riskcode like '26%')";
		} else {
			conditions = conditions
			+ " and b.riskcode not like '07%' and b.riskcode not like '26%'";
		}
		
		//modify by wangwei add end 2005-06-13    
		
		//     因为prplcheck表中无comcode字段，不符合使用addPower的条件，所以使用报案表prpLregist关联控制
		//modify by zhaolu 20060816 start
		
		conditions = conditions
	   	+ uiPowerInterface.addPower(userDto,"c","","ComCode");
	
		//modify by zhaolu 20060816 end

		String condition = httpServletRequest.getParameter("condition");
		if(condition != null)
		{
			conditions = condition;
		}
		
		//查询预赔信息
		UICheckAction uiCheckAction = new UICheckAction();
		
		//得到多行查勘主表信息
		ArrayList checkList = new ArrayList();
		//Collection checkList = new ArrayList();
		
		PageRecord pageRecord = null;
		
		System.out.println("start to search,please waiting ...");
		
		//modify by wangwei add start 2005-06-18
		//原因：意健险和非意健险查询不同的表
		if (httpServletRequest.getParameter("type") != null
				&& httpServletRequest.getParameter("type").equals("acci")) {
			//checkList = (Collection) uiCheckAction
			//.findByQueryConditionsAcci(conditions);
			pageRecord = (PageRecord)uiCheckAction.findByQueryConditionsAcci(conditions,intPageNo,intRecordPerPage);
			checkList = (ArrayList)pageRecord.getResult();
			
		} else {
			
			//checkList = (Collection) uiCheckAction
			//.findByQueryConditions(conditions);
			pageRecord = (PageRecord)uiCheckAction.findByQueryConditions(conditions,intPageNo,intRecordPerPage);
			checkList = (ArrayList)pageRecord.getResult();
		}
		//modify by wangwei add end 2005-06-18
		TurnPageDto turnPageDto = new TurnPageDto();
		turnPageDto.setResultList(checkList);
		turnPageDto.setPageNo(pageRecord.getPageNo());
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		turnPageDto.setTotalCount(pageRecord.getCount());
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		turnPageDto.setCondition(conditions);
		System.out.println("end search,please waiting for result...");
		PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
		prpLcheckDto.setCheckList(checkList);
		prpLcheckDto.setTurnPageDto(turnPageDto);
		System.out.println("finish add list");
		System.out.println("editType="
				+ httpServletRequest.getParameter("editType"));
		prpLcheckDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcheckDto", prpLcheckDto);
	}
	//add by zhaolu 20060802 end
	
	
	/**
	 * 根据PrpCheckDto中的各子表内的信息填充界面
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param checkDto
	 *            查勘的数据类
	 * @throws Exception
	 */
	private void setSubInfo(HttpServletRequest httpServletRequest,
			CheckDto checkDto,int index) throws Exception {
		
		//给报案信息补充说明多行列表准备数据
		Collection arrayListRegistExt = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = new PrpLregistExtDto();
		prpLregistExtDto.setRegistNo(checkDto.getPrpLcheckDto().getRegistNo());
		prpLregistExtDto.setRiskCode(checkDto.getPrpLcheckDto().getRiskCode());
		arrayListRegistExt = checkDto.getPrpLregistExtDtoList();
		prpLregistExtDto.setRegistExtList(arrayListRegistExt);
		httpServletRequest.setAttribute("prpLregistExtDto_"+index, prpLregistExtDto);
		
		//[查勘报告]给报案文件多行列表准备数据
		PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
		String tempContext = "";
		if (checkDto.getPrpLregistTextDtoList() != null) {
			Iterator iterator = checkDto.getPrpLregistTextDtoList().iterator();
			while (iterator.hasNext()) {
				PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto) iterator
				.next();
				if(prpLregistTextDtoTemp.getTextType().equals("1") || prpLregistTextDtoTemp.getTextType().equals("3")){
					tempContext = tempContext + prpLregistTextDtoTemp.getContext();
				}
			}
		}
		prpLregistTextDto.setContext(tempContext);
		prpLregistTextDto.setTextType("3");
		httpServletRequest.setAttribute("prpLregistTextDto_"+index, prpLregistTextDto);
		
		if(checkDto.getPrpLregistTextDtoList3() != null){
			httpServletRequest.setAttribute("prpLregistTextDtoList3_"+index, checkDto.getPrpLregistTextDtoList3());
		}
		
		//[查勘信息]查勘报告多行列表准备数据
		/*
		 * Collection arrayLTextList = new ArrayList(); PrpLregistTextDto
		 * prpLregistTextDto = new PrpLregistTextDto();
		 * prpLregistTextDto.setTextType("3") ; arrayLTextList =
		 * checkDto.getPrpLregistTextDtoList() ;
		 * prpLregistTextDto.setRegistTextList(arrayLTextList) ;
		 * httpServletRequest.setAttribute("prpLregistTextDto",
		 * prpLregistTextDto);
		 */
		//查勘扩展信息多行列表准备数据
		Collection arrayList1 = new ArrayList();
		PrpLcheckExtDto prpLcheckExtDto = new PrpLcheckExtDto();
		arrayList1 = checkDto.getPrpLcheckExtDtoList();
		prpLcheckExtDto.setPrpLcheckExtList(arrayList1);
		httpServletRequest.setAttribute("prpLcheckExtDto_"+index, prpLcheckExtDto);
		
		//事故估损金额多行列表准备数据
		ArrayList arrayList2 = new ArrayList();
		PrpLcheckLossDto prpLcheckLossDto = new PrpLcheckLossDto();
		arrayList2 = checkDto.getPrpLcheckLossDtoList();
		if (arrayList2 != null) {
			for (int indexCheck = 0; indexCheck < arrayList2.size(); indexCheck++) {
				PrpLcheckLossDto prpLcheckLossDto1 = new PrpLcheckLossDto();
				prpLcheckLossDto1 = (PrpLcheckLossDto) arrayList2
				.get(indexCheck);
				
				UICodeAction uiCodeAction = new UICodeAction();
				//对险别进行转换
				String kindCode = prpLcheckLossDto1.getKindCode();
				String kindName = uiCodeAction.translateKindCode(
						BusinessRuleUtil.getOuterCode(httpServletRequest,
						"RISKCODE_DAA"), kindCode, true);
				prpLcheckLossDto1.setKindName(kindName);
			}
		}
		prpLcheckLossDto.setPrpLcheckLossList(arrayList2);
		httpServletRequest.setAttribute("prpLcheckLossDto_"+index, prpLcheckLossDto);
				
		//modify by wangli add start 20050407
		//查询保单信息 显示特别约定列表
		String policyNo = checkDto.getPrpLcheckDto().getPolicyNo();
		ArrayList itemKindList = new ArrayList();
		Collection itemKindListNew = new ArrayList();
		//根据保单号查询特别约定信息
		String registNo = checkDto.getPrpLcheckDto().getRegistNo();
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		
		if (!policyNo.equals("") && policyNo != null) {
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
					policyNo, registDto.getPrpLregistDto().getDamageStartDate()
					.toString(), registDto.getPrpLregistDto()
					.getDamageStartHour());
			
			itemKindList = policyDto.getPrpCitemKindDtoList();
			checkDto.setPrpCengageDtoList(policyDto.getPrpCengageDtoList());
		}
		//特别约定信息多行列表准备数据
		Collection cengageList = new ArrayList();
		PrpCengageDto prpCengageDto = new PrpCengageDto();
		cengageList = checkDto.getPrpCengageDtoList();
		ArrayList cengageListTemp = new ArrayList();
		if (cengageList != null) {
			Iterator iteratorCengage = cengageList.iterator();
			while (iteratorCengage.hasNext()) {
				PrpCengageDto prpCengageDtoTemp = (PrpCengageDto) iteratorCengage
				.next();
				if (prpCengageDtoTemp.getClauseCode() != null
						&& prpCengageDtoTemp.getClauseCode().length() > 0
						&& prpCengageDtoTemp.getClauseCode().charAt(0) == 'T') {
					cengageListTemp.add(prpCengageDtoTemp);
				}
			}
			boolean cFlag = false;
			cengageList = new ArrayList();
			cengageList.addAll(cengageListTemp);
			cengageListTemp = new ArrayList();
			iteratorCengage = cengageList.iterator();
			PrpCengageDto prpCengageDtoTemp1 = new PrpCengageDto();
			while (iteratorCengage.hasNext()) {
				PrpCengageDto prpCengageDtoTemp = (PrpCengageDto) iteratorCengage
				.next();
				if (prpCengageDtoTemp.getTitleFlag().equals("0")) {
					cFlag = true;
					cengageListTemp.add(prpCengageDtoTemp1);
					prpCengageDtoTemp1 = new PrpCengageDto();
					PropertyUtils.copyProperties(prpCengageDtoTemp1,
							prpCengageDtoTemp);
				} else {
					prpCengageDtoTemp1.setContext(prpCengageDtoTemp1
							.getContext()
							+ prpCengageDtoTemp.getClauses() + "<br>");
				}
			}
			cengageListTemp.add(prpCengageDtoTemp1);
			if (cengageListTemp.size() > 0) {
				cengageListTemp.remove(0);
			}
		}
		prpCengageDto.setPrpCengageList(cengageListTemp);
		httpServletRequest.setAttribute("prpCengageDto_"+index, prpCengageDto);
		//modify by wangli add end 20050407
		
		//Modify by chenrenda add 20050409 begin
		//Reason:人伤跟踪信息模块中涉及险种以列表框多选形式显示
		//将险别名称改成D1-车上人员责任险的方式,只包括三者险与车上人员责任险
		
		Collection prpLcheckInsuredItemKindNew = new ArrayList();
		Collection prpLcheckThirdItemKindNew = new ArrayList();
		/*------------------------------------------
		for (int i = 0; i < itemKindList.size(); i++) {
			PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) itemKindList
			.get(i);
			prpCitemKindDto.setKindName(prpCitemKindDto.getKindCode() + "-"
					+ prpCitemKindDto.getKindName());
			if (prpCitemKindDto.getKindCode().equalsIgnoreCase("B")
					|| prpCitemKindDto.getKindCode().equalsIgnoreCase("D3")
					|| prpCitemKindDto.getKindCode().equalsIgnoreCase("D4")
					|| prpCitemKindDto.getKindCode().equalsIgnoreCase("A")
					|| prpCitemKindDto.getKindCode().equalsIgnoreCase("BZ")) {
				itemKindListNew.add(prpCitemKindDto);
			}
			prpLcheckItemKindNew.add(prpCitemKindDto);
		}------------------------------------------------*/
	
		itemKindListNew = BusinessRuleUtil.getReferItemKindListByKindType("ThirdPersonLoss",itemKindList);
		Collection prpLcheckItemKindNew = new ArrayList();
		Collection prpLcheckPropItemKindNew = new ArrayList();
		prpLcheckPropItemKindNew =BusinessRuleUtil.getReferItemKindListByKindType("ThirdPropLoss",itemKindList);
		prpLcheckItemKindNew =BusinessRuleUtil.getReferItemKindListByKindType("MainCarLoss",itemKindList);
		prpLcheckThirdItemKindNew =BusinessRuleUtil.getReferItemKindListByKindType("ThirdCarLoss",itemKindList);
		prpLcheckItemKindNew.addAll(prpLcheckThirdItemKindNew);
		httpServletRequest.setAttribute("referKindList_"+index, itemKindListNew);
		httpServletRequest.setAttribute("prpLcheckPropItemKindList_"+index, prpLcheckPropItemKindNew);
		httpServletRequest.setAttribute("prpLcheckItemKindList_"+index,
				prpLcheckItemKindNew); 
		
		
				
		//Modify by chenrenda add 20050409 end
		
		//Modify by chenrenda add begin 20050408
		
		//Reason:损失部位显示改为列表框方式
		httpServletRequest.setAttribute("partCodeList_"+index, ICollections
				.getPartCodeList());
		//Modify by chenrenda add end 20050408
		
		//Modify by chenrenda add begin 20050412
		//Reason:在查勘页面中加上其它损失模块
		Collection arrayListThirdProp = new ArrayList();
		PrpLthirdPropDto prpLthirdPropDto = new PrpLthirdPropDto();
		arrayListThirdProp = checkDto.getPrpLthirdPropDtoList();
		prpLthirdPropDto.setThirdPropList(arrayListThirdProp);
		//prpLthirdPropDto.setPrpLthirdPropKindCode("B");
		httpServletRequest.setAttribute("prpLthirdPropDto_"+index, prpLthirdPropDto);
		
		//Modify by chenrenda add end 20050412
		
	}
	
	
	/**
	 * 根据PrpCheckDto中的已经设置的代码内容，对代码进行名称转换
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param prpLcheckDto
	 *            查勘的数据类
	 * @throws Exception
	 */
	private void changeCodeToName(HttpServletRequest httpServletRequest,
			PrpLcheckDto prpLcheckDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		//(1)条款名称的转换
		String clauseType = prpLcheckDto.getClauseType();
		String clauseName = uiCodeAction.translateCodeCode("ClauseType",
				clauseType, true);
		prpLcheckDto.setClauseName(clauseName);
		prpLcheckDto.setDamageAreaName(uiCodeAction.translateCodeCode(
				"DamageAreaCode", prpLcheckDto.getDamageAreaCode(), true));
		
		//(2)处理部门的中文转换
		String strHandleUnit = prpLcheckDto.getHandleUnit();
		String strHandleUnitName = uiCodeAction.translateComCode(strHandleUnit,
				true);
		
		//System.out.println("strHandleUnitName
		// =================================="+strHandleUnitName );;
		prpLcheckDto.setHandleUnitName(strHandleUnitName);
	}
	
	public void getCheckScheduleDtoToView(HttpServletRequest httpServletRequest)
	throws Exception {
		//取得当前用户信息，写操作员信息到查勘中
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		// 目的是取得没有被处理完毕的调度任务，然后list出来。
		Collection scheduleDtoList = new ArrayList();
		UICheckAction uiCheckAction = new UICheckAction();
		//查找符合条件的调度任务
		String conditions = "";
		//conditions = " CheckFlag='0' order by registNo,scheduleid " ;
		conditions = " selectSend='1' and insurecarflag='1' order by registNo,scheduleid";
		
		System.out.println("搜索前.");
		scheduleDtoList = (Collection) uiCheckAction
		.findNewScheduleTaskList(conditions);
		System.out.println("搜索后." + scheduleDtoList.toString());
		PrpLcheckItemDto prpLcheckItemDto = new PrpLcheckItemDto();
		
		scheduleDtoList = changeOperatorCodeToName(scheduleDtoList);
		prpLcheckItemDto.setCheckItemList(scheduleDtoList);
		// prpLcheckItemDto.setCheckOperatorCode(user.getUserCode() );
		//将查询出来的 任务列表放到界面上显示
		// httpServletRequest.setAttribute("prpLscheduleMainWFDto",prpLscheduleMainWFDto)
		// ;
		httpServletRequest.setAttribute("prpLcheckItemDto", prpLcheckItemDto);
		
	}
	
	private Collection changeOperatorCodeToName(Collection scheduleList)
	throws Exception {
		Collection scheduleListChange = new ArrayList();
		Iterator it = scheduleList.iterator();
		UICodeAction uiCodeAction = new UICodeAction();
		
		String operatorCode = "";
		String operatorName = "";
		while (it.hasNext()) {
			PrpLcheckItemDto prpLcheckItemDto = new PrpLcheckItemDto();
			prpLcheckItemDto = (PrpLcheckItemDto) it.next();
			operatorCode = prpLcheckItemDto.getOperatorCode();
			operatorName = uiCodeAction.translateUserCode(operatorCode, true);
			prpLcheckItemDto.setOperatorName(operatorName);
			scheduleListChange.add(prpLcheckItemDto);
		}
		return scheduleListChange;
	}
	
	public void getCheckScheduleDealDtoToView(
			HttpServletRequest httpServletRequest, String registNo,
			String scheduleID) throws Exception {
		
		//取得当前用户信息，写操作员信息到查勘中
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		int intscheduleID = Integer.parseInt(scheduleID);
		
		UIScheduleAction uiScheduleAction = new UIScheduleAction();
		ScheduleDto scheduleDto = uiScheduleAction.findByPrimaryKey(
				intscheduleID, registNo);
		
		//根据查询出来的数据内容，给PrpLscheduleDto赋值
		PrpLscheduleMainWFDto prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();
		prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto();
		
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		
		//设置扩展属性
		prpLscheduleMainWFDto.setLinkerName(registDto.getPrpLregistDto()
				.getLinkerName());
		prpLscheduleMainWFDto.setPhoneNumber(registDto.getPrpLregistDto()
				.getPhoneNumber());
		//prpLscheduleMainWFDto.setOperatorName(user.getUserName() );
		if (registDto.getPrpLregistTextDtoList() != null) {
			PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
			prpLregistTextDto = (PrpLregistTextDto) registDto
			.getPrpLregistTextDtoList().iterator().next();
			prpLscheduleMainWFDto.setRegistText(prpLregistTextDto.getContext());
		}
		
		//设置查勘操作的状态为 案件修改 (正处理任务)
		if (scheduleDto.getPrpLclaimStatusDto() != null) {
			prpLscheduleMainWFDto.setStatus(scheduleDto
					.getPrpLscheduleMainWFDto().getStatus());
		} else {
			//已提交，已经处理完毕的状态
			prpLscheduleMainWFDto.setStatus("4");
		}
		
		scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
		
		//设置相关代码的中文转换
		//changeCodeToName(httpServletRequest,scheduleDto);
		//设置窗体表单中各个多选框中列表信息的内容
		// setSelectionList(httpServletRequest,scheduleDto);
		//设置主查勘信息内容到窗体表单
		httpServletRequest.setAttribute("prpLscheduleMainWFDto",
				prpLscheduleMainWFDto);
		//设置各个子表信息项到窗体表单
		setCheckItemInfo(httpServletRequest, scheduleDto);
	}
	
	/**
	 * 根据Dto中的各子表内的信息填充界面
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param scheduleDto
	 *            查勘的数据类
	 * @throws Exception
	 */
	private void setCheckItemInfo(HttpServletRequest httpServletRequest,
			ScheduleDto scheduleDto) throws Exception {
		ArrayList checkItemList = new ArrayList();
		checkItemList = scheduleDto.getPrpLcheckItemDtoList();
		/*
		 * Iterator it = scheduleItemList.iterator() ; int i =1;
		 * 
		 * while (it.hasNext() ) { PrpLscheduleItemDto prpLscheduleItemDto =new
		 * PrpLscheduleItemDto(); prpLthirdPartyTempDto
		 * =(PrpLthirdPartyDto)it.next() ; prpLscheduleItemDto.setScheduleID
		 * (scheduleDto.getPrpLscheduleMainWFDto().getScheduleID() );
		 * prpLscheduleItemDto.setRegistNo
		 * (scheduleDto.getPrpLscheduleMainWFDto().getRegistNo());
		 * prpLscheduleItemDto.setItemNo (i);
		 * prpLscheduleItemDto.setInsureCarFlag
		 * (prpLthirdPartyTempDto.getInsureCarFlag ());
		 * prpLscheduleItemDto.setClaimComCode
		 * (scheduleDto.getPrpLscheduleMainWFDto().getClaimComCode ());
		 * //prpLscheduleItemDto.setSelectSend ("0");
		 * //prpLscheduleItemDto.setSurveyTimes ();
		 * //prpLscheduleItemDto.setSurveyType
		 * (prpLthirdPartyTempDto.getSurveyType ());
		 * //prpLscheduleItemDto.setCheckSite
		 * (prpLthirdPartyTempDto.getCheckSite ());
		 * prpLscheduleItemDto.setLicenseNo (prpLthirdPartyTempDto.getLicenseNo
		 * ()); //prpLscheduleItemDto.setScheduleObjectID
		 * (prpLthirdPartyTempDto.getScheduleObjectID ());
		 * //prpLscheduleItemDto.setScheduleObjectName
		 * (prpLthirdPartyTempDto.getScheduleObjectName());
		 * prpLscheduleItemDto.setInputDate (new
		 * DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY)); //
		 * prpLscheduleItemDto.setResultInfo
		 * (prpLthirdPartyTempDto.getResultInfo ()); //
		 * prpLscheduleItemDto.setBookFlag (prpLthirdPartyTempDto.getBookFlag
		 * ()); // prpLscheduleItemDto.setScheduleType
		 * (prpLthirdPartyTempDto.getScheduleType ()); //加入集合
		 * scheduleItemList.add(prpLscheduleItemDto); i++; }
		 */
		scheduleDto.setPrpLscheduleItemDtoList(checkItemList);
		PrpLcheckItemDto prpLcheckItemDto = new PrpLcheckItemDto();
		prpLcheckItemDto.setCheckItemList(checkItemList);
		httpServletRequest.setAttribute("prpLcheckItemDto", prpLcheckItemDto);
	}
	
	/**
	 * 保存查勘时查勘页面数据整理.
	 * 
	 * @param httpServletRequest
	 * @return scheduleDto 查勘数据传输数据结构
	 * @throws Exception
	 */
	public ScheduleDto checkViewToDto(HttpServletRequest httpServletRequest)
	throws Exception {
		//取得当前用户信息，写操作员信息到查勘中
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		String registNo = httpServletRequest
		.getParameter("prpLscheduleMainWFRegistNo"); //报案号
		String scheduleID = httpServletRequest
		.getParameter("prpLscheduleMainWFScheduleID"); //调度号
		String prpLscheduleMainWFCheckFlag = httpServletRequest
		.getParameter("prpLscheduleMainWFCheckFlag"); //查勘状态
		String prpLscheduleMainWFCheckInfo = httpServletRequest
		.getParameter("prpLscheduleMainWFCheckInfo"); //查勘情况内容
		//String prpLscheduleMainWFCheckInputDate=
		String prpLscheduleMainWFCheckOperatorCode = user.getUserCode();
		int intscheduleID = Integer.parseInt(scheduleID);
		
		//首先从数据库中取得调度的所有信息
		UIScheduleAction uiScheduleAction = new UIScheduleAction();
		ScheduleDto scheduleDto = uiScheduleAction.findByPrimaryKey(
				intscheduleID, registNo);
		
		//根据查询出来的数据内容，给PrpLscheduleDto赋值
		PrpLscheduleMainWFDto prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();
		prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto();
		prpLscheduleMainWFDto.setCheckFlag(prpLscheduleMainWFCheckFlag);
		prpLscheduleMainWFDto.setCheckInfo(prpLscheduleMainWFCheckInfo);
		prpLscheduleMainWFDto.setCheckInputDate(new DateTime(DateTime.current()
				.toString(), DateTime.YEAR_TO_DAY));
		prpLscheduleMainWFDto
		.setCheckOperatorCode(prpLscheduleMainWFCheckOperatorCode);
		scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
		
		//-------------完成主表控制-------------------------------
		ArrayList checkItemList = new ArrayList();
		ArrayList checkItemListTemp = new ArrayList();
		checkItemListTemp = scheduleDto.getPrpLcheckItemDtoList();
		Iterator it = checkItemListTemp.iterator();
		while (it.hasNext()) {
			PrpLcheckItemDto prpLcheckItemDto = new PrpLcheckItemDto();
			prpLcheckItemDto = (PrpLcheckItemDto) it.next();
			prpLcheckItemDto.setCheckFlag(prpLscheduleMainWFCheckFlag);
			prpLcheckItemDto.setCheckInfo(prpLscheduleMainWFCheckInfo);
			//prpLcheckItemDto.setInputDate(new
			// DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
			prpLcheckItemDto
			.setCheckOperatorCode(prpLscheduleMainWFCheckOperatorCode);
			//加入查勘标的集合
			checkItemList.add(prpLcheckItemDto);
		}
		// 调度集合中修改查勘标的
		scheduleDto.setPrpLcheckItemDtoList(checkItemList);
		return scheduleDto;
	}
	
	/**
	 * 根据赔案号,报案号,案件状态，车牌号码，操作时间查询查勘信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param claimNo
	 *            赔案号
	 * @param registNo
	 *            报案号
	 * @param licenseNo
	 *            车牌号
	 * @throws Exception
	 *             Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件
	 */
	
	public void setPrpLcheckDtoToView(HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto) throws Exception {
		//根据输入的保单号，查勘号生成SQL where 子句
		String claimNo = StringUtils.rightTrim(workFlowQueryDto.getClaimNo());
		String registNo = StringUtils.rightTrim(workFlowQueryDto.getRegistNo());
		String licenseNo = StringUtils.rightTrim(workFlowQueryDto.getLicenseNo());
		String status = StringUtils.rightTrim(workFlowQueryDto.getStatus());
		String operateDate = StringUtils.rightTrim(workFlowQueryDto.getOperateDate());
		String policyNo = StringUtils.rightTrim(workFlowQueryDto.getPolicyNo());
		String insuredName = StringUtils.rightTrim(workFlowQueryDto.getInsuredName());
		String conditions = " 1=1 ";
		conditions = conditions
		+ StringConvert.convertString("a.registNo", registNo,
				workFlowQueryDto.getRegistNoSign());
		conditions = conditions
		+ StringConvert.convertString("a.claimNo", claimNo,
				workFlowQueryDto.getClaimNoSign());
		//add by zhouliu start at 2006-6-9
		//reason:强三查询
		conditions = conditions
		+ StringConvert.convertString("d.policyNo", policyNo, 
				workFlowQueryDto.getPolicyNoSign());
		//add by zhouliu end at 2006-6-9
		conditions = conditions
		+ StringConvert.convertString("c.LicenseNo", licenseNo,
				workFlowQueryDto.getLicenseNoSign());
		//添加被保险人查询条件 2006-04-12 miaowenjun
		conditions = conditions
				+ StringConvert.convertString("c.InsuredName", insuredName,
						workFlowQueryDto.getInsuredNameSign());
		if (status.trim().length() > 0) {
			conditions = conditions + " AND b.status in ('" + status + "')";
		}
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions
			+ StringConvert.convertDate("b.operateDate", operateDate,
					workFlowQueryDto.getOperateDateSign());
		}
		//     拼权限
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
		.getAttribute("user");
		
		//modify by wangwei add start 2005-06-13
		//原因：需要根据不同的条件查询意键险和非意健险
		if (httpServletRequest.getParameter("type") != null
				&& httpServletRequest.getParameter("type").equals("acci")) {
			//modify by   项目组  孙兆云  27险类修改为07
			conditions = conditions
			+ " and (b.riskcode like '07%' or b.riskcode like '26%')";
		} else {
			conditions = conditions
			+ " and b.riskcode not like '07%' and b.riskcode not like '26%'";
		}
		//modify by wangwei add end 2005-06-13    
		
		//     因为prplcheck表中无comcode字段，不符合使用addPower的条件，所以使用报案表prpLregist关联控制
		conditions = conditions
		+ uiPowerInterface.addPower(userDto,"c","","ComCode");
		
		//查询预赔信息
		UICheckAction uiCheckAction = new UICheckAction();
		
		//得到多行查勘主表信息
		Collection checkList = new ArrayList();
		System.out.println("start to search,please waiting ...");
		
		//modify by wangwei add start 2005-06-18
		//原因：意健险和非意健险查询不同的表
		if (httpServletRequest.getParameter("type") != null
				&& httpServletRequest.getParameter("type").equals("acci")) {
			checkList = (Collection) uiCheckAction
			.findByQueryConditionsAcci(conditions);
		} else {
			checkList = (Collection) uiCheckAction
			.findByQueryConditions(conditions);
		}
		//modify by wangwei add end 2005-06-18
		
		System.out.println("end search,please waiting for result...");
		PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
		prpLcheckDto.setCheckList(checkList);
		System.out.println("finish add list");
		System.out.println("editType="
				+ httpServletRequest.getParameter("editType"));
		prpLcheckDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcheckDto", prpLcheckDto);
	}
	
	/**
	 * 查询工作流可以用来选择的节点内容
	 * 
	 * @param modelNo
	 *            String
	 * @param nodeNo
	 *            String
	 * @throws Exception
	 */
	private void getSubmitNodes(HttpServletRequest httpServletRequest,int index)
	throws Exception {
		String modelNo = String.valueOf(httpServletRequest.getAttribute("modelNo_"+index)); //模板号
		String nodeNo = String.valueOf(httpServletRequest.getAttribute("nodeNo_"+index)); //节点号
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
		httpServletRequest.setAttribute("pathList_"+index, pathList);
		httpServletRequest.setAttribute("swfPathDto_"+index, swfPathDto);
	}
	/**
	 * 根据报案号码查询定损信息相关的数据显示在页面上
	 * 国元项目组
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param PrpLverifyLossDto
	 *            取出的初始化信息Dto
	 * @throws Exception
	 */
	public void PrpLverifyLossDtoToView(HttpServletRequest httpServletRequest,
			String registNo,int index) throws Exception {
		if (registNo.length() > 21) {
			registNo = registNo.substring(0, 21);
		}
		PrpLpropDto prpLpropDto = new PrpLpropDto();
		UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
		String conditions = "registNo='" + registNo + "'";
		Collection collection = (Collection) uiVerifyLossAction
				.findByConditions(conditions);
		Iterator iterator = collection.iterator();
		PrpLverifyLossDto prpLverifyLossDto = (PrpLverifyLossDto) iterator
				.next();
		httpServletRequest.setAttribute("prpLverifyLossDto_"+index, prpLverifyLossDto);
	}
	/**
	 * 根据报案号码查询定损险别估损信息
	 * 国元项目组
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param PrpLverifyLossDto
	 *            取出的初始化信息Dto
	 * @throws Exception
	 */
	public void verifyLossDtoToView(HttpServletRequest httpServletRequest,
			String registNo,int index) throws Exception {
		if (registNo.length() > 21) {
			registNo = registNo.substring(0, 21);
		}
		VerifyLossDto verifyLossDto = new VerifyLossDto();
		BLVerifyLossFacade bLVerifyLossFacade = new BLVerifyLossFacade();
		verifyLossDto = bLVerifyLossFacade.findByPrimaryKey(registNo, null,
				null);
		httpServletRequest.setAttribute("prpLpropDtoList_"+index, verifyLossDto
				.getPrpLpropDtoList());
		
	}
	/**
	 * 根据报案号码查询定损险别估损信息
	 * 国元项目组
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param PrpLverifyLossDto
	 *            取出的初始化信息Dto
	 * @throws Exception
	 */
	public void addVerifyLossDtoToView(HttpServletRequest httpServletRequest,
			String registNo,int index) throws Exception {
		if (registNo.length() > 21) {
			registNo = registNo.substring(0, 21);
		}
		VerifyLossDto verifyLossDto = new VerifyLossDto();
		BLVerifyLossFacade bLVerifyLossFacade = new BLVerifyLossFacade();
		verifyLossDto = bLVerifyLossFacade.findByPrimaryKey(registNo, null,
				null);
		
		PrpLpropDto prpLpropDto = new PrpLpropDto();
		prpLpropDto.setPolicyNo(httpServletRequest.getParameter("policyNo"));
		prpLpropDto.setRiskCode(httpServletRequest.getParameter("riskCode"));
		prpLpropDto.setClaimNo("");
		prpLpropDto.setRegistNo(String.valueOf(httpServletRequest.getAttribute("RegistNo_"+index)));
		PrpCvirturlItemSchema prpCvirturlItemSchema = Utils.findPrpCvirturlItemSchema(httpServletRequest.getParameter("policyNo"),httpServletRequest.getParameter("riskCode"));
		
		
		prpLpropDto.setFamilyNo(Integer.parseInt(DataUtils
				.nullToZero(prpCvirturlItemSchema.getFamilyNo())));
		prpLpropDto.setFamilyName(prpCvirturlItemSchema.getFamilyName());
	
		PrpCvirturlItemSchema prpCvirturlItemSchema1 = Utils.findPrpCvirturlItemSchema(httpServletRequest.getParameter("policyNo"),httpServletRequest.getParameter("riskCode"),String.valueOf(prpLpropDto.getFamilyNo()),
		httpServletRequest.getParameter("prpLcheckDamageStartDate_"+index));
		
		prpLpropDto.setKindName(prpCvirturlItemSchema1.getKindName());
		prpLpropDto.setKindCode(prpCvirturlItemSchema1.getKindCode());
		prpLpropDto.setLossItemName             ( prpCvirturlItemSchema1.getItemDetailName());
		prpLpropDto.setItemKindNo(Integer.parseInt(DataUtils
				.nullToZero(prpCvirturlItemSchema1.getItemKindNo())));
		prpLpropDto.setItemCode(prpCvirturlItemSchema1.getItemCode());		

		prpLpropDto.setSerialNo                 ( 1);
		prpLpropDto.setLossItemCode             ("-2");
		/*prpLpropDto.setFeeTypeCode              ("");
		prpLpropDto.setFeeTypeName              ("");*/
	
	    prpLpropDto.setCurrency                 ( "CNY");
		prpLpropDto.setUnitPrice                ( 0);
		prpLpropDto.setLossQuantity             (0);
		/*prpLpropDto.setUnit                     ( "xxx");*/
		prpLpropDto.setBuyDate                  ( new DateTime(new Date(),DateTime.YEAR_TO_DAY));

		/*prpLpropDto.setDepreRate                ( 0);
		prpLpropDto.setSumLoss                  ( 0);
		prpLpropDto.setSumReject                ( 0);
		prpLpropDto.setRejectReason             ( "xx");
		prpLpropDto.setLossRate                 ( 0);
		prpLpropDto.setSumDefLoss               ( 0);
		prpLpropDto.setRemark                   ( "xxxxxxx");
		prpLpropDto.setVeriUnitPrice            ( 0);
		prpLpropDto.setVeriLossQuantity         ( 0);
		prpLpropDto.setVeriUnit                 ( "xxxxxxxxxxxxxxxxxxx");
		prpLpropDto.setVeriDepreRate            ( 0);
		prpLpropDto.setVeriSumLoss              ( 0);
		prpLpropDto.setVeriSumReject            ( 0);
		prpLpropDto.setVeriRejectReason         ( "xxxxxxxxxxx");
		prpLpropDto.setVeriLossRate             ( 0);
		prpLpropDto.setVeriSumDefLoss           ( 0);
		prpLpropDto.setVeriRemark               ( "xxxxxxxxxxxx");
		prpLpropDto.setFlag                     ( "xxxxxxxxxxx");
       
        	prpLpropDto.setCompensateBackFlag       ( "xxxxxxxxx");*/
        
        ArrayList prpLpropDtoList =	new ArrayList();prpLpropDtoList.add(prpLpropDto);
        
		httpServletRequest.setAttribute("prpLpropDtoList_"+index, prpLpropDtoList);
		//httpServletRequest.setAttribute("prpLpropDtoList_"+index, verifyLossDto
		//		.getPrpLpropDtoList());
		
	}
	
}