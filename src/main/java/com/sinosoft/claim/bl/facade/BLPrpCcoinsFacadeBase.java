package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpCcoinsAction;
import com.sinosoft.claim.dto.domain.PrpCcoinsDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpCcoins的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpCcoinsFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpCcoinsFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpCcoinsFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpCcoinsDto prpCcoinsDto
     * @throws Exception
     */
    public void insert(PrpCcoinsDto prpCcoinsDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCcoinsAction blPrpCcoinsAction = new BLPrpCcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpCcoinsAction.insert(dbManager,prpCcoinsDto);
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
     * @param policyNo policyNo
     * @param serialNo serialNo
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCcoinsAction blPrpCcoinsAction = new BLPrpCcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpCcoinsAction.delete(dbManager,policyNo, serialNo);
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
        BLPrpCcoinsAction blPrpCcoinsAction = new BLPrpCcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpCcoinsAction.deleteByConditions(dbManager,conditions);
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
     * @param prpCcoinsDto prpCcoinsDto
     * @throws Exception
     */
    public void update(PrpCcoinsDto prpCcoinsDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCcoinsAction blPrpCcoinsAction = new BLPrpCcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpCcoinsAction.update(dbManager,prpCcoinsDto);
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
     * @param policyNo policyNo
     * @param serialNo serialNo
     * @return prpCcoinsDto prpCcoinsDto
     * @throws Exception
     */
    public PrpCcoinsDto findByPrimaryKey(String policyNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCcoinsAction blPrpCcoinsAction = new BLPrpCcoinsAction();
        //声明DTO
        PrpCcoinsDto prpCcoinsDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpCcoinsDto = blPrpCcoinsAction.findByPrimaryKey(dbManager,policyNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpCcoinsDto;
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
        BLPrpCcoinsAction blPrpCcoinsAction = new BLPrpCcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            int count = blPrpCcoinsAction.getRowCount(dbManager,conditions);
            Collection collection = blPrpCcoinsAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
            pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
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
     * @return Collection 包含prpCcoinsDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpCcoinsAction blPrpCcoinsAction = new BLPrpCcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpCcoinsAction.findByConditions(dbManager,conditions,0,0);
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
    public int getRowCount(String conditions) 
        throws Exception{
        int rowCount=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpCcoinsAction blPrpCcoinsAction = new BLPrpCcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpCcoinsAction.getRowCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
