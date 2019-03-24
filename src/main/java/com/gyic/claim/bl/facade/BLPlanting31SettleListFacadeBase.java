package com.gyic.claim.bl.facade;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31SettleListDto;
import com.gyic.claim.resource.dtofactory.domain.DBPlanting31SettleList;
import com.gyic.claim.bl.action.domain.BLPlanting31SettleListAction;
import com.gyic.claim.bl.action.domain.BLPlantingsettlelistAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是Planting31SettleList的业务逻辑对象Facade基类<br>
 */
public class BLPlanting31SettleListFacadeBase{
    private static Logger logger = Logger.getLogger(BLPlanting31SettleListFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPlanting31SettleListFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param planting31SettleListDto planting31SettleListDto
     * @throws Exception
     */
    public void insert(Planting31SettleListDto planting31SettleListDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //插入记录
            blPlanting31SettleListAction.insert(dbManager,planting31SettleListDto);
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
     * @param settleListCode SettleListCode
     * @param fcode FCode
     * @param kindCode KindCode
     * @param itemCode ItemCode
     * @param nodeType NodeType
     * @param indexOfSettle IndexOfSettle
     * @throws Exception
     */
    public void delete(String settleListCode,String fcode,String kindCode,String itemCode,String nodeType,int indexOfSettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //删除记录
            blPlanting31SettleListAction.delete(dbManager,settleListCode, fcode, kindCode, itemCode, nodeType, indexOfSettle);
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
        BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blPlanting31SettleListAction.deleteByConditions(dbManager,conditions);
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
     * @param planting31SettleListDto planting31SettleListDto
     * @throws Exception
     */
    public void update(Planting31SettleListDto planting31SettleListDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //更新记录
            blPlanting31SettleListAction.update(dbManager,planting31SettleListDto);
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
     * @param settleListCode SettleListCode
     * @param fcode FCode
     * @param kindCode KindCode
     * @param itemCode ItemCode
     * @param nodeType NodeType
     * @param indexOfSettle IndexOfSettle
     * @return planting31SettleListDto planting31SettleListDto
     * @throws Exception
     */
    public Planting31SettleListDto findByPrimaryKey(String settleListCode,String fcode,String kindCode,String itemCode,String nodeType,int indexOfSettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
        //声明DTO
        Planting31SettleListDto planting31SettleListDto = null;
        try{
            dbManager.open("NXDADataSource");
            //查询数据,赋值给DTO
            planting31SettleListDto = blPlanting31SettleListAction.findByPrimaryKey(dbManager,settleListCode, fcode, kindCode, itemCode, nodeType, indexOfSettle);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return planting31SettleListDto;
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
        BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blPlanting31SettleListAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含planting31SettleListDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blPlanting31SettleListAction.findByConditions(dbManager,conditions);
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
        BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blPlanting31SettleListAction.getCount(dbManager,conditions);
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
        BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blPlanting31SettleListAction.getSum(dbManager,conditions,fieldName);
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
        BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
        try{
            dbManager.open("NXDADataSource");
            max = blPlanting31SettleListAction.getMaxIndex(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return max;
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
        BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blPlanting31SettleListAction.getDamageInsured(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    /**
     * 转储理赔清单数据
     * @param settleListCode 理赔清单号
     * @param nodeTypeFrom 清单来源节点名称
     * @param nodeTypeTo 清单目的节点名称
     * @return  
     * @throws Exception
     */
    public void dumpByNodeType(String settleListCode, String nodeTypeFrom, String nodeTypeTo)
    throws Exception{
        DBManager dbManager = new DBManager();
        BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
        try{
            dbManager.open("NXDADataSource");
            blPlanting31SettleListAction.dumpByNodeType(dbManager, settleListCode, nodeTypeFrom, nodeTypeTo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    /**
     * 分险别，标的，损失率汇总理赔清单
     * @param dbManager DB管理器
     * @param sqlCondition 查询条件
     * @return  resultList 结果列表
     * @throws Exception
     */
    public Collection getGroupedSumData(String sqlCondition, boolean groupByKindCode, boolean groupByItemCode, boolean groupByLossRate, boolean groupByClaimRate)
    throws Exception{
    	
    	Collection resultList = new ArrayList();
        DBManager dbManager = new DBManager();
        BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
    	try{
            dbManager.open("NXDADataSource");
            resultList = blPlanting31SettleListAction.getGroupedSumData(dbManager, sqlCondition, groupByKindCode, groupByItemCode, groupByLossRate, groupByClaimRate);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    	return resultList;
    }
    /**
     * 分险别，标的，损失率，农户代码，按照条件汇总理赔清单
     * @param dbManager DB管理器
     * @param sqlCondition 查询条件
     * @return  resultList 结果列表
     * @throws Exception
     */
    public Collection getGroupedSumDataByFcode(String sqlCondition)
    throws Exception{
    	
    	Collection resultList = new ArrayList();
        DBManager dbManager = new DBManager();
        BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
    	try{
            dbManager.open("NXDADataSource");
            resultList = blPlanting31SettleListAction.getGroupedSumDataByFcode(dbManager, sqlCondition);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    	return resultList;
    }
    /**
     * 汇总某一农户的总赔款额
     * @param settleListCode 理赔清单号
     * @param fIdCard 农户身份证号
     * @return  result 结果
     * @throws Exception
     */
    public double getSettleSumByFcodeNodeType(String settleListCode, String fIdCard, String nodeType)
    throws Exception{
    	double settleSum = 0.0;
        DBManager dbManager = new DBManager();
        BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
    	try{
            dbManager.open("NXDADataSource");
            settleSum = blPlanting31SettleListAction.getSettleSumByFcodeNodeType(dbManager, settleListCode, fIdCard,nodeType);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    	return settleSum;
    }
}
