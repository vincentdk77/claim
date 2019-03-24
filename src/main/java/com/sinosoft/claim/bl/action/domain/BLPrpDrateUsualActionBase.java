package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDrateUsualDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDrateUsual;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdrateusual费率代码表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrateUsualActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrateUsualActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

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
     * @param riskCode 险种代码
     * @param ratePeriod 费率期数
     * @param rateCode 费率代码
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
     * @param riskCode 险种代码
     * @param ratePeriod 费率期数
     * @param rateCode 费率代码
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

        rowCount = dbPrpDrateUsual.getCount(conditions);
        collection = dbPrpDrateUsual.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDrateUsual dbPrpDrateUsual = new DBPrpDrateUsual(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDrateUsual.getCount(conditions);
        return count;
    }
}
