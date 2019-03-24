package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.ui.control.viewHelper.DAAReturnVisitViewHelper;
/**
 * �ַ�HTTP GET �طò�ѯ
 * <p>Title: �طò�ѯ��Ϣ</p>
 * <p>Description: ��</p>
 * <p>Copyright: Copyright  2011</p>
 * @author chengyupeng
 * @version 1.0
 */
public class UILReturnVisitQueryFacade extends Action{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
		String forward = "";
		String editType = request.getParameter("editType");
		String nodeMark = request.getParameter("nodeMark");
		String excel=request.getParameter("excel");
		try {
			if("ADD".endsWith(editType)){
				forward = "showPage";
			}
			if ("SHOW".equals(editType)&&!"1".equals(excel)) {
				forward = "success";
				String nodeType 			= request.getParameter("nodeType");				//�ط�����
				DAAReturnVisitViewHelper daaReturnVisitViewHelper = new DAAReturnVisitViewHelper();
				String conditions = daaReturnVisitViewHelper.showViewToList(request,"4");
				ArrayList<PrplreturnvisitswflogDto> prplreturnvisitswflogDtoList = daaReturnVisitViewHelper.showReturnVisitList(request, conditions);
				request.setAttribute("prplreturnvisitswflogDtoList",
						prplreturnvisitswflogDtoList);
				request.setAttribute("nodeType", nodeType);
				//request.setAttribute("size", prplreturnvisitswflogDtoList.size());
			}
			if ("1".equals(excel)) {
				forward = "exp";
				String nodeType 			= request.getParameter("nodeType");				//�ط�����
				DAAReturnVisitViewHelper daaReturnVisitViewHelper = new DAAReturnVisitViewHelper();
				String conditions = daaReturnVisitViewHelper.showViewToList(request,"4");
				ArrayList<PrplreturnvisitswflogDto> prplreturnvisitswflogDtoList = daaReturnVisitViewHelper.showAllReturnVisitList(request, conditions);
				request.setAttribute("prplreturnvisitswflogDtoList",
						prplreturnvisitswflogDtoList);
				request.setAttribute("nodeType", nodeType);
				request.setAttribute("editType", editType);
			}
			request.setAttribute("editType", editType);
			//����excel 0������ 1���� 
			request.setAttribute("excel", excel);
			request.setAttribute("nodeMark", nodeMark);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward(forward);
	}
}
