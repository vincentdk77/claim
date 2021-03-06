package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJallocMidDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJallocMid;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjallocmid长期险业务保费分摊中间表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJallocMidActionBase{
    private static Log log = LogFactory.getLog(BLPrpJallocMidActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpJallocMidActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpJallocMidDto prpJallocMidDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJallocMidDto prpJallocMidDto) throws Exception{
        DBPrpJallocMid dbPrpJallocMid = new DBPrpJallocMid(dbManager);
        //插入记录
        dbPrpJallocMid.insert(prpJallocMidDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpJallocMid dbPrpJallocMid = new DBPrpJallocMid(dbManager);
        //删除记录
        dbPrpJallocMid.delete(policyNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJallocMid dbPrpJallocMid = new DBPrpJallocMid(dbManager);
        //按条件删除记录
        dbPrpJallocMid.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpJallocMidDto prpJallocMidDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJallocMidDto prpJallocMidDto) throws Exception{
        DBPrpJallocMid dbPrpJallocMid = new DBPrpJallocMid(dbManager);
        //更新记录
        dbPrpJallocMid.update(prpJallocMidDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号
     * @param serialNo 序号
     * @return prpJallocMidDto prpJallocMidDto
     * @throws Exception
     */
    public PrpJallocMidDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpJallocMid dbPrpJallocMid = new DBPrpJallocMid(dbManager);
        //声明DTO
        PrpJallocMidDto prpJallocMidDto = null;
        //查询数据,赋值给DTO
        prpJallocMidDto = dbPrpJallocMid.findByPrimaryKey(policyNo, serialNo);
        return prpJallocMidDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpJallocMidDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJallocMid dbPrpJallocMid = new DBPrpJallocMid(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJallocMid.getCount(conditions);
        collection = dbPrpJallocMid.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpJallocMid dbPrpJallocMid = new DBPrpJallocMid(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJallocMid.getCount(conditions);
        return count;
    }
}
