package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLSwfConditionAction;
import com.sinosoft.claim.dto.domain.SwfConditionDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfCondition-工作流条件描述表（新增）的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-18 17:53:38.718<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfConditionFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfConditionFacadeBase.class);

    /**
     * 构造函数
     */
    public BLSwfConditionFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param swfConditionDto swfConditionDto
     * @throws Exception
     */
    public void insert(SwfConditionDto swfConditionDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfConditionAction blSwfConditionAction = new BLSwfConditionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blSwfConditionAction.insert(dbManager,swfConditionDto);
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
     * @param modelNo 模板编码
     * @param pathNo 流程边编码
     * @param conditionNo 条件编码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(int modelNo,int pathNo,int conditionNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfConditionAction blSwfConditionAction = new BLSwfConditionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blSwfConditionAction.delete(dbManager,modelNo, pathNo, conditionNo, serialNo);
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
        BLSwfConditionAction blSwfConditionAction = new BLSwfConditionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blSwfConditionAction.deleteByConditions(dbManager,conditions);
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
     * @param swfConditionDto swfConditionDto
     * @throws Exception
     */
    public void update(SwfConditionDto swfConditionDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfConditionAction blSwfConditionAction = new BLSwfConditionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blSwfConditionAction.update(dbManager,swfConditionDto);
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
     * @param modelNo 模板编码
     * @param pathNo 流程边编码
     * @param conditionNo 条件编码
     * @param serialNo 序号
     * @return swfConditionDto swfConditionDto
     * @throws Exception
     */
    public SwfConditionDto findByPrimaryKey(int modelNo,int pathNo,int conditionNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfConditionAction blSwfConditionAction = new BLSwfConditionAction();
        //声明DTO
        SwfConditionDto swfConditionDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            swfConditionDto = blSwfConditionAction.findByPrimaryKey(dbManager,modelNo, pathNo, conditionNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return swfConditionDto;
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
        BLSwfConditionAction blSwfConditionAction = new BLSwfConditionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfConditionAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含swfConditionDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfConditionAction blSwfConditionAction = new BLSwfConditionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blSwfConditionAction.findByConditions(dbManager,conditions);
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
        BLSwfConditionAction blSwfConditionAction = new BLSwfConditionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blSwfConditionAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
