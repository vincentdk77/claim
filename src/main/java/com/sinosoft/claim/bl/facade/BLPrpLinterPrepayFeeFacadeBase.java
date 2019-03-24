package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLinterPrepayFeeAction;
import com.sinosoft.claim.dto.domain.PrpLinterPrepayFeeDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是预赔费用信息表的业务逻辑对象Facade基类<br>
 */
public class BLPrpLinterPrepayFeeFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPrepayFeeFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterPrepayFeeFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLinterPrepayFeeDto prpLinterPrepayFeeDto
     * @throws Exception
     */
    public void insert(PrpLinterPrepayFeeDto prpLinterPrepayFeeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPrepayFeeAction blPrpLinterPrepayFeeAction = new BLPrpLinterPrepayFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLinterPrepayFeeAction.insert(dbManager,prpLinterPrepayFeeDto);
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
     * @param id 主键 PK
     * @throws Exception
     */
    public void delete(String id)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPrepayFeeAction blPrpLinterPrepayFeeAction = new BLPrpLinterPrepayFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLinterPrepayFeeAction.delete(dbManager,id);
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
        BLPrpLinterPrepayFeeAction blPrpLinterPrepayFeeAction = new BLPrpLinterPrepayFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLinterPrepayFeeAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLinterPrepayFeeDto prpLinterPrepayFeeDto
     * @throws Exception
     */
    public void update(PrpLinterPrepayFeeDto prpLinterPrepayFeeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPrepayFeeAction blPrpLinterPrepayFeeAction = new BLPrpLinterPrepayFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLinterPrepayFeeAction.update(dbManager,prpLinterPrepayFeeDto);
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
     * @param id 主键 PK
     * @return prpLinterPrepayFeeDto prpLinterPrepayFeeDto
     * @throws Exception
     */
    public PrpLinterPrepayFeeDto findByPrimaryKey(String id)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPrepayFeeAction blPrpLinterPrepayFeeAction = new BLPrpLinterPrepayFeeAction();
        //声明DTO
        PrpLinterPrepayFeeDto prpLinterPrepayFeeDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLinterPrepayFeeDto = blPrpLinterPrepayFeeAction.findByPrimaryKey(dbManager,id);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLinterPrepayFeeDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinterPrepayFeeAction blPrpLinterPrepayFeeAction = new BLPrpLinterPrepayFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLinterPrepayFeeAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLinterPrepayFeeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinterPrepayFeeAction blPrpLinterPrepayFeeAction = new BLPrpLinterPrepayFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinterPrepayFeeAction.findByConditions(dbManager,conditions);
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
        BLPrpLinterPrepayFeeAction blPrpLinterPrepayFeeAction = new BLPrpLinterPrepayFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLinterPrepayFeeAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
