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
	 * ũ�յ�����Ϣ
	 * @param agriScheduleDto
	 * @return
	 */
	public String saveAgriScheduleDto(AgriScheduleDto agriScheduleDto){
		long serial = System.currentTimeMillis();
		logger.log("ũ�յ�����Ϣ", 1,serial, agriScheduleDto);
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
			if(prpCmainDto != null && "agri".equals(prpCmainDto.getSystemFlag())){//��ũ��
				//String URL = "http://9.0.2.33:9012/services/ClaimForDispatchService?wsdl";
				String URL = AppConfig.get("sysconst.NEWAGRI_SCHEDULESAVE");
				String xml = XMLHandler.getSaveAgriScheduleDtoXML(agriScheduleDto);
				System.out.println("ũ�յ�����Ϣ�����ģ�"+xml);
				logger.log("ũ�յ�����Ϣ�����ģ�", 0,serial, xml);
				Service service = new Service();
				ClaimForDispatchServiceSoapBindingStub stub = 
						new ClaimForDispatchServiceSoapBindingStub(new java.net.URL(URL),service);
				String returnMessage = stub.saveAgriScheduleDto(xml);
				System.out.println("ũ�յ�����Ϣ���ر��ģ�"+returnMessage);
				logger.log("ũ�յ�����Ϣ���ر��ģ�", 0,serial, returnMessage);
				String flag1 = returnMessage.substring(returnMessage.indexOf("<code>")+6, returnMessage.indexOf("</code>"));
				if("01".equals(flag1)){
					flag = "001";
				}
				logger.log("ũ�յ�����Ϣ", 0,serial, "[flag:"+flag+"]");
			}else{//������
				UIScheduleDealInfoCheckAndTrans trans = new UIScheduleDealInfoCheckAndTrans();
				String result = trans.checkAgriScheduleInfo(agriScheduleDto);
				if(null != result && !"".equals(result)){
					if(result.indexOf("001^")>-1){
						System.out.println("����У��"+result);
						flag = "002";//����У�鲻�ϸ�
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
				logger.log("ũ�յ�����Ϣ", 0,serial, "[flag:"+flag+"]");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	   
		return flag;
	} 
	/**
	 * �Ʋ��յ�����Ϣ
	 * @param propScheduleDto
	 * @return
	 */
	public String  savePropScheduleDto(PropScheduleDto propScheduleDto){
		long serial = System.currentTimeMillis();
		logger.log("�Ʋ��յ�����Ϣ", 1,serial,propScheduleDto);
		String flag="000";
		UIScheduleDealInfoCheckAndTrans trans = new UIScheduleDealInfoCheckAndTrans();
		String result = trans.checkPropScheduleInfo(propScheduleDto);
		if(null != result && !"".equals(result)){
			if(result.indexOf("001^")>-1){
				System.out.println("����У��"+result);
				flag = "002";//����У�鲻�ϸ�
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
		logger.log("�Ʋ��յ�����Ϣ", 0,serial, "[flag:"+flag+"]");
		return flag;
	}
	
	
	private String uiScheduleEditPost(UIScheduleDealEditPostInfo uIScheduleDealEditPostInfo,UserDto user,long serial){
		String flag="000";
		try{
			String registNo = uIScheduleDealEditPostInfo.getPrpLscheduleMainWFRegistNo();
			String riskCode = uIScheduleDealEditPostInfo.getPrpLscheduleMainWFRiskCode();
			String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
			
			int scheduleID=1;
			
			String  activeSchedule = "";//�鿱֪ͨ���Ƚ��ж������
			
			AgriScheduleViewHelper agriScheduleViewHelper = new AgriScheduleViewHelper();
		    ScheduleDto scheduleDto = new ScheduleDto();
			
		  //����⽡�գ�Ҳ��ũ�յ�viewhelper modified by xiatian 
		   if("I".equals(riskType)||"H".equals(riskType)||"Q".equals(riskType)||"Z".equals(riskType)||"Y".equals(riskType)||"E".equals(riskType)){
		       scheduleDto = agriScheduleViewHelper.viewToDtoNew(user, uIScheduleDealEditPostInfo);
		       //���ɻط���Ϣ begin
		       DAAReturnVisitViewHelper daaReturnVisitViewHelper = new DAAReturnVisitViewHelper();
		       PrplreturnvisitswflogDto prplreturnvisitswflogDto  = daaReturnVisitViewHelper.setReturnVisitSwflogDtoNew(user, registNo, "sched", "0");
		       scheduleDto.setPrplreturnvisitswflogDto(prplreturnvisitswflogDto);
		       //���ɻط���Ϣ end
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
		    	return "003";//������δ����ĵ��Ƚڵ�
		    }
		    
		    boolean finishSchedule=true;//�Ƿ���ɵ���
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
		    
	        //�������Ͳ�ͬ��������ͬ
	        Collection nextNodeList = new ArrayList();
	        //�鿱���ȵ�ѡ��
	        String  checkSelectSend=uIScheduleDealEditPostInfo.getCheckSelectSend();
	        String oldcheckFlag =uIScheduleDealEditPostInfo.getPrpLscheduleMainWFScheduleFlag();
	        boolean selectCheckNow=false;
			if ("15".equals(activeSchedule)) {
			}// ���ٲ鿱��
			else {
				if ("0".equals(oldcheckFlag)&& "1".equals(checkSelectSend)) {
						// ѡ���˲鿱����
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

						selectCheckNow = true;// ��ʾ����ѡ���˲鿱����
				}
			}
			int maxRow = 0;
	        //�⽡�ղ���Ҫ��Ӷ������ modified by xiatian 
	        if(!"Q".equals(riskType)&&!"Y".equals(riskType)&&!"Z".equals(riskType)&&!"E".equals(riskType)){
	      	  maxRow =1 ;
	        }
		    
	        //������־λ
	        String exigenceGree  =uIScheduleDealEditPostInfo.getExigenceGree();
	        String endflag = "0";
	        //���ȱ�Ĳ��ֿ�ʼ
	        int itemNo=0;
	        //�������ѡ���˲鿱���ȣ���ȫ�������������۶����Ƿ�ѡ���ˣ�����Ϊ���Ⱦ���û�����
	        //endflag=1,��ʾ������
	        if (selectCheckNow&& "0".equals(endflag)) {
	        	finishSchedule=false;
	        }
	        //���ûѡ�鿱���ȣ���û�����
	        if ("0".equals(checkSelectSend )){
	        	finishSchedule=false;
	        } 
	        
	        String selectSend=uIScheduleDealEditPostInfo.getPrpLscheduleItemSelectSend();//ѡ����е���
	        String surveyTimes=uIScheduleDealEditPostInfo.getPrpLscheduleItemSurveyTimes();//�Ƿ�Ϊ�Ѿ����ȹ��ģ�
	        String nextHandlerCode=uIScheduleDealEditPostInfo.getNextHandlerCode();      //ָ����һ���ڵ�����˴���
	        String nextHandlerName=uIScheduleDealEditPostInfo.getNextHandlerName();      //ָ����һ���ڵ����������
	        String strNextNode=uIScheduleDealEditPostInfo.getNextNodeNo();               //ָ����һ���ڵ���
	        String prpLscheduleItemItemNo=uIScheduleDealEditPostInfo.getPrpLscheduleItemItemNo();//���ȱ�׺�
	        String prpLscheduleItemScheduleObjectID     =uIScheduleDealEditPostInfo.getPrpLscheduleItemScheduleObjectID();
	        
	        //�����������
//	        String strClauseType = httpServletRequest.getParameter("clauseType");
	        if(maxRow ==1){
	        	if (selectSend.equals("0")) {
	                finishSchedule=false;
	            }
	            
	            if (selectSend.equals("1")&&surveyTimes.equals("0")) {
	               SwfLogDto swfLogNextNode = new SwfLogDto();
	               swfLogNextNode.setNodeNo(0);
	               swfLogNextNode.setNodeType(strNextNode);//�ڽ�����jsָ���˸����������ͣ��綨������ʲô�ġ�
	               swfLogNextNode.setHandlerCode(nextHandlerCode);
	               swfLogNextNode.setHandlerName(nextHandlerName);
	               //������Ⱥ����itemitemNo�ĺ���
	               swfLogNextNode.setScheduleID(scheduleID) ;
	               swfLogNextNode.setLossItemCode(prpLscheduleItemItemNo);
	               //modify by miaowenjun 20060928 ũ��û����Щ����
//	               if(!"I".equals(riskType)&&!"H".equals(riskType)){
//		                  //���泵�Ƶĺ���
//		                  swfLogNextNode.setLossItemName(prpLscheduleItemLicenseNo);
//		                  //�����Ƿ񱣵������ı�־
//		                  swfLogNextNode.setInsureCarFlag(prpLscheduleInsureCarFlag) ;
//	               }
	               //������־λ
	               swfLogNextNode.setExigenceGree(exigenceGree);
	               swfLogNextNode.setNewHandleDept(prpLscheduleItemScheduleObjectID );
	               
	               //Modify by wangwei add start 2006-01-14
	               //Reason: F22(�����������������α�������),��ĳ�û�ж����ڴ��Զ�������
//	               if ("F22".equals(strClauseType) && "1".equals(prpLscheduleItemItemNo)) {
//	                  swfLogNextNode.setNodeStatus("6"); 
//	               }
	               //Modify by wangwei add start 2006-01-14
	               
	               nextNodeList.add(swfLogNextNode);
	            }
	        }
	        
	        if (nextNodeList.size() >0){
	            swfLogDtoDealNode.setNextNodeListType("1");//�����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
	            swfLogDtoDealNode.setSwfLogList(nextNodeList);
	        }
	            
	        // �����̵����⴦��
	        WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
	        String  msg="";
	        if (!finishSchedule && workFlowDto.getUpdate()) {
				workFlowDto.getUpdateSwfLogDto().setNodeStatus("2");
			} else {
				if (workFlowDto.getUpdate()) { // ���֮ǰ�Ƿ��в鿱�����һ�û�����Ľڵ�
					// ˫������,���ڲ鿱���ɳ��յ�����������,�б���(commiflag=2)�ύʱ�����жϲ鿱�Ƿ����� add by
					// liyanjie 2005-12-20
					if (!"2".equals(scheduleDto.getPrpLscheduleMainWFDto()
							.getCommiFlag())) { // if �ж�add by liyanjie 2005-12-20
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
			flag = "001";//����ʧ��
			logger.log("ũ�յ�����Ϣ",serial,e);
		}
	    
		return flag;
	}

}
