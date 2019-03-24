package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLED_AGENT_INFOAction;
import com.sinosoft.claim.dto.domain.ED_AGENT_INFODto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是座席员工信息表的业务逻辑对象Facade基类<br>
 * 创建于 2005-07-19 09:59:06.511<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLED_AGENT_INFOFacadeBase{
    private static Log logger = LogFactory.getLog(BLED_AGENT_INFOFacadeBase.class);

    /**
     * 构造函数
     */
    public BLED_AGENT_INFOFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param eD_AGENT_INFODto eD_AGENT_INFODto
     * @throws Exception
     */
    public void insert(ED_AGENT_INFODto eD_AGENT_INFODto) throws Exception{
        DBManager dbManager = new DBManager();
        BLED_AGENT_INFOAction blED_AGENT_INFOAction = new BLED_AGENT_INFOAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(AppConfig.get("sysconst.DDCCJNDI")) ;
            dbManager.beginTransaction();
            //插入记录
            blED_AGENT_INFOAction.insert(dbManager,eD_AGENT_INFODto);
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
     * @param aGENTID 座席工号
     * @throws Exception
     */
    public void delete(String aGENTID) throws Exception{
        DBManager dbManager = new DBManager();
        BLED_AGENT_INFOAction blED_AGENT_INFOAction = new BLED_AGENT_INFOAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(AppConfig.get("sysconst.DDCCJNDI")) ;
            dbManager.beginTransaction();
            //删除记录
            blED_AGENT_INFOAction.delete(dbManager,aGENTID);
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
        BLED_AGENT_INFOAction blED_AGENT_INFOAction = new BLED_AGENT_INFOAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(AppConfig.get("sysconst.DDCCJNDI")) ;
            dbManager.beginTransaction();
            //按条件删除记录
            blED_AGENT_INFOAction.deleteByConditions(dbManager,conditions);
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
     * @param eD_AGENT_INFODto eD_AGENT_INFODto
     * @throws Exception
     */
    public void update(ED_AGENT_INFODto eD_AGENT_INFODto) throws Exception{
        DBManager dbManager = new DBManager();
        BLED_AGENT_INFOAction blED_AGENT_INFOAction = new BLED_AGENT_INFOAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(AppConfig.get("sysconst.DDCCJNDI")) ;
            dbManager.beginTransaction();
            //更新记录
            blED_AGENT_INFOAction.update(dbManager,eD_AGENT_INFODto);
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
     * @param aGENTID 座席工号
     * @return eD_AGENT_INFODto eD_AGENT_INFODto
     * @throws Exception
     */
    public ED_AGENT_INFODto findByPrimaryKey(String aGENTID) throws Exception{
        DBManager dbManager = new DBManager();
        BLED_AGENT_INFOAction blED_AGENT_INFOAction = new BLED_AGENT_INFOAction();
        //声明DTO
        ED_AGENT_INFODto eD_AGENT_INFODto = null;
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(AppConfig.get("sysconst.DDCCJNDI")) ;
            //查询数据,赋值给DTO
            eD_AGENT_INFODto = blED_AGENT_INFOAction.findByPrimaryKey(dbManager,aGENTID);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return eD_AGENT_INFODto;
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
        BLED_AGENT_INFOAction blED_AGENT_INFOAction = new BLED_AGENT_INFOAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	 dbManager.open(AppConfig.get("sysconst.DDCCJNDI")) ;
            pageRecord = blED_AGENT_INFOAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含eD_AGENT_INFODto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLED_AGENT_INFOAction blED_AGENT_INFOAction = new BLED_AGENT_INFOAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(AppConfig.get("sysconst.DDCCJNDI")) ;
            collection = blED_AGENT_INFOAction.findByConditions(dbManager,conditions);
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
        BLED_AGENT_INFOAction blED_AGENT_INFOAction = new BLED_AGENT_INFOAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(AppConfig.get("sysconst.DDCCJNDI")) ;
            rowCount = blED_AGENT_INFOAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
