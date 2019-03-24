package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcomplaintDto;
import com.sinosoft.claim.bl.action.domain.BLPrplcomplaintAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLCOMPLAINT的业务逻辑对象Facade基类<br>
 */
public class BLPrplcomplaintFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplcomplaintFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrplcomplaintFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prplcomplaintDto prplcomplaintDto
     * @throws Exception
     */
    public void insert(PrplcomplaintDto prplcomplaintDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcomplaintAction blPrplcomplaintAction = new BLPrplcomplaintAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrplcomplaintAction.insert(dbManager,prplcomplaintDto);
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
     * @param complaintno COMPLAINTNO
     * @throws Exception
     */
    public void delete(String complaintno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcomplaintAction blPrplcomplaintAction = new BLPrplcomplaintAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrplcomplaintAction.delete(dbManager,complaintno);
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
        BLPrplcomplaintAction blPrplcomplaintAction = new BLPrplcomplaintAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrplcomplaintAction.deleteByConditions(dbManager,conditions);
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
     * @param prplcomplaintDto prplcomplaintDto
     * @throws Exception
     */
    public void update(PrplcomplaintDto prplcomplaintDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcomplaintAction blPrplcomplaintAction = new BLPrplcomplaintAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrplcomplaintAction.update(dbManager,prplcomplaintDto);
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
     * @param complaintno COMPLAINTNO
     * @return prplcomplaintDto prplcomplaintDto
     * @throws Exception
     */
    public PrplcomplaintDto findByPrimaryKey(String complaintno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcomplaintAction blPrplcomplaintAction = new BLPrplcomplaintAction();
        //声明DTO
        PrplcomplaintDto prplcomplaintDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prplcomplaintDto = blPrplcomplaintAction.findByPrimaryKey(dbManager,complaintno);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplcomplaintDto;
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
        BLPrplcomplaintAction blPrplcomplaintAction = new BLPrplcomplaintAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplcomplaintAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prplcomplaintDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplcomplaintAction blPrplcomplaintAction = new BLPrplcomplaintAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplcomplaintAction.findByConditions(dbManager,conditions);
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
        BLPrplcomplaintAction blPrplcomplaintAction = new BLPrplcomplaintAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplcomplaintAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
