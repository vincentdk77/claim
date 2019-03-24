package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLinterAccdentPersonAction;
import com.sinosoft.claim.dto.domain.PrpLinterAccdentPersonDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是理算接口事故者信息的业务逻辑对象Facade基类<br>
 */
public class BLPrpLinterAccdentPersonFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterAccdentPersonFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterAccdentPersonFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLinterAccdentPersonDto prpLinterAccdentPersonDto
     * @throws Exception
     */
    public void insert(PrpLinterAccdentPersonDto prpLinterAccdentPersonDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterAccdentPersonAction blPrpLinterAccdentPersonAction = new BLPrpLinterAccdentPersonAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLinterAccdentPersonAction.insert(dbManager,prpLinterAccdentPersonDto);
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
        BLPrpLinterAccdentPersonAction blPrpLinterAccdentPersonAction = new BLPrpLinterAccdentPersonAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLinterAccdentPersonAction.delete(dbManager,id);
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
        BLPrpLinterAccdentPersonAction blPrpLinterAccdentPersonAction = new BLPrpLinterAccdentPersonAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLinterAccdentPersonAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLinterAccdentPersonDto prpLinterAccdentPersonDto
     * @throws Exception
     */
    public void update(PrpLinterAccdentPersonDto prpLinterAccdentPersonDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterAccdentPersonAction blPrpLinterAccdentPersonAction = new BLPrpLinterAccdentPersonAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLinterAccdentPersonAction.update(dbManager,prpLinterAccdentPersonDto);
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
     * @return prpLinterAccdentPersonDto prpLinterAccdentPersonDto
     * @throws Exception
     */
    public PrpLinterAccdentPersonDto findByPrimaryKey(String id)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterAccdentPersonAction blPrpLinterAccdentPersonAction = new BLPrpLinterAccdentPersonAction();
        //声明DTO
        PrpLinterAccdentPersonDto prpLinterAccdentPersonDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLinterAccdentPersonDto = blPrpLinterAccdentPersonAction.findByPrimaryKey(dbManager,id);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLinterAccdentPersonDto;
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
        BLPrpLinterAccdentPersonAction blPrpLinterAccdentPersonAction = new BLPrpLinterAccdentPersonAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLinterAccdentPersonAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLinterAccdentPersonDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinterAccdentPersonAction blPrpLinterAccdentPersonAction = new BLPrpLinterAccdentPersonAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinterAccdentPersonAction.findByConditions(dbManager,conditions);
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
        BLPrpLinterAccdentPersonAction blPrpLinterAccdentPersonAction = new BLPrpLinterAccdentPersonAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLinterAccdentPersonAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
