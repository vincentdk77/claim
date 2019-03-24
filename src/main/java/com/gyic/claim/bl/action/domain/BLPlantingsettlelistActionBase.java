package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PlantingsettlelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingsettlelist;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PLANTINGSETTLELIST的业务逻辑对象类<br>
 */
public class BLPlantingsettlelistActionBase{
    private static Logger logger = Logger.getLogger(BLPlantingsettlelistActionBase.class);

    /**
     * 构造函数
     */
    public BLPlantingsettlelistActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param plantingsettlelistDto plantingsettlelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PlantingsettlelistDto plantingsettlelistDto)
            throws Exception{
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);
        //插入记录
        dbPlantingsettlelist.insert(plantingsettlelistDto);
    }

    /**
     * 插入多条数据
     * @param dbManager DB管理器
     * @param plantingsettlelistDto plantingsettlelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,List plantingsettlelistDtoList)
            throws Exception{
    	if(null!=plantingsettlelistDtoList && plantingsettlelistDtoList.size()>0){
	        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);
	        PlantingsettlelistDto plantingsettlelistDto = new PlantingsettlelistDto();
	        //插入记录
	        for(int i=0;i<plantingsettlelistDtoList.size();i++){
	        	plantingsettlelistDto = (PlantingsettlelistDto)plantingsettlelistDtoList.get(i);
	        	dbPlantingsettlelist.insert(plantingsettlelistDto);
	        }
    	}
    }
    
    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param settlelistcode SETTLELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String settlelistcode,String fcode,String kindcode,String nodetype,int indexofsettle)
            throws Exception{
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);
        //删除记录
        dbPlantingsettlelist.delete(settlelistcode, fcode, kindcode, nodetype, indexofsettle);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);
        //按条件删除记录
        dbPlantingsettlelist.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param plantingsettlelistDto plantingsettlelistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PlantingsettlelistDto plantingsettlelistDto)
            throws Exception{
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);
        //更新记录
        dbPlantingsettlelist.update(plantingsettlelistDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param settlelistcode SETTLELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @return plantingsettlelistDto plantingsettlelistDto
     * @throws Exception
     */
    public PlantingsettlelistDto findByPrimaryKey(DBManager dbManager,String settlelistcode,String fcode,String kindcode,String nodetype,int indexofsettle)
            throws Exception{
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);
        //声明DTO
        PlantingsettlelistDto plantingsettlelistDto = null;
        //查询数据,赋值给DTO
        plantingsettlelistDto = dbPlantingsettlelist.findByPrimaryKey(settlelistcode, fcode, kindcode, nodetype, indexofsettle);
        return plantingsettlelistDto;
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
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlantingsettlelist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPlantingsettlelist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含plantingsettlelistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPlantingsettlelist.findByConditions(conditions);
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
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlantingsettlelist.getCount(conditions);
        return count;
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
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlantingsettlelist.getDistinctLossRateCount(conditions);
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
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double count = dbPlantingsettlelist.getDamageInsured(conditions);
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
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbPlantingsettlelist.getSum(conditions,fieldName);
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
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int max = dbPlantingsettlelist.getMaxIndex(conditions);
        return max;
    }
    
    /**
     * 将数据从临时表 PLANTINGSETTLELISTTEMP 存入正式表 PLANTINGSETTLELIST
     * @param settleListCode 正式表中的理赔清单号
     * @param indexOfSettle 正式表中的序号
     * @param whereCondition 临时表查询条件，决定将那些数据插入正式表。
     * @throws Exception
     */
    public void evaluate(DBManager dbManager, String settleListCode, int indexOfSettle, String whereCondition) throws Exception{
    	DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);

        if(whereCondition.trim().length()==0){
        	whereCondition = "1=1";
        }
        dbPlantingsettlelist.evaluate(settleListCode, indexOfSettle, whereCondition);
    }
}
