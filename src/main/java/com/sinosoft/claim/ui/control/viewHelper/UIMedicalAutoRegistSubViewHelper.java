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
 * 自动报案类
 */
public class UIMedicalAutoRegistSubViewHelper {

	String comCode = "";
	String registNo = "";
	String policyNo = "";
	String riskCode = "";
	/**
	 * 自动报案逻辑
	 * @param prpLinterRequestDto
	 * @return
	 * @throws Exception
	 */
	public PrpLinterRequestDto autoRegist(PrpLinterRequestDto prpLinterRequestDto) throws Exception{
		//自动理赔流程轨迹表
		PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = new PrplinterAutoClaimDetailDto();
		//报案注销流程轨迹表
		PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto = new PrpLinterCancelClaimDetailDto();
		boolean cancelFlag = prpLinterRequestDto.isCancelFlag();
		registNo = prpLinterRequestDto.getRegistno();//取报案号码
		policyNo = prpLinterRequestDto.getPolicyno();//保单号
		String damageDate = prpLinterRequestDto.getDamageStartDate().toString();
		String damageHour = prpLinterRequestDto.getDamageStartHour();
		boolean isNewCreateRegistNo = false;//是否是新创建的报案号码
		String createWorkFlowFlag = "0"; //是否需要创建工作流，如果第一次保存，需要创建工作流 0 表示不需要， 1表示需要
		UIBillAction uiBillAction = new UIBillAction();
		String tableName = "prplregist";
		// 查询保单信息
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,damageDate, damageHour);
		riskCode = policyDto.getPrpCmainDto().getRiskCode();
		comCode = policyDto.getPrpCmainDto().getComCode();
		//组装user对象，方便后续使用
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
		if (null == registNo || registNo.length() < 1) { //若报案号码为空，则生成新报案号码
			int year = DateTime.current().getYear();
			registNo = uiBillAction.getNo(tableName, riskCode,comCode, year);
			prpLinterRequestDto.setRelationRegistNo(registNo);
			createWorkFlowFlag = "1";
			isNewCreateRegistNo = true;
		}
		
