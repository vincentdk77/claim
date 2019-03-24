package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPrtRecordDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiPrtRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utiprtrecord打印记录表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiPrtRecordActionBase{
    private static Log log = LogFactory.getLog(BLUtiPrtRecordActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLUtiPrtRecordActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param utiPrtRecordDto utiPrtRecordDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiPrtRecordDto utiPrtRecordDto) throws Exception{
        DBUtiPrtRecord dbUtiPrtRecord = new DBUtiPrtRecord(dbManager);
        //插入记录
        dbUtiPrtRecord.insert(utiPrtRecordDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param certiNo 单据号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String certiNo) throws Exception{
        DBUtiPrtRecord dbUtiPrtRecord = new DBUtiPrtRecord(dbManager);
        //删除记录
        dbUtiPrtRecord.delete(certiNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiPrtRecord dbUtiPrtRecord = new DBUtiPrtRecord(dbManager);
        //按条件删除记录
        dbUtiPrtRecord.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param utiPrtRecordDto utiPrtRecordDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiPrtRecordDto utiPrtRecordDto) throws Exception{
        DBUtiPrtRecord dbUtiPrtRecord = new DBUtiPrtRecord(dbManager);
        //更新记录
        dbUtiPrtRecord.update(utiPrtRecordDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param certiNo 单据号
     * @return utiPrtRecordDto utiPrtRecordDto
     * @throws Exception
     */
    public UtiPrtRecordDto findByPrimaryKey(DBManager dbManager,String certiNo) throws Exception{
        DBUtiPrtRecord dbUtiPrtRecord = new DBUtiPrtRecord(dbManager);
        //声明DTO
        UtiPrtRecordDto utiPrtRecordDto = null;
        //查询数据,赋值给DTO
        utiPrtRecordDto = dbUtiPrtRecord.findByPrimaryKey(certiNo);
        return utiPrtRecordDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含utiPrtRecordDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiPrtRecord dbUtiPrtRecord = new DBUtiPrtRecord(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiPrtRecord.getCount(conditions);
        collection = dbUtiPrtRecord.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBUtiPrtRecord dbUtiPrtRecord = new DBUtiPrtRecord(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiPrtRecord.getCount(conditions);
        return count;
    }
}
