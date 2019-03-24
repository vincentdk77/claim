package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.MessageReceiveLogDto;
import com.sinosoft.claim.bl.action.domain.BLMessageReceiveLogAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是MessageReceiveLog的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLMessageReceiveLogFacadeBase{
    private static Logger logger = Logger.getLogger(BLMessageReceiveLogFacadeBase.class);

    /**
     * 构造函数
     */
    public BLMessageReceiveLogFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param messageReceiveLogDto messageReceiveLogDto
     * @throws Exception
     */
    public void insert(MessageReceiveLogDto messageReceiveLogDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMessageReceiveLogAction blMessageReceiveLogAction = new BLMessageReceiveLogAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //插入记录
            blMessageReceiveLogAction.insert(dbManager,messageReceiveLogDto);
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
     * @param ruleCode RuleCode
     * @param month Month
     * @throws Exception
     */
    public void delete(String ruleCode,String month)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMessageReceiveLogAction blMessageReceiveLogAction = new BLMessageReceiveLogAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //删除记录
            blMessageReceiveLogAction.delete(dbManager,ruleCode, month);
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
        BLMessageReceiveLogAction blMessageReceiveLogAction = new BLMessageReceiveLogAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blMessageReceiveLogAction.deleteByConditions(dbManager,conditions);
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
     * @param messageReceiveLogDto messageReceiveLogDto
     * @throws Exception
     */
    public void update(MessageReceiveLogDto messageReceiveLogDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMessageReceiveLogAction blMessageReceiveLogAction = new BLMessageReceiveLogAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //更新记录
            blMessageReceiveLogAction.update(dbManager,messageReceiveLogDto);
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
     * @param ruleCode RuleCode
     * @param month Month
     * @return messageReceiveLogDto messageReceiveLogDto
     * @throws Exception
     */
    public MessageReceiveLogDto findByPrimaryKey(String ruleCode,String month)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMessageReceiveLogAction blMessageReceiveLogAction = new BLMessageReceiveLogAction();
        //声明DTO
        MessageReceiveLogDto messageReceiveLogDto = null;
        try{
            dbManager.open("claimDataSource");
            //查询数据,赋值给DTO
            messageReceiveLogDto = blMessageReceiveLogAction.findByPrimaryKey(dbManager,ruleCode, month);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return messageReceiveLogDto;
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
        BLMessageReceiveLogAction blMessageReceiveLogAction = new BLMessageReceiveLogAction();
        try{
            dbManager.open("claimDataSource");
            pageRecord = blMessageReceiveLogAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含messageReceiveLogDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLMessageReceiveLogAction blMessageReceiveLogAction = new BLMessageReceiveLogAction();
        try{
            dbManager.open("claimDataSource");
            collection = blMessageReceiveLogAction.findByConditions(dbManager,conditions);
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
        BLMessageReceiveLogAction blMessageReceiveLogAction = new BLMessageReceiveLogAction();
        try{
            dbManager.open("claimDataSource");
            rowCount = blMessageReceiveLogAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
