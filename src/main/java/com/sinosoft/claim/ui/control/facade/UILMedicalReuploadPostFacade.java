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
			 * 1 从中间表获取数据，判断数据有效性 2 判断轨迹表中是否存在该数据，不存在则说明报案失败，需要从报案开始 3
			 * 若轨迹表中存在该数据，判断当前节点在轨迹表中是否已经上传成功，若成功不需要补传 4
			 * 若不成功，查看当前节点上一个节点是否上传成功，若不成功返回提示 5 调用自动理赔的环节服务接口
			 **/
			if(null == nodeType || "".equals(nodeType)){
				returnMessage = "请先选择补传节点类型";
			}else if(null == reuploadNode || "".equals(reuploadNode)) {
				returnMessage = "请先选择补传节点";
			}else if((null == registNo || "".equals(registNo)) 
					&& (null == interId || "".equals(interId)) 
					&& (null == outId || "".equals(outId))){
				returnMessage = "查询条件不能同时为空";
			}else {
				if(nodeType.equals("claim")){
					if (uiMedicalReloadClaimViewHelper.checkExists(registNo,interId,outId)) {
						if (uiMedicalReloadClaimViewHelper.checkExistsDetail()) {
							// 存在轨迹表
							returnMessage = uiMedicalReloadClaimViewHelper.checkExcuteNode(reuploadNode);
						} else {
							// 不存在轨迹表，只能从报案开始补传
							if ("regis".equals(reuploadNode)) {
								// 补传报案接口
								try {
									new UIMedicalAutoRegistSubViewHelper().autoRegist(uiMedicalReloadClaimViewHelper
													.getPrpLinterRequestDto());
									returnMessage = "报案接口补传成功";
								} catch (Exception e) {
									e.printStackTrace();
									returnMessage = "报案接口补传失败：" + e.getMessage();
								}
							} else {
								returnMessage = "该案件报案环节未完成流转，请先补传报案接口";
							}
						}
					}else {
						returnMessage = "没有在中间表中找到有效数据，请检查查询条件。";
					}
				}else if(nodeType.equals("cancel")){
					if (uiMedicalReloadCancelViewHelper.checkExists(registNo,interId,outId)) {
						if (uiMedicalReloadCancelViewHelper.checkExistsDetail()) {
							// 存在轨迹表
							returnMessage = uiMedicalReloadCancelViewHelper.checkExcuteNode(reuploadNode);
						} else {
							// 不存在轨迹表，只能从报案开始补传
							if ("registCancel".equals(reuploadNode)) {
								// 补传报案注销接口
								try {
									PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto = uiMedicalReloadCancelViewHelper.getPrpLinterCancelClaimRequestDto();
									//更新报案注销标识
									prpLinterCancelClaimRequestDto.setCancelFlag(true);
									new UIMedicalAutoRegistCancleSubViewHelpe().autoRegistCancel(prpLinterCancelClaimRequestDto);
									returnMessage = "报案注销接口补传成功";
								} catch (Exception e) {
									e.printStackTrace();
									returnMessage = "报案注销接口补传失败：" + e.getMessage();
								}
							}else if("claimCancel".equals(reuploadNode)){
								// 补传立案注销申请接口
								try {
									PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto = uiMedicalReloadCancelViewHelper.getPrpLinterCancelClaimRequestDto();
									//更新报案注销标识
									prpLinterCancelClaimRequestDto.setCancelFlag(true);
									new UIMedicalAutoRegistCancleSubViewHelpe().autoClaimCancel(prpLinterCancelClaimRequestDto);
									returnMessage = "立案注销申请接口补传成功";
								} catch (Exception e) {
									e.printStackTrace();
									returnMessage = "立案注销申请接口补传失败：" + e.getMessage();
								} 
							}else {
								returnMessage = "该案件立案注销申请环节未补传，请先补传。";
							}
						}
					}else {
						returnMessage = "没有在中间表中找到该对应数据，请检查查询条件。";
					}
				}else if(nodeType.equals("recase")){
					if (uiMedicalReloadRecaseViewHelper.checkExists(registNo,interId,outId)) {
						if (uiMedicalReloadRecaseViewHelper.checkExistsDetail()) {
							// 存在轨迹表
							returnMessage = uiMedicalReloadRecaseViewHelper.checkExcuteNode(reuploadNode);
						} else {
							// 不存在轨迹表，只能从重开赔案申请开始补传
							if ("recaseApply".equals(reuploadNode)) {
								// 补传重开赔案申请接口
								try {
									PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = null;
									//数据转换，获取前期的关联数据
									try {
										prpLinterRecaseRequestDto = new UIMedicalClaimRecaseViewHelper().getRecaseDtoMain(uiMedicalReloadRecaseViewHelper.getPrpLinterRecaseRequestDto());
									} catch (Exception e) {
										e.printStackTrace();
										returnMessage = "数据转换出错：" + e.toString();
									}
									new UIMedicalAutoRecaseSubViewHelper().autoRecase(prpLinterRecaseRequestDto);
									returnMessage = "重开赔案申请接口补传成功";
								} catch (Exception e) {
									e.printStackTrace();
									returnMessage = "重开赔案申请接口补传失败：" + e.getMessage();
								}
							} else {
								returnMessage = "该案件重开赔案申请环节未完成流转，请先补传重开赔案申请接口";
							}
						}
					}else {
						returnMessage = "没有在中间表中找到该对应数据，请检查查询条件。";
					}
				}else if(nodeType.equals("pay")){
					if (uiMedicalReloadPaylViewHelper.checkExists(registNo,interId,outId)) {
						if (uiMedicalReloadPaylViewHelper.checkExistsDetail()) {
							// 存在轨迹表
							returnMessage = uiMedicalReloadPaylViewHelper.checkExcuteNode(reuploadNode);
						} else {
							// 不存在轨迹表，只能从三方支付申请开始补传
							if ("payApply".equals(reuploadNode)) {
								// 补传三方支付申请接口
								try {
									new UIMedicalAutoPaySubViewHelper().autoPay(uiMedicalReloadPaylViewHelper
													.getPrpLinterPayRequestDto());
									returnMessage = "三方支付申请接口补传成功";
								} catch (Exception e) {
									e.printStackTrace();
									returnMessage = "三方支付申请接口补传失败：" + e.getMessage();
								}
							} else {
								returnMessage = "该案件三方支付申请环节未完成流转，请先补传三方支付申请接口";
							}
						}
					}else {
						returnMessage = "没有在中间表中找到该对应数据，请检查查询条件。";
					}
				}else if (nodeType.equals("payDelete")){
					BLPrpLinterPayDeleteRequestFacade blPrpLinterPayDeleteRequestFacade = new BLPrpLinterPayDeleteRequestFacade();
					if(blPrpLinterPayDeleteRequestFacade.getOutIdIfSyn(outId)){
						blPrpLinterPayDeleteRequestFacade.payDeleteByPro(outId);
					}else{
						returnMessage = "没有在中间表中找到该对应数据或该数据已同步成功，请检查查询条件。";
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
			// 错误信息处理
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
