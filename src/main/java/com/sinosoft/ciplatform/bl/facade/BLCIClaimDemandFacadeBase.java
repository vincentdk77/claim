package com.sinosoft.ciplatform.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.ciplatform.bl.action.domain.BLCIClaimDemandAction;
import com.sinosoft.ciplatform.dto.domain.CIClaimDemandDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是理赔平台查询表的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIClaimDemandFacadeBase{
    private static Logger logger = Logger.getLogger(BLCIClaimDemandFacadeBase.class);

    /**
     * 构造函数
     */
    public BLCIClaimDemandFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param cIClaimDemandDto cIClaimDemandDto
     * @throws Exception
     */
    public void insert(CIClaimDemandDto cIClaimDemandDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCIClaimDemandAction blCIClaimDemandAction = new BLCIClaimDemandAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //插入记录
            blCIClaimDemandAction.insert(dbManager,cIClaimDemandDto);
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
     * @param claimCode 理赔编码
     * @throws Exception
     */
    public void delete(String claimCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCIClaimDemandAction blCIClaimDemandAction = new BLCIClaimDemandAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //删除记录
            blCIClaimDemandAction.delete(dbManager,claimCode);
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
        BLCIClaimDemandAction blCIClaimDemandAction = new BLCIClaimDemandAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //按条件删除记录
            blCIClaimDemandAction.deleteByConditions(dbManager,conditions);
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
     * @param cIClaimDemandDto cIClaimDemandDto
     * @throws Exception
     */
    public void update(CIClaimDemandDto cIClaimDemandDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCIClaimDemandAction blCIClaimDemandAction = new BLCIClaimDemandAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //更新记录
            blCIClaimDemandAction.update(dbManager,cIClaimDemandDto);
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
     * @param claimCode 理赔编码
     * @return cIClaimDemandDto cIClaimDemandDto
     * @throws Exception
     */
    public CIClaimDemandDto findByPrimaryKey(String claimCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCIClaimDemandAction blCIClaimDemandAction = new BLCIClaimDemandAction();
        //声明DTO
        CIClaimDemandDto cIClaimDemandDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            //查询数据,赋值给DTO
            cIClaimDemandDto = blCIClaimDemandAction.findByPrimaryKey(dbManager,claimCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return cIClaimDemandDto;
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
        BLCIClaimDemandAction blCIClaimDemandAction = new BLCIClaimDemandAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            pageRecord = blCIClaimDemandAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含cIClaimDemandDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCIClaimDemandAction blCIClaimDemandAction = new BLCIClaimDemandAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            collection = blCIClaimDemandAction.findByConditions(dbManager,conditions);
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
        BLCIClaimDemandAction blCIClaimDemandAction = new BLCIClaimDemandAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            rowCount = blCIClaimDemandAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
