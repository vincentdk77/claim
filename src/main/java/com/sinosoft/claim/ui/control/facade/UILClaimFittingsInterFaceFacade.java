package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.gyic.claim.utils.Utils;
import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.claim.bl.facade.BLPrpLthirdPartyFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLclaimFittingsDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.ui.control.action.UILClaimFittingsAction;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.utility.PrpallUtility;
import com.sinosoft.utility.string.Str;

/**
 * �������������ϵͳ�ӿ���
 * <p>
 * Title: �������������ϵͳ�ӿ���
 * </p>
 * <p>
 * Description: �������������ϵͳ�ӿ���
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: sinosoft.com.cn
 * </p>
 * 
 * @author sunchenggang
 * @version 1.0
 */
public class UILClaimFittingsInterFaceFacade extends Action {
	private static Log logger = LogFactory.getLog(UILClaimFittingsInterFaceFacade.class);

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		String forward = ""; //��ǰ��ת

		try {
			String queryType = httpServletRequest.getParameter("queryType"); //��ѯ����
			String registNo = httpServletRequest.getParameter("registNo"); //��������
			String policyNo = httpServletRequest.getParameter("policyNo"); //������
			String insurant = httpServletRequest.getParameter("insurant"); //��������
			String lossItemCode = httpServletRequest.getParameter("lossItemCode"); //��ʧ����
			String licenseNo = httpServletRequest.getParameter("licenseNo"); //���ƺ���
			String systemAreaCode = httpServletRequest.getParameter("systemAreaCode"); //ϵͳ�۵���
			String localAreaCode = httpServletRequest.getParameter("localAreaCode"); //���ؼ۵�������д��ǰ�û����ڵķֹ�˾���룩
			String vehCode = httpServletRequest.getParameter("vehCode"); //���ͱ���
			String vehName = httpServletRequest.getParameter("vehName"); //��������
			String selectedCarFittings = httpServletRequest.getParameter("selectCarFittings"); //��������
			
			String kindCode = "A";//�ձ����
			String kindName = "������ʧ��";//�ձ�����
			String estimateNo = httpServletRequest.getParameter("policyNo");;//���𵥺�
			String lossNo = httpServletRequest.getParameter("lossItemCode");//��ʧ��Ŀ���
			String caseNo =  httpServletRequest.getParameter("registNo");//�¹ʺ���
			String plateNo = httpServletRequest.getParameter("licenseNo");//���ƺ�
			BLPrpLthirdPartyFacade blPrpLthirdPartyFacade = new BLPrpLthirdPartyFacade();
			String conditions = " registNo = '" + caseNo + "' and serialNo = '" + estimateNo + "'";
			ArrayList prpLthirdPartyDtoList = (ArrayList)blPrpLthirdPartyFacade.findByConditions(conditions);
			PrpLthirdPartyDto prpLthirdPartyDto = null;
			String markColor = "";//������ɫ
			String engineNo = "";//��������
			String frameNo = "";//���ݺ�
			if(prpLthirdPartyDtoList.size() > 0){
				prpLthirdPartyDto = (PrpLthirdPartyDto)prpLthirdPartyDtoList.get(0);
				BLCodeFacade blCodeFacade = new BLCodeFacade();
				markColor = blCodeFacade.translateCodeCode("ColorCode", prpLthirdPartyDto.getLicenseColorCode(), true);
				engineNo = prpLthirdPartyDto.getEngineNo();
				frameNo = prpLthirdPartyDto.getFrameNo();
			}
			
			String plateColor = "";//������ɫ
			
			String insureVehicleName = httpServletRequest.getParameter("vehName");;//�б���������
			String insureVehicleCode = httpServletRequest.getParameter("vehCode");;//�б����ʹ���
			String comCode = "0000000000";//����Ա�����ֹ�˾����
			String company = "��Ԫũҵ���չɷ����޹�˾";//����Ա�����ֹ�˾����
			UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
			String handlerCode = user.getUserCode();//����Ա����
			String handlerName = user.getUserName();//����Ա����
			String manHour = "";//������ʱ����
			
			String showPriceFlag = httpServletRequest.getParameter("showpriceflag");
			String repairFactoryType = httpServletRequest.getParameter("repairfactorytype");
			

			String returnparam = "";
			String errMsg = "";
			Map infoMap = new HashMap();
			//vehCode = "ABJAD5014";
			//vehName = "������SVW7203BPi";
			if(registNo==null||registNo.trim().length()==0){
				errMsg = "ȱ�ٱ�����registNo,����ϵͳ����Ա��ϵ";
			}else if(lossItemCode==null||lossItemCode.trim().length()==0){
				errMsg = "ȱ����ʧ��������lossItemCode,����ϵͳ����Ա��ϵ";
			}else if(systemAreaCode==null||systemAreaCode.trim().length()==0){
				errMsg = "ȱ��ϵͳ��������systemAreaCode,����ϵͳ����Ա��ϵ";
			}else if(localAreaCode==null||localAreaCode.trim().length()==0){
				errMsg = "ȱ�ٱ��ص�������localAreaCode,����ϵͳ����Ա��ϵ";
			}else if(vehCode==null||vehCode.trim().length()==0){
				errMsg = "���� "+vehName+" ȱ�ٳ��ͱ���vehCode���������⳵���ġ������ͺš���˫��ѡ����Ӧ���������ԡ��ֹ�����ĳ����޷������ϵͳ��ȡ������ݡ�";
			}
			if(errMsg.trim().length()>0){
				throw new UserException(-98, -998, "���ݼ��", errMsg);
			}
			
			
			infoMap.put("400", "ϵͳ��֤����!");
			infoMap.put("401", "���ݰ���ʽ���󣨼���XML����ʽ����!");
			infoMap.put("402", "���������Դ����磺ȱ�ٱ����š���ʧ������š�ȱ�ٱ����š�ȱ�ٱ����ˣ�!");
			infoMap.put("403", "��ǰ���Ͳ����ڣ����ߵ�ǰ�������������û�����!");
			infoMap.put("499", "�����쳣����!");

			UIClaimFittingsClientFacade uiClaimFittingsClientFacade = new UIClaimFittingsClientFacade();
            Utils util=new Utils();
            util.getPhisicaMemory("�������ύ���ϵͳ�ӿڿ�ʼ---start");
			returnparam = uiClaimFittingsClientFacade.sendXMLData(
					kindCode,
					kindName,
					lossNo,
					estimateNo,
					caseNo,
					plateNo,
					markColor,
					plateColor,
					engineNo,
					frameNo,
					insureVehicleName,
					insureVehicleCode,
					comCode,
					company,
					handlerCode,
					handlerName,
					manHour);
			util.getPhisicaMemory("�������ύ���ϵͳ�ӿڽ���---end");
			logger.debug("returnparam=" + returnparam);
 
			if (returnparam.trim().equals("")) {
				throw new UserException(-98, -998, "�ύ���ϵͳ", "���ϵͳû����Ӧ,����ϵϵͳ����Ա!");
			}

			errMsg = returnparam.substring(0, 3);
			if (!errMsg.equals("000")) {
				logger.debug("errMsg:" + errMsg);
				if (infoMap.containsKey(errMsg)) {
					throw new UserException(-98, -998, "�ύ���ϵͳ", (String) infoMap.get(errMsg));
				} else {
					throw new UserException(-98, -998, "�ύ���ϵͳ", "δ֪����,���ϵͳ���ش�����Ϊ:"+errMsg);
				}
			}
			returnparam = returnparam.substring(3);
			logger.debug("�ض�������URL="+returnparam);
//			forward = "success";
			
			httpServletResponse.sendRedirect(returnparam);
			return null;
		} catch (UserException usee) {
			usee.printStackTrace();
			//������Ϣ���� 
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.certainLossBeforeEdit.editCertainLoss");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//������Ϣ����
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.certainLossBeforeEdit.editCertainLoss");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		}
		return actionMapping.findForward(forward);
	}

