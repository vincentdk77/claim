package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.CallCenterSendStatusDto;
import com.sinosoft.claim.bl.action.domain.BLCallCenterSendStatusAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CallCenterSendStatus的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCallCenterSendStatusFacadeBase{
    private static Logger logger = Logger.getLogger(BLCallCenterSendStatusFacadeBase.class);

    /**
     * 构造函数
     */
    public BLCallCenterSendStatusFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param callCenterSendStatusDto callCenterSendStatusDto
     * @throws Exception
     */
    public void insert(CallCenterSendStatusDto callCenterSendStatusDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCallCenterSendStatusAction blCallCenterSendStatusAction = new BLCallCenterSendStatusAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //插入记录
            blCallCenterSendStatusAction.insert(dbManager,callCenterSendStatusDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            exception.printStackTrace();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按主键删除一条数据
     * @param serial serial
     * @throws Exception
     */
    public void delete(double serial)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCallCenterSendStatusAction blCallCenterSendStatusAction = new BLCallCenterSendStatusAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //删除记录
            blCallCenterSendStatusAction.delete(dbManager,serial);
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
        BLCallCenterSendStatusAction blCallCenterSendStatusAction = new BLCallCenterSendStatusAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blCallCenterSendStatusAction.deleteByConditions(dbManager,conditions);
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
     * @param callCenterSendStatusDto callCenterSendStatusDto
     * @throws Exception
     */
    public void update(CallCenterSendStatusDto callCenterSendStatusDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCallCenterSendStatusAction blCallCenterSendStatusAction = new BLCallCenterSendStatusAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //更新记录
            blCallCenterSendStatusAction.update(dbManager,callCenterSendStatusDto);
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
     * @param serial serial
     * @return callCenterSendStatusDto callCenterSendStatusDto
     * @throws Exception
     */
    public CallCenterSendStatusDto findByPrimaryKey(double serial)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCallCenterSendStatusAction blCallCenterSendStatusAction = new BLCallCenterSendStatusAction();
        //声明DTO
        CallCenterSendStatusDto callCenterSendStatusDto = null;
        try{
            dbManager.open("ddccDataSource");
            //查询数据,赋值给DTO
            callCenterSendStatusDto = blCallCenterSendStatusAction.findByPrimaryKey(dbManager,serial);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return callCenterSendStatusDto;
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
        BLCallCenterSendStatusAction blCallCenterSendStatusAction = new BLCallCenterSendStatusAction();
        try{
            dbManager.open("ddccDataSource");
            pageRecord = blCallCenterSendStatusAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含callCenterSendStatusDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCallCenterSendStatusAction blCallCenterSendStatusAction = new BLCallCenterSendStatusAction();
        try{
            dbManager.open("ddccDataSource");
            collection = blCallCenterSendStatusAction.findByConditions(dbManager,conditions);
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
        BLCallCenterSendStatusAction blCallCenterSendStatusAction = new BLCallCenterSendStatusAction();
        try{
            dbManager.open("ddccDataSource");
            rowCount = blCallCenterSendStatusAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
