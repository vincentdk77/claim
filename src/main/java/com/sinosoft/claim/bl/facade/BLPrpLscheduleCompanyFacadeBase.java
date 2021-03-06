package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLscheduleCompanyAction;
import com.sinosoft.claim.dto.domain.PrpLscheduleCompanyDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLscheduleCompany--调度中心提示信息设置表的业务逻辑对象Facade基类<br>
 * 创建于 2005-08-20 17:56:02.106<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLscheduleCompanyFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleCompanyFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLscheduleCompanyFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLscheduleCompanyDto prpLscheduleCompanyDto
     * @throws Exception
     */
    public void insert(PrpLscheduleCompanyDto prpLscheduleCompanyDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleCompanyAction blPrpLscheduleCompanyAction = new BLPrpLscheduleCompanyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //插入记录
            blPrpLscheduleCompanyAction.insert(dbManager,prpLscheduleCompanyDto);
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
     * @param comCode 调度中心机构代码
     * @throws Exception
     */
    public void delete(String comCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleCompanyAction blPrpLscheduleCompanyAction = new BLPrpLscheduleCompanyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //删除记录
            blPrpLscheduleCompanyAction.delete(dbManager,comCode);
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
        BLPrpLscheduleCompanyAction blPrpLscheduleCompanyAction = new BLPrpLscheduleCompanyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLscheduleCompanyAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLscheduleCompanyDto prpLscheduleCompanyDto
     * @throws Exception
     */
    public void update(PrpLscheduleCompanyDto prpLscheduleCompanyDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleCompanyAction blPrpLscheduleCompanyAction = new BLPrpLscheduleCompanyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //更新记录
            blPrpLscheduleCompanyAction.update(dbManager,prpLscheduleCompanyDto);
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
     * @param comCode 调度中心机构代码
     * @return prpLscheduleCompanyDto prpLscheduleCompanyDto
     * @throws Exception
     */
    public PrpLscheduleCompanyDto findByPrimaryKey(String comCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleCompanyAction blPrpLscheduleCompanyAction = new BLPrpLscheduleCompanyAction();
        //声明DTO
        PrpLscheduleCompanyDto prpLscheduleCompanyDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            //查询数据,赋值给DTO
            prpLscheduleCompanyDto = blPrpLscheduleCompanyAction.findByPrimaryKey(dbManager,comCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLscheduleCompanyDto;
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
        BLPrpLscheduleCompanyAction blPrpLscheduleCompanyAction = new BLPrpLscheduleCompanyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            pageRecord = blPrpLscheduleCompanyAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLscheduleCompanyDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLscheduleCompanyAction blPrpLscheduleCompanyAction = new BLPrpLscheduleCompanyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            collection = blPrpLscheduleCompanyAction.findByConditions(dbManager,conditions);
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
        BLPrpLscheduleCompanyAction blPrpLscheduleCompanyAction = new BLPrpLscheduleCompanyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            rowCount = blPrpLscheduleCompanyAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
