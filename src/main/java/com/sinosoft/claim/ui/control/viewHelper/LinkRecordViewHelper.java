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
 * Description:����ViewHelper�࣬�ڸ��������ҳ�����ݵ�����
 * </p>
 * <p>
 * Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004
 * </p>
 * 
 * @author ����������Ŀ�� dongcl
 * @version 1.0 <br>
 */
public class LinkRecordViewHelper  {
    /**
     * Ĭ�Ϲ��췽��
     */
    public LinkRecordViewHelper() {
    }
	   /**
     * ���ݱ����źͱ�����,���ƺţ�����ʱ�䣬����״̬��ѯ������Ϣ
     * 
     * @param httpServletRequest ���ظ�ҳ���request
     * @param registNo ������
     * @param policyNo ������
     * @throws Exception Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ���� Modify By dongchengliang 2005-05-28
     *             Reason:�������ֲ�ѯ����
     */

    public void setLinkRecordDToView(HttpServletRequest httpServletRequest, String claimNo, String userCode,
            String riskCode, String comCode, String editType) throws Exception {
        //System.out.println("-----------������ѯ----1 ---------------");
        //��������ı����ţ�����������SQL where �Ӿ�
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
        //     ƴȨ��
        UIPowerInterface uiPowerInterface = new UIPowerInterface();
        UserDto userDto = (UserDto) httpServletRequest.getSession().getAttribute("user");
        conditions = conditions
                + uiPowerInterface.addPower(userDto.getUserCode(), "lpba", "a", BusinessRuleUtil.getOuterCode(
                        httpServletRequest, "RISKCODE_DAA"));
        prpLregistDto.setEditType(httpServletRequest.getParameter("editType"));
        httpServletRequest.setAttribute("linkRecordDto", linkRecordDto);
    }




}