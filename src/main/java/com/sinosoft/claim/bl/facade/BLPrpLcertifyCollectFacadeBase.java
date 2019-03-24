package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLcertifyCollectAction;
import com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcertifyCollect-单证收集(修改)的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-23 16:36:59.765<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcertifyCollectFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLcertifyCollectFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcertifyCollectFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLcertifyCollectDto prpLcertifyCollectDto
     * @throws Exception
     */
    public void insert(PrpLcertifyCollectDto prpLcertifyCollectDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcertifyCollectAction blPrpLcertifyCollectAction = new BLPrpLcertifyCollectAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //插入记录
            blPrpLcertifyCollectAction.insert(dbManager,prpLcertifyCollectDto);
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
     * @param businessNo 业务号码
     * @param lossItemCode 标的代码
     * @throws Exception
     */
    public void delete(String businessNo,String lossItemCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcertifyCollectAction blPrpLcertifyCollectAction = new BLPrpLcertifyCollectAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //删除记录
            blPrpLcertifyCollectAction.delete(dbManager,businessNo, lossItemCode);
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
        BLPrpLcertifyCollectAction blPrpLcertifyCollectAction = new BLPrpLcertifyCollectAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLcertifyCollectAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLcertifyCollectDto prpLcertifyCollectDto
     * @throws Exception
     */
    public void update(PrpLcertifyCollectDto prpLcertifyCollectDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcertifyCollectAction blPrpLcertifyCollectAction = new BLPrpLcertifyCollectAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //更新记录
            blPrpLcertifyCollectAction.update(dbManager,prpLcertifyCollectDto);
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
     * @param businessNo 业务号码
     * @param lossItemCode 标的代码
     * @return prpLcertifyCollectDto prpLcertifyCollectDto
     * @throws Exception
     */
    public PrpLcertifyCollectDto findByPrimaryKey(String businessNo,String lossItemCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcertifyCollectAction blPrpLcertifyCollectAction = new BLPrpLcertifyCollectAction();
        //声明DTO
        PrpLcertifyCollectDto prpLcertifyCollectDto = null;
        try{
            dbManager.open("claimDataSource");
            //查询数据,赋值给DTO
            prpLcertifyCollectDto = blPrpLcertifyCollectAction.findByPrimaryKey(dbManager,businessNo, lossItemCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLcertifyCollectDto;
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
        BLPrpLcertifyCollectAction blPrpLcertifyCollectAction = new BLPrpLcertifyCollectAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blPrpLcertifyCollectAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLcertifyCollectDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLcertifyCollectAction blPrpLcertifyCollectAction = new BLPrpLcertifyCollectAction();
        try{
            dbManager.open("claimDataSource");
            collection = blPrpLcertifyCollectAction.findByConditions(dbManager,conditions);
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
        BLPrpLcertifyCollectAction blPrpLcertifyCollectAction = new BLPrpLcertifyCollectAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blPrpLcertifyCollectAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
