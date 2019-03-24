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
 * �ַ�HTTP GET ��ֳ�ղ�������
 * <p>
 * Title: ��ֳ�ղ�������
 * </p>
 * <p>
 * Description: ��ֳ�ղ�������
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
		
		//ҵ�����ͣ�ADD-���� EDIT-�޸� SHOW-��ʾ DELETE-ɾ��
		String editType = httpServletRequest.getParameter("editType"); 
		httpServletRequest.setAttribute("editType", editType);
		String claimNo = httpServletRequest.getParameter("ClaimNo"); //�ⰸ��
		String compensateNo = httpServletRequest.getParameter("prpLcompensateCompensateNo"); //���������
		String riskCode = httpServletRequest.getParameter("riskCode");//����
		String caseType = httpServletRequest.getParameter("caseType");//�����ⰸ��־
		String forward = ""; //��ǰ
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
			
			//added by zhangli ͨ������������õ��ڵ�״̬
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
			//��δ����type�쳣����{}��������������쳣����{}
			//1.��ѯ������Ϣ,�������룬���ڳ�ʼ������ʾ
			if (editType.equals("ADD")) {
				SunnyCompensateViewHelper sunnyCompensateViewHelper = new SunnyCompensateViewHelper();				
				ClaimDto claimDto = new UIClaimAction().findByPrimaryKey(claimNo);
				httpServletRequest.setAttribute("prpLclaimDto", claimDto.getPrpLclaimDto());  				
				BLPrpLcompensateFacade blPrpLcompensateFacade = new BLPrpLcompensateFacade();
				int count = blPrpLcompensateFacade.getCount(" claimno='" + claimDto.getPrpLclaimDto().getClaimNo() + "' and underwriteflag in ('1','3')");
                //���ýɷ������ϸ
				setPayCase(httpServletRequest,claimDto.getPrpLclaimDto().getPolicyNo());				
                //ֻ������ʵ����ж϶����
				//û�ж���İ������ܽ���ʵ������
				int conditionFlag = 0;
				if (!"3".equals(caseType) && !"4".equals(caseType)) {
					conditionFlag = sunnyCompensateViewHelper.checkCondition(httpServletRequest, claimNo);
				}				
				//������������㰸����Ҫ������֤
				if (caseType == null || caseType.trim().length() < 1) {
					if (conditionFlag == 1) {
						ActionMessages messages = new ActionMessages();
						messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("title.compensateEidt.notClaim"));
						saveMessages(httpServletRequest, messages);
						return actionMapping.findForward("success");
					}
					//��Ԥ��İ������˲�ͨ���İ������ܽ���ʵ������
					boolean prepayFlag = sunnyCompensateViewHelper.checkPrepay(httpServletRequest, claimNo);
					if (prepayFlag == false) {
						ActionMessages messages = new ActionMessages();
						messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("title.compensateEidt.notPrepay"));
						saveMessages(httpServletRequest, messages);
						return actionMapping.findForward("success");
					}
					//����ͨ���İ������ܽ���ʵ������
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
				    //У���Ƿ����δ�ύ�ڵ�
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
				    
				    //ȡǿ�Ʊ����޶�----------------------------------------------
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
	                //new ȡ�¹�����������------------------
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
	                	
