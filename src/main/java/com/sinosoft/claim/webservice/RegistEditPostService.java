package com.sinosoft.claim.webservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.axis.client.Service;

import com.gyic.claim.bl.facade.BLZh03PolicyListFacade;
import com.gyic.claim.dto.domain.Zh03PolicyListDto;
import com.sinosoft.claim.dto.custom.AcciRegistDto;
import com.sinosoft.claim.dto.custom.AgriRegistDto;
import com.sinosoft.claim.dto.custom.CargoRegistDto;
import com.sinosoft.claim.dto.custom.LiabRegistDto;
import com.sinosoft.claim.dto.custom.PropRegistDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpDcodeDto;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.viewHelper.AgriRegistViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.CallCenterInterfaceLogger;
import com.sinosoft.claim.util.XMLHandler;
import com.sinosoft.claim.webservice.client.NewAgriWS.ClaimForRegistServiceSoapBindingStub;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmainCasualty;
import com.sinosoft.prpall.pubfun.TransCodeCI;
import com.sinosoft.prpall.schema.PrpCmainCasualtySchema;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

public class RegistEditPostService {
	CallCenterInterfaceLogger logger = new CallCenterInterfaceLogger();
	/**
	 * ũ�ձ����ӿ�
	 * @param agriRegistDto
	 * @return
	 */
	public String saveAgriRegistDto(AgriRegistDto agriRegistDto){
		long serial = System.currentTimeMillis();
		logger.log("ũ�ձ����ӿ�", 1,serial, agriRegistDto);
		String registNo = "";
		try {
			String policyNo = "";
			if(agriRegistDto != null){
				policyNo = agriRegistDto.getPolicyNo();
			}
			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PrpCmainDto prpCmainDto = uiPolicyAction.findPrpCmainDtoByPrimaryKey(policyNo);
			if(prpCmainDto != null && "agri".equals(prpCmainDto.getSystemFlag())){//��ũ��
				//String URL = "http://9.0.2.33:9012/services/ClaimForRegistService?wsdl";
				String URL = AppConfig.get("sysconst.NEWAGRI_REGISTSAVE");
				String xml = XMLHandler.getSaveAgriRegistDtoXML(agriRegistDto);
				System.out.println("ũ�ձ����ӿ������ģ�"+xml);
				logger.log("ũ�ձ����ӿ������ģ�", 0,serial, xml);
				Service service = new Service();
				ClaimForRegistServiceSoapBindingStub stub = 
						new ClaimForRegistServiceSoapBindingStub(new java.net.URL(URL),service);
				String returnMessage = stub.saveAgriRegistDto(xml);
				System.out.println("ũ�ձ����ӿڷ��ر��ģ�"+returnMessage);
				logger.log("ũ�ձ����ӿڷ��ر��ģ�", 0,serial, returnMessage);
				String code = returnMessage.substring(returnMessage.indexOf("<code>")+6, returnMessage.indexOf("</code>"));
				if("00".equals(code)){
					registNo = returnMessage.substring(returnMessage.indexOf("<registNo>")+10, returnMessage.indexOf("</registNo>"));
				}
				System.out.println("registNo="+registNo);
			}else{//������
				
				RegistEditPostInfoCheckAndTrans RegistEditPostInfoCheckAndTrans = new RegistEditPostInfoCheckAndTrans();
				//У�����
				RegistEditPostInfoCheckAndTrans.checkAgriRegistDtoInfo(agriRegistDto);
				RegistEditPostInfo registEditPostInfo = RegistEditPostInfoCheckAndTrans.transAgriRegistEditPostInfo(agriRegistDto);
				registNo = saveMainRegistDtoInfo(registEditPostInfo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("ũ�ձ����ӿ�",serial,e);
		}
		logger.log("ũ�ձ����ӿ�", 0,serial, "[registNo:"+registNo+"]");
		return registNo;
	}
	
	/**
	 * �����ձ����ӿ�
	 * @param cargoRegistDto
	 * @return
	 */
	public String saveCargoRegistDto(CargoRegistDto cargoRegistDto){
		long serial = System.currentTimeMillis();
		logger.log("�����ձ����ӿ�", 1,serial, cargoRegistDto);
		String registNo = "";
		try {
			RegistEditPostInfoCheckAndTrans RegistEditPostInfoCheckAndTrans = new RegistEditPostInfoCheckAndTrans();
			//У�����
			RegistEditPostInfoCheckAndTrans.checkCarRegistDtoInfo(cargoRegistDto);
			RegistEditPostInfo registEditPostInfo = RegistEditPostInfoCheckAndTrans.transCargoRegistEditPostInfo(cargoRegistDto);
			registNo = saveMainRegistDtoInfo(registEditPostInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("�����ձ����ӿ�",serial,e);
		}
		logger.log("�����ձ����ӿ�", 0,serial, "[registNo:"+registNo+"]");
		return registNo;
	}
	
	/**
	 * �Ʋ��ձ����ӿ�
	 * @param cargoRegistDto
	 * @return
	 */
	public String savePropRegistDto(PropRegistDto propRegistDto){
		long serial = System.currentTimeMillis();
		logger.log("�Ʋ��ձ����ӿ�", 1,serial, propRegistDto);
		String registNo = "";
		try {
			RegistEditPostInfoCheckAndTrans RegistEditPostInfoCheckAndTrans = new RegistEditPostInfoCheckAndTrans();
			//У�����
			RegistEditPostInfoCheckAndTrans.checkPropRegistDtoInfo(propRegistDto);
			RegistEditPostInfo registEditPostInfo = RegistEditPostInfoCheckAndTrans.transPropRegistEditPostInfo(propRegistDto);
			registNo = saveMainRegistDtoInfo(registEditPostInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("�Ʋ��ձ����ӿ�",serial,e);
		}
		logger.log("�Ʋ��ձ����ӿ�", 0,serial, "[registNo:"+registNo+"]");
		return registNo;
	}
	
	/**
	 * �⽡�ձ����ӿ�
	 * @param cargoRegistDto
	 * @return
	 */
	public String saveAcciRegistDto(AcciRegistDto acciRegistDto){
		long serial = System.currentTimeMillis();
		logger.log("�⽡�ձ����ӿ�", 1,serial, acciRegistDto);
		String registNo = "";
		try {
			RegistEditPostInfoCheckAndTrans RegistEditPostInfoCheckAndTrans = new RegistEditPostInfoCheckAndTrans();
			//У�����
			RegistEditPostInfoCheckAndTrans.checkAcciRegistDtoInfo(acciRegistDto);
			RegistEditPostInfo registEditPostInfo = RegistEditPostInfoCheckAndTrans.transAcciRegistEditPostInfo(acciRegistDto);
			registNo = saveMainRegistDtoInfo(registEditPostInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("�⽡�ձ����ӿ�",serial,e);
		}
		logger.log("�⽡�ձ����ӿ�", 0,serial, "[registNo:"+registNo+"]");
		return registNo;
	}
	
	/**
	 * �����ձ����ӿ�
	 * @param cargoRegistDto
	 * @return
	 */
	public String saveLiabRegistDto(LiabRegistDto liabRegistDto){
		long serial = System.currentTimeMillis();
		logger.log("�����ձ����ӿ�", 1,serial, liabRegistDto);
		String registNo = "";
		try {
			RegistEditPostInfoCheckAndTrans RegistEditPostInfoCheckAndTrans = new RegistEditPostInfoCheckAndTrans();
			//У�����
			RegistEditPostInfoCheckAndTrans.checkLiabRegistDtoInfo(liabRegistDto);
			RegistEditPostInfo registEditPostInfo = RegistEditPostInfoCheckAndTrans.transLiabRegistEditPostInfo(liabRegistDto);
			registNo = saveMainRegistDtoInfo(registEditPostInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("�����ձ����ӿ�",serial,e);
		}
		logger.log("�����ձ����ӿ�", 0,serial, "[registNo:"+registNo+"]");
		return registNo;
	}
	
	
	private String saveMainRegistDtoInfo(RegistEditPostInfo registEditPostInfo){
		String registNo = "";
		boolean flag = false;
		try {
			UICodeAction uiCodeAction = new UICodeAction();
			String createWorkFlowFlag = "0"; //�Ƿ���Ҫ�����������������һ�α��棬��Ҫ���������� 0 ��ʾ����Ҫ�� 1��ʾ��Ҫ
			String registReportorName = registEditPostInfo.getPrpLregistReportorName();
			String registReportDate = registEditPostInfo.getPrpLregistReportDate();
			String registReportHour = registEditPostInfo.getPrpLregistReportHour();
			String registPolicyNo = registEditPostInfo.getPrpLregistPolicyNo();
			String riskCode = registEditPostInfo.getPrpLregistRiskCode();
			String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
			String typeFlag = "";
			String scheduleType = registEditPostInfo.getScheduleType();
			if ("ALLS".equals(scheduleType)) {
				typeFlag = "10";
			}
			
			String strInsuredName = "";
			UserDto user = new UserDto();
			user.setComCode(registEditPostInfo.getUserComCode());
			user.setComName(registEditPostInfo.getUserComName());
			user.setUserCode(registEditPostInfo.getUserCode());
			user.setUserName(registEditPostInfo.getUserName());
			
			//ת�ɶ�Ӧ�Ľ�ǿ�����ֺ�
	        TransCodeCI transCodeCI = new TransCodeCI();
	        String compelRiskCode = transCodeCI.convertToRiskCodeCI(riskCode); //ȡ��ǿ�Ʊ��յ����ִ���
			
	        String policyComCode = registEditPostInfo.getPrpLregistComCode();
	        int year = DateTime.current().getYear();
	        int nextNodeNo = 0;
			if (registNo.length() < 1 || registNo == null) { //ȡ��������
				UIBillAction uiBillAction = new UIBillAction();
				String tableName = "prplregist";
				registNo = uiBillAction.getNo(tableName, riskCode,
						policyComCode, year);

				createWorkFlowFlag = "1";
			}
			registEditPostInfo.setRegistNo(registNo);
			//Ϊ�����������ı�־
			//��viewHelper�����������
			//modify by miaowenjun 20060922 start ũ�����Լ���viewhelper
			RegistDto registDto = new RegistDto();
			//��ǰ�ð汾�Ʋ���û�е���,������Թ�Ԫ������ԲƲ���,������,�����ռ��ϵ��ȵÿ���
			//����⽡�ա�add by xiatian
			if ("I".equals(strRiskType)
					|| "Q".equals(strRiskType) || "Z".equals(strRiskType)
					|| "Y".equals(strRiskType)|| "H".equals(strRiskType) ||"E".equals(strRiskType)){
				AgriRegistViewHelper agriRegistViewHelper = new AgriRegistViewHelper();
				registDto = agriRegistViewHelper.viewToDtoNew(registEditPostInfo, user);
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
			swfLogDtoDealNode.setComCode(registEditPostInfo.getPrpLregistComCode());
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
			
			if(("I".equals(strRiskType) )
					&& swfLogDtoDealNode.getNodeStatus().equals("4")){
				Collection nextNodeList = new ArrayList();
//				String[] strNodeNo = httpServletRequest
//						.getParameterValues("nextNodeNoList");
//				if (strNodeNo != null) {
//					for (int i = 0; i < strNodeNo.length; i++) {
//						SwfLogDto swfLogNextNode = new SwfLogDto();
//						nextNodeNo = Integer.parseInt(strNodeNo[i]);
//						swfLogNextNode.setNodeNo(nextNodeNo);
//						nextNodeList.add(swfLogNextNode);
//					}
//				}
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
			
			//ũ��ס����Ϣ
			if("0310".equals(registEditPostInfo.getPrpLregistRiskCode())||"0312".equals(registEditPostInfo.getPrpLregistRiskCode())){
				 ArrayList prplCompensateHouseDtoList = new ArrayList();
				 PrplcompensatehouseDto	prplCompensateHouseDto = new PrplcompensatehouseDto();
	    		 prplCompensateHouseDto.setAddress(registEditPostInfo.getPrplCompensateHouseAddress());
	    		 prplCompensateHouseDto.setBusinessno(registEditPostInfo.getRegistNo());
	    		 //prplCompensateHouseDto.setCaseno(); ��������û����Щ��Ϣ
	    		 //prplCompensateHouseDto.setClaimno();
	    		 //prplCompensateHouseDto.setCompensateno();
	    		 prplCompensateHouseDto.setDamagecode(registEditPostInfo.getPrpLregistDamageCode());
	    		 prplCompensateHouseDto.setDamagename(registEditPostInfo.getPrpLregistDamageName());
	    		 prplCompensateHouseDto.setDamagestartdate(new DateTime(registEditPostInfo.getPrpLregistDamageStartDate(),DateTime.YEAR_TO_DAY));
	    		 prplCompensateHouseDto.setEstimateloss(Double.parseDouble(DataUtils.nullToZero(registEditPostInfo.getPrplCompensateHouseEstimateloss())));
	    		 prplCompensateHouseDto.setHukoubu(registEditPostInfo.getPrplCompensateHouseHukoubu());
	    		 prplCompensateHouseDto.setIdcard(registEditPostInfo.getPrplCompensateHouseIdcard());
	    		 prplCompensateHouseDto.setKindcode("001");
	    		 prplCompensateHouseDto.setName(registEditPostInfo.getPrplCompensateHouseName());
	    		 prplCompensateHouseDto.setPhone(registEditPostInfo.getPrplCompensateHousePhone());
	    		 prplCompensateHouseDto.setRegistno(registEditPostInfo.getRegistNo());
	    		 prplCompensateHouseDto.setPolicyno(registEditPostInfo.getPrpLregistPolicyNo());
	    		 prplCompensateHouseDto.setNodeno(1);
	    		 prplCompensateHouseDto.setNodetype("regis");
	    		 prplCompensateHouseDto.setRemark(registEditPostInfo.getPrplCompensateHouseRemark());
				 prplCompensateHouseDto.setFloor(registEditPostInfo.getPrplCompensateHouseFloor());
	    		 prplCompensateHouseDto.setBuildingnumber(registEditPostInfo.getPrplCompensateHouseBuildingnumber());
	    		 prplCompensateHouseDto.setZhuannumber(registEditPostInfo.getPrplCompensateHouseZhuannumber());
	    		 prplCompensateHouseDto.setWanumber(registEditPostInfo.getPrplCompensateHouseWanumber());
	    		 prplCompensateHouseDto.setKitchennumber(registEditPostInfo.getPrplCompensateHouseKitchennumber());
	    		 prplCompensateHouseDto.setOthernumber(registEditPostInfo.getPrplCompensateHouseOthernumber());
	    		 prplCompensateHouseDtoList.add(prplCompensateHouseDto);
	    		 registDto.setPrplCompensateHouseDtoList(prplCompensateHouseDtoList);
			}
			
			UIRegistAction uiRegistAction = new UIRegistAction();

			if (workFlowViewHelper.checkDealDto(workFlowDto)) {
				uiRegistAction.save(registDto, workFlowDto);
				flag = true;
				user.setUserMessage(registNo);
			} else {
				if (workFlowDto.getOperateResult() < 0) {
					user.setUserMessage("ע��:��������������ʱ��δ�ҵ���ع�����ģ������ã�����ϵϵͳ����Ա������Ӧ���ã���");
				} else {
					uiRegistAction.save(registDto);
					flag = true;
					user.setUserMessage(registNo + ";ע��:û�з����빤������������κ����ݣ���");
				}
			}
			
		} catch (Exception e) {
			if(!flag){
				registNo="";
			}
			e.printStackTrace();
		}
		if(!flag){
			registNo="";
		}
		return registNo;
	}
	/**
	 * ũ�Ҹ����ձ�������������������Ϣ
	 * @param policyNo
	 * @param indexCode
	 * @return
	 */
	public RegistInsuredDtoInfo[]  getRegistInsured (String policyNo,String indexCode){
		
		long serial = System.currentTimeMillis();logger.log("ũ�Ҹ����ձ�������������������Ϣ", 1,serial, "[policyNo:"+policyNo+"][indexCode:"+indexCode+"]");
		RegistInsuredDtoInfo[] registInsuredDtoInfos = null;
		ArrayList<RegistInsuredDtoInfo> registInsuredDtoInfoList = new ArrayList<RegistInsuredDtoInfo>();
		try {
			if(isEmpty(policyNo)){throw new Exception("�������Ǳش����������飡");}
			if(isEmpty(indexCode)){throw new Exception("������Ǳش����������飡");}
			
			String conditions = "";

	         BLPrpCmainCasualty blPrpCmainCasualty = new BLPrpCmainCasualty();
	   		 blPrpCmainCasualty.getData(policyNo);
	   		 if(null != blPrpCmainCasualty && blPrpCmainCasualty.getSize()==1){
	   		 	PrpCmainCasualtySchema prpCmainCasualtySchema = blPrpCmainCasualty.getArr(0);
	   		 	String insureListCode = prpCmainCasualtySchema.getRemark();
	   		 	if(null!=insureListCode && insureListCode.length() > 0){
	   		 		conditions = " INUSRELISTCODE = '"+ insureListCode + "' "+//���������Ᵽ����ɸѡ���еı�����������
	   		 			" AND FamilyNo LIKE '%"+indexCode+"%'  " +
	   							" and KINDCODE = '2742001' ";
	   				BLZh03PolicyListFacade blZH03PolicyListFacade = new BLZh03PolicyListFacade();
	   				Collection collection = blZH03PolicyListFacade.findByConditions(conditions);
		   	   		int recordSize = collection.size();
			        for(Iterator iterator = collection.iterator();iterator.hasNext();){
		   	   			Zh03PolicyListDto zh03PolicyListDto = (Zh03PolicyListDto)iterator.next();
		   	   			RegistInsuredDtoInfo registInsuredDtoInfo = new RegistInsuredDtoInfo();
		   	   			registInsuredDtoInfo.setIndexCode(zh03PolicyListDto.getFamilyNo());
		   	   			registInsuredDtoInfo.setSerialNo(zh03PolicyListDto.getPersonNo());
		   	   			registInsuredDtoInfo.setInsuredMainName(zh03PolicyListDto.getFamilyName());
		   	   			registInsuredDtoInfo.setIdentifyNumber(zh03PolicyListDto.getFamilyFIdCard());
		   	   			registInsuredDtoInfo.setInsuredLinkName(zh03PolicyListDto.getName());
		   	   			registInsuredDtoInfoList.add(registInsuredDtoInfo);
		   	   		}
	   		 	}
	   		 }
			registInsuredDtoInfos = new RegistInsuredDtoInfo[registInsuredDtoInfoList.size()];
			for(int i = 0;i<registInsuredDtoInfoList.size();i++){
				registInsuredDtoInfos[i] = registInsuredDtoInfoList.get(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("ũ�Ҹ����ձ�������������������Ϣ",serial,e);
		}
		logger.log("ũ�Ҹ����ձ�������������������Ϣ", 0,serial, registInsuredDtoInfos);
		return registInsuredDtoInfos;
	}
	
	private boolean isEmpty(String str){
		if(str==null||str.trim().length()==0){
			return true;
		}else{
			return false;
		}
			
	}
	
}
