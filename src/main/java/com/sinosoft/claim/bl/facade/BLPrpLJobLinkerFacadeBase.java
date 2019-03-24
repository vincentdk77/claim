package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLJobLinkerAction;
import com.sinosoft.claim.dto.domain.PrpLJobLinkerDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLJobLinker的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLJobLinkerFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLJobLinkerFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLJobLinkerFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLJobLinkerDto prpLJobLinkerDto
     * @throws Exception
     */
    public void insert(PrpLJobLinkerDto prpLJobLinkerDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLJobLinkerAction blPrpLJobLinkerAction = new BLPrpLJobLinkerAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLJobLinkerAction.insert(dbManager,prpLJobLinkerDto);
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
     * @param staffId StaffId
     * @throws Exception
     */
    public void delete(String staffId)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLJobLinkerAction blPrpLJobLinkerAction = new BLPrpLJobLinkerAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLJobLinkerAction.delete(dbManager,staffId);
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
        BLPrpLJobLinkerAction blPrpLJobLinkerAction = new BLPrpLJobLinkerAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLJobLinkerAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLJobLinkerDto prpLJobLinkerDto
     * @throws Exception
     */
    public void update(PrpLJobLinkerDto prpLJobLinkerDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLJobLinkerAction blPrpLJobLinkerAction = new BLPrpLJobLinkerAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLJobLinkerAction.update(dbManager,prpLJobLinkerDto);
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
     * @param staffId StaffId
     * @return prpLJobLinkerDto prpLJobLinkerDto
     * @throws Exception
     */
    public PrpLJobLinkerDto findByPrimaryKey(String staffId)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLJobLinkerAction blPrpLJobLinkerAction = new BLPrpLJobLinkerAction();
        //声明DTO
        PrpLJobLinkerDto prpLJobLinkerDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLJobLinkerDto = blPrpLJobLinkerAction.findByPrimaryKey(dbManager,staffId);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLJobLinkerDto;
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
        BLPrpLJobLinkerAction blPrpLJobLinkerAction = new BLPrpLJobLinkerAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLJobLinkerAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLJobLinkerDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLJobLinkerAction blPrpLJobLinkerAction = new BLPrpLJobLinkerAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLJobLinkerAction.findByConditions(dbManager,conditions);
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
        BLPrpLJobLinkerAction blPrpLJobLinkerAction = new BLPrpLJobLinkerAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLJobLinkerAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
