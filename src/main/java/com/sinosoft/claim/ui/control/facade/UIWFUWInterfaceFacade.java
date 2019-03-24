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
 * <p>Title: ˫�� �����⹤�����ӿ�</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: sinosoft ������Ŀ��</p>
 * @author ³��
 * @version 1.0
 */

public class UIWFUWInterfaceFacade extends HttpServlet
{
        //Initialize global variables
        String iBody = ""; //������������
        String SERVER_URL = "http://192.168.62.12:7001/claim/WFUWInterface"; //���⹤������ַ
        public void init() throws ServletException
        {
        }

        /**
         * Process the HTTP Get request�����п��Ʒ������������XML������������д���ݷ�����
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
                        System.out.println("���������ύ��������!");
                        //��ȡ���ն���
                        input = new DataInputStream(request.getInputStream());
                        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
                        byte[] data = null;
                        byte[] b = new byte[1024];
                        int read = 0;
                        //ת��������
                        while ( (read = input.read(b)) > 0)
                        {
                                byteOut.write(b, 0, read);
                        }
                        data = byteOut.toByteArray();
                        //�������
                        input.close();
                        String strData = new String(data);
                        System.out.println("\n----------����������ϣ�����-------------\n ");
                        //��������
                        this.doTransData(response, strData);
                        //����ɹ���ʶ
                        output = new BufferedOutputStream(response.getOutputStream());
                        strReturn =
                                        "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?><Result><TransType>ҵ������</TransType><Flag>true</Flag><Error></Error></Result>";
                        output.write(strReturn.getBytes());
                        output.close();
                }
                catch (Exception e)
                {
                        output = new BufferedOutputStream(response.getOutputStream());
                        strReturn = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?><Result><TransType>ҵ������</TransType><Flag>false</Flag><Error>"
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
                System.out.println("��ʼ�����������ͣ�");
                BufferedOutputStream output = null;
                String strReturn = "";
                try
                {
                        operXML.parserFromXMLString(iData);
                        Element eType = operXML.getElement("Integerface");
                        iBody = eType.getValue();
                        System.out.println("ClaimData��������������������" + iBody);

                        if (iBody.equals("start"))
                        {
                                //��addInformationOnVeric ���½ڵ����ݣ��������ݵ���������
                                //����������ݷ������Բο�doSaveReins����
                                System.out.println("��ʼ�����ٱ����ݣ�");
                                List KeyList = operXML.getChildrenElement(iData, iBody);
                                Element item = null;
                                System.out.println("ҵ������size____:" + KeyList.size());
                                if (KeyList.size() < 1)
                                {
                                        throw new Exception("�������Ͳ�ƥ�䣡");
                                }
                                for (i = 0; i < KeyList.size(); i++)
                                {
                                        item = (Element) KeyList.get(i);
                                        //operXML.getKeyValue( item, "SettleNo" ) + "'" + "," +
                                }
                        }
                        else
                        {
                                throw new Exception("����ȷ��ҵ���������ݣ�����ϵͳ����Ա��ϵ��");
                        }
                }
                catch (SQLException exception)
                {
                        output = new BufferedOutputStream(response.getOutputStream());
                        strReturn = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?><Result><TransType>ҵ������</TransType><Flag>false</Flag><Error>"
                                        + exception.toString() + "</Error></Result>";
                        output.write(strReturn.getBytes());
                        output.close();
                        throw exception;
                }
                catch (Exception ex)
                {
                        ex.printStackTrace();
                        output = new BufferedOutputStream(response.getOutputStream());
                        strReturn = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?><Result><TransType>ҵ������</TransType><Flag>false</Flag><Error>"
                                        + ex.toString() + "</Error></Result>";
                        output.write(strReturn.getBytes());
                        output.close();
                }
                finally
                {

                }
        }

        /**
         * �������ݸ����⹤����
         * @param LflowID String  ���⹤������
         * @param LlogNo String  ���⹤�������
         * @param notion String  �������
         * @param handlerCode String  ����ʱ����˴���
         * @throws Exception
         * @return String
         */
        public String sendData(String interMethod, String LflowID, String LlogNo, String businessNo, String notionInfo,
                                                                                                 String handlerCode) throws Exception
        {
                String xmlData = "<?xml version=\"1.0\" encoding=\"gb2312\" standalone=\"yes\" ?>";
                xmlData += "<ClaimData>";
                xmlData += "<Integerface>" + interMethod + "</Integerface>";
                //��֯����
                xmlData += "<" + interMethod + ">";
                xmlData += "<LflowID>" + LflowID + "</LflowID>";
                xmlData += "<LlogNo>" + LlogNo + "</LlogNo>";
                xmlData += "<businessNo>" + businessNo + "</businessNo>";
                xmlData += "<notionInfo>" + notionInfo + "</notionInfo>";
                xmlData += "<handlerCode>" + handlerCode + "</LflowID>";
                xmlData += "</" + interMethod + ">";
                xmlData += "</ClaimData>";
                System.out.println("׼���õ�XML::::" + xmlData);

                //��������
                URL uploadServlet = new URL(SERVER_URL);
                URLConnection servletConnection = uploadServlet.openConnection();
                System.out.println("��������URL::::::" + servletConnection.getURL());
                //�������Ӳ���
                servletConnection.setUseCaches(false);
                servletConnection.setDoOutput(true);
                servletConnection.setDoInput(true);
                //��������д��XML����
                BufferedOutputStream output = new BufferedOutputStream(servletConnection.getOutputStream());
                output.write(xmlData.getBytes());
                output.close();

                try
                {
                        //���շ��ز���
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
                        System.out.println("�����Ѿ����ͣ� ��û�з��ؽ����");
                        e.printStackTrace();
                }

                return "";
        }

}
