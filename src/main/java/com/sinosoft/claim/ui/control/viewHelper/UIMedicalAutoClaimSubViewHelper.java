package com.sinosoft.claim.ui.control.viewHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.gyic.claim.bl.facade.BLSettlemainlistFacadeForMedical;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.sinosoft.claim.bl.facade.BLDangerUnitFacade;
import com.sinosoft.claim.bl.facade.BLPrpDuserFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterAutoClaimDetailFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.NewDangerUnitDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpCinsuredDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLinterAccdentPersonDto;
import com.sinosoft.claim.dto.domain.PrpLinterClaimAppDto;
import com.sinosoft.claim.dto.domain.PrpLinterClaimKindDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPrpLregistRPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIReinsTrialAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.prpall.dbsvr.pg.DBPrpPhead;
import com.sinosoft.reins.out.bl.facade.BLPrpLdangerUnitFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpLreinsTrialFacade;
import com.sinosoft.reins.out.bl.facade.BLRepayFacade;
import com.sinosoft.reins.out.dto.domain.PrpLdangerItemDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerTotDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerUnitDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.utility.string.Str;
/**
 * 大病医疗接口自动立案子类，此类作出如下操作
 * 1.	生成立案号码，组织立案主表数据。
 * 2.	根据中间表数据组织立案相关业务数据。
 * 3.	根据中间表数据组织危险单位对象
 * 4.	处理立案工作流
 * 5.	完成对立案业务数据及工作流数据的存储
 * 6.	更新流程状态表立案环节状态
 * 
 * @author Administrator
 *
 */
