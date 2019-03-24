package com.sinosoft.webservice.newpayment.cli;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.webservice.newpayment.autogr.SavePayInforServiceImpl;
import com.sinosoft.webservice.newpayment.autogr.SavePayInforServiceImplServiceLocator;

public class SavePaymentInfoUtil {
	public static String savePaymentInfo(String xml) throws MalformedURLException, ServiceException, RemoteException{
		SavePayInforServiceImplServiceLocator locator = new SavePayInforServiceImplServiceLocator();
		SavePayInforServiceImpl service = locator.getSavePaymentInfo(new URL(AppConfig.get("sysconst.GY_NEWPAYMENT_URL")));
		
		String returnxml = service.savePayInfor(xml);
		
		return returnxml;
	}

}
