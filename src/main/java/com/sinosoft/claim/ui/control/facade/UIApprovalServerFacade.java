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

public class UIApprovalServerFacade extends HttpServlet {
    String iBody = ""; //������������
	public static String BackOldClaimCance = "BackOldClaimCance"; // ��˲�ͨ��������ע��
	public static String PassOldClaimCance = "PassOldClaimCance"; // ���ͨ��������ע��

	public static String BackOldClaimRecase = "BackOldClaimRecase"; // ��˲�ͨ�����ؿ��ⰸ
	public static String PassOldClaimRecase = "PassOldClaimRecase"; // ���ͨ�����ؿ��ⰸ
	
	public static String BackOldVeriPay = "BackOldVeriPay"; //��˲�ͨ����֧����Ϣ
    public static String PassOldVeriPay = "PassOldVeriPay"; //���ͨ����֧����Ϣ
    public static String GiveUpOldVeriPay = "GiveUpOldVeriPay"; //֧����Ϣ��˷���

	public void init() throws ServletException {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strReturn = "";
		DataInputStream input = null;
		BufferedOutputStream output = null;
		try {
			System.out.println("����˫���ύ�����Ĳ�������!");
			// ��ȡ���ն���
			int flag = 0;
			input = new DataInputStream(request.getInputStream());
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			byte[] data = null;
			byte[] b = new byte[1024];
			int read = 0;
			// ת��������
			while ((read = input.read(b)) != -1) {
				byteOut.write(b, 0, read);
			}
			data = byteOut.toByteArray();
			// �������
			input.close();
			String strData = new String(data);
			System.out.println("\n----------����������ϣ�����-------------\n ");
			// �������ݲ���Ӧ��Ӧ�ķ���
			flag = this.doTransData(request, response, strData);
			// ����ɹ���ʶ
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
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Clean up resources
	 */
	public void destroy() {
	}

	public int doTransData(HttpServletRequest httpServletRequest,
			HttpServletResponse response, String iData) throws SQLException,
			Exception {

        OperXML operXML = new OperXML();
        
        String LflowID = "";
        int lLogNo = 0;
        String businessNo = "";
        String notionInfo = "";
        String handlerCode = "";
        
        try{
        	operXML.parserFromXMLString(iData);
            
            Element eType = operXML.getElement("Interface");
            iBody = eType.getValue();


            List KeyList = operXML.getChildrenElement(iData, iBody);
            Element item = null;

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
            UIWorkFlowApprovalInterFaceFacade uiWorkFlowApprovalInterFaceFacade = new UIWorkFlowApprovalInterFaceFacade();
            if (iBody.equals(BackOldClaimCance)){
            	return uiWorkFlowApprovalInterFaceFacade.writeClaimCance(LflowID, lLogNo, businessNo, notionInfo, handlerCode, BackOldClaimCance);
            }else if(iBody.equals(PassOldClaimCance)){
            	return uiWorkFlowApprovalInterFaceFacade.writeClaimCance(LflowID, lLogNo, businessNo, notionInfo, handlerCode, PassOldClaimCance);
            }else if(iBody.equals(BackOldClaimRecase)){
            	return uiWorkFlowApprovalInterFaceFacade.writeClaimRecase(LflowID, lLogNo, businessNo, notionInfo, handlerCode, BackOldClaimRecase);
            }else if(iBody.equals(PassOldClaimRecase)){
            	return uiWorkFlowApprovalInterFaceFacade.writeClaimRecase(LflowID, lLogNo, businessNo, notionInfo, handlerCode, PassOldClaimRecase);
            } else if (iBody.equals(BackOldVeriPay)) {
            
                return uiWorkFlowApprovalInterFaceFacade.writeVeriPay(LflowID, lLogNo, businessNo, notionInfo,
                        handlerCode,BackOldVeriPay);
            } else if (iBody.equals(PassOldVeriPay)) {
            
                return uiWorkFlowApprovalInterFaceFacade.writeVeriPay(LflowID, lLogNo, businessNo, notionInfo,
                        handlerCode,PassOldVeriPay);
            }
            //����֧����������
            else if(iBody.equals(GiveUpOldVeriPay)){
            	 return uiWorkFlowApprovalInterFaceFacade.writeVeriPay(LflowID, lLogNo, businessNo, notionInfo,
                         handlerCode,GiveUpOldVeriPay);
            } 
            else {
                throw new Exception("����ȷ��ҵ���������ݣ�����ϵͳ����Ա��ϵ��");
            }
            
        }catch (Exception ex) {
            ex.printStackTrace();
            return -997;
        }
		
	}

}
