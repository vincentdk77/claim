package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.gyic.claim.bl.facade.BLSettlemainlistFacade;
import com.gyic.claim.bl.facade.BLSettlemainlistFacadeForMedical;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.VerifyLossDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UICheckAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.claim.ui.control.action.UIVerifyLossAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.AgriCertainLossViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.AgriCheckViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.AgriVerifyLossViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAACertainLossViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAACheckViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAAScheduleViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * 分发HTTP Post 车险理赔查勘编辑界面
 * <p>Title: 车险理赔查勘编辑界面信息</p>
 * <p>Description: 车险理赔查勘编辑界面信息</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author liubvo
 * @version 1.0
 */  
public class UILCheckEditPostFacade
extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws
			Exception {
		//Log.info(this.getClass().getName(), "BEGIN");
		String forward = ""; //向前流转
		try {
			//查勘号 
			String checkNo = ""; //查勘号
			checkNo = httpServletRequest.getParameter("prpLcheckRegistNo");
			UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
			String comCode=user.getComCode() ;
			String riskCode = httpServletRequest.getParameter("prpLcheckRiskCode");
			String nextHandlerCode=httpServletRequest.getParameter("nextHandlerCode");
			String nextHandlerName=httpServletRequest.getParameter("nextHandlerName");
			String insureCarFlag=httpServletRequest.getParameter("prpLcheckInsureCarFlag"); //是否为本保单车辆
			String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //工作流号码
			String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //工作流logno
			String[] prpLthirdPartyLossFlag =httpServletRequest.getParameterValues("prpLthirdPartyLossFlag"); 
		    String activeSchedule=httpServletRequest.getParameter("messageToScheduleCheck"); //通知调度，使调度工作流变成待处理状态
		    String registno =  httpServletRequest.getParameter("registno");
		    String autoScheduleFlag = httpServletRequest.getParameter("autoScheduleFlag");//自动调度标志
		    String settleListCode=httpServletRequest.getParameter("settleListCode");
		    // 判断当前报案是否存在立案,默认为false,如果已经立案则为true
		    boolean claimFlag = false;
		    BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
			List claimList = (List)blPrpLclaimFacade.findByConditions("registno = '" + registno + "'");
			PrpLclaimDto prpLclaimDto = null;
			if(claimList.size() != 0 ){
				prpLclaimDto = (PrpLclaimDto)claimList.get(0);
				claimFlag = true;
			}
		    
			String lossItemName = httpServletRequest.getParameter("lossItemName");
			//是否是三着车，如果是三者车，不保存任何查勘的信息，只是把工作流送到定损就可以了
			int year =DateTime.current() .getYear() ;
			int nextNodeNo=0;
			
			//if(isTokenValid(httpServletRequest,true)){
			if (checkNo== null||checkNo.length()<1||checkNo.trim().equals(""))
			{
				UIBillAction uiBillAction = new UIBillAction();
				String tableName = "prplcheck";
				checkNo = uiBillAction.getNo(tableName, riskCode, comCode, year);
			}
			httpServletRequest.setAttribute("checkNo", checkNo);
			httpServletRequest.setAttribute("registNo", checkNo);
			//用viewHelper整理界面输入
			//区分是三者，或者是主车的内容进行分别的数据整理
			DAACheckViewHelper dAACheckViewHelper = new DAACheckViewHelper();
			AgriCheckViewHelper agriCheckViewHelper = new AgriCheckViewHelper();
			DAACertainLossViewHelper dAACertainLossViewHelper = new DAACertainLossViewHelper();
			AgriCertainLossViewHelper agriCertainLossViewHelper = new AgriCertainLossViewHelper();
			AgriVerifyLossViewHelper agriVerifyLossViewHelper = new AgriVerifyLossViewHelper();
			//modify by miaowenjun 20060922 农险走自己的viewhelper
			String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
			CheckDto checkDto = new CheckDto();
			VerifyLossDto verifyLossDto = new VerifyLossDto();
			CertainLossDto certainLossDto = new CertainLossDto();
			//add by xiatian  修改意健流程
			if("I".equals(riskType)||"H".equals(riskType)||"Q".equals(riskType)||"Z".equals(riskType)||"E".equals(riskType)){
				checkDto = agriCheckViewHelper.viewToDto(httpServletRequest);
				verifyLossDto = agriVerifyLossViewHelper.viewToDto(httpServletRequest);
				certainLossDto = agriCertainLossViewHelper.viewToDto(httpServletRequest);
			    //在下面这个判断里面写上,关于立案表数据的处理
				if("H".equals(riskType)&&claimFlag){
					//下面进行立案数据的保存
					//BLCheckFacade blCheckFacade = new BLCheckFacade();
					//blCheckFacade.saveClaimLoss(prpLclaimDto, verifyLossDto.getPrpLpropDtoList());
				}
			}else{
				checkDto = dAACheckViewHelper.viewToDto(httpServletRequest);
				certainLossDto = dAACertainLossViewHelper.viewToDto(httpServletRequest);
			}
			//工作流处理过程
			//-----------------------------------------------------
			// 1requst对象,2本节点的节点类型,3本节点需要更新的状态,4本节点的业务号码,5以后节点的业务号码,6本节点的业务流入号码,7以后节点的业务流出号码
			WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			SwfLogDto swfLogDtoDealNode = new SwfLogDto();
			if (swfLogFlowID!=null && swfLogLogNo!=null){
				swfLogDtoDealNode.setFlowID(swfLogFlowID);
				swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
			} else {
				swfLogDtoDealNode.setNodeType("check");
				swfLogDtoDealNode.setBusinessNo(checkDto.getPrpLcheckDto().getRegistNo());
			}
			swfLogDtoDealNode.setNodeStatus(checkDto.getPrpLclaimStatusDto().getStatus());
			swfLogDtoDealNode.setNextBusinessNo(checkDto.getPrpLcheckDto().getRegistNo());
			WorkFlowDto workFlowDto = null;
			
			//swfLogDtoDealNode.setKeyIn(checkDto.getPrpLcheckDto().getRegistNo());
			swfLogDtoDealNode.setKeyOut(checkNo);
			//回访是查勘提交过来的回访,没有typeflag的值,1表示查勘回访，2表示定损回访
			swfLogDtoDealNode.setTypeFlag("1");
			//swfLogDtoDealNode.setLossItemName("lossItemName");
			
//			Collection nextNodeList = new ArrayList();  
//			if("Z".equals(riskType)||"Q".equals(riskType)){//由于责任险流程现在不是根据查勘处录入的信息判断是走人伤定损或者财产定损，而是只有财产定损，而且查堪环节也不录入损失信息，所以写死
//				SwfLogDto swfLogNextNode = new SwfLogDto();               
//				swfLogNextNode.setNodeNo(0);  
//				swfLogNextNode.setNodeType("certa");               
//				swfLogNextNode.setLossItemCode("-1");
//				nextNodeList.add(swfLogNextNode); //LossItemCode: 0 表示定损，-1 表示财产，-2 表示人伤
//			}
//			if (nextNodeList.size() >0){
//				swfLogDtoDealNode.setNextNodeListType("1");//如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
//				swfLogDtoDealNode.setSwfLogList(nextNodeList);
//			}
			/*
			//因为人到人的原因
			
			//modify by liujianbo modify start 2005-10-19
			//if (swfLogDtoDealNode.getNodeStatus().equals("4")){  
			Collection nextNodeList = new ArrayList();           
			//}
			//modify by liujianbo modify end 2005-10-19
			
			
			//[只保三者险则不产生标的车定核损流程]------------------------------------------------
			RegistDto  registDto = new RegistDto();
			UIRegistAction  uiRegistAction =new UIRegistAction();
			registDto = uiRegistAction.findByPrimaryKey(checkNo);
			String  damageDate = String.valueOf(registDto.getPrpLregistDto().getDamageStartDate());
			String  damageHour = registDto.getPrpLregistDto().getDamageStartHour();
			String  policyNo   = registDto.getPrpLregistDto().getPolicyNo();
			String kindCode ="";
			String kindAFlag ="0";  //出险时有无保车损险的标志 1：有 0：无
			String kindBFlag ="0";  //出险时有无保三者险的标志 1：有 0：无
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			// 根据出险时间找到保单
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,damageDate,damageHour);
			

            ArrayList  prpCitemKindDtoList =new ArrayList();
            prpCitemKindDtoList =  policyDto.getPrpCitemKindDtoList(); 
            if ( prpCitemKindDtoList!=null && prpCitemKindDtoList.size()>0){
			   for ( int k =0; k<prpCitemKindDtoList.size();k++){
				  PrpCitemKindDto prpCitemKindDto =(PrpCitemKindDto) prpCitemKindDtoList.get(k);
				  kindCode = prpCitemKindDto.getKindCode();
				  if (kindCode.equals("A")) {
				  	  kindAFlag ="1";				  	  
				  }
				  //modify by lixiang start 2006-6-18 //reason:新增加了强三。
				  if (kindCode.equals("B") || kindCode.equals("B1")|| kindCode.equals("BZ")) {
//				  modify by lixiang end 2006-6-18
				  	  kindBFlag ="1";
				  }
				
			   }
            }
			
           //
            // 　如果有关联的强制保险保单，也认为是投保了三者险
            //
            if(new BLPrpLRegistRPolicyFacade().getCompelFlag(registDto.getPrpLregistDto().getRegistNo())){
            	kindBFlag = "1";
            }
            
			System.out.println("================[  kindAFlag ][  有无车损险标志 1：有 0：无 ]=====" +kindAFlag);
			System.out.println("================[  kindBFlag ][  有无三者险标志 1：有 0：无 ]=====" +kindBFlag);
			
			//----------------------------------------------------------------------------------
			
			//modify by wangli add 200505016
			//reason:此处判断如果为意健险 或者为 货运险，应该keyin加入 赔案号，否则为报案号
			//通过代码对照表转换riskcode
			UICodeAction uiCodeAction = new UICodeAction();
			String classCode = "";
			//判断当为 阳光 的时候取险类前两位，否则取前一位（默认为大地）
			
			//modify by wangwei modify start 2005-06-19
			//原因：先注释掉以下代码
			
			

				
                //提示至少录入一辆车信息----start---------------------
				if(    ( checkDto.getPrpLpersonTraceDtoList()==null ||  checkDto.getPrpLpersonTraceDtoList().size()<1) 
				    && ( checkDto.getPrpLthirdPropDtoList() ==null  || checkDto.getPrpLthirdPropDtoList().size()<1 )
				   ){
				 if( checkDto.getPrpLthirdPartyDtoList() != null &&  //表示是车险
                     ( checkDto.getPrpLthirdPartyDtoList().size()<2	&&  prpLthirdPartyLossFlag[1].equals("0") ) ) //或是只有标的车信息，但标的车无受损
				 {
				 	ActionMessages messages = new ActionMessages();
					messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("title.checkEdit.noCar"));
					saveMessages(httpServletRequest, messages);
					return actionMapping.findForward("success");
					
			      }
				}
				////提示至少录入一辆车信息---end-----------	
					
				//不是意健险时start----------------------------------------------------------------
				//modify by liujianbo modify start 2005-10-19
				if(checkDto.getPrpLthirdPartyDtoList()!=null&&checkDto.getPrpLthirdPartyDtoList().size()>0){    //有几辆车
					for(int i=0;i<checkDto.getPrpLthirdPartyDtoList().size();i++){
						PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)checkDto.getPrpLthirdPartyDtoList().get(i);
						if (kindAFlag.equals("0") && prpLthirdPartyDto.getInsureCarFlag().equals("1")){ //当没保车损险时，不产生车损险定损任务
							continue;
						}
						if (kindBFlag.equals("0") && prpLthirdPartyDto.getInsureCarFlag().equals("0")){ //当没保三者险，但报案或查勘中录了三者车时，不产生三者险定损任务
							continue;
						}
						if ( prpLthirdPartyLossFlag[1].equals("0") &&prpLthirdPartyDto.getInsureCarFlag().equals("1") ){ //标的车没受损，担保了车损险,不产生标的车定损
							continue;
						}
						
						
						
						SwfLogDto swfLogNextNode = new SwfLogDto();
						String nextHandlerCode1 = httpServletRequest.getParameter("nextHandlerCode1");
						String nextHandlerName1= httpServletRequest.getParameter("nextHandlerName1");                
						swfLogNextNode.setNodeNo(0);  
						swfLogNextNode.setNodeType("certa");              
						swfLogNextNode.setHandlerCode(nextHandlerCode1);
						swfLogNextNode.setHandlerName(nextHandlerName1);
						swfLogNextNode.setLossItemCode(String.valueOf(prpLthirdPartyDto.getSerialNo())); 
						
						//保存车牌的号码 
						swfLogNextNode.setLossItemName(prpLthirdPartyDto.getLicenseNo());
						
						//保存是否保单车辆的标志  
						swfLogNextNode.setInsureCarFlag(String.valueOf(prpLthirdPartyDto.getSerialNo())) ;
						nextNodeList.add(swfLogNextNode);  
					}    
				} 
				if(checkDto.getPrpLpersonTraceDtoList()!=null&&checkDto.getPrpLpersonTraceDtoList().size()>0){ //有几个人
					SwfLogDto swfLogNextNode = new SwfLogDto();
					String nextHandlerCode1 = httpServletRequest.getParameter("nextHandlerCode1");
					String nextHandlerName1= httpServletRequest.getParameter("nextHandlerName1");                
					swfLogNextNode.setNodeNo(0);  
					swfLogNextNode.setNodeType("wound");              
					swfLogNextNode.setHandlerCode(nextHandlerCode1); 
					swfLogNextNode.setLossItemCode("0");
					swfLogNextNode.setHandlerName(nextHandlerName1);
					nextNodeList.add(swfLogNextNode);  
				}  
				if(checkDto.getPrpLthirdPropDtoList()!=null&&checkDto.getPrpLthirdPropDtoList().size()>0){ //有几个财产
					SwfLogDto swfLogNextNode = new SwfLogDto();
					String nextHandlerCode1 = httpServletRequest.getParameter("nextHandlerCode1");
					String nextHandlerName1= httpServletRequest.getParameter("nextHandlerName1");                
					swfLogNextNode.setNodeNo(0);  
					swfLogNextNode.setNodeType("propc");               
					swfLogNextNode.setHandlerCode(nextHandlerCode1);
					swfLogNextNode.setHandlerName(nextHandlerName1);
					swfLogNextNode.setLossItemCode("-1");
					nextNodeList.add(swfLogNextNode);  
				}   
				if (nextNodeList.size() >0){
					swfLogDtoDealNode.setNextNodeListType("1");//如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
					swfLogDtoDealNode.setSwfLogList(nextNodeList);
				}
				*/
				//modify by liujianbo modify end 2005-10-19
				swfLogDtoDealNode.setKeyIn(checkDto.getPrpLcheckDto().getRegistNo());	
				workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
		           
		       //修改查勘通知调度的方式
		           UIWorkFlowAction uiWorkFlowAction  = new UIWorkFlowAction ();
		           //通知调度
		           if ("4".equals(swfLogDtoDealNode.getNodeStatus())&&"1".equals(activeSchedule)){
		              if (workFlowDto.getUpdateSwfLogDto()!=null){
		                	String flowID=workFlowDto.getUpdateSwfLogDto().getFlowID();
		                 		//查找没有完成的调度，比如正在处理的调度
		                 		String conditonss="flowId='"+flowID+"' and nodeType='sched' and nodestatus='2'";
		                 		Collection schedList = uiWorkFlowAction.findNodesByConditions(conditonss);
		                 		if (schedList!=null&&schedList.size() >0){
		                 			SwfLogDto swfLogDto1 = new SwfLogDto();
		                 			swfLogDto1 =(SwfLogDto) schedList.iterator().next() ;
		                 			swfLogDto1.setNodeStatus( "0");
		                 			swfLogDto1.setHandlerCode( "");
		                 			swfLogDto1.setHandlerName( "");
		                 			swfLogDto1.setTypeFlag("15");
		                 		    swfLogDto1.setFlowInTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND ).toString()  );
		                 			workFlowDto.setUpdateSwfLog2Dto( swfLogDto1);
		                 		  }
		                    }
		            }
		           //    不通知调度     
		           if ("4".equals(swfLogDtoDealNode.getNodeStatus())&&"0".equals(activeSchedule)){
		            //如果为查勘提交，则判断是不是需要通知调度的选项, activeSchedule.equals( "0")说明不需要通知调度的
		           	//虽然不需要通知，但是需要判断是否所有的调度都已经做完了，如果做完了，则需要结束调度任务
		           	  if (workFlowDto.getUpdateSwfLogDto()!=null){
		                	String flowID=workFlowDto.getUpdateSwfLogDto().getFlowID();
		                 		//查找没有完成的调度，比如正在处理的调度
		                 		String conditonss="flowId='"+flowID+"' and nodeType='sched' and nodestatus<'4'";
		                 		Collection schedList = uiWorkFlowAction.findNodesByConditions(conditonss);
		                 		if (schedList!=null&&schedList.size() >0){
		                 			String strSql=" registno='"+checkDto.getPrpLcheckDto().getRegistNo()+"' and surveyTimes<1";
		           	                UIScheduleAction uiScheduleAction = new UIScheduleAction();
		           	                Collection scheduleItemList =uiScheduleAction.findItemByConditions(strSql);
		           	                if (scheduleItemList !=null && scheduleItemList.size() >0){
		           	        	        //没有完成调度呢。。
		           	        	        System.out.println("没有完成调度呢。。");
		           		               workFlowDto.setUpdateSwfLog2Dto(null);
		           	                }else{
		           	                    
		           	                    //如果查勘新增加了调度的数据呢？ 那也不能结束的
		           	                    //add by lixiang start 2005-10-18
		           	                    //reason:如果调度增加标的，还会引起调度提交操作
		           	                    if (checkDto.getPrpLscheduleItemDtoList()==null || checkDto.getPrpLscheduleItemDtoList().size()==0){
		           	                        //modify by liyanjie 2005-12-21 start
		           	                    	//由于双代的缘故，整理查勘对象时，checkDto.prpLscheduleItemDtoList只保存了新增的项目，
		           	                    	//所以不用按原来的方法判断，直接看checkDto.getPrpLscheduleItemDtoList.size是否为0就可以了
		           	                    	//strSql=" registno='"+checkDto.getPrpLcheckDto().getRegistNo()+"'";
		           	                    	//if (checkDto.getPrpLscheduleItemDtoList().size()==uiScheduleAction.findScheduleItemCountByConditon(strSql))
		           	                    		//modify by liyanjie 2005-12-21 end
		           	                             SwfLogDto swfLogDto2 = new SwfLogDto();
		                 			             swfLogDto2 =(SwfLogDto) schedList.iterator().next() ;
		                 			             swfLogDto2.setNodeStatus( "4");
		                 			             workFlowDto.setUpdateSwfLog2Dto( swfLogDto2);
		                 			        }
		                 		     }
		           	                
		           	           }
		                 }
		           }
		           
		           //
		      
			//保存查勘信息
			UICheckAction uiCheckAction = new UICheckAction();
			UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
			/*
			 if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate()) ||(workFlowDto.getSubmit())||(workFlowDto.getClose()))
			 {
			 uiCheckAction.save(checkDto,certainLossDto,workFlowDto);
			 user.setUserMessage(checkNo);
			 } else {
			 if (insureCarFlag.equals("1") ) uiCheckAction.save(checkDto,certainLossDto);
			 user.setUserMessage(checkNo+";注意:没有发现与工作流流程相关任何数据！！");
			 }
			 */
			
		//保存调查信息
			if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate()) ||(workFlowDto.getSubmit())||(workFlowDto.getClose()))
			{ 
				uiCheckAction.save(checkDto,certainLossDto,workFlowDto);
				//保存定损信息
				if("H".equals(riskType)){
					uiVerifyLossAction.save(verifyLossDto);
				}
			
				user.setUserMessage(checkNo);
			} else {
				if (insureCarFlag.equals("1") ) uiCheckAction.save(checkDto,certainLossDto );
				user.setUserMessage(checkNo+";注意:没有发现与工作流流程相关任何数据！！");
			}
			
			//httpServletRequest.setAttribute("messagepagevalue",checkNo) ;
			httpServletRequest.setAttribute("prpLcheckDto",checkDto.getPrpLcheckDto() ) ;
			//}
			String checkSaveMessage = "q"+checkNo;
			System.out.println(checkSaveMessage);
			ActionMessages messages = new ActionMessages();
			Object obj_msg = checkSaveMessage;
			
			//意健险和非意健险在查勘环节提示不同的信息 2005-09-05
			//if ("27".equals(riskCode.substring(0,2)) || "26".equals(riskCode.substring(0,2))) {  
			//modify by   项目组  孙兆云  险类27改为07
			if ("H".equals(riskType)||"E".equals(riskType)) {
			//if ("07".equals(riskCode.substring(0,2)) || "06".equals(riskCode.substring(0,2))) {
				if(httpServletRequest.getParameter("buttonSaveType").trim().equals("4")){
					//修改查勘提示。去除调查了。add by xiatian
					messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.check.submit"));
				}else {
					//修改查勘提示。去除调查了。add by xiatian
					messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.check.save"));
				}
			} else {
				if(httpServletRequest.getParameter("buttonSaveType").trim().equals("4")){
					messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.check.submit"));
				}else {
					messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.check.save"));
				}
			}		
			
			//查勘保存后自动调度 开始
			if("1".equals(autoScheduleFlag) && "D".equals(riskType) ){				
				//1.取调度信息的大对象，调度id（scheduleID）用1
				UIScheduleAction uiScheduleAction = new UIScheduleAction();
			    ScheduleDto scheduleDto = uiScheduleAction.findByPrimaryKey(1,checkNo);
				//2.工作流各节点的处理
				boolean finishSchedule = true;// 是否完成调度
				//2.1取调度节点
				String strWhere = " flowid = '" + swfLogFlowID + "' and nodeType = 'sched'";
				String scheduleHandlerCode = "";
				String scheduleHandlerName = "";
				BLSwfLogFacade blSwflogFacade 		= new BLSwfLogFacade();
				SwfLogDto swfLogDtoScheduleNode 	= new SwfLogDto();
				Collection swflogCollection = blSwflogFacade.findByConditions(strWhere);
				if(swflogCollection.size() == 1){
					swfLogDtoScheduleNode = (SwfLogDto)swflogCollection.iterator().next();
					swfLogDtoScheduleNode.setNodeStatus(scheduleDto.getPrpLclaimStatusDto().getStatus());
					swfLogDtoScheduleNode.setNextBusinessNo(checkNo);
					scheduleHandlerCode = swfLogDtoScheduleNode.getHandlerCode();//记录下调度节点的处理员
					scheduleHandlerName = swfLogDtoScheduleNode.getHandlerName();
					
					//2.2新增定损节点
					Collection nextNodeList = new ArrayList();
					PrpLscheduleItemDto prplScheduleItemDto = new PrpLscheduleItemDto();
					String prplScheduleComCode = scheduleDto.getPrpLscheduleMainWFDto().getScheduleObjectID();
				    String prplScheduleComName = scheduleDto.getPrpLscheduleMainWFDto().getScheduleObjectName();
					for(int i = 0; i < scheduleDto.getPrpLscheduleItemDtoList().size(); i++){
						prplScheduleItemDto = (PrpLscheduleItemDto)scheduleDto.getPrpLscheduleItemDtoList().get(i);
						if (prplScheduleItemDto.getSurveyTimes() == 0) {
			                  SwfLogDto swfLogNextNode = new SwfLogDto();
			                  swfLogNextNode.setNodeNo(0);
			                  swfLogNextNode.setNodeType(prplScheduleItemDto.getNextNodeNo());
			                  swfLogNextNode.setHandlerCode("");
			                  swfLogNextNode.setHandlerName("");
			                  //保存调度号码和itemitemNo的号码
			                  swfLogNextNode.setScheduleID(prplScheduleItemDto.getScheduleID()) ;
			                  swfLogNextNode.setLossItemCode(prplScheduleItemDto.getItemNo() + "");
				              //保存车牌的号码
				              swfLogNextNode.setLossItemName(prplScheduleItemDto.getLicenseNo());
				              //保存是否保单车辆的标志
				              swfLogNextNode.setInsureCarFlag(prplScheduleItemDto.getInsureCarFlag()) ;
			                  //紧急标志位
			                  swfLogNextNode.setExigenceGree(prplScheduleItemDto.getExigenceGree());
			                  swfLogNextNode.setNewHandleDept(prplScheduleComCode);
			                  
			                  nextNodeList.add(swfLogNextNode);
			               }
					}
					//有需要新增调度的节点时，才进行自动调度
					if (nextNodeList.size() >0){
						swfLogDtoScheduleNode.setNextNodeListType("1");//如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
						swfLogDtoScheduleNode.setSwfLogList(nextNodeList);
						
						//3.处理定损调度数据(prpLscheduleItem)，查勘调度数据(prpLscheduleMainWF)不用处理
					    PrpLscheduleItemDto prpLscheduleItemDto = new PrpLscheduleItemDto();
					    for(int i = 0; i < scheduleDto.getPrpLscheduleItemDtoList().size(); i++){
					    	prpLscheduleItemDto = (PrpLscheduleItemDto)scheduleDto.getPrpLscheduleItemDtoList().get(i);
					    	if(prpLscheduleItemDto.getSurveyTimes() == 0){
					    		prpLscheduleItemDto.setSurveyTimes(1);
					    		prpLscheduleItemDto.setScheduleObjectID(prplScheduleComCode);
					    		prpLscheduleItemDto.setScheduleObjectName(prplScheduleComName);
					    		prpLscheduleItemDto.setOperatorCode(user.getUserCode());
					    		if("".equals(prpLscheduleItemDto.getExigenceGree()) || prpLscheduleItemDto.getExigenceGree() == null){
					    			prpLscheduleItemDto.setExigenceGree("1");//案件状态1：一般案件，0：紧急案件
					    		}
					    	}
					    }
					    
					    //4. 半流程的特殊处理 
						WorkFlowDto workFlowDtoSchedule = workFlowViewHelper.viewToDto(user,swfLogDtoScheduleNode);
						
						// 上一步对工作流的处理将调度节点的处理员更新为当前提交查勘节点的处理员，此处将其还原为原来的处理员
						workFlowDtoSchedule.getUpdateSwfLogDto().setHandlerCode(scheduleHandlerCode);
						workFlowDtoSchedule.getUpdateSwfLogDto().setHandlerName(scheduleHandlerName);
						
						//5.保存调度及工作流信息
						 if ((workFlowDtoSchedule.getCreate()) || (workFlowDtoSchedule.getUpdate())
								|| (workFlowDtoSchedule.getSubmit())
								|| (workFlowDtoSchedule.getClose())) {
							uiScheduleAction.save(scheduleDto, workFlowDtoSchedule);
						} else {
							uiScheduleAction.save(scheduleDto, workFlowDtoSchedule);
							user.setUserMessage("报案号:" + checkNo
									+ ";注意:没有发现与工作流流程相关任何数据！！");
						}
					    messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.schedule.submit"));
				    }	
				}				
			}
			// 查勘保存后自动调度 结束
			
			messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLregist.registNo"));
			saveMessages( httpServletRequest, messages );
			// 跟据配置项 SCHEDULE_AUTOCOMMIT，对于需要自动跳转到调度的部门加入自动跳转的功能
			String strSchedule = AppConfig.get("sysconst.SCHEDULE_AUTOCOMMIT");
			String comCodeTemp = user.getComCode().substring(0,4);
