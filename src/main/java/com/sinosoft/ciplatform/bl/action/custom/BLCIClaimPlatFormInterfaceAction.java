package com.sinosoft.ciplatform.bl.action.custom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sinosoft.ciplatform.bl.action.domain.BLCIClaimDemandAction;
import com.sinosoft.ciplatform.bl.action.domain.BLCIClaimUploadLogAction;
import com.sinosoft.ciplatform.bl.action.domain.BLCIClaimUploadRegistAction;
import com.sinosoft.ciplatform.bl.action.domain.BLCIInsureValidAction;
import com.sinosoft.ciplatform.dto.custom.CancelCase;
import com.sinosoft.ciplatform.dto.custom.Claim;
import com.sinosoft.ciplatform.dto.custom.ClaimCiPlatFormException;
import com.sinosoft.ciplatform.dto.custom.CompensateVeric;
import com.sinosoft.ciplatform.dto.custom.EndCase;
import com.sinosoft.ciplatform.dto.custom.EndCaseAppend;
import com.sinosoft.ciplatform.dto.custom.Iconstants;
import com.sinosoft.ciplatform.dto.custom.Payinfor;
import com.sinosoft.ciplatform.dto.custom.PlatFormParam;
import com.sinosoft.ciplatform.dto.custom.ReCase;
import com.sinosoft.ciplatform.dto.custom.Regist;
import com.sinosoft.ciplatform.dto.custom.ReturnInfo;
import com.sinosoft.ciplatform.dto.domain.CIClaimDemandDto;
import com.sinosoft.ciplatform.dto.domain.CIClaimUploadLogDto;
import com.sinosoft.ciplatform.dto.domain.CIClaimUploadRegistDto;
import com.sinosoft.ciplatform.dto.domain.CIInsureValidDto;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.ciplatform.ui.action.UICIClaimDemandAction;
import com.sinosoft.ciplatform.util.UUID;
import com.sinosoft.claim.bl.action.domain.BLPrpLlocklogAction;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLlocklogDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCmain;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcompensate;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLlocklog;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * ƽ̨ע��action
 * <p>Title: �������� ƽ̨ע��acton</p>
 * <p>Description: �������� ƽ̨ע��acton</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Sinosoft</p>
 * @author miaowenjun
 * @version 1.0
 */ 
public abstract class BLCIClaimPlatFormInterfaceAction {
	/**
	 * ���ǿ�Ʊ���ƽ̨�ӿڵ�ʵ����
	 * �������ļ��е�ciplatform.implClassָ��ʵ���࣬��ʵ�������̳�BLCIClaimPlatFormInterfaceAction
	 * @return
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public final static BLCIClaimPlatFormInterfaceAction getInstance() throws ClassNotFoundException, Exception {
		BLCIClaimPlatFormInterfaceAction blCIClaimPlatFormInterfaceAction = null;
		System.out.println(AppConfig.get("sysconst.implClasssyx"));
		Class loaderClass = Class.forName(AppConfig.get("sysconst.implClasssyx"));
		blCIClaimPlatFormInterfaceAction = (BLCIClaimPlatFormInterfaceAction)loaderClass.newInstance();
		return blCIClaimPlatFormInterfaceAction;
	}
	/**
	 * ƽ̨���
	 * @param dbManager
	 * @param businessNo
	 * @param registType
	 * @param isImmediately
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClaimCiPlatFormException 
	 * @throws ClaimCiPlatFormException 
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClaimCiPlatFormException
	 */
	public final ClaimCiPlatFormException upload(DBManager dbManager, String uploadType, String businessNo, boolean isImmediately,CIPlatformConfigDto cIPlatformConfigDto,String uploadWay,String payRefNo) throws SQLException,Exception{
		CIClaimUploadRegistDto cIClaimUploadRegistDto = new CIClaimUploadRegistDto();
		System.out.println("---AAAAAAAAAAAAAAA-------businessNo-------------"+businessNo);
		cIClaimUploadRegistDto.setBusinessNo(businessNo);
		cIClaimUploadRegistDto.setRegistDate(new DateTime().current());
		cIClaimUploadRegistDto.setUploadType(uploadType);		
		cIClaimUploadRegistDto.setTriggerMode(isImmediately?"0":"1");
		cIClaimUploadRegistDto.setFailTimes(0);
		cIClaimUploadRegistDto.setPayRefNo(payRefNo);
		cIClaimUploadRegistDto.setUplaodWay(uploadWay);
		if(isImmediately){
			cIClaimUploadRegistDto.setUploadNo(null);
			return upload(dbManager,cIClaimUploadRegistDto,cIPlatformConfigDto);
			
		}else{
			cIClaimUploadRegistDto.setUploadNo(UUID.generate());
			new BLCIClaimUploadRegistAction().insert(dbManager, cIClaimUploadRegistDto);
		}
		
		
		return null;
	}
	/**
	 * ƽ̨���(�����ؿ�����)
	 * @param dbManager
	 * @param businessNo
	 * @param registType
	 * @param isImmediately
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClaimCiPlatFormException 
	 * @throws ClaimCiPlatFormException 
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClaimCiPlatFormException
	 */
	public final ClaimCiPlatFormException upload(DBManager dbManager, String uploadType, String businessNo,int serlalNo, boolean isImmediately,CIPlatformConfigDto cIPlatformConfigDto,String uploadWay,String payRefNo,String policyNo) throws SQLException,Exception{
		CIClaimUploadRegistDto cIClaimUploadRegistDto = new CIClaimUploadRegistDto();
		System.out.println("---AAAAAAAAAAAAAAA-------businessNo-------------"+businessNo);
		cIClaimUploadRegistDto.setBusinessNo(businessNo);
		cIClaimUploadRegistDto.setRegistDate(new DateTime().current());
		cIClaimUploadRegistDto.setUploadType(uploadType);		
		cIClaimUploadRegistDto.setTriggerMode(isImmediately?"0":"1");
		cIClaimUploadRegistDto.setFailTimes(0);
		cIClaimUploadRegistDto.setPayRefNo(payRefNo);
		cIClaimUploadRegistDto.setUplaodWay(uploadWay);
		cIClaimUploadRegistDto.setPolicyNo(policyNo);
		cIClaimUploadRegistDto.setSerlalNo(serlalNo);
		cIClaimUploadRegistDto.setUploadFlag("1");
		if(isImmediately){
			cIClaimUploadRegistDto.setUploadNo(null);
			return upload(dbManager,cIClaimUploadRegistDto,cIPlatformConfigDto);
			
		}else{
			cIClaimUploadRegistDto.setUploadNo(UUID.generate());
			new BLCIClaimUploadRegistAction().insert(dbManager, cIClaimUploadRegistDto);
		}
		
		
		return null;
	}
/*    *//**
     * ƽ̨���
     * @param dbManager
     * @param uploadType
     * @param compelCrashDto
     * @throws Exception 
     * @throws SQLException 
     * @throws ClaimCiPlatFormException 
     * @throws ClaimCiPlatFormException 
     * @throws Exception 
     * @throws SQLException 
     * @throws ClaimCiPlatFormException
     *//*
    public final ClaimCiPlatFormException uploadCompelCrashRecord(DBManager dbManager,String uploadType,CompelCrashDto compelCrashDto) throws SQLException,Exception{
        CIClaimUploadRegistDto cIClaimUploadRegistDto = new CIClaimUploadRegistDto();
        cIClaimUploadRegistDto.setRegistDate(new DateTime().current());
        cIClaimUploadRegistDto.setUploadType(uploadType);       
        cIClaimUploadRegistDto.setFailTimes(0);
        cIClaimUploadRegistDto.setUploadNo(null);
        return upload(dbManager,cIClaimUploadRegistDto,compelCrashDto);
    }*/
    
