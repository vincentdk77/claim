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
		//ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
		
		System.err.println("�����ط�");
		
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
				//�ط�
				if("sched".equals(nodeType) || "endca".equals(nodeType)){
					daaReturnVisitViewHelper.findreturnVisitList(request);
					request.setAttribute("user", user);
					forward = "addPage";
				}
			}
			//�طò�ѯ
			
			if ("SHOWADD".equals(editType)) {
				forward = "success";
				String conditions = daaReturnVisitViewHelper.showViewToList(request,"");//ƴ�Ӳ�ѯ����
				ArrayList<PrplreturnvisitswflogDto> prplreturnvisitswflogDtoList = daaReturnVisitViewHelper.showReturnVisitList(request, conditions);
				request.setAttribute("prplreturnvisitswflogDtoList", prplreturnvisitswflogDtoList);
				editType = "ADD";
			}
			//Ͷ�߲�ѯҳ��
			if("dealWith".equals(editType)){
				nodeTypes = "dealWith";
			}
			//Ͷ�߲�ѯ���
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
			//ͨ�������Ż�ȡswfLogFlowID
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
