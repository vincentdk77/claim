package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.gyic.claim.utils.Utils;
import com.sinosoft.claim.bl.action.domain.PrpLinterInjuryPersonDto;
import com.sinosoft.claim.bl.facade.BLDangerUnitFacade;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.bl.facade.BLPrpDuserFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacadeBase;
import com.sinosoft.claim.bl.facade.BLPrpLinterRecaseDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterAutoClaimDetailFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.NewDangerUnitDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpCinsuredDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLcfeeDto;
import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLctextDto;
import com.sinosoft.claim.dto.domain.PrpLinjuryPersonDto;
import com.sinosoft.claim.dto.domain.PrpLinterAccdentPersonDto;
import com.sinosoft.claim.dto.domain.PrpLinterClaimAppDto;
import com.sinosoft.claim.dto.domain.PrpLinterCompeFeeDto;
import com.sinosoft.claim.dto.domain.PrpLinterCompePayFeeDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.facade.UIWorkFlowUWInterFaceFacade;
import com.sinosoft.prpall.dbsvr.pg.DBPrpPhead;
import com.sinosoft.reins.out.bl.facade.BLPrpLdangerUnitFacade;
import com.sinosoft.reins.out.dto.domain.PrpLdangerItemDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerTotDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerUnitDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.utility.string.Str;

/**
 * ��ҽ�ƽӿ��Զ��������࣬�����������²���
 * 1.	���������������ɼ�����ţ���֯�������������ݡ�
 * 2.	�����м��������֯�������ҵ�����ݡ�
 * 3.	�����м��������֯Σ�յ�λ����
 * 4.	������������鹤����
 * 5.	��ɶ�����ҵ�����ݼ����������ݵĴ洢
 * 6.	��������״̬�����㻷��״̬
 * 
 * @author chu
 *
 */
