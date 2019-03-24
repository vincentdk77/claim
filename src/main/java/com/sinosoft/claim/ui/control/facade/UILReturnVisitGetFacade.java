package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrplcomplaintDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAReturnVisitViewHelper;

public class UILReturnVisitGetFacade extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//业务类型：ADD-新增  EDIT-修改  SHOW-显示
		
		System.err.println("新增回访");
		
		String forward = "showPage";
		String editType = request.getParameter("editType");
		String nodeType = request.getParameter("nodeType");
		String nodeTypes = request.getParameter("nodeTypes");
		String nodeMark = request.getParameter("nodeMark");
		HttpSession session = request.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		UICodeAction uiCodeAction = new UICodeAction();
		try {
			DAAReturnVisitViewHelper daaReturnVisitViewHelper = new DAAReturnVisitViewHelper();
			request.getSession().removeAttribute("oldprplreturnvisitAccessedTime");
			if("ADD".equals(editType) || "SHOW".equals(editType)){
				//回访
				if("sched".equals(nodeType) || "endca".equals(nodeType)){
					daaReturnVisitViewHelper.findreturnVisitList(request);
					request.setAttribute("user", user);
					forward = "addPage";
				}
			}
			//回访查询
			
			if ("SHOWADD".equals(editType)) {
				forward = "success";
				String conditions = daaReturnVisitViewHelper.showViewToList(request,"");//拼接查询条件
				ArrayList<PrplreturnvisitswflogDto> prplreturnvisitswflogDtoList = daaReturnVisitViewHelper.showReturnVisitList(request, conditions);
				request.setAttribute("prplreturnvisitswflogDtoList", prplreturnvisitswflogDtoList);
				editType = "ADD";
			}
			//投诉查询页面
			if("dealWith".equals(editType)){
				nodeTypes = "dealWith";
			}
			//投诉查询结果
			if("dealWithADD".equals(editType)){
				forward = "dealWith";
				String conditions = daaReturnVisitViewHelper.showViewToList(request,"34");
				ArrayList<PrplcomplaintDto> prplcomplaintDtoList = daaReturnVisitViewHelper.showDealWithDtoList(request, conditions);
				for(PrplcomplaintDto prplcomplaintDto : prplcomplaintDtoList){
					String bycomplaintcomcodeName = uiCodeAction.translateComCode(prplcomplaintDto.getBycomplaintcomcode(), true);
					prplcomplaintDto.setBycomplaintcomcodeName(bycomplaintcomcodeName);
				}
				request.setAttribute("prplcomplaintDtoList", prplcomplaintDtoList);
				nodeType = "dealWith";
				editType = "ADD";
			}
			//通过报案号获取swfLogFlowID
			String registNo = request.getParameter("registNo");
			if(registNo != null && !"".equals(registNo)){
				BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
				ArrayList<SwfLogDto> swfLogDtoList = (ArrayList<SwfLogDto>) blSwfLogFacade.findByConditions(" registNo='"+registNo+"'");
				String swfLogFlowID = "";
				if(swfLogDtoList.size() > 0){
					swfLogFlowID = swfLogDtoList.get(0).getFlowID();
				}else{
					BLSwfLogStoreFacade blSwfLogStoreFacade = new BLSwfLogStoreFacade();
					swfLogDtoList = (ArrayList<SwfLogDto>) blSwfLogStoreFacade.findByConditions(" registNo='"+registNo+"'");
					if(swfLogDtoList.size() > 0){
						swfLogFlowID = swfLogDtoList.get(0).getFlowID();
					}
				}
				request.setAttribute("swfLogFlowID", swfLogFlowID);
			}
			request.setAttribute("editType", editType);
			request.setAttribute("nodeType", nodeType);
			request.setAttribute("nodeTypes", nodeTypes);
			request.setAttribute("registNo", registNo);
			request.setAttribute("nodeMark", nodeMark);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return mapping.findForward(forward);
	}

}
