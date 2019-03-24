package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalsettlelisttempDto;
import com.gyic.claim.bl.action.domain.BLMedicalsettlelisttempAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PLANTINGSETTLELISTTEMP的业务逻辑对象Facade基类<br>
 */
public class BLMedicalsettlelisttempFacadeBase{
    private static Logger logger = Logger.getLogger(BLMedicalsettlelisttempFacadeBase.class);

    /**
     * 构造函数
     */
    public BLMedicalsettlelisttempFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param medicalsettlelisttempDto medicalsettlelisttempDto
     * @throws Exception
     */
    public void insert(MedicalsettlelisttempDto medicalsettlelisttempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalsettlelisttempAction blMedicalsettlelisttempAction = new BLMedicalsettlelisttempAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //插入记录
            blMedicalsettlelisttempAction.insert(dbManager,medicalsettlelisttempDto);
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
     * @param indexofsettle INDEXOFSETTLE
     * @param stringtimestamp STRINGTIMESTAMP
     * @throws Exception
     */
    public void delete(String registcode,int indexofsettle,String stringtimestamp)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalsettlelisttempAction blMedicalsettlelisttempAction = new BLMedicalsettlelisttempAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //删除记录
            blMedicalsettlelisttempAction.delete(dbManager,registcode, indexofsettle, stringtimestamp);
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
        BLMedicalsettlelisttempAction blMedicalsettlelisttempAction = new BLMedicalsettlelisttempAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blMedicalsettlelisttempAction.deleteByConditions(dbManager,conditions);
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
     * @param medicalsettlelisttempDto medicalsettlelisttempDto
     * @throws Exception
     */
    public void update(MedicalsettlelisttempDto medicalsettlelisttempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalsettlelisttempAction blMedicalsettlelisttempAction = new BLMedicalsettlelisttempAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //更新记录
            blMedicalsettlelisttempAction.update(dbManager,medicalsettlelisttempDto);
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
     * @param indexofsettle INDEXOFSETTLE
     * @param stringtimestamp STRINGTIMESTAMP
     * @return medicalsettlelisttempDto medicalsettlelisttempDto
     * @throws Exception
     */
    public MedicalsettlelisttempDto findByPrimaryKey(String registcode,int indexofsettle,String stringtimestamp)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalsettlelisttempAction blMedicalsettlelisttempAction = new BLMedicalsettlelisttempAction();
        //声明DTO
        MedicalsettlelisttempDto medicalsettlelisttempDto = null;
        try{
            dbManager.open("JKXDataSource");
            //查询数据,赋值给DTO
            medicalsettlelisttempDto = blMedicalsettlelisttempAction.findByPrimaryKey(dbManager,registcode, indexofsettle, stringtimestamp);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return medicalsettlelisttempDto;
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
        BLMedicalsettlelisttempAction blMedicalsettlelisttempAction = new BLMedicalsettlelisttempAction();
        try{
            dbManager.open("JKXDataSource");
            pageRecord = blMedicalsettlelisttempAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含medicalsettlelisttempDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLMedicalsettlelisttempAction blMedicalsettlelisttempAction = new BLMedicalsettlelisttempAction();
        try{
            dbManager.open("JKXDataSource");
            collection = blMedicalsettlelisttempAction.findByConditions(dbManager,conditions);
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
        BLMedicalsettlelisttempAction blMedicalsettlelisttempAction = new BLMedicalsettlelisttempAction();
        try{
            dbManager.open("JKXDataSource");
            rowCount = blMedicalsettlelisttempAction.getCount(dbManager,conditions);
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
        BLMedicalsettlelisttempAction blMedicalsettlelisttempAction = new BLMedicalsettlelisttempAction();
        try{
            dbManager.open("JKXDataSource");
            sum = blMedicalsettlelisttempAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
}
