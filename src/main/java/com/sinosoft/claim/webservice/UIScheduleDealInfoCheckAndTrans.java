package com.sinosoft.claim.webservice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import com.sinosoft.claim.dto.custom.AgriScheduleDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.PropScheduleDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.RegistExtDto;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.sysframework.common.util.StringUtils;

public class UIScheduleDealInfoCheckAndTrans {
	
	public String checkAgriScheduleInfo(AgriScheduleDto agriScheduleDto){
		String result = "";
		if(isEmpty(agriScheduleDto.getRegistNo())){
			result="001^报案号码不能为空，请检查。";
			return result;
	    }
		if(isEmpty(agriScheduleDto.getRiskCode())){
			result="001^险种不能为空，请检查。";
			return result;
	    }
		if(isEmpty(agriScheduleDto.getScheduleObjectID())){
			result="001^查勘处理单位代码不能为空，请检查。";
			return result;
	    }
		if(isEmpty(agriScheduleDto.getScheduleObjectName())){
			result="001^查勘处理单位不能为空，请检查。";
			return result;
	    }
		if(isEmpty(agriScheduleDto.getCheckSite())){
			result="001^查勘地址不能为空，请检查。";
			return result;
	    }
		if(isEmpty(agriScheduleDto.getItemScheduleObjectID())){
			result="001^定损处理单位代码不能为空，请检查。";
			return result;
	    }
		if(isEmpty(agriScheduleDto.getItemScheduleObjectName())){
			result="001^定损处理单位不能为空，请检查。";
			return result;
	    }
		if(isEmpty(agriScheduleDto.getItemCheckSit())){
			result="001^定损地址不能为空，请检查。";
			return result;
	    }
		if(isEmpty(agriScheduleDto.getExigenceGree())){
			result="001^案件状态不能为空，请检查。";
			return result;
	    }
		if(isEmpty(agriScheduleDto.getOperatorCode())){
			result="001^操作人员代码不能为空，请检查。";
			return result;
	    }
		if(isEmpty(agriScheduleDto.getOperatorName())){
			result="001^操作人员不能为空，请检查。";
			return result;
	    }
		if(isEmpty(agriScheduleDto.getMakeComCode())){
			result="001^操作机构代码不能为空，请检查。";
			return result;
	    }
		if(isEmpty(agriScheduleDto.getMakeComName())){
			result="001^操作机构不能为空，请检查。";
			return result;
	    }
		
		return result;
	}
	
	public String checkPropScheduleInfo(PropScheduleDto propScheduleDto){
		String result = "";
		if(isEmpty(propScheduleDto.getRegistNo())){
			result="001^报案号码不能为空，请检查。";
			return result;
	    }
		if(isEmpty(propScheduleDto.getRiskCode())){
			result="001^险种不能为空，请检查。";
			return result;
	    }
		if(isEmpty(propScheduleDto.getScheduleObjectID())){
			result="001^查勘处理单位代码不能为空，请检查。";
			return result;
	    }
		if(isEmpty(propScheduleDto.getScheduleObjectName())){
			result="001^查勘处理单位不能为空，请检查。";
			return result;
	    }
		if(isEmpty(propScheduleDto.getCheckSite())){
			result="001^查勘地址不能为空，请检查。";
			return result;
	    }
		if(isEmpty(propScheduleDto.getOperatorCode())){
			result="001^操作人员代码不能为空，请检查。";
			return result;
	    }
		if(isEmpty(propScheduleDto.getOperatorName())){
			result="001^操作人员不能为空，请检查。";
			return result;
	    }
		if(isEmpty(propScheduleDto.getMakeComCode())){
			result="001^操作机构代码不能为空，请检查。";
			return result;
	    }
		if(isEmpty(propScheduleDto.getMakeComName())){
			result="001^操作机构不能为空，请检查。";
			return result;
	    }
		
		return result;
	}
	
