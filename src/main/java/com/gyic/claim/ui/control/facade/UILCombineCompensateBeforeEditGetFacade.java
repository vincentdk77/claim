package com.gyic.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrpLdeductCondFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpClimitDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLdeductCondDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIDeductCondAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPrpClimitAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.AccidentCompensateViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAARegistViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.SunnyCompensateViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.prpall.bl.facade.BLPrpCmainFacade;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * 分发HTTP GET 养殖险并案处理
 * <p>
 * Title: 养殖险并案处理
 * </p>
 * <p>
 * Description: 养殖险并案处理
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author qianxiantao
 * @version 1.0  
 */
public class UILCombineCompensateBeforeEditGetFacade extends Action {
	private static Log logger = LogFactory.getLog(UILCombineCompensateBeforeEditGetFacade.class); 
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		
		//业务类型：ADD-新增 EDIT-修改 SHOW-显示 DELETE-删除
		String editType = httpServletRequest.getParameter("editType"); 
		httpServletRequest.setAttribute("editType", editType);
		String claimNo = httpServletRequest.getParameter("ClaimNo"); //赔案号
		String compensateNo = httpServletRequest.getParameter("prpLcompensateCompensateNo"); //赔款计算书号
		String riskCode = httpServletRequest.getParameter("riskCode");//险种
		String caseType = httpServletRequest.getParameter("caseType");//特殊赔案标志
		String forward = ""; //向前
		String nodeStatus  = httpServletRequest.getParameter("status");
		httpServletRequest.setAttribute("nodeStatus", nodeStatus);
	    String  strPolicyNo = "";
		String businessFlag = "0";
		String combineNo=httpServletRequest.getParameter("combineNo");
		httpServletRequest.setAttribute("combineNo", combineNo);
		String flag1=httpServletRequest.getParameter("flag1");
		httpServletRequest.setAttribute("flag1", flag1);
		String SumThisPaid=httpServletRequest.getParameter("SumThisPaid");
		httpServletRequest.setAttribute("SumThisPaid", SumThisPaid);
		String conditions1="";
		
