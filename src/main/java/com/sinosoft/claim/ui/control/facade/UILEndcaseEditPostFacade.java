package com.sinosoft.claim.ui.control.facade;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.bz.common.RequestType;
import com.sinosoft.ciplatform.bl.facade.BLCIClaimSYXPlatFormInterfaceFacade;
import com.sinosoft.ciplatform.bl.facade.BLCIPlatformConfigFacade;
import com.sinosoft.ciplatform.dto.domain.CIClaimDemandDto;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.ciplatform.ui.action.UICIClaimDemandAction;
import com.sinosoft.claim.bl.facade.BLPrpLrecaseFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.EndcaseDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIEndcaseAction;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAEndcaseViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claimciplatform.bl.action.custom.BLCIClaimPlatFormCheckAction;
import com.sinosoft.claimciplatform.bl.action.custom.BLCIClaimPlatFormInterfaceAction;
import com.sinosoft.claimciplatform.bl.facade.BLCIClaimPlatFormInterfaceFacade;
import com.sinosoft.claimciplatform.dto.custom.ClaimCiPlatFormException;
import com.sinosoft.claimciplatform.dto.custom.PlatFormParam;
import com.sinosoft.common_claim.bl.action.custom.BLCIClaimAcciSdPlatFormInterfaceFacade;
import com.sinosoft.common_claim.bl.action.custom.BLCIClaimPropPlatFormInterfaceFacade;
import com.sinosoft.platform.bl.facade.BLPrpDriskConfigFacade;
import com.sinosoft.platform.dto.domain.PrpDriskConfigDto;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utiall.blsvr.BLPrpDcompany;

/**
 * �ַ�HTTP Post ��������᰸�༭����
 * <p>
 * Title: ��������᰸�༭������Ϣ
 * </p>
 * <p>
 * Description: ��������᰸�༭������Ϣ
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: sinosoft.com.cn
 * </p>
 * 
 * @author liubvo
 * @version 1.0
 */
