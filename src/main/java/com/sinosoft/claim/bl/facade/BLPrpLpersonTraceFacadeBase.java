package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLpersonTraceAction;
import com.sinosoft.claim.dto.domain.PrpLpersonTraceDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLpersonTrace-人伤跟踪表(新增)的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-18 17:53:38.671<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLpersonTraceFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLpersonTraceFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLpersonTraceFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLpersonTraceDto prpLpersonTraceDto
     * @throws Exception
     */
    public void insert(PrpLpersonTraceDto prpLpersonTraceDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpersonTraceAction blPrpLpersonTraceAction = new BLPrpLpersonTraceAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLpersonTraceAction.insert(dbManager,prpLpersonTraceDto);
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
     * @param registNo 报案号
     * @param personNo 人员序号
     * @throws Exception
     */
    public void delete(String registNo,int personNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpersonTraceAction blPrpLpersonTraceAction = new BLPrpLpersonTraceAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLpersonTraceAction.delete(dbManager,registNo, personNo);
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
        BLPrpLpersonTraceAction blPrpLpersonTraceAction = new BLPrpLpersonTraceAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLpersonTraceAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLpersonTraceDto prpLpersonTraceDto
     * @throws Exception
     */
    public void update(PrpLpersonTraceDto prpLpersonTraceDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpersonTraceAction blPrpLpersonTraceAction = new BLPrpLpersonTraceAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLpersonTraceAction.update(dbManager,prpLpersonTraceDto);
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
     * @param registNo 报案号
     * @param personNo 人员序号
     * @return prpLpersonTraceDto prpLpersonTraceDto
     * @throws Exception
     */
    public PrpLpersonTraceDto findByPrimaryKey(String registNo,int personNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpersonTraceAction blPrpLpersonTraceAction = new BLPrpLpersonTraceAction();
        //声明DTO
        PrpLpersonTraceDto prpLpersonTraceDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLpersonTraceDto = blPrpLpersonTraceAction.findByPrimaryKey(dbManager,registNo, personNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLpersonTraceDto;
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
        BLPrpLpersonTraceAction blPrpLpersonTraceAction = new BLPrpLpersonTraceAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpersonTraceAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLpersonTraceDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpersonTraceAction blPrpLpersonTraceAction = new BLPrpLpersonTraceAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLpersonTraceAction.findByConditions(dbManager,conditions);
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
        BLPrpLpersonTraceAction blPrpLpersonTraceAction = new BLPrpLpersonTraceAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLpersonTraceAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
