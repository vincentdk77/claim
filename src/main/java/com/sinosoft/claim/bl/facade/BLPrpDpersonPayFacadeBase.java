package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpDpersonPayAction;
import com.sinosoft.claim.dto.domain.PrpDpersonPayDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDpersonPay人员赔付标准金额表的业务逻辑对象Facade基类<br>
 * 创建于 2004-09-20 14:11:32.263<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDpersonPayFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpDpersonPayFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpDpersonPayFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpDpersonPayDto prpDpersonPayDto
     * @throws Exception
     */
    public void insert(PrpDpersonPayDto prpDpersonPayDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDpersonPayAction blPrpDpersonPayAction = new BLPrpDpersonPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpDpersonPayAction.insert(dbManager,prpDpersonPayDto);
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
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDpersonPayAction blPrpDpersonPayAction = new BLPrpDpersonPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpDpersonPayAction.delete(dbManager,serialNo);
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
        BLPrpDpersonPayAction blPrpDpersonPayAction = new BLPrpDpersonPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpDpersonPayAction.deleteByConditions(dbManager,conditions);
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
     * @param prpDpersonPayDto prpDpersonPayDto
     * @throws Exception
     */
    public void update(PrpDpersonPayDto prpDpersonPayDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDpersonPayAction blPrpDpersonPayAction = new BLPrpDpersonPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpDpersonPayAction.update(dbManager,prpDpersonPayDto);
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
     * @param serialNo 序号
     * @return prpDpersonPayDto prpDpersonPayDto
     * @throws Exception
     */
    public PrpDpersonPayDto findByPrimaryKey(int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDpersonPayAction blPrpDpersonPayAction = new BLPrpDpersonPayAction();
        //声明DTO
        PrpDpersonPayDto prpDpersonPayDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpDpersonPayDto = blPrpDpersonPayAction.findByPrimaryKey(dbManager,serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpDpersonPayDto;
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
        BLPrpDpersonPayAction blPrpDpersonPayAction = new BLPrpDpersonPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpDpersonPayAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpDpersonPayDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpDpersonPayAction blPrpDpersonPayAction = new BLPrpDpersonPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpDpersonPayAction.findByConditions(dbManager,conditions);
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
        BLPrpDpersonPayAction blPrpDpersonPayAction = new BLPrpDpersonPayAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpDpersonPayAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
