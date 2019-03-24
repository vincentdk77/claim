package com.sinosoft.claim.ui.control.facade;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Element;

import com.sinosoft.claim.util.OperXML;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.utility.string.Str;

/**
 * <p>Title: ���� �����ϵͳ�ͻ���</p>
 * <p>Description:����������� </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: sinosoft ������Ŀ��</p>
 * @author sunchenggang
 * @version 1.0
 */
public class UIClaimFittingsClientFacade {
	private static Log logger = LogFactory.getLog(UIClaimFittingsClientFacade.class);

	/**
	 * �������ݸ����ϵͳ
	 * @param xmlData String
	 * @throws Exception
	 * @return boolean
	 */
	public String sendData(String xmlData) throws Exception {
		String SERVER_URL = AppConfig.get("sysconst.FITTINGS_URL");
		//��������
		URL uploadServlet = new URL(SERVER_URL);
		URLConnection servletConnection = uploadServlet.openConnection();
		logger.debug("�������ϵͳURL:" + servletConnection.getURL());
		//�������Ӳ���
		servletConnection.setUseCaches(false);
		servletConnection.setDoOutput(true);
		servletConnection.setDoInput(true);
		//��������д��XML����
		BufferedOutputStream output = new BufferedOutputStream(servletConnection.getOutputStream());
		output.write(xmlData.getBytes());
		output.close();
		
		try {
			//���շ��ز���
			DataInputStream input = null;
			input = new DataInputStream(servletConnection.getInputStream());
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			byte[] data = null;
			byte[] b = new byte[1024];
			int read = 0;
			while ((read = input.read(b)) > 0) {
				byteOut.write(b, 0, read);
			}
			data = byteOut.toByteArray();
			String dataString = new String(data);
			logger.debug("����dataString___:" + dataString);
			logger.debug("����icode___:" + input.read(b));
			input.close();			
			int index = dataString.indexOf("<RESPONSE_CODE>");
			int lastIndex = dataString.lastIndexOf("</RESPONSE_CODE>");
			String returnCode = dataString.substring(index+15, lastIndex);
			index = dataString.indexOf("<URL>");
			lastIndex = dataString.lastIndexOf("</URL>");
			String returnURL = dataString.substring(index+5, lastIndex);
			dataString = returnCode + returnURL;
			return dataString;
			
		} catch (Exception e) {
			logger.debug("�����Ѿ����ͣ���û�з��ؽ����");
			e.printStackTrace();
			throw e;
		}
	}


	public String sendXMLData(String kindCode, String kindName, String lossNo,
			String estimateNo, String caseNo, String plateNo, String markColor,
			String plateColor, String engineNo, String frameNo,
			String insureVehicleName, String insureVehicleCode, String comCode,
			String company, String handlerCode, String handlerName, String manHour) throws Exception{
		
		String xmlData = "<?xml version=\"1.0\" encoding=\"GBK\"?>";
		xmlData += "<LossReqRequestData>";
		xmlData += "<LossReqHead>";
		xmlData += "<UserCode>jy</UserCode>";
		xmlData += "<Password>jy</Password>";
		xmlData += "<RequestType>001</RequestType>";
		xmlData += "<Power>111111111</Power>";
		xmlData += "<ReturnURL>"+AppConfig.get("sysconst.FITTINGS_LOCAL_URL")+"</ReturnURL>";
		xmlData += "<RefreshURL>"+AppConfig.get("sysconst.FITTINGS_FLASH_URL")+"</RefreshURL>";
		xmlData += "</LossReqHead>";
		xmlData += "<LossInsureItem>";
		xmlData += "<Item>";
		xmlData += "<InsureTerm>"+kindName+"</InsureTerm>";
		xmlData += "<InsureTermCode>"+kindCode+"</InsureTermCode>";
		xmlData += "</Item>";
		xmlData += "</LossInsureItem>";
		xmlData += "<LossReqBody>";
		xmlData += "<LossNo>"+lossNo+"</LossNo>";
		xmlData += "<EstimateNo>"+estimateNo+"</EstimateNo>";
		xmlData += "<CaseNo>"+caseNo+"</CaseNo>";
		xmlData += "<PlateNo>"+plateNo+"</PlateNo>";
		xmlData += "<MarkColor>"+markColor+"</MarkColor>";
		xmlData += "<PlateColor>"+plateColor+"</PlateColor>";
		xmlData += "<EngineNo>"+engineNo+"</EngineNo>";
		xmlData += "<FrameNo>"+frameNo+"</FrameNo>";
		xmlData += "<InsureVehicleName>"+insureVehicleName+"</InsureVehicleName>";
		xmlData += "<InsureVehicleCode>"+insureVehicleCode+"</InsureVehicleCode>";
		xmlData += "<ComCode>"+comCode+"</ComCode>";
		xmlData += "<Company>"+company+"</Company>";
		xmlData += "<HandlerCode>"+handlerCode+"</HandlerCode>";
		xmlData += "<HandlerName>"+handlerName+"</HandlerName>";
		xmlData += "<ManHour>"+manHour+"</ManHour>";
		xmlData += "</LossReqBody>";
		xmlData += "</LossReqRequestData>";

		logger.debug("׼���õ�XML:" + xmlData);
		String flag = ""; //���ص��Ǵ����־
		flag = this.sendData(xmlData);
		return flag;
	}

}
