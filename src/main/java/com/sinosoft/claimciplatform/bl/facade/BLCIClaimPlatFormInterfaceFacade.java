package com.sinosoft.claimciplatform.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sinosoft.bz.common.BZAppConfig;
import com.sinosoft.ciplatform.bl.action.domain.BLCIClaimDemandAction;
import com.sinosoft.ciplatform.dto.custom.Accounts;
import com.sinosoft.ciplatform.dto.custom.ReturnAccountsInfo;
import com.sinosoft.ciplatform.dto.domain.CIClaimDemandDto;
import com.sinosoft.claim.bl.action.custom.BLPolicyAction;
import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claimciplatform.bl.action.custom.BLCIClaimPlatFormInterfaceAction;
import com.sinosoft.claimciplatform.bl.action.custom.CIPlatFormInterface;
import com.sinosoft.claimciplatform.bl.action.domain.BLCIClaimUploadRegistAction;
import com.sinosoft.claimciplatform.dto.custom.ClaimCiPlatFormException;
import com.sinosoft.claimciplatform.dto.custom.PlatFormParam;
import com.sinosoft.claimciplatform.dto.domain.CIClaimUploadRegistDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLCIClaimPlatFormInterfaceFacade {

	private static BLCIClaimPlatFormInterfaceFacade blCIClaimPlatFormInterfaceFacade = new BLCIClaimPlatFormInterfaceFacade();
	public static BLCIClaimPlatFormInterfaceFacade getInstance(){
		return blCIClaimPlatFormInterfaceFacade;
	}
	private BLCIClaimPlatFormInterfaceFacade(){
		//私有构造函数，禁止实例化，使用getInstance()获得实例
	}

	/**
	 * 向强制保险平台上传数据
	 * @param registType	数据交互类型（报案、立案、结案）
	 * @param businessNo	上传的业务号
	 * @param isImmediately	是否立即运行（是：实时；否：定时）
	 * @return　
	 * @throws ClaimCiPlatFormException,Exception
	 */
	public final void upload(String registType,String businessNo,String payRefNo,boolean isImmediately,String uploadWay) throws ClaimCiPlatFormException,Exception{
		ClaimCiPlatFormException claimCiPlatFormException = null;
		DBManager dbManager = new DBManager();
		try {
			BLCIClaimPlatFormInterfaceAction blCIClaimPlatFormInterfaceAction = BLCIClaimPlatFormInterfaceAction.getInstance();
			dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			dbManager.beginTransaction();
			claimCiPlatFormException = blCIClaimPlatFormInterfaceAction.upload(dbManager, registType, businessNo,payRefNo, isImmediately,uploadWay);
			dbManager.commitTransaction();
			
			if(claimCiPlatFormException!=null){
				throw claimCiPlatFormException;
			}
		}  catch (Exception e) {			
			e.printStackTrace();
			dbManager.rollbackTransaction();
			throw e;
		} finally{
			dbManager.close();			
		}

	}
	/**
	 * 案后重开补传接口
	 * @param registType	数据交互类型（报案、立案、结案）
	 * @param businessNo	上传的业务号
	 * @param isImmediately	是否立即运行（是：实时；否：定时）
	 * @return　
	 * @throws ClaimCiPlatFormException,Exception
	 */
	public final void upload(String registType,String businessNo,int serlalNo,String payRefNo,boolean isImmediately,String uploadWay,String policyNo) throws ClaimCiPlatFormException,Exception{
		ClaimCiPlatFormException claimCiPlatFormException = null;
		DBManager dbManager = new DBManager();
		try {
			
			
			BLCIClaimPlatFormInterfaceAction blCIClaimPlatFormInterfaceAction = BLCIClaimPlatFormInterfaceAction.getInstance();
			dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			dbManager.beginTransaction();
			claimCiPlatFormException = blCIClaimPlatFormInterfaceAction.upload(dbManager, registType, businessNo, serlalNo,payRefNo, isImmediately,uploadWay,policyNo);
			dbManager.commitTransaction();
			
			if(claimCiPlatFormException!=null){
				throw claimCiPlatFormException;
			}
		}  catch (Exception e) {			
			e.printStackTrace();
			dbManager.rollbackTransaction();
			throw e;
		} finally{
			dbManager.close();			
		}

	}
	
	
	public final void upload(DBManager dbManager,String registType,String businessNo,String payRefNo,boolean isImmediately,String uploadWay) throws ClaimCiPlatFormException,Exception{
		ClaimCiPlatFormException claimCiPlatFormException = null;
		try {
			BLCIClaimPlatFormInterfaceAction blCIClaimPlatFormInterfaceAction = BLCIClaimPlatFormInterfaceAction.getInstance();
			claimCiPlatFormException = blCIClaimPlatFormInterfaceAction.upload(dbManager, registType, businessNo,payRefNo, isImmediately,uploadWay);
			
			if(claimCiPlatFormException!=null){
				throw claimCiPlatFormException;
			}
		}  catch (Exception e) {			
			e.printStackTrace();
			throw e;
		} finally{
		}

	}
	
	public final void batchTransport() throws ClaimCiPlatFormException,Exception{
		ClaimCiPlatFormException claimCiPlatFormException = null;
		DBManager dbManagerQuery = new DBManager();
		try{
			BLCIClaimPlatFormInterfaceAction blCIClaimPlatFormInterfaceAction = BLCIClaimPlatFormInterfaceAction.getInstance();
			dbManagerQuery.open(AppConfig.get("sysconst.DBJNDI")) ;
			List cIClaimUploadRegistList = (ArrayList)new BLCIClaimUploadRegistAction().findByConditions(dbManagerQuery, "1=1");
			
			for (Iterator iter = cIClaimUploadRegistList.iterator(); iter.hasNext();) {
				CIClaimUploadRegistDto cIClaimUploadRegistDto = (CIClaimUploadRegistDto) iter.next();
				DBManager dbManager = new DBManager();
				try {
					dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
					dbManager.beginTransaction();				
					claimCiPlatFormException = blCIClaimPlatFormInterfaceAction.timeTransport(dbManager, cIClaimUploadRegistDto);
					dbManager.commitTransaction();
					if(claimCiPlatFormException!=null){
						throw claimCiPlatFormException;
					}
				}  catch (Exception e) {			
					e.printStackTrace();
					dbManager.rollbackTransaction();
					throw e;
				} finally{
					dbManager.close();			
				}
			}
		} catch (Exception e) {			
			e.printStackTrace();			
			throw e;
		} finally{
			dbManagerQuery.close();			
		}
	}

	/**
	 * 向强制保险平台上传数据
	 * @param registType	数据交互类型（报案、立案、结案）
	 * @param businessNo	上传的业务号
	 * @param isImmediately	是否立即运行（是：实时；否：定时）
	 * @return　
	 * @throws ClaimCiPlatFormException,Exception
	 */
	public ReturnAccountsInfo accountNoQuery(Accounts accounts) throws ClaimCiPlatFormException,Exception{
		ClaimCiPlatFormException claimCiPlatFormException = null;
		ReturnAccountsInfo returnInfo=null;
		DBManager dbManager = new DBManager();
		try {
			
			
			BLCIClaimPlatFormInterfaceAction blCIClaimPlatFormInterfaceAction = BLCIClaimPlatFormInterfaceAction.getInstance();
			dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			dbManager.beginTransaction();
			BLPrpLregistFacade blPrpLregistFacade=new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto=(PrpLregistDto)blPrpLregistFacade.findByPrimaryKey(accounts.getRecoveryRegistNo());
			String claimCode=getClaimCode(accounts.getRecoveryRegistNo());
			accounts.setClaimCode(claimCode);
			PlatFormParam platFormParam = getPlatFormParam(dbManager,prpLregistDto.getPolicyNo());		
			returnInfo = CIPlatFormInterface.send(accounts, platFormParam);
			dbManager.commitTransaction();
			
			if(claimCiPlatFormException!=null){
				throw claimCiPlatFormException;
			}
			return returnInfo;
		}  catch (Exception e) {			
			e.printStackTrace();
			dbManager.rollbackTransaction();
			throw e;
		} finally{
			dbManager.close();			
		}

	}
	
	/**
	 * 获取理赔编码
	 * @param dbManager
	 * @param businessNo
	 * @return claimCode
	 * @throws SQLException
	 * @throws Exception
	 */
	protected String getClaimCode(String registNo) throws SQLException,Exception {
		String conditions = " registNo='"+registNo+"' AND riskcode='0507' ";	
		System.out.println("========conditions=========conditions========"+conditions);
		String claimCode = "";
		List claimDemandList = new ArrayList();
		DBManager dbManager = new DBManager();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			dbManager.beginTransaction();			
		    BLCIClaimDemandAction blCIClaimDemandAction = new BLCIClaimDemandAction();
		    claimDemandList = (ArrayList)blCIClaimDemandAction.findByConditions(dbManager, conditions);
		if(claimDemandList != null && claimDemandList.size() > 0){
			claimCode = ((CIClaimDemandDto)claimDemandList.get(0)).getClaimCode();
		}
		dbManager.commitTransaction();
		System.out.println("========claimCode====claimCode==============="+claimCode);
		return claimCode;
	    }catch (Exception e) {			
		e.printStackTrace();
		dbManager.rollbackTransaction();
		throw e;
	    } finally{
		dbManager.close();	

	    }
	}
	
	/**
	 * 获得平台参数
	 * @param dbManager
	 * @param policyNo 保单号
	 * @return PlatFormParam 平台参数对象
	 */
	protected PlatFormParam getPlatFormParam(DBManager dbManager,
			String policyNo) throws SQLException, Exception {	
		PlatFormParam platFormParam = new PlatFormParam();
		BLPolicyAction blPolicyAction = new BLPolicyAction();
		BLPrpDcompanyFacade blPrpDcompanyFacade = new BLPrpDcompanyFacade();
		String strComCode = "";
		PrpCmainDto prpCmainDto = blPolicyAction.findPrpCmainDtoByPrimaryKey(dbManager, policyNo);
		strComCode = prpCmainDto.getComCode();
		//取省分机构代码
		PrpDcompanyDto prpDcompany = null;
		String comLevel = "";
		while(!"2".equals(comLevel)){
			prpDcompany = blPrpDcompanyFacade.findByPrimaryKey(strComCode);
			comLevel = prpDcompany.getComLevel();
			if(!"2".equals(comLevel)){
				strComCode = prpDcompany.getUpperComCode();
			}			
		}
		
		platFormParam.setComCode(strComCode);
		platFormParam.setUrl(BZAppConfig.getProperty(strComCode, "URL"));
		platFormParam.setUserName(BZAppConfig.getProperty(strComCode, "USER"));
		platFormParam.setUserPwd(BZAppConfig.getProperty(strComCode, "PASSWORD"));
		platFormParam.setUseFlag(BZAppConfig.getProperty(strComCode, "USEFLAG"));
		platFormParam.setRiskcode(BZAppConfig.getProperty(strComCode, "RISKCODE"));
		return platFormParam;
	}
}
