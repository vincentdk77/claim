package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLbackVisitAction;
import com.sinosoft.claim.dto.domain.PrpLbackVisitDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLbackVisit--回访信息主表的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-25 20:44:49.187<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLbackVisitFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLbackVisitFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLbackVisitFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLbackVisitDto prpLbackVisitDto
     * @throws Exception
     */
    public void insert(PrpLbackVisitDto prpLbackVisitDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitAction blPrpLbackVisitAction = new BLPrpLbackVisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //插入记录
            blPrpLbackVisitAction.insert(dbManager,prpLbackVisitDto);
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
     * @param backVisitID 客户回访记录ID
     * @param registNo 报案号码
     * @param backVisitType 业务类型
     * @throws Exception
     */
    public void delete(int backVisitID,String registNo,String backVisitType) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitAction blPrpLbackVisitAction = new BLPrpLbackVisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //删除记录
            blPrpLbackVisitAction.delete(dbManager,backVisitID, registNo, backVisitType);
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
        BLPrpLbackVisitAction blPrpLbackVisitAction = new BLPrpLbackVisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLbackVisitAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLbackVisitDto prpLbackVisitDto
     * @throws Exception
     */
    public void update(PrpLbackVisitDto prpLbackVisitDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitAction blPrpLbackVisitAction = new BLPrpLbackVisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //更新记录
            blPrpLbackVisitAction.update(dbManager,prpLbackVisitDto);
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
     * @param backVisitID 客户回访记录ID
     * @param registNo 报案号码
     * @param backVisitType 业务类型
     * @return prpLbackVisitDto prpLbackVisitDto
     * @throws Exception
     */
    public PrpLbackVisitDto findByPrimaryKey(int backVisitID,String registNo,String backVisitType) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitAction blPrpLbackVisitAction = new BLPrpLbackVisitAction();
        //声明DTO
        PrpLbackVisitDto prpLbackVisitDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            //查询数据,赋值给DTO
            prpLbackVisitDto = blPrpLbackVisitAction.findByPrimaryKey(dbManager,backVisitID, registNo, backVisitType);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLbackVisitDto;
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
        BLPrpLbackVisitAction blPrpLbackVisitAction = new BLPrpLbackVisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLbackVisitAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLbackVisitDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLbackVisitAction blPrpLbackVisitAction = new BLPrpLbackVisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLbackVisitAction.findByConditions(dbManager,conditions);
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
        BLPrpLbackVisitAction blPrpLbackVisitAction = new BLPrpLbackVisitAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLbackVisitAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
