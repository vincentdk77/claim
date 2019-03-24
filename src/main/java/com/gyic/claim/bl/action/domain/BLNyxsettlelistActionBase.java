package com.gyic.claim.bl.action.domain;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxsettlelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxsettlelist;
import com.gyic.claim.resource.dtofactory.domain.DBPlanting31SettleList;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是NYXSETTLELIST的业务逻辑对象类<br>
 */
public class BLNyxsettlelistActionBase{
    private static Logger logger = Logger.getLogger(BLNyxsettlelistActionBase.class);

    /**
     * 构造函数
     */
    public BLNyxsettlelistActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param nyxsettlelistDto nyxsettlelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,NyxsettlelistDto nyxsettlelistDto)
            throws Exception{
        DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
        //插入记录
        dbNyxsettlelist.insert(nyxsettlelistDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param settlelistcode SETTLELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String settlelistcode,String fcode,String kindcode,String itemcode,String nodetype,int indexofsettle)
            throws Exception{
        DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
        //删除记录
        dbNyxsettlelist.delete(settlelistcode, fcode, kindcode, itemcode, nodetype, indexofsettle);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
        //按条件删除记录
        dbNyxsettlelist.deleteByConditions(conditions);
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
    	DBNyxsettlelist dbPlanting31SettleList = new DBNyxsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbPlanting31SettleList.getSum(conditions,fieldName);
        return sum;
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param nyxsettlelistDto nyxsettlelistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,NyxsettlelistDto nyxsettlelistDto)
            throws Exception{
        DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
        //更新记录
        dbNyxsettlelist.update(nyxsettlelistDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param settlelistcode SETTLELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @return nyxsettlelistDto nyxsettlelistDto
     * @throws Exception
     */
    public NyxsettlelistDto findByPrimaryKey(DBManager dbManager,String settlelistcode,String fcode,String kindcode,String itemcode,String nodetype,int indexofsettle)
            throws Exception{
        DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
        //声明DTO
        NyxsettlelistDto nyxsettlelistDto = null;
        //查询数据,赋值给DTO
        nyxsettlelistDto = dbNyxsettlelist.findByPrimaryKey(settlelistcode, fcode, kindcode, itemcode, nodetype, indexofsettle);
        return nyxsettlelistDto;
    }
    
    public Collection getGroupedSumData(DBManager dbManager, String sqlCondition,  boolean groupByKindCode, boolean groupByItemCode, boolean groupByLossRate, boolean groupByClaimRate)
    throws Exception{
    	
    	Collection resultList = new ArrayList();
		try {
			DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
			//DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
			resultList = dbNyxsettlelist.getGroupedSumData(sqlCondition, groupByKindCode, groupByItemCode, groupByLossRate, groupByClaimRate);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return resultList;
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
        DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxsettlelist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbNyxsettlelist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含nyxsettlelistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbNyxsettlelist.findByConditions(conditions);
        return collection;
    }
    
    public void dumpByNodeType(DBManager dbManager, String settleListCode, String nodeTypeFrom, String nodeTypeTo)
    throws Exception{
        try {
        	DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
			//DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
        	dbNyxsettlelist.dumpByNodeType(settleListCode, nodeTypeFrom, nodeTypeTo);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
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
        DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxsettlelist.getCount(conditions);
        return count;
    }
    
    /**
     * 汇总某一农户的总赔款额
     * @param settleListCode 理赔清单号
     * @param fIdCard 农户身份证号
     * @return  result 结果
     * @throws Exception
     */
    public double getSettleSumByFcodeNodeType(DBManager dbManager, String settleListCode, String fIdCard, String nodeType)
    throws Exception{
    	
    	double settleSum = 0.0;
		try {

			DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
			settleSum = dbNyxsettlelist.getSettleSumByFcodeNodeType(settleListCode, fIdCard,nodeType);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return settleSum;
    }
    
    public double getDamageInsured(DBManager dbManager,String conditions) 
    throws Exception{
    	DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);	
    //DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    double count = dbNyxsettlelist.getDamageInsured(conditions);
    return count;
}
    
    /**
     * 将数据从临时表 PLANTING31SETTLELISTTEMP 存入正式表 PLANTING31SETTLELIST
     * @param settleListCode 正式表中的理赔清单号
     * @param indexOfSettle 正式表中的序号
     * @param whereCondition 临时表查询条件，决定将那些数据插入正式表。
     * @throws Exception
     */
    public void evaluate(DBManager dbManager, String settleListCode, int indexOfSettle, String whereCondition) throws Exception{
    	DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
        //DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);

        if(whereCondition.trim().length()==0){
        	whereCondition = "1=1";
        }
        dbNyxsettlelist.evaluate(settleListCode, indexOfSettle, whereCondition);
    }
    
    public int getMaxIndex(DBManager dbManager,String conditions)
    throws Exception{
    DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
    //DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    int max = dbNyxsettlelist.getMaxIndex(conditions);
    return max;
}
    
    public Collection getGroupedSumDataByFcode(DBManager dbManager, String sqlCondition)
    throws Exception{
    	
    	Collection resultList = new ArrayList();
		try {
			DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
			//DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
			resultList = dbNyxsettlelist.getGroupedSumDataByFcode(sqlCondition);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return resultList;
    }
}
