package com.sinosoft.common_claim.bl.action.custom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.sinosoft.claim.bl.action.domain.BLPrpLcheckAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLclaimAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLcompensateAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLlossAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpersonLossAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLrecaseAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLregistAction;
import com.sinosoft.claim.bl.action.domain.BLSwfLogAction;
import com.sinosoft.claim.bl.facade.BLPrpLaccipersonFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLltextFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistTextFacade;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.claim.dto.domain.PrpLltextDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossForSHDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciPerson;
import com.sinosoft.claimprop.common.bl.facade.BLCiClaimPropDemandFacade;
import com.sinosoft.claimprop.common.dto.domain.CiClaimPropDemandDto;
import com.sinosoft.common_claim.dto.domain.CIPropCancelCaseRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIPropClaimInsuredInfoDto;
import com.sinosoft.common_claim.dto.domain.CIPropClaimPolicyInfoDto;
import com.sinosoft.common_claim.dto.domain.CIPropClaimRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIPropEndcaseRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIPropRegistRequestInDto;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �Ϻ�ƽ̨�⽡����װ����ҵ����
 * @author feigai1
 *
 */
public class TransDataHelperProp {

	public TransDataHelperProp() {
		
	}
	/**
	 * ��װ�⽡�ձ����ӿ�����Ҫ��ҵ������
	 * @param businessNo
	 * @param policyNo
	 * @return
	 * @throws Exception
	 */
	public CIPropRegistRequestInDto getRegist(DBManager dbManager,String businessNo,String policyNo,String groupFlag,String secodeComCode) throws Exception{
		CIPropRegistRequestInDto ciPropRegistRequestInDto = new CIPropRegistRequestInDto();
		//��������
		String policySequenceNo = ""; 
	
		String SQLConditions = "select POLICYSEQUENCENO from CIhealthDemand where policyno = '"+policyNo+"'";
		ResultSet resultSet = dbManager.executeQuery(SQLConditions);
		while(resultSet.next()){
			policySequenceNo = resultSet.getString(1);
		}

		String acciName=""; //����������
		String identifyType=""; //������֤������
		String identifyNumber=""; //������֤��	
		String customerSequenceNo = ""; //�ͻ�����
		ArrayList<PrpLacciPersonDto> prpLacciPersonList  = (ArrayList) new DBPrpLacciPerson(dbManager).findByConditions(" CertiNo='"+businessNo+"'");
		if(prpLacciPersonList.size()>0){
			Iterator it = prpLacciPersonList.iterator();
				while(it.hasNext()){
					customerSequenceNo = "";
					PrpLacciPersonDto acciPerson = (PrpLacciPersonDto)it.next();
					acciName = acciPerson.getAcciName();
					if(acciName.length()>16){
						acciName = acciName.substring(0,16);
					}
					identifyType = getIdentifyType(acciPerson.getIdentifyType());
					identifyNumber = acciPerson.getIdentifyNumber();
					
					String SQLcustomerSequenceNo = "select CUSTOMERSEQUENCENO from prpCinsured where policyno = '"+policyNo+"' and serialno = '"+acciPerson.getFamilyNo()+"'";
					ResultSet resultSetCus = dbManager.executeQuery(SQLcustomerSequenceNo);
					while(resultSetCus.next()){
						customerSequenceNo = resultSetCus.getString(1);
					}
					if(customerSequenceNo ==null || customerSequenceNo.equals("")){
						SQLcustomerSequenceNo = "select CUSTOMERSEQUENCENO from prpPinsured where policyno = '"+policyNo+"' and serialno = '"+acciPerson.getFamilyNo()+"'";
						ResultSet resultSetCus1 = dbManager.executeQuery(SQLcustomerSequenceNo);
						while(resultSetCus1.next()){
							customerSequenceNo = resultSetCus1.getString(1);
						}
					}					
					//�ŵ��ͻ�����������ȡ;
					if(customerSequenceNo ==null || customerSequenceNo.equals("")){						
						SQLcustomerSequenceNo = "select CUSTOMERSEQUENCENO from prpcvirturlitem where policyno='"+acciPerson.getPolicyNo()+"' And FamilyNo='"+acciPerson.getFamilyNo()+"'";
						ResultSet resultSetCus2 = dbManager.executeQuery(SQLcustomerSequenceNo);
						if(resultSetCus2.next()){
							customerSequenceNo = resultSetCus2.getString(1);
						}
					}					
					acciPerson.setAcciCode(customerSequenceNo);
				}
		}
		String damagerText = "";//���վ���		
		Date damageStartDate = new Date();
		String damageStartHour = null;
		Date reportStartDate = new Date();
		String reportStartHour = null;	
		PrpLregistDto prpLregistDto = new BLPrpLregistFacade().findByPrimaryKey(businessNo);
		//����ʱ�䣨������ʱ�֣�
		if (prpLregistDto != null) {
			damageStartDate = prpLregistDto.getDamageStartDate();
			damageStartHour = prpLregistDto.getDamageStartHour();
			reportStartDate = prpLregistDto.getReportDate();
			reportStartHour = prpLregistDto.getReportHour();
		}
		BLPrpLregistTextFacade bLPrpLregistTextFacade = new BLPrpLregistTextFacade();
		ArrayList textList = (ArrayList)bLPrpLregistTextFacade.findByConditions(" registno='"+ businessNo +"' and texttype='1' ");
		for(int i=0;i<textList.size();i++){
			PrpLregistTextDto prpLregistText =(PrpLregistTextDto) textList.get(i);
			    damagerText+=prpLregistText.getContext();
		}
		damagerText=damagerText.replaceAll("	","");
		damagerText=damagerText.replaceAll(" ","");
		damagerText=damagerText.replaceAll("\n","");
		
		String DamageName ="";
		if(prpLregistDto.getDamageName().indexOf("����")>-1){
			DamageName = "2";
		}else if(prpLregistDto.getDamageName().indexOf("��")>-1){
			DamageName = "1";
		}else{
			DamageName = "9";
		}
		String DamageTypeName ="";
		if(prpLregistDto.getDamageTypeName().indexOf("���")>-1 || prpLregistDto.getDamageTypeName().indexOf("����")>-1){
			DamageTypeName = "01";
		}else if(prpLregistDto.getDamageTypeName().indexOf("�м�")>-1 || prpLregistDto.getDamageTypeName().indexOf("����")>-1){
			DamageTypeName = "03";
		}else if(prpLregistDto.getDamageTypeName().indexOf("�ش󼲲�")>-1){
			DamageTypeName = "04";
		}else if(prpLregistDto.getDamageTypeName().indexOf("ҽ��")>-1){
			DamageTypeName = "07";
		}else if(prpLregistDto.getDamageTypeName().indexOf("����")>-1){
			DamageTypeName = "08";
		}else{
			DamageTypeName = "99";
		}
		String ClauseType ="";
		if(prpLregistDto.getClauseType().equals("1")){
			ClauseType = "00";
		}else if(prpLregistDto.getClauseType().equals("2")){
			ClauseType = "10";
		}else{
			ClauseType = "99";
		}
		
		//��װ����
		ciPropRegistRequestInDto.setIsGroup(groupFlag);
		ciPropRegistRequestInDto.setCustomerSequenceNo(customerSequenceNo);//�ͻ�����
		ciPropRegistRequestInDto.setAccidentDate(new SimpleDateFormat("yyyyMMdd").format(damageStartDate));//��������
		ciPropRegistRequestInDto.setSurveyOrNot("1");//�Ƿ����
		ciPropRegistRequestInDto.setCloseDate("");//�᰸����
		ciPropRegistRequestInDto.setClaimStatus("01");////����״̬
		ciPropRegistRequestInDto.setIsReopen("0");//�Ƿ��ؿ�
		ciPropRegistRequestInDto.setReopenNum("");//�ؿ�����
		ciPropRegistRequestInDto.setReopenReason("");//�ؿ�ԭ��
		ciPropRegistRequestInDto.setReportDate(new SimpleDateFormat("yyyyMMdd").format(reportStartDate));////��������
		ciPropRegistRequestInDto.setReportNo(businessNo);//������
		ciPropRegistRequestInDto.setRegistrationDate("");//��������
		ciPropRegistRequestInDto.setRegistrationNo("");//������
		ciPropRegistRequestInDto.setAccidentReason(DamageName);////����ԭ��
		ciPropRegistRequestInDto.setAccidentPlace(prpLregistDto.getDamageAddress());//���յص�
		ciPropRegistRequestInDto.setReportName(prpLregistDto.getReportorName());//����������
		ciPropRegistRequestInDto.setReportGender("");//�������Ա�
		ciPropRegistRequestInDto.setReportBirthday("");//�����˳�������
		if(ClauseType.equals("00")){
			ciPropRegistRequestInDto.setReportCertNo(identifyNumber);//������֤������
			ciPropRegistRequestInDto.setReportCertType("01");//������֤�����
		}else{
			ciPropRegistRequestInDto.setReportCertNo("");//������֤������
			ciPropRegistRequestInDto.setReportCertType("");//������֤�����
		}
		ciPropRegistRequestInDto.setReportPhone(prpLregistDto.getReportorPhoneNumber());//��������ϵ�绰
		ciPropRegistRequestInDto.setReportAddr(prpLregistDto.getReportAddress());//�����˾�����ϵ��ַ
		ciPropRegistRequestInDto.setAccName(acciName);//����������
		ciPropRegistRequestInDto.setAccCertType(identifyType);////������֤�����
		ciPropRegistRequestInDto.setAccCertNo(identifyNumber);////������֤������
		ciPropRegistRequestInDto.setAccResult(DamageTypeName);//���ս��
		ciPropRegistRequestInDto.setAccResultDate(new SimpleDateFormat("yyyyMMdd").format(reportStartDate));////���ս��ʱ��
		ciPropRegistRequestInDto.setStatus("1");//ҵ������״̬
		ciPropRegistRequestInDto.setInvestigationStartDate("");//������鿪ʼ����
		ciPropRegistRequestInDto.setInvestigationEndDate("");//��������������
		ciPropRegistRequestInDto.setRemoteClaimInvestigation("");//�����������ʶ
		ciPropRegistRequestInDto.setRelationship(ClauseType);//������������˹�ϵ
		ciPropRegistRequestInDto.setMedicalCareLable("");//ҽ����ʶ
		ciPropRegistRequestInDto.setSocialNumber("");//�籣����
		ciPropRegistRequestInDto.setAllClaimAmount("");//�⸶�ܽ��	
		ciPropRegistRequestInDto.setPolicyNo(policyNo);//������
		//����
		if("1".equals(groupFlag)){
			if(prpLacciPersonList.size() > 0){
				Iterator it = prpLacciPersonList.iterator();
				while(it.hasNext()){
					PrpLacciPersonDto acciPerson = (PrpLacciPersonDto)it.next();
					CIPropClaimInsuredInfoDto ciPropClaimInsuredInfoDto = new CIPropClaimInsuredInfoDto();					
					ciPropClaimInsuredInfoDto.setCustomerNo(String.valueOf(acciPerson.getFamilyNo()));
					ciPropClaimInsuredInfoDto.setAccidentDate(new SimpleDateFormat("yyyyMMddHH").parse(new SimpleDateFormat("yyyyMMdd").format(damageStartDate)+damageStartHour));
					ciPropClaimInsuredInfoDto.setCustomerSequenceNo(acciPerson.getAcciCode());//Ϊ�����ŵ����¹��߳���������޸Ŀͻ������ȡֵBY CDB
					ciPropRegistRequestInDto.getCiPropClaimInsuredList().add(ciPropClaimInsuredInfoDto);
				}
			}
		}//else{//����
			//CIPropClaimPolicyInfoDto ciPropClaimPolicyInfoDto = new CIPropClaimPolicyInfoDto();
			//ciPropClaimPolicyInfoDto.setPolicySequenceNo(policySequenceNo);
			//ciPropRegistRequestInDto.getCiPropClaimPolicyList().add(ciPropClaimPolicyInfoDto);
			ciPropRegistRequestInDto.setPolicySequenceNo(policySequenceNo);
		//}
		
		return ciPropRegistRequestInDto;
	}
	