		try {
			HttpSession session = httpServletRequest.getSession();
			UserDto user = (UserDto) session.getAttribute("user");
			UICodeAction uiCodeAction = new UICodeAction();
			
			//added by zhangli 通过赔款计算书号拿到节点状态
			UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
			//Collection arrayList = (ArrayList)uiWorkFlowAction.findCurNodeByBusinessNo(compensateNo,"compp","4","0");
			String comppStatusCondition = 
			     " BUSINESSNO='"+ compensateNo + 
		         "' AND NODETYPE ='" + "compp" +
		         "' AND NODESTATUS = '"  + "4" +
		         "' AND FLOWSTATUS = '" + "0" +"'";
			//uiWorkFlowAction
			if(uiWorkFlowAction.getCount(comppStatusCondition) > 0){
				httpServletRequest.setAttribute("comppStatus", "true");
			}			 
			if (riskCode == null || riskCode.length() < 1 || riskCode.trim().equals("")) {
				riskCode = BusinessRuleUtil.getRiskCode(claimNo,"ClaimNo");
			}
		    String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
			double sosMedicFee=0.00;  //add by lym
			httpServletRequest.setAttribute("riskType", strRiskType);
			//尚未加入type异常处理{}、其它必须参数异常处理{}
			//1.查询立案信息,整理输入，用于初始界面显示
			if (editType.equals("ADD")) {
				SunnyCompensateViewHelper sunnyCompensateViewHelper = new SunnyCompensateViewHelper();				
				ClaimDto claimDto = new UIClaimAction().findByPrimaryKey(claimNo);
				httpServletRequest.setAttribute("prpLclaimDto", claimDto.getPrpLclaimDto());  				
				BLPrpLcompensateFacade blPrpLcompensateFacade = new BLPrpLcompensateFacade();
				int count = blPrpLcompensateFacade.getCount(" claimno='" + claimDto.getPrpLclaimDto().getClaimNo() + "' and underwriteflag in ('1','3')");
                //设置缴费情况明细
				setPayCase(httpServletRequest,claimDto.getPrpLclaimDto().getPolicyNo());				
                //只有正常实赔才判断定损的
				//没有定损的案件不能进入实赔理算
				int conditionFlag = 0;
				if (!"3".equals(caseType) && !"4".equals(caseType)) {
					conditionFlag = sunnyCompensateViewHelper.checkCondition(httpServletRequest, claimNo);
				}				
				//如果不是特殊陪案，需要进行验证
				if (caseType == null || caseType.trim().length() < 1) {
					if (conditionFlag == 1) {
						ActionMessages messages = new ActionMessages();
						messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("title.compensateEidt.notClaim"));
						saveMessages(httpServletRequest, messages);
						return actionMapping.findForward("success");
					}
					//有预赔的案件复核不通过的案件不能进入实赔理算
					boolean prepayFlag = sunnyCompensateViewHelper.checkPrepay(httpServletRequest, claimNo);
					if (prepayFlag == false) {
						ActionMessages messages = new ActionMessages();
						messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("title.compensateEidt.notPrepay"));
						saveMessages(httpServletRequest, messages);
						return actionMapping.findForward("success");
					}
					//核损不通过的案件不能进入实赔理算
					if ("D".equals(strRiskType)) {
						boolean verifyFlag = sunnyCompensateViewHelper.checkVerifyLoss(httpServletRequest, claimNo);
						if (verifyFlag == false) {
							ActionMessages messages = new ActionMessages();
							messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("title.compensateEidt.notVertify"));
							saveMessages(httpServletRequest, messages);
							return actionMapping.findForward("success");
						}
					}
				}				
				if("D".equals(strRiskType)){
					  //add by lym 20060809 start	
					ArrayList prpLprepayDtoList =claimDto.getPrpLprepayDtoList();
					String configCode = uiCodeAction.translateRiskCodetoConfigCode(riskCode);
				    if (count == 0 &&  prpLprepayDtoList !=null && prpLprepayDtoList.size()>0){
					    for (Iterator iter = prpLprepayDtoList.iterator(); iter.hasNext();) {
					    PrpLprepayDto element = (PrpLprepayDto) iter.next();
						  
						 if ("5".equals(element.getCaseType()) && "1".equals(element.getUnderWriteFlag())){
							sosMedicFee +=  element.getSumPrePaid();
						 }
						 else if(("RISKCODE_DAZ".equals(configCode)||"RISKCODE_DAY".equals(configCode)||"RISKCODE_DAU".equals(configCode)) && "1".equals(element.getUnderWriteFlag())){
							sosMedicFee +=  element.getSumPrePaid();
						 }
					    }
				    }
				    httpServletRequest.setAttribute("sosMedicFee",String.valueOf(sosMedicFee));				    
				    //校验是否存在未提交节点
				    WorkFlowViewHelper wf = new WorkFlowViewHelper();
				    String flowid = httpServletRequest.getParameter("swfLogFlowID");
				    String logno  = httpServletRequest.getParameter("swfLogLogNo");
				    String msg = wf.checkNodeSubmit(flowid, logno);
                    httpServletRequest.setAttribute("msg",msg);
				    
				    /** 
					String dutyPercent = "0";
					if(claimDto.getPrpLthirdPartyDtoList().size()==2){
						for(int i=0;i<claimDto.getPrpLthirdPartyDtoList().size();i++){
							if(((PrpLthirdPartyDto)claimDto.getPrpLthirdPartyDtoList().get(i)).getInsureCarFlag().equals("0")){						
								dutyPercent = Double.toString(((PrpLthirdPartyDto)claimDto.getPrpLthirdPartyDtoList().get(i)).getDutyPercent());
							}
						}
					}**/
					httpServletRequest.setAttribute("prpLthirdPartyDtoList",claimDto.getPrpLthirdPartyDtoList());
				    
				    //取强制保单限额----------------------------------------------
	                // UICodeAction  uiCodeAction = new UICodeAction();
	                
	                Map limitMap = new HashMap();
	                if ("RISKCODE_DAZ".equals(configCode)||"RISKCODE_DAY".equals(configCode)||"RISKCODE_DAU".equals(configCode)){
	                   UIPrpClimitAction  uiPrpClimitAction =new UIPrpClimitAction(); 
	                  Collection limitList= uiPrpClimitAction.findByConditions(" policyNo='" +claimDto.getPrpLclaimDto().getPolicyNo() +"'");
	                  String limitType="";
	                  double limitFee=0;
	                  if ( limitList != null && limitList.size()>0){
	                      Iterator it =limitList.iterator();
	                      while (it.hasNext()){
	                     	PrpClimitDto  prpClimitDto =(PrpClimitDto)it.next();
	                     	limitType = prpClimitDto.getLimitType();
	                     	limitFee =  prpClimitDto.getLimitFee()  ;
	                     	limitMap.put(limitType,String.valueOf(limitFee));	
	                      }
	                    }
	                 }
	                httpServletRequest.setAttribute("limitMap",limitMap ); 
	                httpServletRequest.setAttribute("configCode",configCode );
	                //new 取事故责任免赔率------------------
	                EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
	                PolicyDto policyDto = endorseViewHelper.findForEndorBefore(claimDto.getPrpLclaimDto().getPolicyNo(),
	                		claimDto.getPrpLclaimDto().getDamageStartDate().toString()
							,claimDto.getPrpLclaimDto().getDamageStartHour());

	                Map mapList = new HashMap();
	                Map deductRateList = new HashMap();
	                String  kind ="";
	                String  modeCode ="";
	                double deductRate=0;
	                DateTime  validDate = policyDto.getPrpCmainDto().getStartDate();
	                UIDeductCondAction uiDeductCondAction =UIDeductCondAction.getInstance(); 
	            	ArrayList prpLdeductCondList = UIDeductCondAction.getInstance().getDeductCondList(httpServletRequest,false);
	                for  ( int i =0; i< policyDto.getPrpCitemKindDtoList().size();i++){
	                	PrpCitemKindDto prpCitemKindDto =(PrpCitemKindDto) policyDto.getPrpCitemKindDtoList().get(i);
	                	kind=  prpCitemKindDto.getKindCode();
	                	modeCode=  prpCitemKindDto.getModeCode();
	                	Map mapp =  uiDeductCondAction.getDeductibleRateOfAccident(riskCode,kind,modeCode,validDate.toString());
	                	
//	                	去绝对免赔率
 	                	 PrpCitemCarDto prpCitemCarDto = (PrpCitemCarDto) (policyDto.getPrpCitemCarDtoList().get(0));
	                	 deductRate = uiDeductCondAction.getDeductibleRateOfAbsolute(
								prpCitemCarDto.getClauseType(), 
								kind,
								prpLdeductCondList, 
								riskCode,
								policyDto.getPrpCmainDto().getOperateDate().toString());
	                	mapList.put(kind, mapp);
	                	deductRateList.put(kind,Double.toString(deductRate));
	                	
	                }
	                httpServletRequest.setAttribute("mapList",mapList );  
	                httpServletRequest.setAttribute("deductRateList",deductRateList );
	                //取车险限额---------------------------
					double amount=0;
					String kindCode="";
					Map amountMap = new HashMap();
					ArrayList limitlist=policyDto.getPrpCitemKindDtoList();
					Iterator it =limitlist.iterator();
					if (limitlist!=null && limitlist.size()>0){
						while(it.hasNext()){
							PrpCitemKindDto  prpCitemKindDto =(PrpCitemKindDto)it.next();
							    kindCode = prpCitemKindDto.getKindCode();
								amount =	prpCitemKindDto.getAmount();
								amountMap.put(kindCode,String.valueOf(amount));
						}
					}
					httpServletRequest.setAttribute("amountMap",amountMap); 
					//----------------------------------------------
					sunnyCompensateViewHelper.claimDtoToView(httpServletRequest, claimNo, editType);
					avoidUpdateSampCompe(httpServletRequest);	//为防止两个人同时操作同一个待处理的理算任务，临时写了实赔结点
	            }else {
                    //modify by liujianbo modify start 2005-11-10
					//关于调查的判断  
					String registNo = uiCodeAction.translateBusinessCode(claimNo,false);
					String conditions = " businessno='"+registNo+"' and nodeType='check' and (nodeStatus in ('0','1','2','3'))";
					if(uiWorkFlowAction.getCount(conditions)>1){
						httpServletRequest.setAttribute("checkFlag12","N"); 
					} else {
						httpServletRequest.setAttribute("checkFlag12","Y");   
					} 
					//modify by liujianbo modify end 2005-11-10    
					
					String condition = " policyno = '" + claimDto.getPrpLclaimDto().getPolicyNo() + "'";
					strPolicyNo =  claimDto.getPrpLclaimDto().getPolicyNo();
					int intReturn = 0;
					UIPolicyAction uiPolicyAction = new UIPolicyAction();
					
	                //分入标志
					PrpCmainDto prpCmainDto = uiPolicyAction.findPrpCmainDtoByPrimaryKey(strPolicyNo);
	            	if(prpCmainDto!=null){
	            		businessFlag = prpCmainDto.getBusinessFlag();
	            	}
	            	httpServletRequest.setAttribute("businessFlag", businessFlag);
	            	
					intReturn = uiPolicyAction.checkPay(condition);//-1为未缴费，0为未缴全，1为缴全
					//保单如果为分入业务 不做此校验
					if(intReturn==-1&&!"1".equals(businessFlag)){
						throw new Exception("此保单保费未缴!");
					}
					AccidentCompensateViewHelper accidentCompensateViewHelper = new AccidentCompensateViewHelper();
					accidentCompensateViewHelper.claimDtoToView(httpServletRequest, claimNo, editType);
					avoidUpdateSampCompe(httpServletRequest);	//为防止两个人同时操作同一个待处理的理算任务，临时写了实赔结点
				}
                //add by wunier 20071228
                //reason：增加与赔付数量对应的单位信息
				String conditions =" codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"+riskCode+"' and codetype='Unit')";
                Collection collection = uiCodeAction.findByConditions(conditions);
                httpServletRequest.setAttribute("lossesUnitCodeCollection",collection);
                //页面放置报案号
                String registNo = uiCodeAction.translateBusinessCode(claimNo,false);
			    httpServletRequest.setAttribute("registNo",registNo);
                //end by wunier 20071228
			    //页面放置事故号码
				String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
				String pageNo     = httpServletRequest.getParameter("pageNo");
				if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";
                WorkFlowViewHelper workViewHelp=new WorkFlowViewHelper();
                workViewHelp.getComBineCompensateListByConditions(httpServletRequest, conditions1, pageNo, recordPerPage);
                //页面放置保单录单日期
                PolicyDto policyDto = new UIPolicyAction().findByPrimaryKey(claimDto.getPrpLclaimDto().getPolicyNo());
            	String policyInputDate=policyDto.getPrpCmainDto().getInputDate().toString();
			    httpServletRequest.setAttribute("policyInputDate",policyInputDate);

			}
			
			//2.修改和查询显示的过程
			if (editType.equals("EDIT") || editType.equals("SHOW") || editType.equals("DELETE")) {
				//查询实赔信息,整理输入，用于初始界面显示
				compensateNo = httpServletRequest.getParameter("prpLcompensateCompensateNo"); //赔款计算书号
				caseType = httpServletRequest.getParameter("caseType");
				UICompensateAction uiCompensateAction = new UICompensateAction();
				CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(compensateNo, caseType);
				
				PrpLcompensateDto prpLcompensateDto = compensateDto.getPrpLcompensateDto();
			    //校验是否存在未提交节点
			    WorkFlowViewHelper wf = new WorkFlowViewHelper();
			    String flowid = httpServletRequest.getParameter("swfLogFlowID");
			    String logno  = httpServletRequest.getParameter("swfLogLogNo");
			    String msg = wf.checkNodeSubmit(flowid, logno);
                httpServletRequest.setAttribute("msg",msg);
			    
				
                //add by miaowenjun 20070130 显示的时候去掉间接理赔费用 start
		        double sumPaid = 0d;
		        double sumDutyPaid = 0d;
		        double sumThisPaid = 0d;
		        sumPaid  = prpLcompensateDto.getSumPaid();
		        sumDutyPaid = prpLcompensateDto.getSumDutyPaid();
		        sumThisPaid = prpLcompensateDto.getSumThisPaid();
		        for (Iterator iter = compensateDto.getPrpLchargeDtoList().iterator(); iter.hasNext();) {
					PrpLchargeDto prpLchargeDto = (PrpLchargeDto) iter.next();
					if("28".equals(prpLchargeDto.getChargeCode())){
						sumPaid -= prpLchargeDto.getChargeAmount();
						sumDutyPaid -= prpLchargeDto.getChargeAmount();
						sumThisPaid -= prpLchargeDto.getChargeAmount();
					}
				}
		        prpLcompensateDto.setSumPaid(sumPaid);
		        prpLcompensateDto.setSumDutyPaid(sumDutyPaid);
		        prpLcompensateDto.setSumThisPaid(sumThisPaid);
		        compensateDto.setPrpLcompensateDto(prpLcompensateDto);
	           //add by miaowenjun 20070130 显示的时候去掉间接理赔费用 end
				
				claimNo = prpLcompensateDto.getClaimNo().trim();
				ClaimDto claimDto = new UIClaimAction().findByPrimaryKey(claimNo);
				strPolicyNo = prpLcompensateDto.getPolicyNo(); 
				httpServletRequest.setAttribute("prpLclaimDto", claimDto.getPrpLclaimDto());  
				/*
				httpServletRequest.setAttribute("dutyFlag",claimDto.getPrpLthirdPartyDtoList().size()+"");
				String dutyPercent = "0";
				if(claimDto.getPrpLthirdPartyDtoList().size()==2){
					for(int i=0;i<claimDto.getPrpLthirdPartyDtoList().size();i++){
						if(((PrpLthirdPartyDto)claimDto.getPrpLthirdPartyDtoList().get(i)).getInsureCarFlag().equals("0")){						
							dutyPercent = Double.toString(((PrpLthirdPartyDto)claimDto.getPrpLthirdPartyDtoList().get(i)).getDutyPercent());
						}
					}
				}
				httpServletRequest.setAttribute("dutyPercent",dutyPercent);
				*/
				//设置缴费情况明细
				setPayCase(httpServletRequest,claimDto.getPrpLclaimDto().getPolicyNo());
				BLPrpLcompensateFacade blPrpLcompensateFacade = new BLPrpLcompensateFacade();
				int count = blPrpLcompensateFacade.getCount(" claimno='" + claimDto.getPrpLclaimDto().getClaimNo() + "' and compensateNo like '%-001'");

				if ("D".equals(strRiskType)) {  
                     //	add by lym 20060809 start	
					String configCode = uiCodeAction.translateRiskCodetoConfigCode(riskCode);
					
					ArrayList prpLprepayDtoList =claimDto.getPrpLprepayDtoList();
					if (count == 1 && prpLprepayDtoList !=null && prpLprepayDtoList.size()>0){
						for (Iterator iter = prpLprepayDtoList.iterator(); iter.hasNext();) {
							PrpLprepayDto element = (PrpLprepayDto) iter.next();
							if ("5".equals(element.getCaseType())&& "1".equals(element.getUnderWriteFlag())){
								sosMedicFee +=  element.getSumPrePaid();
							}
							else if("RISKCODE_DAZ".equals(configCode) && "1".equals(element.getUnderWriteFlag())){
								sosMedicFee +=  element.getSumPrePaid();
						    }
						}
					}
					httpServletRequest.setAttribute("sosMedicFee",String.valueOf(sosMedicFee));
					//add by lym 20060809 end 	
                    
					//取强制保单限额----------------------------------------------
		            
		               
	                Map limitMap = new HashMap();
	                if ("RISKCODE_DAZ".equals(configCode)||"RISKCODE_DAY".equals(configCode)||"RISKCODE_DAU".equals(configCode)){
	                  UIPrpClimitAction  uiPrpClimitAction =new UIPrpClimitAction(); 
	                  Collection limitList= uiPrpClimitAction.findByConditions(" policyNo='" +claimDto.getPrpLclaimDto().getPolicyNo() +"'");
	                  String limitType="";
	                  double limitFee=0;
	                  if ( limitList != null && limitList.size()>0){
	                      Iterator it =limitList.iterator();
	                      while (it.hasNext()){
	                     	PrpClimitDto  prpClimitDto =(PrpClimitDto)it.next();
	                     	limitType = prpClimitDto.getLimitType();
	                     	limitFee =  prpClimitDto.getLimitFee()  ;
	                     	limitMap.put(limitType,String.valueOf(limitFee));	
	                      }
	                    }
	                 }
	                httpServletRequest.setAttribute("limitMap",limitMap ); 
	                httpServletRequest.setAttribute("configCode",configCode );
	                //---------------------------------------------
	                
                    //new 取事故责任免赔率------------------
	                EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
	                PolicyDto policyDto = endorseViewHelper.findForEndorBefore(claimDto.getPrpLclaimDto().getPolicyNo(),
	                		claimDto.getPrpLclaimDto().getDamageStartDate().toString()
							,claimDto.getPrpLclaimDto().getDamageStartHour());
	                
	                Map mapList = new HashMap();
	                Map deductRateList = new HashMap();
	                String  kind ="";
	                String  modeCode ="";
	                double deductRate=0;
	                DateTime  validDate = policyDto.getPrpCmainDto().getStartDate();
	                UIDeductCondAction uiDeductCondAction =UIDeductCondAction.getInstance(); 
	              
	                ArrayList prpLdeductCondList =(ArrayList)  new  BLPrpLdeductCondFacade().findByConditions( compensateNo );
	               // ArrayList prpLdeductCondDtolist = UIDeductCondAction.getInstance().getDeductCondList(httpServletRequest);
	                for  ( int i =0; i< policyDto.getPrpCitemKindDtoList().size();i++){
	                	PrpCitemKindDto prpCitemKindDto =(PrpCitemKindDto) policyDto.getPrpCitemKindDtoList().get(i);
	                	kind=  prpCitemKindDto.getKindCode();
	                	modeCode=  prpCitemKindDto.getModeCode();
	                	Map mapp =  uiDeductCondAction.getDeductibleRateOfAccident(riskCode,kind,modeCode,validDate.toString());
	                	
//	                	去绝对免赔率
	                   PrpCitemCarDto prpCitemCarDto = (PrpCitemCarDto) (policyDto.getPrpCitemCarDtoList().get(0));
	                   deductRate = uiDeductCondAction.getDeductibleRateOfAbsolute(
								prpCitemCarDto.getClauseType(), 
								kind,
								prpLdeductCondList, 
								riskCode,
								policyDto.getPrpCmainDto().getOperateDate().toString());
	                	
	                	
	                	mapList.put(kind, mapp);
	                	deductRateList.put(kind,Double.toString(deductRate));
	                	
	                }
	                httpServletRequest.setAttribute("mapList",mapList );  
	                httpServletRequest.setAttribute("deductRateList",deductRateList );
	            
					 //取车险限额---------------------------
					double amount=0;
					String kindCode="";
					Map amountMap = new HashMap();
                   //UIPolicyAction uiPolicyAction  = new UIPolicyAction (); 
					//PolicyDto policyDto =uiPolicyAction.findByPrimaryKey(claimDto.getPrpLclaimDto().getPolicyNo());
					ArrayList limitlist=policyDto.getPrpCitemKindDtoList();
					Iterator it =limitlist.iterator();
					if (limitlist!=null && limitlist.size()>0){
						while(it.hasNext()){
							PrpCitemKindDto  prpCitemKindDto =(PrpCitemKindDto)it.next();
							    kindCode = prpCitemKindDto.getKindCode();
								amount =	prpCitemKindDto.getAmount();
								amountMap.put(kindCode,String.valueOf(amount));
						}
					}
					httpServletRequest.setAttribute("amountMap",amountMap); 
				
					SunnyCompensateViewHelper sunnyCompensateViewHelper = new SunnyCompensateViewHelper();
					sunnyCompensateViewHelper.compensateDtoView(httpServletRequest, compensateNo, editType);
				
				}else {
					AccidentCompensateViewHelper accidentCompensateViewHelper = new AccidentCompensateViewHelper();
					accidentCompensateViewHelper.compensateDtoView(httpServletRequest, compensateNo, editType);
				}
	
				if (riskCode == null || riskCode.length() < 1 || riskCode.trim().equals("")) {
					riskCode = BusinessRuleUtil.getRiskCode(compensateNo,"CompensateNo");
				}
                //add by wunier 20071228
                //reason：增加与赔付数量对应的单位信息
			    String conditions =" codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"+riskCode+"' and codetype='Unit')";
                Collection collection = uiCodeAction.findByConditions(conditions);
                httpServletRequest.setAttribute("lossesUnitCodeCollection",collection);
                //页面放置报案号
                String registNo = uiCodeAction.translateBusinessCode(claimNo,false);
			    httpServletRequest.setAttribute("registNo",registNo);
                //end by wunier 20071228
			  //页面放置事故号码
				String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
				String pageNo     = httpServletRequest.getParameter("pageNo");
				if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";
                WorkFlowViewHelper workViewHelp=new WorkFlowViewHelper();
                workViewHelp.getComBineCompensateListByConditions(httpServletRequest, conditions1, pageNo, recordPerPage);
			    //页面放置录单日期新危险单位用到
			    PolicyDto policyDto = new UIPolicyAction().findByPrimaryKey(claimDto.getPrpLclaimDto().getPolicyNo());
            	String policyInputDate=policyDto.getPrpCmainDto().getInputDate().toString();
			    httpServletRequest.setAttribute("policyInputDate",policyInputDate);
   		}
	    //免赔率选择-20060418--start-------------------		
		if (editType.equals("RECHOSE")) {	
			
			//String strDeductibleTerm = httpServletRequest.getParameter("DeductibleTerm");
			double dblDeductibleRate = 0;
			double dblDutyDeductibleRate = 0;
		
			
			Vector   it  =  new Vector(3);
			PrpCitemCarDto	 prpCitemCarDto       = new PrpCitemCarDto();
			PrpCitemKindDto  prpCitemKindDto      = new PrpCitemKindDto();
			PrpCmainDto prpCmainDto = new PrpCmainDto();
			ArrayList        prpCitemKindDtolist  = new   ArrayList();
			ClaimDto claimDto = new UIClaimAction().findByPrimaryKey(claimNo);
			httpServletRequest.setAttribute("prpLclaimDto", claimDto.getPrpLclaimDto());  
			String   policyNo= claimDto.getPrpLclaimDto().getPolicyNo();
		    strPolicyNo = policyNo; 
		    
			UIDeductCondAction uiDeductCondAction = UIDeductCondAction.getInstance();
			
			if ("D".equals(strRiskType)) {
				
		          
                // 取得出险时保单的信息
				EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
				PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo, claimDto.getPrpLclaimDto()
						.getDamageStartDate().toString(), claimDto.getPrpLclaimDto().getDamageStartHour());
				 if (policyDto.getPrpCitemCarDtoList() != null && policyDto.getPrpCitemCarDtoList().size() > 0) {
					prpCitemCarDto = (PrpCitemCarDto) (policyDto.getPrpCitemCarDtoList().get(0));
					prpCitemKindDtolist = (ArrayList) policyDto.getPrpCitemKindDtoList();
					prpCmainDto = policyDto.getPrpCmainDto();
				}
				 ArrayList prpLdeductCondList = UIDeductCondAction.getInstance().getDeductCondList(httpServletRequest,false);
				 PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
					prpLcompensateDto.setPrpLdeductCondDtoList(prpLdeductCondList);
					for (Iterator iter = prpLdeductCondList.iterator(); iter
							.hasNext();) {
						PrpLdeductCondDto prpLdeductCondDto = (PrpLdeductCondDto) iter.next();
						System.out.println();System.out.println(prpLdeductCondDto.getDeductCondName());System.out.println();
					}
					httpServletRequest.setAttribute("prpLcompensateDto", prpLcompensateDto);
				String kindCode="";
				String modeCode ="";
			
				
			       if ( prpCitemKindDtolist.size()>0){
                    	for ( int k=0 ;k<prpCitemKindDtolist.size() ; k++){
                    	     prpCitemKindDto =(PrpCitemKindDto) prpCitemKindDtolist.get(k);
                    	        kindCode = prpCitemKindDto.getKindCode();
                    	     	modeCode = prpCitemKindDto.getModeCode(); 
            

	                //事故责任免赔率
                    if(prpCmainDto.getOperateDate() == null){
                    	throw new UserException(0, 0, "保单生效期为空");
                    }
					dblDutyDeductibleRate = uiDeductCondAction.getDeductibleRateOfAccident(
							riskCode, 
							kindCode,
							claimDto.getPrpLclaimDto().getIndemnityDuty(), 
							modeCode, 
							prpCmainDto.getOperateDate().toString()
							);

					//绝对免赔率
					dblDeductibleRate = uiDeductCondAction.getDeductibleRateOfAbsolute(
							prpCitemCarDto.getClauseType(), 
							kindCode,
							prpLdeductCondList, 
							riskCode,
							prpCmainDto.getOperateDate().toString());
				 
				
				it.add(0,kindCode);
				it.add(1,String.valueOf(dblDutyDeductibleRate));
				it.add(2,String.valueOf(dblDeductibleRate));
				
				}//endfor
				  
			}//endif
			httpServletRequest.setAttribute("it",it); 
		//	httpServletRequest.setAttribute("strDeductibleTerm",strDeductibleTerm); //20060511
			
			forward = "RECHOSE";
			return actionMapping.findForward(forward);
		   }
		}
		//start分入标志
	    BLPrpCmainFacade  blPrpCmainFacade = new BLPrpCmainFacade();
	    com.sinosoft.prpall.dto.domain.PrpCmainDto prpCmainDtoTem = blPrpCmainFacade.findByPrimaryKey(strPolicyNo);
	    if(prpCmainDtoTem!=null){
	    	businessFlag = prpCmainDtoTem.getBusinessFlag();
	    }
		httpServletRequest.setAttribute("businessFlag", businessFlag);
	    //end分入标志
		 //免赔率选择-20060418--end-------------------	
			//3。如果是SHOW类型的，目前和EDIT用同一个目的jsp所以
			if (editType.equals("Approve")) {
				//查询实赔信息,整理输入，用于初始界面显示
				//  modify by wangli add start 20050519
				// reason: 车险 和 非车 计算书 走不同 ViewHelper
				if ("D".equals(strRiskType) ) {
					SunnyCompensateViewHelper sunnnyCompensateViewHelper = new SunnyCompensateViewHelper();
					sunnnyCompensateViewHelper.compensateDtoView(httpServletRequest, compensateNo, editType);
				} else {
					AccidentCompensateViewHelper accidentCompensateViewHelper = new AccidentCompensateViewHelper();
					accidentCompensateViewHelper.compensateDtoView(httpServletRequest, compensateNo, editType);
				}
				//  modify by wangli add end 20050519
				return actionMapping.findForward(forward);
			}
			//未处理理算任务的放弃处理
			if (editType.equals("GIVUP")) {
				giveUpLockCompe(httpServletRequest);
				ActionMessages messages = new ActionMessages();
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.compensate.giveup"));
				saveMessages(httpServletRequest, messages);
				forward = "success";
				return actionMapping.findForward(forward);
			}
			
			//取得forward
			forward = BusinessRuleUtil.getForward(httpServletRequest, riskCode, "compe", editType, 1);
			//add by lym 20060614 for 强三 ---start
			String strConfigCode = uiCodeAction.translateRiskCodetoConfigCode(riskCode);
			if (("RISKCODE_DAZ".equals(strConfigCode)||"RISKCODE_DAY".equals(strConfigCode)
					||"RISKCODE_DAU".equals(strConfigCode))&&  editType.equals("ADD") ){
				forward =editType+"BZ";
			}
			if (("RISKCODE_DAZ".equals(strConfigCode)||"RISKCODE_DAY".equals(strConfigCode)
					||"RISKCODE_DAU".equals(strConfigCode))&&( editType.equals("EDIT") || editType.equals("SHOW"))){
				forward ="EDITBZ";
			}
			//add by lym 20060614 for 强三 ---end 			
			if (user == null) {
				user = new UserDto();
			}
			
			user.setRiskCode(riskCode);
			httpServletRequest.setAttribute("user",user);
			saveToken(httpServletRequest);
		} catch (UserException usee) {
			usee.printStackTrace();
			//错误信息处理
			ActionMessages msgs = new ActionMessages();
			ActionMessage msg = new ActionMessage("title.compensateBeforeEdit.editCompensate");
			msgs.add(ActionMessages.GLOBAL_MESSAGE, msg);
			httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(httpServletRequest, msgs);
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			//错误信息处理
			ActionMessages msgs = new ActionMessages();
			ActionMessage msg = new ActionMessage("title.compensateBeforeEdit.titleName");
			msgs.add(ActionMessages.GLOBAL_MESSAGE, msg);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, msgs);
			forward = "error";
		} 
		return actionMapping.findForward(forward);
	}
	
	/**
	 * 设置缴费情况(是否缴费以及缴费情况)
	 * @param httpServletRequest
	 * @param policyNo
	 * @throws Exception
	 */
	private void setPayCase(HttpServletRequest httpServletRequest,String policyNo) throws Exception{
		
		UIPolicyAction uiPolicyAction = new UIPolicyAction();
		String conditions1 = " policyno = '" + policyNo + "'";
		
		//获得缴费情况
		int intReturn = 0;
		intReturn = uiPolicyAction.checkPay(conditions1);//-1为未缴费，0为未缴全，1为缴全
		String strPayFlag = String.valueOf(intReturn);
		httpServletRequest.setAttribute("payFlag",strPayFlag);
		
		/**
		 * modify by mengdongdong start
		 * resion:当缴费不足时,要显示相应的缴费情况
		 * 2006-1-19
		 */
		PrpCmainDto cmainDto = (PrpCmainDto)new UIPolicyAction().findPrpCmainDtoByPrimaryKey(policyNo);
		//欠费情况
		String delinquentfeeCase = "";
		//若费用未缴全,则针对分期付款的情况要提示哪几期费用未缴
		if(intReturn == -2 && cmainDto.getPayTimes()>1){			
			delinquentfeeCase = new DAARegistViewHelper().getDelinquentfeeCase(cmainDto);
		}
		logger.debug("缴费情况为:"+delinquentfeeCase);
		//设置分期付款未缴期数
		httpServletRequest.setAttribute("delinquentfeeCase",delinquentfeeCase);
		/**
		 * modify by mengdongdong end
		 * resion:当缴费不足时,要显示相应的缴费情况
		 * 2006-1-19
		 */
		
		PrpLregistDto prpLregistDto = new PrpLregistDto();
		prpLregistDto.setPayFlag(intReturn+"");
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
	}
	/**
	 * 为防止两个人同时操作同一个待处理的理算任务，临时写了实赔结点
	 * @param httpServletRequest
	 * @throws Exception
	 */
	private void avoidUpdateSampCompe(HttpServletRequest httpServletRequest)throws Exception{
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		//add by huangyunzhong 20051109 为防止两个人同时操作同一个待处理的理算任务，临时写了实赔结点
		String FlowID = httpServletRequest.getParameter("swfLogFlowID");
		int  LogNo=Integer.parseInt((String)httpServletRequest.getParameter("swfLogLogNo"));
		UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
		SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(FlowID,LogNo);
		if(swfLogDto.getNodeType().equals("compe")){
			swfLogDto.setHandlerCode(user.getUserCode());
			swfLogDto.setHandlerName(user.getUserName());
		}
		uiworkflowaction.updateFlow(swfLogDto);
		//add by lixiang start at 2006-4-27
		//如果是车险的话，需要判断是否前面的节点都已经处理完毕 
		UICodeAction  uiCodeAction = new UICodeAction();
		 if ("05".equals(uiCodeAction.translateClassCodeByRiskCode(swfLogDto.getRiskCode()))){
      	   WorkFlowViewHelper workFlowViewHelper=new WorkFlowViewHelper();
		   //检查前面是否有没做完的节点 
		   workFlowViewHelper.checkNodeSubmit(swfLogDto);
		 }
//		add by lixiang end at 2006-4-27
		//add end by huangyunzhong 20051109
	}
	/**
	 * 放弃未暂存和提交的理算任务，删去临时写的实赔结点操作人，使其他人可见可处理
	 * @param httpServletRequest
	 * @throws Exception
	 */
	private void giveUpLockCompe(HttpServletRequest httpServletRequest)throws Exception{
		//add by huangyunzhong 20051110 放弃未暂存和提交的理算任务，删去临时写的实赔结点操作人，使其他人可见可处理
		String FlowID = httpServletRequest.getParameter("swfLogFlowID");
		int  LogNo=Integer.parseInt((String)httpServletRequest.getParameter("swfLogLogNo"));
		UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
		SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(FlowID,LogNo);
		if(swfLogDto.getNodeType().equals("compe")){
			swfLogDto.setHandlerCode("");
			swfLogDto.setHandlerName("");
		}
		uiworkflowaction.updateFlow(swfLogDto);
	}
}
