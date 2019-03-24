package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.gyic.claim.bl.action.domain.BLPrplcompensateearAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是Prplcompensateear的业务逻辑对象Facade基类<br>
 */
public class BLPrplcompensateearFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplcompensateearFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrplcompensateearFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prplcompensateearDto prplcompensateearDto
     * @throws Exception
     */
    public void insert(PrplcompensateearDto prplcompensateearDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrplcompensateearAction.insert(dbManager,prplcompensateearDto);
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
     * @param earno EARNO
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @throws Exception
     */
    public void delete(String earno,String registno,String nodetype,String businessno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrplcompensateearAction.delete(dbManager,earno, registno, nodetype,businessno);
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
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrplcompensateearAction.deleteByConditions(dbManager,conditions);
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
     * @param prplcompensateearDto prplcompensateearDto
     * @throws Exception
     */
    public void update(PrplcompensateearDto prplcompensateearDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrplcompensateearAction.update(dbManager,prplcompensateearDto);
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
     * @param earno EARNO
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @return prplcompensateearDto prplcompensateearDto
     * @throws Exception
     */
    public PrplcompensateearDto findByPrimaryKey(String earno,String registno,String nodetype,String businessno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        //声明DTO
        PrplcompensateearDto prplcompensateearDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prplcompensateearDto = blPrplcompensateearAction.findByPrimaryKey(dbManager,earno, registno, nodetype,businessno);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplcompensateearDto;
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
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplcompensateearAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prplcompensateearDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplcompensateearAction.findByConditions(dbManager,conditions);
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
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplcompensateearAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getInprocessCount(String policyno,String earno) 
        throws Exception{
        int rowCount=0;

        DBManager dbManager = new DBManager();
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplcompensateearAction.getInprocessCount(dbManager,policyno,earno);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    /**
     * 查询满足模糊查询条件的预计给付金额
     * @param conditions conditions
     * @return 满足模糊查询条件的预计给付金额
     * @throws Exception
     */
    public double getSumLoss(String conditions) 
        throws Exception{
        double sumLoss=0.00;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplcompensateearAction blPrplcompensateearAction = new BLPrplcompensateearAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            sumLoss = blPrplcompensateearAction.getSumLoss(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sumLoss;
    }
}
