package com.gyic.claim.bl.facade;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.HerdsettlelistDto;
import com.gyic.claim.bl.action.domain.BLHerdsettlelistAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是HERDSETTLELIST的业务逻辑对象Facade基类<br>
 */
public class BLHerdsettlelistFacadeBase{
    private static Logger logger = Logger.getLogger(BLHerdsettlelistFacadeBase.class);

    /**
     * 构造函数
     */
    public BLHerdsettlelistFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param herdsettlelistDto herdsettlelistDto
     * @throws Exception
     */
    public void insert(HerdsettlelistDto herdsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHerdsettlelistAction blHerdsettlelistAction = new BLHerdsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //插入记录
            blHerdsettlelistAction.insert(dbManager,herdsettlelistDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    /**
     * 插入多条数据
     * @param herdsettlelistDto herdsettlelistDto
     * @throws Exception
     */
    public void insertAll(List list)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHerdsettlelistAction blHerdsettlelistAction = new BLHerdsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //插入记录
            blHerdsettlelistAction.insertAll(dbManager,list);
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
     * @param settlelistcode SETTLELISTCODE
     * @param earlabel EARLABEL
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(String settlelistcode,String earlabel,String fcode,String kindcode,int serialno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHerdsettlelistAction blHerdsettlelistAction = new BLHerdsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //删除记录
            blHerdsettlelistAction.delete(dbManager,settlelistcode, earlabel, fcode, kindcode, serialno);
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
        BLHerdsettlelistAction blHerdsettlelistAction = new BLHerdsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blHerdsettlelistAction.deleteByConditions(dbManager,conditions);
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
     * @param herdsettlelistDto herdsettlelistDto
     * @throws Exception
     */
    public void update(HerdsettlelistDto herdsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHerdsettlelistAction blHerdsettlelistAction = new BLHerdsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //更新记录
            blHerdsettlelistAction.update(dbManager,herdsettlelistDto);
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
     * @param settlelistcode SETTLELISTCODE
     * @param earlabel EARLABEL
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param serialno SERIALNO
     * @return herdsettlelistDto herdsettlelistDto
     * @throws Exception
     */
    public HerdsettlelistDto findByPrimaryKey(String settlelistcode,String earlabel,String fcode,String kindcode,int serialno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHerdsettlelistAction blHerdsettlelistAction = new BLHerdsettlelistAction();
        //声明DTO
        HerdsettlelistDto herdsettlelistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //查询数据,赋值给DTO
            herdsettlelistDto = blHerdsettlelistAction.findByPrimaryKey(dbManager,settlelistcode, earlabel, fcode, kindcode, serialno);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return herdsettlelistDto;
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
        BLHerdsettlelistAction blHerdsettlelistAction = new BLHerdsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blHerdsettlelistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含herdsettlelistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLHerdsettlelistAction blHerdsettlelistAction = new BLHerdsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blHerdsettlelistAction.findByConditions(dbManager,conditions);
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
        BLHerdsettlelistAction blHerdsettlelistAction = new BLHerdsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blHerdsettlelistAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
