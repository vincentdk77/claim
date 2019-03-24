package com.sinosoft.claim.ui.control.viewHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.action.custom.BLRegistAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterCancelClaimDetailAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterRequestAction;
import com.sinosoft.claim.bl.action.domain.BLPrplinterAutoClaimDetailAction;
import com.sinosoft.claim.bl.action.domain.BLPrplinterrelationAction;
import com.sinosoft.claim.bl.facade.BLPrpDuserFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLinterAccdentPersonDto;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.dto.domain.PrplinterrelationDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �Զ�������
 */
public class UIMedicalAutoRegistSubViewHelper {

	String comCode = "";
	String registNo = "";
	String policyNo = "";
	String riskCode = "";
	/**
	 * �Զ������߼�
	 * @param prpLinterRequestDto
	 * @return
	 * @throws Exception
	 */
	public PrpLinterRequestDto autoRegist(PrpLinterRequestDto prpLinterRequestDto) throws Exception{
		//�Զ��������̹켣��
		PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = new PrplinterAutoClaimDetailDto();
		//����ע�����̹켣��
		PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto = new PrpLinterCancelClaimDetailDto();
		boolean cancelFlag = prpLinterRequestDto.isCancelFlag();
		registNo = prpLinterRequestDto.getRegistno();//ȡ��������
		policyNo = prpLinterRequestDto.getPolicyno();//������
		String damageDate = prpLinterRequestDto.getDamageStartDate().toString();
		String damageHour = prpLinterRequestDto.getDamageStartHour();
		boolean isNewCreateRegistNo = false;//�Ƿ����´����ı�������
		String createWorkFlowFlag = "0"; //�Ƿ���Ҫ�����������������һ�α��棬��Ҫ���������� 0 ��ʾ����Ҫ�� 1��ʾ��Ҫ
		UIBillAction uiBillAction = new UIBillAction();
		String tableName = "prplregist";
		// ��ѯ������Ϣ
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,damageDate, damageHour);
		riskCode = policyDto.getPrpCmainDto().getRiskCode();
		comCode = policyDto.getPrpCmainDto().getComCode();
		//��װuser���󣬷������ʹ��
		UserDto user = new UserDto();
		String registUser = prpLinterRequestDto.getRegistUser();
		BLPrpDuserFacade blPrpDuserFacade = new BLPrpDuserFacade();
		PrpDuserDto prpDuserDto = blPrpDuserFacade.findByPrimaryKey(registUser);
		String registName = "";
		if(prpDuserDto!=null){
			registName = prpDuserDto.getUserName();
		}
		user.setUserCode(registUser);
		user.setUserName(registName);
		user.setComCode(prpLinterRequestDto.getMakeCom());
		user.setComName(prpLinterRequestDto.getMakeComName());
		if (null == registNo || registNo.length() < 1) { //����������Ϊ�գ��������±�������
			int year = DateTime.current().getYear();
			registNo = uiBillAction.getNo(tableName, riskCode,comCode, year);
			prpLinterRequestDto.setRelationRegistNo(registNo);
			createWorkFlowFlag = "1";
			isNewCreateRegistNo = true;
		}
		
