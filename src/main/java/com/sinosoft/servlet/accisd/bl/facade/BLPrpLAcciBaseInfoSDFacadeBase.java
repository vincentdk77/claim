package com.sinosoft.servlet.accisd.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.servlet.accisd.bl.action.domain.BLPrpLAcciBaseInfoSDAction;
import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciBaseInfoSDDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLACCIBASEINFOSD的业务逻辑对象Facade基类<br>
 */
public class BLPrpLAcciBaseInfoSDFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLAcciBaseInfoSDFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpLAcciBaseInfoSDFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prplaccibaseinfosdDto prplaccibaseinfosdDto
     * @throws Exception
     */
    public void insert(PrpLAcciBaseInfoSDDto prplaccibaseinfosdDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciBaseInfoSDAction blPrplaccibaseinfosdAction = new BLPrpLAcciBaseInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrplaccibaseinfosdAction.insert(dbManager,prplaccibaseinfosdDto);
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
     * @param name NAME
     * @throws Exception
     */
    public void delete(String name,String credentialType,String credentialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciBaseInfoSDAction blPrplaccibaseinfosdAction = new BLPrpLAcciBaseInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blPrplaccibaseinfosdAction.delete(dbManager,name,credentialType,credentialNo);
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
        BLPrpLAcciBaseInfoSDAction blPrplaccibaseinfosdAction = new BLPrpLAcciBaseInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blPrplaccibaseinfosdAction.deleteByConditions(dbManager,conditions);
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
     * @param prplaccibaseinfosdDto prplaccibaseinfosdDto
     * @throws Exception
     */
    public void update(PrpLAcciBaseInfoSDDto prplaccibaseinfosdDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciBaseInfoSDAction blPrplaccibaseinfosdAction = new BLPrpLAcciBaseInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blPrplaccibaseinfosdAction.update(dbManager,prplaccibaseinfosdDto);
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
     * @param name NAME
     * @return prplaccibaseinfosdDto prplaccibaseinfosdDto
     * @throws Exception
     */
    public PrpLAcciBaseInfoSDDto findByPrimaryKey(String name,String credentialType,String credentialNo )
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciBaseInfoSDAction blPrplaccibaseinfosdAction = new BLPrpLAcciBaseInfoSDAction();
        //声明DTO
        PrpLAcciBaseInfoSDDto prplaccibaseinfosdDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prplaccibaseinfosdDto = blPrplaccibaseinfosdAction.findByPrimaryKey(dbManager,name,credentialType,credentialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplaccibaseinfosdDto;
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
        BLPrpLAcciBaseInfoSDAction blPrplaccibaseinfosdAction = new BLPrpLAcciBaseInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplaccibaseinfosdAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含prplaccibaseinfosdDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLAcciBaseInfoSDAction blPrplaccibaseinfosdAction = new BLPrpLAcciBaseInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplaccibaseinfosdAction.findByConditions(dbManager,conditions);
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
        BLPrpLAcciBaseInfoSDAction blPrplaccibaseinfosdAction = new BLPrpLAcciBaseInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplaccibaseinfosdAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
