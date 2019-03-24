package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDrateUsualDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDrateUsual;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdrateusual的业务逻辑对象类<br>
 * 创建于 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrateUsualActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrateUsualActionBase.class.getName());
    protected int count; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDrateUsualActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDrateUsualDto prpDrateUsualDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDrateUsualDto prpDrateUsualDto) throws Exception{
        DBPrpDrateUsual dbPrpDrateUsual = new DBPrpDrateUsual(dbManager);
        //插入记录
        dbPrpDrateUsual.insert(prpDrateUsualDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param riskCode riskcode
     * @param ratePeriod rateperiod
     * @param rateCode ratecode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,int ratePeriod,String rateCode) throws Exception{
        DBPrpDrateUsual dbPrpDrateUsual = new DBPrpDrateUsual(dbManager);
        //删除记录
        dbPrpDrateUsual.delete(riskCode, ratePeriod, rateCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDrateUsual dbPrpDrateUsual = new DBPrpDrateUsual(dbManager);
        //按条件删除记录
        dbPrpDrateUsual.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDrateUsualDto prpDrateUsualDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDrateUsualDto prpDrateUsualDto) throws Exception{
        DBPrpDrateUsual dbPrpDrateUsual = new DBPrpDrateUsual(dbManager);
        //更新记录
        dbPrpDrateUsual.update(prpDrateUsualDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param riskCode riskcode
     * @param ratePeriod rateperiod
     * @param rateCode ratecode
     * @return prpDrateUsualDto prpDrateUsualDto
     * @throws Exception
     */
    public PrpDrateUsualDto findByPrimaryKey(DBManager dbManager,String riskCode,int ratePeriod,String rateCode) throws Exception{
        DBPrpDrateUsual dbPrpDrateUsual = new DBPrpDrateUsual(dbManager);
        //声明DTO
        PrpDrateUsualDto prpDrateUsualDto = null;
        //查询数据,赋值给DTO
        prpDrateUsualDto = dbPrpDrateUsual.findByPrimaryKey(riskCode, ratePeriod, rateCode);
        return prpDrateUsualDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDrateUsualDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDrateUsual dbPrpDrateUsual = new DBPrpDrateUsual(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDrateUsual.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDrateUsual.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpDrateUsualDto的集合
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
        DBPrpDrateUsual dbPrpDrateUsual = new DBPrpDrateUsual(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDrateUsual.getCount(conditions);
        return count;
    }
}
