package com.sinosoft.claim.ui.control.viewHelper;

import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrplinterAutoClaimDetailAction;
import com.sinosoft.claim.bl.facade.BLPrplinterAutoClaimDetailFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.facade.UIWorkFlowApprovalInterFaceFacade;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 预赔核赔类，处理预赔核赔节点
 * */
public class UIMedicalAutoPrepayVericSubViewHelper {
	/**
	 * 预赔核赔逻辑
	 * @param prpLinterRequestDto
	 * @return prpLinterRequestDto
	 * @throws Exception
	 */
	public PrpLinterRequestDto autoPrepayVeric (PrpLinterRequestDto prpLinterRequestDto) throws Exception{
		PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = prpLinterRequestDto.getPrplinterAutoClaimDetailDto();
		
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
				prpLinterRequestDto.getPolicyno(),
				prpLinterRequestDto.getDamageStartDate().toString(), 
				prpLinterRequestDto.getDamageStartHour());
		String riskCode = policyDto.getPrpCmainDto().getRiskCode();
		String classCode = policyDto.getPrpCmainDto().getClassCode();
		String handlerCode = policyDto.getPrpCmainDto().getHandlerCode();
		String handler1Code = policyDto.getPrpCmainDto().getHandler1Code();
		String makeCom = prpLinterRequestDto.getMakeCom();
		String businessno = "";
		UserDto user = new UserDto();
		user.setUserCode(prpLinterRequestDto.getOperatorCode());
		user.setUserName(prpLinterRequestDto.getOperatorName());
		user.setComCode(prpLinterRequestDto.getMakeCom());
		user.setComName(prpLinterRequestDto.getMakeComName());
		WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
		
		try {
			String registNo = prpLinterRequestDto.getRelationRegistNo();
			BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
			Collection swflogDtoList = blSwfLogFacade. findByConditions(" registno='"+registNo+"' and nodetype='speci' and nodestatus='4' order by logNo desc  ");
			if(swflogDtoList == null || swflogDtoList.size()<1){
				throw new Exception("预赔案节点未提交，无法操作核赔");
			}
			Collection swflogVericDtoList = new UIWorkFlowAction().findNodesByConditions(" registno='"+registNo+"' and nodetype='veric' and nodestatus='0' ");
			if(swflogVericDtoList == null || swflogVericDtoList.size()<1){
				throw new Exception("没有待处理的核赔节点");
			}
			SwfLogDto swflogVericDto = (SwfLogDto)swflogVericDtoList.iterator().next();
			String flowId = swflogVericDto.getFlowID();
			String logno = (""+swflogVericDto.getLogNo()).trim();
			businessno = swflogVericDto.getBusinessNo();
			
			String uwFlowID = new UIWorkFlowApprovalInterFaceFacade(). submitApprovalPlatform("MedicalAutoVeric",flowId,
					logno,businessno,riskCode,classCode,user.getComCode(),handlerCode,makeCom,
					user.getUserCode(), handler1Code, prpLinterRequestDto.getHandleText());
			if(uwFlowID!=null&&!"SUCCESS".equals(uwFlowID)){
				throw new Exception("核赔操作双核系统失败，请重新提交或者与管理员联系!");
			}
			
			swflogVericDto.setHandlerCode(prpLinterRequestDto.getOperatorCode());
			swflogVericDto.setHandlerName(prpLinterRequestDto.getOperatorName());
			swflogVericDto.setNextBusinessNo(swflogVericDto.getKeyIn());
			swflogVericDto.setKeyIn(swflogVericDto.getKeyIn());
			swflogVericDto.setKeyOut(swflogVericDto.getKeyIn());
			swflogVericDto.setNodeStatus("4");
			WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swflogVericDto);
			boolean checkFlag = workFlowViewHelper.checkDealDto(workFlowDto);
			if(checkFlag == false){
				throw new Exception("没有需要处理的工作流数据");
			}
			//记录流程轨迹表-预赔审批环节成功标志
			prplinterAutoClaimDetailDto.setPrepayVericSuccFlag("1");
			prplinterAutoClaimDetailDto.setRemark("预赔审批成功："+registNo);
			// 创建数据库管理对象
			DBManager dbManager = new DBManager();
			try {
				dbManager.open(AppConfig.get("sysconst.DBJNDI"));
				dbManager.beginTransaction();
				//处理工作流数据
				new BLPrplinterAutoClaimDetailAction().update(dbManager,prplinterAutoClaimDetailDto);
				new BLWorkFlowAction().deal(dbManager,workFlowDto);
				dbManager.commitTransaction();
			} catch (Exception e) {
				//事务回滚
				dbManager.rollbackTransaction();
				e.printStackTrace();
				throw e;
			}finally{
			    dbManager.close();
			}
		} catch (Exception e) {
			String messege = e.toString();
			if(messege!=null&&messege.length()>1000){
				messege = messege.substring(0,1000);
			}
			prplinterAutoClaimDetailDto.setPrepayVericSuccFlag("0");
			prplinterAutoClaimDetailDto.setRemark("预赔审批失败："+messege);
			new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
			e.printStackTrace();
			throw e;
		}
		return prpLinterRequestDto;
	}

}
