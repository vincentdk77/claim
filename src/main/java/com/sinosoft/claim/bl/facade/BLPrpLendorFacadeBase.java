package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLendorAction;
import com.sinosoft.claim.dto.domain.PrpLendorDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLendor的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLendorFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLendorFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLendorFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLendorDto prpLendorDto
     * @throws Exception
     */
    public void insert(PrpLendorDto prpLendorDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLendorAction blPrpLendorAction = new BLPrpLendorAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //插入记录
            blPrpLendorAction.insert(dbManager,prpLendorDto);
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
     * @param compensateNo compensateNo
     * @param policyNo policyNo
     * @param itemKindNo itemKindNo
     * @param endorType endorType
     * @throws Exception
     */
    public void delete(String compensateNo,String policyNo,int itemKindNo,String endorType)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLendorAction blPrpLendorAction = new BLPrpLendorAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //删除记录
            blPrpLendorAction.delete(dbManager,compensateNo, policyNo, itemKindNo, endorType);
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
        BLPrpLendorAction blPrpLendorAction = new BLPrpLendorAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLendorAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLendorDto prpLendorDto
     * @throws Exception
     */
    public void update(PrpLendorDto prpLendorDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLendorAction blPrpLendorAction = new BLPrpLendorAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //更新记录
            blPrpLendorAction.update(dbManager,prpLendorDto);
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
     * @param compensateNo compensateNo
     * @param policyNo policyNo
     * @param itemKindNo itemKindNo
     * @param endorType endorType
     * @return prpLendorDto prpLendorDto
     * @throws Exception
     */
    public PrpLendorDto findByPrimaryKey(String compensateNo,String policyNo,int itemKindNo,String endorType)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLendorAction blPrpLendorAction = new BLPrpLendorAction();
        //声明DTO
        PrpLendorDto prpLendorDto = null;
        try{
            dbManager.open("ddccDataSource");
            //查询数据,赋值给DTO
            prpLendorDto = blPrpLendorAction.findByPrimaryKey(dbManager,compensateNo, policyNo, itemKindNo, endorType);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLendorDto;
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
        BLPrpLendorAction blPrpLendorAction = new BLPrpLendorAction();
        try{
            dbManager.open("ddccDataSource");
            pageRecord = blPrpLendorAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLendorDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLendorAction blPrpLendorAction = new BLPrpLendorAction();
        try{
            dbManager.open("ddccDataSource");
            collection = blPrpLendorAction.findByConditions(dbManager,conditions);
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
        BLPrpLendorAction blPrpLendorAction = new BLPrpLendorAction();
        try{
            dbManager.open("ddccDataSource");
            rowCount = blPrpLendorAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
