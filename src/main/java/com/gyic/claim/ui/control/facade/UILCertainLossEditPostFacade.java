package com.gyic.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.gyic.claim.utils.Utils;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICertainLossAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIConfigAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.gyic.claim.ui.control.viewHelper.AgriCombineCertainLossViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAACertainLossViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.utility.SysConfig;

/**
 * �ַ�HTTP Post �������ⶨ��༭����
 * <p>Title: �������ⶨ��༭������Ϣ</p>
 * <p>Description: �������ⶨ��༭������Ϣ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author liubvo
 * @version 1.0  
 */
public class UILCertainLossEditPostFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

		String forward = ""; //��ǰ��ת
		try {

			UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
			
			//reason: ��ֹ�ظ��ύ--------------------------------------------------------------------
			String strLastAccessedTime = "" + httpServletRequest.getSession().getLastAccessedTime() / 1000;
			String oldLastAccessedTime = (String) httpServletRequest.getSession().getAttribute("oldCertainLossLastAccessedTime");
			//�����˻صĶ��𣬲�����û�������κμ�¼�ı�ǣ����Ϊ1��˵��������ֱ���ύ������ȥ��
			String NextComeBackCompensate=httpServletRequest.getParameter("NextComeBackCompensate");
			
			
			if (oldLastAccessedTime != null && !oldLastAccessedTime.trim().equals("")) 
				throw new UserException(1, 3, "������", "�벻Ҫ�ظ��ύ");
			
				httpServletRequest.getSession().setAttribute("oldCertainLossLastAccessedTime", strLastAccessedTime);

				//��ֹ����ˢ�����ύ�������ͬʱ�����ύͬһ������
				String[] registNoValues = httpServletRequest.getParameterValues("combineRegistNo");
				String checkInput = "";
				ActionMessages messages = new ActionMessages();
				String nextHandlerCode = httpServletRequest.getParameter("nextHandlerCode");
				String nextHandlerName = httpServletRequest.getParameter("nextHandlerName");
				checkInput = httpServletRequest.getParameter("checkInput"); //������logno
				ArrayList certainLossDtoList = new ArrayList();
				//��ʼѭ����������DTO
				for(int index = 0;index < registNoValues.length; index++){
					String swfLogFlowID = "";
					String lossItemCode = "";
					String swfLogLogNo = "";
					String registNo = "";
					RegistDto registDto = null;
					String riskCodeTemp = httpServletRequest.getParameter("prpLverifyLossRiskCode_"+index);
				
					swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID_"+index); //����������
					swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo_"+index); //������logno
					
					Collection nextNodeList = new ArrayList();
	
					int nextNodeNo = 0;
					if (riskCodeTemp != null && riskCodeTemp.trim().length() > 0) {
						user.setRiskCode(riskCodeTemp);
					}
					//������ҵ��ʹ��
					registNo = httpServletRequest.getParameter("prpLverifyLossRegistNo_"+index); //������
					//////////////
					UIWorkFlowAction uiWorkFlowActionCheck = new UIWorkFlowAction();
					String conditions = " registNo = '"+registNo+"' and nodeType = 'certa' and nodestatus !='4'";
					Collection swfLogCollection = null;
					swfLogCollection = uiWorkFlowActionCheck.findNodesByConditions(conditions);
					if(null == swfLogCollection || swfLogCollection.size()!=1)
						throw new Exception ("�ڵ��쳣,�����ţ�"+registNo);
					//////////////////
					String claimNo = httpServletRequest.getParameter("prpLverifyLossClaimNo_"+index); //�ⰸ��
					lossItemCode = httpServletRequest.getParameter("prpLverifyLossLossItemCode_"+index); //��ʧ����
					String lossItemName = httpServletRequest.getParameter("prpLverifyLossLossItemName_"+index); //��ʧ����
					String verifyPriceFlag = httpServletRequest.getParameter("verifyPriceFlag_"+index); //�Ƿ���Ҫ�˼۱�־
					//add by miaowenjun 20060922 ��ȡ����
					String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCodeTemp);
					UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
					String condition = "flowId ='"+swfLogFlowID+"' and  logno= "+ swfLogLogNo+"  and nodeStatus ='4'";
				    Collection certifyNodeList = uiWorkFlowAction.findNodesByConditions(condition);
				    if(certifyNodeList!=null&&certifyNodeList.size()>0){
				    	   throw new UserException(1,3,"������","�ð�������ڵ��Ѵ���");
				    }
				    /*
				    String taskCode = SysConfig.getProperty("FamilySplittingFlag","claim");
				    if (httpServletRequest.getParameter("prpLverifyLossRiskCode") != null &&taskCode.indexOf(httpServletRequest.getParameter("prpLverifyLossRiskCode_"+index)) > -1) {
				    	 //start�������ʵ���ж�add by �ž���
					    String[] prplCompensateEarEarNo =httpServletRequest.getParameterValues("prplCompensateEarEarNo_"+index);
					    String   prpLCompensatePolicyNo  = httpServletRequest.getParameter("prpLverifyLossPolicyNo_"+index);
	
					    for(int i = 1;i < prplCompensateEarEarNo.length;i++)
						{
					    	if(prpLCompensatePolicyNo == null || prplCompensateEarEarNo[i] == null ) throw new UserException(1, 3, "�����Ż�����Ϊ��", "");
					    	if("".equals(prpLCompensatePolicyNo) || "".equals(prplCompensateEarEarNo[i]))  throw new UserException(1, 3, "�����Ż�����Ϊ��", "");
					    	ArrayList herdPolicyListResult = (ArrayList)Utils.findHerdpolicylist(prpLCompensatePolicyNo, prplCompensateEarEarNo[i]);
	
					    	ArrayList insureMainListDtoList = (ArrayList) herdPolicyListResult.get(0);
							if(insureMainListDtoList == null || insureMainListDtoList.size() == 0)
							{
								break;
							}
							ArrayList herdPolicyListDtoList = (ArrayList)herdPolicyListResult.get(1);
							if(herdPolicyListDtoList == null || herdPolicyListDtoList.size() == 0)
							{
								throw new UserException(1, 3, "�������ʵ�Լ��ʧ�ܣ�", "�������ʵ�Լ��ʧ�ܣ������"+prplCompensateEarEarNo[i]);
							}
						}
					    //end�������ʵ���ж�add by �ž���
				    }*/
			        //Modify by chenrenda update begin 20050420
					//Reason:�����ύ����ʱ��ȥ����Աѡ�����Ӻ��𼶱�
					int intItemCode = Integer.parseInt(DataUtils.nullToZero(lossItemCode));
					String prplCarLossHandlerRange = "";
					if (intItemCode > 0) {
						prplCarLossHandlerRange = httpServletRequest.getParameter("prplCarLossHandlerRange");
					}
					//Modify by chenrenda update end 20050420
	
					httpServletRequest.setAttribute("registNo_"+index, registNo);
					httpServletRequest.setAttribute("claimNo_"+index, claimNo);
	
	
					//if(isTokenValid(httpServletRequest,true)){
					//��viewHelper�����������
					
					CertainLossDto certainLossDto = new CertainLossDto();
					//modify by miaowenjun 20060922 ũ���߲�ͬviewhelper
					if("I".equals(riskType)||"H".equals(riskType)||"Q".equals(riskType)||"Z".equals(riskType)||"Y".equals(riskType)){
						AgriCombineCertainLossViewHelper agriCertainLossViewHelper = new AgriCombineCertainLossViewHelper();
						certainLossDto = agriCertainLossViewHelper.viewToDto(httpServletRequest,index);
					}else{
						//����������ʱ���ε�add by GYIC�ž���DAACertainLossViewHelper dAACertainLossViewHelper = new DAACertainLossViewHelper();
						//����������ʱ���ε�add by GYIC�ž���certainLossDto = dAACertainLossViewHelper.viewToDto(httpServletRequest);
					}
	
					UIRegistAction uiRegistAction = new UIRegistAction();
					registDto = uiRegistAction.findByPrimaryKey(registNo);
					String businessType = registDto.getPrpLregistDto().getBusinessType();
					String businessType1 = registDto.getPrpLregistDto().getBusinessType1();
					
					certainLossDto.getPrpLverifyLossDto().setBusinessType(businessType);
					certainLossDto.getPrpLverifyLossDto().setBusinessType1(businessType1);
					certainLossDtoList.add(certainLossDto);
				}
				ArrayList<CertainLossDto> certainLossDtoListWf = new ArrayList<CertainLossDto>();
				ArrayList<WorkFlowDto> workFlowDtoList = new ArrayList<WorkFlowDto>();
				String strRegistNo = "";
				UICertainLossAction uiCertainLossAction = new UICertainLossAction();
				if (checkInput != null && checkInput.equals("true")) {
					//��������if (lossItemCode.equals("1")) {
						uiCertainLossAction.save(certainLossDtoList);
	
						//��������} else {
						//��������uiCertainLossAction.save(certainLossDtoList);
						//��������}
					messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.certainLoss.save"));
					//ֻ���涨����Ϣ�����ùܹ��������
				} else {
					//�����빤�����йصĲ���
					// 1requst����,2���ڵ�Ľڵ�����,3���ڵ���Ҫ���µ�״̬,4���ڵ��ҵ�����,5�Ժ�ڵ��ҵ�����,6���ڵ��ҵ���������,7�Ժ�ڵ��ҵ����������
					//�ж��Ƿ���ֱ�Ӵ�0�������ύ����������Ƚ���ҵ�񱣴���� ���0->3 ,��3->4������״̬���,���ں�������˵��˵ķ�ʽ������ȥ�����µĴ���
					for(int index = 0;index < registNoValues.length; index++){
						String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID_"+index); //����������
						String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo_"+index); //������logno
						String registNo = httpServletRequest.getParameter("prpLverifyLossRegistNo_"+index); //������
						String lossItemCode = httpServletRequest.getParameter("prpLverifyLossLossItemCode_"+index); //��ʧ����
						UIRegistAction uiRegistAction = new UIRegistAction();
						RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
						
						WorkFlowDto workFlowDto = new WorkFlowDto();
						workFlowDto.setSwfNotionDtoList(((CertainLossDto)certainLossDtoList.get(index)).getSwfNotionList());
						//����Ĺ��������ã��Ƚ�����
						WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
						SwfLogDto swfLogDtoDealNode = new SwfLogDto();

						if (!swfLogFlowID.equals("null") && !swfLogLogNo.equals("null")) {
							swfLogDtoDealNode.setFlowID(swfLogFlowID);
							swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
						}
						swfLogDtoDealNode.setBusinessNo(registNo);
						swfLogDtoDealNode.setNextBusinessNo(registNo);
						String statusTemp = httpServletRequest.getParameter("buttonSaveType");
						swfLogDtoDealNode.setNodeStatus(statusTemp);
						swfLogDtoDealNode.setKeyIn(registNo);
						swfLogDtoDealNode.setKeyOut(registNo);
						swfLogDtoDealNode.setConditionBusinessNo(registNo);
						swfLogDtoDealNode.setLossItemCode(lossItemCode);
						swfLogDtoDealNode.setRiskCode(registDto.getPrpLregistDto().getRiskCode());
						
						/*
						if ("1".equals(NextComeBackCompensate)){
	                    	nextNodeList.clear();
	                    	SwfLogDto swfLogNextNode = new SwfLogDto();
							swfLogNextNode.setNodeNo(0);
							swfLogNextNode.setNodeType("compe");
							nextNodeList.add(swfLogNextNode);
							swfLogDtoDealNode.setNextNodeListType("1"); //�����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
							swfLogDtoDealNode.setSwfLogList(nextNodeList);
	                    }
						*/
						
	//					�ж�����������˻صĶ��𣬲��Ҹö���û�����������ݣ���ô����ֱ���ύ������ġ�
	//					��Ӧ�����⣬������㴦��������Ϣ��û��ɣ��ǲ����Խ��г�������ġ�					
						
						workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDtoDealNode);
						//���涨����Ϣ
						if (((CertainLossDto)certainLossDtoList.get(index)).getPrpLclaimStatusDto().getStatus().equals("4")
								&& workFlowDto.getSubmitSwfLogDtoList() == null) {
							//strRegistNo = strRegistNo + registNo + ";\r";
						} 
						else{
							if(workFlowViewHelper.checkDealDto(workFlowDto)) {
								//add by lixiang start at 2006-4-26
								//reason:�����ж�������ύ�����Ļ����������ʱ��Ҫ�����������ŵ�
								/*
								if ("1".equals(NextComeBackCompensate)
								  		&&workFlowDto.getSubmitSwfLogDtoList()!=null
										&&workFlowDto.getSubmitSwfLogDtoList().size()>0){
//								      ����businessNo,KeyIn��ֵ
									((SwfLogDto)((ArrayList)workFlowDto.getSubmitSwfLogDtoList()).get( 0)).setKeyIn( claimNo);
								  	((SwfLogDto)((ArrayList)workFlowDto.getSubmitSwfLogDtoList()).get( 0)).setBusinessNo( claimNo);
					
								 }
	                            	
	                            */
								workFlowDtoList.add(workFlowDto);
								certainLossDtoListWf.add((CertainLossDto)certainLossDtoList.get(index));
								//strRegistNo = strRegistNo + registNo + ";\r";
								//user.setUserMessage(registNo);
							}else{
								certainLossDtoListWf.add((CertainLossDto)certainLossDtoList.get(index));
								strRegistNo = strRegistNo +  registNo + ";\r";
							}
						}
					}
					if(certainLossDtoListWf.size() < registNoValues.length){
						uiCertainLossAction.save(certainLossDtoListWf);
						messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.workflow.submitfalse"));
						//messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLclaim.registNo"));
						user.setUserMessage("�¹ʺţ�"+httpServletRequest.getParameter("combineNo"));
					}
					else
					{
						if (httpServletRequest.getParameter("buttonSaveType").trim().equals("4")) {
							messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.certainLoss.submit"));
						} else {
							messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.certainLoss.save"));
						}
						//messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLclaim.registNo"));
						if(workFlowDtoList.size() != certainLossDtoListWf.size())
						{
							uiCertainLossAction.save(certainLossDtoListWf);
							user.setUserMessage(strRegistNo + ";ע��:û�з����빤������������κ����ݣ���");
						}
						else
						{
							uiCertainLossAction.save(certainLossDtoListWf, workFlowDtoList);
							user.setUserMessage("�¹ʺţ�"+httpServletRequest.getParameter("combineNo"));
						}
					}
				}

				//} isTokenValid
				saveMessages(httpServletRequest, messages);

				forward = "success";
				

		} catch (UserException usee) {
			usee.printStackTrace();
			//������Ϣ���� 
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.certainLossBeforeEdit.editCertainLoss");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (SQLException sqle) {
			StringWriter stringWriter = new StringWriter();
			sqle.printStackTrace(new PrintWriter(stringWriter));
			sqle.printStackTrace();
			//������Ϣ����
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.certainLossBeforeEdit.editCertainLoss");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//������Ϣ����
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.certainLossBeforeEdit.editCertainLoss");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";

		} finally {
		}
		return actionMapping.findForward(forward);
	}
}
