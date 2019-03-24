package com.gyic.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.bz.common.RequestType;
import com.sinosoft.ciplatform.bl.facade.BLCIClaimSYXPlatFormInterfaceFacade;
import com.sinosoft.ciplatform.bl.facade.BLCIPlatformConfigFacade;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.claim.bl.facade.BLClaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacadeBase;
import com.sinosoft.claim.bl.facade.BLPrpLpropFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIReinsTrialAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.AgriClaimViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAAClaimViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claimciplatform.bl.action.custom.BLCIClaimPlatFormCheckAction;
import com.sinosoft.claimciplatform.bl.action.custom.BLCIClaimPlatFormInterfaceAction;
import com.sinosoft.claimciplatform.bl.facade.BLCIClaimPlatFormInterfaceFacade;
import com.sinosoft.claimciplatform.dto.custom.ClaimCiPlatFormException;
import com.sinosoft.claimciplatform.dto.custom.Iconstants;
import com.sinosoft.claimciplatform.dto.custom.PlatFormParam;
import com.sinosoft.platform.bl.facade.BLPrpDriskConfigFacade;
import com.sinosoft.platform.dto.domain.PrpDriskConfigDto;
import com.sinosoft.reins.out.bl.facade.BLCTrialFacade;
import com.sinosoft.reins.out.bl.facade.BLFhTreatyFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpLdangerUnitFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpLreinsTrialFacade;
import com.sinosoft.reins.out.bl.facade.BLRepayFacade;
import com.sinosoft.reins.out.dto.custom.CReinsTrialDto;
import com.sinosoft.reins.out.dto.domain.FhTreatyDto;
import com.sinosoft.reins.out.dto.domain.PrpCreinsTrialDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerUnitDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.gyic.claim.ui.control.viewHelper.AgriCombineClaimViewHelper;

/**
 * �ַ�HTTP Post �������������༭����
 * <p>Title: �������������༭������Ϣ</p>
 * <p>Description: �������������༭������Ϣ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author lijiyuan,lixiang
 * @version 1.0
 */