public class UILEndcaseEditPostFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		String forward = ""; // ��ǰ��ת
		try {
			String strStep = httpServletRequest.getParameter("step"); // ҳ���־
			String dfFlag = httpServletRequest.getParameter("dfFlag"); // ҳ���־   //add by lym 20060809  for �������ⰸ����֧����	
			String claimNo = httpServletRequest.getParameter("prpLendcaseClaimNo1"); // �ⰸ��
			String strRiskCode = httpServletRequest.getParameter("riskCode"); 			
			UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
			boolean dfendcase=false;    //�渶�᰸
			DAAEndcaseViewHelper dAAEndcaseViewHelper = new DAAEndcaseViewHelper();
			 //add by lym 20060809 start for �������ⰸ����֧����	
			
			if ( dfFlag!=null && !dfFlag.equals("") && dfFlag.equals("Y")){
			}else {	
				 //add by lym 20060809 end for �������ⰸ����֧����	
			int intCompensateFlag = dAAEndcaseViewHelper.checkCompensate(httpServletRequest, claimNo);
			httpServletRequest.setAttribute("intCompensateFlag",Integer.toString(intCompensateFlag));
			if (intCompensateFlag == 0) { //�����⣬����ǵ渶����Ӧ���м�����ģ��������ô���ǵġ�
				throw new UserException(1, 3, "endcase", "������"+ claimNo +"û���������飬���ܽ᰸��");
					}

			if (intCompensateFlag < 0) { //�м����飬��ûͨ�����⡣
				throw new UserException(1, 3, "endcase", "��û�к���ͨ���ļ����飬���ܽ᰸��");
			}
			
			if (intCompensateFlag ==2){
				 dfendcase=true;
			}
			
	}	
			
			
			
			if (claimNo != null) {
				claimNo = claimNo.trim();
				// add by qinyongli 2005-9-6 start
				// reason:���ⰸ�ŵĴ����Խ����ж�
				boolean isExist = true;
				UIClaimAction claimAction = new UIClaimAction();
				isExist = claimAction.isExist(claimNo);
				if (!isExist) {
					throw new UserException(1, 3, "�����ⰸ��", "��Ǹ����������ⰸ�Ų����ڣ����飡");
				}
			}
		    // add by qinyongli end
			// ���ⰸ�������õ�ҳ��
			httpServletRequest.setAttribute("claimNo", claimNo);
			// �᰸�ֲ������
			if (strStep != null) {
				if (strStep.trim().equals("step1")) {
					// ��������д��᰸���ںͽ᰸Ա����
					// ��viewHelper�����������
					//DAAEndcaseViewHelper dAAEndcaseViewHelper = new DAAEndcaseViewHelper();
					/**
					 * modify by mengdongdong at 20060315 start
					 * reson:��һ����ͬʱ��ɽ᰸�͹鵵
					 */
					
					//������ ��ҵ������:Ҫ��᰸�͹鵵Ҫ��һ�����,�Ա���ֻ�᰸���鵵����������)
					boolean isRecase = dAAEndcaseViewHelper.isRecase(claimNo);
					boolean isGenrateCaseNo = dAAEndcaseViewHelper.isGenrateCaseNo(claimNo);
					boolean isPrepay = false;//�����ⰸ�Ƿ�᰸ falseû�᰸ true�᰸
					if(isGenrateCaseNo == true && isRecase == false){
						isPrepay = dAAEndcaseViewHelper.isPrepay(claimNo);
					}
			     	if (isGenrateCaseNo == true && isRecase == false  && isPrepay == false) {   // isRecase == false ���ؿ��ⰸ �� ��δ�᰸���ؿ��ⰸ 
						ActionMessages messages = new ActionMessages();
						messages.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("title.endcaseEidt.generateCaseNo"));
						saveMessages(httpServletRequest, messages);
						return actionMapping.findForward("success");
					}
					if (isTokenValid(httpServletRequest, true)) {
						
						String caseNo ="";
						if(isRecase==true || isPrepay==true){ //��δ����ؿ��ⰸ�������ⰸ�Ѿ��᰸
						UIClaimAction uiClaimmAction =  new  UIClaimAction();
						ClaimDto claimDto  =  uiClaimmAction.findByPrimaryKey(claimNo);
						PrpLclaimDto prpLclaimDto =claimDto.getPrpLclaimDto();
				
							caseNo = prpLclaimDto.getCaseNo();
						}
						else {
						    caseNo = dAAEndcaseViewHelper.getCaseNo(claimNo,user.getComCode());
						} 
						
						httpServletRequest.setAttribute("caseNo", caseNo);
						EndcaseDto endcaseDto = dAAEndcaseViewHelper.viewToDto(httpServletRequest, true);
						// �������������
						// -----------------------------------------------------
						// 1requst����,2���ڵ�Ľڵ�����,3���ڵ���Ҫ���µ�״̬,4���ڵ��ҵ�����,5�Ժ�ڵ��ҵ�����,6���ڵ��ҵ���������,7�Ժ�ڵ��ҵ����������????
						WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
						SwfLogDto swfLogDtoDealNode = new SwfLogDto();
						swfLogDtoDealNode.setNodeType("endca");
						swfLogDtoDealNode.setNodeStatus("4"); // Ĭ�϶����ύ
						swfLogDtoDealNode.setBusinessNo(claimNo);
						swfLogDtoDealNode.setNextBusinessNo(claimNo);
						swfLogDtoDealNode.setKeyIn(claimNo);
						swfLogDtoDealNode.setKeyOut(caseNo);
						WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDtoDealNode);
						System.out.println("====caseNo========="+caseNo);
						// ------------------------------------------------------------
						// ����᰸��Ϣ
						UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();
				        String comCodeSub= user.getComCode().substring(0,2);
					    PrpDriskConfigDto prpDriskConfigDto = new BLPrpDriskConfigFacade().findByPrimaryKey(comCodeSub,strRiskCode, "CI_TRANSPORT_MODE");
					    if(httpServletRequest.getParameter("buttonSaveType").trim().equals("4")){/*
					    if(prpDriskConfigDto != null && "0".equals(prpDriskConfigDto.getConfigValue())){
					         	BLCIClaimPlatFormInterfaceFacade.getInstance().upload(Iconstants.RequstType.ENDCASE, endcaseDto.getPrpLclaimDto().getClaimNo(), true);
					      }
					    if(prpDriskConfigDto != null && "1".equals(prpDriskConfigDto.getConfigValue())){
					      	BLCIClaimPlatFormInterfaceFacade.getInstance().upload(Iconstants.RequstType.ENDCASE, endcaseDto.getPrpLclaimDto().getClaimNo(), false);
					       } 
					     */}
						if (workFlowViewHelper.checkDealDto(workFlowDto)) { //�ж��п��Ա���Ĺ�����
							
						   if(isRecase==true){ //�ؿ��ⰸֻ�������Ķ���,��д prplrecase��
						  
						   	//��д prplrecase��
						    UIRecaseAction uiRecaseAction =new UIRecaseAction();
						    uiRecaseAction.update(endcaseDto.getPrpLrecaseDto()); 
						    UIClaimAction uiClaimmAction =  new  UIClaimAction();
						    //�ؿ��ⰸ����д�᰸ʱ��
						    //uiClaimmAction.updateEndCaseDate(endcaseDto.getPrpLclaimDto().getClaimNo(),endcaseDto.getPrpLrecaseDto().getCloseCaseDate());
						   	UIWorkFlowAction  uiWorkFlowAction = new UIWorkFlowAction();
						   	uiWorkFlowAction.deal(workFlowDto) ; //Ϊʲô��������ҵ������Ҫ�ֿ�����ͻ��Ϊ��һ��������
						   }else{ //һ�㰸���᰸
							   uiEndcaseAction.save(endcaseDto, workFlowDto);
							  
						   }
						   user.setUserMessage(caseNo);	
						} else {
							uiEndcaseAction.save(endcaseDto);
					       
							user.setUserMessage(caseNo + ";ע��:û�з����빤������������κ����ݣ���");
							httpServletRequest.getSession().setAttribute("user", user);
						}
						
						//���ù��ӱ�ͬ��״̬�ӿ� start
						try{
							if(null != endcaseDto.getPrpLclaimDto()){
								UIClaimSynStatusFacade uiClaimSynStatusFacade = new UIClaimSynStatusFacade();
					  		    uiClaimSynStatusFacade.synRegistStatus(endcaseDto.getPrpLclaimDto().getRegistNo(), "5");
							}
			  	    	}catch(Exception e){
			  	    		e.printStackTrace();
			  	    	}
						//���ù��ӱ�ͬ��״̬�ӿ� end
						
						//����ƽ̨�ϴ�
						String strHerf = "(<a href=\"javascript:showErrorInfo('info')\">��ϸ��Ϣ</a>)";
						String riskType = new UICodeAction().translateRiskCodetoRiskType(endcaseDto.getPrpLclaimDto().getRiskCode());
						
						//�Ϻ��⽡��ƽ̨�᰸�ӿڽ���begin
						boolean isYJXFlag = false;
						String groupFlag = "";
						String strPolicyNo = endcaseDto.getPrpLclaimDto().getPolicyNo();//��ȡ������
						String upComCode = endcaseDto.getPrpLclaimDto().getComCode();
						upComCode = new BLPrpDcompany().getDaaPlatformComCode(upComCode);
						boolean isSuccess = false;
						DBManager dbManager = new DBManager();
//						if("26,27,28".indexOf(endcaseDto.getPrpLclaimDto().getRiskCode().substring(0,2)) > -1){
//							isYJXFlag = true;
//						}						
//						if(isYJXFlag && "310000".equals(upComCode) && httpServletRequest.getParameter("buttonSaveType").trim().equals("4")){
//							System.out.println("------------------�Ϻ�ƽ̨�⽡�ս᰸�ӿڵ���,claimNo= " + claimNo +" --------------------------");
//							//���ݱ���������ѯ������Ϣ,�жϸñ����Ƿ�Ϊ�ŵ�
//							BLPrpCmain blPrpCmain = new BLPrpCmain();
//							blPrpCmain.getData(strPolicyNo);	
//							try {					
//								//����prpcmain.groupNo�Ƿ�Ϊ���ж��Ƿ�Ϊ�ŵ�
//								if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
//									groupFlag = "0";//����
//									isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C01", "03", claimNo,strPolicyNo,groupFlag,upComCode);
//								}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
//									groupFlag = "1";//����
//									isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C04", "03", claimNo,strPolicyNo,groupFlag,upComCode);
//								}
//								if(isSuccess){
//									user.setUserMessage(user.getUserMessage()+ "<br>�Ϻ��⽡�ս᰸��Ϣ�ϴ�ƽ̨�ɹ�!");
//								}else{
//									user.setUserMessage(user.getUserMessage()+ "<br>�Ϻ��⽡�ս᰸��Ϣ�ϴ�ƽ̨ʧ��!");
//								}
//							} catch (Exception e) {
//								e.printStackTrace();								
//			                    throw new Exception(e.getMessage() + "�⽡���ϴ�ƽ̨ʧ��,�᰸�Ǽ�ʧ��!");
//							}				
//						}
//						//�Ϻ��⽡��ƽ̨�᰸�ӿڽ���end
						try{
							if("D".equals(riskType)){
								System.out.println("���Ͻ��н�ǿ��ƽ̨����");
								String uploadType = RequestType.ENDCASE_SIGN;
								BLPrpLrecaseFacade blPrpLrecaseFacade = new BLPrpLrecaseFacade();
								String strCondition = " claimNo = '" + endcaseDto.getPrpLclaimDto().getClaimNo() + "'";
//								Collection collection = blPrpLrecaseFacade.findByConditions(strCondition);
//								if(collection.size() > 0){
//									uploadType = RequestType.ENDCASE_APPEND;
//								}
								
								boolean isUpload = false;
								isUpload = BLCIClaimPlatFormCheckAction.checkUploadForEndCase(claimNo);
								
								if (isUpload) {
									BLCIClaimPlatFormInterfaceFacade.getInstance()
											.upload(
													uploadType,
													endcaseDto.getPrpLclaimDto()
															.getClaimNo(),"", true,
													"0");

									user.setUserMessage(user.getUserMessage()
											+ "<br>�ϴ�����ƽ̨�ɹ�!");
								}
								
								
								
								//2011��ҵ��
								
								System.out.println("���Ͻ�����ҵ��ƽ̨����");
									//2011
									String riskCode="";
									String comcode="";
									String configValue="";
									boolean boo=false;
									UIClaimAction uIClaimAction=new UIClaimAction();
									ClaimDto claimDtopm=uIClaimAction.findByPrimaryKey(claimNo);
									riskCode=claimDtopm.getPrpLclaimDto().getRiskCode();
									comcode=claimDtopm.getPrpLclaimDto().getComCode();
									String registNo=claimDtopm.getPrpLclaimDto().getRegistNo();
									if("0506".equals(riskCode)){
										boo=true;
									}
									if(boo && comcode!=null && !"".equals(comcode)){
										String comCodesub=comcode.substring(0,2);
										BLCIPlatformConfigFacade bLCIPlatformConfigFacade=new BLCIPlatformConfigFacade();
										CIPlatformConfigDto cIPlatformConfigDto=bLCIPlatformConfigFacade.findByPrimaryKey("CI_TRANSPORT_MODE", comCodesub, "0506");
										if(cIPlatformConfigDto!=null && "1".equals(cIPlatformConfigDto.getValidStatus())){
											String conditions=" claimno='"+claimNo+"' ";
											UICIClaimDemandAction uICIClaimDemandAction=new UICIClaimDemandAction();
											Collection demandColl=uICIClaimDemandAction.findByConditions(conditions);
											String registFlag="";
											String claimFlag="";
											if(demandColl.iterator().hasNext()){
												CIClaimDemandDto cIClaimDemandDto=(CIClaimDemandDto)demandColl.iterator().next();
												registFlag=cIClaimDemandDto.getRegistUploadFlag();
												claimFlag=cIClaimDemandDto.getClaimUploadFlag();
											}
											
											
											configValue=cIPlatformConfigDto.getConfigValue();
											if("0".equals(configValue)) {//2011	0ʵʱ������1��ʱ����
													if(!"1".equals(registFlag)){
														BLCIClaimSYXPlatFormInterfaceFacade
														.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.REGIST_SYX,
																registNo,
																true,cIPlatformConfigDto,"0","");
													}
													if(!"1".equals(claimFlag)){
														BLCIClaimSYXPlatFormInterfaceFacade
														.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CLAIM_SYX,
																claimNo,
																true,cIPlatformConfigDto,"0","");
													}
													BLCIClaimSYXPlatFormInterfaceFacade
													.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.ENDCASE_SYX,
															claimNo,
															true,cIPlatformConfigDto,"0","");
													user.setUserMessage(user.getUserMessage()+ "<br>�᰸�ϴ���ҵ��ƽ̨�ɹ�!");
												
											}else{
													if(!"1".equals(registFlag)){
														BLCIClaimSYXPlatFormInterfaceFacade
														.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.REGIST_SYX,
																registNo,
																false,cIPlatformConfigDto,"0","");
													}
													if(!"1".equals(claimFlag)){
														BLCIClaimSYXPlatFormInterfaceFacade
														.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CLAIM_SYX,
																claimNo,
																false,cIPlatformConfigDto,"0","");
													}
													
													BLCIClaimSYXPlatFormInterfaceFacade
													.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.ENDCASE_SYX,
															claimNo,
															false,cIPlatformConfigDto,"0","");
												user.setUserMessage(user.getUserMessage()
														+ "<br>�᰸�ϴ�����ҵ��ƽ̨�ɹ�!");
											}
										}
									}
								}
								
								
							
						}catch(ClaimCiPlatFormException e){
							e.printStackTrace();
							httpServletRequest.setAttribute("ciClaimException", e);
							user.setUserMessage(user.getUserMessage() + "<br>�ϴ�����ƽ̨ʧ�ܣ�<br>" + e.getMessage() + strHerf);
						}catch(Exception e ){
							e.printStackTrace();
							httpServletRequest.setAttribute("ciClaimException", e);
							user.setUserMessage(user.getUserMessage() + "<br>�ϴ�����ƽ̨ʧ��:<br>" + e.getMessage() + strHerf);
						}
						//ɽ�������շ���Ԥ��ϵͳ�Խ�-�᰸�Ǽǽӿ�(�ֶ��᰸����)����
					    if(AppConfig.get("sysconst.SDACCI_RISKCODE").indexOf(endcaseDto.getPrpLclaimDto().getRiskCode())>-1 && "370000".equals(upComCode)){
					      System.out.println("-----ɽ�������շ���Ԥ��ϵͳ�Խ�-�᰸�Ǽǽӿ�(�ֶ��᰸����)����,claimNo= " + endcaseDto.getPrpLclaimDto().getClaimNo() +"-----");
					      try{
					    	  dbManager.open(AppConfig.get("sysconst.DBJNDI"));
					    	  BLPrpCmain blPrpCmain = new BLPrpCmain();
						      blPrpCmain.getData(strPolicyNo);
						      if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
						        groupFlag = "0";//����
						      }else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
						        groupFlag = "1";//����
						      }
						      isSuccess = BLCIClaimAcciSdPlatFormInterfaceFacade.getInstance().upload(dbManager, "L02", endcaseDto.getPrpLclaimDto().getClaimNo(), groupFlag);
						      if(isSuccess){
									user.setUserMessage(user.getUserMessage()+ "<br>ɽ�������շ���Ԥ��ϵͳ�Խ�-�᰸�Ǽǽӿ��ϴ��ɹ�!");
								}else{
									user.setUserMessage(user.getUserMessage()+ "<br>ɽ�������շ���Ԥ��ϵͳ�Խ�-�᰸�Ǽǽӿ��ϴ�ʧ��!");
								}
					      }catch(Exception e){
					    	  e.printStackTrace();
					    	  throw new Exception(e.getMessage() + "ɽ�������շ���Ԥ��ϵͳ�Խ�-�᰸�Ǽǽӿ��ϴ�ʧ��!");
					      }finally{
					    	  dbManager.close();
					      }
					      }
					  //ɽ�������շ���Ԥ��ϵͳ�Խ�-�᰸�Ǽǽӿ�(�ֶ��᰸����)����
					}
	
					ActionMessages messages = new ActionMessages();
					messages.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("prompt.endcase.save"));
					messages.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("db.prpLcompensate.caseNo"));
					saveMessages(httpServletRequest, messages);
					forward = "success";
					/**
					 * modify by mengdongdong at 20060315 end
					 */
				}
				/**
				 * Ϊ������������ʷ����,��ʱ����
				 */
				else if (strStep.trim().equals("step2")) {
					//DAAEndcaseViewHelper dAAEndcaseViewHelper = new DAAEndcaseViewHelper();
					// �Ƿ����ɹ��ⰸ����
					boolean isGenrateCaseNo = dAAEndcaseViewHelper.isGenrateCaseNo(claimNo);
					if (isGenrateCaseNo == true) {
						ActionMessages messages = new ActionMessages();
						messages.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("title.endcaseEidt.generateCaseNo"));
						saveMessages(httpServletRequest, messages);
						return actionMapping.findForward("success");
					}
					dAAEndcaseViewHelper.compensateDtoToView(httpServletRequest, claimNo);
					saveToken(httpServletRequest);
					forward = "step2";
				} else if (strStep.trim().equals("step3")) {
					String caseNo = httpServletRequest.getParameter("prplCaseNoCaseNo1"); // �㰸��
					httpServletRequest.setAttribute("caseNo", caseNo);
					// ��viewHelper�����������
					if (isTokenValid(httpServletRequest, true)) {
						//DAAEndcaseViewHelper dAAEndcaseViewHelper = new DAAEndcaseViewHelper();
						EndcaseDto endcaseDto = dAAEndcaseViewHelper.viewToDto(httpServletRequest, true);
						// �������������
						// -----------------------------------------------------
						// 1requst����,2���ڵ�Ľڵ�����,3���ڵ���Ҫ���µ�״̬,4���ڵ��ҵ�����,5�Ժ�ڵ��ҵ�����,6���ڵ��ҵ���������,7�Ժ�ڵ��ҵ����������????
						WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
						SwfLogDto swfLogDtoDealNode = new SwfLogDto();
						swfLogDtoDealNode.setNodeType("endca");
						swfLogDtoDealNode.setNodeStatus("4"); // Ĭ�϶����ύ
						swfLogDtoDealNode.setBusinessNo(claimNo);
						swfLogDtoDealNode.setNextBusinessNo(claimNo);
						swfLogDtoDealNode.setKeyIn(claimNo);
						swfLogDtoDealNode.setKeyOut(caseNo);
						WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDtoDealNode);
						// ------------------------------------------------------------
						// ����᰸��Ϣ
						UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();

						if ((workFlowDto.getCreate())
								|| (workFlowDto.getUpdate())
								|| (workFlowDto.getSubmit())
								|| (workFlowDto.getClose())) {
							uiEndcaseAction.save(endcaseDto, workFlowDto);
							user.setUserMessage(caseNo);
						} else {
							uiEndcaseAction.save(endcaseDto);
							user.setUserMessage(caseNo + ";ע��:û�з����빤������������κ����ݣ���");
							httpServletRequest.getSession().setAttribute("user", user);
						}
					}
					ActionMessages messages = new ActionMessages();

					if (httpServletRequest.getParameter("buttonSaveType").trim().equals("4")) {
						messages.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("prompt.endcase.submit"));
					} else {
						messages.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("prompt.endcase.save"));
					}
					messages.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("db.prpLcompensate.caseNo"));
					saveMessages(httpServletRequest, messages);
					forward = "success";
				}
			}
		} catch (UserException usee) {
			usee.printStackTrace();
			// ������Ϣ����
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.endcaseBeforeEdit.editEndcase");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			// ������Ϣ����
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.endcaseBeforeEdit.editEndcase");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} 
		return actionMapping.findForward(forward);
	}
}
