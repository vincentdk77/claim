package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLpaymainAction;
import com.sinosoft.claim.bl.action.domain.BLPrplfiscalpaymainAction;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是支付信息主表的业务逻辑对象tgFacade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplfiscalpaymaintgFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplfiscalpaymaintgFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrplfiscalpaymaintgFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLpaymainDto prpLpaymainDto
     * @throws Exception
     */
    public void insert(PrpLpaymainDto prpLpaymainDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLpaymainAction.insert(dbManager,prpLpaymainDto);
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
     * @param paymentNo 支付清单编号
     * @throws Exception
     */
    public void delete(String fiscalNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplfiscalpaymainAction blPrplfiscalpaymainAction = new BLPrplfiscalpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrplfiscalpaymainAction.delete(dbManager,fiscalNo);
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
    public void deleteByConditions(String conditions)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLpaymainAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLpaymainDto prpLpaymainDto
     * @throws Exception
     */
    public void update(PrpLpaymainDto prpLpaymainDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLpaymainAction.update(dbManager,prpLpaymainDto);
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
     * @param paymentNo 支付编号
     * @return prpLpaymainDto prpLpaymainDto
     * @throws Exception
     */
    public PrpLpaymainDto findByPrimaryKey(String paymentNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        //声明DTO
        PrpLpaymainDto prpLpaymainDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLpaymainDto = blPrpLpaymainAction.findByPrimaryKey(dbManager,paymentNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLpaymainDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpaymainAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLpaymainDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLpaymainAction.findByConditions(dbManager,conditions);
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
        BLPrpLpaymainAction blPrpLpaymainAction = new BLPrpLpaymainAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLpaymainAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
