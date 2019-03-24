package com.gyic.claim.bl.action.domain;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorsettlelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxsettlelist;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingsettlelist;
import com.gyic.claim.resource.dtofactory.domain.DBTemblorsettlelist;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是TEMBLORSETTLELIST的业务逻辑对象类<br>
 */
public class BLTemblorsettlelistActionBase{
    private static Logger logger = Logger.getLogger(BLTemblorsettlelistActionBase.class);

    /**
     * 构造函数
     */
    public BLTemblorsettlelistActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param temblorsettlelistDto temblorsettlelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,TemblorsettlelistDto temblorsettlelistDto)
            throws Exception{
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
        //插入记录
        dbTemblorsettlelist.insert(temblorsettlelistDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param settlelistcode SETTLELISTCODE
     * @param indexofsettle INDEXOFSETTLE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String settlelistcode,int indexofsettle,String kindcode,String itemcode,String nodetype)
            throws Exception{
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
        //删除记录
        dbTemblorsettlelist.delete(settlelistcode, indexofsettle, kindcode, itemcode, nodetype);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
        //按条件删除记录
        dbTemblorsettlelist.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param temblorsettlelistDto temblorsettlelistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,TemblorsettlelistDto temblorsettlelistDto)
            throws Exception{
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
        //更新记录
        dbTemblorsettlelist.update(temblorsettlelistDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param settlelistcode SETTLELISTCODE
     * @param indexofsettle INDEXOFSETTLE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @return temblorsettlelistDto temblorsettlelistDto
     * @throws Exception
     */
    public TemblorsettlelistDto findByPrimaryKey(DBManager dbManager,String settlelistcode,int indexofsettle,String kindcode,String itemcode,String nodetype)
            throws Exception{
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
        //声明DTO
        TemblorsettlelistDto temblorsettlelistDto = null;
        //查询数据,赋值给DTO
        temblorsettlelistDto = dbTemblorsettlelist.findByPrimaryKey(settlelistcode, indexofsettle, kindcode, itemcode, nodetype);
        return temblorsettlelistDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorsettlelist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbTemblorsettlelist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含temblorsettlelistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbTemblorsettlelist.findByConditions(conditions);
        return collection;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorsettlelist.getCount(conditions);
        return count;
    }
    
    public void evaluate(DBManager dbManager, String settleListCode, int indexOfSettle, String whereCondition) throws Exception{
    	DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
        //DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);

        if(whereCondition.trim().length()==0){
        	whereCondition = "1=1";
        }
        dbTemblorsettlelist.evaluate(settleListCode, indexOfSettle, whereCondition);
    }
    
    /**
     * 查询不同损失率的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getDistinctLossRateCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorsettlelist.getDistinctLossRateCount(conditions);
        return count;
    }
    /**
     * 统计户次
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 统计户次
     * @throws Exception
     */
    public double getDamageInsured(DBManager dbManager,String conditions) 
        throws Exception{
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double count = dbTemblorsettlelist.getDamageInsured(conditions);
        return count;
    }
        /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @param fieldName 字段名
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public double getSum(DBManager dbManager,String conditions,String fieldName) 
        throws Exception{
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbTemblorsettlelist.getSum(conditions,fieldName);
        return sum;
    }
    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @param fieldName 字段名
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getMaxIndex(DBManager dbManager,String conditions)
        throws Exception{
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int max = dbTemblorsettlelist.getMaxIndex(conditions);
        return max;
    }
    
    
    /**
     * 汇总某一农户的总赔款额
     * @param settleListCode 理赔清单号
     * @param fIdCard 农户身份证号
     * @return  result 结果
     * @throws Exception
     */
    public double getSettleSumByFcodeNodeType(DBManager dbManager, String settleListCode, String fIdCard, String address, String nodeType)
    throws Exception{
    	
    	double settleSum = 0.0;
		try {

			DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
			settleSum = dbTemblorsettlelist.getSettleSumByFcodeNodeType(settleListCode, fIdCard,address,nodeType);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return settleSum;
    }
    


    
    public Collection getGroupedSumDataByFcode(DBManager dbManager, String sqlCondition)
    throws Exception{
    	
    	Collection resultList = new ArrayList();
		try {
			DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
			//DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
			resultList = dbTemblorsettlelist.getGroupedSumDataByFcode(sqlCondition);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return resultList;
    }
    
    public void dumpByNodeType(DBManager dbManager, String settleListCode, String nodeTypeFrom, String nodeTypeTo)
    throws Exception{
        try {
        	DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
			//DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
        	dbTemblorsettlelist.dumpByNodeType(settleListCode, nodeTypeFrom, nodeTypeTo);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

}
