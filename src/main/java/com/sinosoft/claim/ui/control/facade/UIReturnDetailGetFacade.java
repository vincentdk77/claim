package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpJpayRefRecFacade;
import com.sinosoft.claim.bl.facade.BLPrpJplanFeeFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpJpayRefRecDto;
import com.sinosoft.claim.dto.domain.PrpJplanFeeDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.viewHelper.DAAReturnVisitViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
public class UIReturnDetailGetFacade extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 业务类型：ADD-新增 EDIT-修改 SHOW-显示
		String forward = "success";
		String registNo = request.getParameter("registNo");
		String nodeType = request.getParameter("nodeType");
		String state = request.getParameter("state");
		String flag = request.getParameter("flag");
		HttpSession session = request.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		try {
			if("BUTTON".equals(flag)){
				/* 案件流程明细 start */
				// 通过报案号获取swfLogFlowID
				String swfLogFlowID = "";
				if (registNo != null && !"".equals(registNo)) {
					BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
					ArrayList<SwfLogDto> swfLogDtoList = (ArrayList<SwfLogDto>) blSwfLogFacade
							.findByConditions(" registNo='" + registNo + "'");

					if (swfLogDtoList.size() > 0) {
						swfLogFlowID = swfLogDtoList.get(0).getFlowID();
					} else {
						BLSwfLogStoreFacade blSwfLogStoreFacade = new BLSwfLogStoreFacade();
						swfLogDtoList = (ArrayList<SwfLogDto>) blSwfLogStoreFacade
								.findByConditions(" registNo='" + registNo + "'");
						if (swfLogDtoList.size() > 0) {
							swfLogFlowID = swfLogDtoList.get(0).getFlowID();
						}
					}
					request.setAttribute("swfLogFlowID", swfLogFlowID);
				}
				// 根据报案号查询工作流程信息
				WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
				workFlowViewHelper.setFlowDtoToView(request, swfLogFlowID);
				/* 案件流程明细 end */
				/* 已回访明细 start */
				DAAReturnVisitViewHelper daaReturnVisitViewHelper = new DAAReturnVisitViewHelper();
				// 回访
				daaReturnVisitViewHelper.findreturnVisitList(request);
				request.setAttribute("user", user);
				request.setAttribute("editType", "SHOW");
				/* 已回访明细 end */
				request.setAttribute("nodeType", nodeType);

			}
					
			/* 支付明细 start */
			if ("endca".equals(nodeType)) {
				String sql = "  pf.certitype in ('C', 'Y') and pf.PayRefReason in ('P50', 'P60')  and pf.claimno in (select claimno from prplclaim where registno = '"
						+ registNo + "')";
				BLPrpJplanFeeFacade blPrpJplanFeeFacade = new BLPrpJplanFeeFacade();
				ArrayList<PrpJplanFeeDto> prpJplanFeeDtoList = (ArrayList<PrpJplanFeeDto>) blPrpJplanFeeFacade.findJoinJpayRefRecByConditions(sql);
				request.setAttribute("prpJplanFeeDtoList",
						prpJplanFeeDtoList);
				if ("TOOL".equals(flag)) {
					request.setAttribute("flag", "TOOL");
					forward = "payTool";
				}
				
			}
			request.setAttribute("registNo", registNo);
			/* 支付明细 end */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward(forward);
	}

}