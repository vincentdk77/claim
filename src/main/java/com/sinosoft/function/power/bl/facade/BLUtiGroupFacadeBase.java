package com.sinosoft.function.power.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.bl.action.domain.BLUtiGroupAction;
import com.sinosoft.function.power.dto.domain.UtiGroupDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是UtiGroup  权限组号表的业务逻辑对象Facade基类<br>
 * 创建于 2004-11-09 10:40:55.450<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiGroupFacadeBase{
    private static Log logger = LogFactory.getLog(BLUtiGroupFacadeBase.class);

    /**
     * 构造函数
     */
    public BLUtiGroupFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param utiGroupDto utiGroupDto
     * @throws Exception
     */
    public void insert(UtiGroupDto utiGroupDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLUtiGroupAction blUtiGroupAction = new BLUtiGroupAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            dbManager.beginTransaction();
            //插入记录
            blUtiGroupAction.insert(dbManager,utiGroupDto);
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
     * @param groupCode 权限组号代码
     * @throws Exception
     */
    public void delete(String groupCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLUtiGroupAction blUtiGroupAction = new BLUtiGroupAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            dbManager.beginTransaction();
            //删除记录
            blUtiGroupAction.delete(dbManager,groupCode);
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
        BLUtiGroupAction blUtiGroupAction = new BLUtiGroupAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            dbManager.beginTransaction();
            //按条件删除记录
            blUtiGroupAction.deleteByConditions(dbManager,conditions);
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
     * @param utiGroupDto utiGroupDto
     * @throws Exception
     */
    public void update(UtiGroupDto utiGroupDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLUtiGroupAction blUtiGroupAction = new BLUtiGroupAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            dbManager.beginTransaction();
            //更新记录
            blUtiGroupAction.update(dbManager,utiGroupDto);
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
     * @param groupCode 权限组号代码
     * @return utiGroupDto utiGroupDto
     * @throws Exception
     */
    public UtiGroupDto findByPrimaryKey(String groupCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLUtiGroupAction blUtiGroupAction = new BLUtiGroupAction();
        //声明DTO
        UtiGroupDto utiGroupDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            //查询数据,赋值给DTO
            utiGroupDto = blUtiGroupAction.findByPrimaryKey(dbManager,groupCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return utiGroupDto;
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
        BLUtiGroupAction blUtiGroupAction = new BLUtiGroupAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            pageRecord = blUtiGroupAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含utiGroupDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLUtiGroupAction blUtiGroupAction = new BLUtiGroupAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            collection = blUtiGroupAction.findByConditions(dbManager,conditions);
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
        BLUtiGroupAction blUtiGroupAction = new BLUtiGroupAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
            rowCount = blUtiGroupAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
