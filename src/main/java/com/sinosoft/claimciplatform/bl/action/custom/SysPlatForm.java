package com.sinosoft.claimciplatform.bl.action.custom;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.bz.log.BZLogger;
import com.sinosoft.claimciplatform.dto.custom.PlatFormParam;



public class SysPlatForm {
	private static Log logger = LogFactory.getLog(SysPlatForm.class);
	public static String request(String requestXML,PlatFormParam pfp) throws Exception {
        StringBuffer buffer = new StringBuffer();
        String strMessage = "";
        String strURL = "";
        InputStream inputStream = null;
        OutputStream outputStream = null;

        BufferedReader reader = null;
        OutputStreamWriter writer = null;
        URL url = null;
        HttpURLConnection connection = null;
        strURL = pfp.getUrl();
        try {

        	logger.debug("上传强制保险平台的URL是："+strURL);
            url = new URL(strURL);
            connection = (HttpURLConnection) url.openConnection();
            BZLogger.printData(requestXML);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setAllowUserInteraction(true);
            connection.connect();
            outputStream = connection.getOutputStream();
            writer = new OutputStreamWriter(outputStream);
            writer.write(requestXML);
            writer.flush();
            writer.close();
            inputStream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            while ((strMessage = reader.readLine()) != null) {
                buffer.append(strMessage);
            }
            BZLogger.printData(buffer.toString());
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return buffer.toString();
    }
}
