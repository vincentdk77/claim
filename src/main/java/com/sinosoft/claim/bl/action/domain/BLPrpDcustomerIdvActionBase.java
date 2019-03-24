package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcustomerIdvDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcustomerIdv;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcustomer_idv个人客户代码表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcustomerIdvActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcustomerIdvActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDcustomerIdvActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDcustomer_idvDto prpDcustomer_idvDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDcustomerIdvDto prpDcustomer_idvDto) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomer_idv = new DBPrpDcustomerIdv(dbManager);
        //插入记录
        dbPrpDcustomer_idv.insert(prpDcustomer_idvDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param customerCode 客户代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String customerCode) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomer_idv = new DBPrpDcustomerIdv(dbManager);
        //删除记录
        dbPrpDcustomer_idv.delete(customerCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomer_idv = new DBPrpDcustomerIdv(dbManager);
        //按条件删除记录
        dbPrpDcustomer_idv.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDcustomer_idvDto prpDcustomer_idvDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDcustomerIdvDto prpDcustomer_idvDto) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomer_idv = new DBPrpDcustomerIdv(dbManager);
        //更新记录
        dbPrpDcustomer_idv.update(prpDcustomer_idvDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param customerCode 客户代码
     * @return prpDcustomer_idvDto prpDcustomer_idvDto
     * @throws Exception
     */
    public PrpDcustomerIdvDto findByPrimaryKey(DBManager dbManager,String customerCode) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomer_idv = new DBPrpDcustomerIdv(dbManager);
        //声明DTO
        PrpDcustomerIdvDto prpDcustomer_idvDto = null;
        //查询数据,赋值给DTO
        prpDcustomer_idvDto = dbPrpDcustomer_idv.findByPrimaryKey(customerCode);
        return prpDcustomer_idvDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDcustomer_idvDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDcustomerIdv dbPrpDcustomer_idv = new DBPrpDcustomerIdv(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDcustomer_idv.getCount(conditions);
        collection = dbPrpDcustomer_idv.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDcustomerIdv dbPrpDcustomer_idv = new DBPrpDcustomerIdv(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcustomer_idv.getCount(conditions);
        return count;
    }
}
