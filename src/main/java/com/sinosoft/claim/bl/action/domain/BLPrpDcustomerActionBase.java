package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcustomerDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcustomer;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcustomer客户信息的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:46<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcustomerActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcustomerActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDcustomerActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDcustomerDto prpDcustomerDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDcustomerDto prpDcustomerDto) throws Exception{
        DBPrpDcustomer dbPrpDcustomer = new DBPrpDcustomer(dbManager);
        //插入记录
        dbPrpDcustomer.insert(prpDcustomerDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param customerCode 客户代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String customerCode) throws Exception{
        DBPrpDcustomer dbPrpDcustomer = new DBPrpDcustomer(dbManager);
        //删除记录
        dbPrpDcustomer.delete(customerCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcustomer dbPrpDcustomer = new DBPrpDcustomer(dbManager);
        //按条件删除记录
        dbPrpDcustomer.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDcustomerDto prpDcustomerDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDcustomerDto prpDcustomerDto) throws Exception{
        DBPrpDcustomer dbPrpDcustomer = new DBPrpDcustomer(dbManager);
        //更新记录
        dbPrpDcustomer.update(prpDcustomerDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param customerCode 客户代码
     * @return prpDcustomerDto prpDcustomerDto
     * @throws Exception
     */
    public PrpDcustomerDto findByPrimaryKey(DBManager dbManager,String customerCode) throws Exception{
        DBPrpDcustomer dbPrpDcustomer = new DBPrpDcustomer(dbManager);
        //声明DTO
        PrpDcustomerDto prpDcustomerDto = null;
        //查询数据,赋值给DTO
        prpDcustomerDto = dbPrpDcustomer.findByPrimaryKey(customerCode);
        return prpDcustomerDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDcustomerDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDcustomer dbPrpDcustomer = new DBPrpDcustomer(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDcustomer.getCount(conditions);
        collection = dbPrpDcustomer.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDcustomer dbPrpDcustomer = new DBPrpDcustomer(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcustomer.getCount(conditions);
        return count;
    }
}
