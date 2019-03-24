package com.sinosoft.claim.ui.control.facade ;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.Element;

import com.sinosoft.claim.util.OperXML;


/**
 * <p>Title: 双核 －理赔工作流接口</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: sinosoft 阳光项目组</p>
 * @author 鲁阳
 * @version 1.0
 */

public class UIWFUWInterfaceFacade extends HttpServlet
{
        //Initialize global variables
        String iBody = ""; //接收数据类型
        String SERVER_URL = "http://192.168.62.12:7001/claim/WFUWInterface"; //理赔工作流地址
        public void init() throws ServletException
        {
        }

        /**
         * Process the HTTP Get request，集中控制方法，负责调用XML解析方法、回写数据方法等
         * @param request HttpServletRequest
         * @param response HttpServletResponse
         * @throws ServletException
         * @throws IOException
         */
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws
                        ServletException, IOException
        {
                String strReturn = "";
                DataInputStream input = null;
                BufferedOutputStream output = null;
                try
                {
                        System.out.println("接收理赔提交核赔请求!");
                        //获取接收对象
                        input = new DataInputStream(request.getInputStream());
                        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
                        byte[] data = null;
                        byte[] b = new byte[1024];
                        int read = 0;
                        //转换数据流
                        while ( (read = input.read(b)) > 0)
                        {
                                byteOut.write(b, 0, read);
                        }
                        data = byteOut.toByteArray();
                        //接收完毕
                        input.close();
                        String strData = new String(data);
                        System.out.println("\n----------接收数据完毕！！！-------------\n ");
                        //解析数据
                        this.doTransData(response, strData);
                        //输出成功标识
                        output = new BufferedOutputStream(response.getOutputStream());
                        strReturn =
                                        "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?><Result><TransType>业务类型</TransType><Flag>true</Flag><Error></Error></Result>";
                        output.write(strReturn.getBytes());
                        output.close();
                }
                catch (Exception e)
                {
                        output = new BufferedOutputStream(response.getOutputStream());
                        strReturn = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?><Result><TransType>业务类型</TransType><Flag>false</Flag><Error>"
                                        + e.toString() + "</Error></Result>";
                        output.write(strReturn.getBytes());
                        output.close();
                }
        }

        /**
         * Process the HTTP Post request
         * @param request HttpServletRequest
         * @param response HttpServletResponse
         * @throws ServletException
         * @throws IOException
         */
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws
                        ServletException, IOException
        {
                doGet(request, response);
        }

        /**
         * Clean up resources
         */
        public void destroy()
        {
        }

        /**
         * parse XML
         * @param response HttpServletResponse
         * @param iData String
         * @throws Exception
         */
        public void doTransData(HttpServletResponse response, String iData) throws
                        Exception
        {
                OperXML operXML = new OperXML();
                int i = 0;
                System.out.println("开始解析数据类型！");
                BufferedOutputStream output = null;
                String strReturn = "";
                try
                {
                        operXML.parserFromXMLString(iData);
                        Element eType = operXML.getElement("Integerface");
                        iBody = eType.getValue();
                        System.out.println("ClaimData：：：：：：：：：：" + iBody);

                        if (iBody.equals("start"))
                        {
                                //做addInformationOnVeric 更新节点内容，传送数据到后续方法
                                //具体解析数据方法可以参考doSaveReins方法
                                System.out.println("开始解析再保数据！");
                                List KeyList = operXML.getChildrenElement(iData, iBody);
                                Element item = null;
                                System.out.println("业务数据size____:" + KeyList.size());
                                if (KeyList.size() < 1)
                                {
                                        throw new Exception("数据类型不匹配！");
                                }
                                for (i = 0; i < KeyList.size(); i++)
                                {
                                        item = (Element) KeyList.get(i);
                                        //operXML.getKeyValue( item, "SettleNo" ) + "'" + "," +
                                }
                        }
                        else
                        {
                                throw new Exception("不明确的业务类型数据！请与系统管理员联系！");
                        }
                }
                catch (SQLException exception)
                {
                        output = new BufferedOutputStream(response.getOutputStream());
                        strReturn = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?><Result><TransType>业务类型</TransType><Flag>false</Flag><Error>"
                                        + exception.toString() + "</Error></Result>";
                        output.write(strReturn.getBytes());
                        output.close();
                        throw exception;
                }
                catch (Exception ex)
                {
                        ex.printStackTrace();
                        output = new BufferedOutputStream(response.getOutputStream());
                        strReturn = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?><Result><TransType>业务类型</TransType><Flag>false</Flag><Error>"
                                        + ex.toString() + "</Error></Result>";
                        output.write(strReturn.getBytes());
                        output.close();
                }
                finally
                {

                }
        }

        /**
         * 发送数据给理赔工作流
         * @param LflowID String  理赔工作流号
         * @param LlogNo String  理赔工作流序号
         * @param notion String  审批意见
         * @param handlerCode String  回退时审核人代码
         * @throws Exception
         * @return String
         */
        public String sendData(String interMethod, String LflowID, String LlogNo, String businessNo, String notionInfo,
                                                                                                 String handlerCode) throws Exception
        {
                String xmlData = "<?xml version=\"1.0\" encoding=\"gb2312\" standalone=\"yes\" ?>";
                xmlData += "<ClaimData>";
                xmlData += "<Integerface>" + interMethod + "</Integerface>";
                //组织数据
                xmlData += "<" + interMethod + ">";
                xmlData += "<LflowID>" + LflowID + "</LflowID>";
                xmlData += "<LlogNo>" + LlogNo + "</LlogNo>";
                xmlData += "<businessNo>" + businessNo + "</businessNo>";
                xmlData += "<notionInfo>" + notionInfo + "</notionInfo>";
                xmlData += "<handlerCode>" + handlerCode + "</LflowID>";
                xmlData += "</" + interMethod + ">";
                xmlData += "</ClaimData>";
                System.out.println("准备好的XML::::" + xmlData);

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
                        System.out.println("dataString___:" + dataString);
                        System.out.println("icode___:" + input.read(b));
                        input.close();
                }
                catch (Exception e)
                {
                        System.out.println("数据已经发送， 但没有返回结果！");
                        e.printStackTrace();
                }

                return "";
        }

}
