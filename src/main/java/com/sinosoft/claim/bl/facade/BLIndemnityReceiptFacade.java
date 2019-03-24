package com.sinosoft.claim.bl.facade;

import com.sinosoft.claim.bl.action.custom.BLVisaAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLIndemnityReceiptAction;
import com.sinosoft.claim.dto.domain.PrpLIndemnityReceiptDto;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLIndemnityReceiptFacade {
	BLPrpLIndemnityReceiptAction blPrpLIndemnityReceiptAction = new BLPrpLIndemnityReceiptAction();
	BLVisaAction blVisaAction = new BLVisaAction();
	
	/**
	 * 注销单证号 
	 * @param visaCode
	 * @param visaName
	 * @param printNo
	 * @param compensateNo
	 * @param userCode
	 * @param userName
	 * @throws Exception
	 */
	public void doUseVisa(String visaCode,String visaName,String printNo,String compensateNo,String userCode,String userName) throws UserException,Exception{
		DBManager dbManager = null;
		try{
			dbManager = getDBManager();
			dbManager.beginTransaction();
			//首先更新单证使用状态
			blVisaAction.doUsed(dbManager,visaCode,printNo,compensateNo,userCode,userName);

			//再更新本计算书存储的单证信息
			PrpLIndemnityReceiptDto prpLIndemnityReceiptDto = blPrpLIndemnityReceiptAction.findByPrimaryKey(dbManager,compensateNo);
			prpLIndemnityReceiptDto.setVisaCode(visaCode);
			prpLIndemnityReceiptDto.setVisaName(visaName);
			prpLIndemnityReceiptDto.setPrintNo(printNo);			
			blPrpLIndemnityReceiptAction.update(dbManager,prpLIndemnityReceiptDto);
			
			dbManager.commitTransaction();
		}catch(UserException ue){
			dbManager.rollbackTransaction();
			throw ue;
		}catch(Exception exception){
			dbManager.rollbackTransaction();
			throw exception;
		}finally{
			dbManager.close();
		}
	}
	/**
	 * 作废单证号
	 * @param visaCode
	 * @param visaName
	 * @param printNo
	 * @param compensateNo
	 * @param userCode
	 * @param userName
	 * @throws UserException
	 * @throws Exception
	 */
	public void doAnnerVisa(String compensateNo,String userCode,String userName) throws UserException,Exception{
		DBManager dbManager = null;
		try{
			dbManager = getDBManager();
			dbManager.beginTransaction();
			
			PrpLIndemnityReceiptDto prpLIndemnityReceiptDto = blPrpLIndemnityReceiptAction.findByPrimaryKey(dbManager,compensateNo);
			
			//先作废证单证
			blVisaAction.doAnnul(dbManager,prpLIndemnityReceiptDto.getVisaCode(),prpLIndemnityReceiptDto.getPrintNo(),userCode,userName);

			//再更新本计算书存储的单证信息
			prpLIndemnityReceiptDto.setVisaCode(null);
			prpLIndemnityReceiptDto.setVisaName(null);
			prpLIndemnityReceiptDto.setPrintNo(null);			
			blPrpLIndemnityReceiptAction.update(dbManager,prpLIndemnityReceiptDto);
			
			dbManager.commitTransaction();
		}catch(UserException ue){
			dbManager.rollbackTransaction();
			throw ue;
		}catch(Exception exception){
			dbManager.rollbackTransaction();
			throw exception;
		}finally{
			dbManager.close();
		}
	}
	
    private DBManager getDBManager() throws Exception{
    	DBManager dbManager = new DBManager();
    	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
    	return dbManager;
    }
}
