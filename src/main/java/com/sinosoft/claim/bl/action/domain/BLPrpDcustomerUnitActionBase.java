package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcustomerUnitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcustomerUnit;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDcustomerUnit单位客户代码表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcustomerUnitActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcustomerUnitActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDcustomerUnitActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param PrpDcustomerUnitDto PrpDcustomerUnitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDcustomerUnitDto PrpDcustomerUnitDto) throws Exception{
        DBPrpDcustomerUnit dbPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);
        //插入记录
        dbPrpDcustomerUnit.insert(PrpDcustomerUnitDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param customerCode 客户代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String customerCode) throws Exception{
        DBPrpDcustomerUnit dbPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);
        //删除记录
        dbPrpDcustomerUnit.delete(customerCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcustomerUnit dbPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);
        //按条件删除记录
        dbPrpDcustomerUnit.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param PrpDcustomerUnitDto PrpDcustomerUnitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDcustomerUnitDto PrpDcustomerUnitDto) throws Exception{
        DBPrpDcustomerUnit dbPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);
        //更新记录
        dbPrpDcustomerUnit.update(PrpDcustomerUnitDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param customerCode 客户代码
     * @return PrpDcustomerUnitDto PrpDcustomerUnitDto
     * @throws Exception
     */
    public PrpDcustomerUnitDto findByPrimaryKey(DBManager dbManager,String customerCode) throws Exception{
        DBPrpDcustomerUnit dbPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);
        //声明DTO
        PrpDcustomerUnitDto PrpDcustomerUnitDto = null;
        //查询数据,赋值给DTO
        PrpDcustomerUnitDto = dbPrpDcustomerUnit.findByPrimaryKey(customerCode);
        return PrpDcustomerUnitDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含PrpDcustomerUnitDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDcustomerUnit dbPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDcustomerUnit.getCount(conditions);
        collection = dbPrpDcustomerUnit.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDcustomerUnit dbPrpDcustomerUnit = new DBPrpDcustomerUnit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcustomerUnit.getCount(conditions);
        return count;
    }
}
