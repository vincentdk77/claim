package com.sinosoft.claim.webservice;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.axis.client.Service;

import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.AgriScheduleDto;
import com.sinosoft.claim.dto.custom.PropScheduleDto;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.AgriScheduleViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAAReturnVisitViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.CallCenterInterfaceLogger;
import com.sinosoft.claim.util.XMLHandler;
import com.sinosoft.claim.webservice.client.NewAgriWS.ClaimForDispatchServiceSoapBindingStub;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.reference.AppConfig;


public class UIScheduleDealEditPostWebservice {
	CallCenterInterfaceLogger logger = new CallCenterInterfaceLogger();
	/**
	 * 农险调度信息
	 * @param agriScheduleDto
	 * @return
	 */
	public String saveAgriScheduleDto(AgriScheduleDto agriScheduleDto){
		long serial = System.currentTimeMillis();
		logger.log("农险调度信息", 1,serial, agriScheduleDto);
		String registNo = "";
		String policyNo = "";
		String flag="000";
		try{
			if(agriScheduleDto != null){
				registNo = agriScheduleDto.getRegistNo();
			}
			BLPrpLregistFacade prpLregistFacade=new BLPrpLregistFacade();
		    PrpLregistDto prplRegistDto=(PrpLregistDto)prpLregistFacade.findByPrimaryKey(registNo);
			if(prplRegistDto != null){
				policyNo =prplRegistDto.getPolicyNo();
			}
			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PrpCmainDto prpCmainDto = uiPolicyAction.findPrpCmainDtoByPrimaryKey(policyNo);
			if(prpCmainDto != null && "agri".equals(prpCmainDto.getSystemFlag())){//新农险
				//String URL = "http://9.0.2.33:9012/services/ClaimForDispatchService?wsdl";
				String URL = AppConfig.get("sysconst.NEWAGRI_SCHEDULESAVE");
				String xml = XMLHandler.getSaveAgriScheduleDtoXML(agriScheduleDto);
				System.out.println("农险调度信息请求报文："+xml);
				logger.log("农险调度信息请求报文：", 0,serial, xml);
				Service service = new Service();
				ClaimForDispatchServiceSoapBindingStub stub = 
						new ClaimForDispatchServiceSoapBindingStub(new java.net.URL(URL),service);
				String returnMessage = stub.saveAgriScheduleDto(xml);
				System.out.println("农险调度信息返回报文："+returnMessage);
				logger.log("农险调度信息返回报文：", 0,serial, returnMessage);
				String flag1 = returnMessage.substring(returnMessage.indexOf("<code>")+6, returnMessage.indexOf("</code>"));
				if("01".equals(flag1)){
					flag = "001";
				}
				logger.log("农险调度信息", 0,serial, "[flag:"+flag+"]");
			}else{//老理赔
				UIScheduleDealInfoCheckAndTrans trans = new UIScheduleDealInfoCheckAndTrans();
				String result = trans.checkAgriScheduleInfo(agriScheduleDto);
				if(null != result && !"".equals(result)){
					if(result.indexOf("001^")>-1){
						System.out.println("参数校验"+result);
						flag = "002";//参数校验不合格
						return flag;
					}
				}
				UIScheduleDealEditPostInfo uIScheduleDealEditPostInfo = trans.transAgriScheduleToUiScheduleDeal(agriScheduleDto);
				
				UserDto user = new UserDto();
				user.setUserCode(agriScheduleDto.getOperatorCode());
				user.setUserName(agriScheduleDto.getOperatorName());
				user.setComCode(agriScheduleDto.getMakeComCode());
				user.setComName(agriScheduleDto.getMakeComName());
				
				flag = uiScheduleEditPost(uIScheduleDealEditPostInfo, user,serial);
				logger.log("农险调度信息", 0,serial, "[flag:"+flag+"]");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	   
		return flag;
	} 
	/**
	 * 财产险调度信息
	 * @param propScheduleDto
	 * @return
	 */
	public String  savePropScheduleDto(PropScheduleDto propScheduleDto){
		long serial = System.currentTimeMillis();
		logger.log("财产险调度信息", 1,serial,propScheduleDto);
		String flag="000";
		UIScheduleDealInfoCheckAndTrans trans = new UIScheduleDealInfoCheckAndTrans();
		String result = trans.checkPropScheduleInfo(propScheduleDto);
		if(null != result && !"".equals(result)){
			if(result.indexOf("001^")>-1){
				System.out.println("参数校验"+result);
				flag = "002";//参数校验不合格
				return flag;
			}
		}
		UIScheduleDealEditPostInfo uIScheduleDealEditPostInfo = trans.transPropScheduleToUiScheduleDeal(propScheduleDto);
		
		UserDto user = new UserDto();
		user.setUserCode(propScheduleDto.getOperatorCode());
		user.setUserName(propScheduleDto.getOperatorName());
		user.setComCode(propScheduleDto.getMakeComCode());
		user.setComName(propScheduleDto.getMakeComName());
		
		flag = uiScheduleEditPost(uIScheduleDealEditPostInfo, user,serial);
		logger.log("财产险调度信息", 0,serial, "[flag:"+flag+"]");
		return flag;
	}
	
	
	private String uiScheduleEditPost(UIScheduleDealEditPostInfo uIScheduleDealEditPostInfo,UserDto user,long serial){
		String flag="000";
		try{
			String registNo = uIScheduleDealEditPostInfo.getPrpLscheduleMainWFRegistNo();
			String riskCode = uIScheduleDealEditPostInfo.getPrpLscheduleMainWFRiskCode();
			String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
			
			int scheduleID=1;
			
			String  activeSchedule = "";//查勘通知调度进行定损调度
			
			AgriScheduleViewHelper agriScheduleViewHelper = new AgriScheduleViewHelper();
		    ScheduleDto scheduleDto = new ScheduleDto();
			
		  //添加意健险，也走农险的viewhelper modified by xiatian 
		   if("I".equals(riskType)||"H".equals(riskType)||"Q".equals(riskType)||"Z".equals(riskType)||"Y".equals(riskType)||"E".equals(riskType)){
		       scheduleDto = agriScheduleViewHelper.viewToDtoNew(user, uIScheduleDealEditPostInfo);
		       //生成回访信息 begin
		       DAAReturnVisitViewHelper daaReturnVisitViewHelper = new DAAReturnVisitViewHelper();
		       PrplreturnvisitswflogDto prplreturnvisitswflogDto  = daaReturnVisitViewHelper.setReturnVisitSwflogDtoNew(user, registNo, "sched", "0");
		       scheduleDto.setPrplreturnvisitswflogDto(prplreturnvisitswflogDto);
		       //生成回访信息 end
		    }else{
		    }
		    WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
		    
		    BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
		    String conditions = " registno='"+registNo+"' and nodetype='sched' and riskcode='"+riskCode+"'";
		    ArrayList<SwfLogDto> swfLogDtoList = (ArrayList<SwfLogDto>)blSwfLogFacade.findByConditions(conditions);
		    String swfLogFlowID = "";
		    String swfLogLogNo = "";
		    if(null != swfLogDtoList && swfLogDtoList.size()>0){
		    	swfLogFlowID = swfLogDtoList.get(0).getFlowID();
		    	swfLogLogNo = String.valueOf(swfLogDtoList.get(0).getLogNo());
		    }else{
		    	return "003";//不存在未处理的调度节点
		    }
		    
		    boolean finishSchedule=true;//是否完成调度
	        SwfLogDto swfLogDtoDealNode = new SwfLogDto();
	        
	        swfLogDtoDealNode.setNodeStatus(scheduleDto.getPrpLclaimStatusDto().getStatus());
	        swfLogDtoDealNode.setFlowID(swfLogFlowID);
	        swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
	        swfLogDtoDealNode.setNextBusinessNo(registNo);
	        swfLogDtoDealNode.setKeyIn(registNo);
	        swfLogDtoDealNode.setKeyOut(registNo);
		    
	        SwfLogDto swfLogDtoTemp = new UIWorkFlowAction().findNodeByPrimaryKey(swfLogDtoDealNode.getFlowID(),swfLogDtoDealNode.getLogNo());
	        swfLogDtoDealNode.setNodeStatus(scheduleDto.getPrpLclaimStatusDto().getStatus());
	        if("sched".equals(swfLogDtoTemp.getNodeType())){
	     	   activeSchedule = swfLogDtoTemp.getTypeFlag();
	        }
		    
	        //根据类型不同，操作不同
	        Collection nextNodeList = new ArrayList();
	        //查勘调度的选择
	        String  checkSelectSend=uIScheduleDealEditPostInfo.getCheckSelectSend();
	        String oldcheckFlag =uIScheduleDealEditPostInfo.getPrpLscheduleMainWFScheduleFlag();
	        boolean selectCheckNow=false;
			if ("15".equals(activeSchedule)) {
			}// 不再查勘了
			else {
				if ("0".equals(oldcheckFlag)&& "1".equals(checkSelectSend)) {
						// 选择了查勘调度
						SwfLogDto swfLogNextNode = new SwfLogDto();
						String nextHandlerCode1 = uIScheduleDealEditPostInfo.getNextHandlerCode1();
						String nextHandlerName1 = uIScheduleDealEditPostInfo.getNextHandlerName1();

						swfLogNextNode.setNodeNo(0);
						swfLogNextNode.setNodeType("check");
						swfLogNextNode.setHandlerCode(nextHandlerCode1);
						swfLogNextNode.setHandlerName(nextHandlerName1);
						swfLogNextNode.setNewHandleDept(scheduleDto
								.getPrpLscheduleMainWFDto()
								.getScheduleObjectID());
						nextNodeList.add(swfLogNextNode);

						selectCheckNow = true;// 表示本次选择了查勘调度
				}
			}
			int maxRow = 0;
	        //意健险不需要添加定损调度 modified by xiatian 
	        if(!"Q".equals(riskType)&&!"Y".equals(riskType)&&!"Z".equals(riskType)&&!"E".equals(riskType)){
	      	  maxRow =1 ;
	        }
		    
	        //紧急标志位
	        String exigenceGree  =uIScheduleDealEditPostInfo.getExigenceGree();
	        String endflag = "0";
	        //调度标的部分开始
	        int itemNo=0;
	        //如果本次选择了查勘调度，在全流程条件下无论定损是否都选择了，都认为调度就是没有完成
	        //endflag=1,表示半流程
	        if (selectCheckNow&& "0".equals(endflag)) {
	        	finishSchedule=false;
	        }
	        //如果没选查勘调度，则没有完成
	        if ("0".equals(checkSelectSend )){
	        	finishSchedule=false;
	        } 
	        
	        String selectSend=uIScheduleDealEditPostInfo.getPrpLscheduleItemSelectSend();//选择进行调度
	        String surveyTimes=uIScheduleDealEditPostInfo.getPrpLscheduleItemSurveyTimes();//是否为已经调度过的？
	        String nextHandlerCode=uIScheduleDealEditPostInfo.getNextHandlerCode();      //指定下一个节点操作人代码
	        String nextHandlerName=uIScheduleDealEditPostInfo.getNextHandlerName();      //指定下一个节点操作人姓名
	        String strNextNode=uIScheduleDealEditPostInfo.getNextNodeNo();               //指定下一个节点名
	        String prpLscheduleItemItemNo=uIScheduleDealEditPostInfo.getPrpLscheduleItemItemNo();//调度标底号
	        String prpLscheduleItemScheduleObjectID     =uIScheduleDealEditPostInfo.getPrpLscheduleItemScheduleObjectID();
	        
	        //保单条款代码
//	        String strClauseType = httpServletRequest.getParameter("clauseType");
	        if(maxRow ==1){
	        	if (selectSend.equals("0")) {
	                finishSchedule=false;
	            }
	            
	            if (selectSend.equals("1")&&surveyTimes.equals("0")) {
	               SwfLogDto swfLogNextNode = new SwfLogDto();
	               swfLogNextNode.setNodeNo(0);
	               swfLogNextNode.setNodeType(strNextNode);//在界面用js指定了各个调度类型，如定损，人伤什么的。
	               swfLogNextNode.setHandlerCode(nextHandlerCode);
	               swfLogNextNode.setHandlerName(nextHandlerName);
	               //保存调度号码和itemitemNo的号码
	               swfLogNextNode.setScheduleID(scheduleID) ;
	               swfLogNextNode.setLossItemCode(prpLscheduleItemItemNo);
	               //modify by miaowenjun 20060928 农险没有这些东西
//	               if(!"I".equals(riskType)&&!"H".equals(riskType)){
//		                  //保存车牌的号码
//		                  swfLogNextNode.setLossItemName(prpLscheduleItemLicenseNo);
//		                  //保存是否保单车辆的标志
//		                  swfLogNextNode.setInsureCarFlag(prpLscheduleInsureCarFlag) ;
//	               }
	               //紧急标志位
	               swfLogNextNode.setExigenceGree(exigenceGree);
	               swfLogNextNode.setNewHandleDept(prpLscheduleItemScheduleObjectID );
	               
	               //Modify by wangwei add start 2006-01-14
	               //Reason: F22(机动车辆第三者责任保险条款),标的车没有定损，在此自动撤销。
//	               if ("F22".equals(strClauseType) && "1".equals(prpLscheduleItemItemNo)) {
//	                  swfLogNextNode.setNodeStatus("6"); 
//	               }
	               //Modify by wangwei add start 2006-01-14
	               
	               nextNodeList.add(swfLogNextNode);
	            }
	        }
	        
	        if (nextNodeList.size() >0){
	            swfLogDtoDealNode.setNextNodeListType("1");//如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
	            swfLogDtoDealNode.setSwfLogList(nextNodeList);
	        }
	            
	        // 半流程的特殊处理
	        WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
	        String  msg="";
	        if (!finishSchedule && workFlowDto.getUpdate()) {
				workFlowDto.getUpdateSwfLogDto().setNodeStatus("2");
			} else {
				if (workFlowDto.getUpdate()) { // 检查之前是否有查勘，并且还没结束的节点
					// 双代案件,由于查勘是由出险地来做的所以,承保方(commiflag=2)提交时不用判断查勘是否做完 add by
					// liyanjie 2005-12-20
					if (!"2".equals(scheduleDto.getPrpLscheduleMainWFDto()
							.getCommiFlag())) { // if 判断add by liyanjie 2005-12-20
						msg = workFlowViewHelper.checkNodeSubmit(swfLogFlowID,
								swfLogLogNo);

						if (!msg.equals(""))
							workFlowDto.getUpdateSwfLogDto().setNodeStatus("2");
					}
				}
			}
	         
	         UIScheduleAction uiScheduleAction = new UIScheduleAction();
	         if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate())
					|| (workFlowDto.getSubmit()) || (workFlowDto.getClose())) {
				if ("1".equals(endflag) && workFlowDto.getUpdateSwfLogDto() != null) {
					if (workFlowDto.getUpdateSwfLogDto().getNodeStatus()
							.equals("4")) {
						workFlowDto.setClose(true);
					} else {
						workFlowDto.setClose(false);
					}
				}
				uiScheduleAction.save(scheduleDto, workFlowDto);
			} else {
				uiScheduleAction.save(scheduleDto, workFlowDto);
			}
		}catch(Exception e){
			e.printStackTrace();
			flag = "001";//调度失败
			logger.log("农险调度信息",serial,e);
		}
	    
		return flag;
	}

}
