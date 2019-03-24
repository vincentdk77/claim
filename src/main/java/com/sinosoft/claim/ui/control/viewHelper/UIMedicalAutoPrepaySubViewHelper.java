package com.sinosoft.claim.ui.control.viewHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpSession;

import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrplinterAutoClaimDetailAction;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacadeBase;
import com.sinosoft.claim.bl.facade.BLPrplinterAutoClaimDetailFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.PrepayDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLinterPrepayFeeDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrpLpreChargeDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLptextDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIPrepayAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.facade.UIWorkFlowUWInterFaceFacade;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * Ԥ�������࣬���������²�����
 * 1.	�����м������Ԥ����Ϣ���������ⰸ�ڵ�
 * 2.	�����м��������֯Ԥ�����ҵ������
 * 3.	���������ⰸ�ڵ㣬���ɺ���ڵ�
 * */
public class UIMedicalAutoPrepaySubViewHelper {
	/**
	 * Ԥ�������߼�
	 * @param prpLinterRequestDto
	 * @return prpLinterRequestDto
	 * @throws Exception
	 * */
	public PrpLinterRequestDto autoPrepay (PrpLinterRequestDto prpLinterRequestDto) throws Exception{
		PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = prpLinterRequestDto.getPrplinterAutoClaimDetailDto();
		//��װuser���󣬷������ʹ��
		UserDto user = new UserDto();
		user.setUserCode(prpLinterRequestDto.getOperatorCode());
		user.setUserName(prpLinterRequestDto.getOperatorName());
		user.setComCode(prpLinterRequestDto.getMakeCom());
		user.setComName(prpLinterRequestDto.getMakeComName());
		DBManager dbManager = new DBManager();
		
		if(prpLinterRequestDto.getCaseType()!=null && 
				(prpLinterRequestDto.getPrpLinterPrepayFeeDto()!=null || prpLinterRequestDto.getSumPrePaid()>0)){
			try {
				String registNo = prpLinterRequestDto.getRelationRegistNo();
				Collection claimList = new BLPrpLclaimFacadeBase().findByConditions(" registNo='"+registNo+"' ");
				if(claimList==null || claimList.size()<1){
					throw new Exception("�˰���û�д����������޷�����Ԥ��");
				}
				PrpLclaimDto prplclaimDto = (PrpLclaimDto)claimList.iterator().next();
				String claimNo = prplclaimDto.getClaimNo();
				ClaimDto claimDto = new UIClaimAction().findByPrimaryKey(claimNo);
				Collection compeSwflogList = new UIWorkFlowAction().findNodesByConditions(
						" registno='"+registNo+"' and nodetype='compe' and nodestatus='4' ");
				if(compeSwflogList!=null && compeSwflogList.size()>0){
					throw new Exception("����ڵ����ύ���ܽ���Ԥ�ⰸ����");
				}
				Collection certiSwflogList = new UIWorkFlowAction().findNodesByConditions(
						" registno='"+registNo+"' and nodetype='certi' and nodestatus in ('0','2','3') ");
				if(certiSwflogList==null || certiSwflogList.size()<1){
					throw new Exception("û��δ����ĵ�֤�������ڵ㲻�ܽ���Ԥ�ⰸ����");
				}
				SwfLogDto swflogDto = (SwfLogDto)certiSwflogList.iterator().next();
				String nodeStatus = swflogDto.getNodeStatus();
				
				String preCompensateNo = new UIBillAction().getNo("prplprepay",prplclaimDto.getRiskCode(),prplclaimDto.getComCode(), DateTime.current().getYear());
				String caseType = prpLinterRequestDto.getCaseType();
				String payAppContext = prpLinterRequestDto.getPayAppContext();
				String nowTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				String notionString = prpLinterRequestDto.getOperatorName()+" "+nowTime+" "+payAppContext;
				String[] notions = StringUtils.split(notionString,70);
				ArrayList<SwfNotionDto> swfNotionDtoList = new ArrayList<SwfNotionDto>();
				SwfNotionDto swfNotionDto = null;
				int maxLineNo = new UIWorkFlowAction().getSwfNotionMaxLineNo(swflogDto.getFlowID(),swflogDto.getNodeNo());
				for(int i=0;i<notions.length;i++){
					swfNotionDto = new SwfNotionDto();
				    swfNotionDto.setFlowID(swflogDto.getFlowID());
				    swfNotionDto.setLogNo(swflogDto.getLogNo());
				    swfNotionDto.setLineNo(maxLineNo + i + 1);
				    swfNotionDto.setHandleText(notions[i]);
				    swfNotionDtoList.add(swfNotionDto);
				}
				
				WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
				swflogDto.setNextBusinessNo(preCompensateNo);
				swflogDto.setKeyIn(claimNo);
		        swflogDto.setKeyOut(claimNo);
				swflogDto.setNodeStatus("4");
				
				SwfLogDto swflogDealNode = new SwfLogDto();
				swflogDealNode.setFlowID(swflogDto.getFlowID());
				swflogDealNode.setLogNo(swflogDto.getLogNo());
				swflogDealNode.setNodeStatus("4");
				swflogDealNode.setKeyIn(claimNo);
				swflogDealNode.setKeyOut(preCompensateNo);
				swflogDealNode.setNextBusinessNo(preCompensateNo);
				swflogDealNode.setPolicyNo(prpLinterRequestDto.getPolicyno());
				//ָ���¸��ڵ���������ⰸ������ 
				 Collection nextNodeList = new ArrayList();
				SwfLogDto swflogNextNode = new SwfLogDto();
				swflogNextNode.setNodeNo(0);
				swflogNextNode.setNodeType("speci");
				swflogNextNode.setBusinessNo(preCompensateNo);
				swflogNextNode.setTypeFlag(caseType); //�����ⰸ���͵�
				swflogNextNode.setPolicyNo(prpLinterRequestDto.getPolicyno());
				nextNodeList.add(swflogNextNode);
				swflogDealNode.setNextNodeListType("1");//�����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
				swflogDealNode.setSwfLogList(nextNodeList);
				WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swflogDealNode);
				workFlowDto.setSwfNotionDtoList(swfNotionDtoList);
				if (workFlowDto.getUpdateSwfLogDto()!=null) {
					workFlowDto.getUpdateSwfLogDto().setNodeStatus(nodeStatus);
				}
				
				if (!workFlowViewHelper.checkDealDto(workFlowDto)){
					throw new Exception("û�пɴ���Ĺ���������");
				}
				
				CompensateDto compensateDto = this.saveCompensate(prpLinterRequestDto, claimDto, preCompensateNo);
				new UICompensateAction().save(compensateDto, workFlowDto);
				
				PrepayDto prepayDto = this.viewToDto(prpLinterRequestDto, prplclaimDto, user ,preCompensateNo);
				//����Ԥ����Ϣ
				UIPrepayAction uiPrepayAction = new UIPrepayAction();
				uiPrepayAction.save(prepayDto);
				try {
					dbManager.open(AppConfig.get("sysconst.DBJNDI"));
					//����ʼ
					dbManager.beginTransaction();
					Collection swflogVericDtoList = new UIWorkFlowAction().findNodesByConditions(" registno='"+registNo+"' and nodetype='speci' and nodestatus='0' ");
					if(swflogVericDtoList == null || swflogVericDtoList.size()<1){
						throw new Exception("Ԥ��ڵ�δ�ύ���޷�����Ԥ������");
					}
					SwfLogDto swflogVericDto = (SwfLogDto)swflogVericDtoList.iterator().next();
					swflogVericDto.setHandlerCode(prpLinterRequestDto.getOperatorCode());
					swflogVericDto.setHandlerName(prpLinterRequestDto.getOperatorName());
					swflogVericDto.setNextBusinessNo(preCompensateNo);
					swflogVericDto.setKeyIn(preCompensateNo);
					swflogVericDto.setKeyOut(preCompensateNo);
					swflogVericDto.setNodeStatus("4");
					
					WorkFlowDto workFlowDtoDealNode = workFlowViewHelper.viewToDto(user,swflogVericDto);
					boolean checkFlag = workFlowViewHelper.checkDealDto(workFlowDto);
					if(checkFlag == false){
						throw new Exception("û����Ҫ����Ĺ���������");
					}
					
					new BLWorkFlowAction().deal(dbManager,workFlowDtoDealNode);
					if ((workFlowDtoDealNode.getCreate()) || (workFlowDtoDealNode.getUpdate()) 
							||(workFlowDtoDealNode.getSubmit())||(workFlowDtoDealNode.getClose())){
					//���ӶԺ˱�����ϵͳ�Ľӿڵ��á�
					int vericLogNo=0;
					 if (swflogVericDto.getNodeStatus().equals("4")){
						 if (workFlowDtoDealNode.getSubmitSwfLogDtoList()!=null &&workFlowDtoDealNode.getSubmitSwfLogDtoList().size()!=0){
					         vericLogNo=((SwfLogDto)workFlowDtoDealNode.getSubmitSwfLogDtoList().get(0)).getLogNo() ;
					     }
						 UIWorkFlowUWInterFaceFacade uiWorkFlowUWInterFaceFacade=new UIWorkFlowUWInterFaceFacade();
					     String UWflowID= uiWorkFlowUWInterFaceFacade.submitVericTask(workFlowDtoDealNode.getUpdateSwfLogDto().getFlowID() ,
					            vericLogNo+"",
					            "22",
					            "Y",
					            preCompensateNo,
					            prepayDto.getPrpLprepayDto().getRiskCode() ,
					            prepayDto.getPrpLprepayDto().getClassCode() ,
					            prepayDto.getPrpLprepayDto().getComCode(),
					            prepayDto.getPrpLprepayDto().getHandlerCode() ,
					            prepayDto.getPrpLprepayDto().getMakeCom() ,
					            user.getUserCode(),
					            prepayDto.getPrpLprepayDto().getHandler1Code() ,
					            "");
					     if (UWflowID.length()!= 27){
					        //����ύ����ʧ����״̬Ϊ0
					    	swflogVericDto.setNodeStatus("2");
					        prepayDto.getPrpLprepayDto().setUnderWriteFlag("0");
					        workFlowDtoDealNode = workFlowViewHelper.viewToDto(user, swflogVericDto);
							uiPrepayAction.save(prepayDto);
					        String msg="����'"+preCompensateNo+"'�ύ˫��ϵͳʧ�ܣ��������ύ���������Ա��ϵ!";
					        throw new UserException(1,3,"������",msg);
					     }
					 }
					} else {
					     //����ύ����ʧ����״̬Ϊ0
					     prepayDto.getPrpLprepayDto().setUnderWriteFlag("0");
						 uiPrepayAction.save(prepayDto);
					}
					//��¼���̹켣��-Ԥ�����뻷�ڳɹ���־
					prplinterAutoClaimDetailDto.setPrepaySuccFlag("1");
					prplinterAutoClaimDetailDto.setRemark("Ԥ������ɹ���"+preCompensateNo);
					new BLPrplinterAutoClaimDetailAction().update(dbManager,prplinterAutoClaimDetailDto);
					//�ύ����
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
				prplinterAutoClaimDetailDto.setPrepaySuccFlag("0");
				prplinterAutoClaimDetailDto.setRemark("Ԥ������ʧ�ܣ�"+messege);
				new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
				e.printStackTrace();
				throw e;
			}
			
		} else {
			return prpLinterRequestDto;
		}
		
		return prpLinterRequestDto;
	}
	
