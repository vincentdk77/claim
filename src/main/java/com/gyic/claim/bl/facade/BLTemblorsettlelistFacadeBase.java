package com.gyic.claim.bl.facade;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorsettlelistDto;
import com.gyic.claim.bl.action.domain.BLNyxsettlelistAction;
import com.gyic.claim.bl.action.domain.BLPlantingsettlelistAction;
import com.gyic.claim.bl.action.domain.BLTemblorsettlelistAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是TEMBLORSETTLELIST的业务逻辑对象Facade基类<br>
 */
public class BLTemblorsettlelistFacadeBase{
    private static Logger logger = Logger.getLogger(BLTemblorsettlelistFacadeBase.class);

    /**
     * 构造函数
     */
    public BLTemblorsettlelistFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param temblorsettlelistDto temblorsettlelistDto
     * @throws Exception
     */
    public void insert(TemblorsettlelistDto temblorsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //插入记录
            blTemblorsettlelistAction.insert(dbManager,temblorsettlelistDto);
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
     * @param indexofsettle INDEXOFSETTLE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @throws Exception
     */
    public void delete(String settlelistcode,int indexofsettle,String kindcode,String itemcode,String nodetype)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //删除记录
            blTemblorsettlelistAction.delete(dbManager,settlelistcode, indexofsettle, kindcode, itemcode, nodetype);
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
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blTemblorsettlelistAction.deleteByConditions(dbManager,conditions);
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
     * @param temblorsettlelistDto temblorsettlelistDto
     * @throws Exception
     */
    public void update(TemblorsettlelistDto temblorsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //更新记录
            blTemblorsettlelistAction.update(dbManager,temblorsettlelistDto);
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
     * @param indexofsettle INDEXOFSETTLE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @return temblorsettlelistDto temblorsettlelistDto
     * @throws Exception
     */
    public TemblorsettlelistDto findByPrimaryKey(String settlelistcode,int indexofsettle,String kindcode,String itemcode,String nodetype)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        //声明DTO
        TemblorsettlelistDto temblorsettlelistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //查询数据,赋值给DTO
            temblorsettlelistDto = blTemblorsettlelistAction.findByPrimaryKey(dbManager,settlelistcode, indexofsettle, kindcode, itemcode, nodetype);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return temblorsettlelistDto;
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
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blTemblorsettlelistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含temblorsettlelistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blTemblorsettlelistAction.findByConditions(dbManager,conditions);
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
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blTemblorsettlelistAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
    /**
     * 查询不同损失率的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getDistinctLossRateCount(String conditions) 
        throws Exception{
        int rowCount=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blTemblorsettlelistAction.getDistinctLossRateCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    /**
     * 统计户次
     * @param conditions conditions
     * @return 统计户次
     * @throws Exception
     */
    public double getDamageInsured(String conditions) 
        throws Exception{
    	double rowCount=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blTemblorsettlelistAction.getDamageInsured(dbManager,conditions);
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
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blTemblorsettlelistAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
    
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @param fieldName 字段名
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getMaxIndex(String conditions)
        throws Exception{
        int max=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            max = blTemblorsettlelistAction.getMaxIndex(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return max;
    }
    
    /**
     * 汇总某一农户的总赔款额
     * @param settleListCode 理赔清单号
     * @param fIdCard 农户身份证号
     * @return  result 结果
     * @throws Exception
     */
    public double getSettleSumByFcodeNodeType(String settleListCode, String fIdCard, String address, String nodeType)
    throws Exception{
    	double settleSum = 0.0;
        DBManager dbManager = new DBManager();
        
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
    	try{
            dbManager.open("NXDADataSource");
            settleSum = blTemblorsettlelistAction.getSettleSumByFcodeNodeType(dbManager, settleListCode, fIdCard,address,nodeType);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    	return settleSum;
    }
    
    public void dumpByNodeType(String settleListCode, String nodeTypeFrom, String nodeTypeTo)
    throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        //BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
        try{
            dbManager.open("NXDADataSource");
            blTemblorsettlelistAction.dumpByNodeType(dbManager, settleListCode, nodeTypeFrom, nodeTypeTo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    


    
    public Collection getGroupedSumDataByFcode(String sqlCondition)
    throws Exception{
    	
    	Collection resultList = new ArrayList();
        DBManager dbManager = new DBManager();
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        //BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
    	try{
            dbManager.open("NXDADataSource");
            resultList = blTemblorsettlelistAction.getGroupedSumDataByFcode(dbManager, sqlCondition);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    	return resultList;
    }
}
