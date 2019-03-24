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
 * 大病医疗接口自动理算子类，此类作出如下操作
 * 1.	根据立案号码生成计算书号，组织计算书主表数据。
 * 2.	根据中间表数据组织理算相关业务数据。
 * 3.	根据中间表数据组织危险单位对象
 * 4.	处理理算计算书工作流
 * 5.	完成对理算业务数据及工作流数据的存储
 * 6.	更新流程状态表理算环节状态
 * 
 * @author chu
 *
 */
public class UIMedicalAutoCompeSubViewHelper {
	/**
	 * 大病医疗接口自动理算子类主流程方法，处理自动理算的业务数据和工作流数据
	 * @param prpLinterRequestDto 传入参数为中间表大对象
	 * @return 处理过的中间表大对象
	 * @throws Exception
	 */
	public PrpLinterRequestDto autoCompe (PrpLinterRequestDto prpLinterRequestDto) throws Exception{
		/**重开赔案流程状态及标识*/
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
		//组织UserDto对象
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
		Utils utils = new Utils();//检查内存
		String remark  = "";
		String compensateNo = "";
		try{
			int newCompensateFlag = -1; // 默认不需要重新生成赔款计算书,后来决定不需要用工作流保存每个计算书的状态
			SwfLogDto swfLogDtoDealNode = new SwfLogDto();
			String conditions = " registno='"+registNo+"' and nodeType='compe' and nodeStatus='0' ";
			ArrayList<SwfLogDto> swflogList  = (ArrayList<SwfLogDto>) new UIWorkFlowAction().findNodesByConditions(conditions);
			//判断是否有未处理的理算节点需要处理，如果没有理算节点需处理直接抛出异常
			if(swflogList!=null&&!swflogList.isEmpty()&&swflogList.size()>0){
				swfLogDtoDealNode = swflogList.get(0);
			}else {
				throw new Exception("未查询出待处理的理算工作流");
			}
			String flowID = swfLogDtoDealNode.getFlowID();
			int logNo = swfLogDtoDealNode.getLogNo();
			conditions = " registno='"+registNo+"' ";
			ArrayList<PrpLclaimDto> claimList  = (ArrayList<PrpLclaimDto>) blPrpLclaimFacadeBase.findByConditions(conditions);
			PrpLclaimDto prpLclaimDto = null;
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,damageDate,damageHoure);
			if(policyDto==null||policyDto.getPrpCmainDto()==null){
				throw new Exception("未查询出相关承保信息，请确认出入参数的保单号码是否合法!");
			}
			int year = DateTime.current().getYear();
			
			if(claimList==null||claimList.isEmpty()||claimList.size()<1){
				throw new Exception("此案件没有合法的赔案号，无法处理理算");
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
				swfLogDtoDealNode.setBusinessNo(compensateDto.getPrpLcompensateDto().getClaimNo()); // 本节点的查找
				swfLogDtoDealNode.setNextBusinessNo(compensateDto.getPrpLcompensateDto().getCompensateNo());
				swfLogDtoDealNode.setKeyIn(compensateDto.getPrpLcompensateDto().getClaimNo());
				swfLogDtoDealNode.setNodeStatus("4");
				
				swfLogDtoDealNode.setKeyOut(compensateDto.getPrpLcompensateDto().getCompensateNo());
				WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
				
				if (workFlowViewHelper.checkDealDto(workFlowDto)) {
					// reason:直接保存业务数据导致工作流数据丢失，所以提交前需要暂时保存到正在处理的状态。
					// 提交前的暂时保存
					WorkFlowDto workFlowDtoTemp = null;
					swfLogDtoDealNode.setNodeStatus("2");
					workFlowDtoTemp = workFlowViewHelper.viewToDto(user,
							swfLogDtoDealNode);
					Collection swfLogDtoTmpList = workFlowDtoTemp.getSubmitSwfLogDtoList();
					/************************添加标志 开始***********************/
					Iterator iterTmp= swfLogDtoTmpList.iterator();
					ArrayList submListTmp = new ArrayList();
					while(iterTmp.hasNext()){
						SwfLogDto swfLogDtoTmp = (SwfLogDto)iterTmp.next();
						swfLogDtoTmp.setMedicalTransitFlag("1");
						submListTmp.add(swfLogDtoTmp);
					}
					workFlowDtoTemp.setSubmitSwfLogDtoList(submListTmp);
					/*************************添加标志 结束**********************/
					// 暂存计算书节点时将理算节点状态置为已处理
					UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
					SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(flowID, logNo);
					if (swfLogDto.getNodeType().equals("compe")) {
						swfLogDto.setNodeStatus("4");
						swfLogDto.setMedicalTransitFlag("1");//
						workFlowDtoTemp.setUpdate(true);
						workFlowDtoTemp.setUpdateSwfLog2Dto(swfLogDto);
					}
					// 如果提交核赔失败则状态为0
					compensateDto.getPrpLcompensateDto().setUnderWriteFlag("0");
					uiCompensateAction.save(compensateDto, workFlowDtoTemp);

					// 如果提交核赔则状态为9
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
						String msg = "案件'" + compensateNo
								+ "'提交双核系统失败，请重新提交或者与管理员联系!";
						throw new UserException(1, 3, "工作流", msg);
					}
					
					// 休整 workFlowDtoTemp 和workFlowDto
					int newCompeLogNo = 0;
					if (workFlowDtoTemp.getSubmitSwfLogDtoList() != null) {
						newCompeLogNo = ((SwfLogDto) workFlowDtoTemp.getSubmitSwfLogDtoList().get(0)).getLogNo();
						((SwfLogDto) workFlowDtoTemp.getSubmitSwfLogDtoList().get(0)).setNodeStatus("4");
						workFlowDto.setUpdate(true);
						workFlowDto.setUpdateSwfLogDto((SwfLogDto) workFlowDtoTemp.getSubmitSwfLogDtoList().get(0));
						if (workFlowDto.getSubmitSwfLogDtoList() != null) {
							// 删除多余的点
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
							// 删除多余的边
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
							//更新流程状态表理算成功标识
							prpLinterRecaseDetailDto.setComppSuccFlag("1");
							prpLinterRecaseDetailDto.setCompensateNo(compensateNo);
							prpLinterRecaseDetailDto.setRemark("理算成功："+compensateNo);
							new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
						}else{
							//更新流程状态表理算成功标识
							prplinterAutoClaimDetailDto.setComppSuccFlag("1");
							prplinterAutoClaimDetailDto.setRemark("理算成功："+compensateNo);
							blPrplinterAutoClaimDetailFacade.update(prplinterAutoClaimDetailDto);
						}
						
						//内存检查
						remark = "理算书号："+compensateNo+" 保存开始";
						utils.getPhisicaMemory(remark);
						/***********************add 大病系统标志***********************/
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
						//由于出险人详细信息是借口必传项所以这里不再提醒出险人信息必传，直接将从数据库中抽取的数据进行赋值
						/*************************将中间表的出险人详细信息插入prpLinjuryPerson表这张表只存大病系统信息 开始*******************/
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
						/*************************将中间表的出险人详细信息插入prpLinjuryPerson表这张表只存大病系统信息 开始*******************/
						//内存检查
						uiCompensateAction.save(compensateDto, workFlowDto);
						
						
						//内存检查
						remark = "理算书号："+compensateNo+" 保存结束";
						
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
					throw new Exception("没有发现与工作流流程相关任何数据！");
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
				prpLinterRecaseDetailDto.setRemark("理算失败："+messege);
				new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
			}else{
				//更新流程状态表理算标识
				prplinterAutoClaimDetailDto.setComppSuccFlag("0");
				prplinterAutoClaimDetailDto.setRemark("理算失败："+messege);
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
				prpLinterRecaseDetailDto.setRemark("理算失败："+messege);
				new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
			}else{
				prplinterAutoClaimDetailDto.setComppSuccFlag("0");
				prplinterAutoClaimDetailDto.setRemark("理算失败："+messege);;
				blPrplinterAutoClaimDetailFacade.update(prplinterAutoClaimDetailDto);
			}
			throw e;
		}
		return prpLinterRequestDto;
	}
	
	
	/**
	 * 大病医疗接口自动理算子类主流程方法，处理自动理算的业务数据和工作流数据
	 * @param prpLinterRequestDto 传入参数为中间表大对象
	 * @return 处理过的中间表大对象
	 * @throws Exception
	 */
	public PrpLinterRequestDto autoCompeRecase (PrpLinterRecaseRequestDto prpLinterRequestDto) throws Exception{
		/**重开赔案流程状态及标识*/
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
		//组织UserDto对象
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
		Utils utils = new Utils();//检查内存
		String remark  = "";
		String compensateNo = "";
		try{
			int newCompensateFlag = -1; // 默认不需要重新生成赔款计算书,后来决定不需要用工作流保存每个计算书的状态
			SwfLogDto swfLogDtoDealNode = new SwfLogDto();
			String conditions = " registno='"+registNo+"' and nodeType='compe' and nodeStatus='0' ";
			ArrayList<SwfLogDto> swflogList  = (ArrayList<SwfLogDto>) new UIWorkFlowAction().findNodesByConditions(conditions);
			//判断是否有未处理的理算节点需要处理，如果没有理算节点需处理直接抛出异常
			if(swflogList!=null&&!swflogList.isEmpty()&&swflogList.size()>0){
				swfLogDtoDealNode = swflogList.get(0);
			}else {
				throw new Exception("未查询出待处理的理算工作流");
			}
			String flowID = swfLogDtoDealNode.getFlowID();
			int logNo = swfLogDtoDealNode.getLogNo();
			conditions = " registno='"+registNo+"' ";
			ArrayList<PrpLclaimDto> claimList  = (ArrayList<PrpLclaimDto>) blPrpLclaimFacadeBase.findByConditions(conditions);
			PrpLclaimDto prpLclaimDto = null;
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,damageDate,damageHoure);
			if(policyDto==null||policyDto.getPrpCmainDto()==null){
				throw new Exception("未查询出相关承保信息，请确认出入参数的保单号码是否合法!");
			}
			int year = DateTime.current().getYear();
			
			if(claimList==null||claimList.isEmpty()||claimList.size()<1){
				throw new Exception("此案件没有合法的赔案号，无法处理理算");
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
				swfLogDtoDealNode.setBusinessNo(compensateDto.getPrpLcompensateDto().getClaimNo()); // 本节点的查找
				swfLogDtoDealNode.setNextBusinessNo(compensateDto.getPrpLcompensateDto().getCompensateNo());
				swfLogDtoDealNode.setKeyIn(compensateDto.getPrpLcompensateDto().getClaimNo());
				swfLogDtoDealNode.setNodeStatus("4");
				swfLogDtoDealNode.setKeyOut(compensateDto.getPrpLcompensateDto().getCompensateNo());
				WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
				if (workFlowViewHelper.checkDealDto(workFlowDto)) {
					// reason:直接保存业务数据导致工作流数据丢失，所以提交前需要暂时保存到正在处理的状态。
					// 提交前的暂时保存
					WorkFlowDto workFlowDtoTemp = null;
					swfLogDtoDealNode.setNodeStatus("2");
					workFlowDtoTemp = workFlowViewHelper.viewToDtoMedical(user,
							swfLogDtoDealNode);
					Collection swfLogDtoTmpList = workFlowDtoTemp.getSubmitSwfLogDtoList();
					/************************添加标志 开始***********************/
					Iterator iterTmp= swfLogDtoTmpList.iterator();
					ArrayList submListTmp = new ArrayList();
					while(iterTmp.hasNext()){
						SwfLogDto swfLogDtoTmp = (SwfLogDto)iterTmp.next();
						swfLogDtoTmp.setMedicalTransitFlag("1");
						submListTmp.add(swfLogDtoTmp);
					}
					workFlowDtoTemp.setSubmitSwfLogDtoList(submListTmp);
					/*************************添加标志 结束**********************/
					// 暂存计算书节点时将理算节点状态置为已处理
					UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
					SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(flowID, logNo);
					if (swfLogDto.getNodeType().equals("compe")) {
						swfLogDto.setNodeStatus("4");
						swfLogDto.setMedicalTransitFlag("1");//设置大病系统数据标志
						workFlowDtoTemp.setUpdate(true);
						workFlowDtoTemp.setUpdateSwfLog2Dto(swfLogDto);
					}
					
					// 如果提交核赔失败则状态为0
					compensateDto.getPrpLcompensateDto().setUnderWriteFlag("0");
					uiCompensateAction.save(compensateDto, workFlowDtoTemp);

					// 如果提交核赔则状态为9
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
						String msg = "案件'" + compensateNo
								+ "'提交双核系统失败，请重新提交或者与管理员联系!";
						throw new UserException(1, 3, "工作流", msg);
					}
					
					// 休整 workFlowDtoTemp 和workFlowDto
					int newCompeLogNo = 0;
					if (workFlowDtoTemp.getSubmitSwfLogDtoList() != null) {
						newCompeLogNo = ((SwfLogDto) workFlowDtoTemp.getSubmitSwfLogDtoList().get(0)).getLogNo();
						((SwfLogDto) workFlowDtoTemp.getSubmitSwfLogDtoList().get(0)).setNodeStatus("4");
						workFlowDto.setUpdate(true);
						workFlowDto.setUpdateSwfLogDto((SwfLogDto) workFlowDtoTemp.getSubmitSwfLogDtoList().get(0));
						if (workFlowDto.getSubmitSwfLogDtoList() != null) {
							// 删除多余的点
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
							// 删除多余的边
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
						/***********************add 大病系统标志***********************/
//						增加大病系统标志medicaltransitflag
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
						//由于出险人详细信息是借口必传项所以这里不再提醒出险人信息必传，直接将从数据库中抽取的数据进行赋值
						/*************************将中间表的出险人详细信息插入prpLinjuryPerson表这张表只存大病系统信息 开始*******************/
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
						/*************************将中间表的出险人详细信息插入prpLinjuryPerson表这张表只存大病系统信息 开始*******************/
						
						if(recaseFlag){
							//更新流程状态表理算成功标识
							prpLinterRecaseDetailDto.setComppSuccFlag("1");
							prpLinterRecaseDetailDto.setCompensateNo(compensateNo);
							prpLinterRecaseDetailDto.setRemark("理算成功："+compensateNo);
							new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
						}else{
							//更新流程状态表理算成功标识
							prplinterAutoClaimDetailDto.setComppSuccFlag("1");
							prplinterAutoClaimDetailDto.setRemark("理算成功："+compensateNo);
							blPrplinterAutoClaimDetailFacade.update(prplinterAutoClaimDetailDto);
						}
						
						//内存检查
						remark = "理算书号："+compensateNo+" 保存开始";
						utils.getPhisicaMemory(remark);
						//内存检查
						uiCompensateAction.save(compensateDto, workFlowDto);
						//内存检查
						remark = "理算书号："+compensateNo+" 保存结束";
						
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
					throw new Exception("没有发现与工作流流程相关任何数据！");
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
				prpLinterRecaseDetailDto.setRemark("理算失败："+messege);
				new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
			}else{
				//更新流程状态表理算标识
				prplinterAutoClaimDetailDto.setComppSuccFlag("0");
				prplinterAutoClaimDetailDto.setRemark("理算失败："+messege);
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
				prpLinterRecaseDetailDto.setRemark("理算失败："+messege);
				new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
			}else{
				prplinterAutoClaimDetailDto.setComppSuccFlag("0");
				prplinterAutoClaimDetailDto.setRemark("理算失败："+messege);;
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
		
		//文本表PrpLctextDto
		ArrayList prpLctextDtoList = new ArrayList();
		String [] compeContexts = StringUtils.split(prpLinterRequestDto.getCompeContext(), 70);
		// 得到连接串,下面将其切分到数组
		for (int k = 0; k < compeContexts.length; k++) {
			PrpLctextDto prpLctextDto = new PrpLctextDto();
			prpLctextDto.setCompensateNo(compensateNo);
			prpLctextDto.setContext(compeContexts[k]);
			prpLctextDto.setLineNo(k + 1);
			prpLctextDto.setTextType("1");//赔款计算过程
			prpLctextDtoList.add(prpLctextDto);
		}
		// compensateDto
		compensateDto.setPrpLctextDtoDtoList(prpLctextDtoList);
		
		
		//具体出险人
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
		
		//事故者信息模块 begin
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
            	prpLacciBenPersonProposerDto.setCertiType("01"); //事故者信息
            	prpLacciBenPersonProposerDto.setPolicyNo(prpLinterRequestDto.getPolicyno());
            	prpLacciBenPersonProposerDto.setSerialNo(i+1);
            	prpLacciBenPersonProposerDto.setFamilyNo(familyNo);
            	prpLacciBenPersonProposerDto.setAcciCode(prpLinterAccdentPersonDto.getAcciCode());
            	prpLacciBenPersonProposerDto.setAcciName(prpLinterAccdentPersonDto.getAcciName());
            	prpLacciBenPersonProposerDto.setAge(prpLinterAccdentPersonDto.getAge());
            	prpLacciBenPersonProposerDto.setSex(prpLinterAccdentPersonDto.getSex());
            	prpLacciBenPersonProposerDto.setIdentifyNumber(prpLinterAccdentPersonDto.getIdentifyNumber());
            	//prpLacciBenPersonProposerDto.setAddress();
                //加入集合
            	prpLacciBenPersonList.add(prpLacciBenPersonProposerDto);
        		
        	}
        }
        compensateDto.setPrpLacciBenPersonList(prpLacciBenPersonList);
        
        //索赔申请人信息
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
                prpLacciPersonProposerDto.setFlag("1");   //标志是索赔人
                prpLacciPersonProposerDto.setIdentifyNumber(prpLinterClaimAppDto.getIdentifyNumber());
                prpLacciPersonProposerDto.setSerialNo(i+1);
                prpLacciPersonProposerDto.setAddress(prpLinterClaimAppDto.getProposerAddress());
                prpLacciPersonProposerDto.setFamilyNo(0);  //家庭序号
                prpLacciPersonProposerDto.setPhone(prpLinterClaimAppDto.getPhone());
                prpLacciPersonProposerDto.setRelationCode(prpLinterClaimAppDto.getRelationCode());
                String relationName="";
                if("1".equals(prpLinterClaimAppDto.getRelationCode())){
                	relationName ="被保险人本人";	
                }
                else if("2".equals(prpLinterClaimAppDto.getRelationCode())){
                	relationName ="指定受益人";	
                }
                else if("3".equals(prpLinterClaimAppDto.getRelationCode())){
                	relationName ="被保险人之继承人";	
                }
                else if("4".equals(prpLinterClaimAppDto.getRelationCode())){
                	relationName ="被保险人之监护人";	
                }
                prpLacciPersonProposerDto.setRelationName(relationName);
                prpLacciPersonProposerDto.setFamilyNo(1);
                //加入集合
                prpLacciPersonList.add(prpLacciPersonProposerDto);
        	}
        }
        claimDto.setPrpLacciPersonDtoList(prpLacciPersonList);
        
