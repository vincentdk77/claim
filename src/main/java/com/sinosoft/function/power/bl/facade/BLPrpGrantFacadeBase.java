package com.sinosoft.function.power.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.bl.action.domain.BLPrpGrantAction;
import com.sinosoft.function.power.dto.domain.PrpGrantDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpGrant 授权记录表的业务逻辑对象Facade基类<br>
 * 创建于 2004-11-09 10:40:55.460<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGrantFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpGrantFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpGrantFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpGrantDto prpGrantDto
     * @throws Exception
     */
    public void insert(PrpGrantDto prpGrantDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpGrantAction blPrpGrantAction = new BLPrpGrantAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            dbManager.beginTransaction();
            //插入记录
            blPrpGrantAction.insert(dbManager,prpGrantDto);
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
     * @param userCode 员工代码
     * @param groupCode 权限组号
     * @param taskCode 授权任务
     * @param checkCode 授权类型
     * @param grantStartDate 授权开始时限
     * @param grantEndDate 授权终止时限
     * @throws Exception
     */
    public void delete(String userCode,String groupCode,String taskCode,String checkCode,DateTime grantStartDate,DateTime grantEndDate) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpGrantAction blPrpGrantAction = new BLPrpGrantAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            dbManager.beginTransaction();
            //删除记录
            blPrpGrantAction.delete(dbManager,userCode, groupCode, taskCode, checkCode, grantStartDate, grantEndDate);
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
        BLPrpGrantAction blPrpGrantAction = new BLPrpGrantAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpGrantAction.deleteByConditions(dbManager,conditions);
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
     * @param prpGrantDto prpGrantDto
     * @throws Exception
     */
    public void update(PrpGrantDto prpGrantDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpGrantAction blPrpGrantAction = new BLPrpGrantAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            dbManager.beginTransaction();
            //更新记录
            blPrpGrantAction.update(dbManager,prpGrantDto);
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
     * @param userCode 员工代码
     * @param groupCode 权限组号
     * @param taskCode 授权任务
     * @param checkCode 授权类型
     * @param grantStartDate 授权开始时限
     * @param grantEndDate 授权终止时限
     * @return prpGrantDto prpGrantDto
     * @throws Exception
     */
    public PrpGrantDto findByPrimaryKey(String userCode,String groupCode,String taskCode,String checkCode,DateTime grantStartDate,DateTime grantEndDate) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpGrantAction blPrpGrantAction = new BLPrpGrantAction();
        //声明DTO
        PrpGrantDto prpGrantDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            //查询数据,赋值给DTO
            prpGrantDto = blPrpGrantAction.findByPrimaryKey(dbManager,userCode, groupCode, taskCode, checkCode, grantStartDate, grantEndDate);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpGrantDto;
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
        BLPrpGrantAction blPrpGrantAction = new BLPrpGrantAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            pageRecord = blPrpGrantAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpGrantDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpGrantAction blPrpGrantAction = new BLPrpGrantAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            collection = blPrpGrantAction.findByConditions(dbManager,conditions);
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
        BLPrpGrantAction blPrpGrantAction = new BLPrpGrantAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            rowCount = blPrpGrantAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
