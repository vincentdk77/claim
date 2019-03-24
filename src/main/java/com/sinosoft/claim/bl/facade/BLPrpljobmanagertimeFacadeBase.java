package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpljobmanagertimeDto;
import com.sinosoft.claim.bl.action.domain.BLPrpljobmanagertimeAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLJOBMANAGERTIME的业务逻辑对象Facade基类<br>
 */
public class BLPrpljobmanagertimeFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpljobmanagertimeFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpljobmanagertimeFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpljobmanagertimeDto prpljobmanagertimeDto
     * @throws Exception
     */
    public void insert(PrpljobmanagertimeDto prpljobmanagertimeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpljobmanagertimeAction blPrpljobmanagertimeAction = new BLPrpljobmanagertimeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpljobmanagertimeAction.insert(dbManager,prpljobmanagertimeDto);
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
     * @param fid FID
     * @throws Exception
     */
    public void delete(String fid)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpljobmanagertimeAction blPrpljobmanagertimeAction = new BLPrpljobmanagertimeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpljobmanagertimeAction.delete(dbManager,fid);
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
        BLPrpljobmanagertimeAction blPrpljobmanagertimeAction = new BLPrpljobmanagertimeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpljobmanagertimeAction.deleteByConditions(dbManager,conditions);
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
     * @param prpljobmanagertimeDto prpljobmanagertimeDto
     * @throws Exception
     */
    public void update(PrpljobmanagertimeDto prpljobmanagertimeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpljobmanagertimeAction blPrpljobmanagertimeAction = new BLPrpljobmanagertimeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpljobmanagertimeAction.update(dbManager,prpljobmanagertimeDto);
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
     * @param fid FID
     * @return prpljobmanagertimeDto prpljobmanagertimeDto
     * @throws Exception
     */
    public PrpljobmanagertimeDto findByPrimaryKey(String fid)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpljobmanagertimeAction blPrpljobmanagertimeAction = new BLPrpljobmanagertimeAction();
        //声明DTO
        PrpljobmanagertimeDto prpljobmanagertimeDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpljobmanagertimeDto = blPrpljobmanagertimeAction.findByPrimaryKey(dbManager,fid);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpljobmanagertimeDto;
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
        BLPrpljobmanagertimeAction blPrpljobmanagertimeAction = new BLPrpljobmanagertimeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpljobmanagertimeAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpljobmanagertimeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpljobmanagertimeAction blPrpljobmanagertimeAction = new BLPrpljobmanagertimeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpljobmanagertimeAction.findByConditions(dbManager,conditions);
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
        BLPrpljobmanagertimeAction blPrpljobmanagertimeAction = new BLPrpljobmanagertimeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpljobmanagertimeAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
