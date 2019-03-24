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
 * �ַ�HTTP GET ������������ǰ��ѯ����/������������
 * <p>
 * Title: ������������ǰ��ѯ����/����������Ϣ
 * </p>
 * <p>
 * Description: �������ⱨ��ǰ��ѯ������Ϣϵͳ
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

        // ҵ�����ͣ�ADD-���� EDIT-�޸� SHOW-��ʾ CANCEL-ע��
        String editType = httpServletRequest.getParameter("editType"); // ��������
        httpServletRequest.setAttribute("editType", editType);
        String riskCode = httpServletRequest.getParameter("riskCode"); // ����
        String policyNo = httpServletRequest.getParameter("policyNo"); // add by lym 20060605 for ǿ�� 
        String type = httpServletRequest.getParameter("type");
        httpServletRequest.setAttribute("type", type);
       
        String editForward = editType; // ������ת
        String claimNo = ""; // �ⰸ��
        String registNo = ""; // ������
        String forward = ""; // ��ǰ
        String strSql = ""; // ��ѯ����
        String msg = ""; // �׳��������Ϣ�ľ�������
        String riskClass = ""; //���� 2005-08-08
        String businessFlag  = "0";//�����־
        Integer modelnoInt = 0;//ģ���

        try {
            HttpSession session = httpServletRequest.getSession();
            UserDto user = (UserDto) session.getAttribute("user");

            // 3 ����ע���;�����ⰸ����֤
            if (editType.equals("CANCEL")) {
                DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
                // ��ѯ������Ϣ�ľ������
                dAAClaimViewHelper.cancelDtoToView(httpServletRequest, user);
                forward = editType + "DAA";
                riskClass = riskCode.substring(0,2);
                httpServletRequest.setAttribute("com.sinosoft.type", riskClass);
                return actionMapping.findForward(forward);
            }
            if (editType.equals("UNCANCEL")) {
                DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
                // ��ѯ������Ϣ�ľ������
                dAAClaimViewHelper.nucancelDtoToView(httpServletRequest);
                forward = "CANCELDAA";
                riskClass = riskCode.substring(0,2);
                httpServletRequest.setAttribute("com.sinosoft.type", riskClass);
                return actionMapping.findForward(forward);
            }

            // 4 ����ע���;��������
            if (editType.equals("CANCELEDIT")) {
                DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
                // ��ѯ������Ϣ�ľ������
                dAAClaimViewHelper.cancelDtoToCancelView(httpServletRequest, user);
                forward = "CANCELDAA";
                riskClass = riskCode.substring(0,2);
                httpServletRequest.setAttribute("com.sinosoft.type", riskClass);
                return actionMapping.findForward(forward);
            }
            
            //����⽡�ղ��������Ĵ��� 2005-09-06
            if ("NOTGRANDCLAIM".equals(editType)) {
            	 DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
                 dAAClaimViewHelper.notGrandClaimDtoToView(httpServletRequest, user);
                 forward = "NOTGRANDCLAIM";
                 return actionMapping.findForward(forward);
            }

            // ��δ����type�쳣����{}��������������쳣����{}
            if (editType.equals("ADD")) {
                // ��ѯ������Ϣ,�������룬���ڳ�ʼ������ʾ
                registNo = httpServletRequest.getParameter("RegistNo");// ������
                if (riskCode == null || riskCode.length() < 1 || riskCode.trim().equals("")) {
                    riskCode = BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
                }
                // ���ǵ�ǩ�����������ڵ�ǩ������֮����ʾ���ܱ��������������Ӳ����
                UIRegistAction uiRegistAction = new UIRegistAction();
                RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
                httpServletRequest.setAttribute("registDto",registDto );
                //�����Ϻ�ƽ̨�⽡��ƽ̨�ϴ�;
                String classCode = registDto.getPrpLregistDto().getClassCode();
                String comCode = registDto.getPrpLregistDto().getComCode().substring(0, 2);
                httpServletRequest.setAttribute("classCode", classCode);
                httpServletRequest.setAttribute("comCode", comCode);
            	httpServletRequest.setAttribute("prpCmainDto", classCode);	
              //��ҳ����������嵥��
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
                //modify by lym 20060605 for ǿ�� --start
				PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
						policyNo, registDto.getPrpLregistDto()
								.getDamageStartDate().toString(), registDto
								.getPrpLregistDto().getDamageStartHour());
               
            	httpServletRequest.setAttribute("prpCmainDto", policyDto.getPrpCmainDto());	
            	httpServletRequest.setAttribute("statQuantity", policyDto.getPrpCmainDto().getStatQuantity());
            	//�����־
            	if(policyDto.getPrpCmainDto()!=null){
            		businessFlag = policyDto.getPrpCmainDto().getBusinessFlag();
            	}
            	httpServletRequest.setAttribute("businessFlag", businessFlag);
               
			   if("D".equals(strRiskType)){
					
//					 new ȡ�¹�����������------------------
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
					// ȡ�޶�---------------------------
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
					// ȡǿ�Ʊ����޶�----------------------------------------------
	               
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
                    //modify by lym 20060606 for ǿ�� --end
	                

				}
				//**************�жϱ����Ƿ��Ѿ�ʵ��add by qinyongli 2005-7-21
                //UIPolicyAction uiPolicyAction = new UIPolicyAction();
                String conditions = " policyno = '" + policyDto.getPrpCmainDto().getPolicyNo() + "'";
                int intReturn = 0;
                intReturn = uiPolicyAction.checkPay(conditions);//-1Ϊδ�ɷѣ�0Ϊδ��ȫ��1Ϊ��ȫ
                String strPayFlag = String.valueOf(intReturn);
                httpServletRequest.setAttribute("payFlag",strPayFlag);

                /**
                 * modify by mengdongdong start
                 * resion:���ɷѲ���ʱ,Ҫ��ʾ��Ӧ�Ľɷ����
                 * 2006-1-19
                 */
        		//Ƿ�����
        		String delinquentfeeCase = "";
        		//������δ��ȫ,����Է��ڸ�������Ҫ��ʾ�ļ��ڷ���δ��
        		if(intReturn == -2 && policyDto.getPrpCmainDto().getPayTimes()>1){			
        			delinquentfeeCase = new DAARegistViewHelper().getDelinquentfeeCase(policyDto.getPrpCmainDto());
        		}
        		//���÷��ڸ���δ������
        		httpServletRequest.setAttribute("delinquentfeeCase",delinquentfeeCase);
                
                PrpLregistDto prpLregistDto = new PrpLregistDto();
                prpLregistDto.setPayFlag(intReturn+"");
                httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
                /**
                 * modify by mengdongdong end
                 * resion:���ɷѲ���ʱ,Ҫ��ʾ��Ӧ�Ľɷ����
                 * 2006-1-19
                 */
                
                //��ȡϵͳ������Ϣ
                UIConfigAction uiConfigAction = new UIConfigAction();
                String configValue = "" ; //��ȡ����δʵ���Ƿ�������Ϣ
                configValue = uiConfigAction.getConfigValue("ALLOW_UNPAYED_CLAIM",policyDto.getPrpCmainDto().getRiskCode());
                //����������������
                String standard_stringDays = uiConfigAction.getConfigValue("REPORT_DEFER_DAYS",policyDto.getPrpCmainDto().getRiskCode());
                if(configValue==null||configValue.equals("")){
                	throw new UserException(1,3,"platform","" +
                			"����ϵϵͳ����Ա����ƽ̨����ϵͳ�н�������"+policyDto.getPrpCmainDto().getRiskCode()+"'����δʵ���Ƿ���������'�ĳ�ʼ����");
                }
                if(standard_stringDays==null||standard_stringDays.equals("")){
                	throw new UserException(1,3,"platform","" +
                			"����ϵϵͳ����Ա����ƽ̨����ϵͳ�н�������"+policyDto.getPrpCmainDto().getRiskCode()+"'����������������'�ĳ�ʼ����");
                }
                long standard_days =Long.parseLong(standard_stringDays);
                
              
                //���configValue =2 intReturn��=1���ʾδ���Ѳ�������
               if(configValue.equals("2")&&intReturn!=1){
                	ActionMessages messages = new ActionMessages();
                    ActionMessage message = new ActionMessage("prompt.claim.feeFailure");
                    messages.add(ActionMessages.GLOBAL_MESSAGE, message);
                    saveMessages(httpServletRequest, messages);
                    forward = "ADDDAAFALSE";
                    
                    return actionMapping.findForward(forward);
                }
                //**************�жϱ����������������Ƿ����ϵͳ�涨ʱ�䣬���ڲ��������� add by qinyongli 2005-7-28
                DateTime damageDate = registDto.getPrpLregistDto().getDamageStartDate();
                DateTime reportDate = registDto.getPrpLregistDto().getReportDate();
                long report_damage_days = (reportDate.getTime()-damageDate.getTime())/(1000*60*60*24);
                  //��ȡϵͳ�涨ʱ�� standard_days
                if(report_damage_days>standard_days){
                	ActionMessages messages = new ActionMessages();
                    ActionMessage message = new ActionMessage("prompt.claim.report_damage_standardDays");
                    messages.add(ActionMessages.GLOBAL_MESSAGE, message);
                    saveMessages(httpServletRequest, messages);
                    forward = "ADDDAAFALSE";
                    System.out.println("�жϱ�������������������ϵͳ�涨ʱ�䣬������������");
                    return actionMapping.findForward(forward);
                }
                //*******************************************add end 
                
                //���ݱ�����ȡ�ñ�����Ϣ
                UIClaimAction uiClaimAction = new UIClaimAction();
                //modify by lym 20060605 for ǿ�� -----start
                // PrpCmainDto prpCmainDto = uiClaimAction.findByPolicyNoKey(registDto.getPrpLregistDto().getPolicyNo());
                PrpCmainDto prpCmainDto = uiClaimAction.findByPolicyNoKey(policyNo);
                //modify by lym 20060605 for ǿ�� -----start
                
                
                //����ʱ�䲻�ڱ����ڼ��ڵİ���������ʱϵͳ������ʾ������ʱӲ���ƣ��߾�������ⰸ�����̡� 
                if (registDto.getPrpLregistDto().getDamageStartDate().before(prpCmainDto.getStartDate())
                        || registDto.getPrpLregistDto().getDamageStartDate().after(prpCmainDto.getEndDate())) {
                  //modify  by   ��Ŀ�� ������   �������ж�ͳһ��װ��һ�����н����ж�
               	 //if((14<Integer.parseInt(riskCode.substring(0,2))&&Integer.parseInt(riskCode.substring(0,2))<20) //�ж��ǲ���������
                	DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
                	boolean isOutPeriod = false;//����ʱ���Ƿ��ڱ����ڼ���
                	if(RiskCodeTools.IsLiab(riskCode)	//�ж��ǲ���������	 
                	 		&&registDto.getPrpLregistDto().getDamageStartDate().after(policyDto.getLiabStartDate())
							&&registDto.getPrpLregistDto().getDamageStartDate().before(policyDto.getPrpCmainDto().getStartDate())){
                	 	           //�����գ���׷��������������,�Զ�����
                	 	  isOutPeriod = true;         
                	 }else if("05".equals(policyDto.getPrpCmainDto().getClassCode())){
                		 int[] intDamageHour = new int[2];
                		 //ȡ����Сʱ�����ӣ����д洢�ĸ�ʽΪ��hh:mm:ss
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
             
               
                // �����жϸñ����Ƿ��Ѿ�������
                uiClaimAction = new UIClaimAction();
                // ��uiCLaimAcction���Զ�ʶ���Ƿ�Ҫ��ô��ѯ�ľ������
                
                //modify by lym 20060604  for ǿ��  ----start
                strSql = "registNo ='" + registNo + "'  and riskcode = '" + riskCode +"'";
              
                //modify by lym 20060604  for ǿ��  ----end
                
                Collection claimList = new ArrayList();
               
                claimList = (Collection) uiClaimAction.findByConditions(strSql);
                // ˵����ѯ���ñ����Ѿ���������
                if (claimList.size() > 0) {
                    ActionMessages messages = new ActionMessages();
                    ActionMessage message = new ActionMessage("prompt.claimAdd.false");
                    messages.add(ActionMessages.GLOBAL_MESSAGE, message);
                    saveMessages(httpServletRequest, messages);
                    forward = "ADDDAAFALSE";
                    return actionMapping.findForward(forward);
                }
               
                
                // �����ύ״̬�İ����ſ�����
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

                // ������������
                // ==================================================
                // ����ռ�ŷ�����ֻ�е��й����������LogNo��ʱ�����ʹ�á�
                // ���û��flowID��logno�򲻽����жϡ�

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
    	    	   //��ɵ�������
     	    	    	throw new UserException(1,3,"0000","������"+flowID+"���Ȼ���û�н��������ܽ���������");
     	    	    }
     	    	    
     	       }  
                   
//         	       if (modelnoInt.equals(1)){ 
//         	    	   UIWorkFlowAction   uiWorkFlowActioncheck = new UIWorkFlowAction();
//        	    	    Collection noSubmitNodesList=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+flowID +"' and nodeType='propc' and nodestatus='4'");
//        	    	    //Collection noSubmitNodesListCheck=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+swfLogDto.getFlowID() +"' and nodeType='check' and nodestatus<'4'");
//        	    	   
//        	    	    if (noSubmitNodesList.size()<1) {
//        	    	   //��ɵ�������
//        	    	    	throw new UserException(1,3,"0000","������"+flowID+"�Ʋ����𻷽�û�н��������ܽ���������");
//        	    	    }
        	    	    
//        	       } 
//         	       if (modelnoInt.equals(12)||modelnoInt.equals(14)){ 
//         	    	   UIWorkFlowAction   uiWorkFlowActioncheck = new UIWorkFlowAction();
//        	    	    Collection noSubmitNodesList=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+flowID +"' and nodeType='check' and nodestatus='4'");
//        	    	    //Collection noSubmitNodesListCheck=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+swfLogDto.getFlowID() +"' and nodeType='check' and nodestatus<'4'");
//        	    	   
//        	    	    if (noSubmitNodesList.size()<1) {
//        	    	   //��ɵ�������
//        	    	    	throw new UserException(1,3,"0000","������"+flowID+"�鿱����û�н��������ܽ���������");
//        	    	    }
//        	    	    
//        	       }
//         	       if (modelnoInt.equals(87)){ 
//         	    	   UIWorkFlowAction   uiWorkFlowActioncheck = new UIWorkFlowAction();
//        	    	    Collection noSubmitNodesList=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+flowID +"' and nodeType='propv' and nodestatus='4'");
//        	    	    //Collection noSubmitNodesListCheck=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+swfLogDto.getFlowID() +"' and nodeType='check' and nodestatus<'4'");
//        	    	   
//        	    	    if (noSubmitNodesList.size()<1) {
//        	    	   //��ɵ�������
//        	    	    	throw new UserException(1,3,"0000","������"+flowID+"�Ʋ����𻷽�û�н��������ܽ���������");
//        	    	    }
//        	    	    
//        	       }
               	if(logNo != null)
            	{

                    SwfLogDto swfLogDto = new SwfLogDto();
                    swfLogDto = uiWorkFlowAction.holdNode(flowID, Integer.parseInt(logNo), user.getUserCode(), user
                            .getUserName());
                    if (swfLogDto.getHoldNode() == false) {
                        msg = "����'" + registNo + "'�Ѿ�������:'" + swfLogDto.getHandlerCode() + "',����:'"
                                + swfLogDto.getHandlerName() + "'���û���ռ��,��ѡ�������������д���!";
                        throw new UserException(1, 3, "������", msg);
                    }
            	}
                }
                // ===============================================
                DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
                dAAClaimViewHelper.registDtoToView(httpServletRequest, registNo);
                //add by wunier 20071228
                //reason���������⸶������Ӧ�ĵ�λ��Ϣ
                riskCode = policyNo.substring(1,5);
                conditions =" codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"+riskCode+"' and codetype='Unit')";
                Collection collection = uiCodeAction.findByConditions(conditions);
                httpServletRequest.setAttribute("lossesUnitCodeCollection",collection);
                //end by wunier 20071228
                //��ȡ������������
                String policyInputDate=policyDto.getPrpCmainDto().getInputDate().toString();
                httpServletRequest.setAttribute("policyInputDate",policyInputDate );  

            }

            if (editType.equals("EDIT") || editType.equals("SHOW")) {
            	claimNo = httpServletRequest.getParameter("prpLclaimClaimNo"); // �ⰸ��
            	
                // ��ѯ������Ϣ,�������룬���ڳ�ʼ������ʾ
                
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
                intReturn = uiPolicyAction.checkPay(conditions1);//-1Ϊδ�ɷѣ�0Ϊδ��ȫ��1Ϊ��ȫ
                String strPayFlag = String.valueOf(intReturn);
                httpServletRequest.setAttribute("payFlag",strPayFlag);
                policyNo = claimDto.getPrpLclaimDto().getPolicyNo();
                //��ҳ����������嵥��
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
	                // modify  by lym 20060605 for ǿ��---start
	                //PolicyDto policyDto = endorseViewHelper.findForEndorBefore(registDto.getPrpLregistDto().getPolicyNo(),
	                PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,
	                        registDto.getPrpLregistDto().getDamageStartDate().toString()
							,registDto.getPrpLregistDto().getDamageStartHour());
	                // modify  by lym 20060605 for ǿ��----end
	//              modify by lym 20060606 for ǿ�� -start 
	                 //new ȡ�¹�����������------------------
	               
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
	               
	//              modify by lym 20060606 for ǿ�� --end 
	               
	                // ȡ�޶�---------------------------
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
					  //ȡǿ�Ʊ����޶�----------------------------------------------
	              
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
                 * resion:���ɷѲ���ʱ,Ҫ��ʾ��Ӧ�Ľɷ����
                 * 2006-1-19
                 */
        		PrpCmainDto cmainDto = (PrpCmainDto)new UIPolicyAction().findPrpCmainDtoByPrimaryKey(claimDto.getPrpLclaimDto().getPolicyNo());
        		//Ƿ�����
        		
            	httpServletRequest.setAttribute("prpCmainDto", cmainDto);	
            	//�����־
            	if(cmainDto!=null){
            		businessFlag = cmainDto.getBusinessFlag();
            	}
            	httpServletRequest.setAttribute("businessFlag", businessFlag);
               
        		String delinquentfeeCase = "";
        		//������δ��ȫ,����Է��ڸ�������Ҫ��ʾ�ļ��ڷ���δ��
        		if(intReturn == -2 && cmainDto.getPayTimes()>1){			
        			delinquentfeeCase = new DAARegistViewHelper().getDelinquentfeeCase(cmainDto);
        		}
        		//���÷��ڸ���δ������
        		httpServletRequest.setAttribute("delinquentfeeCase",delinquentfeeCase);
                PrpLregistDto prpLregistDto = new PrpLregistDto();
                prpLregistDto.setPayFlag(intReturn+"");
                httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
                
                DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
                dAAClaimViewHelper.claimDtoToView(httpServletRequest, claimNo);
                //add by wunier 20071228
                //reason���������⸶������Ӧ�ĵ�λ��Ϣ
                riskCode = policyNo.substring(1,5);
                String conditions =" codetype='Unit' and codecode in (select codecode from prpdcoderisk where riskcode='"+riskCode+"' and codetype='Unit')";
                Collection collection = uiCodeAction.findByConditions(conditions);
                httpServletRequest.setAttribute("lossesUnitCodeCollection",collection);
                //end by wunier 20071228

                
                PolicyDto policyDto = new UIPolicyAction().findByPrimaryKey(claimDto.getPrpLclaimDto().getPolicyNo());
            	String policyInputDate=policyDto.getPrpCmainDto().getInputDate().toString();
                //��Σ�յ�λȡ�����Ƶ�����
                httpServletRequest.setAttribute("policyInputDate",policyInputDate );  
            }
            
            //δ������������ķ�������
            if (editType.equals("GIVUP")) {
                //add by huangyunzhong 20051226 ����δ�ݴ���ύ����������ɾȥ�������ˣ�ʹ�����˿ɼ��ɴ���
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

            // ȡ��forward
            forward = BusinessRuleUtil.getForward(httpServletRequest, riskCode, "claim", editType, 1);
            // ===============================================================

            if (editType.equals("LOSS")) {
                claimNo = httpServletRequest.getParameter("prpLclaimClaimNo"); // �ⰸ��
                DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
                dAAClaimViewHelper.claimDtoToView(httpServletRequest, claimNo);
                forward = "ADDLOSS";
            }
            saveToken(httpServletRequest);
            
            /**�󻧵�ͼ��Ϣ��ʾ����*/
            PrpLclaimDto prpLclaimDto = (PrpLclaimDto)httpServletRequest.getAttribute("prpLclaimDto"); //������
            registNo = prpLclaimDto.getRegistNo();
		      if(AppConfig.get("sysconst.GIS_FAMILY_RISKCODE").indexOf(riskCode)>-1
		    		  /*SysConfig.getProperty("PLNATING_FARMER_LIST_FLAG").indexOf(riskCode)>-1
						|| SysConfig.getProperty("BREEDING_FARMER_LIST_FLAG").indexOf(riskCode)>-1
						|| "3139,3141".indexOf(riskCode)>-1*/){
		    	  /**��ô���Ϣ*/
		    	  UIPrpLregistRPolicyAction uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction();
		    	  Collection collection = uiPrpLregistRPolicyAction.findByConditions(" Registno = '"+ registNo +"' ");
		    	  if(collection.size()>0){
		    		  PrpLRegistRPolicyDto prpLregistRPolicyDto = (PrpLRegistRPolicyDto)collection.iterator().next();
			    	  String gisPolicyNo = prpLregistRPolicyDto.getPolicyNo();
			    	  UIRegistAction uiRegistAction = new UIRegistAction();
		              RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
			    	  EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		                //modify by lym 20060605 for ǿ�� --start
						PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
								gisPolicyNo, registDto.getPrpLregistDto()
										.getDamageStartDate().toString(), registDto
										.getPrpLregistDto().getDamageStartHour());
			    	  String strRichFlyCode = policyDto.getPrpCmainDto().getRichFlyCode();
			    	  /**��*/
			    	  httpServletRequest.setAttribute("GisRichFlyCode", strRichFlyCode);
			    	  /**������*/
			    	  httpServletRequest.setAttribute("GisRegistNo", registNo);
			    	  /**�Ƿ���ʾ��ͼ��Ϣ��ť*/
			    	  if(!"".equals(strRichFlyCode)){
			    		  httpServletRequest.setAttribute("IsDisplayGisViewInfo", "1");
			    	  }else{
			    		  httpServletRequest.setAttribute("IsDisplayGisViewInfo", "0");
			    	  }
			    		  
		    	  }
		      }
            
        } catch (UserException usee) {
            usee.printStackTrace();
            // ������Ϣ����
            ActionErrors errors = new ActionErrors();
            ActionError error = new ActionError("title.claimBeforeEdit.editClaim");
            errors.add(ActionErrors.GLOBAL_ERROR, error);
            httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
            saveErrors(httpServletRequest, errors);
            forward = "error";
        } catch (Exception e) {
            e.printStackTrace();
            // ������Ϣ����
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