        //状态内容
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
        
        //立案信息
        PrpLclaimDto prpLclaimDto = null;
		prpLclaimDto = new PrpLclaimDto();
		prpLclaimDto.setClaimNo(claimDto.getPrpLclaimDto().getClaimNo());
		prpLclaimDto.setSumPaid(prpLinterRequestDto.getPrplCompensateSumPaid());
		compensateDto.setPrpLclaimDto(prpLclaimDto);
        
        //赔付人员信息
        ArrayList prpLpersonLossDtoList = new ArrayList();
        PrpLpersonLossDto prpLpersonLossDto = null;
        BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
        PrpLinterCompeFeeDto [] prpLinterCompeFeeDtos = prpLinterRequestDto.getPrpLinterCompeFeeDto();
        // 将险别信息压到页面上
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
				//根据安信理赔的特殊情况，在理算取保单信息时直接取当时最新保单信息，不进行倒批单
				String sql = " policyno = '"+strPolicyno+"' and familyno = "+intFamilyNo;
				benPersonKindList = (ArrayList)blPrpCitemKindFacade.findByConditions(sql);
        		for(int j=0;j<benPersonKindList.size();j++){
        			PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) benPersonKindList.get(j);
        			//hisPaid+=prpCitemKindDto.getHisPaid();
        			String strItemKindQueryCon1 = " policyNo='"+prpCitemKindDto.getPolicyNo()+"' AND FamilyNo="+
        					intFamilyNo+" AND ItemKindNo="+prpCitemKindDto.getItemKindNo();
        			
