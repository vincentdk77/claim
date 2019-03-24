package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.bz.common.RequestType;
import com.sinosoft.ciplatform.bl.action.domain.BLCIPlatformConfigAction;
import com.sinosoft.ciplatform.bl.facade.BLCIClaimSYXPlatFormInterfaceFacade;
import com.sinosoft.ciplatform.bl.facade.BLCIPlatformConfigFacade;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpDcodeDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.viewHelper.AgriRegistViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAARegistViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claimciplatform.bl.action.custom.BLCIClaimPlatFormCheckAction;
import com.sinosoft.claimciplatform.bl.facade.BLCIClaimPlatFormInterfaceFacade;
import com.sinosoft.claimciplatform.dto.custom.ClaimCiPlatFormException;
import com.sinosoft.common_claim.bl.action.custom.BLCIClaimPropPlatFormInterfaceFacade;
import com.sinosoft.platform.bl.facade.BLPrpDriskConfigFacade;
import com.sinosoft.platform.dto.domain.PrpDriskConfigDto;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.prpall.pubfun.TransCodeCI;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.undwrt.bl.facade.BLPrpCmainFacade;
import com.sinosoft.utiall.blsvr.BLPrpDcompany;

/**
 * �ַ�HTTP Post �������ⱨ���༭����
 * <p>Title: �������ⱨ���༭������Ϣ</p>
 * <p>Description: �������ⱨ���༭������Ϣ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author weishixin
 * @version 1.0
 */
