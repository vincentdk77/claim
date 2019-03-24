package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrplaccidangersdAction;
import com.sinosoft.claim.dto.domain.PrplaccidangersdDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLACCIDANGERSD的业务逻辑对象Facade基类<br>
 */
public class BLPrplaccidangersdFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplaccidangersdFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrplaccidangersdFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prplaccidangersdDto prplaccidangersdDto
     * @throws Exception
     */
    public void insert(PrplaccidangersdDto prplaccidangersdDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplaccidangersdAction blPrplaccidangersdAction = new BLPrplaccidangersdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrplaccidangersdAction.insert(dbManager,prplaccidangersdDto);
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
     * @param insuredname INSUREDNAME
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(String insuredname,int serialno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplaccidangersdAction blPrplaccidangersdAction = new BLPrplaccidangersdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrplaccidangersdAction.delete(dbManager,insuredname, serialno);
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
        BLPrplaccidangersdAction blPrplaccidangersdAction = new BLPrplaccidangersdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrplaccidangersdAction.deleteByConditions(dbManager,conditions);
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
     * @param prplaccidangersdDto prplaccidangersdDto
     * @throws Exception
     */
    public void update(PrplaccidangersdDto prplaccidangersdDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplaccidangersdAction blPrplaccidangersdAction = new BLPrplaccidangersdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrplaccidangersdAction.update(dbManager,prplaccidangersdDto);
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
     * @param insuredname INSUREDNAME
     * @param serialno SERIALNO
     * @return prplaccidangersdDto prplaccidangersdDto
     * @throws Exception
     */
    public PrplaccidangersdDto findByPrimaryKey(String insuredname,int serialno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplaccidangersdAction blPrplaccidangersdAction = new BLPrplaccidangersdAction();
        //声明DTO
        PrplaccidangersdDto prplaccidangersdDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prplaccidangersdDto = blPrplaccidangersdAction.findByPrimaryKey(dbManager,insuredname, serialno);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplaccidangersdDto;
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
        BLPrplaccidangersdAction blPrplaccidangersdAction = new BLPrplaccidangersdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplaccidangersdAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prplaccidangersdDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplaccidangersdAction blPrplaccidangersdAction = new BLPrplaccidangersdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplaccidangersdAction.findByConditions(dbManager,conditions);
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
        BLPrplaccidangersdAction blPrplaccidangersdAction = new BLPrplaccidangersdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplaccidangersdAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
