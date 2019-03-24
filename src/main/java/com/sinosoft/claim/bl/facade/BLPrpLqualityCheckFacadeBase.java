package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLqualityCheckAction;
import com.sinosoft.claim.dto.domain.PrpLqualityCheckDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLqualityCheck-质量评审内容表的业务逻辑对象Facade基类<br>
 * 创建于 2005-04-14 15:56:47.984<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLqualityCheckFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLqualityCheckFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLqualityCheckFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLqualityCheckDto prpLqualityCheckDto
     * @throws Exception
     */
    public void insert(PrpLqualityCheckDto prpLqualityCheckDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLqualityCheckAction blPrpLqualityCheckAction = new BLPrpLqualityCheckAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //插入记录
            blPrpLqualityCheckAction.insert(dbManager,prpLqualityCheckDto);
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
     * @param registNo 报案号码
     * @param qualityCheckType 业务类型
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String registNo,String qualityCheckType,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLqualityCheckAction blPrpLqualityCheckAction = new BLPrpLqualityCheckAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //删除记录
            blPrpLqualityCheckAction.delete(dbManager,registNo, qualityCheckType, serialNo);
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
    public void deleteByConditions(String conditions) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLqualityCheckAction blPrpLqualityCheckAction = new BLPrpLqualityCheckAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLqualityCheckAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLqualityCheckDto prpLqualityCheckDto
     * @throws Exception
     */
    public void update(PrpLqualityCheckDto prpLqualityCheckDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLqualityCheckAction blPrpLqualityCheckAction = new BLPrpLqualityCheckAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //更新记录
            blPrpLqualityCheckAction.update(dbManager,prpLqualityCheckDto);
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
     * @param registNo 报案号码
     * @param qualityCheckType 业务类型
     * @param serialNo 序号
     * @return prpLqualityCheckDto prpLqualityCheckDto
     * @throws Exception
     */
    public PrpLqualityCheckDto findByPrimaryKey(String registNo,String qualityCheckType,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLqualityCheckAction blPrpLqualityCheckAction = new BLPrpLqualityCheckAction();
        //声明DTO
        PrpLqualityCheckDto prpLqualityCheckDto = null;
        try{
            dbManager.open("claimDataSource");
            //查询数据,赋值给DTO
            prpLqualityCheckDto = blPrpLqualityCheckAction.findByPrimaryKey(dbManager,registNo, qualityCheckType, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLqualityCheckDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLqualityCheckAction blPrpLqualityCheckAction = new BLPrpLqualityCheckAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blPrpLqualityCheckAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLqualityCheckDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLqualityCheckAction blPrpLqualityCheckAction = new BLPrpLqualityCheckAction();
        try{
            dbManager.open("claimDataSource");
            collection = blPrpLqualityCheckAction.findByConditions(dbManager,conditions);
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
        BLPrpLqualityCheckAction blPrpLqualityCheckAction = new BLPrpLqualityCheckAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blPrpLqualityCheckAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