//			System.out.println("------自动跳转判断-----"+strSchedule+"---comCode---"+comCodeTemp+"---index---"+strSchedule.indexOf(comCodeTemp));
			//if(strSchedule.indexOf(comCodeTemp)>=0){
			//需要自动跳转
			//System.out.println("------需要自动跳转-----");
			// httpServletResponse.sendRedirect("/claim/certainLossBeforeEdit.do?RegistNo="+checkNo+"&editType=SelectLossType");
			//<a href="/claim/scheduleDealRegist.do?prpLscheduleMainWFRegistNo=RDAA200431000000000044&editType=ADD&prpLscheduleMainWFSurveyNo=1">  RDAA200431000000000044 </a>
			//}else{
			//不需要自动跳转
			//调查保存向理赔清单回写报案号
			if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3149,3150,3148,3174,3151,3197,3185,3165,3166,3184,3152,3153,3154,3155,3156,3228,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3179,3158,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3177,3163,3168,3169,3182".indexOf(riskCode) > -1)){
				if(!"".equals(settleListCode)&&null!=settleListCode){
				BLSettlemainlistFacade blSettlemainlistFacade=new BLSettlemainlistFacade();
				SettlemainlistDto settlemainlistDto =new SettlemainlistDto();
				settlemainlistDto=blSettlemainlistFacade.findByPrimaryKey(settleListCode);
				settlemainlistDto.setReportcode(registno);
				blSettlemainlistFacade.update(settlemainlistDto);
				}
			}
			if("2801".indexOf(riskCode) > -1 || "2607".indexOf(riskCode) > -1 || "2605".indexOf(riskCode) > -1 || "2606".indexOf(riskCode) > -1|| "2609".indexOf(riskCode) > -1)
			{
				if(!"".equals(settleListCode)&&null!=settleListCode){
					BLSettlemainlistFacadeForMedical blSettlemainlistFacadeForMedical=new BLSettlemainlistFacadeForMedical();
					SettlemainlistDto settlemainlistDto =new SettlemainlistDto();
					settlemainlistDto=blSettlemainlistFacadeForMedical.findByPrimaryKey(settleListCode);
					settlemainlistDto.setReportcode(registno);
					blSettlemainlistFacadeForMedical.update(settlemainlistDto);
					}
			}
			forward = "success";
			// }
			
		}
		catch(UserException usee)
		{
			usee.printStackTrace() ;
			//错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.registBeforeEdit.editRegist");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
			saveErrors(httpServletRequest, errors);
			forward = "error";
			
		}
		catch(SQLException sqle)
		{
			StringWriter stringWriter = new StringWriter();
			sqle.printStackTrace(new PrintWriter(stringWriter));
			sqle.printStackTrace();
			//错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.registBeforeEdit.editRegist");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage",stringWriter.toString() ) ;
			saveErrors(httpServletRequest, errors);
			forward = "error";
		}
		catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.registBeforeEdit.editRegist");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage",stringWriter.toString()) ;
			saveErrors(httpServletRequest, errors);
			forward = "error";
			
		}
		
		//Log.info(this.getClass().getName(), "END");
		return actionMapping.findForward(forward);
	}
}
