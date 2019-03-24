package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.gyic.claim.bl.facade.BLSettlemainlistFacade;
import com.gyic.claim.bl.facade.BLSettlemainlistFacadeForMedical;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.sinosoft.claim.Tools.RiskCodeTools;
import com.sinosoft.claim.bl.action.domain.BLPrpLpropAction;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.ClaimStatusDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpClimitDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLprop;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UIClaimStatusAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIConfigAction;
import com.sinosoft.claim.ui.control.action.UIDeductCondAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPrpClimitAction;
import com.sinosoft.claim.ui.control.action.UIPrpLregistRPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAClaimViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAARegistViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
/**
 * 分发HTTP GET 车险理赔立案前查询保单/立案报案请求
 * <p>
 * Title: 车险理赔立案前查询保单/立案报案信息
 * </p>
 * <p>
 * Description: 车险理赔报案前查询保单信息系统
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author weishixin modify lixiang
 * @version 1.0
 */
public class UILClaimBeforeEditGetFacade extends Action {
    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        // 业务类型：ADD-新增 EDIT-修改 SHOW-显示 CANCEL-注销
        String editType = httpServletRequest.getParameter("editType"); // 操作类型
        httpServletRequest.setAttribute("editType", editType);
        String riskCode = httpServletRequest.getParameter("riskCode"); // 险种
        String policyNo = httpServletRequest.getParameter("policyNo"); // add by lym 20060605 for 强三 
        String type = httpServletRequest.getParameter("type");
        httpServletRequest.setAttribute("type", type);
       
        String editForward = editType; // 操作跳转
        String claimNo = ""; // 赔案号
        String registNo = ""; // 报案号
        String forward = ""; // 向前
        String strSql = ""; // 查询条件
        String msg = ""; // 抛出错误的信息的具体内容
        String riskClass = ""; //险类 2005-08-08
        String businessFlag  = "0";//分入标志
        Integer modelnoInt = 0;//模版号

