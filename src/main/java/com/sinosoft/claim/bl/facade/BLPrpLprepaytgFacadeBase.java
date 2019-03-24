package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLprepaytgAction;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLprepaytgDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLprepay-预赔登记表的业务逻辑对象tgFacade基类<br>
 * 创建于 2005-03-18 17:53:38.468<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLprepaytgFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLprepaytgFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLprepaytgFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLprepayDto prpLprepayDto
     * @throws Exception
     */
    public void insert(PrpLprepaytgDto prpLprepaytgDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLprepaytgAction blPrpLprepaytgAction = new BLPrpLprepaytgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLprepaytgAction.insert(dbManager,prpLprepaytgDto);
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
     * @param preCompensateNo 预赔登记号
     * @throws Exception
     */
    public void delete(String preCompensateNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLprepaytgAction blPrpLprepaytgAction = new BLPrpLprepaytgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLprepaytgAction.delete(dbManager,preCompensateNo);
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
        BLPrpLprepaytgAction blPrpLprepaytgAction = new BLPrpLprepaytgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLprepaytgAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLprepayDto prpLprepayDto
     * @throws Exception
     */
    public void update(PrpLprepaytgDto prpLprepaytgDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLprepaytgAction blPrpLprepaytgAction = new BLPrpLprepaytgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLprepaytgAction.update(dbManager,prpLprepaytgDto);
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
     * @param preCompensateNo 预赔登记号
     * @return prpLprepayDto prpLprepayDto
     * @throws Exception
     */
    public PrpLprepaytgDto findByPrimaryKey(String preCompensateNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLprepaytgAction blPrpLprepaytgAction = new BLPrpLprepaytgAction();
        //声明DTO
        PrpLprepaytgDto prpLprepayDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLprepayDto = blPrpLprepaytgAction.findByPrimaryKey(dbManager,preCompensateNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLprepayDto;
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
        BLPrpLprepaytgAction blPrpLprepaytgAction = new BLPrpLprepaytgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLprepaytgAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLprepayDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLprepaytgAction blPrpLprepaytgAction = new BLPrpLprepaytgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLprepaytgAction.findByConditions(dbManager,conditions);
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
        BLPrpLprepaytgAction blPrpLprepaytgAction = new BLPrpLprepaytgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLprepaytgAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
