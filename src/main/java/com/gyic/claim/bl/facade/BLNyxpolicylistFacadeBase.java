package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxpolicylistDto;
import com.gyic.claim.bl.action.domain.BLNyxpolicylistAction;
import com.gyic.claim.bl.action.domain.BLPlanting31PolicyListAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是NYXPOLICYLIST的业务逻辑对象Facade基类<br>
 */
public class BLNyxpolicylistFacadeBase{
    private static Logger logger = Logger.getLogger(BLNyxpolicylistFacadeBase.class);

    /**
     * 构造函数
     */
    public BLNyxpolicylistFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param nyxpolicylistDto nyxpolicylistDto
     * @throws Exception
     */
    public void insert(NyxpolicylistDto nyxpolicylistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxpolicylistAction blNyxpolicylistAction = new BLNyxpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //插入记录
            blNyxpolicylistAction.insert(dbManager,nyxpolicylistDto);
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
     * @param businessno BUSINESSNO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @throws Exception
     */
    public void delete(String inusrelistcode,String businessno,String kindcode,String itemcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxpolicylistAction blNyxpolicylistAction = new BLNyxpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //删除记录
            blNyxpolicylistAction.delete(dbManager,inusrelistcode, businessno, kindcode, itemcode);
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
        BLNyxpolicylistAction blNyxpolicylistAction = new BLNyxpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blNyxpolicylistAction.deleteByConditions(dbManager,conditions);
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
     * @param nyxpolicylistDto nyxpolicylistDto
     * @throws Exception
     */
    public void update(NyxpolicylistDto nyxpolicylistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxpolicylistAction blNyxpolicylistAction = new BLNyxpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //更新记录
            blNyxpolicylistAction.update(dbManager,nyxpolicylistDto);
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
     * @param businessno BUSINESSNO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @return nyxpolicylistDto nyxpolicylistDto
     * @throws Exception
     */
    public NyxpolicylistDto findByPrimaryKey(String inusrelistcode,String businessno,String kindcode,String itemcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxpolicylistAction blNyxpolicylistAction = new BLNyxpolicylistAction();
        //声明DTO
        NyxpolicylistDto nyxpolicylistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //查询数据,赋值给DTO
            nyxpolicylistDto = blNyxpolicylistAction.findByPrimaryKey(dbManager,inusrelistcode, businessno, kindcode, itemcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return nyxpolicylistDto;
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
        BLNyxpolicylistAction blNyxpolicylistAction = new BLNyxpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blNyxpolicylistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含nyxpolicylistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLNyxpolicylistAction blNyxpolicylistAction = new BLNyxpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blNyxpolicylistAction.findByConditions(dbManager,conditions);
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
        BLNyxpolicylistAction blNyxpolicylistAction = new BLNyxpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blNyxpolicylistAction.getCount(dbManager,conditions);
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
        BLNyxpolicylistAction blNyxpolicylistAction = new BLNyxpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blNyxpolicylistAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
}
