package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Zh03InsuranceListDto;
import com.gyic.claim.bl.action.domain.BLZh03InsuranceListAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是ZH03InsuranceList的业务逻辑对象Facade基类<br>
 */
public class BLZh03InsuranceListFacadeBase{
    private static Logger logger = Logger.getLogger(BLZh03InsuranceListFacadeBase.class);

    /**
     * 构造函数
     */
    public BLZh03InsuranceListFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param zh03InsuranceListDto zh03InsuranceListDto
     * @throws Exception
     */
    public void insert(Zh03InsuranceListDto zh03InsuranceListDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLZh03InsuranceListAction blZh03InsuranceListAction = new BLZh03InsuranceListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //插入记录
            blZh03InsuranceListAction.insert(dbManager,zh03InsuranceListDto);
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
        BLZh03InsuranceListAction blZh03InsuranceListAction = new BLZh03InsuranceListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //删除记录
            blZh03InsuranceListAction.delete(dbManager,inusreListCode);
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
        BLZh03InsuranceListAction blZh03InsuranceListAction = new BLZh03InsuranceListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blZh03InsuranceListAction.deleteByConditions(dbManager,conditions);
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
     * @param zh03InsuranceListDto zh03InsuranceListDto
     * @throws Exception
     */
    public void update(Zh03InsuranceListDto zh03InsuranceListDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLZh03InsuranceListAction blZh03InsuranceListAction = new BLZh03InsuranceListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //更新记录
            blZh03InsuranceListAction.update(dbManager,zh03InsuranceListDto);
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
     * @return zh03InsuranceListDto zh03InsuranceListDto
     * @throws Exception
     */
    public Zh03InsuranceListDto findByPrimaryKey(String inusreListCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLZh03InsuranceListAction blZh03InsuranceListAction = new BLZh03InsuranceListAction();
        //声明DTO
        Zh03InsuranceListDto zh03InsuranceListDto = null;
        try{
            dbManager.open("NXDADataSource");
            //查询数据,赋值给DTO
            zh03InsuranceListDto = blZh03InsuranceListAction.findByPrimaryKey(dbManager,inusreListCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return zh03InsuranceListDto;
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
        BLZh03InsuranceListAction blZh03InsuranceListAction = new BLZh03InsuranceListAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blZh03InsuranceListAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含zh03InsuranceListDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLZh03InsuranceListAction blZh03InsuranceListAction = new BLZh03InsuranceListAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blZh03InsuranceListAction.findByConditions(dbManager,conditions);
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
        BLZh03InsuranceListAction blZh03InsuranceListAction = new BLZh03InsuranceListAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blZh03InsuranceListAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
