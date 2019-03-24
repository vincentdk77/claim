package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiTtyRecordDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiTtyRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utittyrecord登录记录表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiTtyRecordActionBase{
    private static Log log = LogFactory.getLog(BLUtiTtyRecordActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLUtiTtyRecordActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param utiTtyRecordDto utiTtyRecordDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiTtyRecordDto utiTtyRecordDto) throws Exception{
        DBUtiTtyRecord dbUtiTtyRecord = new DBUtiTtyRecord(dbManager);
        //插入记录
        dbUtiTtyRecord.insert(utiTtyRecordDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param sysTty 系统设备号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String sysTty) throws Exception{
        DBUtiTtyRecord dbUtiTtyRecord = new DBUtiTtyRecord(dbManager);
        //删除记录
        dbUtiTtyRecord.delete(sysTty);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiTtyRecord dbUtiTtyRecord = new DBUtiTtyRecord(dbManager);
        //按条件删除记录
        dbUtiTtyRecord.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param utiTtyRecordDto utiTtyRecordDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiTtyRecordDto utiTtyRecordDto) throws Exception{
        DBUtiTtyRecord dbUtiTtyRecord = new DBUtiTtyRecord(dbManager);
        //更新记录
        dbUtiTtyRecord.update(utiTtyRecordDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param sysTty 系统设备号
     * @return utiTtyRecordDto utiTtyRecordDto
     * @throws Exception
     */
    public UtiTtyRecordDto findByPrimaryKey(DBManager dbManager,String sysTty) throws Exception{
        DBUtiTtyRecord dbUtiTtyRecord = new DBUtiTtyRecord(dbManager);
        //声明DTO
        UtiTtyRecordDto utiTtyRecordDto = null;
        //查询数据,赋值给DTO
        utiTtyRecordDto = dbUtiTtyRecord.findByPrimaryKey(sysTty);
        return utiTtyRecordDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含utiTtyRecordDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiTtyRecord dbUtiTtyRecord = new DBUtiTtyRecord(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiTtyRecord.getCount(conditions);
        collection = dbUtiTtyRecord.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBUtiTtyRecord dbUtiTtyRecord = new DBUtiTtyRecord(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiTtyRecord.getCount(conditions);
        return count;
    }
}
