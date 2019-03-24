package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLpayHisAction;
import com.sinosoft.claim.dto.domain.PrpLpayHisDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是prpLpayHis的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayHisFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayHisFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLpayHisFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLpayHisDto prpLpayHisDto
     * @throws Exception
     */
    public void insert(PrpLpayHisDto prpLpayHisDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLpayHisAction.insert(dbManager,prpLpayHisDto);
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
     * @param serialNo serialNo
     * @param serialNo2 serialNo2
     * @throws Exception
     */
    public void delete(String serialNo,String serialNo2)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLpayHisAction.delete(dbManager,serialNo, serialNo2);
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
        BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLpayHisAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLpayHisDto prpLpayHisDto
     * @throws Exception
     */
    public void update(PrpLpayHisDto prpLpayHisDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLpayHisAction.update(dbManager,prpLpayHisDto);
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
     * @param serialNo serialNo
     * @param serialNo2 serialNo2
     * @return prpLpayHisDto prpLpayHisDto
     * @throws Exception
     */
    public PrpLpayHisDto findByPrimaryKey(String serialNo,String serialNo2)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
        //声明DTO
        PrpLpayHisDto prpLpayHisDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLpayHisDto = blPrpLpayHisAction.findByPrimaryKey(dbManager,serialNo, serialNo2);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLpayHisDto;
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
        BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpayHisAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLpayHisDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLpayHisAction.findByConditions(dbManager,conditions);
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
        BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLpayHisAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
