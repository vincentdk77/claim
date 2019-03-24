package com.sinosoft.claim.ui.control.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.claim.ui.model.PrpLacciCheckDeleteCommand;
import com.sinosoft.claim.ui.model.PrpLacciCheckFindByConditionsCommand;
import com.sinosoft.claim.ui.model.PrpLacciCheckFindByPrimaryKeyCommand;
import com.sinosoft.platform.ui.control.action.UIUserProfile;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.ParamUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.web.control.BaseProcessAction;
import com.sinosoft.sysframework.web.view.AbstractForm;

/**
 * PrpLacciCheck处理类
 */
public class UIPrpLacciCheckProcessAction extends BaseProcessAction {
    /**
     * 生成Dto
     * 
     * @param request http请求
     * @return PrpLacciCheckDto
     * @throws Exception
     */
    public PrpLacciCheckDto generateDto(HttpServletRequest request) throws Exception {
        ParamUtils paramUtils = new ParamUtils(request);
        String prpLacciCheckRegistNo = paramUtils.getParameter("prpLacciCheckRegistNo");
        int prpLacciCheckTimes = paramUtils.getIntParameter("prpLacciCheckTimes", 0);
        String prpLacciCheckCheckNo = paramUtils.getParameter("prpLacciCheckCheckNo");
        String prpLacciCheckCertiType = paramUtils.getParameter("prpLacciCheckCertiType");
        String prpLacciCheckCertiNo = paramUtils.getParameter("prpLacciCheckCertiNo");
        String prpLacciCheckRiskCode = paramUtils.getParameter("prpLacciCheckRiskCode");
        String prpLacciCheckPolicyNo = paramUtils.getParameter("prpLacciCheckPolicyNo");
        String prpLacciCheckCheckType = paramUtils.getParameter("prpLacciCheckCheckType");
        String prpLacciCheckCheckContext = paramUtils.getParameter("prpLacciCheckCheckContext");
        String prpLacciCheckCheckObject = paramUtils.getParameter("prpLacciCheckCheckObject");
        String prpLacciCheckCheckObjectDesc = paramUtils.getParameter("prpLacciCheckCheckObjectDesc");
        String prpLacciCheckCheckNature = paramUtils.getParameter("prpLacciCheckCheckNature");
        DateTime prpLacciCheckCheckDate = new DateTime(paramUtils.getParameter("prpLacciCheckCheckDate"),
                DateTime.YEAR_TO_DAY);
        String prpLacciCheckCheckHour = paramUtils.getParameter("prpLacciCheckCheckHour");
        DateTime prpLacciCheckCheckEndDate = new DateTime(paramUtils.getParameter("prpLacciCheckCheckEndDate"),
                DateTime.YEAR_TO_DAY);
        String prpLacciCheckCheckEndHour = paramUtils.getParameter("prpLacciCheckCheckEndHour");
        String prpLacciCheckCheckSite = paramUtils.getParameter("prpLacciCheckCheckSite");
        String prpLacciCheckDamageCode = paramUtils.getParameter("prpLacciCheckDamageCode");
        String prpLacciCheckDamageName = paramUtils.getParameter("prpLacciCheckDamageName");
        String prpLacciCheckDamageTypeCode = paramUtils.getParameter("prpLacciCheckDamageTypeCode");
        String prpLacciCheckDamageTypeName = paramUtils.getParameter("prpLacciCheckDamageTypeName");
        String prpLacciCheckCheckerCode = paramUtils.getParameter("prpLacciCheckCheckerCode");
        String prpLacciCheckApproverCode = paramUtils.getParameter("prpLacciCheckApproverCode");
        DateTime prpLacciCheckApproverDate = new DateTime(paramUtils.getParameter("prpLacciCheckApproverDate"),
                DateTime.YEAR_TO_DAY);
        String prpLacciCheckApproverStatus = paramUtils.getParameter("prpLacciCheckApproverStatus");
        String prpLacciCheckRemark = paramUtils.getParameter("prpLacciCheckRemark");
        String prpLacciCheckFlag = paramUtils.getParameter("prpLacciCheckFlag");

        PrpLacciCheckDto prpLacciCheckDto = new PrpLacciCheckDto();
        prpLacciCheckDto.setRegistNo(prpLacciCheckRegistNo);
        prpLacciCheckDto.setTimes(prpLacciCheckTimes);
        prpLacciCheckDto.setCheckNo(prpLacciCheckCheckNo);
        prpLacciCheckDto.setCertiType(prpLacciCheckCertiType);
        prpLacciCheckDto.setCertiNo(prpLacciCheckCertiNo);
        prpLacciCheckDto.setRiskCode(prpLacciCheckRiskCode);
        prpLacciCheckDto.setPolicyNo(prpLacciCheckPolicyNo);
        prpLacciCheckDto.setCheckType(prpLacciCheckCheckType);
        prpLacciCheckDto.setCheckContext(prpLacciCheckCheckContext);
        prpLacciCheckDto.setCheckObject(prpLacciCheckCheckObject);
        prpLacciCheckDto.setCheckObjectDesc(prpLacciCheckCheckObjectDesc);
        prpLacciCheckDto.setCheckNature(prpLacciCheckCheckNature);
        prpLacciCheckDto.setCheckDate(prpLacciCheckCheckDate);
        prpLacciCheckDto.setCheckHour(prpLacciCheckCheckHour);
        prpLacciCheckDto.setCheckEndDate(prpLacciCheckCheckEndDate);
        prpLacciCheckDto.setCheckEndHour(prpLacciCheckCheckEndHour);
        prpLacciCheckDto.setCheckSite(prpLacciCheckCheckSite);
        prpLacciCheckDto.setDamageCode(prpLacciCheckDamageCode);
        prpLacciCheckDto.setDamageName(prpLacciCheckDamageName);
        prpLacciCheckDto.setDamageTypeCode(prpLacciCheckDamageTypeCode);
        prpLacciCheckDto.setDamageTypeName(prpLacciCheckDamageTypeName);
        prpLacciCheckDto.setCheckerCode(prpLacciCheckCheckerCode);
        prpLacciCheckDto.setApproverCode(prpLacciCheckApproverCode);
        prpLacciCheckDto.setApproverDate(prpLacciCheckApproverDate);
        prpLacciCheckDto.setApproverStatus(prpLacciCheckApproverStatus);
        prpLacciCheckDto.setRemark(prpLacciCheckRemark);
        prpLacciCheckDto.setFlag(prpLacciCheckFlag);

        return prpLacciCheckDto;

    }

