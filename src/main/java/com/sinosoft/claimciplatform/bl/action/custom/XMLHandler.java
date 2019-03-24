package com.sinosoft.claimciplatform.bl.action.custom;

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

import com.sinosoft.bz.common.RequestType;
import com.sinosoft.bz.common.XmlHelper;
import com.sinosoft.ciplatform.dto.custom.ReCase;
import com.sinosoft.ciplatform.dto.custom.Accounts;
import com.sinosoft.ciplatform.dto.custom.ReturnAccountsInfo;
import com.sinosoft.claim.dto.domain.PrpLlocklogDto;
import com.sinosoft.claimciplatform.dto.custom.AccidentBackInfor;
import com.sinosoft.claimciplatform.dto.custom.CancelCase;
import com.sinosoft.claimciplatform.dto.custom.Claim;
import com.sinosoft.claimciplatform.dto.custom.ClaimCover;
import com.sinosoft.claimciplatform.dto.custom.ClaimHistoryInfor;
import com.sinosoft.claimciplatform.dto.custom.CompePlatFormRetrunParam;
import com.sinosoft.claimciplatform.dto.custom.CompelCrashAccidentInfor;
import com.sinosoft.claimciplatform.dto.custom.CompelCrashArgDto;
import com.sinosoft.claimciplatform.dto.custom.CompelCrashDto;
import com.sinosoft.claimciplatform.dto.custom.CompensateVeric;
import com.sinosoft.claimciplatform.dto.custom.EndCase;
import com.sinosoft.claimciplatform.dto.custom.EndCaseAppSituation;
import com.sinosoft.claimciplatform.dto.custom.EndCaseAppend;
import com.sinosoft.claimciplatform.dto.custom.HistoryClaim;
import com.sinosoft.claimciplatform.dto.custom.LossSituation;
import com.sinosoft.claimciplatform.dto.custom.LossSituationDetail;
import com.sinosoft.ciplatform.dto.custom.Paydata;
import com.sinosoft.claimciplatform.dto.custom.PayRefInfo;
import com.sinosoft.claimciplatform.dto.custom.PlatFormCrashParam;
import com.sinosoft.claimciplatform.dto.custom.RecoveryOrPay;
import com.sinosoft.claimciplatform.dto.custom.Regist;
import com.sinosoft.claimciplatform.dto.custom.ReturnInfo;
import com.sinosoft.claimciplatform.dto.domain.CIClaimThirdCarDto;
import com.sinosoft.claimciplatform.util.CodeTransfer;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.utility.string.Str;
public class XMLHandler {
	
	/**
	 * 根据事故信息上传对象生成XML字符串
	 * */
	public static String getAccidentUploadInfoXML(
			CompelCrashDto accidentUploadInfo, String user, String password) {
		Document document = getAccidentUploadInfoDocument(accidentUploadInfo,
				user, password);
		if (document != null) {
			document.setXMLEncoding("GBK");
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
		if(compelCrashDto!=null){
			if(compelCrashDto.getOwnAccidentInfor()!=null){
	        	basePartElement.addElement("A_NAME").setText(
	    				compelCrashDto.getOwnAccidentInfor().getName()==null ? "" : compelCrashDto.getOwnAccidentInfor().getName());
	    		basePartElement.addElement("A_ID_NO").setText(
	    				compelCrashDto.getOwnAccidentInfor().getIdNo()==null ? "" : compelCrashDto.getOwnAccidentInfor().getIdNo());
	    		basePartElement.addElement("A_CAR_MARK").setText(
	    				compelCrashDto.getOwnAccidentInfor().getCarMark()==null ? "" : compelCrashDto.getOwnAccidentInfor().getCarMark());
	    		basePartElement.addElement("A_VEHICLE_TYPE").setText(
	    				compelCrashDto.getOwnAccidentInfor().getVehicleType()==null ? "" : compelCrashDto.getOwnAccidentInfor().getVehicleType());
	    		basePartElement.addElement("A_VEHICLE_MODEL").setText(
	    				compelCrashDto.getOwnAccidentInfor().getVehicleModel()==null ? "" : compelCrashDto.getOwnAccidentInfor().getVehicleModel());
	    		basePartElement.addElement("A_TEL_NO").setText(
	    				compelCrashDto.getOwnAccidentInfor().getTelNo()==null ? "" : compelCrashDto.getOwnAccidentInfor().getTelNo());
	    		basePartElement.addElement("A_COMPANY_CODE").setText(
	    				compelCrashDto.getOwnAccidentInfor().getCompanyCode()==null ? "" : compelCrashDto.getOwnAccidentInfor().getCompanyCode());
	    		basePartElement.addElement("A_POLICY_CODE").setText(
	    				compelCrashDto.getOwnAccidentInfor().getPolicyCode()==null ? "" : compelCrashDto.getOwnAccidentInfor().getPolicyCode());
	    		basePartElement.addElement("A_REPORT_NO").setText(
	    				compelCrashDto.getOwnAccidentInfor().getReportNo()==null ? "" : compelCrashDto.getOwnAccidentInfor().getReportNo());
	    		basePartElement.addElement("A_DAMAGE_PART").setText(
	    				compelCrashDto.getOwnAccidentInfor().getDamagePart()==null ? "" : compelCrashDto.getOwnAccidentInfor().getDamagePart());
	        }
	        if(compelCrashDto.getOtherAccidentInfor()!=null){
	        	basePartElement.addElement("B_NAME").setText(
	    				compelCrashDto.getOtherAccidentInfor().getName()==null ? "" : compelCrashDto.getOtherAccidentInfor().getName());
	    		basePartElement.addElement("B_ID_NO").setText(
	    				compelCrashDto.getOtherAccidentInfor().getIdNo()==null ? "" : compelCrashDto.getOtherAccidentInfor().getIdNo());
	    		basePartElement.addElement("B_CAR_MARK").setText(
	    				compelCrashDto.getOtherAccidentInfor().getCarMark()==null ? "" : compelCrashDto.getOtherAccidentInfor().getCarMark());
	    		basePartElement.addElement("B_VEHICLE_TYPE").setText(
	    				compelCrashDto.getOtherAccidentInfor().getVehicleType()==null ? "" : compelCrashDto.getOtherAccidentInfor().getVehicleType());
	    		basePartElement.addElement("B_VEHICLE_MODEL").setText(
	    				compelCrashDto.getOtherAccidentInfor().getVehicleModel()==null ? "" : compelCrashDto.getOtherAccidentInfor().getVehicleModel());
	    		basePartElement.addElement("B_TEL_NO").setText(
	    				compelCrashDto.getOtherAccidentInfor().getTelNo()==null ? "" : compelCrashDto.getOtherAccidentInfor().getTelNo());
	    		basePartElement.addElement("B_COMPANY_CODE").setText(
	    				compelCrashDto.getOtherAccidentInfor().getCompanyCode()==null ? "" : compelCrashDto.getOtherAccidentInfor().getCompanyCode());
	    		basePartElement.addElement("B_POLICY_CODE").setText(
	    				compelCrashDto.getOtherAccidentInfor().getPolicyCode()==null ? "" : compelCrashDto.getOtherAccidentInfor().getPolicyCode());
	    		basePartElement.addElement("B_REPORT_NO").setText(
	    				compelCrashDto.getOtherAccidentInfor().getReportNo()==null ? "" : compelCrashDto.getOtherAccidentInfor().getReportNo());
	    		basePartElement.addElement("B_DAMAGE_PART").setText(
	    				compelCrashDto.getOtherAccidentInfor().getDamagePart()==null ? "" : compelCrashDto.getOtherAccidentInfor().getDamagePart());
	        }
			
//			basePartElement.addElement("FAULT_PARTY").setText(
//					compelCrashDto.getFaultParty()==null ? "" : compelCrashDto.getFaultParty());
			basePartElement.addElement("FAULT_PARTY").setText(
					"1");
			basePartElement.addElement("FAULT_BEHAVIOR").setText(
					compelCrashDto.getFaultBehavior()==null ? "" : compelCrashDto.getFaultBehavior());
			if(compelCrashDto.getAccidentTime()!=null && compelCrashDto.getAccidentTime().length()>0){
				basePartElement.addElement("ACCIDENT_TIME").setText(new SimpleDateFormat("yyyyMMddhhMM").format(new DateTime(compelCrashDto.getAccidentTime())));
			}
			basePartElement.addElement("ACCIDENT_PLACE").setText(
					compelCrashDto.getAccidentPlace()==null ? "" : compelCrashDto.getAccidentPlace());
			if(compelCrashDto.getReportTime()!=null && compelCrashDto.getReportTime().length()>0){
				basePartElement.addElement("REPORT_TIME").setText(
						new SimpleDateFormat("yyyyMMddhhMM").format(new DateTime(compelCrashDto.getReportTime())));
			}
			if(compelCrashDto.getApplyAssessmentTime()!=null && compelCrashDto.getApplyAssessmentTime().length()>0){
				basePartElement.addElement("APPLY_ASSESSMENT_TIME").setText(
						new SimpleDateFormat("yyyyMMddhhMM").format(new DateTime(compelCrashDto.getApplyAssessmentTime())));
			}
			if(compelCrashDto.getAssessStartTime()!=null && compelCrashDto.getAssessStartTime().length()>0){
				 basePartElement.addElement("ASSESS_START_TIME").setText(
						 new SimpleDateFormat("yyyyMMddhhMM").format(new DateTime(compelCrashDto.getAssessStartTime())));
			}
		   
		}
        
		return document;
	}
	
	/**
	 * 将平台返回的事故信息的XML字符串转换为自己的dto
	 * */
	public static ReturnInfo getAccidentBackInfo(String xmlStr)
	       throws ParseException, DocumentException {
		ReturnInfo returnInfo=new ReturnInfo();
		AccidentBackInfor accidentBackInfor = null;
		CompePlatFormRetrunParam compePlatFormRetrunParam=new CompePlatFormRetrunParam();
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
				System.out.println("===========returnInfo==="+returnInfo.getReturnType());
				compePlatFormRetrunParam.setResponseCode(parseNode(head
						.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
				compePlatFormRetrunParam.setErrorMessage(parseNode(head
						.selectSingleNode("ERROR_MESSAGE")));
				accidentBackInfor.setCompePlatFormRetrunParam(compePlatFormRetrunParam);
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
//					claimHistoryInfor.setAccidentTime(new Date(new SimpleDateFormat("yyyyMMddHHmm").format(
//							parseNode(CLAIM_DATA
//									.selectSingleNode("ACCIDENT_TIME")))));
//					claimHistoryInfor.setReportTime(new Date(new SimpleDateFormat("yyyyMMddHHmm").format(parseNode(CLAIM_DATA
//							.selectSingleNode("REPORT_TIME")))));
//					claimHistoryInfor.setClaimDate(new Date(new SimpleDateFormat("yyyyMMddHHmm").format(
//							parseNode(CLAIM_DATA
//									.selectSingleNode("REGISTRATION_DATE")))));
//					claimHistoryInfor.setEndcaseDate(new Date(new SimpleDateFormat("yyyyMMddHHmm").format(parseNode(CLAIM_DATA
//							.selectSingleNode("ENDCASE_DATE")))));
					//compelCrashDto.getAccidentPlace()==null ? 
					//		"" : compelCrashDto.getAccidentPlace());
					claimHistoryInfor.setUnclaimAmount(Double
							.parseDouble(parseNode(CLAIM_DATA
									.selectSingleNode("UNCLAIM_AMOUNT")).equals("")?"0":
										parseNode(CLAIM_DATA
												.selectSingleNode("UNCLAIM_AMOUNT"))));
					claimHistoryInfor.setClaimAmount(Double
							.parseDouble(parseNode(CLAIM_DATA
									.selectSingleNode("CLAIM_AMOUNT")).equals("")?"0":parseNode(CLAIM_DATA
											.selectSingleNode("CLAIM_AMOUNT"))));
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
//					claimHistoryInfor.setAccidentTime(new Date(new SimpleDateFormat("yyyyMMddHHmm").format(
//							parseNode(CLAIM_DATA
//									.selectSingleNode("ACCIDENT_TIME")))));
//					claimHistoryInfor.setReportTime(new Date(new SimpleDateFormat("yyyyMMddHHmm").format(parseNode(CLAIM_DATA
//							.selectSingleNode("REPORT_TIME")))));
//					claimHistoryInfor.setClaimDate(new Date(new SimpleDateFormat("yyyyMMddHHmm").format(
//							parseNode(CLAIM_DATA
//									.selectSingleNode("REGISTRATION_DATE")))));
//					claimHistoryInfor.setEndcaseDate(new Date(new SimpleDateFormat("yyyyMMddHHmm").format(parseNode(CLAIM_DATA
//							.selectSingleNode("ENDCASE_DATE")))));
					claimHistoryInfor.setUnclaimAmount(Double
							.parseDouble(parseNode(CLAIM_DATA
									.selectSingleNode("UNCLAIM_AMOUNT")).equals("")?"0":parseNode(CLAIM_DATA
											.selectSingleNode("UNCLAIM_AMOUNT"))));
					claimHistoryInfor.setClaimAmount(Double
							.parseDouble(parseNode(CLAIM_DATA
									.selectSingleNode("CLAIM_AMOUNT")).equals("")?"0":parseNode(CLAIM_DATA
											.selectSingleNode("CLAIM_AMOUNT"))));
					claimHistoryInfor.setStatus(parseNode(CLAIM_DATA
							.selectSingleNode("STATUS")));
					bClaimList.add(claimHistoryInfor);
				}
				accidentBackInfor.setAClaimList(aClaimList);
				accidentBackInfor.setBClaimList(bClaimList);
			}
			returnInfo.setAccidentBackInfo(accidentBackInfor);
		} catch (DocumentException e) {
			e.printStackTrace();
			throw e;
		}
		System.out.println("===========returnInfo==="+returnInfo.getReturnType());
		return returnInfo;
	}
	
	
	
