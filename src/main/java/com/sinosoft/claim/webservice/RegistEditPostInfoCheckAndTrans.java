package com.sinosoft.claim.webservice;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sinosoft.claim.dto.custom.AcciPersonDto;
import com.sinosoft.claim.dto.custom.AcciRegistDto;
import com.sinosoft.claim.dto.custom.AgriRegistDto;
import com.sinosoft.claim.dto.custom.CargoRegistDto;
import com.sinosoft.claim.dto.custom.EarNoDto;
import com.sinosoft.claim.dto.custom.LiabRegistDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.PropRegistDto;
import com.sinosoft.claim.dto.custom.RelatePersonDto;
import com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper;

public class RegistEditPostInfoCheckAndTrans {
	
	public void checkAgriRegistDtoInfo(AgriRegistDto agriRegistDto) throws Exception{
		if(isEmpty(agriRegistDto.getRiskCode())){throw new Exception("险种名称不能为空，请检查。");}
		if(isEmpty(agriRegistDto.getPolicyNo())){throw new Exception("保单号码不能为空，请检查。");}
		if(isEmpty(agriRegistDto.getDamageStartDate())){throw new Exception("出险时间：天不能为空，请检查。");}
		if(isEmpty(agriRegistDto.getDamageStartHour())){throw new Exception("出险小时：到分钟不能为空，请检查。");}
		if(isEmpty(agriRegistDto.getDamageCode())){throw new Exception("出险原因代码不能为空，请检查。");}
		if(isEmpty(agriRegistDto.getDamageName())){throw new Exception("出险原因名称不能为空，请检查。");}
		if(isEmpty(agriRegistDto.getReportDate())){throw new Exception("报案时间不能为空，请检查。");}
		if(isEmpty(agriRegistDto.getReportHour())){throw new Exception("报案小时不能为空，请检查。");}
		if(isEmpty(agriRegistDto.getReportType())){throw new Exception("报案方式不能为空，请检查。");}
		if(isEmpty(agriRegistDto.getLinkerName())){throw new Exception("联系人不能为空，请检查。");}
		if(isEmpty(agriRegistDto.getPhoneNumber())){throw new Exception("联系电话不能为空，请检查。");}
		if(isEmpty(agriRegistDto.getLossesNumber())){throw new Exception("赔付数量不能为空，请检查。");}
		if(isEmpty(agriRegistDto.getLossesUnitCode())){throw new Exception("赔付单位不能为空，请检查。");}
		if(isEmpty(agriRegistDto.getDamageAddress())){throw new Exception("出险地点不能为空，请检查。");}
		if(isEmpty(agriRegistDto.getEstiCurrency())){throw new Exception("币别不能为空，请检查。");}
		if(isEmpty(agriRegistDto.getEstimateLoss())){throw new Exception("报损金额不能为空，请检查。");}
		if(isEmpty(agriRegistDto.getLossName())){throw new Exception("受损标的不能为空，请检查。");}
		if(isEmpty(agriRegistDto.getOperatorCode())){throw new Exception("接报案员代码不能为空，请检查。");}
		if(isEmpty(agriRegistDto.getMakeCom())){throw new Exception("理赔登记部门代码不能为空，请检查。");}
		if(isEmpty(agriRegistDto.getTextContext())){throw new Exception("出险摘要不能为空，请检查。");}
		AcciPersonDto[] acciPersonDtoList = agriRegistDto.getAcciPersonDtoList();
		if(null != acciPersonDtoList && acciPersonDtoList.length>0){
			for(int i=0;i<acciPersonDtoList.length;i++){
				AcciPersonDto acciPersonDto = acciPersonDtoList[i];
				if(isEmpty(acciPersonDto.getFamilyNo())){throw new Exception("事故者序号不能为空，请检查。");}
				if(isEmpty(acciPersonDto.getAcciName())){throw new Exception("事故者姓名不能为空，请检查。");}
			}
		}
		if(agriRegistDto.getRiskCode().substring(0, 2).equals("32")){
			EarNoDto[] earNoList = agriRegistDto.getEarNoDtoList();
			if(null != earNoList && earNoList.length>0){
				for(int i=0;i<earNoList.length;i++){
					EarNoDto earNoDto = earNoList[i];
					if(isEmpty(earNoDto.getEarNo())){throw new Exception("耳标号不能为空，请检查。");}
					if(isEmpty(earNoDto.getEarInusreListCode())){throw new Exception("投保清单编号不能为空，请检查。");}
					if(isEmpty(earNoDto.getEarKindCode())){throw new Exception("险别序号不能为空，请检查。");}
					if(isEmpty(earNoDto.getFcode())){throw new Exception("农户代码不能为空，请检查。");}
					if(isEmpty(earNoDto.getIdCard())){throw new Exception("证件号码不能为空，请检查。");}
					if(isEmpty(earNoDto.getName())){throw new Exception("姓名不能为空，请检查。");}
					if(isEmpty(earNoDto.getEstimateloss())){throw new Exception("定损金额不能为空，请检查。");}
					if(isEmpty(earNoDto.getAreaCode())){throw new Exception("养殖地点代码不能为空，请检查。");}
					//if(isEmpty(earNoDto.getAreaName())){throw new Exception("养殖地点名称不能为空，请检查。");}
					if(isEmpty(earNoDto.getEarUnitAmount())){throw new Exception("单位保险金额不能为空，请检查。");}
				}
			}
		}
		
	}
	
