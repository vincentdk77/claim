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
 * �Զ��᰸��
 */
public class UIMedicalAutoEndcaSubViewHelper {
	/**
	 * �Զ��᰸�߼�
	 * @param prpLinterRequestDto
	 * @return prpLinterRequestDto
	 * @throws Exception
	 */
	public PrpLinterRequestDto autoEndca (PrpLinterRequestDto prpLinterRequestDto) throws Exception{
		
			PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = 
				prpLinterRequestDto.getPrplinterAutoClaimDetailDto();
			
			//�ؿ��������̹켣
			PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = prpLinterRequestDto.getPrpLinterRecaseDetailDto();
			//�ؿ��������̹켣
			
			// ��ѯ������Ϣ
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
					prpLinterRequestDto.getPolicyno(),
					prpLinterRequestDto.getDamageStartDate().toString(), 
					prpLinterRequestDto.getDamageStartHour());
			String riskCode = policyDto.getPrpCmainDto().getRiskCode();
			String registNo = prpLinterRequestDto.getRelationRegistNo();
			//��װuser���󣬷������ʹ��
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
				throw new Exception("�˰���û�кϷ����ⰸ�ţ��޷�����᰸");
			}
			PrpLclaimDto prpLclaimDto = (PrpLclaimDto)claimList.iterator().next();
			String claimNo = prpLclaimDto.getClaimNo();
			
			int intCompensateFlag = this.checkCompensate(claimNo);
			if (intCompensateFlag == 0) { //�����⣬����ǵ渶����Ӧ���м�����ģ��������ô���ǵġ�
				throw new UserException(1, 3, "endcase", "������"+ claimNo +"û���������飬���ܽ᰸��");
					}

			if (intCompensateFlag < 0) { //�м����飬��ûͨ�����⡣
				throw new UserException(1, 3, "endcase", "��û�к���ͨ���ļ����飬���ܽ᰸��");
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
				throw new Exception("�޿ɴ���᰸�ڵ�");
			}
