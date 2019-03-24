package com.sinosoft.claim.webservice;

import java.io.OutputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.soap.SOAPException;

import sun.misc.BASE64Decoder;

import com.sinosoft.claim.bl.action.domain.BLPrpCmainAction;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcertifyDirectFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcertifyImgFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcheckFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcheckLossFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimStatusFacade;
import com.sinosoft.claim.bl.facade.BLPrpLdriverFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpersonTraceFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistTextFacade;
import com.sinosoft.claim.bl.facade.BLPrpLscheduleItemFacade;
import com.sinosoft.claim.bl.facade.BLPrpLscheduleMainWFFacade;
import com.sinosoft.claim.bl.facade.BLPrpLthirdPartyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLthirdPropFacade;
import com.sinosoft.claim.bl.facade.BLRegistFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpCcarDriverDto;
import com.sinosoft.claim.dto.domain.PrpCinsuredDto;
import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyDirectDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLcheckLossDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLdriverDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.claim.dto.domain.PrpLpersonTraceDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcode;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcompany;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDrisk;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDuser;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UILogonAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.FtpClient;
import com.sinosoft.platform.bl.facade.BLPrpDuserFacade;
import com.sinosoft.platform.bl.facade.BLUtiGradeTaskFacade;
import com.sinosoft.platform.dto.domain.UtiGradeTaskDto;
import com.sinosoft.platform.dto.domain.UtiUserGradeDto;
import com.sinosoft.platform.ui.control.action.UIPowerAction;
import com.sinosoft.platform.ui.model.UtiUserGradeQueryByUserCodeCommand;
import com.sinosoft.prpall.blsvr.cb.BLPrpCitemCar;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmainSub;
import com.sinosoft.sysframework.common.Constants;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.EncryptUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utiall.blsvr.BLPrpDcompany;

/***
 * �ƶ��鿱WebService��
 * 
 * @author fengye
 * 
 */
public class MobileSurvey {

