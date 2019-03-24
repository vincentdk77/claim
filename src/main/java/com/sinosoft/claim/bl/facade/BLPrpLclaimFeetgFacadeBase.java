package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLclaimFeetgAction;
import com.sinosoft.claim.dto.domain.PrpLclaimFeeDto;
import com.sinosoft.claim.dto.domain.PrpLclaimFeetgDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimFee-估损金额表的业务逻辑对象tgFacade基类<br>
 * 创建于 2005-03-18 17:53:38.390<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimFeetgFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimFeetgFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimFeetgFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLclaimFeeDto prpLclaimFeeDto
     * @throws Exception
     */
    public void insert(PrpLclaimFeetgDto prpLclaimFeetgDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimFeetgAction blPrpLclaimFeetgAction = new BLPrpLclaimFeetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLclaimFeetgAction.insert(dbManager,prpLclaimFeetgDto);
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
     * @param claimNo 赔案号号
     * @param currency 币别代码
     * @throws Exception
     */
    public void delete(String claimNo,String currency) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimFeetgAction blPrpLclaimFeetgAction = new BLPrpLclaimFeetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLclaimFeetgAction.delete(dbManager,claimNo, currency);
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
        BLPrpLclaimFeetgAction blPrpLclaimFeetgAction = new BLPrpLclaimFeetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLclaimFeetgAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLclaimFeeDto prpLclaimFeeDto
     * @throws Exception
     */
    public void update(PrpLclaimFeetgDto prpLclaimFeetgDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimFeetgAction blPrpLclaimFeetgAction = new BLPrpLclaimFeetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLclaimFeetgAction.update(dbManager,prpLclaimFeetgDto);
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
     * @param claimNo 赔案号号
     * @param currency 币别代码
     * @return prpLclaimFeeDto prpLclaimFeeDto
     * @throws Exception
     */
    public PrpLclaimFeetgDto findByPrimaryKey(String claimNo,String currency) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimFeetgAction blPrpLclaimFeetgAction = new BLPrpLclaimFeetgAction();
        //声明DTO
        PrpLclaimFeetgDto prpLclaimFeetgDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLclaimFeetgDto = blPrpLclaimFeetgAction.findByPrimaryKey(dbManager,claimNo, currency);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLclaimFeetgDto;
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
        BLPrpLclaimFeetgAction blPrpLclaimFeetgAction = new BLPrpLclaimFeetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLclaimFeetgAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLclaimFeeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLclaimFeetgAction blPrpLclaimFeetgAction = new BLPrpLclaimFeetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLclaimFeetgAction.findByConditions(dbManager,conditions);
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
        BLPrpLclaimFeetgAction blPrpLclaimFeetgAction = new BLPrpLclaimFeetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLclaimFeetgAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