	/**
	 * �Ϻ�ƽ̨�⽡��������װ����ҵ����
	 * @param dbManager
	 * @param claimNo
	 * @param policyNo
	 * @param groupFlag
	 * @param secodeComCode
	 * @return
	 * @throws Exception
	 */
	public CIPropClaimRequestInDto getCIPropClaimRequestInDto(
			DBManager dbManager, String claimNo, String policyNo,String groupFlag,String secodeComCode) throws Exception {
		String policySequenceNo = ""; //��������
		String isGroup = "";
		String remoteCheckType = "";//�������������
		String checkDate = "";
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CIPropClaimRequestInDto ciPropClaimRequestInDto = new CIPropClaimRequestInDto();
		CIPropClaimInsuredInfoDto ciPropClaimInsuredInfoDto = null;
		CIPropClaimPolicyInfoDto ciPropClaimPolicyInfoDto = new CIPropClaimPolicyInfoDto();
		PrpLclaimDto prpLClaimDto = new BLPrpLclaimAction().findByPrimaryKey(dbManager, claimNo);
		String registNo = prpLClaimDto.getRegistNo();
		PrpLregistDto prpLregistDto = new BLPrpLregistAction().findByPrimaryKey(dbManager,registNo);
		String SQLConditions = "select POLICYSEQUENCENO from CIhealthDemand where policyno = '"+policyNo+"'";
		ResultSet resultSet = dbManager.executeQuery(SQLConditions);
		while(resultSet.next()){
			policySequenceNo = resultSet.getString(1);
		}

		isGroup = groupFlag;//�š����ձ�־;
		String acciName=""; //����������
		String identifyType=""; //������֤������
		String identifyNumber=""; //������֤��	
		String customerSequenceNo = ""; //�ͻ�����
		List prpLacciPersonList = new ArrayList();
		prpLacciPersonList = (ArrayList) new BLPrpLaccipersonFacade().findByConditions(dbManager, " certino = '"+registNo+"'");
		if(prpLacciPersonList.size()>0){
			Iterator it = prpLacciPersonList.iterator();
				while(it.hasNext()){
					customerSequenceNo = "";
					PrpLacciPersonDto acciPerson = (PrpLacciPersonDto)it.next();
					acciName = acciPerson.getAcciName();
					if(acciName.length()>16){
						acciName = acciName.substring(0,16);
					}
					identifyType = getIdentifyType(acciPerson.getIdentifyType());
					identifyNumber = acciPerson.getIdentifyNumber();
					
					String SQLcustomerSequenceNo = "select CUSTOMERSEQUENCENO from prpcinsured where policyno = '"+policyNo+"' and serialno = '"+acciPerson.getFamilyNo()+"'";
					ResultSet resultSetCus = dbManager.executeQuery(SQLcustomerSequenceNo);
					while(resultSetCus.next()){
						customerSequenceNo = resultSetCus.getString(1);
					}
					if(customerSequenceNo ==null || customerSequenceNo.equals("")){
						 SQLcustomerSequenceNo = "select CUSTOMERSEQUENCENO from prpPinsured where policyno = '"+policyNo+"' and serialno = '"+acciPerson.getFamilyNo()+"'";
						 ResultSet resultSetCus1 = dbManager.executeQuery(SQLcustomerSequenceNo);
							while(resultSetCus1.next()){
								customerSequenceNo = resultSetCus1.getString(1);
							}
					}					
					//�ŵ��ͻ�����������ȡ;
					if(customerSequenceNo ==null || customerSequenceNo.equals("")){						
						SQLcustomerSequenceNo = "select CUSTOMERSEQUENCENO from prpcvirturlitem where policyno='"+acciPerson.getPolicyNo()+"' And FamilyNo='"+acciPerson.getFamilyNo()+"'";
						ResultSet resultSetCus2 = dbManager.executeQuery(SQLcustomerSequenceNo);
						if(resultSetCus2.next()){
							customerSequenceNo = resultSetCus2.getString(1);
						}
					}					
					acciPerson.setAcciCode(customerSequenceNo);
				}
		}
		//String strCheckno = registNo+"-001";
		PrpLcheckDto prpLcheckDto = new BLPrpLcheckAction().findByPrimaryKey(dbManager,registNo,1);
		if(prpLcheckDto  != null){
			checkDate = new SimpleDateFormat("yyyy-MM-dd").format(prpLcheckDto.getCheckDate());
			if(prpLcheckDto.getHandleUnitCode().startsWith("31") || prpLcheckDto.getHandleUnitCode().equals("00000000")){
				remoteCheckType = "04";
			}else{
				remoteCheckType = "01";
			}
		}
		
		String damagerText = "";//���վ���
		Date claimDate =new Date();
		Date damageStartDate = new Date();
		String damageStartHour = null;
		Date reportStartDate = new Date();
		String reportStartHour = null;		
		//����ʱ�䣨������ʱ�֣�
		if (prpLregistDto != null) {
			damageStartDate = prpLregistDto.getDamageStartDate();
			damageStartHour = prpLregistDto.getDamageStartHour();
			reportStartDate = prpLregistDto.getReportDate();
			reportStartHour = prpLregistDto.getReportHour();
		}
		if(prpLClaimDto  != null){
			claimDate = prpLClaimDto.getClaimDate();
		}
		BLPrpLregistTextFacade bLPrpLregistTextFacade = new BLPrpLregistTextFacade();
		ArrayList textList = (ArrayList)bLPrpLregistTextFacade.findByConditions(" registno='"+registNo+"' and texttype='1' ");
		for(int i=0;i<textList.size();i++){
			PrpLregistTextDto prpLregistText =(PrpLregistTextDto) textList.get(i);
			    damagerText+=prpLregistText.getContext();
		}
		damagerText=damagerText.replaceAll("	","");
		damagerText=damagerText.replaceAll(" ","");
		damagerText=damagerText.replaceAll("\n","");
		
		String DamageName ="";
		if(prpLregistDto.getDamageName().indexOf("����")>-1){
			DamageName = "2";
		}else if(prpLregistDto.getDamageName().indexOf("��")>-1){
			DamageName = "1";
		}else{
			DamageName = "9";
		}
		String DamageTypeName ="";
		if(prpLregistDto.getDamageTypeName().indexOf("���")>-1 || prpLregistDto.getDamageTypeName().indexOf("����")>-1){
			DamageTypeName = "01";
		}else if(prpLregistDto.getDamageTypeName().indexOf("�м�")>-1 || prpLregistDto.getDamageTypeName().indexOf("����")>-1){
			DamageTypeName = "03";
		}else if(prpLregistDto.getDamageTypeName().indexOf("�ش󼲲�")>-1){
			DamageTypeName = "04";
		}else if(prpLregistDto.getDamageTypeName().indexOf("ҽ��")>-1){
			DamageTypeName = "07";
		}else if(prpLregistDto.getDamageTypeName().indexOf("����")>-1){
			DamageTypeName = "08";
		}else{
			DamageTypeName = "99";
		}
		String ClauseType ="";
		if(prpLregistDto.getClauseType().equals("1")){
			ClauseType = "00";
		}else if(prpLregistDto.getClauseType().equals("2")){
			ClauseType = "10";
		}else{
			ClauseType = "99";
		}
		ciPropClaimRequestInDto.setPolicySequenceNo(policySequenceNo);
		ciPropClaimRequestInDto.setCenterCode(secodeComCode);
		ciPropClaimRequestInDto.setPolicySequenceNo(policySequenceNo);//�������
		ciPropClaimRequestInDto.setClaimNo(claimNo);	   //�ⰸ��
		ciPropClaimRequestInDto.setCustomerSequenceNo(customerSequenceNo);//�ͻ�����
		ciPropClaimRequestInDto.setAccidentDate(damageStartDate);//��������
		ciPropClaimRequestInDto.setSurveyOrNot("1");//�Ƿ����
		//ciPropClaimRequestInDto.setCloseDate("");//�᰸����
		ciPropClaimRequestInDto.setClaimStatus("02");//����״̬
		ciPropClaimRequestInDto.setIsReopen("");//�Ƿ��ؿ�
		//ciPropClaimRequestInDto.setReopenNum("");//�ؿ�����	
		ciPropClaimRequestInDto.setReopenReason("");//�ؿ�ԭ��	
		ciPropClaimRequestInDto.setReportDate(reportStartDate);//��������	
		ciPropClaimRequestInDto.setReportNo(registNo);//������	
		ciPropClaimRequestInDto.setRegistrationDate(claimDate);//��������	
		ciPropClaimRequestInDto.setRegistrationNo(claimNo);//������		
		ciPropClaimRequestInDto.setAccidentReason(DamageName);//����ԭ��		
		ciPropClaimRequestInDto.setAccidentPlace(prpLregistDto.getDamageAddress());//���յص�	
		ciPropClaimRequestInDto.setReportName(prpLregistDto.getReportorName());//����������	
		ciPropClaimRequestInDto.setReportGender("");//�Ա�	
		//ciPropClaimRequestInDto.setReportBirthday("") ;//��������	
		if(ClauseType.equals("00")){
			ciPropClaimRequestInDto.setReportCerttype("01") ;//֤�����	
			ciPropClaimRequestInDto.setReportCertno(identifyNumber);//������֤������
		}else{
			ciPropClaimRequestInDto.setReportCerttype("") ;//֤�����	
			ciPropClaimRequestInDto.setReportCertno("") ;//֤������	
		}
		ciPropClaimRequestInDto.setReportPhone(prpLregistDto.getReportorPhoneNumber()) ;//��ϵ�绰	
		ciPropClaimRequestInDto.setReportAddr(prpLregistDto.getReportAddress()) ;//������ϵ��ַ	
		ciPropClaimRequestInDto.setAccName(acciName) ;//����������	
		ciPropClaimRequestInDto.setAccCertType(identifyType) ;//֤�����	
		ciPropClaimRequestInDto.setAccCertNo(identifyNumber) ;//֤������	
		ciPropClaimRequestInDto.setAccResult(DamageTypeName) ;//���ս��	
		ciPropClaimRequestInDto.setAccResultDate(reportStartDate) ;//���ս��ʱ��	
		ciPropClaimRequestInDto.setStatus("1") ;//ҵ������״̬
		if(checkDate != null && !"".equals(checkDate)){
			ciPropClaimRequestInDto.setInvestigationStartDate(format.parse(checkDate)) ;//������鿪ʼ����	
			ciPropClaimRequestInDto.setInvestigationEndDate(format.parse(checkDate));//��������������	
		}		
		ciPropClaimRequestInDto.setRemoteClaimInvestigation(remoteCheckType) ;//�����������ʶ	
		ciPropClaimRequestInDto.setRelationShip(ClauseType) ;//������������˹�ϵ	
		ciPropClaimRequestInDto.setMedicalCareLable("") ;//ҽ����ʶ	
		ciPropClaimRequestInDto.setSocialNumber("") ;//�籣����	
		ciPropClaimRequestInDto.setAllClaimAmount("") ;//�⸶�ܽ��	
		
		if(groupFlag.equals("1")){
			ciPropClaimRequestInDto.setIsGroup(groupFlag);
			ArrayList<CIPropClaimInsuredInfoDto> claimInsuredList= new ArrayList<CIPropClaimInsuredInfoDto>();
			for (int i = 0; i < prpLacciPersonList.size(); i++) {
				ciPropClaimInsuredInfoDto = new CIPropClaimInsuredInfoDto();//Ϊ�����ŵ����¹��߳����ϴ�ƽ̨�ɹ����޸ĸ�ֵ
				PrpLacciPersonDto acciPerson = (PrpLacciPersonDto) prpLacciPersonList.get(i);				
				ciPropClaimInsuredInfoDto.setCustomerNo(acciPerson.getFamilyNo()+"");//�ͻ����
				ciPropClaimInsuredInfoDto.setCustomerSequenceNo(acciPerson.getAcciCode());//�ͻ����
				ciPropClaimInsuredInfoDto.setAccidentDate(new SimpleDateFormat("yyyyMMddHH").parse(new SimpleDateFormat("yyyyMMdd").format(damageStartDate)+damageStartHour));//��������
				ciPropClaimInsuredInfoDto.setName(acciPerson.getAcciName());//�ͻ�����
				//ciPropClaimInsuredInfoDto.setGender("");//�Ա�
				//ciPropClaimInsuredInfoDto.setBirthDay(birthDay);//��������
				ciPropClaimInsuredInfoDto.setCertNo(acciPerson.getIdentifyNumber());//���֤����
				ciPropClaimInsuredInfoDto.setCertificateType(acciPerson.getIdentifyType());//֤�����
				ciPropClaimInsuredInfoDto.setCertificateNo(acciPerson.getIdentifyNumber());//֤������
				//ciPropClaimInsuredInfoDto.setNation("");//����
				//ciPropClaimInsuredInfoDto.setEffectiveDate("");//��Ч������ʼ����
				//ciPropClaimInsuredInfoDto.setExpireDate("");//��Ч���޽�ֹ����
				claimInsuredList.add(ciPropClaimInsuredInfoDto);
			}
			ciPropClaimRequestInDto.setCiPropClaimInsuredList(claimInsuredList);
		}//else{
			//ArrayList<CIPropClaimPolicyInfoDto> claimPolicyList = new ArrayList<CIPropClaimPolicyInfoDto>();
			//ciPropClaimPolicyInfoDto.setPolicySequenceNo(ciPropClaimRequestInDto.getPolicySequenceNo());  //�������
			//claimPolicyList.add(ciPropClaimPolicyInfoDto);
			//ciPropClaimRequestInDto.setPolicySequenceNo(policySequenceNo);
		//}
		return ciPropClaimRequestInDto;
	}
	
	
	
	
	/**
	 * �Ϻ�ƽ̨�⽡�ս᰸��װ����ҵ����
	 * @param dbManager
	 * @param claimNo
	 * @param policyNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public CIPropEndcaseRequestInDto getEndCaseProp(DBManager dbManager, String claimNo,String policyNo,String groupFlag) throws SQLException, Exception {
		String policySequenceNo = "";//�������
		String customerSequenceNo = "";//�ͻ�����
		String isGroup = groupFlag;//�Ƿ��ŵ�
		String registNo = "";//������
		String CaseNo = "";//�ⰸ��
		String isReopen = "0";//�Ƿ��ؿ�
		int reopenNum = 0;       //�ؿ�����
		String reopenReason="";  //�ؿ�ԭ��
		double sumPaid = 0d; // �����
		double sumdutyPaid = 0d; // �����
		String acciName=""; //����������
		String identifyType=""; //������֤������
		String identifyNumber=""; //������֤��
		String damagerText = "";//���վ���
		String claimAccount = "";//����ʺ�
		String claimBank = "";//����˻�������
		String claimName = "";//����ʺ�������
		String remoteCheckType = "";//�������������
		String hospitalCode = "";//ҽ�ƻ�������
		String diseaseCode = "";//��������
		SwfLogDto swfLogDto = null;
		DateTime claimDate =new DateTime();
		DateTime checkDate =new DateTime();
		DateTime damageStartDate = new DateTime();
		String damageStartHour = null;
		DateTime reportStartDate = new DateTime();
		String reportStartHour = null;	
		ArrayList prpLpersonLossList = new ArrayList();
		ArrayList prpLacciPersonList = new ArrayList();
		CIPropEndcaseRequestInDto propEndcase = new CIPropEndcaseRequestInDto();
		String SQLConditions = "select POLICYSEQUENCENO from CIhealthDemand where policyno = '"+policyNo+"'";
		ResultSet resultSet = dbManager.executeQuery(SQLConditions);
		BLPrpCmain blPrpCmain = new BLPrpCmain();
		while(resultSet.next()){
			policySequenceNo = resultSet.getString(1);
		}
//		String SQLConditions1 = "select flag from prpcmain where policyno = '"+policyNo+"'";
//		ResultSet resultSet1 = dbManager.executeQuery(SQLConditions1);
//		while(resultSet1.next()){
//			isGroup = resultSet1.getString(1);
//			if(isGroup.length()>1){
//				isGroup = "1";
//			}
//		}
		PrpLclaimDto prpLClaimDto = new BLPrpLclaimAction().findByPrimaryKey(dbManager, claimNo);
		if(prpLClaimDto  != null){
			claimDate = prpLClaimDto.getClaimDate();
			registNo = prpLClaimDto.getRegistNo();
		}
		PrpLregistDto prpLregistDto = new BLPrpLregistAction().findByPrimaryKey(dbManager,registNo);
		BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
		Collection collection = blPrpLcompensateAction.findByConditions(dbManager," claimno = '"+claimNo+"'");
		if(collection.size()>0){
			Iterator iteratorOfCompensate = collection.iterator();
			while(iteratorOfCompensate.hasNext()){
				PrpLcompensateDto prpLcompensateDto =(PrpLcompensateDto)iteratorOfCompensate.next();
				CaseNo= prpLcompensateDto.getCaseNo();
				sumPaid = sumPaid +prpLcompensateDto.getSumPaid();
				sumdutyPaid = sumdutyPaid +prpLcompensateDto.getSumDutyPaid();
				claimAccount = prpLcompensateDto.getAccount();
				claimBank = prpLcompensateDto.getBank();
				claimName = prpLcompensateDto.getReceiverName();
				hospitalCode = prpLcompensateDto.getHospitalCode();
				diseaseCode = prpLcompensateDto.getDiseaseCode();
			}
		}
		String DamageName ="";
		if(prpLregistDto.getDamageName().indexOf("����")>-1){
			DamageName = "2";
		}else if(prpLregistDto.getDamageName().indexOf("��")>-1){
			DamageName = "1";
		}else{
			DamageName = "9";
		}
		String personLossConditions = "policyno='" + policyNo+ "' and compensateno in (select compensateno from prplcompensate where claimNo='"+claimNo+"')";
		prpLpersonLossList = (ArrayList) new BLPrpLpersonLossAction().findByConditions(dbManager, personLossConditions);
		//����մ�prpLloss��ȡֵ;
		blPrpCmain.getData(policyNo);
		
		ArrayList prpLlossDtoList = new ArrayList();
		ArrayList prpLpersonLossListForSH = new ArrayList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(prpLpersonLossList.size()>0){
			Iterator itLoss = prpLpersonLossList.iterator();
			
			while(itLoss.hasNext()){
				PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto)itLoss.next();
				PrpLpersonLossForSHDto personLoss = new PrpLpersonLossForSHDto();
				new BeanUtils().copyProperties(personLoss, prpLpersonLossDto);
				if(personLoss.getLiabDetailName().equals("�������")){
					personLoss.setLiabDetailCode("01");
				}else if(personLoss.getLiabDetailName().equals("�������")){
					personLoss.setLiabDetailCode("02");
				}else if(personLoss.getLiabDetailName().equals("��������˲�") || personLoss.getLiabDetailName().equals("�������/�м�") || personLoss.getLiabDetailName().equals("����м�")){
					personLoss.setLiabDetailCode("04");
				}else if(personLoss.getLiabDetailName().equals("ҽ�Ʋ���")){
					personLoss.setLiabDetailCode("06");
				}else if(personLoss.getLiabDetailName().equals("�ش󼲲�")){
					personLoss.setLiabDetailCode("07");
				}else if(personLoss.getLiabDetailName().equals("����סԺҽ��") || personLoss.getLiabDetailName().equals("�����˺�ҽ�Ʒ���")){
					personLoss.setLiabDetailCode("10");
				}else if(personLoss.getLiabDetailName().equals("����סԺ����")){
					personLoss.setLiabDetailCode("11");
				}else if(personLoss.getLiabDetailName().equals("����ҽ��")){
					personLoss.setLiabDetailCode("13");
				}else if(personLoss.getLiabDetailName().equals("����ҽ��")){
					personLoss.setLiabDetailCode("21");
				}else{
					personLoss.setLiabDetailCode("99");
				}
				prpLpersonLossListForSH.add(personLoss);
			}
		}
//		if(prpLlossDtoList.size() > 0){
//			Iterator itPrpLlossDtoList =  prpLlossDtoList.iterator();
//			while(itPrpLlossDtoList.hasNext()){
//				PrpLlossDto prpLlossDto = (PrpLlossDto)itPrpLlossDtoList.next();
//				//ֻ�ϴ��⽡���ձ�
//				if("26,27,28".indexOf(prpLlossDto.getKindCode().substring(0, 2)) > -1){
//					PrpLpersonLossForSHDto personLoss = new PrpLpersonLossForSHDto();
//					personLoss.setRiskCode(prpLlossDto.getRiskCode());
//					personLoss.setKindCode(prpLlossDto.getKindCode());
//					personLoss.setSumRealPay(prpLlossDto.getSumRealPay());
//					personLoss.setFamilyNo(prpLlossDto.getFamilyNo());
//					personLoss.setInHospDate("");
//					personLoss.setOutHospDate("");
//					if(prpLregistDto.getDamageName().equals("�������")){
//						personLoss.setLiabDetailCode("01");
//					}else if(prpLregistDto.getDamageName().equals("�������")){
//						personLoss.setLiabDetailCode("02");
//					}else if(prpLregistDto.getDamageName().equals("��������˲�") || prpLregistDto.getDamageName().equals("�������/�м�") || prpLregistDto.getDamageName().equals("����м�")){
//						personLoss.setLiabDetailCode("04");
//					}else if(prpLregistDto.getDamageName().equals("ҽ�Ʋ���")){
//						personLoss.setLiabDetailCode("06");
//					}else if(prpLregistDto.getDamageName().equals("�ش󼲲�")){
//						personLoss.setLiabDetailCode("07");
//					}else if(prpLregistDto.getDamageName().equals("����סԺҽ��") || prpLregistDto.getDamageName().equals("�����˺�ҽ�Ʒ���")){
//						personLoss.setLiabDetailCode("10");
//					}else if(prpLregistDto.getDamageName().equals("����סԺ����")){
//						personLoss.setLiabDetailCode("11");
//					}else if(prpLregistDto.getDamageName().equals("����ҽ��")){
//						personLoss.setLiabDetailCode("13");
//					}else if(prpLregistDto.getDamageName().equals("����ҽ��")){
//						personLoss.setLiabDetailCode("21");
//					}else{
//						personLoss.setLiabDetailCode("99");
//					}
//					prpLpersonLossListForSH.add(personLoss);
//				}
//			}
//		}
		
		prpLacciPersonList = (ArrayList) new BLPrpLaccipersonFacade().findByConditions(dbManager, " certino = '"+registNo+"'");
		
		if(prpLacciPersonList.size()>0){
		Iterator it = prpLacciPersonList.iterator();
			while(it.hasNext()){
				customerSequenceNo = "";//�᰸�ϴ�ƽ̨��"�����¿ͻ�����Ϳͻ���Ų�ƥ�䣡"�����޸�
				PrpLacciPersonDto acciPerson = (PrpLacciPersonDto)it.next();
				acciName = acciPerson.getAcciName();
				if(acciName.length()>16){
					acciName = acciName.substring(0,16);
				}
				identifyType = getIdentifyType(acciPerson.getIdentifyType());
				identifyNumber = acciPerson.getIdentifyNumber();

				String SQLcustomerSequenceNo = "select CUSTOMERSEQUENCENO from prpcinsured where policyno = '"+policyNo+"' and serialno = '"+acciPerson.getFamilyNo()+"'";
				ResultSet resultSetCus = dbManager.executeQuery(SQLcustomerSequenceNo);
				while(resultSetCus.next()){
					customerSequenceNo = resultSetCus.getString(1);
				}
				if(customerSequenceNo ==null || customerSequenceNo.equals("")){
					 SQLcustomerSequenceNo = "select CUSTOMERSEQUENCENO from prpPinsured where policyno = '"+policyNo+"' and serialno = '"+acciPerson.getFamilyNo()+"'";
					 ResultSet resultSetCus1 = dbManager.executeQuery(SQLcustomerSequenceNo);
						while(resultSetCus1.next()){
							customerSequenceNo = resultSetCus1.getString(1);
						}
				}				
				//�ŵ��ͻ�����������ȡ;
				if(customerSequenceNo ==null || customerSequenceNo.equals("")){						
					SQLcustomerSequenceNo = "select CUSTOMERSEQUENCENO from prpcvirturlitem where policyno='"+acciPerson.getPolicyNo()+"' And FamilyNo='"+acciPerson.getFamilyNo()+"'";
					ResultSet resultSetCus2 = dbManager.executeQuery(SQLcustomerSequenceNo);
					if(resultSetCus2.next()){
						customerSequenceNo = resultSetCus2.getString(1);
					}
				}				
				acciPerson.setAcciCode(customerSequenceNo);
			}
		}
		Collection collection1 = new BLPrpLrecaseAction().findByConditions(dbManager, " claimno = '"+claimNo+"'");
		if(collection1.size()>0){
			reopenNum = collection1.size();
			isReopen = "1";
			Iterator ite = collection1.iterator();
			while(ite.hasNext()){
				PrpLrecaseDto prpLrecaseDto = (PrpLrecaseDto)ite.next();
				reopenReason = prpLrecaseDto.getReCaseReason();
			}
		}
		if(CaseNo.equals("")){
			String conditions  = " NODETYPE = 'endca' and NODESTATUS = '4' and BUSINESSNO='"+claimNo+"' and REGISTNO = '"+registNo+"' order by logno asc "; 
			ArrayList swfEndcaList = (ArrayList) new BLSwfLogAction().findByConditions(dbManager, conditions);
			if(swfEndcaList!= null && swfEndcaList.size()>0){
				swfLogDto = new SwfLogDto();
				swfLogDto = (SwfLogDto) swfEndcaList.get(0);
				if(swfLogDto != null){
					CaseNo = swfLogDto.getKeyOut();
				}
			}
		}
		//String strCheckno = registNo+"-001";
		PrpLcheckDto prpLcheckDto = new BLPrpLcheckAction().findByPrimaryKey(dbManager,registNo,1);
		if(prpLcheckDto  != null){
			checkDate = prpLcheckDto.getCheckDate();
			if(prpLcheckDto.getHandleUnitCode().startsWith("31") || prpLcheckDto.getHandleUnitCode().equals("00000000")){
				remoteCheckType = "04";
			}else{
				remoteCheckType = "01";
			}
		}
		
		//����ʱ�䣨������ʱ�֣�
		if (prpLregistDto != null) {
			damageStartDate = prpLregistDto.getDamageStartDate();
			damageStartHour = prpLregistDto.getDamageStartHour();
			reportStartDate = prpLregistDto.getReportDate();
			reportStartHour = prpLregistDto.getReportHour();
		}
		BLPrpLregistTextFacade bLPrpLregistTextFacade = new BLPrpLregistTextFacade();
		ArrayList textList = (ArrayList)bLPrpLregistTextFacade.findByConditions(" registno='"+registNo+"' and texttype='1' ");
		for(int i=0;i<textList.size();i++){
			PrpLregistTextDto prpLregistText =(PrpLregistTextDto) textList.get(i);
			    damagerText+=prpLregistText.getContext();
		}
		damagerText=damagerText.replaceAll("	","");
		damagerText=damagerText.replaceAll(" ","");
		damagerText=damagerText.replaceAll("\n","");
		
		String DamageTypeName ="";
		if(prpLregistDto.getDamageTypeName().indexOf("���")>-1 || prpLregistDto.getDamageTypeName().indexOf("����")>-1){
			DamageTypeName = "01";
		}else if(prpLregistDto.getDamageTypeName().indexOf("�м�")>-1 || prpLregistDto.getDamageTypeName().indexOf("����")>-1){
			DamageTypeName = "03";
		}else if(prpLregistDto.getDamageTypeName().indexOf("�ش󼲲�")>-1){
			DamageTypeName = "04";
		}else if(prpLregistDto.getDamageTypeName().indexOf("ҽ��")>-1){
			DamageTypeName = "07";
		}else if(prpLregistDto.getDamageTypeName().indexOf("����")>-1){
			DamageTypeName = "08";
		}else{
			DamageTypeName = "99";
		}
		String ClauseType ="";
		if(prpLregistDto.getClauseType().equals("1")){
			ClauseType = "00";
		}else if(prpLregistDto.getClauseType().equals("2")){
			ClauseType = "10";
		}else{
			ClauseType = "99";
		}
		propEndcase.setPolicySequenceNo(policySequenceNo);//�������
		propEndcase.setPolicyNO(policyNo);   //������
		propEndcase.setRegistNo(registNo);   //������
		propEndcase.setClaimNo(claimNo);	 //������
		propEndcase.setEndCaseNo(CaseNo);    //�ⰸ��
		propEndcase.setReopenNum(reopenNum); //�ؿ�����
		propEndcase.setIsReopen(isReopen); //�Ƿ��ؿ�
		propEndcase.setReopenReason(reopenReason);//�ؿ�ԭ��
		propEndcase.setClaimDate(sdf.format(claimDate));
		propEndcase.setDamageDate(sdf.format(damageStartDate));
		propEndcase.setDamageHour(prpLregistDto.getDamageStartHour());
		propEndcase.setReportDate(sdf.format(reportStartDate));//����ʱ��
		propEndcase.setEndCaseDate(sdf.format(new Date()));
		propEndcase.setReportHour(prpLregistDto.getReportHour());
		propEndcase.setReportName(prpLregistDto.getReportorName());//������
		propEndcase.setPhoneNumber(prpLregistDto.getPhoneNumber());//�����˵绰
		propEndcase.setLinkerName(prpLregistDto.getLinkerName());//��ϵ��
		propEndcase.setLinkerAddress(prpLregistDto.getLinkerAddress());//��ϵ�˵�ַ
		propEndcase.setDamagerArrea(prpLregistDto.getDamageAddress());//���ֵص�
		propEndcase.setDamageName(DamageName);//����ԭ��
		propEndcase.setDamagerText(damagerText);//���վ���
		propEndcase.setDamageTypeName(DamageTypeName);//���ֽ�����¹����ͣ�
		propEndcase.setClauseType(ClauseType);//������������˹�ϵ
		propEndcase.setCheckDate(sdf.format(checkDate));//�鿱ʱ��
		propEndcase.setRemoteCheckType(remoteCheckType);//����������
		propEndcase.setSumPaid(sumPaid);
		propEndcase.setIsGroup(isGroup);
		propEndcase.setClaimAccount(claimAccount);
		propEndcase.setClaimBank(claimBank);
		propEndcase.setClaimName(claimName);
		
		propEndcase.setCustomerSequenceNo(customerSequenceNo);
		propEndcase.setAcciName(acciName);//����������
		propEndcase.setIdentifyType(identifyType);//������֤������
		propEndcase.setIdentifyNumber(identifyNumber);//������֤������
		propEndcase.setAcciPersonList(prpLacciPersonList);
		propEndcase.setPersonLossList(prpLpersonLossListForSH);
		
		return propEndcase;
	}
	
	/**
	 * ע��
	 * @param dbManager
	 * @param businessNo
	 * @param policyNo
	 * @param claimStatus
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public CIPropCancelCaseRequestInDto getCancelClaimCase(DBManager dbManager, String businessNo,String policyNo,String groupFlag,String claimStatus) throws SQLException, Exception {
		CIPropCancelCaseRequestInDto propcancelCase = new CIPropCancelCaseRequestInDto();
		String registNo = "";
		String claimNo = "";
		String tempContext = "";
		String condition = "";
		String conditions = "";
		if(businessNo!=null){
			if(businessNo.substring(0, 1).equals("4")){
				registNo = businessNo;
			}else if(businessNo.substring(0, 1).equals("5")){
				registNo = new BLPrpLclaimFacade().findByPrimaryKey(businessNo).getRegistNo();
				claimNo = businessNo;
			}
		}
		if(claimNo ==""){//����ע��
			condition = " RegistNo='" + registNo + "'  and texttype = '2'";
			BLPrpLregistTextFacade blPrpLregistTextFacade = new BLPrpLregistTextFacade();
			ArrayList prplRegistTextList = (ArrayList)blPrpLregistTextFacade.findByConditions(condition);
			if (prplRegistTextList != null) {
	            Iterator iterator = prplRegistTextList.iterator();
	            while (iterator.hasNext()) {
	            	PrpLregistTextDto prpLregistTextDto = (PrpLregistTextDto) iterator.next();
	                tempContext = tempContext + prpLregistTextDto.getContext();
	            }
	        }
			claimStatus = "01";//ע��״̬������ע��
		}else{//����ע��
			condition = " claimno = '"+claimNo+"' and texttype = '10' ";
			BLPrpLltextFacade blPrpLltextFacade = new BLPrpLltextFacade();
			ArrayList prplltextList = (ArrayList)blPrpLltextFacade.findByConditions(condition);
			if (prplltextList != null) {
				Iterator iterator = prplltextList.iterator();
				while (iterator.hasNext()) {
					PrpLltextDto prpLltextDtoTemp = (PrpLltextDto) iterator.next();
					tempContext = tempContext + prpLltextDtoTemp.getContext();
				}
			}
			claimStatus = "02";//ע��״̬������ע��
		}
		propcancelCase.setPolicyNO(policyNo);
		propcancelCase.setRegistNo(registNo);
		propcancelCase.setCanceReason(tempContext);
		propcancelCase.setCancelType(claimStatus);
		propcancelCase.setIsGroup(groupFlag);
		
		return propcancelCase;
	}
	
	
	/**
	 * ֤������ת����ƽ̨����
	 * @param strIdentifyType
	 * @return
	 */
	public String getIdentifyType(String strIdentifyType){
    	String IdentifyType = "";   	
    	if(strIdentifyType.equals("03")){  //07	�й�����
    		IdentifyType = "07";
    	}else if(strIdentifyType.equals("05")){ //03 ��ʻ֤
    		IdentifyType = "03";
    	}else if(strIdentifyType.equals("06")){ //11 ����֤
    		IdentifyType = "11";
    	}else{
    		IdentifyType = "01";
    	}    	
    	return IdentifyType;
    }
}	