	/**
	 * ͨ���������б������ı����ţ���ȡ������Ϣ�б�
	 * �б��������������롢�������ˡ���ʻ֤���������ƺ��롢���ͺ��롢���ܺ��롢���������롢Ͷ�����ڡ�Ͷ������
	 * ��ʹ�����ʡ���ʻ�����³����üۡ�Լ����ʻԱ����������Ͷ���ձ��
	 * 
	 * @param registNo
	 * @return �������ݻ��� null
	 * @throws SOAPException 
	 */
	public PolicyInfo getPolicyInfo(String registNo) throws SOAPException {// ���

		PolicyInfo policyInfo = null;
		UIRegistAction uiRegistAction = new UIRegistAction();
		String comCode = "";
		String comName = "";
		String operateDate = "";
		String endDate = "";
		String driverName = "";
		String kindCode = "";
		String kindName = "";
		double deductible = 0d;

		try {
			if (isEmpty(registNo)) {// ��Ч��У��
				throw new Exception("��������Ϣ��Ч�����顣����������");
			}

			RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
			PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();

			if (prpLregistDto != null) {
				EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
				policyInfo = new PolicyInfo();
				PolicyDto policyDto = endorseViewHelper.findForEndorBefore(prpLregistDto.getPolicyNo(), registDto.getPrpLregistDto().getDamageStartDate().toString(), registDto.getPrpLregistDto()
						.getDamageStartHour());

				PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
				PrpCitemCarDto prpCitemCarDto = (PrpCitemCarDto) policyDto.getPrpCitemCarDtoList().get(0);
				List<PrpCitemKindDto> prpCitemKindList = policyDto.getPrpCitemKindDtoList();
				String policyNo = prpLregistDto.getPolicyNo();
				String LinkPolicyNo = "";
				
				String riskCode = prpLregistDto.getRiskCode();
				BLPrpCmainSub blPrpCmainSub = new BLPrpCmainSub();
				if("0506".equals(riskCode) || "0586".equals(riskCode) || "0576".equals(riskCode)){
					String conditions = " policyNo = '" + policyNo + "'";
					blPrpCmainSub.query(conditions);
					LinkPolicyNo = blPrpCmainSub.getArr(0).getMainPolicyNo();
				}else{
					String conditions = " mainPolicyNo = '" + policyNo + "'";
					blPrpCmainSub.query(conditions);
					if(blPrpCmainSub.getSize() > 0){
						LinkPolicyNo = blPrpCmainSub.getArr(0).getPolicyNo();
					}
				}
				BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
				
				ArrayList prpCitemKindList1 = new ArrayList(); 
				if(!isEmpty(LinkPolicyNo)){
					policyNo += "," + LinkPolicyNo ;
					String conditions = " policyNo = '" + LinkPolicyNo + "'";
					prpCitemKindList1 = (ArrayList)blPrpCitemKindFacade.findByConditions(conditions);
				}
				if(!isEmpty(prpCitemKindList1)){
					prpCitemKindList.addAll(prpCitemKindList1);
				}
				if ("1".equals(prpCitemCarDto.getAgreeDriverFlag())) {// Լ���˼�ʻԱ
					List<PrpCcarDriverDto> prpCcarDriverDtoList = policyDto.getPrpCcarDriverDtoList();
					if (prpCcarDriverDtoList != null && prpCcarDriverDtoList.size() != 0) {// ����Լ����ʻԱ
						for (int i = 0; i < prpCcarDriverDtoList.size(); i++) {
							PrpCcarDriverDto prpCcarDriverDto = prpCcarDriverDtoList.get(i);
							if (i != prpCcarDriverDtoList.size() - 1) {
								driverName += prpCcarDriverDto.getDriverName() + ",";
							} else {
								driverName += prpCcarDriverDto.getDriverName();
							}
						}
					}
				}

				if (prpCitemKindList != null && prpCitemKindList.size() != 0) {
					for (int i = 0; i < prpCitemKindList.size(); i++) {
						PrpCitemKindDto prpCitemKindDto = prpCitemKindList.get(i);
						if (i != prpCitemKindList.size() - 1) {
							kindCode += prpCitemKindDto.getKindCode() + ",";
							kindName += prpCitemKindDto.getKindName() + ",";
							deductible = prpCitemKindDto.getDeductible();
						} else {
							kindCode += prpCitemKindDto.getKindCode();
							kindName += prpCitemKindDto.getKindName();
						}
					}
				}

				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				operateDate = dateFormat.format(prpCmainDto.getStartDate().getTime());
				endDate = dateFormat.format(prpCmainDto.getEndDate().getTime());
				comCode = prpCmainDto.getComCode();
				comName = new BLPrpDcompanyFacade().findByPrimaryKey(comCode).getComCName();

				policyInfo.setPolicyNo(policyNo);
				policyInfo.setComCode(comCode);
				policyInfo.setComName(comName);
				policyInfo.setInsuredCode(prpCmainDto.getInsuredCode());
				policyInfo.setInsuredName(prpCmainDto.getInsuredName());
				policyInfo.setOperateDate(operateDate);
				policyInfo.setEndDate(endDate);
				policyInfo.setCarOwner(prpCitemCarDto.getCarOwner());
				policyInfo.setBrandName(prpCitemCarDto.getBrandName());
				policyInfo.setLicenseNo(prpCitemCarDto.getLicenseNo());
				policyInfo.setEngineNo(prpCitemCarDto.getEngineNo());
				policyInfo.setFrameNo(prpCitemCarDto.getFrameNo());
				policyInfo.setDriverName(driverName);
				policyInfo.setRunAreaCode(prpCitemCarDto.getRunAreaCode());
				policyInfo.setRunAreaName(prpCitemCarDto.getRunAreaName());
				policyInfo.setUseNatureCode(prpCitemCarDto.getUseNatureCode());
				policyInfo.setUseNatureName(new UICodeAction().translateCodeCode("UseNature", prpCitemCarDto.getUseNatureCode(), true));
				policyInfo.setPurchasePrice(prpCitemCarDto.getPurchasePrice());
				policyInfo.setLicenseColorCode(prpCitemCarDto.getLicenseColorCode());
				policyInfo.setCarKindCode(prpCitemCarDto.getCarKindCode());
				policyInfo.setKindCode(kindCode);
				policyInfo.setKindName(kindName);
				policyInfo.setDeductible(deductible);
			}

		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return policyInfo;

	}

	/**
	 * ��1���ж��û���¼����
	 * 
	 * @param userNo
	 * @param password
	 * @return logonStatus �Ƿ������¼
	 * @throws SOAPException 
	 */
	public boolean login(String userNo, String password) throws SOAPException {
		boolean logonStatus = false;
		try {
			if (isEmpty(userNo) || isEmpty(password)) {
				throw new Exception("�û�����������󣡡���������");// ��¼��Ϣ��������ת����У����Чҳ��
			} else {
				UILogonAction uILogonAction = new UILogonAction();
				PrpDuserDto prpDuserDto;
				prpDuserDto = uILogonAction.checkUser(userNo, password);
				if (prpDuserDto != null) {
					logonStatus = true;
				}
			}
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return logonStatus;
	}

	/**
	 * ��2����ȡ��¼���� ���ݣ�Ա��������˾���� �ֶΣ���¼����
	 * 
	 * @return �������ݻ���null
	 * @throws Exception
	 */
	public CompanyInfo[] getCompanyNo(String userNo) throws Exception {
		CompanyInfo[] companyInfoList = null;
		try {
			if (!isEmpty(userNo)) {
				UtiUserGradeQueryByUserCodeCommand command = new UtiUserGradeQueryByUserCodeCommand(userNo, 1, 65535);
				PageRecord record = (PageRecord) command.execute();
				Collection<?> result = record.getResult();
				if (!isEmpty(result)) {// �����Ч�Ļ�
					companyInfoList = new CompanyInfo[result.size()];
					int i = 0;
					for (Iterator<?> iter = result.iterator(); iter.hasNext();) {
						UtiUserGradeDto element = (UtiUserGradeDto) iter.next();
						companyInfoList[i++] = new CompanyInfo(element.getComCode(), element.getComName());
					}
				}
			} else {
				throw new Exception("������Ϣ��Ч��....");
			}
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return companyInfoList;

	}

	/**
	 * ����Ա�����š�Ա��������˾�����Լ�����״̬��ȡԱ����ͬ״̬�������б� �ֶΣ������š����ƺš�����ʱ�䡢����״̬���ɹ����͵�
	 * 
	 * @param userNo
	 * @param loginOrgan
	 * @param taskStatus
	 * @return �������ݻ���null
	 * @throws Exception
	 */
	public TaskInfo[] getTaskList(String userNo, String loginOrgan, String taskStatus) throws Exception {

		TaskInfo[] taskList = null;
		try {
			if (isEmpty(userNo) || isEmpty(loginOrgan) || isEmpty(taskStatus)) {
				throw new Exception("������Ϣ��Ч��");
			}

			com.sinosoft.platform.dto.domain.PrpDuserDto userDto = new com.sinosoft.platform.dto.domain.PrpDuserDto();
			UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
			BLUtiGradeTaskFacade blUtiGradeTaskFacade = new BLUtiGradeTaskFacade();
			UtiGradeTaskDto utiGradeTaskDto = null;
			Map<String, String> gradeCodeMap = new HashMap<String, String>();
			String gradecodes = "";
			String gradeCondition = " taskcode = 'claim' and gradecode in " + // ֻ��ѯ����ϵͳ��Ȩ�޴���
					"(select gradecode from utiusergradepower " + "where usercode='" + userNo + "') and gradecode<>'122'";
			ArrayList<?> gradeList = (ArrayList<?>) blUtiGradeTaskFacade.findByConditions(gradeCondition);
			for (int i = 0; i < gradeList.size(); i++) {
				utiGradeTaskDto = (UtiGradeTaskDto) gradeList.get(i);
				if (!gradeCodeMap.containsKey(utiGradeTaskDto.getGradeCode())) {
					gradeCodeMap.put(utiGradeTaskDto.getGradeCode(), utiGradeTaskDto.getGradeCode());
					gradecodes += "," + utiGradeTaskDto.getGradeCode();
				}
			}
			if (gradecodes.length() > 1) {
				gradecodes = gradecodes.substring(1, gradecodes.length());
			}
			// ----------------------------
			userDto.setUserCode(userNo);
			userDto.setLoginComCode(loginOrgan);
			userDto.setLoginGradeCodes(gradecodes);
			// ------------------------\
			String nodeType = "check";
			String condition = " nodeType='" + nodeType + "' and flowStatus!='0' and (handlerCode='" + userNo + "' or handlerCode is null or handlerCode='')";
			//add by xiatian 26 27 31 Ҳ�ɲ鿱
			condition = condition + " and NodeStatus='" + taskStatus +"'";     //"' and (riskcode not like '27%' and riskCode not like '26%' and riskCode not like '31%')";
			condition = condition + " and riskcode in (select distinct outercode from uticodetransfer where risktype='D' and validstatus='1') ";
			condition = condition + " and ((modelno=7  " + UIPowerAction.addPower(userDto, "vv", "", "ComCode").replace("vv", "Swflog") + ") or (modelno<>7 "
					+ UIPowerAction.addPower(userDto, "kk", "", "handledept").replace("kk", "Swflog") + ") )";
			condition = condition + "order by flowintime desc";
			Collection<?> swfList = uiWorkFlowAction.findNodesByConditions(condition);

			if (!isEmpty(swfList)) {
				taskList = new TaskInfo[swfList.size()];
				int i = 0;
				for (Iterator<?> it = swfList.iterator(); it.hasNext();) {
					TaskInfo temp = new TaskInfo();
					SwfLogDto swflogtemp = (SwfLogDto) it.next();

					temp.setRegistNo(swflogtemp.getRegistNo());
					temp.setLicenseNo(swflogtemp.getLossItemName());
					temp.setTaskStatus(swflogtemp.getNodeStatus());
					temp.setAcceptTime(swflogtemp.getHandleTime());
					temp.setDispatchType("����");
					temp.setInsuredName(swflogtemp.getInsuredName());
					taskList[i++] = temp;
				}
			}
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}

		return taskList;
	}

	/**
	 * ͨ���������б������ı����ţ���ȡ������Ϣ�б���������ʱ�䡢������Ա����������������̶ȡ���ͼ��Ϣ�ȡ�
	 * 
	 * @param registNo
	 * @return �������ݻ���NUll
	 * @throws Exception
	 */
	public DispatchInfo getDispatchInfo(String registNo) throws Exception {//

		DispatchInfo dispatchInfo = null;
		try {
			if (isEmpty(registNo)) {
				throw new Exception();
			}
			BLPrpLscheduleMainWFFacade bLPrpLscheduleMainWFFacade = new BLPrpLscheduleMainWFFacade();
			Collection<PrpLscheduleMainWFDto> prpLscheduleMainWFDtoList = bLPrpLscheduleMainWFFacade.findByConditions("registNo=" + registNo);
			if (!isEmpty(prpLscheduleMainWFDtoList)) {
				Iterator<?> it = prpLscheduleMainWFDtoList.iterator();
				PrpLscheduleMainWFDto prpLscheduleMainWFDto = (PrpLscheduleMainWFDto) it.next();
				if (prpLscheduleMainWFDto == null || "0".equals(prpLscheduleMainWFDto.getScheduleFlag())) {// Ϊ���Ȼ���δ�鵽��Ϣ��Ч
					throw new Exception();
				}
				dispatchInfo = new DispatchInfo();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dispatchDate = dateFormat.format(prpLscheduleMainWFDto.getInputDate().getTime());
				
				dispatchInfo.setDispatchDate(dispatchDate);
				dispatchInfo.setCheckInfo(prpLscheduleMainWFDto.getCheckInfo());
				dispatchInfo.setHandlerCode(prpLscheduleMainWFDto.getOperatorCode());
				UICodeAction uICodeAction = new UICodeAction();
				dispatchInfo.setHandlerName(uICodeAction.translateUserCode(prpLscheduleMainWFDto.getOperatorCode(),true));
			}
		} catch (Exception e) {
			throw new SOAPException("������Ϣ��Ч���߸ð���δ���е��ȴ���......");
		}
		return dispatchInfo;
	}

	/**
	 * ���ݽ�����ͨ���������б������ı����ţ���ȡ������Ϣ�б�
	 * �����������롢����ʱ�䡢�����ˡ������˵绰����ʻԱ����ʻԱ�绰�����ƺ��롢�¹����͡�����ԭ��
	 * ���������򡢴����š��¹����Ρ���ʧ���͡��������������վ��������յص㡢���մ�������Ϣ��
	 * 
	 * @param registNo
	 *            ����������
	 * @return �������ݻ���NUll
	 * @throws SOAPException 
	 */
	public RegistDetailInfo getCaseDetailInfo(String registNo) throws SOAPException {// Update ����

		RegistDetailInfo registDetailInfo = null;
		try {
			if (isEmpty(registNo)) {
				throw new Exception("�����Ų���Ϊ��");
			}
			BLRegistFacade bLRegistFacade = new BLRegistFacade();
			RegistDto registDto = bLRegistFacade.findByPrimaryKey(registNo);
			PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
			if(prpLregistDto==null) {
				throw new Exception("��������Ϣ��Ч��������");
			}
			registDetailInfo = new RegistDetailInfo();
			String damageAbstract = "";
			String damageTime = "";
			String driverName = "";
			String driverPhone = "";
			String indemnityDuty = "";
			String handleUnit = "";
			String woundRemark = "";
			String lossType = "";
			int perilCount = 0;
			
			//��ȡ����ժҪ
			if(registDto.getPrpLregistTextDtoList() != null){
		        Iterator<?> iterator = registDto.getPrpLregistTextDtoList().iterator();
		        while(iterator.hasNext()){
		          PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto)iterator.next();
		          if(StringUtils.rightTrim(prpLregistTextDtoTemp.getTextType()).equals("1"))
		          {
		        	  damageAbstract+=prpLregistTextDtoTemp.getContext();
		          }
		        }
		      } 
			//
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
			damageTime = dateFormat.format(prpLregistDto.getDamageStartDate().getTime())+prpLregistDto.getDamageStartHour();
			//��ȡ��ʻԱ��Ϣ
			if(registDto.getPrpLdriverDtoList() != null) {
				PrpLdriverDto prpLdriverDto = (PrpLdriverDto)registDto.getPrpLdriverDtoList().get(0);
				driverName = prpLdriverDto.getDriverName();
				driverPhone = prpLdriverDto.getDriverSeaRoute();
			}
			//��ȡ��������
			if(registDto.getPrpLpersonTraceDtoList()!=null) {
				for(Iterator<?> it=registDto.getPrpLpersonTraceDtoList().iterator();it.hasNext();) {
					PrpLpersonTraceDto prpLpersonTraceDto = (PrpLpersonTraceDto)it.next();
					woundRemark += prpLpersonTraceDto.getWoundRemark()+" ";
				}
			}
			
			PrpLextDto prpLextDto = registDto.getPrpLextDto();                    
			if (prpLextDto != null&&!isEmpty(prpLextDto.getFlag())) {
				String[] strs = {"��","����","����","����","������","������"};
				for (String index : prpLextDto.getFlag().split(",")) {
					lossType += strs[Integer.parseInt(index)] + ",";
				}
				lossType = lossType.substring(0,lossType.length()-1);
			} 
			
			//��ȡ���մ���
			Collection<?> registList = new UIRegistAction().findSamePolicyRegist(prpLregistDto.getPolicyNo());
			
			if(!isEmpty(registList)) {
				perilCount = registList.size();
			}
			
			UICodeAction uICodeAction = new UICodeAction();
			handleUnit = uICodeAction.translateCodeCode("HandleUnit", prpLregistDto.getHandleUnit(), true);
			
			registDetailInfo.setDamageAbstract(damageAbstract);
			registDetailInfo.setDamageAddress(prpLregistDto.getDamageAddress());
			registDetailInfo.setDamageAreaCode(prpLregistDto.getDamageAreaCode());
			registDetailInfo.setDamageAreaName(prpLregistDto.getDamageAreaName());
			registDetailInfo.setDamageCode(prpLregistDto.getDamageCode());
			registDetailInfo.setDamageName(prpLregistDto.getDamageName());
			registDetailInfo.setDamageTime(damageTime);
			registDetailInfo.setDamageTypeCode(prpLregistDto.getDamageTypeCode());
			registDetailInfo.setDamageTypeName(prpLregistDto.getDamageTypeName());
			registDetailInfo.setDriverName(driverName);
			registDetailInfo.setDriverPhone(driverPhone);
			registDetailInfo.setHandleUnit(handleUnit);
			registDetailInfo.setIndemnityDuty(prpLregistDto.getIndemnityDuty());//
			registDetailInfo.setLicenseNo(prpLregistDto.getLicenseNo());
			registDetailInfo.setLossType(lossType);//
			registDetailInfo.setPerilCount(perilCount);
			registDetailInfo.setPhoneNumber(prpLregistDto.getPhoneNumber());
			registDetailInfo.setRegistNo(prpLregistDto.getRegistNo());
			registDetailInfo.setReportorName(prpLregistDto.getReportorName());
			registDetailInfo.setWoundRemark(woundRemark);
			
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}

		return registDetailInfo;
	}
	
	/**
	 * 	���ݽ�����ͨ���������б������ı����ţ���ȡ�ͻ��绰���룬���������˵绰���롢��ʻԱ�绰����ȡ�
	 * @param  registNo����������
	 * @return �������ػ���null
	 * @throws SOAPException
	 */
	public CustomerNumber getCustomerNumber(String registNo) throws SOAPException {//Update daice
		CustomerNumber customerNumber = null;
		try {
			if (isEmpty(registNo)) {
				throw new Exception("�����Ų���Ϊ�ա�����");
			}
			// ����ҵ�񡣡�������
			BLRegistFacade bLRegistFacade = new BLRegistFacade();
			RegistDto registDto = bLRegistFacade.findByPrimaryKey(registNo);
			PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
			if(prpLregistDto==null) {
				throw new Exception("��������Ϣ��Ч��������");
			}
			customerNumber = new CustomerNumber();
			String driverPhone = "";
			String driverName = "";
			String customerPhone = "";
			String customerName = "";
			//��ȡ��ʻԱ��Ϣ
			if(registDto.getPrpLdriverDtoList() != null) {
				PrpLdriverDto prpLdriverDto = (PrpLdriverDto)registDto.getPrpLdriverDtoList().get(0);
				driverPhone = prpLdriverDto.getDriverSeaRoute();
				driverName = prpLdriverDto.getDriverName();
			}

			//��ȡ����������Ϣ
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(prpLregistDto.getPolicyNo(), registDto.getPrpLregistDto().getDamageStartDate().toString(), registDto.getPrpLregistDto()
					.getDamageStartHour());
			if(!isEmpty(policyDto.getPrpCinsuredDtoList())) {
				List<PrpCinsuredDto> prpCinsuredDtoList = policyDto.getPrpCinsuredDtoList();
				for(PrpCinsuredDto prpCinsuredDto:prpCinsuredDtoList) {
					if("1".equals(prpCinsuredDto.getInsuredFlag())) {
						customerPhone = prpCinsuredDto.getPhoneNumber();
						customerName = prpCinsuredDto.getInsuredName();
						if(isEmpty(customerPhone)) {
							customerPhone = prpCinsuredDto.getMobile();
						}
						break;
					}
				}
			}
		
			customerNumber.setCustomerPhone(customerPhone);
			customerNumber.setCustomerName(customerName);
			customerNumber.setDriverPhone(driverPhone);
			customerNumber.setDriverName(driverName);
			customerNumber.setReportorPhone(prpLregistDto.getPhoneNumber());
			customerNumber.setReportName(prpLregistDto.getReportorName());
			

		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return customerNumber;

	}
	
	/**
	 * ���ݽ���������ǰ����洫������Ա���š���������Ϣ����������Ϣ�е�����״̬���Ϊ������״̬��
	 * @param userNo����Ա����
	 * @param registNo����������
	 * @return �Ƿ�ɹ��ı�־��
	 * @throws SOAPException 
	 */
	public boolean acceptTaskSubmit(String userNo, String registNo) throws SOAPException {
		boolean flag = false;
		try {
			if (isEmpty(registNo)||isEmpty(userNo)) {
				throw new Exception("����������Ϊ�ա�������");
			}

			BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
			String condition = " registNo = '"+registNo+"' and nodetype = 'check' and flowStatus!='0'";
			Collection<SwfLogDto> swfList = bLSwfLogFacade.findByConditions(condition);
			if(!isEmpty(swfList)) {
				SwfLogDto swfLogDto = swfList.iterator().next();
				if(!"2".equals(swfLogDto.getNodeStatus())&&(isEmpty(swfLogDto.getHandlerCode())||swfLogDto.getHandlerCode().equals(userNo))) {//�ڵ㲻�������� �Ҹýڵ㴦����Ϊ�պ͸ò���Ա
					swfLogDto.setNodeStatus("2");
					swfLogDto.setHandleTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND ).toString());
					if(isEmpty(swfLogDto.getHandlerCode())) {
						swfLogDto.setHandlerCode(userNo);
						swfLogDto.setHandlerName(new UICodeAction().translateUserCode(userNo, true));
					}
					bLSwfLogFacade.update(swfLogDto);
					flag = true;
				} else {
					throw new Exception("����Ȩ����ð���������"); 
				}
				
			} 
			

		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}

		return flag;
		
	}
	
	/**
	 * ����ǰ����洫�����ı�������Ϣ����������Ϣ�е�����״̬���Ϊ���״̬��
	 * @param registNo����������
	 * @return
	 * @throws SOAPException 
	 */
	public boolean completeTaskSubmit(String registNo,String userCode) throws SOAPException {
		
		boolean flag = false;
		try {
			if (isEmpty(registNo) || isEmpty(userCode)) {
				throw new Exception("��������Ϊ�ա�������");
			}
			BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
			String condition = " registNo='"+registNo+"' and nodetype = 'check' and flowStatus!='0'";
			Collection<SwfLogDto> swfList = bLSwfLogFacade.findByConditions(condition);
			if (!isEmpty(swfList)) {
				SwfLogDto swfLogDto = swfList.iterator().next();
				if (!"4".equals(swfLogDto.getNodeStatus()) &&(isEmpty(swfLogDto.getHandlerCode())||swfLogDto.getHandlerCode().equals(userCode))) {// ����Ա������Ϊ���������״̬
					BLPrpLcheckFacade blPrpLcheckFacade = new BLPrpLcheckFacade();
					PrpLcheckDto prpLcheckDto = blPrpLcheckFacade.findByPrimaryKey(registNo, 1);
					PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
					prpLclaimStatusDto.setStatus("4");
					prpLclaimStatusDto.setBusinessNo(prpLcheckDto.getRegistNo() );
			        prpLclaimStatusDto.setPolicyNo(prpLcheckDto.getPolicyNo());
			        prpLclaimStatusDto.setNodeType("check");
			        prpLclaimStatusDto.setSerialNo(0);
			        prpLclaimStatusDto.setRiskCode(prpLcheckDto.getRiskCode());
			        //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���鿱��
			        prpLclaimStatusDto.setHandlerCode(userCode);
			        //prpLclaimStatusDto.setHandlerCode(prpLcheckDto.getOperatorCode() );
			        prpLclaimStatusDto.setInputDate(prpLcheckDto.getCheckDate() );
			        prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
			        BLPrpLclaimStatusFacade blPrpLclaimStatusFacade = new BLPrpLclaimStatusFacade();
			        blPrpLclaimStatusFacade.delete(prpLcheckDto.getRegistNo(), "check", 0);
			        blPrpLclaimStatusFacade.insert(prpLclaimStatusDto);
			        String riskType = new UICodeAction().translateRiskCodetoRiskType(prpLcheckDto.getRiskCode());
			        //�鿱ʱ��¼�����߳������ˡ��Ʋ���Ϣʱ��������Ӧ�ĵ�����Ϣ
			        PrpLscheduleItemDto prpLscheduleItemDto = null;
			        ArrayList scheduleItemDtoList = new ArrayList(); 
			        String conditions = " registNo = '" + registNo + "' order by serialNo";
			        String conditions1 = " registNo = '"+registNo+"' order by personNo";
			        String conditions2 = " registNo = '" + registNo + "'";
			        BLPrpLthirdPartyFacade blPrpLthirdPartyFacade = new BLPrpLthirdPartyFacade();
			        BLPrpLthirdPropFacade blPrpLthirdPropFacade = new BLPrpLthirdPropFacade();
			        BLPrpLpersonTraceFacade blPrpLpersonTraceFacade = new BLPrpLpersonTraceFacade();
			        ArrayList prpLthirdPartyDtoList = (ArrayList)blPrpLthirdPartyFacade.findByConditions(conditions);
			        if(prpLthirdPartyDtoList.size() > 0){
			        	for(int i = 0;i < prpLthirdPartyDtoList.size();i++){
			        		PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)prpLthirdPartyDtoList.get(i);
					        prpLscheduleItemDto = new PrpLscheduleItemDto();
					        prpLscheduleItemDto.setScheduleID         (1);
					        prpLscheduleItemDto.setRegistNo           (prpLthirdPartyDto.getRegistNo());
					        prpLscheduleItemDto.setItemNo             (prpLthirdPartyDto.getSerialNo());
					        prpLscheduleItemDto.setInsureCarFlag      (prpLthirdPartyDto.getInsureCarFlag() );
					        //��ʾ�Ƿ�ѡ��
					        prpLscheduleItemDto.setSelectSend         ("1");
					        //��ʾû�е��ȳɶ����
					        prpLscheduleItemDto.setSurveyTimes        (0);
					        prpLscheduleItemDto.setSurveyType         ("1");
					        prpLscheduleItemDto.setCheckSite          (prpLcheckDto.getCheckSite());
					        prpLscheduleItemDto.setLicenseNo          (prpLthirdPartyDto.getLicenseNo() );
					        prpLscheduleItemDto.setScheduleObjectID   ("_");
					        prpLscheduleItemDto.setScheduleObjectName (" ");
					        prpLscheduleItemDto.setInputDate          (new DateTime(DateTime.current().toString() ,DateTime.YEAR_TO_DAY ));
					        prpLscheduleItemDto.setScheduleType       ("schel");
					        prpLscheduleItemDto.setNextNodeNo("certa");
					        
						    scheduleItemDtoList.add(prpLscheduleItemDto);
			        	}
			        }
			        ArrayList prpLthirdPropDtoList = (ArrayList)blPrpLthirdPropFacade.findByConditions(conditions);
					if(prpLthirdPropDtoList.size() > 0){
						 prpLscheduleItemDto = new PrpLscheduleItemDto();
				         prpLscheduleItemDto.setScheduleID(1);
				         prpLscheduleItemDto.setRegistNo(prpLcheckDto.getRegistNo());
				         prpLscheduleItemDto.setItemNo(-1);
				         //��ʾ�Ƿ�ѡ��
				         prpLscheduleItemDto.setSelectSend("1");
				         //��ʾû�е��ȳɶ����
				         prpLscheduleItemDto.setSurveyTimes(0);
				         prpLscheduleItemDto.setSurveyType("1");
				         prpLscheduleItemDto.setCheckSite(prpLcheckDto.getCheckSite() );
				         prpLscheduleItemDto.setInputDate(new DateTime(DateTime.current(),
				             DateTime.YEAR_TO_DAY));
				         prpLscheduleItemDto.setScheduleType("schel");
				         prpLscheduleItemDto.setLicenseNo("�Ʋ���ʧ");
				         prpLscheduleItemDto.setScheduleObjectID("_");
				         prpLscheduleItemDto.setScheduleObjectName(" ");
				         prpLscheduleItemDto.setNextNodeNo("propc");
				         scheduleItemDtoList.add(prpLscheduleItemDto);
					}
					ArrayList prpLpersonTraceDtoList = (ArrayList)blPrpLpersonTraceFacade.findByConditions(conditions1);
					if(prpLpersonTraceDtoList.size() > 0){
						prpLscheduleItemDto = new PrpLscheduleItemDto();
			            prpLscheduleItemDto.setScheduleID(1);
			            prpLscheduleItemDto.setRegistNo(prpLcheckDto.getRegistNo());
			            prpLscheduleItemDto.setItemNo(0);
			            //��ʾ�Ƿ�ѡ��
			            prpLscheduleItemDto.setSelectSend("1");
			            //��ʾû�е��ȳɶ����
			            prpLscheduleItemDto.setSurveyTimes(0);
			            prpLscheduleItemDto.setSurveyType("1");
			            prpLscheduleItemDto.setCheckSite(prpLcheckDto.getCheckSite() );
			            prpLscheduleItemDto.setInputDate(new DateTime(DateTime.current(),
			                DateTime.YEAR_TO_DAY));
			            prpLscheduleItemDto.setScheduleType("schel");
			            prpLscheduleItemDto.setLicenseNo("����");
			            prpLscheduleItemDto.setScheduleObjectID("_");
			            prpLscheduleItemDto.setScheduleObjectName(" ");
			            prpLscheduleItemDto.setNextNodeNo("wound");
			            scheduleItemDtoList.add(prpLscheduleItemDto);
					}
					BLPrpLscheduleItemFacade blPrpLscheduleItemFacade = new BLPrpLscheduleItemFacade();
					ArrayList prpLscheduleItemDtoList = (ArrayList)blPrpLscheduleItemFacade.findByConditions(conditions2);
					for(int y = 0;y < scheduleItemDtoList.size();y++){
						boolean isTrue = true;
						prpLscheduleItemDto = (PrpLscheduleItemDto)scheduleItemDtoList.get(y);
						if(prpLscheduleItemDtoList.size() > 0){
							for(int x = 0;x < prpLscheduleItemDtoList.size();x++){
								PrpLscheduleItemDto prpLscheduleItemDto1 = (PrpLscheduleItemDto)prpLscheduleItemDtoList.get(x);
								if(prpLscheduleItemDto.getRegistNo().equals(prpLscheduleItemDto1.getRegistNo()) &&
										prpLscheduleItemDto.getItemNo() == prpLscheduleItemDto1.getItemNo()){
									isTrue = false;
									break;
								}
							}
						}
						if(isTrue){
							blPrpLscheduleItemFacade.insert(prpLscheduleItemDto);
						}
					}
					String checkNo = prpLcheckDto.getRegistNo();
					String userNo = userCode;
					BLPrpDuserFacade blPrpDuserFacade = new BLPrpDuserFacade();
					com.sinosoft.platform.dto.domain.PrpDuserDto prpDuserDto = (com.sinosoft.platform.dto.domain.PrpDuserDto)blPrpDuserFacade.findByPrimaryKey(userCode);
					UserDto user  = new UserDto();
					user.setUserCode(prpDuserDto.getUserCode());
					user.setUserName(prpDuserDto.getUserName());
					user.setComCode(prpDuserDto.getComCode());
					user.setComName(prpDuserDto.getComName());
					String comCode=user.getComCode() ;
					String riskCode = prpLcheckDto.getRiskCode();
				    String activeSchedule = "0"; //֪ͨ���ȣ�ʹ���ȹ�������ɴ�����״̬
				    String registno =  registNo;
				    String autoScheduleFlag = "1";//�Զ����ȱ�־
					String swfLogFlowID = swfLogDto.getFlowID(); //����������
					String swfLogLogNo = String.valueOf(swfLogDto.getLogNo()); //������logno
					//�������ڵ㴦��
					WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
					SwfLogDto swfLogDtoDealNode = new SwfLogDto();
					if (swfLogFlowID!=null && swfLogLogNo!=null){
						swfLogDtoDealNode.setFlowID(swfLogFlowID);
						swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
					} else {
						swfLogDtoDealNode.setNodeType("check");
						swfLogDtoDealNode.setBusinessNo(prpLcheckDto.getRegistNo());
					}
					swfLogDtoDealNode.setNodeStatus(prpLclaimStatusDto.getStatus());
					swfLogDtoDealNode.setNextBusinessNo(prpLcheckDto.getRegistNo());
					WorkFlowDto workFlowDto = null;
					
					//swfLogDtoDealNode.setKeyIn(checkDto.getPrpLcheckDto().getRegistNo());
					swfLogDtoDealNode.setKeyOut(checkNo);
					//�ط��ǲ鿱�ύ�����Ļط�,û��typeflag��ֵ,1��ʾ�鿱�طã�2��ʾ����ط�
					swfLogDtoDealNode.setTypeFlag("1");
					swfLogDtoDealNode.setKeyIn(prpLcheckDto.getRegistNo());	
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
			                 			String strSql=" registno='"+prpLcheckDto.getRegistNo()+"' and surveyTimes<1";
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
			           	                    if (scheduleItemDtoList==null || scheduleItemDtoList.size()==0){
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
										throw new Exception("������:" + checkNo
												+ ";ע��:û�з����빤������������κ����ݣ���");
									}
							    }
								if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate()) ||(workFlowDto.getSubmit())||(workFlowDto.getClose()))
								{ 
									uiScheduleAction.save(scheduleDto, workFlowDto);
								} else {
									throw new Exception(checkNo+";ע��:û�з����빤������������κ����ݣ���");
								}
							}				
						}   
			           
					flag = true;
				} else {
					throw new Exception("����Ȩ����ð���������");
				}
			} 
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}

		return flag;
		
	}
	
	/**
	 * ����˵���� ͨ���������б������ı����ţ���ȡ���������Ϣ�����������š������š��ѳ��մ���������ʱ�䡢���յص㡢���ƺ��롢��ϵ�ˡ���ϵ�˵�ַ����ϵ�绰����ϵ���ʱ�ȡ�
	 * @param registNo����������
	 * @return
	 * @throws SOAPException 
	 */
	public SurveyViewInfo getSurveyInfo(String registNo,String userNo) throws SOAPException {
		SurveyViewInfo surveyViewInfo = null;
		try {
			if (isEmpty(registNo) || isEmpty(userNo)) {
				throw new Exception("�����б���Ϊ�ա�����");
			}
			BLRegistFacade bLRegistFacade = new BLRegistFacade();
			RegistDto registDto = bLRegistFacade.findByPrimaryKey(registNo);
			PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
			if(prpLregistDto==null) {
				throw new Exception("��������Ϣ��Ч��������");
			}
			surveyViewInfo = new SurveyViewInfo();
			String damageTime = "";
			int perilCount = 0;
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
			damageTime = dateFormat.format(prpLregistDto.getDamageStartDate().getTime())+prpLregistDto.getDamageStartHour();
			Collection<?> registList = new UIRegistAction().findSamePolicyRegist(prpLregistDto.getPolicyNo());
			
			if(!isEmpty(registList)) {
				perilCount = registList.size();
			}
			String policyNo = prpLregistDto.getPolicyNo();
			String LinkPolicyNo = "";
			String riskCode = prpLregistDto.getRiskCode();
			BLPrpCmainSub blPrpCmainSub = new BLPrpCmainSub();
			if("0506".equals(riskCode) || "0586".equals(riskCode) || "0576".equals(riskCode)){
				String conditions = " policyNo = '" + policyNo + "'";
				blPrpCmainSub.query(conditions);
				if(blPrpCmainSub.getSize() > 0){
					LinkPolicyNo = blPrpCmainSub.getArr(0).getMainPolicyNo();
				}
			}else{
				String conditions = " mainPolicyNo = '" + policyNo + "'";
				blPrpCmainSub.query(conditions);
				if(blPrpCmainSub.getSize() > 0){
					LinkPolicyNo = blPrpCmainSub.getArr(0).getPolicyNo();
				}
			}
			if(!isEmpty(LinkPolicyNo)){
				policyNo += "," + LinkPolicyNo;
			}
			UICodeAction uiCodeAction = new UICodeAction();
			String checkUserName = uiCodeAction.translateUserCode(userNo, true);
			//��ʻԱ��Ϣ
			BLPrpLdriverFacade blPrpLdriverFacade = new BLPrpLdriverFacade();
			PrpLdriverDto prpLdriverDto = blPrpLdriverFacade.findByPrimaryKey(registNo, 0);
			//�鿱����
			BLPrpLregistTextFacade blPrpLregistTextFacade = new BLPrpLregistTextFacade();
			String conditions = "registNo = '" + registNo +"' and textType = '3' order by lineNo" ;
			ArrayList prpLregistTextDtoList = (ArrayList)blPrpLregistTextFacade.findByConditions(conditions);
			String checkReport = "";
			for(int index = 0; index < prpLregistTextDtoList.size();index++){
				PrpLregistTextDto prpLregistTextDto = (PrpLregistTextDto)prpLregistTextDtoList.get(index);
				checkReport += prpLregistTextDto.getContext();
			}
			surveyViewInfo.setDamageAddress(prpLregistDto.getDamageAddress());
			surveyViewInfo.setDamageTime(damageTime);//
			surveyViewInfo.setLicenseNo(prpLregistDto.getLicenseNo());
			surveyViewInfo.setLinkerAddress(prpLregistDto.getInsuredAddress());
			surveyViewInfo.setLinkerName(prpLregistDto.getLinkerName());
			surveyViewInfo.setLinkerPhone(prpLregistDto.getPhoneNumber());
			surveyViewInfo.setLinkerPostCode(prpLregistDto.getLinkerPostCode());
			surveyViewInfo.setPerilCount(perilCount);
			surveyViewInfo.setPolicyNo(policyNo);
			surveyViewInfo.setRegistNo(prpLregistDto.getRegistNo());
			surveyViewInfo.setFirstSiteFlag(prpLregistDto.getFirstSiteFlag());
			surveyViewInfo.setDamageCode(prpLregistDto.getDamageCode());
			surveyViewInfo.setIndemnityDuty(prpLregistDto.getIndemnityDuty());
			surveyViewInfo.setDamageAreaCode(prpLregistDto.getDamageAreaCode());
			surveyViewInfo.setClaimType(prpLregistDto.getClaimType());
			surveyViewInfo.setCheckUserName(checkUserName);
			surveyViewInfo.setDriverName(prpLdriverDto.getDriverName());
			surveyViewInfo.setDriverPhone(prpLdriverDto.getDriverSeaRoute());
			surveyViewInfo.setCertTypeCode(prpLdriverDto.getIdentifyType());
			surveyViewInfo.setCertNo(prpLdriverDto.getIdentifyNumber());
			surveyViewInfo.setSurveyReport(checkReport);
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return surveyViewInfo;
	}
	
	/**
	 * ������ĵ���Ϣ����ʱ�ύ�����ݿ��еĲ鿱��¼������������Ϣ�е�����״̬���Ϊ�ݴ�״̬��
	 *@param policyNo����������             
	*@param registNo����������
	*@param damageStartDate������������ 
	*@param damageStartHour��������ʱ��
	*@param damageAddress�������յص�
	*@param checkDate�����鿱����
	*@param checkStartHour�����鿱ʱ��
	*@param checkSite�����鿱�ص�
	*@param firstSiteFlag�����Ƿ��һ�ֳ�
	*@param checkType�����鿱����
	*@param check1�����鿱��1
	*@param check2�����鿱��2
	*@param damageCode��������ԭ���
	*@param damageTypeCode�����¹�ԭ��� 
	*@param indemnityDuty�����¹�����
	*@param damageAreaCode�������������
	*@param claimType�����ⰸ���
	*@param remark������ע
	 * @return �Ƿ��ύ�ɹ�
	 * @throws SOAPException
	 */
	public boolean surveyInfoSubmit(String policyNo, String registNo, String damageStartDate, String damageStartHour, String damageAddress, String checkDate, String checkStartHour, String checkSite, String firstSiteFlag, String checkType, String check1, String check2, String damageCode, String damageTypeCode, String indemnityDuty, String damageAreaCode, String claimType, String remark, String driverName, String driverPhone, String certTypeCode, String certNo,String surveyReport) throws SOAPException {
		boolean flag = false;
		try {
			if (isEmpty(policyNo) || isEmpty(registNo) || isEmpty(damageAddress) || isEmpty(checkDate) || isEmpty(checkStartHour)
					|| isEmpty(checkSite) || isEmpty(firstSiteFlag) || isEmpty(checkType) || (isEmpty(check1)&&isEmpty(check2)) || isEmpty(damageCode) || isEmpty(damageTypeCode)
					|| isEmpty(indemnityDuty) || isEmpty(damageAreaCode) || isEmpty(claimType)
					|| isEmpty(driverName)|| isEmpty(certTypeCode) || isEmpty(certNo) || isEmpty(surveyReport)) {
				throw new Exception("����������Ϊ�ա�������");
			}
			PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
			UICodeAction uICodeAction = new UICodeAction();
			BLPrpLcheckFacade bLPrpLcheckFacade = new BLPrpLcheckFacade();
			prpLcheckDto.setPolicyNo(policyNo);           
			prpLcheckDto.setRegistNo(registNo);
			prpLcheckDto.setRiskCode(policyNo.substring(1, 5));
			prpLcheckDto.setDamageStartDate(new DateTime(damageStartDate));
			prpLcheckDto.setDamageStartHour(damageStartHour);
			prpLcheckDto.setDamageAddress(damageAddress);
			prpLcheckDto.setCheckDate(new DateTime(checkDate));
//			prpLcheckDto.setCheckStartHour(checkStartHour);  //���в����ڸ��ֶΡ�
			prpLcheckDto.setRepeatInsureFlag("N");//��ȷ����ʱ����ΪN
			prpLcheckDto.setReferSerialNo(1);//������Ϊ1
			prpLcheckDto.setCheckSite(checkSite);
			prpLcheckDto.setFirstSiteFlag(firstSiteFlag);
			prpLcheckDto.setCheckType(checkType);
			prpLcheckDto.setChecker1(check1);
			prpLcheckDto.setChecker2(check2);
			prpLcheckDto.setDamageCode(damageCode);
			prpLcheckDto.setDamageName(uICodeAction.translateCodeCode(UICodeAction.DAMAGECODE,damageCode,true));
			prpLcheckDto.setDamageTypeCode(damageTypeCode);
			prpLcheckDto.setDamageTypeName(uICodeAction.translateCodeCode(UICodeAction.DAMAGETYPECODE,damageTypeCode,true));
			prpLcheckDto.setIndemnityDuty(indemnityDuty);
			prpLcheckDto.setDamageAreaCode(damageAreaCode);
			prpLcheckDto.setDamageAreaName(uICodeAction.translateCodeCode(UICodeAction.DAMAGEAREACODE, damageAreaCode, true));
			prpLcheckDto.setClaimType(claimType);
			prpLcheckDto.setRemark(remark);
			
			if(bLPrpLcheckFacade.findByPrimaryKey(registNo, 1)==null) {//��������������͸���
				bLPrpLcheckFacade.insert(prpLcheckDto);
			} else {
				bLPrpLcheckFacade.update(prpLcheckDto);
			}
			//��ʻԱ��Ϣ
			String conditions = "policyNo = '" + policyNo + "'";
			String licenseNo = "";
			BLPrpCitemCar blPrpCitemCar = new BLPrpCitemCar();
			blPrpCitemCar.query(conditions);
			if(blPrpCitemCar.getSize() > 0){
				licenseNo = blPrpCitemCar.getArr(0).getLicenseNo();
			}
			BLPrpLdriverFacade blPrpLdriverFacade = new BLPrpLdriverFacade();
			PrpLdriverDto prpLdriverDto = new PrpLdriverDto();
			prpLdriverDto.setRegistNo(registNo);
			prpLdriverDto.setClaimNo(uICodeAction.translateBusinessCode(registNo, true));
			prpLdriverDto.setRiskCode(prpLcheckDto.getRiskCode());
			prpLdriverDto.setPolicyNo(policyNo);
			prpLdriverDto.setSerialNo(0);
			prpLdriverDto.setDriverName(driverName);
			prpLdriverDto.setDriverSeaRoute(driverPhone);
			//add by zhaolu 20060817 start
			//reason��Ӽ�ʻԱ֤����
			prpLdriverDto.setDrivingLicenseNo(licenseNo);
			prpLdriverDto.setIdentifyType(certTypeCode);
			prpLdriverDto.setIdentifyNumber(certNo);
			blPrpLdriverFacade.delete(registNo, 0);
			blPrpLdriverFacade.insert(prpLdriverDto);
			//�鿱����
			BLPrpLregistTextFacade blPrpLregistTextFacade = new BLPrpLregistTextFacade();
			ArrayList prpLregistTextDtoList = new ArrayList();
			PrpLregistTextDto prpLregistTextDto;
			String conditions1 = "registNo = '" + registNo +"' and textType = '3' " ;
			String[] rules = StringUtils.split(surveyReport,70);
	        for(int k=0;k<rules.length;k++){
	          prpLregistTextDto = new PrpLregistTextDto();
	          prpLregistTextDto.setRegistNo(registNo);
	          prpLregistTextDto.setContext(rules[k]);
	          prpLregistTextDto.setLineNo(k+1);
	          prpLregistTextDto.setTextType("3");
	          prpLregistTextDtoList.add(prpLregistTextDto);
	        }
	        blPrpLregistTextFacade.deleteByConditions(conditions1);
	        for(int index = 0; index < prpLregistTextDtoList.size();index++){
	        	prpLregistTextDto = (PrpLregistTextDto)prpLregistTextDtoList.get(index);
	        	blPrpLregistTextFacade.insert(prpLregistTextDto);
	        }
			//�޸Ĺ�����
			BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
			String condition = " registNo='"+registNo+"' and nodetype = 'check' and flowStatus!='0'";
			Collection<SwfLogDto> swfList = bLSwfLogFacade.findByConditions(condition);
			if (!isEmpty(swfList)) {
				SwfLogDto swfLogDto = swfList.iterator().next();
				String nodeStatus = swfLogDto.getNodeStatus();
				if (nodeStatus.equals("0") || nodeStatus.equals("1") || nodeStatus.equals("2") || nodeStatus.equals("3")) {
					swfLogDto.setNodeStatus("2");
					// swfLogDto.setHandlerCode(user.getUserCode());
					// swfLogDto.setHandlerName(user.getUserName());
					if (isEmpty(swfLogDto.getKeyOut())) {
						swfLogDto.setKeyOut(registNo);
					}
					// swfLogDto.setLossItemCode();
					swfLogDto.setHandleTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
					bLSwfLogFacade.update(swfLogDto);
					
					BLPrpLcheckFacade blPrpLcheckFacade = new BLPrpLcheckFacade();
					PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
					prpLclaimStatusDto.setStatus("2");
					prpLclaimStatusDto.setBusinessNo(prpLcheckDto.getRegistNo() );
			        prpLclaimStatusDto.setPolicyNo(prpLcheckDto.getPolicyNo());
			        prpLclaimStatusDto.setNodeType("check");
			        prpLclaimStatusDto.setSerialNo(0);
			        prpLclaimStatusDto.setRiskCode(prpLcheckDto.getRiskCode());
			        //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ���鿱��
			        prpLclaimStatusDto.setHandlerCode(swfLogDto.getHandlerCode());
			        //prpLclaimStatusDto.setHandlerCode(prpLcheckDto.getOperatorCode() );
			        prpLclaimStatusDto.setInputDate(prpLcheckDto.getCheckDate() );
			        prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
			        BLPrpLclaimStatusFacade blPrpLclaimStatusFacade = new BLPrpLclaimStatusFacade();
			        blPrpLclaimStatusFacade.delete(prpLcheckDto.getRegistNo(), "check", 0);
			        blPrpLclaimStatusFacade.insert(prpLclaimStatusDto);
					flag = true;
				}

			}
			
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}

		return flag;
	}
	
	/**
	 * ����˵���� ���ݽ�����ͨ��ѡ��ͬ�Ķ�����˾���������ݹ�˾�����ò�ͬ������˾������
	 * 
	 * @param companyNo ��˾����
	 * @return
	 * @throws SOAPException 
	 */
	public CompanyInfo[] getComanyCode(String companyNo) throws SOAPException {//Update ����
		CompanyInfo[] companyInfoList = null;
		try {
			if (isEmpty(companyNo)) {
				throw new Exception("��˾���벻��Ϊ�ա�����");
			}
			// ����ҵ�񡣡�������
			String conditions = " uppercomcode = '"+companyNo+"' and validstatus= '1' and ( comCode not like '0000%' or comCode like '00000013%' ) order by comcode";
			BLPrpDcompanyFacade bLPrpDcompanyFacade = new BLPrpDcompanyFacade();
			Collection<PrpDcompanyDto> companyList = bLPrpDcompanyFacade.findByConditions(conditions);
			if(!isEmpty(companyList)) {
				companyInfoList = new CompanyInfo[companyList.size()];
				int i = 0;
				for(PrpDcompanyDto element:companyList) {
					companyInfoList[i++] = new CompanyInfo(element.getComCode(), element.getComCName());
				}
			}
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return companyInfoList;
	}
	
	/**
	 * ���ݽ�����ͨ��ѡ��ͬ�Ĺ�˾�����ݹ�˾�����ò�ͬ��˾��Ա���Ĵ��롢������
	 * @param companyNo������˾����
	 * @return
	 * @throws SOAPException 
	 */
	public UserInfo[] getStaffByComanyCode(String companyNo) throws SOAPException {//Update ��ɡ�
		UserInfo[] userInfoList = null;
		try {
			if (isEmpty(companyNo)) {
				throw new Exception("�������벻��Ϊ�ա���������");
			}

			UICodeAction uiCodeAction = new UICodeAction();
			String conditions = "  ValidStatus='1' " + " AND comCode in ( select ComCode from prpdCompany Start With ComCode = '" + companyNo + "' Connect By Prior comCode =  uppercomCode"
					+ " and prior comcode != comcode and validstatus='1')";
			Collection<PrpDuserDto> collection = uiCodeAction.findByConditions(UICodeAction.HANDERCODE, conditions, 0, 0);
			if (!isEmpty(collection)) {
				boolean checkPower = false;
				List<UserInfo> list = new ArrayList<UserInfo>();

				for (PrpDuserDto element : collection) {
					com.sinosoft.platform.dto.domain.PrpDuserDto platformPrpDuserDto = new com.sinosoft.platform.dto.domain.PrpDuserDto();
					BLPrpDcompany prpDcompany = new BLPrpDcompany();
					String upperComCode = prpDcompany.getCenterCode(element.getComCode());
					platformPrpDuserDto.setLoginComCode(upperComCode);
					platformPrpDuserDto.setUserCode(element.getUserCode());
					checkPower = UIPowerAction.checkPowerReturn(platformPrpDuserDto, Constants.TASK_CLAIM_CHECK);
					if (checkPower) {
						list.add(new UserInfo(element.getUserCode(), element.getUserName()));
					}
				}
				if(!isEmpty(list)) {
					userInfoList = list.toArray(new UserInfo[0]);
				}
			}

		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return userInfoList;
	}
	
	/**
	 * ����˵���� ͨ���������б������ı����ţ���ȡ�鿱Ա�ݴ������ݿ��е��ݴ����������Ϣ
	 * 
	 * @param registNo
	 *            ����������
	 * @return 
	 * @throws SOAPException
	 */
	public StoredCheckInfo getStoreInfo(String registNo) throws SOAPException {
		StoredCheckInfo storedCheckInfo = null;
		try {
			if (isEmpty(registNo)) {
				throw new Exception("�����Ų���Ϊ��");
			}
			// ����ҵ�񡣡�������
			BLPrpLcheckFacade bLPrpLcheckFacade = new BLPrpLcheckFacade();
			PrpLcheckDto prpLcheckDto = bLPrpLcheckFacade.findByPrimaryKey(registNo, 1);
			if(prpLcheckDto==null) {
				throw new Exception("��ѯ���ݲ����ڣ�");
			}
			storedCheckInfo = new StoredCheckInfo();
			String damageStartDate = "";
			String checkDate = "";
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			damageStartDate = dateFormat.format(prpLcheckDto.getDamageStartDate().getTime());
			checkDate = dateFormat.format(prpLcheckDto.getCheckDate().getTime());
			
			String policyNo = prpLcheckDto.getPolicyNo();
			String LinkPolicyNo = "";
			String riskCode = prpLcheckDto.getRiskCode();
			BLPrpCmainSub blPrpCmainSub = new BLPrpCmainSub();
			if("0506".equals(riskCode) || "0586".equals(riskCode) || "0576".equals(riskCode)){
				String conditions = " policyNo = '" + policyNo + "'";
				blPrpCmainSub.query(conditions);
				if(blPrpCmainSub.getSize() > 0){
					LinkPolicyNo = blPrpCmainSub.getArr(0).getMainPolicyNo();
				}
			}else{
				String conditions = " mainPolicyNo = '" + policyNo + "'";
				blPrpCmainSub.query(conditions);
				if(blPrpCmainSub.getSize() > 0){
					LinkPolicyNo = blPrpCmainSub.getArr(0).getPolicyNo();
				}
			}
			if(!isEmpty(LinkPolicyNo)){
				policyNo += "," + LinkPolicyNo;
			}
			//��ʻԱ��Ϣ
			BLPrpLdriverFacade blPrpLdriverFacade = new BLPrpLdriverFacade();
			PrpLdriverDto prpLdriverDto = blPrpLdriverFacade.findByPrimaryKey(registNo, 0);
			//�鿱����
			BLPrpLregistTextFacade blPrpLregistTextFacade = new BLPrpLregistTextFacade();
			String conditions = "registNo = '" + registNo +"' and textType = '3' order by lineNo" ;
			ArrayList prpLregistTextDtoList = (ArrayList)blPrpLregistTextFacade.findByConditions(conditions);
			String checkReport = "";
			for(int index = 0; index < prpLregistTextDtoList.size();index++){
				PrpLregistTextDto prpLregistTextDto = (PrpLregistTextDto)prpLregistTextDtoList.get(index);
				checkReport += prpLregistTextDto.getContext();
			}
			storedCheckInfo.setPolicyNo(policyNo);//������             
			storedCheckInfo.setRegistNo(prpLcheckDto.getRegistNo());//������
			storedCheckInfo.setDamageStartDate(damageStartDate);//�������� 
			storedCheckInfo.setDamageStartHour(prpLcheckDto.getDamageStartHour());//����ʱ��
			storedCheckInfo.setDamageAddress(prpLcheckDto.getDamageAddress());//���յص�
			storedCheckInfo.setCheckDate(checkDate);//�鿱����
			storedCheckInfo.setCheckStartHour("10");//�鿱ʱ��
			storedCheckInfo.setCheckSite(prpLcheckDto.getCheckSite());//�鿱�ص�
			storedCheckInfo.setFirstSiteFlag(prpLcheckDto.getFirstSiteFlag());//�Ƿ��һ�ֳ�
			storedCheckInfo.setCheckType(prpLcheckDto.getCheckType());//�鿱����
			storedCheckInfo.setChecker1(prpLcheckDto.getChecker1());//�鿱��1
			storedCheckInfo.setChecker2(prpLcheckDto.getChecker2());//�鿱��2
			storedCheckInfo.setDamageCode(prpLcheckDto.getDamageCode());//����ԭ���
			storedCheckInfo.setDamageTypeCode(prpLcheckDto.getDamageTypeCode());//�¹�ԭ��� 
			storedCheckInfo.setIndemnityDuty(prpLcheckDto.getIndemnityDuty());//�¹�����
			storedCheckInfo.setDamageAreaCode(prpLcheckDto.getDamageAreaCode());//���������
			storedCheckInfo.setClaimType(prpLcheckDto.getClaimType());//�ⰸ���
			storedCheckInfo.setRemark(prpLcheckDto.getRemark());//��ע
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(prpLcheckDto.getRegistNo());
			if(prpLregistDto != null){
				storedCheckInfo.setLicenseNo(prpLregistDto.getLicenseNo());
				storedCheckInfo.setLinkerName(prpLregistDto.getLinkerName());
				storedCheckInfo.setLinkerPhone(prpLregistDto.getPhoneNumber());
				storedCheckInfo.setLinkerAddress(prpLregistDto.getInsuredAddress());
				storedCheckInfo.setLinkerPostCode(prpLregistDto.getLinkerPostCode());
			}
			storedCheckInfo.setDriverName(prpLdriverDto.getDriverName());
			storedCheckInfo.setDriverPhone(prpLdriverDto.getDriverSeaRoute());
			storedCheckInfo.setCertTypeCode(prpLdriverDto.getIdentifyType());
			storedCheckInfo.setCertNo(prpLdriverDto.getIdentifyNumber());
			storedCheckInfo.setSurveyReport(checkReport);
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return storedCheckInfo;

	}
	
	/**
	 * ת�������޸�������Ϣ
	 * @param reassignUserNo ת����
	 * @param reassignCompanyNo ת��Ա��������˾����
	 * @param userNo Ա������
	 * @param CompanyNo Ա��������˾
	 * @param registNo ������
	 * @return
	 * @throws SOAPException 
	 */
	public boolean reassignTaskSubmit(String reassignUserNo, String reassignCompanyNo, String userNo, String CompanyNo, String registNo) throws SOAPException {
		boolean flag = false;
		try {
			if (isEmpty(reassignUserNo) || isEmpty(reassignCompanyNo) || isEmpty(userNo) || isEmpty(CompanyNo) || isEmpty(registNo)) {
				throw new Exception("�����б���Ϊ�ա�����");
			}
			// ����ҵ�񡣡�������
			BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
			String condition = " registNo='" + registNo + "' and nodetype = 'check' and flowStatus!='0'";
			Collection<SwfLogDto> swfList = bLSwfLogFacade.findByConditions(condition);
			if (!isEmpty(swfList)) {
				SwfLogDto swfLogDto = swfList.iterator().next();
				String nodeStatus = swfLogDto.getNodeStatus();
				if (nodeStatus.equals("0") || nodeStatus.equals("1") || nodeStatus.equals("2") || nodeStatus.equals("3")) {
					if (swfLogDto.getHandlerCode().equals(reassignUserNo)) {
						UICodeAction uiCodeAction = new UICodeAction();
						String userName = uiCodeAction.translateUserCode(userNo, true);
						swfLogDto.setHandleDept(CompanyNo);
						swfLogDto.setHandlerCode(userNo);
						swfLogDto.setHandlerName(userName);
						swfLogDto.setHandleTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
						bLSwfLogFacade.update(swfLogDto);// ���¹���������
						flag = true;
					}
					
				} else {
					throw new Exception("�ýڵ㴦�ڲ���ת��״̬��");
				}

			}

		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return flag;
	}
	
	
	/**
	 *����˵������File���ȡ�ļ���ת��Ϊ�ֽ����飬��base 64������Ϊһ���ַ������ڷ���˻�ȡ���ַ��������base 64������ֽ����飬Ȼ���ֽ�����д���ļ�������ڷ�������Ŀ¼�У�ͨ�������Ž���Ƭ�밸��������
	 * @param registNo����������
	 * @param vehicleID�������������
	 * @param collectorName������Ƭ�Ѽ���
	 * @param fileName�����ļ���
	 * @param image����base 64���루���ļ�ת��Ϊ�ֽ����飬Ȼ����룩
	 * @param imageType����ͼƬ�������
	 * @param description������Ƭ˵��
	 * @return
	 * @throws SOAPException
	 */
	public boolean uploadImage(String registNo, String vehicleID ,String collectorName,String fileName,String image,String imageType,String description) throws SOAPException {
		boolean flag = false;
		try {
			if (isEmpty(registNo) || isEmpty(fileName) || isEmpty(image) || isEmpty(imageType)) {
				throw new Exception("��ز�������Ϊ�ա�����");
			}
			// ����ҵ�񡣡�������
			// Base64����
			FtpClient ftp = null;
			BLPrpLcertifyImgFacade imgFacade = new BLPrpLcertifyImgFacade();
			BLPrpLregistFacade bLPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = bLPrpLregistFacade.findByPrimaryKey(registNo);
			BLPrpLthirdPartyFacade bLPrpLthirdPartyFacade = new BLPrpLthirdPartyFacade();
			String policyNo = prpLregistDto.getPolicyNo();
			String businessNo = registNo;
			String riskCode = prpLregistDto.getRiskCode();
			String nodeType = "certi";
			String lossItemName = null;
			String typeCode = null;
			String picName = null;
			String uploadYear = null;
			String remoteFileName = null;
			String fileExtName = null;
			String yearMonthDay = null;
			DateTime signInDate = null;
			String picPath = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			
			if("0".equals(vehicleID)) {//����������
				lossItemName = "claim";
			} else if("99".equals(vehicleID)){
				lossItemName = "��������";
			} else{//�����������
				lossItemName = bLPrpLthirdPartyFacade.findByPrimaryKey(registNo, Integer.parseInt(vehicleID)).getLicenseNo();
			}
			
			// ����jpegͼƬ
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] buffer = decoder.decodeBuffer(image);
			for (int i = 0; i < buffer.length; ++i) {
				if (buffer[i] < 0) {// �����쳣����
					buffer[i] += 256;
				}
			}

			Calendar c = Calendar.getInstance();
			uploadYear = String.valueOf(c.get(Calendar.YEAR));
			yearMonthDay = dateFormat.format(c.getTime());
			signInDate = new DateTime(DateTime.current().toString());
			int maxSerialNo = 0;
			int maxTypeCodeNo = 0;

			maxSerialNo = imgFacade.getCount("policyNo='" + policyNo + "' and businessNo='" + businessNo + "'")+1;
			String[] types = null;
			types = imageType.split("@@");
			typeCode = types[0];
			picName = types[1];
			maxTypeCodeNo = imgFacade.getCount("policyNo='" + policyNo + "' and businessNo='" + businessNo
					+ "' and typeCode='" + types[0] + "'")+1;
			PrpLcertifyImgDto prpLcertifyImgDto = new PrpLcertifyImgDto();

			fileName = fileName.replaceAll("\\\\", "/");
			int indexDisk = fileName.lastIndexOf("/");
			fileName = fileName.substring(indexDisk + 1);
			int indexExt = fileName.lastIndexOf(".");
			fileExtName = fileName.substring(indexExt + 1);
			remoteFileName = typeCode + "_" + maxTypeCodeNo + "." + fileExtName;
			picPath = "/" + uploadYear + "/" + yearMonthDay + "/" + riskCode + "/" + businessNo + "/" + typeCode
					+ vehicleID;
			
			String ftpUser = AppConfig.get("sysconst.FTP_USER");
			String ftpPass = AppConfig.get("sysconst.FTP_PASS");
			String ftpUrl  = AppConfig.get("sysconst.FTP_URL");
			String ftpDir  = AppConfig.get("sysconst.WRITEDIR");
			ftp = new FtpClient();
			ftp.open(ftpUrl);
			ftp.login(ftpUser, ftpPass);
			ftp.cd(ftpDir);
			ftp.setMode(FtpClient.BIN_MODE);
			ftp.mkdirs(picPath.substring(1));
			OutputStream out = ftp.getFileInputStream(ftp.pwd() + picPath + "/" + remoteFileName);
			out.write(buffer);
			out.flush();
			out.close();
			
			prpLcertifyImgDto.setPolicyNo(policyNo);
			prpLcertifyImgDto.setBusinessNo(businessNo);
			prpLcertifyImgDto.setSerialNo(maxSerialNo);
			prpLcertifyImgDto.setImgSize(buffer.length);
			prpLcertifyImgDto.setLossItemCode(vehicleID);
			prpLcertifyImgDto.setLossItemName(lossItemName);
			// prpLcertifyImgDto.setPicName(typeCode + maxTypeCodeNo);
			prpLcertifyImgDto.setCollectorName(collectorName);
			prpLcertifyImgDto.setUploadFileName(fileName);
			prpLcertifyImgDto.setDisplayName(description);
			prpLcertifyImgDto.setImgFileName(remoteFileName);
			prpLcertifyImgDto.setPicName(picName);
			prpLcertifyImgDto.setPicPath(picPath);
			prpLcertifyImgDto.setTypeCode(typeCode);
			prpLcertifyImgDto.setUploadNodeFlag(nodeType);
			prpLcertifyImgDto.setThirdPartyCode("11111111");
			prpLcertifyImgDto.setReceiveStatus("11");
			prpLcertifyImgDto.setFlag("1");
			prpLcertifyImgDto.setValidStatus("1");
			prpLcertifyImgDto.setSignInDate(signInDate);
			imgFacade.insert(prpLcertifyImgDto);
			
			BLPrpLcertifyDirectFacade blPrpLcertifyDirectFacade = new BLPrpLcertifyDirectFacade();
			String conditions = " registNo = '" + registNo + "'";
			int count = blPrpLcertifyDirectFacade.getCount(conditions);
			String conditions1 = " registNo = '" + registNo +"' and lossItemCode = '" + vehicleID + "' and typeCode = '" + typeCode + "'";
			ArrayList prpLcertifyDirectDtoList = (ArrayList)blPrpLcertifyDirectFacade.findByConditions(conditions1);
			PrpLcertifyDirectDto prpLcertifyDirectDto = new PrpLcertifyDirectDto();
			if(isEmpty(prpLcertifyDirectDtoList)){
				prpLcertifyDirectDto.setRegistNo(registNo);
				prpLcertifyDirectDto.setSerialNo(count + 1);
				prpLcertifyDirectDto.setRiskCode(prpLregistDto.getRiskCode());
				prpLcertifyDirectDto.setPolicyNo(prpLregistDto.getPolicyNo());
				if("99".equals(typeCode.substring(0, 2))){
					vehicleID = "0";
				}
				prpLcertifyDirectDto.setLossItemCode(vehicleID);
				prpLcertifyDirectDto.setTypeCode(typeCode);
				prpLcertifyDirectDto.setTypeName(picName);
				prpLcertifyDirectDto.setColumnValue("columevaue");
				prpLcertifyDirectDto.setCompelFlag("1");
				prpLcertifyDirectDto.setBusinessFlag("1");
				blPrpLcertifyDirectFacade.insert(prpLcertifyDirectDto);
			}
			
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
			throw new SOAPException(e.getMessage());
		}
		return flag;
	}
	
	/**
	 * 
	 * @param registNo
	 * @param vehicleID
	 * @param licensePlateMo
	 * @param frameNo
	 * @param vehicleType
	 * @param engineNo
	 * @param licensePlateBackground
	 * @param brandModel
	 * @param brandModelName
	 * @param insuranceCompany
	 * @param insuranceCompanyName
	 * @param vehiclesUsefulLife
	 * @param vehicleIdentificationNumber
	 * @param mileage
	 * @param liabilityProportion
	 * @param lossAmount
	 * @param injuredOrNot
	 * @param otherVehiclesDriverName
	 * @param otherVehiclesDriverIdNo
	 * @param policyNo
	 * @return
	 * @throws SOAPException
	 */
	public boolean vehiclesInfoSubmit(String registNo, String vehicleID, String licensePlateMo, String frameNo,
			String vehicleType, String engineNo, String licensePlateBackground, String brandModel,
			String brandModelName, String insuranceCompany, String insuranceCompanyName, String vehiclesUsefulLife,
			String vehicleIdentificationNumber, String mileage, String liabilityProportion, String lossAmount,
			String injuredOrNot, String otherVehiclesDriverName, String otherVehiclesDriverIdNo, String policyNo)
			throws SOAPException {

		boolean flag = false;
		try {
			if (isEmpty(registNo) || isEmpty(vehicleID)) {
				throw new Exception("�����б���Ϊ�ա�����");
			}
			BLPrpLthirdPartyFacade bLPrpLthirdPartyFacade = new BLPrpLthirdPartyFacade();
			UICodeAction uiCodeAction = new UICodeAction();
			String claimNo = uiCodeAction.translateBusinessCode(registNo, true);
			BLPrpLregistFacade bLPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = bLPrpLregistFacade.findByPrimaryKey(registNo);
			String riskCode = prpLregistDto.getRiskCode();
			
			PrpLthirdPartyDto prpLthirdPartyDto = new PrpLthirdPartyDto();
			prpLthirdPartyDto.setRegistNo(registNo);
			prpLthirdPartyDto.setRiskCode(riskCode);
			prpLthirdPartyDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(vehicleID)));
			prpLthirdPartyDto.setClaimNo(claimNo);
			prpLthirdPartyDto.setLicenseNo(licensePlateMo); //                                                                 
			prpLthirdPartyDto.setLicenseColorCode(licensePlateBackground); //                                                   
			prpLthirdPartyDto.setCarKindCode(vehicleType);//
			if ("1".equals(vehicleID)) {
				prpLthirdPartyDto.setInsureCarFlag("1"); // �Ǳ�ĳ�
				prpLthirdPartyDto.setLossFlag(injuredOrNot);
				prpLthirdPartyDto.setCarPolicyNo(prpLregistDto.getPolicyNo());
			} else {
				prpLthirdPartyDto.setInsureCarFlag("0"); // ��Ϊ��ĳ�
				prpLthirdPartyDto.setLossFlag("1");
				prpLthirdPartyDto.setPrpLthirdPartyDriveName(otherVehiclesDriverName); //                                             
				prpLthirdPartyDto.setPrpLthirdPartyDriveLicensNo(otherVehiclesDriverIdNo);//
				// ���߳�����������
				if (isEmpty(policyNo)) {// ������
					prpLthirdPartyDto.setCarPolicyNo("2111111111111111sssss");// Ĭ��Ϊ1
				} else {
					prpLthirdPartyDto.setCarPolicyNo(policyNo);//
				}
			}
			prpLthirdPartyDto.setEngineNo(engineNo);//                                                                   
			prpLthirdPartyDto.setFrameNo(frameNo); //                                                                   
			prpLthirdPartyDto.setBrandName(brandModelName);
			prpLthirdPartyDto.setModelCode(brandModel);// 
			prpLthirdPartyDto.setRunDistance(Double.parseDouble(DataUtils.nullToZero(mileage)));//                    
			prpLthirdPartyDto.setUseYears(Integer.parseInt(DataUtils.nullToZero(vehiclesUsefulLife)));//                            
			prpLthirdPartyDto.setDutyPercent(Double.parseDouble(DataUtils.nullToZero(liabilityProportion)));//                    
			prpLthirdPartyDto.setInsuredFlag("1"); // �Ƿ� ����
			prpLthirdPartyDto.setInsureComCode(insuranceCompany);
			prpLthirdPartyDto.setInsureComName(insuranceCompanyName);// 
			prpLthirdPartyDto.setVINNo(vehicleIdentificationNumber); //
			
			bLPrpLthirdPartyFacade.delete(registNo, Integer.parseInt(vehicleID));//��ɾ�ٲ�
			bLPrpLthirdPartyFacade.insert(prpLthirdPartyDto);
			
			BLPrpLcheckLossFacade blPrpLcheckLossFacade = new BLPrpLcheckLossFacade();
			String conditions = " registNo = '" + registNo + "' and lossFeeType = '1' order by serialNo ";
			String conditions1 = " registNo = '" + registNo + "'";
			ArrayList prpLcheckLossDtoList = (ArrayList)blPrpLcheckLossFacade.findByConditions(conditions);
			int countPrpLcheckLoss = blPrpLcheckLossFacade.getCount(conditions1);
			int count = prpLcheckLossDtoList.size();
			int serialNo = Integer.parseInt(vehicleID);
			int index = 0;
			if(count == 0 && countPrpLcheckLoss > 0){
				index = countPrpLcheckLoss + 1;
			}else{
				if(count < serialNo){
					index = countPrpLcheckLoss + 1;
				}else{
					index = ((PrpLcheckLossDto)prpLcheckLossDtoList.get(serialNo-1)).getSerialNo();
				}
			}
			PrpLcheckLossDto prpLcheckLossDto = new PrpLcheckLossDto();
			prpLcheckLossDto.setRegistNo(registNo);
			prpLcheckLossDto.setClaimNo(claimNo);
			prpLcheckLossDto.setRiskCode(riskCode);
			prpLcheckLossDto.setPolicyNo(prpLregistDto.getPolicyNo());
			prpLcheckLossDto.setSerialNo(index);
			prpLcheckLossDto.setReferSerialNo(index);
			prpLcheckLossDto.setKindCode("A");
			prpLcheckLossDto.setLossFeeType("1");
			prpLcheckLossDto.setLossFee(Double.parseDouble(DataUtils.nullToZero(lossAmount)));
			prpLcheckLossDto.setFlag("");
			blPrpLcheckLossFacade.delete(registNo, index);
			blPrpLcheckLossFacade.insert(prpLcheckLossDto);
			flag = true;
			
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return flag;
	}
	
	/**
	 * ��ȡ�鿱��¼�ݴ����ݣ�������ĳ������߳�����Ϣ��
	 * @param registNo
	 * @return
	 * @throws SOAPException
	 */
	public VehicleInfo[] getStoreVehiclesInfo(String registNo) throws SOAPException {
		
		VehicleInfo[] vehicleInfoList = null;
		try {
			if (isEmpty(registNo)) {
				throw new Exception("�����Ų���Ϊ�ա���������");
			}
			BLPrpLthirdPartyFacade bLPrpLthirdPartyFacade = new BLPrpLthirdPartyFacade();
			BLPrpLcheckLossFacade bLPrpLcheckLossFacade = new BLPrpLcheckLossFacade ();
			String conditions = " registNo='"+registNo+"' order by serialNo ";
			String conditions1 = " registNo='"+registNo+"' and lossFeeType = '1' order by serialNo ";
			ArrayList<PrpLthirdPartyDto> result = (ArrayList)bLPrpLthirdPartyFacade.findByConditions(conditions);
			ArrayList prpLcheckLossDtoList = (ArrayList)bLPrpLcheckLossFacade.findByConditions(conditions1);
			if (!isEmpty(result)) {// �����Ч�Ļ�
				vehicleInfoList = new VehicleInfo[result.size()];
				int index = 0;
				for (int i = 0; i < result.size();i++) {
					PrpLthirdPartyDto element =  result.get(i);
					VehicleInfo vehicleInfo =  new VehicleInfo();
					vehicleInfo.setBrandName(element.getBrandName());
					vehicleInfo.setCarKindCode(element.getCarKindCode());
					vehicleInfo.setCarPolicyNo(element.getCarPolicyNo());
					vehicleInfo.setDutyPercent(element.getDutyPercent());
					vehicleInfo.setEngineNo(element.getEngineNo());
					vehicleInfo.setFrameNo(element.getFrameNo());
					vehicleInfo.setInsureComCode(element.getInsureComCode());
					vehicleInfo.setInsureComName(element.getInsureComName());
					vehicleInfo.setLicenseColorCode(element.getLicenseColorCode());
					vehicleInfo.setLicenseNo(element.getLicenseNo());
					vehicleInfo.setLossFlag(element.getLossFlag());
					vehicleInfo.setModelCode(element.getModelCode());
					vehicleInfo.setPrpLthirdPartyDriveLicensNo(element.getPrpLthirdPartyDriveLicensNo());
					vehicleInfo.setPrpLthirdPartyDriveName(element.getPrpLthirdPartyDriveName());
					vehicleInfo.setRegistNo(element.getRegistNo());
					vehicleInfo.setRunDistance(element.getRunDistance());
					vehicleInfo.setSerialNo(element.getSerialNo());
					vehicleInfo.setUseYears(element.getUseYears());
					vehicleInfo.setVINNo(element.getVINNo());
					if(!isEmpty(prpLcheckLossDtoList)){
						vehicleInfo.setLossFee(((PrpLcheckLossDto)prpLcheckLossDtoList.get(i)).getLossFee());
					}else{
						vehicleInfo.setLossFee(0.00);
					}
					vehicleInfoList[index++] = vehicleInfo;
				}
			}
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return vehicleInfoList;

	}
	
	/**
	 * ���ͲƲ���Ϣ
	 */
	public PropInfo[] getStorePropertyDamage(String registNo) throws SOAPException{
		PropInfo[] propInfoList = null;
		try {
			if(isEmpty(registNo)){
				throw new Exception("�����Ų���Ϊ�ա���������");
			}
			BLPrpLthirdPropFacade blPrpLthirdPropFacade = new BLPrpLthirdPropFacade();
			BLPrpLcheckLossFacade bLPrpLcheckLossFacade = new BLPrpLcheckLossFacade ();
			String conditions = "registNo = '" + registNo + "' order by serialNo ";
			String conditions1 = " registNo='"+registNo+"' and lossFeeType = '3' order by serialNo ";
			ArrayList prpLthirdPropDtoList = (ArrayList)blPrpLthirdPropFacade.findByConditions(conditions);
			ArrayList prpLcheckLossDtoList = (ArrayList)bLPrpLcheckLossFacade.findByConditions(conditions1);
			if(!isEmpty(prpLthirdPropDtoList)){
				propInfoList = new PropInfo[prpLthirdPropDtoList.size()];
				int index = 0;
				for(int i = 0;i < prpLcheckLossDtoList.size();i++){
					PrpLthirdPropDto prpLthirdPropDto = (PrpLthirdPropDto)prpLthirdPropDtoList.get(i);
					PrpLcheckLossDto prpLcheckLossDto = (PrpLcheckLossDto)prpLcheckLossDtoList.get(i);
					PropInfo propInfo = new PropInfo();
					propInfo.setRegistNo(prpLthirdPropDto.getRegistNo());
					propInfo.setSerialNo(prpLthirdPropDto.getSerialNo());
					propInfo.setLossItemName(prpLthirdPropDto.getLossItemName());
					propInfo.setLossItemDesc(prpLthirdPropDto.getLossItemDesc());
					propInfo.setKindCode(prpLcheckLossDto.getKindCode());
					propInfo.setLossAmount(prpLcheckLossDto.getLossFee());
					propInfoList[index++] = propInfo;
				}
			}
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return propInfoList;
	}
	/**
	 * ��òƲ���Ϣ
	 */
	public boolean propertyDamageSubmit(String registNo,String lossItemId, String lossName, 
			String lossExtentDesc, String insuranceTypeCode,String lossAmount) throws SOAPException{
		boolean flag = false;
		try {
			if(isEmpty(registNo) || isEmpty(lossItemId)){
				throw new Exception("�����б���Ϊ�ա�����");
			}
			BLPrpLthirdPropFacade blPrpLthirdPropDtoFacade = new BLPrpLthirdPropFacade();
			String riskCode = registNo.trim().substring(1,5);
			int index = Integer.parseInt(lossItemId);
			PrpLthirdPropDto prpLthirdPropDto = new PrpLthirdPropDto();
			prpLthirdPropDto.setRegistNo(registNo.trim());
			prpLthirdPropDto.setRiskCode(riskCode);
			prpLthirdPropDto.setSerialNo(index);
			prpLthirdPropDto.setLicenseNo("");
			prpLthirdPropDto.setLossItemCode("");
			prpLthirdPropDto.setLossItemName(lossName);
			prpLthirdPropDto.setLossItemDesc(lossExtentDesc);
			prpLthirdPropDto.setFlag("");
			blPrpLthirdPropDtoFacade.delete(registNo, index);
			blPrpLthirdPropDtoFacade.insert(prpLthirdPropDto);
			
			BLPrpLcheckLossFacade blPrpLcheckLossFacade = new BLPrpLcheckLossFacade();
			String conditions = " registNo = '" + registNo + "' and lossFeeType = '3' ";
			String conditions1 = " registNo = '" + registNo + "'";
			ArrayList prpLcheckLossDtoList = (ArrayList)blPrpLcheckLossFacade.findByConditions(conditions);
			int countPrpLcheckLoss = blPrpLcheckLossFacade.getCount(conditions1);
			int count = prpLcheckLossDtoList.size();
			int serialNo = Integer.parseInt(lossItemId);
			index = 0;
			if(count == 0 && countPrpLcheckLoss > 0){
				index = countPrpLcheckLoss + 1;
			}else{
				if(count < serialNo){
					index = countPrpLcheckLoss + 1;
				}else{
					index = ((PrpLcheckLossDto)prpLcheckLossDtoList.get(serialNo-1)).getSerialNo();
				}
			}
			UICodeAction uiCodeAction = new UICodeAction();
			String claimNo = uiCodeAction.translateBusinessCode(registNo.trim(), true);
			BLPrpLregistFacade bLPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = bLPrpLregistFacade.findByPrimaryKey(registNo.trim());
			PrpLcheckLossDto prpLcheckLossDto = new PrpLcheckLossDto();
			prpLcheckLossDto.setRegistNo(registNo.trim());
			prpLcheckLossDto.setClaimNo(claimNo);
			prpLcheckLossDto.setRiskCode(riskCode);
			prpLcheckLossDto.setPolicyNo(prpLregistDto.getPolicyNo());
			prpLcheckLossDto.setSerialNo(index);
			prpLcheckLossDto.setReferSerialNo(index);
			prpLcheckLossDto.setKindCode(insuranceTypeCode);
			prpLcheckLossDto.setLossFeeType("3");
			prpLcheckLossDto.setLossFee(Double.parseDouble(DataUtils.nullToZero(lossAmount)));
			prpLcheckLossDto.setFlag("");
			blPrpLcheckLossFacade.delete(registNo, index);
			blPrpLcheckLossFacade.insert(prpLcheckLossDto);
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		
		return flag;
	}
	/**
	 * ����������Ϣ
	 */
	public PersonInfo[] getStoreInjuredPeopleTrackingInfo(String registNo) throws SOAPException{
		PersonInfo[] personInfoList = null;
		try {
			if(isEmpty(registNo)){
				throw new Exception("�����Ų���Ϊ�ա���������");
			}
			BLPrpLpersonTraceFacade blPrpLpersonTraceFacade = new BLPrpLpersonTraceFacade();
			String conditions = "registNo = '" + registNo + "'";
			Collection<PrpLpersonTraceDto> prpLpersonTraceDtoList = blPrpLpersonTraceFacade.findByConditions(conditions);
			if(!isEmpty(prpLpersonTraceDtoList)){
				personInfoList = new PersonInfo[prpLpersonTraceDtoList.size()];
				int index = 0;
				for(Iterator<PrpLpersonTraceDto> iter = prpLpersonTraceDtoList.iterator();iter.hasNext();){
					PrpLpersonTraceDto prpLpersonTraceDto = iter.next();
					PersonInfo personInfo = new PersonInfo();
					personInfo.setRegistNo(prpLpersonTraceDto.getRegistNo());
					personInfo.setPersonNo(prpLpersonTraceDto.getPersonNo());
					personInfo.setPersonName(prpLpersonTraceDto.getPersonName());
					personInfo.setPersonSex(prpLpersonTraceDto.getPersonSex());
					personInfo.setPersonAge(prpLpersonTraceDto.getPersonAge());
					personInfo.setJobName(prpLpersonTraceDto.getJobName());
					personInfo.setReferKind(prpLpersonTraceDto.getReferKind());
					personInfo.setPartDesc(prpLpersonTraceDto.getPartDesc());
					personInfo.setHospital(prpLpersonTraceDto.getHospital());
					personInfo.setMotionFlag(prpLpersonTraceDto.getMotionFlag());
					personInfo.setWoundRemark(prpLpersonTraceDto.getWoundRemark());
					personInfoList[index++] = personInfo;
				}
			}
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return personInfoList;
	}
	
	/**
	 *���������Ϣ
	 * 
	 */
	public boolean injuredPeopleTrackingInfoSubmit(String registNo, String  injuredPeopleId,String injuredPeopleName, 
			String  gender, String age, String industry, String insuranceTypeCode, 
			String injurySite, String  injuryDesc, String  isOwnMedical, String  hospital) throws SOAPException{
		boolean flag = false;
		try {
			if(isEmpty(registNo) || isEmpty(injuredPeopleId)){
				throw new Exception("�����б���Ϊ�ա�����");
			}
			BLPrpLpersonTraceFacade blPrpLpersonTraceFacade = new BLPrpLpersonTraceFacade();
			BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade	();
			String conditions = " registNo = '" + registNo +"' and riskCode = '" + registNo.trim().substring(1, 5) + "'";
			ArrayList prpLclaimDtoList= (ArrayList)blPrpLclaimFacade.findByConditions(conditions);
			String claimNo = "";
			String policyNo = "";
			if(!isEmpty(prpLclaimDtoList)){
				PrpLclaimDto prpLclaimDto = (PrpLclaimDto)prpLclaimDtoList.get(0);
				claimNo = prpLclaimDto.getClaimNo();
				policyNo = prpLclaimDto.getPolicyNo();
			}
			int personSerialNo = Integer.parseInt(injuredPeopleId);
			UICodeAction uiCodeAction = new UICodeAction();
			PrpLpersonTraceDto prpLpersonTraceDto = new PrpLpersonTraceDto();
			prpLpersonTraceDto.setRegistNo(registNo);
			prpLpersonTraceDto.setClaimNo(claimNo);
			prpLpersonTraceDto.setPolicyNo(policyNo);
			prpLpersonTraceDto.setPersonNo(personSerialNo);
			prpLpersonTraceDto.setPersonName(injuredPeopleName);
			prpLpersonTraceDto.setPersonSex(gender);
			prpLpersonTraceDto.setPersonAge(Integer.parseInt(age));
			prpLpersonTraceDto.setIdentifyNumber("");
			prpLpersonTraceDto.setRelatePersonNo(0);
			prpLpersonTraceDto.setJobCode("");
			prpLpersonTraceDto.setJobName(industry);
			prpLpersonTraceDto.setReferKind(insuranceTypeCode);
			prpLpersonTraceDto.setPartDesc(injurySite);
			prpLpersonTraceDto.setHospital(hospital);
			prpLpersonTraceDto.setMotionFlag(isOwnMedical);
			prpLpersonTraceDto.setWoundRemark(injuryDesc);
			prpLpersonTraceDto.setFlag("");
			prpLpersonTraceDto.setRemark("");
			blPrpLpersonTraceFacade.delete(registNo, personSerialNo);
			blPrpLpersonTraceFacade.insert(prpLpersonTraceDto);
			flag = true;
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return flag;
		
	}
	
	private boolean isEmpty(String str) {
		return (str == null || str.trim().length() == 0);
	}

	private boolean isEmpty(Collection<?> collection) {
		if (collection != null && collection.size() > 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * ��ȡ�û���¼��Ϣ
	 */
	public GisUserCompanyInfo getUserInfo(String userCode, String userPwd) throws SOAPException, Exception {

		String strComCode = "";
		String strPassWord = "";
		String strPrpDuserCon = "";
		String strPrpDcompanyCon = "";
		GisUserCompanyInfo gisUserCompanyInfo = new GisUserCompanyInfo();
		PrpDcompanyDto prpDcompanyDto = null;
		DBManager dbManager = new DBManager();

		try {
			if (isEmpty(userCode) || isEmpty(userPwd)) {
				throw new Exception("�����б���Ϊ�ա�����");
			}
			strPassWord = EncryptUtils.md5(userPwd).toUpperCase();
			strPrpDuserCon = "SELECT USERCODE,USERNAME,USERENAME,PASSWORD,SEAL,"
					+ "PASSWORDSETDATE,PASSWORDEXPIREDATE,COMCODE,MAKECOM,ACCOUNTCODE,"
					+ "PHONE,MOBILE,ADDRESS,POSTCODE,EMAIL,USERFLAG,LOGINSYSTEM,"
					+ "NEWUSERCODE,VALIDSTATUS,ARTICLECODE,FLAG FROM PRPDUSER WHERE "
					+ "USERCODE = '" + userCode + "' AND PASSWORD = '" + strPassWord
					+ "' AND VALIDSTATUS = '1'";

			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			ResultSet resultSet = dbManager.executeQuery(strPrpDuserCon);
			while (resultSet.next()) {
				gisUserCompanyInfo.setUserCode(dbManager.getString(resultSet, 1));
				gisUserCompanyInfo.setUserName(dbManager.getString(resultSet, 2));
				gisUserCompanyInfo.setUserEName(dbManager.getString(resultSet, 3));
				gisUserCompanyInfo.setPassword(dbManager.getString(resultSet, 4));
				gisUserCompanyInfo.setSeal(dbManager.getString(resultSet, 5));
				gisUserCompanyInfo.setPasswordSetDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 6));
				gisUserCompanyInfo.setPasswordExpireDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 7));
				gisUserCompanyInfo.setUser_ComCode(dbManager.getString(resultSet, 8));
				gisUserCompanyInfo.setMakeCom(dbManager.getString(resultSet, 9));
				gisUserCompanyInfo.setAccountCode(dbManager.getString(resultSet, 10));
				gisUserCompanyInfo.setPhone(dbManager.getString(resultSet, 11));
				gisUserCompanyInfo.setMobile(dbManager.getString(resultSet, 12));
				gisUserCompanyInfo.setAddress(dbManager.getString(resultSet, 13));
				gisUserCompanyInfo.setUser_PostCode(dbManager.getString(resultSet, 14));
				gisUserCompanyInfo.setEmail(dbManager.getString(resultSet, 15));
				gisUserCompanyInfo.setUserFlag(dbManager.getString(resultSet, 16));
				gisUserCompanyInfo.setLoginSystem(dbManager.getString(resultSet, 17));
				gisUserCompanyInfo.setNewUserCode(dbManager.getString(resultSet, 18));
				gisUserCompanyInfo.setUser_ValidStatus(dbManager.getString(resultSet, 19));
				gisUserCompanyInfo.setUser_ArticleCode(dbManager.getString(resultSet, 20));
				gisUserCompanyInfo.setUser_Flag(dbManager.getString(resultSet, 21));
			}
			strComCode = gisUserCompanyInfo.getUser_ComCode();
			if (strComCode != null && !"".equals(strComCode)) {
				strPrpDcompanyCon = " SELECT COMCODE,COMCNAME,COMENAME,ADDRESSCNAME,"
						+ "ADDRESSENAME,POSTCODE,PHONENUMBER,TAXNUMBER,FAXNUMBER,"
						+ "UPPERCOMCODE,INSURERNAME,COMATTRIBUTE,COMTYPE,COMLEVEL,"
						+ "MANAGER,ACCOUNTLEADER,CASHIER,ACCOUNTANT,REMARK,NEWCOMCODE,"
						+ "VALIDSTATUS,ACNTUNIT,ARTICLECODE,ACCCODE,CENTERFLAG,"
						+ "OUTERPAYCODE,INNERPAYCODE,FLAG,WEBADDRESS,SERVICEPHONE,"
						+ "REPORTPHONE,AGENTCODE,AGREEMENTNO,COMPANYFLAG,SHORTCOMCNAME,"
						+ "SERVICEFLAG,DAAPLATFORMCOMCODE FROM PRPDCOMPANY WHERE " 
						+ "COMCODE = '" + strComCode + "'";

				resultSet = dbManager.executeQuery(strPrpDcompanyCon);
				while (resultSet.next()) {
					gisUserCompanyInfo.setComCode(dbManager.getString(resultSet, 1));
					gisUserCompanyInfo.setComCName(dbManager.getString(resultSet, 2));
					gisUserCompanyInfo.setComEName(dbManager.getString(resultSet, 3));
					gisUserCompanyInfo.setAddressCName(dbManager.getString(resultSet, 4));
					gisUserCompanyInfo.setAddressEName(dbManager.getString(resultSet, 5));
					gisUserCompanyInfo.setPostCode(dbManager.getString(resultSet, 6));
					gisUserCompanyInfo.setPhoneNumber(dbManager.getString(resultSet, 7));
					gisUserCompanyInfo.setTaxNumber(dbManager.getString(resultSet, 8));
					gisUserCompanyInfo.setFaxNumber(dbManager.getString(resultSet, 9));
					gisUserCompanyInfo.setUpperComCode(dbManager.getString(resultSet, 10));
					gisUserCompanyInfo.setInsurerName(dbManager.getString(resultSet, 11));
					gisUserCompanyInfo.setComAttribute(dbManager.getString(resultSet, 12));
					gisUserCompanyInfo.setComType(dbManager.getString(resultSet, 13));
					gisUserCompanyInfo.setComLevel(dbManager.getString(resultSet, 14));
					gisUserCompanyInfo.setManager(dbManager.getString(resultSet, 15));
					gisUserCompanyInfo.setAccountLeader(dbManager.getString(resultSet, 16));
					gisUserCompanyInfo.setCashier(dbManager.getString(resultSet, 17));
					gisUserCompanyInfo.setAccountant(dbManager.getString(resultSet, 18));
					gisUserCompanyInfo.setRemark(dbManager.getString(resultSet, 19));
					gisUserCompanyInfo.setNewComCode(dbManager.getString(resultSet, 20));
					gisUserCompanyInfo.setValidStatus(dbManager.getString(resultSet, 21));
					gisUserCompanyInfo.setAcntUnit(dbManager.getString(resultSet, 22));
					gisUserCompanyInfo.setArticleCode(dbManager.getString(resultSet, 23));
					gisUserCompanyInfo.setAccCode(dbManager.getString(resultSet, 24));
					gisUserCompanyInfo.setCenterFlag(dbManager.getString(resultSet, 25));
					gisUserCompanyInfo.setOuterPayCode(dbManager.getString(resultSet, 26));
					gisUserCompanyInfo.setInnerPayCode(dbManager.getString(resultSet, 27));
					gisUserCompanyInfo.setFlag(dbManager.getString(resultSet, 28));
					gisUserCompanyInfo.setWebAddress(dbManager.getString(resultSet, 29));
					gisUserCompanyInfo.setServicePhone(dbManager.getString(resultSet, 30));
					gisUserCompanyInfo.setReportPhone(dbManager.getString(resultSet, 31));
					gisUserCompanyInfo.setAgentCode(dbManager.getString(resultSet, 32));
					gisUserCompanyInfo.setAgreementNo(dbManager.getString(resultSet, 33));
					gisUserCompanyInfo.setCompanyFlag(dbManager.getString(resultSet, 34));
					gisUserCompanyInfo.setShortComCName(dbManager.getString(resultSet, 35));
					gisUserCompanyInfo.setServiceFlag(dbManager.getString(resultSet, 36));
					gisUserCompanyInfo.setDaaplatformComCode(dbManager.getString(resultSet, 37));
				}
				gisUserCompanyInfo.setWebTime(new Date());
			}
			resultSet.close();
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		} finally {
			dbManager.close();
		}
		return gisUserCompanyInfo;
	}

	/**
	 * ��ȡ�û���Ϣ
	 */
	public GisUserInfo[] getUserList(String userCode, int startNum, int endNum) throws SOAPException,
			Exception {

		int count = 0;
		String strPrpDuserCon = "";
		GisUserInfo gisUserInfo = null;
		GisUserInfo[] gisUserInfoList = null;
		DBManager dbManager = new DBManager();

		strPrpDuserCon = "SELECT USERCODE,USERNAME,USERENAME,PASSWORD,SEAL,"
				+ "PASSWORDSETDATE,PASSWORDEXPIREDATE,COMCODE,MAKECOM,ACCOUNTCODE,"
				+ "PHONE,MOBILE,ADDRESS,POSTCODE,EMAIL,USERFLAG,LOGINSYSTEM,"
				+ "NEWUSERCODE,VALIDSTATUS,ARTICLECODE,FLAG FROM PRPDUSER WHERE ";
		if (isEmpty(userCode)) {
			// �����û��������û���Ϣ
			strPrpDuserCon += " VALIDSTATUS = '1' ORDER BY USERCODE ";
		} else {
			strPrpDuserCon += " USERCODE = '" + userCode
					+ "' AND VALIDSTATUS = '1' ORDER BY USERCODE ";
		}

		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			ResultSet resultSet = dbManager.executeQuery(strPrpDuserCon);
			if(isEmpty(userCode)){
				gisUserInfoList = new GisUserInfo[endNum - startNum + 1];
			} else {
				gisUserInfoList = new GisUserInfo[1];
			}
			if (isEmpty(userCode) && startNum > 1) {
				dbManager.locate(resultSet, startNum - 1);
			}
			while (resultSet.next()) {
				if ((count > endNum - startNum) && isEmpty(userCode)) {
					break;
				}
				gisUserInfo = new GisUserInfo();
				gisUserInfo.setUserCode(dbManager.getString(resultSet, 1));
				gisUserInfo.setUserName(dbManager.getString(resultSet, 2));
				gisUserInfo.setUserEName(dbManager.getString(resultSet, 3));
				gisUserInfo.setPassword(dbManager.getString(resultSet, 4));
				gisUserInfo.setSeal(dbManager.getString(resultSet, 5));
				gisUserInfo.setPasswordSetDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 6));
				gisUserInfo.setPasswordExpireDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 7));
				gisUserInfo.setComCode(dbManager.getString(resultSet, 8));
				gisUserInfo.setMakeCom(dbManager.getString(resultSet, 9));
				gisUserInfo.setAccountCode(dbManager.getString(resultSet, 10));
				gisUserInfo.setPhone(dbManager.getString(resultSet, 11));
				gisUserInfo.setMobile(dbManager.getString(resultSet, 12));
				gisUserInfo.setAddress(dbManager.getString(resultSet, 13));
				gisUserInfo.setPostCode(dbManager.getString(resultSet, 14));
				gisUserInfo.setEmail(dbManager.getString(resultSet, 15));
				gisUserInfo.setUserFlag(dbManager.getString(resultSet, 16));
				gisUserInfo.setLoginSystem(dbManager.getString(resultSet, 17));
				gisUserInfo.setNewUserCode(dbManager.getString(resultSet, 18));
				gisUserInfo.setValidStatus(dbManager.getString(resultSet, 19));
				gisUserInfo.setArticleCode(dbManager.getString(resultSet, 20));
				gisUserInfo.setFlag(dbManager.getString(resultSet, 21));
				gisUserInfoList[count] = gisUserInfo;
				count++;
			}
			//dataSet.setGisUserInfoList(gisUserInfoList);
			resultSet.close();
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		} finally {
			dbManager.close();
		}
		return gisUserInfoList;
	}
	
	/**
	 * ��ȡ������ϸ��Ϣ
	 */
	public GisPolicyInfo getPolicyInfoByPolicyNo(String policyNo) throws SOAPException, Exception {

		String strPrpCmainCon = "";
		DBPrpDcode dbPrpDcode = null;
		DBPrpDrisk dbPrpDrisk = null;
		DBPrpDuser dbPrpDuser = null;
		DBPrpDcompany dbPrpDcompany = null;
		DBManager dbManager = new DBManager();
		PrpCmainDto prpCmainDto = new PrpCmainDto();
		GisPolicyInfo gisPolicyInfo = new GisPolicyInfo();
		BLPrpCmainAction blPrpCmainAction = new BLPrpCmainAction();

		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			dbPrpDcode = new DBPrpDcode(dbManager);
			dbPrpDrisk = new DBPrpDrisk(dbManager);
			dbPrpDuser = new DBPrpDuser(dbManager);
			dbPrpDcompany = new DBPrpDcompany(dbManager);
			strPrpCmainCon = " POLICYNO = '" + policyNo + "'";
			prpCmainDto = blPrpCmainAction.findByPrimaryKey(dbManager, policyNo);
			if (prpCmainDto != null) {
				gisPolicyInfo.setProposalNo(prpCmainDto.getProposalNo());
				gisPolicyInfo.setPolicyNo(prpCmainDto.getPolicyNo());
				gisPolicyInfo.setRiskCode(prpCmainDto.getRiskCode());
				gisPolicyInfo
						.setRiskName(dbPrpDrisk.translateCode(prpCmainDto.getRiskCode(), true));
				gisPolicyInfo.setAppliCode(prpCmainDto.getAppliCode());
				gisPolicyInfo.setAppliName(prpCmainDto.getAppliName());
				gisPolicyInfo.setAppliAddress(prpCmainDto.getAppliAddress());
				gisPolicyInfo.setInsuredCode(prpCmainDto.getInsuredCode());
				gisPolicyInfo.setInsuredName(prpCmainDto.getInsuredName());
				gisPolicyInfo.setBusinessType1Name(dbPrpDcode.translateCode("BusinessType1",
						prpCmainDto.getBusinessType1(), true));
				gisPolicyInfo.setOperateDate(prpCmainDto.getOperateDate());
				gisPolicyInfo.setStartDate(prpCmainDto.getStartDate());
				gisPolicyInfo.setEndDate(prpCmainDto.getEndDate());
				gisPolicyInfo.setEndHour(prpCmainDto.getEndHour());
				gisPolicyInfo.setPureRate(prpCmainDto.getPureRate());
				gisPolicyInfo.setDisRate(prpCmainDto.getDisRate());
				gisPolicyInfo.setDisCount(prpCmainDto.getDiscount());
				gisPolicyInfo.setCurrency(prpCmainDto.getCurrency());
				gisPolicyInfo.setSumValue(prpCmainDto.getSumValue());
				gisPolicyInfo.setSumDiscount(prpCmainDto.getSumDiscount());
				gisPolicyInfo.setSumAmount(prpCmainDto.getSumAmount());
				gisPolicyInfo.setSumPremium(prpCmainDto.getSumPremium());
				gisPolicyInfo.setSumSubPrem(prpCmainDto.getSumSubPrem());
				gisPolicyInfo.setSumQuantity(prpCmainDto.getSumQuantity());
				gisPolicyInfo.setEndorseTimes(prpCmainDto.getEndorseTimes());
				gisPolicyInfo.setClaimTimes(prpCmainDto.getClaimTimes());
				gisPolicyInfo.setMakeComName(dbPrpDcompany.translateCode(prpCmainDto.getMakeCom(),
						true));
				gisPolicyInfo.setComName(dbPrpDcompany
						.translateCode(prpCmainDto.getComCode(), true));
				gisPolicyInfo.setUnderWriteCode(prpCmainDto.getUnderWriteCode());
				gisPolicyInfo.setUnderWriteName(prpCmainDto.getUnderWriteName());
				gisPolicyInfo.setOperatorCode(prpCmainDto.getOperatorCode());
				gisPolicyInfo.setOperatorName(dbPrpDuser.translateCode(prpCmainDto
						.getOperatorCode(), true));
				gisPolicyInfo.setInputDate(prpCmainDto.getInputDate());
				gisPolicyInfo.setInputHour(prpCmainDto.getInputHour());
				gisPolicyInfo.setUnderWriteEndDate(prpCmainDto.getUnderWriteEndDate());
				//dataSet.setGisPolicyInfo(gisPolicyInfo);
			} else {
				throw new Exception("�޴˱�������Ϣ������");
			}
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		} finally {
			dbManager.close();
		}
		return gisPolicyInfo;
	}
	
	/**
	 * ��ȡ������Ϣ
	 */
	public GisRegistInfo[] getRegistInfo(String whereSql, int startNum, int endNum) throws SOAPException,
			Exception {
		
		int count = 0;
		String strContidions = "";
		DBPrpDrisk dbPrpDrisk = null;
		DBManager dbManager = new DBManager();
		GisRegistInfo[] gisRegistInfoList = null;
		
		strContidions = "SELECT T.REGISTNO,T.POLICYNO,T.RISKCODE,T.COMCODE,T.DAMAGECODE," +
				"T.DAMAGENAME,T.DAMAGESTARTDATE,T.REPORTDATE FROM (SELECT R.REGISTNO," +
				"R.POLICYNO,R.RISKCODE,R.COMCODE,R.DAMAGECODE,R.DAMAGENAME," +
				"R.DAMAGESTARTDATE,R.REPORTDATE,C.STARTDATE,C.BUSINESSPROVINCE," +
				"C.BUSINESSTOWN,C.BUSINESSCOUNTY,C.BUSINESSAREANAME,R.CLASSCODE," +
				"R.INPUTDATE,R.INSUREDNAME FROM PRPLREGIST R, PRPCMAIN C WHERE " +
				"R.POLICYNO = C.POLICYNO) T ";
		if(!isEmpty(whereSql)){
			strContidions += " WHERE " + whereSql ;
		}
		
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			dbPrpDrisk = new DBPrpDrisk(dbManager);
			ResultSet resultSet = dbManager.executeQuery(strContidions);
			gisRegistInfoList = new GisRegistInfo[endNum - startNum + 1];
			if (startNum > 1) {
				dbManager.locate(resultSet, startNum - 1);
			}
			while (resultSet.next()) {
				if ((count > endNum - startNum)) {
					break;
				}
				GisRegistInfo gisRegistInfo = new GisRegistInfo();
				gisRegistInfo.setRegistNo(dbManager.getString(resultSet, 1));
				gisRegistInfo.setPolicyNo(dbManager.getString(resultSet, 2));
				gisRegistInfo.setRiskCode(dbManager.getString(resultSet, 3));
				gisRegistInfo.setComCode(dbManager.getString(resultSet, 4));
				gisRegistInfo.setDamageCode(dbManager.getString(resultSet, 5));
				gisRegistInfo.setDamageName(dbManager.getString(resultSet, 6));
				gisRegistInfo.setDamageStartDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 7));
				gisRegistInfo.setReportDate(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_DAY,
						8));
				gisRegistInfoList[count] = gisRegistInfo;
				count++;
			}
			for(int i = 0; i < gisRegistInfoList.length; i++){
				gisRegistInfoList[i].setRiskName(dbPrpDrisk.translateCode(gisRegistInfoList[i].getRiskCode(), true));
			}
			resultSet.close();
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		} finally {
			dbManager.close();
		}
		return gisRegistInfoList;
	}

	/**
	 * ��ȡ������ϸ��Ϣ
	 */
	public GisRegistDetailInfo getRegistDetailInfo(String registNo) throws SOAPException, Exception {

		String strContidions = "";
		DBManager dbManager = new DBManager();
		GisRegistDetailInfo gisRegistDetailInfo = null;

		strContidions = " SELECT M.POLICYNO,M.RISKCODE,M.BUSINESSPROVINCE,M.BUSINESSTOWN,"
				+ "M.BUSINESSCOUNTY,M.BUSINESSAREANAME,M.STARTDATE,R.LFLAG,R.LANGUAGE,"
				+ "R.INSUREDCODE,R.INSUREDNAME,R.REPORTDATE,R.REPORTHOUR,R.REPORTORNAME,"
				+ "R.REPORTTYPE,R.PHONENUMBER,R.LINKERNAME,R.REGISTNO,R.DAMAGESTARTDATE,"
				+ "R.DAMAGESTARTHOUR,R.DAMAGEENDDATE,R.DAMAGEENDHOUR,R.DAMAGECODE,R.DAMAGENAME,"
				+ "R.ADDRESSCODE,R.DAMAGEADDRESS,R.LOSSNAME,R.LOSSQUANTITY,R.ESTICURRENCY,"
				+ "R.ESTIMATELOSS,R.RECEIVERNAME,R.HANDLER1CODE,R.COMCODE,R.INPUTDATE,"
				+ "R.ACCEPTFLAG,R.REPEATINSUREFLAG,R.CANCELDATE,R.DEALERCODE,R.OPERATORCODE,"
				+ "R.MAKECOM,R.LOSSESNUMBER,R.LOSSESUNITCODE,R.BUSINESSTYPE,R.BUSINESSTYPE1,"
				+ "R.BUSINESSFLAG,R.OTHERFLAG FROM PRPCMAIN M,PRPLREGIST R WHERE "
				+ "M.POLICYNO = R.POLICYNO AND R.REGISTNO = '" + registNo + "'";
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			ResultSet resultSet = dbManager.executeQuery(strContidions);
			while (resultSet.next()) {
				gisRegistDetailInfo = new GisRegistDetailInfo();
				gisRegistDetailInfo.setPolicyNo(dbManager.getString(resultSet, 1));
				gisRegistDetailInfo.setRiskCode(dbManager.getString(resultSet, 2));
				gisRegistDetailInfo.setBusinessProvince(dbManager.getString(resultSet, 3));
				gisRegistDetailInfo.setBusinessTown(dbManager.getString(resultSet, 4));
				gisRegistDetailInfo.setBusinessCountry(dbManager.getString(resultSet, 5));
				gisRegistDetailInfo.setBusinessAreaName(dbManager.getString(resultSet, 6));
				gisRegistDetailInfo.setStartDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 7));

				gisRegistDetailInfo.setLFlag(dbManager.getString(resultSet, 8));
				gisRegistDetailInfo.setLanguage(dbManager.getString(resultSet, 9));
				gisRegistDetailInfo.setInsuredCode(dbManager.getString(resultSet, 10));
				gisRegistDetailInfo.setInsuredName(dbManager.getString(resultSet, 11));
				gisRegistDetailInfo.setReportDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 12));
				gisRegistDetailInfo.setReportHour(dbManager.getString(resultSet, 13));
				gisRegistDetailInfo.setReportorName(dbManager.getString(resultSet, 14));
				gisRegistDetailInfo.setReportType(dbManager.getString(resultSet, 15));
				gisRegistDetailInfo.setPhoneNumber(dbManager.getString(resultSet, 16));
				gisRegistDetailInfo.setLinkerName(dbManager.getString(resultSet, 17));
				gisRegistDetailInfo.setRegistNo(dbManager.getString(resultSet, 18));

				gisRegistDetailInfo.setDamageStartDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 19));
				gisRegistDetailInfo.setDamageStartHour(dbManager.getString(resultSet, 20));
				gisRegistDetailInfo.setDamageEndDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 21));
				gisRegistDetailInfo.setDamageEndHour(dbManager.getString(resultSet, 22));
				gisRegistDetailInfo.setDamageCode(dbManager.getString(resultSet, 23));
				gisRegistDetailInfo.setDamageName(dbManager.getString(resultSet, 24));
				gisRegistDetailInfo.setAddressCode(dbManager.getString(resultSet, 25));
				gisRegistDetailInfo.setDamageAddress(dbManager.getString(resultSet, 26));

				gisRegistDetailInfo.setLossName(dbManager.getString(resultSet, 27));
				gisRegistDetailInfo.setLossQuantity(dbManager.getString(resultSet, 28));
				gisRegistDetailInfo.setEstiCurrency(dbManager.getString(resultSet, 29));
				gisRegistDetailInfo.setEstimateLoss(dbManager.getString(resultSet, 30));

				gisRegistDetailInfo.setReceiverName(dbManager.getString(resultSet, 31));
				gisRegistDetailInfo.setHandler1Code(dbManager.getString(resultSet, 32));
				gisRegistDetailInfo.setComCode(dbManager.getString(resultSet, 33));
				gisRegistDetailInfo.setInputDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 34));
				gisRegistDetailInfo.setAcceptFlag(dbManager.getString(resultSet, 35));
				gisRegistDetailInfo.setRepeatInsureFlag(dbManager.getString(resultSet, 36));
				gisRegistDetailInfo.setCancelDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 37));
				gisRegistDetailInfo.setDealerCode(dbManager.getString(resultSet, 38));
				gisRegistDetailInfo.setOperatorCode(dbManager.getString(resultSet, 39));
				gisRegistDetailInfo.setMakeCom(dbManager.getString(resultSet, 40));
				gisRegistDetailInfo.setLossesNumber(dbManager.getString(resultSet, 41));
				gisRegistDetailInfo.setLossesUnitCode(dbManager.getString(resultSet, 42));
				gisRegistDetailInfo.setBusinessType(dbManager.getString(resultSet, 43));
				gisRegistDetailInfo.setBusinessType1(dbManager.getString(resultSet, 44));
				gisRegistDetailInfo.setBusinessFlag(dbManager.getString(resultSet, 45));
				gisRegistDetailInfo.setOtherFlag(dbManager.getString(resultSet, 46));
				//dataSet.setGisRegistDetailInfo(gisRegistDetailInfo);
			}
			resultSet.close();
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		} finally {
			dbManager.close();
		}
		return gisRegistDetailInfo;
	}
}

