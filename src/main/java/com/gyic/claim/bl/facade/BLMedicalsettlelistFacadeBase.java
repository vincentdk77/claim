package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalsettlelistDto;
import com.gyic.claim.bl.action.domain.BLMedicalsettlelistAction;
import java.math.BigDecimal;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PLANTINGSETTLELIST的业务逻辑对象Facade基类<br>
 */
public class BLMedicalsettlelistFacadeBase{
    private static Logger logger = Logger.getLogger(BLMedicalsettlelistFacadeBase.class);

    /**
     * 构造函数
     */
    public BLMedicalsettlelistFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param medicalsettlelistDto medicalsettlelistDto
     * @throws Exception
     */
    public void insert(MedicalsettlelistDto medicalsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //插入记录
            blMedicalsettlelistAction.insert(dbManager,medicalsettlelistDto);
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
     * @param List medicalSettleListDtoList
     * @throws Exception
     */
    public void insert(List medicalSettleListDtoList)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            if(null!=medicalSettleListDtoList){
            	for(int i=0;i<medicalSettleListDtoList.size();i++){
            		MedicalsettlelistDto medicalsettlelistDto = (MedicalsettlelistDto)medicalSettleListDtoList.get(i);
		            //插入记录
		            blMedicalsettlelistAction.insert(dbManager,medicalsettlelistDto);
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
    public void delete(String settlelistcode,String idcard,String nodetype,int indexofsettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //删除记录
            blMedicalsettlelistAction.delete(dbManager,settlelistcode, idcard,  nodetype, indexofsettle);
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
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blMedicalsettlelistAction.deleteByConditions(dbManager,conditions);
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
     * @param medicalsettlelistDto medicalsettlelistDto
     * @throws Exception
     */
    public void update(MedicalsettlelistDto medicalsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //更新记录
            blMedicalsettlelistAction.update(dbManager,medicalsettlelistDto);
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
     * @return medicalsettlelistDto medicalsettlelistDto
     * @throws Exception
     */
    public MedicalsettlelistDto findByPrimaryKey(String settlelistcode,String idcard,String nodetype,int indexofsettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        //声明DTO
        MedicalsettlelistDto medicalsettlelistDto = null;
        try{
            dbManager.open("JKXDataSource");
            //查询数据,赋值给DTO
            medicalsettlelistDto = blMedicalsettlelistAction.findByPrimaryKey(dbManager,settlelistcode, idcard, nodetype, indexofsettle);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return medicalsettlelistDto;
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
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            pageRecord = blMedicalsettlelistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection 包含medicalsettlelistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            collection = blMedicalsettlelistAction.findByConditions(dbManager,conditions);
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
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            rowCount = blMedicalsettlelistAction.getCount(dbManager,conditions);
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
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            rowCount = blMedicalsettlelistAction.getDistinctLossRateCount(dbManager,conditions);
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
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            rowCount = blMedicalsettlelistAction.getDamageInsured(dbManager,conditions);
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
    public BigDecimal getSum(String conditions, String fieldName)
        throws Exception{
    	BigDecimal sum =new BigDecimal(0);
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            sum = blMedicalsettlelistAction.getSum(dbManager,conditions,fieldName);
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
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            max = blMedicalsettlelistAction.getMaxIndex(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return max;
    }
}
