package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCinsuredDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCinsured;
import com.sinosoft.prpall.dbsvr.cb.DBPrpCvirturlItem;
import com.sinosoft.prpall.schema.PrpCvirturlItemSchema;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcinsured保险关系人表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCinsuredActionBase{
    private static Log log = LogFactory.getLog(BLPrpCinsuredActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpCinsuredActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCinsuredDto prpCinsuredDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCinsuredDto prpCinsuredDto) throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
        //插入记录
        dbPrpCinsured.insert(prpCinsuredDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
        //删除记录
        dbPrpCinsured.delete(policyNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
        //按条件删除记录
        dbPrpCinsured.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCinsuredDto prpCinsuredDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCinsuredDto prpCinsuredDto) throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
        //更新记录
        dbPrpCinsured.update(prpCinsuredDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @return prpCinsuredDto prpCinsuredDto
     * @throws Exception
     */
    public PrpCinsuredDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
        //声明DTO
        PrpCinsuredDto prpCinsuredDto = null;
        //查询数据,赋值给DTO
        prpCinsuredDto = dbPrpCinsured.findByPrimaryKey(policyNo, serialNo);
        return prpCinsuredDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCinsuredDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCinsured.getCount(conditions);
        collection = dbPrpCinsured.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * 按条件查询出理赔分户的多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCinsuredDto的集合
     * @throws Exception
     */
    public Collection findVirturlItemByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCinsured.getVirturlItemCount(conditions);
        
        collection = dbPrpCinsured.findVirturlItemByConditions(conditions,pageNo,rowsPerPage);
        Iterator it = collection.iterator();
        while(it.hasNext()){
        	PrpCvirturlItemSchema prpCvirturlItemSchema = (PrpCvirturlItemSchema)it.next();
        	if(prpCvirturlItemSchema.getFamilySex()==null||prpCvirturlItemSchema.getFamilySex()==""){
        		prpCvirturlItemSchema.setFamilySex("9");
        	}
        }

        
        return collection;
    }
    /**
     * 从prpcvirturlItem表中取乡村干部组合保险数据
     * @param dbManager
     * @param conditions
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
    public Collection findViturlItemDtoByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCinsured.getVirturlItemCount(conditions);
        
        collection = dbPrpCinsured.findViturlItemDtoByConditions(conditions,pageNo,rowsPerPage);
        Iterator it = collection.iterator();
        while(it.hasNext()){
        	PrpCvirturlItemSchema prpCvirturlItemSchema = (PrpCvirturlItemSchema)it.next();
        	if(prpCvirturlItemSchema.getFamilySex()==null||prpCvirturlItemSchema.getFamilySex()==""){
        		prpCvirturlItemSchema.setFamilySex("9");
        	}
        }

        
        return collection;
    }
    /**
     * 必须在findByConditions后调用,返回findByConditions查询到的记录数
     * @return 记录数
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCinsured.getCount(conditions);
        return count;
    }
    
    /**
     * 查询种植险农户清单信息展示成事故者信息方法
     * @param dbManager
     * @param conditions
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
    public Collection findByPlantingConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        collection = dbPrpCinsured.findByPlantingConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }
}
