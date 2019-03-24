package com.sinosoft.ciplatform.bl.action.custom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.ciplatform.dto.custom.Accounts;
import com.sinosoft.ciplatform.dto.custom.CancelCase;
import com.sinosoft.ciplatform.dto.custom.Claim;
import com.sinosoft.ciplatform.dto.custom.CompensateVeric;
import com.sinosoft.ciplatform.dto.custom.EndCase;
import com.sinosoft.ciplatform.dto.custom.EndCaseAppend;
import com.sinosoft.ciplatform.dto.custom.Iconstants;
import com.sinosoft.ciplatform.dto.custom.Payinfor;
import com.sinosoft.ciplatform.dto.custom.PlatFormParam;
import com.sinosoft.ciplatform.dto.custom.ReCase;
import com.sinosoft.ciplatform.dto.custom.Regist;
import com.sinosoft.ciplatform.dto.custom.ReturnAccountsInfo;
import com.sinosoft.ciplatform.dto.custom.ReturnInfo;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;


public class CIPlatFormInterface {
	private static Log logger = LogFactory.getLog(CIPlatFormInterface.class);
	private CIPlatFormInterface() {
		// ��ֹ���죬ֱ�ӵ��þ�̬��������
	}	
	
	// ���� ��ά��
	public static ReturnInfo send(Regist regist, PlatFormParam pfp)//2011
			throws Exception {
		try {
			String xmlString = "";
			ReturnInfo returnInfo = null;
			
			xmlString = XMLHandlerSYX.getRegistXML(regist, pfp.getUserName(), pfp.getUserPwd());
			
			logger.debug("���͵ı���XML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			logger.debug("ƽ̨���ص�XML(������[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			System.out.println("���صı���XML��"+retXmlString);
				
			returnInfo = XMLHandlerSYX.getReturnFromXMLConsole(retXmlString,Iconstants.ZJRequstType.REGIST_SYX);
			if(returnInfo==null)System.out.println("returnInfoȷʵΪ��");
			if(returnInfo.getClaimCode()==null||returnInfo.getClaimCode().trim().length()==0){
				returnInfo.setClaimCode(regist.getRegistNo());
			}

			return returnInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// ����
	public static ReturnInfo send(Claim claim, PlatFormParam pfp)//2011
			throws Exception {
		try {
			String xmlString = "";
			ReturnInfo returnInfo = null;		
			xmlString = XMLHandlerSYX.getClaimXML(claim, pfp.getUserName(),
						pfp.getUserPwd());

			logger.debug("���͵�����XML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			logger.debug("ƽ̨���ص�XML(������[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			System.out.println("���ص�����XML��"+retXmlString);				
			returnInfo = XMLHandlerSYX.getReturnFromXMLConsole(retXmlString,Iconstants.ZJRequstType.CLAIM_SYX);
			if(returnInfo.getClaimCode()==null||returnInfo.getClaimCode().trim().length()==0){
				returnInfo.setClaimCode(claim.getRegistNo());
			}
			return returnInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	// �᰸
	public static ReturnInfo send(EndCase endCase, PlatFormParam pfp)//2011
			throws Exception {
		try {
			String xmlString = "";
			ReturnInfo returnInfo = null;
		
				xmlString = XMLHandlerSYX.getEndCaseXML(endCase, pfp
						.getUserName(), pfp.getUserPwd());

			logger.debug("���͵Ľ᰸XML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			logger.debug("ƽ̨���ص�XML(�᰸��[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			System.out.println("���صĽ᰸XML��"+retXmlString);
			
			returnInfo = XMLHandlerSYX.getReturnFromXMLConsole(retXmlString,Iconstants.ZJRequstType.ENDCASE_SYX);
			if(returnInfo.getClaimCode()==null||returnInfo.getClaimCode().trim().length()==0){
				returnInfo.setClaimCode(endCase.getRegistNo());
			}
			return returnInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// ����ע��
	public static ReturnInfo send(CancelCase cancelCase, PlatFormParam pfp)//2011
			throws Exception {
		try {
			String xmlString = "";
			ReturnInfo returnInfo = null;
			
				xmlString = XMLHandlerSYX.getCancelCaseXML(cancelCase, pfp
						.getUserName(), pfp.getUserPwd());

			logger.debug("���͵�ע��XML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			logger.debug("ƽ̨���ص�XML(ע����[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			System.out.println("���ص�����ȡ��XML��"+retXmlString);
			returnInfo = XMLHandlerSYX.getReturnFromXMLConsole(retXmlString,Iconstants.ZJRequstType.CANCEL_CASE);
			return returnInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// ׷�ӽ᰸
	public static ReturnInfo send(EndCaseAppend endCaseAppend, PlatFormParam pfp)//2011
			throws Exception {
		try {
			String xmlString = "";
			ReturnInfo returnInfo = null;
	
				xmlString = XMLHandlerSYX.getEndCaseAppendXML(endCaseAppend, pfp
						.getUserName(), pfp.getUserPwd());

			logger.debug("���͵Ľ᰸׷��XML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			logger.debug("ƽ̨���ص�XML(�᰸׷�ӣ�[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			System.out.println("���صĽ᰸׷��XML��"+retXmlString);
			returnInfo = XMLHandlerSYX.getReturnFromXMLConsole(retXmlString,Iconstants.ZJRequstType.ENDCASE_APPEND_SYX);
			return returnInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	//�ؿ��ⰸ
	public static ReturnInfo send(ReCase reCase, PlatFormParam  pfp)//2011
			throws Exception {
		try {
			String xmlString = "";
			ReturnInfo returnInfo = null;
	
				xmlString = XMLHandlerSYX.getReCaseXML(reCase, pfp
						.getUserName(), pfp.getUserPwd());

			logger.debug("���͵��ؿ��ⰸXML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			//String retXmlString="<?xml version='1.0' encoding='gb2312'?><PACKET type='RESPONSE' version='1.0'><Head><RequestType>V3111</RequestType><ResponseCode>1</ResponseCode><ErrorCode>0000</ErrorCode><ErrorMessage>�ɹ�</ErrorMessage></Head><Body><LockedData><RecoveryCode>V3101PICCCSN1234567890</RecoveryCode><RecoverStatus>1</RecoverStatus><InsurerCode>PICC</InsurerCode><InsurerArea>110000</InsurerArea><CoverageType>1</CoverageType><PolicyNo> V3101PICCCSN1234567890</PolicyNo><ClaimNotificationNo>V3101PICCCSN1234567890</ClaimNotificationNo><ClaimStatus>1</ClaimStatus><RecoveryCodeStatus>1</RecoveryCodeStatus></LockedData></Body></PACKET>";
			logger.debug("ƽ̨���ص�XML(�ؿ��ⰸ��[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			System.out.println("���ص��ؿ��ⰸXML��"+retXmlString);
			returnInfo = XMLHandlerSYX.getZJReturnReCaseFromXML(retXmlString,reCase);
			if(returnInfo.getClaimCode()==null||returnInfo.getClaimCode().trim().length()==0){
				returnInfo.setClaimCode(reCase.getClaimCode());
			}
			return returnInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	//ȫ����ҵ�����֧��wenxuanzhen
	public static ReturnInfo send(Payinfor payinfor, PlatFormParam pfp)
			throws Exception {//2011
		try {
			String xmlString = "";
			ReturnInfo returnInfo = null;

				xmlString = XMLHandlerSYX.getPayinforXML(payinfor, pfp.getUserName(),
						pfp.getUserPwd());
			logger.debug("���͵��⸶XML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			logger.debug("ƽ̨���ص�XML(�⸶��[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			System.out.println("���ص����֧��XML��"+retXmlString);
			returnInfo = XMLHandlerSYX.getReturnFromXMLConsole(retXmlString,Iconstants.ZJRequstType.PAYINFOR_SYX);
			if(returnInfo.getClaimCode()==null||returnInfo.getClaimCode().trim().length()==0){
					returnInfo.setClaimCode(payinfor.getClaimCode());
			}
			return returnInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	//���������Ϣ
	public static ReturnInfo send(CompensateVeric compensateVeric, PlatFormParam pfp)
			throws Exception {//2011
		try {
			String xmlString = "";
			ReturnInfo returnInfo = null;
				xmlString = XMLHandlerSYX.getCompensateVericforXML(compensateVeric, pfp.getUserName(),
						pfp.getUserPwd());
			logger.debug("���͵��⸶XML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			logger.debug("ƽ̨���ص�XML(�⸶��[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			System.out.println("���ص����֧��XML��"+retXmlString);
			returnInfo = XMLHandlerSYX.getReturnFromXMLConsole(retXmlString,Iconstants.ZJRequstType.COMPENSATEVERIC_SYX);
			if(returnInfo.getClaimCode()==null||returnInfo.getClaimCode().trim().length()==0){
					returnInfo.setClaimCode(compensateVeric.getClaimCode());
			}
			return returnInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static ReturnAccountsInfo sendAccountNo(Accounts accounts, PlatFormParam pfp)//2011
	throws Exception {
		try {
			String xmlString = "";
			ReturnAccountsInfo returnInfo = null;
			
			xmlString = XMLHandlerSYX.getAccountNoXML(accounts, pfp.getUserName(), pfp.getUserPwd());
			
			logger.debug("���͵ı���XML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			//String retXmlString ="<?xml version='1.0' encoding='GBK'?><Packet type='RESPONSE' version='1.0'><Head><RequestType>V3205</RequestType><ResponseCode>1</ResponseCode><ErrorCode>0000</ErrorCode><ErrorMessage>�ɹ�</ErrorMessage></Head><Body><QueryResultData><RecoveryCode>V520126204421002152002</RecoveryCode><RecoveryCodeStatus>4</RecoveryCodeStatus><FailureTime>201206032012</FailureTime><FailureCause>1</FailureCause><RecoverStatus>1</RecoverStatus><CoverageType>1</CoverageType><ClaimNotificationNo>405063404212012000056</ClaimNotificationNo></QueryResultData></Body></Packet>";
			logger.debug("ƽ̨���ص�XML(������[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			System.out.println("���صı���XML��"+retXmlString);
				
			returnInfo = XMLHandlerSYX.getZJReturnAccountNoFromXML(retXmlString);
			if(returnInfo==null)System.out.println("returnInfoȷʵΪ��");
			return returnInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