	/**
	 * 根据事故回写信息生成xml字符串
	 */
	public static String getAccidentBackWriteUploadInfo(
            CompelCrashArgDto compelCrashArg,
			String user, String password) {
		Document document = getAccidentBackWriteUploadInfoDocument(
                compelCrashArg, user, password);
		if (document != null) {
			document.setXMLEncoding("GBK");
			return document.asXML();
		}
		return null;
	}
	
	private static Document getAccidentBackWriteUploadInfoDocument(
            CompelCrashArgDto compelCrashArg,
			String user, String password) {
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
                compelCrashArg.getARegsitNo()==null ? "" : compelCrashArg.getARegsitNo());
		basePartElement.addElement("B_REPORT_NO").setText(
                compelCrashArg.getBRegsitNo()==null ? "" : compelCrashArg.getBRegsitNo());
		return document;
	}
	
	public static ReturnInfo getAccidentBackWriteBackInfo(String xmlStr)
	       throws ParseException, DocumentException {
		ReturnInfo returnInfo=new ReturnInfo();
		try {
			CompelCrashDto accidentBackWriteBackInfo = new CompelCrashDto();
			CompePlatFormRetrunParam compePlatFormRetrunParam=new CompePlatFormRetrunParam();
			Document document = DocumentHelper.parseText(xmlStr);
			Element packet = document.getRootElement();
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
				accidentBackWriteBackInfo.setCompePlatFormRetrunParam(compePlatFormRetrunParam);

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
				
				accidentBackWriteBackInfo.setAccidentPlace(parseNode(basepart
						.selectSingleNode("ACCIDENT_PLACE")));
				accidentBackWriteBackInfo.setAccidentTime(parseNode(basepart
						.selectSingleNode("ACCIDENT_TIME")));
				accidentBackWriteBackInfo.setApplyAssessmentTime(parseNode(basepart
						.selectSingleNode("APPLY_ASSESSMENT_TIME")));
				accidentBackWriteBackInfo.setAssessStartTime(parseNode(basepart
						.selectSingleNode("ASSESS_START_TIME")));
				accidentBackWriteBackInfo.setReportTime(parseNode(basepart
				.selectSingleNode("REPORT_TIME")));
				accidentBackWriteBackInfo.setFaultParty(parseNode(basepart
						.selectSingleNode("FAULT_PARTY")));
				accidentBackWriteBackInfo.setFaultBehavior(parseNode(basepart
						.selectSingleNode("FAULT_BEHAVIOR")));
				System.out.println("======aAccidentInfo.getCarMark()======="+aAccidentInfo.getCarMark());
			}
			returnInfo.setCompelCrashDto(accidentBackWriteBackInfo);
			return returnInfo;

		} catch (DocumentException e) {
			e.printStackTrace();
			throw e;
		}

	}
	
	
	
	/**
	 * 根据报案对象生成XML字符串
	 * @param regist
	 * @param user
	 * @param password
	 * @return
	 */
	public static String getRegistXML(Regist regist,String user,String password){
		Document document = getRegistDocument(regist, user, password);
		if(document!=null){
			document.setXMLEncoding("GBK");
			return document.asXML();
		}
		return null;
	}
	/**
	 *  根据立案对象生成XML字符串
	 * @param claim
	 * @param user
	 * @param password
	 * @return
	 */
	public static String getClaimXML(Claim claim,String user,String password){
		Document document = getClaimDocument(claim, user, password);
		if(document!=null){
			document.setXMLEncoding("GBK");
			return document.asXML();
		}
		return null;
	}
	
	/**
	 *  根据结案对象生成XML字符串
	 * @param EndCase
	 * @param user
	 * @param password
	 * @return
	 */
	public static String getEndCaseXML(EndCase endCase,String user,String password){
		Document document = getEndCaseDocument(endCase, user, password);
		if(document!=null){
			document.setXMLEncoding("GBK");
			return document.asXML();
		}
		return null;
	}
	
	/**
	 *  根据结案追加对象生成XML字符串
	 * @param EndCase
	 * @param user
	 * @param password
	 * @return
	 */
	public static String getEndCaseAppendXML(EndCaseAppend endCaseApp,String user,String password){
		Document document = getEndCaseAppendDocument(endCaseApp, user, password);
		if(document!=null){
			document.setXMLEncoding("GBK");
			return document.asXML();
		}
		return null;
	}
	
	/**
	 *  根据赔付登记对象生成XML字符串
	 * @param EndCase
	 * @param user
	 * @param password
	 * @return
	 */
	public static String getPayRefInfoXML(PayRefInfo payRefInfo,String user,String password){
		Document document = getPayRefInfoDocument(payRefInfo, user, password);
		if(document!=null){
			document.setXMLEncoding("GBK");
			return document.asXML();
		}
		return null;
	}
	/**
	 *  根据案后重开对象生成XML字符串
	 * @param EndCase
	 * @param user
	 * @param password
	 * @return
	 */
	public static String getReCaseXML(ReCase reCase,String user,String password){
		Document document = getReCaseDocument(reCase, user, password);
		if(document!=null){
			document.setXMLEncoding("GBK");
			return document.asXML();
		}
		return null;
	}
	
	public static String getCompensateVericInfoXML(CompensateVeric compensateVeric,String user,String password){
		Document document = getCompensateVericInfoDocument(compensateVeric, user, password);
		if(document!=null){
			document.setXMLEncoding("GBK");
			return document.asXML();
		}
		return null;
	}
	/**
	 *  根据注销立案对象生成XML字符串
	 * @param EndCase
	 * @param user
	 * @param password
	 * @return
	 */
	public static String getCancelCaseXML(CancelCase cancelCase,String user,String password){
		Document document = getCancelCaseDocument(cancelCase, user, password);
		if(document!=null){
			document.setXMLEncoding("GBK");
			return document.asXML();
		}
		return null;
	}

	/**
	 * 根据报案对象生成Document对象
	 * @param regist
	 * @param user
	 * @param password
	 * @return
	 */
	private static Document getRegistDocument(Regist regist,String user,String password){
		
		XmlHelper xmlHelper = new XmlHelper();
		xmlHelper.createDocument(RequestType.REGIST_SIGN);
		xmlHelper.addNode("USER", user, xmlHelper.head);
		xmlHelper.addNode("PASSWORD", password, xmlHelper.head);
		
		//报案主信息
		Element basePartElement = xmlHelper.addNode("BASE_PART", xmlHelper.body);
		xmlHelper.addNode("CONFIRM_SEQUENCE_NO", regist.getConfirmSequenceNo(), basePartElement);
		xmlHelper.addNode("CLAIM_CODE", regist.getClaimCode(), basePartElement);
		xmlHelper.addNode("POLICY_NO", regist.getPolicyNO(), basePartElement);
		xmlHelper.addNode("REPORT_NO", regist.getRegistNo(), basePartElement);
		xmlHelper.addNode("REPORT_TIME", regist.getReportDate(), basePartElement);
		xmlHelper.addNode("ACCIDENT_TIME", regist.getDamageDate(), basePartElement);
		xmlHelper.addNode("CAR_MARK", regist.getLicenseNo(), basePartElement);
		xmlHelper.addNode("VEHICLE_TYPE", regist.getLicenseType(), basePartElement);
		xmlHelper.addNode("PAY_SELF_FLAG", regist.getSelfPayFlag(), basePartElement);
		xmlHelper.addNode("ACCIDENT_PLACE", regist.getDamageAddress(), basePartElement);
		
		//三者车信息列表
		Element thirdCarListElement = xmlHelper.addNode("THIRD_VEHICLE_LIST", xmlHelper.body);
		for(int i = 0; i < regist.getThirdCarList().size(); i++){
			CIClaimThirdCarDto ciClaimThirdCarDto = (CIClaimThirdCarDto)regist.getThirdCarList().get(i);
			Element thirdCarDateElement = xmlHelper.addNode("THIRD_VEHICLE_DATA", thirdCarListElement);
			xmlHelper.addNode("CAR_MARK", ciClaimThirdCarDto.getCarMark(), thirdCarDateElement);
			xmlHelper.addNode("POLICY_NO",ciClaimThirdCarDto.getPolicyNo(), thirdCarDateElement);
			xmlHelper.addNode("COMPANY_CODE", ciClaimThirdCarDto.getClaimCompany(), thirdCarDateElement);
		}
		return xmlHelper.doc;
	}
	/**
	 * 根据立案信息生成Document对象
	 * @param regist
	 * @param user
	 * @param password
	 * @return
	 */
	private static Document getClaimDocument(Claim claim,String user,String password){
		
		XmlHelper xmlHelper = new XmlHelper();
		xmlHelper.createDocument(RequestType.CLAIM_SIGN);
		xmlHelper.addNode("USER", user, xmlHelper.head);
		xmlHelper.addNode("PASSWORD", password, xmlHelper.head);
		
		//立案主信息
		Element basePartElement = xmlHelper.addNode("BASE_PART", xmlHelper.body);
		xmlHelper.addNode("CONFIRM_SEQUENCE_NO", 	claim.getConfirmSequenceNo(), 	basePartElement);
		xmlHelper.addNode("CLAIM_CODE", 			claim.getClaimCode(), 			basePartElement);
		xmlHelper.addNode("ESTIMATE_AMOUNT", 		claim.getUnClaimAmount() + "", 	basePartElement);
		xmlHelper.addNode("REGISTRATION_NO", 				claim.getClaimNo(), 	basePartElement);
		xmlHelper.addNode("REGISTRATION_DATE", 	    claim.getClaimDate(), 			basePartElement);
		
		xmlHelper.addNode("CLAIM_TYPE", 			claim.getCaseType(), 			basePartElement);
		xmlHelper.addNode("CAR_MARK", 				claim.getLicenseNo(), 			basePartElement);
		xmlHelper.addNode("VEHICLE_TYPE", 			claim.getLicenseType(), 		basePartElement);
		xmlHelper.addNode("ACCIDENT_TIME", 			claim.getDamageDate(), 			basePartElement);
		xmlHelper.addNode("POLICY_NO", 				claim.getPolicyNO(), 			basePartElement);
		xmlHelper.addNode("PAY_SELF_FLAG", 			claim.getSelfPayFlag(), 		basePartElement);
		xmlHelper.addNode("ACCIDENT_PLACE", 		claim.getDamageAddress(), 		basePartElement);
		
		//三者车信息列表
		Element thirdCarListElement = xmlHelper.addNode("THIRD_VEHICLE_LIST", xmlHelper.body);
		for(int i = 0; i < claim.getThirdCarList().size(); i++){
			CIClaimThirdCarDto ciClaimThirdCarDto = (CIClaimThirdCarDto)claim.getThirdCarList().get(i);
			Element thirdCarDateElement = xmlHelper.addNode("THIRD_VEHICLE_DATA", thirdCarListElement);
			xmlHelper.addNode("CAR_MARK", ciClaimThirdCarDto.getCarMark(), thirdCarDateElement);
			xmlHelper.addNode("POLICY_NO",ciClaimThirdCarDto.getPolicyNo(), thirdCarDateElement);
			xmlHelper.addNode("COMPANY_CODE", ciClaimThirdCarDto.getClaimCompany(), thirdCarDateElement);
		}
		
		return xmlHelper.doc;
	}
	
	/**
	 * 根据结案信息生成Document对象
	 * @param endCase
	 * @param user
	 * @param password
	 * @return
	 */
	private  static Document getEndCaseDocument(EndCase endCase,String user,String password)
	{
		XmlHelper xmlHelper = new XmlHelper();
		xmlHelper.createDocument(RequestType.ENDCASE_SIGN);
		xmlHelper.addNode("USER", user, xmlHelper.head);
		xmlHelper.addNode("PASSWORD", password, xmlHelper.head);
		
		//结案主信息
		Element basePartElement = xmlHelper.addNode("BASE_PART", xmlHelper.body);
		xmlHelper.addNode("CONFIRM_SEQUENCE_NO",  endCase.getConfirmSequenceNo(), basePartElement);
		xmlHelper.addNode("CLAIM_CODE", 		  endCase.getClaimCode(), basePartElement);
		xmlHelper.addNode("CLAIM_AMOUNT",         new DecimalFormat("0.00").format(endCase.getSumPaid()) + "", basePartElement);
		xmlHelper.addNode("NORES_INSTEAD_AMOUNT", endCase.getNodutyPaid() + "", basePartElement);
		
		xmlHelper.addNode("REPORT_NO",      	  endCase.getRegistNo(),basePartElement); 
		xmlHelper.addNode("REGISTRATION_NO",      endCase.getClaimNo(),basePartElement);                       
		xmlHelper.addNode("CLAIM_NO",             endCase.getEndcaseNo(),basePartElement);         
		xmlHelper.addNode("REPORT_TIME",          endCase.getRegistTime(),basePartElement);     
		xmlHelper.addNode("REGISTRATION_DATE",    endCase.getClaimTime(),basePartElement);                 
		xmlHelper.addNode("ENDCASE_DATE",         endCase.getEndCaseTime(),basePartElement);       
		xmlHelper.addNode("INSURED",              endCase.getIsInsuredDuty(),basePartElement);
		xmlHelper.addNode("CLAIM_TYPE",           endCase.getCaseType(),basePartElement);
		xmlHelper.addNode("PAY_CAUSE",            endCase.getPrepayreason(),basePartElement);
		xmlHelper.addNode("REFUSE_CAUSE",         endCase.getRefusereason(),basePartElement);
		xmlHelper.addNode("CAR_MARK",             endCase.getLicenseNo(),basePartElement);
		xmlHelper.addNode("VEHICLE_TYPE",         endCase.getLicenseType(),basePartElement);
		xmlHelper.addNode("DRIVER_NAME",          endCase.getDriverName(),basePartElement);
		xmlHelper.addNode("CERTI_TYPE",           endCase.getCertiType(),basePartElement);
		xmlHelper.addNode("CERTI_CODE",           endCase.getCertiCode(),basePartElement);
		xmlHelper.addNode("POLICY_NO",            endCase.getPolicyNo(),basePartElement);           
		xmlHelper.addNode("ACCIDENT_TIME",        endCase.getDamageDate(),basePartElement);         
		xmlHelper.addNode("ACCIDENT_PLACE",       endCase.getDamageAdress(),basePartElement);             
		xmlHelper.addNode("ACCIDENT_DESCRIPTION", endCase.getDamageDescription(),basePartElement);               
		xmlHelper.addNode("MANAGE_DEPARTMENT",    endCase.getHandleComcode(),basePartElement);     
		xmlHelper.addNode("LIABILITY_AMOUNT",     endCase.getIndemnityDuty(),basePartElement);    
		xmlHelper.addNode("ACCIDENT_DEATH",       endCase.getAccidentDeath(),basePartElement);
		xmlHelper.addNode("PAY_SELF_FLAG",        endCase.getSelfPayFlag(),basePartElement);
		
		//三者车信息列表
		Element thirdCarListElement = xmlHelper.addNode("THIRD_VEHICLE_LIST", xmlHelper.body);
		for(int i = 0; i < endCase.getThirdCarList().size(); i++){
			CIClaimThirdCarDto ciClaimThirdCarDto = (CIClaimThirdCarDto)endCase.getThirdCarList().get(i);
			Element thirdCarDateElement = xmlHelper.addNode("THIRD_VEHICLE_DATA", thirdCarListElement);
			xmlHelper.addNode("CAR_MARK", ciClaimThirdCarDto.getCarMark(), thirdCarDateElement);
			xmlHelper.addNode("POLICY_NO",ciClaimThirdCarDto.getPolicyNo(), thirdCarDateElement);
			xmlHelper.addNode("COMPANY_CODE", ciClaimThirdCarDto.getClaimCompany(), thirdCarDateElement);
		}
		
		//损失赔偿情况列表
		Element lossListElement = xmlHelper.addNode("CLAIM_COVER_LIST", xmlHelper.body);
		for(int i = 0; i < endCase.getLossSituationList().size(); i++){
			LossSituation lossSituation = (LossSituation)endCase.getLossSituationList().get(i);
			Element lossDataElement = xmlHelper.addNode("CLAIM_COVER_DATA", lossListElement);
			xmlHelper.addNode("POLICY_NO",		lossSituation.getPolicyNo(),lossDataElement);
			xmlHelper.addNode("LIABILITY_RATE", lossSituation.getIndemnitydutyrate() + "",lossDataElement);
			xmlHelper.addNode("CLAIM_FEE_TYPE", lossSituation.getLossType(),lossDataElement);
			xmlHelper.addNode("COVERAGE_TYPE",  lossSituation.getRiskcodeType(),lossDataElement);
			xmlHelper.addNode("COVERAGE_CODE",  "100",lossDataElement);
			xmlHelper.addNode("LOSS_AMOUNT",    new DecimalFormat("0.00").format(lossSituation.getSumLoss()) + "",lossDataElement);
			xmlHelper.addNode("CLAIM_AMOUNT",   new DecimalFormat("0.00").format(lossSituation.getSumPay()) + "",lossDataElement);
			Element detailListElement = xmlHelper.addNode("DETAIL_LIST", lossDataElement);
			for(int j = 0 ; j < lossSituation.getLossSituationDetailList().size(); j++){
				LossSituationDetail lossSituationDetail = (LossSituationDetail)lossSituation.getLossSituationDetailList().get(j);
				Element detailDataElement = xmlHelper.addNode("DETAIL_DATA", detailListElement);
				xmlHelper.addNode("CLAIM_FEE_TYPE",  lossSituationDetail.getLossType(),detailDataElement);
				xmlHelper.addNode("DETAIL_FEE_TYPE", lossSituationDetail.getLossTypeDetail(),detailDataElement);
				xmlHelper.addNode("LOSS_AMOUNT",     new DecimalFormat("0.00").format(lossSituationDetail.getSumLoss()) + "",detailDataElement);
				xmlHelper.addNode("CLAIM_AMOUNT",    new DecimalFormat("0.00").format(lossSituationDetail.getSumPay()) + "",detailDataElement);
				xmlHelper.addNode("LIABILITY_RATE",  lossSituationDetail.getIndemnitydutyrate() + "",detailDataElement);				
			}
		}	
		
		return xmlHelper.doc;
		
	}
	
	/**
	 * 根据案后重开信息生成XML
	 * @param appEndCase
	 * @param user
	 * @param password
	 * @return
	 */
	private static Document getReCaseDocument(ReCase reCase,String user,String password)
	{
		XmlHelper xmlHelper = new XmlHelper();
		xmlHelper.createDocument(RequestType.RECASE_SIGN);
		xmlHelper.addNode("USER", user, xmlHelper.head);
		xmlHelper.addNode("PASSWORD", password, xmlHelper.head);
		
		//结案追加主信息
		Element basePartElement = xmlHelper.addNode("BASE_PART", xmlHelper.body);
		xmlHelper.addNode("CONFIRM_SEQUENCE_NO",  reCase.getConfirmSequenceNo(), basePartElement);
		xmlHelper.addNode("CLAIM_CODE", 		  reCase.getClaimCode(), basePartElement);
		xmlHelper.addNode("REPORT_NO",            reCase.getRegistNo(), basePartElement);
		xmlHelper.addNode("REOPEN_CAUSE", 	      reCase.getReOpenCause(), basePartElement);
		xmlHelper.addNode("REOPEN_DATE",          new SimpleDateFormat("yyyyMMddHHmm").format(reCase.getReOpenDate()), basePartElement);
			
		return xmlHelper.doc;
	}
	/**
	 * 根据结案追加信息生成XML
	 * @param appEndCase
	 * @param user
	 * @param password
	 * @return
	 */
	private static Document getEndCaseAppendDocument(EndCaseAppend endCaseApp,String user,String password)
	{
		XmlHelper xmlHelper = new XmlHelper();
		xmlHelper.createDocument(RequestType.ENDCASE_APPEND);
		xmlHelper.addNode("USER", user, xmlHelper.head);
		xmlHelper.addNode("PASSWORD", password, xmlHelper.head);
		
		//结案追加主信息
		Element basePartElement = xmlHelper.addNode("BASE_PART", xmlHelper.body);
		xmlHelper.addNode("CLAIM_CODE", 		  endCaseApp.getClaimCode(), basePartElement);
		xmlHelper.addNode("SERIAL_NO",  		  endCaseApp.getSerialNo(), basePartElement);
		xmlHelper.addNode("CLAIM_APPEND_DATE", 	  endCaseApp.getAppendDate(), basePartElement);
		xmlHelper.addNode("ACCIDENT_DEATH",       endCaseApp.getAccidentDeath(), basePartElement);
		
		//追加赔偿列表
		Element lossListElement = xmlHelper.addNode("CLAIM_COVER_LIST", xmlHelper.body);
		for(Iterator iter = endCaseApp.getEndCaseAppSituationList().iterator();iter.hasNext();){
			EndCaseAppSituation endCaseAppSituation = (EndCaseAppSituation)iter.next();
			Element lossDataElement = xmlHelper.addNode("CLAIM_COVER_DATA", lossListElement);
			xmlHelper.addNode("CLAIM_FEE_TYPE", 	endCaseAppSituation.getLossType(),lossDataElement);
			xmlHelper.addNode("CLAIM_AMOUNT", 		endCaseAppSituation.getAppPaySum() + "",lossDataElement);
		}
			
		return xmlHelper.doc;
	}
	
	

	/**
	 * 根据实付信息生成XML
	 * @param appEndCase
	 * @param user
	 * @param password
	 * @return
	 */
	private static Document getPayRefInfoDocument(PayRefInfo payRefInfo,String user,String password)
	{
		XmlHelper xmlHelper = new XmlHelper();
		xmlHelper.createDocument(RequestType.CASE_PAYREF);
		xmlHelper.addNode("USER", user, xmlHelper.head);
		xmlHelper.addNode("PASSWORD", password, xmlHelper.head);
		
		//结案追加主信息
		Element basePartElement = xmlHelper.addNode("BASE_PART", xmlHelper.body);
		xmlHelper.addNode("CONFIRM_SEQUENCE_NO",payRefInfo.getConfirmSequenceNo(), basePartElement);
		xmlHelper.addNode("CLAIM_CODE",payRefInfo.getClaimCode(), basePartElement);
		xmlHelper.addNode("REPORT_NO",payRefInfo.getRegistNo(), basePartElement);
		xmlHelper.addNode("CLAIM_AMOUNT",String.valueOf(payRefInfo.getPayAmount()), basePartElement);
		xmlHelper.addNode("BANK_ACCOUNT",payRefInfo.getBankName(), basePartElement);
		xmlHelper.addNode("AccountNumber",payRefInfo.getAccountNumber(), basePartElement);
		xmlHelper.addNode("AccountName",payRefInfo.getAccountName(), basePartElement);
		
		//收款帐户明细列表
		Element payDataListElement = xmlHelper.addNode("PAY_LIST",xmlHelper.body);
		List<Paydata> payDataList = payRefInfo.getPayDataList();
		for(Iterator itr = payDataList.iterator();itr.hasNext();){
			Paydata payData = (Paydata)itr.next();
			Element payDataElement = xmlHelper.addNode("PAY_DATA",payDataListElement);
			
			xmlHelper.addNode("ACCOUNT_NUMBER",payData.getRBankAcount(), payDataElement);
			xmlHelper.addNode("BANK_ACCOUNT",payData.getRBankName(), payDataElement);
			xmlHelper.addNode("ACCOUNT_NAME",payData.getRBankAcountName(), payDataElement);
			xmlHelper.addNode("CENTI_TYPE",payData.getRBankCentiType(), payDataElement);
			xmlHelper.addNode("CENTI_CODE",payData.getRBankCenticode(), payDataElement);
			xmlHelper.addNode("RECOVERY_CODE",payData.getRecoveryCode(), payDataElement);
			xmlHelper.addNode("CLAIM_AMOUNT",String.valueOf(payData.getClaimAmount()), payDataElement);
			xmlHelper.addNode("PAY_TIME",new SimpleDateFormat("yyyyMMddHHmm").format(payData.getPayDate()), payDataElement);
			
		}	
		return xmlHelper.doc;
	}
	
	/**
	 * 根据理算核赔信息生成XML
	 * @param appEndCase
	 * @param user
	 * @param password
	 * @return
	 */
	private static Document getCompensateVericInfoDocument(CompensateVeric compensateVeric1,String user,String password)
	{
		XmlHelper xmlHelper = new XmlHelper();
		xmlHelper.createDocument(RequestType.COMPENSATE_SIGN);
		xmlHelper.addNode("USER", user, xmlHelper.head);
		xmlHelper.addNode("PASSWORD", password, xmlHelper.head);
		
		//理算核赔主信息
		Element basePartElement = xmlHelper.addNode("BASE_PART", xmlHelper.body);
		xmlHelper.addNode("CONFIRM_SEQUENCE_NO", 		  compensateVeric1.getConfirmSequenceNo(), basePartElement);
		xmlHelper.addNode("CLAIM_CODE",  		  compensateVeric1.getClaimCode(), basePartElement);
		xmlHelper.addNode("REPORT_NO", 	  compensateVeric1.getRegistNo(), basePartElement);
		xmlHelper.addNode("PAY_SELF_FLAG", 	  compensateVeric1.getClaimType(), basePartElement);
		xmlHelper.addNode("ISINVOLVING", 	compensateVeric1.getIsInvolving(), basePartElement);//是否涉诉
		//理算信息
		CompensateVeric compensateVeric = null;
		ArrayList compensateVericList = (ArrayList)compensateVeric1.getCompensateVericList();
		if(compensateVericList.size() > 0){
			for(int index = 0;index < compensateVericList.size();index++){
				compensateVeric = (CompensateVeric)compensateVericList.get(index);
				Element adjustment_ListElement = xmlHelper.addNode("ADJUSTMENT_LIST", xmlHelper.body);
				Element adjustment_DataElement = xmlHelper.addNode("ADJUSTMENT_DATA", adjustment_ListElement);
				xmlHelper.addNode("ADJUSTMENT_CODE", 	  compensateVeric.getCompensateNo(), adjustment_DataElement);
				//xmlHelper.addNode("OTHER_FEE", 	  compensateVeric.getOtherFee(), adjustment_DataElement);
				xmlHelper.addNode("UNDER_WRITE_DES", 	  compensateVeric.getUnderWriteDesc(), adjustment_DataElement);
				xmlHelper.addNode("CLAIM_AMOUNT", 	 new DecimalFormat("0.00").format(compensateVeric.getSumPaid()), adjustment_DataElement);
				xmlHelper.addNode("UNDER_WRITE_END_TIME", 	  compensateVeric.getUnderWriteEnd(), adjustment_DataElement);
				
				Element claim_cover_listElement  = xmlHelper.addNode("CLAIM_COVER_LIST",adjustment_DataElement);
				ArrayList<ClaimCover> claimCoverList = (ArrayList)compensateVeric.getClaimCoverList();
				ClaimCover claimCover = null;
				for(int i = 0;i < claimCoverList.size();i++){
					claimCover = claimCoverList.get(i);
					Element claim_cover_dateElement = xmlHelper.addNode("CLAIM_COVER_DATA", claim_cover_listElement);
					xmlHelper.addNode("RECOVERY_OR_PAY_FLAG", 	  claimCover.getRecoveryOrPayFlag(), claim_cover_dateElement);
					xmlHelper.addNode("COVERAGE_CODE", 	  claimCover.getCoverageCode(), claim_cover_dateElement);
					xmlHelper.addNode("CLAIM_FEE_TYPE", 	 claimCover.getLossFeeType() , claim_cover_dateElement);
					xmlHelper.addNode("LIABILITY_RATE", 	  claimCover.getLiabilityRate(), claim_cover_dateElement);
					xmlHelper.addNode("CLAIM_AMOUNT", 	  new DecimalFormat("0.00").format(claimCover.getClaimAmount()), claim_cover_dateElement);
					xmlHelper.addNode("SALVAGE_FEE", 	   Double.toString(claimCover.getSalvageFee()), claim_cover_dateElement);
				}
				
				Element recovery_or_pay_listElement = xmlHelper.addNode("RECOVERY_OR_PAY_LIST",adjustment_DataElement);
				ArrayList<RecoveryOrPay> recoveryOrPayList =  (ArrayList)compensateVeric.getRecoveryOrPayList();
				RecoveryOrPay recoveryOrPay = null;
				for(int i = 0;i < recoveryOrPayList.size();i++){
					recoveryOrPay = recoveryOrPayList.get(i);
					Element recovery_or_pay_dataElement = xmlHelper.addNode("RECOVERY_OR_PAY_DATA",recovery_or_pay_listElement);
					xmlHelper.addNode("SERIAL_NO", recoveryOrPay.getSerialNo()+"",recovery_or_pay_dataElement);
					xmlHelper.addNode("RECOVERY_OR_PAY_TYPE", recoveryOrPay.getRecoveryOrPayType(),recovery_or_pay_dataElement);
					xmlHelper.addNode("RECOVERY_OR_PAY_FLAG", recoveryOrPay.getRecoveryOrPayFlag(),recovery_or_pay_dataElement);
					xmlHelper.addNode("RECOVERY_OR_PAY_MAN", recoveryOrPay.getRecoveryOrPayMan(),recovery_or_pay_dataElement);
					xmlHelper.addNode("RECOVERY_CODE", recoveryOrPay.getRecoveryCode(),recovery_or_pay_dataElement);
					xmlHelper.addNode("RECOVERY_OR_PAY_AMOUNT", Double.toString(recoveryOrPay.getRecoveryOrPayAmount()),recovery_or_pay_dataElement);
					xmlHelper.addNode("RECOVERY_REMARK", recoveryOrPay.getRecoveryRemark(),recovery_or_pay_dataElement);
				}
			}
		}
		return xmlHelper.doc;
	}
	/**
	 * 根据案件注销信息生成XML
	 * @param appEndCase
	 * @param user
	 * @param password
	 * @return
	 */
	private static Document getCancelCaseDocument(CancelCase cancelCase,String user,String password)
	{
		XmlHelper xmlHelper = new XmlHelper();
		xmlHelper.createDocument(RequestType.CASE_CANCEL);
		xmlHelper.addNode("USER", user, xmlHelper.head);
		xmlHelper.addNode("PASSWORD", password, xmlHelper.head);
		
		//案件注销主信息
		Element basePartElement = xmlHelper.addNode("BASE_PART", xmlHelper.body);
		xmlHelper.addNode("CLAIM_CODE",cancelCase.getClaimCode(),basePartElement);
		xmlHelper.addNode("CANCEL_TYPE",cancelCase.getCancelType(),basePartElement);
		xmlHelper.addNode("CANCEL_CAUSE",cancelCase.getCancelReason(),basePartElement);
		xmlHelper.addNode("CANCEL_DESC",cancelCase.getCancelDesc(),basePartElement);
		return xmlHelper.doc;
	}
	
	/**
	 * 根据Document对象生成RegistDTO对象
	 * @param xmlStr
	 * @return
	 * @throws DocumentException 
	 */
	public static ReturnInfo getReturnRegistFromXML(String xmlStr) throws ParseException, DocumentException{
		ReturnInfo returnInfo= null;
		HistoryClaim historyClaim = null;
		try {
			returnInfo=new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			//得到根节点PACKET 
			Element packet = document.getRootElement();
			//得到HEAD节点
			for (Iterator it=packet.elementIterator("HEAD"); it.hasNext();)
			{
				Element head=(Element)it.next();
				returnInfo.setRequestType(parseNode(head.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setReturnType(parseNode(head.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorCode(parseNode(head.selectSingleNode("ERROR_CODE")));
				returnInfo.setErrorMessage(parseNode(head.selectSingleNode("ERROR_MESSAGE")));
			}
			//得到BODY节点
			for (Iterator bit=packet.elementIterator("BODY"); bit.hasNext();)
			{
				Element body=(Element)bit.next();
				//得到BASE_PART节点
				Element basepart=(Element)body.selectSingleNode("BASE_PART");
				returnInfo.setClaimCode(parseNode(basepart.selectSingleNode("CLAIM_CODE")));
				//得到CLAIM_LIST节点
				Element claimList=(Element)body.selectSingleNode("CLAIM_LIST");
				//遍历CLAIM_DATA列表
				int index = 0;
				for (Iterator it = claimList.elementIterator("CLAIM_DATA"); it.hasNext();)
				{
					historyClaim=new HistoryClaim();
					Element claimDate=(Element)it.next();
					historyClaim.setClaimCode(returnInfo.getClaimCode());
					historyClaim.setSerialNo(index++);
					historyClaim.setClaimCompany(parseNode(claimDate.selectSingleNode("CLAIM_COMPANY")));
					historyClaim.setLicenseNo(parseNode(claimDate.selectSingleNode("CAR_MARK")));
					historyClaim.setVehicleType(parseNode(claimDate.selectSingleNode("VEHICLE_TYPE")));
					historyClaim.setIsInsuredCar(parseNode(claimDate.selectSingleNode("IS_INSURED_CAR")));
					historyClaim.setCoverageType(parseNode(claimDate.selectSingleNode("COVERAGE_TYPE")));
					historyClaim.setRegistNo(parseNode(claimDate.selectSingleNode("REPORT_NO")));
					historyClaim.setClaimNo(parseNode(claimDate.selectSingleNode("CLAIM_NO")));
					historyClaim.setPolicyNo(parseNode(claimDate.selectSingleNode("POLICY_NO")));
					historyClaim.setAccidentTime(getDateTime(claimDate,"ACCIDENT_TIME"));
					historyClaim.setRegistTime(getDateTime(claimDate,"REPORT_TIME"));
					historyClaim.setEndCaseTime(getDateTime(claimDate,"ENDCASE_DATE"));
					historyClaim.setUnClaimAmount(parseDouble(parseNode(claimDate.selectSingleNode("UNCLAIM_AMOUNT"))));
					historyClaim.setClaimAmount(parseDouble(parseNode(claimDate.selectSingleNode("CLAIM_AMOUNT"))));
					historyClaim.setCaseStatus(parseNode(claimDate.selectSingleNode("STATUS")));
					historyClaim.setAccidentPlace(parseNode(claimDate.selectSingleNode("ACCIDENT_PLACE")));
					historyClaim.setAccidentDesc(parseNode(claimDate.selectSingleNode("ACCIDENT_DESCRIPTION")));
					historyClaim.setIndemnityDuty(CodeTransfer.IndemnityDuty.covrentSystemCode(parseNode(claimDate.selectSingleNode("ACCIDENT_TYPE"))));
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
	 * @param xmlStr
	 * @return
	 * @throws DocumentException 
	 */
	public static ReturnInfo getReturnClaimFromXML(String xmlStr) throws ParseException, DocumentException{
		ReturnInfo returnInfo= null;
		HistoryClaim historyClaim = null;
		try {
			returnInfo=new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			//得到根节点PACKET 
			Element packet = document.getRootElement();
			//得到HEAD节点
			for (Iterator it=packet.elementIterator("HEAD"); it.hasNext();)
			{
				Element head=(Element)it.next();
				returnInfo.setRequestType(parseNode(head.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setReturnType(parseNode(head.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorCode(parseNode(head.selectSingleNode("ERROR_CODE")));
				returnInfo.setErrorMessage(parseNode(head.selectSingleNode("ERROR_MESSAGE")));
			}
			//得到BODY节点
			for (Iterator bit=packet.elementIterator("BODY"); bit.hasNext();)
			{
				Element body=(Element)bit.next();

				//得到BASE_PART节点
				Element basepart=(Element)body.selectSingleNode("BASE_PART");
				returnInfo.setClaimCode(parseNode(basepart.selectSingleNode("CLAIM_CODE")));
				//得到CLAIM_LIST节点
				Element claimList=(Element)body.selectSingleNode("CLAIM_LIST");
				//遍历CLAIM_DATA列表
				int index = 0;
				if(claimList!=null){
				for (Iterator it = claimList.elementIterator("CLAIM_DATA"); it.hasNext();)
				{
					historyClaim=new HistoryClaim();
					Element claimData=(Element)it.next();
					historyClaim.setClaimCode(returnInfo.getClaimCode());
					historyClaim.setSerialNo(index++);
					historyClaim.setClaimCompany(parseNode(claimData.selectSingleNode("CLAIM_COMPANY")));
					historyClaim.setLicenseNo(parseNode(claimData.selectSingleNode("CAR_MARK")));
					historyClaim.setVehicleType(parseNode(claimData.selectSingleNode("VEHICLE_TYPE")));
					historyClaim.setIsInsuredCar(parseNode(claimData.selectSingleNode("IS_INSURED_CAR")));
					historyClaim.setCoverageType(parseNode(claimData.selectSingleNode("COVERAGE_TYPE")));
					historyClaim.setRegistNo(parseNode(claimData.selectSingleNode("REPORT_NO")));
					historyClaim.setClaimNo(parseNode(claimData.selectSingleNode("CLAIM_NO")));
					historyClaim.setPolicyNo(parseNode(claimData.selectSingleNode("POLICY_NO")));
					historyClaim.setAccidentTime(getDateTime(claimData,"ACCIDENT_TIME"));
					historyClaim.setRegistTime(getDateTime(claimData,"REPORT_TIME"));
					historyClaim.setEndCaseTime(getDateTime(claimData,"ENDCASE_DATE"));					
					historyClaim.setUnClaimAmount(parseDouble(parseNode(claimData.selectSingleNode("UNCLAIM_AMOUNT"))));
					historyClaim.setClaimAmount(parseDouble(parseNode(claimData.selectSingleNode("CLAIM_AMOUNT"))));
					historyClaim.setCaseStatus(parseNode(claimData.selectSingleNode("STATUS")));
					historyClaim.setAccidentPlace(parseNode(claimData.selectSingleNode("ACCIDENT_PLACE")));
					historyClaim.setAccidentDesc(parseNode(claimData.selectSingleNode("ACCIDENT_DESCRIPTION")));
					historyClaim.setIndemnityDuty(CodeTransfer.IndemnityDuty.covrentSystemCode(parseNode(claimData.selectSingleNode("ACCIDENT_TYPE"))));
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
	 * 根据Document对象生成ReturnEndCaseDTO对象
	 * @param xmlStr
	 * @return
	 * @throws DocumentException 
	 */
	public static ReturnInfo getReturnEndCaseFromXML(String xmlStr) throws ParseException,DocumentException{
		ReturnInfo returnEndCase=null;
		CIClaimThirdCarDto thirdCar = null;
		try
		{
			returnEndCase=new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			//得到根节点PACKET 
			Element packet = document.getRootElement();
			//得到HEAD节点
			for (Iterator it=packet.elementIterator("HEAD"); it.hasNext();)
			{
				Element head=(Element)it.next();
				returnEndCase.setRequestType(parseNode(head.selectSingleNode("REQUEST_TYPE")));
				returnEndCase.setReturnType(parseNode(head.selectSingleNode("RESPONSE_CODE")));
				returnEndCase.setErrorCode(parseNode(head.selectSingleNode("ERROR_CODE")));
				returnEndCase.setErrorMessage(parseNode(head.selectSingleNode("ERROR_MESSAGE")));
			}
			
//			得到BODY节点
			for (Iterator bit=packet.elementIterator("BODY"); bit.hasNext();)
			{
				Element body=(Element)bit.next();

				//得到BASE_PART节点
				Element basepart=(Element)body.selectSingleNode("BASE_PART");
				returnEndCase.setClaimCode(parseNode(basepart.selectSingleNode("CLAIM_CODE")));
				returnEndCase.setClaimConfirmCode(parseNode(basepart.selectSingleNode("CLAIM_CONFIRM_CODE")));
				//得到THIRD_VEHICLE_LIST节点
				Element claimList=(Element)body.selectSingleNode("THIRD_VEHICLE_LIST");
				//遍历THIRD_VEHICLE_DATA列表
				int index = 0;
				if(claimList!=null){
				for (Iterator it = claimList.elementIterator("THIRD_VEHICLE_DATA"); it.hasNext();)
				{
					thirdCar = new CIClaimThirdCarDto();
					Element thirdCarData=(Element)it.next();
					thirdCar.setClaimCode(returnEndCase.getClaimCode());
					thirdCar.setSerialNo(index++);
					thirdCar.setPolicyNo(parseNode(thirdCarData.selectSingleNode("POLICY_NO")));
					thirdCar.setCarMark(parseNode(thirdCarData.selectSingleNode("CAR_MARK")));
					thirdCar.setVehicleType(parseNode(thirdCarData.selectSingleNode("VEHICLE_TYPE")));
					thirdCar.setClaimCompany(parseNode(thirdCarData.selectSingleNode("COMPANY_CODE")));
					thirdCar.setThirdClaimCode(parseNode(thirdCarData.selectSingleNode("CLAIM_CODE")));
					thirdCar.setClaimStatus(parseNode(thirdCarData.selectSingleNode("CLAIM_STATUS")));
					thirdCar.setPaySelfFlag(parseNode(thirdCarData.selectSingleNode("PAY_SELF_FLAG")));
					thirdCar.setRegistNo(parseNode(thirdCarData.selectSingleNode("REPORT_NO")));
					thirdCar.setClaimNo(parseNode(thirdCarData.selectSingleNode("CLAIM_NO")));
					thirdCar.setAccidentDate(getDateTime(thirdCarData,"ACCIDENT_TIME"));
					thirdCar.setAccidentPlace(parseNode(thirdCarData.selectSingleNode("ACCIDENT_PLACE")));
					thirdCar.setSumPaid(Double.parseDouble(parseNode(thirdCarData.selectSingleNode("CLAIM_AMOUNT"))));
					
					returnEndCase.addThirdCar(thirdCar);
				}	
			}
			}
		}catch (DocumentException e) {
			e.printStackTrace();
			throw e;
		}
		return returnEndCase;
	}
	/**
	 * 根据Document对象生成ReCase对象
	 * @param xmlStr
	 * @return
	 * @throws DocumentException 
	 */
	public static ReturnInfo getReturnReCaseFromXML(String xmlStr,ReCase reCase) throws DocumentException{
		ReturnInfo returnInfo=null;
		PrpLlocklogDto locked=null;
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
				returnInfo.setRequestType(parseNode(head.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setReturnType(parseNode(head.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorCode(parseNode(head.selectSingleNode("ERROR_CODE")));
				returnInfo.setErrorMessage(parseNode(head.selectSingleNode("ERROR_MESSAGE")));
			}
			//得到BODY节点
			for (Iterator bit=packet.elementIterator("BODY"); bit.hasNext();)
			{
				Element body=(Element)bit.next();
				//得到LOCKED_LIST节点
				Element claimList=(Element)body.selectSingleNode("LOCKED_LIST");
				//遍历LOCKED_LIST列表
				int index = 1;
				for (Iterator it = claimList.elementIterator("LOCKED_DATA"); it.hasNext();)
				{
					locked = new PrpLlocklogDto();
					Element lockedData=(Element)it.next();
					locked.setNodeType("recase");
					locked.setRecoveryCode(parseNode(lockedData.selectSingleNode("RECOVERY_CODE")));
					locked.setRecoveryCodeStatus(parseNode(lockedData.selectSingleNode("RECOVERY_CODE_STATUS")));
					locked.setRecoverStatus(parseNode(lockedData.selectSingleNode("RECOVER_STATUS")));
					locked.setInsurerCode(parseNode(lockedData.selectSingleNode("INSURER_CODE")));
					locked.setInsurerArea(parseNode(lockedData.selectSingleNode("INSURER_AREA")));
					locked.setCoverageType(parseNode(lockedData.selectSingleNode("COVERAGE_TYPE")));
					locked.setPolicyNo(parseNode(lockedData.selectSingleNode("POLICY_NO")));
					locked.setClaimNotificationNo(parseNode(lockedData.selectSingleNode("REPORT_NO")));
					locked.setClaimStatus(parseNode(lockedData.selectSingleNode("CLAIM_STATUS")));
					locked.setClaimProgress(parseNode(lockedData.selectSingleNode("CLAIM_PROGRESS")));
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
	/**
	 * 根据Document对象生成EndCaseAppendDTO对象
	 * @param xmlStr
	 * @return
	 * @throws DocumentException 
	 */
	public static ReturnInfo getReturnEndCaseApendFromXML(String xmlStr) throws DocumentException{
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
				returnInfo.setRequestType(parseNode(head.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setReturnType(parseNode(head.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorCode(parseNode(head.selectSingleNode("ERROR_CODE")));
				returnInfo.setErrorMessage(parseNode(head.selectSingleNode("ERROR_MESSAGE")));
			}
			/**得到BODY节点*/
			List<PrpLlocklogDto> lockedDataList = returnInfo.getLocked();
			for (Iterator bit=packet.elementIterator("BODY"); bit.hasNext();){
				Element body=(Element)bit.next();
				for(Iterator lockedListItr = body.elementIterator("LOCKED_LIST");lockedListItr.hasNext();){
					Element lockedList = (Element)lockedListItr.next();
					
					PrpLlocklogDto prpLlocklogDto = null;
					Iterator lockedDataItr = (Iterator)lockedList.elementIterator("LOCKED_DATA");
					if(lockedDataItr!=null){
						while(lockedDataItr.hasNext()){
							prpLlocklogDto = new PrpLlocklogDto();
							lockedDataList.add(prpLlocklogDto);
							Element LockedDataNode = (Element)lockedDataItr.next();
							
							prpLlocklogDto.setRecoveryCode(parseNode(LockedDataNode.selectSingleNode("RECOVERY_CODE")));
							prpLlocklogDto.setInputDate(DateTime.current());
							prpLlocklogDto.setNodeType("payment");
							prpLlocklogDto.setRiskCode("0507");
							prpLlocklogDto.setRecoverStatus(parseNode(LockedDataNode.selectSingleNode("RECOVER_STATUS")));
							prpLlocklogDto.setInsurerCode(parseNode(LockedDataNode.selectSingleNode("INSURER_CODE")));
							prpLlocklogDto.setInsurerArea(parseNode(LockedDataNode.selectSingleNode("INSURER_AREA")));
							prpLlocklogDto.setCoverageType(parseNode(LockedDataNode.selectSingleNode("COVERAGE_TYPE")));
							prpLlocklogDto.setPolicyNo(parseNode(LockedDataNode.selectSingleNode("POLICY_NO")));
							prpLlocklogDto.setClaimNotificationNo(parseNode(LockedDataNode.selectSingleNode("REPORT_NO")));
							prpLlocklogDto.setClaimStatus(parseNode(LockedDataNode.selectSingleNode("CLAIM_STATUS")));
							prpLlocklogDto.setRecoveryCodeStatus(parseNode(LockedDataNode.selectSingleNode("RECOVERY_CODE_STATUS")));
							prpLlocklogDto.setClaimProgress(parseNode(LockedDataNode.selectSingleNode("CLAIM_PROGRESS"))==null?"":parseNode(LockedDataNode.selectSingleNode("CLAIM_PROGRESS")));
						}
					}
				}
			}
			
		}catch (DocumentException e) {
			e.printStackTrace();
			throw e;
		}
		return returnInfo;
	}
	
	public static ReturnInfo getReturnCompensateVericInfoFromXML(String xmlStr) throws DocumentException{
		ReturnInfo returnInfo= null;
		HistoryClaim historyClaim = null;
		PrpLlocklogDto prpLlocklogDto =null;
		try {
			returnInfo=new ReturnInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			//得到根节点PACKET 
			Element packet = document.getRootElement();
			//得到HEAD节点
			for (Iterator it=packet.elementIterator("HEAD"); it.hasNext();)
			{
				Element head=(Element)it.next();
				returnInfo.setRequestType(parseNode(head.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setReturnType(parseNode(head.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorCode(parseNode(head.selectSingleNode("ERROR_CODE")));
				returnInfo.setErrorMessage(parseNode(head.selectSingleNode("ERROR_MESSAGE")));
			}
			//得到BODY节点
			for (Iterator bit=packet.elementIterator("BODY"); bit.hasNext();)
			{
				Element body=(Element)bit.next();
				Element lockedList=(Element)body.selectSingleNode("LOCKED_LIST");
				int index = 0;
				//遍历LOCKED_DATA列表
				for (Iterator it = lockedList.elementIterator("LOCKED_DATA"); it.hasNext();){
					prpLlocklogDto = new PrpLlocklogDto();
					Element lockedData=(Element)it.next();
					prpLlocklogDto.setNodeType("veric");
					prpLlocklogDto.setRecoveryCode(parseNode(lockedData.selectSingleNode("RECOVERY_CODE")));
					prpLlocklogDto.setRecoveryCodeStatus(parseNode(lockedData.selectSingleNode("RECOVERY_CODE_STATUS")));
					prpLlocklogDto.setRecoverStatus(parseNode(lockedData.selectSingleNode("RECOVER_STATUS")));
					prpLlocklogDto.setInsurerCode(parseNode(lockedData.selectSingleNode("INSURER_CODE")));
					prpLlocklogDto.setInsurerArea(parseNode(lockedData.selectSingleNode("INSURER_AREA")));
					prpLlocklogDto.setCoverageType(parseNode(lockedData.selectSingleNode("COVERAGE_TYPE")));
					prpLlocklogDto.setPolicyNo(parseNode(lockedData.selectSingleNode("POLICY_NO")));
					prpLlocklogDto.setClaimNotificationNo(parseNode(lockedData.selectSingleNode("REPORT_NO")));
					prpLlocklogDto.setClaimStatus(parseNode(lockedData.selectSingleNode("CLAIM_STATUS")));
					prpLlocklogDto.setClaimProgress(parseNode(lockedData.selectSingleNode("CLAIM_PROGRESS")));
					returnInfo.addLocked(prpLlocklogDto);
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
	 * 根据Document对象生成ReturnCancelCaseDTO对象
	 * @param xmlStr
	 * @return
	 * @throws DocumentException 
	 */
	public static ReturnInfo getReturnCancelCaseFromXML(String xmlStr) throws DocumentException{
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
				returnInfo.setRequestType(parseNode(head.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setReturnType(parseNode(head.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorCode(parseNode(head.selectSingleNode("ERROR_CODE")));
				returnInfo.setErrorMessage(parseNode(head.selectSingleNode("ERROR_MESSAGE")));
			}
			//得到BODY节点
			for (Iterator bit=packet.elementIterator("BODY"); bit.hasNext();)
			{
				Element body=(Element)bit.next();

				//得到BASE_PART节点
				Element basepart=(Element)body.selectSingleNode("BASE_PART");
				returnInfo.setClaimCode(parseNode(basepart.selectSingleNode("CLAIM_CODE")));
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
			throw new ParseException("返回的日期字符串格式不正确，无法解析.［日期字符串＝"+dateString+"]", 0);
		}
		
		return new SimpleDateFormat(dateFormat).parse(dateString);
	}
	
	private static DateTime getDateTime(Element element,String nodeName) throws ParseException{

		String dateString = "";
		String dateFormat = "yyyyMMddHHmm";
		DateTime dateTime = new DateTime();
		if(element.selectSingleNode(nodeName)!=null){
			dateString = element.selectSingleNode(nodeName).getText();
		}
		
		if(dateString == null || dateString.length() == 0){
			dateTime = new DateTime();
		}else{
			if(dateString.length()==8){
				dateFormat = "yyyyMMdd";
			}else if(dateString.length()==10){
				dateFormat = "yyyyMMddHH";
			}else if(dateString.length()==12){
				dateFormat = "yyyyMMddHHmm";
			}else if(dateString.length()==14){
				dateFormat = "yyyyMMddHHmmss";
			}else{
				throw new ParseException("返回的日期字符串格式不正确，无法解析.［日期字符串＝"+dateString+"]", 0);
			}
		} 
		Date date = new SimpleDateFormat(dateFormat).parse(dateString);
		dateTime = new DateTime( new SimpleDateFormat("yyyyMMdd HH:mm").format(date),DateTime.YEAR_TO_MINUTE);
		return dateTime;
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
			return Str.round(Double.parseDouble(data),2);
		}
		return 0;
	}
	
	public static void main(String[] args)throws Exception{
		String dateString = "";
		DateTime dateTime = new DateTime();
		dateString = "200608031015";
		String dateFormat = "";
		if(dateString.length()==0){
		}else if(dateString.length()==8){
			dateFormat = "yyyyMMdd";
		}else if(dateString.length()==10){
			dateFormat = "yyyyMMddHH";
		}else if(dateString.length()==12){
			dateFormat = "yyyyMMddHHmm";
		}else if(dateString.length()==14){
			dateFormat = "yyyyMMddHHmmss";
		}else{
			throw new ParseException("返回的日期字符串格式不正确，无法解析.［日期字符串＝"+dateString+"]", 0);
		}
		Date d = new SimpleDateFormat(dateFormat).parse(dateString);
		
		dateTime = new DateTime( new SimpleDateFormat("yyyyMMdd HH:mm").format(d),DateTime.YEAR_TO_MINUTE);
		
		System.err.println("date = " + d + " and "+ dateTime.toString());
	}
	
	/**
	 * 根据报案对象生成XML字符串
	 * @param regist
	 * @param user
	 * @param password
	 * @return
	 */
	public static String getAccountNoXML(Accounts accounts,String user,String password){
		Document document = getAccountNoDocument(accounts, user, password);
		if(document!=null){
			document.setXMLEncoding("GBK");
			return document.asXML();
		}
		return null;
	}
	
	/**
	 * 根据报案对象生成Document对象
	 * @param regist
	 * @param user
	 * @param password
	 * @return
	 */
	private static Document getAccountNoDocument(Accounts accounts,String user,String password){
		
		XmlHelper xmlHelper = new XmlHelper();
		xmlHelper.createDocument(RequestType.ACCOUNT_NO_QUERY);
		xmlHelper.addNode("USER", user, xmlHelper.head);
		xmlHelper.addNode("PASSWORD", password, xmlHelper.head);
		
		//报案主信息
		Element basePartElement = xmlHelper.addNode("BASE_PART", xmlHelper.body);
		xmlHelper.addNode("OPPOENT_INSURER_CODE", accounts.getOppoentInsurerCode(), basePartElement);
		xmlHelper.addNode("OPPOENT_INSURER_AREA", accounts.getOppoentInsurerArea(), basePartElement);
		xmlHelper.addNode("OPPOENT_COVERAGE_TYPE", accounts.getOppoentCoverageCode(), basePartElement);
		xmlHelper.addNode("OPPOENT_REPORT_NO", accounts.getOppoentRegistNo(), basePartElement);
		xmlHelper.addNode("RECOVERY_STATUS", accounts.getRecoverStatus(), basePartElement);
		xmlHelper.addNode("CLAIM_CODE", accounts.getClaimCode(), basePartElement);
		xmlHelper.addNode("REPORT_NO", accounts.getRecoveryRegistNo(), basePartElement);
		return xmlHelper.doc;
	}
	
	/**
	 * 根据Document对象生成RegistDTO对象
	 * @param xmlStr
	 * @return
	 * @throws DocumentException 
	 */
	public static ReturnAccountsInfo getReturnAccountNoFromXML(String xmlStr) throws ParseException, DocumentException{
		ReturnAccountsInfo returnInfo= null;
		Accounts accounts = null;
		try {
			returnInfo=new ReturnAccountsInfo();
			Document document = DocumentHelper.parseText(xmlStr);
			//得到根节点PACKET 
			Element packet = document.getRootElement();
			//得到HEAD节点
			for (Iterator it=packet.elementIterator("HEAD"); it.hasNext();)
			{
				Element head=(Element)it.next();
				returnInfo.setRequestType(parseNode(head.selectSingleNode("REQUEST_TYPE")));
				returnInfo.setResponseCode(parseNode(head.selectSingleNode("RESPONSE_CODE")));
				returnInfo.setErrorCode(parseNode(head.selectSingleNode("ERROR_CODE")));
				returnInfo.setErrorMessage(parseNode(head.selectSingleNode("ERROR_MESSAGE")));
			}
			//得到BODY节点
			for (Iterator bit=packet.elementIterator("BODY"); bit.hasNext();)
			{
				Element body=(Element)bit.next();
				Element claimList=(Element)body.selectSingleNode("QUERY_RESULT_LIST");
				//遍历QUERY_RESULT_LIST列表
				int index = 0;
				for (Iterator it = claimList.elementIterator("QUERY_RESULT_DATA"); it.hasNext();)
				{
					accounts=new Accounts();
					Element claimDate=(Element)it.next();
					accounts.setSerialNo(index++);
					accounts.setAccountsNo(parseNode(claimDate.selectSingleNode("RECOVERY_CODE")));
					accounts.setAccountsNoStatus(parseNode(claimDate.selectSingleNode("RECOVERY_CODE_STATUS")));
					accounts.setFailureTime(parseNode(claimDate.selectSingleNode("FAILURE_TIME")));
					accounts.setFailureCause(parseNode(claimDate.selectSingleNode("FAILURE_CAUSE")));
					accounts.setRecoverStatus(parseNode(claimDate.selectSingleNode("RECOVERY_STATUS")));
					accounts.setRecoveryRegistNo(parseNode(claimDate.selectSingleNode("REPORT_NO")));
					accounts.setRecoveryRiskCode(parseNode(claimDate.selectSingleNode("COVERAGE_TYPE")));
					returnInfo.addAccounts(accounts);
				}
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		return returnInfo;
	}
}
