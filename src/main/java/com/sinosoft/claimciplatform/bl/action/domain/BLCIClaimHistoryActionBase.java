package com.sinosoft.claimciplatform.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.dto.custom.HistoryClaim;
import com.sinosoft.claimciplatform.dto.domain.CIClaimThirdCarDto;
import com.sinosoft.claimciplatform.resource.dtofactory.domain.DBCIClaimHistory;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是理赔信息上传平台三者车赔付信息表的业务逻辑对象类<br>
 * 创建于 2010-03-30
 */
public class BLCIClaimHistoryActionBase {
	private static Log logger = LogFactory.getLog(BLCIClaimHistoryActionBase.class);

    /**
     * 构造函数
     */
    public BLCIClaimHistoryActionBase(){
    }
    
    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param HistoryClaim historyClaim
     * @throws Exception
     */
    public void insert(DBManager dbManager,HistoryClaim historyClaim)throws Exception{
    	DBCIClaimHistory dbCIClaimHistory = new DBCIClaimHistory(dbManager);
    	dbCIClaimHistory.insert(historyClaim);
    }
    
    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param HistoryClaim historyClaim
     * @throws Exception
     */
    public void insertAll(DBManager dbManager,Collection collection)throws Exception{
    	DBCIClaimHistory dbCIClaimHistory = new DBCIClaimHistory(dbManager);
    	dbCIClaimHistory.insertAll(collection);
    }
    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param claimCode 理赔编码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimCode,int serialNo)
            throws Exception{
    	DBCIClaimHistory dbCIClaimHistory = new DBCIClaimHistory(dbManager);
    	dbCIClaimHistory.delete(claimCode, serialNo);
    }
    
    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
    	DBCIClaimHistory dbCIClaimHistory = new DBCIClaimHistory(dbManager);
    	dbCIClaimHistory.deleteByConditions(conditions);
    }
    
    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param HistoryClaim historyClaim
     * @throws Exception
     */
    public void update(DBManager dbManager,HistoryClaim historyClaim)
    		throws Exception{
    	DBCIClaimHistory dbCIClaimHistory = new DBCIClaimHistory(dbManager);
    	dbCIClaimHistory.update(historyClaim);
    }
    
    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param claimCode 理赔编码
     * @param serialNo 顺序号
     * @return HistoryClaim historyClaim
     * @throws Exception
     */
    public HistoryClaim findByPrimaryKey(DBManager dbManager,String claimCode,int serialNo)
    throws Exception{
    	DBCIClaimHistory dbCIClaimHistory = new DBCIClaimHistory(dbManager);
    	HistoryClaim historyClaim = null;
    	
    	historyClaim = dbCIClaimHistory.findByPrimaryKey(claimCode, serialNo);
    	
    	return historyClaim;
    }
    
    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
    	throws Exception{
    	DBCIClaimHistory dbCIClaimHistory = new DBCIClaimHistory(dbManager);
    	
    	Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        int count = dbCIClaimHistory.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbCIClaimHistory.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    
    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含cIClaimUploadLogDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
    	throws Exception{
    	DBCIClaimHistory dbCIClaimHistory = new DBCIClaimHistory(dbManager);
    	Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCIClaimHistory.findByConditions(conditions);
        return collection;
    }
    
    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
    throws Exception{
    	DBCIClaimHistory dbCIClaimHistory = new DBCIClaimHistory(dbManager);
    	if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIClaimHistory.getCount(conditions);
        return count;
    }
    
    
}
