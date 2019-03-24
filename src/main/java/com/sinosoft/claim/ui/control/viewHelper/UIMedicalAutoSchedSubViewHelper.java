package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.facade.BLPrpDuserFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterAutoClaimDetailFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterSchedExtDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * 自动调度类
 */
public class UIMedicalAutoSchedSubViewHelper {
	/**
	 * 自动调度逻辑
	 * @param prpLinterRequestDto
	 * @return
	 * @throws Exception
	 */
	public PrpLinterRequestDto autoSched (PrpLinterRequestDto prpLinterRequestDto) throws Exception{
		ScheduleDto scheduleDto = new ScheduleDto();
		PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = 
			prpLinterRequestDto.getPrplinterAutoClaimDetailDto();
		// 查询保单信息
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
				prpLinterRequestDto.getPolicyno(),
				prpLinterRequestDto.getDamageStartDate().toString(), 
				prpLinterRequestDto.getDamageStartHour());
		String riskCode = policyDto.getPrpCmainDto().getRiskCode();
		//组装user对象，方便后续使用
		UserDto user = new UserDto();
		String compeUser = prpLinterRequestDto.getCompeUser();
		BLPrpDuserFacade blPrpDuserFacade = new BLPrpDuserFacade();
		PrpDuserDto prpDuserDto = blPrpDuserFacade.findByPrimaryKey(compeUser);
		String compeName = "";
		if(prpDuserDto!=null){
			compeName = prpDuserDto.getUserName();
		}
		user.setUserCode(compeUser);
		user.setUserName(compeName);
		user.setComCode(prpLinterRequestDto.getMakeCom());
		user.setComName(prpLinterRequestDto.getMakeComName());
		try{
			UIScheduleAction uiScheduleAction = new UIScheduleAction();
			ScheduleDto scheduleDtoTemp = uiScheduleAction.findByPrimaryKey(1,prpLinterRequestDto.getRelationRegistNo());
			PrpLscheduleMainWFDto prpLscheduleMainWFDto = null;
			if (scheduleDtoTemp.getPrpLscheduleMainWFDto()!=null&& scheduleDtoTemp.getPrpLscheduleMainWFDto().getScheduleFlag().equals( "1")){
		      	prpLscheduleMainWFDto=scheduleDtoTemp.getPrpLscheduleMainWFDto();
		    }else{
		    	prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();
		    	prpLscheduleMainWFDto.setScheduleID(1);
		    	prpLscheduleMainWFDto.setSurveyNo(1);
		    	prpLscheduleMainWFDto.setRegistNo(prpLinterRequestDto.getRelationRegistNo());
		    	prpLscheduleMainWFDto.setScheduleFlag("1");
		    	prpLscheduleMainWFDto.setScheduleObjectID(prpLinterRequestDto.getMakeCom());
		    	prpLscheduleMainWFDto.setScheduleObjectName(prpLinterRequestDto.getMakeComName());
		    	prpLscheduleMainWFDto.setCheckFlag("4");
		    	prpLscheduleMainWFDto.setCheckSite(prpLinterRequestDto.getCheckSite());
		    	prpLscheduleMainWFDto.setNextHandlerCode(prpLinterRequestDto.getNextHandlerCode());
		    	prpLscheduleMainWFDto.setNextHandlerName(prpLinterRequestDto.getNextHandlerName());
		    	prpLscheduleMainWFDto.setClaimComCode(prpLinterRequestDto.getMakeCom());
		    	prpLscheduleMainWFDto.setRiskCode(riskCode);
		    	prpLscheduleMainWFDto.setPolicyNo(prpLinterRequestDto.getPolicyno());
		    	prpLscheduleMainWFDto.setOperatorCode(compeUser);
		    	prpLscheduleMainWFDto.setInputDate(new DateTime(prpLinterRequestDto.getCompeTime(),DateTime.YEAR_TO_DAY));
		    	prpLscheduleMainWFDto.setInputHour(DateTime.current().getHour());
		    	prpLscheduleMainWFDto.setCheckOperatorCode(compeUser);
		    	prpLscheduleMainWFDto.setScheduleArea(0);
//		    	prpLscheduleMainWFDto.setFlag(flag);
//		        prpLscheduleMainWFDto.setSaveType(prpLscheduleMainWFSaveType);
//		        prpLscheduleMainWFDto.setCommiFlag(prpLscheduleMainWFDtoCommiFlag);//案件双代标志 
//		        prpLscheduleMainWFDto.setNextNodeNo( prpLscheduleMainWFNextNodeNo);
		    }
			scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
			
			PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
			prpLclaimStatusDto.setNodeType("sched");
			prpLclaimStatusDto.setRiskCode(riskCode);
			prpLclaimStatusDto.setBusinessNo(prpLinterRequestDto.getRelationRegistNo());
			prpLclaimStatusDto.setPolicyNo(prpLinterRequestDto.getPolicyno());
			prpLclaimStatusDto.setInputDate(new DateTime(prpLinterRequestDto.getCompeTime(),DateTime.YEAR_TO_DAY));
			prpLclaimStatusDto.setOperateDate(new DateTime(prpLinterRequestDto.getCompeTime(),DateTime.YEAR_TO_DAY));
			prpLclaimStatusDto.setHandlerCode(policyDto.getPrpCmainDto().getHandlerCode());
			prpLclaimStatusDto.setHandlerCode(compeUser);
			prpLclaimStatusDto.setStatus("4");
			scheduleDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
			
			PrpLinterSchedExtDto[] prpLinterSchedExtDtoArray = prpLinterRequestDto.getPrpLinterSchedExtDto();
			ArrayList<PrpLregistExtDto> prpLregistExtDtoList = new ArrayList<PrpLregistExtDto>();
	        PrpLregistExtDto prpLregistExtDto = null ;
	        if(prpLinterSchedExtDtoArray!=null&&prpLinterSchedExtDtoArray.length>0){
	        	for(int i=0;i<prpLinterSchedExtDtoArray.length;i++){
	        		prpLregistExtDto = new PrpLregistExtDto();
	        		prpLregistExtDto.setRegistNo(prpLinterRequestDto.getRelationRegistNo());
	        		prpLregistExtDto.setSerialNo(prpLinterSchedExtDtoArray[i].getSerialNo());
	        		prpLregistExtDto.setOperatorCode(prpLinterSchedExtDtoArray[i].getOperatorCode());
	        		prpLregistExtDto.setContext(prpLinterSchedExtDtoArray[i].getContext());
	        		prpLregistExtDtoList.add(prpLregistExtDto);
	        	}
	        }
			scheduleDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
		    
			PrpLscheduleItemDto prpLscheduleItemDto = null ;
			if (scheduleDtoTemp.getPrpLscheduleItemDto()!=null){
				prpLscheduleItemDto = scheduleDtoTemp.getPrpLscheduleItemDto();
				prpLscheduleItemDto.setNextHandlerCode(prpLinterRequestDto.getNextHandlerCode());
				prpLscheduleItemDto.setNextHandlerName(prpLinterRequestDto.getNextHandlerName());
				prpLscheduleItemDto.setCheckSite(prpLinterRequestDto.getCheckSite());
		    }else{
		    	prpLscheduleItemDto = new PrpLscheduleItemDto();
		    	prpLscheduleItemDto.setNextHandlerCode(prpLinterRequestDto.getNextHandlerCode());
		    	prpLscheduleItemDto.setNextHandlerName(prpLinterRequestDto.getNextHandlerName());
		    	prpLscheduleItemDto.setCheckSite(prpLinterRequestDto.getCheckSite());
		    }
			scheduleDto.setPrpLscheduleItemDto(prpLscheduleItemDto);
			
			String registNo = prpLinterRequestDto.getRelationRegistNo();
			//生成回访信息 begin
	    	PrplreturnvisitswflogDto prplreturnvisitswflogDto  = this.setReturnVisitSwflogDto(user, registNo, "sched", "0");
	    	scheduleDto.setPrplreturnvisitswflogDto(prplreturnvisitswflogDto);
	    	//生成回访信息 end
			
			Collection collection = new UIWorkFlowAction().findNodesByConditions(" registno='"+registNo+"' and nodetype='sched' and nodestatus='0' ");
			if(collection == null || collection.size()<1){
				throw new Exception("不存在调度节点");
			}
			collection.iterator().next();
			SwfLogDto swflogDto = (SwfLogDto)collection.iterator().next();
			swflogDto.setNextBusinessNo(prpLinterRequestDto.getRelationRegistNo());
			swflogDto.setKeyIn(prpLinterRequestDto.getRelationRegistNo());
	        swflogDto.setKeyOut(prpLinterRequestDto.getRelationRegistNo());
			swflogDto.setNodeStatus("4");
			
			ArrayList<SwfLogDto> swflogList = new ArrayList<SwfLogDto>();
			SwfLogDto nextSwflog = new SwfLogDto();
			nextSwflog.setHandlerCode(user.getUserCode());
			nextSwflog.setHandlerName(user.getUserName());
			nextSwflog.setNodeType("check");
			swflogList.add(nextSwflog);
			
			if (swflogList.size() >0){
				swflogDto.setNextNodeListType("1");//如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
				swflogDto.setSwfLogList(swflogList);
		    }
			String sqlSched = " Update swflog Set  submittime='"+prpLinterRequestDto.getCompeTime()
									           +"' Where registno ='"+registNo+"' and nodeType ='sched'";
			String sqlCheck = " Update swflog Set Flowintime='"+prpLinterRequestDto.getCompeTime()
                                               +"',handletime='"+prpLinterRequestDto.getCompeTime()
                                               +"' Where registno ='"+registNo+"' and nodeType ='check'";
			
			//记录流程轨迹表-调度环节成功标志
			prplinterAutoClaimDetailDto.setSchedSuccFlag("1");
			prplinterAutoClaimDetailDto.setRemark("调度成功："+registNo);
			new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
			WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			/***********************add 大病系统标志***********************/
			//增加大病系统标志medicaltransitflag
			WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swflogDto);
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
			//uiScheduleAction.save(scheduleDto);
			uiScheduleAction.save(scheduleDto, workFlowDto);
			
			new BLPrplinterAutoClaimDetailFacade().updateBySQL(sqlSched);
			new BLPrplinterAutoClaimDetailFacade().updateBySQL(sqlCheck);
		}catch (Exception e) {
			prplinterAutoClaimDetailDto.setSchedSuccFlag("0");
			String messege = e.toString();
			if(messege!=null&&messege.length()>1000){
				messege = messege.substring(0,1000);
			}
			prplinterAutoClaimDetailDto.setRemark("调度失败："+messege);
			new BLPrplinterAutoClaimDetailFacade().update(prplinterAutoClaimDetailDto);
			e.printStackTrace();
			throw e;
		}
			
	    return prpLinterRequestDto;
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
