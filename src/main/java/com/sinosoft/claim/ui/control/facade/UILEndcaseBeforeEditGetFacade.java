package com.sinosoft.claim.ui.control.facade; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.dto.custom.EndcaseDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowQueryDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIConfigAction;
import com.sinosoft.claim.ui.control.action.UIEndcaseAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAACompensateViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAAEndcaseViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �ַ�HTTP GET ��������᰸ǰ��ѯ��������
 * <p>
 * Title: ��������᰸ǰ��ѯ������Ϣ
 * </p>
 * <p>
 * Description: ��������᰸ǰ��ѯ������Ϣϵͳ��������
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author liubvo
 * @version 1.0
 */
public class UILEndcaseBeforeEditGetFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

		// ҵ�����ͣ�ADD-���� EDIT-�޸� SHOW-��ʾ
//		add by lym 20060809 start for �������ⰸ����֧����
		String dfFlag = httpServletRequest.getParameter("dfFlag");
		httpServletRequest.setAttribute("dfFlag",dfFlag);
//		add by lym 20060809 end for �������ⰸ����֧����	
		String editType = httpServletRequest.getParameter("editType");
		String claimNo = httpServletRequest.getParameter("ClaimNo"); // �ⰸ��
 		String caseNo = ""; // �ⰸ��
		String riskCode = httpServletRequest.getParameter("riskCode"); // ����
		String forward = ""; // ��ǰ
		try { 
			HttpSession session = httpServletRequest.getSession();
			UserDto user = (UserDto) session.getAttribute("user"); // �û���Ϣ

			// ��δ����type�쳣����{}��������������쳣����{}
			// 1.��ѯ������Ϣ,�������룬���ڳ�ʼ������ʾ
			if (editType.equals("ADD")) {
				
				DAAEndcaseViewHelper dAAEndcaseViewHelper = new DAAEndcaseViewHelper();
				boolean blnRecaseFlag = dAAEndcaseViewHelper.checkRecase(claimNo); //�Ƿ��ؿ��ⰸ�����ѽ᰸
			
				// �����Ѿ��᰸�Ĳ����ٽ��н᰸�Ǽ�
				boolean blnEndcaseFlag = dAAEndcaseViewHelper.checkEndcase(claimNo);
				if (blnEndcaseFlag == true  &&  blnRecaseFlag ==true) {  //�������ؿ��ⰸ�Ƿ�Ҳ�Ѿ��᰸���ж�
					ActionMessages messages = new ActionMessages();
					messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("title.endcaseEidt.alreadyEndcase"));
					saveMessages(httpServletRequest, messages);
					return actionMapping.findForward("success");
				}
				
				
				// **************�жϱ����Ƿ��Ѿ�ʵ��add by qinyongli 2005-7-21
				UIPolicyAction uiPolicyAction = new UIPolicyAction();
				UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();
				EndcaseDto endcaseDto = uiEndcaseAction.findByPrimaryKey(claimNo);
				String conditions1 = " policyno = '" + endcaseDto.getPrpLclaimDto().getPolicyNo() + "'";
				int intReturn = 0;
				intReturn = uiPolicyAction.checkPay(conditions1);// -1Ϊδ�ɷѣ�-2Ϊδ��ȫ��1Ϊ��ȫ
				// ��ȡϵͳ������Ϣ
				UIConfigAction uiConfigAction = new UIConfigAction();
				String configValue = ""; // ��ȡ����δʵ���Ƿ�����᰸
				configValue = uiConfigAction.getConfigValue("ALLOW_UNPAYED_ENDCASE", endcaseDto.getPrpLclaimDto().getRiskCode());
				if (configValue == null || configValue.equals("")) {
					throw new UserException(1, 3, "platform", "����ϵϵͳ����Ա����ƽ̨����ϵͳ�н�������"
							+ endcaseDto.getPrpLclaimDto().getRiskCode() + "'����δʵ���Ƿ�����᰸'�ĳ�ʼ����");

				}

				// modify by liuyanmei add 20051110 start==================
				// reason:�ж��Ƿ�¼��֧����Ϣ��û��¼��֧����Ϣ���ܽ᰸
				System.out.println("��ʼ�ж������ⰸ�Ĳ���1");
				int planFeeFlag = 0;
   //add by lym 20060809 start for �������ⰸ����֧����	
			if (dfFlag !=null && !dfFlag.equals("") && dfFlag.equals("Y")){
			}else {
	//add by lym 20060809 end for �������ⰸ����֧����

				planFeeFlag = dAAEndcaseViewHelper.checkPlanFeeFlag(httpServletRequest, claimNo);
				//modify by lixiang start at 2006-08-31
				//reason:�������ʲô�õ��أ� ����û����ʾ��������ע�͵��ˡ�������֪��ԭ��
				/*
				if (planFeeFlag == 0) {
					ActionMessages messages = new ActionMessages();
					messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("title.endcaseEidt.compensateNotInJplanFee"));
					saveMessages(httpServletRequest, messages);
					return actionMapping.findForward("success");
				}*/
                //modify by lixiang end at 2006-08-31
				// modify by liuyanmei add 20051110 end======================
            }
			System.out.println("��ʼ�ж������ⰸ�Ĳ���2");
				// ���configValue =2 intReturn��=1���ʾδ���ѽ᰸
				//if (configValue.equals("2") && intReturn != 1) {
					//throw new UserException(1, 3, "endcase", "����δʵ�գ�ϵͳ������᰸��"+ intReturn);
				//}
			httpServletRequest.setAttribute("planFeeFlag", intReturn);
				// *******************************************add end
				// ȡ�����������Ƿ�ͨ������Ϣ
				 //add by lym 20060809 start for �������ⰸ����֧����
				System.out.println("��ʼ�ж������ⰸ�Ĳ���3");
				
			if (dfFlag !=null && !dfFlag.equals("") && dfFlag.equals("Y")){
			}else {
				 //add by lym 20060809 end for �������ⰸ����֧����			
				int intCompensateFlag = dAAEndcaseViewHelper.checkCompensate(httpServletRequest, claimNo);
				
				if (intCompensateFlag == 0) { //�����⣬����ǵ渶����Ӧ���м�����ģ��������ô���ǵġ�
					throw new UserException(1, 3, "endcase", "������"+endcaseDto.getPrpLclaimDto().getClaimNo() +"û���������飬���ܽ᰸��");
						}

				if (intCompensateFlag < 0) {
					throw new UserException(1, 3, "endcase", "��û�к���ͨ���ļ����飬���ܽ᰸��");
				}
			}
			System.out.println("��ʼ�ж������ⰸ�Ĳ���4");
				// ==================================================
				// ����ռ�ŷ�����ֻ�е��й����������LogNo��ʱ�����ʹ�á�
				// ���û��flowID��logno�򲻽����жϡ�
				String flowID = httpServletRequest.getParameter("swfLogFlowID");
				String logNo = httpServletRequest.getParameter("swfLogLogNo");
				if (flowID != null && logNo != null) {
					UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
					SwfLogDto swfLogDto = new SwfLogDto();
					swfLogDto = uiWorkFlowAction.holdNode(flowID, Integer.parseInt(logNo), user.getUserCode(), user.getUserName());
					if (swfLogDto.getHoldNode() == false) {
						String msg = "����'" + claimNo + "'�Ѿ�������:'" + swfLogDto.getHandlerCode() + "',����:'"
								+ swfLogDto.getHandlerName() + "'���û���ռ��,��ѡ�������������д���!";
						throw new UserException(1, 3, "������", msg);
					}
				}
				// ==================================================
				dAAEndcaseViewHelper.claimDtoToView(httpServletRequest, claimNo, editType);

				// modify by wangli add start 20050418
				if (riskCode == null || riskCode.length() < 1 || riskCode.trim().equals("")) {
					riskCode = BusinessRuleUtil.getRiskCode(claimNo,"ClaimNo");
				}
				
			}
			// ��ѯ�᰸��Ϣ,�������룬���ڳ�ʼ������ʾ
			if (editType.equals("EDIT") || editType.equals("SHOW")) {
				claimNo = httpServletRequest.getParameter("prpLendcaseEndcaseNo"); // �᰸��
				DAAEndcaseViewHelper dAAEndcaseViewHelper = new DAAEndcaseViewHelper();
				dAAEndcaseViewHelper.endcaseDtoView(httpServletRequest, claimNo);
				if (riskCode == null || riskCode.length() < 1 || riskCode.trim().equals("")) {
					riskCode = BusinessRuleUtil.getRiskCode(caseNo,"CaseNo");
				}
			}
			WorkFlowQueryDto workFlowQueryDto = new WorkFlowQueryDto();
			workFlowQueryDto.setClaimNo(claimNo);
			httpServletRequest.setAttribute("caseType", httpServletRequest.getParameter("caseType"));
			DAACompensateViewHelper dAACompensateViewHelper = new DAACompensateViewHelper();
			dAACompensateViewHelper.setPrpLcompensateDtoToView(httpServletRequest, workFlowQueryDto);
			// ȡ��forward
			forward = BusinessRuleUtil.getForward(httpServletRequest, riskCode, "endca", editType, 1);
			saveToken(httpServletRequest);
		} catch (UserException usee) {
			usee.printStackTrace();
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.endcaseBeforeEdit.titleName");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			// ������Ϣ����
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.endcaseBeforeEdit.titleName");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		}
		return actionMapping.findForward(forward);
	}
}
