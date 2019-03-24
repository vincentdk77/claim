package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpDcompanyAction;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcompany机构代码表的业务逻辑对象Facade基类<br>
 * 创建于 2004-08-25 16:51:30.344<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcompanyFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpDcompanyFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpDcompanyFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpDcompanyDto prpDcompanyDto
     * @throws Exception
     */
    public void insert(PrpDcompanyDto prpDcompanyDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDcompanyAction blPrpDcompanyAction = new BLPrpDcompanyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpDcompanyAction.insert(dbManager,prpDcompanyDto);
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
     * @param comCode 机构代码
     * @throws Exception
     */
    public void delete(String comCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDcompanyAction blPrpDcompanyAction = new BLPrpDcompanyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrpDcompanyAction.delete(dbManager,comCode);
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
        BLPrpDcompanyAction blPrpDcompanyAction = new BLPrpDcompanyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpDcompanyAction.deleteByConditions(dbManager,conditions);
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
     * @param prpDcompanyDto prpDcompanyDto
     * @throws Exception
     */
    public void update(PrpDcompanyDto prpDcompanyDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDcompanyAction blPrpDcompanyAction = new BLPrpDcompanyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrpDcompanyAction.update(dbManager,prpDcompanyDto);
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
     * @param comCode 机构代码
     * @return prpDcompanyDto prpDcompanyDto
     * @throws Exception
     */
    public PrpDcompanyDto findByPrimaryKey(String comCode) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDcompanyAction blPrpDcompanyAction = new BLPrpDcompanyAction();
        //声明DTO
        PrpDcompanyDto prpDcompanyDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpDcompanyDto = blPrpDcompanyAction.findByPrimaryKey(dbManager,comCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpDcompanyDto;
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
        BLPrpDcompanyAction blPrpDcompanyAction = new BLPrpDcompanyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpDcompanyAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prpDcompanyDto的集合
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
        BLPrpDcompanyAction blPrpDcompanyAction = new BLPrpDcompanyAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpDcompanyAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
