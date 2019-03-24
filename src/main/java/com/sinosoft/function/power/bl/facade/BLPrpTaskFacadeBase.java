package com.sinosoft.function.power.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.bl.action.domain.BLPrpTaskAction;
import com.sinosoft.function.power.dto.domain.PrpTaskDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpTask工作任务表的业务逻辑对象Facade基类<br>
 * 创建于 2004-11-09 10:40:55.460<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpTaskFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpTaskFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpTaskFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpTaskDto prpTaskDto
     * @throws Exception
     */
    public void insert(PrpTaskDto prpTaskDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpTaskAction blPrpTaskAction = new BLPrpTaskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            dbManager.beginTransaction();
            //插入记录
            blPrpTaskAction.insert(dbManager,prpTaskDto);
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
     * @param taskCode 任务代码
     * @param checkCode 权限检验代码
     * @throws Exception
     */
    public void delete(String taskCode,String checkCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpTaskAction blPrpTaskAction = new BLPrpTaskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            dbManager.beginTransaction();
            //删除记录
            blPrpTaskAction.delete(dbManager,taskCode, checkCode);
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
        BLPrpTaskAction blPrpTaskAction = new BLPrpTaskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpTaskAction.deleteByConditions(dbManager,conditions);
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
     * @param prpTaskDto prpTaskDto
     * @throws Exception
     */
    public void update(PrpTaskDto prpTaskDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpTaskAction blPrpTaskAction = new BLPrpTaskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            dbManager.beginTransaction();
            //更新记录
            blPrpTaskAction.update(dbManager,prpTaskDto);
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
     * @param taskCode 任务代码
     * @param checkCode 权限检验代码
     * @return prpTaskDto prpTaskDto
     * @throws Exception
     */
    public PrpTaskDto findByPrimaryKey(String taskCode,String checkCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpTaskAction blPrpTaskAction = new BLPrpTaskAction();
        //声明DTO
        PrpTaskDto prpTaskDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            //查询数据,赋值给DTO
            prpTaskDto = blPrpTaskAction.findByPrimaryKey(dbManager,taskCode, checkCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpTaskDto;
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
        BLPrpTaskAction blPrpTaskAction = new BLPrpTaskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            pageRecord = blPrpTaskAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpTaskDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpTaskAction blPrpTaskAction = new BLPrpTaskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            collection = blPrpTaskAction.findByConditions(dbManager,conditions);
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
        BLPrpTaskAction blPrpTaskAction = new BLPrpTaskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            rowCount = blPrpTaskAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