		try {
			//��ʼ����ҵ���߼�
			RegistDto registDto = this.viewToDto(prpLinterRequestDto, policyDto);
			
			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PrpCmainDto prpCmainDto = uiPolicyAction.findPrpCmainDtoByPrimaryKey(policyNo);
			registDto.getPrpLregistDto().setBusinessType(prpCmainDto.getBusinessType());
			registDto.getPrpLregistDto().setBusinessType1(prpCmainDto.getBusinessType1());
			registDto.getPrpLregistDto().setBusinessFlag(prpCmainDto.getBusinessFlag());
			registDto.getPrpLregistDto().setOtherFlag(prpCmainDto.getOthFlag());
			WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			SwfLogDto swfLogDtoDealNode = new SwfLogDto();
			if (createWorkFlowFlag.equals("1")){
				swfLogDtoDealNode.setCreateFlow(true);
			}
			//�ж��Ƿ������״̬,������������ù������Ĳ���Ϊ�������̽���״̬��
			if (registDto.getPrpLregistDto().getAcceptFlag().equals("N")){
				swfLogDtoDealNode.setEndFlag("1");
			}
			//���ñ������빤�����ĸ���״̬
			swfLogDtoDealNode.setNodeType("regis");
			swfLogDtoDealNode.setNodeStatus(registDto.getPrpLclaimStatusDto().getStatus());
			swfLogDtoDealNode.setBusinessNo(registNo);
			swfLogDtoDealNode.setNextBusinessNo(registNo);
			swfLogDtoDealNode.setKeyIn(registNo);
			swfLogDtoDealNode.setKeyOut(registNo);
			swfLogDtoDealNode.setRiskCode(registDto.getPrpLregistDto().getRiskCode());
			swfLogDtoDealNode.setComCode(comCode);
			swfLogDtoDealNode.setPolicyNo(policyNo);
			swfLogDtoDealNode.setRegistNo(registNo);//������Ĳ�ѯ���������ӱ����ţ��������ˣ����ƺ�(��������Ҫ���)  
			swfLogDtoDealNode.setInsuredName(policyDto.getPrpCmainDto().getInsuredName());
			swfLogDtoDealNode.setLossItemName(registDto.getPrpLregistDto()
					.getLicenseNo());
			swfLogDtoDealNode.setFlowInTime(registDto.getPrpLregistDto()
					.getFlowInTime().toString());
			
			// ���������Ĵ���/�޸�/�ύ������
			WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
			/********************************add start**************************/
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
			SwfLogDto swfLogDto  = workFlowDto.getCreateSwfLogDto();
			swfLogDto.setMedicalTransitFlag("1");
			workFlowDto.setCreateSwfLogDto(swfLogDto);
			/**********************************add end*********************************/
			if(cancelFlag){
				prpLinterCancelClaimDetailDto.setId(prpLinterRequestDto.getId());
				prpLinterCancelClaimDetailDto.setOutId(prpLinterRequestDto.getOutId());
				prpLinterCancelClaimDetailDto.setPolicyNo(policyNo);
				prpLinterCancelClaimDetailDto.setRegistNo(registNo);
				prpLinterCancelClaimDetailDto.setRegistSuccFlag("1");
				prpLinterCancelClaimDetailDto.setRemark("�����ɹ���"+registNo);
			}else{
				prplinterAutoClaimDetailDto.setId(prpLinterRequestDto.getId());
				prplinterAutoClaimDetailDto.setRegistNo(registNo);
				prplinterAutoClaimDetailDto.setPolicyNo(policyNo);
				prplinterAutoClaimDetailDto.setRegistSuccFlag("1");
				prplinterAutoClaimDetailDto.setRemark("�����ɹ���"+registNo);
				prpLinterRequestDto.setPrplinterAutoClaimDetailDto(prplinterAutoClaimDetailDto);
			}
			
			prpLinterRequestDto.setRelationRegistNo(registNo);
//			prpLinterRequestDto.setOutRigstNo(registNo);
			
			PrplinterrelationDto prplinterrelationDto = new PrplinterrelationDto();
			prplinterrelationDto.setId(prpLinterRequestDto.getId());
			prplinterrelationDto.setInputDate(DateTime.current());
			prplinterrelationDto.setOutId(prpLinterRequestDto.getOutId());
			prplinterrelationDto.setOutRigstNo(prpLinterRequestDto.getOutRigstNo());
			prplinterrelationDto.setRelationRegistNo(registNo);
			prplinterrelationDto.setSynchronFlag("0");//Ĭ�ϲ��ɹ�
			
			String sqlRegist = " Update swflog Set Flowintime='"+prpLinterRequestDto.getRegistTime()
			                                   +"',handletime='"+prpLinterRequestDto.getRegistTime()
			                                   +"',submittime='"+prpLinterRequestDto.getRegistTime()
			                                   +"' Where registno ='"+registNo+"' and nodeType ='regis'";
			String sqlSched = " Update swflog Set Flowintime='"+prpLinterRequestDto.getRegistTime()
                                               +"',handletime='"+prpLinterRequestDto.getRegistTime()
                                               +"' Where registno ='"+registNo+"' and nodeType ='sched'";
			
			//�������ݿ�������
		    DBManager dbManager = new DBManager();
		    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
		    try
		    {
		      //��ʼ����
			  dbManager.beginTransaction();
			  if(cancelFlag){
				  new BLPrpLinterCancelClaimDetailAction().insert(dbManager, prpLinterCancelClaimDetailDto);
			  }else{
				  new BLPrplinterAutoClaimDetailAction().insert(dbManager,prplinterAutoClaimDetailDto);
			  }
		      new BLPrplinterrelationAction().insert(dbManager,prplinterrelationDto);
		      /****************�ǲ�����Ҫ���******************/
		      new BLPrpLinterRequestAction().update(dbManager, prpLinterRequestDto);//����û�ж�prpLinterrequest���е����ݽ��и���
		      new BLRegistAction().save(dbManager,registDto);
		      if(workFlowDto!=null){
		        new BLWorkFlowAction().deal(dbManager,workFlowDto);
		      }
		      new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager, sqlRegist);
		      new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager, sqlSched);
		      //�ύ����
		      dbManager.commitTransaction();
		    }
		    catch(SQLException sqle)
		    {
		      //�ع�����
		      dbManager.rollbackTransaction();
		      throw sqle;
		    }
		    catch(Exception ex)
		    {
		      //�ع�����
		      dbManager.rollbackTransaction();
		      throw ex;
		    }
		    finally
		    {
		      //�ر����ݿ�����
		      dbManager.close();
		    }
		} catch (Exception e) {
			e.printStackTrace();
			if(isNewCreateRegistNo){
				//�����쳣����������´����ı������룬��Ҫ�Żغ���
				this.putNoback(registNo);
			}
			throw e;
		}
		return prpLinterRequestDto;
	}
	
	
	/**
	 * �����м��������֯��������
	 * @param prpLinterRequestDto
	 * @param policyDto
	 * @return
	 */
	public RegistDto viewToDto(PrpLinterRequestDto prpLinterRequestDto,PolicyDto policyDto) throws Exception{
		RegistDto registDto =  new RegistDto();
		/*---------------------��������prpLregist------------------------------------*/
		PrpLregistDto prpLregistDto = new PrpLregistDto();
		prpLregistDto.setRegistNo(prpLinterRequestDto.getRelationRegistNo());
		prpLregistDto.setLFlag("L");
        prpLregistDto.setClassCode(policyDto.getPrpCmainDto().getClassCode());
        prpLregistDto.setRiskCode(policyDto.getPrpCmainDto().getRiskCode());
        prpLregistDto.setPolicyNo(policyDto.getPrpCmainDto().getPolicyNo());
        prpLregistDto.setLanguage("C");
        prpLregistDto.setInsuredCode(policyDto.getPrpCmainDto().getInsuredCode());
        prpLregistDto.setInsuredName(policyDto.getPrpCmainDto().getInsuredName());
        prpLregistDto.setInsuredAddress(policyDto.getPrpCmainDto().getInsuredAddress());
        prpLregistDto.setClauseType(prpLinterRequestDto.getClauseType());
        prpLregistDto.setReportDate(prpLinterRequestDto.getReportDate());
        prpLregistDto.setLinkerAddress(prpLinterRequestDto.getLinkerAddress());
        prpLregistDto.setLossesNumber(prpLinterRequestDto.getLossesNumber());
        prpLregistDto.setMakeCom(prpLinterRequestDto.getMakeCom());
        prpLregistDto.setOperatorCode(prpLinterRequestDto.getRegistUser());
        prpLregistDto.setHandler1Code(policyDto.getPrpCmainDto().getHandler1Code());
        prpLregistDto.setRemark(prpLinterRequestDto.getRemark());
        prpLregistDto.setReceiverName(prpLinterRequestDto.getReceiverName());
        prpLregistDto.setReportFlag("0");
        prpLregistDto.setAcceptFlag("Y");
        prpLregistDto.setRepeatInsureFlag("N");

        //Ϊ�˼��ݴ�س����Сʱ�������������ֻ����Сʱ���ֺ����Ȳ�����
        prpLregistDto.setReportHour(prpLinterRequestDto.getReportHour());
        prpLregistDto.setReportorName(prpLinterRequestDto.getReportName());
        prpLregistDto.setReportType(prpLinterRequestDto.getReportType());
        prpLregistDto.setPhoneNumber(prpLinterRequestDto.getPhoneNumber());
        prpLregistDto.setLinkerName(prpLinterRequestDto.getLinkerName());
        prpLregistDto.setDamageStartDate(prpLinterRequestDto.getDamageStartDate());
        prpLregistDto.setDamageEndDate(prpLinterRequestDto.getDamageStartDate());
        //Ϊ�˼��ݴ�س����Сʱ�������������ֻ����Сʱ���ֺ����Ȳ�����
        prpLregistDto.setDamageStartHour(prpLinterRequestDto.getDamageStartHour());
        prpLregistDto.setDamageEndHour(prpLinterRequestDto.getDamageStartHour());
        prpLregistDto.setInputDate(new DateTime(prpLinterRequestDto.getRegistTime(), DateTime.YEAR_TO_DAY));

        prpLregistDto.setDamageCode(prpLinterRequestDto.getDamageCode());
        String damageCode = prpLinterRequestDto.getDamageCode();
        String damageName = new UICodeAction().translateCodeCode("DamageCode", damageCode, true);
        prpLregistDto.setDamageName(damageName);
        prpLregistDto.setDamageTypeCode(prpLinterRequestDto.getDamageTypeCode());
        prpLregistDto.setDamageTypeName(prpLinterRequestDto.getDamageTypeName());
        prpLregistDto.setDamageAddress(prpLinterRequestDto.getDamageAddress());
        prpLregistDto.setEstiCurrency(prpLinterRequestDto.getCurrency());
        prpLregistDto.setComCode(comCode);
        //װ��RegistDto
        registDto.setPrpLregistDto(prpLregistDto);
		
        /*---------------------�¹�����Ϣ��prpLacciPerson------------------------------------*/
        PrpLacciPersonDto prpLacciPerson = null;
        ArrayList<PrpLacciPersonDto> prpLacciPersonList = new ArrayList<PrpLacciPersonDto>();
        PrpLinterAccdentPersonDto[] pla = prpLinterRequestDto.getPrpLinterAccdentPersonDto();
        if(pla != null && pla.length>0){
        	for(int i=0;i<pla.length;i++){
        		prpLacciPerson = new PrpLacciPersonDto();
            	prpLacciPerson.setSerialNo(pla[i].getSerialNo());
            	prpLacciPerson.setPolicyNo(policyNo);
            	prpLacciPerson.setAcciCode(pla[i].getAcciCode());
            	prpLacciPerson.setAcciName(pla[i].getAcciName());
            	prpLacciPerson.setAge(pla[i].getAge());
            	prpLacciPerson.setSex(pla[i].getSex());
            	prpLacciPerson.setIdentifyNumber(pla[i].getIdentifyNumber());
            	prpLacciPerson.setCertiNo(registNo);
            	prpLacciPerson.setCertiType("01");
            	prpLacciPerson.setFamilyNo(2);
            	prpLacciPerson.setAcciCode(prpLinterRequestDto.getPrpLinterAccdentPersonDto()[i].getAcciCode());
            	prpLacciPerson.setAcciName(prpLinterRequestDto.getPrpLinterAccdentPersonDto()[i].getAcciName());
            	prpLacciPersonList.add(prpLacciPerson);
            }
        }
        //װ��RegistDto
        registDto.setPrplacciBenPersonDtoList(prpLacciPersonList);
        
        /*---------------------����˵����prpLregistText------------------------------------*/
        ArrayList<PrpLregistTextDto> prpLregistTextDtoList = new ArrayList<PrpLregistTextDto>();
        String context = prpLinterRequestDto.getContext();
        if(context != null && context.length()>0){
        	String[] rules = StringUtils.split(context, 70);
            //�õ����Ӵ�,���潫���зֵ�����
            for (int k = 0; k < rules.length; k++) {
                PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
                prpLregistTextDto.setRegistNo(registNo);
                prpLregistTextDto.setContext(rules[k]);
                prpLregistTextDto.setLineNo(k + 1);
                prpLregistTextDto.setTextType("1");
                prpLregistTextDtoList.add(prpLregistTextDto);
            }
        }
        //װ��RegistDto
        registDto.setPrpLregistTextDtoList2(prpLregistTextDtoList);
      
        /*---------------------����״̬��prpLclaimStatus------------------------------------*/
        PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
        prpLclaimStatusDto.setBusinessNo(registNo);
        prpLclaimStatusDto.setNodeType("regis");
        prpLclaimStatusDto.setPolicyNo(policyNo);
        prpLclaimStatusDto.setRiskCode(riskCode);
        prpLclaimStatusDto.setStatus("4");
        prpLclaimStatusDto.setInputDate(new DateTime(prpLinterRequestDto.getRegistTime(),DateTime.YEAR_TO_DAY));
        prpLclaimStatusDto.setOperateDate(new DateTime(prpLinterRequestDto.getRegistTime(), DateTime.YEAR_TO_DAY));
        prpLclaimStatusDto.setHandlerCode(prpLinterRequestDto.getOperatorCode());
        //װ��RegistDto
        registDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
        
        /*---------------------����������prpLRegistRPolicy------------------------------------*/
        ArrayList<PrpLRegistRPolicyDto> prpLRegistRPolicyList = new ArrayList<PrpLRegistRPolicyDto>();
        PrpLRegistRPolicyDto prpLRegistRPolicyDto = new PrpLRegistRPolicyDto();
        prpLRegistRPolicyDto.setRegistNo(registNo);
        prpLRegistRPolicyDto.setPolicyNo(policyNo);
        prpLRegistRPolicyDto.setRiskCode(riskCode);
        prpLRegistRPolicyDto.setPolicyType("1");
        prpLRegistRPolicyDto.setRegistFlag("1");
        prpLRegistRPolicyDto.setRegistValidStatus("1");
        prpLRegistRPolicyDto.setRegistComCode(prpLinterRequestDto.getMakeCom());
        prpLRegistRPolicyDto.setClaimNo(prpLinterRequestDto.getClaimno());
        prpLRegistRPolicyDto.setInputDate(prpLinterRequestDto.getRegistTime());
        prpLRegistRPolicyDto.setRemark(prpLinterRequestDto.getRemark());
        prpLRegistRPolicyDto.setOperatorCode(prpLinterRequestDto.getOperatorCode());
        prpLRegistRPolicyDto.setValidStatus("1");
        //װ��RegistDto
        //registDto.setPrpLRegistRPolicyDto(prpLRegistRPolicyDto);
        prpLRegistRPolicyList.add(prpLRegistRPolicyDto);
        registDto.setPrpLRegistRPolicyList(prpLRegistRPolicyList);
        /*---------------------��������PrpLscheduleMainWF------------------------------------*/
        PrpLscheduleMainWFDto prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();
        prpLscheduleMainWFDto.setScheduleID(1);
        prpLscheduleMainWFDto.setRegistNo(registNo);
        prpLscheduleMainWFDto.setPolicyNo(policyNo);
        prpLscheduleMainWFDto.setRiskCode(riskCode);
        prpLscheduleMainWFDto.setInputDate(new DateTime(prpLinterRequestDto.getRegistTime(),DateTime.YEAR_TO_DAY));
        prpLscheduleMainWFDto.setInputHour(prpLinterRequestDto.getRegistTime().getHour() );
        prpLscheduleMainWFDto.setOperatorCode(prpLinterRequestDto.getOperatorCode());
        prpLscheduleMainWFDto.setNextHandlerCode(prpLinterRequestDto.getNextHandlerCode());
        prpLscheduleMainWFDto.setNextHandlerName(prpLinterRequestDto.getNextHandlerName());
        prpLscheduleMainWFDto.setOperatorName(prpLinterRequestDto.getOperatorName());
        prpLscheduleMainWFDto.setPhoneNumber(prpLinterRequestDto.getPhoneNumber());
        prpLscheduleMainWFDto.setLinkerName(prpLinterRequestDto.getLinkerName());
        prpLscheduleMainWFDto.setClaimComCode(prpLinterRequestDto.getMakeCom());
        prpLscheduleMainWFDto.setScheduleObjectID  ("_" );
        prpLscheduleMainWFDto.setScheduleObjectName(" ");
        prpLscheduleMainWFDto.setCheckFlag("0");
        prpLscheduleMainWFDto.setScheduleFlag("0");  //�鿱����û�б��ɳ�ȥ��
        prpLscheduleMainWFDto.setFlag                ("");
        //װ��RegistDto
        registDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
        
        /*---------------------�����ӱ�prpLscheduleItem------------------------------------*/
        ArrayList<PrpLscheduleItemDto> prpLscheduleItemDtoList = new ArrayList<PrpLscheduleItemDto>();
        PrpLscheduleItemDto prpLscheduleItemDto = new PrpLscheduleItemDto();
        prpLscheduleItemDto.setScheduleID(1);
        prpLscheduleItemDto.setItemNo(-2);
		// ��ʾ�Ƿ�ѡ��
		//prpLscheduleItemDto.setSelectSend(prpLthirdPropSelectSend);
		// ��ʾû�е��ȳɶ����
		prpLscheduleItemDto.setSurveyTimes(0);
		prpLscheduleItemDto.setSurveyType("1");
        prpLscheduleItemDto.setRegistNo(registNo);
        prpLscheduleItemDto.setOperatorName(prpLinterRequestDto.getOperatorName());
        prpLscheduleItemDto.setInputDate(new DateTime(prpLinterRequestDto.getRegistTime(), DateTime.YEAR_TO_DAY));
        prpLscheduleItemDto.setOperatorCode(prpLinterRequestDto.getOperatorCode());
        prpLscheduleItemDto.setNextHandlerCode(prpLinterRequestDto.getNextHandlerCode());
        prpLscheduleItemDto.setNextHandlerName(prpLinterRequestDto.getNextHandlerName());
        prpLscheduleItemDto.setOperatorName(prpLinterRequestDto.getOperatorName());
        prpLscheduleItemDto.setCheckSite(prpLinterRequestDto.getCheckSite());
        prpLscheduleItemDto.setScheduleType("sched");
		prpLscheduleItemDto.setLicenseNo("�Ʋ���ʧ");
		prpLscheduleItemDto.setScheduleObjectID("_");
		prpLscheduleItemDto.setScheduleObjectName(" ");
		prpLscheduleItemDto.setNextNodeNo("certa");
        //װ��RegistDto
		prpLscheduleItemDtoList.add(prpLscheduleItemDto);
        registDto.setPrpLscheduleItemDtoList(prpLscheduleItemDtoList);
        
		return registDto;
	}
	
	
	/**
	 * �����źŻع麯��
	 * @param registNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean putNoback(String registNo) throws SQLException, Exception {
		UIBillAction uiBillAction = new UIBillAction();
		String tableName = "prplregist";
		if (uiBillAction.putNo(tableName, registNo)) {
			System.out.println("���ŷŻسɹ�" + registNo);
		} else {
			System.out.println("���ŷŻ�ʧ��" + registNo);
		}
		return true;
	}
	
}
