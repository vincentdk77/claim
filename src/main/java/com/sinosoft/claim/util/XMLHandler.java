package com.sinosoft.claim.util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.sinosoft.claim.dto.custom.AgriRegistDto;
import com.sinosoft.claim.dto.custom.AgriScheduleDto;


public class XMLHandler {

	/**
	 * 根据报案对象生成XML字符串 
	 * @param regist
	 * @param user
	 * @param password
	 * @return
	 */
	public static String getSaveAgriRegistDtoXML(AgriRegistDto agriRegistDto){
		Document document = null;
		document = getSaveAgriRegistDtoDocument(agriRegistDto);

		if(document!=null){
			document.setXMLEncoding("GBK");
			System.out.println("**********   老农险报案接口发送的 XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}
	

	private static Document getSaveAgriRegistDtoDocument(AgriRegistDto agriRegistDto){
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("Packet")
		.addAttribute("type", "request")
		.addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("head");
		Element bodyElement = packetElement.addElement("body");
		bodyElement.addElement("riskCode").setText(agriRegistDto.getRiskCode());
		bodyElement.addElement("policyNo").setText(agriRegistDto.getPolicyNo());
		bodyElement.addElement("damageStartDate").setText(agriRegistDto.getDamageStartDate());
		bodyElement.addElement("damageStartHour").setText(agriRegistDto.getDamageStartHour()+":"+agriRegistDto.getDamageStartMinute()+":00");
		bodyElement.addElement("damageCode").setText(agriRegistDto.getDamageCode());
		bodyElement.addElement("damageName").setText(agriRegistDto.getDamageName());
		if(agriRegistDto.getDamageMessage()!=null && agriRegistDto.getDamageMessage().length>0){
			String message = "[";
			for(int i=0;i<agriRegistDto.getDamageMessage().length;i++){
				message += agriRegistDto.getDamageMessage()[i]+",";
			}
			message = message.substring(0, message.length()-1) +"]";
			bodyElement.addElement("damageMessage").setText(message);
		}
		if(agriRegistDto.getReportorName()!=null && !"".equals(agriRegistDto.getReportorName())){
			bodyElement.addElement("reportorName").setText(agriRegistDto.getReportorName());
		}
		bodyElement.addElement("reportDate").setText(agriRegistDto.getReportDate());
		bodyElement.addElement("reportHour").setText(agriRegistDto.getReportHour());
		bodyElement.addElement("reportType").setText(agriRegistDto.getReportType());
		bodyElement.addElement("linkerName").setText(agriRegistDto.getLinkerName());
		bodyElement.addElement("phoneNumber").setText(agriRegistDto.getPhoneNumber());
		bodyElement.addElement("lossesNumber").setText(agriRegistDto.getLossesNumber());
		if(agriRegistDto.getAddressCode()!=null && !"".equals(agriRegistDto.getAddressCode())){
			bodyElement.addElement("addressCode").setText(agriRegistDto.getAddressCode());
		}
		bodyElement.addElement("damageAddress").setText(agriRegistDto.getDamageAddress());
		bodyElement.addElement("estiCurrency").setText(agriRegistDto.getEstiCurrency());
		bodyElement.addElement("estimateLoss").setText(agriRegistDto.getEstimateLoss());
		bodyElement.addElement("lossName").setText(agriRegistDto.getLossName());
		
		if(agriRegistDto.getAcciPersonDtoList()!=null && agriRegistDto.getAcciPersonDtoList().length>0){
			Element acciPersonDtoListElement = bodyElement.addElement("acciPersonDtoList");
			for(int i=0;i<agriRegistDto.getAcciPersonDtoList().length;i++){
				acciPersonDtoListElement.addElement("serialNo").setText(agriRegistDto.getAcciPersonDtoList()[i].getSerialNo());
				acciPersonDtoListElement.addElement("familyNo").setText(agriRegistDto.getAcciPersonDtoList()[i].getFamilyNo());
				acciPersonDtoListElement.addElement("acciCode").setText(agriRegistDto.getAcciPersonDtoList()[i].getAcciCode());
				acciPersonDtoListElement.addElement("acciName").setText(agriRegistDto.getAcciPersonDtoList()[i].getAcciName());
				acciPersonDtoListElement.addElement("sex").setText(agriRegistDto.getAcciPersonDtoList()[i].getSex());
				acciPersonDtoListElement.addElement("age").setText(agriRegistDto.getAcciPersonDtoList()[i].getAge());
				acciPersonDtoListElement.addElement("identifyNumber").setText(agriRegistDto.getAcciPersonDtoList()[i].getIdentifyNumber());
			}
		}
		
		bodyElement.addElement("operatorCode").setText(agriRegistDto.getOperatorCode());
		bodyElement.addElement("operatorName").setText(agriRegistDto.getOperatorName());
		bodyElement.addElement("makeCom").setText(agriRegistDto.getMakeCom());
		bodyElement.addElement("makeComName").setText(agriRegistDto.getMakeComName());
		if(agriRegistDto.getEarNoDtoList()!=null && agriRegistDto.getEarNoDtoList().length>0){
			String earNoListMessage = "[";
			for(int i=0;i<agriRegistDto.getEarNoDtoList().length;i++){
				earNoListMessage += agriRegistDto.getEarNoDtoList()[i].getEarNo()+",";
			}
			earNoListMessage = earNoListMessage.substring(0, earNoListMessage.length()-1) +"]";
			bodyElement.addElement("earNoList").setText(earNoListMessage);
		}
		if(agriRegistDto.getRemark()!=null && !"".equals(agriRegistDto.getRemark())){
			bodyElement.addElement("Remark").setText(agriRegistDto.getRemark());
		}
		bodyElement.addElement("textContext").setText(agriRegistDto.getTextContext());
		if(agriRegistDto.getCatastropheCode1()!=null && !"".equals(agriRegistDto.getCatastropheCode1())){
			bodyElement.addElement("catastropheCode1").setText(agriRegistDto.getCatastropheCode1());
		}
		if(agriRegistDto.getCatastropheName1()!=null && !"".equals(agriRegistDto.getCatastropheName1())){
			bodyElement.addElement("catastropheName1").setText(agriRegistDto.getCatastropheName1());
		}
		if(agriRegistDto.getCatastropheCode2()!=null && !"".equals(agriRegistDto.getCatastropheCode2())){
			bodyElement.addElement("catastropheCode2").setText(agriRegistDto.getCatastropheCode2());
		}
		if(agriRegistDto.getCatastropheName2()!=null && !"".equals(agriRegistDto.getCatastropheName2())){
			bodyElement.addElement("catastropheName2").setText(agriRegistDto.getCatastropheName2());
		}
		return document;
	}
	public static String getSaveAgriScheduleDtoXML(AgriScheduleDto agriScheduleDto){
		Document document = null;
		document = getSaveAgriScheduleDtoDocument(agriScheduleDto);
		
		if(document!=null){
			document.setXMLEncoding("GBK");
			System.out.println("**********   老农险调度接口发送的 XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}
	
	
	private static Document getSaveAgriScheduleDtoDocument(AgriScheduleDto agriScheduleDto){
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("Packet")
				.addAttribute("type", "request")
				.addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("head");
		Element bodyElement = packetElement.addElement("body");
		bodyElement.addElement("registNo").setText(agriScheduleDto.getRegistNo());
		bodyElement.addElement("riskCode").setText(agriScheduleDto.getRiskCode());
		bodyElement.addElement("scheduleObjectID").setText(agriScheduleDto.getScheduleObjectID());
		bodyElement.addElement("scheduleObjectName").setText(agriScheduleDto.getScheduleObjectName());
		bodyElement.addElement("checkSite").setText(agriScheduleDto.getCheckSite());
		if(agriScheduleDto.getCheckInfo() !=null && !"".equals(agriScheduleDto.getCheckInfo())){
			bodyElement.addElement("checkInfo").setText(agriScheduleDto.getCheckInfo());
		}
		if(agriScheduleDto.getNextHandlerCode1() !=null && !"".equals(agriScheduleDto.getNextHandlerCode1())){
			bodyElement.addElement("nextHandlerCode1").setData(agriScheduleDto.getNextHandlerCode1());
		}
		if(agriScheduleDto.getNextHandlerName1() !=null && !"".equals(agriScheduleDto.getNextHandlerName1())){
			bodyElement.addElement("nextHandlerName1").setText(agriScheduleDto.getNextHandlerName1());
		}
		bodyElement.addElement("ItemScheduleObjectID").setText(agriScheduleDto.getItemScheduleObjectID());
		bodyElement.addElement("ItemScheduleObjectName").setText(agriScheduleDto.getItemScheduleObjectName());
		bodyElement.addElement("ItemCheckSit").setText(agriScheduleDto.getItemCheckSit());
		if(agriScheduleDto.getRepairFactoryName() !=null && !"".equals(agriScheduleDto.getRepairFactoryName())){
			bodyElement.addElement("repairFactoryName").setText(agriScheduleDto.getRepairFactoryName());
		}
		if(agriScheduleDto.getFactoryEstimateLoss() !=null && !"".equals(agriScheduleDto.getFactoryEstimateLoss())){
			bodyElement.addElement("factoryEstimateLoss").setText(agriScheduleDto.getFactoryEstimateLoss());
		}
		if(agriScheduleDto.getFactoryPhone() !=null && !"".equals(agriScheduleDto.getFactoryPhone())){
			bodyElement.addElement("factoryPhone").setText(agriScheduleDto.getFactoryPhone());
		}
		
		bodyElement.addElement("exigenceGree").setText(agriScheduleDto.getExigenceGree());
		
		if(agriScheduleDto.getResultInfo() !=null && !"".equals(agriScheduleDto.getResultInfo())){
			bodyElement.addElement("resultInfo").setText(agriScheduleDto.getResultInfo());
		}
		if(agriScheduleDto.getNextHandlerCode() !=null && !"".equals(agriScheduleDto.getNextHandlerCode())){
			bodyElement.addElement("nextHandlerCode").setText(agriScheduleDto.getNextHandlerCode());
		}
		if(agriScheduleDto.getNextHandlerName() !=null && !"".equals(agriScheduleDto.getNextHandlerName())){
			bodyElement.addElement("nextHandlerName").setText(agriScheduleDto.getNextHandlerName());
		}
		bodyElement.addElement("operatorCode").setText(agriScheduleDto.getOperatorCode());
		bodyElement.addElement("operatorName").setText(agriScheduleDto.getOperatorName());
		bodyElement.addElement("makeComCode").setText(agriScheduleDto.getMakeComCode());
		bodyElement.addElement("makeComName").setText(agriScheduleDto.getMakeComName());
		if(agriScheduleDto.getRegistExtDto() !=null && agriScheduleDto.getRegistExtDto().length>0){
			Element registExtElement = bodyElement.addElement("registExtDto");
			for(int i=0;i<agriScheduleDto.getRegistExtDto().length;i++){
				registExtElement.addElement("serialNo").setText(agriScheduleDto.getRegistExtDto()[i].getSerialno());
				registExtElement.addElement("inputDate").setText(agriScheduleDto.getRegistExtDto()[i].getInputDate());
				registExtElement.addElement("inputHour").setText(agriScheduleDto.getRegistExtDto()[i].getInputHour());
				registExtElement.addElement("operatorCode").setText(agriScheduleDto.getRegistExtDto()[i].getOperatorCode());
				registExtElement.addElement("context").setText(agriScheduleDto.getRegistExtDto()[i].getContext());
			}
		}
		return document;
	}

}
