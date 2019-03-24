package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLscheduleMainAction;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLscheduleMain-调度任务主表的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-18 17:53:38.546<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLscheduleMainFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLscheduleMainFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLscheduleMainFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLscheduleMainDto prpLscheduleMainDto
     * @throws Exception
     */
    public void insert(PrpLscheduleMainDto prpLscheduleMainDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleMainAction blPrpLscheduleMainAction = new BLPrpLscheduleMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLscheduleMainAction.insert(dbManager,prpLscheduleMainDto);
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
     * @param scheduleID 调度ID
     * @param registNo 报案号码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(int scheduleID,String registNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleMainAction blPrpLscheduleMainAction = new BLPrpLscheduleMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLscheduleMainAction.delete(dbManager,scheduleID, registNo, serialNo);
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
        BLPrpLscheduleMainAction blPrpLscheduleMainAction = new BLPrpLscheduleMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLscheduleMainAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLscheduleMainDto prpLscheduleMainDto
     * @throws Exception
     */
    public void update(PrpLscheduleMainDto prpLscheduleMainDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleMainAction blPrpLscheduleMainAction = new BLPrpLscheduleMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLscheduleMainAction.update(dbManager,prpLscheduleMainDto);
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
     * @param scheduleID 调度ID
     * @param registNo 报案号码
     * @param serialNo 序号
     * @return prpLscheduleMainDto prpLscheduleMainDto
     * @throws Exception
     */
    public PrpLscheduleMainDto findByPrimaryKey(int scheduleID,String registNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLscheduleMainAction blPrpLscheduleMainAction = new BLPrpLscheduleMainAction();
        //声明DTO
        PrpLscheduleMainDto prpLscheduleMainDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLscheduleMainDto = blPrpLscheduleMainAction.findByPrimaryKey(dbManager,scheduleID, registNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLscheduleMainDto;
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
        BLPrpLscheduleMainAction blPrpLscheduleMainAction = new BLPrpLscheduleMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLscheduleMainAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLscheduleMainDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLscheduleMainAction blPrpLscheduleMainAction = new BLPrpLscheduleMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLscheduleMainAction.findByConditions(dbManager,conditions);
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
        BLPrpLscheduleMainAction blPrpLscheduleMainAction = new BLPrpLscheduleMainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLscheduleMainAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
