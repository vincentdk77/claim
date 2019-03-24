package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorsettlelisttempDto;
import com.gyic.claim.bl.action.domain.BLNyxsettlelisttempAction;
import com.gyic.claim.bl.action.domain.BLTemblorsettlelisttempAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是TEMBLORSETTLELISTTEMP的业务逻辑对象Facade基类<br>
 */
public class BLTemblorsettlelisttempFacadeBase{
    private static Logger logger = Logger.getLogger(BLTemblorsettlelisttempFacadeBase.class);

    /**
     * 构造函数
     */
    public BLTemblorsettlelisttempFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param temblorsettlelisttempDto temblorsettlelisttempDto
     * @throws Exception
     */
    public void insert(TemblorsettlelisttempDto temblorsettlelisttempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorsettlelisttempAction blTemblorsettlelisttempAction = new BLTemblorsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //插入记录
            blTemblorsettlelisttempAction.insert(dbManager,temblorsettlelisttempDto);
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
     * @param registcode REGISTCODE
     * @param stringtimestamp STRINGTIMESTAMP
     * @param indexofsettle INDEXOFSETTLE
     * @throws Exception
     */
    public void delete(String registcode,String stringtimestamp,int indexofsettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorsettlelisttempAction blTemblorsettlelisttempAction = new BLTemblorsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //删除记录
            blTemblorsettlelisttempAction.delete(dbManager,registcode, stringtimestamp, indexofsettle);
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
        BLTemblorsettlelisttempAction blTemblorsettlelisttempAction = new BLTemblorsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blTemblorsettlelisttempAction.deleteByConditions(dbManager,conditions);
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
     * @param temblorsettlelisttempDto temblorsettlelisttempDto
     * @throws Exception
     */
    public void update(TemblorsettlelisttempDto temblorsettlelisttempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorsettlelisttempAction blTemblorsettlelisttempAction = new BLTemblorsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //更新记录
            blTemblorsettlelisttempAction.update(dbManager,temblorsettlelisttempDto);
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
     * @param registcode REGISTCODE
     * @param stringtimestamp STRINGTIMESTAMP
     * @param indexofsettle INDEXOFSETTLE
     * @return temblorsettlelisttempDto temblorsettlelisttempDto
     * @throws Exception
     */
    public TemblorsettlelisttempDto findByPrimaryKey(String registcode,String stringtimestamp,int indexofsettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorsettlelisttempAction blTemblorsettlelisttempAction = new BLTemblorsettlelisttempAction();
        //声明DTO
        TemblorsettlelisttempDto temblorsettlelisttempDto = null;
        try{
            dbManager.open("NXDADataSource");
            //查询数据,赋值给DTO
            temblorsettlelisttempDto = blTemblorsettlelisttempAction.findByPrimaryKey(dbManager,registcode, stringtimestamp, indexofsettle);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return temblorsettlelisttempDto;
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
        BLTemblorsettlelisttempAction blTemblorsettlelisttempAction = new BLTemblorsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blTemblorsettlelisttempAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含temblorsettlelisttempDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLTemblorsettlelisttempAction blTemblorsettlelisttempAction = new BLTemblorsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blTemblorsettlelisttempAction.findByConditions(dbManager,conditions);
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
        BLTemblorsettlelisttempAction blTemblorsettlelisttempAction = new BLTemblorsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blTemblorsettlelisttempAction.getCount(dbManager,conditions);
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
        BLTemblorsettlelisttempAction blTemblorsettlelisttempAction = new BLTemblorsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blTemblorsettlelisttempAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
}