public class UILRegistEditPostFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		String forward = ""; //��ǰ��ת
		String registNo = "";
		/**
		 * ����˼·��
		 *========================================================
		 *[1]����claimNo�ڽ����ǲ���Ϊ�գ��ж��ǲ��ǵ�һ�α��汨����
		 *[2]Ϊ�գ���ȡ�����ţ���ʹ��intCreateWorkFlowFlag =1
		 *[3]���汨������Ϣ
		 *[4]���永��״̬����Ϣ��strNodeStatus
		 *[5]���intCreateWorkFlowFlag =1 ����������
		 *[6]�ж�strNodeStatus�ǲ��ǵ����ύ�����ǵĻ���ֱ���޸Ĺ�����Map�е�״̬λ��Update
		 *[7]�����ύ��ִ��Complate������
		 *
		 *
		 *��Ԫ�µ�����(��ֲ��)
		 *[1]�ڱ�����ʱ�������ж��Ƿ�ñ����Ƿ���ڱ���prplregist�и��ݱ����Ų�ѯ���Ƿ�������
		 *[2]|| "H".equals(strRiskType)��ֲ�պ���ֳ�շ���,ԭ�е���ֳ�ղ���
		 *========================================================
		 */
		try {
			UICodeAction uiCodeAction = new UICodeAction();
			// String strRiskCode = uiCodeAction.translateProductCode("RISKCODE_DAA");
			// String strRiskCodeDAB = uiCodeAction.translateProductCode("RISKCODE_DAB");
			// String strRiskCodeDAE = uiCodeAction.translateProductCode("RISKCODE_DAE");
			//ȡ������
			//String registNo = ""; //������
			registNo = httpServletRequest.getParameter("prpLregistRegistNo");
			//������µǼǣ����ȡ�ű���ȡ�ⰸ���룬������޸ģ��򱣳�ԭ����claimNo����
			String createWorkFlowFlag = "0"; //�Ƿ���Ҫ�����������������һ�α��棬��Ҫ���������� 0 ��ʾ����Ҫ�� 1��ʾ��Ҫ
			//��ֹ�ظ�ˢ��,Ŀǰ���ƺţ������ˣ������������ж��ǲ���ͬһ��������
			String registReportorName = httpServletRequest.getParameter("prpLregistReportorName");
			String registLicenseNo = httpServletRequest.getParameter("prpLregistLicenseNo");
			String registReportDate = httpServletRequest.getParameter("prpLregistReportDate");
			String registReportHour = httpServletRequest.getParameter("prpLregistReportHour");
			String registPolicyNo = httpServletRequest.getParameter("prpLregistPolicyNo");
			String riskCode = httpServletRequest.getParameter("prpLregistRiskCode");
			String scheduleType = httpServletRequest.getParameter("scheduleType");
			String typeFlag = "";
			String mainPolicyNo = httpServletRequest.getParameter("mainPolicyNo");
			String qsFlag = httpServletRequest.getParameter("qsFlag");
			
			int year = DateTime.current().getYear();
			int nextNodeNo = 0;
			String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
			String comCodePolicy = httpServletRequest.getParameter("prpLregistComCode");
			//��������� �ڵ������
			//�Ƿ������
			String strScheduleTypeLoss = httpServletRequest.getParameter("nextScheduleTypeLoss");
			//�Ƿ�鿱����  
			String strScheduleTypeCheck = httpServletRequest.getParameter("nextScheduleTypeCheck");
			String policyComCode = httpServletRequest.getParameter("prpLregistComCode");
			String strLastAccessedTime = ""	+ httpServletRequest.getSession().getLastAccessedTime()/ 1000;
			String oldLastAccessedTime = (String) httpServletRequest.getSession().getValue("oldRegistLastAccessedTime");
			UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
			String strInsuredName = "";
	        //ת�ɶ�Ӧ�Ľ�ǿ�����ֺ�
	        TransCodeCI transCodeCI = new TransCodeCI();
	        String compelRiskCode = transCodeCI.convertToRiskCodeCI(riskCode); //ȡ��ǿ�Ʊ��յ����ִ���
			
			if ("ALLS".equals(scheduleType)) {
				typeFlag = "10";
			}

//			if (oldLastAccessedTime != null) {
//				//modify by miaowenjun 20060920 end
//				if (!oldLastAccessedTime.trim().equals("")) {
//					throw new UserException(1, 3, "0000", "�벻Ҫ�ظ��ύ��");
//				}
//			}

			//if(isTokenValid(httpServletRequest,true)){
			if (registNo.length() < 1 || registNo == null) { //ȡ��������
				UIBillAction uiBillAction = new UIBillAction();
				String tableName = "prplregist";
				//registNo = uiBillAction.getNo(tableName, riskCode, comCode, year);
				registNo = uiBillAction.getNo(tableName, riskCode,
						policyComCode, year);
				//modify by wangwei add start 2005-06-06
				//ԭ����session�д��һ���²����ı����ţ����ڱ����ύ���ݴ��Ĵ�ӡ��Ϣ
				// HttpSession  session = httpServletRequest.getSession();
				httpServletRequest.setAttribute("com.sinosoft.registno",
						registNo);
				httpServletRequest.setAttribute("riskCode", riskCode);
				//modify by wangwei add end 2005-06-06

				//registNo = "200000000010305000015";
				createWorkFlowFlag = "1";
			}
			
			httpServletRequest.setAttribute("registNo", registNo);
			httpServletRequest.setAttribute("newWorkFlow", createWorkFlowFlag);
			//Ϊ�����������ı�־
			//��viewHelper�����������
			//modify by miaowenjun 20060922 start ũ�����Լ���viewhelper
			RegistDto registDto = new RegistDto();
			//��ǰ�ð汾�Ʋ���û�е���,������Թ�Ԫ������ԲƲ���,������,�����ռ��ϵ��ȵÿ���
			//����⽡�ա�add by xiatian
			if ("I".equals(strRiskType)
					|| "Q".equals(strRiskType) || "Z".equals(strRiskType)
					|| "Y".equals(strRiskType)|| "H".equals(strRiskType) ||"E".equals(strRiskType)) {
				AgriRegistViewHelper agriRegistViewHelper = new AgriRegistViewHelper();
				registDto = agriRegistViewHelper.viewToDto(httpServletRequest);
			} else {
				DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
				registDto = dAARegistViewHelper.viewToDto(httpServletRequest);
			}
			//modify by miaowenjun 20060922 end ũ�����Լ���viewhelper
			//��������viewHelper�����������
			//add by wunier 20080107
			//reason:��ֲ����ֳ�ա������մ���ũҵ/��ũ/��ũ��־�Լ�����������/�ط�������/��ҵ�Ա�־
			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PrpCmainDto prpCmainDto = uiPolicyAction
					.findPrpCmainDtoByPrimaryKey(registPolicyNo);
			registDto.getPrpLregistDto().setBusinessType(
					prpCmainDto.getBusinessType());
			registDto.getPrpLregistDto().setBusinessType1(
					prpCmainDto.getBusinessType1());
			registDto.getPrpLregistDto().setBusinessFlag(prpCmainDto.getBusinessFlag());
			registDto.getPrpLregistDto().setOtherFlag(prpCmainDto.getOthFlag());
			//end by wunier 20080107

			WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			SwfLogDto swfLogDtoDealNode = new SwfLogDto();
			if (createWorkFlowFlag.equals("1")){
				swfLogDtoDealNode.setCreateFlow(true);
			}
			//�ж��Ƿ������״̬,������������ù������Ĳ���Ϊ�������̽���״̬��
			if (registDto.getPrpLregistDto().getAcceptFlag().equals("N")){
				swfLogDtoDealNode.setEndFlag("1");
			}
			//���ñ������빤�����ĸ���״̬
			swfLogDtoDealNode.setNodeType("regis");
			swfLogDtoDealNode.setNodeStatus(registDto.getPrpLclaimStatusDto().getStatus());
			swfLogDtoDealNode.setBusinessNo(registNo);
			swfLogDtoDealNode.setNextBusinessNo(registNo);
			swfLogDtoDealNode.setKeyIn(registNo);
			swfLogDtoDealNode.setKeyOut(registNo);
			swfLogDtoDealNode.setRiskCode(registDto.getPrpLregistDto().getRiskCode());
			swfLogDtoDealNode.setComCode(comCodePolicy);
			swfLogDtoDealNode.setPolicyNo(registPolicyNo);
			swfLogDtoDealNode.setRegistNo(registNo);//������Ĳ�ѯ���������ӱ����ţ��������ˣ����ƺ�(��������Ҫ���)  


			if (registDto.getPrpLregistDto().getInsuredNameShow() != null
					&& !registDto.getPrpLregistDto().getInsuredNameShow()
							.equals("")) {
				strInsuredName = registDto.getPrpLregistDto()
						.getInsuredNameShow();
			} else {
				strInsuredName = registDto.getPrpLregistDto().getInsuredName();
			}
			swfLogDtoDealNode.setInsuredName(strInsuredName);
			swfLogDtoDealNode.setLossItemName(registDto.getPrpLregistDto()
					.getLicenseNo());
			// modify by wangli add start 200504017
			swfLogDtoDealNode.setFlowInTime(registDto.getPrpLregistDto()
					.getFlowInTime().toString());
			// modify by wangli add end 200504017
			//��Ϊ�˵��˵�ԭ��/ָ���ڵ�����⣬Ŀǰֻ�г�����������ġ�
			//modify by qinyongli ���մ����������ԭ���ľ�һ������0501��Ϊ05������Ϊ����
			if ("D".equals(strRiskType)
					&& swfLogDtoDealNode.getNodeStatus().equals("4")) {
				String[] strNodeNo = httpServletRequest.getParameterValues("nextNodeNoList");
				Collection nextNodeList = new ArrayList();
				if (strNodeNo != null) {
					for (int i = 0; i < strNodeNo.length; i++) {
						SwfLogDto swfLogNextNode = new SwfLogDto();
						nextNodeNo = Integer.parseInt(strNodeNo[i]);
						swfLogNextNode.setNodeNo(nextNodeNo);
						nextNodeList.add(swfLogNextNode);
					}
				}
				//�����Ǵ�ģ���ж�ȡ�ı����ߵ�ģ����Ϣ(ע�⣬�����ǽڵ���룬�����ǿͻ��Լ�ѡ�����Ϣ

				//��Ϊitem��Ҫ��д���ݵġ���

				if (strScheduleTypeCheck.equals("1")) { //����鿱����
					SwfLogDto swfLogNextNode = new SwfLogDto();
					swfLogNextNode.setNodeNo(0);
					swfLogNextNode.setNodeType("sched");
					swfLogNextNode.setScheduleID(1);
					swfLogNextNode.setLossItemName(registDto.getPrpLregistDto()
							.getScheduleItemNote());
					//����itemcode��ֵ�Ĵ�С��
					swfLogNextNode.setLossItemCode(registDto.getPrpLregistDto()
							.getLossItemCode());
					swfLogNextNode.setTypeFlag(typeFlag);
					nextNodeList.add(swfLogNextNode);
				}

				//add by lym 20060202 for ǿ�� һ����������2������ ---start
				
			

				if (qsFlag.equals("Y")) {
					SwfLogDto swfLogNextNode = new SwfLogDto();
					swfLogNextNode.setNodeNo(0);
					swfLogNextNode.setNodeType("claim");
					swfLogNextNode.setPolicyNo(mainPolicyNo); //ǿ��������
					if("0507".equals(riskCode)){//������
						compelRiskCode = "0506";
					}else if("0577".equals(riskCode)){//Ħ�г�
						compelRiskCode = "0576";
					}else if("0587".equals(riskCode)){//������
						compelRiskCode = "0586";
					}
					swfLogNextNode.setRiskCode(compelRiskCode); // ǿ�� ����
					swfLogNextNode.setLossItemCode(registDto.getPrpLregistDto()
							.getLossItemCode());
					nextNodeList.add(swfLogNextNode);
				}
				//add by lym 20060202 for ǿ�� һ����������2������ ---end

				if (nextNodeList.size() > 0) {
					swfLogDtoDealNode.setNextNodeListType("1");//�����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
					swfLogDtoDealNode.setSwfLogList(nextNodeList);
				}
				//add by miaowenjun 20060921 ũ��ҲҪ�ߵ��ȳ�����ֲ�������ũ���ߵ���
			} else if (("I".equals(strRiskType) )
					&& swfLogDtoDealNode.getNodeStatus().equals("4")) {
				Collection nextNodeList = new ArrayList();
				String[] strNodeNo = httpServletRequest
						.getParameterValues("nextNodeNoList");
				if (strNodeNo != null) {
					for (int i = 0; i < strNodeNo.length; i++) {
						SwfLogDto swfLogNextNode = new SwfLogDto();
						nextNodeNo = Integer.parseInt(strNodeNo[i]);
						swfLogNextNode.setNodeNo(nextNodeNo);
						nextNodeList.add(swfLogNextNode);
					}
				}
				// �����Ǵ�ģ���ж�ȡ�ı����ߵ�ģ����Ϣ(ע�⣬�����ǽڵ���룬�����ǿͻ��Լ�ѡ�����Ϣ
				SwfLogDto swfLogNextNode = new SwfLogDto();
				swfLogNextNode.setNodeNo(0);
				swfLogNextNode.setNodeType("sched");
				swfLogNextNode.setScheduleID(1);
				swfLogNextNode.setLossItemName(registDto.getPrpLregistDto()
						.getScheduleItemNote());
				// ����itemcode��ֵ�Ĵ�С��
				swfLogNextNode.setLossItemCode(registDto.getPrpLregistDto()
						.getLossItemCode());
				swfLogNextNode.setTypeFlag(typeFlag);
				nextNodeList.add(swfLogNextNode);

				if (nextNodeList.size() > 0) {
					swfLogDtoDealNode.setNextNodeListType("1");// �����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
					swfLogDtoDealNode.setSwfLogList(nextNodeList);
				}
			}

			// ���������Ĵ���/�޸�/�ύ������
			WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,
					swfLogDtoDealNode);

			// �쳣����
			if (registNo.equals("") || registNo.length() != 22) {
				//throw new UserException(-98,-200,"","�������");
			}
			//У�����ԭ���Ƿ�Ϊ��
			String prpLregistDamageCode = registDto.getPrpLregistDto().getDamageCode();
			String prpLregistDamageName = registDto.getPrpLregistDto().getDamageName();
			String conditions = "select * from prpdcode where codecode in (select ss.codecode "+
		       "from prpdcoderisk ss "+
		       "where ss.riskcode = '"+riskCode+"' "+
		         "and ss.codetype = 'DamageCode' )"+
					"and codetype = 'DamageCode' "+
					"and validstatus = '1'";
			ArrayList PrpDcodeDtoList = (ArrayList)uiCodeAction.findByConditions(UICodeAction.DAMAGECODE,conditions,0,0);
			if(prpLregistDamageCode == null || "".equals(prpLregistDamageCode)){
				user.setUserMessage("����ԭ����Ϊ�գ�������¼������ύ��");
				throw new UserException(-98,0,"����ԭ����Ϊ�գ�������¼������ύ��");
			}else{
				PrpDcodeDto prpDcodeDto = null;
				for(int j=0;j < PrpDcodeDtoList.size();j++){
					prpDcodeDto = new PrpDcodeDto();
					prpDcodeDto = (PrpDcodeDto)PrpDcodeDtoList.get(j);
					if(prpDcodeDto.getCodeCode().equals(prpLregistDamageCode) && 
							prpDcodeDto.getCodeCName().equals(prpLregistDamageName)	){
						
					}else{
						user.setUserMessage("����ԭ�����ͳ���ԭ��˵����һ�£�������¼������ύ��");
						new UserException(-98,0,"����ԭ�����ͳ���ԭ��˵����һ�£�������¼������ύ��");
					}
				}
			}
			
			UIRegistAction uiRegistAction = new UIRegistAction();

			if (workFlowViewHelper.checkDealDto(workFlowDto)) {
				uiRegistAction.save(registDto, workFlowDto);
				user.setUserMessage(registNo);
			} else {
				if (workFlowDto.getOperateResult() < 0) {
					user.setUserMessage("ע��:��������������ʱ��δ�ҵ���ع�����ģ������ã�����ϵϵͳ����Ա������Ӧ���ã���");
				} else {
					uiRegistAction.save(registDto);
					user.setUserMessage(registNo + ";ע��:û�з����빤������������κ����ݣ���");
				}
			}
			httpServletRequest.getSession().putValue(
					"oldRegistLastAccessedTime", strLastAccessedTime);
			//       add end by guolei 20060711 begin
			
			//�Ϻ�ƽ̨�⽡�ձ�����Ϣ�ϴ�
			boolean isYJXFlag = false;
			String groupFlag = "";
			BLPrpDcompany blPrpDcompany = new BLPrpDcompany();
			String secodeComCode = blPrpDcompany.getDaaPlatformComCode(registDto.getPrpLregistDto().getComCode());
			//String strPolicyNo = prpLregistDto.getPolicyNo();//������
			if("26,27,28".indexOf(riskCode.substring(0,2)) > -1){
				isYJXFlag = true;
			}
			System.out.println(httpServletRequest.getParameter("buttonSaveType").trim());
			if(isYJXFlag && "310000".equals(secodeComCode) && "4".equals(httpServletRequest.getParameter("buttonSaveType").trim())){
				System.out.println("------------------�Ϻ�ƽ̨�⽡�ձ����ӿڵ���,registno= " + registNo +" --------------------------");
				//���ݱ���������ѯ������Ϣ,�жϸñ����Ƿ�Ϊ�ŵ�
				boolean isSuccess = false;
				BLPrpCmain blPrpCmain = new BLPrpCmain();
				blPrpCmain.getData(registPolicyNo);	
				DBManager dbManager = new DBManager();
				try {					
					dbManager.open(AppConfig.get("sysconst.DBJNDI"));
					//����prpcmain.groupNo�Ƿ�Ϊ���ж��Ƿ�Ϊ�ŵ�
					if(blPrpCmain.getSize() > 0){
						if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
							groupFlag = "0";//����
							isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C01", "01", registNo, registPolicyNo, groupFlag, secodeComCode);
						}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
							groupFlag = "1";//����
							isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C04", "01", registNo, registPolicyNo, groupFlag, secodeComCode);
						}
						if(isSuccess){
						    user.setUserMessage(user.getUserMessage() + "<br>�⽡�ձ�����Ϣ�ϴ�ƽ̨�ɹ�!");
						}else{
							user.setUserMessage(user.getUserMessage() + "<br>�⽡�ձ�����Ϣ�ϴ�ƽ̨ʧ��!");
						}
					}					
				} catch (Exception e) {
					e.printStackTrace();
					user.setUserMessage(user.getUserMessage() + "<br>"+e.getMessage());
				} finally{//�ر�����Դ
					dbManager.close();
				}				
			}
			
			//����ƽ̨�ϴ�
			String strHerf = "(<a href=\"javascript:showErrorInfo('info')\">��ϸ��Ϣ</a>)";
			try{
				if (httpServletRequest.getParameter("buttonSaveType").trim()
						.equals("4") && "D".equals(strRiskType)) {
					
					System.out.println("���Ͻ��н�ǿ��ƽ̨����");
					//�ӹ�������ȡ��ǿ�յı�����
					String policyNo = "";
					BLPrpLRegistRPolicyFacade blPrpLregistRPolicyFacade = new BLPrpLRegistRPolicyFacade();
					Collection collection = blPrpLregistRPolicyFacade.findByRegistNo(registDto.getPrpLregistDto().getRegistNo());
					PrpLRegistRPolicyDto prpLregistRPolicyDto = null;
					for(Iterator i = collection.iterator(); i.hasNext();){
						prpLregistRPolicyDto = (PrpLRegistRPolicyDto) i.next();
						if("0507".equals(prpLregistRPolicyDto.getRiskCode())){
							policyNo = prpLregistRPolicyDto.getPolicyNo();
							continue;
						}
					}
					boolean isUpload = false;
					
					isUpload = BLCIClaimPlatFormCheckAction.checkUploadForRegist(policyNo, registDto.getPrpLregistDto().getRegistNo());
					if(isUpload){
						BLCIClaimPlatFormInterfaceFacade.getInstance().upload(
								RequestType.REGIST_SIGN,
								registDto.getPrpLregistDto().getRegistNo(),"", true,"0");
						
						user.setUserMessage(user.getUserMessage() + "<br>�ϴ�����ƽ̨�ɹ�!");
					}
					
					
					System.out.println("���Ͻ�����ҵ��ƽ̨����");
					//2011
					//��ҵ���ϴ�ƽ̨����
					String configValue="";
					UIRegistAction uIRegistAction=new UIRegistAction();
					RegistDto registDtopm=uIRegistAction.findByPrimaryKey(registNo);
					String comcode=registDtopm.getPrpLregistDto().getComCode();
					boolean boo=false;
					if("0506".equals(riskCode)){//��ҵ�ձ���
						boo=true;
					}else{//��ǿ�ձ���,�����������ҵ�ձ���
						BLPrpLRegistRPolicyFacade blPrpLregistRPolicyFacade2=new BLPrpLRegistRPolicyFacade();
						String condtion=" registno='"+registNo+"' and riskcode='0506' ";
						Collection coll=blPrpLregistRPolicyFacade2.findByConditions(condtion);
						if(coll!=null && coll.size()>0){
							PrpLRegistRPolicyDto prpLRegistRPolicyDto=(PrpLRegistRPolicyDto)coll.iterator().next();
							String policyno=prpLRegistRPolicyDto.getPolicyNo();
							com.sinosoft.prpall.dto.domain.PrpCmainDto prpCmainDtopm=new com.sinosoft.prpall.bl.facade.BLPrpCmainFacade().findByPrimaryKey(policyno);
							if(prpCmainDtopm!=null ){
								comcode=prpCmainDtopm.getComCode();
								boo=true;
							}
						}
					}
					if(boo && comcode!=null && !"".equals(comcode)){
						String comcodeSub=comcode.substring(0,2);
						BLCIPlatformConfigFacade bLCIPlatformConfigFacade=new BLCIPlatformConfigFacade();
						CIPlatformConfigDto cIPlatformConfigDto=bLCIPlatformConfigFacade.findByPrimaryKey("CI_TRANSPORT_MODE", comcodeSub, "0506");
						if(cIPlatformConfigDto!=null && "1".equals(cIPlatformConfigDto.getValidStatus())){
							if("0".equals(cIPlatformConfigDto.getConfigValue())) {//2011	0��ʱ������1�Ǽ�ʱ����
								BLCIClaimSYXPlatFormInterfaceFacade
										.getInstance()
										.upload(
												com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.REGIST_SYX,
												registNo,
												true,cIPlatformConfigDto,"0","");
								user.setUserMessage(user.getUserMessage()
										+ "<br>�����ϴ���ҵ��ƽ̨�ɹ�!");
							}else{
								BLCIClaimSYXPlatFormInterfaceFacade
								.getInstance()
								.upload(
										com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.REGIST_SYX,
										registNo,
										false,cIPlatformConfigDto,"0","");
								user.setUserMessage(user.getUserMessage()
										+ "<br>�����ϴ���ҵ��ƽ̨�ɹ�!");
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
			
			
			//���������� SCHEDULE_AUTOCOMMIT��������Ҫ�Զ���ת�����ȵĲ��ż����Զ���ת�Ĺ���
			String strSchedule = AppConfig.get("sysconst.SCHEDULE_AUTOCOMMIT");
			String comCodeTemp = user.getComCode().substring(0, 4);
			if (swfLogDtoDealNode.getNodeStatus().equals("4")
					&& "D".equals(strRiskType)
					&& strSchedule.indexOf(comCodeTemp) >= 0) {
				//��Ҫ�Զ���ת,�������ύ����ܽ��е���ת
				//Ҫ�ж��ǲ鿱���ȣ����Ƕ������
				String scheduleRef = "/claim/scheduleDealRegist.do?prpLscheduleMainWFRegistNo="
						+ registNo
						+ "&prpLscheduleMainWFSurveyNo=0"
						+ "&status=0"
						+ "&riskCode="
						+ riskCode
						+ "&editType=ADD";
				String goFlowID = "";
				int goLogNo = 0;
				//������תλ��
				if (workFlowDto.getSubmitSwfLogDtoList() != null) {
				}
				if (goLogNo > 0) { //��ȷ�ҵ���ת��λ�ú�
					scheduleRef = scheduleRef + "&swfLogFlowID=" + goFlowID
							+ "&swfLogLogNo=" + goLogNo;
					httpServletResponse.sendRedirect(scheduleRef);
				}
			}

			httpServletRequest.setAttribute("prpLregistDto", registDto
					.getPrpLregistDto());

			//} 

			String registSaveMessage = "q" + registNo;
			ActionMessages messages = new ActionMessages();
			Object obj_msg = registSaveMessage;
			if (httpServletRequest.getParameter("buttonSaveType").trim()
					.equals("4")) {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"prompt.regist.submit"));
			} else {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"prompt.regist.save"));
			}
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"db.prpLregist.registNo"));
			saveMessages(httpServletRequest, messages);
			httpServletRequest.setAttribute("buttonSaveType", httpServletRequest.getParameter("buttonSaveType").trim());
			//add by zhaolu 20060913 start
			//������ֱ�ӵ���
			httpServletRequest.setAttribute("policyNo", registPolicyNo);
			httpServletRequest.setAttribute("handleDept", comCodePolicy);
			//����Ҫ�޸��жϵ�����
			//��ֲҲ��Ҫ����add by xiatian 
			if(!"H".equals(strRiskType)||!"0".equals(createWorkFlowFlag) ){
			String swfLogFlowID = workFlowDto.getUpdateSwfLogDto().getFlowID();
			httpServletRequest.setAttribute("swfLogFlowID", swfLogFlowID);
	        }
			//add by zhaolu 20060913 end
			
			
			String scheduleRef1 = httpServletRequest.getParameter("scheduleRef")==null?"":httpServletRequest.getParameter("scheduleRef");
			if("scheduleRef".equals(scheduleRef1)){
				
				String scheduleRedirect="/claim/scheduleDealRegist.do?prpLscheduleMainWFRegistNo="+registNo
				+"&prpLscheduleMainWFSurveyNo=0"
				+"&scheduleType=sched"
				+"&handleDept="+user.getComCode()
				+"&endflag=0"
				+"&commiFlag=0"
				+"&status=0"
				+"&riskCode="+riskCode
				+"&editType=ADD"
				+"&nodeType=sched"
				+"&businessNo="+registNo
				+"&keyIn="+registNo
				+"&schedFlag=Y"
				;
				
				if (workFlowDto.getSubmitSwfLogDtoList() != null) {
					SwfLogDto swfLog = (SwfLogDto) workFlowDto.getSubmitSwfLogDtoList().get(0);
					scheduleRedirect += "&swfLogFlowID="+swfLog.getFlowID()
					+"&swfLogLogNo="+swfLog.getLogNo()+"&policyNo="+swfLog.getPolicyNo()
					+"&modelNo="+swfLog.getModelNo()
					+"&nodeNo="+swfLog.getNodeNo();
				}
				
				httpServletResponse.sendRedirect(scheduleRedirect);
			}else{
				//Ĭ�ϲ���Ҫ�Զ���ת
				forward = "success";
			}

		} catch (UserException usee) {
			usee.printStackTrace();
			//������Ϣ����
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError(
					"title.registBeforeEdit.editRegist");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			//erroeMessageΪUnkown Messageʱ���쳣��Ϣ���Զ����
			if(usee.getErrorMessage().equals("Unkown Message")){
				httpServletRequest.setAttribute("errorMessage", usee
						.getErrorModule());
			}else{
				httpServletRequest.setAttribute("errorMessage", usee
						.getErrorMessage());
			}
			saveErrors(httpServletRequest, errors);
			forward = "error";
			this.putNoback(registNo);
		}

		catch (SQLException sqle) {
			StringWriter stringWriter = new StringWriter();
			sqle.printStackTrace(new PrintWriter(stringWriter));
			sqle.printStackTrace();
			//������Ϣ����
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError(
					"title.registBeforeEdit.editRegist");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter
					.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";
			this.putNoback(registNo);
		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//������Ϣ����
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError(
					
					"title.registBeforeEdit.editRegist");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter
					.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";
			this.putNoback(registNo);

		} finally {

		}

		return actionMapping.findForward(forward);
	}

	//add by huangyunzhong ���ӳ����źŻع麯�� 20051208
	public boolean putNoback(String registNo) throws SQLException, Exception {

		UIBillAction uiBillAction = new UIBillAction();
		String tableName = "prplregist";
		if (uiBillAction.putNo(tableName, registNo)) {
			System.out.println("���ŷŻسɹ�" + registNo);
		} else {
			System.out.println("���ŷŻ�ʧ��" + registNo);
		}
		return true;
	}
	//add end by huangyunzhong 20051208
}
