package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31PolicyListDto;
import com.gyic.claim.bl.action.domain.BLPlanting31PolicyListAction;
import com.gyic.claim.bl.action.domain.BLPlantingpolicylistAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是Planting31PolicyList的业务逻辑对象Facade基类<br>
 */
public class BLPlanting31PolicyListFacadeBase{
    private static Logger logger = Logger.getLogger(BLPlanting31PolicyListFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPlanting31PolicyListFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param planting31PolicyListDto planting31PolicyListDto
     * @throws Exception
     */
    public void insert(Planting31PolicyListDto planting31PolicyListDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlanting31PolicyListAction blPlanting31PolicyListAction = new BLPlanting31PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //插入记录
            blPlanting31PolicyListAction.insert(dbManager,planting31PolicyListDto);
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
     * @param inusreListCode InusreListCode
     * @throws Exception
     */
    public void delete(String inusreListCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlanting31PolicyListAction blPlanting31PolicyListAction = new BLPlanting31PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //删除记录
            blPlanting31PolicyListAction.delete(dbManager,inusreListCode);
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
        BLPlanting31PolicyListAction blPlanting31PolicyListAction = new BLPlanting31PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blPlanting31PolicyListAction.deleteByConditions(dbManager,conditions);
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
     * @param planting31PolicyListDto planting31PolicyListDto
     * @throws Exception
     */
    public void update(Planting31PolicyListDto planting31PolicyListDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlanting31PolicyListAction blPlanting31PolicyListAction = new BLPlanting31PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //更新记录
            blPlanting31PolicyListAction.update(dbManager,planting31PolicyListDto);
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
     * @param inusreListCode InusreListCode
     * @return planting31PolicyListDto planting31PolicyListDto
     * @throws Exception
     */
    public Planting31PolicyListDto findByPrimaryKey(String inusreListCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlanting31PolicyListAction blPlanting31PolicyListAction = new BLPlanting31PolicyListAction();
        //声明DTO
        Planting31PolicyListDto planting31PolicyListDto = null;
        try{
            dbManager.open("NXDADataSource");
            //查询数据,赋值给DTO
            planting31PolicyListDto = blPlanting31PolicyListAction.findByPrimaryKey(dbManager,inusreListCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return planting31PolicyListDto;
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
        BLPlanting31PolicyListAction blPlanting31PolicyListAction = new BLPlanting31PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blPlanting31PolicyListAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含planting31PolicyListDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPlanting31PolicyListAction blPlanting31PolicyListAction = new BLPlanting31PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blPlanting31PolicyListAction.findByConditions(dbManager,conditions);
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
        BLPlanting31PolicyListAction blPlanting31PolicyListAction = new BLPlanting31PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blPlanting31PolicyListAction.getCount(dbManager,conditions);
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
        BLPlanting31PolicyListAction blPlanting31PolicyListAction = new BLPlanting31PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blPlanting31PolicyListAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
}
