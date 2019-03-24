package com.sinosoft.claimciplatform.bl.action.custom;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.bz.client.HttpServletClient;
import com.sinosoft.ciplatform.dto.custom.Accounts;
import com.sinosoft.ciplatform.dto.custom.ReturnAccountsInfo;
import com.sinosoft.claimciplatform.dto.custom.CompensateVeric;
import com.sinosoft.ciplatform.dto.custom.ReCase;
import com.sinosoft.claimciplatform.dto.custom.CancelCase;
import com.sinosoft.claimciplatform.dto.custom.Claim;
import com.sinosoft.claimciplatform.dto.custom.ClaimCiPlatFormException;
import com.sinosoft.claimciplatform.dto.custom.CompelCrashArgDto;
import com.sinosoft.claimciplatform.dto.custom.CompelCrashDto;
import com.sinosoft.claimciplatform.dto.custom.CompensateVeric;
import com.sinosoft.claimciplatform.dto.custom.EndCase;
import com.sinosoft.claimciplatform.dto.custom.EndCaseAppend;
import com.sinosoft.claimciplatform.dto.custom.PayRefInfo;
import com.sinosoft.claimciplatform.dto.custom.PlatFormParam;
import com.sinosoft.claimciplatform.dto.custom.Regist;
import com.sinosoft.claimciplatform.dto.custom.ReturnInfo;

public class CIPlatFormInterface {
	private static Log logger = LogFactory.getLog(CIPlatFormInterface.class);
	private CIPlatFormInterface() {
		// ��ֹ���죬ֱ�ӵ��þ�̬��������
	}

