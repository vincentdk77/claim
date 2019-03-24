package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCprofitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCprofit;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcprofit优惠信息表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCprofitActionBase{
    private static Log log = LogFactory.getLog(BLPrpCprofitActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpCprofitActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCprofitDto prpCprofitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCprofitDto prpCprofitDto) throws Exception{
        DBPrpCprofit dbPrpCprofit = new DBPrpCprofit(dbManager);
        //插入记录
        dbPrpCprofit.insert(prpCprofitDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号
     * @param profitType 优惠折扣类型
     * @param itemkindNo 标的险别序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,String profitType,int itemkindNo) throws Exception{
        DBPrpCprofit dbPrpCprofit = new DBPrpCprofit(dbManager);
        //删除记录
        dbPrpCprofit.delete(policyNo, profitType, itemkindNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCprofit dbPrpCprofit = new DBPrpCprofit(dbManager);
        //按条件删除记录
        dbPrpCprofit.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCprofitDto prpCprofitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCprofitDto prpCprofitDto) throws Exception{
        DBPrpCprofit dbPrpCprofit = new DBPrpCprofit(dbManager);
        //更新记录
        dbPrpCprofit.update(prpCprofitDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号
     * @param profitType 优惠折扣类型
     * @param itemkindNo 标的险别序号
     * @return prpCprofitDto prpCprofitDto
     * @throws Exception
     */
    public PrpCprofitDto findByPrimaryKey(DBManager dbManager,String policyNo,String profitType,int itemkindNo) throws Exception{
        DBPrpCprofit dbPrpCprofit = new DBPrpCprofit(dbManager);
        //声明DTO
        PrpCprofitDto prpCprofitDto = null;
        //查询数据,赋值给DTO
        prpCprofitDto = dbPrpCprofit.findByPrimaryKey(policyNo, profitType, itemkindNo);
        return prpCprofitDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCprofitDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCprofit dbPrpCprofit = new DBPrpCprofit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCprofit.getCount(conditions);
        collection = dbPrpCprofit.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCprofit dbPrpCprofit = new DBPrpCprofit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCprofit.getCount(conditions);
        return count;
    }
}
