package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.claim.webservice.RegistEditPostInfo;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.utility.string.ChgDate;

/**
 * <p>
 * Title: RegistViewHelper
 * </p>
 * <p>
 * Description:报案ViewHelper类，在该类中完成页面数据的整理
 * </p>
 * <p>
 * Copyright: Copyright 中科软科技股份有限公司(c) 2004
 * </p>
 * 
 * @author 车险理赔项目组 weishixin
 * @version 1.0 <br>
 */

public abstract class RegistViewHelper {
    private int RULE_LENGTH = 70; //rule字段的长度
    /**
     * 默认构造方法
     */
    public RegistViewHelper() {
    }
    /**
     * 保存报案时报案页面数据整理. 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
     * 
     * @param httpServletRequest
     * @return registDto 报案数据传输数据结构
     * @throws Exception
     */
    public RegistDto viewToDto(HttpServletRequest httpServletRequest) throws Exception {
        RegistDto registDto = new RegistDto();
        /*---------------------报案主表prpLregist------------------------------------*/
        PrpLregistDto prpLregistDto = new PrpLregistDto();
        prpLregistDto.setRegistNo((String) httpServletRequest.getAttribute("registNo"));
        prpLregistDto.setLFlag(httpServletRequest.getParameter("prpLregistLFlag"));
        prpLregistDto.setClassCode(httpServletRequest.getParameter("prpLregistClassCode"));
        prpLregistDto.setRiskCode(httpServletRequest.getParameter("prpLregistRiskCode"));
        prpLregistDto.setPolicyNo(httpServletRequest.getParameter("prpLregistPolicyNo"));
        prpLregistDto.setLanguage(httpServletRequest.getParameter("prpLregistLanguage"));
        prpLregistDto.setInsuredCode(httpServletRequest.getParameter("prpLregistInsuredCode"));
        prpLregistDto.setInsuredName(httpServletRequest.getParameter("prpLregistInsuredName"));
        String strInsuredNameShow = httpServletRequest.getParameter("prpLregistInsuredNameShow");
        if(strInsuredNameShow!=null&&strInsuredNameShow.length()>0){
        	prpLregistDto.setInsuredName(httpServletRequest.getParameter("prpLregistInsuredNameShow"));//对于团单，存储第一个被保险人加人数	
        }
        prpLregistDto.setInsuredAddress(httpServletRequest.getParameter("prpLregistInsuredAddress"));
        prpLregistDto.setClauseType(httpServletRequest.getParameter("prpLregistClauseType"));
        prpLregistDto.setLicenseNo(httpServletRequest.getParameter("prpLregistLicenseNo"));
        prpLregistDto.setLicenseColorCode(httpServletRequest.getParameter("prpLregistLicenseColorCode"));
        prpLregistDto.setCarKindCode(httpServletRequest.getParameter("prpLregistCarKindCode"));
        prpLregistDto.setModelCode(httpServletRequest.getParameter("prpLregistModelCode"));
        prpLregistDto.setBrandName(httpServletRequest.getParameter("prpLregistBrandName"));
        prpLregistDto.setEngineNo(httpServletRequest.getParameter("prpLregistEngineNo"));
        prpLregistDto.setFrameNo(httpServletRequest.getParameter("prpLregistFrameNo"));
        prpLregistDto.setRunDistance(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLregistRunDistance"))));
        prpLregistDto.setUseYears(Integer.parseInt(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLregistUseYears"))));
        prpLregistDto.setReportDate(new DateTime(httpServletRequest.getParameter("prpLregistReportDate"),
                DateTime.YEAR_TO_DAY));

        prpLregistDto.setReportorPhoneNumber(httpServletRequest.getParameter("prpLregistReportorPhoneNumber"));
        prpLregistDto.setLinkerPostCode(httpServletRequest.getParameter("prpLregistLinkerPostCode"));
        prpLregistDto.setLinkerAddress(httpServletRequest.getParameter("prpLregistLinkerAddress"));

        //为了兼容大地程序的小时设置情况，所以只保存小时，分和秒先不保存
        prpLregistDto.setReportHour(StringConvert.newString(httpServletRequest.getParameter("prpLregistReportHour"))
                + ":" + StringConvert.newString(httpServletRequest.getParameter("prpLregistReportMinute")) + ":00");

        prpLregistDto.setReportAddress(httpServletRequest.getParameter("prpLregistReportAddress"));
        prpLregistDto.setReportorName(httpServletRequest.getParameter("prpLregistReportorName"));
        prpLregistDto.setReportType(httpServletRequest.getParameter("reportType"));
        prpLregistDto.setPhoneNumber(httpServletRequest.getParameter("prpLregistPhoneNumber"));
        prpLregistDto.setLinkerName(httpServletRequest.getParameter("prpLregistLinkerName"));
        prpLregistDto.setDamageStartDate(new DateTime(httpServletRequest.getParameter("prpLregistDamageStartDate"),
                DateTime.YEAR_TO_DAY));
        //为了兼容大地程序的小时设置情况，所以只保存小时，分和秒先不保存
        prpLregistDto
                .setDamageStartHour(StringConvert.newString(httpServletRequest
                        .getParameter("prpLregistDamageStartHour"))
                        + ":"
                        + StringConvert.newString(httpServletRequest.getParameter("prpLregistDamageStartMinute"))
                        + ":00");

        prpLregistDto.setDamageEndDate(new DateTime(httpServletRequest.getParameter("prpLregistDamageStartDate"),
                DateTime.YEAR_TO_DAY));

        //为了兼容大地程序的小时设置情况，所以只保存小时，分和秒先不保存
        prpLregistDto
                .setDamageEndHour(StringConvert.newString(httpServletRequest.getParameter("prpLregistDamageStartHour"))
                        + ":" + StringConvert.newString(httpServletRequest.getParameter("prpLregistDamageStartMinute"))
                        + ":00");

        prpLregistDto.setDamageCode(httpServletRequest.getParameter("prpLregistDamageCode"));
        prpLregistDto.setDamageName(httpServletRequest.getParameter("prpLregistDamageName"));
        prpLregistDto.setDamageTypeCode(httpServletRequest.getParameter("prpLregistDamageTypeCode"));
        prpLregistDto.setDamageTypeName(httpServletRequest.getParameter("prpLregistDamageTypeName"));
        prpLregistDto.setFirstSiteFlag(httpServletRequest.getParameter("firstSiteFlag"));
        prpLregistDto.setAddressCode(httpServletRequest.getParameter("prpLregistAddressCode"));
        prpLregistDto.setDamageAreaCode(httpServletRequest.getParameter("prpLregistDamageAreaCode"));
        prpLregistDto.setDamageAreaName(httpServletRequest.getParameter("prpLregistDamageAreaName"));
        prpLregistDto.setDamageAddressType(httpServletRequest.getParameter("damageAddressType"));
        prpLregistDto.setDamageAddress(httpServletRequest.getParameter("prpLregistDamageAddress"));
        prpLregistDto.setDamageAreaPostCode(httpServletRequest.getParameter("prpLregistDamageAreaPostCode"));
        prpLregistDto.setHandleUnit(httpServletRequest.getParameter("prpLregistHandleUnit"));
        prpLregistDto.setLossName(httpServletRequest.getParameter("prpLregistLossName"));
        prpLregistDto.setLossQuantity(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLregistLossQuantity"))));
        prpLregistDto.setUnit(httpServletRequest.getParameter("prpLregistUnit"));
        prpLregistDto.setEstiCurrency(httpServletRequest.getParameter("prpLregistEstiCurrency"));
        prpLregistDto.setEstimateLoss(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLregistEstimateLoss"))));

        //modify by wangwei add start 20050602
        //原因：增加一个字段
        prpLregistDto.setEstimateFee(Double.parseDouble(DataUtils.nullToZero(httpServletRequest
                .getParameter("prpLregistEstimateFee"))));
        //modify by wangwei add end 20050602

        prpLregistDto.setReceiverName(httpServletRequest.getParameter("prpLregistReceiverName"));
        prpLregistDto.setHandlerCode(httpServletRequest.getParameter("prpLregistHandlerCode"));
        prpLregistDto.setHandler1Code(httpServletRequest.getParameter("prpLregistHandler1Code"));
        prpLregistDto.setComCode(httpServletRequest.getParameter("prpLregistComCode"));
        //车险报案时，录入时间显示到时分
        if("05".equals(prpLregistDto.getClassCode())){
        	prpLregistDto.setInputDate(new DateTime(httpServletRequest.getParameter("prpLregistInputDate"),
                DateTime.YEAR_TO_SECOND));
        }else{

			if(!"".equals(httpServletRequest.getParameter("prpLregistInputDate")))
			{
				ChgDate idate = new ChgDate();
				String	currentTime = idate.getCurrentTime(" HH:mm:ss");
	            if(httpServletRequest.getParameter("prpLregistInputDate").length()<12)
	            {
	            	prpLregistDto.setInputDate(new DateTime(httpServletRequest.getParameter("prpLregistInputDate")+currentTime,
		                DateTime.YEAR_TO_SECOND));
	            }
	            else
	            {
	            	prpLregistDto.setInputDate(new DateTime(httpServletRequest.getParameter("prpLregistInputDate"),
			                DateTime.YEAR_TO_SECOND));
	            }
			}
			else
			{
        	prpLregistDto.setInputDate(new DateTime(httpServletRequest.getParameter("prpLregistInputDate"),
                DateTime.YEAR_TO_DAY));
			}
        }
        prpLregistDto.setAcceptFlag(httpServletRequest.getParameter("acceptFlag"));
        //prpLregistDto.setAcceptFlag (httpServletRequest.getParameter("prpLregistAcceptFlag" ));
        prpLregistDto.setRepeatInsureFlag(httpServletRequest.getParameter("repeatInsureFlag"));
        prpLregistDto.setClaimType(httpServletRequest.getParameter("claimType"));
        prpLregistDto.setCancelDate(new DateTime(httpServletRequest.getParameter("prpLregistCancelDate"),
                DateTime.YEAR_TO_DAY));
        prpLregistDto.setDealerCode(httpServletRequest.getParameter("prpLregistDealerCode"));
        prpLregistDto.setRemark(httpServletRequest.getParameter("prpLregistRemark"));
        prpLregistDto.setOperatorCode(httpServletRequest.getParameter("prpLregistOperatorCode"));
        prpLregistDto.setMakeCom(httpServletRequest.getParameter("prpLregistMakeCom"));
        prpLregistDto.setFlag(httpServletRequest.getParameter("prpLregistFlag"));

        //原因：添加巨灾代码
        prpLregistDto.setCatastropheCode1(httpServletRequest.getParameter("prpCatastropheCode1"));
        prpLregistDto.setCatastropheName1(httpServletRequest.getParameter("prpCatastropheName1"));
        prpLregistDto.setCatastropheCode2(httpServletRequest.getParameter("prpCatastropheCode2"));
        prpLregistDto.setCatastropheName2(httpServletRequest.getParameter("prpCatastropheName2"));
        //意键险需要添加是否呈报字段
        prpLregistDto.setReportFlag(httpServletRequest.getParameter("prplregistReportFlag"));
        
        //add by wunier 20071228
        //reason:添加赔付数量和数量单位
        double lossesNumber = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLregistLossesNumber")));
        prpLregistDto.setLossesNumber(lossesNumber);
        prpLregistDto.setLossesUnitCode(httpServletRequest.getParameter("lossesUnitCode"));
        //事故责任
        prpLregistDto.setIndemnityDuty(httpServletRequest.getParameter("indemnityDuty"));
        //end by wunier  20071228

        //加到ArrayList中
        registDto.setPrpLregistDto(prpLregistDto);
        
        //事故者信息模块
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
            	prpLacciBenPersonProposerDto.setCertiNo((String) httpServletRequest.getAttribute("registNo"));
            	prpLacciBenPersonProposerDto.setCertiType("01"); //事故者信息
            	prpLacciBenPersonProposerDto.setPolicyNo(httpServletRequest.getParameter("prpLregistPolicyNo"));
            	//prpLacciBenPersonProposerDto.setSerialNo(uiPolicyAction.findBySeriaNo("1=1") + 1);
                  //分户序号从界面上取
            	prpLacciBenPersonProposerDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLacciBenPersonSerialNo[index])));
            	prpLacciBenPersonProposerDto.setFamilyNo(Integer.parseInt(DataUtils.nullToZero(prpLacciPersonFamilyNo[index])));
            	prpLacciBenPersonProposerDto.setAcciCode(prpLacciPersonAcciCode[index]);
            	prpLacciBenPersonProposerDto.setAcciName(prpLacciPersonAcciName[index]);
            	prpLacciBenPersonProposerDto.setAge(Integer.parseInt(DataUtils.nullToZero(prpLacciPersonAge[index])));
            	//如果没有选择性别
            	if(prpLacciPersonSex.length == 1){
            	}else{
            		prpLacciBenPersonProposerDto.setSex(prpLacciPersonSex[index]);
            	}
            	prpLacciBenPersonProposerDto.setIdentifyNumber(prpLacciPersonIdentifyNumber[index]);
            	prpLacciBenPersonProposerDto.setAddress(prpLacciPersonAddress[index]);//暂存牛号信息
                //加入集合
            	prpLacciBenPersonList.add(prpLacciBenPersonProposerDto);
            }
        }
        
        registDto.setPrplacciBenPersonDtoList(prpLacciBenPersonList);
        
        /*---------------------耳标号信息表prpLcompensateear------------------------------------*/
        ArrayList prplCompensateEarDtoList = new ArrayList();
		PrplcompensateearDto prplCompensateEarDto = null;
		
  
		//从界面得到输入数组
		String   prpLregistPolicyNo  = httpServletRequest.getParameter("prpLregistPolicyNo");
		String   prpLregistRegistNo  = httpServletRequest.getParameter("prpLregistRegistNo");
		String   prpLregistDamageStartDate  = httpServletRequest.getParameter("prpLregistDamageStartDate");
		String   prpLregistReportDate  = httpServletRequest.getParameter("prpLregistReportDate");
		String   prpLregistDamageCode  = httpServletRequest.getParameter("prpLregistDamageCode");
		String   prpLregistDamageName  = httpServletRequest.getParameter("prpLregistDamageName");
		
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
				prplCompensateEarDto.setClaimno(prplCompensateEarClaimNo[index]);
				prplCompensateEarDto.setClaimrate(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarClaimRate[index])));
				prplCompensateEarDto.setCombineno(httpServletRequest.getParameter("Combine"));
				prplCompensateEarDto.setCompensateno(prplCompensateEarCompensateNo[index]);
				prplCompensateEarDto.setCullnumber(Integer.valueOf(DataUtils.nullToZero(prplCompensateEarCullNumber[index])));
				prplCompensateEarDto.setDamagecode(prpLregistDamageCode);
				prplCompensateEarDto.setDamageenddate(new DateTime(prplCompensateEarDamageEndDate[index],DateTime.YEAR_TO_DAY));
				prplCompensateEarDto.setDamagename(prpLregistDamageName);
				prplCompensateEarDto.setDamagestartdate(new DateTime(prpLregistDamageStartDate,DateTime.YEAR_TO_DAY));
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
				prplCompensateEarDto.setNodeno(1);
				prplCompensateEarDto.setNodetype("regis");
				prplCompensateEarDto.setPolicyno(prpLregistPolicyNo);
				prplCompensateEarDto.setRegistno((String) httpServletRequest.getAttribute("registNo"));
				prplCompensateEarDto.setBusinessno((String) httpServletRequest.getAttribute("registNo"));
				prplCompensateEarDto.setReporttime(prpLregistReportDate);
				prplCompensateEarDto.setRestfee(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarRestFee[index])));
				prplCompensateEarDto.setSumrealpay(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarSumRealpay[index])));
				prplCompensateEarDto.setUnitamount(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarUnitAmount[index])));

				
    			prplCompensateEarDtoList.add(prplCompensateEarDto);
			}
		}
		registDto.setPrpLcompensateEarDtoList(prplCompensateEarDtoList);
		
        String temp2 = httpServletRequest.getParameter("prpLregistRiskCode");
		
		if("0310".equals(temp2)||"0312".equals(temp2))
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
			//System.err.println("length1:" + prplCompensateHouseIDcard.length);
			//System.err.println("length2:" + prplCompensateHouseCaseNo.length);
			if (prplCompensateHouseIDcard == null){
		     }else{
		    	 for(int index = 1;index < prplCompensateHouseIDcard.length;index++)
		    	 {
		    		 prplCompensateHouseDto = new PrplcompensatehouseDto();
		    		 prplCompensateHouseDto.setAddress(prplCompensateHouseAddress[index]);
		    		 prplCompensateHouseDto.setBusinessno((String) httpServletRequest.getAttribute("registNo"));
		    		 prplCompensateHouseDto.setCaseno(prplCompensateHouseCaseNo[index]);
		    		 prplCompensateHouseDto.setClaimno(prplCompensateHouseClaimNo[index]);
		    		 prplCompensateHouseDto.setCompensateno(prplCompensateHouseClaimNo[index]);
		    		 prplCompensateHouseDto.setDamagecode(prpLregistDamageCode);
		    		 prplCompensateHouseDto.setDamagename(prpLregistDamageName);
		    		 prplCompensateHouseDto.setDamagestartdate(new DateTime(prpLregistDamageStartDate,DateTime.YEAR_TO_DAY));
		    		 prplCompensateHouseDto.setEstimateloss(Double.parseDouble(DataUtils.nullToZero(prplCompensateHouseEstimateLoss[index])));
		    		 prplCompensateHouseDto.setHukoubu(prplCompensateHousehukoubu[index]);
		    		 prplCompensateHouseDto.setIdcard(prplCompensateHouseIDcard[index]);
		    		 prplCompensateHouseDto.setKindcode("001");
		    		 prplCompensateHouseDto.setName(prplCompensateHouseName[index]);
		    		 prplCompensateHouseDto.setPhone(prplCompensateHousePhone[index]);
		    		 prplCompensateHouseDto.setRegistno((String) httpServletRequest.getAttribute("registNo"));
		    		 prplCompensateHouseDto.setPolicyno(prpLregistPolicyNo);
		    		 prplCompensateHouseDto.setNodeno(1);
		    		 prplCompensateHouseDto.setNodetype("regis");
		    		 prplCompensateHouseDto.setRemark(prplCompensateHouseRemark[index]);
					 prplCompensateHouseDto.setFloor(prplCompensateHouseFloor);
		    		 prplCompensateHouseDto.setBuildingnumber(prplCompensateHouseBuildingnumber);
		    		 prplCompensateHouseDto.setZhuannumber(prplCompensateHouseZhuannumber);
		    		 prplCompensateHouseDto.setWanumber(prplCompensateHouseWanumber);
		    		 prplCompensateHouseDto.setKitchennumber(prplCompensateHouseKitchennumber);
		    		 prplCompensateHouseDto.setOthernumber(prplCompensateHouseOthernumber);
					 prplCompensateHouseDtoList.add(prplCompensateHouseDto);

		    	 }
		    	 //System.err.println("长度:" + prplCompensateHouseDtoList.size());
		    	 registDto.setPrplCompensateHouseDtoList(prplCompensateHouseDtoList); 	 
		     }
		}
		
		
			
        /*---------------------报案文本表prpLregistText------------------------------------*/
        ArrayList prpLregistTextDtoList = new ArrayList();

        String TextTemp = httpServletRequest.getParameter("prpLregistTextContextInnerHTML");
        String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);

        //得到连接串,下面将其切分到数组
        for (int k = 0; k < rules.length; k++) {
            PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
            prpLregistTextDto.setRegistNo((String) httpServletRequest.getAttribute("registNo"));
            prpLregistTextDto.setContext(rules[k]);
            prpLregistTextDto.setLineNo(k + 1);
            prpLregistTextDto.setTextType("1");
            prpLregistTextDtoList.add(prpLregistTextDto);
        }
        //装入RegistDto
        registDto.setPrpLregistTextDtoList(prpLregistTextDtoList);

        //原因：添加呈报信息  2005-08-01
       if (httpServletRequest.getParameter("prplregistReportFlag") != null && !httpServletRequest.getParameter("prplregistReportFlag").equals("")) {
            ArrayList prpLregistTextDtoList2 = new ArrayList();
            String TextTemp2 = httpServletRequest.getParameter("prpLregistTextContextInnerHTML2");
            String[] rules2 = StringUtils.split(TextTemp2, RULE_LENGTH);

           //得到连接串,下面将其切分到数组
            for (int k = 0; k < rules2.length; k++) {
                PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
                prpLregistTextDto.setRegistNo((String) httpServletRequest.getAttribute("registNo"));
                prpLregistTextDto.setContext(rules2[k]);
                prpLregistTextDto.setLineNo(k + 1);
                prpLregistTextDto.setTextType("4");
                prpLregistTextDtoList2.add(prpLregistTextDto);
            }
            //装入RegistDto
            registDto.setPrpLregistTextDtoList2(prpLregistTextDtoList2);
        }

       /*---------------------------详细出险原因----------------------------------*/
       String strDamageMessage = httpServletRequest.getParameter("damageMessageFlag");
       if(strDamageMessage!=null && !strDamageMessage.equals("")){
    	   ArrayList prpLregistTextDtoList3 = new ArrayList();
    	   String[] damageMessage = httpServletRequest.getParameterValues("damageMessage");
    	   if(damageMessage != null){
	    	   for(int index = 0;index<damageMessage.length;index++){
	    		   PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
	    		   prpLregistTextDto.setRegistNo((String) httpServletRequest.getAttribute("registNo"));
	    		   prpLregistTextDto.setLineNo(index+1);
	    		   prpLregistTextDto.setContext(damageMessage[index]);
	    		   prpLregistTextDto.setTextType(strDamageMessage);
	    		   prpLregistTextDtoList3.add(prpLregistTextDto);
	    	   }
    	   }
    	   registDto.setPrpLregistTextDtoList3(prpLregistTextDtoList3);
       }
        /*---------------------立案操作状态内容prpLclaimStatus------------------------------------*/
        PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
        prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
        prpLclaimStatusDto.setBusinessNo(prpLregistDto.getRegistNo());
        prpLclaimStatusDto.setPolicyNo(prpLregistDto.getPolicyNo());
        prpLclaimStatusDto.setNodeType("regis");
        prpLclaimStatusDto.setSerialNo(0);

        //取得当前用户信息，写操作员信息到实赔中
        HttpSession session = httpServletRequest.getSession();
        UserDto user = (UserDto) session.getAttribute("user");
        prpLclaimStatusDto.setHandlerCode(user.getUserCode());
        //prpLclaimStatusDto.setHandlerCode(prpLregistDto.getOperatorCode() );
        prpLclaimStatusDto.setInputDate(prpLregistDto.getInputDate());
        prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
        prpLclaimStatusDto.setRiskCode(prpLregistDto.getRiskCode());
        registDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
        return registDto;
    }
    
    public RegistDto viewToDtoNew(RegistEditPostInfo registEditPostInfo) throws Exception {
        RegistDto registDto = new RegistDto();
        /*---------------------报案主表prpLregist------------------------------------*/
        PrpLregistDto prpLregistDto = new PrpLregistDto();
        prpLregistDto.setRegistNo(registEditPostInfo.getRegistNo());
        prpLregistDto.setLFlag(registEditPostInfo.getPrpLregistLFlag());
        prpLregistDto.setClassCode(registEditPostInfo.getPrpLregistClassCode());
        prpLregistDto.setRiskCode(registEditPostInfo.getPrpLregistRiskCode());
        prpLregistDto.setPolicyNo(registEditPostInfo.getPrpLregistPolicyNo());
        prpLregistDto.setLanguage(registEditPostInfo.getPrpLregistLanguage());
        prpLregistDto.setInsuredCode(registEditPostInfo.getPrpLregistInsuredCode());
        prpLregistDto.setInsuredName(registEditPostInfo.getPrpLregistInsuredName());
        
        String strInsuredNameShow = registEditPostInfo.getPrpLregistInsuredName();
        if(strInsuredNameShow!=null&&strInsuredNameShow.length()>0){
        	prpLregistDto.setInsuredName(strInsuredNameShow);//对于团单，存储第一个被保险人加人数	
        }
        prpLregistDto.setInsuredAddress(registEditPostInfo.getPrpLregistInsuredAddress());
        prpLregistDto.setClauseType(registEditPostInfo.getPrpLregistClauseType());
        prpLregistDto.setLicenseNo(registEditPostInfo.getPrpLregistLicenseNo());
        prpLregistDto.setLicenseColorCode(registEditPostInfo.getPrpLregistLicenseColorCode());
        prpLregistDto.setCarKindCode(registEditPostInfo.getPrpLregistCarKindCode());
        prpLregistDto.setModelCode(registEditPostInfo.getPrpLregistModelCode());
        prpLregistDto.setBrandName(registEditPostInfo.getPrpLregistBrandName());
        prpLregistDto.setEngineNo(registEditPostInfo.getPrpLregistEngineNo());
        prpLregistDto.setFrameNo(registEditPostInfo.getPrpLregistFrameNo());
        prpLregistDto.setRunDistance(Double.parseDouble(DataUtils.nullToZero(registEditPostInfo.getPrpLregistRunDistance())));
        prpLregistDto.setUseYears(Integer.parseInt(DataUtils.nullToZero(registEditPostInfo.getPrpLregistUseYears())));
        prpLregistDto.setReportDate(new DateTime(registEditPostInfo.getPrpLregistReportDate(),
                DateTime.YEAR_TO_DAY));

        prpLregistDto.setReportorPhoneNumber(registEditPostInfo.getPrpLregistReportorPhoneNumber());
        prpLregistDto.setLinkerPostCode(registEditPostInfo.getPrpLregistLinkerPostCode());
        prpLregistDto.setLinkerAddress(registEditPostInfo.getPrpLregistLinkerAddress());

        //为了兼容大地程序的小时设置情况，所以只保存小时，分和秒先不保存
        prpLregistDto.setReportHour(StringConvert.newString(registEditPostInfo.getPrpLregistReportHour())
                + ":00");

        prpLregistDto.setReportAddress(registEditPostInfo.getPrpLregistReportAddress());
        prpLregistDto.setReportorName(registEditPostInfo.getPrpLregistReportorName());
        prpLregistDto.setReportType(registEditPostInfo.getReportType());
        prpLregistDto.setPhoneNumber(registEditPostInfo.getPrpLregistPhoneNumber());
        prpLregistDto.setLinkerName(registEditPostInfo.getPrpLregistLinkerName());
        prpLregistDto.setDamageStartDate(new DateTime(registEditPostInfo.getPrpLregistDamageStartDate(),
                DateTime.YEAR_TO_DAY));
        //为了兼容大地程序的小时设置情况，所以只保存小时，分和秒先不保存
        prpLregistDto.setDamageStartHour(StringConvert
				.newString(registEditPostInfo.getPrpLregistDamageStartHour())
				+ ":"
				+ StringConvert.newString(registEditPostInfo.getPrpLregistDamageStartMinute())
				+ ":00");

		prpLregistDto.setDamageEndDate(new DateTime(registEditPostInfo.getPrpLregistDamageStartDate(),
				DateTime.YEAR_TO_DAY));

		// 为了兼容大地程序的小时设置情况，所以只保存小时，分和秒先不保存
		prpLregistDto.setDamageEndHour(StringConvert
				.newString(registEditPostInfo.getPrpLregistDamageStartHour())
				+ ":"
				+ StringConvert.newString(registEditPostInfo.getPrpLregistDamageStartMinute())
				+ ":00");

		prpLregistDto.setDamageCode(registEditPostInfo.getPrpLregistDamageCode());
		prpLregistDto.setDamageName(registEditPostInfo.getPrpLregistDamageName());
		prpLregistDto.setDamageTypeCode(registEditPostInfo.getPrpLregistDamageTypeCode());
		prpLregistDto.setDamageTypeName(registEditPostInfo.getPrpLregistDamageTypeName());
        prpLregistDto.setFirstSiteFlag(registEditPostInfo.getFirstSiteFlag());
        prpLregistDto.setAddressCode(registEditPostInfo.getPrpLregistAddressCode());
        prpLregistDto.setDamageAreaCode(registEditPostInfo.getPrpLregistDamageAreaCode());
        prpLregistDto.setDamageAreaName(registEditPostInfo.getPrpLregistDamageAreaName());
        prpLregistDto.setDamageAddressType(registEditPostInfo.getDamageAddressType());
        prpLregistDto.setDamageAddress(registEditPostInfo.getPrpLregistDamageAddress());
        prpLregistDto.setDamageAreaPostCode(registEditPostInfo.getPrpLregistDamageAreaPostCode());
        prpLregistDto.setHandleUnit(registEditPostInfo.getPrpLregistHandleUnit());
        prpLregistDto.setLossName(registEditPostInfo.getPrpLregistLossName());
        prpLregistDto.setLossQuantity(Double.parseDouble(DataUtils.nullToZero(registEditPostInfo.getPrpLregistLossQuantity())));
        prpLregistDto.setUnit(registEditPostInfo.getPrpLregistUnit());
        prpLregistDto.setEstiCurrency(registEditPostInfo.getPrpLregistEstiCurrency());
        prpLregistDto.setEstimateLoss(Double.parseDouble(DataUtils.nullToZero(registEditPostInfo.getPrpLregistEstimateLoss())));

        //modify by wangwei add start 20050602
        //原因：增加一个字段
        prpLregistDto.setEstimateFee(Double.parseDouble(DataUtils.nullToZero(registEditPostInfo.getPrpLregistEstimateFee())));
        //modify by wangwei add end 20050602

        prpLregistDto.setReceiverName(registEditPostInfo.getPrpLregistReceiverName());
        prpLregistDto.setHandlerCode(registEditPostInfo.getPrpLregistHandlerCode());
        prpLregistDto.setHandler1Code(registEditPostInfo.getPrpLregistHandler1Code());
        prpLregistDto.setComCode(registEditPostInfo.getPrpLregistComCode());
        //车险报案时，录入时间显示到时分
        if("05".equals(prpLregistDto.getClassCode())){
        	prpLregistDto.setInputDate(new DateTime(registEditPostInfo.getPrpLregistInputDate(),
                DateTime.YEAR_TO_SECOND));
        }else{
        	prpLregistDto.setInputDate(new DateTime(registEditPostInfo.getPrpLregistInputDate(),
                DateTime.YEAR_TO_DAY));
        }
        prpLregistDto.setAcceptFlag(registEditPostInfo.getAcceptFlag());
        //-----------prpLregistDto.setAcceptFlag (httpServletRequest.getParameter("prpLregistAcceptFlag" ));
        prpLregistDto.setRepeatInsureFlag(registEditPostInfo.getRepeatInsureFlag());
        prpLregistDto.setClaimType(registEditPostInfo.getClaimType());
        prpLregistDto.setCancelDate(new DateTime(registEditPostInfo.getPrpLregistCancelDate(),
                DateTime.YEAR_TO_DAY));
        prpLregistDto.setDealerCode(registEditPostInfo.getPrpLregistDealerCode());
        prpLregistDto.setRemark(registEditPostInfo.getPrpLregistRemark());
        prpLregistDto.setOperatorCode(registEditPostInfo.getPrpLregistOperatorCode());
        prpLregistDto.setMakeCom(registEditPostInfo.getPrpLregistMakeCom());
        prpLregistDto.setFlag(registEditPostInfo.getPrpLregistFlag());

        //原因：添加巨灾代码
        prpLregistDto.setCatastropheCode1(registEditPostInfo.getPrpCatastropheCode1());
        prpLregistDto.setCatastropheName1(registEditPostInfo.getPrpCatastropheName1());
        prpLregistDto.setCatastropheCode2(registEditPostInfo.getPrpCatastropheCode2());
        prpLregistDto.setCatastropheName2(registEditPostInfo.getPrpCatastropheName2());
        //意键险需要添加是否呈报字段
        prpLregistDto.setReportFlag(registEditPostInfo.getPrplregistReportFlag());
        
        //add by wunier 20071228
        //reason:添加赔付数量和数量单位
        double lossesNumber = Double.parseDouble(DataUtils.nullToZero(registEditPostInfo.getPrpLregistLossesNumber()));
        prpLregistDto.setLossesNumber(lossesNumber);
        prpLregistDto.setLossesUnitCode(registEditPostInfo.getLossesUnitCode());
        //事故责任
        prpLregistDto.setIndemnityDuty(registEditPostInfo.getIndemnityDuty());
        //end by wunier  20071228

        //加到ArrayList中
        registDto.setPrpLregistDto(prpLregistDto);
        
        //事故者信息模块
        ArrayList prpLacciBenPersonList = new ArrayList();
        PrpLacciPersonDto   prpLacciBenPersonProposerDto = null;
        String[] prpLacciPersonAcciCode = registEditPostInfo.getPrpLacciPersonAcciCode();
        String[] prpLacciBenPersonSerialNo = registEditPostInfo.getPrpLacciBenPersonSerialNo();
        String[] prpLacciPersonAcciName = registEditPostInfo.getPrpLacciPersonAcciName();
        String[] prpLacciPersonFamilyNo = registEditPostInfo.getPrpLacciPersonFamilyNo();
        String[] prpLacciPersonAge = registEditPostInfo.getPrpLacciPersonAge();
        String[] prpLacciPersonSex = registEditPostInfo.getPrpLacciPersonSex();
        String[] prpLacciPersonIdentifyNumber = registEditPostInfo.getPrpLacciPersonIdentifyNumber();
        String[] prpLacciPersonAddress = registEditPostInfo.getPrpLacciPersonAddress();
        
        
        //对象赋值
        if (prpLacciPersonFamilyNo ==null) {
        } else { 
        	
            for (int index = 0; index < prpLacciPersonFamilyNo.length; index++) {
            	prpLacciBenPersonProposerDto = new PrpLacciPersonDto();
            	prpLacciBenPersonProposerDto.setCertiNo(registEditPostInfo.getRegistNo());
            	prpLacciBenPersonProposerDto.setCertiType("01"); //事故者信息
            	prpLacciBenPersonProposerDto.setPolicyNo(registEditPostInfo.getPrpLregistPolicyNo());
                  //分户序号从界面上取
            	prpLacciBenPersonProposerDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLacciBenPersonSerialNo[index])));
            	prpLacciBenPersonProposerDto.setFamilyNo(Integer.parseInt(DataUtils.nullToZero(prpLacciPersonFamilyNo[index])));
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
        
        registDto.setPrplacciBenPersonDtoList(prpLacciBenPersonList);
        
        /*---------------------耳标号信息表prpLcompensateear------------------------------------*/
        ArrayList prplCompensateEarDtoList = new ArrayList();
		PrplcompensateearDto prplCompensateEarDto = null;
		
  
		//从界面得到输入数组
		String   prpLregistPolicyNo  = registEditPostInfo.getPrpLregistPolicyNo();
		String   prpLregistRegistNo  = registEditPostInfo.getRegistNo();
		String   prpLregistDamageStartDate  = registEditPostInfo.getPrpLregistDamageStartDate();
		String   prpLregistReportDate  = registEditPostInfo.getPrpLregistReportDate();
		String   prpLregistDamageCode  = registEditPostInfo.getPrpLregistDamageCode();
		String   prpLregistDamageName  = registEditPostInfo.getPrpLregistDamageName();
		
		String[] prplCompensateEarAccount=registEditPostInfo.getPrplCompensateEarAccount();
		String[] prplCompensateEarBank=registEditPostInfo.getPrplCompensateEarBank();
		String[] prplCompensateEarBreedingAreaCode=registEditPostInfo.getPrplCompensateEarBreedingAreaCode();
		String[] prplCompensateEarBreedingAreaName=registEditPostInfo.getPrplCompensateEarBreedingAreaName();
		String[] prplCompensateEarCaseNo=registEditPostInfo.getPrplCompensateEarCaseNo();
		String[] prplCompensateEarClaimNo=registEditPostInfo.getPrplCompensateEarClaimNo();
		String[] prplCompensateEarClaimRate=registEditPostInfo.getPrplCompensateEarClaimRate();
		String[] prplCompensateEarCombineNo=registEditPostInfo.getPrplCompensateEarCombineNo();
		String[] prplCompensateEarCompensateNo=registEditPostInfo.getPrplCompensateEarCompensateNo();
		String[] prplCompensateEarCullNumber=registEditPostInfo.getPrplCompensateEarCullNumber();
		String[] prplCompensateEarDamageCode=registEditPostInfo.getPrplCompensateEarDamageCode();
		String[] prplCompensateEarDamageEndDate=registEditPostInfo.getPrplCompensateEarDamageEndDate();
		String[] prplCompensateEarDamageName=registEditPostInfo.getPrplCompensateEarDamageName();
		String[] prplCompensateEarDamageStartDate=registEditPostInfo.getPrplCompensateEarDamageStartDate();
		String[] prplCompensateEarDamageStartHour=registEditPostInfo.getPrplCompensateEarDamageStartHour();
		String[] prplCompensateEarDeadNumber=registEditPostInfo.getPrplCompensateEarDeadNumber();
		String[] prplCompensateEarDeadReason=registEditPostInfo.getPrplCompensateEarDeadReason();
		String[] prplCompensateEarDeductible=registEditPostInfo.getPrplCompensateEarDeductible();
		String[] prplCompensateEarDeductibleRate=registEditPostInfo.getPrplCompensateEarDeductibleRate();
		String[] prplCompensateEarEarNo=registEditPostInfo.getPrplCompensateEarEarNo();
		String[] prplCompensateEarEstimateLoss=registEditPostInfo.getPrplCompensateEarEstimateLoss();
		String[] prplCompensateEarFCode=registEditPostInfo.getPrplCompensateEarFCode();
		String[] prplCompensateEarId_Card=registEditPostInfo.getPrplCompensateEarId_Card();
		String[] prplCompensateEarInusreListCode=registEditPostInfo.getPrplCompensateEarInusreListCode();
		String[] prplCompensateEarKindCode=registEditPostInfo.getPrplCompensateEarKindCode();
		String[] prplCompensateEarName=registEditPostInfo.getPrplCompensateEarName();
		String[] prplCompensateEarNodeNo=registEditPostInfo.getPrplCompensateEarNodeNo();
		String[] prplCompensateEarNodeType=registEditPostInfo.getPrplCompensateEarNodeType();
		String[] prplCompensateEarPolicyNo=registEditPostInfo.getPrplCompensateEarPolicyNo();
		String[] prplCompensateEarRegistNo=registEditPostInfo.getPrplCompensateEarRegistNo();
		String[] prplCompensateEarReportTime=registEditPostInfo.getPrplCompensateEarReportTime();
		String[] prplCompensateEarRestFee=registEditPostInfo.getPrplCompensateEarRestFee();
		String[] prplCompensateEarSumRealpay=registEditPostInfo.getPrplCompensateEarSumRealpay();
		String[] prplCompensateEarUnitAmount=registEditPostInfo.getPrplCompensateEarUnitAmount();

		//end养殖险耳标清单列表字段定义
		if (prplCompensateEarEarNo == null){
		}else{
			for(int index = 0;index < prplCompensateEarEarNo.length;index++)
			{
				prplCompensateEarDto = new PrplcompensateearDto();
						
				prplCompensateEarDto.setAccount(prplCompensateEarAccount[index]);
				prplCompensateEarDto.setBank(prplCompensateEarBank[index]);
				prplCompensateEarDto.setBreedingareacode(prplCompensateEarBreedingAreaCode[index]);
				prplCompensateEarDto.setBreedingareaname(prplCompensateEarBreedingAreaName[index]);
				if(null != prplCompensateEarCaseNo && prplCompensateEarCaseNo.length>0){
					prplCompensateEarDto.setCaseno(prplCompensateEarCaseNo[index]);
				}
				if(null != prplCompensateEarClaimNo && prplCompensateEarClaimNo.length>0){
					prplCompensateEarDto.setClaimno(prplCompensateEarClaimNo[index]);
				}
				if(null != prplCompensateEarClaimRate && prplCompensateEarClaimRate.length>0){
					prplCompensateEarDto.setClaimrate(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarClaimRate[index])));
				}else{
					prplCompensateEarDto.setClaimrate(0);
				}
				prplCompensateEarDto.setCombineno("");
				if(null != prplCompensateEarCompensateNo && prplCompensateEarCompensateNo.length>0){
					prplCompensateEarDto.setCompensateno(prplCompensateEarCompensateNo[index]);
				}
				if(null != prplCompensateEarCullNumber && prplCompensateEarCullNumber.length>0){
					prplCompensateEarDto.setCullnumber(Integer.valueOf(DataUtils.nullToZero(prplCompensateEarCullNumber[index])));
				}else{
					prplCompensateEarDto.setCullnumber(0);
				}
				prplCompensateEarDto.setDamagecode(prpLregistDamageCode);
				if(null != prplCompensateEarDamageEndDate && prplCompensateEarDamageEndDate.length>0){
					prplCompensateEarDto.setDamageenddate(new DateTime(prplCompensateEarDamageEndDate[index],DateTime.YEAR_TO_DAY));
				}
				prplCompensateEarDto.setDamagename(prpLregistDamageName);
				prplCompensateEarDto.setDamagestartdate(new DateTime(prpLregistDamageStartDate,DateTime.YEAR_TO_DAY));
				if(null != prplCompensateEarDamageStartHour && prplCompensateEarDamageStartHour.length>0){
					prplCompensateEarDto.setDamagestarthour(prplCompensateEarDamageStartHour[index]);
				}
				if(null != prplCompensateEarDeadNumber && prplCompensateEarDeadNumber.length>0){
					prplCompensateEarDto.setDeadnumber(Integer.valueOf(DataUtils.nullToZero(prplCompensateEarDeadNumber[index])));
				}else{
					prplCompensateEarDto.setDeadnumber(0);
				}
				if(null != prplCompensateEarDeadReason && prplCompensateEarDeadReason.length>0){
					prplCompensateEarDto.setDeadreason(prplCompensateEarDeadReason[index]);
				}
				if(null != prplCompensateEarDeductible && prplCompensateEarDeductible.length>0){
					prplCompensateEarDto.setDeductible(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarDeductible[index])));
				}else{
					prplCompensateEarDto.setDeductible(0);
				}
				if(null != prplCompensateEarDeductibleRate && prplCompensateEarDeductibleRate.length>0){
					prplCompensateEarDto.setDeductiblerate(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarDeductibleRate[index])));
				}else{
					prplCompensateEarDto.setDeductiblerate(0);
				}
				prplCompensateEarDto.setEarno(prplCompensateEarEarNo[index]);
				prplCompensateEarDto.setEstimateloss(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarEstimateLoss[index])));
				prplCompensateEarDto.setFcode(prplCompensateEarFCode[index]);
				prplCompensateEarDto.setId_card(prplCompensateEarId_Card[index]);
				prplCompensateEarDto.setInusrelistcode(prplCompensateEarInusreListCode[index]);
				prplCompensateEarDto.setKindcode(prplCompensateEarKindCode[index]);
				prplCompensateEarDto.setName(prplCompensateEarName[index]);
				prplCompensateEarDto.setNodeno(1);
				prplCompensateEarDto.setNodetype("regis");
				prplCompensateEarDto.setPolicyno(prpLregistPolicyNo);
				prplCompensateEarDto.setRegistno(registEditPostInfo.getRegistNo());
				prplCompensateEarDto.setBusinessno(registEditPostInfo.getRegistNo());
				prplCompensateEarDto.setReporttime(prpLregistReportDate);
				if(null != prplCompensateEarRestFee && prplCompensateEarRestFee.length>0){
					prplCompensateEarDto.setRestfee(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarRestFee[index])));
				}else{
					prplCompensateEarDto.setRestfee(0);
				}
				if(null != prplCompensateEarSumRealpay && prplCompensateEarSumRealpay.length>0){
					prplCompensateEarDto.setSumrealpay(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarSumRealpay[index])));
				}else{
					prplCompensateEarDto.setSumrealpay(0);
				}
				
				prplCompensateEarDto.setUnitamount(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarUnitAmount[index])));

				
    			prplCompensateEarDtoList.add(prplCompensateEarDto);
			}
		}
		registDto.setPrpLcompensateEarDtoList(prplCompensateEarDtoList);
			
        /*---------------------报案文本表prpLregistText------------------------------------*/
        ArrayList prpLregistTextDtoList = new ArrayList();

        String TextTemp = registEditPostInfo.getPrpLregistTextContextInnerHTML();
        String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);

        //得到连接串,下面将其切分到数组
        for (int k = 0; k < rules.length; k++) {
            PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
            prpLregistTextDto.setRegistNo(registEditPostInfo.getRegistNo());
            prpLregistTextDto.setContext(rules[k]);
            prpLregistTextDto.setLineNo(k + 1);
            prpLregistTextDto.setTextType("1");
            prpLregistTextDtoList.add(prpLregistTextDto);
        }
        //装入RegistDto
        registDto.setPrpLregistTextDtoList(prpLregistTextDtoList);

        //原因：添加呈报信息  2005-08-01
       if (registEditPostInfo.getPrplregistReportFlag() != null && !registEditPostInfo.getPrplregistReportFlag().equals("")) {
            ArrayList prpLregistTextDtoList2 = new ArrayList();
            String TextTemp2 = registEditPostInfo.getPrpLregistTextContextInnerHTML2();
            String[] rules2 = StringUtils.split(TextTemp2, RULE_LENGTH);

           //得到连接串,下面将其切分到数组
            for (int k = 0; k < rules2.length; k++) {
                PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
                prpLregistTextDto.setRegistNo(registEditPostInfo.getRegistNo());
                prpLregistTextDto.setContext(rules2[k]);
                prpLregistTextDto.setLineNo(k + 1);
                prpLregistTextDto.setTextType("4");
                prpLregistTextDtoList2.add(prpLregistTextDto);
            }
            //装入RegistDto
            registDto.setPrpLregistTextDtoList2(prpLregistTextDtoList2);
        }

       /*---------------------------详细出险原因----------------------------------*/
       String strDamageMessage = registEditPostInfo.getDamageMessageFlag();
       if(strDamageMessage!=null && !strDamageMessage.equals("")){
    	   ArrayList prpLregistTextDtoList3 = new ArrayList();
    	   String[] damageMessage = registEditPostInfo.getDamageMessage();
    	   if(damageMessage != null){
	    	   for(int index = 0;index<damageMessage.length;index++){
	    		   PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
	    		   prpLregistTextDto.setRegistNo(registEditPostInfo.getRegistNo());
	    		   prpLregistTextDto.setLineNo(index+1);
	    		   prpLregistTextDto.setContext(damageMessage[index]);
	    		   prpLregistTextDto.setTextType(strDamageMessage);
	    		   prpLregistTextDtoList3.add(prpLregistTextDto);
	    	   }
    	   }
    	   registDto.setPrpLregistTextDtoList3(prpLregistTextDtoList3);
       }
        /*---------------------立案操作状态内容prpLclaimStatus------------------------------------*/
        PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
        prpLclaimStatusDto.setStatus(registEditPostInfo.getButtonSaveType());
        prpLclaimStatusDto.setBusinessNo(prpLregistDto.getRegistNo());
        prpLclaimStatusDto.setPolicyNo(prpLregistDto.getPolicyNo());
        prpLclaimStatusDto.setNodeType("regis");
        prpLclaimStatusDto.setSerialNo(0);

        //取得当前用户信息，写操作员信息到实赔中
        prpLclaimStatusDto.setHandlerCode(registEditPostInfo.getUserCode());
        //prpLclaimStatusDto.setHandlerCode(prpLregistDto.getOperatorCode() );
        prpLclaimStatusDto.setInputDate(prpLregistDto.getInputDate());
        prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
        prpLclaimStatusDto.setRiskCode(prpLregistDto.getRiskCode());
        registDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
        return registDto;
    }

    /**
     * 取初始化信息需要的数据的整理. 填写报案单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参， 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。
     * 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
     * 
     * @param httpServletRequest
     * @return RequestDto 取初始化信息需要的数据
     * @throws Exception
     */
    public abstract RegistDto iniViewToDto(HttpServletRequest httpServletRequest) throws Exception;

    /**
     * 填写报案页面及查询报案request的生成. 填写报案时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
     * 
     * @param httpServletRequest 返回给页面的request
     * @param registDto 取出的初始化信息Dto
     * @throws Exception
     */
    public abstract void dtoToView(HttpServletRequest httpServletRequest, RegistDto registDto) throws Exception;

    /**
     * 保存报案时报案页面数据整理. 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
     * 
     * @param httpServletRequest
     * @return registDto 报案数据传输数据结构
     * @throws Exception
     */
    public RegistDto viewToDtoTest(HttpServletRequest httpServletRequest) throws Exception {
        RegistDto registDto = new RegistDto();
        PrpLregistDto prpLregistDto = new PrpLregistDto();
        prpLregistDto.setRegistNo("11111111111111");
        prpLregistDto.setLFlag("1");
        prpLregistDto.setClassCode("R");
        prpLregistDto.setRiskCode("DAA");
        prpLregistDto.setPolicyNo("PDAA200441010102000001");
        prpLregistDto.setLanguage("C");
        prpLregistDto.setInsuredCode("4101016000000001");
        prpLregistDto.setInsuredName("张三");
        prpLregistDto.setInsuredAddress("上海商城");
        prpLregistDto.setClauseType("F21");
        prpLregistDto.setLicenseNo("京A1234");
        prpLregistDto.setLicenseColorCode("01");
        prpLregistDto.setCarKindCode("1");
        prpLregistDto.setModelCode("1");
        prpLregistDto.setBrandName("京A1234");
        prpLregistDto.setEngineNo("京A1234");
        prpLregistDto.setFrameNo("京A1234");
        prpLregistDto.setRunDistance(123);
        prpLregistDto.setUseYears(12);
        prpLregistDto.setReportDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));

        prpLregistDto.setReportorPhoneNumber("11");
        prpLregistDto.setLinkerPostCode("11");
        prpLregistDto.setLinkerAddress("所以只保存小时，分和秒先不保存");

        //为了兼容大地程序的小时设置情况，所以只保存小时，分和秒先不保存
        prpLregistDto.setReportHour("12:00:00");

        prpLregistDto.setReportAddress("prpLregistReportAds");
        prpLregistDto.setReportorName("prpLregortorName");
        prpLregistDto.setReportType("11");
        prpLregistDto.setPhoneNumber("11");
        prpLregistDto.setLinkerName("11");
        prpLregistDto.setDamageStartDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
        //为了兼容大地程序的小时设置情况，所以只保存小时，分和秒先不保存
        prpLregistDto.setDamageStartHour("12:00:00");

        prpLregistDto.setDamageEndDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));

        //为了兼容大地程序的小时设置情况，所以只保存小时，分和秒先不保存
        prpLregistDto.setDamageEndHour("12:00:00");

        prpLregistDto.setDamageCode("1");
        prpLregistDto.setDamageName("1");
        prpLregistDto.setDamageTypeCode("1");
        prpLregistDto.setDamageTypeName("1");
        prpLregistDto.setFirstSiteFlag("1");
        prpLregistDto.setAddressCode("1");
        prpLregistDto.setDamageAreaCode("1");
        prpLregistDto.setDamageAreaName("1");
        prpLregistDto.setDamageAddressType("1");
        prpLregistDto.setDamageAddress("1");
        prpLregistDto.setDamageAreaPostCode("1");
        prpLregistDto.setHandleUnit("1");
        prpLregistDto.setLossName("1");
        prpLregistDto.setLossQuantity(23423);
        prpLregistDto.setUnit("1");
        prpLregistDto.setEstiCurrency("1");
        prpLregistDto.setEstimateLoss(43534);
        prpLregistDto.setReceiverName("1");
        prpLregistDto.setHandlerCode("1");
        prpLregistDto.setHandler1Code("1");
        prpLregistDto.setComCode("1");
        prpLregistDto.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
        prpLregistDto.setAcceptFlag("1");
        //prpLregistDto.setAcceptFlag (httpServletRequest.getParameter("prpLregistAcceptFlag" ));
        prpLregistDto.setRepeatInsureFlag("1");
        prpLregistDto.setClaimType("1");
        prpLregistDto.setCancelDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
        prpLregistDto.setDealerCode("1");
        prpLregistDto.setRemark("1");
        prpLregistDto.setOperatorCode("1");
        prpLregistDto.setMakeCom("1");
        prpLregistDto.setFlag("1");
        //加到ArrayList中
        registDto.setPrpLregistDto(prpLregistDto);
        return registDto;
    }

}

