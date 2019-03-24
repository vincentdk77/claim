package com.sinosoft.workrove.ui.control.viewHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.bl.action.domain.BLPrpLscheduleItemAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLscheduleMainWFAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLthirdPartyAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLthirdPropAction;
import com.sinosoft.claim.bl.facade.BLPrpLregistExtFacade;
import com.sinosoft.claim.bl.facade.BLPrpLscheduleItemFacade;
import com.sinosoft.claim.bl.facade.BLPrpLscheduleMainWFFacade;
import com.sinosoft.claim.bl.facade.BLPrpLthirdPartyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLthirdPropFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfLogDtoBase;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.platform.bl.facade.BLPrpDuserFacade;
import com.sinosoft.platform.bl.facade.BLUtiUserGradeFacade;
import com.sinosoft.platform.dto.domain.PrpDuserDto;
import com.sinosoft.platform.dto.domain.UtiUserGradeDto;
import com.sinosoft.platform.ui.control.action.UIPowerAction;
import com.sinosoft.sysframework.common.Constants;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.utiall.blsvr.BLPrpDcompany;
import com.sinosoft.utiall.blsvr.BLPrpDuser;
import com.sinosoft.workrove.dto.formbean.WorkRoveDto;
import com.sinosoft.workrove.dto.formbean.WorkRoveForm;

/**
 * <p>Title: CertainLossViewHelper</p>
 * <p>Description:定损ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2011</p>
 * @author 车险理赔专项项目组 zhangjs
 * @version 1.0
 * <br>
 */
public class CoincareOfWorkViewHelper {
	public CoincareOfWorkViewHelper() {
		// TODO Auto-generated constructor stub
	}

	public Object viewToDto(HttpServletRequest httpServletRequest)
			throws Exception {

		return null;
	}

