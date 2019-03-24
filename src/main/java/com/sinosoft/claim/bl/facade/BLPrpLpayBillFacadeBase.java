package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLpayBillAction;
import com.sinosoft.claim.dto.domain.PrpLpayBillDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是prpLpayBill的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayBillFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayBillFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLpayBillFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLpayBillDto prpLpayBillDto
     * @throws Exception
     */
    public void insert(PrpLpayBillDto prpLpayBillDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLpayBillAction.insert(dbManager,prpLpayBillDto);
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
     * @param paymentNo paymentNo
     * @param registNo registNo
     * @param compensateNo compensateNo
     * @param serialNo serialNo
     * @throws Exception
     */
    public void delete(String paymentNo,String registNo,String compensateNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLpayBillAction.delete(dbManager,paymentNo, registNo, compensateNo, serialNo);
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
        BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLpayBillAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLpayBillDto prpLpayBillDto
     * @throws Exception
     */
    public void update(PrpLpayBillDto prpLpayBillDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLpayBillAction.update(dbManager,prpLpayBillDto);
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
     * @param paymentNo paymentNo
     * @param registNo registNo
     * @param compensateNo compensateNo
     * @param serialNo serialNo
     * @return prpLpayBillDto prpLpayBillDto
     * @throws Exception
     */
    public PrpLpayBillDto findByPrimaryKey(String paymentNo,String registNo,String compensateNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
        //声明DTO
        PrpLpayBillDto prpLpayBillDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLpayBillDto = blPrpLpayBillAction.findByPrimaryKey(dbManager,paymentNo, registNo, compensateNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLpayBillDto;
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
        BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpayBillAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLpayBillDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLpayBillAction.findByConditions(dbManager,conditions);
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
        BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLpayBillAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
