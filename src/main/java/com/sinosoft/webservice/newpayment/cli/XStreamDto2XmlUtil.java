package com.sinosoft.webservice.newpayment.cli;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
/**
 * 
 * @description （Dto转换成xml、xml转成Dto）
 * @author Administrator
 * @date 2016年11月29日上午9:45:12
 */
public class XStreamDto2XmlUtil{
	/**
	 * 
	 * @description （Dto转换成xml）
	 * @param obj
	 * @return
	 * @author Administrator
	 * @date 2016年11月29日下午10:24:18
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
	 * @description （xml转成Dto）
	 * @param obj
	 * @param xml
	 * @return
	 * @author Administrator
	 * @date 2016年11月29日下午10:24:33
	 */
	public Object Xml2Dto(Object obj,String xml){
		XStream xs = new XStream(new DomDriver());
		xs.alias("Packet", obj.getClass());
		xs.processAnnotations(obj.getClass());
		obj=xs.fromXML(xml);
		return obj;
	}
	
}
