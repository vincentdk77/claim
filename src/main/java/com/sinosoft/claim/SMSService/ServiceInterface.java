package com.sinosoft.claim.SMSService;

import java.rmi.RemoteException;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

/**�˷���ӿڶ��ڲ�����Ŀǰֻ������Ϊ�ַ�������������Ƕ������û�п��ǣ���Ҫ�Ľ�*/
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
	
	/**��ʼ������*/
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
	/**���ͱ���*/
	public String send(String reqXml) throws RemoteException{
		String resp = "";
		resp = (String) call.invoke(new Object[]{reqXml});
		return resp;
	}
	
}
