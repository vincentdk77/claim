package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Zh03PolicyListDto;
import com.gyic.claim.bl.action.domain.BLZh03PolicyListAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是ZH03PolicyList的业务逻辑对象Facade基类<br>
 */
public class BLZh03PolicyListFacadeBase{
    private static Logger logger = Logger.getLogger(BLZh03PolicyListFacadeBase.class);

    /**
     * 构造函数
     */
    public BLZh03PolicyListFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param zh03PolicyListDto zh03PolicyListDto
     * @throws Exception
     */
    public void insert(Zh03PolicyListDto zh03PolicyListDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLZh03PolicyListAction blZh03PolicyListAction = new BLZh03PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //插入记录
            blZh03PolicyListAction.insert(dbManager,zh03PolicyListDto);
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
        BLZh03PolicyListAction blZh03PolicyListAction = new BLZh03PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //删除记录
            blZh03PolicyListAction.delete(dbManager,inusreListCode);
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
        BLZh03PolicyListAction blZh03PolicyListAction = new BLZh03PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blZh03PolicyListAction.deleteByConditions(dbManager,conditions);
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
     * @param zh03PolicyListDto zh03PolicyListDto
     * @throws Exception
     */
    public void update(Zh03PolicyListDto zh03PolicyListDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLZh03PolicyListAction blZh03PolicyListAction = new BLZh03PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //更新记录
            blZh03PolicyListAction.update(dbManager,zh03PolicyListDto);
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
     * @return zh03PolicyListDto zh03PolicyListDto
     * @throws Exception
     */
    public Zh03PolicyListDto findByPrimaryKey(String inusreListCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLZh03PolicyListAction blZh03PolicyListAction = new BLZh03PolicyListAction();
        //声明DTO
        Zh03PolicyListDto zh03PolicyListDto = null;
        try{
            dbManager.open("NXDADataSource");
            //查询数据,赋值给DTO
            zh03PolicyListDto = blZh03PolicyListAction.findByPrimaryKey(dbManager,inusreListCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return zh03PolicyListDto;
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
        BLZh03PolicyListAction blZh03PolicyListAction = new BLZh03PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blZh03PolicyListAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含zh03PolicyListDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLZh03PolicyListAction blZh03PolicyListAction = new BLZh03PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blZh03PolicyListAction.findByConditions(dbManager,conditions);
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
        BLZh03PolicyListAction blZh03PolicyListAction = new BLZh03PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blZh03PolicyListAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findFamilyNoByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLZh03PolicyListAction blZh03PolicylistAction = new BLZh03PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blZh03PolicylistAction.findFamilyNoByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
}
