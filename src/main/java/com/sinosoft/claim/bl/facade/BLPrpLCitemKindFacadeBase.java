package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLCitemKindAction;
import com.sinosoft.claim.dto.domain.PrpLCitemKindDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLCitemKind-代赔保单投保险别表的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-18 17:53:38.609<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLCitemKindFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLCitemKindFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLCitemKindFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLCitemKindDto prpLCitemKindDto
     * @throws Exception
     */
    public void insert(PrpLCitemKindDto prpLCitemKindDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLCitemKindAction blPrpLCitemKindAction = new BLPrpLCitemKindAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLCitemKindAction.insert(dbManager,prpLCitemKindDto);
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
     * @param policyNo 保单号码
     * @param itemKindNo 序号
     * @throws Exception
     */
    public void delete(String registNo,String policyNo,int itemKindNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLCitemKindAction blPrpLCitemKindAction = new BLPrpLCitemKindAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLCitemKindAction.delete(dbManager,registNo, policyNo, itemKindNo);
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
        BLPrpLCitemKindAction blPrpLCitemKindAction = new BLPrpLCitemKindAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLCitemKindAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLCitemKindDto prpLCitemKindDto
     * @throws Exception
     */
    public void update(PrpLCitemKindDto prpLCitemKindDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLCitemKindAction blPrpLCitemKindAction = new BLPrpLCitemKindAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLCitemKindAction.update(dbManager,prpLCitemKindDto);
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
     * @param policyNo 保单号码
     * @param itemKindNo 序号
     * @return prpLCitemKindDto prpLCitemKindDto
     * @throws Exception
     */
    public PrpLCitemKindDto findByPrimaryKey(String registNo,String policyNo,int itemKindNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLCitemKindAction blPrpLCitemKindAction = new BLPrpLCitemKindAction();
        //声明DTO
        PrpLCitemKindDto prpLCitemKindDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLCitemKindDto = blPrpLCitemKindAction.findByPrimaryKey(dbManager,registNo, policyNo, itemKindNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLCitemKindDto;
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
        BLPrpLCitemKindAction blPrpLCitemKindAction = new BLPrpLCitemKindAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLCitemKindAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLCitemKindDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLCitemKindAction blPrpLCitemKindAction = new BLPrpLCitemKindAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLCitemKindAction.findByConditions(dbManager,conditions);
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
        BLPrpLCitemKindAction blPrpLCitemKindAction = new BLPrpLCitemKindAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLCitemKindAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
