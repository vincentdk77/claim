package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLpersonLossAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpersonLossActionFG;
import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLpersonLoss-人员赔付信息表的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-18 17:53:38.468<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLpersonLossFacadeBaseFG{
    private static Log logger = LogFactory.getLog(BLPrpLpersonLossFacadeBaseFG.class);

    /**
     * 构造函数
     */
    public BLPrpLpersonLossFacadeBaseFG(){
    }

    /**
     * 插入一条数据
     * @param prpLpersonLossDto prpLpersonLossDto
     * @throws Exception
     */
    public void insert(PrpLpersonLossDto prpLpersonLossDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpersonLossAction blPrpLpersonLossAction = new BLPrpLpersonLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLpersonLossAction.insert(dbManager,prpLpersonLossDto);
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
     * @param compensateNo 赔款计算书号
     * @param serialNo 赔付标的序号
     * @throws Exception
     */
    public void delete(String compensateNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpersonLossAction blPrpLpersonLossAction = new BLPrpLpersonLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLpersonLossAction.delete(dbManager,compensateNo, serialNo);
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
        BLPrpLpersonLossAction blPrpLpersonLossAction = new BLPrpLpersonLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLpersonLossAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLpersonLossDto prpLpersonLossDto
     * @throws Exception
     */
    public void update(PrpLpersonLossDto prpLpersonLossDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpersonLossAction blPrpLpersonLossAction = new BLPrpLpersonLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLpersonLossAction.update(dbManager,prpLpersonLossDto);
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
     * @param compensateNo 赔款计算书号
     * @param serialNo 赔付标的序号
     * @return prpLpersonLossDto prpLpersonLossDto
     * @throws Exception
     */
    public PrpLpersonLossDto findByPrimaryKey(String compensateNo,int serialNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpersonLossAction blPrpLpersonLossAction = new BLPrpLpersonLossAction();
        //声明DTO
        PrpLpersonLossDto prpLpersonLossDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLpersonLossDto = blPrpLpersonLossAction.findByPrimaryKey(dbManager,compensateNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLpersonLossDto;
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
        BLPrpLpersonLossAction blPrpLpersonLossAction = new BLPrpLpersonLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpersonLossAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLpersonLossDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpersonLossActionFG blPrpLpersonLossAction = new BLPrpLpersonLossActionFG();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLpersonLossAction.findByConditions(dbManager,conditions);
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
        BLPrpLpersonLossAction blPrpLpersonLossAction = new BLPrpLpersonLossAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLpersonLossAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
