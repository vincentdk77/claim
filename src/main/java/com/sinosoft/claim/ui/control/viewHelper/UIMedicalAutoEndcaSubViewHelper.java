package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import com.sinosoft.claim.bl.action.domain.BLPrplinterAutoClaimDetailAction;
import com.sinosoft.claim.bl.facade.BLPrpDuserFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacadeBase;
import com.sinosoft.claim.bl.facade.BLPrpLinterRecaseDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterAutoClaimDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrplreturnvisitswflogFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.EndcaseDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLcaseNoDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIEndcaseAction;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 自动结案类
 */
public class UIMedicalAutoEndcaSubViewHelper {
	/**
	 * 自动结案逻辑
	 * @param prpLinterRequestDto
	 * @return prpLinterRequestDto
	 * @throws Exception
	 */
	public PrpLinterRequestDto autoEndca (PrpLinterRequestDto prpLinterRequestDto) throws Exception{
		
			PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = 
				prpLinterRequestDto.getPrplinterAutoClaimDetailDto();
			
			//重开案件流程轨迹
			PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = prpLinterRequestDto.getPrpLinterRecaseDetailDto();
			//重开案件流程轨迹
			
			// 查询保单信息
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
					prpLinterRequestDto.getPolicyno(),
					prpLinterRequestDto.getDamageStartDate().toString(), 
					prpLinterRequestDto.getDamageStartHour());
			String riskCode = policyDto.getPrpCmainDto().getRiskCode();
			String registNo = prpLinterRequestDto.getRelationRegistNo();
			//组装user对象，方便后续使用
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
			
