package com.sinosoft.claim.query.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.query.util.Constant;
import com.sinosoft.claim.bl.action.domain.BLPrplcompensatehouseAction;
import java.math.*;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLCOMPENSATEHOUSE的业务逻辑对象Facade基类<br>
 */
public class BLPrplcompensatehouseFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplcompensatehouseFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrplcompensatehouseFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prplcompensatehouseDto prplcompensatehouseDto
     * @throws Exception
     */
    public void insert(PrplcompensatehouseDto prplcompensatehouseDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrplcompensatehouseAction.insert(dbManager,prplcompensatehouseDto);
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
        BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrplcompensatehouseAction.delete(dbManager,idcard, registno, nodetype, businessno);
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
        BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrplcompensatehouseAction.deleteByConditions(dbManager,conditions);
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
    public void update(PrplcompensatehouseDto prplcompensatehouseDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrplcompensatehouseAction.update(dbManager,prplcompensatehouseDto);
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
    public PrplcompensatehouseDto findByPrimaryKey(String idcard,String registno,String nodetype,String businessno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
        //声明DTO
        PrplcompensatehouseDto prplcompensatehouseDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prplcompensatehouseDto = blPrplcompensatehouseAction.findByPrimaryKey(dbManager,idcard, registno, nodetype, businessno);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplcompensatehouseDto;
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
        BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplcompensatehouseAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
        BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(Constant.QUERY_DATA_SOURCE);
            collection = blPrplcompensatehouseAction.findByConditions(dbManager,conditions);
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
        BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplcompensatehouseAction.getCount(dbManager,conditions);
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
    BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
    try{
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        sum = blPrplcompensatehouseAction.getSumCompensate(dbManager,idcard,policyno);
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
        BLPrplcompensatehouseAction blPrplcompensatehouseAction = new BLPrplcompensatehouseAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplcompensatehouseAction.getInprocessCount(dbManager,policyno,idcard);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
