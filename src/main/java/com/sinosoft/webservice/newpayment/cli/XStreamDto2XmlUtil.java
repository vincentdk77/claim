package com.sinosoft.webservice.newpayment.cli;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
/**
 * 
 * @description ��Dtoת����xml��xmlת��Dto��
 * @author Administrator
 * @date 2016��11��29������9:45:12
 */
public class XStreamDto2XmlUtil{
	/**
	 * 
	 * @description ��Dtoת����xml��
	 * @param obj
	 * @return
	 * @author Administrator
	 * @date 2016��11��29������10:24:18
	 */
	public String Dto2Xml(Object obj){
		String xml="";
		XStream xs = new XStream(new DomDriver());
		xs.alias("Packet", obj.getClass());
		xs.processAnnotations(obj.getClass());
		xml=xs.toXML(obj);
		return xml;
	}
	/**
	 * 
	 * @description ��xmlת��Dto��
	 * @param obj
	 * @param xml
	 * @return
	 * @author Administrator
	 * @date 2016��11��29������10:24:33
	 */
	public Object Xml2Dto(Object obj,String xml){
		XStream xs = new XStream(new DomDriver());
		xs.alias("Packet", obj.getClass());
		xs.processAnnotations(obj.getClass());
		obj=xs.fromXML(xml);
		return obj;
	}
	
}
