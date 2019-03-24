package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDshortRateDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDshortRate;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdshortrate的业务逻辑对象类<br>
 * 创建于 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDshortRateActionBase{
    private static Log log = LogFactory.getLog(BLPrpDshortRateActionBase.class.getName());
    protected int count; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDshortRateActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDshortRateDto prpDshortRateDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDshortRateDto prpDshortRateDto) throws Exception{
        DBPrpDshortRate dbPrpDshortRate = new DBPrpDshortRate(dbManager);
        //插入记录
        dbPrpDshortRate.insert(prpDshortRateDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param riskCode riskcode
     * @param months months
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,int months) throws Exception{
        DBPrpDshortRate dbPrpDshortRate = new DBPrpDshortRate(dbManager);
        //删除记录
        dbPrpDshortRate.delete(riskCode, months);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDshortRate dbPrpDshortRate = new DBPrpDshortRate(dbManager);
        //按条件删除记录
        dbPrpDshortRate.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDshortRateDto prpDshortRateDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDshortRateDto prpDshortRateDto) throws Exception{
        DBPrpDshortRate dbPrpDshortRate = new DBPrpDshortRate(dbManager);
        //更新记录
        dbPrpDshortRate.update(prpDshortRateDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param riskCode riskcode
     * @param months months
     * @return prpDshortRateDto prpDshortRateDto
     * @throws Exception
     */
    public PrpDshortRateDto findByPrimaryKey(DBManager dbManager,String riskCode,int months) throws Exception{
        DBPrpDshortRate dbPrpDshortRate = new DBPrpDshortRate(dbManager);
        //声明DTO
        PrpDshortRateDto prpDshortRateDto = null;
        //查询数据,赋值给DTO
        prpDshortRateDto = dbPrpDshortRate.findByPrimaryKey(riskCode, months);
        return prpDshortRateDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDshortRateDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDshortRate dbPrpDshortRate = new DBPrpDshortRate(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDshortRate.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDshortRate.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpDshortRateDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        return findByConditions(dbManager,conditions,0,0);
    }

    /**
     * 必须在findByConditions后调用,返回findByConditions查询到的记录数
     * @return 记录数
     */
    public int getCount(){
        return count;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpDshortRate dbPrpDshortRate = new DBPrpDshortRate(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDshortRate.getCount(conditions);
        return count;
    }
}