public class UILClaimEditPostFacade extends Action {
	private static Log logger = LogFactory.getLog(UILClaimEditPostFacade.class);
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		String forward = ""; //��ǰ��ת
		String claimNo = "";
		/*
		 * ����˼·��
		 *========================================================
		 *[1]������������Ϣ
		 *[2]���永��״̬����Ϣ��strNodeStatus
		 *[3]�ж�strNodeStatus�ǲ��ǵ����ύ�����ǵĻ���ֱ���޸Ĺ�����Map�е�״̬λ��Update
		 *[4]�����ύ��ִ��Complate������
		 *========================================================
		 */
		String[] arrayRegistNo = httpServletRequest.getParameterValues("registNo");
		try {

			//������µǼǣ����ȡ�ű���ȡ�ⰸ���룬������޸ģ��򱣳�ԭ����claimNo����
			//ȡ�ⰸ��
			// 0 ��ʾ����Ҫ�� 1��ʾ��Ҫ
			//String claimNo ="";
			String comCode = "";
			String userCode = "";
			ClaimDto claimDto = null;
			ArrayList<ClaimDto> claimDtoList = new ArrayList<ClaimDto>();
			ArrayList<WorkFlowDto> workFlowDtoList = new ArrayList<WorkFlowDto>();
			UIClaimAction uiClaimAction = new UIClaimAction();
			String strLastAccessedTime = String.valueOf(httpServletRequest.getSession().getLastAccessedTime()/ 1000);
			String oldLastAccessedTime = (String) httpServletRequest.getSession().getAttribute("oldClaimLastAccessedTime");
			if (oldLastAccessedTime !=null && !oldLastAccessedTime.trim().equals("")) {
		    	   throw new UserException(1, 3, "������", "�벻Ҫ�ظ��ύ");
		       }
			
				httpServletRequest.getSession().setAttribute("oldClaimLastAccessedTime", strLastAccessedTime);
			

				UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
				userCode = user.getUserCode();
				String userLastActionNow = "claimAdd?"; //��ֹ�û��ظ��ύ
				String claimControlFlags="";
				if(null != arrayRegistNo && arrayRegistNo.length>0){					
					for(int indexOfRegistNo=0;indexOfRegistNo < arrayRegistNo.length;indexOfRegistNo ++){				
						claimNo = httpServletRequest.getParameter("prpLclaimClaimNo_"+indexOfRegistNo); //�ⰸ��
						String registNo = httpServletRequest.getParameter("prpLclaimRegistNo_"+indexOfRegistNo);
						//////////////
						UIWorkFlowAction uiWorkFlowActionCheck = new UIWorkFlowAction();
						String strCondition = " registNo = '"+registNo+"' and nodeType = 'claim' and nodestatus !='4'";
						Collection swfLogCollection = null;
						swfLogCollection = uiWorkFlowActionCheck.findNodesByConditions(strCondition);
						if(null == swfLogCollection || swfLogCollection.size()!=1)
							throw new Exception ("�ڵ��쳣,�����ţ�"+registNo);
						//////////////////
						String riskCode = httpServletRequest.getParameter("prpLclaimRiskCode_"+indexOfRegistNo);   //add by lym 20060605 for ǿ��
						String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
						String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID_"+indexOfRegistNo); //���������� add 20051228
						String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo_"+indexOfRegistNo); //������logno add  20051228

						comCode =  httpServletRequest.getParameter("prpLclaimComCode_"+indexOfRegistNo);
						int year = DateTime.current().getYear();
		
						
						//��ֹ����ˢ�����ύ�������ͬʱ�����ύͬһ������
						UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
						String condition = "flowId ='"+swfLogFlowID+"' and  logno= "+ swfLogLogNo+"  and nodeStatus in ('4')";
					    Collection certifyNodeList = uiWorkFlowAction.findNodesByConditions(condition);
					    if(certifyNodeList!=null&&certifyNodeList.size()>0){
					    	   throw new UserException(1,3,"������","�ð��������ڵ��Ѵ���");
					    }
						//��������������ύ��ʱ��Բ鿱�Ͷ��𻷽ڵĴ���״̬�����жϽ�������ֳ�ս��д���
						if("I".equals(riskType)){
							BLClaimFacade blClaimFacade = new BLClaimFacade();
							blClaimFacade.checkNodeStatus(swfLogFlowID);
						}
						
		
						if (claimNo.length() < 1 || claimNo == null) {
							//ȡ�Ź��̻���Ҫ��һ������
							UIBillAction uiBillAction = new UIBillAction();
							String tableName = "prplclaim";
							claimNo = uiBillAction.getNo(tableName, riskCode, comCode, year);
						}
		
						httpServletRequest.setAttribute("claimNo_"+indexOfRegistNo, claimNo);
		
						//��viewHelper�����������
		
						if("I".equals(riskType)||"H".equals(riskType)||"E".equals(riskType)){
							AgriCombineClaimViewHelper agriCombineClaimViewHelper = new AgriCombineClaimViewHelper();
							claimDto = agriCombineClaimViewHelper.viewToDto(httpServletRequest,indexOfRegistNo);
						}
						else{
						    DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
						    claimDto = dAAClaimViewHelper.viewToDto(httpServletRequest);
						}
						//add by wunier 20080107
						UIRegistAction uiRegistAction = new UIRegistAction();
						RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
						String businessType = registDto.getPrpLregistDto().getBusinessType();
						String businessType1 = registDto.getPrpLregistDto().getBusinessType1();
						String businessFlag = registDto.getPrpLregistDto().getBusinessFlag();
						String otherFlag	= registDto.getPrpLregistDto().getOtherFlag();
						claimDto.getPrpLclaimDto().setBusinessType(businessType);
						claimDto.getPrpLclaimDto().setBusinessType1(businessType1);
						claimDto.getPrpLclaimDto().setBusinessFlag(businessFlag);
						claimDto.getPrpLclaimDto().setOtherFlag(otherFlag);
						//end by wunier 20080107
						//add by fenglei 20080722 ���չ�Ԫ���ڵ���������,������������д��PrpLprop����������
						BLPrpLpropFacade blPrpLpropFacade = new BLPrpLpropFacade();
						String conditions="registNo='"+ registNo +"'";
						Collection PrpLpropDtoList = blPrpLpropFacade.findByConditions(conditions);
				    	 if (PrpLpropDtoList!=null &&PrpLpropDtoList.size()>0 ) {
				    	 	Iterator it = PrpLpropDtoList.iterator();
				    	 	  while(it.hasNext()){
				    	 		 PrpLpropDto prpLpropDto = (PrpLpropDto)it.next();
				    	 		prpLpropDto.setClaimNo(claimNo);
				    	 		blPrpLpropFacade.update(prpLpropDto);
				    	       }
				    	 }
						//end  by fenglei 20080722
						//�������������
						//-----------------------------------------------------
						// 1requst����,2���ڵ�Ľڵ�����,3���ڵ���Ҫ���µ�״̬,4���ڵ��ҵ�����,5�Ժ�ڵ��ҵ�����,6���ڵ��ҵ���������,7�Ժ�ڵ��ҵ����������
						WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
						SwfLogDto swfLogDtoDealNode = new SwfLogDto();
		
						//add by liuyanmei 20051228 start 
						if (!(swfLogFlowID == null || swfLogFlowID.equals("")) && !(swfLogLogNo == null || swfLogLogNo.equals(""))) {
							swfLogDtoDealNode.setFlowID(swfLogFlowID);
							swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
						}
						//add by liuyanmei 20051228 end 
		
						swfLogDtoDealNode.setNodeType("claim");
						swfLogDtoDealNode.setNodeStatus(claimDto.getPrpLclaimStatusDto().getStatus());
						swfLogDtoDealNode.setBusinessNo(registNo);
						swfLogDtoDealNode.setComCode(comCode);
						swfLogDtoDealNode.setNextBusinessNo(claimNo);
						//���� ����������������clamno��keyin����ֵ�ġ���
						swfLogDtoDealNode.setKeyIn(claimNo);
						swfLogDtoDealNode.setKeyOut(claimNo);
		
						WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDtoDealNode);
		
						//------------------------------------------------------------
						//���汨����Ϣ
						
		
						if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate())
								|| (workFlowDto.getSubmit())
								|| (workFlowDto.getClose())) {
							claimDtoList.add(claimDto);
							workFlowDtoList.add(workFlowDto);
							
							//user.setUserMessage("�¹ʺ�:"+httpServletRequest.getParameter("combineNo"));
						} else {
							//uiClaimAction.save(claimDto);
							//user.setUserMessage(claimNo + ";ע��:û�з����빤������������κ����ݣ���");
		
						}
						