	//���������¹���Ϣ�ϴ�
	public static ReturnInfo send(CompelCrashDto compelCrashDto,PlatFormParam pfp)
	       throws Exception{
		try{
			String xmlString =XMLHandler.getAccidentUploadInfoXML(compelCrashDto,pfp.getUserName(),pfp.getUserPwd());
			logger.debug("���͵ĳ��������¹���ϢXML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			logger.debug("ƽ̨���ص�XML(���������¹���Ϣ��[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			ReturnInfo returnInfo=XMLHandler.getAccidentBackInfo(retXmlString);
			return returnInfo;
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	//���������¹ʻ�д��Ϣ�ϴ�
	public static ReturnInfo send(CompelCrashArgDto compelCrashArg,PlatFormParam pfp)
	       throws Exception{
		try{
			String xmlString =XMLHandler.getAccidentBackWriteUploadInfo(compelCrashArg,pfp.getUserName(),pfp.getUserPwd());
			logger.debug("���͵ĳ��������¹ʻ�д��ϢXML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			String retXmlString = SysPlatForm.request(xmlString, pfp);
			logger.debug("ƽ̨���ص�XML(���������¹ʻ�д��Ϣ��[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			ReturnInfo returnInfo=XMLHandler.getAccidentBackWriteBackInfo(retXmlString);
			System.out.println("returnInfo==="+returnInfo.getRequestType());
			return returnInfo;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	// ����
	public static ReturnInfo send(Regist regist, PlatFormParam pfp)
			throws Exception {
		try {
			String xmlString = XMLHandler.getRegistXML(regist, pfp.getUserName(), pfp.getUserPwd());
			logger.debug("���͵ı���XML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			HttpServletClient httpServletClient = new HttpServletClient();
			String retXmlString = httpServletClient.send(xmlString, pfp.getComCode());
			logger.debug("ƽ̨���ص�XML(������[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			return XMLHandler.getReturnRegistFromXML(retXmlString);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// ����
	public static ReturnInfo send(Claim claim, PlatFormParam pfp)
			throws Exception {
		try {
			String xmlString = XMLHandler.getClaimXML(claim, pfp.getUserName(),
					pfp.getUserPwd());
			logger.debug("���͵�����XML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			HttpServletClient httpServletClient = new HttpServletClient();
			String retXmlString = httpServletClient.send(xmlString, pfp.getComCode());
			logger.debug("ƽ̨���ص�XML(������[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
     		return XMLHandler.getReturnClaimFromXML(retXmlString);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// �᰸
	public static ReturnInfo send(EndCase endCase, PlatFormParam pfp)
			throws Exception {
		try {
			String xmlString = XMLHandler.getEndCaseXML(endCase, pfp
					.getUserName(), pfp.getUserPwd());
			logger.debug("���͵Ľ᰸XML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			HttpServletClient httpServletClient = new HttpServletClient();
			String retXmlString = httpServletClient.send(xmlString, pfp.getComCode());
			logger.debug("ƽ̨���ص�XML(�᰸��[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			return XMLHandler.getReturnEndCaseFromXML(retXmlString);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// ȡ������
	public static ReturnInfo send(CancelCase cancelCase, PlatFormParam pfp)
			throws Exception {
		try {
			String xmlString = XMLHandler.getCancelCaseXML(cancelCase, pfp
					.getUserName(), pfp.getUserPwd());
			logger.debug("���͵�ע��XML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			HttpServletClient httpServletClient = new HttpServletClient();
			String retXmlString = httpServletClient.send(xmlString, pfp.getComCode());
			logger.debug("ƽ̨���ص�XML(ע����[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			return XMLHandler.getReturnCancelCaseFromXML(retXmlString);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// ׷�ӽ᰸
	public static ReturnInfo send(EndCaseAppend endCaseAppend, PlatFormParam pfp)
			throws Exception {
		try {
			String xmlString = XMLHandler.getEndCaseAppendXML(endCaseAppend,
					pfp.getUserName(), pfp.getUserPwd());
			logger.debug("���͵Ľ᰸׷��XML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			HttpServletClient httpServletClient = new HttpServletClient();
			String retXmlString = httpServletClient.send(xmlString, pfp.getComCode());
			logger.debug("ƽ̨���ص�XML(�᰸׷�ӣ�[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			return XMLHandler.getReturnEndCaseApendFromXML(retXmlString);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	// �������
	public static ReturnInfo send(CompensateVeric compensateVeric, PlatFormParam pfp)
			throws Exception {
		try {
			String xmlString = XMLHandler.getCompensateVericInfoXML(compensateVeric,
					pfp.getUserName(), pfp.getUserPwd());
			logger.debug("���͵Ľ᰸׷��XML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			HttpServletClient httpServletClient = new HttpServletClient();
			String retXmlString = httpServletClient.send(xmlString, pfp.getComCode());
			logger.debug("ƽ̨���ص�XML(�᰸׷�ӣ�[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			return XMLHandler.getReturnCompensateVericInfoFromXML(retXmlString);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	// ׷�ӽ᰸
	public static ReturnInfo send(PayRefInfo payRefInfo, PlatFormParam pfp)
			throws Exception {
		try {
			String xmlString = XMLHandler.getPayRefInfoXML(payRefInfo,
					pfp.getUserName(), pfp.getUserPwd());
			logger.debug("���͵Ľ᰸׷��XML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			HttpServletClient httpServletClient = new HttpServletClient();
			String retXmlString = httpServletClient.send(xmlString, pfp.getComCode());
			logger.debug("ƽ̨���ص�XML(�᰸׷�ӣ�[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			return XMLHandler.getReturnEndCaseApendFromXML(retXmlString);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	// �����ؿ�
	public static ReturnInfo send(ReCase reCase, PlatFormParam pfp)
			throws Exception {
		try {
			String xmlString = XMLHandler.getReCaseXML(reCase,
					pfp.getUserName(), pfp.getUserPwd());
			logger.debug("���͵Ľ᰸׷��XML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			HttpServletClient httpServletClient = new HttpServletClient();
			String retXmlString = httpServletClient.send(xmlString, pfp.getComCode());
			//String retXmlString ="<?xml version='1.0' encoding='GBK'?><PACKET type='RESPONSE' version='1.0'><HEAD><REQUEST_TYPE>5A</REQUEST_TYPE><RESPONSE_CODE>1</RESPONSE_CODE><ERROR_CODE>0000</ERROR_CODE><ERROR_MESSAGE>�ɹ�</ERROR_MESSAGE></HEAD><BODY><LOCKED_LIST><LOCKED_DATA><RECOVERY_CODE>301042009210000000027</RECOVERY_CODE><RECOVERY_CODE_STATUS>1</RECOVERY_CODE_STATUS><RECOVER_STATUS>1</RECOVER_STATUS><INSURER_CODE>AAIC</INSURER_CODE><INSURER_AREA>310000</INSURER_AREA><COVERAGE_TYPE>1</COVERAGE_TYPE><POLICY_NO>PDAA200611011204032567</POLICY_NO><REPORT_NO>RDAA200611011204438303</REPORT_NO><CLAIM_STATUS>1</CLAIM_STATUS></LOCKED_DATA></LOCKED_LIST></BODY></PACKET>";
			logger.debug("ƽ̨���ص�XML(�᰸׷�ӣ�[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			return XMLHandler.getReturnReCaseFromXML(retXmlString,reCase);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * ��ȡ������Ϣ
	 * @param e
	 * @return
	 * @throws Exception
	 */
	public static String getStackTraceMessage(Exception e)throws Exception{
		String message = "";
		StringBuffer strbufStackTrace = new StringBuffer("");
		StackTraceElement[] stackTrace = null;
        
        Throwable cause = e.getCause();
        if(cause == null){
        	stackTrace = e.getStackTrace();
        }else{
        	while(cause.getCause() != null){
            	cause = cause.getCause();
            }
        	stackTrace = cause.getStackTrace();
        }
        
        if(stackTrace!=null) {
        	if(cause == null){
            	strbufStackTrace.append("Caused by:" + e.getClass().getSimpleName().toString() + "\n");
        	}else{
            	strbufStackTrace.append("Caused by:" + cause.getClass().getSimpleName().toString() + "\n");
        	}
            for(int i=0;i<stackTrace.length;i++) {
                strbufStackTrace.append( "\t" + stackTrace[i].getFileName() + ":" + stackTrace[i].getLineNumber() + "\n");
            }
        }
        message = strbufStackTrace.toString();
		return message;
	}
	/**
	 * ��ȡ������Ϣ(html��)
	 * @param e
	 * @return
	 * @throws Exception
	 */
	public static String getStackTraceMessageForHTML(Exception e)throws Exception{
		String message = "";
		StringBuffer strbufStackTrace = new StringBuffer("");
		StackTraceElement[] stackTrace = null;
        
        Throwable cause = e.getCause();
        if(cause == null){
        	stackTrace = e.getStackTrace();
        }else{
        	while(cause.getCause() != null){
            	cause = cause.getCause();
            }
        	stackTrace = cause.getStackTrace();
        }
        
        if(stackTrace!=null) {
        	if(cause == null){
            	strbufStackTrace.append("Caused by:" + e.getClass().getSimpleName().toString() + "<br>");
        	}else{
            	strbufStackTrace.append("Caused by:" + cause.getClass().getSimpleName().toString() + "<br>");
        	}
            for(int i=0;i<stackTrace.length;i++) {
                strbufStackTrace.append( "&emsp;" + stackTrace[i].getFileName() + ":" + stackTrace[i].getLineNumber() + "<br>");
            }
        }
        message = strbufStackTrace.toString();
		return message;
	}
	public static void main(String[] args)throws Exception{
		
		try{
			try{
				try{
					String test = null;
					test.length();
				}catch(Exception e){
					throw new ClaimCiPlatFormException(e);
				}
				
			}catch(Exception e){
				
				throw new ClaimCiPlatFormException("����",e);
			}
			//Exception e = new Exception();
			//throw new ClaimCiPlatFormException("",e);
		}catch(ClaimCiPlatFormException e ){
			//OutputStream
			//PrintWriter
			e.printStackTrace();
			//System.err.println("22");
			System.out.println(CIPlatFormInterface.getStackTraceMessage(e));
		}
	}
	//�������ѯ
	public static ReturnAccountsInfo send(Accounts accounts, PlatFormParam pfp)
			throws Exception {
		try {
			String xmlString = XMLHandler.getAccountNoXML(accounts, pfp.getUserName(), pfp.getUserPwd());
			logger.debug("���͵ı���XML��[�ַ������ȣ�"+xmlString.length()+"]��"+xmlString);
			HttpServletClient httpServletClient = new HttpServletClient();
			String retXmlString = httpServletClient.send(xmlString, pfp.getComCode());
			//String retXmlString = "<?xml version='1.0' encoding='GBK'?><PACKET type='RESPONSE' version='1.0'><HEAD><REQUEST_TYPE>62</REQUEST_TYPE><RESPONSE_CODE>1</RESPONSE_CODE><ERROR_CODE>0000</ERROR_CODE><ERROR_MESSAGE>�ɹ�</ERROR_MESSAGE></HEAD><BODY><QUERY_RESULT_LIST><QUERY_RESULT_DATA><RECOVERY_CODE>RDAA200611011204438302</RECOVERY_CODE><RECOVERY_CODE_STATUS>5</RECOVERY_CODE_STATUS><FAILURE_TIME>201205060201</FAILURE_TIME><FAILURE_CAUSE>1</FAILURE_CAUSE><RECOVERY_STATUS>1</RECOVERY_STATUS><REPORT_NO>45433322124515122</REPORT_NO><COVERAGE_TYPE>1</COVERAGE_TYPE></QUERY_RESULT_DATA></QUERY_RESULT_LIST></BODY></PACKET>";
			logger.debug("ƽ̨���ص�XML(������[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			System.out.println("ƽ̨���ص�XML(������[�ַ������ȣ�"+retXmlString.length()+"]��"+retXmlString);
			return XMLHandler.getReturnAccountNoFromXML(retXmlString);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
