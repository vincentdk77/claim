package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.gyic.claim.bl.action.domain.BLSettlemainlistAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是SETTLEMAINLIST的业务逻辑对象Facade基类<br>
 */
public class BLSettlemainlistFacadeForMedicalBase{
    private static Logger logger = Logger.getLogger(BLSettlemainlistFacadeBase.class);

    /**
     * 构造函数
     */
    public BLSettlemainlistFacadeForMedicalBase(){
    }

    /**
     * 插入一条数据
     * @param settlemainlistDto settlemainlistDto
     * @throws Exception
     */
    public void insert(SettlemainlistDto settlemainlistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSettlemainlistAction blSettlemainlistAction = new BLSettlemainlistAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //插入记录
            blSettlemainlistAction.insert(dbManager,settlemainlistDto);
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
     * @param settlelistcode SETTLELISTCODE
     * @throws Exception
     */
    public void delete(String settlelistcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSettlemainlistAction blSettlemainlistAction = new BLSettlemainlistAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //删除记录
            blSettlemainlistAction.delete(dbManager,settlelistcode);
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
        BLSettlemainlistAction blSettlemainlistAction = new BLSettlemainlistAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blSettlemainlistAction.deleteByConditions(dbManager,conditions);
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
     * @param settlemainlistDto settlemainlistDto
     * @throws Exception
     */
    public void update(SettlemainlistDto settlemainlistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSettlemainlistAction blSettlemainlistAction = new BLSettlemainlistAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //更新记录
            blSettlemainlistAction.update(dbManager,settlemainlistDto);
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
     * @param settlelistcode SETTLELISTCODE
     * @return settlemainlistDto settlemainlistDto
     * @throws Exception
     */
    public SettlemainlistDto findByPrimaryKey(String settlelistcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLSettlemainlistAction blSettlemainlistAction = new BLSettlemainlistAction();
        //声明DTO
        SettlemainlistDto settlemainlistDto = null;
        try{
            dbManager.open("JKXDataSource");
            //查询数据,赋值给DTO
            settlemainlistDto = blSettlemainlistAction.findByPrimaryKey(dbManager,settlelistcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return settlemainlistDto;
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
        BLSettlemainlistAction blSettlemainlistAction = new BLSettlemainlistAction();
        try{
            dbManager.open("JKXDataSource");
            pageRecord = blSettlemainlistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含settlemainlistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSettlemainlistAction blSettlemainlistAction = new BLSettlemainlistAction();
        try{
            dbManager.open("JKXDataSource");
            collection = blSettlemainlistAction.findByConditions(dbManager,conditions);
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
        BLSettlemainlistAction blSettlemainlistAction = new BLSettlemainlistAction();
        try{
            dbManager.open("JKXDataSource");
            rowCount = blSettlemainlistAction.getCount(dbManager,conditions);
        }catch(Exception exception){
        	exception.printStackTrace();
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