						//��ֳ��ũ�ղ������죬��ʱ���γ��ղ��֡�
						//����ƽ̨�ϴ�
		//				try{
		//					if (httpServletRequest.getParameter("buttonSaveType").trim()
		//							.equals("4") && "D".equals(riskType)) {
		//						
		//						System.out.println("���Ͻ��н�ǿ��ƽ̨����");
		//						boolean isUpload = false;
		//						
		//						isUpload = BLCIClaimPlatFormCheckAction.checkUploadForClaim(claimNo);
		//						
		//						if(isUpload){
		//							BLCIClaimPlatFormInterfaceFacade.getInstance().upload(
		//									RequestType.CLAIM_SIGN,
		//									claimDto.getPrpLclaimDto().getClaimNo(),"", true,"0");
		//							
		//							user.setUserMessage(user.getUserMessage() + "<br>�ϴ�����ƽ̨�ɹ�!");
		//						}
		//						
		//						System.out.println("���Ͻ�����ҵ��ƽ̨����");
		//						//2011��ҵ��ƽ̨����
		//						String configValue="";
		//						
		//						UIClaimAction uIClaimAction=new UIClaimAction();
		//						ClaimDto claimDtopm=uIClaimAction.findByPrimaryKey(claimNo);
		//						String comcode=claimDtopm.getPrpLclaimDto().getComCode();
		//						boolean boo=false;
		//						if("0506".equals(riskCode)){
		//							boo=true;
		//						}
		//						if(boo && comcode!=null && !"".equals(comcode)){
		//							String comCodeSub=comCode.substring(0,2);
		//							BLCIPlatformConfigFacade bLCIPlatformConfigFacade=new BLCIPlatformConfigFacade();
		//							CIPlatformConfigDto cIPlatformConfigDto=bLCIPlatformConfigFacade.findByPrimaryKey("CI_TRANSPORT_MODE", comCodeSub, "0506");
		//							if(cIPlatformConfigDto!=null && "1".equals(cIPlatformConfigDto.getValidStatus())){
		//								configValue=cIPlatformConfigDto.getConfigValue();
		//								if("0".equals(configValue)) {//2011	0��ʱ������1�Ǽ�ʱ����
		//									BLCIClaimSYXPlatFormInterfaceFacade
		//									.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CLAIM_SYX,
		//											claimNo,
		//											true,cIPlatformConfigDto,"0","");
		//									user.setUserMessage(user.getUserMessage()
		//											+ "<br>�����ϴ���ҵ��ƽ̨�ɹ�!");
		//								}else{
		//									BLCIClaimSYXPlatFormInterfaceFacade
		//									.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CLAIM_SYX,
		//											claimNo,
		//											false,cIPlatformConfigDto,"0","");
		//									user.setUserMessage(user.getUserMessage()
		//											+ "<br>�����ϴ���ҵ��ƽ̨�ɹ�!");
		//								}
		//							}
		//						}
		//						
		//						
		//						
		//					}
		//				}catch(ClaimCiPlatFormException e){
		//					e.printStackTrace();
		//					user.setUserMessage(user.getUserMessage() + "<br>�ϴ�����ƽ̨ʧ�ܣ�<br>" + e.getMessage());
		//				}catch(Exception e ){
		//					e.printStackTrace();
		//					user.setUserMessage(user.getUserMessage() + "<br>�ϴ�����ƽ̨ʧ��<br>" + e.getMessage());
		//				}
						
