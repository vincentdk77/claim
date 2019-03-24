package com.sinosoft.claim.bl.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrplcompensatehousetgAction;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.dto.domain.PrplcompensatehousetgDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLCOMPENSATEHOUSE的业务逻辑对象tgFacade基类<br>
 */
public class BLPrplcompensatehousetgFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplcompensatehousetgFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrplcompensatehousetgFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prplcompensatehouseDto prplcompensatehouseDto
     * @throws Exception
     */
    public void insert(PrplcompensatehousetgDto prplcompensatehousetgDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcompensatehousetgAction blPrplcompensatehousetgAction = new BLPrplcompensatehousetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrplcompensatehousetgAction.insert(dbManager,prplcompensatehousetgDto);
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
     * @param idcard IDCARD
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @param businessno BUSINESSNO
     * @throws Exception
     */
    public void delete(String idcard,String registno,String nodetype,String businessno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcompensatehousetgAction blPrplcompensatehousetgAction = new BLPrplcompensatehousetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrplcompensatehousetgAction.delete(dbManager,idcard, registno, nodetype, businessno);
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
        BLPrplcompensatehousetgAction blPrplcompensatehousetgAction = new BLPrplcompensatehousetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrplcompensatehousetgAction.deleteByConditions(dbManager,conditions);
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
     * @param prplcompensatehouseDto prplcompensatehouseDto
     * @throws Exception
     */
    public void update(PrplcompensatehousetgDto prplcompensatehousetgDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcompensatehousetgAction blPrplcompensatehousetgAction = new BLPrplcompensatehousetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrplcompensatehousetgAction.update(dbManager,prplcompensatehousetgDto);
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
     * @param idcard IDCARD
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @param businessno BUSINESSNO
     * @return prplcompensatehouseDto prplcompensatehouseDto
     * @throws Exception
     */
    public PrplcompensatehousetgDto findByPrimaryKey(String idcard,String registno,String nodetype,String businessno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcompensatehousetgAction blPrplcompensatehousetgAction = new BLPrplcompensatehousetgAction();
        //声明DTO
        PrplcompensatehousetgDto prplcompensatehousetgDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prplcompensatehousetgDto = blPrplcompensatehousetgAction.findByPrimaryKey(dbManager,idcard, registno, nodetype, businessno);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplcompensatehousetgDto;
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
        BLPrplcompensatehousetgAction blPrplcompensatehousetgAction = new BLPrplcompensatehousetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplcompensatehousetgAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prplcompensatehouseDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplcompensatehousetgAction blPrplcompensatehousetgAction = new BLPrplcompensatehousetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplcompensatehousetgAction.findByConditions(dbManager,conditions);
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
        BLPrplcompensatehousetgAction blPrplcompensatehousetgAction = new BLPrplcompensatehousetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplcompensatehousetgAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
    public BigDecimal getSumCompensate(String idcard,String policyno) 
    throws Exception{
    BigDecimal sum = new BigDecimal(0.00);

    DBManager dbManager = new DBManager();
    BLPrplcompensatehousetgAction blPrplcompensatehousetgAction = new BLPrplcompensatehousetgAction();
    try{
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        sum = blPrplcompensatehousetgAction.getSumCompensate(dbManager,idcard,policyno);
    }catch(Exception exception){
        throw exception;
    }finally{
        dbManager.close();
    }
    return sum;
}
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getInprocessCount(String policyno,String idcard) 
        throws Exception{
        int rowCount=0;

        DBManager dbManager = new DBManager();
        BLPrplcompensatehousetgAction blPrplcompensatehousetgAction = new BLPrplcompensatehousetgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplcompensatehousetgAction.getInprocessCount(dbManager,policyno,idcard);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
