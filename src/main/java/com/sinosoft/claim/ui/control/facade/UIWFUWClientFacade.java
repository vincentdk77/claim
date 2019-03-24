package com.sinosoft.claim.ui.control.facade  ;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.net.URL;
import java.net.URLConnection;

import com.sinosoft.sysframework.reference.AppConfig;

/**
 * <p>Title: 理赔 －双核工作流客户端</p>
 * <p>Description:发送双核工作流数据（目前只有提交核赔一个方法） </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: sinosoft 理赔响目组</p>
 * @author 李香
 * @version 1.0
 */
public class UIWFUWClientFacade
{
	public UIWFUWClientFacade()
	{
	}

	/**
	 * 发送数据给双核工作流
	 * @param xmlData String
	 * @throws Exception
	 * @return boolean
	 */
	public String sendData(String xmlData) throws Exception
	{
		String SERVER_URL = AppConfig.get("sysconst.UW_URL");
		//开启连接
		URL uploadServlet = new URL(SERVER_URL);
		URLConnection servletConnection = uploadServlet.openConnection();
		System.out.println("请求理赔URL::::::" + servletConnection.getURL());
		//设置连接参数
		servletConnection.setUseCaches(false);
		servletConnection.setDoOutput(true);
		servletConnection.setDoInput(true);
		//开启流，写入XML数据
		BufferedOutputStream output = new BufferedOutputStream(servletConnection.getOutputStream());
		output.write(xmlData.getBytes());
		output.close();

		try
		{
			//接收返回参数
			DataInputStream input = null;
			input = new DataInputStream(servletConnection.getInputStream());
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			byte[] data = null;
			byte[] b = new byte[1024];
			int read = 0;
			while ( (read = input.read(b)) > 0)
			{
				byteOut.write(b, 0, read);
			}
			data = byteOut.toByteArray();
			String dataString = new String(data);
			input.close();
			return dataString;
		}
		catch (Exception e)
		{
			System.out.println("数据已经发送， 但没有返回结果！");
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 组织XML数据
	 * @param interMethod String
	 * @param LflowID String
	 * @param LlogNo String
	 * @param businessNo String
	 * @param notionInfo String
	 * @param handlerCode String
	 * @throws Exception
	 * @return String
	 */
	public String sendXMLData(String LflowID, String LlogNo, String modelType,
                    String certiType, String businessNo, String riskCode,
		    String classCode, String comCode, String handlerCode,
	            String makecom,String userCode,String handler1Code,
                    String contractNo) throws Exception {
        String interMethod="start";
        String xmlData = "<?xml version=\"1.0\" encoding=\"gb2312\" standalone=\"yes\" ?>";
                xmlData += "<ClaimData>";
                xmlData += "<Interface>" + interMethod + "</Interface>";
                //组织数据
                xmlData += "<" + interMethod + ">";
                xmlData += "<LflowID>" + LflowID + "</LflowID>";
                xmlData += "<LlogNo>" + LlogNo + "</LlogNo>";
                xmlData += "<modelType>" + modelType + "</modelType>";
                xmlData += "<certiType>" + certiType + "</certiType>";
                xmlData += "<businessNo>" + businessNo + "</businessNo>";
                xmlData += "<riskCode>" + riskCode + "</riskCode>";
                xmlData += "<classCode>" + classCode + "</classCode>";
                xmlData += "<comCode>" + comCode + "</comCode>";
                xmlData += "<makecom>" + makecom + "</makecom>";
                xmlData += "<userCode>" + userCode + "</userCode>";
                xmlData += "<handlerCode>" + handlerCode + "</handlerCode>";
                xmlData += "<handler1Code>" + handler1Code + "</handler1Code>";
                xmlData += "<contractNo>" +contractNo + "</contractNo>";
                xmlData += "<flag>" +"claim" + "</flag>";
                xmlData += "</" + interMethod + ">";
                xmlData += "</ClaimData>";

    System.out.println("准备好的XML::::" + xmlData);
    String flag = ""; //返回的是字符uwflowid
    try
    {
      flag = this.sendData(xmlData);
    }
    catch (Exception e)
    {
      //发送错误标志

    }
    return flag;
  }

}
