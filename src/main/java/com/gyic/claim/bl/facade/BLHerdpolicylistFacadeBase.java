package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.HerdpolicylistDto;
import com.gyic.claim.bl.action.domain.BLHerdpolicylistAction;
import com.gyic.claim.bl.action.domain.BLPlantingpolicylistAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是HERDPOLICYLIST的业务逻辑对象Facade基类<br>
 */
public class BLHerdpolicylistFacadeBase{
    private static Logger logger = Logger.getLogger(BLHerdpolicylistFacadeBase.class);

    /**
     * 构造函数
     */
    public BLHerdpolicylistFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param herdpolicylistDto herdpolicylistDto
     * @throws Exception
     */
    public void insert(HerdpolicylistDto herdpolicylistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //插入记录
            blHerdpolicylistAction.insert(dbManager,herdpolicylistDto);
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
     * @param inusrelistcode INUSRELISTCODE
     * @param earlabel EARLABEL
     * @param kindcode KINDCODE
     * @param fcode FCODE
     * @throws Exception
     */
    public void delete(String inusrelistcode,String earlabel,String kindcode,String fcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //删除记录
            blHerdpolicylistAction.delete(dbManager,inusrelistcode, earlabel, kindcode, fcode);
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
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blHerdpolicylistAction.deleteByConditions(dbManager,conditions);
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
     * @param herdpolicylistDto herdpolicylistDto
     * @throws Exception
     */
    public void update(HerdpolicylistDto herdpolicylistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //更新记录
            blHerdpolicylistAction.update(dbManager,herdpolicylistDto);
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
     * @param inusrelistcode INUSRELISTCODE
     * @param earlabel EARLABEL
     * @param kindcode KINDCODE
     * @param fcode FCODE
     * @return herdpolicylistDto herdpolicylistDto
     * @throws Exception
     */
    public HerdpolicylistDto findByPrimaryKey(String inusrelistcode,String earlabel,String kindcode,String fcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        //声明DTO
        HerdpolicylistDto herdpolicylistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //查询数据,赋值给DTO
            herdpolicylistDto = blHerdpolicylistAction.findByPrimaryKey(dbManager,inusrelistcode, earlabel, kindcode, fcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return herdpolicylistDto;
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
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blHerdpolicylistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含herdpolicylistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blHerdpolicylistAction.findByConditions(dbManager,conditions);
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
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blHerdpolicylistAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @param fieldName 字段名
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public double getSum(String conditions, String fieldName)
        throws Exception{
        double sum=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blHerdpolicylistAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
    
    /**
     * 按条件查询多条数据--新农险
     * @param conditions 查询条件
     * @return Collection 包含herdpolicylistDto的集合
     * @throws Exception
     */
    public Collection findNewAgriByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NewNXDADataSource");
            collection = blHerdpolicylistAction.findByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
}
