package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是WorkFlow工作流条件描述表的业务逻辑对象Facade基类<br>
 * 创建于 2004-08-09 19:54:55.307<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLWorkFlowFacadeBase{
    private static Log logger = LogFactory.getLog(BLWorkFlowFacadeBase.class);

    /**
     * 构造函数
     */
    public BLWorkFlowFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param workFlowDto workFlowDto
     * @throws Exception
     */
    public void insert(WorkFlowDto workFlowDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLWorkFlowAction blWorkFlowAction = new BLWorkFlowAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blWorkFlowAction.insert(dbManager,workFlowDto);
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
        BLWorkFlowAction blWorkFlowAction = new BLWorkFlowAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blWorkFlowAction.delete(dbManager,modelNo, pathNo, conditionNo, serialNo);
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

    public void deleteByConditions(String conditions) throws Exception{
        DBManager dbManager = new DBManager();
        BLWorkFlowAction blWorkFlowAction = new BLWorkFlowAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blWorkFlowAction.delete(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
 */
    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param workFlowDto workFlowDto
     * @throws Exception
     */
    public void update(WorkFlowDto workFlowDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLWorkFlowAction blWorkFlowAction = new BLWorkFlowAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blWorkFlowAction.update(dbManager,workFlowDto);
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
     * @return workFlowDto workFlowDto
     * @throws Exception
     */
    public WorkFlowDto findByPrimaryKey(int modelNo,int pathNo,int conditionNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLWorkFlowAction blWorkFlowAction = new BLWorkFlowAction();
        //声明DTO
        WorkFlowDto workFlowDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            workFlowDto = blWorkFlowAction.findByPrimaryKey(dbManager,modelNo, pathNo, conditionNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return workFlowDto;
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
        PageRecord pageRecord = new PageRecord(0,pageNo,1,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLWorkFlowAction blWorkFlowAction = new BLWorkFlowAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blWorkFlowAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含workFlowDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0).getResult();
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
        BLWorkFlowAction blWorkFlowAction = new BLWorkFlowAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blWorkFlowAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
