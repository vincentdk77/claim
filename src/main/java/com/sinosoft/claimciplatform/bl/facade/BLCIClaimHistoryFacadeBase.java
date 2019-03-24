package com.sinosoft.claimciplatform.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.bl.action.domain.BLCIClaimHistoryAction;
import com.sinosoft.claimciplatform.dto.custom.HistoryClaim;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是理赔信息上传平台历次赔付信息表的业务逻辑对象Facade基类<br>
 * 创建于 2010-03-30
 */
public class BLCIClaimHistoryFacadeBase {
	private static Log logger = LogFactory.getLog(BLCIClaimHistoryFacadeBase.class);

    /**
     * 构造函数
     */
    public BLCIClaimHistoryFacadeBase(){
    }
    
    /**
     * 插入一条数据
     * @param HistoryClaim historyClaim
     * @throws Exception
     */
    public void insert(HistoryClaim historyClaim)throws Exception{
    	DBManager dbManager = new DBManager();
    	BLCIClaimHistoryAction blCIClaimHistoryAction = new BLCIClaimHistoryAction();
    	try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blCIClaimHistoryAction.insert(dbManager,historyClaim);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    /**
     * 按主键删除一条数据
     * @param claimCode 理赔编码
     * @param serialNo 顺序号
     * @throws Exception
     */
    public void delete(String claimCode,int serialNo)
    throws Exception{
    	DBManager dbManager = new DBManager();
    	BLCIClaimHistoryAction blCIClaimHistoryAction = new BLCIClaimHistoryAction();
    	try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blCIClaimHistoryAction.delete(dbManager,claimCode, serialNo);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    /**
     * 按条件删除数据
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(String conditions)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCIClaimHistoryAction blCIClaimHistoryAction = new BLCIClaimHistoryAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blCIClaimHistoryAction.deleteByConditions(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param HistoryClaim historyClaim
     * @throws Exception
     */
    public void update(HistoryClaim historyClaim)throws Exception{
    	DBManager dbManager = new DBManager();
        BLCIClaimHistoryAction blCIClaimHistoryAction = new BLCIClaimHistoryAction();
    	try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blCIClaimHistoryAction.update(dbManager,historyClaim);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    /**
     * 按主键查找一条数据
     * @param claimCode 理赔编码
     * @param serialNo 序号
     * @return HistoryClaim historyClaim
     * @throws Exception
     */
    public HistoryClaim findByPrimaryKey(String claimCode,int serialNo)
    throws Exception{
    	DBManager dbManager = new DBManager();
        BLCIClaimHistoryAction blCIClaimHistoryAction = new BLCIClaimHistoryAction();
    	
    	HistoryClaim historyClaim = null;
    	
    	try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            historyClaim = blCIClaimHistoryAction.findByPrimaryKey(dbManager,claimCode, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return historyClaim;
    }
    
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions, int pageNo,
			int rowsPerPage) throws Exception {
		PageRecord pageRecord = new PageRecord(0, pageNo, 1, rowsPerPage,
				new ArrayList());

		if (conditions.trim().length() == 0) {
			conditions = "1=1";
		}

		DBManager dbManager = new DBManager();
        BLCIClaimHistoryAction blCIClaimHistoryAction = new BLCIClaimHistoryAction();
		try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blCIClaimHistoryAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含historyClaim的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCIClaimHistoryAction blCIClaimHistoryAction = new BLCIClaimHistoryAction();
        
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blCIClaimHistoryAction.findByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
    
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int rowCount=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCIClaimHistoryAction blCIClaimHistoryAction = new BLCIClaimHistoryAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blCIClaimHistoryAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
}