	/**
	 * ˫��������ת�ж������еĺ���ڵ�����ݱ��
	 * 
	 * @param LflowID String ���⹤��������
	 * @param LlogNo int ���⹤�����ڵ����
	 * @param businessNo String ҵ�����
	 * @param notionInfo String ������� ��Ա�� ʱ��ʱ��
	 * @param handlerCode String ����Ա
	 * @throws Exception
	 * @return boolean
	 */

	public String addFittings(String registNo, String lossItemCode, String vehCode, String licenseNo,
			String selectedFittings) throws Exception {

		UILClaimFittingsAction uiLClaimFittingsAction = new UILClaimFittingsAction();
		PrpLclaimFittingsDto prpLclaimFittingsDto = null;
		Collection fittingsList = new ArrayList();
		PrpallUtility util=new PrpallUtility();
		String[] selectedFittingsArr = null;
		String[] fittingsArr = null;

		try {
			if(!"".equals(selectedFittings)){
				selectedFittingsArr = Str.split(selectedFittings, "_|");
	
				for (int i = 0; i < selectedFittingsArr.length; i++) {
	
					logger.debug("selectedFittingsArr[i]====" + selectedFittingsArr[i]);
	
					fittingsArr = Str.split(selectedFittingsArr[i], "^");
	
					prpLclaimFittingsDto = new PrpLclaimFittingsDto();
					prpLclaimFittingsDto.setPartId(fittingsArr[0]);
					prpLclaimFittingsDto.setSerialNo(Integer.parseInt(fittingsArr[1]));
					prpLclaimFittingsDto.setOriginalID(fittingsArr[2]);
					prpLclaimFittingsDto.setOriginalName(fittingsArr[3]);
					prpLclaimFittingsDto.setFittingCode(fittingsArr[4]);
					prpLclaimFittingsDto.setFittingName(fittingsArr[5]);
					prpLclaimFittingsDto.setPartGroupCode(fittingsArr[6]);
					prpLclaimFittingsDto.setPartGroupName(fittingsArr[7]);
					prpLclaimFittingsDto.setCertaPrice(Double.parseDouble(NullToZero(fittingsArr[8])));
					prpLclaimFittingsDto.setRepairSitePrice(Double.parseDouble(NullToZero(fittingsArr[9])));
					long certaQuantity = (long)Double.parseDouble(NullToZero(fittingsArr[10]));
					prpLclaimFittingsDto.setCertaQuantity(certaQuantity);
					prpLclaimFittingsDto.setSumPrice(Double.parseDouble(NullToZero(fittingsArr[11])));
					prpLclaimFittingsDto.setSelfConfigFlag(fittingsArr[12]);
					prpLclaimFittingsDto.setChgCompSetCode(fittingsArr[13]);
					prpLclaimFittingsDto.setChgCompSetName(fittingsArr[14]);
					prpLclaimFittingsDto.setChgRefPrice(Double.parseDouble(NullToZero(fittingsArr[15])));
					prpLclaimFittingsDto.setChgLocPrice(Double.parseDouble(NullToZero(fittingsArr[16])));
					prpLclaimFittingsDto.setSys4SPrice(Double.parseDouble(NullToZero(fittingsArr[17])));
					prpLclaimFittingsDto.setSysMarketPrice(Double.parseDouble(NullToZero(fittingsArr[18])));
					prpLclaimFittingsDto.setSysmatchPrice(Double.parseDouble(NullToZero(fittingsArr[19])));
					prpLclaimFittingsDto.setNative4SPrice(Double.parseDouble(NullToZero(fittingsArr[20])));
					prpLclaimFittingsDto.setNativeMarketPrice(Double.parseDouble(NullToZero(fittingsArr[21])));
					prpLclaimFittingsDto.setNativeMatchPrice(Double.parseDouble(NullToZero(fittingsArr[22])));
					prpLclaimFittingsDto.setCertaSaved(fittingsArr[23]);
					prpLclaimFittingsDto.setRemnant(Double.parseDouble(NullToZero(fittingsArr[24])));
					prpLclaimFittingsDto.setStatus(fittingsArr[25]);
					prpLclaimFittingsDto.setRemark(fittingsArr[26]);
					prpLclaimFittingsDto.setRegistNo(registNo);
					prpLclaimFittingsDto.setLossItemCode(lossItemCode);
					prpLclaimFittingsDto.setModelCode(vehCode);
					prpLclaimFittingsDto.setLicenseNo(licenseNo);
					prpLclaimFittingsDto.setResultType("Compent");
					prpLclaimFittingsDto.setFlag("1");
	
					fittingsList.add(prpLclaimFittingsDto);
				}
			}
			util.getPhisicaMemory("˫��������ת�ж������еĺ���ڵ�����ݱ����ʼ---start");
			uiLClaimFittingsAction.save(fittingsList);
			util.getPhisicaMemory("˫��������ת�ж������еĺ���ڵ�����ݱ������---end");
			return "000";
		} catch (Exception exception) {
			exception.printStackTrace();
			return "499";

		}

	}

	private static String NullToZero(String strNum) {
		if (strNum == null || strNum.equals("")) {
			return "0";
		}
		return strNum;
	}
}
