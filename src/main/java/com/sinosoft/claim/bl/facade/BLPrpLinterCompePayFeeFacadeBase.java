package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLinterCompePayFeeAction;
import com.sinosoft.claim.dto.domain.PrpLinterCompePayFeeDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是计算书赔款费用信息的业务逻辑对象Facade基类<br>
 */
public class BLPrpLinterCompePayFeeFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCompePayFeeFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterCompePayFeeFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLinterCompePayFeeDto prpLinterCompePayFeeDto
     * @throws Exception
     */
    public void insert(PrpLinterCompePayFeeDto prpLinterCompePayFeeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCompePayFeeAction blPrpLinterCompePayFeeAction = new BLPrpLinterCompePayFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLinterCompePayFeeAction.insert(dbManager,prpLinterCompePayFeeDto);
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
     * @param id 主键pk
     * @param serialNo 主键序号pk
     * @throws Exception
     */
    public void delete(String id,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCompePayFeeAction blPrpLinterCompePayFeeAction = new BLPrpLinterCompePayFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLinterCompePayFeeAction.delete(dbManager,id, serialNo);
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
        BLPrpLinterCompePayFeeAction blPrpLinterCompePayFeeAction = new BLPrpLinterCompePayFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLinterCompePayFeeAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLinterCompePayFeeDto prpLinterCompePayFeeDto
     * @throws Exception
     */
    public void update(PrpLinterCompePayFeeDto prpLinterCompePayFeeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCompePayFeeAction blPrpLinterCompePayFeeAction = new BLPrpLinterCompePayFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLinterCompePayFeeAction.update(dbManager,prpLinterCompePayFeeDto);
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
     * @param id 主键pk
     * @param serialNo 主键序号pk
     * @return prpLinterCompePayFeeDto prpLinterCompePayFeeDto
     * @throws Exception
     */
    public PrpLinterCompePayFeeDto findByPrimaryKey(String id,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCompePayFeeAction blPrpLinterCompePayFeeAction = new BLPrpLinterCompePayFeeAction();
        //声明DTO
        PrpLinterCompePayFeeDto prpLinterCompePayFeeDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLinterCompePayFeeDto = blPrpLinterCompePayFeeAction.findByPrimaryKey(dbManager,id, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLinterCompePayFeeDto;
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
        BLPrpLinterCompePayFeeAction blPrpLinterCompePayFeeAction = new BLPrpLinterCompePayFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLinterCompePayFeeAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLinterCompePayFeeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinterCompePayFeeAction blPrpLinterCompePayFeeAction = new BLPrpLinterCompePayFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinterCompePayFeeAction.findByConditions(dbManager,conditions);
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
        BLPrpLinterCompePayFeeAction blPrpLinterCompePayFeeAction = new BLPrpLinterCompePayFeeAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLinterCompePayFeeAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
