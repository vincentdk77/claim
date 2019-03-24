package com.gyic.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.gyic.claim.ui.control.viewHelper.AgriCombineCertainLossViewHelper;
import com.gyic.claim.ui.control.viewHelper.AgriCombineCheckViewHelper;
import com.gyic.claim.ui.control.viewHelper.AgriCombineVerifyLossViewHelper;
import com.gyic.claim.utils.Utils;
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
 * �ַ�HTTP Post ��������鿱�༭����
 * <p>Title: ��������鿱�༭������Ϣ</p>
 * <p>Description: ��������鿱�༭������Ϣ</p>
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
		String forward = ""; //��ǰ��ת
		try {
			UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");

			
			//reason: ��ֹ�ظ��ύ--------------------------------------------------------------------
			String strLastAccessedTime = "" + httpServletRequest.getSession().getLastAccessedTime() / 1000;
			String oldLastAccessedTime = (String) httpServletRequest.getSession().getAttribute("oldCheckLastAccessedTime");
			//�����˻صĶ��𣬲�����û�������κμ�¼�ı�ǣ����Ϊ1��˵��������ֱ���ύ������ȥ��
			String NextComeBackCompensate=httpServletRequest.getParameter("NextComeBackCompensate");
			
			
			if (oldLastAccessedTime != null && !oldLastAccessedTime.trim().equals("")) 
				throw new UserException(1, 3, "������", "�벻Ҫ�ظ��ύ");
			
			httpServletRequest.getSession().setAttribute("oldCheckLastAccessedTime", strLastAccessedTime);
			String[] registNoValues = httpServletRequest.getParameterValues("combineRegistNo");
			ArrayList<CertainLossDto> certainLossDtoList = new ArrayList<CertainLossDto>();
			ArrayList<WorkFlowDto> workFlowDtoList = new ArrayList<WorkFlowDto>();
			ArrayList<CheckDto> checkDtoList = new ArrayList<CheckDto>();
			ActionMessages messages = new ActionMessages();
			for(int index = 0;index < registNoValues.length; index++)
			{	
				
				
				String checkNo = ""; //�鿱��
				checkNo = httpServletRequest.getParameter("prpLcheckRegistNo_"+index);
				//////////////
				UIWorkFlowAction uiWorkFlowActionCheck = new UIWorkFlowAction();
				String conditions = " registNo = '"+checkNo+"' and nodeType = 'check' and nodestatus !='4'";
				Collection swfLogCollection = null;
				swfLogCollection = uiWorkFlowActionCheck.findNodesByConditions(conditions);
				if(null == swfLogCollection || swfLogCollection.size()!=1)
					throw new Exception ("�ڵ��쳣,�����ţ�"+checkNo);
				//////////////////
				String comCode=user.getComCode() ;
				String riskCode = httpServletRequest.getParameter("prpLcheckRiskCode_"+index);
				String nextHandlerCode=httpServletRequest.getParameter("nextHandlerCode_"+index);
				String nextHandlerName=httpServletRequest.getParameter("nextHandlerName_"+index);
				String insureCarFlag=httpServletRequest.getParameter("prpLcheckInsureCarFlag_"+index); //�Ƿ�Ϊ����������
				String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID_"+index); //����������
				String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo_"+index); //������logno
				String[] prpLthirdPartyLossFlag =httpServletRequest.getParameterValues("prpLthirdPartyLossFlag_"+index); 
			    String activeSchedule=httpServletRequest.getParameter("messageToScheduleCheck_"+index); //֪ͨ���ȣ�ʹ���ȹ�������ɴ�����״̬
			    String registno =  httpServletRequest.getParameter("registno_"+index);
			    String autoScheduleFlag = httpServletRequest.getParameter("autoScheduleFlag_"+index);//�Զ����ȱ�־
			    
			    
			    // �жϵ�ǰ�����Ƿ��������,Ĭ��Ϊfalse,����Ѿ�������Ϊtrue
			    boolean claimFlag = false;
			    BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
				List claimList = (List)blPrpLclaimFacade.findByConditions("registno = '" + registno + "'");
				PrpLclaimDto prpLclaimDto = null;
				if(claimList.size() != 0 ){
					prpLclaimDto = (PrpLclaimDto)claimList.get(0);
					claimFlag = true;
				}
			    
				String lossItemName = httpServletRequest.getParameter("lossItemName_"+index);
				//�Ƿ������ų�����������߳����������κβ鿱����Ϣ��ֻ�ǰѹ������͵�����Ϳ�����
				int year =DateTime.current() .getYear() ;
				int nextNodeNo=0;
				
				//if(isTokenValid(httpServletRequest,true)){
				if (checkNo== null||checkNo.length()<1||checkNo.trim().equals(""))
				{
					UIBillAction uiBillAction = new UIBillAction();
					String tableName = "prplcheck";
					checkNo = uiBillAction.getNo(tableName, riskCode, comCode, year);
				}
				httpServletRequest.setAttribute("checkNo_"+index, checkNo);
				httpServletRequest.setAttribute("registNo_"+index, checkNo);
				//��viewHelper�����������
				//���������ߣ����������������ݽ��зֱ����������
				DAACheckViewHelper dAACheckViewHelper = new DAACheckViewHelper();
				AgriCombineCheckViewHelper agriCombineCheckViewHelper = new AgriCombineCheckViewHelper();
				DAACertainLossViewHelper dAACertainLossViewHelper = new DAACertainLossViewHelper();
				AgriCombineCertainLossViewHelper agriCombineCertainLossViewHelper = new AgriCombineCertainLossViewHelper();
				AgriCombineVerifyLossViewHelper agriCombineVerifyLossViewHelper = new AgriCombineVerifyLossViewHelper();
				//modify by miaowenjun 20060922 ũ�����Լ���viewhelper
				String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
				CheckDto checkDto = new CheckDto();
				VerifyLossDto verifyLossDto = new VerifyLossDto();
				CertainLossDto certainLossDto = new CertainLossDto();
				
				if("I".equals(riskType)||"H".equals(riskType)||"Q".equals(riskType)||"Z".equals(riskType)){
					checkDto = agriCombineCheckViewHelper.viewToDto(httpServletRequest,index);
					verifyLossDto = agriCombineVerifyLossViewHelper.viewToDto(httpServletRequest,index);
					certainLossDto = agriCombineCertainLossViewHelper.viewToDto(httpServletRequest,index);
				    //����������ж�����д��,�������������ݵĴ���
					if("H".equals(riskType)&&claimFlag){
						//��������������ݵı���
						//BLCheckFacade blCheckFacade = new BLCheckFacade();
						//blCheckFacade.saveClaimLoss(prpLclaimDto, verifyLossDto.getPrpLpropDtoList());
					}
				}else{
					//������������by GYIC�ž���checkDto = dAACheckViewHelper.viewToDto(httpServletRequest);
					//������������by GYIC�ž���certainLossDto = dAACertainLossViewHelper.viewToDto(httpServletRequest);
				}
				//�������������
				//-----------------------------------------------------
				// 1requst����,2���ڵ�Ľڵ�����,3���ڵ���Ҫ���µ�״̬,4���ڵ��ҵ�����,5�Ժ�ڵ��ҵ�����,6���ڵ��ҵ���������,7�Ժ�ڵ��ҵ����������
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
				//�ط��ǲ鿱�ύ�����Ļط�,û��typeflag��ֵ,1��ʾ�鿱�طã�2��ʾ����ط�
				swfLogDtoDealNode.setTypeFlag("1");
				//swfLogDtoDealNode.setLossItemName("lossItemName");
				
	//			Collection nextNodeList = new ArrayList();  
	//			if("Z".equals(riskType)||"Q".equals(riskType)){//�����������������ڲ��Ǹ��ݲ鿱��¼�����Ϣ�ж��������˶�����߲Ʋ����𣬶���ֻ�вƲ����𣬶��Ҳ鿰����Ҳ��¼����ʧ��Ϣ������д��
	//				SwfLogDto swfLogNextNode = new SwfLogDto();               
	//				swfLogNextNode.setNodeNo(0);  
	//				swfLogNextNode.setNodeType("certa");               
	//				swfLogNextNode.setLossItemCode("-1");
	//				nextNodeList.add(swfLogNextNode); //LossItemCode: 0 ��ʾ����-1 ��ʾ�Ʋ���-2 ��ʾ����
	//			}
	//			if (nextNodeList.size() >0){
	//				swfLogDtoDealNode.setNextNodeListType("1");//�����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
	//				swfLogDtoDealNode.setSwfLogList(nextNodeList);
	//			}
				/*
				//��Ϊ�˵��˵�ԭ��
				
				//modify by liujianbo modify start 2005-10-19
				//if (swfLogDtoDealNode.getNodeStatus().equals("4")){  
				Collection nextNodeList = new ArrayList();           
				//}
				//modify by liujianbo modify end 2005-10-19
				
				
				//[ֻ���������򲻲�����ĳ�����������]------------------------------------------------
				RegistDto  registDto = new RegistDto();
				UIRegistAction  uiRegistAction =new UIRegistAction();
				registDto = uiRegistAction.findByPrimaryKey(checkNo);
				String  damageDate = String.valueOf(registDto.getPrpLregistDto().getDamageStartDate());
				String  damageHour = registDto.getPrpLregistDto().getDamageStartHour();
				String  policyNo   = registDto.getPrpLregistDto().getPolicyNo();
				String kindCode ="";
				String kindAFlag ="0";  //����ʱ���ޱ������յı�־ 1���� 0����
				String kindBFlag ="0";  //����ʱ���ޱ������յı�־ 1���� 0����
				EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
				// ���ݳ���ʱ���ҵ�����
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
					  //modify by lixiang start 2006-6-18 //reason:��������ǿ����
					  if (kindCode.equals("B") || kindCode.equals("B1")|| kindCode.equals("BZ")) {
	//				  modify by lixiang end 2006-6-18
					  	  kindBFlag ="1";
					  }
					
				   }
	            }
				
	           //
	            // ������й�����ǿ�Ʊ��ձ�����Ҳ��Ϊ��Ͷ����������
	            //
	            if(new BLPrpLRegistRPolicyFacade().getCompelFlag(registDto.getPrpLregistDto().getRegistNo())){
	            	kindBFlag = "1";
	            }
	            
				System.out.println("================[  kindAFlag ][  ���޳����ձ�־ 1���� 0���� ]=====" +kindAFlag);
				System.out.println("================[  kindBFlag ][  ���������ձ�־ 1���� 0���� ]=====" +kindBFlag);
				
				//----------------------------------------------------------------------------------
				
				//modify by wangli add 200505016
				//reason:�˴��ж����Ϊ�⽡�� ����Ϊ �����գ�Ӧ��keyin���� �ⰸ�ţ�����Ϊ������
				//ͨ��������ձ�ת��riskcode
				UICodeAction uiCodeAction = new UICodeAction();
				String classCode = "";
				//�жϵ�Ϊ ���� ��ʱ��ȡ����ǰ��λ������ȡǰһλ��Ĭ��Ϊ��أ�
				
				//modify by wangwei modify start 2005-06-19
				//ԭ����ע�͵����´���
				
				
	
					
	                //��ʾ����¼��һ������Ϣ----start---------------------
					if(    ( checkDto.getPrpLpersonTraceDtoList()==null ||  checkDto.getPrpLpersonTraceDtoList().size()<1) 
					    && ( checkDto.getPrpLthirdPropDtoList() ==null  || checkDto.getPrpLthirdPropDtoList().size()<1 )
					   ){
					 if( checkDto.getPrpLthirdPartyDtoList() != null &&  //��ʾ�ǳ���
	                     ( checkDto.getPrpLthirdPartyDtoList().size()<2	&&  prpLthirdPartyLossFlag[1].equals("0") ) ) //����ֻ�б�ĳ���Ϣ������ĳ�������
					 {
					 	ActionMessages messages = new ActionMessages();
						messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("title.checkEdit.noCar"));
						saveMessages(httpServletRequest, messages);
						return actionMapping.findForward("success");
						
				      }
					}
					////��ʾ����¼��һ������Ϣ---end-----------	
						
					//�����⽡��ʱstart----------------------------------------------------------------
					//modify by liujianbo modify start 2005-10-19
					if(checkDto.getPrpLthirdPartyDtoList()!=null&&checkDto.getPrpLthirdPartyDtoList().size()>0){    //�м�����
						for(int i=0;i<checkDto.getPrpLthirdPartyDtoList().size();i++){
							PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)checkDto.getPrpLthirdPartyDtoList().get(i);
							if (kindAFlag.equals("0") && prpLthirdPartyDto.getInsureCarFlag().equals("1")){ //��û��������ʱ�������������ն�������
								continue;
							}
							if (kindBFlag.equals("0") && prpLthirdPartyDto.getInsureCarFlag().equals("0")){ //��û�������գ���������鿱��¼�����߳�ʱ�������������ն�������
								continue;
							}
							if ( prpLthirdPartyLossFlag[1].equals("0") &&prpLthirdPartyDto.getInsureCarFlag().equals("1") ){ //��ĳ�û���𣬵����˳�����,��������ĳ�����
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
							
							//���泵�Ƶĺ��� 
							swfLogNextNode.setLossItemName(prpLthirdPartyDto.getLicenseNo());
							
							//�����Ƿ񱣵������ı�־  
							swfLogNextNode.setInsureCarFlag(String.valueOf(prpLthirdPartyDto.getSerialNo())) ;
							nextNodeList.add(swfLogNextNode);  
						}    
					} 
					if(checkDto.getPrpLpersonTraceDtoList()!=null&&checkDto.getPrpLpersonTraceDtoList().size()>0){ //�м�����
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
					if(checkDto.getPrpLthirdPropDtoList()!=null&&checkDto.getPrpLthirdPropDtoList().size()>0){ //�м����Ʋ�
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
						swfLogDtoDealNode.setNextNodeListType("1");//�����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
						swfLogDtoDealNode.setSwfLogList(nextNodeList);
					}
					*/
					//modify by liujianbo modify end 2005-10-19
					swfLogDtoDealNode.setKeyIn(checkDto.getPrpLcheckDto().getRegistNo());	
					workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
			           
			       //�޸Ĳ鿱֪ͨ���ȵķ�ʽ
			           UIWorkFlowAction uiWorkFlowAction  = new UIWorkFlowAction ();
			           //֪ͨ����
			           if ("4".equals(swfLogDtoDealNode.getNodeStatus())&&"1".equals(activeSchedule)){
			              if (workFlowDto.getUpdateSwfLogDto()!=null){
			                	String flowID=workFlowDto.getUpdateSwfLogDto().getFlowID();
			                 		//����û����ɵĵ��ȣ��������ڴ���ĵ���
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
			           //    ��֪ͨ����     
			           if ("4".equals(swfLogDtoDealNode.getNodeStatus())&&"0".equals(activeSchedule)){
			            //���Ϊ�鿱�ύ�����ж��ǲ�����Ҫ֪ͨ���ȵ�ѡ��, activeSchedule.equals( "0")˵������Ҫ֪ͨ���ȵ�
			           	//��Ȼ����Ҫ֪ͨ��������Ҫ�ж��Ƿ����еĵ��ȶ��Ѿ������ˣ���������ˣ�����Ҫ������������
			           	  if (workFlowDto.getUpdateSwfLogDto()!=null){
			                	String flowID=workFlowDto.getUpdateSwfLogDto().getFlowID();
			                 		//����û����ɵĵ��ȣ��������ڴ���ĵ���
			                 		String conditonss="flowId='"+flowID+"' and nodeType='sched' and nodestatus<'4'";
			                 		Collection schedList = uiWorkFlowAction.findNodesByConditions(conditonss);
			                 		if (schedList!=null&&schedList.size() >0){
			                 			String strSql=" registno='"+checkDto.getPrpLcheckDto().getRegistNo()+"' and surveyTimes<1";
			           	                UIScheduleAction uiScheduleAction = new UIScheduleAction();
			           	                Collection scheduleItemList =uiScheduleAction.findItemByConditions(strSql);
			           	                if (scheduleItemList !=null && scheduleItemList.size() >0){
			           	        	        //û����ɵ����ء���
			           	        	        System.out.println("û����ɵ����ء���");
			           		               workFlowDto.setUpdateSwfLog2Dto(null);
			           	                }else{
			           	                    
			           	                    //����鿱�������˵��ȵ������أ� ��Ҳ���ܽ�����
			           	                    //add by lixiang start 2005-10-18
			           	                    //reason:����������ӱ�ģ�������������ύ����
			           	                    if (checkDto.getPrpLscheduleItemDtoList()==null || checkDto.getPrpLscheduleItemDtoList().size()==0){
			           	                        //modify by liyanjie 2005-12-21 start
			           	                    	//����˫����Ե�ʣ�����鿱����ʱ��checkDto.prpLscheduleItemDtoListֻ��������������Ŀ��
			           	                    	//���Բ��ð�ԭ���ķ����жϣ�ֱ�ӿ�checkDto.getPrpLscheduleItemDtoList.size�Ƿ�Ϊ0�Ϳ�����
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
			      
				//����鿱��Ϣ
				
				UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
				/*
				 if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate()) ||(workFlowDto.getSubmit())||(workFlowDto.getClose()))
				 {
				 uiCheckAction.save(checkDto,certainLossDto,workFlowDto);
				 user.setUserMessage(checkNo);
				 } else {
				 if (insureCarFlag.equals("1") ) uiCheckAction.save(checkDto,certainLossDto);
				 user.setUserMessage(checkNo+";ע��:û�з����빤������������κ����ݣ���");
				 }
				 */
				
			//���������Ϣ
				if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate()) ||(workFlowDto.getSubmit())||(workFlowDto.getClose()))
				{ 
					certainLossDtoList.add(certainLossDto);
					checkDtoList.add(checkDto);
					workFlowDtoList.add(workFlowDto);
					
					//���涨����Ϣ
					//������������if("H".equals(riskType)){
					//������������	uiVerifyLossAction.save(verifyLossDto);
					//������������}
				
					//user.setUserMessage(checkNo);
				} else {
					if (insureCarFlag.equals("1") ) {
						certainLossDtoList.add(certainLossDto);
						checkDtoList.add(checkDto);
						//������������uiCheckAction.save(checkDto,certainLossDto );
						}
					
				}
				
				//httpServletRequest.setAttribute("messagepagevalue",checkNo) ;
				httpServletRequest.setAttribute("prpLcheckDto_"+index,checkDto.getPrpLcheckDto() ) ;
				//}
				//������������String checkSaveMessage = "q"+checkNo;
				//������������System.out.println(checkSaveMessage);
				
				//������������Object obj_msg = checkSaveMessage;
				
				//�⽡�պͷ��⽡���ڲ鿱������ʾ��ͬ����Ϣ 2005-09-05
				//if ("27".equals(riskCode.substring(0,2)) || "26".equals(riskCode.substring(0,2))) {  
				//modify by   ��Ŀ��  ������  ����27��Ϊ07
				
				
				//�鿱������Զ����� ��ʼ
				if("1".equals(autoScheduleFlag) && "D".equals(riskType) ){				
					//1.ȡ������Ϣ�Ĵ���󣬵���id��scheduleID����1
					UIScheduleAction uiScheduleAction = new UIScheduleAction();
				    ScheduleDto scheduleDto = uiScheduleAction.findByPrimaryKey(1,checkNo);
					//2.���������ڵ�Ĵ���
					boolean finishSchedule = true;// �Ƿ���ɵ���
					//2.1ȡ���Ƚڵ�
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
						scheduleHandlerCode = swfLogDtoScheduleNode.getHandlerCode();//��¼�µ��Ƚڵ�Ĵ���Ա
						scheduleHandlerName = swfLogDtoScheduleNode.getHandlerName();
						
						//2.2��������ڵ�
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
				                  //������Ⱥ����itemitemNo�ĺ���
				                  swfLogNextNode.setScheduleID(prplScheduleItemDto.getScheduleID()) ;
				                  swfLogNextNode.setLossItemCode(prplScheduleItemDto.getItemNo() + "");
					              //���泵�Ƶĺ���
					              swfLogNextNode.setLossItemName(prplScheduleItemDto.getLicenseNo());
					              //�����Ƿ񱣵������ı�־
					              swfLogNextNode.setInsureCarFlag(prplScheduleItemDto.getInsureCarFlag()) ;
				                  //������־λ
				                  swfLogNextNode.setExigenceGree(prplScheduleItemDto.getExigenceGree());
				                  swfLogNextNode.setNewHandleDept(prplScheduleComCode);
				                  
				                  nextNodeList.add(swfLogNextNode);
				               }
						}
						//����Ҫ�������ȵĽڵ�ʱ���Ž����Զ�����
						if (nextNodeList.size() >0){
							swfLogDtoScheduleNode.setNextNodeListType("1");//�����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
							swfLogDtoScheduleNode.setSwfLogList(nextNodeList);
							
							//3.�������������(prpLscheduleItem)���鿱��������(prpLscheduleMainWF)���ô���
						    PrpLscheduleItemDto prpLscheduleItemDto = new PrpLscheduleItemDto();
						    for(int i = 0; i < scheduleDto.getPrpLscheduleItemDtoList().size(); i++){
						    	prpLscheduleItemDto = (PrpLscheduleItemDto)scheduleDto.getPrpLscheduleItemDtoList().get(i);
						    	if(prpLscheduleItemDto.getSurveyTimes() == 0){
						    		prpLscheduleItemDto.setSurveyTimes(1);
						    		prpLscheduleItemDto.setScheduleObjectID(prplScheduleComCode);
						    		prpLscheduleItemDto.setScheduleObjectName(prplScheduleComName);
						    		prpLscheduleItemDto.setOperatorCode(user.getUserCode());
						    		if("".equals(prpLscheduleItemDto.getExigenceGree()) || prpLscheduleItemDto.getExigenceGree() == null){
						    			prpLscheduleItemDto.setExigenceGree("1");//����״̬1��һ�㰸����0����������
						    		}
						    	}
						    }
						    
						    //4. �����̵����⴦�� 
							WorkFlowDto workFlowDtoSchedule = workFlowViewHelper.viewToDto(user,swfLogDtoScheduleNode);
							
							// ��һ���Թ������Ĵ������Ƚڵ�Ĵ���Ա����Ϊ��ǰ�ύ�鿱�ڵ�Ĵ���Ա���˴����仹ԭΪԭ���Ĵ���Ա
							workFlowDtoSchedule.getUpdateSwfLogDto().setHandlerCode(scheduleHandlerCode);
							workFlowDtoSchedule.getUpdateSwfLogDto().setHandlerName(scheduleHandlerName);
							
							//5.������ȼ���������Ϣ
							 if ((workFlowDtoSchedule.getCreate()) || (workFlowDtoSchedule.getUpdate())
									|| (workFlowDtoSchedule.getSubmit())
									|| (workFlowDtoSchedule.getClose())) {
								uiScheduleAction.save(scheduleDto, workFlowDtoSchedule);
							} else {
								uiScheduleAction.save(scheduleDto, workFlowDtoSchedule);
								user.setUserMessage("������:" + checkNo
										+ ";ע��:û�з����빤������������κ����ݣ���");
							}
						    messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.schedule.submit"));
					    }	
					}				
				}
				// �鿱������Զ����� ����
				//messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLregist.registNo"));
				

			}
			UICheckAction uiCheckAction = new UICheckAction();
			uiCheckAction.save(checkDtoList,certainLossDtoList,workFlowDtoList);

			// ���������� SCHEDULE_AUTOCOMMIT��������Ҫ�Զ���ת�����ȵĲ��ż����Զ���ת�Ĺ���
			String strSchedule = AppConfig.get("sysconst.SCHEDULE_AUTOCOMMIT");
			String comCodeTemp = user.getComCode().substring(0,4);
//			System.out.println("------�Զ���ת�ж�-----"+strSchedule+"---comCode---"+comCodeTemp+"---index---"+strSchedule.indexOf(comCodeTemp));
			//if(strSchedule.indexOf(comCodeTemp)>=0){
			//��Ҫ�Զ���ת
			//System.out.println("------��Ҫ�Զ���ת-----");
			// httpServletResponse.sendRedirect("/claim/certainLossBeforeEdit.do?RegistNo="+checkNo+"&editType=SelectLossType");
			//<a href="/claim/scheduleDealRegist.do?prpLscheduleMainWFRegistNo=RDAA200431000000000044&editType=ADD&prpLscheduleMainWFSurveyNo=1">  RDAA200431000000000044 </a>
			//}else{
			//����Ҫ�Զ���ת
			if(workFlowDtoList.size() < registNoValues.length){
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.workflow.submitfalse"));
				//messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLclaim.registNo"));
				user.setUserMessage("�¹ʺţ�"+httpServletRequest.getParameter("combineNo")+";ע��:û�з����빤������������κ����ݣ���");
			}
			else
			{
	
				if(httpServletRequest.getParameter("buttonSaveType").trim().equals("4")){
					messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.check.submit"));
				}else {
					messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.check.save"));
				}
				user.setUserMessage("�¹ʺţ�"+httpServletRequest.getParameter("combineNo")+";");		
			}
			saveMessages( httpServletRequest, messages );
			forward = "success";
			// }
			
		}
		catch(UserException usee)
		{
			usee.printStackTrace() ;
			//������Ϣ����
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
			//������Ϣ����
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
			//������Ϣ����
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
