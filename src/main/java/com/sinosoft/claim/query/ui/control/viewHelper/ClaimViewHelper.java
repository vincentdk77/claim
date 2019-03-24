package com.sinosoft.claim.query.ui.control.viewHelper;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * <p>
 * Title: ClaimViewHelper
 * </p>
 * <p>
 * Description:立案ViewHelper类，在该类中完成页面数据的整理
 * </p>
 * <p>
 * Copyright: Copyright 中科软科技股份有限公司(c) 2004
 * </p>
 * 
 * @author 车险理赔项目组 lijiyuan
 * @version 1.0 <br>
 */

public abstract class ClaimViewHelper {
    private int RULE_LENGTH = 70; //rule字段的长度
    /**
     * 默认构造方法
     */
    public ClaimViewHelper() {
    }
    /**
     * 保存立案时立案页面数据整理. 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
     * 
     * @param httpServletRequest
     * @return claimDto 立案数据传输数据结构
     * @throws Exception
     */
    public ClaimDto viewToDto(HttpServletRequest httpServletRequest) throws Exception {
        ClaimDto claimDto = new ClaimDto();
        /*---------------------立案主表prpLclaim------------------------------------*/
        PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
        //加到ArrayList中
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(httpServletRequest.getParameter("prpLclaimPolicyNo")
				,httpServletRequest.getParameter("prpLclaimDamageStartDate")
				,httpServletRequest.getParameter("prpLclaimDamageStartHour")); 
        prpLclaimDto.setClaimNo((String) httpServletRequest.getAttribute("claimNo"));
        //prpLclaimDto.setLFlag (httpServletRequest.getParameter("prpLclaimLFlag"));
        prpLclaimDto.setLFlag(httpServletRequest.getParameter("LFlag"));
        prpLclaimDto.setCaseNo(httpServletRequest.getParameter("prpLclaimCaseNo"));
        prpLclaimDto.setClassCode(httpServletRequest.getParameter("prpLclaimClassCode"));
        prpLclaimDto.setRiskCode(httpServletRequest.getParameter("prpLclaimRiskCode"));

        prpLclaimDto.setRegistNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
        prpLclaimDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
        prpLclaimDto.setBusinessNature(httpServletRequest.getParameter("prpLclaimBusinessNature"));
        prpLclaimDto.setLanguage(httpServletRequest.getParameter("prpLclaimLanguage"));
        prpLclaimDto.setPolicyType(httpServletRequest.getParameter("prpLclaimPolicyType"));
//        prpLclaimDto.setInsuredCode(httpServletRequest.getParameter("prpLclaimInsuredCode"));
        prpLclaimDto.setInsuredCode(httpServletRequest.getParameter("prpLregistInsuredCode"));
        prpLclaimDto.setInsuredName(httpServletRequest.getParameter("prpLclaimInsuredName"));
        prpLclaimDto.setStartDate(new DateTime(httpServletRequest.getParameter("prpLclaimStartDate"),
                DateTime.YEAR_TO_DAY));
       if(policyDto!= null){
        	if(policyDto.getPrpCmainDto()!=null){
              prpLclaimDto.setStartHour(policyDto.getPrpCmainDto().getStartHour());
              prpLclaimDto.setEndHour(policyDto.getPrpCmainDto().getEndHour());
            }
        }else{
        	prpLclaimDto.setStartHour(0);
            prpLclaimDto.setEndHour(24);
        }
        prpLclaimDto
                .setEndDate(new DateTime(httpServletRequest.getParameter("prpLclaimEndDate"), DateTime.YEAR_TO_DAY));
        
        prpLclaimDto.setCurrency(httpServletRequest.getParameter("prpLclaimCurrency"));
        
        prpLclaimDto.setSumAmount(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimSumAmount"))));
        prpLclaimDto.setSumPremium(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimSumPremium"))));
        prpLclaimDto.setSumQuantity(Integer.parseInt(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimSumQuantity"))));
        //兼容大地的小时，所以先注释掉
        prpLclaimDto.setDamageStartHour(StringConvert.newString(httpServletRequest
                .getParameter("prpLclaimDamageStartHour"))
                + ":" + StringConvert.newString(httpServletRequest.getParameter("prpLclaimDamageStartMinute")) + ":00");
        //prpLclaimDto.setDamageStartHour (httpServletRequest.getParameter("prpLclaimDamageStartHour"));
        //兼容大地的小时，所以先注释掉
        prpLclaimDto.setDamageStartDate(new DateTime(httpServletRequest.getParameter("prpLclaimDamageStartDate"),
                DateTime.YEAR_TO_DAY));
        prpLclaimDto.setDamageEndDate(new DateTime(httpServletRequest.getParameter("prpLclaimDamageEndDate"),
                DateTime.YEAR_TO_DAY));
        //兼容大地的小时，所以先注释掉
        //prpLclaimDto.setDamageEndHour (httpServletRequest.getParameter("prpLclaimDamageEndHour"));
        prpLclaimDto.setDamageEndHour(StringConvert
                .newString(httpServletRequest.getParameter("prpLclaimDamageEndHour"))
                + ":" + StringConvert.newString(httpServletRequest.getParameter("prpLclaimDamageEndMinute")) + ":00");
        prpLclaimDto.setDamageCode(httpServletRequest.getParameter("prpLclaimDamageCode"));
        prpLclaimDto.setDamageName(httpServletRequest.getParameter("prpLclaimDamageName"));
        prpLclaimDto.setDamageTypeCode(httpServletRequest.getParameter("prpLclaimDamageTypeCode"));
        prpLclaimDto.setDamageTypeName(httpServletRequest.getParameter("prpLclaimDamageTypeName"));
        prpLclaimDto.setDamageAreaCode(httpServletRequest.getParameter("prpLclaimDamageAreaCode"));
        prpLclaimDto.setDamageAreaName(httpServletRequest.getParameter("prpLclaimDamageAreaName"));
        prpLclaimDto.setDamageAddressType(httpServletRequest.getParameter("prpLclaimDamageAddressType"));
        prpLclaimDto.setDamageAddress(httpServletRequest.getParameter("prpLclaimDamageAddress"));
        prpLclaimDto.setLossName(httpServletRequest.getParameter("prpLclaimLossName"));
        prpLclaimDto.setLossQuantity(Integer.parseInt(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimLossQuantity"))));
        prpLclaimDto.setDamageKind(httpServletRequest.getParameter("prpLclaimDamageKind"));
        if("05".equals(prpLclaimDto.getClassCode())){
        	prpLclaimDto.setClaimDate(new DateTime(httpServletRequest.getParameter("prpLclaimClaimDate"),
                    DateTime.YEAR_TO_SECOND));
        }else{
        	prpLclaimDto.setClaimDate(new DateTime(httpServletRequest.getParameter("prpLclaimClaimDate"),
                    DateTime.YEAR_TO_DAY));
        	prpLclaimDto.setClaimTime(new DateTime(httpServletRequest.getParameter("prpLclaimClaimTime"),
                    DateTime.YEAR_TO_SECOND));
        }
        //prpLclaimDto.setClaimDate(new DateTime(httpServletRequest.getParameter("prpLclaimClaimDate"),
        //        DateTime.YEAR_TO_DAY));
        prpLclaimDto.setIndemnityDuty(httpServletRequest.getParameter("indemnityDuty"));
        prpLclaimDto.setIndemnityDutyRate(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimIndemnityDutyRate"))));
        prpLclaimDto.setDeductibleRate(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimDeductibleRate"))));
        prpLclaimDto.setSumClaim(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimSumClaim"))));
        prpLclaimDto.setSumDefLoss(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimSumDefLoss"))));
        prpLclaimDto.setSumPaid(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimSumPaid"))));
        prpLclaimDto.setSumReplevy(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLclaimSumReplevy"))));
        
        if("ZH03".equals(httpServletRequest.getParameter("prpLclaimRiskCode"))){
        	prpLclaimDto.setRemark(httpServletRequest.getParameter("FamilyNo"));
        }
        else
        {
        	prpLclaimDto.setRemark(httpServletRequest.getParameter("prpLclaimRemark"));
        }
  
        prpLclaimDto.setCaseType(httpServletRequest.getParameter("prpLclaimCaseType"));
        prpLclaimDto.setMakeCom(httpServletRequest.getParameter("prpLclaimMakeCom"));
        prpLclaimDto.setComCode(httpServletRequest.getParameter("prpLclaimComCode"));
        prpLclaimDto.setAgentCode(httpServletRequest.getParameter("prpLclaimAgentCode"));
        prpLclaimDto.setHandlerCode(httpServletRequest.getParameter("prpLclaimHandlerCode"));
        prpLclaimDto.setHandler1Code(httpServletRequest.getParameter("prpLclaimHandler1Code"));
        prpLclaimDto.setStatisticsYM(new DateTime(httpServletRequest.getParameter("prpLclaimStatisticsYM"),
                DateTime.YEAR_TO_DAY));
        prpLclaimDto.setOperatorCode(httpServletRequest.getParameter("prpLclaimOperatorCode"));
        prpLclaimDto.setInputDate(new DateTime(httpServletRequest.getParameter("prpLclaimInputDate"),
                DateTime.YEAR_TO_DAY));
        prpLclaimDto.setEndCaseDate(new DateTime(httpServletRequest.getParameter("prpLclaimEndCaseDate"),
                DateTime.YEAR_TO_SECOND));
        prpLclaimDto.setEndCaserCode(httpServletRequest.getParameter("prpLclaimEndCaserCode"));
        prpLclaimDto.setCancelDate(new DateTime(httpServletRequest.getParameter("prpLclaimCancelDate"),
                DateTime.YEAR_TO_DAY));
        prpLclaimDto.setCancelReason(httpServletRequest.getParameter("prpLclaimCancelReason"));
        prpLclaimDto.setDealerCode(httpServletRequest.getParameter("prpLclaimDealerCode"));

        //modify by wangwei add start 2005-06-07
        //原因：添加巨灾代码和出险地邮编
        prpLclaimDto.setDamageAreaPostCode(httpServletRequest.getParameter("prpDamageAreaPostCode"));
        prpLclaimDto.setCatastropheCode1(httpServletRequest.getParameter("prpCatastropheCode1"));
        prpLclaimDto.setCatastropheName1(httpServletRequest.getParameter("prpCatastropheName1"));
        prpLclaimDto.setCatastropheCode2(httpServletRequest.getParameter("prpCatastropheCode2"));
        prpLclaimDto.setCatastropheName2(httpServletRequest.getParameter("prpCatastropheName2"));
        //modify by wangwei add end 205-06-07
        //add by wunier 20071228
        //reason:添加赔付数量以及相应单位
        String prpLclaimLossesNumber = httpServletRequest.getParameter("prpLclaimLossesNumber");
        if(prpLclaimLossesNumber!=null){
        prpLclaimDto.setLossesNumber(Double.parseDouble(prpLclaimLossesNumber));
        }
        prpLclaimDto.setLossesUnitCode(httpServletRequest.getParameter("lossesUnitCode"));
        //end by wunier 20071228
        //add by wunier 20071229
        //reason:增加出险户次、受灾面积
        String prpLclaimDamageInsured = httpServletRequest.getParameter("prpLclaimDamageInsured");
        if(prpLclaimDamageInsured!=null&&!"".equals(prpLclaimDamageInsured)){
        prpLclaimDto.setDamageInsured(Double.parseDouble(prpLclaimDamageInsured));
        }
        String prpLclaimDisasterArea = httpServletRequest.getParameter("prpLclaimDisasterArea");
        if(prpLclaimDisasterArea!=null&&!"".equals(prpLclaimDisasterArea)){
        prpLclaimDto.setDisasterArea(Double.parseDouble(prpLclaimDisasterArea));
        }
        prpLclaimDto.setDisasterUnit(httpServletRequest.getParameter("disasterUnit"));
        String prpLclaimAffectedArea = httpServletRequest.getParameter("prpLclaimAffectedArea");
        if(prpLclaimAffectedArea!=null&&!"".equals(prpLclaimAffectedArea)){
        prpLclaimDto.setAffectedArea(Double.parseDouble(prpLclaimAffectedArea));
        }
        prpLclaimDto.setAffectedUnit(httpServletRequest.getParameter("affectedUnit"));
        String prpLclaimNoProductionArea = httpServletRequest.getParameter("prpLclaimNoProductionArea");
        if(prpLclaimNoProductionArea!=null&&!"".equals(prpLclaimNoProductionArea)){
        prpLclaimDto.setNoProductionArea(Double.parseDouble(prpLclaimNoProductionArea));
        }
        prpLclaimDto.setNoProductionUnit(httpServletRequest.getParameter("noProductionUnit"));
        String prpLclaimDeathQuantity = httpServletRequest.getParameter("prpLclaimDeathQuantity");
        if(prpLclaimDeathQuantity!=null&&!"".equals(prpLclaimDeathQuantity)){
        prpLclaimDto.setDeathQuantity(Double.parseDouble(prpLclaimDeathQuantity));
        prpLclaimDto.setDeathUnit(httpServletRequest.getParameter("deathUnit"));
        }
        String prpLclaimKillQuantity = httpServletRequest.getParameter("prpLclaimKillQuantity");
        if(prpLclaimKillQuantity!=null&&!"".equals(prpLclaimKillQuantity)){
        prpLclaimDto.setKillQuantity(Double.parseDouble(prpLclaimKillQuantity));
        }
        prpLclaimDto.setKillUnit(httpServletRequest.getParameter("killUnit"));

        //end by wunier 20071229


        
        /*添加案件类型 2005-08-03
        prpLclaimDto.setClaimType(httpServletRequest.getParameter("prpLclaimClaimType"));
        
        //modify by luqin add 2005-03-24 begin
        //reason:插入字段（escapeFlag）超长
        
        /*
        String escapeFlag = httpServletRequest.getParameter("escapeFlag");
        if (escapeFlag == null) {
            escapeFlag = "";
        }
        String escapeFlag2 = "";
        escapeFlag2 = httpServletRequest.getParameter("escapeFlag2");
        if (escapeFlag2 == null) {
            escapeFlag2 = "";
        }
        prpLclaimDto.setEscapeFlag2(escapeFlag2);
        prpLclaimDto.setEscapeFlag(escapeFlag + escapeFlag2);
        */
        // modify by wangli add start 20050421
        
        //=================================== modify by YANGBO 2009-01-15 START
        prpLclaimDto.setClaimType(httpServletRequest.getParameter("claimType"));
        prpLclaimDto.setEscapeFlag(httpServletRequest.getParameter("escapeFlag"));
        prpLclaimDto.setClaimTypeName(httpServletRequest.getParameter("claimTypeName"));
        //=================================== modify by YANGBO 2009-01-15 END

        prpLclaimDto.setFlag(httpServletRequest.getParameter("prpLclaimFlag"));

        prpLclaimDto.setReplevyFlag(httpServletRequest.getParameter("replevyFlag"));
        prpLclaimDto.setThirdComFlag(httpServletRequest.getParameter("thirdComFlag"));
        //需要保存的状态,所以每个操作界面必须有一个"buttonSaveType"的操作域来保存要操作的状态！！
        prpLclaimDto.setAddressCode(httpServletRequest.getParameter("prpLclaimAddressCode"));
       
        //if ((prpLclaimDto.getEscapeFlag().length() > 0) && (prpLclaimDto.getEscapeFlag2().length() > 0)) {
        //    String strTemp = prpLclaimDto.getEscapeFlag().substring(0, 1)
        //            + prpLclaimDto.getEscapeFlag2().substring(0, 1);
        //    prpLclaimDto.setEscapeFlag(strTemp);
        //}
        //prpLclaimDto.setStatus (httpServletRequest.getParameter("buttonSaveType") ) ;
        prpLclaimDto.setComName(prpLclaimDto.getComCode());
        prpLclaimDto.setMedicalType(httpServletRequest.getParameter("medicalType"));

        //加到ArrayList中

        claimDto.setPrpLclaimDto(prpLclaimDto);
        
        //事故者信息模块 begin
        ArrayList prpLacciBenPersonList = new ArrayList();
        PrpLacciPersonDto   prpLacciBenPersonProposerDto = null;
        String[] prpLacciPersonAcciCode = httpServletRequest.getParameterValues("prpLacciPersonAcciCode");
        String[] prpLacciBenPersonSerialNo = httpServletRequest.getParameterValues("prpLacciBenPersonSerialNo");
        String[] prpLacciPersonAcciName = httpServletRequest.getParameterValues("prpLacciPersonAcciName");
        String[] prpLacciPersonFamilyNo = httpServletRequest.getParameterValues("prpLacciPersonFamilyNo");
        String[] prpLacciPersonAge = httpServletRequest.getParameterValues("prpLacciPersonAge");
        String[] prpLacciPersonSex = httpServletRequest.getParameterValues("prpLacciPersonSex");
        String[] prpLacciPersonIdentifyNumber = httpServletRequest.getParameterValues("prpLacciPersonIdentifyNumber");
        String[] prpLacciPersonAddress = httpServletRequest.getParameterValues("prpLacciPersonAddress");
        
        //对象赋值
        if (prpLacciPersonFamilyNo ==null) {
        } else { 
        	
            for (int index = 1; index < prpLacciPersonFamilyNo.length; index++) {
            	prpLacciBenPersonProposerDto = new PrpLacciPersonDto();
            	prpLacciBenPersonProposerDto.setCertiNo(httpServletRequest.getParameter("prpLclaimRegistNo"));
            	prpLacciBenPersonProposerDto.setCertiType("01"); //事故者信息
            	prpLacciBenPersonProposerDto.setPolicyNo(httpServletRequest.getParameter("prpLclaimPolicyNo"));
            	//prpLacciBenPersonProposerDto.setSerialNo(uiPolicyAction.findBySeriaNo("1=1") + 1);不明白?
                  //分户序号从界面上取
            	prpLacciBenPersonProposerDto.setSerialNo(Integer.parseInt(prpLacciBenPersonSerialNo[index]));
            	prpLacciBenPersonProposerDto.setFamilyNo(Integer.parseInt(prpLacciPersonFamilyNo[index]));
            	prpLacciBenPersonProposerDto.setAcciCode(prpLacciPersonAcciCode[index]);
            	prpLacciBenPersonProposerDto.setAcciName(prpLacciPersonAcciName[index]);
            	prpLacciBenPersonProposerDto.setAge(Integer.parseInt(DataUtils.nullToZero(prpLacciPersonAge[index])));
            	prpLacciBenPersonProposerDto.setSex(prpLacciPersonSex[index]);
            	prpLacciBenPersonProposerDto.setIdentifyNumber(prpLacciPersonIdentifyNumber[index]);
            	prpLacciBenPersonProposerDto.setAddress(prpLacciPersonAddress[index]);//暂存牛号信息
                //加入集合
            	prpLacciBenPersonList.add(prpLacciBenPersonProposerDto);
            }
        }
        claimDto.setPrplacciBenPersonDtoList(prpLacciBenPersonList);
        //事故者信息模块 end
        /*---------------------立案文本表prpLltext------------------------------------*/
        ArrayList prpLltextDtoList = new ArrayList();
        String TextTemp = httpServletRequest.getParameter("prpLltextContextInnerHTML");
        String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);
        //得到连接串,下面将其切分到数组
        for (int k = 0; k < rules.length; k++) {
            PrpLltextDto prpLltextDto = new PrpLltextDto();
            prpLltextDto.setClaimNo((String) httpServletRequest.getAttribute("claimNo"));
            prpLltextDto.setContext(rules[k]);
            prpLltextDto.setLineNo(k + 1);
            prpLltextDto.setTextType("09");
            prpLltextDtoList.add(prpLltextDto);
        }
        //详细出险原因信息
        String strDamageMessage = httpServletRequest.getParameter("damageMessageFlag");
        if(strDamageMessage!=null && !strDamageMessage.equals("")){
     	   ArrayList prpLltextDtoList3 = new ArrayList();
     	   String[] damageMessage = httpServletRequest.getParameterValues("damageMessage");
     	   if(damageMessage != null){
 	    	   for(int index = 0;index<damageMessage.length;index++){
 	    		  PrpLltextDto prpLltextDto = new PrpLltextDto();
 	    		  prpLltextDto.setClaimNo((String) httpServletRequest.getAttribute("claimNo"));
 	    		  prpLltextDto.setLineNo(index+1);
 	    		  prpLltextDto.setContext(damageMessage[index]);
 	    		  prpLltextDto.setTextType(strDamageMessage);
 	    		 prpLltextDtoList3.add(prpLltextDto);
 	    	   }
     	   }
     	   claimDto.setPrpLltextDtoList3(prpLltextDtoList3);
        }
        //claimDto
        claimDto.setPrpLltextDtoList(prpLltextDtoList);
        
        
        String riskcodefortemp = httpServletRequest.getParameter("prpLclaimRiskCode");
        if("0310".equals(riskcodefortemp)||"0312".equals(riskcodefortemp))
        {
			ArrayList prplCompensateHouseDtoList = new ArrayList();
			PrplcompensatehouseDto prplCompensateHouseDto = null;
			//String   prplCheckPolicyNoShow  = httpServletRequest.getParameter("prplCheckPolicyNoShow");
			//String   prplCheckRegistNoShow  = httpServletRequest.getParameter("prplCheckRegistNoShow");
			String[] prplCompensateHouseCaseNo=httpServletRequest.getParameterValues("prplCompensateHouseCaseNo");
			String[] prplCompensateHouseClaimNo=httpServletRequest.getParameterValues("prplCompensateHouseClaimNo");
			String[] prplCompensateHouseNodeNo=httpServletRequest.getParameterValues("prplCompensateHouseNodeNo");
			String[] prplCompensateHouseNodeType=httpServletRequest.getParameterValues("prplCompensateHouseNodeType");
			String[] prplCompensateHousePolicyNo=httpServletRequest.getParameterValues("prplCompensateHousePolicyNo");
			String[] prplCompensateHouseRegistNo=httpServletRequest.getParameterValues("prplCompensateHouseRegistNo");
			String[] prplCompensateHouseDamageCode=httpServletRequest.getParameterValues("prplCompensateHouseDamageCode");
			String[] prplCompensateHouseDamageStartDate=httpServletRequest.getParameterValues("prplCompensateHouseDamageStartDate");
			String[] prplCompensateHouseCompensateNo=httpServletRequest.getParameterValues("prplCompensateHouseCompensateNo");
			String[] prplCompensateHouseDamageName=httpServletRequest.getParameterValues("prplCompensateHouseDamageName");
			String[] prplCompensateHouseKindCode=httpServletRequest.getParameterValues("prplCompensateHouseKindCode");
			
			
			String[] prplCompensateHouseName=httpServletRequest.getParameterValues("prplCompensateHouseName");
			String[] prplCompensateHouseIDcard=httpServletRequest.getParameterValues("prplCompensateHouseIDcard");
			String[] prplCompensateHousehukoubu=httpServletRequest.getParameterValues("prplCompensateHousehukoubu");
			String[] prplCompensateHouseAddress=httpServletRequest.getParameterValues("prplCompensateHouseAddress");
			String[] prplCompensateHousePhone=httpServletRequest.getParameterValues("prplCompensateHousePhone");
			String[] prplCompensateHouseRemark=httpServletRequest.getParameterValues("prplCompensateHouseRemark");
			
			String[] prplCompensateHouseEstimateLoss=httpServletRequest.getParameterValues("prplCompensateHouseEstimateLoss");
			
  			String prplCompensateHouseBuildingnumber=httpServletRequest.getParameter("prplCompensateHouseBuildingnumber");
			String prplCompensateHouseZhuannumber=httpServletRequest.getParameter("prplCompensateHouseZhuannumber");
			String prplCompensateHouseWanumber=httpServletRequest.getParameter("prplCompensateHouseWanumber");
			String prplCompensateHouseKitchennumber=httpServletRequest.getParameter("prplCompensateHouseKitchennumber");
			String prplCompensateHouseOthernumber=httpServletRequest.getParameter("prplCompensateHouseOthernumber");
			String prplCompensateHouseFloor=httpServletRequest.getParameter("prplCompensateHouseFloor");
			
			if (prplCompensateHouseIDcard == null){
		     }else{
		    	 for(int index = 1;index < prplCompensateHouseIDcard.length;index++)
		    	 {
		    		 prplCompensateHouseDto = new PrplcompensatehouseDto();
		    		 prplCompensateHouseDto.setAddress(prplCompensateHouseAddress[index]);
		    		 prplCompensateHouseDto.setBusinessno(httpServletRequest.getParameter("prpLclaimRegistNo"));
		    		 prplCompensateHouseDto.setCaseno(prplCompensateHouseCaseNo[index]);
		    		 prplCompensateHouseDto.setClaimno(httpServletRequest.getParameter("prpLclaimClaimNo"));
		    		 prplCompensateHouseDto.setCompensateno(prplCompensateHouseClaimNo[index]);
		    		 prplCompensateHouseDto.setDamagecode(httpServletRequest.getParameter("prpLclaimDamageCode"));
		    		 prplCompensateHouseDto.setDamagename(httpServletRequest.getParameter("prpLclaimDamageName"));
		    		 prplCompensateHouseDto.setDamagestartdate(new DateTime(httpServletRequest.getParameter("prpLclaimDamageStartDate"),DateTime.YEAR_TO_DAY));
		    		 prplCompensateHouseDto.setEstimateloss(Double.parseDouble(DataUtils.nullToZero(prplCompensateHouseEstimateLoss[index])));
		    		 prplCompensateHouseDto.setHukoubu(prplCompensateHousehukoubu[index]);
		    		 prplCompensateHouseDto.setIdcard(prplCompensateHouseIDcard[index]);
		    		 prplCompensateHouseDto.setKindcode("001");
		    		 prplCompensateHouseDto.setName(prplCompensateHouseName[index]);
		    		 prplCompensateHouseDto.setPhone(prplCompensateHousePhone[index]);
		    	     prplCompensateHouseDto.setNodeno(4);
		    	     prplCompensateHouseDto.setRegistno(httpServletRequest.getParameter("prpLclaimRegistNo"));
		    		 prplCompensateHouseDto.setNodetype("claim");
		    		 prplCompensateHouseDto.setPolicyno(httpServletRequest.getParameter("prpLclaimPolicyNo"));
		    		 prplCompensateHouseDto.setRemark(prplCompensateHouseRemark[index]);
					 prplCompensateHouseDto.setFloor(prplCompensateHouseFloor);
		    		 prplCompensateHouseDto.setBuildingnumber(prplCompensateHouseBuildingnumber);
		    		 prplCompensateHouseDto.setZhuannumber(prplCompensateHouseZhuannumber);
		    		 prplCompensateHouseDto.setWanumber(prplCompensateHouseWanumber);
		    		 prplCompensateHouseDto.setKitchennumber(prplCompensateHouseKitchennumber);
		    		 prplCompensateHouseDto.setOthernumber(prplCompensateHouseOthernumber);

					 prplCompensateHouseDtoList.add(prplCompensateHouseDto);
		    	 }
		    	 claimDto.setPrplCompensateHouseDtoList(prplCompensateHouseDtoList); 	 
		     }
        }
        
        
        
        /*---------------------耳标号信息表prpLcompensateear------------------------------------*/
        ArrayList prplCompensateEarDtoList = new ArrayList();
		PrplcompensateearDto prplCompensateEarDto = null;
  
		//从界面得到输入数组
		String   prpLclaimClaimNo  = httpServletRequest.getParameter("prpLclaimClaimNo");
		String   prpLclaimPolicyNo  = httpServletRequest.getParameter("prpLclaimPolicyNo");
		String   prpLclaimRegistNo  = httpServletRequest.getParameter("prpLclaimRegistNo");
		String   prpLclaimDamageStartDate  = httpServletRequest.getParameter("prpLclaimDamageStartDate");
		String   prpLclaimDamageCode  = httpServletRequest.getParameter("prpLclaimDamageCode");
		String   prpLclaimDamageName  = httpServletRequest.getParameter("prpLclaimDamageName");
		String[] prpLclaimLossKindCode = httpServletRequest.getParameterValues("prpLclaimLossKindCode");
		
		
		String[] prplCompensateEarAccount=httpServletRequest.getParameterValues("prplCompensateEarAccount");
		String[] prplCompensateEarBank=httpServletRequest.getParameterValues("prplCompensateEarBank");
		String[] prplCompensateEarBreedingAreaCode=httpServletRequest.getParameterValues("prplCompensateEarBreedingAreaCode");
		String[] prplCompensateEarBreedingAreaName=httpServletRequest.getParameterValues("prplCompensateEarBreedingAreaName");
		String[] prplCompensateEarCaseNo=httpServletRequest.getParameterValues("prplCompensateEarCaseNo");
		String[] prplCompensateEarClaimNo=httpServletRequest.getParameterValues("prplCompensateEarClaimNo");
		String[] prplCompensateEarClaimRate=httpServletRequest.getParameterValues("prplCompensateEarClaimRate");
		String[] prplCompensateEarCombineNo=httpServletRequest.getParameterValues("prplCompensateEarCombineNo");
		String[] prplCompensateEarCompensateNo=httpServletRequest.getParameterValues("prplCompensateEarCompensateNo");
		String[] prplCompensateEarCullNumber=httpServletRequest.getParameterValues("prplCompensateEarCullNumber");
		String[] prplCompensateEarDamageCode=httpServletRequest.getParameterValues("prplCompensateEarDamageCode");
		String[] prplCompensateEarDamageEndDate=httpServletRequest.getParameterValues("prplCompensateEarDamageEndDate");
		String[] prplCompensateEarDamageName=httpServletRequest.getParameterValues("prplCompensateEarDamageName");
		String[] prplCompensateEarDamageStartDate=httpServletRequest.getParameterValues("prplCompensateEarDamageStartDate");
		String[] prplCompensateEarDamageStartHour=httpServletRequest.getParameterValues("prplCompensateEarDamageStartHour");
		String[] prplCompensateEarDeadNumber=httpServletRequest.getParameterValues("prplCompensateEarDeadNumber");
		String[] prplCompensateEarDeadReason=httpServletRequest.getParameterValues("prplCompensateEarDeadReason");
		String[] prplCompensateEarDeductible=httpServletRequest.getParameterValues("prplCompensateEarDeductible");
		String[] prplCompensateEarDeductibleRate=httpServletRequest.getParameterValues("prplCompensateEarDeductibleRate");
		String[] prplCompensateEarEarNo=httpServletRequest.getParameterValues("prplCompensateEarEarNo");
		String[] prplCompensateEarEstimateLoss=httpServletRequest.getParameterValues("prplCompensateEarEstimateLoss");
		String[] prplCompensateEarFCode=httpServletRequest.getParameterValues("prplCompensateEarFCode");
		String[] prplCompensateEarId_Card=httpServletRequest.getParameterValues("prplCompensateEarId_Card");
		String[] prplCompensateEarInusreListCode=httpServletRequest.getParameterValues("prplCompensateEarInusreListCode");
		String[] prplCompensateEarKindCode=httpServletRequest.getParameterValues("prplCompensateEarKindCode");
		String[] prplCompensateEarName=httpServletRequest.getParameterValues("prplCompensateEarName");
		String[] prplCompensateEarNodeNo=httpServletRequest.getParameterValues("prplCompensateEarNodeNo");
		String[] prplCompensateEarNodeType=httpServletRequest.getParameterValues("prplCompensateEarNodeType");
		String[] prplCompensateEarPolicyNo=httpServletRequest.getParameterValues("prplCompensateEarPolicyNo");
		String[] prplCompensateEarRegistNo=httpServletRequest.getParameterValues("prplCompensateEarRegistNo");
		String[] prplCompensateEarReportTime=httpServletRequest.getParameterValues("prplCompensateEarReportTime");
		String[] prplCompensateEarRestFee=httpServletRequest.getParameterValues("prplCompensateEarRestFee");
		String[] prplCompensateEarSumRealpay=httpServletRequest.getParameterValues("prplCompensateEarSumRealpay");
		String[] prplCompensateEarUnitAmount=httpServletRequest.getParameterValues("prplCompensateEarUnitAmount");


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
				prplCompensateEarDto.setClaimno(prpLclaimClaimNo);
				prplCompensateEarDto.setClaimrate(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarClaimRate[index])));
				prplCompensateEarDto.setCombineno(httpServletRequest.getParameter("CombineNo"));
				prplCompensateEarDto.setCompensateno(prplCompensateEarCompensateNo[index]);
				prplCompensateEarDto.setCullnumber(Integer.valueOf(DataUtils.nullToZero(prplCompensateEarCullNumber[index])));
				prplCompensateEarDto.setDamagecode(prpLclaimDamageCode);
				prplCompensateEarDto.setDamageenddate(new DateTime(prplCompensateEarDamageEndDate[index],DateTime.YEAR_TO_DAY));
				prplCompensateEarDto.setDamagename(prpLclaimDamageName);
				prplCompensateEarDto.setDamagestartdate(new DateTime(prpLclaimDamageStartDate,DateTime.YEAR_TO_DAY));
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
				prplCompensateEarDto.setKindcode(prpLclaimLossKindCode[1]);
				prplCompensateEarDto.setName(prplCompensateEarName[index]);
				prplCompensateEarDto.setNodeno(4);
				prplCompensateEarDto.setNodetype("claim");
				prplCompensateEarDto.setPolicyno(prpLclaimPolicyNo);
				prplCompensateEarDto.setRegistno(prpLclaimRegistNo);
				prplCompensateEarDto.setBusinessno(prpLclaimRegistNo);
				prplCompensateEarDto.setReporttime(prplCompensateEarReportTime[index]);
				prplCompensateEarDto.setRestfee(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarRestFee[index])));
				prplCompensateEarDto.setSumrealpay(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarSumRealpay[index])));
				prplCompensateEarDto.setUnitamount(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarUnitAmount[index])));

				
    			prplCompensateEarDtoList.add(prplCompensateEarDto);
			}
		}
		claimDto.setPrpLcompensateeartDtoList(prplCompensateEarDtoList);
        
        /*---------------------立案操作状态内容prpLclaimStatus------------------------------------*/
        PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
        prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
        prpLclaimStatusDto.setBusinessNo(prpLclaimDto.getClaimNo());
        prpLclaimStatusDto.setPolicyNo(prpLclaimDto.getPolicyNo());
        prpLclaimStatusDto.setNodeType("claim");
        prpLclaimStatusDto.setSerialNo(0);
        prpLclaimStatusDto.setRiskCode(prpLclaimDto.getRiskCode());
        //取得当前用户信息，写操作员信息到实赔中
        HttpSession session = httpServletRequest.getSession();
        UserDto user = (UserDto) session.getAttribute("user");
        prpLclaimStatusDto.setHandlerCode(user.getUserCode());
        //prpLclaimStatusDto.setHandlerCode(prpLclaimDto.getOperatorCode() );
        prpLclaimStatusDto.setInputDate(prpLclaimDto.getInputDate());
        prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
        claimDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
        return claimDto;
    }

    /**
     * 取初始化信息需要的数据的整理. 填写立案单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参， 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。
     * 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
     * 
     * @param httpServletRequest
     * @return RequestDto 取初始化信息需要的数据
     * @throws Exception
     */
    public abstract ClaimDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception;

    /**
     * 填写立案页面及查询立案request的生成. 填写立案时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
     * 
     * @param httpServletRequest 返回给页面的request
     * @param claimDto 取出的初始化信息Dto
     * @throws Exception
     */
    public abstract void dtoToView(HttpServletRequest httpServletRequest, ClaimDto claimDto) throws Exception;

}