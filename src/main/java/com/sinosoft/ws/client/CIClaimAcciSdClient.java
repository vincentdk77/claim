package com.sinosoft.ws.client;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.ws.ciclaimpropservice.CIClaimAcciSdService;

public class CIClaimAcciSdClient {

	private static Logger logger = Logger.getLogger(CIClaimAcciSdClient.class);
	private static CIClaimAcciSdService service;

	public static void init() {
		Service srvcModel = new ObjectServiceFactory().create(CIClaimAcciSdService.class);
		XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());
		try {
			service = (CIClaimAcciSdService) factory.create(srvcModel,AppConfig.get("sysconst.ServiceClient")+"CIClaimAcciSdService");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			logger.error(e);
		}
	}

	/**
	 * 获取一个WebService接口的实例.
	 * 
	 * @return ISelfQueryService
	 */
	public static CIClaimAcciSdService getInstance() {
		if (service == null)
			init();
		return service;
	}


}
