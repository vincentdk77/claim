package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplreturnvisitDto;
import com.sinosoft.claim.bl.action.domain.BLPrplreturnvisitAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLRETURNVISIT的业务逻辑对象Facade基类<br>
 */
public class BLPrplreturnvisitFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplreturnvisitFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrplreturnvisitFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prplreturnvisitDto prplreturnvisitDto
     * @throws Exception
     */
    public void insert(PrplreturnvisitDto prplreturnvisitDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplreturnvisitAction blPrplreturnvisitAction = new BLPrplreturnvisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrplreturnvisitAction.insert(dbManager,prplreturnvisitDto);
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
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(String registno,String serialno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplreturnvisitAction blPrplreturnvisitAction = new BLPrplreturnvisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrplreturnvisitAction.delete(dbManager,registno, serialno);
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
        BLPrplreturnvisitAction blPrplreturnvisitAction = new BLPrplreturnvisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrplreturnvisitAction.deleteByConditions(dbManager,conditions);
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
     * @param prplreturnvisitDto prplreturnvisitDto
     * @throws Exception
     */
    public void update(PrplreturnvisitDto prplreturnvisitDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplreturnvisitAction blPrplreturnvisitAction = new BLPrplreturnvisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrplreturnvisitAction.update(dbManager,prplreturnvisitDto);
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
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @return prplreturnvisitDto prplreturnvisitDto
     * @throws Exception
     */
    public PrplreturnvisitDto findByPrimaryKey(String registno,String serialno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplreturnvisitAction blPrplreturnvisitAction = new BLPrplreturnvisitAction();
        //声明DTO
        PrplreturnvisitDto prplreturnvisitDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prplreturnvisitDto = blPrplreturnvisitAction.findByPrimaryKey(dbManager,registno, serialno);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplreturnvisitDto;
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
        BLPrplreturnvisitAction blPrplreturnvisitAction = new BLPrplreturnvisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplreturnvisitAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prplreturnvisitDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplreturnvisitAction blPrplreturnvisitAction = new BLPrplreturnvisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplreturnvisitAction.findByConditions(dbManager,conditions);
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
        BLPrplreturnvisitAction blPrplreturnvisitAction = new BLPrplreturnvisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplreturnvisitAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