        			prplpersonlossDtoList = uiCompensateAction.findPersonLossByConditions(strItemKindQueryCon1);
        			//累加历史记录金额
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
                //加入集合
                prpLpersonLossDtoList.add(prpLpersonLossDto);
        		
        	}
        }
        compensateDto.setPrpLpersonLossDtoList(prpLpersonLossDtoList);
        ArrayList prpllossDtoList = new ArrayList();
        compensateDto.setPrpLlossDtoList(prpllossDtoList);
        
        //赔款费用信息
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
                /* 大病医疗报销实物中不存在代查勘情况
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
        
        //赔款计算金额信息
        ArrayList prpLcfeeDtoList = new ArrayList();
        PrpLcfeeDto prpLcfeeDto = null;
        //对象赋值
        
        prpLcfeeDto = new PrpLcfeeDto();
        prpLcfeeDto.setCompensateNo(compensateNo);
        prpLcfeeDto.setPolicyNo(prpLinterRequestDto.getPolicyno());
        prpLcfeeDto.setRiskCode(claimDto.getPrpLclaimDto().getRiskCode());
        prpLcfeeDto.setCurrency(claimDto.getPrpLclaimDto().getCurrency());
        prpLcfeeDto.setSumPaid(prpLinterRequestDto.getSumThisPaid());
        prpLcfeeDto.setFlag("");
        prpLcfeeDtoList.add(prpLcfeeDto);
        compensateDto.setPrpLcfeeDtoList(prpLcfeeDtoList);
        
        //危险单位信息
        Map kindMap = new HashMap();
		//拼接标的序号使用
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
		//根据标的代码查询数据库危险单位信息  start
	    DBPrpPhead dbPrpPhead = new DBPrpPhead();
		BLDangerUnitFacade blDangerFacade = new BLDangerUnitFacade();
		// 如果在出险时间之前存在批改，则取pdangunit表的数据，否则取cdangunit表的数据
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
        //危险单位估损金额按照标的序号最后一位减法原则处理
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
    				prpLdangerItemDto.setCertiNo(compensateNo); // 计算书号
    				prpLdangerItemDto.setDangerNo(Integer.parseInt(newDangerUnitDto2.getDangerno())); //危险单位
    				prpLdangerItemDto.setCurrency(newDangerUnitDto2.getCurrency()); // 损失币别
    				prpLdangerItemDto.setKindFlag("0"); // 险别归类标志,0表示正常
    				prpLdangerItemDto.setKindCode(newDangerUnitDto2.getKindcode());    
    				prpLdangerItemDto.setKindName(newDangerUnitDto2.getKindname());  
    				prpLdangerItemDto.setRiskCode(newDangerUnitDto2.getRiskcode()); 
    				prpLdangerItemDto.setAddressName(newDangerUnitDto2.getAddressname());
    				prpLdangerItemDto.setPolicyno(newDangerUnitDto2.getPolicyno());
    				prpLdangerItemDto.setDangerdesc(newDangerUnitDto2.getDangerdesc());
    				prpLdangerItemDto.setItemcode(newDangerUnitDto2.getItemcode());
    				prpLdangerItemDto.setItemname(newDangerUnitDto2.getItemname());
    				prpLdangerItemDto.setSumPaid(Str.round(Double.parseDouble(newDangerUnitDto2.getDangerkindAmount()),2)); 
    				prpLdangerItemDto.setSerialNo(Integer.parseInt(newDangerUnitDto2.getItemkindno())); // 标的序号
    				//prpLdangerItemDto.setDangerKindShare(Str.round(Double.parseDouble(newDangerUnitDto2.getDangerkindshare()),2));
    				
    				//占比最后一个减法原则
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
       	//2、生成此危险单位标金额合计PrpLdangerTot（汇总prpLdangerItem）
        
       	Iterator     iterator   = null;
        PrpLdangerTotDto prpLdangerTotNewDto   = null; 
        Iterator      itTot  = null;
        PrpLdangerItemDto prpLdangerItemNewDto = null;       //标的DTO
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
        		//每个危险单位标的的第一次数据的生成
        		if (find == false)
        		{
        			prpLdangerTotNewDto = new PrpLdangerTotDto();
                    
        			prpLdangerTotNewDto.setCertiNo(compensateNo);
        			prpLdangerTotNewDto.setDangerNo(prpLdangerItemNewDto.getDangerNo());                        
        			prpLdangerTotNewDto.setSCurrency(prpLdangerItemNewDto.getCurrency());   //标的原币别
        			prpLdangerTotNewDto.setSumFee(0);
        			prpLdangerTotNewDto.setSumPaid(prpLdangerItemNewDto.getSumPaid());
    		    	prpLdangerTotNewDto.setTCurrency(prpLdangerItemNewDto.getCurrency());
    		    	prpLdangerTotNewDto.setExchRate(1);
    		    	prpLdangerTotNewDto.setSumFeeEx(0);
    		    	prpLdangerTotNewDto.setSumPaidEx(prpLdangerItemNewDto.getSumPaid());
    		  	 	 //加入集合
                	 if(prpLdangerTotNewDto!=null){
                		dangerTotList.add(prpLdangerTotNewDto);
                	 }
            		
        		}
          
        	}

        	if(dangerTotList.size()>0){
        		compensateDto.setPrpLprpLdangerTotList(dangerTotList);
        	}
        }
        //3、生成危险单位prpLdangerUnit
        
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
        		
        		//每个危险单位标的的第一次数据的生成
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
              	     
              	    //加入集合
                	if(prpLdangerUnitNewDto!=null){
                		dangerUnitList.add(prpLdangerUnitNewDto);
                	}
        		}
        		
        	}
        	//最后一个占比减法原则
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
            		prpLdangerUnitDtotemp.setSumNoPaid(0);  //结案  未决赔款置零
        			
 	       	 	}
   	     		if(dangerUnitList.size()>0){
   	     			compensateDto.setPrplRiskUnitDtoList(dangerUnitList);
   	     		}
 	        }
        
        
		return compensateDto;
	}
}
