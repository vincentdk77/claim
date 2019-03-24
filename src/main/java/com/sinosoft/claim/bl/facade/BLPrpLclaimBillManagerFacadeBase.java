package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLclaimBillManagerAction;
import com.sinosoft.claim.dto.domain.PrpLclaimBillManagerDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLclaimBillManager的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLclaimBillManagerFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLclaimBillManagerFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimBillManagerFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLclaimBillManagerDto prpLclaimBillManagerDto
     * @throws Exception
     */
    public void insert(PrpLclaimBillManagerDto prpLclaimBillManagerDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLclaimBillManagerAction.insert(dbManager,prpLclaimBillManagerDto);
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
     * @param registNo registNo
     * @throws Exception
     */
    public void delete(String registNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLclaimBillManagerAction.delete(dbManager,registNo);
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
        BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLclaimBillManagerAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLclaimBillManagerDto prpLclaimBillManagerDto
     * @throws Exception
     */
    public void update(PrpLclaimBillManagerDto prpLclaimBillManagerDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLclaimBillManagerAction.update(dbManager,prpLclaimBillManagerDto);
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
     * @param registNo registNo
     * @return prpLclaimBillManagerDto prpLclaimBillManagerDto
     * @throws Exception
     */
    public PrpLclaimBillManagerDto findByPrimaryKey(String registNo,String compensateNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
        //声明DTO
        PrpLclaimBillManagerDto prpLclaimBillManagerDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLclaimBillManagerDto = blPrpLclaimBillManagerAction.findByPrimaryKey(dbManager,registNo,compensateNo,serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLclaimBillManagerDto;
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
        BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLclaimBillManagerAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLclaimBillManagerDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLclaimBillManagerAction.findByConditions(dbManager,conditions);
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
        BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLclaimBillManagerAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
