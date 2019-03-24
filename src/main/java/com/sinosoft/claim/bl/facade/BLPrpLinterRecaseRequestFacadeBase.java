package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterRecaseRequestAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是大病医疗接口重开赔案参数中间表的业务逻辑对象Facade基类<br>
 */
public class BLPrpLinterRecaseRequestFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterRecaseRequestFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterRecaseRequestFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLinterRecaseRequestDto prpLinterRecaseRequestDto
     * @throws Exception
     */
    public void insert(PrpLinterRecaseRequestDto prpLinterRecaseRequestDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterRecaseRequestAction blPrpLinterRecaseRequestAction = new BLPrpLinterRecaseRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLinterRecaseRequestAction.insert(dbManager,prpLinterRecaseRequestDto);
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
     * @param id 主键id PK
     * @throws Exception
     */
    public void delete(String id)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterRecaseRequestAction blPrpLinterRecaseRequestAction = new BLPrpLinterRecaseRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLinterRecaseRequestAction.delete(dbManager,id);
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
        BLPrpLinterRecaseRequestAction blPrpLinterRecaseRequestAction = new BLPrpLinterRecaseRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLinterRecaseRequestAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLinterRecaseRequestDto prpLinterRecaseRequestDto
     * @throws Exception
     */
    public void update(PrpLinterRecaseRequestDto prpLinterRecaseRequestDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterRecaseRequestAction blPrpLinterRecaseRequestAction = new BLPrpLinterRecaseRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLinterRecaseRequestAction.update(dbManager,prpLinterRecaseRequestDto);
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
     * @param id 主键id PK
     * @return prpLinterRecaseRequestDto prpLinterRecaseRequestDto
     * @throws Exception
     */
    public PrpLinterRecaseRequestDto findByPrimaryKey(String id)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterRecaseRequestAction blPrpLinterRecaseRequestAction = new BLPrpLinterRecaseRequestAction();
        //声明DTO
        PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLinterRecaseRequestDto = blPrpLinterRecaseRequestAction.findByPrimaryKey(dbManager,id);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLinterRecaseRequestDto;
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
        BLPrpLinterRecaseRequestAction blPrpLinterRecaseRequestAction = new BLPrpLinterRecaseRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLinterRecaseRequestAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLinterRecaseRequestDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinterRecaseRequestAction blPrpLinterRecaseRequestAction = new BLPrpLinterRecaseRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinterRecaseRequestAction.findByConditions(dbManager,conditions);
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
        BLPrpLinterRecaseRequestAction blPrpLinterRecaseRequestAction = new BLPrpLinterRecaseRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLinterRecaseRequestAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
