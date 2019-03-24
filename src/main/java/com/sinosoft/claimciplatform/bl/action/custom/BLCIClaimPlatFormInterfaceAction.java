package com.sinosoft.claimciplatform.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sinosoft.bz.common.BZAppConfig;
import com.sinosoft.bz.common.RequestType;
import com.sinosoft.claim.bl.action.domain.BLPrpLlocklogAction;
import com.sinosoft.ciplatform.dto.custom.ReCase;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLlocklogDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLlocklogDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCmain;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLlocklog;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.claimciplatform.bl.action.domain.BLCIClaimDemandAction;
import com.sinosoft.claimciplatform.bl.action.domain.BLCIClaimHistoryAction;
import com.sinosoft.claimciplatform.bl.action.domain.BLCIClaimThirdCarAction;
import com.sinosoft.claimciplatform.bl.action.domain.BLCIClaimUploadLogAction;
import com.sinosoft.claimciplatform.bl.action.domain.BLCIInsureValidAction;
import com.sinosoft.claimciplatform.bl.facade.BLCIClaimUploadLogFacade;
import com.sinosoft.claimciplatform.dto.custom.CancelCase;
import com.sinosoft.claimciplatform.dto.custom.Claim;
import com.sinosoft.claimciplatform.dto.custom.ClaimCiPlatFormException;
import com.sinosoft.claimciplatform.dto.custom.ClaimHistoryDto;
import com.sinosoft.claimciplatform.dto.custom.CompelCrashArgDto;
import com.sinosoft.claimciplatform.dto.custom.CompelCrashDto;
import com.sinosoft.claimciplatform.dto.custom.CompensateVeric;
import com.sinosoft.claimciplatform.dto.custom.EndCase;
import com.sinosoft.claimciplatform.dto.custom.EndCaseAppend;
import com.sinosoft.claimciplatform.dto.custom.Iconstants;
import com.sinosoft.claimciplatform.dto.custom.PayRefInfo;
import com.sinosoft.claimciplatform.dto.custom.PlatFormParam;
import com.sinosoft.claimciplatform.dto.custom.Regist;
import com.sinosoft.claimciplatform.dto.custom.ReturnInfo;
import com.sinosoft.claimciplatform.dto.domain.CIClaimDemandDto;
import com.sinosoft.claimciplatform.dto.domain.CIClaimUploadLogDto;
import com.sinosoft.claimciplatform.dto.domain.CIClaimUploadRegistDto;
import com.sinosoft.claimciplatform.dto.domain.CIInsureValidDto;
import com.sinosoft.claimciplatform.util.UUID;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * 平台注册action
 * <p>Title: 车险理赔 平台注册acton</p>
 * <p>Description: 车险理赔 平台注册acton</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Sinosoft</p>
 * @author miaowenjun
 * @version 1.0
 */
public abstract class BLCIClaimPlatFormInterfaceAction {
	/**
	 * 获得强制保险平台接口的实现类
	 * 在配置文件中的ciplatform.implClass指明实现类，该实现类必须继承BLCIClaimPlatFormInterfaceAction
	 * @return
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public final static BLCIClaimPlatFormInterfaceAction getInstance() throws ClassNotFoundException, Exception {
		BLCIClaimPlatFormInterfaceAction blCIClaimPlatFormInterfaceAction = null;
		Class loaderClass = Class.forName(BZAppConfig.getProperty("IMPLCLASS"));
		blCIClaimPlatFormInterfaceAction = (BLCIClaimPlatFormInterfaceAction)loaderClass.newInstance();
		return blCIClaimPlatFormInterfaceAction;
	}
	/**
	 * 平台入口
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
	public final ClaimCiPlatFormException upload(DBManager dbManager, String uploadType, String businessNo, String payRefNo,boolean isImmediately,String uploadWay) throws SQLException,Exception{
		
		CIClaimUploadRegistDto cIClaimUploadRegistDto = new CIClaimUploadRegistDto();
		cIClaimUploadRegistDto.setBusinessNo(businessNo);
		cIClaimUploadRegistDto.setRegistDate(new DateTime().current());
		cIClaimUploadRegistDto.setUploadType(uploadType);		
		cIClaimUploadRegistDto.setTriggerMode(isImmediately?"0":"1");
		cIClaimUploadRegistDto.setFailTimes(0);
		cIClaimUploadRegistDto.setUplaodWay(uploadWay);
		cIClaimUploadRegistDto.setPayRefNo(payRefNo);
		//isImmediately表示是否立即上传，若选否，则保存相关信息后不进行上传操作（通过定时任务来进行批量上传这些非立即上传的）
		//该字段系统目前没有使用，暂时保留
		if(isImmediately){
			cIClaimUploadRegistDto.setUploadNo(null);
			return upload(dbManager,cIClaimUploadRegistDto,null);
		}else{
			//cIClaimUploadRegistDto.setUploadNo(UUID.generate());
			//new BLCIClaimUploadRegistAction().insert(dbManager, cIClaimUploadRegistDto);
		}
		return null;
	}
	/**
	 * 平台入口(案后重开补传)
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
	public final ClaimCiPlatFormException upload(DBManager dbManager, String uploadType, String businessNo, int serlalNo,String payRefNo,boolean isImmediately,String uploadWay,String policyNo) throws SQLException,Exception{
		
		CIClaimUploadRegistDto cIClaimUploadRegistDto = new CIClaimUploadRegistDto();
		cIClaimUploadRegistDto.setBusinessNo(businessNo);
		cIClaimUploadRegistDto.setRegistDate(new DateTime().current());
		cIClaimUploadRegistDto.setUploadType(uploadType);		
		cIClaimUploadRegistDto.setTriggerMode(isImmediately?"0":"1");
		cIClaimUploadRegistDto.setFailTimes(0);
		cIClaimUploadRegistDto.setUplaodWay(uploadWay);
		cIClaimUploadRegistDto.setPayRefNo(payRefNo);
		cIClaimUploadRegistDto.setSerlalNo(serlalNo);
		cIClaimUploadRegistDto.setUploadFlag("1");
		//isImmediately表示是否立即上传，若选否，则保存相关信息后不进行上传操作（通过定时任务来进行批量上传这些非立即上传的）
		//该字段系统目前没有使用，暂时保留
		if(isImmediately){
			cIClaimUploadRegistDto.setUploadNo(null);
			return upload(dbManager,cIClaimUploadRegistDto,null);
		}else{
			//cIClaimUploadRegistDto.setUploadNo(UUID.generate());
			//new BLCIClaimUploadRegistAction().insert(dbManager, cIClaimUploadRegistDto);
		}
		return null;
	}
    /**
     * 平台入口
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
     */
    public final ClaimCiPlatFormException uploadCompelCrashRecord(DBManager dbManager,String uploadType,CompelCrashDto compelCrashDto) throws SQLException,Exception{
        CIClaimUploadRegistDto cIClaimUploadRegistDto = new CIClaimUploadRegistDto();
        cIClaimUploadRegistDto.setRegistDate(new DateTime().current());
        cIClaimUploadRegistDto.setUploadType(uploadType);       
        cIClaimUploadRegistDto.setFailTimes(0);
        cIClaimUploadRegistDto.setUploadNo(null);
        return upload(dbManager,cIClaimUploadRegistDto,compelCrashDto);
    }
    
