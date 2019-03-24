package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PlantingsettlelistDto;
import com.gyic.claim.bl.action.domain.BLPlantingsettlelistAction;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PLANTINGSETTLELIST的业务逻辑对象Facade基类<br>
 */
public class BLPlantingsettlelistFacadeBase{
    private static Logger logger = Logger.getLogger(BLPlantingsettlelistFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPlantingsettlelistFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param plantingsettlelistDto plantingsettlelistDto
     * @throws Exception
     */
    public void insert(PlantingsettlelistDto plantingsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //插入记录
            blPlantingsettlelistAction.insert(dbManager,plantingsettlelistDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    /**
     * 插入多条数据
     * @param List plantingSettleListDtoList
     * @throws Exception
     */
    public void insert(List plantingSettleListDtoList)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            if(null!=plantingSettleListDtoList){
            	for(int i=0;i<plantingSettleListDtoList.size();i++){
            		PlantingsettlelistDto plantingsettlelistDto = (PlantingsettlelistDto)plantingSettleListDtoList.get(i);
		            //插入记录
		            blPlantingsettlelistAction.insert(dbManager,plantingsettlelistDto);
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
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @throws Exception
     */
    public void delete(String settlelistcode,String fcode,String kindcode,String nodetype,int indexofsettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //删除记录
            blPlantingsettlelistAction.delete(dbManager,settlelistcode, fcode, kindcode, nodetype, indexofsettle);
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
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blPlantingsettlelistAction.deleteByConditions(dbManager,conditions);
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
     * @param plantingsettlelistDto plantingsettlelistDto
     * @throws Exception
     */
    public void update(PlantingsettlelistDto plantingsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //更新记录
            blPlantingsettlelistAction.update(dbManager,plantingsettlelistDto);
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
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @return plantingsettlelistDto plantingsettlelistDto
     * @throws Exception
     */
    public PlantingsettlelistDto findByPrimaryKey(String settlelistcode,String fcode,String kindcode,String nodetype,int indexofsettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        //声明DTO
        PlantingsettlelistDto plantingsettlelistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //查询数据,赋值给DTO
            plantingsettlelistDto = blPlantingsettlelistAction.findByPrimaryKey(dbManager,settlelistcode, fcode, kindcode, nodetype, indexofsettle);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return plantingsettlelistDto;
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
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blPlantingsettlelistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含plantingsettlelistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blPlantingsettlelistAction.findByConditions(dbManager,conditions);
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
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blPlantingsettlelistAction.getCount(dbManager,conditions);
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
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blPlantingsettlelistAction.getDistinctLossRateCount(dbManager,conditions);
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
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blPlantingsettlelistAction.getDamageInsured(dbManager,conditions);
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
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blPlantingsettlelistAction.getSum(dbManager,conditions,fieldName);
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
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            max = blPlantingsettlelistAction.getMaxIndex(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return max;
    }
}