public class UIMedicalAutoClaimSubViewHelper {
	/**
	 * 大病医疗接口自动立案子类主流程方法，处理自动立案的业务数据和工作流数据
	 * @param prpLinterRequestDto 传入参数为中间表大对象
	 * @return 处理过的中间表大对象
	 * @throws Exception
	 */
	public PrpLinterRequestDto autoClaim (PrpLinterRequestDto prpLinterRequestDto) throws Exception{
		String operatorComCode = prpLinterRequestDto.getMakeCom();
		String operatorComCName = prpLinterRequestDto.getMakeComName();
		String registNo = prpLinterRequestDto.getRelationRegistNo();
		String policyNo = prpLinterRequestDto.getPolicyno();
		String claimNo = "";
		String damageDate = new DateTime(prpLinterRequestDto.getDamageStartDate(),DateTime.YEAR_TO_DAY).toString();
		String damageHoure = prpLinterRequestDto.getDamageStartHour();
		BLPrplinterAutoClaimDetailFacade blPrplinterAutoClaimDetailFacade = new BLPrplinterAutoClaimDetailFacade();
		//组织UserDto对象
		UserDto user  = new UserDto();
		String compeUser = prpLinterRequestDto.getCompeUser();
		BLPrpDuserFacade blPrpDuserFacade = new BLPrpDuserFacade();
		PrpDuserDto prpDuserDto = blPrpDuserFacade.findByPrimaryKey(compeUser);
		String compeName = "";
		if(prpDuserDto!=null){
			compeName = prpDuserDto.getUserName();
		}
		String operatorCode  =  compeUser;
		String operatorName  =  compeName;
		user.setUserCode(compeUser);
		user.setUserName(compeName);
		user.setComCode(operatorComCode);
		user.setComName(operatorComCName);
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PrplinterAutoClaimDetailDto  prplinterAutoClaimDetailDto = prpLinterRequestDto.getPrplinterAutoClaimDetailDto();
		try{
			SwfLogDto swfLogDtoDealNode = new SwfLogDto();
			String conditions = " registno='"+registNo+"' and nodeType='claim' and nodeStatus='0' ";
			ArrayList<SwfLogDto> swflogList  = (ArrayList<SwfLogDto>) new UIWorkFlowAction().findNodesByConditions(conditions);
			//判断是否有未处理的立案节点需要处理，如果没有立案节点需处理直接抛出异常
			if(swflogList!=null&&!swflogList.isEmpty()&&swflogList.size()>0){
				swfLogDtoDealNode = swflogList.get(0);
			}else {
				throw new Exception("未查询出待处理的立案工作流");
			}
			String flowId = swfLogDtoDealNode.getFlowID();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,damageDate,damageHoure);
			if(policyDto==null||policyDto.getPrpCmainDto()==null){
				throw new Exception("未查询出相关承保信息，请确认出入参数的保单号码是否合法!");
			}
			int year = DateTime.current().getYear();
			if (claimNo.length() < 1 || claimNo == null) {
				//取号过程还需要进一步完善
				UIBillAction uiBillAction = new UIBillAction();
				String tableName = "prplclaim";
				claimNo = uiBillAction.getNo(tableName, policyDto.getPrpCmainDto().getRiskCode(), policyDto.getPrpCmainDto().getComCode(), year);
			}
			//子方法用于封装业务数据对象
			ClaimDto claimDto = null;
			claimDto = this.viewToDto(prpLinterRequestDto, policyDto,  claimNo,flowId);
			UIRegistAction uiRegistAction = new UIRegistAction();
			RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
			String businessType = registDto.getPrpLregistDto().getBusinessType();
			String businessType1 = registDto.getPrpLregistDto().getBusinessType1();
			String businessFlag = registDto.getPrpLregistDto().getBusinessFlag();
			String otherFlag	= registDto.getPrpLregistDto().getOtherFlag();
			claimDto.getPrpLclaimDto().setBusinessType(businessType);
			claimDto.getPrpLclaimDto().setBusinessType1(businessType1);
			claimDto.getPrpLclaimDto().setBusinessFlag(businessFlag);
			claimDto.getPrpLclaimDto().setOtherFlag(otherFlag);
			
			// 1requst对象,2本节点的节点类型,3本节点需要更新的状态,4本节点的业务号码,5以后节点的业务号码,6本节点的业务流入号码,7以后节点的业务流出号码
			WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			swfLogDtoDealNode.setNodeType("claim");
			swfLogDtoDealNode.setNodeStatus(claimDto.getPrpLclaimStatusDto().getStatus());
			swfLogDtoDealNode.setBusinessNo(registNo);
			swfLogDtoDealNode.setNextBusinessNo(claimNo);
			//考虑 到后来几乎都是用clamno做keyin的数值的。。
			swfLogDtoDealNode.setKeyIn(claimNo);
			swfLogDtoDealNode.setKeyOut(claimNo);
			
			//PrplinterAutoClaimDetailDto  prplinterAutoClaimDetailDto  = blPrplinterAutoClaimDetailFacade.findByPrimaryKey(prpLinterRequestDto.getId(), registNo);
			prplinterAutoClaimDetailDto.setClaimSuccFlag("1");
			prplinterAutoClaimDetailDto.setRemark("立案成功："+claimNo);
			blPrplinterAutoClaimDetailFacade.update(prplinterAutoClaimDetailDto);
			
			WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDtoDealNode);
			/*********************************add 大病系统标志medicaltransitflag************************************/
			Collection submitSwfLogDtoList = workFlowDto.getSubmitSwfLogDtoList();
			Iterator iterSwf = submitSwfLogDtoList.iterator();
			ArrayList submitListTemp = new ArrayList();
			while(iterSwf.hasNext()){
				SwfLogDto swfLogDto = (SwfLogDto)iterSwf.next();
				swfLogDto.setMedicalTransitFlag("1");
				submitListTemp.add(swfLogDto);
			}
			workFlowDto.setSubmitSwfLogDtoList(submitListTemp);
			SwfLogDto updateSwfLogDto = workFlowDto.getUpdateSwfLogDto();
			updateSwfLogDto.setMedicalTransitFlag("1");
			workFlowDto.setUpdateSwfLogDto(updateSwfLogDto);
			/*****************************************************************************/
			//保存立案信息
			UIClaimAction uiClaimAction = new UIClaimAction();
			
			String sqlClaim = " Update swflog Set  submittime='"+prpLinterRequestDto.getCompeTime()
	                                           +"' Where registno ='"+registNo+"' and nodeType ='claim'";
            String sqlCerti = " Update swflog Set Flowintime='"+prpLinterRequestDto.getCompeTime()
									            +"',handletime='"+prpLinterRequestDto.getCompeTime()
									            +"' Where registno ='"+registNo+"' and nodeType ='certi'";

