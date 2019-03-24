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
 * Title: 理赔-双核工作流接口
 * </p>
 * <p>
 * Description:接收双核工作流更新核赔节点的请求
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: sinosoft 理赔项目组
 * </p>
 *
 * @author 李香
 * @version 1.0
 */

public class UIWFUWServerFacade extends HttpServlet {
    //Initialize global variables
    String iBody = ""; //接收数据类型
    public static String ADDVERIC = "addInformationOnVeric"; //双核流程流转中对理赔中的核赔节点的内容变更
    public static String BACKVERIC = "backVericToCompp"; //核赔节点的退回（退回到计算书）
    public static String PASSVERIC = "passVeric"; //核赔节点的通过（手工结案）
    public static String PASSCLOSEVERIC = "passVericAndCloseFlow"; //核赔节点的通过（自动结案）

    public void init() throws ServletException {
    }

    /**
     * Process the HTTP Get request，集中控制方法，负责调用XML解析方法、回写数据方法等
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
            System.out.println("接收双核提交过来的操作请求!");
            //获取接收对象
            int flag = 0;
            input = new DataInputStream(request.getInputStream());
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            byte[] data = null;
            byte[] b = new byte[1024];
            int read = 0;
            //转换数据流
            while ((read = input.read(b)) !=-1) {
                byteOut.write(b, 0, read);
            }
            data = byteOut.toByteArray();
            //接收完毕
            input.close();
            String strData = new String(data);
            System.out.println("\n----------接收数据完毕！！！-------------\n ");
            //解析数据并响应相应的方法
            flag = this.doTransData(request, response, strData);
            //输出成功标识
            output = new BufferedOutputStream(response.getOutputStream());
            strReturn = flag + "";
            System.out.println("\n---------数据处理完毕，开始发送数据！！！-------------\n ");
            output.write(strReturn.getBytes());
            output.close();
            System.out.println("\n---------发送数据完毕！！！-------------\n ");
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
        System.out.println("开始解析数据类型！");
        String LflowID = "";
        int lLogNo = 0;
        String businessNo = "";
        String notionInfo = "";
        String handlerCode = "";
        String interMethod = ""; //方法名称
        UIWorkFlowUWInterFaceFacade uiWorkFlowUWInterFaceFacade = new UIWorkFlowUWInterFaceFacade();
        try {
            operXML.parserFromXMLString(iData);
            System.out.println("接收的XML:" + iData);
            Element eType = operXML.getElement("Interface");
            iBody = eType.getValue();
            System.out.println("Interface：：：：：：：：：：" + iBody);

            System.out.println("开始解析数据！");
            List KeyList = operXML.getChildrenElement(iData, iBody);
            Element item = null;
            System.out.println("业务数据size____:" + KeyList.size());
            if (KeyList.size() < 1) {
                throw new Exception("数据类型不匹配！");
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

            System.out.println("输出接收字串::\n" + LflowID + "\n" + lLogNo + "\n" + businessNo + "\n" + notionInfo + "\n"
                    + handlerCode);
            //判断函数类型的调用
            if (iBody.equals(ADDVERIC)) {
                System.out.println("增加信息开始");
                return uiWorkFlowUWInterFaceFacade.addInformationOnVeric(LflowID, lLogNo, businessNo, notionInfo,
                        handlerCode);
            } else if (iBody.equals(BACKVERIC)) {
                System.out.println("退回信息开始");
                return uiWorkFlowUWInterFaceFacade.backVericToCompp(LflowID, lLogNo, businessNo, notionInfo,
                        handlerCode);
            } else if (iBody.equals(PASSVERIC)) {
                System.out.println("通过信息开始");

                return uiWorkFlowUWInterFaceFacade.passVeric(httpServletRequest, LflowID, lLogNo, businessNo,
                        notionInfo, handlerCode);
            } else if (iBody.equals(PASSCLOSEVERIC)) {
                System.out.println("通过并结束信息开始");
                return uiWorkFlowUWInterFaceFacade.passVericAndCloseFlow(httpServletRequest, LflowID, lLogNo,
                        businessNo, notionInfo, handlerCode);
            } else {
                throw new Exception("不明确的业务类型数据！请与系统管理员联系！");
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