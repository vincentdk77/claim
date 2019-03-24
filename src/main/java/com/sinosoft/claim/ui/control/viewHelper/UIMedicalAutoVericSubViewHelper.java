package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterRecaseDetailAction;
import com.sinosoft.claim.bl.action.domain.BLPrplinterAutoClaimDetailAction;
import com.sinosoft.claim.bl.facade.BLPrpDuserFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterRecaseDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterAutoClaimDetailFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.facade.UIWorkFlowApprovalInterFaceFacade;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �Զ�������
 */
public class UIMedicalAutoVericSubViewHelper {
	/**
	 * �Զ������߼�
	 * @param prpLinterRequestDto
	 * @return
	 * @throws Exception
	 */
	public PrpLinterRequestDto autoVeric (PrpLinterRequestDto prpLinterRequestDto) throws Exception{
		PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = 
			prpLinterRequestDto.getPrplinterAutoClaimDetailDto();
		
		/**�ؿ��ⰸ����״̬����ʶ*/
		boolean recaseFlag = prpLinterRequestDto.isRecaseFlag();
		PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = prpLinterRequestDto.getPrpLinterRecaseDetailDto();
		
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
		String vericUser = prpLinterRequestDto.getVericUser();
		BLPrpDuserFacade blPrpDuserFacade = new BLPrpDuserFacade();
		PrpDuserDto prpDuserDto = blPrpDuserFacade.findByPrimaryKey(vericUser);
		String vericName = "";
		if(prpDuserDto!=null){
			vericName = prpDuserDto.getUserName();
		}
		user.setUserCode(vericUser);
		user.setUserName(vericName);
		user.setComCode(prpLinterRequestDto.getMakeCom());
		user.setComName(prpLinterRequestDto.getMakeComName());
		
		try {
			String registNo = prpLinterRequestDto.getRelationRegistNo();
			BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
			Collection swflogDtoList = blSwfLogFacade. findByConditions(" registno='"+registNo+"' and nodetype='compp' and nodestatus='4' order by logNo desc  ");
			if(swflogDtoList == null || swflogDtoList.size()<1){
				throw new Exception("������ڵ�δ�ύ���޷���������");
			}
			SwfLogDto swflogDto = (SwfLogDto)swflogDtoList.iterator().next();
			String flowId = swflogDto.getFlowID();
			String logno = (""+swflogDto.getLogNo()).trim();
			businessno = swflogDto.getBusinessNo();
			Collection swflogVericDtoList = new UIWorkFlowAction().findNodesByConditions(" registno='"+registNo+"' and nodetype='veric' and nodestatus='0' ");
			if(swflogVericDtoList == null || swflogVericDtoList.size()<1){
				throw new Exception("û�д�����ĺ���ڵ�");
			}
			SwfLogDto swflogVericDto = (SwfLogDto)swflogVericDtoList.iterator().next();
			
			String uwFlowID = new UIWorkFlowApprovalInterFaceFacade(). submitApprovalPlatform("MedicalAutoVeric",flowId,
					logno,businessno,riskCode,classCode,user.getComCode(),handlerCode,makeCom,
					user.getUserCode(), handler1Code, prpLinterRequestDto.getHandleText());
			if(uwFlowID!=null&&!"SUCCESS".equals(uwFlowID)){
				throw new Exception("�������˫��ϵͳʧ�ܣ��������ύ���������Ա��ϵ!");
			}
			
			swflogVericDto.setHandlerCode(vericUser);
			swflogVericDto.setHandlerName(vericName);
			//swflogDto.setBusinessNo(businessNo);
			swflogVericDto.setNextBusinessNo(swflogVericDto.getKeyIn());
			swflogVericDto.setKeyIn(swflogVericDto.getKeyIn());
			swflogVericDto.setKeyOut(swflogVericDto.getKeyIn());
			swflogVericDto.setNodeStatus("4");
			
			swflogVericDto.setSubmitTime(prpLinterRequestDto.getVericTime().toString());
			WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			WorkFlowDto workFlowDto = workFlowViewHelper.viewToDtoMedical(user,swflogVericDto);
			/***********************add ��ϵͳ��־***********************/
			//���Ӵ�ϵͳ��־medicaltransitflag
			Collection submitSwfLogDtoList = workFlowDto.getSubmitSwfLogDtoList();
			Iterator iter = submitSwfLogDtoList.iterator();
			ArrayList submitListTemp = new ArrayList();
			while(iter.hasNext()){
				SwfLogDto swfLogDto = (SwfLogDto)iter.next();
				swfLogDto.setMedicalTransitFlag("1");
				submitListTemp.add(swfLogDto);
			}
			workFlowDto.setSubmitSwfLogDtoList(submitListTemp);
			SwfLogDto updateSwfLogDto = workFlowDto.getUpdateSwfLogDto();
			updateSwfLogDto.setMedicalTransitFlag("1");
			workFlowDto.setUpdateSwfLogDto(updateSwfLogDto);
			/*************************end****************/
			boolean checkFlag = workFlowViewHelper.checkDealDto(workFlowDto);
			if(checkFlag == false){
				throw new Exception("û����Ҫ����Ĺ���������");
			}
			//׷�������Ϣ
			String[] notions = StringUtils.split(prpLinterRequestDto.getHandleText(),70);
			ArrayList<SwfNotionDto> notionList = new ArrayList<SwfNotionDto>();
			SwfNotionDto swfNotionDto = null;
			for(int i=0;i<notions.length;i++){
				swfNotionDto = new SwfNotionDto();
			    swfNotionDto.setFlowID(swflogVericDto.getFlowID());
			    swfNotionDto.setLogNo(swflogVericDto.getLogNo());
			    swfNotionDto.setLineNo(i + 1);
			    swfNotionDto.setHandleText(notions[i]);
			    notionList.add(swfNotionDto);
			}
			workFlowDto.setSwfNotionDtoList(notionList);
			if(recaseFlag){
				prpLinterRecaseDetailDto.setVericSuccFlag("1");
				prpLinterRecaseDetailDto.setRemark("����ɹ���"+registNo);
			}else{
				//��¼���̹켣��-���⻷�ڳɹ���־
				prplinterAutoClaimDetailDto.setVericSuccFlag("1");
				prplinterAutoClaimDetailDto.setRemark("����ɹ���"+registNo);
			}
			//new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
			// �������ݿ�������
			DBManager dbManager = new DBManager();
			try {
				dbManager.open(AppConfig.get("sysconst.DBJNDI"));
				dbManager.beginTransaction();
				//������������
				if(recaseFlag){
					new BLPrpLinterRecaseDetailAction().update(dbManager, prpLinterRecaseDetailDto);
				}else{
					new BLPrplinterAutoClaimDetailAction().update(dbManager,prplinterAutoClaimDetailDto);
				}
				new BLWorkFlowAction().deal(dbManager,workFlowDto);
				if(recaseFlag){
					
				}else{
					String sqlVeric = " Update swflog Set  submittime='"+prpLinterRequestDto.getVericTime()
	                                                    +"' Where registno ='"+registNo+"' and nodeType ='veric'";
	                String sqlEndca = " Update swflog Set Flowintime='"+prpLinterRequestDto.getVericTime()
											            +"',handletime='"+prpLinterRequestDto.getVericTime()
											            +"' Where registno ='"+registNo+"' and nodeType ='endca'";
					new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager,sqlVeric);
					new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager,sqlEndca);
					Date VericTime = new DateTime(prpLinterRequestDto.getVericTime(),DateTime.YEAR_TO_DAY);
					String sql = " Update prplcompensate set underwriteenddate=date'"+ VericTime+
											                    "',preservedate=date'"+ VericTime+
											                    "',statisticsym=date'"+ VericTime+
											                    "',inputdate=date'"+ VericTime+
											                    "' where compensateno ='"+businessno+"'";
                    new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager,sql);
					new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager,sql);
					String sql1 = " Update prpjplanfee set underwritedate =date'"+ VericTime+
						                "' where certino ='"+businessno+"'";
					new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager,sql1);
				}
				dbManager.commitTransaction();
			} catch (Exception e) {
				//����ع�
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
			if(recaseFlag){
				prpLinterRecaseDetailDto.setVericSuccFlag("0");
				prpLinterRecaseDetailDto.setRemark("����ʧ�ܣ�"+messege);
				new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
			}else{
				prplinterAutoClaimDetailDto.setVericSuccFlag("0");
				prplinterAutoClaimDetailDto.setRemark("����ʧ�ܣ�"+messege);
				new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
			}
			e.printStackTrace();
			throw e;
		}
		return prpLinterRequestDto;
	}
	
	
	/**
	 * �Զ������߼�
	 * @param prpLinterRequestDto
	 * @return
	 * @throws Exception
	 */
	public PrpLinterRequestDto autoVericRecase (PrpLinterRecaseRequestDto prpLinterRequestDto) throws Exception{
		PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = 
			prpLinterRequestDto.getPrplinterAutoClaimDetailDto();
		
		/**�ؿ��ⰸ����״̬����ʶ*/
		boolean recaseFlag = prpLinterRequestDto.isRecaseFlag();
		PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = prpLinterRequestDto.getPrpLinterRecaseDetailDto();
		
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
		String vericUser = prpLinterRequestDto.getVericUser();
		BLPrpDuserFacade blPrpDuserFacade = new BLPrpDuserFacade();
		PrpDuserDto prpDuserDto = blPrpDuserFacade.findByPrimaryKey(vericUser);
		String vericName = "";
		if(prpDuserDto!=null){
			vericName = prpDuserDto.getUserName();
		}
		user.setUserCode(vericUser);
		user.setUserName(vericName);
		user.setComCode(prpLinterRequestDto.getMakeCom());
		user.setComName(prpLinterRequestDto.getMakeComName());
		
		try {
			String registNo = prpLinterRequestDto.getRelationRegistNo();
			BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
			Collection swflogDtoList = blSwfLogFacade. findByConditions(" registno='"+registNo+"' and nodetype='compp' and nodestatus='4' order by logNo desc  ");
			if(swflogDtoList == null || swflogDtoList.size()<1){
				throw new Exception("������ڵ�δ�ύ���޷���������");
			}
			SwfLogDto swflogDto = (SwfLogDto)swflogDtoList.iterator().next();
			String flowId = swflogDto.getFlowID();
			String logno = (""+swflogDto.getLogNo()).trim();
			businessno = swflogDto.getBusinessNo();
			Collection swflogVericDtoList = new UIWorkFlowAction().findNodesByConditions(" registno='"+registNo+"' and nodetype='veric' and nodestatus='0' ");
			if(swflogVericDtoList == null || swflogVericDtoList.size()<1){
				throw new Exception("û�д�����ĺ���ڵ�");
			}
			SwfLogDto swflogVericDto = (SwfLogDto)swflogVericDtoList.iterator().next();
			
			String uwFlowID = new UIWorkFlowApprovalInterFaceFacade(). submitApprovalPlatform("MedicalAutoVeric",flowId,
					logno,businessno,riskCode,classCode,user.getComCode(),handlerCode,makeCom,
					user.getUserCode(), handler1Code, prpLinterRequestDto.getHandleText());
			if(uwFlowID!=null&&!"SUCCESS".equals(uwFlowID)){
				throw new Exception("�������˫��ϵͳʧ�ܣ��������ύ���������Ա��ϵ!");
			}
			
			swflogVericDto.setHandlerCode(vericUser);
			swflogVericDto.setHandlerName(vericName);
			//swflogDto.setBusinessNo(businessNo);
			swflogVericDto.setNextBusinessNo(swflogVericDto.getKeyIn());
			swflogVericDto.setKeyIn(swflogVericDto.getKeyIn());
			swflogVericDto.setKeyOut(swflogVericDto.getKeyIn());
			swflogVericDto.setNodeStatus("4");
			swflogVericDto.setFlowInTime(prpLinterRequestDto.getVericTime().toString());
			swflogVericDto.setHandleTime(prpLinterRequestDto.getVericTime().toString());
			swflogVericDto.setSubmitTime(prpLinterRequestDto.getVericTime().toString());
			WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			WorkFlowDto workFlowDto = workFlowViewHelper.viewToDtoMedical(user,swflogVericDto);
		    SwfLogDto swfLogDto1 = 	(SwfLogDto)workFlowDto.getSubmitSwfLogDtoList().get(0);
		    swfLogDto1.setFlowInTime(prpLinterRequestDto.getVericTime().toString());
		    swfLogDto1.setHandleTime(prpLinterRequestDto.getVericTime().toString());
		    swfLogDto1.setSubmitTime(prpLinterRequestDto.getVericTime().toString());
		    workFlowDto.getUpdateSwfLogDto().setFlowInTime(prpLinterRequestDto.getVericTime().toString());
		    workFlowDto.getUpdateSwfLogDto().setHandleTime(prpLinterRequestDto.getVericTime().toString());
		    workFlowDto.getUpdateSwfLogDto().setSubmitTime(prpLinterRequestDto.getVericTime().toString());
		    /***********************add ��ϵͳ��־***********************/
			//���Ӵ�ϵͳ��־medicaltransitflag
			Collection submitSwfLogDtoList = workFlowDto.getSubmitSwfLogDtoList();
			Iterator iter = submitSwfLogDtoList.iterator();
			ArrayList submitListTemp = new ArrayList();
			while(iter.hasNext()){
				SwfLogDto swfLogDto = (SwfLogDto)iter.next();
				swfLogDto.setMedicalTransitFlag("1");
				submitListTemp.add(swfLogDto);
			}
			workFlowDto.setSubmitSwfLogDtoList(submitListTemp);
			SwfLogDto updateSwfLogDto = workFlowDto.getUpdateSwfLogDto();
			updateSwfLogDto.setMedicalTransitFlag("1");
			workFlowDto.setUpdateSwfLogDto(updateSwfLogDto);
			/*************************end****************/
			boolean checkFlag = workFlowViewHelper.checkDealDto(workFlowDto);
			if(checkFlag == false){
				throw new Exception("û����Ҫ����Ĺ���������");
			}
			//׷�������Ϣ
			String[] notions = StringUtils.split(prpLinterRequestDto.getHandleText(),70);
			ArrayList<SwfNotionDto> notionList = new ArrayList<SwfNotionDto>();
			SwfNotionDto swfNotionDto = null;
			for(int i=0;i<notions.length;i++){
				swfNotionDto = new SwfNotionDto();
			    swfNotionDto.setFlowID(swflogVericDto.getFlowID());
			    swfNotionDto.setLogNo(swflogVericDto.getLogNo());
			    swfNotionDto.setLineNo(i + 1);
			    swfNotionDto.setHandleText(notions[i]);
			    notionList.add(swfNotionDto);
			}
			workFlowDto.setSwfNotionDtoList(notionList);
			if(recaseFlag){
				prpLinterRecaseDetailDto.setVericSuccFlag("1");
				prpLinterRecaseDetailDto.setRemark("����ɹ���"+registNo);
			}else{
				//��¼���̹켣��-���⻷�ڳɹ���־
				prplinterAutoClaimDetailDto.setVericSuccFlag("1");
				prplinterAutoClaimDetailDto.setRemark("����ɹ���"+registNo);
			}
			//new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
			// �������ݿ�������
			DBManager dbManager = new DBManager();
			try {
				dbManager.open(AppConfig.get("sysconst.DBJNDI"));
				dbManager.beginTransaction();
				//������������
				if(recaseFlag){
					new BLPrpLinterRecaseDetailAction().update(dbManager, prpLinterRecaseDetailDto);
				}else{
					new BLPrplinterAutoClaimDetailAction().update(dbManager,prplinterAutoClaimDetailDto);
				}
				new BLWorkFlowAction().deal(dbManager,workFlowDto);
				
				Date VericTime = new DateTime(prpLinterRequestDto.getVericTime(),DateTime.YEAR_TO_DAY);
				String sql = " Update prplcompensate set underwriteenddate=date'"+ VericTime+
				                                   "',preservedate=date'"+ VericTime+
				                                   "',statisticsym=date'"+ VericTime+
				                                   "',inputdate=date'"+ VericTime+
				                                   "' where compensateno ='"+businessno+"'";
				new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager,sql);
				String sql1 = " Update prpjplanfee set underwritedate =date'"+ VericTime+
									                "' where certino ='"+businessno+"'";
				new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager,sql1);
				
				
				dbManager.commitTransaction();
			} catch (Exception e) {
				//����ع�
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
			if(recaseFlag){
				prpLinterRecaseDetailDto.setVericSuccFlag("0");
				prpLinterRecaseDetailDto.setRemark("����ʧ�ܣ�"+messege);
				new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
			}else{
				prplinterAutoClaimDetailDto.setVericSuccFlag("0");
				prplinterAutoClaimDetailDto.setRemark("����ʧ�ܣ�"+messege);
				new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
			}
			e.printStackTrace();
			throw e;
		}
		return prpLinterRequestDto;
	}
	
	
	public PrpLinterRequestDto autoVericUpload(PrpLinterRequestDto prpLinterRequestDto) throws Exception{
		PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = 
			prpLinterRequestDto.getPrplinterAutoClaimDetailDto();
		
		/**�ؿ��ⰸ����״̬����ʶ*/
		boolean recaseFlag = prpLinterRequestDto.isRecaseFlag();
		PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = prpLinterRequestDto.getPrpLinterRecaseDetailDto();
		
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
		String vericUser = prpLinterRequestDto.getVericUser();
		BLPrpDuserFacade blPrpDuserFacade = new BLPrpDuserFacade();
		PrpDuserDto prpDuserDto = blPrpDuserFacade.findByPrimaryKey(vericUser);
		String vericName = "";
		if(prpDuserDto!=null){
			vericName = prpDuserDto.getUserName();
		}
		user.setUserCode(vericUser);
		user.setUserName(vericName);
		user.setComCode(prpLinterRequestDto.getMakeCom());
		user.setComName(prpLinterRequestDto.getMakeComName());
		
		try {
			String registNo = prpLinterRequestDto.getRelationRegistNo();
			BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
			Collection swflogDtoList = blSwfLogFacade. findByConditions(" registno='"+registNo+"' and nodetype='compp' and nodestatus='4' order by logNo desc  ");
			if(swflogDtoList == null || swflogDtoList.size()<1){
				throw new Exception("������ڵ�δ�ύ���޷���������");
			}
			SwfLogDto swflogDto = (SwfLogDto)swflogDtoList.iterator().next();
			String flowId = swflogDto.getFlowID();
			String logno = (""+swflogDto.getLogNo()).trim();
			businessno = swflogDto.getBusinessNo();
			Collection swflogVericDtoList = new UIWorkFlowAction().findNodesByConditions(" registno='"+registNo+"' and nodetype='veric' and nodestatus='0' ");
			if(swflogVericDtoList == null || swflogVericDtoList.size()<1){
				throw new Exception("û�д�����ĺ���ڵ�");
			}
			SwfLogDto swflogVericDto = (SwfLogDto)swflogVericDtoList.iterator().next();
			
//			String uwFlowID = new UIWorkFlowApprovalInterFaceFacade(). submitApprovalPlatform("MedicalAutoVeric",flowId,
//					logno,businessno,riskCode,classCode,user.getComCode(),handlerCode,makeCom,
//					user.getUserCode(), handler1Code, prpLinterRequestDto.getHandleText());
//			if(uwFlowID!=null&&!"SUCCESS".equals(uwFlowID)){
//				throw new Exception("�������˫��ϵͳʧ�ܣ��������ύ���������Ա��ϵ!");
//			}
			
			swflogVericDto.setHandlerCode(vericUser);
			swflogVericDto.setHandlerName(vericName);
			//swflogDto.setBusinessNo(businessNo);
			swflogVericDto.setNextBusinessNo(swflogVericDto.getKeyIn());
			swflogVericDto.setKeyIn(swflogVericDto.getKeyIn());
			swflogVericDto.setKeyOut(swflogVericDto.getKeyIn());
			swflogVericDto.setNodeStatus("4");
			swflogVericDto.setSubmitTime(prpLinterRequestDto.getVericTime().toString());
			WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			WorkFlowDto workFlowDto = workFlowViewHelper.viewToDtoMedical(user,swflogVericDto);
			boolean checkFlag = workFlowViewHelper.checkDealDto(workFlowDto);
			if(checkFlag == false){
				throw new Exception("û����Ҫ����Ĺ���������");
			}
			//׷�������Ϣ
			String[] notions = StringUtils.split(prpLinterRequestDto.getHandleText(),70);
			ArrayList<SwfNotionDto> notionList = new ArrayList<SwfNotionDto>();
			SwfNotionDto swfNotionDto = null;
			for(int i=0;i<notions.length;i++){
				swfNotionDto = new SwfNotionDto();
			    swfNotionDto.setFlowID(swflogVericDto.getFlowID());
			    swfNotionDto.setLogNo(swflogVericDto.getLogNo());
			    swfNotionDto.setLineNo(i + 1);
			    swfNotionDto.setHandleText(notions[i]);
			    notionList.add(swfNotionDto);
			}
			workFlowDto.setSwfNotionDtoList(notionList);
			if(recaseFlag){
				prpLinterRecaseDetailDto.setVericSuccFlag("1");
				prpLinterRecaseDetailDto.setRemark("����ɹ���"+registNo);
			}else{
				//��¼���̹켣��-���⻷�ڳɹ���־
				prplinterAutoClaimDetailDto.setVericSuccFlag("1");
				prplinterAutoClaimDetailDto.setRemark("����ɹ���"+registNo);
			}
			//new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
			// �������ݿ�������
			DBManager dbManager = new DBManager();
			try {
				dbManager.open(AppConfig.get("sysconst.DBJNDI"));
				dbManager.beginTransaction();
				//������������
				if(recaseFlag){
					new BLPrpLinterRecaseDetailAction().update(dbManager, prpLinterRecaseDetailDto);
				}else{
					new BLPrplinterAutoClaimDetailAction().update(dbManager,prplinterAutoClaimDetailDto);
				}
				new BLWorkFlowAction().deal(dbManager,workFlowDto);
				if(recaseFlag){
					
				}else{
					String sqlVeric = " Update swflog Set  submittime='"+prpLinterRequestDto.getVericTime()
	                                                    +"' Where registno ='"+registNo+"' and nodeType ='veric'";
	                String sqlEndca = " Update swflog Set Flowintime='"+prpLinterRequestDto.getVericTime()
											            +"',handletime='"+prpLinterRequestDto.getVericTime()
											            +"' Where registno ='"+registNo+"' and nodeType ='endca'";
					new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager,sqlVeric);
					new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager,sqlEndca);
					Date VericTime = new DateTime(prpLinterRequestDto.getVericTime(),DateTime.YEAR_TO_DAY);
					String sql = " Update prplcompensate set underwriteenddate=date'"+ VericTime+
											                    "',preservedate=date'"+ VericTime+
											                    "',statisticsym=date'"+ VericTime+
											                    "',inputdate=date'"+ VericTime+
											                    "' where compensateno ='"+businessno+"'";
                    new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager,sql);
					new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager,sql);
					String sql1 = " Update prpjplanfee set underwritedate =date'"+ VericTime+
						                "' where certino ='"+businessno+"'";
					new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager,sql1);
				}
				dbManager.commitTransaction();
			} catch (Exception e) {
				//����ع�
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
			if(recaseFlag){
				prpLinterRecaseDetailDto.setVericSuccFlag("0");
				prpLinterRecaseDetailDto.setRemark("����ʧ�ܣ�"+messege);
				new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
			}else{
				prplinterAutoClaimDetailDto.setVericSuccFlag("0");
				prplinterAutoClaimDetailDto.setRemark("����ʧ�ܣ�"+messege);
				new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
			}
			e.printStackTrace();
			throw e;
		}
		return prpLinterRequestDto;
	}

}
