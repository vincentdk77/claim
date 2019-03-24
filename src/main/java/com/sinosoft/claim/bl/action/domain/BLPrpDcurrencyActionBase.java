package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcurrencyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcurrency;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcurrency币别代码表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcurrencyActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcurrencyActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDcurrencyActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDcurrencyDto prpDcurrencyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDcurrencyDto prpDcurrencyDto) throws Exception{
        DBPrpDcurrency dbPrpDcurrency = new DBPrpDcurrency(dbManager);
        //插入记录
        dbPrpDcurrency.insert(prpDcurrencyDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param currencyCode 币别代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String currencyCode) throws Exception{
        DBPrpDcurrency dbPrpDcurrency = new DBPrpDcurrency(dbManager);
        //删除记录
        dbPrpDcurrency.delete(currencyCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcurrency dbPrpDcurrency = new DBPrpDcurrency(dbManager);
        //按条件删除记录
        dbPrpDcurrency.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDcurrencyDto prpDcurrencyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDcurrencyDto prpDcurrencyDto) throws Exception{
        DBPrpDcurrency dbPrpDcurrency = new DBPrpDcurrency(dbManager);
        //更新记录
        dbPrpDcurrency.update(prpDcurrencyDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param currencyCode 币别代码
     * @return prpDcurrencyDto prpDcurrencyDto
     * @throws Exception
     */
    public PrpDcurrencyDto findByPrimaryKey(DBManager dbManager,String currencyCode) throws Exception{
        DBPrpDcurrency dbPrpDcurrency = new DBPrpDcurrency(dbManager);
        //声明DTO
        PrpDcurrencyDto prpDcurrencyDto = null;
        //查询数据,赋值给DTO
        prpDcurrencyDto = dbPrpDcurrency.findByPrimaryKey(currencyCode);
        return prpDcurrencyDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDcurrencyDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDcurrency dbPrpDcurrency = new DBPrpDcurrency(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDcurrency.getCount(conditions);
        collection = dbPrpDcurrency.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDcurrency dbPrpDcurrency = new DBPrpDcurrency(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcurrency.getCount(conditions);
        return count;
    }
}
