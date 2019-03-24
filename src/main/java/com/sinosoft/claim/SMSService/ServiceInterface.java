package com.sinosoft.claim.SMSService;

import java.rmi.RemoteException;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

/**此服务接口对于参数，目前只是设置为字符串，对于入参是对象情况没有考虑，需要改进*/
public class ServiceInterface {
	private Call call = null;
	private String endpoint = "";
	private String methodName = "";
	private final String SERVICE_NAMESPACE = "http://ws.apache.org/axis2";
	
	public ServiceInterface(String wsdlPath,String methodName){
		this.endpoint = wsdlPath;
		this.methodName = methodName;
		init();
	}
	
	/**初始化方法*/
	private void init(){
		try{
			Service service = new Service();
	        this.call = (Call) service.createCall();
	        this.call.setOperationName(new QName(this.SERVICE_NAMESPACE,this.methodName));
	        this.call.setTargetEndpointAddress(new java.net.URL(this.endpoint));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**发送报文*/
	public String send(String reqXml) throws RemoteException{
		String resp = "";
		resp = (String) call.invoke(new Object[]{reqXml});
		return resp;
	}
	
}
