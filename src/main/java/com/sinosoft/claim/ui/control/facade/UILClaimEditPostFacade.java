package com.sinosoft.claim.ui.control.facade;

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

import com.gyic.claim.bl.facade.BLPlantingsettlelistFacade;
import com.gyic.claim.bl.facade.BLNyxsettlelistFacade;
import com.gyic.claim.bl.facade.BLSettlemainlistFacade;
import com.gyic.claim.bl.facade.BLSettlemainlistFacadeForMedical;
import com.gyic.claim.dto.domain.PlantingsettlelistDto;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.gyic.claim.dto.domain.NyxsettlelistDto;
import com.sinosoft.bz.common.RequestType;
import com.sinosoft.ciplatform.bl.facade.BLCIClaimSYXPlatFormInterfaceFacade;
import com.sinosoft.ciplatform.bl.facade.BLCIPlatformConfigFacade;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.claim.bl.facade.BLClaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacadeBase;
import com.sinosoft.claim.bl.facade.BLPrpLpropFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
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
import com.sinosoft.common_claim.bl.action.custom.BLCIClaimPropPlatFormInterfaceFacade;
import com.sinosoft.platform.bl.facade.BLPrpDriskConfigFacade;
import com.sinosoft.platform.dto.domain.PrpDriskConfigDto;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.reins.out.bl.action.custom.BLLDangerGetAction;
import com.sinosoft.reins.out.bl.facade.BLCTrialFacade;
import com.sinosoft.reins.out.bl.facade.BLFhTreatyFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpLdangerUnitFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpLreinsTrialFacade;
import com.sinosoft.reins.out.bl.facade.BLRepayFacade;
import com.sinosoft.reins.out.dto.custom.CReinsTrialDto;
import com.sinosoft.reins.out.dto.domain.FhTreatyDto;
import com.sinosoft.reins.out.dto.domain.PrpCreinsTrialDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerUnitDto;
import com.sinosoft.reins.out.dto.domain.PrpLreinsTrialDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utiall.blsvr.BLPrpDcompany;
import com.sinosoft.utility.SysConfig;
import com.sinosoft.common_claim.bl.action.custom.BLCIClaimAcciSdPlatFormInterfaceFacade;
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

		try {

			//������µǼǣ����ȡ�ű���ȡ�ⰸ���룬������޸ģ��򱣳�ԭ����claimNo����
			//ȡ�ⰸ��
			// 0 ��ʾ����Ҫ�� 1��ʾ��Ҫ
			//String claimNo ="";
			String comCode = "";
			String userCode = "";
			ClaimDto claimDto = null;

			String strLastAccessedTime = String.valueOf(httpServletRequest.getSession().getLastAccessedTime()/ 1000);
			String oldLastAccessedTime = (String) httpServletRequest.getSession().getAttribute("oldClaimLastAccessedTime");
			if (oldLastAccessedTime !=null && !oldLastAccessedTime.trim().equals("")) {
		    	   throw new UserException(1, 3, "������", "�벻Ҫ�ظ��ύ");
		       }
			
				httpServletRequest.getSession().setAttribute("oldClaimLastAccessedTime", strLastAccessedTime);
			
				claimNo = httpServletRequest.getParameter("prpLclaimClaimNo"); //�ⰸ��
				String settleListCode=httpServletRequest.getParameter("settleListCode");
				String registNo = httpServletRequest.getParameter("prpLclaimRegistNo");
				String riskCode = httpServletRequest.getParameter("prpLclaimRiskCode");   //add by lym 20060605 for ǿ��
				String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
				String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //���������� add 20051228
				String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //������logno add  20051228
				String userLastActionNow = "claimAdd?regist=" + registNo; //��ֹ�û��ظ��ύ
				int year = DateTime.current().getYear();

				UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
				comCode =  httpServletRequest.getParameter("prpLclaimComCode");
				userCode = user.getUserCode();
				//��ֹ����ˢ�����ύ�������ͬʱ�����ύͬһ������
				UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
				String condition = "flowId ='"+swfLogFlowID+"' and  logno= "+ swfLogLogNo+"  and nodeStatus in ('4')";
			    Collection certifyNodeList = uiWorkFlowAction.findNodesByConditions(condition);
			    if(certifyNodeList!=null&&certifyNodeList.size()>0){
			    	   throw new UserException(1,3,"������","�ð��������ڵ��Ѵ���");
			    }
				//��������������ύ��ʱ��Բ鿱�Ͷ��𻷽ڵĴ���״̬�����жϽ�������ֳ�ս��д���
			    //add by xiatian  �����ֲ���ж�
				if("I".equals(riskType)||"H".equals(riskType)){
					BLClaimFacade blClaimFacade = new BLClaimFacade();
					blClaimFacade.checkNodeStatus(swfLogFlowID);
				}
				

				if (claimNo.length() < 1 || claimNo == null) {
					//ȡ�Ź��̻���Ҫ��һ������
					UIBillAction uiBillAction = new UIBillAction();
					String tableName = "prplclaim";
					claimNo = uiBillAction.getNo(tableName, riskCode, comCode, year);
				}

				httpServletRequest.setAttribute("claimNo", claimNo);

				//��viewHelper�����������

				if("I".equals(riskType)||"H".equals(riskType)||"E".equals(riskType)){
					AgriClaimViewHelper agriClaimViewHelper = new AgriClaimViewHelper();
					claimDto = agriClaimViewHelper.viewToDto(httpServletRequest);
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
				UIClaimAction uiClaimAction = new UIClaimAction();

				if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate())
						|| (workFlowDto.getSubmit())
						|| (workFlowDto.getClose())) {
					uiClaimAction.save(claimDto, workFlowDto);
					user.setUserMessage(claimNo);
				} else {
					//uiClaimAction.save(claimDto);
					user.setUserMessage(claimNo + ";ע��:û�з����빤������������κ����ݣ���");

				}
				
				//���½���Σ�յ�λ����===begain 2017-08-16
				if(claimDto.getPrpLRiskUnitDtoList() != null && claimDto.getPrpLRiskUnitDtoList().size() > 0){
				}else{
					BLPrpLdangerUnitFacade prpLdangerUnitFacade = new BLPrpLdangerUnitFacade();
					DBManager dbManager1 = new DBManager();
					BLLDangerGetAction ldangerGetAction = new BLLDangerGetAction();
					try{
			            dbManager1.open(AppConfig.get("sysconst.REINS_JNDI"));
			            dbManager1.beginTransaction();
			            //��������
			            ldangerGetAction.getLDangerInfoNewL(claimNo, dbManager1);
			            dbManager1.commitTransaction();
			        }catch(Exception exception){
			            dbManager1.rollbackTransaction();
			            throw exception;
			        }finally{
			            dbManager1.close();
			        }
				}
				//���½���Σ�յ�λ����===end
				
				//����ƽ̨�ϴ�
				try{
					
					//�Ϻ�ƽ̨�⽡��������Ϣ�ϴ�
					boolean isYJXFlag = false;
					boolean isSuccess = false;
					String groupFlag = "";
					String secodeComCode  = "";
					String strPolicyNo = "";//������
					BLPrpDcompany blPrpDcompany = new BLPrpDcompany();
					if(claimDto.getPrpLclaimDto() != null){
						strPolicyNo = claimDto.getPrpLclaimDto().getPolicyNo();
						secodeComCode  = blPrpDcompany.getDaaPlatformComCode(claimDto.getPrpLclaimDto().getComCode());
					}
					if("26,27,28".indexOf(riskCode.substring(0, 2)) > -1){
						isYJXFlag = true;
					}					
					if(isYJXFlag && "310000".equals(secodeComCode) && httpServletRequest.getParameter("buttonSaveType").trim().equals("4")){
						System.out.println("------------------�Ϻ�ƽ̨�⽡�������ӿڵ���,claimNo= " + claimNo +" --------------------------");
						//���ݱ���������ѯ������Ϣ,�жϸñ����Ƿ�Ϊ�ŵ�
						BLPrpCmain blPrpCmain = new BLPrpCmain();
						blPrpCmain.getData(strPolicyNo);	
						DBManager dbManager = new DBManager();
						try {					
							dbManager.open(AppConfig.get("sysconst.DBJNDI"));
							//����prpcmain.groupNo�Ƿ�Ϊ���ж��Ƿ�Ϊ�ŵ�
							if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
								groupFlag = "0";//����
								isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C01", "02", claimNo, strPolicyNo, groupFlag, secodeComCode);
							}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
								groupFlag = "1";//����
								isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C04", "02", claimNo, strPolicyNo, groupFlag, secodeComCode);
							}
							if(isSuccess){
							    user.setUserMessage(user.getUserMessage() + "<br>�⽡��������Ϣ�ϴ�ƽ̨�ɹ�!");
							}else{
								user.setUserMessage(user.getUserMessage() + "<br>�⽡��������Ϣ�ϴ�ƽ̨ʧ��!");
							}
						} catch (Exception e) {
							e.printStackTrace();
							user.setUserMessage(user.getUserMessage() + "<br>"+e.getMessage());
						} finally{//�ر�����Դ
							dbManager.close();
						}				
					}
					
					if (httpServletRequest.getParameter("buttonSaveType").trim()
							.equals("4") && "D".equals(riskType)) {
						
						System.out.println("���Ͻ��н�ǿ��ƽ̨����");
						boolean isUpload = false;
						
						isUpload = BLCIClaimPlatFormCheckAction.checkUploadForClaim(claimNo);
						
						if(isUpload){
							BLCIClaimPlatFormInterfaceFacade.getInstance().upload(
									RequestType.CLAIM_SIGN,
									claimDto.getPrpLclaimDto().getClaimNo(),"", true,"0");
							
							user.setUserMessage(user.getUserMessage() + "<br>�ϴ�����ƽ̨�ɹ�!");
						}
						
						System.out.println("���Ͻ�����ҵ��ƽ̨����");
						//2011��ҵ��ƽ̨����
						String configValue="";
						
						UIClaimAction uIClaimAction=new UIClaimAction();
						ClaimDto claimDtopm=uIClaimAction.findByPrimaryKey(claimNo);
						String comcode=claimDtopm.getPrpLclaimDto().getComCode();
						boolean boo=false;
						if("0506".equals(riskCode)){
							boo=true;
						}
						if(boo && comcode!=null && !"".equals(comcode)){
							String comCodeSub=comCode.substring(0,2);
							BLCIPlatformConfigFacade bLCIPlatformConfigFacade=new BLCIPlatformConfigFacade();
							CIPlatformConfigDto cIPlatformConfigDto=bLCIPlatformConfigFacade.findByPrimaryKey("CI_TRANSPORT_MODE", comCodeSub, "0506");
							if(cIPlatformConfigDto!=null && "1".equals(cIPlatformConfigDto.getValidStatus())){
								configValue=cIPlatformConfigDto.getConfigValue();
								if("0".equals(configValue)) {//2011	0��ʱ������1�Ǽ�ʱ����
									BLCIClaimSYXPlatFormInterfaceFacade
									.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CLAIM_SYX,
											claimNo,
											true,cIPlatformConfigDto,"0","");
									user.setUserMessage(user.getUserMessage()
											+ "<br>�����ϴ���ҵ��ƽ̨�ɹ�!");
								}else{
									BLCIClaimSYXPlatFormInterfaceFacade
									.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CLAIM_SYX,
											claimNo,
											false,cIPlatformConfigDto,"0","");
									user.setUserMessage(user.getUserMessage()
											+ "<br>�����ϴ���ҵ��ƽ̨�ɹ�!");
								}
							}
						}
						
						
						
					}
					//ɽ�������շ���Ԥ�������Ǽ��ϴ�ƽ̨
					if(httpServletRequest.getParameter("buttonSaveType").trim().equals("4") 
							&& AppConfig.get("sysconst.SDACCI_RISKCODE").indexOf(riskCode)>-1 && "370000".equals(secodeComCode)){
						System.out.println("-----ɽ�������շ���Ԥ��ϵͳ-�����Ǽǽӿڵ���,claimNo= " + claimNo +" -----");
						//���ݱ���������ѯ������Ϣ,�жϸñ����Ƿ�Ϊ�ŵ�
						BLPrpCmain blPrpCmain = new BLPrpCmain();
						blPrpCmain.getData(strPolicyNo);	
						DBManager dbManager = new DBManager();
						try{
							dbManager.open(AppConfig.get("sysconst.DBJNDI"));
							if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
								groupFlag = "0";//����
							}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
								groupFlag = "1";//����
							}
							isSuccess = BLCIClaimAcciSdPlatFormInterfaceFacade.getInstance().upload(dbManager, "L01", claimNo, groupFlag);
							if(isSuccess){
							    user.setUserMessage(user.getUserMessage() + "<br>ɽ�������շ���Ԥ�������Ǽǽӿ��ϴ��ɹ�!");
							}else{
								user.setUserMessage(user.getUserMessage() + "<br>ɽ�������շ���Ԥ�������Ǽǽӿ��ϴ�ʧ��!");
							}
						}catch(Exception e){
							e.printStackTrace();
							user.setUserMessage(user.getUserMessage() + "<br>"+e.getMessage());
						}finally{
							dbManager.close();
						}
					}
				}catch(ClaimCiPlatFormException e){
					e.printStackTrace();
					user.setUserMessage(user.getUserMessage() + "<br>�ϴ�����ƽ̨ʧ�ܣ�<br>" + e.getMessage());
				}catch(Exception e ){
					e.printStackTrace();
					user.setUserMessage(user.getUserMessage() + "<br>�ϴ�����ƽ̨ʧ��<br>" + e.getMessage());
				}
				
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
				user.setUserLastAction(userLastActionNow);
				httpServletRequest.setAttribute("prpLclaimDto", claimDto.getPrpLclaimDto());
			

			ActionMessages messages = new ActionMessages();
			UICodeAction uiCodeAction =new UICodeAction();
			String strRiskCode = httpServletRequest.getParameter("prpLclaimRiskCode");
			String strConfigCode = uiCodeAction.translateRiskCodetoConfigCode(strRiskCode);
			 
			if (httpServletRequest.getParameter("buttonSaveType").trim().equals("4")) {
			
				
				//add by dongyanqi begin 20050827���ɷ��ⰸ
				
				Collection dangerTrial = new BLPrpLreinsTrialFacade().findByConditions("certiNo = '" + claimNo + "'");
				//���û�з�̯���㣬���Ƚ��з�̯����
				if (dangerTrial == null || dangerTrial.size() == 0) {
					new UIReinsTrialAction().simulateRepayByDangerNo(claimNo,claimNo);
					getControlFlag(claimDto);
				}
				Collection dangerUnit = new BLPrpLdangerUnitFacade().findByConditions("certiNo = '" + claimNo + "'");
				if (dangerUnit != null) {
					Iterator iter = dangerUnit.iterator();
					while (iter.hasNext()) {
						PrpLdangerUnitDto prpLdangerUnitDto = (PrpLdangerUnitDto) iter.next();
						 String newRepayNo = new BLRepayFacade().genRepay(
								claimNo, 
								prpLdangerUnitDto.getDangerNo(),
								comCode, 
								userCode,
								prpLdangerUnitDto.getClaimADDTimes()
								);
						if (!newRepayNo.equals("")) {
							new BLRepayFacade().checkRepay(newRepayNo, userCode);
						}
					}
				} //add by dongyanqi end 20050827���ɷ��ⰸ
				
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.claim.submit"));
			} else {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.claim.save"));
			}
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLafterward.claimNo"));
			saveMessages(httpServletRequest, messages);

			
			  //�ٱ��е��ֽ�����ͬ���⴦��: ��Ҫ������ʾ. 2005-9-28
			  //httpServletRequest.setAttribute("com.sinosoft.flag", getControlFlag(claimDto));
			  //���������������嵥��д������
				if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3149,3148,3174,3150,3151,3197,3185,3165,3166,3184,3152,3153,3154,3155,3156,3228,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3179,3187,3178,3158,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3177,3163,3168,3169,3182".indexOf(riskCode) > -1)){
					if(!"".equals(settleListCode)&&null!=settleListCode){
					BLSettlemainlistFacade blSettlemainlistFacade=new BLSettlemainlistFacade();
					SettlemainlistDto settlemainlistDto =new SettlemainlistDto();
					settlemainlistDto=blSettlemainlistFacade.findByPrimaryKey(settleListCode);
					settlemainlistDto.setRegistercode(claimNo);
					blSettlemainlistFacade.update(settlemainlistDto);
					}
				}
				if("2801".indexOf(riskCode) > -1)
				{
					if(!"".equals(settleListCode)&&null!=settleListCode){
						BLSettlemainlistFacadeForMedical blSettlemainlistFacadeForMedical=new BLSettlemainlistFacadeForMedical();
						SettlemainlistDto settlemainlistDto =new SettlemainlistDto();
						settlemainlistDto=blSettlemainlistFacadeForMedical.findByPrimaryKey(settleListCode);
						settlemainlistDto.setRegistercode(claimNo);
						blSettlemainlistFacadeForMedical.update(settlemainlistDto);
						}
				}
				
				//���ձ������ֲ�����⣺���������������嵥��д�����š�
				String planting31FarmerListFlag = SysConfig.getProperty("PLNATING_31_FARMER_LIST_FLAG","claim");
				if((null != planting31FarmerListFlag && planting31FarmerListFlag.indexOf(riskCode) > -1)){
					if(!"".equals(settleListCode)&&null!=settleListCode){
						BLSettlemainlistFacade blSettlemainlistFacade=new BLSettlemainlistFacade();
						SettlemainlistDto settlemainlistDto =new SettlemainlistDto();
						settlemainlistDto=blSettlemainlistFacade.findByPrimaryKey(settleListCode);
						settlemainlistDto.setRegistercode(claimNo);
						blSettlemainlistFacade.update(settlemainlistDto);
					}
				}
				//��һ�����������嵥��������δ����ֱ�ӵ������,��Ҫ���嵥�ӱ����ݱ���ڵ�״̬ת��
				if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3148,3174,3150,3151,3197,3152,3153,3154,3155,3156,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3179,3158,3176,3177".indexOf(riskCode) > -1)){
					if(!"".equals(settleListCode)&&null!=settleListCode){
					PlantingsettlelistDto plantingsettlelistDto=null;
					BLPlantingsettlelistFacade blPlantingsettlelist=new BLPlantingsettlelistFacade();
					String strCondition=" settleListCode='"+settleListCode+"' and nodetype='claim'";
					String strCondition1=" settleListCode='"+settleListCode+"' and nodetype='check'";
					Collection plantingsettlelist=blPlantingsettlelist.findByConditions(strCondition);
					ArrayList plantingsettlelist1=(ArrayList)blPlantingsettlelist.findByConditions(strCondition1);
					ArrayList arrPlantingsettlelist=new ArrayList();
					if(plantingsettlelist.size()<1){
						if(plantingsettlelist1.size()>1){
							for(int i=0;i<plantingsettlelist1.size();i++){
							plantingsettlelistDto=new PlantingsettlelistDto();
							plantingsettlelistDto=(PlantingsettlelistDto)plantingsettlelist1.get(i);
							plantingsettlelistDto.setNodetype("claim");
							arrPlantingsettlelist.add(plantingsettlelistDto);
							}
							blPlantingsettlelist.insert(arrPlantingsettlelist);
						}		
					}
					}
				}
				//yx
				//if("3224".equals(riskCode))
				  if("3224,3201,3204,3238,3228,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(riskCode)>-1)
				{
					if(!"".equals(settleListCode)&&null!=settleListCode){
						NyxsettlelistDto nyxsettlelistDto=null;
						BLNyxsettlelistFacade blNyxsettlelistFacade=new BLNyxsettlelistFacade();
						String strCondition=" settleListCode='"+settleListCode+"' and nodetype='claim'";
						String strCondition1=" settleListCode='"+settleListCode+"' and nodetype='check'";
						Collection plantingsettlelist=blNyxsettlelistFacade.findByConditions(strCondition);
						ArrayList plantingsettlelist1=(ArrayList)blNyxsettlelistFacade.findByConditions(strCondition1);
						ArrayList arrPlantingsettlelist=new ArrayList();
						if(plantingsettlelist.size()<1){
							if(plantingsettlelist1.size()>1){
								for(int i=0;i<plantingsettlelist1.size();i++){
									nyxsettlelistDto=new NyxsettlelistDto();
									nyxsettlelistDto=(NyxsettlelistDto)plantingsettlelist1.get(i);
									nyxsettlelistDto.setNodetype("claim");
								arrPlantingsettlelist.add(nyxsettlelistDto);
								}
								blNyxsettlelistFacade.insert(arrPlantingsettlelist);
							}		
						}
						}
					
				}
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
			putNoback(claimNo);
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
			putNoback(claimNo);
		}
		return actionMapping.findForward(forward);
	}

	/**
	 * �����ٱ����ֽ�����ͬ���ⷽ��
	 * @param ClaimDto ����Dto
	 * @return String ��ʾ��Ϣ:�Ƿ���Ҫ�ֽ�����ͬ����
	 */
	/*
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
	*/
	/*
	 * �ش��ⰸ֪ͨ��־�ĸ��·���
	 */
	public void largelossUpdate(ClaimDto claimDto,String largeLossFlag){
		String greatClaimConditions = "update prpldangerunit set largelossflag = '"+largeLossFlag+"' where claimNo = '"+claimDto.getPrpLclaimDto().getClaimNo()+"'";
		try {
			new BLPrpLdangerUnitFacade().updateByconditions(greatClaimConditions);
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	/**
	 * �����ٱ����ֽ�����ͬ���ⷽ��
	 * @param ClaimDto ����Dto
	 * @return String ��ʾ��Ϣ:�Ƿ���Ҫ�ֽ�����ͬ����
	 */
	private String getControlFlag(ClaimDto claimDto) {
		String setControlFlagMsg = ""; //������ʾ��Ϣ
		String reinsMode = "";   //�ֱ���ʽ [1]=2����Լ
		String treatyNo = "";  //��Լ����
		String strControlFlag = ""; //�Ƿ񡰹�ͬ����/������ơ�
		String strLargeValueFlag = ""; // "1"Ϊ"����(��Լ)����"0"Ϊ"Σ�յ�λ����"
		String treatyFormalNo = ""; // ʵ�ʺ�Լ��
		BLFhTreatyFacade blFhTreatyFacade = new BLFhTreatyFacade();
		FhTreatyDto fhTreatyDto = new FhTreatyDto();
		PrpLreinsTrialDto prpLreinsTrialDto = new PrpLreinsTrialDto();

		try {
			Collection trialList = new ArrayList();
			boolean flag = false;
			Collection dangerTrial = new BLPrpLreinsTrialFacade()
					.findByConditions("certiNo = '"
							+ claimDto.getPrpLclaimDto().getClaimNo() + "'");
			Iterator itTrial2 = dangerTrial.iterator();
			if ((dangerTrial != null) && (dangerTrial.size() != 0)) {
				while (itTrial2.hasNext()) {
					prpLreinsTrialDto = (PrpLreinsTrialDto) itTrial2.next();
					reinsMode = prpLreinsTrialDto.getReinsMode();
					if ((reinsMode.substring(0, 1)).equals("2")) {
						flag = false;
						treatyNo = prpLreinsTrialDto.getTreatyNo();
						// ���ݺ�Լ�ŵ�fhtraty���л�ȡ��Լ��Ϣ
						fhTreatyDto = blFhTreatyFacade
								.findByPrimaryKey(treatyNo);
						// ��ȡʵ�ʺ�Լ��
						treatyFormalNo = fhTreatyDto.getTreatyFormalNo();
						prpLreinsTrialDto.setTreatyNo(treatyFormalNo);
						strControlFlag = fhTreatyDto.getControlFlag();
						if (strControlFlag == null
								|| "".equals(strControlFlag)
								|| strControlFlag.length() < 1) {
							continue;
						}
						if (!"".equals(fhTreatyDto.getLargeLossFlag())) {
							prpLreinsTrialDto.setFlag(fhTreatyDto
									.getControlFlag().substring(0, 1)
									+ fhTreatyDto.getLargeLossFlag());
						} else {
							prpLreinsTrialDto.setFlag(fhTreatyDto
									.getControlFlag().substring(0, 1) + "2");
						}
						prpLreinsTrialDto.setSumPaid(fhTreatyDto
								.getLargeLossValue());
						Iterator iterator = trialList.iterator();
						while (iterator.hasNext()) {
							PrpLreinsTrialDto trialDto = (PrpLreinsTrialDto) iterator
									.next();
							if (trialDto.getTreatyNo().equals(treatyFormalNo)) {
								trialDto.setSumClaim(trialDto.getSumClaim()
										+ prpLreinsTrialDto.getSumClaim());
								flag = true;
								break ; 
							}

						}
						if (flag == false) {
							trialList.add(prpLreinsTrialDto);
						}
					}
				}
			}
			if (trialList != null && trialList.size() > 0) {
				Iterator iterator = trialList.iterator();
				while (iterator.hasNext()) {
					PrpLreinsTrialDto trialDto = (PrpLreinsTrialDto) iterator
							.next();
					strControlFlag = trialDto.getFlag().substring(0, 1);
					strLargeValueFlag = trialDto.getFlag().substring(1, 2);
					if ("1".equals(strControlFlag)) {
						if ("0".equals(strLargeValueFlag)
								&& claimDto.getPrpLclaimDto().getSumClaim() > prpLreinsTrialDto
										.getSumPaid()) {
							// ����
							String greatClaimConditions = "update prpldangerunit set largelossflag = '1' where claimNo = '"
									+ claimDto.getPrpLclaimDto().getClaimNo()
									+ "' ";
							new BLPrpLdangerUnitFacade()
									.updateByconditions(greatClaimConditions);

						} else if ("1".equals(strLargeValueFlag)
								&& prpLreinsTrialDto.getSumClaim() > prpLreinsTrialDto
										.getSumPaid()) {
							String greatClaimConditions = "update prpldangerunit set largelossflag = '1' where claimNo = '"
									+ claimDto.getPrpLclaimDto().getClaimNo()
									+ "' ";
							new BLPrpLdangerUnitFacade()
									.updateByconditions(greatClaimConditions);
							break;
						}
					}
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return setControlFlagMsg;
	}
}