        try {
            HttpSession session = httpServletRequest.getSession();
            UserDto user = (UserDto) session.getAttribute("user");

            // 3 立案注销和拒赔的赔案号验证
            if (editType.equals("CANCEL")) {
                DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
                // 查询立案信息的拒赔过程
                dAAClaimViewHelper.cancelDtoToView(httpServletRequest, user);
                forward = editType + "DAA";
                riskClass = riskCode.substring(0,2);
                httpServletRequest.setAttribute("com.sinosoft.type", riskClass);
                return actionMapping.findForward(forward);
            }
            if (editType.equals("UNCANCEL")) {
                DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
                // 查询立案信息的拒赔过程
                dAAClaimViewHelper.nucancelDtoToView(httpServletRequest);
                forward = "CANCELDAA";
                riskClass = riskCode.substring(0,2);
                httpServletRequest.setAttribute("com.sinosoft.type", riskClass);
                return actionMapping.findForward(forward);
            }

            // 4 立案注销和拒赔的受理
            if (editType.equals("CANCELEDIT")) {
                DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
                // 查询立案信息的拒赔过程
                dAAClaimViewHelper.cancelDtoToCancelView(httpServletRequest, user);
                forward = "CANCELDAA";
                riskClass = riskCode.substring(0,2);
                httpServletRequest.setAttribute("com.sinosoft.type", riskClass);
                return actionMapping.findForward(forward);
            }
            
            //添加意健险不予立案的处理 2005-09-06
            if ("NOTGRANDCLAIM".equals(editType)) {
            	 DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
                 dAAClaimViewHelper.notGrandClaimDtoToView(httpServletRequest, user);
                 forward = "NOTGRANDCLAIM";
                 return actionMapping.findForward(forward);
            }

            // 尚未加入type异常处理{}、其它必须参数异常处理{}
            if (editType.equals("ADD")) {
                // 查询报案信息,整理输入，用于初始界面显示
                registNo = httpServletRequest.getParameter("RegistNo");// 报案号
                if (riskCode == null || riskCode.length() < 1 || riskCode.trim().equals("")) {
                    riskCode = BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
                }
                // 若是倒签单，在起保日期到签单日期之间提示不能报案，这个控制是硬控制
                UIRegistAction uiRegistAction = new UIRegistAction();
                RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
                httpServletRequest.setAttribute("registDto",registDto );
                //区分上海平台意健险平台上传;
                String classCode = registDto.getPrpLregistDto().getClassCode();
                String comCode = registDto.getPrpLregistDto().getComCode().substring(0, 2);
                httpServletRequest.setAttribute("classCode", classCode);
                httpServletRequest.setAttribute("comCode", comCode);
            	httpServletRequest.setAttribute("prpCmainDto", classCode);	
              //向页面放置理赔清单号
    			String conditions1=" reportcode='"+registNo+"' and validity='2'";
    			BLSettlemainlistFacade blSettlemainlistFacade=new BLSettlemainlistFacade();
    			Collection blSettlemainlist=new ArrayList();//blSettlemainlistFacade.findByConditions(conditions1);
    			String settleListCode="";
    			SettlemainlistDto settlemainlistDto=new SettlemainlistDto();
    			if(blSettlemainlist.size()>0){
    				settlemainlistDto=(SettlemainlistDto)blSettlemainlist.iterator().next();
    				settleListCode=settlemainlistDto.getSettlelistcode();
    			}else{
    				settleListCode="";
    			}
    			if("2801".indexOf(riskCode) > -1)
    			{
    				BLSettlemainlistFacadeForMedical blSettlemainlistFacadeForMedical=new BLSettlemainlistFacadeForMedical();
    				Collection blSettlemainlistForMedical=blSettlemainlistFacadeForMedical.findByConditions(conditions1);
    				SettlemainlistDto settlemainlistDtoForMedical=new SettlemainlistDto();
    				if(blSettlemainlistForMedical.size()>0){
    					settlemainlistDtoForMedical=(SettlemainlistDto)blSettlemainlistForMedical.iterator().next();
        				settleListCode=settlemainlistDtoForMedical.getSettlelistcode();
        			}else{
        				settleListCode="";
        			}
    			}
    			httpServletRequest.setAttribute("settleListCode", settleListCode);
                UICodeAction uiCodeAction = new UICodeAction();
                UIPolicyAction uiPolicyAction = new UIPolicyAction();
                String strRiskType = uiCodeAction.translateRiskCodetoRiskType(registDto.getPrpLregistDto().getRiskCode());
                httpServletRequest.setAttribute("riskType", strRiskType);
                EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
                //modify by lym 20060605 for 强三 --start
				PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
						policyNo, registDto.getPrpLregistDto()
								.getDamageStartDate().toString(), registDto
								.getPrpLregistDto().getDamageStartHour());
               
            	httpServletRequest.setAttribute("prpCmainDto", policyDto.getPrpCmainDto());	
            	httpServletRequest.setAttribute("statQuantity", policyDto.getPrpCmainDto().getStatQuantity());
            	//分入标志
            	if(policyDto.getPrpCmainDto()!=null){
            		businessFlag = policyDto.getPrpCmainDto().getBusinessFlag();
            	}
            	httpServletRequest.setAttribute("businessFlag", businessFlag);
               
			   if("D".equals(strRiskType)){
					
//					 new 取事故责任免赔率------------------
					Map map = new HashMap();
					Map mapList = new HashMap();
					String kindCode = "";
					String modeCode = "";
					DateTime validDate = policyDto.getPrpCmainDto().getStartDate();
					UIDeductCondAction uiDeductCondAction = UIDeductCondAction
							.getInstance();
					if (riskCode.substring(0, 2).equalsIgnoreCase("05")
							|| "3119".equals(riskCode)) {
						for (int i = 0; i < policyDto.getPrpCitemKindDtoList()
								.size(); i++) {
							PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) policyDto
									.getPrpCitemKindDtoList().get(i);
							kindCode = prpCitemKindDto.getKindCode();
							modeCode = prpCitemKindDto.getModeCode();
							Map mapp = uiDeductCondAction
									.getDeductibleRateOfAccident(riskCode,
											kindCode, modeCode, validDate
													.toString());
							mapList.put(kindCode, mapp);

						}
						httpServletRequest.setAttribute("mapList", mapList);
					}
					// 取限额---------------------------
					double amount = 0;
					String strKindCode = "";
					Map amountMap = new HashMap();
					
					PolicyDto policyDto1 = uiPolicyAction
							.findByPrimaryKey(policyNo);
					ArrayList limitlist = policyDto.getPrpCitemKindDtoList();
					Iterator it = limitlist.iterator();
					if (limitlist != null && limitlist.size() > 0) {
						while (it.hasNext()) {
							PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) it
									.next();
							strKindCode = prpCitemKindDto.getKindCode();
							amount = prpCitemKindDto.getAmount();
							amountMap.put(strKindCode, String.valueOf(amount));
						}
					}
					httpServletRequest.setAttribute("amountMap", amountMap);
					// 取强制保单限额----------------------------------------------
	               
	                String configCode = uiCodeAction.translateRiskCodetoConfigCode(riskCode);
	             