			EndcaseDto endcaseDto = new EndcaseDto();
			ClaimDto claimDto = new ClaimDto();
			ReCaseDto recaseDto = new ReCaseDto();
		try {
			UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();
			
			Collection claimList = new BLPrpLclaimFacadeBase().findByConditions(" registno='"+registNo+"' ");
			if(claimList == null || claimList.size()<1){
				throw new Exception("此案件没有合法的赔案号，无法处理结案");
			}
			PrpLclaimDto prpLclaimDto = (PrpLclaimDto)claimList.iterator().next();
			String claimNo = prpLclaimDto.getClaimNo();
			
			int intCompensateFlag = this.checkCompensate(claimNo);
			if (intCompensateFlag == 0) { //有问题，如果是垫付，不应该有计算书的，这个是怎么考虑的。
				throw new UserException(1, 3, "endcase", "此立案"+ claimNo +"没有赔款计算书，不能结案！");
					}

			if (intCompensateFlag < 0) { //有计算书，但没通过核赔。
				throw new UserException(1, 3, "endcase", "有没有核赔通过的计算书，不能结案！");
			}
			
			boolean recaseFlag = new DAAEndcaseViewHelper().isRecase(claimNo);
			String caseNo = "";
			if(recaseFlag == true){
				caseNo = prpLclaimDto.getCaseNo();
			}else{
				caseNo = new DAAEndcaseViewHelper().getCaseNo(claimNo,user.getComCode());
			}
			
			Collection collection = new UIWorkFlowAction().findNodesByConditions(" registno='"+registNo+"' and nodetype='endca' and nodestatus='0' ");
			if(collection == null || collection.size()<1){
				throw new Exception("无可处理结案节点");
			}
//		collection.iterator().next();
			SwfLogDto swflogDto = (SwfLogDto)collection.iterator().next();
			
			/*---------------------赔案号表prpLcaseno------------------------------------*/
			UICompensateAction uICompensateAction = new UICompensateAction();
			String conditions = " claimNo ='" + claimNo.trim() + "' ";
			ArrayList prpLperpayDtoList = new ArrayList();
			ArrayList arraylist = (ArrayList) uICompensateAction.findByConditions(conditions);
			if (arraylist != null && arraylist.size()>0) {
				for (int i = 0; i < arraylist.size(); i++) {
					PrpLcaseNoDto prpLcaseNoDto = new PrpLcaseNoDto();
					PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
					prpLcompensateDto = (PrpLcompensateDto) arraylist.get(i);
					prpLcaseNoDto.setCertiNo(prpLcompensateDto.getCompensateNo());
					prpLcaseNoDto.setCertiType("C");
					prpLcaseNoDto.setCaseNo(caseNo.trim());
					prpLcaseNoDto.setFlag("");
					prpLcaseNoDto.setClaimNo(claimNo.trim());
					prpLperpayDtoList.add(prpLcaseNoDto);
					//policyNo = prpLcompensateDto.getPolicyNo();
				}
			}
			endcaseDto.setPrpLcaseNoDtoList(prpLperpayDtoList);
			
			ArrayList<PrpLcompensateDto> prpLcompensateDtoList = new ArrayList<PrpLcompensateDto>();
			for (int j = 0; j < arraylist.size(); j++) {
				PrpLcompensateDto prpLcompensateDto = null;
				prpLcompensateDto = (PrpLcompensateDto) arraylist.get(j);
				prpLcompensateDto.setCaseNo(caseNo);
				prpLcompensateDto.setZeroLossType(prpLinterRequestDto.getZeroLossType());
				prpLcompensateDtoList.add(prpLcompensateDto);
			}
			endcaseDto.setPrpLcompensateDtoList(prpLcompensateDtoList);
			
			/*---------------------文本表PrpLltextDto--------------------*/
			ArrayList<PrpLltextDto> prpLltextDtoList = new ArrayList<PrpLltextDto>();
			String context = prpLinterRequestDto.getContext();
			if (context != null && context.length()>0) {
				String[] rules = StringUtils.split(context, 70);
				//得到连接串,下面将其切分到数组
				for (int k = 0; k < rules.length; k++) {
					PrpLltextDto prpLltextDto = new PrpLltextDto();
					prpLltextDto.setClaimNo(claimNo.trim());
					prpLltextDto.setContext(rules[k]);
					prpLltextDto.setLineNo(k + 1);
					//Modify by zhaolu 20060909 start
					//reason对非车险结案报告覆盖理 算报告的问题修改
					//prpLltextDto.setTextType("05");
					//fenglei
					prpLltextDto.setTextType("08");
					//Modify by zhaolu 20060909 end
					prpLltextDtoList.add(prpLltextDto);
				}
				endcaseDto.setPrpLltextDtoList(prpLltextDtoList);
			}
			
			/*---------------------状态内容prpLclaimStatus-----------------------*/
			PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
			prpLclaimStatusDto.setStatus("4");
			prpLclaimStatusDto.setBusinessNo(caseNo.trim());
			prpLclaimStatusDto.setPolicyNo(prpLinterRequestDto.getPolicyno());
			prpLclaimStatusDto.setRiskCode(riskCode);
			prpLclaimStatusDto.setNodeType("endca");
			prpLclaimStatusDto.setSerialNo(0);
			//取得当前用户信息，写操作员信息到结案中
			prpLclaimStatusDto.setHandlerCode(user.getUserCode());
			prpLclaimStatusDto.setInputDate(new DateTime(prpLinterRequestDto.getVericTime(),DateTime.YEAR_TO_DAY));
			prpLclaimStatusDto.setOperateDate(new DateTime(prpLinterRequestDto.getVericTime(), DateTime.YEAR_TO_DAY));
			endcaseDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
			
			PrplreturnvisitswflogDto prplreturnvisitswflogDto = null;
			UIRecaseAction uiRecaseAction = new UIRecaseAction();
			String cancelDate = prpLclaimDto.getCancelDate().toString();
			if(recaseFlag == false){
				prpLclaimDto.setCaseNo(caseNo);
				prpLclaimDto.setEndCaseDate(new DateTime(prpLinterRequestDto.getVericTime(), DateTime.YEAR_TO_SECOND));
				prpLclaimDto.setEndCaserCode(user.getUserCode());
				//prpLclaimDto.setFlag("1");
//				prpLclaimDto.setEndCaseDate();
//				prpLclaimDto.setEndCaserCode();
//				prpLclaimDto.setEndCaseFlag();
				
				//生成回访信息 begin
				prplreturnvisitswflogDto  = this.setReturnVisitSwflogDto(user, registNo, "endca", "0");
				endcaseDto.setPrplreturnvisitswflogDto(prplreturnvisitswflogDto);
				//生成回访信息 end;
			}else{
				int maxSerialNo = 0;
				//ReCaseDto ReCaseDto = uiRecaseAction. findByPrimaryKey(claimNo,maxSerialNo);
				if(uiRecaseAction.findByConditions(" claimno='"+claimNo+"' ")!=null){
		             maxSerialNo =  uiRecaseAction.getMaxSerialNo(claimNo);
		         }else{maxSerialNo =1;}
		         recaseDto = uiRecaseAction.findByPrimaryKey(claimNo,maxSerialNo);
		         PrpLrecaseDto prpLrecaseDto = recaseDto.getPrpLrecaseDto();
		         prpLrecaseDto.setCloseCaseDate(new DateTime(prpLinterRequestDto.getVericTime(), DateTime.YEAR_TO_DAY));
		         prpLrecaseDto.setCloseCaseUserCode(user.getUserCode());
		         recaseDto.setPrpLrecaseDto(prpLrecaseDto);
		         uiRecaseAction.savePrpLrecase(recaseDto);
			}
			endcaseDto.setPrpLclaimDto(prpLclaimDto);
			
			PrplreturnvisitswflogDto PrplreturnvisitswflogDto = 
				new BLPrplreturnvisitswflogFacade().findByPrimaryKey(registNo,"endca");
			if(PrplreturnvisitswflogDto == null){
				endcaseDto.setPrplreturnvisitswflogDto(prplreturnvisitswflogDto);
			}
			
			if(prpLinterRequestDto.isRecaseFlag()){//判断重开
				prpLinterRecaseDetailDto.setEndcaSuccFlag("1");
				prpLinterRecaseDetailDto.setRemark("结案成功："+registNo);
				new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
			}else{
				//记录流程轨迹表-结案环节成功标志
				prplinterAutoClaimDetailDto.setEndcaSuccFlag("1");
				prplinterAutoClaimDetailDto.setRemark("结案成功："+registNo);
				new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
			}
			
//		111	PrpLrecaseDto prplrecase = new PrpLrecaseDto();
			swflogDto.setBusinessNo(claimNo);
			swflogDto.setNextBusinessNo(claimNo);
			swflogDto.setKeyIn(claimNo);
			swflogDto.setKeyOut(caseNo);
			swflogDto.setNodeStatus("4");
			swflogDto.setHandleTime(prpLinterRequestDto.getVericTime().toString());
			swflogDto.setSubmitTime(prpLinterRequestDto.getVericTime().toString());
			WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swflogDto);
			
