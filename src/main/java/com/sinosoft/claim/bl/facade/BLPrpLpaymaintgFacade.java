package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;

import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.bl.action.domain.BLPrpLpaymaintgAction;

/**
 * 这是支付信息主表的业务对象Facade类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpaymaintgFacade extends BLPrpLpaymaintgFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLpaymaintgFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLpaymaintgFacade(){
        super();
    }
    
    /**
     * 根据收付编号更新支付状态 add by zhongfen
     * @param paymentNo 收付编号
     * @param vflag 支付状态
     * @throws Exception
     */
    public void updateByKey(String paymentNo,String vflag)throws Exception{
    	DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLpaymaintgAction.updateByKey(dbManager,paymentNo,vflag);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    	
    }
    
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findPayQueryByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymaintgAction.findPayQueryByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord queryThirdPayByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymaintgAction.queryThirdPayByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findPayQueryByConditionsNew(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymaintgAction.findPayQueryByConditionsNew(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    
    /**
     * 根据收付编号更新第三方支付状态 add by zhongfen
     * @param paymentNo 收付编号
     * @param thirdPayFlag 支付状态
     * @throws Exception
     */
    public void updateThirdPayFlag(String paymentNo,String thirdPayFlag)throws Exception{
    	DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLpaymaintgAction.updateThirdPayFlag(dbManager,paymentNo,thirdPayFlag);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    	
    }
    
    /**
     * 根据收付编号更新第三方支付状态 add by zhongfen
     * @param paymentNo 收付编号
     * @param thirdPayFlag 支付状态
     * @throws Exception
     */
    public void updateVflagAndThirdPayFlag(String paymentNo,String vflag,String thirdPayFlag)throws Exception{
    	DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLpaymaintgAction.updateVflagAndThirdPayFlag(dbManager, paymentNo, vflag, thirdPayFlag);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    	
    }

	public PageRecord findPayQueryByConditionsBack(String conditions,String conditions1,
			int pageNo, int rowsPerPage) throws Exception {
		PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymaintgAction.findPayQueryByConditionsBack(dbManager,conditions,conditions1,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
	}
	
	/**
     * 获取支付情况统计信息
     * @param conditions
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
    public PageRecord findPayStatisticsByConditions(String conditions,int pageNo,int rowsPerPage)throws Exception{
    	PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymaintgAction.findPayStatisticsByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    
    /**
     * 获取支付统计信息数量
     * @return
     * @throws Exception
     */
    public int getPayStatisticsCount(String conditions)throws Exception{
    	if(conditions.trim().length()==0){
            conditions = "1=1";
        }
    	int count=0;
        DBManager dbManager = new DBManager();
        BLPrpLpaymaintgAction blPrpLpaymaintgAction = new BLPrpLpaymaintgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            count = blPrpLpaymaintgAction.getPayStatisticsCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    	return count;
    }
}
