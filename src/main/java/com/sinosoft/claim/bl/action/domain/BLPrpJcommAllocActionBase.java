package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJcommAllocDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJcommAlloc;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjcommalloc手续费分摊表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJcommAllocActionBase{
    private static Log log = LogFactory.getLog(BLPrpJcommAllocActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpJcommAllocActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpJcommAllocDto prpJcommAllocDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJcommAllocDto prpJcommAllocDto) throws Exception{
        DBPrpJcommAlloc dbPrpJcommAlloc = new DBPrpJcommAlloc(dbManager);
        //插入记录
        dbPrpJcommAlloc.insert(prpJcommAllocDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param allocNo 分摊号
     * @param policyNo 保单号
     * @param serialNo 分摊序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String allocNo,String policyNo,int serialNo) throws Exception{
        DBPrpJcommAlloc dbPrpJcommAlloc = new DBPrpJcommAlloc(dbManager);
        //删除记录
        dbPrpJcommAlloc.delete(allocNo, policyNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJcommAlloc dbPrpJcommAlloc = new DBPrpJcommAlloc(dbManager);
        //按条件删除记录
        dbPrpJcommAlloc.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpJcommAllocDto prpJcommAllocDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJcommAllocDto prpJcommAllocDto) throws Exception{
        DBPrpJcommAlloc dbPrpJcommAlloc = new DBPrpJcommAlloc(dbManager);
        //更新记录
        dbPrpJcommAlloc.update(prpJcommAllocDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param allocNo 分摊号
     * @param policyNo 保单号
     * @param serialNo 分摊序号
     * @return prpJcommAllocDto prpJcommAllocDto
     * @throws Exception
     */
    public PrpJcommAllocDto findByPrimaryKey(DBManager dbManager,String allocNo,String policyNo,int serialNo) throws Exception{
        DBPrpJcommAlloc dbPrpJcommAlloc = new DBPrpJcommAlloc(dbManager);
        //声明DTO
        PrpJcommAllocDto prpJcommAllocDto = null;
        //查询数据,赋值给DTO
        prpJcommAllocDto = dbPrpJcommAlloc.findByPrimaryKey(allocNo, policyNo, serialNo);
        return prpJcommAllocDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpJcommAllocDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJcommAlloc dbPrpJcommAlloc = new DBPrpJcommAlloc(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJcommAlloc.getCount(conditions);
        collection = dbPrpJcommAlloc.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpJcommAlloc dbPrpJcommAlloc = new DBPrpJcommAlloc(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJcommAlloc.getCount(conditions);
        return count;
    }
}