    //2011
	private ClaimCiPlatFormException upload(DBManager dbManager, CIClaimUploadRegistDto cIClaimUploadRegistDto,CIPlatformConfigDto cIPlatformConfigDto) throws SQLException,Exception{
		ReturnInfo returnInfo = null;
		try {
			returnInfo = transport(dbManager,cIClaimUploadRegistDto,cIPlatformConfigDto);
			if(returnInfo!=null && returnInfo.getErrorMessage().indexOf("��ҵ�ձ���ƽ̨����׼�����ϴ�ʧ��!")>0){//δ����
				return new ClaimCiPlatFormException(returnInfo.getErrorMessage());
			}else if(returnInfo!=null && "0".equals(returnInfo.getReturnType())){//�����ˣ���������ƽ̨Ҫ������
				return new ClaimCiPlatFormException("��ҵ�ձ���ƽ̨����ʧ�ܣ�ԭ�����£�"+returnInfo.getErrorMessage());
			}else if(returnInfo!=null){
				return null;
			}
			else{
				return new ClaimCiPlatFormException("��ҵ�ϴ�ʧ��!");//��������²�����
			}
		} catch (Exception e) {
			
		}finally{
		}
		return null;
	}
		
	
	//2011,���������ϴ��ʹ�����ʷ�����ϴ�ͳһ���ýӿ�
	/**
	 * ʵʱע��,�����ݴ���ƽ̨
	 * @param dbManager
	 * @param businessNo
	 * @param registType
	 * @throws ClaimCiPlatFormException 
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws SQLException
	 * @throws Exception
	 */
	public ReturnInfo transport(DBManager dbManager,CIClaimUploadRegistDto ciClaimUploadRegistDto,CIPlatformConfigDto cIPlatformConfigDto) throws Exception,SQLException {
		ReturnInfo returnInfo = null;
        ReCase reCase=null;
		String registType=ciClaimUploadRegistDto.getUploadType();
		String businessNo = ciClaimUploadRegistDto.getBusinessNo();
		String payRefNo=ciClaimUploadRegistDto.getPayRefNo();
		String uploadWay=ciClaimUploadRegistDto.getUplaodWay();
		String uploadFlag=ciClaimUploadRegistDto.getUploadFlag();
		String uploadNo = null;
		System.out.println("===========registType===2011======="+registType);
		if(ciClaimUploadRegistDto.getUploadNo()==null||ciClaimUploadRegistDto.getUploadNo().trim().length()==0){
			uploadNo = null;
			if(ciClaimUploadRegistDto!=null){
				ciClaimUploadRegistDto.setUploadNo(UUID.generate());
			}
		}else{
			uploadNo = ciClaimUploadRegistDto.getUploadNo();
		}
		String claimCode="";
		try
		{
			PlatFormParam platFormParam =new PlatFormParam();
			platFormParam.setUrl(cIPlatformConfigDto.getUrl());
			platFormParam.setUserName(cIPlatformConfigDto.getUserName());
			platFormParam.setUserPwd(cIPlatformConfigDto.getPwd());
			
			if(Iconstants.ZJRequstType.REGIST_SYX.equals(registType)){  //����
				Regist regist = getRegist(dbManager, businessNo,registType);
				regist.setClaimCode(getClaimCode(dbManager, registType,regist.getRegistNo(), regist.getClaimNo()));
				regist.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, regist.getPolicyNO()));
				returnInfo = CIPlatFormInterface.send(regist, platFormParam);
				returnInfo.setPolicyNo(regist.getPolicyNO());
			}else if(Iconstants.ZJRequstType.CLAIM_SYX.equals(registType)){  //����
				Claim claim = getClaim(dbManager, businessNo,registType);
				claim.setClaimCode(getClaimCode(dbManager, registType,claim.getRegistNo(), claim.getClaimNo()));
				claim.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, claim.getPolicyNO()));
				returnInfo = CIPlatFormInterface.send(claim, platFormParam);
				returnInfo.setPolicyNo(claim.getPolicyNO());
			}
			else if(Iconstants.ZJRequstType.ENDCASE_SYX.equals(registType)){  //�᰸
				EndCase endCase = getEndCase(dbManager, businessNo);
				endCase.setClaimCode(getClaimCode(dbManager, registType,endCase.getRegistNo(), endCase.getClaimNo()));
				endCase.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, endCase.getPolicyNo()));
				returnInfo = CIPlatFormInterface.send(endCase, platFormParam);
				returnInfo.setPolicyNo(endCase.getPolicyNo());
			}else if(Iconstants.ZJRequstType.RECASE_SYX.equals(registType)){  //�᰸׷��  �ؿ��ⰸ
//				EndCaseAppend endCaseAppend = getEndCaseAppend(dbManager, businessNo);
//				endCaseAppend.setClaimCode(getClaimCode(dbManager, registType,endCaseAppend.getRegistNo(), endCaseAppend.getClaimNo()));		
//				returnInfo = CIPlatFormInterface.send(endCaseAppend, platFormParam);
				if(null!=uploadFlag&&"1".equals(uploadFlag)){
					reCase = getReCase(dbManager, businessNo,ciClaimUploadRegistDto.getSerlalNo());	
				}else{
				    reCase = getReCase(dbManager, businessNo);
				}
				claimCode=getClaimCode(dbManager, registType, reCase.getRegistNo(), reCase.getClaimNo());
				reCase.setClaimCode(claimCode);
				reCase.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, reCase.getPolicyNo()));
				returnInfo = CIPlatFormInterface.send(reCase, platFormParam);
				if(null!=uploadFlag&&"1".equals(uploadFlag)){
					returnInfo.setSelralNo(ciClaimUploadRegistDto.getSerlalNo());
					returnInfo.setUploadFlag("1");
				}else{
				    returnInfo.setUploadFlag("");
				}
				returnInfo.setPolicyNo(reCase.getPolicyNo());//�¼�
			}
			else if (Iconstants.ZJRequstType.CANCEL_CASE.equals(registType)){//ע��
				CancelCase cancelCase = getCancelCaseZJ(dbManager, businessNo);
				cancelCase.setClaimCode(getClaimCode(dbManager, registType,cancelCase.getRegistNo(), cancelCase.getClaimNo()));
				String confirmSequenceNo = getConfirmSequenceNoFromNotify(dbManager,cancelCase.getRegistNo());
				if("".equals(confirmSequenceNo) || confirmSequenceNo == null){
					cancelCase.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, cancelCase.getPolicyNO()));
				}else{
					cancelCase.setConfirmSequenceNo(confirmSequenceNo);
				}
				returnInfo = CIPlatFormInterface.send(cancelCase, platFormParam);
				returnInfo.setPolicyNo(cancelCase.getPolicyNO());
            }
			else if(Iconstants.ZJRequstType.PAYINFOR_SYX.equals(registType)){  //�⸶�Ǽ�
				Payinfor payinfor = getPayinfor(dbManager, businessNo,registType,payRefNo);
				payinfor.setClaimCode(getClaimCode(dbManager, registType,"", payinfor.getClaimNo()));
				payinfor.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, payinfor.getPolicyNo()));
				returnInfo = CIPlatFormInterface.send(payinfor, platFormParam);
				returnInfo.setCompensateNos(payinfor.getCompensateNos());
				returnInfo.setUploadSerialNo(payinfor.getSerialNo());
				returnInfo.setPreCompensateNos(payinfor.getPreCompensateNos());
				for(Iterator itr = returnInfo.getLocked().iterator();itr.hasNext();){
					PrpLlocklogDto prpLlocklogDto = (PrpLlocklogDto)itr.next();
					prpLlocklogDto.setRegistNo(payinfor.getRegistNo());
				}
				returnInfo.setPreCompensateNos(payinfor.getPreCompensateNos()); 
				returnInfo.setPolicyNo(payinfor.getPolicyNo());
			}else if(Iconstants.ZJRequstType.COMPENSATEVERIC_SYX.equals(registType)){//����
				CompensateVeric compensateVeric = getCompensateVeric(dbManager,registType,businessNo);
				claimCode = getClaimCode(dbManager, registType,compensateVeric.getRegistNo(),compensateVeric.getClaimNo());
				if("".equals(claimCode)){
					throw new Exception("��ҵ��������벻����!!!");
				}else{
					compensateVeric.setClaimCode(claimCode);
				}
				compensateVeric.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, compensateVeric.getPolicyNo()));
				returnInfo = CIPlatFormInterface.send(compensateVeric, platFormParam);
				returnInfo.setCompensateNos(compensateVeric.getCompensateNo());
				returnInfo.setUploadSerialNo("1");
				returnInfo.setPolicyNo(compensateVeric.getPolicyNo());
			}
		}catch(Exception ex){
			returnInfo = new ReturnInfo();
			returnInfo.setReturnType("E"); 
			returnInfo.setErrorMessage("��ҵ�ձ���ƽ̨����׼�����ϴ�ʧ��!"+ex.getMessage());
			//throw ex;
		}
		finally
		{
			if(returnInfo!=null&&Iconstants.ReturnType.SUCCESS.equals(returnInfo.getReturnType()))
			{
				//���ƽ̨�����˳ɹ��ı�־���򱣴�˴γɹ�
				saveReturnInfo(dbManager, returnInfo, ciClaimUploadRegistDto.getBusinessNo());
				if(uploadNo!=null){
					//˵��ע������и��ϴ���Ϣ
					new BLCIClaimUploadRegistAction().delete(dbManager, ciClaimUploadRegistDto.getUploadNo());
				}
			}
			else
			{		
				ciClaimUploadRegistDto.setFailTimes(ciClaimUploadRegistDto.getFailTimes()+1);
				if(uploadNo==null){
					//˵��ע������޸���Ϣ����Ҫ��Ӹ�ע���¼
					new BLCIClaimUploadRegistAction().insert(dbManager, ciClaimUploadRegistDto);
				}else{
					//˵����ע������д˼�¼����Ҫ���¸�ע����Ϣ
					new BLCIClaimUploadRegistAction().update(dbManager, ciClaimUploadRegistDto);
				}
				
				
			}
			//���۳ɹ�ʧ�ܣ���Ҫ������Ӧ����־��¼
            saveRegistLog(dbManager,returnInfo,ciClaimUploadRegistDto.getBusinessNo(),true,ciClaimUploadRegistDto.getUploadNo(),uploadWay);
			return returnInfo;
	    }
	}