						  String comCodeSub= swfLogDtoDealNode.getComCode().substring(0,2);
						  if (httpServletRequest.getParameter("buttonSaveType").trim().equals("4")){/*
					         PrpDriskConfigDto prpDriskConfigDto = new BLPrpDriskConfigFacade().findByPrimaryKey(comCodeSub, riskCode, "CI_TRANSPORT_MODE");
					         if(prpDriskConfigDto != null && "0".equals(prpDriskConfigDto.getConfigValue())){
					         	BLCIClaimPlatFormInterfaceFacade.getInstance().upload(Iconstants.RequstType.CLAIM, claimDto.getPrpLclaimDto().getClaimNo(), true);
					         }
					         if(prpDriskConfigDto != null && "1".equals(prpDriskConfigDto.getConfigValue())){
					         	BLCIClaimPlatFormInterfaceFacade.getInstance().upload(Iconstants.RequstType.CLAIM, claimDto.getPrpLclaimDto().getClaimNo(), true);
					         } 
						  */}
					         //add end by miaowenjun 20060711
		//			       add end by guolei 20060711 end
					 
						
						//��ֹ�ظ�ˢ��
						//user.setUserLastAction(userLastActionNow);
						httpServletRequest.setAttribute("prpLclaimDto_"+indexOfRegistNo, claimDto.getPrpLclaimDto());
					
		
					
