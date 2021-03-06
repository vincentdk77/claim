package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpPcoinsDetailAction;
import com.sinosoft.claim.dto.domain.PrpPcoinsDetailDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpPcoinsDetail的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpPcoinsDetailFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpPcoinsDetailFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpPcoinsDetailFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpPcoinsDetailDto prpPcoinsDetailDto
     * @throws Exception
     */
    public void insert(PrpPcoinsDetailDto prpPcoinsDetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPcoinsDetailAction blPrpPcoinsDetailAction = new BLPrpPcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpPcoinsDetailAction.insert(dbManager,prpPcoinsDetailDto);
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
     * @param endorseNo endorseNo
     * @param serialNo serialNo
     * @param currency currency
     * @throws Exception
     */
    public void delete(String endorseNo,long serialNo,String currency)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPcoinsDetailAction blPrpPcoinsDetailAction = new BLPrpPcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpPcoinsDetailAction.delete(dbManager,endorseNo, serialNo, currency);
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
        BLPrpPcoinsDetailAction blPrpPcoinsDetailAction = new BLPrpPcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpPcoinsDetailAction.deleteByConditions(dbManager,conditions);
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
     * @param prpPcoinsDetailDto prpPcoinsDetailDto
     * @throws Exception
     */
    public void update(PrpPcoinsDetailDto prpPcoinsDetailDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPcoinsDetailAction blPrpPcoinsDetailAction = new BLPrpPcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpPcoinsDetailAction.update(dbManager,prpPcoinsDetailDto);
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
     * @param endorseNo endorseNo
     * @param serialNo serialNo
     * @param currency currency
     * @return prpPcoinsDetailDto prpPcoinsDetailDto
     * @throws Exception
     */
    public PrpPcoinsDetailDto findByPrimaryKey(String endorseNo,long serialNo,String currency)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPcoinsDetailAction blPrpPcoinsDetailAction = new BLPrpPcoinsDetailAction();
        //声明DTO
        PrpPcoinsDetailDto prpPcoinsDetailDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpPcoinsDetailDto = blPrpPcoinsDetailAction.findByPrimaryKey(dbManager,endorseNo, serialNo, currency);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpPcoinsDetailDto;
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
        BLPrpPcoinsDetailAction blPrpPcoinsDetailAction = new BLPrpPcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpPcoinsDetailAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpPcoinsDetailDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpPcoinsDetailAction blPrpPcoinsDetailAction = new BLPrpPcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpPcoinsDetailAction.findByConditions(dbManager,conditions);
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
        BLPrpPcoinsDetailAction blPrpPcoinsDetailAction = new BLPrpPcoinsDetailAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpPcoinsDetailAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