	/**
	 * 
	 * @param workRoveForm
	 * @return
	 * @throws Exception
	 */
	public WorkRoveDto formToDto(UserDto user,WorkRoveForm workRoveForm) throws Exception {
		WorkRoveDto workRoveDto  = new WorkRoveDto();
		PrpLregistExtDto prpLregistExtDto = new PrpLregistExtDto();
		BLPrpLregistExtFacade prpLregistExtFacade = new BLPrpLregistExtFacade();
		Collection accessList = new ArrayList();
		BLPrpLscheduleItemFacade prpLscheduleItemFacade = new BLPrpLscheduleItemFacade();
		
		//1 整理报案补充说明表的数据
		//1.1查询出过往的案件补充说明
		ArrayList prpLregistExtList = (ArrayList)prpLregistExtFacade.findByConditions(" registNo ='"+workRoveForm.getRegistNo()+"'  order by serialno desc");
		if(null!=prpLregistExtList&&prpLregistExtList.size()>0){
			prpLregistExtDto.setSerialNo(((PrpLregistExtDto)prpLregistExtList.get(0)).getSerialNo()+1) ; 
			accessList.addAll(prpLregistExtList);
		}else{
			prpLregistExtDto.setSerialNo(1) ; 
		}
		//1.2整理本次转交工作的案件补充说明
		prpLregistExtDto.setRegistNo(workRoveForm.getRegistNo());
		prpLregistExtDto.setRiskCode(workRoveForm.getRiskcode());
		prpLregistExtDto.setInputDate(new DateTime(workRoveForm.getInputDate())); 
		DateFormat format= new SimpleDateFormat("HH:mm:ss");
		String date = format.format(new Date());
		prpLregistExtDto.setInputHour(date) ; 
		//prpLregistExtDto.setCheckStatus("0");
		prpLregistExtDto.setComCode(user.getComCode());
		prpLregistExtDto.setOperatorCode(workRoveForm.getOperatorCode()); 
		prpLregistExtDto.setContext(workRoveForm.getContext()); 
		//prpLregistExtDto.setNodetype(workRoveForm.getRoveTypeHidden());
		accessList.add(prpLregistExtDto);

		//把整理的结果放入到返回的对象workRoveDto内。
		workRoveDto.setRegistNo(workRoveForm.getRegistNo());
		workRoveDto.setPrpLregistExtDtoList(accessList);
		
		
		String swfLogFlowID = workRoveForm.getSwfLogFlowID();
		String swfLogLogNo = workRoveForm.getSwfLogLogNo();
		SwfLogDto 			swfLogDtoDealNode 	= new SwfLogDto();//当前节点
		BLSwfLogFacade 		swfLogFacade 		= new BLSwfLogFacade();
		swfLogDtoDealNode = swfLogFacade.findByPrimaryKey(swfLogFlowID, Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
		if("check".equals(swfLogDtoDealNode.getNodeType())){
			BLPrpLscheduleMainWFFacade blPrpLscheduleMainWFFacade = new BLPrpLscheduleMainWFFacade();
			PrpLscheduleMainWFDto prpLscheduleMainWFDto = blPrpLscheduleMainWFFacade.findByPrimaryKey(1,swfLogDtoDealNode.getRegistNo());
			prpLscheduleMainWFDto.setScheduleObjectID(workRoveForm.getHandleCode());
			prpLscheduleMainWFDto.setScheduleObjectName(workRoveForm.getHandleName());
			prpLscheduleMainWFDto.setNextHandlerName(workRoveForm.getHandlerName());
			if(workRoveForm.getHandleCode()==null||"".equals(workRoveForm.getHandleCode())){
				prpLscheduleMainWFDto.setNextHandlerCode("0000000000");
			}else{
				prpLscheduleMainWFDto.setNextHandlerCode(workRoveForm.getHandlerCode());
			}
			workRoveDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
		}
		
		return workRoveDto;
	}

	/**
	 * 
	 * @param user
	 * @param workRoveForm
	 * @return
	 * @throws Exception
	 */
	public WorkFlowDto formToWorkFlowDto(UserDto user, WorkRoveForm workRoveForm)
			throws Exception {
		//1 整理工作流的数据
		WorkFlowDto workFlowDto = new WorkFlowDto();
		WorkFlowViewHelper	workFlowViewHelper 	= new WorkFlowViewHelper();
		BLSwfLogFacade 		swfLogFacade 		= new BLSwfLogFacade();
		SwfLogDto 			swfLogDtoDealNode 	= new SwfLogDto();//当前节点
		SwfLogDto 			swfLogDtoNextNode 	= new SwfLogDto();//下一节点
		BLPrpDuserFacade 	prpDuserFacade 		= new BLPrpDuserFacade();
		Collection nextNodeList = new ArrayList();
		
		
		String swfLogFlowID = workRoveForm.getSwfLogFlowID();
		String swfLogLogNo = workRoveForm.getSwfLogLogNo();
		swfLogDtoDealNode = swfLogFacade.findByPrimaryKey(swfLogFlowID, Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
		swfLogDtoDealNode.setNextBusinessNo(swfLogDtoDealNode.getBusinessNo());
		swfLogDtoDealNode.setNodeStatus("4");
		//下一节点属性
		swfLogDtoNextNode.setBusinessNo(swfLogDtoDealNode.getBusinessNo());
		swfLogDtoNextNode.setKeyIn(swfLogDtoDealNode.getKeyIn());
		//转交查勘，前一节点swflog的keyout==keyin
		if("check".equals(swfLogDtoDealNode.getNodeType())){
			if(null==swfLogDtoDealNode.getKeyOut()||"".equals(swfLogDtoDealNode.getKeyOut().trim())){
				swfLogDtoDealNode.setKeyOut(swfLogDtoDealNode.getKeyIn());
				swfLogDtoNextNode.setKeyOut(swfLogDtoDealNode.getKeyIn());
			}else{
				swfLogDtoNextNode.setKeyOut(swfLogDtoDealNode.getKeyOut());
			}
		}
		
		if(workRoveForm.getHandleCode()!=null && !"".equals(workRoveForm.getHandleCode())){
			swfLogDtoNextNode.setHandleDept(workRoveForm.getHandleCode());
		}else{
			swfLogDtoNextNode.setHandleDept("0000000000");
		}
		swfLogDtoNextNode.setNodeType(swfLogDtoDealNode.getNodeType());
		swfLogDtoNextNode.setLossItemCode(swfLogDtoDealNode.getLossItemCode());
		swfLogDtoDealNode.setNextNodeListType("1");//指定下一结点	
		//任务处理机构，暂时默认为人员处理机构(暂时这么处理，后续有问题在就问题进行改正)
		//1.1获取人员记录

		swfLogDtoNextNode.setHandlerCode(workRoveForm.getHandlerCode());
		swfLogDtoNextNode.setHandlerName(workRoveForm.getHandlerName());
		nextNodeList.add(swfLogDtoNextNode);
		swfLogDtoDealNode.setSwfLogList(nextNodeList);
		workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDtoDealNode);
		//1 指定到人 需要把handledep写成人员的所在 
		if(null!=workRoveForm.getHandlerCode() &&!"".equals(workRoveForm.getHandlerCode())){
			PrpDuserDto prpDuserDto = prpDuserFacade.findByPrimaryKey(workRoveForm.getHandlerCode());
			//1.2设置
			//对查询出的人员进行权限校验
			boolean checkPower = false ; //是否通过校验
			BLPrpDcompany prpDcompany = new BLPrpDcompany();   
	        String upperComCode = prpDcompany.getCenterCode(prpDuserDto.getComCode());
	        prpDuserDto.setLoginComCode(upperComCode);
		    checkPower=UIPowerAction.checkPowerReturn(prpDuserDto,Constants.TASK_CLAIM_CHECK);
		    if (checkPower) {
		    	   
		    }else{
				throw new Exception("没有权限");
			}
			((SwfLogDto) workFlowDto.getSubmitSwfLogDtoList().get(0)).setHandleDept(prpDuserDto.getComCode());
			
		}else{//没有指定人
			String schedulComCodeStart = "";
			String schedulComCode =  "";
			if(workRoveForm.getHandleCode()!=null && !"".equals(workRoveForm.getHandleCode())){
				schedulComCodeStart = workRoveForm.getHandleCode() ;
			}else{
				schedulComCodeStart = user.getComCode() ;
			}
			((SwfLogDto) workFlowDto.getSubmitSwfLogDtoList().get(0)).setHandleDept(schedulComCodeStart);
			
		}
		//2 如果没有人 但指定到机构了 那么就需要指定到当前机构下的人0
		return workFlowDto;
	}
	
}
