package com.sinosoft.claim.query.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLSwfFlowMainAction;
import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.query.util.Constant;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfFlowMain-流程主表（新增）的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-18 17:53:38.703<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfFlowMainFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfFlowMainFacadeBase.class);

    /**
     * 构造函数
     */
    public BLSwfFlowMainFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param swfFlowMainDto swfFlowMainDto
     * @throws Exception
     */
    public void insert(SwfFlowMainDto swfFlowMainDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfFlowMainAction blSwfFlowMainAction = new BLSwfFlowMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blSwfFlowMainAction.insert(dbManager,swfFlowMainDto);
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
     * @param flowID 流程编号
     * @throws Exception
     */
    public void delete(String flowID) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfFlowMainAction blSwfFlowMainAction = new BLSwfFlowMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blSwfFlowMainAction.delete(dbManager,flowID);
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
        BLSwfFlowMainAction blSwfFlowMainAction = new BLSwfFlowMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blSwfFlowMainAction.deleteByConditions(dbManager,conditions);
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
     * @param swfFlowMainDto swfFlowMainDto
     * @throws Exception
     */
    public void update(SwfFlowMainDto swfFlowMainDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfFlowMainAction blSwfFlowMainAction = new BLSwfFlowMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blSwfFlowMainAction.update(dbManager,swfFlowMainDto);
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
     * @param flowID 流程编号
     * @return swfFlowMainDto swfFlowMainDto
     * @throws Exception
     */
    public SwfFlowMainDto findByPrimaryKey(String flowID) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfFlowMainAction blSwfFlowMainAction = new BLSwfFlowMainAction();
        //声明DTO
        SwfFlowMainDto swfFlowMainDto = null;
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(Constant.QUERY_DATA_SOURCE);
            //查询数据,赋值给DTO
            swfFlowMainDto = blSwfFlowMainAction.findByPrimaryKey(dbManager,flowID);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return swfFlowMainDto;
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
        BLSwfFlowMainAction blSwfFlowMainAction = new BLSwfFlowMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfFlowMainAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含swfFlowMainDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfFlowMainAction blSwfFlowMainAction = new BLSwfFlowMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blSwfFlowMainAction.findByConditions(dbManager,conditions);
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
        BLSwfFlowMainAction blSwfFlowMainAction = new BLSwfFlowMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blSwfFlowMainAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