	/**
	* �����м�������ʼ�ռ�Ԥ��ľ���ҵ������
	* @param prpLinterRequestDto  prplclaimDto
	* @return prepayDto �������ݴ������ݽṹ
	* @throws Exception
	*/
	public PrepayDto viewToDto(PrpLinterRequestDto prpLinterRequestDto,PrpLclaimDto prplclaimDto,UserDto user,String preCompensateNo) throws Exception {
		PrepayDto prepayDto = new PrepayDto();
		int year = DateTime.current().getYear();
		
		/*---------------------Ԥ������prpLprepay------------------------------------*/
	      PrpLprepayDto prpLprepayDto = new PrpLprepayDto();
	      prpLprepayDto.setPreCompensateNo(preCompensateNo);
	      prpLprepayDto.setClaimNo(prplclaimDto.getClaimNo());
	      prpLprepayDto.setRiskCode(prplclaimDto.getRiskCode());
	      prpLprepayDto.setPolicyNo(prpLinterRequestDto.getPolicyno());
	      prpLprepayDto.setCurrency(prplclaimDto.getCurrency());
	      prpLprepayDto.setArrearageTimes(0);
	      prpLprepayDto.setSumArrearage(0);
	      prpLprepayDto.setSumBeforePrePaid(0);
	      //prpLprepayDto.setSumBeforePrePaid(Integer.parseInt(httpServletRequest.getParameter("prpLprepaySumBeforePrePaid")));
	      prpLprepayDto.setBlockUpTimes(0);
	      prpLprepayDto.setSumPrePaid(prpLinterRequestDto.getSumPrePaid());
	      prpLprepayDto.setSumTotalPrepaid(0);
	      prpLprepayDto.setComCode(prplclaimDto.getComCode());
	      prpLprepayDto.setMakeCom(prplclaimDto.getMakeCom());
	      prpLprepayDto.setHandlerCode(prplclaimDto.getHandlerCode());
	      prpLprepayDto.setHandler1Code(prplclaimDto.getHandler1Code());
	      prpLprepayDto.setApproverCode("");
//	      prpLprepayDto.setUnderWriteCode(httpServletRequest.getParameter("prpLprepayUnderWriteCode"));
//	      prpLprepayDto.setUnderWriteName(httpServletRequest.getParameter("prpLprepayUnderWriteName"));
	      prpLprepayDto.setStatisticsYM(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
	      prpLprepayDto.setOperatorCode(prpLinterRequestDto.getOperatorCode());
	      prpLprepayDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
	      prpLprepayDto.setUnderWriteEndDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
	      prpLprepayDto.setUnderWriteFlag("9");
	      prpLprepayDto.setFlag("");
	      prpLprepayDto.setCaseType(prpLinterRequestDto.getCaseType());
	      //��������
	      prpLprepayDto.setClassCode(prplclaimDto.getClassCode());      
	 
	      //�ӵ�ArrayList��
	      
	      /*---------------------Ԥ�����PrpLpreChargeDto--------------------------*/
	      ArrayList prpLpreChargeDtoList = new ArrayList();
	      PrpLinterPrepayFeeDto[] prpLinterPrepayFeeDtos = prpLinterRequestDto.getPrpLinterPrepayFeeDto();
	      PrpLpreChargeDto prpLpreChargeDto = null;
	      double sumPrePaid = 0.0;
	      for(int i=0;i<prpLinterPrepayFeeDtos.length;i++){
	    	  PrpLinterPrepayFeeDto prpLinterPrepayFeeDto = prpLinterPrepayFeeDtos[i];
	    	  if(prpLinterPrepayFeeDto != null){
	    		  prpLpreChargeDto = new PrpLpreChargeDto();
		    	  prpLpreChargeDto.setPreCompensateNo(prpLprepayDto.getPreCompensateNo() );
		    	  prpLpreChargeDto.setSerialNo(prpLinterPrepayFeeDtos[i].getSerialNo());
		    	  prpLpreChargeDto.setClaimNo(prplclaimDto.getClaimNo());
		    	  prpLpreChargeDto.setRiskCode(prplclaimDto.getRiskCode());
		    	  prpLpreChargeDto.setPolicyNo(prpLinterRequestDto.getPolicyno());
		    	  prpLpreChargeDto.setKindCode(prpLinterPrepayFeeDtos[i].getKindCode());
		    	  prpLpreChargeDto.setChargeCode(prpLinterPrepayFeeDtos[i].getChargeCode());
		    	  prpLpreChargeDto.setChargeEName(prpLinterPrepayFeeDtos[i].getChargeName());
		    	  prpLpreChargeDto.setCurrenCY(prpLinterPrepayFeeDtos[i].getCurrency());
		    	  prpLpreChargeDto.setSumPrepaid(prpLinterPrepayFeeDtos[i].getChargeReport());
		    	  sumPrePaid += prpLinterPrepayFeeDtos[i].getChargeReport();
	    	  }
	    	  prpLpreChargeDtoList.add(prpLpreChargeDto);
	      }
	      prpLprepayDto.setSumPreChargePaid(sumPrePaid);
	      prepayDto.setPrpLprepayDto(prpLprepayDto);
	      prepayDto.setPrpLpreChargeDtoList(prpLpreChargeDtoList);
	      /*---------------------Ԥ���ı���PrpLptextDto------------------------------------*/
	      ArrayList prpLptextDtoList = new ArrayList();
	      PrpLptextDto prpLptextDto = null;
	      String prepayReport = prpLinterRequestDto.getPrepayReport();
	      String[] rules = StringUtils.split(prepayReport,70);
	      //�õ����Ӵ�,���潫���зֵ�����
	      for(int k=0;k<rules.length;k++){
	        prpLptextDto = new PrpLptextDto();
	        prpLptextDto.setPreCompensateNo(prpLprepayDto.getPreCompensateNo() );
	        prpLptextDto.setContext(rules[k]);
	        prpLptextDto.setLineNo(k+1);
	        prpLptextDtoList.add(prpLptextDto);
	      }
	      
	      //prepayDto
	      prepayDto.setPrpLptextDtoList(prpLptextDtoList);

	      /*---------------------��������״̬����prpLclaimStatus------------------------------------*/
	      PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
	      prpLclaimStatusDto.setStatus("4");
	      prpLclaimStatusDto.setBusinessNo(prpLprepayDto.getPreCompensateNo() );
	      prpLclaimStatusDto.setPolicyNo(prpLprepayDto.getPolicyNo());
	      prpLclaimStatusDto.setTypeFlag("5");
	      prpLclaimStatusDto.setNodeType("speci");
	      prpLclaimStatusDto.setSerialNo(5);
	      prpLclaimStatusDto.setRiskCode(prplclaimDto.getRiskCode());
	      prpLclaimStatusDto.setHandlerCode(user.getUserCode() );
	      prpLclaimStatusDto.setInputDate(prpLprepayDto.getInputDate() );
	      prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
	      prepayDto.setPrpLclaimStatusDto(prpLclaimStatusDto);

	      PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
	      prpLclaimDto.setClaimNo(prplclaimDto.getClaimNo());
	      prpLclaimDto.setSumPaid(sumPrePaid);
	      prepayDto.setPrpLclaimDto(prpLclaimDto);
	      
	      return prepayDto;
	}
	
	public CompensateDto saveCompensate(PrpLinterRequestDto prpLinterRequestDto,ClaimDto claimDto,String compensateNo) throws Exception{
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
		prpLcompensateDto.setPreserveDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
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
		prpLcompensateDto.setStatisticsYM(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		prpLcompensateDto.setOperatorCode(prpLinterRequestDto.getOperatorCode());
		prpLcompensateDto.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
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
		prpLcompensateDto.setUnderWriteEndDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
		//prpLcompensateDto.setCaseType("2");
		//prpLcompensateDto.setMedicalType("02");
		compensateDto.setPrpLcompensateDto(prpLcompensateDto);
		return compensateDto;
	}

}
