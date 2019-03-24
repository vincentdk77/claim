package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeDto;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayNoticeAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是通知单表的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayNoticeFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayNoticeFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLpayNoticeFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLpayNoticeDto prpLpayNoticeDto
     * @throws Exception
     */
    public void insert(PrpLpayNoticeDto prpLpayNoticeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayNoticeAction blPrpLpayNoticeAction = new BLPrpLpayNoticeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLpayNoticeAction.insert(dbManager,prpLpayNoticeDto);
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
     * @param noticeNo 通知单号
     * @throws Exception
     */
    public void delete(String noticeNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayNoticeAction blPrpLpayNoticeAction = new BLPrpLpayNoticeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLpayNoticeAction.delete(dbManager,noticeNo);
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
        BLPrpLpayNoticeAction blPrpLpayNoticeAction = new BLPrpLpayNoticeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLpayNoticeAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLpayNoticeDto prpLpayNoticeDto
     * @throws Exception
     */
    public void update(PrpLpayNoticeDto prpLpayNoticeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayNoticeAction blPrpLpayNoticeAction = new BLPrpLpayNoticeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLpayNoticeAction.update(dbManager,prpLpayNoticeDto);
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
     * @param noticeNo 通知单号
     * @return prpLpayNoticeDto prpLpayNoticeDto
     * @throws Exception
     */
    public PrpLpayNoticeDto findByPrimaryKey(String noticeNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayNoticeAction blPrpLpayNoticeAction = new BLPrpLpayNoticeAction();
        //声明DTO
        PrpLpayNoticeDto prpLpayNoticeDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLpayNoticeDto = blPrpLpayNoticeAction.findByPrimaryKey(dbManager,noticeNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLpayNoticeDto;
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
        BLPrpLpayNoticeAction blPrpLpayNoticeAction = new BLPrpLpayNoticeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpayNoticeAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLpayNoticeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpayNoticeAction blPrpLpayNoticeAction = new BLPrpLpayNoticeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLpayNoticeAction.findByConditions(dbManager,conditions);
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
        BLPrpLpayNoticeAction blPrpLpayNoticeAction = new BLPrpLpayNoticeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLpayNoticeAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
