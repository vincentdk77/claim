package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLReCaseAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterRecaseDetailAction;
import com.sinosoft.claim.bl.facade.BLPrpDuserFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcertifyDirectFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterRecaseDetailFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyDirectDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLinterCertifyDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfNodeDto;
import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertifyDirect;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.facade.UIWorkFlowApprovalInterFaceFacade;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utiall.blsvr.BLPrpDuser;

/**
 * 1.	根据中间表数据组织重开赔案相关业务数据。
 * 2.	处理工作流数据，保存重开赔案节点并设置工作流向回转储。
 * 3.	完成对重开赔案的业务数据及工作流数据的存储。
 * 4.	调用接口发送重开赔案数据到核保核赔系统进行处理。
 * 5.	更新流程状态表重开申请环节状态。
 * 
 * @author Administrator
 *
 */
public class UIMedicalAutoRecaseSubViewHelper {
	/**
	 * 大病医疗接口自动申请重开主流程方法，处理自动申请重开的业务数据和工作流数据
	 * @param prpLinterRecaseRequestDto
	 * @return
	 * @throws Exception
	 */
	public PrpLinterRecaseRequestDto autoRecase (PrpLinterRecaseRequestDto prpLinterRecaseRequestDto) throws Exception{
		String registNo = prpLinterRecaseRequestDto.getRelationRegistNo();
		String operatorCode  =  prpLinterRecaseRequestDto.getApplyRecaseUser();
		BLPrpDuserFacade blPrpDuserFacade = new BLPrpDuserFacade();
        PrpDuserDto prpDuserDto = blPrpDuserFacade.findByPrimaryKey(operatorCode);
		String operatorName  =  prpDuserDto.getUserName();
		String operatorComCode = prpLinterRecaseRequestDto.getMakeCom();
		String operatorComCName = prpLinterRecaseRequestDto.getMakeComName();
		//组织UserDto对象
		UserDto user  = new UserDto();
		user.setUserCode(operatorCode);
		user.setUserName(operatorName);
		user.setComCode(operatorComCode);
		user.setComName(operatorComCName);
		String claimNo = "";
		BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
		PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = new PrpLinterRecaseDetailDto();
		BLPrpLinterRecaseDetailAction blPrpLinterRecaseDetailAction = new BLPrpLinterRecaseDetailAction();
		BLPrpLinterRecaseDetailFacade blPrpLinterRecaseDetailFacade = new BLPrpLinterRecaseDetailFacade();
		try {
			String conditions  = " registno='"+registNo.trim()+"' ";
			ArrayList<PrpLclaimDto> prpLclaimList = (ArrayList<PrpLclaimDto>) blPrpLclaimFacade.findByConditions(conditions);
			if(prpLclaimList==null||prpLclaimList.isEmpty()||prpLclaimList.size()<1){
				throw new Exception("未查询出合法的立案信息");
			}
			PrpLclaimDto prpLclaimDto = prpLclaimList.get(0);
			claimNo = prpLclaimDto.getClaimNo();
			//获取最大serialNo
			int serialNo=0;
			UIRecaseAction  uiRecaseAction  =new  UIRecaseAction ();
			conditions="claimNo ='"+claimNo+"'";
			if(uiRecaseAction.findByConditions(conditions)!=null){
			    int maxSerialNo =  uiRecaseAction.getMaxSerialNo(claimNo);
			    serialNo = maxSerialNo+1;
			}
			else {
				serialNo =1;
			}
			ReCaseDto   reCaseDto = new ReCaseDto();;
			//给重开赔案表赋值
			PrpLrecaseDto   prpLrecaseDto =  new PrpLrecaseDto();
			prpLrecaseDto.setClaimNo(claimNo);
			prpLrecaseDto.setSerialNo(serialNo);
			prpLrecaseDto.setOpenCaseDate(new DateTime(prpLinterRecaseRequestDto.getApplyRecaseTime(),DateTime.YEAR_TO_SECOND));
			prpLrecaseDto.setOpenCaseUserCode(prpLinterRecaseRequestDto.getApplyRecaseUser());
			prpLrecaseDto.setReCaseReason(prpLinterRecaseRequestDto.getAppRecaseReason());
			reCaseDto.setPrpLrecaseDto(prpLrecaseDto);
			
			//单证信息
			ArrayList<PrpLcertifyDirectDto> prpLcertifyDirectDtoList = new ArrayList<PrpLcertifyDirectDto>();
			PrpLinterCertifyDto[] prpLinterCertifyDtoList = prpLinterRecaseRequestDto.getPrpLinterCertifyDto();
			PrpLcertifyDirectDto prpLcertifyDirectDto = null;
			int maxSerialNo = new BLPrpLcertifyDirectFacade().getCount(" registno='"+registNo+"' and lossitemcode='1' ")+1;
			if(prpLinterCertifyDtoList!=null && prpLinterCertifyDtoList.length>0){
				for(int i=0;i<prpLinterCertifyDtoList.length;i++){
					prpLcertifyDirectDto = new PrpLcertifyDirectDto();
					prpLcertifyDirectDto.setRegistNo(registNo);
					prpLcertifyDirectDto.setSerialNo(i + maxSerialNo);
					prpLcertifyDirectDto.setRiskCode(prpLclaimDto.getRiskCode());
					prpLcertifyDirectDto.setPolicyNo(prpLinterRecaseRequestDto.getPolicyno());
					prpLcertifyDirectDto.setLossItemCode("1");
					prpLcertifyDirectDto.setTypeCode(prpLinterCertifyDtoList[i].getTypeCode());
					prpLcertifyDirectDto.setTypeName(prpLinterCertifyDtoList[i].getTypeName());
					prpLcertifyDirectDto.setColumnValue("columevaue");
					prpLcertifyDirectDtoList.add(prpLcertifyDirectDto);
				}
			}
			
			/***********处理工作流开始*************/
			
			//用来操作工作流的传输对象
			WorkFlowDto workFlowDto = new WorkFlowDto();
    
			//1.寻找工作流上的编码
			UIWorkFlowAction  uiWorkFlowAction =new UIWorkFlowAction();
			String flowId = uiWorkFlowAction.findStoreFlowIDBybusinessNo(claimNo); //获取flowId
			if (flowId.equals( "")) {
			 	//一般情况下从转储表取，若没有转储，则从swflog表取
			 	flowId = uiWorkFlowAction.findFlowIDBybusinessNo(claimNo); 
			 	if (flowId.equals( "")) {
					throw new Exception("案件未查询到工作流信息，不能重开赔案！");	
			 	}
			}
			//2.检查流程现在的状态
			SwfFlowMainDto swfFlowMainDto=uiWorkFlowAction.findFlowMainByPrimaryKey(flowId);//将flowstatus置为1
			//已转储的从转储表取数据
			int maxLogNo= 0;  //db层maxLogNo是取的最大LogNo+1
			int maxEndcaseLogNo = 0; 
			BLSwfLogStoreFacade blSwflogStoreFacade = null;
			SwfLogDto swfLogjaDto = new SwfLogDto();
			//查询此立案最后一次理算节点
			String condition = "flowid='"+flowId+"' and businessno='"+claimNo+"' and nodeType='compe' order by logNo desc";
			//检查是否现在这个立案已经重开过赔案了，不能再重新开赔案了。。
			String compeStr ="flowid='"+flowId+"' and businessno='"+claimNo+"' and nodeType='compe' and flowstatus>'0' and nodestatus<'4'";
			Collection nodes = null;
			int compeCount = 0;
			//已转储的数据从swflogStore查询
			if("1".equals(swfFlowMainDto.getStoreFlag())){
			 blSwflogStoreFacade = new BLSwfLogStoreFacade();
			 maxLogNo = blSwflogStoreFacade.getMaxLogNo(flowId);
			 maxEndcaseLogNo = blSwflogStoreFacade.getMaxNodeLogNo(flowId,"endca",claimNo); 
			 swfLogjaDto = blSwflogStoreFacade.findByPrimaryKey(flowId,maxEndcaseLogNo);
			 nodes = uiWorkFlowAction.findStoreNodesByConditions(condition);
			 compeCount = uiWorkFlowAction.findFlowStoreNodeCountByConditon(compeStr);
			//未转储的数据从Swflog查询
			}else{
			    maxLogNo= uiWorkFlowAction.getSwfLogMaxLogNo(flowId);  //db层maxLogNo是取的最大LogNo+1
			    maxEndcaseLogNo = uiWorkFlowAction.getSwfLogMaxNodeLogNo(flowId,"endca",claimNo); 
			    swfLogjaDto = uiWorkFlowAction.findNodeByPrimaryKey(flowId,maxEndcaseLogNo); //swfLogjaDto为结案结点的swflogDto
			    nodes = uiWorkFlowAction.findNodesByConditions(condition);
			    compeCount = uiWorkFlowAction.findFlowNodeCountByConditon(compeStr);
			}
			if (nodes == null || nodes.size() == 0){
			  	throw new Exception("没有发现此立案的理算节点！");
			}
			if (compeCount>0){
			 	throw new Exception("此案件的立案已经重开过赔案并未处理完毕，请不要再重开赔案！");
			 }
			//生成一条待处理理算任务
			int modelNo=0; //默认
			ArrayList swfPathLogList= new ArrayList();          //保存新增加的结案到理算的线信息
			if(swfLogjaDto==null){
			 	throw new Exception("案件未查询到结案的工作流信息，不能重开赔案！");
			   
			}
			//3.关闭的流程的处理
			if(swfLogjaDto!=null&&swfFlowMainDto.getFlowStatus().equals( "0") ){
				//3.1开启工作流主表数据，打开工作流的节点所有数据
				swfFlowMainDto.setFlowStatus( "1");
				workFlowDto.setReOpen(true);
				workFlowDto.setReOpenSwfFlowMainDto(swfFlowMainDto);
			}
			
			ArrayList<SwfLogDto> nextList=new ArrayList<SwfLogDto>();
			modelNo=swfLogjaDto.getModelNo() ;
			SwfNodeDto  swfNodeDto= uiWorkFlowAction.findModelNodeByNodeType(modelNo,"rcase");  
			int nodeNo= swfNodeDto.getNodeNo();
			String nodeName=swfNodeDto.getNodeName(); 
			SwfLogDto nextSwfLogDto = new SwfLogDto();
			nextSwfLogDto = swfLogjaDto;
			nextSwfLogDto.setNodeNo(nodeNo);
			nextSwfLogDto.setNodeName(nodeName);
			nextSwfLogDto.setFlowInTime(new DateTime(prpLinterRecaseRequestDto.getApplyRecaseTime(),DateTime.YEAR_TO_SECOND).toString());
			nextSwfLogDto.setFlowStatus("1");
			
			nextSwfLogDto.setKeyIn(claimNo);
			nextSwfLogDto.setLogNo(maxLogNo);
			nextSwfLogDto.setNodeStatus("0"); 
			nextSwfLogDto.setNodeType("rcase");
			nextSwfLogDto.setPackageID("0");     
			nextSwfLogDto.setMainFlowID("0");    
			 
			nextSwfLogDto.setSubFlowID("0");  
			nextSwfLogDto.setRegistNo(swfLogjaDto.getRegistNo());
			nextSwfLogDto.setInsuredName(swfLogjaDto.getInsuredName());
			
			nextSwfLogDto.setHandleDept(swfLogjaDto.getHandleDept());
			nextSwfLogDto.setHandleTime(new DateTime(prpLinterRecaseRequestDto.getApplyRecaseTime(),DateTime.YEAR_TO_SECOND).toString());
			String beforeHandlerCode=swfLogjaDto.getHandlerCode();
			String beforeHandleName =swfLogjaDto.getHandlerName();
			nextSwfLogDto.setBeforeHandlerCode(beforeHandlerCode);
			nextSwfLogDto.setBeforeHandlerName(beforeHandleName);
			nextSwfLogDto.setTaskNo(swfNodeDto.getTaskNo());      
			nextSwfLogDto.setTaskType(swfNodeDto.getTaskType());  
			nextSwfLogDto.setTitleStr("重开赔案");
			nextSwfLogDto.setDeptName(user.getComName());
			nextSwfLogDto.setPosX(0);
			nextSwfLogDto.setPosY(0); 
			nextSwfLogDto.setTypeFlag(swfNodeDto.getTypeFlag());
			nextSwfLogDto.setEndFlag(swfNodeDto.getEndFlag()); 
			nextSwfLogDto.setSubmitTime(new DateTime(prpLinterRecaseRequestDto.getAuditRecaseTime(),DateTime.YEAR_TO_SECOND).toString());
			
			nextSwfLogDto.setMedicalTransitFlag("1");//设置大病系统数据标志，1为大病系统交换过来的数据，空不为大病系统的交换数据
			nextList.add(nextSwfLogDto);
			
			//5.形成新的理赔线数据
			String pathName ="从 结案 到 "+ nodeName ;
			SwfPathLogDto swfPathLogDtoTemp = new SwfPathLogDto();
			swfPathLogDtoTemp.setPathNo(uiWorkFlowAction.getSwfPathLogMaxPathNo( flowId) );
			swfPathLogDtoTemp.setFlowID(flowId );
			swfPathLogDtoTemp.setStartNodeNo(maxEndcaseLogNo );
			swfPathLogDtoTemp.setStartNodeName( "结案");
			swfPathLogDtoTemp.setEndNodeNo(maxLogNo );
			swfPathLogDtoTemp.setEndNodeName( nodeName );
			swfPathLogDtoTemp.setModelNo(modelNo); 
			swfPathLogDtoTemp.setPathName(pathName);
			  
			swfPathLogList.add(swfPathLogDtoTemp );
			//6.设置新增加方式，做为后台数据保存的来源。
			workFlowDto.setSubmit( true);
			workFlowDto.setSubmitSwfPathLogDtoList(swfPathLogList );
			workFlowDto.setSubmitSwfLogDtoList(nextList );
     
			//uiRecaseAction.save(reCaseDto, workFlowDto);
			//创建数据库管理对象
		    DBManager dbManager = new DBManager();
		    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			try {
				//开始事务
				dbManager.beginTransaction();
				new BLReCaseAction().save(dbManager,reCaseDto);
				new DBPrpLcertifyDirect(dbManager).insertAll(prpLcertifyDirectDtoList);
				if (workFlowDto!=null){
					new BLWorkFlowAction().deal(dbManager,workFlowDto);
				}
				prpLinterRecaseDetailDto.setId(prpLinterRecaseRequestDto.getId());
				prpLinterRecaseDetailDto.setPolicyNo(prpLinterRecaseRequestDto.getPolicyno());
				prpLinterRecaseDetailDto.setRegistNo(prpLinterRecaseRequestDto.getRelationRegistNo());
				prpLinterRecaseDetailDto.setClaimNo(prpLclaimDto.getClaimNo());
				prpLinterRecaseDetailDto.setRecaseTime(serialNo);
				prpLinterRecaseDetailDto.setRecaseSuccFlag("1");
				prpLinterRecaseDetailDto.setRemark("重开申请成功："+prpLclaimDto.getClaimNo());
				blPrpLinterRecaseDetailAction.insert(dbManager, prpLinterRecaseDetailDto);
				
				/*** 报案注销送审核平台 start****/
				int vericLogNo = 0;
				if (workFlowDto.getSubmitSwfLogDtoList() != null
							&& workFlowDto.getSubmitSwfLogDtoList().size() > 0) {
						vericLogNo = ((SwfLogDto) workFlowDto
								.getSubmitSwfLogDtoList().get(0)).getLogNo();
				}
				UIWorkFlowApprovalInterFaceFacade uiWorkFlowApprovalInterFaceFacade = new UIWorkFlowApprovalInterFaceFacade();
				String UWflowID = uiWorkFlowApprovalInterFaceFacade
							.submitApprovalPlatform("ClaimRecase",nextSwfLogDto.getFlowID(),
									Integer.valueOf(vericLogNo).toString(),claimNo,prpLclaimDto.getRiskCode(),prpLclaimDto.getClassCode(),
									prpLclaimDto.getComCode(),user.getUserCode(),
									prpLclaimDto.getMakeCom(),user.getUserCode(),
									user.getUserCode(),"");
				if (UWflowID.length() < 15) {
						String msg = "案件'" + prpLclaimDto.getClaimNo()
								+ "'提交双核系统失败，请重新提交或者与管理员联系!";
						throw new Exception(msg);
				}
				
				prpLinterRecaseRequestDto.setPrpLinterRecaseDetailDto(prpLinterRecaseDetailDto);
				//提交事务
				dbManager.commitTransaction();
			} catch (Exception e) {
				e.printStackTrace();
				 //回滚事务
			    dbManager.rollbackTransaction();
			    throw e;
			}finally{
				//关闭数据库连接
			    dbManager.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		    throw e;
		}
		return prpLinterRecaseRequestDto;
	}
}
