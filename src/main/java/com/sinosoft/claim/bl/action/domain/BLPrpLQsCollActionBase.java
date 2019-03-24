package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLQsCollDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLQsColl;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLQs_coll清算中心通赔结算汇总表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLQsCollActionBase{
    private static Log log = LogFactory.getLog(BLPrpLQsCollActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpLQsCollActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLQs_collDto prpLQs_collDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLQsCollDto prpLQs_collDto) throws Exception{
        DBPrpLQsColl dbPrpLQs_coll = new DBPrpLQsColl(dbManager);
        //插入记录
        dbPrpLQs_coll.insert(prpLQs_collDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param batchNo 总批次号
     * @param procNo 结算单批次号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String batchNo,String procNo) throws Exception{
        DBPrpLQsColl dbPrpLQs_coll = new DBPrpLQsColl(dbManager);
        //删除记录
        dbPrpLQs_coll.delete(batchNo, procNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLQsColl dbPrpLQs_coll = new DBPrpLQsColl(dbManager);
        //按条件删除记录
        dbPrpLQs_coll.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLQs_collDto prpLQs_collDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLQsCollDto prpLQs_collDto) throws Exception{
        DBPrpLQsColl dbPrpLQs_coll = new DBPrpLQsColl(dbManager);
        //更新记录
        dbPrpLQs_coll.update(prpLQs_collDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param batchNo 总批次号
     * @param procNo 结算单批次号
     * @return prpLQs_collDto prpLQs_collDto
     * @throws Exception
     */
    public PrpLQsCollDto findByPrimaryKey(DBManager dbManager,String batchNo,String procNo) throws Exception{
        DBPrpLQsColl dbPrpLQs_coll = new DBPrpLQsColl(dbManager);
        //声明DTO
        PrpLQsCollDto prpLQs_collDto = null;
        //查询数据,赋值给DTO
        prpLQs_collDto = dbPrpLQs_coll.findByPrimaryKey(batchNo, procNo);
        return prpLQs_collDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpLQs_collDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLQsColl dbPrpLQs_coll = new DBPrpLQsColl(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpLQs_coll.getCount(conditions);
        collection = dbPrpLQs_coll.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpLQsColl dbPrpLQs_coll = new DBPrpLQsColl(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLQs_coll.getCount(conditions);
        return count;
    }
}
