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
		// 禁止构造，直接调用静态方法即可
	}	
	
	// 报案 待维护
	public static ReturnInfo send(Regist regist, PlatFormParam pfp)//2011
			throws Exception {
		try {
			String xmlString = "";
			ReturnInfo returnInfo = null;
			
			xmlString = XMLHandlerSYX.getRegistXML(regist, pfp.getUserName(), pfp.getUserPwd());
			
			logger.debug("发送的报案XML：[字符串长度："+xmlString.length()+"]："+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			logger.debug("平台返回的XML(报案）[字符串长度："+retXmlString.length()+"]："+retXmlString);
			System.out.println("返回的报案XML："+retXmlString);
				
			returnInfo = XMLHandlerSYX.getReturnFromXMLConsole(retXmlString,Iconstants.ZJRequstType.REGIST_SYX);
			if(returnInfo==null)System.out.println("returnInfo确实为空");
			if(returnInfo.getClaimCode()==null||returnInfo.getClaimCode().trim().length()==0){
				returnInfo.setClaimCode(regist.getRegistNo());
			}

			return returnInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// 立案
	public static ReturnInfo send(Claim claim, PlatFormParam pfp)//2011
			throws Exception {
		try {
			String xmlString = "";
			ReturnInfo returnInfo = null;		
			xmlString = XMLHandlerSYX.getClaimXML(claim, pfp.getUserName(),
						pfp.getUserPwd());

			logger.debug("发送的立案XML：[字符串长度："+xmlString.length()+"]："+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			logger.debug("平台返回的XML(立案）[字符串长度："+retXmlString.length()+"]："+retXmlString);
			System.out.println("返回的立案XML："+retXmlString);				
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
	// 结案
	public static ReturnInfo send(EndCase endCase, PlatFormParam pfp)//2011
			throws Exception {
		try {
			String xmlString = "";
			ReturnInfo returnInfo = null;
		
				xmlString = XMLHandlerSYX.getEndCaseXML(endCase, pfp
						.getUserName(), pfp.getUserPwd());

			logger.debug("发送的结案XML：[字符串长度："+xmlString.length()+"]："+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			logger.debug("平台返回的XML(结案）[字符串长度："+retXmlString.length()+"]："+retXmlString);
			System.out.println("返回的结案XML："+retXmlString);
			
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

	// 案件注销
	public static ReturnInfo send(CancelCase cancelCase, PlatFormParam pfp)//2011
			throws Exception {
		try {
			String xmlString = "";
			ReturnInfo returnInfo = null;
			
				xmlString = XMLHandlerSYX.getCancelCaseXML(cancelCase, pfp
						.getUserName(), pfp.getUserPwd());

			logger.debug("发送的注销XML：[字符串长度："+xmlString.length()+"]："+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			logger.debug("平台返回的XML(注销）[字符串长度："+retXmlString.length()+"]："+retXmlString);
			System.out.println("返回的立案取消XML："+retXmlString);
			returnInfo = XMLHandlerSYX.getReturnFromXMLConsole(retXmlString,Iconstants.ZJRequstType.CANCEL_CASE);
			return returnInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// 追加结案
	public static ReturnInfo send(EndCaseAppend endCaseAppend, PlatFormParam pfp)//2011
			throws Exception {
		try {
			String xmlString = "";
			ReturnInfo returnInfo = null;
	
				xmlString = XMLHandlerSYX.getEndCaseAppendXML(endCaseAppend, pfp
						.getUserName(), pfp.getUserPwd());

			logger.debug("发送的结案追加XML：[字符串长度："+xmlString.length()+"]："+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			logger.debug("平台返回的XML(结案追加）[字符串长度："+retXmlString.length()+"]："+retXmlString);
			System.out.println("返回的结案追加XML："+retXmlString);
			returnInfo = XMLHandlerSYX.getReturnFromXMLConsole(retXmlString,Iconstants.ZJRequstType.ENDCASE_APPEND_SYX);
			return returnInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	//重开赔案
	public static ReturnInfo send(ReCase reCase, PlatFormParam  pfp)//2011
			throws Exception {
		try {
			String xmlString = "";
			ReturnInfo returnInfo = null;
	
				xmlString = XMLHandlerSYX.getReCaseXML(reCase, pfp
						.getUserName(), pfp.getUserPwd());

			logger.debug("发送的重开赔案XML：[字符串长度："+xmlString.length()+"]："+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			//String retXmlString="<?xml version='1.0' encoding='gb2312'?><PACKET type='RESPONSE' version='1.0'><Head><RequestType>V3111</RequestType><ResponseCode>1</ResponseCode><ErrorCode>0000</ErrorCode><ErrorMessage>成功</ErrorMessage></Head><Body><LockedData><RecoveryCode>V3101PICCCSN1234567890</RecoveryCode><RecoverStatus>1</RecoverStatus><InsurerCode>PICC</InsurerCode><InsurerArea>110000</InsurerArea><CoverageType>1</CoverageType><PolicyNo> V3101PICCCSN1234567890</PolicyNo><ClaimNotificationNo>V3101PICCCSN1234567890</ClaimNotificationNo><ClaimStatus>1</ClaimStatus><RecoveryCodeStatus>1</RecoveryCodeStatus></LockedData></Body></PACKET>";
			logger.debug("平台返回的XML(重开赔案）[字符串长度："+retXmlString.length()+"]："+retXmlString);
			System.out.println("返回的重开赔案XML："+retXmlString);
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
	//全国商业险赔款支付wenxuanzhen
	public static ReturnInfo send(Payinfor payinfor, PlatFormParam pfp)
			throws Exception {//2011
		try {
			String xmlString = "";
			ReturnInfo returnInfo = null;

				xmlString = XMLHandlerSYX.getPayinforXML(payinfor, pfp.getUserName(),
						pfp.getUserPwd());
			logger.debug("发送的赔付XML：[字符串长度："+xmlString.length()+"]："+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			logger.debug("平台返回的XML(赔付）[字符串长度："+retXmlString.length()+"]："+retXmlString);
			System.out.println("返回的赔款支付XML："+retXmlString);
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

	//理算核赔信息
	public static ReturnInfo send(CompensateVeric compensateVeric, PlatFormParam pfp)
			throws Exception {//2011
		try {
			String xmlString = "";
			ReturnInfo returnInfo = null;
				xmlString = XMLHandlerSYX.getCompensateVericforXML(compensateVeric, pfp.getUserName(),
						pfp.getUserPwd());
			logger.debug("发送的赔付XML：[字符串长度："+xmlString.length()+"]："+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			logger.debug("平台返回的XML(赔付）[字符串长度："+retXmlString.length()+"]："+retXmlString);
			System.out.println("返回的赔款支付XML："+retXmlString);
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
			
			logger.debug("发送的报案XML：[字符串长度："+xmlString.length()+"]："+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			//String retXmlString ="<?xml version='1.0' encoding='GBK'?><Packet type='RESPONSE' version='1.0'><Head><RequestType>V3205</RequestType><ResponseCode>1</ResponseCode><ErrorCode>0000</ErrorCode><ErrorMessage>成功</ErrorMessage></Head><Body><QueryResultData><RecoveryCode>V520126204421002152002</RecoveryCode><RecoveryCodeStatus>4</RecoveryCodeStatus><FailureTime>201206032012</FailureTime><FailureCause>1</FailureCause><RecoverStatus>1</RecoverStatus><CoverageType>1</CoverageType><ClaimNotificationNo>405063404212012000056</ClaimNotificationNo></QueryResultData></Body></Packet>";
			logger.debug("平台返回的XML(报案）[字符串长度："+retXmlString.length()+"]："+retXmlString);
			System.out.println("返回的报案XML："+retXmlString);
				
			returnInfo = XMLHandlerSYX.getZJReturnAccountNoFromXML(retXmlString);
			if(returnInfo==null)System.out.println("returnInfo确实为空");
			return returnInfo;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