//		collection.iterator().next();
			SwfLogDto swflogDto = (SwfLogDto)collection.iterator().next();
			
			/*---------------------�ⰸ�ű�prpLcaseno------------------------------------*/
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
			
			/*---------------------�ı���PrpLltextDto--------------------*/
			ArrayList<PrpLltextDto> prpLltextDtoList = new ArrayList<PrpLltextDto>();
			String context = prpLinterRequestDto.getContext();
			if (context != null && context.length()>0) {
				String[] rules = StringUtils.split(context, 70);
				//�õ����Ӵ�,���潫���зֵ�����
				for (int k = 0; k < rules.length; k++) {
					PrpLltextDto prpLltextDto = new PrpLltextDto();
					prpLltextDto.setClaimNo(claimNo.trim());
					prpLltextDto.setContext(rules[k]);
					prpLltextDto.setLineNo(k + 1);
					//Modify by zhaolu 20060909 start
					//reason�Էǳ��ս᰸���渲���� �㱨��������޸�
					//prpLltextDto.setTextType("05");
					//fenglei
					prpLltextDto.setTextType("08");
					//Modify by zhaolu 20060909 end
					prpLltextDtoList.add(prpLltextDto);
				}
				endcaseDto.setPrpLltextDtoList(prpLltextDtoList);
			}
			
			/*---------------------״̬����prpLclaimStatus-----------------------*/
			PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
			prpLclaimStatusDto.setStatus("4");
			prpLclaimStatusDto.setBusinessNo(caseNo.trim());
			prpLclaimStatusDto.setPolicyNo(prpLinterRequestDto.getPolicyno());
			prpLclaimStatusDto.setRiskCode(riskCode);
			prpLclaimStatusDto.setNodeType("endca");
			prpLclaimStatusDto.setSerialNo(0);
			//ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���᰸��
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
				
				//���ɻط���Ϣ begin
				prplreturnvisitswflogDto  = this.setReturnVisitSwflogDto(user, registNo, "endca", "0");
				endcaseDto.setPrplreturnvisitswflogDto(prplreturnvisitswflogDto);
				//���ɻط���Ϣ end;
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
			
			if(prpLinterRequestDto.isRecaseFlag()){//�ж��ؿ�
				prpLinterRecaseDetailDto.setEndcaSuccFlag("1");
				prpLinterRecaseDetailDto.setRemark("�᰸�ɹ���"+registNo);
				new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
			}else{
				//��¼���̹켣��-�᰸���ڳɹ���־
				prplinterAutoClaimDetailDto.setEndcaSuccFlag("1");
				prplinterAutoClaimDetailDto.setRemark("�᰸�ɹ���"+registNo);
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
			/***********************add ��ϵͳ��־***********************/
			//���Ӵ�ϵͳ��־medicaltransitflag
			Collection submitSwfLogDtoList = workFlowDto.getSubmitSwfLogDtoList();
			Iterator iter = submitSwfLogDtoList.iterator();
			ArrayList submitListTemp = new ArrayList();
			while(iter.hasNext()){
				SwfLogDto swfLogDto = (SwfLogDto)iter.next();
				swfLogDto.setMedicalTransitFlag("1");//���ô�ϵͳ������λ1����ʱ��Ϊ��ϵͳ����
				submitListTemp.add(swfLogDto);
			}
			workFlowDto.setSubmitSwfLogDtoList(submitListTemp);
			/*************************end****************/
			if(chechkDealFlag == false){
				throw new Exception("û�з����빤������������κ�����");
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
			if(prpLinterRequestDto.isRecaseFlag()){//�ж��ؿ�
				prpLinterRecaseDetailDto.setEndcaSuccFlag("0");
				prpLinterRecaseDetailDto.setRemark("�᰸ʧ�ܣ�"+messege);
				new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
			}else{
				prplinterAutoClaimDetailDto.setEndcaSuccFlag("0");
				prplinterAutoClaimDetailDto.setRemark("�᰸ʧ�ܣ�"+messege);
				new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
			}
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * �Զ��᰸�߼�
	 * @param prpLinterRequestDto
	 * @return prpLinterRequestDto
	 * @throws Exception
	 */
	public PrpLinterRequestDto autoEndcaRecase (PrpLinterRecaseRequestDto prpLinterRequestDto) throws Exception{
		
			PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = 
				prpLinterRequestDto.getPrplinterAutoClaimDetailDto();
			
			//�ؿ��������̹켣
			PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = prpLinterRequestDto.getPrpLinterRecaseDetailDto();
			//�ؿ��������̹켣
			
			// ��ѯ������Ϣ
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
					prpLinterRequestDto.getPolicyno(),
					prpLinterRequestDto.getDamageStartDate().toString(), 
					prpLinterRequestDto.getDamageStartHour());
			String riskCode = policyDto.getPrpCmainDto().getRiskCode();
			String registNo = prpLinterRequestDto.getRelationRegistNo();
			//��װuser���󣬷������ʹ��
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
				throw new Exception("�˰���û�кϷ����ⰸ�ţ��޷�����᰸");
			}
			PrpLclaimDto prpLclaimDto = (PrpLclaimDto)claimList.iterator().next();
			String claimNo = prpLclaimDto.getClaimNo();
			
			int intCompensateFlag = this.checkCompensate(claimNo);
			if (intCompensateFlag == 0) { //�����⣬����ǵ渶����Ӧ���м�����ģ��������ô���ǵġ�
				throw new UserException(1, 3, "endcase", "������"+ claimNo +"û���������飬���ܽ᰸��");
					}

			if (intCompensateFlag < 0) { //�м����飬��ûͨ�����⡣
				throw new UserException(1, 3, "endcase", "��û�к���ͨ���ļ����飬���ܽ᰸��");
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
				throw new Exception("�޿ɴ���᰸�ڵ�");
			}
//		collection.iterator().next();
			SwfLogDto swflogDto = (SwfLogDto)collection.iterator().next();
			
			/*---------------------�ⰸ�ű�prpLcaseno------------------------------------*/
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
			
			/*---------------------�ı���PrpLltextDto--------------------*/
			ArrayList<PrpLltextDto> prpLltextDtoList = new ArrayList<PrpLltextDto>();
			String context = prpLinterRequestDto.getContext();
			if (context != null && context.length()>0) {
				String[] rules = StringUtils.split(context, 70);
				//�õ����Ӵ�,���潫���зֵ�����
				for (int k = 0; k < rules.length; k++) {
					PrpLltextDto prpLltextDto = new PrpLltextDto();
					prpLltextDto.setClaimNo(claimNo.trim());
					prpLltextDto.setContext(rules[k]);
					prpLltextDto.setLineNo(k + 1);
					//Modify by zhaolu 20060909 start
					//reason�Էǳ��ս᰸���渲���� �㱨��������޸�
					//prpLltextDto.setTextType("05");
					//fenglei
					prpLltextDto.setTextType("08");
					//Modify by zhaolu 20060909 end
					prpLltextDtoList.add(prpLltextDto);
				}
				endcaseDto.setPrpLltextDtoList(prpLltextDtoList);
			}
			
			/*---------------------״̬����prpLclaimStatus-----------------------*/
			PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
			prpLclaimStatusDto.setStatus("4");
			prpLclaimStatusDto.setBusinessNo(caseNo.trim());
			prpLclaimStatusDto.setPolicyNo(prpLinterRequestDto.getPolicyno());
			prpLclaimStatusDto.setRiskCode(riskCode);
			prpLclaimStatusDto.setNodeType("endca");
			prpLclaimStatusDto.setSerialNo(0);
			//ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���᰸��
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
				
				//���ɻط���Ϣ begin
				prplreturnvisitswflogDto  = this.setReturnVisitSwflogDto(user, registNo, "endca", "0");
				endcaseDto.setPrplreturnvisitswflogDto(prplreturnvisitswflogDto);
				//���ɻط���Ϣ end;
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
			
			if(prpLinterRequestDto.isRecaseFlag()){//�ж��ؿ�
				prpLinterRecaseDetailDto.setEndcaSuccFlag("1");
				prpLinterRecaseDetailDto.setRemark("�᰸�ɹ���"+registNo);
				new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
			}else{
				//��¼���̹켣��-�᰸���ڳɹ���־
				prplinterAutoClaimDetailDto.setEndcaSuccFlag("1");
				prplinterAutoClaimDetailDto.setRemark("�᰸�ɹ���"+registNo);
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
			/***********************add ��ϵͳ��־***********************/
			//���Ӵ�ϵͳ��־medicaltransitflag
			Collection submitSwfLogDtoList = workFlowDto.getSubmitSwfLogDtoList();
			Iterator iter = submitSwfLogDtoList.iterator();
			ArrayList submitListTemp = new ArrayList();
			while(iter.hasNext()){
				SwfLogDto swfLogDto = (SwfLogDto)iter.next();
				swfLogDto.setMedicalTransitFlag("1");//���ô�ϵͳ������λ1����ʱ��Ϊ��ϵͳ����
				submitListTemp.add(swfLogDto);
			}
			workFlowDto.setSubmitSwfLogDtoList(submitListTemp);
			/*************************end****************/
			if(chechkDealFlag == false){
				throw new Exception("û�з����빤������������κ�����");
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
			if(prpLinterRequestDto.isRecaseFlag()){//�ж��ؿ�
				prpLinterRecaseDetailDto.setEndcaSuccFlag("0");
				prpLinterRecaseDetailDto.setRemark("�᰸ʧ�ܣ�"+messege);
				new BLPrpLinterRecaseDetailFacade().update(prpLinterRecaseDetailDto);
			}else{
				prplinterAutoClaimDetailDto.setEndcaSuccFlag("0");
				prplinterAutoClaimDetailDto.setRemark("�᰸ʧ�ܣ�"+messege);
				new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
			}
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * ����Ƿ���δͨ������������
	 * ����ֵ   0��û����������  -1:����δͨ������������  1�����е��������鶼�Ѿ�ͨ�� 2:�渶�᰸
	 * @param claimNo �ⰸ��
	 * @throws Exception
	 */
	public int checkCompensate(String claimNo) throws Exception {
		//ȡ������������Ϣ
		int compensateFlag= 1 ;
		UICompensateAction uICompensateAction = new UICompensateAction();
		String conditions = "claimNo ='" + claimNo.trim() + "'";
		ArrayList arraylist = (ArrayList) uICompensateAction.findByConditions(conditions);
		if (arraylist == null || arraylist.size() < 1) {
			//return 0;
			//����ǵ渶����£�Ӧ������᰸�ġ����Ի���Ҫ�ж��Ƿ��е渶�������
//			UIPrepayAction uiPrepayAction = new UIPrepayAction ();	
//			conditions = conditions + " and caseType='8'";
//			ArrayList prepayList = (ArrayList)uiPrepayAction.findByConditions(conditions);
			compensateFlag =0;
//			if (prepayList!=null&&prepayList.size()>0){
//				compensateFlag =2; //����е渶����������Խ��н᰸������
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
	 * ����ط���������(�Զ����ɻط���������)
	 * @param httpServletRequest
	 * @param registNo		������
	 * @param nodeType		��ǰ�ڵ�
	 * @param state			�طð���״̬
	 * @throws Exception
	 */
	public PrplreturnvisitswflogDto setReturnVisitSwflogDto(UserDto userDto,String registNo,String nodeType,String state) throws Exception{
		
		//ͨ��ҵ��� ��ȡ������
		BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
		//ͨ�������Ų�ѯ������Ϣ
		PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
		PrplreturnvisitswflogDto prplreturnvisitswflogDto = new PrplreturnvisitswflogDto();
		if(prpLregistDto != null && !"".equals(prpLregistDto)){
			prplreturnvisitswflogDto.setBusinessno(prpLregistDto.getRegistNo());								//ҵ���
			prplreturnvisitswflogDto.setNodetype(nodeType);														//�ڵ��
			prplreturnvisitswflogDto.setRegistno(prpLregistDto.getRegistNo());									//������
			prplreturnvisitswflogDto.setComcode(prpLregistDto.getComCode());									//�б�����			
			prplreturnvisitswflogDto.setPolicyno(prpLregistDto.getPolicyNo());
			UICodeAction uiCodeAction = new UICodeAction();
			String comName = uiCodeAction.translateComCode(prpLregistDto.getComCode(), true);
			prplreturnvisitswflogDto.setComcodename(comName);										//��������
			prplreturnvisitswflogDto.setInsuredname(prpLregistDto.getInsuredName());							//��������
			String reportd = prpLregistDto.getReportDate().toString();
			reportd = reportd+" "+prpLregistDto.getReportHour();
			DateTime d =new DateTime(reportd,DateTime.YEAR_TO_MONTH);
			prplreturnvisitswflogDto.setReportdate(d);			//����ʱ��
			if("sched".equals(nodeType)){
				
			}else{
				prplreturnvisitswflogDto.setCeasedate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));													//�᰸ʱ��
			}
			prplreturnvisitswflogDto.setLicenseno(prpLregistDto.getLicenseNo());								//���ƺ�
			prplreturnvisitswflogDto.setHandlercode(userDto.getUserCode());										//�����˴���
			prplreturnvisitswflogDto.setHandlername(userDto.getUserName());										//����������
			prplreturnvisitswflogDto.setHandlercomcode(userDto.getComCode());									//�����˲���
			
			prplreturnvisitswflogDto.setFlowintotime(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));//����ʱ��
			prplreturnvisitswflogDto.setClasscode(prpLregistDto.getClassCode());								//����
			prplreturnvisitswflogDto.setState(state);															//״̬
			prplreturnvisitswflogDto.setRiskCode(prpLregistDto.getRiskCode());
			
		}
		return prplreturnvisitswflogDto;
	}

}
