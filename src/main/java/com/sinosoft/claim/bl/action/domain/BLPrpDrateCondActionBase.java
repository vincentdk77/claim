package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDrateCondDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDrateCond;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdratecond费率条件表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDrateCondActionBase{
    private static Log log = LogFactory.getLog(BLPrpDrateCondActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDrateCondActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDrateCondDto prpDrateCondDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDrateCondDto prpDrateCondDto) throws Exception{
        DBPrpDrateCond dbPrpDrateCond = new DBPrpDrateCond(dbManager);
        //插入记录
        dbPrpDrateCond.insert(prpDrateCondDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param ratePeriod 费率期数
     * @param condCode 条件代码
     * @param valueCode 取值代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,int ratePeriod,String condCode,String valueCode) throws Exception{
        DBPrpDrateCond dbPrpDrateCond = new DBPrpDrateCond(dbManager);
        //删除记录
        dbPrpDrateCond.delete(riskCode, ratePeriod, condCode, valueCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDrateCond dbPrpDrateCond = new DBPrpDrateCond(dbManager);
        //按条件删除记录
        dbPrpDrateCond.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDrateCondDto prpDrateCondDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDrateCondDto prpDrateCondDto) throws Exception{
        DBPrpDrateCond dbPrpDrateCond = new DBPrpDrateCond(dbManager);
        //更新记录
        dbPrpDrateCond.update(prpDrateCondDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param ratePeriod 费率期数
     * @param condCode 条件代码
     * @param valueCode 取值代码
     * @return prpDrateCondDto prpDrateCondDto
     * @throws Exception
     */
    public PrpDrateCondDto findByPrimaryKey(DBManager dbManager,String riskCode,int ratePeriod,String condCode,String valueCode) throws Exception{
        DBPrpDrateCond dbPrpDrateCond = new DBPrpDrateCond(dbManager);
        //声明DTO
        PrpDrateCondDto prpDrateCondDto = null;
        //查询数据,赋值给DTO
        prpDrateCondDto = dbPrpDrateCond.findByPrimaryKey(riskCode, ratePeriod, condCode, valueCode);
        return prpDrateCondDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDrateCondDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDrateCond dbPrpDrateCond = new DBPrpDrateCond(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDrateCond.getCount(conditions);
        collection = dbPrpDrateCond.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDrateCond dbPrpDrateCond = new DBPrpDrateCond(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDrateCond.getCount(conditions);
        return count;
    }
}
