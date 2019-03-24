package com.sinosoft.ciplatform.bl.action.custom;


import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.ciplatform.dto.custom.AccidentBackInfor;
import com.sinosoft.ciplatform.dto.custom.AdvanceInfoDto;
import com.sinosoft.ciplatform.dto.custom.AdvanceUpdateRequestDto;
import com.sinosoft.ciplatform.dto.custom.AdvanceUpdateResponseDto;
import com.sinosoft.ciplatform.dto.custom.CancelCase;
import com.sinosoft.ciplatform.dto.custom.CarLoss;
import com.sinosoft.ciplatform.dto.custom.Certify;
import com.sinosoft.ciplatform.dto.custom.CheckVerify;
import com.sinosoft.ciplatform.dto.custom.Claim;
import com.sinosoft.ciplatform.dto.custom.ClaimHistoryInfor;
import com.sinosoft.ciplatform.dto.custom.CompePlatFormRetrunParam;
import com.sinosoft.ciplatform.dto.custom.CompelCrashAccidentInfor;
import com.sinosoft.ciplatform.dto.custom.CompelCrashArgDto;
import com.sinosoft.ciplatform.dto.custom.CompelCrashDto;
import com.sinosoft.ciplatform.dto.custom.Compensate;
import com.sinosoft.ciplatform.dto.custom.EndCase;
import com.sinosoft.ciplatform.dto.custom.EndCaseAppSituation;
import com.sinosoft.ciplatform.dto.custom.EndCaseAppend;
import com.sinosoft.ciplatform.dto.custom.EndcaseWritebackRequestDto;
import com.sinosoft.ciplatform.dto.custom.EndcaseWritebackResponseDto;
import com.sinosoft.ciplatform.dto.custom.HistoryClaim;
import com.sinosoft.ciplatform.dto.custom.Iconstants;
import com.sinosoft.ciplatform.dto.custom.ImageInfoDto;
import com.sinosoft.ciplatform.dto.custom.LossSituation;
import com.sinosoft.ciplatform.dto.custom.LossSituationDetail;
import com.sinosoft.ciplatform.dto.custom.Paydata;
import com.sinosoft.ciplatform.dto.custom.PayinforSH;
import com.sinosoft.ciplatform.dto.custom.PersonLoss;
import com.sinosoft.ciplatform.dto.custom.PlatFormCrashParam;
import com.sinosoft.ciplatform.dto.custom.PropLoss;
import com.sinosoft.ciplatform.dto.custom.Regist;
import com.sinosoft.ciplatform.dto.custom.ReturnInfo;
import com.sinosoft.ciplatform.dto.custom.ThirdCar;
import com.sinosoft.ciplatform.dto.custom.ThirdPerson;
import com.sinosoft.ciplatform.util.CodeTransfer;
import com.sinosoft.prpall.pubfun.ComCodeTools;
import com.sinosoft.sysframework.common.datatype.DateTime;

public class XMLHandler {
	// 北京无责垫付信息回写，根据事故信息对象生成XML字符串
	/**F
	 * 根据垫付信息回写请求生成XML字符串
	 * 
	 * @param AdvanceUpdateRequestDto
	 * @author zhangwei
	 * @return
	 */ 
	public static String getAdvanceUpdateRequestXML(   
			AdvanceUpdateRequestDto advanceUpdateRequestDto, String user,
			String psd) {
		Document document = getAdvanceUpdateRequestDocument(
				advanceUpdateRequestDto, user, psd);
		// writeFile("regist.xml",document);
		if (document != null) {
			document.setXMLEncoding("gb2312");
			return document.asXML();
		}
		return null;
	}