			boolean chechkDealFlag = workFlowViewHelper.checkDealDto(workFlowViewHelper.viewToDto(user,swflogDto));
			/***********************add 大病系统标志***********************/
			//增加大病系统标志medicaltransitflag
			Collection submitSwfLogDtoList = workFlowDto.getSubmitSwfLogDtoList();
			Iterator iter = submitSwfLogDtoList.iterator();
			ArrayList submitListTemp = new ArrayList();
			while(iter.hasNext()){
				SwfLogDto swfLogDto = (SwfLogDto)iter.next();
				swfLogDto.setMedicalTransitFlag("1");//设置大病系统的数据位1，空时不为大病系统数据
				submitListTemp.add(swfLogDto);
			}
			workFlowDto.setSubmitSwfLogDtoList(submitListTemp);
			/*************************end****************/
			if(chechkDealFlag == false){
				throw new Exception("没有发现与工作流流程相关任何数据");
			}else{
				if(recaseFlag == true){
//		111			uiRecaseAction.update(prplrecase);
					new UIWorkFlowAction().deal(workFlowDto);
				}else{
					uiEndcaseAction.save(endcaseDto, workFlowDto);
				}
			}
			
			String sqlEndca = " Update swflogStore Set  submittime='"+prpLinterRequestDto.getVericTime()
			                                    +"' Where registno ='"+registNo+"' and nodeType ='endca'";
			new BLPrplinterAutoClaimDetailFacade().updateBySQL(sqlEndca);
			