	public void checkCarRegistDtoInfo(CargoRegistDto cargoRegistDto) throws Exception{
		if(isEmpty(cargoRegistDto.getRiskCode())){throw new Exception("险种名称不能为空，请检查。");}
		if(isEmpty(cargoRegistDto.getPolicyNo())){throw new Exception("保单号码不能为空，请检查。");}
		if(isEmpty(cargoRegistDto.getDamageStartDate())){throw new Exception("出险时间：天不能为空，请检查。");}
		if(isEmpty(cargoRegistDto.getDamageCode())){throw new Exception("出险原因代码不能为空，请检查。");}
		if(isEmpty(cargoRegistDto.getDamageName())){throw new Exception("出险原因名称不能为空，请检查。");}
		if(isEmpty(cargoRegistDto.getReportDate())){throw new Exception("报案时间不能为空，请检查。");}
		if(isEmpty(cargoRegistDto.getReportHour())){throw new Exception("报案小时不能为空，请检查。");}
		if(isEmpty(cargoRegistDto.getReportType())){throw new Exception("报案方式不能为空，请检查。");}
		if(isEmpty(cargoRegistDto.getLinkerName())){throw new Exception("联系人不能为空，请检查。");}
		if(isEmpty(cargoRegistDto.getPhoneNumber())){throw new Exception("联系电话不能为空，请检查。");}
		if(isEmpty(cargoRegistDto.getDamageAddress())){throw new Exception("出险地点不能为空，请检查。");}
		if(isEmpty(cargoRegistDto.getEstiCurrency())){throw new Exception("币别不能为空，请检查。");}
		if(isEmpty(cargoRegistDto.getEstimateLoss())){throw new Exception("报损金额不能为空，请检查。");}
		if(isEmpty(cargoRegistDto.getLossName())){throw new Exception("受损标的不能为空，请检查。");}
		if(isEmpty(cargoRegistDto.getOperatorCode())){throw new Exception("接报案员代码不能为空，请检查。");}
		if(isEmpty(cargoRegistDto.getOperatorName())){throw new Exception("接报案员名称不能为空，请检查。");}
		if(isEmpty(cargoRegistDto.getMakeCom())){throw new Exception("理赔登记部门代码不能为空，请检查。");}
		if(isEmpty(cargoRegistDto.getMakeComName())){throw new Exception("理赔登记部门名称不能为空，请检查。");}
		if(isEmpty(cargoRegistDto.getTextContext())){throw new Exception("出险摘要不能为空，请检查。");}
		RelatePersonDto[] list = cargoRegistDto.getRelatePersonDtoList();
		if(null != list && list.length>0){
			for(int i=0;i<list.length;i++){
				if(isEmpty(list[i].getSerialNo())){throw new Exception("序号不能为空，请检查。");}
			}
		}
		
		
	}
	
	public void checkPropRegistDtoInfo(PropRegistDto propRegistDto) throws Exception{
		if(isEmpty(propRegistDto.getRiskCode())){throw new Exception("险种名称不能为空，请检查。");}
		if(isEmpty(propRegistDto.getPolicyNo())){throw new Exception("保单号码不能为空，请检查。");}
		if(isEmpty(propRegistDto.getDamageStartDate())){throw new Exception("出险时间：天不能为空，请检查。");}
		if(isEmpty(propRegistDto.getDamageStartHour())){throw new Exception("出险小时：到分钟不能为空，请检查。");}
		if(isEmpty(propRegistDto.getDamageCode())){throw new Exception("出险原因代码不能为空，请检查。");}
		if(isEmpty(propRegistDto.getDamageName())){throw new Exception("出险原因名称不能为空，请检查。");}
		if(isEmpty(propRegistDto.getReportDate())){throw new Exception("报案时间不能为空，请检查。");}
		if(isEmpty(propRegistDto.getReportHour())){throw new Exception("报案小时不能为空，请检查。");}
		if(isEmpty(propRegistDto.getReportType())){throw new Exception("报案方式不能为空，请检查。");}
		if(isEmpty(propRegistDto.getLinkerName())){throw new Exception("联系人不能为空，请检查。");}
		if(isEmpty(propRegistDto.getPhoneNumber())){throw new Exception("联系电话不能为空，请检查。");}
		if(isEmpty(propRegistDto.getDamageAddress())){throw new Exception("出险地点不能为空，请检查。");}
		if(isEmpty(propRegistDto.getEstiCurrency())){throw new Exception("币别不能为空，请检查。");}
		if(isEmpty(propRegistDto.getEstimateLoss())){throw new Exception("报损金额不能为空，请检查。");}
		if(isEmpty(propRegistDto.getLossName())){throw new Exception("受损标的不能为空，请检查。");}
		if(isEmpty(propRegistDto.getOperatorCode())){throw new Exception("接报案员代码不能为空，请检查。");}
		if(isEmpty(propRegistDto.getOperatorName())){throw new Exception("接报案员名称不能为空，请检查。");}
		if(isEmpty(propRegistDto.getMakeCom())){throw new Exception("理赔登记部门代码不能为空，请检查。");}
		if(isEmpty(propRegistDto.getMakeComName())){throw new Exception("理赔登记部门名称不能为空，请检查。");}
		if(isEmpty(propRegistDto.getTextContext())){throw new Exception("出险摘要不能为空，请检查。");}
		RelatePersonDto[] list = propRegistDto.getRelatePersonDtoList();
		if(null != list && list.length>0){
			for(int i=0;i<list.length;i++){
				if(isEmpty(list[i].getSerialNo())){throw new Exception("序号不能为空，请检查。");}
			}
		}
		
	}
	
