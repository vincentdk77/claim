package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpDriskAction;
import com.sinosoft.claim.dto.domain.PrpDriskDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdrisk险种代码表的业务逻辑对象Facade基类<br>
 * 创建于 2004-08-25 16:51:30.344<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDriskFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpDriskFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpDriskFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpDriskDto prpDriskDto
     * @throws Exception
     */
    public void insert(PrpDriskDto prpDriskDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDriskAction blPrpDriskAction = new BLPrpDriskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpDriskAction.insert(dbManager,prpDriskDto);
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
     * @param riskCode 险种代码
     * @throws Exception
     */
    public void delete(String riskCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDriskAction blPrpDriskAction = new BLPrpDriskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpDriskAction.delete(dbManager,riskCode);
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
        BLPrpDriskAction blPrpDriskAction = new BLPrpDriskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpDriskAction.deleteByConditions(dbManager,conditions);
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
     * @param prpDriskDto prpDriskDto
     * @throws Exception
     */
    public void update(PrpDriskDto prpDriskDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDriskAction blPrpDriskAction = new BLPrpDriskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpDriskAction.update(dbManager,prpDriskDto);
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
     * @param riskCode 险种代码
     * @return prpDriskDto prpDriskDto
     * @throws Exception
     */
    public PrpDriskDto findByPrimaryKey(String riskCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDriskAction blPrpDriskAction = new BLPrpDriskAction();
        //声明DTO
        PrpDriskDto prpDriskDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpDriskDto = blPrpDriskAction.findByPrimaryKey(dbManager,riskCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpDriskDto;
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
        BLPrpDriskAction blPrpDriskAction = new BLPrpDriskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpDriskAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpDriskDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
      return findByConditions(conditions,0,0).getResult();
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
        BLPrpDriskAction blPrpDriskAction = new BLPrpDriskAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpDriskAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