			return prpLinterRequestDto;
		} catch (Exception e) {
			String messege = e.toString();
			if(messege!=null&&messege.length()>1000){
				messege = messege.substring(0,1000);
			}
			if(prpLinterRequestDto.isRecaseFlag()){//判断重开
				prpLinterRecaseDetailDto.setEndcaSuccFlag("0");
				prpLinterRecaseDetailDto.setRemark("结案失败："+messege);
				new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
			}else{
				prplinterAutoClaimDetailDto.setEndcaSuccFlag("0");
				prplinterAutoClaimDetailDto.setRemark("结案失败："+messege);
				new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
			}
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * 自动结案逻辑
	 * @param prpLinterRequestDto
	 * @return prpLinterRequestDto
	 * @throws Exception
	 */
	public PrpLinterRequestDto autoEndcaRecase (PrpLinterRecaseRequestDto prpLinterRequestDto) throws Exception{
		
			PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = 
				prpLinterRequestDto.getPrplinterAutoClaimDetailDto();
			
			//重开案件流程轨迹
			PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = prpLinterRequestDto.getPrpLinterRecaseDetailDto();
			//重开案件流程轨迹
			
			// 查询保单信息
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
					prpLinterRequestDto.getPolicyno(),
					prpLinterRequestDto.getDamageStartDate().toString(), 
					prpLinterRequestDto.getDamageStartHour());
			String riskCode = policyDto.getPrpCmainDto().getRiskCode();
			String registNo = prpLinterRequestDto.getRelationRegistNo();
			//组装user对象，方便后续使用
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
			
			EndcaseDto endcaseDto = new EndcaseDto();
			ClaimDto claimDto = new ClaimDto();
			ReCaseDto recaseDto = new ReCaseDto();
		try {
			UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();
			
			Collection claimList = new BLPrpLclaimFacadeBase().findByConditions(" registno='"+registNo+"' ");
			if(claimList == null || claimList.size()<1){
				throw new Exception("此案件没有合法的赔案号，无法处理结案");
			}
			PrpLclaimDto prpLclaimDto = (PrpLclaimDto)claimList.iterator().next();
			String claimNo = prpLclaimDto.getClaimNo();
			
			int intCompensateFlag = this.checkCompensate(claimNo);
			if (intCompensateFlag == 0) { //有问题，如果是垫付，不应该有计算书的，这个是怎么考虑的。
				throw new UserException(1, 3, "endcase", "此立案"+ claimNo +"没有赔款计算书，不能结案！");
					}

			if (intCompensateFlag < 0) { //有计算书，但没通过核赔。
				throw new UserException(1, 3, "endcase", "有没有核赔通过的计算书，不能结案！");
			}
			
			boolean recaseFlag = new DAAEndcaseViewHelper().isRecase(claimNo);
			String caseNo = "";
			if(recaseFlag == true){
				caseNo = prpLclaimDto.getCaseNo();
			}else{
				caseNo = new DAAEndcaseViewHelper().getCaseNo(claimNo,user.getComCode());
			}
			
			Collection collection = new UIWorkFlowAction().findNodesByConditions(" registno='"+registNo+"' and nodetype='endca' and nodestatus='0' ");
			if(collection == null || collection.size()<1){
				throw new Exception("无可处理结案节点");
			}
//		collection.iterator().next();
			SwfLogDto swflogDto = (SwfLogDto)collection.iterator().next();
			
			/*---------------------赔案号表prpLcaseno------------------------------------*/
			UICompensateAction uICompensateAction = new UICompensateAction();
			String conditions = " claimNo ='" + claimNo.trim() + "' ";
			ArrayList prpLperpayDtoList = new ArrayList();
			ArrayList arraylist = (ArrayList) uICompensateAction.findByConditions(conditions);
			if (arraylist != null && arraylist.size()>0) {
				for (int i = 0; i < arraylist.size(); i++) {
					PrpLcaseNoDto prpLcaseNoDto = new PrpLcaseNoDto();
					PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
					prpLcompensateDto = (PrpLcompensateDto) arraylist.get(i);
					prpLcaseNoDto.setCertiNo(prpLcompensateDto.getCompensateNo());
					prpLcaseNoDto.setCertiType("C");
					prpLcaseNoDto.setCaseNo(caseNo.trim());
					prpLcaseNoDto.setFlag("");
					prpLcaseNoDto.setClaimNo(claimNo.trim());
					prpLperpayDtoList.add(prpLcaseNoDto);
					//policyNo = prpLcompensateDto.getPolicyNo();
				}
			}
			endcaseDto.setPrpLcaseNoDtoList(prpLperpayDtoList);
			
			ArrayList<PrpLcompensateDto> prpLcompensateDtoList = new ArrayList<PrpLcompensateDto>();
			for (int j = 0; j < arraylist.size(); j++) {
				PrpLcompensateDto prpLcompensateDto = null;
				prpLcompensateDto = (PrpLcompensateDto) arraylist.get(j);
				prpLcompensateDto.setCaseNo(caseNo);
				prpLcompensateDto.setZeroLossType(prpLinterRequestDto.getZeroLossType());
				prpLcompensateDtoList.add(prpLcompensateDto);
			}
			endcaseDto.setPrpLcompensateDtoList(prpLcompensateDtoList);
			
			/*---------------------文本表PrpLltextDto--------------------*/
			ArrayList<PrpLltextDto> prpLltextDtoList = new ArrayList<PrpLltextDto>();
			String context = prpLinterRequestDto.getContext();
			if (context != null && context.length()>0) {
				String[] rules = StringUtils.split(context, 70);
				//得到连接串,下面将其切分到数组
				for (int k = 0; k < rules.length; k++) {
					PrpLltextDto prpLltextDto = new PrpLltextDto();
					prpLltextDto.setClaimNo(claimNo.trim());
					prpLltextDto.setContext(rules[k]);
					prpLltextDto.setLineNo(k + 1);
					//Modify by zhaolu 20060909 start
					//reason对非车险结案报告覆盖理 算报告的问题修改
					//prpLltextDto.setTextType("05");
					//fenglei
					prpLltextDto.setTextType("08");
					//Modify by zhaolu 20060909 end
					prpLltextDtoList.add(prpLltextDto);
				}
				endcaseDto.setPrpLltextDtoList(prpLltextDtoList);
			}
			
			/*---------------------状态内容prpLclaimStatus-----------------------*/
			PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
			prpLclaimStatusDto.setStatus("4");
			prpLclaimStatusDto.setBusinessNo(caseNo.trim());
			prpLclaimStatusDto.setPolicyNo(prpLinterRequestDto.getPolicyno());
			prpLclaimStatusDto.setRiskCode(riskCode);
			prpLclaimStatusDto.setNodeType("endca");
			prpLclaimStatusDto.setSerialNo(0);
			//取得当前用户信息，写操作员信息到结案中
			prpLclaimStatusDto.setHandlerCode(user.getUserCode());
			prpLclaimStatusDto.setInputDate(new DateTime(prpLinterRequestDto.getVericTime(),DateTime.YEAR_TO_DAY));
			prpLclaimStatusDto.setOperateDate(new DateTime(prpLinterRequestDto.getVericTime(), DateTime.YEAR_TO_DAY));
			endcaseDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
			
			PrplreturnvisitswflogDto prplreturnvisitswflogDto = null;
			UIRecaseAction uiRecaseAction = new UIRecaseAction();
			if(recaseFlag == false){
				prpLclaimDto.setCaseNo(caseNo);
				prpLclaimDto.setEndCaseDate(new DateTime(prpLinterRequestDto.getVericTime(), DateTime.YEAR_TO_SECOND));
				prpLclaimDto.setEndCaserCode(user.getUserCode());
				//prpLclaimDto.setFlag("1");
//				prpLclaimDto.setEndCaseDate();
//				prpLclaimDto.setEndCaserCode();
//				prpLclaimDto.setEndCaseFlag();
				
				//生成回访信息 begin
				prplreturnvisitswflogDto  = this.setReturnVisitSwflogDto(user, registNo, "endca", "0");
				endcaseDto.setPrplreturnvisitswflogDto(prplreturnvisitswflogDto);
				//生成回访信息 end;
			}else{
				int maxSerialNo = 0;
				//ReCaseDto ReCaseDto = uiRecaseAction. findByPrimaryKey(claimNo,maxSerialNo);
				if(uiRecaseAction.findByConditions(" claimno='"+claimNo+"' ")!=null){
		             maxSerialNo =  uiRecaseAction.getMaxSerialNo(claimNo);
		         }else{maxSerialNo =1;}
		         recaseDto = uiRecaseAction.findByPrimaryKey(claimNo,maxSerialNo);
		         PrpLrecaseDto prpLrecaseDto = recaseDto.getPrpLrecaseDto();
		         prpLrecaseDto.setCloseCaseDate(new DateTime(prpLinterRequestDto.getVericTime(), DateTime.YEAR_TO_DAY));
		         prpLrecaseDto.setCloseCaseUserCode(user.getUserCode());
		         recaseDto.setPrpLrecaseDto(prpLrecaseDto);
		         uiRecaseAction.savePrpLrecase(recaseDto);
			}
			endcaseDto.setPrpLclaimDto(prpLclaimDto);
			
			PrplreturnvisitswflogDto PrplreturnvisitswflogDto = 
				new BLPrplreturnvisitswflogFacade().findByPrimaryKey(registNo,"endca");
			if(PrplreturnvisitswflogDto == null){
				endcaseDto.setPrplreturnvisitswflogDto(prplreturnvisitswflogDto);
			}
			
			if(prpLinterRequestDto.isRecaseFlag()){//判断重开
				prpLinterRecaseDetailDto.setEndcaSuccFlag("1");
				prpLinterRecaseDetailDto.setRemark("结案成功："+registNo);
				new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
			}else{
				//记录流程轨迹表-结案环节成功标志
				prplinterAutoClaimDetailDto.setEndcaSuccFlag("1");
				prplinterAutoClaimDetailDto.setRemark("结案成功："+registNo);
				new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
			}
			
//		111	PrpLrecaseDto prplrecase = new PrpLrecaseDto();
			swflogDto.setBusinessNo(claimNo);
			swflogDto.setNextBusinessNo(claimNo);
			swflogDto.setKeyIn(claimNo);
			swflogDto.setKeyOut(caseNo);
			swflogDto.setNodeStatus("4");
			swflogDto.setFlowInTime(prpLinterRequestDto.getVericTime().toString());
			swflogDto.setHandleTime(prpLinterRequestDto.getVericTime().toString());
			swflogDto.setSubmitTime(prpLinterRequestDto.getVericTime().toString());
			WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			WorkFlowDto workFlowDto=workFlowViewHelper.viewToDtoMedical(user,swflogDto);
			boolean chechkDealFlag = workFlowViewHelper.checkDealDto(workFlowViewHelper.viewToDtoMedical(user,swflogDto));
			/***********************add 大病系统标志***********************/
			//增加大病系统标志medicaltransitflag
			Collection submitSwfLogDtoList = workFlowDto.getSubmitSwfLogDtoList();
			Iterator iter = submitSwfLogDtoList.iterator();
			ArrayList submitListTemp = new ArrayList();
			while(iter.hasNext()){
				SwfLogDto swfLogDto = (SwfLogDto)iter.next();
				swfLogDto.setMedicalTransitFlag("1");//设置大病系统的数据位1，空时不为大病系统数据
				submitListTemp.add(swfLogDto);
			}
			workFlowDto.setSubmitSwfLogDtoList(submitListTemp);
			/*************************end****************/
			if(chechkDealFlag == false){
				throw new Exception("没有发现与工作流流程相关任何数据");
			}else{
				if(recaseFlag == true){
//		111			uiRecaseAction.update(prplrecase);
					new UIWorkFlowAction().deal(workFlowDto);
				}else{
					uiEndcaseAction.save(endcaseDto, workFlowDto);
				}
			}
			if(recaseFlag == true){
				
			}else{
				String sqlEndca = " Update swflogStore Set  submittime='"+prpLinterRequestDto.getVericTime()
				                                    +"' Where registno ='"+registNo+"' and nodeType ='endca'";
				new BLPrplinterAutoClaimDetailFacade().updateBySQL(sqlEndca);
			}
			return prpLinterRequestDto;
		} catch (Exception e) {
			String messege = e.toString();
			if(messege!=null&&messege.length()>1000){
				messege = messege.substring(0,1000);
			}
			if(prpLinterRequestDto.isRecaseFlag()){//判断重开
				prpLinterRecaseDetailDto.setEndcaSuccFlag("0");
				prpLinterRecaseDetailDto.setRemark("结案失败："+messege);
				new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
			}else{
				prplinterAutoClaimDetailDto.setEndcaSuccFlag("0");
				prplinterAutoClaimDetailDto.setRemark("结案失败："+messege);
				new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
			}
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * 检查是否还有未通过的赔款计算书
	 * 返回值   0：没有赔款计算书  -1:还有未通过的赔款计算书  1：所有的赔款计算书都已经通过 2:垫付结案
	 * @param claimNo 赔案号
	 * @throws Exception
	 */
	public int checkCompensate(String claimNo) throws Exception {
		//取得赔款计算书信息
		int compensateFlag= 1 ;
		UICompensateAction uICompensateAction = new UICompensateAction();
		String conditions = "claimNo ='" + claimNo.trim() + "'";
		ArrayList arraylist = (ArrayList) uICompensateAction.findByConditions(conditions);
		if (arraylist == null || arraylist.size() < 1) {
			//return 0;
			//如果是垫付情况下，应该允许结案的。所以还需要判断是否有垫付的情况。
//			UIPrepayAction uiPrepayAction = new UIPrepayAction ();	
//			conditions = conditions + " and caseType='8'";
//			ArrayList prepayList = (ArrayList)uiPrepayAction.findByConditions(conditions);
			compensateFlag =0;
//			if (prepayList!=null&&prepayList.size()>0){
//				compensateFlag =2; //如果有垫付的情况，可以进行结案操作。
//			}
		}
		if (arraylist != null) {
			for (int i = 0; i < arraylist.size(); i++) {
				PrpLcompensateDto prpLcompensateDto = null;
				prpLcompensateDto = (PrpLcompensateDto) arraylist.get(i);
				if (!(prpLcompensateDto.getUnderWriteFlag().equals("1") || prpLcompensateDto.getUnderWriteFlag().equals("3") )) {
					
					//return -1;
					compensateFlag =-1;
				}
			}
		}
		return compensateFlag ;
	}
	
	/**
	 * 整理回访主表数据(自动生成回访主表数据)
	 * @param httpServletRequest
	 * @param registNo		报案号
	 * @param nodeType		当前节点
	 * @param state			回访案件状态
	 * @throws Exception
	 */
	public PrplreturnvisitswflogDto setReturnVisitSwflogDto(UserDto userDto,String registNo,String nodeType,String state) throws Exception{
		
		//通过业务号 获取报案号
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		//通过报案号查询报案信息
		PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
		PrplreturnvisitswflogDto prplreturnvisitswflogDto = new PrplreturnvisitswflogDto();
		if(prpLregistDto != null && !"".equals(prpLregistDto)){
			prplreturnvisitswflogDto.setBusinessno(prpLregistDto.getRegistNo());								//业务号
			prplreturnvisitswflogDto.setNodetype(nodeType);														//节点号
			prplreturnvisitswflogDto.setRegistno(prpLregistDto.getRegistNo());									//报案号
			prplreturnvisitswflogDto.setComcode(prpLregistDto.getComCode());									//承保机构			
			prplreturnvisitswflogDto.setPolicyno(prpLregistDto.getPolicyNo());
			UICodeAction uiCodeAction = new UICodeAction();
			String comName = uiCodeAction.translateComCode(prpLregistDto.getComCode(), true);
			prplreturnvisitswflogDto.setComcodename(comName);										//机构名称
			prplreturnvisitswflogDto.setInsuredname(prpLregistDto.getInsuredName());							//被保险人
			String reportd = prpLregistDto.getReportDate().toString();
			reportd = reportd+" "+prpLregistDto.getReportHour();
			DateTime d =new DateTime(reportd,DateTime.YEAR_TO_MONTH);
			prplreturnvisitswflogDto.setReportdate(d);			//报案时间
			if("sched".equals(nodeType)){
				
			}else{
				prplreturnvisitswflogDto.setCeasedate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));													//结案时间
			}
			prplreturnvisitswflogDto.setLicenseno(prpLregistDto.getLicenseNo());								//车牌号
			prplreturnvisitswflogDto.setHandlercode(userDto.getUserCode());										//处理人代码
			prplreturnvisitswflogDto.setHandlername(userDto.getUserName());										//处理人名称
			prplreturnvisitswflogDto.setHandlercomcode(userDto.getComCode());									//处理人部门
			
			prplreturnvisitswflogDto.setFlowintotime(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));//流入时间
			prplreturnvisitswflogDto.setClasscode(prpLregistDto.getClassCode());								//险类
			prplreturnvisitswflogDto.setState(state);															//状态
			prplreturnvisitswflogDto.setRiskCode(prpLregistDto.getRiskCode());
			
		}
		return prplreturnvisitswflogDto;
	}

}