/*	*//**
	 * ʵʱע��,�����ݴ���ƽ̨
	 * @param dbManager
	 * @param businessNo
	 * @param registType
	 * @throws ClaimCiPlatFormException 
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws SQLException
	 * @throws Exception
	 *//*
	private ReturnInfo transport(DBManager dbManager, String registType, String businessNo,CompelCrashDto compelCrashDto,CompelCrashArgDto compelCrashArg) throws ClaimCiPlatFormException {
		try{
			ReturnInfo returnInfo = null;
			System.out.println("=======registType========="+registType);
			if(Iconstants.ZJRequstType.REGIST_SYX.equals(registType)){  //����
				
				Regist regist = getRegist(dbManager, businessNo,registType);				
				regist.setClaimCode(getClaimCode(dbManager, registType,regist.getRegistNo(), regist.getClaimNo()));
				regist.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, regist.getPolicyNO()));
				PlatFormParam platFormParam = getPlatFormParam(dbManager,regist.getPolicyNO());
				platFormParam.setCIflag(false);
				returnInfo = CIPlatFormInterface.send(regist, platFormParam);
			}else if(Iconstants.ZJRequstType.CLAIM_SYX.equals(registType)){  //����
				Claim claim = getClaim(dbManager, businessNo,registType);
				claim.setClaimCode(getClaimCode(dbManager, registType,claim.getRegistNo(), claim.getClaimNo()));
				claim.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, claim.getPolicyNO()));
				PlatFormParam platFormParam = getPlatFormParam(dbManager,claim.getPolicyNO());
				platFormParam.setCIflag(false);
				returnInfo = CIPlatFormInterface.send(claim, platFormParam);
			}else if(Iconstants.ZJRequstType.COMPENSATE_SYX.equals(registType)){  //����
				Compensate compensate = getCompensate(dbManager, businessNo,registType);
				compensate.setClaimCode(getClaimCode(dbManager, registType,compensate.getRegistNo(), compensate.getClaimNo()));
				compensate.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, compensate.getPolicyNo()));
				PlatFormParam platFormParam = getPlatFormParam(dbManager,compensate.getPolicyNo());
				platFormParam.setComcode(compensate.getComCode());
					platFormParam.setCIflag(false);
				returnInfo = CIPlatFormInterface.send(compensate, platFormParam);
			}else if(Iconstants.RequstType.CANCEL_CLAIM_CASE.equals(registType)||Iconstants.RequstType.CANCEL_CLAIMSYX_CASE.equals(registType)){  //����ע��
				CancelCase cancelCase = getCancelClaimCase(dbManager, businessNo);
				cancelCase.setClaimCode(getClaimCode(dbManager, registType,cancelCase.getRegistNo(), cancelCase.getClaimNo()));
				cancelCase.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, cancelCase.getPolicyNO()));
				PlatFormParam platFormParam = getPlatFormParam(dbManager,cancelCase.getPolicyNO());
				platFormParam.setComcode(cancelCase.getComCode()); 

					platFormParam.setCIflag(false);

				returnInfo = CIPlatFormInterface.send(cancelCase, platFormParam);
			}else if(Iconstants.RequstType.CANCEL_REGIST_CASE.equals(registType)||Iconstants.RequstType.CANCEL_REGISTSYX_CASE.equals(registType)){  //����ע��
				CancelCase cancelCase = getCancelRegistCase(dbManager, businessNo,registType);
				cancelCase.setClaimCode(getClaimCode(dbManager, registType,cancelCase.getRegistNo(), cancelCase.getClaimNo()));
				cancelCase.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, cancelCase.getPolicyNO()));
				PlatFormParam platFormParam = getPlatFormParam(dbManager,cancelCase.getPolicyNO());
				platFormParam.setComcode(cancelCase.getComCode());

					platFormParam.setCIflag(false);

				returnInfo = CIPlatFormInterface.send(cancelCase, platFormParam);
			}else if(Iconstants.RequstType.CERTIFY.equals(registType)||Iconstants.RequstType.CERTIFY_SYX.equals(registType)){  //��֤
				Certify certify = getCertify(dbManager, businessNo);
				certify.setClaimCode(getClaimCode(dbManager, registType,certify.getRegistNo(), certify.getClaimNo()));
				PlatFormParam platFormParam = getPlatFormParam(dbManager,certify.getPolicyNO());
				platFormParam.setComcode(certify.getComCode());

					platFormParam.setCIflag(false);

				returnInfo = CIPlatFormInterface.send(certify, platFormParam);
			}else if(Iconstants.ZJRequstType.ENDCASE_SYX.equals(registType)){  //�᰸
				EndCase endCase = getEndCase(dbManager, businessNo);
				endCase.setClaimCode(getClaimCode(dbManager, registType,endCase.getRegistNo(), endCase.getClaimNo()));
				endCase.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, endCase.getPolicyNo()));				
				PlatFormParam platFormParam = getPlatFormParam(dbManager,endCase.getPolicyNO());
				platFormParam.setComcode(endCase.getComCode());

					platFormParam.setCIflag(false);

				returnInfo = CIPlatFormInterface.send(endCase, platFormParam);
			}

			else if(Iconstants.ZJRequstType.PAYINFOR_SYX.equals(registType)){  //����
				Payinfor payinfor = getPayinfor(dbManager, businessNo,registType);
				payinfor.setClaimCode(getClaimCode(dbManager, registType,payinfor.getRegistNo(), payinfor.getClaimNo()));
				payinfor.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, payinfor.getPolicyNo()));
				PlatFormParam platFormParam = getPlatFormParam(dbManager,payinfor.getPolicyNo());
				platFormParam.setComcode(payinfor.getComCode());

					platFormParam.setCIflag(false);

				returnInfo = CIPlatFormInterface.send(payinfor, platFormParam);
			}else if(Iconstants.ZJRequstType.ENDCASE_APPEND_SYX.equals(registType)){  //�᰸׷��
				EndCaseAppend endCaseAppend = getEndCaseAppend(dbManager, businessNo);
				endCaseAppend.setClaimCode(getClaimCode(dbManager, registType,endCaseAppend.getRegistNo(), endCaseAppend.getClaimNo()));		
				PlatFormParam platFormParam = getPlatFormParam(dbManager,endCaseAppend.getPolicyNO());
				platFormParam.setComcode(endCaseAppend.getComCode());

					platFormParam.setCIflag(false);

				returnInfo = CIPlatFormInterface.send(endCaseAppend, platFormParam);
			}else if (Iconstants.RequstType.COMPELCRASH_UPLOAD.equals(registType)){    //�¹���Ϣ�ϴ�
                PlatFormParam platFormParam = getPlatFormParam(dbManager,compelCrashDto.getCompePlatFormRetrunParam().getCiPlatFormCode());
                returnInfo = CIPlatFormInterface.send(compelCrashDto, platFormParam);
           
            }else if (Iconstants.RequstType.COMPELCRASH_DOWNLOAD.equals(registType)){   //�¹���Ϣ��д
            	 
            	PlatFormParam platFormParam = getPlatFormParam(dbManager,compelCrashArg.getCiPlatFormCode());
            	returnInfo=CIPlatFormInterface.send(compelCrashArg, platFormParam);
            }else if (Iconstants.ZJRequstType.CANCEL_CASE.equals(registType)){//�㽭��ҵ��ע��
				CancelCase cancelCase = getCancelCaseZJ(dbManager, businessNo);
				cancelCase.setClaimCode(getClaimCode(dbManager, registType,cancelCase.getRegistNo(), cancelCase.getClaimNo()));
				cancelCase.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, cancelCase.getPolicyNO()));
				PlatFormParam platFormParam = getPlatFormParam(dbManager,cancelCase.getPolicyNO());
				platFormParam.setComcode(cancelCase.getComCode()); 

					platFormParam.setCIflag(false);

				returnInfo = CIPlatFormInterface.send(cancelCase, platFormParam);
            }
			return returnInfo;
		}catch(Exception e){
			e.printStackTrace();
			throw new ClaimCiPlatFormException("ǿ�Ʊ���ƽ̨����׼�����ϴ�ʧ��",e); 
		}
	}*/
	
	/**
	 * ��ʷ�����ϴ�,�����ݴ���ƽ̨
	 * @param dbManager
	 * @param businessNo
	 * @param registType
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws SQLException
	 * @throws Exception
	 *//*
	public ReturnInfo transportHistorData(DBManager dbManager, String registType, CIClaimUploadRegistDto ciClaimUploadRegistDto) throws SQLException, Exception {
		ReturnInfo returnInfo = null;
		String businessNo = ciClaimUploadRegistDto.getBusinessNo();
		String uploadNo = null;
		System.out.println("=====transportHistorData=======registType=========="+registType);
		if(ciClaimUploadRegistDto.getUploadNo()==null||ciClaimUploadRegistDto.getUploadNo().trim().length()==0){
			uploadNo = null;
			if(ciClaimUploadRegistDto!=null){
				ciClaimUploadRegistDto.setUploadNo(UUID.generate());
			}
			
		}else{
			uploadNo = ciClaimUploadRegistDto.getUploadNo();
		}
		try
		{
			if(Iconstants.RequstType.REGIST.equals(registType)||Iconstants.RequstType.REGIST_SYX.equals(registType)||Iconstants.ZJRequstType.REGIST_SYX.equals(registType)){  //����
				Regist regist = getRegist(dbManager, businessNo,registType);
				regist.setClaimCode(getClaimCode(dbManager, registType,regist.getRegistNo(), regist.getClaimNo()));
				regist.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, regist.getPolicyNO()));
				PlatFormParam platFormParam = getPlatFormParam(dbManager,regist.getPolicyNO());
				platFormParam.setComcode(regist.getComCode());
				if(Iconstants.RequstType.REGIST.equals(registType)){
					platFormParam.setCIflag(true);
				}else{
					platFormParam.setCIflag(false);
				}
				returnInfo = CIPlatFormInterface.send(regist, platFormParam);			
			}else if(Iconstants.RequstType.CLAIM.equals(registType)||Iconstants.RequstType.CLAIM_SYX.equals(registType)||Iconstants.ZJRequstType.CLAIM_SYX.equals(registType)){  //����
				Claim claim = getClaim(dbManager, businessNo,registType);
				claim.setClaimCode(getClaimCode(dbManager, registType,claim.getRegistNo(), claim.getClaimNo()));
				claim.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, claim.getPolicyNO()));
				PlatFormParam platFormParam = getPlatFormParam(dbManager,claim.getPolicyNO());
				platFormParam.setComcode(claim.getComCode());
				if(Iconstants.RequstType.CLAIM.equals(registType)){
					platFormParam.setCIflag(true);
				}else{
					platFormParam.setCIflag(false);
				}
				returnInfo = CIPlatFormInterface.send(claim, platFormParam);
			}else if(Iconstants.RequstType.COMPENSATE.equals(registType)||Iconstants.RequstType.COMPENSATE_SYX.equals(registType)||Iconstants.ZJRequstType.COMPENSATE_SYX.equals(registType)){  //����
				Compensate compensate = getCompensate(dbManager, businessNo,registType);
				compensate.setClaimCode(getClaimCode(dbManager, registType,compensate.getRegistNo(), compensate.getClaimNo()));
				compensate.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, compensate.getPolicyNo()));
				PlatFormParam platFormParam = getPlatFormParam(dbManager,compensate.getPolicyNo());
				platFormParam.setComcode(compensate.getComCode());
				if(Iconstants.RequstType.COMPENSATE.equals(registType)){
					platFormParam.setCIflag(true);
				}else{
					platFormParam.setCIflag(false);
				}
				returnInfo = CIPlatFormInterface.send(compensate, platFormParam);
			}else if(Iconstants.RequstType.CANCEL_CLAIM_CASE.equals(registType)||Iconstants.RequstType.CANCEL_CLAIMSYX_CASE.equals(registType)){ //����ע��
				CancelCase cancelCase = getCancelClaimCase(dbManager, businessNo);
				cancelCase.setClaimCode(getClaimCode(dbManager, registType,cancelCase.getRegistNo(), cancelCase.getClaimNo()));
				PlatFormParam platFormParam = getPlatFormParam(dbManager,cancelCase.getPolicyNO());
				platFormParam.setComcode(cancelCase.getComCode());
				if(Iconstants.RequstType.CANCEL_CLAIM_CASE.equals(registType)){
					platFormParam.setCIflag(true);
				}else{
					platFormParam.setCIflag(false);
				}
				returnInfo = CIPlatFormInterface.send(cancelCase, platFormParam);
			}else if(Iconstants.RequstType.CANCEL_REGIST_CASE.equals(registType)||Iconstants.RequstType.CANCEL_REGISTSYX_CASE.equals(registType)){  //����ע��
				System.out.println("========11111========");
				CancelCase cancelCase = getCancelRegistCase(dbManager, businessNo, registType);
				System.out.println("========22222========");
				cancelCase.setClaimCode(getClaimCode(dbManager, registType,cancelCase.getRegistNo(), cancelCase.getClaimNo()));
				System.out.println("========33333========");
				PlatFormParam platFormParam = getPlatFormParam(dbManager,cancelCase.getPolicyNO());
				System.out.println("========44444========");
				platFormParam.setComcode(cancelCase.getComCode());
				System.out.println("========55555========");
				if(Iconstants.RequstType.CANCEL_REGIST_CASE.equals(registType)){
					platFormParam.setCIflag(true);
				}else{
					platFormParam.setCIflag(false);
				}
				returnInfo = CIPlatFormInterface.send(cancelCase, platFormParam);
			}else if(Iconstants.RequstType.ENDCASE.equals(registType)||Iconstants.RequstType.ENDCASE_SYX.equals(registType)||Iconstants.ZJRequstType.ENDCASE_SYX.equals(registType)){  //�᰸
				EndCase endCase = getEndCase(dbManager, businessNo);
				endCase.setClaimCode(getClaimCode(dbManager, registType,endCase.getRegistNo(), endCase.getClaimNo()));
				endCase.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, endCase.getPolicyNo()));
				PlatFormParam platFormParam = getPlatFormParam(dbManager,endCase.getPolicyNO());
				platFormParam.setComcode(endCase.getComCode());
				if(Iconstants.RequstType.ENDCASE.equals(registType)){
					platFormParam.setCIflag(true);
				}else{
					platFormParam.setCIflag(false);
				}
				returnInfo = CIPlatFormInterface.send(endCase, platFormParam);
			}else if(Iconstants.RequstType.ENDCASE_APPEND.equals(registType)||Iconstants.RequstType.ENDCASE_APPEND_SYX.equals(registType)||Iconstants.ZJRequstType.ENDCASE_APPEND_SYX.equals(registType)){  //�᰸׷��
				EndCaseAppend endCaseAppend = getEndCaseAppend(dbManager, businessNo);
				endCaseAppend.setClaimCode(getClaimCode(dbManager, registType,endCaseAppend.getRegistNo(), endCaseAppend.getClaimNo()));		
				PlatFormParam platFormParam = getPlatFormParam(dbManager,endCaseAppend.getPolicyNO());
				platFormParam.setComcode(endCaseAppend.getComCode());
				if(Iconstants.RequstType.ENDCASE_APPEND.equals(registType)){
					platFormParam.setCIflag(true);
				}else{
					platFormParam.setCIflag(false);
				}
				returnInfo = CIPlatFormInterface.send(endCaseAppend, platFormParam);
			}else if(Iconstants.RequstType.REPCANCEL_REGIST_CASE.equals(registType)){  //��ǿ�ظ�ע��
				CancelCase cancelCase = new CancelCase();
				cancelCase.setClaimCode(businessNo);
				PlatFormParam platFormParam = getPlatFormParam(dbManager,"BJ");
				platFormParam.setComcode("2110000000");
				if(Iconstants.RequstType.REPCANCEL_REGIST_CASE.equals(registType)){
					platFormParam.setCIflag(true);
				}else{
					platFormParam.setCIflag(false);
				}
				returnInfo = CIPlatFormInterface.send(cancelCase, platFormParam);
			}else if (Iconstants.ZJRequstType.CANCEL_CASE.equals(registType)){//�㽭��ҵ��ע��
				CancelCase cancelCase = getCancelCaseZJ(dbManager, businessNo);
				cancelCase.setClaimCode(getClaimCode(dbManager, registType,cancelCase.getRegistNo(), cancelCase.getClaimNo()));
				cancelCase.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, cancelCase.getPolicyNO()));
				PlatFormParam platFormParam = getPlatFormParam(dbManager,cancelCase.getPolicyNO());
				platFormParam.setComcode(cancelCase.getComCode()); 
				if(Iconstants.RequstType.CANCEL_CLAIM_CASE.equals(registType)){
					platFormParam.setCIflag(true);
				}else{
					platFormParam.setCIflag(false);
				}
				returnInfo = CIPlatFormInterface.send(cancelCase, platFormParam);
            }
		}
		catch(Exception e)
		{
			returnInfo = new ReturnInfo();
			returnInfo.setReturnType("E");
			returnInfo.setErrorMessage("ǿ�Ʊ���ƽ̨����׼�����ϴ�ʧ��!"+e.getMessage());
		}
		finally
		{
			if(Iconstants.RequstType.REPCANCEL_REGIST_CASE.equals(registType)){
				return returnInfo;
			}
			System.out.println("====������������=====REPCANCEL_REGIST_CASE============"+registType);
			if(returnInfo!=null&&Iconstants.ReturnType.SUCCESS.equals(returnInfo.getReturnType()))
			{
				//���ƽ̨�����˳ɹ��ı�־���򱣴�˴γɹ�
				saveReturnInfo(dbManager, returnInfo, ciClaimUploadRegistDto.getBusinessNo());
				if(uploadNo!=null){
					//˵��ע������и��ϴ���Ϣ
					new BLCIClaimUploadRegistAction().delete(dbManager, ciClaimUploadRegistDto.getUploadNo());
				}
			}
			else
			{		
				ciClaimUploadRegistDto.setFailTimes(ciClaimUploadRegistDto.getFailTimes()+1);
				if(uploadNo==null){
					//˵��ע������޸���Ϣ����Ҫ��Ӹ�ע���¼
					new BLCIClaimUploadRegistAction().insert(dbManager, ciClaimUploadRegistDto);
				}else{
					//˵����ע������д˼�¼����Ҫ���¸�ע����Ϣ
					new BLCIClaimUploadRegistAction().update(dbManager, ciClaimUploadRegistDto);
				}
				
				
			}
			//���۳ɹ�ʧ�ܣ���Ҫ������Ӧ����־��¼
            saveRegistLog(dbManager,returnInfo,ciClaimUploadRegistDto.getBusinessNo(),true,ciClaimUploadRegistDto.getUploadNo());
			return returnInfo;
	    }
	}*/
	private void saveRegistLog(DBManager dbManager, ReturnInfo returnInfo, String businessNo, boolean isImmediately, String uploadNo,String uploadWay) throws Exception{
		List ciClaimUploadLogList = (List)new BLCIClaimUploadLogAction().findByConditions(dbManager, "uploadno='"+uploadNo+"' order by serialno desc");
		int serialNo = 1;
		if(ciClaimUploadLogList != null && ciClaimUploadLogList.size()>0){
			serialNo = ((CIClaimUploadLogDto)ciClaimUploadLogList.get(0)).getSerialNo()+1;
		}
		CIClaimUploadLogDto ciClaimUploadLog = new CIClaimUploadLogDto();
		/*ciClaimUploadLog.setBusinessNo(businessNo);
		if(returnInfo!=null&&Iconstants.ReturnType.SUCCESS.equals(returnInfo.getReturnType())){
			ciClaimUploadLog.setFlag(1);
		}else{
			if(returnInfo==null){
				ciClaimUploadLog.setFailReson("������Ϣʧ�ܻ�ƽ̨δ������Ϣ");
			}else{
				ciClaimUploadLog.setFailReson(returnInfo.getErrorMessage());
			}
			ciClaimUploadLog.setFlag(0);
		}
		ciClaimUploadLog.setReturnContext("");
		ciClaimUploadLog.setSendContext("");
		ciClaimUploadLog.setSerialNo(serialNo);
		if(isImmediately){
			ciClaimUploadLog.setTriggerMode("0");
		}else{
			ciClaimUploadLog.setTriggerMode("1");
		}
		ciClaimUploadLog.setUploadNo(uploadNo);
		ciClaimUploadLog.setUploadDate(new DateTime().current());
		if(returnInfo!=null){
			ciClaimUploadLog.setUploadType(returnInfo.getRequestType());
			ciClaimUploadLog.setClaimCode(returnInfo.getClaimCode());
			if(returnInfo.getReturnType()!=null && (returnInfo.getRequestType()==null || returnInfo.getRequestType().equals(""))){
				ciClaimUploadLog.setClaimCode(returnInfo.getClaimCode());
			}
		}*/


		
		//2011
		ciClaimUploadLog.setUploadNo(uploadNo);
		ciClaimUploadLog.setBusinessNo(businessNo);
		if(returnInfo == null){
			returnInfo = new ReturnInfo();
		}
		
		if(returnInfo!=null&&Iconstants.ReturnType.SUCCESS.equals(returnInfo.getReturnType())){
			ciClaimUploadLog.setFlag(1);
		}else{			
			ciClaimUploadLog.setFlag(0);
		}
		ciClaimUploadLog.setErrorCode(returnInfo.getErrorCode());
		ciClaimUploadLog.setErrorname(returnInfo.getErrorMessage());
		ciClaimUploadLog.setSerialNo(serialNo);
		ciClaimUploadLog.setUploadDate(new DateTime().current());
		ciClaimUploadLog.setUploadWay(uploadWay);//2011�ϴ���ʽ��0-ϵͳ��1-�ֶ�
		if(returnInfo!=null){
			ciClaimUploadLog.setUploadType(returnInfo.getRequestType());
			ciClaimUploadLog.setClaimCode(returnInfo.getClaimCode());
		}
		new BLCIClaimUploadLogAction().insert(dbManager, ciClaimUploadLog);
	}
	

	
	/**
	 * ��ȡ�������
	 * @param dbManager
	 * @param businessNo
	 * @return claimCode
	 * @throws SQLException
	 * @throws Exception
	 */
	protected String getClaimCode(DBManager dbManager,String registType,String registNo ,String claimNo) throws SQLException,Exception {
		String conditions = "";
		if("".equals(registNo))
		{
			conditions = " (claimno='"+claimNo+"') AND riskcode in('0506','0546','0556') and ( canceluploadflag is null or canceluploadflag = '' ) ";
		}else
		{
			conditions = " (registno='"+registNo+"' or claimno='"+claimNo+"') AND riskcode in('0506','0546','0556') and ( canceluploadflag is null or canceluploadflag = '' )  ";
		}
		System.out.println("========conditions=========conditions========"+conditions);
		String claimCode = "";
		List claimDemandList = new ArrayList();
		BLCIClaimDemandAction blCIClaimDemandAction = new BLCIClaimDemandAction();
		claimDemandList = (ArrayList)blCIClaimDemandAction.findByConditions(dbManager, conditions);
		if(claimDemandList != null && claimDemandList.size() > 0){
			claimCode = ((CIClaimDemandDto)claimDemandList.get(0)).getClaimCode();
		}
		System.out.println("========claimCode====claimCode==============="+claimCode);
		return claimCode;
	}
	
	/**
	 * ����ƽ̨���ص���Ϣ
	 * @param obj
	 * @param businessNo
	 */
	private void saveReturnInfo(DBManager dbManager, ReturnInfo returnInfo, String businessNo) throws SQLException,Exception{
		/**
		 * returnInfo.getReturnType()==1��ʾƽ̨���ݴ�����ȷ����
		 */		
		if(Iconstants.ReturnType.SUCCESS.equals(returnInfo.getReturnType())){
			if(returnInfo.getClaimCode()==null||returnInfo.getClaimCode().trim().length()==0){
				//������벻��Ϊ�գ�����˵��ƽ̨������Ϣ����ȷ
				//throw new Exception("ƽ̨���ص��������Ϊ��");
				UICIClaimDemandAction uiCIClaimDemandAction = new UICIClaimDemandAction();
				 
				String claimCode = "";
				//Ŀǰ��ҵ�᰸׷�ӡ���ǿ�ս᰸׷�� ��û�з����������
					String conditions= " (claimNo= '" + businessNo+"' or registNo = '" + businessNo+"') and riskcode='0506' ";
					ArrayList ciClaimDemandDtoList = uiCIClaimDemandAction.findByConditions(conditions);
					if(ciClaimDemandDtoList!=null && ciClaimDemandDtoList.size()>0){
						for (Iterator iter = ciClaimDemandDtoList.iterator(); iter.hasNext();) {
							CIClaimDemandDto element = (CIClaimDemandDto) iter.next();
							if(!("").equals(element.getClaimCode())){
								claimCode = element.getClaimCode();
								break;
							}							
						}
					}
					if(("").equals(claimCode)){
						claimCode = "1111";
					}
				returnInfo.setClaimCode(claimCode);
			}
			DBPrpCmain dbprpCmain=new DBPrpCmain(dbManager);
			PrpCmainDto prpCmainDto=dbprpCmain.findByPrimaryKey(returnInfo.getPolicyNo());
			BLCIClaimDemandAction blCIClaimDemandAction = new BLCIClaimDemandAction();
			CIClaimDemandDto ciClaimDemandDto = blCIClaimDemandAction.findByPrimaryKey(dbManager, returnInfo.getClaimCode());
			if(ciClaimDemandDto == null){
				ciClaimDemandDto = new CIClaimDemandDto();
				ciClaimDemandDto.setClaimCode(null);
			}
			if(Iconstants.ZJRequstType.REGIST_SYX.equals(returnInfo.getRequestType())){
				ciClaimDemandDto.setRegistUploadFlag("1");
				ciClaimDemandDto.setRegistNo(businessNo);
				ciClaimDemandDto.setRiskcode(prpCmainDto.getRiskCode());
			}else if(Iconstants.ZJRequstType.CLAIM_SYX.equals(returnInfo.getRequestType())){
				ciClaimDemandDto.setClaimUploadFlag("1");
				ciClaimDemandDto.setClaimNo(businessNo);
				ciClaimDemandDto.setRiskcode(prpCmainDto.getRiskCode());
			}else if(Iconstants.ZJRequstType.CANCEL_CASE.equals(returnInfo.getRequestType())){
				ciClaimDemandDto.setCancelUploadFlag("1");
			}else if(Iconstants.ZJRequstType.ENDCASE_SYX.equals(returnInfo.getRequestType())){
				ciClaimDemandDto.setEndCaseUploadFlag("1");
				ciClaimDemandDto.setCaseCheckNo(returnInfo.getClaimConfirmCode());
			}
			else if(Iconstants.ZJRequstType.ENDCASE_APPEND_SYX.equals(returnInfo.getRequestType())){
				ciClaimDemandDto.setEndCaseAppendUploadFlag("1");
			}else if(Iconstants.ZJRequstType.COMPENSATEVERIC_SYX.equals(returnInfo.getRequestType())){
				if(returnInfo.getCompensateNos().length() > 1){
					String strSql = "update prplcompensate set compensateuploadflag='" + returnInfo.getUploadSerialNo() + "'" +
						" where compensateno = '" + returnInfo.getCompensateNos() + "' ";
					dbManager.executeUpdate(strSql);
				}
				BLPrpLcompensateFacade blPrpLcompensate=new BLPrpLcompensateFacade();
				PrpLcompensateDto prpLcompensateDto=blPrpLcompensate.findByPrimaryKey(returnInfo.getCompensateNos());
				if(returnInfo.getLocked().size() > 0){
					DBPrpLlocklog dbPrpLlocklog = new DBPrpLlocklog(dbManager);
					PrpLlocklogDto prpLlocklogDto = null;
					String conditions = "registNo = '"+returnInfo.getCompensateNos()+"' and nodetype = 'veric' and riskcode in( '0506','0546','0556') ";
					dbPrpLlocklog.deleteByConditions(conditions);
					ArrayList prpLlocklogList = new ArrayList();
					for(int i = 0;i < returnInfo.getLocked().size();i++){
						prpLlocklogDto = (PrpLlocklogDto)returnInfo.getLocked().get(i);
						prpLlocklogDto.setRegistNo(returnInfo.getCompensateNos());
						prpLlocklogDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
						prpLlocklogDto.setRiskCode(prpLcompensateDto.getRiskCode());
						prpLlocklogList.add(prpLlocklogDto);
					}
					dbPrpLlocklog.insertAll(prpLlocklogList);
				}
			}
			else if(Iconstants.ZJRequstType.RECASE_SYX.equals(returnInfo.getRequestType())){
				int maxSerialNo=0;
				String uploadFlag=returnInfo.getUploadFlag();
			    UIRecaseAction  uiRecaseAction  =new  UIRecaseAction ();
			    if(null!=uploadFlag&&"1".equals(uploadFlag)){
			    	   maxSerialNo=returnInfo.getSelralNo();
			    }else{
				    String conditions="claimNo ='"+businessNo+"'";			    
				    if(uiRecaseAction.findByConditions(conditions)!=null){
				       maxSerialNo =  uiRecaseAction.getMaxSerialNo(businessNo);
				    }else{
				       maxSerialNo=1;
				    }	
			    }
			    ReCaseDto   recaseDto =  new ReCaseDto();
			    recaseDto=(ReCaseDto)uiRecaseAction.findByPrimaryKey(businessNo, maxSerialNo);
			    PrpLrecaseDto prpLrecaseDto=new PrpLrecaseDto();
			    prpLrecaseDto=((PrpLrecaseDto)recaseDto.getPrpLrecaseDto());
			    prpLrecaseDto.setReCaseUploadFlag("1");
			    recaseDto.setPrpLrecaseDto(prpLrecaseDto);
			    uiRecaseAction.savePrpLrecase(recaseDto);
				ciClaimDemandDto.setClaimNo(businessNo);
				ciClaimDemandDto.setEndCaseUploadFlag("");
			}
			else if(Iconstants.ZJRequstType.PAYINFOR_SYX.equals(returnInfo.getRequestType())){
				if(returnInfo.getCompensateNos().length() > 1){
					String strSql = "update prplcompensate set uploadserialNo='" + returnInfo.getUploadSerialNo() + "'" +
						" where compensateno in (" + returnInfo.getCompensateNos() + ")";
					dbManager.executeUpdate(strSql);
				}
				if(returnInfo.getPreCompensateNos().length() > 1){
					String strSql = "update prplprepay set uploadserialNo='" + returnInfo.getUploadSerialNo() + "'" +
						" where precompensateno in (" + returnInfo.getPreCompensateNos() + ")";
					dbManager.executeUpdate(strSql);
				}
				BLPrpLlocklogAction blPrpLlocklogAction = new BLPrpLlocklogAction();
				blPrpLlocklogAction.insertAll(dbManager, returnInfo.getLocked());
			}
			
			if(!Iconstants.RequstType.CANCELCASE.equals(returnInfo.getRequestType()))
			{
				if(ciClaimDemandDto.getClaimCode()==null||ciClaimDemandDto.getClaimCode().length()==0){
					System.out.println("=============��============");
					ciClaimDemandDto.setClaimCode(returnInfo.getClaimCode());
					System.out.println("==========returnclaimcode==========="+returnInfo.getClaimCode());
					blCIClaimDemandAction.insert(dbManager, ciClaimDemandDto);
				}else{
					System.out.println("=============update=====ciClaimDemand======="+ciClaimDemandDto.getClaimCode());
					blCIClaimDemandAction.update(dbManager, ciClaimDemandDto);
				}
			}
			
		}
	}
	
	
	/**
	 * ���ݱ����Ż�ñ���ȷ����
	 * @param dbManager
	 * @param policyNo
	 * @return confirmSequenceNo
	 * @throws SQLException
	 * @throws Exception
	 */
		String confirmSequenceNo = "";
		private String getConfirmSequenceNo(DBManager dbManager,String policyNo) throws SQLException,Exception {
		List ciInsureValidList = new ArrayList();
		BLCIInsureValidAction blCIInsureValidAction = new BLCIInsureValidAction();
		ciInsureValidList = (ArrayList)blCIInsureValidAction.findByConditions(dbManager, " policyno='" + policyNo + "'");
		if(ciInsureValidList != null && ciInsureValidList.size() > 0){	
			confirmSequenceNo = ((CIInsureValidDto)ciInsureValidList.get(0)).getValidNo();
		}
		return confirmSequenceNo;
	}
	
	private String getConfirmSequenceNoFromNotify(DBManager dbManager,String registNo)throws SQLException,Exception{
		String sql = "Select col3 From gyic.dbnotify y Where y.col5 = '" + registNo + "'";
		 ResultSet resultSet = dbManager.executeQuery(sql);
		 while(resultSet.next()){
			 confirmSequenceNo = dbManager.getString(resultSet,1);
		 }
		return confirmSequenceNo;
	}
	
	//��ά��
	/**
	 * �ṩ���ƽ̨������Ĭ��ʵ��
	 * ����Ŀ��ƽ̨������ȡ���Բ�ͬ����������ļ��ж�ȡ������ݿ��ж�ȡ�����������������¸�д�÷������ɡ�
	 * @return
	 * @throws Exception
	 */
	protected PlatFormParam getPlatFormParam(DBManager dbManager,String policyNo) throws Exception{		
		PlatFormParam platFormParam= new PlatFormParam();
		platFormParam.setUrl(AppConfig.get("ciplatform.URL"));
		platFormParam.setUserName(AppConfig.get("ciplatform.User"));
		platFormParam.setUserPwd(AppConfig.get("ciplatform.Pwd"));		
		System.out.println("url:\t"+AppConfig.get("ciplatform.URL"));
		System.out.println("user:\t"+AppConfig.get("ciplatform.User"));
		System.out.println("pwd:\t"+AppConfig.get("ciplatform.Pwd"));
//		BLPrpCmain blPrpCmain= new BLPrpCmain();
//		PrpCmainSchema prpCmainSchema = new PrpCmainSchema();
//		
//		blPrpCmain.getData(policyNo);
//		prpCmainSchema = blPrpCmain.getArr(0);
//		if("211".equals(prpCmainSchema.getComCode().substring(0, 3))){
//			platFormParam.setUrl(SysConst.getProperty("CI_INSURED_110_URL"));
//			platFormParam.setUserName(SysConst.getProperty("CI_INSURED_110_USER"));
//			platFormParam.setUserPwd(SysConst.getProperty("CI_INSURED_110_PASSWORD"));
//			platFormParam.setComcode(prpCmainSchema.getComCode());
//			if("0590".equals(prpCmainSchema.getRiskCode()))
//				platFormParam.setCIflag(true);
//			else
				platFormParam.setCIflag(false);
//		}
		return platFormParam;
	}
    
    /**
     * ת��returnInfor��ϢΪ��������ƽ̨���ص���ʷ�⸶��Ϣ
     * @return
     * @throws Exception
     *//*
    protected ClaimHistoryDto getClaimHistory(ReturnInfo returnInfo) throws Exception{        
        if (returnInfo!=null){
            ClaimHistoryDto claimHistoryDto=new ClaimHistoryDto();
            claimHistoryDto.setOwnClaimHistory(returnInfo.getAccidentBackInfo().getAClaimList());
            claimHistoryDto.setOtherClaimHistory(returnInfo.getAccidentBackInfo().getBClaimList());
            claimHistoryDto.setAccidentNo(returnInfo.getAccidentBackInfo().getAccidentNo());
            return claimHistoryDto;
            
        }else{
            return new ClaimHistoryDto();
        }
        
    }
    
    *//**
     * ת��returnInfor��ϢΪ��������ƽ̨���ص��¹���Ϣ
     * @return
     * @throws Exception
     *//*
    protected CompelCrashDto getCompelCrashDto(ReturnInfo returnInfo) throws Exception{  
        if (returnInfo!=null){
            CompelCrashDto compelCrashDto=new CompelCrashDto();
//            compelCrashDto=returnInfo.getCompelCrashDto();
//            compelCrashDto.setOwnAccidentInfor(returnInfo.getCompelCrashDto().getOtherAccidentInfor());
//            compelCrashDto.setOtherAccidentInfor(returnInfo.getAccidentBackWriteBackInfo().getBAccidentInfo());
//            compelCrashDto.setAccidentPlace(returnInfo.getAccidentBackWriteBackInfo().getAccidentPlace());
//            compelCrashDto.setAccidentTime(returnInfo.getAccidentBackWriteBackInfo().getAccidentTime());
//            compelCrashDto.setApplyAssessmentTime(returnInfo.getAccidentBackWriteBackInfo().getApplyAssessmentTime());
//            compelCrashDto.setAssessStartTime(returnInfo.getAccidentBackWriteBackInfo().getAssessStartTime());
//            compelCrashDto.setFaultBehavior(returnInfo.getAccidentBackWriteBackInfo().getFaultBehavior());
//            compelCrashDto.setFaultParty(returnInfo.getAccidentBackWriteBackInfo().getFaultParty());
//            compelCrashDto.setReportTime(returnInfo.getAccidentBackWriteBackInfo().getReportTime());
            return compelCrashDto;
        }else{
            return new CompelCrashDto();
        }
    }
	*/
	/**
	 * ���ǿ�Ʊ���ƽ̨��Ҫ�ı�������������ʵ��
	 * @param dbManager
	 * @param registNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected abstract Regist getRegist(DBManager dbManager, String registNo, String registType)throws SQLException, Exception;
	
	/**
	 * ���ǿ�Ʊ���ƽ̨��Ҫ����������������ʵ��
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected abstract Claim getClaim(DBManager dbManager, String claimNo, String registType)throws SQLException, Exception;
	
	/**
	 * ���ǿ�Ʊ���ƽ̨��Ҫ���������������ʵ��
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
//	protected abstract Compensate getCompensate(DBManager dbManager, String compensateNo, String registType)throws SQLException, Exception;
	
	
	/**
	 * ���ǿ�Ʊ���ƽ̨��Ҫ��ע����������������ʵ��
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
//	protected abstract CancelCase getCancelClaimCase(DBManager dbManager, String claimNo)throws SQLException, Exception;
	
	/**
	 * ���ǿ�Ʊ���ƽ̨��Ҫ��ע����������������ʵ��
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
//	protected abstract CancelCase getCancelRegistCase(DBManager dbManager, String registNo, String registType)throws SQLException, Exception;

	
	/**
	 * ���ǿ�Ʊ���ƽ̨��Ҫ�Ľ᰸����������ʵ��
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected abstract EndCase getEndCase(DBManager dbManager, String claimNo)throws SQLException, Exception;
	/**
	 * ���ǿ�Ʊ���ƽ̨��Ҫ�Ľ᰸׷�Ӷ���������ʵ��
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected abstract EndCaseAppend getEndCaseAppend(DBManager dbManager, String claimNo)throws SQLException, Exception;
	/**
	 * ���ǿ�Ʊ���ƽ̨��Ҫ�Ĳ鿱���������������ʵ��
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
//	protected abstract CheckVerify getCheckVerify(DBManager dbManager, String claimNo)throws SQLException, Exception;
	/**
	 * ���ǿ�Ʊ���ƽ̨��Ҫ�ĵ�֤����������ʵ��
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
//	protected abstract Certify getCertify(DBManager dbManager, String claimNo)throws SQLException, Exception;
	/**
	 * ���ǿ�Ʊ���ƽ̨��Ҫ���ո�����������ʵ��
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
//	protected abstract PayinforSH getPayinforSH(DBManager dbManager, String claimNo,String registType)throws SQLException, Exception;
	/**
	 * ���ǿ�Ʊ���ƽ̨��Ҫ�ĵ�֤����������ʵ��
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected abstract Payinfor getPayinfor(DBManager dbManager, String compensateNo, String payRefNo, String registType)throws SQLException, Exception;
    /**
     * ���泵��������д���󷵻ص�������ʷ�⸶��Ϣ��������ʵ��
     * @param dbManager
     * @param claimNo
     * @return
     * @throws SQLException
     * @throws Exception
     */
  //  protected abstract void saveClaimHistoryInfo(DBManager dbManager, ClaimHistoryDto claimHistory)throws SQLException, Exception;
    /**
     * ���泵��������д���󷵻ص�������ʷ�⸽��Ϣ��������ʵ��
     * @param dbManager
     * @param claimNo
     * @return
     * @throws SQLException
     * @throws Exception
     */
   // protected abstract void backWriteAccidentNo(DBManager dbManager,String ownRegist,String otherRegsit,String accidentNo)throws SQLException, Exception;
	/**
	 * ����㽭��ҵ��ע����������������ʵ��
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected abstract CancelCase getCancelCaseZJ(DBManager dbManager, String claimNo)throws SQLException, Exception;
	protected abstract ReCase getReCase(DBManager dbManager, String claimNo)throws SQLException, Exception;
	protected abstract ReCase getReCase(DBManager dbManager, String claimNo,int seralNo)throws SQLException, Exception;
	protected abstract CompensateVeric getCompensateVeric(DBManager dbManager, String registType,String compensateNo)throws SQLException, Exception;

}
