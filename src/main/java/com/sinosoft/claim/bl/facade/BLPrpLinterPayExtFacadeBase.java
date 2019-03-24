package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLinterPayExtAction;
import com.sinosoft.claim.dto.domain.PrpLinterPayExtDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是传入参数子表------处理意见的业务逻辑对象Facade基类<br>
 */
public class BLPrpLinterPayExtFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayExtFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterPayExtFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLinterPayExtDto prpLinterPayExtDto
     * @throws Exception
     */
    public void insert(PrpLinterPayExtDto prpLinterPayExtDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayExtAction blPrpLinterPayExtAction = new BLPrpLinterPayExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLinterPayExtAction.insert(dbManager,prpLinterPayExtDto);
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
     * @param serialNo 主键序号 PK
     * @throws Exception
     */
    public void delete(String id,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayExtAction blPrpLinterPayExtAction = new BLPrpLinterPayExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLinterPayExtAction.delete(dbManager,id, serialNo);
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
        BLPrpLinterPayExtAction blPrpLinterPayExtAction = new BLPrpLinterPayExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLinterPayExtAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLinterPayExtDto prpLinterPayExtDto
     * @throws Exception
     */
    public void update(PrpLinterPayExtDto prpLinterPayExtDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayExtAction blPrpLinterPayExtAction = new BLPrpLinterPayExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLinterPayExtAction.update(dbManager,prpLinterPayExtDto);
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
     * @param serialNo 主键序号 PK
     * @return prpLinterPayExtDto prpLinterPayExtDto
     * @throws Exception
     */
    public PrpLinterPayExtDto findByPrimaryKey(String id,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPayExtAction blPrpLinterPayExtAction = new BLPrpLinterPayExtAction();
        //声明DTO
        PrpLinterPayExtDto prpLinterPayExtDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLinterPayExtDto = blPrpLinterPayExtAction.findByPrimaryKey(dbManager,id, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLinterPayExtDto;
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
        BLPrpLinterPayExtAction blPrpLinterPayExtAction = new BLPrpLinterPayExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLinterPayExtAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLinterPayExtDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinterPayExtAction blPrpLinterPayExtAction = new BLPrpLinterPayExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinterPayExtAction.findByConditions(dbManager,conditions);
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
        BLPrpLinterPayExtAction blPrpLinterPayExtAction = new BLPrpLinterPayExtAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLinterPayExtAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