					UICodeAction uiCodeAction =new UICodeAction();
					String strRiskCode = httpServletRequest.getParameter("prpLclaimRiskCode_"+indexOfRegistNo);
					String strConfigCode = uiCodeAction.translateRiskCodetoConfigCode(strRiskCode);
  
				}
					
					if(workFlowDtoList.size() < arrayRegistNo.length)
					{
						user.setUserMessage(httpServletRequest.getParameter("combineNo") + ";ע��:û�з����빤������������κ����ݣ���");
					}
					else
					{
						user.setUserMessage("�¹ʺ�:"+httpServletRequest.getParameter("combineNo"));
					}
					ActionMessages messages = new ActionMessages();
					if (httpServletRequest.getParameter("buttonSaveType").trim().equals("4")) {
						//add by dongyanqi begin 20050827���ɷ��ⰸ
						uiClaimAction.save(claimDtoList, workFlowDtoList,comCode, 
								userCode);
						messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.claim.submit"));
					} else {
						messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.claim.save"));
					}
					//messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLafterward.claimNo"));
					saveMessages(httpServletRequest, messages);
					
					if("".equals(claimControlFlags))
						claimControlFlags = getControlFlag(claimDto);
					else claimControlFlags = claimControlFlags + getControlFlag(claimDto);
					//�ٱ��е��ֽ�����ͬ���⴦��: ��Ҫ������ʾ. 2005-9-28
					  httpServletRequest.setAttribute("com.sinosoft.flag", claimControlFlags);
			}
			//��ֹ�ظ�ˢ��
			user.setUserLastAction(userLastActionNow);	
			forward = "success";
		} catch (UserException usee) {
			usee.printStackTrace();
			//������Ϣ����
			ActionMessages msgs = new ActionMessages();
			ActionMessage msg = new ActionMessage("title.claimBeforeEdit.editClaim");
			msgs.add(ActionMessages.GLOBAL_MESSAGE, msg);
			httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(httpServletRequest, msgs);
			forward = "error";
			for(int indexOfRegistNo=0;indexOfRegistNo < arrayRegistNo.length;indexOfRegistNo ++){				
				claimNo = httpServletRequest.getParameter("prpLclaimClaimNo_"+indexOfRegistNo); //�ⰸ��
			putNoback(claimNo);
			}
		}  catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//������Ϣ����
			ActionMessages msgs = new ActionMessages();
			ActionMessage msg = new ActionMessage("title.claimBeforeEdit.editClaim");
			msgs.add(ActionMessages.GLOBAL_MESSAGE, msg);
			httpServletRequest.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(httpServletRequest, msgs);
			forward = "error";
			for(int indexOfRegistNo=0;indexOfRegistNo < arrayRegistNo.length;indexOfRegistNo ++){				
				claimNo = httpServletRequest.getParameter("prpLclaimClaimNo_"+indexOfRegistNo); //�ⰸ��
			putNoback(claimNo);
			}
		}
		return actionMapping.findForward(forward);
	}

	/**
	 * �����ٱ����ֽ�����ͬ���ⷽ��
	 * @param ClaimDto ����Dto
	 * @return String ��ʾ��Ϣ:�Ƿ���Ҫ�ֽ�����ͬ����
	 */
	private String getControlFlag(ClaimDto claimDto) {
		String setControlFlagMsg = ""; //������ʾ��Ϣ
		String reinsMode = ""; //�ֱ���ʽ [1]=2����Լ
		String treatyNo = ""; //��Լ����
		String strControlFlag = ""; //�Ƿ񡰹�ͬ����/������ơ�
		boolean blnLargeLoss = false;
		boolean blnCashLoss = false;
		PrpCreinsTrialDto prpCreinsTrialDto = new PrpCreinsTrialDto();
		BLFhTreatyFacade blFhTreatyFacade = new BLFhTreatyFacade();
		FhTreatyDto fhTreatyDto = new FhTreatyDto();
		BLCTrialFacade blCTrialFacade = new BLCTrialFacade();

		try {
			CReinsTrialDto cReinsTrialDto = blCTrialFacade.getCTrialInfo(
					claimDto.getPrpLclaimDto().getPolicyNo(), 
					1, 
					claimDto.getPrpLclaimDto().getDamageStartDate().toString()
					);

			ArrayList prpCreinsTrialDtoList = (ArrayList) cReinsTrialDto.getPrpCreinsTrialDtoList();
			Iterator itTrial = prpCreinsTrialDtoList.iterator();

			while (itTrial.hasNext()) {
				prpCreinsTrialDto = (PrpCreinsTrialDto) itTrial.next();
				reinsMode = prpCreinsTrialDto.getReinsMode().substring(0, 1);

				if (reinsMode.equals("2")) { //Ϊ��Լ�ֱ�
					treatyNo = prpCreinsTrialDto.getTreatyNo();

					//���ݺ�Լ�ŵ�fhTreaty���л�ȡ��Լ��Ϣ
					fhTreatyDto = blFhTreatyFacade.findByPrimaryKey(treatyNo);
					strControlFlag = fhTreatyDto.getControlFlag();

					//�ж��ⰸ�Ĺ������Ƿ񳬹��ش��ⰸ֪ͨ��
					//�������������ʾ����Ա����Ҫ��ͬ����
					if (strControlFlag.equals("1")
							&& claimDto.getPrpLclaimDto().getSumClaim() >= fhTreatyDto.getLargeLossValue()
							&& blnLargeLoss == false) {
						setControlFlagMsg = "�˰���Ҫ��ͬ����.";
						blnLargeLoss = true;
					}

					//�жϹ������Ƿ񳬹��ֽ����֪ͨ��
					//�������������ʾ����Ա����Ҫ�ֽ����
					if (claimDto.getPrpLclaimDto().getSumClaim() >= fhTreatyDto.getCashLossValue()
							&& blnCashLoss == false) {
						setControlFlagMsg = setControlFlagMsg + "�˰���Ҫ�ֽ����.";
						blnCashLoss = true;
					}
				}
				if (blnLargeLoss == true && blnCashLoss == true) {
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return setControlFlagMsg;
	}

	//add by huangyunzhong ���ӳ����źŻع麯�� 20051208
	private boolean putNoback(String claimNo) throws SQLException, Exception {
		UIBillAction uiBillAction = new UIBillAction();
		String tableName = "prplclaim";
		if (uiBillAction.putNo(tableName, claimNo)) {
			logger.debug("���ŷŻسɹ�" + claimNo);
		} else {
			logger.debug("���ŷŻ�ʧ��" + claimNo);
		}
		return true;
	}
	//add end by huangyunzhong 20051208
}
