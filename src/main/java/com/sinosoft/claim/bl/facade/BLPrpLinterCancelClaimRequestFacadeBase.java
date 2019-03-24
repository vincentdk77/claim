package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLinterCancelClaimRequestAction;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是立案注销传入参主数的业务逻辑对象Facade基类<br>
 */
public class BLPrpLinterCancelClaimRequestFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCancelClaimRequestFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterCancelClaimRequestFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto
     * @throws Exception
     */
    public void insert(PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCancelClaimRequestAction blPrpLinterCancelClaimRequestAction = new BLPrpLinterCancelClaimRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLinterCancelClaimRequestAction.insert(dbManager,prpLinterCancelClaimRequestDto);
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
     * @param id 主键id PK
     * @throws Exception
     */
    public void delete(String id)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCancelClaimRequestAction blPrpLinterCancelClaimRequestAction = new BLPrpLinterCancelClaimRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLinterCancelClaimRequestAction.delete(dbManager,id);
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
        BLPrpLinterCancelClaimRequestAction blPrpLinterCancelClaimRequestAction = new BLPrpLinterCancelClaimRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLinterCancelClaimRequestAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto
     * @throws Exception
     */
    public void update(PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCancelClaimRequestAction blPrpLinterCancelClaimRequestAction = new BLPrpLinterCancelClaimRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLinterCancelClaimRequestAction.update(dbManager,prpLinterCancelClaimRequestDto);
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
     * @param id 主键id PK
     * @return prpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto
     * @throws Exception
     */
    public PrpLinterCancelClaimRequestDto findByPrimaryKey(String id)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCancelClaimRequestAction blPrpLinterCancelClaimRequestAction = new BLPrpLinterCancelClaimRequestAction();
        //声明DTO
        PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLinterCancelClaimRequestDto = blPrpLinterCancelClaimRequestAction.findByPrimaryKey(dbManager,id);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLinterCancelClaimRequestDto;
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
        BLPrpLinterCancelClaimRequestAction blPrpLinterCancelClaimRequestAction = new BLPrpLinterCancelClaimRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLinterCancelClaimRequestAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLinterCancelClaimRequestDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinterCancelClaimRequestAction blPrpLinterCancelClaimRequestAction = new BLPrpLinterCancelClaimRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinterCancelClaimRequestAction.findByConditions(dbManager,conditions);
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
        BLPrpLinterCancelClaimRequestAction blPrpLinterCancelClaimRequestAction = new BLPrpLinterCancelClaimRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLinterCancelClaimRequestAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