	                Map limitMap = new HashMap();
	                if ("RISKCODE_DAZ".equals(configCode)||"RISKCODE_DAY".equals(configCode)
	                		||"RISKCODE_DAU".equals(configCode)){
	                   UIPrpClimitAction  uiPrpClimitAction =new UIPrpClimitAction(); 
	                  Collection limitList= uiPrpClimitAction.findByConditions(" policyNo='" +policyNo +"'");
	                 
	                  String limitType="";
	                  double limitFee=0;
	                  if ( limitList != null && limitList.size()>0){
	                      Iterator mapit =limitList.iterator();
	                      while (mapit.hasNext()){
	                     	PrpClimitDto  prpClimitDto =(PrpClimitDto)mapit.next();
	                     	limitType = prpClimitDto.getLimitType();
	                     	limitFee =  prpClimitDto.getLimitFee()  ;
	                     	limitMap.put(limitType,String.valueOf(limitFee));	
	                      }
	                    }
	                 }
	                httpServletRequest.setAttribute("limitMap",limitMap ); 
	                httpServletRequest.setAttribute("configCode",configCode );
                    //modify by lym 20060606 for 强三 --end
	                

				}
				//**************判断保费是否已经实收add by qinyongli 2005-7-21
                //UIPolicyAction uiPolicyAction = new UIPolicyAction();
                String conditions = " policyno = '" + policyDto.getPrpCmainDto().getPolicyNo() + "'";
                int intReturn = 0;
                intReturn = uiPolicyAction.checkPay(conditions);//-1为未缴费，0为未缴全，1为缴全
                String strPayFlag = String.valueOf(intReturn);
                httpServletRequest.setAttribute("payFlag",strPayFlag);

                /**
                 * modify by mengdongdong start
                 * resion:当缴费不足时,要显示相应的缴费情况
                 * 2006-1-19
                 */
        		//欠费情况
        		String delinquentfeeCase = "";
        		//若费用未缴全,则针对分期付款的情况要提示哪几期费用未缴
        		if(intReturn == -2 && policyDto.getPrpCmainDto().getPayTimes()>1){			
        			delinquentfeeCase = new DAARegistViewHelper().getDelinquentfeeCase(policyDto.getPrpCmainDto());
        		}
        		//设置分期付款未缴期数
        		httpServletRequest.setAttribute("delinquentfeeCase",delinquentfeeCase);
                
                PrpLregistDto prpLregistDto = new PrpLregistDto();
                prpLregistDto.setPayFlag(intReturn+"");
                httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
                /**
                 * modify by mengdongdong end
                 * resion:当缴费不足时,要显示相应的缴费情况
                 * 2006-1-19
                 */
                
                //获取系统设置信息
                UIConfigAction uiConfigAction = new UIConfigAction();
                String configValue = "" ; //获取保费未实收是否立案信息
                configValue = uiConfigAction.getConfigValue("ALLOW_UNPAYED_CLAIM",policyDto.getPrpCmainDto().getRiskCode());
                //报案出险延期天数
                String standard_stringDays = uiConfigAction.getConfigValue("REPORT_DEFER_DAYS",policyDto.getPrpCmainDto().getRiskCode());
                if(configValue==null||configValue.equals("")){
                	throw new UserException(1,3,"platform","" +
                			"请联系系统管理员，在平台配置系统中进行险种"+policyDto.getPrpCmainDto().getRiskCode()+"'保费未实收是否允许立案'的初始化！");
                }
                if(standard_stringDays==null||standard_stringDays.equals("")){
                	throw new UserException(1,3,"platform","" +
                			"请联系系统管理员，在平台配置系统中进行险种"+policyDto.getPrpCmainDto().getRiskCode()+"'报案出险延期天数'的初始化！");
                }
                long standard_days =Long.parseLong(standard_stringDays);
                
              
                //如果configValue =2 intReturn！=1则表示未交费不能立案
               if(configValue.equals("2")&&intReturn!=1){
                	ActionMessages messages = new ActionMessages();
                    ActionMessage message = new ActionMessage("prompt.claim.feeFailure");
                    messages.add(ActionMessages.GLOBAL_MESSAGE, message);
                    saveMessages(httpServletRequest, messages);
                    forward = "ADDDAAFALSE";
                    
                    return actionMapping.findForward(forward);
                }
                //**************判断报案出险延期天数是否大于系统规定时间，大于不允许立案 add by qinyongli 2005-7-28
                DateTime damageDate = registDto.getPrpLregistDto().getDamageStartDate();
                DateTime reportDate = registDto.getPrpLregistDto().getReportDate();
                long report_damage_days = (reportDate.getTime()-damageDate.getTime())/(1000*60*60*24);
                  //获取系统规定时间 standard_days
                if(report_damage_days>standard_days){
                	ActionMessages messages = new ActionMessages();
                    ActionMessage message = new ActionMessage("prompt.claim.report_damage_standardDays");
                    messages.add(ActionMessages.GLOBAL_MESSAGE, message);
                    saveMessages(httpServletRequest, messages);
                    forward = "ADDDAAFALSE";
                    System.out.println("判断报案出险延期天数大于系统规定时间，不允许立案！");
                    return actionMapping.findForward(forward);
                }
                //*******************************************add end 
                
                //根据保单号取得保单信息
                UIClaimAction uiClaimAction = new UIClaimAction();
                //modify by lym 20060605 for 强三 -----start
                // PrpCmainDto prpCmainDto = uiClaimAction.findByPolicyNoKey(registDto.getPrpLregistDto().getPolicyNo());
                PrpCmainDto prpCmainDto = uiClaimAction.findByPolicyNoKey(policyNo);
                //modify by lym 20060605 for 强三 -----start
                
                
                //出险时间不在保险期间内的案件，报案时系统进行提示，立案时硬控制，走拒赔或特殊案件流程。 
                if (registDto.getPrpLregistDto().getDamageStartDate().before(prpCmainDto.getStartDate())
                        || registDto.getPrpLregistDto().getDamageStartDate().after(prpCmainDto.getEndDate())) {
                  //modify  by   项目组 孙兆云   责任险判断统一封装到一个类中进行判断
               	 //if((14<Integer.parseInt(riskCode.substring(0,2))&&Integer.parseInt(riskCode.substring(0,2))<20) //判断是不是责任险
                	DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
                	boolean isOutPeriod = false;//出险时间是否在保险期间内
                	if(RiskCodeTools.IsLiab(riskCode)	//判断是不是责任险	 
                	 		&&registDto.getPrpLregistDto().getDamageStartDate().after(policyDto.getLiabStartDate())
							&&registDto.getPrpLregistDto().getDamageStartDate().before(policyDto.getPrpCmainDto().getStartDate())){
                	 	           //责任险，在追溯期内允许立案,自动跳过
                	 	  isOutPeriod = true;         
                	 }else if("05".equals(policyDto.getPrpCmainDto().getClassCode())){
                		 int[] intDamageHour = new int[2];
                		 //取出险小时、分钟，表中存储的格式为：hh:mm:ss
                		 String[] strDamageHour = registDto.getPrpLregistDto().getDamageStartHour().split(":");
                		 if(strDamageHour != null && strDamageHour.length >1){
                			 intDamageHour[0] = Integer.parseInt(strDamageHour[0]);
                			 intDamageHour[1] = Integer.parseInt(strDamageHour[1]);
                		 }else{
                			 intDamageHour[0] = 0;
                			 intDamageHour[1] = 0;
                		 }
                		 isOutPeriod = dAARegistViewHelper.checkDate(httpServletRequest,policyDto.getPrpCmainDto().getPolicyNo(), registDto.getPrpLregistDto().getDamageStartDate().toString(), intDamageHour[0],intDamageHour[1] );
                	 }

                	if(!isOutPeriod){
                		ActionMessages messages = new ActionMessages();
                        ActionMessage message = new ActionMessage("prompt.claimAdd.damageStartDate");
                        messages.add(ActionMessages.GLOBAL_MESSAGE, message);
                        saveMessages(httpServletRequest, messages);
                        forward = "ADDDAAFALSE";
                        return actionMapping.findForward(forward);
                	}
                } 
             
               
                // 首先判断该报案是否已经立过案
                uiClaimAction = new UIClaimAction();
                // 在uiCLaimAcction里自动识别是否要怎么查询的具体操作
                
                //modify by lym 20060604  for 强三  ----start
                strSql = "registNo ='" + registNo + "'  and riskcode = '" + riskCode +"'";
              
                //modify by lym 20060604  for 强三  ----end
                
                Collection claimList = new ArrayList();
               
                claimList = (Collection) uiClaimAction.findByConditions(strSql);
                // 说明查询到该报案已经立过案了
                if (claimList.size() > 0) {
                    ActionMessages messages = new ActionMessages();
                    ActionMessage message = new ActionMessage("prompt.claimAdd.false");
                    messages.add(ActionMessages.GLOBAL_MESSAGE, message);
                    saveMessages(httpServletRequest, messages);
                    forward = "ADDDAAFALSE";
                    return actionMapping.findForward(forward);
                }
               
                
                // 报案提交状态的案件才可立案
                UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction();
                ClaimStatusDto claimStatusDto = (ClaimStatusDto) uiClaimStatusAction.findByPrimaryKey(registNo,
                        "regis", 0);

                if (claimStatusDto.getPrpLclaimStatusDto() != null) {
                    if (!claimStatusDto.getPrpLclaimStatusDto().getStatus().equals("4")) {
                        ActionMessages messages = new ActionMessages();
                        ActionMessage message = new ActionMessage("prompt.claimAdd.notSubmit");
                        messages.add(ActionMessages.GLOBAL_MESSAGE, message);
                        saveMessages(httpServletRequest, messages);
                        forward = "ADDDAAFALSE";
                        return actionMapping.findForward(forward);
                    }
                }

                // 可以做立案了
                // ==================================================
                // 进行占号分析，只有当有工作流号码和LogNo的时候才能使用。
                // 如果没有flowID和logno则不进行判断。

                String flowID = httpServletRequest.getParameter("swfLogFlowID");
                System.err.println(flowID);
                String logNo = httpServletRequest.getParameter("swfLogLogNo");
                if (flowID != null  ) {
                    UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
                    modelnoInt = uiWorkFlowAction.getModelNo(riskCode, registDto.getPrpLregistDto().getComCode());
          	        if (modelnoInt.equals(1)||modelnoInt.equals(12)||modelnoInt.equals(14)||modelnoInt.equals(87)){ 
          	        	UIWorkFlowAction   uiWorkFlowActioncheck = new UIWorkFlowAction();
      	    	    	Collection noSubmitNodesList=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+flowID +"' and nodeType='sched' and nodestatus<>'0'");
      	    	    	//Collection noSubmitNodesListCheck=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+swfLogDto.getFlowID() +"' and nodeType='check' and nodestatus<'4'");
     	    	   
     	    	    if (noSubmitNodesList.size()<1) {
    	    	   //完成调度任务
     	    	    	throw new UserException(1,3,"0000","工作流"+flowID+"调度环节没有结束，不能进行立案！");
     	    	    }
     	    	    
     	       }  
                   
