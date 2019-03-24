package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLbackVisitQueAction;
import com.sinosoft.claim.dto.domain.PrpLbackVisitQueDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLbackVisitQue--回访问询表的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-23 09:00:26.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLbackVisitQueFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLbackVisitQueFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLbackVisitQueFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLbackVisitQueDto prpLbackVisitQueDto
     * @throws Exception
     */
    public void insert(PrpLbackVisitQueDto prpLbackVisitQueDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitQueAction blPrpLbackVisitQueAction = new BLPrpLbackVisitQueAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLbackVisitQueAction.insert(dbManager,prpLbackVisitQueDto);
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
     * @param questionCode 回访项目代码
     * @throws Exception
     */
    public void delete(int backVisitID,String registNo,String backVisitType,String questionCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitQueAction blPrpLbackVisitQueAction = new BLPrpLbackVisitQueAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLbackVisitQueAction.delete(dbManager,backVisitID, registNo, backVisitType, questionCode);
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
        BLPrpLbackVisitQueAction blPrpLbackVisitQueAction = new BLPrpLbackVisitQueAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLbackVisitQueAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLbackVisitQueDto prpLbackVisitQueDto
     * @throws Exception
     */
    public void update(PrpLbackVisitQueDto prpLbackVisitQueDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitQueAction blPrpLbackVisitQueAction = new BLPrpLbackVisitQueAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLbackVisitQueAction.update(dbManager,prpLbackVisitQueDto);
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
     * @param questionCode 回访项目代码
     * @return prpLbackVisitQueDto prpLbackVisitQueDto
     * @throws Exception
     */
    public PrpLbackVisitQueDto findByPrimaryKey(int backVisitID,String registNo,String backVisitType,String questionCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLbackVisitQueAction blPrpLbackVisitQueAction = new BLPrpLbackVisitQueAction();
        //声明DTO
        PrpLbackVisitQueDto prpLbackVisitQueDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLbackVisitQueDto = blPrpLbackVisitQueAction.findByPrimaryKey(dbManager,backVisitID, registNo, backVisitType, questionCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLbackVisitQueDto;
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
        BLPrpLbackVisitQueAction blPrpLbackVisitQueAction = new BLPrpLbackVisitQueAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLbackVisitQueAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLbackVisitQueDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLbackVisitQueAction blPrpLbackVisitQueAction = new BLPrpLbackVisitQueAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLbackVisitQueAction.findByConditions(dbManager,conditions);
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
        BLPrpLbackVisitQueAction blPrpLbackVisitQueAction = new BLPrpLbackVisitQueAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLbackVisitQueAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
