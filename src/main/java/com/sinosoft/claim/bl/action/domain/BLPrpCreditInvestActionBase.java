package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCreditInvestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCreditInvest;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpCreditInvest资信调查表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCreditInvestActionBase{
    private static Log log = LogFactory.getLog(BLPrpCreditInvestActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpCreditInvestActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCreditInvestDto prpCreditInvestDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCreditInvestDto prpCreditInvestDto) throws Exception{
        DBPrpCreditInvest dbPrpCreditInvest = new DBPrpCreditInvest(dbManager);
        //插入记录
        dbPrpCreditInvest.insert(prpCreditInvestDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param investigateNo 风险预警号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String investigateNo) throws Exception{
        DBPrpCreditInvest dbPrpCreditInvest = new DBPrpCreditInvest(dbManager);
        //删除记录
        dbPrpCreditInvest.delete(investigateNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCreditInvest dbPrpCreditInvest = new DBPrpCreditInvest(dbManager);
        //按条件删除记录
        dbPrpCreditInvest.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCreditInvestDto prpCreditInvestDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCreditInvestDto prpCreditInvestDto) throws Exception{
        DBPrpCreditInvest dbPrpCreditInvest = new DBPrpCreditInvest(dbManager);
        //更新记录
        dbPrpCreditInvest.update(prpCreditInvestDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param investigateNo 风险预警号
     * @return prpCreditInvestDto prpCreditInvestDto
     * @throws Exception
     */
    public PrpCreditInvestDto findByPrimaryKey(DBManager dbManager,String investigateNo) throws Exception{
        DBPrpCreditInvest dbPrpCreditInvest = new DBPrpCreditInvest(dbManager);
        //声明DTO
        PrpCreditInvestDto prpCreditInvestDto = null;
        //查询数据,赋值给DTO
        prpCreditInvestDto = dbPrpCreditInvest.findByPrimaryKey(investigateNo);
        return prpCreditInvestDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCreditInvestDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCreditInvest dbPrpCreditInvest = new DBPrpCreditInvest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCreditInvest.getCount(conditions);
        collection = dbPrpCreditInvest.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCreditInvest dbPrpCreditInvest = new DBPrpCreditInvest(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCreditInvest.getCount(conditions);
        return count;
    }
}
