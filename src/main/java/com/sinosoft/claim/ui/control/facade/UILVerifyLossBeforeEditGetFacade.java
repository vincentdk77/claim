package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLSwfFlowMainFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAVerifyLossViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * Description: �����������ǰ��ѯ������Ϣ��Ϣϵͳ��������
 * Copyright: Copyright (c) 2004
 * Company: Sinosoft
 * @author liubvo
 * @version 1.0
 */
public class UILVerifyLossBeforeEditGetFacade extends Action {
	// ��־��Ϣ
	private static final Log logger = LogFactory.getLog(UILVerifyLossBeforeEditGetFacade.class);
	
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {

		// ҵ�����ͣ�ADD-���� EDIT-�޸� SHOW-��ʾ
		String editType = httpServletRequest.getParameter("editType");
		String registNo = ""; // ������
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user"); // �û���Ϣ
		String riskCode = httpServletRequest.getParameter("riskCode"); // ����
		String insureCarFlag = httpServletRequest.getParameter("insureCarFlag"); // ������־
		String lossItemCode = httpServletRequest.getParameter("lossItemCode"); // ����
		String lossItemName = httpServletRequest.getParameter("lossItemName"); // ���ƺ���
		String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
		String tempStatus = httpServletRequest.getParameter("status"); // ���ƺ���

		String forward = ""; // ��ǰ
		int intLossItemCode = Integer.parseInt(DataUtils.nullToZero(lossItemCode)); // ����
		try {
			// ��δ����type�쳣����{}��������������쳣����{}
			if (editType.equals("ADD")) {
				logger.info("������������ʼ......");
				// ��ѯ������Ϣ,�������룬���ڳ�ʼ������ʾ
				registNo = httpServletRequest.getParameter("RegistNo"); // ������
				DAAVerifyLossViewHelper dAAVerifyLossViewHelper = new DAAVerifyLossViewHelper();
				// ����ռ�ŷ�����ֻ�е��й����������LogNo��ʱ�����ʹ�á� ���û��flowID��logno�򲻽����жϡ�
				String flowID = httpServletRequest.getParameter("swfLogFlowID");
				String logNo = httpServletRequest.getParameter("swfLogLogNo");
				String msg = "";
				if (flowID != null && logNo != null) {
					UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
					SwfLogDto swfLogDto = new SwfLogDto();
					swfLogDto = uiWorkFlowAction.holdNode(flowID, Integer.parseInt(logNo), user
							.getUserCode(), user.getUserName());
					if (swfLogDto.getHoldNode() == false) {
						msg = "����'" + registNo + "'�Ѿ�������:'" + swfLogDto.getHandlerCode() + "',����:'"
								+ swfLogDto.getHandlerName() + "'���û���ռ��,��ѡ�������������д���!";
						throw new UserException(1, 3, "������", msg);
					}
				}
				// ũ��
				if ("I".equals(riskType) || "H".equals(riskType)) {
					// ũ��û�к���
					// agriVerifyLossViewHelper.certainLossDtoToView(httpServletRequest, registNo, editType);
				} else {
					dAAVerifyLossViewHelper.certainLossDtoToView(httpServletRequest, registNo,
							editType);
				}
				forward = editType + riskCode;
				
				// reason���������⸶������Ӧ�ĵ�λ��Ϣ
				UICodeAction uiCodeAction = new UICodeAction();
				String conditions = " codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"
						+ riskCode + "' and codetype='Unit')";
				Collection collection = uiCodeAction.findByConditions(conditions);
				httpServletRequest.setAttribute("lossesUnitCodeCollection", collection);
				logger.info("���������������......");
			}
			if (editType.equals("EDIT") || editType.equals("SHOW")) {
				logger.info("�޸�/��ѯ��������ʼ......");
				// ��ѯ������Ϣ,�������룬���ڳ�ʼ������ʾ
				registNo = httpServletRequest.getParameter("prpLverifyLossRegistNo"); // ������
				DAAVerifyLossViewHelper dAAVerifyLossViewHelper = new DAAVerifyLossViewHelper();
				// ũ��
				if ("I".equals(riskType) || "H".equals(riskType)) {
					// ũ��û�к���
					// agriVerifyLossViewHelper.verifyLossDtoView(httpServletRequest, registNo, editType, tempStatus);
				} else {
					dAAVerifyLossViewHelper.verifyLossDtoView(httpServletRequest, registNo,
							editType, tempStatus);
				}
				//���˺���ҳ�����ӡ����̲�ѯ��������"swfLogFlowID"����
				if("SHOW".equals(editType)){
					String flowID = httpServletRequest.getParameter("swfLogFlowID");
					if(null==flowID||"".equals(flowID)){
						ArrayList arraylistSwflog = (ArrayList)new BLSwfFlowMainFacade().findByConditions(" flowname='"+registNo+"' ");
						if(null!=arraylistSwflog&&arraylistSwflog.size()>0){
							SwfFlowMainDto swfFlowMainDto = (SwfFlowMainDto) arraylistSwflog.get(0);
							flowID = swfFlowMainDto.getFlowID();
							httpServletRequest.setAttribute("swfLogFlowID", flowID);
						}
					}
				}
				
				forward = editType + riskCode;
				// reason���������⸶������Ӧ�ĵ�λ��Ϣ
				UICodeAction uiCodeAction = new UICodeAction();
				String conditions = " codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"
						+ riskCode + "' and codetype='Unit')";
				Collection collection = uiCodeAction.findByConditions(conditions);
				httpServletRequest.setAttribute("lossesUnitCodeCollection", collection);
				logger.info("�޸�/��ѯ�����������......");
			}

			// reason:���ֻؿ�
			String nodeType = httpServletRequest.getParameter("nodeType");
			if (nodeType != null && nodeType.equals("backc")) {
				forward = "BackCDAA";
			} else {
				forward = BusinessRuleUtil.getForward(httpServletRequest, riskCode, "verif",
						editType, intLossItemCode);
			}

			if (editType.equals("SelectLossType")) {
				forward = "SelectLossType";
			}
			saveToken(httpServletRequest);
			//reason: �����ֹ�ظ��ύ
			session.setAttribute("oldVerifyLossLastAccessedTime","");
		} catch (SecurityException usee) {
			usee.printStackTrace();
			// ������Ϣ����
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("title.verifyLossBeforeEdit.titleName");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", usee.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			// ������Ϣ����
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("title.verifyLossBeforeEdit.titleName");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} finally {

		}
		return actionMapping.findForward(forward);
	}
}