//         	       if (modelnoInt.equals(1)){ 
//         	    	   UIWorkFlowAction   uiWorkFlowActioncheck = new UIWorkFlowAction();
//        	    	    Collection noSubmitNodesList=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+flowID +"' and nodeType='propc' and nodestatus='4'");
//        	    	    //Collection noSubmitNodesListCheck=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+swfLogDto.getFlowID() +"' and nodeType='check' and nodestatus<'4'");
//        	    	   
//        	    	    if (noSubmitNodesList.size()<1) {
//        	    	   //完成调度任务
//        	    	    	throw new UserException(1,3,"0000","工作流"+flowID+"财产定损环节没有结束，不能进行立案！");
//        	    	    }
        	    	    
//        	       } 
//         	       if (modelnoInt.equals(12)||modelnoInt.equals(14)){ 
//         	    	   UIWorkFlowAction   uiWorkFlowActioncheck = new UIWorkFlowAction();
//        	    	    Collection noSubmitNodesList=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+flowID +"' and nodeType='check' and nodestatus='4'");
//        	    	    //Collection noSubmitNodesListCheck=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+swfLogDto.getFlowID() +"' and nodeType='check' and nodestatus<'4'");
//        	    	   
//        	    	    if (noSubmitNodesList.size()<1) {
//        	    	   //完成调度任务
//        	    	    	throw new UserException(1,3,"0000","工作流"+flowID+"查勘环节没有结束，不能进行立案！");
//        	    	    }
//        	    	    
//        	       }
//         	       if (modelnoInt.equals(87)){ 
//         	    	   UIWorkFlowAction   uiWorkFlowActioncheck = new UIWorkFlowAction();
//        	    	    Collection noSubmitNodesList=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+flowID +"' and nodeType='propv' and nodestatus='4'");
//        	    	    //Collection noSubmitNodesListCheck=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+swfLogDto.getFlowID() +"' and nodeType='check' and nodestatus<'4'");
//        	    	   
//        	    	    if (noSubmitNodesList.size()<1) {
//        	    	   //完成调度任务
//        	    	    	throw new UserException(1,3,"0000","工作流"+flowID+"财产核损环节没有结束，不能进行立案！");
//        	    	    }
//        	    	    
//        	       }
               	if(logNo != null)
            	{

                    SwfLogDto swfLogDto = new SwfLogDto();
                    swfLogDto = uiWorkFlowAction.holdNode(flowID, Integer.parseInt(logNo), user.getUserCode(), user
                            .getUserName());
                    if (swfLogDto.getHoldNode() == false) {
                        msg = "案件'" + registNo + "'已经被代码:'" + swfLogDto.getHandlerCode() + "',名称:'"
                                + swfLogDto.getHandlerName() + "'的用户所占用,请选择其它案件进行处理!";
                        throw new UserException(1, 3, "工作流", msg);
                    }
            	}
                }
                // ===============================================
                DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
                dAAClaimViewHelper.registDtoToView(httpServletRequest, registNo);
                //add by wunier 20071228
                //reason：增加与赔付数量对应的单位信息
                riskCode = policyNo.substring(1,5);
                conditions =" codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"+riskCode+"' and codetype='Unit')";
                Collection collection = uiCodeAction.findByConditions(conditions);
                httpServletRequest.setAttribute("lossesUnitCodeCollection",collection);
                //end by wunier 20071228
                //获取保单输入日期
                String policyInputDate=policyDto.getPrpCmainDto().getInputDate().toString();
                httpServletRequest.setAttribute("policyInputDate",policyInputDate );  

            }

            if (editType.equals("EDIT") || editType.equals("SHOW")) {
            	claimNo = httpServletRequest.getParameter("prpLclaimClaimNo"); // 赔案号
            	
                // 查询立案信息,整理输入，用于初始界面显示
                
                if (riskCode == null || riskCode.length() < 1 || riskCode.trim().equals("")) {
                    riskCode = BusinessRuleUtil.getRiskCode(claimNo,"ClaimNo");
                }
                UICodeAction uiCodeAction = new UICodeAction();
                String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
                UIPolicyAction uiPolicyAction = new UIPolicyAction();
                UIClaimAction uiClaimAction = new UIClaimAction();
                ClaimDto claimDto = uiClaimAction.findByPrimaryKey(claimNo);
                String conditions1 = " policyno = '" + claimDto.getPrpLclaimDto().getPolicyNo() + "'";
                int intReturn = 0;
                intReturn = uiPolicyAction.checkPay(conditions1);//-1为未缴费，0为未缴全，1为缴全
                String strPayFlag = String.valueOf(intReturn);
                httpServletRequest.setAttribute("payFlag",strPayFlag);
                policyNo = claimDto.getPrpLclaimDto().getPolicyNo();
                //向页面放置理赔清单号
    			String conditions2=" reportcode='"+claimDto.getPrpLclaimDto().getRegistNo()+"' and validity='2'";
    			BLSettlemainlistFacade blSettlemainlistFacade=new BLSettlemainlistFacade();
    			Collection blSettlemainlist=new ArrayList();//blSettlemainlistFacade.findByConditions(conditions2);
    			String settleListCode="";
    			SettlemainlistDto settlemainlistDto=new SettlemainlistDto();
    			if(blSettlemainlist.size()>0){
    				settlemainlistDto=(SettlemainlistDto)blSettlemainlist.iterator().next();
    				settleListCode=settlemainlistDto.getSettlelistcode();
    			}else{
    				settleListCode="";
    			}
    			
    			if("2801".indexOf(riskCode) > -1)
    			{
    				BLSettlemainlistFacadeForMedical blSettlemainlistFacadeForMedical=new BLSettlemainlistFacadeForMedical();
    				Collection blSettlemainlistForMedical=blSettlemainlistFacadeForMedical.findByConditions(conditions2);
    				SettlemainlistDto settlemainlistDtoForMedical=new SettlemainlistDto();
    				if(blSettlemainlistForMedical.size()>0){
    					settlemainlistDtoForMedical=(SettlemainlistDto)blSettlemainlistForMedical.iterator().next();
        				settleListCode=settlemainlistDtoForMedical.getSettlelistcode();
        			}else{
        				settleListCode="";
        			}
    			}
    			
    			httpServletRequest.setAttribute("settleListCode", settleListCode);               
                httpServletRequest.setAttribute("riskType", strRiskType);
                //--------------------------------
                UIRegistAction uiRegistAction = new UIRegistAction();
                RegistDto registDto = uiRegistAction.findByPrimaryKey(claimDto.getPrpLclaimDto().getRegistNo()); 
                if("D".equals(strRiskType)){
                	
                    EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
	                // modify  by lym 20060605 for 强三---start
	                //PolicyDto policyDto = endorseViewHelper.findForEndorBefore(registDto.getPrpLregistDto().getPolicyNo(),
	                PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,
	                        registDto.getPrpLregistDto().getDamageStartDate().toString()
							,registDto.getPrpLregistDto().getDamageStartHour());
	                // modify  by lym 20060605 for 强三----end
	//              modify by lym 20060606 for 强三 -start 
	                 //new 取事故责任免赔率------------------
	               
	            	Map mapList = new HashMap();
	                String  kindCode ="";
	                String  modeCode ="";
	                DateTime  validDate = policyDto.getPrpCmainDto().getStartDate();
	             
	                UIDeductCondAction uiDeductCondAction =UIDeductCondAction.getInstance(); 
	                for  ( int i =0; i< policyDto.getPrpCitemKindDtoList().size();i++){
	                	PrpCitemKindDto prpCitemKindDto =(PrpCitemKindDto) policyDto.getPrpCitemKindDtoList().get(i);
	                	kindCode=  prpCitemKindDto.getKindCode();
	                	modeCode=  prpCitemKindDto.getModeCode();
	                  Map map =  uiDeductCondAction.getDeductibleRateOfAccident(riskCode,kindCode,modeCode,validDate.toString());
	                	mapList.put(kindCode, map);
	                  }
	                httpServletRequest.setAttribute("mapList",mapList );  
	               
	//              modify by lym 20060606 for 强三 --end 
	               
	                // 取限额---------------------------
					double amount=0;
					String strKindCode="";
					Map amountMap = new HashMap();
					//UIPolicyAction uiPolicyAction  = new UIPolicyAction (); 
					PolicyDto policyDto1 =uiPolicyAction.findByPrimaryKey(policyNo);
					ArrayList limitlist=policyDto.getPrpCitemKindDtoList();
					Iterator it =limitlist.iterator();
					if (limitlist!=null && limitlist.size()>0){
						while(it.hasNext()){
							PrpCitemKindDto  prpCitemKindDto =(PrpCitemKindDto)it.next();
							strKindCode = prpCitemKindDto.getKindCode();
								amount =	prpCitemKindDto.getAmount();
								amountMap.put(strKindCode,String.valueOf(amount));
						}
					}
					httpServletRequest.setAttribute("amountMap",amountMap); 
					//----------------------------------------------
					  //取强制保单限额----------------------------------------------
	              
	                String configCode = uiCodeAction.translateRiskCodetoConfigCode(riskCode);
	                Map limitMap = new HashMap();
	                if ("RISKCODE_DAZ".equals(configCode)||"RISKCODE_DAY".equals(configCode)||"RISKCODE_DAU".equals(configCode)){
	                   UIPrpClimitAction  uiPrpClimitAction =new UIPrpClimitAction(); 
	                  Collection limitList= uiPrpClimitAction.findByConditions(" policyNo='" +policyNo +"'");
	                  String limitType="";
	                  double limitFee=0;
	                  if ( limitList != null && limitList.size()>0){
	                      Iterator mapit =limitList.iterator();
	                      while (mapit.hasNext()){
	                     	PrpClimitDto  prpClimitDto =(PrpClimitDto)mapit.next();
	                     	limitType = prpClimitDto.getLimitType();
	                     	limitFee =  prpClimitDto.getLimitFee()  ;
	                     	limitMap.put(limitType,String.valueOf(limitFee));	
	                      }
	                    }
	                 }
	                httpServletRequest.setAttribute("limitMap",limitMap ); 
	                httpServletRequest.setAttribute("configCode",configCode );
	            
	                //-------------------------------------------------------------
	                
                }
                /**
                 * modify by mengdongdong start
                 * resion:当缴费不足时,要显示相应的缴费情况
                 * 2006-1-19
                 */
        		PrpCmainDto cmainDto = (PrpCmainDto)new UIPolicyAction().findPrpCmainDtoByPrimaryKey(claimDto.getPrpLclaimDto().getPolicyNo());
        		//欠费情况
        		
            	httpServletRequest.setAttribute("prpCmainDto", cmainDto);	
            	//分入标志
            	if(cmainDto!=null){
            		businessFlag = cmainDto.getBusinessFlag();
            	}
            	httpServletRequest.setAttribute("businessFlag", businessFlag);
               
        		String delinquentfeeCase = "";
        		//若费用未缴全,则针对分期付款的情况要提示哪几期费用未缴
        		if(intReturn == -2 && cmainDto.getPayTimes()>1){			
        			delinquentfeeCase = new DAARegistViewHelper().getDelinquentfeeCase(cmainDto);
        		}
        		//设置分期付款未缴期数
        		httpServletRequest.setAttribute("delinquentfeeCase",delinquentfeeCase);
                PrpLregistDto prpLregistDto = new PrpLregistDto();
                prpLregistDto.setPayFlag(intReturn+"");
                httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
                
                DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
                dAAClaimViewHelper.claimDtoToView(httpServletRequest, claimNo);
                //add by wunier 20071228
                //reason：增加与赔付数量对应的单位信息
                riskCode = policyNo.substring(1,5);
                String conditions =" codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"+riskCode+"' and codetype='Unit')";
                Collection collection = uiCodeAction.findByConditions(conditions);
                httpServletRequest.setAttribute("lossesUnitCodeCollection",collection);
                //end by wunier 20071228

                
                PolicyDto policyDto = new UIPolicyAction().findByPrimaryKey(claimDto.getPrpLclaimDto().getPolicyNo());
            	String policyInputDate=policyDto.getPrpCmainDto().getInputDate().toString();
                //新危险单位取保单制单日期
                httpServletRequest.setAttribute("policyInputDate",policyInputDate );  
            }
            
            //未处理立案任务的放弃处理
            if (editType.equals("GIVUP")) {
                //add by huangyunzhong 20051226 放弃未暂存和提交的立案任务，删去结点操作人，使其他人可见可处理
                String FlowID = httpServletRequest.getParameter("swfLogFlowID");
                int  LogNo=Integer.parseInt((String)httpServletRequest.getParameter("swfLogLogNo"));
                UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
                SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(FlowID,LogNo);
                if(swfLogDto.getNodeType().equals("claim")){
                swfLogDto.setHandlerCode("");
                swfLogDto.setHandlerName("");
                swfLogDto.setFlowStatus("1");
                   }
                uiworkflowaction.updateFlow(swfLogDto);
                ActionMessages messages = new ActionMessages();
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                "prompt.compensate.giveup"));
                saveMessages(httpServletRequest, messages);
                forward = "success";
                return actionMapping.findForward(forward);
            }

            // 取得forward
            forward = BusinessRuleUtil.getForward(httpServletRequest, riskCode, "claim", editType, 1);
            // ===============================================================

            if (editType.equals("LOSS")) {
                claimNo = httpServletRequest.getParameter("prpLclaimClaimNo"); // 赔案号
                DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
                dAAClaimViewHelper.claimDtoToView(httpServletRequest, claimNo);
                forward = "ADDLOSS";
            }
            saveToken(httpServletRequest);
            
            /**大户地图信息显示控制*/
            PrpLclaimDto prpLclaimDto = (PrpLclaimDto)httpServletRequest.getAttribute("prpLclaimDto"); //报案号
            registNo = prpLclaimDto.getRegistNo();
		      if(AppConfig.get("sysconst.GIS_FAMILY_RISKCODE").indexOf(riskCode)>-1
		    		  /*SysConfig.getProperty("PLNATING_FARMER_LIST_FLAG").indexOf(riskCode)>-1
						|| SysConfig.getProperty("BREEDING_FARMER_LIST_FLAG").indexOf(riskCode)>-1
						|| "3139,3141".indexOf(riskCode)>-1*/){
		    	  /**获得大户信息*/
		    	  UIPrpLregistRPolicyAction uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction();
		    	  Collection collection = uiPrpLregistRPolicyAction.findByConditions(" Registno = '"+ registNo +"' ");
		    	  if(collection.size()>0){
		    		  PrpLRegistRPolicyDto prpLregistRPolicyDto = (PrpLRegistRPolicyDto)collection.iterator().next();
			    	  String gisPolicyNo = prpLregistRPolicyDto.getPolicyNo();
			    	  UIRegistAction uiRegistAction = new UIRegistAction();
		              RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
			    	  EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		                //modify by lym 20060605 for 强三 --start
						PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
								gisPolicyNo, registDto.getPrpLregistDto()
										.getDamageStartDate().toString(), registDto
										.getPrpLregistDto().getDamageStartHour());
			    	  String strRichFlyCode = policyDto.getPrpCmainDto().getRichFlyCode();
			    	  /**大户*/
			    	  httpServletRequest.setAttribute("GisRichFlyCode", strRichFlyCode);
			    	  /**报案号*/
			    	  httpServletRequest.setAttribute("GisRegistNo", registNo);
			    	  /**是否显示地图信息按钮*/
			    	  if(!"".equals(strRichFlyCode)){
			    		  httpServletRequest.setAttribute("IsDisplayGisViewInfo", "1");
			    	  }else{
			    		  httpServletRequest.setAttribute("IsDisplayGisViewInfo", "0");
			    	  }
			    		  
		    	  }
		      }
            
        } catch (UserException usee) {
            usee.printStackTrace();
            // 错误信息处理
            ActionErrors errors = new ActionErrors();
            ActionError error = new ActionError("title.claimBeforeEdit.editClaim");
            errors.add(ActionErrors.GLOBAL_ERROR, error);
            httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
            saveErrors(httpServletRequest, errors);
            forward = "error";
        } catch (Exception e) {
            e.printStackTrace();
            // 错误信息处理
            ActionErrors errors = new ActionErrors();
            ActionError error = new ActionError("title.claimBeforeEdit.titleName");
            errors.add(ActionErrors.GLOBAL_ERROR, error);
            httpServletRequest.setAttribute("errorMessage", e.getMessage());
            saveErrors(httpServletRequest, errors);
            forward = "error";
        } finally {
        }

        return actionMapping.findForward(forward);
    }
}
