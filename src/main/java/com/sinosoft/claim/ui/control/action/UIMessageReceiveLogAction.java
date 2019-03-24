package com.sinosoft.claim.ui.control.action;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import com.sinosoft.claim.SMSService.feedback.custom.MessageReceiveDto;
import com.sinosoft.claim.SMSService.feedback.custom.MessageSendDto;
import com.sinosoft.claim.bl.facade.BLMessageReceiveLogFacade;
import com.sinosoft.claim.dto.domain.MessageReceiveLogDto;
import com.sinosoft.sysframework.common.datatype.DateTime;

public class UIMessageReceiveLogAction {
	private MessageReceiveLogDto messageReceiveLogDto  = null;
	/**
	 * 将短信对象转为数据库保存对象
	 * */
	public MessageReceiveLogDto convertObject2DBObject(MessageSendDto sendDto,String ruleCode){
		MessageReceiveLogDto receiveLogDto = new MessageReceiveLogDto();
		DateTime dateTime = new DateTime(new Date());
		receiveLogDto.setRuleCode(ruleCode);
		receiveLogDto.setModuleCode(sendDto.getModuleCode());
		receiveLogDto.setBusinessNo1(sendDto.getBusinessNo1());
		receiveLogDto.setBusinessNo2(sendDto.getBusinessNo2());
		receiveLogDto.setBusinessNo3(sendDto.getBusinessNo3());
		receiveLogDto.setBusinessNo4(sendDto.getBusinessNo4());
		receiveLogDto.setBusinessNo5(sendDto.getBusinessNo5());
		receiveLogDto.setSendTime(dateTime);
		receiveLogDto.setSendText(sendDto.getContent());
		receiveLogDto.setSendPhone(sendDto.getMobilePhones());
		receiveLogDto.setMonth(dateTime.toString(DateTime.YEAR_TO_DAY));
		return receiveLogDto;
	}
	/**
	 * 保存发送内容到数据库中
	 * @throws Exception 
	 * */
	public boolean save(MessageSendDto sendDto,String ruleCode) throws Exception{
		boolean isSuccess = false;
		this.messageReceiveLogDto = this.convertObject2DBObject(sendDto, ruleCode);
		BLMessageReceiveLogFacade blMessageReceiveLogFacade = new BLMessageReceiveLogFacade();
		if(this.messageReceiveLogDto != null){
			blMessageReceiveLogFacade.insert(this.messageReceiveLogDto);
			isSuccess = true;
		}
		return isSuccess;
	}
	public boolean update(MessageReceiveDto receiveDto) throws Exception {
		boolean isSuccess = false;
		if(receiveDto == null){
			return isSuccess;
		}
		BLMessageReceiveLogFacade blMessageReceiveLogFacade = new BLMessageReceiveLogFacade();
		Collection collection = blMessageReceiveLogFacade.findByConditions(" RuleCode = '"+receiveDto.getRuleCode()+"' order by SendTime desc");
		MessageReceiveLogDto messageReceiveLogDto = null;
		if(collection.size()>0){
			messageReceiveLogDto = (MessageReceiveLogDto)collection.iterator().next();
			messageReceiveLogDto.setReceivePhone(receiveDto.getMobilePhones());
			messageReceiveLogDto.setReceiveText(receiveDto.getContent());
			messageReceiveLogDto.setReceiveTime(new DateTime(receiveDto.getReceiveTime(),DateTime.YEAR_TO_DAY));
			messageReceiveLogDto.setBusinessNo1(receiveDto.getBusinessNo1());
			messageReceiveLogDto.setBusinessNo2(receiveDto.getBusinessNo2());
			messageReceiveLogDto.setBusinessNo3(receiveDto.getBusinessNo3());
			messageReceiveLogDto.setBusinessNo4(receiveDto.getBusinessNo4());
			messageReceiveLogDto.setBusinessNo5(receiveDto.getBusinessNo5());
		}
		if(messageReceiveLogDto !=null){
			blMessageReceiveLogFacade.update(messageReceiveLogDto);
			isSuccess = true;
		}
		return isSuccess;
	}
}
