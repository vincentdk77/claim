package com.gyic.claim.bl.facade;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxsettlelistDto;
import com.gyic.claim.dto.domain.PlantingsettlelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxsettlelist;
import com.gyic.claim.bl.action.domain.BLNyxsettlelistAction;
import com.gyic.claim.bl.action.domain.BLPlanting31SettleListAction;
import com.gyic.claim.bl.action.domain.BLPlantingsettlelistAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是NYXSETTLELIST的业务逻辑对象Facade基类<br>
 */
public class BLNyxsettlelistFacadeBase{
    private static Logger logger = Logger.getLogger(BLNyxsettlelistFacadeBase.class);

    /**
     * 构造函数
     */
    public BLNyxsettlelistFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param nyxsettlelistDto nyxsettlelistDto
     * @throws Exception
     */
    public void insert(NyxsettlelistDto nyxsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //插入记录
            blNyxsettlelistAction.insert(dbManager,nyxsettlelistDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    public void insert(List nyxSettleListDtoList)
    throws Exception{
    DBManager dbManager = new DBManager();
    BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
    
    try{
        dbManager.open("NXDADataSource");
        dbManager.beginTransaction();
        if(null!=nyxSettleListDtoList){
        	for(int i=0;i<nyxSettleListDtoList.size();i++){
        		NyxsettlelistDto nyxsettlelistDto = (NyxsettlelistDto)nyxSettleListDtoList.get(i);
	            //插入记录
        		blNyxsettlelistAction.insert(dbManager,nyxsettlelistDto);
        	}
        }
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
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @throws Exception
     */
    public void delete(String settlelistcode,String fcode,String kindcode,String itemcode,String nodetype,int indexofsettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //删除记录
            blNyxsettlelistAction.delete(dbManager,settlelistcode, fcode, kindcode, itemcode, nodetype, indexofsettle);
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
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blNyxsettlelistAction.deleteByConditions(dbManager,conditions);
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
     * @param nyxsettlelistDto nyxsettlelistDto
     * @throws Exception
     */
    public void update(NyxsettlelistDto nyxsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //更新记录
            blNyxsettlelistAction.update(dbManager,nyxsettlelistDto);
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
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @return nyxsettlelistDto nyxsettlelistDto
     * @throws Exception
     */
    public NyxsettlelistDto findByPrimaryKey(String settlelistcode,String fcode,String kindcode,String itemcode,String nodetype,int indexofsettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        //声明DTO
        NyxsettlelistDto nyxsettlelistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //查询数据,赋值给DTO
            nyxsettlelistDto = blNyxsettlelistAction.findByPrimaryKey(dbManager,settlelistcode, fcode, kindcode, itemcode, nodetype, indexofsettle);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return nyxsettlelistDto;
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
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blNyxsettlelistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含nyxsettlelistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blNyxsettlelistAction.findByConditions(dbManager,conditions);
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
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blNyxsettlelistAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
    
    public void dumpByNodeType(String settleListCode, String nodeTypeFrom, String nodeTypeTo)
    throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        //BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
        try{
            dbManager.open("NXDADataSource");
            blNyxsettlelistAction.dumpByNodeType(dbManager, settleListCode, nodeTypeFrom, nodeTypeTo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    
    public Collection getGroupedSumData(String sqlCondition, boolean groupByKindCode, boolean groupByItemCode, boolean groupByLossRate, boolean groupByClaimRate)
    throws Exception{
    	
    	Collection resultList = new ArrayList();
        DBManager dbManager = new DBManager();
        BLNyxsettlelistAction BLNyxsettlelistAction = new BLNyxsettlelistAction();
        //BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
    	try{
            dbManager.open("NXDADataSource");
            resultList = BLNyxsettlelistAction.getGroupedSumData(dbManager, sqlCondition, groupByKindCode, groupByItemCode, groupByLossRate, groupByClaimRate);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    	return resultList;
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
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blNyxsettlelistAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
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
        
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
    	try{
            dbManager.open("NXDADataSource");
            settleSum = blNyxsettlelistAction.getSettleSumByFcodeNodeType(dbManager, settleListCode, fIdCard,nodeType);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    	return settleSum;
    }
    
    public int getMaxIndex(String conditions)
    throws Exception{
    int max=0;
    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    DBManager dbManager = new DBManager();
    BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
    //BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
    try{
        dbManager.open("NXDADataSource");
        max = blNyxsettlelistAction.getMaxIndex(dbManager,conditions);
    }catch(Exception exception){
        throw exception;
    }finally{
        dbManager.close();
    }
    return max;
}
    
    public double getDamageInsured(String conditions) 
    throws Exception{
	double rowCount=0;
    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    DBManager dbManager = new DBManager();
    BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
    //BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
    try{
        dbManager.open("NXDADataSource");
        rowCount = blNyxsettlelistAction.getDamageInsured(dbManager,conditions);
    }catch(Exception exception){
        throw exception;
    }finally{
        dbManager.close();
    }
    return rowCount;
}
    
    public Collection getGroupedSumDataByFcode(String sqlCondition)
    throws Exception{
    	
    	Collection resultList = new ArrayList();
        DBManager dbManager = new DBManager();
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        //BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
    	try{
            dbManager.open("NXDADataSource");
            resultList = blNyxsettlelistAction.getGroupedSumDataByFcode(dbManager, sqlCondition);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    	return resultList;
    }
}
