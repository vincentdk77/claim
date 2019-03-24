package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxsettlelisttempDto;
import com.gyic.claim.bl.action.domain.BLNyxsettlelisttempAction;
import com.gyic.claim.bl.action.domain.BLPlanting31SettleListTempAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是NYXSETTLELISTTEMP的业务逻辑对象Facade基类<br>
 */
public class BLNyxsettlelisttempFacadeBase{
    private static Logger logger = Logger.getLogger(BLNyxsettlelisttempFacadeBase.class);

    /**
     * 构造函数
     */
    public BLNyxsettlelisttempFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param nyxsettlelisttempDto nyxsettlelisttempDto
     * @throws Exception
     */
    public void insert(NyxsettlelisttempDto nyxsettlelisttempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxsettlelisttempAction blNyxsettlelisttempAction = new BLNyxsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //插入记录
            blNyxsettlelisttempAction.insert(dbManager,nyxsettlelisttempDto);
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
        BLNyxsettlelisttempAction blNyxsettlelisttempAction = new BLNyxsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //删除记录
            blNyxsettlelisttempAction.delete(dbManager,registcode, stringtimestamp, indexofsettle);
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
        BLNyxsettlelisttempAction blNyxsettlelisttempAction = new BLNyxsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blNyxsettlelisttempAction.deleteByConditions(dbManager,conditions);
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
     * @param nyxsettlelisttempDto nyxsettlelisttempDto
     * @throws Exception
     */
    public void update(NyxsettlelisttempDto nyxsettlelisttempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxsettlelisttempAction blNyxsettlelisttempAction = new BLNyxsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //更新记录
            blNyxsettlelisttempAction.update(dbManager,nyxsettlelisttempDto);
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
     * @return nyxsettlelisttempDto nyxsettlelisttempDto
     * @throws Exception
     */
    public NyxsettlelisttempDto findByPrimaryKey(String registcode,String stringtimestamp,int indexofsettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxsettlelisttempAction blNyxsettlelisttempAction = new BLNyxsettlelisttempAction();
        //声明DTO
        NyxsettlelisttempDto nyxsettlelisttempDto = null;
        try{
            dbManager.open("NXDADataSource");
            //查询数据,赋值给DTO
            nyxsettlelisttempDto = blNyxsettlelisttempAction.findByPrimaryKey(dbManager,registcode, stringtimestamp, indexofsettle);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return nyxsettlelisttempDto;
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
        BLNyxsettlelisttempAction blNyxsettlelisttempAction = new BLNyxsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blNyxsettlelisttempAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含nyxsettlelisttempDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLNyxsettlelisttempAction blNyxsettlelisttempAction = new BLNyxsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blNyxsettlelisttempAction.findByConditions(dbManager,conditions);
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
        BLNyxsettlelisttempAction blNyxsettlelisttempAction = new BLNyxsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blNyxsettlelisttempAction.getCount(dbManager,conditions);
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
        BLNyxsettlelisttempAction blNyxsettlelisttempAction = new BLNyxsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blNyxsettlelisttempAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
}