    //zhouliu车车回写接口
    public final Object DownLoadCompelCrashRecord(DBManager dbManager,String uploadType,CompelCrashArgDto compelCrashArg) throws SQLException,Exception{
    	CIClaimUploadRegistDto cIClaimUploadRegistDto = new CIClaimUploadRegistDto();
        cIClaimUploadRegistDto.setRegistDate(new DateTime().current());
        cIClaimUploadRegistDto.setUploadType(uploadType);       
        cIClaimUploadRegistDto.setFailTimes(0);
        cIClaimUploadRegistDto.setUploadNo(null);
        return uploadCompelCrashQueryInfo(dbManager,cIClaimUploadRegistDto,compelCrashArg);
    }  
    //zhouliu车车上传入口
    private CompelCrashDto uploadCompelCrashQueryInfo(DBManager dbManager, CIClaimUploadRegistDto cIClaimUploadRegistDto,CompelCrashArgDto compelCrashArg) throws SQLException,Exception{
        String uploadNo = null;
        if(cIClaimUploadRegistDto.getUploadNo()==null||cIClaimUploadRegistDto.getUploadNo().trim().length()==0){
            uploadNo = null;
            cIClaimUploadRegistDto.setUploadNo(UUID.generate());
        }else{
            uploadNo = cIClaimUploadRegistDto.getUploadNo();
        }        
        //如果是实时数据上传的请求，则下面立刻开始上传数据
        ReturnInfo returnInfo = null;
        try {
            returnInfo = transport(dbManager,cIClaimUploadRegistDto.getUploadType(), cIClaimUploadRegistDto.getBusinessNo(),cIClaimUploadRegistDto.getPayRefNo(),null,compelCrashArg);
         } catch (ClaimCiPlatFormException e) {
            //传输失败（组织对象或XML数据失败又或是平台的问题导致失败
//            e.printStackTrace();
            throw new ClaimCiPlatFormException("回写车车互碰信息出错");
        	
        }finally{
          if(returnInfo!=null&& Iconstants.RequstType.COMPELCRASH_DOWNLOAD.equals(returnInfo.getRequestType())){
                cIClaimUploadRegistDto.setBusinessNo(compelCrashArg.getARegsitNo()); 
                returnInfo.setClaimCode(compelCrashArg.getBRegsitNo());
                if (!Iconstants.ReturnType.SUCCESS.equals(returnInfo.getReturnType())){
                    saveRegistLog(dbManager,returnInfo,cIClaimUploadRegistDto.getBusinessNo(),true,cIClaimUploadRegistDto.getUploadNo(),cIClaimUploadRegistDto.getUplaodWay());
//                    modify lishengjun
//                    throw new ClaimCiPlatFormException(returnInfo.getErrorMessage());
                    if (returnInfo!=null){
                        return getCompelCrashDto(returnInfo);//zhouliu
                    }
//                    modify lishengjun end
                }
            }else{
                cIClaimUploadRegistDto.setBusinessNo(compelCrashArg.getARegsitNo()); 
            }
            saveRegistLog(dbManager,returnInfo,cIClaimUploadRegistDto.getBusinessNo(),true,cIClaimUploadRegistDto.getUploadNo(),cIClaimUploadRegistDto.getUplaodWay());
        }
        if (returnInfo!=null){
            return getCompelCrashDto(returnInfo);//zhouliu
        }
        return null;
    }
	
