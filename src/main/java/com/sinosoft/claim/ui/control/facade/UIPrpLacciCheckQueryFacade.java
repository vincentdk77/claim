package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.ui.control.viewHelper.PrpLacciCheckViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * �ַ�HTTP GET �����¼
 * <p>
 * Title: �����¼��ѯ��Ϣ
 * </p>
 */

public class UIPrpLacciCheckQueryFacade extends Action {
    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        //ҵ�����ͣ�ADD-���� EDIT-�޸� SHOW-��ʾ
        String editType = httpServletRequest.getParameter("editType");
        String pageFlag = httpServletRequest.getParameter("pageFlag");
        String policyNo = httpServletRequest.getParameter("PolicyNo"); //������
        String registNo = httpServletRequest.getParameter("RegistNo"); //������
        //Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ����
        String licenseNo = httpServletRequest.getParameter("LicenseNo"); //���ƺ�
        String status = httpServletRequest.getParameter("caseFlag"); //����״̬
        String operateDate = httpServletRequest.getParameter("OperateDate");//����ʱ��
        //	Modify By dongchengliang 2005-05-28 Reason:�������ֲ�ѯ����
        String riskCode = httpServletRequest.getParameter("RiskCode");//����

        String forward = ""; //��ǰ

        try {
            System.out.println("editType="+editType);
            //�����ѯ�����е�״̬ȥ��status�����һ������
            if (status != null && status.trim().length() > 0) {
                status = status.substring(0, status.length() - 1);
            }
            HttpSession session = httpServletRequest.getSession();
            //��δ����type�쳣����{}��������������쳣����{}
            //1������һ��Ĳ�ѯ����ѯ����ڵ�״̬��Ϣ,�������룬���ڳ�ʼ������ʾ
            if (editType.equals("ADD") || editType.equals("EDIT") || editType.equals("SHOW")) {
                //                DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
                //                dAARegistViewHelper.setPrpLregistDtoToView(httpServletRequest, registNo, policyNo, riskCode,
                // licenseNo,
                //                        status, operateDate);
                forward = "success";
            }
            if (editType.equals("LacciCheckBeforeQuery")) {
                //��Ҫ���з�ҳ����
                //ÿҳ��ʾ������
                String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
                String pageNo = httpServletRequest.getParameter("pageNo");
                //
                if (pageNo == null || pageNo.trim().equals(""))
                    pageNo = "1";

                PrpLacciCheckViewHelper viewHelper = new PrpLacciCheckViewHelper();
                viewHelper.policyListToView(httpServletRequest,registNo, pageNo, recordPerPage);
                forward = "target1";
            }

        } catch (UserException usee) {
            usee.printStackTrace();
            //������Ϣ����
            ActionErrors errors = new ActionErrors();
            ActionError error = new ActionError("title.registBeforeEdit.queryRegistList");
            errors.add(ActionErrors.GLOBAL_ERROR, error);
            httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
            saveErrors(httpServletRequest, errors);
            forward = "error";
        } catch (Exception e) {
            e.printStackTrace();
            ActionErrors errors = new ActionErrors();
            ActionError error = new ActionError("title.registBeforeEdit.queryRegistList");
            errors.add(ActionErrors.GLOBAL_ERROR, error);
            httpServletRequest.setAttribute("errorMessage", e.getMessage());
            saveErrors(httpServletRequest, errors);
            forward = "error";

        } finally {

        }
        return actionMapping.findForward(forward);
    }

}