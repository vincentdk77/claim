package com.sinosoft.claim.SMSService.feedback;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.sinosoft.claim.SMSService.ServiceInterface;
import com.sinosoft.claim.SMSService.URLInterface;
import com.sinosoft.claim.SMSService.feedback.custom.MessageReceiveDto;
import com.sinosoft.claim.SMSService.feedback.custom.MessageSendDto;
import com.sinosoft.claim.ui.control.action.UIMessageReceiveLogAction;
import com.sinosoft.sysframework.reference.AppConfig;
/**
 * 默认情况，以WebService发送
 * */
public class MessageCenter {
	public static final String SEND_WEBSERVICE = "0";
	public static final String SEND_URL = "1";
	/**短信发送
	 * 单个对象发送
	 * @throws Exception */
	public String send(MessageSendDto sendDto) throws Exception{
		String isFail = "1";
		//转为报文
		MessageHandler handler = new MessageHandler();
		String reqXml = handler.convertObject2Xml(sendDto);
		System.err.print(reqXml);
		//发送给服务端
		String endpoint = AppConfig.get("sysconst.ENDPOINT_URL");
		ServiceInterface service = new ServiceInterface(endpoint,"sendSMS");
		UIMessageReceiveLogAction uiMessageReceiveLogAction = new UIMessageReceiveLogAction();
		String ruleCode = service.send(reqXml);
		System.err.println("------------------"+ruleCode);
		//返回发送成功标志
		if("0".equals(ruleCode)){
			isFail = "0";
		}else if(this.checkRuleCode(ruleCode)){
			//成功
			isFail = "0";
			//数据库保存
			uiMessageReceiveLogAction.save(sendDto, ruleCode);
		}
		return isFail;
	}
	
	/**群发短信
	 * @throws Exception */
	public Map send(List<MessageSendDto> sendDtoList) throws Exception{
		Map rtnMap =  new TreeMap();
		if(null == sendDtoList || sendDtoList.size()==0){
			return null;
		}
		String reqXml = "";
		String ruleCode = "";
		MessageSendDto sendDto = null;
		MessageHandler handler = new MessageHandler();
		String endpoint = AppConfig.get("sysconst.ENDPOINT_URL");
		ServiceInterface service = new ServiceInterface(endpoint,"sendSMS");
		UIMessageReceiveLogAction uiMessageReceiveLogAction = new UIMessageReceiveLogAction();
		for(Iterator itr = sendDtoList.iterator();itr.hasNext();){
			sendDto = (MessageSendDto)itr.next();
			reqXml = handler.convertObject2Xml(sendDto);
			ruleCode = service.send(reqXml);
			/**
			 * 对于核心系统续保短信，老理赔调度，新理赔调度短信，发送成功返回0，否则返回1或者异常
			 * 对于其他返回回执编码
			 * */
			if("0".equals(ruleCode)){
				rtnMap.put(sendDto.getAcceptor(), "0");
			}else if(this.checkRuleCode(ruleCode)){
				//成功
				rtnMap.put(sendDto.getAcceptor(), "0");
				//数据库保存
				uiMessageReceiveLogAction.save(sendDto, ruleCode);
			}else{
				rtnMap.put(sendDto.getAcceptor(), "1");
			}
		}
		return rtnMap;
	}
	/**发送短信
	 * @throws Exception */
	public String send(MessageSendDto sendDto,String type) throws Exception{
		String rtnStr = "";
		if(this.SEND_URL.equals(type)){
			rtnStr = this.sendURL(sendDto);
		}else{
			rtnStr = this.send(sendDto);
		}
		return rtnStr;
	}
	/**
	 * URL形式发送短信
	 * */
	private String sendURL(MessageSendDto sendDto) throws Exception{
		String isFail = "1";
		//转为参数Map
		MessageHandler handler = new MessageHandler();
		Map paramMap = handler.convertObject2Map(sendDto);
		//发送给服务端
		String urlPath = AppConfig.get("sysconst.SMS_ENDPOINT_URL");
		UIMessageReceiveLogAction uiMessageReceiveLogAction = new UIMessageReceiveLogAction();
		URLInterface service = new URLInterface(urlPath);
		String ruleCode = service.send(paramMap);
		//数据保存
		if("OK".equals(ruleCode)){
			isFail = "0";//成功
		}else if(this.checkRuleCode(ruleCode)){
			isFail = "0";//成功
			//数据库保存
			uiMessageReceiveLogAction.save(sendDto, ruleCode);
		}
		return isFail;
	}
	/**
	 * 发送短信
	 * */
	public Map send(List<MessageSendDto> sendDtoList,String type) throws Exception{
		Map rtnMap = null;
		if(this.SEND_URL.equals(type)){
			rtnMap = this.sendURL(sendDtoList);
		}else{
			rtnMap = this.send(sendDtoList);
		}
		return rtnMap;
	}
	
	/**
	 * URL形式群发短信
	 * @throws Exception 
	 * */
	private Map sendURL(List<MessageSendDto> sendDtoList) throws Exception{
		Map rtnMap =  new TreeMap();
		if(null == sendDtoList || sendDtoList.size()==0){
			return null;
		}
		Map paramMap = null;
		String ruleCode = "";
		MessageSendDto sendDto = null;
		MessageHandler handler = new MessageHandler();
		String urlPath = AppConfig.get("sysconst.SMS_ENDPOINT_URL");
		URLInterface service = new URLInterface(urlPath);
		UIMessageReceiveLogAction uiMessageReceiveLogAction = new UIMessageReceiveLogAction();
		for(Iterator itr = sendDtoList.iterator();itr.hasNext();){
			sendDto = (MessageSendDto)itr.next();
			paramMap = handler.convertObject2Map(sendDto);
			ruleCode = service.send(paramMap);
			if("OK".equals(ruleCode)){
				rtnMap.put(sendDto.getAcceptor(), "0");
			}else if(this.checkRuleCode(ruleCode)){
				//成功
				rtnMap.put(sendDto.getAcceptor(), "0");
				//数据库保存
				uiMessageReceiveLogAction.save(sendDto, ruleCode);
			}else{
				rtnMap.put(sendDto.getAcceptor(), "1");
			}
		}
		return rtnMap;
	}
	
	/**校验规则编码
	 * 若规则编码符合 前两位01-99，后两位a1-z9，则发送成功；否则发送失败
	 * */
	private boolean checkRuleCode(String ruleCode){
		if(ruleCode.matches("^\\d{1}[1-9]{1}[a-z]{1}\\d{1}$")){
			return true;
		}else{
			return false;
		}
	}
	/**短信接收*/
	public String receive(String respXml){
		String isSuccess = "0";
		try{
			System.err.println(respXml);
			//转为对象
			MessageHandler handler = new MessageHandler();
			MessageReceiveDto receiveDto = handler.convertXml2Object(respXml);
			//数据更新
			UIMessageReceiveLogAction uiMessageReceiveLogAction = new UIMessageReceiveLogAction();
			boolean successFlag = uiMessageReceiveLogAction.update(receiveDto);
			//返回成功标志
			if(successFlag)
				isSuccess = "1";
		}catch(Exception e){
			e.printStackTrace();
			System.err.print(e.getMessage());
			return e.getMessage();
		}
		return isSuccess;
	}
}