	private ClaimCiPlatFormException upload(DBManager dbManager, CIClaimUploadRegistDto cIClaimUploadRegistDto,CompelCrashDto compelCrashDto) throws SQLException,Exception{
		int serialNo = 1;
		//取上传序号
		String uploadNo = null;
		BLCIClaimUploadLogFacade blCIClaimUploadLog = new BLCIClaimUploadLogFacade();
		if(cIClaimUploadRegistDto.getUploadNo()==null||cIClaimUploadRegistDto.getUploadNo().trim().length()==0){
			uploadNo = blCIClaimUploadLog.getUplaodNo(cIClaimUploadRegistDto.getBusinessNo());
			cIClaimUploadRegistDto.setUploadNo(uploadNo);
			String claimNo = "";
			if(uploadNo == null || "".equals(uploadNo)){
				//不存在当期业务号对应的上传序号，则可能当前业务号是个立案号，取出报案号再进行上传序号的查询
				BLPrpLcompensateFacade blPrpLcompensateFacade = new BLPrpLcompensateFacade();
				PrpLcompensateDto prpLcompensateDto = blPrpLcompensateFacade.findByPrimaryKey(cIClaimUploadRegistDto.getBusinessNo());
				if(prpLcompensateDto != null ){
					claimNo = prpLcompensateDto.getClaimNo();
					uploadNo = blCIClaimUploadLog.getUplaodNo(prpLcompensateDto.getClaimNo());
					cIClaimUploadRegistDto.setUploadNo(uploadNo);
				}
				if(uploadNo == null || "".equals(uploadNo)){
					//上传序号不存在时，自动生成上传序号
					cIClaimUploadRegistDto.setUploadNo(UUID.generate());
				}
			}
			
			if(uploadNo == null || "".equals(uploadNo)){
				//不存在当期业务号对应的上传序号，则可能当前业务号是个立案号，取出报案号再进行上传序号的查询
				BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
				PrpLclaimDto prpLclaimDto = blPrpLclaimFacade.findByPrimaryKey(cIClaimUploadRegistDto.getBusinessNo());
				if(prpLclaimDto != null ){
					uploadNo = blCIClaimUploadLog.getUplaodNo(prpLclaimDto.getRegistNo());
					cIClaimUploadRegistDto.setUploadNo(uploadNo);
				}
				if(uploadNo == null || "".equals(uploadNo)){
					//上传序号不存在时，自动生成上传序号
					cIClaimUploadRegistDto.setUploadNo(UUID.generate());
				}
			}
			
		}else{
			uploadNo = cIClaimUploadRegistDto.getUploadNo();
		}
		String uploadFlag=cIClaimUploadRegistDto.getUploadFlag();
		//如果是实时数据上传的请求，则下面立刻开始上传数据
		ReturnInfo returnInfo = null;
		try {
			if(uploadFlag!=null&&"1".equals(uploadFlag)){//补传
				returnInfo = transport(dbManager,cIClaimUploadRegistDto.getUploadType(), cIClaimUploadRegistDto.getBusinessNo(),cIClaimUploadRegistDto.getSerlalNo(),cIClaimUploadRegistDto.getPayRefNo(),compelCrashDto,null);
				}else{
				returnInfo = transport(dbManager,cIClaimUploadRegistDto.getUploadType(), cIClaimUploadRegistDto.getBusinessNo(),cIClaimUploadRegistDto.getPayRefNo(),compelCrashDto,null);	
				}
			if(!Iconstants.ReturnType.SUCCESS.equals(returnInfo.getReturnType())){
				return new ClaimCiPlatFormException(returnInfo.getErrorMessage());
			}
		} catch (ClaimCiPlatFormException e) {
			//传输失败（组织对象或XML数据失败又或是平台的问题导致失败
			//将报错信息放入返回信息中以供日志表保存
			if(returnInfo == null || "".equals(returnInfo.getErrorCode())){
				returnInfo = new ReturnInfo();
				returnInfo.setRequestType(cIClaimUploadRegistDto.getUploadType());
				returnInfo.setReturnType("0");
				returnInfo.setErrorCode("EXCEPTION");
				String errorMessage = CIPlatFormInterface.getStackTraceMessage(e);
				if(errorMessage.length() > 480){
					errorMessage = errorMessage.substring(0,480) + "……";
				}
				returnInfo.setErrorMessage(errorMessage);
				
			}
			return  e;
		}finally{
            /*//车车互碰返回结果处理
			if (Iconstants.RequstType.COMPELCRASH_UPLOAD.equals(cIClaimUploadRegistDto.getUploadType())){
                if (returnInfo!=null){
                    returnInfo.setClaimCode(compelCrashDto.getOtherAccidentInfor().getReportNo());
                    cIClaimUploadRegistDto.setBusinessNo(compelCrashDto.getOwnAccidentInfor().getReportNo());
                    if (Iconstants.ReturnType.SUCCESS.equals(returnInfo.getReturnType())){
                        compelCrashDto.setAccidentNo(returnInfo.getAccidentBackInfo().getAccidentNo());
                        ClaimHistoryDto claimHistoryDto=(ClaimHistoryDto)getClaimHistory(returnInfo);
                        saveClaimHistoryInfo(dbManager,claimHistoryDto,compelCrashDto);
                        backWriteAccidentNo(dbManager,compelCrashDto.getOwnAccidentInfor().getReportNo(),compelCrashDto.getOtherAccidentInfor().getReportNo(),claimHistoryDto.getAccidentNo()); 
                    }else{
                        saveRegistLog(dbManager,returnInfo,cIClaimUploadRegistDto.getBusinessNo(),true,cIClaimUploadRegistDto.getUploadNo(),cIClaimUploadRegistDto.getUplaodWay());
                        throw new ClaimCiPlatFormException(returnInfo.getErrorMessage());
                    }
                }else{
                    saveRegistLog(dbManager,returnInfo,cIClaimUploadRegistDto.getBusinessNo(),true,cIClaimUploadRegistDto.getUploadNo(),cIClaimUploadRegistDto.getUplaodWay());
                }
                
		    }else*/
		    if(returnInfo!=null&&Iconstants.ReturnType.SUCCESS.equals(returnInfo.getReturnType())){
				//如果平台返回了成功的标志，则保存此次成功
				saveReturnInfo(dbManager, returnInfo, cIClaimUploadRegistDto.getBusinessNo());
				//if(uploadNo!=null){
					//说明注册表中有该上传信息
					//new BLCIClaimUploadRegistAction().delete(dbManager, cIClaimUploadRegistDto.getUploadNo());
				//}
			}else{
				/*系统目前没有使用注册表
				 * cIClaimUploadRegistDto.setFailTimes(cIClaimUploadRegistDto.getFailTimes()+1);
				if(uploadNo==null){
					//说明注册表中无该信息，则要添加该注册记录
					new BLCIClaimUploadRegistAction().insert(dbManager, cIClaimUploadRegistDto);
				}else{
					//说明该注册表中有此记录，则要更新该注册信息
					new BLCIClaimUploadRegistAction().update(dbManager, cIClaimUploadRegistDto);
				}*/
			}
			//不论成功失败，都要保存相应的日志记录
		    serialNo = saveRegistLog(dbManager,returnInfo,cIClaimUploadRegistDto.getBusinessNo(),true,cIClaimUploadRegistDto.getUploadNo(),cIClaimUploadRegistDto.getUplaodWay());
		}

		return null;
	}
	
