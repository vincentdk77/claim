package com.sinosoft.webservice.newpayment.autogr;

import com.sinosoft.webservice.newpayment.cli.XStreamDto2XmlUtil;
import com.sinosoft.webservice.newpayment.req.PrpqBaseDto;

public class SavePayMainInfo {
	
	public String savePayMainInfo(PrpqBaseDto prpqBaseDto){
		
		//·µ»ØµÄString
		String returnXml="";
		XStreamDto2XmlUtil util=new XStreamDto2XmlUtil();
		returnXml=util.Dto2Xml(prpqBaseDto);
		return returnXml;
	}
}
