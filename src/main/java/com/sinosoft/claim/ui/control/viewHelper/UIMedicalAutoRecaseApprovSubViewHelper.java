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
 * 1.	�����м����������ؿ�˫��������ҵ�����ݼ���������
 * 2.	�����м��������֯�ؿ������ҵ�����ݼ��������㹤������
 * 3.	��������״̬���ؿ���������״̬
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
				throw new Exception("û�д�������ؿ��ⰸ�����ڵ㣡");
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
				throw new Exception("�ؿ�����ʧ�ܴ���ʧ��");
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
			/***************��Ӵ�ϵͳ��־********************/
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
			/*******************���ӱ�־����****************************/
			
			BLWorkFlowAction blWorkFlowAction = new BLWorkFlowAction();
			
			BLPrpLrecaseAction blPrpLrecaseAction = new BLPrpLrecaseAction();
			
			//�������ݿ�������
		    DBManager dbManager = new DBManager();
		    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			try {
				int i = blPrpLrecaseAction.getCount(dbManager, "claimNo='"+ businessno + "' order by order by serialno desc");
				PrpLrecaseDto prpLrecaseDto = blPrpLrecaseAction.findByPrimaryKey(dbManager, businessno, i);
				prpLrecaseDto.setFlag("1");
				//��ʼ����
				dbManager.beginTransaction();
				blPrpLrecaseAction.update(dbManager, prpLrecaseDto);
				blWorkFlowAction.deal(dbManager, workFlowDto);
				prpLinterRecaseDetailDto.setAppovlSuccFlag("1");
				prpLinterRecaseDetailDto.setRemark("�ؿ������ɹ���"+businessno);
				blPrpLinterRecaseDetailAction.update(dbManager, prpLinterRecaseDetailDto);
				dbManager.commitTransaction();
			} catch (Exception e) {
				e.printStackTrace();
				 //�ع�����
			    dbManager.rollbackTransaction();
			    throw e;
			}finally{
				//�ر����ݿ�����
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
			prpLinterRecaseDetailDto.setRemark("�ؿ�����ʧ�ܣ�"+messege);;
			blPrpLinterRecaseDetailFacade.update(prpLinterRecaseDetailDto);
			e.printStackTrace();
			throw e;
		}
		
		return prpLinterRecaseRequestDto;
	}
}
