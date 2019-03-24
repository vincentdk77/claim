package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterRecaseDetailAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLrecaseAction;
import com.sinosoft.claim.bl.facade.BLPrpDuserFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterRecaseDetailFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.facade.UIWorkFlowApprovalInterFaceFacade;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 1.	根据中间表数据完成重开双核审批的业务数据及工作流。
 * 2.	根据中间表数据组织重开理赔的业务数据及生成理算工作流。
 * 3.	更新流程状态表重开审批环节状态
 * 
 * @author Administrator
 *
 */
public class UIMedicalAutoRecaseApprovSubViewHelper {
	
	public PrpLinterRecaseRequestDto autoRecaseApprov (PrpLinterRecaseRequestDto prpLinterRecaseRequestDto) throws Exception{
		UserDto user = new UserDto();
		user.setUserCode(prpLinterRecaseRequestDto.getAuditUser());
		BLPrpDuserFacade blPrpDuserFacade = new BLPrpDuserFacade();
        PrpDuserDto prpDuserDto = blPrpDuserFacade.findByPrimaryKey(prpLinterRecaseRequestDto.getAuditUser());
		user.setUserName(prpDuserDto.getUserName());
		user.setComCode(prpLinterRecaseRequestDto.getMakeCom());
		user.setComName(prpLinterRecaseRequestDto.getMakeComName());
		PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = prpLinterRecaseRequestDto.getPrpLinterRecaseDetailDto();
		BLPrpLinterRecaseDetailAction blPrpLinterRecaseDetailAction = new BLPrpLinterRecaseDetailAction();
		BLPrpLinterRecaseDetailFacade blPrpLinterRecaseDetailFacade = new BLPrpLinterRecaseDetailFacade();
		try {
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
					prpLinterRecaseRequestDto.getPolicyno(),
					prpLinterRecaseRequestDto.getDamageStartDate().toString(), 
					prpLinterRecaseRequestDto.getDamageStartHour());
			String riskCode = policyDto.getPrpCmainDto().getRiskCode();
			String classCode = policyDto.getPrpCmainDto().getClassCode();
			
			String registNo = prpLinterRecaseRequestDto.getRelationRegistNo();
			BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
			Collection swflogDtoList = blSwfLogFacade. findByConditions(" registno='"+registNo+"' and nodetype='rcase' and nodestatus='0' ");
			if(swflogDtoList == null || swflogDtoList.size()<1){
				throw new Exception("没有待处理的重开赔案审批节点！");
			}
			SwfLogDto swflogDto = (SwfLogDto)swflogDtoList.iterator().next();
			String flowId = swflogDto.getFlowID();
			String logno = (""+swflogDto.getLogNo()).trim();
			String businessno = swflogDto.getBusinessNo();
			String handlerCode = prpLinterRecaseRequestDto.getOperatorCode();
			String handler1Code = policyDto.getPrpCmainDto().getHandler1Code();
			String uwFlowID = new UIWorkFlowApprovalInterFaceFacade(). submitApprovalPlatform("MedicalAutoRecasApprov",flowId,
					logno,businessno,riskCode,classCode,user.getComCode(),handlerCode,prpLinterRecaseRequestDto.getMakeCom(),
					user.getUserCode(), handler1Code, prpLinterRecaseRequestDto.getHandleText());
			
			if(!"SUCCESS".equals(uwFlowID)){
				throw new Exception("重开审批失败处理失败");
			}
			
			ArrayList<SwfLogDto> nextnodeList = new ArrayList<SwfLogDto>();
			swflogDto.setNodeStatus("4");
			swflogDto.setNextBusinessNo(swflogDto.getBusinessNo());
			SwfLogDto nextSwfLogDto = new SwfLogDto();
			nextSwfLogDto.setNodeType("compe");
			nextSwfLogDto.setNodeNo(0);
			nextSwfLogDto.setFlowInTime(new DateTime(prpLinterRecaseRequestDto.getVericTime(),DateTime.YEAR_TO_SECOND).toString());
			nextSwfLogDto.setHandleTime(new DateTime(prpLinterRecaseRequestDto.getVericTime(),DateTime.YEAR_TO_SECOND).toString());
			nextnodeList.add(nextSwfLogDto);
			swflogDto.setNextNodeListType("1");
			swflogDto.setSwfLogList(nextnodeList);
			WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			WorkFlowDto workFlowDto = workFlowViewHelper.viewToDtoMedical(user,swflogDto);
			/***************添加大病系统标志********************/
			Collection submitSwfLogList = workFlowDto.getSubmitSwfLogDtoList();
			Iterator subIter = submitSwfLogList.iterator();
			ArrayList submitSwfLogListTmp = new ArrayList();
			while(subIter.hasNext()){
				SwfLogDto swfLog = (SwfLogDto)subIter.next();
				swfLog.setMedicalTransitFlag("1");
				submitSwfLogListTmp.add(swfLog);
			}
			workFlowDto.setSubmitSwfLogDtoList(submitSwfLogListTmp);
			SwfLogDto updateSwfLog = workFlowDto.getUpdateSwfLogDto();
			updateSwfLog.setMedicalTransitFlag("1");
			workFlowDto.setUpdateSwfLogDto(updateSwfLog);
			/*******************增加标志结束****************************/
			
			BLWorkFlowAction blWorkFlowAction = new BLWorkFlowAction();
			
			BLPrpLrecaseAction blPrpLrecaseAction = new BLPrpLrecaseAction();
			
			//创建数据库管理对象
		    DBManager dbManager = new DBManager();
		    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			try {
				int i = blPrpLrecaseAction.getCount(dbManager, "claimNo='"+ businessno + "' order by order by serialno desc");
				PrpLrecaseDto prpLrecaseDto = blPrpLrecaseAction.findByPrimaryKey(dbManager, businessno, i);
				prpLrecaseDto.setFlag("1");
				//开始事务
				dbManager.beginTransaction();
				blPrpLrecaseAction.update(dbManager, prpLrecaseDto);
				blWorkFlowAction.deal(dbManager, workFlowDto);
				prpLinterRecaseDetailDto.setAppovlSuccFlag("1");
				prpLinterRecaseDetailDto.setRemark("重开审批成功："+businessno);
				blPrpLinterRecaseDetailAction.update(dbManager, prpLinterRecaseDetailDto);
				dbManager.commitTransaction();
			} catch (Exception e) {
				e.printStackTrace();
				 //回滚事务
			    dbManager.rollbackTransaction();
			    throw e;
			}finally{
				//关闭数据库连接
			    dbManager.close();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			//PrplinterAutoClaimDetailDto  prplinterAutoClaimDetailDto  = blPrplinterAutoClaimDetailFacade.findByPrimaryKey(prpLinterRequestDto.getId(), registNo);
			prpLinterRecaseDetailDto.setAppovlSuccFlag("0");
			String messege = e.toString();
			if(messege!=null&&messege.length()>1000){
				messege = messege.substring(0,1000);
			}
			prpLinterRecaseDetailDto.setRemark("重开审批失败："+messege);;
			blPrpLinterRecaseDetailFacade.update(prpLinterRecaseDetailDto);
			e.printStackTrace();
			throw e;
		}
		
		return prpLinterRecaseRequestDto;
	}
}
