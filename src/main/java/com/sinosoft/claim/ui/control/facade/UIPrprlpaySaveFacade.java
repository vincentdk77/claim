package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrpLprepayFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
/*import com.sinosoft.claim.ui.control.viewHelper.DAAReviewViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAARulesmodleViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAARulesmodleViewHelper;*/
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.prpall.blsvr.lp.BLPrpLprepay;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;

public class UIPrprlpaySaveFacade extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String registno=request.getParameter("registNo_payment");
		String[] compensateno = request.getParameterValues("compensateno");
		String onlySaveReq = request.getParameter("onlySave");
		String businessNo = null;
		String forward = "s";
		String flag = request.getParameter("flag");
		try {
			
			/**
			 * ���ռ�ع���������������
			 * �����ᡱ��Ӱ�������̵���ת��ֻ����֧��¼�벻���ύ��*/
			//�жϰ����Ƿ񶳽�begin
			/*DAAReviewViewHelper daaReviewViewHelper = new DAAReviewViewHelper();
			if(!"true".equals(onlySaveReq)){
				boolean status = daaReviewViewHelper.CaseStatus(request, registno);
				if(status){
					String msg = "�����Ѷ��ᣬ�����ύ֧����";
					throw new UserException(1, 3, "", msg);
				}
			}*/
			//�жϰ����Ƿ񶳽�end
			
			String parentNodeSql="";//���Ҹ��ڵ�sql
			String parentNodeName="";//���ڵ�����
			boolean onlySave= false;
			if ("comp".equals(flag)) {
				businessNo = compensateno[0];
				parentNodeSql="businessno='" + businessNo+ "' and nodeType = 'compp'";
				parentNodeName="����";
			}else if ("prepay".equals(flag)) {
				businessNo = compensateno[0];
				parentNodeSql="keyout='" + businessNo+ "' and nodeType ='speci'";
				parentNodeName="Ԥ��";
			}else {
				onlySave=true;
				parentNodeName="��֤";
			}
			if (!StringUtils.isEmpty(onlySaveReq)&&"true".equals(onlySaveReq)) {
				onlySave=true;
			}
			UserDto userDto = (UserDto) request.getSession(true).getAttribute(
			"user");
			if (onlySave) {
				String vflag="1";
				//��֤���޸�״̬
				if ("certify".equals(flag)) {
					vflag="";
				}
				new BLPrplpayFacade().save(request,vflag);
				userDto.setUserMessage("֧����Ϣ����ɹ���");
			}else {
				if (businessNo == null ||StringUtils.isEmpty(businessNo)) {
					String msg = "֧����Ϣ�������Ϊ�գ������ύ������";
					throw new UserException(1, 3, "֧����Ϣ����", msg);
				}
				
	            boolean overHepei=true;
	            //δ����ͨ��ʱֻ����֧����Ϣ
	            if ("comp".equals(flag)) {
	            	BLPrpLcompensateFacade bLcompensateFacade=new BLPrpLcompensateFacade();
		            PrpLcompensateDto prpLcompensateDto= bLcompensateFacade.findByPrimaryKey(businessNo);
	            	//if (prpLcompensateDto==null||"1,3".indexOf(prpLcompensateDto.getUnderWriteFlag())<0) {
						new BLPrplpayFacade().save(request,"");
						//userDto.setUserMessage("δ����ͨ��,֧����Ϣ����ɹ���");
						userDto.setUserMessage("֧����Ϣ����ɹ���");
						overHepei=false;
					//}
				}
	            if ("prepay".equals(flag)) {
	            	BLPrpLprepayFacade blPrpLprepayFacade=new BLPrpLprepayFacade();
	            	PrpLprepayDto prpLprepayDto=blPrpLprepayFacade.findByPrimaryKey(businessNo);
	            	//if (prpLprepayDto==null||"1,3".indexOf(prpLprepayDto.getUnderWriteFlag())<0) {
						new BLPrplpayFacade().save(request,"");
						//userDto.setUserMessage("δ����ͨ��,֧����Ϣ����ɹ���");
						userDto.setUserMessage("֧����Ϣ����ɹ���");
						overHepei=false;
					//}
				}
	            //ͨ������ʱ�ϴ�ƽ̨
	            /**����������Ŀǰֻ�Ǳ���֧����Ϣ����ҵ����û�����κεĴ�����Ҫ���������ύƽ̨������ȵ���Ϣ����������ȵ���Ϣ
	             * �Ƚ��˴��ߺ���ƽ̨���ε���*/
	            overHepei = false;
	            if (overHepei) {
	            	PrpLregistDto prpLregistDto = new BLPrpLregistFacade().findByPrimaryKey(registno);
					WorkFlowDto workFlowDto = new WorkFlowDto();
					WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
					//��ȡ��һ���ڵ�
					SwfLogDto swfLogDtoDealNode = new SwfLogDto();
					BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
					ArrayList<SwfLogDto> apayList = null;
					
					apayList = (ArrayList<SwfLogDto>) blSwfLogFacade
							.findByConditions("businessno='" + businessNo
									+ "' and nodeType='apay' order by logno desc");
					SwfLogDto apayLog=null;
					if (apayList != null && !apayList.isEmpty()) {
						apayLog=apayList.get(0);
						if ("0,3".indexOf(apayLog.getNodeStatus())==-1) {//��ǰ���벻�������ݴ�״̬������ 2011��10��17��16:38:27
							String msg = "��֧����Ϣ�Ѿ��ύ���������������룡";
							throw new UserException(1, 3, "֧����Ϣ����", msg);
						}
					}

					
		            List<SwfLogDto> swfList=((ArrayList<SwfLogDto>) blSwfLogFacade
							.findByConditions(parentNodeSql));
		            BLSwfLogStoreFacade blSwfLogStoreFacade = new BLSwfLogStoreFacade();
		            if(swfList==null||swfList.isEmpty()){
		            	swfList= (ArrayList<SwfLogDto>)blSwfLogStoreFacade.findByConditions(parentNodeSql);
		            }
		            if (swfList.size()==0) {
						String msg = "δ����"+parentNodeName+"�ڵ㣡";
						throw new UserException(1, 3, "֧����Ϣ����", msg);
					}
					swfLogDtoDealNode = swfList.get(0);
					
					
					swfLogDtoDealNode.setNextBusinessNo(businessNo);
					ArrayList<SwfLogDto> nextNodeList = new ArrayList<SwfLogDto>();
					SwfLogDto nextSwfLogDto = new SwfLogDto();
					if (apayLog==null) {
						 //2.����������ڵ�״̬
						UIWorkFlowAction  uiWorkFlowAction =new UIWorkFlowAction();
				        SwfFlowMainDto swfFlowMainDto=uiWorkFlowAction.findFlowMainByPrimaryKey(swfLogDtoDealNode.getFlowID());//��flowstatus��Ϊ1
				        if(swfFlowMainDto.getFlowStatus().equals( "0") ){
				        	swfFlowMainDto.setFlowStatus( "1");
				            workFlowDto.setReOpen(true);
				            workFlowDto.setReOpenSwfFlowMainDto(swfFlowMainDto);
				            uiWorkFlowAction.deal(workFlowDto);
				        }
						//���������ڵ�
						nextSwfLogDto.setNodeType("apay");
						nextSwfLogDto.setNodeNo(0);
						nextSwfLogDto.setBusinessNo(businessNo);
						nextSwfLogDto.setSubmitTime(new DateTime(new Date(),DateTime.YEAR_TO_SECOND).toString());
						nextNodeList.add(nextSwfLogDto);
						swfLogDtoDealNode.setNextNodeListType("1");// �����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
						swfLogDtoDealNode.setSwfLogList(nextNodeList);
						swfLogDtoDealNode.setTaskType("S");//�޸��������ͣ�������ڵ�Ϊ�����ⰸ��T��ʱ ����������ִ�д����ͻ
						//������
						workFlowDto = workFlowViewHelper.viewToDto(userDto,
								swfLogDtoDealNode);
						
						workFlowDto.setUpdateSwfLogDto(null);
						nextSwfLogDto=((SwfLogDto) workFlowDto
								.getSubmitSwfLogDtoList().get(0));
						nextSwfLogDto.setSubmitTime(new DateTime(new Date(),DateTime.YEAR_TO_SECOND).toString());
						nextSwfLogDto.setNodeStatus("4");
						nextSwfLogDto.setKeyOut(businessNo);
						((SwfLogDto) workFlowDto
								.getSubmitSwfLogDtoList().get(0)).setKeyOut(businessNo);
					}else {
						swfLogDtoDealNode=apayLog;
						swfLogDtoDealNode.setNextBusinessNo(businessNo);
						swfLogDtoDealNode.setNodeStatus("4");
						swfLogDtoDealNode.setHandlerCode(userDto.getUserCode());
						swfLogDtoDealNode.setHandleDept(userDto.getComName());
						swfLogDtoDealNode.setKeyOut(businessNo);
						//������
						workFlowDto = workFlowViewHelper.viewToDto(userDto,
								swfLogDtoDealNode);
						((SwfLogDto) workFlowDto
								.getSubmitSwfLogDtoList().get(0)).setKeyOut(businessNo);
					}
					
				
					
					
					
					//���ƽ̨  �����ϴ�ƽ̨����   ȡ�����ΰ�&&falseȥ��
					if (workFlowViewHelper.checkDealDto(workFlowDto)) {
						
						new BLPrplpayFacade().save(request, workFlowDto);
						/*** ����ע�������ƽ̨ start****/
						/*int vericLogNo = 0;
						int size=workFlowDto.getSubmitSwfLogDtoList().size();
						if (workFlowDto.getSubmitSwfLogDtoList() != null
								&& size > 0) {
							vericLogNo = ((SwfLogDto) workFlowDto
									.getSubmitSwfLogDtoList().get(size-1)).getLogNo();
						}
						UIWorkFlowApprovalInterFaceFacade uiWorkFlowApprovalInterFaceFacade = new UIWorkFlowApprovalInterFaceFacade();
						String UWflowID = uiWorkFlowApprovalInterFaceFacade
								.submitApprovalPlatform("VeriPay",
										swfLogDtoDealNode.getFlowID(), Integer.valueOf(
												vericLogNo).toString(), businessNo,
												prpLregistDto.getRiskCode(),
												prpLregistDto.getClassCode(),
												prpLregistDto.getComCode(),
										userDto.getUserCode(), prpLregistDto.getMakeCom(),
										userDto.getUserCode(), userDto.getUserCode(),
										"");
						if (UWflowID.length() < 15) {
							String msg = "����'"
									+ businessNo
									+ "'�ύ˫��ϵͳʧ�ܣ��������ύ���������Ա��ϵ!";
							throw new UserException(1, 3, "������", msg);
						}*/
						/*** ����ע�������ƽ̨ end****/
						new BLPrplpayFacade().updateVFlag("2", registno, businessNo);//����Ϊ�������״̬
						
					} else {
						new BLPrplpayFacade().save(request,"1");
					}
					/****�����͸���ƽ̨start******/
					/*DAARulesmodleViewHelper daaRulesmodleViewHelper =new DAARulesmodleViewHelper();
					if(daaRulesmodleViewHelper.isuploud(swfLogDtoDealNode.getRegistNo(), "1", "apay")){
						daaRulesmodleViewHelper.matchRule(swfLogDtoDealNode.getComCode(),"apay", swfLogDtoDealNode.getRegistNo(), "1", "", businessNo);
					}*/
					/****�����͸���ƽ̨end ******/
					userDto.setUserMessage("֧����Ϣ�ϴ����ƽ̨�ɹ���");
				}
			}
			
		} catch (UserException usee) {
			usee.printStackTrace();
			//������Ϣ����
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("֧����Ϣ����");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			request.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(request, errors);
			forward = "error";

		} catch (SQLException sqle) {
			StringWriter stringWriter = new StringWriter();
			sqle.printStackTrace(new PrintWriter(stringWriter));
			sqle.printStackTrace();
			//������Ϣ����
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("֧����Ϣ����");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			request.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(request, errors);
			forward = "error";
		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//������Ϣ����
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("֧����Ϣ����");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			request.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(request, errors);
			forward = "error";

		}
		return mapping.findForward(forward);
		
		/*String onlySaveReq = request.getParameter("onlySave");
		String forward = "s";
		boolean onlySave= false;
		if (!StringUtils.isEmpty(onlySaveReq)&&"true".equals(onlySaveReq)) {
			onlySave=true;
		}
		try {
			
			UserDto userDto = (UserDto) request.getSession(true).getAttribute("user");
			if (onlySave){
				String vflag="1";
				new BLPrplpayFacade().save(request,vflag);
				userDto.setUserMessage("֧����Ϣ�ݴ�ɹ���");
			}else{
				new BLPrplpayFacade().save(request,"");
				userDto.setUserMessage("֧����Ϣ����ɹ���");
			}
			
		} catch (UserException usee) {
			usee.printStackTrace();
			//������Ϣ����
			ActionErrors errors = new ActionErrors();
			ActionError error = null;
			if(onlySave){
				error = new ActionError("֧����Ϣ����");
			}else{
				error = new ActionError("֧����Ϣ�ݴ�");
			}
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			request.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(request, errors);
			forward = "error";

		} catch (SQLException sqle) {
			StringWriter stringWriter = new StringWriter();
			sqle.printStackTrace(new PrintWriter(stringWriter));
			sqle.printStackTrace();
			//������Ϣ����
			ActionErrors errors = new ActionErrors();
			ActionError error = null;
			if(onlySave){
				error = new ActionError("֧����Ϣ����");
			}else{
				error = new ActionError("֧����Ϣ�ݴ�");
			}
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			request.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(request, errors);
			forward = "error";
		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//������Ϣ����
			ActionErrors errors = new ActionErrors();
			ActionError error = null;
			if(onlySave){
				error = new ActionError("֧����Ϣ����");
			}else{
				error = new ActionError("֧����Ϣ�ݴ�");
			}
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			request.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(request, errors);
			forward = "error";

		}
		return mapping.findForward(forward);*/
	}
}
