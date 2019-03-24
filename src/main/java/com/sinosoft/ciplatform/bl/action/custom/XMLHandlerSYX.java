package com.sinosoft.ciplatform.bl.action.custom;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.claim.dto.domain.PrpLlocklogDto;
import com.sinosoft.ciplatform.dto.custom.Accounts;
import com.sinosoft.ciplatform.dto.custom.CancelCase;
import com.sinosoft.ciplatform.dto.custom.CarLoss;
import com.sinosoft.ciplatform.dto.custom.Claim;
import com.sinosoft.ciplatform.dto.custom.ClaimCover;
import com.sinosoft.ciplatform.dto.custom.CompensateVeric;
import com.sinosoft.ciplatform.dto.custom.EndCase;
import com.sinosoft.ciplatform.dto.custom.EndCaseAppSituation;
import com.sinosoft.ciplatform.dto.custom.EndCaseAppend;
import com.sinosoft.ciplatform.dto.custom.HistoryClaim;
import com.sinosoft.ciplatform.dto.custom.Iconstants;
import com.sinosoft.ciplatform.dto.custom.Payinfor;
import com.sinosoft.ciplatform.dto.custom.PersonLoss;
import com.sinosoft.ciplatform.dto.custom.PropLoss;
import com.sinosoft.ciplatform.dto.custom.ReCase;
import com.sinosoft.ciplatform.dto.custom.RecoveryOrPay;
import com.sinosoft.ciplatform.dto.custom.Regist;
import com.sinosoft.ciplatform.dto.custom.ReturnAccountsInfo;
import com.sinosoft.ciplatform.dto.custom.ReturnInfo;
import com.sinosoft.ciplatform.util.CodeTransfer;
import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.claim.dto.domain.PrpLlocklogDto;
import com.sinosoft.ciplatform.dto.custom.Paydata;
import com.sinosoft.prpall.pubfun.PubTools;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.claim.dto.domain.PrpLlocklogDto;


public class XMLHandlerSYX {

