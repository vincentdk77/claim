package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.bl.facade.BLPrpLendorFacade;
import com.sinosoft.claim.dto.custom.EndorDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLendorDto;
import com.sinosoft.claim.ui.control.action.UIEndorAction;
import com.sinosoft.claim.ui.control.viewHelper.EndorViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.utility.SysConfig;
import com.sinosoft.utility.string.Str;

/**
 * 分发HTTP GET 冲减保额
 * <p>冲减保额登</p>
 * <p>车险理赔冲减保额</p>
 * @author liubvo
 * @version 1.0
 */
public class UILEndorFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {

		// 业务类型：ADD-初始化 SAVE-冲减保额
		String editType = httpServletRequest.getParameter("editType");
		String compensateNo = "";
		String claimNo = ""; // 赔案号
		String forward = ""; // 向前
		
		try {
			claimNo = httpServletRequest.getParameter("ClaimNo");
			compensateNo = httpServletRequest.getParameter("CompensateNo");
			if (claimNo == null) {
				claimNo = "";
			} else {
				claimNo = claimNo.trim();
			}
			if (compensateNo == null) {
				compensateNo = "";
			} else {
				compensateNo = compensateNo.trim();
			}
			// add by fenglei 2008-07-25 设置不能进行冲减保额的 险种
			if (claimNo != null && !"".equals(claimNo)) {
				String riskCode = claimNo.substring(1, 5);
				String taskCode = SysConfig.getProperty("FORBID_REDUCE_AMOUNT",
						"claim");// 禁止冲减保额的 险种
				if (taskCode.indexOf(riskCode) > -1) {
					throw new Exception("险种" + riskCode + "禁止做冲减保额操作！");
				}
			}
			if (compensateNo != null && !"".equals(compensateNo)) {
				String riskCode = compensateNo.substring(1, 5);
				String taskCode = SysConfig.getProperty("FORBID_REDUCE_AMOUNT",
						"claim");// 禁止冲减保额的 险种
				if (taskCode.indexOf(riskCode) > -1) {
					throw new Exception("险种" + riskCode + "禁止做冲减保额操作！");
				}
			}
			// end by fenglei 2008-07-25 设置不能进行冲减保额的 险种
			HttpSession session = httpServletRequest.getSession();
			UserDto user = (UserDto) session.getAttribute("user");
			// 尚未加入type异常处理{}、其它必须参数异常处理{}
			if (editType.equals("reducePre")) {
				EndorViewHelper endorViewHelper = new EndorViewHelper();
				endorViewHelper.prepayDataToView(httpServletRequest, claimNo, compensateNo);
				if (claimNo.length() > 0) {
					if (claimNo.substring(9, 11).equals("05")) {
						forward = "EDITENDORDAA";
					} else {
						if ((claimNo.substring(1, 3).equals("31") || claimNo.substring(1, 3)
								.equals("32"))
								&& !claimNo.substring(1, 5).equals("3119")) {
							forward = "EDITENDORNOAGRI";
						} else {
							forward = "EDITENDORNODAA";
						}
					}
				}
				if (compensateNo.length() > 0) {
					if (compensateNo.substring(9, 11).equals("05")) {
						forward = "EDITENDORDAA";
					} else {
						if ((compensateNo.substring(1, 3).equals("31") || compensateNo.substring(1,
								3).equals("32"))
								&& !compensateNo.substring(1, 5).equals("3119")) {
							forward = "EDITENDORNOAGRI";
						} else {
							forward = "EDITENDORNODAA";
						}
					}
				}
			} else if (editType.equals("addPre")) {
				EndorViewHelper endorViewHelper = new EndorViewHelper();
				endorViewHelper.addPreDataToView(httpServletRequest, claimNo, compensateNo);
				forward = "EDITADDPRE";
			}
			if (editType.equals("SAVE")) {
				// 查询预赔信息,整理输入，用于初始界面显示
				EndorViewHelper endorViewHelper = new EndorViewHelper();

				EndorDto endorDto = endorViewHelper.viewToDto(httpServletRequest);
				// 为了生成批单用
				forward = "GENENDORSE";
				if (claimNo.length() > 0) {
					if ((claimNo.substring(1, 3).equals("31") || claimNo.substring(1, 3).equals(
							"32"))
							&& !claimNo.substring(1, 5).equals("3119")) {
						forward = "AGRIGENENDORSE";
					}
				}
				// 将冲减保额和批改放在一起，这里暂存信息
				UIEndorAction uiEndorAction = new UIEndorAction();
				uiEndorAction.save(endorDto);
				// 根据prplendor表中的标志位判断是否进行了冲减保额,在冲减完保额后再修改标志位2005-10-21
				// 以下将标志位改为 1
				ArrayList endorList = endorDto.getPrpLendorList();
				ArrayList endorNewList = new ArrayList();
				Iterator endorLists = endorList.iterator();
				while (endorLists.hasNext()) {
					PrpLendorDto prpLendorDto = new PrpLendorDto();
					prpLendorDto = (PrpLendorDto) endorLists.next();
					prpLendorDto.setFlag("0");
					endorNewList.add(prpLendorDto);
				}
				endorDto.setPrpLendorList(endorNewList);
				httpServletRequest.setAttribute("endorDto", endorDto);
				// add end
				ActionMessages messages = new ActionMessages();
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"prompt.policymoney.save"));
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"db.prpLprepay.claimNo"));
				saveMessages(httpServletRequest, messages);
				user.setUserMessage(claimNo);

			} else if (editType.equals("ADDPRESAVE")) {
				EndorViewHelper endorViewHelper = new EndorViewHelper();
				EndorDto endorDto = endorViewHelper.viewToDto(httpServletRequest);
				UIEndorAction uiEndorAction = new UIEndorAction();
				uiEndorAction.save(endorDto);
				// 以下将标志位改为 2
				ArrayList endorList = endorDto.getPrpLendorList();
				ArrayList endorNewList = new ArrayList();
				PrpLendorDto prpLendorDto = new PrpLendorDto();
				Iterator endorLists = endorList.iterator();
				while (endorLists.hasNext()) {
					prpLendorDto = (PrpLendorDto) endorLists.next();
					prpLendorDto.setFlag("2");
					endorNewList.add(prpLendorDto);
				}
				endorDto.setPrpLendorList(endorNewList);
				httpServletRequest.setAttribute("endorDto", endorDto);
				ActionMessages messages = new ActionMessages();
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"prompt.policymoney.save"));
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"db.prpLprepay.claimNo"));
				saveMessages(httpServletRequest, messages);
				user.setUserMessage(claimNo);
				forward = "ADDPREENDORSE";
			}

			if (editType.equals("SAVEENDORSE")) {
				//add fenglei 2008-07-23在这里增加控制,将Prplendor表中的 flag字段修改为1
				BLPrpLendorFacade blPrpLendorFacade = new BLPrpLendorFacade();
				String conditions="claimNo='"+ claimNo+"'";
				Collection PrpLendorDtoList = blPrpLendorFacade.findByConditions(conditions);
		    	 if (PrpLendorDtoList!=null &&PrpLendorDtoList.size()>0 ) {
		    	 	Iterator it = PrpLendorDtoList.iterator();
		    	 	  while(it.hasNext()){
		    	 		 PrpLendorDto prpLendorDto = (PrpLendorDto)it.next();
		    	 		prpLendorDto.setFlag("1");
		    	 		blPrpLendorFacade.update(prpLendorDto);
		    	       }
		    	 }
				//end fenglei 2008-07-23在这里增加控制,将Prplendor表中的 flag字段修改为1
				forward = "SAVEENDORSE";
			}
			saveToken(httpServletRequest);
		} catch (UserException usee) {
			usee.printStackTrace();
			// 错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("title.endcaseBeforeEdit.titleName");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", usee.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			// 错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("title.endcaseBeforeEdit.titleName");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";

		} finally {

		}

		return actionMapping.findForward(forward);
	}
}
