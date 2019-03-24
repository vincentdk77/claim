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
 * 分发HTTP GET 车险理赔结案前查询保单请求
 * <p>
 * Title: 车险理赔结案前查询保单信息
 * </p>
 * <p>
 * Description: 车险理赔结案前查询保单信息系统样本程序
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

		// 业务类型：ADD-新增 EDIT-修改 SHOW-显示
//		add by lym 20060809 start for （特殊赔案：垫支付）
		String dfFlag = httpServletRequest.getParameter("dfFlag");
		httpServletRequest.setAttribute("dfFlag",dfFlag);
//		add by lym 20060809 end for （特殊赔案：垫支付）	
		String editType = httpServletRequest.getParameter("editType");
		String claimNo = httpServletRequest.getParameter("ClaimNo"); // 赔案号
 		String caseNo = ""; // 赔案号
		String riskCode = httpServletRequest.getParameter("riskCode"); // 险种
		String forward = ""; // 向前
		try { 
			HttpSession session = httpServletRequest.getSession();
			UserDto user = (UserDto) session.getAttribute("user"); // 用户信息

			// 尚未加入type异常处理{}、其它必须参数异常处理{}
			// 1.查询立案信息,整理输入，用于初始界面显示
			if (editType.equals("ADD")) {
				
				DAAEndcaseViewHelper dAAEndcaseViewHelper = new DAAEndcaseViewHelper();
				boolean blnRecaseFlag = dAAEndcaseViewHelper.checkRecase(claimNo); //是否重开赔案，且已结案
			
				// 立案已经结案的不许再进行结案登记
				boolean blnEndcaseFlag = dAAEndcaseViewHelper.checkEndcase(claimNo);
				if (blnEndcaseFlag == true  &&  blnRecaseFlag ==true) {  //增加了重开赔案是否也已经结案的判断
					ActionMessages messages = new ActionMessages();
					messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("title.endcaseEidt.alreadyEndcase"));
					saveMessages(httpServletRequest, messages);
					return actionMapping.findForward("success");
				}
				
				
				// **************判断保费是否已经实收add by qinyongli 2005-7-21
				UIPolicyAction uiPolicyAction = new UIPolicyAction();
				UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();
				EndcaseDto endcaseDto = uiEndcaseAction.findByPrimaryKey(claimNo);
				String conditions1 = " policyno = '" + endcaseDto.getPrpLclaimDto().getPolicyNo() + "'";
				int intReturn = 0;
				intReturn = uiPolicyAction.checkPay(conditions1);// -1为未缴费，-2为未缴全，1为缴全
				// 获取系统设置信息
				UIConfigAction uiConfigAction = new UIConfigAction();
				String configValue = ""; // 获取保费未实收是否允许结案
				configValue = uiConfigAction.getConfigValue("ALLOW_UNPAYED_ENDCASE", endcaseDto.getPrpLclaimDto().getRiskCode());
				if (configValue == null || configValue.equals("")) {
					throw new UserException(1, 3, "platform", "请联系系统管理员，在平台配置系统中进行险种"
							+ endcaseDto.getPrpLclaimDto().getRiskCode() + "'保费未实收是否允许结案'的初始化！");

				}

				// modify by liuyanmei add 20051110 start==================
				// reason:判断是否录入支付信息，没有录入支付信息不能结案
				System.out.println("开始判断特殊赔案的部分1");
				int planFeeFlag = 0;
   //add by lym 20060809 start for （特殊赔案：垫支付）	
			if (dfFlag !=null && !dfFlag.equals("") && dfFlag.equals("Y")){
			}else {
	//add by lym 20060809 end for （特殊赔案：垫支付）

				planFeeFlag = dAAEndcaseViewHelper.checkPlanFeeFlag(httpServletRequest, claimNo);
				//modify by lixiang start at 2006-08-31
				//reason:这个是做什么用的呢？ 而且没有提示，所以先注释掉了。。否则不知道原因：
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
			System.out.println("开始判断特殊赔案的部分2");
				// 如果configValue =2 intReturn！=1则表示未交费结案
				//if (configValue.equals("2") && intReturn != 1) {
					//throw new UserException(1, 3, "endcase", "保费未实收，系统不允许结案！"+ intReturn);
				//}
			httpServletRequest.setAttribute("planFeeFlag", intReturn);
				// *******************************************add end
				// 取得赔款计算书是否通过的信息
				 //add by lym 20060809 start for （特殊赔案：垫支付）
				System.out.println("开始判断特殊赔案的部分3");
				
			if (dfFlag !=null && !dfFlag.equals("") && dfFlag.equals("Y")){
			}else {
				 //add by lym 20060809 end for （特殊赔案：垫支付）			
				int intCompensateFlag = dAAEndcaseViewHelper.checkCompensate(httpServletRequest, claimNo);
				
				if (intCompensateFlag == 0) { //有问题，如果是垫付，不应该有计算书的，这个是怎么考虑的。
					throw new UserException(1, 3, "endcase", "此立案"+endcaseDto.getPrpLclaimDto().getClaimNo() +"没有赔款计算书，不能结案！");
						}

				if (intCompensateFlag < 0) {
					throw new UserException(1, 3, "endcase", "有没有核赔通过的计算书，不能结案！");
				}
			}
			System.out.println("开始判断特殊赔案的部分4");
				// ==================================================
				// 进行占号分析，只有当有工作流号码和LogNo的时候才能使用。
				// 如果没有flowID和logno则不进行判断。
				String flowID = httpServletRequest.getParameter("swfLogFlowID");
				String logNo = httpServletRequest.getParameter("swfLogLogNo");
				if (flowID != null && logNo != null) {
					UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
					SwfLogDto swfLogDto = new SwfLogDto();
					swfLogDto = uiWorkFlowAction.holdNode(flowID, Integer.parseInt(logNo), user.getUserCode(), user.getUserName());
					if (swfLogDto.getHoldNode() == false) {
						String msg = "案件'" + claimNo + "'已经被代码:'" + swfLogDto.getHandlerCode() + "',名称:'"
								+ swfLogDto.getHandlerName() + "'的用户所占用,请选择其它案件进行处理!";
						throw new UserException(1, 3, "工作流", msg);
					}
				}
				// ==================================================
				dAAEndcaseViewHelper.claimDtoToView(httpServletRequest, claimNo, editType);

				// modify by wangli add start 20050418
				if (riskCode == null || riskCode.length() < 1 || riskCode.trim().equals("")) {
					riskCode = BusinessRuleUtil.getRiskCode(claimNo,"ClaimNo");
				}
				
			}
			// 查询结案信息,整理输入，用于初始界面显示
			if (editType.equals("EDIT") || editType.equals("SHOW")) {
				claimNo = httpServletRequest.getParameter("prpLendcaseEndcaseNo"); // 结案号
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
			// 取得forward
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
			// 错误信息处理
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
