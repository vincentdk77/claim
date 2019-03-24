package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLMidResultConfigAction;
import com.sinosoft.claim.dto.domain.MidResultConfigDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是MidResultConfig结果页面配置表的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-11 10:51:28.265<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLMidResultConfigFacadeBase{
    private static Log logger = LogFactory.getLog(BLMidResultConfigFacadeBase.class);

    /**
     * 构造函数
     */
    public BLMidResultConfigFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param midResultConfigDto midResultConfigDto
     * @throws Exception
     */
    public void insert(MidResultConfigDto midResultConfigDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLMidResultConfigAction blMidResultConfigAction = new BLMidResultConfigAction();
        try{
	    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //插入记录
            blMidResultConfigAction.insert(dbManager,midResultConfigDto);
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
     * @param configOwner 配置归属者
     * @param resultType 结果页面类型
     * @param itemNo 项目序号
     * @throws Exception
     */
    public void delete(String configOwner,String resultType,int itemNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLMidResultConfigAction blMidResultConfigAction = new BLMidResultConfigAction();
        try{
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //删除记录
            blMidResultConfigAction.delete(dbManager,configOwner, resultType, itemNo);
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
        BLMidResultConfigAction blMidResultConfigAction = new BLMidResultConfigAction();
        try{
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //按条件删除记录
            blMidResultConfigAction.deleteByConditions(dbManager,conditions);
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
     * @param midResultConfigDto midResultConfigDto
     * @throws Exception
     */
    public void update(MidResultConfigDto midResultConfigDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLMidResultConfigAction blMidResultConfigAction = new BLMidResultConfigAction();
        try{
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            //更新记录
            blMidResultConfigAction.update(dbManager,midResultConfigDto);
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
     * @param configOwner 配置归属者
     * @param resultType 结果页面类型
     * @param itemNo 项目序号
     * @return midResultConfigDto midResultConfigDto
     * @throws Exception
     */
    public MidResultConfigDto findByPrimaryKey(String configOwner,String resultType,int itemNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLMidResultConfigAction blMidResultConfigAction = new BLMidResultConfigAction();
        //声明DTO
        MidResultConfigDto midResultConfigDto = null;
        try{
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            //查询数据,赋值给DTO
            midResultConfigDto = blMidResultConfigAction.findByPrimaryKey(dbManager,configOwner, resultType, itemNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return midResultConfigDto;
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
        BLMidResultConfigAction blMidResultConfigAction = new BLMidResultConfigAction();
        try{
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            pageRecord = blMidResultConfigAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含midResultConfigDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLMidResultConfigAction blMidResultConfigAction = new BLMidResultConfigAction();
        try{
    	     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;			
            collection = blMidResultConfigAction.findByConditions(dbManager,conditions);
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
        BLMidResultConfigAction blMidResultConfigAction = new BLMidResultConfigAction();
        try{
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            rowCount = blMidResultConfigAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
