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
 * Ĭ���������WebService����
 * */
public class MessageCenter {
	public static final String SEND_WEBSERVICE = "0";
	public static final String SEND_URL = "1";
	/**���ŷ���
	 * ����������
	 * @throws Exception */
	public String send(MessageSendDto sendDto) throws Exception{
		String isFail = "1";
		//תΪ����
		MessageHandler handler = new MessageHandler();
		String reqXml = handler.convertObject2Xml(sendDto);
		System.err.print(reqXml);
		//���͸������
		String endpoint = AppConfig.get("sysconst.ENDPOINT_URL");
		ServiceInterface service = new ServiceInterface(endpoint,"sendSMS");
		UIMessageReceiveLogAction uiMessageReceiveLogAction = new UIMessageReceiveLogAction();
		String ruleCode = service.send(reqXml);
		System.err.println("------------------"+ruleCode);
		//���ط��ͳɹ���־
		if("0".equals(ruleCode)){
			isFail = "0";
		}else if(this.checkRuleCode(ruleCode)){
			//�ɹ�
			isFail = "0";
			//���ݿⱣ��
			uiMessageReceiveLogAction.save(sendDto, ruleCode);
		}
		return isFail;
	}
	
	/**Ⱥ������
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
			 * ���ں���ϵͳ�������ţ���������ȣ���������ȶ��ţ����ͳɹ�����0�����򷵻�1�����쳣
			 * �����������ػ�ִ����
			 * */
			if("0".equals(ruleCode)){
				rtnMap.put(sendDto.getAcceptor(), "0");
			}else if(this.checkRuleCode(ruleCode)){
				//�ɹ�
				rtnMap.put(sendDto.getAcceptor(), "0");
				//���ݿⱣ��
				uiMessageReceiveLogAction.save(sendDto, ruleCode);
			}else{
				rtnMap.put(sendDto.getAcceptor(), "1");
			}
		}
		return rtnMap;
	}
	/**���Ͷ���
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
	 * URL��ʽ���Ͷ���
	 * */
	private String sendURL(MessageSendDto sendDto) throws Exception{
		String isFail = "1";
		//תΪ����Map
		MessageHandler handler = new MessageHandler();
		Map paramMap = handler.convertObject2Map(sendDto);
		//���͸������
		String urlPath = AppConfig.get("sysconst.SMS_ENDPOINT_URL");
		UIMessageReceiveLogAction uiMessageReceiveLogAction = new UIMessageReceiveLogAction();
		URLInterface service = new URLInterface(urlPath);
		String ruleCode = service.send(paramMap);
		//���ݱ���
		if("OK".equals(ruleCode)){
			isFail = "0";//�ɹ�
		}else if(this.checkRuleCode(ruleCode)){
			isFail = "0";//�ɹ�
			//���ݿⱣ��
			uiMessageReceiveLogAction.save(sendDto, ruleCode);
		}
		return isFail;
	}
	/**
	 * ���Ͷ���
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
	 * URL��ʽȺ������
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
				//�ɹ�
				rtnMap.put(sendDto.getAcceptor(), "0");
				//���ݿⱣ��
				uiMessageReceiveLogAction.save(sendDto, ruleCode);
			}else{
				rtnMap.put(sendDto.getAcceptor(), "1");
			}
		}
		return rtnMap;
	}
	
	/**У��������
	 * ������������ ǰ��λ01-99������λa1-z9�����ͳɹ���������ʧ��
	 * */
	private boolean checkRuleCode(String ruleCode){
		if(ruleCode.matches("^\\d{1}[1-9]{1}[a-z]{1}\\d{1}$")){
			return true;
		}else{
			return false;
		}
	}
	/**���Ž���*/
	public String receive(String respXml){
		String isSuccess = "0";
		try{
			System.err.println(respXml);
			//תΪ����
			MessageHandler handler = new MessageHandler();
			MessageReceiveDto receiveDto = handler.convertXml2Object(respXml);
			//���ݸ���
			UIMessageReceiveLogAction uiMessageReceiveLogAction = new UIMessageReceiveLogAction();
			boolean successFlag = uiMessageReceiveLogAction.update(receiveDto);
			//���سɹ���־
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
