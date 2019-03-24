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
 * 分发HTTP GET 调查记录
 * <p>
 * Title: 调查记录查询信息
 * </p>
 */

public class UIPrpLacciCheckQueryFacade extends Action {
    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        //业务类型：ADD-新增 EDIT-修改 SHOW-显示
        String editType = httpServletRequest.getParameter("editType");
        String pageFlag = httpServletRequest.getParameter("pageFlag");
        String policyNo = httpServletRequest.getParameter("PolicyNo"); //保单号
        String registNo = httpServletRequest.getParameter("RegistNo"); //报案号
        //Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件
        String licenseNo = httpServletRequest.getParameter("LicenseNo"); //车牌号
        String status = httpServletRequest.getParameter("caseFlag"); //案件状态
        String operateDate = httpServletRequest.getParameter("OperateDate");//操作时间
        //	Modify By dongchengliang 2005-05-28 Reason:增加险种查询条件
        String riskCode = httpServletRequest.getParameter("RiskCode");//险种

        String forward = ""; //向前

        try {
            System.out.println("editType="+editType);
            //整理查询条件中的状态去掉status中最后一个逗号
            if (status != null && status.trim().length() > 0) {
                status = status.substring(0, status.length() - 1);
            }
            HttpSession session = httpServletRequest.getSession();
            //尚未加入type异常处理{}、其它必须参数异常处理{}
            //1。报案一般的查询，查询理赔节点状态信息,整理输入，用于初始界面显示
            if (editType.equals("ADD") || editType.equals("EDIT") || editType.equals("SHOW")) {
                //                DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
                //                dAARegistViewHelper.setPrpLregistDtoToView(httpServletRequest, registNo, policyNo, riskCode,
                // licenseNo,
                //                        status, operateDate);
                forward = "success";
            }
            if (editType.equals("LacciCheckBeforeQuery")) {
                //需要进行翻页处理
                //每页显示的行数
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
            //错误信息处理
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