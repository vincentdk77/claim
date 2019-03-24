package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalsettlelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBMedicalsettlelist;
import java.math.BigDecimal;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PLANTINGSETTLELIST的业务逻辑对象类<br>
 */
public class BLMedicalsettlelistActionBase{
    private static Logger logger = Logger.getLogger(BLMedicalsettlelistActionBase.class);

    /**
     * 构造函数
     */
    public BLMedicalsettlelistActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param medicalsettlelistDto medicalsettlelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,MedicalsettlelistDto medicalsettlelistDto)
            throws Exception{
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);
        //插入记录
        dbMedicalsettlelist.insert(medicalsettlelistDto);
    }

    /**
     * 插入多条数据
     * @param dbManager DB管理器
     * @param medicalsettlelistDto medicalsettlelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,List medicalsettlelistDtoList)
            throws Exception{
    	if(null!=medicalsettlelistDtoList && medicalsettlelistDtoList.size()>0){
	        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);
	        MedicalsettlelistDto medicalsettlelistDto = new MedicalsettlelistDto();
	        //插入记录
	        for(int i=0;i<medicalsettlelistDtoList.size();i++){
	        	medicalsettlelistDto = (MedicalsettlelistDto)medicalsettlelistDtoList.get(i);
	        	dbMedicalsettlelist.insert(medicalsettlelistDto);
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
    public void delete(DBManager dbManager,String settlelistcode,String idcard,String nodetype,int indexofsettle)
            throws Exception{
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);
        //删除记录
        dbMedicalsettlelist.delete(settlelistcode, idcard, nodetype, indexofsettle);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);
        //按条件删除记录
        dbMedicalsettlelist.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param medicalsettlelistDto medicalsettlelistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,MedicalsettlelistDto medicalsettlelistDto)
            throws Exception{
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);
        //更新记录
        dbMedicalsettlelist.update(medicalsettlelistDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param settlelistcode SETTLELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @return medicalsettlelistDto medicalsettlelistDto
     * @throws Exception
     */
    public MedicalsettlelistDto findByPrimaryKey(DBManager dbManager,String settlelistcode,String idcard,String nodetype,int indexofsettle)
            throws Exception{
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);
        //声明DTO
        MedicalsettlelistDto medicalsettlelistDto = null;
        //查询数据,赋值给DTO
        medicalsettlelistDto = dbMedicalsettlelist.findByPrimaryKey(settlelistcode, idcard, nodetype, indexofsettle);
        return medicalsettlelistDto;
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
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMedicalsettlelist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbMedicalsettlelist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含medicalsettlelistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbMedicalsettlelist.findByConditions(conditions);
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
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMedicalsettlelist.getCount(conditions);
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
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMedicalsettlelist.getDistinctLossRateCount(conditions);
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
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double count = dbMedicalsettlelist.getDamageInsured(conditions);
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
    public BigDecimal getSum(DBManager dbManager,String conditions,String fieldName) 
        throws Exception{
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        BigDecimal sum = dbMedicalsettlelist.getSum(conditions,fieldName);
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
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int max = dbMedicalsettlelist.getMaxIndex(conditions);
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
    	DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);

        if(whereCondition.trim().length()==0){
        	whereCondition = "1=1";
        }
        dbMedicalsettlelist.evaluate(settleListCode, indexOfSettle, whereCondition);
    }
}
