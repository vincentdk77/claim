package com.sinosoft.ciplatform.bl.facade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sinosoft.ciplatform.bl.action.custom.BLCIClaimPlatFormInterfaceAction;
import com.sinosoft.ciplatform.dto.custom.ClaimCiPlatFormException;
import com.sinosoft.ciplatform.dto.domain.CIClaimUploadRegistDto;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.ciplatform.bl.action.domain.BLCIClaimUploadRegistAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLCIClaimSYXPlatFormInterfaceFacade {

	private static BLCIClaimSYXPlatFormInterfaceFacade blCIClaimPlatFormInterfaceFacade = new BLCIClaimSYXPlatFormInterfaceFacade();
	public static BLCIClaimSYXPlatFormInterfaceFacade getInstance(){
		return blCIClaimPlatFormInterfaceFacade;
	}
	private BLCIClaimSYXPlatFormInterfaceFacade(){
		//˽�й��캯������ֹʵ������ʹ��getInstance()���ʵ��
	}

	/**
	 * ��ǿ�Ʊ���ƽ̨�ϴ�����
	 * @param registType	���ݽ������ͣ��������������᰸��
	 * @param businessNo	�ϴ���ҵ���
	 * @param isImmediately	�Ƿ��������У��ǣ�ʵʱ���񣺶�ʱ��
	 * @return��
	 * @throws ClaimCiPlatFormException,Exception
	 */
	public final void upload(String registType,String businessNo,boolean isImmediately,CIPlatformConfigDto cIPlatformConfigDto,String uploadWay,String payRefNo) throws ClaimCiPlatFormException,Exception{
		ClaimCiPlatFormException claimCiPlatFormException = null;
		DBManager dbManager = new DBManager();
		try {
			BLCIClaimPlatFormInterfaceAction blCIClaimPlatFormInterfaceAction = BLCIClaimPlatFormInterfaceAction.getInstance();
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			dbManager.beginTransaction();
			
			claimCiPlatFormException = blCIClaimPlatFormInterfaceAction.upload(dbManager, registType, businessNo, isImmediately,cIPlatformConfigDto,uploadWay,payRefNo);
			dbManager.commitTransaction();
			if(claimCiPlatFormException!=null){
				throw claimCiPlatFormException;
			}
		}  catch (Exception e) {			
			//e.printStackTrace();
			dbManager.rollbackTransaction();
			throw e;
		} finally{
			dbManager.close();			
		}

	}
	/**
	 * ��ǿ�Ʊ���ƽ̨�ϴ�����(�����ؿ������ӿ�)
	 * @param registType	���ݽ������ͣ��������������᰸��
	 * @param businessNo	�ϴ���ҵ���
	 * @param isImmediately	�Ƿ��������У��ǣ�ʵʱ���񣺶�ʱ��
	 * @return��
	 * @throws ClaimCiPlatFormException,Exception
	 */
	public final void upload(String registType,String businessNo,int serlalNo,boolean isImmediately,CIPlatformConfigDto cIPlatformConfigDto,String uploadWay,String payRefNo,String policyNo) throws ClaimCiPlatFormException,Exception{
		ClaimCiPlatFormException claimCiPlatFormException = null;
		DBManager dbManager = new DBManager();
		try {
			BLCIClaimPlatFormInterfaceAction blCIClaimPlatFormInterfaceAction = BLCIClaimPlatFormInterfaceAction.getInstance();
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			dbManager.beginTransaction();
			
			claimCiPlatFormException = blCIClaimPlatFormInterfaceAction.upload(dbManager, registType, businessNo,serlalNo, isImmediately,cIPlatformConfigDto,uploadWay,payRefNo,policyNo);
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
	
	
	public final void upload(DBManager dbManager,String registType,String businessNo,boolean isImmediately,CIPlatformConfigDto cIPlatformConfigDto,String uploadWay,String payRefNo) throws ClaimCiPlatFormException,Exception{
		ClaimCiPlatFormException claimCiPlatFormException = null;
		try {
			BLCIClaimPlatFormInterfaceAction blCIClaimPlatFormInterfaceAction = BLCIClaimPlatFormInterfaceAction.getInstance();
			
			claimCiPlatFormException = blCIClaimPlatFormInterfaceAction.upload(dbManager, registType, businessNo, isImmediately,cIPlatformConfigDto,uploadWay,payRefNo);
			if(claimCiPlatFormException!=null){
				throw claimCiPlatFormException;
			}
		}  catch (Exception e) {			
			//e.printStackTrace();
			throw e;
		} finally{
		}

	}
/*	public final void batchTransport() throws ClaimCiPlatFormException,Exception{
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
	}*/

}