	/**
	 * 定时注册将数据传送到平台
	 * @param dbManager
	 * @throws ClaimCiPlatFormException
	 * @throws Exception
	 */
	public final ClaimCiPlatFormException timeTransport(DBManager dbManager,CIClaimUploadRegistDto cIClaimUploadRegistDto) throws SQLException,Exception{
		ClaimCiPlatFormException claimCiPlatFormException = upload(dbManager,cIClaimUploadRegistDto,null);
		return claimCiPlatFormException;
	}
	
	/**
	 * 实时注册,将数据传送平台
	 * @param dbManager
	 * @param businessNo
	 * @param registType
	 * @throws ClaimCiPlatFormException 
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws SQLException
	 * @throws Exception
	 */
	private ReturnInfo transport(DBManager dbManager, String registType, String businessNo,String payRefNo,CompelCrashDto compelCrashDto,CompelCrashArgDto compelCrashArg) throws ClaimCiPlatFormException {
		try{
			ReturnInfo returnInfo = null;
			if(RequestType.REGIST_SIGN.equals(registType)){  //报案
				Regist regist = getRegist(dbManager, businessNo);
				regist.setClaimCode(getClaimCode(dbManager, regist.getRegistNo(), regist.getClaimNo()));
				regist.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, regist.getPolicyNO()));
				
				PlatFormParam platFormParam = getPlatFormParam(dbManager,regist.getPolicyNO());
				
				returnInfo = CIPlatFormInterface.send(regist, platFormParam);	
				returnInfo.setPolicyNo(regist.getPolicyNO());
			}else if(RequestType.CLAIM_SIGN.equals(registType)){  //立案
				
				Claim claim = getClaim(dbManager, businessNo);
				claim.setClaimCode(getClaimCode(dbManager, claim.getRegistNo(), claim.getClaimNo()));
				claim.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, claim.getPolicyNO()));
				
				PlatFormParam platFormParam = getPlatFormParam(dbManager,claim.getPolicyNO());
				
				returnInfo = CIPlatFormInterface.send(claim, platFormParam);
				returnInfo.setPolicyNo(claim.getPolicyNO());
			}else if(RequestType.CASE_CANCEL.equals(registType)){  //案件注销
				
				CancelCase cancelCase = getCancelClaimCase(dbManager, businessNo);
				cancelCase.setClaimCode(getClaimCode(dbManager, cancelCase.getRegistNo(), cancelCase.getClaimNo()));
				PlatFormParam platFormParam = getPlatFormParam(dbManager,cancelCase.getPolicyNO());
				
				returnInfo = CIPlatFormInterface.send(cancelCase, platFormParam);
				
				returnInfo.setClaimCode(cancelCase.getClaimCode());
				returnInfo.setPolicyNo(cancelCase.getPolicyNO());
			}else if(Iconstants.RequstType.CANCEL_REGIST_CASE.equals(registType)){  //报案注销
				
				CancelCase cancelCase = getCancelRegistCase(dbManager, businessNo);
				cancelCase.setClaimCode(getClaimCode(dbManager, cancelCase.getRegistNo(), cancelCase.getClaimNo()));
				
				PlatFormParam platFormParam = getPlatFormParam(dbManager,cancelCase.getPolicyNO());
				
				returnInfo = CIPlatFormInterface.send(cancelCase, platFormParam);
				returnInfo.setPolicyNo(cancelCase.getPolicyNO());
			}else if(RequestType.ENDCASE_SIGN.equals(registType)){  //结案
				
				EndCase endCase = getEndCase(dbManager, businessNo);
				endCase.setClaimCode(getClaimCode(dbManager, endCase.getRegistNo(), endCase.getClaimNo()));
				endCase.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, endCase.getPolicyNo()));
				
				PlatFormParam platFormParam = getPlatFormParam(dbManager,endCase.getPolicyNo());
				
				returnInfo = CIPlatFormInterface.send(endCase, platFormParam);
				returnInfo.setPolicyNo(endCase.getPolicyNo());
			}else if(RequestType.RECASE_SIGN.equals(registType)){  //案后重开
				
				ReCase reCase = getReCase(dbManager, businessNo);
				reCase.setClaimCode(getClaimCode(dbManager, reCase.getClaimNo()));
				reCase.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, reCase.getPolicyNo()));				
				PlatFormParam platFormParam = getPlatFormParam(dbManager,reCase.getPolicyNo());
				
				returnInfo = CIPlatFormInterface.send(reCase, platFormParam);
				returnInfo.setClaimCode(getClaimCode(dbManager, reCase.getClaimNo()));
				returnInfo.setPolicyNo(reCase.getPolicyNo());
			}else if(RequestType.ENDCASE_APPEND.equals(registType)){  //结案追加
				
				EndCaseAppend endCaseAppend = getEndCaseAppend(dbManager,businessNo);
				endCaseAppend.setClaimCode(getClaimCode(dbManager, endCaseAppend.getRegistNo(), endCaseAppend.getClaimNo()));
				PlatFormParam platFormParam = getPlatFormParam(dbManager,endCaseAppend.getPolicyNO());
				
				returnInfo = CIPlatFormInterface.send(endCaseAppend, platFormParam);
				
				//结案追加不返回理赔编码，此处设置
				returnInfo.setClaimCode(endCaseAppend.getClaimCode());
				returnInfo.setPolicyNo(endCaseAppend.getPolicyNO());
			}else if(RequestType.CASE_PAYREF.equals(registType)){  //赔付登记
				
				PayRefInfo payRefInfo = getPayRefInfo(dbManager,businessNo,payRefNo);
				payRefInfo.setClaimCode(getClaimCode(dbManager, "", payRefInfo.getClaimNo()));
				payRefInfo.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, payRefInfo.getPolicyNO()));
				PlatFormParam platFormParam = getPlatFormParam(dbManager,payRefInfo.getPolicyNO());
				
				returnInfo = CIPlatFormInterface.send(payRefInfo, platFormParam);
				returnInfo.setPolicyNo(payRefInfo.getPolicyNO());
				//赔付登记不返回理赔编码，此处设置
				returnInfo.setClaimCode(payRefInfo.getClaimCode());
				returnInfo.setUploadSerialNo(payRefInfo.getSerialNo());
				returnInfo.setCompensateNos(payRefInfo.getCompensateNos());
				returnInfo.setPreCompensateNos(payRefInfo.getPreCompensateNos());
				for(Iterator itr = returnInfo.getLocked().iterator();itr.hasNext();){
					PrpLlocklogDto prpLlocklogDto = (PrpLlocklogDto)itr.next();
					prpLlocklogDto.setRegistNo(payRefInfo.getRegistNo());
				}
				
			}else if(RequestType.COMPENSATE_SIGN.equals(registType)){//理算核赔
				CompensateVeric compensateVeric = getCompensateVeric(dbManager,businessNo);
				String claimCode = getClaimCode(dbManager,compensateVeric.getRegistNo(),compensateVeric.getClaimNo());
				if("".equals(claimCode)){
					throw new Exception("交强险理赔编码不存在!!!");
				}else{
					compensateVeric.setClaimCode(claimCode);
				}
				compensateVeric.setClaimCode(claimCode);
				compensateVeric.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, compensateVeric.getPolicyNo()));
				PlatFormParam platFormParam = getPlatFormParam(dbManager,compensateVeric.getPolicyNo());
				returnInfo = CIPlatFormInterface.send(compensateVeric, platFormParam);
				
				returnInfo.setClaimCode(compensateVeric.getClaimCode());
				returnInfo.setCompensateNos(compensateVeric.getCompensateNo());
				returnInfo.setUploadSerialNo("1");
				returnInfo.setPolicyNo(compensateVeric.getPolicyNo());
			}else if (Iconstants.RequstType.COMPELCRASH_UPLOAD.equals(registType)){    //事故信息上传
				
                PlatFormParam platFormParam = getPlatFormParam(dbManager,compelCrashDto.getCompePlatFormRetrunParam().getCiPlatFormCode());
                returnInfo = CIPlatFormInterface.send(compelCrashDto, platFormParam);
            }else if (Iconstants.RequstType.COMPELCRASH_DOWNLOAD.equals(registType)){   //事故信息回写
            	
            	PlatFormParam platFormParam = getPlatFormParam(dbManager,compelCrashArg.getCiPlatFormCode());
            	returnInfo=CIPlatFormInterface.send(compelCrashArg, platFormParam);
            	
            }
			return returnInfo;
		}catch(Exception e){
			e.printStackTrace();
			throw new ClaimCiPlatFormException("数据准备或上传失败",e); 
		}
	}
	
	/**
	 * 实时注册,将数据传送平台(案后重开)
	 * @param dbManager
	 * @param businessNo
	 * @param registType
	 * @throws ClaimCiPlatFormException 
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws SQLException
	 * @throws Exception
	 */
	private ReturnInfo transport(DBManager dbManager, String registType, String businessNo,int serlalNo,String payRefNo,CompelCrashDto compelCrashDto,CompelCrashArgDto compelCrashArg) throws ClaimCiPlatFormException {
		try{
			ReturnInfo returnInfo = null;
			
			if(RequestType.RECASE_SIGN.equals(registType)){  //案后重开
				
				ReCase reCase = getReCase(dbManager, businessNo,serlalNo);
				reCase.setClaimCode(getClaimCode(dbManager, reCase.getClaimNo()));
				reCase.setConfirmSequenceNo(getConfirmSequenceNo(dbManager, reCase.getPolicyNo()));				
				PlatFormParam platFormParam = getPlatFormParam(dbManager,reCase.getPolicyNo());
				
				returnInfo = CIPlatFormInterface.send(reCase, platFormParam);
				returnInfo.setClaimCode(getClaimCode(dbManager, reCase.getClaimNo()));
				returnInfo.setSelralNo(serlalNo);
				returnInfo.setUploadFlag("1");
			}
			return returnInfo;
		}catch(Exception e){
			e.printStackTrace();
			throw new ClaimCiPlatFormException("数据准备或上传失败",e); 
		}
	}
	private int saveRegistLog(DBManager dbManager, ReturnInfo returnInfo, String businessNo, boolean isImmediately,String uploadNo,String uploadWay) throws Exception{
		int serialNo = new BLCIClaimUploadLogAction().getMaxSerialNo(dbManager, uploadNo)+1;
		CIClaimUploadLogDto ciClaimUploadLog = new CIClaimUploadLogDto();
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
		ciClaimUploadLog.setUploadWay(uploadWay);
		if(returnInfo!=null){
			ciClaimUploadLog.setUploadType(returnInfo.getRequestType());
			ciClaimUploadLog.setClaimCode(returnInfo.getClaimCode());
		}
		new BLCIClaimUploadLogAction().insert(dbManager, ciClaimUploadLog);
		return serialNo;
	}
	
	/**
	 * 获取理赔编码
	 * @param dbManager
	 * @param businessNo
	 * @return claimCode
	 * @throws SQLException
	 * @throws Exception
	 */
	private String getClaimCode(DBManager dbManager ,String claimNo) throws SQLException,Exception {
		String conditions = " claimno='"+claimNo+"' and riskcode='0507' ";
		String claimCode = "";
		List claimDemandList = new ArrayList();
		BLCIClaimDemandAction blCIClaimDemandAction = new BLCIClaimDemandAction();
		claimDemandList = (ArrayList)blCIClaimDemandAction.findByConditions(dbManager, conditions);
		if(claimDemandList != null && claimDemandList.size() > 0){
			claimCode = ((CIClaimDemandDto)claimDemandList.get(0)).getClaimCode();
		}
		System.out.println("====================claimCode="+claimCode+"================================");
		return claimCode;
	}
	
	/**
	 * 获取理赔编码
	 * @param dbManager
	 * @param businessNo
	 * @return claimCode
	 * @throws SQLException
	 * @throws Exception
	 */
	protected String getClaimCode(DBManager dbManager,String registNo ,String claimNo) throws SQLException,Exception {
		String conditions = "";
		if("".equals(registNo))
		{
			conditions = " (claimno='"+claimNo+"') and riskcode in('0507','0597') and ( canceluploadflag is null or canceluploadflag = '' ) ";
		}else
		{
			conditions = " (registno='"+registNo+"' or claimno='"+claimNo+"') and  riskcode in('0507','0597') and ( canceluploadflag is null or canceluploadflag = '' ) ";	
		}
		
		String claimCode = "";
		List claimDemandList = new ArrayList();
		BLCIClaimDemandAction blCIClaimDemandAction = new BLCIClaimDemandAction();
		claimDemandList = (ArrayList)blCIClaimDemandAction.findByConditions(dbManager, conditions);
		if(claimDemandList != null && claimDemandList.size() > 0){
			claimCode = ((CIClaimDemandDto)claimDemandList.get(0)).getClaimCode();
		}
		System.out.println("====================claimCode="+claimCode+"================================");
		return claimCode;
	}
	
	/**
	 * 保存平台返回的信息
	 * @param obj
	 * @param businessNo
	 */
	private void saveReturnInfo(DBManager dbManager, ReturnInfo returnInfo, String businessNo) throws SQLException,Exception{
		/**
		 * 保存车车互碰事故上传返回信息
		 * */
		if(Iconstants.ReturnType.SUCCESS.equals(returnInfo.getReturnType()) && (returnInfo.getRequestType()==null || returnInfo.getRequestType().equals(""))){
			//增加对返回信息的保存方法
		}
		
		
		/**
		 * returnInfo.getReturnType()==1表示平台数据处理正确返回
		 */
		
		if(Iconstants.ReturnType.SUCCESS.equals(returnInfo.getReturnType())){
			
			DBPrpCmain dbPrpCmain=new DBPrpCmain(dbManager);
			PrpCmainDto prpCmainDto=dbPrpCmain.findByPrimaryKey(returnInfo.getPolicyNo());
			BLCIClaimDemandAction blCIClaimDemandAction = new BLCIClaimDemandAction();
			CIClaimDemandDto ciClaimDemandDto = blCIClaimDemandAction.findByPrimaryKey(dbManager, returnInfo.getClaimCode());
			
			if(ciClaimDemandDto == null){
				ciClaimDemandDto = new CIClaimDemandDto();
				ciClaimDemandDto.setClaimCode(null);
			}
			if(RequestType.REGIST_SIGN.equals(returnInfo.getRequestType())){
				ciClaimDemandDto.setRegistUploadFlag("1");
				ciClaimDemandDto.setRegistNo(businessNo);
				//2011
				ciClaimDemandDto.setRiskCode(prpCmainDto.getRiskCode());
				
				//保存历次赔案信息
				String strWhere = " claimCode = '" + returnInfo.getClaimCode() + "'";
				BLCIClaimHistoryAction blCIClaimHistoryAction = new BLCIClaimHistoryAction();
				blCIClaimHistoryAction.deleteByConditions(dbManager, strWhere);
				blCIClaimHistoryAction.insertAll(dbManager, returnInfo.getHistoryClaimList());
				
			}else if(RequestType.CLAIM_SIGN.equals(returnInfo.getRequestType())){
				ciClaimDemandDto.setClaimUploadFlag("1");
				ciClaimDemandDto.setClaimNo(businessNo);
				
				//保存历次赔案信息
				String strWhere = " claimCode = '" + returnInfo.getClaimCode() + "'";
				BLCIClaimHistoryAction blCIClaimHistoryAction = new BLCIClaimHistoryAction();
				blCIClaimHistoryAction.deleteByConditions(dbManager, strWhere);
				blCIClaimHistoryAction.insertAll(dbManager, returnInfo.getHistoryClaimList());
				
			}else if(RequestType.CASE_CANCEL.equals(returnInfo.getRequestType())){
				ciClaimDemandDto.setCancelUploadFlag("1");
				PrpLclaimDto prpLclaimDto = new BLPrpLclaimFacade().findByPrimaryKey(businessNo);
				if(prpLclaimDto != null){
					ciClaimDemandDto.setClaimNo(businessNo);
					ciClaimDemandDto.setRegistNo(prpLclaimDto.getRegistNo());
				}else{
					ciClaimDemandDto.setRegistNo(businessNo);
				}
			}else if(RequestType.ENDCASE_SIGN.equals(returnInfo.getRequestType())){
				ciClaimDemandDto.setEndCaseUploadFlag("1");
				ciClaimDemandDto.setClaimNo(businessNo);
				ciClaimDemandDto.setCaseCheckNo(returnInfo.getClaimConfirmCode());
				
				//保存三者赔付情况列表
				String strWhere = " claimCode = '" + returnInfo.getClaimCode() + "'";
				BLCIClaimThirdCarAction blCIClaimThirdCarAtion = new BLCIClaimThirdCarAction();
				blCIClaimThirdCarAtion.deleteByConditions(dbManager, strWhere);
				blCIClaimThirdCarAtion.insertAll(dbManager, returnInfo.getThirdCarList());
				
			}else if(RequestType.ENDCASE_APPEND.equals(returnInfo.getRequestType())){
				ciClaimDemandDto.setEndCaseAppendUploadFlag("1");
				ciClaimDemandDto.setClaimNo(businessNo);
			}else if(RequestType.RECASE_SIGN.equals(returnInfo.getRequestType())){
				//保存锁定信息列表
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
			    uiRecaseAction.savePrpLrecase(recaseDto);
				ciClaimDemandDto.setClaimNo(businessNo);
				ciClaimDemandDto.setEndCaseUploadFlag("");
			    }else if(RequestType.COMPENSATE_SIGN.equals(returnInfo.getRequestType())){
				String strSql = "update prplcompensate set compensateuploadflag='" + returnInfo.getUploadSerialNo() + "'" +
				" where compensateno ='" + returnInfo.getCompensateNos() + "' ";
				dbManager.executeUpdate(strSql);
				if(returnInfo.getLocked().size() > 0){
					DBPrpLlocklog dbPrpLlocklog = new DBPrpLlocklog(dbManager);
					PrpLlocklogDto prpLlocklogDto = null;
					String conditions = "registNo = '"+returnInfo.getCompensateNos()+"' and nodetype = 'veric' and riskcode = '0507' ";
					dbPrpLlocklog.deleteByConditions(conditions);
					ArrayList prpLlocklogList = new ArrayList();
					for(int i = 0;i < returnInfo.getLocked().size();i++){
						prpLlocklogDto = (PrpLlocklogDto)returnInfo.getLocked().get(i);
						prpLlocklogDto.setRegistNo(returnInfo.getCompensateNos());
						prpLlocklogDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
						prpLlocklogDto.setRiskCode(prpCmainDto.getRiskCode());
						prpLlocklogList.add(prpLlocklogDto);
					}
					dbPrpLlocklog.insertAll(prpLlocklogList);
				}			
			}
			
			if (!RequestType.CASE_PAYREF.equals(returnInfo.getRequestType())) {
				if (ciClaimDemandDto.getClaimCode() == null
						|| ciClaimDemandDto.getClaimCode().length() == 0) {

					ciClaimDemandDto.setClaimCode(returnInfo.getClaimCode());
					blCIClaimDemandAction.insert(dbManager, ciClaimDemandDto);
				} else {
					blCIClaimDemandAction.update(dbManager, ciClaimDemandDto);
				}
			//实付接口时，需要回写prplcompensate，prplprepay表相关数据
			}else{
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
		}
	}
	
	
	/**
	 * 根据保单号获得保单确认码
	 * @param dbManager
	 * @param policyNo
	 * @return confirmSequenceNo
	 * @throws SQLException
	 * @throws Exception
	 */
	private String getConfirmSequenceNo(DBManager dbManager,String policyNo) throws SQLException,Exception {
		String confirmSequenceNo = "";
		List ciInsureValidList = new ArrayList();
		BLCIInsureValidAction blCIInsureValidAction = new BLCIInsureValidAction();
		ciInsureValidList = (ArrayList)blCIInsureValidAction.findByConditions(dbManager, " policyno='" + policyNo + "'");
		if(ciInsureValidList != null && ciInsureValidList.size() > 0){	
			confirmSequenceNo = ((CIInsureValidDto)ciInsureValidList.get(0)).getValidNo();
		}
		return confirmSequenceNo;
	}
	
	
	/**
	 * 提供获得平台参数的默认实现
	 * 若项目组平台参数获取策略不同（如从配置文件中读取或从数据库中读取），则在子类中重新覆写该方法即可。
	 * @return
	 * @throws Exception
	 */
	protected PlatFormParam getPlatFormParam(DBManager dbManager,String policyNo) throws Exception{		
		PlatFormParam platFormParam= new PlatFormParam();
		platFormParam.setUrl(AppConfig.get("ciplatform.URL"));
		platFormParam.setUserName(AppConfig.get("ciplatform.User"));
		platFormParam.setUserPwd(AppConfig.get("ciplatform.Pwd"));		
		return platFormParam;
	}
    
	/**
	 * 提供获得平台参数的默认实现
	 * 若项目组平台参数获取策略不同（如从配置文件中读取或从数据库中读取），则在子类中重新覆写该方法即可。
	 * @return
	 * @throws Exception
	 */
	public PlatFormParam getPlatFormParam(String policyNo) throws Exception{		
		PlatFormParam platFormParam= new PlatFormParam();
		platFormParam.setUrl(AppConfig.get("ciplatform.URL"));
		platFormParam.setUserName(AppConfig.get("ciplatform.User"));
		platFormParam.setUserPwd(AppConfig.get("ciplatform.Pwd"));		
		return platFormParam;
	}
    /**
     * 转换returnInfor信息为车车互碰平台返回的历史赔付信息
     * @return
     * @throws Exception
     */
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
    
    /**
     * 转换returnInfor信息为车车互碰平台返回的事故信息
     * @return
     * @throws Exception
     */
    protected CompelCrashDto getCompelCrashDto(ReturnInfo returnInfo) throws Exception{  
        if (returnInfo!=null){
            CompelCrashDto compelCrashDto=new CompelCrashDto();
            compelCrashDto=returnInfo.getCompelCrashDto();
            compelCrashDto.setOwnAccidentInfor(returnInfo.getCompelCrashDto().getOwnAccidentInfor());
            compelCrashDto.setOtherAccidentInfor(returnInfo.getCompelCrashDto().getOtherAccidentInfor());
            compelCrashDto.setAccidentPlace(returnInfo.getCompelCrashDto().getAccidentPlace());
            compelCrashDto.setAccidentTime(returnInfo.getCompelCrashDto().getAccidentTime());
            compelCrashDto.setApplyAssessmentTime(returnInfo.getCompelCrashDto().getApplyAssessmentTime());
            compelCrashDto.setAssessStartTime(returnInfo.getCompelCrashDto().getAssessStartTime());
            compelCrashDto.setFaultBehavior(returnInfo.getCompelCrashDto().getFaultBehavior());
            compelCrashDto.setFaultParty(returnInfo.getCompelCrashDto().getFaultParty());
            compelCrashDto.setReportTime(returnInfo.getCompelCrashDto().getReportTime());
            return compelCrashDto;
        }else{
            return new CompelCrashDto();
        }
    }
	
	/**
	 * 获得强制保险平台需要的报案对象，由子类实现
	 * @param dbManager
	 * @param registNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected abstract Regist getRegist(DBManager dbManager, String registNo)throws SQLException, Exception;
	
	/**
	 * 获得强制保险平台需要的立案对象，由子类实现
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected abstract Claim getClaim(DBManager dbManager, String claimNo)throws SQLException, Exception;
	
	/**
	 * 获得强制保险平台需要的注销案件对象，由子类实现
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected abstract CancelCase getCancelClaimCase(DBManager dbManager, String businessNo)throws SQLException, Exception;
	
	/**
	 * 获得强制保险平台需要的注销案件对象，由子类实现
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected abstract CancelCase getCancelRegistCase(DBManager dbManager, String registNo)throws SQLException, Exception;

	
	/**
	 * 获得强制保险平台需要的结案对象，由子类实现
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected abstract EndCase getEndCase(DBManager dbManager, String claimNo)throws SQLException, Exception;
	/**
	 * 获得强制保险平台需要的结案追加对象，由子类实现
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected abstract EndCaseAppend getEndCaseAppend(DBManager dbManager, String claimNo)throws SQLException, Exception;
	
	/**
	 * 获得强制保险平台需要的赔付登记对象，由子类实现
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected abstract PayRefInfo getPayRefInfo(DBManager dbManager, String claimNo,String payRefNo)throws SQLException, Exception;
	
	/**
     * 保存车车互碰回写请求返回的理赔历史赔付信息，由子类实现
     * @param dbManager
     * @param claimNo
     * @return
     * @throws SQLException
     * @throws Exception
     */
    protected abstract void saveClaimHistoryInfo(DBManager dbManager, ClaimHistoryDto claimHistory,CompelCrashDto compelCrashDto)throws SQLException, Exception;
    /**
     * 保存车车互碰回写请求返回的理赔历史赔附信息，由子类实现
     * @param dbManager
     * @param claimNo
     * @return
     * @throws SQLException
     * @throws Exception
     */
    protected abstract void backWriteAccidentNo(DBManager dbManager,String ownRegist,String otherRegsit,String accidentNo)throws SQLException, Exception;
	/**
	 * 获得强制保险平台需要的案后重开对象，由子类实现
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected abstract ReCase getReCase(DBManager dbManager, String claimNo)throws SQLException, Exception;
	/**
	 * 获得强制保险平台需要的案后重开对象，由子类实现
	 * @param dbManager
	 * @param claimNo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	protected abstract ReCase getReCase(DBManager dbManager, String claimNo,int serlalNo)throws SQLException, Exception;
	protected abstract CompensateVeric getCompensateVeric(DBManager dbManager, String compensateNo)throws SQLException, Exception;
    
}