    /**
     * 生成Conditions
     * 
     * @param actionForm actionForm
     * @param request http请求
     * @return condtions
     */
    public String generateConditions(HttpServletRequest request) throws Exception {
        ParamUtils paramUtils = new ParamUtils(request);
        String prpLacciCheckRegistNo = paramUtils.getParameter("prpLacciCheckRegistNo");
        String prpLacciCheckTimes = paramUtils.getParameter("prpLacciCheckTimes");
        String prpLacciCheckCheckNo = paramUtils.getParameter("prpLacciCheckCheckNo");
        String prpLacciCheckCertiType = paramUtils.getParameter("prpLacciCheckCertiType");
        String prpLacciCheckCertiNo = paramUtils.getParameter("prpLacciCheckCertiNo");
        String prpLacciCheckRiskCode = paramUtils.getParameter("prpLacciCheckRiskCode");
        String prpLacciCheckPolicyNo = paramUtils.getParameter("prpLacciCheckPolicyNo");
        String prpLacciCheckCheckType = paramUtils.getParameter("prpLacciCheckCheckType");
        String prpLacciCheckCheckContext = paramUtils.getParameter("prpLacciCheckCheckContext");
        String prpLacciCheckCheckObject = paramUtils.getParameter("prpLacciCheckCheckObject");
        String prpLacciCheckCheckObjectDesc = paramUtils.getParameter("prpLacciCheckCheckObjectDesc");
        String prpLacciCheckCheckNature = paramUtils.getParameter("prpLacciCheckCheckNature");
        String prpLacciCheckCheckDate = paramUtils.getParameter("prpLacciCheckCheckDate");
        String prpLacciCheckCheckHour = paramUtils.getParameter("prpLacciCheckCheckHour");
        String prpLacciCheckCheckEndDate = paramUtils.getParameter("prpLacciCheckCheckEndDate");
        String prpLacciCheckCheckEndHour = paramUtils.getParameter("prpLacciCheckCheckEndHour");
        String prpLacciCheckCheckSite = paramUtils.getParameter("prpLacciCheckCheckSite");
        String prpLacciCheckDamageCode = paramUtils.getParameter("prpLacciCheckDamageCode");
        String prpLacciCheckDamageName = paramUtils.getParameter("prpLacciCheckDamageName");
        String prpLacciCheckDamageTypeCode = paramUtils.getParameter("prpLacciCheckDamageTypeCode");
        String prpLacciCheckDamageTypeName = paramUtils.getParameter("prpLacciCheckDamageTypeName");
        String prpLacciCheckCheckerCode = paramUtils.getParameter("prpLacciCheckCheckerCode");
        String prpLacciCheckApproverCode = paramUtils.getParameter("prpLacciCheckApproverCode");
        String prpLacciCheckApproverDate = paramUtils.getParameter("prpLacciCheckApproverDate");
        String prpLacciCheckApproverStatus = paramUtils.getParameter("prpLacciCheckApproverStatus");
        String prpLacciCheckRemark = paramUtils.getParameter("prpLacciCheckRemark");
        String prpLacciCheckFlag = paramUtils.getParameter("prpLacciCheckFlag");

        String conditions = "1=1";
        conditions += SqlUtils.convertString("prpLacciCheck.RegistNo", prpLacciCheckRegistNo);
        conditions += SqlUtils.convertNumber("prpLacciCheck.Times", prpLacciCheckTimes);
        conditions += SqlUtils.convertString("prpLacciCheck.CheckNo", prpLacciCheckCheckNo);
        conditions += SqlUtils.convertString("prpLacciCheck.CertiType", prpLacciCheckCertiType);
        conditions += SqlUtils.convertString("prpLacciCheck.CertiNo", prpLacciCheckCertiNo);
        conditions += SqlUtils.convertString("prpLacciCheck.RiskCode", prpLacciCheckRiskCode);
        conditions += SqlUtils.convertString("prpLacciCheck.PolicyNo", prpLacciCheckPolicyNo);
        conditions += SqlUtils.convertString("prpLacciCheck.CheckType", prpLacciCheckCheckType);
        conditions += SqlUtils.convertString("prpLacciCheck.CheckContext", prpLacciCheckCheckContext);
        conditions += SqlUtils.convertString("prpLacciCheck.CheckObject", prpLacciCheckCheckObject);
        conditions += SqlUtils.convertString("prpLacciCheck.CheckObjectDesc", prpLacciCheckCheckObjectDesc);
        conditions += SqlUtils.convertString("prpLacciCheck.CheckNature", prpLacciCheckCheckNature);
        conditions += SqlUtils.convertDate("prpLacciCheck.CheckDate", prpLacciCheckCheckDate);
        conditions += SqlUtils.convertString("prpLacciCheck.CheckHour", prpLacciCheckCheckHour);
        conditions += SqlUtils.convertDate("prpLacciCheck.CheckEndDate", prpLacciCheckCheckEndDate);
        conditions += SqlUtils.convertString("prpLacciCheck.CheckEndHour", prpLacciCheckCheckEndHour);
        conditions += SqlUtils.convertString("prpLacciCheck.CheckSite", prpLacciCheckCheckSite);
        conditions += SqlUtils.convertString("prpLacciCheck.DamageCode", prpLacciCheckDamageCode);
        conditions += SqlUtils.convertString("prpLacciCheck.DamageName", prpLacciCheckDamageName);
        conditions += SqlUtils.convertString("prpLacciCheck.DamageTypeCode", prpLacciCheckDamageTypeCode);
        conditions += SqlUtils.convertString("prpLacciCheck.DamageTypeName", prpLacciCheckDamageTypeName);
        conditions += SqlUtils.convertString("prpLacciCheck.CheckerCode", prpLacciCheckCheckerCode);
        conditions += SqlUtils.convertString("prpLacciCheck.ApproverCode", prpLacciCheckApproverCode);
        conditions += SqlUtils.convertDate("prpLacciCheck.ApproverDate", prpLacciCheckApproverDate);
        conditions += SqlUtils.convertString("prpLacciCheck.ApproverStatus", prpLacciCheckApproverStatus);
        conditions += SqlUtils.convertString("prpLacciCheck.Remark", prpLacciCheckRemark);
        conditions += SqlUtils.convertString("prpLacciCheck.Flag", prpLacciCheckFlag);
        return conditions;

    }

    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#delete(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        UserDto user = (UserDto) session.getAttribute("user");
        ParamUtils paramUtils = new ParamUtils(request);
        String[] myselect = paramUtils.getParameterValues("checkboxSelect");
        String[] prpLacciCheckCheckNos = paramUtils.getParameterValues("prpLacciCheckCheckNo");
        for (int i = 0; i < myselect.length; i++) {
            String prpLacciCheckCheckNo = prpLacciCheckCheckNos[Integer.parseInt(myselect[i])];
            PrpLacciCheckDeleteCommand command = new PrpLacciCheckDeleteCommand(prpLacciCheckCheckNo);
            try {
                command.execute();
            } catch (Exception e) {
                throw new UserException(-98, -1212, this.getClass().getName()
                        + ".delete(prpLacciCheckCheckNo)--<br>说明：删除调查" + prpLacciCheckCheckNo + "失败--<br>"
                        + e.getCause());
            }
        }
    }

    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#prepareQuery(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void prepareQuery(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("prpLacciCheckDto", new PrpLacciCheckDto());
        request.setAttribute("validStatusList", ICollections.getCollectionWithAll(ICollections.getValidStatusList()));
    }

    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#query(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void query(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ParamUtils paramUtils = new ParamUtils(request);
        int i=1;
        
        HttpSession session = request.getSession();
        UserDto user = (UserDto) (session.getAttribute("user"));
        int pageNo = paramUtils.getIntParameter("pageNo", 1);
        int rowsPerPage = paramUtils.getIntParameter("rowsPerPage", UIUserProfile.getRowsPerPage());
        String conditions = generateConditions(request);
        user.setQueryCondition("prpLacciCheck", conditions, pageNo, rowsPerPage);
        PrpLacciCheckFindByConditionsCommand command = new PrpLacciCheckFindByConditionsCommand(conditions, pageNo,
                rowsPerPage);
        PageRecord pageRecord = (PageRecord) command.execute();
        request.setAttribute("fm", new AbstractForm(pageRecord));
        request.setAttribute("prpLacciCheckOverview", pageRecord.getResult());
    }

    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#queryContinue(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void queryContinue(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ParamUtils paramUtils = new ParamUtils(request);
        HttpSession session = request.getSession();
        UserDto user = (UserDto) (session.getAttribute("user"));
        String conditions = "1=1";
        if (user.getQueryCondition().getQueryKey().equals("prpLacciCheck")) {
            conditions = user.getQueryCondition().getConditions();
        }
        int pageNo = paramUtils.getIntParameter("pageNo", user.getQueryCondition().getPageNo());
        int rowsPerPage = paramUtils.getIntParameter("rowsPerPage", user.getQueryCondition().getRowsPerPage());
        //更新查询条件
        user.setQueryCondition("prpLacciCheck", conditions, pageNo, rowsPerPage);
        PrpLacciCheckFindByConditionsCommand command = new PrpLacciCheckFindByConditionsCommand(conditions, pageNo,
                rowsPerPage);
        PageRecord pageRecord = (PageRecord) command.execute();
        request.setAttribute("fm", new AbstractForm(pageRecord));
        request.setAttribute("prpLacciCheckOverview", pageRecord.getResult());
    }

    /**
     * @see com.sinosoft.sysframework.common.AbstractAction#view(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public void view(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ParamUtils paramUtils = new ParamUtils(request);
        String prpLacciCheckCheckNo = paramUtils.getParameter("prpLacciCheckCheckNo");
        PrpLacciCheckFindByPrimaryKeyCommand command = new PrpLacciCheckFindByPrimaryKeyCommand(prpLacciCheckCheckNo);
        PrpLacciCheckDto prpLacciCheckDto = (PrpLacciCheckDto) command.execute();
        request.setAttribute("prpLacciCheckDto", prpLacciCheckDto);
        request.setAttribute("validStatusList", ICollections.getValidStatusList());
    }
}