package com.sinosoft.claim.bl.facade;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.ui.control.viewHelper.LossProcessDto;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrplpaytgAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLPAY的业务逻辑对象tgFacade基类<br>
 */
public class BLPrplpaytgFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplpaytgFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrplpaytgFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prplpaytgDto prplpaytgDto
     * @throws Exception
     */
    public void insert(PrplpayDto prplpaytgDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //插入记录
            blPrplpaytgAction.insert(dbManager,prplpaytgDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    public void save(HttpServletRequest request,String vflag)
    throws Exception{
        DBManager dbManager = new DBManager();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //插入记录
            LossProcessDto lp=new LossProcessDto();
            lp.saveOrUpdatePay(dbManager, request, null,vflag);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            exception.printStackTrace();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    public void save(HttpServletRequest request,WorkFlowDto workFlowDto)
    throws Exception{
        DBManager dbManager = new DBManager();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //插入记录
            LossProcessDto lp=new LossProcessDto();
            //
            lp.saveOrUpdatePay(dbManager, request, null,"");
            if(workFlowDto!=null){
                new BLWorkFlowAction().deal(dbManager,workFlowDto);
            }
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            exception.printStackTrace();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按主键删除一条数据
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @throws Exception
     */
//    public void delete(String serialno,String compensateno)
//        throws Exception{
//        DBManager dbManager = new DBManager();
//        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
//        try{
//        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
//            dbManager.beginTransaction();
//            //删除记录
//            blPrplpaytgAction.delete(dbManager,serialno, compensateno);
//            dbManager.commitTransaction();
//        }catch(Exception exception){
//            dbManager.rollbackTransaction();
//            throw exception;
//        }finally{
//            dbManager.close();
//        }
//    }
    /**
     * 按主键删除一条数据
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @param serialno2 SERIALNO2
     * @throws Exception
     */
    public void delete(String serialno,String compensateno,String serialno2)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrplpaytgAction.delete(dbManager,serialno, compensateno, serialno2);
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
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //按条件删除记录
            blPrplpaytgAction.deleteByConditions(dbManager,conditions);
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
     * @param prplpaytgDto prplpaytgDto
     * @throws Exception
     */
    public void update(PrplpayDto prplpaytgDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //更新记录
            blPrplpaytgAction.update(dbManager,prplpaytgDto);
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
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @return prplpaytgDto prplpaytgDto
     * @throws Exception
     */
//    public PrplpayDto findByPrimaryKey(String serialno,String compensateno)
//        throws Exception{
//        DBManager dbManager = new DBManager();
//        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
//        //声明DTO
//        PrplpayDto prplpaytgDto = null;
//        try{
//        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
//            //查询数据,赋值给DTO
//            prplpaytgDto = blPrplpaytgAction.findByPrimaryKey(dbManager,serialno, compensateno);
//        }catch(Exception exception){
//            throw exception;
//        }finally{
//            dbManager.close();
//        }
//        return prplpaytgDto;
//    }
    /**
     * 按主键查找一条数据
     * @param serialno SERIALNO
     * @param compensateno COMPENSATENO
     * @param serialno2 SERIALNO2
     * @return prplpaytgDto prplpaytgDto
     * @throws Exception
     */
    public PrplpayDto findByPrimaryKey(String serialno,String compensateno,String serialno2)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        //声明DTO
        PrplpayDto prplpaytgDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prplpaytgDto = blPrplpaytgAction.findByPrimaryKey(dbManager,serialno, compensateno, serialno2);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplpaytgDto;
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
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            pageRecord = blPrplpaytgAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prplpayDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            collection = blPrplpaytgAction.findByConditions(dbManager,conditions);
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
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            rowCount = blPrplpaytgAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    /**
     * 按条件查询多条数据 相同计算书,收付原因,联共保人金额求和
     * @param conditions 查询条件
     * @return Collection 包含prplpayDto的集合
     * @throws Exception
     */
    public Collection getSumPayamount(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplpaytgAction blPrplpaytgAction = new BLPrplpaytgAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            collection = blPrplpaytgAction.getSumPayamount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
}
