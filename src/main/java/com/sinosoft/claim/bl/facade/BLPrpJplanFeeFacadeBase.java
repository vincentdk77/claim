package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpJplanFeeAction;
import com.sinosoft.claim.dto.domain.PrpJplanFeeDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是应收应付费信息表的业务逻辑对象Facade基类<br>
 */
public class BLPrpJplanFeeFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpJplanFeeFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpJplanFeeFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpJplanFeeDto prpJplanFeeDto
     * @throws Exception
     */
    public void insert(PrpJplanFeeDto prpJplanFeeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpJplanFeeAction blPrpJplanFeeAction = new BLPrpJplanFeeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpJplanFeeAction.insert(dbManager,prpJplanFeeDto);
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
     * @param certiType 业务类型
     * @param certiNo 保单号码/批单号码
     * @param serialNo 交费计划序号
     * @param payRefReason 收付原因
     * @throws Exception
     */
    public void delete(String certiType,String certiNo,int serialNo,String payRefReason)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpJplanFeeAction blPrpJplanFeeAction = new BLPrpJplanFeeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();            dbManager.beginTransaction();
            //删除记录
            blPrpJplanFeeAction.delete(dbManager,certiType, certiNo, serialNo, payRefReason);
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
        BLPrpJplanFeeAction blPrpJplanFeeAction = new BLPrpJplanFeeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpJplanFeeAction.deleteByConditions(dbManager,conditions);
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
     * @param prpJplanFeeDto prpJplanFeeDto
     * @throws Exception
     */
    public void update(PrpJplanFeeDto prpJplanFeeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpJplanFeeAction blPrpJplanFeeAction = new BLPrpJplanFeeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            dbManager.beginTransaction();
            //更新记录
            blPrpJplanFeeAction.update(dbManager,prpJplanFeeDto);
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
     * @param certiType 业务类型
     * @param certiNo 保单号码/批单号码
     * @param serialNo 交费计划序号
     * @param payRefReason 收付原因
     * @return prpJplanFeeDto prpJplanFeeDto
     * @throws Exception
     */
    public PrpJplanFeeDto findByPrimaryKey(String certiType,String certiNo,int serialNo,String payRefReason)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpJplanFeeAction blPrpJplanFeeAction = new BLPrpJplanFeeAction();
        //声明DTO
        PrpJplanFeeDto prpJplanFeeDto = null;
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //查询数据,赋值给DTO
            prpJplanFeeDto = blPrpJplanFeeAction.findByPrimaryKey(dbManager,certiType, certiNo, serialNo, payRefReason);
            dbManager.commitTransaction();
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpJplanFeeDto;
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
        BLPrpJplanFeeAction blPrpJplanFeeAction = new BLPrpJplanFeeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            pageRecord = blPrpJplanFeeAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
            dbManager.commitTransaction();
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
     * @return Collection 包含prpJplanFeeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpJplanFeeAction blPrpJplanFeeAction = new BLPrpJplanFeeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            collection = blPrpJplanFeeAction.findByConditions(dbManager,conditions);
            dbManager.commitTransaction();
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
        BLPrpJplanFeeAction blPrpJplanFeeAction = new BLPrpJplanFeeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            rowCount = blPrpJplanFeeAction.getCount(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
