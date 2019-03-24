package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31SettleListDto;
import com.gyic.claim.resource.dtofactory.domain.DBPlanting31SettleList;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingsettlelist;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是Planting31SettleList的业务逻辑对象类<br>
 */
public class BLPlanting31SettleListActionBase{
    private static Logger logger = Logger.getLogger(BLPlanting31SettleListActionBase.class);

    /**
     * 构造函数
     */
    public BLPlanting31SettleListActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param planting31SettleListDto planting31SettleListDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,Planting31SettleListDto planting31SettleListDto)
            throws Exception{
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
        //插入记录
        dbPlanting31SettleList.insert(planting31SettleListDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param settleListCode SettleListCode
     * @param fcode FCode
     * @param kindCode KindCode
     * @param itemCode ItemCode
     * @param nodeType NodeType
     * @param indexOfSettle IndexOfSettle
     * @throws Exception
     */
    public void delete(DBManager dbManager,String settleListCode,String fcode,String kindCode,String itemCode,String nodeType,int indexOfSettle)
            throws Exception{
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
        //删除记录
        dbPlanting31SettleList.delete(settleListCode, fcode, kindCode, itemCode, nodeType, indexOfSettle);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
        //按条件删除记录
        dbPlanting31SettleList.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param planting31SettleListDto planting31SettleListDto
     * @throws Exception
     */
    public void update(DBManager dbManager,Planting31SettleListDto planting31SettleListDto)
            throws Exception{
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
        //更新记录
        dbPlanting31SettleList.update(planting31SettleListDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param settleListCode SettleListCode
     * @param fcode FCode
     * @param kindCode KindCode
     * @param itemCode ItemCode
     * @param nodeType NodeType
     * @param indexOfSettle IndexOfSettle
     * @return planting31SettleListDto planting31SettleListDto
     * @throws Exception
     */
    public Planting31SettleListDto findByPrimaryKey(DBManager dbManager,String settleListCode,String fcode,String kindCode,String itemCode,String nodeType,int indexOfSettle)
            throws Exception{
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
        //声明DTO
        Planting31SettleListDto planting31SettleListDto = null;
        //查询数据,赋值给DTO
        planting31SettleListDto = dbPlanting31SettleList.findByPrimaryKey(settleListCode, fcode, kindCode, itemCode, nodeType, indexOfSettle);
        return planting31SettleListDto;
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
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlanting31SettleList.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPlanting31SettleList.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含planting31SettleListDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPlanting31SettleList.findByConditions(conditions);
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
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlanting31SettleList.getCount(conditions);
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
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbPlanting31SettleList.getSum(conditions,fieldName);
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
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int max = dbPlanting31SettleList.getMaxIndex(conditions);
        return max;
    }
    
    /**
     * 将数据从临时表 PLANTING31SETTLELISTTEMP 存入正式表 PLANTING31SETTLELIST
     * @param settleListCode 正式表中的理赔清单号
     * @param indexOfSettle 正式表中的序号
     * @param whereCondition 临时表查询条件，决定将那些数据插入正式表。
     * @throws Exception
     */
    public void evaluate(DBManager dbManager, String settleListCode, int indexOfSettle, String whereCondition) throws Exception{
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);

        if(whereCondition.trim().length()==0){
        	whereCondition = "1=1";
        }
        dbPlanting31SettleList.evaluate(settleListCode, indexOfSettle, whereCondition);
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
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double count = dbPlanting31SettleList.getDamageInsured(conditions);
        return count;
    }
    /**
     * 转储理赔清单数据
     * @param dbManager DB管理器
     * @param settleListCode 理赔清单号
     * @param nodeTypeFrom 清单来源节点名称
     * @param nodeTypeTo 清单目的节点名称
     * @return  
     * @throws Exception
     */
    public void dumpByNodeType(DBManager dbManager, String settleListCode, String nodeTypeFrom, String nodeTypeTo)
    throws Exception{
        try {
			DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
			dbPlanting31SettleList.dumpByNodeType(settleListCode, nodeTypeFrom, nodeTypeTo);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    /**
     * 分险别，标的，损失率汇总理赔清单
     * @param dbManager DB管理器
     * @param sqlCondition 查询条件
     * @return  resultList 结果列表
     * @throws Exception
     */
    public Collection getGroupedSumData(DBManager dbManager, String sqlCondition,  boolean groupByKindCode, boolean groupByItemCode, boolean groupByLossRate, boolean groupByClaimRate)
    throws Exception{
    	
    	Collection resultList = new ArrayList();
		try {

			DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
			resultList = dbPlanting31SettleList.getGroupedSumData(sqlCondition, groupByKindCode, groupByItemCode, groupByLossRate, groupByClaimRate);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
    public Collection getGroupedSumDataByFcode(DBManager dbManager, String sqlCondition)
    throws Exception{
    	
    	Collection resultList = new ArrayList();
		try {

			DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
			resultList = dbPlanting31SettleList.getGroupedSumDataByFcode(sqlCondition);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
    public double getSettleSumByFcodeNodeType(DBManager dbManager, String settleListCode, String fIdCard, String nodeType)
    throws Exception{
    	
    	double settleSum = 0.0;
		try {

			DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
			settleSum = dbPlanting31SettleList.getSettleSumByFcodeNodeType(settleListCode, fIdCard,nodeType);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return settleSum;
    }
}

