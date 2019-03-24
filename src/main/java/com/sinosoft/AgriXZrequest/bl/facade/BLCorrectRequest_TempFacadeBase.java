package com.sinosoft.AgriXZrequest.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.AgriXZrequest.dto.domain.CorrectRequest_TempDto;
import com.sinosoft.AgriXZrequest.bl.action.domain.BLCorrectRequest_TempAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CorrectRequest_Temp的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCorrectRequest_TempFacadeBase{
    private static Logger logger = Logger.getLogger(BLCorrectRequest_TempFacadeBase.class);

    /**
     * 构造函数
     */
    public BLCorrectRequest_TempFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param correctRequest_TempDto correctRequest_TempDto
     * @throws Exception
     */
    public void insert(CorrectRequest_TempDto correctRequest_TempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCorrectRequest_TempAction blCorrectRequest_TempAction = new BLCorrectRequest_TempAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //插入记录
            blCorrectRequest_TempAction.insert(dbManager,correctRequest_TempDto);
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
     * @param batchNo batchNo
     * @throws Exception
     */
    public void delete(String batchNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCorrectRequest_TempAction blCorrectRequest_TempAction = new BLCorrectRequest_TempAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //删除记录
            blCorrectRequest_TempAction.delete(dbManager,batchNo);
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
        BLCorrectRequest_TempAction blCorrectRequest_TempAction = new BLCorrectRequest_TempAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blCorrectRequest_TempAction.deleteByConditions(dbManager,conditions);
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
     * @param correctRequest_TempDto correctRequest_TempDto
     * @throws Exception
     */
    public void update(CorrectRequest_TempDto correctRequest_TempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCorrectRequest_TempAction blCorrectRequest_TempAction = new BLCorrectRequest_TempAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //更新记录
            blCorrectRequest_TempAction.update(dbManager,correctRequest_TempDto);
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
     * @param batchNo batchNo
     * @return correctRequest_TempDto correctRequest_TempDto
     * @throws Exception
     */
    public CorrectRequest_TempDto findByPrimaryKey(String batchNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCorrectRequest_TempAction blCorrectRequest_TempAction = new BLCorrectRequest_TempAction();
        //声明DTO
        CorrectRequest_TempDto correctRequest_TempDto = null;
        try{
            dbManager.open("ddccDataSource");
            //查询数据,赋值给DTO
            correctRequest_TempDto = blCorrectRequest_TempAction.findByPrimaryKey(dbManager,batchNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return correctRequest_TempDto;
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
        BLCorrectRequest_TempAction blCorrectRequest_TempAction = new BLCorrectRequest_TempAction();
        try{
            dbManager.open("ddccDataSource");
            pageRecord = blCorrectRequest_TempAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含correctRequest_TempDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCorrectRequest_TempAction blCorrectRequest_TempAction = new BLCorrectRequest_TempAction();
        try{
            dbManager.open("ddccDataSource");
            collection = blCorrectRequest_TempAction.findByConditions(dbManager,conditions);
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
        BLCorrectRequest_TempAction blCorrectRequest_TempAction = new BLCorrectRequest_TempAction();
        try{
            dbManager.open("ddccDataSource");
            rowCount = blCorrectRequest_TempAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
