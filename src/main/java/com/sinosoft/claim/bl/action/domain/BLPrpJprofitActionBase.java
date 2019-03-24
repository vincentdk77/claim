package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJprofitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJprofit;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjprofit优惠记录表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJprofitActionBase{
    private static Log log = LogFactory.getLog(BLPrpJprofitActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpJprofitActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpJprofitDto prpJprofitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJprofitDto prpJprofitDto) throws Exception{
        DBPrpJprofit dbPrpJprofit = new DBPrpJprofit(dbManager);
        //插入记录
        dbPrpJprofit.insert(prpJprofitDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 保险单号次
     * @param profitNo 优惠序号
     * @param itemKindNo 标的险别序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int profitNo,int itemKindNo) throws Exception{
        DBPrpJprofit dbPrpJprofit = new DBPrpJprofit(dbManager);
        //删除记录
        dbPrpJprofit.delete(policyNo, profitNo, itemKindNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJprofit dbPrpJprofit = new DBPrpJprofit(dbManager);
        //按条件删除记录
        dbPrpJprofit.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpJprofitDto prpJprofitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJprofitDto prpJprofitDto) throws Exception{
        DBPrpJprofit dbPrpJprofit = new DBPrpJprofit(dbManager);
        //更新记录
        dbPrpJprofit.update(prpJprofitDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 保险单号次
     * @param profitNo 优惠序号
     * @param itemKindNo 标的险别序号
     * @return prpJprofitDto prpJprofitDto
     * @throws Exception
     */
    public PrpJprofitDto findByPrimaryKey(DBManager dbManager,String policyNo,int profitNo,int itemKindNo) throws Exception{
        DBPrpJprofit dbPrpJprofit = new DBPrpJprofit(dbManager);
        //声明DTO
        PrpJprofitDto prpJprofitDto = null;
        //查询数据,赋值给DTO
        prpJprofitDto = dbPrpJprofit.findByPrimaryKey(policyNo, profitNo, itemKindNo);
        return prpJprofitDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpJprofitDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJprofit dbPrpJprofit = new DBPrpJprofit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJprofit.getCount(conditions);
        collection = dbPrpJprofit.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpJprofit dbPrpJprofit = new DBPrpJprofit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJprofit.getCount(conditions);
        return count;
    }
}