	/**
	 * ���ݱ�����������XML�ַ��� 
	 * @param regist
	 * @param user
	 * @param password
	 * @return
	 */
	public static String getRegistXML(Regist regist,String user,String password){//2011
		Document document = null;
		document = getZJRegistDocument(regist, user, password);

		if(document!=null){
			document.setXMLEncoding("GBK");
			System.out.println("**********   ��ҵ�������͵� XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}
	/**
	 *  ����������������XML�ַ���
	 * @param claim
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception 
	 */
	public static String getClaimXML(Claim claim,String user,String password) throws Exception{//2011
		Document document = null;
		document = getZJClaimDocument(claim, user, password);

		if(document!=null){
			document.setXMLEncoding("GBK");	
			System.out.println("**********   ��ҵ�������͵� XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}
	/**
	 *  ���������������XML�ַ���
	 * @param claim
	 * @param user
	 * @param password
	 * @return
	 *//*
	public static String getCompensateXML(Compensate compensate,String user,String password){
		Document document = null;
		document=getZJCompensateDocument(compensate, user, password);

		if(document!=null){
			document.setXMLEncoding("GBK");
			System.out.println("**********   ��ҵ���㷢�͵� XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}*/
	
	/**
	 *  ����֧����������XML�ַ���,ȫ�����֧��
	 * @param claim
	 * @param user
	 * @param password
	 * @return
	 */
	public static String getPayinforXML(Payinfor payinfor,String user,String password){//2011
		Document document = null;
			document=getZJPayinforDocument(payinfor, user, password);
		if(document!=null){
			document.setXMLEncoding("GBK");
			System.out.println("**********   ��ҵ�⸶���͵� XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}
	
	public static String getCompensateVericforXML(CompensateVeric compensateVeric,String user,String password) throws Exception{//2011
		Document document = null;
			document=getZJCompensateVericforDocument(compensateVeric, user, password);
		if(document!=null){
			document.setXMLEncoding("GBK");
			System.out.println("**********   ��ҵ�⸶���͵� XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}
	
	/**
	 *  ���ݽ᰸��������XML�ַ���
	 * @param EndCase
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception 
	 */
	public static String getEndCaseXML(EndCase endCase,String user,String password) throws Exception{//2011
		Document document = null;

		document = getZJEndCaseDocument(endCase, user, password);

		if(document!=null){
			document.setXMLEncoding("GBK");
			System.out.println("**********   ��ҵ�᰸���͵� XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}
	
	/**
	 *  ���ݽ᰸׷�Ӷ�������XML�ַ���
	 * @param EndCase
	 * @param user
	 * @param password
	 * @return
	 */
	public static String getEndCaseAppendXML(EndCaseAppend endCaseApp,String user,String password){//2011
		Document document = null;

			document = getZJEndCaseAppendDocument(endCaseApp, user, password);

		if(document!=null){
			document.setXMLEncoding("gb2312");
			System.out.println("**********   ��ҵ�᰸׷�ӷ��͵� XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}

	/**
	 *  ���ݽ᰸׷�Ӷ�������XML�ַ���
	 * @param EndCase
	 * @param user
	 * @param password
	 * @return
	 */
	public static String getReCaseXML(ReCase reCase,String user,String password){//2011
		Document document = null;

			document = getZJReCaseDocument(reCase, user, password);

		if(document!=null){
			document.setXMLEncoding("gb2312");
			System.out.println("**********   ��ҵ�����ؿ����͵� XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}

	/**
	 *  ����ע��������������XML�ַ���
	 * @param EndCase
	 * @param user
	 * @param password
	 * @return
	 */
	public static String getCancelCaseXML(CancelCase cancelCase,String user,String password){//2011
		Document document = null;

			document = getZJCancelCaseDocument(cancelCase, user, password);

		if(document!=null){
			document.setXMLEncoding("GBK");
			System.out.println("**********   ��ҵע�����͵� XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}

	private static Document getZJRegistDocument(Regist regist,String user,String password){//2011
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET")
		.addAttribute("type", "REQUEST")
		.addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("Head");
		headElement.addElement("RequestType").setText(Iconstants.ZJRequstType.REGIST_SYX);
		headElement.addElement("User").setText(user==null?"":user);
		headElement.addElement("Password").setText(password==null?"":password);
		Element bodyElement = packetElement.addElement("Body");
		Element basePartElement = bodyElement.addElement("BasePart");
		basePartElement.addElement("ClaimSequenceNo").setText("");
		basePartElement.addElement("ConfirmSequenceNo").setText(regist.getConfirmSequenceNo());
		basePartElement.addElement("PolicyNo").setText(regist.getPolicyNO());
		basePartElement.addElement("ClaimNotificationNo").setText(regist.getRegistNo());
		/**
		 * ע��:����ʱ��˴�Ҫת��Ϊǿ�Ʊ���ƽ̨Ҫ����ַ�����ʽ
		 */
		basePartElement.addElement("NotificationTime").setText(new SimpleDateFormat("yyyyMMddHHmm").format(regist.getReportDate()));
		/**
		 * ע��:����ʱ��˴�Ҫת��Ϊǿ�Ʊ���ƽ̨Ҫ����ַ�����ʽ
		 */
		basePartElement.addElement("Reporter").setText(regist.getReportorName());
		basePartElement.addElement("DriverName").setText(regist.getDriverName());
		basePartElement.addElement("CertiType").setText(CodeTransfer.ZJCertiType.covrentPlatFormCode(regist.getCertiType()));
		basePartElement.addElement("CertiCode").setText(regist.getCertiCode());
		basePartElement.addElement("LossTime").setText(new SimpleDateFormat("yyyyMMddHHmm").format(regist.getDamageDate()));
		basePartElement.addElement("LossArea").setText(regist.getDamageAddress());
		basePartElement.addElement("LossDesc").setText(regist.getDamageContext());
		return document;
	}

	private static Document getZJClaimDocument(Claim claim,String user,String password) throws Exception{
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET")
		.addAttribute("type", "REQUEST")
		.addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("Head");
		headElement.addElement("RequestType").setText(Iconstants.ZJRequstType.CLAIM_SYX);
		headElement.addElement("User").setText(user);
		headElement.addElement("Password").setText(password);
		Element bodyElement = packetElement.addElement("Body");
		Element basePart = bodyElement.addElement("BasePart");
		basePart.addElement("ClaimSequenceNo").setText(claim.getClaimCode());
		basePart.addElement("ConfirmSequenceNo").setText(claim.getConfirmSequenceNo());
		basePart.addElement("PolicyNo").setText(claim.getPolicyNO());
		basePart.addElement("ClaimNotificationNo").setText(claim.getRegistNo());
		basePart.addElement("ClaimRegistrationNo").setText(claim.getClaimNo());
		if("4".equals(claim.getCaseType()))
		{
			basePart.addElement("ClaimType").setText("2");
		}else
		{
			basePart.addElement("ClaimType").setText("1");
		}
		basePart.addElement("AccidentLiability").setText(CodeTransfer.IndemnityDuty.covrentPlatFormCode(claim.getIndemnityDuty()));
		basePart.addElement("ClaimRegistrationTime").setText(new SimpleDateFormat("yyyyMMddHHmm").format(claim.getClaimDate()));
		basePart.addElement("EstimatedLossAmount").setText(new DecimalFormat("0.00").format(claim.getUnClaimAmount()));
		
		return document;
	}
	private static Document getZJPayinforDocument(Payinfor payinfor,String user,String password){//2011
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET")
		.addAttribute("type", "REQUEST")
		.addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("Head");
		headElement.addElement("RequestType").setText(Iconstants.ZJRequstType.PAYINFOR_SYX);
		headElement.addElement("User").setText(user);
		headElement.addElement("Password").setText(password);
		Element bodyElement = packetElement.addElement("Body");
		Element basePart = bodyElement.addElement("BasePart");
		/**������*/
		basePart.addElement("ClaimSequenceNo").setText(payinfor.getClaimCode());
		/**������*/
		basePart.addElement("ClaimNotificationNo").setText(payinfor.getRegistNo());
		/**Ͷ��ȷ����*/
		basePart.addElement("ConfirmSequenceNo").setText(payinfor.getConfirmSequenceNo());
		/**�⸶�ܽ��*/
		basePart.addElement("PayAmount").setText(new DecimalFormat("0.00").format(payinfor.getSumPaid()));
		/**���֧��������*/
		basePart.addElement("BankName").setText(payinfor.getBankName());
		/**���֧���˻���*/
		basePart.addElement("AccountNumber").setText(payinfor.getAccountNumber());
		/**���֧���˻���*/
		basePart.addElement("AccountName").setText(payinfor.getAccountName());
		
		List<Paydata> payDataList = payinfor.getPayDataList();
		for(Iterator itr = payDataList.iterator();itr.hasNext();){
			Paydata payData = (Paydata)itr.next();
			Element payDataElement = bodyElement.addElement("PayData");
			/**����տ��˻���*/
			payDataElement.addElement("AccountNumber").setText(payData.getRBankAcount());
			/**����տ����*/
			payDataElement.addElement("BankName").setText(payData.getRBankName());
			/**����տ��˻���*/
			payDataElement.addElement("AccountName").setText(payData.getRBankAcountName());
			/**����տ���֤������*/
			payDataElement.addElement("CentiType").setText(payData.getRBankCentiType());
			/**����տ�֤������*/
			payDataElement.addElement("CentiCode").setText(payData.getRBankCenticode());
			/**������*/
			payDataElement.addElement("RecoveryCode").setText(payData.getRecoveryCode());
			/**�⳥֧�����*/
			payDataElement.addElement("PayAmount").setText(new DecimalFormat("0.00").format(payData.getClaimAmount()));
			/**�⳥֧��ʱ�䣻��ȷ����*/
			payDataElement.addElement("PayDate").setText(new SimpleDateFormat("yyyyMMddHHmm").format(payData.getPayDate()));
		}
		
		return document;
	}
	private  static Document getZJEndCaseDocument(EndCase endCase,String user,String password) throws Exception//2011
	{
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET")
		.addAttribute("type", "REQUEST")
		.addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("Head");
		headElement.addElement("RequestType").setText(Iconstants.ZJRequstType.ENDCASE_SYX);
		headElement.addElement("User").setText(user);
		headElement.addElement("Password").setText(password);
		Element bodyElement = packetElement.addElement("Body");
		Element basePart = bodyElement.addElement("BasePart");
		
		basePart.addElement("ClaimSequenceNo").setText(String.valueOf(endCase.getClaimCode()));
		basePart.addElement("ConfirmSequenceNo").setText(String.valueOf(endCase.getConfirmSequenceNo()));
		basePart.addElement("PolicyNo").setText(String.valueOf(endCase.getPolicyNo()));
		basePart.addElement("ClaimNotificationNo").setText(endCase.getRegistNo());
		basePart.addElement("ClaimRegistrationNo").setText(endCase.getClaimNo());
		basePart.addElement("CaseID").setText(endCase.getEndCaseNo());
		basePart.addElement("ClaimAmount").setText(new DecimalFormat("0.00").format(endCase.getSumDutyPaid()));
		basePart.addElement("ClaimCloseTime").setText(new SimpleDateFormat("yyyyMMddHHmm").format(endCase.getEndCaseTime()));
		basePart.addElement("IsInsured").setText(endCase.isInsuredDuty() ? "1" : "0");
		basePart.addElement("ClaimType").setText(endCase.getClaimType());	
		basePart.addElement("PayCause").setText("");
		basePart.addElement("RefuseCause").setText(endCase.getRefusereason());
		basePart.addElement("DriverName").setText(endCase.getDriverName());
		basePart.addElement("CertiType").setText(endCase.getCertiType());
		basePart.addElement("CertiCode").setText(endCase.getCertiCode());
		Element accident = bodyElement.addElement("Accident");
		if (endCase.getAccidentInfor()!=null)
		{
			accident.addElement("LossTime").setText(new SimpleDateFormat("yyyyMMddHHmm").format(endCase.getAccidentInfor().getAccidentTime()));
			accident.addElement("LossArea").setText(endCase.getAccidentInfor().getAccidentPlace());
			accident.addElement("LossDesc").setText(endCase.getAccidentInfor().getAccidentDesc());
			accident.addElement("ManageDepartment").setText(endCase.getAccidentInfor().getHandleUnit());
			accident.addElement("AccidentLiability").setText(CodeTransfer.IndemnityDuty.covrentPlatFormCode(endCase.getAccidentInfor().getIndemnityDuty()));
			accident.addElement("OptionType").setText(CodeTransfer.OptionType.covrentPlatFormCode(endCase.getOptionType()));
			accident.addElement("AccidentType").setText(CodeTransfer.AccidentType.covrentPlatFormCode(endCase.getDamageCode()));
		}
		Element thirdVehicleData = bodyElement.addElement("ThirdVehicleData");
		/*for (int i = 0; i < endCase.getThirdCarList().size(); i++) {
			ThirdCar thirdCar = (ThirdCar) endCase.getThirdCarList().get(i);
			thirdVehicleData.addElement("LicensePlateNo").setText(thirdCar.getLicenseNo());
			thirdVehicleData.addElement("LicensePlateType").setText("");
			thirdVehicleData.addElement("VehicleType").setText("");
			thirdVehicleData.addElement("PolicyNo").setText("");
			thirdVehicleData.addElement("InsurerCode").setText("");
			thirdVehicleData.addElement("DriverName").setText("");
			thirdVehicleData.addElement("CertiType").setText("");
			thirdVehicleData.addElement("CertiCode").setText("");
		}*/
		if(endCase.getCarSumPaid()>0)
		{
			Element claimCoverData = bodyElement.addElement("ClaimCoverData");
			claimCoverData.addElement("liabilityRate").setText("");
			claimCoverData.addElement("LossFeeType").setText("1");
			claimCoverData.addElement("CoverageCode").setText("");
			claimCoverData.addElement("LossAmount").setText(new DecimalFormat("0.00").format(endCase.getCarSumLoss()));
			claimCoverData.addElement("ClaimAmount").setText(new DecimalFormat("0.00").format(endCase.getCarSumPaid()));
			for (Iterator it=endCase.getCarLossList().iterator(); it.hasNext();)
			{
				CarLoss carLoss = (CarLoss)it.next();
				Element DetailData = claimCoverData.addElement("DetailData");
				DetailData.addElement("IndemnityCode").setText(CodeTransfer.CarLossType.covrentPlatFormCode(carLoss.getIndemnityCode()));
				DetailData.addElement("LossAmount").setText(new DecimalFormat("0.00").format(carLoss.getSumLoss()));
				DetailData.addElement("ClaimAmount").setText(new DecimalFormat("0.00").format(carLoss.getSumDuty()));
				DetailData.addElement("liabilityRate").setText("");
			}
		}
		if(endCase.getPersonSumPaid()>0)
		{
			Element claimCoverData = bodyElement.addElement("ClaimCoverData");
			claimCoverData.addElement("liabilityRate").setText("");
			claimCoverData.addElement("LossFeeType").setText("3");
			claimCoverData.addElement("CoverageCode").setText("");
			claimCoverData.addElement("LossAmount").setText(new DecimalFormat("0.00").format(endCase.getPersonSumLoss()));
			claimCoverData.addElement("ClaimAmount").setText(new DecimalFormat("0.00").format(endCase.getPersonSumPaid()));
			for (Iterator it=endCase.getPersonLossList().iterator(); it.hasNext();)
			{
				PersonLoss personLoss=(PersonLoss)it.next();
				Element DetailData = claimCoverData.addElement("DetailData");
				DetailData.addElement("IndemnityCode").setText(CodeTransfer.PersonLossType.covrentPlatFormCode(personLoss.getIndemnityCode()));
				DetailData.addElement("LossAmount").setText(new DecimalFormat("0.00").format(personLoss.getSumLoss()));
				DetailData.addElement("ClaimAmount").setText(new DecimalFormat("0.00").format(personLoss.getSumDuty()));
				DetailData.addElement("liabilityRate").setText("");
			}
		}
		if(endCase.getPropSumPaid()>0)
		{
			Element claimCoverData = bodyElement.addElement("ClaimCoverData");
			claimCoverData.addElement("liabilityRate").setText("");
			claimCoverData.addElement("LossFeeType").setText("2");
			claimCoverData.addElement("CoverageCode").setText("");
			claimCoverData.addElement("LossAmount").setText(new DecimalFormat("0.00").format(endCase.getPropSumLoss()));
			claimCoverData.addElement("ClaimAmount").setText(new DecimalFormat("0.00").format(endCase.getPropSumPaid()));
			for (Iterator it=endCase.getPropLossList().iterator(); it.hasNext();)
			{
				PropLoss propLoss=(PropLoss)it.next();
				Element DetailData = claimCoverData.addElement("DetailData");
				DetailData.addElement("IndemnityCode").setText("400");
				DetailData.addElement("LossAmount").setText(new DecimalFormat("0.00").format(propLoss.getSumLoss()));
				DetailData.addElement("ClaimAmount").setText(new DecimalFormat("0.00").format(propLoss.getSumDuty()));
				DetailData.addElement("liabilityRate").setText("");
			}
		}
		if(endCase.getChargePaid()>0)
		{
			Element claimCoverData = bodyElement.addElement("ClaimCoverData");
			claimCoverData.addElement("liabilityRate").setText("");
			claimCoverData.addElement("LossFeeType").setText("4");
			claimCoverData.addElement("CoverageCode").setText("");
			claimCoverData.addElement("LossAmount").setText(new DecimalFormat("0.00").format(endCase.getChargeSumLoss()));
			claimCoverData.addElement("ClaimAmount").setText(new DecimalFormat("0.00").format(endCase.getChargeSumPaid()));
			for (Iterator it=endCase.getPrplchargeList().iterator(); it.hasNext();)
			{
				PrpLchargeDto prpLchargeDto=(PrpLchargeDto)it.next();
				Element DetailData = claimCoverData.addElement("DetailData");
				DetailData.addElement("IndemnityCode").setText(CodeTransfer.FeeLossType.covrentPlatFormCode(prpLchargeDto.getChargeCode()));
				DetailData.addElement("LossAmount").setText(new DecimalFormat("0.00").format(prpLchargeDto.getChargeAmount()));
				DetailData.addElement("ClaimAmount").setText(new DecimalFormat("0.00").format(prpLchargeDto.getSumRealPay()));
				DetailData.addElement("liabilityRate").setText("");
			}
		}
		return document;
		
	}
	

	private static Document getZJEndCaseAppendDocument(EndCaseAppend endCaseApp,String user,String password)//2011
	{
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET")
		.addAttribute("type", "REQUEST")
		.addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("Head");
		headElement.addElement("RequestType").setText(Iconstants.ZJRequstType.ENDCASE_APPEND_SYX);
		headElement.addElement("User").setText(user);
		headElement.addElement("Password").setText(password);
		Element bodyElement = packetElement.addElement("Body");
		Element basePart = bodyElement.addElement("BasePart");
		basePart.addElement("ClaimSequenceNo").setText(endCaseApp.getClaimCode());
		basePart.addElement("SerialNo").setText(endCaseApp.getSerialNo());
		basePart.addElement("PolicyNo").setText(endCaseApp.getPolicyNO());
		basePart.addElement("ClaimNotificationNo").setText(endCaseApp.getRegistNo());
		basePart.addElement("ClaimRegistrationNo").setText(endCaseApp.getClaimNo());
		basePart.addElement("CaseID").setText(endCaseApp.getCaseNo());
		//add by shaofan 20100920 for REQ0001487 �ؿ��ⰸ�᰸ʱ������ start
		basePart.addElement("ClaimReopenDate").setText(new SimpleDateFormat("yyyyMMddHHmm").format(endCaseApp.getRecaseDate()));
		//add by shaofan 20100920 for REQ0001487 �ؿ��ⰸ�᰸ʱ������ end
		basePart.addElement("ClaimReopenDesc").setText(endCaseApp.getRecaseReason());
		
		for(Iterator it=endCaseApp.getEndCaseAppSituationList().iterator(); it.hasNext();)
		{
			EndCaseAppSituation endCaseAppSituation=(EndCaseAppSituation)it.next();
			Element claimCoverData = bodyElement.addElement("ClaimCoverData");
			claimCoverData.addElement("LossFeeType").setText(endCaseAppSituation.getLossType());
			claimCoverData.addElement("ClaimAmount").setText(new DecimalFormat("0.00").format(endCaseAppSituation.getAppPaySum()));		
		}
		
		return document;
	}
	

	private static Document getZJCancelCaseDocument(CancelCase cancelCase,String user,String password)//2011
	{
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET")
		.addAttribute("type", "REQUEST")
		.addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("Head");
		headElement.addElement("RequestType").setText(Iconstants.ZJRequstType.CANCEL_CASE);
		headElement.addElement("User").setText(user);
		headElement.addElement("Password").setText(password);
		Element bodyElement = packetElement.addElement("Body");
		Element basePart = bodyElement.addElement("BasePart");
		basePart.addElement("ConfirmSequenceNo").setText(cancelCase.getConfirmSequenceNo());
		basePart.addElement("ClaimSequenceNo").setText(cancelCase.getClaimCode());
		basePart.addElement("CancelType").setText(cancelCase.getCancelType());
		basePart.addElement("CancelCause").setText(cancelCase.getCancelCause());
		basePart.addElement("CancelDesc").setText("");
		return document;
	}
	private static Document getZJReCaseDocument(ReCase reCase,String user,String password)//2011
	{
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET")
		.addAttribute("type", "REQUEST")
		.addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("Head");
		headElement.addElement("RequestType").setText(Iconstants.ZJRequstType.RECASE_SYX);
		headElement.addElement("User").setText(user);
		headElement.addElement("Password").setText(password);
		Element bodyElement = packetElement.addElement("Body");
		Element basePart = bodyElement.addElement("BasePart");
		basePart.addElement("ConfirmSequenceNo").setText(reCase.getConfirmSequenceNo());
		basePart.addElement("ClaimSequenceNo").setText(reCase.getClaimCode());
		basePart.addElement("ClaimNotificationNo").setText(reCase.getRegistNo());
		basePart.addElement("ReopenCause").setText(reCase.getReOpenCause());
		basePart.addElement("ReopenDate").setText(new SimpleDateFormat("yyyyMMddHHmm").format(reCase.getReOpenDate()));
		return document;
	}
	public static ReturnInfo getReturnFromXMLConsole(String xmlStr,String reqType) throws Exception{//2011
		ReturnInfo returnInfo=null;
		if(Iconstants.ZJRequstType.REGIST_SYX.equals(reqType)){
			returnInfo = getZJReturnRegistFromXML(xmlStr);
		}else if(Iconstants.ZJRequstType.CLAIM_SYX.equals(reqType)){
				returnInfo = getZJReturnClaimFromXML(xmlStr);
		}else if(Iconstants.ZJRequstType.ENDCASE_SYX.equals(reqType)){
				returnInfo = getZJReturnEndCaseFromXML(xmlStr);
		}else if(Iconstants.ZJRequstType.CANCEL_CASE.equals(reqType)){
				returnInfo = getZJReturnCancelCaseFromXML(xmlStr);
		}else if(Iconstants.ZJRequstType.ENDCASE_APPEND_SYX.equals(reqType)){
				returnInfo = getZJReturnEndCaseAppendFromXML(xmlStr);
		}else if(Iconstants.ZJRequstType.PAYINFOR_SYX.equals(reqType)){
			returnInfo =getZJReturnPayinforFromXML(xmlStr);
		}else if(Iconstants.ZJRequstType.COMPENSATEVERIC_SYX.equals(reqType)){
			returnInfo =getZJReturnCompensateVericFromXML(xmlStr);
		}
		return returnInfo;
	}

	public static ReturnInfo getZJReturnRegistFromXML(String xmlStr) throws ParseException, DocumentException{
		ReturnInfo returnInfo= null;
		HistoryClaim historyClaim = null;
		try {
			returnInfo=new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			//�õ����ڵ�PACKET 
			Element packet = document.getRootElement();
			//�õ�HEAD�ڵ�
			for (Iterator it=packet.elementIterator("Head"); it.hasNext();)
			{
				Element head=(Element)it.next();
				returnInfo.setRequestType(parseNode(head.selectSingleNode("RequestType")));
				returnInfo.setReturnType(parseNode(head.selectSingleNode("ResponseCode")));
				returnInfo.setErrorCode(parseNode(head.selectSingleNode("ErrorCode")));
				returnInfo.setErrorMessage(parseNode(head.selectSingleNode("ErrorMessage")));
			}
			//�õ�BODY�ڵ�
			for (Iterator bit=packet.elementIterator("Body"); bit.hasNext();)
			{
				Element body=(Element)bit.next();
				//�õ�BASE_PART�ڵ�
				Element basepart=(Element)body.selectSingleNode("BasePart");
				System.out.println(parseNode(basepart.selectSingleNode("ClaimSequenceNo")));
				returnInfo.setClaimCode(parseNode(basepart.selectSingleNode("ClaimSequenceNo")));
				//����CLAIM_DATA�б�
				Iterator it = (Iterator)body.selectSingleNode("ClaimData");
				if(it!=null)
				{
					while (it.hasNext())
					{
						historyClaim=new HistoryClaim();
						Element claimDate=(Element)it.next();
						historyClaim.setClaimCompany(parseNode(claimDate.selectSingleNode("InsurerCode")));
						historyClaim.setCarMark(parseNode(claimDate.selectSingleNode("LicensePlateNo")));
						historyClaim.setVehicleType(parseNode(claimDate.selectSingleNode("LicensePlateType")));
						historyClaim.setRegistNo(parseNode(claimDate.selectSingleNode("ClaimNotificationNo")));
						historyClaim.setClaimNo(parseNode(claimDate.selectSingleNode("ClaimRegistrationNo")));
						historyClaim.setEndCaseno(parseNode(claimDate.selectSingleNode("CaseID")));
						historyClaim.setPolicyNo(parseNode(claimDate.selectSingleNode("PolicyNo")));
						historyClaim.setAccidentTime(getDate(claimDate,"LossTime"));
						historyClaim.setRegistTime(getDate(claimDate,"NotificationTime"));
						historyClaim.setEndCaseTime(getDate(claimDate,"ClaimCloseTime"));
						historyClaim.setUnClaimAmount(parseDouble(parseNode(claimDate.selectSingleNode("EstimatedLossAmount"))));
						historyClaim.setClaimAmount(parseDouble(parseNode(claimDate.selectSingleNode("ClaimAmount"))));
						historyClaim.setCaseStatus(parseNode(claimDate.selectSingleNode("Status")));
						historyClaim.setAccidentPlace(parseNode(claimDate.selectSingleNode("LossArea")));
						historyClaim.setAccidentDesc(parseNode(claimDate.selectSingleNode("LossDesc")));
						historyClaim.setIndemnityDuty(parseNode(claimDate.selectSingleNode("AccidentLiability")));
						returnInfo.addHistoryClaim(historyClaim);
					}
				}
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return returnInfo;
	}
	

	public static ReturnInfo getZJReturnClaimFromXML(String xmlStr) throws ParseException, DocumentException{
		ReturnInfo returnInfo= null;
		HistoryClaim historyClaim = null;
		try {
			returnInfo=new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			//�õ����ڵ�PACKET 
			Element packet = document.getRootElement();
			//�õ�HEAD�ڵ�
			for (Iterator it=packet.elementIterator("Head"); it.hasNext();)
			{
				Element head=(Element)it.next();
				returnInfo.setRequestType(parseNode(head.selectSingleNode("RequestType")));
				returnInfo.setReturnType(parseNode(head.selectSingleNode("ResponseCode")));
				returnInfo.setErrorCode(parseNode(head.selectSingleNode("ErrorCode")));
				returnInfo.setErrorMessage(parseNode(head.selectSingleNode("ErrorMessage")));
			}
			
			//�õ�BODY�ڵ�
			for (Iterator bit=packet.elementIterator("Body"); bit.hasNext();)
			{
				Element body=(Element)bit.next();
				//�õ�BASE_PART�ڵ�
				Element basepart=(Element)body.selectSingleNode("BasePart");
				returnInfo.setClaimCode(parseNode(basepart.selectSingleNode("ClaimSequenceNo")));
				//����CLAIM_DATA�б�
				Iterator it = (Iterator)body.selectSingleNode("ClaimData");
				if(it!=null)
				{
					while (it.hasNext())
					{
						historyClaim=new HistoryClaim();
						Element claimDate=(Element)it.next();
						historyClaim.setClaimCompany(parseNode(claimDate.selectSingleNode("ClaimCompany")));
						historyClaim.setVehicleType(parseNode(claimDate.selectSingleNode("LicensePlateType")));
						historyClaim.setCarMark(parseNode(claimDate.selectSingleNode("LicensePlateNo")));
						historyClaim.setIsInsuredCar(parseNode(claimDate.selectSingleNode("IsInsuredCar")));
						historyClaim.setRegistNo(parseNode(claimDate.selectSingleNode("ClaimNotificationNo")));
						historyClaim.setClaimNo(parseNode(claimDate.selectSingleNode("ClaimRegistrationNo")));
						historyClaim.setEndCaseno(parseNode(claimDate.selectSingleNode("CaseID")));
						historyClaim.setPolicyNo(parseNode(claimDate.selectSingleNode("PolicyNo")));
						historyClaim.setCoverageType(parseNode(claimDate.selectSingleNode("COVERAGE_TYPE")));
						historyClaim.setAccidentTime(getDate(claimDate,"LossTime"));
						historyClaim.setRegistTime(getDate(claimDate,"NotificationTime"));
						historyClaim.setEndCaseTime(getDate(claimDate,"ClaimCloseTime"));
						historyClaim.setUnClaimAmount(parseDouble(parseNode(claimDate.selectSingleNode("EstimatedLossAmount"))));
						historyClaim.setClaimAmount(parseDouble(parseNode(claimDate.selectSingleNode("ClaimAmount"))));
						historyClaim.setCaseStatus(parseNode(claimDate.selectSingleNode("Status")));
						historyClaim.setAccidentPlace(parseNode(claimDate.selectSingleNode("LossArea")));
						historyClaim.setAccidentDesc(parseNode(claimDate.selectSingleNode("LossDesc")));
						historyClaim.setIndemnityDuty(parseNode(claimDate.selectSingleNode("AccidentLiability")));
						returnInfo.addHistoryClaim(historyClaim);
					}
				}
			}
			
		}catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		return returnInfo;
	}
	/**
	 * ����Document��������ReCaseDTO����
	 * @param xmlStr
	 * @return
	 * @throws DocumentException 
	 */
	public static ReturnInfo getZJReturnReCaseFromXML(String xmlStr,ReCase reCase) throws DocumentException{
		ReturnInfo returnInfo=null;
		PrpLlocklogDto locked=null;
		try
		{
			returnInfo=new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			//�õ����ڵ�PACKET 
			Element packet = document.getRootElement();
			//�õ�HEAD�ڵ�
			for (Iterator it=packet.elementIterator("Head"); it.hasNext();)
			{
				Element head=(Element)it.next();
				returnInfo.setRequestType(parseNode(head.selectSingleNode("RequestType")));
				returnInfo.setReturnType(parseNode(head.selectSingleNode("ResponseCode")));
				returnInfo.setErrorMessage(parseNode(head.selectSingleNode("ErrorMessage")));
			}
//			�õ�BODY�ڵ�
			for (Iterator bit=packet.elementIterator("Body"); bit.hasNext();)
			{
				Element body=(Element)bit.next();
				//����LOCKED_LIST�б�
				int index = 1;
				for (Iterator it = body.elementIterator("LockedData"); it.hasNext();)
				{
					locked = new PrpLlocklogDto();
					Element lockedData=(Element)it.next();
					locked.setNodeType("recase");
					locked.setRecoveryCode(parseNode(lockedData.selectSingleNode("RecoveryCode")));
					locked.setRecoverStatus(parseNode(lockedData.selectSingleNode("RecoverStatus")));
					locked.setInsurerCode(parseNode(lockedData.selectSingleNode("InsurerCode")));
					locked.setInsurerArea(parseNode(lockedData.selectSingleNode("InsurerArea")));
					locked.setCoverageType(parseNode(lockedData.selectSingleNode("CoverageType")));
					locked.setPolicyNo(parseNode(lockedData.selectSingleNode("PolicyNo")));
					locked.setClaimNotificationNo(parseNode(lockedData.selectSingleNode("ClaimNotificationNo")));
					locked.setClaimStatus(parseNode(lockedData.selectSingleNode("ClaimStatus")));
					locked.setRecoveryCodeStatus(parseNode(lockedData.selectSingleNode("RecoveryCodeStatus")));
					locked.setClaimProgress(parseNode(lockedData.selectSingleNode("ClaimProGress")));
					locked.setRegistNo(reCase.getRegistNo());
					returnInfo.addLocked(locked);
				}	
			}

		}catch (DocumentException e) {
			e.printStackTrace();
			throw e;
		}
		return returnInfo;
	}

	public static ReturnInfo getZJReturnCompensateFromXML(String xmlStr) throws ParseException, DocumentException{
		ReturnInfo returnInfo= null;
		try {
			returnInfo=new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			//�õ����ڵ�PACKET 
			Element packet = document.getRootElement();
			//�õ�HEAD�ڵ�
			for (Iterator it=packet.elementIterator("Head"); it.hasNext();)
			{
				Element head=(Element)it.next();
				returnInfo.setRequestType(parseNode(head.selectSingleNode("RequestType")));
				returnInfo.setReturnType(parseNode(head.selectSingleNode("ResponseCode")));
				returnInfo.setErrorCode(parseNode(head.selectSingleNode("ErrorCode")));
				returnInfo.setErrorMessage(parseNode(head.selectSingleNode("ErrorMessage")));
			}
		}catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		return returnInfo;
	}

	public static ReturnInfo getZJReturnCompensateVericFromXML(String xmlStr) throws ParseException, DocumentException{//2011
		ReturnInfo returnInfo= null;
		PrpLlocklogDto prpLlocklogDto = null;
		try {
			returnInfo=new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			//�õ����ڵ�PACKET 
			Element packet = document.getRootElement();
			//�õ�HEAD�ڵ�
			for (Iterator it=packet.elementIterator("Head"); it.hasNext();)
			{
				Element head=(Element)it.next();
				returnInfo.setRequestType(parseNode(head.selectSingleNode("RequestType")));
				returnInfo.setReturnType(parseNode(head.selectSingleNode("ResponseCode")));
				returnInfo.setErrorCode(parseNode(head.selectSingleNode("ErrorCode")));
				returnInfo.setErrorMessage(parseNode(head.selectSingleNode("ErrorMessage")));
			}
			
			//�õ�BODY�ڵ�
			for (Iterator bit=packet.elementIterator("Body"); bit.hasNext();)
			{
				Element body=(Element)bit.next();
				//�õ�BASE_PART�ڵ�
				//����LockedData�б�
				Iterator it = (Iterator)body.elementIterator("LockedData");
				if(it!=null)
				{
					while (it.hasNext())
					{
						prpLlocklogDto = new PrpLlocklogDto();
						Element lockedData=(Element)it.next();
						prpLlocklogDto.setNodeType("veric");
						prpLlocklogDto.setRecoveryCode(parseNode(lockedData.selectSingleNode("RecoveryCode")));
						prpLlocklogDto.setRecoverStatus(parseNode(lockedData.selectSingleNode("RecoverStatus")));
						prpLlocklogDto.setInsurerCode(parseNode(lockedData.selectSingleNode("InsurerCode")));
						prpLlocklogDto.setInsurerArea(parseNode(lockedData.selectSingleNode("InsurerArea")));
						prpLlocklogDto.setCoverageType(parseNode(lockedData.selectSingleNode("CoverageType")));
						prpLlocklogDto.setPolicyNo(parseNode(lockedData.selectSingleNode("PolicyNo")));
						prpLlocklogDto.setClaimNotificationNo(parseNode(lockedData.selectSingleNode("ClaimNotificationNo")));
						prpLlocklogDto.setClaimStatus(parseNode(lockedData.selectSingleNode("ClaimStatus")));
						prpLlocklogDto.setRecoveryCodeStatus(parseNode(lockedData.selectSingleNode("RecoveryCodeStatus")));
						prpLlocklogDto.setClaimProgress(parseNode(lockedData.selectSingleNode("ClaimProgress")));
						returnInfo.addLocked(prpLlocklogDto);
					}
				}
			}	
		}catch (DocumentException e) {
			e.printStackTrace();
			throw e;
		}
		return returnInfo;
	}
	public static ReturnInfo getZJReturnPayinforFromXML(String xmlStr) throws ParseException, DocumentException{//2011
		ReturnInfo returnInfo= null;
		try {
			returnInfo=new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			//�õ����ڵ�PACKET 
			Element packet = document.getRootElement();
			//�õ�HEAD�ڵ�
			for (Iterator it=packet.elementIterator("Head"); it.hasNext();)
			{
				Element head=(Element)it.next();
				returnInfo.setRequestType(parseNode(head.selectSingleNode("RequestType")));
				returnInfo.setReturnType(parseNode(head.selectSingleNode("ResponseCode")));
				returnInfo.setErrorCode(parseNode(head.selectSingleNode("ErrorCode")));
				returnInfo.setErrorMessage(parseNode(head.selectSingleNode("ErrorMessage")));
			}
			/**���body�ڵ���Ϣ*/
			for (Iterator bit=packet.elementIterator("Body"); bit.hasNext();){
				Element body=(Element)bit.next();
				List<PrpLlocklogDto> prpLlocklogList = returnInfo.getLocked();
				PrpLlocklogDto prpLlocklogDto = null;
				Iterator lockedDataItr = (Iterator)body.elementIterator("LockedData");
				if(lockedDataItr!=null){
					while(lockedDataItr.hasNext()){
						prpLlocklogDto = new PrpLlocklogDto();
						prpLlocklogList.add(prpLlocklogDto);
						Element LockedDataNode = (Element)lockedDataItr.next();
						
						prpLlocklogDto.setRecoveryCode(parseNode(LockedDataNode.selectSingleNode("RecoveryCode")));
						prpLlocklogDto.setInputDate(DateTime.current());
						prpLlocklogDto.setNodeType("payment");
						prpLlocklogDto.setRiskCode("0506");
						prpLlocklogDto.setRecoverStatus(parseNode(LockedDataNode.selectSingleNode("RecoverStatus")));
						prpLlocklogDto.setInsurerCode(parseNode(LockedDataNode.selectSingleNode("InsurerCode")));
						prpLlocklogDto.setInsurerArea(parseNode(LockedDataNode.selectSingleNode("InsurerArea")));
						prpLlocklogDto.setCoverageType(parseNode(LockedDataNode.selectSingleNode("CoverageType")));
						prpLlocklogDto.setPolicyNo(parseNode(LockedDataNode.selectSingleNode("PolicyNo")));
						prpLlocklogDto.setClaimNotificationNo(parseNode(LockedDataNode.selectSingleNode("ClaimNotificationNo")));
						prpLlocklogDto.setClaimStatus(parseNode(LockedDataNode.selectSingleNode("ClaimStatus")));
						prpLlocklogDto.setRecoveryCodeStatus(parseNode(LockedDataNode.selectSingleNode("RecoveryCodeStatus")));
						prpLlocklogDto.setClaimProgress(parseNode(LockedDataNode.selectSingleNode("ClaimProgress"))==null?"":parseNode(LockedDataNode.selectSingleNode("ClaimProgress")));
					}
				}
			}
			
		}catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		return returnInfo;
	}

	private static Document getZJCompensateVericforDocument(CompensateVeric compensateVeric1,String user,String password) throws Exception{//2011
		Document document = DocumentHelper.createDocument();
		String FGDate = AppConfig.get("sysconst.FG_DATE");
		String dateTime = new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY).toString();
		PubTools pubTools  = new PubTools();
		Element packetElement = document.addElement("PACKET")
		.addAttribute("type", "REQUEST")
		.addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("Head");
		headElement.addElement("RequestType").setText(Iconstants.ZJRequstType.COMPENSATEVERIC_SYX);
		headElement.addElement("User").setText(user);
		headElement.addElement("Password").setText(password);
		Element bodyElement = packetElement.addElement("Body");
		Element basePart = bodyElement.addElement("BasePart");
		basePart.addElement("ClaimSequenceNo").setText(compensateVeric1.getClaimCode());//
		basePart.addElement("ClaimNotificationNo").setText(compensateVeric1.getRegistNo());
		basePart.addElement("ConfirmSequenceNo").setText(compensateVeric1.getConfirmSequenceNo());//
		basePart.addElement("IsInvolving").setText(compensateVeric1.getIsInvolving());// �Ƿ�����
		ArrayList compensateVericList = (ArrayList)compensateVeric1.getCompensateVericList();
		CompensateVeric compensateVeric = null;
		if(compensateVericList.size() > 0){
			for(int index = 0; index < compensateVericList.size();index++){
				compensateVeric = (CompensateVeric)compensateVericList.get(index);
				Element AdjustmentData = bodyElement.addElement("AdjustmentData");
				AdjustmentData.addElement("AdjustmentCode").setText(compensateVeric.getCompensateNo());
			    if(pubTools.compareDate(dateTime,FGDate)>-1){
			    	AdjustmentData.addElement("OtherFee").setText(compensateVeric.getOtherFee());
			    }
				AdjustmentData.addElement("UnderWriteDesc").setText(compensateVeric.getUnderWriteDesc());
				AdjustmentData.addElement("ClaimAmount").setText(new DecimalFormat("0.00").format(compensateVeric.getSumPaid()));
				AdjustmentData.addElement("UnderWriteEndTime").setText(compensateVeric.getUnderWriteEnd());
				
				ArrayList<ClaimCover> claimCoverList = (ArrayList)compensateVeric.getClaimCoverList();
				ClaimCover claimCover = null;
				for(int i = 0;i < claimCoverList.size();i++){
					claimCover = claimCoverList.get(i);
					Element ClaimCoverData = AdjustmentData.addElement("ClaimCoverData");
					ClaimCoverData.addElement("RecoveryOrPayFlag").setText(claimCover.getRecoveryOrPayFlag());
					ClaimCoverData.addElement("CoverageCode").setText(claimCover.getCoverageCode());
					ClaimCoverData.addElement("LossFeeType").setText(claimCover.getClaimFeeType());
					ClaimCoverData.addElement("LiabilityRate").setText(claimCover.getLiabilityRate());
					ClaimCoverData.addElement("ClaimAmount").setText(new DecimalFormat("0.00").format(Double.parseDouble(claimCover.getClaimAmount())));
					ClaimCoverData.addElement("SalvageFee").setText(claimCover.getSalvageFee());
				    if(pubTools.compareDate(dateTime,FGDate)>-1){
				    	ClaimCoverData.addElement("LossAmount").setText(new DecimalFormat("0.00").format(Double.parseDouble(claimCover.getLossAmount())));
				    }
				    if(claimCover.getIsDeviceItem()!=null && !"".equals(claimCover.getIsDeviceItem())){//ȫ���ͳ����գ�"�Ƿ������豸ƴ��"
				    	ClaimCoverData.addElement("IsDeviceItem").setText(claimCover.getIsDeviceItem());
				    }
				}
				
				ArrayList<RecoveryOrPay> recoveryOrPayList = (ArrayList)compensateVeric.getRecoveryOrPayList();
				RecoveryOrPay recoveryOrPay = null;
				for(int i = 0;i < recoveryOrPayList.size();i++){
					recoveryOrPay = recoveryOrPayList.get(i);
					Element RecoveryOrPayData = AdjustmentData.addElement("RecoveryOrPayData");
					RecoveryOrPayData.addElement("SerialNo").setText(""+recoveryOrPay.getSerialNo());
					RecoveryOrPayData.addElement("RecoveryOrPayFlag").setText(recoveryOrPay.getRecoveryOrPayFlag());
					RecoveryOrPayData.addElement("RecoveryOrPayType").setText(recoveryOrPay.getRecoveryOrPayType());
					RecoveryOrPayData.addElement("RecoveryOrPayMan").setText(recoveryOrPay.getRecoveryOrPayMan());
					RecoveryOrPayData.addElement("RecoveryCode").setText(recoveryOrPay.getRecoveryCode());
					RecoveryOrPayData.addElement("RecoveryOrPayAmount").setText(new DecimalFormat("0.00").format(Double.parseDouble(recoveryOrPay.getRecoveryOrPayAmount())));
					RecoveryOrPayData.addElement("RecoveryRemark").setText(recoveryOrPay.getRecoveryRemark());
				}
			}
		}
		return document;
	}

	public static ReturnInfo getZJReturnEndCaseFromXML(String xmlStr) throws DocumentException{
		ReturnInfo returnEndCase=null;
		try
		{
			returnEndCase=new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			//�õ����ڵ�PACKET 
			Element packet = document.getRootElement();
			//�õ�HEAD�ڵ�
			for (Iterator it=packet.elementIterator("Head"); it.hasNext();)
			{
				Element head=(Element)it.next();
				returnEndCase.setRequestType(parseNode(head.selectSingleNode("RequestType")));
				returnEndCase.setReturnType(parseNode(head.selectSingleNode("ResponseCode")));
				returnEndCase.setErrorCode(parseNode(head.selectSingleNode("ErrorCode")));
				returnEndCase.setErrorMessage(parseNode(head.selectSingleNode("ErrorMessage")));
			}
			
//			�õ�BODY�ڵ�
			for (Iterator bit=packet.elementIterator("Body"); bit.hasNext();)
			{
				Element body=(Element)bit.next();

				//�õ�BASE_PART�ڵ�
				Element basepart=(Element)body.selectSingleNode("BasePart");
				returnEndCase.setClaimCode(parseNode(basepart.selectSingleNode("ClaimSequenceNo")));
				//add by shaofan 20110120 REQ00003171���㽭��ҵ��ƽ̨�᰸���ӽ᰸ȷ���� start
				returnEndCase.setClaimConfirmCode(parseNode(basepart.selectSingleNode("ClaimConfirmCode")));
				//add by shaofan 20110120 REQ00003171���㽭��ҵ��ƽ̨�᰸���ӽ᰸ȷ���� end				
			}
			
		}catch (DocumentException e) {
			e.printStackTrace();
			throw e;
		}
		return returnEndCase;
	}

	/**
	 * ����Document��������EndCaseAppendDTO����
	 * @param xmlStr
	 * @return
	 * @throws DocumentException 
	 */
	public static ReturnInfo getZJReturnEndCaseAppendFromXML(String xmlStr) throws DocumentException{
		ReturnInfo returnInfo=null;
		try
		{
			returnInfo=new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			//�õ����ڵ�PACKET 
			Element packet = document.getRootElement();
			//�õ�HEAD�ڵ�
			for (Iterator it=packet.elementIterator("Head"); it.hasNext();)
			{
				Element head=(Element)it.next();
				returnInfo.setRequestType(parseNode(head.selectSingleNode("RequestType")));
				returnInfo.setReturnType(parseNode(head.selectSingleNode("ResponseCode")));
				returnInfo.setErrorMessage(parseNode(head.selectSingleNode("ErrorMessage")));
			}
			
		}catch (DocumentException e) {
			e.printStackTrace();
			throw e;
		}
		return returnInfo;
	}



	public static ReturnInfo getZJReturnCancelCaseFromXML(String xmlStr) throws DocumentException{
		ReturnInfo returnInfo=null;
		try
		{
			returnInfo=new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			//�õ����ڵ�PACKET 
			Element packet = document.getRootElement();
			//�õ�HEAD�ڵ�
			for (Iterator it=packet.elementIterator("Head"); it.hasNext();)
			{
				Element head=(Element)it.next();
				returnInfo.setRequestType(parseNode(head.selectSingleNode("RequestType")));
				returnInfo.setReturnType(parseNode(head.selectSingleNode("ResponseCode")));
				returnInfo.setErrorCode(parseNode(head.selectSingleNode("ErrorCode")));
				returnInfo.setErrorMessage(parseNode(head.selectSingleNode("ErrorMessage")));
			}
			
		}catch (DocumentException e) {
			e.printStackTrace();
			throw e;
		}
		return returnInfo;
	}
	
	private static Date getDate(Element element,String nodeName) throws ParseException{

		String dateString = "";
		if(element.selectSingleNode(nodeName)!=null){
			dateString = element.selectSingleNode(nodeName).getText();
		}
		String dateFormat = "";
		if(dateString.length()==0){
			return null;
		}else if(dateString.length()==8){
			dateFormat = "yyyyMMdd";
		}else if(dateString.length()==10){
			dateFormat = "yyyyMMddHH";
		}else if(dateString.length()==12){
			dateFormat = "yyyyMMddHHmm";
		}else if(dateString.length()==14){
			dateFormat = "yyyyMMddHHmmss";
		}else{
			throw new ParseException("���ص������ַ�����ʽ����ȷ���޷�����.�������ַ�����"+dateString+"]", 0);
		}
		
		return new SimpleDateFormat(dateFormat).parse(dateString);
	}
	
	private static String parseNode(Node node)
	{
		if (node==null)
		{
			return null;
		}
		return node.getText();
	}
	
	private static double parseDouble(String data)
	{
		if (data!=null && data!="")
		{
			return Double.parseDouble(data);
		}
		return 0;
	}
	private static Document getZJAccountNoDocument(Accounts accounts,String user,String password){//2011
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET")
		.addAttribute("type", "REQUEST")
		.addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("Head");
		headElement.addElement("RequestType").setText(Iconstants.ZJRequstType.ACCOUNTS_NO_SYX);
		headElement.addElement("User").setText(user==null?"":user);
		headElement.addElement("Password").setText(password==null?"":password);
		Element bodyElement = packetElement.addElement("Body");
		Element basePartElement = bodyElement.addElement("BasePart");
		basePartElement.addElement("OppoentInsurerCode").setText(accounts.getOppoentInsurerCode()==null?"":accounts.getOppoentInsurerCode());
		basePartElement.addElement("OppoentInsurerArea ").setText(accounts.getOppoentInsurerArea()==null?"":accounts.getOppoentInsurerArea());
		basePartElement.addElement("OppoentCoverageType").setText(accounts.getOppoentCoverageCode()==null?"":accounts.getOppoentCoverageCode());
		basePartElement.addElement("OppoentClaimNotificationNo").setText(accounts.getOppoentRegistNo()==null?"":accounts.getOppoentRegistNo());
		basePartElement.addElement("RecoverStatus").setText(accounts.getRecoverStatus()==null?"":accounts.getRecoverStatus());
		basePartElement.addElement("ClaimSequenceNo").setText(accounts.getClaimCode());
		basePartElement.addElement("ClaimNotificationNo").setText(accounts.getRecoveryRegistNo());
		return document;
	}
	/**
	 * ����XML�ַ��� 
	 * @param regist
	 * @param user
	 * @param password
	 * @return
	 */
	public static String getAccountNoXML(Accounts accounts,String user,String password){//2011
		Document document = null;
		document = getZJAccountNoDocument(accounts, user, password);
	
		if(document!=null){
			document.setXMLEncoding("GBK");
			System.out.println("**********   ��ҵ�������͵� XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}
	private static int parseInteger(String data)
	{
		if (data!=null && data!="")
		{
			return Integer.parseInt(data);
		}
		return 0;
	}
	/**
	 * ����Document��������ReturnAccountsInfo����
	 * @param xmlStr
	 * @return
	 * @throws DocumentException 
	 */
	public static ReturnAccountsInfo getZJReturnAccountNoFromXML(String xmlStr) throws DocumentException{
		ReturnAccountsInfo returnInfo=null;
		Accounts accounts=null;
		try
		{
			returnInfo=new ReturnAccountsInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			//�õ����ڵ�PACKET 
			Element packet = document.getRootElement();
			//�õ�HEAD�ڵ�
			for (Iterator it=packet.elementIterator("Head"); it.hasNext();)
			{
				Element head=(Element)it.next();
				returnInfo.setRequestType(parseNode(head.selectSingleNode("RequestType")));
				returnInfo.setResponseCode(parseNode(head.selectSingleNode("ResponseCode")));
				returnInfo.setErrorCode(parseNode(head.selectSingleNode("ErrorCode")));
				returnInfo.setErrorMessage(parseNode(head.selectSingleNode("ErrorMessage")));
			}
//			�õ�BODY�ڵ�
			for (Iterator bit=packet.elementIterator("Body"); bit.hasNext();)
			{
				Element body=(Element)bit.next();
				//����LOCKED_LIST�б�
				int index = 1;
				for (Iterator it = body.elementIterator("QueryResultData"); it.hasNext();)
				{
					accounts = new Accounts();
					Element AccountsInfo=(Element)it.next();
					accounts.setSerialNo(index++);
					accounts.setAccountsNo(parseNode(AccountsInfo.selectSingleNode("RecoveryCode")));
					accounts.setAccountsNoStatus(parseNode(AccountsInfo.selectSingleNode("RecoveryCodeStatus")));
					accounts.setFailureTime(parseNode(AccountsInfo.selectSingleNode("FailureTime")));
					accounts.setFailureCause(parseNode(AccountsInfo.selectSingleNode("FailureCause")));
					accounts.setRecoverStatus(parseNode(AccountsInfo.selectSingleNode("RecoverStatus")));
					accounts.setRecoveryRiskCode(parseNode(AccountsInfo.selectSingleNode("CoverageType")));
					accounts.setRecoveryRegistNo(parseNode(AccountsInfo.selectSingleNode("ClaimNotificationNo")));
					returnInfo.addAccounts(accounts);
				}	
			}
			
		}catch (DocumentException e) {
			e.printStackTrace();
			throw e;
		}
		return returnInfo;
	}
}