	public UIScheduleDealEditPostInfo transAgriScheduleToUiScheduleDeal(AgriScheduleDto agriScheduleDto){
		UIScheduleDealEditPostInfo uiScheduleDealEditPostInfo = new UIScheduleDealEditPostInfo();
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFRegistNo(agriScheduleDto.getRegistNo());
		UserDto user = new UserDto();
		user.setUserCode(agriScheduleDto.getOperatorCode());
		user.setUserName(agriScheduleDto.getOperatorName());
		user.setComCode(agriScheduleDto.getMakeComCode());
		user.setComName(agriScheduleDto.getMakeComName());
		ScheduleDto scheduleDto = scheduleDtoToView(user, uiScheduleDealEditPostInfo);
		PrpLscheduleMainWFDto prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto();
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFPolicyNo(prpLscheduleMainWFDto.getPolicyNo());
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFScheduleID(String.valueOf(prpLscheduleMainWFDto.getScheduleID()));
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFCheckClaimComCode(prpLscheduleMainWFDto.getClaimComCode());
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFRiskCode(prpLscheduleMainWFDto.getRiskCode());
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFScheduleType(prpLscheduleMainWFDto.getScheduleType());
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFSaveType(prpLscheduleMainWFDto.getSaveType());
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFScheduleFlag(prpLscheduleMainWFDto.getScheduleFlag());
		uiScheduleDealEditPostInfo.setFlag(prpLscheduleMainWFDto.getFlag());
		uiScheduleDealEditPostInfo.setNextNodeNo1(prpLscheduleMainWFDto.getNextNodeNo());
		uiScheduleDealEditPostInfo.setCheckCommiItemFlag(prpLscheduleMainWFDto.getCommiItemFlag());
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFDtoCommiFlag(prpLscheduleMainWFDto.getCommiFlag());
		uiScheduleDealEditPostInfo.setCheckSelectSend("1");
		
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFScheduleObjectID(agriScheduleDto.getScheduleObjectID());
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFScheduleObjectName(agriScheduleDto.getScheduleObjectName());
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFCheckInfo(agriScheduleDto.getCheckInfo());
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFCheckSite(agriScheduleDto.getCheckSite());
		uiScheduleDealEditPostInfo.setNextHandlerCode1(agriScheduleDto.getNextHandlerCode1());
		uiScheduleDealEditPostInfo.setNextHandlerName1(agriScheduleDto.getNextHandlerName1());
		
		ArrayList<PrpLscheduleItemDto> prpLscheduleItemDtoList = scheduleDto.getPrpLscheduleItemDtoList();
		if(null != prpLscheduleItemDtoList && prpLscheduleItemDtoList.size()>0){
			PrpLscheduleItemDto prpLscheduleItemDto = prpLscheduleItemDtoList.get(0);
			uiScheduleDealEditPostInfo.setPrpLscheduleItemScheduleID(String.valueOf(prpLscheduleItemDto.getScheduleID()));
			uiScheduleDealEditPostInfo.setPrpLscheduleItemItemNo(String.valueOf(prpLscheduleItemDto.getItemNo()));
			uiScheduleDealEditPostInfo.setPrpLscheduleItemSelectSend("1");
			uiScheduleDealEditPostInfo.setPrpLscheduleItemClaimComCode(prpLscheduleItemDto.getClaimComCode());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemCommiItemFlag(prpLscheduleItemDto.getCommiItemFlag());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemSurveyTimes(String.valueOf(prpLscheduleItemDto.getSurveyTimes()));
			uiScheduleDealEditPostInfo.setSurveyType(prpLscheduleItemDto.getSurveyType());
			
			uiScheduleDealEditPostInfo.setPrpLscheduleItemCheckSite(agriScheduleDto.getItemCheckSit());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemScheduleObjectID(agriScheduleDto.getItemScheduleObjectID());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemScheduleObjectName(agriScheduleDto.getItemScheduleObjectName());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemCommendRepairFactoryName(agriScheduleDto.getRepairFactoryName());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemFactoryEstimateLoss(agriScheduleDto.getFactoryEstimateLoss());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemFactoryPhone(agriScheduleDto.getFactoryPhone());
			uiScheduleDealEditPostInfo.setExigenceGree(agriScheduleDto.getExigenceGree());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemResultInfo(agriScheduleDto.getResultInfo());
			
			uiScheduleDealEditPostInfo.setPrpLscheduleItemBookFlag(prpLscheduleItemDto.getBookFlag());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemScheduleType(prpLscheduleItemDto.getScheduleType());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemFlag(prpLscheduleItemDto.getFlag());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemOperatorCode(prpLscheduleItemDto.getOperatorCode());
			if(null != prpLscheduleItemDto.getInputDate()){
				String prpLscheduleItemInputDate = new SimpleDateFormat("yyyy-MM-dd").format(prpLscheduleItemDto.getInputDate());
				uiScheduleDealEditPostInfo.setPrpLscheduleItemInputDate(prpLscheduleItemInputDate);
			}
			uiScheduleDealEditPostInfo.setNextNodeNo(prpLscheduleItemDto.getNextNodeNo());
			
			uiScheduleDealEditPostInfo.setNextHandlerCode(agriScheduleDto.getNextHandlerCode());
			uiScheduleDealEditPostInfo.setNextHandlerName(agriScheduleDto.getNextHandlerName());
			
			if(null != prpLscheduleMainWFDto.getInputDate()){
				String prpLscheduleMainWFInput = new SimpleDateFormat("yyyy-MM-dd").format(prpLscheduleMainWFDto.getInputDate());
				uiScheduleDealEditPostInfo.setPrpLscheduleMainWFInputDate(prpLscheduleMainWFInput);
			}
			
		}
		
		RegistExtDto[] registExtDto = agriScheduleDto.getRegistExtDto();
		if(null != registExtDto && registExtDto.length>0){
			int size = registExtDto.length;
			String[] prpLregistExtSerialNo = new String[size];
			String[] prpLregistExtInputDate = new String[size];
			String[] prpLregistExtInputHour = new String[size];
			String[] prpLregistExtOperatorCode = new String[size];
			String[] prpLregistExtContext = new String[size];
			for(int i=0;i<registExtDto.length;i++){
				prpLregistExtSerialNo[i] = registExtDto[i].getSerialno();
				prpLregistExtInputDate[i] = registExtDto[i].getInputDate();
				prpLregistExtInputHour[i] = registExtDto[i].getInputHour();
				prpLregistExtOperatorCode[i] = registExtDto[i].getOperatorCode();
				prpLregistExtContext[i] = registExtDto[i].getContext();
			}
			uiScheduleDealEditPostInfo.setPrpLregistExtSerialNo(prpLregistExtSerialNo);
			uiScheduleDealEditPostInfo.setPrpLregistExtInputDate(prpLregistExtInputDate);
			uiScheduleDealEditPostInfo.setPrpLregistExtInputHour(prpLregistExtInputHour);
			uiScheduleDealEditPostInfo.setPrpLregistExtOperatorCode(prpLregistExtOperatorCode);
			uiScheduleDealEditPostInfo.setPrpLregistExtContext(prpLregistExtContext);
		}
		
		return uiScheduleDealEditPostInfo;
	}
	
