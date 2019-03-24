package com.sinosoft.claim.bl.facade;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.bl.action.domain.BLPrpLclaimBillManagerAction;
import com.sinosoft.claim.dto.domain.PrpLclaimBillManagerDto;

/**
 * 这是PrpLclaimBillManager的业务对象Facade类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLclaimBillManagertgFacade extends BLPrpLclaimBillManagertgFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLclaimBillManagerFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimBillManagertgFacade(){
        super();
    }

	public PageRecord findByConditonSum(String conditions,String editType,String back,int rowsPerPage,int pageNo) throws Exception {
		PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLclaimBillManagerAction.findByConditonSum(dbManager,conditions,editType,back,rowsPerPage,pageNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
	}

	public void update(String registNo, String compensateNo, int serialNo,
			double payAmount, String userCode,String payFlag) throws Exception {
		DBManager dbManager = new DBManager();
        BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLclaimBillManagerAction.update(dbManager,registNo,compensateNo,serialNo,payAmount,userCode,payFlag);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
		
	}

	public PageRecord findByConditonBillSum(String conditions,String editType,int rowsPerPage,int pageNo) throws Exception {
		PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLclaimBillManagerAction.findByConditonBillSum(dbManager,conditions,editType,rowsPerPage,pageNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
	}
	/**
	 * 新农险清单支付审核详细信息查询
	 * @param conditions
	 * @param editType
	 * @param rowsPerPage
	 * @param pageNo
	 * @return
	 * @throws Exception
	 */
	public PageRecord findByConditonBillSumNew(String conditions,String editType,int rowsPerPage,int pageNo,boolean wtFlag) throws Exception {
		PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
		
		if(conditions.trim().length()==0){
			conditions = "1=1";
		}
		
		DBManager dbManager = new DBManager();
		BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			pageRecord = blPrpLclaimBillManagerAction.findByConditonBillSumNew(dbManager,conditions,editType,rowsPerPage,pageNo,wtFlag);
		}catch(Exception exception){
			throw exception;
		}finally{
			dbManager.close();
		}
		return pageRecord;
	}
	
	public void nyxToclaimBillManager(String compensateNo) throws Exception{
		DBManager dbManager = new DBManager();
        BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLclaimBillManagerAction.nyxToclaimBillManager(dbManager, compensateNo);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
	}
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getMaxSerialNo(String conditions) 
        throws Exception{
        int rowCount=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLclaimBillManagerAction.getMaxSerialNo(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
