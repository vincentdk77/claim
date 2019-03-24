package com.sinosoft.claim.ui.control.facade;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.Element;

import com.sinosoft.claim.util.OperXML;
import com.sinosoft.utility.string.Str;

/**
 * <p>
 * Title: ����-˫�˹������ӿ�
 * </p>
 * <p>
 * Description:����˫�˹��������º���ڵ������
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: sinosoft ������Ŀ��
 * </p>
 *
 * @author ����
 * @version 1.0
 */

public class UIWFUWServerFacade extends HttpServlet {
    //Initialize global variables
    String iBody = ""; //������������
    public static String ADDVERIC = "addInformationOnVeric"; //˫��������ת�ж������еĺ���ڵ�����ݱ��
    public static String BACKVERIC = "backVericToCompp"; //����ڵ���˻أ��˻ص������飩
    public static String PASSVERIC = "passVeric"; //����ڵ��ͨ�����ֹ��᰸��
    public static String PASSCLOSEVERIC = "passVericAndCloseFlow"; //����ڵ��ͨ�����Զ��᰸��

    public void init() throws ServletException {
    }

    /**
     * Process the HTTP Get request�����п��Ʒ������������XML������������д���ݷ�����
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strReturn = "";
        DataInputStream input = null;
        BufferedOutputStream output = null;
        try {
            System.out.println("����˫���ύ�����Ĳ�������!");
            //��ȡ���ն���
            int flag = 0;
            input = new DataInputStream(request.getInputStream());
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            byte[] data = null;
            byte[] b = new byte[1024];
            int read = 0;
            //ת��������
            while ((read = input.read(b)) !=-1) {
                byteOut.write(b, 0, read);
            }
            data = byteOut.toByteArray();
            //�������
            input.close();
            String strData = new String(data);
            System.out.println("\n----------����������ϣ�����-------------\n ");
            //�������ݲ���Ӧ��Ӧ�ķ���
            flag = this.doTransData(request, response, strData);
            //����ɹ���ʶ
            output = new BufferedOutputStream(response.getOutputStream());
            strReturn = flag + "";
            System.out.println("\n---------���ݴ�����ϣ���ʼ�������ݣ�����-------------\n ");
            output.write(strReturn.getBytes());
            output.close();
            System.out.println("\n---------����������ϣ�����-------------\n ");
        } catch (Exception e) {
            e.printStackTrace();
            output = new BufferedOutputStream(response.getOutputStream());
            strReturn = "-999";
            output.write(strReturn.getBytes());
            output.close();
        }
    }

    /**
     * Process the HTTP Post request
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Clean up resources
     */
    public void destroy() {
    }

    /**
     * parse XML
     *
     * @param response HttpServletResponse
     * @param iData String
     * @throws Exception
     */
    public int doTransData(HttpServletRequest httpServletRequest, HttpServletResponse response, String iData)
            throws SQLException, Exception {
        OperXML operXML = new OperXML();
        System.out.println("��ʼ�����������ͣ�");
        String LflowID = "";
        int lLogNo = 0;
        String businessNo = "";
        String notionInfo = "";
        String handlerCode = "";
        String interMethod = ""; //��������
        UIWorkFlowUWInterFaceFacade uiWorkFlowUWInterFaceFacade = new UIWorkFlowUWInterFaceFacade();
        try {
            operXML.parserFromXMLString(iData);
            System.out.println("���յ�XML:" + iData);
            Element eType = operXML.getElement("Interface");
            iBody = eType.getValue();
            System.out.println("Interface��������������������" + iBody);

            System.out.println("��ʼ�������ݣ�");
            List KeyList = operXML.getChildrenElement(iData, iBody);
            Element item = null;
            System.out.println("ҵ������size____:" + KeyList.size());
            if (KeyList.size() < 1) {
                throw new Exception("�������Ͳ�ƥ�䣡");
            }
            item = (Element) KeyList.get(0);
            LflowID = operXML.getKeyValue(item, "LflowID");
            lLogNo = Integer.parseInt(operXML.getKeyValue(item, "LlogNo"));
            businessNo = operXML.getKeyValue(item, "businessNo");
            notionInfo = operXML.getKeyValue(item, "notionInfo");
            handlerCode = operXML.getKeyValue(item, "handlerCode");

            if(new String(notionInfo.getBytes(),"ISO8859-1").length()>70){
              String[] arrReturn = (String[])Str.split(notionInfo,70);
              notionInfo = arrReturn[0];
            }

            System.out.println("��������ִ�::\n" + LflowID + "\n" + lLogNo + "\n" + businessNo + "\n" + notionInfo + "\n"
                    + handlerCode);
            //�жϺ������͵ĵ���
            if (iBody.equals(ADDVERIC)) {
                System.out.println("������Ϣ��ʼ");
                return uiWorkFlowUWInterFaceFacade.addInformationOnVeric(LflowID, lLogNo, businessNo, notionInfo,
                        handlerCode);
            } else if (iBody.equals(BACKVERIC)) {
                System.out.println("�˻���Ϣ��ʼ");
                return uiWorkFlowUWInterFaceFacade.backVericToCompp(LflowID, lLogNo, businessNo, notionInfo,
                        handlerCode);
            } else if (iBody.equals(PASSVERIC)) {
                System.out.println("ͨ����Ϣ��ʼ");

                return uiWorkFlowUWInterFaceFacade.passVeric(httpServletRequest, LflowID, lLogNo, businessNo,
                        notionInfo, handlerCode);
            } else if (iBody.equals(PASSCLOSEVERIC)) {
                System.out.println("ͨ����������Ϣ��ʼ");
                return uiWorkFlowUWInterFaceFacade.passVericAndCloseFlow(httpServletRequest, LflowID, lLogNo,
                        businessNo, notionInfo, handlerCode);
            } else {
                throw new Exception("����ȷ��ҵ���������ݣ�����ϵͳ����Ա��ϵ��");
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
            return -998;
        } catch (Exception ex) {
            ex.printStackTrace();
            return -997;
        }
    }

}