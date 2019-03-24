package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLRegistRPolicyAction;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLRegistRPolicy赔案保单关联表的业务逻辑对象Facade基类<br>
 * 创建于 2006-06-04 15:22:18.542<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLRegistRPolicyFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLRegistRPolicyFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLRegistRPolicyFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLRegistRPolicyDto prpLRegistRPolicyDto
     * @throws Exception
     */
    public void insert(PrpLRegistRPolicyDto prpLRegistRPolicyDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLRegistRPolicyAction blPrpLRegistRPolicyAction = new BLPrpLRegistRPolicyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLRegistRPolicyAction.insert(dbManager,prpLRegistRPolicyDto);
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
     * @param policyNo 保单号
     * @throws Exception
     */
    public void delete(String registNo,String policyNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLRegistRPolicyAction blPrpLRegistRPolicyAction = new BLPrpLRegistRPolicyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLRegistRPolicyAction.delete(dbManager,registNo, policyNo);
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
        BLPrpLRegistRPolicyAction blPrpLRegistRPolicyAction = new BLPrpLRegistRPolicyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLRegistRPolicyAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLRegistRPolicyDto prpLRegistRPolicyDto
     * @throws Exception
     */
    public void update(PrpLRegistRPolicyDto prpLRegistRPolicyDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLRegistRPolicyAction blPrpLRegistRPolicyAction = new BLPrpLRegistRPolicyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLRegistRPolicyAction.update(dbManager,prpLRegistRPolicyDto);
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
     * @param policyNo 保单号
     * @return prpLRegistRPolicyDto prpLRegistRPolicyDto
     * @throws Exception
     */
    public PrpLRegistRPolicyDto findByPrimaryKey(String registNo,String policyNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLRegistRPolicyAction blPrpLRegistRPolicyAction = new BLPrpLRegistRPolicyAction();
        //声明DTO
        PrpLRegistRPolicyDto prpLRegistRPolicyDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLRegistRPolicyDto = blPrpLRegistRPolicyAction.findByPrimaryKey(dbManager,registNo, policyNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLRegistRPolicyDto;
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
        BLPrpLRegistRPolicyAction blPrpLRegistRPolicyAction = new BLPrpLRegistRPolicyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLRegistRPolicyAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLRegistRPolicyDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLRegistRPolicyAction blPrpLRegistRPolicyAction = new BLPrpLRegistRPolicyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLRegistRPolicyAction.findByConditions(dbManager,conditions);
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
        BLPrpLRegistRPolicyAction blPrpLRegistRPolicyAction = new BLPrpLRegistRPolicyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLRegistRPolicyAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