	public UIScheduleDealEditPostInfo transPropScheduleToUiScheduleDeal(PropScheduleDto propScheduleDto){
		UIScheduleDealEditPostInfo uiScheduleDealEditPostInfo = new UIScheduleDealEditPostInfo();
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFRegistNo(propScheduleDto.getRegistNo());
		UserDto user = new UserDto();
		user.setUserCode(propScheduleDto.getOperatorCode());
		user.setUserName(propScheduleDto.getOperatorName());
		user.setComCode(propScheduleDto.getMakeComCode());
		user.setComName(propScheduleDto.getMakeComName());
		ScheduleDto scheduleDto = scheduleDtoToView(user, uiScheduleDealEditPostInfo);
		PrpLscheduleMainWFDto prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto();
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFPolicyNo(prpLscheduleMainWFDto.getPolicyNo());
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFScheduleID(String.valueOf(prpLscheduleMainWFDto.getScheduleID()));
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFCheckClaimComCode(prpLscheduleMainWFDto.getClaimComCode());
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFRiskCode(prpLscheduleMainWFDto.getRiskCode());
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFScheduleType(prpLscheduleMainWFDto.getScheduleType());
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFSaveType(prpLscheduleMainWFDto.getSaveType());
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFScheduleFlag(prpLscheduleMainWFDto.getScheduleFlag());
		uiScheduleDealEditPostInfo.setFlag(prpLscheduleMainWFDto.getFlag());
		uiScheduleDealEditPostInfo.setNextNodeNo1(prpLscheduleMainWFDto.getNextNodeNo());
		uiScheduleDealEditPostInfo.setCheckCommiItemFlag(prpLscheduleMainWFDto.getCommiItemFlag());
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFDtoCommiFlag(prpLscheduleMainWFDto.getCommiFlag());
		uiScheduleDealEditPostInfo.setCheckSelectSend("1");
		
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFScheduleObjectID(propScheduleDto.getScheduleObjectID());
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFScheduleObjectName(propScheduleDto.getScheduleObjectName());
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFCheckInfo(propScheduleDto.getCheckInfo());
		uiScheduleDealEditPostInfo.setPrpLscheduleMainWFCheckSite(propScheduleDto.getCheckSite());
		uiScheduleDealEditPostInfo.setNextHandlerCode1(propScheduleDto.getNextHandlerCode1());
		uiScheduleDealEditPostInfo.setNextHandlerName1(propScheduleDto.getNextHandlerName1());
		
		ArrayList<PrpLscheduleItemDto> prpLscheduleItemDtoList = scheduleDto.getPrpLscheduleItemDtoList();
		if(null != prpLscheduleItemDtoList && prpLscheduleItemDtoList.size()>0){
			PrpLscheduleItemDto prpLscheduleItemDto = prpLscheduleItemDtoList.get(0);
			uiScheduleDealEditPostInfo.setPrpLscheduleItemScheduleID(String.valueOf(prpLscheduleItemDto.getScheduleID()));
			uiScheduleDealEditPostInfo.setPrpLscheduleItemItemNo(String.valueOf(prpLscheduleItemDto.getItemNo()));
			uiScheduleDealEditPostInfo.setPrpLscheduleItemSelectSend("1");
			uiScheduleDealEditPostInfo.setPrpLscheduleItemClaimComCode(prpLscheduleItemDto.getClaimComCode());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemCommiItemFlag(prpLscheduleItemDto.getCommiItemFlag());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemSurveyTimes(String.valueOf(prpLscheduleItemDto.getSurveyTimes()));
			uiScheduleDealEditPostInfo.setSurveyType(prpLscheduleItemDto.getSurveyType());
			
			uiScheduleDealEditPostInfo.setPrpLscheduleItemCheckSite(prpLscheduleItemDto.getCheckSite());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemScheduleObjectID(prpLscheduleItemDto.getScheduleObjectID());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemScheduleObjectName(prpLscheduleItemDto.getScheduleObjectName());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemCommendRepairFactoryName(prpLscheduleItemDto.getCommendRepairFactoryName());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemFactoryEstimateLoss(String.valueOf(prpLscheduleItemDto.getFactoryEstimateLoss()));
			uiScheduleDealEditPostInfo.setPrpLscheduleItemFactoryPhone(prpLscheduleItemDto.getFactoryPhone());
			uiScheduleDealEditPostInfo.setExigenceGree(prpLscheduleItemDto.getExigenceGree());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemResultInfo(prpLscheduleItemDto.getResultInfo());
			
			uiScheduleDealEditPostInfo.setPrpLscheduleItemBookFlag(prpLscheduleItemDto.getBookFlag());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemScheduleType(prpLscheduleItemDto.getScheduleType());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemFlag(prpLscheduleItemDto.getFlag());
			uiScheduleDealEditPostInfo.setPrpLscheduleItemOperatorCode(prpLscheduleItemDto.getOperatorCode());
			if(null != prpLscheduleItemDto.getInputDate()){
				String prpLscheduleItemInputDate = new SimpleDateFormat("yyyy-MM-dd").format(prpLscheduleItemDto.getInputDate());
				uiScheduleDealEditPostInfo.setPrpLscheduleItemInputDate(prpLscheduleItemInputDate);
			}
			uiScheduleDealEditPostInfo.setNextNodeNo(prpLscheduleItemDto.getNextNodeNo());
			
			uiScheduleDealEditPostInfo.setNextHandlerCode(prpLscheduleItemDto.getNextHandlerCode());
			uiScheduleDealEditPostInfo.setNextHandlerName(prpLscheduleItemDto.getNextHandlerName());
			
			if(null != prpLscheduleMainWFDto.getInputDate()){
				String prpLscheduleMainWFInput = new SimpleDateFormat("yyyy-MM-dd").format(prpLscheduleMainWFDto.getInputDate());
				uiScheduleDealEditPostInfo.setPrpLscheduleMainWFInputDate(prpLscheduleMainWFInput);
			}
			
		}
		
		RegistExtDto[] registExtDto = propScheduleDto.getRegistExtDto();
		if(null != registExtDto && registExtDto.length>0){
			
			int size = registExtDto.length;
			String[] prpLregistExtSerialNo = new String[size];
			String[] prpLregistExtInputDate = new String[size];
			String[] prpLregistExtInputHour = new String[size];
			String[] prpLregistExtOperatorCode = new String[size];
			String[] prpLregistExtContext = new String[size];
			
			for(int i=0;i<registExtDto.length;i++){
				prpLregistExtSerialNo[i] = registExtDto[i].getSerialno();
				prpLregistExtInputDate[i] = registExtDto[i].getInputDate();
				prpLregistExtInputHour[i] = registExtDto[i].getInputHour();
				prpLregistExtOperatorCode[i] = registExtDto[i].getOperatorCode();
				prpLregistExtContext[i] = registExtDto[i].getContext();
			}
			uiScheduleDealEditPostInfo.setPrpLregistExtSerialNo(prpLregistExtSerialNo);
			uiScheduleDealEditPostInfo.setPrpLregistExtInputDate(prpLregistExtInputDate);
			uiScheduleDealEditPostInfo.setPrpLregistExtInputHour(prpLregistExtInputHour);
			uiScheduleDealEditPostInfo.setPrpLregistExtOperatorCode(prpLregistExtOperatorCode);
			uiScheduleDealEditPostInfo.setPrpLregistExtContext(prpLregistExtContext);
		}
		
		return uiScheduleDealEditPostInfo;
	}

