package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDprofitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDprofit;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdprofit优惠折扣条件表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDprofitActionBase{
    private static Log log = LogFactory.getLog(BLPrpDprofitActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDprofitActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDprofitDto prpDprofitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDprofitDto prpDprofitDto) throws Exception{
        DBPrpDprofit dbPrpDprofit = new DBPrpDprofit(dbManager);
        //插入记录
        dbPrpDprofit.insert(prpDprofitDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param comcode 地区代码
     * @param riskCode 险种
     * @param profitPeriod 批次
     * @param profitCode 优惠折扣代码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String comcode,String riskCode,int profitPeriod,String profitCode,int serialNo) throws Exception{
        DBPrpDprofit dbPrpDprofit = new DBPrpDprofit(dbManager);
        //删除记录
        dbPrpDprofit.delete(comcode, riskCode, profitPeriod, profitCode, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDprofit dbPrpDprofit = new DBPrpDprofit(dbManager);
        //按条件删除记录
        dbPrpDprofit.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDprofitDto prpDprofitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDprofitDto prpDprofitDto) throws Exception{
        DBPrpDprofit dbPrpDprofit = new DBPrpDprofit(dbManager);
        //更新记录
        dbPrpDprofit.update(prpDprofitDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param comcode 地区代码
     * @param riskCode 险种
     * @param profitPeriod 批次
     * @param profitCode 优惠折扣代码
     * @param serialNo 序号
     * @return prpDprofitDto prpDprofitDto
     * @throws Exception
     */
    public PrpDprofitDto findByPrimaryKey(DBManager dbManager,String comcode,String riskCode,int profitPeriod,String profitCode,int serialNo) throws Exception{
        DBPrpDprofit dbPrpDprofit = new DBPrpDprofit(dbManager);
        //声明DTO
        PrpDprofitDto prpDprofitDto = null;
        //查询数据,赋值给DTO
        prpDprofitDto = dbPrpDprofit.findByPrimaryKey(comcode, riskCode, profitPeriod, profitCode, serialNo);
        return prpDprofitDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDprofitDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDprofit dbPrpDprofit = new DBPrpDprofit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDprofit.getCount(conditions);
        collection = dbPrpDprofit.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDprofit dbPrpDprofit = new DBPrpDprofit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDprofit.getCount(conditions);
        return count;
    }
}
