package com.sinosoft.claim.ui.control.viewHelper;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.custom.LinkRecordDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLdocDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UILinkRecordAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * <p>
 * Title: RegistViewHelper
 * </p>
 * <p>
 * Description:报案ViewHelper类，在该类中完成页面数据的整理
 * </p>
 * <p>
 * Copyright: Copyright 中科软科技股份有限公司(c) 2004
 * </p>
 * 
 * @author 阳光理赔项目组 dongcl
 * @version 1.0 <br>
 */
public class LinkRecordViewHelper  {
    /**
     * 默认构造方法
     */
    public LinkRecordViewHelper() {
    }
	   /**
     * 根据报案号和保单号,车牌号，操作时间，案件状态查询报案信息
     * 
     * @param httpServletRequest 返回给页面的request
     * @param registNo 报案号
     * @param policyNo 保单号
     * @throws Exception Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件 Modify By dongchengliang 2005-05-28
     *             Reason:增加险种查询条件
     */

    public void setLinkRecordDToView(HttpServletRequest httpServletRequest, String claimNo, String userCode,
            String riskCode, String comCode, String editType) throws Exception {
        //System.out.println("-----------报案查询----1 ---------------");
        //根据输入的保单号，报案号生成SQL where 子句
		claimNo = StringUtils.rightTrim(claimNo);
		userCode = StringUtils.rightTrim(userCode);
		comCode = StringUtils.rightTrim(comCode);
		editType = StringUtils.rightTrim(editType);
        riskCode = StringUtils.rightTrim(riskCode);
		LinkRecordDto linkRecordDto = new LinkRecordDto();
		UILinkRecordAction uiLinkRecordAction = new UILinkRecordAction();
		PrpLclaimDto prpLclaimDto = uiLinkRecordAction.PrpLclaimFindByPrimaryKeyCommand(claimNo);
		System.err.println("--------------prpLclaim is:" + prpLclaimDto);
		PrpLregistDto prpLregistDto = uiLinkRecordAction.PrpLregistFindByPrimaryKeyCommand(prpLclaimDto.getRegistNo());
		PrpLcheckDto prpLcheckDto = uiLinkRecordAction.PrpLcheckFindByPrimaryKeyCommand(prpLclaimDto.getRegistNo());
		Collection prpLregistExtList = uiLinkRecordAction.PrpLregistExtFindByConditionsCommand(" registNo ='" + prpLclaimDto.getRegistNo() + "' order by inputdate ");
		if(prpLregistExtList != null ){
			if(prpLregistExtList.iterator().hasNext()){
				PrpLregistExtDto prpLregistExtDto = (PrpLregistExtDto)prpLregistExtList.iterator().next();
				linkRecordDto.setLinkCustomDate(prpLregistExtDto.getInputDate());
			}
		}
		linkRecordDto.setPrpLregistExtList(prpLregistExtList);
		Collection prpLdocList = uiLinkRecordAction.PrpLdocFindByConditionsCommand(" claimNo ='" + prpLclaimDto.getClaimNo() + "'  order by signindate desc ");
		if(prpLdocList != null ){
			if(prpLdocList.iterator().hasNext()){
				PrpLdocDto prpLdocDto = (PrpLdocDto)prpLdocList.iterator().next();
				linkRecordDto.setFinishDocDate(prpLdocDto.getSignInDate());
			}
		}	
		UICodeAction uiCodeAction = new UICodeAction();
		linkRecordDto.setComCode(prpLclaimDto.getComCode());
		linkRecordDto.setComName(uiCodeAction.translateComCode(prpLclaimDto.getComCode(),true));
		linkRecordDto.setClaimNo(claimNo);
		linkRecordDto.setReportDate(prpLregistDto.getReportDate());
		linkRecordDto.setCopyPolicyDate(prpLclaimDto.getOperateDate());
		linkRecordDto.setCheckDate(prpLcheckDto.getCheckDate());
		linkRecordDto.setEndCaseDate(prpLclaimDto.getEndCaseDate());
		String conditions = " 1=1 ";
        //     拼权限
        UIPowerInterface uiPowerInterface = new UIPowerInterface();
        UserDto userDto = (UserDto) httpServletRequest.getSession().getAttribute("user");
        conditions = conditions
                + uiPowerInterface.addPower(userDto.getUserCode(), "lpba", "a", BusinessRuleUtil.getOuterCode(
                        httpServletRequest, "RISKCODE_DAA"));
        prpLregistDto.setEditType(httpServletRequest.getParameter("editType"));
        httpServletRequest.setAttribute("linkRecordDto", linkRecordDto);
    }




}