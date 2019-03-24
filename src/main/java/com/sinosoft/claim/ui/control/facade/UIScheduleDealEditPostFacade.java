package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;


import com.sinosoft.assistant.services.PushCaseWsImpl;
import com.sinosoft.assistant.services.PushCaseWsImplServiceLocator;
import com.sinosoft.claim.SMSService.SMSDto;
import com.sinosoft.claim.SMSService.SendSMS;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLRegistFacade;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.AgriScheduleViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAAReturnVisitViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAAScheduleViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.ui.model.SwfLogFindByPrimaryKeyCommand;
import com.sinosoft.claim.zdyApp.ZdyAppCaseDto;
import com.sinosoft.claim.zdyApp.ZdyAppCaseTransFacade;
import com.sinosoft.prpall.blsvr.cb.BLPrpCinsured;
import com.sinosoft.prpall.schema.PrpCinsuredSchema;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 分发HTTP GET 理赔调度节点的保存任务
 * <p>Title: 理赔调度节点的保存任务</p>
 * <p>Description: 理赔调度节点的保存任务</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */

public class UIScheduleDealEditPostFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
  throws Exception
  {
    int nextNodeNo=0;
    String[] nextHandlerCode=httpServletRequest.getParameterValues("nextHandlerCode");      //指定下一个节点操作人代码
    String[] nextHandlerName=httpServletRequest.getParameterValues("nextHandlerName");      //指定下一个节点操作人姓名
    String[] strNextNode=httpServletRequest.getParameterValues("nextNodeNo");               //指定下一个节点名
    
    //定损调度选择
    String[] selectSend=httpServletRequest.getParameterValues("prpLscheduleItemSelectSend");//选择进行调度
    String[] prpLscheduleItemItemNo=httpServletRequest.getParameterValues("prpLscheduleItemItemNo");//调度标底号
    String[] prpLscheduleItemLicenseNo =httpServletRequest.getParameterValues("prpLscheduleItemLicenseNo");//车牌号码
    String[] prpLscheduleInsureCarFlag =httpServletRequest.getParameterValues("prpLscheduleItemInsureCarFlag");//是否为本保单投保车辆
    String[] surveyTimes=httpServletRequest.getParameterValues("prpLscheduleItemSurveyTimes");//是否为已经调度过的？
    String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //工作流号码
    String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //工作流logno
    String  msg="";
    String[] prpLscheduleItemScheduleObjectID     =httpServletRequest.getParameterValues("prpLscheduleItemScheduleObjectID");
    String  prpLscheduleMainWFScheduleID   = httpServletRequest.getParameter("prpLscheduleMainWFScheduleID");
    String  activeSchedule = "";//查勘通知调度进行定损调度
    //查勘调度的选择
    String  checkSelectSend=httpServletRequest.getParameter("checkSelectSend");
    String oldcheckFlag =httpServletRequest.getParameter("prpLscheduleMainWFScheduleFlag");
    String endflag =httpServletRequest.getParameter("endflag");
    boolean selectCheckNow=false;
    //需要保存车牌号码，
    String forward="";
    
    //add by miaowenjun 20060928
    String riskCode = httpServletRequest.getParameter("prpLscheduleMainWFRiskCode");
    String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
    
    //保单条款代码
    String strClauseType = httpServletRequest.getParameter("clauseType");
    
     try{         
     String registNo = httpServletRequest.getParameter("prpLscheduleMainWFRegistNo"); //报案号
     int scheduleID = -1; //调度号
     UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
     UIScheduleAction uiScheduleAction = new UIScheduleAction();
     ActionMessages messages = new ActionMessages();
     
     //modify by ww add begin 2005-11-15
     //reason: 防止重复提交
     String strLastAccessedTime = "" + httpServletRequest.getSession().getLastAccessedTime()/1000;
     String oldLastAccessedTime = (String)httpServletRequest.getSession().getAttribute("oldScheduleLastAccessedTime");
      //modify by ww add end 2005-11-15  
     //if(isTokenValid(httpServletRequest,true)){
     //System.out.println("oldScheduleLastAccessedTime:"+oldLastAccessedTime);
     if(oldLastAccessedTime.trim().equals("")){
         
         //modify by ww add begin 2005-11-15
         //reason: 防止重复提交
        httpServletRequest.getSession().setAttribute ("oldScheduleLastAccessedTime",strLastAccessedTime);
         //modify by ww add end 2005-11-15
        
        //Modify by wangwei add start 2006-02-16
    	//Reason:把调度案件由正在处理改为待处理
    	String buttonSaveType = httpServletRequest.getParameter("buttonSaveType");
    	if ("20".equals(buttonSaveType)) {
    		 //从数据库中查询符合条件的工作流节点
    		SwfLogFindByPrimaryKeyCommand swfLogFindByPrimaryKeyCommand = new SwfLogFindByPrimaryKeyCommand(swfLogFlowID, Integer.parseInt(swfLogLogNo));
            SwfLogDto swfLogDto= (SwfLogDto) swfLogFindByPrimaryKeyCommand.execute();
            WorkFlowDto workFlowDto = new WorkFlowDto();
            UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
            swfLogDto.setNodeStatus("0");
 			swfLogDto.setHandlerCode("");
 			swfLogDto.setHandlerName("");
 			swfLogDto.setFlowStatus("1");
            workFlowDto.setUpdate (true);
            workFlowDto.setUpdateSwfLogDto(swfLogDto);
            uiWorkFlowAction.deal(workFlowDto);
            messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.schedule.back"));
            saveMessages( httpServletRequest, messages );
            return actionMapping.findForward("success"); 
    	}
        //Modify by wangwei add end 2006-02-16
        
       //判断是哪种类型的保存
       String editType=httpServletRequest.getParameter("saveType");
     
       scheduleID=1;
     
       httpServletRequest.setAttribute("registNo", registNo);
       httpServletRequest.setAttribute("scheduleID",String.valueOf( scheduleID));	
       httpServletRequest.setAttribute("isSave", "1");
       //2.用viewHelper整理界面输入
       //modify by miaowenjun 20060928 农险走自己的viewhelper
       AgriScheduleViewHelper agriScheduleViewHelper = new AgriScheduleViewHelper();
       DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
       ScheduleDto scheduleDto = new ScheduleDto();
       //添加意健险，也走农险的viewhelper modified by xiatian 
       if("I".equals(riskType)||"H".equals(riskType)||"Q".equals(riskType)||"Z".equals(riskType)||"Y".equals(riskType)||"E".equals(riskType)){
    	   scheduleDto = agriScheduleViewHelper.viewToDto(httpServletRequest);
    	   //生成回访信息 begin
    	   DAAReturnVisitViewHelper daaReturnVisitViewHelper = new DAAReturnVisitViewHelper();
    	   PrplreturnvisitswflogDto prplreturnvisitswflogDto  = daaReturnVisitViewHelper.setReturnVisitSwflogDto(httpServletRequest, registNo, "sched", "0");
    	   scheduleDto.setPrplreturnvisitswflogDto(prplreturnvisitswflogDto);
    	   //生成回访信息 end
       }else{
    	   scheduleDto = dAAScheduleViewHelper.viewToDto(httpServletRequest);
       }
       WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();

       //System.out.println("editType.========"+editType);
       //调度改派
       if (editType.equals("GETBACKEDIT"))
       {
    	//判断是哪种类型的改派，是定损的，还是
       	String getbackNodeType= httpServletRequest.getParameter( "getbackNodeType");
       	//System.out .println(getbackNodeType);
       	String scheduleObjectID="";
       	if (!"check".equals( getbackNodeType)){ //定损改派
       		scheduleDto.setPrpLscheduleMainWFDto(null );
       		if (scheduleDto.getPrpLscheduleItemDtoList()!=null&&scheduleDto.getPrpLscheduleItemDtoList().size() >0 ){
       			scheduleDto.setPrpLscheduleItemDto((PrpLscheduleItemDto) scheduleDto.getPrpLscheduleItemDtoList().iterator() .next()   );
       			scheduleObjectID=scheduleDto.getPrpLscheduleItemDto().getScheduleObjectID() ;
       		}
       		httpServletRequest.setAttribute("nodeType1", editType);
       	}else
       	{ //查勘改派 
       		scheduleObjectID=scheduleDto.getPrpLscheduleMainWFDto().getScheduleObjectID() ;
       		httpServletRequest.setAttribute("nodeType1", "sched");
       	}
       	//目前改派只保存业务数据，但是，如果是修改节点上的人的话。。。
         String newHandlerCode="";
         String scheduleType=     httpServletRequest.getParameter("scheduleType"            );
         WorkFlowDto workFlowDto = new WorkFlowDto();
         //有没有做换人操作
         newHandlerCode= httpServletRequest.getParameter("newHandlerCode");   
        
         
         //System.out.println(newHandlerCode+"4543543");
         //if (newHandlerCode.length()>0 || ){
         	//更换用户，这个其他的函数也可以进行调用的
         System.out.println("新更换的人员代码:"+newHandlerCode);
       workFlowDto =workFlowViewHelper.changeFlowNodeHandler(swfLogFlowID, swfLogLogNo,newHandlerCode,user.getUserName() +"进行了调度改派人员"+newHandlerCode ,scheduleObjectID);
          //}
         
         //如果换机构了呢？？
         
         
         if (workFlowViewHelper.checkDealDto(workFlowDto)){
         	//将改派后的任务变成待处理
         	if (workFlowDto.getUpdateSwfLogDto() !=null){
         		workFlowDto.getUpdateSwfLogDto().setNodeStatus( "0");
         	}
            uiScheduleAction.changeSave(scheduleDto,workFlowDto);
         }else{
           uiScheduleAction.changeSave(scheduleDto);
         }

       } 
       //正常调度
       else {
           //4.以下是工作流处理的过程
           //-----------------------------------------------------
           // 1requst对象,2本节点的节点类型,3本节点需要更新的状态,4本节点的业务号码,5以后节点的业务号码,6本节点的业务流入号码,7以后节点的业务流出号码
                   
           String scheduleType = httpServletRequest.getParameter("scheduleType"); //调度类型
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
			if ("15".equals(activeSchedule)) {
			}// 不再查勘了
			else {
				if ("0".equals(oldcheckFlag)
						&& "1".equals(checkSelectSend)) {
					// 选择了查勘调度
					SwfLogDto swfLogNextNode = new SwfLogDto();
					String nextHandlerCode1 = httpServletRequest
							.getParameter("nextHandlerCode1");
					String nextHandlerName1 = httpServletRequest
							.getParameter("nextHandlerName1");

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
			// 因为人到人的原因,但是又2因为不止一个查勘对象，那么。。。主车到调度，三者直接到定损
          int maxRow = 0;
          //意健险不需要添加定损调度 modified by xiatian 
          if(!"Q".equals(riskType)&&!"Y".equals(riskType)&&!"Z".equals(riskType)&&!"E".equals(riskType)){
        	  maxRow =Integer.parseInt((String)httpServletRequest.getParameter("maxrow")) ;
          }
            //紧急标志位
            String[] exigenceGree          =httpServletRequest.getParameterValues("exigenceGree"      );
            //调度标的部分开始
            int itemNo=0;
            //如果本次选择了查勘调度，在全流程条件下无论定损是否都选择了，都认为调度就是没有完成
            //endflag=1,表示半流程
            if (selectCheckNow&& "0".equals(endflag)) finishSchedule=false;
            //如果没选查勘调度，则没有完成
            if ("0".equals(checkSelectSend ))  finishSchedule=false;
            //定损调度，在都调度结束后，新增定损调度后，产生新的check有问题。。。。。
            
             for(int index=0;index<maxRow;index++) {
                 
               //只要存在一个没有调度的定损标的，就是认为定损调度没有完成	
               if (selectSend[index].equals("0")) {
                   finishSchedule=false;
               }
               
               if (selectSend[index].equals("1")&&surveyTimes[index].equals("0")) {
                  SwfLogDto swfLogNextNode = new SwfLogDto();
                  swfLogNextNode.setNodeNo(0);
                  swfLogNextNode.setNodeType(strNextNode[index]);//在界面用js指定了各个调度类型，如定损，人伤什么的。
                  swfLogNextNode.setHandlerCode(nextHandlerCode[index]);
                  swfLogNextNode.setHandlerName(nextHandlerName[index]);
                  //保存调度号码和itemitemNo的号码
                  swfLogNextNode.setScheduleID(scheduleID) ;
                  swfLogNextNode.setLossItemCode(prpLscheduleItemItemNo[index]);
                  //modify by miaowenjun 20060928 农险没有这些东西
                  if(!"I".equals(riskType)&&!"H".equals(riskType)){
	                  //保存车牌的号码
	                  swfLogNextNode.setLossItemName(prpLscheduleItemLicenseNo[index]);
	                  //保存是否保单车辆的标志
	                  swfLogNextNode.setInsureCarFlag(prpLscheduleInsureCarFlag[index]) ;
                  }
                  //紧急标志位
                  swfLogNextNode.setExigenceGree(exigenceGree[index]);
                  swfLogNextNode.setNewHandleDept(prpLscheduleItemScheduleObjectID[index] );
                  
                  //Modify by wangwei add start 2006-01-14
                  //Reason: F22(机动车辆第三者责任保险条款),标的车没有定损，在此自动撤销。
                  if ("F22".equals(strClauseType) && "1".equals(prpLscheduleItemItemNo[index])) {
                     swfLogNextNode.setNodeStatus("6"); 
                  }
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
           
           /*
           if (finishSchedule&&"1".equals(endflag)){
           	swfLogDtoDealNode.setNodeStatus("2");
           	WorkFlowDto workFlowDtoTemp = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
           	workFlowDto.setSubmit(workFlowDtoTemp.getSubmit());
           	workFlowDto.setSubmitSwfLogDtoList(workFlowDtoTemp.getSubmitSwfLogDtoList() );
        	workFlowDto.setSubmitSwfPathLogDtoList(workFlowDtoTemp.getSubmitSwfPathLogDtoList() );
           	
           }*/
          
         
             //3.保存调度信息,没有完成的话，设置状态为2,未完成查勘的，没有 把所有定损调度做完的，都是正在处理的状态
             if (!finishSchedule&&workFlowDto.getUpdate()){
                workFlowDto.getUpdateSwfLogDto().setNodeStatus("2");
              }else{
                if (workFlowDto.getUpdate() ){ //检查之前是否有查勘，并且还没结束的节点
                	//双代案件,由于查勘是由出险地来做的所以,承保方(commiflag=2)提交时不用判断查勘是否做完 add by liyanjie 2005-12-20
                	if(!"2".equals(scheduleDto.getPrpLscheduleMainWFDto().getCommiFlag())){ //if 判断add by liyanjie 2005-12-20 
                		msg=workFlowViewHelper.checkNodeSubmit(swfLogFlowID,swfLogLogNo);
                		
                		if (!msg.equals("") ) workFlowDto.getUpdateSwfLogDto().setNodeStatus("2");
                	}
              }
          
          }

            if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate()) ||(workFlowDto.getSubmit())||(workFlowDto.getClose()))
            {
            	 if ("1".equals(endflag)&&workFlowDto.getUpdateSwfLogDto() !=null){
            	 	//System.out .println("43543543543"+workFlowDto.getUpdateSwfLogDto().getNodeStatus()) ;
            	 	if (workFlowDto.getUpdateSwfLogDto().getNodeStatus().equals( "4")){
                   	workFlowDto.setClose(true);
                   }else{
                   	workFlowDto.setClose(false);
                   }
            	 }  
               uiScheduleAction.save(scheduleDto,workFlowDto);
               //驻点员App案件推送
               BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
          	   PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
          	   String result = null;
               String caseReportCd =  prpLregistDto.getRegistNo();
               String insuredName = prpLregistDto.getInsuredName();
               String damageStartDate = prpLregistDto.getDamageStartDate()+"";
               String damageAddress = prpLregistDto.getDamageAddress();
               String surveyUserCd = httpServletRequest
          		.getParameter("nextHandlerCode1");
               String riskCode1 = prpLregistDto.getRiskCode();
               String pushContent = "尊敬的客户，您的报案已受理" 
          			              + "，报案号："+caseReportCd;
               if("31".equals(riskCode1.substring(0, 2)) || "32".equals(riskCode1.substring(0, 2))){
            	   String data = "<PUSHCASE>" + "<CASE_REPORT_CD>"
									+ caseReportCd + "</CASE_REPORT_CD>"
									+ "<RISK_CODE>" + riskCode1
									+ "</RISK_CODE>" + "<INSURED_NAME>"
									+ insuredName + "</INSURED_NAME>"
									+ "<DAMAGE_START_DATE>" + damageStartDate
									+ "</DAMAGE_START_DATE>"
									+ "<DAMAGE_ADDRESS>" + damageAddress
									+ "</DAMAGE_ADDRESS>" + "<SURVEY_USER_CD>"
									+ surveyUserCd + "</SURVEY_USER_CD>"
									+ "<PUSH_CONTENT>" + pushContent
									+ "</PUSH_CONTENT>" + "</PUSHCASE>";
							System.err.print(data);
							try{
								PushCaseWsImplServiceLocator service = new PushCaseWsImplServiceLocator();
								PushCaseWsImpl impl = service
										.getacceptPushCaseService();
								result = impl.accept(data);
								System.err.print("result==" + result);
								String transFlag = null;// 案件推送标志（驻点员App）
								if ("SUCCESS".equals(result)) {
									transFlag = "1";
								} else {
									transFlag = "0";
								}
								DateTime transDate = new DateTime(DateTime
										.current().toString(),
										DateTime.YEAR_TO_SECOND);// 案件推送时间（驻点员App）
								ZdyAppCaseDto zdyAppCaseDto = new ZdyAppCaseDto();
								zdyAppCaseDto.setRegistNo(caseReportCd);
								zdyAppCaseDto.setData(data);
								zdyAppCaseDto.setTransFlag(transFlag);
								zdyAppCaseDto.setTransDate(transDate);
								ZdyAppCaseTransFacade zdyAppCaseTransFacade = new ZdyAppCaseTransFacade();
								try {
									zdyAppCaseTransFacade.insert(zdyAppCaseDto);
								} catch (Exception zdyexception) {
									System.out.println("驻点员案件信息推送数据存储异常");
									zdyexception.printStackTrace();
								}
								if ("SUCCESS".equals(result)) {
									result = "案件信息推送驻点员App接口成功!";
								} else {
									//result = "案件信息推送失败!";  
								} 
							}catch(Exception ZDYAppception){
								result = "案件信息推送驻点员App接口失败!";
								System.out.println("案件信息推送驻点员App接口失败!");
								ZDYAppception.printStackTrace();
							}
							System.err.print(result);
							user.setUserMessage("报案号:" + registNo + " " + msg+ result);	
               }else{
            	   user.setUserMessage("报案号:"+registNo+" "+msg);
               }
            }else
            {
                 uiScheduleAction.save(scheduleDto,workFlowDto);
                 user.setUserMessage("报案号:"+registNo+";注意:没有发现与工作流流程相关任何数据！！");
            }
            httpServletRequest.setAttribute("nodeType1", "sched");
        }
         messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.schedule.submit"));
     } else {//重复提交
     	 messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.again.value"));
      }
      saveMessages( httpServletRequest, messages );
      forward="success";
    }

    catch(UserException usee)
    {
      usee.printStackTrace();
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.claimBeforeEdit.queryClaimList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }

    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.claimBeforeEdit.queryClaimList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    }
    finally
    {

    }

    return actionMapping.findForward(forward);
  }

}