			if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate())
					|| (workFlowDto.getSubmit())
					|| (workFlowDto.getClose())) {
				uiClaimAction.save(claimDto, workFlowDto);
			} else {
				throw new Exception(claimNo + ";注意:没有发现与工作流流程相关任何数据！！");
			}
			
			new BLPrplinterAutoClaimDetailFacade().updateBySQL(sqlClaim);
			new BLPrplinterAutoClaimDetailFacade().updateBySQL(sqlCerti);
			
			
			try {
				//生成分赔案
				Collection dangerTrial = new BLPrpLreinsTrialFacade().findByConditions("certiNo = '" + claimNo + "'");
				//如果没有分摊试算，首先进行分摊试算
				if (dangerTrial == null || dangerTrial.size() == 0) {
					new UIReinsTrialAction().simulateRepayByDangerNo(claimNo,claimNo);
				}
				Collection dangerUnit = new BLPrpLdangerUnitFacade().findByConditions("certiNo = '" + claimNo + "'");
				if (dangerUnit != null) {
					Iterator iter = dangerUnit.iterator();
					while (iter.hasNext()) {
						PrpLdangerUnitDto prpLdangerUnitDto = (PrpLdangerUnitDto) iter.next();
						String newRepayNo = new BLRepayFacade().genRepay(claimNo, 
								prpLdangerUnitDto.getDangerNo(), policyDto.getPrpCmainDto().getComCode(), operatorCode,
								prpLdangerUnitDto.getClaimADDTimes());
						if (!newRepayNo.equals("")) {
							new BLRepayFacade().checkRepay(newRepayNo, operatorCode);
						}
					}
				} //生成分赔案
			} catch (Exception e) {
				System.out.println("自动立案拆分危险单位报错：");
				e.printStackTrace();
			}
		}catch(UserException ue){
			ue.printStackTrace();
			//PrplinterAutoClaimDetailDto  prplinterAutoClaimDetailDto  = blPrplinterAutoClaimDetailFacade.findByPrimaryKey(prpLinterRequestDto.getId(), registNo);
			prplinterAutoClaimDetailDto.setClaimSuccFlag("0");
			String messege = ue.toString();
			if(messege!=null&&messege.length()>1000){
				messege = messege.substring(0,1000);
			}
			prplinterAutoClaimDetailDto.setRemark("立案失败："+messege);
			blPrplinterAutoClaimDetailFacade.update(prplinterAutoClaimDetailDto);
			putNoback(claimNo);
			throw ue;
		}catch(Exception e){
			e.printStackTrace();
			//PrplinterAutoClaimDetailDto  prplinterAutoClaimDetailDto  = blPrplinterAutoClaimDetailFacade.findByPrimaryKey(prpLinterRequestDto.getId(), registNo);
			prplinterAutoClaimDetailDto.setClaimSuccFlag("0");
			String messege = e.toString();
			if(messege!=null&&messege.length()>1000){
				messege = messege.substring(0,1000);
			}
			prplinterAutoClaimDetailDto.setRemark("立案失败："+messege);;
			blPrplinterAutoClaimDetailFacade.update(prplinterAutoClaimDetailDto);
			putNoback(claimNo);
			throw e;
		}
		return prpLinterRequestDto;
	}
	/**
	 * 根据传入的对象及生成的立案号码组织生成立案相关的业务对象
	 * @param prpLinterRequestDto
	 * @param policyDto
	 * @param user
	 * @param claimNo
	 * @return
	 * @throws Exception
	 */
	public ClaimDto viewToDto(PrpLinterRequestDto prpLinterRequestDto,PolicyDto policyDto,String claimNo,String flowId) throws Exception{
		ClaimDto claimDto = new ClaimDto();
		String policyNo = prpLinterRequestDto.getPolicyno();
		PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
		prpLclaimDto.setClaimNo(claimNo);
        prpLclaimDto.setLFlag("L");
        prpLclaimDto.setClassCode(policyDto.getPrpCmainDto().getClassCode());
        prpLclaimDto.setRiskCode(policyDto.getPrpCmainDto().getRiskCode());
        prpLclaimDto.setBusinessNature(policyDto.getPrpCmainDto().getBusinessNature());
        prpLclaimDto.setLanguage(policyDto.getPrpCmainDto().getLanguage());
        prpLclaimDto.setPolicyType(policyDto.getPrpCmainDto().getPolicyType());
        prpLclaimDto.setInsuredCode(policyDto.getPrpCmainDto().getInsuredCode());
        prpLclaimDto.setInsuredName(policyDto.getPrpCmainDto().getInsuredName());
        prpLclaimDto.setRegistNo(prpLinterRequestDto.getRelationRegistNo());
        prpLclaimDto.setPolicyNo(prpLinterRequestDto.getPolicyno());
        prpLclaimDto.setStartDate(new DateTime(policyDto.getPrpCmainDto().getStartDate(),DateTime.YEAR_TO_DAY));
        prpLclaimDto.setStartHour(policyDto.getPrpCmainDto().getStartHour());
        prpLclaimDto.setEndHour(policyDto.getPrpCmainDto().getEndHour());
        prpLclaimDto.setEndDate(new DateTime(policyDto.getPrpCmainDto().getEndDate(), DateTime.YEAR_TO_DAY));
        prpLclaimDto.setCurrency(policyDto.getPrpCmainDto().getCurrency());
        prpLclaimDto.setSumAmount(policyDto.getPrpCmainDto().getSumAmount());
        prpLclaimDto.setSumPremium(policyDto.getPrpCmainDto().getSumPremium());
        prpLclaimDto.setSumQuantity(policyDto.getPrpCmainDto().getSumQuantity());
        prpLclaimDto.setDamageStartHour(prpLinterRequestDto.getDamageStartHour()+"");
        prpLclaimDto.setDamageStartDate(new DateTime(prpLinterRequestDto.getDamageStartDate(), DateTime.YEAR_TO_DAY));
        prpLclaimDto.setDamageEndDate(new DateTime(prpLinterRequestDto.getDamageStartDate(), DateTime.YEAR_TO_DAY));
        prpLclaimDto.setDamageEndHour(prpLinterRequestDto.getDamageStartHour() + "");
        prpLclaimDto.setDamageCode(prpLinterRequestDto.getDamageCode());
        String damageName  = new UICodeAction().translateCodeCode("DamageCode", prpLinterRequestDto.getDamageCode(), true);
        prpLclaimDto.setDamageName(damageName);
        prpLclaimDto.setDamageTypeCode(prpLinterRequestDto.getDamageTypeCode());
        prpLclaimDto.setDamageTypeName(prpLinterRequestDto.getDamageTypeName());
        prpLclaimDto.setDamageAddress(prpLinterRequestDto.getDamageAddress());
        prpLclaimDto.setLossQuantity(0);
        prpLclaimDto.setClaimDate(new DateTime(prpLinterRequestDto.getCompeTime(),DateTime.YEAR_TO_DAY));
        prpLclaimDto.setClaimTime(new DateTime(prpLinterRequestDto.getCompeTime(),DateTime.YEAR_TO_SECOND));
        prpLclaimDto.setSumClaim(prpLinterRequestDto.getSumClaim());
        //此数据在结案时回写
        //prpLclaimDto.setSumPaid(prpLinterRequestDto.getSumClaim());
        
        prpLclaimDto.setMakeCom(prpLinterRequestDto.getMakeCom());
        prpLclaimDto.setComCode(policyDto.getPrpCmainDto().getComCode());
        prpLclaimDto.setHandlerCode(prpLinterRequestDto.getCompeUser());
        prpLclaimDto.setHandler1Code(policyDto.getPrpCmainDto().getHandler1Code());
        prpLclaimDto.setOperatorCode(prpLinterRequestDto.getCompeUser());
        prpLclaimDto.setInputDate(new DateTime(prpLinterRequestDto.getCompeTime(),DateTime.YEAR_TO_DAY));
        prpLclaimDto.setLossesNumber(prpLinterRequestDto.getLossesNumber());
        prpLclaimDto.setClaimType("0");
        prpLclaimDto.setReplevyFlag("0");
        prpLclaimDto.setThirdComFlag("0");
        if("2606".equals(prpLclaimDto.getRiskCode())){
            prpLclaimDto.setMedicalType("99");
        }
        //prpLclaimDto.setDamageKind();出险险别
        //prpLclaimDto.setMedicalType();//治疗方式
        
        //prpLclaimDto.setIndemnityDuty(0);
        //prpLclaimDto.setIndemnityDutyRate(Double.parseDouble(DataUtils.nullToZero("0.00")));
        //prpLclaimDto.setDeductibleRate(Double.parseDouble(DataUtils.nullToZero("0.00")));
        //prpLclaimDto.setSumDefLoss(Double.parseDouble(DataUtils.nullToZero("0.00")));
        //prpLclaimDto.setSumReplevy(Double.parseDouble(DataUtils.nullToZero("0.00")));
        claimDto.setPrpLclaimDto(prpLclaimDto);
        
        UIPolicyAction uiPolicyAction = new UIPolicyAction();
        String conditions = " policyno='"+prpLinterRequestDto.getPolicyno()+"'  ";
    	Collection collection = new ArrayList();
    	collection = uiPolicyAction.findPrpCinsuredDtoByConditions(conditions);
    	int familyNo = 1;
    	for(Iterator iterator = collection.iterator();iterator.hasNext();){
        	  PrpCinsuredDto prpCinsuredDto = (PrpCinsuredDto) iterator.next();
        	  if(prpCinsuredDto.getInsuredFlag().equals("1") ) {
        		  familyNo = prpCinsuredDto.getSerialNo();
        	  }
        }
        
        //事故者信息模块 begin
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
        claimDto.setPrplacciBenPersonDtoList(prpLacciBenPersonList);
        
        //立案文本表prpLltext
        ArrayList prpLltextDtoList = null;
        String context = prpLinterRequestDto.getContext();
        if(context!=null&&context.length()>0){
        	String[] rules = StringUtils.split(context, 70);
        	prpLltextDtoList = new ArrayList();
            //得到连接串,下面将其切分到数组
            for (int k = 0; k < rules.length; k++) {
                PrpLltextDto prpLltextDto = new PrpLltextDto();
                prpLltextDto.setClaimNo(claimNo);
                prpLltextDto.setContext(rules[k]);
                prpLltextDto.setLineNo(k + 1);
                prpLltextDto.setTextType("09");
                prpLltextDtoList.add(prpLltextDto);
            }
        }
        claimDto.setPrpLltextDtoList(prpLltextDtoList);
        
        //立案操作状态内容prpLclaimStatus
        PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
        prpLclaimStatusDto.setStatus("4");
        prpLclaimStatusDto.setBusinessNo(prpLclaimDto.getClaimNo());
        prpLclaimStatusDto.setPolicyNo(prpLclaimDto.getPolicyNo());
        prpLclaimStatusDto.setNodeType("claim");
        prpLclaimStatusDto.setSerialNo(0);
        prpLclaimStatusDto.setRiskCode(prpLclaimDto.getRiskCode());
        prpLclaimStatusDto.setHandlerCode(prpLclaimDto.getHandlerCode());
        prpLclaimStatusDto.setInputDate(new DateTime(prpLinterRequestDto.getCompeTime(), DateTime.YEAR_TO_DAY));
        prpLclaimStatusDto.setOperateDate(new DateTime(prpLinterRequestDto.getCompeTime(), DateTime.YEAR_TO_DAY));
        claimDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
        
        //保单关联表prpLRegistRPolicy
        UIPrpLregistRPolicyAction  uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction(); 
        PrpLRegistRPolicyDto  prpLRegistRPolicyDto = 
        		uiPrpLregistRPolicyAction.findByPrimaryKey(prpLinterRequestDto.getRelationRegistNo(), prpLinterRequestDto.getPolicyno());
        if ( prpLRegistRPolicyDto!=null ){
        	prpLRegistRPolicyDto.setRegistNo(prpLRegistRPolicyDto.getRegistNo());
        	prpLRegistRPolicyDto.setPolicyNo(prpLRegistRPolicyDto.getPolicyNo());
        	prpLRegistRPolicyDto.setClaimNo(claimNo);
        	prpLRegistRPolicyDto.setFlowId(flowId);
        	prpLRegistRPolicyDto.setPolicyType(prpLRegistRPolicyDto.getPolicyType());
        	prpLRegistRPolicyDto.setRegistFlag(prpLRegistRPolicyDto.getRegistFlag());
        	prpLRegistRPolicyDto.setValidStatus(prpLRegistRPolicyDto.getValidStatus());
        	prpLRegistRPolicyDto.setFlag(prpLRegistRPolicyDto.getFlag());
        	prpLRegistRPolicyDto.setRemark(prpLRegistRPolicyDto.getRemark());
        }
        claimDto.setPrpLRegistRPolicyDto(prpLRegistRPolicyDto);
        
        //险别估损金额PrpLclaimloss
        ArrayList claimLossList = new ArrayList();
        PrpLinterClaimKindDto[] prplinterClaimKindDtos =  prpLinterRequestDto.getPrpLinterClaimKindDto();
        PrpLclaimLossDto prpLclaimLossDto = null;
        if(prplinterClaimKindDtos!=null&&prplinterClaimKindDtos.length>0){
        	for(int i=0;i<prplinterClaimKindDtos.length;i++){
        		PrpLinterClaimKindDto prpLinterClaimKindDto = prplinterClaimKindDtos[i];
        		prpLclaimLossDto = new PrpLclaimLossDto();
                prpLclaimLossDto.setClaimNo(claimNo);
                prpLclaimLossDto.setRiskCode(prpLclaimDto.getRiskCode());
                prpLclaimLossDto.setSerialNo(i+1);
                prpLclaimLossDto.setItemKindNo(prpLinterClaimKindDto.getItemKindNo());
                prpLclaimLossDto.setKindCode(prpLinterClaimKindDto.getKindCode());
                prpLclaimLossDto.setKindRest(prpLinterClaimKindDto.getKindRest());
                prpLclaimLossDto.setCurrency(prpLinterClaimKindDto.getCurrency());
                prpLclaimLossDto.setSumClaim(prpLinterClaimKindDto.getSumClaim());
                prpLclaimLossDto.setKindLoss(prpLinterClaimKindDto.getSumClaim());
                prpLclaimLossDto.setInputDate(new DateTime(prpLinterRequestDto.getCompeTime(),DateTime.YEAR_TO_DAY));
              	prpLclaimLossDto.setFamilyName(prpLinterClaimKindDto.getFamilyName());
              	prpLclaimLossDto.setFamilyNo(familyNo);
                prpLclaimLossDto.setLossFeeType(prpLinterClaimKindDto.getLossFeeType());
                claimLossList.add(prpLclaimLossDto);
        	}
        }
        claimDto.setPrpLclaimLossDtoList(claimLossList);
        
        //索赔申请人信息
        ArrayList prpLacciPersonList = new ArrayList();
        PrpLacciPersonDto prpLacciPersonProposerDto = null;
        PrpLinterClaimAppDto[] prpLinterClaimAppDtos = prpLinterRequestDto.getPrpLinterClaimAppDto();
        if(prpLinterClaimAppDtos!=null&&prpLinterClaimAppDtos.length>0){
        	for(int i=0;i<prpLinterClaimAppDtos.length;i++){
        		PrpLinterClaimAppDto prpLinterClaimAppDto = prpLinterClaimAppDtos[i];
        		prpLacciPersonProposerDto = new PrpLacciPersonDto();
                prpLacciPersonProposerDto.setAcciName(prpLinterClaimAppDto.getAcciName());
                prpLacciPersonProposerDto.setCertiNo(claimNo);
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
        
        //危险单位信息 
        ArrayList  dangerUnitList = new ArrayList();
        ArrayList  dangerItemList = new ArrayList();
        ArrayList  dangerTotList = new ArrayList();
        List prpdangerUnitList = new ArrayList();
        Map kindMap = new HashMap();
        BLDangerUnitFacade blDangerFacade=new BLDangerUnitFacade();
        DBPrpPhead dbPrpPhead = new DBPrpPhead();
        String registNo = prpLinterRequestDto.getRelationRegistNo();
        //如果在出险时间之前存在批改，则取pdangunit表的数据，否则取cdangunit表的数据
        String wherepart=" policyno='"+policyNo+"' and validdate <= date '"+prpLinterRequestDto.getDamageStartDate()+"' and underwriteflag in ('1','3') ";
        int count=dbPrpPhead.getCount(wherepart);
        
        //根据标的序号查询数据库危险单位信息
        if(claimLossList!=null&&claimLossList.size()>0){
        	for(int i = 0; i< claimLossList.size();i++){
        		PrpLclaimLossDto prpLclaimLossDtoTemp = (PrpLclaimLossDto) claimLossList.get(i);
        		String itemKindNo = prpLclaimLossDtoTemp.getItemKindNo()+"";
        		double sumLoss  = prpLclaimLossDtoTemp.getSumClaim();
        		if(kindMap.containsKey(itemKindNo)){
        			String tempSumLoss=String.valueOf((sumLoss+Double.parseDouble("" + kindMap.get(itemKindNo))));
        			kindMap.put(itemKindNo, tempSumLoss);
        		}else{
        			if(count==0){
        				List prpdangerUnitTempList=blDangerFacade.getPrpCdangerUnit(policyNo,itemKindNo);
        				prpdangerUnitList.addAll(prpdangerUnitTempList);
        			}else{
        				List prpdangerUnitTempList=blDangerFacade.getPrpPdangerUnit(registNo, policyNo, itemKindNo);
        				prpdangerUnitList.addAll(prpdangerUnitTempList);
        			}
        			kindMap.put(itemKindNo, sumLoss);
        		}
        	}
        }
        //危险单位估损金额按照标的序号最后一位减法原则处理
		double dbSumLoss = 0D;
        double dbshare = 0D;
        double tempSumLoss=0D;
        //判断标的序号是否是此危险单位的最后一个
        boolean flag = false;
        NewDangerUnitDto  newDangerUnitDto=null;
  	  	NewDangerUnitDto  newDangerUnitDtoTemp=null;
        for(int i=0;i<prpdangerUnitList.size();i++){
      		newDangerUnitDto= (NewDangerUnitDto)prpdangerUnitList.get(i);
        	dbSumLoss = Double.parseDouble(Str.chgStrZero("" + kindMap.get(newDangerUnitDto.getItemkindno())));
            dbshare = Double.parseDouble(Str.chgStrZero(newDangerUnitDto.getDangerkindshare()));
        	flag = false;
            for(int j=i+1;j<prpdangerUnitList.size();j++){
          		newDangerUnitDtoTemp= (NewDangerUnitDto)prpdangerUnitList.get(j);
                if (newDangerUnitDtoTemp.getItemkindno().equals(newDangerUnitDto.getItemkindno())) {
					flag = true;
				 	break;
				}
            }
            if(flag){
            	dbSumLoss = Str.round((dbSumLoss * (dbshare/100)),2); 
            	newDangerUnitDto.setDangerkindAmount(""+dbSumLoss);
            }else{
        		tempSumLoss = 0;
        		for(int k=0;k<i;k++){
        			newDangerUnitDtoTemp= (NewDangerUnitDto)prpdangerUnitList.get(k);
        			if(newDangerUnitDtoTemp.getItemkindno().equals(newDangerUnitDto.getItemkindno())){
       					tempSumLoss+=Double.parseDouble(Str.chgStrZero(newDangerUnitDtoTemp.getDangerkindAmount())); 
        			} 
            	}
        		newDangerUnitDto.setDangerkindAmount(""+Str.round((dbSumLoss-tempSumLoss),2));
            }
        }
        
        //根据投保时的危险单位信息生成立案危险单位
        double temp=0;
        double sumDangerUnit=0d;
        NewDangerUnitDto  newDangerUnitDto2=null;
        if(prpdangerUnitList!=null&&!prpdangerUnitList.isEmpty()){
        	for(int i=0;i<prpdangerUnitList.size();i++){
        		PrpLdangerItemDto prpLdangerItemDto=null;
        		newDangerUnitDto2= (NewDangerUnitDto)prpdangerUnitList.get(i);
        		if(Double.parseDouble(newDangerUnitDto2.getDangerkindAmount())!=0&&Double.parseDouble(newDangerUnitDto2.getDangerkindshare())!=0){
        			prpLdangerItemDto= new PrpLdangerItemDto();       
    				prpLdangerItemDto.setCertiNo(claimNo); // 立案号
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
        }
           
        claimDto.setPrpLdangerItemDtoList(dangerItemList);
        
      //2、生成此危险单位标金额合计PrpLdangerTot（汇总prpLdangerItem）
        
        Iterator     iterator   = null;
        PrpLdangerTotDto prpLdangerTotDto   = null; 
        Iterator      itTot  = null;
		PrpLdangerItemDto prpLdangerItemDto = null;       //标的DTO
        boolean find = true;
        if (dangerItemList  != null){
        	iterator = dangerItemList.iterator();
        	while(iterator.hasNext()){
        		prpLdangerItemDto = (PrpLdangerItemDto)iterator.next();
        		find = false;
        		itTot = dangerTotList.iterator();
        		while(itTot.hasNext())
        		{
        			prpLdangerTotDto = (PrpLdangerTotDto)itTot.next();
        			if (prpLdangerTotDto.getDangerNo() == prpLdangerItemDto.getDangerNo())
        			{
        				find = true;
        				prpLdangerTotDto.setSumPaid(Str.round(prpLdangerTotDto.getSumPaid()+prpLdangerItemDto.getSumPaid(),2));
        				prpLdangerTotDto.setSumPaidEx(Str.round(prpLdangerTotDto.getSumPaidEx()+prpLdangerItemDto.getSumPaid(),2));
        				break;
        			}
        		}
        		//每个危险单位标的的第一次数据的生成
        		if (find == false)
        		{
        			prpLdangerTotDto = new PrpLdangerTotDto();
                    
                     prpLdangerTotDto.setCertiNo(claimNo);
    		  		 prpLdangerTotDto.setDangerNo(prpLdangerItemDto.getDangerNo());                        
    		  		 prpLdangerTotDto.setSCurrency(prpLdangerItemDto.getCurrency());   //标的原币别
    		  		 prpLdangerTotDto.setSumFee(0);
    		  		 prpLdangerTotDto.setSumPaid(prpLdangerItemDto.getSumPaid());
    		  		 prpLdangerTotDto.setTCurrency(prpLdangerItemDto.getCurrency());
    		  		 prpLdangerTotDto.setExchRate(1);
    		  		 prpLdangerTotDto.setSumFeeEx(0);
    		  		 prpLdangerTotDto.setSumPaidEx(prpLdangerItemDto.getSumPaid());
    		  	 	 //加入集合
                	 if(prpLdangerTotDto!=null){
                		dangerTotList.add(prpLdangerTotDto);
                	 }
            		
        		}
          
        	}

        	  if(dangerTotList.size()>0){
                	claimDto.setPrpLdangerTotDtoList(dangerTotList);
              }
        }
        
        //3、生成危险单位prpLdangerUnit
       
        Iterator      itUnit  = null;
        PrpLdangerUnitDto prpLdangerUnitDto=null;
        if (dangerItemList != null){
        	iterator = dangerItemList.iterator();
        	while(iterator.hasNext()){
        		prpLdangerItemDto = (PrpLdangerItemDto)iterator.next();
        		find = false;
        		itUnit = dangerUnitList.iterator();
        		while(itUnit.hasNext())
        		{
        			prpLdangerUnitDto = (PrpLdangerUnitDto)itUnit.next();
        			if (prpLdangerUnitDto.getDangerNo() == prpLdangerItemDto.getDangerNo())
        			{
        				find = true;
        				prpLdangerUnitDto.setSumLoss(Str.round(prpLdangerUnitDto.getSumLoss()+prpLdangerItemDto.getSumPaid(),2));
        				prpLdangerUnitDto.setSumNoPaid(Str.round(prpLdangerUnitDto.getSumLoss(),2));
        				break;
        			}
        		}
        		//每个危险单位标的的第一次数据的生成
        		if (find == false)
        		{
        			 prpLdangerUnitDto = new PrpLdangerUnitDto();
               	     prpLdangerUnitDto.setCertiNo(claimNo);
                	 prpLdangerUnitDto.setClaimNo(claimNo);
                	 prpLdangerUnitDto.setCertiType("1");
                	 prpLdangerUnitDto.setRiskCode(prpLdangerItemDto.getRiskCode());
                	 prpLdangerUnitDto.setPolicyNo(prpLdangerItemDto.getPolicyno());
                	 prpLdangerUnitDto.setDangerNo(prpLdangerItemDto.getDangerNo());
                	 prpLdangerUnitDto.setDangerDesc(prpLdangerItemDto.getDangerdesc());
                	 prpLdangerUnitDto.setAddressName(prpLdangerItemDto.getAddressName());
                	 prpLdangerUnitDto.setCurrency(prpLdangerItemDto.getCurrency());
        		     prpLdangerUnitDto.setSumLoss(prpLdangerItemDto.getSumPaid());
        		     prpLdangerUnitDto.setSumPaid(0);
                     prpLdangerUnitDto.setSumNoPaid(prpLdangerItemDto.getSumPaid());
                     prpLdangerUnitDto.setSumFee(0);
              	     prpLdangerUnitDto.setCoinsFlag(policyDto.getPrpCmainDto().getCoinsFlag());
              	     prpLdangerUnitDto.setDamageDate(claimDto.getPrpLclaimDto().getDamageStartDate());
              	     prpLdangerUnitDto.setClaimDate(claimDto.getPrpLclaimDto().getClaimDate());
              	   //  prpLdangerUnitDto.setAgricultureflag(prpCmainDto.getBusinessType1());
              	    //加入集合
                	 if(prpLdangerUnitDto!=null){
                		dangerUnitList.add(prpLdangerUnitDto);
                	 }
        		}
        	}
        	//最后一个占比减法原则
        	double dangerShare = 0;
        	double tempSumDangerShare = 0;
        	PrpLdangerUnitDto prpLdangerUnitDtotemp =null;
        	for (int i=0;i<dangerUnitList.size();i++){
        		prpLdangerUnitDtotemp=(PrpLdangerUnitDto)dangerUnitList.get(i);
        		if(i==(dangerUnitList.size()-1))
        		{
        			dangerShare = Str.round(100-tempSumDangerShare,2);
        		}else
        		{
        			dangerShare = Str.round(prpLdangerUnitDtotemp.getSumLoss()/sumDangerUnit*100,2);
        			tempSumDangerShare = Str.round(tempSumDangerShare+dangerShare, 2);
        		}
        		prpLdangerUnitDtotemp.setDangerShare(dangerShare);
	       	 }
	        	
	        	 if(dangerUnitList.size()>0){
	             	claimDto.setPrplRiskUnitDtoList(dangerUnitList);
	           }
	        }
        
        
		return claimDto;
	}
	/**
	 * 将取出的单号放回
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	private boolean putNoback(String claimNo) throws SQLException, Exception {
		UIBillAction uiBillAction = new UIBillAction();
		String tableName = "prplclaim";
		if (uiBillAction.putNo(tableName, claimNo)) {
			System.out.println("单号放回成功" + claimNo);
		} else {
			System.out.println("单号放回失败" + claimNo);
		}
		return true;
	}
}
