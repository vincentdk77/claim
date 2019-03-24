package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.InsuremainlistDto;
import com.gyic.claim.bl.action.domain.BLInsuremainlistAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是投保清单头表的业务逻辑对象Facade基类<br>
 */
public class BLInsuremainlistFacadeBase{
    private static Logger logger = Logger.getLogger(BLInsuremainlistFacadeBase.class);

    /**
     * 构造函数
     */
    public BLInsuremainlistFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param insuremainlistDto insuremainlistDto
     * @throws Exception
     */
    public void insert(InsuremainlistDto insuremainlistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLInsuremainlistAction blInsuremainlistAction = new BLInsuremainlistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //插入记录
            blInsuremainlistAction.insert(dbManager,insuremainlistDto);
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
     * @param inusrelistcode 投保清单编号
     * @throws Exception
     */
    public void delete(String inusrelistcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLInsuremainlistAction blInsuremainlistAction = new BLInsuremainlistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //删除记录
            blInsuremainlistAction.delete(dbManager,inusrelistcode);
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
        BLInsuremainlistAction blInsuremainlistAction = new BLInsuremainlistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blInsuremainlistAction.deleteByConditions(dbManager,conditions);
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
     * @param insuremainlistDto insuremainlistDto
     * @throws Exception
     */
    public void update(InsuremainlistDto insuremainlistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLInsuremainlistAction blInsuremainlistAction = new BLInsuremainlistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //更新记录
            blInsuremainlistAction.update(dbManager,insuremainlistDto);
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
     * @param inusrelistcode 投保清单编号
     * @return insuremainlistDto insuremainlistDto
     * @throws Exception
     */
    public InsuremainlistDto findByPrimaryKey(String inusrelistcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLInsuremainlistAction blInsuremainlistAction = new BLInsuremainlistAction();
        //声明DTO
        InsuremainlistDto insuremainlistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //查询数据,赋值给DTO
            insuremainlistDto = blInsuremainlistAction.findByPrimaryKey(dbManager,inusrelistcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return insuremainlistDto;
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
        BLInsuremainlistAction blInsuremainlistAction = new BLInsuremainlistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blInsuremainlistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含insuremainlistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLInsuremainlistAction blInsuremainlistAction = new BLInsuremainlistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blInsuremainlistAction.findByConditions(dbManager,conditions);
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
        BLInsuremainlistAction blInsuremainlistAction = new BLInsuremainlistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blInsuremainlistAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
    /**
     * 按条件查询多条数据--新农险
     * @param conditions 查询条件
     * @return Collection 包含insuremainlistDto的集合
     * @throws Exception
     */
    public Collection findNewAgriByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLInsuremainlistAction blInsuremainlistAction = new BLInsuremainlistAction();
        try{
            dbManager.open("NewNXDADataSource");
            collection = blInsuremainlistAction.findByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
}
