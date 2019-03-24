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
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * <p>
 * Title: ����-���ϵͳ�ӿ�
 * </p>
 * <p>
 * Description:�������ϵͳ������
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: sinosoft ������Ŀ��
 * </p>
 * 
 * @author sunchenggang
 * @version 1.0
 */

public class UIClaimFittingsServerFacade extends HttpServlet {
	String iBody = ""; //������������
	public static String RETFITTINGS = "ReturnResultFittings"; //�������ϵͳ��������
	
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
			System.out.println("�������ϵͳ�ύ�����Ĳ�������2005-12-12!!!!!!!!!!!!!!!");
			//��ȡ���ն���
			String flag = "";
			String flashURL = AppConfig.get("sysconst.FITTINGS_FLASH_URL");
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
			//�������ݲ���Ӧ��Ӧ�ķ���
			flag = this.doTransData(request, response, strData);
			//����ɹ���ʶ
			output = new BufferedOutputStream(response.getOutputStream());
			String error_Message = "";
			if("000".equals(flag)){
				error_Message = "�ɹ�";
			}else{
				error_Message = "ʧ��";
			}
			strReturn = "<?xml version=\"1.0\" encoding=\"GBK\"?>\n"+
			"<LossRtnReturnData>\n"+
			  "<RESPONSE_CODE>"+flag+"</RESPONSE_CODE>\n"+
			  "<ERROR_MESSAGE>"+error_Message+"</ERROR_MESSAGE>\n"+
			  "<URL>"+flashURL+"</URL>\n"+
			"</LossRtnReturnData>";

			output.write(strReturn.getBytes());
			output.close();
			
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
	public String doTransData(HttpServletRequest httpServletRequest, HttpServletResponse response, String iData)
	throws SQLException, Exception {
		OperXML operXML = new OperXML();
		
		String registNo = "";        
		String lossItemCode = "";
		String vehCode = "";
		String licenseNo = "";
		String repairFactoryType="";
		String selectedFittings = "";
		int itemCount = 0;
		
		try {
			operXML.parserFromXMLString(iData);
			System.out.println("���յ�XML:" + iData);
			System.out.println("��ʼ�����������ݣ�");
			iBody = "LossRtnBody";
			System.out.println("BaseInfo��������������������" + iBody);
			
			List KeyList = operXML.getChildrenElement(iData, iBody);
			Element item = null;
			Element item1 = null;
			Element item2 = null;
			System.out.println("ҵ������size____:" + KeyList.size());
			if (KeyList.size() < 1) {
				throw new Exception("�������Ͳ�ƥ�䣡");
			}
			
			item = (Element) KeyList.get(0);  
			item1 = operXML.getElement(item,"LossInfo");
			registNo = operXML.getKeyValue(item1, "CaseNo");
			lossItemCode = operXML.getKeyValue(item1, "LossNo");
			vehCode = operXML.getKeyValue(item1, "VehCertainCode");
			licenseNo = operXML.getKeyValue(item1, "PlateNo");
			
			System.out.println("��ʼ����������ݣ�");
			iBody = "LossRtnBody";
			KeyList = operXML.getChildrenElement(iData, iBody);
			
			System.out.println("ҵ������size____:" + KeyList.size());
			if (KeyList.size() < 1) {
				throw new Exception("�������Ͳ�ƥ�䣡");
			}
			
			for(int i=0;i<KeyList.size();i++){
				item = (Element) KeyList.get(i);
				item1 = operXML.getElement(item,"LossFitInfo");
				itemCount = operXML.getCountByTag(item1, "Item");
				for(int j=0;j<itemCount;j++){
					item2 = operXML.getElement(item1,"Item",j);
					if(!"".equals(operXML.getKeyValue(item2, "PartId"))){
						if(!"".equals(selectedFittings)){
							selectedFittings += "_|";
						}
						
						selectedFittings +=  operXML.getKeyValue(item2, "PartId") + "^"
						+  operXML.getKeyValue(item2, "SerialNo") + "^"
						+  operXML.getKeyValue(item2, "OriginalId") + "^"
						+  operXML.getKeyValue(item2, "OriginalName") + "^"                                  
						+  operXML.getKeyValue(item2, "PartStandardCode") + "^"
						+  operXML.getKeyValue(item2, "PartStandard") + "^"
						+  operXML.getKeyValue(item2, "PartGroupCode") + "^"
						+  operXML.getKeyValue(item2, "PartGroupName") + "^"
						+  operXML.getKeyValue(item2, "LossPrice") + "^"
						+  operXML.getKeyValue(item2, "RepairSitePrice") + "^"
						+  operXML.getKeyValue(item2, "LossCount") + "^"
						+  operXML.getKeyValue(item2, "SumPrice") + "^"
						+  operXML.getKeyValue(item2, "SelfConfigFlag") + "^"
						+  operXML.getKeyValue(item2, "ChgCompSetCode") + "^"
						+  operXML.getKeyValue(item2, "ChgCompSetName") + "^"
						+  operXML.getKeyValue(item2, "ChgRefPrice") + "^"
						+  operXML.getKeyValue(item2, "ChgLocPrice") + "^"
						+  operXML.getKeyValue(item2, "RefPrice1") + "^"                                  
						+  operXML.getKeyValue(item2, "RefPrice2") + "^"                                                                    
						+  operXML.getKeyValue(item2, "RefPrice3")+ "^"
						+  operXML.getKeyValue(item2, "LocPrice1")+ "^"
						+  operXML.getKeyValue(item2, "LocPrice2")+ "^"
						+  operXML.getKeyValue(item2, "LocPrice3")+ "^"
						+  operXML.getKeyValue(item2, "IfRemain")+ "^"
						+  operXML.getKeyValue(item2, "Remnant")+ "^"
						+  operXML.getKeyValue(item2, "Status")+ "^"
						+  operXML.getKeyValue(item2, "Remark");
					}    
				}
			}
			iBody = "ReturnResultFittings";
			/**
			 * 000���ɹ�
			 * 400��ϵͳ��֤����
			 * 401�����ݰ���ʽ���󣨼���XML����ʽ���󣩡�
			 * 402�����������Դ����磺ȱ�ٱ����š���ʧ������ţ���
			 * 403����ʧ������Ŵ��󣬼�û�е�ǰ��ŵĳ�����
			 * 499�������쳣����
			 */
			
			//�жϺ������͵ĵ���
			if (iBody.equals(RETFITTINGS)) {
				//���������Ϣ��ʼ
				UILClaimFittingsInterFaceFacade uiLClaimFittingsInterFaceFacade = new UILClaimFittingsInterFaceFacade();
				return uiLClaimFittingsInterFaceFacade.addFittings(registNo, lossItemCode, vehCode, licenseNo,selectedFittings);
			} else {
				return "401";
			}
			
		} catch (SQLException exception) {
			exception.printStackTrace();            
			return "499";
			
		} catch (Exception ex) {
			ex.printStackTrace();
			return "401";
		}
		
	}
	
}