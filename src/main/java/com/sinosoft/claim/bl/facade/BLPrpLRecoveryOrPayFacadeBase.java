package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLRecoveryOrPayAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLlossAction;
import com.sinosoft.claim.dto.domain.PrpLRecoveryOrPayDto;
import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLRecoveryOrPayFacadeBase {
	private static Log logger = LogFactory.getLog(BLPrpLRecoveryOrPayFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLRecoveryOrPayFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLlossDto prpLlossDto
     * @throws Exception
     */
    public void insert(PrpLRecoveryOrPayDto prpLRecoveryOrPayDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLRecoveryOrPayAction blPrpLRecoveryOrPayAction = new BLPrpLRecoveryOrPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLRecoveryOrPayAction.insert(dbManager,prpLRecoveryOrPayDto);
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
     * @param compensateNo 赔款计算书号
     * @param serialNo 赔付标的序号
     * @throws Exception
     */
    public void delete(String compensateNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLRecoveryOrPayAction blPrpLRecoveryOrPayAction = new BLPrpLRecoveryOrPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLRecoveryOrPayAction.delete(dbManager,compensateNo, serialNo);
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
        BLPrpLRecoveryOrPayAction blPrpLRecoveryOrPayAction = new BLPrpLRecoveryOrPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLRecoveryOrPayAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLlossDto prpLlossDto
     * @throws Exception
     */
    public void update(PrpLRecoveryOrPayDto prpLRecoveryOrPayDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLRecoveryOrPayAction blPrpLRecoveryOrPayAction = new BLPrpLRecoveryOrPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLRecoveryOrPayAction.update(dbManager,prpLRecoveryOrPayDto);
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
     * @param compensateNo 赔款计算书号
     * @param serialNo 赔付标的序号
     * @return prpLlossDto prpLlossDto
     * @throws Exception
     */
    public PrpLRecoveryOrPayDto findByPrimaryKey(String compensateNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLRecoveryOrPayAction blPrpLRecoveryOrPayAction = new BLPrpLRecoveryOrPayAction();
        //声明DTO
        PrpLRecoveryOrPayDto prpLRecoveryOrPayDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLRecoveryOrPayDto = blPrpLRecoveryOrPayAction.findByPrimaryKey(dbManager,compensateNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLRecoveryOrPayDto;
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
        BLPrpLRecoveryOrPayAction blPrpLRecoveryOrPayAction = new BLPrpLRecoveryOrPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLRecoveryOrPayAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLlossDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLRecoveryOrPayAction blPrpLRecoveryOrPayAction = new BLPrpLRecoveryOrPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLRecoveryOrPayAction.findByConditions(dbManager,conditions);
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
        BLPrpLRecoveryOrPayAction blPrpLRecoveryOrPayAction = new BLPrpLRecoveryOrPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLRecoveryOrPayAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