public class UIMedicalAutoCompeSubViewHelper {
	/**
	 * ��ҽ�ƽӿ��Զ��������������̷����������Զ������ҵ�����ݺ͹���������
	 * @param prpLinterRequestDto �������Ϊ�м������
	 * @return ��������м������
	 * @throws Exception
	 */
	public PrpLinterRequestDto autoCompe (PrpLinterRequestDto prpLinterRequestDto) throws Exception{
		/**�ؿ��ⰸ����״̬����ʶ*/
		boolean recaseFlag = prpLinterRequestDto.isRecaseFlag();
		String operatorCode  = "";
		String operatorName  = "";
		if(recaseFlag){
			
		}else{
			String compeUser = prpLinterRequestDto.getCompeUser();
			BLPrpDuserFacade blPrpDuserFacade = new BLPrpDuserFacade();
			PrpDuserDto prpDuserDto = blPrpDuserFacade.findByPrimaryKey(compeUser);
			String compeName = "";
			if(prpDuserDto!=null){
				compeName = prpDuserDto.getUserName();
			}
			operatorCode  =  compeUser;
			operatorName  =  compeName;
		}
		String operatorComCode = prpLinterRequestDto.getMakeCom();
		String operatorComCName = prpLinterRequestDto.getMakeComName();
		String damageDate = new DateTime(prpLinterRequestDto.getDamageStartDate(),DateTime.YEAR_TO_DAY).toString();
		String damageHoure = prpLinterRequestDto.getDamageStartHour();
		String registNo = prpLinterRequestDto.getRelationRegistNo();
		String policyNo = prpLinterRequestDto.getPolicyno();
		String claimNo = "";
		//��֯UserDto����
		UserDto user  = new UserDto();
		user.setUserCode(operatorCode);
		user.setUserName(operatorName);
		user.setComCode(operatorComCode);
		user.setComName(operatorComCName);
		PrplinterAutoClaimDetailDto  prplinterAutoClaimDetailDto = prpLinterRequestDto.getPrplinterAutoClaimDetailDto();
		
		PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = prpLinterRequestDto.getPrpLinterRecaseDetailDto();
		
		BLPrplinterAutoClaimDetailFacade blPrplinterAutoClaimDetailFacade = new BLPrplinterAutoClaimDetailFacade();
		BLPrpLclaimFacadeBase blPrpLclaimFacadeBase = new BLPrpLclaimFacadeBase();
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
		UICompensateAction uiCompensateAction = new UICompensateAction();
		Utils utils = new Utils();//����ڴ�
		String remark  = "";
		String compensateNo = "";
		try{
			int newCompensateFlag = -1; // Ĭ�ϲ���Ҫ����������������,������������Ҫ�ù���������ÿ���������״̬
			SwfLogDto swfLogDtoDealNode = new SwfLogDto();
			String conditions = " registno='"+registNo+"' and nodeType='compe' and nodeStatus='0' ";
			ArrayList<SwfLogDto> swflogList  = (ArrayList<SwfLogDto>) new UIWorkFlowAction().findNodesByConditions(conditions);
			//�ж��Ƿ���δ���������ڵ���Ҫ�������û������ڵ��账��ֱ���׳��쳣
			if(swflogList!=null&&!swflogList.isEmpty()&&swflogList.size()>0){
				swfLogDtoDealNode = swflogList.get(0);
			}else {
				throw new Exception("δ��ѯ������������㹤����");
			}
			String flowID = swfLogDtoDealNode.getFlowID();
			int logNo = swfLogDtoDealNode.getLogNo();
			conditions = " registno='"+registNo+"' ";
			ArrayList<PrpLclaimDto> claimList  = (ArrayList<PrpLclaimDto>) blPrpLclaimFacadeBase.findByConditions(conditions);
			PrpLclaimDto prpLclaimDto = null;
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,damageDate,damageHoure);
			if(policyDto==null||policyDto.getPrpCmainDto()==null){
				throw new Exception("δ��ѯ����سб���Ϣ����ȷ�ϳ�������ı��������Ƿ�Ϸ�!");
			}
			int year = DateTime.current().getYear();
			
			if(claimList==null||claimList.isEmpty()||claimList.size()<1){
				throw new Exception("�˰���û�кϷ����ⰸ�ţ��޷���������");
			}else{
//				for(int index = 0 ; index < claimList.size() ; index ++ ){
//				}
				prpLclaimDto  = claimList.get(0);
				claimNo = prpLclaimDto.getClaimNo();
				ClaimDto claimDto = new UIClaimAction().findByPrimaryKey(claimNo);
				UIBillAction uiBillAction = new UIBillAction();//
				String tableName = "prplcompensate";
				compensateNo = uiBillAction.getNo(tableName,claimNo,policyDto.getPrpCmainDto().getComCode(), year);
				newCompensateFlag = 1; 	
				CompensateDto compensateDto = null;
				compensateDto = this.viewToDto(prpLinterRequestDto, claimDto, policyDto,compensateNo);
				swfLogDtoDealNode.setNewMTask(newCompensateFlag);
				swfLogDtoDealNode.setBusinessNo(compensateDto.getPrpLcompensateDto().getClaimNo()); // ���ڵ�Ĳ���
				swfLogDtoDealNode.setNextBusinessNo(compensateDto.getPrpLcompensateDto().getCompensateNo());
				swfLogDtoDealNode.setKeyIn(compensateDto.getPrpLcompensateDto().getClaimNo());
				swfLogDtoDealNode.setNodeStatus("4");
				
				swfLogDtoDealNode.setKeyOut(compensateDto.getPrpLcompensateDto().getCompensateNo());
				WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
				
				if (workFlowViewHelper.checkDealDto(workFlowDto)) {
					// reason:ֱ�ӱ���ҵ�����ݵ��¹��������ݶ�ʧ�������ύǰ��Ҫ��ʱ���浽���ڴ����״̬��
					// �ύǰ����ʱ����
					WorkFlowDto workFlowDtoTemp = null;
					swfLogDtoDealNode.setNodeStatus("2");
					workFlowDtoTemp = workFlowViewHelper.viewToDto(user,
							swfLogDtoDealNode);
					Collection swfLogDtoTmpList = workFlowDtoTemp.getSubmitSwfLogDtoList();
					/************************��ӱ�־ ��ʼ***********************/
					Iterator iterTmp= swfLogDtoTmpList.iterator();
					ArrayList submListTmp = new ArrayList();
					while(iterTmp.hasNext()){
						SwfLogDto swfLogDtoTmp = (SwfLogDto)iterTmp.next();
						swfLogDtoTmp.setMedicalTransitFlag("1");
						submListTmp.add(swfLogDtoTmp);
					}
					workFlowDtoTemp.setSubmitSwfLogDtoList(submListTmp);
					/*************************��ӱ�־ ����**********************/
					// �ݴ������ڵ�ʱ������ڵ�״̬��Ϊ�Ѵ���
					UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
					SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(flowID, logNo);
					if (swfLogDto.getNodeType().equals("compe")) {
						swfLogDto.setNodeStatus("4");
						swfLogDto.setMedicalTransitFlag("1");//
						workFlowDtoTemp.setUpdate(true);
						workFlowDtoTemp.setUpdateSwfLog2Dto(swfLogDto);
					}
					// ����ύ����ʧ����״̬Ϊ0
					compensateDto.getPrpLcompensateDto().setUnderWriteFlag("0");
					uiCompensateAction.save(compensateDto, workFlowDtoTemp);

					// ����ύ������״̬Ϊ9
					compensateDto.getPrpLcompensateDto().setUnderWriteFlag("9");
					int vericLogNo = 0;
					if (workFlowDto.getSubmitSwfLogDtoList() != null&& workFlowDto.getSubmitSwfLogDtoList().size() > 0) {
						vericLogNo = ((SwfLogDto) workFlowDto.getSubmitSwfLogDtoList().get(0)).getLogNo();
					}

					
					UIWorkFlowUWInterFaceFacade uiWorkFlowUWInterFaceFacade = new UIWorkFlowUWInterFaceFacade();
					String UWflowID = uiWorkFlowUWInterFaceFacade
							.submitVericTask(workFlowDto
									.getUpdateSwfLogDto().getFlowID(),
									vericLogNo + "", "22", "C",
									compensateDto.getPrpLcompensateDto()
											.getCompensateNo(),
									compensateDto.getPrpLcompensateDto()
											.getRiskCode(), compensateDto
											.getPrpLcompensateDto()
											.getClassCode(), compensateDto
											.getPrpLcompensateDto()
											.getComCode(), compensateDto
											.getPrpLcompensateDto()
											.getHandlerCode(),
									compensateDto.getPrpLcompensateDto()
											.getMakeCom(), user
											.getUserCode(), compensateDto
											.getPrpLcompensateDto()
											.getHandler1Code(), "");
					if (UWflowID.length() < 15) {
						String msg = "����'" + compensateNo
								+ "'�ύ˫��ϵͳʧ�ܣ��������ύ���������Ա��ϵ!";
						throw new UserException(1, 3, "������", msg);
					}
					
					// ���� workFlowDtoTemp ��workFlowDto
					int newCompeLogNo = 0;
					if (workFlowDtoTemp.getSubmitSwfLogDtoList() != null) {
						newCompeLogNo = ((SwfLogDto) workFlowDtoTemp.getSubmitSwfLogDtoList().get(0)).getLogNo();
						((SwfLogDto) workFlowDtoTemp.getSubmitSwfLogDtoList().get(0)).setNodeStatus("4");
						workFlowDto.setUpdate(true);
						workFlowDto.setUpdateSwfLogDto((SwfLogDto) workFlowDtoTemp.getSubmitSwfLogDtoList().get(0));
						if (workFlowDto.getSubmitSwfLogDtoList() != null) {
							// ɾ������ĵ�
							for (int i = 0; i < workFlowDto
									.getSubmitSwfLogDtoList().size(); i++) {
								if (((SwfLogDto) workFlowDto
										.getSubmitSwfLogDtoList().get(i))
										.getLogNo() == newCompeLogNo) {
									workFlowDto.getSubmitSwfLogDtoList()
											.remove(i);
									break;
								}

							}
						}

						if (workFlowDto.getSubmitSwfPathLogDtoList() != null) {
							// ɾ������ı�
							for (int i = 0; i < workFlowDto
									.getSubmitSwfPathLogDtoList().size(); i++) {
								if (((SwfPathLogDto) workFlowDto
										.getSubmitSwfPathLogDtoList()
										.get(i)).getEndNodeNo() == newCompeLogNo) {
									workFlowDto
											.getSubmitSwfPathLogDtoList()
											.remove(i);
									break;
								}

							}
						}
						//UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
						//SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(flowID, logNo);
						if (swfLogDto.getNodeType().equals("compe")) {
							swfLogDto.setNodeStatus("4");
							workFlowDto.setUpdate(true);
							workFlowDto.setUpdateSwfLog2Dto(swfLogDto);
						}
						
						if(recaseFlag){
							//��������״̬������ɹ���ʶ
							prpLinterRecaseDetailDto.setComppSuccFlag("1");
							prpLinterRecaseDetailDto.setCompensateNo(compensateNo);
							prpLinterRecaseDetailDto.setRemark("����ɹ���"+compensateNo);
							new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
						}else{
							//��������״̬������ɹ���ʶ
							prplinterAutoClaimDetailDto.setComppSuccFlag("1");
							prplinterAutoClaimDetailDto.setRemark("����ɹ���"+compensateNo);
							blPrplinterAutoClaimDetailFacade.update(prplinterAutoClaimDetailDto);
						}
						
						//�ڴ���
						remark = "������ţ�"+compensateNo+" ���濪ʼ";
						utils.getPhisicaMemory(remark);
						/***********************add ��ϵͳ��־***********************/
						Collection submSwfLogDtoList = workFlowDto.getSubmitSwfLogDtoList();
						Iterator iterSubm = submSwfLogDtoList.iterator();
						ArrayList submListTemp = new ArrayList();
						while(iterSubm.hasNext()){
							SwfLogDto swfLogDtoTmp = (SwfLogDto)iterSubm.next();
							swfLogDtoTmp.setMedicalTransitFlag("1");
							submListTemp.add(swfLogDtoTmp);
						}
						workFlowDto.setSubmitSwfLogDtoList(submListTemp);
						SwfLogDto updaSwfLogDto = workFlowDto.getUpdateSwfLogDto();
						updaSwfLogDto.setMedicalTransitFlag("1");
						workFlowDto.setUpdateSwfLogDto(updaSwfLogDto);
						SwfLogDto updaSwfLog2Dto = workFlowDto.getUpdateSwfLog2Dto();
						updaSwfLog2Dto.setMedicalTransitFlag("1");
						workFlowDto.setUpdateSwfLog2Dto(updaSwfLog2Dto);
						/*************************end****************/
						//���ڳ�������ϸ��Ϣ�ǽ�ڱش����������ﲻ�����ѳ�������Ϣ�ش���ֱ�ӽ������ݿ��г�ȡ�����ݽ��и�ֵ
						/*************************���м��ĳ�������ϸ��Ϣ����prpLinjuryPerson�����ű�ֻ���ϵͳ��Ϣ ��ʼ*******************/
						PrpLinterInjuryPersonDto[] prpLinterInjuryPersonArray=prpLinterRequestDto.getPrpLinterInjuryPersonArrayDto();
						ArrayList prpLinjuryPersonList = new ArrayList();
						PrpLinjuryPersonDto prpLinjuryPersonDto=null;
						if(prpLinterInjuryPersonArray!=null&&prpLinterInjuryPersonArray.length>0){
							for(int i=0;i<prpLinterInjuryPersonArray.length;i++){
								PrpLinterInjuryPersonDto prpLinterInjuryPersonDto = prpLinterInjuryPersonArray[i];
								prpLinjuryPersonDto= new PrpLinjuryPersonDto();
								prpLinjuryPersonDto.setAcciName(prpLinterInjuryPersonDto.getAcciName());
								prpLinjuryPersonDto.setIdentifyNumber(prpLinterInjuryPersonDto.getIdentifyNumber());
								prpLinjuryPersonDto.setSex(prpLinterInjuryPersonDto.getSex());
								prpLinjuryPersonDto.setCompensateNo(compensateNo);
								prpLinjuryPersonList.add(prpLinjuryPersonDto);
							}
						}
						
						compensateDto.setPrpLinjuryPersonList(prpLinjuryPersonList);
						/*************************���м��ĳ�������ϸ��Ϣ����prpLinjuryPerson�����ű�ֻ���ϵͳ��Ϣ ��ʼ*******************/
						//�ڴ���
						uiCompensateAction.save(compensateDto, workFlowDto);
						
						
						//�ڴ���
						remark = "������ţ�"+compensateNo+" �������";
						
						if(recaseFlag){
							
						}else{
							String sqlCompe = " Update swflog Set  submittime='"+prpLinterRequestDto.getCompeTime()
		                                                      +"' Where registno ='"+registNo+"' and nodeType='compe'";
							String sqlCompp = " Update swflog Set Flowintime='"+prpLinterRequestDto.getCompeTime()
											                  +"',handletime='"+prpLinterRequestDto.getCompeTime()
									                          +"',submittime='"+prpLinterRequestDto.getCompeTime()
									                         +"' Where registno ='"+registNo+"' and nodeType='compp'";
							String sqlVeric = " Update swflog Set Flowintime='"+prpLinterRequestDto.getCompeTime()
											                  +"',handletime='"+prpLinterRequestDto.getCompeTime()
											                  +"' Where registno ='"+registNo+"' and nodeType ='veric'";
							new BLPrplinterAutoClaimDetailFacade().updateBySQL(sqlCompe);
							new BLPrplinterAutoClaimDetailFacade().updateBySQL(sqlCompp);
							new BLPrplinterAutoClaimDetailFacade().updateBySQL(sqlVeric);
						}
					}
					
				}else{
					throw new Exception("û�з����빤������������κ����ݣ�");
				}
			}
		}catch(UserException ue){
			ue.printStackTrace();
			//PrplinterAutoClaimDetailDto  prplinterAutoClaimDetailDto  = blPrplinterAutoClaimDetailFacade.findByPrimaryKey(prpLinterRequestDto.getId(), registNo);
			String messege = ue.toString();
			if(messege!=null&&messege.length()>1000){
				messege = messege.substring(0,1000);
			}
			if(recaseFlag){
				prpLinterRecaseDetailDto.setComppSuccFlag("0");
				prpLinterRecaseDetailDto.setCompensateNo(compensateNo);
				prpLinterRecaseDetailDto.setRemark("����ʧ�ܣ�"+messege);
				new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
			}else{
				//��������״̬�������ʶ
				prplinterAutoClaimDetailDto.setComppSuccFlag("0");
				prplinterAutoClaimDetailDto.setRemark("����ʧ�ܣ�"+messege);
				blPrplinterAutoClaimDetailFacade.update(prplinterAutoClaimDetailDto);
			}
			throw ue;
		}catch(Exception e){
			e.printStackTrace();
			//PrplinterAutoClaimDetailDto  prplinterAutoClaimDetailDto  = blPrplinterAutoClaimDetailFacade.findByPrimaryKey(prpLinterRequestDto.getId(), registNo);
			String messege = e.toString();
			if(messege!=null&&messege.length()>1000){
				messege = messege.substring(0,1000);
			}
			if(recaseFlag){
				prpLinterRecaseDetailDto.setComppSuccFlag("0");
				prpLinterRecaseDetailDto.setCompensateNo(compensateNo);
				prpLinterRecaseDetailDto.setRemark("����ʧ�ܣ�"+messege);
				new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
			}else{
				prplinterAutoClaimDetailDto.setComppSuccFlag("0");
				prplinterAutoClaimDetailDto.setRemark("����ʧ�ܣ�"+messege);;
				blPrplinterAutoClaimDetailFacade.update(prplinterAutoClaimDetailDto);
			}
			throw e;
		}
		return prpLinterRequestDto;
	}
	
	
	/**
	 * ��ҽ�ƽӿ��Զ��������������̷����������Զ������ҵ�����ݺ͹���������
	 * @param prpLinterRequestDto �������Ϊ�м������
	 * @return ��������м������
	 * @throws Exception
	 */
	public PrpLinterRequestDto autoCompeRecase (PrpLinterRecaseRequestDto prpLinterRequestDto) throws Exception{
		/**�ؿ��ⰸ����״̬����ʶ*/
		boolean recaseFlag = prpLinterRequestDto.isRecaseFlag();
		String operatorCode  = "";
		String operatorName  = "";
		
	    operatorCode = prpLinterRequestDto.getApplyRecaseUser();
		BLPrpDuserFacade blPrpDuserFacade = new BLPrpDuserFacade();
		PrpDuserDto prpDuserDto = blPrpDuserFacade.findByPrimaryKey(operatorCode);
		String compeName = "";
		if(prpDuserDto!=null){
			operatorName = prpDuserDto.getUserName();
		}
		String operatorComCode = prpLinterRequestDto.getMakeCom();
		String operatorComCName = prpLinterRequestDto.getMakeComName();
		String damageDate = new DateTime(prpLinterRequestDto.getDamageStartDate(),DateTime.YEAR_TO_DAY).toString();
		String damageHoure = prpLinterRequestDto.getDamageStartHour();
		String registNo = prpLinterRequestDto.getRelationRegistNo();
		String policyNo = prpLinterRequestDto.getPolicyno();
		String claimNo = "";
		//��֯UserDto����
		UserDto user  = new UserDto();
		user.setUserCode(operatorCode);
		user.setUserName(operatorName);
		user.setComCode(operatorComCode);
		user.setComName(operatorComCName);
		PrplinterAutoClaimDetailDto  prplinterAutoClaimDetailDto = prpLinterRequestDto.getPrplinterAutoClaimDetailDto();
		
		PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = prpLinterRequestDto.getPrpLinterRecaseDetailDto();
		
		BLPrplinterAutoClaimDetailFacade blPrplinterAutoClaimDetailFacade = new BLPrplinterAutoClaimDetailFacade();
		BLPrpLclaimFacadeBase blPrpLclaimFacadeBase = new BLPrpLclaimFacadeBase();
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
		UICompensateAction uiCompensateAction = new UICompensateAction();
		Utils utils = new Utils();//����ڴ�
		String remark  = "";
		String compensateNo = "";
		try{
			int newCompensateFlag = -1; // Ĭ�ϲ���Ҫ����������������,������������Ҫ�ù���������ÿ���������״̬
			SwfLogDto swfLogDtoDealNode = new SwfLogDto();
			String conditions = " registno='"+registNo+"' and nodeType='compe' and nodeStatus='0' ";
			ArrayList<SwfLogDto> swflogList  = (ArrayList<SwfLogDto>) new UIWorkFlowAction().findNodesByConditions(conditions);
			//�ж��Ƿ���δ���������ڵ���Ҫ�������û������ڵ��账��ֱ���׳��쳣
			if(swflogList!=null&&!swflogList.isEmpty()&&swflogList.size()>0){
				swfLogDtoDealNode = swflogList.get(0);
			}else {
				throw new Exception("δ��ѯ������������㹤����");
			}
			String flowID = swfLogDtoDealNode.getFlowID();
			int logNo = swfLogDtoDealNode.getLogNo();
			conditions = " registno='"+registNo+"' ";
			ArrayList<PrpLclaimDto> claimList  = (ArrayList<PrpLclaimDto>) blPrpLclaimFacadeBase.findByConditions(conditions);
			PrpLclaimDto prpLclaimDto = null;
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,damageDate,damageHoure);
			if(policyDto==null||policyDto.getPrpCmainDto()==null){
				throw new Exception("δ��ѯ����سб���Ϣ����ȷ�ϳ�������ı��������Ƿ�Ϸ�!");
			}
			int year = DateTime.current().getYear();
			
			if(claimList==null||claimList.isEmpty()||claimList.size()<1){
				throw new Exception("�˰���û�кϷ����ⰸ�ţ��޷���������");
			}else{
//				for(int index = 0 ; index < claimList.size() ; index ++ ){
//				}
				prpLclaimDto  = claimList.get(0);
				claimNo = prpLclaimDto.getClaimNo();
				ClaimDto claimDto = new UIClaimAction().findByPrimaryKey(claimNo);
				UIBillAction uiBillAction = new UIBillAction();//
				String tableName = "prplcompensate";
				compensateNo = uiBillAction.getNo(tableName,claimNo,policyDto.getPrpCmainDto().getComCode(), year);
				newCompensateFlag = 1; 	
				CompensateDto compensateDto = null;
				compensateDto = this.viewToDto(prpLinterRequestDto, claimDto, policyDto,compensateNo);
				swfLogDtoDealNode.setNewMTask(newCompensateFlag);
				swfLogDtoDealNode.setBusinessNo(compensateDto.getPrpLcompensateDto().getClaimNo()); // ���ڵ�Ĳ���
				swfLogDtoDealNode.setNextBusinessNo(compensateDto.getPrpLcompensateDto().getCompensateNo());
				swfLogDtoDealNode.setKeyIn(compensateDto.getPrpLcompensateDto().getClaimNo());
				swfLogDtoDealNode.setNodeStatus("4");
				swfLogDtoDealNode.setKeyOut(compensateDto.getPrpLcompensateDto().getCompensateNo());
				WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
				if (workFlowViewHelper.checkDealDto(workFlowDto)) {
					// reason:ֱ�ӱ���ҵ�����ݵ��¹��������ݶ�ʧ�������ύǰ��Ҫ��ʱ���浽���ڴ����״̬��
					// �ύǰ����ʱ����
					WorkFlowDto workFlowDtoTemp = null;
					swfLogDtoDealNode.setNodeStatus("2");
					workFlowDtoTemp = workFlowViewHelper.viewToDtoMedical(user,
							swfLogDtoDealNode);
					Collection swfLogDtoTmpList = workFlowDtoTemp.getSubmitSwfLogDtoList();
					/************************��ӱ�־ ��ʼ***********************/
					Iterator iterTmp= swfLogDtoTmpList.iterator();
					ArrayList submListTmp = new ArrayList();
					while(iterTmp.hasNext()){
						SwfLogDto swfLogDtoTmp = (SwfLogDto)iterTmp.next();
						swfLogDtoTmp.setMedicalTransitFlag("1");
						submListTmp.add(swfLogDtoTmp);
					}
					workFlowDtoTemp.setSubmitSwfLogDtoList(submListTmp);
					/*************************��ӱ�־ ����**********************/
					// �ݴ������ڵ�ʱ������ڵ�״̬��Ϊ�Ѵ���
					UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
					SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(flowID, logNo);
					if (swfLogDto.getNodeType().equals("compe")) {
						swfLogDto.setNodeStatus("4");
						swfLogDto.setMedicalTransitFlag("1");//���ô�ϵͳ���ݱ�־
						workFlowDtoTemp.setUpdate(true);
						workFlowDtoTemp.setUpdateSwfLog2Dto(swfLogDto);
					}
					
					// ����ύ����ʧ����״̬Ϊ0
					compensateDto.getPrpLcompensateDto().setUnderWriteFlag("0");
					uiCompensateAction.save(compensateDto, workFlowDtoTemp);

					// ����ύ������״̬Ϊ9
					compensateDto.getPrpLcompensateDto().setUnderWriteFlag("9");
					int vericLogNo = 0;
					if (workFlowDto.getSubmitSwfLogDtoList() != null&& workFlowDto.getSubmitSwfLogDtoList().size() > 0) {
						vericLogNo = ((SwfLogDto) workFlowDto.getSubmitSwfLogDtoList().get(0)).getLogNo();
					}

					
					UIWorkFlowUWInterFaceFacade uiWorkFlowUWInterFaceFacade = new UIWorkFlowUWInterFaceFacade();
					String UWflowID = uiWorkFlowUWInterFaceFacade
							.submitVericTask(workFlowDto
									.getUpdateSwfLogDto().getFlowID(),
									vericLogNo + "", "22", "C",
									compensateDto.getPrpLcompensateDto()
											.getCompensateNo(),
									compensateDto.getPrpLcompensateDto()
											.getRiskCode(), compensateDto
											.getPrpLcompensateDto()
											.getClassCode(), compensateDto
											.getPrpLcompensateDto()
											.getComCode(), compensateDto
											.getPrpLcompensateDto()
											.getHandlerCode(),
									compensateDto.getPrpLcompensateDto()
											.getMakeCom(), user
											.getUserCode(), compensateDto
											.getPrpLcompensateDto()
											.getHandler1Code(), "");
					if (UWflowID.length() < 15) {
						String msg = "����'" + compensateNo
								+ "'�ύ˫��ϵͳʧ�ܣ��������ύ���������Ա��ϵ!";
						throw new UserException(1, 3, "������", msg);
					}
					
					// ���� workFlowDtoTemp ��workFlowDto
					int newCompeLogNo = 0;
					if (workFlowDtoTemp.getSubmitSwfLogDtoList() != null) {
						newCompeLogNo = ((SwfLogDto) workFlowDtoTemp.getSubmitSwfLogDtoList().get(0)).getLogNo();
						((SwfLogDto) workFlowDtoTemp.getSubmitSwfLogDtoList().get(0)).setNodeStatus("4");
						workFlowDto.setUpdate(true);
						workFlowDto.setUpdateSwfLogDto((SwfLogDto) workFlowDtoTemp.getSubmitSwfLogDtoList().get(0));
						if (workFlowDto.getSubmitSwfLogDtoList() != null) {
							// ɾ������ĵ�
							for (int i = 0; i < workFlowDto
									.getSubmitSwfLogDtoList().size(); i++) {
								if (((SwfLogDto) workFlowDto
										.getSubmitSwfLogDtoList().get(i))
										.getLogNo() == newCompeLogNo) {
									workFlowDto.getSubmitSwfLogDtoList()
											.remove(i);
									break;
								}

							}
						}

						if (workFlowDto.getSubmitSwfPathLogDtoList() != null) {
							// ɾ������ı�
							for (int i = 0; i < workFlowDto
									.getSubmitSwfPathLogDtoList().size(); i++) {
								if (((SwfPathLogDto) workFlowDto
										.getSubmitSwfPathLogDtoList()
										.get(i)).getEndNodeNo() == newCompeLogNo) {
									workFlowDto
											.getSubmitSwfPathLogDtoList()
											.remove(i);
									break;
								}

							}
						}
						//UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
						//SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(flowID, logNo);
						if (swfLogDto.getNodeType().equals("compe")) {
							swfLogDto.setNodeStatus("4");
							workFlowDto.setUpdate(true);
							workFlowDto.setUpdateSwfLog2Dto(swfLogDto);
						}
						/***********************add ��ϵͳ��־***********************/
//						���Ӵ�ϵͳ��־medicaltransitflag
						Collection submSwfLogDtoList = workFlowDto.getSubmitSwfLogDtoList();
						Iterator iterSubm = submSwfLogDtoList.iterator();
						ArrayList submListTemp = new ArrayList();
						while(iterSubm.hasNext()){
							SwfLogDto swfLogDtoTmp = (SwfLogDto)iterSubm.next();
							swfLogDtoTmp.setMedicalTransitFlag("1");
							submListTemp.add(swfLogDtoTmp);
						}
						workFlowDto.setSubmitSwfLogDtoList(submListTemp);
						SwfLogDto updaSwfLogDto = workFlowDto.getUpdateSwfLogDto();
						updaSwfLogDto.setMedicalTransitFlag("1");
						workFlowDto.setUpdateSwfLogDto(updaSwfLogDto);
						SwfLogDto updaSwfLog2Dto = workFlowDto.getUpdateSwfLog2Dto();
						updaSwfLog2Dto.setMedicalTransitFlag("1");
						workFlowDto.setUpdateSwfLog2Dto(updaSwfLog2Dto);
						/*************************end****************/
						//���ڳ�������ϸ��Ϣ�ǽ�ڱش����������ﲻ�����ѳ�������Ϣ�ش���ֱ�ӽ������ݿ��г�ȡ�����ݽ��и�ֵ
						/*************************���м��ĳ�������ϸ��Ϣ����prpLinjuryPerson�����ű�ֻ���ϵͳ��Ϣ ��ʼ*******************/
						PrpLinterInjuryPersonDto[] prpLinterInjuryPersonArray=prpLinterRequestDto.getPrpLinterInjuryPersonArrayDto();
						ArrayList prpLinjuryPersonList = new ArrayList();
						PrpLinjuryPersonDto prpLinjuryPersonDto=null;
						if(prpLinterInjuryPersonArray!=null&&prpLinterInjuryPersonArray.length>0){
							for(int i=0;i<prpLinterInjuryPersonArray.length;i++){
								PrpLinterInjuryPersonDto prpLinterInjuryPersonDto = prpLinterInjuryPersonArray[i];
								prpLinjuryPersonDto= new PrpLinjuryPersonDto();
								prpLinjuryPersonDto.setAcciName(prpLinterInjuryPersonDto.getAcciName());
								prpLinjuryPersonDto.setIdentifyNumber(prpLinterInjuryPersonDto.getIdentifyNumber());
								prpLinjuryPersonDto.setSex(prpLinterInjuryPersonDto.getSex());
								prpLinjuryPersonDto.setCompensateNo(compensateNo);
								prpLinjuryPersonList.add(prpLinjuryPersonDto);
							}
						}
						compensateDto.setPrpLinjuryPersonList(prpLinjuryPersonList);
						/*************************���м��ĳ�������ϸ��Ϣ����prpLinjuryPerson�����ű�ֻ���ϵͳ��Ϣ ��ʼ*******************/
						
						if(recaseFlag){
							//��������״̬������ɹ���ʶ
							prpLinterRecaseDetailDto.setComppSuccFlag("1");
							prpLinterRecaseDetailDto.setCompensateNo(compensateNo);
							prpLinterRecaseDetailDto.setRemark("����ɹ���"+compensateNo);
							new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
						}else{
							//��������״̬������ɹ���ʶ
							prplinterAutoClaimDetailDto.setComppSuccFlag("1");
							prplinterAutoClaimDetailDto.setRemark("����ɹ���"+compensateNo);
							blPrplinterAutoClaimDetailFacade.update(prplinterAutoClaimDetailDto);
						}
						
						//�ڴ���
						remark = "������ţ�"+compensateNo+" ���濪ʼ";
						utils.getPhisicaMemory(remark);
						//�ڴ���
						uiCompensateAction.save(compensateDto, workFlowDto);
						//�ڴ���
						remark = "������ţ�"+compensateNo+" �������";
						
						if(recaseFlag){
							
						}else{
							String sqlCompe = " Update swflog Set  submittime='"+prpLinterRequestDto.getCompeTime()
		                                                      +"' Where registno ='"+registNo+"' and nodeType='compe'";
							String sqlCompp = " Update swflog Set Flowintime='"+prpLinterRequestDto.getCompeTime()
											                  +"',handletime='"+prpLinterRequestDto.getCompeTime()
									                          +"',submittime='"+prpLinterRequestDto.getCompeTime()
									                         +"' Where registno ='"+registNo+"' and nodeType='compp'";
							String sqlVeric = " Update swflog Set Flowintime='"+prpLinterRequestDto.getCompeTime()
											                  +"',handletime='"+prpLinterRequestDto.getCompeTime()
											                  +"' Where registno ='"+registNo+"' and nodeType ='veric'";
							new BLPrplinterAutoClaimDetailFacade().updateBySQL(sqlCompe);
							new BLPrplinterAutoClaimDetailFacade().updateBySQL(sqlCompp);
							new BLPrplinterAutoClaimDetailFacade().updateBySQL(sqlVeric);
						}
					}
					
				}else{
					throw new Exception("û�з����빤������������κ����ݣ�");
				}
			}
		}catch(UserException ue){
			ue.printStackTrace();
			//PrplinterAutoClaimDetailDto  prplinterAutoClaimDetailDto  = blPrplinterAutoClaimDetailFacade.findByPrimaryKey(prpLinterRequestDto.getId(), registNo);
			String messege = ue.toString();
			if(messege!=null&&messege.length()>1000){
				messege = messege.substring(0,1000);
			}
			if(recaseFlag){
				prpLinterRecaseDetailDto.setComppSuccFlag("0");
				prpLinterRecaseDetailDto.setCompensateNo(compensateNo);
				prpLinterRecaseDetailDto.setRemark("����ʧ�ܣ�"+messege);
				new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
			}else{
				//��������״̬�������ʶ
				prplinterAutoClaimDetailDto.setComppSuccFlag("0");
				prplinterAutoClaimDetailDto.setRemark("����ʧ�ܣ�"+messege);
				blPrplinterAutoClaimDetailFacade.update(prplinterAutoClaimDetailDto);
			}
			throw ue;
		}catch(Exception e){
			e.printStackTrace();
			//PrplinterAutoClaimDetailDto  prplinterAutoClaimDetailDto  = blPrplinterAutoClaimDetailFacade.findByPrimaryKey(prpLinterRequestDto.getId(), registNo);
			String messege = e.toString();
			if(messege!=null&&messege.length()>1000){
				messege = messege.substring(0,1000);
			}
			if(recaseFlag){
				prpLinterRecaseDetailDto.setComppSuccFlag("0");
				prpLinterRecaseDetailDto.setCompensateNo(compensateNo);
				prpLinterRecaseDetailDto.setRemark("����ʧ�ܣ�"+messege);
				new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
			}else{
				prplinterAutoClaimDetailDto.setComppSuccFlag("0");
				prplinterAutoClaimDetailDto.setRemark("����ʧ�ܣ�"+messege);;
				blPrplinterAutoClaimDetailFacade.update(prplinterAutoClaimDetailDto);
			}
			throw e;
		}
		return prpLinterRequestDto;
	}
	
	public CompensateDto viewToDto(PrpLinterRequestDto prpLinterRequestDto,ClaimDto claimDto,PolicyDto policyDto,String compensateNo) throws Exception{
		CompensateDto compensateDto = new CompensateDto();
		UICompensateAction uiCompensateAction = new UICompensateAction();
		PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
		prpLcompensateDto.setCompensateNo(compensateNo);
		prpLcompensateDto.setLFlag(claimDto.getPrpLclaimDto().getLFlag());
		
		ArrayList list = (ArrayList) uiCompensateAction. findByConditions(" claimNo='"+claimDto.getPrpLclaimDto().getClaimNo()+"'");
		if(list==null||list.isEmpty()||list.size()<1){
			prpLcompensateDto.setTimes(1);
		}else{
			prpLcompensateDto.setTimes(list.size()+1);
		}
		prpLcompensateDto.setClassCode(claimDto.getPrpLclaimDto().getClassCode());
		prpLcompensateDto.setRiskCode(claimDto.getPrpLclaimDto().getRiskCode());
		prpLcompensateDto.setClaimNo(claimDto.getPrpLclaimDto().getClaimNo());
		prpLcompensateDto.setCaseNo(claimDto.getPrpLclaimDto().getCaseNo());
		prpLcompensateDto.setPolicyNo(claimDto.getPrpLclaimDto().getPolicyNo());
		prpLcompensateDto.setCurrency(claimDto.getPrpLclaimDto().getCurrency());
		prpLcompensateDto.setPreserveDate(new DateTime(prpLinterRequestDto.getCompeTime(), DateTime.YEAR_TO_DAY));
		prpLcompensateDto.setSumDutyPaid(prpLinterRequestDto.getPrplCompensateSumPaid());
		prpLcompensateDto.setSumNoDutyFee(prpLinterRequestDto.getSumNoDutyFee());
		//prpLcompensateDto.setSumPaid(prpLinterRequestDto.getSumThisPaid());
		prpLcompensateDto.setSumPaid(prpLinterRequestDto.getPrplCompensateSumPaid());
		prpLcompensateDto.setSumPrePaid(prpLinterRequestDto.getSumPrePaid());
		prpLcompensateDto.setSumThisPaid(prpLinterRequestDto.getSumThisPaid());
		prpLcompensateDto.setBank(prpLinterRequestDto.getBank());
		prpLcompensateDto.setReceiverName(prpLinterRequestDto.getReceiverName());
		prpLcompensateDto.setAccount(prpLinterRequestDto.getAccount());
		prpLcompensateDto.setMakeCom(prpLinterRequestDto.getMakeCom());
		prpLcompensateDto.setComCode(claimDto.getPrpLclaimDto().getComCode());
		prpLcompensateDto.setHandlerCode(prpLinterRequestDto.getOperatorCode());
		prpLcompensateDto.setHandler1Code(claimDto.getPrpLclaimDto().getHandler1Code());
		prpLcompensateDto.setStatisticsYM(new DateTime(prpLinterRequestDto.getCompeTime(), DateTime.YEAR_TO_DAY));
		prpLcompensateDto.setOperatorCode(prpLinterRequestDto.getVericUser());
		prpLcompensateDto.setInputDate(new DateTime(prpLinterRequestDto.getCompeTime(), DateTime.YEAR_TO_DAY));
		prpLcompensateDto.setDamageStartDate(prpLinterRequestDto.getDamageStartDate());
		prpLcompensateDto.setDamageStartHour(prpLinterRequestDto.getDamageStartHour());
		prpLcompensateDto.setIndemnityDutyRate(claimDto.getPrpLclaimDto().getIndemnityDutyRate());
		prpLcompensateDto.setIndemnityDuty(claimDto.getPrpLclaimDto().getIndemnityDuty());
		prpLcompensateDto.setFinallyFlag("1");
		prpLcompensateDto.setResult("1");
		prpLcompensateDto.setLossesNumber(prpLinterRequestDto.getLossesNumber());
		prpLcompensateDto.setStatus("1");
		prpLcompensateDto.setBusinessType(claimDto.getPrpLclaimDto().getBusinessType());
		prpLcompensateDto.setBusinessType1(claimDto.getPrpLclaimDto().getBusinessType1());
		prpLcompensateDto.setBusinessFlag(claimDto.getPrpLclaimDto().getBusinessFlag());
		prpLcompensateDto.setOtherFlag(claimDto.getPrpLclaimDto().getOtherFlag());
		prpLcompensateDto.setUnderWriteEndDate(new DateTime(prpLinterRequestDto.getVericTime(), DateTime.YEAR_TO_DAY));
		//prpLcompensateDto.setCaseType("2");
		//prpLcompensateDto.setMedicalType("02");
		if("2606".equals(prpLcompensateDto.getRiskCode())){
		   prpLcompensateDto.setMedicalType("99");
	    }
		compensateDto.setPrpLcompensateDto(prpLcompensateDto);
		
		//�ı���PrpLctextDto
		ArrayList prpLctextDtoList = new ArrayList();
		String [] compeContexts = StringUtils.split(prpLinterRequestDto.getCompeContext(), 70);
		// �õ����Ӵ�,���潫���зֵ�����
		for (int k = 0; k < compeContexts.length; k++) {
			PrpLctextDto prpLctextDto = new PrpLctextDto();
			prpLctextDto.setCompensateNo(compensateNo);
			prpLctextDto.setContext(compeContexts[k]);
			prpLctextDto.setLineNo(k + 1);
			prpLctextDto.setTextType("1");//���������
			prpLctextDtoList.add(prpLctextDto);
		}
		// compensateDto
		compensateDto.setPrpLctextDtoDtoList(prpLctextDtoList);
		
		
		//���������
		ArrayList prpLinjuryPersonList = new ArrayList();
		PrpLinjuryPersonDto prpLinjuryPersonDto = null;
		PrpLinterInjuryPersonDto[] prpLinterInjuryPersonArrayDto = prpLinterRequestDto.getPrpLinterInjuryPersonArrayDto();
		if(prpLinterInjuryPersonArrayDto!=null&&prpLinterInjuryPersonArrayDto.length>0){
			for (int i = 0; i < prpLinterInjuryPersonArrayDto.length; i++) {
				PrpLinterInjuryPersonDto prpLinterInjuryPersonDto = prpLinterInjuryPersonArrayDto[i];
				prpLinjuryPersonDto = new PrpLinjuryPersonDto();
				prpLinjuryPersonDto.setCompensateNo(compensateNo);
				prpLinjuryPersonDto.setAcciName(prpLinterInjuryPersonDto.getAcciName());
				prpLinjuryPersonDto.setIdentifyNumber(prpLinterInjuryPersonDto.getIdentifyNumber());
				prpLinjuryPersonDto.setSex(prpLinterInjuryPersonDto.getSex());
				prpLinjuryPersonList.add(prpLinjuryPersonDto);
			}
		}
		compensateDto.setPrpLinjuryPersonList(prpLinjuryPersonList);
		
		//�¹�����Ϣģ�� begin
		UIPolicyAction uiPolicyAction = new UIPolicyAction();
        String conditions = " policyno='"+prpLinterRequestDto.getPolicyno()+"'  ";
    	Collection collection = new ArrayList();
    	collection = uiPolicyAction.findPrpCinsuredDtoByConditions(conditions);
    	int familyNo = 1;
    	String familyName= "";
    	for(Iterator iterator = collection.iterator();iterator.hasNext();){
        	  PrpCinsuredDto prpCinsuredDto = (PrpCinsuredDto) iterator.next();
        	  if(prpCinsuredDto.getInsuredFlag().equals("1") ) {
        		  familyNo = prpCinsuredDto.getSerialNo();
        		  familyName = prpCinsuredDto.getInsuredName();
        	  }
        }
        ArrayList prpLacciBenPersonList = new ArrayList();
        PrpLinterAccdentPersonDto [] prpLinterAccdentPersonDtos = prpLinterRequestDto.getPrpLinterAccdentPersonDto();
        PrpLacciPersonDto   prpLacciBenPersonProposerDto = null;
        if(prpLinterAccdentPersonDtos!=null&&prpLinterAccdentPersonDtos.length>0){
        	for(int i=0;i<prpLinterAccdentPersonDtos.length;i++){
        		PrpLinterAccdentPersonDto prpLinterAccdentPersonDto = prpLinterAccdentPersonDtos[i];
        		prpLacciBenPersonProposerDto = new PrpLacciPersonDto();
        		//prpLacciBenPersonProposerDto
        		prpLacciBenPersonProposerDto.setCertiNo(prpLinterRequestDto.getRelationRegistNo());
            	prpLacciBenPersonProposerDto.setCertiType("01"); //�¹�����Ϣ
            	prpLacciBenPersonProposerDto.setPolicyNo(prpLinterRequestDto.getPolicyno());
            	prpLacciBenPersonProposerDto.setSerialNo(i+1);
            	prpLacciBenPersonProposerDto.setFamilyNo(familyNo);
            	prpLacciBenPersonProposerDto.setAcciCode(prpLinterAccdentPersonDto.getAcciCode());
            	prpLacciBenPersonProposerDto.setAcciName(prpLinterAccdentPersonDto.getAcciName());
            	prpLacciBenPersonProposerDto.setAge(prpLinterAccdentPersonDto.getAge());
            	prpLacciBenPersonProposerDto.setSex(prpLinterAccdentPersonDto.getSex());
            	prpLacciBenPersonProposerDto.setIdentifyNumber(prpLinterAccdentPersonDto.getIdentifyNumber());
            	//prpLacciBenPersonProposerDto.setAddress();
                //���뼯��
            	prpLacciBenPersonList.add(prpLacciBenPersonProposerDto);
        		
        	}
        }
        compensateDto.setPrpLacciBenPersonList(prpLacciBenPersonList);
        
        //������������Ϣ
        ArrayList prpLacciPersonList = new ArrayList();
        PrpLacciPersonDto prpLacciPersonProposerDto = null;
        PrpLinterClaimAppDto[] prpLinterClaimAppDtos = prpLinterRequestDto.getPrpLinterClaimAppDto();
        if(prpLinterClaimAppDtos!=null&&prpLinterClaimAppDtos.length>0){
        	for(int i=0;i<prpLinterClaimAppDtos.length;i++){
        		PrpLinterClaimAppDto prpLinterClaimAppDto = prpLinterClaimAppDtos[i];
        		prpLacciPersonProposerDto = new PrpLacciPersonDto();
                prpLacciPersonProposerDto.setAcciName(prpLinterClaimAppDto.getAcciName());
                prpLacciPersonProposerDto.setCertiNo(claimDto.getPrpLclaimDto().getClaimNo());
                prpLacciPersonProposerDto.setCertiType("03");
                prpLacciPersonProposerDto.setPolicyNo(prpLinterRequestDto.getPolicyno());
                prpLacciPersonProposerDto.setFlag("1");   //��־��������
                prpLacciPersonProposerDto.setIdentifyNumber(prpLinterClaimAppDto.getIdentifyNumber());
                prpLacciPersonProposerDto.setSerialNo(i+1);
                prpLacciPersonProposerDto.setAddress(prpLinterClaimAppDto.getProposerAddress());
                prpLacciPersonProposerDto.setFamilyNo(0);  //��ͥ���
                prpLacciPersonProposerDto.setPhone(prpLinterClaimAppDto.getPhone());
                prpLacciPersonProposerDto.setRelationCode(prpLinterClaimAppDto.getRelationCode());
                String relationName="";
                if("1".equals(prpLinterClaimAppDto.getRelationCode())){
                	relationName ="�������˱���";	
                }
                else if("2".equals(prpLinterClaimAppDto.getRelationCode())){
                	relationName ="ָ��������";	
                }
                else if("3".equals(prpLinterClaimAppDto.getRelationCode())){
                	relationName ="��������֮�̳���";	
                }
                else if("4".equals(prpLinterClaimAppDto.getRelationCode())){
                	relationName ="��������֮�໤��";	
                }
                prpLacciPersonProposerDto.setRelationName(relationName);
                prpLacciPersonProposerDto.setFamilyNo(1);
                //���뼯��
                prpLacciPersonList.add(prpLacciPersonProposerDto);
        	}
        }
        claimDto.setPrpLacciPersonDtoList(prpLacciPersonList);
        
        //״̬����
        PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
        prpLclaimStatusDto.setStatus("4");
        prpLclaimStatusDto.setBusinessNo(compensateNo);
        prpLclaimStatusDto.setPolicyNo(prpLcompensateDto.getPolicyNo());
        prpLclaimStatusDto.setNodeType("compe");
		prpLclaimStatusDto.setTypeFlag("2");
        prpLclaimStatusDto.setSerialNo(0);
        prpLclaimStatusDto.setRiskCode(prpLcompensateDto.getRiskCode());
        prpLclaimStatusDto.setHandlerCode(prpLcompensateDto.getHandlerCode());
        prpLclaimStatusDto.setInputDate(prpLcompensateDto.getInputDate());
        prpLclaimStatusDto.setOperateDate(new DateTime(prpLinterRequestDto.getVericTime(), DateTime.YEAR_TO_DAY));
        compensateDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
        
        //������Ϣ
        PrpLclaimDto prpLclaimDto = null;
		prpLclaimDto = new PrpLclaimDto();
		prpLclaimDto.setClaimNo(claimDto.getPrpLclaimDto().getClaimNo());
		prpLclaimDto.setSumPaid(prpLinterRequestDto.getPrplCompensateSumPaid());
		compensateDto.setPrpLclaimDto(prpLclaimDto);
        
        //�⸶��Ա��Ϣ
        ArrayList prpLpersonLossDtoList = new ArrayList();
        PrpLpersonLossDto prpLpersonLossDto = null;
        BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
        PrpLinterCompeFeeDto [] prpLinterCompeFeeDtos = prpLinterRequestDto.getPrpLinterCompeFeeDto();
        // ���ձ���Ϣѹ��ҳ����
     	//ArrayList damageKindList = policyDto.getPrpCitemKindDtoList();
		int intFamilyNo = 0;
		String strPolicyno = "";
		ArrayList benPersonKindList =  new ArrayList();
		Collection prplpersonlossDtoList = new ArrayList();
		//ArrayList prpCitemKindDtoCopyList = new ArrayList();
		//int intItemKindNo = 0;
     	if(prpLacciBenPersonList!=null&&!prpLacciBenPersonList.isEmpty()&&prpLacciBenPersonList.size()>0){
        	for (int index3=0;index3<prpLacciBenPersonList.size();index3++){
        		double hisPaid = 0.0d;
                double amountPaid = 0.0d;
        		PrpLacciPersonDto prpLacciPersonDtoOne = (PrpLacciPersonDto) prpLacciBenPersonList.get(index3);
				intFamilyNo = prpLacciPersonDtoOne.getFamilyNo();
				strPolicyno = prpLacciPersonDtoOne.getPolicyNo();
				//���ݰ�����������������������ȡ������Ϣʱֱ��ȡ��ʱ���±�����Ϣ�������е�����
				String sql = " policyno = '"+strPolicyno+"' and familyno = "+intFamilyNo;
				benPersonKindList = (ArrayList)blPrpCitemKindFacade.findByConditions(sql);
        		for(int j=0;j<benPersonKindList.size();j++){
        			PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) benPersonKindList.get(j);
        			//hisPaid+=prpCitemKindDto.getHisPaid();
        			String strItemKindQueryCon1 = " policyNo='"+prpCitemKindDto.getPolicyNo()+"' AND FamilyNo="+
        					intFamilyNo+" AND ItemKindNo="+prpCitemKindDto.getItemKindNo();
        			
        			prplpersonlossDtoList = uiCompensateAction.findPersonLossByConditions(strItemKindQueryCon1);
        			//�ۼ���ʷ��¼���
        			Iterator itpersonloss = prplpersonlossDtoList.iterator();
        			while (itpersonloss.hasNext())
        			{
        				prpLpersonLossDto = (PrpLpersonLossDto)itpersonloss.next();
        				hisPaid = hisPaid+prpLpersonLossDto.getSumRealPay();	
        			}
        			amountPaid+=prpCitemKindDto.getAmount();
        			
        		}
        		
        		prpLacciPersonDtoOne.setHisPaid(hisPaid);
        		prpLacciPersonDtoOne.setAmountPaid(amountPaid);
        		
         		
        	}
        }
     	
        if(prpLinterCompeFeeDtos!=null&&prpLinterCompeFeeDtos.length>0){
        	for(int i=0;i<prpLinterCompeFeeDtos.length;i++){
        		PrpLinterCompeFeeDto prpLinterCompeFeeDto =prpLinterCompeFeeDtos[i];
        		prpLpersonLossDto = new PrpLpersonLossDto();
        		prpLpersonLossDto.setCompensateNo(compensateNo);
                prpLpersonLossDto.setPolicyNo(claimDto.getPrpLclaimDto().getPolicyNo());
                prpLpersonLossDto.setRiskCode(claimDto.getPrpLclaimDto().getRiskCode());
                prpLpersonLossDto.setSerialNo(i+1);
                if(prpLacciBenPersonList!=null&&!prpLacciBenPersonList.isEmpty()&&prpLacciBenPersonList.size()>0){
                	for (int index3=0;index3<prpLacciBenPersonList.size();index3++){
                		if(((PrpLacciPersonDto)prpLacciBenPersonList.get(index3)).getSerialNo()==prpLinterCompeFeeDto.getItemKindNo()){
                			PrpLacciPersonDto prpLacciPersonDtoTemp = (PrpLacciPersonDto) prpLacciBenPersonList.get(index3);
                			prpLpersonLossDto.setIdentifyNumber(prpLacciPersonDtoTemp.getIdentifyNumber());
                			prpLpersonLossDto.setFamilyNo(prpLacciPersonDtoTemp.getFamilyNo());
                			prpLpersonLossDto.setFamilyName(familyName);
                			prpLpersonLossDto.setAge(prpLacciPersonDtoTemp.getAge());
                			prpLpersonLossDto.setPersonNo(Integer.parseInt(DataUtils.nullToZero(""+prpLinterCompeFeeDto.getItemKindNo())));
                			prpLpersonLossDto.setPersonName(prpLacciPersonDtoTemp.getAcciName());
                			prpLpersonLossDto.setSex(prpLacciPersonDtoTemp.getSex());
                			prpLpersonLossDto.setMaxpaid(prpLacciPersonDtoTemp.getAmountPaid());
                			prpLpersonLossDto.setHispaid(prpLacciPersonDtoTemp.getHisPaid());
                			
                		}
                		
                	}
                }
                prpLpersonLossDto.setKindCode(prpLinterCompeFeeDto.getKindCode());
                prpLpersonLossDto.setItemKindNo(Integer.parseInt(DataUtils.nullToZero(""+prpLinterCompeFeeDto.getItemKindNo())));
                
                
                prpLpersonLossDto.setCurrency(prpLinterCompeFeeDto.getCurrency());
                prpLpersonLossDto.setAmount(claimDto.getPrpLclaimDto().getSumAmount());
                prpLpersonLossDto.setCurrency1(claimDto.getPrpLclaimDto().getCurrency());
                prpLpersonLossDto.setCurrency2(prpLinterCompeFeeDto.getCurrency());
                prpLpersonLossDto.setSumRest(prpLinterCompeFeeDto.getSumRest());
                prpLpersonLossDto.setClaimRate(prpLinterCompeFeeDto.getClaimRete());
                prpLpersonLossDto.setDeductible(prpLinterCompeFeeDto.getDeductible());
                prpLpersonLossDto.setCurrency4(prpLinterCompeFeeDto.getCurrency());
                prpLpersonLossDto.setSumRealPay(prpLinterCompeFeeDto.getSumRealPay());
                prpLpersonLossDto.setInjuryGrade("");
                prpLpersonLossDto.setHospitalDays(0);
                prpLpersonLossDto.setInHospDate(new DateTime(prpLinterRequestDto.getVericTime(), DateTime.YEAR_TO_DAY));
                prpLpersonLossDto.setOutHospDate(new DateTime(new DateTime(prpLinterRequestDto.getVericTime(), DateTime.YEAR_TO_DAY)));                
                
                prpLpersonLossDto.setLossQuantity(0);
                prpLpersonLossDto.setSumLoss(prpLinterCompeFeeDto.getSumLoss());

                prpLpersonLossDto.setCurrency3(prpLinterCompeFeeDto.getCurrency());
               
                prpLpersonLossDto.setIndemnityDutyRate(0.0d);
                prpLpersonLossDto.setDeductibleRate(0.0d);
                prpLpersonLossDto.setRemark(prpLinterCompeFeeDto.getRemark());
                //���뼯��
                prpLpersonLossDtoList.add(prpLpersonLossDto);
        		
        	}
        }
        compensateDto.setPrpLpersonLossDtoList(prpLpersonLossDtoList);
        ArrayList prpllossDtoList = new ArrayList();
        compensateDto.setPrpLlossDtoList(prpllossDtoList);
        
        //��������Ϣ
        ArrayList prpLchargeDtoList = new ArrayList();
        PrpLchargeDto prpLchargeDto = null;
        PrpLinterCompePayFeeDto[] prpLinterCompePayFeeDtos = prpLinterRequestDto.getPrpLinterCompePayFeeDto();
        if(prpLinterCompePayFeeDtos!=null&&prpLinterCompePayFeeDtos.length>0){
        	for(int i=0;i<prpLinterCompePayFeeDtos.length;i++){
        		PrpLinterCompePayFeeDto prpLinterCompePayFeeDto = prpLinterCompePayFeeDtos[i];
        		prpLchargeDto = new PrpLchargeDto();
                prpLchargeDto.setPolicyNo(claimDto.getPrpLclaimDto().getPolicyNo());
                prpLchargeDto.setRiskCode(claimDto.getPrpLclaimDto().getRiskCode());
                prpLchargeDto.setCompensateNo(compensateNo);

                prpLchargeDto.setSerialNo(i+1);
                prpLchargeDto.setKindCode(prpLinterCompePayFeeDto.getKindCode());
                prpLchargeDto.setChargeCode(prpLinterCompePayFeeDto.getCodeCode());
                prpLchargeDto.setChargeName(prpLinterCompePayFeeDto.getCodeCName());
                /* ��ҽ�Ʊ���ʵ���в����ڴ��鿱���
                 * if(prpLinterCompePayFeeDto.getCodeCode()!=null&&"14".equals(prpLinterCompePayFeeDto.getCodeCode())){
					prpLchargeDto.setCheckDeptCode("");
					prpLchargeDto.setCheckDeptName(prpLinterCompePayFeeDto.getCodeCode());
	            }*/
                prpLchargeDto.setCurrency(prpLinterCompePayFeeDto.getCurrency());
                prpLchargeDto.setChargeAmount(prpLinterCompePayFeeDto.getChargeAmount());
                prpLchargeDto.setPreChargeAmount(prpLinterCompePayFeeDto.getPreChargeAmount());
                prpLchargeDto.setSumRealPay(prpLinterCompePayFeeDto.getSumRealPay());
                prpLchargeDto.setFlag("");
                prpLchargeDto.setItemkindno(prpLinterCompePayFeeDto.getItemKindNo());
                prpLchargeDtoList.add(prpLchargeDto);
        	}
        }
        compensateDto.setPrpLchargeDtoList(prpLchargeDtoList);
        
        //����������Ϣ
        ArrayList prpLcfeeDtoList = new ArrayList();
        PrpLcfeeDto prpLcfeeDto = null;
        //����ֵ
        
        prpLcfeeDto = new PrpLcfeeDto();
        prpLcfeeDto.setCompensateNo(compensateNo);
        prpLcfeeDto.setPolicyNo(prpLinterRequestDto.getPolicyno());
        prpLcfeeDto.setRiskCode(claimDto.getPrpLclaimDto().getRiskCode());
        prpLcfeeDto.setCurrency(claimDto.getPrpLclaimDto().getCurrency());
        prpLcfeeDto.setSumPaid(prpLinterRequestDto.getSumThisPaid());
        prpLcfeeDto.setFlag("");
        prpLcfeeDtoList.add(prpLcfeeDto);
        compensateDto.setPrpLcfeeDtoList(prpLcfeeDtoList);
        
        //Σ�յ�λ��Ϣ
        Map kindMap = new HashMap();
		//ƴ�ӱ�����ʹ��
		String strKindCodeList = "";
		List prpdangerUnitList = new ArrayList();
        
        for (int i = 0; i < prpLchargeDtoList.size(); i++) {
        	PrpLchargeDto prpLchargeDtoTemp = (PrpLchargeDto) prpLchargeDtoList.get(i);
        	String itemKindNo = prpLchargeDtoTemp.getItemkindno()+"";
			if (kindMap.containsKey(itemKindNo)) {
				String tempSumLoss="";
				if(prpLchargeDtoTemp.getSumRealPay()==0&&prpLchargeDtoTemp.getChargeAmount()!=0){
					tempSumLoss = String.valueOf((prpLchargeDtoTemp.getChargeAmount() + Double.parseDouble(""+ kindMap.get(itemKindNo))));
					
				}else if(prpLchargeDtoTemp.getSumRealPay()!=0&&prpLchargeDtoTemp.getChargeAmount()==0){
					tempSumLoss = String.valueOf(prpLchargeDtoTemp.getSumRealPay() + Double.parseDouble(""+ kindMap.get(itemKindNo)));
				}else if(prpLchargeDtoTemp.getChargeAmount()==0&&prpLchargeDtoTemp.getSumRealPay()==0){
					tempSumLoss ="0";
				}else if(prpLchargeDtoTemp.getSumRealPay()!=0&&prpLchargeDtoTemp.getChargeAmount()!=0){
					if (prpLchargeDtoTemp.getChargeAmount()<prpLchargeDtoTemp.getSumRealPay()) {
						tempSumLoss = String.valueOf((prpLchargeDtoTemp.getSumRealPay() + Double.parseDouble(""+ kindMap.get(itemKindNo))));
					} else {
						tempSumLoss = String.valueOf((prpLchargeDtoTemp.getChargeAmount()+ Double.parseDouble(""+ kindMap.get(itemKindNo))));
					}
				}
				kindMap.put(itemKindNo, tempSumLoss);
			} else {
				if (i != 0) {
					strKindCodeList += ",";
				}
				strKindCodeList += "'" + itemKindNo + "'";
				if(prpLchargeDtoTemp.getSumRealPay()==0&&prpLchargeDtoTemp.getChargeAmount()!=0){
					kindMap.put(itemKindNo,prpLchargeDtoTemp.getChargeAmount());
					
				}else if(prpLchargeDtoTemp.getSumRealPay()!=0&&prpLchargeDtoTemp.getChargeAmount()==0){
					kindMap.put(itemKindNo,prpLchargeDtoTemp.getSumRealPay());
				}else if(prpLchargeDtoTemp.getChargeAmount()==0&&prpLchargeDtoTemp.getSumRealPay()==0){
					kindMap.put(itemKindNo,0);
				}else if(prpLchargeDtoTemp.getChargeAmount()!=0&&prpLchargeDtoTemp.getSumRealPay()!=0){
					if (prpLchargeDtoTemp.getChargeAmount()<prpLchargeDtoTemp.getSumRealPay()) {
						kindMap.put(itemKindNo,prpLchargeDtoTemp.getSumRealPay());
					} else {
						kindMap.put(itemKindNo,prpLchargeDtoTemp.getChargeAmount());
					}
				}
			}
		}
		
		for (int i = 0; i < prpLpersonLossDtoList.size(); i++) {
			PrpLpersonLossDto prpLpersonLossDtoTemp = (PrpLpersonLossDto) prpLpersonLossDtoList.get(i);
			String itemKindNo = prpLpersonLossDtoTemp.getItemKindNo()+"";
			if (kindMap.containsKey(itemKindNo)) {
				String tempSumLoss = String.valueOf(prpLpersonLossDtoTemp.getSumRealPay() + Double.parseDouble(""+ kindMap.get(itemKindNo)));
				kindMap.put(itemKindNo, tempSumLoss);
			} else {
				if (!kindMap.isEmpty()) {
					strKindCodeList += ",";
				}
				strKindCodeList += "'" + itemKindNo+ "'";
				kindMap.put(itemKindNo,prpLpersonLossDtoTemp.getSumRealPay());

			}
		}
		//���ݱ�Ĵ����ѯ���ݿ�Σ�յ�λ��Ϣ  start
	    DBPrpPhead dbPrpPhead = new DBPrpPhead();
		BLDangerUnitFacade blDangerFacade = new BLDangerUnitFacade();
		// ����ڳ���ʱ��֮ǰ�������ģ���ȡpdangunit������ݣ�����ȡcdangunit�������
		String wherepart = " policyno='" + prpLinterRequestDto.getPolicyno()
				+ "' and validdate <= date '"
				+ prpLinterRequestDto.getDamageStartDate() + "' "
				+"  and underwriteflag in ('1','3')";
		int count = dbPrpPhead.getCount(wherepart);
		
		if (count == 0) {
			prpdangerUnitList = blDangerFacade.getCompensatePrpCdangerUnit( prpLinterRequestDto.getPolicyno(), strKindCodeList);
		}else{
			prpdangerUnitList = blDangerFacade.getCompensatePrpPdangerUnit(prpLinterRequestDto.getRelationRegistNo(), prpLinterRequestDto.getPolicyno(), strKindCodeList);
		}
        
		double dbSumLoss = 0D;
        double dbshare = 0D;
        double tempSumLoss=0D;
        //Σ�յ�λ������ձ��������һλ����ԭ����
        boolean dangFlag = false;
        NewDangerUnitDto  newDangerUnitDto=null;
        for(int i=0;i<prpdangerUnitList.size();i++){
        	newDangerUnitDto= (NewDangerUnitDto)prpdangerUnitList.get(i);
        	dbSumLoss = Double.parseDouble(DataUtils.nullToZero(""+ kindMap.get(newDangerUnitDto.getItemkindno())));
        	dbshare = Double.parseDouble(DataUtils.nullToZero(newDangerUnitDto.getDangerkindshare()));
        	dangFlag = false;
            for(int j=i+1;j<prpdangerUnitList.size();j++){
            	NewDangerUnitDto  newDangerUnitDtoTemp= (NewDangerUnitDto)prpdangerUnitList.get(j);
            	if (newDangerUnitDtoTemp.getItemkindno().equals(newDangerUnitDto.getItemkindno())) {
            		dangFlag = true;
				break;
            	}
            }
            if(dangFlag){
            	dbSumLoss = Str.round((dbSumLoss * (dbshare/100)),2); 
            	newDangerUnitDto.setDangerkindAmount(""+dbSumLoss);
            }else{
        		tempSumLoss = 0;
        		for(int k=0;k<i;k++){
        			NewDangerUnitDto  newDangerUnitDtoTemp= (NewDangerUnitDto)prpdangerUnitList.get(k);
        			if(newDangerUnitDtoTemp.getItemkindno().equals(newDangerUnitDto.getItemkindno())){
       					tempSumLoss+=Double.parseDouble(DataUtils.nullToZero(newDangerUnitDtoTemp.getDangerkindAmount())); 
       			 	} 
            	}
        		newDangerUnitDto.setDangerkindAmount(""+Str.round((dbSumLoss-tempSumLoss),2));
            }
        }
        
        //prpdangerUnitList
        String strCoinsFlag = policyDto.getPrpCmainDto().getCoinsFlag();
		BLPrpLdangerUnitFacade blPrpLdangerUnitFacade = new BLPrpLdangerUnitFacade();
		PrpLdangerUnitDto prpLdangerUnitClaimDto = new PrpLdangerUnitDto();
		
		ArrayList  dangerUnitList = new ArrayList();
		ArrayList  dangerItemList = new ArrayList();
		ArrayList  dangerTotList = new ArrayList();
   
       	double temp=0;
       	double sumDangerUnit=0d;
       	boolean flag=true; 
       	String sql="";
       	NewDangerUnitDto  newDangerUnitDto2=null;
       	if(prpdangerUnitList!=null&&!prpdangerUnitList.isEmpty()){
        	for(int i=0;i<prpdangerUnitList.size();i++){
        		PrpLdangerItemDto prpLdangerItemDto=null;
        		newDangerUnitDto2= (NewDangerUnitDto)prpdangerUnitList.get(i);
        		if(Double.parseDouble(newDangerUnitDto2.getDangerkindAmount())!=0&&Double.parseDouble(newDangerUnitDto2.getDangerkindshare())!=0){
        			prpLdangerItemDto= new PrpLdangerItemDto();       
    				prpLdangerItemDto.setCertiNo(compensateNo); // �������
    				prpLdangerItemDto.setDangerNo(Integer.parseInt(newDangerUnitDto2.getDangerno())); //Σ�յ�λ
    				prpLdangerItemDto.setCurrency(newDangerUnitDto2.getCurrency()); // ��ʧ�ұ�
    				prpLdangerItemDto.setKindFlag("0"); // �ձ�����־,0��ʾ����
    				prpLdangerItemDto.setKindCode(newDangerUnitDto2.getKindcode());    
    				prpLdangerItemDto.setKindName(newDangerUnitDto2.getKindname());  
    				prpLdangerItemDto.setRiskCode(newDangerUnitDto2.getRiskcode()); 
    				prpLdangerItemDto.setAddressName(newDangerUnitDto2.getAddressname());
    				prpLdangerItemDto.setPolicyno(newDangerUnitDto2.getPolicyno());
    				prpLdangerItemDto.setDangerdesc(newDangerUnitDto2.getDangerdesc());
    				prpLdangerItemDto.setItemcode(newDangerUnitDto2.getItemcode());
    				prpLdangerItemDto.setItemname(newDangerUnitDto2.getItemname());
    				prpLdangerItemDto.setSumPaid(Str.round(Double.parseDouble(newDangerUnitDto2.getDangerkindAmount()),2)); 
    				prpLdangerItemDto.setSerialNo(Integer.parseInt(newDangerUnitDto2.getItemkindno())); // ������
    				//prpLdangerItemDto.setDangerKindShare(Str.round(Double.parseDouble(newDangerUnitDto2.getDangerkindshare()),2));
    				
    				//ռ�����һ������ԭ��
     				flag=true;
     				NewDangerUnitDto newDangerUnitDto_i= (NewDangerUnitDto)prpdangerUnitList.get(i);
     	            for(int j=i+1;j<prpdangerUnitList.size();j++){
     	            	NewDangerUnitDto newDangerUnitDto_j= (NewDangerUnitDto)prpdangerUnitList.get(j);
	                	if(newDangerUnitDto_i.getItemkindno().equals(newDangerUnitDto_j.getItemkindno())){
	     	            	flag=false;
	     	        	}
     	            }
     	            if(flag){
     	        		temp=0;
     	        		for(int k=1;k<i;k++){
     	        			NewDangerUnitDto newDangerUnitDto_k= (NewDangerUnitDto)prpdangerUnitList.get(k);
     	        			if(newDangerUnitDto_k.getItemkindno().equals(newDangerUnitDto_i.getItemkindno())){
	    	                	temp+=Str.round(Double.parseDouble(newDangerUnitDto_k.getDangerkindshare()),2);
	    	               	}
     	               	}
     	               	prpLdangerItemDto.setDangerKindShare(Str.round(100-temp,2));
     	            }else{
     	                prpLdangerItemDto.setDangerKindShare(Double.parseDouble(newDangerUnitDto_i.getDangerkindshare()));
     	            }
    				sumDangerUnit+=Str.round(Double.parseDouble(newDangerUnitDto2.getDangerkindAmount()),2);
        		}
        		if(prpLdangerItemDto!=null){
        			dangerItemList.add(prpLdangerItemDto);
        		} 
        	}
        	if(dangerItemList.size()>0){
             	compensateDto.setPrpLprpLdangerItemList(dangerItemList);
           }
        }
       	//2�����ɴ�Σ�յ�λ����ϼ�PrpLdangerTot������prpLdangerItem��
        
       	Iterator     iterator   = null;
        PrpLdangerTotDto prpLdangerTotNewDto   = null; 
        Iterator      itTot  = null;
        PrpLdangerItemDto prpLdangerItemNewDto = null;       //���DTO
        boolean find = true;
        if (dangerItemList  != null){
        	iterator = dangerItemList.iterator();
        	while(iterator.hasNext()){
        		prpLdangerItemNewDto = (PrpLdangerItemDto)iterator.next();
        		find = false;
        		itTot = dangerTotList.iterator();
        		while(itTot.hasNext())
        		{
        			prpLdangerTotNewDto = (PrpLdangerTotDto)itTot.next();
        			if (prpLdangerTotNewDto.getDangerNo() == prpLdangerItemNewDto.getDangerNo())
        			{
        				find = true;
        				prpLdangerTotNewDto.setSumPaid(Str.round(prpLdangerTotNewDto.getSumPaid()+prpLdangerItemNewDto.getSumPaid(),2));
        				prpLdangerTotNewDto.setSumPaidEx(Str.round(prpLdangerTotNewDto.getSumPaidEx()+prpLdangerItemNewDto.getSumPaid(),2));
        				break;
        			}
        		}
        		//ÿ��Σ�յ�λ��ĵĵ�һ�����ݵ�����
        		if (find == false)
        		{
        			prpLdangerTotNewDto = new PrpLdangerTotDto();
                    
        			prpLdangerTotNewDto.setCertiNo(compensateNo);
        			prpLdangerTotNewDto.setDangerNo(prpLdangerItemNewDto.getDangerNo());                        
        			prpLdangerTotNewDto.setSCurrency(prpLdangerItemNewDto.getCurrency());   //���ԭ�ұ�
        			prpLdangerTotNewDto.setSumFee(0);
        			prpLdangerTotNewDto.setSumPaid(prpLdangerItemNewDto.getSumPaid());
    		    	prpLdangerTotNewDto.setTCurrency(prpLdangerItemNewDto.getCurrency());
    		    	prpLdangerTotNewDto.setExchRate(1);
    		    	prpLdangerTotNewDto.setSumFeeEx(0);
    		    	prpLdangerTotNewDto.setSumPaidEx(prpLdangerItemNewDto.getSumPaid());
    		  	 	 //���뼯��
                	 if(prpLdangerTotNewDto!=null){
                		dangerTotList.add(prpLdangerTotNewDto);
                	 }
            		
        		}
          
        	}

        	if(dangerTotList.size()>0){
        		compensateDto.setPrpLprpLdangerTotList(dangerTotList);
        	}
        }
        //3������Σ�յ�λprpLdangerUnit
        
        Iterator      itUnit  = null;
        PrpLdangerUnitDto prpLdangerUnitNewDto=null;
        if (dangerItemList != null){
        	iterator = dangerItemList.iterator();
        	while(iterator.hasNext()){
        		prpLdangerItemNewDto = (PrpLdangerItemDto)iterator.next();
        		find = false;
        		itUnit = dangerUnitList.iterator();
        		while(itUnit.hasNext())
        		{
        			prpLdangerUnitNewDto = (PrpLdangerUnitDto)itUnit.next();
        			if (prpLdangerUnitNewDto.getDangerNo() == prpLdangerItemNewDto.getDangerNo())
        			{
        				find = true;
        				prpLdangerUnitNewDto.setSumPaid(Str.round(prpLdangerUnitNewDto.getSumPaid()+prpLdangerItemNewDto.getSumPaid(),2));
        				break;
        			}
        		}
        		
        		//ÿ��Σ�յ�λ��ĵĵ�һ�����ݵ�����
        		if (find == false)
        		{
                	
        			prpLdangerUnitNewDto = new PrpLdangerUnitDto();
        			prpLdangerUnitNewDto.setCertiNo(compensateNo);
        			prpLdangerUnitNewDto.setClaimNo(compensateDto.getPrpLcompensateDto().getClaimNo());
        			prpLdangerUnitNewDto.setCertiType("3");
        			prpLdangerUnitNewDto.setRiskCode(prpLdangerItemNewDto.getRiskCode());
        			prpLdangerUnitNewDto.setPolicyNo(prpLdangerItemNewDto.getPolicyno());
        			prpLdangerUnitNewDto.setDangerNo(prpLdangerItemNewDto.getDangerNo());
        			prpLdangerUnitNewDto.setDangerDesc(prpLdangerItemNewDto.getDangerdesc());
        			prpLdangerUnitNewDto.setAddressName(prpLdangerItemNewDto.getAddressName());
        			prpLdangerUnitNewDto.setCurrency(prpLdangerItemNewDto.getCurrency());
        			prpLdangerUnitNewDto.setSumPaid(prpLdangerItemNewDto.getSumPaid());
        			prpLdangerUnitNewDto.setSumFee(0);
        			prpLdangerUnitNewDto.setCoinsFlag(strCoinsFlag);
        			prpLdangerUnitNewDto.setDamageDate(compensateDto.getPrpLcompensateDto().getDamageStartDate());
              	     
              	    //���뼯��
                	if(prpLdangerUnitNewDto!=null){
                		dangerUnitList.add(prpLdangerUnitNewDto);
                	}
        		}
        		
        	}
        	//���һ��ռ�ȼ���ԭ��
        	double dangerShare = 0;
        	double tempSumDangerShare = 0;
   	     	double tempSumLossUnit=0;
   	     	double sumTempSumLoss=0;
   	     	double tempSumNoPaid=0;
   	     	double sumTempNoPaid=0;
   	     	PrpLdangerUnitDto prpLdangerUnitDtotemp=null;
   	     	for (int i=0;i<dangerUnitList.size();i++){
   	     		prpLdangerUnitDtotemp=(PrpLdangerUnitDto)dangerUnitList.get(i);
   	     			if(i==(dangerUnitList.size()-1))
   	     			{
   	     				dangerShare = Str.round(100-tempSumDangerShare,2);
   	     				tempSumNoPaid = Str.round(claimDto.getPrpLclaimDto().getSumClaim()-claimDto.getPrpLclaimDto().getSumPaid()-sumTempNoPaid,2);
   	     			tempSumLossUnit = Str.round(claimDto.getPrpLclaimDto().getSumClaim()-sumTempSumLoss,2);
   	     			}else
   	     			{
   	     				dangerShare = Str.round(prpLdangerUnitDtotemp.getSumPaid()/sumDangerUnit*100,2);
   	     				tempSumDangerShare = Str.round(tempSumDangerShare+dangerShare, 2);
   	     				tempSumNoPaid = Str.round((claimDto.getPrpLclaimDto().getSumClaim()-claimDto.getPrpLclaimDto().getSumPaid())*dangerShare/100,2);
   	     				sumTempNoPaid = Str.round(sumTempSumLoss+tempSumLossUnit, 2);
   	     			tempSumLossUnit = Str.round(claimDto.getPrpLclaimDto().getSumClaim()*dangerShare/100,2);
   	     				sumTempSumLoss = Str.round(sumTempSumLoss+tempSumLossUnit, 2);
   	     			}
   	     			prpLdangerUnitDtotemp.setDangerShare(dangerShare);
        			prpLdangerUnitDtotemp.setClaimDate(claimDto.getPrpLclaimDto().getClaimDate());
        			prpLdangerUnitDtotemp.setSumLoss(tempSumLossUnit);
            		prpLdangerUnitDtotemp.setSumNoPaid(0);  //�᰸  δ���������
        			
 	       	 	}
   	     		if(dangerUnitList.size()>0){
   	     			compensateDto.setPrplRiskUnitDtoList(dangerUnitList);
   	     		}
 	        }
        
        
		return compensateDto;
	}
}
