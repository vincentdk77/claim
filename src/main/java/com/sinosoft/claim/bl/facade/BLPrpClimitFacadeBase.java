package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpClimitAction;
import com.sinosoft.claim.dto.domain.PrpClimitDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpClimit的业务逻辑对象Facade基类<br>
 * 创建于 2006-06-09 15:31:33.828<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpClimitFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpClimitFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpClimitFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpClimitDto prpClimitDto
     * @throws Exception
     */
    public void insert(PrpClimitDto prpClimitDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpClimitAction blPrpClimitAction = new BLPrpClimitAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //插入记录
            blPrpClimitAction.insert(dbManager,prpClimitDto);
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
     * @param policyNo PolicyNo
     * @param limitGrade LimitGrade
     * @param limitNo LimitNo
     * @param limitType LimitType
     * @param currency Currency
     * @throws Exception
     */
    public void delete(String policyNo,String limitGrade,double limitNo,String limitType,String currency) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpClimitAction blPrpClimitAction = new BLPrpClimitAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //删除记录
            blPrpClimitAction.delete(dbManager,policyNo, limitGrade, limitNo, limitType, currency);
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
    public void deleteByConditions(String conditions) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpClimitAction blPrpClimitAction = new BLPrpClimitAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpClimitAction.deleteByConditions(dbManager,conditions);
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
     * @param prpClimitDto prpClimitDto
     * @throws Exception
     */
    public void update(PrpClimitDto prpClimitDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpClimitAction blPrpClimitAction = new BLPrpClimitAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //更新记录
            blPrpClimitAction.update(dbManager,prpClimitDto);
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
     * @param policyNo PolicyNo
     * @param limitGrade LimitGrade
     * @param limitNo LimitNo
     * @param limitType LimitType
     * @param currency Currency
     * @return prpClimitDto prpClimitDto
     * @throws Exception
     */
    public PrpClimitDto findByPrimaryKey(String policyNo,String limitGrade,double limitNo,String limitType,String currency) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpClimitAction blPrpClimitAction = new BLPrpClimitAction();
        //声明DTO
        PrpClimitDto prpClimitDto = null;
        try{
            dbManager.open("claimDataSource");
            //查询数据,赋值给DTO
            prpClimitDto = blPrpClimitAction.findByPrimaryKey(dbManager,policyNo, limitGrade, limitNo, limitType, currency);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpClimitDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpClimitAction blPrpClimitAction = new BLPrpClimitAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blPrpClimitAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpClimitDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpClimitAction blPrpClimitAction = new BLPrpClimitAction();
        try{
            dbManager.open("claimDataSource");
            collection = blPrpClimitAction.findByConditions(dbManager,conditions);
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
        BLPrpClimitAction blPrpClimitAction = new BLPrpClimitAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blPrpClimitAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
