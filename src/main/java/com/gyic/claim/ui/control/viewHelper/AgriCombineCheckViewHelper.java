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
 * Description:�鿱ViewHelper�࣬�ڸ��������ҳ�����ݵ�����
 * </p>
 * <p>
 * Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004
 * </p>
 * 
 * @author ����������Ŀ�� liubvo
 * @version 1.0 <br>
 */

public class AgriCombineCheckViewHelper{
	
	 private int RULE_LENGTH = 70; //rule�ֶεĳ���  
	 /**
	 * Ĭ�Ϲ��췽��
	 */
	public AgriCombineCheckViewHelper() {
	}

	   /**
	    * ����鿱ʱ�鿱ҳ����������.
	    * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
	    * @param httpServletRequest
	    * @return checkDto �鿱���ݴ������ݽṹ
	    * @throws Exception
	    */
	    public CheckDto viewToDto(int combineIndex,HttpServletRequest httpServletRequest) throws Exception
	    {
	      CheckDto checkDto = new CheckDto();
	      /*---------------------�鿱����prpLcheck------------------------------------*/

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
	        //ԭ�򣺴�ҳ���л��Ԥ������Ԥ������
	        prpLcheckDto.setEstimateLoss(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLcheckEstimateLoss_"+combineIndex))));
	        prpLcheckDto.setEstimateFee(Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLcheckEstimateFee_"+combineIndex))));
	        //modify by wangwei add end 20050603
	 
	        //���� ϵͳ��ʾ �� �鿱����λ�����ֶ�
	        prpLcheckDto.setUnitType(httpServletRequest.getParameterValues("unitType")[combineIndex]);
	        prpLcheckDto.setHandleUnitCode(httpServletRequest.getParameter("prpLcheckHandleUnitCode_"+combineIndex));
	        
	        //�ӵ�ArrayList��
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
	        //ԭ������⽡�յĵ�����Ϣ
	        if ("E".equals(strRiskType)) {
	        	PrpLacciCheckDto  prpLacciCheckDto = new PrpLacciCheckDto();
	        	//prpLacciCheckDto.setCheckType(httpServletRequest.getParameter("checkType_"+combineIndex)); //��ʱ������ʾ��ʲô�ڵ��ύ�����ĵ���,�����
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
	            //�õ����Ӵ�,���潫���зֵ�����
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
	        
	        /*---------------------�ı���PrpLregistTextDto--------------------*/
	      	ArrayList prpLregistTextDtoList = new ArrayList();
	        //�õ����Ӵ�,���潫���зֵ�����
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

	        //װ��checkDto
	        checkDto.setPrpLregistTextDtoList(prpLregistTextDtoList);
	        
	        /*------------------����ԭ����ϸ��Ϣ----------------------*/
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
	        
	        
	        /*---------------------�������Ϣ��prpLcompensateear------------------------------------*/
	        ArrayList prplCompensateEarDtoList = new ArrayList();
			PrplcompensateearDto prplCompensateEarDto = null;
			
	  
			//�ӽ���õ���������
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

			//end��ֳ�ն����嵥�б��ֶζ���
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
	        
	        /*---------------------״̬����prpLclaimStatus------------------------------------*/
	        PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
	        prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
	        prpLclaimStatusDto.setBusinessNo(prpLcheckDto.getRegistNo() );
	        prpLclaimStatusDto.setPolicyNo(prpLcheckDto.getPolicyNo());
	        prpLclaimStatusDto.setNodeType("check");
	        prpLclaimStatusDto.setSerialNo(0);
	        prpLclaimStatusDto.setRiskCode(prpLcheckDto.getRiskCode());
	        System.out.println("prpLclaimStatusDto.setRiskCode(prpLcheckDto.getRiskCode()):==" + prpLcheckDto.getRiskCode());
	        //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���鿱��
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
	 * ����鿱ʱ�鿱ҳ����������. ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
	 * 
	 * @param httpServletRequest
	 * @return checkDto �鿱���ݴ������ݽṹ
	 * @throws Exception
	 */
	public CheckDto viewToDto(HttpServletRequest httpServletRequest,int combineIndex)
	throws Exception {
		//�̳ж�check,checkText��ĸ�ֵ
		CheckDto checkDto = this.viewToDto(combineIndex,httpServletRequest);
		//Modify by chenrenda add begin 20050418
		//Reason:��ʧģ����Ϣ�ϵ��永���������ˡ��Ʋ���ʧ��Ϣ��
		ArrayList prpLcheckLossDtoList = new ArrayList();
		PrpLcheckLossDto prpLcheckLossDto = null;
		int intCheckLossIndex = 1;//���
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
		//reason: ��Ϊ���ǵ�¼���ʱ�򣬿���û���������������ύ��ʱ����������������������ûд�롣
		//��ȡ�������룬����Ҫ����Ҫ��ҳ����ȡ�á�����
		String claimNo=prpLcheckLossClaimNo;
		if (claimNo==null||claimNo.length()<2){
			UICodeAction uiCodeAction = new UICodeAction();
			claimNo=uiCodeAction.translateBusinessCode(prpLcheckLossRegistNo ,true);
		}
		
		//add by lixiang end at 2005-12-28
		
		
		ArrayList scheduleItemDtoList = new ArrayList();
		PrpLscheduleItemDto prpLscheduleItemDto = new PrpLscheduleItemDto();
		
		//Reason:ҳ��������������ʧģ��
		/*---------------------������ʧ��λ PrpLthirdProp begin------------------------------------*/
		ArrayList thirdPropDtoList = new ArrayList();
		PrpLthirdPropDto prpLthirdPropDto = null;
		
		//�ӽ���õ���������
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
		//Reason:��ʧģ����Ϣ�ϵ��永���������ˡ��Ʋ���ʧ��Ϣ��
		String[] prpLthirdPropKindCode = httpServletRequest
		.getParameterValues("prpLthirdPropKindCode_"+combineIndex);
		String[] prpLthirdPropLossFee = httpServletRequest
		.getParameterValues("prpLthirdPropLossFee_"+combineIndex);
		//Modify by chenrenda add end 20050418
		   String[] prpLthirdPropNewAddFlag      =httpServletRequest.getParameterValues("prpLthirdPropNewAddFlag_"+combineIndex );//�Ƿ�������Ŀ�ı�־
		   
		//����ֵ
		//��ʧ��λ���ֿ�ʼ
		if (prpLthirdPropItemNo == null) {
		} else {
			for (int index = 1; index < prpLthirdPropItemNo.length; index++) {
				
				prpLthirdPropDto = new PrpLthirdPropDto();
				
				//Modify by chenrenda update begin 20050418
				//Reason:Ԥ����ʧģ��ϵ��永������Ϣ��
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
				
				//���뼯��
				thirdPropDtoList.add(prpLthirdPropDto);
				
			}
//			���ӲƲ���ʧ���������Ϣ��������ˣ��ͽ��е���
			System.out.println(" �Ʋ���ʧ�жϿ�ʼ����������������");
			if (thirdPropDtoList != null && thirdPropDtoList.size() > 0) {
				System.out.println(" �Ʋ���ʧ�����ݡ���������������");	
		         prpLscheduleItemDto = new PrpLscheduleItemDto();
		         prpLscheduleItemDto.setScheduleID(1);
		         prpLscheduleItemDto.setRegistNo(checkDto.getPrpLcheckDto() .getRegistNo());
		         prpLscheduleItemDto.setItemNo(-1);
		         //��ʾ�Ƿ�ѡ��
		         prpLscheduleItemDto.setSelectSend("1");
		         //��ʾû�е��ȳɶ����
		         prpLscheduleItemDto.setSurveyTimes(0);
		         prpLscheduleItemDto.setSurveyType("1");
		         prpLscheduleItemDto.setCheckSite(checkDto.getPrpLcheckDto().getCheckSite() );
		         prpLscheduleItemDto.setInputDate(new DateTime(DateTime.current(),
		             DateTime.YEAR_TO_DAY));
		         prpLscheduleItemDto.setScheduleType("schel");
		         prpLscheduleItemDto.setLicenseNo("�Ʋ���ʧ");
		         prpLscheduleItemDto.setScheduleObjectID("_");
		         prpLscheduleItemDto.setScheduleObjectName(" ");
		         prpLscheduleItemDto.setNextNodeNo("propc");
		        	scheduleItemDtoList.add(prpLscheduleItemDto);

			}

			//���������м�����ʧ��λ
			checkDto.setPrpLthirdPropDtoList(thirdPropDtoList);
			}
		/*---------------------������ʧ��λ PrpLthirdProp end------------------------------------*/
		//Modify by chenrenda add end 20050407
		
        //�������ݣ���������ȵ����ݣ�������ύ��ʱ�򡣡����µ����ݷ���prplscheduleItem�У��������Ѿ����ȹ�������
        if (checkDto.getPrpLclaimStatusDto() .getStatus().equals("4")
           &&scheduleItemDtoList.size() >0 ){ //���β鿱���ҵ����µĵ�������
           //��鶨����ȵ������������ڶ�����ȣ�����Ƿ��Ѿ����ȹ������û�е��ȹ�������û�е��ȹ�����
           Collection prpLscheduleItemList = new ArrayList();
           //��ѯ���ȹ���
           String strSql =" registno ='"+checkDto.getPrpLcheckDto() .getRegistNo()
                         +"' and surveyTimes='1'";
           //��ѯ����
           UIScheduleAction uiScheduleAction=new UIScheduleAction();
           prpLscheduleItemList =uiScheduleAction.findItemByConditions(strSql) ;
           PrpLscheduleItemDto prpLscheduleItemoldDto=new PrpLscheduleItemDto();
           ArrayList scheduleItemLastList = new ArrayList();
           if (prpLscheduleItemList ==null || prpLscheduleItemList.size()<1){
              //���ü��scheduleITem�ġ���
              checkDto.setPrpLscheduleItemDtoList(scheduleItemDtoList) ;
           }else
           { //�������õ������У��Ƿ��Ѿ����Ѿ����ȹ�������

               ////System.out.println("prpLscheduleItemList.size()"+prpLscheduleItemList.size());
             //scheduleItemDtoList ��ָԭ���ӵ����Ѿ����ȹ������ݣ�������ô�������ǲ��ܱ�ɾ���ġ�
             //ֻҪ��� scheduleItemDtoList�д��� prpLscheduleItemList��û�еģ�������prpLscheduleItemList���ˡ�
             
            boolean blnotFind=true; 
            //scheduleItemDtoList���鿱�����ռ��ĵ�������
             for (int i =0;i<scheduleItemDtoList.size() ;i++)
             {
               prpLscheduleItemDto = new PrpLscheduleItemDto();
               prpLscheduleItemDto = (PrpLscheduleItemDto)scheduleItemDtoList.get(i);
               //ԭ����ͬ�ģ���ԭ��������Ϊ׼��û�е��Ѻ�����Ϊ׼
               blnotFind=true;
               for (int j =0;j<prpLscheduleItemList.size() ;j++)
               {
                 prpLscheduleItemoldDto= new PrpLscheduleItemDto();
                 prpLscheduleItemoldDto = (PrpLscheduleItemDto)((ArrayList)prpLscheduleItemList).get(j);
                 if (prpLscheduleItemDto.getItemNo()==prpLscheduleItemoldDto.getItemNo() )
                 { //������ھɵ����ݣ���Ҫ�þɵ����ݣ���Ҫ���µ�����
                   blnotFind=false;
                   break;
                 }
                 //ԭ����ͬ�ģ���ԭ��������Ϊ׼��û�е��Ѻ�����Ϊ׼
               }
               
               if (blnotFind)  scheduleItemLastList.add(prpLscheduleItemDto) ;
             }
             
             //����ԭ���Ѿ����ȹ������������ӻ�ȥ
            scheduleItemLastList.addAll(prpLscheduleItemList);
            checkDto.setPrpLscheduleItemDtoList(scheduleItemLastList) ;
           }
         }

		//Modify by chenrenda add begin 20050408
		//Reason:��ʧ��λģ����Ϣ�������永������Ϣ�У���Ӧģ��������
		
		/*---------------------��ʧ��λ PrpLthirdCarLoss end------------------------------------*/
		//Modify by chenrenda add end 20050408
		/*---------------------������Ϣ����˵�� PrpLregistExt ------------------------------------*/
		ArrayList prpLregistExtDtoList = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = null;
		//�ӽ���õ���������
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
		
		//����ֵ
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
				//���뼯��
				prpLregistExtDtoList.add(prpLregistExtDto);
			}
			//���������м�����ʧ��λ
			checkDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
		}
		//Modify by chenrenda add begin 20051418
		//Reason:��ʧģ����Ϣ�ϵ��永���������ˡ��Ʋ���ʧ��Ϣ��;�����ʧ��Ϣ����checkDto������
		checkDto.setPrpLcheckLossDtoList(prpLcheckLossDtoList);
		//Modify by chenrenda add end 20051418
		return checkDto;
	}
	
	/**
	 * ȡ��ʼ����Ϣ��Ҫ�����ݵ�����. ��д�鿱��ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȡ�ȡ��Щ��Ϣ��ҪһЩ��Σ�
	 * ���ǵ��ӿڵ�һ���ԣ�����Щ�����ΪDto��ʽ���룬Dto���þۺ϶��Ǽ̳еķ�ʽ�� ������ü̳еķ�ʽ�ֲ㴦��������߼�����������������������.
	 * 
	 * @param httpServletRequest
	 * @return RequestDto ȡ��ʼ����Ϣ��Ҫ������
	 * @throws Exception
	 */
	public CheckDto iniViewToDto(HttpServletRequest httpServletRequest)
	throws Exception {
		CheckDto checkDto = new CheckDto();
		return checkDto;
	}
	
	/**
	 * ��д�鿱ҳ�漰��ѯ�鿱request������.
	 * ��д�鿱ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
	 * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param proposalIniDto
	 *            ȡ���ĳ�ʼ����ϢDto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest,
			CheckDto checkDto) throws Exception {
		//�õ�request��PrpLcheckForm������ʾ
		PrpLcheckDto prpLcheckDto = checkDto.getPrpLcheckDto();
		httpServletRequest.setAttribute("prpLcheckDto", prpLcheckDto);
	}
	
	public void checkDtoView(HttpServletRequest httpServletRequest,
			String checkNo,int index) throws Exception {
		//ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���鿱��
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
		//ԭ�������⽡�ͷ������
		RegistDto registDto = new UIRegistAction().findByPrimaryKey(checkNo);
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(registDto.getPrpLregistDto().getRiskCode());
				//modify by wangwei add end 2005-06-18
		String riskCode = registDto.getPrpLregistDto().getRiskCode();
			
			//���ݲ�ѯ�������������ݣ���PrpLcheckDto��ֵ
			
			//Ϊ��ͬ��������
			//     prpLcheckDto.setLossItemName(lossItemName);
			prpLcheckDto.setLossItemCode(prpLcheckDto.getReferSerialNo() + "");
			//     prpLcheckDto.setInsureCarFlag(insureCarFlag);
			//    System.out.println("------liujianbo-----"+prpLcheckDto.getLossItemCode()+"|"+prpLcheckDto.getLossItemName()+"|"+prpLcheckDto.getInsureCarFlag());
			//���ò鿱������״̬Ϊ �����޸� (����������)
			if (checkDto.getPrpLclaimStatusDto() != null) {
				if (checkDto.getPrpLclaimStatusDto().getStatus().equals("7"))
					checkDto.getPrpLclaimStatusDto().setStatus("3");
				prpLcheckDto.setStatus(checkDto.getPrpLclaimStatusDto()
						.getStatus());
			} else {
				//���ύ���Ѿ�������ϵ�״̬
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
			//reason:Ϊ�˱�֤���������߳���˳������
			//�������ȡ���ⰸ�ţ�������������
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
			//������ش��������ת��
			changeCodeToName(httpServletRequest, prpLcheckDto);
			
			AgriCombineRegistViewHelper agriCombineRegistViewHelper = new AgriCombineRegistViewHelper();
			//��ѯ��ͬ�����ŵĳ��մ���
			agriCombineRegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
					prpLcheckDto.getPolicyNo(), prpLcheckDto.getRegistNo(),index);
			
			//Modify by chenrenda add begin 20050418
			//Reason:������ͬ�ڵ㹲�ü���jsp�ļ�ʱ���ͻ��˳�����Ҫ�������������ĸ��ڵ�
			String strPrpLnodeType = "check";
			httpServletRequest.setAttribute("prpLnodeType_"+index, strPrpLnodeType);
			//Modify by chenrenda add end 20050418
			
			//���ø����ӱ���Ϣ������
			setSubInfo(httpServletRequest, checkDto,index);
			
			//���ù�������һ���ڵ��ύ��������Ϣ
			getSubmitNodes(httpServletRequest,index);
			//�������鿱��Ϣ���ݵ������
			httpServletRequest.setAttribute("prpLcheckDto_"+index, prpLcheckDto);
			
			//�ڽ�������ʾ�������� 2005-09-09
			httpServletRequest.setAttribute("riskCName_"+index, uiCodeAction
					.translateRiskCode(prpLcheckDto.getRiskCode(), true));
			
			httpServletRequest.setAttribute("prpLregistDto_"+index, registDto
					.getPrpLregistDto());
			//modify by wangwei add start 2005-06-15
			// ԭ��ת��������
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
			//add by miaowenjun 20060925 �鿱����
			Collection checkNatures = uiCodeAction.getCodeType("CheckNature",
					BusinessRuleUtil.getOuterCode(httpServletRequest,
					"RISKCODE_DAA"));
			String editType     = String.valueOf(httpServletRequest.getAttribute("editType_"+index));
			AgriCombineCertainLossViewHelper agriCombineCertainLossViewHelper = new AgriCombineCertainLossViewHelper();
			agriCombineCertainLossViewHelper.registDtoToView(httpServletRequest, checkNo,
					editType,index);
					/*BusinessRuleUtil.getOuterCode(httpServletRequest,
					"RISKCODE_IBA"));GYIC�ž���*/
			httpServletRequest.setAttribute("checkNatures_"+index, checkNatures);
			httpServletRequest.setAttribute("statQuantity_"+index, policyDto.getPrpCmainDto().getStatQuantity());

	}
	/**
	 * ��д�鿱ҳ�漰��ѯ�鿱request������.
	 * ��д�鿱ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
	 * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param proposalIniDto
	 *            ȡ���ĳ�ʼ����ϢDto
	 * @throws Exception
	 */
	public void registDtoToView(HttpServletRequest httpServletRequest,
			String registNo, String editType,int index) throws Exception {
		//ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���鿱��
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
			
		//ԭ�������⽡�ͷ������
		String riskCode = registDto.getPrpLregistDto().getRiskCode();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		
		//ԭ��Ҫ�ڽ�������ʾһЩ������Ϣ
		com.sinosoft.claim.ui.control.action.UIClaimAction uiClaimAction = new com.sinosoft.claim.ui.control.action.UIClaimAction();
		Collection registClaimDtoList = (Collection) uiClaimAction
		.findByPolicyNo(registDto.getPrpLregistDto().getPolicyNo());
		httpServletRequest.setAttribute("registClaimDtoList_"+index,
				registClaimDtoList);
		httpServletRequest.setAttribute("com.sinosoft.agentCode", registDto
				.getIdentifierName());
		//modify by wangwei add end 2005-06-07

		/*
		//ԭ��Ҫ�ڽ�������ʾһЩ�������Ϣ
		UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
		Collection registVerifyLossList = (Collection) uiVerifyLossAction.findByPrimaryKey(registNo);
		httpServletRequest.setAttribute("registVerifyLossList",registVerifyLossList);
		*/
		//��ѯ�Ƿ��Ѿ�¼����鿱��Ϣ��
		if (uiCheckAction.isExist(registNo)&&!strRiskType.equals("H")) {
			checkDtoView(httpServletRequest, registNo,index);
			//��ֳ���Ȳ鿰,����ʱ�����а�����
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
		//����ڲ鿱ǰ�Ѿ������ˣ���ô��������ⰸ�ŷ���Ļ��������
		
		prpLcheckDto.setClaimNo(claimNo);
		prpLcheckDto.setRiskCode(registDto.getPrpLregistDto().getRiskCode());
		prpLcheckDto.setPolicyNo(registDto.getPrpLregistDto().getPolicyNo());
		//prpLcheckDto.setCheckType("L");
		
		////�鿱����Ĳ鿱�����ɵ��ȱ���� 2005-07-12
		if (registDto.getPrpLscheduleMainWFDto() != null) {
			prpLcheckDto.setCheckType(registDto.getPrpLscheduleMainWFDto()
					.getFlag());
		}
		
		//modify by wangwei add start 20050602
		//ԭ�����ӱ�����ͱ������
		prpLcheckDto.setRegistEstimateLoss(registDto.getPrpLregistDto()
				.getEstimateLoss());
		prpLcheckDto.setRegistEstimateFee(registDto.getPrpLregistDto()
				.getEstimateFee());
		//modity by wangwei add end 20050602
		
		//add by miaowenjun 20060922 �鿱�����б� ũ������û������ʱʹ��Daa����ҳ�����
		Collection checkNatures = uiCodeAction.getCodeType("CheckNature",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("checkNatures_"+index, checkNatures);
		//prpLcheckDto.setCheckNature(registDto.getPrpLregistDto().getCheckNature());
		//prpLcheckDto.setCheckDate(registDto.getPrpLregistDto().getCheckDate());
		//prpLcheckDto.setCheckSite(registDto.getPrpLregistDto().getCheckSite());
		//modify by lixiang remark 20050309 start
		// prpLcheckDto.setCheckSite(registDto.getPrpLregistDto().getDamageAddress());
		//reason:�鿱������յص��ɱ����������鿱��ַĬ��Ϊ���յص�
		//modify by lixiang remark 20050309 end
		
		//�鿱����Ĳ鿱��ַ�ɵ��ȱ���� 2005-07-12
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
		//reason:�鿱��1Ĭ��Ϊ������Զ������
		
		prpLcheckDto.setChecker1(user.getUserName());
		//System.out.println("prpLcheckDto.setChecker1"+prpLcheckDto.getChecker1());
		//modify by lixiang add 20050304 end
		
		//prpLcheckDto.setChecker2(registDto.getPrpLregistDto().getChecker2());
		//prpLcheckDto.setCheckUnitName(registDto.getPrpLregistDto().getCheckUnitName());
		prpLcheckDto
		.setHandleUnit(registDto.getPrpLregistDto().getHandleUnit());
		prpLcheckDto.setRemark(registDto.getPrpLregistDto().getRemark());
		prpLcheckDto.setFlag(registDto.getPrpLregistDto().getFlag());
		
		//add by wuxiaodong 050905 beegain reasion �û���ʾ����ʱ�ıұ�
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
		
		//��鿱ҳ����ӱ���������Ϣ  2005-09-26
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
		//prpLcheckDto.setHandleUnitName(registDto.getPrpLregistDto().getHandleUnitName());//δ֪
		
		//Ĭ�ϲ鿱����
		prpLcheckDto.setCheckDate(new DateTime(DateTime.current(),
				DateTime.YEAR_TO_DAY));
		//���ò鿱������״̬Ϊ �°����Ǽ� (δ��������)
		prpLcheckDto.setStatus("1");
		
		//������ش��������ת��
		changeCodeToName(httpServletRequest, prpLcheckDto);
		//���ô�����и�����ѡ�����б���Ϣ������
		//System.out.println("prpLcheckDto.getHandleUnitName()="+prpLcheckDto.getHandleUnitName()
		// );
		//��ѯ��ͬ�����ŵĳ��մ���
		DAACombineRegistViewHelper dAACombineRegistViewHelper = new DAACombineRegistViewHelper();
		dAACombineRegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLcheckDto.getPolicyNo(), prpLcheckDto.getRegistNo(),index);
		
		//�������鿱��Ϣ���ݵ������
		//��������߳�������ô��Ϊ�����棬��Ҫͨ��У�飬���Ա������ض����з����ʼ������ֵ
		/*
		 * if
		 * ((prpLcheckDto.getRiskCode().equals(BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA")))&&!insureCarFlag.equals("1")) {
		 * prpLcheckDto.setCheckSite("0 "); prpLcheckDto.setChecker1("0");
		 * prpLcheckDto.setChecker2("0 ");
		 * 
		 * }else {//Ĭ��ֵ prpLcheckDto.setInsureCarFlag("1");
		 * prpLcheckDto.setReferSerialNo(1); }
		 */
		//���ø����ӱ���Ϣ������
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
		//�����ر�Լ����Ϣ
		checkDto.setPrpLcheckDto(prpLcheckDto);

		//modify by wangli add end 20050408
		
		//Modify by chenrenda add begin 20050418
		//Reason:������ͬ�ڵ㹲�ü���jsp�ļ�ʱ���ͻ��˳�����Ҫ�������������ĸ��ڵ�
		String strPrpLnodeType = "check";
		httpServletRequest.setAttribute("prpLnodeType_"+index, strPrpLnodeType);
		//Modify by chenrenda add end 20050418
		
		 CheckDto checkDtoTemp = uiCheckAction.findByPrimaryKey(registNo);
		 checkDto.setPrpLcheckLossDtoList(checkDtoTemp.getPrpLcheckLossDtoList());

		//���ø����ӱ��е���Ϣ����ʾ
		setSubInfo(httpServletRequest, checkDto,index);
		
		//���ù�������һ���ڵ��ύ��������Ϣ
		getSubmitNodes(httpServletRequest,index);
		
		//��ȡ������Ϣ
		AgriCombineCertainLossViewHelper agriCombineCertainLossViewHelper = new AgriCombineCertainLossViewHelper();
		agriCombineCertainLossViewHelper.registDtoToView(httpServletRequest, registNo,
				editType,index);
				/*BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_IBA"));ԭ������ע�͵�*/
		httpServletRequest.setAttribute("prpLcheckDto_"+index, prpLcheckDto);
		//�ڽ�������ʾ�������� 2005-09-09
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
	 * �����ⰸ�źͱ����Ų�ѯ�鿱��Ϣ
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param registNo
	 *            �ⰸ��
	 * @param claimNo
	 *            ������
	 * @throws Exception
	 */
	
	public void setPrpLcheckDtoToView(HttpServletRequest httpServletRequest,
			String registNo, String policyNo,int index) throws Exception {
		//checkNo,policyNo,claimNo
		//��������ı����ţ��鿱������SQL where �Ӿ�
		policyNo = StringUtils.rightTrim(policyNo);
		registNo = StringUtils.rightTrim(registNo);
		String conditions = "";
		conditions = " registNo like '" + registNo + "%' and policyNo like '" + policyNo + "%'";
		//��ѯԤ����Ϣ
		UICheckAction uiCheckAction = new UICheckAction();
		
		//�õ����в鿱������Ϣ
		Collection checkList = new ArrayList();
		System.out.println("start to search,please waiting ...");
		
		checkList = (Collection) uiCheckAction.findByConditions(conditions);
		
		PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
		prpLcheckDto.setCheckList(checkList);
		
		prpLcheckDto.setEditType(String.valueOf(httpServletRequest.getAttribute("editType_"+index)));
		httpServletRequest.setAttribute("prpLcheckDto_"+index, prpLcheckDto);
		//���ù�������һ���ڵ��ύ��������Ϣ
		getSubmitNodes(httpServletRequest,index);
	}
	
	//add by zhaolu 20060802 start
	//reason:���ӷ�ҳ��ѯ
	public void setPrpLcheckDtoToView(HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto,String pageNo,String recordPerPage) throws Exception {
		//��������ı����ţ��鿱������SQL where �Ӿ�
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
		//reason:ǿ����ѯ
		conditions = conditions
		+ StringConvert.convertString("d.policyNo", policyNo, 
				workFlowQueryDto.getPolicyNoSign());
		//add by zhouliu end at 2006-6-9
		conditions = conditions
		+ StringConvert.convertString("c.LicenseNo", licenseNo,
				workFlowQueryDto.getLicenseNoSign());
		//��ӱ������˲�ѯ���� 2006-04-12 miaowenjun
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
		
		
	    // ƴȨ��
		//modify by zhaolu 20060816 start
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
		.getAttribute("user");
		
		//modify by zhaolu 20060816 end
		//modify by wangwei add start 2005-06-13
		//ԭ����Ҫ���ݲ�ͬ��������ѯ����պͷ��⽡��
		if (httpServletRequest.getParameter("type") != null
				&& httpServletRequest.getParameter("type").equals("acci")) {
			//modify by  ������Ŀ��  ������  27�����޸�Ϊ07
			conditions = conditions
			+ " and (b.riskcode like '07%' or b.riskcode like '26%')";
		} else {
			conditions = conditions
			+ " and b.riskcode not like '07%' and b.riskcode not like '26%'";
		}
		
		//modify by wangwei add end 2005-06-13    
		
		//     ��Ϊprplcheck������comcode�ֶΣ�������ʹ��addPower������������ʹ�ñ�����prpLregist��������
		//modify by zhaolu 20060816 start
		
		conditions = conditions
	   	+ uiPowerInterface.addPower(userDto,"c","","ComCode");
	
		//modify by zhaolu 20060816 end

		String condition = httpServletRequest.getParameter("condition");
		if(condition != null)
		{
			conditions = condition;
		}
		
		//��ѯԤ����Ϣ
		UICheckAction uiCheckAction = new UICheckAction();
		
		//�õ����в鿱������Ϣ
		ArrayList checkList = new ArrayList();
		//Collection checkList = new ArrayList();
		
		PageRecord pageRecord = null;
		
		System.out.println("start to search,please waiting ...");
		
		//modify by wangwei add start 2005-06-18
		//ԭ���⽡�պͷ��⽡�ղ�ѯ��ͬ�ı�
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
	 * ����PrpCheckDto�еĸ��ӱ��ڵ���Ϣ������
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param checkDto
	 *            �鿱��������
	 * @throws Exception
	 */
	private void setSubInfo(HttpServletRequest httpServletRequest,
			CheckDto checkDto,int index) throws Exception {
		
		//��������Ϣ����˵�������б�׼������
		Collection arrayListRegistExt = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = new PrpLregistExtDto();
		prpLregistExtDto.setRegistNo(checkDto.getPrpLcheckDto().getRegistNo());
		prpLregistExtDto.setRiskCode(checkDto.getPrpLcheckDto().getRiskCode());
		arrayListRegistExt = checkDto.getPrpLregistExtDtoList();
		prpLregistExtDto.setRegistExtList(arrayListRegistExt);
		httpServletRequest.setAttribute("prpLregistExtDto_"+index, prpLregistExtDto);
		
		//[�鿱����]�������ļ������б�׼������
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
		
		//[�鿱��Ϣ]�鿱��������б�׼������
		/*
		 * Collection arrayLTextList = new ArrayList(); PrpLregistTextDto
		 * prpLregistTextDto = new PrpLregistTextDto();
		 * prpLregistTextDto.setTextType("3") ; arrayLTextList =
		 * checkDto.getPrpLregistTextDtoList() ;
		 * prpLregistTextDto.setRegistTextList(arrayLTextList) ;
		 * httpServletRequest.setAttribute("prpLregistTextDto",
		 * prpLregistTextDto);
		 */
		//�鿱��չ��Ϣ�����б�׼������
		Collection arrayList1 = new ArrayList();
		PrpLcheckExtDto prpLcheckExtDto = new PrpLcheckExtDto();
		arrayList1 = checkDto.getPrpLcheckExtDtoList();
		prpLcheckExtDto.setPrpLcheckExtList(arrayList1);
		httpServletRequest.setAttribute("prpLcheckExtDto_"+index, prpLcheckExtDto);
		
		//�¹ʹ���������б�׼������
		ArrayList arrayList2 = new ArrayList();
		PrpLcheckLossDto prpLcheckLossDto = new PrpLcheckLossDto();
		arrayList2 = checkDto.getPrpLcheckLossDtoList();
		if (arrayList2 != null) {
			for (int indexCheck = 0; indexCheck < arrayList2.size(); indexCheck++) {
				PrpLcheckLossDto prpLcheckLossDto1 = new PrpLcheckLossDto();
				prpLcheckLossDto1 = (PrpLcheckLossDto) arrayList2
				.get(indexCheck);
				
				UICodeAction uiCodeAction = new UICodeAction();
				//���ձ����ת��
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
		//��ѯ������Ϣ ��ʾ�ر�Լ���б�
		String policyNo = checkDto.getPrpLcheckDto().getPolicyNo();
		ArrayList itemKindList = new ArrayList();
		Collection itemKindListNew = new ArrayList();
		//���ݱ����Ų�ѯ�ر�Լ����Ϣ
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
		//�ر�Լ����Ϣ�����б�׼������
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
		//Reason:���˸�����Ϣģ�����漰�������б���ѡ��ʽ��ʾ
		//���ձ����Ƹĳ�D1-������Ա�����յķ�ʽ,ֻ�����������복����Ա������
		
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
		
		//Reason:��ʧ��λ��ʾ��Ϊ�б��ʽ
		httpServletRequest.setAttribute("partCodeList_"+index, ICollections
				.getPartCodeList());
		//Modify by chenrenda add end 20050408
		
		//Modify by chenrenda add begin 20050412
		//Reason:�ڲ鿱ҳ���м���������ʧģ��
		Collection arrayListThirdProp = new ArrayList();
		PrpLthirdPropDto prpLthirdPropDto = new PrpLthirdPropDto();
		arrayListThirdProp = checkDto.getPrpLthirdPropDtoList();
		prpLthirdPropDto.setThirdPropList(arrayListThirdProp);
		//prpLthirdPropDto.setPrpLthirdPropKindCode("B");
		httpServletRequest.setAttribute("prpLthirdPropDto_"+index, prpLthirdPropDto);
		
		//Modify by chenrenda add end 20050412
		
	}
	
	
	/**
	 * ����PrpCheckDto�е��Ѿ����õĴ������ݣ��Դ����������ת��
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param prpLcheckDto
	 *            �鿱��������
	 * @throws Exception
	 */
	private void changeCodeToName(HttpServletRequest httpServletRequest,
			PrpLcheckDto prpLcheckDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		//(1)�������Ƶ�ת��
		String clauseType = prpLcheckDto.getClauseType();
		String clauseName = uiCodeAction.translateCodeCode("ClauseType",
				clauseType, true);
		prpLcheckDto.setClauseName(clauseName);
		prpLcheckDto.setDamageAreaName(uiCodeAction.translateCodeCode(
				"DamageAreaCode", prpLcheckDto.getDamageAreaCode(), true));
		
		//(2)�����ŵ�����ת��
		String strHandleUnit = prpLcheckDto.getHandleUnit();
		String strHandleUnitName = uiCodeAction.translateComCode(strHandleUnit,
				true);
		
		//System.out.println("strHandleUnitName
		// =================================="+strHandleUnitName );;
		prpLcheckDto.setHandleUnitName(strHandleUnitName);
	}
	
	public void getCheckScheduleDtoToView(HttpServletRequest httpServletRequest)
	throws Exception {
		//ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���鿱��
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		// Ŀ����ȡ��û�б�������ϵĵ�������Ȼ��list������
		Collection scheduleDtoList = new ArrayList();
		UICheckAction uiCheckAction = new UICheckAction();
		//���ҷ��������ĵ�������
		String conditions = "";
		//conditions = " CheckFlag='0' order by registNo,scheduleid " ;
		conditions = " selectSend='1' and insurecarflag='1' order by registNo,scheduleid";
		
		System.out.println("����ǰ.");
		scheduleDtoList = (Collection) uiCheckAction
		.findNewScheduleTaskList(conditions);
		System.out.println("������." + scheduleDtoList.toString());
		PrpLcheckItemDto prpLcheckItemDto = new PrpLcheckItemDto();
		
		scheduleDtoList = changeOperatorCodeToName(scheduleDtoList);
		prpLcheckItemDto.setCheckItemList(scheduleDtoList);
		// prpLcheckItemDto.setCheckOperatorCode(user.getUserCode() );
		//����ѯ������ �����б�ŵ���������ʾ
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
		
		//ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���鿱��
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		int intscheduleID = Integer.parseInt(scheduleID);
		
		UIScheduleAction uiScheduleAction = new UIScheduleAction();
		ScheduleDto scheduleDto = uiScheduleAction.findByPrimaryKey(
				intscheduleID, registNo);
		
		//���ݲ�ѯ�������������ݣ���PrpLscheduleDto��ֵ
		PrpLscheduleMainWFDto prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();
		prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto();
		
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		
		//������չ����
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
		
		//���ò鿱������״̬Ϊ �����޸� (����������)
		if (scheduleDto.getPrpLclaimStatusDto() != null) {
			prpLscheduleMainWFDto.setStatus(scheduleDto
					.getPrpLscheduleMainWFDto().getStatus());
		} else {
			//���ύ���Ѿ�������ϵ�״̬
			prpLscheduleMainWFDto.setStatus("4");
		}
		
		scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
		
		//������ش��������ת��
		//changeCodeToName(httpServletRequest,scheduleDto);
		//���ô�����и�����ѡ�����б���Ϣ������
		// setSelectionList(httpServletRequest,scheduleDto);
		//�������鿱��Ϣ���ݵ������
		httpServletRequest.setAttribute("prpLscheduleMainWFDto",
				prpLscheduleMainWFDto);
		//���ø����ӱ���Ϣ������
		setCheckItemInfo(httpServletRequest, scheduleDto);
	}
	
	/**
	 * ����Dto�еĸ��ӱ��ڵ���Ϣ������
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param scheduleDto
	 *            �鿱��������
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
		 * (prpLthirdPartyTempDto.getScheduleType ()); //���뼯��
		 * scheduleItemList.add(prpLscheduleItemDto); i++; }
		 */
		scheduleDto.setPrpLscheduleItemDtoList(checkItemList);
		PrpLcheckItemDto prpLcheckItemDto = new PrpLcheckItemDto();
		prpLcheckItemDto.setCheckItemList(checkItemList);
		httpServletRequest.setAttribute("prpLcheckItemDto", prpLcheckItemDto);
	}
	
	/**
	 * ����鿱ʱ�鿱ҳ����������.
	 * 
	 * @param httpServletRequest
	 * @return scheduleDto �鿱���ݴ������ݽṹ
	 * @throws Exception
	 */
	public ScheduleDto checkViewToDto(HttpServletRequest httpServletRequest)
	throws Exception {
		//ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���鿱��
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		String registNo = httpServletRequest
		.getParameter("prpLscheduleMainWFRegistNo"); //������
		String scheduleID = httpServletRequest
		.getParameter("prpLscheduleMainWFScheduleID"); //���Ⱥ�
		String prpLscheduleMainWFCheckFlag = httpServletRequest
		.getParameter("prpLscheduleMainWFCheckFlag"); //�鿱״̬
		String prpLscheduleMainWFCheckInfo = httpServletRequest
		.getParameter("prpLscheduleMainWFCheckInfo"); //�鿱�������
		//String prpLscheduleMainWFCheckInputDate=
		String prpLscheduleMainWFCheckOperatorCode = user.getUserCode();
		int intscheduleID = Integer.parseInt(scheduleID);
		
		//���ȴ����ݿ���ȡ�õ��ȵ�������Ϣ
		UIScheduleAction uiScheduleAction = new UIScheduleAction();
		ScheduleDto scheduleDto = uiScheduleAction.findByPrimaryKey(
				intscheduleID, registNo);
		
		//���ݲ�ѯ�������������ݣ���PrpLscheduleDto��ֵ
		PrpLscheduleMainWFDto prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();
		prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto();
		prpLscheduleMainWFDto.setCheckFlag(prpLscheduleMainWFCheckFlag);
		prpLscheduleMainWFDto.setCheckInfo(prpLscheduleMainWFCheckInfo);
		prpLscheduleMainWFDto.setCheckInputDate(new DateTime(DateTime.current()
				.toString(), DateTime.YEAR_TO_DAY));
		prpLscheduleMainWFDto
		.setCheckOperatorCode(prpLscheduleMainWFCheckOperatorCode);
		scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
		
		//-------------����������-------------------------------
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
			//����鿱��ļ���
			checkItemList.add(prpLcheckItemDto);
		}
		// ���ȼ������޸Ĳ鿱���
		scheduleDto.setPrpLcheckItemDtoList(checkItemList);
		return scheduleDto;
	}
	
	/**
	 * �����ⰸ��,������,����״̬�����ƺ��룬����ʱ���ѯ�鿱��Ϣ
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param claimNo
	 *            �ⰸ��
	 * @param registNo
	 *            ������
	 * @param licenseNo
	 *            ���ƺ�
	 * @throws Exception
	 *             Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ����
	 */
	
	public void setPrpLcheckDtoToView(HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto) throws Exception {
		//��������ı����ţ��鿱������SQL where �Ӿ�
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
		//reason:ǿ����ѯ
		conditions = conditions
		+ StringConvert.convertString("d.policyNo", policyNo, 
				workFlowQueryDto.getPolicyNoSign());
		//add by zhouliu end at 2006-6-9
		conditions = conditions
		+ StringConvert.convertString("c.LicenseNo", licenseNo,
				workFlowQueryDto.getLicenseNoSign());
		//��ӱ������˲�ѯ���� 2006-04-12 miaowenjun
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
		//     ƴȨ��
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
		.getAttribute("user");
		
		//modify by wangwei add start 2005-06-13
		//ԭ����Ҫ���ݲ�ͬ��������ѯ����պͷ��⽡��
		if (httpServletRequest.getParameter("type") != null
				&& httpServletRequest.getParameter("type").equals("acci")) {
			//modify by   ��Ŀ��  ������  27�����޸�Ϊ07
			conditions = conditions
			+ " and (b.riskcode like '07%' or b.riskcode like '26%')";
		} else {
			conditions = conditions
			+ " and b.riskcode not like '07%' and b.riskcode not like '26%'";
		}
		//modify by wangwei add end 2005-06-13    
		
		//     ��Ϊprplcheck������comcode�ֶΣ�������ʹ��addPower������������ʹ�ñ�����prpLregist��������
		conditions = conditions
		+ uiPowerInterface.addPower(userDto,"c","","ComCode");
		
		//��ѯԤ����Ϣ
		UICheckAction uiCheckAction = new UICheckAction();
		
		//�õ����в鿱������Ϣ
		Collection checkList = new ArrayList();
		System.out.println("start to search,please waiting ...");
		
		//modify by wangwei add start 2005-06-18
		//ԭ���⽡�պͷ��⽡�ղ�ѯ��ͬ�ı�
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
	 * ��ѯ��������������ѡ��Ľڵ�����
	 * 
	 * @param modelNo
	 *            String
	 * @param nodeNo
	 *            String
	 * @throws Exception
	 */
	private void getSubmitNodes(HttpServletRequest httpServletRequest,int index)
	throws Exception {
		String modelNo = String.valueOf(httpServletRequest.getAttribute("modelNo_"+index)); //ģ���
		String nodeNo = String.valueOf(httpServletRequest.getAttribute("nodeNo_"+index)); //�ڵ��
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
	 * ���ݱ��������ѯ������Ϣ��ص�������ʾ��ҳ����
	 * ��Ԫ��Ŀ��
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param PrpLverifyLossDto
	 *            ȡ���ĳ�ʼ����ϢDto
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
	 * ���ݱ��������ѯ�����ձ������Ϣ
	 * ��Ԫ��Ŀ��
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param PrpLverifyLossDto
	 *            ȡ���ĳ�ʼ����ϢDto
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
	 * ���ݱ��������ѯ�����ձ������Ϣ
	 * ��Ԫ��Ŀ��
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param PrpLverifyLossDto
	 *            ȡ���ĳ�ʼ����ϢDto
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