//	                	ȥ����������
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
	                //ȡ�����޶�---------------------------
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
					avoidUpdateSampCompe(httpServletRequest);	//Ϊ��ֹ������ͬʱ����ͬһ�������������������ʱд��ʵ����
	            }else {
                    //modify by liujianbo modify start 2005-11-10
					//���ڵ�����ж�  
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
					
	                //�����־
					PrpCmainDto prpCmainDto = uiPolicyAction.findPrpCmainDtoByPrimaryKey(strPolicyNo);
	            	if(prpCmainDto!=null){
	            		businessFlag = prpCmainDto.getBusinessFlag();
	            	}
	            	httpServletRequest.setAttribute("businessFlag", businessFlag);
	            	
					intReturn = uiPolicyAction.checkPay(condition);//-1Ϊδ�ɷѣ�0Ϊδ��ȫ��1Ϊ��ȫ
					//�������Ϊ����ҵ�� ������У��
					if(intReturn==-1&&!"1".equals(businessFlag)){
						throw new Exception("�˱�������δ��!");
					}
					AccidentCompensateViewHelper accidentCompensateViewHelper = new AccidentCompensateViewHelper();
					accidentCompensateViewHelper.claimDtoToView(httpServletRequest, claimNo, editType);
					avoidUpdateSampCompe(httpServletRequest);	//Ϊ��ֹ������ͬʱ����ͬһ�������������������ʱд��ʵ����
				}
                //add by wunier 20071228
                //reason���������⸶������Ӧ�ĵ�λ��Ϣ
				String conditions =" codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"+riskCode+"' and codetype='Unit')";
                Collection collection = uiCodeAction.findByConditions(conditions);
                httpServletRequest.setAttribute("lossesUnitCodeCollection",collection);
                //ҳ����ñ�����
                String registNo = uiCodeAction.translateBusinessCode(claimNo,false);
			    httpServletRequest.setAttribute("registNo",registNo);
                //end by wunier 20071228
			    //ҳ������¹ʺ���
				String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
				String pageNo     = httpServletRequest.getParameter("pageNo");
				if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";
                WorkFlowViewHelper workViewHelp=new WorkFlowViewHelper();
                workViewHelp.getComBineCompensateListByConditions(httpServletRequest, conditions1, pageNo, recordPerPage);
                //ҳ����ñ���¼������
                PolicyDto policyDto = new UIPolicyAction().findByPrimaryKey(claimDto.getPrpLclaimDto().getPolicyNo());
            	String policyInputDate=policyDto.getPrpCmainDto().getInputDate().toString();
			    httpServletRequest.setAttribute("policyInputDate",policyInputDate);

			}
			
			//2.�޸ĺͲ�ѯ��ʾ�Ĺ���
			if (editType.equals("EDIT") || editType.equals("SHOW") || editType.equals("DELETE")) {
				//��ѯʵ����Ϣ,�������룬���ڳ�ʼ������ʾ
				compensateNo = httpServletRequest.getParameter("prpLcompensateCompensateNo"); //���������
				caseType = httpServletRequest.getParameter("caseType");
				UICompensateAction uiCompensateAction = new UICompensateAction();
				CompensateDto compensateDto = uiCompensateAction.findByPrimaryKey(compensateNo, caseType);
				
				PrpLcompensateDto prpLcompensateDto = compensateDto.getPrpLcompensateDto();
			    //У���Ƿ����δ�ύ�ڵ�
			    WorkFlowViewHelper wf = new WorkFlowViewHelper();
			    String flowid = httpServletRequest.getParameter("swfLogFlowID");
			    String logno  = httpServletRequest.getParameter("swfLogLogNo");
			    String msg = wf.checkNodeSubmit(flowid, logno);
                httpServletRequest.setAttribute("msg",msg);
			    
				
                //add by miaowenjun 20070130 ��ʾ��ʱ��ȥ������������ start
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
	           //add by miaowenjun 20070130 ��ʾ��ʱ��ȥ������������ end
				
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
				//���ýɷ������ϸ
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
                    
					//ȡǿ�Ʊ����޶�----------------------------------------------
		            
		               
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
	                
                    //new ȡ�¹�����������------------------
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
	                	
//	                	ȥ����������
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
	            
					 //ȡ�����޶�---------------------------
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
                //reason���������⸶������Ӧ�ĵ�λ��Ϣ
			    String conditions =" codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"+riskCode+"' and codetype='Unit')";
                Collection collection = uiCodeAction.findByConditions(conditions);
                httpServletRequest.setAttribute("lossesUnitCodeCollection",collection);
                //ҳ����ñ�����
                String registNo = uiCodeAction.translateBusinessCode(claimNo,false);
			    httpServletRequest.setAttribute("registNo",registNo);
                //end by wunier 20071228
			  //ҳ������¹ʺ���
				String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
				String pageNo     = httpServletRequest.getParameter("pageNo");
				if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";
                WorkFlowViewHelper workViewHelp=new WorkFlowViewHelper();
                workViewHelp.getComBineCompensateListByConditions(httpServletRequest, conditions1, pageNo, recordPerPage);
			    //ҳ�����¼��������Σ�յ�λ�õ�
			    PolicyDto policyDto = new UIPolicyAction().findByPrimaryKey(claimDto.getPrpLclaimDto().getPolicyNo());
            	String policyInputDate=policyDto.getPrpCmainDto().getInputDate().toString();
			    httpServletRequest.setAttribute("policyInputDate",policyInputDate);
   		}
	    //������ѡ��-20060418--start-------------------		
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
				
		          
                // ȡ�ó���ʱ��������Ϣ
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
            

	                //�¹�����������
                    if(prpCmainDto.getOperateDate() == null){
                    	throw new UserException(0, 0, "������Ч��Ϊ��");
                    }
					dblDutyDeductibleRate = uiDeductCondAction.getDeductibleRateOfAccident(
							riskCode, 
							kindCode,
							claimDto.getPrpLclaimDto().getIndemnityDuty(), 
							modeCode, 
							prpCmainDto.getOperateDate().toString()
							);

					//����������
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
		//start�����־
	    BLPrpCmainFacade  blPrpCmainFacade = new BLPrpCmainFacade();
	    com.sinosoft.prpall.dto.domain.PrpCmainDto prpCmainDtoTem = blPrpCmainFacade.findByPrimaryKey(strPolicyNo);
	    if(prpCmainDtoTem!=null){
	    	businessFlag = prpCmainDtoTem.getBusinessFlag();
	    }
		httpServletRequest.setAttribute("businessFlag", businessFlag);
	    //end�����־
		 //������ѡ��-20060418--end-------------------	
			//3�������SHOW���͵ģ�Ŀǰ��EDIT��ͬһ��Ŀ��jsp����
			if (editType.equals("Approve")) {
				//��ѯʵ����Ϣ,�������룬���ڳ�ʼ������ʾ
				//  modify by wangli add start 20050519
				// reason: ���� �� �ǳ� ������ �߲�ͬ ViewHelper
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
			//δ������������ķ�������
			if (editType.equals("GIVUP")) {
				giveUpLockCompe(httpServletRequest);
				ActionMessages messages = new ActionMessages();
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.compensate.giveup"));
				saveMessages(httpServletRequest, messages);
				forward = "success";
				return actionMapping.findForward(forward);
			}
			
			//ȡ��forward
			forward = BusinessRuleUtil.getForward(httpServletRequest, riskCode, "compe", editType, 1);
			//add by lym 20060614 for ǿ�� ---start
			String strConfigCode = uiCodeAction.translateRiskCodetoConfigCode(riskCode);
			if (("RISKCODE_DAZ".equals(strConfigCode)||"RISKCODE_DAY".equals(strConfigCode)
					||"RISKCODE_DAU".equals(strConfigCode))&&  editType.equals("ADD") ){
				forward =editType+"BZ";
			}
			if (("RISKCODE_DAZ".equals(strConfigCode)||"RISKCODE_DAY".equals(strConfigCode)
					||"RISKCODE_DAU".equals(strConfigCode))&&( editType.equals("EDIT") || editType.equals("SHOW"))){
				forward ="EDITBZ";
			}
			//add by lym 20060614 for ǿ�� ---end 			
			if (user == null) {
				user = new UserDto();
			}
			
			user.setRiskCode(riskCode);
			httpServletRequest.setAttribute("user",user);
			saveToken(httpServletRequest);
		} catch (UserException usee) {
			usee.printStackTrace();
			//������Ϣ����
			ActionMessages msgs = new ActionMessages();
			ActionMessage msg = new ActionMessage("title.compensateBeforeEdit.editCompensate");
			msgs.add(ActionMessages.GLOBAL_MESSAGE, msg);
			httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(httpServletRequest, msgs);
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			//������Ϣ����
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
	 * ���ýɷ����(�Ƿ�ɷ��Լ��ɷ����)
	 * @param httpServletRequest
	 * @param policyNo
	 * @throws Exception
	 */
	private void setPayCase(HttpServletRequest httpServletRequest,String policyNo) throws Exception{
		
		UIPolicyAction uiPolicyAction = new UIPolicyAction();
		String conditions1 = " policyno = '" + policyNo + "'";
		
		//��ýɷ����
		int intReturn = 0;
		intReturn = uiPolicyAction.checkPay(conditions1);//-1Ϊδ�ɷѣ�0Ϊδ��ȫ��1Ϊ��ȫ
		String strPayFlag = String.valueOf(intReturn);
		httpServletRequest.setAttribute("payFlag",strPayFlag);
		
		/**
		 * modify by mengdongdong start
		 * resion:���ɷѲ���ʱ,Ҫ��ʾ��Ӧ�Ľɷ����
		 * 2006-1-19
		 */
		PrpCmainDto cmainDto = (PrpCmainDto)new UIPolicyAction().findPrpCmainDtoByPrimaryKey(policyNo);
		//Ƿ�����
		String delinquentfeeCase = "";
		//������δ��ȫ,����Է��ڸ�������Ҫ��ʾ�ļ��ڷ���δ��
		if(intReturn == -2 && cmainDto.getPayTimes()>1){			
			delinquentfeeCase = new DAARegistViewHelper().getDelinquentfeeCase(cmainDto);
		}
		logger.debug("�ɷ����Ϊ:"+delinquentfeeCase);
		//���÷��ڸ���δ������
		httpServletRequest.setAttribute("delinquentfeeCase",delinquentfeeCase);
		/**
		 * modify by mengdongdong end
		 * resion:���ɷѲ���ʱ,Ҫ��ʾ��Ӧ�Ľɷ����
		 * 2006-1-19
		 */
		
		PrpLregistDto prpLregistDto = new PrpLregistDto();
		prpLregistDto.setPayFlag(intReturn+"");
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
	}
	/**
	 * Ϊ��ֹ������ͬʱ����ͬһ�������������������ʱд��ʵ����
	 * @param httpServletRequest
	 * @throws Exception
	 */
	private void avoidUpdateSampCompe(HttpServletRequest httpServletRequest)throws Exception{
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		//add by huangyunzhong 20051109 Ϊ��ֹ������ͬʱ����ͬһ�������������������ʱд��ʵ����
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
		//����ǳ��յĻ�����Ҫ�ж��Ƿ�ǰ��Ľڵ㶼�Ѿ�������� 
		UICodeAction  uiCodeAction = new UICodeAction();
		 if ("05".equals(uiCodeAction.translateClassCodeByRiskCode(swfLogDto.getRiskCode()))){
      	   WorkFlowViewHelper workFlowViewHelper=new WorkFlowViewHelper();
		   //���ǰ���Ƿ���û����Ľڵ� 
		   workFlowViewHelper.checkNodeSubmit(swfLogDto);
		 }
//		add by lixiang end at 2006-4-27
		//add end by huangyunzhong 20051109
	}
	/**
	 * ����δ�ݴ���ύ����������ɾȥ��ʱд��ʵ��������ˣ�ʹ�����˿ɼ��ɴ���
	 * @param httpServletRequest
	 * @throws Exception
	 */
	private void giveUpLockCompe(HttpServletRequest httpServletRequest)throws Exception{
		//add by huangyunzhong 20051110 ����δ�ݴ���ύ����������ɾȥ��ʱд��ʵ��������ˣ�ʹ�����˿ɼ��ɴ���
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