		try {
			//开始处理业务逻辑
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
			//判断是否受理的状态,如果不受理，设置工作流的参数为工作流程结束状态。
			if (registDto.getPrpLregistDto().getAcceptFlag().equals("N")){
				swfLogDtoDealNode.setEndFlag("1");
			}
			//设置报案传入工作流的各个状态
			swfLogDtoDealNode.setNodeType("regis");
			swfLogDtoDealNode.setNodeStatus(registDto.getPrpLclaimStatusDto().getStatus());
			swfLogDtoDealNode.setBusinessNo(registNo);
			swfLogDtoDealNode.setNextBusinessNo(registNo);
			swfLogDtoDealNode.setKeyIn(registNo);
			swfLogDtoDealNode.setKeyOut(registNo);
			swfLogDtoDealNode.setRiskCode(registDto.getPrpLregistDto().getRiskCode());
			swfLogDtoDealNode.setComCode(comCode);
			swfLogDtoDealNode.setPolicyNo(policyNo);
			swfLogDtoDealNode.setRegistNo(registNo);//待处理的查询条件，增加报案号，被保险人，车牌号(工作流需要添加)  
			swfLogDtoDealNode.setInsuredName(policyDto.getPrpCmainDto().getInsuredName());
			swfLogDtoDealNode.setLossItemName(registDto.getPrpLregistDto()
					.getLicenseNo());
			swfLogDtoDealNode.setFlowInTime(registDto.getPrpLregistDto()
					.getFlowInTime().toString());
			
			// 整理工作流的创建/修改/提交的数据
			WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
			/********************************add start**************************/
			//增加大病系统标志medicaltransitflag
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
				prpLinterCancelClaimDetailDto.setRemark("报案成功："+registNo);
			}else{
				prplinterAutoClaimDetailDto.setId(prpLinterRequestDto.getId());
				prplinterAutoClaimDetailDto.setRegistNo(registNo);
				prplinterAutoClaimDetailDto.setPolicyNo(policyNo);
				prplinterAutoClaimDetailDto.setRegistSuccFlag("1");
				prplinterAutoClaimDetailDto.setRemark("报案成功："+registNo);
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
			prplinterrelationDto.setSynchronFlag("0");//默认不成功
			
			String sqlRegist = " Update swflog Set Flowintime='"+prpLinterRequestDto.getRegistTime()
			                                   +"',handletime='"+prpLinterRequestDto.getRegistTime()
			                                   +"',submittime='"+prpLinterRequestDto.getRegistTime()
			                                   +"' Where registno ='"+registNo+"' and nodeType ='regis'";
			String sqlSched = " Update swflog Set Flowintime='"+prpLinterRequestDto.getRegistTime()
                                               +"',handletime='"+prpLinterRequestDto.getRegistTime()
                                               +"' Where registno ='"+registNo+"' and nodeType ='sched'";
			
			//创建数据库管理对象
		    DBManager dbManager = new DBManager();
		    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
		    try
		    {
		      //开始事务
			  dbManager.beginTransaction();
			  if(cancelFlag){
				  new BLPrpLinterCancelClaimDetailAction().insert(dbManager, prpLinterCancelClaimDetailDto);
			  }else{
				  new BLPrplinterAutoClaimDetailAction().insert(dbManager,prplinterAutoClaimDetailDto);
			  }
		      new BLPrplinterrelationAction().insert(dbManager,prplinterrelationDto);
		      /****************是不是需要添加******************/
		      new BLPrpLinterRequestAction().update(dbManager, prpLinterRequestDto);//好像没有对prpLinterrequest表中的数据进行更新
		      new BLRegistAction().save(dbManager,registDto);
		      if(workFlowDto!=null){
		        new BLWorkFlowAction().deal(dbManager,workFlowDto);
		      }
		      new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager, sqlRegist);
		      new BLPrplinterAutoClaimDetailAction().updateBySQL(dbManager, sqlSched);
		      //提交事务
		      dbManager.commitTransaction();
		    }
		    catch(SQLException sqle)
		    {
		      //回滚事务
		      dbManager.rollbackTransaction();
		      throw sqle;
		    }
		    catch(Exception ex)
		    {
		      //回滚事务
		      dbManager.rollbackTransaction();
		      throw ex;
		    }
		    finally
		    {
		      //关闭数据库连接
		      dbManager.close();
		    }
		} catch (Exception e) {
			e.printStackTrace();
			if(isNewCreateRegistNo){
				//出险异常后如果是最新创建的报案号码，需要放回号码
				this.putNoback(registNo);
			}
			throw e;
		}
		return prpLinterRequestDto;
	}
	
	
	/**
	 * 根据中间表数据组织报案对象
	 * @param prpLinterRequestDto
	 * @param policyDto
	 * @return
	 */
	public RegistDto viewToDto(PrpLinterRequestDto prpLinterRequestDto,PolicyDto policyDto) throws Exception{
		RegistDto registDto =  new RegistDto();
		/*---------------------报案主表prpLregist------------------------------------*/
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

        //为了兼容大地程序的小时设置情况，所以只保存小时，分和秒先不保存
        prpLregistDto.setReportHour(prpLinterRequestDto.getReportHour());
        prpLregistDto.setReportorName(prpLinterRequestDto.getReportName());
        prpLregistDto.setReportType(prpLinterRequestDto.getReportType());
        prpLregistDto.setPhoneNumber(prpLinterRequestDto.getPhoneNumber());
        prpLregistDto.setLinkerName(prpLinterRequestDto.getLinkerName());
        prpLregistDto.setDamageStartDate(prpLinterRequestDto.getDamageStartDate());
        prpLregistDto.setDamageEndDate(prpLinterRequestDto.getDamageStartDate());
        //为了兼容大地程序的小时设置情况，所以只保存小时，分和秒先不保存
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
        //装入RegistDto
        registDto.setPrpLregistDto(prpLregistDto);
		
        /*---------------------事故者信息表prpLacciPerson------------------------------------*/
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
        //装入RegistDto
        registDto.setPrplacciBenPersonDtoList(prpLacciPersonList);
        
        /*---------------------补充说明表prpLregistText------------------------------------*/
        ArrayList<PrpLregistTextDto> prpLregistTextDtoList = new ArrayList<PrpLregistTextDto>();
        String context = prpLinterRequestDto.getContext();
        if(context != null && context.length()>0){
        	String[] rules = StringUtils.split(context, 70);
            //得到连接串,下面将其切分到数组
            for (int k = 0; k < rules.length; k++) {
                PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
                prpLregistTextDto.setRegistNo(registNo);
                prpLregistTextDto.setContext(rules[k]);
                prpLregistTextDto.setLineNo(k + 1);
                prpLregistTextDto.setTextType("1");
                prpLregistTextDtoList.add(prpLregistTextDto);
            }
        }
        //装入RegistDto
        registDto.setPrpLregistTextDtoList2(prpLregistTextDtoList);
      
        /*---------------------立案状态表prpLclaimStatus------------------------------------*/
        PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
        prpLclaimStatusDto.setBusinessNo(registNo);
        prpLclaimStatusDto.setNodeType("regis");
        prpLclaimStatusDto.setPolicyNo(policyNo);
        prpLclaimStatusDto.setRiskCode(riskCode);
        prpLclaimStatusDto.setStatus("4");
        prpLclaimStatusDto.setInputDate(new DateTime(prpLinterRequestDto.getRegistTime(),DateTime.YEAR_TO_DAY));
        prpLclaimStatusDto.setOperateDate(new DateTime(prpLinterRequestDto.getRegistTime(), DateTime.YEAR_TO_DAY));
        prpLclaimStatusDto.setHandlerCode(prpLinterRequestDto.getOperatorCode());
        //装入RegistDto
        registDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
        
        /*---------------------保单关联表prpLRegistRPolicy------------------------------------*/
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
        //装入RegistDto
        //registDto.setPrpLRegistRPolicyDto(prpLRegistRPolicyDto);
        prpLRegistRPolicyList.add(prpLRegistRPolicyDto);
        registDto.setPrpLRegistRPolicyList(prpLRegistRPolicyList);
        /*---------------------调度主表PrpLscheduleMainWF------------------------------------*/
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
        prpLscheduleMainWFDto.setScheduleFlag("0");  //查勘调度没有被派出去的
        prpLscheduleMainWFDto.setFlag                ("");
        //装入RegistDto
        registDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
        
        /*---------------------调度子表prpLscheduleItem------------------------------------*/
        ArrayList<PrpLscheduleItemDto> prpLscheduleItemDtoList = new ArrayList<PrpLscheduleItemDto>();
        PrpLscheduleItemDto prpLscheduleItemDto = new PrpLscheduleItemDto();
        prpLscheduleItemDto.setScheduleID(1);
        prpLscheduleItemDto.setItemNo(-2);
		// 表示是否选中
		//prpLscheduleItemDto.setSelectSend(prpLthirdPropSelectSend);
		// 表示没有调度成定损过
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
		prpLscheduleItemDto.setLicenseNo("财产损失");
		prpLscheduleItemDto.setScheduleObjectID("_");
		prpLscheduleItemDto.setScheduleObjectName(" ");
		prpLscheduleItemDto.setNextNodeNo("certa");
        //装入RegistDto
		prpLscheduleItemDtoList.add(prpLscheduleItemDto);
        registDto.setPrpLscheduleItemDtoList(prpLscheduleItemDtoList);
        
		return registDto;
	}
	
	
	/**
	 * 出错后放号回归函数
	 * @param registNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean putNoback(String registNo) throws SQLException, Exception {
		UIBillAction uiBillAction = new UIBillAction();
		String tableName = "prplregist";
		if (uiBillAction.putNo(tableName, registNo)) {
			System.out.println("单号放回成功" + registNo);
		} else {
			System.out.println("单号放回失败" + registNo);
		}
		return true;
	}
	
}
