package com.sinosoft.claim.SMSService.feedback;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import com.sinosoft.claim.SMSService.feedback.custom.MessageReceiveDto;
import com.sinosoft.claim.SMSService.feedback.custom.MessageSendDto;

/**
 * 短信处理：回执短信处理，短信发送（带有回执标志）
 * */
public class MessageHandler {
	/**
	 * 对象转为报文--发送
	 * */
	public String convertObject2Xml(MessageSendDto sendDto) {
		String rtnXml = "";
		if(sendDto == null){
			return rtnXml;
		}
		rtnXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> "
			+ "<SendSMSReq>                             "
			+ "	<BODY>                                  "
			+ "		<MobilePhones>"+sendDto.getMobilePhones()+"</MobilePhones>       "
			+ "		<Content>"+sendDto.getContent()+"</Content>                 "
			+ "		<Priority>"+sendDto.getPriority()+"</Priority>               "
			+ "		<ModuleCode>"+sendDto.getModuleCode()+"</ModuleCode>           "
			+ "		<Receive>"+sendDto.getReceive()+"</Receive>                 "
			+ "		<BusinessNo1>"+sendDto.getBusinessNo1()+"</BusinessNo1>         "
			+ "		<BusinessNo2>"+sendDto.getBusinessNo2()+"</BusinessNo2>         "
			+ "		<BusinessNo3>"+sendDto.getBusinessNo3()+"</BusinessNo3>         "
			+ "		<BusinessNo4>"+sendDto.getBusinessNo4()+"</BusinessNo4>         "
			+ "		<BusinessNo5>"+sendDto.getBusinessNo5()+"</BusinessNo5>         "
			+ "	</BODY>                                 "
			+ "</SendSMSReq>                            ";
		return rtnXml;
	}

	public MessageReceiveDto convertXml2Object(String xml) {
		MessageReceiveDto receiveDto = null;
		try{
			Document document = DocumentHelper.parseText(xml);
			Element root = document.getRootElement();
			Iterator it=root.elementIterator("BODY");
			if(it.hasNext()){
				Element body=(Element)it.next();
				receiveDto = new MessageReceiveDto();
				receiveDto.setRuleCode(parseNode(body.selectSingleNode("RuleCode")));
				receiveDto.setMobilePhones(parseNode(body.selectSingleNode("MobilePhones")));
				receiveDto.setContent(parseNode(body.selectSingleNode("Content")));
				receiveDto.setReceiveTime(parseNode(body.selectSingleNode("ReceiveTime")));
				receiveDto.setBusinessNo1(parseNode(body.selectSingleNode("BusinessNo1")));
				receiveDto.setBusinessNo2(parseNode(body.selectSingleNode("BusinessNo2")));
				receiveDto.setBusinessNo3(parseNode(body.selectSingleNode("BusinessNo3")));
				receiveDto.setBusinessNo4(parseNode(body.selectSingleNode("BusinessNo4")));
				receiveDto.setBusinessNo5(parseNode(body.selectSingleNode("BusinessNo5")));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return receiveDto;
	}
	private static String parseNode(Node node){
		if (node==null)
		{
			return null;
		}
		return node.getText();
	}
	/**转为参数Map集合，用于URL发送信息*/
	public Map convertObject2Map(MessageSendDto sendDto) {
		Map param = new HashMap();
		param.put("MobilePhones", sendDto.getMobilePhones());
		param.put("Content", URLEncoder.encode(sendDto.getContent()));
		param.put("Priority", sendDto.getPriority());
		param.put("ModuleCode", sendDto.getModuleCode());
		param.put("Receive", sendDto.getReceive());
		param.put("BusinessNo1", sendDto.getBusinessNo1());
		param.put("BusinessNo2", sendDto.getBusinessNo2());
		param.put("BusinessNo3", sendDto.getBusinessNo3());
		param.put("BusinessNo4", sendDto.getBusinessNo4());
		param.put("BusinessNo5", sendDto.getBusinessNo5());
		return param;
	}
	
}