	public void checkAcciRegistDtoInfo(AcciRegistDto acciRegistDto) throws Exception{
		if(isEmpty(acciRegistDto.getRiskCode())){throw new Exception("险种名称不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getPolicyNo())){throw new Exception("保单号码不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getDamageStartDate())){throw new Exception("出险时间：天不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getDamageStartHour())){throw new Exception("出险小时：到分钟不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getDamageCode())){throw new Exception("出险原因代码不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getDamageName())){throw new Exception("出险原因名称不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getReportDate())){throw new Exception("报案时间不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getReportHour())){throw new Exception("报案小时不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getReportType())){throw new Exception("报案方式不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getLinkerName())){throw new Exception("联系人不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getPhoneNumber())){throw new Exception("联系电话不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getLinkerAddress())){throw new Exception("联系地址不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getClauseType())){throw new Exception("与事故者关系不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getDamageAddress())){throw new Exception("事故地点不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getDamageTypeCode())){throw new Exception("事故类型不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getLossesNumber())){throw new Exception("赔付人次不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getReportFlag())){throw new Exception("是否呈报不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getEstiCurrency())){throw new Exception("币别不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getOperatorCode())){throw new Exception("接报案员代码不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getOperatorName())){throw new Exception("接报案员名称不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getMakeCom())){throw new Exception("理赔登记部门代码不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getMakeComName())){throw new Exception("理赔登记部门名称不能为空，请检查。");}
		if(isEmpty(acciRegistDto.getContext())){throw new Exception("事故经过及其事故者现状不能为空，请检查。");}
		AcciPersonDto[] acciPersonDtoList = acciRegistDto.getAcciPersonDtoList();
		if(null != acciPersonDtoList && acciPersonDtoList.length>0){
			for(int i=0;i<acciPersonDtoList.length;i++){
				AcciPersonDto acciPersonDto = acciPersonDtoList[i];
				if(isEmpty(acciPersonDto.getFamilyNo())){throw new Exception("事故者序号不能为空，请检查。");}
				if(isEmpty(acciPersonDto.getAcciName())){throw new Exception("事故者姓名不能为空，请检查。");}
			}
		}else{
			throw new Exception("事故者信息不能为空，请检查。");
		}
		
	}
	
	public void checkLiabRegistDtoInfo(LiabRegistDto liabRegistDto) throws Exception{
		if(isEmpty(liabRegistDto.getRiskCode())){throw new Exception("险种名称不能为空，请检查。");}
		if(isEmpty(liabRegistDto.getPolicyNo())){throw new Exception("保单号码不能为空，请检查。");}
		if(isEmpty(liabRegistDto.getDamageStartDate())){throw new Exception("出险时间：天不能为空，请检查。");}
		if(isEmpty(liabRegistDto.getDamageStartHour())){throw new Exception("出险小时：到分钟不能为空，请检查。");}
		if(isEmpty(liabRegistDto.getDamageCode())){throw new Exception("出险原因代码不能为空，请检查。");}
		if(isEmpty(liabRegistDto.getDamageName())){throw new Exception("出险原因名称不能为空，请检查。");}
		if(isEmpty(liabRegistDto.getReportDate())){throw new Exception("报案时间不能为空，请检查。");}
		if(isEmpty(liabRegistDto.getReportHour())){throw new Exception("报案小时不能为空，请检查。");}
		if(isEmpty(liabRegistDto.getReportType())){throw new Exception("报案方式不能为空，请检查。");}
		if(isEmpty(liabRegistDto.getLinkerName())){throw new Exception("联系人不能为空，请检查。");}
		if(isEmpty(liabRegistDto.getPhoneNumber())){throw new Exception("联系电话不能为空，请检查。");}
		if(isEmpty(liabRegistDto.getDamageAddress())){throw new Exception("出险地点不能为空，请检查。");}
		if(isEmpty(liabRegistDto.getEstiCurrency())){throw new Exception("币别不能为空，请检查。");}
		if(isEmpty(liabRegistDto.getEstimateLoss())){throw new Exception("报损金额不能为空，请检查。");}
		if(isEmpty(liabRegistDto.getLossName())){throw new Exception("受损标的不能为空，请检查。");}
		if(isEmpty(liabRegistDto.getOperatorCode())){throw new Exception("接报案员代码不能为空，请检查。");}
		if(isEmpty(liabRegistDto.getOperatorName())){throw new Exception("接报案员名称不能为空，请检查。");}
		if(isEmpty(liabRegistDto.getMakeCom())){throw new Exception("理赔登记部门代码不能为空，请检查。");}
		if(isEmpty(liabRegistDto.getMakeComName())){throw new Exception("理赔登记部门名称不能为空，请检查。");}
		if(isEmpty(liabRegistDto.getTextContext())){throw new Exception("出险摘要不能为空，请检查。");}
//		//zhoujiawei:针对特殊险种停车场责任险需要添加传入参数（入参内容参考意健险报案信息中的事故者信息）
//		if("1532".equals(liabRegistDto.getRiskCode())){
//			AcciPersonDto[] acciPersonDtoList = liabRegistDto.getAcciPersonDtoList();
//			if(null != acciPersonDtoList && acciPersonDtoList.length>0){
//				for(int i=0;i<acciPersonDtoList.length;i++){
//					AcciPersonDto acciPersonDto = acciPersonDtoList[i];
//					if(isEmpty(acciPersonDto.getSerialNo())){throw new Exception("acciPersonDtoList["+i+"]序号不能为空，请检查。");}
//					if(isEmpty(acciPersonDto.getFamilyNo())){throw new Exception("acciPersonDtoList["+i+"]事故者序号不能为空，请检查。");}
//					if(isEmpty(acciPersonDto.getAcciName())){throw new Exception("acciPersonDtoList["+i+"]事故者姓名不能为空，请检查。");}
//				}
//			}else{
//				throw new Exception("停车场责任险-事故者信息不能为空，请检查。");
//			}
//		}else{
//			AcciPersonDto[] acciPersonDtoList = liabRegistDto.getAcciPersonDtoList();
//			if(null != acciPersonDtoList && acciPersonDtoList.length>0){
//				throw new Exception("非停车场责任险-事故者信息只能为空，请检查。");
//			}
//		}
		
		
		
		
		
		
	}
	
	//转换
	public RegistEditPostInfo transAgriRegistEditPostInfo(AgriRegistDto agriRegistDto){
		RegistEditPostInfo registEditPostInfo = new RegistEditPostInfo();
		registEditPostInfo.setButtonSaveType("4");
		registEditPostInfo.setPrpLregistRiskCode(agriRegistDto.getRiskCode());
		registEditPostInfo.setPrpLregistPolicyNo(agriRegistDto.getPolicyNo());
		registEditPostInfo.setPrpLregistDamageStartDate(agriRegistDto.getDamageStartDate());
		registEditPostInfo.setPrpLregistDamageStartHour(agriRegistDto.getDamageStartHour());
		registEditPostInfo.setPrpLregistDamageStartMinute(agriRegistDto.getDamageStartMinute());
		registEditPostInfo = policyDtoToView(registEditPostInfo);
		
		registEditPostInfo.setUserComCode(agriRegistDto.getMakeCom());
		registEditPostInfo.setUserComName(agriRegistDto.getMakeComName());
		registEditPostInfo.setUserCode(agriRegistDto.getOperatorCode());
		registEditPostInfo.setUserName(agriRegistDto.getOperatorName());
		registEditPostInfo.setPrpLregistReceiverCode(agriRegistDto.getOperatorCode());
		registEditPostInfo.setPrpLregistReceiverName(agriRegistDto.getOperatorName());
		
		registEditPostInfo.setPrpLregistDamageCode(agriRegistDto.getDamageCode());
		registEditPostInfo.setPrpLregistDamageName(agriRegistDto.getDamageName());
		registEditPostInfo.setDamageMessageFlag("06");
		registEditPostInfo.setDamageMessage(agriRegistDto.getDamageMessage());
		registEditPostInfo.setPrpLregistReportorName(agriRegistDto.getReportorName());
		registEditPostInfo.setPrpLregistReportDate(agriRegistDto.getReportDate());
		registEditPostInfo.setPrpLregistReportHour(agriRegistDto.getReportHour());
		registEditPostInfo.setReportType(agriRegistDto.getReportType());
		Date date = new Date();
		SimpleDateFormat simp = new SimpleDateFormat("yyyyMMdd");
		registEditPostInfo.setPrpLregistInputDate(simp.format(date));
		registEditPostInfo.setPrpLregistLinkerName(agriRegistDto.getLinkerName());
		registEditPostInfo.setPrpLregistPhoneNumber(agriRegistDto.getPhoneNumber());
		registEditPostInfo.setPrpLregistLossesNumber(agriRegistDto.getLossesNumber());
		registEditPostInfo.setLossesUnitCode(agriRegistDto.getLossesUnitCode());
		registEditPostInfo.setPrpLregistAddressCode(agriRegistDto.getAddressCode());
		registEditPostInfo.setPrpLregistDamageAddress(agriRegistDto.getDamageAddress());
		registEditPostInfo.setPrpLregistEstimateLoss(agriRegistDto.getEstimateLoss());
		registEditPostInfo.setPrpLregistLossName(agriRegistDto.getLossName());
		registEditPostInfo.setPrpLregistOperatorCode(agriRegistDto.getOperatorCode());
		registEditPostInfo.setPrpLregistMakeCom(agriRegistDto.getMakeCom());
		registEditPostInfo.setPrpLregistRemark(agriRegistDto.getRemark());
		registEditPostInfo.setPrpLregistTextContextInnerHTML(agriRegistDto.getTextContext());
		registEditPostInfo.setPrpCatastropheCode1(agriRegistDto.getCatastropheCode1());
		registEditPostInfo.setPrpCatastropheName1(agriRegistDto.getCatastropheName1());
		registEditPostInfo.setPrpCatastropheCode2(agriRegistDto.getCatastropheCode2());
		registEditPostInfo.setPrpCatastropheName2(agriRegistDto.getCatastropheName2());
		registEditPostInfo.setPrpLregistEstiCurrency(agriRegistDto.getEstiCurrency());
		
		registEditPostInfo.setScheduleType("ALLS");
		
		AcciPersonDto[] list = agriRegistDto.getAcciPersonDtoList();
		if(null != list && list.length>0){
			String[] prpLacciBenPersonSerialNo = new String[list.length];
			String[] prpLacciPersonFamilyNo = new String[list.length];
			String[] prpLacciPersonAcciCode = new String[list.length];
			String[] prpLacciPersonAcciName = new String[list.length];
			String[] prpLacciPersonSex = new String[list.length];
			String[] prpLacciPersonAge = new String[list.length];
			String[] prpLacciPersonIdentifyNumber = new String[list.length];
			String[] prpLacciPersonAddress = new String[list.length];
			for(int i=0;i<list.length;i++){
				AcciPersonDto acciPersonDto = list[i];
				prpLacciBenPersonSerialNo[i] = acciPersonDto.getSerialNo();
				prpLacciPersonFamilyNo[i] = acciPersonDto.getFamilyNo();
				prpLacciPersonAcciCode[i] = acciPersonDto.getAcciCode();
				prpLacciPersonAcciName[i] = acciPersonDto.getAcciName();
				prpLacciPersonSex[i] = acciPersonDto.getSex();
				prpLacciPersonAge[i] = acciPersonDto.getAge();
				prpLacciPersonIdentifyNumber[i] = acciPersonDto.getIdentifyNumber();
				prpLacciPersonAddress[i] = "";
			}
			registEditPostInfo.setPrpLacciBenPersonSerialNo(prpLacciBenPersonSerialNo);
			registEditPostInfo.setPrpLacciPersonFamilyNo(prpLacciPersonFamilyNo);
			registEditPostInfo.setPrpLacciPersonAcciCode(prpLacciPersonAcciCode);
			registEditPostInfo.setPrpLacciPersonAcciName(prpLacciPersonAcciName);
			registEditPostInfo.setPrpLacciPersonSex(prpLacciPersonSex);
			registEditPostInfo.setPrpLacciPersonAge(prpLacciPersonAge);
			registEditPostInfo.setPrpLacciPersonIdentifyNumber(prpLacciPersonIdentifyNumber);
			registEditPostInfo.setPrpLacciPersonAddress(prpLacciPersonAddress);
		}
		
		EarNoDto[] earNoDtoList = agriRegistDto.getEarNoDtoList();
		if(null != earNoDtoList && earNoDtoList.length>0){
			int size = earNoDtoList.length;
			String[] prplCompensateEarEarNo  = new String[size];
			String[] prplCompensateEarInusreListCode = new String[size];
			String[] prplCompensateEarKindCode = new String[size];
			String[] prplCompensateEarBreedingAreaCode = new String[size];
			String[] prplCompensateEarBreedingAreaName = new String[size];
			String[] prplCompensateEarUnitAmount = new String[size];
			String[] prplCompensateEarFCode  = new String[size];
			String[] prplCompensateEarId_Card  = new String[size];
			String[] prplCompensateEarName  = new String[size];
			String[] prplCompensateEarBank  = new String[size];
			String[] prplCompensateEarAccount  = new String[size];
			String[] prplCompensateEarEstimateLoss  = new String[size];
			for(int i=0;i<earNoDtoList.length;i++){
				EarNoDto earNoDto = earNoDtoList[i];
				prplCompensateEarEarNo[i] = earNoDto.getEarNo();
				prplCompensateEarInusreListCode[i] = earNoDto.getEarInusreListCode();
				prplCompensateEarKindCode[i] = earNoDto.getEarKindCode();
				prplCompensateEarBreedingAreaCode[i] = earNoDto.getAreaCode();
				prplCompensateEarBreedingAreaName[i] = earNoDto.getAreaName();
				prplCompensateEarUnitAmount[i] = earNoDto.getEarUnitAmount();
				prplCompensateEarFCode[i] = earNoDto.getFcode();
				prplCompensateEarId_Card[i] = earNoDto.getIdCard();
				prplCompensateEarName[i] = earNoDto.getName();
				prplCompensateEarBank[i] = earNoDto.getBank();
				prplCompensateEarAccount[i] = earNoDto.getAccount();
				prplCompensateEarEstimateLoss[i] = earNoDto.getEstimateloss();
			}
			registEditPostInfo.setPrplCompensateEarEarNo(prplCompensateEarEarNo);
			registEditPostInfo.setPrplCompensateEarInusreListCode(prplCompensateEarInusreListCode);
			registEditPostInfo.setPrplCompensateEarKindCode(prplCompensateEarKindCode);
			registEditPostInfo.setPrplCompensateEarBreedingAreaCode(prplCompensateEarBreedingAreaCode);
			registEditPostInfo.setPrplCompensateEarBreedingAreaName(prplCompensateEarBreedingAreaName);
			registEditPostInfo.setPrplCompensateEarUnitAmount(prplCompensateEarUnitAmount);
			registEditPostInfo.setPrplCompensateEarFCode(prplCompensateEarFCode);
			registEditPostInfo.setPrplCompensateEarId_Card(prplCompensateEarId_Card);
			registEditPostInfo.setPrplCompensateEarName(prplCompensateEarName);
			registEditPostInfo.setPrplCompensateEarBank(prplCompensateEarBank);
			registEditPostInfo.setPrplCompensateEarAccount(prplCompensateEarAccount);
			registEditPostInfo.setPrplCompensateEarEstimateLoss(prplCompensateEarEstimateLoss);
		}
		
		return registEditPostInfo;
	}
	
	public RegistEditPostInfo transCargoRegistEditPostInfo(CargoRegistDto cargoRegistDto){
		RegistEditPostInfo registEditPostInfo = new RegistEditPostInfo();
		registEditPostInfo.setButtonSaveType("4");
		registEditPostInfo.setPrpLregistRiskCode(cargoRegistDto.getRiskCode());
		registEditPostInfo.setPrpLregistPolicyNo(cargoRegistDto.getPolicyNo());
		registEditPostInfo.setPrpLregistDamageStartDate(cargoRegistDto.getDamageStartDate());
		registEditPostInfo.setPrpLregistDamageStartHour("00");
		registEditPostInfo.setPrpLregistDamageStartMinute("00");
		registEditPostInfo = policyDtoToView(registEditPostInfo);
		
		registEditPostInfo.setUserComCode(cargoRegistDto.getMakeCom());
		registEditPostInfo.setUserComName(cargoRegistDto.getMakeComName());
		registEditPostInfo.setUserCode(cargoRegistDto.getOperatorCode());
		registEditPostInfo.setUserName(cargoRegistDto.getOperatorName());
		registEditPostInfo.setPrpLregistReceiverCode(cargoRegistDto.getOperatorCode());
		registEditPostInfo.setPrpLregistReceiverName(cargoRegistDto.getOperatorName());
		
		registEditPostInfo.setPrpLregistDamageCode(cargoRegistDto.getDamageCode());
		registEditPostInfo.setPrpLregistDamageName(cargoRegistDto.getDamageName());
		registEditPostInfo.setPrpLregistReportorName(cargoRegistDto.getReportorName());
		registEditPostInfo.setPrpLregistReportDate(cargoRegistDto.getReportDate());
		registEditPostInfo.setPrpLregistReportHour(cargoRegistDto.getReportHour());
		registEditPostInfo.setReportType(cargoRegistDto.getReportType());
		Date date = new Date();
		SimpleDateFormat simp = new SimpleDateFormat("yyyyMMdd");
		registEditPostInfo.setPrpLregistInputDate(simp.format(date));
		registEditPostInfo.setPrpLregistLinkerName(cargoRegistDto.getLinkerName());
		registEditPostInfo.setPrpLregistPhoneNumber(cargoRegistDto.getPhoneNumber());
		registEditPostInfo.setPrpLregistAddressCode(cargoRegistDto.getAddressCode());
		registEditPostInfo.setPrpLregistDamageAddress(cargoRegistDto.getDamageAddress());
		registEditPostInfo.setPrpLregistEstimateLoss(cargoRegistDto.getEstimateLoss());
		registEditPostInfo.setPrpLregistLossName(cargoRegistDto.getLossName());
		registEditPostInfo.setPrpLregistOperatorCode(cargoRegistDto.getOperatorCode());
		registEditPostInfo.setPrpLregistMakeCom(cargoRegistDto.getMakeCom());
		registEditPostInfo.setPrpLregistRemark(cargoRegistDto.getRemark());
		registEditPostInfo.setPrpLregistTextContextInnerHTML(cargoRegistDto.getTextContext());
		registEditPostInfo.setPrpCatastropheCode1(cargoRegistDto.getCatastropheCode1());
		registEditPostInfo.setPrpCatastropheName1(cargoRegistDto.getCatastropheName1());
		registEditPostInfo.setPrpCatastropheCode2(cargoRegistDto.getCatastropheCode2());
		registEditPostInfo.setPrpCatastropheName2(cargoRegistDto.getCatastropheName2());
		registEditPostInfo.setPrpLregistEstiCurrency(cargoRegistDto.getEstiCurrency());
		
		RelatePersonDto[] list = cargoRegistDto.getRelatePersonDtoList();
		if(null != list && list.length>0){
			String[] prpLrelatePersonSeriaNo = new String[list.length];
			String[] prpLrelatePersonPersonName = new String[list.length];
			String[] prpLrelatePersonPhoneNumber = new String[list.length];
			String[] prpLrelatePersonMobile = new String[list.length];
			String[] prpLrelatePersonRemark = new String[list.length];
			for(int i=0;i<list.length;i++){
				RelatePersonDto relatePersonDto = list[i];
				prpLrelatePersonSeriaNo[i] = relatePersonDto.getSerialNo();
				prpLrelatePersonPersonName[i] = relatePersonDto.getPersonName();
				prpLrelatePersonPhoneNumber[i] = relatePersonDto.getPhoneNumber();
				prpLrelatePersonMobile[i] = relatePersonDto.getMobile();
				prpLrelatePersonRemark[i] = relatePersonDto.getRemark();
			}
			registEditPostInfo.setPrpLrelatePersonSeriaNo(prpLrelatePersonSeriaNo);
			registEditPostInfo.setPrpLrelatePersonPersonName(prpLrelatePersonPersonName);
			registEditPostInfo.setPrpLrelatePersonPhoneNumber(prpLrelatePersonPhoneNumber);
			registEditPostInfo.setPrpLrelatePersonMobile(prpLrelatePersonMobile);
			registEditPostInfo.setPrpLrelatePersonRemark(prpLrelatePersonRemark);
		}
		
		return registEditPostInfo;
	}
	
	public RegistEditPostInfo transPropRegistEditPostInfo(PropRegistDto propRegistDto){
		RegistEditPostInfo registEditPostInfo = new RegistEditPostInfo();
		
		registEditPostInfo.setButtonSaveType("4");
		registEditPostInfo.setPrpLregistRiskCode(propRegistDto.getRiskCode());
		registEditPostInfo.setPrpLregistPolicyNo(propRegistDto.getPolicyNo());
		registEditPostInfo.setPrpLregistDamageStartDate(propRegistDto.getDamageStartDate());
		registEditPostInfo.setPrpLregistDamageStartHour(propRegistDto.getDamageStartHour());
		registEditPostInfo.setPrpLregistDamageStartMinute(propRegistDto.getDamageStartMinute());
		registEditPostInfo = policyDtoToView(registEditPostInfo);
		
		registEditPostInfo.setUserComCode(propRegistDto.getMakeCom());
		registEditPostInfo.setUserComName(propRegistDto.getMakeComName());
		registEditPostInfo.setUserCode(propRegistDto.getOperatorCode());
		registEditPostInfo.setUserName(propRegistDto.getOperatorName());
		registEditPostInfo.setPrpLregistReceiverCode(propRegistDto.getOperatorCode());
		registEditPostInfo.setPrpLregistReceiverName(propRegistDto.getOperatorName());
		
		registEditPostInfo.setPrpLregistDamageCode(propRegistDto.getDamageCode());
		registEditPostInfo.setPrpLregistDamageName(propRegistDto.getDamageName());
		registEditPostInfo.setPrpLregistReportorName(propRegistDto.getReportorName());
		registEditPostInfo.setPrpLregistReportDate(propRegistDto.getReportDate());
		registEditPostInfo.setPrpLregistReportHour(propRegistDto.getReportHour());
		registEditPostInfo.setReportType(propRegistDto.getReportType());
		Date date = new Date();
		SimpleDateFormat simp = new SimpleDateFormat("yyyyMMdd");
		registEditPostInfo.setPrpLregistInputDate(simp.format(date));
		registEditPostInfo.setPrpLregistLinkerName(propRegistDto.getLinkerName());
		registEditPostInfo.setPrpLregistPhoneNumber(propRegistDto.getPhoneNumber());
		registEditPostInfo.setPrpLregistAddressCode(propRegistDto.getAddressCode());
		registEditPostInfo.setPrpLregistDamageAddress(propRegistDto.getDamageAddress());
		registEditPostInfo.setPrpLregistEstimateLoss(propRegistDto.getEstimateLoss());
		registEditPostInfo.setPrpLregistLossName(propRegistDto.getLossName());
		registEditPostInfo.setPrpLregistOperatorCode(propRegistDto.getOperatorCode());
		registEditPostInfo.setPrpLregistMakeCom(propRegistDto.getMakeCom());
		registEditPostInfo.setPrpLregistRemark(propRegistDto.getRemark());
		registEditPostInfo.setPrpLregistTextContextInnerHTML(propRegistDto.getTextContext());
		registEditPostInfo.setPrpCatastropheCode1(propRegistDto.getCatastropheCode1());
		registEditPostInfo.setPrpCatastropheName1(propRegistDto.getCatastropheName1());
		registEditPostInfo.setPrpCatastropheCode2(propRegistDto.getCatastropheCode2());
		registEditPostInfo.setPrpCatastropheName2(propRegistDto.getCatastropheName2());
		registEditPostInfo.setPrpLregistEstiCurrency(propRegistDto.getEstiCurrency());
		
		RelatePersonDto[] list = propRegistDto.getRelatePersonDtoList();
		if(null != list && list.length>0){
			String[] prpLrelatePersonSeriaNo = new String[list.length];
			String[] prpLrelatePersonPersonName = new String[list.length];
			String[] prpLrelatePersonPhoneNumber = new String[list.length];
			String[] prpLrelatePersonMobile = new String[list.length];
			String[] prpLrelatePersonRemark = new String[list.length];
			for(int i=0;i<list.length;i++){
				RelatePersonDto relatePersonDto = list[i];
				prpLrelatePersonSeriaNo[i] = relatePersonDto.getSerialNo();
				prpLrelatePersonPersonName[i] = relatePersonDto.getPersonName();
				prpLrelatePersonPhoneNumber[i] = relatePersonDto.getPhoneNumber();
				prpLrelatePersonMobile[i] = relatePersonDto.getMobile();
				prpLrelatePersonRemark[i] = relatePersonDto.getRemark();
			}
			registEditPostInfo.setPrpLrelatePersonSeriaNo(prpLrelatePersonSeriaNo);
			registEditPostInfo.setPrpLrelatePersonPersonName(prpLrelatePersonPersonName);
			registEditPostInfo.setPrpLrelatePersonPhoneNumber(prpLrelatePersonPhoneNumber);
			registEditPostInfo.setPrpLrelatePersonMobile(prpLrelatePersonMobile);
			registEditPostInfo.setPrpLrelatePersonRemark(prpLrelatePersonRemark);
		}
		
		registEditPostInfo.setPrplCompensateHouseAddress(propRegistDto.getHouseAddress());
		registEditPostInfo.setPrplCompensateHouseRemark(propRegistDto.getHouseRemark());   
		registEditPostInfo.setPrplCompensateHouseEstimateloss(propRegistDto.getHouseEstimateloss());     
		registEditPostInfo.setPrplCompensateHouseHukoubu(propRegistDto.getHouseHukoubu());  
		registEditPostInfo.setPrplCompensateHouseIdcard(propRegistDto.getHouseIdcard());   
		registEditPostInfo.setPrplCompensateHouseName(propRegistDto.getHouseName());   
		registEditPostInfo.setPrplCompensateHousePhone(propRegistDto.getHousePhone());   
		registEditPostInfo.setPrplCompensateHouseFloor(propRegistDto.getHouseFloor());   
		registEditPostInfo.setPrplCompensateHouseBuildingnumber(propRegistDto.getHouseBuildingnumber());   
		registEditPostInfo.setPrplCompensateHouseZhuannumber(propRegistDto.getHouseZhuannumber());  
		registEditPostInfo.setPrplCompensateHouseWanumber(propRegistDto.getHouseWanumber());    
		registEditPostInfo.setPrplCompensateHouseKitchennumber(propRegistDto.getHouseKitchennumber());   
		registEditPostInfo.setPrplCompensateHouseOthernumber(propRegistDto.getHouseOthernumber()); 
		
		return registEditPostInfo;
	}
	
	public RegistEditPostInfo transAcciRegistEditPostInfo(AcciRegistDto acciRegistDto){
		RegistEditPostInfo registEditPostInfo = new RegistEditPostInfo();
		
		registEditPostInfo.setButtonSaveType("4");
		registEditPostInfo.setPrpLregistRiskCode(acciRegistDto.getRiskCode());
		registEditPostInfo.setPrpLregistPolicyNo(acciRegistDto.getPolicyNo());
		registEditPostInfo.setPrpLregistDamageStartDate(acciRegistDto.getDamageStartDate());
		registEditPostInfo.setPrpLregistDamageStartHour(acciRegistDto.getDamageStartHour());
		registEditPostInfo.setPrpLregistDamageStartMinute(acciRegistDto.getDamageStartMinute());
		registEditPostInfo = policyDtoToView(registEditPostInfo);
		
		registEditPostInfo.setUserComCode(acciRegistDto.getMakeCom());
		registEditPostInfo.setUserComName(acciRegistDto.getMakeComName());
		registEditPostInfo.setUserCode(acciRegistDto.getOperatorCode());
		registEditPostInfo.setUserName(acciRegistDto.getOperatorName());
		registEditPostInfo.setPrpLregistReceiverCode(acciRegistDto.getOperatorCode());
		registEditPostInfo.setPrpLregistReceiverName(acciRegistDto.getOperatorName());
		
		registEditPostInfo.setPrpLregistDamageStartDate(acciRegistDto.getDamageStartDate());
		registEditPostInfo.setPrpLregistDamageStartHour(acciRegistDto.getDamageStartHour());
		registEditPostInfo.setPrpLregistDamageCode(acciRegistDto.getDamageCode());
		registEditPostInfo.setPrpLregistDamageName(acciRegistDto.getDamageName());
		registEditPostInfo.setPrpLregistReportorName(acciRegistDto.getReportorName());
		registEditPostInfo.setPrpLregistReportDate(acciRegistDto.getReportDate());
		registEditPostInfo.setPrpLregistReportHour(acciRegistDto.getReportHour());
		registEditPostInfo.setReportType(acciRegistDto.getReportType());
		Date date = new Date();
		SimpleDateFormat simp = new SimpleDateFormat("yyyyMMdd");
		registEditPostInfo.setPrpLregistInputDate(simp.format(date));
		registEditPostInfo.setPrpLregistLinkerName(acciRegistDto.getLinkerName());
		registEditPostInfo.setPrpLregistPhoneNumber(acciRegistDto.getPhoneNumber());
		registEditPostInfo.setPrpLregistLinkerAddress(acciRegistDto.getLinkerAddress());
		registEditPostInfo.setPrpLregistLossesNumber(acciRegistDto.getLossesNumber());
		registEditPostInfo.setPrpLregistClauseType(acciRegistDto.getClauseType());
		registEditPostInfo.setPrpLregistDamageAddress(acciRegistDto.getDamageAddress());
		registEditPostInfo.setPrpLregistDamageTypeCode(acciRegistDto.getDamageTypeCode());
		registEditPostInfo.setPrpLregistDamageTypeName(acciRegistDto.getDamageTypeName());
		registEditPostInfo.setPrplregistReportFlag(acciRegistDto.getReportFlag());
		registEditPostInfo.setPrpLregistOperatorCode(acciRegistDto.getOperatorCode());
		registEditPostInfo.setPrpLregistMakeCom(acciRegistDto.getMakeCom());
		registEditPostInfo.setPrpLregistRemark(acciRegistDto.getRemark());
		registEditPostInfo.setPrpLregistTextContextInnerHTML(acciRegistDto.getContext());
		registEditPostInfo.setPrpCatastropheCode1(acciRegistDto.getCatastropheCode1());
		registEditPostInfo.setPrpCatastropheName1(acciRegistDto.getCatastropheName1());
		registEditPostInfo.setPrpCatastropheCode2(acciRegistDto.getCatastropheCode2());
		registEditPostInfo.setPrpCatastropheName2(acciRegistDto.getCatastropheName2());
		registEditPostInfo.setPrpLregistEstiCurrency(acciRegistDto.getEstiCurrency());
		
		AcciPersonDto[] list = acciRegistDto.getAcciPersonDtoList();
		if(null != list && list.length>0){
			String[] prpLacciBenPersonSerialNo = new String[list.length];
			String[] prpLacciPersonFamilyNo = new String[list.length];
			String[] prpLacciPersonAcciCode = new String[list.length];
			String[] prpLacciPersonAcciName = new String[list.length];
			String[] prpLacciPersonSex = new String[list.length];
			String[] prpLacciPersonAge = new String[list.length];
			String[] prpLacciPersonIdentifyNumber = new String[list.length];
			String[] prpLacciPersonAddress = new String[list.length];
			for(int i=0;i<list.length;i++){
				AcciPersonDto acciPersonDto = list[i];
				prpLacciBenPersonSerialNo[i] = acciPersonDto.getSerialNo();
				prpLacciPersonFamilyNo[i] = acciPersonDto.getFamilyNo();
				prpLacciPersonAcciCode[i] = acciPersonDto.getAcciCode();
				prpLacciPersonAcciName[i] = acciPersonDto.getAcciName();
				prpLacciPersonSex[i] = acciPersonDto.getSex();
				prpLacciPersonAge[i] = acciPersonDto.getAge();
				prpLacciPersonIdentifyNumber[i] = acciPersonDto.getIdentifyNumber();
				prpLacciPersonAddress[i] = "";
			}
			registEditPostInfo.setPrpLacciBenPersonSerialNo(prpLacciBenPersonSerialNo);
			registEditPostInfo.setPrpLacciPersonFamilyNo(prpLacciPersonFamilyNo);
			registEditPostInfo.setPrpLacciPersonAcciCode(prpLacciPersonAcciCode);
			registEditPostInfo.setPrpLacciPersonAcciName(prpLacciPersonAcciName);
			registEditPostInfo.setPrpLacciPersonSex(prpLacciPersonSex);
			registEditPostInfo.setPrpLacciPersonAge(prpLacciPersonAge);
			registEditPostInfo.setPrpLacciPersonIdentifyNumber(prpLacciPersonIdentifyNumber);
			registEditPostInfo.setPrpLacciPersonAddress(prpLacciPersonAddress);
		}
		
		return registEditPostInfo;
	}
	
	public RegistEditPostInfo transLiabRegistEditPostInfo(LiabRegistDto liabRegistDto){
		RegistEditPostInfo registEditPostInfo = new RegistEditPostInfo();
		registEditPostInfo.setButtonSaveType("4");
		registEditPostInfo.setPrpLregistRiskCode(liabRegistDto.getRiskCode());
		registEditPostInfo.setPrpLregistPolicyNo(liabRegistDto.getPolicyNo());
		registEditPostInfo.setPrpLregistDamageStartDate(liabRegistDto.getDamageStartDate());
		registEditPostInfo.setPrpLregistDamageStartHour(liabRegistDto.getDamageStartHour());
		registEditPostInfo.setPrpLregistDamageStartMinute(liabRegistDto.getDamageStartMinute());
		registEditPostInfo = policyDtoToView(registEditPostInfo);
		
		registEditPostInfo.setUserComCode(liabRegistDto.getMakeCom());
		registEditPostInfo.setUserComName(liabRegistDto.getMakeComName());
		registEditPostInfo.setUserCode(liabRegistDto.getOperatorCode());
		registEditPostInfo.setUserName(liabRegistDto.getOperatorName());
		registEditPostInfo.setPrpLregistReceiverCode(liabRegistDto.getOperatorCode());
		registEditPostInfo.setPrpLregistReceiverName(liabRegistDto.getOperatorName());
		
		registEditPostInfo.setPrpLregistDamageCode(liabRegistDto.getDamageCode());
		registEditPostInfo.setPrpLregistDamageName(liabRegistDto.getDamageName());
		registEditPostInfo.setPrpLregistReportorName(liabRegistDto.getReportorName());
		registEditPostInfo.setPrpLregistReportDate(liabRegistDto.getReportDate());
		registEditPostInfo.setPrpLregistReportHour(liabRegistDto.getReportHour());
		registEditPostInfo.setReportType(liabRegistDto.getReportType());
		Date date = new Date();
		SimpleDateFormat simp = new SimpleDateFormat("yyyyMMdd");
		registEditPostInfo.setPrpLregistInputDate(simp.format(date));
		registEditPostInfo.setPrpLregistLinkerName(liabRegistDto.getLinkerName());
		registEditPostInfo.setPrpLregistPhoneNumber(liabRegistDto.getPhoneNumber());
		registEditPostInfo.setPrpLregistAddressCode(liabRegistDto.getAddressCode());
		registEditPostInfo.setPrpLregistDamageAddress(liabRegistDto.getDamageAddress());
		registEditPostInfo.setPrpLregistEstimateLoss(liabRegistDto.getEstimateLoss());
		registEditPostInfo.setPrpLregistLossName(liabRegistDto.getLossName());
		registEditPostInfo.setPrpLregistOperatorCode(liabRegistDto.getOperatorCode());
		registEditPostInfo.setPrpLregistMakeCom(liabRegistDto.getMakeCom());
		registEditPostInfo.setPrpLregistRemark(liabRegistDto.getRemark());
		registEditPostInfo.setPrpLregistTextContextInnerHTML(liabRegistDto.getTextContext());
		registEditPostInfo.setPrpCatastropheCode1(liabRegistDto.getCatastropheCode1());
		registEditPostInfo.setPrpCatastropheName1(liabRegistDto.getCatastropheName1());
		registEditPostInfo.setPrpCatastropheCode2(liabRegistDto.getCatastropheCode2());
		registEditPostInfo.setPrpCatastropheName2(liabRegistDto.getCatastropheName2());
		registEditPostInfo.setPrpLregistEstiCurrency(liabRegistDto.getEstiCurrency());
		
//		//zhoujiawei:针对特殊险种停车场责任险需要添加传入参数（入参内容参考意健险报案信息中的事故者信息）
//		if("1532".equals(liabRegistDto.getRiskCode())){
//			AcciPersonDto[] list = liabRegistDto.getAcciPersonDtoList();
//			if(null != list && list.length>0){
//				String[] prpLacciBenPersonSerialNo = new String[list.length];
//				String[] prpLacciPersonFamilyNo = new String[list.length];
//				String[] prpLacciPersonAcciCode = new String[list.length];
//				String[] prpLacciPersonAcciName = new String[list.length];
//				String[] prpLacciPersonSex = new String[list.length];
//				String[] prpLacciPersonAge = new String[list.length];
//				String[] prpLacciPersonIdentifyNumber = new String[list.length];
//				String[] prpLacciPersonAddress = new String[list.length];
//				for(int i=0;i<list.length;i++){
//					AcciPersonDto acciPersonDto = list[i];
//					prpLacciBenPersonSerialNo[i] = acciPersonDto.getSerialNo();
//					prpLacciPersonFamilyNo[i] = acciPersonDto.getFamilyNo();
//					prpLacciPersonAcciCode[i] = "";
//					prpLacciPersonAcciName[i] = acciPersonDto.getAcciName();
//					prpLacciPersonSex[i] = "";
//					prpLacciPersonAge[i] = "";
//					prpLacciPersonIdentifyNumber[i] = acciPersonDto.getIdentifyNumber();
//					prpLacciPersonAddress[i] = "";
//				}
//				registEditPostInfo.setPrpLacciBenPersonSerialNo(prpLacciBenPersonSerialNo);
//				registEditPostInfo.setPrpLacciPersonFamilyNo(prpLacciPersonFamilyNo);
//				registEditPostInfo.setPrpLacciPersonAcciCode(prpLacciPersonAcciCode);
//				registEditPostInfo.setPrpLacciPersonAcciName(prpLacciPersonAcciName);
//				registEditPostInfo.setPrpLacciPersonSex(prpLacciPersonSex);
//				registEditPostInfo.setPrpLacciPersonAge(prpLacciPersonAge);
//				registEditPostInfo.setPrpLacciPersonIdentifyNumber(prpLacciPersonIdentifyNumber);
//				registEditPostInfo.setPrpLacciPersonAddress(prpLacciPersonAddress);
//			}
//		}
		
		
		
		
		
		return registEditPostInfo;
	}
	
	public RegistEditPostInfo policyDtoToView(RegistEditPostInfo registEditPostInfo){
		try {
			// 根据出险时间找到保单
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			String policyNo = registEditPostInfo.getPrpLregistPolicyNo();
			String damageDate = registEditPostInfo.getPrpLregistDamageStartDate();
			String damageHour = registEditPostInfo.getPrpLregistDamageStartHour();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
					policyNo, damageDate, damageHour);
			
			registEditPostInfo.setPrpLregistPolicyNo(policyNo);
			registEditPostInfo.setPrpLregistClassCode(policyDto.getPrpCmainDto().getClassCode());
			registEditPostInfo.setFirstSiteFlag("0");// 设置默认现场为非第一现场
			String handler1Code = policyDto.getPrpCmainDto().getHandler1Code();
			registEditPostInfo.setPrpLregistHandler1Code(handler1Code);
			String comCode = policyDto.getPrpCmainDto().getComCode();
			registEditPostInfo.setPrpLregistComCode(comCode);
			registEditPostInfo.setPrpLregistEstiCurrency(policyDto.getPrpCmainDto().getCurrency());
			registEditPostInfo.setPrpLregistLanguage(policyDto.getPrpCmainDto().getLanguage());
			// 取得理赔登记机构信息
			String strInsuredName = "";
			int insureQuantity = policyDto.getPrpCmainDto().getSumQuantity();
		    if (String.valueOf(insureQuantity) == null || String.valueOf(insureQuantity).equals("")
				|| insureQuantity <= 1 ) {
		    	
			       strInsuredName = policyDto.getPrpCmainDto().getInsuredName();
			       
			}
			else {
				   strInsuredName = policyDto.getPrpCmainDto().getInsuredName()+"等"+insureQuantity+"人";	
			}
			registEditPostInfo.setPrpLregistInsuredCode(policyDto.getPrpCmainDto().getInsuredCode());
			registEditPostInfo.setPrpLregistInsuredName(strInsuredName);
			registEditPostInfo.setPrpLregistInsuredAddress(policyDto.getPrpCmainDto().getInsuredAddress());
			registEditPostInfo.setPrpLregistLFlag("L");
			// 默认的是否受理是Y,投其他公司的是N
			registEditPostInfo.setAcceptFlag("Y");
			registEditPostInfo.setRepeatInsureFlag("N");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return registEditPostInfo;
	}
	
	private boolean isEmpty(String str) {
		return (str == null || str.trim().length() == 0);
	}

}