	public ScheduleDto scheduleDtoToView(UserDto user,UIScheduleDealEditPostInfo uiScheduleDealEditPostInfo) {
		ScheduleDto scheduleDto = null;
		try {
			String registNo = uiScheduleDealEditPostInfo.getPrpLscheduleMainWFRegistNo();
			
			UIScheduleAction uiScheduleAction = new UIScheduleAction();
			scheduleDto = uiScheduleAction.findByPrimaryKey(1,registNo);
			PrpLscheduleMainWFDto prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto();
			
			String policyNo = prpLscheduleMainWFDto.getPolicyNo();
			
			UIRegistAction uiRegistAction = new UIRegistAction();
			RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);

			// 查询保单信息
			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(policyNo);
			UICodeAction uiCodeAction = new UICodeAction();

			// 如果查不到怎么办？ 写程序要注意的
			String agentCode = "";

			if (policyDto.getPrpCmainDto() != null) {
				agentCode = policyDto.getPrpCmainDto().getAgentCode(); // 代理人代码
			}

			if (agentCode == null) {
				agentCode = "";
			}
			if (agentCode != null && !"".equals(agentCode)) {
				prpLscheduleMainWFDto.setAgentCode(agentCode);
				prpLscheduleMainWFDto.setAgentName(uiCodeAction.translateAgentName(agentCode));// 得到代理人名称
			}

			// 设置扩展属性
			prpLscheduleMainWFDto.setLinkerName(registDto.getPrpLregistDto().getLinkerName());
			prpLscheduleMainWFDto.setPhoneNumber(registDto.getPrpLregistDto().getPhoneNumber());
			prpLscheduleMainWFDto.setOperatorName(user.getUserName());
			prpLscheduleMainWFDto.setLicenseNo(registDto.getPrpLregistDto().getLicenseNo());
			// 增加调度报损金额

			prpLscheduleMainWFDto.setEstimateLoss(registDto.getPrpLregistDto().getEstimateLoss());
			if ("_".equals(prpLscheduleMainWFDto.getScheduleObjectID())) {
				prpLscheduleMainWFDto.setScheduleObjectID("");
			}
			// 设置到底是什么类型的保存,可能是取回类型的

			String editType = "ADD";
			prpLscheduleMainWFDto.setSaveType(editType);

			// 给报案文件多行列表准备数据
			PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
			if (registDto.getPrpLregistTextDtoList() != null) {
				Iterator iterator = registDto.getPrpLregistTextDtoList().iterator();
				while (iterator.hasNext()) {
					PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto) iterator.next();
					if (StringUtils.rightTrim(prpLregistTextDtoTemp.getTextType()).equals("1")) {
						prpLscheduleMainWFDto.setRegistText(prpLscheduleMainWFDto.getRegistText()+ prpLregistTextDtoTemp.getContext());
					}
				}
			}
			// 设置查勘操作的状态为 案件修改 (正处理任务)
			if (scheduleDto.getPrpLclaimStatusDto() != null) {
				prpLscheduleMainWFDto.setStatus(scheduleDto
						.getPrpLclaimStatusDto().getStatus());
			} else {
				// 已提交，已经处理完毕的状态
				prpLscheduleMainWFDto.setStatus("4");
			}

			String commiFlag = "0";
			prpLscheduleMainWFDto.setCommiFlag(commiFlag);

			// (1)对业务归属结构进行转换
			String claimComCode = prpLscheduleMainWFDto.getClaimComCode();
			String claimComName = uiCodeAction.translateComCode(claimComCode,
					true);
			prpLscheduleMainWFDto.setClaimComName(claimComName);
			// (2)对操作员进行处理
			String operatorCode = prpLscheduleMainWFDto.getOperatorCode();
			String operatorName = uiCodeAction.translateUserCode(operatorCode,
					true);
			prpLscheduleMainWFDto.setOperatorName(operatorName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return scheduleDto;
	}
	
	private boolean isEmpty(String str) {
		return (str == null || str.trim().length() == 0);
	}

}
