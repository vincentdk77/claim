package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLinterPayDeleteRequestFacade;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoCancelClaimViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoPaySubViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoRecaseSubViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoRegistCancleSubViewHelpe;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoRegistSubViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalClaimRecaseViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalReloadCancelViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalReloadClaimViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalReloadPaylViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalReloadRecaseViewHelper;

public class UILMedicalReuploadPostFacade extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String forward = "success";
		String registNo = request.getParameter("registNo");
		String interId = request.getParameter("interId");
		String outId = request.getParameter("outId");
		String nodeType = request.getParameter("nodeType");
		String reuploadNode = request.getParameter("reuploadNode");
		UIMedicalReloadClaimViewHelper uiMedicalReloadClaimViewHelper = new UIMedicalReloadClaimViewHelper();
		UIMedicalReloadCancelViewHelper uiMedicalReloadCancelViewHelper = new UIMedicalReloadCancelViewHelper();
		UIMedicalReloadRecaseViewHelper uiMedicalReloadRecaseViewHelper = new UIMedicalReloadRecaseViewHelper();
		UIMedicalReloadPaylViewHelper uiMedicalReloadPaylViewHelper = new UIMedicalReloadPaylViewHelper();
		String returnMessage = "";
		try {
			
			/**
			 * 1 ���м���ȡ���ݣ��ж�������Ч�� 2 �жϹ켣�����Ƿ���ڸ����ݣ���������˵������ʧ�ܣ���Ҫ�ӱ�����ʼ 3
			 * ���켣���д��ڸ����ݣ��жϵ�ǰ�ڵ��ڹ켣�����Ƿ��Ѿ��ϴ��ɹ������ɹ�����Ҫ���� 4
			 * �����ɹ����鿴��ǰ�ڵ���һ���ڵ��Ƿ��ϴ��ɹ��������ɹ�������ʾ 5 �����Զ�����Ļ��ڷ���ӿ�
			 **/
			if(null == nodeType || "".equals(nodeType)){
				returnMessage = "����ѡ�񲹴��ڵ�����";
			}else if(null == reuploadNode || "".equals(reuploadNode)) {
				returnMessage = "����ѡ�񲹴��ڵ�";
			}else if((null == registNo || "".equals(registNo)) 
					&& (null == interId || "".equals(interId)) 
					&& (null == outId || "".equals(outId))){
				returnMessage = "��ѯ��������ͬʱΪ��";
			}else {
				if(nodeType.equals("claim")){
					if (uiMedicalReloadClaimViewHelper.checkExists(registNo,interId,outId)) {
						if (uiMedicalReloadClaimViewHelper.checkExistsDetail()) {
							// ���ڹ켣��
							returnMessage = uiMedicalReloadClaimViewHelper.checkExcuteNode(reuploadNode);
						} else {
							// �����ڹ켣��ֻ�ܴӱ�����ʼ����
							if ("regis".equals(reuploadNode)) {
								// ���������ӿ�
								try {
									new UIMedicalAutoRegistSubViewHelper().autoRegist(uiMedicalReloadClaimViewHelper
													.getPrpLinterRequestDto());
									returnMessage = "�����ӿڲ����ɹ�";
								} catch (Exception e) {
									e.printStackTrace();
									returnMessage = "�����ӿڲ���ʧ�ܣ�" + e.getMessage();
								}
							} else {
								returnMessage = "�ð�����������δ�����ת�����Ȳ��������ӿ�";
							}
						}
					}else {
						returnMessage = "û�����м�����ҵ���Ч���ݣ������ѯ������";
					}
				}else if(nodeType.equals("cancel")){
					if (uiMedicalReloadCancelViewHelper.checkExists(registNo,interId,outId)) {
						if (uiMedicalReloadCancelViewHelper.checkExistsDetail()) {
							// ���ڹ켣��
							returnMessage = uiMedicalReloadCancelViewHelper.checkExcuteNode(reuploadNode);
						} else {
							// �����ڹ켣��ֻ�ܴӱ�����ʼ����
							if ("registCancel".equals(reuploadNode)) {
								// ��������ע���ӿ�
								try {
									PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto = uiMedicalReloadCancelViewHelper.getPrpLinterCancelClaimRequestDto();
									//���±���ע����ʶ
									prpLinterCancelClaimRequestDto.setCancelFlag(true);
									new UIMedicalAutoRegistCancleSubViewHelpe().autoRegistCancel(prpLinterCancelClaimRequestDto);
									returnMessage = "����ע���ӿڲ����ɹ�";
								} catch (Exception e) {
									e.printStackTrace();
									returnMessage = "����ע���ӿڲ���ʧ�ܣ�" + e.getMessage();
								}
							}else if("claimCancel".equals(reuploadNode)){
								// ��������ע������ӿ�
								try {
									PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto = uiMedicalReloadCancelViewHelper.getPrpLinterCancelClaimRequestDto();
									//���±���ע����ʶ
									prpLinterCancelClaimRequestDto.setCancelFlag(true);
									new UIMedicalAutoRegistCancleSubViewHelpe().autoClaimCancel(prpLinterCancelClaimRequestDto);
									returnMessage = "����ע������ӿڲ����ɹ�";
								} catch (Exception e) {
									e.printStackTrace();
									returnMessage = "����ע������ӿڲ���ʧ�ܣ�" + e.getMessage();
								} 
							}else {
								returnMessage = "�ð�������ע�����뻷��δ���������Ȳ�����";
							}
						}
					}else {
						returnMessage = "û�����м�����ҵ��ö�Ӧ���ݣ������ѯ������";
					}
				}else if(nodeType.equals("recase")){
					if (uiMedicalReloadRecaseViewHelper.checkExists(registNo,interId,outId)) {
						if (uiMedicalReloadRecaseViewHelper.checkExistsDetail()) {
							// ���ڹ켣��
							returnMessage = uiMedicalReloadRecaseViewHelper.checkExcuteNode(reuploadNode);
						} else {
							// �����ڹ켣��ֻ�ܴ��ؿ��ⰸ���뿪ʼ����
							if ("recaseApply".equals(reuploadNode)) {
								// �����ؿ��ⰸ����ӿ�
								try {
									PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = null;
									//����ת������ȡǰ�ڵĹ�������
									try {
										prpLinterRecaseRequestDto = new UIMedicalClaimRecaseViewHelper().getRecaseDtoMain(uiMedicalReloadRecaseViewHelper.getPrpLinterRecaseRequestDto());
									} catch (Exception e) {
										e.printStackTrace();
										returnMessage = "����ת������" + e.toString();
									}
									new UIMedicalAutoRecaseSubViewHelper().autoRecase(prpLinterRecaseRequestDto);
									returnMessage = "�ؿ��ⰸ����ӿڲ����ɹ�";
								} catch (Exception e) {
									e.printStackTrace();
									returnMessage = "�ؿ��ⰸ����ӿڲ���ʧ�ܣ�" + e.getMessage();
								}
							} else {
								returnMessage = "�ð����ؿ��ⰸ���뻷��δ�����ת�����Ȳ����ؿ��ⰸ����ӿ�";
							}
						}
					}else {
						returnMessage = "û�����м�����ҵ��ö�Ӧ���ݣ������ѯ������";
					}
				}else if(nodeType.equals("pay")){
					if (uiMedicalReloadPaylViewHelper.checkExists(registNo,interId,outId)) {
						if (uiMedicalReloadPaylViewHelper.checkExistsDetail()) {
							// ���ڹ켣��
							returnMessage = uiMedicalReloadPaylViewHelper.checkExcuteNode(reuploadNode);
						} else {
							// �����ڹ켣��ֻ�ܴ�����֧�����뿪ʼ����
							if ("payApply".equals(reuploadNode)) {
								// ��������֧������ӿ�
								try {
									new UIMedicalAutoPaySubViewHelper().autoPay(uiMedicalReloadPaylViewHelper
													.getPrpLinterPayRequestDto());
									returnMessage = "����֧������ӿڲ����ɹ�";
								} catch (Exception e) {
									e.printStackTrace();
									returnMessage = "����֧������ӿڲ���ʧ�ܣ�" + e.getMessage();
								}
							} else {
								returnMessage = "�ð�������֧�����뻷��δ�����ת�����Ȳ�������֧������ӿ�";
							}
						}
					}else {
						returnMessage = "û�����м�����ҵ��ö�Ӧ���ݣ������ѯ������";
					}
				}else if (nodeType.equals("payDelete")){
					BLPrpLinterPayDeleteRequestFacade blPrpLinterPayDeleteRequestFacade = new BLPrpLinterPayDeleteRequestFacade();
					if(blPrpLinterPayDeleteRequestFacade.getOutIdIfSyn(outId)){
						blPrpLinterPayDeleteRequestFacade.payDeleteByPro(outId);
					}else{
						returnMessage = "û�����м�����ҵ��ö�Ӧ���ݻ��������ͬ���ɹ��������ѯ������";
					}
				}
			}

			request.setAttribute("registNo", registNo);
			request.setAttribute("interId", interId);
			request.setAttribute("outId", outId);
			request.setAttribute("returnMessage", returnMessage);
			request.setAttribute("nodeType", nodeType);

		
		
		
		
		
		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			// ������Ϣ����
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError(

			"title.registBeforeEdit.editRegist");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			request.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(request, errors);
			forward = "error";
		}
		return mapping.findForward(forward);
	}

}
