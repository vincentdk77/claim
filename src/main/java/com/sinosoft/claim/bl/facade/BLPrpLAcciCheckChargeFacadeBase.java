package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLAcciCheckChargeAction;
import com.sinosoft.claim.dto.domain.PrpLAcciCheckChargeDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是调查费用表-PrpLAcciCheckCharge的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLAcciCheckChargeFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLAcciCheckChargeFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLAcciCheckChargeFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpLAcciCheckChargeDto prpLAcciCheckChargeDto
     * @throws Exception
     */
    public void insert(PrpLAcciCheckChargeDto prpLAcciCheckChargeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciCheckChargeAction blPrpLAcciCheckChargeAction = new BLPrpLAcciCheckChargeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLAcciCheckChargeAction.insert(dbManager,prpLAcciCheckChargeDto);
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
     * @param checkNo 调查号-CheckNo
     * @param serialNo 序号-SerialNo
     * @throws Exception
     */
    public void delete(String checkNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciCheckChargeAction blPrpLAcciCheckChargeAction = new BLPrpLAcciCheckChargeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpLAcciCheckChargeAction.delete(dbManager,checkNo, serialNo);
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
        BLPrpLAcciCheckChargeAction blPrpLAcciCheckChargeAction = new BLPrpLAcciCheckChargeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpLAcciCheckChargeAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLAcciCheckChargeDto prpLAcciCheckChargeDto
     * @throws Exception
     */
    public void update(PrpLAcciCheckChargeDto prpLAcciCheckChargeDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciCheckChargeAction blPrpLAcciCheckChargeAction = new BLPrpLAcciCheckChargeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpLAcciCheckChargeAction.update(dbManager,prpLAcciCheckChargeDto);
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
     * @param checkNo 调查号-CheckNo
     * @param serialNo 序号-SerialNo
     * @return prpLAcciCheckChargeDto prpLAcciCheckChargeDto
     * @throws Exception
     */
    public PrpLAcciCheckChargeDto findByPrimaryKey(String checkNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciCheckChargeAction blPrpLAcciCheckChargeAction = new BLPrpLAcciCheckChargeAction();
        //声明DTO
        PrpLAcciCheckChargeDto prpLAcciCheckChargeDto = null;
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpLAcciCheckChargeDto = blPrpLAcciCheckChargeAction.findByPrimaryKey(dbManager,checkNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLAcciCheckChargeDto;
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
        BLPrpLAcciCheckChargeAction blPrpLAcciCheckChargeAction = new BLPrpLAcciCheckChargeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLAcciCheckChargeAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpLAcciCheckChargeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLAcciCheckChargeAction blPrpLAcciCheckChargeAction = new BLPrpLAcciCheckChargeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLAcciCheckChargeAction.findByConditions(dbManager,conditions);
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
        BLPrpLAcciCheckChargeAction blPrpLAcciCheckChargeAction = new BLPrpLAcciCheckChargeAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLAcciCheckChargeAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