	/**
	 * 根据垫付信息回写请求生成XML
	 * 
	 * @param PrepayUpdateRequestDto
	 * @author zhangwei
	 * @return
	 */
	private static Document getAdvanceUpdateRequestDocument(
			AdvanceUpdateRequestDto advanceUpdateRequestDto, String user,
			String psd) {
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET").addAttribute(
				"type", "REQUEST").addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("HEAD");
		headElement.addElement("REQUEST_TYPE").setText(
				Iconstants.RequstType.NODUTYPAY_DOWNLOAD);
		headElement.addElement("USER").setText(user == null ? "" : user);
		headElement.addElement("PASSWORD").setText(psd == null ? "" : psd);
		Element bodyElement = packetElement.addElement("BODY");
		Element basePartElement = bodyElement.addElement("BASE_PART");
		basePartElement.addElement("FULL_REPORT_NO").setText(
				advanceUpdateRequestDto.getFullDutyRegistNo());
		return document;
	}

	/**
	 * 根据Document对象生成AdvanceUpdateResponseDto对象
	 * 
	 * @param xmlStr
	 * @return ReturnInfo
	 * @throws DocumentException
	 */
	public static ReturnInfo getAdvanceUpdateResponseFromXML(String xmlStr)
			throws ParseException, DocumentException {
		ReturnInfo returnInfo = null;
		AdvanceUpdateResponseDto advanceUpdateResponseDto = new AdvanceUpdateResponseDto();
		CompePlatFormRetrunParam compePlatFormRetrunParam = new CompePlatFormRetrunParam();
		AdvanceInfoDto fullDutyAdvanceInfoDto = new AdvanceInfoDto();
		AdvanceInfoDto noDutyAdvanceInfoDto = new AdvanceInfoDto();
		try {
			returnInfo = new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			// 得到根节点PACKET
			Element packet = document.getRootElement();
			// 得到HEAD节点
			for (Iterator it = packet.elementIterator("HEAD"); it.hasNext();) {
				Element head = (Element) it.next();
				returnInfo.setRequestType(parseNode(head
						.selectSingleNode("REQUEST_TYPE")));
				compePlatFormRetrunParam.setRequestType(parseNode(head
						.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setReturnType(parseNode(head
						.selectSingleNode("RESPONSE_CODE")));
				compePlatFormRetrunParam.setResponseCode(parseNode(head
						.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
				compePlatFormRetrunParam.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
			}
			// 设置compePlatFormRetrunParam
			advanceUpdateResponseDto
					.setCompePlatFormRetrunParam(compePlatFormRetrunParam);
			// 得到BODY节点
			for (Iterator bit = packet.elementIterator("BODY"); bit.hasNext();) {
				Element body = (Element) bit.next();
				// 得到BASE_PART节点
				Element basepart = (Element) body.selectSingleNode("BASE_PART");
				// 得到fullDutyPrepayInfoDto和noDutyPrepayInfoDto
				fullDutyAdvanceInfoDto.setAdvanceNo(parseNode(basepart
						.selectSingleNode("ADVANCE_NO")));
				noDutyAdvanceInfoDto.setAdvanceNo(parseNode(basepart
						.selectSingleNode("ADVANCE_NO")));
				noDutyAdvanceInfoDto.setCompanyCode(parseNode(basepart
						.selectSingleNode("NULL_COMPANY")));
				noDutyAdvanceInfoDto.setRegistNo(parseNode(basepart
						.selectSingleNode("NULL_REPORT_NO")));
				noDutyAdvanceInfoDto.setClaimNo(parseNode(basepart
						.selectSingleNode("NULL_CLAIM_CODE")));
				noDutyAdvanceInfoDto.setPolicyNo(parseNode(basepart
						.selectSingleNode("NULL_POLICY_CODE")));
				noDutyAdvanceInfoDto.setProposalNo(parseNode(basepart
						.selectSingleNode("NULL_CONFIRM_SEQUENCE_NO")));
				noDutyAdvanceInfoDto.setLicenseNo(parseNode(basepart
						.selectSingleNode("NULL_CAR_MARK")));
				noDutyAdvanceInfoDto.setCarKindCode(parseNode(basepart
						.selectSingleNode("NULL_VEHICLE_TYPE")));
				noDutyAdvanceInfoDto.setDriverName(parseNode(basepart
						.selectSingleNode("NULL_DRIVER_NAME")));
				noDutyAdvanceInfoDto.setDrivingLicenseNo(parseNode(basepart
						.selectSingleNode("NULL_DRIVER_CODE")));
				fullDutyAdvanceInfoDto.setCompanyCode(parseNode(basepart
						.selectSingleNode("FULL_COMPANY")));
				fullDutyAdvanceInfoDto.setRegistNo(parseNode(basepart
						.selectSingleNode("FULL_REPORT_NO")));
				fullDutyAdvanceInfoDto.setClaimNo(parseNode(basepart
						.selectSingleNode("FULL_CLAIM_CODE")));
				fullDutyAdvanceInfoDto.setPolicyNo(parseNode(basepart
						.selectSingleNode("FULL_POLICY_CODE")));
				fullDutyAdvanceInfoDto.setProposalNo(parseNode(basepart
						.selectSingleNode("FULL_CONFIRM_SEQUENCE_NO")));
				fullDutyAdvanceInfoDto.setLicenseNo(parseNode(basepart
						.selectSingleNode("FULL_CAR_MARK")));
				fullDutyAdvanceInfoDto.setCarKindCode(parseNode(basepart
						.selectSingleNode("FULL_VEHICLE_TYPE")));
				fullDutyAdvanceInfoDto.setDriverName(parseNode(basepart
						.selectSingleNode("FULL_DRIVER_NAME")));
				fullDutyAdvanceInfoDto.setDrivingLicenseNo(parseNode(basepart
						.selectSingleNode("FULL_DRIVER_CODE")));
				noDutyAdvanceInfoDto.setDamageDate(getDate(basepart,
						"ACCIDENT_TIME"));
				fullDutyAdvanceInfoDto.setDamageDate(getDate(basepart,
						"ACCIDENT_TIME"));
				fullDutyAdvanceInfoDto.setReportDate(getDate(basepart,
						"FULL_REPORT_TIME"));
				fullDutyAdvanceInfoDto.setCheckDate(getDate(basepart,
						"FULL_INVESTIGATION_TIME"));
				noDutyAdvanceInfoDto.setDamageAddress(parseNode(basepart
						.selectSingleNode("ACCIDENT_PLACE")));
				noDutyAdvanceInfoDto.setCheckSite(parseNode(basepart
						.selectSingleNode("INVESTIGATION_PLACE")));
				noDutyAdvanceInfoDto.setAccidentDescription(parseNode(basepart
						.selectSingleNode("ACCIDENT_DESCRIPTION")));
				noDutyAdvanceInfoDto.setAccidentReason(parseNode(basepart
						.selectSingleNode("ACCIDENT_REASON")));
				fullDutyAdvanceInfoDto.setDamageAddress(parseNode(basepart
						.selectSingleNode("ACCIDENT_PLACE")));
				fullDutyAdvanceInfoDto.setCheckSite(parseNode(basepart
						.selectSingleNode("INVESTIGATION_PLACE")));
				fullDutyAdvanceInfoDto
						.setAccidentDescription(parseNode(basepart
								.selectSingleNode("ACCIDENT_DESCRIPTION")));
				fullDutyAdvanceInfoDto.setAccidentReason(parseNode(basepart
						.selectSingleNode("ACCIDENT_REASON")));
				noDutyAdvanceInfoDto
						.setSettlementAmount(parseDouble(parseNode(basepart
								.selectSingleNode("SETTLEMENT_AMOUNT"))));
				fullDutyAdvanceInfoDto
						.setEstimateAmount(parseDouble(parseNode(basepart
								.selectSingleNode("ESTIMATED_AMOUNT"))));
				noDutyAdvanceInfoDto.setPayMode(parseNode(basepart
						.selectSingleNode("PAY_MODE")));
				fullDutyAdvanceInfoDto.setPayMode(parseNode(basepart
						.selectSingleNode("PAY_MODE")));
				noDutyAdvanceInfoDto.setComment(parseNode(basepart
						.selectSingleNode("NULL_COMMENTS")));
				fullDutyAdvanceInfoDto.setComment(parseNode(basepart
						.selectSingleNode("FULL_COMMENTS")));
				// 设置fullDutyAdvanceInfoDto和noDutyAdvanceInfoDto
				advanceUpdateResponseDto
						.setFullDutyAdvanceInfoDto(fullDutyAdvanceInfoDto);
				advanceUpdateResponseDto
						.setNoDutyAdvanceInfoDto(noDutyAdvanceInfoDto);
				// 得到imageInfoDtoList
				Element imageInfoList = (Element) body
						.selectSingleNode("ATTACH_LIST");
				for (Iterator it = imageInfoList.elementIterator("ATTACH_LIST"); it
						.hasNext();) {
					ImageInfoDto imageInfoDto = new ImageInfoDto();
					Element imageInfo = (Element) it.next();
					imageInfoDto.setAttachType(parseNode(imageInfo
							.selectSingleNode("ATTACH_TYPE")));
					imageInfoDto.setFileType(parseNode(imageInfo
							.selectSingleNode("FILE_TYPE")));
					imageInfoDto.setFileName(parseNode(imageInfo
							.selectSingleNode("FILE_NAME")));
					imageInfoDto.setFileUrl(parseNode(imageInfo
							.selectSingleNode("FILE_URL")));
					advanceUpdateResponseDto.addImageInfoDto(imageInfoDto);
				}
			}
			// 设置prepayUpdateResponseDto
		//	returnInfo.setAdvanceUpdateResponseDto(advanceUpdateResponseDto);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		return returnInfo;
	}

	/**
	 * 根据结案信息回写请求生成XML字符串
	 * 
	 * @param AdvanceConfirmRequestDto
	 * @author zhangwei
	 * @return
	 */
	public static String getEndcaseWritebackRequestXML(
			EndcaseWritebackRequestDto endcaseWritebackRequestDto, String user,
			String psd) {
		Document document = getEndcaseWritebackRequestDocument(
				endcaseWritebackRequestDto, user, psd);
		// writeFile("regist.xml",document);
		if (document != null) {
			document.setXMLEncoding("gb2312");
			return document.asXML();
		}
		return null;
	}

	/**
	 * 根据结案信息回写请求生成XML
	 * 
	 * @param EndcaseWritebackRequestDto
	 * @author zhangwei
	 * @return
	 */
	private static Document getEndcaseWritebackRequestDocument(
			EndcaseWritebackRequestDto endcaseWritebackRequestDto, String user,
			String psd) {
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET").addAttribute(
				"type", "REQUEST").addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("HEAD");
		headElement.addElement("REQUEST_TYPE").setText(
				Iconstants.RequstType.NODUTYPAY_ENDCASE_DOWNLOAD);
		headElement.addElement("USER").setText(user);
		headElement.addElement("PASSWORD").setText(psd);
		Element bodyElement = packetElement.addElement("BODY");
		Element basePartElement = bodyElement.addElement("BASE_PART");
		basePartElement.addElement("NULL_REPORT_NO").setText(
				endcaseWritebackRequestDto.getNoDutyRegistNo());
		return document;
	}

	/**
	 * 根据Document对象生成EndcaseWritebackResponseDto对象
	 * 
	 * @param xmlStr
	 * @return ReturnInfo
	 * @throws DocumentException
	 */
	public static ReturnInfo getEndcaseWritebackResponseFromXML(String xmlStr)
			throws ParseException, DocumentException {
		ReturnInfo returnInfo = null;
		EndcaseWritebackResponseDto endcaseWritebackResponseDto = new EndcaseWritebackResponseDto();
		CompePlatFormRetrunParam compePlatFormRetrunParam = new CompePlatFormRetrunParam();
		AdvanceInfoDto fullDutyAdvanceInfoDto = new AdvanceInfoDto();
		AdvanceInfoDto noDutyAdvanceInfoDto = new AdvanceInfoDto();
		try {
			returnInfo = new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			// 得到根节点PACKET
			Element packet = document.getRootElement();
			// 得到HEAD节点
			for (Iterator it = packet.elementIterator("HEAD"); it.hasNext();) {
				Element head = (Element) it.next();
				returnInfo.setRequestType(parseNode(head
						.selectSingleNode("REQUEST_TYPE")));
				compePlatFormRetrunParam.setRequestType(parseNode(head
						.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setReturnType(parseNode(head
						.selectSingleNode("RESPONSE_CODE")));
				compePlatFormRetrunParam.setResponseCode(parseNode(head
						.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
				compePlatFormRetrunParam.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
			}
			// 设置compePlatFormRetrunParam
			endcaseWritebackResponseDto
					.setCompePlatFormRetrunParam(compePlatFormRetrunParam);
			// 得到BODY节点
			for (Iterator bit = packet.elementIterator("BODY"); bit.hasNext();) {
				Element body = (Element) bit.next();
				// 得到BASE_PART节点
				Element basepart = (Element) body.selectSingleNode("BASE_PART");
				// 得到fullDutyPrepayInfoDto和noDutyPrepayInfoDto
				fullDutyAdvanceInfoDto.setAdvanceNo(parseNode(basepart
						.selectSingleNode("ADVANCE_NO")));
				noDutyAdvanceInfoDto.setAdvanceNo(parseNode(basepart
						.selectSingleNode("ADVANCE_NO")));
				noDutyAdvanceInfoDto.setCompanyCode(parseNode(basepart
						.selectSingleNode("NULL_COMPANY")));
				noDutyAdvanceInfoDto.setRegistNo(parseNode(basepart
						.selectSingleNode("NULL_REPORT_NO")));
				noDutyAdvanceInfoDto.setClaimNo(parseNode(basepart
						.selectSingleNode("NULL_CLAIM_CODE")));
				noDutyAdvanceInfoDto.setPolicyNo(parseNode(basepart
						.selectSingleNode("NULL_POLICY_CODE")));
				noDutyAdvanceInfoDto.setProposalNo(parseNode(basepart
						.selectSingleNode("NULL_CONFIRM_SEQUENCE_NO")));
				noDutyAdvanceInfoDto.setLicenseNo(parseNode(basepart
						.selectSingleNode("NULL_CAR_MARK")));
				noDutyAdvanceInfoDto.setCarKindCode(parseNode(basepart
						.selectSingleNode("NULL_VEHICLE_TYPE")));
				noDutyAdvanceInfoDto.setDriverName(parseNode(basepart
						.selectSingleNode("NULL_DRIVER_NAME")));
				noDutyAdvanceInfoDto.setDrivingLicenseNo(parseNode(basepart
						.selectSingleNode("NULL_DRIVER_CODE")));
				fullDutyAdvanceInfoDto.setCompanyCode(parseNode(basepart
						.selectSingleNode("FULL_COMPANY")));
				fullDutyAdvanceInfoDto.setRegistNo(parseNode(basepart
						.selectSingleNode("FULL_REPORT_NO")));
				fullDutyAdvanceInfoDto.setClaimNo(parseNode(basepart
						.selectSingleNode("FULL_CLAIM_CODE")));
				fullDutyAdvanceInfoDto.setPolicyNo(parseNode(basepart
						.selectSingleNode("FULL_POLICY_CODE")));
				fullDutyAdvanceInfoDto.setProposalNo(parseNode(basepart
						.selectSingleNode("FULL_CONFIRM_SEQUENCE_NO")));
				fullDutyAdvanceInfoDto.setLicenseNo(parseNode(basepart
						.selectSingleNode("FULL_CAR_MARK")));
				fullDutyAdvanceInfoDto.setCarKindCode(parseNode(basepart
						.selectSingleNode("FULL_VEHICLE_TYPE")));
				fullDutyAdvanceInfoDto.setDriverName(parseNode(basepart
						.selectSingleNode("FULL_DRIVER_NAME")));
				fullDutyAdvanceInfoDto.setDrivingLicenseNo(parseNode(basepart
						.selectSingleNode("FULL_DRIVER_CODE")));
				noDutyAdvanceInfoDto.setDamageDate(getDate(basepart,
						"ACCIDENT_TIME"));
				fullDutyAdvanceInfoDto.setDamageDate(getDate(basepart,
						"ACCIDENT_TIME"));
				fullDutyAdvanceInfoDto.setReportDate(getDate(basepart,
						"FULL_REPORT_TIME"));
				fullDutyAdvanceInfoDto.setCheckDate(getDate(basepart,
						"FULL_INVESTIGATION_TIME"));
				noDutyAdvanceInfoDto.setDamageAddress(parseNode(basepart
						.selectSingleNode("ACCIDENT_PLACE")));
				noDutyAdvanceInfoDto.setCheckSite(parseNode(basepart
						.selectSingleNode("INVESTIGATION_PLACE")));
				noDutyAdvanceInfoDto.setAccidentDescription(parseNode(basepart
						.selectSingleNode("ACCIDENT_DESCRIPTION")));
				noDutyAdvanceInfoDto.setAccidentReason(parseNode(basepart
						.selectSingleNode("ACCIDENT_REASON")));
				fullDutyAdvanceInfoDto.setDamageAddress(parseNode(basepart
						.selectSingleNode("ACCIDENT_PLACE")));
				fullDutyAdvanceInfoDto.setCheckSite(parseNode(basepart
						.selectSingleNode("INVESTIGATION_PLACE")));
				fullDutyAdvanceInfoDto
						.setAccidentDescription(parseNode(basepart
								.selectSingleNode("ACCIDENT_DESCRIPTION")));
				fullDutyAdvanceInfoDto.setAccidentReason(parseNode(basepart
						.selectSingleNode("ACCIDENT_REASON")));
				noDutyAdvanceInfoDto
						.setSettlementAmount(parseDouble(parseNode(basepart
								.selectSingleNode("SETTLEMENT_AMOUNT"))));
				fullDutyAdvanceInfoDto
						.setEstimateAmount(parseDouble(parseNode(basepart
								.selectSingleNode("ESTIMATED_AMOUNT"))));
				noDutyAdvanceInfoDto.setPayMode(parseNode(basepart
						.selectSingleNode("PAY_MODE")));
				fullDutyAdvanceInfoDto.setPayMode(parseNode(basepart
						.selectSingleNode("PAY_MODE")));
				noDutyAdvanceInfoDto.setComment(parseNode(basepart
						.selectSingleNode("NULL_COMMENTS")));
				fullDutyAdvanceInfoDto.setComment(parseNode(basepart
						.selectSingleNode("FULL_COMMENTS")));
				// 设置fullDutyAdvanceInfoDto和noDutyAdvanceInfoDto
				endcaseWritebackResponseDto
						.setFullDutyAdvanceInfoDto(fullDutyAdvanceInfoDto);
				endcaseWritebackResponseDto
						.setNoDutyAdvanceInfoDto(noDutyAdvanceInfoDto);
				// 得到imageInfoDtoList
				Element imageInfoList = (Element) body
						.selectSingleNode("ATTACH_LIST");
				for (Iterator it = imageInfoList.elementIterator("ATTACH_FILE"); it
						.hasNext();) {
					ImageInfoDto imageInfoDto = new ImageInfoDto();
					Element imageInfo = (Element) it.next();
					imageInfoDto.setAttachType(parseNode(imageInfo
							.selectSingleNode("ATTACH_TYPE")));
					imageInfoDto.setFileType(parseNode(imageInfo
							.selectSingleNode("FILE_TYPE")));
					imageInfoDto.setFileName(parseNode(imageInfo
							.selectSingleNode("FILE_NAME")));
					imageInfoDto.setFileUrl(parseNode(imageInfo
							.selectSingleNode("FILE_URL")));
					endcaseWritebackResponseDto.addImageInfoDto(imageInfoDto);
				}
			}
			// 设置prepayUpdateResponseDto
	//				.setEndcaseWritebackResponseDto(endcaseWritebackResponseDto);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		return returnInfo;
	}

	/**
	 * 根据事故信息上传对象生成XML字符串
	 */
	public static String getAccidentUploadInfoXML(
			CompelCrashDto accidentUploadInfo, String user, String password) {
		Document document = getAccidentUploadInfoDocument(accidentUploadInfo,
				user, password);
		if (document != null) {
			document.setXMLEncoding("gb2312");
			return document.asXML();
		}
		return null;
	}

	private static Document getAccidentUploadInfoDocument(
			CompelCrashDto compelCrashDto, String user, String password) {
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET").addAttribute(
				"type", "REQUEST").addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("HEAD");
		headElement.addElement("REQUEST_TYPE").setText(
				new PlatFormCrashParam().REQUEST_UPLOAD);
		headElement.addElement("USER").setText(user == null ? "" : user);
		headElement.addElement("PASSWORD").setText(
				password == null ? "" : password);
		Element bodyElement = packetElement.addElement("BODY");
		Element basePartElement = bodyElement.addElement("BASE_PART");
		if (compelCrashDto != null) {
			if (compelCrashDto.getOwnAccidentInfor() != null) {
				basePartElement
						.addElement("A_NAME")
						.setText(
								compelCrashDto.getOwnAccidentInfor().getName() == null ? ""
										: compelCrashDto.getOwnAccidentInfor()
												.getName());
				basePartElement
						.addElement("A_ID_NO")
						.setText(
								compelCrashDto.getOwnAccidentInfor().getIdNo() == null ? ""
										: compelCrashDto.getOwnAccidentInfor()
												.getIdNo());
				basePartElement.addElement("A_CAR_MARK")
						.setText(
								compelCrashDto.getOwnAccidentInfor()
										.getCarMark() == null ? ""
										: compelCrashDto.getOwnAccidentInfor()
												.getCarMark());
				basePartElement.addElement("A_VEHICLE_TYPE")
						.setText(
								compelCrashDto.getOwnAccidentInfor()
										.getVehicleType() == null ? ""
										: compelCrashDto.getOwnAccidentInfor()
												.getVehicleType());
				basePartElement.addElement("A_VEHICLE_MODEL")
						.setText(
								compelCrashDto.getOwnAccidentInfor()
										.getVehicleModel() == null ? ""
										: compelCrashDto.getOwnAccidentInfor()
												.getVehicleModel());
				basePartElement
						.addElement("A_TEL_NO")
						.setText(
								compelCrashDto.getOwnAccidentInfor().getTelNo() == null ? ""
										: compelCrashDto.getOwnAccidentInfor()
												.getTelNo());
				basePartElement.addElement("A_COMPANY_CODE")
						.setText(
								compelCrashDto.getOwnAccidentInfor()
										.getCompanyCode() == null ? ""
										: compelCrashDto.getOwnAccidentInfor()
												.getCompanyCode());
				basePartElement.addElement("A_POLICY_CODE")
						.setText(
								compelCrashDto.getOwnAccidentInfor()
										.getPolicyCode() == null ? ""
										: compelCrashDto.getOwnAccidentInfor()
												.getPolicyCode());
				basePartElement.addElement("A_REPORT_NO")
						.setText(
								compelCrashDto.getOwnAccidentInfor()
										.getReportNo() == null ? ""
										: compelCrashDto.getOwnAccidentInfor()
												.getReportNo());
				basePartElement.addElement("A_DAMAGE_PART")
						.setText(
								compelCrashDto.getOwnAccidentInfor()
										.getDamagePart() == null ? ""
										: compelCrashDto.getOwnAccidentInfor()
												.getDamagePart());
			}
			if (compelCrashDto.getOtherAccidentInfor() != null) {
				basePartElement.addElement("B_NAME")
						.setText(
								compelCrashDto.getOtherAccidentInfor()
										.getName() == null ? ""
										: compelCrashDto
												.getOtherAccidentInfor()
												.getName());
				basePartElement.addElement("B_ID_NO")
						.setText(
								compelCrashDto.getOtherAccidentInfor()
										.getIdNo() == null ? ""
										: compelCrashDto
												.getOtherAccidentInfor()
												.getIdNo());
				basePartElement.addElement("B_CAR_MARK")
						.setText(
								compelCrashDto.getOtherAccidentInfor()
										.getCarMark() == null ? ""
										: compelCrashDto
												.getOtherAccidentInfor()
												.getCarMark());
				basePartElement.addElement("B_VEHICLE_TYPE")
						.setText(
								compelCrashDto.getOtherAccidentInfor()
										.getVehicleType() == null ? ""
										: compelCrashDto
												.getOtherAccidentInfor()
												.getVehicleType());
				basePartElement.addElement("B_VEHICLE_MODEL").setText(
						compelCrashDto.getOtherAccidentInfor()
								.getVehicleModel() == null ? ""
								: compelCrashDto.getOtherAccidentInfor()
										.getVehicleModel());
				basePartElement.addElement("B_TEL_NO")
						.setText(
								compelCrashDto.getOtherAccidentInfor()
										.getTelNo() == null ? ""
										: compelCrashDto
												.getOtherAccidentInfor()
												.getTelNo());
				basePartElement.addElement("B_COMPANY_CODE")
						.setText(
								compelCrashDto.getOtherAccidentInfor()
										.getCompanyCode() == null ? ""
										: compelCrashDto
												.getOtherAccidentInfor()
												.getCompanyCode());
				// basePartElement.addElement("B_COMPANY_CODE").setText("CIC001");
				basePartElement.addElement("B_POLICY_CODE")
						.setText(
								compelCrashDto.getOtherAccidentInfor()
										.getPolicyCode() == null ? ""
										: compelCrashDto
												.getOtherAccidentInfor()
												.getPolicyCode());
				basePartElement.addElement("B_REPORT_NO")
						.setText(
								compelCrashDto.getOtherAccidentInfor()
										.getReportNo() == null ? ""
										: compelCrashDto
												.getOtherAccidentInfor()
												.getReportNo());
				basePartElement.addElement("B_DAMAGE_PART")
						.setText(
								compelCrashDto.getOtherAccidentInfor()
										.getDamagePart() == null ? ""
										: compelCrashDto
												.getOtherAccidentInfor()
												.getDamagePart());
			}

			basePartElement.addElement("FAULT_PARTY").setText(
					compelCrashDto.getFaultParty() == null ? ""
							: compelCrashDto.getFaultParty());
			basePartElement.addElement("FAULT_BEHAVIOR").setText(
					compelCrashDto.getFaultBehavior() == null ? ""
							: compelCrashDto.getFaultBehavior());
			if (compelCrashDto.getAccidentTime() != null
					&& compelCrashDto.getAccidentTime().length() > 0) {
				basePartElement.addElement("ACCIDENT_TIME").setText(
						compelCrashDto.getAccidentTime());
			}
			basePartElement.addElement("ACCIDENT_PLACE").setText(
					compelCrashDto.getAccidentPlace() == null ? ""
							: compelCrashDto.getAccidentPlace());
			if (compelCrashDto.getReportTime() != null
					&& compelCrashDto.getReportTime().length() > 0) {
				basePartElement.addElement("REPORT_TIME").setText(
						compelCrashDto.getReportTime());
			}
			if (compelCrashDto.getApplyAssessmentTime() != null
					&& compelCrashDto.getApplyAssessmentTime().length() > 0) {
				basePartElement.addElement("APPLY_ASSESSMENT_TIME").setText(
						compelCrashDto.getApplyAssessmentTime());
			}
			if (compelCrashDto.getAssessStartTime() != null
					&& compelCrashDto.getAssessStartTime().length() > 0) {
				basePartElement.addElement("ASSESS_START_TIME").setText(
						compelCrashDto.getAssessStartTime());
			}
		}

		return document;
	}

	/**
	 * 将平台返回的事故信息的XML字符串转换为自己的dto
	 */
	public static ReturnInfo getAccidentBackInfo(String xmlStr)
			throws ParseException, DocumentException {
		ReturnInfo returnInfo = new ReturnInfo();
		AccidentBackInfor accidentBackInfor = null;
		CompePlatFormRetrunParam compePlatFormRetrunParam = new CompePlatFormRetrunParam();
		ArrayList aClaimList = new ArrayList();
		ArrayList bClaimList = new ArrayList();
		try {
			accidentBackInfor = new AccidentBackInfor();
			Document document = DocumentHelper.parseText(xmlStr);
			Element packet = document.getRootElement();
			for (Iterator it = packet.elementIterator("HEAD"); it.hasNext();) {
				Element head = (Element) it.next();
				returnInfo.setReturnType(parseNode(head
						.selectSingleNode("REQUEST_TYPE")));
				compePlatFormRetrunParam.setRequestType(parseNode(head
						.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setReturnType(parseNode(head
						.selectSingleNode("RESPONSE_CODE")));
				compePlatFormRetrunParam.setResponseCode(parseNode(head
						.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
				compePlatFormRetrunParam.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
				accidentBackInfor
						.setCompePlatFormRetrunParam(compePlatFormRetrunParam);
			}
			for (Iterator bit = packet.elementIterator("BODY"); bit.hasNext();) {
				Element body = (Element) bit.next();
				Element basepart = (Element) body.selectSingleNode("BASE_PART");
				accidentBackInfor.setAccidentNo(parseNode(basepart
						.selectSingleNode("ACCIDENT_NO")));
				Element A_CLAIM_LIST = (Element) body
						.selectSingleNode("A_CLAIM_LIST");
				for (Iterator ait = A_CLAIM_LIST.elementIterator("CLAIM_DATA"); ait
						.hasNext();) {
					Element CLAIM_DATA = (Element) ait.next();
					ClaimHistoryInfor claimHistoryInfor = new ClaimHistoryInfor();
					claimHistoryInfor.setClaimCompanyCode(parseNode(CLAIM_DATA
							.selectSingleNode("CLAIM_COMPANY_CODE")));
					claimHistoryInfor.setAccidentTime(getDate(CLAIM_DATA,
							"ACCIDENT_TIME"));
					claimHistoryInfor.setReportTime(getDate(CLAIM_DATA,
							"REPORT_TIME"));
					claimHistoryInfor.setClaimDate(getDate(CLAIM_DATA,
							"REGISTRATION_DATE"));
					claimHistoryInfor.setEndcaseDate(getDate(CLAIM_DATA,
							"ENDCASE_DATE"));
					if (parseNode(CLAIM_DATA.selectSingleNode("UNCLAIM_AMOUNT")) != null
							&& !parseNode(
									CLAIM_DATA
											.selectSingleNode("UNCLAIM_AMOUNT"))
									.equals("")) {
						claimHistoryInfor.setUnclaimAmount(Double
								.parseDouble(parseNode(CLAIM_DATA
										.selectSingleNode("UNCLAIM_AMOUNT"))));
					}
					if (parseNode(CLAIM_DATA.selectSingleNode("CLAIM_AMOUNT")) != null
							&& !parseNode(
									CLAIM_DATA.selectSingleNode("CLAIM_AMOUNT"))
									.equals("")) {
						claimHistoryInfor.setClaimAmount(Double
								.parseDouble(parseNode(CLAIM_DATA
										.selectSingleNode("CLAIM_AMOUNT"))));
					}

					claimHistoryInfor.setStatus(parseNode(CLAIM_DATA
							.selectSingleNode("STATUS")));

					aClaimList.add(claimHistoryInfor);
				}
				Element B_CLAIM_LIST = (Element) body
						.selectSingleNode("B_CLAIM_LIST");
				for (Iterator it = B_CLAIM_LIST.elementIterator("CLAIM_DATA"); it
						.hasNext();) {
					Element CLAIM_DATA = (Element) it.next();
					ClaimHistoryInfor claimHistoryInfor = new ClaimHistoryInfor();

					claimHistoryInfor.setClaimCompanyCode(parseNode(CLAIM_DATA
							.selectSingleNode("CLAIM_COMPANY_CODE")));
					claimHistoryInfor.setAccidentTime(getDate(CLAIM_DATA,
							"ACCIDENT_TIME"));
					claimHistoryInfor.setReportTime(getDate(CLAIM_DATA,
							"REPORT_TIME"));
					claimHistoryInfor.setClaimDate(getDate(CLAIM_DATA,
							"REGISTRATION_DATE"));
					claimHistoryInfor.setEndcaseDate(getDate(CLAIM_DATA,
							"ENDCASE_DATE"));
					if (parseNode(CLAIM_DATA.selectSingleNode("UNCLAIM_AMOUNT")) != null
							&& !parseNode(
									CLAIM_DATA
											.selectSingleNode("UNCLAIM_AMOUNT"))
									.equals("")) {
						claimHistoryInfor.setUnclaimAmount(Double
								.parseDouble(parseNode(CLAIM_DATA
										.selectSingleNode("UNCLAIM_AMOUNT"))));
					}
					if (parseNode(CLAIM_DATA.selectSingleNode("CLAIM_AMOUNT")) != null
							&& !parseNode(
									CLAIM_DATA.selectSingleNode("CLAIM_AMOUNT"))
									.equals("")) {
						claimHistoryInfor.setClaimAmount(Double
								.parseDouble(parseNode(CLAIM_DATA
										.selectSingleNode("CLAIM_AMOUNT"))));
					}

					claimHistoryInfor.setStatus(parseNode(CLAIM_DATA
							.selectSingleNode("STATUS")));
					bClaimList.add(claimHistoryInfor);
				}
				accidentBackInfor.setAClaimList(aClaimList);
				accidentBackInfor.setBClaimList(bClaimList);
			}
		//	returnInfo.setAccidentBackInfo(accidentBackInfor);
		} catch (DocumentException e) {
			e.printStackTrace();
			throw e;
		}
		return returnInfo;
	}

	/**
	 * 根据事故回写信息生成xml字符串
	 */
	public static String getAccidentBackWriteUploadInfo(
			CompelCrashArgDto compelCrashArg, String user, String password) {
		Document document = getAccidentBackWriteUploadInfoDocument(
				compelCrashArg, user, password);
		if (document != null) {
			document.setXMLEncoding("gb2312");
			return document.asXML();
		}
		return null;
	}

	private static Document getAccidentBackWriteUploadInfoDocument(
			CompelCrashArgDto compelCrashArg, String user, String password) {
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET").addAttribute(
				"type", "REQUEST").addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("HEAD");
		headElement.addElement("REQUEST_TYPE").setText(
				new PlatFormCrashParam().REQUEST_BACKWRITE);
		headElement.addElement("USER").setText(user == null ? "" : user);
		headElement.addElement("PASSWORD").setText(
				password == null ? "" : password);
		Element bodyElement = packetElement.addElement("BODY");
		Element basePartElement = bodyElement.addElement("BASE_PART");
		basePartElement.addElement("A_REPORT_NO").setText(
				compelCrashArg.getARegsitNo() == null ? "" : compelCrashArg
						.getARegsitNo());
		basePartElement.addElement("B_REPORT_NO").setText(
				compelCrashArg.getBRegsitNo() == null ? "" : compelCrashArg
						.getBRegsitNo());
		return document;
	}

	public static ReturnInfo getAccidentBackWriteBackInfo(String xmlStr)
			throws ParseException, DocumentException {
		ReturnInfo returnInfo = new ReturnInfo();
		try {
			CompelCrashDto accidentBackWriteBackInfo = new CompelCrashDto();
			CompePlatFormRetrunParam compePlatFormRetrunParam = new CompePlatFormRetrunParam();
			Document document = DocumentHelper.parseText(xmlStr);
			Element packet = document.getRootElement();
			for (Iterator it = packet.elementIterator("HEAD"); it.hasNext();) {
				Element head = (Element) it.next();
				returnInfo.setReturnType(parseNode(head
						.selectSingleNode("REQUEST_TYPE")));
				compePlatFormRetrunParam.setRequestType(parseNode(head
						.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setReturnType(parseNode(head
						.selectSingleNode("RESPONSE_CODE")));
				compePlatFormRetrunParam.setResponseCode(parseNode(head
						.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
				compePlatFormRetrunParam.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
				accidentBackWriteBackInfo
						.setCompePlatFormRetrunParam(compePlatFormRetrunParam);

			}

			for (Iterator bit = packet.elementIterator("BODY"); bit.hasNext();) {
				Element body = (Element) bit.next();
				Element basepart = (Element) body.selectSingleNode("BASE_PART");
				accidentBackWriteBackInfo.setAccidentNo(parseNode(basepart
						.selectSingleNode("ACCIDENT_NO")));

				CompelCrashAccidentInfor aAccidentInfo = new CompelCrashAccidentInfor();
				aAccidentInfo.setName(parseNode(basepart
						.selectSingleNode("A_NAME")));
				aAccidentInfo.setIdNo(parseNode(basepart
						.selectSingleNode("A_ID_NO")));
				aAccidentInfo.setCarMark(parseNode(basepart
						.selectSingleNode("A_CAR_MARK")));
				aAccidentInfo.setVehicleType(parseNode(basepart
						.selectSingleNode("A_VEHICLE_TYPE")));
				aAccidentInfo.setVehicleModel(parseNode(basepart
						.selectSingleNode("A_VEHICLE_MODEL")));
				aAccidentInfo.setTelNo(parseNode(basepart
						.selectSingleNode("A_TEL_NO")));
				aAccidentInfo.setCompanyCode(parseNode(basepart
						.selectSingleNode("A_COMPANY_CODE")));
				aAccidentInfo.setPolicyCode(parseNode(basepart
						.selectSingleNode("A_POLICY_CODE")));
				aAccidentInfo.setReportNo(parseNode(basepart
						.selectSingleNode("A_REPORT_NO")));
				aAccidentInfo.setDamagePart(parseNode(basepart
						.selectSingleNode("A_DAMAGE_PART")));
				accidentBackWriteBackInfo.setOwnAccidentInfor(aAccidentInfo);
				CompelCrashAccidentInfor bAccidentInfo = new CompelCrashAccidentInfor();
				bAccidentInfo.setName(parseNode(basepart
						.selectSingleNode("B_NAME")));
				bAccidentInfo.setIdNo(parseNode(basepart
						.selectSingleNode("B_ID_NO")));
				bAccidentInfo.setCarMark(parseNode(basepart
						.selectSingleNode("B_CAR_MARK")));
				bAccidentInfo.setVehicleType(parseNode(basepart
						.selectSingleNode("B_VEHICLE_TYPE")));
				bAccidentInfo.setVehicleModel(parseNode(basepart
						.selectSingleNode("B_VEHICLE_MODEL")));
				bAccidentInfo.setTelNo(parseNode(basepart
						.selectSingleNode("B_TEL_NO")));
				bAccidentInfo.setCompanyCode(parseNode(basepart
						.selectSingleNode("B_COMPANY_CODE")));
				bAccidentInfo.setPolicyCode(parseNode(basepart
						.selectSingleNode("B_POLICY_CODE")));
				bAccidentInfo.setReportNo(parseNode(basepart
						.selectSingleNode("B_REPORT_NO")));
				bAccidentInfo.setDamagePart(parseNode(basepart
						.selectSingleNode("B_DAMAGE_PART")));
				accidentBackWriteBackInfo.setOtherAccidentInfor(bAccidentInfo);

			}
		//	returnInfo.setCompelCrashDto(accidentBackWriteBackInfo);
			return returnInfo;

		} catch (DocumentException e) {
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * 根据报案对象生成XML字符串
	 * 
	 * @param regist
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static String getRegistXML(Regist regist, String user,
			String password) throws Exception {
		Document document = getRegistDocument(regist, user, password);
		// writeFile("regist.xml",document);
		if (document != null) {
			document.setXMLEncoding("gb2312");
			System.out.println("**********   报案发送的 XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}

	/**
	 * 根据立案对象生成XML字符串
	 * 
	 * @param claim
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static String getClaimXML(Claim claim, String user, String password)
			throws Exception {
		Document document = getClaimDocument(claim, user, password);
		if (document != null) {
			document.setXMLEncoding("gb2312");
			System.out.println("**********   立案发送的 XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}
	/**
	 * 根据理算对象生成XML字符串
	 * 
	 * @param claim
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static String getCompensateXML(Compensate compensate, String user, String password)
			throws Exception {
		Document document = getCompensateDocument(compensate, user, password);
		if (document != null) {
			document.setXMLEncoding("gb2312");
			System.out.println("**********  理算发送的 XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}
	/**
	 * 根据单证对象生成XML字符串
	 * 
	 * @param claim
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static String getCertifyXML(Certify certify, String user, String password)
			throws Exception {
		Document document = getSHCertifyDocument(certify, user, password);
		if (document != null) {
			document.setXMLEncoding("gb2312");
			System.out.println("**********   单证发送的 XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}
//	/**
//	 * 根据支付对象生成XML字符串
//	 * 
//	 * @param claim
//	 * @param user
//	 * @param password
//	 * @return
//	 * @throws Exception
//	 */
//	public static String getPayinforXML(Payinfor payinfor, String user, String password)
//			throws Exception {
//		Document document = getPayinforDocument(payinfor, user, password);
//		if (document != null) {
//			document.setXMLEncoding("gb2312");
//			System.out.println("**********   赔款支付发送的 XML  *************"
//					+ document.asXML());
//			return document.asXML();
//		}
//		return null;
//	}
	/**
	 * 根据结案对象生成XML字符串
	 * 
	 * @param EndCase
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static String getEndCaseXML(EndCase endCase, String user,
			String password) throws Exception {
		Document document = getEndCaseDocument(endCase, user, password);
		if (document != null) {
			document.setXMLEncoding("gb2312");
			System.out.println("**********   结案发送的 XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}

	/**
	 * 根据结案追加对象生成XML字符串
	 * 
	 * @param EndCase
	 * @param user
	 * @param password
	 * @return
	 */
	public static String getEndCaseAppendXML(EndCaseAppend endCaseApp,
			String user, String password) throws Exception{
		Document document=null;
		if(ComCodeTools.getBeforThreeCode(endCaseApp.getComCode()).equals("231"))
		{
			document = getSHEndCaseAppendDocument(endCaseApp, user, password);
		}else
		{
			document = getEndCaseAppendDocument(endCaseApp, user, password);
		}
		if (document != null) {
			document.setXMLEncoding("gb2312");
			System.out.println("**********   结案追加发送的 XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}

	/**
	 * 根据注销立案对象生成XML字符串
	 * 
	 * @param EndCase
	 * @param user
	 * @param password
	 * @return
	 */
	public static String getCancelCaseXML(CancelCase cancelCase, String user,
			String password) throws Exception{
		Document document = getCancelCaseDocument(cancelCase, user, password);
		if (document != null) {
			document.setXMLEncoding("gb2312");
			System.out.println("**********   注销发送的 XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}
	/**
	 * 根据查勘定损核损对象生成XML字符串
	 * 
	 * @param EndCase
	 * @param user
	 * @param password
	 * @return
	 */
	public static String getCheckVerifyXML(CheckVerify checkVerify, String user,
			String password) throws Exception{
		Document document = null;
		if(ComCodeTools.getBeforThreeCode(checkVerify.getComCode()).equals("231"))//上海
		{
			document = getSHCheckVerifyDocument(checkVerify, user, password);
		}
		if (document != null) {
			document.setXMLEncoding("gb2312");
			System.out.println("**********   查勘定损核损发送的 XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}

	/**
	 * 根据报案对象生成Document对象
	 * 
	 * @param regist
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception
	 */
	private static Document getRegistDocument(Regist regist, String user,String password) throws Exception 
	{
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET").addAttribute("type", "REQUEST").addAttribute("version", "1.0");
		
		Element headElement = packetElement.addElement("HEAD");
		headElement.addElement("REQUEST_TYPE").setText(Iconstants.RequstType.REGIST);
		headElement.addElement("USER").setText(user == null ? "" : user);
		headElement.addElement("PASSWORD").setText(password == null ? "" : password);
		
		Element bodyElement = packetElement.addElement("BODY");
		Element basePartElement = bodyElement.addElement("BASE_PART");
		basePartElement.addElement("CONFIRM_SEQUENCE_NO").setText(regist.getConfirmSequenceNo());  //投保确认码
		basePartElement.addElement("CLAIM_CODE").setText(regist.getClaimCode());
		basePartElement.addElement("POLICY_NO").setText(regist.getPolicyNO());
		basePartElement.addElement("REPORT_NO").setText(regist.getRegistNo());                     //报案号
		basePartElement.addElement("SPECIAL_REPORT_NO").setText("");                               //特殊报案号
		if(ComCodeTools.getBeforThreeCode(regist.getComCode()).equals("211")) 
		{
			basePartElement.addElement("REPORT_TIME").setText(new SimpleDateFormat("yyyyMMddHHmm").format(regist.getReportDate()));    //报案时间
		}else if(ComCodeTools.getBeforThreeCode(regist.getComCode()).equals("231"))
		{
			basePartElement.addElement("REPORT_TIME").setText(new SimpleDateFormat("yyyyMMddHHmmss").format(regist.getReportDate()));    //报案时间
		}else{
			basePartElement.addElement("REPORT_TIME").setText(new SimpleDateFormat("yyyyMMddHHmm").format(regist.getReportDate()));    //报案时间
		}
		/**
		 * 注意:出险时间此处要转换为强制保险平台要求的字符串格式
		 */
		if (ComCodeTools.getBeforThreeCode(regist.getComCode()).equals("231")) 
		{
			basePartElement.addElement("ACCIDENT_TIME").setText(new SimpleDateFormat("yyyyMMddHHmmss").format(regist.getDamageDate()));
		}else if(ComCodeTools.getBeforThreeCode(regist.getComCode()).equals("211")){
			basePartElement.addElement("ACCIDENT_TIME").setText(new SimpleDateFormat("yyyyMMddHHmm").format(regist.getDamageDate()));
		}else{
			basePartElement.addElement("ACCIDENT_TIME").setText(new SimpleDateFormat("yyyyMMddHHmm").format(regist.getDamageDate()));
		}
		basePartElement.addElement("CAR_MARK").setText(regist.getLicenseNo());                      //出险承保车辆号牌号码
		/**
		 * 注意可能需要针对车牌种类按强制保险平台代码进行转换
		 */
		basePartElement.addElement("VEHICLE_TYPE").setText(CodeTransfer.LicenseKindCode.covrentPlatFormCode(regist.getLicenseKindCode()));    //出险承保车辆号牌种类
		if (ComCodeTools.getBeforThreeCode(regist.getComCode()).equals("231"))
		{
			basePartElement.addElement("MANAGE_TYPE").setText(regist.getManageTypeCode());
			basePartElement.addElement("REPORTER").setText(regist.getReportorName());
			basePartElement.addElement("TEL").setText(regist.getPhoneNumber());
			basePartElement.addElement("WEATHER").setText(regist.getWeatherCode());
			basePartElement.addElement("OWNER").setText(regist.getOwner());
			basePartElement.addElement("DRIVER_NAME").setText(regist.getDriverName());
			basePartElement.addElement("CERTI_TYPE").setText(regist.getCertiType());
			basePartElement.addElement("CERTI_CODE").setText(regist.getCertiCode());
			basePartElement.addElement("LICENSE_NO").setText(regist.getArchivesNo());               //出险驾驶员档案编号
			basePartElement.addElement("LICENSE_EFFECTURAL_DATE").setText("");                      //出险驾驶员驾驶证有效日期
			basePartElement.addElement("ACCIDENT_PLACE").setText(regist.getDamageAddress());		//出险地点
			basePartElement.addElement("POLICY_PLACE").setText("1");           						//保单归属地，暂时写死为本地
			basePartElement.addElement("ACCIDENT_PLACE_MARK").setText(regist.getDamageAddreddCode());
		}
		/**
		 * add by DBIC sunzhaoyun 2007-06-06 北京平台调整 begin
		 */
		if (ComCodeTools.getBeforThreeCode(regist.getComCode()).equals("211")) 
		{
			basePartElement.addElement("MANAGE_TYPE").setText(
					regist.getManageTypeCode());
			basePartElement.addElement("ACCIDENT_CAUSE").setText(
					CodeTransfer.coventDamageTypeCodeToAccidentCause(regist
							.getDamageTypeCode()));
			basePartElement.addElement("ACCIDENT_PLACE").setText(
					regist.getDamageAddress());
			basePartElement.addElement("WEATHER").setText(
					regist.getWeatherCode());
			basePartElement.addElement("SECTION").setText(
					regist.getDamageAreacode());
			basePartElement.addElement("HURT_NUM").setText(
					regist.getDamageManCount());
			basePartElement.addElement("ACCIDENT_DESCRIPTION").setText(
					regist.getDamageContext());
			basePartElement.addElement("LIABILITY_AMOUNT").setText(
					CodeTransfer.coventIndemnityDutyToLiabilityAmount(regist
							.getIndemnityDuty()));
			basePartElement.addElement("TEL").setText(regist.getPhoneNumber());
		}
		if (!ComCodeTools.getBeforThreeCode(regist.getComCode()).equals("231")&&!ComCodeTools.getBeforThreeCode(regist.getComCode()).equals("211")) 
		{
		basePartElement.addElement("PAY_SELF_FLAG").setText(regist.getPaySelfFlag());
		basePartElement.addElement("ACCIDENT_PLACE").setText(regist.getDamageAddress());
		}
		/**
		 * add by DBIC sunzhaoyun 2007-06-06 北京平台调整 end
		 */
		if(ComCodeTools.getBeforThreeCode(regist.getComCode()).equals("231"))
		{
			Element objListElement = bodyElement.addElement("OBJ_LIST");
			for (int i = 0; i < regist.getCarLossList().size(); i++) {
				CarLoss carLoss = (CarLoss) regist.getCarLossList().get(i);
				Element objDataList = objListElement.addElement("OBJ_DATA");
				objDataList.addElement("OBJ_NAME").setText(carLoss.getLicenseNo());
				objDataList.addElement("VEHICLE_TYPE").setText(carLoss.getLicenseType());    		
				objDataList.addElement("OBJ_TYPE").setText(Iconstants.SHLossType.carLoss);
			}
		}else
		{
			Element thirdVehicleListElement = bodyElement.addElement("THIRD_VEHICLE_LIST");
			for (int i = 0; i < regist.getThirdCarList().size(); i++) {
				ThirdCar thirdCar = (ThirdCar) regist.getThirdCarList().get(i);			
				Element thirdVehicleDataList = thirdVehicleListElement.addElement("THIRD_VEHICLE_DATA");
				thirdVehicleDataList.addElement("CAR_MARK").setText(thirdCar.getLicenseNo());
				thirdVehicleDataList.addElement("POLICY_NO").setText("");
				thirdVehicleDataList.addElement("COMPANY_CODE").setText(thirdCar.getInsuredCompanyCode());
			}
		}
		return document;
	}
	/**
	 * 根据立案信息生成Document对象
	 * 
	 * @param regist
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception
	 */
	private static Document getClaimDocument(Claim claim, String user,String password) throws Exception 
	{
		Document document = DocumentHelper.createDocument();
		
		Element packetElement = document.addElement("PACKET").addAttribute("type", "REQUEST").addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("HEAD");
		
		headElement.addElement("REQUEST_TYPE").setText(Iconstants.RequstType.CLAIM);
		headElement.addElement("USER").setText(user);
		headElement.addElement("PASSWORD").setText(password);
		
		Element bodyElement = packetElement.addElement("BODY");
		Element basePart = bodyElement.addElement("BASE_PART");
		
		basePart.addElement("CONFIRM_SEQUENCE_NO").setText(claim.getConfirmSequenceNo());
		basePart.addElement("CLAIM_CODE").setText(claim.getClaimCode());
		basePart.addElement("ESTIMATE_AMOUNT").setText(new DecimalFormat("0.00").format(claim.getUnClaimAmount()));
		basePart.addElement("REPORT_NO").setText(claim.getRegistNo());
		basePart.addElement("CLAIM_NO").setText(claim.getClaimNo());		
		// add by sunmt 20070803 北京改造
		if (ComCodeTools.getBeforThreeCode(claim.getComCode()).equals("211")) 
		{
			basePart.addElement("REGISTRATION_DATE").setText(new SimpleDateFormat("yyyyMMddHHmm").format(claim.getClaimDate()));
		}
		// add by sunmt 20070803 北京改造
		// add by mouxh 20100929 上海改造
		else if(ComCodeTools.getBeforThreeCode(claim.getComCode()).equals("231"))
		{
			basePart.addElement("REGISTRATION_DATE").setText(new SimpleDateFormat("yyyyMMddHHmmss").format(claim.getClaimDate()));
		}
		// add by mouxh 20100929 上海改造
		//add by shaofan 20101208 REQ00002570：浙江交强险改造 start
		else {
			basePart.addElement("REGISTRATION_DATE").setText(new SimpleDateFormat("yyyyMMddHHmm").format(claim.getClaimDate()));
		}
		//add by shaofan 20101208 REQ00002570：浙江交强险改造 end
		basePart.addElement("CLAIM_TYPE").setText(CodeTransfer.IndemnityDuty1.covrentPlatFormCode(claim.getCaseType()));
		basePart.addElement("CAR_MARK").setText(claim.getLicenseNo());
		basePart.addElement("VEHICLE_TYPE").setText(CodeTransfer.LicenseKindCode.covrentPlatFormCode(claim.getLicenseType()));
		if (!ComCodeTools.getBeforThreeCode(claim.getComCode()).equals("231")&&!ComCodeTools.getBeforThreeCode(claim.getComCode()).equals("211")) 
		{
			basePart.addElement("ACCIDENT_TIME").setText(new SimpleDateFormat("yyyyMMddHHmm").format(claim.getDamageDate()));
			basePart.addElement("POLICY_NO").setText(claim.getPolicyNO());
			basePart.addElement("PAY_SELF_FLAG").setText(claim.getPaySelfFlag());
			basePart.addElement("ACCIDENT_PLACE").setText(claim.getDamageAddress());
		} else if (ComCodeTools.getBeforThreeCode(claim.getComCode()).equals("211")) 
		{
			basePart.addElement("ACCIDENT_TIME").setText(new SimpleDateFormat("yyyyMMddHHmm").format(claim.getDamageDate()));
		} else if(ComCodeTools.getBeforThreeCode(claim.getComCode()).equals("231"))
		{
			basePart.addElement("ACCIDENT_TIME").setText(new SimpleDateFormat("yyyyMMddHHmmss").format(claim.getDamageDate()));
			basePart.addElement("MANAGE_TYPE").setText(claim.getManageTypeCode());
			basePart.addElement("POLICY_PLACE").setText("1");                                                       //暂时写死保单归属地为本地
		}else 
		{
			basePart.addElement("ACCIDENT_TIME").setText(new SimpleDateFormat("yyyyMMddHH").format(claim.getDamageDate()));
		}

		/**
		 * add by DBIC sunzhaoyun 2007-06-06 北京平台调整 begin
		 */
		if (ComCodeTools.getBeforThreeCode(claim.getComCode()).equals("211")) 
		{
			basePart.addElement("MANAGE_TYPE").setText(claim.getManageTypeCode());
			basePart.addElement("ACCIDENT_CAUSE").setText(CodeTransfer.coventDamageTypeCodeToAccidentCause(claim.getDamageTypeCode()));
			
			basePart.addElement("INJURY_ACCIDENT").setText(claim.getInjuryFlag());
			basePart.addElement("BRIGANDAGE_ACCIDENT").setText(claim.getBrigandageFlag());
			basePart.addElement("FIRST_INVESTIGATE_TIME").setText(claim.getFirstInvestigateTime());
			basePart.addElement("ACCIDENT_LETTER").setText(claim.getAcciLetterFlag());
			basePart.addElement("ACCIDENT_LETTER_NO").setText(claim.getAcciLetterNo());
			basePart.addElement("ROAD_ACCIDENT").setText(claim.getRoadFlag());
		}
		/**
		 * add by DBIC sunzhaoyun 2007-06-06 北京平台调整 end
		 */
		
		//add by liuxin 20080516 start for 北京交强险信息库接口调整
		if (ComCodeTools.getBeforThreeCode(claim.getComCode()).equals("211"))
		{
			basePart.addElement("THIRD_VEHICLE").setText(claim.getThirdVehicleFlag());
		}
		//add by liuxin 20080516 end for 北京交强险信息库接口调整
		if(ComCodeTools.getBeforThreeCode(claim.getComCode()).equals("231"))
		{
			Element objListElement = bodyElement.addElement("OBJ_LIST");
			for (int i = 0; i < claim.getCarLossList().size(); i++) {
				CarLoss carLoss = (CarLoss) claim.getCarLossList().get(i);
				Element objDataList = objListElement.addElement("OBJ_DATA");
				objDataList.addElement("OBJ_NAME").setText(carLoss.getLicenseNo());
				objDataList.addElement("VEHICLE_TYPE").setText(carLoss.getLicenseType());
				objDataList.addElement("OBJ_TYPE").setText(Iconstants.SHLossType.carLoss);
			}
		}else
		{
			Element thirdVehicleList = bodyElement.addElement("THIRD_VEHICLE_LIST");
			for (Iterator it = claim.getThirdCarList().iterator(); it.hasNext();) {
				ThirdCar thirdCar = (ThirdCar) it.next();
				String thridParty = thirdCar.getLicenseNo();
				Element thirdVehicleDataList = thirdVehicleList.addElement("THIRD_VEHICLE_DATA");
				thirdVehicleDataList.addElement("CAR_MARK").setText(thridParty);
				thirdVehicleDataList.addElement("POLICY_NO").setText("");
				thirdVehicleDataList.addElement("COMPANY_CODE").setText(thirdCar.getInsuredCompanyCode());
			}
		}
		//add by liuxin 20080516 start for 北京交强险信息库接口调整
		if (ComCodeTools.getBeforThreeCode(claim.getComCode()).equals("211"))
		{
			Element thirdPersonList = bodyElement.addElement("THIRD_PERSON_LIST");
			for (Iterator it = claim.getThirdPersonList().iterator(); it.hasNext();) {
				ThirdPerson thirdPerson = (ThirdPerson)it.next();
				String thirdPersonName = thirdPerson.getPersonName();
				String thirdPersonIdentifyNumber = thirdPerson.getIdentifyNumber();
				Element thirdPersonDataList = thirdPersonList.addElement("THIRD_PERSON_DATA");
				thirdPersonDataList.addElement("PERSON_NAME").setText(thirdPersonName);
				thirdPersonDataList.addElement("PERSON_ID").setText(thirdPersonIdentifyNumber);
			}
		}
		//add by liuxin 20080516 end for 北京交强险信息库接口调整
		
		return document;
	}
	/**
	 * 根据理算信息生成Document对象
	 * 
	 * @param compensate
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception
	 */
	private static Document getCompensateDocument(Compensate compensate, String user,String password) throws Exception {
		Document document = null;
		if(ComCodeTools.getBeforThreeCode(compensate.getComCode()).equals("231"))
		{
			document = DocumentHelper.createDocument();
			Element packetElement = document.addElement("PACKET").addAttribute("type", "REQUEST").addAttribute("version", "1.0");
			
			Element headElement = packetElement.addElement("HEAD");
			headElement.addElement("REQUEST_TYPE").setText(Iconstants.RequstType.COMPENSATE);
			headElement.addElement("USER").setText(user);
			headElement.addElement("PASSWORD").setText(password);
			
			Element bodyElement = packetElement.addElement("BODY");
			Element basePart = bodyElement.addElement("BASE_PART");
			basePart.addElement("CLAIM_CODE").setText(compensate.getClaimCode());
			basePart.addElement("NUMERATION_START_TIME").setText(compensate.getNumerationStartTime());
			basePart.addElement("NUMERATION_END_TIME").setText(compensate.getNumerationEndTime());		
			basePart.addElement("ASSESOR_START_TIME").setText(compensate.getAssesorStartTime());		
			basePart.addElement("ASSESOR_END_TIME").setText(compensate.getAssesorEndTime());
			basePart.addElement("OTHER_AMOUNT").setText(new DecimalFormat("0.00").format(compensate.getOtherAmount()));
			basePart.addElement("ASSESOR_DES").setText(compensate.getAssesorDes());		
			basePart.addElement("ASSESOR_AMOUNT").setText(new DecimalFormat("0.00").format(compensate.getAssesorAmount()));
			basePart.addElement("DRIVER_NAME").setText(compensate.getDriverName());
			basePart.addElement("CERTI_TYPE").setText(compensate.getCertiType());
			basePart.addElement("CERTI_CODE").setText(compensate.getCertiCode());
			basePart.addElement("LICENSE_NO").setText(compensate.getArchivesNo());
			basePart.addElement("LICENSE_EFFECTURAL_DATE").setText("");
			basePart.addElement("ACCIDENT_PLACE").setText(compensate.getAccidentPlace());
			basePart.addElement("PROPORTIONA_CLAIM").setText(compensate.getProportionaClaim());
			basePart.addElement("ACCIDENT_PLACE_MARK").setText(compensate.getAccidentPlaceMark());
			Element claimCoverList = bodyElement.addElement("CLAIM_COVER_LIST");
			for (Iterator it=compensate.getLossSituationList().iterator(); it.hasNext();)
			{
				LossSituation lossSituation=(LossSituation)it.next();
				Element claimCoverDate = claimCoverList.addElement("CLAIM_COVER_DATA");
				claimCoverDate.addElement("POLICY_NO").setText(lossSituation.getPolicyNo());
				claimCoverDate.addElement("LIABILITY_RATE").setText(String.valueOf(new DecimalFormat("0.00").format(lossSituation.getIndemnitydutyrate())));
				System.out.println("【损失赔偿比例LIABILITY_RATE】----------"+String.valueOf(new DecimalFormat("0.00").format(lossSituation.getIndemnitydutyrate())));
				claimCoverDate.addElement("CLAIM_FEE_TYPE").setText(lossSituation.getLossType());//lossSituation.getLossType()
				claimCoverDate.addElement("COVERAGE_TYPE").setText(lossSituation.getRiskcodeType());
				claimCoverDate.addElement("COVERAGE_CODE").setText(CodeTransfer.CoverageCode.covrentPlatFormCode(lossSituation.getKindCode()));
				System.out.println("【kindcode】----------"+CodeTransfer.CoverageCode.covrentPlatFormCode(lossSituation.getKindCode()));
				claimCoverDate.addElement("LOSS_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(lossSituation.getSumLoss())));
				claimCoverDate.addElement("CLAIM_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(lossSituation.getSumPay())));
				
				Element detailList = claimCoverDate.addElement("DETAIL_LIST");
				for(Iterator itd=lossSituation.getLossSituationDetailList().iterator(); itd.hasNext();){
					System.out.println("【size】-----------"+lossSituation.getLossSituationDetailList().size());
					LossSituationDetail lossSituationDetail =(LossSituationDetail)itd.next();
					Element detailDate = detailList.addElement("DETAIL_DATA");
					detailDate.addElement("CLAIM_FEE_TYPE").setText(lossSituationDetail.getLossType());     	//损失赔偿类型
					if(lossSituationDetail.getLossType().equals(Iconstants.LossType.DEATH_CRIPPLE) || lossSituationDetail.getLossType().equals(Iconstants.LossType.NODUTY_DEATH_CRIPPLE))
					{//死亡伤残
						detailDate.addElement("DETAIL_FEE_TYPE").setText(CodeTransfer.SHBZDeadPersonLossType.covrentPlatFormCode(lossSituationDetail.getLossTypeDetail()));
						detailDate.addElement("LOSS_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(lossSituationDetail.getSumPay()))); 
						detailDate.addElement("CLAIM_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(lossSituationDetail.getSumPay())));
						detailDate.addElement("LIABILITY_RATE").setText(String.valueOf(new DecimalFormat("0.00").format(lossSituation.getIndemnitydutyrate())));
					}
					if(lossSituationDetail.getLossType().equals(Iconstants.LossType.MEDICAL) || lossSituationDetail.getLossType().equals(Iconstants.LossType.NODUTY_MEDICAL))
					{//医疗
						detailDate.addElement("DETAIL_FEE_TYPE").setText(CodeTransfer.SHBZMedicalPersonLossType.covrentPlatFormCode(lossSituationDetail.getLossTypeDetail()));
						detailDate.addElement("LOSS_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(lossSituationDetail.getSumPay()))); 
						detailDate.addElement("CLAIM_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(lossSituationDetail.getSumPay())));
						detailDate.addElement("LIABILITY_RATE").setText(String.valueOf(new DecimalFormat("0.00").format(lossSituation.getIndemnitydutyrate())));
					}
					if(lossSituationDetail.getLossType().equals(Iconstants.LossType.PROPERTY) || lossSituationDetail.getLossType().equals(Iconstants.LossType.NODUTY_PROPERTY))
					{//财产
						detailDate.addElement("DETAIL_FEE_TYPE").setText(CodeTransfer.SHBZPropPersonLossType.covrentPlatFormCode(lossSituationDetail.getLossTypeDetail()));
						detailDate.addElement("LOSS_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(lossSituationDetail.getSumPay()))); 
						detailDate.addElement("CLAIM_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(lossSituationDetail.getSumPay())));
						detailDate.addElement("LIABILITY_RATE").setText(String.valueOf(new DecimalFormat("0.00").format(lossSituation.getIndemnitydutyrate())));
					}
					if(lossSituationDetail.getLossType().equals(Iconstants.LossType.OTHER) || lossSituationDetail.getLossType().equals(Iconstants.LossType.NODUTY_OTHER))
					{//其他
						detailDate.addElement("DETAIL_FEE_TYPE").setText(CodeTransfer.SHBZOtherPersonLossType.covrentPlatFormCode(lossSituationDetail.getLossTypeDetail()));
						detailDate.addElement("LOSS_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(lossSituationDetail.getSumPay()))); 
						detailDate.addElement("CLAIM_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(lossSituationDetail.getSumPay())));
						detailDate.addElement("LIABILITY_RATE").setText(String.valueOf(new DecimalFormat("0.00").format(lossSituation.getIndemnitydutyrate())));
					}				
				}
			}
		}else
		{
			document = DocumentHelper.createDocument();
			Element packetElement = document.addElement("PACKET").addAttribute("type", "REQUEST").addAttribute("version", "1.0");
			Element headElement = packetElement.addElement("HEAD");
			headElement.addElement("REQUEST_TYPE").setText(Iconstants.RequstType.COMPENSATE);
			headElement.addElement("USER").setText(user);
			headElement.addElement("PASSWORD").setText(password);
			Element bodyElement = packetElement.addElement("BODY");
			Element basePart = bodyElement.addElement("BASE_PART");
			basePart.addElement("CONFIRM_SEQUENCE_NO").setText(compensate.getConfirmSequenceNo());
			basePart.addElement("CLAIM_CODE").setText(compensate.getClaimCode());
			basePart.addElement("REPORT_NO").setText(compensate.getRegistNo());
			basePart.addElement("CLAIM_NO").setText(compensate.getClaimNo());
			basePart.addElement("CAR_MARK").setText(compensate.getLicenseNo());
			basePart.addElement("VEHICLE_TYPE").setText(CodeTransfer.LicenseKindCode.covrentPlatFormCode(compensate.getLicenseType()));
			basePart.addElement("ACCIDENT_TIME").setText(new SimpleDateFormat("yyyyMMddHHmm").format(compensate.getDamageDate()));
			basePart.addElement("NUMERATION_DATE").setText(new SimpleDateFormat("yyyyMMddHHmm").format(compensate.getCompensateDate()));
			basePart.addElement("NUMERATION_AMOUNT").setText(new DecimalFormat("0.00").format(compensate.getAssesorAmount()));
			basePart.addElement("CLAIM_COST").setText(new DecimalFormat("0.00").format(compensate.getOtherAmount()));
			basePart.addElement("CLAIM_LETTER_NO").setText(String.valueOf(compensate.getCompensateNo()));
		}
		
		return document;
	}
	/**
	 * 根据单证信息生成Document对象
	 * @param certify
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception 
	 */
	private static Document getSHCertifyDocument(Certify certify,String user,String password) throws Exception
	{
		if(ComCodeTools.getBeforThreeCode(certify.getComCode()).equals("231"))
		{
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET")
		.addAttribute("type", "REQUEST")
		.addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("HEAD");
		headElement.addElement("REQUEST_TYPE").setText(Iconstants.RequstType.CERTIFY);
		headElement.addElement("USER").setText(user);
		headElement.addElement("PASSWORD").setText(password);
		Element bodyElement = packetElement.addElement("BODY");
		Element basePart = bodyElement.addElement("BASE_PART");
		basePart.addElement("CLAIM_CODE").setText(certify.getClaimCode());
		basePart.addElement("DOC_START_TIME").setText(certify.getDocStartTime());
		basePart.addElement("DOC_END_TIME").setText(certify.getDocEndTime());
		Element docList = bodyElement.addElement("DOC_LIST");
		for (Iterator it=certify.getCertiList().iterator(); it.hasNext();)
		{
			PrpLcertifyImgDto prpLcertifyImgDto = (PrpLcertifyImgDto) it.next();		
			Element docDate = docList.addElement("DOC_DATA");
			docDate.addElement("DOC_NAME").setText(prpLcertifyImgDto.getPicName());
		}
		return document;
		}else{
			return null;
		}
	}
//	/**
//	 * 根据支付信息生成DTO对象
//	 * 
//	 * @param regist
//	 * @param user
//	 * @param password
//	 * @return
//	 * @throws Exception
//	 */
//	private static Document getPayinforDocument(Payinfor payinfor, String user,
//			String password) throws Exception {
//		Document document = DocumentHelper.createDocument();
//		Element packetElement = document.addElement("PACKET").addAttribute(
//				"type", "REQUEST").addAttribute("version", "1.0");
//		Element headElement = packetElement.addElement("HEAD");
//		headElement.addElement("REQUEST_TYPE").setText(
//				Iconstants.RequstType.PAYINFOR);
//		headElement.addElement("USER").setText(user);
//		headElement.addElement("PASSWORD").setText(password);
//		Element bodyElement = packetElement.addElement("BODY");
//		Element basePart = bodyElement.addElement("BASE_PART");
//		basePart.addElement("CONFIRM_SEQUENCE_NO").setText(
//				payinfor.getConfirmSequenceNo());
//		basePart.addElement("CLAIM_CODE").setText(payinfor.getClaimCode());
//		basePart.addElement("REPORT_NO").setText(payinfor.getRegistNo());
//		basePart.addElement("CLAIM_NO").setText(payinfor.getClaimNo());
//
//		basePart.addElement("CAR_MARK").setText(payinfor.getLicenseNo());
//		basePart.addElement("VEHICLE_TYPE").setText(
//				CodeTransfer.LicenseKindCode.covrentPlatFormCode(payinfor
//						.getLicenseType()));
//	
//		basePart.addElement("ACCIDENT_TIME").setText(
//				new SimpleDateFormat("yyyyMMddHHmm").format(payinfor
//						.getDamageDate()));
//
//		basePart.addElement("NUMERATION_DATE").setText(
//				new SimpleDateFormat("yyyyMMddHHmm").format(payinfor
//						.getCompensateDate()));
//		basePart.addElement("NUMERATION_AMOUNT").setText(new DecimalFormat("0.00").format(payinfor.getSumPaid()));
//		basePart.addElement("CLAIM_COST").setText(new DecimalFormat("0.00").format(payinfor.getClaimCost()));
//		basePart.addElement("CLAIM_LETTER_NO").setText(String.valueOf(payinfor.getCompensateNo()));
//		
//		return document;
//	}
	/**
	 * 根据结案信息生成DTO对象
	 * 
	 * @param endCase
	 * @param user
	 * @param password
	 * @return
	 * @throws Exception
	 */
	private static Document getEndCaseDocument(EndCase endCase, String user,String password) throws Exception 
	{
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET").addAttribute("type", "REQUEST").addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("HEAD");
		
		headElement.addElement("REQUEST_TYPE").setText(Iconstants.RequstType.ENDCASE);
		headElement.addElement("USER").setText(user);
		headElement.addElement("PASSWORD").setText(password);
		
		Element bodyElement = packetElement.addElement("BODY");
		Element basePart = bodyElement.addElement("BASE_PART");
		
		basePart.addElement("CONFIRM_SEQUENCE_NO").setText(endCase.getConfirmSequenceNo());
		basePart.addElement("CLAIM_CODE").setText(endCase.getClaimCode());
		basePart.addElement("CLAIM_AMOUNT").setText(new DecimalFormat("0.00").format(endCase.getSumPaid()));
		if (ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("211")) 
		{
			basePart.addElement("LOSS_AMOUNT").setText(new DecimalFormat("0.00").format(endCase.getSumPaid()));
		}
		//add by shaofan 20101208 REQ00002570：浙江交强险改造 start
		if(!ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("231")&&!ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("211")) 
		{
			basePart.addElement("NORES_INSTEAD_AMOUNT").setText(new DecimalFormat("0.00").format(endCase.getSumNoDutyPaid()));
		}
		//add by shaofan 20101208 REQ00002570：浙江交强险改造 end		
		basePart.addElement("REPORT_NO").setText(endCase.getRegistNo());
		basePart.addElement("REGISTRATION_NO").setText(endCase.getClaimNo());
		basePart.addElement("CLAIM_NO").setText(endCase.getEndCaseNo());
		// add by sunmt 北京改造
		if (ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("211")) 
		{
			basePart.addElement("REPORT_TIME").setText(new SimpleDateFormat("yyyyMMddHHmm").format(endCase.getRegistTime()));
		}else if(ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("231"))
		{
			basePart.addElement("REPORT_TIME").setText(new SimpleDateFormat("yyyyMMddHHmmss").format(endCase.getRegistTime()));
		}else {
			basePart.addElement("REPORT_TIME").setText(new SimpleDateFormat("yyyyMMddHHmm").format(endCase.getRegistTime()));
		}
		if (!ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("231")&& !ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("211")) 
		{
			basePart.addElement("REGISTRATION_DATE").setText(new SimpleDateFormat("yyyyMMddHHmm").format(endCase.getClaimTime()));
			basePart.addElement("ENDCASE_DATE").setText(new SimpleDateFormat("yyyyMMddHHmm").format(endCase.getEndCaseTime()));
		// add by sunmt 北京改造
		}else if (ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("211"))
		{
			basePart.addElement("REGISTRATION_DATE").setText(new SimpleDateFormat("yyyyMMddHHmm").format(endCase.getClaimTime()));
			basePart.addElement("ENDCASE_DATE").setText(new SimpleDateFormat("yyyyMMddHHmm").format(endCase.getEndCaseTime()));
		}else if(ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("231")){
			basePart.addElement("REGISTRATION_DATE").setText(new SimpleDateFormat("yyyyMMddHHmmss").format(endCase.getClaimTime()));
			basePart.addElement("ENDCASE_DATE").setText(new SimpleDateFormat("yyyyMMddHHmmss").format(endCase.getEndCaseTime()));
		}else {
			basePart.addElement("REGISTRATION_DATE").setText(new SimpleDateFormat("yyyyMMddHHmm").format(endCase.getClaimTime()));
			basePart.addElement("ENDCASE_DATE").setText(new SimpleDateFormat("yyyyMMddHHmm").format(endCase.getEndCaseTime()));
		}
		/**
		 * 是否保险责任
		 */
		if (endCase.isInsuredDuty()) {
			basePart.addElement("INSURED").setText("1");
		} else {
			basePart.addElement("INSURED").setText("0");
		}
		basePart.addElement("CLAIM_TYPE").setText(CodeTransfer.IndemnityDuty1.covrentPlatFormCode(endCase.getCaseType()));
		basePart.addElement("PAY_CAUSE").setText(CodeTransfer.PrePayCause.covrentPlatFormCode(endCase.getPrepayreason()));
		basePart.addElement("REFUSE_CAUSE").setText(endCase.getRefusereason());
		basePart.addElement("CAR_MARK").setText(endCase.getLicenseNo());
		basePart.addElement("VEHICLE_TYPE").setText(CodeTransfer.LicenseKindCode.covrentPlatFormCode(endCase.getLicenseType()));
		basePart.addElement("DRIVER_NAME").setText(endCase.getDriverName());
		/**
		 * add by DBIC sunzhaoyun 2007-06-06 北京平台调整 begin
		 */
		if (ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("211")) 
		{
			basePart.addElement("SEX").setText(CodeTransfer.coventDriverSex(endCase.getDirverSex()));
			basePart.addElement("PERSON_APANAGE").setText(endCase.getDirverAddress());
		}
		/**
		 * add by DBIC sunzhaoyun 2007-06-06 北京平台调整 end
		 */

		basePart.addElement("CERTI_TYPE").setText(CodeTransfer.CertiType.covrentPlatFormCode(endCase.getCertiType()));
		basePart.addElement("CERTI_CODE").setText(endCase.getCertiCode());
		if (ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("231"))
		{
			basePart.addElement("LICENSE_NO").setText(endCase.getArchivesNo());
			basePart.addElement("LICENSE_EFFECTURAL_DATE").setText("");                                 //出险驾驶员驾驶证有效日期
			basePart.addElement("PERSON_NUM").setText(String.valueOf(endCase.getPersonNum()));
		}
		basePart.addElement("POLICY_NO").setText(endCase.getPolicyNo());
		if (ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("231"))
		{	
			basePart.addElement("ROAD_ACCIDENT").setText("");											//是否道路交通事故，0否，1是
			basePart.addElement("OTHER_AMOUNT").setText(new DecimalFormat("0.00").format(endCase.getOtherAmount()));
		}
		if (ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("211")) {			
			basePart.addElement("INJURY_ACCIDENT").setText(endCase.getInjuryFlag());
			basePart.addElement("BRIGANDAGE_ACCIDENT").setText(endCase.getBrigandageFlag());
			basePart.addElement("ACCIDENT_LETTER").setText(endCase.getAcciLetterFlag());
			basePart.addElement("ACCIDENT_LETTER_NO").setText(endCase.getAcciLetterNo());
			basePart.addElement("ROAD_ACCIDENT").setText(endCase.getRoadFlag());
			basePart.addElement("IRRESPONSIBILITY_PAYMENT").setText(endCase.getIrresponsibilityPayment());
		}
		
		//add by liuxin 20080516 start for 北京交强险信息库接口调整
		if (ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("211"))
		{
			basePart.addElement("THIRD_VEHICLE").setText(endCase.getThirdVehicleFlag());
		}
		//add by liuxin 20080516 end for 北京交强险信息库接口调整
		
		
		if (endCase.getAccidentInfor() != null)
		{
			basePart.addElement("ACCIDENT_TIME").setText(new SimpleDateFormat("yyyyMMddHHmm").format(endCase.getAccidentInfor().getAccidentTime()));
			basePart.addElement("ACCIDENT_PLACE").setText(endCase.getAccidentInfor().getAccidentPlace());
			basePart.addElement("ACCIDENT_DESCRIPTION").setText(endCase.getAccidentInfor().getAccidentDesc());
			basePart.addElement("MANAGE_DEPARTMENT").setText(CodeTransfer.AccidentDep.covrentPlatFormCode(endCase.getAccidentInfor().getAccidentdep()));
			basePart.addElement("LIABILITY_AMOUNT").setText(CodeTransfer.IndemnityDuty.covrentPlatFormCode(endCase.getAccidentInfor().getIndemnityDuty()));
			if (!ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("211")&& !ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("231")) 
			{
				basePart.addElement("ACCIDENT_DEATH").setText(endCase.getpersonDeath());
				basePart.addElement("PAY_SELF_FLAG").setText(endCase.getPaySelfFlag());
			}
			if(ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("211")||ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("231"))
			{
				basePart.addElement("MANAGE_TYPE").setText(endCase.getManageType());
			}
			if(ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("231")){
				basePart.addElement("ACCIDENT_PLACE_MARK").setText(endCase.getAccidentInfor().getAccidentPlaceCode()); 									//出险地点唯一标识
			}
			/**
			 * add by DBIC sunzhaoyun 2007-06-06 北京平台调整 begin
			 */
			if (ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("211")) 
			{
				basePart.addElement("ACCIDENT_CAUSE").setText(CodeTransfer.coventDamageTypeCodeToAccidentCause(endCase.getDamageTypeCode()));
				basePart.addElement("ACCI_SITE").setText(endCase.getDamageAddress());				
				//add by liuxin 20080516 start for 北京交强险信息库接口调整
				basePart.addElement("SECTION").setText(endCase.getAccidentInfor().getDamageAreaCode());
				//add by liuxin 20080516 end for 北京交强险信息库接口调整
			}
			/**
			 * add by DBIC sunzhaoyun 2007-06-06 北京平台调整 end
			 */
		}

		Element thirdVehicleList = bodyElement.addElement("THIRD_VEHICLE_LIST");
		for (Iterator it = endCase.getThirdCarList().iterator(); it.hasNext();) {
			ThirdCar thirdCar = (ThirdCar) it.next();
			String carMaker = thirdCar.getLicenseNo();
			String policyNo = thirdCar.getPolicyNo();
			String vehicleType = thirdCar.getLicenseKindCode();
			String irresponsibilityCompany = thirdCar.getInsuredCompanyCode();
			if(!("").equals(irresponsibilityCompany)){
				if (ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("211")) 
				{
					irresponsibilityCompany = irresponsibilityCompany + "02";
				}else if (ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("231"))
				{
					irresponsibilityCompany = irresponsibilityCompany + "01";
				}
			}
			double advanceAmount = thirdCar.getRealPaid();
			Element claimThirdVehicleDate =  thirdVehicleList.addElement("THIRD_VEHICLE_DATA");
			if(ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("231"))
			{
				claimThirdVehicleDate.addElement("CAR_MARK").setText(carMaker);
				claimThirdVehicleDate.addElement("VEHICLE_TYPE").setText(vehicleType);
				claimThirdVehicleDate.addElement("IRRESPONSIBILITY_COMPANY").setText(irresponsibilityCompany);
				claimThirdVehicleDate.addElement("ADVANCE_AMOUNT").setText(new DecimalFormat("0.00").format(advanceAmount));
			}else
			{
				claimThirdVehicleDate.addElement("CAR_MARK").setText(carMaker);
				claimThirdVehicleDate.addElement("VEHICLE_TYPE").setText(vehicleType);
				claimThirdVehicleDate.addElement("IRRESPONSIBILITY_COMPANY").setText(irresponsibilityCompany);
				claimThirdVehicleDate.addElement("ADVANCE_AMOUNT").setText(new DecimalFormat("0.00").format(advanceAmount));
				claimThirdVehicleDate.addElement("POLICY_NO").setText(policyNo);
				claimThirdVehicleDate.addElement("COMPANY_CODE").setText(irresponsibilityCompany);
			}
		}
		
		//add by liuxin 20080516 start for 北京交强险信息库接口调整
		if (ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("211")) 
		{
			
			Element thirdPersonList = bodyElement.addElement("THIRD_PERSON_LIST");
			for (Iterator it = endCase.getThirdPersonList().iterator(); it.hasNext();) {
				ThirdPerson thirdPerson = (ThirdPerson)it.next();
				String thirdPersonName = thirdPerson.getPersonName();
				String thirdPersonIdentifyNumber = thirdPerson.getIdentifyNumber();		
				Element thirdPersonDataList = thirdPersonList.addElement("THIRD_PERSON_DATA");
				thirdPersonDataList.addElement("PERSON_NAME").setText(thirdPersonName);
				thirdPersonDataList.addElement("PERSON_ID").setText(thirdPersonIdentifyNumber);
			}

		}
		//add by liuxin 20080516 end for 北京交强险信息库接口调整
		
		if(!ComCodeTools.getBeforThreeCode(endCase.getComCode()).equals("231"))
		{
			Element claimCoverList = bodyElement.addElement("CLAIM_COVER_LIST");
			for (Iterator it = endCase.getLossSituationList().iterator(); it
					.hasNext();) {
				LossSituation lossSituation = (LossSituation) it.next();
				Element claimCoverDate = claimCoverList
						.addElement("CLAIM_COVER_DATA");
				claimCoverDate.addElement("POLICY_NO").setText(
						lossSituation.getPolicyNo());
				claimCoverDate.addElement("LIABILITY_RATE").setText(
						new DecimalFormat("0.00").format(lossSituation.getIndemnitydutyrate()));
				claimCoverDate.addElement("CLAIM_FEE_TYPE").setText(
						lossSituation.getLossType());
				claimCoverDate.addElement("CLAIM_AMOUNT").setText(
						new DecimalFormat("0.00").format(lossSituation.getSumPay()));
				claimCoverDate.addElement("COVERAGE_TYPE").setText(
						lossSituation.getRiskcodeType());
				claimCoverDate.addElement("COVERAGE_CODE").setText(
						lossSituation.getRiskcode());
				claimCoverDate.addElement("LOSS_AMOUNT").setText(
						new DecimalFormat("0.00").format(lossSituation.getSumLoss()));

				if (lossSituation.getLossSituationDetailList() != null
						&& lossSituation.getLossSituationDetailList().size() > 0) {
					Element detailList = claimCoverDate.addElement("DETAIL_LIST");
					for (Iterator dit = lossSituation.getLossSituationDetailList()
							.iterator(); dit.hasNext();) {
						LossSituationDetail lossSituationDetail = (LossSituationDetail) dit
								.next();
						Element detailDate = detailList.addElement("DETAIL_DATA");
						detailDate.addElement("CLAIM_FEE_TYPE").setText(
								lossSituationDetail.getLossType());
						detailDate.addElement("DETAIL_FEE_TYPE").setText(
								CodeTransfer.LossTypeDetail
										.covrentPlatFormCode(lossSituationDetail
												.getLossTypeDetail()));
						detailDate.addElement("LOSS_AMOUNT").setText(
								new DecimalFormat("0.00").format(lossSituationDetail.getSumLoss()));
						detailDate.addElement("CLAIM_AMOUN").setText(
								new DecimalFormat("0.00").format(lossSituationDetail.getSumPay()));
						detailDate.addElement("LIABILITY_RATE").setText(
								new DecimalFormat("0.00").format(lossSituationDetail
										.getIndemnitydutyrate()));

					}
				}

			}
		}

		return document;

	}

	/**
	 * 根据结案追加信息生成XML
	 * 
	 * @param appEndCase
	 * @param user
	 * @param password
	 * @return
	 */
	private static Document getEndCaseAppendDocument(EndCaseAppend endCaseApp,
			String user, String password) {
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET").addAttribute(
				"type", "REQUEST").addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("HEAD");
		headElement.addElement("REQUEST_TYPE").setText(Iconstants.RequstType.ENDCASE_APPEND);
		headElement.addElement("USER").setText(user);
		headElement.addElement("PASSWORD").setText(password);
		Element bodyElement = packetElement.addElement("BODY");
		Element basePart = bodyElement.addElement("BASE_PART");
		basePart.addElement("CLAIM_CODE").setText(endCaseApp.getClaimCode());
		basePart.addElement("SERIAL_NO").setText(endCaseApp.getSerialNo());
		basePart.addElement("CLAIM_APPEND_DATE").setText(
				new SimpleDateFormat("yyyyMMdd").format(endCaseApp.getRecaseDate()));
		basePart.addElement("ACCIDENT_DEATH").setText(endCaseApp.getAccidentDeath());
		Element claimCoverList = bodyElement.addElement("CLAIM_COVER_LIST");
		for (Iterator it = endCaseApp.getEndCaseAppSituationList().iterator(); it.hasNext();) {
			EndCaseAppSituation endCaseAppSituation = (EndCaseAppSituation) it.next();
			Element claimCoverDate = claimCoverList.addElement("CLAIM_COVER_DATA");
			claimCoverDate.addElement("CLAIM_FEE_TYPE").setText(endCaseAppSituation.getLossType());
			claimCoverDate.addElement("CLAIM_AMOUNT").setText(
					new DecimalFormat("0.00").format(endCaseAppSituation.getAppPaySum()));
		}

		return document;
	}
	/**
	 * 根据上海结案追加信息生成Document对象
	 * 
	 * @param appEndCase
	 * @param user
	 * @param password
	 * @return
	 */
	private static Document getSHEndCaseAppendDocument(EndCaseAppend endCaseApp,
			String user, String password) {
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET")
		.addAttribute("type", "REQUEST")
		.addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("HEAD");
		headElement.addElement("REQUEST_TYPE").setText(Iconstants.RequstType.ENDCASE_APPEND);
		headElement.addElement("USER").setText(user);
		headElement.addElement("PASSWORD").setText(password);
		Element bodyElement = packetElement.addElement("BODY");
		Element basePart = bodyElement.addElement("BASE_PART");
		basePart.addElement("CLAIM_CODE").setText(endCaseApp.getClaimCode());
		basePart.addElement("REASON_TYPE").setText(Iconstants.ReasonType.SS);
		basePart.addElement("DOC_START_TIME").setText(endCaseApp.getDocStartTime());
		basePart.addElement("DOC_END_TIME").setText(endCaseApp.getDocEndTime());
		basePart.addElement("NUMERATION_START_TIME").setText(endCaseApp.getNumerationStartTime());
		basePart.addElement("NUMERATION_END_TIME").setText(endCaseApp.getNumerationEndTime());
		basePart.addElement("ADD_TIME").setText(new SimpleDateFormat("yyyyMMddHHmmss").format(endCaseApp.getRecaseDate()));
		
		Element claimCoverList = bodyElement.addElement("CLAIM_COVER_LIST");
		for (Iterator it=endCaseApp.getEndCaseAppSituationList().iterator(); it.hasNext();)
		{
			EndCaseAppSituation endCaseAppSituation=(EndCaseAppSituation)it.next();
			Element claimCoverDate = claimCoverList.addElement("CLAIM_COVER_DATA");
			if(endCaseAppSituation.getLossType().equals("4"))
			{
				endCaseAppSituation.setLossType("1");
			}
			claimCoverDate.addElement("POLICY_NO").setText(endCaseApp.getPolicyNO());
			claimCoverDate.addElement("LIABILITY_RATE").setText(String.valueOf(new DecimalFormat("0.00").format(endCaseApp.getIndemnitydutyRate())));
			claimCoverDate.addElement("CLAIM_FEE_TYPE").setText(endCaseAppSituation.getLossType());     //损失赔偿类型
			claimCoverDate.addElement("COVERAGE_TYPE").setText(Iconstants.RiskCodeType.COMPEL_THIRD);
			claimCoverDate.addElement("COVERAGE_CODE").setText(CodeTransfer.CoverageCode.covrentPlatFormCode(endCaseAppSituation.getKindCode()));
			
			claimCoverDate.addElement("LOSS_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(endCaseAppSituation.getAppPaySum())));
			claimCoverDate.addElement("CLAIM_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(endCaseAppSituation.getAppPaySum())));
			Element detailList = claimCoverDate.addElement("DETAIL_LIST");							//赔偿损失明细
			for (Iterator itd=endCaseAppSituation.getEndCaseSituationDetailList().iterator(); itd.hasNext();)
			{
				LossSituationDetail LossSituationDetail=(LossSituationDetail)itd.next();
				Element detailDate = detailList.addElement("DETAIL_DATA");
				if(endCaseAppSituation.getLossType().equals("4"))
				{
					endCaseAppSituation.setLossType("1");
				}
				detailDate.addElement("LIABILITY_RATE").setText(String.valueOf(new DecimalFormat("0.00").format(LossSituationDetail.getIndemnitydutyrate())));
				detailDate.addElement("CLAIM_FEE_TYPE").setText(endCaseAppSituation.getLossType());     	//损失赔偿类型
				if(endCaseAppSituation.getLossType().equals(Iconstants.LossType.DEATH_CRIPPLE) || endCaseAppSituation.getLossType().equals(Iconstants.LossType.NODUTY_DEATH_CRIPPLE))
				{//死亡伤残
					detailDate.addElement("DETAIL_FEE_TYPE").setText(CodeTransfer.SHBZDeadPersonLossType.covrentPlatFormCode(LossSituationDetail.getLossTypeDetail()));
					detailDate.addElement("LOSS_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(LossSituationDetail.getSumPay()))); 
					detailDate.addElement("CLAIM_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(LossSituationDetail.getSumPay())));
				}
				if(endCaseAppSituation.getLossType().equals(Iconstants.LossType.MEDICAL) || endCaseAppSituation.getLossType().equals(Iconstants.LossType.NODUTY_MEDICAL))
				{//医疗
					detailDate.addElement("DETAIL_FEE_TYPE").setText(CodeTransfer.SHBZMedicalPersonLossType.covrentPlatFormCode(LossSituationDetail.getLossTypeDetail()));
					detailDate.addElement("LOSS_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(LossSituationDetail.getSumPay()))); 
					detailDate.addElement("CLAIM_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(LossSituationDetail.getSumPay())));	
				}
				if(endCaseAppSituation.getLossType().equals(Iconstants.LossType.PROPERTY) || endCaseAppSituation.getLossType().equals(Iconstants.LossType.NODUTY_PROPERTY))
				{//财产
					detailDate.addElement("DETAIL_FEE_TYPE").setText(CodeTransfer.SHBZPropPersonLossType.covrentPlatFormCode(LossSituationDetail.getLossTypeDetail()));
					detailDate.addElement("LOSS_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(LossSituationDetail.getSumPay()))); 
					detailDate.addElement("CLAIM_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(LossSituationDetail.getSumPay())));	
				}
				if(endCaseAppSituation.getLossType().equals(Iconstants.LossType.OTHER) || endCaseAppSituation.getLossType().equals(Iconstants.LossType.NODUTY_OTHER))
				{//其他
					detailDate.addElement("DETAIL_FEE_TYPE").setText(CodeTransfer.SHBZOtherPersonLossType.covrentPlatFormCode(LossSituationDetail.getLossTypeDetail()));
					detailDate.addElement("LOSS_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(LossSituationDetail.getSumPay()))); 
					detailDate.addElement("CLAIM_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(LossSituationDetail.getSumPay())));
				}				
			}
		}
		
		Element personList = bodyElement.addElement("PERSON_LIST");
		for (Iterator it=endCaseApp.getPersonLossList().iterator(); it.hasNext();)
		{
			PersonLoss personLoss=(PersonLoss)it.next();			
			Element personDate = personList.addElement("PERSON_DATA");
			personDate.addElement("PERSON_NAME").setText(personLoss.getPersonName());
			personDate.addElement("PERSON_ID").setText(personLoss.getIdentifyNumber());
			personDate.addElement("AGE").setText(personLoss.getAge());
			personDate.addElement("LOSS_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(personLoss.getSumDuty())));
			personDate.addElement("MAIN_THIRD").setText("0");
			personDate.addElement("SURVEY_TYPE").setText(endCaseApp.getSurveyType());
			personDate.addElement("SURVEY_NAME").setText(endCaseApp.getSurveyName());
			personDate.addElement("SURVEY_START_TIME").setText(endCaseApp.getSurveyStartTime());
			personDate.addElement("SURVEY_END_TIME").setText(endCaseApp.getSurveyEndTime());
			personDate.addElement("SURVEY_PLACE").setText(endCaseApp.getSurveyPlace());
			personDate.addElement("SURVEY_DES").setText(endCaseApp.getSurveyDes());
			personDate.addElement("ESTIMATE_NAME").setText(personLoss.getEsimateName());
			personDate.addElement("ESTIMATE_START_TIME").setText(personLoss.getEsimateStartTime());
			personDate.addElement("ESTIMATE_END_TIME").setText(personLoss.getEsimateEndTime());
			personDate.addElement("ASSESOR_NAME").setText(personLoss.getAssesorName());
			personDate.addElement("ASSESOR_START_TIME").setText(personLoss.getAssesorStartTime());
			personDate.addElement("ASSESOR_END_TIME").setText(personLoss.getAssesorEndTime());
			Element LossPartList = personDate.addElement("LOSS_PART_LIST");
			for (Iterator itd=personLoss.getPersonLossDetailList().iterator(); itd.hasNext();)
			{
				PersonLoss personDetailLoss=(PersonLoss)itd.next();
				Element LossPartDate = LossPartList.addElement("LOSS_PART_DATA");
				LossPartDate.addElement("FEE_TYPE").setText(CodeTransfer.SHPersonLossType.covrentPlatFormCode(personDetailLoss.getFeeType()));
				LossPartDate.addElement("LOSS_AMOUNT").setText(new DecimalFormat("0.00").format(personDetailLoss.getSumDuty()));
				LossPartDate.addElement("INJURY_TYPE").setText(personDetailLoss.getInjuryType());
				LossPartDate.addElement("INJURY_LEVEL").setText(personDetailLoss.getInjuryLevel());
				LossPartDate.addElement("INJURY_PART").setText(personDetailLoss.getInjuryPart());
				LossPartDate.addElement("HOSPITAL").setText(personDetailLoss.getHospital());
			}
		}
		Element vehicleList = bodyElement.addElement("VEHICLE_LIST");
		for (Iterator it=endCaseApp.getCarLossList().iterator(); it.hasNext();)
		{
			CarLoss carLoss=(CarLoss)it.next();			
			Element vehicleDate = vehicleList.addElement("VEHICLE_DATA");
			vehicleDate.addElement("CAR_MARK").setText(carLoss.getLicenseNo());
			vehicleDate.addElement("VEHICLE_TYPE").setText(carLoss.getLicenseType());
			vehicleDate.addElement("LOSS_AMOUNT").setText(new DecimalFormat("0.00").format(carLoss.getSumLoss()));
			vehicleDate.addElement("MAIN_THIRD").setText(carLoss.getInsureCarFlag());
			vehicleDate.addElement("ROBBER").setText("0");
			vehicleDate.addElement("SURVEY_TYPE").setText(endCaseApp.getSurveyType());
			vehicleDate.addElement("SURVEY_NAME").setText(endCaseApp.getSurveyName());
			vehicleDate.addElement("SURVEY_START_TIME").setText(endCaseApp.getSurveyStartTime());
			vehicleDate.addElement("SURVEY_END_TIME").setText(endCaseApp.getSurveyEndTime());
			vehicleDate.addElement("SURVEY_PLACE").setText(endCaseApp.getSurveyPlace());
			vehicleDate.addElement("SURVEY_DES").setText(endCaseApp.getSurveyDes());
			//vehicleDate.addElement("REPAIR_ORG").setText(carLoss.getVerifyLossRepairFactory());
			vehicleDate.addElement("ESTIMATE_NAME").setText(carLoss.getEsimateName());
			vehicleDate.addElement("ESTIMATE_START_TIME").setText(carLoss.getEsimateStartTime());
			vehicleDate.addElement("ESTIMATE_END_TIME").setText(carLoss.getEsimateEndTime());
			vehicleDate.addElement("ASSESOR_NAME").setText(carLoss.getAssesorName());
			vehicleDate.addElement("ASSESOR_START_TIME").setText(carLoss.getAssesorStartTime());
			vehicleDate.addElement("ASSESOR_END_TIME").setText(carLoss.getAssesorEndTime());
			vehicleDate.addElement("REMNANT").setText(new DecimalFormat("0.00").format(carLoss.getSumManager()));
			vehicleDate.addElement("CHARGE_FEE").setText(new DecimalFormat("0.00").format(carLoss.getSumRest()));
			vehicleDate.addElement("TOTAL_WORKING_HOUR").setText(new DecimalFormat("0.00").format(carLoss.getTotalWorkHour()));
			vehicleDate.addElement("CHANGE_OR_REPAIR_PART").setText(carLoss.getChangeOrRepairPart());
			vehicleDate.addElement("JY_VEHICLE_CODE").setText("");
			vehicleDate.addElement("MADE_FACTORY").setText("无");
			vehicleDate.addElement("VEHICLE_BRAND_CODE").setText("");
			vehicleDate.addElement("VEHICLE_CATENA_CODE").setText("");
			vehicleDate.addElement("VEHICLE_GROUP_CODE").setText("");
			vehicleDate.addElement("PRICE_SLT_CODE").setText("01");
			vehicleDate.addElement("DEFINE_FLAG").setText("0");
			Element LossPartList = vehicleDate.addElement("LOSS_PART_LIST");
			Element LossPartDate = LossPartList.addElement("LOSS_PART_DATA");
			LossPartDate.addElement("LOSS_PART").setText("");
			Element fittingList = vehicleDate.addElement("FITTING_LIST");
			for (Iterator itd=carLoss.getCarLossDetailList().iterator(); itd.hasNext();)
			{
				CarLoss carDetailLoss=(CarLoss)itd.next();
				Element fittingDate = fittingList.addElement("FITTING_DATA");
				fittingDate.addElement("CHANGE_PART_NAME").setText(carDetailLoss.getChangePartName());
				fittingDate.addElement("CHANGE_PART_NUM").setText(String.valueOf(carDetailLoss.getChangePartNum()));
				fittingDate.addElement("CHANGE_PART_FEE").setText(new DecimalFormat("0.00").format(carDetailLoss.getChangePartFee()));
				fittingDate.addElement("CHANGE_PART_TIME").setText(new DecimalFormat("0.00").format(carDetailLoss.getChangePartTime()));
				fittingDate.addElement("CHANGE_PART_MANPOWER_FEE").setText(new DecimalFormat("0.00").format(carDetailLoss.getChangePartManpowerFee()));
				fittingDate.addElement("REPAIR_PART_NAME").setText(carDetailLoss.getRepairPartName());
				fittingDate.addElement("REPAIR_PART_NUM").setText(String.valueOf(carDetailLoss.getRepairPartNum()));
				fittingDate.addElement("REPAIR_PART_FEE").setText(new DecimalFormat("0.00").format(carDetailLoss.getRepairPartFee()));
				fittingDate.addElement("REPAIR_PART_TIME").setText(new DecimalFormat("0.00").format(carDetailLoss.getRepairPartTime()));
				fittingDate.addElement("REPAIR_PART_MANPOWER_FEE").setText(new DecimalFormat("0.00").format(carDetailLoss.getRepairPartManpowerFee()));
				fittingDate.addElement("REPAIR_METHORD").setText(carDetailLoss.getRepairMethord());
				fittingDate.addElement("JY_PART_CODE").setText("");
				fittingDate.addElement("OEM_PART_CODE").setText(carDetailLoss.getOemPartCode());
				fittingDate.addElement("DEFINE_FLAG").setText(carDetailLoss.getDefineFlag());
				fittingDate.addElement("SUBJION_FLAG").setText(carDetailLoss.getSubjionFlag());				
			}
			Element repairList = vehicleDate.addElement("REPAIR_LIST");
			for (Iterator itd=carLoss.getCarLossDetailList().iterator(); itd.hasNext();)
			{
				CarLoss carLossFac=(CarLoss)itd.next();
				Element repairDate = repairList.addElement("REPAIR_DATA");
				repairDate.addElement("REPAIR_ORG").setText(carLossFac.getVerifyLossRepairFactory());
			}
		}
		Element objList = bodyElement.addElement("OBJ_LIST");
		for (Iterator it=endCaseApp.getPropLossList().iterator(); it.hasNext();)
		{
			PropLoss propLoss=(PropLoss)it.next();			
			Element propDate = objList.addElement("OBJ_DATA");
			propDate.addElement("OBJECT_DESC").setText(propLoss.getPropDesc());
			propDate.addElement("LOSS_NUM").setText("");
			propDate.addElement("LOSS_AMOUNT").setText(new DecimalFormat("0.00").format(propLoss.getSumLoss()));
			propDate.addElement("MAIN_THIRD").setText("1");
			propDate.addElement("SURVEY_TYPE").setText(endCaseApp.getSurveyType());
			propDate.addElement("SURVEY_NAME").setText(endCaseApp.getSurveyName());
			propDate.addElement("SURVEY_START_TIME").setText(endCaseApp.getSurveyStartTime());
			propDate.addElement("SURVEY_END_TIME").setText(endCaseApp.getSurveyEndTime());
			propDate.addElement("SURVEY_PLACE").setText(endCaseApp.getSurveyPlace());
			propDate.addElement("SURVEY_DES").setText(endCaseApp.getSurveyDes());
			propDate.addElement("ESTIMATE_NAME").setText(propLoss.getEsimateName());
			propDate.addElement("ESTIMATE_START_TIME").setText(propLoss.getEsimateStartTime());
			propDate.addElement("ESTIMATE_END_TIME").setText(propLoss.getEsimateEndTime());
			propDate.addElement("ASSESOR_NAME").setText(propLoss.getAssesorName());
			propDate.addElement("ASSESOR_START_TIME").setText(propLoss.getAssesorStartTime());
			propDate.addElement("ASSESOR_END_TIME").setText(propLoss.getAssesorEndTime());
		}
		return document;
	}
	/**
	 * 根据案件注销信息生成Document对象
	 * 
	 * @param appEndCase
	 * @param user
	 * @param password
	 * @return
	 */
	private static Document getCancelCaseDocument(CancelCase cancelCase,
			String user, String password)throws Exception {
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET").addAttribute("type", "REQUEST").addAttribute("version", "1.0");
		
		Element headElement = packetElement.addElement("HEAD");
		headElement.addElement("REQUEST_TYPE").setText(Iconstants.RequstType.CANCELCASE);
		headElement.addElement("USER").setText(user);
		headElement.addElement("PASSWORD").setText(password);
		
		Element bodyElement = packetElement.addElement("BODY");
		Element basePart = bodyElement.addElement("BASE_PART");
		basePart.addElement("CLAIM_CODE").setText(cancelCase.getClaimCode());
		if(ComCodeTools.getBeforThreeCode(cancelCase.getComCode()).equals("231"))
		{
			basePart.addElement("REJECT_REASON").setText(cancelCase.getCancelCause());
		}
		//add by shaofan 20101208 REQ00002570：浙江交强险改造 start		
		if(!ComCodeTools.getBeforThreeCode(cancelCase.getComCode()).equals("211") && !ComCodeTools.getBeforThreeCode(cancelCase.getComCode()).equals("231"))
		{
			basePart.addElement("CANCEL_TYPE").setText(cancelCase.getCancelType());
			basePart.addElement("CANCEL_CAUSE").setText(cancelCase.getCancelCause());
			basePart.addElement("CANCEL_DESC").setText("");
		}
		//add by shaofan 20101208 REQ00002570：浙江交强险改造 end		
		return document;
	}

	/**
	 * 根据Document对象生成RegistDTO对象
	 * 
	 * @param xmlStr
	 * @return
	 * @throws DocumentException
	 */
	public static ReturnInfo getReturnRegistFromXML(String xmlStr)
			throws ParseException, DocumentException {
		ReturnInfo returnInfo = null;
		HistoryClaim historyClaim = null;
		try {
			returnInfo = new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			// 得到根节点PACKET
			Element packet = document.getRootElement();
			// 得到HEAD节点
			for (Iterator it = packet.elementIterator("HEAD"); it.hasNext();) {
				Element head = (Element) it.next();
				returnInfo.setRequestType(parseNode(head
						.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setReturnType(parseNode(head
						.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
			}
			// 得到BODY节点
			for (Iterator bit = packet.elementIterator("BODY"); bit.hasNext();) {
				Element body = (Element) bit.next();
				// 得到BASE_PART节点
				Element basepart = (Element) body.selectSingleNode("BASE_PART");
				returnInfo.setClaimCode(parseNode(basepart
						.selectSingleNode("CLAIM_CODE")));
				// 得到CLAIM_LIST节点
				Element claimList = (Element) body
						.selectSingleNode("CLAIM_LIST");
				// 遍历CLAIM_DATA列表
				for (Iterator it = claimList.elementIterator("CLAIM_DATA"); it
						.hasNext();) {
					historyClaim = new HistoryClaim();
					Element claimDate = (Element) it.next();
					historyClaim.setClaimCompany(CodeTransfer.ClaimCompany
							.covrentSystemCode(parseNode(claimDate
									.selectSingleNode("CLAIM_COMPANY"))));
					historyClaim.setRegistNo(parseNode(claimDate
							.selectSingleNode("REPORT_NO")));
					historyClaim.setClaimNo(parseNode(claimDate
							.selectSingleNode("CLAIM_NO")));
					historyClaim.setPolicyNo(parseNode(claimDate
							.selectSingleNode("POLICY_NO")));
					historyClaim.setAccidentTime(getDate(claimDate,
							"ACCIDENT_TIME"));
					historyClaim.setRegistTime(getDate(claimDate, 
							"REPORT_TIME"));
					historyClaim.setEndCaseTime(getDate(claimDate,
							"ENDCASE_DATE"));

					historyClaim.setUnClaimAmount(parseDouble(parseNode(claimDate
									.selectSingleNode("UNCLAIM_AMOUNT"))));
					historyClaim.setCaseStatus(parseNode(claimDate
							.selectSingleNode("STATUS")));
					historyClaim.setAccidentPlace(parseNode(claimDate
							.selectSingleNode("ACCIDENT_PLACE")));
					historyClaim.setAccidentDesc(parseNode(claimDate
							.selectSingleNode("ACCIDENT_DESCRIPTION")));
					historyClaim.setIndemnityDuty(CodeTransfer.IndemnityDuty
							.covrentSystemCode(parseNode(claimDate
									.selectSingleNode("ACCIDENT_TYPE"))));
					returnInfo.addHistoryClaim(historyClaim);
				}
			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		return returnInfo;
	}

	/**
	 * 根据Document对象生成ClaimDTO对象
	 * 
	 * @param xmlStr
	 * @return
	 * @throws DocumentException
	 */
	public static ReturnInfo getReturnClaimFromXML(String xmlStr)
			throws ParseException, DocumentException {
		ReturnInfo returnInfo = null;
		HistoryClaim historyClaim = null;
		try {
			returnInfo = new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			// 得到根节点PACKET
			Element packet = document.getRootElement();
			// 得到HEAD节点
			for (Iterator it = packet.elementIterator("HEAD"); it.hasNext();) {
				Element head = (Element) it.next();
				returnInfo.setRequestType(parseNode(head
						.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setReturnType(parseNode(head
						.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
			}
			// 得到BODY节点
			for (Iterator bit = packet.elementIterator("BODY"); bit.hasNext();) {
				Element body = (Element) bit.next();

				// 得到BASE_PART节点
				Element basepart = (Element) body.selectSingleNode("BASE_PART");
				returnInfo.setClaimCode(parseNode(basepart
						.selectSingleNode("CLAIM_CODE")));
				// 得到CLAIM_LIST节点
				Element claimList = (Element) body
						.selectSingleNode("CLAIM_LIST");
				// 遍历CLAIM_DATA列表
				for (Iterator it = claimList.elementIterator("CLAIM_DATA"); it
						.hasNext();) {
					historyClaim = new HistoryClaim();
					Element claimDate = (Element) it.next();
					historyClaim.setClaimCompany(CodeTransfer.ClaimCompany
							.covrentSystemCode(parseNode(claimDate
									.selectSingleNode("CLAIM_COMPANY"))));
					historyClaim.setRegistNo(parseNode(claimDate
							.selectSingleNode("REPORT_NO")));
					historyClaim.setClaimNo(parseNode(claimDate
							.selectSingleNode("CLAIM_NO")));
					historyClaim.setPolicyNo(parseNode(claimDate
							.selectSingleNode("POLICY_NO")));
					historyClaim.setAccidentTime(getDate(claimDate,
							"ACCIDENT_TIME"));
					historyClaim
							.setRegistTime(getDate(claimDate, "REPORT_TIME"));
					historyClaim.setEndCaseTime(getDate(claimDate,
							"ENDCASE_DATE"));
					historyClaim
							.setUnClaimAmount(parseDouble(parseNode(claimDate
									.selectSingleNode("UNCLAIM_AMOUNT"))));
					historyClaim.setClaimAmount(parseDouble(parseNode(claimDate
							.selectSingleNode("CLAIM_AMOUNT"))));
					historyClaim.setCaseStatus(parseNode(claimDate
							.selectSingleNode("STATUS")));
					historyClaim.setAccidentPlace(parseNode(claimDate
							.selectSingleNode("ACCIDENT_PLACE")));
					historyClaim.setAccidentDesc(parseNode(claimDate
							.selectSingleNode("ACCIDENT_DESCRIPTION")));
					historyClaim.setIndemnityDuty(CodeTransfer.IndemnityDuty
							.covrentSystemCode(parseNode(claimDate
									.selectSingleNode("ACCIDENT_TYPE"))));
					returnInfo.addHistoryClaim(historyClaim);
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		return returnInfo;
	}
	/**
	 * 根据Document对象生成ClaimDTO对象
	 * 
	 * @param xmlStr
	 * @return
	 * @throws DocumentException
	 */
	public static ReturnInfo getReturnCompensateFromXML(String xmlStr)
			throws ParseException, DocumentException {
		ReturnInfo returnInfo = null;
		HistoryClaim historyCompensate = null;
		try {
			returnInfo = new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			// 得到根节点PACKET
			Element packet = document.getRootElement();
			// 得到HEAD节点
			for (Iterator it = packet.elementIterator("HEAD"); it.hasNext();) {
				Element head = (Element) it.next();
				returnInfo.setRequestType(parseNode(head
						.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setReturnType(parseNode(head
						.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
			}
			// 得到BODY节点
			for (Iterator bit = packet.elementIterator("BODY"); bit.hasNext();) {
				Element body = (Element) bit.next();

				// 得到BASE_PART节点
				Element basepart = (Element) body.selectSingleNode("BASE_PART");
				returnInfo.setClaimCode(parseNode(basepart
						.selectSingleNode("CLAIM_CODE")));
				
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		return returnInfo;
	}
	public static ReturnInfo getReturnSHCompensateFromXML(String xmlStr)
		throws ParseException, DocumentException {
		ReturnInfo returnInfo = null;
		HistoryClaim historyCompensate = null;
		try {
			returnInfo = new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			// 得到根节点PACKET
			Element packet = document.getRootElement();
			// 得到HEAD节点
			for (Iterator it = packet.elementIterator("HEAD"); it.hasNext();) {
				Element head = (Element) it.next();
				returnInfo.setRequestType(parseNode(head
						.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setReturnType(parseNode(head
						.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
				System.out.println(returnInfo.getRequestType()+":::"+returnInfo.getReturnType()+":::"+returnInfo.getErrorMessage());
			}
			// 得到BODY节点
			for (Iterator bit = packet.elementIterator("BODY"); bit.hasNext();) {
				Element body = (Element) bit.next();

				// 得到BASE_PART节点
				returnInfo.setClaimCode(parseNode(body.selectSingleNode("CLAIM_CODE")));
				System.out.println(returnInfo.getClaimCode()+":::");
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		return returnInfo;
		
	}
	/**
	 * 根据Document对象生成ReturnEndCaseDTO对象
	 * 
	 * @param xmlStr
	 * @return
	 * @throws DocumentException
	 */
	public static ReturnInfo getReturnEndCaseFromXML(String xmlStr)
			throws DocumentException {
		ReturnInfo returnEndCase = null;
		try {
			returnEndCase = new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			// 得到根节点PACKET
			Element packet = document.getRootElement();
			// 得到HEAD节点
			for (Iterator it = packet.elementIterator("HEAD"); it.hasNext();) {
				Element head = (Element) it.next();
				returnEndCase.setRequestType(parseNode(head
						.selectSingleNode("REQUEST_TYPE")));
				returnEndCase.setReturnType(parseNode(head
						.selectSingleNode("RESPONSE_CODE")));
				returnEndCase.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
			}

			// 得到BODY节点
			for (Iterator bit = packet.elementIterator("BODY"); bit.hasNext();) {
				Element body = (Element) bit.next();

				// 得到BASE_PART节点
				Element basepart = (Element) body.selectSingleNode("BASE_PART");
				returnEndCase.setClaimCode(parseNode(basepart
						.selectSingleNode("CLAIM_CODE")));
				returnEndCase.setClaimConfirmCode(parseNode(basepart
						.selectSingleNode("CLAIM_CONFIRM_CODE")));
			}

		} catch (DocumentException e) {
			e.printStackTrace();
			throw e;
		}
		return returnEndCase;
	}

	/**
	 * 根据Document对象生成EndCaseAppendDTO对象
	 * 
	 * @param xmlStr
	 * @return
	 * @throws DocumentException
	 */
	public static ReturnInfo getReturnEndCaseApendFromXML(String xmlStr)
			throws DocumentException {
		ReturnInfo returnInfo = null;
		try {
			returnInfo = new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			// 得到根节点PACKET
			Element packet = document.getRootElement();
			// 得到HEAD节点
			for (Iterator it = packet.elementIterator("HEAD"); it.hasNext();) {
				Element head = (Element) it.next();
				returnInfo.setRequestType(parseNode(head
						.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setReturnType(parseNode(head
						.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
			}

		} catch (DocumentException e) {
			e.printStackTrace();
			throw e;
		}
		return returnInfo;
	}
	/**
	 * 根据Document对象生成CheckVerifyDTO对象
	 * 
	 * @param xmlStr
	 * @return
	 * @throws DocumentException
	 */
	public static ReturnInfo getReturnCheckVerifyFromXML(String xmlStr)
			throws DocumentException {
		ReturnInfo returnInfo = null;
		try {
			returnInfo = new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			// 得到根节点PACKET
			Element packet = document.getRootElement();
			// 得到HEAD节点
			for (Iterator it = packet.elementIterator("HEAD"); it.hasNext();) {
				Element head = (Element) it.next();
				returnInfo.setRequestType(parseNode(head
						.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setReturnType(parseNode(head
						.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
			}

		} catch (DocumentException e) {
			e.printStackTrace();
			throw e;
		}
		return returnInfo;
	}
	/**
	 * 根据Document对象生成CertifyDTO对象
	 * 
	 * @param xmlStr
	 * @return
	 * @throws DocumentException
	 */
	public static ReturnInfo getReturnCertifyFromXML(String xmlStr)
			throws DocumentException {
		ReturnInfo returnInfo = null;
		try {
			returnInfo = new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			// 得到根节点PACKET
			Element packet = document.getRootElement();
			// 得到HEAD节点
			for (Iterator it = packet.elementIterator("HEAD"); it.hasNext();) {
				Element head = (Element) it.next();
				returnInfo.setRequestType(parseNode(head
						.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setReturnType(parseNode(head
						.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
			}

		} catch (DocumentException e) {
			e.printStackTrace();
			throw e;
		}
		return returnInfo;
	}
	/**
	 * 根据查勘定损核损象生成Document对象（上海）
	 * 
	 * @param checkVerify
	 * @param user
	 * @param password
	 * @return 
	 */
	private static Document getSHCheckVerifyDocument(CheckVerify checkVerify,String user,String password)
	{
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET").addAttribute("type", "REQUEST").addAttribute("version", "1.0");
		
		Element headElement = packetElement.addElement("HEAD");
		headElement.addElement("REQUEST_TYPE").setText(Iconstants.RequstType.CHECKVERIFY);
		headElement.addElement("USER").setText(user);
		headElement.addElement("PASSWORD").setText(password);
		
		Element bodyElement = packetElement.addElement("BODY");
		Element basePart = bodyElement.addElement("BASE_PART");
		basePart.addElement("CLAIM_CODE").setText(checkVerify.getClaimCode());
		basePart.addElement("MANAGE_TYPE").setText(checkVerify.getManageType());
		basePart.addElement("LIABILITY_AMOUNT").setText(CodeTransfer.IndemnityDuty.covrentPlatFormCode(checkVerify.getIndemnityDuty()));		
		basePart.addElement("ESTIMATE_AMOUNT").setText(new DecimalFormat("0.00").format(checkVerify.getSumCertainLoss()));
		basePart.addElement("CONFIRM_SEQUENCE_NO").setText(checkVerify.getConfirmSequenceNo());
		basePart.addElement("CAR_MARK").setText(checkVerify.getLicenseNo());
		basePart.addElement("VEHICLE_TYPE").setText(checkVerify.getLicenseKindCode());
		Element personList = bodyElement.addElement("PERSON_LIST");
		for (Iterator it=checkVerify.getPersonLossList().iterator(); it.hasNext();)
		{
			PersonLoss personLoss=(PersonLoss)it.next();			
			Element personDate = personList.addElement("PERSON_DATA");
			personDate.addElement("PERSON_NAME").setText(personLoss.getPersonName());
			personDate.addElement("PERSON_ID").setText(personLoss.getIdentifyNumber());
			personDate.addElement("AGE").setText(personLoss.getAge());
			personDate.addElement("LOSS_AMOUNT").setText(new DecimalFormat("0.00").format(personLoss.getSumDuty()));
			personDate.addElement("MAIN_THIRD").setText("0");										//是否承保车辆
			personDate.addElement("SURVEY_TYPE").setText(checkVerify.getSurveyType());
			personDate.addElement("SURVEY_NAME").setText(checkVerify.getSurveyName());
			personDate.addElement("SURVEY_START_TIME").setText(checkVerify.getSurveyStartTime());
			personDate.addElement("SURVEY_END_TIME").setText(checkVerify.getSurveyEndTime());
			personDate.addElement("SURVEY_PLACE").setText(checkVerify.getSurveyPlace());
			personDate.addElement("SURVEY_DES").setText(checkVerify.getSurveyDes());
			personDate.addElement("ESTIMATE_NAME").setText(personLoss.getEsimateName());
			personDate.addElement("ESTIMATE_START_TIME").setText(personLoss.getEsimateStartTime());
			personDate.addElement("ESTIMATE_END_TIME").setText(personLoss.getEsimateEndTime());
			personDate.addElement("ASSESOR_NAME").setText(personLoss.getAssesorName());
			personDate.addElement("ASSESOR_START_TIME").setText(personLoss.getAssesorStartTime());
			personDate.addElement("ASSESOR_END_TIME").setText(personLoss.getAssesorEndTime());
			Element LossPartList = personDate.addElement("LOSS_PART_LIST");
			for (Iterator itd=personLoss.getPersonLossDetailList().iterator(); itd.hasNext();)
			{
				PersonLoss personDetailLoss=(PersonLoss)itd.next();
				if(personDetailLoss.getPersonNo() == personLoss.getPersonNo()){
					Element LossPartDate = LossPartList.addElement("LOSS_PART_DATA");
					LossPartDate.addElement("FEE_TYPE").setText(CodeTransfer.SHPersonLossType.covrentPlatFormCode(personDetailLoss.getFeeType()));
					LossPartDate.addElement("LOSS_AMOUNT").setText(new DecimalFormat("0.00").format(personDetailLoss.getSumDuty()));
					LossPartDate.addElement("INJURY_TYPE").setText(personDetailLoss.getInjuryType());
					LossPartDate.addElement("INJURY_LEVEL").setText(personDetailLoss.getInjuryLevel());
					LossPartDate.addElement("INJURY_PART").setText(personDetailLoss.getInjuryPart());
					LossPartDate.addElement("HOSPITAL").setText(personDetailLoss.getHospital());
				}
			}
		}
		Element vehicleList = bodyElement.addElement("VEHICLE_LIST");
		for (Iterator it=checkVerify.getCarLossList().iterator(); it.hasNext();)
		{
			CarLoss carLoss=(CarLoss)it.next();			
			Element vehicleDate = vehicleList.addElement("VEHICLE_DATA");
			vehicleDate.addElement("CAR_MARK").setText(carLoss.getLicenseNo());
			if(carLoss.getInsureCarFlag().equals("1"))
			{
				vehicleDate.addElement("VEHICLE_TYPE").setText(carLoss.getLicenseType());
			}else{
				vehicleDate.addElement("VEHICLE_TYPE").setText(carLoss.getLicenseType());
			}
			vehicleDate.addElement("LOSS_AMOUNT").setText(new DecimalFormat("0.00").format(carLoss.getSumLoss()));
			vehicleDate.addElement("MAIN_THIRD").setText(carLoss.getInsureCarFlag());
			vehicleDate.addElement("ROBBER").setText("0");
			vehicleDate.addElement("SURVEY_TYPE").setText(checkVerify.getSurveyType());
			vehicleDate.addElement("SURVEY_NAME").setText(checkVerify.getSurveyName());
			vehicleDate.addElement("SURVEY_START_TIME").setText(checkVerify.getSurveyStartTime());
			vehicleDate.addElement("SURVEY_END_TIME").setText(checkVerify.getSurveyEndTime());
			vehicleDate.addElement("SURVEY_PLACE").setText(checkVerify.getSurveyPlace());
			vehicleDate.addElement("SURVEY_DES").setText(checkVerify.getSurveyDes());
			//vehicleDate.addElement("REPAIR_ORG").setText(carLoss.getVerifyLossRepairFactory());
			vehicleDate.addElement("ESTIMATE_NAME").setText(carLoss.getEsimateName()); //carLoss.getEsimateName()
			System.out.println("【车辆定损人员】----------"+carLoss.getEsimateName());
			vehicleDate.addElement("ESTIMATE_START_TIME").setText(carLoss.getEsimateStartTime());
			vehicleDate.addElement("ESTIMATE_END_TIME").setText(carLoss.getEsimateEndTime());
			vehicleDate.addElement("ASSESOR_NAME").setText(carLoss.getAssesorName());
			vehicleDate.addElement("ASSESOR_START_TIME").setText(carLoss.getAssesorStartTime());
			vehicleDate.addElement("ASSESOR_END_TIME").setText(carLoss.getAssesorEndTime());
			vehicleDate.addElement("REMNANT").setText(new DecimalFormat("0.00").format(carLoss.getSumRest()));
			vehicleDate.addElement("CHARGE_FEE").setText(new DecimalFormat("0.00").format(carLoss.getSumManager()));
			vehicleDate.addElement("TOTAL_WORKING_HOUR").setText(new DecimalFormat("0.00").format(carLoss.getTotalWorkHour()));
			vehicleDate.addElement("CHANGE_OR_REPAIR_PART").setText(carLoss.getChangeOrRepairPart());
			vehicleDate.addElement("JY_VEHICLE_CODE").setText("");
			vehicleDate.addElement("MADE_FACTORY").setText("无");
			vehicleDate.addElement("VEHICLE_BRAND_CODE").setText("");
			vehicleDate.addElement("VEHICLE_CATENA_CODE").setText("");
			vehicleDate.addElement("VEHICLE_GROUP_CODE").setText("");
			vehicleDate.addElement("PRICE_SLT_CODE").setText("02");
			vehicleDate.addElement("DEFINE_FLAG").setText("0");
			Element LossPartList = vehicleDate.addElement("LOSS_PART_LIST");
			Element LossPartDate = LossPartList.addElement("LOSS_PART_DATA");
			LossPartDate.addElement("LOSS_PART").setText("01");
			Element fittingList = vehicleDate.addElement("FITTING_LIST");
			for (Iterator itd=carLoss.getCarLossDetailList().iterator(); itd.hasNext();)
			{
				CarLoss carDetailLoss=(CarLoss)itd.next();
				Element fittingDate = fittingList.addElement("FITTING_DATA");
				fittingDate.addElement("CHANGE_PART_NAME").setText(carDetailLoss.getChangePartName());
				fittingDate.addElement("CHANGE_PART_NUM").setText(String.valueOf(carDetailLoss.getChangePartNum()));
				fittingDate.addElement("CHANGE_PART_FEE").setText(new DecimalFormat("0.00").format(carDetailLoss.getChangePartFee()));
				fittingDate.addElement("CHANGE_PART_TIME").setText(new DecimalFormat("0.00").format(carDetailLoss.getChangePartTime()));
				fittingDate.addElement("CHANGE_PART_MANPOWER_FEE").setText(new DecimalFormat("0.00").format(carDetailLoss.getChangePartManpowerFee()));
				fittingDate.addElement("REPAIR_PART_NAME").setText(carDetailLoss.getRepairPartName());
				fittingDate.addElement("REPAIR_PART_NUM").setText(String.valueOf(carDetailLoss.getRepairPartNum()));
				fittingDate.addElement("REPAIR_PART_FEE").setText(new DecimalFormat("0.00").format(carDetailLoss.getRepairPartFee()));
				fittingDate.addElement("REPAIR_PART_TIME").setText(new DecimalFormat("0.00").format(carDetailLoss.getRepairPartTime()));
				fittingDate.addElement("REPAIR_PART_MANPOWER_FEE").setText(new DecimalFormat("0.00").format(carDetailLoss.getRepairPartManpowerFee()));
				fittingDate.addElement("REPAIR_METHORD").setText(carDetailLoss.getRepairMethord());              
				fittingDate.addElement("JY_PART_CODE").setText("");
				fittingDate.addElement("OEM_PART_CODE").setText(carDetailLoss.getOemPartCode());
				fittingDate.addElement("DEFINE_FLAG").setText(carDetailLoss.getDefineFlag());
				fittingDate.addElement("SUBJION_FLAG").setText(carDetailLoss.getSubjionFlag());		 		
			}
			Element repairList = vehicleDate.addElement("REPAIR_LIST");
			for (Iterator itd=carLoss.getCarLossDetailList().iterator(); itd.hasNext();)
			{
				CarLoss carLossFac=(CarLoss)itd.next();
				Element repairDate = repairList.addElement("REPAIR_DATA");
				repairDate.addElement("REPAIR_ORG").setText(carLossFac.getVerifyLossRepairFactory());         //修理机构信息
			}
		}
		Element objList = bodyElement.addElement("OBJ_LIST");
		for (Iterator it=checkVerify.getPropLossList().iterator(); it.hasNext();)
		{
			PropLoss propLoss=(PropLoss)it.next();			
			Element propDate = objList.addElement("OBJ_DATA");
			propDate.addElement("OBJECT_DESC").setText(propLoss.getPropDesc());
			propDate.addElement("LOSS_NUM").setText(Integer.toString((int)propLoss.getLossQuantity()));
			propDate.addElement("LOSS_AMOUNT").setText(new DecimalFormat("0.00").format(propLoss.getSumLoss()));
			propDate.addElement("MAIN_THIRD").setText("0");
			propDate.addElement("SURVEY_TYPE").setText(checkVerify.getSurveyType());
			propDate.addElement("SURVEY_NAME").setText(checkVerify.getSurveyName());
			propDate.addElement("SURVEY_START_TIME").setText(checkVerify.getSurveyStartTime());
			propDate.addElement("SURVEY_END_TIME").setText(checkVerify.getSurveyEndTime());
			propDate.addElement("SURVEY_PLACE").setText(checkVerify.getSurveyPlace());
			propDate.addElement("SURVEY_DES").setText(checkVerify.getSurveyDes());
			propDate.addElement("ESTIMATE_NAME").setText(propLoss.getEsimateName());
			propDate.addElement("ESTIMATE_START_TIME").setText(propLoss.getEsimateStartTime());
			propDate.addElement("ESTIMATE_END_TIME").setText(propLoss.getEsimateEndTime());
			propDate.addElement("ASSESOR_NAME").setText(propLoss.getAssesorName());
			propDate.addElement("ASSESOR_START_TIME").setText(propLoss.getAssesorStartTime());
			propDate.addElement("ASSESOR_END_TIME").setText(propLoss.getAssesorEndTime());
		}
		return document;
	}

	/**
	 * 根据Document对象生成ReturnCancelCaseDTO对象
	 * 
	 * @param xmlStr
	 * @return
	 * @throws DocumentException
	 */
	public static ReturnInfo getReturnCancelCaseFromXML(String xmlStr)
			throws DocumentException {
		ReturnInfo returnInfo = null;
		try {
			returnInfo = new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			// 得到根节点PACKET
			Element packet = document.getRootElement();
			// 得到HEAD节点
			for (Iterator it = packet.elementIterator("HEAD"); it.hasNext();) {
				Element head = (Element) it.next();
				returnInfo.setRequestType(parseNode(head
						.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setReturnType(parseNode(head
						.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
			}

		} catch (DocumentException e) {
			e.printStackTrace();
			throw e;
		}
		return returnInfo;
	}
	/**
	 *  根据赔款支付对象生成XML字符串
	 * @param EndCase
	 * @param user
	 * @param password
	 * @return
	 */
	public static String getPayinforXML(PayinforSH payinfor,String user,String password,String jigou){
		Document document = null;
		if(("211").equals(jigou)){//北京
		}else if(("231").equals(jigou)){//上海
			document = getSHPayinforDocument(payinfor, user, password);
		}else{//浙江、江苏、湖南
		}
		if(document!=null){
			document.setXMLEncoding("gb2312");
			System.out.println("**********   商业赔款支付发送的 XML  *************"
					+ document.asXML());
			return document.asXML();
		}
		return null;
	}
	
	private static Document getSHPayinforDocument(PayinforSH payinfor,String user,String password)
	{
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("PACKET")
		.addAttribute("type", "REQUEST")
		.addAttribute("version", "1.0");
		
		
		Element headElement = packetElement.addElement("HEAD");
		headElement.addElement("REQUEST_TYPE").setText(Iconstants.RequstType.PAYINFORSH);
		headElement.addElement("USER").setText(user);
		headElement.addElement("PASSWORD").setText(password);
		
		
		Element bodyElement = packetElement.addElement("BODY");
		
		Element basePart = bodyElement.addElement("BASE_PART");
		basePart.addElement("CLAIM_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(payinfor.getClaimAmount())));
		basePart.addElement("PAY_METHOD").setText(payinfor.getPayMethod());
		basePart.addElement("BANK_NAME").setText(payinfor.getBankName());
		basePart.addElement("BANK_ACCOUNT").setText(payinfor.getBankAcount());
		basePart.addElement("BANK_ACCOUNT_NAME").setText(payinfor.getBankAcountName());
		basePart.addElement("PAY_TIME").setText(new SimpleDateFormat("yyyyMMddhhmmss").format(payinfor.getPayTime()));
		
		Element payList=bodyElement.addElement("PAY_LIST");
		for(Iterator it=payinfor.getpayList().iterator();it.hasNext();){
			Paydata payData=(Paydata)it.next();
			Element pay_Data=payList.addElement("PAY_DATA");
			pay_Data.addElement("R_BANK_ACCOUNT").setText(payData.getRBankAcount());
			pay_Data.addElement("R_BANK_NAME").setText(payData.getRBankName());
			pay_Data.addElement("R_BANK_ACCOUNT_NAME").setText(payData.getRBankAcountName());
			pay_Data.addElement("R_BANK_CENTICODE").setText(payData.getRBankCenticode());
			pay_Data.addElement("CLAIM_CODE").setText(payData.getClaimCode());
			pay_Data.addElement("CLAIM_ADD_CODE").setText(payData.getClaimAddCode());
			pay_Data.addElement("CLAIM_AMOUNT").setText(String.valueOf(new DecimalFormat("0.00").format(payData.getClaimAmount())));
			pay_Data.addElement("CLAIM_TYPE").setText(payData.getClaimType());
		}
		return document;
	}
	
	public static ReturnInfo getReturnFromXMLConsole(String xmlStr,String reqType,String jigou) throws Exception{
		ReturnInfo returnInfo=null;
		if(Iconstants.RequstType.PAYINFORSH.equals(reqType)){
			if(("211").equals(jigou)){//北京
			}else if(("231").equals(jigou)){//上海
				returnInfo = getSHReturnPayinforFromXML(xmlStr);
			}else{//浙江、江苏、湖南
			}
//		}else if(Iconstants.RequstType.PAYINFOR.equals(reqType)){
//			if(("211").equals(jigou)){//北京
//				returnInfo = getReturnPayinforFromXML(xmlStr);
//			}else if(("231").equals(jigou)){//上海
//			}else{//浙江、江苏、湖南
//				returnInfo = getReturnPayinforFromXML(xmlStr);
//			}
		}		
		
		return returnInfo;
	}
	
	/**
	 * 根据Document对象生成PayinforDTO对象
	 * @param xmlStr
	 * @return
	 * @throws DocumentException 
	 */
	public static ReturnInfo getSHReturnPayinforFromXML(String xmlStr) throws DocumentException{
		ReturnInfo returnInfo=null;
		try
		{
			returnInfo=new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			//得到根节点PACKET 
			Element packet = document.getRootElement();
			//得到HEAD节点
			for (Iterator it=packet.elementIterator("HEAD"); it.hasNext();)
			{
				Element head=(Element)it.next();
				returnInfo.setRequestType(Iconstants.RequstType.PAYINFORSH_SYX); //涉及类型转换 写死
				returnInfo.setReturnType(parseNode(head.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorMessage(parseNode(head.selectSingleNode("ERROR_MESSAGE")));
			}
			
			if("1".equals(returnInfo.getReturnType())){
				for(Iterator it=document.selectNodes("//PACKET/BODY/BASE_PART/SUCCEED_GROUP/PAY_SUCCEED_LIST/PAY_SUCCEED_DATA/CLAIM_CODE").iterator();it.hasNext();){
					returnInfo.setClaimCode(((Element)it.next()).getText());
				}
			}else if("0".equals(returnInfo.getReturnType())){
				for(Iterator it=document.selectNodes("//PACKET/BODY/BASE_PART/LOST_GROUP/PAY_LOST_LIST/PAY_LOST_DATA/CLAIM_CODE").iterator();it.hasNext();){
					returnInfo.setClaimCode(((Element)it.next()).getText());
				}
			}
			
		}catch (DocumentException e) {
			e.printStackTrace();
			throw e;
		}
		return returnInfo;
	}
	
	/**
	 * 根据Document对象生成ClaimDTO对象
	 * 
	 * @param xmlStr
	 * @return
	 * @throws DocumentException
	 */
	public static ReturnInfo getReturnPayinforFromXML(String xmlStr)
			throws ParseException, DocumentException {
		ReturnInfo returnInfo = null;
		HistoryClaim historyCompensate = null;
		try {
			returnInfo = new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			// 得到根节点PACKET
			Element packet = document.getRootElement();
			// 得到HEAD节点
			for (Iterator it = packet.elementIterator("HEAD"); it.hasNext();) {
				Element head = (Element) it.next();
				returnInfo.setRequestType(parseNode(head
						.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setReturnType(parseNode(head
						.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
			}
			// 得到BODY节点
			for (Iterator bit = packet.elementIterator("BODY"); bit.hasNext();) {
				Element body = (Element) bit.next();

				// 得到BASE_PART节点
				Element basepart = (Element) body.selectSingleNode("BASE_PART");
				returnInfo.setClaimCode(parseNode(basepart
						.selectSingleNode("CLAIM_CODE")));
				
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		return returnInfo;
	}
	private static Date getDate(Element element, String nodeName)
			throws ParseException {

		String dateString = "";
		if (element.selectSingleNode(nodeName) != null) {
			dateString = element.selectSingleNode(nodeName).getText();
		}
		String dateFormat = "";
		if (dateString.length() == 0) {
			return null;
		} else if (dateString.length() == 8) {
			dateFormat = "yyyyMMdd";
		} else if (dateString.length() == 10) {
			dateFormat = "yyyyMMddHH";
		} else if (dateString.length() == 12) {
			dateFormat = "yyyyMMddHHmm";
		} else if (dateString.length() == 14) {
			dateFormat = "yyyyMMddHHmmss";
		} else if (dateString.length() > 14) {
			// throw new
			// ParseException("返回的日期字符串格式不正确，无法解析.［日期字符串＝"+dateString+"]", 0);
			return new SimpleDateFormat("yyyyMMddHHmm").parse(dateString);
		} else {
			throw new ParseException("返回的日期字符串格式不正确，无法解析.［日期字符串＝" + dateString
					+ "]", 0);
		}

		return new SimpleDateFormat(dateFormat).parse(dateString);
	}

	private static String parseNode(Node node) {
		if (node == null) {
			return null;
		}
		return node.getText();
	}

	private static double parseDouble(String data) {
		if (data != null && data != "") {
			return Double.parseDouble(data);
		}
		return 0;
	}
}
